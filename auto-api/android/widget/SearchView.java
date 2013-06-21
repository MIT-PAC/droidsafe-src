package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import static android.widget.SuggestionsAdapter.getColumnString;
import android.app.PendingIntent;
import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.speech.RecognizerIntent;
import android.text.Editable;
import android.text.InputType;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.CollapsibleActionView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView.OnEditorActionListener;
import com.android.internal.R;
import java.util.WeakHashMap;

public class SearchView extends LinearLayout implements CollapsibleActionView {
    private OnQueryTextListener mOnQueryChangeListener;
    private OnCloseListener mOnCloseListener;
    private OnFocusChangeListener mOnQueryTextFocusChangeListener;
    private OnSuggestionListener mOnSuggestionListener;
    private OnClickListener mOnSearchClickListener;
    private boolean mIconifiedByDefault;
    private boolean mIconified;
    private CursorAdapter mSuggestionsAdapter;
    private View mSearchButton;
    private View mSubmitButton;
    private View mSearchPlate;
    private View mSubmitArea;
    private ImageView mCloseButton;
    private View mSearchEditFrame;
    private View mVoiceButton;
    private SearchAutoComplete mQueryTextView;
    private View mDropDownAnchor;
    private ImageView mSearchHintIcon;
    private boolean mSubmitButtonEnabled;
    private CharSequence mQueryHint;
    private boolean mQueryRefinement;
    private boolean mClearingFocus;
    private int mMaxWidth;
    private boolean mVoiceButtonEnabled;
    private CharSequence mOldQueryText;
    private CharSequence mUserQuery;
    private boolean mExpandedInActionView;
    private int mCollapsedImeOptions;
    private SearchableInfo mSearchable;
    private Bundle mAppSearchData;
    private Runnable mShowImeRunnable = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.498 -0400", hash_original_method = "0C9F4768975D596BB26A07FA95497352", hash_generated_method = "B40D8DB4A2FD60707CF1E6FE3690FD6A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void run() {
            InputMethodManager imm;
            imm = (InputMethodManager)
                    getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            {
                imm.showSoftInputUnchecked(0, null);
            } //End block
            // ---------- Original Method ----------
            //InputMethodManager imm = (InputMethodManager)
                    //getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            //if (imm != null) {
                //imm.showSoftInputUnchecked(0, null);
            //}
        }

        
}; //Transformed anonymous class
    private Runnable mUpdateDrawableStateRunnable = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.498 -0400", hash_original_method = "E7E2D783E1837F9E8B1A28FF4E183514", hash_generated_method = "B3EAFD427E9292CB229208955575A412")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void run() {
            updateFocusedState();
            // ---------- Original Method ----------
            //updateFocusedState();
        }

        
}; //Transformed anonymous class
    private Runnable mReleaseCursorRunnable = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.498 -0400", hash_original_method = "EDF4C3DBCA8CFDCCDE7923F1B773494D", hash_generated_method = "5D09A5A32E2149C6D8DDAB1034633D73")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void run() {
            {
                mSuggestionsAdapter.changeCursor(null);
            } //End block
            // ---------- Original Method ----------
            //if (mSuggestionsAdapter != null && mSuggestionsAdapter instanceof SuggestionsAdapter) {
                //mSuggestionsAdapter.changeCursor(null);
            //}
        }

        
}; //Transformed anonymous class
    private Intent mVoiceWebSearchIntent;
    private Intent mVoiceAppSearchIntent;
    private WeakHashMap<String, Drawable.ConstantState> mOutsideDrawablesCache =
            new WeakHashMap<String, Drawable.ConstantState>();
    private final OnClickListener mOnClickListener = new OnClickListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.499 -0400", hash_original_method = "7A1C93089C02ACFF37CDB0A860AADCE9", hash_generated_method = "B52D2FBE6F59E20BBDB65D421000FFCA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onClick(View v) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(v.dsTaint);
            {
                onSearchClicked();
            } //End block
            {
                onCloseClicked();
            } //End block
            {
                onSubmitQuery();
            } //End block
            {
                onVoiceClicked();
            } //End block
            {
                forceSuggestionQuery();
            } //End block
            // ---------- Original Method ----------
            //if (v == mSearchButton) {
                //onSearchClicked();
            //} else if (v == mCloseButton) {
                //onCloseClicked();
            //} else if (v == mSubmitButton) {
                //onSubmitQuery();
            //} else if (v == mVoiceButton) {
                //onVoiceClicked();
            //} else if (v == mQueryTextView) {
                //forceSuggestionQuery();
            //}
        }

        
}; //Transformed anonymous class
    View.OnKeyListener mTextKeyListener = new View.OnKeyListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.499 -0400", hash_original_method = "6918EF31FF46DE3F47367E08809323A7", hash_generated_method = "0113F03EA5755C990B7777DF527950C4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(keyCode);
            dsTaint.addTaint(v.dsTaint);
            dsTaint.addTaint(event.dsTaint);
            {
                Log.d(LOG_TAG, "mTextListener.onKey(" + keyCode + "," + event + "), selection: "
                        + mQueryTextView.getListSelection());
            } //End block
            {
                boolean varE6EA52064C48DD8716C3E906CB173C57_411566708 = (mQueryTextView.isPopupShowing()
                    && mQueryTextView.getListSelection() != ListView.INVALID_POSITION);
                {
                    boolean var61B897F82409A70C761917364CAB3F30_1080102881 = (onSuggestionsKey(v, keyCode, event));
                } //End block
            } //End collapsed parenthetic
            {
                boolean varE59197EBDDDE38F1D5742B373FE3954C_1112586138 = (!mQueryTextView.isEmpty() && event.hasNoModifiers());
                {
                    {
                        boolean varA6D964A9D1A4D1D485BD8D60F2BFCDEE_1755201042 = (event.getAction() == KeyEvent.ACTION_UP);
                        {
                            {
                                v.cancelLongPress();
                                launchQuerySearch(KeyEvent.KEYCODE_UNKNOWN, null, mQueryTextView.getText()
                                .toString());
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                    {
                        boolean var53B1438B0BA4D5FAD39095EFE3E69325_2078234179 = (event.getAction() == KeyEvent.ACTION_DOWN);
                        {
                            SearchableInfo.ActionKeyInfo actionKey;
                            actionKey = mSearchable.findActionKey(keyCode);
                            {
                                boolean var2CE6658B093840CDBB7A8A4DB4461BFB_1609232681 = ((actionKey != null) && (actionKey.getQueryActionMsg() != null));
                                {
                                    launchQuerySearch(keyCode, actionKey.getQueryActionMsg(), mQueryTextView
                                .getText().toString());
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
}; //Transformed anonymous class
    private final OnEditorActionListener mOnEditorActionListener = new OnEditorActionListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.499 -0400", hash_original_method = "D29597D64DD97652D3ABF8CFD2738E45", hash_generated_method = "DA46FFAAE990E227EFFC25DE53F79E07")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(v.dsTaint);
            dsTaint.addTaint(event.dsTaint);
            dsTaint.addTaint(actionId);
            onSubmitQuery();
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //onSubmitQuery();
            //return true;
        }

        
}; //Transformed anonymous class
    private final OnItemClickListener mOnItemClickListener = new OnItemClickListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.500 -0400", hash_original_method = "5E212E5821217E2BB1A383DD15E7F009", hash_generated_method = "E50673E5F4472B236EA71FF65D456391")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(id);
            dsTaint.addTaint(position);
            dsTaint.addTaint(parent.dsTaint);
            dsTaint.addTaint(view.dsTaint);
            Log.d(LOG_TAG, "onItemClick() position " + position);
            onItemClicked(position, KeyEvent.KEYCODE_UNKNOWN, null);
            // ---------- Original Method ----------
            //if (DBG) Log.d(LOG_TAG, "onItemClick() position " + position);
            //onItemClicked(position, KeyEvent.KEYCODE_UNKNOWN, null);
        }

        
}; //Transformed anonymous class
    private final OnItemSelectedListener mOnItemSelectedListener = new OnItemSelectedListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.501 -0400", hash_original_method = "86CEF1E2408F388AD82C104FE40AC329", hash_generated_method = "32CFD3CFF9038F950EBFBB73CA8E6223")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(id);
            dsTaint.addTaint(position);
            dsTaint.addTaint(parent.dsTaint);
            dsTaint.addTaint(view.dsTaint);
            Log.d(LOG_TAG, "onItemSelected() position " + position);
            SearchView.this.onItemSelected(position);
            // ---------- Original Method ----------
            //if (DBG) Log.d(LOG_TAG, "onItemSelected() position " + position);
            //SearchView.this.onItemSelected(position);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.501 -0400", hash_original_method = "4FDA6539116BD7730EFFECAC0128D708", hash_generated_method = "9CD3E4366D6D0676AD4D867CD4EB5610")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onNothingSelected(AdapterView<?> parent) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(parent.dsTaint);
            Log.d(LOG_TAG, "onNothingSelected()");
            // ---------- Original Method ----------
            //if (DBG)
                //Log.d(LOG_TAG, "onNothingSelected()");
        }

        
}; //Transformed anonymous class
    private TextWatcher mTextWatcher = new TextWatcher() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.501 -0400", hash_original_method = "EAE2EA11EF016FE6B504EAA4A71A905F", hash_generated_method = "04B91B49845F86517EE4B3DB5C3E9857")
        @DSModeled(DSC.SAFE)
        public void beforeTextChanged(CharSequence s, int start, int before, int after) {
            dsTaint.addTaint(after);
            dsTaint.addTaint(s);
            dsTaint.addTaint(start);
            dsTaint.addTaint(before);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.501 -0400", hash_original_method = "F1038C7BDD17D1F93B5C6C4513E79DEF", hash_generated_method = "3A88039220535D51681E874F9BC1C11F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onTextChanged(CharSequence s, int start,
                int before, int after) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(after);
            dsTaint.addTaint(s);
            dsTaint.addTaint(start);
            dsTaint.addTaint(before);
            SearchView.this.onTextChanged(s);
            // ---------- Original Method ----------
            //SearchView.this.onTextChanged(s);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.501 -0400", hash_original_method = "2B62725FCE5BAC340D42F3403AAE31A5", hash_generated_method = "E1E9B48623236A758AA5D88D665C2448")
        @DSModeled(DSC.SAFE)
        public void afterTextChanged(Editable s) {
            dsTaint.addTaint(s.dsTaint);
            // ---------- Original Method ----------
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.501 -0400", hash_original_method = "C1ED4F339F78000C40B1DF7945901DEA", hash_generated_method = "63A4398EEAEA540B697E208DDF291D26")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SearchView(Context context) {
        this(context, null);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.503 -0400", hash_original_method = "3896FE61014E55816F436D09C274C5F6", hash_generated_method = "76091B2EDDA2317749E000982513298D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SearchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        LayoutInflater inflater;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.search_view, this, true);
        mSearchButton = findViewById(R.id.search_button);
        mQueryTextView = (SearchAutoComplete) findViewById(R.id.search_src_text);
        mQueryTextView.setSearchView(this);
        mSearchEditFrame = findViewById(R.id.search_edit_frame);
        mSearchPlate = findViewById(R.id.search_plate);
        mSubmitArea = findViewById(R.id.submit_area);
        mSubmitButton = findViewById(R.id.search_go_btn);
        mCloseButton = (ImageView) findViewById(R.id.search_close_btn);
        mVoiceButton = findViewById(R.id.search_voice_btn);
        mSearchHintIcon = (ImageView) findViewById(R.id.search_mag_icon);
        mSearchButton.setOnClickListener(mOnClickListener);
        mCloseButton.setOnClickListener(mOnClickListener);
        mSubmitButton.setOnClickListener(mOnClickListener);
        mVoiceButton.setOnClickListener(mOnClickListener);
        mQueryTextView.setOnClickListener(mOnClickListener);
        mQueryTextView.addTextChangedListener(mTextWatcher);
        mQueryTextView.setOnEditorActionListener(mOnEditorActionListener);
        mQueryTextView.setOnItemClickListener(mOnItemClickListener);
        mQueryTextView.setOnItemSelectedListener(mOnItemSelectedListener);
        mQueryTextView.setOnKeyListener(mTextKeyListener);
        mQueryTextView.setOnFocusChangeListener(new OnFocusChangeListener() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.503 -0400", hash_original_method = "93DBFCC4F7C7F6082C428361FF73C717", hash_generated_method = "6E11FEFF786AEFC0808A8AEA5843D38F")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void onFocusChange(View v, boolean hasFocus) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                dsTaint.addTaint(v.dsTaint);
                dsTaint.addTaint(hasFocus);
                {
                    mOnQueryTextFocusChangeListener.onFocusChange(SearchView.this, hasFocus);
                } //End block
                // ---------- Original Method ----------
                //if (mOnQueryTextFocusChangeListener != null) {
                    //mOnQueryTextFocusChangeListener.onFocusChange(SearchView.this, hasFocus);
                //}
            }
});
        TypedArray a;
        a = context.obtainStyledAttributes(attrs, R.styleable.SearchView, 0, 0);
        setIconifiedByDefault(a.getBoolean(R.styleable.SearchView_iconifiedByDefault, true));
        int maxWidth;
        maxWidth = a.getDimensionPixelSize(R.styleable.SearchView_maxWidth, -1);
        {
            setMaxWidth(maxWidth);
        } //End block
        CharSequence queryHint;
        queryHint = a.getText(R.styleable.SearchView_queryHint);
        {
            boolean varC80C3FDE5CDED7C0FBD0A83E98220CA5_875943336 = (!TextUtils.isEmpty(queryHint));
            {
                setQueryHint(queryHint);
            } //End block
        } //End collapsed parenthetic
        int imeOptions;
        imeOptions = a.getInt(R.styleable.SearchView_imeOptions, -1);
        {
            setImeOptions(imeOptions);
        } //End block
        int inputType;
        inputType = a.getInt(R.styleable.SearchView_inputType, -1);
        {
            setInputType(inputType);
        } //End block
        a.recycle();
        boolean focusable;
        focusable = true;
        a = context.obtainStyledAttributes(attrs, R.styleable.View, 0, 0);
        focusable = a.getBoolean(R.styleable.View_focusable, focusable);
        a.recycle();
        setFocusable(focusable);
        mVoiceWebSearchIntent = new Intent(RecognizerIntent.ACTION_WEB_SEARCH);
        mVoiceWebSearchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mVoiceWebSearchIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_WEB_SEARCH);
        mVoiceAppSearchIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        mVoiceAppSearchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mDropDownAnchor = findViewById(mQueryTextView.getDropDownAnchor());
        {
            mDropDownAnchor.addOnLayoutChangeListener(new OnLayoutChangeListener() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.503 -0400", hash_original_method = "1877F5683C45A9DD10AF559CB44A52A8", hash_generated_method = "02ADEAD3522F132F505D9D984BFAC102")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public void onLayoutChange(View v, int left, int top, int right, int bottom,
                        int oldLeft, int oldTop, int oldRight, int oldBottom) {
                    //DSFIXME:  CODE0009: Possible callback target function detected
                    dsTaint.addTaint(v.dsTaint);
                    dsTaint.addTaint(oldLeft);
                    dsTaint.addTaint(oldBottom);
                    dsTaint.addTaint(oldRight);
                    dsTaint.addTaint(bottom);
                    dsTaint.addTaint(left);
                    dsTaint.addTaint(right);
                    dsTaint.addTaint(oldTop);
                    dsTaint.addTaint(top);
                    adjustDropDownSizeAndPosition();
                    // ---------- Original Method ----------
                    //adjustDropDownSizeAndPosition();
                }
});
        } //End block
        updateViewsVisibility(mIconifiedByDefault);
        updateQueryHint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.504 -0400", hash_original_method = "D9A30BFA849ECE06409E134B6DE5C1F0", hash_generated_method = "4C2C897F12D59FFDF4CFB574A519A6FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSearchableInfo(SearchableInfo searchable) {
        dsTaint.addTaint(searchable.dsTaint);
        {
            updateSearchAutoComplete();
            updateQueryHint();
        } //End block
        mVoiceButtonEnabled = hasVoiceSearch();
        {
            mQueryTextView.setPrivateImeOptions(IME_OPTION_NO_MICROPHONE);
        } //End block
        updateViewsVisibility(isIconified());
        // ---------- Original Method ----------
        //mSearchable = searchable;
        //if (mSearchable != null) {
            //updateSearchAutoComplete();
            //updateQueryHint();
        //}
        //mVoiceButtonEnabled = hasVoiceSearch();
        //if (mVoiceButtonEnabled) {
            //mQueryTextView.setPrivateImeOptions(IME_OPTION_NO_MICROPHONE);
        //}
        //updateViewsVisibility(isIconified());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.504 -0400", hash_original_method = "EBA44227BB74F0B08E6F1C70EA9AD0F7", hash_generated_method = "EF9CE62672B754DA6A6AC93C9D9CD980")
    @DSModeled(DSC.SAFE)
    public void setAppSearchData(Bundle appSearchData) {
        dsTaint.addTaint(appSearchData.dsTaint);
        // ---------- Original Method ----------
        //mAppSearchData = appSearchData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.504 -0400", hash_original_method = "A9C55FF5F962662498ECAD2C137876AF", hash_generated_method = "822848E6E5218716A47C9701B2E10698")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setImeOptions(int imeOptions) {
        dsTaint.addTaint(imeOptions);
        mQueryTextView.setImeOptions(imeOptions);
        // ---------- Original Method ----------
        //mQueryTextView.setImeOptions(imeOptions);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.504 -0400", hash_original_method = "48CC06180C89621288EE9E924CBC5764", hash_generated_method = "6BB9E917E85E54C24BBE66716CEE5BDF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setInputType(int inputType) {
        dsTaint.addTaint(inputType);
        mQueryTextView.setInputType(inputType);
        // ---------- Original Method ----------
        //mQueryTextView.setInputType(inputType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.504 -0400", hash_original_method = "83E343EB647417E47B475AFEA392BC7D", hash_generated_method = "9DF1DAA8C086CDE6B3D93559967E295D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean requestFocus(int direction, Rect previouslyFocusedRect) {
        dsTaint.addTaint(direction);
        dsTaint.addTaint(previouslyFocusedRect.dsTaint);
        {
            boolean var8DB70F00D9A309F787FE648FEF017045_1776303945 = (!isFocusable());
        } //End collapsed parenthetic
        {
            boolean varCD5C141A0C77A05F6864C5164FA139BA_743306448 = (!isIconified());
            {
                boolean result;
                result = mQueryTextView.requestFocus(direction, previouslyFocusedRect);
                {
                    updateViewsVisibility(false);
                } //End block
            } //End block
            {
                boolean var7EEFFE453EE8B06336FEADC34AE77D1B_1256866681 = (super.requestFocus(direction, previouslyFocusedRect));
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mClearingFocus) return false;
        //if (!isFocusable()) return false;
        //if (!isIconified()) {
            //boolean result = mQueryTextView.requestFocus(direction, previouslyFocusedRect);
            //if (result) {
                //updateViewsVisibility(false);
            //}
            //return result;
        //} else {
            //return super.requestFocus(direction, previouslyFocusedRect);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.505 -0400", hash_original_method = "65B369A9FAEBC12EA58ACD6F427C9883", hash_generated_method = "A6CAF4E8BDA1F89ACF64F4B0D6BA3049")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void clearFocus() {
        mClearingFocus = true;
        setImeVisibility(false);
        super.clearFocus();
        mQueryTextView.clearFocus();
        mClearingFocus = false;
        // ---------- Original Method ----------
        //mClearingFocus = true;
        //setImeVisibility(false);
        //super.clearFocus();
        //mQueryTextView.clearFocus();
        //mClearingFocus = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.505 -0400", hash_original_method = "5F51E4234BD6E41AFB4ED2E85F8CC1A5", hash_generated_method = "C085BA56D557CFE924E1DC44C30CF9B7")
    @DSModeled(DSC.SAFE)
    public void setOnQueryTextListener(OnQueryTextListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        // ---------- Original Method ----------
        //mOnQueryChangeListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.505 -0400", hash_original_method = "5C0B64E237CFC180C92A60294DA35470", hash_generated_method = "09D148599FCC8A272AF89831660F20C5")
    @DSModeled(DSC.SAFE)
    public void setOnCloseListener(OnCloseListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        // ---------- Original Method ----------
        //mOnCloseListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.505 -0400", hash_original_method = "2E189EEDC80EC67610C89143836C4DBB", hash_generated_method = "B74920CA5AED4B7098D141A1B09B3301")
    @DSModeled(DSC.SAFE)
    public void setOnQueryTextFocusChangeListener(OnFocusChangeListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        // ---------- Original Method ----------
        //mOnQueryTextFocusChangeListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.505 -0400", hash_original_method = "5242CF20D6A154AA5BAD996C3A14A890", hash_generated_method = "07C5D61FBA82B8AD7534562D6B4D07C0")
    @DSModeled(DSC.SAFE)
    public void setOnSuggestionListener(OnSuggestionListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        // ---------- Original Method ----------
        //mOnSuggestionListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.505 -0400", hash_original_method = "AFFD80E7D30CC6B8E84DA9D0AC11DA43", hash_generated_method = "8208CAA893549BBB6F7F39C41986A5C8")
    @DSModeled(DSC.SAFE)
    public void setOnSearchClickListener(OnClickListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        // ---------- Original Method ----------
        //mOnSearchClickListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.506 -0400", hash_original_method = "BDCF19F1BD9841AC2C41BDBA087D55A0", hash_generated_method = "45A9765C5FBE9C354980F69B6AE832AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharSequence getQuery() {
        CharSequence varB461394E71CF8D3289DF78E33DD57634_538078174 = (mQueryTextView.getText());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mQueryTextView.getText();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.506 -0400", hash_original_method = "5407FC5F92134D6A89C79A4C1515F538", hash_generated_method = "C468D353075A1C1F68DC3971E81DC273")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setQuery(CharSequence query, boolean submit) {
        dsTaint.addTaint(submit);
        dsTaint.addTaint(query);
        mQueryTextView.setText(query);
        {
            mQueryTextView.setSelection(query.length());
        } //End block
        {
            boolean var9242B3EAE17A7A89184E70A84C88F6F2_1210196324 = (submit && !TextUtils.isEmpty(query));
            {
                onSubmitQuery();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //mQueryTextView.setText(query);
        //if (query != null) {
            //mQueryTextView.setSelection(query.length());
            //mUserQuery = query;
        //}
        //if (submit && !TextUtils.isEmpty(query)) {
            //onSubmitQuery();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.506 -0400", hash_original_method = "E72A59E6C313C94D91D305DFD6AC06A2", hash_generated_method = "BEEE7205E2C023047F5313AB355E068C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setQueryHint(CharSequence hint) {
        dsTaint.addTaint(hint);
        updateQueryHint();
        // ---------- Original Method ----------
        //mQueryHint = hint;
        //updateQueryHint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.506 -0400", hash_original_method = "ACA6D63CA1F64B4CD762BEE0367B8A15", hash_generated_method = "703CCA6927177A30F32CADAA6B5DBF98")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setIconifiedByDefault(boolean iconified) {
        dsTaint.addTaint(iconified);
        updateViewsVisibility(iconified);
        updateQueryHint();
        // ---------- Original Method ----------
        //if (mIconifiedByDefault == iconified) return;
        //mIconifiedByDefault = iconified;
        //updateViewsVisibility(iconified);
        //updateQueryHint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.506 -0400", hash_original_method = "B0C72E24DA4703D19B476F7F5669A367", hash_generated_method = "A3CCDBE185CB3D52D9187EDA45314917")
    @DSModeled(DSC.SAFE)
    public boolean isIconfiedByDefault() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIconifiedByDefault;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.507 -0400", hash_original_method = "1D615B467973354655EE36C4E6E1B780", hash_generated_method = "6971E8FB5A5DE407A0996A9872E5B601")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setIconified(boolean iconify) {
        dsTaint.addTaint(iconify);
        {
            onCloseClicked();
        } //End block
        {
            onSearchClicked();
        } //End block
        // ---------- Original Method ----------
        //if (iconify) {
            //onCloseClicked();
        //} else {
            //onSearchClicked();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.507 -0400", hash_original_method = "844ED2B05054700D6A1A7C47A43DB3F5", hash_generated_method = "65C58409535619350A115262A8ACDF34")
    @DSModeled(DSC.SAFE)
    public boolean isIconified() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIconified;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.507 -0400", hash_original_method = "3C1CA8493C58EB873C43522E7F5B066C", hash_generated_method = "4AB4B87C234C89F0C21A1E0DB0CD2C0D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSubmitButtonEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        updateViewsVisibility(isIconified());
        // ---------- Original Method ----------
        //mSubmitButtonEnabled = enabled;
        //updateViewsVisibility(isIconified());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.507 -0400", hash_original_method = "A8CFD3302CC6C1FBD45FF4B867C72D5B", hash_generated_method = "6195C72D23BCD91F51F23EA10A327738")
    @DSModeled(DSC.SAFE)
    public boolean isSubmitButtonEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mSubmitButtonEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.507 -0400", hash_original_method = "29051F8E555BD7A9218D5240E768869F", hash_generated_method = "4F4F3A8108E1F4757CDC5AB0442C96BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setQueryRefinementEnabled(boolean enable) {
        dsTaint.addTaint(enable);
        {
            ((SuggestionsAdapter) mSuggestionsAdapter).setQueryRefinement(
                    enable ? SuggestionsAdapter.REFINE_ALL : SuggestionsAdapter.REFINE_BY_ENTRY);
        } //End block
        // ---------- Original Method ----------
        //mQueryRefinement = enable;
        //if (mSuggestionsAdapter instanceof SuggestionsAdapter) {
            //((SuggestionsAdapter) mSuggestionsAdapter).setQueryRefinement(
                    //enable ? SuggestionsAdapter.REFINE_ALL : SuggestionsAdapter.REFINE_BY_ENTRY);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.507 -0400", hash_original_method = "A374A24A58636548BF0B2ADA0B696601", hash_generated_method = "D5E921979CDD03764B60148BA59F9101")
    @DSModeled(DSC.SAFE)
    public boolean isQueryRefinementEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mQueryRefinement;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.508 -0400", hash_original_method = "23DC9EA74A588F20B69495720EC7B1A3", hash_generated_method = "C039AFD7811FA7B64DE7449AF4BFE6FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSuggestionsAdapter(CursorAdapter adapter) {
        dsTaint.addTaint(adapter.dsTaint);
        mQueryTextView.setAdapter(mSuggestionsAdapter);
        // ---------- Original Method ----------
        //mSuggestionsAdapter = adapter;
        //mQueryTextView.setAdapter(mSuggestionsAdapter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.508 -0400", hash_original_method = "D43CFDAE734651DCDEBEEE22CB7FB2A7", hash_generated_method = "BF530C617D324E4328EBADCCAEDE6360")
    @DSModeled(DSC.SAFE)
    public CursorAdapter getSuggestionsAdapter() {
        return (CursorAdapter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mSuggestionsAdapter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.508 -0400", hash_original_method = "8FF296A57B18752E84CEF7286CDC8903", hash_generated_method = "022755862B4465404F7AFA6EA00E10CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMaxWidth(int maxpixels) {
        dsTaint.addTaint(maxpixels);
        requestLayout();
        // ---------- Original Method ----------
        //mMaxWidth = maxpixels;
        //requestLayout();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.508 -0400", hash_original_method = "455591DBA8980F8F128C9C99FA0F791A", hash_generated_method = "42A7A7D503951274A85673DAC80DA090")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(heightMeasureSpec);
        dsTaint.addTaint(widthMeasureSpec);
        {
            boolean var9CB88D429CDA0C605332B4B8BAA0D08B_1564723280 = (isIconified());
            {
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            } //End block
        } //End collapsed parenthetic
        int widthMode;
        widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int width;
        width = MeasureSpec.getSize(widthMeasureSpec);
        //Begin case MeasureSpec.AT_MOST 
        {
            width = Math.min(mMaxWidth, width);
        } //End block
        {
            width = Math.min(getPreferredWidth(), width);
        } //End block
        //End case MeasureSpec.AT_MOST 
        //Begin case MeasureSpec.EXACTLY 
        {
            width = Math.min(mMaxWidth, width);
        } //End block
        //End case MeasureSpec.EXACTLY 
        //Begin case MeasureSpec.UNSPECIFIED 
        width = mMaxWidth > 0 ? mMaxWidth : getPreferredWidth();
        //End case MeasureSpec.UNSPECIFIED 
        widthMode = MeasureSpec.EXACTLY;
        super.onMeasure(MeasureSpec.makeMeasureSpec(width, widthMode), heightMeasureSpec);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.508 -0400", hash_original_method = "28B5EEA3A28B4F5F076920D5EA4FBBAC", hash_generated_method = "79023DD5965A46C5E5E9F6B20AB83D3D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getPreferredWidth() {
        int var1DFA48C11562BB9C778ED25A8E5697EF_975756239 = (getContext().getResources()
                .getDimensionPixelSize(R.dimen.search_view_preferred_width));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getContext().getResources()
                //.getDimensionPixelSize(R.dimen.search_view_preferred_width);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.509 -0400", hash_original_method = "7F3DE149B8C5E14764DBC69CC4EE105A", hash_generated_method = "B3BC469C585CA82331932CE3BE4FB373")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void updateViewsVisibility(final boolean collapsed) {
        dsTaint.addTaint(collapsed);
        int visCollapsed;
        visCollapsed = VISIBLE;
        visCollapsed = GONE;
        boolean hasText;
        hasText = !TextUtils.isEmpty(mQueryTextView.getText());
        mSearchButton.setVisibility(visCollapsed);
        updateSubmitButton(hasText);
        mSearchEditFrame.setVisibility(collapsed ? GONE : VISIBLE);
        mSearchHintIcon.setVisibility(mIconifiedByDefault ? GONE : VISIBLE);
        updateCloseButton();
        updateVoiceButton(!hasText);
        updateSubmitArea();
        // ---------- Original Method ----------
        //mIconified = collapsed;
        //final int visCollapsed = collapsed ? VISIBLE : GONE;
        //final boolean hasText = !TextUtils.isEmpty(mQueryTextView.getText());
        //mSearchButton.setVisibility(visCollapsed);
        //updateSubmitButton(hasText);
        //mSearchEditFrame.setVisibility(collapsed ? GONE : VISIBLE);
        //mSearchHintIcon.setVisibility(mIconifiedByDefault ? GONE : VISIBLE);
        //updateCloseButton();
        //updateVoiceButton(!hasText);
        //updateSubmitArea();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.509 -0400", hash_original_method = "1F6B21487B2FA81D5679515DB4F108DF", hash_generated_method = "107DEFF4C3A8E9FBE725DDC81B2CFC80")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean hasVoiceSearch() {
        {
            boolean var7CD733601A61864D0CEC141D0D3E93F1_11485067 = (mSearchable != null && mSearchable.getVoiceSearchEnabled());
            {
                Intent testIntent;
                testIntent = null;
                {
                    boolean varE115433D5D367A06EC1291A48F299B73_1444553482 = (mSearchable.getVoiceSearchLaunchWebSearch());
                    {
                        testIntent = mVoiceWebSearchIntent;
                    } //End block
                    {
                        boolean varDE5F6591B1893B8D2949FC45E45FA986_984688868 = (mSearchable.getVoiceSearchLaunchRecognizer());
                        {
                            testIntent = mVoiceAppSearchIntent;
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
                {
                    ResolveInfo ri;
                    ri = getContext().getPackageManager().resolveActivity(testIntent,
                        PackageManager.MATCH_DEFAULT_ONLY);
                } //End block
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mSearchable != null && mSearchable.getVoiceSearchEnabled()) {
            //Intent testIntent = null;
            //if (mSearchable.getVoiceSearchLaunchWebSearch()) {
                //testIntent = mVoiceWebSearchIntent;
            //} else if (mSearchable.getVoiceSearchLaunchRecognizer()) {
                //testIntent = mVoiceAppSearchIntent;
            //}
            //if (testIntent != null) {
                //ResolveInfo ri = getContext().getPackageManager().resolveActivity(testIntent,
                        //PackageManager.MATCH_DEFAULT_ONLY);
                //return ri != null;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.509 -0400", hash_original_method = "E98BAF533B4581CBC109A603E4339AE5", hash_generated_method = "B4BF25D7AB6DAA4AD8167B27052B29BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isSubmitAreaEnabled() {
        boolean var81656F16A1D45B5B6822129878881E75_761077482 = ((mSubmitButtonEnabled || mVoiceButtonEnabled) && !isIconified());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mSubmitButtonEnabled || mVoiceButtonEnabled) && !isIconified();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.509 -0400", hash_original_method = "956EC0D217930FCBDABBCC447139885F", hash_generated_method = "0B67B7D33F2C0DF446C8FAAF3052F58C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void updateSubmitButton(boolean hasText) {
        dsTaint.addTaint(hasText);
        int visibility;
        visibility = GONE;
        {
            boolean varC111929E1238EF6E7C5A396EC91615E0_1446220073 = (mSubmitButtonEnabled && isSubmitAreaEnabled() && hasFocus()
                && (hasText || !mVoiceButtonEnabled));
            {
                visibility = VISIBLE;
            } //End block
        } //End collapsed parenthetic
        mSubmitButton.setVisibility(visibility);
        // ---------- Original Method ----------
        //int visibility = GONE;
        //if (mSubmitButtonEnabled && isSubmitAreaEnabled() && hasFocus()
                //&& (hasText || !mVoiceButtonEnabled)) {
            //visibility = VISIBLE;
        //}
        //mSubmitButton.setVisibility(visibility);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.510 -0400", hash_original_method = "FF9871F833F63C36B3921C4F59B0ED2F", hash_generated_method = "57F3BBDF53B5E8DBD8EB25F8CF42E0A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void updateSubmitArea() {
        int visibility;
        visibility = GONE;
        {
            boolean var970FABBB7F1A591E8D4BEDE840BD2DF3_1052372729 = (isSubmitAreaEnabled()
                && (mSubmitButton.getVisibility() == VISIBLE
                        || mVoiceButton.getVisibility() == VISIBLE));
            {
                visibility = VISIBLE;
            } //End block
        } //End collapsed parenthetic
        mSubmitArea.setVisibility(visibility);
        // ---------- Original Method ----------
        //int visibility = GONE;
        //if (isSubmitAreaEnabled()
                //&& (mSubmitButton.getVisibility() == VISIBLE
                        //|| mVoiceButton.getVisibility() == VISIBLE)) {
            //visibility = VISIBLE;
        //}
        //mSubmitArea.setVisibility(visibility);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.510 -0400", hash_original_method = "31438C0932D7B883B0B6F7C1A8D11C73", hash_generated_method = "D53198375AD17F7978B8F3AB090BD95A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void updateCloseButton() {
        boolean hasText;
        hasText = !TextUtils.isEmpty(mQueryTextView.getText());
        boolean showClose;
        showClose = hasText || (mIconifiedByDefault && !mExpandedInActionView);
        mCloseButton.setVisibility(showClose ? VISIBLE : GONE);
        mCloseButton.getDrawable().setState(hasText ? ENABLED_STATE_SET : EMPTY_STATE_SET);
        // ---------- Original Method ----------
        //final boolean hasText = !TextUtils.isEmpty(mQueryTextView.getText());
        //final boolean showClose = hasText || (mIconifiedByDefault && !mExpandedInActionView);
        //mCloseButton.setVisibility(showClose ? VISIBLE : GONE);
        //mCloseButton.getDrawable().setState(hasText ? ENABLED_STATE_SET : EMPTY_STATE_SET);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.510 -0400", hash_original_method = "A19187F7BD510E54AC677DCF71153712", hash_generated_method = "E58D53BF8B2730472056F6D862C2F112")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void postUpdateFocusedState() {
        post(mUpdateDrawableStateRunnable);
        // ---------- Original Method ----------
        //post(mUpdateDrawableStateRunnable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.510 -0400", hash_original_method = "2FABE728CB7CDC63DD618939E6086EE5", hash_generated_method = "9F102B9A48DB7E4668EA50B8ACA81BBA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void updateFocusedState() {
        boolean focused;
        focused = mQueryTextView.hasFocus();
        mSearchPlate.getBackground().setState(focused ? FOCUSED_STATE_SET : EMPTY_STATE_SET);
        mSubmitArea.getBackground().setState(focused ? FOCUSED_STATE_SET : EMPTY_STATE_SET);
        invalidate();
        // ---------- Original Method ----------
        //boolean focused = mQueryTextView.hasFocus();
        //mSearchPlate.getBackground().setState(focused ? FOCUSED_STATE_SET : EMPTY_STATE_SET);
        //mSubmitArea.getBackground().setState(focused ? FOCUSED_STATE_SET : EMPTY_STATE_SET);
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.511 -0400", hash_original_method = "466B44C18A399269336D5B13075B3DD5", hash_generated_method = "541E8F066DEA567D4C20FD5E338EC369")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        removeCallbacks(mUpdateDrawableStateRunnable);
        post(mReleaseCursorRunnable);
        super.onDetachedFromWindow();
        // ---------- Original Method ----------
        //removeCallbacks(mUpdateDrawableStateRunnable);
        //post(mReleaseCursorRunnable);
        //super.onDetachedFromWindow();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.511 -0400", hash_original_method = "10C83777364EAA061E75B08DB527338D", hash_generated_method = "861A91D69DE59DC07544F81718D68AEF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setImeVisibility(final boolean visible) {
        dsTaint.addTaint(visible);
        {
            post(mShowImeRunnable);
        } //End block
        {
            removeCallbacks(mShowImeRunnable);
            InputMethodManager imm;
            imm = (InputMethodManager)
                    getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            {
                imm.hideSoftInputFromWindow(getWindowToken(), 0);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (visible) {
            //post(mShowImeRunnable);
        //} else {
            //removeCallbacks(mShowImeRunnable);
            //InputMethodManager imm = (InputMethodManager)
                    //getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            //if (imm != null) {
                //imm.hideSoftInputFromWindow(getWindowToken(), 0);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.511 -0400", hash_original_method = "364D10214479FA13BFF6BDB192F3E0CD", hash_generated_method = "185A913D248788967BDF10D60EBFE6B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void onQueryRefine(CharSequence queryText) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(queryText);
        setQuery(queryText);
        // ---------- Original Method ----------
        //setQuery(queryText);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.511 -0400", hash_original_method = "E2E8A56E8AA279DA8CFFA9FDDF535879", hash_generated_method = "E44B5E92CE69008D292577886209FA25")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        SearchableInfo.ActionKeyInfo actionKey;
        actionKey = mSearchable.findActionKey(keyCode);
        {
            boolean var5CB2730BDD0F8A6AFECB97402B427F1B_1105707629 = ((actionKey != null) && (actionKey.getQueryActionMsg() != null));
            {
                launchQuerySearch(keyCode, actionKey.getQueryActionMsg(), mQueryTextView.getText()
                    .toString());
            } //End block
        } //End collapsed parenthetic
        boolean var8C6E6C19273FC56B5C56CC7DEF63ED7B_1478143466 = (super.onKeyDown(keyCode, event));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mSearchable == null) {
            //return false;
        //}
        //SearchableInfo.ActionKeyInfo actionKey = mSearchable.findActionKey(keyCode);
        //if ((actionKey != null) && (actionKey.getQueryActionMsg() != null)) {
            //launchQuerySearch(keyCode, actionKey.getQueryActionMsg(), mQueryTextView.getText()
                    //.toString());
            //return true;
        //}
        //return super.onKeyDown(keyCode, event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.512 -0400", hash_original_method = "2292125EFE6589DCDAE880647EC125AA", hash_generated_method = "808FECF2F057ED10324BC135A4E3EF7E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean onSuggestionsKey(View v, int keyCode, KeyEvent event) {
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(v.dsTaint);
        dsTaint.addTaint(event.dsTaint);
        {
            boolean var96842DBF46FE1F5DB2349D1F8230BD47_2022889611 = (event.getAction() == KeyEvent.ACTION_DOWN && event.hasNoModifiers());
            {
                {
                    int position;
                    position = mQueryTextView.getListSelection();
                    boolean var524CB2E03CDD56BA662F9285090A5D2A_2116429034 = (onItemClicked(position, KeyEvent.KEYCODE_UNKNOWN, null));
                } //End block
                {
                    int selPoint;
                    selPoint = 0;
                    selPoint = mQueryTextView
                        .length();
                    mQueryTextView.setSelection(selPoint);
                    mQueryTextView.setListSelection(0);
                    mQueryTextView.clearListSelection();
                    mQueryTextView.ensureImeVisible(true);
                } //End block
                {
                    boolean var404CC5C85EC37EE7D9EAFA6391F0B425_87794578 = (keyCode == KeyEvent.KEYCODE_DPAD_UP && 0 == mQueryTextView.getListSelection());
                } //End collapsed parenthetic
                SearchableInfo.ActionKeyInfo actionKey;
                actionKey = mSearchable.findActionKey(keyCode);
                {
                    boolean varD6A63EA6CB82F1938533850645AC63CC_1990432142 = ((actionKey != null)
                    && ((actionKey.getSuggestActionMsg() != null) || (actionKey
                            .getSuggestActionMsgColumn() != null)));
                    {
                        int position;
                        position = mQueryTextView.getListSelection();
                        {
                            Cursor c;
                            c = mSuggestionsAdapter.getCursor();
                            {
                                boolean varAA3D0D8A8F9C1695507C58A83CA2F991_1130134239 = (c.moveToPosition(position));
                                {
                                    String actionMsg;
                                    actionMsg = getActionKeyMessage(c, actionKey);
                                    {
                                        boolean varCBF97EF6005E0ABB0B009E065E0E7581_699269882 = (actionMsg != null && (actionMsg.length() > 0));
                                        {
                                            boolean varEA30C83275615DF0CD0CC1A4EF5FFEC1_61552396 = (onItemClicked(position, keyCode, actionMsg));
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        private static String getActionKeyMessage(Cursor c, SearchableInfo.ActionKeyInfo actionKey) {
        String result = null;
        final String column = actionKey.getSuggestActionMsgColumn();
        if (column != null) {
            result = SuggestionsAdapter.getColumnString(c, column);
        }
        if (result == null) {
            result = actionKey.getSuggestActionMsg();
        }
        return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.512 -0400", hash_original_method = "587CD5DA65D790D90BAF0DE8B5BB2354", hash_generated_method = "03A635F4A99A99457057FF967460856D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getSearchIconId() {
        TypedValue outValue;
        outValue = new TypedValue();
        getContext().getTheme().resolveAttribute(com.android.internal.R.attr.searchViewSearchIcon,
                outValue, true);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //TypedValue outValue = new TypedValue();
        //getContext().getTheme().resolveAttribute(com.android.internal.R.attr.searchViewSearchIcon,
                //outValue, true);
        //return outValue.resourceId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.513 -0400", hash_original_method = "BEC25B8B383259674E4804BA5A8143D3", hash_generated_method = "52B0BADD5E965022872AF60868645802")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private CharSequence getDecoratedHint(CharSequence hintText) {
        dsTaint.addTaint(hintText);
        SpannableStringBuilder ssb;
        ssb = new SpannableStringBuilder("   ");
        ssb.append(hintText);
        Drawable searchIcon;
        searchIcon = getContext().getResources().getDrawable(getSearchIconId());
        int textSize;
        textSize = (int) (mQueryTextView.getTextSize() * 1.25);
        searchIcon.setBounds(0, 0, textSize, textSize);
        ssb.setSpan(new ImageSpan(searchIcon), 1, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (!mIconifiedByDefault) return hintText;
        //SpannableStringBuilder ssb = new SpannableStringBuilder("   ");
        //ssb.append(hintText);
        //Drawable searchIcon = getContext().getResources().getDrawable(getSearchIconId());
        //int textSize = (int) (mQueryTextView.getTextSize() * 1.25);
        //searchIcon.setBounds(0, 0, textSize, textSize);
        //ssb.setSpan(new ImageSpan(searchIcon), 1, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        //return ssb;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.513 -0400", hash_original_method = "86FF55CF6755F81D1B5EAA7CA81FA50B", hash_generated_method = "6C59B222F2990690BE5EC8F5F5426AE9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void updateQueryHint() {
        {
            mQueryTextView.setHint(getDecoratedHint(mQueryHint));
        } //End block
        {
            CharSequence hint;
            hint = null;
            int hintId;
            hintId = mSearchable.getHintId();
            {
                hint = getContext().getString(hintId);
            } //End block
            {
                mQueryTextView.setHint(getDecoratedHint(hint));
            } //End block
        } //End block
        {
            mQueryTextView.setHint(getDecoratedHint(""));
        } //End block
        // ---------- Original Method ----------
        //if (mQueryHint != null) {
            //mQueryTextView.setHint(getDecoratedHint(mQueryHint));
        //} else if (mSearchable != null) {
            //CharSequence hint = null;
            //int hintId = mSearchable.getHintId();
            //if (hintId != 0) {
                //hint = getContext().getString(hintId);
            //}
            //if (hint != null) {
                //mQueryTextView.setHint(getDecoratedHint(hint));
            //}
        //} else {
            //mQueryTextView.setHint(getDecoratedHint(""));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.513 -0400", hash_original_method = "923331D2E7E4B81B915A368FF3E97F8B", hash_generated_method = "1467F314D85CC8AEF6DF4F6F9A3BA8A8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void updateSearchAutoComplete() {
        mQueryTextView.setDropDownAnimationStyle(0);
        mQueryTextView.setThreshold(mSearchable.getSuggestThreshold());
        mQueryTextView.setImeOptions(mSearchable.getImeOptions());
        int inputType;
        inputType = mSearchable.getInputType();
        {
            inputType &= ~InputType.TYPE_TEXT_FLAG_AUTO_COMPLETE;
            {
                boolean var35AC7A1761C1124F307704E7A9FB2780_648317761 = (mSearchable.getSuggestAuthority() != null);
                {
                    inputType |= InputType.TYPE_TEXT_FLAG_AUTO_COMPLETE;
                } //End block
            } //End collapsed parenthetic
        } //End block
        mQueryTextView.setInputType(inputType);
        {
            mSuggestionsAdapter.changeCursor(null);
        } //End block
        {
            boolean var766631DCADAC65258B4B2AA4BC08BF1D_385043315 = (mSearchable.getSuggestAuthority() != null);
            {
                mSuggestionsAdapter = new SuggestionsAdapter(getContext(),
                    this, mSearchable, mOutsideDrawablesCache);
                mQueryTextView.setAdapter(mSuggestionsAdapter);
                ((SuggestionsAdapter) mSuggestionsAdapter).setQueryRefinement(
                    mQueryRefinement ? SuggestionsAdapter.REFINE_ALL
                    : SuggestionsAdapter.REFINE_BY_ENTRY);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.514 -0400", hash_original_method = "3C9F3ABEF9459DE6C607B751B6CB866E", hash_generated_method = "45EA26B6470BE2949FC5CB2AF4379727")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void updateVoiceButton(boolean empty) {
        dsTaint.addTaint(empty);
        int visibility;
        visibility = GONE;
        {
            boolean var90713B33485BF631D704E35E86303098_1833734215 = (mVoiceButtonEnabled && !isIconified() && empty);
            {
                visibility = VISIBLE;
                mSubmitButton.setVisibility(GONE);
            } //End block
        } //End collapsed parenthetic
        mVoiceButton.setVisibility(visibility);
        // ---------- Original Method ----------
        //int visibility = GONE;
        //if (mVoiceButtonEnabled && !isIconified() && empty) {
            //visibility = VISIBLE;
            //mSubmitButton.setVisibility(GONE);
        //}
        //mVoiceButton.setVisibility(visibility);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.514 -0400", hash_original_method = "1411F54CFFACC3FC33F099091662F124", hash_generated_method = "A6726249DACBF89E236BE97E42B77C98")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void onTextChanged(CharSequence newText) {
        dsTaint.addTaint(newText);
        CharSequence text;
        text = mQueryTextView.getText();
        mUserQuery = text;
        boolean hasText;
        hasText = !TextUtils.isEmpty(text);
        updateSubmitButton(hasText);
        updateVoiceButton(!hasText);
        updateCloseButton();
        updateSubmitArea();
        {
            boolean var323E3AECC67129F3B90BD3247116BE94_1070232760 = (mOnQueryChangeListener != null && !TextUtils.equals(newText, mOldQueryText));
            {
                mOnQueryChangeListener.onQueryTextChange(newText.toString());
            } //End block
        } //End collapsed parenthetic
        mOldQueryText = newText.toString();
        // ---------- Original Method ----------
        //CharSequence text = mQueryTextView.getText();
        //mUserQuery = text;
        //boolean hasText = !TextUtils.isEmpty(text);
        //updateSubmitButton(hasText);
        //updateVoiceButton(!hasText);
        //updateCloseButton();
        //updateSubmitArea();
        //if (mOnQueryChangeListener != null && !TextUtils.equals(newText, mOldQueryText)) {
            //mOnQueryChangeListener.onQueryTextChange(newText.toString());
        //}
        //mOldQueryText = newText.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.514 -0400", hash_original_method = "5AEA0BD14CD513B7E21145454A43DADF", hash_generated_method = "5CC5496CA960DEDFBD7E73F9F36E6E5A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void onSubmitQuery() {
        CharSequence query;
        query = mQueryTextView.getText();
        {
            boolean var0D033082B10BC0B3B14D4B2164FDB866_995583780 = (query != null && TextUtils.getTrimmedLength(query) > 0);
            {
                {
                    boolean varEB8F49EA341CCD6D5D4625046BE9A9DC_1161697701 = (mOnQueryChangeListener == null
                    || !mOnQueryChangeListener.onQueryTextSubmit(query.toString()));
                    {
                        {
                            launchQuerySearch(KeyEvent.KEYCODE_UNKNOWN, null, query.toString());
                            setImeVisibility(false);
                        } //End block
                        dismissSuggestions();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //CharSequence query = mQueryTextView.getText();
        //if (query != null && TextUtils.getTrimmedLength(query) > 0) {
            //if (mOnQueryChangeListener == null
                    //|| !mOnQueryChangeListener.onQueryTextSubmit(query.toString())) {
                //if (mSearchable != null) {
                    //launchQuerySearch(KeyEvent.KEYCODE_UNKNOWN, null, query.toString());
                    //setImeVisibility(false);
                //}
                //dismissSuggestions();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.515 -0400", hash_original_method = "8D9A2C9AF67AD5F3EB2818A3F7453E73", hash_generated_method = "D7D68B4D8980045DB76C85CF1D652798")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void dismissSuggestions() {
        mQueryTextView.dismissDropDown();
        // ---------- Original Method ----------
        //mQueryTextView.dismissDropDown();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.515 -0400", hash_original_method = "E1C21CB17E5E6548A25ED1EEE1C98C9D", hash_generated_method = "B48A9BD38EC487DA3670DCC7671892FF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void onCloseClicked() {
        CharSequence text;
        text = mQueryTextView.getText();
        {
            boolean var6C86A511CD0D2845B6E0259573F6A612_1122486137 = (TextUtils.isEmpty(text));
            {
                {
                    {
                        boolean varD565EFD0C61B0AA0DDB6D792ED5EB23E_807315008 = (mOnCloseListener == null || !mOnCloseListener.onClose());
                        {
                            clearFocus();
                            updateViewsVisibility(true);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
            {
                mQueryTextView.setText("");
                mQueryTextView.requestFocus();
                setImeVisibility(true);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //CharSequence text = mQueryTextView.getText();
        //if (TextUtils.isEmpty(text)) {
            //if (mIconifiedByDefault) {
                //if (mOnCloseListener == null || !mOnCloseListener.onClose()) {
                    //clearFocus();
                    //updateViewsVisibility(true);
                //}
            //}
        //} else {
            //mQueryTextView.setText("");
            //mQueryTextView.requestFocus();
            //setImeVisibility(true);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.516 -0400", hash_original_method = "4C174341C531719A99E642D8022F787E", hash_generated_method = "A1D5AAB78161FB95636B4F354E411467")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void onSearchClicked() {
        updateViewsVisibility(false);
        mQueryTextView.requestFocus();
        setImeVisibility(true);
        {
            mOnSearchClickListener.onClick(this);
        } //End block
        // ---------- Original Method ----------
        //updateViewsVisibility(false);
        //mQueryTextView.requestFocus();
        //setImeVisibility(true);
        //if (mOnSearchClickListener != null) {
            //mOnSearchClickListener.onClick(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.516 -0400", hash_original_method = "5B2168D9C175988BD80847D561C5C5CC", hash_generated_method = "DAD71DBE1161742CB3D709BBFCCEADA7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void onVoiceClicked() {
        SearchableInfo searchable;
        searchable = mSearchable;
        try 
        {
            {
                boolean varA7C415A860984F74F13F2B5F35E99AF8_904389113 = (searchable.getVoiceSearchLaunchWebSearch());
                {
                    Intent webSearchIntent;
                    webSearchIntent = createVoiceWebSearchIntent(mVoiceWebSearchIntent,
                        searchable);
                    getContext().startActivity(webSearchIntent);
                } //End block
                {
                    boolean var645D8F4ECB1C0F7F11811AA98A572600_1949656779 = (searchable.getVoiceSearchLaunchRecognizer());
                    {
                        Intent appSearchIntent;
                        appSearchIntent = createVoiceAppSearchIntent(mVoiceAppSearchIntent,
                        searchable);
                        getContext().startActivity(appSearchIntent);
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        catch (ActivityNotFoundException e)
        { }
        // ---------- Original Method ----------
        //if (mSearchable == null) {
            //return;
        //}
        //SearchableInfo searchable = mSearchable;
        //try {
            //if (searchable.getVoiceSearchLaunchWebSearch()) {
                //Intent webSearchIntent = createVoiceWebSearchIntent(mVoiceWebSearchIntent,
                        //searchable);
                //getContext().startActivity(webSearchIntent);
            //} else if (searchable.getVoiceSearchLaunchRecognizer()) {
                //Intent appSearchIntent = createVoiceAppSearchIntent(mVoiceAppSearchIntent,
                        //searchable);
                //getContext().startActivity(appSearchIntent);
            //}
        //} catch (ActivityNotFoundException e) {
            //Log.w(LOG_TAG, "Could not find voice search activity");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.516 -0400", hash_original_method = "4D3FC77D85FEC9D80C6560FAE74CDA60", hash_generated_method = "03864FF2D85E73C463914096D79A27EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void onTextFocusChanged() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        updateViewsVisibility(isIconified());
        postUpdateFocusedState();
        {
            boolean varD5B56093B4D5DB9CF48D5816CF04A069_166906973 = (mQueryTextView.hasFocus());
            {
                forceSuggestionQuery();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //updateViewsVisibility(isIconified());
        //postUpdateFocusedState();
        //if (mQueryTextView.hasFocus()) {
            //forceSuggestionQuery();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.516 -0400", hash_original_method = "6BC34AF35099192BA7E60BCC11E3C756", hash_generated_method = "24FD7A4DEC3974221F378785EFCB80E5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(hasWindowFocus);
        super.onWindowFocusChanged(hasWindowFocus);
        postUpdateFocusedState();
        // ---------- Original Method ----------
        //super.onWindowFocusChanged(hasWindowFocus);
        //postUpdateFocusedState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.517 -0400", hash_original_method = "5D7477A3D9C6D568A19E621F4FAE5DD7", hash_generated_method = "657A76175C5C027E0A83AC8F0E70E279")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onActionViewCollapsed() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        clearFocus();
        updateViewsVisibility(true);
        mQueryTextView.setImeOptions(mCollapsedImeOptions);
        mExpandedInActionView = false;
        // ---------- Original Method ----------
        //clearFocus();
        //updateViewsVisibility(true);
        //mQueryTextView.setImeOptions(mCollapsedImeOptions);
        //mExpandedInActionView = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.517 -0400", hash_original_method = "F734C19BE6B7D5E142C7745125215DDF", hash_generated_method = "131F0E66390DDDCCE1C64EE3296721EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onActionViewExpanded() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mExpandedInActionView = true;
        mCollapsedImeOptions = mQueryTextView.getImeOptions();
        mQueryTextView.setImeOptions(mCollapsedImeOptions | EditorInfo.IME_FLAG_NO_FULLSCREEN);
        mQueryTextView.setText("");
        setIconified(false);
        // ---------- Original Method ----------
        //if (mExpandedInActionView) return;
        //mExpandedInActionView = true;
        //mCollapsedImeOptions = mQueryTextView.getImeOptions();
        //mQueryTextView.setImeOptions(mCollapsedImeOptions | EditorInfo.IME_FLAG_NO_FULLSCREEN);
        //mQueryTextView.setText("");
        //setIconified(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.517 -0400", hash_original_method = "C8142821EB0396ABFD0EB3B305480E27", hash_generated_method = "0FCEA8FE392227B6C7A1A3251FFEB2B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void adjustDropDownSizeAndPosition() {
        {
            boolean varBDFC2850FDF993A89C978164A3FC182E_10311120 = (mDropDownAnchor.getWidth() > 1);
            {
                Resources res;
                res = getContext().getResources();
                int anchorPadding;
                anchorPadding = mSearchPlate.getPaddingLeft();
                Rect dropDownPadding;
                dropDownPadding = new Rect();
                int iconOffset;
                iconOffset = res.getDimensionPixelSize(R.dimen.dropdownitem_icon_width)
                    + res.getDimensionPixelSize(R.dimen.dropdownitem_text_padding_left);
                iconOffset = 0;
                mQueryTextView.getDropDownBackground().getPadding(dropDownPadding);
                mQueryTextView.setDropDownHorizontalOffset(-(dropDownPadding.left + iconOffset)
                    + anchorPadding);
                mQueryTextView.setDropDownWidth(mDropDownAnchor.getWidth() + dropDownPadding.left
                    + dropDownPadding.right + iconOffset - (anchorPadding));
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.517 -0400", hash_original_method = "5FDC493391F791D62FF75AE849BF4213", hash_generated_method = "CB4C9C5F77878BA8090D8B3C97D16882")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean onItemClicked(int position, int actionKey, String actionMsg) {
        dsTaint.addTaint(position);
        dsTaint.addTaint(actionMsg);
        dsTaint.addTaint(actionKey);
        {
            boolean var350FE6BC9A4CD5C160297254EB8318B3_1263199224 = (mOnSuggestionListener == null
                || !mOnSuggestionListener.onSuggestionClick(position));
            {
                launchSuggestion(position, KeyEvent.KEYCODE_UNKNOWN, null);
                setImeVisibility(false);
                dismissSuggestions();
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mOnSuggestionListener == null
                //|| !mOnSuggestionListener.onSuggestionClick(position)) {
            //launchSuggestion(position, KeyEvent.KEYCODE_UNKNOWN, null);
            //setImeVisibility(false);
            //dismissSuggestions();
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.518 -0400", hash_original_method = "08FFA8C71E803D9BC52878D0BDC1227B", hash_generated_method = "CAD14348BDCD1E10260B7E0247579092")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean onItemSelected(int position) {
        dsTaint.addTaint(position);
        {
            boolean varD0AB4A987152B8EC35399136FBAE5E5E_366551064 = (mOnSuggestionListener == null
                || !mOnSuggestionListener.onSuggestionSelect(position));
            {
                rewriteQueryFromSuggestion(position);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mOnSuggestionListener == null
                //|| !mOnSuggestionListener.onSuggestionSelect(position)) {
            //rewriteQueryFromSuggestion(position);
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.518 -0400", hash_original_method = "FE5C7BD493A3B7C4988BF7B094450FE1", hash_generated_method = "AF2FE443B4B7B639D0760A54B1154864")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void rewriteQueryFromSuggestion(int position) {
        dsTaint.addTaint(position);
        CharSequence oldQuery;
        oldQuery = mQueryTextView.getText();
        Cursor c;
        c = mSuggestionsAdapter.getCursor();
        {
            boolean var13F64BF59FABCAB989EC616298EA3580_195888636 = (c.moveToPosition(position));
            {
                CharSequence newQuery;
                newQuery = mSuggestionsAdapter.convertToString(c);
                {
                    setQuery(newQuery);
                } //End block
                {
                    setQuery(oldQuery);
                } //End block
            } //End block
            {
                setQuery(oldQuery);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //CharSequence oldQuery = mQueryTextView.getText();
        //Cursor c = mSuggestionsAdapter.getCursor();
        //if (c == null) {
            //return;
        //}
        //if (c.moveToPosition(position)) {
            //CharSequence newQuery = mSuggestionsAdapter.convertToString(c);
            //if (newQuery != null) {
                //setQuery(newQuery);
            //} else {
                //setQuery(oldQuery);
            //}
        //} else {
            //setQuery(oldQuery);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.518 -0400", hash_original_method = "1026A945AA7D5E936A04225BB74423F6", hash_generated_method = "924F9F3DB9D2DF943B2B6286FF9B50AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean launchSuggestion(int position, int actionKey, String actionMsg) {
        dsTaint.addTaint(position);
        dsTaint.addTaint(actionMsg);
        dsTaint.addTaint(actionKey);
        Cursor c;
        c = mSuggestionsAdapter.getCursor();
        {
            boolean var74E5271F2D14A3901C9E07AB7568B5C7_46592680 = ((c != null) && c.moveToPosition(position));
            {
                Intent intent;
                intent = createIntentFromSuggestion(c, actionKey, actionMsg);
                launchIntent(intent);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Cursor c = mSuggestionsAdapter.getCursor();
        //if ((c != null) && c.moveToPosition(position)) {
            //Intent intent = createIntentFromSuggestion(c, actionKey, actionMsg);
            //launchIntent(intent);
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.518 -0400", hash_original_method = "B092F13CA13C6A372C37DCEFCF94B5BC", hash_generated_method = "023BDC8BB36B02A1DC3134A885F9FAE6")
    @DSModeled(DSC.SPEC)
    private void launchIntent(Intent intent) {
        dsTaint.addTaint(intent.dsTaint);
        try 
        {
            getContext().startActivity(intent);
        } //End block
        catch (RuntimeException ex)
        { }
        // ---------- Original Method ----------
        //if (intent == null) {
            //return;
        //}
        //try {
            //getContext().startActivity(intent);
        //} catch (RuntimeException ex) {
            //Log.e(LOG_TAG, "Failed launch activity: " + intent, ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.519 -0400", hash_original_method = "39B31EC96E94C2151059B7594679485C", hash_generated_method = "ABF1F43C2739E978A28B7FF4C8017480")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setQuery(CharSequence query) {
        dsTaint.addTaint(query);
        mQueryTextView.setText(query, true);
        mQueryTextView.setSelection(TextUtils.isEmpty(query) ? 0 : query.length());
        // ---------- Original Method ----------
        //mQueryTextView.setText(query, true);
        //mQueryTextView.setSelection(TextUtils.isEmpty(query) ? 0 : query.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.519 -0400", hash_original_method = "A610C255BB7D93FEE4A49CEF406D7E3C", hash_generated_method = "A8657B2C2A1D227BBDFA132183F7D92A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void launchQuerySearch(int actionKey, String actionMsg, String query) {
        dsTaint.addTaint(query);
        dsTaint.addTaint(actionMsg);
        dsTaint.addTaint(actionKey);
        String action;
        action = Intent.ACTION_SEARCH;
        Intent intent;
        intent = createIntent(action, null, null, query, actionKey, actionMsg);
        getContext().startActivity(intent);
        // ---------- Original Method ----------
        //String action = Intent.ACTION_SEARCH;
        //Intent intent = createIntent(action, null, null, query, actionKey, actionMsg);
        //getContext().startActivity(intent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.519 -0400", hash_original_method = "7931502AE551A2F220A0C85C1181EB09", hash_generated_method = "5B90F8AC6D5584509599B7B0E477A10E")
    @DSModeled(DSC.SPEC)
    private Intent createIntent(String action, Uri data, String extraData, String query,
            int actionKey, String actionMsg) {
        dsTaint.addTaint(query);
        dsTaint.addTaint(data.dsTaint);
        dsTaint.addTaint(action);
        dsTaint.addTaint(extraData);
        dsTaint.addTaint(actionMsg);
        dsTaint.addTaint(actionKey);
        Intent intent;
        intent = new Intent(action);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        {
            intent.setData(data);
        } //End block
        intent.putExtra(SearchManager.USER_QUERY, mUserQuery);
        {
            intent.putExtra(SearchManager.QUERY, query);
        } //End block
        {
            intent.putExtra(SearchManager.EXTRA_DATA_KEY, extraData);
        } //End block
        {
            intent.putExtra(SearchManager.APP_DATA, mAppSearchData);
        } //End block
        {
            intent.putExtra(SearchManager.ACTION_KEY, actionKey);
            intent.putExtra(SearchManager.ACTION_MSG, actionMsg);
        } //End block
        intent.setComponent(mSearchable.getSearchActivity());
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.519 -0400", hash_original_method = "88ED2A4CD1E55FCB278985A3652D43A1", hash_generated_method = "5B89F72506989402B36B85A298DB4946")
    @DSModeled(DSC.SPEC)
    private Intent createVoiceWebSearchIntent(Intent baseIntent, SearchableInfo searchable) {
        dsTaint.addTaint(baseIntent.dsTaint);
        dsTaint.addTaint(searchable.dsTaint);
        Intent voiceIntent;
        voiceIntent = new Intent(baseIntent);
        ComponentName searchActivity;
        searchActivity = searchable.getSearchActivity();
        voiceIntent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, searchActivity == null ? null
                : searchActivity.flattenToShortString());
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Intent voiceIntent = new Intent(baseIntent);
        //ComponentName searchActivity = searchable.getSearchActivity();
        //voiceIntent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, searchActivity == null ? null
                //: searchActivity.flattenToShortString());
        //return voiceIntent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.520 -0400", hash_original_method = "7F7E8A56997E65BDFC7ADF14F1E923E9", hash_generated_method = "5809D452DDF9AE8514610FD8CD7262E0")
    @DSModeled(DSC.SPEC)
    private Intent createVoiceAppSearchIntent(Intent baseIntent, SearchableInfo searchable) {
        dsTaint.addTaint(baseIntent.dsTaint);
        dsTaint.addTaint(searchable.dsTaint);
        ComponentName searchActivity;
        searchActivity = searchable.getSearchActivity();
        Intent queryIntent;
        queryIntent = new Intent(Intent.ACTION_SEARCH);
        queryIntent.setComponent(searchActivity);
        PendingIntent pending;
        pending = PendingIntent.getActivity(getContext(), 0, queryIntent,
                PendingIntent.FLAG_ONE_SHOT);
        Bundle queryExtras;
        queryExtras = new Bundle();
        Intent voiceIntent;
        voiceIntent = new Intent(baseIntent);
        String languageModel;
        languageModel = RecognizerIntent.LANGUAGE_MODEL_FREE_FORM;
        String prompt;
        prompt = null;
        String language;
        language = null;
        int maxResults;
        maxResults = 1;
        Resources resources;
        resources = getResources();
        {
            boolean varBBE4CD039A6A00BFEFC751059FE85B4F_294617213 = (searchable.getVoiceLanguageModeId() != 0);
            {
                languageModel = resources.getString(searchable.getVoiceLanguageModeId());
            } //End block
        } //End collapsed parenthetic
        {
            boolean varAC8E073C8A191629EF47CD10960E1E5F_1898178515 = (searchable.getVoicePromptTextId() != 0);
            {
                prompt = resources.getString(searchable.getVoicePromptTextId());
            } //End block
        } //End collapsed parenthetic
        {
            boolean varC746CB3F134BCAA7F8EF0771FDB78FED_738178339 = (searchable.getVoiceLanguageId() != 0);
            {
                language = resources.getString(searchable.getVoiceLanguageId());
            } //End block
        } //End collapsed parenthetic
        {
            boolean var2E746E5A42346C8832AA6F44EE0CF45F_1424640233 = (searchable.getVoiceMaxResults() != 0);
            {
                maxResults = searchable.getVoiceMaxResults();
            } //End block
        } //End collapsed parenthetic
        voiceIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, languageModel);
        voiceIntent.putExtra(RecognizerIntent.EXTRA_PROMPT, prompt);
        voiceIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, language);
        voiceIntent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, maxResults);
        voiceIntent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, searchActivity == null ? null
                : searchActivity.flattenToShortString());
        voiceIntent.putExtra(RecognizerIntent.EXTRA_RESULTS_PENDINGINTENT, pending);
        voiceIntent.putExtra(RecognizerIntent.EXTRA_RESULTS_PENDINGINTENT_BUNDLE, queryExtras);
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.520 -0400", hash_original_method = "830957C509294E2BDC3732D8A42E8F7A", hash_generated_method = "362C73350C03E3D9976440E01AC0394D")
    @DSModeled(DSC.SPEC)
    private Intent createIntentFromSuggestion(Cursor c, int actionKey, String actionMsg) {
        dsTaint.addTaint(c.dsTaint);
        dsTaint.addTaint(actionMsg);
        dsTaint.addTaint(actionKey);
        try 
        {
            String action;
            action = getColumnString(c, SearchManager.SUGGEST_COLUMN_INTENT_ACTION);
            {
                action = mSearchable.getSuggestIntentAction();
            } //End block
            {
                action = Intent.ACTION_SEARCH;
            } //End block
            String data;
            data = getColumnString(c, SearchManager.SUGGEST_COLUMN_INTENT_DATA);
            {
                data = mSearchable.getSuggestIntentData();
            } //End block
            {
                String id;
                id = getColumnString(c, SearchManager.SUGGEST_COLUMN_INTENT_DATA_ID);
                {
                    data = data + "/" + Uri.encode(id);
                } //End block
            } //End block
            Uri dataUri;
            dataUri = null;
            dataUri = Uri.parse(data);
            String query;
            query = getColumnString(c, SearchManager.SUGGEST_COLUMN_QUERY);
            String extraData;
            extraData = getColumnString(c, SearchManager.SUGGEST_COLUMN_INTENT_EXTRA_DATA);
            Intent varD861FF2D721A4D11F2352C409E2BE356_248150078 = (createIntent(action, dataUri, extraData, query, actionKey, actionMsg));
        } //End block
        catch (RuntimeException e)
        {
            int rowNum;
            try 
            {
                rowNum = c.getPosition();
            } //End block
            catch (RuntimeException e2)
            {
                rowNum = -1;
            } //End block
        } //End block
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.521 -0400", hash_original_method = "7E9F5D2AEBB04ECB1BF9832E28C48CE5", hash_generated_method = "842B7E3CB61461A203AD10E7DC7E1B6F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void forceSuggestionQuery() {
        mQueryTextView.doBeforeTextChanged();
        mQueryTextView.doAfterTextChanged();
        // ---------- Original Method ----------
        //mQueryTextView.doBeforeTextChanged();
        //mQueryTextView.doAfterTextChanged();
    }

    
        static boolean isLandscapeMode(Context context) {
        return context.getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_LANDSCAPE;
    }

    
    public static class SearchAutoComplete extends AutoCompleteTextView {
        private int mThreshold;
        private SearchView mSearchView;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.521 -0400", hash_original_method = "0EFA734BA823B47BC95B6AD45B9E23E2", hash_generated_method = "484CD6B46B40673A5E6B87327E211634")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SearchAutoComplete(Context context) {
            super(context);
            dsTaint.addTaint(context.dsTaint);
            mThreshold = getThreshold();
            // ---------- Original Method ----------
            //mThreshold = getThreshold();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.521 -0400", hash_original_method = "D2F6F380F4593BE38169820FCC450031", hash_generated_method = "7684BC25756DF4A8201E471B65A62873")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SearchAutoComplete(Context context, AttributeSet attrs) {
            super(context, attrs);
            dsTaint.addTaint(attrs.dsTaint);
            dsTaint.addTaint(context.dsTaint);
            mThreshold = getThreshold();
            // ---------- Original Method ----------
            //mThreshold = getThreshold();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.521 -0400", hash_original_method = "6D01382B108C5B979A3DE77D2755BA0A", hash_generated_method = "03B46EF72C51CE38D15757602C201D75")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SearchAutoComplete(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
            dsTaint.addTaint(attrs.dsTaint);
            dsTaint.addTaint(defStyle);
            dsTaint.addTaint(context.dsTaint);
            mThreshold = getThreshold();
            // ---------- Original Method ----------
            //mThreshold = getThreshold();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.522 -0400", hash_original_method = "BBDE2605DAB20A62DF5DDA8DAF1B33B9", hash_generated_method = "5196D50080C5A1209AED92A319AD0523")
        @DSModeled(DSC.SAFE)
         void setSearchView(SearchView searchView) {
            dsTaint.addTaint(searchView.dsTaint);
            // ---------- Original Method ----------
            //mSearchView = searchView;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.522 -0400", hash_original_method = "2A2464279ECB52A9D86939A6AE2D6FFF", hash_generated_method = "122C8225F791601C5247C9B700BDB1B2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void setThreshold(int threshold) {
            dsTaint.addTaint(threshold);
            super.setThreshold(threshold);
            // ---------- Original Method ----------
            //super.setThreshold(threshold);
            //mThreshold = threshold;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.522 -0400", hash_original_method = "BA394CC4782335931E16390E53BDBA7F", hash_generated_method = "D40BE07D4C7C13692DAEAC3F055D5232")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private boolean isEmpty() {
            boolean var3DC6FA609B5525FAC46D05EECEA6786A_1436530263 = (TextUtils.getTrimmedLength(getText()) == 0);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return TextUtils.getTrimmedLength(getText()) == 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.522 -0400", hash_original_method = "04EDD552CD5932834AB8E3EAD2670FCB", hash_generated_method = "B957A42B227069BD2C2F1C79AB9497E3")
        @DSModeled(DSC.SAFE)
        @Override
        protected void replaceText(CharSequence text) {
            dsTaint.addTaint(text);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.522 -0400", hash_original_method = "BBB8F048947DA4F8E171ED984E24E3AE", hash_generated_method = "65E30508731680C780234FF5491E8384")
        @DSModeled(DSC.SAFE)
        @Override
        public void performCompletion() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.522 -0400", hash_original_method = "3777C1088ADE560024EE2C32D034B492", hash_generated_method = "89205D4203E9F305D4F8979411DA5829")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void onWindowFocusChanged(boolean hasWindowFocus) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(hasWindowFocus);
            super.onWindowFocusChanged(hasWindowFocus);
            {
                boolean var07827550B2C2F4C2AD19C2B83045B0B0_922113196 = (hasWindowFocus && mSearchView.hasFocus() && getVisibility() == VISIBLE);
                {
                    InputMethodManager inputManager;
                    inputManager = (InputMethodManager) getContext()
                        .getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputManager.showSoftInput(this, 0);
                    {
                        boolean var962BF569303E770457EF5B953E22B6C6_994577090 = (isLandscapeMode(getContext()));
                        {
                            ensureImeVisible(true);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //super.onWindowFocusChanged(hasWindowFocus);
            //if (hasWindowFocus && mSearchView.hasFocus() && getVisibility() == VISIBLE) {
                //InputMethodManager inputManager = (InputMethodManager) getContext()
                        //.getSystemService(Context.INPUT_METHOD_SERVICE);
                //inputManager.showSoftInput(this, 0);
                //if (isLandscapeMode(getContext())) {
                    //ensureImeVisible(true);
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.523 -0400", hash_original_method = "5F63BE621D8AAF87B5CC12EFB3AE40CE", hash_generated_method = "5A432AA9290092FEAB517B7FDC24818E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(direction);
            dsTaint.addTaint(previouslyFocusedRect.dsTaint);
            dsTaint.addTaint(focused);
            super.onFocusChanged(focused, direction, previouslyFocusedRect);
            mSearchView.onTextFocusChanged();
            // ---------- Original Method ----------
            //super.onFocusChanged(focused, direction, previouslyFocusedRect);
            //mSearchView.onTextFocusChanged();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.523 -0400", hash_original_method = "E5C7430DC03439C4054C8D137460F5A5", hash_generated_method = "F19ADBD0F9B6C2DF52AC35007E70DF75")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean enoughToFilter() {
            boolean varC2A9CA7695220720B0749D6800887CAB_218447645 = (mThreshold <= 0 || super.enoughToFilter());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mThreshold <= 0 || super.enoughToFilter();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.523 -0400", hash_original_method = "AB0021D21F9078098334FA1D38399275", hash_generated_method = "7B68FD83B47ACC00A00692874767E9EB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean onKeyPreIme(int keyCode, KeyEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(keyCode);
            dsTaint.addTaint(event.dsTaint);
            {
                {
                    boolean var51947D54DEEA690F1B41A17DE6323711_694860084 = (event.getAction() == KeyEvent.ACTION_DOWN && event.getRepeatCount() == 0);
                    {
                        KeyEvent.DispatcherState state;
                        state = getKeyDispatcherState();
                        {
                            state.startTracking(event, this);
                        } //End block
                    } //End block
                    {
                        boolean varA6D964A9D1A4D1D485BD8D60F2BFCDEE_1485965950 = (event.getAction() == KeyEvent.ACTION_UP);
                        {
                            KeyEvent.DispatcherState state;
                            state = getKeyDispatcherState();
                            {
                                state.handleUpEvent(event);
                            } //End block
                            {
                                boolean varBE09C907F92D135687297C67489D82A5_98172647 = (event.isTracking() && !event.isCanceled());
                                {
                                    mSearchView.clearFocus();
                                    mSearchView.setImeVisibility(false);
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
            boolean var5970925D52CD103B5580C9C1CCD0A863_539198088 = (super.onKeyPreIme(keyCode, event));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    public interface OnQueryTextListener {

        
        boolean onQueryTextSubmit(String query);

        
        boolean onQueryTextChange(String newText);
    }
    
    public interface OnCloseListener {

        
        boolean onClose();
    }
    
    public interface OnSuggestionListener {

        
        boolean onSuggestionSelect(int position);

        
        boolean onSuggestionClick(int position);
    }
    
    private static final boolean DBG = false;
    private static final String LOG_TAG = "SearchView";
    private static final String IME_OPTION_NO_MICROPHONE = "nm";
}

