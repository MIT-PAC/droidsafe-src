package android.app;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;

import com.android.internal.policy.PolicyManager;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;
import droidsafe.helpers.DSTaintObject;

public class Activity extends ContextThemeWrapper
implements LayoutInflater.Factory2,
Window.Callback, KeyEvent.Callback,
OnCreateContextMenuListener, ComponentCallbacks2 {
	private DSTaintObject dsTaint = new DSTaintObject();
	final FragmentManagerImpl mFragments = new FragmentManagerImpl();
	private Window mWindow;
	private WindowManager mWindowManager;
	private Application mApplication;
	NonConfigurationInstances mLastNonConfigurationInstances;
	private static final String FRAGMENTS_TAG = "android:fragments";

	@Override
	public View onCreateView(String arg0, Context arg1, AttributeSet arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onConfigurationChanged(Configuration arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onLowMemory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTrimMemory(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onKeyDown(int arg0, KeyEvent arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onKeyLongPress(int arg0, KeyEvent arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onKeyMultiple(int arg0, int arg1, KeyEvent arg2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onKeyUp(int arg0, KeyEvent arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean dispatchGenericMotionEvent(MotionEvent arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean dispatchKeyShortcutEvent(KeyEvent arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean dispatchTrackballEvent(MotionEvent arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onActionModeFinished(ActionMode arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onActionModeStarted(ActionMode arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onAttachedToWindow() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onContentChanged() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onCreatePanelMenu(int arg0, Menu arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public View onCreatePanelView(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onDetachedFromWindow() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onMenuItemSelected(int arg0, MenuItem arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onMenuOpened(int arg0, Menu arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onPanelClosed(int arg0, Menu arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onPreparePanel(int arg0, View arg1, Menu arg2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onSearchRequested() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onWindowAttributesChanged(
			android.view.WindowManager.LayoutParams arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onWindowFocusChanged(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ActionMode onWindowStartingActionMode(Callback arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public View onCreateView(View arg0, String arg1, Context arg2,
			AttributeSet arg3) {
		// TODO Auto-generated method stub
		return null;
	}
	
	static final class NonConfigurationInstances {
        Object activity;
        HashMap<String, Object> children;
        ArrayList<Fragment> fragments;
        SparseArray<LoaderManagerImpl> loaders;
    }
	
	@DSModeled(DSC.SAFE)
	public Window getWindow() {
		/*
		 * There is no need to track taint up.  The mWindow object is instanced
		 * only through the attach methods.  It can not be directly assigned itself.
		 * If there is taint to be tracked, it will be as internal data and state
		 * inside of the Window object itself.
		 */
        return mWindow;
    }

	@DSModeled(DSC.SAFE)
	final void attach(Context context, ActivityThread aThread, Instrumentation instr, IBinder token,
            Application application, Intent intent, ActivityInfo info, CharSequence title, 
            Activity parent, String id, NonConfigurationInstances lastNonConfigurationInstances,
            Configuration config) {
        attach(context, aThread, instr, token, 0, application, intent, info, title, parent, id,
            lastNonConfigurationInstances, config);
    }
	
	@DSModeled(DSC.SAFE)
	final void attach(Context context, ActivityThread aThread,
            Instrumentation instr, IBinder token, int ident,
            Application application, Intent intent, ActivityInfo info,
            CharSequence title, Activity parent, String id,
            NonConfigurationInstances lastNonConfigurationInstances,
            Configuration config) {

        attachBaseContext(context);  //This method is a part of ContextThemeWrapper
        
        mFragments.attachActivity(this);
        
        mWindow = PolicyManager.makeNewWindow(this);
        mWindow.setCallback(this);
        mWindow.getLayoutInflater().setPrivateFactory(this);
        if (info.softInputMode != WindowManager.LayoutParams.SOFT_INPUT_STATE_UNSPECIFIED) {
            mWindow.setSoftInputMode(info.softInputMode);
        }
        if (info.uiOptions != 0) {
            mWindow.setUiOptions(info.uiOptions);
        }
        dsTaint.addTaint(Thread.currentThread());  //DSFIXME:  Unsure if tainting this is necessary, may want to remove this later if unnecessary
        //mUiThread = Thread.currentThread();
        
        dsTaint.addTaint(aThread);
        //mMainThread = aThread;
        dsTaint.addTaint(instr);
        //mInstrumentation = instr;
        dsTaint.addTaint(token);
        //mToken = token;
        dsTaint.addTaint(ident);
        //mIdent = ident;
        dsTaint.addTaint(application);
        //mApplication = application;
        dsTaint.addTaint(intent);
        //mIntent = intent;
        dsTaint.addTaint(intent.getComponent()); //DSFIXME:  Follow this down into intent to verify taint flows
        //mComponent = intent.getComponent();
        dsTaint.addTaint(info);
        //mActivityInfo = info;
        dsTaint.addTaint(title);
        //mTitle = title;
        dsTaint.addTaint(parent);
        //mParent = parent;
        dsTaint.addTaint(id);
        //mEmbeddedID = id;
        dsTaint.addTaint(lastNonConfigurationInstances);
        //mLastNonConfigurationInstances = lastNonConfigurationInstances;

        mWindow.setWindowManager(null, token, intent.getComponent().flattenToString(),
                (info.flags & ActivityInfo.FLAG_HARDWARE_ACCELERATED) != 0);
        mWindow.setContainer(parent.getWindow());
        mWindowManager = mWindow.getWindowManager();
        dsTaint.addTaint(config);
        //mCurrentConfig = config;
        /*
        mWindow.setWindowManager(null, mToken, mComponent.flattenToString(),
                (info.flags & ActivityInfo.FLAG_HARDWARE_ACCELERATED) != 0);
        if (mParent != null) {
            mWindow.setContainer(mParent.getWindow());
        }
        mWindowManager = mWindow.getWindowManager();
        mCurrentConfig = config;
        */
    }
	
	@DSModeled(DSC.SAFE)
	public void attach(Context context) {
		//This method is taken from BackupAgent.  This method flagged in the Sensor app.
        attachBaseContext(context);
    }
	
	@DSModeled()  //Go with SPEC for now, bundle could contain arbitrary data
	protected void onCreate(Bundle savedInstanceState) {
		/*
		 * DSFIXME:  This method may need a better model, since it is clearly
		 * restoring state from a bundle.  We definitely need to track the taint
		 * here
		 */
		
		Parcelable p = savedInstanceState.getParcelable(FRAGMENTS_TAG);
		mFragments.restoreAllState(p, mLastNonConfigurationInstances.fragments);
		/*
        if (mLastNonConfigurationInstances != null) {
            mAllLoaderManagers = mLastNonConfigurationInstances.loaders;
        }
        if (savedInstanceState != null) {
            Parcelable p = savedInstanceState.getParcelable(FRAGMENTS_TAG);
            mFragments.restoreAllState(p, mLastNonConfigurationInstances != null
                    ? mLastNonConfigurationInstances.fragments : null);
        }
        mFragments.dispatchCreate();
        getApplication().dispatchActivityCreated(this, savedInstanceState);
        mCalled = true;
        */
    }
	
	
	@DSModeled(DSC.SAFE)
	public Activity() {
		super();
	}
	
	@DSModeled(DSC.SAFE)
    protected void onResume() {
        // DSModeled: DSModel: GITI - For now, no modeling
        //getApplication().dispatchActivityResumed(this);
        //mCalled = true;
    }
	
	/*
	 private void initActionBar() {
	        Window window = getWindow();

	        // Initializing the window decor can change window feature flags.
	        // Make sure that we have the correct set before performing the test below.
	        window.getDecorView();

	        if (isChild() || !window.hasFeature(Window.FEATURE_ACTION_BAR) || mActionBar != null) {
	            return;
	        }
	        
	        mActionBar = new ActionBarImpl(this);
	    }
	 */
	
	@DSModeled(DSC.SAFE)
	public void setContentView(int layoutResID) {
		/*
		 * DSFIXME:  //We should really track the taint in the Window class, since 
		 * there aren't any getter methods at this level for that data.
		 */
        getWindow().setContentView(layoutResID);  
        //initActionBar();  //Looking at the code (listed above), I don't think this needs to be modeled
    }
	
	@DSModeled(DSC.SAFE)
    public void setContentView(View view) {
		/*
		 * DSFIXME:  //We should really track the taint in the Window class, since 
		 * there aren't any getter methods at this level for that data.
		 */
        getWindow().setContentView(view); //Pass it down, taint should probably be tracked in the Window class       
        //initActionBar();   //Looking at the code (listed above), I don't think this needs to be modeled
    }
	
	@DSModeled(DSC.SAFE)
	public View findViewById(int id) {
        return getWindow().findViewById(id);
    }
	
	@DSModeled(DSC.BAN)
    public void droidsafeOnResume() {
		//This method is called by droidsafe itself, and should NEVER be called by an app
    	onResume();
    }
	
	// ------------- Original MIT Models ------------- 
	@DSModeled(DSC.BAN)
    public void droidsafeOnStop() {
		//This method is called by droidsafe itself, and should NEVER be called by an app
    	onStop();
    }
	
	@DSModeled(DSC.BAN)
    public final Application getApplication() {
		return (Application)dsTaint.getTaint();  //This value is set on the attach method
        //return mApplication;
    }
	
	@DSModeled
    public void startActivityForResult(Intent intent, int requestCode) {
        /*
          The modeling required here will create the call to onActivityResult that 
          could be called as an effect of this call.  onActivityResult will have
          a new Intent.  We are modeling this Intent as a copy of the intent 
          passed to this method.  Of course, we cannot model the response intent
          perfectly, but grab as many fields as we can.
         */
        Intent resultIntent = new Intent();
        
        droidsafe.helpers.DSUtils.translateIntent(intent, resultIntent);
                
        this.onActivityResult(requestCode, /* just make this up */ -1,
                              resultIntent);
    }
	
	@DSModeled(DSC.SAFE)
	protected void onStop() {
		/*
        if (mActionBar != null) mActionBar.setShowHideAnimationEnabled(false);
        getApplication().dispatchActivityStopped(this);
        mCalled = true;
        */
    }
	
	@DSModeled(DSC.BAN) //called by dsruntime to perform the onCreate
	public final void performCreate(Bundle icicle) {  //Was package level
        onCreate(icicle);
        // No need to track the bool
        /*
        mVisibleFromClient = !mWindow.getWindowStyle().getBoolean(
                com.android.internal.R.styleable.Window_windowNoDisplay, false);
        */
        mFragments.dispatchActivityCreated();  //May do something under the hood, keep in for now   
    }
	
	@DSModeled(DSC.SAFE)
    protected void onActivityResult(int requestCode, int resultCode,
    Intent data) {
           //no modeling required
    }
}
