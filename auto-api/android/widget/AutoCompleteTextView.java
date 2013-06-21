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
    private CharSequence mHintText;
    private TextView mHintView;
    private int mHintResource;
    private ListAdapter mAdapter;
    private Filter mFilter;
    private int mThreshold;
    private ListPopupWindow mPopup;
    private int mDropDownAnchorId;
    private AdapterView.OnItemClickListener mItemClickListener;
    private AdapterView.OnItemSelectedListener mItemSelectedListener;
    private boolean mDropDownDismissedOnCompletion = true;
    private int mLastKeyCode = KeyEvent.KEYCODE_UNKNOWN;
    private boolean mOpenBefore;
    private Validator mValidator = null;
    private boolean mBlockCompletion;
    private boolean mPopupCanBeUpdated = true;
    private PassThroughClickListener mPassThroughClickListener;
    private PopupDataSetObserver mObserver;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.316 -0400", hash_original_method = "25FDD5DBEC32252B7FC5EA7A3C1328DA", hash_generated_method = "FBA6F782EA52D0B73DD40B182745BEDF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AutoCompleteTextView(Context context) {
        this(context, null);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.317 -0400", hash_original_method = "37425D654E09169E65BAA252CC2C351E", hash_generated_method = "A00894729836890918820E6FDCE1B095")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AutoCompleteTextView(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.autoCompleteTextViewStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.317 -0400", hash_original_method = "E7A1365EE4283D79F23C38EBF5E5D299", hash_generated_method = "26234045C1AB345ED4A872C9BF4C1780")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AutoCompleteTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(defStyle);
        dsTaint.addTaint(context.dsTaint);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.318 -0400", hash_original_method = "C1942F3D6CF625065E36951B3C995636", hash_generated_method = "A79BF01F23988E8D3105E5CABB5FF037")
    @DSModeled(DSC.SAFE)
    @Override
    public void setOnClickListener(OnClickListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        mPassThroughClickListener.mWrapped = listener;
        // ---------- Original Method ----------
        //mPassThroughClickListener.mWrapped = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.318 -0400", hash_original_method = "58D3202231E1A3AE7FD8546C3F8B5C86", hash_generated_method = "88B474F79B59DD6548173C744D63B853")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void onClickImpl() {
        {
            boolean varBF0DD052E7F558A1BAF9DA85140649CD_2495836 = (isPopupShowing());
            {
                ensureImeVisible(true);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (isPopupShowing()) {
            //ensureImeVisible(true);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.318 -0400", hash_original_method = "4F48038C1162C78CAFD13A15CFC4C4E3", hash_generated_method = "17C342D92880C5F5DA54C7B4473CBF2E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCompletionHint(CharSequence hint) {
        dsTaint.addTaint(hint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.319 -0400", hash_original_method = "0FF617112E6940852CA340238B035B28", hash_generated_method = "EF05AC1A6FCF96E0FD893AA57B6CBAE0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getDropDownWidth() {
        int varDE5FE111D7D320C8167E395DFD34A92D_1538494070 = (mPopup.getWidth());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mPopup.getWidth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.319 -0400", hash_original_method = "B270189DDD36B930B898EDE5BD590C69", hash_generated_method = "029B4F77715FDF4FE1D3D756043302A6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDropDownWidth(int width) {
        dsTaint.addTaint(width);
        mPopup.setWidth(width);
        // ---------- Original Method ----------
        //mPopup.setWidth(width);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.319 -0400", hash_original_method = "ED81905DF1626AD5BC656BEBB27BE880", hash_generated_method = "B3BB22F94B4770979F3493B95663248E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getDropDownHeight() {
        int var289B548EABC2C0DE3CC9B937149AC347_7824995 = (mPopup.getHeight());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mPopup.getHeight();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.320 -0400", hash_original_method = "7CEF092BABE0725B932F9B439F9A3AFD", hash_generated_method = "2A7A6E29A3FECBD6F0A1116C9F8CE7A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDropDownHeight(int height) {
        dsTaint.addTaint(height);
        mPopup.setHeight(height);
        // ---------- Original Method ----------
        //mPopup.setHeight(height);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.320 -0400", hash_original_method = "983C379A49D6519E05BB04A2322E89F2", hash_generated_method = "F32740A1420753F8AB59045E2ADE19BD")
    @DSModeled(DSC.SAFE)
    public int getDropDownAnchor() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mDropDownAnchorId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.320 -0400", hash_original_method = "5971179F1F300FE7DC24F52751CD203A", hash_generated_method = "F9FDBC4F360D2BDBCC22C7EA8E3DF858")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDropDownAnchor(int id) {
        dsTaint.addTaint(id);
        mPopup.setAnchorView(null);
        // ---------- Original Method ----------
        //mDropDownAnchorId = id;
        //mPopup.setAnchorView(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.320 -0400", hash_original_method = "AF968841F9ADA345DD97E068FA7BD610", hash_generated_method = "796C059A2448CB64F3CC395BED300B83")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Drawable getDropDownBackground() {
        Drawable var3AB612EC6D572A5289EDC1AB98187ABD_319697893 = (mPopup.getBackground());
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mPopup.getBackground();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.320 -0400", hash_original_method = "B18D529A578176AD889BDFBA197D2FE9", hash_generated_method = "A895F43A9E7129B1F254CF68B0405E60")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDropDownBackgroundDrawable(Drawable d) {
        dsTaint.addTaint(d.dsTaint);
        mPopup.setBackgroundDrawable(d);
        // ---------- Original Method ----------
        //mPopup.setBackgroundDrawable(d);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.321 -0400", hash_original_method = "58B212667945303F92E76684E6DBBAC3", hash_generated_method = "CEF397D5880658809FB1FF86532C71A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDropDownBackgroundResource(int id) {
        dsTaint.addTaint(id);
        mPopup.setBackgroundDrawable(getResources().getDrawable(id));
        // ---------- Original Method ----------
        //mPopup.setBackgroundDrawable(getResources().getDrawable(id));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.321 -0400", hash_original_method = "AFE41A06E9A754A352572FB9B075CCA0", hash_generated_method = "DC90CEB98E00307C135147BCD1978177")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDropDownVerticalOffset(int offset) {
        dsTaint.addTaint(offset);
        mPopup.setVerticalOffset(offset);
        // ---------- Original Method ----------
        //mPopup.setVerticalOffset(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.321 -0400", hash_original_method = "CD8747B9F2476A0A6006DC41A664E503", hash_generated_method = "71C42D0787C6BAC9E7E8458BE0D222E5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getDropDownVerticalOffset() {
        int var144F8B316A170B2292449FD7841B01F4_1220879909 = (mPopup.getVerticalOffset());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mPopup.getVerticalOffset();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.321 -0400", hash_original_method = "6A22527360686DE12C48E20144984DC3", hash_generated_method = "1B2037BAA14FFBAB53AD7C728EC78FDC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDropDownHorizontalOffset(int offset) {
        dsTaint.addTaint(offset);
        mPopup.setHorizontalOffset(offset);
        // ---------- Original Method ----------
        //mPopup.setHorizontalOffset(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.321 -0400", hash_original_method = "A7584484859282D74A751422BD935CE2", hash_generated_method = "B7CDE324F20C4C86CA25D853695D2AFD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getDropDownHorizontalOffset() {
        int var4E1106CDA8E88D337563292F7F0B86B9_1949150873 = (mPopup.getHorizontalOffset());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mPopup.getHorizontalOffset();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.322 -0400", hash_original_method = "AB6AF7AB4438F2936FAB5E115855ABD1", hash_generated_method = "619B6E9301542D18A1EF7D238D2A4829")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDropDownAnimationStyle(int animationStyle) {
        dsTaint.addTaint(animationStyle);
        mPopup.setAnimationStyle(animationStyle);
        // ---------- Original Method ----------
        //mPopup.setAnimationStyle(animationStyle);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.322 -0400", hash_original_method = "348942C9B29D455789FBCF016CC929C3", hash_generated_method = "97C43DD17E89D1ACD6558F3D79317A39")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getDropDownAnimationStyle() {
        int varFF59793919A82B1D3C72ECF85DD5BB92_252401520 = (mPopup.getAnimationStyle());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mPopup.getAnimationStyle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.322 -0400", hash_original_method = "4343F66DAC432AAC8F4BD77081597537", hash_generated_method = "D34F21B308E96DDB401240DDB74BD99C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isDropDownAlwaysVisible() {
        boolean var25EF609394F97B7ED2D9FEED6B39F9EF_962613605 = (mPopup.isDropDownAlwaysVisible());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mPopup.isDropDownAlwaysVisible();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.322 -0400", hash_original_method = "9D048710298E272B53CC3CA9B767E12A", hash_generated_method = "CFD5D79BF1699513BEF8AE9C4FFA225A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDropDownAlwaysVisible(boolean dropDownAlwaysVisible) {
        dsTaint.addTaint(dropDownAlwaysVisible);
        mPopup.setDropDownAlwaysVisible(dropDownAlwaysVisible);
        // ---------- Original Method ----------
        //mPopup.setDropDownAlwaysVisible(dropDownAlwaysVisible);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.322 -0400", hash_original_method = "5251E63145860B08CE1AA76BBDDDD070", hash_generated_method = "38F3E63A894ED6433680B2BDB7C727E0")
    @DSModeled(DSC.SAFE)
    public boolean isDropDownDismissedOnCompletion() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mDropDownDismissedOnCompletion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.323 -0400", hash_original_method = "87D4B20D86EF98CE5F9B2DCFB12777AB", hash_generated_method = "6A55E721DEF220F60C33D857795D1191")
    @DSModeled(DSC.SAFE)
    public void setDropDownDismissedOnCompletion(boolean dropDownDismissedOnCompletion) {
        dsTaint.addTaint(dropDownDismissedOnCompletion);
        // ---------- Original Method ----------
        //mDropDownDismissedOnCompletion = dropDownDismissedOnCompletion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.323 -0400", hash_original_method = "D355B3B251BB91FAED293791929579AC", hash_generated_method = "BC0EC707799AF1F1798472393689F4E0")
    @DSModeled(DSC.SAFE)
    public int getThreshold() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mThreshold;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.323 -0400", hash_original_method = "E80EC39EC531963E159919926C4979B9", hash_generated_method = "C9F881ADDE0B797D0A73D2F039AA6983")
    @DSModeled(DSC.SAFE)
    public void setThreshold(int threshold) {
        dsTaint.addTaint(threshold);
        {
            threshold = 1;
        } //End block
        // ---------- Original Method ----------
        //if (threshold <= 0) {
            //threshold = 1;
        //}
        //mThreshold = threshold;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.323 -0400", hash_original_method = "B69DF6D8B348285F7F509DAAD23C3372", hash_generated_method = "AFAC2317C1419AEDF1FCB8BDC3B95F1C")
    @DSModeled(DSC.SAFE)
    public void setOnItemClickListener(AdapterView.OnItemClickListener l) {
        dsTaint.addTaint(l.dsTaint);
        // ---------- Original Method ----------
        //mItemClickListener = l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.323 -0400", hash_original_method = "48F24F393448111E92CC5CFF766C1584", hash_generated_method = "B0731A665B0F00AAB6FEEE2D6CBB26DB")
    @DSModeled(DSC.SAFE)
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener l) {
        dsTaint.addTaint(l.dsTaint);
        // ---------- Original Method ----------
        //mItemSelectedListener = l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.324 -0400", hash_original_method = "0AE6D510B9C16F8D52FF49376A7BF6A4", hash_generated_method = "344CDE5923E90321B97E13DDDCECCA1D")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public AdapterView.OnItemClickListener getItemClickListener() {
        return (AdapterView.OnItemClickListener)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mItemClickListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.324 -0400", hash_original_method = "2A86C7E057A0C403AB649B0ED567456D", hash_generated_method = "FBCA2023A0811E03BF10808E2F73FEA7")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public AdapterView.OnItemSelectedListener getItemSelectedListener() {
        return (AdapterView.OnItemSelectedListener)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mItemSelectedListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.324 -0400", hash_original_method = "CC34C836A582B2E0B6660928CDDA2E79", hash_generated_method = "1C0471D838183EA6AB848E6811C883DF")
    @DSModeled(DSC.SAFE)
    public AdapterView.OnItemClickListener getOnItemClickListener() {
        return (AdapterView.OnItemClickListener)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mItemClickListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.324 -0400", hash_original_method = "CA4C95C3D87D9F2B4999807B4A5E6086", hash_generated_method = "B76B52B398FDB38308F50EBC84095576")
    @DSModeled(DSC.SAFE)
    public AdapterView.OnItemSelectedListener getOnItemSelectedListener() {
        return (AdapterView.OnItemSelectedListener)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mItemSelectedListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.324 -0400", hash_original_method = "0E1A05724C497F45D7FB6AC34C501814", hash_generated_method = "445578E314D07460596613848BAFE1E9")
    @DSModeled(DSC.SAFE)
    public ListAdapter getAdapter() {
        return (ListAdapter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mAdapter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.326 -0400", hash_original_method = "18CB1EEAAEFB5BC2DC3ECE426EBE9928", hash_generated_method = "EE8CD69A67B79B3ACD28357DC5A598F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public <T extends ListAdapter & Filterable> void setAdapter(T adapter) {
        dsTaint.addTaint(adapter.dsTaint);
        {
            mObserver = new PopupDataSetObserver();
        } //End block
        {
            mAdapter.unregisterDataSetObserver(mObserver);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.327 -0400", hash_original_method = "1E2534A3F57B1DBFCDE49E1B48E26A0E", hash_generated_method = "2E168751D1DA9D3E77F1555F342D001F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        {
            boolean varCF91672D100D36DDC3B4C7C44DABA877_935477413 = (keyCode == KeyEvent.KEYCODE_BACK && isPopupShowing()
                && !mPopup.isDropDownAlwaysVisible());
            {
                {
                    boolean var51947D54DEEA690F1B41A17DE6323711_1481632371 = (event.getAction() == KeyEvent.ACTION_DOWN && event.getRepeatCount() == 0);
                    {
                        KeyEvent.DispatcherState state;
                        state = getKeyDispatcherState();
                        {
                            state.startTracking(event, this);
                        } //End block
                    } //End block
                    {
                        boolean varA6D964A9D1A4D1D485BD8D60F2BFCDEE_2108621930 = (event.getAction() == KeyEvent.ACTION_UP);
                        {
                            KeyEvent.DispatcherState state;
                            state = getKeyDispatcherState();
                            {
                                state.handleUpEvent(event);
                            } //End block
                            {
                                boolean varBE09C907F92D135687297C67489D82A5_1213279315 = (event.isTracking() && !event.isCanceled());
                                {
                                    dismissDropDown();
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        boolean var84A59BF21652B099F795A333EE25717D_1644366202 = (super.onKeyPreIme(keyCode, event));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.327 -0400", hash_original_method = "A5021B9859EF1208F776ED0647DC53F8", hash_generated_method = "38420139308EF19C7BE02A5011E3C092")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        boolean consumed;
        consumed = mPopup.onKeyUp(keyCode, event);
        {
            //Begin case KeyEvent.KEYCODE_ENTER KeyEvent.KEYCODE_DPAD_CENTER KeyEvent.KEYCODE_TAB 
            {
                boolean var01265F35364458CD2A88FFB15C2C1B92_1621708511 = (event.hasNoModifiers());
                {
                    performCompletion();
                } //End block
            } //End collapsed parenthetic
            //End case KeyEvent.KEYCODE_ENTER KeyEvent.KEYCODE_DPAD_CENTER KeyEvent.KEYCODE_TAB 
        } //End block
        {
            boolean var4EA7F10CC93D61226F2D23FB52A9A1C6_2058967607 = (isPopupShowing() && keyCode == KeyEvent.KEYCODE_TAB && event.hasNoModifiers());
            {
                performCompletion();
            } //End block
        } //End collapsed parenthetic
        boolean varEDD771EBF66425AD21882AB08CD0EE48_239683074 = (super.onKeyUp(keyCode, event));
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.328 -0400", hash_original_method = "7D38CCD4A21A1817640875450034C5D6", hash_generated_method = "441632F3D0C752B34099272C0E2C3E31")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        {
            boolean varEAA7337EBC536309203EE3E593753A75_1822434969 = (mPopup.onKeyDown(keyCode, event));
        } //End collapsed parenthetic
        {
            boolean var31CE5F0E197E77752ACB4AEDFA1D3C90_1028030483 = (!isPopupShowing());
            {
                //Begin case KeyEvent.KEYCODE_DPAD_DOWN 
                {
                    boolean varC77C0C11194BD87DFEE086A32DCE5C18_2145254132 = (event.hasNoModifiers());
                    {
                        performValidation();
                    } //End block
                } //End collapsed parenthetic
                //End case KeyEvent.KEYCODE_DPAD_DOWN 
            } //End block
        } //End collapsed parenthetic
        {
            boolean var4EA7F10CC93D61226F2D23FB52A9A1C6_247984644 = (isPopupShowing() && keyCode == KeyEvent.KEYCODE_TAB && event.hasNoModifiers());
        } //End collapsed parenthetic
        boolean handled;
        handled = super.onKeyDown(keyCode, event);
        mLastKeyCode = KeyEvent.KEYCODE_UNKNOWN;
        {
            boolean var162F5ADAD69E734CD14CBE2CECA73563_1849598509 = (handled && isPopupShowing());
            {
                clearListSelection();
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.328 -0400", hash_original_method = "845425AE754C4142506C6C975210339B", hash_generated_method = "4EE69878B17DEED61E79B46629CABF44")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean enoughToFilter() {
        boolean var802A199BC987421607136CCD7E0B67F4_1074221819 = (getText().length() >= mThreshold);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (DEBUG) Log.v(TAG, "Enough to filter: len=" + getText().length()
                //+ " threshold=" + mThreshold);
        //return getText().length() >= mThreshold;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.328 -0400", hash_original_method = "9B68F895919D747E86E2BC0B861C3485", hash_generated_method = "5079856DA9B9C5DA20D2FB5BC21BACFA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void doBeforeTextChanged() {
        mOpenBefore = isPopupShowing();
        // ---------- Original Method ----------
        //if (mBlockCompletion) return;
        //mOpenBefore = isPopupShowing();
        //if (DEBUG) Log.v(TAG, "before text changed: open=" + mOpenBefore);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.329 -0400", hash_original_method = "EABD50974341527CEC5D7DC0490BCDC7", hash_generated_method = "95CF8494BB7F22856355A30EE46276E4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void doAfterTextChanged() {
        {
            boolean varC8DFCD3EC6795C83C2C2CEA0F5FB857A_541473841 = (mOpenBefore && !isPopupShowing());
        } //End collapsed parenthetic
        {
            boolean var7BC1F429DC7B76D5B2FE230BBFF7FD32_870571383 = (enoughToFilter());
            {
                {
                    mPopupCanBeUpdated = true;
                    performFiltering(getText(), mLastKeyCode);
                } //End block
            } //End block
            {
                {
                    boolean var0824F0A8A43CDA043490F1016B02DD90_1118127321 = (!mPopup.isDropDownAlwaysVisible());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.329 -0400", hash_original_method = "82AB47D081F83CBFD677A62933F7FE17", hash_generated_method = "8A8933F43D29FCA173CDB001E860BDBD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isPopupShowing() {
        boolean varC4D0BEF5C8B8A88A8F0203AF22B9D645_259140343 = (mPopup.isShowing());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mPopup.isShowing();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.329 -0400", hash_original_method = "5BE18D1BCEE667E3D32BBF42EAB5125A", hash_generated_method = "602AE200835CAB1CA60C0CCACC51216C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected CharSequence convertSelectionToString(Object selectedItem) {
        dsTaint.addTaint(selectedItem.dsTaint);
        CharSequence varFB319E4CB0512E1B0CE9C016FC4A6122_988889192 = (mFilter.convertResultToString(selectedItem));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mFilter.convertResultToString(selectedItem);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.329 -0400", hash_original_method = "7623D1558693BF470F22C595BECC6733", hash_generated_method = "8B3C8ABD4877B8477A9502489B2E9EE7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clearListSelection() {
        mPopup.clearListSelection();
        // ---------- Original Method ----------
        //mPopup.clearListSelection();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.329 -0400", hash_original_method = "133DE5DB01039801737429C3DDB0411B", hash_generated_method = "0BE8736ED6838552DDB37015A922EC8A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setListSelection(int position) {
        dsTaint.addTaint(position);
        mPopup.setSelection(position);
        // ---------- Original Method ----------
        //mPopup.setSelection(position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.330 -0400", hash_original_method = "FACA63936D6E82D9A31B7F667F19A5C4", hash_generated_method = "D1705F75744038E9E5A110E13BBFA8A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getListSelection() {
        int var857A9A7C75A21043C7E420ED49138B63_1795692418 = (mPopup.getSelectedItemPosition());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mPopup.getSelectedItemPosition();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.330 -0400", hash_original_method = "6D2AAF11ECF28F40F16EC0FF58DB7391", hash_generated_method = "07A7475DC56B0EFC48EC36128C245C6C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings({ "UnusedDeclaration" })
    protected void performFiltering(CharSequence text, int keyCode) {
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(text);
        mFilter.filter(text, this);
        // ---------- Original Method ----------
        //mFilter.filter(text, this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.330 -0400", hash_original_method = "F704ACEA98F83F3E1219E92B20BE03DA", hash_generated_method = "A721540EC82B1346CA97B5580BF1819C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void performCompletion() {
        performCompletion(null, -1, -1);
        // ---------- Original Method ----------
        //performCompletion(null, -1, -1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.330 -0400", hash_original_method = "4C402F357E20A5DEEC78C01A554F2E74", hash_generated_method = "B561D1C6B5643D531F143942B992A531")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onCommitCompletion(CompletionInfo completion) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(completion.dsTaint);
        {
            boolean varBF0DD052E7F558A1BAF9DA85140649CD_1564068045 = (isPopupShowing());
            {
                mPopup.performItemClick(completion.getPosition());
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (isPopupShowing()) {
            //mPopup.performItemClick(completion.getPosition());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.331 -0400", hash_original_method = "87F4A447D592D0FFBC34508A48276E40", hash_generated_method = "7FE88E36AD2B4DB5988A8DB85F9DF037")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void performCompletion(View selectedView, int position, long id) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(position);
        dsTaint.addTaint(selectedView.dsTaint);
        {
            boolean varBF0DD052E7F558A1BAF9DA85140649CD_2056602558 = (isPopupShowing());
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
            boolean var84F7BA650A0C071DE71B9F9EFAFD4CB7_808010995 = (mDropDownDismissedOnCompletion && !mPopup.isDropDownAlwaysVisible());
            {
                dismissDropDown();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.331 -0400", hash_original_method = "01D38330C874C1244C7D1EF978D11C36", hash_generated_method = "AFB3000F8B83229B2A841F6A466BA65E")
    @DSModeled(DSC.SAFE)
    public boolean isPerformingCompletion() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mBlockCompletion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.331 -0400", hash_original_method = "3F95D8A8308B140C895762391C3A32C6", hash_generated_method = "575B8783E50A3D5DFDAEE78961AB6C30")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setText(CharSequence text, boolean filter) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(filter);
        {
            setText(text);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.331 -0400", hash_original_method = "BFA04BF25DCE9275294E0FA186DED6C8", hash_generated_method = "262C4152C2E9FF9BBAD81AA47D611915")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void replaceText(CharSequence text) {
        dsTaint.addTaint(text);
        clearComposingText();
        setText(text);
        Editable spannable;
        spannable = getText();
        Selection.setSelection(spannable, spannable.length());
        // ---------- Original Method ----------
        //clearComposingText();
        //setText(text);
        //Editable spannable = getText();
        //Selection.setSelection(spannable, spannable.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.332 -0400", hash_original_method = "65C6B6A3B92536D4DF6F13E8CB596A16", hash_generated_method = "CAFB9EEAD61B7191C8A1301CF3C210DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onFilterComplete(int count) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(count);
        updateDropDownForFilter(count);
        // ---------- Original Method ----------
        //updateDropDownForFilter(count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.332 -0400", hash_original_method = "43BA40231E8A8ECAF857BC9AE8C4397B", hash_generated_method = "BFD2A6707B14BE80F387B665A8DA8025")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void updateDropDownForFilter(int count) {
        dsTaint.addTaint(count);
        {
            boolean varD5CDC0D536B5FA4553B96B5703612C11_1959073755 = (getWindowVisibility() == View.GONE);
        } //End collapsed parenthetic
        boolean dropDownAlwaysVisible;
        dropDownAlwaysVisible = mPopup.isDropDownAlwaysVisible();
        boolean enoughToFilter;
        enoughToFilter = enoughToFilter();
        {
            {
                boolean varE1F8380C8E3F7DCCF817AF0484F51D4C_1823297141 = (hasFocus() && hasWindowFocus() && mPopupCanBeUpdated);
                {
                    showDropDown();
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean var9C99795911568E3888EABA880D410AFC_680879915 = (!dropDownAlwaysVisible && isPopupShowing());
            {
                dismissDropDown();
                mPopupCanBeUpdated = true;
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.332 -0400", hash_original_method = "2BBFCFB03CA88D4E4428D247CF9B4D7A", hash_generated_method = "73F4F2F31C8B4A85303983D05B9F3D25")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(hasWindowFocus);
        super.onWindowFocusChanged(hasWindowFocus);
        {
            boolean var941F9BC59CD94FBFBC0C73300BC8F8DC_1995294530 = (!hasWindowFocus && !mPopup.isDropDownAlwaysVisible());
            {
                dismissDropDown();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //super.onWindowFocusChanged(hasWindowFocus);
        //if (!hasWindowFocus && !mPopup.isDropDownAlwaysVisible()) {
            //dismissDropDown();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.332 -0400", hash_original_method = "42E246C35216D3D5148B04B4E2B23F4A", hash_generated_method = "D0E03208D288BEEA1D66B328A0180BD6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onDisplayHint(int hint) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(hint);
        super.onDisplayHint(hint);
        //Begin case INVISIBLE 
        {
            boolean var385AD17FFBEDD864FC1A0B58A1F09114_934147628 = (!mPopup.isDropDownAlwaysVisible());
            {
                dismissDropDown();
            } //End block
        } //End collapsed parenthetic
        //End case INVISIBLE 
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.333 -0400", hash_original_method = "28987A1F68AF8291400818B9FA8A6C7A", hash_generated_method = "4FE225ABB9A44DBB5750F1572206E919")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(direction);
        dsTaint.addTaint(previouslyFocusedRect.dsTaint);
        dsTaint.addTaint(focused);
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        {
            performValidation();
        } //End block
        {
            boolean varA8CBBEFC0E9CCE791C24D52787B7074B_708094857 = (!focused && !mPopup.isDropDownAlwaysVisible());
            {
                dismissDropDown();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //super.onFocusChanged(focused, direction, previouslyFocusedRect);
        //if (!focused) {
            //performValidation();
        //}
        //if (!focused && !mPopup.isDropDownAlwaysVisible()) {
            //dismissDropDown();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.333 -0400", hash_original_method = "7A2D6EDAA0E5981DC60C5747420510C2", hash_generated_method = "00FC054FE7DDC1542F03A4EEE8C79AC6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onAttachedToWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onAttachedToWindow();
        // ---------- Original Method ----------
        //super.onAttachedToWindow();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.333 -0400", hash_original_method = "DD8C719D50846B220D8C588E856246EC", hash_generated_method = "3B133B89A062F2ACA8F9A841C10030DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dismissDropDown();
        super.onDetachedFromWindow();
        // ---------- Original Method ----------
        //dismissDropDown();
        //super.onDetachedFromWindow();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.334 -0400", hash_original_method = "B307D50FE74ACB01B1CCF5403B3C4263", hash_generated_method = "A125B69E4FE5391B539E4F789A84776B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.334 -0400", hash_original_method = "8B7584A552A003B9ACCE9D0FC992FC50", hash_generated_method = "4E38C9AD3819208376B6F1FA2AFBCBFB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean setFrame(final int l, int t, final int r, int b) {
        dsTaint.addTaint(t);
        dsTaint.addTaint(b);
        dsTaint.addTaint(r);
        dsTaint.addTaint(l);
        boolean result;
        result = super.setFrame(l, t, r, b);
        {
            boolean varBF0DD052E7F558A1BAF9DA85140649CD_1756994524 = (isPopupShowing());
            {
                showDropDown();
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean result = super.setFrame(l, t, r, b);
        //if (isPopupShowing()) {
            //showDropDown();
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.334 -0400", hash_original_method = "E5B4D0CB7911E0BF332298A12D86AD4A", hash_generated_method = "A9417F64F27E0248C39106ECDBA36D11")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void showDropDownAfterLayout() {
        mPopup.postShow();
        // ---------- Original Method ----------
        //mPopup.postShow();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.334 -0400", hash_original_method = "E55E3CC7F05D9D6DD7DBC4A161FF882F", hash_generated_method = "B6D179893A48AA800832816EB0DDA665")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void ensureImeVisible(boolean visible) {
        dsTaint.addTaint(visible);
        mPopup.setInputMethodMode(visible
                ? ListPopupWindow.INPUT_METHOD_NEEDED : ListPopupWindow.INPUT_METHOD_NOT_NEEDED);
        showDropDown();
        // ---------- Original Method ----------
        //mPopup.setInputMethodMode(visible
                //? ListPopupWindow.INPUT_METHOD_NEEDED : ListPopupWindow.INPUT_METHOD_NOT_NEEDED);
        //showDropDown();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.334 -0400", hash_original_method = "16FCF16EE4527CEC1661452DABA1BD86", hash_generated_method = "E924039F19BF4C75EAB068F5238D76BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isInputMethodNotNeeded() {
        boolean varFE28C58AF71C3C6BA19C8B909BE540AC_1169433286 = (mPopup.getInputMethodMode() == ListPopupWindow.INPUT_METHOD_NOT_NEEDED);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mPopup.getInputMethodMode() == ListPopupWindow.INPUT_METHOD_NOT_NEEDED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.335 -0400", hash_original_method = "D361024BEE5BA43B42AED822B3CFC4B1", hash_generated_method = "18E44AD594D7C3A17E401986EAFD83B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void showDropDown() {
        buildImeCompletions();
        {
            boolean var3068B623CD2CFC5D008C7D2FE5FE0A2C_529153784 = (mPopup.getAnchorView() == null);
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
            boolean var31CE5F0E197E77752ACB4AEDFA1D3C90_15442400 = (!isPopupShowing());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.335 -0400", hash_original_method = "3BAD4610337E0EF5F8BF22A9BBBB2B17", hash_generated_method = "C11DDD496A4073D4E4031A201AB486EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setForceIgnoreOutsideTouch(boolean forceIgnoreOutsideTouch) {
        dsTaint.addTaint(forceIgnoreOutsideTouch);
        mPopup.setForceIgnoreOutsideTouch(forceIgnoreOutsideTouch);
        // ---------- Original Method ----------
        //mPopup.setForceIgnoreOutsideTouch(forceIgnoreOutsideTouch);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.336 -0400", hash_original_method = "DD23AC9F9BC11D23FC9B33CDFA0AE577", hash_generated_method = "2C8C79AA6D2B36D2B32318B1383E3CC5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
                            boolean var80DA9CC47A088166826473F71AF20B64_692646670 = (adapter.isEnabled(i));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.336 -0400", hash_original_method = "19381912498DA3D1F08FF4D2E33BF7A7", hash_generated_method = "FD60F7CCAB70A28BF1E5CD94EBE64547")
    @DSModeled(DSC.SAFE)
    public void setValidator(Validator validator) {
        dsTaint.addTaint(validator.dsTaint);
        // ---------- Original Method ----------
        //mValidator = validator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.336 -0400", hash_original_method = "E2B844337B4F2E764213661E3DB17BC8", hash_generated_method = "AA9FC125C80C4DC46F0379852050683B")
    @DSModeled(DSC.SAFE)
    public Validator getValidator() {
        return (Validator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mValidator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.336 -0400", hash_original_method = "6C87320109B091D88082BE6479926B64", hash_generated_method = "EECA9EB75570AF573EA7D75FF725547F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void performValidation() {
        CharSequence text;
        text = getText();
        {
            boolean varEEC51FF3E573EAB5A8EA2A7F5E6B2AEF_1338154163 = (!TextUtils.isEmpty(text) && !mValidator.isValid(text));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.336 -0400", hash_original_method = "A182F1708C145D57F0135D6BE7F61F0B", hash_generated_method = "3397C559AAFBB84DC5D22E7554E50FD1")
    @DSModeled(DSC.SAFE)
    protected Filter getFilter() {
        return (Filter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mFilter;
    }

    
    private class MyWatcher implements TextWatcher {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.337 -0400", hash_original_method = "2EE250BF1246E4A9EA3B956E6C5AF16E", hash_generated_method = "2EE250BF1246E4A9EA3B956E6C5AF16E")
                public MyWatcher ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.337 -0400", hash_original_method = "595E81F8C2CD078134C2C0CD5C188C48", hash_generated_method = "E8B6040B7E12E03915F6D20C20B65358")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void afterTextChanged(Editable s) {
            dsTaint.addTaint(s.dsTaint);
            doAfterTextChanged();
            // ---------- Original Method ----------
            //doAfterTextChanged();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.337 -0400", hash_original_method = "BC2E54553D15961DF2A438BC2F30EBE4", hash_generated_method = "3E606CA9F6E7FEC47E150EAF5E364874")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            dsTaint.addTaint(after);
            dsTaint.addTaint(count);
            dsTaint.addTaint(s);
            dsTaint.addTaint(start);
            doBeforeTextChanged();
            // ---------- Original Method ----------
            //doBeforeTextChanged();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.337 -0400", hash_original_method = "65C508C8ABB6ACC44B70A081DD077416", hash_generated_method = "3F7574C5C6185DC37F3B1E55A5FF4DC4")
        @DSModeled(DSC.SAFE)
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(count);
            dsTaint.addTaint(s);
            dsTaint.addTaint(start);
            dsTaint.addTaint(before);
            // ---------- Original Method ----------
        }

        
    }


    
    private class DropDownItemClickListener implements AdapterView.OnItemClickListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.337 -0400", hash_original_method = "5A7EE0A03F28676BB81ABDCCB3EFF8AB", hash_generated_method = "5A7EE0A03F28676BB81ABDCCB3EFF8AB")
                public DropDownItemClickListener ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.337 -0400", hash_original_method = "4F7C82DB77A3FEF0D877BA2AB4932B41", hash_generated_method = "83178DE10A0511C88B245CF29995122D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onItemClick(AdapterView parent, View v, int position, long id) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(id);
            dsTaint.addTaint(position);
            dsTaint.addTaint(v.dsTaint);
            dsTaint.addTaint(parent.dsTaint);
            performCompletion(v, position, id);
            // ---------- Original Method ----------
            //performCompletion(v, position, id);
        }

        
    }


    
    private class PassThroughClickListener implements OnClickListener {
        private View.OnClickListener mWrapped;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.338 -0400", hash_original_method = "CC46B11D378E346F6E5009C904FBF035", hash_generated_method = "CC46B11D378E346F6E5009C904FBF035")
                public PassThroughClickListener ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.338 -0400", hash_original_method = "E3F762E6FD76D99B402BD097AF1F93E6", hash_generated_method = "40E08C357C41CA85FEDE39EB493C59A6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onClick(View v) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(v.dsTaint);
            onClickImpl();
            mWrapped.onClick(v);
            // ---------- Original Method ----------
            //onClickImpl();
            //if (mWrapped != null) mWrapped.onClick(v);
        }

        
    }


    
    private class PopupDataSetObserver extends DataSetObserver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.338 -0400", hash_original_method = "18147E3C812B85F2382843E6ADAF110B", hash_generated_method = "18147E3C812B85F2382843E6ADAF110B")
                public PopupDataSetObserver ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.338 -0400", hash_original_method = "E1ADD1CC7F155CD4BE00BE335F96E1E6", hash_generated_method = "3D83CB70E9F67B293A52A9EED6F59E41")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void onChanged() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                post(new Runnable() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.338 -0400", hash_original_method = "C1C8572D4CABAA4D9D14EF8392DA725A", hash_generated_method = "7C35BB640D9B77A86C8F65E3682D3D6D")
                    //DSFIXME:  CODE0002: Requires DSC value to be set
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
    
    static final boolean DEBUG = false;
    static final String TAG = "AutoCompleteTextView";
    static final int EXPAND_MAX = 3;
}

