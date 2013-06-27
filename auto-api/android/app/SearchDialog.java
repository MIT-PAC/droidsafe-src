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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.800 -0400", hash_original_field = "B5F063A37AD81095B9F7B6C497D8C073", hash_generated_field = "1106A4E8A92B8ECB3AB388E40AAD60FA")

    private TextView mBadgeLabel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.801 -0400", hash_original_field = "DB25167EF9293EEFF4756808C80CF681", hash_generated_field = "AA62E658C5FFF9798AE22B318F3E352B")

    private ImageView mAppIcon;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.801 -0400", hash_original_field = "A183DEAF35902AC49819EF2DA1163BF1", hash_generated_field = "D28C2E2316A6D4BCBB3634EE05B8CBED")

    private AutoCompleteTextView mSearchAutoComplete;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.814 -0400", hash_original_field = "01BCA17D3E9DDD8BF5B44F3E2EF1EE68", hash_generated_field = "BFE96959B9AF28F7C0E58BC61493C3DB")

    private View mSearchPlate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.815 -0400", hash_original_field = "D1972F87341AF3F5EA90C2B878C0DF14", hash_generated_field = "1366187FE3CF01EF5FC13B6B4154C3DB")

    private SearchView mSearchView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.816 -0400", hash_original_field = "7218FD22EC10C78A06F25F9B75D1FAAD", hash_generated_field = "DD5A2D50F6C0D0417755EF4A026A680F")

    private Drawable mWorkingSpinner;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.816 -0400", hash_original_field = "16EF54934FDE54D82011E1002CD5B491", hash_generated_field = "C06E0E7D1467D7FE8A6F8A71C4DF5424")

    private View mCloseSearch;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.825 -0400", hash_original_field = "43A23F0BB5F798E421F2CC49BC43D947", hash_generated_field = "6F1511307A7DE5E4BDCE1D082D25D113")

    private SearchableInfo mSearchable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.826 -0400", hash_original_field = "82A5F7BC03D8AFDACBBDB135A5815198", hash_generated_field = "50EEF416470C835B6507F85F77B6005A")

    private ComponentName mLaunchComponent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.827 -0400", hash_original_field = "9AD25D597D917C37D99A80719B4F8F99", hash_generated_field = "59F218E5E058390715FC276BA2A49292")

    private Bundle mAppSearchData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.828 -0400", hash_original_field = "2D82D6A5CDAAA9A7194BD0893F3418C6", hash_generated_field = "830673ADBDEDB8A3B6CE8ACC5E0E51D6")

    private Context mActivityContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.828 -0400", hash_original_field = "04D6CDF64323839563B4F92092B41FA4", hash_generated_field = "72504DA1E4071FF872DD4C2D7A26922B")

    private Intent mVoiceWebSearchIntent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.829 -0400", hash_original_field = "11E5F1DDAB281A77343908AB3E79EC12", hash_generated_field = "FEBA65D5D58AD1CB3F0ABB729B735300")

    private Intent mVoiceAppSearchIntent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.829 -0400", hash_original_field = "336CD107D0D6B9BEBFB6CBC4E3350BF4", hash_generated_field = "A4DF17D9C01FD7FA245A1BE527F16171")

    private String mUserQuery;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.830 -0400", hash_original_field = "94107C719F928E0A2A608F06A9B23DE2", hash_generated_field = "AB035B7E16E303E650083D3FC6117294")

    private int mSearchAutoCompleteImeOptions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.861 -0400", hash_original_field = "4C8632D0626D11A25D8014E79CAA4E06", hash_generated_field = "67B62B3AFCBEE4A32A8CE46A0FBB5995")

    private BroadcastReceiver mConfChangeListener = new BroadcastReceiver() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.860 -0400", hash_original_method = "61FB59FECA93F3EDF27E6A33F699149F", hash_generated_method = "B805E68675BA63E412C83E2FA8FF65FF")
        @Override
        public void onReceive(Context context, Intent intent) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                boolean varE405DF0F97C7D559E41F379AE2677168_1862206416 = (intent.getAction().equals(Intent.ACTION_CONFIGURATION_CHANGED));
                {
                    onConfigurationChanged();
                } //End block
            } //End collapsed parenthetic
            addTaint(context.getTaint());
            addTaint(intent.getTaint());
            // ---------- Original Method ----------
            //if (intent.getAction().equals(Intent.ACTION_CONFIGURATION_CHANGED)) {
                //onConfigurationChanged();
            //}
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.885 -0400", hash_original_field = "C8DA34EAFE5A804F3DA0F26C8C4E68D6", hash_generated_field = "A697B4E72486B1BE8AC8C48658F9ED2E")

    private SearchView.OnCloseListener mOnCloseListener = new SearchView.OnCloseListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.862 -0400", hash_original_method = "59E568E09AB29194E5325B85C030BFA7", hash_generated_method = "2484D3FBCC9D83E4CFF51E5CE29349C6")
        public boolean onClose() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            boolean var7C756DC13C2D8A9436460F5A2B0F353B_295372776 = (onClosePressed());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1142478730 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1142478730;
            // ---------- Original Method ----------
            //return onClosePressed();
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.890 -0400", hash_original_field = "30CF5A2AB690CA0DA5E52E2B1D748F3D", hash_generated_field = "8974EFC7B49999810F5ECEB81970C30E")

    private SearchView.OnQueryTextListener mOnQueryChangeListener = new SearchView.OnQueryTextListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.887 -0400", hash_original_method = "E09154FCFE3F9A3A23F9DDB58EA399A5", hash_generated_method = "196DEACE242D769AA4BE572391CF5000")
        public boolean onQueryTextSubmit(String query) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dismiss();
            addTaint(query.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1591374007 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1591374007;
            // ---------- Original Method ----------
            //dismiss();
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.890 -0400", hash_original_method = "B6F5742F5D55A0164A53BADD48E4641B", hash_generated_method = "CE32E26390C5BA7141A154B2643FDA09")
        public boolean onQueryTextChange(String newText) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(newText.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_60544390 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_60544390;
            // ---------- Original Method ----------
            //return false;
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.912 -0400", hash_original_field = "664EEA0FE979F3BA2B7F5E6EE6FFA2E6", hash_generated_field = "9C5BB3310785EBDDFCEC803D33C7153D")

    private SearchView.OnSuggestionListener mOnSuggestionSelectionListener = new SearchView.OnSuggestionListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.910 -0400", hash_original_method = "A3A230CAC466D18E54C97A3930C1550C", hash_generated_method = "38B4CF6C7EC2F1C2DCF2CB2E5F3E6F2F")
        public boolean onSuggestionSelect(int position) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(position);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_395248689 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_395248689;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.912 -0400", hash_original_method = "59D851DE147AEDB85EE9900538C05E02", hash_generated_method = "63B26F36DEBD4BD481B3CAD8CE7E714A")
        public boolean onSuggestionClick(int position) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dismiss();
            addTaint(position);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1008299678 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1008299678;
            // ---------- Original Method ----------
            //dismiss();
            //return false;
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.929 -0400", hash_original_method = "F1210797C1F332443A604D5C626C1E55", hash_generated_method = "B52D28654D3C33C7304882237AC71C77")
    public  SearchDialog(Context context, SearchManager searchManager) {
        super(context, resolveDialogTheme(context));
        mVoiceWebSearchIntent = new Intent(RecognizerIntent.ACTION_WEB_SEARCH);
        mVoiceWebSearchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mVoiceWebSearchIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_WEB_SEARCH);
        mVoiceAppSearchIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        mVoiceAppSearchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        addTaint(context.getTaint());
        addTaint(searchManager.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.948 -0400", hash_original_method = "ADA44CDEEADE302052A002E44C1889B1", hash_generated_method = "F273EE5405A5C5C927CAB66237137B44")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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
        addTaint(savedInstanceState.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.003 -0400", hash_original_method = "464C4B41AE1C07D5D4F71BE590B5445C", hash_generated_method = "D97FA6C03A898DCE37361682C5692401")
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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.978 -0400", hash_original_method = "94911F0CA1072E95A75799AAC34EFD5F", hash_generated_method = "31BEF810EEA8B2DD9BFC5D7F6EE5D941")
            @Override
            public void onClick(View v) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                dismiss();
                addTaint(v.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.014 -0400", hash_original_method = "08D03C59DE669D3068C0B765E743FE8E", hash_generated_method = "5A4CAC651813F97D6C26F50D19E4F7C1")
    public boolean show(String initialQuery, boolean selectInitialQuery,
            ComponentName componentName, Bundle appSearchData) {
        boolean success;
        success = doShow(initialQuery, selectInitialQuery, componentName, appSearchData);
        {
            mSearchAutoComplete.showDropDownAfterLayout();
        } //End block
        addTaint(initialQuery.getTaint());
        addTaint(selectInitialQuery);
        addTaint(componentName.getTaint());
        addTaint(appSearchData.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_288302431 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_288302431;
        // ---------- Original Method ----------
        //boolean success = doShow(initialQuery, selectInitialQuery, componentName, appSearchData);
        //if (success) {
            //mSearchAutoComplete.showDropDownAfterLayout();
        //}
        //return success;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.016 -0400", hash_original_method = "EAE1B7BC7DC4BF1770F63B02B1B868E2", hash_generated_method = "AFDF3255B1D353BBA9C192086B6B7B9D")
    private boolean doShow(String initialQuery, boolean selectInitialQuery,
            ComponentName componentName, Bundle appSearchData) {
        {
            boolean var473B8D869FB051523792CFDB691F86C1_539962942 = (!show(componentName, appSearchData));
        } //End collapsed parenthetic
        setUserQuery(initialQuery);
        {
            mSearchAutoComplete.selectAll();
        } //End block
        addTaint(initialQuery.getTaint());
        addTaint(selectInitialQuery);
        addTaint(componentName.getTaint());
        addTaint(appSearchData.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1826583110 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1826583110;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.172 -0400", hash_original_method = "705B52B556BB75FCC3E8159D4BF0A627", hash_generated_method = "606A959E7E4083AE1373B5650001F395")
    private boolean show(ComponentName componentName, Bundle appSearchData) {
        {
            Log.d(LOG_TAG, "show(" + componentName + ", " 
                    + appSearchData + ")");
        } //End block
        SearchManager searchManager;
        searchManager = (SearchManager)
                mContext.getSystemService(Context.SEARCH_SERVICE);
        mSearchable = searchManager.getSearchableInfo(componentName);
        mLaunchComponent = componentName;
        mAppSearchData = appSearchData;
        mActivityContext = mSearchable.getActivityContext(getContext());
        {
            boolean var67F0F8A90F47989DCF9FDFD2C3F61D76_1393226420 = (!isShowing());
            {
                createContentView();
                mSearchView.setSearchableInfo(mSearchable);
                mSearchView.setAppSearchData(mAppSearchData);
                show();
            } //End block
        } //End collapsed parenthetic
        updateUI();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_179071572 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_179071572;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.173 -0400", hash_original_method = "57C4DE658D3F4A02662686A9CE61B2E8", hash_generated_method = "BFEB33921E55453E3C8B73DF51FCB89F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.175 -0400", hash_original_method = "6050D9FBC779B270404C43A7E853C1E6", hash_generated_method = "984822E2BAA867DD58A325DECDF6CA94")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.199 -0400", hash_original_method = "25F8B16486236BF1FAF351BB43EBD4A7", hash_generated_method = "BFC527EFBB5F72AE120BA0BDCF329278")
    public void setWorking(boolean working) {
        mWorkingSpinner.setAlpha(working ? 255 : 0);
        mWorkingSpinner.setVisible(working, false);
        mWorkingSpinner.invalidateSelf();
        addTaint(working);
        // ---------- Original Method ----------
        //mWorkingSpinner.setAlpha(working ? 255 : 0);
        //mWorkingSpinner.setVisible(working, false);
        //mWorkingSpinner.invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.213 -0400", hash_original_method = "A93DBE942737D1F537AD057E006AED8C", hash_generated_method = "591E4E1A94680496839EA0B9AF3F995D")
    @Override
    public Bundle onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Bundle varB4EAC82CA7396A68D541C85D26508E83_264220179 = null; //Variable for return #1
        Bundle varB4EAC82CA7396A68D541C85D26508E83_885666404 = null; //Variable for return #2
        {
            boolean var67F0F8A90F47989DCF9FDFD2C3F61D76_330902420 = (!isShowing());
            varB4EAC82CA7396A68D541C85D26508E83_264220179 = null;
        } //End collapsed parenthetic
        Bundle bundle;
        bundle = new Bundle();
        bundle.putParcelable(INSTANCE_KEY_COMPONENT, mLaunchComponent);
        bundle.putBundle(INSTANCE_KEY_APPDATA, mAppSearchData);
        bundle.putString(INSTANCE_KEY_USER_QUERY, mUserQuery);
        varB4EAC82CA7396A68D541C85D26508E83_885666404 = bundle;
        Bundle varA7E53CE21691AB073D9660D615818899_1694336287; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1694336287 = varB4EAC82CA7396A68D541C85D26508E83_264220179;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1694336287 = varB4EAC82CA7396A68D541C85D26508E83_885666404;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1694336287.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1694336287;
        // ---------- Original Method ----------
        //if (!isShowing()) return null;
        //Bundle bundle = new Bundle();
        //bundle.putParcelable(INSTANCE_KEY_COMPONENT, mLaunchComponent);
        //bundle.putBundle(INSTANCE_KEY_APPDATA, mAppSearchData);
        //bundle.putString(INSTANCE_KEY_USER_QUERY, mUserQuery);
        //return bundle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.214 -0400", hash_original_method = "D7088D676BF54E193C8B7B9D0CD3713D", hash_generated_method = "E7786C70ABB25E8D387A6ECA43C691BC")
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        ComponentName launchComponent;
        launchComponent = savedInstanceState.getParcelable(INSTANCE_KEY_COMPONENT);
        Bundle appSearchData;
        appSearchData = savedInstanceState.getBundle(INSTANCE_KEY_APPDATA);
        String userQuery;
        userQuery = savedInstanceState.getString(INSTANCE_KEY_USER_QUERY);
        {
            boolean varCADE91999A5045C9B6A838D3ABB970B0_2008669374 = (!doShow(userQuery, false, launchComponent, appSearchData));
        } //End collapsed parenthetic
        addTaint(savedInstanceState.getTaint());
        // ---------- Original Method ----------
        //if (savedInstanceState == null) return;
        //ComponentName launchComponent = savedInstanceState.getParcelable(INSTANCE_KEY_COMPONENT);
        //Bundle appSearchData = savedInstanceState.getBundle(INSTANCE_KEY_APPDATA);
        //String userQuery = savedInstanceState.getString(INSTANCE_KEY_USER_QUERY);
        //if (!doShow(userQuery, false, launchComponent, appSearchData)) {
            //return;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.240 -0400", hash_original_method = "D7D85FA93E7D9B21BC4DF3FC01DC78AB", hash_generated_method = "234EEEBE66C5E10A35C318BDBBD47530")
    public void onConfigurationChanged() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var79A5C46CCA5E7286E0D93C56266E8188_281028535 = (mSearchable != null && isShowing());
            {
                updateSearchAppIcon();
                updateSearchBadge();
                {
                    boolean varD9CA9AD6B23722108299537C69CF06C3_1545172306 = (isLandscapeMode(getContext()));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.256 -0400", hash_original_method = "BEA9325A3466C1690A3F58B8B49BC62D", hash_generated_method = "A503B0685FFA803311C64CF382B0232B")
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
                    boolean varE37A0D6BE7319DB117FE61B1B4764F6E_1900083069 = (mSearchable.getSuggestAuthority() != null);
                    {
                        inputType |= InputType.TYPE_TEXT_FLAG_AUTO_COMPLETE;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            mSearchAutoComplete.setInputType(inputType);
            mSearchAutoCompleteImeOptions = mSearchable.getImeOptions();
            mSearchAutoComplete.setImeOptions(mSearchAutoCompleteImeOptions);
            {
                boolean var33073265117069CA3BD3530ADCE8C281_755797031 = (mSearchable.getVoiceSearchEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.278 -0400", hash_original_method = "7645C33AE0588436620AE83A499D7C08", hash_generated_method = "B486407D70349091073B2AB72B9DD448")
    private void updateSearchAutoComplete() {
        mSearchAutoComplete.setDropDownDismissedOnCompletion(false);
        mSearchAutoComplete.setForceIgnoreOutsideTouch(false);
        // ---------- Original Method ----------
        //mSearchAutoComplete.setDropDownDismissedOnCompletion(false);
        //mSearchAutoComplete.setForceIgnoreOutsideTouch(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.280 -0400", hash_original_method = "E83CA9B0957C02D3E99E874CE94E4E80", hash_generated_method = "7DC40FA3793A7BD314AE40F29AE78769")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.304 -0400", hash_original_method = "306E7BCD0818ADE89EBA434EE06262F7", hash_generated_method = "C4DA4666272E96A533B244881DA87DE9")
    private void updateSearchBadge() {
        int visibility;
        visibility = View.GONE;
        Drawable icon;
        icon = null;
        CharSequence text;
        text = null;
        {
            boolean var4B40E5E52C5EBE3D0042AA73F5931D76_866683496 = (mSearchable.useBadgeIcon());
            {
                icon = mActivityContext.getResources().getDrawable(mSearchable.getIconId());
                visibility = View.VISIBLE;
                Log.d(LOG_TAG, "Using badge icon: " + mSearchable.getIconId());
            } //End block
            {
                boolean varFB7BF02190381C7212E4349D9E51B506_1244881802 = (mSearchable.useBadgeLabel());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.322 -0400", hash_original_method = "0D9DE884F4C3EB514898202D906CFD1D", hash_generated_method = "8FC072C42F28C16C2CA952DB6486F1D4")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean varCE17A41A6CEAAE3326A1B5E493AA76FE_1366051712 = (!mSearchAutoComplete.isPopupShowing() && isOutOfBounds(mSearchPlate, event));
            {
                Log.d(LOG_TAG, "Pop-up not showing and outside of search plate.");
                cancel();
            } //End block
        } //End collapsed parenthetic
        boolean var5D1E90CB51451ACDF0A3114FBC92AA76_1560605397 = (super.onTouchEvent(event));
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1756324355 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1756324355;
        // ---------- Original Method ----------
        //if (!mSearchAutoComplete.isPopupShowing() && isOutOfBounds(mSearchPlate, event)) {
            //if (DBG) Log.d(LOG_TAG, "Pop-up not showing and outside of search plate.");
            //cancel();
            //return true;
        //}
        //return super.onTouchEvent(event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.324 -0400", hash_original_method = "56250C7379795A076A294BCEF2D5FD2C", hash_generated_method = "2677D083EFEA1958E2DF5317CA386BA6")
    private boolean isOutOfBounds(View v, MotionEvent event) {
        int x;
        x = (int) event.getX();
        int y;
        y = (int) event.getY();
        int slop;
        slop = ViewConfiguration.get(mContext).getScaledWindowTouchSlop();
        boolean varF1323CBC1C1BDF62B7AAA2E8EBAA7C86_219042751 = ((x < -slop) || (y < -slop)
                || (x > (v.getWidth()+slop))
                || (y > (v.getHeight()+slop)));
        addTaint(v.getTaint());
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_298375772 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_298375772;
        // ---------- Original Method ----------
        //final int x = (int) event.getX();
        //final int y = (int) event.getY();
        //final int slop = ViewConfiguration.get(mContext).getScaledWindowTouchSlop();
        //return (x < -slop) || (y < -slop)
                //|| (x > (v.getWidth()+slop))
                //|| (y > (v.getHeight()+slop));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.351 -0400", hash_original_method = "6ED6F897B7566B2172AD538A3B9EBF5C", hash_generated_method = "59006A577F2D3706F9B2C5C7A6F42E55")
    @Override
    public void hide() {
        {
            boolean var67F0F8A90F47989DCF9FDFD2C3F61D76_489903371 = (!isShowing());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.387 -0400", hash_original_method = "A776EE9CD94492AC9830F6D90123EF80", hash_generated_method = "1F96E398546D6644A16C0EB6DC477101")
    public void launchQuerySearch() {
        launchQuerySearch(KeyEvent.KEYCODE_UNKNOWN, null);
        // ---------- Original Method ----------
        //launchQuerySearch(KeyEvent.KEYCODE_UNKNOWN, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.389 -0400", hash_original_method = "8DA1240BCB0B1358D88E8B5A3BC94CC9", hash_generated_method = "F50C1919796C768E030E365E5722668D")
    protected void launchQuerySearch(int actionKey, String actionMsg) {
        String query;
        query = mSearchAutoComplete.getText().toString();
        String action;
        action = Intent.ACTION_SEARCH;
        Intent intent;
        intent = createIntent(action, null, null, query, actionKey, actionMsg);
        launchIntent(intent);
        addTaint(actionKey);
        addTaint(actionMsg.getTaint());
        // ---------- Original Method ----------
        //String query = mSearchAutoComplete.getText().toString();
        //String action = Intent.ACTION_SEARCH;
        //Intent intent = createIntent(action, null, null, query, actionKey, actionMsg);
        //launchIntent(intent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.391 -0400", hash_original_method = "BC4CCAAD8BAD8DFDC06067A6480767AA", hash_generated_method = "C653AA31586676AF5C9F3A77ABDFB483")
    private void launchIntent(Intent intent) {
        Log.d(LOG_TAG, "launching " + intent);
        try 
        {
            getContext().startActivity(intent);
            dismiss();
        } //End block
        catch (RuntimeException ex)
        { }
        addTaint(intent.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.392 -0400", hash_original_method = "A7D428EF1EDEF778DF6A68394BD0B0D0", hash_generated_method = "E80AE8EAA8FB112504D4E6DC33B9E369")
    public void setListSelection(int index) {
        mSearchAutoComplete.setListSelection(index);
        addTaint(index);
        // ---------- Original Method ----------
        //mSearchAutoComplete.setListSelection(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.410 -0400", hash_original_method = "7931502AE551A2F220A0C85C1181EB09", hash_generated_method = "F7843DF66F6F3FA88F694C9286DCE11F")
    private Intent createIntent(String action, Uri data, String extraData, String query,
            int actionKey, String actionMsg) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_1645348879 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1645348879 = intent;
        addTaint(action.getTaint());
        addTaint(data.getTaint());
        addTaint(extraData.getTaint());
        addTaint(query.getTaint());
        addTaint(actionKey);
        addTaint(actionMsg.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1645348879.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1645348879;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.436 -0400", hash_original_method = "F1F42C772C06A28CE3769310F1841510", hash_generated_method = "687C73B97DB8CBEAADD3A08E98B93AF7")
    private boolean isEmpty(AutoCompleteTextView actv) {
        boolean varA00CA6A03B7729E39BB9012B388B84AE_336989946 = (TextUtils.getTrimmedLength(actv.getText()) == 0);
        addTaint(actv.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1516866565 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1516866565;
        // ---------- Original Method ----------
        //return TextUtils.getTrimmedLength(actv.getText()) == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.437 -0400", hash_original_method = "85C012DD8E7654DEDC3FCC35E518B3D4", hash_generated_method = "D0D7296F2AEF6260BBEDA91342A0B811")
    @Override
    public void onBackPressed() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        InputMethodManager imm;
        imm = (InputMethodManager)getContext()
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        {
            boolean var923BEF24B2989F56B9B96F77869010FA_2024841495 = (imm != null && imm.isFullscreenMode() &&
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.456 -0400", hash_original_method = "D537924252E5FBECE100B51E4DF20EDD", hash_generated_method = "AA385CB4E39CFB1C54CD3215883E58B7")
    private boolean onClosePressed() {
        {
            boolean var64E470953DFC6D121014C23115412BF9_1419278580 = (isEmpty(mSearchAutoComplete));
            {
                dismiss();
            } //End block
        } //End collapsed parenthetic
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1465436572 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1465436572;
        // ---------- Original Method ----------
        //if (isEmpty(mSearchAutoComplete)) {
            //dismiss();
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.457 -0400", hash_original_method = "AC61287D1F4BDFB9C05737508F4ABB90", hash_generated_method = "B9DB14128A168275D10CD265AE58A20D")
    private void setUserQuery(String query) {
        {
            query = "";
        } //End block
        mUserQuery = query;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.473 -0400", hash_original_field = "07AB93C86DCF2727B3D7686803B97F37", hash_generated_field = "247F9D3B324680CEDDC332FCA6608926")

        private SearchDialog mSearchDialog;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.478 -0400", hash_original_method = "A3B6592F51A27BFA7A85197EDA145FFE", hash_generated_method = "DBF76B98CB9968EA9594F2785A3B3866")
        public  SearchBar(Context context, AttributeSet attrs) {
            super(context, attrs);
            addTaint(context.getTaint());
            addTaint(attrs.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.479 -0400", hash_original_method = "4392E8B38D4E47AAE679D125E8E4B6FF", hash_generated_method = "4BE2592B34D38C3F6B65AC2EB8AA305A")
        public  SearchBar(Context context) {
            super(context);
            addTaint(context.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.508 -0400", hash_original_method = "7E3A3D5A1CCC1779F8492CDCF581870E", hash_generated_method = "723912D2FF4CFA7FED8D56FF3CC86130")
        public void setSearchDialog(SearchDialog searchDialog) {
            mSearchDialog = searchDialog;
            // ---------- Original Method ----------
            //mSearchDialog = searchDialog;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.510 -0400", hash_original_method = "195483BC208A3A4410E3220FCA03E982", hash_generated_method = "548EC9E2B3A7AD8190C82A56D8E0936C")
        @Override
        public ActionMode startActionModeForChild(View child, ActionMode.Callback callback) {
            ActionMode varB4EAC82CA7396A68D541C85D26508E83_1774199656 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1774199656 = null;
            addTaint(child.getTaint());
            addTaint(callback.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1774199656.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1774199656;
            // ---------- Original Method ----------
            //return null;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.511 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "B7C4E93D97D072890A37A56076D870F8")

    private static boolean DBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.511 -0400", hash_original_field = "80188998735D6BE6103CE15F0AD5FAB6", hash_generated_field = "4DDFAB0AAF64E32C3495004565A8055C")

    private static String LOG_TAG = "SearchDialog";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.511 -0400", hash_original_field = "5ECE9C8FE4EF49C0CAFCE503C1625BCF", hash_generated_field = "0A7904215524B3C06E82F40393E5DABE")

    private static String INSTANCE_KEY_COMPONENT = "comp";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.512 -0400", hash_original_field = "6AA4A9ADD537EC6FB2B42C71CA57CA90", hash_generated_field = "E0F079CCEB4D0A981841A84E002721A6")

    private static String INSTANCE_KEY_APPDATA = "data";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.512 -0400", hash_original_field = "248A8417FD38990B808C89A094A7C7E8", hash_generated_field = "F1B57BF7298BD3D7C9EE72801C03150D")

    private static String INSTANCE_KEY_USER_QUERY = "uQry";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.544 -0400", hash_original_field = "B8CF89EB7E6552EBC5C9FCBB33074205", hash_generated_field = "61A82CC61263F39D464CE416448D85EF")

    private static String IME_OPTION_NO_MICROPHONE = "nm";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.544 -0400", hash_original_field = "45F7847F1D1C07D089FC78D632C27ECD", hash_generated_field = "86CC11D497DEAF67E0F0021840FA8B01")

    private static int SEARCH_PLATE_LEFT_PADDING_NON_GLOBAL = 7;
}

