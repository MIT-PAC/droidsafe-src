package android.preference;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
import java.util.List;

public abstract class PreferenceActivity extends ListActivity implements PreferenceManager.OnPreferenceTreeClickListener, PreferenceFragment.OnPreferenceStartFragmentCallback {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.878 -0400", hash_original_field = "B4437D0EBCCFE94A5CAF24979E87BFF3", hash_generated_field = "901091A9FFD11A2CE9C4A230BC7853B9")

    private ArrayList<Header> mHeaders = new ArrayList<Header>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.878 -0400", hash_original_field = "2F6930B6C645E4D8ACA3F8AB58293E8F", hash_generated_field = "FD5AB4D46307B27E8B131FCC69B56024")

    private FrameLayout mListFooter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.878 -0400", hash_original_field = "4869BE0BA3554EC728CBE9D046D8CE8D", hash_generated_field = "7F048D850CFE3A627851CBB7E986274C")

    private ViewGroup mPrefsContainer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.879 -0400", hash_original_field = "57396922F5B63ED226B6755FB75B8ABD", hash_generated_field = "C9A9E888C6CF8869C49ADC5AA023A69B")

    private FragmentBreadCrumbs mFragmentBreadCrumbs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.879 -0400", hash_original_field = "A766A90F5B30D5F0A747208880E91C20", hash_generated_field = "A5B8DDF0DF04B9985F211EFD1518F984")

    private boolean mSinglePane;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.879 -0400", hash_original_field = "B922356C2BC86CDD61900AA9E1D0840F", hash_generated_field = "801A7E2120484101CEC1CFAD107C2A9C")

    private Header mCurHeader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.879 -0400", hash_original_field = "D1487CA8252F4AA0A95324AB4DDD5316", hash_generated_field = "13262EB3751B753EEB3302EF75D8B1E5")

    private PreferenceManager mPreferenceManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.879 -0400", hash_original_field = "A587E455CA5C0B536357B11202A985DD", hash_generated_field = "04DDA78321A9F720FA97A23B9C869D4C")

    private Bundle mSavedInstanceState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.879 -0400", hash_original_field = "25A8D69C909160605880E75D8AC0CC0C", hash_generated_field = "128183E1ED5B562A53AAED4DF9F0640D")

    private Button mNextButton;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.887 -0400", hash_original_field = "92EE827C36817A69E1CF224FB382CB43", hash_generated_field = "7D3129EB8E32E9132E12E63BE3E8F7E1")

    private Handler mHandler = new Handler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.887 -0400", hash_original_method = "DC47A807DF4ECAC4EAC562CA0F303D11", hash_generated_method = "265480BC69D6FD0ECBB0FDF22CC62BB3")
        @Override
        public void handleMessage(Message msg) {
            //Begin case MSG_BIND_PREFERENCES 
            {
                bindPreferences();
            } //End block
            //End case MSG_BIND_PREFERENCES 
            //Begin case MSG_BUILD_HEADERS 
            {
                ArrayList<Header> oldHeaders;
                oldHeaders = new ArrayList<Header>(mHeaders);
                mHeaders.clear();
                onBuildHeaders(mHeaders);
                {
                    ((BaseAdapter) mAdapter).notifyDataSetChanged();
                } //End block
                Header header;
                header = onGetNewHeader();
                {
                    Header mappedHeader;
                    mappedHeader = findBestMatchingHeader(header, oldHeaders);
                    {
                        switchToHeader(header);
                    } //End block
                } //End block
                {
                    Header mappedHeader;
                    mappedHeader = findBestMatchingHeader(mCurHeader, mHeaders);
                    {
                        setSelectedHeader(mappedHeader);
                    } //End block
                } //End block
            } //End block
            //End case MSG_BUILD_HEADERS 
            addTaint(msg.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.888 -0400", hash_original_method = "5B933AEEC6389C71875EE2A57A875A3A", hash_generated_method = "5B933AEEC6389C71875EE2A57A875A3A")
    public PreferenceActivity ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.914 -0400", hash_original_method = "7377982A731D92C32EEEF871F40BFABD", hash_generated_method = "57862EB94DEF09906219B231A44E8254")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onCreate(savedInstanceState);
        setContentView(com.android.internal.R.layout.preference_list_content);
        mListFooter = (FrameLayout)findViewById(com.android.internal.R.id.list_footer);
        mPrefsContainer = (ViewGroup) findViewById(com.android.internal.R.id.prefs_frame);
        boolean hidingHeaders;
        hidingHeaders = onIsHidingHeaders();
        mSinglePane = hidingHeaders || !onIsMultiPane();
        String initialFragment;
        initialFragment = getIntent().getStringExtra(EXTRA_SHOW_FRAGMENT);
        Bundle initialArguments;
        initialArguments = getIntent().getBundleExtra(EXTRA_SHOW_FRAGMENT_ARGUMENTS);
        int initialTitle;
        initialTitle = getIntent().getIntExtra(EXTRA_SHOW_FRAGMENT_TITLE, 0);
        int initialShortTitle;
        initialShortTitle = getIntent().getIntExtra(EXTRA_SHOW_FRAGMENT_SHORT_TITLE, 0);
        {
            ArrayList<Header> headers;
            headers = savedInstanceState.getParcelableArrayList(HEADERS_TAG);
            {
                mHeaders.addAll(headers);
                int curHeader;
                curHeader = savedInstanceState.getInt(CUR_HEADER_TAG,
                        (int) HEADER_ID_UNDEFINED);
                {
                    boolean varD971D97B53AA0BC8D8587D6FE0840F58_2144748994 = (curHeader >= 0 && curHeader < mHeaders.size());
                    {
                        setSelectedHeader(mHeaders.get(curHeader));
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            {
                switchToHeader(initialFragment, initialArguments);
                {
                    CharSequence initialTitleStr;
                    initialTitleStr = getText(initialTitle);
                    CharSequence initialShortTitleStr;
                    initialShortTitleStr = getText(initialShortTitle);
                    initialShortTitleStr = null;
                    showBreadCrumbs(initialTitleStr, initialShortTitleStr);
                } //End block
            } //End block
            {
                onBuildHeaders(mHeaders);
                {
                    boolean var3C5C9122339EB6902CABDBBCEAC3E848_1845580485 = (mHeaders.size() > 0);
                    {
                        {
                            {
                                Header h;
                                h = onGetInitialHeader();
                                switchToHeader(h);
                            } //End block
                            {
                                switchToHeader(initialFragment, initialArguments);
                            } //End block
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            findViewById(com.android.internal.R.id.headers).setVisibility(View.GONE);
            mPrefsContainer.setVisibility(View.VISIBLE);
            {
                CharSequence initialTitleStr;
                initialTitleStr = getText(initialTitle);
                CharSequence initialShortTitleStr;
                initialShortTitleStr = getText(initialShortTitle);
                initialShortTitleStr = null;
                showBreadCrumbs(initialTitleStr, initialShortTitleStr);
            } //End block
        } //End block
        {
            boolean varC47E2037492266204268C44984CBA8D5_1753757863 = (mHeaders.size() > 0);
            {
                setListAdapter(new HeaderAdapter(this, mHeaders));
                {
                    getListView().setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
                    {
                        setSelectedHeader(mCurHeader);
                    } //End block
                    mPrefsContainer.setVisibility(View.VISIBLE);
                } //End block
            } //End block
            {
                setContentView(com.android.internal.R.layout.preference_list_content_single);
                mListFooter = (FrameLayout) findViewById(com.android.internal.R.id.list_footer);
                mPrefsContainer = (ViewGroup) findViewById(com.android.internal.R.id.prefs);
                mPreferenceManager = new PreferenceManager(this, FIRST_REQUEST_CODE);
                mPreferenceManager.setOnPreferenceTreeClickListener(this);
            } //End block
        } //End collapsed parenthetic
        Intent intent;
        intent = getIntent();
        {
            boolean var6B00C4D8B2C7FAD11C83CC1F266AECCB_119506619 = (intent.getBooleanExtra(EXTRA_PREFS_SHOW_BUTTON_BAR, false));
            {
                findViewById(com.android.internal.R.id.button_bar).setVisibility(View.VISIBLE);
                Button backButton;
                backButton = (Button)findViewById(com.android.internal.R.id.back_button);
                backButton.setOnClickListener(new OnClickListener() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.912 -0400", hash_original_method = "B6AEEA4CFEDD0D6DCDC87F0A632F7AF4", hash_generated_method = "B0B10E3119A72559C15D04B140EBDDAB")
                    public void onClick(View v) {
                        //DSFIXME:  CODE0009: Possible callback target function detected
                        setResult(RESULT_CANCELED);
                        finish();
                        addTaint(v.getTaint());
                        // ---------- Original Method ----------
                        //setResult(RESULT_CANCELED);
                        //finish();
                    }
});
                Button skipButton;
                skipButton = (Button)findViewById(com.android.internal.R.id.skip_button);
                skipButton.setOnClickListener(new OnClickListener() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.912 -0400", hash_original_method = "812DEADF112942F677940097DE15DE01", hash_generated_method = "A3397B80DD10207A45A973E88FAC70AD")
                    public void onClick(View v) {
                        //DSFIXME:  CODE0009: Possible callback target function detected
                        setResult(RESULT_OK);
                        finish();
                        addTaint(v.getTaint());
                        // ---------- Original Method ----------
                        //setResult(RESULT_OK);
                        //finish();
                    }
});
                mNextButton = (Button)findViewById(com.android.internal.R.id.next_button);
                mNextButton.setOnClickListener(new OnClickListener() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.913 -0400", hash_original_method = "812DEADF112942F677940097DE15DE01", hash_generated_method = "A3397B80DD10207A45A973E88FAC70AD")
                    public void onClick(View v) {
                        //DSFIXME:  CODE0009: Possible callback target function detected
                        setResult(RESULT_OK);
                        finish();
                        addTaint(v.getTaint());
                        // ---------- Original Method ----------
                        //setResult(RESULT_OK);
                        //finish();
                    }
});
                {
                    boolean varD8F09DEAA64F02CAA3B7761851A087BA_1239392711 = (intent.hasExtra(EXTRA_PREFS_SET_NEXT_TEXT));
                    {
                        String buttonText;
                        buttonText = intent.getStringExtra(EXTRA_PREFS_SET_NEXT_TEXT);
                        {
                            boolean varA83281A80E85198E02B69B5E2D604E2A_690437177 = (TextUtils.isEmpty(buttonText));
                            {
                                mNextButton.setVisibility(View.GONE);
                            } //End block
                            {
                                mNextButton.setText(buttonText);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var212B680940E2D8C079403373389F9963_1779848752 = (intent.hasExtra(EXTRA_PREFS_SET_BACK_TEXT));
                    {
                        String buttonText;
                        buttonText = intent.getStringExtra(EXTRA_PREFS_SET_BACK_TEXT);
                        {
                            boolean varA83281A80E85198E02B69B5E2D604E2A_566203153 = (TextUtils.isEmpty(buttonText));
                            {
                                backButton.setVisibility(View.GONE);
                            } //End block
                            {
                                backButton.setText(buttonText);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var5CF4482CBBF2E47E20FB0A5A85182C1D_81904937 = (intent.getBooleanExtra(EXTRA_PREFS_SHOW_SKIP, false));
                    {
                        skipButton.setVisibility(View.VISIBLE);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(savedInstanceState.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.915 -0400", hash_original_method = "451C86882BCD1F18856FAB1FCF2DF436", hash_generated_method = "D28155EBE267FB2640872B70D7EEA1BC")
    public boolean hasHeaders() {
        boolean var2793A1F83EB46403278370A572A342A3_921173929 = (getListView().getVisibility() == View.VISIBLE
                && mPreferenceManager == null);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1062026133 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1062026133;
        // ---------- Original Method ----------
        //return getListView().getVisibility() == View.VISIBLE
                //&& mPreferenceManager == null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.935 -0400", hash_original_method = "E843412269C4B791D4D2B897726E7F84", hash_generated_method = "252480762A803FE546F938AE9C52BE20")
    public boolean isMultiPane() {
        boolean var6FA4B253B6861D383ED2CA9AF2933EFC_486486917 = (hasHeaders() && mPrefsContainer.getVisibility() == View.VISIBLE);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_568167241 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_568167241;
        // ---------- Original Method ----------
        //return hasHeaders() && mPrefsContainer.getVisibility() == View.VISIBLE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.935 -0400", hash_original_method = "88171EFEE6286ACCEFBDA2CCA56DC062", hash_generated_method = "A501380D12838E915EF16272D1EF27BC")
    public boolean onIsMultiPane() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        boolean preferMultiPane;
        preferMultiPane = getResources().getBoolean(
                com.android.internal.R.bool.preferences_prefer_dual_pane);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_245565797 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_245565797;
        // ---------- Original Method ----------
        //boolean preferMultiPane = getResources().getBoolean(
                //com.android.internal.R.bool.preferences_prefer_dual_pane);
        //return preferMultiPane;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.936 -0400", hash_original_method = "6AB6F840F5A47C64B3086422C8E885E0", hash_generated_method = "DC73DEA223BEFB0C7BF82EF1EE270992")
    public boolean onIsHidingHeaders() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        boolean varF3070E6C30B8A57340493B81FC01958C_216655293 = (getIntent().getBooleanExtra(EXTRA_NO_HEADERS, false));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1006833219 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1006833219;
        // ---------- Original Method ----------
        //return getIntent().getBooleanExtra(EXTRA_NO_HEADERS, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.937 -0400", hash_original_method = "106989DF67000CA038D75C5F0732B905", hash_generated_method = "44B27BB686C6273E5EF12AA2B131FAD5")
    public Header onGetInitialHeader() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Header varB4EAC82CA7396A68D541C85D26508E83_1835008979 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1835008979 = mHeaders.get(0);
        varB4EAC82CA7396A68D541C85D26508E83_1835008979.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1835008979;
        // ---------- Original Method ----------
        //return mHeaders.get(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.937 -0400", hash_original_method = "3D3F0DDAE644689D05411BA38FC63FD0", hash_generated_method = "878D21D1A6736EDFE86C985D0B24C6B3")
    public Header onGetNewHeader() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Header varB4EAC82CA7396A68D541C85D26508E83_1225653784 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1225653784 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1225653784.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1225653784;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.938 -0400", hash_original_method = "2E92E1B9DF373424BC377EC8A240659F", hash_generated_method = "F45695A5F2F86F35BBA19C4D3E46F18D")
    public void onBuildHeaders(List<Header> target) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(target.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.939 -0400", hash_original_method = "F909FF4426F024059C8CEA2BE75ABFBE", hash_generated_method = "16FC237C4820C71139000CC7CB0FB05C")
    public void invalidateHeaders() {
        {
            boolean var15FECD8C7CC36B9F24D51671998B7A8D_960407103 = (!mHandler.hasMessages(MSG_BUILD_HEADERS));
            {
                mHandler.sendEmptyMessage(MSG_BUILD_HEADERS);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!mHandler.hasMessages(MSG_BUILD_HEADERS)) {
            //mHandler.sendEmptyMessage(MSG_BUILD_HEADERS);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.972 -0400", hash_original_method = "004FDF3B00128708010F53C563B52195", hash_generated_method = "EBCDF3960CE8B328CB01794438EA8E6D")
    public void loadHeadersFromResource(int resid, List<Header> target) {
        XmlResourceParser parser;
        parser = null;
        try 
        {
            parser = getResources().getXml(resid);
            AttributeSet attrs;
            attrs = Xml.asAttributeSet(parser);
            int type;
            {
                boolean var995057C222283DCE9E465AE35974357A_546020060 = ((type=parser.next()) != XmlPullParser.END_DOCUMENT
                    && type != XmlPullParser.START_TAG);
            } //End collapsed parenthetic
            String nodeName;
            nodeName = parser.getName();
            {
                boolean var40E6A369503F37C37F39656021C225B0_320749208 = (!"preference-headers".equals(nodeName));
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                        "XML document must start with <preference-headers> tag; found"
                        + nodeName + " at " + parser.getPositionDescription());
                } //End block
            } //End collapsed parenthetic
            Bundle curBundle;
            curBundle = null;
            int outerDepth;
            outerDepth = parser.getDepth();
            {
                boolean var8956F460685E7D17F4EB87103FD834D7_1570629908 = ((type=parser.next()) != XmlPullParser.END_DOCUMENT
                   && (type != XmlPullParser.END_TAG || parser.getDepth() > outerDepth));
                {
                    nodeName = parser.getName();
                    {
                        boolean var3960BA89728D7772E92DE81F9AEA2B8A_1054687378 = ("header".equals(nodeName));
                        {
                            Header header;
                            header = new Header();
                            TypedArray sa;
                            sa = getResources().obtainAttributes(attrs,
                            com.android.internal.R.styleable.PreferenceHeader);
                            header.id = sa.getResourceId(
                            com.android.internal.R.styleable.PreferenceHeader_id,
                            (int)HEADER_ID_UNDEFINED);
                            TypedValue tv;
                            tv = sa.peekValue(
                            com.android.internal.R.styleable.PreferenceHeader_title);
                            {
                                {
                                    header.titleRes = tv.resourceId;
                                } //End block
                                {
                                    header.title = tv.string;
                                } //End block
                            } //End block
                            tv = sa.peekValue(
                            com.android.internal.R.styleable.PreferenceHeader_summary);
                            {
                                {
                                    header.summaryRes = tv.resourceId;
                                } //End block
                                {
                                    header.summary = tv.string;
                                } //End block
                            } //End block
                            tv = sa.peekValue(
                            com.android.internal.R.styleable.PreferenceHeader_breadCrumbTitle);
                            {
                                {
                                    header.breadCrumbTitleRes = tv.resourceId;
                                } //End block
                                {
                                    header.breadCrumbTitle = tv.string;
                                } //End block
                            } //End block
                            tv = sa.peekValue(
                            com.android.internal.R.styleable.PreferenceHeader_breadCrumbShortTitle);
                            {
                                {
                                    header.breadCrumbShortTitleRes = tv.resourceId;
                                } //End block
                                {
                                    header.breadCrumbShortTitle = tv.string;
                                } //End block
                            } //End block
                            header.iconRes = sa.getResourceId(
                            com.android.internal.R.styleable.PreferenceHeader_icon, 0);
                            header.fragment = sa.getString(
                            com.android.internal.R.styleable.PreferenceHeader_fragment);
                            sa.recycle();
                            {
                                curBundle = new Bundle();
                            } //End block
                            int innerDepth;
                            innerDepth = parser.getDepth();
                            {
                                boolean var554531EF1BF3152A9E18038DDC877C21_494867528 = ((type=parser.next()) != XmlPullParser.END_DOCUMENT
                           && (type != XmlPullParser.END_TAG || parser.getDepth() > innerDepth));
                                {
                                    String innerNodeName;
                                    innerNodeName = parser.getName();
                                    {
                                        boolean var74DE697D83642086363AEB84579A347D_1334186372 = (innerNodeName.equals("extra"));
                                        {
                                            getResources().parseBundleExtra("extra", attrs, curBundle);
                                            XmlUtils.skipCurrentTag(parser);
                                        } //End block
                                        {
                                            boolean var0397BC68DE863D781A6C34BDE10D80E3_893650589 = (innerNodeName.equals("intent"));
                                            {
                                                header.intent = Intent.parseIntent(getResources(), parser, attrs);
                                            } //End block
                                            {
                                                XmlUtils.skipCurrentTag(parser);
                                            } //End block
                                        } //End collapsed parenthetic
                                    } //End collapsed parenthetic
                                } //End block
                            } //End collapsed parenthetic
                            {
                                boolean var50D670F336750E2E523F404128E754B7_1550904080 = (curBundle.size() > 0);
                                {
                                    header.fragmentArguments = curBundle;
                                    curBundle = null;
                                } //End block
                            } //End collapsed parenthetic
                            target.add(header);
                        } //End block
                        {
                            XmlUtils.skipCurrentTag(parser);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (XmlPullParserException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Error parsing headers", e);
        } //End block
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Error parsing headers", e);
        } //End block
        finally 
        {
            parser.close();
        } //End block
        addTaint(resid);
        addTaint(target.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.973 -0400", hash_original_method = "0C226BA6EB709C0B8BDD6989275021F7", hash_generated_method = "60C6F75401B75C3D68FF18F76EA87C6B")
    public void setListFooter(View view) {
        mListFooter.removeAllViews();
        mListFooter.addView(view, new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.WRAP_CONTENT));
        addTaint(view.getTaint());
        // ---------- Original Method ----------
        //mListFooter.removeAllViews();
        //mListFooter.addView(view, new FrameLayout.LayoutParams(
                //FrameLayout.LayoutParams.MATCH_PARENT,
                //FrameLayout.LayoutParams.WRAP_CONTENT));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.987 -0400", hash_original_method = "5055AD43F70FAF224ADCBC793E0582D3", hash_generated_method = "A90604FCE63812931DB95980487BC552")
    @Override
    protected void onStop() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onStop();
        {
            mPreferenceManager.dispatchActivityStop();
        } //End block
        // ---------- Original Method ----------
        //super.onStop();
        //if (mPreferenceManager != null) {
            //mPreferenceManager.dispatchActivityStop();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.988 -0400", hash_original_method = "015EB586B516E4BA63E47DF2D2F941B5", hash_generated_method = "C72394E9CC1E3C1FA20099DB7C625F82")
    @Override
    protected void onDestroy() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onDestroy();
        {
            mPreferenceManager.dispatchActivityDestroy();
        } //End block
        // ---------- Original Method ----------
        //super.onDestroy();
        //if (mPreferenceManager != null) {
            //mPreferenceManager.dispatchActivityDestroy();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.989 -0400", hash_original_method = "1A457C81CAD07F8216A55B906C01B0EE", hash_generated_method = "463AB16F6E5EEB97DB12FB6EEFF8A3DF")
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onSaveInstanceState(outState);
        {
            boolean varC47E2037492266204268C44984CBA8D5_374764053 = (mHeaders.size() > 0);
            {
                outState.putParcelableArrayList(HEADERS_TAG, mHeaders);
                {
                    int index;
                    index = mHeaders.indexOf(mCurHeader);
                    {
                        outState.putInt(CUR_HEADER_TAG, index);
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            PreferenceScreen preferenceScreen;
            preferenceScreen = getPreferenceScreen();
            {
                Bundle container;
                container = new Bundle();
                preferenceScreen.saveHierarchyState(container);
                outState.putBundle(PREFERENCES_TAG, container);
            } //End block
        } //End block
        addTaint(outState.getTaint());
        // ---------- Original Method ----------
        //super.onSaveInstanceState(outState);
        //if (mHeaders.size() > 0) {
            //outState.putParcelableArrayList(HEADERS_TAG, mHeaders);
            //if (mCurHeader != null) {
                //int index = mHeaders.indexOf(mCurHeader);
                //if (index >= 0) {
                    //outState.putInt(CUR_HEADER_TAG, index);
                //}
            //}
        //}
        //if (mPreferenceManager != null) {
            //final PreferenceScreen preferenceScreen = getPreferenceScreen();
            //if (preferenceScreen != null) {
                //Bundle container = new Bundle();
                //preferenceScreen.saveHierarchyState(container);
                //outState.putBundle(PREFERENCES_TAG, container);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.989 -0400", hash_original_method = "3A902C5AADE0A248676EF9D6166BBE53", hash_generated_method = "B401BAB5E5B61E63A5DE7C63DAEB8E88")
    @Override
    protected void onRestoreInstanceState(Bundle state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            Bundle container;
            container = state.getBundle(PREFERENCES_TAG);
            {
                PreferenceScreen preferenceScreen;
                preferenceScreen = getPreferenceScreen();
                {
                    preferenceScreen.restoreHierarchyState(container);
                    mSavedInstanceState = state;
                } //End block
            } //End block
        } //End block
        super.onRestoreInstanceState(state);
        // ---------- Original Method ----------
        //if (mPreferenceManager != null) {
            //Bundle container = state.getBundle(PREFERENCES_TAG);
            //if (container != null) {
                //final PreferenceScreen preferenceScreen = getPreferenceScreen();
                //if (preferenceScreen != null) {
                    //preferenceScreen.restoreHierarchyState(container);
                    //mSavedInstanceState = state;
                    //return;
                //}
            //}
        //}
        //super.onRestoreInstanceState(state);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.990 -0400", hash_original_method = "BC5669EA98C9095AD4591AFCBD99CE20", hash_generated_method = "2AEBE14919F34D41BF0961BCD39F29A4")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onActivityResult(requestCode, resultCode, data);
        {
            mPreferenceManager.dispatchActivityResult(requestCode, resultCode, data);
        } //End block
        addTaint(requestCode);
        addTaint(resultCode);
        addTaint(data.getTaint());
        // ---------- Original Method ----------
        //super.onActivityResult(requestCode, resultCode, data);
        //if (mPreferenceManager != null) {
            //mPreferenceManager.dispatchActivityResult(requestCode, resultCode, data);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:29.990 -0400", hash_original_method = "B413EAEA105506529AB09785B80740F7", hash_generated_method = "4E2B368FDE2D7213D07B0E0E26C29B19")
    @Override
    public void onContentChanged() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onContentChanged();
        {
            postBindPreferences();
        } //End block
        // ---------- Original Method ----------
        //super.onContentChanged();
        //if (mPreferenceManager != null) {
            //postBindPreferences();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.005 -0400", hash_original_method = "32CF46DB4065373D899344EB4B5785F0", hash_generated_method = "FFCD589B143D35DFB9A82550E081412B")
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onListItemClick(l, v, position, id);
        {
            Object item;
            item = mAdapter.getItem(position);
            onHeaderClick((Header) item, position);
        } //End block
        addTaint(l.getTaint());
        addTaint(v.getTaint());
        addTaint(position);
        addTaint(id);
        // ---------- Original Method ----------
        //super.onListItemClick(l, v, position, id);
        //if (mAdapter != null) {
            //Object item = mAdapter.getItem(position);
            //if (item instanceof Header) onHeaderClick((Header) item, position);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.006 -0400", hash_original_method = "41F78ADB739893E8265A1748D8E017F7", hash_generated_method = "4A1873CAC30118CB19DBCB480FB0218A")
    public void onHeaderClick(Header header, int position) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            {
                int titleRes;
                titleRes = header.breadCrumbTitleRes;
                int shortTitleRes;
                shortTitleRes = header.breadCrumbShortTitleRes;
                {
                    titleRes = header.titleRes;
                    shortTitleRes = 0;
                } //End block
                startWithFragment(header.fragment, header.fragmentArguments, null, 0,
                        titleRes, shortTitleRes);
            } //End block
            {
                switchToHeader(header);
            } //End block
        } //End block
        {
            startActivity(header.intent);
        } //End block
        addTaint(header.getTaint());
        addTaint(position);
        // ---------- Original Method ----------
        //if (header.fragment != null) {
            //if (mSinglePane) {
                //int titleRes = header.breadCrumbTitleRes;
                //int shortTitleRes = header.breadCrumbShortTitleRes;
                //if (titleRes == 0) {
                    //titleRes = header.titleRes;
                    //shortTitleRes = 0;
                //}
                //startWithFragment(header.fragment, header.fragmentArguments, null, 0,
                        //titleRes, shortTitleRes);
            //} else {
                //switchToHeader(header);
            //}
        //} else if (header.intent != null) {
            //startActivity(header.intent);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.007 -0400", hash_original_method = "B5DA23DDC47E44587D99F550083B256B", hash_generated_method = "A41FC5B0C81DCFE41AD241B380B50991")
    public Intent onBuildStartFragmentIntent(String fragmentName, Bundle args,
            int titleRes, int shortTitleRes) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Intent varB4EAC82CA7396A68D541C85D26508E83_944550784 = null; //Variable for return #1
        Intent intent;
        intent = new Intent(Intent.ACTION_MAIN);
        intent.setClass(this, getClass());
        intent.putExtra(EXTRA_SHOW_FRAGMENT, fragmentName);
        intent.putExtra(EXTRA_SHOW_FRAGMENT_ARGUMENTS, args);
        intent.putExtra(EXTRA_SHOW_FRAGMENT_TITLE, titleRes);
        intent.putExtra(EXTRA_SHOW_FRAGMENT_SHORT_TITLE, shortTitleRes);
        intent.putExtra(EXTRA_NO_HEADERS, true);
        varB4EAC82CA7396A68D541C85D26508E83_944550784 = intent;
        addTaint(fragmentName.getTaint());
        addTaint(args.getTaint());
        addTaint(titleRes);
        addTaint(shortTitleRes);
        varB4EAC82CA7396A68D541C85D26508E83_944550784.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_944550784;
        // ---------- Original Method ----------
        //Intent intent = new Intent(Intent.ACTION_MAIN);
        //intent.setClass(this, getClass());
        //intent.putExtra(EXTRA_SHOW_FRAGMENT, fragmentName);
        //intent.putExtra(EXTRA_SHOW_FRAGMENT_ARGUMENTS, args);
        //intent.putExtra(EXTRA_SHOW_FRAGMENT_TITLE, titleRes);
        //intent.putExtra(EXTRA_SHOW_FRAGMENT_SHORT_TITLE, shortTitleRes);
        //intent.putExtra(EXTRA_NO_HEADERS, true);
        //return intent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.007 -0400", hash_original_method = "7A5ABD7084FE456D2AC9E7363F23F617", hash_generated_method = "896974140AC0AE3C321B30A73585FD7E")
    public void startWithFragment(String fragmentName, Bundle args,
            Fragment resultTo, int resultRequestCode) {
        startWithFragment(fragmentName, args, resultTo, resultRequestCode, 0, 0);
        addTaint(fragmentName.getTaint());
        addTaint(args.getTaint());
        addTaint(resultTo.getTaint());
        addTaint(resultRequestCode);
        // ---------- Original Method ----------
        //startWithFragment(fragmentName, args, resultTo, resultRequestCode, 0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.030 -0400", hash_original_method = "A8702F14B58AAD20058746FC81F4589D", hash_generated_method = "D7ED6B509E3B18B47520A7ECEBF7BC95")
    public void startWithFragment(String fragmentName, Bundle args,
            Fragment resultTo, int resultRequestCode, int titleRes, int shortTitleRes) {
        Intent intent;
        intent = onBuildStartFragmentIntent(fragmentName, args, titleRes, shortTitleRes);
        {
            startActivity(intent);
        } //End block
        {
            resultTo.startActivityForResult(intent, resultRequestCode);
        } //End block
        addTaint(fragmentName.getTaint());
        addTaint(args.getTaint());
        addTaint(resultTo.getTaint());
        addTaint(resultRequestCode);
        addTaint(titleRes);
        addTaint(shortTitleRes);
        // ---------- Original Method ----------
        //Intent intent = onBuildStartFragmentIntent(fragmentName, args, titleRes, shortTitleRes);
        //if (resultTo == null) {
            //startActivity(intent);
        //} else {
            //resultTo.startActivityForResult(intent, resultRequestCode);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.031 -0400", hash_original_method = "4F3C5CDBD4880824AF39CB9E5E4A33FC", hash_generated_method = "C7717C96A6F34BCA1AF9F4F860E22029")
    public void showBreadCrumbs(CharSequence title, CharSequence shortTitle) {
        {
            View crumbs;
            crumbs = findViewById(android.R.id.title);
            try 
            {
                mFragmentBreadCrumbs = (FragmentBreadCrumbs)crumbs;
            } //End block
            catch (ClassCastException e)
            { }
            {
                {
                    setTitle(title);
                } //End block
            } //End block
            mFragmentBreadCrumbs.setMaxVisible(2);
            mFragmentBreadCrumbs.setActivity(this);
        } //End block
        mFragmentBreadCrumbs.setTitle(title, shortTitle);
        mFragmentBreadCrumbs.setParentTitle(null, null, null);
        addTaint(title.getTaint());
        addTaint(shortTitle.getTaint());
        // ---------- Original Method ----------
        //if (mFragmentBreadCrumbs == null) {
            //View crumbs = findViewById(android.R.id.title);
            //try {
                //mFragmentBreadCrumbs = (FragmentBreadCrumbs)crumbs;
            //} catch (ClassCastException e) {
                //return;
            //}
            //if (mFragmentBreadCrumbs == null) {
                //if (title != null) {
                    //setTitle(title);
                //}
                //return;
            //}
            //mFragmentBreadCrumbs.setMaxVisible(2);
            //mFragmentBreadCrumbs.setActivity(this);
        //}
        //mFragmentBreadCrumbs.setTitle(title, shortTitle);
        //mFragmentBreadCrumbs.setParentTitle(null, null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.031 -0400", hash_original_method = "1549DF3FA5C3B3F8F6931C4E058E1944", hash_generated_method = "6AA3BF014DB67A933D14B4A9B3EF7856")
    public void setParentTitle(CharSequence title, CharSequence shortTitle,
            OnClickListener listener) {
        {
            mFragmentBreadCrumbs.setParentTitle(title, shortTitle, listener);
        } //End block
        addTaint(title.getTaint());
        addTaint(shortTitle.getTaint());
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //if (mFragmentBreadCrumbs != null) {
            //mFragmentBreadCrumbs.setParentTitle(title, shortTitle, listener);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.039 -0400", hash_original_method = "6CD55A84320A14788B0DD27C2F943CD9", hash_generated_method = "2EE77195C3A7B8DDD02AE7993CED5FA9")
     void setSelectedHeader(Header header) {
        mCurHeader = header;
        int index;
        index = mHeaders.indexOf(header);
        {
            getListView().setItemChecked(index, true);
        } //End block
        {
            getListView().clearChoices();
        } //End block
        showBreadCrumbs(header);
        // ---------- Original Method ----------
        //mCurHeader = header;
        //int index = mHeaders.indexOf(header);
        //if (index >= 0) {
            //getListView().setItemChecked(index, true);
        //} else {
            //getListView().clearChoices();
        //}
        //showBreadCrumbs(header);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.041 -0400", hash_original_method = "DBABA4F3A7CA13D3BE4599BE843A33E0", hash_generated_method = "B670761857F56D256FCA86E8EECFD8CD")
     void showBreadCrumbs(Header header) {
        {
            CharSequence title;
            title = header.getBreadCrumbTitle(getResources());
            title = header.getTitle(getResources());
            title = getTitle();
            showBreadCrumbs(title, header.getBreadCrumbShortTitle(getResources()));
        } //End block
        {
            showBreadCrumbs(getTitle(), null);
        } //End block
        addTaint(header.getTaint());
        // ---------- Original Method ----------
        //if (header != null) {
            //CharSequence title = header.getBreadCrumbTitle(getResources());
            //if (title == null) title = header.getTitle(getResources());
            //if (title == null) title = getTitle();
            //showBreadCrumbs(title, header.getBreadCrumbShortTitle(getResources()));
        //} else {
            //showBreadCrumbs(getTitle(), null);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.043 -0400", hash_original_method = "7A46889D874DD705E59FA4FB1509394D", hash_generated_method = "C3E0677412F7C0DB10F3A020CFA6931A")
    private void switchToHeaderInner(String fragmentName, Bundle args, int direction) {
        getFragmentManager().popBackStack(BACK_STACK_PREFS,
                FragmentManager.POP_BACK_STACK_INCLUSIVE);
        Fragment f;
        f = Fragment.instantiate(this, fragmentName, args);
        FragmentTransaction transaction;
        transaction = getFragmentManager().beginTransaction();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        transaction.replace(com.android.internal.R.id.prefs, f);
        transaction.commitAllowingStateLoss();
        addTaint(fragmentName.getTaint());
        addTaint(args.getTaint());
        addTaint(direction);
        // ---------- Original Method ----------
        //getFragmentManager().popBackStack(BACK_STACK_PREFS,
                //FragmentManager.POP_BACK_STACK_INCLUSIVE);
        //Fragment f = Fragment.instantiate(this, fragmentName, args);
        //FragmentTransaction transaction = getFragmentManager().beginTransaction();
        //transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        //transaction.replace(com.android.internal.R.id.prefs, f);
        //transaction.commitAllowingStateLoss();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.057 -0400", hash_original_method = "1F3D49C208A22CE80DD0C39318B7FB91", hash_generated_method = "099C14639DAE655741E9D9D13E0A37A9")
    public void switchToHeader(String fragmentName, Bundle args) {
        setSelectedHeader(null);
        switchToHeaderInner(fragmentName, args, 0);
        addTaint(fragmentName.getTaint());
        addTaint(args.getTaint());
        // ---------- Original Method ----------
        //setSelectedHeader(null);
        //switchToHeaderInner(fragmentName, args, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.058 -0400", hash_original_method = "439F40B8AE0DFA06D4CE3EB843023A82", hash_generated_method = "119AC978ED9EED79F978736F27D33895")
    public void switchToHeader(Header header) {
        {
            getFragmentManager().popBackStack(BACK_STACK_PREFS,
                    FragmentManager.POP_BACK_STACK_INCLUSIVE);
        } //End block
        {
            int direction;
            direction = mHeaders.indexOf(header) - mHeaders.indexOf(mCurHeader);
            switchToHeaderInner(header.fragment, header.fragmentArguments, direction);
            setSelectedHeader(header);
        } //End block
        addTaint(header.getTaint());
        // ---------- Original Method ----------
        //if (mCurHeader == header) {
            //getFragmentManager().popBackStack(BACK_STACK_PREFS,
                    //FragmentManager.POP_BACK_STACK_INCLUSIVE);
        //} else {
            //int direction = mHeaders.indexOf(header) - mHeaders.indexOf(mCurHeader);
            //switchToHeaderInner(header.fragment, header.fragmentArguments, direction);
            //setSelectedHeader(header);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.064 -0400", hash_original_method = "A27B5089D7C34DCC8F697434FD74BDF2", hash_generated_method = "0B0CADF12A8FC60805F0CF2857AD6FE1")
     Header findBestMatchingHeader(Header cur, ArrayList<Header> from) {
        Header varB4EAC82CA7396A68D541C85D26508E83_518028315 = null; //Variable for return #1
        Header varB4EAC82CA7396A68D541C85D26508E83_1174511219 = null; //Variable for return #2
        Header varB4EAC82CA7396A68D541C85D26508E83_1999966110 = null; //Variable for return #3
        Header varB4EAC82CA7396A68D541C85D26508E83_613384514 = null; //Variable for return #4
        Header varB4EAC82CA7396A68D541C85D26508E83_1464686602 = null; //Variable for return #5
        ArrayList<Header> matches;
        matches = new ArrayList<Header>();
        {
            int j;
            j = 0;
            boolean varD2B83A07940AD2FCC09DE02F8C6611C9_123227020 = (j<from.size());
            {
                Header oh;
                oh = from.get(j);
                {
                    matches.clear();
                    matches.add(oh);
                } //End block
                {
                    {
                        boolean varB609688441FFD779964D632A69036A70_1579270366 = (cur.fragment.equals(oh.fragment));
                        {
                            matches.add(oh);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    {
                        boolean var06842B930564AE514F8A239E6992E155_1314433388 = (cur.intent.equals(oh.intent));
                        {
                            matches.add(oh);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    {
                        boolean var4A426A86AF313259696B16DB6F4D6498_1088352735 = (cur.title.equals(oh.title));
                        {
                            matches.add(oh);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End collapsed parenthetic
        int NM;
        NM = matches.size();
        {
            varB4EAC82CA7396A68D541C85D26508E83_518028315 = matches.get(0);
        } //End block
        {
            {
                int j;
                j = 0;
                {
                    Header oh;
                    oh = matches.get(j);
                    {
                        boolean var98CA1E00A10F515D2E57E097A1D05BB9_713511104 = (cur.fragmentArguments != null &&
                        cur.fragmentArguments.equals(oh.fragmentArguments));
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_1174511219 = oh;
                        } //End block
                    } //End collapsed parenthetic
                    {
                        boolean varACD7FE70235FC87BB57677F1298E5E1E_1036748865 = (cur.extras != null && cur.extras.equals(oh.extras));
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_1999966110 = oh;
                        } //End block
                    } //End collapsed parenthetic
                    {
                        boolean varFD818620707839EB3618AD38A41F0598_300101588 = (cur.title != null && cur.title.equals(oh.title));
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_613384514 = oh;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1464686602 = null;
        addTaint(cur.getTaint());
        addTaint(from.getTaint());
        Header varA7E53CE21691AB073D9660D615818899_1924152236; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1924152236 = varB4EAC82CA7396A68D541C85D26508E83_518028315;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1924152236 = varB4EAC82CA7396A68D541C85D26508E83_1174511219;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1924152236 = varB4EAC82CA7396A68D541C85D26508E83_1999966110;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1924152236 = varB4EAC82CA7396A68D541C85D26508E83_613384514;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1924152236 = varB4EAC82CA7396A68D541C85D26508E83_1464686602;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1924152236.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1924152236;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.078 -0400", hash_original_method = "20FDC2DC66402E55AE5BF59B2D025057", hash_generated_method = "39DB3ED98EB8F96F6963E1C36BDD4AE6")
    public void startPreferenceFragment(Fragment fragment, boolean push) {
        FragmentTransaction transaction;
        transaction = getFragmentManager().beginTransaction();
        transaction.replace(com.android.internal.R.id.prefs, fragment);
        {
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            transaction.addToBackStack(BACK_STACK_PREFS);
        } //End block
        {
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        } //End block
        transaction.commitAllowingStateLoss();
        addTaint(fragment.getTaint());
        addTaint(push);
        // ---------- Original Method ----------
        //FragmentTransaction transaction = getFragmentManager().beginTransaction();
        //transaction.replace(com.android.internal.R.id.prefs, fragment);
        //if (push) {
            //transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            //transaction.addToBackStack(BACK_STACK_PREFS);
        //} else {
            //transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        //}
        //transaction.commitAllowingStateLoss();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.079 -0400", hash_original_method = "E25F9CE570E0BFA743AE6FCAFFB6168D", hash_generated_method = "6D0039DADD991E0350E58791869B0CC1")
    public void startPreferencePanel(String fragmentClass, Bundle args, int titleRes,
            CharSequence titleText, Fragment resultTo, int resultRequestCode) {
        {
            startWithFragment(fragmentClass, args, resultTo, resultRequestCode, titleRes, 0);
        } //End block
        {
            Fragment f;
            f = Fragment.instantiate(this, fragmentClass, args);
            {
                f.setTargetFragment(resultTo, resultRequestCode);
            } //End block
            FragmentTransaction transaction;
            transaction = getFragmentManager().beginTransaction();
            transaction.replace(com.android.internal.R.id.prefs, f);
            {
                transaction.setBreadCrumbTitle(titleRes);
            } //End block
            {
                transaction.setBreadCrumbTitle(titleText);
            } //End block
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            transaction.addToBackStack(BACK_STACK_PREFS);
            transaction.commitAllowingStateLoss();
        } //End block
        addTaint(fragmentClass.getTaint());
        addTaint(args.getTaint());
        addTaint(titleRes);
        addTaint(titleText.getTaint());
        addTaint(resultTo.getTaint());
        addTaint(resultRequestCode);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.080 -0400", hash_original_method = "35CCCF58010C828A125388DBAAB260E2", hash_generated_method = "CA61EF56D9F44EC8A161CC41773B7161")
    public void finishPreferencePanel(Fragment caller, int resultCode, Intent resultData) {
        {
            setResult(resultCode, resultData);
            finish();
        } //End block
        {
            onBackPressed();
            {
                {
                    boolean var05213B3A3869F77879DB09487CF0868B_1167810908 = (caller.getTargetFragment() != null);
                    {
                        caller.getTargetFragment().onActivityResult(caller.getTargetRequestCode(),
                            resultCode, resultData);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        addTaint(caller.getTaint());
        addTaint(resultCode);
        addTaint(resultData.getTaint());
        // ---------- Original Method ----------
        //if (mSinglePane) {
            //setResult(resultCode, resultData);
            //finish();
        //} else {
            //onBackPressed();
            //if (caller != null) {
                //if (caller.getTargetFragment() != null) {
                    //caller.getTargetFragment().onActivityResult(caller.getTargetRequestCode(),
                            //resultCode, resultData);
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.080 -0400", hash_original_method = "88B12B83AF6C82165835FAA52B723B1A", hash_generated_method = "BC5C0DC0F9258CA0116A9D0114DAA7C6")
    @Override
    public boolean onPreferenceStartFragment(PreferenceFragment caller, Preference pref) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        startPreferencePanel(pref.getFragment(), pref.getExtras(), pref.getTitleRes(),
                pref.getTitle(), null, 0);
        addTaint(caller.getTaint());
        addTaint(pref.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_483050272 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_483050272;
        // ---------- Original Method ----------
        //startPreferencePanel(pref.getFragment(), pref.getExtras(), pref.getTitleRes(),
                //pref.getTitle(), null, 0);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.094 -0400", hash_original_method = "6C1825C42631AE6FCE57D0240C5D762E", hash_generated_method = "4E2193EDF407AE0DD926B43B3398AF1F")
    private void postBindPreferences() {
        {
            boolean var0A3D3B0504D764BC1C3FB906BCA6B206_1299043367 = (mHandler.hasMessages(MSG_BIND_PREFERENCES));
        } //End collapsed parenthetic
        mHandler.obtainMessage(MSG_BIND_PREFERENCES).sendToTarget();
        // ---------- Original Method ----------
        //if (mHandler.hasMessages(MSG_BIND_PREFERENCES)) return;
        //mHandler.obtainMessage(MSG_BIND_PREFERENCES).sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.095 -0400", hash_original_method = "548F27FE8CA6D6649BD8B5A7939C474E", hash_generated_method = "BBAF028D332690DB0346C9589CE3B31B")
    private void bindPreferences() {
        PreferenceScreen preferenceScreen;
        preferenceScreen = getPreferenceScreen();
        {
            preferenceScreen.bind(getListView());
            {
                super.onRestoreInstanceState(mSavedInstanceState);
                mSavedInstanceState = null;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //final PreferenceScreen preferenceScreen = getPreferenceScreen();
        //if (preferenceScreen != null) {
            //preferenceScreen.bind(getListView());
            //if (mSavedInstanceState != null) {
                //super.onRestoreInstanceState(mSavedInstanceState);
                //mSavedInstanceState = null;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.096 -0400", hash_original_method = "002FC5CEE5BE5B5D1FE36CEDBC1DEB65", hash_generated_method = "47227131B2BCB583883DBF705E57AB32")
    @Deprecated
    public PreferenceManager getPreferenceManager() {
        PreferenceManager varB4EAC82CA7396A68D541C85D26508E83_1041579247 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1041579247 = mPreferenceManager;
        varB4EAC82CA7396A68D541C85D26508E83_1041579247.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1041579247;
        // ---------- Original Method ----------
        //return mPreferenceManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.102 -0400", hash_original_method = "B2669BE6B91E4B8BF7765D817C0F2C8A", hash_generated_method = "012E4F81E02E147BD2D416E482E7C516")
    private void requirePreferenceManager() {
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException("This should be called after super.onCreate.");
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                    "Modern two-pane PreferenceActivity requires use of a PreferenceFragment");
        } //End block
        // ---------- Original Method ----------
        //if (mPreferenceManager == null) {
            //if (mAdapter == null) {
                //throw new RuntimeException("This should be called after super.onCreate.");
            //}
            //throw new RuntimeException(
                    //"Modern two-pane PreferenceActivity requires use of a PreferenceFragment");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.103 -0400", hash_original_method = "20BEF3079E316F6730A81E488DFA70F2", hash_generated_method = "58E6E3D41527BD7AD6811106934F0E74")
    @Deprecated
    public void setPreferenceScreen(PreferenceScreen preferenceScreen) {
        requirePreferenceManager();
        {
            boolean var551C8AB5BC879C26D0247C3960A9CA65_1004046529 = (mPreferenceManager.setPreferences(preferenceScreen) && preferenceScreen != null);
            {
                postBindPreferences();
                CharSequence title;
                title = getPreferenceScreen().getTitle();
                {
                    setTitle(title);
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(preferenceScreen.getTaint());
        // ---------- Original Method ----------
        //requirePreferenceManager();
        //if (mPreferenceManager.setPreferences(preferenceScreen) && preferenceScreen != null) {
            //postBindPreferences();
            //CharSequence title = getPreferenceScreen().getTitle();
            //if (title != null) {
                //setTitle(title);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.124 -0400", hash_original_method = "7CC03E7D3EBAF4E1E382E9E7A55EF0AE", hash_generated_method = "03A25C13440E13EC80FD605CB3ADF777")
    @Deprecated
    public PreferenceScreen getPreferenceScreen() {
        PreferenceScreen varB4EAC82CA7396A68D541C85D26508E83_1447492820 = null; //Variable for return #1
        PreferenceScreen varB4EAC82CA7396A68D541C85D26508E83_2079587467 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1447492820 = mPreferenceManager.getPreferenceScreen();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2079587467 = null;
        PreferenceScreen varA7E53CE21691AB073D9660D615818899_2134749779; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2134749779 = varB4EAC82CA7396A68D541C85D26508E83_1447492820;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2134749779 = varB4EAC82CA7396A68D541C85D26508E83_2079587467;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2134749779.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2134749779;
        // ---------- Original Method ----------
        //if (mPreferenceManager != null) {
            //return mPreferenceManager.getPreferenceScreen();
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.124 -0400", hash_original_method = "5674CE8C214451535BFAB18211614C8C", hash_generated_method = "93A4A732934FD8FFA0ABE2E40CF5EAA5")
    @Deprecated
    public void addPreferencesFromIntent(Intent intent) {
        requirePreferenceManager();
        setPreferenceScreen(mPreferenceManager.inflateFromIntent(intent, getPreferenceScreen()));
        addTaint(intent.getTaint());
        // ---------- Original Method ----------
        //requirePreferenceManager();
        //setPreferenceScreen(mPreferenceManager.inflateFromIntent(intent, getPreferenceScreen()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.125 -0400", hash_original_method = "1D27A71B873F6C05FF2DA5D8C133ED30", hash_generated_method = "F61A9E9524F31BE80BAB0A913149E477")
    @Deprecated
    public void addPreferencesFromResource(int preferencesResId) {
        requirePreferenceManager();
        setPreferenceScreen(mPreferenceManager.inflateFromResource(this, preferencesResId,
                getPreferenceScreen()));
        addTaint(preferencesResId);
        // ---------- Original Method ----------
        //requirePreferenceManager();
        //setPreferenceScreen(mPreferenceManager.inflateFromResource(this, preferencesResId,
                //getPreferenceScreen()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.125 -0400", hash_original_method = "ADC2C8250ACD9F9573CD9A45AF1661C3", hash_generated_method = "D3F3D42987CB27BC63B8A5A0CF90BC7D")
    @Deprecated
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(preferenceScreen.getTaint());
        addTaint(preference.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1985627068 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1985627068;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.126 -0400", hash_original_method = "0C794FFD7CBFBB35093DF6CE24875508", hash_generated_method = "E53D0EB4E5FE249DA2C6A3D4F68B8C3D")
    @Deprecated
    public Preference findPreference(CharSequence key) {
        Preference varB4EAC82CA7396A68D541C85D26508E83_857093123 = null; //Variable for return #1
        Preference varB4EAC82CA7396A68D541C85D26508E83_903159193 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_857093123 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_903159193 = mPreferenceManager.findPreference(key);
        addTaint(key.getTaint());
        Preference varA7E53CE21691AB073D9660D615818899_1970886056; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1970886056 = varB4EAC82CA7396A68D541C85D26508E83_857093123;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1970886056 = varB4EAC82CA7396A68D541C85D26508E83_903159193;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1970886056.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1970886056;
        // ---------- Original Method ----------
        //if (mPreferenceManager == null) {
            //return null;
        //}
        //return mPreferenceManager.findPreference(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.126 -0400", hash_original_method = "5A6127558FF9D60C52821F59A1A351C3", hash_generated_method = "F6066D2E4DA28AFE4FDCE25F8D97A89C")
    @Override
    protected void onNewIntent(Intent intent) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            mPreferenceManager.dispatchNewIntent(intent);
        } //End block
        addTaint(intent.getTaint());
        // ---------- Original Method ----------
        //if (mPreferenceManager != null) {
            //mPreferenceManager.dispatchNewIntent(intent);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.127 -0400", hash_original_method = "BC54EB6D436D19F86F3C9657BD0BE1AA", hash_generated_method = "F0FA8DE3D6FA8AA94CB9C1F15E4136B6")
    protected boolean hasNextButton() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1306496142 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1306496142;
        // ---------- Original Method ----------
        //return mNextButton != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.127 -0400", hash_original_method = "CC6F0F14612F322772A46478BA75E81F", hash_generated_method = "9663794F2E8C27A66CA383B50E7DB27D")
    protected Button getNextButton() {
        Button varB4EAC82CA7396A68D541C85D26508E83_1851552504 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1851552504 = mNextButton;
        varB4EAC82CA7396A68D541C85D26508E83_1851552504.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1851552504;
        // ---------- Original Method ----------
        //return mNextButton;
    }

    
    private static class HeaderAdapter extends ArrayAdapter<Header> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.129 -0400", hash_original_field = "D03597FDEDE23F3823480E0520822BB2", hash_generated_field = "CBB0EE0A851756643DA52E1D33B6B161")

        private LayoutInflater mInflater;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.129 -0400", hash_original_method = "F02F4C5BC3B955ED93786AEEC10379FE", hash_generated_method = "4BF8FCE86F96A9348B08B0BB4D559984")
        public  HeaderAdapter(Context context, List<Header> objects) {
            super(context, 0, objects);
            mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            addTaint(objects.getTaint());
            // ---------- Original Method ----------
            //mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.155 -0400", hash_original_method = "BD15B4EB453F2C74F6031A45FD2B76C2", hash_generated_method = "6953B6C471F2D606E8BBE4E3831B2D1A")
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View varB4EAC82CA7396A68D541C85D26508E83_1960851284 = null; //Variable for return #1
            HeaderViewHolder holder;
            View view;
            {
                view = mInflater.inflate(com.android.internal.R.layout.preference_header_item,
                        parent, false);
                holder = new HeaderViewHolder();
                holder.icon = (ImageView) view.findViewById(com.android.internal.R.id.icon);
                holder.title = (TextView) view.findViewById(com.android.internal.R.id.title);
                holder.summary = (TextView) view.findViewById(com.android.internal.R.id.summary);
                view.setTag(holder);
            } //End block
            {
                view = convertView;
                holder = (HeaderViewHolder) view.getTag();
            } //End block
            Header header;
            header = getItem(position);
            holder.icon.setImageResource(header.iconRes);
            holder.title.setText(header.getTitle(getContext().getResources()));
            CharSequence summary;
            summary = header.getSummary(getContext().getResources());
            {
                boolean var33886BAB7464784CE6FA21654C0C5CE0_1499587864 = (!TextUtils.isEmpty(summary));
                {
                    holder.summary.setVisibility(View.VISIBLE);
                    holder.summary.setText(summary);
                } //End block
                {
                    holder.summary.setVisibility(View.GONE);
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1960851284 = view;
            addTaint(position);
            addTaint(convertView.getTaint());
            addTaint(parent.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1960851284.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1960851284;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        private static class HeaderViewHolder {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.156 -0400", hash_original_field = "BAEC6461B0D69DDE1B861AEFBE375D8A", hash_generated_field = "7D496A7EF4277B81CF926C9FC9D04248")

            ImageView icon;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.156 -0400", hash_original_field = "D5D3DB1765287EEF77D7927CC956F50A", hash_generated_field = "D2FBB4059A3EADAB444F225698E4F56E")

            TextView title;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.156 -0400", hash_original_field = "A80DA1282F2C775BBC5F2C92C836968B", hash_generated_field = "BA7542FFBE4C8102C12065D859063619")

            TextView summary;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.156 -0400", hash_original_method = "7AAB7B01E6419825274A30D2382564EA", hash_generated_method = "7AAB7B01E6419825274A30D2382564EA")
            public HeaderViewHolder ()
            {
                //Synthesized constructor
            }


        }


        
    }


    
    public static final class Header implements Parcelable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.157 -0400", hash_original_field = "CD9D7F08098BD235A18AE68FCAFCDC6A", hash_generated_field = "737A7D6903ECE33BE0237DB5C22496D2")

        public long id = HEADER_ID_UNDEFINED;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.157 -0400", hash_original_field = "608C178BEAA10D047DA1A404A17FEEF5", hash_generated_field = "3FD6C8139DEDC39179812C2724BF57B9")

        public int titleRes;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.157 -0400", hash_original_field = "D5D3DB1765287EEF77D7927CC956F50A", hash_generated_field = "285EF5A6A116FF608EE0587EA9C0F06D")

        public CharSequence title;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.157 -0400", hash_original_field = "05DF20411D7FE5FD44C56C61ADE561A9", hash_generated_field = "CF9D7763F41618969B1EF555AA62D675")

        public int summaryRes;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.157 -0400", hash_original_field = "A80DA1282F2C775BBC5F2C92C836968B", hash_generated_field = "649E9B273BD3EE954608217A46D60F9B")

        public CharSequence summary;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.157 -0400", hash_original_field = "EA055285E63FE8F3AEBF3FF66EAD77EC", hash_generated_field = "2CD689A4778432DF6FA02D3B2B9056EA")

        public int breadCrumbTitleRes;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.157 -0400", hash_original_field = "EC414BEC23FAE15429CFD80EB6C67E2E", hash_generated_field = "73EEB773801D9077B302E48B9DC2F190")

        public CharSequence breadCrumbTitle;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.157 -0400", hash_original_field = "E547092BCAACD041884B348DB68C9AFC", hash_generated_field = "61F809170E6E2C53D80864D07EEB140C")

        public int breadCrumbShortTitleRes;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.157 -0400", hash_original_field = "BC12220BB3538919F835A9A75EA14EA8", hash_generated_field = "12A2018B53E7263915979427C28D6095")

        public CharSequence breadCrumbShortTitle;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.157 -0400", hash_original_field = "1AFA68AAD1FD9765C18E4975F512B2FD", hash_generated_field = "800898B731FFFE010B18EB819F288168")

        public int iconRes;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.164 -0400", hash_original_field = "02E918FC72837D7C2689BE88684DCEB1", hash_generated_field = "3FCA1C3F48B0A85017F597A00E283B60")

        public String fragment;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.164 -0400", hash_original_field = "42BE488D27E9D9A55607EBD0D4EE93C5", hash_generated_field = "B8BBDD0C2C5BEF49B225AB4995204C33")

        public Bundle fragmentArguments;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.164 -0400", hash_original_field = "FA48C7D544739BA0E46430E4BA366662", hash_generated_field = "5DEDAC72AD89B3864945324786195E0B")

        public Intent intent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.164 -0400", hash_original_field = "27353006CFD751D26221E04A7928034D", hash_generated_field = "360651D25CBD3D75EA270BBFA49C37D4")

        public Bundle extras;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.164 -0400", hash_original_method = "CC8692EE42ED9AE9CFD9E664B2A1E936", hash_generated_method = "D78360B1F9ED0AA24422BF34D2B11223")
        public  Header() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.177 -0400", hash_original_method = "3E4088512988FAACC868C0BAC5E638A1", hash_generated_method = "3D2638C4E4B60CE25F1B6D2D2D061EC9")
          Header(Parcel in) {
            readFromParcel(in);
            addTaint(in.getTaint());
            // ---------- Original Method ----------
            //readFromParcel(in);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.179 -0400", hash_original_method = "334D1E94CC98A584AC982CEC8D5C3813", hash_generated_method = "FFF3A025534B8B593881E2537110BE7C")
        public CharSequence getTitle(Resources res) {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_1404864747 = null; //Variable for return #1
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_409600025 = null; //Variable for return #2
            {
                varB4EAC82CA7396A68D541C85D26508E83_1404864747 = res.getText(titleRes);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_409600025 = title;
            addTaint(res.getTaint());
            CharSequence varA7E53CE21691AB073D9660D615818899_497356233; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_497356233 = varB4EAC82CA7396A68D541C85D26508E83_1404864747;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_497356233 = varB4EAC82CA7396A68D541C85D26508E83_409600025;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_497356233.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_497356233;
            // ---------- Original Method ----------
            //if (titleRes != 0) {
                //return res.getText(titleRes);
            //}
            //return title;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.179 -0400", hash_original_method = "817FA0FA7A0D92830E14FE64024CE8CC", hash_generated_method = "127BE01B5DEA7C397E5C9CA7E1461025")
        public CharSequence getSummary(Resources res) {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_1617767882 = null; //Variable for return #1
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_1149357494 = null; //Variable for return #2
            {
                varB4EAC82CA7396A68D541C85D26508E83_1617767882 = res.getText(summaryRes);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1149357494 = summary;
            addTaint(res.getTaint());
            CharSequence varA7E53CE21691AB073D9660D615818899_809835786; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_809835786 = varB4EAC82CA7396A68D541C85D26508E83_1617767882;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_809835786 = varB4EAC82CA7396A68D541C85D26508E83_1149357494;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_809835786.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_809835786;
            // ---------- Original Method ----------
            //if (summaryRes != 0) {
                //return res.getText(summaryRes);
            //}
            //return summary;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.180 -0400", hash_original_method = "AB517FA9C1DC5B1E62910A1ABDCECDD0", hash_generated_method = "60569F937761120A6DE11F4F319A1A60")
        public CharSequence getBreadCrumbTitle(Resources res) {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_202221711 = null; //Variable for return #1
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_1976706097 = null; //Variable for return #2
            {
                varB4EAC82CA7396A68D541C85D26508E83_202221711 = res.getText(breadCrumbTitleRes);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1976706097 = breadCrumbTitle;
            addTaint(res.getTaint());
            CharSequence varA7E53CE21691AB073D9660D615818899_1212374283; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1212374283 = varB4EAC82CA7396A68D541C85D26508E83_202221711;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1212374283 = varB4EAC82CA7396A68D541C85D26508E83_1976706097;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1212374283.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1212374283;
            // ---------- Original Method ----------
            //if (breadCrumbTitleRes != 0) {
                //return res.getText(breadCrumbTitleRes);
            //}
            //return breadCrumbTitle;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.181 -0400", hash_original_method = "F11776C7591643DD9CB4C4ECCD867732", hash_generated_method = "531087AE76E081C2CDA15BC54D66FDCD")
        public CharSequence getBreadCrumbShortTitle(Resources res) {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_1819542026 = null; //Variable for return #1
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_868730045 = null; //Variable for return #2
            {
                varB4EAC82CA7396A68D541C85D26508E83_1819542026 = res.getText(breadCrumbShortTitleRes);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_868730045 = breadCrumbShortTitle;
            addTaint(res.getTaint());
            CharSequence varA7E53CE21691AB073D9660D615818899_2091863078; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_2091863078 = varB4EAC82CA7396A68D541C85D26508E83_1819542026;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_2091863078 = varB4EAC82CA7396A68D541C85D26508E83_868730045;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_2091863078.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_2091863078;
            // ---------- Original Method ----------
            //if (breadCrumbShortTitleRes != 0) {
                //return res.getText(breadCrumbShortTitleRes);
            //}
            //return breadCrumbShortTitle;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.182 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "BD26D8BE61EE043BAF27D88B98F448F7")
        @Override
        public int describeContents() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1034062296 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1034062296;
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.196 -0400", hash_original_method = "BB0DBC9520A7E98C1F6BA8AD4772118F", hash_generated_method = "806E7F393AD3463C295E19AD88192853")
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
            {
                dest.writeInt(1);
                intent.writeToParcel(dest, flags);
            } //End block
            {
                dest.writeInt(0);
            } //End block
            dest.writeBundle(extras);
            addTaint(dest.getTaint());
            addTaint(flags);
            // ---------- Original Method ----------
            //dest.writeLong(id);
            //dest.writeInt(titleRes);
            //TextUtils.writeToParcel(title, dest, flags);
            //dest.writeInt(summaryRes);
            //TextUtils.writeToParcel(summary, dest, flags);
            //dest.writeInt(breadCrumbTitleRes);
            //TextUtils.writeToParcel(breadCrumbTitle, dest, flags);
            //dest.writeInt(breadCrumbShortTitleRes);
            //TextUtils.writeToParcel(breadCrumbShortTitle, dest, flags);
            //dest.writeInt(iconRes);
            //dest.writeString(fragment);
            //dest.writeBundle(fragmentArguments);
            //if (intent != null) {
                //dest.writeInt(1);
                //intent.writeToParcel(dest, flags);
            //} else {
                //dest.writeInt(0);
            //}
            //dest.writeBundle(extras);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.210 -0400", hash_original_method = "29282A1B26F647059DDF5369C2CB137B", hash_generated_method = "EFA925A9B7F4461978B0EEB8554827C3")
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
            {
                boolean var331417C59A822E59FB0B216D2F29CB47_1047892504 = (in.readInt() != 0);
                {
                    intent = Intent.CREATOR.createFromParcel(in);
                } //End block
            } //End collapsed parenthetic
            extras = in.readBundle();
            // ---------- Original Method ----------
            //id = in.readLong();
            //titleRes = in.readInt();
            //title = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
            //summaryRes = in.readInt();
            //summary = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
            //breadCrumbTitleRes = in.readInt();
            //breadCrumbTitle = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
            //breadCrumbShortTitleRes = in.readInt();
            //breadCrumbShortTitle = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
            //iconRes = in.readInt();
            //fragment = in.readString();
            //fragmentArguments = in.readBundle();
            //if (in.readInt() != 0) {
                //intent = Intent.CREATOR.createFromParcel(in);
            //}
            //extras = in.readBundle();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.210 -0400", hash_original_field = "80358CCA6C151B1C75C8F6D01427BC96", hash_generated_field = "0285FC5896D2C8A81AC7F6CCCD215EAF")

        public static final Creator<Header> CREATOR = new Creator<Header>() {
            public Header createFromParcel(Parcel source) {
                return new Header(source);
            }
            public Header[] newArray(int size) {
                return new Header[size];
            }
        };
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.210 -0400", hash_original_field = "5224C355FB3151226DCBB252E71D8C45", hash_generated_field = "2E274955A675C9CA27F4195CDA950B86")

    private static String HEADERS_TAG = ":android:headers";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.211 -0400", hash_original_field = "24813F27F5BB25614DE5963D935AEC65", hash_generated_field = "7B2D610983C58C7722DFF3050AC51EEB")

    private static String CUR_HEADER_TAG = ":android:cur_header";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.211 -0400", hash_original_field = "6B4950CB402849CFD7FF819E761EC566", hash_generated_field = "DC39031403A482FF1DD6127E0C8F66DF")

    private static String PREFERENCES_TAG = ":android:preferences";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.211 -0400", hash_original_field = "8E1D2567A8F5FC0D4CCD7E7D4E5D61DA", hash_generated_field = "46D5D655E675E9CC41AA95971DA7C983")

    public static final String EXTRA_SHOW_FRAGMENT = ":android:show_fragment";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.211 -0400", hash_original_field = "24CAAB8CA0E6C99A6AFA2C78AA37D067", hash_generated_field = "238348398E3BDE30D489970315DCB2F7")

    public static final String EXTRA_SHOW_FRAGMENT_ARGUMENTS = ":android:show_fragment_args";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.211 -0400", hash_original_field = "6C8D245A63EEB3438D48DA1A14CC14B3", hash_generated_field = "9EDA9A80F485D711E436660545646846")

    public static final String EXTRA_SHOW_FRAGMENT_TITLE = ":android:show_fragment_title";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.211 -0400", hash_original_field = "B6BA4D79DB131AD112A933A84B09B7F5", hash_generated_field = "72E65F21D21C144A50537392CA5C7A04")

    public static final String EXTRA_SHOW_FRAGMENT_SHORT_TITLE
            = ":android:show_fragment_short_title";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.211 -0400", hash_original_field = "A307AC2DB4EF1E817C27C8522EB96281", hash_generated_field = "D38B44E415912850DD5978247D2C7A68")

    public static final String EXTRA_NO_HEADERS = ":android:no_headers";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.211 -0400", hash_original_field = "86E59DEBCAC94735618BAF4F9F1733CE", hash_generated_field = "AFFC86D873F9A9583341954E6D602960")

    private static String BACK_STACK_PREFS = ":android:prefs";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.211 -0400", hash_original_field = "C933A32E9C9683A1B47540929477CEAC", hash_generated_field = "E14B19F8F8CAA5B16E50F718933FA502")

    private static String EXTRA_PREFS_SHOW_BUTTON_BAR = "extra_prefs_show_button_bar";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.211 -0400", hash_original_field = "5D4A5C2C86B5EB9C1BF49D09CE1DB767", hash_generated_field = "1DBEDD0EFEB902B44CED42475B9EEC15")

    private static String EXTRA_PREFS_SHOW_SKIP = "extra_prefs_show_skip";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.211 -0400", hash_original_field = "C1643E502B9F83474DDF3C1BA3B34047", hash_generated_field = "3CB4BD92535C0A284387F1DF21049BC8")

    private static String EXTRA_PREFS_SET_NEXT_TEXT = "extra_prefs_set_next_text";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.211 -0400", hash_original_field = "4CE17D3BE7186684C204C2BE77C91C4A", hash_generated_field = "F03E639CCAABE078366FEEE5504B74A0")

    private static String EXTRA_PREFS_SET_BACK_TEXT = "extra_prefs_set_back_text";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.211 -0400", hash_original_field = "0466831DAC50AD91F00BE2472F26C26A", hash_generated_field = "7B59C9E22FB89D92E9C9BE49405D418F")

    private static int FIRST_REQUEST_CODE = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.211 -0400", hash_original_field = "D7A6754ED93721763C237AE926734ECE", hash_generated_field = "B7C0D2FF79AAE30581F370D2E4D9B876")

    private static int MSG_BIND_PREFERENCES = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.211 -0400", hash_original_field = "A311ADD455E28882DFBE1013B45DE390", hash_generated_field = "5317AC01A8574CC061FD48ABD5C9B8F2")

    private static int MSG_BUILD_HEADERS = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.212 -0400", hash_original_field = "66B9C0557A7ABDF9846F2E4A3158DC16", hash_generated_field = "D3EEEA8888F40DB4597966262702A0F4")

    public static final long HEADER_ID_UNDEFINED = -1;
}

