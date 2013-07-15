package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.622 -0400", hash_original_field = "B5F063A37AD81095B9F7B6C497D8C073", hash_generated_field = "1106A4E8A92B8ECB3AB388E40AAD60FA")

    private TextView mBadgeLabel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.622 -0400", hash_original_field = "DB25167EF9293EEFF4756808C80CF681", hash_generated_field = "AA62E658C5FFF9798AE22B318F3E352B")

    private ImageView mAppIcon;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.622 -0400", hash_original_field = "A183DEAF35902AC49819EF2DA1163BF1", hash_generated_field = "D28C2E2316A6D4BCBB3634EE05B8CBED")

    private AutoCompleteTextView mSearchAutoComplete;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.622 -0400", hash_original_field = "01BCA17D3E9DDD8BF5B44F3E2EF1EE68", hash_generated_field = "BFE96959B9AF28F7C0E58BC61493C3DB")

    private View mSearchPlate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.622 -0400", hash_original_field = "D1972F87341AF3F5EA90C2B878C0DF14", hash_generated_field = "1366187FE3CF01EF5FC13B6B4154C3DB")

    private SearchView mSearchView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.622 -0400", hash_original_field = "7218FD22EC10C78A06F25F9B75D1FAAD", hash_generated_field = "DD5A2D50F6C0D0417755EF4A026A680F")

    private Drawable mWorkingSpinner;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.622 -0400", hash_original_field = "16EF54934FDE54D82011E1002CD5B491", hash_generated_field = "C06E0E7D1467D7FE8A6F8A71C4DF5424")

    private View mCloseSearch;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.623 -0400", hash_original_field = "43A23F0BB5F798E421F2CC49BC43D947", hash_generated_field = "6F1511307A7DE5E4BDCE1D082D25D113")

    private SearchableInfo mSearchable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.623 -0400", hash_original_field = "82A5F7BC03D8AFDACBBDB135A5815198", hash_generated_field = "50EEF416470C835B6507F85F77B6005A")

    private ComponentName mLaunchComponent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.623 -0400", hash_original_field = "9AD25D597D917C37D99A80719B4F8F99", hash_generated_field = "59F218E5E058390715FC276BA2A49292")

    private Bundle mAppSearchData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.625 -0400", hash_original_field = "2D82D6A5CDAAA9A7194BD0893F3418C6", hash_generated_field = "830673ADBDEDB8A3B6CE8ACC5E0E51D6")

    private Context mActivityContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.625 -0400", hash_original_field = "04D6CDF64323839563B4F92092B41FA4", hash_generated_field = "72504DA1E4071FF872DD4C2D7A26922B")

    private Intent mVoiceWebSearchIntent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.625 -0400", hash_original_field = "11E5F1DDAB281A77343908AB3E79EC12", hash_generated_field = "FEBA65D5D58AD1CB3F0ABB729B735300")

    private Intent mVoiceAppSearchIntent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.626 -0400", hash_original_field = "336CD107D0D6B9BEBFB6CBC4E3350BF4", hash_generated_field = "A4DF17D9C01FD7FA245A1BE527F16171")

    private String mUserQuery;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.626 -0400", hash_original_field = "94107C719F928E0A2A608F06A9B23DE2", hash_generated_field = "AB035B7E16E303E650083D3FC6117294")

    private int mSearchAutoCompleteImeOptions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.068 -0400", hash_original_field = "4C8632D0626D11A25D8014E79CAA4E06", hash_generated_field = "078A814FD4991378BDB28FB48F12B0ED")

    private BroadcastReceiver mConfChangeListener = new BroadcastReceiver() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.068 -0400", hash_original_method = "61FB59FECA93F3EDF27E6A33F699149F", hash_generated_method = "98EAE8A6AA366027995AA3D63178677D")
        @Override
        public void onReceive(Context context, Intent intent) {
            
            {
                boolean varE405DF0F97C7D559E41F379AE2677168_2125883050 = (intent.getAction().equals(Intent.ACTION_CONFIGURATION_CHANGED));
                {
                    onConfigurationChanged();
                } 
            } 
            addTaint(context.getTaint());
            addTaint(intent.getTaint());
            
            
                
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.068 -0400", hash_original_field = "C8DA34EAFE5A804F3DA0F26C8C4E68D6", hash_generated_field = "3245111817DC9835A07A0A31DE4B0A90")

    private final SearchView.OnCloseListener mOnCloseListener = new SearchView.OnCloseListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.068 -0400", hash_original_method = "59E568E09AB29194E5325B85C030BFA7", hash_generated_method = "9A8160A67864EDC0FC245F93C202442A")
        public boolean onClose() {
            
            boolean var7C756DC13C2D8A9436460F5A2B0F353B_1679447489 = (onClosePressed());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_789855726 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_789855726;
            
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.070 -0400", hash_original_field = "30CF5A2AB690CA0DA5E52E2B1D748F3D", hash_generated_field = "E29563EDD9A2E78DCF7B8077DDF9205E")

    private final SearchView.OnQueryTextListener mOnQueryChangeListener = new SearchView.OnQueryTextListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.069 -0400", hash_original_method = "E09154FCFE3F9A3A23F9DDB58EA399A5", hash_generated_method = "8F583E7574BA85E0D25E30F1FC47866F")
        public boolean onQueryTextSubmit(String query) {
            
            dismiss();
            addTaint(query.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_761659196 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_761659196;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.070 -0400", hash_original_method = "B6F5742F5D55A0164A53BADD48E4641B", hash_generated_method = "353766EFCC8F0AD377965FF3483914CC")
        public boolean onQueryTextChange(String newText) {
            
            addTaint(newText.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_80975844 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_80975844;
            
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.072 -0400", hash_original_field = "664EEA0FE979F3BA2B7F5E6EE6FFA2E6", hash_generated_field = "28233D501C7D0E0FB0BF53D4AE9FE3B8")

    private final SearchView.OnSuggestionListener mOnSuggestionSelectionListener = new SearchView.OnSuggestionListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.071 -0400", hash_original_method = "A3A230CAC466D18E54C97A3930C1550C", hash_generated_method = "B8BB399ACFF8B8AB58EE6395C9CBBA39")
        public boolean onSuggestionSelect(int position) {
            
            addTaint(position);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2095629159 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2095629159;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.072 -0400", hash_original_method = "59D851DE147AEDB85EE9900538C05E02", hash_generated_method = "7452D6031F67D102D819D3EB143E8409")
        public boolean onSuggestionClick(int position) {
            
            dismiss();
            addTaint(position);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_425980155 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_425980155;
            
            
            
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.627 -0400", hash_original_method = "F1210797C1F332443A604D5C626C1E55", hash_generated_method = "2A457D069B43912187243BC3869C823E")
    public  SearchDialog(Context context, SearchManager searchManager) {
        super(context, resolveDialogTheme(context));
        addTaint(searchManager.getTaint());
        addTaint(context.getTaint());
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

    
        @DSModeled(DSC.SPEC)
    static int resolveDialogTheme(Context context) {
        TypedValue outValue = new TypedValue();
        context.getTheme().resolveAttribute(com.android.internal.R.attr.searchDialogTheme,
                outValue, true);
        return outValue.resourceId;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.628 -0400", hash_original_method = "ADA44CDEEADE302052A002E44C1889B1", hash_generated_method = "1B09A60335323C910903C36F1E81FFAF")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(savedInstanceState.getTaint());
        super.onCreate(savedInstanceState);
        Window theWindow = getWindow();
        WindowManager.LayoutParams lp = theWindow.getAttributes();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.631 -0400", hash_original_method = "464C4B41AE1C07D5D4F71BE590B5445C", hash_generated_method = "6CD71173C537416B7708E4B1AFBC26D1")
    private void createContentView() {
        setContentView(com.android.internal.R.layout.search_bar);
        SearchBar searchBar = (SearchBar) findViewById(com.android.internal.R.id.search_bar);
        searchBar.setSearchDialog(this);
        mSearchView = (SearchView) findViewById(com.android.internal.R.id.search_view);
        mSearchView.setIconified(false);
        mSearchView.setOnCloseListener(mOnCloseListener);
        mSearchView.setOnQueryTextListener(mOnQueryChangeListener);
        mSearchView.setOnSuggestionListener(mOnSuggestionSelectionListener);
        mSearchView.onActionViewExpanded();
        mCloseSearch = findViewById(com.android.internal.R.id.closeButton);
        mCloseSearch.setOnClickListener(new View.OnClickListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.630 -0400", hash_original_method = "94911F0CA1072E95A75799AAC34EFD5F", hash_generated_method = "1DD1419B1A67DD9095538B767D725B73")
        @Override
        public void onClick(View v) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(v.getTaint());
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.632 -0400", hash_original_method = "08D03C59DE669D3068C0B765E743FE8E", hash_generated_method = "3E8941C10D87BBDF6668A5F10A2D5C59")
    public boolean show(String initialQuery, boolean selectInitialQuery,
            ComponentName componentName, Bundle appSearchData) {
        addTaint(appSearchData.getTaint());
        addTaint(componentName.getTaint());
        addTaint(selectInitialQuery);
        addTaint(initialQuery.getTaint());
        boolean success = doShow(initialQuery, selectInitialQuery, componentName, appSearchData);
    if(success)        
        {
            mSearchAutoComplete.showDropDownAfterLayout();
        } //End block
        boolean var260CA9DD8A4577FC00B7BD5810298076_221315465 = (success);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1406859253 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1406859253;
        // ---------- Original Method ----------
        //boolean success = doShow(initialQuery, selectInitialQuery, componentName, appSearchData);
        //if (success) {
            //mSearchAutoComplete.showDropDownAfterLayout();
        //}
        //return success;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.633 -0400", hash_original_method = "EAE1B7BC7DC4BF1770F63B02B1B868E2", hash_generated_method = "038CB2CDEBA93EF32BD8189FDD39F7B6")
    private boolean doShow(String initialQuery, boolean selectInitialQuery,
            ComponentName componentName, Bundle appSearchData) {
        addTaint(appSearchData.getTaint());
        addTaint(componentName.getTaint());
        addTaint(selectInitialQuery);
        addTaint(initialQuery.getTaint());
    if(!show(componentName, appSearchData))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1189431572 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_895355124 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_895355124;
        } //End block
        setUserQuery(initialQuery);
    if(selectInitialQuery)        
        {
            mSearchAutoComplete.selectAll();
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1676526077 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1315831181 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1315831181;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.636 -0400", hash_original_method = "705B52B556BB75FCC3E8159D4BF0A627", hash_generated_method = "DCED87D0DB91ED8159F0F408052F16A8")
    private boolean show(ComponentName componentName, Bundle appSearchData) {
    if(DBG)        
        {
            Log.d(LOG_TAG, "show(" + componentName + ", " 
                    + appSearchData + ")");
        } //End block
        SearchManager searchManager = (SearchManager)
                mContext.getSystemService(Context.SEARCH_SERVICE);
        mSearchable = searchManager.getSearchableInfo(componentName);
    if(mSearchable == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_276612582 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_772650039 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_772650039;
        } //End block
        mLaunchComponent = componentName;
        mAppSearchData = appSearchData;
        mActivityContext = mSearchable.getActivityContext(getContext());
    if(!isShowing())        
        {
            createContentView();
            mSearchView.setSearchableInfo(mSearchable);
            mSearchView.setAppSearchData(mAppSearchData);
            show();
        } //End block
        updateUI();
        boolean varB326B5062B2F0E69046810717534CB09_558690946 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_890246838 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_890246838;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.637 -0400", hash_original_method = "57C4DE658D3F4A02662686A9CE61B2E8", hash_generated_method = "BE7B8D8391D43FB6F5DEE404D22862CF")
    @Override
    public void onStart() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onStart();
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_CONFIGURATION_CHANGED);
        getContext().registerReceiver(mConfChangeListener, filter);
        // ---------- Original Method ----------
        //super.onStart();
        //IntentFilter filter = new IntentFilter();
        //filter.addAction(Intent.ACTION_CONFIGURATION_CHANGED);
        //getContext().registerReceiver(mConfChangeListener, filter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.639 -0400", hash_original_method = "6050D9FBC779B270404C43A7E853C1E6", hash_generated_method = "984822E2BAA867DD58A325DECDF6CA94")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.639 -0400", hash_original_method = "25F8B16486236BF1FAF351BB43EBD4A7", hash_generated_method = "3696D170441C3B18794ED2C65DB79F3A")
    public void setWorking(boolean working) {
        addTaint(working);
        mWorkingSpinner.setAlpha(working ? 255 : 0);
        mWorkingSpinner.setVisible(working, false);
        mWorkingSpinner.invalidateSelf();
        // ---------- Original Method ----------
        //mWorkingSpinner.setAlpha(working ? 255 : 0);
        //mWorkingSpinner.setVisible(working, false);
        //mWorkingSpinner.invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.640 -0400", hash_original_method = "A93DBE942737D1F537AD057E006AED8C", hash_generated_method = "DD8AE8A9FA60B1DB38FA4DE1523C7948")
    @Override
    public Bundle onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
    if(!isShowing())        
        {
Bundle var540C13E9E156B687226421B24F2DF178_1784351707 =         null;
        var540C13E9E156B687226421B24F2DF178_1784351707.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1784351707;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable(INSTANCE_KEY_COMPONENT, mLaunchComponent);
        bundle.putBundle(INSTANCE_KEY_APPDATA, mAppSearchData);
        bundle.putString(INSTANCE_KEY_USER_QUERY, mUserQuery);
Bundle var7B2862195409742DCA365D8C6330AB92_851847894 =         bundle;
        var7B2862195409742DCA365D8C6330AB92_851847894.addTaint(taint);
        return var7B2862195409742DCA365D8C6330AB92_851847894;
        // ---------- Original Method ----------
        //if (!isShowing()) return null;
        //Bundle bundle = new Bundle();
        //bundle.putParcelable(INSTANCE_KEY_COMPONENT, mLaunchComponent);
        //bundle.putBundle(INSTANCE_KEY_APPDATA, mAppSearchData);
        //bundle.putString(INSTANCE_KEY_USER_QUERY, mUserQuery);
        //return bundle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.640 -0400", hash_original_method = "D7088D676BF54E193C8B7B9D0CD3713D", hash_generated_method = "7B21B9562E6036EBF8934034DF03F17F")
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(savedInstanceState.getTaint());
    if(savedInstanceState == null)        
        return;
        ComponentName launchComponent = savedInstanceState.getParcelable(INSTANCE_KEY_COMPONENT);
        Bundle appSearchData = savedInstanceState.getBundle(INSTANCE_KEY_APPDATA);
        String userQuery = savedInstanceState.getString(INSTANCE_KEY_USER_QUERY);
    if(!doShow(userQuery, false, launchComponent, appSearchData))        
        {
            return;
        } //End block
        // ---------- Original Method ----------
        //if (savedInstanceState == null) return;
        //ComponentName launchComponent = savedInstanceState.getParcelable(INSTANCE_KEY_COMPONENT);
        //Bundle appSearchData = savedInstanceState.getBundle(INSTANCE_KEY_APPDATA);
        //String userQuery = savedInstanceState.getString(INSTANCE_KEY_USER_QUERY);
        //if (!doShow(userQuery, false, launchComponent, appSearchData)) {
            //return;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.641 -0400", hash_original_method = "D7D85FA93E7D9B21BC4DF3FC01DC78AB", hash_generated_method = "B220F7819E1C912DBA45A89B330DF2FC")
    public void onConfigurationChanged() {
        //DSFIXME:  CODE0009: Possible callback target function detected
    if(mSearchable != null && isShowing())        
        {
            updateSearchAppIcon();
            updateSearchBadge();
    if(isLandscapeMode(getContext()))            
            {
                mSearchAutoComplete.ensureImeVisible(true);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mSearchable != null && isShowing()) {
            //updateSearchAppIcon();
            //updateSearchBadge();
            //if (isLandscapeMode(getContext())) {
                //mSearchAutoComplete.ensureImeVisible(true);
            //}
        //}
    }

    
        @DSModeled(DSC.SPEC)
    static boolean isLandscapeMode(Context context) {
        return context.getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_LANDSCAPE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.642 -0400", hash_original_method = "BEA9325A3466C1690A3F58B8B49BC62D", hash_generated_method = "2A88C6AF5F6C8D1BD479D9CE36C53E5F")
    private void updateUI() {
    if(mSearchable != null)        
        {
            mDecor.setVisibility(View.VISIBLE);
            updateSearchAutoComplete();
            updateSearchAppIcon();
            updateSearchBadge();
            int inputType = mSearchable.getInputType();
    if((inputType & InputType.TYPE_MASK_CLASS) == InputType.TYPE_CLASS_TEXT)            
            {
                inputType &= ~InputType.TYPE_TEXT_FLAG_AUTO_COMPLETE;
    if(mSearchable.getSuggestAuthority() != null)                
                {
                    inputType |= InputType.TYPE_TEXT_FLAG_AUTO_COMPLETE;
                } //End block
            } //End block
            mSearchAutoComplete.setInputType(inputType);
            mSearchAutoCompleteImeOptions = mSearchable.getImeOptions();
            mSearchAutoComplete.setImeOptions(mSearchAutoCompleteImeOptions);
    if(mSearchable.getVoiceSearchEnabled())            
            {
                mSearchAutoComplete.setPrivateImeOptions(IME_OPTION_NO_MICROPHONE);
            } //End block
            else
            {
                mSearchAutoComplete.setPrivateImeOptions(null);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.643 -0400", hash_original_method = "7645C33AE0588436620AE83A499D7C08", hash_generated_method = "B486407D70349091073B2AB72B9DD448")
    private void updateSearchAutoComplete() {
        mSearchAutoComplete.setDropDownDismissedOnCompletion(false);
        mSearchAutoComplete.setForceIgnoreOutsideTouch(false);
        // ---------- Original Method ----------
        //mSearchAutoComplete.setDropDownDismissedOnCompletion(false);
        //mSearchAutoComplete.setForceIgnoreOutsideTouch(false);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.644 -0400", hash_original_method = "E83CA9B0957C02D3E99E874CE94E4E80", hash_generated_method = "7BF9C1FD7211EFC373AB440709516B7F")
    private void updateSearchAppIcon() {
        PackageManager pm = getContext().getPackageManager();
        Drawable icon;
        try 
        {
            ActivityInfo info = pm.getActivityInfo(mLaunchComponent, 0);
            icon = pm.getApplicationIcon(info.applicationInfo);
    if(DBG)            
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.646 -0400", hash_original_method = "306E7BCD0818ADE89EBA434EE06262F7", hash_generated_method = "669295363F8ADC6B4C97641E9EB3B005")
    private void updateSearchBadge() {
        int visibility = View.GONE;
        Drawable icon = null;
        CharSequence text = null;
    if(mSearchable.useBadgeIcon())        
        {
            icon = mActivityContext.getResources().getDrawable(mSearchable.getIconId());
            visibility = View.VISIBLE;
    if(DBG)            
            Log.d(LOG_TAG, "Using badge icon: " + mSearchable.getIconId());
        } //End block
        else
    if(mSearchable.useBadgeLabel())        
        {
            text = mActivityContext.getResources().getText(mSearchable.getLabelId()).toString();
            visibility = View.VISIBLE;
    if(DBG)            
            Log.d(LOG_TAG, "Using badge label: " + mSearchable.getLabelId());
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.647 -0400", hash_original_method = "0D9DE884F4C3EB514898202D906CFD1D", hash_generated_method = "F11361A64E163CC6F93AAFFC222F11FA")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
    if(!mSearchAutoComplete.isPopupShowing() && isOutOfBounds(mSearchPlate, event))        
        {
    if(DBG)            
            Log.d(LOG_TAG, "Pop-up not showing and outside of search plate.");
            cancel();
            boolean varB326B5062B2F0E69046810717534CB09_1415054159 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1423682628 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1423682628;
        } //End block
        boolean varB07EB30996A92905DCA4C49613CBAF5F_635054265 = (super.onTouchEvent(event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1582408691 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1582408691;
        // ---------- Original Method ----------
        //if (!mSearchAutoComplete.isPopupShowing() && isOutOfBounds(mSearchPlate, event)) {
            //if (DBG) Log.d(LOG_TAG, "Pop-up not showing and outside of search plate.");
            //cancel();
            //return true;
        //}
        //return super.onTouchEvent(event);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.647 -0400", hash_original_method = "56250C7379795A076A294BCEF2D5FD2C", hash_generated_method = "CEA82616B9A477B8C9B21D840B2F4C83")
    private boolean isOutOfBounds(View v, MotionEvent event) {
        addTaint(event.getTaint());
        addTaint(v.getTaint());
        final int x = (int) event.getX();
        final int y = (int) event.getY();
        final int slop = ViewConfiguration.get(mContext).getScaledWindowTouchSlop();
        boolean varD14EF19BE0BB4F81D62FB25998CFF8D2_990221229 = ((x < -slop) || (y < -slop)
                || (x > (v.getWidth()+slop))
                || (y > (v.getHeight()+slop)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1148836721 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1148836721;
        // ---------- Original Method ----------
        //final int x = (int) event.getX();
        //final int y = (int) event.getY();
        //final int slop = ViewConfiguration.get(mContext).getScaledWindowTouchSlop();
        //return (x < -slop) || (y < -slop)
                //|| (x > (v.getWidth()+slop))
                //|| (y > (v.getHeight()+slop));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.648 -0400", hash_original_method = "6ED6F897B7566B2172AD538A3B9EBF5C", hash_generated_method = "B9C71C476DCF0A75A7242DD1365B586F")
    @Override
    public void hide() {
    if(!isShowing())        
        return;
        InputMethodManager imm = (InputMethodManager)getContext()
                .getSystemService(Context.INPUT_METHOD_SERVICE);
    if(imm != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.648 -0400", hash_original_method = "A776EE9CD94492AC9830F6D90123EF80", hash_generated_method = "1F96E398546D6644A16C0EB6DC477101")
    public void launchQuerySearch() {
        launchQuerySearch(KeyEvent.KEYCODE_UNKNOWN, null);
        // ---------- Original Method ----------
        //launchQuerySearch(KeyEvent.KEYCODE_UNKNOWN, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.649 -0400", hash_original_method = "8DA1240BCB0B1358D88E8B5A3BC94CC9", hash_generated_method = "5423F14BCD0912B3B7995D79DEE5536E")
    protected void launchQuerySearch(int actionKey, String actionMsg) {
        addTaint(actionMsg.getTaint());
        addTaint(actionKey);
        String query = mSearchAutoComplete.getText().toString();
        String action = Intent.ACTION_SEARCH;
        Intent intent = createIntent(action, null, null, query, actionKey, actionMsg);
        launchIntent(intent);
        // ---------- Original Method ----------
        //String query = mSearchAutoComplete.getText().toString();
        //String action = Intent.ACTION_SEARCH;
        //Intent intent = createIntent(action, null, null, query, actionKey, actionMsg);
        //launchIntent(intent);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.649 -0400", hash_original_method = "BC4CCAAD8BAD8DFDC06067A6480767AA", hash_generated_method = "7040D0F9E1C6FC04DB30D39E6CAF63DA")
    private void launchIntent(Intent intent) {
        addTaint(intent.getTaint());
    if(intent == null)        
        {
            return;
        } //End block
        Log.d(LOG_TAG, "launching " + intent);
        try 
        {
            getContext().startActivity(intent);
            dismiss();
        } //End block
        catch (RuntimeException ex)
        {
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.650 -0400", hash_original_method = "A7D428EF1EDEF778DF6A68394BD0B0D0", hash_generated_method = "AA7A423639C27056D168B09A563E2FC7")
    public void setListSelection(int index) {
        addTaint(index);
        mSearchAutoComplete.setListSelection(index);
        // ---------- Original Method ----------
        //mSearchAutoComplete.setListSelection(index);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.651 -0400", hash_original_method = "7931502AE551A2F220A0C85C1181EB09", hash_generated_method = "869F09B49C8489D1549EC776A792F2D2")
    private Intent createIntent(String action, Uri data, String extraData, String query,
            int actionKey, String actionMsg) {
        addTaint(actionMsg.getTaint());
        addTaint(actionKey);
        addTaint(query.getTaint());
        addTaint(extraData.getTaint());
        addTaint(data.getTaint());
        addTaint(action.getTaint());
        Intent intent = new Intent(action);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    if(data != null)        
        {
            intent.setData(data);
        } //End block
        intent.putExtra(SearchManager.USER_QUERY, mUserQuery);
    if(query != null)        
        {
            intent.putExtra(SearchManager.QUERY, query);
        } //End block
    if(extraData != null)        
        {
            intent.putExtra(SearchManager.EXTRA_DATA_KEY, extraData);
        } //End block
    if(mAppSearchData != null)        
        {
            intent.putExtra(SearchManager.APP_DATA, mAppSearchData);
        } //End block
    if(actionKey != KeyEvent.KEYCODE_UNKNOWN)        
        {
            intent.putExtra(SearchManager.ACTION_KEY, actionKey);
            intent.putExtra(SearchManager.ACTION_MSG, actionMsg);
        } //End block
        intent.setComponent(mSearchable.getSearchActivity());
Intent var095937E5B36214360A2644916BF0E8DF_1808906433 =         intent;
        var095937E5B36214360A2644916BF0E8DF_1808906433.addTaint(taint);
        return var095937E5B36214360A2644916BF0E8DF_1808906433;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.651 -0400", hash_original_method = "F1F42C772C06A28CE3769310F1841510", hash_generated_method = "7F2F55BF2822F562769BE1D5622C91F4")
    private boolean isEmpty(AutoCompleteTextView actv) {
        addTaint(actv.getTaint());
        boolean var8E0C66D225FA2540FF4A949E52DCA7E7_1877305951 = (TextUtils.getTrimmedLength(actv.getText()) == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_858719917 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_858719917;
        // ---------- Original Method ----------
        //return TextUtils.getTrimmedLength(actv.getText()) == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.652 -0400", hash_original_method = "85C012DD8E7654DEDC3FCC35E518B3D4", hash_generated_method = "C63C6984B12B9C1072C209561E7602E3")
    @Override
    public void onBackPressed() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        InputMethodManager imm = (InputMethodManager)getContext()
                .getSystemService(Context.INPUT_METHOD_SERVICE);
    if(imm != null && imm.isFullscreenMode() &&
                imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0))        
        {
            return;
        } //End block
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.652 -0400", hash_original_method = "D537924252E5FBECE100B51E4DF20EDD", hash_generated_method = "DC0A63383ED217B54128944A17FDF02B")
    private boolean onClosePressed() {
    if(isEmpty(mSearchAutoComplete))        
        {
            dismiss();
            boolean varB326B5062B2F0E69046810717534CB09_559511415 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_931781851 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_931781851;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_15312882 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_836067712 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_836067712;
        // ---------- Original Method ----------
        //if (isEmpty(mSearchAutoComplete)) {
            //dismiss();
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.653 -0400", hash_original_method = "AC61287D1F4BDFB9C05737508F4ABB90", hash_generated_method = "708386CC7BDBAB35148A0ED905959FDD")
    private void setUserQuery(String query) {
    if(query == null)        
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.654 -0400", hash_original_field = "07AB93C86DCF2727B3D7686803B97F37", hash_generated_field = "247F9D3B324680CEDDC332FCA6608926")

        private SearchDialog mSearchDialog;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.654 -0400", hash_original_method = "A3B6592F51A27BFA7A85197EDA145FFE", hash_generated_method = "09048A3FCCF2CF3674B2E844C0E0EFEC")
        public  SearchBar(Context context, AttributeSet attrs) {
            super(context, attrs);
            addTaint(attrs.getTaint());
            addTaint(context.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.655 -0400", hash_original_method = "4392E8B38D4E47AAE679D125E8E4B6FF", hash_generated_method = "4BE2592B34D38C3F6B65AC2EB8AA305A")
        public  SearchBar(Context context) {
            super(context);
            addTaint(context.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.656 -0400", hash_original_method = "7E3A3D5A1CCC1779F8492CDCF581870E", hash_generated_method = "723912D2FF4CFA7FED8D56FF3CC86130")
        public void setSearchDialog(SearchDialog searchDialog) {
            mSearchDialog = searchDialog;
            // ---------- Original Method ----------
            //mSearchDialog = searchDialog;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.656 -0400", hash_original_method = "195483BC208A3A4410E3220FCA03E982", hash_generated_method = "47E825A17E6A2B43CAAE7313EBAB8252")
        @Override
        public ActionMode startActionModeForChild(View child, ActionMode.Callback callback) {
            addTaint(callback.getTaint());
            addTaint(child.getTaint());
ActionMode var540C13E9E156B687226421B24F2DF178_537832848 =             null;
            var540C13E9E156B687226421B24F2DF178_537832848.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_537832848;
            // ---------- Original Method ----------
            //return null;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.656 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.657 -0400", hash_original_field = "80188998735D6BE6103CE15F0AD5FAB6", hash_generated_field = "2108E8D2E82C8F5E3CDA71B7634FCAF0")

    private static final String LOG_TAG = "SearchDialog";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.657 -0400", hash_original_field = "5ECE9C8FE4EF49C0CAFCE503C1625BCF", hash_generated_field = "32263DEC0FC7AEC057254F1EE9768AC4")

    private static final String INSTANCE_KEY_COMPONENT = "comp";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.657 -0400", hash_original_field = "6AA4A9ADD537EC6FB2B42C71CA57CA90", hash_generated_field = "1FBAB201C0ABBCB1FC1817DA78FCEDB5")

    private static final String INSTANCE_KEY_APPDATA = "data";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.657 -0400", hash_original_field = "248A8417FD38990B808C89A094A7C7E8", hash_generated_field = "A1E0FBB48DCD1FE95C7FA9374B53A700")

    private static final String INSTANCE_KEY_USER_QUERY = "uQry";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.657 -0400", hash_original_field = "B8CF89EB7E6552EBC5C9FCBB33074205", hash_generated_field = "7875B207C54E2B6D5ABF1652FFF3F22A")

    private static final String IME_OPTION_NO_MICROPHONE = "nm";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.657 -0400", hash_original_field = "45F7847F1D1C07D089FC78D632C27ECD", hash_generated_field = "4DA3BCE289680CAD95CE7D774B9BCB53")

    private static final int SEARCH_PLATE_LEFT_PADDING_NON_GLOBAL = 7;
}

