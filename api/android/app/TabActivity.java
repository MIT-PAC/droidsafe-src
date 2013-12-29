package android.app;

// Droidsafe Imports
import droidsafe.annotations.*;
import droidsafe.helpers.*;

import droidsafe.runtime.*;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

public class TabActivity extends ActivityGroup {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:22.103 -0500", hash_original_field = "2BC2C7D2CF316CF0BDFB85C66C22A1DF", hash_generated_field = "FDB3EE2BFD396DB59CF2AF609368DA5F")

    private TabHost mTabHost;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:22.104 -0500", hash_original_field = "9CA56DF4FD795D519A6C63F797997BFB", hash_generated_field = "15376AEA94D706E4B7600BED235ACE08")

    private String mDefaultTab = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:22.105 -0500", hash_original_field = "FD12D0F60A87214A5A20117D367780FB", hash_generated_field = "DDA136115CCD60C8AA5A05ECA2765B5B")

    private int mDefaultTabIndex = -1;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:22.106 -0500", hash_original_method = "7656B1DA8F939C27E9A82F1B44C0847D", hash_generated_method = "58E71EE30CE038A7E54BAFF2C3030AF5")
    public TabActivity() {
    }

    /**
     * Sets the default tab that is the first tab highlighted.
     * 
     * @param tag the name of the default tab
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:22.107 -0500", hash_original_method = "DD818EDD04198A64589FCF3CE4F0396C", hash_generated_method = "64B01EFDB22004A059A6ADB44AFD1A85")
    public void setDefaultTab(String tag) {
        mDefaultTab = tag;
        mDefaultTabIndex = -1;
    }

    /**
     * Sets the default tab that is the first tab highlighted.
     * 
     * @param index the index of the default tab
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:22.108 -0500", hash_original_method = "4CDCBCFE71ABD3C5FA6E0629F75B0C62", hash_generated_method = "BCC0146EEE3EED206BDDBA63540D5877")
    public void setDefaultTab(int index) {
        mDefaultTab = null;
        mDefaultTabIndex = index;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:22.108 -0500", hash_original_method = "43FC78560A264DC47797D8670D9C3246", hash_generated_method = "6AC89BFAC49F7EC91737BA5CBAE8C9FA")
    @Override
protected void onRestoreInstanceState(Bundle state) {
        super.onRestoreInstanceState(state);
        ensureTabHost();
        String cur = state.getString("currentTab");
        if (cur != null) {
            mTabHost.setCurrentTabByTag(cur);
        }
        if (mTabHost.getCurrentTab() < 0) {
            if (mDefaultTab != null) {
                mTabHost.setCurrentTabByTag(mDefaultTab);
            } else if (mDefaultTabIndex >= 0) {
                mTabHost.setCurrentTab(mDefaultTabIndex);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:22.109 -0500", hash_original_method = "95D0011EE002D17BAA86137B82FD9E88", hash_generated_method = "932DC7D210369E2E72283F0F299B1AE6")
    @Override
protected void onPostCreate(Bundle icicle) {        
        super.onPostCreate(icicle);

        ensureTabHost();

        if (mTabHost.getCurrentTab() == -1) {
            mTabHost.setCurrentTab(0);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:22.110 -0500", hash_original_method = "7A1E5FF4358126AE2CED70B78C4AF1EE", hash_generated_method = "800834DA05538FBD581E6F9367E60777")
    @Override
protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String currentTabTag = mTabHost.getCurrentTabTag();
        if (currentTabTag != null) {
            outState.putString("currentTab", currentTabTag);
        }
    }

    /**
     * Updates the screen state (current list and other views) when the
     * content changes.
     * 
     *@see Activity#onContentChanged()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:22.111 -0500", hash_original_method = "582B2DDC8E1047355D2EEA6881BB52B9", hash_generated_method = "FC35BCF3565A03809911FAE1712E18DE")
    @Override
public void onContentChanged() {
        super.onContentChanged();
        mTabHost = (TabHost) findViewById(com.android.internal.R.id.tabhost);

        if (mTabHost == null) {
            throw new RuntimeException(
                    "Your content must have a TabHost whose id attribute is " +
                    "'android.R.id.tabhost'");
        }
        mTabHost.setup(getLocalActivityManager());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:22.112 -0500", hash_original_method = "165BC05C59C361B649DC3EA7F3563399", hash_generated_method = "1E5C770EAF8EFB294684B4B7179CB403")
    private void ensureTabHost() {
        if (mTabHost == null) {
            this.setContentView(com.android.internal.R.layout.tab_content);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:22.113 -0500", hash_original_method = "90307FAF1FA715C3E880FDADA1597ED5", hash_generated_method = "E18848D84C38468D55B904723A3A0629")
    @Override
protected void
    onChildTitleChanged(Activity childActivity, CharSequence title) {
        // Dorky implementation until we can have multiple activities running.
        if (getLocalActivityManager().getCurrentActivity() == childActivity) {
            View tabView = mTabHost.getCurrentTabView();
            if (tabView != null && tabView instanceof TextView) {
                ((TextView) tabView).setText(title);
            }
        }
    }

    /**
     * Returns the {@link TabHost} the activity is using to host its tabs.
     *
     * @return the {@link TabHost} the activity is using to host its tabs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:22.113 -0500", hash_original_method = "6AC0503CD9EB9D407A1E8CBC0E0E9255", hash_generated_method = "854FCBF35F834D6C10A8AC36ED9F2611")
    public TabHost getTabHost() {
        ensureTabHost();
        return mTabHost;
    }

    /**
     * Returns the {@link TabWidget} the activity is using to draw the actual tabs.
     *
     * @return the {@link TabWidget} the activity is using to draw the actual tabs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:22.114 -0500", hash_original_method = "8A117298A466C130739D5E7C43BBFBE6", hash_generated_method = "973D9B3CD91A6D11F69A7ED06F816FCC")
    public TabWidget getTabWidget() {
        return mTabHost.getTabWidget();
    }

    
}

