package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

public class TabActivity extends ActivityGroup {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.366 -0400", hash_original_field = "BEFE305CB509C7B768A055FC2844AD3E", hash_generated_field = "FDB3EE2BFD396DB59CF2AF609368DA5F")

    private TabHost mTabHost;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.366 -0400", hash_original_field = "2673BE403D04D82FDBA3E962F08C2A55", hash_generated_field = "15376AEA94D706E4B7600BED235ACE08")

    private String mDefaultTab = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.367 -0400", hash_original_field = "2B163D1DF886926CA978FE8CD880A2BD", hash_generated_field = "DDA136115CCD60C8AA5A05ECA2765B5B")

    private int mDefaultTabIndex = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.384 -0400", hash_original_method = "7656B1DA8F939C27E9A82F1B44C0847D", hash_generated_method = "31D889F3885F23AF577087DF7DEEA8FD")
    public  TabActivity() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.385 -0400", hash_original_method = "DD818EDD04198A64589FCF3CE4F0396C", hash_generated_method = "6EF6D298E53C3A38F863841FD7A54A7A")
    public void setDefaultTab(String tag) {
        mDefaultTab = tag;
        mDefaultTabIndex = -1;
        // ---------- Original Method ----------
        //mDefaultTab = tag;
        //mDefaultTabIndex = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.412 -0400", hash_original_method = "4CDCBCFE71ABD3C5FA6E0629F75B0C62", hash_generated_method = "826E6F3E2CF34349C386CCE272BF95A1")
    public void setDefaultTab(int index) {
        mDefaultTab = null;
        mDefaultTabIndex = index;
        // ---------- Original Method ----------
        //mDefaultTab = null;
        //mDefaultTabIndex = index;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.420 -0400", hash_original_method = "43FC78560A264DC47797D8670D9C3246", hash_generated_method = "72512D94FB204DD9D6CB3F0B826905DA")
    @Override
    protected void onRestoreInstanceState(Bundle state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onRestoreInstanceState(state);
        ensureTabHost();
        String cur;
        cur = state.getString("currentTab");
        {
            mTabHost.setCurrentTabByTag(cur);
        } //End block
        {
            boolean varB759B15E40530C9C0260D509474713F2_512916621 = (mTabHost.getCurrentTab() < 0);
            {
                {
                    mTabHost.setCurrentTabByTag(mDefaultTab);
                } //End block
                {
                    mTabHost.setCurrentTab(mDefaultTabIndex);
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(state.getTaint());
        // ---------- Original Method ----------
        //super.onRestoreInstanceState(state);
        //ensureTabHost();
        //String cur = state.getString("currentTab");
        //if (cur != null) {
            //mTabHost.setCurrentTabByTag(cur);
        //}
        //if (mTabHost.getCurrentTab() < 0) {
            //if (mDefaultTab != null) {
                //mTabHost.setCurrentTabByTag(mDefaultTab);
            //} else if (mDefaultTabIndex >= 0) {
                //mTabHost.setCurrentTab(mDefaultTabIndex);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.442 -0400", hash_original_method = "95D0011EE002D17BAA86137B82FD9E88", hash_generated_method = "3FD117073DFA040022D89D97DC7A1597")
    @Override
    protected void onPostCreate(Bundle icicle) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onPostCreate(icicle);
        ensureTabHost();
        {
            boolean var3C5C9E0FB5B4113877BCFA92B254E3EF_250614761 = (mTabHost.getCurrentTab() == -1);
            {
                mTabHost.setCurrentTab(0);
            } //End block
        } //End collapsed parenthetic
        addTaint(icicle.getTaint());
        // ---------- Original Method ----------
        //super.onPostCreate(icicle);
        //ensureTabHost();
        //if (mTabHost.getCurrentTab() == -1) {
            //mTabHost.setCurrentTab(0);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.444 -0400", hash_original_method = "7A1E5FF4358126AE2CED70B78C4AF1EE", hash_generated_method = "9C90F11D027A67AE9EAE61C01E7A333E")
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onSaveInstanceState(outState);
        String currentTabTag;
        currentTabTag = mTabHost.getCurrentTabTag();
        {
            outState.putString("currentTab", currentTabTag);
        } //End block
        addTaint(outState.getTaint());
        // ---------- Original Method ----------
        //super.onSaveInstanceState(outState);
        //String currentTabTag = mTabHost.getCurrentTabTag();
        //if (currentTabTag != null) {
            //outState.putString("currentTab", currentTabTag);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.464 -0400", hash_original_method = "582B2DDC8E1047355D2EEA6881BB52B9", hash_generated_method = "6372FE2BDAB68FEEB21FA6735B740DDC")
    @Override
    public void onContentChanged() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onContentChanged();
        mTabHost = (TabHost) findViewById(com.android.internal.R.id.tabhost);
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                    "Your content must have a TabHost whose id attribute is " +
                    "'android.R.id.tabhost'");
        } //End block
        mTabHost.setup(getLocalActivityManager());
        // ---------- Original Method ----------
        //super.onContentChanged();
        //mTabHost = (TabHost) findViewById(com.android.internal.R.id.tabhost);
        //if (mTabHost == null) {
            //throw new RuntimeException(
                    //"Your content must have a TabHost whose id attribute is " +
                    //"'android.R.id.tabhost'");
        //}
        //mTabHost.setup(getLocalActivityManager());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.468 -0400", hash_original_method = "165BC05C59C361B649DC3EA7F3563399", hash_generated_method = "3B7702C22FE7A89AA5949DCF5F7EE310")
    private void ensureTabHost() {
        {
            this.setContentView(com.android.internal.R.layout.tab_content);
        } //End block
        // ---------- Original Method ----------
        //if (mTabHost == null) {
            //this.setContentView(com.android.internal.R.layout.tab_content);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.491 -0400", hash_original_method = "90307FAF1FA715C3E880FDADA1597ED5", hash_generated_method = "81F2158F6CE26CFFAEBD94D812133380")
    @Override
    protected void onChildTitleChanged(Activity childActivity, CharSequence title) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var91C02A08111643BA5B7BBC33C7AF13E4_1207755999 = (getLocalActivityManager().getCurrentActivity() == childActivity);
            {
                View tabView;
                tabView = mTabHost.getCurrentTabView();
                {
                    ((TextView) tabView).setText(title);
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(childActivity.getTaint());
        addTaint(title.getTaint());
        // ---------- Original Method ----------
        //if (getLocalActivityManager().getCurrentActivity() == childActivity) {
            //View tabView = mTabHost.getCurrentTabView();
            //if (tabView != null && tabView instanceof TextView) {
                //((TextView) tabView).setText(title);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.513 -0400", hash_original_method = "6AC0503CD9EB9D407A1E8CBC0E0E9255", hash_generated_method = "38884C37B1B6140149D2C184A6E3589D")
    public TabHost getTabHost() {
        TabHost varB4EAC82CA7396A68D541C85D26508E83_1663267307 = null; //Variable for return #1
        ensureTabHost();
        varB4EAC82CA7396A68D541C85D26508E83_1663267307 = mTabHost;
        varB4EAC82CA7396A68D541C85D26508E83_1663267307.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1663267307;
        // ---------- Original Method ----------
        //ensureTabHost();
        //return mTabHost;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.519 -0400", hash_original_method = "8A117298A466C130739D5E7C43BBFBE6", hash_generated_method = "BFA2E03F2FBB904118DF1BABCAFB40FA")
    public TabWidget getTabWidget() {
        TabWidget varB4EAC82CA7396A68D541C85D26508E83_1040224054 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1040224054 = mTabHost.getTabWidget();
        varB4EAC82CA7396A68D541C85D26508E83_1040224054.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1040224054;
        // ---------- Original Method ----------
        //return mTabHost.getTabWidget();
    }

    
}

