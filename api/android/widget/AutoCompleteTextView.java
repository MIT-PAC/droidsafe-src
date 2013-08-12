package android.widget;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.685 -0400", hash_original_field = "E1CABE1E2EB0E02B938A46A1B7A0EBFD", hash_generated_field = "1FDB4027FDC409C38C96D7C7129240A3")

    private CharSequence mHintText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.685 -0400", hash_original_field = "16B58D4213ECFB0245D924E5499952EB", hash_generated_field = "3A9494D52ECD891CDD06D9FB033B0410")

    private TextView mHintView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.685 -0400", hash_original_field = "935E8213B379645517C175727BFECCFA", hash_generated_field = "83A803468B3B4450D753F58C9690FCF8")

    private int mHintResource;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.685 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "90F29768206AB431EA361CD94838716F")

    private ListAdapter mAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.685 -0400", hash_original_field = "C781ED17A87FBE09F8079C6EC63D1F26", hash_generated_field = "A13F7A33CB1B9B8C8BC52C7A25894515")

    private Filter mFilter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.685 -0400", hash_original_field = "3C3C53D359DFC0BF874C1D7D1521B140", hash_generated_field = "2B2FC0AB3F9DED44C14A982417EA1993")

    private int mThreshold;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.685 -0400", hash_original_field = "E863CEB96C01242A6262A422DC21BA91", hash_generated_field = "8997F2E1258B500A89588C7ED08EDAF2")

    private ListPopupWindow mPopup;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.685 -0400", hash_original_field = "903BD9B69A445B253D97DFE9C11F5514", hash_generated_field = "AA79DCF4F4AF02E5E4FD88F114FC4A45")

    private int mDropDownAnchorId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.685 -0400", hash_original_field = "1AE585B9A4195C50494CD4717922829E", hash_generated_field = "91F251C39E992AB6E9A1F97E1DB2D65A")

    private AdapterView.OnItemClickListener mItemClickListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.685 -0400", hash_original_field = "AC663E6C1E4BAD60BFB3B64BE97350A7", hash_generated_field = "B20A14E839638431419A27C6FA2EB183")

    private AdapterView.OnItemSelectedListener mItemSelectedListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.685 -0400", hash_original_field = "3010C19D73E606ACA829805F2EC4AF2C", hash_generated_field = "F2A9684F0F8098ECC6D91A395F94C973")

    private boolean mDropDownDismissedOnCompletion = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.685 -0400", hash_original_field = "B1F84A8F9072BD31689628A95AABAE5F", hash_generated_field = "202A96DE332795BB4B1FEBF0146D898F")

    private int mLastKeyCode = KeyEvent.KEYCODE_UNKNOWN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.685 -0400", hash_original_field = "D352E44EC37B3483025E4C3E786315A7", hash_generated_field = "DF21E3DF0E1F480F88152014C172C190")

    private boolean mOpenBefore;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.686 -0400", hash_original_field = "3AAD6DF18105DD8AC1D710531E7A2098", hash_generated_field = "174452E4EA6CBBEFAC61139138443140")

    private Validator mValidator = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.686 -0400", hash_original_field = "FFA1B57EE05E9FF9A47A264C76446CB7", hash_generated_field = "F75A9D78378413BAF88541599A31BF41")

    private boolean mBlockCompletion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.686 -0400", hash_original_field = "25E1729F4969B02B4D30E52EF1ABB195", hash_generated_field = "4C4FE9E3F67714CCAEF17C0AFE9B8BC4")

    private boolean mPopupCanBeUpdated = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.686 -0400", hash_original_field = "3AA8F11C0A37ED86BB0928D842CD212E", hash_generated_field = "EBF3BC0102B69BA2B0B114608A6AF073")

    private PassThroughClickListener mPassThroughClickListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.686 -0400", hash_original_field = "C61FA2E7C36AC7AB9C40A5C4B482DC3A", hash_generated_field = "0623EBBCEF1FE0FD7F127A32EDBCAFCC")

    private PopupDataSetObserver mObserver;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.686 -0400", hash_original_method = "25FDD5DBEC32252B7FC5EA7A3C1328DA", hash_generated_method = "87D0E3C2A13969937ECA57F44C36F265")
    public  AutoCompleteTextView(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.686 -0400", hash_original_method = "37425D654E09169E65BAA252CC2C351E", hash_generated_method = "3E34311E45ABA26ED4156F15AE55D952")
    public  AutoCompleteTextView(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.autoCompleteTextViewStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.688 -0400", hash_original_method = "E7A1365EE4283D79F23C38EBF5E5D299", hash_generated_method = "663241ECB4A3A3B2DBE51BDBC7F2F94A")
    public  AutoCompleteTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(defStyle);
        mPopup = new ListPopupWindow(context, attrs,
                com.android.internal.R.attr.autoCompleteTextViewStyle);
        mPopup.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        mPopup.setPromptPosition(ListPopupWindow.POSITION_PROMPT_BELOW);
        TypedArray a = context.obtainStyledAttributes(
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
        int inputType = getInputType();
        if((inputType&EditorInfo.TYPE_MASK_CLASS)
                == EditorInfo.TYPE_CLASS_TEXT)        
        {
            inputType |= EditorInfo.TYPE_TEXT_FLAG_AUTO_COMPLETE;
            setRawInputType(inputType);
        } //End block
        a.recycle();
        setFocusable(true);
        addTextChangedListener(new MyWatcher());
        mPassThroughClickListener = new PassThroughClickListener();
        super.setOnClickListener(mPassThroughClickListener);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.689 -0400", hash_original_method = "C1942F3D6CF625065E36951B3C995636", hash_generated_method = "8FAF35C11E127607F0937D7E984024B4")
    @Override
    public void setOnClickListener(OnClickListener listener) {
        mPassThroughClickListener.mWrapped = listener;
        // ---------- Original Method ----------
        //mPassThroughClickListener.mWrapped = listener;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.689 -0400", hash_original_method = "58D3202231E1A3AE7FD8546C3F8B5C86", hash_generated_method = "5E8318BD6AE816BF6A553349975BDD5C")
    private void onClickImpl() {
        if(isPopupShowing())        
        {
            ensureImeVisible(true);
        } //End block
        // ---------- Original Method ----------
        //if (isPopupShowing()) {
            //ensureImeVisible(true);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.690 -0400", hash_original_method = "4F48038C1162C78CAFD13A15CFC4C4E3", hash_generated_method = "492D3AB75492D0D5DBC0FB4F9284E161")
    public void setCompletionHint(CharSequence hint) {
        mHintText = hint;
        if(hint != null)        
        {
            if(mHintView == null)            
            {
                final TextView hintView = (TextView) LayoutInflater.from(getContext()).inflate(
                        mHintResource, null).findViewById(com.android.internal.R.id.text1);
                hintView.setText(mHintText);
                mHintView = hintView;
                mPopup.setPromptView(hintView);
            } //End block
            else
            {
                mHintView.setText(hint);
            } //End block
        } //End block
        else
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.691 -0400", hash_original_method = "0FF617112E6940852CA340238B035B28", hash_generated_method = "47C7254579BBDAD95A9F1E464ACF1188")
    public int getDropDownWidth() {
        int var6ACF8E0E97C75E88C1848D73A7CD5C00_794901753 = (mPopup.getWidth());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_852513111 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_852513111;
        // ---------- Original Method ----------
        //return mPopup.getWidth();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.691 -0400", hash_original_method = "B270189DDD36B930B898EDE5BD590C69", hash_generated_method = "BB33BCBC5406ED655690CDCC1B59C71E")
    public void setDropDownWidth(int width) {
        addTaint(width);
        mPopup.setWidth(width);
        // ---------- Original Method ----------
        //mPopup.setWidth(width);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.691 -0400", hash_original_method = "ED81905DF1626AD5BC656BEBB27BE880", hash_generated_method = "EFC6B908E6A6550AF8DA52B1F2E5D673")
    public int getDropDownHeight() {
        int var53DB8DBAC9CF6169329C2D2133A018EE_1363242356 = (mPopup.getHeight());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1631836044 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1631836044;
        // ---------- Original Method ----------
        //return mPopup.getHeight();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.691 -0400", hash_original_method = "7CEF092BABE0725B932F9B439F9A3AFD", hash_generated_method = "29D91C76191CC89A6DC85A9A64156A6C")
    public void setDropDownHeight(int height) {
        addTaint(height);
        mPopup.setHeight(height);
        // ---------- Original Method ----------
        //mPopup.setHeight(height);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.692 -0400", hash_original_method = "983C379A49D6519E05BB04A2322E89F2", hash_generated_method = "B9A6ECBAEC82BF49C6DA00F503BFBCAC")
    public int getDropDownAnchor() {
        int var903BD9B69A445B253D97DFE9C11F5514_678378770 = (mDropDownAnchorId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1940111282 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1940111282;
        // ---------- Original Method ----------
        //return mDropDownAnchorId;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.692 -0400", hash_original_method = "5971179F1F300FE7DC24F52751CD203A", hash_generated_method = "A178705FF73BC3A9E4C8F5B8D7813F35")
    public void setDropDownAnchor(int id) {
        mDropDownAnchorId = id;
        mPopup.setAnchorView(null);
        // ---------- Original Method ----------
        //mDropDownAnchorId = id;
        //mPopup.setAnchorView(null);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.692 -0400", hash_original_method = "AF968841F9ADA345DD97E068FA7BD610", hash_generated_method = "B8B2752D1972C752D2A980BD9508BB15")
    public Drawable getDropDownBackground() {
Drawable var7BDA07CC732F6A99E383B1984680564C_1654412578 =         mPopup.getBackground();
        var7BDA07CC732F6A99E383B1984680564C_1654412578.addTaint(taint);
        return var7BDA07CC732F6A99E383B1984680564C_1654412578;
        // ---------- Original Method ----------
        //return mPopup.getBackground();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.692 -0400", hash_original_method = "B18D529A578176AD889BDFBA197D2FE9", hash_generated_method = "D7A3D7EE3759C6EF2C394DB339ACBAF5")
    public void setDropDownBackgroundDrawable(Drawable d) {
        addTaint(d.getTaint());
        mPopup.setBackgroundDrawable(d);
        // ---------- Original Method ----------
        //mPopup.setBackgroundDrawable(d);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.693 -0400", hash_original_method = "58B212667945303F92E76684E6DBBAC3", hash_generated_method = "A5EABC29E09BE4E6128A587CCAFC3AA5")
    public void setDropDownBackgroundResource(int id) {
        addTaint(id);
        mPopup.setBackgroundDrawable(getResources().getDrawable(id));
        // ---------- Original Method ----------
        //mPopup.setBackgroundDrawable(getResources().getDrawable(id));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.693 -0400", hash_original_method = "AFE41A06E9A754A352572FB9B075CCA0", hash_generated_method = "C103FEBC890C73F1381DDAADE088373B")
    public void setDropDownVerticalOffset(int offset) {
        addTaint(offset);
        mPopup.setVerticalOffset(offset);
        // ---------- Original Method ----------
        //mPopup.setVerticalOffset(offset);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.693 -0400", hash_original_method = "CD8747B9F2476A0A6006DC41A664E503", hash_generated_method = "AC25E1BAC62696829B058AD89DCBFB30")
    public int getDropDownVerticalOffset() {
        int var31401D924AC0898C93CCD25EA9B41C31_1547477537 = (mPopup.getVerticalOffset());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_144204288 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_144204288;
        // ---------- Original Method ----------
        //return mPopup.getVerticalOffset();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.693 -0400", hash_original_method = "6A22527360686DE12C48E20144984DC3", hash_generated_method = "94460EC6CA68FC3876DDA8F0283AACE5")
    public void setDropDownHorizontalOffset(int offset) {
        addTaint(offset);
        mPopup.setHorizontalOffset(offset);
        // ---------- Original Method ----------
        //mPopup.setHorizontalOffset(offset);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.694 -0400", hash_original_method = "A7584484859282D74A751422BD935CE2", hash_generated_method = "9B5292E4C51A1E36C076E076D1D710EF")
    public int getDropDownHorizontalOffset() {
        int var159CC1985722BBD4B37A689973EEA1E1_1867478397 = (mPopup.getHorizontalOffset());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1431018471 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1431018471;
        // ---------- Original Method ----------
        //return mPopup.getHorizontalOffset();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.694 -0400", hash_original_method = "AB6AF7AB4438F2936FAB5E115855ABD1", hash_generated_method = "2DB8A20E119F934F9A2991689F09D838")
    public void setDropDownAnimationStyle(int animationStyle) {
        addTaint(animationStyle);
        mPopup.setAnimationStyle(animationStyle);
        // ---------- Original Method ----------
        //mPopup.setAnimationStyle(animationStyle);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.694 -0400", hash_original_method = "348942C9B29D455789FBCF016CC929C3", hash_generated_method = "12DD111B6A84A24E41CF325F32282538")
    public int getDropDownAnimationStyle() {
        int var816B0EC48DB4C372BCF76D1AAEC8966A_153272422 = (mPopup.getAnimationStyle());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1584073568 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1584073568;
        // ---------- Original Method ----------
        //return mPopup.getAnimationStyle();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.694 -0400", hash_original_method = "4343F66DAC432AAC8F4BD77081597537", hash_generated_method = "B4CE8D8C26BD87AB6817EBD133DA8ECD")
    public boolean isDropDownAlwaysVisible() {
        boolean var02A603F69D53C1BA03CBBFB8B5937DA3_315078103 = (mPopup.isDropDownAlwaysVisible());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1377070722 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1377070722;
        // ---------- Original Method ----------
        //return mPopup.isDropDownAlwaysVisible();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.694 -0400", hash_original_method = "9D048710298E272B53CC3CA9B767E12A", hash_generated_method = "FD8ED3488F6CA647809E7062D103782E")
    public void setDropDownAlwaysVisible(boolean dropDownAlwaysVisible) {
        addTaint(dropDownAlwaysVisible);
        mPopup.setDropDownAlwaysVisible(dropDownAlwaysVisible);
        // ---------- Original Method ----------
        //mPopup.setDropDownAlwaysVisible(dropDownAlwaysVisible);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.694 -0400", hash_original_method = "5251E63145860B08CE1AA76BBDDDD070", hash_generated_method = "2D80C8CB1D34B9C837528C37DEF42857")
    public boolean isDropDownDismissedOnCompletion() {
        boolean var136ABDC94A753EA99E787B313DCAB6C7_1507967517 = (mDropDownDismissedOnCompletion);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_639255378 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_639255378;
        // ---------- Original Method ----------
        //return mDropDownDismissedOnCompletion;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.694 -0400", hash_original_method = "87D4B20D86EF98CE5F9B2DCFB12777AB", hash_generated_method = "60B8689EC6F3BBAD668A4B2923A0BC91")
    public void setDropDownDismissedOnCompletion(boolean dropDownDismissedOnCompletion) {
        mDropDownDismissedOnCompletion = dropDownDismissedOnCompletion;
        // ---------- Original Method ----------
        //mDropDownDismissedOnCompletion = dropDownDismissedOnCompletion;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.695 -0400", hash_original_method = "D355B3B251BB91FAED293791929579AC", hash_generated_method = "B3D8F963C7057EEC2BB95DD155FE03BB")
    public int getThreshold() {
        int var3C3C53D359DFC0BF874C1D7D1521B140_1485239723 = (mThreshold);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_967155345 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_967155345;
        // ---------- Original Method ----------
        //return mThreshold;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.695 -0400", hash_original_method = "E80EC39EC531963E159919926C4979B9", hash_generated_method = "A38F733A6E1873D0A8C2D8A5F0056964")
    public void setThreshold(int threshold) {
        if(threshold <= 0)        
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.695 -0400", hash_original_method = "B69DF6D8B348285F7F509DAAD23C3372", hash_generated_method = "25CD98E2A8A27C201F3F3F3C7D972CAC")
    public void setOnItemClickListener(AdapterView.OnItemClickListener l) {
        mItemClickListener = l;
        // ---------- Original Method ----------
        //mItemClickListener = l;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.695 -0400", hash_original_method = "48F24F393448111E92CC5CFF766C1584", hash_generated_method = "B7A11EA05B947A6361BE0A6FEA1488E9")
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener l) {
        mItemSelectedListener = l;
        // ---------- Original Method ----------
        //mItemSelectedListener = l;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.695 -0400", hash_original_method = "0AE6D510B9C16F8D52FF49376A7BF6A4", hash_generated_method = "2255C10CAB7BE6A72F9E1B018D3E5A25")
    @Deprecated
    public AdapterView.OnItemClickListener getItemClickListener() {
AdapterView.OnItemClickListener var63013AF3E02932658F997B57B5405EA0_1505496960 =         mItemClickListener;
        var63013AF3E02932658F997B57B5405EA0_1505496960.addTaint(taint);
        return var63013AF3E02932658F997B57B5405EA0_1505496960;
        // ---------- Original Method ----------
        //return mItemClickListener;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.695 -0400", hash_original_method = "2A86C7E057A0C403AB649B0ED567456D", hash_generated_method = "53DBD6EDB3CE6E11E8441152C5E62B86")
    @Deprecated
    public AdapterView.OnItemSelectedListener getItemSelectedListener() {
AdapterView.OnItemSelectedListener var5A4BC6A387706AABAC34DDF7CE11D2B3_1330173129 =         mItemSelectedListener;
        var5A4BC6A387706AABAC34DDF7CE11D2B3_1330173129.addTaint(taint);
        return var5A4BC6A387706AABAC34DDF7CE11D2B3_1330173129;
        // ---------- Original Method ----------
        //return mItemSelectedListener;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.695 -0400", hash_original_method = "CC34C836A582B2E0B6660928CDDA2E79", hash_generated_method = "3FFAAB787A97CF3B93F681CF945E3BDE")
    public AdapterView.OnItemClickListener getOnItemClickListener() {
AdapterView.OnItemClickListener var63013AF3E02932658F997B57B5405EA0_1739108503 =         mItemClickListener;
        var63013AF3E02932658F997B57B5405EA0_1739108503.addTaint(taint);
        return var63013AF3E02932658F997B57B5405EA0_1739108503;
        // ---------- Original Method ----------
        //return mItemClickListener;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.695 -0400", hash_original_method = "CA4C95C3D87D9F2B4999807B4A5E6086", hash_generated_method = "3B2DD8A580382537C44E79A21433606F")
    public AdapterView.OnItemSelectedListener getOnItemSelectedListener() {
AdapterView.OnItemSelectedListener var5A4BC6A387706AABAC34DDF7CE11D2B3_354431831 =         mItemSelectedListener;
        var5A4BC6A387706AABAC34DDF7CE11D2B3_354431831.addTaint(taint);
        return var5A4BC6A387706AABAC34DDF7CE11D2B3_354431831;
        // ---------- Original Method ----------
        //return mItemSelectedListener;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.695 -0400", hash_original_method = "0E1A05724C497F45D7FB6AC34C501814", hash_generated_method = "6AD81C04D17515D4865D091818D8470B")
    public ListAdapter getAdapter() {
ListAdapter varD72668EDE5E63ADF9340F3D8A19FD205_160838299 =         mAdapter;
        varD72668EDE5E63ADF9340F3D8A19FD205_160838299.addTaint(taint);
        return varD72668EDE5E63ADF9340F3D8A19FD205_160838299;
        // ---------- Original Method ----------
        //return mAdapter;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.696 -0400", hash_original_method = "18CB1EEAAEFB5BC2DC3ECE426EBE9928", hash_generated_method = "F0E69E1084FD7B774906C79EDAFD6B58")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.696 -0400", hash_original_method = "1E2534A3F57B1DBFCDE49E1B48E26A0E", hash_generated_method = "317E2657371921BF8B47AD3A49F59E85")
    @Override
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
        if(keyCode == KeyEvent.KEYCODE_BACK && isPopupShowing()
                && !mPopup.isDropDownAlwaysVisible())        
        {
            if(event.getAction() == KeyEvent.ACTION_DOWN && event.getRepeatCount() == 0)            
            {
                KeyEvent.DispatcherState state = getKeyDispatcherState();
                if(state != null)                
                {
                    state.startTracking(event, this);
                } //End block
                boolean varB326B5062B2F0E69046810717534CB09_799833956 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1645176352 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1645176352;
            } //End block
            else
            if(event.getAction() == KeyEvent.ACTION_UP)            
            {
                KeyEvent.DispatcherState state = getKeyDispatcherState();
                if(state != null)                
                {
                    state.handleUpEvent(event);
                } //End block
                if(event.isTracking() && !event.isCanceled())                
                {
                    dismissDropDown();
                    boolean varB326B5062B2F0E69046810717534CB09_667311742 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1748265271 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1748265271;
                } //End block
            } //End block
        } //End block
        boolean varD211DC142BF75E7E3C7CE1C752BD391A_72944304 = (super.onKeyPreIme(keyCode, event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_239560773 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_239560773;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.696 -0400", hash_original_method = "A5021B9859EF1208F776ED0647DC53F8", hash_generated_method = "B41BB61C37B1DAB4A7663D6A77931369")
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
        boolean consumed = mPopup.onKeyUp(keyCode, event);
        if(consumed)        
        {
switch(keyCode){
            case KeyEvent.KEYCODE_ENTER:
            case KeyEvent.KEYCODE_DPAD_CENTER:
            case KeyEvent.KEYCODE_TAB:
            if(event.hasNoModifiers())            
            {
                performCompletion();
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_458963469 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1284349112 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1284349112;
}
        } //End block
        if(isPopupShowing() && keyCode == KeyEvent.KEYCODE_TAB && event.hasNoModifiers())        
        {
            performCompletion();
            boolean varB326B5062B2F0E69046810717534CB09_532940413 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2009880321 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2009880321;
        } //End block
        boolean varAD33E8F21A74B923C1A24761EAF2F4A9_1731954571 = (super.onKeyUp(keyCode, event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_921739896 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_921739896;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.697 -0400", hash_original_method = "7D38CCD4A21A1817640875450034C5D6", hash_generated_method = "2FB558D1E0E073BFC5F0C42333F890B9")
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        if(mPopup.onKeyDown(keyCode, event))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_339450603 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1726514727 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1726514727;
        } //End block
        if(!isPopupShowing())        
        {
switch(keyCode){
            case KeyEvent.KEYCODE_DPAD_DOWN:
            if(event.hasNoModifiers())            
            {
                performValidation();
            } //End block
}
        } //End block
        if(isPopupShowing() && keyCode == KeyEvent.KEYCODE_TAB && event.hasNoModifiers())        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1066346001 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1144959980 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1144959980;
        } //End block
        mLastKeyCode = keyCode;
        boolean handled = super.onKeyDown(keyCode, event);
        mLastKeyCode = KeyEvent.KEYCODE_UNKNOWN;
        if(handled && isPopupShowing())        
        {
            clearListSelection();
        } //End block
        boolean var98F0599AF776A1FE4101C199A40EEB8F_1485293301 = (handled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1649251115 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1649251115;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.697 -0400", hash_original_method = "845425AE754C4142506C6C975210339B", hash_generated_method = "09DAAE7E23694A41DB36CC7CCAC0C672")
    public boolean enoughToFilter() {
        if(DEBUG){ }        boolean var7E8D24952212A6B4F15AC00CF49898E8_600522500 = (getText().length() >= mThreshold);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2066206511 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2066206511;
        // ---------- Original Method ----------
        //if (DEBUG) Log.v(TAG, "Enough to filter: len=" + getText().length()
                //+ " threshold=" + mThreshold);
        //return getText().length() >= mThreshold;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.697 -0400", hash_original_method = "9B68F895919D747E86E2BC0B861C3485", hash_generated_method = "B32951119CDFA0137E74BD67B07EDFC4")
     void doBeforeTextChanged() {
        if(mBlockCompletion)        
        return;
        mOpenBefore = isPopupShowing();
        if(DEBUG){ }
        // ---------- Original Method ----------
        //if (mBlockCompletion) return;
        //mOpenBefore = isPopupShowing();
        //if (DEBUG) Log.v(TAG, "before text changed: open=" + mOpenBefore);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.698 -0400", hash_original_method = "EABD50974341527CEC5D7DC0490BCDC7", hash_generated_method = "D9363D57145018FF8AF72F83B3B302B9")
     void doAfterTextChanged() {
        if(mBlockCompletion)        
        return;
        if(DEBUG){ }        if(mOpenBefore && !isPopupShowing())        
        {
            return;
        } //End block
        if(enoughToFilter())        
        {
            if(mFilter != null)            
            {
                mPopupCanBeUpdated = true;
                performFiltering(getText(), mLastKeyCode);
            } //End block
        } //End block
        else
        {
            if(!mPopup.isDropDownAlwaysVisible())            
            {
                dismissDropDown();
            } //End block
            if(mFilter != null)            
            {
                mFilter.filter(null);
            } //End block
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.698 -0400", hash_original_method = "82AB47D081F83CBFD677A62933F7FE17", hash_generated_method = "5A50041A038444B690E1A4D168224A7F")
    public boolean isPopupShowing() {
        boolean var85306F04F495AA80A9692FCC104D9D40_1843070757 = (mPopup.isShowing());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1482180572 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1482180572;
        // ---------- Original Method ----------
        //return mPopup.isShowing();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.698 -0400", hash_original_method = "5BE18D1BCEE667E3D32BBF42EAB5125A", hash_generated_method = "66D4DD5FE656D3D891C3C1F31F848D6C")
    protected CharSequence convertSelectionToString(Object selectedItem) {
        addTaint(selectedItem.getTaint());
CharSequence varAF827B06EB9498287FA55CEAE7AD5953_488430523 =         mFilter.convertResultToString(selectedItem);
        varAF827B06EB9498287FA55CEAE7AD5953_488430523.addTaint(taint);
        return varAF827B06EB9498287FA55CEAE7AD5953_488430523;
        // ---------- Original Method ----------
        //return mFilter.convertResultToString(selectedItem);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.698 -0400", hash_original_method = "7623D1558693BF470F22C595BECC6733", hash_generated_method = "8B3C8ABD4877B8477A9502489B2E9EE7")
    public void clearListSelection() {
        mPopup.clearListSelection();
        // ---------- Original Method ----------
        //mPopup.clearListSelection();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.698 -0400", hash_original_method = "133DE5DB01039801737429C3DDB0411B", hash_generated_method = "4AE18AF13A4E39A286D3C559313AEE51")
    public void setListSelection(int position) {
        addTaint(position);
        mPopup.setSelection(position);
        // ---------- Original Method ----------
        //mPopup.setSelection(position);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.698 -0400", hash_original_method = "FACA63936D6E82D9A31B7F667F19A5C4", hash_generated_method = "75A4464C8732B3D6788F2AA76ED1D878")
    public int getListSelection() {
        int varC888F4F4BE85ABF5A33D518B7D405315_905255374 = (mPopup.getSelectedItemPosition());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1418522191 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1418522191;
        // ---------- Original Method ----------
        //return mPopup.getSelectedItemPosition();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.698 -0400", hash_original_method = "6D2AAF11ECF28F40F16EC0FF58DB7391", hash_generated_method = "6B515124C869DE51A23103EA5AD774FE")
    @SuppressWarnings({ "UnusedDeclaration" })
    protected void performFiltering(CharSequence text, int keyCode) {
        addTaint(keyCode);
        addTaint(text.getTaint());
        mFilter.filter(text, this);
        // ---------- Original Method ----------
        //mFilter.filter(text, this);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.698 -0400", hash_original_method = "F704ACEA98F83F3E1219E92B20BE03DA", hash_generated_method = "A721540EC82B1346CA97B5580BF1819C")
    public void performCompletion() {
        performCompletion(null, -1, -1);
        // ---------- Original Method ----------
        //performCompletion(null, -1, -1);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.699 -0400", hash_original_method = "4C402F357E20A5DEEC78C01A554F2E74", hash_generated_method = "14CA78410D2108E448E52272D64884E2")
    @Override
    public void onCommitCompletion(CompletionInfo completion) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(completion.getTaint());
        if(isPopupShowing())        
        {
            mPopup.performItemClick(completion.getPosition());
        } //End block
        // ---------- Original Method ----------
        //if (isPopupShowing()) {
            //mPopup.performItemClick(completion.getPosition());
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.699 -0400", hash_original_method = "87F4A447D592D0FFBC34508A48276E40", hash_generated_method = "7F957E394606C5D79841CB53DEA0413B")
    private void performCompletion(View selectedView, int position, long id) {
        addTaint(id);
        addTaint(position);
        addTaint(selectedView.getTaint());
        if(isPopupShowing())        
        {
            Object selectedItem;
            if(position < 0)            
            {
                selectedItem = mPopup.getSelectedItem();
            } //End block
            else
            {
                selectedItem = mAdapter.getItem(position);
            } //End block
            if(selectedItem == null)            
            {
                return;
            } //End block
            mBlockCompletion = true;
            replaceText(convertSelectionToString(selectedItem));
            mBlockCompletion = false;
            if(mItemClickListener != null)            
            {
                final ListPopupWindow list = mPopup;
                if(selectedView == null || position < 0)                
                {
                    selectedView = list.getSelectedView();
                    position = list.getSelectedItemPosition();
                    id = list.getSelectedItemId();
                } //End block
                mItemClickListener.onItemClick(list.getListView(), selectedView, position, id);
            } //End block
        } //End block
        if(mDropDownDismissedOnCompletion && !mPopup.isDropDownAlwaysVisible())        
        {
            dismissDropDown();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.700 -0400", hash_original_method = "01D38330C874C1244C7D1EF978D11C36", hash_generated_method = "D8492CD3A2B2D1C1AFC32BF3C2005006")
    public boolean isPerformingCompletion() {
        boolean varFFA1B57EE05E9FF9A47A264C76446CB7_1677194998 = (mBlockCompletion);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1467390690 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1467390690;
        // ---------- Original Method ----------
        //return mBlockCompletion;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.700 -0400", hash_original_method = "3F95D8A8308B140C895762391C3A32C6", hash_generated_method = "502A82D0190EA626125A51B291042371")
    public void setText(CharSequence text, boolean filter) {
        addTaint(filter);
        addTaint(text.getTaint());
        if(filter)        
        {
            setText(text);
        } //End block
        else
        {
            mBlockCompletion = true;
            setText(text);
            mBlockCompletion = false;
        } //End block
        // ---------- Original Method ----------
        //if (filter) {
            //setText(text);
        //} else {
            //mBlockCompletion = true;
            //setText(text);
            //mBlockCompletion = false;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.701 -0400", hash_original_method = "BFA04BF25DCE9275294E0FA186DED6C8", hash_generated_method = "6D3E284F49A0F5BF9F434A5C3D46D92D")
    protected void replaceText(CharSequence text) {
        addTaint(text.getTaint());
        clearComposingText();
        setText(text);
        Editable spannable = getText();
        Selection.setSelection(spannable, spannable.length());
        // ---------- Original Method ----------
        //clearComposingText();
        //setText(text);
        //Editable spannable = getText();
        //Selection.setSelection(spannable, spannable.length());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.701 -0400", hash_original_method = "65C6B6A3B92536D4DF6F13E8CB596A16", hash_generated_method = "101B997E74F395C01333B0250263A6F9")
    public void onFilterComplete(int count) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(count);
        updateDropDownForFilter(count);
        // ---------- Original Method ----------
        //updateDropDownForFilter(count);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.701 -0400", hash_original_method = "43BA40231E8A8ECAF857BC9AE8C4397B", hash_generated_method = "AAAD29A240B6514A486D7B7FC0F2D174")
    private void updateDropDownForFilter(int count) {
        addTaint(count);
        if(getWindowVisibility() == View.GONE)        
        return;
        final boolean dropDownAlwaysVisible = mPopup.isDropDownAlwaysVisible();
        final boolean enoughToFilter = enoughToFilter();
        if((count > 0 || dropDownAlwaysVisible) && enoughToFilter)        
        {
            if(hasFocus() && hasWindowFocus() && mPopupCanBeUpdated)            
            {
                showDropDown();
            } //End block
        } //End block
        else
        if(!dropDownAlwaysVisible && isPopupShowing())        
        {
            dismissDropDown();
            mPopupCanBeUpdated = true;
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.702 -0400", hash_original_method = "2BBFCFB03CA88D4E4428D247CF9B4D7A", hash_generated_method = "419E5AB1B85DD44104CE527A82C564F1")
    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(hasWindowFocus);
        super.onWindowFocusChanged(hasWindowFocus);
        if(!hasWindowFocus && !mPopup.isDropDownAlwaysVisible())        
        {
            dismissDropDown();
        } //End block
        // ---------- Original Method ----------
        //super.onWindowFocusChanged(hasWindowFocus);
        //if (!hasWindowFocus && !mPopup.isDropDownAlwaysVisible()) {
            //dismissDropDown();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.702 -0400", hash_original_method = "42E246C35216D3D5148B04B4E2B23F4A", hash_generated_method = "9EEAB759C38126E1DF37DB6985B22710")
    @Override
    protected void onDisplayHint(int hint) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(hint);
        super.onDisplayHint(hint);
switch(hint){
        case INVISIBLE:
        if(!mPopup.isDropDownAlwaysVisible())        
        {
            dismissDropDown();
        } //End block
        break;
}
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.702 -0400", hash_original_method = "28987A1F68AF8291400818B9FA8A6C7A", hash_generated_method = "EF0295E476FF7952BCC10A6EC62B3F06")
    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(previouslyFocusedRect.getTaint());
        addTaint(direction);
        addTaint(focused);
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        if(!focused)        
        {
            performValidation();
        } //End block
        if(!focused && !mPopup.isDropDownAlwaysVisible())        
        {
            dismissDropDown();
        } //End block
        // ---------- Original Method ----------
        //super.onFocusChanged(focused, direction, previouslyFocusedRect);
        //if (!focused) {
            //performValidation();
        //}
        //if (!focused && !mPopup.isDropDownAlwaysVisible()) {
            //dismissDropDown();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.702 -0400", hash_original_method = "7A2D6EDAA0E5981DC60C5747420510C2", hash_generated_method = "00FC054FE7DDC1542F03A4EEE8C79AC6")
    @Override
    protected void onAttachedToWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onAttachedToWindow();
        // ---------- Original Method ----------
        //super.onAttachedToWindow();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.703 -0400", hash_original_method = "DD8C719D50846B220D8C588E856246EC", hash_generated_method = "3B133B89A062F2ACA8F9A841C10030DC")
    @Override
    protected void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dismissDropDown();
        super.onDetachedFromWindow();
        // ---------- Original Method ----------
        //dismissDropDown();
        //super.onDetachedFromWindow();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.703 -0400", hash_original_method = "B307D50FE74ACB01B1CCF5403B3C4263", hash_generated_method = "A7C42EF76CE432B682880B73ABD64569")
    public void dismissDropDown() {
        InputMethodManager imm = InputMethodManager.peekInstance();
        if(imm != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.703 -0400", hash_original_method = "8B7584A552A003B9ACCE9D0FC992FC50", hash_generated_method = "27B2F92694AA9C88B3570205BF8D8BF7")
    @Override
    protected boolean setFrame(final int l, int t, final int r, int b) {
        addTaint(b);
        addTaint(r);
        addTaint(t);
        addTaint(l);
        boolean result = super.setFrame(l, t, r, b);
        if(isPopupShowing())        
        {
            showDropDown();
        } //End block
        boolean varB4A88417B3D0170D754C647C30B7216A_1054752573 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1462773039 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1462773039;
        // ---------- Original Method ----------
        //boolean result = super.setFrame(l, t, r, b);
        //if (isPopupShowing()) {
            //showDropDown();
        //}
        //return result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.704 -0400", hash_original_method = "E5B4D0CB7911E0BF332298A12D86AD4A", hash_generated_method = "A9417F64F27E0248C39106ECDBA36D11")
    public void showDropDownAfterLayout() {
        mPopup.postShow();
        // ---------- Original Method ----------
        //mPopup.postShow();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.704 -0400", hash_original_method = "E55E3CC7F05D9D6DD7DBC4A161FF882F", hash_generated_method = "051C95117151B443F9082D0AD48C2491")
    public void ensureImeVisible(boolean visible) {
        addTaint(visible);
        mPopup.setInputMethodMode(visible
                ? ListPopupWindow.INPUT_METHOD_NEEDED : ListPopupWindow.INPUT_METHOD_NOT_NEEDED);
        showDropDown();
        // ---------- Original Method ----------
        //mPopup.setInputMethodMode(visible
                //? ListPopupWindow.INPUT_METHOD_NEEDED : ListPopupWindow.INPUT_METHOD_NOT_NEEDED);
        //showDropDown();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.704 -0400", hash_original_method = "16FCF16EE4527CEC1661452DABA1BD86", hash_generated_method = "F6C0A9F9255DD39F3D99B459E798DC67")
    public boolean isInputMethodNotNeeded() {
        boolean var597C2240CA1A3462E67A3E88FFFF4617_71034413 = (mPopup.getInputMethodMode() == ListPopupWindow.INPUT_METHOD_NOT_NEEDED);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1372964327 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1372964327;
        // ---------- Original Method ----------
        //return mPopup.getInputMethodMode() == ListPopupWindow.INPUT_METHOD_NOT_NEEDED;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.704 -0400", hash_original_method = "D361024BEE5BA43B42AED822B3CFC4B1", hash_generated_method = "680322F6C0D809F07B2686D8886794F1")
    public void showDropDown() {
        buildImeCompletions();
        if(mPopup.getAnchorView() == null)        
        {
            if(mDropDownAnchorId != View.NO_ID)            
            {
                mPopup.setAnchorView(getRootView().findViewById(mDropDownAnchorId));
            } //End block
            else
            {
                mPopup.setAnchorView(this);
            } //End block
        } //End block
        if(!isPopupShowing())        
        {
            mPopup.setInputMethodMode(ListPopupWindow.INPUT_METHOD_NEEDED);
            mPopup.setListItemExpandMax(EXPAND_MAX);
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.705 -0400", hash_original_method = "3BAD4610337E0EF5F8BF22A9BBBB2B17", hash_generated_method = "9CAB43A5A6BF3AEAA949B77F4C12F4DA")
    public void setForceIgnoreOutsideTouch(boolean forceIgnoreOutsideTouch) {
        addTaint(forceIgnoreOutsideTouch);
        mPopup.setForceIgnoreOutsideTouch(forceIgnoreOutsideTouch);
        // ---------- Original Method ----------
        //mPopup.setForceIgnoreOutsideTouch(forceIgnoreOutsideTouch);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.705 -0400", hash_original_method = "DD23AC9F9BC11D23FC9B33CDFA0AE577", hash_generated_method = "2156FC9816750186C2019DB784D4B9CB")
    private void buildImeCompletions() {
        final ListAdapter adapter = mAdapter;
        if(adapter != null)        
        {
            InputMethodManager imm = InputMethodManager.peekInstance();
            if(imm != null)            
            {
                final int count = Math.min(adapter.getCount(), 20);
                CompletionInfo[] completions = new CompletionInfo[count];
                int realCount = 0;
for(int i = 0;i < count;i++)
                {
                    if(adapter.isEnabled(i))                    
                    {
                        realCount++;
                        Object item = adapter.getItem(i);
                        long id = adapter.getItemId(i);
                        completions[i] = new CompletionInfo(id, i, convertSelectionToString(item));
                    } //End block
                } //End block
                if(realCount != count)                
                {
                    CompletionInfo[] tmp = new CompletionInfo[realCount];
                    System.arraycopy(completions, 0, tmp, 0, realCount);
                    completions = tmp;
                } //End block
                imm.displayCompletions(this, completions);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.705 -0400", hash_original_method = "19381912498DA3D1F08FF4D2E33BF7A7", hash_generated_method = "6329C8E47F79ED3E974714DEACCABB5F")
    public void setValidator(Validator validator) {
        mValidator = validator;
        // ---------- Original Method ----------
        //mValidator = validator;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.706 -0400", hash_original_method = "E2B844337B4F2E764213661E3DB17BC8", hash_generated_method = "5A2106623419BBBD57BC6BEC7CF132F2")
    public Validator getValidator() {
Validator varA82B8BDD631A19AD77E1590146D034EB_558694394 =         mValidator;
        varA82B8BDD631A19AD77E1590146D034EB_558694394.addTaint(taint);
        return varA82B8BDD631A19AD77E1590146D034EB_558694394;
        // ---------- Original Method ----------
        //return mValidator;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.706 -0400", hash_original_method = "6C87320109B091D88082BE6479926B64", hash_generated_method = "7E21749001ADC6B90AA6C1F40FF916DC")
    public void performValidation() {
        if(mValidator == null)        
        return;
        CharSequence text = getText();
        if(!TextUtils.isEmpty(text) && !mValidator.isValid(text))        
        {
            setText(mValidator.fixText(text));
        } //End block
        // ---------- Original Method ----------
        //if (mValidator == null) return;
        //CharSequence text = getText();
        //if (!TextUtils.isEmpty(text) && !mValidator.isValid(text)) {
            //setText(mValidator.fixText(text));
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.706 -0400", hash_original_method = "A182F1708C145D57F0135D6BE7F61F0B", hash_generated_method = "D2F2CEA93140B3FE0A52CCCA8CA9E082")
    protected Filter getFilter() {
Filter var6104E4BD549FCD2640641D136DD683A6_347588412 =         mFilter;
        var6104E4BD549FCD2640641D136DD683A6_347588412.addTaint(taint);
        return var6104E4BD549FCD2640641D136DD683A6_347588412;
        // ---------- Original Method ----------
        //return mFilter;
    }

    
    private class MyWatcher implements TextWatcher {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.706 -0400", hash_original_method = "25E4BE534CF40240061ABF020C9D68F0", hash_generated_method = "25E4BE534CF40240061ABF020C9D68F0")
        public MyWatcher ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.706 -0400", hash_original_method = "595E81F8C2CD078134C2C0CD5C188C48", hash_generated_method = "B89158CBF311B73D27DDB7EC0BFC3BFE")
        public void afterTextChanged(Editable s) {
            addTaint(s.getTaint());
            doAfterTextChanged();
            // ---------- Original Method ----------
            //doAfterTextChanged();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.706 -0400", hash_original_method = "BC2E54553D15961DF2A438BC2F30EBE4", hash_generated_method = "E67207FF036200717E23CE52ADCCD6EF")
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            addTaint(after);
            addTaint(count);
            addTaint(start);
            addTaint(s.getTaint());
            doBeforeTextChanged();
            // ---------- Original Method ----------
            //doBeforeTextChanged();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.707 -0400", hash_original_method = "65C508C8ABB6ACC44B70A081DD077416", hash_generated_method = "A21233C596673F70242F69FE5FA27133")
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(count);
            addTaint(before);
            addTaint(start);
            addTaint(s.getTaint());
            // ---------- Original Method ----------
        }

        
    }


    
    private class DropDownItemClickListener implements AdapterView.OnItemClickListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.707 -0400", hash_original_method = "8B63FBEE4316EEB2311D787C7564687C", hash_generated_method = "8B63FBEE4316EEB2311D787C7564687C")
        public DropDownItemClickListener ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.707 -0400", hash_original_method = "4F7C82DB77A3FEF0D877BA2AB4932B41", hash_generated_method = "ED5B0C046944C5FF7A457F07C3A0A6CB")
        public void onItemClick(AdapterView parent, View v, int position, long id) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(id);
            addTaint(position);
            addTaint(v.getTaint());
            addTaint(parent.getTaint());
            performCompletion(v, position, id);
            // ---------- Original Method ----------
            //performCompletion(v, position, id);
        }

        
    }


    
    private class PassThroughClickListener implements OnClickListener {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.707 -0400", hash_original_field = "B7CE96B7646AE9C0D4A917FBF1A25931", hash_generated_field = "7D6A8796716A6CBC9C60BD4061851E68")

        private View.OnClickListener mWrapped;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.707 -0400", hash_original_method = "DBB7AAAD00FA07F6102A2DD0869EFBF7", hash_generated_method = "DBB7AAAD00FA07F6102A2DD0869EFBF7")
        public PassThroughClickListener ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.707 -0400", hash_original_method = "E3F762E6FD76D99B402BD097AF1F93E6", hash_generated_method = "1BD340F73188B85578EB1A140C1C4DFD")
        public void onClick(View v) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(v.getTaint());
            onClickImpl();
            if(mWrapped != null)            
            mWrapped.onClick(v);
            // ---------- Original Method ----------
            //onClickImpl();
            //if (mWrapped != null) mWrapped.onClick(v);
        }

        
    }


    
    private class PopupDataSetObserver extends DataSetObserver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.707 -0400", hash_original_method = "2B87497157622859499FF49FBED7C822", hash_generated_method = "2B87497157622859499FF49FBED7C822")
        public PopupDataSetObserver ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.708 -0400", hash_original_method = "E1ADD1CC7F155CD4BE00BE335F96E1E6", hash_generated_method = "DECD7F31845C3CC4A02C7173649C17A1")
        @Override
        public void onChanged() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            if(mAdapter != null)            
            {
                post(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.708 -0400", hash_original_method = "C1C8572D4CABAA4D9D14EF8392DA725A", hash_generated_method = "BAC524A6A75756F40505C1924C655E2A")
            public void run() {
                final ListAdapter adapter = mAdapter;
                if(adapter != null)                
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.708 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "F09208C088E716A2CD36A97B937BB5EA")

    static final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.709 -0400", hash_original_field = "C365BBDB987278C0C402C79C0A858962", hash_generated_field = "747049ADD59E7427B505A8078EF2569B")

    static final String TAG = "AutoCompleteTextView";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.709 -0400", hash_original_field = "EE6AECF4EFFC59776F3FA81450B77B44", hash_generated_field = "50DC5A53A7642176DA288042E8938B92")

    static final int EXPAND_MAX = 3;
}

