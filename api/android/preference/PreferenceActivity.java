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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.356 -0400", hash_original_field = "B4437D0EBCCFE94A5CAF24979E87BFF3", hash_generated_field = "05229AEEB45F74E6571A04947AF7440D")

    private final ArrayList<Header> mHeaders = new ArrayList<Header>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.357 -0400", hash_original_field = "2F6930B6C645E4D8ACA3F8AB58293E8F", hash_generated_field = "FD5AB4D46307B27E8B131FCC69B56024")

    private FrameLayout mListFooter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.357 -0400", hash_original_field = "4869BE0BA3554EC728CBE9D046D8CE8D", hash_generated_field = "7F048D850CFE3A627851CBB7E986274C")

    private ViewGroup mPrefsContainer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.358 -0400", hash_original_field = "57396922F5B63ED226B6755FB75B8ABD", hash_generated_field = "C9A9E888C6CF8869C49ADC5AA023A69B")

    private FragmentBreadCrumbs mFragmentBreadCrumbs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.359 -0400", hash_original_field = "A766A90F5B30D5F0A747208880E91C20", hash_generated_field = "A5B8DDF0DF04B9985F211EFD1518F984")

    private boolean mSinglePane;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.360 -0400", hash_original_field = "B922356C2BC86CDD61900AA9E1D0840F", hash_generated_field = "801A7E2120484101CEC1CFAD107C2A9C")

    private Header mCurHeader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.361 -0400", hash_original_field = "D1487CA8252F4AA0A95324AB4DDD5316", hash_generated_field = "13262EB3751B753EEB3302EF75D8B1E5")

    private PreferenceManager mPreferenceManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.362 -0400", hash_original_field = "A587E455CA5C0B536357B11202A985DD", hash_generated_field = "04DDA78321A9F720FA97A23B9C869D4C")

    private Bundle mSavedInstanceState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.363 -0400", hash_original_field = "25A8D69C909160605880E75D8AC0CC0C", hash_generated_field = "128183E1ED5B562A53AAED4DF9F0640D")

    private Button mNextButton;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.368 -0400", hash_original_field = "92EE827C36817A69E1CF224FB382CB43", hash_generated_field = "17A435BCB512B12289624DA1E2A26680")

    private Handler mHandler = new Handler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.366 -0400", hash_original_method = "DC47A807DF4ECAC4EAC562CA0F303D11", hash_generated_method = "925BA49D313903DC573EDBB90D8D6F26")
        @Override
        public void handleMessage(Message msg) {
            addTaint(msg.getTaint());
switch(msg.what){
            case MSG_BIND_PREFERENCES:
            {
                bindPreferences();
            } //End block
            break;
            case MSG_BUILD_HEADERS:
            {
                ArrayList<Header> oldHeaders = new ArrayList<Header>(mHeaders);
                mHeaders.clear();
                onBuildHeaders(mHeaders);
                if(mAdapter instanceof BaseAdapter)                
                {
                    ((BaseAdapter) mAdapter).notifyDataSetChanged();
                } //End block
                Header header = onGetNewHeader();
                if(header != null && header.fragment != null)                
                {
                    Header mappedHeader = findBestMatchingHeader(header, oldHeaders);
                    if(mappedHeader == null || mCurHeader != mappedHeader)                    
                    {
                        switchToHeader(header);
                    } //End block
                } //End block
                else
                if(mCurHeader != null)                
                {
                    Header mappedHeader = findBestMatchingHeader(mCurHeader, mHeaders);
                    if(mappedHeader != null)                    
                    {
                        setSelectedHeader(mappedHeader);
                    } //End block
                } //End block
            } //End block
            break;
}
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
};
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.369 -0400", hash_original_method = "5B933AEEC6389C71875EE2A57A875A3A", hash_generated_method = "5B933AEEC6389C71875EE2A57A875A3A")
    public PreferenceActivity ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.398 -0400", hash_original_method = "7377982A731D92C32EEEF871F40BFABD", hash_generated_method = "D43BC4C519BC8078BE2429A9EA44CB1F")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(savedInstanceState.getTaint());
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
        if(savedInstanceState != null)        
        {
            ArrayList<Header> headers = savedInstanceState.getParcelableArrayList(HEADERS_TAG);
            if(headers != null)            
            {
                mHeaders.addAll(headers);
                int curHeader = savedInstanceState.getInt(CUR_HEADER_TAG,
                        (int) HEADER_ID_UNDEFINED);
                if(curHeader >= 0 && curHeader < mHeaders.size())                
                {
                    setSelectedHeader(mHeaders.get(curHeader));
                } //End block
            } //End block
        } //End block
        else
        {
            if(initialFragment != null && mSinglePane)            
            {
                switchToHeader(initialFragment, initialArguments);
                if(initialTitle != 0)                
                {
                    CharSequence initialTitleStr = getText(initialTitle);
                    CharSequence initialShortTitleStr = initialShortTitle != 0
                            ? getText(initialShortTitle) : null;
                    showBreadCrumbs(initialTitleStr, initialShortTitleStr);
                } //End block
            } //End block
            else
            {
                onBuildHeaders(mHeaders);
                if(mHeaders.size() > 0)                
                {
                    if(!mSinglePane)                    
                    {
                        if(initialFragment == null)                        
                        {
                            Header h = onGetInitialHeader();
                            switchToHeader(h);
                        } //End block
                        else
                        {
                            switchToHeader(initialFragment, initialArguments);
                        } //End block
                    } //End block
                } //End block
            } //End block
        } //End block
        if(initialFragment != null && mSinglePane)        
        {
            findViewById(com.android.internal.R.id.headers).setVisibility(View.GONE);
            mPrefsContainer.setVisibility(View.VISIBLE);
            if(initialTitle != 0)            
            {
                CharSequence initialTitleStr = getText(initialTitle);
                CharSequence initialShortTitleStr = initialShortTitle != 0
                        ? getText(initialShortTitle) : null;
                showBreadCrumbs(initialTitleStr, initialShortTitleStr);
            } //End block
        } //End block
        else
        if(mHeaders.size() > 0)        
        {
            setListAdapter(new HeaderAdapter(this, mHeaders));
            if(!mSinglePane)            
            {
                getListView().setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
                if(mCurHeader != null)                
                {
                    setSelectedHeader(mCurHeader);
                } //End block
                mPrefsContainer.setVisibility(View.VISIBLE);
            } //End block
        } //End block
        else
        {
            setContentView(com.android.internal.R.layout.preference_list_content_single);
            mListFooter = (FrameLayout) findViewById(com.android.internal.R.id.list_footer);
            mPrefsContainer = (ViewGroup) findViewById(com.android.internal.R.id.prefs);
            mPreferenceManager = new PreferenceManager(this, FIRST_REQUEST_CODE);
            mPreferenceManager.setOnPreferenceTreeClickListener(this);
        } //End block
        Intent intent = getIntent();
        if(intent.getBooleanExtra(EXTRA_PREFS_SHOW_BUTTON_BAR, false))        
        {
            findViewById(com.android.internal.R.id.button_bar).setVisibility(View.VISIBLE);
            Button backButton = (Button)findViewById(com.android.internal.R.id.back_button);
            backButton.setOnClickListener(new OnClickListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.380 -0400", hash_original_method = "B6AEEA4CFEDD0D6DCDC87F0A632F7AF4", hash_generated_method = "A2DEEC0BCA2EEE58B67D32434F6F4501")
        public void onClick(View v) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(v.getTaint());
            setResult(RESULT_CANCELED);
            finish();
            // ---------- Original Method ----------
            //setResult(RESULT_CANCELED);
            //finish();
        }
});
            Button skipButton = (Button)findViewById(com.android.internal.R.id.skip_button);
            skipButton.setOnClickListener(new OnClickListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.387 -0400", hash_original_method = "812DEADF112942F677940097DE15DE01", hash_generated_method = "B1B5E3C218A549B734B356DE85AA0D56")
        public void onClick(View v) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(v.getTaint());
            setResult(RESULT_OK);
            finish();
            // ---------- Original Method ----------
            //setResult(RESULT_OK);
            //finish();
        }
});
            mNextButton = (Button)findViewById(com.android.internal.R.id.next_button);
            mNextButton.setOnClickListener(new OnClickListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.393 -0400", hash_original_method = "812DEADF112942F677940097DE15DE01", hash_generated_method = "B1B5E3C218A549B734B356DE85AA0D56")
        public void onClick(View v) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(v.getTaint());
            setResult(RESULT_OK);
            finish();
            // ---------- Original Method ----------
            //setResult(RESULT_OK);
            //finish();
        }
});
            if(intent.hasExtra(EXTRA_PREFS_SET_NEXT_TEXT))            
            {
                String buttonText = intent.getStringExtra(EXTRA_PREFS_SET_NEXT_TEXT);
                if(TextUtils.isEmpty(buttonText))                
                {
                    mNextButton.setVisibility(View.GONE);
                } //End block
                else
                {
                    mNextButton.setText(buttonText);
                } //End block
            } //End block
            if(intent.hasExtra(EXTRA_PREFS_SET_BACK_TEXT))            
            {
                String buttonText = intent.getStringExtra(EXTRA_PREFS_SET_BACK_TEXT);
                if(TextUtils.isEmpty(buttonText))                
                {
                    backButton.setVisibility(View.GONE);
                } //End block
                else
                {
                    backButton.setText(buttonText);
                } //End block
            } //End block
            if(intent.getBooleanExtra(EXTRA_PREFS_SHOW_SKIP, false))            
            {
                skipButton.setVisibility(View.VISIBLE);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.408 -0400", hash_original_method = "451C86882BCD1F18856FAB1FCF2DF436", hash_generated_method = "5BD5E6A0B049D82C805602A19459792D")
    public boolean hasHeaders() {
        boolean varFB56F84D8FE8412E172376948FE3E514_482765098 = (getListView().getVisibility() == View.VISIBLE
                && mPreferenceManager == null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1791455732 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1791455732;
        // ---------- Original Method ----------
        //return getListView().getVisibility() == View.VISIBLE
                //&& mPreferenceManager == null;
    }
    
    @DSModeled(DSC.BAN)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.411 -0400", hash_original_method = "E843412269C4B791D4D2B897726E7F84", hash_generated_method = "27D79C559D8D0746EE4B45056F1FD7D3")
    public boolean isMultiPane() {
        boolean var0C9FC50197D9FDDE22A2A05DD594B236_623098030 = (hasHeaders() && mPrefsContainer.getVisibility() == View.VISIBLE);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_862147983 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_862147983;
        // ---------- Original Method ----------
        //return hasHeaders() && mPrefsContainer.getVisibility() == View.VISIBLE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.414 -0400", hash_original_method = "88171EFEE6286ACCEFBDA2CCA56DC062", hash_generated_method = "2B6E198DC14785F46F7BC0CF848BCD51")
    public boolean onIsMultiPane() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        boolean preferMultiPane = getResources().getBoolean(
                com.android.internal.R.bool.preferences_prefer_dual_pane);
        boolean var150293950C09C20400E6FF653B3B9EE7_1322437936 = (preferMultiPane);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1472061590 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1472061590;
        // ---------- Original Method ----------
        //boolean preferMultiPane = getResources().getBoolean(
                //com.android.internal.R.bool.preferences_prefer_dual_pane);
        //return preferMultiPane;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.419 -0400", hash_original_method = "6AB6F840F5A47C64B3086422C8E885E0", hash_generated_method = "A6490F25B13C2F09718AC02FF07EFB0C")
    public boolean onIsHidingHeaders() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        boolean varE1541AE2FD573B2F1C1C13AA2ACF19D5_1138729583 = (getIntent().getBooleanExtra(EXTRA_NO_HEADERS, false));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1432341742 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1432341742;
        // ---------- Original Method ----------
        //return getIntent().getBooleanExtra(EXTRA_NO_HEADERS, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.424 -0400", hash_original_method = "106989DF67000CA038D75C5F0732B905", hash_generated_method = "52A78BDC2CA7ECF1A197FE4F44FA2965")
    public Header onGetInitialHeader() {
        //DSFIXME:  CODE0009: Possible callback target function detected
Header var0F018EE4F0AD04E5FC7022D1F64677F0_402436716 =         mHeaders.get(0);
        var0F018EE4F0AD04E5FC7022D1F64677F0_402436716.addTaint(taint);
        return var0F018EE4F0AD04E5FC7022D1F64677F0_402436716;
        // ---------- Original Method ----------
        //return mHeaders.get(0);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.427 -0400", hash_original_method = "3D3F0DDAE644689D05411BA38FC63FD0", hash_generated_method = "51B7851B9DB89AE8D7238F6C5CF7E88D")
    public Header onGetNewHeader() {
        //DSFIXME:  CODE0009: Possible callback target function detected
Header var540C13E9E156B687226421B24F2DF178_1765735875 =         null;
        var540C13E9E156B687226421B24F2DF178_1765735875.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1765735875;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.432 -0400", hash_original_method = "2E92E1B9DF373424BC377EC8A240659F", hash_generated_method = "F45695A5F2F86F35BBA19C4D3E46F18D")
    public void onBuildHeaders(List<Header> target) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(target.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.435 -0400", hash_original_method = "F909FF4426F024059C8CEA2BE75ABFBE", hash_generated_method = "A6B4F2C3278193D918DF2EFB9CCD1632")
    public void invalidateHeaders() {
        if(!mHandler.hasMessages(MSG_BUILD_HEADERS))        
        {
            mHandler.sendEmptyMessage(MSG_BUILD_HEADERS);
        } //End block
        // ---------- Original Method ----------
        //if (!mHandler.hasMessages(MSG_BUILD_HEADERS)) {
            //mHandler.sendEmptyMessage(MSG_BUILD_HEADERS);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.462 -0400", hash_original_method = "004FDF3B00128708010F53C563B52195", hash_generated_method = "8520554D91842B6A8B4D11679C3EEE4B")
    public void loadHeadersFromResource(int resid, List<Header> target) {
        addTaint(target.getTaint());
        addTaint(resid);
        XmlResourceParser parser = null;
        try 
        {
            parser = getResources().getXml(resid);
            AttributeSet attrs = Xml.asAttributeSet(parser);
            int type;
            while
((type=parser.next()) != XmlPullParser.END_DOCUMENT
                    && type != XmlPullParser.START_TAG)            
            {
            } //End block
            String nodeName = parser.getName();
            if(!"preference-headers".equals(nodeName))            
            {
                RuntimeException varBD69A16DB40B45C10AB50A4F4BE55A11_546572613 = new RuntimeException(
                        "XML document must start with <preference-headers> tag; found"
                        + nodeName + " at " + parser.getPositionDescription());
                varBD69A16DB40B45C10AB50A4F4BE55A11_546572613.addTaint(taint);
                throw varBD69A16DB40B45C10AB50A4F4BE55A11_546572613;
            } //End block
            Bundle curBundle = null;
            final int outerDepth = parser.getDepth();
            while
((type=parser.next()) != XmlPullParser.END_DOCUMENT
                   && (type != XmlPullParser.END_TAG || parser.getDepth() > outerDepth))            
            {
                if(type == XmlPullParser.END_TAG || type == XmlPullParser.TEXT)                
                {
                    continue;
                } //End block
                nodeName = parser.getName();
                if("header".equals(nodeName))                
                {
                    Header header = new Header();
                    TypedArray sa = getResources().obtainAttributes(attrs,
                            com.android.internal.R.styleable.PreferenceHeader);
                    header.id = sa.getResourceId(
                            com.android.internal.R.styleable.PreferenceHeader_id,
                            (int)HEADER_ID_UNDEFINED);
                    TypedValue tv = sa.peekValue(
                            com.android.internal.R.styleable.PreferenceHeader_title);
                    if(tv != null && tv.type == TypedValue.TYPE_STRING)                    
                    {
                        if(tv.resourceId != 0)                        
                        {
                            header.titleRes = tv.resourceId;
                        } //End block
                        else
                        {
                            header.title = tv.string;
                        } //End block
                    } //End block
                    tv = sa.peekValue(
                            com.android.internal.R.styleable.PreferenceHeader_summary);
                    if(tv != null && tv.type == TypedValue.TYPE_STRING)                    
                    {
                        if(tv.resourceId != 0)                        
                        {
                            header.summaryRes = tv.resourceId;
                        } //End block
                        else
                        {
                            header.summary = tv.string;
                        } //End block
                    } //End block
                    tv = sa.peekValue(
                            com.android.internal.R.styleable.PreferenceHeader_breadCrumbTitle);
                    if(tv != null && tv.type == TypedValue.TYPE_STRING)                    
                    {
                        if(tv.resourceId != 0)                        
                        {
                            header.breadCrumbTitleRes = tv.resourceId;
                        } //End block
                        else
                        {
                            header.breadCrumbTitle = tv.string;
                        } //End block
                    } //End block
                    tv = sa.peekValue(
                            com.android.internal.R.styleable.PreferenceHeader_breadCrumbShortTitle);
                    if(tv != null && tv.type == TypedValue.TYPE_STRING)                    
                    {
                        if(tv.resourceId != 0)                        
                        {
                            header.breadCrumbShortTitleRes = tv.resourceId;
                        } //End block
                        else
                        {
                            header.breadCrumbShortTitle = tv.string;
                        } //End block
                    } //End block
                    header.iconRes = sa.getResourceId(
                            com.android.internal.R.styleable.PreferenceHeader_icon, 0);
                    header.fragment = sa.getString(
                            com.android.internal.R.styleable.PreferenceHeader_fragment);
                    sa.recycle();
                    if(curBundle == null)                    
                    {
                        curBundle = new Bundle();
                    } //End block
                    final int innerDepth = parser.getDepth();
                    while
((type=parser.next()) != XmlPullParser.END_DOCUMENT
                           && (type != XmlPullParser.END_TAG || parser.getDepth() > innerDepth))                    
                    {
                        if(type == XmlPullParser.END_TAG || type == XmlPullParser.TEXT)                        
                        {
                            continue;
                        } //End block
                        String innerNodeName = parser.getName();
                        if(innerNodeName.equals("extra"))                        
                        {
                            getResources().parseBundleExtra("extra", attrs, curBundle);
                            XmlUtils.skipCurrentTag(parser);
                        } //End block
                        else
                        if(innerNodeName.equals("intent"))                        
                        {
                            header.intent = Intent.parseIntent(getResources(), parser, attrs);
                        } //End block
                        else
                        {
                            XmlUtils.skipCurrentTag(parser);
                        } //End block
                    } //End block
                    if(curBundle.size() > 0)                    
                    {
                        header.fragmentArguments = curBundle;
                        curBundle = null;
                    } //End block
                    target.add(header);
                } //End block
                else
                {
                    XmlUtils.skipCurrentTag(parser);
                } //End block
            } //End block
        } //End block
        catch (XmlPullParserException e)
        {
            RuntimeException var9FC72194F14BB1372730BEDBAE80B19C_2009869838 = new RuntimeException("Error parsing headers", e);
            var9FC72194F14BB1372730BEDBAE80B19C_2009869838.addTaint(taint);
            throw var9FC72194F14BB1372730BEDBAE80B19C_2009869838;
        } //End block
        catch (IOException e)
        {
            RuntimeException var9FC72194F14BB1372730BEDBAE80B19C_1912493856 = new RuntimeException("Error parsing headers", e);
            var9FC72194F14BB1372730BEDBAE80B19C_1912493856.addTaint(taint);
            throw var9FC72194F14BB1372730BEDBAE80B19C_1912493856;
        } //End block
        finally 
        {
            if(parser != null)            
            parser.close();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.471 -0400", hash_original_method = "0C226BA6EB709C0B8BDD6989275021F7", hash_generated_method = "775BB6F1CC8D9134BE9D314ED041786D")
    public void setListFooter(View view) {
        addTaint(view.getTaint());
        mListFooter.removeAllViews();
        mListFooter.addView(view, new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.WRAP_CONTENT));
        // ---------- Original Method ----------
        //mListFooter.removeAllViews();
        //mListFooter.addView(view, new FrameLayout.LayoutParams(
                //FrameLayout.LayoutParams.MATCH_PARENT,
                //FrameLayout.LayoutParams.WRAP_CONTENT));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.474 -0400", hash_original_method = "5055AD43F70FAF224ADCBC793E0582D3", hash_generated_method = "0F83034986D090C449BE8ACCE151509A")
    @Override
    protected void onStop() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onStop();
        if(mPreferenceManager != null)        
        {
            mPreferenceManager.dispatchActivityStop();
        } //End block
        // ---------- Original Method ----------
        //super.onStop();
        //if (mPreferenceManager != null) {
            //mPreferenceManager.dispatchActivityStop();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.477 -0400", hash_original_method = "015EB586B516E4BA63E47DF2D2F941B5", hash_generated_method = "AE118E707C09982F50168A53C26BB9CF")
    @Override
    protected void onDestroy() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onDestroy();
        if(mPreferenceManager != null)        
        {
            mPreferenceManager.dispatchActivityDestroy();
        } //End block
        // ---------- Original Method ----------
        //super.onDestroy();
        //if (mPreferenceManager != null) {
            //mPreferenceManager.dispatchActivityDestroy();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.482 -0400", hash_original_method = "1A457C81CAD07F8216A55B906C01B0EE", hash_generated_method = "6A7EE5C03743044FB2FA617489FCC0DE")
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(outState.getTaint());
        super.onSaveInstanceState(outState);
        if(mHeaders.size() > 0)        
        {
            outState.putParcelableArrayList(HEADERS_TAG, mHeaders);
            if(mCurHeader != null)            
            {
                int index = mHeaders.indexOf(mCurHeader);
                if(index >= 0)                
                {
                    outState.putInt(CUR_HEADER_TAG, index);
                } //End block
            } //End block
        } //End block
        if(mPreferenceManager != null)        
        {
            final PreferenceScreen preferenceScreen = getPreferenceScreen();
            if(preferenceScreen != null)            
            {
                Bundle container = new Bundle();
                preferenceScreen.saveHierarchyState(container);
                outState.putBundle(PREFERENCES_TAG, container);
            } //End block
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.488 -0400", hash_original_method = "3A902C5AADE0A248676EF9D6166BBE53", hash_generated_method = "B4A71275DB41C1646E4A84B1E8FD82DE")
    @Override
    protected void onRestoreInstanceState(Bundle state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        if(mPreferenceManager != null)        
        {
            Bundle container = state.getBundle(PREFERENCES_TAG);
            if(container != null)            
            {
                final PreferenceScreen preferenceScreen = getPreferenceScreen();
                if(preferenceScreen != null)                
                {
                    preferenceScreen.restoreHierarchyState(container);
                    mSavedInstanceState = state;
                    return;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.492 -0400", hash_original_method = "BC5669EA98C9095AD4591AFCBD99CE20", hash_generated_method = "05ABF09D2E465058589333E2123351B1")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(data.getTaint());
        addTaint(resultCode);
        addTaint(requestCode);
        super.onActivityResult(requestCode, resultCode, data);
        if(mPreferenceManager != null)        
        {
            mPreferenceManager.dispatchActivityResult(requestCode, resultCode, data);
        } //End block
        // ---------- Original Method ----------
        //super.onActivityResult(requestCode, resultCode, data);
        //if (mPreferenceManager != null) {
            //mPreferenceManager.dispatchActivityResult(requestCode, resultCode, data);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.498 -0400", hash_original_method = "B413EAEA105506529AB09785B80740F7", hash_generated_method = "72B7D24B88F658BB93C8F3A07B2A5D17")
    @Override
    public void onContentChanged() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onContentChanged();
        if(mPreferenceManager != null)        
        {
            postBindPreferences();
        } //End block
        // ---------- Original Method ----------
        //super.onContentChanged();
        //if (mPreferenceManager != null) {
            //postBindPreferences();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.502 -0400", hash_original_method = "32CF46DB4065373D899344EB4B5785F0", hash_generated_method = "75FBE36B67C91894E710DA1334AA9643")
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(id);
        addTaint(position);
        addTaint(v.getTaint());
        addTaint(l.getTaint());
        super.onListItemClick(l, v, position, id);
        if(mAdapter != null)        
        {
            Object item = mAdapter.getItem(position);
            if(item instanceof Header)            
            onHeaderClick((Header) item, position);
        } //End block
        // ---------- Original Method ----------
        //super.onListItemClick(l, v, position, id);
        //if (mAdapter != null) {
            //Object item = mAdapter.getItem(position);
            //if (item instanceof Header) onHeaderClick((Header) item, position);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.507 -0400", hash_original_method = "41F78ADB739893E8265A1748D8E017F7", hash_generated_method = "B943C702B2C90C6B7847DADA7B287EE0")
    public void onHeaderClick(Header header, int position) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(position);
        addTaint(header.getTaint());
        if(header.fragment != null)        
        {
            if(mSinglePane)            
            {
                int titleRes = header.breadCrumbTitleRes;
                int shortTitleRes = header.breadCrumbShortTitleRes;
                if(titleRes == 0)                
                {
                    titleRes = header.titleRes;
                    shortTitleRes = 0;
                } //End block
                startWithFragment(header.fragment, header.fragmentArguments, null, 0,
                        titleRes, shortTitleRes);
            } //End block
            else
            {
                switchToHeader(header);
            } //End block
        } //End block
        else
        if(header.intent != null)        
        {
            startActivity(header.intent);
        } //End block
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.511 -0400", hash_original_method = "B5DA23DDC47E44587D99F550083B256B", hash_generated_method = "90EC8DE2E47BBC836FEED95C393FC42C")
    public Intent onBuildStartFragmentIntent(String fragmentName, Bundle args,
            int titleRes, int shortTitleRes) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(shortTitleRes);
        addTaint(titleRes);
        addTaint(args.getTaint());
        addTaint(fragmentName.getTaint());
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setClass(this, getClass());
        intent.putExtra(EXTRA_SHOW_FRAGMENT, fragmentName);
        intent.putExtra(EXTRA_SHOW_FRAGMENT_ARGUMENTS, args);
        intent.putExtra(EXTRA_SHOW_FRAGMENT_TITLE, titleRes);
        intent.putExtra(EXTRA_SHOW_FRAGMENT_SHORT_TITLE, shortTitleRes);
        intent.putExtra(EXTRA_NO_HEADERS, true);
Intent var095937E5B36214360A2644916BF0E8DF_650793812 =         intent;
        var095937E5B36214360A2644916BF0E8DF_650793812.addTaint(taint);
        return var095937E5B36214360A2644916BF0E8DF_650793812;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.515 -0400", hash_original_method = "7A5ABD7084FE456D2AC9E7363F23F617", hash_generated_method = "0036BC0AB937BEFADE730C357D77A802")
    public void startWithFragment(String fragmentName, Bundle args,
            Fragment resultTo, int resultRequestCode) {
        addTaint(resultRequestCode);
        addTaint(resultTo.getTaint());
        addTaint(args.getTaint());
        addTaint(fragmentName.getTaint());
        startWithFragment(fragmentName, args, resultTo, resultRequestCode, 0, 0);
        // ---------- Original Method ----------
        //startWithFragment(fragmentName, args, resultTo, resultRequestCode, 0, 0);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.520 -0400", hash_original_method = "A8702F14B58AAD20058746FC81F4589D", hash_generated_method = "2087FD1F7D29ED6671BD8B81568BEEED")
    public void startWithFragment(String fragmentName, Bundle args,
            Fragment resultTo, int resultRequestCode, int titleRes, int shortTitleRes) {
        addTaint(shortTitleRes);
        addTaint(titleRes);
        addTaint(resultRequestCode);
        addTaint(resultTo.getTaint());
        addTaint(args.getTaint());
        addTaint(fragmentName.getTaint());
        Intent intent = onBuildStartFragmentIntent(fragmentName, args, titleRes, shortTitleRes);
        if(resultTo == null)        
        {
            startActivity(intent);
        } //End block
        else
        {
            resultTo.startActivityForResult(intent, resultRequestCode);
        } //End block
        // ---------- Original Method ----------
        //Intent intent = onBuildStartFragmentIntent(fragmentName, args, titleRes, shortTitleRes);
        //if (resultTo == null) {
            //startActivity(intent);
        //} else {
            //resultTo.startActivityForResult(intent, resultRequestCode);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.527 -0400", hash_original_method = "4F3C5CDBD4880824AF39CB9E5E4A33FC", hash_generated_method = "64FD54591298EBACAE007166EDCB2744")
    public void showBreadCrumbs(CharSequence title, CharSequence shortTitle) {
        addTaint(shortTitle.getTaint());
        addTaint(title.getTaint());
        if(mFragmentBreadCrumbs == null)        
        {
            View crumbs = findViewById(android.R.id.title);
            try 
            {
                mFragmentBreadCrumbs = (FragmentBreadCrumbs)crumbs;
            } //End block
            catch (ClassCastException e)
            {
                return;
            } //End block
            if(mFragmentBreadCrumbs == null)            
            {
                if(title != null)                
                {
                    setTitle(title);
                } //End block
                return;
            } //End block
            mFragmentBreadCrumbs.setMaxVisible(2);
            mFragmentBreadCrumbs.setActivity(this);
        } //End block
        mFragmentBreadCrumbs.setTitle(title, shortTitle);
        mFragmentBreadCrumbs.setParentTitle(null, null, null);
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.532 -0400", hash_original_method = "1549DF3FA5C3B3F8F6931C4E058E1944", hash_generated_method = "D939DE64B78C32A50D36EA4E26D93CF1")
    public void setParentTitle(CharSequence title, CharSequence shortTitle,
            OnClickListener listener) {
        addTaint(listener.getTaint());
        addTaint(shortTitle.getTaint());
        addTaint(title.getTaint());
        if(mFragmentBreadCrumbs != null)        
        {
            mFragmentBreadCrumbs.setParentTitle(title, shortTitle, listener);
        } //End block
        // ---------- Original Method ----------
        //if (mFragmentBreadCrumbs != null) {
            //mFragmentBreadCrumbs.setParentTitle(title, shortTitle, listener);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.537 -0400", hash_original_method = "6CD55A84320A14788B0DD27C2F943CD9", hash_generated_method = "CACF44D26AC7B617CF3E20E8C1D94157")
     void setSelectedHeader(Header header) {
        mCurHeader = header;
        int index = mHeaders.indexOf(header);
        if(index >= 0)        
        {
            getListView().setItemChecked(index, true);
        } //End block
        else
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.544 -0400", hash_original_method = "DBABA4F3A7CA13D3BE4599BE843A33E0", hash_generated_method = "B29D58C5AA119ABCCF7A02E2247170CB")
     void showBreadCrumbs(Header header) {
        addTaint(header.getTaint());
        if(header != null)        
        {
            CharSequence title = header.getBreadCrumbTitle(getResources());
            if(title == null)            
            title = header.getTitle(getResources());
            if(title == null)            
            title = getTitle();
            showBreadCrumbs(title, header.getBreadCrumbShortTitle(getResources()));
        } //End block
        else
        {
            showBreadCrumbs(getTitle(), null);
        } //End block
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.550 -0400", hash_original_method = "7A46889D874DD705E59FA4FB1509394D", hash_generated_method = "AD8B3E2994D47F36692A20BABB2FE90B")
    private void switchToHeaderInner(String fragmentName, Bundle args, int direction) {
        addTaint(direction);
        addTaint(args.getTaint());
        addTaint(fragmentName.getTaint());
        getFragmentManager().popBackStack(BACK_STACK_PREFS,
                FragmentManager.POP_BACK_STACK_INCLUSIVE);
        Fragment f = Fragment.instantiate(this, fragmentName, args);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        transaction.replace(com.android.internal.R.id.prefs, f);
        transaction.commitAllowingStateLoss();
        // ---------- Original Method ----------
        //getFragmentManager().popBackStack(BACK_STACK_PREFS,
                //FragmentManager.POP_BACK_STACK_INCLUSIVE);
        //Fragment f = Fragment.instantiate(this, fragmentName, args);
        //FragmentTransaction transaction = getFragmentManager().beginTransaction();
        //transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        //transaction.replace(com.android.internal.R.id.prefs, f);
        //transaction.commitAllowingStateLoss();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.553 -0400", hash_original_method = "1F3D49C208A22CE80DD0C39318B7FB91", hash_generated_method = "D2591BAFFB703A5882B8EE0F32D40934")
    public void switchToHeader(String fragmentName, Bundle args) {
        addTaint(args.getTaint());
        addTaint(fragmentName.getTaint());
        setSelectedHeader(null);
        switchToHeaderInner(fragmentName, args, 0);
        // ---------- Original Method ----------
        //setSelectedHeader(null);
        //switchToHeaderInner(fragmentName, args, 0);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.555 -0400", hash_original_method = "439F40B8AE0DFA06D4CE3EB843023A82", hash_generated_method = "74A23E75163F0D345CCFD106C3007722")
    public void switchToHeader(Header header) {
        addTaint(header.getTaint());
        if(mCurHeader == header)        
        {
            getFragmentManager().popBackStack(BACK_STACK_PREFS,
                    FragmentManager.POP_BACK_STACK_INCLUSIVE);
        } //End block
        else
        {
            int direction = mHeaders.indexOf(header) - mHeaders.indexOf(mCurHeader);
            switchToHeaderInner(header.fragment, header.fragmentArguments, direction);
            setSelectedHeader(header);
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.560 -0400", hash_original_method = "A27B5089D7C34DCC8F697434FD74BDF2", hash_generated_method = "F932D33AA08EF1920645B4789B9C3C6A")
     Header findBestMatchingHeader(Header cur, ArrayList<Header> from) {
        addTaint(from.getTaint());
        addTaint(cur.getTaint());
        ArrayList<Header> matches = new ArrayList<Header>();
for(int j=0;j<from.size();j++)
        {
            Header oh = from.get(j);
            if(cur == oh || (cur.id != HEADER_ID_UNDEFINED && cur.id == oh.id))            
            {
                matches.clear();
                matches.add(oh);
                break;
            } //End block
            if(cur.fragment != null)            
            {
                if(cur.fragment.equals(oh.fragment))                
                {
                    matches.add(oh);
                } //End block
            } //End block
            else
            if(cur.intent != null)            
            {
                if(cur.intent.equals(oh.intent))                
                {
                    matches.add(oh);
                } //End block
            } //End block
            else
            if(cur.title != null)            
            {
                if(cur.title.equals(oh.title))                
                {
                    matches.add(oh);
                } //End block
            } //End block
        } //End block
        final int NM = matches.size();
        if(NM == 1)        
        {
Header varC1114F24C5567AB8F8AE424D598AC772_2077794815 =             matches.get(0);
            varC1114F24C5567AB8F8AE424D598AC772_2077794815.addTaint(taint);
            return varC1114F24C5567AB8F8AE424D598AC772_2077794815;
        } //End block
        else
        if(NM > 1)        
        {
for(int j=0;j<NM;j++)
            {
                Header oh = matches.get(j);
                if(cur.fragmentArguments != null &&
                        cur.fragmentArguments.equals(oh.fragmentArguments))                
                {
Header var275593AE7D86E48E1276E2A4723C29EA_730470507 =                     oh;
                    var275593AE7D86E48E1276E2A4723C29EA_730470507.addTaint(taint);
                    return var275593AE7D86E48E1276E2A4723C29EA_730470507;
                } //End block
                if(cur.extras != null && cur.extras.equals(oh.extras))                
                {
Header var275593AE7D86E48E1276E2A4723C29EA_779475632 =                     oh;
                    var275593AE7D86E48E1276E2A4723C29EA_779475632.addTaint(taint);
                    return var275593AE7D86E48E1276E2A4723C29EA_779475632;
                } //End block
                if(cur.title != null && cur.title.equals(oh.title))                
                {
Header var275593AE7D86E48E1276E2A4723C29EA_1825863797 =                     oh;
                    var275593AE7D86E48E1276E2A4723C29EA_1825863797.addTaint(taint);
                    return var275593AE7D86E48E1276E2A4723C29EA_1825863797;
                } //End block
            } //End block
        } //End block
Header var540C13E9E156B687226421B24F2DF178_928101578 =         null;
        var540C13E9E156B687226421B24F2DF178_928101578.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_928101578;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.566 -0400", hash_original_method = "20FDC2DC66402E55AE5BF59B2D025057", hash_generated_method = "C5FAFD8C993579BA448EA6EDA23BE907")
    public void startPreferenceFragment(Fragment fragment, boolean push) {
        addTaint(push);
        addTaint(fragment.getTaint());
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(com.android.internal.R.id.prefs, fragment);
        if(push)        
        {
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            transaction.addToBackStack(BACK_STACK_PREFS);
        } //End block
        else
        {
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        } //End block
        transaction.commitAllowingStateLoss();
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.571 -0400", hash_original_method = "E25F9CE570E0BFA743AE6FCAFFB6168D", hash_generated_method = "D2FF75B64855CE1AE0E059C367E33674")
    public void startPreferencePanel(String fragmentClass, Bundle args, int titleRes,
            CharSequence titleText, Fragment resultTo, int resultRequestCode) {
        addTaint(resultRequestCode);
        addTaint(resultTo.getTaint());
        addTaint(titleText.getTaint());
        addTaint(titleRes);
        addTaint(args.getTaint());
        addTaint(fragmentClass.getTaint());
        if(mSinglePane)        
        {
            startWithFragment(fragmentClass, args, resultTo, resultRequestCode, titleRes, 0);
        } //End block
        else
        {
            Fragment f = Fragment.instantiate(this, fragmentClass, args);
            if(resultTo != null)            
            {
                f.setTargetFragment(resultTo, resultRequestCode);
            } //End block
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(com.android.internal.R.id.prefs, f);
            if(titleRes != 0)            
            {
                transaction.setBreadCrumbTitle(titleRes);
            } //End block
            else
            if(titleText != null)            
            {
                transaction.setBreadCrumbTitle(titleText);
            } //End block
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            transaction.addToBackStack(BACK_STACK_PREFS);
            transaction.commitAllowingStateLoss();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.575 -0400", hash_original_method = "35CCCF58010C828A125388DBAAB260E2", hash_generated_method = "CCD71968ABB38D35E2FCFB0EA934F100")
    public void finishPreferencePanel(Fragment caller, int resultCode, Intent resultData) {
        addTaint(resultData.getTaint());
        addTaint(resultCode);
        addTaint(caller.getTaint());
        if(mSinglePane)        
        {
            setResult(resultCode, resultData);
            finish();
        } //End block
        else
        {
            onBackPressed();
            if(caller != null)            
            {
                if(caller.getTargetFragment() != null)                
                {
                    caller.getTargetFragment().onActivityResult(caller.getTargetRequestCode(),
                            resultCode, resultData);
                } //End block
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.579 -0400", hash_original_method = "88B12B83AF6C82165835FAA52B723B1A", hash_generated_method = "E3C2D78BAF1D9327C709A6B99658E0B3")
    @Override
    public boolean onPreferenceStartFragment(PreferenceFragment caller, Preference pref) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(pref.getTaint());
        addTaint(caller.getTaint());
        startPreferencePanel(pref.getFragment(), pref.getExtras(), pref.getTitleRes(),
                pref.getTitle(), null, 0);
        boolean varB326B5062B2F0E69046810717534CB09_1123338335 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1732261604 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1732261604;
        // ---------- Original Method ----------
        //startPreferencePanel(pref.getFragment(), pref.getExtras(), pref.getTitleRes(),
                //pref.getTitle(), null, 0);
        //return true;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.581 -0400", hash_original_method = "6C1825C42631AE6FCE57D0240C5D762E", hash_generated_method = "62DE4FD95EC2A6D210170DB16FB47120")
    private void postBindPreferences() {
        if(mHandler.hasMessages(MSG_BIND_PREFERENCES))        
        return;
        mHandler.obtainMessage(MSG_BIND_PREFERENCES).sendToTarget();
        // ---------- Original Method ----------
        //if (mHandler.hasMessages(MSG_BIND_PREFERENCES)) return;
        //mHandler.obtainMessage(MSG_BIND_PREFERENCES).sendToTarget();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.584 -0400", hash_original_method = "548F27FE8CA6D6649BD8B5A7939C474E", hash_generated_method = "04275918F224E187ABF5A8521868CD6D")
    private void bindPreferences() {
        final PreferenceScreen preferenceScreen = getPreferenceScreen();
        if(preferenceScreen != null)        
        {
            preferenceScreen.bind(getListView());
            if(mSavedInstanceState != null)            
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.588 -0400", hash_original_method = "002FC5CEE5BE5B5D1FE36CEDBC1DEB65", hash_generated_method = "FF0A1125A8B8FA5E823F7AEA5C520666")
    @Deprecated
    public PreferenceManager getPreferenceManager() {
PreferenceManager var00374A2A6A541F0EA9C609E6C6447EED_743531044 =         mPreferenceManager;
        var00374A2A6A541F0EA9C609E6C6447EED_743531044.addTaint(taint);
        return var00374A2A6A541F0EA9C609E6C6447EED_743531044;
        // ---------- Original Method ----------
        //return mPreferenceManager;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.591 -0400", hash_original_method = "B2669BE6B91E4B8BF7765D817C0F2C8A", hash_generated_method = "3EB839ED8B0EE645576AC72D20736F78")
    private void requirePreferenceManager() {
        if(mPreferenceManager == null)        
        {
            if(mAdapter == null)            
            {
                RuntimeException var3378A9C87F81772D2E810C2DBC2CC508_865959223 = new RuntimeException("This should be called after super.onCreate.");
                var3378A9C87F81772D2E810C2DBC2CC508_865959223.addTaint(taint);
                throw var3378A9C87F81772D2E810C2DBC2CC508_865959223;
            } //End block
            RuntimeException var2658115932D9540AE1555A80B4B6B7E5_1134923318 = new RuntimeException(
                    "Modern two-pane PreferenceActivity requires use of a PreferenceFragment");
            var2658115932D9540AE1555A80B4B6B7E5_1134923318.addTaint(taint);
            throw var2658115932D9540AE1555A80B4B6B7E5_1134923318;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.596 -0400", hash_original_method = "20BEF3079E316F6730A81E488DFA70F2", hash_generated_method = "6B5C2DB60A615141EC233D88147A3BC1")
    @Deprecated
    public void setPreferenceScreen(PreferenceScreen preferenceScreen) {
        addTaint(preferenceScreen.getTaint());
        requirePreferenceManager();
        if(mPreferenceManager.setPreferences(preferenceScreen) && preferenceScreen != null)        
        {
            postBindPreferences();
            CharSequence title = getPreferenceScreen().getTitle();
            if(title != null)            
            {
                setTitle(title);
            } //End block
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.601 -0400", hash_original_method = "7CC03E7D3EBAF4E1E382E9E7A55EF0AE", hash_generated_method = "9997E88388F8F46F4A9BDA8219C5A432")
    @Deprecated
    public PreferenceScreen getPreferenceScreen() {
        if(mPreferenceManager != null)        
        {
PreferenceScreen varDAFD38741BC1123E8F4608DDE091E020_710309616 =             mPreferenceManager.getPreferenceScreen();
            varDAFD38741BC1123E8F4608DDE091E020_710309616.addTaint(taint);
            return varDAFD38741BC1123E8F4608DDE091E020_710309616;
        } //End block
PreferenceScreen var540C13E9E156B687226421B24F2DF178_1161814857 =         null;
        var540C13E9E156B687226421B24F2DF178_1161814857.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1161814857;
        // ---------- Original Method ----------
        //if (mPreferenceManager != null) {
            //return mPreferenceManager.getPreferenceScreen();
        //}
        //return null;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.605 -0400", hash_original_method = "5674CE8C214451535BFAB18211614C8C", hash_generated_method = "994365E398A017D99D07B6A5AD6A37DB")
    @Deprecated
    public void addPreferencesFromIntent(Intent intent) {
        addTaint(intent.getTaint());
        requirePreferenceManager();
        setPreferenceScreen(mPreferenceManager.inflateFromIntent(intent, getPreferenceScreen()));
        // ---------- Original Method ----------
        //requirePreferenceManager();
        //setPreferenceScreen(mPreferenceManager.inflateFromIntent(intent, getPreferenceScreen()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.607 -0400", hash_original_method = "1D27A71B873F6C05FF2DA5D8C133ED30", hash_generated_method = "562ADC3112E6710E167FCD36403697FB")
    @Deprecated
    public void addPreferencesFromResource(int preferencesResId) {
        addTaint(preferencesResId);
        requirePreferenceManager();
        setPreferenceScreen(mPreferenceManager.inflateFromResource(this, preferencesResId,
                getPreferenceScreen()));
        // ---------- Original Method ----------
        //requirePreferenceManager();
        //setPreferenceScreen(mPreferenceManager.inflateFromResource(this, preferencesResId,
                //getPreferenceScreen()));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.609 -0400", hash_original_method = "ADC2C8250ACD9F9573CD9A45AF1661C3", hash_generated_method = "E70FDB545CBF331C09C3569B5B2992AE")
    @Deprecated
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(preference.getTaint());
        addTaint(preferenceScreen.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_1647549200 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_738918378 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_738918378;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.614 -0400", hash_original_method = "0C794FFD7CBFBB35093DF6CE24875508", hash_generated_method = "9C50FA2520C29E17671B4C92BF1F033C")
    @Deprecated
    public Preference findPreference(CharSequence key) {
        addTaint(key.getTaint());
        if(mPreferenceManager == null)        
        {
Preference var540C13E9E156B687226421B24F2DF178_30710135 =             null;
            var540C13E9E156B687226421B24F2DF178_30710135.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_30710135;
        } //End block
Preference var3F9904390C47A44ACE8B6D395680E8CD_1071960949 =         mPreferenceManager.findPreference(key);
        var3F9904390C47A44ACE8B6D395680E8CD_1071960949.addTaint(taint);
        return var3F9904390C47A44ACE8B6D395680E8CD_1071960949;
        // ---------- Original Method ----------
        //if (mPreferenceManager == null) {
            //return null;
        //}
        //return mPreferenceManager.findPreference(key);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.617 -0400", hash_original_method = "5A6127558FF9D60C52821F59A1A351C3", hash_generated_method = "D57D01EBB933E9B22B810E43247A5847")
    @Override
    protected void onNewIntent(Intent intent) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(intent.getTaint());
        if(mPreferenceManager != null)        
        {
            mPreferenceManager.dispatchNewIntent(intent);
        } //End block
        // ---------- Original Method ----------
        //if (mPreferenceManager != null) {
            //mPreferenceManager.dispatchNewIntent(intent);
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.623 -0400", hash_original_method = "BC54EB6D436D19F86F3C9657BD0BE1AA", hash_generated_method = "6F80C6ADE0DDC523ABF7A3B96571F952")
    protected boolean hasNextButton() {
        boolean var1E13A8D62F65FA8B16FFABE15551D8B3_1714306332 = (mNextButton != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_773133992 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_773133992;
        // ---------- Original Method ----------
        //return mNextButton != null;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.627 -0400", hash_original_method = "CC6F0F14612F322772A46478BA75E81F", hash_generated_method = "550F1C61017D49E1E417EE2B012C6BAE")
    protected Button getNextButton() {
Button var0A300EA22629DC89E0DD4FA357122FBD_1421989561 =         mNextButton;
        var0A300EA22629DC89E0DD4FA357122FBD_1421989561.addTaint(taint);
        return var0A300EA22629DC89E0DD4FA357122FBD_1421989561;
        // ---------- Original Method ----------
        //return mNextButton;
    }

    
    private static class HeaderAdapter extends ArrayAdapter<Header> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.629 -0400", hash_original_field = "D03597FDEDE23F3823480E0520822BB2", hash_generated_field = "CBB0EE0A851756643DA52E1D33B6B161")

        private LayoutInflater mInflater;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.632 -0400", hash_original_method = "F02F4C5BC3B955ED93786AEEC10379FE", hash_generated_method = "A60B0B04E9E424ECAFBF90FFB9A5E0F7")
        public  HeaderAdapter(Context context, List<Header> objects) {
            super(context, 0, objects);
            addTaint(objects.getTaint());
            mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // ---------- Original Method ----------
            //mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        
        @DSModeled(DSC.SAFE)
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
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.642 -0400", hash_original_field = "BAEC6461B0D69DDE1B861AEFBE375D8A", hash_generated_field = "7D496A7EF4277B81CF926C9FC9D04248")

            ImageView icon;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.643 -0400", hash_original_field = "D5D3DB1765287EEF77D7927CC956F50A", hash_generated_field = "D2FBB4059A3EADAB444F225698E4F56E")

            TextView title;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.644 -0400", hash_original_field = "A80DA1282F2C775BBC5F2C92C836968B", hash_generated_field = "BA7542FFBE4C8102C12065D859063619")

            TextView summary;
            
            @DSModeled(DSC.BAN)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.646 -0400", hash_original_method = "7AAB7B01E6419825274A30D2382564EA", hash_generated_method = "7AAB7B01E6419825274A30D2382564EA")
            public HeaderViewHolder ()
            {
                //Synthesized constructor
            }


        }


        
    }


    
    public static final class Header implements Parcelable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.651 -0400", hash_original_field = "CD9D7F08098BD235A18AE68FCAFCDC6A", hash_generated_field = "737A7D6903ECE33BE0237DB5C22496D2")

        public long id = HEADER_ID_UNDEFINED;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.652 -0400", hash_original_field = "608C178BEAA10D047DA1A404A17FEEF5", hash_generated_field = "3FD6C8139DEDC39179812C2724BF57B9")

        public int titleRes;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.653 -0400", hash_original_field = "D5D3DB1765287EEF77D7927CC956F50A", hash_generated_field = "285EF5A6A116FF608EE0587EA9C0F06D")

        public CharSequence title;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.654 -0400", hash_original_field = "05DF20411D7FE5FD44C56C61ADE561A9", hash_generated_field = "CF9D7763F41618969B1EF555AA62D675")

        public int summaryRes;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.655 -0400", hash_original_field = "A80DA1282F2C775BBC5F2C92C836968B", hash_generated_field = "649E9B273BD3EE954608217A46D60F9B")

        public CharSequence summary;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.656 -0400", hash_original_field = "EA055285E63FE8F3AEBF3FF66EAD77EC", hash_generated_field = "2CD689A4778432DF6FA02D3B2B9056EA")

        public int breadCrumbTitleRes;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.657 -0400", hash_original_field = "EC414BEC23FAE15429CFD80EB6C67E2E", hash_generated_field = "73EEB773801D9077B302E48B9DC2F190")

        public CharSequence breadCrumbTitle;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.659 -0400", hash_original_field = "E547092BCAACD041884B348DB68C9AFC", hash_generated_field = "61F809170E6E2C53D80864D07EEB140C")

        public int breadCrumbShortTitleRes;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.660 -0400", hash_original_field = "BC12220BB3538919F835A9A75EA14EA8", hash_generated_field = "12A2018B53E7263915979427C28D6095")

        public CharSequence breadCrumbShortTitle;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.661 -0400", hash_original_field = "1AFA68AAD1FD9765C18E4975F512B2FD", hash_generated_field = "800898B731FFFE010B18EB819F288168")

        public int iconRes;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.662 -0400", hash_original_field = "02E918FC72837D7C2689BE88684DCEB1", hash_generated_field = "3FCA1C3F48B0A85017F597A00E283B60")

        public String fragment;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.664 -0400", hash_original_field = "42BE488D27E9D9A55607EBD0D4EE93C5", hash_generated_field = "B8BBDD0C2C5BEF49B225AB4995204C33")

        public Bundle fragmentArguments;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.665 -0400", hash_original_field = "FA48C7D544739BA0E46430E4BA366662", hash_generated_field = "5DEDAC72AD89B3864945324786195E0B")

        public Intent intent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.666 -0400", hash_original_field = "27353006CFD751D26221E04A7928034D", hash_generated_field = "360651D25CBD3D75EA270BBFA49C37D4")

        public Bundle extras;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.669 -0400", hash_original_method = "CC8692EE42ED9AE9CFD9E664B2A1E936", hash_generated_method = "D78360B1F9ED0AA24422BF34D2B11223")
        public  Header() {
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.672 -0400", hash_original_method = "3E4088512988FAACC868C0BAC5E638A1", hash_generated_method = "3A1D4F49D71351DF78F288CC07EBC7A2")
          Header(Parcel in) {
            addTaint(in.getTaint());
            readFromParcel(in);
            // ---------- Original Method ----------
            //readFromParcel(in);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.677 -0400", hash_original_method = "334D1E94CC98A584AC982CEC8D5C3813", hash_generated_method = "2C08691B928D15B9A2EBA7B64EA85531")
        public CharSequence getTitle(Resources res) {
            addTaint(res.getTaint());
            if(titleRes != 0)            
            {
CharSequence varAF4156E8196C05DF0D9633D2FC0CEBB0_583567282 =                 res.getText(titleRes);
                varAF4156E8196C05DF0D9633D2FC0CEBB0_583567282.addTaint(taint);
                return varAF4156E8196C05DF0D9633D2FC0CEBB0_583567282;
            } //End block
CharSequence varCD126D34DD1576383395AEE5945E9C28_2085786960 =             title;
            varCD126D34DD1576383395AEE5945E9C28_2085786960.addTaint(taint);
            return varCD126D34DD1576383395AEE5945E9C28_2085786960;
            // ---------- Original Method ----------
            //if (titleRes != 0) {
                //return res.getText(titleRes);
            //}
            //return title;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.681 -0400", hash_original_method = "817FA0FA7A0D92830E14FE64024CE8CC", hash_generated_method = "1A372BA310030B219EED35A4F779DE75")
        public CharSequence getSummary(Resources res) {
            addTaint(res.getTaint());
            if(summaryRes != 0)            
            {
CharSequence varA1CEAA901D90BE290F2A48333A870BB6_101061769 =                 res.getText(summaryRes);
                varA1CEAA901D90BE290F2A48333A870BB6_101061769.addTaint(taint);
                return varA1CEAA901D90BE290F2A48333A870BB6_101061769;
            } //End block
CharSequence var94CF84F5B46450576F294A9E2D95E50C_904404921 =             summary;
            var94CF84F5B46450576F294A9E2D95E50C_904404921.addTaint(taint);
            return var94CF84F5B46450576F294A9E2D95E50C_904404921;
            // ---------- Original Method ----------
            //if (summaryRes != 0) {
                //return res.getText(summaryRes);
            //}
            //return summary;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.685 -0400", hash_original_method = "AB517FA9C1DC5B1E62910A1ABDCECDD0", hash_generated_method = "44C265B30FD83B746A0151E8B44465E1")
        public CharSequence getBreadCrumbTitle(Resources res) {
            addTaint(res.getTaint());
            if(breadCrumbTitleRes != 0)            
            {
CharSequence varBF5D7092F0F6173021E909C0837E1890_1917179024 =                 res.getText(breadCrumbTitleRes);
                varBF5D7092F0F6173021E909C0837E1890_1917179024.addTaint(taint);
                return varBF5D7092F0F6173021E909C0837E1890_1917179024;
            } //End block
CharSequence varD5156347D91E42719275E656EEC8D728_1007437793 =             breadCrumbTitle;
            varD5156347D91E42719275E656EEC8D728_1007437793.addTaint(taint);
            return varD5156347D91E42719275E656EEC8D728_1007437793;
            // ---------- Original Method ----------
            //if (breadCrumbTitleRes != 0) {
                //return res.getText(breadCrumbTitleRes);
            //}
            //return breadCrumbTitle;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.693 -0400", hash_original_method = "F11776C7591643DD9CB4C4ECCD867732", hash_generated_method = "EF58D1D058B2750230A1CCF614E40AB6")
        public CharSequence getBreadCrumbShortTitle(Resources res) {
            addTaint(res.getTaint());
            if(breadCrumbShortTitleRes != 0)            
            {
CharSequence varDDF24F0AD0B4A79B38B23FACD38ABED3_681705890 =                 res.getText(breadCrumbShortTitleRes);
                varDDF24F0AD0B4A79B38B23FACD38ABED3_681705890.addTaint(taint);
                return varDDF24F0AD0B4A79B38B23FACD38ABED3_681705890;
            } //End block
CharSequence varFFEE091C203152B4B8D9368992F950CE_1043247137 =             breadCrumbShortTitle;
            varFFEE091C203152B4B8D9368992F950CE_1043247137.addTaint(taint);
            return varFFEE091C203152B4B8D9368992F950CE_1043247137;
            // ---------- Original Method ----------
            //if (breadCrumbShortTitleRes != 0) {
                //return res.getText(breadCrumbShortTitleRes);
            //}
            //return breadCrumbShortTitle;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.700 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D47BC5CB8D43EFE296BA482ABA1518B0")
        @Override
        public int describeContents() {
            int varCFCD208495D565EF66E7DFF9F98764DA_1603494934 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_98951994 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_98951994;
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.705 -0400", hash_original_method = "BB0DBC9520A7E98C1F6BA8AD4772118F", hash_generated_method = "6C5169A1B271D34F0294933C99A03E6B")
        @Override
        public void writeToParcel(Parcel dest, int flags) {
            addTaint(flags);
            addTaint(dest.getTaint());
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
            if(intent != null)            
            {
                dest.writeInt(1);
                intent.writeToParcel(dest, flags);
            } //End block
            else
            {
                dest.writeInt(0);
            } //End block
            dest.writeBundle(extras);
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

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.716 -0400", hash_original_method = "29282A1B26F647059DDF5369C2CB137B", hash_generated_method = "5EBD6735AC3A9D662A04B831C6816001")
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
            if(in.readInt() != 0)            
            {
                intent = Intent.CREATOR.createFromParcel(in);
            } //End block
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.717 -0400", hash_original_field = "80358CCA6C151B1C75C8F6D01427BC96", hash_generated_field = "0285FC5896D2C8A81AC7F6CCCD215EAF")

        public static final Creator<Header> CREATOR = new Creator<Header>() {
            @DSModeled(DSC.SAFE)
            public Header createFromParcel(Parcel source) {
                return new Header(source);
            }
            public Header[] newArray(int size) {
                return new Header[size];
            }
        };
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.719 -0400", hash_original_field = "5224C355FB3151226DCBB252E71D8C45", hash_generated_field = "2E084579604068AECB302A705EB28607")

    private static final String HEADERS_TAG = ":android:headers";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.720 -0400", hash_original_field = "24813F27F5BB25614DE5963D935AEC65", hash_generated_field = "475A448573DAB6E82A443372F6B23A12")

    private static final String CUR_HEADER_TAG = ":android:cur_header";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.721 -0400", hash_original_field = "6B4950CB402849CFD7FF819E761EC566", hash_generated_field = "95AADD698D0027248B58F382F8E7BC71")

    private static final String PREFERENCES_TAG = ":android:preferences";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.723 -0400", hash_original_field = "8E1D2567A8F5FC0D4CCD7E7D4E5D61DA", hash_generated_field = "46D5D655E675E9CC41AA95971DA7C983")

    public static final String EXTRA_SHOW_FRAGMENT = ":android:show_fragment";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.724 -0400", hash_original_field = "24CAAB8CA0E6C99A6AFA2C78AA37D067", hash_generated_field = "238348398E3BDE30D489970315DCB2F7")

    public static final String EXTRA_SHOW_FRAGMENT_ARGUMENTS = ":android:show_fragment_args";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.726 -0400", hash_original_field = "6C8D245A63EEB3438D48DA1A14CC14B3", hash_generated_field = "9EDA9A80F485D711E436660545646846")

    public static final String EXTRA_SHOW_FRAGMENT_TITLE = ":android:show_fragment_title";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.727 -0400", hash_original_field = "B6BA4D79DB131AD112A933A84B09B7F5", hash_generated_field = "72E65F21D21C144A50537392CA5C7A04")

    public static final String EXTRA_SHOW_FRAGMENT_SHORT_TITLE
            = ":android:show_fragment_short_title";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.728 -0400", hash_original_field = "A307AC2DB4EF1E817C27C8522EB96281", hash_generated_field = "D38B44E415912850DD5978247D2C7A68")

    public static final String EXTRA_NO_HEADERS = ":android:no_headers";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.729 -0400", hash_original_field = "86E59DEBCAC94735618BAF4F9F1733CE", hash_generated_field = "A284837FF977B323F510310B8A0B07BC")

    private static final String BACK_STACK_PREFS = ":android:prefs";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.730 -0400", hash_original_field = "C933A32E9C9683A1B47540929477CEAC", hash_generated_field = "098F0E24A0AA8F1878CCD553C99A0536")

    private static final String EXTRA_PREFS_SHOW_BUTTON_BAR = "extra_prefs_show_button_bar";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.731 -0400", hash_original_field = "5D4A5C2C86B5EB9C1BF49D09CE1DB767", hash_generated_field = "B496A57DC5DA5028C2D08B42DAE92474")

    private static final String EXTRA_PREFS_SHOW_SKIP = "extra_prefs_show_skip";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.732 -0400", hash_original_field = "C1643E502B9F83474DDF3C1BA3B34047", hash_generated_field = "66E2D8A3053DB56E24A1B4E8D7484ED3")

    private static final String EXTRA_PREFS_SET_NEXT_TEXT = "extra_prefs_set_next_text";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.733 -0400", hash_original_field = "4CE17D3BE7186684C204C2BE77C91C4A", hash_generated_field = "9CF302D5D1C7AB16535FE30602ABF893")

    private static final String EXTRA_PREFS_SET_BACK_TEXT = "extra_prefs_set_back_text";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.734 -0400", hash_original_field = "0466831DAC50AD91F00BE2472F26C26A", hash_generated_field = "0136D59B093194DD543B8062A7975D9E")

    private static final int FIRST_REQUEST_CODE = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.735 -0400", hash_original_field = "D7A6754ED93721763C237AE926734ECE", hash_generated_field = "7A68CD10BF8C3B855976E8E8F733E671")

    private static final int MSG_BIND_PREFERENCES = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.735 -0400", hash_original_field = "A311ADD455E28882DFBE1013B45DE390", hash_generated_field = "CF41B970CC3B897D25CF787D434428D5")

    private static final int MSG_BUILD_HEADERS = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.736 -0400", hash_original_field = "66B9C0557A7ABDF9846F2E4A3158DC16", hash_generated_field = "D3EEEA8888F40DB4597966262702A0F4")

    public static final long HEADER_ID_UNDEFINED = -1;
}

