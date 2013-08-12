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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.794 -0400", hash_original_field = "BEFE305CB509C7B768A055FC2844AD3E", hash_generated_field = "FDB3EE2BFD396DB59CF2AF609368DA5F")

    private TabHost mTabHost;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.795 -0400", hash_original_field = "2673BE403D04D82FDBA3E962F08C2A55", hash_generated_field = "15376AEA94D706E4B7600BED235ACE08")

    private String mDefaultTab = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.796 -0400", hash_original_field = "2B163D1DF886926CA978FE8CD880A2BD", hash_generated_field = "DDA136115CCD60C8AA5A05ECA2765B5B")

    private int mDefaultTabIndex = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.797 -0400", hash_original_method = "7656B1DA8F939C27E9A82F1B44C0847D", hash_generated_method = "31D889F3885F23AF577087DF7DEEA8FD")
    public  TabActivity() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.802 -0400", hash_original_method = "DD818EDD04198A64589FCF3CE4F0396C", hash_generated_method = "6EF6D298E53C3A38F863841FD7A54A7A")
    public void setDefaultTab(String tag) {
        mDefaultTab = tag;
        mDefaultTabIndex = -1;
        // ---------- Original Method ----------
        //mDefaultTab = tag;
        //mDefaultTabIndex = -1;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.805 -0400", hash_original_method = "4CDCBCFE71ABD3C5FA6E0629F75B0C62", hash_generated_method = "826E6F3E2CF34349C386CCE272BF95A1")
    public void setDefaultTab(int index) {
        mDefaultTab = null;
        mDefaultTabIndex = index;
        // ---------- Original Method ----------
        //mDefaultTab = null;
        //mDefaultTabIndex = index;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.809 -0400", hash_original_method = "43FC78560A264DC47797D8670D9C3246", hash_generated_method = "DDF2B14F26A5FCD77F3BB4ECAE4C77A0")
    @Override
    protected void onRestoreInstanceState(Bundle state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(state.getTaint());
        super.onRestoreInstanceState(state);
        ensureTabHost();
        String cur = state.getString("currentTab");
        if(cur != null)        
        {
            mTabHost.setCurrentTabByTag(cur);
        } //End block
        if(mTabHost.getCurrentTab() < 0)        
        {
            if(mDefaultTab != null)            
            {
                mTabHost.setCurrentTabByTag(mDefaultTab);
            } //End block
            else
            if(mDefaultTabIndex >= 0)            
            {
                mTabHost.setCurrentTab(mDefaultTabIndex);
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.813 -0400", hash_original_method = "95D0011EE002D17BAA86137B82FD9E88", hash_generated_method = "B6D51AC5447D40C39E4714C9B483690D")
    @Override
    protected void onPostCreate(Bundle icicle) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(icicle.getTaint());
        super.onPostCreate(icicle);
        ensureTabHost();
        if(mTabHost.getCurrentTab() == -1)        
        {
            mTabHost.setCurrentTab(0);
        } //End block
        // ---------- Original Method ----------
        //super.onPostCreate(icicle);
        //ensureTabHost();
        //if (mTabHost.getCurrentTab() == -1) {
            //mTabHost.setCurrentTab(0);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.815 -0400", hash_original_method = "7A1E5FF4358126AE2CED70B78C4AF1EE", hash_generated_method = "032CC45F32190987341F6A369950F9F3")
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(outState.getTaint());
        super.onSaveInstanceState(outState);
        String currentTabTag = mTabHost.getCurrentTabTag();
        if(currentTabTag != null)        
        {
            outState.putString("currentTab", currentTabTag);
        } //End block
        // ---------- Original Method ----------
        //super.onSaveInstanceState(outState);
        //String currentTabTag = mTabHost.getCurrentTabTag();
        //if (currentTabTag != null) {
            //outState.putString("currentTab", currentTabTag);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.820 -0400", hash_original_method = "582B2DDC8E1047355D2EEA6881BB52B9", hash_generated_method = "4821CB8641E74D5DF7C588F70D740FBF")
    @Override
    public void onContentChanged() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onContentChanged();
        mTabHost = (TabHost) findViewById(com.android.internal.R.id.tabhost);
        if(mTabHost == null)        
        {
            RuntimeException var360CB72B77B8C488AE7D6E2D4D2E1003_1328105687 = new RuntimeException(
                    "Your content must have a TabHost whose id attribute is " +
                    "'android.R.id.tabhost'");
            var360CB72B77B8C488AE7D6E2D4D2E1003_1328105687.addTaint(taint);
            throw var360CB72B77B8C488AE7D6E2D4D2E1003_1328105687;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.825 -0400", hash_original_method = "165BC05C59C361B649DC3EA7F3563399", hash_generated_method = "00DE5349A258909C28EFAA2FAD8BD06D")
    private void ensureTabHost() {
        if(mTabHost == null)        
        {
            this.setContentView(com.android.internal.R.layout.tab_content);
        } //End block
        // ---------- Original Method ----------
        //if (mTabHost == null) {
            //this.setContentView(com.android.internal.R.layout.tab_content);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.829 -0400", hash_original_method = "90307FAF1FA715C3E880FDADA1597ED5", hash_generated_method = "2CAEDF22E79EDC59D7347942BD88C865")
    @Override
    protected void onChildTitleChanged(Activity childActivity, CharSequence title) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(title.getTaint());
        addTaint(childActivity.getTaint());
        if(getLocalActivityManager().getCurrentActivity() == childActivity)        
        {
            View tabView = mTabHost.getCurrentTabView();
            if(tabView != null && tabView instanceof TextView)            
            {
                ((TextView) tabView).setText(title);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (getLocalActivityManager().getCurrentActivity() == childActivity) {
            //View tabView = mTabHost.getCurrentTabView();
            //if (tabView != null && tabView instanceof TextView) {
                //((TextView) tabView).setText(title);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.831 -0400", hash_original_method = "6AC0503CD9EB9D407A1E8CBC0E0E9255", hash_generated_method = "8C9A4BC472A5B96B6E3CE6ABFE0CD7AF")
    public TabHost getTabHost() {
        ensureTabHost();
TabHost var06998FE366872B3BEE4958CBCD2D2D0F_1863439716 =         mTabHost;
        var06998FE366872B3BEE4958CBCD2D2D0F_1863439716.addTaint(taint);
        return var06998FE366872B3BEE4958CBCD2D2D0F_1863439716;
        // ---------- Original Method ----------
        //ensureTabHost();
        //return mTabHost;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.832 -0400", hash_original_method = "8A117298A466C130739D5E7C43BBFBE6", hash_generated_method = "8EA6BE70BBC671D625B4AD005E81518B")
    public TabWidget getTabWidget() {
TabWidget varF0DBA4D03D7609D8323613EAD5340477_472807350 =         mTabHost.getTabWidget();
        varF0DBA4D03D7609D8323613EAD5340477_472807350.addTaint(taint);
        return varF0DBA4D03D7609D8323613EAD5340477_472807350;
        // ---------- Original Method ----------
        //return mTabHost.getTabWidget();
    }

    
}

