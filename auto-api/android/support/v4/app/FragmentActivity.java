package android.support.v4.app;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class FragmentActivity extends Activity {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.736 -0400", hash_original_field = "BD6DAC53FC9C157B350330EAEE248807", hash_generated_field = "501FA87408E2F66D936187DF5DCADDC6")

    final Handler mHandler = new Handler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.736 -0400", hash_original_method = "ED8978699985B094E29E929E78E6359E", hash_generated_method = "168BA30ED6C33F2DDBC36D8B8B268C8C")
        @Override
        public void handleMessage(Message msg) {
            
            {
                doReallyStop(false);
            } 
            
            
            onResumeFragments();
            
            
            mFragments.execPendingActions();
            
            
            super.handleMessage(msg);
            
            addTaint(msg.getTaint());
            
            
                
                    
                        
                    
                    
                
                    
                    
                    
                
                    
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.737 -0400", hash_original_field = "9E9F5C9A2D303AC76B37DDF504A5EF92", hash_generated_field = "694874072698409F6608B46B5D5A3DE1")

    final FragmentManagerImpl mFragments = new FragmentManagerImpl();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.737 -0400", hash_original_field = "BF98B02E33783F9E5A5CF09B5615CA83", hash_generated_field = "ADF324DE7C48550B65817C7DAE1C2031")

    final FragmentContainer mContainer = new FragmentContainer() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.737 -0400", hash_original_method = "EBF9138B1D5057AD1D48F1D0D3D08E54", hash_generated_method = "93FC326340435248F019828EB69DF899")
        @Override
        public View findViewById(int id) {
            View varB4EAC82CA7396A68D541C85D26508E83_497045847 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_497045847 = FragmentActivity.this.findViewById(id);
            addTaint(id);
            varB4EAC82CA7396A68D541C85D26508E83_497045847.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_497045847;
            
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.737 -0400", hash_original_field = "7887646F8CFE1A947D11EA6420A8B1DF", hash_generated_field = "271824B07358893C73D20BA1540862F9")

    boolean mCreated;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.738 -0400", hash_original_field = "9933B84C738DC45A33F44AE2EFCBD30F", hash_generated_field = "23D2434AD22548E124B62AB7739838E9")

    boolean mResumed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.738 -0400", hash_original_field = "33AF93F952A554412842C66D48683981", hash_generated_field = "C703FF92314B1EE9638F5EE77CD641D7")

    boolean mStopped;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.738 -0400", hash_original_field = "B1982C70B990A57E853D769AA7D47148", hash_generated_field = "747FF298A79A7C3192A681D678D25FE6")

    boolean mReallyStopped;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.738 -0400", hash_original_field = "DD825820C327E7F8D7347744CB13973E", hash_generated_field = "9B9EA230363F2EF227C5BE272DCC6838")

    boolean mRetaining;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.738 -0400", hash_original_field = "8D082D8869E8E3F959CB30710AFA9671", hash_generated_field = "DB8D4CEB8A7AAD8A9737A3EEEA202045")

    boolean mOptionsMenuInvalidated;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.738 -0400", hash_original_field = "E2FDF9701AF8C008E54F63B95BC75C79", hash_generated_field = "93A369593E1CC22C7DE8D4D5C675B065")

    boolean mCheckedForLoaderManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.738 -0400", hash_original_field = "7B94EB60C9B740E67FF099B167511F7B", hash_generated_field = "D357ECA56BF47F1751443279339D50DF")

    boolean mLoadersStarted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.738 -0400", hash_original_field = "C3FC98EBFA953A5BA9BDADB9981A948A", hash_generated_field = "12F53F261CD1A5D7A9E1650F04FB24A0")

    HashMap<String, LoaderManagerImpl> mAllLoaderManagers;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.738 -0400", hash_original_field = "780418B081227A51BFCB9EC0223B15ED", hash_generated_field = "6EE478DF5473556475C8D09C185A01BC")

    LoaderManagerImpl mLoaderManager;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.738 -0400", hash_original_method = "A8E156BB7E87BE56EEE389E385DAEBFA", hash_generated_method = "A8E156BB7E87BE56EEE389E385DAEBFA")
    public FragmentActivity ()
    {
        
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.739 -0400", hash_original_method = "AE8D2F77597464B24506681CBB435A18", hash_generated_method = "1959681C830DB30762AED39BD167799D")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        
        mFragments.noteStateNotSaved();
        int index = requestCode>>16;
        {
            {
                boolean var56D5535283CDDB9CA6C9FE2754AC0112_1337897066 = (mFragments.mActive == null || index < 0 || index >= mFragments.mActive.size());
            } 
            Fragment frag = mFragments.mActive.get(index);
            {
                frag.onActivityResult(requestCode&0xffff, resultCode, data);
            } 
        } 
        super.onActivityResult(requestCode, resultCode, data);
        addTaint(requestCode);
        addTaint(resultCode);
        addTaint(data.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.740 -0400", hash_original_method = "6AE13C43A807A8F581EF7E482513BDAF", hash_generated_method = "A0D9E33A55941DD57DA4614BE3FDB01B")
    public void onBackPressed() {
        
        {
            boolean var5C240956F2A34791A06A0F4236D73061_660134422 = (!mFragments.popBackStackImmediate());
            {
                finish();
            } 
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.740 -0400", hash_original_method = "55FDC064636609C07EA6D352B59B7C90", hash_generated_method = "744CE0EE1E79E428FC0F115815525478")
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        
        super.onConfigurationChanged(newConfig);
        mFragments.dispatchConfigurationChanged(newConfig);
        addTaint(newConfig.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.741 -0400", hash_original_method = "C455F2D927ADC92D1A4791D782C4857A", hash_generated_method = "2EBEA5A23B43BA14D248FE86B8809A93")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        mFragments.attachActivity(this, mContainer, null);
        {
            boolean var897078D306EA59CF34AB5640B4C99A5E_1326433022 = (getLayoutInflater().getFactory() == null);
            {
                getLayoutInflater().setFactory(this);
            } 
        } 
        super.onCreate(savedInstanceState);
        NonConfigurationInstances nc = (NonConfigurationInstances)
                getLastNonConfigurationInstance();
        {
            mAllLoaderManagers = nc.loaders;
        } 
        {
            Parcelable p = savedInstanceState.getParcelable(FRAGMENTS_TAG);
            mFragments.restoreAllState(p, nc != null ? nc.fragments : null);
        } 
        mFragments.dispatchCreate();
        addTaint(savedInstanceState.getTaint());
        
        
        
            
        
        
        
                
        
            
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.741 -0400", hash_original_method = "7F7FAA4BD379FD5B7B024567C1869B85", hash_generated_method = "AD20A47D78FACB129C008F2EF43737CC")
    @Override
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        
        {
            boolean show = super.onCreatePanelMenu(featureId, menu);
            show |= mFragments.dispatchCreateOptionsMenu(menu, getMenuInflater());
        } 
        boolean varBC0609E39141DD93BD051DCAB4D84F60_32612930 = (super.onCreatePanelMenu(featureId, menu));
        addTaint(featureId);
        addTaint(menu.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_562619606 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_562619606;
        
        
            
            
            
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.743 -0400", hash_original_method = "77C8CC4EE959FDB021D467966620FB0D", hash_generated_method = "14BF6FB00E0D88ABCEDFD182A5C3A418")
    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        
        View varB4EAC82CA7396A68D541C85D26508E83_973837427 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_472298878 = null; 
        {
            boolean var0F10F717A8824D895C9119EA392D7F2A_1520593106 = (!"fragment".equals(name));
            {
                varB4EAC82CA7396A68D541C85D26508E83_973837427 = super.onCreateView(name, context, attrs);
            } 
        } 
        String fname = attrs.getAttributeValue(null, "class");
        TypedArray a = context.obtainStyledAttributes(attrs, FragmentTag.Fragment);
        {
            fname = a.getString(FragmentTag.Fragment_name);
        } 
        int id = a.getResourceId(FragmentTag.Fragment_id, View.NO_ID);
        String tag = a.getString(FragmentTag.Fragment_tag);
        a.recycle();
        View parent = null;
        int containerId;
        containerId = parent.getId();
        containerId = 0;
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(attrs.getPositionDescription()
                    + ": Must specify unique android:id, android:tag, or have a parent with an id for " + fname);
        } 
        Fragment fragment;
        fragment = mFragments.findFragmentById(id);
        fragment = null;
        {
            fragment = mFragments.findFragmentByTag(tag);
        } 
        {
            fragment = mFragments.findFragmentById(containerId);
        } 
        {
            fragment = Fragment.instantiate(this, fname);
            fragment.mFromLayout = true;
            fragment.mFragmentId = id != 0 ? id : containerId;
            fragment.mContainerId = containerId;
            fragment.mTag = tag;
            fragment.mInLayout = true;
            fragment.mFragmentManager = mFragments;
            fragment.onInflate(this, attrs, fragment.mSavedFragmentState);
            mFragments.addFragment(fragment, true);
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(attrs.getPositionDescription()
                    + ": Duplicate id 0x" + Integer.toHexString(id)
                    + ", tag " + tag + ", or parent id 0x" + Integer.toHexString(containerId)
                    + " with another fragment for " + fname);
        } 
        {
            fragment.mInLayout = true;
            {
                fragment.onInflate(this, attrs, fragment.mSavedFragmentState);
            } 
            mFragments.moveToState(fragment);
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Fragment " + fname
                    + " did not create a view.");
        } 
        {
            fragment.mView.setId(id);
        } 
        {
            boolean var28AAFB4908746F4035C573FBEA5D04E5_1340192582 = (fragment.mView.getTag() == null);
            {
                fragment.mView.setTag(tag);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_472298878 = fragment.mView;
        addTaint(name.getTaint());
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        View varA7E53CE21691AB073D9660D615818899_679375372; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_679375372 = varB4EAC82CA7396A68D541C85D26508E83_973837427;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_679375372 = varB4EAC82CA7396A68D541C85D26508E83_472298878;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_679375372.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_679375372;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.743 -0400", hash_original_method = "81DE240BA78D06EF3CA4E4150F572C81", hash_generated_method = "3D5C30949FF5D5945B61A67D7F523035")
    @Override
    protected void onDestroy() {
        
        super.onDestroy();
        doReallyStop(false);
        mFragments.dispatchDestroy();
        {
            mLoaderManager.doDestroy();
        } 
        
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.744 -0400", hash_original_method = "9885A8D8E166C211280B71A198245DDA", hash_generated_method = "4FD17FB0E2651543E4EF345644F20B7E")
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        
        {
            boolean var589B130747FD36B61C3189894CAF6513_2064926178 = (android.os.Build.VERSION.SDK_INT < 5 
                && keyCode == KeyEvent.KEYCODE_BACK
                && event.getRepeatCount() == 0);
            {
                onBackPressed();
            } 
        } 
        boolean var8C6E6C19273FC56B5C56CC7DEF63ED7B_1709141046 = (super.onKeyDown(keyCode, event));
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1778662235 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1778662235;
        
        
                
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.744 -0400", hash_original_method = "5060399A61D97F30C880AACCBE3D1906", hash_generated_method = "179AD79FEEBC5260223D01A1DE47B9E6")
    @Override
    public void onLowMemory() {
        
        super.onLowMemory();
        mFragments.dispatchLowMemory();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.744 -0400", hash_original_method = "07B1A6CC471050623DC993725853B976", hash_generated_method = "D5D18FCC08CF2F07168C8499F718C56E")
    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        
        {
            boolean var80D23AF261DC2D76825947E935873830_1404304026 = (super.onMenuItemSelected(featureId, item));
        } 
        
        boolean varE8A690D6428BE61C39A35A33EE497930_451241361 = (mFragments.dispatchOptionsItemSelected(item));
        
        
        boolean var06F6B009CCB26CDE69B7F5C36D0D4DFE_1691038038 = (mFragments.dispatchContextItemSelected(item));
        
        addTaint(featureId);
        addTaint(item.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1620859108 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1620859108;
        
        
            
        
        
            
                
            
                
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.745 -0400", hash_original_method = "B1F57A749E35030E5CB8EAB506D19441", hash_generated_method = "296AF4F9A3E80F9EAEE6B8CA53BAE5C3")
    @Override
    public void onPanelClosed(int featureId, Menu menu) {
        
        
        mFragments.dispatchOptionsMenuClosed(menu);
        
        super.onPanelClosed(featureId, menu);
        addTaint(featureId);
        addTaint(menu.getTaint());
        
        
            
                
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.745 -0400", hash_original_method = "EBBC480BA94BD3D79D683AB555C9F857", hash_generated_method = "27C9C6391964346EFFC47166183351B6")
    @Override
    protected void onPause() {
        
        super.onPause();
        mResumed = false;
        {
            boolean varE846E8054E55107C7ED185FA70E4116A_871584231 = (mHandler.hasMessages(MSG_RESUME_PENDING));
            {
                mHandler.removeMessages(MSG_RESUME_PENDING);
                onResumeFragments();
            } 
        } 
        mFragments.dispatchPause();
        
        
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.746 -0400", hash_original_method = "22DD6D11219C23D125AE29FC1331896B", hash_generated_method = "69A15B9D6984917E5AC499991F82AA67")
    @Override
    protected void onNewIntent(Intent intent) {
        
        super.onNewIntent(intent);
        mFragments.noteStateNotSaved();
        addTaint(intent.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.746 -0400", hash_original_method = "3FCB5D73B297020DDBEAF38F4A9C2458", hash_generated_method = "2304C8D4908051D209863854C6EC9090")
    @Override
    protected void onResume() {
        
        super.onResume();
        mHandler.sendEmptyMessage(MSG_RESUME_PENDING);
        mResumed = true;
        mFragments.execPendingActions();
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.746 -0400", hash_original_method = "6B2BC88BC45E8448086501D1DCC5CA8F", hash_generated_method = "0EC7CE9DD1DFB4A4C28F312BCC044B23")
    @Override
    protected void onPostResume() {
        
        super.onPostResume();
        mHandler.removeMessages(MSG_RESUME_PENDING);
        onResumeFragments();
        mFragments.execPendingActions();
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.747 -0400", hash_original_method = "571F1484F02501E8599B33312B988FBD", hash_generated_method = "D3F8E7A7CF464221689B4E21DB27888D")
    protected void onResumeFragments() {
        
        mFragments.dispatchResume();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.747 -0400", hash_original_method = "B669498AB621CA27E61E7D94F5D38091", hash_generated_method = "A3818E52A9ABFFB32A4A534F179FC13F")
    @Override
    public boolean onPreparePanel(int featureId, View view, Menu menu) {
        
        {
            {
                mOptionsMenuInvalidated = false;
                menu.clear();
                onCreatePanelMenu(featureId, menu);
            } 
            boolean goforit = super.onPreparePanel(featureId, view, menu);
            goforit |= mFragments.dispatchPrepareOptionsMenu(menu);
            boolean var7116118DD297E6C08BE1AD40992AA51A_1783855897 = (goforit && menu.hasVisibleItems());
        } 
        boolean var6AD9E3BDA38B7F6D015ACC0F119D59E3_429494877 = (super.onPreparePanel(featureId, view, menu));
        addTaint(featureId);
        addTaint(view.getTaint());
        addTaint(menu.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_974795555 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_974795555;
        
        
            
                
                
                
            
            
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.748 -0400", hash_original_method = "26757680A48F135FACB25346DC79BC25", hash_generated_method = "34AB4214901538AD87AA6B678213810F")
    @Override
    public final Object onRetainNonConfigurationInstance() {
        
        Object varB4EAC82CA7396A68D541C85D26508E83_474339042 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_1900268606 = null; 
        {
            doReallyStop(true);
        } 
        Object custom = onRetainCustomNonConfigurationInstance();
        ArrayList<Fragment> fragments = mFragments.retainNonConfig();
        boolean retainLoaders = false;
        {
            LoaderManagerImpl loaders[] = new LoaderManagerImpl[mAllLoaderManagers.size()];
            mAllLoaderManagers.values().toArray(loaders);
            {
                {
                    int i = 0;
                    {
                        LoaderManagerImpl lm = loaders[i];
                        {
                            retainLoaders = true;
                        } 
                        {
                            lm.doDestroy();
                            mAllLoaderManagers.remove(lm.mWho);
                        } 
                    } 
                } 
            } 
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_474339042 = null;
        } 
        NonConfigurationInstances nci = new NonConfigurationInstances();
        nci.activity = null;
        nci.custom = custom;
        nci.children = null;
        nci.fragments = fragments;
        nci.loaders = mAllLoaderManagers;
        varB4EAC82CA7396A68D541C85D26508E83_1900268606 = nci;
        Object varA7E53CE21691AB073D9660D615818899_1968899138; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1968899138 = varB4EAC82CA7396A68D541C85D26508E83_474339042;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1968899138 = varB4EAC82CA7396A68D541C85D26508E83_1900268606;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1968899138.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1968899138;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.749 -0400", hash_original_method = "C79CD565EF7D4DAA3E1BC7711F48F8E1", hash_generated_method = "8FBC8B563F8853C271E83F4FEC2B542D")
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        
        super.onSaveInstanceState(outState);
        Parcelable p = mFragments.saveAllState();
        {
            outState.putParcelable(FRAGMENTS_TAG, p);
        } 
        addTaint(outState.getTaint());
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.750 -0400", hash_original_method = "F5C32F05E56A3FD61FD95DF89ACF56DE", hash_generated_method = "A50A83BE76F80940D39F5C58693560C9")
    @Override
    protected void onStart() {
        
        super.onStart();
        mStopped = false;
        mReallyStopped = false;
        mHandler.removeMessages(MSG_REALLY_STOPPED);
        {
            mCreated = true;
            mFragments.dispatchActivityCreated();
        } 
        mFragments.noteStateNotSaved();
        mFragments.execPendingActions();
        {
            mLoadersStarted = true;
            {
                mLoaderManager.doStart();
            } 
            {
                mLoaderManager = getLoaderManager(null, mLoadersStarted, false);
                {
                    mLoaderManager.doStart();
                } 
            } 
            mCheckedForLoaderManager = true;
        } 
        mFragments.dispatchStart();
        {
            LoaderManagerImpl loaders[] = new LoaderManagerImpl[mAllLoaderManagers.size()];
            mAllLoaderManagers.values().toArray(loaders);
            {
                {
                    int i = 0;
                    {
                        LoaderManagerImpl lm = loaders[i];
                        lm.finishRetain();
                        lm.doReportStart();
                    } 
                } 
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.751 -0400", hash_original_method = "F60F215A385D287752751758F3F3D1D2", hash_generated_method = "D292BE290C6A31742F08B288962530FC")
    @Override
    protected void onStop() {
        
        super.onStop();
        mStopped = true;
        mHandler.sendEmptyMessage(MSG_REALLY_STOPPED);
        mFragments.dispatchStop();
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.752 -0400", hash_original_method = "F55A4C6A01F3D0AB15650B3080E9EF76", hash_generated_method = "DE559D86CCE183E8F824016D2AB4BCF5")
    public Object onRetainCustomNonConfigurationInstance() {
        
        Object varB4EAC82CA7396A68D541C85D26508E83_717238163 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_717238163 = null;
        varB4EAC82CA7396A68D541C85D26508E83_717238163.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_717238163;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.753 -0400", hash_original_method = "350BC71A71D255050EA53218D39061A7", hash_generated_method = "787AC16C117430A4B59380D2D4EB62BD")
    public Object getLastCustomNonConfigurationInstance() {
        Object varB4EAC82CA7396A68D541C85D26508E83_99197518 = null; 
        NonConfigurationInstances nc = (NonConfigurationInstances)
                getLastNonConfigurationInstance();
        varB4EAC82CA7396A68D541C85D26508E83_99197518 = nc != null ? nc.custom : null;
        varB4EAC82CA7396A68D541C85D26508E83_99197518.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_99197518;
        
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.753 -0400", hash_original_method = "9AD1865EB184E07C9164FA8858758524", hash_generated_method = "419C889AF9E66DFB659C8D9136B8CAD2")
    public void supportInvalidateOptionsMenu() {
        {
            ActivityCompatHoneycomb.invalidateOptionsMenu(this);
        } 
        mOptionsMenuInvalidated = true;
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.754 -0400", hash_original_method = "793A438044EEB54318015A62231AC042", hash_generated_method = "D64314F1BB83393D7D2EB229963C54A6")
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        writer.print(prefix);
        writer.print("Local FragmentActivity ");
        writer.print(Integer.toHexString(System.identityHashCode(this)));
        writer.println(" State:");
        String innerPrefix = prefix + "  ";
        writer.print(innerPrefix);
        writer.print("mCreated=");
        writer.print(mCreated);
        writer.print("mResumed=");
        writer.print(mResumed);
        writer.print(" mStopped=");
        writer.print(mStopped);
        writer.print(" mReallyStopped=");
        writer.println(mReallyStopped);
        writer.print(innerPrefix);
        writer.print("mLoadersStarted=");
        writer.println(mLoadersStarted);
        {
            writer.print(prefix);
            writer.print("Loader Manager ");
            writer.print(Integer.toHexString(System.identityHashCode(mLoaderManager)));
            writer.println(":");
            mLoaderManager.dump(prefix + "  ", fd, writer, args);
        } 
        mFragments.dump(prefix, fd, writer, args);
        writer.print(prefix);
        writer.println("View Hierarchy:");
        dumpViewHierarchy(prefix + "  ", writer, getWindow().getDecorView());
        addTaint(prefix.getTaint());
        addTaint(fd.getTaint());
        addTaint(writer.getTaint());
        addTaint(args[0].getTaint());
        
        
    }

    
        @DSModeled(DSC.SAFE)
    private static String viewToString(View view) {
        StringBuilder out = new StringBuilder(128);
        out.append(view.getClass().getName());
        out.append('{');
        out.append(Integer.toHexString(System.identityHashCode(view)));
        out.append(' ');
        switch (view.getVisibility()) {
            case View.VISIBLE: out.append('V'); break;
            case View.INVISIBLE: out.append('I'); break;
            case View.GONE: out.append('G'); break;
            default: out.append('.'); break;
        }
        out.append(view.isFocusable() ? 'F' : '.');
        out.append(view.isEnabled() ? 'E' : '.');
        out.append(view.willNotDraw() ? '.' : 'D');
        out.append(view.isHorizontalScrollBarEnabled()? 'H' : '.');
        out.append(view.isVerticalScrollBarEnabled() ? 'V' : '.');
        out.append(view.isClickable() ? 'C' : '.');
        out.append(view.isLongClickable() ? 'L' : '.');
        out.append(' ');
        out.append(view.isFocused() ? 'F' : '.');
        out.append(view.isSelected() ? 'S' : '.');
        out.append(view.isPressed() ? 'P' : '.');
        out.append(' ');
        out.append(view.getLeft());
        out.append(',');
        out.append(view.getTop());
        out.append('-');
        out.append(view.getRight());
        out.append(',');
        out.append(view.getBottom());
        final int id = view.getId();
        if (id != View.NO_ID) {
            out.append(" #");
            out.append(Integer.toHexString(id));
            final Resources r = view.getResources();
            if (id != 0 && r != null) {
                try {
                    String pkgname;
                    switch (id&0xff000000) {
                        case 0x7f000000:
                            pkgname="app";
                            break;
                        case 0x01000000:
                            pkgname="android";
                            break;
                        default:
                            pkgname = r.getResourcePackageName(id);
                            break;
                    }
                    String typename = r.getResourceTypeName(id);
                    String entryname = r.getResourceEntryName(id);
                    out.append(" ");
                    out.append(pkgname);
                    out.append(":");
                    out.append(typename);
                    out.append("/");
                    out.append(entryname);
                } catch (Resources.NotFoundException e) {
                }
            }
        }
        out.append("}");
        return out.toString();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.755 -0400", hash_original_method = "0B7E3349E1F0303BBAAE6767112F50B2", hash_generated_method = "9445D930D9D818731BA88F111C78359B")
    private void dumpViewHierarchy(String prefix, PrintWriter writer, View view) {
        writer.print(prefix);
        {
            writer.println("null");
        } 
        writer.println(viewToString(view));
        ViewGroup grp = (ViewGroup)view;
        final int N = grp.getChildCount();
        prefix = prefix + "  ";
        {
            int i = 0;
            {
                dumpViewHierarchy(prefix, writer, grp.getChildAt(i));
            } 
        } 
        addTaint(prefix.getTaint());
        addTaint(writer.getTaint());
        addTaint(view.getTaint());
        
        
        
            
            
        
        
        
            
        
        
        
        
            
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.755 -0400", hash_original_method = "4C92BE36A72450E440D9BAAFB03D8955", hash_generated_method = "8C1ABF5890F17C22B4C073F21006326D")
     void doReallyStop(boolean retaining) {
        {
            mReallyStopped = true;
            mRetaining = retaining;
            mHandler.removeMessages(MSG_REALLY_STOPPED);
            onReallyStop();
        } 
        
        
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.756 -0400", hash_original_method = "E4D0A1E9799E4532B863FFE2D6A92452", hash_generated_method = "A4E2620AD94AA7F4E435DEB0C02AD08F")
     void onReallyStop() {
        
        {
            mLoadersStarted = false;
            {
                {
                    mLoaderManager.doStop();
                } 
                {
                    mLoaderManager.doRetain();
                } 
            } 
        } 
        mFragments.dispatchReallyStop();
        
        
            
            
                
                    
                
                    
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.756 -0400", hash_original_method = "28C2B4CF762BABC0F8C194FDD6A98E77", hash_generated_method = "7BA62512AFE4BD6BB2D807B17B09B3A6")
    public void onAttachFragment(Fragment fragment) {
        
        addTaint(fragment.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.756 -0400", hash_original_method = "A30369BEE359642894950823DFC915CE", hash_generated_method = "D7EFDC0EF0403ED6A154386F4CBE0655")
    public FragmentManager getSupportFragmentManager() {
        FragmentManager varB4EAC82CA7396A68D541C85D26508E83_21361763 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_21361763 = mFragments;
        varB4EAC82CA7396A68D541C85D26508E83_21361763.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_21361763;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.757 -0400", hash_original_method = "5BE63D387764C79BADD7265D6253130D", hash_generated_method = "814CA2E1FF69D2569FF984822D3F52AA")
    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        } 
        super.startActivityForResult(intent, requestCode);
        addTaint(intent.getTaint());
        addTaint(requestCode);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.757 -0400", hash_original_method = "62E7172DD8437600599EFB859FBECAC1", hash_generated_method = "FAFAF89BBF44057AB8C563B2900D79C8")
    public void startActivityFromFragment(Fragment fragment, Intent intent, 
            int requestCode) {
        {
            super.startActivityForResult(intent, -1);
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        } 
        super.startActivityForResult(intent, ((fragment.mIndex+1)<<16) + (requestCode&0xffff));
        addTaint(fragment.getTaint());
        addTaint(intent.getTaint());
        addTaint(requestCode);
        
        
            
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.757 -0400", hash_original_method = "6D742EEA8D7FFBA4C7362E83B04A53C8", hash_generated_method = "D67DEA93F8B8D2CAA8539667EA29A69B")
     void invalidateSupportFragment(String who) {
        {
            LoaderManagerImpl lm = mAllLoaderManagers.get(who);
            {
                lm.doDestroy();
                mAllLoaderManagers.remove(who);
            } 
        } 
        addTaint(who.getTaint());
        
        
            
            
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.759 -0400", hash_original_method = "7961401A3063345A714303BF5703D192", hash_generated_method = "3E3FDA928FEAC1D685921B1654C528C7")
    public LoaderManager getSupportLoaderManager() {
        LoaderManager varB4EAC82CA7396A68D541C85D26508E83_1283274358 = null; 
        LoaderManager varB4EAC82CA7396A68D541C85D26508E83_192696400 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1283274358 = mLoaderManager;
        } 
        mCheckedForLoaderManager = true;
        mLoaderManager = getLoaderManager(null, mLoadersStarted, true);
        varB4EAC82CA7396A68D541C85D26508E83_192696400 = mLoaderManager;
        LoaderManager varA7E53CE21691AB073D9660D615818899_1112368372; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1112368372 = varB4EAC82CA7396A68D541C85D26508E83_1283274358;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1112368372 = varB4EAC82CA7396A68D541C85D26508E83_192696400;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1112368372.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1112368372;
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.760 -0400", hash_original_method = "AFD15C82BB2F05228B3396C6CCD75AFC", hash_generated_method = "84B8F2296932C065C4E04A581A1BB75B")
     LoaderManagerImpl getLoaderManager(String who, boolean started, boolean create) {
        LoaderManagerImpl varB4EAC82CA7396A68D541C85D26508E83_1930299347 = null; 
        {
            mAllLoaderManagers = new HashMap<String, LoaderManagerImpl>();
        } 
        LoaderManagerImpl lm = mAllLoaderManagers.get(who);
        {
            {
                lm = new LoaderManagerImpl(who, this, started);
                mAllLoaderManagers.put(who, lm);
            } 
        } 
        {
            lm.updateActivity(this);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1930299347 = lm;
        addTaint(who.getTaint());
        addTaint(started);
        addTaint(create);
        varB4EAC82CA7396A68D541C85D26508E83_1930299347.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1930299347;
        
        
            
        
        
        
            
                
                
            
        
            
        
        
    }

    
    static final class NonConfigurationInstances {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.760 -0400", hash_original_field = "69A256025F66E4CE5D15C9DD7225D357", hash_generated_field = "AE7D68ABA75D09946A953E289939C500")

        Object activity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.760 -0400", hash_original_field = "8B9035807842A4E4DBE009F3F1478127", hash_generated_field = "6C7B2F12230CF06C59368C1EB75FD645")

        Object custom;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.760 -0400", hash_original_field = "268184C12DF027F536154D099D497B31", hash_generated_field = "39C55DEAC9D9B669F0F104569866C7D7")

        HashMap<String, Object> children;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.760 -0400", hash_original_field = "AD7BA86BB6B55B3BB2BB5F974A84CECF", hash_generated_field = "CB2FDAC93F3729E9B59C5F21C93A6FFF")

        ArrayList<Fragment> fragments;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.760 -0400", hash_original_field = "2AB8B63748D15E45B6CE4A33D435F369", hash_generated_field = "8C064BAF950EC1A7AEC35748813A8160")

        HashMap<String, LoaderManagerImpl> loaders;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.760 -0400", hash_original_method = "6ECBAFFBF9F9B3F6A966772230E87049", hash_generated_method = "6ECBAFFBF9F9B3F6A966772230E87049")
        public NonConfigurationInstances ()
        {
            
        }


    }


    
    static class FragmentTag {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.760 -0400", hash_original_method = "97B15C4C04F651D57AC6A8ACA51C7A09", hash_generated_method = "97B15C4C04F651D57AC6A8ACA51C7A09")
        public FragmentTag ()
        {
            
        }


        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.760 -0400", hash_original_field = "D42252BEFED75C32E548BE75BF5C4620", hash_generated_field = "3167F4E7249DC389B08D5F8E4C20C10E")

        public static final int[] Fragment = {
            0x01010003, 0x010100d0, 0x010100d1
        };
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.760 -0400", hash_original_field = "D6DB09C01D75F746AA01083F1D9062CF", hash_generated_field = "098455E3F5E27FCE8DA656673901D4AC")

        public static final int Fragment_id = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.761 -0400", hash_original_field = "A33B7B30DCAC99F7A4FB05B52F7951A6", hash_generated_field = "7F5A6C3F76956AED5EB489CC7943D533")

        public static final int Fragment_name = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.761 -0400", hash_original_field = "3B400A218B69F84392B1EF9C22F60FEE", hash_generated_field = "0E428D78A37805ABD36D913832862F75")

        public static final int Fragment_tag = 2;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.761 -0400", hash_original_field = "6A6A7CB1D8D33E8620E0FFE4D265DFE3", hash_generated_field = "C05D29547F0FF3FBBC06D3D9747B009C")

    private static final String TAG = "FragmentActivity";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.761 -0400", hash_original_field = "3AEA24E6EBBC19672BB18FE79BC3A4AC", hash_generated_field = "1476D3F2166208C74AB619F6216B021B")

    static final String FRAGMENTS_TAG = "android:support:fragments";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.761 -0400", hash_original_field = "AF64DCC553B411957BAC29B7B8E4FB66", hash_generated_field = "9B5590C251929187BF81DBAD4FF353CC")

    private static final int HONEYCOMB = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.761 -0400", hash_original_field = "4881AEF4968D385D4F40809021AF975B", hash_generated_field = "3858BC703C64AB39E77D6A854C205B10")

    static final int MSG_REALLY_STOPPED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.761 -0400", hash_original_field = "F94DAE58A628ED7394EB6F4BDD116058", hash_generated_field = "85BC97DB38BAD7BD3198C330C85F8A73")

    static final int MSG_RESUME_PENDING = 2;
}

