package android.support.v4.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.423 -0400", hash_original_field = "9E9F5C9A2D303AC76B37DDF504A5EF92", hash_generated_field = "694874072698409F6608B46B5D5A3DE1")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.423 -0400", hash_original_field = "7887646F8CFE1A947D11EA6420A8B1DF", hash_generated_field = "271824B07358893C73D20BA1540862F9")

    boolean mCreated;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.423 -0400", hash_original_field = "9933B84C738DC45A33F44AE2EFCBD30F", hash_generated_field = "23D2434AD22548E124B62AB7739838E9")

    boolean mResumed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.423 -0400", hash_original_field = "33AF93F952A554412842C66D48683981", hash_generated_field = "C703FF92314B1EE9638F5EE77CD641D7")

    boolean mStopped;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.424 -0400", hash_original_field = "B1982C70B990A57E853D769AA7D47148", hash_generated_field = "747FF298A79A7C3192A681D678D25FE6")

    boolean mReallyStopped;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.424 -0400", hash_original_field = "DD825820C327E7F8D7347744CB13973E", hash_generated_field = "9B9EA230363F2EF227C5BE272DCC6838")

    boolean mRetaining;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.424 -0400", hash_original_field = "8D082D8869E8E3F959CB30710AFA9671", hash_generated_field = "DB8D4CEB8A7AAD8A9737A3EEEA202045")

    boolean mOptionsMenuInvalidated;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.424 -0400", hash_original_field = "E2FDF9701AF8C008E54F63B95BC75C79", hash_generated_field = "93A369593E1CC22C7DE8D4D5C675B065")

    boolean mCheckedForLoaderManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.424 -0400", hash_original_field = "7B94EB60C9B740E67FF099B167511F7B", hash_generated_field = "D357ECA56BF47F1751443279339D50DF")

    boolean mLoadersStarted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.424 -0400", hash_original_field = "C3FC98EBFA953A5BA9BDADB9981A948A", hash_generated_field = "12F53F261CD1A5D7A9E1650F04FB24A0")

    HashMap<String, LoaderManagerImpl> mAllLoaderManagers;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.424 -0400", hash_original_field = "780418B081227A51BFCB9EC0223B15ED", hash_generated_field = "6EE478DF5473556475C8D09C185A01BC")

    LoaderManagerImpl mLoaderManager;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.425 -0400", hash_original_method = "A8E156BB7E87BE56EEE389E385DAEBFA", hash_generated_method = "A8E156BB7E87BE56EEE389E385DAEBFA")
    public FragmentActivity ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.426 -0400", hash_original_method = "AE8D2F77597464B24506681CBB435A18", hash_generated_method = "99746B24FB7E3FB0708E0E02A4F62760")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(data.getTaint());
        addTaint(resultCode);
        addTaint(requestCode);
        mFragments.noteStateNotSaved();
        int index = requestCode>>16;
    if(index != 0)        
        {
            index--;
    if(mFragments.mActive == null || index < 0 || index >= mFragments.mActive.size())            
            {
                return;
            } //End block
            Fragment frag = mFragments.mActive.get(index);
    if(frag == null)            
            {
            } //End block
            else
            {
                frag.onActivityResult(requestCode&0xffff, resultCode, data);
            } //End block
            return;
        } //End block
        super.onActivityResult(requestCode, resultCode, data);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.426 -0400", hash_original_method = "6AE13C43A807A8F581EF7E482513BDAF", hash_generated_method = "2F6D57473D5D3CD0E2A1AE71D5A914F0")
    public void onBackPressed() {
        //DSFIXME:  CODE0009: Possible callback target function detected
    if(!mFragments.popBackStackImmediate())        
        {
            finish();
        } //End block
        // ---------- Original Method ----------
        //if (!mFragments.popBackStackImmediate()) {
            //finish();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.446 -0400", hash_original_method = "55FDC064636609C07EA6D352B59B7C90", hash_generated_method = "1C9A1A936CA05248F3562920B9C055A7")
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(newConfig.getTaint());
        super.onConfigurationChanged(newConfig);
        mFragments.dispatchConfigurationChanged(newConfig);
        // ---------- Original Method ----------
        //super.onConfigurationChanged(newConfig);
        //mFragments.dispatchConfigurationChanged(newConfig);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.446 -0400", hash_original_method = "C455F2D927ADC92D1A4791D782C4857A", hash_generated_method = "3E5962B6517860089A05D3369C6A064F")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(savedInstanceState.getTaint());
        mFragments.attachActivity(this, mContainer, null);
    if(getLayoutInflater().getFactory() == null)        
        {
            getLayoutInflater().setFactory(this);
        } //End block
        super.onCreate(savedInstanceState);
        NonConfigurationInstances nc = (NonConfigurationInstances)
                getLastNonConfigurationInstance();
    if(nc != null)        
        {
            mAllLoaderManagers = nc.loaders;
        } //End block
    if(savedInstanceState != null)        
        {
            Parcelable p = savedInstanceState.getParcelable(FRAGMENTS_TAG);
            mFragments.restoreAllState(p, nc != null ? nc.fragments : null);
        } //End block
        mFragments.dispatchCreate();
        // ---------- Original Method ----------
        //mFragments.attachActivity(this, mContainer, null);
        //if (getLayoutInflater().getFactory() == null) {
            //getLayoutInflater().setFactory(this);
        //}
        //super.onCreate(savedInstanceState);
        //NonConfigurationInstances nc = (NonConfigurationInstances)
                //getLastNonConfigurationInstance();
        //if (nc != null) {
            //mAllLoaderManagers = nc.loaders;
        //}
        //if (savedInstanceState != null) {
            //Parcelable p = savedInstanceState.getParcelable(FRAGMENTS_TAG);
            //mFragments.restoreAllState(p, nc != null ? nc.fragments : null);
        //}
        //mFragments.dispatchCreate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.447 -0400", hash_original_method = "7F7FAA4BD379FD5B7B024567C1869B85", hash_generated_method = "93DCA51F3FA52AD96B5BC2687566A453")
    @Override
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(menu.getTaint());
        addTaint(featureId);
    if(featureId == Window.FEATURE_OPTIONS_PANEL)        
        {
            boolean show = super.onCreatePanelMenu(featureId, menu);
            show |= mFragments.dispatchCreateOptionsMenu(menu, getMenuInflater());
    if(android.os.Build.VERSION.SDK_INT >= HONEYCOMB)            
            {
                boolean varA7DD12B1DAB17D25467B0B0A4C8D4A92_1778034094 = (show);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_952622093 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_952622093;
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_1549591289 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1991987743 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1991987743;
        } //End block
        boolean varC9826DF834BF55314F827931D2CC092D_115435561 = (super.onCreatePanelMenu(featureId, menu));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_790893763 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_790893763;
        // ---------- Original Method ----------
        //if (featureId == Window.FEATURE_OPTIONS_PANEL) {
            //boolean show = super.onCreatePanelMenu(featureId, menu);
            //show |= mFragments.dispatchCreateOptionsMenu(menu, getMenuInflater());
            //if (android.os.Build.VERSION.SDK_INT >= HONEYCOMB) {
                //return show;
            //}
            //return true;
        //}
        //return super.onCreatePanelMenu(featureId, menu);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.453 -0400", hash_original_method = "77C8CC4EE959FDB021D467966620FB0D", hash_generated_method = "0A25B879E900D9ABB71D61ECE6725320")
    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        addTaint(name.getTaint());
    if(!"fragment".equals(name))        
        {
View varC82C3AD1F32EBDFFB67CA822325243C0_1412952039 =             super.onCreateView(name, context, attrs);
            varC82C3AD1F32EBDFFB67CA822325243C0_1412952039.addTaint(taint);
            return varC82C3AD1F32EBDFFB67CA822325243C0_1412952039;
        } //End block
        String fname = attrs.getAttributeValue(null, "class");
        TypedArray a = context.obtainStyledAttributes(attrs, FragmentTag.Fragment);
    if(fname == null)        
        {
            fname = a.getString(FragmentTag.Fragment_name);
        } //End block
        int id = a.getResourceId(FragmentTag.Fragment_id, View.NO_ID);
        String tag = a.getString(FragmentTag.Fragment_tag);
        a.recycle();
        View parent = null;
        int containerId = parent != null ? parent.getId() : 0;
    if(containerId == View.NO_ID && id == View.NO_ID && tag == null)        
        {
            IllegalArgumentException var3AF5CF07E2261E5D16C72162F16D6095_748853402 = new IllegalArgumentException(attrs.getPositionDescription()
                    + ": Must specify unique android:id, android:tag, or have a parent with an id for " + fname);
            var3AF5CF07E2261E5D16C72162F16D6095_748853402.addTaint(taint);
            throw var3AF5CF07E2261E5D16C72162F16D6095_748853402;
        } //End block
        Fragment fragment = id != View.NO_ID ? mFragments.findFragmentById(id) : null;
    if(fragment == null && tag != null)        
        {
            fragment = mFragments.findFragmentByTag(tag);
        } //End block
    if(fragment == null && containerId != View.NO_ID)        
        {
            fragment = mFragments.findFragmentById(containerId);
        } //End block
    if(FragmentManagerImpl.DEBUG){ }    if(fragment == null)        
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
        } //End block
        else
    if(fragment.mInLayout)        
        {
            IllegalArgumentException var390F44C73191E7A7A889F24BBA1C65CC_1743906249 = new IllegalArgumentException(attrs.getPositionDescription()
                    + ": Duplicate id 0x" + Integer.toHexString(id)
                    + ", tag " + tag + ", or parent id 0x" + Integer.toHexString(containerId)
                    + " with another fragment for " + fname);
            var390F44C73191E7A7A889F24BBA1C65CC_1743906249.addTaint(taint);
            throw var390F44C73191E7A7A889F24BBA1C65CC_1743906249;
        } //End block
        else
        {
            fragment.mInLayout = true;
    if(!fragment.mRetaining)            
            {
                fragment.onInflate(this, attrs, fragment.mSavedFragmentState);
            } //End block
            mFragments.moveToState(fragment);
        } //End block
    if(fragment.mView == null)        
        {
            IllegalStateException varE32E018854A74B91F16273BC26BBEA6D_1770588665 = new IllegalStateException("Fragment " + fname
                    + " did not create a view.");
            varE32E018854A74B91F16273BC26BBEA6D_1770588665.addTaint(taint);
            throw varE32E018854A74B91F16273BC26BBEA6D_1770588665;
        } //End block
    if(id != 0)        
        {
            fragment.mView.setId(id);
        } //End block
    if(fragment.mView.getTag() == null)        
        {
            fragment.mView.setTag(tag);
        } //End block
View varCA045DD9191E9B0BACEF80A7EEFB5C7A_1372896286 =         fragment.mView;
        varCA045DD9191E9B0BACEF80A7EEFB5C7A_1372896286.addTaint(taint);
        return varCA045DD9191E9B0BACEF80A7EEFB5C7A_1372896286;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.453 -0400", hash_original_method = "81DE240BA78D06EF3CA4E4150F572C81", hash_generated_method = "060C5407A30F13E0FD85AEFCEDF74CCD")
    @Override
    protected void onDestroy() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onDestroy();
        doReallyStop(false);
        mFragments.dispatchDestroy();
    if(mLoaderManager != null)        
        {
            mLoaderManager.doDestroy();
        } //End block
        // ---------- Original Method ----------
        //super.onDestroy();
        //doReallyStop(false);
        //mFragments.dispatchDestroy();
        //if (mLoaderManager != null) {
            //mLoaderManager.doDestroy();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.454 -0400", hash_original_method = "9885A8D8E166C211280B71A198245DDA", hash_generated_method = "B58EED9C5DC5D595E25FEF31F25B696E")
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
    if(android.os.Build.VERSION.SDK_INT < 5 
                && keyCode == KeyEvent.KEYCODE_BACK
                && event.getRepeatCount() == 0)        
        {
            onBackPressed();
            boolean varB326B5062B2F0E69046810717534CB09_1090499705 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1016832075 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1016832075;
        } //End block
        boolean var947F0C250323B9F4475E02588E9A9740_497690715 = (super.onKeyDown(keyCode, event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1256072307 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1256072307;
        // ---------- Original Method ----------
        //if (android.os.Build.VERSION.SDK_INT < 5 
                //&& keyCode == KeyEvent.KEYCODE_BACK
                //&& event.getRepeatCount() == 0) {
            //onBackPressed();
            //return true;
        //}
        //return super.onKeyDown(keyCode, event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.454 -0400", hash_original_method = "5060399A61D97F30C880AACCBE3D1906", hash_generated_method = "179AD79FEEBC5260223D01A1DE47B9E6")
    @Override
    public void onLowMemory() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onLowMemory();
        mFragments.dispatchLowMemory();
        // ---------- Original Method ----------
        //super.onLowMemory();
        //mFragments.dispatchLowMemory();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.455 -0400", hash_original_method = "07B1A6CC471050623DC993725853B976", hash_generated_method = "36ACEFB9C5E0FA96B6839017ABB800DD")
    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(item.getTaint());
        addTaint(featureId);
    if(super.onMenuItemSelected(featureId, item))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_2078684282 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1679557113 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1679557113;
        } //End block
switch(featureId){
        case Window.FEATURE_OPTIONS_PANEL:
        boolean var35323F3748751EAB5CA55A38B5170D93_1865776334 = (mFragments.dispatchOptionsItemSelected(item));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_544926571 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_544926571;
        case Window.FEATURE_CONTEXT_MENU:
        boolean varE8A1D72471F976E54718B2BDEBD8D841_1892278665 = (mFragments.dispatchContextItemSelected(item));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1600387808 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1600387808;
        default:
        boolean var68934A3E9455FA72420237EB05902327_1528333725 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2123187411 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2123187411;
}
        // ---------- Original Method ----------
        //if (super.onMenuItemSelected(featureId, item)) {
            //return true;
        //}
        //switch (featureId) {
            //case Window.FEATURE_OPTIONS_PANEL:
                //return mFragments.dispatchOptionsItemSelected(item);
            //case Window.FEATURE_CONTEXT_MENU:
                //return mFragments.dispatchContextItemSelected(item);
            //default:
                //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.455 -0400", hash_original_method = "B1F57A749E35030E5CB8EAB506D19441", hash_generated_method = "79CD56A71D6249D03ABF50568EB2F958")
    @Override
    public void onPanelClosed(int featureId, Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(menu.getTaint());
        addTaint(featureId);
switch(featureId){
        case Window.FEATURE_OPTIONS_PANEL:
        mFragments.dispatchOptionsMenuClosed(menu);
        break;
}        super.onPanelClosed(featureId, menu);
        // ---------- Original Method ----------
        //switch (featureId) {
            //case Window.FEATURE_OPTIONS_PANEL:
                //mFragments.dispatchOptionsMenuClosed(menu);
                //break;
        //}
        //super.onPanelClosed(featureId, menu);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.455 -0400", hash_original_method = "EBBC480BA94BD3D79D683AB555C9F857", hash_generated_method = "F6203FA5F3497C63921C51E8F1DE18BC")
    @Override
    protected void onPause() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onPause();
        mResumed = false;
    if(mHandler.hasMessages(MSG_RESUME_PENDING))        
        {
            mHandler.removeMessages(MSG_RESUME_PENDING);
            onResumeFragments();
        } //End block
        mFragments.dispatchPause();
        // ---------- Original Method ----------
        //super.onPause();
        //mResumed = false;
        //if (mHandler.hasMessages(MSG_RESUME_PENDING)) {
            //mHandler.removeMessages(MSG_RESUME_PENDING);
            //onResumeFragments();
        //}
        //mFragments.dispatchPause();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.455 -0400", hash_original_method = "22DD6D11219C23D125AE29FC1331896B", hash_generated_method = "FA89657D88D3369A8E7951E23FEAAA18")
    @Override
    protected void onNewIntent(Intent intent) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(intent.getTaint());
        super.onNewIntent(intent);
        mFragments.noteStateNotSaved();
        // ---------- Original Method ----------
        //super.onNewIntent(intent);
        //mFragments.noteStateNotSaved();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.455 -0400", hash_original_method = "3FCB5D73B297020DDBEAF38F4A9C2458", hash_generated_method = "2304C8D4908051D209863854C6EC9090")
    @Override
    protected void onResume() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onResume();
        mHandler.sendEmptyMessage(MSG_RESUME_PENDING);
        mResumed = true;
        mFragments.execPendingActions();
        // ---------- Original Method ----------
        //super.onResume();
        //mHandler.sendEmptyMessage(MSG_RESUME_PENDING);
        //mResumed = true;
        //mFragments.execPendingActions();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.456 -0400", hash_original_method = "6B2BC88BC45E8448086501D1DCC5CA8F", hash_generated_method = "0EC7CE9DD1DFB4A4C28F312BCC044B23")
    @Override
    protected void onPostResume() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onPostResume();
        mHandler.removeMessages(MSG_RESUME_PENDING);
        onResumeFragments();
        mFragments.execPendingActions();
        // ---------- Original Method ----------
        //super.onPostResume();
        //mHandler.removeMessages(MSG_RESUME_PENDING);
        //onResumeFragments();
        //mFragments.execPendingActions();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.456 -0400", hash_original_method = "571F1484F02501E8599B33312B988FBD", hash_generated_method = "D3F8E7A7CF464221689B4E21DB27888D")
    protected void onResumeFragments() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mFragments.dispatchResume();
        // ---------- Original Method ----------
        //mFragments.dispatchResume();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.456 -0400", hash_original_method = "B669498AB621CA27E61E7D94F5D38091", hash_generated_method = "FDE3EB23EDE2E42D20F992F31CBE59B9")
    @Override
    public boolean onPreparePanel(int featureId, View view, Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(menu.getTaint());
        addTaint(view.getTaint());
        addTaint(featureId);
    if(featureId == Window.FEATURE_OPTIONS_PANEL && menu != null)        
        {
    if(mOptionsMenuInvalidated)            
            {
                mOptionsMenuInvalidated = false;
                menu.clear();
                onCreatePanelMenu(featureId, menu);
            } //End block
            boolean goforit = super.onPreparePanel(featureId, view, menu);
            goforit |= mFragments.dispatchPrepareOptionsMenu(menu);
            boolean var6F30EC4F22FBB3CC309B851E4D801F61_1308910866 = (goforit && menu.hasVisibleItems());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_252039124 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_252039124;
        } //End block
        boolean var954238BB3F7A1F486EB0778D82CD6736_107922062 = (super.onPreparePanel(featureId, view, menu));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_294214676 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_294214676;
        // ---------- Original Method ----------
        //if (featureId == Window.FEATURE_OPTIONS_PANEL && menu != null) {
            //if (mOptionsMenuInvalidated) {
                //mOptionsMenuInvalidated = false;
                //menu.clear();
                //onCreatePanelMenu(featureId, menu);
            //}
            //boolean goforit = super.onPreparePanel(featureId, view, menu);
            //goforit |= mFragments.dispatchPrepareOptionsMenu(menu);
            //return goforit && menu.hasVisibleItems();
        //}
        //return super.onPreparePanel(featureId, view, menu);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.456 -0400", hash_original_method = "26757680A48F135FACB25346DC79BC25", hash_generated_method = "FB31FFB6B0A762DB3CC62BC29FCAEF2F")
    @Override
    public final Object onRetainNonConfigurationInstance() {
        //DSFIXME:  CODE0009: Possible callback target function detected
    if(mStopped)        
        {
            doReallyStop(true);
        } //End block
        Object custom = onRetainCustomNonConfigurationInstance();
        ArrayList<Fragment> fragments = mFragments.retainNonConfig();
        boolean retainLoaders = false;
    if(mAllLoaderManagers != null)        
        {
            LoaderManagerImpl loaders[] = new LoaderManagerImpl[mAllLoaderManagers.size()];
            mAllLoaderManagers.values().toArray(loaders);
    if(loaders != null)            
            {
for(int i=0;i<loaders.length;i++)
                {
                    LoaderManagerImpl lm = loaders[i];
    if(lm.mRetaining)                    
                    {
                        retainLoaders = true;
                    } //End block
                    else
                    {
                        lm.doDestroy();
                        mAllLoaderManagers.remove(lm.mWho);
                    } //End block
                } //End block
            } //End block
        } //End block
    if(fragments == null && !retainLoaders && custom == null)        
        {
Object var540C13E9E156B687226421B24F2DF178_2042181423 =             null;
            var540C13E9E156B687226421B24F2DF178_2042181423.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2042181423;
        } //End block
        NonConfigurationInstances nci = new NonConfigurationInstances();
        nci.activity = null;
        nci.custom = custom;
        nci.children = null;
        nci.fragments = fragments;
        nci.loaders = mAllLoaderManagers;
Object var7D805FCD5771122135162F5B7459B31C_1750351118 =         nci;
        var7D805FCD5771122135162F5B7459B31C_1750351118.addTaint(taint);
        return var7D805FCD5771122135162F5B7459B31C_1750351118;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.457 -0400", hash_original_method = "C79CD565EF7D4DAA3E1BC7711F48F8E1", hash_generated_method = "32D322835D7FD87775E923B44703158E")
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(outState.getTaint());
        super.onSaveInstanceState(outState);
        Parcelable p = mFragments.saveAllState();
    if(p != null)        
        {
            outState.putParcelable(FRAGMENTS_TAG, p);
        } //End block
        // ---------- Original Method ----------
        //super.onSaveInstanceState(outState);
        //Parcelable p = mFragments.saveAllState();
        //if (p != null) {
            //outState.putParcelable(FRAGMENTS_TAG, p);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.457 -0400", hash_original_method = "F5C32F05E56A3FD61FD95DF89ACF56DE", hash_generated_method = "7D239A22EDC5B732DE87F86521AF6BF1")
    @Override
    protected void onStart() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onStart();
        mStopped = false;
        mReallyStopped = false;
        mHandler.removeMessages(MSG_REALLY_STOPPED);
    if(!mCreated)        
        {
            mCreated = true;
            mFragments.dispatchActivityCreated();
        } //End block
        mFragments.noteStateNotSaved();
        mFragments.execPendingActions();
    if(!mLoadersStarted)        
        {
            mLoadersStarted = true;
    if(mLoaderManager != null)            
            {
                mLoaderManager.doStart();
            } //End block
            else
    if(!mCheckedForLoaderManager)            
            {
                mLoaderManager = getLoaderManager(null, mLoadersStarted, false);
    if((mLoaderManager != null) && (!mLoaderManager.mStarted))                
                {
                    mLoaderManager.doStart();
                } //End block
            } //End block
            mCheckedForLoaderManager = true;
        } //End block
        mFragments.dispatchStart();
    if(mAllLoaderManagers != null)        
        {
            LoaderManagerImpl loaders[] = new LoaderManagerImpl[mAllLoaderManagers.size()];
            mAllLoaderManagers.values().toArray(loaders);
    if(loaders != null)            
            {
for(int i=0;i<loaders.length;i++)
                {
                    LoaderManagerImpl lm = loaders[i];
                    lm.finishRetain();
                    lm.doReportStart();
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.457 -0400", hash_original_method = "F60F215A385D287752751758F3F3D1D2", hash_generated_method = "D292BE290C6A31742F08B288962530FC")
    @Override
    protected void onStop() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onStop();
        mStopped = true;
        mHandler.sendEmptyMessage(MSG_REALLY_STOPPED);
        mFragments.dispatchStop();
        // ---------- Original Method ----------
        //super.onStop();
        //mStopped = true;
        //mHandler.sendEmptyMessage(MSG_REALLY_STOPPED);
        //mFragments.dispatchStop();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.457 -0400", hash_original_method = "F55A4C6A01F3D0AB15650B3080E9EF76", hash_generated_method = "D04B8ACD151922BAB60C32B925410865")
    public Object onRetainCustomNonConfigurationInstance() {
        //DSFIXME:  CODE0009: Possible callback target function detected
Object var540C13E9E156B687226421B24F2DF178_1244558848 =         null;
        var540C13E9E156B687226421B24F2DF178_1244558848.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1244558848;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.457 -0400", hash_original_method = "350BC71A71D255050EA53218D39061A7", hash_generated_method = "9DA0776E9FFAE0EFDA277690C98ED935")
    public Object getLastCustomNonConfigurationInstance() {
        NonConfigurationInstances nc = (NonConfigurationInstances)
                getLastNonConfigurationInstance();
Object var5B57144719C5DFE393244107A5A35FBA_96163493 =         nc != null ? nc.custom : null;
        var5B57144719C5DFE393244107A5A35FBA_96163493.addTaint(taint);
        return var5B57144719C5DFE393244107A5A35FBA_96163493;
        // ---------- Original Method ----------
        //NonConfigurationInstances nc = (NonConfigurationInstances)
                //getLastNonConfigurationInstance();
        //return nc != null ? nc.custom : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.458 -0400", hash_original_method = "9AD1865EB184E07C9164FA8858758524", hash_generated_method = "ECF552923146C377DB66E8F497E401AE")
    public void supportInvalidateOptionsMenu() {
    if(android.os.Build.VERSION.SDK_INT >= HONEYCOMB)        
        {
            ActivityCompatHoneycomb.invalidateOptionsMenu(this);
            return;
        } //End block
        mOptionsMenuInvalidated = true;
        // ---------- Original Method ----------
        //if (android.os.Build.VERSION.SDK_INT >= HONEYCOMB) {
            //ActivityCompatHoneycomb.invalidateOptionsMenu(this);
            //return;
        //}
        //mOptionsMenuInvalidated = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.458 -0400", hash_original_method = "793A438044EEB54318015A62231AC042", hash_generated_method = "AA94D62EA0B88634CC66EEC2A35935C8")
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        addTaint(args[0].getTaint());
        addTaint(writer.getTaint());
        addTaint(fd.getTaint());
        addTaint(prefix.getTaint());
    if(android.os.Build.VERSION.SDK_INT >= HONEYCOMB)        
        {
        } //End block
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
    if(mLoaderManager != null)        
        {
            writer.print(prefix);
            writer.print("Loader Manager ");
            writer.print(Integer.toHexString(System.identityHashCode(mLoaderManager)));
            writer.println(":");
            mLoaderManager.dump(prefix + "  ", fd, writer, args);
        } //End block
        mFragments.dump(prefix, fd, writer, args);
        writer.print(prefix);
        writer.println("View Hierarchy:");
        dumpViewHierarchy(prefix + "  ", writer, getWindow().getDecorView());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.459 -0400", hash_original_method = "0B7E3349E1F0303BBAAE6767112F50B2", hash_generated_method = "45A51C74069149FCF9F1548BE869ED30")
    private void dumpViewHierarchy(String prefix, PrintWriter writer, View view) {
        addTaint(view.getTaint());
        addTaint(writer.getTaint());
        addTaint(prefix.getTaint());
        writer.print(prefix);
    if(view == null)        
        {
            writer.println("null");
            return;
        } //End block
        writer.println(viewToString(view));
    if(!(view instanceof ViewGroup))        
        {
            return;
        } //End block
        ViewGroup grp = (ViewGroup)view;
        final int N = grp.getChildCount();
    if(N <= 0)        
        {
            return;
        } //End block
        prefix = prefix + "  ";
for(int i=0;i<N;i++)
        {
            dumpViewHierarchy(prefix, writer, grp.getChildAt(i));
        } //End block
        // ---------- Original Method ----------
        //writer.print(prefix);
        //if (view == null) {
            //writer.println("null");
            //return;
        //}
        //writer.println(viewToString(view));
        //if (!(view instanceof ViewGroup)) {
            //return;
        //}
        //ViewGroup grp = (ViewGroup)view;
        //final int N = grp.getChildCount();
        //if (N <= 0) {
            //return;
        //}
        //prefix = prefix + "  ";
        //for (int i=0; i<N; i++) {
            //dumpViewHierarchy(prefix, writer, grp.getChildAt(i));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.459 -0400", hash_original_method = "4C92BE36A72450E440D9BAAFB03D8955", hash_generated_method = "396E82C845013CD0203A115C35BB097B")
     void doReallyStop(boolean retaining) {
    if(!mReallyStopped)        
        {
            mReallyStopped = true;
            mRetaining = retaining;
            mHandler.removeMessages(MSG_REALLY_STOPPED);
            onReallyStop();
        } //End block
        // ---------- Original Method ----------
        //if (!mReallyStopped) {
            //mReallyStopped = true;
            //mRetaining = retaining;
            //mHandler.removeMessages(MSG_REALLY_STOPPED);
            //onReallyStop();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.459 -0400", hash_original_method = "E4D0A1E9799E4532B863FFE2D6A92452", hash_generated_method = "3881F683C297898F0D37C2901806C723")
     void onReallyStop() {
        //DSFIXME:  CODE0009: Possible callback target function detected
    if(mLoadersStarted)        
        {
            mLoadersStarted = false;
    if(mLoaderManager != null)            
            {
    if(!mRetaining)                
                {
                    mLoaderManager.doStop();
                } //End block
                else
                {
                    mLoaderManager.doRetain();
                } //End block
            } //End block
        } //End block
        mFragments.dispatchReallyStop();
        // ---------- Original Method ----------
        //if (mLoadersStarted) {
            //mLoadersStarted = false;
            //if (mLoaderManager != null) {
                //if (!mRetaining) {
                    //mLoaderManager.doStop();
                //} else {
                    //mLoaderManager.doRetain();
                //}
            //}
        //}
        //mFragments.dispatchReallyStop();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.460 -0400", hash_original_method = "28C2B4CF762BABC0F8C194FDD6A98E77", hash_generated_method = "7BA62512AFE4BD6BB2D807B17B09B3A6")
    public void onAttachFragment(Fragment fragment) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(fragment.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.460 -0400", hash_original_method = "A30369BEE359642894950823DFC915CE", hash_generated_method = "E158E8E1C9D3B1D5CFED70795D3D8C12")
    public FragmentManager getSupportFragmentManager() {
FragmentManager varB68713B43E6D3DE30B9A48FEA4C5FD0D_1733791102 =         mFragments;
        varB68713B43E6D3DE30B9A48FEA4C5FD0D_1733791102.addTaint(taint);
        return varB68713B43E6D3DE30B9A48FEA4C5FD0D_1733791102;
        // ---------- Original Method ----------
        //return mFragments;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.460 -0400", hash_original_method = "5BE63D387764C79BADD7265D6253130D", hash_generated_method = "9FCF3EB3A232A7812661BF3C74491F2F")
    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        addTaint(requestCode);
        addTaint(intent.getTaint());
    if(requestCode != -1 && (requestCode&0xffff0000) != 0)        
        {
            IllegalArgumentException varB7E61383B05BE5F7E102A4CA4C3E1B29_1275637741 = new IllegalArgumentException("Can only use lower 16 bits for requestCode");
            varB7E61383B05BE5F7E102A4CA4C3E1B29_1275637741.addTaint(taint);
            throw varB7E61383B05BE5F7E102A4CA4C3E1B29_1275637741;
        } //End block
        super.startActivityForResult(intent, requestCode);
        // ---------- Original Method ----------
        //if (requestCode != -1 && (requestCode&0xffff0000) != 0) {
            //throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        //}
        //super.startActivityForResult(intent, requestCode);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.460 -0400", hash_original_method = "62E7172DD8437600599EFB859FBECAC1", hash_generated_method = "1791E84EF1BB3D8677153EB9EADD99F6")
    public void startActivityFromFragment(Fragment fragment, Intent intent, 
            int requestCode) {
        addTaint(requestCode);
        addTaint(intent.getTaint());
        addTaint(fragment.getTaint());
    if(requestCode == -1)        
        {
            super.startActivityForResult(intent, -1);
            return;
        } //End block
    if((requestCode&0xffff0000) != 0)        
        {
            IllegalArgumentException varB7E61383B05BE5F7E102A4CA4C3E1B29_1769412088 = new IllegalArgumentException("Can only use lower 16 bits for requestCode");
            varB7E61383B05BE5F7E102A4CA4C3E1B29_1769412088.addTaint(taint);
            throw varB7E61383B05BE5F7E102A4CA4C3E1B29_1769412088;
        } //End block
        super.startActivityForResult(intent, ((fragment.mIndex+1)<<16) + (requestCode&0xffff));
        // ---------- Original Method ----------
        //if (requestCode == -1) {
            //super.startActivityForResult(intent, -1);
            //return;
        //}
        //if ((requestCode&0xffff0000) != 0) {
            //throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        //}
        //super.startActivityForResult(intent, ((fragment.mIndex+1)<<16) + (requestCode&0xffff));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.461 -0400", hash_original_method = "6D742EEA8D7FFBA4C7362E83B04A53C8", hash_generated_method = "2B55FF047860DFE6F9F9E7C26C4B5799")
     void invalidateSupportFragment(String who) {
        addTaint(who.getTaint());
    if(mAllLoaderManagers != null)        
        {
            LoaderManagerImpl lm = mAllLoaderManagers.get(who);
    if(lm != null && !lm.mRetaining)            
            {
                lm.doDestroy();
                mAllLoaderManagers.remove(who);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mAllLoaderManagers != null) {
            //LoaderManagerImpl lm = mAllLoaderManagers.get(who);
            //if (lm != null && !lm.mRetaining) {
                //lm.doDestroy();
                //mAllLoaderManagers.remove(who);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.461 -0400", hash_original_method = "7961401A3063345A714303BF5703D192", hash_generated_method = "9514578996C251A3F87CD629144EE7C8")
    public LoaderManager getSupportLoaderManager() {
    if(mLoaderManager != null)        
        {
LoaderManager var805CC3710F0829AF609E93E575C2DA90_109956256 =             mLoaderManager;
            var805CC3710F0829AF609E93E575C2DA90_109956256.addTaint(taint);
            return var805CC3710F0829AF609E93E575C2DA90_109956256;
        } //End block
        mCheckedForLoaderManager = true;
        mLoaderManager = getLoaderManager(null, mLoadersStarted, true);
LoaderManager var805CC3710F0829AF609E93E575C2DA90_933636705 =         mLoaderManager;
        var805CC3710F0829AF609E93E575C2DA90_933636705.addTaint(taint);
        return var805CC3710F0829AF609E93E575C2DA90_933636705;
        // ---------- Original Method ----------
        //if (mLoaderManager != null) {
            //return mLoaderManager;
        //}
        //mCheckedForLoaderManager = true;
        //mLoaderManager = getLoaderManager(null, mLoadersStarted, true);
        //return mLoaderManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.462 -0400", hash_original_method = "AFD15C82BB2F05228B3396C6CCD75AFC", hash_generated_method = "409ED5F174F050E8E47AA0C56D58C72C")
     LoaderManagerImpl getLoaderManager(String who, boolean started, boolean create) {
        addTaint(create);
        addTaint(started);
        addTaint(who.getTaint());
    if(mAllLoaderManagers == null)        
        {
            mAllLoaderManagers = new HashMap<String, LoaderManagerImpl>();
        } //End block
        LoaderManagerImpl lm = mAllLoaderManagers.get(who);
    if(lm == null)        
        {
    if(create)            
            {
                lm = new LoaderManagerImpl(who, this, started);
                mAllLoaderManagers.put(who, lm);
            } //End block
        } //End block
        else
        {
            lm.updateActivity(this);
        } //End block
LoaderManagerImpl varFAB97767FC97D5B051DD34588BADBEE3_1910829732 =         lm;
        varFAB97767FC97D5B051DD34588BADBEE3_1910829732.addTaint(taint);
        return varFAB97767FC97D5B051DD34588BADBEE3_1910829732;
        // ---------- Original Method ----------
        //if (mAllLoaderManagers == null) {
            //mAllLoaderManagers = new HashMap<String, LoaderManagerImpl>();
        //}
        //LoaderManagerImpl lm = mAllLoaderManagers.get(who);
        //if (lm == null) {
            //if (create) {
                //lm = new LoaderManagerImpl(who, this, started);
                //mAllLoaderManagers.put(who, lm);
            //}
        //} else {
            //lm.updateActivity(this);
        //}
        //return lm;
    }

    
    static final class NonConfigurationInstances {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.462 -0400", hash_original_field = "69A256025F66E4CE5D15C9DD7225D357", hash_generated_field = "AE7D68ABA75D09946A953E289939C500")

        Object activity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.462 -0400", hash_original_field = "8B9035807842A4E4DBE009F3F1478127", hash_generated_field = "6C7B2F12230CF06C59368C1EB75FD645")

        Object custom;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.462 -0400", hash_original_field = "268184C12DF027F536154D099D497B31", hash_generated_field = "39C55DEAC9D9B669F0F104569866C7D7")

        HashMap<String, Object> children;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.462 -0400", hash_original_field = "AD7BA86BB6B55B3BB2BB5F974A84CECF", hash_generated_field = "CB2FDAC93F3729E9B59C5F21C93A6FFF")

        ArrayList<Fragment> fragments;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.462 -0400", hash_original_field = "2AB8B63748D15E45B6CE4A33D435F369", hash_generated_field = "8C064BAF950EC1A7AEC35748813A8160")

        HashMap<String, LoaderManagerImpl> loaders;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.462 -0400", hash_original_method = "6ECBAFFBF9F9B3F6A966772230E87049", hash_generated_method = "6ECBAFFBF9F9B3F6A966772230E87049")
        public NonConfigurationInstances ()
        {
            //Synthesized constructor
        }


    }


    
    static class FragmentTag {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.462 -0400", hash_original_method = "97B15C4C04F651D57AC6A8ACA51C7A09", hash_generated_method = "97B15C4C04F651D57AC6A8ACA51C7A09")
        public FragmentTag ()
        {
            //Synthesized constructor
        }


        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.462 -0400", hash_original_field = "D42252BEFED75C32E548BE75BF5C4620", hash_generated_field = "3167F4E7249DC389B08D5F8E4C20C10E")

        public static final int[] Fragment = {
            0x01010003, 0x010100d0, 0x010100d1
        };
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.463 -0400", hash_original_field = "D6DB09C01D75F746AA01083F1D9062CF", hash_generated_field = "098455E3F5E27FCE8DA656673901D4AC")

        public static final int Fragment_id = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.463 -0400", hash_original_field = "A33B7B30DCAC99F7A4FB05B52F7951A6", hash_generated_field = "7F5A6C3F76956AED5EB489CC7943D533")

        public static final int Fragment_name = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.463 -0400", hash_original_field = "3B400A218B69F84392B1EF9C22F60FEE", hash_generated_field = "0E428D78A37805ABD36D913832862F75")

        public static final int Fragment_tag = 2;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.463 -0400", hash_original_field = "6A6A7CB1D8D33E8620E0FFE4D265DFE3", hash_generated_field = "C05D29547F0FF3FBBC06D3D9747B009C")

    private static final String TAG = "FragmentActivity";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.463 -0400", hash_original_field = "3AEA24E6EBBC19672BB18FE79BC3A4AC", hash_generated_field = "1476D3F2166208C74AB619F6216B021B")

    static final String FRAGMENTS_TAG = "android:support:fragments";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.463 -0400", hash_original_field = "AF64DCC553B411957BAC29B7B8E4FB66", hash_generated_field = "9B5590C251929187BF81DBAD4FF353CC")

    private static final int HONEYCOMB = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.463 -0400", hash_original_field = "4881AEF4968D385D4F40809021AF975B", hash_generated_field = "3858BC703C64AB39E77D6A854C205B10")

    static final int MSG_REALLY_STOPPED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.463 -0400", hash_original_field = "F94DAE58A628ED7394EB6F4BDD116058", hash_generated_field = "85BC97DB38BAD7BD3198C330C85F8A73")

    static final int MSG_RESUME_PENDING = 2;
}

