package android.preference;

// Droidsafe Imports
import droidsafe.annotations.*;
import droidsafe.helpers.*;

import droidsafe.runtime.*;
import android.app.Fragment;
import android.app.FragmentBreadCrumbs;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.android.internal.util.XmlUtils;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class PreferenceActivity extends ListActivity implements PreferenceManager.OnPreferenceTreeClickListener, PreferenceFragment.OnPreferenceStartFragmentCallback {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.413 -0500", hash_original_field = "7BDF14D5CB30507B18B1C0FFB4D1594D", hash_generated_field = "2E084579604068AECB302A705EB28607")

    private static final String HEADERS_TAG = ":android:headers";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.416 -0500", hash_original_field = "2DE14FD0830FB23F89B93C7C3886B0BE", hash_generated_field = "475A448573DAB6E82A443372F6B23A12")

    private static final String CUR_HEADER_TAG = ":android:cur_header";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.418 -0500", hash_original_field = "985B3970EBD23BF57C0A829DB568DEAB", hash_generated_field = "95AADD698D0027248B58F382F8E7BC71")

    private static final String PREFERENCES_TAG = ":android:preferences";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.421 -0500", hash_original_field = "154E079E6D20286ED847CA5B423E60D4", hash_generated_field = "46D5D655E675E9CC41AA95971DA7C983")

    public static final String EXTRA_SHOW_FRAGMENT = ":android:show_fragment";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.423 -0500", hash_original_field = "F0F4879B2A9B8A1FB706B1CAC91AF72E", hash_generated_field = "238348398E3BDE30D489970315DCB2F7")

    public static final String EXTRA_SHOW_FRAGMENT_ARGUMENTS = ":android:show_fragment_args";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.426 -0500", hash_original_field = "B0D5359B56BC44434170B12347397250", hash_generated_field = "9EDA9A80F485D711E436660545646846")

    public static final String EXTRA_SHOW_FRAGMENT_TITLE = ":android:show_fragment_title";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.428 -0500", hash_original_field = "C4A089B5D15CBC1A99717825200801D2", hash_generated_field = "72E65F21D21C144A50537392CA5C7A04")

    public static final String EXTRA_SHOW_FRAGMENT_SHORT_TITLE
            = ":android:show_fragment_short_title";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.430 -0500", hash_original_field = "9516B49B1664D3039B954BD2451AA855", hash_generated_field = "D38B44E415912850DD5978247D2C7A68")

    public static final String EXTRA_NO_HEADERS = ":android:no_headers";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.432 -0500", hash_original_field = "07A92C52E9A0529B8A0BBC301D6C72EE", hash_generated_field = "A284837FF977B323F510310B8A0B07BC")

    private static final String BACK_STACK_PREFS = ":android:prefs";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.435 -0500", hash_original_field = "56CA01FB702FD0C1821373F6C3CDF75A", hash_generated_field = "ADF6AAB2E36F959142988AA6C9A4B500")

    // show Back and Next buttons? takes boolean parameter
    // Back will then return RESULT_CANCELED and Next RESULT_OK
    private static final String EXTRA_PREFS_SHOW_BUTTON_BAR = "extra_prefs_show_button_bar";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.437 -0500", hash_original_field = "B962E6CD148194FAB2FAC9893EA4DF2F", hash_generated_field = "B496A57DC5DA5028C2D08B42DAE92474")

    private static final String EXTRA_PREFS_SHOW_SKIP = "extra_prefs_show_skip";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.439 -0500", hash_original_field = "10770B2170AC6D6BCB58C6A92AC69F10", hash_generated_field = "98958FC91C69E60BF72CEC3D1E8C1677")

    // at all by setting it to null
    private static final String EXTRA_PREFS_SET_NEXT_TEXT = "extra_prefs_set_next_text";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.442 -0500", hash_original_field = "388EB9B46737BE51786CBC8410B36311", hash_generated_field = "9CF302D5D1C7AB16535FE30602ABF893")

    private static final String EXTRA_PREFS_SET_BACK_TEXT = "extra_prefs_set_back_text";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.464 -0500", hash_original_field = "EF58221526EB4F2D6AEC0B63C641BA7F", hash_generated_field = "0136D59B093194DD543B8062A7975D9E")

    private static final int FIRST_REQUEST_CODE = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.467 -0500", hash_original_field = "527115F2BBB9AFA090DB4A1C2F4D370C", hash_generated_field = "7A68CD10BF8C3B855976E8E8F733E671")

    private static final int MSG_BIND_PREFERENCES = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.469 -0500", hash_original_field = "B333F87B4C3A3F15B2A6084E90BB450E", hash_generated_field = "CF41B970CC3B897D25CF787D434428D5")

    private static final int MSG_BUILD_HEADERS = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.498 -0500", hash_original_field = "9EFF634E8993FED0D7C758DC4D1D06A9", hash_generated_field = "D3EEEA8888F40DB4597966262702A0F4")

    public static final long HEADER_ID_UNDEFINED = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.444 -0500", hash_original_field = "D4BA745EF746ED82C85F58EF4171CFAD", hash_generated_field = "05229AEEB45F74E6571A04947AF7440D")

    private final ArrayList<Header> mHeaders = new ArrayList<Header>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.446 -0500", hash_original_field = "7A46D58E9373A396D1878E4F12CD4178", hash_generated_field = "FD5AB4D46307B27E8B131FCC69B56024")

    private FrameLayout mListFooter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.449 -0500", hash_original_field = "4BFEBCD179051A6AD954B7C0056C566F", hash_generated_field = "7F048D850CFE3A627851CBB7E986274C")

    private ViewGroup mPrefsContainer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.451 -0500", hash_original_field = "0433CBF092186CAF13AF3D99C4E244F1", hash_generated_field = "C9A9E888C6CF8869C49ADC5AA023A69B")

    private FragmentBreadCrumbs mFragmentBreadCrumbs;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.453 -0500", hash_original_field = "C1227A8D190B9EED1A3F26E4B09FF207", hash_generated_field = "A5B8DDF0DF04B9985F211EFD1518F984")

    private boolean mSinglePane;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.455 -0500", hash_original_field = "55AC852C7B8ED98951F16E8068C7A6D1", hash_generated_field = "801A7E2120484101CEC1CFAD107C2A9C")

    private Header mCurHeader;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.457 -0500", hash_original_field = "F44A9B2F698C7B96C36DE45B8F61794D", hash_generated_field = "13262EB3751B753EEB3302EF75D8B1E5")

    private PreferenceManager mPreferenceManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.459 -0500", hash_original_field = "540FC7475282CE902EB05EE0E2FD5926", hash_generated_field = "04DDA78321A9F720FA97A23B9C869D4C")

    private Bundle mSavedInstanceState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.461 -0500", hash_original_field = "4A0BF985B0515BC6CEDD46C3626DEC54", hash_generated_field = "128183E1ED5B562A53AAED4DF9F0640D")

    private Button mNextButton;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.368 -0400", hash_original_field = "92EE827C36817A69E1CF224FB382CB43", hash_generated_field = "17A435BCB512B12289624DA1E2A26680")

    private Handler mHandler = new Handler() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.473 -0500", hash_original_method = "DC47A807DF4ECAC4EAC562CA0F303D11", hash_generated_method = "3EBED8433021141911C1A0823B7D62FA")
        
@Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_BIND_PREFERENCES: {
                    bindPreferences();
                } break;
                case MSG_BUILD_HEADERS: {
                    ArrayList<Header> oldHeaders = new ArrayList<Header>(mHeaders);
                    mHeaders.clear();
                    onBuildHeaders(mHeaders);
                    if (mAdapter instanceof BaseAdapter) {
                        ((BaseAdapter) mAdapter).notifyDataSetChanged();
                    }
                    Header header = onGetNewHeader();
                    if (header != null && header.fragment != null) {
                        Header mappedHeader = findBestMatchingHeader(header, oldHeaders);
                        if (mappedHeader == null || mCurHeader != mappedHeader) {
                            switchToHeader(header);
                        }
                    } else if (mCurHeader != null) {
                        Header mappedHeader = findBestMatchingHeader(mCurHeader, mHeaders);
                        if (mappedHeader != null) {
                            setSelectedHeader(mappedHeader);
                        }
                    }
                } break;
            }
        }
        
};
    
    @DSComment("General android operation, no security concern")
    @DSSafe(DSCat.OS_GENERAL)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.369 -0400", hash_original_method = "5B933AEEC6389C71875EE2A57A875A3A", hash_generated_method = "5B933AEEC6389C71875EE2A57A875A3A")
    public PreferenceActivity ()
    {
        //Synthesized constructor
    }

    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSVerified("called from Activity's droidsafeOnCreate")
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.579 -0500", hash_original_method = "7377982A731D92C32EEEF871F40BFABD", hash_generated_method = "52427157046BF3244375E6579DEF6556")
    
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(com.android.internal.R.layout.preference_list_content);

        mListFooter = (FrameLayout)findViewById(com.android.internal.R.id.list_footer);
        mPrefsContainer = (ViewGroup) findViewById(com.android.internal.R.id.prefs_frame);
        boolean hidingHeaders = onIsHidingHeaders();
        mSinglePane = hidingHeaders || !onIsMultiPane();
        String initialFragment = getIntent().getStringExtra(EXTRA_SHOW_FRAGMENT);
        Bundle initialArguments = getIntent().getBundleExtra(EXTRA_SHOW_FRAGMENT_ARGUMENTS);
        int initialTitle = getIntent().getIntExtra(EXTRA_SHOW_FRAGMENT_TITLE, 0);
        int initialShortTitle = getIntent().getIntExtra(EXTRA_SHOW_FRAGMENT_SHORT_TITLE, 0);

        if (savedInstanceState != null) {
            // We are restarting from a previous saved state; used that to
            // initialize, instead of starting fresh.
            ArrayList<Header> headers = savedInstanceState.getParcelableArrayList(HEADERS_TAG);
            if (headers != null) {
                mHeaders.addAll(headers);
                int curHeader = savedInstanceState.getInt(CUR_HEADER_TAG,
                        (int) HEADER_ID_UNDEFINED);
                if (curHeader >= 0 && curHeader < mHeaders.size()) {
                    setSelectedHeader(mHeaders.get(curHeader));
                }
            }

        } else {
            if (initialFragment != null && mSinglePane) {
                // If we are just showing a fragment, we want to run in
                // new fragment mode, but don't need to compute and show
                // the headers.
                switchToHeader(initialFragment, initialArguments);
                if (initialTitle != 0) {
                    CharSequence initialTitleStr = getText(initialTitle);
                    CharSequence initialShortTitleStr = initialShortTitle != 0
                            ? getText(initialShortTitle) : null;
                    showBreadCrumbs(initialTitleStr, initialShortTitleStr);
                }

            } else {
                // We need to try to build the headers.
                onBuildHeaders(mHeaders);

                // If there are headers, then at this point we need to show
                // them and, depending on the screen, we may also show in-line
                // the currently selected preference fragment.
                if (mHeaders.size() > 0) {
                    if (!mSinglePane) {
                        if (initialFragment == null) {
                            Header h = onGetInitialHeader();
                            switchToHeader(h);
                        } else {
                            switchToHeader(initialFragment, initialArguments);
                        }
                    }
                }
            }
        }

        // The default configuration is to only show the list view.  Adjust
        // visibility for other configurations.
        if (initialFragment != null && mSinglePane) {
            // Single pane, showing just a prefs fragment.
            findViewById(com.android.internal.R.id.headers).setVisibility(View.GONE);
            mPrefsContainer.setVisibility(View.VISIBLE);
            if (initialTitle != 0) {
                CharSequence initialTitleStr = getText(initialTitle);
                CharSequence initialShortTitleStr = initialShortTitle != 0
                        ? getText(initialShortTitle) : null;
                showBreadCrumbs(initialTitleStr, initialShortTitleStr);
            }
        } else if (mHeaders.size() > 0) {
            setListAdapter(new HeaderAdapter(this, mHeaders));
            if (!mSinglePane) {
                // Multi-pane.
                getListView().setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
                if (mCurHeader != null) {
                    setSelectedHeader(mCurHeader);
                }
                mPrefsContainer.setVisibility(View.VISIBLE);
            }
        } else {
            // If there are no headers, we are in the old "just show a screen
            // of preferences" mode.
            setContentView(com.android.internal.R.layout.preference_list_content_single);
            mListFooter = (FrameLayout) findViewById(com.android.internal.R.id.list_footer);
            mPrefsContainer = (ViewGroup) findViewById(com.android.internal.R.id.prefs);
            mPreferenceManager = new PreferenceManager(this, FIRST_REQUEST_CODE);
            mPreferenceManager.setOnPreferenceTreeClickListener(this);
        }

        // see if we should show Back/Next buttons
        Intent intent = getIntent();
        if (intent.getBooleanExtra(EXTRA_PREFS_SHOW_BUTTON_BAR, false)) {

            findViewById(com.android.internal.R.id.button_bar).setVisibility(View.VISIBLE);

            Button backButton = (Button)findViewById(com.android.internal.R.id.back_button);
            backButton.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    setResult(RESULT_CANCELED);
                    finish();
                }
            });
            Button skipButton = (Button)findViewById(com.android.internal.R.id.skip_button);
            skipButton.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    setResult(RESULT_OK);
                    finish();
                }
            });
            mNextButton = (Button)findViewById(com.android.internal.R.id.next_button);
            mNextButton.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    setResult(RESULT_OK);
                    finish();
                }
            });

            // set our various button parameters
            if (intent.hasExtra(EXTRA_PREFS_SET_NEXT_TEXT)) {
                String buttonText = intent.getStringExtra(EXTRA_PREFS_SET_NEXT_TEXT);
                if (TextUtils.isEmpty(buttonText)) {
                    mNextButton.setVisibility(View.GONE);
                }
                else {
                    mNextButton.setText(buttonText);
                }
            }
            if (intent.hasExtra(EXTRA_PREFS_SET_BACK_TEXT)) {
                String buttonText = intent.getStringExtra(EXTRA_PREFS_SET_BACK_TEXT);
                if (TextUtils.isEmpty(buttonText)) {
                    backButton.setVisibility(View.GONE);
                }
                else {
                    backButton.setText(buttonText);
                }
            }
            if (intent.getBooleanExtra(EXTRA_PREFS_SHOW_SKIP, false)) {
                skipButton.setVisibility(View.VISIBLE);
            }
        }
    }

    /**
     * Returns true if this activity is currently showing the header list.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.582 -0500", hash_original_method = "451C86882BCD1F18856FAB1FCF2DF436", hash_generated_method = "F8E80606B800F2ABAAD0D0C071CB8B17")
    
public boolean hasHeaders() {
        return getListView().getVisibility() == View.VISIBLE
                && mPreferenceManager == null;
    }
    
    @Override
    public void droidsafeOnSubActivityHook() {
        onIsHidingHeaders();
        onIsMultiPane();
        onBuildHeaders(new LinkedList<Header>());
        onGetInitialHeader();
        onGetNewHeader();
        onHeaderClick(new Header(), getTaintInt());
        onBuildStartFragmentIntent(new String(), new Bundle(), getTaintInt(), getTaintInt());
        //TODO: check to make sure other callbacks are already called from super classes
        // callback preference screeen set
    }

    /**
     * Returns true if this activity is showing multiple panes -- the headers
     * and a preference fragment.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.584 -0500", hash_original_method = "E843412269C4B791D4D2B897726E7F84", hash_generated_method = "BC8939ADB87C98BC980EE193E0531F45")
    
public boolean isMultiPane() {
        return hasHeaders() && mPrefsContainer.getVisibility() == View.VISIBLE;
    }

    /**
     * Called to determine if the activity should run in multi-pane mode.
     * The default implementation returns true if the screen is large
     * enough.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.586 -0500", hash_original_method = "88171EFEE6286ACCEFBDA2CCA56DC062", hash_generated_method = "408EE93D32F3AD0106656C9DF079935A")
    
public boolean onIsMultiPane() {
        boolean preferMultiPane = getResources().getBoolean(
                com.android.internal.R.bool.preferences_prefer_dual_pane);
        return preferMultiPane;
    }

    /**
     * Called to determine whether the header list should be hidden.
     * The default implementation returns the
     * value given in {@link #EXTRA_NO_HEADERS} or false if it is not supplied.
     * This is set to false, for example, when the activity is being re-launched
     * to show a particular preference activity.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.588 -0500", hash_original_method = "6AB6F840F5A47C64B3086422C8E885E0", hash_generated_method = "3A2D57977C22AA10A16CC41CD9B930C0")
    
public boolean onIsHidingHeaders() {
        return getIntent().getBooleanExtra(EXTRA_NO_HEADERS, false);
    }

    /**
     * Called to determine the initial header to be shown.  The default
     * implementation simply returns the fragment of the first header.  Note
     * that the returned Header object does not actually need to exist in
     * your header list -- whatever its fragment is will simply be used to
     * show for the initial UI.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.591 -0500", hash_original_method = "106989DF67000CA038D75C5F0732B905", hash_generated_method = "8B4A91D4CE3A9FF3A63694FAF9AD4684")
    
public Header onGetInitialHeader() {
        return mHeaders.get(0);
    }

    /**
     * Called after the header list has been updated ({@link #onBuildHeaders}
     * has been called and returned due to {@link #invalidateHeaders()}) to
     * specify the header that should now be selected.  The default implementation
     * returns null to keep whatever header is currently selected.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.593 -0500", hash_original_method = "3D3F0DDAE644689D05411BA38FC63FD0", hash_generated_method = "64F53DFD10BB5819E704E7BAC89AD96B")
    
public Header onGetNewHeader() {
        return null;
    }

    /**
     * Called when the activity needs its list of headers build.  By
     * implementing this and adding at least one item to the list, you
     * will cause the activity to run in its modern fragment mode.  Note
     * that this function may not always be called; for example, if the
     * activity has been asked to display a particular fragment without
     * the header list, there is no need to build the headers.
     *
     * <p>Typical implementations will use {@link #loadHeadersFromResource}
     * to fill in the list from a resource.
     *
     * @param target The list in which to place the headers.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.595 -0500", hash_original_method = "2E92E1B9DF373424BC377EC8A240659F", hash_generated_method = "51E5BECBBAFE62361C1AFF7E778E7B96")
    
public void onBuildHeaders(List<Header> target) {
        // Should be overloaded by subclasses
    }

    /**
     * Call when you need to change the headers being displayed.  Will result
     * in onBuildHeaders() later being called to retrieve the new list.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.597 -0500", hash_original_method = "F909FF4426F024059C8CEA2BE75ABFBE", hash_generated_method = "6AE54003EF68EC28106E6B4BE417E02D")
    
public void invalidateHeaders() {
        if (!mHandler.hasMessages(MSG_BUILD_HEADERS)) {
            mHandler.sendEmptyMessage(MSG_BUILD_HEADERS);
        }
    }

    /**
     * Parse the given XML file as a header description, adding each
     * parsed Header into the target list.
     *
     * @param resid The XML resource to load and parse.
     * @param target The list in which the parsed headers should be placed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.602 -0500", hash_original_method = "004FDF3B00128708010F53C563B52195", hash_generated_method = "2FE4F18604C14FE634FC58F7E4689B4F")
    
public void loadHeadersFromResource(int resid, List<Header> target) {
        XmlResourceParser parser = null;
        try {
            parser = getResources().getXml(resid);
            AttributeSet attrs = Xml.asAttributeSet(parser);

            int type;
            while ((type=parser.next()) != XmlPullParser.END_DOCUMENT
                    && type != XmlPullParser.START_TAG) {
                // Parse next until start tag is found
            }

            String nodeName = parser.getName();
            if (!"preference-headers".equals(nodeName)) {
                throw new RuntimeException(
                        "XML document must start with <preference-headers> tag; found"
                        + nodeName + " at " + parser.getPositionDescription());
            }

            Bundle curBundle = null;

            final int outerDepth = parser.getDepth();
            while ((type=parser.next()) != XmlPullParser.END_DOCUMENT
                   && (type != XmlPullParser.END_TAG || parser.getDepth() > outerDepth)) {
                if (type == XmlPullParser.END_TAG || type == XmlPullParser.TEXT) {
                    continue;
                }

                nodeName = parser.getName();
                if ("header".equals(nodeName)) {
                    Header header = new Header();

                    TypedArray sa = getResources().obtainAttributes(attrs,
                            com.android.internal.R.styleable.PreferenceHeader);
                    header.id = sa.getResourceId(
                            com.android.internal.R.styleable.PreferenceHeader_id,
                            (int)HEADER_ID_UNDEFINED);
                    TypedValue tv = sa.peekValue(
                            com.android.internal.R.styleable.PreferenceHeader_title);
                    if (tv != null && tv.type == TypedValue.TYPE_STRING) {
                        if (tv.resourceId != 0) {
                            header.titleRes = tv.resourceId;
                        } else {
                            header.title = tv.string;
                        }
                    }
                    tv = sa.peekValue(
                            com.android.internal.R.styleable.PreferenceHeader_summary);
                    if (tv != null && tv.type == TypedValue.TYPE_STRING) {
                        if (tv.resourceId != 0) {
                            header.summaryRes = tv.resourceId;
                        } else {
                            header.summary = tv.string;
                        }
                    }
                    tv = sa.peekValue(
                            com.android.internal.R.styleable.PreferenceHeader_breadCrumbTitle);
                    if (tv != null && tv.type == TypedValue.TYPE_STRING) {
                        if (tv.resourceId != 0) {
                            header.breadCrumbTitleRes = tv.resourceId;
                        } else {
                            header.breadCrumbTitle = tv.string;
                        }
                    }
                    tv = sa.peekValue(
                            com.android.internal.R.styleable.PreferenceHeader_breadCrumbShortTitle);
                    if (tv != null && tv.type == TypedValue.TYPE_STRING) {
                        if (tv.resourceId != 0) {
                            header.breadCrumbShortTitleRes = tv.resourceId;
                        } else {
                            header.breadCrumbShortTitle = tv.string;
                        }
                    }
                    header.iconRes = sa.getResourceId(
                            com.android.internal.R.styleable.PreferenceHeader_icon, 0);
                    header.fragment = sa.getString(
                            com.android.internal.R.styleable.PreferenceHeader_fragment);
                    sa.recycle();

                    if (curBundle == null) {
                        curBundle = new Bundle();
                    }

                    final int innerDepth = parser.getDepth();
                    while ((type=parser.next()) != XmlPullParser.END_DOCUMENT
                           && (type != XmlPullParser.END_TAG || parser.getDepth() > innerDepth)) {
                        if (type == XmlPullParser.END_TAG || type == XmlPullParser.TEXT) {
                            continue;
                        }

                        String innerNodeName = parser.getName();
                        if (innerNodeName.equals("extra")) {
                            getResources().parseBundleExtra("extra", attrs, curBundle);
                            XmlUtils.skipCurrentTag(parser);

                        } else if (innerNodeName.equals("intent")) {
                            header.intent = Intent.parseIntent(getResources(), parser, attrs);

                        } else {
                            XmlUtils.skipCurrentTag(parser);
                        }
                    }

                    if (curBundle.size() > 0) {
                        header.fragmentArguments = curBundle;
                        curBundle = null;
                    }

                    target.add(header);
                } else {
                    XmlUtils.skipCurrentTag(parser);
                }
            }

        } catch (XmlPullParserException e) {
            throw new RuntimeException("Error parsing headers", e);
        } catch (IOException e) {
            throw new RuntimeException("Error parsing headers", e);
        } finally {
            if (parser != null) parser.close();
        }

    }

    /**
     * Set a footer that should be shown at the bottom of the header list.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.604 -0500", hash_original_method = "0C226BA6EB709C0B8BDD6989275021F7", hash_generated_method = "9B928AE24A2BDA9F14C8520E1111062C")
    
public void setListFooter(View view) {
        mListFooter.removeAllViews();
        mListFooter.addView(view, new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.WRAP_CONTENT));
    }

    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.607 -0500", hash_original_method = "5055AD43F70FAF224ADCBC793E0582D3", hash_generated_method = "18452CB7F1C5EF94F201F49A2445B815")
    
@Override
    protected void onStop() {
        super.onStop();

        if (mPreferenceManager != null) {
            mPreferenceManager.dispatchActivityStop();
        }
    }

    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.609 -0500", hash_original_method = "015EB586B516E4BA63E47DF2D2F941B5", hash_generated_method = "5FE1E22A9A75AB3816C7CADD00DC12E0")
    
@Override
    protected void onDestroy() {
        super.onDestroy();

        if (mPreferenceManager != null) {
            mPreferenceManager.dispatchActivityDestroy();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.611 -0500", hash_original_method = "1A457C81CAD07F8216A55B906C01B0EE", hash_generated_method = "F1397A80A92FDCEF0EACA23B93A28389")
    
@Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        if (mHeaders.size() > 0) {
            outState.putParcelableArrayList(HEADERS_TAG, mHeaders);
            if (mCurHeader != null) {
                int index = mHeaders.indexOf(mCurHeader);
                if (index >= 0) {
                    outState.putInt(CUR_HEADER_TAG, index);
                }
            }
        }

        if (mPreferenceManager != null) {
            final PreferenceScreen preferenceScreen = getPreferenceScreen();
            if (preferenceScreen != null) {
                Bundle container = new Bundle();
                preferenceScreen.saveHierarchyState(container);
                outState.putBundle(PREFERENCES_TAG, container);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.614 -0500", hash_original_method = "3A902C5AADE0A248676EF9D6166BBE53", hash_generated_method = "757342F67D8E14FAD1B0748543E54D0E")
    
@Override
    protected void onRestoreInstanceState(Bundle state) {
        if (mPreferenceManager != null) {
            Bundle container = state.getBundle(PREFERENCES_TAG);
            if (container != null) {
                final PreferenceScreen preferenceScreen = getPreferenceScreen();
                if (preferenceScreen != null) {
                    preferenceScreen.restoreHierarchyState(container);
                    mSavedInstanceState = state;
                    return;
                }
            }
        }

        // Only call this if we didn't save the instance state for later.
        // If we did save it, it will be restored when we bind the adapter.
        super.onRestoreInstanceState(state);
    }

    @DSVerified
    @DSComment("Potential intent to trigger other processing")
    @DSSpec(DSCat.INTENT_EXCHANGE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.616 -0500", hash_original_method = "BC5669EA98C9095AD4591AFCBD99CE20", hash_generated_method = "367800A5BDAE41B74EA1B95BD8DBE532")
    
@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (mPreferenceManager != null) {
            mPreferenceManager.dispatchActivityResult(requestCode, resultCode, data);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.619 -0500", hash_original_method = "B413EAEA105506529AB09785B80740F7", hash_generated_method = "E7539A179D929E3CE0F45D143EFB7898")
    
@Override
    public void onContentChanged() {
        super.onContentChanged();

        if (mPreferenceManager != null) {
            postBindPreferences();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.621 -0500", hash_original_method = "32CF46DB4065373D899344EB4B5785F0", hash_generated_method = "0FAADE09CA8D14D8449EF7BF6B0E444F")
    
@Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        if (mAdapter != null) {
            Object item = mAdapter.getItem(position);
            if (item instanceof Header) onHeaderClick((Header) item, position);
        }
    }

    /**
     * Called when the user selects an item in the header list.  The default
     * implementation will call either
     * {@link #startWithFragment(String, Bundle, Fragment, int, int, int)}
     * or {@link #switchToHeader(Header)} as appropriate.
     *
     * @param header The header that was selected.
     * @param position The header's position in the list.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.624 -0500", hash_original_method = "41F78ADB739893E8265A1748D8E017F7", hash_generated_method = "43C741CB9777D88299D7A3C1BE2122C7")
    
public void onHeaderClick(Header header, int position) {
        if (header.fragment != null) {
            if (mSinglePane) {
                int titleRes = header.breadCrumbTitleRes;
                int shortTitleRes = header.breadCrumbShortTitleRes;
                if (titleRes == 0) {
                    titleRes = header.titleRes;
                    shortTitleRes = 0;
                }
                startWithFragment(header.fragment, header.fragmentArguments, null, 0,
                        titleRes, shortTitleRes);
            } else {
                switchToHeader(header);
            }
        } else if (header.intent != null) {
            startActivity(header.intent);
        }
    }

    /**
     * Called by {@link #startWithFragment(String, Bundle, Fragment, int, int, int)} when
     * in single-pane mode, to build an Intent to launch a new activity showing
     * the selected fragment.  The default implementation constructs an Intent
     * that re-launches the current activity with the appropriate arguments to
     * display the fragment.
     * 
     * @param fragmentName The name of the fragment to display.
     * @param args Optional arguments to supply to the fragment.
     * @param titleRes Optional resource ID of title to show for this item.
     * @param shortTitleRes Optional resource ID of short title to show for this item.
     * @return Returns an Intent that can be launched to display the given
     * fragment.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.627 -0500", hash_original_method = "B5DA23DDC47E44587D99F550083B256B", hash_generated_method = "D694B38CE711606CC8563D5769288619")
    
public Intent onBuildStartFragmentIntent(String fragmentName, Bundle args,
            int titleRes, int shortTitleRes) {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setClass(this, getClass());
        intent.putExtra(EXTRA_SHOW_FRAGMENT, fragmentName);
        intent.putExtra(EXTRA_SHOW_FRAGMENT_ARGUMENTS, args);
        intent.putExtra(EXTRA_SHOW_FRAGMENT_TITLE, titleRes);
        intent.putExtra(EXTRA_SHOW_FRAGMENT_SHORT_TITLE, shortTitleRes);
        intent.putExtra(EXTRA_NO_HEADERS, true);
        return intent;
    }
    
    /**
     * Like {@link #startWithFragment(String, Bundle, Fragment, int, int, int)}
     * but uses a 0 titleRes.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.629 -0500", hash_original_method = "7A5ABD7084FE456D2AC9E7363F23F617", hash_generated_method = "F44F953B843CDA61CFFB0C970B2E4A7C")
    
public void startWithFragment(String fragmentName, Bundle args,
            Fragment resultTo, int resultRequestCode) {
        startWithFragment(fragmentName, args, resultTo, resultRequestCode, 0, 0);
    }

    /**
     * Start a new instance of this activity, showing only the given
     * preference fragment.  When launched in this mode, the header list
     * will be hidden and the given preference fragment will be instantiated
     * and fill the entire activity.
     *
     * @param fragmentName The name of the fragment to display.
     * @param args Optional arguments to supply to the fragment.
     * @param resultTo Option fragment that should receive the result of
     * the activity launch.
     * @param resultRequestCode If resultTo is non-null, this is the request
     * code in which to report the result.
     * @param titleRes Resource ID of string to display for the title of
     * this set of preferences.
     * @param shortTitleRes Resource ID of string to display for the short title of
     * this set of preferences.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.631 -0500", hash_original_method = "A8702F14B58AAD20058746FC81F4589D", hash_generated_method = "FA9F84C4830C5AB60D417F152BB76B01")
    
public void startWithFragment(String fragmentName, Bundle args,
            Fragment resultTo, int resultRequestCode, int titleRes, int shortTitleRes) {
        Intent intent = onBuildStartFragmentIntent(fragmentName, args, titleRes, shortTitleRes);
        if (resultTo == null) {
            startActivity(intent);
        } else {
            resultTo.startActivityForResult(intent, resultRequestCode);
        }
    }

    /**
     * Change the base title of the bread crumbs for the current preferences.
     * This will normally be called for you.  See
     * {@link android.app.FragmentBreadCrumbs} for more information.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.633 -0500", hash_original_method = "4F3C5CDBD4880824AF39CB9E5E4A33FC", hash_generated_method = "E83DDE2347BB66E5D90AE3A17B543CD0")
    
public void showBreadCrumbs(CharSequence title, CharSequence shortTitle) {
        if (mFragmentBreadCrumbs == null) {
            View crumbs = findViewById(android.R.id.title);
            // For screens with a different kind of title, don't create breadcrumbs.
            try {
                mFragmentBreadCrumbs = (FragmentBreadCrumbs)crumbs;
            } catch (ClassCastException e) {
                return;
            }
            if (mFragmentBreadCrumbs == null) {
                if (title != null) {
                    setTitle(title);
                }
                return;
            }
            mFragmentBreadCrumbs.setMaxVisible(2);
            mFragmentBreadCrumbs.setActivity(this);
        }
        mFragmentBreadCrumbs.setTitle(title, shortTitle);
        mFragmentBreadCrumbs.setParentTitle(null, null, null);
    }

    /**
     * Should be called after onCreate to ensure that the breadcrumbs, if any, were created.
     * This prepends a title to the fragment breadcrumbs and attaches a listener to any clicks
     * on the parent entry.
     * @param title the title for the breadcrumb
     * @param shortTitle the short title for the breadcrumb
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.636 -0500", hash_original_method = "1549DF3FA5C3B3F8F6931C4E058E1944", hash_generated_method = "D14CD56FAD81A8341A55033BEF5C0FF8")
    
public void setParentTitle(CharSequence title, CharSequence shortTitle,
            OnClickListener listener) {
        if (mFragmentBreadCrumbs != null) {
            mFragmentBreadCrumbs.setParentTitle(title, shortTitle, listener);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.638 -0500", hash_original_method = "6CD55A84320A14788B0DD27C2F943CD9", hash_generated_method = "6CD55A84320A14788B0DD27C2F943CD9")
    
void setSelectedHeader(Header header) {
        mCurHeader = header;
        int index = mHeaders.indexOf(header);
        if (index >= 0) {
            getListView().setItemChecked(index, true);
        } else {
            getListView().clearChoices();
        }
        showBreadCrumbs(header);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.640 -0500", hash_original_method = "DBABA4F3A7CA13D3BE4599BE843A33E0", hash_generated_method = "DBABA4F3A7CA13D3BE4599BE843A33E0")
    
void showBreadCrumbs(Header header) {
        if (header != null) {
            CharSequence title = header.getBreadCrumbTitle(getResources());
            if (title == null) title = header.getTitle(getResources());
            if (title == null) title = getTitle();
            showBreadCrumbs(title, header.getBreadCrumbShortTitle(getResources()));
        } else {
            showBreadCrumbs(getTitle(), null);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.642 -0500", hash_original_method = "7A46889D874DD705E59FA4FB1509394D", hash_generated_method = "D5534E964B59AC2DBFA44850590E04CF")
    
private void switchToHeaderInner(String fragmentName, Bundle args, int direction) {
        getFragmentManager().popBackStack(BACK_STACK_PREFS,
                FragmentManager.POP_BACK_STACK_INCLUSIVE);
        Fragment f = Fragment.instantiate(this, fragmentName, args);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        transaction.replace(com.android.internal.R.id.prefs, f);
        transaction.commitAllowingStateLoss();
    }

    /**
     * When in two-pane mode, switch the fragment pane to show the given
     * preference fragment.
     *
     * @param fragmentName The name of the fragment to display.
     * @param args Optional arguments to supply to the fragment.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.644 -0500", hash_original_method = "1F3D49C208A22CE80DD0C39318B7FB91", hash_generated_method = "5C463F0E1A8DAA99D6E8FB66BDCEF58E")
    
public void switchToHeader(String fragmentName, Bundle args) {
        setSelectedHeader(null);
        switchToHeaderInner(fragmentName, args, 0);
    }

    /**
     * When in two-pane mode, switch to the fragment pane to show the given
     * preference fragment.
     *
     * @param header The new header to display.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.646 -0500", hash_original_method = "439F40B8AE0DFA06D4CE3EB843023A82", hash_generated_method = "EAF5CD1C7D4E570AFF0CBE3F9A1D9217")
    
public void switchToHeader(Header header) {
        if (mCurHeader == header) {
            // This is the header we are currently displaying.  Just make sure
            // to pop the stack up to its root state.
            getFragmentManager().popBackStack(BACK_STACK_PREFS,
                    FragmentManager.POP_BACK_STACK_INCLUSIVE);
        } else {
            int direction = mHeaders.indexOf(header) - mHeaders.indexOf(mCurHeader);
            switchToHeaderInner(header.fragment, header.fragmentArguments, direction);
            setSelectedHeader(header);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.649 -0500", hash_original_method = "A27B5089D7C34DCC8F697434FD74BDF2", hash_generated_method = "730E1055E603A8FB5E08A38CA907F928")
    
Header findBestMatchingHeader(Header cur, ArrayList<Header> from) {
        ArrayList<Header> matches = new ArrayList<Header>();
        for (int j=0; j<from.size(); j++) {
            Header oh = from.get(j);
            if (cur == oh || (cur.id != HEADER_ID_UNDEFINED && cur.id == oh.id)) {
                // Must be this one.
                matches.clear();
                matches.add(oh);
                break;
            }
            if (cur.fragment != null) {
                if (cur.fragment.equals(oh.fragment)) {
                    matches.add(oh);
                }
            } else if (cur.intent != null) {
                if (cur.intent.equals(oh.intent)) {
                    matches.add(oh);
                }
            } else if (cur.title != null) {
                if (cur.title.equals(oh.title)) {
                    matches.add(oh);
                }
            }
        }
        final int NM = matches.size();
        if (NM == 1) {
            return matches.get(0);
        } else if (NM > 1) {
            for (int j=0; j<NM; j++) {
                Header oh = matches.get(j);
                if (cur.fragmentArguments != null &&
                        cur.fragmentArguments.equals(oh.fragmentArguments)) {
                    return oh;
                }
                if (cur.extras != null && cur.extras.equals(oh.extras)) {
                    return oh;
                }
                if (cur.title != null && cur.title.equals(oh.title)) {
                    return oh;
                }
            }
        }
        return null;
    }
    
    private static class HeaderAdapter extends ArrayAdapter<Header> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.488 -0500", hash_original_field = "B03B4DAE3F576B7166425BEE37B96C5E", hash_generated_field = "CBB0EE0A851756643DA52E1D33B6B161")

        private LayoutInflater mInflater;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.490 -0500", hash_original_method = "F02F4C5BC3B955ED93786AEEC10379FE", hash_generated_method = "FE4ED3732FA66CB97F76ECCAD910EC4B")
        
public HeaderAdapter(Context context, List<Header> objects) {
            super(context, 0, objects);
            mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.639 -0400", hash_original_method = "BD15B4EB453F2C74F6031A45FD2B76C2", hash_generated_method = "26757578C3FCD43F8FF32C3523B6A317")
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            addTaint(parent.getTaint());
            addTaint(convertView.getTaint());
            addTaint(position);
            HeaderViewHolder holder;
            View view;
            if(convertView == null)            
            {
                view = mInflater.inflate(com.android.internal.R.layout.preference_header_item,
                        parent, false);
                holder = new HeaderViewHolder();
                holder.icon = (ImageView) view.findViewById(com.android.internal.R.id.icon);
                holder.title = (TextView) view.findViewById(com.android.internal.R.id.title);
                holder.summary = (TextView) view.findViewById(com.android.internal.R.id.summary);
                view.setTag(holder);
            } //End block
            else
            {
                view = convertView;
                holder = (HeaderViewHolder) view.getTag();
            } //End block
            Header header = (Header) getItem(position);
            holder.icon.setImageResource(header.iconRes);
            holder.title.setText(header.getTitle(getContext().getResources()));
            CharSequence summary = header.getSummary(getContext().getResources());
            if(!TextUtils.isEmpty(summary))            
            {
                holder.summary.setVisibility(View.VISIBLE);
                holder.summary.setText(summary);
            } //End block
            else
            {
                holder.summary.setVisibility(View.GONE);
            } //End block
View var057D265746AE9672AFE5F9FF6338071D_1722391247 =             view;
            var057D265746AE9672AFE5F9FF6338071D_1722391247.addTaint(taint);
            return var057D265746AE9672AFE5F9FF6338071D_1722391247;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }
        
        private static class HeaderViewHolder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.479 -0500", hash_original_field = "7D496A7EF4277B81CF926C9FC9D04248", hash_generated_field = "7D496A7EF4277B81CF926C9FC9D04248")

            ImageView icon;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.481 -0500", hash_original_field = "D2FBB4059A3EADAB444F225698E4F56E", hash_generated_field = "D2FBB4059A3EADAB444F225698E4F56E")

            TextView title;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.483 -0500", hash_original_field = "BA7542FFBE4C8102C12065D859063619", hash_generated_field = "BA7542FFBE4C8102C12065D859063619")

            TextView summary;
            
            @DSComment("Private Method")
            @DSBan(DSCat.PRIVATE_METHOD)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.646 -0400", hash_original_method = "7AAB7B01E6419825274A30D2382564EA", hash_generated_method = "7AAB7B01E6419825274A30D2382564EA")
            public HeaderViewHolder ()
            {
                //Synthesized constructor
            }

        }
        
    }
    
    public static final class Header implements Parcelable {
        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.717 -0400", hash_original_field = "80358CCA6C151B1C75C8F6D01427BC96", hash_generated_field = "0285FC5896D2C8A81AC7F6CCCD215EAF")

        public static final Creator<Header> CREATOR = new Creator<Header>() {
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.556 -0500", hash_original_method = "C7AEFD10D7C167524F7EC8EE7485F83D", hash_generated_method = "5EF80A858BCAD7DE9466608611F9FE8E")
            
public Header createFromParcel(Parcel source) {
                return new Header(source);
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.559 -0500", hash_original_method = "B5BF874DB290B269F63DFF8F13F70AAB", hash_generated_method = "6B45B502D639DBD6FCD536D9E5F56828")
            
public Header[] newArray(int size) {
                return new Header[size];
            }
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.502 -0500", hash_original_field = "9A341A8A13D1D6EEBE0F394873C4B136", hash_generated_field = "737A7D6903ECE33BE0237DB5C22496D2")

        public long id = HEADER_ID_UNDEFINED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.504 -0500", hash_original_field = "6024D9B9B9CB2CF6A7186335B469D557", hash_generated_field = "3FD6C8139DEDC39179812C2724BF57B9")

        public int titleRes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.506 -0500", hash_original_field = "EBB523BB554B1588E9D2A3FD4AC43EC2", hash_generated_field = "285EF5A6A116FF608EE0587EA9C0F06D")

        public CharSequence title;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.508 -0500", hash_original_field = "6B7D939C497F73A48F26C550E2A9CA3C", hash_generated_field = "CF9D7763F41618969B1EF555AA62D675")

        public int summaryRes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.510 -0500", hash_original_field = "F23D4C65765568B26B704DE52831CEA4", hash_generated_field = "649E9B273BD3EE954608217A46D60F9B")

        public CharSequence summary;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.512 -0500", hash_original_field = "00BFFF18C1635D07EDB6DD66A327D9D9", hash_generated_field = "2CD689A4778432DF6FA02D3B2B9056EA")

        public int breadCrumbTitleRes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.515 -0500", hash_original_field = "953799CCB093BBAE2106C8A5E5D5040C", hash_generated_field = "73EEB773801D9077B302E48B9DC2F190")

        public CharSequence breadCrumbTitle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.517 -0500", hash_original_field = "74BF7521E31926BF6317F6B56421DF06", hash_generated_field = "61F809170E6E2C53D80864D07EEB140C")

        public int breadCrumbShortTitleRes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.520 -0500", hash_original_field = "6C2370FF2B0C2AF158C82B1DB24BE602", hash_generated_field = "12A2018B53E7263915979427C28D6095")

        public CharSequence breadCrumbShortTitle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.522 -0500", hash_original_field = "16A2D6444BA4128F5DED925DDCED14C3", hash_generated_field = "800898B731FFFE010B18EB819F288168")

        public int iconRes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.524 -0500", hash_original_field = "1351A4AFA5B1F9B1204BBA65A76690AC", hash_generated_field = "3FCA1C3F48B0A85017F597A00E283B60")

        public String fragment;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.526 -0500", hash_original_field = "E2B4F5038F2CA31AC7CE1A6E2EBA1E5C", hash_generated_field = "B8BBDD0C2C5BEF49B225AB4995204C33")

        public Bundle fragmentArguments;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.528 -0500", hash_original_field = "170FCA7A98A65D8003A3D20D5B3C245D", hash_generated_field = "5DEDAC72AD89B3864945324786195E0B")

        public Intent intent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.531 -0500", hash_original_field = "6F80A5414A80FF69E92A0BD3C0E073DC", hash_generated_field = "360651D25CBD3D75EA270BBFA49C37D4")

        public Bundle extras;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.533 -0500", hash_original_method = "CC8692EE42ED9AE9CFD9E664B2A1E936", hash_generated_method = "FF5D00D926FE8AA9CB6F2A80117BC757")
        
public Header() {
            // Empty
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.553 -0500", hash_original_method = "3E4088512988FAACC868C0BAC5E638A1", hash_generated_method = "3E4088512988FAACC868C0BAC5E638A1")
        
Header(Parcel in) {
            readFromParcel(in);
        }

        /**
         * Return the currently set title.  If {@link #titleRes} is set,
         * this resource is loaded from <var>res</var> and returned.  Otherwise
         * {@link #title} is returned.
         */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.536 -0500", hash_original_method = "334D1E94CC98A584AC982CEC8D5C3813", hash_generated_method = "558119F0346FC33D66232F3AB2F54893")
        
public CharSequence getTitle(Resources res) {
            if (titleRes != 0) {
                return res.getText(titleRes);
            }
            return title;
        }

        /**
         * Return the currently set summary.  If {@link #summaryRes} is set,
         * this resource is loaded from <var>res</var> and returned.  Otherwise
         * {@link #summary} is returned.
         */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.538 -0500", hash_original_method = "817FA0FA7A0D92830E14FE64024CE8CC", hash_generated_method = "6B1B3BF94A66A564864764F49C732AC0")
        
public CharSequence getSummary(Resources res) {
            if (summaryRes != 0) {
                return res.getText(summaryRes);
            }
            return summary;
        }

        /**
         * Return the currently set bread crumb title.  If {@link #breadCrumbTitleRes} is set,
         * this resource is loaded from <var>res</var> and returned.  Otherwise
         * {@link #breadCrumbTitle} is returned.
         */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.540 -0500", hash_original_method = "AB517FA9C1DC5B1E62910A1ABDCECDD0", hash_generated_method = "5419ED962D99E0BA9669C14FE8FF3315")
        
public CharSequence getBreadCrumbTitle(Resources res) {
            if (breadCrumbTitleRes != 0) {
                return res.getText(breadCrumbTitleRes);
            }
            return breadCrumbTitle;
        }

        /**
         * Return the currently set bread crumb short title.  If
         * {@link #breadCrumbShortTitleRes} is set,
         * this resource is loaded from <var>res</var> and returned.  Otherwise
         * {@link #breadCrumbShortTitle} is returned.
         */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.543 -0500", hash_original_method = "F11776C7591643DD9CB4C4ECCD867732", hash_generated_method = "E4501D960841694B287DBBF69FFD5A42")
        
public CharSequence getBreadCrumbShortTitle(Resources res) {
            if (breadCrumbShortTitleRes != 0) {
                return res.getText(breadCrumbShortTitleRes);
            }
            return breadCrumbShortTitle;
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.545 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "8188008AC9C80E87937FE73DCA905200")
        
@Override
        public int describeContents() {
            return 0;
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.548 -0500", hash_original_method = "BB0DBC9520A7E98C1F6BA8AD4772118F", hash_generated_method = "3FCE770CA3A52A269B81414300D49F64")
        
@Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeLong(id);
            dest.writeInt(titleRes);
            TextUtils.writeToParcel(title, dest, flags);
            dest.writeInt(summaryRes);
            TextUtils.writeToParcel(summary, dest, flags);
            dest.writeInt(breadCrumbTitleRes);
            TextUtils.writeToParcel(breadCrumbTitle, dest, flags);
            dest.writeInt(breadCrumbShortTitleRes);
            TextUtils.writeToParcel(breadCrumbShortTitle, dest, flags);
            dest.writeInt(iconRes);
            dest.writeString(fragment);
            dest.writeBundle(fragmentArguments);
            if (intent != null) {
                dest.writeInt(1);
                intent.writeToParcel(dest, flags);
            } else {
                dest.writeInt(0);
            }
            dest.writeBundle(extras);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.550 -0500", hash_original_method = "29282A1B26F647059DDF5369C2CB137B", hash_generated_method = "6730EC0709031A17D20BE511D6445C77")
        
public void readFromParcel(Parcel in) {
            id = in.readLong();
            titleRes = in.readInt();
            title = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
            summaryRes = in.readInt();
            summary = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
            breadCrumbTitleRes = in.readInt();
            breadCrumbTitle = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
            breadCrumbShortTitleRes = in.readInt();
            breadCrumbShortTitle = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
            iconRes = in.readInt();
            fragment = in.readString();
            fragmentArguments = in.readBundle();
            if (in.readInt() != 0) {
                intent = Intent.CREATOR.createFromParcel(in);
            }
            extras = in.readBundle();
        }
    }

    /**
     * Start a new fragment.
     *
     * @param fragment The fragment to start
     * @param push If true, the current fragment will be pushed onto the back stack.  If false,
     * the current fragment will be replaced.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.653 -0500", hash_original_method = "20FDC2DC66402E55AE5BF59B2D025057", hash_generated_method = "FF8D379599B6EB4246A0F64E1BF95C13")
    
public void startPreferenceFragment(Fragment fragment, boolean push) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(com.android.internal.R.id.prefs, fragment);
        if (push) {
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            transaction.addToBackStack(BACK_STACK_PREFS);
        } else {
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        }
        transaction.commitAllowingStateLoss();
    }

    /**
     * Start a new fragment containing a preference panel.  If the prefences
     * are being displayed in multi-pane mode, the given fragment class will
     * be instantiated and placed in the appropriate pane.  If running in
     * single-pane mode, a new activity will be launched in which to show the
     * fragment.
     * 
     * @param fragmentClass Full name of the class implementing the fragment.
     * @param args Any desired arguments to supply to the fragment.
     * @param titleRes Optional resource identifier of the title of this
     * fragment.
     * @param titleText Optional text of the title of this fragment.
     * @param resultTo Optional fragment that result data should be sent to.
     * If non-null, resultTo.onActivityResult() will be called when this
     * preference panel is done.  The launched panel must use
     * {@link #finishPreferencePanel(Fragment, int, Intent)} when done.
     * @param resultRequestCode If resultTo is non-null, this is the caller's
     * request code to be received with the resut.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.655 -0500", hash_original_method = "E25F9CE570E0BFA743AE6FCAFFB6168D", hash_generated_method = "B45569DC11A75BEC758B271655EA9D3C")
    
public void startPreferencePanel(String fragmentClass, Bundle args, int titleRes,
            CharSequence titleText, Fragment resultTo, int resultRequestCode) {
        if (mSinglePane) {
            startWithFragment(fragmentClass, args, resultTo, resultRequestCode, titleRes, 0);
        } else {
            Fragment f = Fragment.instantiate(this, fragmentClass, args);
            if (resultTo != null) {
                f.setTargetFragment(resultTo, resultRequestCode);
            }
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(com.android.internal.R.id.prefs, f);
            if (titleRes != 0) {
                transaction.setBreadCrumbTitle(titleRes);
            } else if (titleText != null) {
                transaction.setBreadCrumbTitle(titleText);
            }
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            transaction.addToBackStack(BACK_STACK_PREFS);
            transaction.commitAllowingStateLoss();
        }
    }
    
    /**
     * Called by a preference panel fragment to finish itself.
     * 
     * @param caller The fragment that is asking to be finished.
     * @param resultCode Optional result code to send back to the original
     * launching fragment.
     * @param resultData Optional result data to send back to the original
     * launching fragment.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.658 -0500", hash_original_method = "35CCCF58010C828A125388DBAAB260E2", hash_generated_method = "B9DAB758FE076528F57D8806EA550E91")
    
public void finishPreferencePanel(Fragment caller, int resultCode, Intent resultData) {
        if (mSinglePane) {
            setResult(resultCode, resultData);
            finish();
        } else {
            // XXX be smarter about popping the stack.
            onBackPressed();
            if (caller != null) {
                if (caller.getTargetFragment() != null) {
                    caller.getTargetFragment().onActivityResult(caller.getTargetRequestCode(),
                            resultCode, resultData);
                }
            }
        }
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.660 -0500", hash_original_method = "88B12B83AF6C82165835FAA52B723B1A", hash_generated_method = "CE6C747186D68711084C57C35A99D10B")
    
@Override
    public boolean onPreferenceStartFragment(PreferenceFragment caller, Preference pref) {
        startPreferencePanel(pref.getFragment(), pref.getExtras(), pref.getTitleRes(),
                pref.getTitle(), null, 0);
        return true;
    }

    /**
     * Posts a message to bind the preferences to the list view.
     * <p>
     * Binding late is preferred as any custom preference types created in
     * {@link #onCreate(Bundle)} are able to have their views recycled.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.662 -0500", hash_original_method = "6C1825C42631AE6FCE57D0240C5D762E", hash_generated_method = "C0A2F3211F41F689D452EE09981B4771")
    
private void postBindPreferences() {
        if (mHandler.hasMessages(MSG_BIND_PREFERENCES)) return;
        mHandler.obtainMessage(MSG_BIND_PREFERENCES).sendToTarget();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.665 -0500", hash_original_method = "548F27FE8CA6D6649BD8B5A7939C474E", hash_generated_method = "FD6B5E4440D382E9C6526DFCBE9F884F")
    
private void bindPreferences() {
        final PreferenceScreen preferenceScreen = getPreferenceScreen();
        if (preferenceScreen != null) {
            preferenceScreen.bind(getListView());
            if (mSavedInstanceState != null) {
                super.onRestoreInstanceState(mSavedInstanceState);
                mSavedInstanceState = null;
            }
        }
    }

    /**
     * Returns the {@link PreferenceManager} used by this activity.
     * @return The {@link PreferenceManager}.
     *
     * @deprecated This function is not relevant for a modern fragment-based
     * PreferenceActivity.
     */
    @DSComment("Android Manager retrieved/accessed")
    @DSSpec(DSCat.ANDROID_MANAGER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.667 -0500", hash_original_method = "002FC5CEE5BE5B5D1FE36CEDBC1DEB65", hash_generated_method = "606CF70C7776240D74182A497A612E24")
    
@Deprecated
    public PreferenceManager getPreferenceManager() {
        return mPreferenceManager;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.669 -0500", hash_original_method = "B2669BE6B91E4B8BF7765D817C0F2C8A", hash_generated_method = "79E45405A5E3BB0CB046DCF04639395D")
    
private void requirePreferenceManager() {
        if (mPreferenceManager == null) {
            if (mAdapter == null) {
                throw new RuntimeException("This should be called after super.onCreate.");
            }
            throw new RuntimeException(
                    "Modern two-pane PreferenceActivity requires use of a PreferenceFragment");
        }
    }

    /**
     * Sets the root of the preference hierarchy that this activity is showing.
     *
     * @param preferenceScreen The root {@link PreferenceScreen} of the preference hierarchy.
     *
     * @deprecated This function is not relevant for a modern fragment-based
     * PreferenceActivity.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.671 -0500", hash_original_method = "20BEF3079E316F6730A81E488DFA70F2", hash_generated_method = "CB73D3B03400881BC7A95FC5A764F2C8")
    
@Deprecated
    public void setPreferenceScreen(PreferenceScreen preferenceScreen) {
        requirePreferenceManager();

        if (mPreferenceManager.setPreferences(preferenceScreen) && preferenceScreen != null) {
            postBindPreferences();
            CharSequence title = getPreferenceScreen().getTitle();
            // Set the title of the activity
            if (title != null) {
                setTitle(title);
            }
        }
    }

    /**
     * Gets the root of the preference hierarchy that this activity is showing.
     *
     * @return The {@link PreferenceScreen} that is the root of the preference
     *         hierarchy.
     *
     * @deprecated This function is not relevant for a modern fragment-based
     * PreferenceActivity.
     */
    @DSComment("General android operation, no security concern")
    @DSSafe(DSCat.OS_GENERAL)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.674 -0500", hash_original_method = "7CC03E7D3EBAF4E1E382E9E7A55EF0AE", hash_generated_method = "FA685498E0CC32F1C045DBDEE416C01B")
    
@Deprecated
    public PreferenceScreen getPreferenceScreen() {
        if (mPreferenceManager != null) {
            return mPreferenceManager.getPreferenceScreen();
        }
        return null;
    }

    /**
     * Adds preferences from activities that match the given {@link Intent}.
     *
     * @param intent The {@link Intent} to query activities.
     *
     * @deprecated This function is not relevant for a modern fragment-based
     * PreferenceActivity.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.676 -0500", hash_original_method = "5674CE8C214451535BFAB18211614C8C", hash_generated_method = "F5A08D3E68D7C18F44CC6234DE2C796C")
    
@Deprecated
    public void addPreferencesFromIntent(Intent intent) {
        requirePreferenceManager();

        setPreferenceScreen(mPreferenceManager.inflateFromIntent(intent, getPreferenceScreen()));
    }

    /**
     * Inflates the given XML resource and adds the preference hierarchy to the current
     * preference hierarchy.
     *
     * @param preferencesResId The XML resource ID to inflate.
     *
     * @deprecated This function is not relevant for a modern fragment-based
     * PreferenceActivity.
     */
    @DSComment("General android operation, no security concern")
    @DSSafe(DSCat.OS_GENERAL)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.678 -0500", hash_original_method = "1D27A71B873F6C05FF2DA5D8C133ED30", hash_generated_method = "A72CCF4B5AF9FDD5731F350455BAC101")
    
@Deprecated
    public void addPreferencesFromResource(int preferencesResId) {
        requirePreferenceManager();

        setPreferenceScreen(mPreferenceManager.inflateFromResource(this, preferencesResId,
                getPreferenceScreen()));
    }

    /**
     * {@inheritDoc}
     *
     * @deprecated This function is not relevant for a modern fragment-based
     * PreferenceActivity.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.681 -0500", hash_original_method = "ADC2C8250ACD9F9573CD9A45AF1661C3", hash_generated_method = "3398DD08B181ADA01EFDFE3261598757")
    
@Deprecated
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
        return false;
    }

    /**
     * Finds a {@link Preference} based on its key.
     *
     * @param key The key of the preference to retrieve.
     * @return The {@link Preference} with the key, or null.
     * @see PreferenceGroup#findPreference(CharSequence)
     *
     * @deprecated This function is not relevant for a modern fragment-based
     * PreferenceActivity.
     */
    @DSComment("General android operation, no security concern")
    @DSSafe(DSCat.OS_GENERAL)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.683 -0500", hash_original_method = "0C794FFD7CBFBB35093DF6CE24875508", hash_generated_method = "378655292483895DBE1C27B8BA6DA4B5")
    
@Deprecated
    public Preference findPreference(CharSequence key) {

        if (mPreferenceManager == null) {
            return null;
        }

        return mPreferenceManager.findPreference(key);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.685 -0500", hash_original_method = "5A6127558FF9D60C52821F59A1A351C3", hash_generated_method = "A3CCA1639D56932850641C74B8B2F3DE")
    
@Override
    protected void onNewIntent(Intent intent) {
        if (mPreferenceManager != null) {
            mPreferenceManager.dispatchNewIntent(intent);
        }
    }

    // give subclasses access to the Next button
    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.687 -0500", hash_original_method = "BC54EB6D436D19F86F3C9657BD0BE1AA", hash_generated_method = "C4FB7C7A885EB2EC797C2D66128C515B")
    
protected boolean hasNextButton() {
        return mNextButton != null;
    }
    /** @hide */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:24.689 -0500", hash_original_method = "CC6F0F14612F322772A46478BA75E81F", hash_generated_method = "469B44BBEFA1C18D487E69314CE28ED4")
    
protected Button getNextButton() {
        return mNextButton;
    }
}

