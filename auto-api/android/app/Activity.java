package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import com.android.internal.app.ActionBarImpl;
import com.android.internal.policy.PolicyManager;
import android.content.ComponentCallbacks2;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.CursorLoader;
import android.content.IIntentSender;
import android.content.Intent;
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.Resources.Theme;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.StrictMode;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.TextKeyListener;
import android.util.AttributeSet;
import android.util.EventLog;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
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
import android.view.WindowManagerImpl;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewManager;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.widget.AdapterView;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class Activity extends ContextThemeWrapper implements LayoutInflater.Factory2, Window.Callback, KeyEvent.Callback, OnCreateContextMenuListener, ComponentCallbacks2 {
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
    final FragmentManagerImpl mFragments = new FragmentManagerImpl();
    SparseArray<LoaderManagerImpl> mAllLoaderManagers;
    LoaderManagerImpl mLoaderManager;
    private final ArrayList<ManagedCursor> mManagedCursors =
        new ArrayList<ManagedCursor>();
    int mResultCode = RESULT_CANCELED;
    Intent mResultData = null;
    private boolean mTitleReady = false;
    private int mDefaultKeyMode = DEFAULT_KEYS_DISABLE;
    private SpannableStringBuilder mDefaultKeySsb = null;
    protected static final int[] FOCUSED_STATE_SET = {com.android.internal.R.attr.state_focused};
    private final Object mInstanceTracker = StrictMode.trackActivity(this);
    private Thread mUiThread;
    final Handler mHandler = new Handler();
    static public final int DEFAULT_KEYS_DISABLE = 0;
    static public final int DEFAULT_KEYS_DIALER = 1;
    static public final int DEFAULT_KEYS_SHORTCUT = 2;
    static public final int DEFAULT_KEYS_SEARCH_LOCAL = 3;
    static public final int DEFAULT_KEYS_SEARCH_GLOBAL = 4;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.719 -0400", hash_original_method = "AD027B7B58A4A2F151CC138FB7B23244", hash_generated_method = "0171D0DC4EAD6361737CA1E97CC20C8A")
    @DSModeled(DSC.SPEC)
    public Intent getIntent() {
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mIntent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.720 -0400", hash_original_method = "CC61C883982068788EAC9DED2F81C9E5", hash_generated_method = "4101B0307DE63B223A59B00674018BCB")
    @DSModeled(DSC.SPEC)
    public void setIntent(Intent newIntent) {
        dsTaint.addTaint(newIntent.dsTaint);
        // ---------- Original Method ----------
        //mIntent = newIntent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.720 -0400", hash_original_method = "510D23D8CF054FDAE1D1426C6A1A1500", hash_generated_method = "4914D71A145455A64F100875BAFE4A39")
    @DSModeled(DSC.SAFE)
    public final Application getApplication() {
        return (Application)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mApplication;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.721 -0400", hash_original_method = "68263BD6D248286EA0E84780534AEB0C", hash_generated_method = "C2436BCD9D337FB8E5BFA7B81BC61551")
    @DSModeled(DSC.SAFE)
    public final boolean isChild() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mParent != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.721 -0400", hash_original_method = "9F036901744EF56469FFF11C0925658F", hash_generated_method = "E69497F8A972DB3CB00A0E24723DCCEE")
    @DSModeled(DSC.SAFE)
    public final Activity getParent() {
        return (Activity)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mParent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.722 -0400", hash_original_method = "1DCFADD2C71F0E408EA049F81A8ACDED", hash_generated_method = "B98B893AE27DF665CF138083693D914D")
    @DSModeled(DSC.SAFE)
    public WindowManager getWindowManager() {
        return (WindowManager)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mWindowManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.722 -0400", hash_original_method = "51ACB33F24592F8ED3FAFF9D96DEAF2A", hash_generated_method = "BC1575FB97618B2B4FE295C2D61E7F0E")
    @DSModeled(DSC.SAFE)
    public Window getWindow() {
        return (Window)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mWindow;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.723 -0400", hash_original_method = "6FD2535D569839ECA0CF9FB0769EA7E8", hash_generated_method = "FB0DD5898C8B87938E0F1EAB08ADA4F0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LoaderManager getLoaderManager() {
        mCheckedForLoaderManager = true;
        mLoaderManager = getLoaderManager(-1, mLoadersStarted, true);
        return (LoaderManager)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mLoaderManager != null) {
            //return mLoaderManager;
        //}
        //mCheckedForLoaderManager = true;
        //mLoaderManager = getLoaderManager(-1, mLoadersStarted, true);
        //return mLoaderManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.723 -0400", hash_original_method = "08140101E6179DFA80CB04A3C57AF21B", hash_generated_method = "B9A72302C6D0901C41678E717BE3DABB")
    @DSModeled(DSC.SAFE)
     LoaderManagerImpl getLoaderManager(int index, boolean started, boolean create) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(started);
        dsTaint.addTaint(create);
        {
            mAllLoaderManagers = new SparseArray<LoaderManagerImpl>();
        } //End block
        LoaderManagerImpl lm;
        lm = mAllLoaderManagers.get(index);
        {
            {
                lm = new LoaderManagerImpl(this, started);
                mAllLoaderManagers.put(index, lm);
            } //End block
        } //End block
        {
            lm.updateActivity(this);
        } //End block
        return (LoaderManagerImpl)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mAllLoaderManagers == null) {
            //mAllLoaderManagers = new SparseArray<LoaderManagerImpl>();
        //}
        //LoaderManagerImpl lm = mAllLoaderManagers.get(index);
        //if (lm == null) {
            //if (create) {
                //lm = new LoaderManagerImpl(this, started);
                //mAllLoaderManagers.put(index, lm);
            //}
        //} else {
            //lm.updateActivity(this);
        //}
        //return lm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.724 -0400", hash_original_method = "44957F5326E5A87B91E438DCD3C71232", hash_generated_method = "DF2454BE3EE6F09D7710FBF09A86426A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public View getCurrentFocus() {
        {
            Object varF2CA58DC7834394B6A347593E17E623A_7382207 = (mWindow.getCurrentFocus());
        } //End flattened ternary
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mWindow != null ? mWindow.getCurrentFocus() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.725 -0400", hash_original_method = "B17127798FA6CFC370BF4A1AB8F1546E", hash_generated_method = "28683BA694BFD24ED50B5320E96F235C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void onCreate(Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(savedInstanceState.dsTaint);
        {
            mAllLoaderManagers = mLastNonConfigurationInstances.loaders;
        } //End block
        {
            Parcelable p;
            p = savedInstanceState.getParcelable(FRAGMENTS_TAG);
            mFragments.restoreAllState(p, mLastNonConfigurationInstances != null
                    ? mLastNonConfigurationInstances.fragments : null);
        } //End block
        mFragments.dispatchCreate();
        getApplication().dispatchActivityCreated(this, savedInstanceState);
        mCalled = true;
        // ---------- Original Method ----------
        //if (mLastNonConfigurationInstances != null) {
            //mAllLoaderManagers = mLastNonConfigurationInstances.loaders;
        //}
        //if (savedInstanceState != null) {
            //Parcelable p = savedInstanceState.getParcelable(FRAGMENTS_TAG);
            //mFragments.restoreAllState(p, mLastNonConfigurationInstances != null
                    //? mLastNonConfigurationInstances.fragments : null);
        //}
        //mFragments.dispatchCreate();
        //getApplication().dispatchActivityCreated(this, savedInstanceState);
        //mCalled = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.726 -0400", hash_original_method = "F96DCFB160CAE669DE173597BCAB5D29", hash_generated_method = "739760FE40CF77A18CC5A78817BAC093")
    @DSModeled(DSC.SAFE)
    final void performRestoreInstanceState(Bundle savedInstanceState) {
        dsTaint.addTaint(savedInstanceState.dsTaint);
        onRestoreInstanceState(savedInstanceState);
        restoreManagedDialogs(savedInstanceState);
        // ---------- Original Method ----------
        //onRestoreInstanceState(savedInstanceState);
        //restoreManagedDialogs(savedInstanceState);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.726 -0400", hash_original_method = "310E3A3C8C3B3732DFA9529F42CA26F1", hash_generated_method = "CBA37E88FA20B86D21429BD5858B087C")
    @DSModeled(DSC.SAFE)
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(savedInstanceState.dsTaint);
        {
            Bundle windowState;
            windowState = savedInstanceState.getBundle(WINDOW_HIERARCHY_TAG);
            {
                mWindow.restoreHierarchyState(windowState);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mWindow != null) {
            //Bundle windowState = savedInstanceState.getBundle(WINDOW_HIERARCHY_TAG);
            //if (windowState != null) {
                //mWindow.restoreHierarchyState(windowState);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.727 -0400", hash_original_method = "0F730FD08B46E6D42261031E4F07C651", hash_generated_method = "0994CAB639E0FD5BBE6B32B15F925D13")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void restoreManagedDialogs(Bundle savedInstanceState) {
        dsTaint.addTaint(savedInstanceState.dsTaint);
        final Bundle b;
        b = savedInstanceState.getBundle(SAVED_DIALOGS_TAG);
        final int[] ids;
        ids = b.getIntArray(SAVED_DIALOG_IDS_KEY);
        final int numDialogs;
        numDialogs = ids.length;
        mManagedDialogs = new SparseArray<ManagedDialog>(numDialogs);
        {
            int i;
            i = 0;
            {
                final Integer dialogId;
                dialogId = ids[i];
                Bundle dialogState;
                dialogState = b.getBundle(savedDialogKeyFor(dialogId));
                {
                    final ManagedDialog md;
                    md = new ManagedDialog();
                    md.mArgs = b.getBundle(savedDialogArgsKeyFor(dialogId));
                    md.mDialog = createDialog(dialogId, dialogState, md.mArgs);
                    {
                        mManagedDialogs.put(dialogId, md);
                        onPrepareDialog(dialogId, md.mDialog, md.mArgs);
                        md.mDialog.onRestoreInstanceState(dialogState);
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.728 -0400", hash_original_method = "F21B3418C21CA75D12B54B07BD48021E", hash_generated_method = "EE501D33C65CC0FAF1423CD836212A1A")
    @DSModeled(DSC.SAFE)
    private Dialog createDialog(Integer dialogId, Bundle state, Bundle args) {
        dsTaint.addTaint(args.dsTaint);
        dsTaint.addTaint(state.dsTaint);
        dsTaint.addTaint(dialogId.dsTaint);
        final Dialog dialog;
        dialog = onCreateDialog(dialogId, args);
        dialog.dispatchOnCreate(state);
        return (Dialog)dsTaint.getTaint();
        // ---------- Original Method ----------
        //final Dialog dialog = onCreateDialog(dialogId, args);
        //if (dialog == null) {
            //return null;
        //}
        //dialog.dispatchOnCreate(state);
        //return dialog;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.728 -0400", hash_original_method = "01913B634CE5DDC5010A9BA59D76B171", hash_generated_method = "DF750B8EE9E341C812E98754AB7A947F")
    private static String savedDialogKeyFor(int key) {
        return SAVED_DIALOG_KEY_PREFIX + key;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.729 -0400", hash_original_method = "52E4E9B9636BD2D522A3CAFDBBCABB2E", hash_generated_method = "42E47A4EE8ECE157D7CD799C3C8E1FD9")
    private static String savedDialogArgsKeyFor(int key) {
        return SAVED_DIALOG_ARGS_KEY_PREFIX + key;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.729 -0400", hash_original_method = "15D630F6A1CF1F711678BA91927530D5", hash_generated_method = "32B937092021C60EF38A6C348A8E521A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void onPostCreate(Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(savedInstanceState.dsTaint);
        {
            boolean var1E47DE65F9CFFB5FFE0047F063F1F3E2_753570631 = (!isChild());
            {
                mTitleReady = true;
                onTitleChanged(getTitle(), getTitleColor());
            } //End block
        } //End collapsed parenthetic
        mCalled = true;
        // ---------- Original Method ----------
        //if (!isChild()) {
            //mTitleReady = true;
            //onTitleChanged(getTitle(), getTitleColor());
        //}
        //mCalled = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.730 -0400", hash_original_method = "79A696122767FFD8BC894F5F20A8F390", hash_generated_method = "4E5E996D025551530E8EB96B0864C007")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void onStart() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mCalled = true;
        {
            mLoadersStarted = true;
            {
                mLoaderManager.doStart();
            } //End block
            {
                mLoaderManager = getLoaderManager(-1, mLoadersStarted, false);
            } //End block
            mCheckedForLoaderManager = true;
        } //End block
        getApplication().dispatchActivityStarted(this);
        // ---------- Original Method ----------
        //mCalled = true;
        //if (!mLoadersStarted) {
            //mLoadersStarted = true;
            //if (mLoaderManager != null) {
                //mLoaderManager.doStart();
            //} else if (!mCheckedForLoaderManager) {
                //mLoaderManager = getLoaderManager(-1, mLoadersStarted, false);
            //}
            //mCheckedForLoaderManager = true;
        //}
        //getApplication().dispatchActivityStarted(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.731 -0400", hash_original_method = "9551F017AAC8568C86A29525E7DD6889", hash_generated_method = "D202A2C92ACEC885F880557EE728CEAE")
    @DSModeled(DSC.SAFE)
    protected void onRestart() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mCalled = true;
        // ---------- Original Method ----------
        //mCalled = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.731 -0400", hash_original_method = "AC4046BA89469FB1DB71AF45F366E61A", hash_generated_method = "ECE50173A0551FF37913CE55E433C882")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void onResume() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        getApplication().dispatchActivityResumed(this);
        mCalled = true;
        // ---------- Original Method ----------
        //getApplication().dispatchActivityResumed(this);
        //mCalled = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.732 -0400", hash_original_method = "F3C7FB58C48A3E40E2BB0C45916F9A60", hash_generated_method = "DAB3C21D61668AD84B32E79F565A283A")
    @DSModeled(DSC.SAFE)
    protected void onPostResume() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        final Window win;
        win = getWindow();
        win.makeActive();
        mActionBar.setShowHideAnimationEnabled(true);
        mCalled = true;
        // ---------- Original Method ----------
        //final Window win = getWindow();
        //if (win != null) win.makeActive();
        //if (mActionBar != null) mActionBar.setShowHideAnimationEnabled(true);
        //mCalled = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.732 -0400", hash_original_method = "ECA12E6FCFF6C8E6301C9A23FD34F5BD", hash_generated_method = "52D29C01F58DA8640060B5BE6E5442DE")
    @DSModeled(DSC.SPEC)
    protected void onNewIntent(Intent intent) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(intent.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.733 -0400", hash_original_method = "0B461FC0ABFD8E876BD0A4555078BB43", hash_generated_method = "C56C97B491CE9C5DFDD46FEB5DDEC62B")
    @DSModeled(DSC.SAFE)
    final void performSaveInstanceState(Bundle outState) {
        dsTaint.addTaint(outState.dsTaint);
        onSaveInstanceState(outState);
        saveManagedDialogs(outState);
        // ---------- Original Method ----------
        //onSaveInstanceState(outState);
        //saveManagedDialogs(outState);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.734 -0400", hash_original_method = "7ACED454726A10AD27032B8542185EA6", hash_generated_method = "98D70395C0F7323DB2694D59337F9106")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void onSaveInstanceState(Bundle outState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(outState.dsTaint);
        outState.putBundle(WINDOW_HIERARCHY_TAG, mWindow.saveHierarchyState());
        Parcelable p;
        p = mFragments.saveAllState();
        {
            outState.putParcelable(FRAGMENTS_TAG, p);
        } //End block
        getApplication().dispatchActivitySaveInstanceState(this, outState);
        // ---------- Original Method ----------
        //outState.putBundle(WINDOW_HIERARCHY_TAG, mWindow.saveHierarchyState());
        //Parcelable p = mFragments.saveAllState();
        //if (p != null) {
            //outState.putParcelable(FRAGMENTS_TAG, p);
        //}
        //getApplication().dispatchActivitySaveInstanceState(this, outState);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.735 -0400", hash_original_method = "8A0B1A781281636D9884F4D74FBF5AF9", hash_generated_method = "19E9098EB3222FEDF700F19021E6CF94")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void saveManagedDialogs(Bundle outState) {
        dsTaint.addTaint(outState.dsTaint);
        final int numDialogs;
        numDialogs = mManagedDialogs.size();
        Bundle dialogState;
        dialogState = new Bundle();
        int[] ids;
        ids = new int[mManagedDialogs.size()];
        {
            int i;
            i = 0;
            {
                final int key;
                key = mManagedDialogs.keyAt(i);
                ids[i] = key;
                final ManagedDialog md;
                md = mManagedDialogs.valueAt(i);
                dialogState.putBundle(savedDialogKeyFor(key), md.mDialog.onSaveInstanceState());
                {
                    dialogState.putBundle(savedDialogArgsKeyFor(key), md.mArgs);
                } //End block
            } //End block
        } //End collapsed parenthetic
        dialogState.putIntArray(SAVED_DIALOG_IDS_KEY, ids);
        outState.putBundle(SAVED_DIALOGS_TAG, dialogState);
        // ---------- Original Method ----------
        //if (mManagedDialogs == null) {
            //return;
        //}
        //final int numDialogs = mManagedDialogs.size();
        //if (numDialogs == 0) {
            //return;
        //}
        //Bundle dialogState = new Bundle();
        //int[] ids = new int[mManagedDialogs.size()];
        //for (int i = 0; i < numDialogs; i++) {
            //final int key = mManagedDialogs.keyAt(i);
            //ids[i] = key;
            //final ManagedDialog md = mManagedDialogs.valueAt(i);
            //dialogState.putBundle(savedDialogKeyFor(key), md.mDialog.onSaveInstanceState());
            //if (md.mArgs != null) {
                //dialogState.putBundle(savedDialogArgsKeyFor(key), md.mArgs);
            //}
        //}
        //dialogState.putIntArray(SAVED_DIALOG_IDS_KEY, ids);
        //outState.putBundle(SAVED_DIALOGS_TAG, dialogState);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.735 -0400", hash_original_method = "B6F2BA46109080323AC17E644CBE52E4", hash_generated_method = "266839F4FFD8CFDEA7FF3251A1B039A9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void onPause() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        getApplication().dispatchActivityPaused(this);
        mCalled = true;
        // ---------- Original Method ----------
        //getApplication().dispatchActivityPaused(this);
        //mCalled = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.736 -0400", hash_original_method = "F09D1B8D5CADCA3B5931B472B638BC48", hash_generated_method = "E7A345CE7D7338AB1E7898DE14CA41F6")
    @DSModeled(DSC.SAFE)
    protected void onUserLeaveHint() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.736 -0400", hash_original_method = "88BB0202BF6BAEB771096BFB80D04435", hash_generated_method = "59BCE036A25FD3C9BCF9A82B65E5AF84")
    @DSModeled(DSC.SAFE)
    public boolean onCreateThumbnail(Bitmap outBitmap, Canvas canvas) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(outBitmap.dsTaint);
        dsTaint.addTaint(canvas.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.737 -0400", hash_original_method = "ABF3FC9B35FB67DA4650457E79D2DAE8", hash_generated_method = "EF01E641A622712ED5EBB96D019796CD")
    @DSModeled(DSC.SAFE)
    public CharSequence onCreateDescription() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.737 -0400", hash_original_method = "24615BF0697D6E27C5190BAC65D711E7", hash_generated_method = "253EB0CD46E41E0E44CF45F7DC3F4B21")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void onStop() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mActionBar.setShowHideAnimationEnabled(false);
        getApplication().dispatchActivityStopped(this);
        mCalled = true;
        // ---------- Original Method ----------
        //if (mActionBar != null) mActionBar.setShowHideAnimationEnabled(false);
        //getApplication().dispatchActivityStopped(this);
        //mCalled = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.738 -0400", hash_original_method = "4E5533F51E688B9D4BB620414B9C0889", hash_generated_method = "CC0198698FD5F28B6B48F4F7219C4537")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void onDestroy() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mCalled = true;
        {
            final int numDialogs;
            numDialogs = mManagedDialogs.size();
            {
                int i;
                i = 0;
                {
                    final ManagedDialog md;
                    md = mManagedDialogs.valueAt(i);
                    {
                        boolean var45C50B8B627C1BA4D235A3956BED22BE_492544448 = (md.mDialog.isShowing());
                        {
                            md.mDialog.dismiss();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            mManagedDialogs = null;
        } //End block
        {
            int numCursors;
            numCursors = mManagedCursors.size();
            {
                int i;
                i = 0;
                {
                    ManagedCursor c;
                    c = mManagedCursors.get(i);
                    {
                        c.mCursor.close();
                    } //End block
                } //End block
            } //End collapsed parenthetic
            mManagedCursors.clear();
        } //End block
        {
            mSearchManager.stopSearch();
        } //End block
        getApplication().dispatchActivityDestroyed(this);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.739 -0400", hash_original_method = "30CE766C89D5A8D407C7E787A35027AF", hash_generated_method = "6ACD567CACA2643A3709EB1A931CEB5A")
    @DSModeled(DSC.SAFE)
    public void onConfigurationChanged(Configuration newConfig) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(newConfig.dsTaint);
        mCalled = true;
        mFragments.dispatchConfigurationChanged(newConfig);
        {
            mWindow.onConfigurationChanged(newConfig);
        } //End block
        {
            mActionBar.onConfigurationChanged(newConfig);
        } //End block
        // ---------- Original Method ----------
        //mCalled = true;
        //mFragments.dispatchConfigurationChanged(newConfig);
        //if (mWindow != null) {
            //mWindow.onConfigurationChanged(newConfig);
        //}
        //if (mActionBar != null) {
            //mActionBar.onConfigurationChanged(newConfig);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.740 -0400", hash_original_method = "60C5D0D9DB2F726CCDEA80A841C2981A", hash_generated_method = "9E267EC084A6047B1ECC6FC244D02162")
    @DSModeled(DSC.SAFE)
    public int getChangingConfigurations() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mConfigChangeFlags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.740 -0400", hash_original_method = "A4ED76D57E3C56C838C9F6AEF3843C6C", hash_generated_method = "750C1664BAFBD616B7CA084DFC4E257B")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public Object getLastNonConfigurationInstance() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mLastNonConfigurationInstances != null
                //? mLastNonConfigurationInstances.activity : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.741 -0400", hash_original_method = "1AAF173FB42EFD7F047F27F49A93F1B0", hash_generated_method = "01A7E90FD2B528BFCEED63391B6C6CE1")
    @DSModeled(DSC.SAFE)
    public Object onRetainNonConfigurationInstance() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.741 -0400", hash_original_method = "891F87189588B9AE1E11F6F1107773C1", hash_generated_method = "BAC145EE2E1F975583038F5718C6EBFA")
    @DSModeled(DSC.SAFE)
     HashMap<String, Object> getLastNonConfigurationChildInstances() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return (HashMap<String, Object>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mLastNonConfigurationInstances != null
                //? mLastNonConfigurationInstances.children : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.742 -0400", hash_original_method = "342B0C995620FF868A09DAF694D00C04", hash_generated_method = "1DC6064E7039BC09DEFCA401512A5C90")
    @DSModeled(DSC.SAFE)
     HashMap<String,Object> onRetainNonConfigurationChildInstances() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return (HashMap<String,Object>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.743 -0400", hash_original_method = "927AC7E194A76481C5C9B757C08C225A", hash_generated_method = "7909CAA819A80B3C1BA5AE08C5B189CB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     NonConfigurationInstances retainNonConfigurationInstances() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Object activity;
        activity = onRetainNonConfigurationInstance();
        HashMap<String, Object> children;
        children = onRetainNonConfigurationChildInstances();
        ArrayList<Fragment> fragments;
        fragments = mFragments.retainNonConfig();
        boolean retainLoaders;
        retainLoaders = false;
        {
            {
                int i;
                i = mAllLoaderManagers.size()-1;
                {
                    LoaderManagerImpl lm;
                    lm = mAllLoaderManagers.valueAt(i);
                    {
                        retainLoaders = true;
                    } //End block
                    {
                        lm.doDestroy();
                        mAllLoaderManagers.removeAt(i);
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        NonConfigurationInstances nci;
        nci = new NonConfigurationInstances();
        nci.activity = activity;
        nci.children = children;
        nci.fragments = fragments;
        nci.loaders = mAllLoaderManagers;
        return (NonConfigurationInstances)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.744 -0400", hash_original_method = "85EA10C9746E5BAE09F0BEB2EAF91433", hash_generated_method = "9587D3F3FAAE88840B7FC55EE1579ED5")
    @DSModeled(DSC.SAFE)
    public void onLowMemory() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mCalled = true;
        mFragments.dispatchLowMemory();
        // ---------- Original Method ----------
        //mCalled = true;
        //mFragments.dispatchLowMemory();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.744 -0400", hash_original_method = "B7E71156F952E373C8BB026507E8D786", hash_generated_method = "F678EFADD2161430E21DB58A999C0616")
    @DSModeled(DSC.SAFE)
    public void onTrimMemory(int level) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(level);
        mCalled = true;
        mFragments.dispatchTrimMemory(level);
        // ---------- Original Method ----------
        //mCalled = true;
        //mFragments.dispatchTrimMemory(level);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.745 -0400", hash_original_method = "C5EB33D6873EE026D87972F02E8EBD4B", hash_generated_method = "2568D385BA2282FEB7F36F9651AD680E")
    @DSModeled(DSC.SAFE)
    public FragmentManager getFragmentManager() {
        return (FragmentManager)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mFragments;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.745 -0400", hash_original_method = "36D6A0BA7A439406C26069B6EB63A924", hash_generated_method = "2F67570E22960178C45866258AD4B5B0")
    @DSModeled(DSC.SAFE)
     void invalidateFragmentIndex(int index) {
        dsTaint.addTaint(index);
        {
            LoaderManagerImpl lm;
            lm = mAllLoaderManagers.get(index);
            {
                lm.doDestroy();
                mAllLoaderManagers.remove(index);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mAllLoaderManagers != null) {
            //LoaderManagerImpl lm = mAllLoaderManagers.get(index);
            //if (lm != null && !lm.mRetaining) {
                //lm.doDestroy();
                //mAllLoaderManagers.remove(index);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.746 -0400", hash_original_method = "28C2B4CF762BABC0F8C194FDD6A98E77", hash_generated_method = "6F83A2FFAD2DFCB63F3D0346C0EAC8BE")
    @DSModeled(DSC.SAFE)
    public void onAttachFragment(Fragment fragment) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(fragment.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.746 -0400", hash_original_method = "BCF4BFC69850BAC01DAD91770055CA28", hash_generated_method = "126901FD983AAD78B64A355313770740")
    @DSModeled(DSC.SPEC)
    @Deprecated
    public final Cursor managedQuery(Uri uri, String[] projection, String selection,
            String sortOrder) {
        dsTaint.addTaint(sortOrder);
        dsTaint.addTaint(projection);
        dsTaint.addTaint(uri.dsTaint);
        dsTaint.addTaint(selection);
        Cursor c;
        c = getContentResolver().query(uri, projection, selection, null, sortOrder);
        {
            startManagingCursor(c);
        } //End block
        return (Cursor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Cursor c = getContentResolver().query(uri, projection, selection, null, sortOrder);
        //if (c != null) {
            //startManagingCursor(c);
        //}
        //return c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.747 -0400", hash_original_method = "957642E226FD04681CA818B5E27D8161", hash_generated_method = "92B656DACD7D029A186616DEEB8E1761")
    @DSModeled(DSC.SPEC)
    @Deprecated
    public final Cursor managedQuery(Uri uri, String[] projection, String selection,
            String[] selectionArgs, String sortOrder) {
        dsTaint.addTaint(selectionArgs);
        dsTaint.addTaint(sortOrder);
        dsTaint.addTaint(projection);
        dsTaint.addTaint(uri.dsTaint);
        dsTaint.addTaint(selection);
        Cursor c;
        c = getContentResolver().query(uri, projection, selection, selectionArgs, sortOrder);
        {
            startManagingCursor(c);
        } //End block
        return (Cursor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Cursor c = getContentResolver().query(uri, projection, selection, selectionArgs, sortOrder);
        //if (c != null) {
            //startManagingCursor(c);
        //}
        //return c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.748 -0400", hash_original_method = "A63FE9916C33F333B3D894D85FA64949", hash_generated_method = "0CE73C38D33F355837504D521B858232")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void startManagingCursor(Cursor c) {
        dsTaint.addTaint(c.dsTaint);
        {
            mManagedCursors.add(new ManagedCursor(c));
        } //End block
        // ---------- Original Method ----------
        //synchronized (mManagedCursors) {
            //mManagedCursors.add(new ManagedCursor(c));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.748 -0400", hash_original_method = "6A91264601243F53EF1A64547761DF34", hash_generated_method = "92CF959BFC514B3DDBD23FE7FE532F11")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void stopManagingCursor(Cursor c) {
        dsTaint.addTaint(c.dsTaint);
        {
            final int N;
            N = mManagedCursors.size();
            {
                int i;
                i = 0;
                {
                    ManagedCursor mc;
                    mc = mManagedCursors.get(i);
                    {
                        mManagedCursors.remove(i);
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //synchronized (mManagedCursors) {
            //final int N = mManagedCursors.size();
            //for (int i=0; i<N; i++) {
                //ManagedCursor mc = mManagedCursors.get(i);
                //if (mc.mCursor == c) {
                    //mManagedCursors.remove(i);
                    //break;
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.749 -0400", hash_original_method = "14D9F664592BF6CD2790F336C855BE58", hash_generated_method = "065334D146CB7E4548BEBCFA3FB6CCB6")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void setPersistent(boolean isPersistent) {
        dsTaint.addTaint(isPersistent);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.749 -0400", hash_original_method = "6A267AF8CD8DFD046F9AA4A840E0F1F1", hash_generated_method = "C4A8C3CFD3A2BA03DE0867D47DFF19DE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public View findViewById(int id) {
        dsTaint.addTaint(id);
        View var54D20F3E0E6EE36A641A7B0DC7FF322B_581087325 = (getWindow().findViewById(id));
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getWindow().findViewById(id);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.750 -0400", hash_original_method = "EC6DC7C8BFDE6FF47CE21F97E3274EE5", hash_generated_method = "7DADAA2D397D5F1EBB1CEE4C70DB0F61")
    @DSModeled(DSC.SAFE)
    public ActionBar getActionBar() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        initActionBar();
        return (ActionBar)dsTaint.getTaint();
        // ---------- Original Method ----------
        //initActionBar();
        //return mActionBar;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.750 -0400", hash_original_method = "1F37525CA4259BFCC1AC98918D267A3B", hash_generated_method = "5123F7C61FF191E3A3751465F1D4BC36")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void initActionBar() {
        Window window;
        window = getWindow();
        window.getDecorView();
        {
            boolean varDD4E522E8814A0C229F7C100E74BEA95_2064886713 = (isChild() || !window.hasFeature(Window.FEATURE_ACTION_BAR) || mActionBar != null);
        } //End collapsed parenthetic
        mActionBar = new ActionBarImpl(this);
        // ---------- Original Method ----------
        //Window window = getWindow();
        //window.getDecorView();
        //if (isChild() || !window.hasFeature(Window.FEATURE_ACTION_BAR) || mActionBar != null) {
            //return;
        //}
        //mActionBar = new ActionBarImpl(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.751 -0400", hash_original_method = "FC4CFA409E0DBC3CD2C86D908686341E", hash_generated_method = "8E241ED274E7D1AAFA0EB909220058EF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setContentView(int layoutResID) {
        dsTaint.addTaint(layoutResID);
        getWindow().setContentView(layoutResID);
        initActionBar();
        // ---------- Original Method ----------
        //getWindow().setContentView(layoutResID);
        //initActionBar();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.752 -0400", hash_original_method = "6143DA20A0E63D3DD26D6D6CC3A0350F", hash_generated_method = "1E9485E9A0FC7F707C59D407F48ECB13")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setContentView(View view) {
        dsTaint.addTaint(view.dsTaint);
        getWindow().setContentView(view);
        initActionBar();
        // ---------- Original Method ----------
        //getWindow().setContentView(view);
        //initActionBar();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.752 -0400", hash_original_method = "FCB0E6F09A4D449F841F63B35D6A2C9A", hash_generated_method = "B7D2D84E0F2EA2E18CFFDD432D78C4C6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        dsTaint.addTaint(view.dsTaint);
        dsTaint.addTaint(params.dsTaint);
        getWindow().setContentView(view, params);
        initActionBar();
        // ---------- Original Method ----------
        //getWindow().setContentView(view, params);
        //initActionBar();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.753 -0400", hash_original_method = "FC447FA34EAD1A15520CE5D8778BF36F", hash_generated_method = "B47B46F7E44D7082DBC2B5FF565124E5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addContentView(View view, ViewGroup.LayoutParams params) {
        dsTaint.addTaint(view.dsTaint);
        dsTaint.addTaint(params.dsTaint);
        getWindow().addContentView(view, params);
        initActionBar();
        // ---------- Original Method ----------
        //getWindow().addContentView(view, params);
        //initActionBar();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.753 -0400", hash_original_method = "729048B37138D48F6A74BC6AFCECACEE", hash_generated_method = "9445592E2AE7A6B2EEAEF070186688D9")
    @DSModeled(DSC.SAFE)
    public void setFinishOnTouchOutside(boolean finish) {
        dsTaint.addTaint(finish);
        mWindow.setCloseOnTouchOutside(finish);
        // ---------- Original Method ----------
        //mWindow.setCloseOnTouchOutside(finish);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.754 -0400", hash_original_method = "84B2B4D9720193C8DC3107EE4335392B", hash_generated_method = "E44E11E3FB0E35508160F1B68D40B26F")
    @DSModeled(DSC.SAFE)
    public final void setDefaultKeyMode(int mode) {
        dsTaint.addTaint(mode);
        //Begin case DEFAULT_KEYS_DISABLE DEFAULT_KEYS_SHORTCUT 
        mDefaultKeySsb = null;
        //End case DEFAULT_KEYS_DISABLE DEFAULT_KEYS_SHORTCUT 
        //Begin case DEFAULT_KEYS_DIALER DEFAULT_KEYS_SEARCH_LOCAL DEFAULT_KEYS_SEARCH_GLOBAL 
        mDefaultKeySsb = new SpannableStringBuilder();
        //End case DEFAULT_KEYS_DIALER DEFAULT_KEYS_SEARCH_LOCAL DEFAULT_KEYS_SEARCH_GLOBAL 
        //Begin case DEFAULT_KEYS_DIALER DEFAULT_KEYS_SEARCH_LOCAL DEFAULT_KEYS_SEARCH_GLOBAL 
        Selection.setSelection(mDefaultKeySsb,0);
        //End case DEFAULT_KEYS_DIALER DEFAULT_KEYS_SEARCH_LOCAL DEFAULT_KEYS_SEARCH_GLOBAL 
        //Begin case default 
        throw new IllegalArgumentException();
        //End case default 
        // ---------- Original Method ----------
        //mDefaultKeyMode = mode;
        //switch (mode) {
        //case DEFAULT_KEYS_DISABLE:
        //case DEFAULT_KEYS_SHORTCUT:
            //mDefaultKeySsb = null;      
            //break;
        //case DEFAULT_KEYS_DIALER:
        //case DEFAULT_KEYS_SEARCH_LOCAL:
        //case DEFAULT_KEYS_SEARCH_GLOBAL:
            //mDefaultKeySsb = new SpannableStringBuilder();
            //Selection.setSelection(mDefaultKeySsb,0);
            //break;
        //default:
            //throw new IllegalArgumentException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.756 -0400", hash_original_method = "447EA7C05CB03D3ADA1829E3AD87227A", hash_generated_method = "855926021ECBD8A3EBB5FD414D73C194")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        {
            {
                boolean var6C8C397317C30451187B86B88E0B9C4B_1312394776 = (getApplicationInfo().targetSdkVersion
                    >= Build.VERSION_CODES.ECLAIR);
                {
                    event.startTracking();
                } //End block
                {
                    onBackPressed();
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varBB73A2A4C4FF1B16BF9427D966A4A801_1818695349 = (getWindow().performPanelShortcut(Window.FEATURE_OPTIONS_PANEL, 
                    keyCode, event, Menu.FLAG_ALWAYS_PERFORM_CLOSE));
            } //End collapsed parenthetic
        } //End block
        {
            boolean clearSpannable;
            clearSpannable = false;
            boolean handled;
            {
                boolean var083CEDCC9F1335B2AB0C1AAC01AAF679_850582314 = ((event.getRepeatCount() != 0) || event.isSystem());
                {
                    clearSpannable = true;
                    handled = false;
                } //End block
                {
                    handled = TextKeyListener.getInstance().onKeyDown(
                        null, mDefaultKeySsb, keyCode, event);
                    {
                        boolean varEE1C0A7E7A940EF9FBEBBE171CEDD5A9_487941946 = (handled && mDefaultKeySsb.length() > 0);
                        {
                            final String str;
                            str = mDefaultKeySsb.toString();
                            clearSpannable = true;
                            //Begin case DEFAULT_KEYS_DIALER 
                            Intent intent;
                            intent = new Intent(Intent.ACTION_DIAL,  Uri.parse("tel:" + str));
                            //End case DEFAULT_KEYS_DIALER 
                            //Begin case DEFAULT_KEYS_DIALER 
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            //End case DEFAULT_KEYS_DIALER 
                            //Begin case DEFAULT_KEYS_DIALER 
                            startActivity(intent);
                            //End case DEFAULT_KEYS_DIALER 
                            //Begin case DEFAULT_KEYS_SEARCH_LOCAL 
                            startSearch(str, false, null, false);
                            //End case DEFAULT_KEYS_SEARCH_LOCAL 
                            //Begin case DEFAULT_KEYS_SEARCH_GLOBAL 
                            startSearch(str, false, null, true);
                            //End case DEFAULT_KEYS_SEARCH_GLOBAL 
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                mDefaultKeySsb.clear();
                mDefaultKeySsb.clearSpans();
                Selection.setSelection(mDefaultKeySsb,0);
            } //End block
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.757 -0400", hash_original_method = "2A75FF2C44C4D96068DDAFC2643F0C8B", hash_generated_method = "DA9BC46836632D5DE2442CF165E2ADA1")
    @DSModeled(DSC.SAFE)
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.758 -0400", hash_original_method = "25B851F5D41453D6013FB2C2AA511AE1", hash_generated_method = "CC3D85B55CB1BFBBB850295CE387778A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        {
            boolean varDD97E8990072EF9A9394C8CEA67054A7_936875198 = (getApplicationInfo().targetSdkVersion
                >= Build.VERSION_CODES.ECLAIR);
            {
                {
                    boolean var1C6DFE5F80166C4CE3FD88815AAAD598_455329408 = (keyCode == KeyEvent.KEYCODE_BACK && event.isTracking()
                    && !event.isCanceled());
                    {
                        onBackPressed();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (getApplicationInfo().targetSdkVersion
                //>= Build.VERSION_CODES.ECLAIR) {
            //if (keyCode == KeyEvent.KEYCODE_BACK && event.isTracking()
                    //&& !event.isCanceled()) {
                //onBackPressed();
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.758 -0400", hash_original_method = "E364C67ED15F0AA31C6DCFFA6137C8C0", hash_generated_method = "0E01544320A5CC465E03FDA462609D24")
    @DSModeled(DSC.SAFE)
    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        dsTaint.addTaint(repeatCount);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.759 -0400", hash_original_method = "6AE13C43A807A8F581EF7E482513BDAF", hash_generated_method = "B12257E0E9D677DEAFC01C83BBE922AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onBackPressed() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var5C240956F2A34791A06A0F4236D73061_418832538 = (!mFragments.popBackStackImmediate());
            {
                finish();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!mFragments.popBackStackImmediate()) {
            //finish();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.759 -0400", hash_original_method = "2ECF3E4914B4B3BE2238F799B7435A51", hash_generated_method = "364CE6898BE65A7CFF9904AA77AFAA75")
    @DSModeled(DSC.SAFE)
    public boolean onKeyShortcut(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.760 -0400", hash_original_method = "587C23A975B49ED816BE95A55AB82601", hash_generated_method = "4442B0EDD7455B69C119843022B56884")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onTouchEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        {
            boolean var5B881718D56E5E510CAAD751F448A0C9_1098812864 = (mWindow.shouldCloseOnTouch(this, event));
            {
                finish();
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mWindow.shouldCloseOnTouch(this, event)) {
            //finish();
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.761 -0400", hash_original_method = "4A983FDB3FF481E2165B7D8D641CDD48", hash_generated_method = "B408743212A32554110D224D6DDF0567")
    @DSModeled(DSC.SAFE)
    public boolean onTrackballEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.761 -0400", hash_original_method = "0E59A005881F30C798F764BCF32D89A3", hash_generated_method = "BEBEED24402A14C8538F8CE978A041B5")
    @DSModeled(DSC.SAFE)
    public boolean onGenericMotionEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.761 -0400", hash_original_method = "787C037504CBD45EADF1B222AFA073D0", hash_generated_method = "ECDB309EC70947C8B21E1D0D7A9F5CCC")
    @DSModeled(DSC.SAFE)
    public void onUserInteraction() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.762 -0400", hash_original_method = "1D902756EB8B1D6D1B39ED873E4CD230", hash_generated_method = "F6F001C55A048E16F5891B21B02D57D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onWindowAttributesChanged(WindowManager.LayoutParams params) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(params.dsTaint);
        {
            View decor;
            decor = mDecor;
            {
                boolean var518FD95C1D322AE3CA22F3454EF80BC3_1174921869 = (decor != null && decor.getParent() != null);
                {
                    getWindowManager().updateViewLayout(decor, params);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //if (mParent == null) {
            //View decor = mDecor;
            //if (decor != null && decor.getParent() != null) {
                //getWindowManager().updateViewLayout(decor, params);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.763 -0400", hash_original_method = "32D7339793DCE0D5AEFE6621981EC978", hash_generated_method = "C607EECEEAC7DDCEB734C893F2AC41C9")
    @DSModeled(DSC.SAFE)
    public void onContentChanged() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.763 -0400", hash_original_method = "C7622FC561A602386C2112BC0445F7C6", hash_generated_method = "BD7B79E860C99002DF5F485F018D51C5")
    @DSModeled(DSC.SAFE)
    public void onWindowFocusChanged(boolean hasFocus) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(hasFocus);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.764 -0400", hash_original_method = "D6E949EE9F0768F47016EEA4FC0347A8", hash_generated_method = "2D900B79CAA57F7254CAD443BA396CFB")
    @DSModeled(DSC.SAFE)
    public void onAttachedToWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.764 -0400", hash_original_method = "E592299EBB4DE1D6696EB8C4009A9EF4", hash_generated_method = "431528BFA4E4D3D6E01BD7811B5265F1")
    @DSModeled(DSC.SAFE)
    public void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.765 -0400", hash_original_method = "7F717562D5C1B102DE657A2EE434F557", hash_generated_method = "F3B571B7E0F35CC591C07785293420F0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasWindowFocus() {
        Window w;
        w = getWindow();
        {
            View d;
            d = w.getDecorView();
            {
                boolean varB73A262141F3E017F7CE2E1136F11BDF_746917899 = (d.hasWindowFocus());
            } //End block
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Window w = getWindow();
        //if (w != null) {
            //View d = w.getDecorView();
            //if (d != null) {
                //return d.hasWindowFocus();
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.766 -0400", hash_original_method = "1A094AE61005DB4CDA2599E7F0A4A230", hash_generated_method = "1F24929A59DDC19956E7F0C23B9B9449")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean dispatchKeyEvent(KeyEvent event) {
        dsTaint.addTaint(event.dsTaint);
        onUserInteraction();
        Window win;
        win = getWindow();
        {
            boolean varB72D02E2D60D06CF890A5BAC6ED691A6_2029237683 = (win.superDispatchKeyEvent(event));
        } //End collapsed parenthetic
        View decor;
        decor = mDecor;
        decor = win.getDecorView();
        boolean var0F3BC286E711F8FE369DCCE6C96A1F39_1157135060 = (event.dispatch(this, decor != null
                ? decor.getKeyDispatcherState() : null, this)); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //onUserInteraction();
        //Window win = getWindow();
        //if (win.superDispatchKeyEvent(event)) {
            //return true;
        //}
        //View decor = mDecor;
        //if (decor == null) decor = win.getDecorView();
        //return event.dispatch(this, decor != null
                //? decor.getKeyDispatcherState() : null, this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.767 -0400", hash_original_method = "1BC9E6494D7E888C2866773840EEFAF2", hash_generated_method = "1F867E1B976CB189F261B3B7DB58F93E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean dispatchKeyShortcutEvent(KeyEvent event) {
        dsTaint.addTaint(event.dsTaint);
        onUserInteraction();
        {
            boolean var22B3DC591CCDF9027A8822387BB60CC1_1029413200 = (getWindow().superDispatchKeyShortcutEvent(event));
        } //End collapsed parenthetic
        boolean varB65319FC5255424F872A964CBDE1432E_1938967511 = (onKeyShortcut(event.getKeyCode(), event));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //onUserInteraction();
        //if (getWindow().superDispatchKeyShortcutEvent(event)) {
            //return true;
        //}
        //return onKeyShortcut(event.getKeyCode(), event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.767 -0400", hash_original_method = "9C043C82D0E35283EE51DCEF499F92C6", hash_generated_method = "8A53ACA030362A9CF3809C4F2A4199F6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean dispatchTouchEvent(MotionEvent ev) {
        dsTaint.addTaint(ev.dsTaint);
        {
            boolean var89AADF399BE9B0E2DFA5C9BD5C451F2D_41609381 = (ev.getAction() == MotionEvent.ACTION_DOWN);
            {
                onUserInteraction();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var63BEDD669BE8863D86EB2C005414F90C_84433155 = (getWindow().superDispatchTouchEvent(ev));
        } //End collapsed parenthetic
        boolean var985DA2294C2CD7796EE4EFA7F3FBE91B_1189743436 = (onTouchEvent(ev));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            //onUserInteraction();
        //}
        //if (getWindow().superDispatchTouchEvent(ev)) {
            //return true;
        //}
        //return onTouchEvent(ev);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.768 -0400", hash_original_method = "B4E564288E5B587F0E42C599C68E6C62", hash_generated_method = "05B85D5EDD92B999B6FF776397A3EB79")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean dispatchTrackballEvent(MotionEvent ev) {
        dsTaint.addTaint(ev.dsTaint);
        onUserInteraction();
        {
            boolean var344CC3B3CF0390FD00C126501759FC6E_1106641897 = (getWindow().superDispatchTrackballEvent(ev));
        } //End collapsed parenthetic
        boolean varE24895B72E913D801FFC5B9D9055D482_1855140134 = (onTrackballEvent(ev));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //onUserInteraction();
        //if (getWindow().superDispatchTrackballEvent(ev)) {
            //return true;
        //}
        //return onTrackballEvent(ev);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.769 -0400", hash_original_method = "8A5C748F888ED0234B6228EEE9B28C6A", hash_generated_method = "BB42671E3E033AF7B878184276CE1E16")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean dispatchGenericMotionEvent(MotionEvent ev) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(ev.dsTaint);
        onUserInteraction();
        {
            boolean var0488FB753A1A4840338895882C17972B_993376397 = (getWindow().superDispatchGenericMotionEvent(ev));
        } //End collapsed parenthetic
        boolean var82ABE1E641E95D27D650D268E959F965_1880919600 = (onGenericMotionEvent(ev));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //onUserInteraction();
        //if (getWindow().superDispatchGenericMotionEvent(ev)) {
            //return true;
        //}
        //return onGenericMotionEvent(ev);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.770 -0400", hash_original_method = "E0DA176D51FB90EA428361841719B862", hash_generated_method = "FB0278795B04440E4A8C0EF21946A0F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        dsTaint.addTaint(event.dsTaint);
        event.setClassName(getClass().getName());
        event.setPackageName(getPackageName());
        LayoutParams params;
        params = getWindow().getAttributes();
        boolean isFullScreen;
        isFullScreen = (params.width == LayoutParams.MATCH_PARENT) &&
            (params.height == LayoutParams.MATCH_PARENT);
        event.setFullScreen(isFullScreen);
        CharSequence title;
        title = getTitle();
        {
            boolean var4315037A3FEAFB24D399CA884BFC6923_2095423989 = (!TextUtils.isEmpty(title));
            {
                event.getText().add(title);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //event.setClassName(getClass().getName());
        //event.setPackageName(getPackageName());
        //LayoutParams params = getWindow().getAttributes();
        //boolean isFullScreen = (params.width == LayoutParams.MATCH_PARENT) &&
            //(params.height == LayoutParams.MATCH_PARENT);
        //event.setFullScreen(isFullScreen);
        //CharSequence title = getTitle();
        //if (!TextUtils.isEmpty(title)) {
           //event.getText().add(title);
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.771 -0400", hash_original_method = "8FB2859FE43E0606E21921E291A18BDA", hash_generated_method = "C714261247E9068E376FB32B63F0F6DE")
    @DSModeled(DSC.SAFE)
    public View onCreatePanelView(int featureId) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(featureId);
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.771 -0400", hash_original_method = "3CEBC68A0556AFB2BA0DA511B7D323DE", hash_generated_method = "38ACB49CBD4F93F9F3224B3A754494A9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(menu.dsTaint);
        dsTaint.addTaint(featureId);
        {
            boolean show;
            show = onCreateOptionsMenu(menu);
            show |= mFragments.dispatchCreateOptionsMenu(menu, getMenuInflater());
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (featureId == Window.FEATURE_OPTIONS_PANEL) {
            //boolean show = onCreateOptionsMenu(menu);
            //show |= mFragments.dispatchCreateOptionsMenu(menu, getMenuInflater());
            //return show;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.772 -0400", hash_original_method = "A6A8332EF2663DFC6EB1A100F6AD5BEC", hash_generated_method = "7C096EB9EC234635312DD3D2573CEC0A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onPreparePanel(int featureId, View view, Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(menu.dsTaint);
        dsTaint.addTaint(featureId);
        dsTaint.addTaint(view.dsTaint);
        {
            boolean goforit;
            goforit = onPrepareOptionsMenu(menu);
            goforit |= mFragments.dispatchPrepareOptionsMenu(menu);
            boolean var7116118DD297E6C08BE1AD40992AA51A_437339716 = (goforit && menu.hasVisibleItems());
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (featureId == Window.FEATURE_OPTIONS_PANEL && menu != null) {
            //boolean goforit = onPrepareOptionsMenu(menu);
            //goforit |= mFragments.dispatchPrepareOptionsMenu(menu);
            //return goforit && menu.hasVisibleItems();
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.773 -0400", hash_original_method = "FE81CE57FF3B2984A6841999BDAFE276", hash_generated_method = "F09DD994247D3BBE5F5D0DF004191951")
    @DSModeled(DSC.SAFE)
    public boolean onMenuOpened(int featureId, Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(menu.dsTaint);
        dsTaint.addTaint(featureId);
        {
            initActionBar();
            {
                mActionBar.dispatchMenuVisibilityChanged(true);
            } //End block
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (featureId == Window.FEATURE_ACTION_BAR) {
            //initActionBar();
            //if (mActionBar != null) {
                //mActionBar.dispatchMenuVisibilityChanged(true);
            //} else {
                //Log.e(TAG, "Tried to open action bar menu with no action bar");
            //}
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.774 -0400", hash_original_method = "06AE80A8039E39DC7E4DC1C38B6D66B0", hash_generated_method = "6E5C727CAF57C6CC4512E051B2E98FC6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(item.dsTaint);
        dsTaint.addTaint(featureId);
        //Begin case Window.FEATURE_OPTIONS_PANEL 
        EventLog.writeEvent(50000, 0, item.getTitleCondensed());
        //End case Window.FEATURE_OPTIONS_PANEL 
        //Begin case Window.FEATURE_OPTIONS_PANEL 
        {
            boolean var3550B832F8A6DB96B87874C60FB2152D_454042406 = (onOptionsItemSelected(item));
        } //End collapsed parenthetic
        //End case Window.FEATURE_OPTIONS_PANEL 
        //Begin case Window.FEATURE_OPTIONS_PANEL 
        boolean varE8A690D6428BE61C39A35A33EE497930_2048068342 = (mFragments.dispatchOptionsItemSelected(item));
        //End case Window.FEATURE_OPTIONS_PANEL 
        //Begin case Window.FEATURE_CONTEXT_MENU 
        EventLog.writeEvent(50000, 1, item.getTitleCondensed());
        //End case Window.FEATURE_CONTEXT_MENU 
        //Begin case Window.FEATURE_CONTEXT_MENU 
        {
            boolean varB8F885094F9CD83DEADF429F082FB201_1151060708 = (onContextItemSelected(item));
        } //End collapsed parenthetic
        //End case Window.FEATURE_CONTEXT_MENU 
        //Begin case Window.FEATURE_CONTEXT_MENU 
        boolean var06F6B009CCB26CDE69B7F5C36D0D4DFE_118718806 = (mFragments.dispatchContextItemSelected(item));
        //End case Window.FEATURE_CONTEXT_MENU 
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //switch (featureId) {
            //case Window.FEATURE_OPTIONS_PANEL:
                //EventLog.writeEvent(50000, 0, item.getTitleCondensed());
                //if (onOptionsItemSelected(item)) {
                    //return true;
                //}
                //return mFragments.dispatchOptionsItemSelected(item);
            //case Window.FEATURE_CONTEXT_MENU:
                //EventLog.writeEvent(50000, 1, item.getTitleCondensed());
                //if (onContextItemSelected(item)) {
                    //return true;
                //}
                //return mFragments.dispatchContextItemSelected(item);
            //default:
                //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.775 -0400", hash_original_method = "89E795D5B25B105016E6897E97159EA1", hash_generated_method = "20346585AE64290EEC9301F4E09FD2FE")
    @DSModeled(DSC.SAFE)
    public void onPanelClosed(int featureId, Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(menu.dsTaint);
        dsTaint.addTaint(featureId);
        //Begin case Window.FEATURE_OPTIONS_PANEL 
        mFragments.dispatchOptionsMenuClosed(menu);
        //End case Window.FEATURE_OPTIONS_PANEL 
        //Begin case Window.FEATURE_OPTIONS_PANEL 
        onOptionsMenuClosed(menu);
        //End case Window.FEATURE_OPTIONS_PANEL 
        //Begin case Window.FEATURE_CONTEXT_MENU 
        onContextMenuClosed(menu);
        //End case Window.FEATURE_CONTEXT_MENU 
        //Begin case Window.FEATURE_ACTION_BAR 
        initActionBar();
        //End case Window.FEATURE_ACTION_BAR 
        //Begin case Window.FEATURE_ACTION_BAR 
        mActionBar.dispatchMenuVisibilityChanged(false);
        //End case Window.FEATURE_ACTION_BAR 
        // ---------- Original Method ----------
        //switch (featureId) {
            //case Window.FEATURE_OPTIONS_PANEL:
                //mFragments.dispatchOptionsMenuClosed(menu);
                //onOptionsMenuClosed(menu);
                //break;
            //case Window.FEATURE_CONTEXT_MENU:
                //onContextMenuClosed(menu);
                //break;
            //case Window.FEATURE_ACTION_BAR:
                //initActionBar();
                //mActionBar.dispatchMenuVisibilityChanged(false);
                //break;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.775 -0400", hash_original_method = "319389EBA801B290FB41D02473EB2E9E", hash_generated_method = "3B7DE101242C5001DBDB882784A7446C")
    @DSModeled(DSC.SAFE)
    public void invalidateOptionsMenu() {
        mWindow.invalidatePanelMenu(Window.FEATURE_OPTIONS_PANEL);
        // ---------- Original Method ----------
        //mWindow.invalidatePanelMenu(Window.FEATURE_OPTIONS_PANEL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.776 -0400", hash_original_method = "D798A5E9CBD6E094B476E3BCFB506C48", hash_generated_method = "2F7F85CA76CF60CC6B39A662ECAF07E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onCreateOptionsMenu(Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(menu.dsTaint);
        {
            boolean varF935B90ABE5131DCB630E9E27DC64FE3_1657610368 = (mParent.onCreateOptionsMenu(menu));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mParent != null) {
            //return mParent.onCreateOptionsMenu(menu);
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.777 -0400", hash_original_method = "E91DC6A73B73F0C36C3453FFD6D52B27", hash_generated_method = "FF1763945F5D5EFF7CE32B29DEC7FAAB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onPrepareOptionsMenu(Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(menu.dsTaint);
        {
            boolean varAAB92CF1F1A4A0A344E7476B2B22B35C_272810086 = (mParent.onPrepareOptionsMenu(menu));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mParent != null) {
            //return mParent.onPrepareOptionsMenu(menu);
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.777 -0400", hash_original_method = "3F90928280ED0097B9620B898E691C1D", hash_generated_method = "A01F90958B8AD4AC8B65568718300A96")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onOptionsItemSelected(MenuItem item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(item.dsTaint);
        {
            boolean var47DFB44A8390EC1DC29AA40E602F6D38_794405820 = (mParent.onOptionsItemSelected(item));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mParent != null) {
            //return mParent.onOptionsItemSelected(item);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.778 -0400", hash_original_method = "F56CDE64C3E3D8A72B60F2808B2AA992", hash_generated_method = "E9B036797B3E5B4DABCEA001F4B353CC")
    @DSModeled(DSC.SAFE)
    public void onOptionsMenuClosed(Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(menu.dsTaint);
        {
            mParent.onOptionsMenuClosed(menu);
        } //End block
        // ---------- Original Method ----------
        //if (mParent != null) {
            //mParent.onOptionsMenuClosed(menu);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.778 -0400", hash_original_method = "756759165F6AB2C8C6E469E63BE14186", hash_generated_method = "C5E1420A924619BD7FCF42769B926EC3")
    @DSModeled(DSC.SAFE)
    public void openOptionsMenu() {
        mWindow.openPanel(Window.FEATURE_OPTIONS_PANEL, null);
        // ---------- Original Method ----------
        //mWindow.openPanel(Window.FEATURE_OPTIONS_PANEL, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.779 -0400", hash_original_method = "D12ED1735BBB9BCDCD831C99F03640D7", hash_generated_method = "C293EABC3EADEC19F8893BAA898F2287")
    @DSModeled(DSC.SAFE)
    public void closeOptionsMenu() {
        mWindow.closePanel(Window.FEATURE_OPTIONS_PANEL);
        // ---------- Original Method ----------
        //mWindow.closePanel(Window.FEATURE_OPTIONS_PANEL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.779 -0400", hash_original_method = "85F2A519B2781A30F4BC68DB47459C98", hash_generated_method = "A9507FF45074975C3CAE4CED12E5ABE8")
    @DSModeled(DSC.SAFE)
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(v.dsTaint);
        dsTaint.addTaint(menuInfo.dsTaint);
        dsTaint.addTaint(menu.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.780 -0400", hash_original_method = "1A123249F7C2C892EA53E2F44D60C1FB", hash_generated_method = "D5AEBE7AEEC7D3E3B101DF78C9A3E75E")
    @DSModeled(DSC.SAFE)
    public void registerForContextMenu(View view) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(view.dsTaint);
        view.setOnCreateContextMenuListener(this);
        // ---------- Original Method ----------
        //view.setOnCreateContextMenuListener(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.780 -0400", hash_original_method = "6A7E2B106BB1CEE7C3B668A773DE5A5B", hash_generated_method = "4D9E35D385EF9B5B213AA7FF4E0572BB")
    @DSModeled(DSC.SAFE)
    public void unregisterForContextMenu(View view) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(view.dsTaint);
        view.setOnCreateContextMenuListener(null);
        // ---------- Original Method ----------
        //view.setOnCreateContextMenuListener(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.781 -0400", hash_original_method = "D1451DBD5DFD14FAE397660897192E3C", hash_generated_method = "42C797A24C9EE1616F70442E1C396D9D")
    @DSModeled(DSC.SAFE)
    public void openContextMenu(View view) {
        dsTaint.addTaint(view.dsTaint);
        view.showContextMenu();
        // ---------- Original Method ----------
        //view.showContextMenu();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.781 -0400", hash_original_method = "0F5BE8719D80390C88A4C0CDCF0E8C81", hash_generated_method = "D556392414203E3D31C1E65B78BC9F65")
    @DSModeled(DSC.SAFE)
    public void closeContextMenu() {
        mWindow.closePanel(Window.FEATURE_CONTEXT_MENU);
        // ---------- Original Method ----------
        //mWindow.closePanel(Window.FEATURE_CONTEXT_MENU);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.782 -0400", hash_original_method = "BE982B537DFF57F9B4E6459A3621A4C0", hash_generated_method = "2F722AD260941D231A6C3E1F74205CDF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onContextItemSelected(MenuItem item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(item.dsTaint);
        {
            boolean var7ECF1B2F229D5634CCEBD2144EC86F5A_1942142044 = (mParent.onContextItemSelected(item));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mParent != null) {
            //return mParent.onContextItemSelected(item);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.782 -0400", hash_original_method = "3B89231032C2ACDB0A53B5E9B36C3177", hash_generated_method = "F69866D19985FC3A2A886099E120AC81")
    @DSModeled(DSC.SAFE)
    public void onContextMenuClosed(Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(menu.dsTaint);
        {
            mParent.onContextMenuClosed(menu);
        } //End block
        // ---------- Original Method ----------
        //if (mParent != null) {
            //mParent.onContextMenuClosed(menu);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.783 -0400", hash_original_method = "5C4ABBE5E4F27E10ACC00467798D80D8", hash_generated_method = "63858064271A1EDF4CD81CAC4AB9C98A")
    @DSModeled(DSC.SAFE)
    @Deprecated
    protected Dialog onCreateDialog(int id) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(id);
        return (Dialog)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.783 -0400", hash_original_method = "34E3D2628A4C0BFC6C20A449A8141897", hash_generated_method = "65DD877821BDF9278170794B604AAA62")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    protected Dialog onCreateDialog(int id, Bundle args) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(id);
        dsTaint.addTaint(args.dsTaint);
        Dialog varCADCDC5C21D1D61CFDEE7014260361F5_555550458 = (onCreateDialog(id));
        return (Dialog)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return onCreateDialog(id);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.784 -0400", hash_original_method = "7779942926F36CBECCFB305682D0E188", hash_generated_method = "AE4BC73A7BB3C92997CE8B2CCF2C0242")
    @DSModeled(DSC.SAFE)
    @Deprecated
    protected void onPrepareDialog(int id, Dialog dialog) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(id);
        dsTaint.addTaint(dialog.dsTaint);
        dialog.setOwnerActivity(this);
        // ---------- Original Method ----------
        //dialog.setOwnerActivity(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.784 -0400", hash_original_method = "5C5331293ECB563ADEBB709047E6FA90", hash_generated_method = "9C7E7AAD7FA588822F32145C62B8A0A9")
    @DSModeled(DSC.SAFE)
    @Deprecated
    protected void onPrepareDialog(int id, Dialog dialog, Bundle args) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(id);
        dsTaint.addTaint(args.dsTaint);
        dsTaint.addTaint(dialog.dsTaint);
        onPrepareDialog(id, dialog);
        // ---------- Original Method ----------
        //onPrepareDialog(id, dialog);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.785 -0400", hash_original_method = "C69337B465910082B7749F46A60AEA22", hash_generated_method = "851FB08E52D1CCD1D78CFE9027FC025C")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public final void showDialog(int id) {
        dsTaint.addTaint(id);
        showDialog(id, null);
        // ---------- Original Method ----------
        //showDialog(id, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.786 -0400", hash_original_method = "3DD1E3020EFCD44C0CA311C29E1CC42D", hash_generated_method = "43D6B81ABD9E7A9D63D9763F53D1C4AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public final boolean showDialog(int id, Bundle args) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(args.dsTaint);
        {
            mManagedDialogs = new SparseArray<ManagedDialog>();
        } //End block
        ManagedDialog md;
        md = mManagedDialogs.get(id);
        {
            md = new ManagedDialog();
            md.mDialog = createDialog(id, null, args);
            mManagedDialogs.put(id, md);
        } //End block
        md.mArgs = args;
        onPrepareDialog(id, md.mDialog, args);
        md.mDialog.show();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mManagedDialogs == null) {
            //mManagedDialogs = new SparseArray<ManagedDialog>();
        //}
        //ManagedDialog md = mManagedDialogs.get(id);
        //if (md == null) {
            //md = new ManagedDialog();
            //md.mDialog = createDialog(id, null, args);
            //if (md.mDialog == null) {
                //return false;
            //}
            //mManagedDialogs.put(id, md);
        //}
        //md.mArgs = args;
        //onPrepareDialog(id, md.mDialog, args);
        //md.mDialog.show();
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.786 -0400", hash_original_method = "E601E473B0753C1FEDA76812E1FD9E58", hash_generated_method = "B7E122B9FE022C65152CE63DB057925F")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public final void dismissDialog(int id) {
        dsTaint.addTaint(id);
        {
            throw missingDialog(id);
        } //End block
        final ManagedDialog md;
        md = mManagedDialogs.get(id);
        {
            throw missingDialog(id);
        } //End block
        md.mDialog.dismiss();
        // ---------- Original Method ----------
        //if (mManagedDialogs == null) {
            //throw missingDialog(id);
        //}
        //final ManagedDialog md = mManagedDialogs.get(id);
        //if (md == null) {
            //throw missingDialog(id);
        //}
        //md.mDialog.dismiss();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.787 -0400", hash_original_method = "A39236F46CF5FE1491F0C82DFDF249BB", hash_generated_method = "FBB10ABCB2A68989BC29827A90617BC5")
    @DSModeled(DSC.SAFE)
    private IllegalArgumentException missingDialog(int id) {
        dsTaint.addTaint(id);
        return (IllegalArgumentException)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new IllegalArgumentException("no dialog with id " + id + " was ever "
                //+ "shown via Activity#showDialog");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.788 -0400", hash_original_method = "3D1D9959965F7A331D31AA1B43803DC2", hash_generated_method = "7349F4B165A9563EB53C766D75D3ACA6")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public final void removeDialog(int id) {
        dsTaint.addTaint(id);
        {
            final ManagedDialog md;
            md = mManagedDialogs.get(id);
            {
                md.mDialog.dismiss();
                mManagedDialogs.remove(id);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mManagedDialogs != null) {
            //final ManagedDialog md = mManagedDialogs.get(id);
            //if (md != null) {
                //md.mDialog.dismiss();
                //mManagedDialogs.remove(id);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.788 -0400", hash_original_method = "0DF3BA4E928401133F2B75C6B5EB4631", hash_generated_method = "9782F1A4620012F0FF61E3714D226CC9")
    @DSModeled(DSC.SAFE)
    public boolean onSearchRequested() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        startSearch(null, false, null, false);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //startSearch(null, false, null, false);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.789 -0400", hash_original_method = "E294F26A29AF2F9D8B2D38BC4A0138F5", hash_generated_method = "0F79E0B36DBC5731D7DC8875DC3EAD94")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void startSearch(String initialQuery, boolean selectInitialQuery, 
            Bundle appSearchData, boolean globalSearch) {
        dsTaint.addTaint(globalSearch);
        dsTaint.addTaint(appSearchData.dsTaint);
        dsTaint.addTaint(selectInitialQuery);
        dsTaint.addTaint(initialQuery);
        ensureSearchManager();
        mSearchManager.startSearch(initialQuery, selectInitialQuery, getComponentName(),
                        appSearchData, globalSearch);
        // ---------- Original Method ----------
        //ensureSearchManager();
        //mSearchManager.startSearch(initialQuery, selectInitialQuery, getComponentName(),
                        //appSearchData, globalSearch);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.789 -0400", hash_original_method = "A3EE90277ACB35FF640742FD629291A1", hash_generated_method = "BB20BA13144C3A27C2B2F4A81237BFFB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void triggerSearch(String query, Bundle appSearchData) {
        dsTaint.addTaint(appSearchData.dsTaint);
        dsTaint.addTaint(query);
        ensureSearchManager();
        mSearchManager.triggerSearch(query, getComponentName(), appSearchData);
        // ---------- Original Method ----------
        //ensureSearchManager();
        //mSearchManager.triggerSearch(query, getComponentName(), appSearchData);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.790 -0400", hash_original_method = "0192041795732D663EE503A2AEC04112", hash_generated_method = "FBFF2B3752CCA4B059AD30EA5F913158")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void takeKeyEvents(boolean get) {
        dsTaint.addTaint(get);
        getWindow().takeKeyEvents(get);
        // ---------- Original Method ----------
        //getWindow().takeKeyEvents(get);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.790 -0400", hash_original_method = "3CDF417FCD4F33EAE6CFCF0FB6D583A8", hash_generated_method = "72F57E4438E50562A60FF066B6B3984A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean requestWindowFeature(int featureId) {
        dsTaint.addTaint(featureId);
        boolean varB82514052F40771017139C27F50D7D45_270381755 = (getWindow().requestFeature(featureId));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getWindow().requestFeature(featureId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.791 -0400", hash_original_method = "E7AFD534CB1DF8060614ED36111B2407", hash_generated_method = "AE2A3CD5F810F5101A122FDB79D1405C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setFeatureDrawableResource(int featureId, int resId) {
        dsTaint.addTaint(featureId);
        dsTaint.addTaint(resId);
        getWindow().setFeatureDrawableResource(featureId, resId);
        // ---------- Original Method ----------
        //getWindow().setFeatureDrawableResource(featureId, resId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.791 -0400", hash_original_method = "2E53659D6309BF8C5C8E8AD82BD6A577", hash_generated_method = "120A5780594DBF5623D7F9B160CF8F62")
    @DSModeled(DSC.SPEC)
    public final void setFeatureDrawableUri(int featureId, Uri uri) {
        dsTaint.addTaint(featureId);
        dsTaint.addTaint(uri.dsTaint);
        getWindow().setFeatureDrawableUri(featureId, uri);
        // ---------- Original Method ----------
        //getWindow().setFeatureDrawableUri(featureId, uri);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.792 -0400", hash_original_method = "D3FA0A5870730A6F3C959B16FC004BCD", hash_generated_method = "8AE8BFF4603816CA319428F6ACD8E111")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setFeatureDrawable(int featureId, Drawable drawable) {
        dsTaint.addTaint(featureId);
        dsTaint.addTaint(drawable.dsTaint);
        getWindow().setFeatureDrawable(featureId, drawable);
        // ---------- Original Method ----------
        //getWindow().setFeatureDrawable(featureId, drawable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.792 -0400", hash_original_method = "4D2A81FF8C2C83F47460DEB3120C04CB", hash_generated_method = "B796E379B5D7A6026F0198D5CFE3899E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setFeatureDrawableAlpha(int featureId, int alpha) {
        dsTaint.addTaint(alpha);
        dsTaint.addTaint(featureId);
        getWindow().setFeatureDrawableAlpha(featureId, alpha);
        // ---------- Original Method ----------
        //getWindow().setFeatureDrawableAlpha(featureId, alpha);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.793 -0400", hash_original_method = "2F200E491A9F2CDC38C392035D21ED48", hash_generated_method = "3628CBDFFB44997426E7F6356E58961E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LayoutInflater getLayoutInflater() {
        LayoutInflater var3465C34A946175F3636FF96D45866694_892541444 = (getWindow().getLayoutInflater());
        return (LayoutInflater)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getWindow().getLayoutInflater();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.793 -0400", hash_original_method = "E3707649B39EF110B7161F89DE89D715", hash_generated_method = "3FF9A93FC5775E4AD489E0F41EF2B7F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MenuInflater getMenuInflater() {
        {
            initActionBar();
            {
                mMenuInflater = new MenuInflater(mActionBar.getThemedContext());
            } //End block
            {
                mMenuInflater = new MenuInflater(this);
            } //End block
        } //End block
        return (MenuInflater)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mMenuInflater == null) {
            //initActionBar();
            //if (mActionBar != null) {
                //mMenuInflater = new MenuInflater(mActionBar.getThemedContext());
            //} else {
                //mMenuInflater = new MenuInflater(this);
            //}
        //}
        //return mMenuInflater;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.794 -0400", hash_original_method = "4857987668195170B5763D3AC5F48499", hash_generated_method = "E597A483BC82B2E9EF05BA1DBEA92D81")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onApplyThemeResource(Resources.Theme theme, int resid,
            boolean first) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(resid);
        dsTaint.addTaint(theme.dsTaint);
        dsTaint.addTaint(first);
        {
            super.onApplyThemeResource(theme, resid, first);
        } //End block
        {
            try 
            {
                theme.setTo(mParent.getTheme());
            } //End block
            catch (Exception e)
            { }
            theme.applyStyle(resid, false);
        } //End block
        // ---------- Original Method ----------
        //if (mParent == null) {
            //super.onApplyThemeResource(theme, resid, first);
        //} else {
            //try {
                //theme.setTo(mParent.getTheme());
            //} catch (Exception e) {
            //}
            //theme.applyStyle(resid, false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.795 -0400", hash_original_method = "30D6BE1E6EC7F84FBEF609A16BE7CA4B", hash_generated_method = "1C9D69DFD7AC9CB3E9582A46FE066675")
    @DSModeled(DSC.SPEC)
    public void startActivityForResult(Intent intent, int requestCode) {
        dsTaint.addTaint(requestCode);
        dsTaint.addTaint(intent.dsTaint);
        {
            Instrumentation.ActivityResult ar;
            ar = mInstrumentation.execStartActivity(
                    this, mMainThread.getApplicationThread(), mToken, this,
                    intent, requestCode);
            {
                mMainThread.sendActivityResult(
                    mToken, mEmbeddedID, requestCode, ar.getResultCode(),
                    ar.getResultData());
            } //End block
            {
                mStartedActivity = true;
            } //End block
        } //End block
        {
            mParent.startActivityFromChild(this, intent, requestCode);
        } //End block
        // ---------- Original Method ----------
        //if (mParent == null) {
            //Instrumentation.ActivityResult ar =
                //mInstrumentation.execStartActivity(
                    //this, mMainThread.getApplicationThread(), mToken, this,
                    //intent, requestCode);
            //if (ar != null) {
                //mMainThread.sendActivityResult(
                    //mToken, mEmbeddedID, requestCode, ar.getResultCode(),
                    //ar.getResultData());
            //}
            //if (requestCode >= 0) {
                //mStartedActivity = true;
            //}
        //} else {
            //mParent.startActivityFromChild(this, intent, requestCode);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.795 -0400", hash_original_method = "97600DFB6FE5B26D9938AA60DE8024CD", hash_generated_method = "8074EB1E90C11E5D00E5782F1E6D878E")
    @DSModeled(DSC.SPEC)
    public void startIntentSenderForResult(IntentSender intent, int requestCode,
            Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {
        dsTaint.addTaint(requestCode);
        dsTaint.addTaint(flagsMask);
        dsTaint.addTaint(flagsValues);
        dsTaint.addTaint(extraFlags);
        dsTaint.addTaint(intent.dsTaint);
        dsTaint.addTaint(fillInIntent.dsTaint);
        {
            startIntentSenderForResultInner(intent, requestCode, fillInIntent,
                    flagsMask, flagsValues, this);
        } //End block
        {
            mParent.startIntentSenderFromChild(this, intent, requestCode,
                    fillInIntent, flagsMask, flagsValues, extraFlags);
        } //End block
        // ---------- Original Method ----------
        //if (mParent == null) {
            //startIntentSenderForResultInner(intent, requestCode, fillInIntent,
                    //flagsMask, flagsValues, this);
        //} else {
            //mParent.startIntentSenderFromChild(this, intent, requestCode,
                    //fillInIntent, flagsMask, flagsValues, extraFlags);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.796 -0400", hash_original_method = "5FAE47F5C92447A2EE7F29A0B33663DC", hash_generated_method = "8D8CAE4174300A8D4814AA0FAB949CD9")
    @DSModeled(DSC.SPEC)
    private void startIntentSenderForResultInner(IntentSender intent, int requestCode,
            Intent fillInIntent, int flagsMask, int flagsValues, Activity activity) throws IntentSender.SendIntentException {
        dsTaint.addTaint(requestCode);
        dsTaint.addTaint(flagsMask);
        dsTaint.addTaint(flagsValues);
        dsTaint.addTaint(intent.dsTaint);
        dsTaint.addTaint(fillInIntent.dsTaint);
        dsTaint.addTaint(activity.dsTaint);
        try 
        {
            String resolvedType;
            resolvedType = null;
            {
                fillInIntent.setAllowFds(false);
                resolvedType = fillInIntent.resolveTypeIfNeeded(getContentResolver());
            } //End block
            int result;
            result = ActivityManagerNative.getDefault()
                .startActivityIntentSender(mMainThread.getApplicationThread(), intent,
                        fillInIntent, resolvedType, mToken, activity.mEmbeddedID,
                        requestCode, flagsMask, flagsValues);
            {
                throw new IntentSender.SendIntentException();
            } //End block
            Instrumentation.checkStartActivityResult(result, null);
        } //End block
        catch (RemoteException e)
        { }
        {
            mStartedActivity = true;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.797 -0400", hash_original_method = "496A47C2900A9596F27A50B4876A4F74", hash_generated_method = "309A794A338312805061E7F69660131A")
    @DSModeled(DSC.SPEC)
    @Override
    public void startActivity(Intent intent) {
        dsTaint.addTaint(intent.dsTaint);
        startActivityForResult(intent, -1);
        // ---------- Original Method ----------
        //startActivityForResult(intent, -1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.797 -0400", hash_original_method = "E2A55AFC4750254BD88786F18353EE8B", hash_generated_method = "0A6B40E40ED98284A8D42B02E76884B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void startActivities(Intent[] intents) {
        dsTaint.addTaint(intents.dsTaint);
        mInstrumentation.execStartActivities(this, mMainThread.getApplicationThread(),
                mToken, this, intents);
        // ---------- Original Method ----------
        //mInstrumentation.execStartActivities(this, mMainThread.getApplicationThread(),
                //mToken, this, intents);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.798 -0400", hash_original_method = "9F69F403C1C5722F41E10FF600B75C73", hash_generated_method = "D613D3CA455A673C3F48F50A4BE018A7")
    @DSModeled(DSC.SPEC)
    public void startIntentSender(IntentSender intent,
            Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {
        dsTaint.addTaint(flagsMask);
        dsTaint.addTaint(flagsValues);
        dsTaint.addTaint(extraFlags);
        dsTaint.addTaint(intent.dsTaint);
        dsTaint.addTaint(fillInIntent.dsTaint);
        startIntentSenderForResult(intent, -1, fillInIntent, flagsMask,
                flagsValues, extraFlags);
        // ---------- Original Method ----------
        //startIntentSenderForResult(intent, -1, fillInIntent, flagsMask,
                //flagsValues, extraFlags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.799 -0400", hash_original_method = "190134DCA27346A23C03C3693BD2B9AA", hash_generated_method = "94F6B9846BB96F821BA41538F6270085")
    @DSModeled(DSC.SPEC)
    public boolean startActivityIfNeeded(Intent intent, int requestCode) {
        dsTaint.addTaint(requestCode);
        dsTaint.addTaint(intent.dsTaint);
        {
            int result;
            result = IActivityManager.START_RETURN_INTENT_TO_CALLER;
            try 
            {
                intent.setAllowFds(false);
                result = ActivityManagerNative.getDefault()
                    .startActivity(mMainThread.getApplicationThread(),
                            intent, intent.resolveTypeIfNeeded(
                                    getContentResolver()),
                            null, 0,
                            mToken, mEmbeddedID, requestCode, true, false,
                            null, null, false);
            } //End block
            catch (RemoteException e)
            { }
            Instrumentation.checkStartActivityResult(result, intent);
            {
                mStartedActivity = true;
            } //End block
        } //End block
        throw new UnsupportedOperationException(
            "startActivityIfNeeded can only be called from a top-level activity");
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.800 -0400", hash_original_method = "BA57A0705EEE92F3B7079102E9F6CF18", hash_generated_method = "DCA52F1EFC541039FA77D2089055A86B")
    @DSModeled(DSC.SPEC)
    public boolean startNextMatchingActivity(Intent intent) {
        dsTaint.addTaint(intent.dsTaint);
        {
            try 
            {
                intent.setAllowFds(false);
                boolean var48E21F8A126EF0CF3E2826B5E3578F5C_1878231765 = (ActivityManagerNative.getDefault()
                    .startNextMatchingActivity(mToken, intent));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        throw new UnsupportedOperationException(
            "startNextMatchingActivity can only be called from a top-level activity");
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mParent == null) {
            //try {
                //intent.setAllowFds(false);
                //return ActivityManagerNative.getDefault()
                    //.startNextMatchingActivity(mToken, intent);
            //} catch (RemoteException e) {
            //}
            //return false;
        //}
        //throw new UnsupportedOperationException(
            //"startNextMatchingActivity can only be called from a top-level activity");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.800 -0400", hash_original_method = "DF04C3C173E07E956B29F2B3DAB7E481", hash_generated_method = "D9D59CB0820E3BB0F785C2E851D14E0F")
    @DSModeled(DSC.SPEC)
    public void startActivityFromChild(Activity child, Intent intent, 
            int requestCode) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(requestCode);
        dsTaint.addTaint(intent.dsTaint);
        Instrumentation.ActivityResult ar;
        ar = mInstrumentation.execStartActivity(
                this, mMainThread.getApplicationThread(), mToken, child,
                intent, requestCode);
        {
            mMainThread.sendActivityResult(
                mToken, child.mEmbeddedID, requestCode,
                ar.getResultCode(), ar.getResultData());
        } //End block
        // ---------- Original Method ----------
        //Instrumentation.ActivityResult ar =
            //mInstrumentation.execStartActivity(
                //this, mMainThread.getApplicationThread(), mToken, child,
                //intent, requestCode);
        //if (ar != null) {
            //mMainThread.sendActivityResult(
                //mToken, child.mEmbeddedID, requestCode,
                //ar.getResultCode(), ar.getResultData());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.801 -0400", hash_original_method = "5E733A6053D527FE1D06898E4868AC5B", hash_generated_method = "F215C029F763A0518721309BCC888ED5")
    @DSModeled(DSC.SPEC)
    public void startActivityFromFragment(Fragment fragment, Intent intent, 
            int requestCode) {
        dsTaint.addTaint(requestCode);
        dsTaint.addTaint(fragment.dsTaint);
        dsTaint.addTaint(intent.dsTaint);
        Instrumentation.ActivityResult ar;
        ar = mInstrumentation.execStartActivity(
                this, mMainThread.getApplicationThread(), mToken, fragment,
                intent, requestCode);
        {
            mMainThread.sendActivityResult(
                mToken, fragment.mWho, requestCode,
                ar.getResultCode(), ar.getResultData());
        } //End block
        // ---------- Original Method ----------
        //Instrumentation.ActivityResult ar =
            //mInstrumentation.execStartActivity(
                //this, mMainThread.getApplicationThread(), mToken, fragment,
                //intent, requestCode);
        //if (ar != null) {
            //mMainThread.sendActivityResult(
                //mToken, fragment.mWho, requestCode,
                //ar.getResultCode(), ar.getResultData());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.802 -0400", hash_original_method = "39BD7073F28230B53A756B456127D77C", hash_generated_method = "C707123F738F432667E2893EE1398163")
    @DSModeled(DSC.SPEC)
    public void startIntentSenderFromChild(Activity child, IntentSender intent,
            int requestCode, Intent fillInIntent, int flagsMask, int flagsValues,
            int extraFlags) throws IntentSender.SendIntentException {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(requestCode);
        dsTaint.addTaint(flagsMask);
        dsTaint.addTaint(flagsValues);
        dsTaint.addTaint(extraFlags);
        dsTaint.addTaint(intent.dsTaint);
        dsTaint.addTaint(fillInIntent.dsTaint);
        startIntentSenderForResultInner(intent, requestCode, fillInIntent,
                flagsMask, flagsValues, child);
        // ---------- Original Method ----------
        //startIntentSenderForResultInner(intent, requestCode, fillInIntent,
                //flagsMask, flagsValues, child);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.802 -0400", hash_original_method = "0CB07497B5E56C46E5A71AB5CB4CC143", hash_generated_method = "510F244B37F20011EF222DDE0A9964B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void overridePendingTransition(int enterAnim, int exitAnim) {
        dsTaint.addTaint(exitAnim);
        dsTaint.addTaint(enterAnim);
        try 
        {
            ActivityManagerNative.getDefault().overridePendingTransition(
                    mToken, getPackageName(), enterAnim, exitAnim);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //ActivityManagerNative.getDefault().overridePendingTransition(
                    //mToken, getPackageName(), enterAnim, exitAnim);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.803 -0400", hash_original_method = "A1F0E9D1C51A75D776561E1E894349B6", hash_generated_method = "6D9863E480EBEDF0B0EE1413B569A258")
    @DSModeled(DSC.SAFE)
    public final void setResult(int resultCode) {
        dsTaint.addTaint(resultCode);
        {
            mResultData = null;
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //mResultCode = resultCode;
            //mResultData = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.803 -0400", hash_original_method = "6BED503DFB65A20EFD511A0C71BBBEA5", hash_generated_method = "32A5EEE09C95928B9A9E01B4E23CEDAF")
    @DSModeled(DSC.SPEC)
    public final void setResult(int resultCode, Intent data) {
        dsTaint.addTaint(resultCode);
        dsTaint.addTaint(data.dsTaint);
        // ---------- Original Method ----------
        //synchronized (this) {
            //mResultCode = resultCode;
            //mResultData = data;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.804 -0400", hash_original_method = "88476E01B039440C5805C3F210A00F20", hash_generated_method = "B45D38C647770251B03EE525534E1498")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getCallingPackage() {
        try 
        {
            String varE59521CC38195B8E76AF09771DC5BC84_946712936 = (ActivityManagerNative.getDefault().getCallingPackage(mToken));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().getCallingPackage(mToken);
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.805 -0400", hash_original_method = "BA5844B2C9F3C6D12393731B7AECDFB9", hash_generated_method = "2EF642CDC77F98C5E16FA803557292AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ComponentName getCallingActivity() {
        try 
        {
            ComponentName var7BF8A3B200F3F0D1C3E27AB9F5DD22C6_579815384 = (ActivityManagerNative.getDefault().getCallingActivity(mToken));
        } //End block
        catch (RemoteException e)
        { }
        return (ComponentName)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().getCallingActivity(mToken);
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.805 -0400", hash_original_method = "0E2F74853BCADD728740841EA37367F9", hash_generated_method = "939C81944FFCCC6994D8DA47C04D12B3")
    @DSModeled(DSC.SAFE)
    public void setVisible(boolean visible) {
        dsTaint.addTaint(visible);
        {
            {
                makeVisible();
                mDecor.setVisibility(View.INVISIBLE);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mVisibleFromClient != visible) {
            //mVisibleFromClient = visible;
            //if (mVisibleFromServer) {
                //if (visible) makeVisible();
                //else mDecor.setVisibility(View.INVISIBLE);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.806 -0400", hash_original_method = "FB761D67DEFD95C853371C7404DC7410", hash_generated_method = "90478E35DAA72DD1B32BEB6D41823629")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void makeVisible() {
        {
            ViewManager wm;
            wm = getWindowManager();
            wm.addView(mDecor, getWindow().getAttributes());
            mWindowAdded = true;
        } //End block
        mDecor.setVisibility(View.VISIBLE);
        // ---------- Original Method ----------
        //if (!mWindowAdded) {
            //ViewManager wm = getWindowManager();
            //wm.addView(mDecor, getWindow().getAttributes());
            //mWindowAdded = true;
        //}
        //mDecor.setVisibility(View.VISIBLE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.806 -0400", hash_original_method = "43D5EE376AB6A31BE07F9DEA063A3A15", hash_generated_method = "D740F94768B3FF18AE292D6E1996837E")
    @DSModeled(DSC.SAFE)
    public boolean isFinishing() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mFinished;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.807 -0400", hash_original_method = "FE2E80A11740332998069879BC688861", hash_generated_method = "466E0D31A69D4FAC27CB68CA7BBF267A")
    @DSModeled(DSC.SAFE)
    public boolean isChangingConfigurations() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mChangingConfigurations;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.807 -0400", hash_original_method = "3298831B26ECD21F1FDB51A320DC7BE6", hash_generated_method = "C1F75DED86FC9E6C15652ADD3DDAEA4F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void recreate() {
        {
            throw new IllegalStateException("Can only be called on top-level activity");
        } //End block
        {
            boolean var61A058F6D0650572B0637A5D7A729D5C_929062422 = (Looper.myLooper() != mMainThread.getLooper());
            {
                throw new IllegalStateException("Must be called from main thread");
            } //End block
        } //End collapsed parenthetic
        mMainThread.requestRelaunchActivity(mToken, null, null, 0, false, null, false);
        // ---------- Original Method ----------
        //if (mParent != null) {
            //throw new IllegalStateException("Can only be called on top-level activity");
        //}
        //if (Looper.myLooper() != mMainThread.getLooper()) {
            //throw new IllegalStateException("Must be called from main thread");
        //}
        //mMainThread.requestRelaunchActivity(mToken, null, null, 0, false, null, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.809 -0400", hash_original_method = "996A5282391C6D355ADB156CA1D0ED89", hash_generated_method = "75B54E22DBA025055E7E294F4EE15B07")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void finish() {
        {
            int resultCode;
            Intent resultData;
            {
                resultCode = mResultCode;
                resultData = mResultData;
            } //End block
            try 
            {
                {
                    resultData.setAllowFds(false);
                } //End block
                {
                    boolean var98DEA089FC32BBD5488A00FF4FF0CC1E_385425380 = (ActivityManagerNative.getDefault()
                    .finishActivity(mToken, resultCode, resultData));
                    {
                        mFinished = true;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        {
            mParent.finishFromChild(this);
        } //End block
        // ---------- Original Method ----------
        //if (mParent == null) {
            //int resultCode;
            //Intent resultData;
            //synchronized (this) {
                //resultCode = mResultCode;
                //resultData = mResultData;
            //}
            //if (false) Log.v(TAG, "Finishing self: token=" + mToken);
            //try {
                //if (resultData != null) {
                    //resultData.setAllowFds(false);
                //}
                //if (ActivityManagerNative.getDefault()
                    //.finishActivity(mToken, resultCode, resultData)) {
                    //mFinished = true;
                //}
            //} catch (RemoteException e) {
            //}
        //} else {
            //mParent.finishFromChild(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.809 -0400", hash_original_method = "75F7E4E1E03EB9263BD8694C580B708B", hash_generated_method = "F9135AAE42E430C495FD348B1A6691DF")
    @DSModeled(DSC.SAFE)
    public void finishFromChild(Activity child) {
        dsTaint.addTaint(child.dsTaint);
        finish();
        // ---------- Original Method ----------
        //finish();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.810 -0400", hash_original_method = "5ADA8FCD727B0FDDA383F561FB00E0D6", hash_generated_method = "3C652A6A4C3BD16031292689BF455E12")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void finishActivity(int requestCode) {
        dsTaint.addTaint(requestCode);
        {
            try 
            {
                ActivityManagerNative.getDefault()
                    .finishSubActivity(mToken, mEmbeddedID, requestCode);
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        {
            mParent.finishActivityFromChild(this, requestCode);
        } //End block
        // ---------- Original Method ----------
        //if (mParent == null) {
            //try {
                //ActivityManagerNative.getDefault()
                    //.finishSubActivity(mToken, mEmbeddedID, requestCode);
            //} catch (RemoteException e) {
            //}
        //} else {
            //mParent.finishActivityFromChild(this, requestCode);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.810 -0400", hash_original_method = "78F43A087FD65470CED68BD5979667B7", hash_generated_method = "969F4EE9D4CDC9A2655AD2D3D5B57007")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void finishActivityFromChild(Activity child, int requestCode) {
        dsTaint.addTaint(child.dsTaint);
        dsTaint.addTaint(requestCode);
        try 
        {
            ActivityManagerNative.getDefault()
                .finishSubActivity(mToken, child.mEmbeddedID, requestCode);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //ActivityManagerNative.getDefault()
                //.finishSubActivity(mToken, child.mEmbeddedID, requestCode);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.811 -0400", hash_original_method = "6D8F676326F7C192A2903AC6F4C36AC9", hash_generated_method = "42713E1EF57290E674D088FDDC7B93B3")
    @DSModeled(DSC.SPEC)
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(requestCode);
        dsTaint.addTaint(resultCode);
        dsTaint.addTaint(data.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.811 -0400", hash_original_method = "724A566EB4440BBE32F479663ADACFA1", hash_generated_method = "EC306DC17EC498ABB91E831ACF2D9B83")
    @DSModeled(DSC.SPEC)
    public PendingIntent createPendingResult(int requestCode, Intent data,
            int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(requestCode);
        dsTaint.addTaint(data.dsTaint);
        String packageName;
        packageName = getPackageName();
        try 
        {
            data.setAllowFds(false);
            IIntentSender target;
            target = ActivityManagerNative.getDefault().getIntentSender(
                        IActivityManager.INTENT_SENDER_ACTIVITY_RESULT, packageName,
                        mParent == null ? mToken : mParent.mToken,
                        mEmbeddedID, requestCode, new Intent[] { data }, null, flags);//DSFIXME:  CODE0008: Nested ternary operator in expression
        } //End block
        catch (RemoteException e)
        { }
        return (PendingIntent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //String packageName = getPackageName();
        //try {
            //data.setAllowFds(false);
            //IIntentSender target =
                //ActivityManagerNative.getDefault().getIntentSender(
                        //IActivityManager.INTENT_SENDER_ACTIVITY_RESULT, packageName,
                        //mParent == null ? mToken : mParent.mToken,
                        //mEmbeddedID, requestCode, new Intent[] { data }, null, flags);
            //return target != null ? new PendingIntent(target) : null;
        //} catch (RemoteException e) {
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.812 -0400", hash_original_method = "AB602316CD63B19CFF08DCE67D0ABE67", hash_generated_method = "8667988CA258A09B34BD97822C674397")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setRequestedOrientation(int requestedOrientation) {
        dsTaint.addTaint(requestedOrientation);
        {
            try 
            {
                ActivityManagerNative.getDefault().setRequestedOrientation(
                        mToken, requestedOrientation);
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        {
            mParent.setRequestedOrientation(requestedOrientation);
        } //End block
        // ---------- Original Method ----------
        //if (mParent == null) {
            //try {
                //ActivityManagerNative.getDefault().setRequestedOrientation(
                        //mToken, requestedOrientation);
            //} catch (RemoteException e) {
            //}
        //} else {
            //mParent.setRequestedOrientation(requestedOrientation);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.813 -0400", hash_original_method = "DB34404EF91E1F4006BE0A78903A055D", hash_generated_method = "F78C843A25F392BC35A3E7B2A9B41917")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getRequestedOrientation() {
        {
            try 
            {
                int varF73A2C1D42F32A8E880FEE19D43552B0_453559359 = (ActivityManagerNative.getDefault()
                        .getRequestedOrientation(mToken));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        {
            int var6BA699CCE9FE9ECEB5C2EB944481D0CA_1651042976 = (mParent.getRequestedOrientation());
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mParent == null) {
            //try {
                //return ActivityManagerNative.getDefault()
                        //.getRequestedOrientation(mToken);
            //} catch (RemoteException e) {
            //}
        //} else {
            //return mParent.getRequestedOrientation();
        //}
        //return ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.813 -0400", hash_original_method = "617D78E91C885EF783A85ACE788D978C", hash_generated_method = "791D8DDEEE98E92C3DC675D4F955EC9C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getTaskId() {
        try 
        {
            int varB14910B437D45BFD02C50351FBFB3D89_431948208 = (ActivityManagerNative.getDefault()
                .getTaskForActivity(mToken, false));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault()
                //.getTaskForActivity(mToken, false);
        //} catch (RemoteException e) {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.814 -0400", hash_original_method = "6E45F873D7236EF61D26B672F842F45F", hash_generated_method = "F4C1A7F8EC5E19D1AC374C7B427F3A45")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isTaskRoot() {
        try 
        {
            boolean var4B80DC96910152E8758D098D1964B8FB_1229819426 = (ActivityManagerNative.getDefault()
                .getTaskForActivity(mToken, true) >= 0);
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault()
                //.getTaskForActivity(mToken, true) >= 0;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.815 -0400", hash_original_method = "9A59EFD62BA4B2B1BB27D9BF60C81F37", hash_generated_method = "6711DF7C0DB20F82D47CB3808312D3CC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean moveTaskToBack(boolean nonRoot) {
        dsTaint.addTaint(nonRoot);
        try 
        {
            boolean var098F37A659AB56219B499ADFB5DCEEF7_1731429860 = (ActivityManagerNative.getDefault().moveActivityTaskToBack(
                    mToken, nonRoot));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().moveActivityTaskToBack(
                    //mToken, nonRoot);
        //} catch (RemoteException e) {
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.816 -0400", hash_original_method = "551AAFB8F3EA920969607A2C223A3A3A", hash_generated_method = "D3446612A2E3992115B867ADA03C0255")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getLocalClassName() {
        final String pkg;
        pkg = getPackageName();
        final String cls;
        cls = mComponent.getClassName();
        int packageLen;
        packageLen = pkg.length();
        {
            boolean var0EAAC10B288339C1570AA8AB20356E7A_460919265 = (!cls.startsWith(pkg) || cls.length() <= packageLen
                || cls.charAt(packageLen) != '.');
        } //End collapsed parenthetic
        String varF471B88E7B282AE8DF0B110A2C04A621_1823234925 = (cls.substring(packageLen+1));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //final String pkg = getPackageName();
        //final String cls = mComponent.getClassName();
        //int packageLen = pkg.length();
        //if (!cls.startsWith(pkg) || cls.length() <= packageLen
                //|| cls.charAt(packageLen) != '.') {
            //return cls;
        //}
        //return cls.substring(packageLen+1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.816 -0400", hash_original_method = "6C1D36E28C0C97736EA4779A7FB1715C", hash_generated_method = "2AB623F2A00779F213CEA55B54586301")
    @DSModeled(DSC.SAFE)
    public ComponentName getComponentName() {
        return (ComponentName)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mComponent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.817 -0400", hash_original_method = "8FF11253989B916424A8F19A417B9894", hash_generated_method = "B44AF6DCCC3B768B8F2B998B04C41E81")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SharedPreferences getPreferences(int mode) {
        dsTaint.addTaint(mode);
        SharedPreferences varC61923A749CAFF821EBC5C1DD5CA84B2_2072786509 = (getSharedPreferences(getLocalClassName(), mode));
        return (SharedPreferences)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getSharedPreferences(getLocalClassName(), mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.817 -0400", hash_original_method = "4647E231E061B70291C2AAA883C4D14E", hash_generated_method = "769F3B480B0FBCCE4865A86068DEC7E5")
    @DSModeled(DSC.SAFE)
    private void ensureSearchManager() {
        mSearchManager = new SearchManager(this, null);
        // ---------- Original Method ----------
        //if (mSearchManager != null) {
            //return;
        //}
        //mSearchManager = new SearchManager(this, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.818 -0400", hash_original_method = "C911C3513CF522AB406EF738AFCD068D", hash_generated_method = "81E49B4B42EF4E8E4049E6C24F05BA68")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object getSystemService(String name) {
        dsTaint.addTaint(name);
        {
            boolean var147AC2BBBF3AEE182DB26FB40142700F_893478202 = (getBaseContext() == null);
            {
                throw new IllegalStateException(
                    "System services not available to Activities before onCreate()");
            } //End block
        } //End collapsed parenthetic
        {
            boolean var1CCF0F4FD95ED5B34F2142B4928344D1_705991019 = (WINDOW_SERVICE.equals(name));
            {
                boolean var2768C019CA3E7B10A866FFEC217F769C_1887808210 = (SEARCH_SERVICE.equals(name));
                {
                    ensureSearchManager();
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        Object varF71AC18101D74F10400EFC571ABECEF6_1417034023 = (super.getSystemService(name));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (getBaseContext() == null) {
            //throw new IllegalStateException(
                    //"System services not available to Activities before onCreate()");
        //}
        //if (WINDOW_SERVICE.equals(name)) {
            //return mWindowManager;
        //} else if (SEARCH_SERVICE.equals(name)) {
            //ensureSearchManager();
            //return mSearchManager;
        //}
        //return super.getSystemService(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.819 -0400", hash_original_method = "917DB493889E2A2E4400765775D2C5BF", hash_generated_method = "F59334A29EBCFF65502029EAE5FA19B9")
    @DSModeled(DSC.SAFE)
    public void setTitle(CharSequence title) {
        dsTaint.addTaint(title);
        onTitleChanged(title, mTitleColor);
        {
            mParent.onChildTitleChanged(this, title);
        } //End block
        // ---------- Original Method ----------
        //mTitle = title;
        //onTitleChanged(title, mTitleColor);
        //if (mParent != null) {
            //mParent.onChildTitleChanged(this, title);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.819 -0400", hash_original_method = "A39F8277E51A7F6BD4A471D6255FEBC5", hash_generated_method = "47A358A0BEEFACDBEA6EB75A9ADB6142")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTitle(int titleId) {
        dsTaint.addTaint(titleId);
        setTitle(getText(titleId));
        // ---------- Original Method ----------
        //setTitle(getText(titleId));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.820 -0400", hash_original_method = "FA24EF1A624DFEEBC72DEB2A718D69DE", hash_generated_method = "06B6C67148B064D0C7E62AAE5DAFC4AF")
    @DSModeled(DSC.SAFE)
    public void setTitleColor(int textColor) {
        dsTaint.addTaint(textColor);
        onTitleChanged(mTitle, textColor);
        // ---------- Original Method ----------
        //mTitleColor = textColor;
        //onTitleChanged(mTitle, textColor);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.821 -0400", hash_original_method = "7D691BCB64236E7B5AF8F6CB0399C091", hash_generated_method = "5A63188D5D79CE0E5665FF8D3968411B")
    @DSModeled(DSC.SAFE)
    public final CharSequence getTitle() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mTitle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.822 -0400", hash_original_method = "96312D04BD6FB534546AC8090A725A72", hash_generated_method = "D1414E86D3C57212E6F03DC5BFE03042")
    @DSModeled(DSC.SAFE)
    public final int getTitleColor() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mTitleColor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.822 -0400", hash_original_method = "907C0E9079D015DC414B2AE462CAF06D", hash_generated_method = "15411BB4FDEC655250DB01CC1D087E43")
    @DSModeled(DSC.SAFE)
    protected void onTitleChanged(CharSequence title, int color) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(title);
        dsTaint.addTaint(color);
        {
            final Window win;
            win = getWindow();
            {
                win.setTitle(title);
                {
                    win.setTitleColor(color);
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mTitleReady) {
            //final Window win = getWindow();
            //if (win != null) {
                //win.setTitle(title);
                //if (color != 0) {
                    //win.setTitleColor(color);
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.823 -0400", hash_original_method = "7A7CC5A839395F1C996BC46DE28C9533", hash_generated_method = "D48EBC19C970198CC9EA75D78CAFAB6B")
    @DSModeled(DSC.SAFE)
    protected void onChildTitleChanged(Activity childActivity, CharSequence title) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(title);
        dsTaint.addTaint(childActivity.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.824 -0400", hash_original_method = "32B6571BC6889F247F99CDBE3AE16965", hash_generated_method = "AEA2E6FF4E21742DD6998C4009D56BC4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setProgressBarVisibility(boolean visible) {
        dsTaint.addTaint(visible);
        getWindow().setFeatureInt(Window.FEATURE_PROGRESS, visible ? Window.PROGRESS_VISIBILITY_ON :
            Window.PROGRESS_VISIBILITY_OFF);
        // ---------- Original Method ----------
        //getWindow().setFeatureInt(Window.FEATURE_PROGRESS, visible ? Window.PROGRESS_VISIBILITY_ON :
            //Window.PROGRESS_VISIBILITY_OFF);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.824 -0400", hash_original_method = "1DF5015282F18776361652D68AED30B4", hash_generated_method = "8F2DAC4D48E79512A72479F1A85D76C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setProgressBarIndeterminateVisibility(boolean visible) {
        dsTaint.addTaint(visible);
        getWindow().setFeatureInt(Window.FEATURE_INDETERMINATE_PROGRESS,
                visible ? Window.PROGRESS_VISIBILITY_ON : Window.PROGRESS_VISIBILITY_OFF);
        // ---------- Original Method ----------
        //getWindow().setFeatureInt(Window.FEATURE_INDETERMINATE_PROGRESS,
                //visible ? Window.PROGRESS_VISIBILITY_ON : Window.PROGRESS_VISIBILITY_OFF);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.825 -0400", hash_original_method = "2F28E974BBABA05D28D9AF73C25D13FA", hash_generated_method = "636FE459C7EDFFF6A63A0175DE278205")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setProgressBarIndeterminate(boolean indeterminate) {
        dsTaint.addTaint(indeterminate);
        getWindow().setFeatureInt(Window.FEATURE_PROGRESS,
                indeterminate ? Window.PROGRESS_INDETERMINATE_ON : Window.PROGRESS_INDETERMINATE_OFF);
        // ---------- Original Method ----------
        //getWindow().setFeatureInt(Window.FEATURE_PROGRESS,
                //indeterminate ? Window.PROGRESS_INDETERMINATE_ON : Window.PROGRESS_INDETERMINATE_OFF);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.825 -0400", hash_original_method = "55067894B88907AA64DBBC76309FF362", hash_generated_method = "84FCA5B337D53F71467704C1539EEF7E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setProgress(int progress) {
        dsTaint.addTaint(progress);
        getWindow().setFeatureInt(Window.FEATURE_PROGRESS, progress + Window.PROGRESS_START);
        // ---------- Original Method ----------
        //getWindow().setFeatureInt(Window.FEATURE_PROGRESS, progress + Window.PROGRESS_START);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.826 -0400", hash_original_method = "FF0EFB07F2D369BD624208547BA4F187", hash_generated_method = "5A2308966DE55D838145EF4E6F2BE2B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setSecondaryProgress(int secondaryProgress) {
        dsTaint.addTaint(secondaryProgress);
        getWindow().setFeatureInt(Window.FEATURE_PROGRESS,
                secondaryProgress + Window.PROGRESS_SECONDARY_START);
        // ---------- Original Method ----------
        //getWindow().setFeatureInt(Window.FEATURE_PROGRESS,
                //secondaryProgress + Window.PROGRESS_SECONDARY_START);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.826 -0400", hash_original_method = "70729F29EB37CCBEC739A5986214C32F", hash_generated_method = "448C76726BFAB336F3C6D49C85E5F133")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setVolumeControlStream(int streamType) {
        dsTaint.addTaint(streamType);
        getWindow().setVolumeControlStream(streamType);
        // ---------- Original Method ----------
        //getWindow().setVolumeControlStream(streamType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.827 -0400", hash_original_method = "03A841DC7655848901B3CE2C14084AAE", hash_generated_method = "9BD9F5E37E91410CBE122176D7A71947")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getVolumeControlStream() {
        int var10019DD6073F3F6675C482019A78518D_1421190255 = (getWindow().getVolumeControlStream());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getWindow().getVolumeControlStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.827 -0400", hash_original_method = "691B4E9428578C2267EA5A6538081943", hash_generated_method = "7344E9568EAB6CFC248939A9A31DB7BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void runOnUiThread(Runnable action) {
        dsTaint.addTaint(action.dsTaint);
        {
            boolean varD46220B6DBDB2780BC14591AF2433BD7_745623728 = (Thread.currentThread() != mUiThread);
            {
                mHandler.post(action);
            } //End block
            {
                action.run();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (Thread.currentThread() != mUiThread) {
            //mHandler.post(action);
        //} else {
            //action.run();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.828 -0400", hash_original_method = "C11741BEACAA4DD4B803A04296254194", hash_generated_method = "E185B809026CFD6D884CCD697D97A773")
    @DSModeled(DSC.SAFE)
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(name);
        dsTaint.addTaint(context.dsTaint);
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.830 -0400", hash_original_method = "6AED635285422A876000505F10FFFED0", hash_generated_method = "05902AA83F7388ADBED193A5B4889295")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(name);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(parent.dsTaint);
        {
            boolean var0F10F717A8824D895C9119EA392D7F2A_1972240508 = (!"fragment".equals(name));
            {
                View varEAB1D85B42521E0D39927257B57E8E1F_1734998378 = (onCreateView(name, context, attrs));
            } //End block
        } //End collapsed parenthetic
        String fname;
        fname = attrs.getAttributeValue(null, "class");
        TypedArray a;
        a = context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.Fragment);
        {
            fname = a.getString(com.android.internal.R.styleable.Fragment_name);
        } //End block
        int id;
        id = a.getResourceId(com.android.internal.R.styleable.Fragment_id, View.NO_ID);
        String tag;
        tag = a.getString(com.android.internal.R.styleable.Fragment_tag);
        a.recycle();
        int containerId;
        containerId = parent.getId();
        containerId = 0;
        {
            throw new IllegalArgumentException(attrs.getPositionDescription()
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
            throw new IllegalArgumentException(attrs.getPositionDescription()
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
            throw new IllegalStateException("Fragment " + fname
                    + " did not create a view.");
        } //End block
        {
            fragment.mView.setId(id);
        } //End block
        {
            boolean var28AAFB4908746F4035C573FBEA5D04E5_1554832536 = (fragment.mView.getTag() == null);
            {
                fragment.mView.setTag(tag);
            } //End block
        } //End collapsed parenthetic
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.832 -0400", hash_original_method = "A3B02D247D35A4A6189512589B728713", hash_generated_method = "ED88ED540AADB4A2EF6F1A87DC507FA2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        dsTaint.addTaint(args);
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(fd.dsTaint);
        dsTaint.addTaint(writer.dsTaint);
        writer.print(prefix);
        writer.print("Local Activity ");
        writer.print(Integer.toHexString(System.identityHashCode(this)));
        writer.println(" State:");
        String innerPrefix;
        innerPrefix = prefix + "  ";
        writer.print(innerPrefix);
        writer.print("mResumed=");
        writer.print(mResumed);
        writer.print(" mStopped=");
        writer.print(mStopped);
        writer.print(" mFinished=");
        writer.println(mFinished);
        writer.print(innerPrefix);
        writer.print("mLoadersStarted=");
        writer.println(mLoadersStarted);
        writer.print(innerPrefix);
        writer.print("mChangingConfigurations=");
        writer.println(mChangingConfigurations);
        writer.print(innerPrefix);
        writer.print("mCurrentConfig=");
        writer.println(mCurrentConfig);
        {
            writer.print(prefix);
            writer.print("Loader Manager ");
            writer.print(Integer.toHexString(System.identityHashCode(mLoaderManager)));
            writer.println(":");
            mLoaderManager.dump(prefix + "  ", fd, writer, args);
        } //End block
        mFragments.dump(prefix, fd, writer, args);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.833 -0400", hash_original_method = "F5F1BD517EE731E56F922C1A6872A499", hash_generated_method = "4512AE347D81B551C7A15F85C33BC542")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isImmersive() {
        try 
        {
            boolean var8E24EC029BEB1ED19FFEAC6EBBA9556E_632309433 = (ActivityManagerNative.getDefault().isImmersive(mToken));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().isImmersive(mToken);
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.834 -0400", hash_original_method = "9D8EB8E29C9BCD315046F1934B1FF39B", hash_generated_method = "3EEDFA66E60F7EFD8552CADF1A9B0102")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setImmersive(boolean i) {
        dsTaint.addTaint(i);
        try 
        {
            ActivityManagerNative.getDefault().setImmersive(mToken, i);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //ActivityManagerNative.getDefault().setImmersive(mToken, i);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.834 -0400", hash_original_method = "2C973E12746FE944D244FE9652432CFA", hash_generated_method = "7A8CB668D98157ECD247E9145D951A01")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ActionMode startActionMode(ActionMode.Callback callback) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(callback.dsTaint);
        ActionMode var3B64A2E697CE158BAD389DA26C3A35A0_1621095659 = (mWindow.getDecorView().startActionMode(callback));
        return (ActionMode)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mWindow.getDecorView().startActionMode(callback);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.835 -0400", hash_original_method = "371F08E85934452E39039D6D8CFF84EA", hash_generated_method = "19B65AACD1A5109CDEF4201BBFE26067")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(callback.dsTaint);
        initActionBar();
        {
            ActionMode varC7B1CFD44B51A75C688A1BA10AC498EB_908302149 = (mActionBar.startActionMode(callback));
        } //End block
        return (ActionMode)dsTaint.getTaint();
        // ---------- Original Method ----------
        //initActionBar();
        //if (mActionBar != null) {
            //return mActionBar.startActionMode(callback);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.835 -0400", hash_original_method = "255BA88D048ED7CA66014BFC1FF334C0", hash_generated_method = "05E6A9D1EEEB10623F370AD61605C4AB")
    @DSModeled(DSC.SAFE)
    public void onActionModeStarted(ActionMode mode) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(mode.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.836 -0400", hash_original_method = "731D5E497065CC7A99050B1E6205CD2C", hash_generated_method = "5024B890A5EC497573528F5B00578B8E")
    @DSModeled(DSC.SAFE)
    public void onActionModeFinished(ActionMode mode) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(mode.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.836 -0400", hash_original_method = "CB0EFE3ADA1587CB31B88C9EC51AC6CD", hash_generated_method = "027BFF005B69EBDCC1E865C195587E20")
    @DSModeled(DSC.SAFE)
    final void setParent(Activity parent) {
        dsTaint.addTaint(parent.dsTaint);
        // ---------- Original Method ----------
        //mParent = parent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.837 -0400", hash_original_method = "F5D036702945AFC6D1167650D88CF89C", hash_generated_method = "D9C31FD3F7EB63EE127FD5852A57CFAF")
    @DSModeled(DSC.SPEC)
    final void attach(Context context, ActivityThread aThread, Instrumentation instr, IBinder token,
            Application application, Intent intent, ActivityInfo info, CharSequence title, 
            Activity parent, String id, NonConfigurationInstances lastNonConfigurationInstances,
            Configuration config) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(application.dsTaint);
        dsTaint.addTaint(title);
        dsTaint.addTaint(aThread.dsTaint);
        dsTaint.addTaint(token.dsTaint);
        dsTaint.addTaint(lastNonConfigurationInstances.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(parent.dsTaint);
        dsTaint.addTaint(config.dsTaint);
        dsTaint.addTaint(intent.dsTaint);
        dsTaint.addTaint(instr.dsTaint);
        dsTaint.addTaint(info.dsTaint);
        attach(context, aThread, instr, token, 0, application, intent, info, title, parent, id,
            lastNonConfigurationInstances, config);
        // ---------- Original Method ----------
        //attach(context, aThread, instr, token, 0, application, intent, info, title, parent, id,
            //lastNonConfigurationInstances, config);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.839 -0400", hash_original_method = "1337919A8B79C562A3EF2FA6EE3B4075", hash_generated_method = "840D1D53D8BE8B7D0D696F0AEECB1AE1")
    @DSModeled(DSC.SPEC)
    final void attach(Context context, ActivityThread aThread,
            Instrumentation instr, IBinder token, int ident,
            Application application, Intent intent, ActivityInfo info,
            CharSequence title, Activity parent, String id,
            NonConfigurationInstances lastNonConfigurationInstances,
            Configuration config) {
        dsTaint.addTaint(application.dsTaint);
        dsTaint.addTaint(aThread.dsTaint);
        dsTaint.addTaint(parent.dsTaint);
        dsTaint.addTaint(intent.dsTaint);
        dsTaint.addTaint(info.dsTaint);
        dsTaint.addTaint(instr.dsTaint);
        dsTaint.addTaint(id);
        dsTaint.addTaint(title);
        dsTaint.addTaint(ident);
        dsTaint.addTaint(token.dsTaint);
        dsTaint.addTaint(lastNonConfigurationInstances.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(config.dsTaint);
        attachBaseContext(context);
        mFragments.attachActivity(this);
        mWindow = PolicyManager.makeNewWindow(this);
        mWindow.setCallback(this);
        mWindow.getLayoutInflater().setPrivateFactory(this);
        {
            mWindow.setSoftInputMode(info.softInputMode);
        } //End block
        {
            mWindow.setUiOptions(info.uiOptions);
        } //End block
        mUiThread = Thread.currentThread();
        mComponent = intent.getComponent();
        mWindow.setWindowManager(null, mToken, mComponent.flattenToString(),
                (info.flags & ActivityInfo.FLAG_HARDWARE_ACCELERATED) != 0);
        {
            mWindow.setContainer(mParent.getWindow());
        } //End block
        mWindowManager = mWindow.getWindowManager();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.840 -0400", hash_original_method = "032FECF5166BB774C48681F5A73546B5", hash_generated_method = "C6488925324CAF339AE6BB735C331705")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final IBinder getActivityToken() {
        {
            Object varD5A921868FF3B2F8D4ADA6839AF4EB5F_1902785601 = (mParent.getActivityToken());
        } //End flattened ternary
        return (IBinder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mParent != null ? mParent.getActivityToken() : mToken;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.841 -0400", hash_original_method = "DAB379B095765C858B51976FA2FCF6E4", hash_generated_method = "9BB7BE85FE940035B191CEB04A7135BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void performCreate(Bundle icicle) {
        dsTaint.addTaint(icicle.dsTaint);
        onCreate(icicle);
        mVisibleFromClient = !mWindow.getWindowStyle().getBoolean(
                com.android.internal.R.styleable.Window_windowNoDisplay, false);
        mFragments.dispatchActivityCreated();
        // ---------- Original Method ----------
        //onCreate(icicle);
        //mVisibleFromClient = !mWindow.getWindowStyle().getBoolean(
                //com.android.internal.R.styleable.Window_windowNoDisplay, false);
        //mFragments.dispatchActivityCreated();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.842 -0400", hash_original_method = "82BCF6383A02A95A38B6B2EB9C1C7555", hash_generated_method = "132EC7493D175B47356291C18260F2F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void performStart() {
        mFragments.noteStateNotSaved();
        mCalled = false;
        mFragments.execPendingActions();
        mInstrumentation.callActivityOnStart(this);
        {
            throw new SuperNotCalledException(
                "Activity " + mComponent.toShortString() +
                " did not call through to super.onStart()");
        } //End block
        mFragments.dispatchStart();
        {
            {
                int i;
                i = mAllLoaderManagers.size()-1;
                {
                    LoaderManagerImpl lm;
                    lm = mAllLoaderManagers.valueAt(i);
                    lm.finishRetain();
                    lm.doReportStart();
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //mFragments.noteStateNotSaved();
        //mCalled = false;
        //mFragments.execPendingActions();
        //mInstrumentation.callActivityOnStart(this);
        //if (!mCalled) {
            //throw new SuperNotCalledException(
                //"Activity " + mComponent.toShortString() +
                //" did not call through to super.onStart()");
        //}
        //mFragments.dispatchStart();
        //if (mAllLoaderManagers != null) {
            //for (int i=mAllLoaderManagers.size()-1; i>=0; i--) {
                //LoaderManagerImpl lm = mAllLoaderManagers.valueAt(i);
                //lm.finishRetain();
                //lm.doReportStart();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.843 -0400", hash_original_method = "3EBAEF204822031FA104B5D3C8D08DD5", hash_generated_method = "C7C9273CF70E0D3A46A2E538338475DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void performRestart() {
        mFragments.noteStateNotSaved();
        {
            mStopped = false;
            {
                WindowManagerImpl.getDefault().setStoppedState(mToken, false);
            } //End block
            {
                final int N;
                N = mManagedCursors.size();
                {
                    int i;
                    i = 0;
                    {
                        ManagedCursor mc;
                        mc = mManagedCursors.get(i);
                        {
                            {
                                boolean var04A5C84C1C3F081B6B9C5407629BB7FE_173834470 = (!mc.mCursor.requery());
                                {
                                    {
                                        boolean varF1BBC5758062A55B0A9400E3F4AF6947_1879402967 = (getApplicationInfo().targetSdkVersion
                                    >= android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH);
                                        {
                                            throw new IllegalStateException(
                                        "trying to requery an already closed cursor  "
                                        + mc.mCursor);
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                            } //End collapsed parenthetic
                            mc.mReleased = false;
                            mc.mUpdated = false;
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
            mCalled = false;
            mInstrumentation.callActivityOnRestart(this);
            {
                throw new SuperNotCalledException(
                    "Activity " + mComponent.toShortString() +
                    " did not call through to super.onRestart()");
            } //End block
            performStart();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.844 -0400", hash_original_method = "F35F1467F0B7E6EEBE9DD69D8D6AD358", hash_generated_method = "70AA26E146C4EB2F857F1D05F4B787E9")
    @DSModeled(DSC.SAFE)
    final void performResume() {
        performRestart();
        mFragments.execPendingActions();
        mLastNonConfigurationInstances = null;
        mCalled = false;
        mInstrumentation.callActivityOnResume(this);
        {
            throw new SuperNotCalledException(
                "Activity " + mComponent.toShortString() +
                " did not call through to super.onResume()");
        } //End block
        mCalled = false;
        mFragments.dispatchResume();
        mFragments.execPendingActions();
        onPostResume();
        {
            throw new SuperNotCalledException(
                "Activity " + mComponent.toShortString() +
                " did not call through to super.onPostResume()");
        } //End block
        // ---------- Original Method ----------
        //performRestart();
        //mFragments.execPendingActions();
        //mLastNonConfigurationInstances = null;
        //mCalled = false;
        //mInstrumentation.callActivityOnResume(this);
        //if (!mCalled) {
            //throw new SuperNotCalledException(
                //"Activity " + mComponent.toShortString() +
                //" did not call through to super.onResume()");
        //}
        //mCalled = false;
        //mFragments.dispatchResume();
        //mFragments.execPendingActions();
        //onPostResume();
        //if (!mCalled) {
            //throw new SuperNotCalledException(
                //"Activity " + mComponent.toShortString() +
                //" did not call through to super.onPostResume()");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.845 -0400", hash_original_method = "F81A8DB24B00685E2B896EC5528AF34D", hash_generated_method = "7AE9C316A6140AAFBEF4F84CA23F631B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void performPause() {
        mFragments.dispatchPause();
        mCalled = false;
        onPause();
        mResumed = false;
        {
            boolean varAE0213A865A9842D2D0B2E8D0A5C03B4_1003073884 = (!mCalled && getApplicationInfo().targetSdkVersion
                >= android.os.Build.VERSION_CODES.GINGERBREAD);
            {
                throw new SuperNotCalledException(
                    "Activity " + mComponent.toShortString() +
                    " did not call through to super.onPause()");
            } //End block
        } //End collapsed parenthetic
        mResumed = false;
        // ---------- Original Method ----------
        //mFragments.dispatchPause();
        //mCalled = false;
        //onPause();
        //mResumed = false;
        //if (!mCalled && getApplicationInfo().targetSdkVersion
                //>= android.os.Build.VERSION_CODES.GINGERBREAD) {
            //throw new SuperNotCalledException(
                    //"Activity " + mComponent.toShortString() +
                    //" did not call through to super.onPause()");
        //}
        //mResumed = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.846 -0400", hash_original_method = "ABDB3944564BF35742E6297221FCB3EA", hash_generated_method = "2290B2B79326435B5931E4EAAD319377")
    @DSModeled(DSC.SAFE)
    final void performUserLeaving() {
        onUserInteraction();
        onUserLeaveHint();
        // ---------- Original Method ----------
        //onUserInteraction();
        //onUserLeaveHint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.848 -0400", hash_original_method = "1444D8CCB63DB563C5707F75C9D1FF30", hash_generated_method = "2A103BCBCCDEAF3B6B650CF5E537622D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void performStop() {
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
        {
            {
                mWindow.closeAllPanels();
            } //End block
            {
                WindowManagerImpl.getDefault().setStoppedState(mToken, true);
            } //End block
            mFragments.dispatchStop();
            mCalled = false;
            mInstrumentation.callActivityOnStop(this);
            {
                throw new SuperNotCalledException(
                    "Activity " + mComponent.toShortString() +
                    " did not call through to super.onStop()");
            } //End block
            {
                final int N;
                N = mManagedCursors.size();
                {
                    int i;
                    i = 0;
                    {
                        ManagedCursor mc;
                        mc = mManagedCursors.get(i);
                        {
                            mc.mCursor.deactivate();
                            mc.mReleased = true;
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
            mStopped = true;
        } //End block
        mResumed = false;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.849 -0400", hash_original_method = "1C8656F81B9FFA0D582D8F6098E0BE30", hash_generated_method = "418235B350B9614E23639F8A051F02E4")
    @DSModeled(DSC.SAFE)
    final void performDestroy() {
        mWindow.destroy();
        mFragments.dispatchDestroy();
        onDestroy();
        {
            mLoaderManager.doDestroy();
        } //End block
        // ---------- Original Method ----------
        //mWindow.destroy();
        //mFragments.dispatchDestroy();
        //onDestroy();
        //if (mLoaderManager != null) {
            //mLoaderManager.doDestroy();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.849 -0400", hash_original_method = "58811A32FF0FF231CA3DA7AD72F98B09", hash_generated_method = "43F9CF89DFDCA8E1BDC122A1BE3742F1")
    @DSModeled(DSC.SAFE)
    public final boolean isResumed() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mResumed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.851 -0400", hash_original_method = "9EF1B69B76655E6A901B5D291A25C28E", hash_generated_method = "A0E3C6F84DB10C9D4CE8C6FF361CEA7B")
    @DSModeled(DSC.SPEC)
     void dispatchActivityResult(String who, int requestCode, 
        int resultCode, Intent data) {
        dsTaint.addTaint(requestCode);
        dsTaint.addTaint(resultCode);
        dsTaint.addTaint(data.dsTaint);
        dsTaint.addTaint(who);
        mFragments.noteStateNotSaved();
        {
            onActivityResult(requestCode, resultCode, data);
        } //End block
        {
            Fragment frag;
            frag = mFragments.findFragmentByWho(who);
            {
                frag.onActivityResult(requestCode, resultCode, data);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (false) Log.v(
            //TAG, "Dispatching result: who=" + who + ", reqCode=" + requestCode
            //+ ", resCode=" + resultCode + ", data=" + data);
        //mFragments.noteStateNotSaved();
        //if (who == null) {
            //onActivityResult(requestCode, resultCode, data);
        //} else {
            //Fragment frag = mFragments.findFragmentByWho(who);
            //if (frag != null) {
                //frag.onActivityResult(requestCode, resultCode, data);
            //}
        //}
    }

    
    private static class ManagedDialog {
        Dialog mDialog;
        Bundle mArgs;
        
    }


    
    static final class NonConfigurationInstances {
        Object activity;
        HashMap<String, Object> children;
        ArrayList<Fragment> fragments;
        SparseArray<LoaderManagerImpl> loaders;
        
    }


    
    private static final class ManagedCursor {
        private final Cursor mCursor;
        private boolean mReleased;
        private boolean mUpdated;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.852 -0400", hash_original_method = "1B2A6EC67EE1273DC41D2716939B2D2A", hash_generated_method = "24FB25B9BDC0093D18CB74CB8624B42D")
        @DSModeled(DSC.SAFE)
         ManagedCursor(Cursor cursor) {
            dsTaint.addTaint(cursor.dsTaint);
            mReleased = false;
            mUpdated = false;
            // ---------- Original Method ----------
            //mCursor = cursor;
            //mReleased = false;
            //mUpdated = false;
        }

        
    }


    
}


//DSFIXME:  CODE0011:  Unresolved legacy methods exist in original model
/*

*/
