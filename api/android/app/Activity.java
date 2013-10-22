package android.app;

// Droidsafe Imports
import droidsafe.annotations.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import android.content.ComponentCallbacks2;
import android.content.ComponentName;
import android.content.Context;
import android.content.IIntentSender;
import android.content.Intent;
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.EventLog;
import android.util.Log;
import android.util.SparseArray;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;

import com.android.internal.app.ActionBarImpl;
import com.android.internal.policy.PolicyManager;





public class Activity extends ContextThemeWrapper implements LayoutInflater.Factory2, Window.Callback, KeyEvent.Callback, OnCreateContextMenuListener, ComponentCallbacks2 {
    private SparseArray<ManagedDialog> mManagedDialogs;
    private Instrumentation mInstrumentation;
    private IBinder mToken;
    private int mIdent;
    String mEmbeddedID;
    private Application mApplication;
    Intent mIntent;
    private ComponentName mComponent;
    ActivityInfo mActivityInfo;
    ActivityThread mMainThread;
    Activity mParent;
    boolean mCalled;
    boolean mCheckedForLoaderManager;
    boolean mLoadersStarted;
    boolean mResumed;
    private boolean mStopped;
    boolean mFinished;
    boolean mStartedActivity;
    boolean mTemporaryPause = false;
    boolean mChangingConfigurations = false;
    int mConfigChangeFlags;
    Configuration mCurrentConfig;
    private SearchManager mSearchManager;
    private MenuInflater mMenuInflater;
    NonConfigurationInstances mLastNonConfigurationInstances;
    private Window mWindow;
    private WindowManager mWindowManager;
    View mDecor = null;
    boolean mWindowAdded = false;
    boolean mVisibleFromServer = false;
    boolean mVisibleFromClient = true;
    ActionBarImpl mActionBar = null;
    private CharSequence mTitle;
    private int mTitleColor = 0;
    FragmentManagerImpl mFragments = new FragmentManagerImpl();
    SparseArray<LoaderManagerImpl> mAllLoaderManagers;
    LoaderManagerImpl mLoaderManager;
    private final ArrayList<ManagedCursor> mManagedCursors =
        new ArrayList<ManagedCursor>();
    int mResultCode = RESULT_CANCELED;
    Intent mResultData = null;
    private boolean mTitleReady = false;
    private int mDefaultKeyMode = DEFAULT_KEYS_DISABLE;
    private SpannableStringBuilder mDefaultKeySsb = null;
    private final Object mInstanceTracker = null;
    private Thread mUiThread;
    final Handler mHandler = new Handler();
    
    @DSModeled(DSC.SAFE)
	public Activity() {
		super();
		mWindow = PolicyManager.makeNewWindow((Context)this);
	}

    @DSModeled(DSC.SPEC)
    public Intent getIntent(){
		return mIntent;
		// Original method
		/*
		{
        return mIntent;
    }
		*/
	}

    
    @DSModeled(DSC.SPEC)
    public void setIntent(Intent newIntent){
		mIntent = newIntent;  //Preserved
		// Original method
		/*
		{
        mIntent = newIntent;
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
	public final Application getApplication(){
		return mApplication;
		// Original method
		/*
		{
        return mApplication;
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
    public final boolean isChild(){
		return getTaintBoolean();
		// Original method
		/*
		{
        return mParent != null;
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
    public final Activity getParent(){
		return mParent;
		// Original method
		/*
		{
        return mParent;
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
    public WindowManager getWindowManager(){
		return mWindowManager;
		// Original method
		/*
		{
        return mWindowManager;
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
	public Window getWindow(){
		return mWindow;
		// Original method
		/*
		{
        return mWindow;
    }
		*/
	}

    
    @DSModeled(DSC.SPEC)
    public LoaderManager getLoaderManager(){
		mLoaderManager = getLoaderManager(-1, mLoadersStarted, true);
		return mLoaderManager;
		// Original method
		/*
		{
        if (mLoaderManager != null) {
            return mLoaderManager;
        }
        mCheckedForLoaderManager = true;
        mLoaderManager = getLoaderManager(-1, mLoadersStarted, true);
        return mLoaderManager;
    }
		*/
	}

    
    @DSModeled(DSC.SPEC)
    LoaderManagerImpl getLoaderManager(int index, boolean started, boolean create){
		mAllLoaderManagers = new SparseArray<LoaderManagerImpl>();
		LoaderManagerImpl lm = mAllLoaderManagers.get(index);
		lm.updateActivity(this);
		return lm;
		// Original method
		/*
		{
        if (mAllLoaderManagers == null) {
            mAllLoaderManagers = new SparseArray<LoaderManagerImpl>();
        }
        LoaderManagerImpl lm = mAllLoaderManagers.get(index);
        if (lm == null) {
            if (create) {
                lm = new LoaderManagerImpl(this, started);
                mAllLoaderManagers.put(index, lm);
            }
        } else {
            lm.updateActivity(this);
        }
        return lm;
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
    public View getCurrentFocus(){
		return mWindow.getCurrentFocus();
		// Original method
		/*
		{
        return mWindow != null ? mWindow.getCurrentFocus() : null;
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
	protected void onCreate(Bundle savedInstanceState){
		mAllLoaderManagers = mLastNonConfigurationInstances.loaders;
		Parcelable p = savedInstanceState.getParcelable(FRAGMENTS_TAG);
		mFragments.restoreAllState(p, mLastNonConfigurationInstances.fragments);
		mFragments.dispatchCreate();
		getApplication().dispatchActivityCreated(this, savedInstanceState);
		// Original method
		/*
		{
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
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    final void performRestoreInstanceState(Bundle savedInstanceState){
		onRestoreInstanceState(savedInstanceState);
        restoreManagedDialogs(savedInstanceState);
		// Original method
		/*
		{
        onRestoreInstanceState(savedInstanceState);
        restoreManagedDialogs(savedInstanceState);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SPEC)
    protected void onRestoreInstanceState(Bundle savedInstanceState){
		Bundle windowState = savedInstanceState.getBundle(WINDOW_HIERARCHY_TAG); //DSFIXME:  Model method in bundle
		mWindow.restoreHierarchyState(windowState);
		// Original method
		/*
		{
        if (mWindow != null) {
            Bundle windowState = savedInstanceState.getBundle(WINDOW_HIERARCHY_TAG);
            if (windowState != null) {
                mWindow.restoreHierarchyState(windowState);
            }
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.BAN)
    private void restoreManagedDialogs(Bundle savedInstanceState){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    @DSModeled(DSC.BAN)
    private Dialog createDialog(Integer dialogId, Bundle state, Bundle args){
		final Dialog dialog = onCreateDialog(dialogId, args);
		dialog.dispatchOnCreate(state);
        return dialog;
		// Original method
		/*
		{
        final Dialog dialog = onCreateDialog(dialogId, args);
        if (dialog == null) {
            return null;
        }
        dialog.dispatchOnCreate(state);
        return dialog;
    }
		*/
	}

    
    @DSModeled(DSC.BAN)
    private static String savedDialogKeyFor(int key){
		// Original method
		/*
		{
        return SAVED_DIALOG_KEY_PREFIX + key;
    }
		*/
		return "";
	}

    
    @DSModeled(DSC.BAN)
    private static String savedDialogArgsKeyFor(int key){
		// Original method
		/*
		{
        return SAVED_DIALOG_ARGS_KEY_PREFIX + key;
    }
		*/
		return "";
	}

    
    @DSModeled(DSC.SPEC)
    protected void onPostCreate(Bundle savedInstanceState){
		onTitleChanged(getTitle(), getTitleColor());
		// Original method
		/*
		{
        if (!isChild()) {
            mTitleReady = true;
            onTitleChanged(getTitle(), getTitleColor());
        }
        mCalled = true;
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SPEC)
    protected void onStart(){
		mLoaderManager = getLoaderManager(-1, mLoadersStarted, false);
		mLoaderManager.doStart();
		getApplication().dispatchActivityStarted(this);
		// Original method
		/*
		{
        mCalled = true;
        if (!mLoadersStarted) {
            mLoadersStarted = true;
            if (mLoaderManager != null) {
                mLoaderManager.doStart();
            } else if (!mCheckedForLoaderManager) {
                mLoaderManager = getLoaderManager(-1, mLoadersStarted, false);
            }
            mCheckedForLoaderManager = true;
        }
        getApplication().dispatchActivityStarted(this);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    protected void onRestart(){
		// Original method
		/*
		{
        mCalled = true;
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
	protected void onResume(){
		getApplication().dispatchActivityResumed(this);
		// Original method
		/*
		{
        getApplication().dispatchActivityResumed(this);
        mCalled = true;
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SPEC)
    protected void onPostResume(){
		final Window win = getWindow();
		win.makeActive();
		mActionBar.setShowHideAnimationEnabled(true);
		// Original method
		/*
		{
        final Window win = getWindow();
        if (win != null) win.makeActive();
        if (mActionBar != null) mActionBar.setShowHideAnimationEnabled(true);
        mCalled = true;
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SPEC)
    protected void onNewIntent(Intent intent){
		// Original method
		/*
		{
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    final void performSaveInstanceState(Bundle outState){
		onSaveInstanceState(outState);
        saveManagedDialogs(outState);
		// Original method
		/*
		{
        onSaveInstanceState(outState);
        saveManagedDialogs(outState);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SPEC)
    protected void onSaveInstanceState(Bundle outState){
		outState.putBundle(WINDOW_HIERARCHY_TAG, mWindow.saveHierarchyState());
        Parcelable p = mFragments.saveAllState();
        outState.putParcelable(FRAGMENTS_TAG, p);
        getApplication().dispatchActivitySaveInstanceState(this, outState);
		// Original method
		/*
		{
        outState.putBundle(WINDOW_HIERARCHY_TAG, mWindow.saveHierarchyState());
        Parcelable p = mFragments.saveAllState();
        if (p != null) {
            outState.putParcelable(FRAGMENTS_TAG, p);
        }
        getApplication().dispatchActivitySaveInstanceState(this, outState);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.BAN)
    private void saveManagedDialogs(Bundle outState){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    protected void onPause(){
		getApplication().dispatchActivityPaused(this);
		// Original method
		/*
		{
        getApplication().dispatchActivityPaused(this);
        mCalled = true;
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    protected void onUserLeaveHint(){
		// Original method
		/*
		{
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public boolean onCreateThumbnail(Bitmap outBitmap, Canvas canvas){
		// Original method
		/*
		{
        return false;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    public CharSequence onCreateDescription(){
		// Original method
		/*
		{
        return null;
    }
		*/
		return null;
	}

    
    @DSModeled(DSC.SAFE)
	protected void onStop(){
		mActionBar.setShowHideAnimationEnabled(false);
		getApplication().dispatchActivityStopped(this);
		// Original method
		/*
		{
        if (mActionBar != null) mActionBar.setShowHideAnimationEnabled(false);
        getApplication().dispatchActivityStopped(this);
        mCalled = true;
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
	protected void onDestroy(){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public void onConfigurationChanged(Configuration newConfig){
		mFragments.dispatchConfigurationChanged(newConfig);
		mWindow.onConfigurationChanged(newConfig);
		mActionBar.onConfigurationChanged(newConfig);
		// Original method
		/*
		{
        mCalled = true;
        mFragments.dispatchConfigurationChanged(newConfig);
        if (mWindow != null) {
            mWindow.onConfigurationChanged(newConfig);
        }
        if (mActionBar != null) {
            mActionBar.onConfigurationChanged(newConfig);
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public int getChangingConfigurations(){
		return getTaintInt();
		// Original method
		/*
		{
        return mConfigChangeFlags;
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
    @Deprecated public Object getLastNonConfigurationInstance(){
		return mLastNonConfigurationInstances.activity;
		// Original method
		/*
		{
        return mLastNonConfigurationInstances != null
                ? mLastNonConfigurationInstances.activity : null;
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
    public Object onRetainNonConfigurationInstance(){
		// Original method
		/*
		{
        return null;
    }
		*/
		return null;
	}

    
    @DSModeled(DSC.SAFE)
    HashMap<String, Object> getLastNonConfigurationChildInstances(){
		return mLastNonConfigurationInstances.children;
		// Original method
		/*
		{
        return mLastNonConfigurationInstances != null
                ? mLastNonConfigurationInstances.children : null;
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
    HashMap<String,Object> onRetainNonConfigurationChildInstances(){
		// Original method
		/*
		{
        return null;
    }
		*/
		return null;
	}

    
    @DSModeled(DSC.SAFE)
    NonConfigurationInstances retainNonConfigurationInstances(){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return null;
	}

    
    @DSModeled(DSC.SPEC)
    public void onLowMemory(){
		mFragments.dispatchLowMemory();
		// Original method
		/*
		{
        mCalled = true;
        mFragments.dispatchLowMemory();
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
	public void onTrimMemory(int level){
		mFragments.dispatchTrimMemory(level);
		// Original method
		/*
		{
        mCalled = true;
        mFragments.dispatchTrimMemory(level);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
	public FragmentManager getFragmentManager(){
		if (mFragments == null)
			mFragments = new FragmentManagerImpl();
		return mFragments;
		// Original method
		/*
		{
        return mFragments;
    }
		*/
	}

    
    @DSModeled(DSC.SPEC)
    void invalidateFragmentIndex(int index){
		LoaderManagerImpl lm = mAllLoaderManagers.get(0);
		lm.doDestroy();
		mAllLoaderManagers.remove(0);
		// Original method
		/*
		{
        if (mAllLoaderManagers != null) {
            LoaderManagerImpl lm = mAllLoaderManagers.get(index);
            if (lm != null && !lm.mRetaining) {
                lm.doDestroy();
                mAllLoaderManagers.remove(index);
            }
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public void onAttachFragment(Fragment fragment){
		// Original method
		/*
		{
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    @Deprecated public final Cursor managedQuery(Uri uri, String[] projection, String selection,
            String sortOrder){
		Cursor c = getContentResolver().query(uri, projection, selection, null, sortOrder);
		startManagingCursor(c);
		return c;
		// Original method
		/*
		{
        Cursor c = getContentResolver().query(uri, projection, selection, null, sortOrder);
        if (c != null) {
            startManagingCursor(c);
        }
        return c;
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
    @Deprecated public final Cursor managedQuery(Uri uri, String[] projection, String selection,
            String[] selectionArgs, String sortOrder){
		Cursor c = getContentResolver().query(uri, projection, selection, selectionArgs, sortOrder);
		startManagingCursor(c);
		return c;
		// Original method
		/*
		{
        Cursor c = getContentResolver().query(uri, projection, selection, selectionArgs, sortOrder);
        if (c != null) {
            startManagingCursor(c);
        }
        return c;
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
    @Deprecated public void startManagingCursor(Cursor c){
		// Original method
		/*
		{
        synchronized (mManagedCursors) {
            mManagedCursors.add(new ManagedCursor(c));
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    @Deprecated public void stopManagingCursor(Cursor c){
		ManagedCursor mc = mManagedCursors.get(0);
		mManagedCursors.remove(0);
		// Original method
		/*
		{
        synchronized (mManagedCursors) {
            final int N = mManagedCursors.size();
            for (int i=0; i<N; i++) {
                ManagedCursor mc = mManagedCursors.get(i);
                if (mc.mCursor == c) {
                    mManagedCursors.remove(i);
                    break;
                }
            }
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.BAN)
    @Deprecated public void setPersistent(boolean isPersistent){
		// Original method
		/*
		{
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
	public View findViewById(int id){
		return getWindow().findViewById(id);
		// Original method
		/*
		{
        return getWindow().findViewById(id);
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
    public ActionBar getActionBar(){
		initActionBar();
        return mActionBar;
		// Original method
		/*
		{
        initActionBar();
        return mActionBar;
    }
		*/
	}

    
    @DSModeled(DSC.BAN)
	private void initActionBar(){
		Window window = getWindow();
		window.getDecorView();
		window.hasFeature(Window.FEATURE_ACTION_BAR);
		mActionBar = new ActionBarImpl(this);
		// Original method
		/*
		{
        Window window = getWindow();
        window.getDecorView();
        if (isChild() || !window.hasFeature(Window.FEATURE_ACTION_BAR) || mActionBar != null) {
            return;
        }
        mActionBar = new ActionBarImpl(this);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
	public void setContentView(int layoutResID){
		getWindow().setContentView(layoutResID);
        initActionBar();
		// Original method
		/*
		{
        getWindow().setContentView(layoutResID);
        initActionBar();
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
	public void setContentView(View view){
		getWindow().setContentView(view);
        initActionBar();
		// Original method
		/*
		{
        getWindow().setContentView(view);
        initActionBar();
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public void setContentView(View view, ViewGroup.LayoutParams params){
		getWindow().setContentView(view, params);
        initActionBar();
		// Original method
		/*
		{
        getWindow().setContentView(view, params);
        initActionBar();
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public void addContentView(View view, ViewGroup.LayoutParams params){
		getWindow().addContentView(view, params);
        initActionBar();
		// Original method
		/*
		{
        getWindow().addContentView(view, params);
        initActionBar();
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SPEC)
    public void setFinishOnTouchOutside(boolean finish){
		mWindow.setCloseOnTouchOutside(finish);
		// Original method
		/*
		{
        mWindow.setCloseOnTouchOutside(finish);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public final void setDefaultKeyMode(int mode){
		addTaint(mode);
		mDefaultKeySsb = new SpannableStringBuilder();
		Selection.setSelection(mDefaultKeySsb,0);
		// Original method
		/*
		{
        mDefaultKeyMode = mode;
        switch (mode) {
        case DEFAULT_KEYS_DISABLE:
        case DEFAULT_KEYS_SHORTCUT:
            mDefaultKeySsb = null;      
            break;
        case DEFAULT_KEYS_DIALER:
        case DEFAULT_KEYS_SEARCH_LOCAL:
        case DEFAULT_KEYS_SEARCH_GLOBAL:
            mDefaultKeySsb = new SpannableStringBuilder();
            Selection.setSelection(mDefaultKeySsb,0);
            break;
        default:
            throw new IllegalArgumentException();
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.BAN)
    public void droidsafeOnKeyEvents() {
        int action = getTaintInt();
        int code = getTaintInt();
        int repeatCount = getTaintInt();
        KeyEvent ev = new KeyEvent(action, code);
        onKeyDown(getTaintInt(), ev);
        onKeyUp(getTaintInt(), ev);
        onKeyLongPress(getTaintInt(), ev);
        onKeyMultiple(code, repeatCount, ev);
        
        Parcel parcel = Parcel.obtain();
        MotionEvent motionEv = MotionEvent.createFromParcelBody(parcel);
        onTouchEvent(motionEv);
        onTrackballEvent(motionEv);
        onGenericMotionEvent(motionEv);
    }

    @DSModeled(DSC.SAFE)
    public boolean onKeyDown(int keyCode, KeyEvent event){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    public boolean onKeyLongPress(int keyCode, KeyEvent event){
		// Original method
		/*
		{
        return false;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SPEC)
    public boolean onKeyUp(int keyCode, KeyEvent event){
		getApplicationInfo();
		onBackPressed();
		return (event.isCanceled() || event.isTracking()); //Probably just want to get a taint bool from inside event
		// Original method
		/*
		{
        if (getApplicationInfo().targetSdkVersion
                >= Build.VERSION_CODES.ECLAIR) {
            if (keyCode == KeyEvent.KEYCODE_BACK && event.isTracking()
                    && !event.isCanceled()) {
                onBackPressed();
                return true;
            }
        }
        return false;
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event){
		// Original method
		/*
		{
        return false;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SPEC)
    public void onBackPressed(){
		mFragments.popBackStackImmediate();
		finish();
		// Original method
		/*
		{
        if (!mFragments.popBackStackImmediate()) {
            finish();
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public boolean onKeyShortcut(int keyCode, KeyEvent event){
		// Original method
		/*
		{
        return false;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    public boolean onTouchEvent(MotionEvent event){
		finish();
		return mWindow.shouldCloseOnTouch(this, event); //Taint should bubble up
		// Original method
		/*
		{
        if (mWindow.shouldCloseOnTouch(this, event)) {
            finish();
            return true;
        }
        return false;
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
    public boolean onTrackballEvent(MotionEvent event){
		// Original method
		/*
		{
        return false;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    public boolean onGenericMotionEvent(MotionEvent event){
		// Original method
		/*
		{
        return false;
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SAFE)
    public void onUserInteraction(){
		// Original method
		/*
		{
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public void onWindowAttributesChanged(WindowManager.LayoutParams params){
		mDecor.getParent();
		getWindowManager().updateViewLayout(mDecor, params);
		// Original method
		/*
		{
        if (mParent == null) {
            View decor = mDecor;
            if (decor != null && decor.getParent() != null) {
                getWindowManager().updateViewLayout(decor, params);
            }
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public void onContentChanged(){
		// Original method
		/*
		{
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public void onWindowFocusChanged(boolean hasFocus){
		// Original method
		/*
		{
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public void onAttachedToWindow(){
		// Original method
		/*
		{
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public void onDetachedFromWindow(){
		// Original method
		/*
		{
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public boolean hasWindowFocus(){
		Window w = getWindow();
		View d = w.getDecorView();
		return d.hasWindowFocus();
		// Original method
		/*
		{
        Window w = getWindow();
        if (w != null) {
            View d = w.getDecorView();
            if (d != null) {
                return d.hasWindowFocus();
            }
        }
        return false;
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
    public boolean dispatchKeyEvent(KeyEvent event){
		onUserInteraction();
		Window win = getWindow();
		View decor = mDecor;
		decor = win.getDecorView();
		return (win.superDispatchKeyEvent(event) || event.dispatch(this, decor.getKeyDispatcherState(), this));
		// Original method
		/*
		{
        onUserInteraction();
        Window win = getWindow();
        if (win.superDispatchKeyEvent(event)) {
            return true;
        }
        View decor = mDecor;
        if (decor == null) decor = win.getDecorView();
        return event.dispatch(this, decor != null
                ? decor.getKeyDispatcherState() : null, this);
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
    public boolean dispatchKeyShortcutEvent(KeyEvent event){
		onUserInteraction();
		return (getWindow().superDispatchKeyShortcutEvent(event) || onKeyShortcut(event.getKeyCode(), event));
		// Original method
		/*
		{
        onUserInteraction();
        if (getWindow().superDispatchKeyShortcutEvent(event)) {
            return true;
        }
        return onKeyShortcut(event.getKeyCode(), event);
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
    public boolean dispatchTouchEvent(MotionEvent ev){
		onUserInteraction();
		return (getWindow().superDispatchTouchEvent(ev) || onTouchEvent(ev));
		// Original method
		/*
		{
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            onUserInteraction();
        }
        if (getWindow().superDispatchTouchEvent(ev)) {
            return true;
        }
        return onTouchEvent(ev);
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
    public boolean dispatchTrackballEvent(MotionEvent ev){
		onUserInteraction();
		return (getWindow().superDispatchTrackballEvent(ev) || onTrackballEvent(ev));
		// Original method
		/*
		{
        onUserInteraction();
        if (getWindow().superDispatchTrackballEvent(ev)) {
            return true;
        }
        return onTrackballEvent(ev);
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
    public boolean dispatchGenericMotionEvent(MotionEvent ev){
		onUserInteraction();
		return (getWindow().superDispatchGenericMotionEvent(ev) || onGenericMotionEvent(ev));
		// Original method
		/*
		{
        onUserInteraction();
        if (getWindow().superDispatchGenericMotionEvent(ev)) {
            return true;
        }
        return onGenericMotionEvent(ev);
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event){
		event.setClassName(getClass().getName());
        event.setPackageName(getPackageName());
        getWindow().getAttributes();
        event.setFullScreen(true);
        TextUtils.isEmpty("");
        event.getText().add(getTitle());
        return true;
		// Original method
		/*
		{
        event.setClassName(getClass().getName());
        event.setPackageName(getPackageName());
        LayoutParams params = getWindow().getAttributes();
        boolean isFullScreen = (params.width == LayoutParams.MATCH_PARENT) &&
            (params.height == LayoutParams.MATCH_PARENT);
        event.setFullScreen(isFullScreen);
        CharSequence title = getTitle();
        if (!TextUtils.isEmpty(title)) {
           event.getText().add(title);
        }
        return true;
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
    public View onCreatePanelView(int featureId){
		// Original method
		/*
		{
        return null;
    }
		*/
		return null;
	}

    
    @DSModeled(DSC.SAFE)
    public boolean onCreatePanelMenu(int featureId, Menu menu){
		return (onCreateOptionsMenu(menu) || mFragments.dispatchCreateOptionsMenu(menu, getMenuInflater()));
		// Original method
		/*
		{
        if (featureId == Window.FEATURE_OPTIONS_PANEL) {
            boolean show = onCreateOptionsMenu(menu);
            show |= mFragments.dispatchCreateOptionsMenu(menu, getMenuInflater());
            return show;
        }
        return false;
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
    public boolean onPreparePanel(int featureId, View view, Menu menu){
		return (onPrepareOptionsMenu(menu) || mFragments.dispatchPrepareOptionsMenu(menu) && menu.hasVisibleItems());
		// Original method
		/*
		{
        if (featureId == Window.FEATURE_OPTIONS_PANEL && menu != null) {
            boolean goforit = onPrepareOptionsMenu(menu);
            goforit |= mFragments.dispatchPrepareOptionsMenu(menu);
            return goforit && menu.hasVisibleItems();
        }
        return true;
    }
		*/
	}

    
    @DSModeled(DSC.SPEC)
    public boolean onMenuOpened(int featureId, Menu menu){
		initActionBar();
		mActionBar.dispatchMenuVisibilityChanged(true);
		Log.e(TAG, "Tried to open action bar menu with no action bar");
		return true;
		// Original method
		/*
		{
        if (featureId == Window.FEATURE_ACTION_BAR) {
            initActionBar();
            if (mActionBar != null) {
                mActionBar.dispatchMenuVisibilityChanged(true);
            } else {
                Log.e(TAG, "Tried to open action bar menu with no action bar");
            }
        }
        return true;
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
    public boolean onMenuItemSelected(int featureId, MenuItem item){
		EventLog.writeEvent(50000, 0, item.getTitleCondensed());
		return (onOptionsItemSelected(item) || mFragments.dispatchContextItemSelected(item));
		// Original method
		/*
		{
        switch (featureId) {
            case Window.FEATURE_OPTIONS_PANEL:
                EventLog.writeEvent(50000, 0, item.getTitleCondensed());
                if (onOptionsItemSelected(item)) {
                    return true;
                }
                return mFragments.dispatchOptionsItemSelected(item);
            case Window.FEATURE_CONTEXT_MENU:
                EventLog.writeEvent(50000, 1, item.getTitleCondensed());
                if (onContextItemSelected(item)) {
                    return true;
                }
                return mFragments.dispatchContextItemSelected(item);
            default:
                return false;
        }
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
    public void onPanelClosed(int featureId, Menu menu){
		mFragments.dispatchOptionsMenuClosed(menu);
		onOptionsMenuClosed(menu);
		initActionBar();
        mActionBar.dispatchMenuVisibilityChanged(false);
		// Original method
		/*
		{
        switch (featureId) {
            case Window.FEATURE_OPTIONS_PANEL:
                mFragments.dispatchOptionsMenuClosed(menu);
                onOptionsMenuClosed(menu);
                break;
            case Window.FEATURE_CONTEXT_MENU:
                onContextMenuClosed(menu);
                break;
            case Window.FEATURE_ACTION_BAR:
                initActionBar();
                mActionBar.dispatchMenuVisibilityChanged(false);
                break;
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SPEC)
    public void invalidateOptionsMenu(){
		mWindow.invalidatePanelMenu(Window.FEATURE_OPTIONS_PANEL);
		// Original method
		/*
		{
        mWindow.invalidatePanelMenu(Window.FEATURE_OPTIONS_PANEL);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SPEC)
    public boolean onCreateOptionsMenu(Menu menu){
		return mParent.onCreateOptionsMenu(menu);
		// Original method
		/*
		{
        if (mParent != null) {
            return mParent.onCreateOptionsMenu(menu);
        }
        return true;
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
    public boolean onPrepareOptionsMenu(Menu menu){
		return mParent.onPrepareOptionsMenu(menu);
		// Original method
		/*
		{
        if (mParent != null) {
            return mParent.onPrepareOptionsMenu(menu);
        }
        return true;
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
    public boolean onOptionsItemSelected(MenuItem item){
		return mParent.onOptionsItemSelected(item);
		// Original method
		/*
		{
        if (mParent != null) {
            return mParent.onOptionsItemSelected(item);
        }
        return false;
    }
		*/
	}

    
    @DSModeled(DSC.SPEC)
    public void onOptionsMenuClosed(Menu menu){
		mParent.onOptionsMenuClosed(menu);
		// Original method
		/*
		{
        if (mParent != null) {
            mParent.onOptionsMenuClosed(menu);
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public void openOptionsMenu(){
		mWindow.openPanel(Window.FEATURE_OPTIONS_PANEL, null);
		// Original method
		/*
		{
        mWindow.openPanel(Window.FEATURE_OPTIONS_PANEL, null);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public void closeOptionsMenu(){
		// Original method
		/*
		{
        mWindow.closePanel(Window.FEATURE_OPTIONS_PANEL);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo){
		// Original method
		/*
		{
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public void registerForContextMenu(View view){
		view.setOnCreateContextMenuListener(this);
		// Original method
		/*
		{
        view.setOnCreateContextMenuListener(this);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SPEC)
    public void unregisterForContextMenu(View view){
		view.setOnCreateContextMenuListener(null);
		// Original method
		/*
		{
        view.setOnCreateContextMenuListener(null);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public void openContextMenu(View view){
		view.showContextMenu();
		// Original method
		/*
		{
        view.showContextMenu();
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public void closeContextMenu(){
		mWindow.closePanel(Window.FEATURE_CONTEXT_MENU);
		// Original method
		/*
		{
        mWindow.closePanel(Window.FEATURE_CONTEXT_MENU);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SPEC)
    public boolean onContextItemSelected(MenuItem item){
		return mParent.onContextItemSelected(item);
		// Original method
		/*
		{
        if (mParent != null) {
            return mParent.onContextItemSelected(item);
        }
        return false;
    }
		*/
	}

    
    @DSModeled(DSC.SPEC)
    public void onContextMenuClosed(Menu menu){
		mParent.onContextMenuClosed(menu);
		// Original method
		/*
		{
        if (mParent != null) {
            mParent.onContextMenuClosed(menu);
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    @Deprecated protected Dialog onCreateDialog(int id){
		// Original method
		/*
		{
        return null;
    }
		*/
		return null;
	}

    
    @DSModeled(DSC.SAFE)
    @Deprecated protected Dialog onCreateDialog(int id, Bundle args){
		return onCreateDialog(id);
		// Original method
		/*
		{
        return onCreateDialog(id);
    }
		*/
	}

    
    @DSModeled(DSC.SPEC)
    @Deprecated protected void onPrepareDialog(int id, Dialog dialog){
		dialog.setOwnerActivity(this);
		// Original method
		/*
		{
        dialog.setOwnerActivity(this);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SPEC)
    @Deprecated protected void onPrepareDialog(int id, Dialog dialog, Bundle args){
		onPrepareDialog(id, dialog);
		// Original method
		/*
		{
        onPrepareDialog(id, dialog);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    @Deprecated public final void showDialog(int id){
		showDialog(id, null);
		// Original method
		/*
		{
        showDialog(id, null);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    @Deprecated public final boolean showDialog(int id, Bundle args){
		mManagedDialogs = new SparseArray<ManagedDialog>();
		ManagedDialog md = mManagedDialogs.get(id);
		md = new ManagedDialog();
		md.mDialog = createDialog(id, null, args);
		mManagedDialogs.put(id, md);
		md.mArgs = args;
		onPrepareDialog(id, md.mDialog, args);
		return true;
		// Original method
		/*
		{
        if (mManagedDialogs == null) {
            mManagedDialogs = new SparseArray<ManagedDialog>();
        }
        ManagedDialog md = mManagedDialogs.get(id);
        if (md == null) {
            md = new ManagedDialog();
            md.mDialog = createDialog(id, null, args);
            if (md.mDialog == null) {
                return false;
            }
            mManagedDialogs.put(id, md);
        }
        md.mArgs = args;
        onPrepareDialog(id, md.mDialog, args);
        md.mDialog.show();
        return true;
    }
		*/
	}

    
    @DSModeled(DSC.SPEC)
    @Deprecated public final void dismissDialog(int id){
		final ManagedDialog md = mManagedDialogs.get(id);
		md.mDialog.dismiss();
		throw missingDialog(id);
		// Original method
		/*
		{
        if (mManagedDialogs == null) {
            throw missingDialog(id);
        }
        final ManagedDialog md = mManagedDialogs.get(id);
        if (md == null) {
            throw missingDialog(id);
        }
        md.mDialog.dismiss();
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.BAN)
    private IllegalArgumentException missingDialog(int id){
		return new IllegalArgumentException("");
		// Original method
		/*
		{
        return new IllegalArgumentException("no dialog with id " + id + " was ever "
                + "shown via Activity#showDialog");
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
    @Deprecated public final void removeDialog(int id){
		final ManagedDialog md = mManagedDialogs.get(id);
		md.mDialog.dismiss();
        mManagedDialogs.remove(id);
		// Original method
		/*
		{
        if (mManagedDialogs != null) {
            final ManagedDialog md = mManagedDialogs.get(id);
            if (md != null) {
                md.mDialog.dismiss();
                mManagedDialogs.remove(id);
            }
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public boolean onSearchRequested(){
		startSearch(null, false, null, false); 
        return getTaintBoolean();
		// Original method
		/*
		{
        startSearch(null, false, null, false); 
        return true;
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
    public void startSearch(String initialQuery, boolean selectInitialQuery, 
            Bundle appSearchData, boolean globalSearch){
    	addTaint(initialQuery.getTaint());
    	addTaint(selectInitialQuery);
    	addTaint(appSearchData.getTaint());
    	addTaint(globalSearch);
		ensureSearchManager();
		mSearchManager.startSearch(initialQuery, selectInitialQuery, getComponentName(),
                appSearchData, globalSearch); 
		// Original method
		/*
		{
        ensureSearchManager();
        mSearchManager.startSearch(initialQuery, selectInitialQuery, getComponentName(),
                        appSearchData, globalSearch); 
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SPEC)
    public void triggerSearch(String query, Bundle appSearchData){
		ensureSearchManager();
	    mSearchManager.triggerSearch(query, getComponentName(), appSearchData);
		// Original method
		/*
		{
        ensureSearchManager();
        mSearchManager.triggerSearch(query, getComponentName(), appSearchData);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public void takeKeyEvents(boolean get){
		getWindow().takeKeyEvents(get);
		// Original method
		/*
		{
        getWindow().takeKeyEvents(get);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public final boolean requestWindowFeature(int featureId){
		return getWindow().requestFeature(featureId);
		// Original method
		/*
		{
        return getWindow().requestFeature(featureId);
    }
		*/
	}

    
    @DSModeled(DSC.SPEC)
    public final void setFeatureDrawableResource(int featureId, int resId){
		 getWindow().setFeatureDrawableResource(featureId, resId);
		// Original method
		/*
		{
        getWindow().setFeatureDrawableResource(featureId, resId);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SPEC)
    public final void setFeatureDrawableUri(int featureId, Uri uri){
		getWindow().setFeatureDrawableUri(featureId, uri);
		// Original method
		/*
		{
        getWindow().setFeatureDrawableUri(featureId, uri);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SPEC)
    public final void setFeatureDrawable(int featureId, Drawable drawable){
		getWindow().setFeatureDrawable(featureId, drawable);
		// Original method
		/*
		{
        getWindow().setFeatureDrawable(featureId, drawable);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SPEC)
    public final void setFeatureDrawableAlpha(int featureId, int alpha){
		getWindow().setFeatureDrawableAlpha(featureId, alpha);
		// Original method
		/*
		{
        getWindow().setFeatureDrawableAlpha(featureId, alpha);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SPEC)
    public LayoutInflater getLayoutInflater(){
		return getWindow().getLayoutInflater();
		// Original method
		/*
		{
        return getWindow().getLayoutInflater();
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
    public MenuInflater getMenuInflater(){
		initActionBar();
		mMenuInflater = new MenuInflater(mActionBar.getThemedContext()); //DSFIXME:  Look at underlying method to determine if this can be colapsed.
		mMenuInflater = new MenuInflater(this);
		return mMenuInflater;
		// Original method
		/*
		{
        if (mMenuInflater == null) {
            initActionBar();
            if (mActionBar != null) {
                mMenuInflater = new MenuInflater(mActionBar.getThemedContext());
            } else {
                mMenuInflater = new MenuInflater(this);
            }
        }
        return mMenuInflater;
    }
		*/
	}

    
    @DSModeled(DSC.SPEC)
    @Override protected void onApplyThemeResource(Resources.Theme theme, int resid,
            boolean first){
		super.onApplyThemeResource(theme, resid, first);
		theme.setTo(mParent.getTheme());
		theme.applyStyle(resid, false);
		// Original method
		/*
		{
        if (mParent == null) {
            super.onApplyThemeResource(theme, resid, first);
        } else {
            try {
                theme.setTo(mParent.getTheme());
            } catch (Exception e) {
            }
            theme.applyStyle(resid, false);
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SPEC)
	public void startActivityForResult(Intent intent, int requestCode){
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
		// Original method
		/*
		{
        if (mParent == null) {
            Instrumentation.ActivityResult ar =
                mInstrumentation.execStartActivity(
                    this, mMainThread.getApplicationThread(), mToken, this,
                    intent, requestCode);
            if (ar != null) {
                mMainThread.sendActivityResult(
                    mToken, mEmbeddedID, requestCode, ar.getResultCode(),
                    ar.getResultData());
            }
            if (requestCode >= 0) {
                mStartedActivity = true;
            }
        } else {
            mParent.startActivityFromChild(this, intent, requestCode);
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SPEC)
    public void startIntentSenderForResult(IntentSender intent, int requestCode,
            Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags){
		startIntentSenderForResultInner(intent, requestCode, fillInIntent,
                flagsMask, flagsValues, this);
		mParent.startIntentSenderFromChild(this, intent, requestCode,
                fillInIntent, flagsMask, flagsValues, extraFlags);
		// Original method
		/*
		{
        if (mParent == null) {
            startIntentSenderForResultInner(intent, requestCode, fillInIntent,
                    flagsMask, flagsValues, this);
        } else {
            mParent.startIntentSenderFromChild(this, intent, requestCode,
                    fillInIntent, flagsMask, flagsValues, extraFlags);
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.BAN)
    private void startIntentSenderForResultInner(IntentSender intent, int requestCode,
            Intent fillInIntent, int flagsMask, int flagsValues, Activity activity){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    @DSModeled(DSC.SPEC)
    @Override public void startActivity(Intent intent){
		startActivityForResult(intent, -1);
		// Original method
		/*
		{
        startActivityForResult(intent, -1);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    @Override public void startActivities(Intent[] intents){
		mInstrumentation.execStartActivities(this, mMainThread.getApplicationThread(),
                mToken, this, intents);
		// Original method
		/*
		{
        mInstrumentation.execStartActivities(this, mMainThread.getApplicationThread(),
                mToken, this, intents);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SPEC)
    public void startIntentSender(IntentSender intent,
            Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags){
		startIntentSenderForResult(intent, -1, fillInIntent, flagsMask,
                flagsValues, extraFlags);
		// Original method
		/*
		{
        startIntentSenderForResult(intent, -1, fillInIntent, flagsMask,
                flagsValues, extraFlags);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SPEC)
    public boolean startActivityIfNeeded(Intent intent, int requestCode){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return false;
	}

    
    @DSModeled(DSC.SPEC)
    public boolean startNextMatchingActivity(Intent intent){
		try {
            intent.setAllowFds(false);
            return ActivityManagerNative.getDefault()
                .startNextMatchingActivity(mToken, intent);
        } catch (RemoteException e) {
        }
		// Original method
		/*
		{
        if (mParent == null) {
            try {
                intent.setAllowFds(false);
                return ActivityManagerNative.getDefault()
                    .startNextMatchingActivity(mToken, intent);
            } catch (RemoteException e) {
            }
            return false;
        }
        throw new UnsupportedOperationException(
            "startNextMatchingActivity can only be called from a top-level activity");
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SPEC)
    public void startActivityFromChild(Activity child, Intent intent, 
            int requestCode){
		Instrumentation.ActivityResult ar =
	            mInstrumentation.execStartActivity(
	                this, mMainThread.getApplicationThread(), mToken, child,
	                intent, requestCode);
		mMainThread.sendActivityResult(
	                mToken, child.mEmbeddedID, requestCode,
	                ar.getResultCode(), ar.getResultData());
		// Original method
		/*
		{
        Instrumentation.ActivityResult ar =
            mInstrumentation.execStartActivity(
                this, mMainThread.getApplicationThread(), mToken, child,
                intent, requestCode);
        if (ar != null) {
            mMainThread.sendActivityResult(
                mToken, child.mEmbeddedID, requestCode,
                ar.getResultCode(), ar.getResultData());
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SPEC)
    public void startActivityFromFragment(Fragment fragment, Intent intent, 
            int requestCode){
	    /*
		Instrumentation.ActivityResult ar =
	            mInstrumentation.execStartActivity(
	                this, mMainThread.getApplicationThread(), mToken, fragment,
	                intent, requestCode);
		mMainThread.sendActivityResult(
                mToken, fragment.mWho, requestCode,
                ar.getResultCode(), ar.getResultData());
        */        
		// Original method
		/*
		{
        Instrumentation.ActivityResult ar =
            mInstrumentation.execStartActivity(
                this, mMainThread.getApplicationThread(), mToken, fragment,
                intent, requestCode);
        if (ar != null) {
            mMainThread.sendActivityResult(
                mToken, fragment.mWho, requestCode,
                ar.getResultCode(), ar.getResultData());
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SPEC)
    public void startIntentSenderFromChild(Activity child, IntentSender intent,
            int requestCode, Intent fillInIntent, int flagsMask, int flagsValues,
            int extraFlags){
		startIntentSenderForResultInner(intent, requestCode, fillInIntent,
                flagsMask, flagsValues, child);
		// Original method
		/*
		{
        startIntentSenderForResultInner(intent, requestCode, fillInIntent,
                flagsMask, flagsValues, child);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public void overridePendingTransition(int enterAnim, int exitAnim){
		try {
            ActivityManagerNative.getDefault().overridePendingTransition(
                    mToken, getPackageName(), enterAnim, exitAnim);
        } catch (RemoteException e) {
        }
		// Original method
		/*
		{
        try {
            ActivityManagerNative.getDefault().overridePendingTransition(
                    mToken, getPackageName(), enterAnim, exitAnim);
        } catch (RemoteException e) {
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public final void setResult(int resultCode){
		addTaint(resultCode);
		// Original method
		/*
		{
        synchronized (this) {
            mResultCode = resultCode;
            mResultData = null;
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SPEC)
    public final void setResult(int resultCode, Intent data){
		addTaint(resultCode);
		mResultData = data;
		// Original method
		/*
		{
        synchronized (this) {
            mResultCode = resultCode;
            mResultData = data;
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SPEC)
    public String getCallingPackage(){
		try {
            return ActivityManagerNative.getDefault().getCallingPackage(mToken);
        } catch (RemoteException e) {
            return null;
        }
		// Original method
		/*
		{
        try {
            return ActivityManagerNative.getDefault().getCallingPackage(mToken);
        } catch (RemoteException e) {
            return null;
        }
    }
		*/
	}

    
    @DSModeled(DSC.SPEC)
    public ComponentName getCallingActivity(){
		try {
            return ActivityManagerNative.getDefault().getCallingActivity(mToken);
        } catch (RemoteException e) {
            return null;
        }
		// Original method
		/*
		{
        try {
            return ActivityManagerNative.getDefault().getCallingActivity(mToken);
        } catch (RemoteException e) {
            return null;
        }
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
    public void setVisible(boolean visible){
		addTaint(visible);
		makeVisible();
		mDecor.setVisibility(View.INVISIBLE);
		// Original method
		/*
		{
        if (mVisibleFromClient != visible) {
            mVisibleFromClient = visible;
            if (mVisibleFromServer) {
                if (visible) makeVisible();
                else mDecor.setVisibility(View.INVISIBLE);
            }
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SPEC)
    void makeVisible(){
		ViewManager wm = getWindowManager();
        wm.addView(mDecor, getWindow().getAttributes());
		mDecor.setVisibility(View.VISIBLE);
		// Original method
		/*
		{
        if (!mWindowAdded) {
            ViewManager wm = getWindowManager();
            wm.addView(mDecor, getWindow().getAttributes());
            mWindowAdded = true;
        }
        mDecor.setVisibility(View.VISIBLE);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public boolean isFinishing(){
		return getTaintBoolean();
		// Original method
		/*
		{
        return mFinished;
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
    public boolean isChangingConfigurations(){
		return getTaintBoolean();
		// Original method
		/*
		{
        return mChangingConfigurations;
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
    public void recreate(){
		mMainThread.requestRelaunchActivity(mToken, null, null, 0, false, null, false);
		// Original method
		/*
		{
        if (mParent != null) {
            throw new IllegalStateException("Can only be called on top-level activity");
        }
        if (Looper.myLooper() != mMainThread.getLooper()) {
            throw new IllegalStateException("Must be called from main thread");
        }
        mMainThread.requestRelaunchActivity(mToken, null, null, 0, false, null, false);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SPEC)
    public void finish(){
		Log.v(TAG, "Finishing self: token=" + mToken);
		mResultData.setAllowFds(false);
		try {
		ActivityManagerNative.getDefault()
        .finishActivity(mToken, mResultCode, mResultData);
		} catch (RemoteException e) {
        }
		mParent.finishFromChild(this);
		// Original method
		/*
		{
        if (mParent == null) {
            int resultCode;
            Intent resultData;
            synchronized (this) {
                resultCode = mResultCode;
                resultData = mResultData;
            }
            if (false) Log.v(TAG, "Finishing self: token=" + mToken);
            try {
                if (resultData != null) {
                    resultData.setAllowFds(false);
                }
                if (ActivityManagerNative.getDefault()
                    .finishActivity(mToken, resultCode, resultData)) {
                    mFinished = true;
                }
            } catch (RemoteException e) {
            }
        } else {
            mParent.finishFromChild(this);
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SPEC)
    public void finishFromChild(Activity child){
		finish();
		// Original method
		/*
		{
        finish();
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SPEC)
    public void finishActivity(int requestCode){
		try {
            ActivityManagerNative.getDefault()
                .finishSubActivity(mToken, mEmbeddedID, requestCode);
        } catch (RemoteException e) {
        }
		mParent.finishActivityFromChild(this, requestCode);
		// Original method
		/*
		{
        if (mParent == null) {
            try {
                ActivityManagerNative.getDefault()
                    .finishSubActivity(mToken, mEmbeddedID, requestCode);
            } catch (RemoteException e) {
            }
        } else {
            mParent.finishActivityFromChild(this, requestCode);
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SPEC)
    public void finishActivityFromChild(Activity child, int requestCode){
		try {
            ActivityManagerNative.getDefault()
                .finishSubActivity(mToken, child.mEmbeddedID, requestCode);
        } catch (RemoteException e) {
        }
		// Original method
		/*
		{
        try {
            ActivityManagerNative.getDefault()
                .finishSubActivity(mToken, child.mEmbeddedID, requestCode);
        } catch (RemoteException e) {
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SPEC)
	protected void onActivityResult(int requestCode, int resultCode, Intent data){
		// Original method
		/*
		{
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SPEC)
    public PendingIntent createPendingResult(int requestCode, Intent data,
            int flags){
		String packageName = getPackageName();
		IIntentSender target = null;
		try {
            data.setAllowFds(false);
            target =
                ActivityManagerNative.getDefault().getIntentSender(
                        IActivityManager.INTENT_SENDER_ACTIVITY_RESULT, packageName,
                        mParent == null ? mToken : mParent.mToken,
                        mEmbeddedID, requestCode, new Intent[] { data }, null, flags);
		} catch (RemoteException e) {
        }
		return new PendingIntent(target);
		// Original method
		/*
		{
        String packageName = getPackageName();
        try {
            data.setAllowFds(false);
            IIntentSender target =
                ActivityManagerNative.getDefault().getIntentSender(
                        IActivityManager.INTENT_SENDER_ACTIVITY_RESULT, packageName,
                        mParent == null ? mToken : mParent.mToken,
                        mEmbeddedID, requestCode, new Intent[] { data }, null, flags);
            return target != null ? new PendingIntent(target) : null;
        } catch (RemoteException e) {
        }
        return null;
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
    public void setRequestedOrientation(int requestedOrientation){
		try {
            ActivityManagerNative.getDefault().setRequestedOrientation(
                    mToken, requestedOrientation);
        } catch (RemoteException e) {
        }
		mParent.setRequestedOrientation(requestedOrientation);
		// Original method
		/*
		{
        if (mParent == null) {
            try {
                ActivityManagerNative.getDefault().setRequestedOrientation(
                        mToken, requestedOrientation);
            } catch (RemoteException e) {
            }
        } else {
            mParent.setRequestedOrientation(requestedOrientation);
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public int getRequestedOrientation(){
		int retval = 0;
		try {
			retval = ActivityManagerNative.getDefault().getRequestedOrientation(mToken) + mParent.getRequestedOrientation();
		} catch (RemoteException e) {
        }
		return retval;
		// Original method
		/*
		{
        if (mParent == null) {
            try {
                return ActivityManagerNative.getDefault()
                        .getRequestedOrientation(mToken);
            } catch (RemoteException e) {
            }
        } else {
            return mParent.getRequestedOrientation();
        }
        return ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED;
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
    public int getTaskId(){
		try {
            return ActivityManagerNative.getDefault()
                .getTaskForActivity(mToken, false);
        } catch (RemoteException e) {
            return -1;
        }
		// Original method
		/*
		{
        try {
            return ActivityManagerNative.getDefault()
                .getTaskForActivity(mToken, false);
        } catch (RemoteException e) {
            return -1;
        }
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
    public boolean isTaskRoot(){
		try {
            return ActivityManagerNative.getDefault()
                .getTaskForActivity(mToken, true) >= 0;
        } catch (RemoteException e) {
            return false;
        }
		// Original method
		/*
		{
        try {
            return ActivityManagerNative.getDefault()
                .getTaskForActivity(mToken, true) >= 0;
        } catch (RemoteException e) {
            return false;
        }
    }
		*/
	}

    
    @DSModeled(DSC.SPEC)
    public boolean moveTaskToBack(boolean nonRoot){
		try {
            return ActivityManagerNative.getDefault().moveActivityTaskToBack(
                    mToken, nonRoot);
        } catch (RemoteException e) {
        }
        return false;
		// Original method
		/*
		{
        try {
            return ActivityManagerNative.getDefault().moveActivityTaskToBack(
                    mToken, nonRoot);
        } catch (RemoteException e) {
        }
        return false;
    }
		*/
	}

    
    @DSModeled(DSC.SPEC)
    public String getLocalClassName(){
		return mComponent.getClassName();
		// Original method
		/*
		{
        final String pkg = getPackageName();
        final String cls = mComponent.getClassName();
        int packageLen = pkg.length();
        if (!cls.startsWith(pkg) || cls.length() <= packageLen
                || cls.charAt(packageLen) != '.') {
            return cls;
        }
        return cls.substring(packageLen+1);
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
    public ComponentName getComponentName(){
		return mComponent;
		// Original method
		/*
		{
        return mComponent;
    }
		*/
	}

    
    @DSModeled(DSC.SPEC)
    public SharedPreferences getPreferences(int mode){
		return getSharedPreferences(getLocalClassName(), mode);
		// Original method
		/*
		{
        return getSharedPreferences(getLocalClassName(), mode);
    }
		*/
	}

    
    @DSModeled(DSC.BAN)
	private void ensureSearchManager(){
		mSearchManager = new SearchManager(this, null);
		// Original method
		/*
		{
        if (mSearchManager != null) {
            return;
        }
        mSearchManager = new SearchManager(this, null);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
	@Override public Object getSystemService(String name){
       
        if (DroidSafeAndroidRuntime.control || getBaseContext()==null) {
             IllegalStateException exception = new IllegalStateException(
                    "System services not available to Activities before onCreate()");
             exception.addTaint(getTaint());
        }

        if (name.equals(SEARCH_SERVICE)) {
            ensureSearchManager();
            mSearchManager.addTaint(getTaint());
            return mSearchManager;
        }
        
        if (name.equals(WINDOW_SERVICE)) {
            mWindowManager.addTaint(getTaint());
            return mWindowManager;
        }

		return super.getSystemService(name);
		// Original method
		/*
		{
        if (getBaseContext() == null) {
           
        }
        if (WINDOW_SERVICE.equals(name)) {
            return mWindowManager;
        } else if (SEARCH_SERVICE.equals(name)) {
            ensureSearchManager();
            return mSearchManager;
        }
        return super.getSystemService(name);
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
    public void setTitle(CharSequence title){
		mTitle = title;  //Preserved
		onTitleChanged(title, mTitleColor);
		mParent.onChildTitleChanged(this, title);
		// Original method
		/*
		{
        mTitle = title;
        onTitleChanged(title, mTitleColor);
        if (mParent != null) {
            mParent.onChildTitleChanged(this, title);
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public void setTitle(int titleId){
		setTitle(getText(titleId));
		// Original method
		/*
		{
        setTitle(getText(titleId));
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public void setTitleColor(int textColor){
		addTaint(textColor);
		onTitleChanged(mTitle, textColor);
		// Original method
		/*
		{
        mTitleColor = textColor;
        onTitleChanged(mTitle, textColor);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public final CharSequence getTitle(){
		return mTitle;
		// Original method
		/*
		{
        return mTitle;
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
    public final int getTitleColor(){
		return getTaintInt();
		// Original method
		/*
		{
        return mTitleColor;
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
    protected void onTitleChanged(CharSequence title, int color){
		final Window win = getWindow();
		win.setTitle(title);
		win.setTitleColor(color);
		// Original method
		/*
		{
        if (mTitleReady) {
            final Window win = getWindow();
            if (win != null) {
                win.setTitle(title);
                if (color != 0) {
                    win.setTitleColor(color);
                }
            }
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    protected void onChildTitleChanged(Activity childActivity, CharSequence title){
		// Original method
		/*
		{
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public final void setProgressBarVisibility(boolean visible){
		getWindow().setFeatureInt(Window.FEATURE_PROGRESS, Window.PROGRESS_VISIBILITY_ON);
		// Original method
		/*
		{
        getWindow().setFeatureInt(Window.FEATURE_PROGRESS, visible ? Window.PROGRESS_VISIBILITY_ON :
            Window.PROGRESS_VISIBILITY_OFF);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public final void setProgressBarIndeterminateVisibility(boolean visible){
		getWindow().setFeatureInt(Window.FEATURE_INDETERMINATE_PROGRESS, Window.PROGRESS_VISIBILITY_ON);
		// Original method
		/*
		{
        getWindow().setFeatureInt(Window.FEATURE_INDETERMINATE_PROGRESS,
                visible ? Window.PROGRESS_VISIBILITY_ON : Window.PROGRESS_VISIBILITY_OFF);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public final void setProgressBarIndeterminate(boolean indeterminate){
		getWindow().setFeatureInt(Window.FEATURE_PROGRESS, Window.PROGRESS_INDETERMINATE_ON);
		// Original method
		/*
		{
        getWindow().setFeatureInt(Window.FEATURE_PROGRESS,
                indeterminate ? Window.PROGRESS_INDETERMINATE_ON : Window.PROGRESS_INDETERMINATE_OFF);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SPEC)
    public final void setProgress(int progress){
		getWindow().setFeatureInt(Window.FEATURE_PROGRESS, Window.PROGRESS_START);
		// Original method
		/*
		{
        getWindow().setFeatureInt(Window.FEATURE_PROGRESS, progress + Window.PROGRESS_START);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public final void setSecondaryProgress(int secondaryProgress){
		getWindow().setFeatureInt(Window.FEATURE_PROGRESS, Window.PROGRESS_SECONDARY_START);
		// Original method
		/*
		{
        getWindow().setFeatureInt(Window.FEATURE_PROGRESS,
                secondaryProgress + Window.PROGRESS_SECONDARY_START);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public final void setVolumeControlStream(int streamType){
		getWindow().setVolumeControlStream(0);
		// Original method
		/*
		{
        getWindow().setVolumeControlStream(streamType);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SPEC)
    public final int getVolumeControlStream(){
		return getWindow().getVolumeControlStream();
		// Original method
		/*
		{
        return getWindow().getVolumeControlStream();
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
	public final void runOnUiThread(Runnable action){
		mHandler.post(action);
		action.run();
		// Original method
		/*
		{
        if (Thread.currentThread() != mUiThread) {
            mHandler.post(action);
        } else {
            action.run();
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public View onCreateView(String name, Context context, AttributeSet attrs){
		// Original method
		/*
		{
        return null;
    }
		*/
		return new View(context);
	}

    
    @DSModeled(DSC.SAFE)
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return new View(context);
	}

    
    @DSModeled(DSC.SPEC)
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    @DSModeled(DSC.BAN)
    public boolean isImmersive(){
		try {
            return ActivityManagerNative.getDefault().isImmersive(mToken); //Call down into 
        } catch (RemoteException e) {
            return false;
        }
		// Original method
		/*
		{
        try {
            return ActivityManagerNative.getDefault().isImmersive(mToken);
        } catch (RemoteException e) {
            return false;
        }
    }
		*/
	}

    
    @DSModeled(DSC.BAN)
    public void setImmersive(boolean i){
		try {
            ActivityManagerNative.getDefault().setImmersive(mToken, i);
        } catch (RemoteException e) {
        }
		// Original method
		/*
		{
        try {
            ActivityManagerNative.getDefault().setImmersive(mToken, i);
        } catch (RemoteException e) {
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SPEC)
    public ActionMode startActionMode(ActionMode.Callback callback){
		return mWindow.getDecorView().startActionMode(callback);
		// Original method
		/*
		{
        return mWindow.getDecorView().startActionMode(callback);
    }
		*/
	}

    
    @DSModeled(DSC.SPEC)
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback){
		initActionBar();
		return mActionBar.startActionMode(callback);
		// Original method
		/*
		{
        initActionBar();
        if (mActionBar != null) {
            return mActionBar.startActionMode(callback);
        }
        return null;
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
    public void onActionModeStarted(ActionMode mode){
		// Original method
		/*
		{
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public void onActionModeFinished(ActionMode mode){
		// Original method
		/*
		{
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    final void setParent(Activity parent){
		mParent = parent;  //Preserved
		// Original method
		/*
		{
        mParent = parent;
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SPEC)
	final void attach(Context context, ActivityThread aThread, Instrumentation instr, IBinder token,
            Application application, Intent intent, ActivityInfo info, CharSequence title, 
            Activity parent, String id, NonConfigurationInstances lastNonConfigurationInstances,
            Configuration config){
		attach(context, aThread, instr, token, 0, application, intent, info, title, parent, id,
	            lastNonConfigurationInstances, config);
		// Original method
		/*
		{
        attach(context, aThread, instr, token, 0, application, intent, info, title, parent, id,
            lastNonConfigurationInstances, config);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SPEC)
	final void attach(Context context, ActivityThread aThread,
            Instrumentation instr, IBinder token, int ident,
            Application application, Intent intent, ActivityInfo info,
            CharSequence title, Activity parent, String id,
            NonConfigurationInstances lastNonConfigurationInstances,
            Configuration config){
		mMainThread = aThread;  //Preserved
		mInstrumentation = instr;  //Preserved
		mToken = token;  //Preserved
		addTaint(ident);
		mApplication = application;  //Preserved
		mIntent = intent;  //Preserved
		mActivityInfo = info;  //Preserved
		mTitle = title;  //Preserved
		mParent = parent;  //Preserved
		addTaint(id.getTaint());
		mLastNonConfigurationInstances = lastNonConfigurationInstances;  //Preserved
		mCurrentConfig = config;  //Preserved
		attachBaseContext(context);
		mFragments.attachActivity(this);
		mWindow = PolicyManager.makeNewWindow(this);
        mWindow.setCallback(this);
        mWindow.getLayoutInflater().setPrivateFactory(this);
        mWindow.setSoftInputMode(info.softInputMode);
        mWindow.setWindowManager(null, token, intent.getComponent().flattenToString(),
                (info.flags & ActivityInfo.FLAG_HARDWARE_ACCELERATED) != 0);
        mWindow.setContainer(parent.getWindow());
        mWindowManager = mWindow.getWindowManager();
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    @DSModeled(DSC.SPEC)
    final IBinder getActivityToken(){
		return mParent.getActivityToken();
		// Original method
		/*
		{
        return mParent != null ? mParent.getActivityToken() : mToken;
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.919 -0400", hash_original_method = "DAB379B095765C858B51976FA2FCF6E4", hash_generated_method = "B85FC9CA5FD75BC2569BC7FE820DA2C6")
    final void performCreate(Bundle icicle) {
        addTaint(icicle.getTaint());
        mVisibleFromClient = !mWindow.getWindowStyle().getBoolean(
                com.android.internal.R.styleable.Window_windowNoDisplay, false);
        mFragments.dispatchActivityCreated();
        onCreate(icicle);
        onStart();
        // ---------- Original Method ----------
        //onCreate(icicle);
        //mVisibleFromClient = !mWindow.getWindowStyle().getBoolean(
                //com.android.internal.R.styleable.Window_windowNoDisplay, false);
        //mFragments.dispatchActivityCreated();
    }

    
    @DSModeled(DSC.SAFE)
    final void performStart(){
		mFragments.noteStateNotSaved();
		mFragments.execPendingActions();
		mInstrumentation.callActivityOnStart(this);
		mFragments.dispatchStart();
		LoaderManagerImpl lm = mAllLoaderManagers.valueAt(0);
        lm.finishRetain();
        lm.doReportStart();
		// Original method
		/*
		{
        mFragments.noteStateNotSaved();
        mCalled = false;
        mFragments.execPendingActions();
        mInstrumentation.callActivityOnStart(this);
        if (!mCalled) {
            throw new SuperNotCalledException(
                "Activity " + mComponent.toShortString() +
                " did not call through to super.onStart()");
        }
        mFragments.dispatchStart();
        if (mAllLoaderManagers != null) {
            for (int i=mAllLoaderManagers.size()-1; i>=0; i--) {
                LoaderManagerImpl lm = mAllLoaderManagers.valueAt(i);
                lm.finishRetain();
                lm.doReportStart();
            }
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    final void performRestart(){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    final void performResume(){
		performRestart();
		mFragments.execPendingActions();
		mInstrumentation.callActivityOnResume(this);
		mFragments.dispatchResume();
        mFragments.execPendingActions();
        onPostResume();
		// Original method
		/*
		{
        performRestart();
        mFragments.execPendingActions();
        mLastNonConfigurationInstances = null;
        mCalled = false;
        mInstrumentation.callActivityOnResume(this);
        if (!mCalled) {
            throw new SuperNotCalledException(
                "Activity " + mComponent.toShortString() +
                " did not call through to super.onResume()");
        }
        mCalled = false;
        mFragments.dispatchResume();
        mFragments.execPendingActions();
        onPostResume();
        if (!mCalled) {
            throw new SuperNotCalledException(
                "Activity " + mComponent.toShortString() +
                " did not call through to super.onPostResume()");
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    final void performPause(){
		mFragments.dispatchPause();
		onPause();
		getApplicationInfo();
		// Original method
		/*
		{
        mFragments.dispatchPause();
        mCalled = false;
        onPause();
        mResumed = false;
        if (!mCalled && getApplicationInfo().targetSdkVersion
                >= android.os.Build.VERSION_CODES.GINGERBREAD) {
            throw new SuperNotCalledException(
                    "Activity " + mComponent.toShortString() +
                    " did not call through to super.onPause()");
        }
        mResumed = false;
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    final void performUserLeaving(){
		onUserInteraction();
        onUserLeaveHint();
		// Original method
		/*
		{
        onUserInteraction();
        onUserLeaveHint();
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    final void performStop(){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    final void performDestroy(){
		mWindow.destroy();
        mFragments.dispatchDestroy();
        onDestroy();
        mLoaderManager.doDestroy();
		// Original method
		/*
		{
        mWindow.destroy();
        mFragments.dispatchDestroy();
        onDestroy();
        if (mLoaderManager != null) {
            mLoaderManager.doDestroy();
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.BAN)
    public final boolean isResumed(){
		return getTaintBoolean();
		// Original method
		/*
		{
        return mResumed;
    }
		*/
	}

    
    @DSModeled(DSC.SPEC)
    void dispatchActivityResult(String who, int requestCode, 
        int resultCode, Intent data){
		 Log.v(
		            TAG, "Dispatching result: who=" + who + ", reqCode=" + requestCode
		            + ", resCode=" + resultCode + ", data=" + data);
		mFragments.noteStateNotSaved();
		onActivityResult(requestCode, resultCode, data);
		Fragment frag = mFragments.findFragmentByWho(who);
		frag.onActivityResult(requestCode, resultCode, data);
		// Original method
		/*
		{
        if (false) Log.v(
            TAG, "Dispatching result: who=" + who + ", reqCode=" + requestCode
            + ", resCode=" + resultCode + ", data=" + data);
        mFragments.noteStateNotSaved();
        if (who == null) {
            onActivityResult(requestCode, resultCode, data);
        } else {
            Fragment frag = mFragments.findFragmentByWho(who);
            if (frag != null) {
                frag.onActivityResult(requestCode, resultCode, data);
            }
        }
    }
		*/
		//Return nothing
	}

    
    private static class ManagedDialog {
        Dialog mDialog;
        Bundle mArgs;
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.926 -0400", hash_original_method = "9DCA77B5D1234925DAEE8DA8399779D6", hash_generated_method = "9DCA77B5D1234925DAEE8DA8399779D6")
        public ManagedDialog ()
        {
            //Synthesized constructor
        }


    }


    
    static final class NonConfigurationInstances {
        Object activity;
        HashMap<String, Object> children;
        ArrayList<Fragment> fragments;
        SparseArray<LoaderManagerImpl> loaders;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.926 -0400", hash_original_method = "6ECBAFFBF9F9B3F6A966772230E87049", hash_generated_method = "6ECBAFFBF9F9B3F6A966772230E87049")
        public NonConfigurationInstances ()
        {
            //Synthesized constructor
        }


    }


    
    private static final class ManagedCursor {
        private final Cursor mCursor;
        private boolean mReleased;
        private boolean mUpdated;
        
        @DSModeled(DSC.SAFE)
        ManagedCursor(Cursor cursor){
			mCursor = cursor;
			/*
			mCursor = cursor;
			mReleased = false;
			mUpdated = false;
			*/
		}

        
    }


    
    private static final String TAG = "Activity";
    public static final int RESULT_CANCELED    = 0;
    public static final int RESULT_OK           = -1;
    public static final int RESULT_FIRST_USER   = 1;
    private static final String WINDOW_HIERARCHY_TAG = "android:viewHierarchyState";
    private static final String FRAGMENTS_TAG = "android:fragments";
    private static final String SAVED_DIALOG_IDS_KEY = "android:savedDialogIds";
    private static final String SAVED_DIALOGS_TAG = "android:savedDialogs";
    private static final String SAVED_DIALOG_KEY_PREFIX = "android:dialog_";
    private static final String SAVED_DIALOG_ARGS_KEY_PREFIX = "android:dialog_args_";
    protected static final int[] FOCUSED_STATE_SET = {com.android.internal.R.attr.state_focused};
    static public final int DEFAULT_KEYS_DISABLE = 0;
    static public final int DEFAULT_KEYS_DIALER = 1;
    static public final int DEFAULT_KEYS_SHORTCUT = 2;
    static public final int DEFAULT_KEYS_SEARCH_LOCAL = 3;
    static public final int DEFAULT_KEYS_SEARCH_GLOBAL = 4;
    // orphaned legacy method
    @DSModeled(DSC.BAN)
	public void droidsafeOnDestroy() {
		onDestroy();
	}
    
    // orphaned legacy method
    @DSModeled(DSC.BAN) //called by dsruntime to perform the onCreate
	public final void performCreate(Bundle icicle, Context context){
		this.attachBaseContext(context);
		onCreate(icicle);
		mVisibleFromClient = !mWindow.getWindowStyle().getBoolean(
                com.android.internal.R.styleable.Window_windowNoDisplay, false);
		mFragments.dispatchActivityCreated();
		// Original method
		/*
		{
        onCreate(icicle);
        mVisibleFromClient = !mWindow.getWindowStyle().getBoolean(
                com.android.internal.R.styleable.Window_windowNoDisplay, false);
        mFragments.dispatchActivityCreated();
    }
		*/
		//Return nothing
	}
    
    // orphaned legacy method
    @DSModeled(DSC.BAN)
    public void droidsafeOnResume() {
		//This method is called by droidsafe itself, and should NEVER be called by an app
    	onResume();
    }
    
    // orphaned legacy method
    @DSModeled(DSC.BAN)
    public void droidsafeOnStop() {
		//This method is called by droidsafe itself, and should NEVER be called by an app
    	onStop();
    }
    
    public static final int START_FLAG_RETRY = 0x0002;
    @DSModeled(DSC.BAN)
    public void setApplication(Application app) { 
            this.mApplication = app;
    }
    
    @DSModeled(DSC.BAN)
	public void droidsafeOnSavedInstanceState(Bundle b) {
    	this.onSaveInstanceState(b);
	}

    @DSModeled(DSC.BAN)
	public void droidsafeOnPause() {
    	this.onPause();
	}

    
}

