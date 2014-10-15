package android.app;

// Droidsafe Imports
import com.android.internal.view.menu.MenuBuilder;

import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.ActionMode.SimpleActionMode;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;

public class SearchDialog extends Dialog {

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:20.709 -0500", hash_original_method = "56A848B4C6D8FA4A2680FE0AB0EEBE05", hash_generated_method = "4DCAA74AAF032E5CA9A8B8B2BE8B8E72")
    
static int resolveDialogTheme(Context context) {
        TypedValue outValue = new TypedValue();
        context.getTheme().resolveAttribute(com.android.internal.R.attr.searchDialogTheme,
                outValue, true);
        return outValue.resourceId;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:20.767 -0500", hash_original_method = "1515F3198E379060DCB8EFB4F4DD3EF3", hash_generated_method = "068CF4650A3DEA4B1C4E446DD99717AD")
    
static boolean isLandscapeMode(Context context) {
        return context.getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_LANDSCAPE;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:20.619 -0500", hash_original_field = "B2601CA7445F6BA19FA7884763D82281", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:20.623 -0500", hash_original_field = "1B1E75BA545E86D75599F3311460C67E", hash_generated_field = "2108E8D2E82C8F5E3CDA71B7634FCAF0")

    private static final String LOG_TAG = "SearchDialog";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:20.626 -0500", hash_original_field = "AA15E2171E6B8E02519B80CD96C95ADA", hash_generated_field = "32263DEC0FC7AEC057254F1EE9768AC4")

    private static final String INSTANCE_KEY_COMPONENT = "comp";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:20.631 -0500", hash_original_field = "C3F3ABE2A252746724A84BA8C4092AB9", hash_generated_field = "1FBAB201C0ABBCB1FC1817DA78FCEDB5")

    private static final String INSTANCE_KEY_APPDATA = "data";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:20.636 -0500", hash_original_field = "F9AFBC9CB78F719DFA20B91D7713213D", hash_generated_field = "A1E0FBB48DCD1FE95C7FA9374B53A700")

    private static final String INSTANCE_KEY_USER_QUERY = "uQry";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:20.640 -0500", hash_original_field = "C4734236EF81A78AAB39B6B639767E8D", hash_generated_field = "52DD75F87AA806868D2378F3E786EA24")

    // a microphone button since one already exists in the search dialog.
    private static final String IME_OPTION_NO_MICROPHONE = "nm";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:20.644 -0500", hash_original_field = "B06E2FDE831865FCE5B95733E1B81D43", hash_generated_field = "4DA3BCE289680CAD95CE7D774B9BCB53")

    private static final int SEARCH_PLATE_LEFT_PADDING_NON_GLOBAL = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:20.647 -0500", hash_original_field = "CF7A163C9C546A0CDC5A7AB00BB1810C", hash_generated_field = "1106A4E8A92B8ECB3AB388E40AAD60FA")

    private TextView mBadgeLabel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:20.651 -0500", hash_original_field = "402C9351A621B0DA49A9F26021F70C61", hash_generated_field = "AA62E658C5FFF9798AE22B318F3E352B")

    private ImageView mAppIcon;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:20.654 -0500", hash_original_field = "D1AFBC3908B905B50CA603BF94540202", hash_generated_field = "D28C2E2316A6D4BCBB3634EE05B8CBED")

    private AutoCompleteTextView mSearchAutoComplete;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:20.658 -0500", hash_original_field = "7E4809667357258106E5CE84F733E49D", hash_generated_field = "BFE96959B9AF28F7C0E58BC61493C3DB")

    private View mSearchPlate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:20.662 -0500", hash_original_field = "60229949E2319A4FB0EE2E6EFEBE4F16", hash_generated_field = "1366187FE3CF01EF5FC13B6B4154C3DB")

    private SearchView mSearchView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:20.665 -0500", hash_original_field = "0C6A1E530A1E3111FAE73539D55531F8", hash_generated_field = "DD5A2D50F6C0D0417755EF4A026A680F")

    private Drawable mWorkingSpinner;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:20.669 -0500", hash_original_field = "D5EEBE68A095ECC87C9EC314D80339B2", hash_generated_field = "C06E0E7D1467D7FE8A6F8A71C4DF5424")

    private View mCloseSearch;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:20.672 -0500", hash_original_field = "48D170239934FB4D79AA195112CE1340", hash_generated_field = "6F1511307A7DE5E4BDCE1D082D25D113")

    private SearchableInfo mSearchable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:20.676 -0500", hash_original_field = "70BA183DC56B3DB74D30314EE130C23B", hash_generated_field = "50EEF416470C835B6507F85F77B6005A")

    private ComponentName mLaunchComponent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:20.679 -0500", hash_original_field = "15421EAEB4E151ECA9251D997F5C011B", hash_generated_field = "59F218E5E058390715FC276BA2A49292")

    private Bundle mAppSearchData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:20.682 -0500", hash_original_field = "81ACE726544598459CF1FC2D0025FEEE", hash_generated_field = "830673ADBDEDB8A3B6CE8ACC5E0E51D6")

    private Context mActivityContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:20.686 -0500", hash_original_field = "E4F65C89D480286574889D20EDDB2F1E", hash_generated_field = "72504DA1E4071FF872DD4C2D7A26922B")

    private  Intent mVoiceWebSearchIntent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:20.690 -0500", hash_original_field = "349320321140031AC947D7B95CC99F5A", hash_generated_field = "FEBA65D5D58AD1CB3F0ABB729B735300")

    private  Intent mVoiceAppSearchIntent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:20.694 -0500", hash_original_field = "93A1E954F4AF7050A1020B5586E82D15", hash_generated_field = "701084B97FFBFD9CDBE1D2FE996B145E")

    // that modifies the contents of the text field. But if the user then edits
    // the suggestion, the resulting string is saved.
    private String mUserQuery;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:20.697 -0500", hash_original_field = "246CEFB508C41CC7255AA85AF244874C", hash_generated_field = "AB035B7E16E303E650083D3FC6117294")

    private int mSearchAutoCompleteImeOptions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.068 -0400", hash_original_field = "4C8632D0626D11A25D8014E79CAA4E06", hash_generated_field = "078A814FD4991378BDB28FB48F12B0ED")

    private BroadcastReceiver mConfChangeListener = new BroadcastReceiver() {
        
        @DSSafe(DSCat.SAFE_LIST)
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

    /**
     * Constructor - fires it up and makes it look like the search UI.
     * 
     * @param context Application Context we can use for system acess
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:20.714 -0500", hash_original_method = "F1210797C1F332443A604D5C626C1E55", hash_generated_method = "4768C04CB3C76A7F69DA8E7F1B8D0D0B")
    
public SearchDialog(Context context, SearchManager searchManager) {
        super(context, resolveDialogTheme(context));

        // Save voice intent for later queries/launching
        mVoiceWebSearchIntent = new Intent(RecognizerIntent.ACTION_WEB_SEARCH);
        mVoiceWebSearchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mVoiceWebSearchIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_WEB_SEARCH);

        mVoiceAppSearchIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        mVoiceAppSearchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    }

    /**
     * Create the search dialog and any resources that are used for the
     * entire lifetime of the dialog.
     */
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:20.718 -0500", hash_original_method = "ADA44CDEEADE302052A002E44C1889B1", hash_generated_method = "25E987B9FCED8843878CDCB6E5ABFF02")
    
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Window theWindow = getWindow();
        WindowManager.LayoutParams lp = theWindow.getAttributes();
        lp.width = ViewGroup.LayoutParams.MATCH_PARENT;
        // taking up the whole window (even when transparent) is less than ideal,
        // but necessary to show the popup window until the window manager supports
        // having windows anchored by their parent but not clipped by them.
        lp.height = ViewGroup.LayoutParams.MATCH_PARENT;
        lp.gravity = Gravity.TOP | Gravity.FILL_HORIZONTAL;
        lp.softInputMode = WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE;
        theWindow.setAttributes(lp);

        // Touching outside of the search dialog will dismiss it
        setCanceledOnTouchOutside(true);        
    }

    /**
     * We recreate the dialog view each time it becomes visible so as to limit
     * the scope of any problems with the contained resources.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:20.728 -0500", hash_original_method = "464C4B41AE1C07D5D4F71BE590B5445C", hash_generated_method = "74355882FD6A841EAE7513E54F7BC48C")
    
private void createContentView() {
        setContentView(com.android.internal.R.layout.search_bar);

        // get the view elements for local access
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
            @DSSafe(DSCat.SAFE_LIST)
        @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        // TODO: Move the badge logic to SearchView or move the badge to search_bar.xml
        mBadgeLabel = (TextView) mSearchView.findViewById(com.android.internal.R.id.search_badge);
        mSearchAutoComplete = (AutoCompleteTextView)
                mSearchView.findViewById(com.android.internal.R.id.search_src_text);
        mAppIcon = (ImageView) findViewById(com.android.internal.R.id.search_app_icon);
        mSearchPlate = mSearchView.findViewById(com.android.internal.R.id.search_plate);
        mWorkingSpinner = getContext().getResources().
                getDrawable(com.android.internal.R.drawable.search_spinner);
        // TODO: Restore the spinner for slow suggestion lookups
        // mSearchAutoComplete.setCompoundDrawablesWithIntrinsicBounds(
        //        null, null, mWorkingSpinner, null);
        setWorking(false);

        // pre-hide all the extraneous elements
        mBadgeLabel.setVisibility(View.GONE);

        // Additional adjustments to make Dialog work for Search
        mSearchAutoCompleteImeOptions = mSearchAutoComplete.getImeOptions();
    }

    /**
     * Set up the search dialog
     * 
     * @return true if search dialog launched, false if not
     */
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:20.732 -0500", hash_original_method = "08D03C59DE669D3068C0B765E743FE8E", hash_generated_method = "508A411C3534EE152489F1C3E4C79E3A")
    
public boolean show(String initialQuery, boolean selectInitialQuery,
            ComponentName componentName, Bundle appSearchData) {
        boolean success = doShow(initialQuery, selectInitialQuery, componentName, appSearchData);
        if (success) {
            // Display the drop down as soon as possible instead of waiting for the rest of the
            // pending UI stuff to get done, so that things appear faster to the user.
            mSearchAutoComplete.showDropDownAfterLayout();
        }
        return success;
    }

    /**
     * Does the rest of the work required to show the search dialog. Called by
     * {@link #show(String, boolean, ComponentName, Bundle)} and
     *
     * @return true if search dialog showed, false if not
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:20.736 -0500", hash_original_method = "EAE1B7BC7DC4BF1770F63B02B1B868E2", hash_generated_method = "CA67D5AB382401DC9B5ACA8D75E80D1B")
    
private boolean doShow(String initialQuery, boolean selectInitialQuery,
            ComponentName componentName, Bundle appSearchData) {
        // set up the searchable and show the dialog
        if (!show(componentName, appSearchData)) {
            return false;
        }

        // finally, load the user's initial text (which may trigger suggestions)
        setUserQuery(initialQuery);
        if (selectInitialQuery) {
            mSearchAutoComplete.selectAll();
        }

        return true;
    }

    /**
     * Sets up the search dialog and shows it.
     * 
     * @return <code>true</code> if search dialog launched
     */
    @DSComment("Private Method")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:20.741 -0500", hash_original_method = "705B52B556BB75FCC3E8159D4BF0A627", hash_generated_method = "76440539B87D735A9490277AF70C6969")
    
private boolean show(ComponentName componentName, Bundle appSearchData) {
        
        if (DBG) { 
            Log.d(LOG_TAG, "show(" + componentName + ", " 
                    + appSearchData + ")");
        }
        
        SearchManager searchManager = (SearchManager)
                mContext.getSystemService(Context.SEARCH_SERVICE);
        // Try to get the searchable info for the provided component.
        mSearchable = searchManager.getSearchableInfo(componentName);

        if (mSearchable == null) {
            return false;
        }

        mLaunchComponent = componentName;
        mAppSearchData = appSearchData;
        mActivityContext = mSearchable.getActivityContext(getContext());

        // show the dialog. this will call onStart().
        if (!isShowing()) {
            // Recreate the search bar view every time the dialog is shown, to get rid
            // of any bad state in the AutoCompleteTextView etc
            createContentView();
            mSearchView.setSearchableInfo(mSearchable);
            mSearchView.setAppSearchData(mAppSearchData);

            show();
        }
        updateUI();

        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:20.744 -0500", hash_original_method = "57C4DE658D3F4A02662686A9CE61B2E8", hash_generated_method = "CBA264CC57569CAC1DDC30142E94BD59")
    
@Override
    public void onStart() {
        super.onStart();

        // Register a listener for configuration change events.
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_CONFIGURATION_CHANGED);
        getContext().registerReceiver(mConfChangeListener, filter);
    }

    /**
     * The search dialog is being dismissed, so handle all of the local shutdown operations.
     * 
     * This function is designed to be idempotent so that dismiss() can be safely called at any time
     * (even if already closed) and more likely to really dump any memory.  No leaks!
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:20.748 -0500", hash_original_method = "6050D9FBC779B270404C43A7E853C1E6", hash_generated_method = "378352F37398678C80BFD1E7AD99170C")
    
@Override
    public void onStop() {
        super.onStop();

        getContext().unregisterReceiver(mConfChangeListener);

        // dump extra memory we're hanging on to
        mLaunchComponent = null;
        mAppSearchData = null;
        mSearchable = null;
        mUserQuery = null;
    }

    /**
     * Sets the search dialog to the 'working' state, which shows a working spinner in the
     * right hand size of the text field.
     * 
     * @param working true to show spinner, false to hide spinner
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:20.752 -0500", hash_original_method = "25F8B16486236BF1FAF351BB43EBD4A7", hash_generated_method = "46D7396215703DE3106C4959C01FD235")
    
public void setWorking(boolean working) {
        mWorkingSpinner.setAlpha(working ? 255 : 0);
        mWorkingSpinner.setVisible(working, false);
        mWorkingSpinner.invalidateSelf();
    }

    /**
     * Save the minimal set of data necessary to recreate the search
     * 
     * @return A bundle with the state of the dialog, or {@code null} if the search
     *         dialog is not showing.
     */
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:20.756 -0500", hash_original_method = "A93DBE942737D1F537AD057E006AED8C", hash_generated_method = "870783D19F6594D1C034646EFDF474AF")
    
@Override
    public Bundle onSaveInstanceState() {
        if (!isShowing()) return null;

        Bundle bundle = new Bundle();

        // setup info so I can recreate this particular search       
        bundle.putParcelable(INSTANCE_KEY_COMPONENT, mLaunchComponent);
        bundle.putBundle(INSTANCE_KEY_APPDATA, mAppSearchData);
        bundle.putString(INSTANCE_KEY_USER_QUERY, mUserQuery);

        return bundle;
    }

    /**
     * Restore the state of the dialog from a previously saved bundle.
     * 
     * @param savedInstanceState The state of the dialog previously saved by
     *     {@link #onSaveInstanceState()}.
     */
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:20.760 -0500", hash_original_method = "D7088D676BF54E193C8B7B9D0CD3713D", hash_generated_method = "0B6A4B44261B665077F6F492F3949A3B")
    
@Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState == null) return;

        ComponentName launchComponent = savedInstanceState.getParcelable(INSTANCE_KEY_COMPONENT);
        Bundle appSearchData = savedInstanceState.getBundle(INSTANCE_KEY_APPDATA);
        String userQuery = savedInstanceState.getString(INSTANCE_KEY_USER_QUERY);

        // show the dialog.
        if (!doShow(userQuery, false, launchComponent, appSearchData)) {
            // for some reason, we couldn't re-instantiate
            return;
        }
    }

    /**
     * Called after resources have changed, e.g. after screen rotation or locale change.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:20.763 -0500", hash_original_method = "D7D85FA93E7D9B21BC4DF3FC01DC78AB", hash_generated_method = "E3B6A5C43B6350A40B1B7DA5C9BB591E")
    
public void onConfigurationChanged() {
        if (mSearchable != null && isShowing()) {
            // Redraw (resources may have changed)
            updateSearchAppIcon();
            updateSearchBadge();
            if (isLandscapeMode(getContext())) {
                mSearchAutoComplete.ensureImeVisible(true);
            }
        }
    }

    /**
     * Update the UI according to the info in the current value of {@link #mSearchable}.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:20.771 -0500", hash_original_method = "BEA9325A3466C1690A3F58B8B49BC62D", hash_generated_method = "AEBA2470C71BF29E47286BD3D8496A4F")
    
private void updateUI() {
        if (mSearchable != null) {
            mDecor.setVisibility(View.VISIBLE);
            updateSearchAutoComplete();
            updateSearchAppIcon();
            updateSearchBadge();
            
            // In order to properly configure the input method (if one is being used), we
            // need to let it know if we'll be providing suggestions.  Although it would be
            // difficult/expensive to know if every last detail has been configured properly, we 
            // can at least see if a suggestions provider has been configured, and use that
            // as our trigger.
            int inputType = mSearchable.getInputType();
            // We only touch this if the input type is set up for text (which it almost certainly
            // should be, in the case of search!)
            if ((inputType & InputType.TYPE_MASK_CLASS) == InputType.TYPE_CLASS_TEXT) {
                // The existence of a suggestions authority is the proxy for "suggestions 
                // are available here"
                inputType &= ~InputType.TYPE_TEXT_FLAG_AUTO_COMPLETE;
                if (mSearchable.getSuggestAuthority() != null) {
                    inputType |= InputType.TYPE_TEXT_FLAG_AUTO_COMPLETE;
                }
            }
            mSearchAutoComplete.setInputType(inputType);
            mSearchAutoCompleteImeOptions = mSearchable.getImeOptions();
            mSearchAutoComplete.setImeOptions(mSearchAutoCompleteImeOptions);
            
            // If the search dialog is going to show a voice search button, then don't let
            // the soft keyboard display a microphone button if it would have otherwise.
            if (mSearchable.getVoiceSearchEnabled()) {
                mSearchAutoComplete.setPrivateImeOptions(IME_OPTION_NO_MICROPHONE);
            } else {
                mSearchAutoComplete.setPrivateImeOptions(null);
            }
        }
    }
    
    /**
     * Updates the auto-complete text view.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:20.776 -0500", hash_original_method = "7645C33AE0588436620AE83A499D7C08", hash_generated_method = "9D697A0850F600422BCC7570C91E7256")
    
private void updateSearchAutoComplete() {
        // we dismiss the entire dialog instead
        mSearchAutoComplete.setDropDownDismissedOnCompletion(false);
        mSearchAutoComplete.setForceIgnoreOutsideTouch(false);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:20.780 -0500", hash_original_method = "E83CA9B0957C02D3E99E874CE94E4E80", hash_generated_method = "7112B892137F2B886F605260B79F93DF")
    
private void updateSearchAppIcon() {
        PackageManager pm = getContext().getPackageManager();
        Drawable icon;
        try {
            ActivityInfo info = pm.getActivityInfo(mLaunchComponent, 0);
            icon = pm.getApplicationIcon(info.applicationInfo);
            if (DBG)
                Log.d(LOG_TAG, "Using app-specific icon");
        } catch (NameNotFoundException e) {
            icon = pm.getDefaultActivityIcon();
            Log.w(LOG_TAG, mLaunchComponent + " not found, using generic app icon");
        }
        mAppIcon.setImageDrawable(icon);
        mAppIcon.setVisibility(View.VISIBLE);
        mSearchPlate.setPadding(SEARCH_PLATE_LEFT_PADDING_NON_GLOBAL, mSearchPlate.getPaddingTop(), mSearchPlate.getPaddingRight(), mSearchPlate.getPaddingBottom());
    }

    /**
     * Setup the search "Badge" if requested by mode flags.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:20.784 -0500", hash_original_method = "306E7BCD0818ADE89EBA434EE06262F7", hash_generated_method = "B80DE44C36094CCD8F7BFB6AC88EC24C")
    
private void updateSearchBadge() {
        // assume both hidden
        int visibility = View.GONE;
        Drawable icon = null;
        CharSequence text = null;

        // optionally show one or the other.
        if (mSearchable.useBadgeIcon()) {
            icon = mActivityContext.getResources().getDrawable(mSearchable.getIconId());
            visibility = View.VISIBLE;
            if (DBG) Log.d(LOG_TAG, "Using badge icon: " + mSearchable.getIconId());
        } else if (mSearchable.useBadgeLabel()) {
            text = mActivityContext.getResources().getText(mSearchable.getLabelId()).toString();
            visibility = View.VISIBLE;
            if (DBG) Log.d(LOG_TAG, "Using badge label: " + mSearchable.getLabelId());
        }

        mBadgeLabel.setCompoundDrawablesWithIntrinsicBounds(icon, null, null, null);
        mBadgeLabel.setText(text);
        mBadgeLabel.setVisibility(visibility);
    }

    /*
     * Listeners of various types
     */

    /**
     * {@link Dialog#onTouchEvent(MotionEvent)} will cancel the dialog only when the
     * touch is outside the window. But the window includes space for the drop-down,
     * so we also cancel on taps outside the search bar when the drop-down is not showing.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:20.788 -0500", hash_original_method = "0D9DE884F4C3EB514898202D906CFD1D", hash_generated_method = "E84E69EC3AB56FE0D91606C242DF048D")
    
@Override
    public boolean onTouchEvent(MotionEvent event) {
        // cancel if the drop-down is not showing and the touch event was outside the search plate
        if (!mSearchAutoComplete.isPopupShowing() && isOutOfBounds(mSearchPlate, event)) {
            if (DBG) Log.d(LOG_TAG, "Pop-up not showing and outside of search plate.");
            cancel();
            return true;
        }
        // Let Dialog handle events outside the window while the pop-up is showing.
        return super.onTouchEvent(event);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:20.792 -0500", hash_original_method = "56250C7379795A076A294BCEF2D5FD2C", hash_generated_method = "BA8552B008E20F0400287BEBB9724F3F")
    
private boolean isOutOfBounds(View v, MotionEvent event) {
        final int x = (int) event.getX();
        final int y = (int) event.getY();
        final int slop = ViewConfiguration.get(mContext).getScaledWindowTouchSlop();
        return (((x + y + slop + v.getWidth() + v.getHeight())) == 1);
    }

    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:20.796 -0500", hash_original_method = "6ED6F897B7566B2172AD538A3B9EBF5C", hash_generated_method = "53ECED5597F031D7F8622916BBFFF475")
    
@Override
    public void hide() {
        if (!isShowing()) return;

        // We made sure the IME was displayed, so also make sure it is closed
        // when we go away.
        InputMethodManager imm = (InputMethodManager)getContext()
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(
                    getWindow().getDecorView().getWindowToken(), 0);
        }

        super.hide();
    }
    
    /**
     * Launch a search for the text in the query text field.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:20.799 -0500", hash_original_method = "A776EE9CD94492AC9830F6D90123EF80", hash_generated_method = "4AF9EA9654FEF9F99B4CC125624506F1")
    
public void launchQuerySearch() {
        launchQuerySearch(KeyEvent.KEYCODE_UNKNOWN, null);
    }

    /**
     * Launch a search for the text in the query text field.
     *
     * @param actionKey The key code of the action key that was pressed,
     *        or {@link KeyEvent#KEYCODE_UNKNOWN} if none.
     * @param actionMsg The message for the action key that was pressed,
     *        or <code>null</code> if none.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:20.802 -0500", hash_original_method = "8DA1240BCB0B1358D88E8B5A3BC94CC9", hash_generated_method = "3393F4228B7567012C52A4075D51057C")
    
protected void launchQuerySearch(int actionKey, String actionMsg) {
        String query = mSearchAutoComplete.getText().toString();
        String action = Intent.ACTION_SEARCH;
        Intent intent = createIntent(action, null, null, query, actionKey, actionMsg);
        launchIntent(intent);
    }
    
    public static class SearchBar extends LinearLayout {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:20.819 -0500", hash_original_field = "B93D728F11520F5ED9A8F4EC523DF611", hash_generated_field = "247F9D3B324680CEDDC332FCA6608926")

        private SearchDialog mSearchDialog;

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:20.824 -0500", hash_original_method = "A3B6592F51A27BFA7A85197EDA145FFE", hash_generated_method = "3C08E8235D3A7A15A58812D345A0FCBC")
        
public SearchBar(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:20.828 -0500", hash_original_method = "4392E8B38D4E47AAE679D125E8E4B6FF", hash_generated_method = "D487A1EB20E53F9AFBF66DD2A72E0818")
        
public SearchBar(Context context) {
            super(context);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:20.831 -0500", hash_original_method = "7E3A3D5A1CCC1779F8492CDCF581870E", hash_generated_method = "CF0D3DDF98996ADD8B2510D81BB49B89")
        
public void setSearchDialog(SearchDialog searchDialog) {
            mSearchDialog = searchDialog;
        }

        /**
         * Don't allow action modes in a SearchBar, it looks silly.
         */
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:20.835 -0500", hash_original_method = "195483BC208A3A4410E3220FCA03E982", hash_generated_method = "7FF36BEFF752FC78BA0E798F3C85A766")
        
@Override
        public ActionMode startActionModeForChild(View child, ActionMode.Callback callback) {
            if (callback  != null) {
                //callback.onCreateActionMode(mode, menu)
                MenuBuilder builder = new MenuBuilder(mSearchDialog.mActivityContext);
            //technically we should use the menu from external source
                Menu menu = builder.addSubMenu(DSUtils.FAKE_INT);
                MenuItem menuItem = menu.add(DSUtils.FAKE_INT);
                ActionMode mode = new ActionMode.SimpleActionMode();
                callback.onCreateActionMode(mode, menu);
                callback.onPrepareActionMode(mode, menu);
                callback.onActionItemClicked(mode, menuItem);  
                callback.onDestroyActionMode(mode);
            }
            return null;
        }
        
    }

    /**
     * Launches an intent, including any special intent handling.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:20.806 -0500", hash_original_method = "BC4CCAAD8BAD8DFDC06067A6480767AA", hash_generated_method = "70C567FF99FB51F3FA5DED8971A59CEA")
    
private void launchIntent(Intent intent) {
        if (intent == null) {
            return;
        }
        Log.d(LOG_TAG, "launching " + intent);
        try {
            // If the intent was created from a suggestion, it will always have an explicit
            // component here.
            Log.i(LOG_TAG, "Starting (as ourselves) " + intent.toUri(0));
            getContext().startActivity(intent);
            // If the search switches to a different activity,
            // SearchDialogWrapper#performActivityResuming
            // will handle hiding the dialog when the next activity starts, but for
            // real in-app search, we still need to dismiss the dialog.
            dismiss();
        } catch (RuntimeException ex) {
            Log.e(LOG_TAG, "Failed launch activity: " + intent, ex);
        }
    }

    /**
     * Sets the list item selection in the AutoCompleteTextView's ListView.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:20.810 -0500", hash_original_method = "A7D428EF1EDEF778DF6A68394BD0B0D0", hash_generated_method = "E9D1A5A5D96575CA1EA78178C89B0FAA")
    
public void setListSelection(int index) {
        mSearchAutoComplete.setListSelection(index);
    }

    /**
     * Constructs an intent from the given information and the search dialog state.
     * 
     * @param action Intent action.
     * @param data Intent data, or <code>null</code>.
     * @param extraData Data for {@link SearchManager#EXTRA_DATA_KEY} or <code>null</code>.
     * @param query Intent query, or <code>null</code>.
     * @param actionKey The key code of the action key that was pressed,
     *        or {@link KeyEvent#KEYCODE_UNKNOWN} if none.
     * @param actionMsg The message for the action key that was pressed,
     *        or <code>null</code> if none.
     * @param mode The search mode, one of the acceptable values for
     *             {@link SearchManager#SEARCH_MODE}, or {@code null}.
     * @return The intent.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:20.815 -0500", hash_original_method = "7931502AE551A2F220A0C85C1181EB09", hash_generated_method = "1F0A50D12F3AF83BCB8DD4F3AC55A247")
    
private Intent createIntent(String action, Uri data, String extraData, String query,
            int actionKey, String actionMsg) {
        // Now build the Intent
        Intent intent = new Intent(action);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        // We need CLEAR_TOP to avoid reusing an old task that has other activities
        // on top of the one we want. We don't want to do this in in-app search though,
        // as it can be destructive to the activity stack.
        if (data != null) {
            intent.setData(data);
        }
        intent.putExtra(SearchManager.USER_QUERY, mUserQuery);
        if (query != null) {
            intent.putExtra(SearchManager.QUERY, query);
        }
        if (extraData != null) {
            intent.putExtra(SearchManager.EXTRA_DATA_KEY, extraData);
        }
        if (mAppSearchData != null) {
            intent.putExtra(SearchManager.APP_DATA, mAppSearchData);
        }
        if (actionKey != KeyEvent.KEYCODE_UNKNOWN) {
            intent.putExtra(SearchManager.ACTION_KEY, actionKey);
            intent.putExtra(SearchManager.ACTION_MSG, actionMsg);
        }
        intent.setComponent(mSearchable.getSearchActivity());
        return intent;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:20.841 -0500", hash_original_method = "F1F42C772C06A28CE3769310F1841510", hash_generated_method = "F787CA429662AB1A9B883868F90AEB8B")
    
private boolean isEmpty(AutoCompleteTextView actv) {
        return 1 == (TextUtils.getTrimmedLength(actv.getText())); 
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:20.844 -0500", hash_original_method = "85C012DD8E7654DEDC3FCC35E518B3D4", hash_generated_method = "6B0AB955F4D93B7616DA539A73AA7B05")
    
@Override
    public void onBackPressed() {
        // If the input method is covering the search dialog completely,
        // e.g. in landscape mode with no hard keyboard, dismiss just the input method
        InputMethodManager imm = (InputMethodManager)getContext()
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null && imm.isFullscreenMode() &&
                imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0)) {
            return;
        }
        // Close search dialog
        cancel();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:20.848 -0500", hash_original_method = "D537924252E5FBECE100B51E4DF20EDD", hash_generated_method = "4440127D4F7F8E99505708E804A9A040")
    
private boolean onClosePressed() {
        // Dismiss the dialog if close button is pressed when there's no query text
        if (isEmpty(mSearchAutoComplete)) {
            dismiss();
            return true;
        }

        return false;
    }

    /**
     * Sets the text in the query box, updating the suggestions.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:20.872 -0500", hash_original_method = "AC61287D1F4BDFB9C05737508F4ABB90", hash_generated_method = "51609A548F387EDA2014CA6A38CC5A57")
    
private void setUserQuery(String query) {
        if (query == null) {
            query = "";
        }
        mUserQuery = query;
        mSearchAutoComplete.setText(query);
        mSearchAutoComplete.setSelection(query.length());
    }
}

