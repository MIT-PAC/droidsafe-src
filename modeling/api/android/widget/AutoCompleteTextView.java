package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;

import com.android.internal.R;

public class AutoCompleteTextView extends EditText implements Filter.FilterListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:58.984 -0500", hash_original_field = "81DD852ECBE07BA98A61C8F3D0C85F01", hash_generated_field = "F09208C088E716A2CD36A97B937BB5EA")

    static final boolean DEBUG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:58.986 -0500", hash_original_field = "7366E80B7B2A92E12BC8826DA81EC79D", hash_generated_field = "747049ADD59E7427B505A8078EF2569B")

    static final String TAG = "AutoCompleteTextView";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:58.988 -0500", hash_original_field = "278B86F4E21489565DB89494073B789E", hash_generated_field = "50DC5A53A7642176DA288042E8938B92")

    static final int EXPAND_MAX = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:58.990 -0500", hash_original_field = "D9985579330390AE8290FE29DE0EF688", hash_generated_field = "1FDB4027FDC409C38C96D7C7129240A3")

    private CharSequence mHintText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:58.992 -0500", hash_original_field = "CA453DA8168AD73BA8AAAB4C1D94E39C", hash_generated_field = "3A9494D52ECD891CDD06D9FB033B0410")

    private TextView mHintView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:58.994 -0500", hash_original_field = "6946D6F10715FD4353B09EB56B52ED37", hash_generated_field = "83A803468B3B4450D753F58C9690FCF8")

    private int mHintResource;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:58.996 -0500", hash_original_field = "CBDD62EF585589E92C0E00AE9F4F22E2", hash_generated_field = "90F29768206AB431EA361CD94838716F")

    private ListAdapter mAdapter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:58.998 -0500", hash_original_field = "E9FBEB72F5336AFA25831B1B3CB2A4B4", hash_generated_field = "A13F7A33CB1B9B8C8BC52C7A25894515")

    private Filter mFilter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.001 -0500", hash_original_field = "13731C31E93ABBBB47CAEC955FCD759C", hash_generated_field = "2B2FC0AB3F9DED44C14A982417EA1993")

    private int mThreshold;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.004 -0500", hash_original_field = "4DA234AE6542EB8CE34753F7DEA560C5", hash_generated_field = "8997F2E1258B500A89588C7ED08EDAF2")

    private ListPopupWindow mPopup;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.006 -0500", hash_original_field = "2D95AAF1E2AEB6DBA83C660BDDE73F76", hash_generated_field = "AA79DCF4F4AF02E5E4FD88F114FC4A45")

    private int mDropDownAnchorId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.008 -0500", hash_original_field = "C3BCFE8177AEF338D4004A6DD4D2D8EF", hash_generated_field = "91F251C39E992AB6E9A1F97E1DB2D65A")

    private AdapterView.OnItemClickListener mItemClickListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.010 -0500", hash_original_field = "95D49B221C26B1A3334D3BD6A6E6E61A", hash_generated_field = "B20A14E839638431419A27C6FA2EB183")

    private AdapterView.OnItemSelectedListener mItemSelectedListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.012 -0500", hash_original_field = "F3626448EBBBD7C8DF8388361FA4C097", hash_generated_field = "F2A9684F0F8098ECC6D91A395F94C973")

    private boolean mDropDownDismissedOnCompletion = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.014 -0500", hash_original_field = "42F0BE50EE4EAA127551894E1C861A8F", hash_generated_field = "202A96DE332795BB4B1FEBF0146D898F")

    private int mLastKeyCode = KeyEvent.KEYCODE_UNKNOWN;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.016 -0500", hash_original_field = "8EC18D8C56BE58C3AEB1159EBA595EC9", hash_generated_field = "DF21E3DF0E1F480F88152014C172C190")

    private boolean mOpenBefore;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.018 -0500", hash_original_field = "0E68BF28727A92D3ED40E3FAF1710C9D", hash_generated_field = "174452E4EA6CBBEFAC61139138443140")

    private Validator mValidator = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.020 -0500", hash_original_field = "6D60824235355A8B322627882F3A5E35", hash_generated_field = "F75A9D78378413BAF88541599A31BF41")

    private boolean mBlockCompletion;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.022 -0500", hash_original_field = "B19B6345438F97FA7F665572D52EE922", hash_generated_field = "F2AAA1757CC6C7A55ED4750947F6FFD1")

    // Set to false when the list is hidden to prevent asynchronous updates to popup the list again.
    private boolean mPopupCanBeUpdated = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.024 -0500", hash_original_field = "7D303B16C326C90EA8482AA23C590B95", hash_generated_field = "EBF3BC0102B69BA2B0B114608A6AF073")

    private PassThroughClickListener mPassThroughClickListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.027 -0500", hash_original_field = "CE1C8FF88DD224C2604D8448F5044A3A", hash_generated_field = "0623EBBCEF1FE0FD7F127A32EDBCAFCC")

    private PopupDataSetObserver mObserver;

    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.029 -0500", hash_original_method = "25FDD5DBEC32252B7FC5EA7A3C1328DA", hash_generated_method = "0C7B7D22F248FE6109823F4B0F4CAAE9")
    
public AutoCompleteTextView(Context context) {
        this(context, null);
    }

    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.032 -0500", hash_original_method = "37425D654E09169E65BAA252CC2C351E", hash_generated_method = "E4179262A4C131B20A93FB94930A339C")
    
public AutoCompleteTextView(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.autoCompleteTextViewStyle);
    }

    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.036 -0500", hash_original_method = "E7A1365EE4283D79F23C38EBF5E5D299", hash_generated_method = "89FD964B0ABCB7421FE995ED0157B557")
    
public AutoCompleteTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        mPopup = new ListPopupWindow(context, attrs,
                com.android.internal.R.attr.autoCompleteTextViewStyle);
        mPopup.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        mPopup.setPromptPosition(ListPopupWindow.POSITION_PROMPT_BELOW);

        TypedArray a =
            context.obtainStyledAttributes(
                attrs, com.android.internal.R.styleable.AutoCompleteTextView, defStyle, 0);

        mThreshold = a.getInt(
                R.styleable.AutoCompleteTextView_completionThreshold, 2);

        mPopup.setListSelector(a.getDrawable(R.styleable.AutoCompleteTextView_dropDownSelector));
        mPopup.setVerticalOffset((int)
                a.getDimension(R.styleable.AutoCompleteTextView_dropDownVerticalOffset, 0.0f));
        mPopup.setHorizontalOffset((int)
                a.getDimension(R.styleable.AutoCompleteTextView_dropDownHorizontalOffset, 0.0f));
        
        // Get the anchor's id now, but the view won't be ready, so wait to actually get the
        // view and store it in mDropDownAnchorView lazily in getDropDownAnchorView later.
        // Defaults to NO_ID, in which case the getDropDownAnchorView method will simply return
        // this TextView, as a default anchoring point.
        mDropDownAnchorId = a.getResourceId(R.styleable.AutoCompleteTextView_dropDownAnchor,
                View.NO_ID);
        
        // For dropdown width, the developer can specify a specific width, or MATCH_PARENT
        // (for full screen width) or WRAP_CONTENT (to match the width of the anchored view).
        mPopup.setWidth(a.getLayoutDimension(
                R.styleable.AutoCompleteTextView_dropDownWidth,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        mPopup.setHeight(a.getLayoutDimension(
                R.styleable.AutoCompleteTextView_dropDownHeight,
                ViewGroup.LayoutParams.WRAP_CONTENT));

        mHintResource = a.getResourceId(R.styleable.AutoCompleteTextView_completionHintView,
                R.layout.simple_dropdown_hint);
        
        mPopup.setOnItemClickListener(new DropDownItemClickListener());
        setCompletionHint(a.getText(R.styleable.AutoCompleteTextView_completionHint));

        // Always turn on the auto complete input type flag, since it
        // makes no sense to use this widget without it.
        int inputType = getInputType();
        if ((inputType&EditorInfo.TYPE_MASK_CLASS)
                == EditorInfo.TYPE_CLASS_TEXT) {
            inputType |= EditorInfo.TYPE_TEXT_FLAG_AUTO_COMPLETE;
            setRawInputType(inputType);
        }

        a.recycle();

        setFocusable(true);

        addTextChangedListener(new MyWatcher());
        
        mPassThroughClickListener = new PassThroughClickListener();
        super.setOnClickListener(mPassThroughClickListener);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.038 -0500", hash_original_method = "C1942F3D6CF625065E36951B3C995636", hash_generated_method = "B20AF43F2EEAFF7AD7EDC0F3F3D5C991")
    
@Override
    public void setOnClickListener(OnClickListener listener) {
        mPassThroughClickListener.mWrapped = listener;
        listener.onClick(this);
    }

    /**
     * Private hook into the on click event, dispatched from {@link PassThroughClickListener}
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.040 -0500", hash_original_method = "58D3202231E1A3AE7FD8546C3F8B5C86", hash_generated_method = "6F252D3DBAB2D3637BFAC9BE2CE05524")
    
private void onClickImpl() {
        // If the dropdown is showing, bring the keyboard to the front
        // when the user touches the text field.
        if (isPopupShowing()) {
            ensureImeVisible(true);
        }
    }

    /**
     * <p>Sets the optional hint text that is displayed at the bottom of the
     * the matching list.  This can be used as a cue to the user on how to
     * best use the list, or to provide extra information.</p>
     *
     * @param hint the text to be displayed to the user
     *
     * @attr ref android.R.styleable#AutoCompleteTextView_completionHint
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.042 -0500", hash_original_method = "4F48038C1162C78CAFD13A15CFC4C4E3", hash_generated_method = "DFD3B8635EA96918AD36F7B36578A81C")
    
public void setCompletionHint(CharSequence hint) {
        mHintText = hint;
        if (hint != null) {
            if (mHintView == null) {
                final TextView hintView = (TextView) LayoutInflater.from(getContext()).inflate(
                        mHintResource, null).findViewById(com.android.internal.R.id.text1);
                hintView.setText(mHintText);
                mHintView = hintView;
                mPopup.setPromptView(hintView);
            } else {
                mHintView.setText(hint);
            }
        } else {
            mPopup.setPromptView(null);
            mHintView = null;
        }
    }
    
    /**
     * <p>Returns the current width for the auto-complete drop down list. This can
     * be a fixed width, or {@link ViewGroup.LayoutParams#MATCH_PARENT} to fill the screen, or
     * {@link ViewGroup.LayoutParams#WRAP_CONTENT} to fit the width of its anchor view.</p>
     * 
     * @return the width for the drop down list
     * 
     * @attr ref android.R.styleable#AutoCompleteTextView_dropDownWidth
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.044 -0500", hash_original_method = "0FF617112E6940852CA340238B035B28", hash_generated_method = "247259A32CDB55B911557833DCE6FDAC")
    
public int getDropDownWidth() {
        return mPopup.getWidth();
    }
    
    /**
     * <p>Sets the current width for the auto-complete drop down list. This can
     * be a fixed width, or {@link ViewGroup.LayoutParams#MATCH_PARENT} to fill the screen, or
     * {@link ViewGroup.LayoutParams#WRAP_CONTENT} to fit the width of its anchor view.</p>
     * 
     * @param width the width to use
     * 
     * @attr ref android.R.styleable#AutoCompleteTextView_dropDownWidth
     */
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.047 -0500", hash_original_method = "B270189DDD36B930B898EDE5BD590C69", hash_generated_method = "E55EDD4E31E177747521386D45E056CD")
    
public void setDropDownWidth(int width) {
        mPopup.setWidth(width);
    }

    /**
     * <p>Returns the current height for the auto-complete drop down list. This can
     * be a fixed height, or {@link ViewGroup.LayoutParams#MATCH_PARENT} to fill
     * the screen, or {@link ViewGroup.LayoutParams#WRAP_CONTENT} to fit the height
     * of the drop down's content.</p>
     *
     * @return the height for the drop down list
     *
     * @attr ref android.R.styleable#AutoCompleteTextView_dropDownHeight
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.049 -0500", hash_original_method = "ED81905DF1626AD5BC656BEBB27BE880", hash_generated_method = "2A536E1053D7425939D8951FC2FDBAD3")
    
public int getDropDownHeight() {
        return mPopup.getHeight();
    }

    /**
     * <p>Sets the current height for the auto-complete drop down list. This can
     * be a fixed height, or {@link ViewGroup.LayoutParams#MATCH_PARENT} to fill
     * the screen, or {@link ViewGroup.LayoutParams#WRAP_CONTENT} to fit the height
     * of the drop down's content.</p>
     *
     * @param height the height to use
     *
     * @attr ref android.R.styleable#AutoCompleteTextView_dropDownHeight
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.051 -0500", hash_original_method = "7CEF092BABE0725B932F9B439F9A3AFD", hash_generated_method = "856B2F95F412E5E4A940FCE97E3D1A9C")
    
public void setDropDownHeight(int height) {
        mPopup.setHeight(height);
    }
    
    /**
     * <p>Returns the id for the view that the auto-complete drop down list is anchored to.</p>
     *  
     * @return the view's id, or {@link View#NO_ID} if none specified
     * 
     * @attr ref android.R.styleable#AutoCompleteTextView_dropDownAnchor
     */
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.053 -0500", hash_original_method = "983C379A49D6519E05BB04A2322E89F2", hash_generated_method = "47B37E22C0C8134B5DD2F1C2D09AD204")
    
public int getDropDownAnchor() {
        return mDropDownAnchorId;
    }
    
    /**
     * <p>Sets the view to which the auto-complete drop down list should anchor. The view
     * corresponding to this id will not be loaded until the next time it is needed to avoid
     * loading a view which is not yet instantiated.</p>
     * 
     * @param id the id to anchor the drop down list view to
     * 
     * @attr ref android.R.styleable#AutoCompleteTextView_dropDownAnchor 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.055 -0500", hash_original_method = "5971179F1F300FE7DC24F52751CD203A", hash_generated_method = "B9B3B579AC7F5D7459E24CEA1627FCF0")
    
public void setDropDownAnchor(int id) {
        mDropDownAnchorId = id;
        mPopup.setAnchorView(null);
    }
    
    /**
     * <p>Gets the background of the auto-complete drop-down list.</p>
     * 
     * @return the background drawable
     * 
     * @attr ref android.R.styleable#PopupWindow_popupBackground
     */
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.058 -0500", hash_original_method = "AF968841F9ADA345DD97E068FA7BD610", hash_generated_method = "B9F5A4E86C16A1269D847E12A60592B2")
    
public Drawable getDropDownBackground() {
        return mPopup.getBackground();
    }
    
    /**
     * <p>Sets the background of the auto-complete drop-down list.</p>
     * 
     * @param d the drawable to set as the background
     * 
     * @attr ref android.R.styleable#PopupWindow_popupBackground
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.060 -0500", hash_original_method = "B18D529A578176AD889BDFBA197D2FE9", hash_generated_method = "72828885475402233A1065AA4238F0B0")
    
public void setDropDownBackgroundDrawable(Drawable d) {
        mPopup.setBackgroundDrawable(d);
    }
    
    /**
     * <p>Sets the background of the auto-complete drop-down list.</p>
     * 
     * @param id the id of the drawable to set as the background
     * 
     * @attr ref android.R.styleable#PopupWindow_popupBackground
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.062 -0500", hash_original_method = "58B212667945303F92E76684E6DBBAC3", hash_generated_method = "5C1C1861F58F15C596D520ED54C07A96")
    
public void setDropDownBackgroundResource(int id) {
        mPopup.setBackgroundDrawable(getResources().getDrawable(id));
    }
    
    /**
     * <p>Sets the vertical offset used for the auto-complete drop-down list.</p>
     * 
     * @param offset the vertical offset
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.064 -0500", hash_original_method = "AFE41A06E9A754A352572FB9B075CCA0", hash_generated_method = "F998023443B69F9CACF43A7FE224C147")
    
public void setDropDownVerticalOffset(int offset) {
        mPopup.setVerticalOffset(offset);
    }
    
    /**
     * <p>Gets the vertical offset used for the auto-complete drop-down list.</p>
     * 
     * @return the vertical offset
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.067 -0500", hash_original_method = "CD8747B9F2476A0A6006DC41A664E503", hash_generated_method = "DE383788E4FDCB2B215C3C806573CB68")
    
public int getDropDownVerticalOffset() {
        return mPopup.getVerticalOffset();
    }
    
    /**
     * <p>Sets the horizontal offset used for the auto-complete drop-down list.</p>
     * 
     * @param offset the horizontal offset
     */
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.069 -0500", hash_original_method = "6A22527360686DE12C48E20144984DC3", hash_generated_method = "7D53B2885E28A76B6CAEC543641AFBEC")
    
public void setDropDownHorizontalOffset(int offset) {
        mPopup.setHorizontalOffset(offset);
    }
    
    /**
     * <p>Gets the horizontal offset used for the auto-complete drop-down list.</p>
     * 
     * @return the horizontal offset
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.071 -0500", hash_original_method = "A7584484859282D74A751422BD935CE2", hash_generated_method = "7E8C8CA6329EF47BA0A3EA2027EC0765")
    
public int getDropDownHorizontalOffset() {
        return mPopup.getHorizontalOffset();
    }

     /**
     * <p>Sets the animation style of the auto-complete drop-down list.</p>
     *
     * <p>If the drop-down is showing, calling this method will take effect only
     * the next time the drop-down is shown.</p>
     *
     * @param animationStyle animation style to use when the drop-down appears
     *      and disappears.  Set to -1 for the default animation, 0 for no
     *      animation, or a resource identifier for an explicit animation.
     *
     * @hide Pending API council approval
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.073 -0500", hash_original_method = "AB6AF7AB4438F2936FAB5E115855ABD1", hash_generated_method = "2C41EAEA804D3D5F5683493CD2859ABC")
    
public void setDropDownAnimationStyle(int animationStyle) {
        mPopup.setAnimationStyle(animationStyle);
    }

    /**
     * <p>Returns the animation style that is used when the drop-down list appears and disappears
     * </p>
     *
     * @return the animation style that is used when the drop-down list appears and disappears
     *
     * @hide Pending API council approval
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.075 -0500", hash_original_method = "348942C9B29D455789FBCF016CC929C3", hash_generated_method = "3EE54AD2789BC1F54D5F2D236311658A")
    
public int getDropDownAnimationStyle() {
        return mPopup.getAnimationStyle();
    }

    /**
     * @return Whether the drop-down is visible as long as there is {@link #enoughToFilter()}
     *
     * @hide Pending API council approval
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.077 -0500", hash_original_method = "4343F66DAC432AAC8F4BD77081597537", hash_generated_method = "A227F4A190BDF36D01C8A6F1B1422AE2")
    
public boolean isDropDownAlwaysVisible() {
        return mPopup.isDropDownAlwaysVisible();
    }

    /**
     * Sets whether the drop-down should remain visible as long as there is there is
     * {@link #enoughToFilter()}.  This is useful if an unknown number of results are expected
     * to show up in the adapter sometime in the future.
     *
     * The drop-down will occupy the entire screen below {@link #getDropDownAnchor} regardless
     * of the size or content of the list.  {@link #getDropDownBackground()} will fill any space
     * that is not used by the list.
     *
     * @param dropDownAlwaysVisible Whether to keep the drop-down visible.
     *
     * @hide Pending API council approval
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.079 -0500", hash_original_method = "9D048710298E272B53CC3CA9B767E12A", hash_generated_method = "1BA9B13157BB69F6E30D4DF2BAB035EC")
    
public void setDropDownAlwaysVisible(boolean dropDownAlwaysVisible) {
        mPopup.setDropDownAlwaysVisible(dropDownAlwaysVisible);
    }
   
    /**
     * Checks whether the drop-down is dismissed when a suggestion is clicked.
     * 
     * @hide Pending API council approval
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.081 -0500", hash_original_method = "5251E63145860B08CE1AA76BBDDDD070", hash_generated_method = "1255D0258B08D02BDD7780B2F8C3206B")
    
public boolean isDropDownDismissedOnCompletion() {
        return mDropDownDismissedOnCompletion;
    }

    /**
     * Sets whether the drop-down is dismissed when a suggestion is clicked. This is 
     * true by default.
     * 
     * @param dropDownDismissedOnCompletion Whether to dismiss the drop-down.
     * 
     * @hide Pending API council approval
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.083 -0500", hash_original_method = "87D4B20D86EF98CE5F9B2DCFB12777AB", hash_generated_method = "34C971D40FCB01BBC19F0C8CA8E642F7")
    
public void setDropDownDismissedOnCompletion(boolean dropDownDismissedOnCompletion) {
        mDropDownDismissedOnCompletion = dropDownDismissedOnCompletion;
    }
 
    /**
     * <p>Returns the number of characters the user must type before the drop
     * down list is shown.</p>
     *
     * @return the minimum number of characters to type to show the drop down
     *
     * @see #setThreshold(int)
     */
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.085 -0500", hash_original_method = "D355B3B251BB91FAED293791929579AC", hash_generated_method = "3394DC2838DC305525F1033F25137CAE")
    
public int getThreshold() {
        return mThreshold;
    }

    /**
     * <p>Specifies the minimum number of characters the user has to type in the
     * edit box before the drop down list is shown.</p>
     *
     * <p>When <code>threshold</code> is less than or equals 0, a threshold of
     * 1 is applied.</p>
     *
     * @param threshold the number of characters to type before the drop down
     *                  is shown
     *
     * @see #getThreshold()
     *
     * @attr ref android.R.styleable#AutoCompleteTextView_completionThreshold
     */
    @DSComment("Autocomplete")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.087 -0500", hash_original_method = "E80EC39EC531963E159919926C4979B9", hash_generated_method = "19334D7DFA7EE4A6663FB4F88E3C4D9D")
    
public void setThreshold(int threshold) {
        if (threshold <= 0) {
            threshold = 1;
        }

        mThreshold = threshold;
    }

    /**
     * <p>Sets the listener that will be notified when the user clicks an item
     * in the drop down list.</p>
     *
     * @param l the item click listener
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.090 -0500", hash_original_method = "B69DF6D8B348285F7F509DAAD23C3372", hash_generated_method = "7842F66D843EA6654D84B924FD053A47")
    @DSVerified
    @DSSafe(DSCat.ANDROID_CALLBACK)
public void setOnItemClickListener(AdapterView.OnItemClickListener l) {
        mItemClickListener = l;
        if (l != null) {
            AdapterView<?> a = (AdapterView<?>)getRootView();
            //TODO: to figure out proper AdapterView to pass in here
            l.onItemClick(a, this, DSUtils.FAKE_INT, DSUtils.FAKE_INT);
        }
    }

    /**
     * <p>Sets the listener that will be notified when the user selects an item
     * in the drop down list.</p>
     *
     * @param l the item selected listener
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.092 -0500", hash_original_method = "48F24F393448111E92CC5CFF766C1584", hash_generated_method = "A61D054416CB4681E7ED1D9CB20ED173")
    @DSVerified
    @DSSafe(DSCat.SAFE_LIST)   
public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener l) {
        mItemSelectedListener = l;
        if (l != null) {
           View v = this.getRootView(); 
           AdapterView<?> av = (AdapterView<?>)v;
            l.onItemSelected(av, new View(DSOnlyType.NOT_USED), DSUtils.FAKE_INT,
                    (long)DSUtils.FAKE_INT);
            l.onNothingSelected(av);
        }
    }

    /**
     * <p>Returns the listener that is notified whenever the user clicks an item
     * in the drop down list.</p>
     *
     * @return the item click listener
     *
     * @deprecated Use {@link #getOnItemClickListener()} intead
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.095 -0500", hash_original_method = "0AE6D510B9C16F8D52FF49376A7BF6A4", hash_generated_method = "F8BA54642F9AFE601558F4AEC7F8B6F3")
    
@Deprecated
    public AdapterView.OnItemClickListener getItemClickListener() {
        return mItemClickListener;
    }

    /**
     * <p>Returns the listener that is notified whenever the user selects an
     * item in the drop down list.</p>
     *
     * @return the item selected listener
     *
     * @deprecated Use {@link #getOnItemSelectedListener()} intead
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.097 -0500", hash_original_method = "2A86C7E057A0C403AB649B0ED567456D", hash_generated_method = "A4990F39B6044048EE36D632B4B7E566")
    
@Deprecated
    public AdapterView.OnItemSelectedListener getItemSelectedListener() {
        return mItemSelectedListener;
    }

    /**
     * <p>Returns the listener that is notified whenever the user clicks an item
     * in the drop down list.</p>
     *
     * @return the item click listener
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.099 -0500", hash_original_method = "CC34C836A582B2E0B6660928CDDA2E79", hash_generated_method = "B54B49B09CBFF91292FCD4F35A88BDD0")
    
public AdapterView.OnItemClickListener getOnItemClickListener() {
        return mItemClickListener;
    }

    /**
     * <p>Returns the listener that is notified whenever the user selects an
     * item in the drop down list.</p>
     *
     * @return the item selected listener
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.101 -0500", hash_original_method = "CA4C95C3D87D9F2B4999807B4A5E6086", hash_generated_method = "DA5949D4A2D1566DF4926875184937CD")
    
public AdapterView.OnItemSelectedListener getOnItemSelectedListener() {
        return mItemSelectedListener;
    }

    /**
     * <p>Returns a filterable list adapter used for auto completion.</p>
     *
     * @return a data adapter used for auto completion
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.103 -0500", hash_original_method = "0E1A05724C497F45D7FB6AC34C501814", hash_generated_method = "A4011003FD32FA617AD815FC289B0759")
    
public ListAdapter getAdapter() {
        return mAdapter;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.696 -0400", hash_original_method = "18CB1EEAAEFB5BC2DC3ECE426EBE9928", hash_generated_method = "F0E69E1084FD7B774906C79EDAFD6B58")

    @DSSafe(DSCat.GUI)
    public <T extends ListAdapter & Filterable> void setAdapter(T adapter) {
        if(mObserver == null)        
        {
            mObserver = new PopupDataSetObserver();
        } //End block
        else
        if(mAdapter != null)        
        {
            mAdapter.unregisterDataSetObserver(mObserver);
        } //End block
        mAdapter = adapter;
        if(mAdapter != null)        
        {
            mFilter = ((Filterable) mAdapter).getFilter();
            adapter.registerDataSetObserver(mObserver);
        } //End block
        else
        {
            mFilter = null;
        } //End block
        mPopup.setAdapter(mAdapter);
        // ---------- Original Method ----------
        //if (mObserver == null) {
            //mObserver = new PopupDataSetObserver();
        //} else if (mAdapter != null) {
            //mAdapter.unregisterDataSetObserver(mObserver);
        //}
        //mAdapter = adapter;
        //if (mAdapter != null) {
            //mFilter = ((Filterable) mAdapter).getFilter();
            //adapter.registerDataSetObserver(mObserver);
        //} else {
            //mFilter = null;
        //}
        //mPopup.setAdapter(mAdapter);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.108 -0500", hash_original_method = "1E2534A3F57B1DBFCDE49E1B48E26A0E", hash_generated_method = "991226CDAFEA77A8960DE06ED6E79A37")
    
@Override
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && isPopupShowing()
                && !mPopup.isDropDownAlwaysVisible()) {
            // special case for the back key, we do not even try to send it
            // to the drop down list but instead, consume it immediately
            if (event.getAction() == KeyEvent.ACTION_DOWN && event.getRepeatCount() == 0) {
                KeyEvent.DispatcherState state = getKeyDispatcherState();
                if (state != null) {
                    state.startTracking(event, this);
                }
                return true;
            } else if (event.getAction() == KeyEvent.ACTION_UP) {
                KeyEvent.DispatcherState state = getKeyDispatcherState();
                if (state != null) {
                    state.handleUpEvent(event);
                }
                if (event.isTracking() && !event.isCanceled()) {
                    dismissDropDown();
                    return true;
                }
            }
        }
        return super.onKeyPreIme(keyCode, event);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.111 -0500", hash_original_method = "A5021B9859EF1208F776ED0647DC53F8", hash_generated_method = "7417C25EED3F33894D22D68A9CD56A4C")
    
@Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        boolean consumed = mPopup.onKeyUp(keyCode, event);
        if (consumed) {
            switch (keyCode) {
            // if the list accepts the key events and the key event
            // was a click, the text view gets the selected item
            // from the drop down as its content
            case KeyEvent.KEYCODE_ENTER:
            case KeyEvent.KEYCODE_DPAD_CENTER:
            case KeyEvent.KEYCODE_TAB:
                if (event.hasNoModifiers()) {
                    performCompletion();
                }
                return true;
            }
        }

        if (isPopupShowing() && keyCode == KeyEvent.KEYCODE_TAB && event.hasNoModifiers()) {
            performCompletion();
            return true;
        }

        return super.onKeyUp(keyCode, event);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.114 -0500", hash_original_method = "7D38CCD4A21A1817640875450034C5D6", hash_generated_method = "3D42DF2AB1DA1416CB0D82F2DB53286F")
    
@Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (mPopup.onKeyDown(keyCode, event)) {
            return true;
        }
        
        if (!isPopupShowing()) {
            switch(keyCode) {
            case KeyEvent.KEYCODE_DPAD_DOWN:
                if (event.hasNoModifiers()) {
                    performValidation();
                }
            }
        }

        if (isPopupShowing() && keyCode == KeyEvent.KEYCODE_TAB && event.hasNoModifiers()) {
            return true;
        }

        mLastKeyCode = keyCode;
        boolean handled = super.onKeyDown(keyCode, event);
        mLastKeyCode = KeyEvent.KEYCODE_UNKNOWN;

        if (handled && isPopupShowing()) {
            clearListSelection();
        }

        return handled;
    }

    /**
     * Returns <code>true</code> if the amount of text in the field meets
     * or exceeds the {@link #getThreshold} requirement.  You can override
     * this to impose a different standard for when filtering will be
     * triggered.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.116 -0500", hash_original_method = "845425AE754C4142506C6C975210339B", hash_generated_method = "37F16E8131F3F6A5190F950D6D13D8DC")
    
public boolean enoughToFilter() {
        if (DEBUG) Log.v(TAG, "Enough to filter: len=" + getText().length()
                + " threshold=" + mThreshold);
        return getText().length() >= mThreshold;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.127 -0500", hash_original_method = "9B68F895919D747E86E2BC0B861C3485", hash_generated_method = "447E457E156E84BB9A7E023E62CF8230")
    
void doBeforeTextChanged() {
        if (mBlockCompletion) return;

        // when text is changed, inserted or deleted, we attempt to show
        // the drop down
        mOpenBefore = isPopupShowing();
        if (DEBUG) Log.v(TAG, "before text changed: open=" + mOpenBefore);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.129 -0500", hash_original_method = "EABD50974341527CEC5D7DC0490BCDC7", hash_generated_method = "5B0369A85B089A34506DC99A71F6CCC5")
    
void doAfterTextChanged() {
        if (mBlockCompletion) return;

        // if the list was open before the keystroke, but closed afterwards,
        // then something in the keystroke processing (an input filter perhaps)
        // called performCompletion() and we shouldn't do any more processing.
        if (DEBUG) Log.v(TAG, "after text changed: openBefore=" + mOpenBefore
                + " open=" + isPopupShowing());
        if (mOpenBefore && !isPopupShowing()) {
            return;
        }

        // the drop down is shown only when a minimum number of characters
        // was typed in the text view
        if (enoughToFilter()) {
            if (mFilter != null) {
                mPopupCanBeUpdated = true;
                performFiltering(getText(), mLastKeyCode);
            }
        } else {
            // drop down is automatically dismissed when enough characters
            // are deleted from the text view
            if (!mPopup.isDropDownAlwaysVisible()) {
                dismissDropDown();
            }
            if (mFilter != null) {
                mFilter.filter(null);
            }
        }
    }

    /**
     * <p>Indicates whether the popup menu is showing.</p>
     *
     * @return true if the popup menu is showing, false otherwise
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.131 -0500", hash_original_method = "82AB47D081F83CBFD677A62933F7FE17", hash_generated_method = "B07C2907453F667B21F350D9D3606E25")
    
public boolean isPopupShowing() {
        return mPopup.isShowing();
    }

    /**
     * <p>Converts the selected item from the drop down list into a sequence
     * of character that can be used in the edit box.</p>
     *
     * @param selectedItem the item selected by the user for completion
     *
     * @return a sequence of characters representing the selected suggestion
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.133 -0500", hash_original_method = "5BE18D1BCEE667E3D32BBF42EAB5125A", hash_generated_method = "28C6DFB4255A71700E4B504C2060D8D3")
    
protected CharSequence convertSelectionToString(Object selectedItem) {
        return mFilter.convertResultToString(selectedItem);
    }
    
    /**
     * <p>Clear the list selection.  This may only be temporary, as user input will often bring 
     * it back.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.136 -0500", hash_original_method = "7623D1558693BF470F22C595BECC6733", hash_generated_method = "A3F0AA39F28FDC2E34EBEF922A4A3535")
    
public void clearListSelection() {
        mPopup.clearListSelection();
    }
    
    /**
     * Set the position of the dropdown view selection.
     * 
     * @param position The position to move the selector to.
     */
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.138 -0500", hash_original_method = "133DE5DB01039801737429C3DDB0411B", hash_generated_method = "511115DE2EE242D3198E20B99BBA03EF")
    
public void setListSelection(int position) {
        mPopup.setSelection(position);
    }

    /**
     * Get the position of the dropdown view selection, if there is one.  Returns 
     * {@link ListView#INVALID_POSITION ListView.INVALID_POSITION} if there is no dropdown or if
     * there is no selection.
     * 
     * @return the position of the current selection, if there is one, or 
     * {@link ListView#INVALID_POSITION ListView.INVALID_POSITION} if not.
     * 
     * @see ListView#getSelectedItemPosition()
     */
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.140 -0500", hash_original_method = "FACA63936D6E82D9A31B7F667F19A5C4", hash_generated_method = "494BAF6C10428ED1B29905126FB73382")
    
public int getListSelection() {
        return mPopup.getSelectedItemPosition();
    }

    /**
     * <p>Starts filtering the content of the drop down list. The filtering
     * pattern is the content of the edit box. Subclasses should override this
     * method to filter with a different pattern, for instance a substring of
     * <code>text</code>.</p>
     *
     * @param text the filtering pattern
     * @param keyCode the last character inserted in the edit box; beware that
     * this will be null when text is being added through a soft input method.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.142 -0500", hash_original_method = "6D2AAF11ECF28F40F16EC0FF58DB7391", hash_generated_method = "F01C3D2D9E6D426E485849DDF6897F91")
    
@SuppressWarnings({ "UnusedDeclaration" })
    protected void performFiltering(CharSequence text, int keyCode) {
        mFilter.filter(text, this);
    }

    /**
     * <p>Performs the text completion by converting the selected item from
     * the drop down list into a string, replacing the text box's content with
     * this string and finally dismissing the drop down menu.</p>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.145 -0500", hash_original_method = "F704ACEA98F83F3E1219E92B20BE03DA", hash_generated_method = "4FC39A6566B5E257130A579910332F94")
    
public void performCompletion() {
        performCompletion(null, -1, -1);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.147 -0500", hash_original_method = "4C402F357E20A5DEEC78C01A554F2E74", hash_generated_method = "AAEE5FBA5E30CB675A68D36EB2E22393")
    
@Override
    public void onCommitCompletion(CompletionInfo completion) {
        if (isPopupShowing()) {
            mPopup.performItemClick(completion.getPosition());
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.150 -0500", hash_original_method = "87F4A447D592D0FFBC34508A48276E40", hash_generated_method = "F11A9C1BE770F3E11C26092FE52EC6BC")
    
private void performCompletion(View selectedView, int position, long id) {
        if (isPopupShowing()) {
            Object selectedItem;
            if (position < 0) {
                selectedItem = mPopup.getSelectedItem();
            } else {
                selectedItem = mAdapter.getItem(position);
            }
            if (selectedItem == null) {
                Log.w(TAG, "performCompletion: no selected item");
                return;
            }

            mBlockCompletion = true;
            replaceText(convertSelectionToString(selectedItem));
            mBlockCompletion = false;

            if (mItemClickListener != null) {
                final ListPopupWindow list = mPopup;

                if (selectedView == null || position < 0) {
                    selectedView = list.getSelectedView();
                    position = list.getSelectedItemPosition();
                    id = list.getSelectedItemId();
                }
                mItemClickListener.onItemClick(list.getListView(), selectedView, position, id);
            }
        }

        if (mDropDownDismissedOnCompletion && !mPopup.isDropDownAlwaysVisible()) {
            dismissDropDown();
        }
    }
    
    /**
     * Identifies whether the view is currently performing a text completion, so subclasses
     * can decide whether to respond to text changed events.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.153 -0500", hash_original_method = "01D38330C874C1244C7D1EF978D11C36", hash_generated_method = "225CC47C010306C0FBC3AC11A3A0EF30")
    
public boolean isPerformingCompletion() {
        return mBlockCompletion;
    }

    /**
     * Like {@link #setText(CharSequence)}, except that it can disable filtering.
     *
     * @param filter If <code>false</code>, no filtering will be performed
     *        as a result of this call.
     * 
     * @hide Pending API council approval.
     */
    @DSComment("Autocomplete")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.155 -0500", hash_original_method = "3F95D8A8308B140C895762391C3A32C6", hash_generated_method = "24DAE7F22FFD61C7AE872D912B41AF03")
    
public void setText(CharSequence text, boolean filter) {
        if (filter) {
            setText(text);
        } else {
            mBlockCompletion = true;
            setText(text);
            mBlockCompletion = false;
        }
    }

    /**
     * <p>Performs the text completion by replacing the current text by the
     * selected item. Subclasses should override this method to avoid replacing
     * the whole content of the edit box.</p>
     *
     * @param text the selected suggestion in the drop down list
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.157 -0500", hash_original_method = "BFA04BF25DCE9275294E0FA186DED6C8", hash_generated_method = "55EAA920F5E3AFF330E3ED8B31F4ECEF")
    
protected void replaceText(CharSequence text) {
        clearComposingText();

        setText(text);
        // make sure we keep the caret at the end of the text view
        Editable spannable = getText();
        Selection.setSelection(spannable, spannable.length());
    }

    /** {@inheritDoc} */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.159 -0500", hash_original_method = "65C6B6A3B92536D4DF6F13E8CB596A16", hash_generated_method = "0AD8666114C214A9E490E22D67D4D90F")
    
public void onFilterComplete(int count) {
        updateDropDownForFilter(count);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.162 -0500", hash_original_method = "43BA40231E8A8ECAF857BC9AE8C4397B", hash_generated_method = "A08E860AE04FB4ABA8989C5F4BDB74BA")
    
private void updateDropDownForFilter(int count) {
        // Not attached to window, don't update drop-down
        if (getWindowVisibility() == View.GONE) return;

        /*
         * This checks enoughToFilter() again because filtering requests
         * are asynchronous, so the result may come back after enough text
         * has since been deleted to make it no longer appropriate
         * to filter.
         */

        final boolean dropDownAlwaysVisible = mPopup.isDropDownAlwaysVisible();
        final boolean enoughToFilter = enoughToFilter();
        if ((count > 0 || dropDownAlwaysVisible) && enoughToFilter) {
            if (hasFocus() && hasWindowFocus() && mPopupCanBeUpdated) {
                showDropDown();
            }
        } else if (!dropDownAlwaysVisible && isPopupShowing()) {
            dismissDropDown();
            // When the filter text is changed, the first update from the adapter may show an empty
            // count (when the query is being performed on the network). Future updates when some
            // content has been retrieved should still be able to update the list.
            mPopupCanBeUpdated = true;
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.164 -0500", hash_original_method = "2BBFCFB03CA88D4E4428D247CF9B4D7A", hash_generated_method = "58AD942C8C862DEDE86F6EC904E535BF")
    
@Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        if (!hasWindowFocus && !mPopup.isDropDownAlwaysVisible()) {
            dismissDropDown();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.167 -0500", hash_original_method = "42E246C35216D3D5148B04B4E2B23F4A", hash_generated_method = "973FD131F7C02CD89CC0C37852293F2F")
    
@Override
    protected void onDisplayHint(int hint) {
        super.onDisplayHint(hint);
        switch (hint) {
            case INVISIBLE:
                if (!mPopup.isDropDownAlwaysVisible()) {
                    dismissDropDown();
                }
                break;
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.169 -0500", hash_original_method = "28987A1F68AF8291400818B9FA8A6C7A", hash_generated_method = "C9FE1046269B11C730916E3DFEFACE21")
    
@Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        // Perform validation if the view is losing focus.
        if (!focused) {
            performValidation();
        }
        if (!focused && !mPopup.isDropDownAlwaysVisible()) {
            dismissDropDown();
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.171 -0500", hash_original_method = "7A2D6EDAA0E5981DC60C5747420510C2", hash_generated_method = "E61F893A31C359A7EC7EDA9DECB2160C")
    
@Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.173 -0500", hash_original_method = "DD8C719D50846B220D8C588E856246EC", hash_generated_method = "C4BD8833BCFE27BF0CA905246A5BC211")
    
@Override
    protected void onDetachedFromWindow() {
        dismissDropDown();
        super.onDetachedFromWindow();
    }

    /**
     * <p>Closes the drop down if present on screen.</p>
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.175 -0500", hash_original_method = "B307D50FE74ACB01B1CCF5403B3C4263", hash_generated_method = "E479173901F9EF1AB207EFBF64346D88")
    
public void dismissDropDown() {
        InputMethodManager imm = InputMethodManager.peekInstance();
        if (imm != null) {
            imm.displayCompletions(this, null);
        }
        mPopup.dismiss();
        mPopupCanBeUpdated = false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.178 -0500", hash_original_method = "8B7584A552A003B9ACCE9D0FC992FC50", hash_generated_method = "55EF67264642C7311FDF033F8C293F6F")
    
@Override
    protected boolean setFrame(final int l, int t, final int r, int b) {
        boolean result = super.setFrame(l, t, r, b);

        if (isPopupShowing()) {
            showDropDown();
        }

        return result;
    }

    /**
     * Issues a runnable to show the dropdown as soon as possible.
     *
     * @hide internal used only by SearchDialog
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.180 -0500", hash_original_method = "E5B4D0CB7911E0BF332298A12D86AD4A", hash_generated_method = "11C895BDAC8A92EFC9A09FF845014FD0")
    
public void showDropDownAfterLayout() {
        mPopup.postShow();
    }
    
    /**
     * Ensures that the drop down is not obscuring the IME.
     * @param visible whether the ime should be in front. If false, the ime is pushed to
     * the background.
     * @hide internal used only here and SearchDialog
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.183 -0500", hash_original_method = "E55E3CC7F05D9D6DD7DBC4A161FF882F", hash_generated_method = "ED091A77940D15554176AD270BCCE6D6")
    
public void ensureImeVisible(boolean visible) {
        mPopup.setInputMethodMode(visible
                ? ListPopupWindow.INPUT_METHOD_NEEDED : ListPopupWindow.INPUT_METHOD_NOT_NEEDED);
        showDropDown();
    }

    /**
     * @hide internal used only here and SearchDialog
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.185 -0500", hash_original_method = "16FCF16EE4527CEC1661452DABA1BD86", hash_generated_method = "F68C17831E7BD9D5C300D0E6B1DBD386")
    
public boolean isInputMethodNotNeeded() {
        return mPopup.getInputMethodMode() == ListPopupWindow.INPUT_METHOD_NOT_NEEDED;
    }

    /**
     * <p>Displays the drop down on screen.</p>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.187 -0500", hash_original_method = "D361024BEE5BA43B42AED822B3CFC4B1", hash_generated_method = "3A60AA6804A83129BABF6C1C5606521A")
    
public void showDropDown() {
        buildImeCompletions();

        if (mPopup.getAnchorView() == null) {
            if (mDropDownAnchorId != View.NO_ID) {
                mPopup.setAnchorView(getRootView().findViewById(mDropDownAnchorId));
            } else {
                mPopup.setAnchorView(this);
            }
        }
        if (!isPopupShowing()) {
            // Make sure the list does not obscure the IME when shown for the first time.
            mPopup.setInputMethodMode(ListPopupWindow.INPUT_METHOD_NEEDED);
            mPopup.setListItemExpandMax(EXPAND_MAX);
        }
        mPopup.show();
        mPopup.getListView().setOverScrollMode(View.OVER_SCROLL_ALWAYS);
    }

    /**
     * Forces outside touches to be ignored. Normally if {@link #isDropDownAlwaysVisible()} is
     * false, we allow outside touch to dismiss the dropdown. If this is set to true, then we
     * ignore outside touch even when the drop down is not set to always visible.
     * 
     * @hide used only by SearchDialog
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.189 -0500", hash_original_method = "3BAD4610337E0EF5F8BF22A9BBBB2B17", hash_generated_method = "AD6E1537BA196DC650F4C225B5A8FB83")
    
public void setForceIgnoreOutsideTouch(boolean forceIgnoreOutsideTouch) {
        mPopup.setForceIgnoreOutsideTouch(forceIgnoreOutsideTouch);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.192 -0500", hash_original_method = "DD23AC9F9BC11D23FC9B33CDFA0AE577", hash_generated_method = "758CD66E877E747C2B309E0C07EC6FA9")
    
private void buildImeCompletions() {
        final ListAdapter adapter = mAdapter;
        if (adapter != null) {
            InputMethodManager imm = InputMethodManager.peekInstance();
            if (imm != null) {
                final int count = Math.min(adapter.getCount(), 20);
                CompletionInfo[] completions = new CompletionInfo[count];
                int realCount = 0;

                for (int i = 0; i < count; i++) {
                    if (adapter.isEnabled(i)) {
                        realCount++;
                        Object item = adapter.getItem(i);
                        long id = adapter.getItemId(i);
                        completions[i] = new CompletionInfo(id, i, convertSelectionToString(item));
                    }
                }
                
                if (realCount != count) {
                    CompletionInfo[] tmp = new CompletionInfo[realCount];
                    System.arraycopy(completions, 0, tmp, 0, realCount);
                    completions = tmp;
                }

                imm.displayCompletions(this, completions);
            }
        }
    }

    /**
     * Sets the validator used to perform text validation.
     *
     * @param validator The validator used to validate the text entered in this widget.
     *
     * @see #getValidator()
     * @see #performValidation()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.194 -0500", hash_original_method = "19381912498DA3D1F08FF4D2E33BF7A7", hash_generated_method = "98CCD852ABC0697763A0C0BB714FC32C")
    
public void setValidator(Validator validator) {
        mValidator = validator;
    }
    
    private class MyWatcher implements TextWatcher {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.706 -0400", hash_original_method = "25E4BE534CF40240061ABF020C9D68F0", hash_generated_method = "25E4BE534CF40240061ABF020C9D68F0")
        public MyWatcher ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.119 -0500", hash_original_method = "595E81F8C2CD078134C2C0CD5C188C48", hash_generated_method = "87DEFFC43436462F8FA092D750C0C169")
        
public void afterTextChanged(Editable s) {
            doAfterTextChanged();
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.121 -0500", hash_original_method = "BC2E54553D15961DF2A438BC2F30EBE4", hash_generated_method = "9FD50235C1E8D3000B8ADFE167BFB1CB")
        
public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            doBeforeTextChanged();
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.124 -0500", hash_original_method = "65C508C8ABB6ACC44B70A081DD077416", hash_generated_method = "CCE1FF6FD345C39C196B5456008BBCE8")
        
public void onTextChanged(CharSequence s, int start, int before, int count) {
        }
        
    }
    
    private class DropDownItemClickListener implements AdapterView.OnItemClickListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.707 -0400", hash_original_method = "8B63FBEE4316EEB2311D787C7564687C", hash_generated_method = "8B63FBEE4316EEB2311D787C7564687C")
        public DropDownItemClickListener ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.204 -0500", hash_original_method = "4F7C82DB77A3FEF0D877BA2AB4932B41", hash_generated_method = "F6AC220B4873365DF9CDCB143989EF97")
        
public void onItemClick(AdapterView parent, View v, int position, long id) {
            performCompletion(v, position, id);
        }
        
    }
    
    private class PassThroughClickListener implements OnClickListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.211 -0500", hash_original_field = "4B266FAAAFEF787B089CC94471039413", hash_generated_field = "7D6A8796716A6CBC9C60BD4061851E68")

        private View.OnClickListener mWrapped;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.707 -0400", hash_original_method = "DBB7AAAD00FA07F6102A2DD0869EFBF7", hash_generated_method = "DBB7AAAD00FA07F6102A2DD0869EFBF7")
        public PassThroughClickListener ()
        {
            //Synthesized constructor
        }

        /** {@inheritDoc} */
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.213 -0500", hash_original_method = "E3F762E6FD76D99B402BD097AF1F93E6", hash_generated_method = "2075C3C205332D6D432C7633D1C59C3D")
        
public void onClick(View v) {
            onClickImpl();

            if (mWrapped != null) mWrapped.onClick(v);
        }
        
    }
    
    private class PopupDataSetObserver extends DataSetObserver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.707 -0400", hash_original_method = "2B87497157622859499FF49FBED7C822", hash_generated_method = "2B87497157622859499FF49FBED7C822")
        public PopupDataSetObserver ()
        {
            //Synthesized constructor
        }
        @DSSafe(DSCat.ANDROID_CALLBACK)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.221 -0500", hash_original_method = "E1ADD1CC7F155CD4BE00BE335F96E1E6", hash_generated_method = "4B1CFFEC63A0D414A294C4D8F3EFD687")
        
@Override
        public void onChanged() {
            if (mAdapter != null) {
                // If the popup is not showing already, showing it will cause
                // the list of data set observers attached to the adapter to
                // change. We can't do it from here, because we are in the middle
                // of iterating through the list of observers.
                post(new Runnable() {
                    @DSSafe(DSCat.SAFE_LIST)
            public void run() {
                        final ListAdapter adapter = mAdapter;
                        if (adapter != null) {
                            // This will re-layout, thus resetting mDataChanged, so that the
                            // listView click listener stays responsive
                            updateDropDownForFilter(adapter.getCount());
                        }
                    }
                });
            }
        }
        
    }
    
    public interface Validator {
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        boolean isValid(CharSequence text);
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        CharSequence fixText(CharSequence invalidText);
    }

    /**
     * Returns the Validator set with {@link #setValidator},
     * or <code>null</code> if it was not set.
     *
     * @see #setValidator(android.widget.AutoCompleteTextView.Validator)
     * @see #performValidation()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.196 -0500", hash_original_method = "E2B844337B4F2E764213661E3DB17BC8", hash_generated_method = "EB072997E470738223E617AD59B8AB79")
    
public Validator getValidator() {
        return mValidator;
    }

    /**
     * If a validator was set on this view and the current string is not valid,
     * ask the validator to fix it.
     *
     * @see #getValidator()
     * @see #setValidator(android.widget.AutoCompleteTextView.Validator)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.199 -0500", hash_original_method = "6C87320109B091D88082BE6479926B64", hash_generated_method = "D659EA8C256AE7D72B0AF519FA2F28FE")
    
public void performValidation() {
        if (mValidator == null) return;

        CharSequence text = getText();

        if (!TextUtils.isEmpty(text) && !mValidator.isValid(text)) {
            setText(mValidator.fixText(text));
        }
    }

    /**
     * Returns the Filter obtained from {@link Filterable#getFilter},
     * or <code>null</code> if {@link #setAdapter} was not called with
     * a Filterable.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:59.201 -0500", hash_original_method = "A182F1708C145D57F0135D6BE7F61F0B", hash_generated_method = "20C2962FE0F60E0FBED755951BC8FDD8")
    
protected Filter getFilter() {
        return mFilter;
    }
}

