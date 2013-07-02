package android.preference;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.348 -0400", hash_original_field = "B4437D0EBCCFE94A5CAF24979E87BFF3", hash_generated_field = "05229AEEB45F74E6571A04947AF7440D")

    private final ArrayList<Header> mHeaders = new ArrayList<Header>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.348 -0400", hash_original_field = "2F6930B6C645E4D8ACA3F8AB58293E8F", hash_generated_field = "FD5AB4D46307B27E8B131FCC69B56024")

    private FrameLayout mListFooter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.348 -0400", hash_original_field = "4869BE0BA3554EC728CBE9D046D8CE8D", hash_generated_field = "7F048D850CFE3A627851CBB7E986274C")

    private ViewGroup mPrefsContainer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.348 -0400", hash_original_field = "57396922F5B63ED226B6755FB75B8ABD", hash_generated_field = "C9A9E888C6CF8869C49ADC5AA023A69B")

    private FragmentBreadCrumbs mFragmentBreadCrumbs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.348 -0400", hash_original_field = "A766A90F5B30D5F0A747208880E91C20", hash_generated_field = "A5B8DDF0DF04B9985F211EFD1518F984")

    private boolean mSinglePane;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.348 -0400", hash_original_field = "B922356C2BC86CDD61900AA9E1D0840F", hash_generated_field = "801A7E2120484101CEC1CFAD107C2A9C")

    private Header mCurHeader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.348 -0400", hash_original_field = "D1487CA8252F4AA0A95324AB4DDD5316", hash_generated_field = "13262EB3751B753EEB3302EF75D8B1E5")

    private PreferenceManager mPreferenceManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.348 -0400", hash_original_field = "A587E455CA5C0B536357B11202A985DD", hash_generated_field = "04DDA78321A9F720FA97A23B9C869D4C")

    private Bundle mSavedInstanceState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.348 -0400", hash_original_field = "25A8D69C909160605880E75D8AC0CC0C", hash_generated_field = "128183E1ED5B562A53AAED4DF9F0640D")

    private Button mNextButton;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.349 -0400", hash_original_field = "92EE827C36817A69E1CF224FB382CB43", hash_generated_field = "A298A40C2B729B85EE4D64C5A99AC361")

    private Handler mHandler = new Handler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.349 -0400", hash_original_method = "DC47A807DF4ECAC4EAC562CA0F303D11", hash_generated_method = "529476C9BAD09545DB4DCA7067D3A940")
        @Override
        public void handleMessage(Message msg) {
            
            {
                bindPreferences();
            } 
            
            
            {
                ArrayList<Header> oldHeaders = new ArrayList<Header>(mHeaders);
                mHeaders.clear();
                onBuildHeaders(mHeaders);
                {
                    ((BaseAdapter) mAdapter).notifyDataSetChanged();
                } 
                Header header = onGetNewHeader();
                {
                    Header mappedHeader = findBestMatchingHeader(header, oldHeaders);
                    {
                        switchToHeader(header);
                    } 
                } 
                {
                    Header mappedHeader = findBestMatchingHeader(mCurHeader, mHeaders);
                    {
                        setSelectedHeader(mappedHeader);
                    } 
                } 
            } 
            
            addTaint(msg.getTaint());
            
            
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.349 -0400", hash_original_method = "5B933AEEC6389C71875EE2A57A875A3A", hash_generated_method = "5B933AEEC6389C71875EE2A57A875A3A")
    public PreferenceActivity ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.353 -0400", hash_original_method = "7377982A731D92C32EEEF871F40BFABD", hash_generated_method = "B0513C26D40A9EBA5025DA3C40517454")
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
        {
            ArrayList<Header> headers = savedInstanceState.getParcelableArrayList(HEADERS_TAG);
            {
                mHeaders.addAll(headers);
                int curHeader = savedInstanceState.getInt(CUR_HEADER_TAG,
                        (int) HEADER_ID_UNDEFINED);
                {
                    boolean varD971D97B53AA0BC8D8587D6FE0840F58_1240335405 = (curHeader >= 0 && curHeader < mHeaders.size());
                    {
                        setSelectedHeader(mHeaders.get(curHeader));
                    } 
                } 
            } 
        } 
        {
            {
                switchToHeader(initialFragment, initialArguments);
                {
                    CharSequence initialTitleStr = getText(initialTitle);
                    CharSequence initialShortTitleStr;
                    initialShortTitleStr = getText(initialShortTitle);
                    initialShortTitleStr = null;
                    showBreadCrumbs(initialTitleStr, initialShortTitleStr);
                } 
            } 
            {
                onBuildHeaders(mHeaders);
                {
                    boolean var3C5C9122339EB6902CABDBBCEAC3E848_675695643 = (mHeaders.size() > 0);
                    {
                        {
                            {
                                Header h = onGetInitialHeader();
                                switchToHeader(h);
                            } 
                            {
                                switchToHeader(initialFragment, initialArguments);
                            } 
                        } 
                    } 
                } 
            } 
        } 
        {
            findViewById(com.android.internal.R.id.headers).setVisibility(View.GONE);
            mPrefsContainer.setVisibility(View.VISIBLE);
            {
                CharSequence initialTitleStr = getText(initialTitle);
                CharSequence initialShortTitleStr;
                initialShortTitleStr = getText(initialShortTitle);
                initialShortTitleStr = null;
                showBreadCrumbs(initialTitleStr, initialShortTitleStr);
            } 
        } 
        {
            boolean varC47E2037492266204268C44984CBA8D5_1185775221 = (mHeaders.size() > 0);
            {
                setListAdapter(new HeaderAdapter(this, mHeaders));
                {
                    getListView().setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
                    {
                        setSelectedHeader(mCurHeader);
                    } 
                    mPrefsContainer.setVisibility(View.VISIBLE);
                } 
            } 
            {
                setContentView(com.android.internal.R.layout.preference_list_content_single);
                mListFooter = (FrameLayout) findViewById(com.android.internal.R.id.list_footer);
                mPrefsContainer = (ViewGroup) findViewById(com.android.internal.R.id.prefs);
                mPreferenceManager = new PreferenceManager(this, FIRST_REQUEST_CODE);
                mPreferenceManager.setOnPreferenceTreeClickListener(this);
            } 
        } 
        Intent intent = getIntent();
        {
            boolean var6B00C4D8B2C7FAD11C83CC1F266AECCB_1425690367 = (intent.getBooleanExtra(EXTRA_PREFS_SHOW_BUTTON_BAR, false));
            {
                findViewById(com.android.internal.R.id.button_bar).setVisibility(View.VISIBLE);
                Button backButton = (Button)findViewById(com.android.internal.R.id.back_button);
                backButton.setOnClickListener(new OnClickListener() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.351 -0400", hash_original_method = "B6AEEA4CFEDD0D6DCDC87F0A632F7AF4", hash_generated_method = "B0B10E3119A72559C15D04B140EBDDAB")
                    public void onClick(View v) {
                        
                        setResult(RESULT_CANCELED);
                        finish();
                        addTaint(v.getTaint());
                        
                        
                        
                    }
});
                Button skipButton = (Button)findViewById(com.android.internal.R.id.skip_button);
                skipButton.setOnClickListener(new OnClickListener() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.352 -0400", hash_original_method = "812DEADF112942F677940097DE15DE01", hash_generated_method = "A3397B80DD10207A45A973E88FAC70AD")
                    public void onClick(View v) {
                        
                        setResult(RESULT_OK);
                        finish();
                        addTaint(v.getTaint());
                        
                        
                        
                    }
});
                mNextButton = (Button)findViewById(com.android.internal.R.id.next_button);
                mNextButton.setOnClickListener(new OnClickListener() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.353 -0400", hash_original_method = "812DEADF112942F677940097DE15DE01", hash_generated_method = "A3397B80DD10207A45A973E88FAC70AD")
                    public void onClick(View v) {
                        
                        setResult(RESULT_OK);
                        finish();
                        addTaint(v.getTaint());
                        
                        
                        
                    }
});
                {
                    boolean varD8F09DEAA64F02CAA3B7761851A087BA_514435029 = (intent.hasExtra(EXTRA_PREFS_SET_NEXT_TEXT));
                    {
                        String buttonText = intent.getStringExtra(EXTRA_PREFS_SET_NEXT_TEXT);
                        {
                            boolean varA83281A80E85198E02B69B5E2D604E2A_1776683378 = (TextUtils.isEmpty(buttonText));
                            {
                                mNextButton.setVisibility(View.GONE);
                            } 
                            {
                                mNextButton.setText(buttonText);
                            } 
                        } 
                    } 
                } 
                {
                    boolean var212B680940E2D8C079403373389F9963_1956037294 = (intent.hasExtra(EXTRA_PREFS_SET_BACK_TEXT));
                    {
                        String buttonText = intent.getStringExtra(EXTRA_PREFS_SET_BACK_TEXT);
                        {
                            boolean varA83281A80E85198E02B69B5E2D604E2A_697605002 = (TextUtils.isEmpty(buttonText));
                            {
                                backButton.setVisibility(View.GONE);
                            } 
                            {
                                backButton.setText(buttonText);
                            } 
                        } 
                    } 
                } 
                {
                    boolean var5CF4482CBBF2E47E20FB0A5A85182C1D_170465316 = (intent.getBooleanExtra(EXTRA_PREFS_SHOW_SKIP, false));
                    {
                        skipButton.setVisibility(View.VISIBLE);
                    } 
                } 
            } 
        } 
        addTaint(savedInstanceState.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.354 -0400", hash_original_method = "451C86882BCD1F18856FAB1FCF2DF436", hash_generated_method = "7C78AD25E525F7C488D332D40F142DBD")
    public boolean hasHeaders() {
        boolean var2793A1F83EB46403278370A572A342A3_1638782919 = (getListView().getVisibility() == View.VISIBLE
                && mPreferenceManager == null);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1920610135 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1920610135;
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.354 -0400", hash_original_method = "E843412269C4B791D4D2B897726E7F84", hash_generated_method = "612C6F091D076141268A1374E68CE1C5")
    public boolean isMultiPane() {
        boolean var6FA4B253B6861D383ED2CA9AF2933EFC_806247048 = (hasHeaders() && mPrefsContainer.getVisibility() == View.VISIBLE);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1758277912 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1758277912;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.354 -0400", hash_original_method = "88171EFEE6286ACCEFBDA2CCA56DC062", hash_generated_method = "7CFDD1499FAC19CBABFF6FE9F92A6F0C")
    public boolean onIsMultiPane() {
        
        boolean preferMultiPane = getResources().getBoolean(
                com.android.internal.R.bool.preferences_prefer_dual_pane);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_653581693 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_653581693;
        
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.354 -0400", hash_original_method = "6AB6F840F5A47C64B3086422C8E885E0", hash_generated_method = "DF3DA5BBB706CB0BAB951113FA3D8384")
    public boolean onIsHidingHeaders() {
        
        boolean varF3070E6C30B8A57340493B81FC01958C_353375646 = (getIntent().getBooleanExtra(EXTRA_NO_HEADERS, false));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1552018068 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1552018068;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.355 -0400", hash_original_method = "106989DF67000CA038D75C5F0732B905", hash_generated_method = "77398A983DD162DEBC09E62482E5C9C6")
    public Header onGetInitialHeader() {
        
        Header varB4EAC82CA7396A68D541C85D26508E83_290835506 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_290835506 = mHeaders.get(0);
        varB4EAC82CA7396A68D541C85D26508E83_290835506.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_290835506;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.356 -0400", hash_original_method = "3D3F0DDAE644689D05411BA38FC63FD0", hash_generated_method = "7DFC9735717E5D2380FA525F13DC49FA")
    public Header onGetNewHeader() {
        
        Header varB4EAC82CA7396A68D541C85D26508E83_936482231 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_936482231 = null;
        varB4EAC82CA7396A68D541C85D26508E83_936482231.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_936482231;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.356 -0400", hash_original_method = "2E92E1B9DF373424BC377EC8A240659F", hash_generated_method = "F45695A5F2F86F35BBA19C4D3E46F18D")
    public void onBuildHeaders(List<Header> target) {
        
        addTaint(target.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.356 -0400", hash_original_method = "F909FF4426F024059C8CEA2BE75ABFBE", hash_generated_method = "3D8A14C7D553F12D3C740C7EDFB62791")
    public void invalidateHeaders() {
        {
            boolean var15FECD8C7CC36B9F24D51671998B7A8D_1626681758 = (!mHandler.hasMessages(MSG_BUILD_HEADERS));
            {
                mHandler.sendEmptyMessage(MSG_BUILD_HEADERS);
            } 
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.358 -0400", hash_original_method = "004FDF3B00128708010F53C563B52195", hash_generated_method = "D6A9BB9DE89A42202A32EF2BD6EA303F")
    public void loadHeadersFromResource(int resid, List<Header> target) {
        XmlResourceParser parser = null;
        try 
        {
            parser = getResources().getXml(resid);
            AttributeSet attrs = Xml.asAttributeSet(parser);
            int type;
            {
                boolean var995057C222283DCE9E465AE35974357A_300581670 = ((type=parser.next()) != XmlPullParser.END_DOCUMENT
                    && type != XmlPullParser.START_TAG);
            } 
            String nodeName = parser.getName();
            {
                boolean var40E6A369503F37C37F39656021C225B0_1811448329 = (!"preference-headers".equals(nodeName));
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                        "XML document must start with <preference-headers> tag; found"
                        + nodeName + " at " + parser.getPositionDescription());
                } 
            } 
            Bundle curBundle = null;
            final int outerDepth = parser.getDepth();
            {
                boolean var8956F460685E7D17F4EB87103FD834D7_1576327428 = ((type=parser.next()) != XmlPullParser.END_DOCUMENT
                   && (type != XmlPullParser.END_TAG || parser.getDepth() > outerDepth));
                {
                    nodeName = parser.getName();
                    {
                        boolean var3960BA89728D7772E92DE81F9AEA2B8A_1072354575 = ("header".equals(nodeName));
                        {
                            Header header = new Header();
                            TypedArray sa = getResources().obtainAttributes(attrs,
                            com.android.internal.R.styleable.PreferenceHeader);
                            header.id = sa.getResourceId(
                            com.android.internal.R.styleable.PreferenceHeader_id,
                            (int)HEADER_ID_UNDEFINED);
                            TypedValue tv = sa.peekValue(
                            com.android.internal.R.styleable.PreferenceHeader_title);
                            {
                                {
                                    header.titleRes = tv.resourceId;
                                } 
                                {
                                    header.title = tv.string;
                                } 
                            } 
                            tv = sa.peekValue(
                            com.android.internal.R.styleable.PreferenceHeader_summary);
                            {
                                {
                                    header.summaryRes = tv.resourceId;
                                } 
                                {
                                    header.summary = tv.string;
                                } 
                            } 
                            tv = sa.peekValue(
                            com.android.internal.R.styleable.PreferenceHeader_breadCrumbTitle);
                            {
                                {
                                    header.breadCrumbTitleRes = tv.resourceId;
                                } 
                                {
                                    header.breadCrumbTitle = tv.string;
                                } 
                            } 
                            tv = sa.peekValue(
                            com.android.internal.R.styleable.PreferenceHeader_breadCrumbShortTitle);
                            {
                                {
                                    header.breadCrumbShortTitleRes = tv.resourceId;
                                } 
                                {
                                    header.breadCrumbShortTitle = tv.string;
                                } 
                            } 
                            header.iconRes = sa.getResourceId(
                            com.android.internal.R.styleable.PreferenceHeader_icon, 0);
                            header.fragment = sa.getString(
                            com.android.internal.R.styleable.PreferenceHeader_fragment);
                            sa.recycle();
                            {
                                curBundle = new Bundle();
                            } 
                            final int innerDepth = parser.getDepth();
                            {
                                boolean var554531EF1BF3152A9E18038DDC877C21_990381473 = ((type=parser.next()) != XmlPullParser.END_DOCUMENT
                           && (type != XmlPullParser.END_TAG || parser.getDepth() > innerDepth));
                                {
                                    String innerNodeName = parser.getName();
                                    {
                                        boolean var74DE697D83642086363AEB84579A347D_1883937529 = (innerNodeName.equals("extra"));
                                        {
                                            getResources().parseBundleExtra("extra", attrs, curBundle);
                                            XmlUtils.skipCurrentTag(parser);
                                        } 
                                        {
                                            boolean var0397BC68DE863D781A6C34BDE10D80E3_270381045 = (innerNodeName.equals("intent"));
                                            {
                                                header.intent = Intent.parseIntent(getResources(), parser, attrs);
                                            } 
                                            {
                                                XmlUtils.skipCurrentTag(parser);
                                            } 
                                        } 
                                    } 
                                } 
                            } 
                            {
                                boolean var50D670F336750E2E523F404128E754B7_469397123 = (curBundle.size() > 0);
                                {
                                    header.fragmentArguments = curBundle;
                                    curBundle = null;
                                } 
                            } 
                            target.add(header);
                        } 
                        {
                            XmlUtils.skipCurrentTag(parser);
                        } 
                    } 
                } 
            } 
        } 
        catch (XmlPullParserException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Error parsing headers", e);
        } 
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Error parsing headers", e);
        } 
        finally 
        {
            parser.close();
        } 
        addTaint(resid);
        addTaint(target.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.359 -0400", hash_original_method = "0C226BA6EB709C0B8BDD6989275021F7", hash_generated_method = "60C6F75401B75C3D68FF18F76EA87C6B")
    public void setListFooter(View view) {
        mListFooter.removeAllViews();
        mListFooter.addView(view, new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.WRAP_CONTENT));
        addTaint(view.getTaint());
        
        
        
                
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.359 -0400", hash_original_method = "5055AD43F70FAF224ADCBC793E0582D3", hash_generated_method = "A90604FCE63812931DB95980487BC552")
    @Override
    protected void onStop() {
        
        super.onStop();
        {
            mPreferenceManager.dispatchActivityStop();
        } 
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.359 -0400", hash_original_method = "015EB586B516E4BA63E47DF2D2F941B5", hash_generated_method = "C72394E9CC1E3C1FA20099DB7C625F82")
    @Override
    protected void onDestroy() {
        
        super.onDestroy();
        {
            mPreferenceManager.dispatchActivityDestroy();
        } 
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.360 -0400", hash_original_method = "1A457C81CAD07F8216A55B906C01B0EE", hash_generated_method = "8DDC5F519CBF08B5726E8D29E478EA67")
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        
        super.onSaveInstanceState(outState);
        {
            boolean varC47E2037492266204268C44984CBA8D5_2083693317 = (mHeaders.size() > 0);
            {
                outState.putParcelableArrayList(HEADERS_TAG, mHeaders);
                {
                    int index = mHeaders.indexOf(mCurHeader);
                    {
                        outState.putInt(CUR_HEADER_TAG, index);
                    } 
                } 
            } 
        } 
        {
            final PreferenceScreen preferenceScreen = getPreferenceScreen();
            {
                Bundle container = new Bundle();
                preferenceScreen.saveHierarchyState(container);
                outState.putBundle(PREFERENCES_TAG, container);
            } 
        } 
        addTaint(outState.getTaint());
        
        
        
            
            
                
                
                    
                
            
        
        
            
            
                
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.361 -0400", hash_original_method = "3A902C5AADE0A248676EF9D6166BBE53", hash_generated_method = "84E379B659A98E98EB06AD621E9BE580")
    @Override
    protected void onRestoreInstanceState(Bundle state) {
        
        {
            Bundle container = state.getBundle(PREFERENCES_TAG);
            {
                final PreferenceScreen preferenceScreen = getPreferenceScreen();
                {
                    preferenceScreen.restoreHierarchyState(container);
                    mSavedInstanceState = state;
                } 
            } 
        } 
        super.onRestoreInstanceState(state);
        
        
            
            
                
                
                    
                    
                    
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.361 -0400", hash_original_method = "BC5669EA98C9095AD4591AFCBD99CE20", hash_generated_method = "2AEBE14919F34D41BF0961BCD39F29A4")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        
        super.onActivityResult(requestCode, resultCode, data);
        {
            mPreferenceManager.dispatchActivityResult(requestCode, resultCode, data);
        } 
        addTaint(requestCode);
        addTaint(resultCode);
        addTaint(data.getTaint());
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.362 -0400", hash_original_method = "B413EAEA105506529AB09785B80740F7", hash_generated_method = "4E2B368FDE2D7213D07B0E0E26C29B19")
    @Override
    public void onContentChanged() {
        
        super.onContentChanged();
        {
            postBindPreferences();
        } 
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.362 -0400", hash_original_method = "32CF46DB4065373D899344EB4B5785F0", hash_generated_method = "1AB6D1934EED5209C3E82B2A7C8AE59A")
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        
        super.onListItemClick(l, v, position, id);
        {
            Object item = mAdapter.getItem(position);
            onHeaderClick((Header) item, position);
        } 
        addTaint(l.getTaint());
        addTaint(v.getTaint());
        addTaint(position);
        addTaint(id);
        
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.363 -0400", hash_original_method = "41F78ADB739893E8265A1748D8E017F7", hash_generated_method = "D0FC963E65199A1D8113FFEAA2897FFF")
    public void onHeaderClick(Header header, int position) {
        
        {
            {
                int titleRes = header.breadCrumbTitleRes;
                int shortTitleRes = header.breadCrumbShortTitleRes;
                {
                    titleRes = header.titleRes;
                    shortTitleRes = 0;
                } 
                startWithFragment(header.fragment, header.fragmentArguments, null, 0,
                        titleRes, shortTitleRes);
            } 
            {
                switchToHeader(header);
            } 
        } 
        {
            startActivity(header.intent);
        } 
        addTaint(header.getTaint());
        addTaint(position);
        
        
            
                
                
                
                    
                    
                
                
                        
            
                
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.365 -0400", hash_original_method = "B5DA23DDC47E44587D99F550083B256B", hash_generated_method = "48A99DC9419C503EF497AECBFE83D560")
    public Intent onBuildStartFragmentIntent(String fragmentName, Bundle args,
            int titleRes, int shortTitleRes) {
        
        Intent varB4EAC82CA7396A68D541C85D26508E83_922368756 = null; 
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setClass(this, getClass());
        intent.putExtra(EXTRA_SHOW_FRAGMENT, fragmentName);
        intent.putExtra(EXTRA_SHOW_FRAGMENT_ARGUMENTS, args);
        intent.putExtra(EXTRA_SHOW_FRAGMENT_TITLE, titleRes);
        intent.putExtra(EXTRA_SHOW_FRAGMENT_SHORT_TITLE, shortTitleRes);
        intent.putExtra(EXTRA_NO_HEADERS, true);
        varB4EAC82CA7396A68D541C85D26508E83_922368756 = intent;
        addTaint(fragmentName.getTaint());
        addTaint(args.getTaint());
        addTaint(titleRes);
        addTaint(shortTitleRes);
        varB4EAC82CA7396A68D541C85D26508E83_922368756.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_922368756;
        
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.366 -0400", hash_original_method = "7A5ABD7084FE456D2AC9E7363F23F617", hash_generated_method = "896974140AC0AE3C321B30A73585FD7E")
    public void startWithFragment(String fragmentName, Bundle args,
            Fragment resultTo, int resultRequestCode) {
        startWithFragment(fragmentName, args, resultTo, resultRequestCode, 0, 0);
        addTaint(fragmentName.getTaint());
        addTaint(args.getTaint());
        addTaint(resultTo.getTaint());
        addTaint(resultRequestCode);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.366 -0400", hash_original_method = "A8702F14B58AAD20058746FC81F4589D", hash_generated_method = "106676E8E3D44CBEEA7291CCA71E84A8")
    public void startWithFragment(String fragmentName, Bundle args,
            Fragment resultTo, int resultRequestCode, int titleRes, int shortTitleRes) {
        Intent intent = onBuildStartFragmentIntent(fragmentName, args, titleRes, shortTitleRes);
        {
            startActivity(intent);
        } 
        {
            resultTo.startActivityForResult(intent, resultRequestCode);
        } 
        addTaint(fragmentName.getTaint());
        addTaint(args.getTaint());
        addTaint(resultTo.getTaint());
        addTaint(resultRequestCode);
        addTaint(titleRes);
        addTaint(shortTitleRes);
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.367 -0400", hash_original_method = "4F3C5CDBD4880824AF39CB9E5E4A33FC", hash_generated_method = "EC5EB591A9DDD9FF4C8C459D50CD6D00")
    public void showBreadCrumbs(CharSequence title, CharSequence shortTitle) {
        {
            View crumbs = findViewById(android.R.id.title);
            try 
            {
                mFragmentBreadCrumbs = (FragmentBreadCrumbs)crumbs;
            } 
            catch (ClassCastException e)
            { }
            {
                {
                    setTitle(title);
                } 
            } 
            mFragmentBreadCrumbs.setMaxVisible(2);
            mFragmentBreadCrumbs.setActivity(this);
        } 
        mFragmentBreadCrumbs.setTitle(title, shortTitle);
        mFragmentBreadCrumbs.setParentTitle(null, null, null);
        addTaint(title.getTaint());
        addTaint(shortTitle.getTaint());
        
        
            
            
                
            
                
            
            
                
                    
                
                
            
            
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.367 -0400", hash_original_method = "1549DF3FA5C3B3F8F6931C4E058E1944", hash_generated_method = "6AA3BF014DB67A933D14B4A9B3EF7856")
    public void setParentTitle(CharSequence title, CharSequence shortTitle,
            OnClickListener listener) {
        {
            mFragmentBreadCrumbs.setParentTitle(title, shortTitle, listener);
        } 
        addTaint(title.getTaint());
        addTaint(shortTitle.getTaint());
        addTaint(listener.getTaint());
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.368 -0400", hash_original_method = "6CD55A84320A14788B0DD27C2F943CD9", hash_generated_method = "5981A5AC90CBE9CC7045855C435628D3")
     void setSelectedHeader(Header header) {
        mCurHeader = header;
        int index = mHeaders.indexOf(header);
        {
            getListView().setItemChecked(index, true);
        } 
        {
            getListView().clearChoices();
        } 
        showBreadCrumbs(header);
        
        
        
        
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.368 -0400", hash_original_method = "DBABA4F3A7CA13D3BE4599BE843A33E0", hash_generated_method = "073FBEB4451545CC7DA93EEE6B568E00")
     void showBreadCrumbs(Header header) {
        {
            CharSequence title = header.getBreadCrumbTitle(getResources());
            title = header.getTitle(getResources());
            title = getTitle();
            showBreadCrumbs(title, header.getBreadCrumbShortTitle(getResources()));
        } 
        {
            showBreadCrumbs(getTitle(), null);
        } 
        addTaint(header.getTaint());
        
        
            
            
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.368 -0400", hash_original_method = "7A46889D874DD705E59FA4FB1509394D", hash_generated_method = "9AE7071D10C51ABB3A9A84CE965C4BA9")
    private void switchToHeaderInner(String fragmentName, Bundle args, int direction) {
        getFragmentManager().popBackStack(BACK_STACK_PREFS,
                FragmentManager.POP_BACK_STACK_INCLUSIVE);
        Fragment f = Fragment.instantiate(this, fragmentName, args);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        transaction.replace(com.android.internal.R.id.prefs, f);
        transaction.commitAllowingStateLoss();
        addTaint(fragmentName.getTaint());
        addTaint(args.getTaint());
        addTaint(direction);
        
        
                
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.369 -0400", hash_original_method = "1F3D49C208A22CE80DD0C39318B7FB91", hash_generated_method = "099C14639DAE655741E9D9D13E0A37A9")
    public void switchToHeader(String fragmentName, Bundle args) {
        setSelectedHeader(null);
        switchToHeaderInner(fragmentName, args, 0);
        addTaint(fragmentName.getTaint());
        addTaint(args.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.369 -0400", hash_original_method = "439F40B8AE0DFA06D4CE3EB843023A82", hash_generated_method = "2651D867B417CA357603F222594F2BE8")
    public void switchToHeader(Header header) {
        {
            getFragmentManager().popBackStack(BACK_STACK_PREFS,
                    FragmentManager.POP_BACK_STACK_INCLUSIVE);
        } 
        {
            int direction = mHeaders.indexOf(header) - mHeaders.indexOf(mCurHeader);
            switchToHeaderInner(header.fragment, header.fragmentArguments, direction);
            setSelectedHeader(header);
        } 
        addTaint(header.getTaint());
        
        
            
                    
        
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.371 -0400", hash_original_method = "A27B5089D7C34DCC8F697434FD74BDF2", hash_generated_method = "C1890811DC8886E8BEECB2C3814E7BF6")
     Header findBestMatchingHeader(Header cur, ArrayList<Header> from) {
        Header varB4EAC82CA7396A68D541C85D26508E83_1497376996 = null; 
        Header varB4EAC82CA7396A68D541C85D26508E83_2090929088 = null; 
        Header varB4EAC82CA7396A68D541C85D26508E83_1502574901 = null; 
        Header varB4EAC82CA7396A68D541C85D26508E83_132431259 = null; 
        Header varB4EAC82CA7396A68D541C85D26508E83_982564609 = null; 
        ArrayList<Header> matches = new ArrayList<Header>();
        {
            int j = 0;
            boolean varD2B83A07940AD2FCC09DE02F8C6611C9_1193971561 = (j<from.size());
            {
                Header oh = from.get(j);
                {
                    matches.clear();
                    matches.add(oh);
                } 
                {
                    {
                        boolean varB609688441FFD779964D632A69036A70_2028830934 = (cur.fragment.equals(oh.fragment));
                        {
                            matches.add(oh);
                        } 
                    } 
                } 
                {
                    {
                        boolean var06842B930564AE514F8A239E6992E155_1975412732 = (cur.intent.equals(oh.intent));
                        {
                            matches.add(oh);
                        } 
                    } 
                } 
                {
                    {
                        boolean var4A426A86AF313259696B16DB6F4D6498_2041759995 = (cur.title.equals(oh.title));
                        {
                            matches.add(oh);
                        } 
                    } 
                } 
            } 
        } 
        final int NM = matches.size();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1497376996 = matches.get(0);
        } 
        {
            {
                int j = 0;
                {
                    Header oh = matches.get(j);
                    {
                        boolean var98CA1E00A10F515D2E57E097A1D05BB9_1871177267 = (cur.fragmentArguments != null &&
                        cur.fragmentArguments.equals(oh.fragmentArguments));
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_2090929088 = oh;
                        } 
                    } 
                    {
                        boolean varACD7FE70235FC87BB57677F1298E5E1E_191626364 = (cur.extras != null && cur.extras.equals(oh.extras));
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_1502574901 = oh;
                        } 
                    } 
                    {
                        boolean varFD818620707839EB3618AD38A41F0598_1668908473 = (cur.title != null && cur.title.equals(oh.title));
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_132431259 = oh;
                        } 
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_982564609 = null;
        addTaint(cur.getTaint());
        addTaint(from.getTaint());
        Header varA7E53CE21691AB073D9660D615818899_169772439; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_169772439 = varB4EAC82CA7396A68D541C85D26508E83_1497376996;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_169772439 = varB4EAC82CA7396A68D541C85D26508E83_2090929088;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_169772439 = varB4EAC82CA7396A68D541C85D26508E83_1502574901;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_169772439 = varB4EAC82CA7396A68D541C85D26508E83_132431259;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_169772439 = varB4EAC82CA7396A68D541C85D26508E83_982564609;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_169772439.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_169772439;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.371 -0400", hash_original_method = "20FDC2DC66402E55AE5BF59B2D025057", hash_generated_method = "A452DEF7287F95DC48919A82387FC55D")
    public void startPreferenceFragment(Fragment fragment, boolean push) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(com.android.internal.R.id.prefs, fragment);
        {
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            transaction.addToBackStack(BACK_STACK_PREFS);
        } 
        {
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        } 
        transaction.commitAllowingStateLoss();
        addTaint(fragment.getTaint());
        addTaint(push);
        
        
        
        
            
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.372 -0400", hash_original_method = "E25F9CE570E0BFA743AE6FCAFFB6168D", hash_generated_method = "9AD7FCF3DE9BC12208350C59BD0578FD")
    public void startPreferencePanel(String fragmentClass, Bundle args, int titleRes,
            CharSequence titleText, Fragment resultTo, int resultRequestCode) {
        {
            startWithFragment(fragmentClass, args, resultTo, resultRequestCode, titleRes, 0);
        } 
        {
            Fragment f = Fragment.instantiate(this, fragmentClass, args);
            {
                f.setTargetFragment(resultTo, resultRequestCode);
            } 
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(com.android.internal.R.id.prefs, f);
            {
                transaction.setBreadCrumbTitle(titleRes);
            } 
            {
                transaction.setBreadCrumbTitle(titleText);
            } 
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            transaction.addToBackStack(BACK_STACK_PREFS);
            transaction.commitAllowingStateLoss();
        } 
        addTaint(fragmentClass.getTaint());
        addTaint(args.getTaint());
        addTaint(titleRes);
        addTaint(titleText.getTaint());
        addTaint(resultTo.getTaint());
        addTaint(resultRequestCode);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.374 -0400", hash_original_method = "35CCCF58010C828A125388DBAAB260E2", hash_generated_method = "6204A7BE7AF4C35F6D9CAB69B4FAB057")
    public void finishPreferencePanel(Fragment caller, int resultCode, Intent resultData) {
        {
            setResult(resultCode, resultData);
            finish();
        } 
        {
            onBackPressed();
            {
                {
                    boolean var05213B3A3869F77879DB09487CF0868B_1535169615 = (caller.getTargetFragment() != null);
                    {
                        caller.getTargetFragment().onActivityResult(caller.getTargetRequestCode(),
                            resultCode, resultData);
                    } 
                } 
            } 
        } 
        addTaint(caller.getTaint());
        addTaint(resultCode);
        addTaint(resultData.getTaint());
        
        
            
            
        
            
            
                
                    
                            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.375 -0400", hash_original_method = "88B12B83AF6C82165835FAA52B723B1A", hash_generated_method = "DACC93F527BA7DB25BBB52E2DC4FD374")
    @Override
    public boolean onPreferenceStartFragment(PreferenceFragment caller, Preference pref) {
        
        startPreferencePanel(pref.getFragment(), pref.getExtras(), pref.getTitleRes(),
                pref.getTitle(), null, 0);
        addTaint(caller.getTaint());
        addTaint(pref.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1121737806 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1121737806;
        
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.375 -0400", hash_original_method = "6C1825C42631AE6FCE57D0240C5D762E", hash_generated_method = "98E39F6FCC867B9D6EB994337181A754")
    private void postBindPreferences() {
        {
            boolean var0A3D3B0504D764BC1C3FB906BCA6B206_1980560407 = (mHandler.hasMessages(MSG_BIND_PREFERENCES));
        } 
        mHandler.obtainMessage(MSG_BIND_PREFERENCES).sendToTarget();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.375 -0400", hash_original_method = "548F27FE8CA6D6649BD8B5A7939C474E", hash_generated_method = "B27868F34D69115F2950B48B70E88D58")
    private void bindPreferences() {
        final PreferenceScreen preferenceScreen = getPreferenceScreen();
        {
            preferenceScreen.bind(getListView());
            {
                super.onRestoreInstanceState(mSavedInstanceState);
                mSavedInstanceState = null;
            } 
        } 
        
        
        
            
            
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.376 -0400", hash_original_method = "002FC5CEE5BE5B5D1FE36CEDBC1DEB65", hash_generated_method = "FDB48B8C54349F6D86C6A73008EF5547")
    @Deprecated
    public PreferenceManager getPreferenceManager() {
        PreferenceManager varB4EAC82CA7396A68D541C85D26508E83_918013968 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_918013968 = mPreferenceManager;
        varB4EAC82CA7396A68D541C85D26508E83_918013968.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_918013968;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.376 -0400", hash_original_method = "B2669BE6B91E4B8BF7765D817C0F2C8A", hash_generated_method = "012E4F81E02E147BD2D416E482E7C516")
    private void requirePreferenceManager() {
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException("This should be called after super.onCreate.");
            } 
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                    "Modern two-pane PreferenceActivity requires use of a PreferenceFragment");
        } 
        
        
            
                
            
            
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.377 -0400", hash_original_method = "20BEF3079E316F6730A81E488DFA70F2", hash_generated_method = "893B620C0714442ABA0B754EBE4B5DED")
    @Deprecated
    public void setPreferenceScreen(PreferenceScreen preferenceScreen) {
        requirePreferenceManager();
        {
            boolean var551C8AB5BC879C26D0247C3960A9CA65_843359243 = (mPreferenceManager.setPreferences(preferenceScreen) && preferenceScreen != null);
            {
                postBindPreferences();
                CharSequence title = getPreferenceScreen().getTitle();
                {
                    setTitle(title);
                } 
            } 
        } 
        addTaint(preferenceScreen.getTaint());
        
        
        
            
            
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.377 -0400", hash_original_method = "7CC03E7D3EBAF4E1E382E9E7A55EF0AE", hash_generated_method = "54EB01FBB688C1739176D5AE0339DDDD")
    @Deprecated
    public PreferenceScreen getPreferenceScreen() {
        PreferenceScreen varB4EAC82CA7396A68D541C85D26508E83_375737688 = null; 
        PreferenceScreen varB4EAC82CA7396A68D541C85D26508E83_1878234937 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_375737688 = mPreferenceManager.getPreferenceScreen();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1878234937 = null;
        PreferenceScreen varA7E53CE21691AB073D9660D615818899_1445772607; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1445772607 = varB4EAC82CA7396A68D541C85D26508E83_375737688;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1445772607 = varB4EAC82CA7396A68D541C85D26508E83_1878234937;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1445772607.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1445772607;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.378 -0400", hash_original_method = "5674CE8C214451535BFAB18211614C8C", hash_generated_method = "93A4A732934FD8FFA0ABE2E40CF5EAA5")
    @Deprecated
    public void addPreferencesFromIntent(Intent intent) {
        requirePreferenceManager();
        setPreferenceScreen(mPreferenceManager.inflateFromIntent(intent, getPreferenceScreen()));
        addTaint(intent.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.378 -0400", hash_original_method = "1D27A71B873F6C05FF2DA5D8C133ED30", hash_generated_method = "F61A9E9524F31BE80BAB0A913149E477")
    @Deprecated
    public void addPreferencesFromResource(int preferencesResId) {
        requirePreferenceManager();
        setPreferenceScreen(mPreferenceManager.inflateFromResource(this, preferencesResId,
                getPreferenceScreen()));
        addTaint(preferencesResId);
        
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.378 -0400", hash_original_method = "ADC2C8250ACD9F9573CD9A45AF1661C3", hash_generated_method = "D3582C85661738A4289F0C23DC4A69E4")
    @Deprecated
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
        
        addTaint(preferenceScreen.getTaint());
        addTaint(preference.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1992350907 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1992350907;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.379 -0400", hash_original_method = "0C794FFD7CBFBB35093DF6CE24875508", hash_generated_method = "0AFAF5561FBF2459E85BB2D1F7200065")
    @Deprecated
    public Preference findPreference(CharSequence key) {
        Preference varB4EAC82CA7396A68D541C85D26508E83_663194278 = null; 
        Preference varB4EAC82CA7396A68D541C85D26508E83_878930753 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_663194278 = null;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_878930753 = mPreferenceManager.findPreference(key);
        addTaint(key.getTaint());
        Preference varA7E53CE21691AB073D9660D615818899_1650219859; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1650219859 = varB4EAC82CA7396A68D541C85D26508E83_663194278;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1650219859 = varB4EAC82CA7396A68D541C85D26508E83_878930753;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1650219859.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1650219859;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.380 -0400", hash_original_method = "5A6127558FF9D60C52821F59A1A351C3", hash_generated_method = "F6066D2E4DA28AFE4FDCE25F8D97A89C")
    @Override
    protected void onNewIntent(Intent intent) {
        
        {
            mPreferenceManager.dispatchNewIntent(intent);
        } 
        addTaint(intent.getTaint());
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.380 -0400", hash_original_method = "BC54EB6D436D19F86F3C9657BD0BE1AA", hash_generated_method = "134494D7DDB9B30DCB7FEE3BEAF43CCC")
    protected boolean hasNextButton() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1253747436 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1253747436;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.380 -0400", hash_original_method = "CC6F0F14612F322772A46478BA75E81F", hash_generated_method = "E918EA6CDAF50A53479FBE18823F68DE")
    protected Button getNextButton() {
        Button varB4EAC82CA7396A68D541C85D26508E83_414962954 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_414962954 = mNextButton;
        varB4EAC82CA7396A68D541C85D26508E83_414962954.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_414962954;
        
        
    }

    
    private static class HeaderAdapter extends ArrayAdapter<Header> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.381 -0400", hash_original_field = "D03597FDEDE23F3823480E0520822BB2", hash_generated_field = "CBB0EE0A851756643DA52E1D33B6B161")

        private LayoutInflater mInflater;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.381 -0400", hash_original_method = "F02F4C5BC3B955ED93786AEEC10379FE", hash_generated_method = "4BF8FCE86F96A9348B08B0BB4D559984")
        public  HeaderAdapter(Context context, List<Header> objects) {
            super(context, 0, objects);
            mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            addTaint(objects.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.383 -0400", hash_original_method = "BD15B4EB453F2C74F6031A45FD2B76C2", hash_generated_method = "039EF49EF52F7D0497B314774D591D97")
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View varB4EAC82CA7396A68D541C85D26508E83_1406905214 = null; 
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
            } 
            {
                view = convertView;
                holder = (HeaderViewHolder) view.getTag();
            } 
            Header header = getItem(position);
            holder.icon.setImageResource(header.iconRes);
            holder.title.setText(header.getTitle(getContext().getResources()));
            CharSequence summary = header.getSummary(getContext().getResources());
            {
                boolean var33886BAB7464784CE6FA21654C0C5CE0_435405072 = (!TextUtils.isEmpty(summary));
                {
                    holder.summary.setVisibility(View.VISIBLE);
                    holder.summary.setText(summary);
                } 
                {
                    holder.summary.setVisibility(View.GONE);
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1406905214 = view;
            addTaint(position);
            addTaint(convertView.getTaint());
            addTaint(parent.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1406905214.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1406905214;
            
            
        }

        
        private static class HeaderViewHolder {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.383 -0400", hash_original_field = "BAEC6461B0D69DDE1B861AEFBE375D8A", hash_generated_field = "7D496A7EF4277B81CF926C9FC9D04248")

            ImageView icon;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.383 -0400", hash_original_field = "D5D3DB1765287EEF77D7927CC956F50A", hash_generated_field = "D2FBB4059A3EADAB444F225698E4F56E")

            TextView title;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.383 -0400", hash_original_field = "A80DA1282F2C775BBC5F2C92C836968B", hash_generated_field = "BA7542FFBE4C8102C12065D859063619")

            TextView summary;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.384 -0400", hash_original_method = "7AAB7B01E6419825274A30D2382564EA", hash_generated_method = "7AAB7B01E6419825274A30D2382564EA")
            public HeaderViewHolder ()
            {
                
            }


        }


        
    }


    
    public static final class Header implements Parcelable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.384 -0400", hash_original_field = "CD9D7F08098BD235A18AE68FCAFCDC6A", hash_generated_field = "737A7D6903ECE33BE0237DB5C22496D2")

        public long id = HEADER_ID_UNDEFINED;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.384 -0400", hash_original_field = "608C178BEAA10D047DA1A404A17FEEF5", hash_generated_field = "3FD6C8139DEDC39179812C2724BF57B9")

        public int titleRes;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.384 -0400", hash_original_field = "D5D3DB1765287EEF77D7927CC956F50A", hash_generated_field = "285EF5A6A116FF608EE0587EA9C0F06D")

        public CharSequence title;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.384 -0400", hash_original_field = "05DF20411D7FE5FD44C56C61ADE561A9", hash_generated_field = "CF9D7763F41618969B1EF555AA62D675")

        public int summaryRes;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.384 -0400", hash_original_field = "A80DA1282F2C775BBC5F2C92C836968B", hash_generated_field = "649E9B273BD3EE954608217A46D60F9B")

        public CharSequence summary;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.384 -0400", hash_original_field = "EA055285E63FE8F3AEBF3FF66EAD77EC", hash_generated_field = "2CD689A4778432DF6FA02D3B2B9056EA")

        public int breadCrumbTitleRes;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.384 -0400", hash_original_field = "EC414BEC23FAE15429CFD80EB6C67E2E", hash_generated_field = "73EEB773801D9077B302E48B9DC2F190")

        public CharSequence breadCrumbTitle;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.384 -0400", hash_original_field = "E547092BCAACD041884B348DB68C9AFC", hash_generated_field = "61F809170E6E2C53D80864D07EEB140C")

        public int breadCrumbShortTitleRes;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.384 -0400", hash_original_field = "BC12220BB3538919F835A9A75EA14EA8", hash_generated_field = "12A2018B53E7263915979427C28D6095")

        public CharSequence breadCrumbShortTitle;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.384 -0400", hash_original_field = "1AFA68AAD1FD9765C18E4975F512B2FD", hash_generated_field = "800898B731FFFE010B18EB819F288168")

        public int iconRes;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.384 -0400", hash_original_field = "02E918FC72837D7C2689BE88684DCEB1", hash_generated_field = "3FCA1C3F48B0A85017F597A00E283B60")

        public String fragment;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.384 -0400", hash_original_field = "42BE488D27E9D9A55607EBD0D4EE93C5", hash_generated_field = "B8BBDD0C2C5BEF49B225AB4995204C33")

        public Bundle fragmentArguments;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.384 -0400", hash_original_field = "FA48C7D544739BA0E46430E4BA366662", hash_generated_field = "5DEDAC72AD89B3864945324786195E0B")

        public Intent intent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.384 -0400", hash_original_field = "27353006CFD751D26221E04A7928034D", hash_generated_field = "360651D25CBD3D75EA270BBFA49C37D4")

        public Bundle extras;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.385 -0400", hash_original_method = "CC8692EE42ED9AE9CFD9E664B2A1E936", hash_generated_method = "D78360B1F9ED0AA24422BF34D2B11223")
        public  Header() {
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.385 -0400", hash_original_method = "3E4088512988FAACC868C0BAC5E638A1", hash_generated_method = "3D2638C4E4B60CE25F1B6D2D2D061EC9")
          Header(Parcel in) {
            readFromParcel(in);
            addTaint(in.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.386 -0400", hash_original_method = "334D1E94CC98A584AC982CEC8D5C3813", hash_generated_method = "702DA6B76E1C4CC7FA371E590BA03B6F")
        public CharSequence getTitle(Resources res) {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_1518036942 = null; 
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_1634589924 = null; 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1518036942 = res.getText(titleRes);
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1634589924 = title;
            addTaint(res.getTaint());
            CharSequence varA7E53CE21691AB073D9660D615818899_1253068103; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_1253068103 = varB4EAC82CA7396A68D541C85D26508E83_1518036942;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1253068103 = varB4EAC82CA7396A68D541C85D26508E83_1634589924;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1253068103.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_1253068103;
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.387 -0400", hash_original_method = "817FA0FA7A0D92830E14FE64024CE8CC", hash_generated_method = "26426FE518A4FDFAA21FC02A963CBB10")
        public CharSequence getSummary(Resources res) {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_1942129793 = null; 
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_1671646670 = null; 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1942129793 = res.getText(summaryRes);
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1671646670 = summary;
            addTaint(res.getTaint());
            CharSequence varA7E53CE21691AB073D9660D615818899_1380273538; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_1380273538 = varB4EAC82CA7396A68D541C85D26508E83_1942129793;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1380273538 = varB4EAC82CA7396A68D541C85D26508E83_1671646670;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1380273538.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_1380273538;
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.388 -0400", hash_original_method = "AB517FA9C1DC5B1E62910A1ABDCECDD0", hash_generated_method = "DEB1A62FCA8ACCA4F1A4CFAC3F6978C9")
        public CharSequence getBreadCrumbTitle(Resources res) {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_1978876152 = null; 
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_585241720 = null; 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1978876152 = res.getText(breadCrumbTitleRes);
            } 
            varB4EAC82CA7396A68D541C85D26508E83_585241720 = breadCrumbTitle;
            addTaint(res.getTaint());
            CharSequence varA7E53CE21691AB073D9660D615818899_1019664216; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_1019664216 = varB4EAC82CA7396A68D541C85D26508E83_1978876152;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1019664216 = varB4EAC82CA7396A68D541C85D26508E83_585241720;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1019664216.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_1019664216;
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.388 -0400", hash_original_method = "F11776C7591643DD9CB4C4ECCD867732", hash_generated_method = "6195E69E7640331F21A8028CE56C1D75")
        public CharSequence getBreadCrumbShortTitle(Resources res) {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_1306084495 = null; 
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_2003460133 = null; 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1306084495 = res.getText(breadCrumbShortTitleRes);
            } 
            varB4EAC82CA7396A68D541C85D26508E83_2003460133 = breadCrumbShortTitle;
            addTaint(res.getTaint());
            CharSequence varA7E53CE21691AB073D9660D615818899_977812753; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_977812753 = varB4EAC82CA7396A68D541C85D26508E83_1306084495;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_977812753 = varB4EAC82CA7396A68D541C85D26508E83_2003460133;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_977812753.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_977812753;
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.389 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "8E271ED24B79FA6D40EA12E5B60D9157")
        @Override
        public int describeContents() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1365525159 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1365525159;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.389 -0400", hash_original_method = "BB0DBC9520A7E98C1F6BA8AD4772118F", hash_generated_method = "806E7F393AD3463C295E19AD88192853")
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
            } 
            {
                dest.writeInt(0);
            } 
            dest.writeBundle(extras);
            addTaint(dest.getTaint());
            addTaint(flags);
            
            
            
            
            
            
            
            
            
            
            
            
            
            
                
                
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.390 -0400", hash_original_method = "29282A1B26F647059DDF5369C2CB137B", hash_generated_method = "EFE214EB4E4109430E22166B455A2679")
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
                boolean var331417C59A822E59FB0B216D2F29CB47_544854899 = (in.readInt() != 0);
                {
                    intent = Intent.CREATOR.createFromParcel(in);
                } 
            } 
            extras = in.readBundle();
            
            
            
            
            
            
            
            
            
            
            
            
            
            
                
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.390 -0400", hash_original_field = "80358CCA6C151B1C75C8F6D01427BC96", hash_generated_field = "0285FC5896D2C8A81AC7F6CCCD215EAF")

        public static final Creator<Header> CREATOR = new Creator<Header>() {
            public Header createFromParcel(Parcel source) {
                return new Header(source);
            }
            public Header[] newArray(int size) {
                return new Header[size];
            }
        };
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.390 -0400", hash_original_field = "5224C355FB3151226DCBB252E71D8C45", hash_generated_field = "2E084579604068AECB302A705EB28607")

    private static final String HEADERS_TAG = ":android:headers";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.390 -0400", hash_original_field = "24813F27F5BB25614DE5963D935AEC65", hash_generated_field = "475A448573DAB6E82A443372F6B23A12")

    private static final String CUR_HEADER_TAG = ":android:cur_header";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.390 -0400", hash_original_field = "6B4950CB402849CFD7FF819E761EC566", hash_generated_field = "95AADD698D0027248B58F382F8E7BC71")

    private static final String PREFERENCES_TAG = ":android:preferences";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.390 -0400", hash_original_field = "8E1D2567A8F5FC0D4CCD7E7D4E5D61DA", hash_generated_field = "46D5D655E675E9CC41AA95971DA7C983")

    public static final String EXTRA_SHOW_FRAGMENT = ":android:show_fragment";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.390 -0400", hash_original_field = "24CAAB8CA0E6C99A6AFA2C78AA37D067", hash_generated_field = "238348398E3BDE30D489970315DCB2F7")

    public static final String EXTRA_SHOW_FRAGMENT_ARGUMENTS = ":android:show_fragment_args";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.390 -0400", hash_original_field = "6C8D245A63EEB3438D48DA1A14CC14B3", hash_generated_field = "9EDA9A80F485D711E436660545646846")

    public static final String EXTRA_SHOW_FRAGMENT_TITLE = ":android:show_fragment_title";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.390 -0400", hash_original_field = "B6BA4D79DB131AD112A933A84B09B7F5", hash_generated_field = "72E65F21D21C144A50537392CA5C7A04")

    public static final String EXTRA_SHOW_FRAGMENT_SHORT_TITLE
            = ":android:show_fragment_short_title";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.390 -0400", hash_original_field = "A307AC2DB4EF1E817C27C8522EB96281", hash_generated_field = "D38B44E415912850DD5978247D2C7A68")

    public static final String EXTRA_NO_HEADERS = ":android:no_headers";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.390 -0400", hash_original_field = "86E59DEBCAC94735618BAF4F9F1733CE", hash_generated_field = "A284837FF977B323F510310B8A0B07BC")

    private static final String BACK_STACK_PREFS = ":android:prefs";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.390 -0400", hash_original_field = "C933A32E9C9683A1B47540929477CEAC", hash_generated_field = "098F0E24A0AA8F1878CCD553C99A0536")

    private static final String EXTRA_PREFS_SHOW_BUTTON_BAR = "extra_prefs_show_button_bar";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.390 -0400", hash_original_field = "5D4A5C2C86B5EB9C1BF49D09CE1DB767", hash_generated_field = "B496A57DC5DA5028C2D08B42DAE92474")

    private static final String EXTRA_PREFS_SHOW_SKIP = "extra_prefs_show_skip";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.390 -0400", hash_original_field = "C1643E502B9F83474DDF3C1BA3B34047", hash_generated_field = "66E2D8A3053DB56E24A1B4E8D7484ED3")

    private static final String EXTRA_PREFS_SET_NEXT_TEXT = "extra_prefs_set_next_text";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.390 -0400", hash_original_field = "4CE17D3BE7186684C204C2BE77C91C4A", hash_generated_field = "9CF302D5D1C7AB16535FE30602ABF893")

    private static final String EXTRA_PREFS_SET_BACK_TEXT = "extra_prefs_set_back_text";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.390 -0400", hash_original_field = "0466831DAC50AD91F00BE2472F26C26A", hash_generated_field = "0136D59B093194DD543B8062A7975D9E")

    private static final int FIRST_REQUEST_CODE = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.390 -0400", hash_original_field = "D7A6754ED93721763C237AE926734ECE", hash_generated_field = "7A68CD10BF8C3B855976E8E8F733E671")

    private static final int MSG_BIND_PREFERENCES = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.390 -0400", hash_original_field = "A311ADD455E28882DFBE1013B45DE390", hash_generated_field = "CF41B970CC3B897D25CF787D434428D5")

    private static final int MSG_BUILD_HEADERS = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.390 -0400", hash_original_field = "66B9C0557A7ABDF9846F2E4A3158DC16", hash_generated_field = "D3EEEA8888F40DB4597966262702A0F4")

    public static final long HEADER_ID_UNDEFINED = -1;
}

