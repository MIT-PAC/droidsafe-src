package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.text.InputType;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;

public class SearchDialog extends Dialog {
    private TextView mBadgeLabel;
    private ImageView mAppIcon;
    private AutoCompleteTextView mSearchAutoComplete;
    private View mSearchPlate;
    private SearchView mSearchView;
    private Drawable mWorkingSpinner;
    private View mCloseSearch;
    private SearchableInfo mSearchable;
    private ComponentName mLaunchComponent;
    private Bundle mAppSearchData;
    private Context mActivityContext;
    private Intent mVoiceWebSearchIntent;
    private Intent mVoiceAppSearchIntent;
    private String mUserQuery;
    private int mSearchAutoCompleteImeOptions;
    private BroadcastReceiver mConfChangeListener = new BroadcastReceiver() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.596 -0400", hash_original_method = "61FB59FECA93F3EDF27E6A33F699149F", hash_generated_method = "9298340FF1F3DC1B66CF31143744E097")
        @DSModeled(DSC.SPEC)
        @Override
        public void onReceive(Context context, Intent intent) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(context.dsTaint);
            dsTaint.addTaint(intent.dsTaint);
            {
                boolean varE405DF0F97C7D559E41F379AE2677168_291298021 = (intent.getAction().equals(Intent.ACTION_CONFIGURATION_CHANGED));
                {
                    onConfigurationChanged();
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if (intent.getAction().equals(Intent.ACTION_CONFIGURATION_CHANGED)) {
                //onConfigurationChanged();
            //}
        }

        
}; //Transformed anonymous class
    private final SearchView.OnCloseListener mOnCloseListener = new SearchView.OnCloseListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.596 -0400", hash_original_method = "59E568E09AB29194E5325B85C030BFA7", hash_generated_method = "56FFDE85510586E3A6018F82F0D16375")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean onClose() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            boolean var7C756DC13C2D8A9436460F5A2B0F353B_281839669 = (onClosePressed());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return onClosePressed();
        }

        
}; //Transformed anonymous class
    private final SearchView.OnQueryTextListener mOnQueryChangeListener = new SearchView.OnQueryTextListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.596 -0400", hash_original_method = "E09154FCFE3F9A3A23F9DDB58EA399A5", hash_generated_method = "792316740B4A38B63005350D20A480F1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean onQueryTextSubmit(String query) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(query);
            dismiss();
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //dismiss();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.597 -0400", hash_original_method = "B6F5742F5D55A0164A53BADD48E4641B", hash_generated_method = "E4430735EF98C62011E6904C17CFBA3A")
        @DSModeled(DSC.SAFE)
        public boolean onQueryTextChange(String newText) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(newText);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return false;
        }

        
}; //Transformed anonymous class
    private final SearchView.OnSuggestionListener mOnSuggestionSelectionListener = new SearchView.OnSuggestionListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.597 -0400", hash_original_method = "A3A230CAC466D18E54C97A3930C1550C", hash_generated_method = "DB1D02E1F8AAD5AF824864E1DDB513FE")
        @DSModeled(DSC.SAFE)
        public boolean onSuggestionSelect(int position) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(position);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.597 -0400", hash_original_method = "59D851DE147AEDB85EE9900538C05E02", hash_generated_method = "EB514DB92E46997EA91AD40FC43883B7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean onSuggestionClick(int position) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(position);
            dismiss();
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //dismiss();
            //return false;
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.598 -0400", hash_original_method = "F1210797C1F332443A604D5C626C1E55", hash_generated_method = "ACCE65FF8B32694B1AA3BA7FD5B50008")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SearchDialog(Context context, SearchManager searchManager) {
        super(context, resolveDialogTheme(context));
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(searchManager.dsTaint);
        mVoiceWebSearchIntent = new Intent(RecognizerIntent.ACTION_WEB_SEARCH);
        mVoiceWebSearchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mVoiceWebSearchIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_WEB_SEARCH);
        mVoiceAppSearchIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        mVoiceAppSearchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        // ---------- Original Method ----------
        //mVoiceWebSearchIntent = new Intent(RecognizerIntent.ACTION_WEB_SEARCH);
        //mVoiceWebSearchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //mVoiceWebSearchIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                //RecognizerIntent.LANGUAGE_MODEL_WEB_SEARCH);
        //mVoiceAppSearchIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        //mVoiceAppSearchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    }

    
        static int resolveDialogTheme(Context context) {
        TypedValue outValue = new TypedValue();
        context.getTheme().resolveAttribute(com.android.internal.R.attr.searchDialogTheme,
                outValue, true);
        return outValue.resourceId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.599 -0400", hash_original_method = "ADA44CDEEADE302052A002E44C1889B1", hash_generated_method = "AB4A343C944F4FFB53ED881FE17655D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(savedInstanceState.dsTaint);
        super.onCreate(savedInstanceState);
        Window theWindow;
        theWindow = getWindow();
        WindowManager.LayoutParams lp;
        lp = theWindow.getAttributes();
        lp.width = ViewGroup.LayoutParams.MATCH_PARENT;
        lp.height = ViewGroup.LayoutParams.MATCH_PARENT;
        lp.gravity = Gravity.TOP | Gravity.FILL_HORIZONTAL;
        lp.softInputMode = WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE;
        theWindow.setAttributes(lp);
        setCanceledOnTouchOutside(true);
        // ---------- Original Method ----------
        //super.onCreate(savedInstanceState);
        //Window theWindow = getWindow();
        //WindowManager.LayoutParams lp = theWindow.getAttributes();
        //lp.width = ViewGroup.LayoutParams.MATCH_PARENT;
        //lp.height = ViewGroup.LayoutParams.MATCH_PARENT;
        //lp.gravity = Gravity.TOP | Gravity.FILL_HORIZONTAL;
        //lp.softInputMode = WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE;
        //theWindow.setAttributes(lp);
        //setCanceledOnTouchOutside(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.600 -0400", hash_original_method = "464C4B41AE1C07D5D4F71BE590B5445C", hash_generated_method = "9A2585E7749CD3F1695FDD3CE2D0B662")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void createContentView() {
        setContentView(com.android.internal.R.layout.search_bar);
        SearchBar searchBar;
        searchBar = (SearchBar) findViewById(com.android.internal.R.id.search_bar);
        searchBar.setSearchDialog(this);
        mSearchView = (SearchView) findViewById(com.android.internal.R.id.search_view);
        mSearchView.setIconified(false);
        mSearchView.setOnCloseListener(mOnCloseListener);
        mSearchView.setOnQueryTextListener(mOnQueryChangeListener);
        mSearchView.setOnSuggestionListener(mOnSuggestionSelectionListener);
        mSearchView.onActionViewExpanded();
        mCloseSearch = findViewById(com.android.internal.R.id.closeButton);
        mCloseSearch.setOnClickListener(new View.OnClickListener() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.600 -0400", hash_original_method = "94911F0CA1072E95A75799AAC34EFD5F", hash_generated_method = "224B035D43744F4BB915DDE76561493C")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public void onClick(View v) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                dsTaint.addTaint(v.dsTaint);
                dismiss();
                // ---------- Original Method ----------
                //dismiss();
            }
});
        mBadgeLabel = (TextView) mSearchView.findViewById(com.android.internal.R.id.search_badge);
        mSearchAutoComplete = (AutoCompleteTextView)
                mSearchView.findViewById(com.android.internal.R.id.search_src_text);
        mAppIcon = (ImageView) findViewById(com.android.internal.R.id.search_app_icon);
        mSearchPlate = mSearchView.findViewById(com.android.internal.R.id.search_plate);
        mWorkingSpinner = getContext().getResources().
                getDrawable(com.android.internal.R.drawable.search_spinner);
        setWorking(false);
        mBadgeLabel.setVisibility(View.GONE);
        mSearchAutoCompleteImeOptions = mSearchAutoComplete.getImeOptions();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.601 -0400", hash_original_method = "08D03C59DE669D3068C0B765E743FE8E", hash_generated_method = "43D8ABC969875FC668617A8AF97427A8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean show(String initialQuery, boolean selectInitialQuery,
            ComponentName componentName, Bundle appSearchData) {
        dsTaint.addTaint(appSearchData.dsTaint);
        dsTaint.addTaint(componentName.dsTaint);
        dsTaint.addTaint(selectInitialQuery);
        dsTaint.addTaint(initialQuery);
        boolean success;
        success = doShow(initialQuery, selectInitialQuery, componentName, appSearchData);
        {
            mSearchAutoComplete.showDropDownAfterLayout();
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean success = doShow(initialQuery, selectInitialQuery, componentName, appSearchData);
        //if (success) {
            //mSearchAutoComplete.showDropDownAfterLayout();
        //}
        //return success;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.602 -0400", hash_original_method = "EAE1B7BC7DC4BF1770F63B02B1B868E2", hash_generated_method = "0F4CF33B94D2AA0A26AEFB3C1DC42BFB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean doShow(String initialQuery, boolean selectInitialQuery,
            ComponentName componentName, Bundle appSearchData) {
        dsTaint.addTaint(appSearchData.dsTaint);
        dsTaint.addTaint(componentName.dsTaint);
        dsTaint.addTaint(selectInitialQuery);
        dsTaint.addTaint(initialQuery);
        {
            boolean var473B8D869FB051523792CFDB691F86C1_543384195 = (!show(componentName, appSearchData));
        } //End collapsed parenthetic
        setUserQuery(initialQuery);
        {
            mSearchAutoComplete.selectAll();
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!show(componentName, appSearchData)) {
            //return false;
        //}
        //setUserQuery(initialQuery);
        //if (selectInitialQuery) {
            //mSearchAutoComplete.selectAll();
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.602 -0400", hash_original_method = "705B52B556BB75FCC3E8159D4BF0A627", hash_generated_method = "6BF5546D364A82A6412634FE9E8814B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean show(ComponentName componentName, Bundle appSearchData) {
        dsTaint.addTaint(appSearchData.dsTaint);
        dsTaint.addTaint(componentName.dsTaint);
        {
            Log.d(LOG_TAG, "show(" + componentName + ", " 
                    + appSearchData + ")");
        } //End block
        SearchManager searchManager;
        searchManager = (SearchManager)
                mContext.getSystemService(Context.SEARCH_SERVICE);
        mSearchable = searchManager.getSearchableInfo(componentName);
        mActivityContext = mSearchable.getActivityContext(getContext());
        {
            boolean var67F0F8A90F47989DCF9FDFD2C3F61D76_1672354672 = (!isShowing());
            {
                createContentView();
                mSearchView.setSearchableInfo(mSearchable);
                mSearchView.setAppSearchData(mAppSearchData);
                show();
            } //End block
        } //End collapsed parenthetic
        updateUI();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (DBG) { 
            //Log.d(LOG_TAG, "show(" + componentName + ", " 
                    //+ appSearchData + ")");
        //}
        //SearchManager searchManager = (SearchManager)
                //mContext.getSystemService(Context.SEARCH_SERVICE);
        //mSearchable = searchManager.getSearchableInfo(componentName);
        //if (mSearchable == null) {
            //return false;
        //}
        //mLaunchComponent = componentName;
        //mAppSearchData = appSearchData;
        //mActivityContext = mSearchable.getActivityContext(getContext());
        //if (!isShowing()) {
            //createContentView();
            //mSearchView.setSearchableInfo(mSearchable);
            //mSearchView.setAppSearchData(mAppSearchData);
            //show();
        //}
        //updateUI();
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.603 -0400", hash_original_method = "57C4DE658D3F4A02662686A9CE61B2E8", hash_generated_method = "BFEB33921E55453E3C8B73DF51FCB89F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onStart() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onStart();
        IntentFilter filter;
        filter = new IntentFilter();
        filter.addAction(Intent.ACTION_CONFIGURATION_CHANGED);
        getContext().registerReceiver(mConfChangeListener, filter);
        // ---------- Original Method ----------
        //super.onStart();
        //IntentFilter filter = new IntentFilter();
        //filter.addAction(Intent.ACTION_CONFIGURATION_CHANGED);
        //getContext().registerReceiver(mConfChangeListener, filter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.604 -0400", hash_original_method = "6050D9FBC779B270404C43A7E853C1E6", hash_generated_method = "984822E2BAA867DD58A325DECDF6CA94")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onStop() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onStop();
        getContext().unregisterReceiver(mConfChangeListener);
        mLaunchComponent = null;
        mAppSearchData = null;
        mSearchable = null;
        mUserQuery = null;
        // ---------- Original Method ----------
        //super.onStop();
        //getContext().unregisterReceiver(mConfChangeListener);
        //mLaunchComponent = null;
        //mAppSearchData = null;
        //mSearchable = null;
        //mUserQuery = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.604 -0400", hash_original_method = "25F8B16486236BF1FAF351BB43EBD4A7", hash_generated_method = "2C8FCB3A136B7CEC96BAF9AF42D5051B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setWorking(boolean working) {
        dsTaint.addTaint(working);
        mWorkingSpinner.setAlpha(working ? 255 : 0);
        mWorkingSpinner.setVisible(working, false);
        mWorkingSpinner.invalidateSelf();
        // ---------- Original Method ----------
        //mWorkingSpinner.setAlpha(working ? 255 : 0);
        //mWorkingSpinner.setVisible(working, false);
        //mWorkingSpinner.invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.605 -0400", hash_original_method = "A93DBE942737D1F537AD057E006AED8C", hash_generated_method = "6E723A5858DC7762643FFCDE896A982A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Bundle onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var67F0F8A90F47989DCF9FDFD2C3F61D76_706142954 = (!isShowing());
        } //End collapsed parenthetic
        Bundle bundle;
        bundle = new Bundle();
        bundle.putParcelable(INSTANCE_KEY_COMPONENT, mLaunchComponent);
        bundle.putBundle(INSTANCE_KEY_APPDATA, mAppSearchData);
        bundle.putString(INSTANCE_KEY_USER_QUERY, mUserQuery);
        return (Bundle)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!isShowing()) return null;
        //Bundle bundle = new Bundle();
        //bundle.putParcelable(INSTANCE_KEY_COMPONENT, mLaunchComponent);
        //bundle.putBundle(INSTANCE_KEY_APPDATA, mAppSearchData);
        //bundle.putString(INSTANCE_KEY_USER_QUERY, mUserQuery);
        //return bundle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.607 -0400", hash_original_method = "D7088D676BF54E193C8B7B9D0CD3713D", hash_generated_method = "C840F32835D824496AAA584DF8340CDD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(savedInstanceState.dsTaint);
        ComponentName launchComponent;
        launchComponent = savedInstanceState.getParcelable(INSTANCE_KEY_COMPONENT);
        Bundle appSearchData;
        appSearchData = savedInstanceState.getBundle(INSTANCE_KEY_APPDATA);
        String userQuery;
        userQuery = savedInstanceState.getString(INSTANCE_KEY_USER_QUERY);
        {
            boolean varCADE91999A5045C9B6A838D3ABB970B0_2026940817 = (!doShow(userQuery, false, launchComponent, appSearchData));
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (savedInstanceState == null) return;
        //ComponentName launchComponent = savedInstanceState.getParcelable(INSTANCE_KEY_COMPONENT);
        //Bundle appSearchData = savedInstanceState.getBundle(INSTANCE_KEY_APPDATA);
        //String userQuery = savedInstanceState.getString(INSTANCE_KEY_USER_QUERY);
        //if (!doShow(userQuery, false, launchComponent, appSearchData)) {
            //return;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.608 -0400", hash_original_method = "D7D85FA93E7D9B21BC4DF3FC01DC78AB", hash_generated_method = "9576515FF641EEDC1C478FEE7D6B810C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onConfigurationChanged() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var79A5C46CCA5E7286E0D93C56266E8188_998018601 = (mSearchable != null && isShowing());
            {
                updateSearchAppIcon();
                updateSearchBadge();
                {
                    boolean varD9CA9AD6B23722108299537C69CF06C3_237279042 = (isLandscapeMode(getContext()));
                    {
                        mSearchAutoComplete.ensureImeVisible(true);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (mSearchable != null && isShowing()) {
            //updateSearchAppIcon();
            //updateSearchBadge();
            //if (isLandscapeMode(getContext())) {
                //mSearchAutoComplete.ensureImeVisible(true);
            //}
        //}
    }

    
        static boolean isLandscapeMode(Context context) {
        return context.getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_LANDSCAPE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.610 -0400", hash_original_method = "BEA9325A3466C1690A3F58B8B49BC62D", hash_generated_method = "C579B1C666A59B54D261E8915DA03F3A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void updateUI() {
        {
            mDecor.setVisibility(View.VISIBLE);
            updateSearchAutoComplete();
            updateSearchAppIcon();
            updateSearchBadge();
            int inputType;
            inputType = mSearchable.getInputType();
            {
                inputType &= ~InputType.TYPE_TEXT_FLAG_AUTO_COMPLETE;
                {
                    boolean varE37A0D6BE7319DB117FE61B1B4764F6E_120727308 = (mSearchable.getSuggestAuthority() != null);
                    {
                        inputType |= InputType.TYPE_TEXT_FLAG_AUTO_COMPLETE;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            mSearchAutoComplete.setInputType(inputType);
            mSearchAutoCompleteImeOptions = mSearchable.getImeOptions();
            mSearchAutoComplete.setImeOptions(mSearchAutoCompleteImeOptions);
            {
                boolean var33073265117069CA3BD3530ADCE8C281_1542802783 = (mSearchable.getVoiceSearchEnabled());
                {
                    mSearchAutoComplete.setPrivateImeOptions(IME_OPTION_NO_MICROPHONE);
                } //End block
                {
                    mSearchAutoComplete.setPrivateImeOptions(null);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.610 -0400", hash_original_method = "7645C33AE0588436620AE83A499D7C08", hash_generated_method = "B486407D70349091073B2AB72B9DD448")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void updateSearchAutoComplete() {
        mSearchAutoComplete.setDropDownDismissedOnCompletion(false);
        mSearchAutoComplete.setForceIgnoreOutsideTouch(false);
        // ---------- Original Method ----------
        //mSearchAutoComplete.setDropDownDismissedOnCompletion(false);
        //mSearchAutoComplete.setForceIgnoreOutsideTouch(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.611 -0400", hash_original_method = "E83CA9B0957C02D3E99E874CE94E4E80", hash_generated_method = "7DC40FA3793A7BD314AE40F29AE78769")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void updateSearchAppIcon() {
        PackageManager pm;
        pm = getContext().getPackageManager();
        Drawable icon;
        try 
        {
            ActivityInfo info;
            info = pm.getActivityInfo(mLaunchComponent, 0);
            icon = pm.getApplicationIcon(info.applicationInfo);
            Log.d(LOG_TAG, "Using app-specific icon");
        } //End block
        catch (NameNotFoundException e)
        {
            icon = pm.getDefaultActivityIcon();
        } //End block
        mAppIcon.setImageDrawable(icon);
        mAppIcon.setVisibility(View.VISIBLE);
        mSearchPlate.setPadding(SEARCH_PLATE_LEFT_PADDING_NON_GLOBAL, mSearchPlate.getPaddingTop(), mSearchPlate.getPaddingRight(), mSearchPlate.getPaddingBottom());
        // ---------- Original Method ----------
        //PackageManager pm = getContext().getPackageManager();
        //Drawable icon;
        //try {
            //ActivityInfo info = pm.getActivityInfo(mLaunchComponent, 0);
            //icon = pm.getApplicationIcon(info.applicationInfo);
            //if (DBG)
                //Log.d(LOG_TAG, "Using app-specific icon");
        //} catch (NameNotFoundException e) {
            //icon = pm.getDefaultActivityIcon();
            //Log.w(LOG_TAG, mLaunchComponent + " not found, using generic app icon");
        //}
        //mAppIcon.setImageDrawable(icon);
        //mAppIcon.setVisibility(View.VISIBLE);
        //mSearchPlate.setPadding(SEARCH_PLATE_LEFT_PADDING_NON_GLOBAL, mSearchPlate.getPaddingTop(), mSearchPlate.getPaddingRight(), mSearchPlate.getPaddingBottom());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.611 -0400", hash_original_method = "306E7BCD0818ADE89EBA434EE06262F7", hash_generated_method = "5F89E745199D4F735AF61F9D271E9DF3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void updateSearchBadge() {
        int visibility;
        visibility = View.GONE;
        Drawable icon;
        icon = null;
        CharSequence text;
        text = null;
        {
            boolean var4B40E5E52C5EBE3D0042AA73F5931D76_1078168557 = (mSearchable.useBadgeIcon());
            {
                icon = mActivityContext.getResources().getDrawable(mSearchable.getIconId());
                visibility = View.VISIBLE;
                Log.d(LOG_TAG, "Using badge icon: " + mSearchable.getIconId());
            } //End block
            {
                boolean varFB7BF02190381C7212E4349D9E51B506_181575273 = (mSearchable.useBadgeLabel());
                {
                    text = mActivityContext.getResources().getText(mSearchable.getLabelId()).toString();
                    visibility = View.VISIBLE;
                    Log.d(LOG_TAG, "Using badge label: " + mSearchable.getLabelId());
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        mBadgeLabel.setCompoundDrawablesWithIntrinsicBounds(icon, null, null, null);
        mBadgeLabel.setText(text);
        mBadgeLabel.setVisibility(visibility);
        // ---------- Original Method ----------
        //int visibility = View.GONE;
        //Drawable icon = null;
        //CharSequence text = null;
        //if (mSearchable.useBadgeIcon()) {
            //icon = mActivityContext.getResources().getDrawable(mSearchable.getIconId());
            //visibility = View.VISIBLE;
            //if (DBG) Log.d(LOG_TAG, "Using badge icon: " + mSearchable.getIconId());
        //} else if (mSearchable.useBadgeLabel()) {
            //text = mActivityContext.getResources().getText(mSearchable.getLabelId()).toString();
            //visibility = View.VISIBLE;
            //if (DBG) Log.d(LOG_TAG, "Using badge label: " + mSearchable.getLabelId());
        //}
        //mBadgeLabel.setCompoundDrawablesWithIntrinsicBounds(icon, null, null, null);
        //mBadgeLabel.setText(text);
        //mBadgeLabel.setVisibility(visibility);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.612 -0400", hash_original_method = "0D9DE884F4C3EB514898202D906CFD1D", hash_generated_method = "8B5B733434D03384B411F3F165F12333")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        {
            boolean varCE17A41A6CEAAE3326A1B5E493AA76FE_639667795 = (!mSearchAutoComplete.isPopupShowing() && isOutOfBounds(mSearchPlate, event));
            {
                Log.d(LOG_TAG, "Pop-up not showing and outside of search plate.");
                cancel();
            } //End block
        } //End collapsed parenthetic
        boolean var5D1E90CB51451ACDF0A3114FBC92AA76_481196298 = (super.onTouchEvent(event));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!mSearchAutoComplete.isPopupShowing() && isOutOfBounds(mSearchPlate, event)) {
            //if (DBG) Log.d(LOG_TAG, "Pop-up not showing and outside of search plate.");
            //cancel();
            //return true;
        //}
        //return super.onTouchEvent(event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.612 -0400", hash_original_method = "56250C7379795A076A294BCEF2D5FD2C", hash_generated_method = "D269ADC83891B05CFB79111B6A8CC0C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isOutOfBounds(View v, MotionEvent event) {
        dsTaint.addTaint(v.dsTaint);
        dsTaint.addTaint(event.dsTaint);
        int x;
        x = (int) event.getX();
        int y;
        y = (int) event.getY();
        int slop;
        slop = ViewConfiguration.get(mContext).getScaledWindowTouchSlop();
        boolean varF1323CBC1C1BDF62B7AAA2E8EBAA7C86_734403139 = ((x < -slop) || (y < -slop)
                || (x > (v.getWidth()+slop))
                || (y > (v.getHeight()+slop)));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final int x = (int) event.getX();
        //final int y = (int) event.getY();
        //final int slop = ViewConfiguration.get(mContext).getScaledWindowTouchSlop();
        //return (x < -slop) || (y < -slop)
                //|| (x > (v.getWidth()+slop))
                //|| (y > (v.getHeight()+slop));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.613 -0400", hash_original_method = "6ED6F897B7566B2172AD538A3B9EBF5C", hash_generated_method = "43E4DBB5287216FDDA8F7975D9232EC6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void hide() {
        {
            boolean var67F0F8A90F47989DCF9FDFD2C3F61D76_1139320605 = (!isShowing());
        } //End collapsed parenthetic
        InputMethodManager imm;
        imm = (InputMethodManager)getContext()
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        {
            imm.hideSoftInputFromWindow(
                    getWindow().getDecorView().getWindowToken(), 0);
        } //End block
        super.hide();
        // ---------- Original Method ----------
        //if (!isShowing()) return;
        //InputMethodManager imm = (InputMethodManager)getContext()
                //.getSystemService(Context.INPUT_METHOD_SERVICE);
        //if (imm != null) {
            //imm.hideSoftInputFromWindow(
                    //getWindow().getDecorView().getWindowToken(), 0);
        //}
        //super.hide();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.613 -0400", hash_original_method = "A776EE9CD94492AC9830F6D90123EF80", hash_generated_method = "1F96E398546D6644A16C0EB6DC477101")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void launchQuerySearch() {
        launchQuerySearch(KeyEvent.KEYCODE_UNKNOWN, null);
        // ---------- Original Method ----------
        //launchQuerySearch(KeyEvent.KEYCODE_UNKNOWN, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.614 -0400", hash_original_method = "8DA1240BCB0B1358D88E8B5A3BC94CC9", hash_generated_method = "D1AEF277961F48FCBC0945337D672B69")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void launchQuerySearch(int actionKey, String actionMsg) {
        dsTaint.addTaint(actionMsg);
        dsTaint.addTaint(actionKey);
        String query;
        query = mSearchAutoComplete.getText().toString();
        String action;
        action = Intent.ACTION_SEARCH;
        Intent intent;
        intent = createIntent(action, null, null, query, actionKey, actionMsg);
        launchIntent(intent);
        // ---------- Original Method ----------
        //String query = mSearchAutoComplete.getText().toString();
        //String action = Intent.ACTION_SEARCH;
        //Intent intent = createIntent(action, null, null, query, actionKey, actionMsg);
        //launchIntent(intent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.614 -0400", hash_original_method = "BC4CCAAD8BAD8DFDC06067A6480767AA", hash_generated_method = "6154283A20C3AB7C2FABCC749D086240")
    @DSModeled(DSC.SPEC)
    private void launchIntent(Intent intent) {
        dsTaint.addTaint(intent.dsTaint);
        Log.d(LOG_TAG, "launching " + intent);
        try 
        {
            getContext().startActivity(intent);
            dismiss();
        } //End block
        catch (RuntimeException ex)
        { }
        // ---------- Original Method ----------
        //if (intent == null) {
            //return;
        //}
        //Log.d(LOG_TAG, "launching " + intent);
        //try {
            //Log.i(LOG_TAG, "Starting (as ourselves) " + intent.toUri(0));
            //getContext().startActivity(intent);
            //dismiss();
        //} catch (RuntimeException ex) {
            //Log.e(LOG_TAG, "Failed launch activity: " + intent, ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.615 -0400", hash_original_method = "A7D428EF1EDEF778DF6A68394BD0B0D0", hash_generated_method = "B308379FF9D6754DD034B8E4BC33D5AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setListSelection(int index) {
        dsTaint.addTaint(index);
        mSearchAutoComplete.setListSelection(index);
        // ---------- Original Method ----------
        //mSearchAutoComplete.setListSelection(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.615 -0400", hash_original_method = "7931502AE551A2F220A0C85C1181EB09", hash_generated_method = "5B90F8AC6D5584509599B7B0E477A10E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.616 -0400", hash_original_method = "F1F42C772C06A28CE3769310F1841510", hash_generated_method = "6A435CFDD6DD7F09E6A4888EC942FBB4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isEmpty(AutoCompleteTextView actv) {
        dsTaint.addTaint(actv.dsTaint);
        boolean varA00CA6A03B7729E39BB9012B388B84AE_1597220652 = (TextUtils.getTrimmedLength(actv.getText()) == 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return TextUtils.getTrimmedLength(actv.getText()) == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.616 -0400", hash_original_method = "85C012DD8E7654DEDC3FCC35E518B3D4", hash_generated_method = "10F21B8A0703A0FCFD1ECB70E5249C51")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onBackPressed() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        InputMethodManager imm;
        imm = (InputMethodManager)getContext()
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        {
            boolean var923BEF24B2989F56B9B96F77869010FA_936691877 = (imm != null && imm.isFullscreenMode() &&
                imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0));
        } //End collapsed parenthetic
        cancel();
        // ---------- Original Method ----------
        //InputMethodManager imm = (InputMethodManager)getContext()
                //.getSystemService(Context.INPUT_METHOD_SERVICE);
        //if (imm != null && imm.isFullscreenMode() &&
                //imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0)) {
            //return;
        //}
        //cancel();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.616 -0400", hash_original_method = "D537924252E5FBECE100B51E4DF20EDD", hash_generated_method = "68EF308065BD42C0ACAD629DEDF7AD27")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean onClosePressed() {
        {
            boolean var64E470953DFC6D121014C23115412BF9_764850907 = (isEmpty(mSearchAutoComplete));
            {
                dismiss();
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (isEmpty(mSearchAutoComplete)) {
            //dismiss();
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.617 -0400", hash_original_method = "AC61287D1F4BDFB9C05737508F4ABB90", hash_generated_method = "E0B1D1AE6032906EC08D7F2DC54B8E02")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setUserQuery(String query) {
        dsTaint.addTaint(query);
        {
            query = "";
        } //End block
        mSearchAutoComplete.setText(query);
        mSearchAutoComplete.setSelection(query.length());
        // ---------- Original Method ----------
        //if (query == null) {
            //query = "";
        //}
        //mUserQuery = query;
        //mSearchAutoComplete.setText(query);
        //mSearchAutoComplete.setSelection(query.length());
    }

    
    public static class SearchBar extends LinearLayout {
        private SearchDialog mSearchDialog;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.617 -0400", hash_original_method = "A3B6592F51A27BFA7A85197EDA145FFE", hash_generated_method = "4129712E27E24D6D52A5D8C319CED5F5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SearchBar(Context context, AttributeSet attrs) {
            super(context, attrs);
            dsTaint.addTaint(attrs.dsTaint);
            dsTaint.addTaint(context.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.618 -0400", hash_original_method = "4392E8B38D4E47AAE679D125E8E4B6FF", hash_generated_method = "A1AB76063B791318076A1493C7B75279")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SearchBar(Context context) {
            super(context);
            dsTaint.addTaint(context.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.618 -0400", hash_original_method = "7E3A3D5A1CCC1779F8492CDCF581870E", hash_generated_method = "4012E758B811F534AE42A2C7D860E87E")
        @DSModeled(DSC.SAFE)
        public void setSearchDialog(SearchDialog searchDialog) {
            dsTaint.addTaint(searchDialog.dsTaint);
            // ---------- Original Method ----------
            //mSearchDialog = searchDialog;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.618 -0400", hash_original_method = "195483BC208A3A4410E3220FCA03E982", hash_generated_method = "3389872DBFC37E489B6736D71BB1D8F7")
        @DSModeled(DSC.SAFE)
        @Override
        public ActionMode startActionModeForChild(View child, ActionMode.Callback callback) {
            dsTaint.addTaint(child.dsTaint);
            dsTaint.addTaint(callback.dsTaint);
            return (ActionMode)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return null;
        }

        
    }


    
    private static final boolean DBG = false;
    private static final String LOG_TAG = "SearchDialog";
    private static final String INSTANCE_KEY_COMPONENT = "comp";
    private static final String INSTANCE_KEY_APPDATA = "data";
    private static final String INSTANCE_KEY_USER_QUERY = "uQry";
    private static final String IME_OPTION_NO_MICROPHONE = "nm";
    private static final int SEARCH_PLATE_LEFT_PADDING_NON_GLOBAL = 7;
}

