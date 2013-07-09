package android.app;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

public class TabActivity extends ActivityGroup {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.579 -0400", hash_original_field = "BEFE305CB509C7B768A055FC2844AD3E", hash_generated_field = "FDB3EE2BFD396DB59CF2AF609368DA5F")

    private TabHost mTabHost;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.580 -0400", hash_original_field = "2673BE403D04D82FDBA3E962F08C2A55", hash_generated_field = "15376AEA94D706E4B7600BED235ACE08")

    private String mDefaultTab = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.580 -0400", hash_original_field = "2B163D1DF886926CA978FE8CD880A2BD", hash_generated_field = "DDA136115CCD60C8AA5A05ECA2765B5B")

    private int mDefaultTabIndex = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.580 -0400", hash_original_method = "7656B1DA8F939C27E9A82F1B44C0847D", hash_generated_method = "31D889F3885F23AF577087DF7DEEA8FD")
    public  TabActivity() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.581 -0400", hash_original_method = "DD818EDD04198A64589FCF3CE4F0396C", hash_generated_method = "6EF6D298E53C3A38F863841FD7A54A7A")
    public void setDefaultTab(String tag) {
        mDefaultTab = tag;
        mDefaultTabIndex = -1;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.582 -0400", hash_original_method = "4CDCBCFE71ABD3C5FA6E0629F75B0C62", hash_generated_method = "826E6F3E2CF34349C386CCE272BF95A1")
    public void setDefaultTab(int index) {
        mDefaultTab = null;
        mDefaultTabIndex = index;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.583 -0400", hash_original_method = "43FC78560A264DC47797D8670D9C3246", hash_generated_method = "939A3B15CB42FE2B911FD499BC68A408")
    @Override
    protected void onRestoreInstanceState(Bundle state) {
        
        super.onRestoreInstanceState(state);
        ensureTabHost();
        String cur = state.getString("currentTab");
        {
            mTabHost.setCurrentTabByTag(cur);
        } 
        {
            boolean varB759B15E40530C9C0260D509474713F2_88183735 = (mTabHost.getCurrentTab() < 0);
            {
                {
                    mTabHost.setCurrentTabByTag(mDefaultTab);
                } 
                {
                    mTabHost.setCurrentTab(mDefaultTabIndex);
                } 
            } 
        } 
        addTaint(state.getTaint());
        
        
        
        
        
            
        
        
            
                
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.584 -0400", hash_original_method = "95D0011EE002D17BAA86137B82FD9E88", hash_generated_method = "8DA443D4A4DE42B0AF6ABC102EA34055")
    @Override
    protected void onPostCreate(Bundle icicle) {
        
        super.onPostCreate(icicle);
        ensureTabHost();
        {
            boolean var3C5C9E0FB5B4113877BCFA92B254E3EF_737277142 = (mTabHost.getCurrentTab() == -1);
            {
                mTabHost.setCurrentTab(0);
            } 
        } 
        addTaint(icicle.getTaint());
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.584 -0400", hash_original_method = "7A1E5FF4358126AE2CED70B78C4AF1EE", hash_generated_method = "7BDBC13CF2ADC1BB5921E6F503EF00FC")
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        
        super.onSaveInstanceState(outState);
        String currentTabTag = mTabHost.getCurrentTabTag();
        {
            outState.putString("currentTab", currentTabTag);
        } 
        addTaint(outState.getTaint());
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.585 -0400", hash_original_method = "582B2DDC8E1047355D2EEA6881BB52B9", hash_generated_method = "6372FE2BDAB68FEEB21FA6735B740DDC")
    @Override
    public void onContentChanged() {
        
        super.onContentChanged();
        mTabHost = (TabHost) findViewById(com.android.internal.R.id.tabhost);
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                    "Your content must have a TabHost whose id attribute is " +
                    "'android.R.id.tabhost'");
        } 
        mTabHost.setup(getLocalActivityManager());
        
        
        
        
            
                    
                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.586 -0400", hash_original_method = "165BC05C59C361B649DC3EA7F3563399", hash_generated_method = "3B7702C22FE7A89AA5949DCF5F7EE310")
    private void ensureTabHost() {
        {
            this.setContentView(com.android.internal.R.layout.tab_content);
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.587 -0400", hash_original_method = "90307FAF1FA715C3E880FDADA1597ED5", hash_generated_method = "916F23C6CCFC1FD14307615E77CD6896")
    @Override
    protected void onChildTitleChanged(Activity childActivity, CharSequence title) {
        
        {
            boolean var91C02A08111643BA5B7BBC33C7AF13E4_675383115 = (getLocalActivityManager().getCurrentActivity() == childActivity);
            {
                View tabView = mTabHost.getCurrentTabView();
                {
                    ((TextView) tabView).setText(title);
                } 
            } 
        } 
        addTaint(childActivity.getTaint());
        addTaint(title.getTaint());
        
        
            
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.588 -0400", hash_original_method = "6AC0503CD9EB9D407A1E8CBC0E0E9255", hash_generated_method = "A1447184A8A735B6610653ADC67FF2C1")
    public TabHost getTabHost() {
        TabHost varB4EAC82CA7396A68D541C85D26508E83_1976207668 = null; 
        ensureTabHost();
        varB4EAC82CA7396A68D541C85D26508E83_1976207668 = mTabHost;
        varB4EAC82CA7396A68D541C85D26508E83_1976207668.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1976207668;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.589 -0400", hash_original_method = "8A117298A466C130739D5E7C43BBFBE6", hash_generated_method = "06CB591F369C23C36BF7B0EFD3FBE85D")
    public TabWidget getTabWidget() {
        TabWidget varB4EAC82CA7396A68D541C85D26508E83_1215748055 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1215748055 = mTabHost.getTabWidget();
        varB4EAC82CA7396A68D541C85D26508E83_1215748055.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1215748055;
        
        
    }

    
}

