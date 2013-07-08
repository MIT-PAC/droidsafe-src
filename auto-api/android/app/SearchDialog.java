package android.app;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.067 -0400", hash_original_field = "B5F063A37AD81095B9F7B6C497D8C073", hash_generated_field = "1106A4E8A92B8ECB3AB388E40AAD60FA")

    private TextView mBadgeLabel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.067 -0400", hash_original_field = "DB25167EF9293EEFF4756808C80CF681", hash_generated_field = "AA62E658C5FFF9798AE22B318F3E352B")

    private ImageView mAppIcon;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.067 -0400", hash_original_field = "A183DEAF35902AC49819EF2DA1163BF1", hash_generated_field = "D28C2E2316A6D4BCBB3634EE05B8CBED")

    private AutoCompleteTextView mSearchAutoComplete;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.067 -0400", hash_original_field = "01BCA17D3E9DDD8BF5B44F3E2EF1EE68", hash_generated_field = "BFE96959B9AF28F7C0E58BC61493C3DB")

    private View mSearchPlate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.067 -0400", hash_original_field = "D1972F87341AF3F5EA90C2B878C0DF14", hash_generated_field = "1366187FE3CF01EF5FC13B6B4154C3DB")

    private SearchView mSearchView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.067 -0400", hash_original_field = "7218FD22EC10C78A06F25F9B75D1FAAD", hash_generated_field = "DD5A2D50F6C0D0417755EF4A026A680F")

    private Drawable mWorkingSpinner;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.067 -0400", hash_original_field = "16EF54934FDE54D82011E1002CD5B491", hash_generated_field = "C06E0E7D1467D7FE8A6F8A71C4DF5424")

    private View mCloseSearch;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.067 -0400", hash_original_field = "43A23F0BB5F798E421F2CC49BC43D947", hash_generated_field = "6F1511307A7DE5E4BDCE1D082D25D113")

    private SearchableInfo mSearchable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.067 -0400", hash_original_field = "82A5F7BC03D8AFDACBBDB135A5815198", hash_generated_field = "50EEF416470C835B6507F85F77B6005A")

    private ComponentName mLaunchComponent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.067 -0400", hash_original_field = "9AD25D597D917C37D99A80719B4F8F99", hash_generated_field = "59F218E5E058390715FC276BA2A49292")

    private Bundle mAppSearchData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.067 -0400", hash_original_field = "2D82D6A5CDAAA9A7194BD0893F3418C6", hash_generated_field = "830673ADBDEDB8A3B6CE8ACC5E0E51D6")

    private Context mActivityContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.067 -0400", hash_original_field = "04D6CDF64323839563B4F92092B41FA4", hash_generated_field = "72504DA1E4071FF872DD4C2D7A26922B")

    private Intent mVoiceWebSearchIntent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.067 -0400", hash_original_field = "11E5F1DDAB281A77343908AB3E79EC12", hash_generated_field = "FEBA65D5D58AD1CB3F0ABB729B735300")

    private Intent mVoiceAppSearchIntent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.067 -0400", hash_original_field = "336CD107D0D6B9BEBFB6CBC4E3350BF4", hash_generated_field = "A4DF17D9C01FD7FA245A1BE527F16171")

    private String mUserQuery;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.067 -0400", hash_original_field = "94107C719F928E0A2A608F06A9B23DE2", hash_generated_field = "AB035B7E16E303E650083D3FC6117294")

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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.072 -0400", hash_original_method = "F1210797C1F332443A604D5C626C1E55", hash_generated_method = "B52D28654D3C33C7304882237AC71C77")
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
        
        
        
        
                
        
        
    }

    
        @DSModeled(DSC.SAFE)
    static int resolveDialogTheme(Context context) {
        TypedValue outValue = new TypedValue();
        context.getTheme().resolveAttribute(com.android.internal.R.attr.searchDialogTheme,
                outValue, true);
        return outValue.resourceId;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.073 -0400", hash_original_method = "ADA44CDEEADE302052A002E44C1889B1", hash_generated_method = "E35EEA4C102E74033DA60EF490100B48")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        Window theWindow = getWindow();
        WindowManager.LayoutParams lp = theWindow.getAttributes();
        lp.width = ViewGroup.LayoutParams.MATCH_PARENT;
        lp.height = ViewGroup.LayoutParams.MATCH_PARENT;
        lp.gravity = Gravity.TOP | Gravity.FILL_HORIZONTAL;
        lp.softInputMode = WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE;
        theWindow.setAttributes(lp);
        setCanceledOnTouchOutside(true);
        addTaint(savedInstanceState.getTaint());
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.075 -0400", hash_original_method = "464C4B41AE1C07D5D4F71BE590B5445C", hash_generated_method = "D7B49D3E493460568A8B53B076AD529F")
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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.074 -0400", hash_original_method = "94911F0CA1072E95A75799AAC34EFD5F", hash_generated_method = "31BEF810EEA8B2DD9BFC5D7F6EE5D941")
            @Override
            public void onClick(View v) {
                
                dismiss();
                addTaint(v.getTaint());
                
                
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
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.075 -0400", hash_original_method = "08D03C59DE669D3068C0B765E743FE8E", hash_generated_method = "E66BEC54A4F46787CB068768A4AD1D62")
    public boolean show(String initialQuery, boolean selectInitialQuery,
            ComponentName componentName, Bundle appSearchData) {
        boolean success = doShow(initialQuery, selectInitialQuery, componentName, appSearchData);
        {
            mSearchAutoComplete.showDropDownAfterLayout();
        } 
        addTaint(initialQuery.getTaint());
        addTaint(selectInitialQuery);
        addTaint(componentName.getTaint());
        addTaint(appSearchData.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_346862278 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_346862278;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.076 -0400", hash_original_method = "EAE1B7BC7DC4BF1770F63B02B1B868E2", hash_generated_method = "32C7DD1C4B23E28936E3DE946C8D2D5A")
    private boolean doShow(String initialQuery, boolean selectInitialQuery,
            ComponentName componentName, Bundle appSearchData) {
        {
            boolean var473B8D869FB051523792CFDB691F86C1_829366918 = (!show(componentName, appSearchData));
        } 
        setUserQuery(initialQuery);
        {
            mSearchAutoComplete.selectAll();
        } 
        addTaint(initialQuery.getTaint());
        addTaint(selectInitialQuery);
        addTaint(componentName.getTaint());
        addTaint(appSearchData.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1812782001 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1812782001;
        
        
            
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.076 -0400", hash_original_method = "705B52B556BB75FCC3E8159D4BF0A627", hash_generated_method = "0B97825D0821CB77513665AAFBE21696")
    private boolean show(ComponentName componentName, Bundle appSearchData) {
        {
            Log.d(LOG_TAG, "show(" + componentName + ", " 
                    + appSearchData + ")");
        } 
        SearchManager searchManager = (SearchManager)
                mContext.getSystemService(Context.SEARCH_SERVICE);
        mSearchable = searchManager.getSearchableInfo(componentName);
        mLaunchComponent = componentName;
        mAppSearchData = appSearchData;
        mActivityContext = mSearchable.getActivityContext(getContext());
        {
            boolean var67F0F8A90F47989DCF9FDFD2C3F61D76_473868663 = (!isShowing());
            {
                createContentView();
                mSearchView.setSearchableInfo(mSearchable);
                mSearchView.setAppSearchData(mAppSearchData);
                show();
            } 
        } 
        updateUI();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_830967300 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_830967300;
        
        
            
                    
        
        
                
        
        
            
        
        
        
        
        
            
            
            
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.077 -0400", hash_original_method = "57C4DE658D3F4A02662686A9CE61B2E8", hash_generated_method = "BE7B8D8391D43FB6F5DEE404D22862CF")
    @Override
    public void onStart() {
        
        super.onStart();
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_CONFIGURATION_CHANGED);
        getContext().registerReceiver(mConfChangeListener, filter);
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.078 -0400", hash_original_method = "6050D9FBC779B270404C43A7E853C1E6", hash_generated_method = "984822E2BAA867DD58A325DECDF6CA94")
    @Override
    public void onStop() {
        
        super.onStop();
        getContext().unregisterReceiver(mConfChangeListener);
        mLaunchComponent = null;
        mAppSearchData = null;
        mSearchable = null;
        mUserQuery = null;
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.078 -0400", hash_original_method = "25F8B16486236BF1FAF351BB43EBD4A7", hash_generated_method = "BFC527EFBB5F72AE120BA0BDCF329278")
    public void setWorking(boolean working) {
        mWorkingSpinner.setAlpha(working ? 255 : 0);
        mWorkingSpinner.setVisible(working, false);
        mWorkingSpinner.invalidateSelf();
        addTaint(working);
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.079 -0400", hash_original_method = "A93DBE942737D1F537AD057E006AED8C", hash_generated_method = "8DAA458669BEC99AA02E9A90CE29B135")
    @Override
    public Bundle onSaveInstanceState() {
        
        Bundle varB4EAC82CA7396A68D541C85D26508E83_844501870 = null; 
        Bundle varB4EAC82CA7396A68D541C85D26508E83_1807360702 = null; 
        {
            boolean var67F0F8A90F47989DCF9FDFD2C3F61D76_1519338531 = (!isShowing());
            varB4EAC82CA7396A68D541C85D26508E83_844501870 = null;
        } 
        Bundle bundle = new Bundle();
        bundle.putParcelable(INSTANCE_KEY_COMPONENT, mLaunchComponent);
        bundle.putBundle(INSTANCE_KEY_APPDATA, mAppSearchData);
        bundle.putString(INSTANCE_KEY_USER_QUERY, mUserQuery);
        varB4EAC82CA7396A68D541C85D26508E83_1807360702 = bundle;
        Bundle varA7E53CE21691AB073D9660D615818899_1534385603; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1534385603 = varB4EAC82CA7396A68D541C85D26508E83_844501870;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1534385603 = varB4EAC82CA7396A68D541C85D26508E83_1807360702;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1534385603.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1534385603;
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.080 -0400", hash_original_method = "D7088D676BF54E193C8B7B9D0CD3713D", hash_generated_method = "428FFAD3957EB7C1953F1329A7957FEB")
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        
        ComponentName launchComponent = savedInstanceState.getParcelable(INSTANCE_KEY_COMPONENT);
        Bundle appSearchData = savedInstanceState.getBundle(INSTANCE_KEY_APPDATA);
        String userQuery = savedInstanceState.getString(INSTANCE_KEY_USER_QUERY);
        {
            boolean varCADE91999A5045C9B6A838D3ABB970B0_1841315985 = (!doShow(userQuery, false, launchComponent, appSearchData));
        } 
        addTaint(savedInstanceState.getTaint());
        
        
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.081 -0400", hash_original_method = "D7D85FA93E7D9B21BC4DF3FC01DC78AB", hash_generated_method = "11C9435819372F119658A2B96DD8BF8D")
    public void onConfigurationChanged() {
        
        {
            boolean var79A5C46CCA5E7286E0D93C56266E8188_622946977 = (mSearchable != null && isShowing());
            {
                updateSearchAppIcon();
                updateSearchBadge();
                {
                    boolean varD9CA9AD6B23722108299537C69CF06C3_265272905 = (isLandscapeMode(getContext()));
                    {
                        mSearchAutoComplete.ensureImeVisible(true);
                    } 
                } 
            } 
        } 
        
        
            
            
            
                
            
        
    }

    
        @DSModeled(DSC.SAFE)
    static boolean isLandscapeMode(Context context) {
        return context.getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_LANDSCAPE;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.083 -0400", hash_original_method = "BEA9325A3466C1690A3F58B8B49BC62D", hash_generated_method = "AE71F12351319119C64A3B20F706939C")
    private void updateUI() {
        {
            mDecor.setVisibility(View.VISIBLE);
            updateSearchAutoComplete();
            updateSearchAppIcon();
            updateSearchBadge();
            int inputType = mSearchable.getInputType();
            {
                inputType &= ~InputType.TYPE_TEXT_FLAG_AUTO_COMPLETE;
                {
                    boolean varE37A0D6BE7319DB117FE61B1B4764F6E_1175143686 = (mSearchable.getSuggestAuthority() != null);
                    {
                        inputType |= InputType.TYPE_TEXT_FLAG_AUTO_COMPLETE;
                    } 
                } 
            } 
            mSearchAutoComplete.setInputType(inputType);
            mSearchAutoCompleteImeOptions = mSearchable.getImeOptions();
            mSearchAutoComplete.setImeOptions(mSearchAutoCompleteImeOptions);
            {
                boolean var33073265117069CA3BD3530ADCE8C281_2082290575 = (mSearchable.getVoiceSearchEnabled());
                {
                    mSearchAutoComplete.setPrivateImeOptions(IME_OPTION_NO_MICROPHONE);
                } 
                {
                    mSearchAutoComplete.setPrivateImeOptions(null);
                } 
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.084 -0400", hash_original_method = "7645C33AE0588436620AE83A499D7C08", hash_generated_method = "B486407D70349091073B2AB72B9DD448")
    private void updateSearchAutoComplete() {
        mSearchAutoComplete.setDropDownDismissedOnCompletion(false);
        mSearchAutoComplete.setForceIgnoreOutsideTouch(false);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.085 -0400", hash_original_method = "E83CA9B0957C02D3E99E874CE94E4E80", hash_generated_method = "3AA0AF3AB20F79BC2E5DADBEF9D10E07")
    private void updateSearchAppIcon() {
        PackageManager pm = getContext().getPackageManager();
        Drawable icon;
        try 
        {
            ActivityInfo info = pm.getActivityInfo(mLaunchComponent, 0);
            icon = pm.getApplicationIcon(info.applicationInfo);
            Log.d(LOG_TAG, "Using app-specific icon");
        } 
        catch (NameNotFoundException e)
        {
            icon = pm.getDefaultActivityIcon();
        } 
        mAppIcon.setImageDrawable(icon);
        mAppIcon.setVisibility(View.VISIBLE);
        mSearchPlate.setPadding(SEARCH_PLATE_LEFT_PADDING_NON_GLOBAL, mSearchPlate.getPaddingTop(), mSearchPlate.getPaddingRight(), mSearchPlate.getPaddingBottom());
        
        
        
        
            
            
            
                
        
            
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.086 -0400", hash_original_method = "306E7BCD0818ADE89EBA434EE06262F7", hash_generated_method = "7B85B5F19916D32708FD3364E6A632B2")
    private void updateSearchBadge() {
        int visibility = View.GONE;
        Drawable icon = null;
        CharSequence text = null;
        {
            boolean var4B40E5E52C5EBE3D0042AA73F5931D76_2002065343 = (mSearchable.useBadgeIcon());
            {
                icon = mActivityContext.getResources().getDrawable(mSearchable.getIconId());
                visibility = View.VISIBLE;
                Log.d(LOG_TAG, "Using badge icon: " + mSearchable.getIconId());
            } 
            {
                boolean varFB7BF02190381C7212E4349D9E51B506_852657890 = (mSearchable.useBadgeLabel());
                {
                    text = mActivityContext.getResources().getText(mSearchable.getLabelId()).toString();
                    visibility = View.VISIBLE;
                    Log.d(LOG_TAG, "Using badge label: " + mSearchable.getLabelId());
                } 
            } 
        } 
        mBadgeLabel.setCompoundDrawablesWithIntrinsicBounds(icon, null, null, null);
        mBadgeLabel.setText(text);
        mBadgeLabel.setVisibility(visibility);
        
        
        
        
        
            
            
            
        
            
            
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.086 -0400", hash_original_method = "0D9DE884F4C3EB514898202D906CFD1D", hash_generated_method = "015E71B98CD27DC4545359010DC57180")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        
        {
            boolean varCE17A41A6CEAAE3326A1B5E493AA76FE_634189695 = (!mSearchAutoComplete.isPopupShowing() && isOutOfBounds(mSearchPlate, event));
            {
                Log.d(LOG_TAG, "Pop-up not showing and outside of search plate.");
                cancel();
            } 
        } 
        boolean var5D1E90CB51451ACDF0A3114FBC92AA76_2099160294 = (super.onTouchEvent(event));
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2048935155 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2048935155;
        
        
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.087 -0400", hash_original_method = "56250C7379795A076A294BCEF2D5FD2C", hash_generated_method = "3E4590D916BD0C52ECC692DDEE5BE184")
    private boolean isOutOfBounds(View v, MotionEvent event) {
        final int x = (int) event.getX();
        final int y = (int) event.getY();
        final int slop = ViewConfiguration.get(mContext).getScaledWindowTouchSlop();
        boolean varF1323CBC1C1BDF62B7AAA2E8EBAA7C86_1091749930 = ((x < -slop) || (y < -slop)
                || (x > (v.getWidth()+slop))
                || (y > (v.getHeight()+slop)));
        addTaint(v.getTaint());
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1669590701 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1669590701;
        
        
        
        
        
                
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.087 -0400", hash_original_method = "6ED6F897B7566B2172AD538A3B9EBF5C", hash_generated_method = "87827FF14058DA01BAB141A9DF01FCCA")
    @Override
    public void hide() {
        {
            boolean var67F0F8A90F47989DCF9FDFD2C3F61D76_1869677692 = (!isShowing());
        } 
        InputMethodManager imm = (InputMethodManager)getContext()
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        {
            imm.hideSoftInputFromWindow(
                    getWindow().getDecorView().getWindowToken(), 0);
        } 
        super.hide();
        
        
        
                
        
            
                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.088 -0400", hash_original_method = "A776EE9CD94492AC9830F6D90123EF80", hash_generated_method = "1F96E398546D6644A16C0EB6DC477101")
    public void launchQuerySearch() {
        launchQuerySearch(KeyEvent.KEYCODE_UNKNOWN, null);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.088 -0400", hash_original_method = "8DA1240BCB0B1358D88E8B5A3BC94CC9", hash_generated_method = "7ED2081DD6313C0BE10DE11C5CC76134")
    protected void launchQuerySearch(int actionKey, String actionMsg) {
        String query = mSearchAutoComplete.getText().toString();
        String action = Intent.ACTION_SEARCH;
        Intent intent = createIntent(action, null, null, query, actionKey, actionMsg);
        launchIntent(intent);
        addTaint(actionKey);
        addTaint(actionMsg.getTaint());
        
        
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.089 -0400", hash_original_method = "BC4CCAAD8BAD8DFDC06067A6480767AA", hash_generated_method = "C653AA31586676AF5C9F3A77ABDFB483")
    private void launchIntent(Intent intent) {
        Log.d(LOG_TAG, "launching " + intent);
        try 
        {
            getContext().startActivity(intent);
            dismiss();
        } 
        catch (RuntimeException ex)
        { }
        addTaint(intent.getTaint());
        
        
            
        
        
        
            
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.089 -0400", hash_original_method = "A7D428EF1EDEF778DF6A68394BD0B0D0", hash_generated_method = "E80AE8EAA8FB112504D4E6DC33B9E369")
    public void setListSelection(int index) {
        mSearchAutoComplete.setListSelection(index);
        addTaint(index);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.091 -0400", hash_original_method = "7931502AE551A2F220A0C85C1181EB09", hash_generated_method = "2B2EAD44BB1540733EFEA0F87CA52E5E")
    private Intent createIntent(String action, Uri data, String extraData, String query,
            int actionKey, String actionMsg) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_142915675 = null; 
        Intent intent = new Intent(action);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        {
            intent.setData(data);
        } 
        intent.putExtra(SearchManager.USER_QUERY, mUserQuery);
        {
            intent.putExtra(SearchManager.QUERY, query);
        } 
        {
            intent.putExtra(SearchManager.EXTRA_DATA_KEY, extraData);
        } 
        {
            intent.putExtra(SearchManager.APP_DATA, mAppSearchData);
        } 
        {
            intent.putExtra(SearchManager.ACTION_KEY, actionKey);
            intent.putExtra(SearchManager.ACTION_MSG, actionMsg);
        } 
        intent.setComponent(mSearchable.getSearchActivity());
        varB4EAC82CA7396A68D541C85D26508E83_142915675 = intent;
        addTaint(action.getTaint());
        addTaint(data.getTaint());
        addTaint(extraData.getTaint());
        addTaint(query.getTaint());
        addTaint(actionKey);
        addTaint(actionMsg.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_142915675.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_142915675;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.093 -0400", hash_original_method = "F1F42C772C06A28CE3769310F1841510", hash_generated_method = "3307A8B6B77AD17AE76883DA27E217D3")
    private boolean isEmpty(AutoCompleteTextView actv) {
        boolean varA00CA6A03B7729E39BB9012B388B84AE_2062431965 = (TextUtils.getTrimmedLength(actv.getText()) == 0);
        addTaint(actv.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1672246636 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1672246636;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.094 -0400", hash_original_method = "85C012DD8E7654DEDC3FCC35E518B3D4", hash_generated_method = "CB00CF3CFE476CFDCAAFFC3820100AE3")
    @Override
    public void onBackPressed() {
        
        InputMethodManager imm = (InputMethodManager)getContext()
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        {
            boolean var923BEF24B2989F56B9B96F77869010FA_1877010128 = (imm != null && imm.isFullscreenMode() &&
                imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0));
        } 
        cancel();
        
        
                
        
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.095 -0400", hash_original_method = "D537924252E5FBECE100B51E4DF20EDD", hash_generated_method = "5CBC1B90BBF88891D75A7664B1B53274")
    private boolean onClosePressed() {
        {
            boolean var64E470953DFC6D121014C23115412BF9_124970761 = (isEmpty(mSearchAutoComplete));
            {
                dismiss();
            } 
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1386712264 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1386712264;
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.095 -0400", hash_original_method = "AC61287D1F4BDFB9C05737508F4ABB90", hash_generated_method = "B9DB14128A168275D10CD265AE58A20D")
    private void setUserQuery(String query) {
        {
            query = "";
        } 
        mUserQuery = query;
        mSearchAutoComplete.setText(query);
        mSearchAutoComplete.setSelection(query.length());
        
        
            
        
        
        
        
    }

    
    public static class SearchBar extends LinearLayout {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.096 -0400", hash_original_field = "07AB93C86DCF2727B3D7686803B97F37", hash_generated_field = "247F9D3B324680CEDDC332FCA6608926")

        private SearchDialog mSearchDialog;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.096 -0400", hash_original_method = "A3B6592F51A27BFA7A85197EDA145FFE", hash_generated_method = "DBF76B98CB9968EA9594F2785A3B3866")
        public  SearchBar(Context context, AttributeSet attrs) {
            super(context, attrs);
            addTaint(context.getTaint());
            addTaint(attrs.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.096 -0400", hash_original_method = "4392E8B38D4E47AAE679D125E8E4B6FF", hash_generated_method = "4BE2592B34D38C3F6B65AC2EB8AA305A")
        public  SearchBar(Context context) {
            super(context);
            addTaint(context.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.097 -0400", hash_original_method = "7E3A3D5A1CCC1779F8492CDCF581870E", hash_generated_method = "723912D2FF4CFA7FED8D56FF3CC86130")
        public void setSearchDialog(SearchDialog searchDialog) {
            mSearchDialog = searchDialog;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.098 -0400", hash_original_method = "195483BC208A3A4410E3220FCA03E982", hash_generated_method = "D10A3387198C355074E0B66A3813B222")
        @Override
        public ActionMode startActionModeForChild(View child, ActionMode.Callback callback) {
            ActionMode varB4EAC82CA7396A68D541C85D26508E83_826203704 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_826203704 = null;
            addTaint(child.getTaint());
            addTaint(callback.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_826203704.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_826203704;
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.098 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.099 -0400", hash_original_field = "80188998735D6BE6103CE15F0AD5FAB6", hash_generated_field = "2108E8D2E82C8F5E3CDA71B7634FCAF0")

    private static final String LOG_TAG = "SearchDialog";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.099 -0400", hash_original_field = "5ECE9C8FE4EF49C0CAFCE503C1625BCF", hash_generated_field = "32263DEC0FC7AEC057254F1EE9768AC4")

    private static final String INSTANCE_KEY_COMPONENT = "comp";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.099 -0400", hash_original_field = "6AA4A9ADD537EC6FB2B42C71CA57CA90", hash_generated_field = "1FBAB201C0ABBCB1FC1817DA78FCEDB5")

    private static final String INSTANCE_KEY_APPDATA = "data";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.099 -0400", hash_original_field = "248A8417FD38990B808C89A094A7C7E8", hash_generated_field = "A1E0FBB48DCD1FE95C7FA9374B53A700")

    private static final String INSTANCE_KEY_USER_QUERY = "uQry";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.099 -0400", hash_original_field = "B8CF89EB7E6552EBC5C9FCBB33074205", hash_generated_field = "7875B207C54E2B6D5ABF1652FFF3F22A")

    private static final String IME_OPTION_NO_MICROPHONE = "nm";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.099 -0400", hash_original_field = "45F7847F1D1C07D089FC78D632C27ECD", hash_generated_field = "4DA3BCE289680CAD95CE7D774B9BCB53")

    private static final int SEARCH_PLATE_LEFT_PADDING_NON_GLOBAL = 7;
}

