package android.support.v4.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.361 -0400", hash_original_field = "BD6DAC53FC9C157B350330EAEE248807", hash_generated_field = "DC2CF55207BC7FED1AD43C5D172320FA")

    Handler mHandler = new Handler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.361 -0400", hash_original_method = "ED8978699985B094E29E929E78E6359E", hash_generated_method = "168BA30ED6C33F2DDBC36D8B8B268C8C")
        @Override
        public void handleMessage(Message msg) {
            //Begin case MSG_REALLY_STOPPED 
            {
                doReallyStop(false);
            } //End block
            //End case MSG_REALLY_STOPPED 
            //Begin case MSG_RESUME_PENDING 
            onResumeFragments();
            //End case MSG_RESUME_PENDING 
            //Begin case MSG_RESUME_PENDING 
            mFragments.execPendingActions();
            //End case MSG_RESUME_PENDING 
            //Begin case default 
            super.handleMessage(msg);
            //End case default 
            addTaint(msg.getTaint());
            // ---------- Original Method ----------
            //switch (msg.what) {
                //case MSG_REALLY_STOPPED:
                    //if (mStopped) {
                        //doReallyStop(false);
                    //}
                    //break;
                //case MSG_RESUME_PENDING:
                    //onResumeFragments();
                    //mFragments.execPendingActions();
                    //break;
                //default:
                    //super.handleMessage(msg);
            //}
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.361 -0400", hash_original_field = "9E9F5C9A2D303AC76B37DDF504A5EF92", hash_generated_field = "770A646DB3FFD5D268F1207A9B6648B8")

    FragmentManagerImpl mFragments = new FragmentManagerImpl();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.362 -0400", hash_original_field = "BF98B02E33783F9E5A5CF09B5615CA83", hash_generated_field = "DFA7D5684D610DEAC86C944CFFFF291F")

    FragmentContainer mContainer = new FragmentContainer() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.362 -0400", hash_original_method = "EBF9138B1D5057AD1D48F1D0D3D08E54", hash_generated_method = "F47DFCB062DB7692F32ACB5D513481CB")
        @Override
        public View findViewById(int id) {
            View varB4EAC82CA7396A68D541C85D26508E83_984877964 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_984877964 = FragmentActivity.this.findViewById(id);
            addTaint(id);
            varB4EAC82CA7396A68D541C85D26508E83_984877964.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_984877964;
            // ---------- Original Method ----------
            //return FragmentActivity.this.findViewById(id);
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.363 -0400", hash_original_field = "7887646F8CFE1A947D11EA6420A8B1DF", hash_generated_field = "271824B07358893C73D20BA1540862F9")

    boolean mCreated;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.375 -0400", hash_original_field = "9933B84C738DC45A33F44AE2EFCBD30F", hash_generated_field = "23D2434AD22548E124B62AB7739838E9")

    boolean mResumed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.376 -0400", hash_original_field = "33AF93F952A554412842C66D48683981", hash_generated_field = "C703FF92314B1EE9638F5EE77CD641D7")

    boolean mStopped;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.376 -0400", hash_original_field = "B1982C70B990A57E853D769AA7D47148", hash_generated_field = "747FF298A79A7C3192A681D678D25FE6")

    boolean mReallyStopped;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.376 -0400", hash_original_field = "DD825820C327E7F8D7347744CB13973E", hash_generated_field = "9B9EA230363F2EF227C5BE272DCC6838")

    boolean mRetaining;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.376 -0400", hash_original_field = "8D082D8869E8E3F959CB30710AFA9671", hash_generated_field = "DB8D4CEB8A7AAD8A9737A3EEEA202045")

    boolean mOptionsMenuInvalidated;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.376 -0400", hash_original_field = "E2FDF9701AF8C008E54F63B95BC75C79", hash_generated_field = "93A369593E1CC22C7DE8D4D5C675B065")

    boolean mCheckedForLoaderManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.376 -0400", hash_original_field = "7B94EB60C9B740E67FF099B167511F7B", hash_generated_field = "D357ECA56BF47F1751443279339D50DF")

    boolean mLoadersStarted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.376 -0400", hash_original_field = "C3FC98EBFA953A5BA9BDADB9981A948A", hash_generated_field = "12F53F261CD1A5D7A9E1650F04FB24A0")

    HashMap<String, LoaderManagerImpl> mAllLoaderManagers;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.376 -0400", hash_original_field = "780418B081227A51BFCB9EC0223B15ED", hash_generated_field = "6EE478DF5473556475C8D09C185A01BC")

    LoaderManagerImpl mLoaderManager;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.376 -0400", hash_original_method = "A8E156BB7E87BE56EEE389E385DAEBFA", hash_generated_method = "A8E156BB7E87BE56EEE389E385DAEBFA")
    public FragmentActivity ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.378 -0400", hash_original_method = "AE8D2F77597464B24506681CBB435A18", hash_generated_method = "0F84B587715E2BA36B348AECC47AAB57")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mFragments.noteStateNotSaved();
        int index;
        index = requestCode>>16;
        {
            {
                boolean var56D5535283CDDB9CA6C9FE2754AC0112_225080150 = (mFragments.mActive == null || index < 0 || index >= mFragments.mActive.size());
            } //End collapsed parenthetic
            Fragment frag;
            frag = mFragments.mActive.get(index);
            {
                frag.onActivityResult(requestCode&0xffff, resultCode, data);
            } //End block
        } //End block
        super.onActivityResult(requestCode, resultCode, data);
        addTaint(requestCode);
        addTaint(resultCode);
        addTaint(data.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.383 -0400", hash_original_method = "6AE13C43A807A8F581EF7E482513BDAF", hash_generated_method = "F36ED36ECD49DB87458AE7A137F02C60")
    public void onBackPressed() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var5C240956F2A34791A06A0F4236D73061_2115129411 = (!mFragments.popBackStackImmediate());
            {
                finish();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!mFragments.popBackStackImmediate()) {
            //finish();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.384 -0400", hash_original_method = "55FDC064636609C07EA6D352B59B7C90", hash_generated_method = "744CE0EE1E79E428FC0F115815525478")
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onConfigurationChanged(newConfig);
        mFragments.dispatchConfigurationChanged(newConfig);
        addTaint(newConfig.getTaint());
        // ---------- Original Method ----------
        //super.onConfigurationChanged(newConfig);
        //mFragments.dispatchConfigurationChanged(newConfig);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.411 -0400", hash_original_method = "C455F2D927ADC92D1A4791D782C4857A", hash_generated_method = "8A701F853D3782E241B5CF8017B39135")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mFragments.attachActivity(this, mContainer, null);
        {
            boolean var897078D306EA59CF34AB5640B4C99A5E_247287186 = (getLayoutInflater().getFactory() == null);
            {
                getLayoutInflater().setFactory(this);
            } //End block
        } //End collapsed parenthetic
        super.onCreate(savedInstanceState);
        NonConfigurationInstances nc;
        nc = (NonConfigurationInstances)
                getLastNonConfigurationInstance();
        {
            mAllLoaderManagers = nc.loaders;
        } //End block
        {
            Parcelable p;
            p = savedInstanceState.getParcelable(FRAGMENTS_TAG);
            mFragments.restoreAllState(p, nc != null ? nc.fragments : null);
        } //End block
        mFragments.dispatchCreate();
        addTaint(savedInstanceState.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.412 -0400", hash_original_method = "7F7FAA4BD379FD5B7B024567C1869B85", hash_generated_method = "612C2262ABD2528538DCD3DC8C9E2FAB")
    @Override
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean show;
            show = super.onCreatePanelMenu(featureId, menu);
            show |= mFragments.dispatchCreateOptionsMenu(menu, getMenuInflater());
        } //End block
        boolean varBC0609E39141DD93BD051DCAB4D84F60_1166702903 = (super.onCreatePanelMenu(featureId, menu));
        addTaint(featureId);
        addTaint(menu.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1943905094 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1943905094;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.416 -0400", hash_original_method = "77C8CC4EE959FDB021D467966620FB0D", hash_generated_method = "8FC909BAB15DF14270A1C2BA315C8309")
    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        View varB4EAC82CA7396A68D541C85D26508E83_1100354882 = null; //Variable for return #1
        View varB4EAC82CA7396A68D541C85D26508E83_422341670 = null; //Variable for return #2
        {
            boolean var0F10F717A8824D895C9119EA392D7F2A_810540229 = (!"fragment".equals(name));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1100354882 = super.onCreateView(name, context, attrs);
            } //End block
        } //End collapsed parenthetic
        String fname;
        fname = attrs.getAttributeValue(null, "class");
        TypedArray a;
        a = context.obtainStyledAttributes(attrs, FragmentTag.Fragment);
        {
            fname = a.getString(FragmentTag.Fragment_name);
        } //End block
        int id;
        id = a.getResourceId(FragmentTag.Fragment_id, View.NO_ID);
        String tag;
        tag = a.getString(FragmentTag.Fragment_tag);
        a.recycle();
        View parent;
        parent = null;
        int containerId;
        containerId = parent.getId();
        containerId = 0;
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(attrs.getPositionDescription()
                    + ": Must specify unique android:id, android:tag, or have a parent with an id for " + fname);
        } //End block
        Fragment fragment;
        fragment = mFragments.findFragmentById(id);
        fragment = null;
        {
            fragment = mFragments.findFragmentByTag(tag);
        } //End block
        {
            fragment = mFragments.findFragmentById(containerId);
        } //End block
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
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(attrs.getPositionDescription()
                    + ": Duplicate id 0x" + Integer.toHexString(id)
                    + ", tag " + tag + ", or parent id 0x" + Integer.toHexString(containerId)
                    + " with another fragment for " + fname);
        } //End block
        {
            fragment.mInLayout = true;
            {
                fragment.onInflate(this, attrs, fragment.mSavedFragmentState);
            } //End block
            mFragments.moveToState(fragment);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Fragment " + fname
                    + " did not create a view.");
        } //End block
        {
            fragment.mView.setId(id);
        } //End block
        {
            boolean var28AAFB4908746F4035C573FBEA5D04E5_1672393318 = (fragment.mView.getTag() == null);
            {
                fragment.mView.setTag(tag);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_422341670 = fragment.mView;
        addTaint(name.getTaint());
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        View varA7E53CE21691AB073D9660D615818899_685955178; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_685955178 = varB4EAC82CA7396A68D541C85D26508E83_1100354882;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_685955178 = varB4EAC82CA7396A68D541C85D26508E83_422341670;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_685955178.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_685955178;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.439 -0400", hash_original_method = "81DE240BA78D06EF3CA4E4150F572C81", hash_generated_method = "3D5C30949FF5D5945B61A67D7F523035")
    @Override
    protected void onDestroy() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onDestroy();
        doReallyStop(false);
        mFragments.dispatchDestroy();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.440 -0400", hash_original_method = "9885A8D8E166C211280B71A198245DDA", hash_generated_method = "361B4A89B948F4BB0B6903A2E008E2B6")
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var589B130747FD36B61C3189894CAF6513_1216884902 = (android.os.Build.VERSION.SDK_INT < 5 
                && keyCode == KeyEvent.KEYCODE_BACK
                && event.getRepeatCount() == 0);
            {
                onBackPressed();
            } //End block
        } //End collapsed parenthetic
        boolean var8C6E6C19273FC56B5C56CC7DEF63ED7B_1545631190 = (super.onKeyDown(keyCode, event));
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_659526292 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_659526292;
        // ---------- Original Method ----------
        //if (android.os.Build.VERSION.SDK_INT < 5 
                //&& keyCode == KeyEvent.KEYCODE_BACK
                //&& event.getRepeatCount() == 0) {
            //onBackPressed();
            //return true;
        //}
        //return super.onKeyDown(keyCode, event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.440 -0400", hash_original_method = "5060399A61D97F30C880AACCBE3D1906", hash_generated_method = "179AD79FEEBC5260223D01A1DE47B9E6")
    @Override
    public void onLowMemory() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onLowMemory();
        mFragments.dispatchLowMemory();
        // ---------- Original Method ----------
        //super.onLowMemory();
        //mFragments.dispatchLowMemory();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.441 -0400", hash_original_method = "07B1A6CC471050623DC993725853B976", hash_generated_method = "1603940260C5B980DBBAC45B1F4E7AE3")
    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var80D23AF261DC2D76825947E935873830_12978472 = (super.onMenuItemSelected(featureId, item));
        } //End collapsed parenthetic
        //Begin case Window.FEATURE_OPTIONS_PANEL 
        boolean varE8A690D6428BE61C39A35A33EE497930_999549199 = (mFragments.dispatchOptionsItemSelected(item));
        //End case Window.FEATURE_OPTIONS_PANEL 
        //Begin case Window.FEATURE_CONTEXT_MENU 
        boolean var06F6B009CCB26CDE69B7F5C36D0D4DFE_861379877 = (mFragments.dispatchContextItemSelected(item));
        //End case Window.FEATURE_CONTEXT_MENU 
        addTaint(featureId);
        addTaint(item.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_753617965 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_753617965;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.441 -0400", hash_original_method = "B1F57A749E35030E5CB8EAB506D19441", hash_generated_method = "296AF4F9A3E80F9EAEE6B8CA53BAE5C3")
    @Override
    public void onPanelClosed(int featureId, Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        //Begin case Window.FEATURE_OPTIONS_PANEL 
        mFragments.dispatchOptionsMenuClosed(menu);
        //End case Window.FEATURE_OPTIONS_PANEL 
        super.onPanelClosed(featureId, menu);
        addTaint(featureId);
        addTaint(menu.getTaint());
        // ---------- Original Method ----------
        //switch (featureId) {
            //case Window.FEATURE_OPTIONS_PANEL:
                //mFragments.dispatchOptionsMenuClosed(menu);
                //break;
        //}
        //super.onPanelClosed(featureId, menu);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.443 -0400", hash_original_method = "EBBC480BA94BD3D79D683AB555C9F857", hash_generated_method = "11CABBFBC297582135F675226BD346A3")
    @Override
    protected void onPause() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onPause();
        mResumed = false;
        {
            boolean varE846E8054E55107C7ED185FA70E4116A_1889694037 = (mHandler.hasMessages(MSG_RESUME_PENDING));
            {
                mHandler.removeMessages(MSG_RESUME_PENDING);
                onResumeFragments();
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.443 -0400", hash_original_method = "22DD6D11219C23D125AE29FC1331896B", hash_generated_method = "69A15B9D6984917E5AC499991F82AA67")
    @Override
    protected void onNewIntent(Intent intent) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onNewIntent(intent);
        mFragments.noteStateNotSaved();
        addTaint(intent.getTaint());
        // ---------- Original Method ----------
        //super.onNewIntent(intent);
        //mFragments.noteStateNotSaved();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.443 -0400", hash_original_method = "3FCB5D73B297020DDBEAF38F4A9C2458", hash_generated_method = "2304C8D4908051D209863854C6EC9090")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.462 -0400", hash_original_method = "6B2BC88BC45E8448086501D1DCC5CA8F", hash_generated_method = "0EC7CE9DD1DFB4A4C28F312BCC044B23")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.462 -0400", hash_original_method = "571F1484F02501E8599B33312B988FBD", hash_generated_method = "D3F8E7A7CF464221689B4E21DB27888D")
    protected void onResumeFragments() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mFragments.dispatchResume();
        // ---------- Original Method ----------
        //mFragments.dispatchResume();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.463 -0400", hash_original_method = "B669498AB621CA27E61E7D94F5D38091", hash_generated_method = "76567EE9FE22A6068F3DE87835A89DD7")
    @Override
    public boolean onPreparePanel(int featureId, View view, Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            {
                mOptionsMenuInvalidated = false;
                menu.clear();
                onCreatePanelMenu(featureId, menu);
            } //End block
            boolean goforit;
            goforit = super.onPreparePanel(featureId, view, menu);
            goforit |= mFragments.dispatchPrepareOptionsMenu(menu);
            boolean var7116118DD297E6C08BE1AD40992AA51A_1795141224 = (goforit && menu.hasVisibleItems());
        } //End block
        boolean var6AD9E3BDA38B7F6D015ACC0F119D59E3_1922143302 = (super.onPreparePanel(featureId, view, menu));
        addTaint(featureId);
        addTaint(view.getTaint());
        addTaint(menu.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1112880595 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1112880595;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.484 -0400", hash_original_method = "26757680A48F135FACB25346DC79BC25", hash_generated_method = "AC4E474C691274D60E6FB13E7D46C8F2")
    @Override
    public final Object onRetainNonConfigurationInstance() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Object varB4EAC82CA7396A68D541C85D26508E83_1075752671 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_1662338585 = null; //Variable for return #2
        {
            doReallyStop(true);
        } //End block
        Object custom;
        custom = onRetainCustomNonConfigurationInstance();
        ArrayList<Fragment> fragments;
        fragments = mFragments.retainNonConfig();
        boolean retainLoaders;
        retainLoaders = false;
        {
            LoaderManagerImpl loaders[];
            loaders = new LoaderManagerImpl[mAllLoaderManagers.size()];
            mAllLoaderManagers.values().toArray(loaders);
            {
                {
                    int i;
                    i = 0;
                    {
                        LoaderManagerImpl lm;
                        lm = loaders[i];
                        {
                            retainLoaders = true;
                        } //End block
                        {
                            lm.doDestroy();
                            mAllLoaderManagers.remove(lm.mWho);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1075752671 = null;
        } //End block
        NonConfigurationInstances nci;
        nci = new NonConfigurationInstances();
        nci.activity = null;
        nci.custom = custom;
        nci.children = null;
        nci.fragments = fragments;
        nci.loaders = mAllLoaderManagers;
        varB4EAC82CA7396A68D541C85D26508E83_1662338585 = nci;
        Object varA7E53CE21691AB073D9660D615818899_538431994; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_538431994 = varB4EAC82CA7396A68D541C85D26508E83_1075752671;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_538431994 = varB4EAC82CA7396A68D541C85D26508E83_1662338585;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_538431994.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_538431994;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.486 -0400", hash_original_method = "C79CD565EF7D4DAA3E1BC7711F48F8E1", hash_generated_method = "06ADFCBA32F4EA4CE34622805D5CF675")
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onSaveInstanceState(outState);
        Parcelable p;
        p = mFragments.saveAllState();
        {
            outState.putParcelable(FRAGMENTS_TAG, p);
        } //End block
        addTaint(outState.getTaint());
        // ---------- Original Method ----------
        //super.onSaveInstanceState(outState);
        //Parcelable p = mFragments.saveAllState();
        //if (p != null) {
            //outState.putParcelable(FRAGMENTS_TAG, p);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.488 -0400", hash_original_method = "F5C32F05E56A3FD61FD95DF89ACF56DE", hash_generated_method = "E5FA13F7E785BA55266DF98A17696C53")
    @Override
    protected void onStart() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onStart();
        mStopped = false;
        mReallyStopped = false;
        mHandler.removeMessages(MSG_REALLY_STOPPED);
        {
            mCreated = true;
            mFragments.dispatchActivityCreated();
        } //End block
        mFragments.noteStateNotSaved();
        mFragments.execPendingActions();
        {
            mLoadersStarted = true;
            {
                mLoaderManager.doStart();
            } //End block
            {
                mLoaderManager = getLoaderManager(null, mLoadersStarted, false);
                {
                    mLoaderManager.doStart();
                } //End block
            } //End block
            mCheckedForLoaderManager = true;
        } //End block
        mFragments.dispatchStart();
        {
            LoaderManagerImpl loaders[];
            loaders = new LoaderManagerImpl[mAllLoaderManagers.size()];
            mAllLoaderManagers.values().toArray(loaders);
            {
                {
                    int i;
                    i = 0;
                    {
                        LoaderManagerImpl lm;
                        lm = loaders[i];
                        lm.finishRetain();
                        lm.doReportStart();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.513 -0400", hash_original_method = "F60F215A385D287752751758F3F3D1D2", hash_generated_method = "D292BE290C6A31742F08B288962530FC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.514 -0400", hash_original_method = "F55A4C6A01F3D0AB15650B3080E9EF76", hash_generated_method = "26A3692A89A0BBC13FEED649D517A979")
    public Object onRetainCustomNonConfigurationInstance() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Object varB4EAC82CA7396A68D541C85D26508E83_1398118085 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1398118085 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1398118085.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1398118085;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.515 -0400", hash_original_method = "350BC71A71D255050EA53218D39061A7", hash_generated_method = "14980010ABCBCF50749D0D42D024329C")
    public Object getLastCustomNonConfigurationInstance() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1882863954 = null; //Variable for return #1
        NonConfigurationInstances nc;
        nc = (NonConfigurationInstances)
                getLastNonConfigurationInstance();
        varB4EAC82CA7396A68D541C85D26508E83_1882863954 = nc != null ? nc.custom : null;
        varB4EAC82CA7396A68D541C85D26508E83_1882863954.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1882863954;
        // ---------- Original Method ----------
        //NonConfigurationInstances nc = (NonConfigurationInstances)
                //getLastNonConfigurationInstance();
        //return nc != null ? nc.custom : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.516 -0400", hash_original_method = "9AD1865EB184E07C9164FA8858758524", hash_generated_method = "419C889AF9E66DFB659C8D9136B8CAD2")
    public void supportInvalidateOptionsMenu() {
        {
            ActivityCompatHoneycomb.invalidateOptionsMenu(this);
        } //End block
        mOptionsMenuInvalidated = true;
        // ---------- Original Method ----------
        //if (android.os.Build.VERSION.SDK_INT >= HONEYCOMB) {
            //ActivityCompatHoneycomb.invalidateOptionsMenu(this);
            //return;
        //}
        //mOptionsMenuInvalidated = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.517 -0400", hash_original_method = "793A438044EEB54318015A62231AC042", hash_generated_method = "BFEEA7D78BE0FD77F4834F95EA19DE9D")
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        writer.print(prefix);
        writer.print("Local FragmentActivity ");
        writer.print(Integer.toHexString(System.identityHashCode(this)));
        writer.println(" State:");
        String innerPrefix;
        innerPrefix = prefix + "  ";
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
        } //End block
        mFragments.dump(prefix, fd, writer, args);
        writer.print(prefix);
        writer.println("View Hierarchy:");
        dumpViewHierarchy(prefix + "  ", writer, getWindow().getDecorView());
        addTaint(prefix.getTaint());
        addTaint(fd.getTaint());
        addTaint(writer.getTaint());
        addTaint(args[0].getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.534 -0400", hash_original_method = "0B7E3349E1F0303BBAAE6767112F50B2", hash_generated_method = "FC5C93C8720E85897637B4CA6D6CD1A8")
    private void dumpViewHierarchy(String prefix, PrintWriter writer, View view) {
        writer.print(prefix);
        {
            writer.println("null");
        } //End block
        writer.println(viewToString(view));
        ViewGroup grp;
        grp = (ViewGroup)view;
        int N;
        N = grp.getChildCount();
        prefix = prefix + "  ";
        {
            int i;
            i = 0;
            {
                dumpViewHierarchy(prefix, writer, grp.getChildAt(i));
            } //End block
        } //End collapsed parenthetic
        addTaint(prefix.getTaint());
        addTaint(writer.getTaint());
        addTaint(view.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.535 -0400", hash_original_method = "4C92BE36A72450E440D9BAAFB03D8955", hash_generated_method = "8C1ABF5890F17C22B4C073F21006326D")
     void doReallyStop(boolean retaining) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.540 -0400", hash_original_method = "E4D0A1E9799E4532B863FFE2D6A92452", hash_generated_method = "A4E2620AD94AA7F4E435DEB0C02AD08F")
     void onReallyStop() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            mLoadersStarted = false;
            {
                {
                    mLoaderManager.doStop();
                } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.555 -0400", hash_original_method = "28C2B4CF762BABC0F8C194FDD6A98E77", hash_generated_method = "7BA62512AFE4BD6BB2D807B17B09B3A6")
    public void onAttachFragment(Fragment fragment) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(fragment.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.555 -0400", hash_original_method = "A30369BEE359642894950823DFC915CE", hash_generated_method = "44F2830CA9B42A398D3A052F8923C12D")
    public FragmentManager getSupportFragmentManager() {
        FragmentManager varB4EAC82CA7396A68D541C85D26508E83_946405332 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_946405332 = mFragments;
        varB4EAC82CA7396A68D541C85D26508E83_946405332.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_946405332;
        // ---------- Original Method ----------
        //return mFragments;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.556 -0400", hash_original_method = "5BE63D387764C79BADD7265D6253130D", hash_generated_method = "814CA2E1FF69D2569FF984822D3F52AA")
    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        } //End block
        super.startActivityForResult(intent, requestCode);
        addTaint(intent.getTaint());
        addTaint(requestCode);
        // ---------- Original Method ----------
        //if (requestCode != -1 && (requestCode&0xffff0000) != 0) {
            //throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        //}
        //super.startActivityForResult(intent, requestCode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.556 -0400", hash_original_method = "62E7172DD8437600599EFB859FBECAC1", hash_generated_method = "FAFAF89BBF44057AB8C563B2900D79C8")
    public void startActivityFromFragment(Fragment fragment, Intent intent, 
            int requestCode) {
        {
            super.startActivityForResult(intent, -1);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        } //End block
        super.startActivityForResult(intent, ((fragment.mIndex+1)<<16) + (requestCode&0xffff));
        addTaint(fragment.getTaint());
        addTaint(intent.getTaint());
        addTaint(requestCode);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.557 -0400", hash_original_method = "6D742EEA8D7FFBA4C7362E83B04A53C8", hash_generated_method = "B539E015F2E61B112064BC1FDB675931")
     void invalidateSupportFragment(String who) {
        {
            LoaderManagerImpl lm;
            lm = mAllLoaderManagers.get(who);
            {
                lm.doDestroy();
                mAllLoaderManagers.remove(who);
            } //End block
        } //End block
        addTaint(who.getTaint());
        // ---------- Original Method ----------
        //if (mAllLoaderManagers != null) {
            //LoaderManagerImpl lm = mAllLoaderManagers.get(who);
            //if (lm != null && !lm.mRetaining) {
                //lm.doDestroy();
                //mAllLoaderManagers.remove(who);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.562 -0400", hash_original_method = "7961401A3063345A714303BF5703D192", hash_generated_method = "7D9000F0E0B0ACBC20CED0251677A2C6")
    public LoaderManager getSupportLoaderManager() {
        LoaderManager varB4EAC82CA7396A68D541C85D26508E83_467766915 = null; //Variable for return #1
        LoaderManager varB4EAC82CA7396A68D541C85D26508E83_932107983 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_467766915 = mLoaderManager;
        } //End block
        mCheckedForLoaderManager = true;
        mLoaderManager = getLoaderManager(null, mLoadersStarted, true);
        varB4EAC82CA7396A68D541C85D26508E83_932107983 = mLoaderManager;
        LoaderManager varA7E53CE21691AB073D9660D615818899_30554329; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_30554329 = varB4EAC82CA7396A68D541C85D26508E83_467766915;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_30554329 = varB4EAC82CA7396A68D541C85D26508E83_932107983;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_30554329.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_30554329;
        // ---------- Original Method ----------
        //if (mLoaderManager != null) {
            //return mLoaderManager;
        //}
        //mCheckedForLoaderManager = true;
        //mLoaderManager = getLoaderManager(null, mLoadersStarted, true);
        //return mLoaderManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.576 -0400", hash_original_method = "AFD15C82BB2F05228B3396C6CCD75AFC", hash_generated_method = "84E5EB73E53CD550613BC5C869A4E8C3")
     LoaderManagerImpl getLoaderManager(String who, boolean started, boolean create) {
        LoaderManagerImpl varB4EAC82CA7396A68D541C85D26508E83_1405558484 = null; //Variable for return #1
        {
            mAllLoaderManagers = new HashMap<String, LoaderManagerImpl>();
        } //End block
        LoaderManagerImpl lm;
        lm = mAllLoaderManagers.get(who);
        {
            {
                lm = new LoaderManagerImpl(who, this, started);
                mAllLoaderManagers.put(who, lm);
            } //End block
        } //End block
        {
            lm.updateActivity(this);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1405558484 = lm;
        addTaint(who.getTaint());
        addTaint(started);
        addTaint(create);
        varB4EAC82CA7396A68D541C85D26508E83_1405558484.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1405558484;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.577 -0400", hash_original_field = "69A256025F66E4CE5D15C9DD7225D357", hash_generated_field = "AE7D68ABA75D09946A953E289939C500")

        Object activity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.577 -0400", hash_original_field = "8B9035807842A4E4DBE009F3F1478127", hash_generated_field = "6C7B2F12230CF06C59368C1EB75FD645")

        Object custom;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.577 -0400", hash_original_field = "268184C12DF027F536154D099D497B31", hash_generated_field = "39C55DEAC9D9B669F0F104569866C7D7")

        HashMap<String, Object> children;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.577 -0400", hash_original_field = "AD7BA86BB6B55B3BB2BB5F974A84CECF", hash_generated_field = "CB2FDAC93F3729E9B59C5F21C93A6FFF")

        ArrayList<Fragment> fragments;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.577 -0400", hash_original_field = "2AB8B63748D15E45B6CE4A33D435F369", hash_generated_field = "8C064BAF950EC1A7AEC35748813A8160")

        HashMap<String, LoaderManagerImpl> loaders;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.577 -0400", hash_original_method = "6ECBAFFBF9F9B3F6A966772230E87049", hash_generated_method = "6ECBAFFBF9F9B3F6A966772230E87049")
        public NonConfigurationInstances ()
        {
            //Synthesized constructor
        }


    }


    
    static class FragmentTag {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.577 -0400", hash_original_method = "97B15C4C04F651D57AC6A8ACA51C7A09", hash_generated_method = "97B15C4C04F651D57AC6A8ACA51C7A09")
        public FragmentTag ()
        {
            //Synthesized constructor
        }


        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.577 -0400", hash_original_field = "D42252BEFED75C32E548BE75BF5C4620", hash_generated_field = "3167F4E7249DC389B08D5F8E4C20C10E")

        public static final int[] Fragment = {
            0x01010003, 0x010100d0, 0x010100d1
        };
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.577 -0400", hash_original_field = "D6DB09C01D75F746AA01083F1D9062CF", hash_generated_field = "098455E3F5E27FCE8DA656673901D4AC")

        public static final int Fragment_id = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.578 -0400", hash_original_field = "A33B7B30DCAC99F7A4FB05B52F7951A6", hash_generated_field = "7F5A6C3F76956AED5EB489CC7943D533")

        public static final int Fragment_name = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.578 -0400", hash_original_field = "3B400A218B69F84392B1EF9C22F60FEE", hash_generated_field = "0E428D78A37805ABD36D913832862F75")

        public static final int Fragment_tag = 2;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.578 -0400", hash_original_field = "6A6A7CB1D8D33E8620E0FFE4D265DFE3", hash_generated_field = "432CB40B3A377A231785FF795F1B0E2C")

    private static String TAG = "FragmentActivity";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.578 -0400", hash_original_field = "3AEA24E6EBBC19672BB18FE79BC3A4AC", hash_generated_field = "D6B1CA034DEDD07CA31DCCE969C27028")

    static String FRAGMENTS_TAG = "android:support:fragments";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.578 -0400", hash_original_field = "AF64DCC553B411957BAC29B7B8E4FB66", hash_generated_field = "A9D15B4EA6BC7BCFBE5130D6905931CF")

    private static int HONEYCOMB = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.578 -0400", hash_original_field = "4881AEF4968D385D4F40809021AF975B", hash_generated_field = "792793856BC7BFB2FC755FA992A81629")

    static int MSG_REALLY_STOPPED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.578 -0400", hash_original_field = "F94DAE58A628ED7394EB6F4BDD116058", hash_generated_field = "1CBC7A9BB609E52C9400E144F0946D33")

    static int MSG_RESUME_PENDING = 2;
}

