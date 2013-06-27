package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
import android.util.Log;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.633 -0400", hash_original_field = "E1CABE1E2EB0E02B938A46A1B7A0EBFD", hash_generated_field = "1FDB4027FDC409C38C96D7C7129240A3")

    private CharSequence mHintText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.633 -0400", hash_original_field = "16B58D4213ECFB0245D924E5499952EB", hash_generated_field = "3A9494D52ECD891CDD06D9FB033B0410")

    private TextView mHintView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.633 -0400", hash_original_field = "935E8213B379645517C175727BFECCFA", hash_generated_field = "83A803468B3B4450D753F58C9690FCF8")

    private int mHintResource;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.634 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "90F29768206AB431EA361CD94838716F")

    private ListAdapter mAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.634 -0400", hash_original_field = "C781ED17A87FBE09F8079C6EC63D1F26", hash_generated_field = "A13F7A33CB1B9B8C8BC52C7A25894515")

    private Filter mFilter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.634 -0400", hash_original_field = "3C3C53D359DFC0BF874C1D7D1521B140", hash_generated_field = "2B2FC0AB3F9DED44C14A982417EA1993")

    private int mThreshold;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.634 -0400", hash_original_field = "E863CEB96C01242A6262A422DC21BA91", hash_generated_field = "8997F2E1258B500A89588C7ED08EDAF2")

    private ListPopupWindow mPopup;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.634 -0400", hash_original_field = "903BD9B69A445B253D97DFE9C11F5514", hash_generated_field = "AA79DCF4F4AF02E5E4FD88F114FC4A45")

    private int mDropDownAnchorId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.634 -0400", hash_original_field = "1AE585B9A4195C50494CD4717922829E", hash_generated_field = "91F251C39E992AB6E9A1F97E1DB2D65A")

    private AdapterView.OnItemClickListener mItemClickListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.634 -0400", hash_original_field = "AC663E6C1E4BAD60BFB3B64BE97350A7", hash_generated_field = "B20A14E839638431419A27C6FA2EB183")

    private AdapterView.OnItemSelectedListener mItemSelectedListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.634 -0400", hash_original_field = "3010C19D73E606ACA829805F2EC4AF2C", hash_generated_field = "F2A9684F0F8098ECC6D91A395F94C973")

    private boolean mDropDownDismissedOnCompletion = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.634 -0400", hash_original_field = "B1F84A8F9072BD31689628A95AABAE5F", hash_generated_field = "202A96DE332795BB4B1FEBF0146D898F")

    private int mLastKeyCode = KeyEvent.KEYCODE_UNKNOWN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.634 -0400", hash_original_field = "D352E44EC37B3483025E4C3E786315A7", hash_generated_field = "DF21E3DF0E1F480F88152014C172C190")

    private boolean mOpenBefore;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.634 -0400", hash_original_field = "3AAD6DF18105DD8AC1D710531E7A2098", hash_generated_field = "174452E4EA6CBBEFAC61139138443140")

    private Validator mValidator = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.634 -0400", hash_original_field = "FFA1B57EE05E9FF9A47A264C76446CB7", hash_generated_field = "F75A9D78378413BAF88541599A31BF41")

    private boolean mBlockCompletion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.634 -0400", hash_original_field = "25E1729F4969B02B4D30E52EF1ABB195", hash_generated_field = "4C4FE9E3F67714CCAEF17C0AFE9B8BC4")

    private boolean mPopupCanBeUpdated = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.634 -0400", hash_original_field = "3AA8F11C0A37ED86BB0928D842CD212E", hash_generated_field = "EBF3BC0102B69BA2B0B114608A6AF073")

    private PassThroughClickListener mPassThroughClickListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.634 -0400", hash_original_field = "C61FA2E7C36AC7AB9C40A5C4B482DC3A", hash_generated_field = "0623EBBCEF1FE0FD7F127A32EDBCAFCC")

    private PopupDataSetObserver mObserver;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.635 -0400", hash_original_method = "25FDD5DBEC32252B7FC5EA7A3C1328DA", hash_generated_method = "87D0E3C2A13969937ECA57F44C36F265")
    public  AutoCompleteTextView(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.635 -0400", hash_original_method = "37425D654E09169E65BAA252CC2C351E", hash_generated_method = "EEB923E636E8AF07FD5437CF4FF15F49")
    public  AutoCompleteTextView(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.autoCompleteTextViewStyle);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.636 -0400", hash_original_method = "E7A1365EE4283D79F23C38EBF5E5D299", hash_generated_method = "37C17CB955F5AFA031C915DD09A81020")
    public  AutoCompleteTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mPopup = new ListPopupWindow(context, attrs,
                com.android.internal.R.attr.autoCompleteTextViewStyle);
        mPopup.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        mPopup.setPromptPosition(ListPopupWindow.POSITION_PROMPT_BELOW);
        TypedArray a;
        a = context.obtainStyledAttributes(
                attrs, com.android.internal.R.styleable.AutoCompleteTextView, defStyle, 0);
        mThreshold = a.getInt(
                R.styleable.AutoCompleteTextView_completionThreshold, 2);
        mPopup.setListSelector(a.getDrawable(R.styleable.AutoCompleteTextView_dropDownSelector));
        mPopup.setVerticalOffset((int)
                a.getDimension(R.styleable.AutoCompleteTextView_dropDownVerticalOffset, 0.0f));
        mPopup.setHorizontalOffset((int)
                a.getDimension(R.styleable.AutoCompleteTextView_dropDownHorizontalOffset, 0.0f));
        mDropDownAnchorId = a.getResourceId(R.styleable.AutoCompleteTextView_dropDownAnchor,
                View.NO_ID);
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
        int inputType;
        inputType = getInputType();
        {
            inputType |= EditorInfo.TYPE_TEXT_FLAG_AUTO_COMPLETE;
            setRawInputType(inputType);
        } //End block
        a.recycle();
        setFocusable(true);
        addTextChangedListener(new MyWatcher());
        mPassThroughClickListener = new PassThroughClickListener();
        super.setOnClickListener(mPassThroughClickListener);
        addTaint(defStyle);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.637 -0400", hash_original_method = "C1942F3D6CF625065E36951B3C995636", hash_generated_method = "8FAF35C11E127607F0937D7E984024B4")
    @Override
    public void setOnClickListener(OnClickListener listener) {
        mPassThroughClickListener.mWrapped = listener;
        // ---------- Original Method ----------
        //mPassThroughClickListener.mWrapped = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.640 -0400", hash_original_method = "58D3202231E1A3AE7FD8546C3F8B5C86", hash_generated_method = "52A2A3AA0B7B98EAFB7905D335ACF40A")
    private void onClickImpl() {
        {
            boolean varBF0DD052E7F558A1BAF9DA85140649CD_1091644914 = (isPopupShowing());
            {
                ensureImeVisible(true);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (isPopupShowing()) {
            //ensureImeVisible(true);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.641 -0400", hash_original_method = "4F48038C1162C78CAFD13A15CFC4C4E3", hash_generated_method = "F83E0D6E877E565C39C135075280EF39")
    public void setCompletionHint(CharSequence hint) {
        mHintText = hint;
        {
            {
                TextView hintView;
                hintView = (TextView) LayoutInflater.from(getContext()).inflate(
                        mHintResource, null).findViewById(com.android.internal.R.id.text1);
                hintView.setText(mHintText);
                mHintView = hintView;
                mPopup.setPromptView(hintView);
            } //End block
            {
                mHintView.setText(hint);
            } //End block
        } //End block
        {
            mPopup.setPromptView(null);
            mHintView = null;
        } //End block
        // ---------- Original Method ----------
        //mHintText = hint;
        //if (hint != null) {
            //if (mHintView == null) {
                //final TextView hintView = (TextView) LayoutInflater.from(getContext()).inflate(
                        //mHintResource, null).findViewById(com.android.internal.R.id.text1);
                //hintView.setText(mHintText);
                //mHintView = hintView;
                //mPopup.setPromptView(hintView);
            //} else {
                //mHintView.setText(hint);
            //}
        //} else {
            //mPopup.setPromptView(null);
            //mHintView = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.641 -0400", hash_original_method = "0FF617112E6940852CA340238B035B28", hash_generated_method = "B48A4D27D943268E2ECC59A1D8B631DE")
    public int getDropDownWidth() {
        int varDE5FE111D7D320C8167E395DFD34A92D_876703105 = (mPopup.getWidth());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_14430660 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_14430660;
        // ---------- Original Method ----------
        //return mPopup.getWidth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.657 -0400", hash_original_method = "B270189DDD36B930B898EDE5BD590C69", hash_generated_method = "BD864A3F2620BF019C71B7C3D014D20B")
    public void setDropDownWidth(int width) {
        mPopup.setWidth(width);
        addTaint(width);
        // ---------- Original Method ----------
        //mPopup.setWidth(width);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.658 -0400", hash_original_method = "ED81905DF1626AD5BC656BEBB27BE880", hash_generated_method = "664017055C967B4BE5906BDE16F27DDC")
    public int getDropDownHeight() {
        int var289B548EABC2C0DE3CC9B937149AC347_1907479833 = (mPopup.getHeight());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1598452992 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1598452992;
        // ---------- Original Method ----------
        //return mPopup.getHeight();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.658 -0400", hash_original_method = "7CEF092BABE0725B932F9B439F9A3AFD", hash_generated_method = "013FBD695CE08A7C16E3BE2EE89F113D")
    public void setDropDownHeight(int height) {
        mPopup.setHeight(height);
        addTaint(height);
        // ---------- Original Method ----------
        //mPopup.setHeight(height);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.659 -0400", hash_original_method = "983C379A49D6519E05BB04A2322E89F2", hash_generated_method = "0411916E6A5DAAFE6062247BEEC409E6")
    public int getDropDownAnchor() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1568930814 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1568930814;
        // ---------- Original Method ----------
        //return mDropDownAnchorId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.659 -0400", hash_original_method = "5971179F1F300FE7DC24F52751CD203A", hash_generated_method = "A178705FF73BC3A9E4C8F5B8D7813F35")
    public void setDropDownAnchor(int id) {
        mDropDownAnchorId = id;
        mPopup.setAnchorView(null);
        // ---------- Original Method ----------
        //mDropDownAnchorId = id;
        //mPopup.setAnchorView(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.659 -0400", hash_original_method = "AF968841F9ADA345DD97E068FA7BD610", hash_generated_method = "AFB7D2E46B972E782291976AEDF5567E")
    public Drawable getDropDownBackground() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_2015860259 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2015860259 = mPopup.getBackground();
        varB4EAC82CA7396A68D541C85D26508E83_2015860259.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2015860259;
        // ---------- Original Method ----------
        //return mPopup.getBackground();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.660 -0400", hash_original_method = "B18D529A578176AD889BDFBA197D2FE9", hash_generated_method = "48A91F27698F5FAF671A1BE029067209")
    public void setDropDownBackgroundDrawable(Drawable d) {
        mPopup.setBackgroundDrawable(d);
        addTaint(d.getTaint());
        // ---------- Original Method ----------
        //mPopup.setBackgroundDrawable(d);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.660 -0400", hash_original_method = "58B212667945303F92E76684E6DBBAC3", hash_generated_method = "4987F8E12291D63A7394F16AB33C2E01")
    public void setDropDownBackgroundResource(int id) {
        mPopup.setBackgroundDrawable(getResources().getDrawable(id));
        addTaint(id);
        // ---------- Original Method ----------
        //mPopup.setBackgroundDrawable(getResources().getDrawable(id));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.660 -0400", hash_original_method = "AFE41A06E9A754A352572FB9B075CCA0", hash_generated_method = "8A6BAC5BA53C104319D3238202B34849")
    public void setDropDownVerticalOffset(int offset) {
        mPopup.setVerticalOffset(offset);
        addTaint(offset);
        // ---------- Original Method ----------
        //mPopup.setVerticalOffset(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.680 -0400", hash_original_method = "CD8747B9F2476A0A6006DC41A664E503", hash_generated_method = "8FDA2875B60385031F0734992119476F")
    public int getDropDownVerticalOffset() {
        int var144F8B316A170B2292449FD7841B01F4_1274018888 = (mPopup.getVerticalOffset());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1989890989 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1989890989;
        // ---------- Original Method ----------
        //return mPopup.getVerticalOffset();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.680 -0400", hash_original_method = "6A22527360686DE12C48E20144984DC3", hash_generated_method = "11FAAEAF433F768EE713C36C9055E6FC")
    public void setDropDownHorizontalOffset(int offset) {
        mPopup.setHorizontalOffset(offset);
        addTaint(offset);
        // ---------- Original Method ----------
        //mPopup.setHorizontalOffset(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.681 -0400", hash_original_method = "A7584484859282D74A751422BD935CE2", hash_generated_method = "32D0EA5FA73A38A5B6A88AA5F4D2FA56")
    public int getDropDownHorizontalOffset() {
        int var4E1106CDA8E88D337563292F7F0B86B9_1299105250 = (mPopup.getHorizontalOffset());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1737987626 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1737987626;
        // ---------- Original Method ----------
        //return mPopup.getHorizontalOffset();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.681 -0400", hash_original_method = "AB6AF7AB4438F2936FAB5E115855ABD1", hash_generated_method = "C52D4378B9FB9F5A35C6B59E46AEE386")
    public void setDropDownAnimationStyle(int animationStyle) {
        mPopup.setAnimationStyle(animationStyle);
        addTaint(animationStyle);
        // ---------- Original Method ----------
        //mPopup.setAnimationStyle(animationStyle);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.682 -0400", hash_original_method = "348942C9B29D455789FBCF016CC929C3", hash_generated_method = "DF56BBC3FB19C4EB4C9B4DE96C29430B")
    public int getDropDownAnimationStyle() {
        int varFF59793919A82B1D3C72ECF85DD5BB92_60939512 = (mPopup.getAnimationStyle());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_337652214 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_337652214;
        // ---------- Original Method ----------
        //return mPopup.getAnimationStyle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.682 -0400", hash_original_method = "4343F66DAC432AAC8F4BD77081597537", hash_generated_method = "4C10CD677DCDFE5F41E02ABF9BAE1AAE")
    public boolean isDropDownAlwaysVisible() {
        boolean var25EF609394F97B7ED2D9FEED6B39F9EF_1818973683 = (mPopup.isDropDownAlwaysVisible());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1976048904 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1976048904;
        // ---------- Original Method ----------
        //return mPopup.isDropDownAlwaysVisible();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.682 -0400", hash_original_method = "9D048710298E272B53CC3CA9B767E12A", hash_generated_method = "FA06148E7B02F238F0BAE803F1C7DFCE")
    public void setDropDownAlwaysVisible(boolean dropDownAlwaysVisible) {
        mPopup.setDropDownAlwaysVisible(dropDownAlwaysVisible);
        addTaint(dropDownAlwaysVisible);
        // ---------- Original Method ----------
        //mPopup.setDropDownAlwaysVisible(dropDownAlwaysVisible);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.694 -0400", hash_original_method = "5251E63145860B08CE1AA76BBDDDD070", hash_generated_method = "36EEBDCF85B366580E8E455407318E73")
    public boolean isDropDownDismissedOnCompletion() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1256819493 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1256819493;
        // ---------- Original Method ----------
        //return mDropDownDismissedOnCompletion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.695 -0400", hash_original_method = "87D4B20D86EF98CE5F9B2DCFB12777AB", hash_generated_method = "60B8689EC6F3BBAD668A4B2923A0BC91")
    public void setDropDownDismissedOnCompletion(boolean dropDownDismissedOnCompletion) {
        mDropDownDismissedOnCompletion = dropDownDismissedOnCompletion;
        // ---------- Original Method ----------
        //mDropDownDismissedOnCompletion = dropDownDismissedOnCompletion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.695 -0400", hash_original_method = "D355B3B251BB91FAED293791929579AC", hash_generated_method = "94277BBCA4A744511AB108C5C9FD9A21")
    public int getThreshold() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_896606147 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_896606147;
        // ---------- Original Method ----------
        //return mThreshold;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.696 -0400", hash_original_method = "E80EC39EC531963E159919926C4979B9", hash_generated_method = "B09D48444A80E5C277F1A11E6CB8772A")
    public void setThreshold(int threshold) {
        {
            threshold = 1;
        } //End block
        mThreshold = threshold;
        // ---------- Original Method ----------
        //if (threshold <= 0) {
            //threshold = 1;
        //}
        //mThreshold = threshold;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.696 -0400", hash_original_method = "B69DF6D8B348285F7F509DAAD23C3372", hash_generated_method = "25CD98E2A8A27C201F3F3F3C7D972CAC")
    public void setOnItemClickListener(AdapterView.OnItemClickListener l) {
        mItemClickListener = l;
        // ---------- Original Method ----------
        //mItemClickListener = l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.696 -0400", hash_original_method = "48F24F393448111E92CC5CFF766C1584", hash_generated_method = "B7A11EA05B947A6361BE0A6FEA1488E9")
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener l) {
        mItemSelectedListener = l;
        // ---------- Original Method ----------
        //mItemSelectedListener = l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.697 -0400", hash_original_method = "0AE6D510B9C16F8D52FF49376A7BF6A4", hash_generated_method = "62EC718150AB10407A54F26AE6EEFDE0")
    @Deprecated
    public AdapterView.OnItemClickListener getItemClickListener() {
        AdapterView.OnItemClickListener varB4EAC82CA7396A68D541C85D26508E83_1620801136 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1620801136 = mItemClickListener;
        varB4EAC82CA7396A68D541C85D26508E83_1620801136.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1620801136;
        // ---------- Original Method ----------
        //return mItemClickListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.697 -0400", hash_original_method = "2A86C7E057A0C403AB649B0ED567456D", hash_generated_method = "A2CBA387A83878DFA09E1A83CDAFBD4D")
    @Deprecated
    public AdapterView.OnItemSelectedListener getItemSelectedListener() {
        AdapterView.OnItemSelectedListener varB4EAC82CA7396A68D541C85D26508E83_643571457 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_643571457 = mItemSelectedListener;
        varB4EAC82CA7396A68D541C85D26508E83_643571457.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_643571457;
        // ---------- Original Method ----------
        //return mItemSelectedListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.717 -0400", hash_original_method = "CC34C836A582B2E0B6660928CDDA2E79", hash_generated_method = "02AB266E0906AF1FD43BD617444552BE")
    public AdapterView.OnItemClickListener getOnItemClickListener() {
        AdapterView.OnItemClickListener varB4EAC82CA7396A68D541C85D26508E83_644585138 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_644585138 = mItemClickListener;
        varB4EAC82CA7396A68D541C85D26508E83_644585138.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_644585138;
        // ---------- Original Method ----------
        //return mItemClickListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.717 -0400", hash_original_method = "CA4C95C3D87D9F2B4999807B4A5E6086", hash_generated_method = "DD75AB27D305647650D5580AF8AD77DE")
    public AdapterView.OnItemSelectedListener getOnItemSelectedListener() {
        AdapterView.OnItemSelectedListener varB4EAC82CA7396A68D541C85D26508E83_2052074474 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2052074474 = mItemSelectedListener;
        varB4EAC82CA7396A68D541C85D26508E83_2052074474.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2052074474;
        // ---------- Original Method ----------
        //return mItemSelectedListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.718 -0400", hash_original_method = "0E1A05724C497F45D7FB6AC34C501814", hash_generated_method = "2E971245067FCC7F68209D21F62034A4")
    public ListAdapter getAdapter() {
        ListAdapter varB4EAC82CA7396A68D541C85D26508E83_587088787 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_587088787 = mAdapter;
        varB4EAC82CA7396A68D541C85D26508E83_587088787.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_587088787;
        // ---------- Original Method ----------
        //return mAdapter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.719 -0400", hash_original_method = "18CB1EEAAEFB5BC2DC3ECE426EBE9928", hash_generated_method = "F413B6554C42CF54302E569B2397F6EF")
    public <T extends ListAdapter & Filterable> void setAdapter(T adapter) {
        {
            mObserver = new PopupDataSetObserver();
        } //End block
        {
            mAdapter.unregisterDataSetObserver(mObserver);
        } //End block
        mAdapter = adapter;
        {
            mFilter = ((Filterable) mAdapter).getFilter();
            adapter.registerDataSetObserver(mObserver);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.719 -0400", hash_original_method = "1E2534A3F57B1DBFCDE49E1B48E26A0E", hash_generated_method = "A9044550EAB217CBCB2E431FBEB9978C")
    @Override
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean varCF91672D100D36DDC3B4C7C44DABA877_1077582282 = (keyCode == KeyEvent.KEYCODE_BACK && isPopupShowing()
                && !mPopup.isDropDownAlwaysVisible());
            {
                {
                    boolean var51947D54DEEA690F1B41A17DE6323711_2025998670 = (event.getAction() == KeyEvent.ACTION_DOWN && event.getRepeatCount() == 0);
                    {
                        KeyEvent.DispatcherState state;
                        state = getKeyDispatcherState();
                        {
                            state.startTracking(event, this);
                        } //End block
                    } //End block
                    {
                        boolean varA6D964A9D1A4D1D485BD8D60F2BFCDEE_405690601 = (event.getAction() == KeyEvent.ACTION_UP);
                        {
                            KeyEvent.DispatcherState state;
                            state = getKeyDispatcherState();
                            {
                                state.handleUpEvent(event);
                            } //End block
                            {
                                boolean varBE09C907F92D135687297C67489D82A5_682733480 = (event.isTracking() && !event.isCanceled());
                                {
                                    dismissDropDown();
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        boolean var84A59BF21652B099F795A333EE25717D_1379402573 = (super.onKeyPreIme(keyCode, event));
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_249188145 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_249188145;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.746 -0400", hash_original_method = "A5021B9859EF1208F776ED0647DC53F8", hash_generated_method = "1AA780625BC43B6F7F0BF194FC4A397C")
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        boolean consumed;
        consumed = mPopup.onKeyUp(keyCode, event);
        {
            //Begin case KeyEvent.KEYCODE_ENTER KeyEvent.KEYCODE_DPAD_CENTER KeyEvent.KEYCODE_TAB 
            {
                boolean var01265F35364458CD2A88FFB15C2C1B92_458611125 = (event.hasNoModifiers());
                {
                    performCompletion();
                } //End block
            } //End collapsed parenthetic
            //End case KeyEvent.KEYCODE_ENTER KeyEvent.KEYCODE_DPAD_CENTER KeyEvent.KEYCODE_TAB 
        } //End block
        {
            boolean var4EA7F10CC93D61226F2D23FB52A9A1C6_1513197244 = (isPopupShowing() && keyCode == KeyEvent.KEYCODE_TAB && event.hasNoModifiers());
            {
                performCompletion();
            } //End block
        } //End collapsed parenthetic
        boolean varEDD771EBF66425AD21882AB08CD0EE48_1408654855 = (super.onKeyUp(keyCode, event));
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_453949724 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_453949724;
        // ---------- Original Method ----------
        //boolean consumed = mPopup.onKeyUp(keyCode, event);
        //if (consumed) {
            //switch (keyCode) {
            //case KeyEvent.KEYCODE_ENTER:
            //case KeyEvent.KEYCODE_DPAD_CENTER:
            //case KeyEvent.KEYCODE_TAB:
                //if (event.hasNoModifiers()) {
                    //performCompletion();
                //}
                //return true;
            //}
        //}
        //if (isPopupShowing() && keyCode == KeyEvent.KEYCODE_TAB && event.hasNoModifiers()) {
            //performCompletion();
            //return true;
        //}
        //return super.onKeyUp(keyCode, event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.747 -0400", hash_original_method = "7D38CCD4A21A1817640875450034C5D6", hash_generated_method = "1CD2C73476BA8D8D42A8ED7E85D930A5")
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean varEAA7337EBC536309203EE3E593753A75_973967689 = (mPopup.onKeyDown(keyCode, event));
        } //End collapsed parenthetic
        {
            boolean var31CE5F0E197E77752ACB4AEDFA1D3C90_1672024589 = (!isPopupShowing());
            {
                //Begin case KeyEvent.KEYCODE_DPAD_DOWN 
                {
                    boolean varC77C0C11194BD87DFEE086A32DCE5C18_1526080524 = (event.hasNoModifiers());
                    {
                        performValidation();
                    } //End block
                } //End collapsed parenthetic
                //End case KeyEvent.KEYCODE_DPAD_DOWN 
            } //End block
        } //End collapsed parenthetic
        {
            boolean var4EA7F10CC93D61226F2D23FB52A9A1C6_867680365 = (isPopupShowing() && keyCode == KeyEvent.KEYCODE_TAB && event.hasNoModifiers());
        } //End collapsed parenthetic
        mLastKeyCode = keyCode;
        boolean handled;
        handled = super.onKeyDown(keyCode, event);
        mLastKeyCode = KeyEvent.KEYCODE_UNKNOWN;
        {
            boolean var162F5ADAD69E734CD14CBE2CECA73563_2038456388 = (handled && isPopupShowing());
            {
                clearListSelection();
            } //End block
        } //End collapsed parenthetic
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_768101079 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_768101079;
        // ---------- Original Method ----------
        //if (mPopup.onKeyDown(keyCode, event)) {
            //return true;
        //}
        //if (!isPopupShowing()) {
            //switch(keyCode) {
            //case KeyEvent.KEYCODE_DPAD_DOWN:
                //if (event.hasNoModifiers()) {
                    //performValidation();
                //}
            //}
        //}
        //if (isPopupShowing() && keyCode == KeyEvent.KEYCODE_TAB && event.hasNoModifiers()) {
            //return true;
        //}
        //mLastKeyCode = keyCode;
        //boolean handled = super.onKeyDown(keyCode, event);
        //mLastKeyCode = KeyEvent.KEYCODE_UNKNOWN;
        //if (handled && isPopupShowing()) {
            //clearListSelection();
        //}
        //return handled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.761 -0400", hash_original_method = "845425AE754C4142506C6C975210339B", hash_generated_method = "70DA01F1CF001A2FE9EC7F3748C3907A")
    public boolean enoughToFilter() {
        boolean var802A199BC987421607136CCD7E0B67F4_1510126712 = (getText().length() >= mThreshold);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1705758773 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1705758773;
        // ---------- Original Method ----------
        //if (DEBUG) Log.v(TAG, "Enough to filter: len=" + getText().length()
                //+ " threshold=" + mThreshold);
        //return getText().length() >= mThreshold;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.761 -0400", hash_original_method = "9B68F895919D747E86E2BC0B861C3485", hash_generated_method = "5079856DA9B9C5DA20D2FB5BC21BACFA")
     void doBeforeTextChanged() {
        mOpenBefore = isPopupShowing();
        // ---------- Original Method ----------
        //if (mBlockCompletion) return;
        //mOpenBefore = isPopupShowing();
        //if (DEBUG) Log.v(TAG, "before text changed: open=" + mOpenBefore);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.856 -0400", hash_original_method = "EABD50974341527CEC5D7DC0490BCDC7", hash_generated_method = "4BD45B92C5389A7F3646F7ABFF38414B")
     void doAfterTextChanged() {
        {
            boolean varC8DFCD3EC6795C83C2C2CEA0F5FB857A_1994184901 = (mOpenBefore && !isPopupShowing());
        } //End collapsed parenthetic
        {
            boolean var7BC1F429DC7B76D5B2FE230BBFF7FD32_68110401 = (enoughToFilter());
            {
                {
                    mPopupCanBeUpdated = true;
                    performFiltering(getText(), mLastKeyCode);
                } //End block
            } //End block
            {
                {
                    boolean var0824F0A8A43CDA043490F1016B02DD90_821700099 = (!mPopup.isDropDownAlwaysVisible());
                    {
                        dismissDropDown();
                    } //End block
                } //End collapsed parenthetic
                {
                    mFilter.filter(null);
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (mBlockCompletion) return;
        //if (DEBUG) Log.v(TAG, "after text changed: openBefore=" + mOpenBefore
                //+ " open=" + isPopupShowing());
        //if (mOpenBefore && !isPopupShowing()) {
            //return;
        //}
        //if (enoughToFilter()) {
            //if (mFilter != null) {
                //mPopupCanBeUpdated = true;
                //performFiltering(getText(), mLastKeyCode);
            //}
        //} else {
            //if (!mPopup.isDropDownAlwaysVisible()) {
                //dismissDropDown();
            //}
            //if (mFilter != null) {
                //mFilter.filter(null);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.857 -0400", hash_original_method = "82AB47D081F83CBFD677A62933F7FE17", hash_generated_method = "9B9A0B02F6BCFF846D12C0C51C1DFDF9")
    public boolean isPopupShowing() {
        boolean varC4D0BEF5C8B8A88A8F0203AF22B9D645_300546910 = (mPopup.isShowing());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2056805645 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2056805645;
        // ---------- Original Method ----------
        //return mPopup.isShowing();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.858 -0400", hash_original_method = "5BE18D1BCEE667E3D32BBF42EAB5125A", hash_generated_method = "867DBEC88B7F126011A8FAAF4860C22B")
    protected CharSequence convertSelectionToString(Object selectedItem) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_2062737848 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2062737848 = mFilter.convertResultToString(selectedItem);
        addTaint(selectedItem.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2062737848.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2062737848;
        // ---------- Original Method ----------
        //return mFilter.convertResultToString(selectedItem);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.858 -0400", hash_original_method = "7623D1558693BF470F22C595BECC6733", hash_generated_method = "8B3C8ABD4877B8477A9502489B2E9EE7")
    public void clearListSelection() {
        mPopup.clearListSelection();
        // ---------- Original Method ----------
        //mPopup.clearListSelection();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.862 -0400", hash_original_method = "133DE5DB01039801737429C3DDB0411B", hash_generated_method = "4586C4A5BD8268367DA504FDAB85A9DC")
    public void setListSelection(int position) {
        mPopup.setSelection(position);
        addTaint(position);
        // ---------- Original Method ----------
        //mPopup.setSelection(position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.863 -0400", hash_original_method = "FACA63936D6E82D9A31B7F667F19A5C4", hash_generated_method = "98E4587267E127FD5B2F0F047B8763C4")
    public int getListSelection() {
        int var857A9A7C75A21043C7E420ED49138B63_257276916 = (mPopup.getSelectedItemPosition());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_653661676 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_653661676;
        // ---------- Original Method ----------
        //return mPopup.getSelectedItemPosition();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.863 -0400", hash_original_method = "6D2AAF11ECF28F40F16EC0FF58DB7391", hash_generated_method = "AFF6AEDA3F0CB584AAF5212EC2736449")
    @SuppressWarnings({ "UnusedDeclaration" })
    protected void performFiltering(CharSequence text, int keyCode) {
        mFilter.filter(text, this);
        addTaint(text.getTaint());
        addTaint(keyCode);
        // ---------- Original Method ----------
        //mFilter.filter(text, this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.864 -0400", hash_original_method = "F704ACEA98F83F3E1219E92B20BE03DA", hash_generated_method = "A721540EC82B1346CA97B5580BF1819C")
    public void performCompletion() {
        performCompletion(null, -1, -1);
        // ---------- Original Method ----------
        //performCompletion(null, -1, -1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.866 -0400", hash_original_method = "4C402F357E20A5DEEC78C01A554F2E74", hash_generated_method = "181C9C2B4E9A829FC24FAA1BE7B45952")
    @Override
    public void onCommitCompletion(CompletionInfo completion) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean varBF0DD052E7F558A1BAF9DA85140649CD_1577925830 = (isPopupShowing());
            {
                mPopup.performItemClick(completion.getPosition());
            } //End block
        } //End collapsed parenthetic
        addTaint(completion.getTaint());
        // ---------- Original Method ----------
        //if (isPopupShowing()) {
            //mPopup.performItemClick(completion.getPosition());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.873 -0400", hash_original_method = "87F4A447D592D0FFBC34508A48276E40", hash_generated_method = "56222FF56FAA8EFB96B211D100BC7AD6")
    private void performCompletion(View selectedView, int position, long id) {
        {
            boolean varBF0DD052E7F558A1BAF9DA85140649CD_551865670 = (isPopupShowing());
            {
                Object selectedItem;
                {
                    selectedItem = mPopup.getSelectedItem();
                } //End block
                {
                    selectedItem = mAdapter.getItem(position);
                } //End block
                mBlockCompletion = true;
                replaceText(convertSelectionToString(selectedItem));
                mBlockCompletion = false;
                {
                    ListPopupWindow list;
                    list = mPopup;
                    {
                        selectedView = list.getSelectedView();
                        position = list.getSelectedItemPosition();
                        id = list.getSelectedItemId();
                    } //End block
                    mItemClickListener.onItemClick(list.getListView(), selectedView, position, id);
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            boolean var84F7BA650A0C071DE71B9F9EFAFD4CB7_410106463 = (mDropDownDismissedOnCompletion && !mPopup.isDropDownAlwaysVisible());
            {
                dismissDropDown();
            } //End block
        } //End collapsed parenthetic
        addTaint(selectedView.getTaint());
        addTaint(position);
        addTaint(id);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.873 -0400", hash_original_method = "01D38330C874C1244C7D1EF978D11C36", hash_generated_method = "CEBBCEA30FDFA682A848BC3CC5111024")
    public boolean isPerformingCompletion() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1476253417 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1476253417;
        // ---------- Original Method ----------
        //return mBlockCompletion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.894 -0400", hash_original_method = "3F95D8A8308B140C895762391C3A32C6", hash_generated_method = "D05AAB70325B9428DEECAD29F5FAB653")
    public void setText(CharSequence text, boolean filter) {
        {
            setText(text);
        } //End block
        {
            mBlockCompletion = true;
            setText(text);
            mBlockCompletion = false;
        } //End block
        addTaint(text.getTaint());
        addTaint(filter);
        // ---------- Original Method ----------
        //if (filter) {
            //setText(text);
        //} else {
            //mBlockCompletion = true;
            //setText(text);
            //mBlockCompletion = false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.895 -0400", hash_original_method = "BFA04BF25DCE9275294E0FA186DED6C8", hash_generated_method = "C89A328C2A078FB6EAF713B08B8BEE99")
    protected void replaceText(CharSequence text) {
        clearComposingText();
        setText(text);
        Editable spannable;
        spannable = getText();
        Selection.setSelection(spannable, spannable.length());
        addTaint(text.getTaint());
        // ---------- Original Method ----------
        //clearComposingText();
        //setText(text);
        //Editable spannable = getText();
        //Selection.setSelection(spannable, spannable.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.895 -0400", hash_original_method = "65C6B6A3B92536D4DF6F13E8CB596A16", hash_generated_method = "9FA1EB20741DC74E1C22C1F26903C549")
    public void onFilterComplete(int count) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        updateDropDownForFilter(count);
        addTaint(count);
        // ---------- Original Method ----------
        //updateDropDownForFilter(count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.896 -0400", hash_original_method = "43BA40231E8A8ECAF857BC9AE8C4397B", hash_generated_method = "E52EFE9C96B0ABF6FA7507C4976F50D4")
    private void updateDropDownForFilter(int count) {
        {
            boolean varD5CDC0D536B5FA4553B96B5703612C11_1464274911 = (getWindowVisibility() == View.GONE);
        } //End collapsed parenthetic
        boolean dropDownAlwaysVisible;
        dropDownAlwaysVisible = mPopup.isDropDownAlwaysVisible();
        boolean enoughToFilter;
        enoughToFilter = enoughToFilter();
        {
            {
                boolean varE1F8380C8E3F7DCCF817AF0484F51D4C_938335399 = (hasFocus() && hasWindowFocus() && mPopupCanBeUpdated);
                {
                    showDropDown();
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean var9C99795911568E3888EABA880D410AFC_1813471767 = (!dropDownAlwaysVisible && isPopupShowing());
            {
                dismissDropDown();
                mPopupCanBeUpdated = true;
            } //End block
        } //End collapsed parenthetic
        addTaint(count);
        // ---------- Original Method ----------
        //if (getWindowVisibility() == View.GONE) return;
        //final boolean dropDownAlwaysVisible = mPopup.isDropDownAlwaysVisible();
        //final boolean enoughToFilter = enoughToFilter();
        //if ((count > 0 || dropDownAlwaysVisible) && enoughToFilter) {
            //if (hasFocus() && hasWindowFocus() && mPopupCanBeUpdated) {
                //showDropDown();
            //}
        //} else if (!dropDownAlwaysVisible && isPopupShowing()) {
            //dismissDropDown();
            //mPopupCanBeUpdated = true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.904 -0400", hash_original_method = "2BBFCFB03CA88D4E4428D247CF9B4D7A", hash_generated_method = "B5F435E1176BACFF9A291C949EB48B37")
    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onWindowFocusChanged(hasWindowFocus);
        {
            boolean var941F9BC59CD94FBFBC0C73300BC8F8DC_479353567 = (!hasWindowFocus && !mPopup.isDropDownAlwaysVisible());
            {
                dismissDropDown();
            } //End block
        } //End collapsed parenthetic
        addTaint(hasWindowFocus);
        // ---------- Original Method ----------
        //super.onWindowFocusChanged(hasWindowFocus);
        //if (!hasWindowFocus && !mPopup.isDropDownAlwaysVisible()) {
            //dismissDropDown();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.905 -0400", hash_original_method = "42E246C35216D3D5148B04B4E2B23F4A", hash_generated_method = "DFCBD28DFA9074217C23A1ACB2094F76")
    @Override
    protected void onDisplayHint(int hint) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onDisplayHint(hint);
        //Begin case INVISIBLE 
        {
            boolean var385AD17FFBEDD864FC1A0B58A1F09114_1248592131 = (!mPopup.isDropDownAlwaysVisible());
            {
                dismissDropDown();
            } //End block
        } //End collapsed parenthetic
        //End case INVISIBLE 
        addTaint(hint);
        // ---------- Original Method ----------
        //super.onDisplayHint(hint);
        //switch (hint) {
            //case INVISIBLE:
                //if (!mPopup.isDropDownAlwaysVisible()) {
                    //dismissDropDown();
                //}
                //break;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.905 -0400", hash_original_method = "28987A1F68AF8291400818B9FA8A6C7A", hash_generated_method = "5B7D3FC707C38B7FB996E7352636B6BD")
    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        {
            performValidation();
        } //End block
        {
            boolean varA8CBBEFC0E9CCE791C24D52787B7074B_2030683882 = (!focused && !mPopup.isDropDownAlwaysVisible());
            {
                dismissDropDown();
            } //End block
        } //End collapsed parenthetic
        addTaint(focused);
        addTaint(direction);
        addTaint(previouslyFocusedRect.getTaint());
        // ---------- Original Method ----------
        //super.onFocusChanged(focused, direction, previouslyFocusedRect);
        //if (!focused) {
            //performValidation();
        //}
        //if (!focused && !mPopup.isDropDownAlwaysVisible()) {
            //dismissDropDown();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.908 -0400", hash_original_method = "7A2D6EDAA0E5981DC60C5747420510C2", hash_generated_method = "00FC054FE7DDC1542F03A4EEE8C79AC6")
    @Override
    protected void onAttachedToWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onAttachedToWindow();
        // ---------- Original Method ----------
        //super.onAttachedToWindow();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.908 -0400", hash_original_method = "DD8C719D50846B220D8C588E856246EC", hash_generated_method = "3B133B89A062F2ACA8F9A841C10030DC")
    @Override
    protected void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dismissDropDown();
        super.onDetachedFromWindow();
        // ---------- Original Method ----------
        //dismissDropDown();
        //super.onDetachedFromWindow();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.909 -0400", hash_original_method = "B307D50FE74ACB01B1CCF5403B3C4263", hash_generated_method = "A125B69E4FE5391B539E4F789A84776B")
    public void dismissDropDown() {
        InputMethodManager imm;
        imm = InputMethodManager.peekInstance();
        {
            imm.displayCompletions(this, null);
        } //End block
        mPopup.dismiss();
        mPopupCanBeUpdated = false;
        // ---------- Original Method ----------
        //InputMethodManager imm = InputMethodManager.peekInstance();
        //if (imm != null) {
            //imm.displayCompletions(this, null);
        //}
        //mPopup.dismiss();
        //mPopupCanBeUpdated = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.913 -0400", hash_original_method = "8B7584A552A003B9ACCE9D0FC992FC50", hash_generated_method = "0521FC6B4E2321A9D5F259BD3843EC0A")
    @Override
    protected boolean setFrame(final int l, int t, final int r, int b) {
        boolean result;
        result = super.setFrame(l, t, r, b);
        {
            boolean varBF0DD052E7F558A1BAF9DA85140649CD_839183889 = (isPopupShowing());
            {
                showDropDown();
            } //End block
        } //End collapsed parenthetic
        addTaint(l);
        addTaint(t);
        addTaint(r);
        addTaint(b);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_26774102 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_26774102;
        // ---------- Original Method ----------
        //boolean result = super.setFrame(l, t, r, b);
        //if (isPopupShowing()) {
            //showDropDown();
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.913 -0400", hash_original_method = "E5B4D0CB7911E0BF332298A12D86AD4A", hash_generated_method = "A9417F64F27E0248C39106ECDBA36D11")
    public void showDropDownAfterLayout() {
        mPopup.postShow();
        // ---------- Original Method ----------
        //mPopup.postShow();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.914 -0400", hash_original_method = "E55E3CC7F05D9D6DD7DBC4A161FF882F", hash_generated_method = "FF0A52CA19BAB45F7C3324D9CF8EA676")
    public void ensureImeVisible(boolean visible) {
        mPopup.setInputMethodMode(visible
                ? ListPopupWindow.INPUT_METHOD_NEEDED : ListPopupWindow.INPUT_METHOD_NOT_NEEDED);
        showDropDown();
        addTaint(visible);
        // ---------- Original Method ----------
        //mPopup.setInputMethodMode(visible
                //? ListPopupWindow.INPUT_METHOD_NEEDED : ListPopupWindow.INPUT_METHOD_NOT_NEEDED);
        //showDropDown();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.914 -0400", hash_original_method = "16FCF16EE4527CEC1661452DABA1BD86", hash_generated_method = "40F30D390EFCD761225DC2EAAB445FE7")
    public boolean isInputMethodNotNeeded() {
        boolean varFE28C58AF71C3C6BA19C8B909BE540AC_1626560660 = (mPopup.getInputMethodMode() == ListPopupWindow.INPUT_METHOD_NOT_NEEDED);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_597203362 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_597203362;
        // ---------- Original Method ----------
        //return mPopup.getInputMethodMode() == ListPopupWindow.INPUT_METHOD_NOT_NEEDED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.932 -0400", hash_original_method = "D361024BEE5BA43B42AED822B3CFC4B1", hash_generated_method = "E0341764C1894230CF3228B4BD9BEDFF")
    public void showDropDown() {
        buildImeCompletions();
        {
            boolean var3068B623CD2CFC5D008C7D2FE5FE0A2C_800111471 = (mPopup.getAnchorView() == null);
            {
                {
                    mPopup.setAnchorView(getRootView().findViewById(mDropDownAnchorId));
                } //End block
                {
                    mPopup.setAnchorView(this);
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            boolean var31CE5F0E197E77752ACB4AEDFA1D3C90_2106863683 = (!isPopupShowing());
            {
                mPopup.setInputMethodMode(ListPopupWindow.INPUT_METHOD_NEEDED);
                mPopup.setListItemExpandMax(EXPAND_MAX);
            } //End block
        } //End collapsed parenthetic
        mPopup.show();
        mPopup.getListView().setOverScrollMode(View.OVER_SCROLL_ALWAYS);
        // ---------- Original Method ----------
        //buildImeCompletions();
        //if (mPopup.getAnchorView() == null) {
            //if (mDropDownAnchorId != View.NO_ID) {
                //mPopup.setAnchorView(getRootView().findViewById(mDropDownAnchorId));
            //} else {
                //mPopup.setAnchorView(this);
            //}
        //}
        //if (!isPopupShowing()) {
            //mPopup.setInputMethodMode(ListPopupWindow.INPUT_METHOD_NEEDED);
            //mPopup.setListItemExpandMax(EXPAND_MAX);
        //}
        //mPopup.show();
        //mPopup.getListView().setOverScrollMode(View.OVER_SCROLL_ALWAYS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.932 -0400", hash_original_method = "3BAD4610337E0EF5F8BF22A9BBBB2B17", hash_generated_method = "D9F2ED66A137FDF3FB1BBC11AC6C9B35")
    public void setForceIgnoreOutsideTouch(boolean forceIgnoreOutsideTouch) {
        mPopup.setForceIgnoreOutsideTouch(forceIgnoreOutsideTouch);
        addTaint(forceIgnoreOutsideTouch);
        // ---------- Original Method ----------
        //mPopup.setForceIgnoreOutsideTouch(forceIgnoreOutsideTouch);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.933 -0400", hash_original_method = "DD23AC9F9BC11D23FC9B33CDFA0AE577", hash_generated_method = "E41C87D66B96C7DF895D531965A09E0A")
    private void buildImeCompletions() {
        ListAdapter adapter;
        adapter = mAdapter;
        {
            InputMethodManager imm;
            imm = InputMethodManager.peekInstance();
            {
                int count;
                count = Math.min(adapter.getCount(), 20);
                CompletionInfo[] completions;
                completions = new CompletionInfo[count];
                int realCount;
                realCount = 0;
                {
                    int i;
                    i = 0;
                    {
                        {
                            boolean var80DA9CC47A088166826473F71AF20B64_1297793317 = (adapter.isEnabled(i));
                            {
                                Object item;
                                item = adapter.getItem(i);
                                long id;
                                id = adapter.getItemId(i);
                                completions[i] = new CompletionInfo(id, i, convertSelectionToString(item));
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                {
                    CompletionInfo[] tmp;
                    tmp = new CompletionInfo[realCount];
                    System.arraycopy(completions, 0, tmp, 0, realCount);
                    completions = tmp;
                } //End block
                imm.displayCompletions(this, completions);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.934 -0400", hash_original_method = "19381912498DA3D1F08FF4D2E33BF7A7", hash_generated_method = "6329C8E47F79ED3E974714DEACCABB5F")
    public void setValidator(Validator validator) {
        mValidator = validator;
        // ---------- Original Method ----------
        //mValidator = validator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.934 -0400", hash_original_method = "E2B844337B4F2E764213661E3DB17BC8", hash_generated_method = "C86A326128F0428BB94D806A0087CD68")
    public Validator getValidator() {
        Validator varB4EAC82CA7396A68D541C85D26508E83_1782671739 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1782671739 = mValidator;
        varB4EAC82CA7396A68D541C85D26508E83_1782671739.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1782671739;
        // ---------- Original Method ----------
        //return mValidator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.938 -0400", hash_original_method = "6C87320109B091D88082BE6479926B64", hash_generated_method = "37615EF7CBB0BED0328B924434C3C88D")
    public void performValidation() {
        CharSequence text;
        text = getText();
        {
            boolean varEEC51FF3E573EAB5A8EA2A7F5E6B2AEF_1175343239 = (!TextUtils.isEmpty(text) && !mValidator.isValid(text));
            {
                setText(mValidator.fixText(text));
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (mValidator == null) return;
        //CharSequence text = getText();
        //if (!TextUtils.isEmpty(text) && !mValidator.isValid(text)) {
            //setText(mValidator.fixText(text));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.939 -0400", hash_original_method = "A182F1708C145D57F0135D6BE7F61F0B", hash_generated_method = "E9078CDF2681A14E7AB73A437DBFB747")
    protected Filter getFilter() {
        Filter varB4EAC82CA7396A68D541C85D26508E83_2061171492 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2061171492 = mFilter;
        varB4EAC82CA7396A68D541C85D26508E83_2061171492.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2061171492;
        // ---------- Original Method ----------
        //return mFilter;
    }

    
    private class MyWatcher implements TextWatcher {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.940 -0400", hash_original_method = "25E4BE534CF40240061ABF020C9D68F0", hash_generated_method = "25E4BE534CF40240061ABF020C9D68F0")
        public MyWatcher ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.953 -0400", hash_original_method = "595E81F8C2CD078134C2C0CD5C188C48", hash_generated_method = "D4BF2CE132E1B2D7E52881CE9873E33B")
        public void afterTextChanged(Editable s) {
            doAfterTextChanged();
            addTaint(s.getTaint());
            // ---------- Original Method ----------
            //doAfterTextChanged();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.954 -0400", hash_original_method = "BC2E54553D15961DF2A438BC2F30EBE4", hash_generated_method = "1D3F488EF9A6DDE5A1689B1AB3CA4601")
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            doBeforeTextChanged();
            addTaint(s.getTaint());
            addTaint(start);
            addTaint(count);
            addTaint(after);
            // ---------- Original Method ----------
            //doBeforeTextChanged();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.954 -0400", hash_original_method = "65C508C8ABB6ACC44B70A081DD077416", hash_generated_method = "AB53F3EBF150FBCBE879390E7BF86D96")
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(s.getTaint());
            addTaint(start);
            addTaint(before);
            addTaint(count);
            // ---------- Original Method ----------
        }

        
    }


    
    private class DropDownItemClickListener implements AdapterView.OnItemClickListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.954 -0400", hash_original_method = "8B63FBEE4316EEB2311D787C7564687C", hash_generated_method = "8B63FBEE4316EEB2311D787C7564687C")
        public DropDownItemClickListener ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.954 -0400", hash_original_method = "4F7C82DB77A3FEF0D877BA2AB4932B41", hash_generated_method = "8CD27B33394371A9A8927398E103F62E")
        public void onItemClick(AdapterView parent, View v, int position, long id) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            performCompletion(v, position, id);
            addTaint(parent.getTaint());
            addTaint(v.getTaint());
            addTaint(position);
            addTaint(id);
            // ---------- Original Method ----------
            //performCompletion(v, position, id);
        }

        
    }


    
    private class PassThroughClickListener implements OnClickListener {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.955 -0400", hash_original_field = "B7CE96B7646AE9C0D4A917FBF1A25931", hash_generated_field = "7D6A8796716A6CBC9C60BD4061851E68")

        private View.OnClickListener mWrapped;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.960 -0400", hash_original_method = "DBB7AAAD00FA07F6102A2DD0869EFBF7", hash_generated_method = "DBB7AAAD00FA07F6102A2DD0869EFBF7")
        public PassThroughClickListener ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.960 -0400", hash_original_method = "E3F762E6FD76D99B402BD097AF1F93E6", hash_generated_method = "4C8B96ECA88AD1CD8A3AA92FA9829E8F")
        public void onClick(View v) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            onClickImpl();
            mWrapped.onClick(v);
            addTaint(v.getTaint());
            // ---------- Original Method ----------
            //onClickImpl();
            //if (mWrapped != null) mWrapped.onClick(v);
        }

        
    }


    
    private class PopupDataSetObserver extends DataSetObserver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.961 -0400", hash_original_method = "2B87497157622859499FF49FBED7C822", hash_generated_method = "2B87497157622859499FF49FBED7C822")
        public PopupDataSetObserver ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.968 -0400", hash_original_method = "E1ADD1CC7F155CD4BE00BE335F96E1E6", hash_generated_method = "0BABFF4BA104A02F8BB8DF0C779616AB")
        @Override
        public void onChanged() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                post(new Runnable() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.967 -0400", hash_original_method = "C1C8572D4CABAA4D9D14EF8392DA725A", hash_generated_method = "7C35BB640D9B77A86C8F65E3682D3D6D")
                    public void run() {
                        ListAdapter adapter;
                        adapter = mAdapter;
                        {
                            updateDropDownForFilter(adapter.getCount());
                        } //End block
                        // ---------- Original Method ----------
                        //final ListAdapter adapter = mAdapter;
                        //if (adapter != null) {
                            //updateDropDownForFilter(adapter.getCount());
                        //}
                    }
});
            } //End block
            // ---------- Original Method ----------
            //if (mAdapter != null) {
                //post(new Runnable() {
                    //public void run() {
                        //final ListAdapter adapter = mAdapter;
                        //if (adapter != null) {
                            //updateDropDownForFilter(adapter.getCount());
                        //}
                    //}
                //});
            //}
        }

        
    }


    
    public interface Validator {
        
        boolean isValid(CharSequence text);

        
        CharSequence fixText(CharSequence invalidText);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.973 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "99DFF1318F5BF79C590B7B00A696225C")

    static boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.973 -0400", hash_original_field = "C365BBDB987278C0C402C79C0A858962", hash_generated_field = "E2BEA15E1ADBAE7CB13C0A33096AD91D")

    static String TAG = "AutoCompleteTextView";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.973 -0400", hash_original_field = "EE6AECF4EFFC59776F3FA81450B77B44", hash_generated_field = "48B2A015F8A1CA8D34650479A24A19B2")

    static int EXPAND_MAX = 3;
}

