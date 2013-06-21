package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.app.ActionBarImpl;
import com.android.internal.policy.PolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import java.lang.ref.WeakReference;

public class Dialog implements DialogInterface, Window.Callback, KeyEvent.Callback, OnCreateContextMenuListener {
    private Activity mOwnerActivity;
    Context mContext;
    WindowManager mWindowManager;
    Window mWindow;
    View mDecor;
    private ActionBarImpl mActionBar;
    protected boolean mCancelable = true;
    private String mCancelAndDismissTaken;
    private Message mCancelMessage;
    private Message mDismissMessage;
    private Message mShowMessage;
    private OnKeyListener mOnKeyListener;
    private boolean mCreated = false;
    private boolean mShowing = false;
    private boolean mCanceled = false;
    private Thread mUiThread;
    private Handler mHandler = new Handler();
    private Handler mListenersHandler;
    private ActionMode mActionMode;
    private final Runnable mDismissAction = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.190 -0400", hash_original_method = "BEE19A9C5B7D04B78955A3FD8170F1CA", hash_generated_method = "4B98EED19700DEC05BCE304A452DAE0F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void run() {
            dismissDialog();
            // ---------- Original Method ----------
            //dismissDialog();
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.190 -0400", hash_original_method = "BC9D2F22217346E354BF7BFC78A2D0C2", hash_generated_method = "5F75C6A5B900A6889A831E26EB56CB98")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Dialog(Context context) {
        this(context, 0, true);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.191 -0400", hash_original_method = "E8683E6729C8449A45D83189604DFAE9", hash_generated_method = "D7723A199537544EBB5728040CAB1E6B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Dialog(Context context, int theme) {
        this(context, theme, true);
        dsTaint.addTaint(theme);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.192 -0400", hash_original_method = "C6D5E1D2CF37954F320E3261297EC417", hash_generated_method = "1F216738EDC140E1EFF79D272EB42BC5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Dialog(Context context, int theme, boolean createContextWrapper) {
        dsTaint.addTaint(theme);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(createContextWrapper);
        {
            TypedValue outValue;
            outValue = new TypedValue();
            context.getTheme().resolveAttribute(com.android.internal.R.attr.dialogTheme,
                    outValue, true);
            theme = outValue.resourceId;
        } //End block
        mContext = createContextWrapper ? new ContextThemeWrapper(context, theme) : context;
        mWindowManager = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        Window w;
        w = PolicyManager.makeNewWindow(mContext);
        mWindow = w;
        w.setCallback(this);
        w.setWindowManager(mWindowManager, null, null);
        w.setGravity(Gravity.CENTER);
        mUiThread = Thread.currentThread();
        mListenersHandler = new ListenersHandler(this);
        // ---------- Original Method ----------
        //if (theme == 0) {
            //TypedValue outValue = new TypedValue();
            //context.getTheme().resolveAttribute(com.android.internal.R.attr.dialogTheme,
                    //outValue, true);
            //theme = outValue.resourceId;
        //}
        //mContext = createContextWrapper ? new ContextThemeWrapper(context, theme) : context;
        //mWindowManager = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        //Window w = PolicyManager.makeNewWindow(mContext);
        //mWindow = w;
        //w.setCallback(this);
        //w.setWindowManager(mWindowManager, null, null);
        //w.setGravity(Gravity.CENTER);
        //mUiThread = Thread.currentThread();
        //mListenersHandler = new ListenersHandler(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.192 -0400", hash_original_method = "845C16E53E1BE45A2BA7FF67CD257C6C", hash_generated_method = "822C6837C9447F0054810784FAB7360D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    protected Dialog(Context context, boolean cancelable,
            Message cancelCallback) {
        this(context);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(cancelable);
        dsTaint.addTaint(cancelCallback.dsTaint);
        // ---------- Original Method ----------
        //mCancelable = cancelable;
        //mCancelMessage = cancelCallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.193 -0400", hash_original_method = "C9ADA56967BDAFB742C2181BE637639A", hash_generated_method = "511FBFDBB63EFE68ECBF04DEB163A226")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Dialog(Context context, boolean cancelable,
            OnCancelListener cancelListener) {
        this(context);
        dsTaint.addTaint(cancelListener.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(cancelable);
        setOnCancelListener(cancelListener);
        // ---------- Original Method ----------
        //mCancelable = cancelable;
        //setOnCancelListener(cancelListener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.193 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "BE5638BA5602E1CB98C94695D5EEE971")
    @DSModeled(DSC.SAFE)
    public final Context getContext() {
        return (Context)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.201 -0400", hash_original_method = "624FE63EC935EE8F7C5CD37954EA0AEA", hash_generated_method = "AD45C77DBDCAF5299E6858248E4B0B9B")
    @DSModeled(DSC.SAFE)
    public ActionBar getActionBar() {
        return (ActionBar)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActionBar;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.202 -0400", hash_original_method = "AEEF4868262FBFB181A318E6FDCF1973", hash_generated_method = "AD18F854203A1E181A938179A6D59108")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setOwnerActivity(Activity activity) {
        dsTaint.addTaint(activity.dsTaint);
        getWindow().setVolumeControlStream(mOwnerActivity.getVolumeControlStream());
        // ---------- Original Method ----------
        //mOwnerActivity = activity;
        //getWindow().setVolumeControlStream(mOwnerActivity.getVolumeControlStream());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.203 -0400", hash_original_method = "D833D4731703AD671D7AED3C45CAE756", hash_generated_method = "C81188C8395C4FECEEB10F435505E8F3")
    @DSModeled(DSC.SAFE)
    public final Activity getOwnerActivity() {
        return (Activity)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mOwnerActivity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.203 -0400", hash_original_method = "F21458EB6FE36A924A49B40493E1F9F8", hash_generated_method = "A750A7C7A899819E05726851055511DF")
    @DSModeled(DSC.SAFE)
    public boolean isShowing() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mShowing;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.205 -0400", hash_original_method = "079FA2E5CA600A12F7067E75E853F614", hash_generated_method = "29763C8359FE6C9F480B31519F7CBF94")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void show() {
        {
            {
                {
                    boolean varDF79E2FDC0F8C38E07A73A6CD2C66427_670532459 = (mWindow.hasFeature(Window.FEATURE_ACTION_BAR));
                    {
                        mWindow.invalidatePanelMenu(Window.FEATURE_ACTION_BAR);
                    } //End block
                } //End collapsed parenthetic
                mDecor.setVisibility(View.VISIBLE);
            } //End block
        } //End block
        mCanceled = false;
        {
            dispatchOnCreate(null);
        } //End block
        onStart();
        mDecor = mWindow.getDecorView();
        {
            boolean varF4E6C6330D33A37486BAA82B7DDC231D_796602478 = (mActionBar == null && mWindow.hasFeature(Window.FEATURE_ACTION_BAR));
            {
                mActionBar = new ActionBarImpl(this);
            } //End block
        } //End collapsed parenthetic
        WindowManager.LayoutParams l;
        l = mWindow.getAttributes();
        {
            WindowManager.LayoutParams nl;
            nl = new WindowManager.LayoutParams();
            nl.copyFrom(l);
            nl.softInputMode |=
                    WindowManager.LayoutParams.SOFT_INPUT_IS_FORWARD_NAVIGATION;
            l = nl;
        } //End block
        try 
        {
            mWindowManager.addView(mDecor, l);
            mShowing = true;
            sendShowMessage();
        } //End block
        finally 
        { }
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.207 -0400", hash_original_method = "4A0CDBB7EA97DC376E25E0EE43387CF4", hash_generated_method = "D960C5A95FEB753FEAD909D760B2CA18")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void hide() {
        {
            mDecor.setVisibility(View.GONE);
        } //End block
        // ---------- Original Method ----------
        //if (mDecor != null) {
            //mDecor.setVisibility(View.GONE);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.208 -0400", hash_original_method = "33443011198828BD072B057DA719765A", hash_generated_method = "D330EB374DB3A373C9794E89B6CAADB1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dismiss() {
        {
            boolean varD46220B6DBDB2780BC14591AF2433BD7_771939389 = (Thread.currentThread() != mUiThread);
            {
                mHandler.post(mDismissAction);
            } //End block
            {
                mHandler.removeCallbacks(mDismissAction);
                mDismissAction.run();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (Thread.currentThread() != mUiThread) {
            //mHandler.post(mDismissAction);
        //} else {
            //mHandler.removeCallbacks(mDismissAction);
            //mDismissAction.run();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.209 -0400", hash_original_method = "4ECC78F105BA2AD2FA21893BA556AFFD", hash_generated_method = "BC1FD94439D3B225CDB89C303360945A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void dismissDialog() {
        {
            boolean varAA9215BBF1FF733067DEC864B8F4AC12_227045994 = (mWindow.isDestroyed());
        } //End collapsed parenthetic
        try 
        {
            mWindowManager.removeView(mDecor);
        } //End block
        finally 
        {
            {
                mActionMode.finish();
            } //End block
            mDecor = null;
            mWindow.closeAllPanels();
            onStop();
            mShowing = false;
            sendDismissMessage();
        } //End block
        // ---------- Original Method ----------
        //if (mDecor == null || !mShowing) {
            //return;
        //}
        //if (mWindow.isDestroyed()) {
            //Log.e(TAG, "Tried to dismissDialog() but the Dialog's window was already destroyed!");
            //return;
        //}
        //try {
            //mWindowManager.removeView(mDecor);
        //} finally {
            //if (mActionMode != null) {
                //mActionMode.finish();
            //}
            //mDecor = null;
            //mWindow.closeAllPanels();
            //onStop();
            //mShowing = false;
            //sendDismissMessage();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.210 -0400", hash_original_method = "866BAFBEBC09B92D7388CA2F75E61BAD", hash_generated_method = "1EA55A4647FD1A132F53711D4AB8E09B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void sendDismissMessage() {
        {
            Message.obtain(mDismissMessage).sendToTarget();
        } //End block
        // ---------- Original Method ----------
        //if (mDismissMessage != null) {
            //Message.obtain(mDismissMessage).sendToTarget();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.218 -0400", hash_original_method = "02D405BDD0443049D755381D9E715694", hash_generated_method = "FB6E6E412C3BA60E0F71F6858C0C0653")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void sendShowMessage() {
        {
            Message.obtain(mShowMessage).sendToTarget();
        } //End block
        // ---------- Original Method ----------
        //if (mShowMessage != null) {
            //Message.obtain(mShowMessage).sendToTarget();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.223 -0400", hash_original_method = "CD27A7CE58254212F040E7B7DA65BCA4", hash_generated_method = "A2F576B3D51F65F3A416F5E8C8BC7DD1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void dispatchOnCreate(Bundle savedInstanceState) {
        dsTaint.addTaint(savedInstanceState.dsTaint);
        {
            onCreate(savedInstanceState);
            mCreated = true;
        } //End block
        // ---------- Original Method ----------
        //if (!mCreated) {
            //onCreate(savedInstanceState);
            //mCreated = true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.232 -0400", hash_original_method = "B84ED822BC6011EB138B2F6F1D018FE5", hash_generated_method = "9623B629AD8599015A773008B2CAF1AF")
    @DSModeled(DSC.SAFE)
    protected void onCreate(Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(savedInstanceState.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.232 -0400", hash_original_method = "1B4F9BFF1D832A07D0E1F41D0B16D2FF", hash_generated_method = "BE9AD01CB83E36F19DAEE7EFF770DFAE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void onStart() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mActionBar.setShowHideAnimationEnabled(true);
        // ---------- Original Method ----------
        //if (mActionBar != null) mActionBar.setShowHideAnimationEnabled(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.233 -0400", hash_original_method = "28173EE669492C23D10F671D2D034693", hash_generated_method = "EFC4CEDE95009F9A2C76BCB60E4786BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void onStop() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mActionBar.setShowHideAnimationEnabled(false);
        // ---------- Original Method ----------
        //if (mActionBar != null) mActionBar.setShowHideAnimationEnabled(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.233 -0400", hash_original_method = "2D855197EA1046BD8EC8CA2E991844E1", hash_generated_method = "126F1E575771305DB7812FA1C17C69DE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Bundle onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Bundle bundle;
        bundle = new Bundle();
        bundle.putBoolean(DIALOG_SHOWING_TAG, mShowing);
        {
            bundle.putBundle(DIALOG_HIERARCHY_TAG, mWindow.saveHierarchyState());
        } //End block
        return (Bundle)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Bundle bundle = new Bundle();
        //bundle.putBoolean(DIALOG_SHOWING_TAG, mShowing);
        //if (mCreated) {
            //bundle.putBundle(DIALOG_HIERARCHY_TAG, mWindow.saveHierarchyState());
        //}
        //return bundle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.234 -0400", hash_original_method = "EE5C9B4EF0AAEC8AB3AF49A30F3FD2D3", hash_generated_method = "B5EA21A1FEE59FB687618278FD76306D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(savedInstanceState.dsTaint);
        Bundle dialogHierarchyState;
        dialogHierarchyState = savedInstanceState.getBundle(DIALOG_HIERARCHY_TAG);
        dispatchOnCreate(savedInstanceState);
        mWindow.restoreHierarchyState(dialogHierarchyState);
        {
            boolean varB08F34606D5FAE48568279D4B22B1AC4_175292684 = (savedInstanceState.getBoolean(DIALOG_SHOWING_TAG));
            {
                show();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //final Bundle dialogHierarchyState = savedInstanceState.getBundle(DIALOG_HIERARCHY_TAG);
        //if (dialogHierarchyState == null) {
            //return;
        //}
        //dispatchOnCreate(savedInstanceState);
        //mWindow.restoreHierarchyState(dialogHierarchyState);
        //if (savedInstanceState.getBoolean(DIALOG_SHOWING_TAG)) {
            //show();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.235 -0400", hash_original_method = "51ACB33F24592F8ED3FAFF9D96DEAF2A", hash_generated_method = "851A718E93C6CD3CC102ED3F16EC7D4B")
    @DSModeled(DSC.SAFE)
    public Window getWindow() {
        return (Window)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mWindow;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.235 -0400", hash_original_method = "44957F5326E5A87B91E438DCD3C71232", hash_generated_method = "1C8CF0F2FF3A6CD420364B9B454D6AFB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public View getCurrentFocus() {
        {
            Object varF2CA58DC7834394B6A347593E17E623A_1779894225 = (mWindow.getCurrentFocus());
        } //End flattened ternary
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mWindow != null ? mWindow.getCurrentFocus() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.236 -0400", hash_original_method = "FBC1E026CFF410D335B7C0F9A45B0829", hash_generated_method = "1C7298DAF0A0ED58D2CA76C75CAC1A2D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public View findViewById(int id) {
        dsTaint.addTaint(id);
        View var86E7B55A02A98C723837B51FAC1DA5D6_313406662 = (mWindow.findViewById(id));
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mWindow.findViewById(id);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.236 -0400", hash_original_method = "A6A8A3E553FD4B026D939E9AE3AC9985", hash_generated_method = "F6FCD4DCCCE0A80CF0C403F264AF052C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setContentView(int layoutResID) {
        dsTaint.addTaint(layoutResID);
        mWindow.setContentView(layoutResID);
        // ---------- Original Method ----------
        //mWindow.setContentView(layoutResID);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.237 -0400", hash_original_method = "64A976C0ECE03B8AD97B801012E7B71B", hash_generated_method = "DD2952086599291EF474FE43E1042B6C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setContentView(View view) {
        dsTaint.addTaint(view.dsTaint);
        mWindow.setContentView(view);
        // ---------- Original Method ----------
        //mWindow.setContentView(view);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.237 -0400", hash_original_method = "21FC0CE0727282A96780C185A7B70535", hash_generated_method = "8D88B038E478F6B80F5082C8A62073B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        dsTaint.addTaint(params.dsTaint);
        dsTaint.addTaint(view.dsTaint);
        mWindow.setContentView(view, params);
        // ---------- Original Method ----------
        //mWindow.setContentView(view, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.238 -0400", hash_original_method = "54F8942E4EAEA6A93BE827863701CD23", hash_generated_method = "5AD0B9F04FA348A3F4E6F1B233063DE1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addContentView(View view, ViewGroup.LayoutParams params) {
        dsTaint.addTaint(params.dsTaint);
        dsTaint.addTaint(view.dsTaint);
        mWindow.addContentView(view, params);
        // ---------- Original Method ----------
        //mWindow.addContentView(view, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.238 -0400", hash_original_method = "A94A4616451E43B03E2FA5DD3DFB9ED3", hash_generated_method = "1735CB82C1132C935C486AF6EBDFD816")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTitle(CharSequence title) {
        dsTaint.addTaint(title);
        mWindow.setTitle(title);
        mWindow.getAttributes().setTitle(title);
        // ---------- Original Method ----------
        //mWindow.setTitle(title);
        //mWindow.getAttributes().setTitle(title);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.239 -0400", hash_original_method = "0D914ED2883864B655DBF2629252A595", hash_generated_method = "C7D138ADE4073EED3D0F05F1B17E3040")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTitle(int titleId) {
        dsTaint.addTaint(titleId);
        setTitle(mContext.getText(titleId));
        // ---------- Original Method ----------
        //setTitle(mContext.getText(titleId));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.239 -0400", hash_original_method = "EB61104CC8357BEAF109072385D21C38", hash_generated_method = "A532162FED5B3F6CFFA0A3C727BD1F9B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        {
            event.startTracking();
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (keyCode == KeyEvent.KEYCODE_BACK) {
            //event.startTracking();
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.240 -0400", hash_original_method = "2A75FF2C44C4D96068DDAFC2643F0C8B", hash_generated_method = "121675FEA65080179B4E07A9D8940A28")
    @DSModeled(DSC.SAFE)
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.245 -0400", hash_original_method = "CFFAC7119271281C27F3BEDCE8D82CC2", hash_generated_method = "7203FE0635381E5F653493ECD1BDA462")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        {
            boolean var0632AF553088255946876F04AB1E8E7D_921655236 = (keyCode == KeyEvent.KEYCODE_BACK && event.isTracking()
                && !event.isCanceled());
            {
                onBackPressed();
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (keyCode == KeyEvent.KEYCODE_BACK && event.isTracking()
                //&& !event.isCanceled()) {
            //onBackPressed();
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.246 -0400", hash_original_method = "E364C67ED15F0AA31C6DCFFA6137C8C0", hash_generated_method = "04DCF4ED60D6FB5861B483E64E603EE8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.247 -0400", hash_original_method = "EAEAA0DB8B83D24D321D98459F4FA29E", hash_generated_method = "3E313C8978C5A46580C6435094C7FE54")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onBackPressed() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            cancel();
        } //End block
        // ---------- Original Method ----------
        //if (mCancelable) {
            //cancel();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.247 -0400", hash_original_method = "2ECF3E4914B4B3BE2238F799B7435A51", hash_generated_method = "7AE552AEBA435B6260303AF26A8BCBA8")
    @DSModeled(DSC.SAFE)
    public boolean onKeyShortcut(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.248 -0400", hash_original_method = "5A4B1024EA76F961E6155B7F9E2B0909", hash_generated_method = "FE39336A10428993AA478AF3CBDF34B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onTouchEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        {
            boolean var31C1B547289343DCAE6EBC7208A847F8_1565077852 = (mCancelable && mShowing && mWindow.shouldCloseOnTouch(mContext, event));
            {
                cancel();
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mCancelable && mShowing && mWindow.shouldCloseOnTouch(mContext, event)) {
            //cancel();
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.248 -0400", hash_original_method = "4A983FDB3FF481E2165B7D8D641CDD48", hash_generated_method = "833D77A11226C846CBB638957F249990")
    @DSModeled(DSC.SAFE)
    public boolean onTrackballEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.258 -0400", hash_original_method = "0E59A005881F30C798F764BCF32D89A3", hash_generated_method = "ED84870AAC7E1EEE24DEDDB0C34D9E1A")
    @DSModeled(DSC.SAFE)
    public boolean onGenericMotionEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.258 -0400", hash_original_method = "4EF468126ED8F0323D4288D03F894270", hash_generated_method = "6C65A0A7BCD79B98E4B1092BB23E70CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onWindowAttributesChanged(WindowManager.LayoutParams params) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(params.dsTaint);
        {
            mWindowManager.updateViewLayout(mDecor, params);
        } //End block
        // ---------- Original Method ----------
        //if (mDecor != null) {
            //mWindowManager.updateViewLayout(mDecor, params);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.259 -0400", hash_original_method = "32D7339793DCE0D5AEFE6621981EC978", hash_generated_method = "15CE33052F85E41C1BB65E1E6B2C108A")
    @DSModeled(DSC.SAFE)
    public void onContentChanged() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.259 -0400", hash_original_method = "C7622FC561A602386C2112BC0445F7C6", hash_generated_method = "C14EC4ECF51B12BD2F6912C8CDA695D8")
    @DSModeled(DSC.SAFE)
    public void onWindowFocusChanged(boolean hasFocus) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(hasFocus);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.260 -0400", hash_original_method = "D6E949EE9F0768F47016EEA4FC0347A8", hash_generated_method = "0E08FFA9282E502085CC6973CB60CDA1")
    @DSModeled(DSC.SAFE)
    public void onAttachedToWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.260 -0400", hash_original_method = "E592299EBB4DE1D6696EB8C4009A9EF4", hash_generated_method = "1328510831112E7A424EFCA8583CA87C")
    @DSModeled(DSC.SAFE)
    public void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.261 -0400", hash_original_method = "1435B67C8334D2AC8987004B54F10264", hash_generated_method = "A417B649FB45FA449B5BC7A6EE437CDA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean dispatchKeyEvent(KeyEvent event) {
        dsTaint.addTaint(event.dsTaint);
        {
            boolean var119FC86DBD10D0451AA68681D2661AF8_158878116 = ((mOnKeyListener != null) && (mOnKeyListener.onKey(this, event.getKeyCode(), event)));
        } //End collapsed parenthetic
        {
            boolean var524CC85D3B1F7496F0129E1D66C889FF_1358789123 = (mWindow.superDispatchKeyEvent(event));
        } //End collapsed parenthetic
        boolean var9A9ACA17DE81B47807106F3C8C61EFB2_554559700 = (event.dispatch(this, mDecor != null
                ? mDecor.getKeyDispatcherState() : null, this)); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if ((mOnKeyListener != null) && (mOnKeyListener.onKey(this, event.getKeyCode(), event))) {
            //return true;
        //}
        //if (mWindow.superDispatchKeyEvent(event)) {
            //return true;
        //}
        //return event.dispatch(this, mDecor != null
                //? mDecor.getKeyDispatcherState() : null, this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.262 -0400", hash_original_method = "BA9D4031BD488C1D379B1950A362F8D4", hash_generated_method = "35C31A02B0CEE3EF43C9260ADAAE47DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean dispatchKeyShortcutEvent(KeyEvent event) {
        dsTaint.addTaint(event.dsTaint);
        {
            boolean var1506FC9A951093FEBE1E9D9D60B77FAA_599978303 = (mWindow.superDispatchKeyShortcutEvent(event));
        } //End collapsed parenthetic
        boolean varB65319FC5255424F872A964CBDE1432E_1586154101 = (onKeyShortcut(event.getKeyCode(), event));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mWindow.superDispatchKeyShortcutEvent(event)) {
            //return true;
        //}
        //return onKeyShortcut(event.getKeyCode(), event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.262 -0400", hash_original_method = "D3052CDDAC0630315E0F5E7AF5478D0E", hash_generated_method = "9DA8C04C27E1DF2188D847A2DCEF12D1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean dispatchTouchEvent(MotionEvent ev) {
        dsTaint.addTaint(ev.dsTaint);
        {
            boolean var5240AC15FBF7E8C8943B586A077531B5_581064979 = (mWindow.superDispatchTouchEvent(ev));
        } //End collapsed parenthetic
        boolean var985DA2294C2CD7796EE4EFA7F3FBE91B_1720916873 = (onTouchEvent(ev));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mWindow.superDispatchTouchEvent(ev)) {
            //return true;
        //}
        //return onTouchEvent(ev);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.263 -0400", hash_original_method = "2B935C89EDDE71F28E7C978B3C9DCAB0", hash_generated_method = "B0B57CFC4CCEB72E27A1F48DA58F5B78")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean dispatchTrackballEvent(MotionEvent ev) {
        dsTaint.addTaint(ev.dsTaint);
        {
            boolean varF25A212D3CF06F711C8BBD649E0977F2_1100621940 = (mWindow.superDispatchTrackballEvent(ev));
        } //End collapsed parenthetic
        boolean varE24895B72E913D801FFC5B9D9055D482_2081368840 = (onTrackballEvent(ev));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mWindow.superDispatchTrackballEvent(ev)) {
            //return true;
        //}
        //return onTrackballEvent(ev);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.264 -0400", hash_original_method = "B6AB9C2BD67E148832650E309163688C", hash_generated_method = "58963644685C6ACCDECB91D3710ADF8D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean dispatchGenericMotionEvent(MotionEvent ev) {
        dsTaint.addTaint(ev.dsTaint);
        {
            boolean varC6CFD9FB7BF4B51FA19B29CFED05E764_282031582 = (mWindow.superDispatchGenericMotionEvent(ev));
        } //End collapsed parenthetic
        boolean var82ABE1E641E95D27D650D268E959F965_286176346 = (onGenericMotionEvent(ev));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mWindow.superDispatchGenericMotionEvent(ev)) {
            //return true;
        //}
        //return onGenericMotionEvent(ev);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.266 -0400", hash_original_method = "3CC377981D86463D050A06CF1F7ED782", hash_generated_method = "13B780FE1F7C9C1AC5E4980217ADCFDD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        dsTaint.addTaint(event.dsTaint);
        event.setClassName(getClass().getName());
        event.setPackageName(mContext.getPackageName());
        LayoutParams params;
        params = getWindow().getAttributes();
        boolean isFullScreen;
        isFullScreen = (params.width == LayoutParams.MATCH_PARENT) &&
            (params.height == LayoutParams.MATCH_PARENT);
        event.setFullScreen(isFullScreen);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //event.setClassName(getClass().getName());
        //event.setPackageName(mContext.getPackageName());
        //LayoutParams params = getWindow().getAttributes();
        //boolean isFullScreen = (params.width == LayoutParams.MATCH_PARENT) &&
            //(params.height == LayoutParams.MATCH_PARENT);
        //event.setFullScreen(isFullScreen);
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.267 -0400", hash_original_method = "8FB2859FE43E0606E21921E291A18BDA", hash_generated_method = "AB9DBB00E790E2357089E1890DDB00A5")
    @DSModeled(DSC.SAFE)
    public View onCreatePanelView(int featureId) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(featureId);
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.267 -0400", hash_original_method = "1B30E4AD9FCCEF2C81163B46B66D301C", hash_generated_method = "B15AF4AD3F381571AECFA4D912AEB7BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(menu.dsTaint);
        dsTaint.addTaint(featureId);
        {
            boolean var3ADDFAB895A7216D8503161675C1D088_723093963 = (onCreateOptionsMenu(menu));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (featureId == Window.FEATURE_OPTIONS_PANEL) {
            //return onCreateOptionsMenu(menu);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.268 -0400", hash_original_method = "A95440A37102593BE255304F4188998E", hash_generated_method = "3DA5A218861BF88384DF5B59A9B3B94E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onPreparePanel(int featureId, View view, Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(menu.dsTaint);
        dsTaint.addTaint(featureId);
        dsTaint.addTaint(view.dsTaint);
        {
            boolean goforit;
            goforit = onPrepareOptionsMenu(menu);
            boolean var7116118DD297E6C08BE1AD40992AA51A_1064848334 = (goforit && menu.hasVisibleItems());
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (featureId == Window.FEATURE_OPTIONS_PANEL && menu != null) {
            //boolean goforit = onPrepareOptionsMenu(menu);
            //return goforit && menu.hasVisibleItems();
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.268 -0400", hash_original_method = "F5A72D2A4A42C0CE2781798802611276", hash_generated_method = "345327D3D92782804F37EC4CFCF70D2B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onMenuOpened(int featureId, Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(menu.dsTaint);
        dsTaint.addTaint(featureId);
        {
            mActionBar.dispatchMenuVisibilityChanged(true);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (featureId == Window.FEATURE_ACTION_BAR) {
            //mActionBar.dispatchMenuVisibilityChanged(true);
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.269 -0400", hash_original_method = "CDCEA93B87CB4399825B767626A61473", hash_generated_method = "5197496732E20E27BABB73FCFDC46A94")
    @DSModeled(DSC.SAFE)
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(item.dsTaint);
        dsTaint.addTaint(featureId);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.269 -0400", hash_original_method = "20C3110FD341FFE95CFF6A6C95609D00", hash_generated_method = "B1DC3D844815244A5C4F6F0DFE5EC0E3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onPanelClosed(int featureId, Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(menu.dsTaint);
        dsTaint.addTaint(featureId);
        {
            mActionBar.dispatchMenuVisibilityChanged(false);
        } //End block
        // ---------- Original Method ----------
        //if (featureId == Window.FEATURE_ACTION_BAR) {
            //mActionBar.dispatchMenuVisibilityChanged(false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.270 -0400", hash_original_method = "F3CAA7B8E21AB403B530132B4E52A4EB", hash_generated_method = "73B4FF1907DE46FA793ED1F9935D38BA")
    @DSModeled(DSC.SAFE)
    public boolean onCreateOptionsMenu(Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(menu.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.270 -0400", hash_original_method = "BF0F08B18C75FC62D01E0D6DB107696E", hash_generated_method = "CB4BAB634FB4D2DF6FCF514B8E6A51CB")
    @DSModeled(DSC.SAFE)
    public boolean onPrepareOptionsMenu(Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(menu.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.270 -0400", hash_original_method = "8EF9A1828892EFEBF4B93362A866125C", hash_generated_method = "6814944D3BF2F9192DA171F02183EF45")
    @DSModeled(DSC.SAFE)
    public boolean onOptionsItemSelected(MenuItem item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(item.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.271 -0400", hash_original_method = "D53E4189B6E7F0EC0F9883E9844F2140", hash_generated_method = "3A76DA4E8EF6038718A7FF2EBAFB77BD")
    @DSModeled(DSC.SAFE)
    public void onOptionsMenuClosed(Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(menu.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.271 -0400", hash_original_method = "756759165F6AB2C8C6E469E63BE14186", hash_generated_method = "8F36C449192E9A4FC8F578B78BE7C244")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void openOptionsMenu() {
        mWindow.openPanel(Window.FEATURE_OPTIONS_PANEL, null);
        // ---------- Original Method ----------
        //mWindow.openPanel(Window.FEATURE_OPTIONS_PANEL, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.272 -0400", hash_original_method = "D12ED1735BBB9BCDCD831C99F03640D7", hash_generated_method = "249BD0BDCB652EF31D4B735086D0BDEC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void closeOptionsMenu() {
        mWindow.closePanel(Window.FEATURE_OPTIONS_PANEL);
        // ---------- Original Method ----------
        //mWindow.closePanel(Window.FEATURE_OPTIONS_PANEL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.272 -0400", hash_original_method = "319389EBA801B290FB41D02473EB2E9E", hash_generated_method = "E3CB03CA5E4EB5916215E567B4276E95")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void invalidateOptionsMenu() {
        mWindow.invalidatePanelMenu(Window.FEATURE_OPTIONS_PANEL);
        // ---------- Original Method ----------
        //mWindow.invalidatePanelMenu(Window.FEATURE_OPTIONS_PANEL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.272 -0400", hash_original_method = "85F2A519B2781A30F4BC68DB47459C98", hash_generated_method = "9BE5DB40B40B7B9323D66297C40214B1")
    @DSModeled(DSC.SAFE)
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(v.dsTaint);
        dsTaint.addTaint(menuInfo.dsTaint);
        dsTaint.addTaint(menu.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.273 -0400", hash_original_method = "1A123249F7C2C892EA53E2F44D60C1FB", hash_generated_method = "9303A120679EFDCECFF0557014C3F44C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForContextMenu(View view) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(view.dsTaint);
        view.setOnCreateContextMenuListener(this);
        // ---------- Original Method ----------
        //view.setOnCreateContextMenuListener(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.273 -0400", hash_original_method = "6A7E2B106BB1CEE7C3B668A773DE5A5B", hash_generated_method = "B4C81DA9CA6119CB0B2BC57EF94EC72A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForContextMenu(View view) {
        dsTaint.addTaint(view.dsTaint);
        view.setOnCreateContextMenuListener(null);
        // ---------- Original Method ----------
        //view.setOnCreateContextMenuListener(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.274 -0400", hash_original_method = "D1451DBD5DFD14FAE397660897192E3C", hash_generated_method = "848A881741C2A51ABBD3134FF0D902D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void openContextMenu(View view) {
        dsTaint.addTaint(view.dsTaint);
        view.showContextMenu();
        // ---------- Original Method ----------
        //view.showContextMenu();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.282 -0400", hash_original_method = "801D77DFDCCE5570587CA592634E3D3B", hash_generated_method = "FAAE04AB5046596C0BC4461D258162EB")
    @DSModeled(DSC.SAFE)
    public boolean onContextItemSelected(MenuItem item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(item.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.284 -0400", hash_original_method = "5C6F377B774E414E6D9422BBC7AAE81F", hash_generated_method = "A7F202C6758654CE596DAED1D264AEF2")
    @DSModeled(DSC.SAFE)
    public void onContextMenuClosed(Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(menu.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.289 -0400", hash_original_method = "38790ED2FB6D0EF1B7954716C7615F0D", hash_generated_method = "20C482EE7CB9466185762835C17C21BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onSearchRequested() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        SearchManager searchManager;
        searchManager = (SearchManager) mContext
                .getSystemService(Context.SEARCH_SERVICE);
        ComponentName appName;
        appName = getAssociatedActivity();
        {
            boolean var39077EF7EA373069B451847B267FD676_1852154397 = (appName != null && searchManager.getSearchableInfo(appName) != null);
            {
                searchManager.startSearch(null, false, appName, null, false);
                dismiss();
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final SearchManager searchManager = (SearchManager) mContext
                //.getSystemService(Context.SEARCH_SERVICE);
        //final ComponentName appName = getAssociatedActivity();
        //if (appName != null && searchManager.getSearchableInfo(appName) != null) {
            //searchManager.startSearch(null, false, appName, null, false);
            //dismiss();
            //return true;
        //} else {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.290 -0400", hash_original_method = "5D1C131301342FA877A860064E23A1A6", hash_generated_method = "A2E35717A9F3A27D9F44145933B9EE45")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(callback.dsTaint);
        {
            ActionMode varC7B1CFD44B51A75C688A1BA10AC498EB_845501503 = (mActionBar.startActionMode(callback));
        } //End block
        return (ActionMode)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mActionBar != null) {
            //return mActionBar.startActionMode(callback);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.291 -0400", hash_original_method = "00C0B67E273850713F0D88B8DE976F73", hash_generated_method = "A1AFA65DC39440E79F5D222B50819A83")
    @DSModeled(DSC.SAFE)
    public void onActionModeStarted(ActionMode mode) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(mode.dsTaint);
        // ---------- Original Method ----------
        //mActionMode = mode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.293 -0400", hash_original_method = "9FD315390CEABDE5B2497E2EE78C905A", hash_generated_method = "DDE624BDA678B3216675D7A429DB23DF")
    @DSModeled(DSC.SAFE)
    public void onActionModeFinished(ActionMode mode) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(mode.dsTaint);
        {
            mActionMode = null;
        } //End block
        // ---------- Original Method ----------
        //if (mode == mActionMode) {
            //mActionMode = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.294 -0400", hash_original_method = "2C0F3C4A58B092DBFC10EA72C5A7ED76", hash_generated_method = "4DA28E6B09D57E7EB22ADC241F9A72EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ComponentName getAssociatedActivity() {
        Activity activity;
        activity = mOwnerActivity;
        Context context;
        context = getContext();
        {
            {
                activity = (Activity) context;
            } //End block
            {
                context = (context instanceof ContextWrapper) ?
                        ((ContextWrapper) context).getBaseContext() : 
                        null;
            } //End block
        } //End block
        {
            Object var7B6A584389FB07906F86D920B4F0B19A_1019578795 = (activity.getComponentName());
        } //End flattened ternary
        return (ComponentName)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Activity activity = mOwnerActivity;
        //Context context = getContext();
        //while (activity == null && context != null) {
            //if (context instanceof Activity) {
                //activity = (Activity) context;  
            //} else {
                //context = (context instanceof ContextWrapper) ?
                        //((ContextWrapper) context).getBaseContext() : 
                        //null;                                         
            //}
        //}
        //return activity == null ? null : activity.getComponentName();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.294 -0400", hash_original_method = "18F720E0A5C2702D89E6608BD6B708CA", hash_generated_method = "468157A2BCD7F848D4087838695C5145")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void takeKeyEvents(boolean get) {
        dsTaint.addTaint(get);
        mWindow.takeKeyEvents(get);
        // ---------- Original Method ----------
        //mWindow.takeKeyEvents(get);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.295 -0400", hash_original_method = "3CDF417FCD4F33EAE6CFCF0FB6D583A8", hash_generated_method = "5802D79A58B398DB0459F0D0E2E3E7C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean requestWindowFeature(int featureId) {
        dsTaint.addTaint(featureId);
        boolean varB82514052F40771017139C27F50D7D45_1547145850 = (getWindow().requestFeature(featureId));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getWindow().requestFeature(featureId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.295 -0400", hash_original_method = "E7AFD534CB1DF8060614ED36111B2407", hash_generated_method = "210A175B7E1AFE379FC9F819242999D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setFeatureDrawableResource(int featureId, int resId) {
        dsTaint.addTaint(featureId);
        dsTaint.addTaint(resId);
        getWindow().setFeatureDrawableResource(featureId, resId);
        // ---------- Original Method ----------
        //getWindow().setFeatureDrawableResource(featureId, resId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.296 -0400", hash_original_method = "2E53659D6309BF8C5C8E8AD82BD6A577", hash_generated_method = "8F6D59863888D3BCEBD739D2E68652C9")
    @DSModeled(DSC.SPEC)
    public final void setFeatureDrawableUri(int featureId, Uri uri) {
        dsTaint.addTaint(featureId);
        dsTaint.addTaint(uri.dsTaint);
        getWindow().setFeatureDrawableUri(featureId, uri);
        // ---------- Original Method ----------
        //getWindow().setFeatureDrawableUri(featureId, uri);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.296 -0400", hash_original_method = "D3FA0A5870730A6F3C959B16FC004BCD", hash_generated_method = "031BFC6584676F8A54C90DF9D5B9A750")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setFeatureDrawable(int featureId, Drawable drawable) {
        dsTaint.addTaint(featureId);
        dsTaint.addTaint(drawable.dsTaint);
        getWindow().setFeatureDrawable(featureId, drawable);
        // ---------- Original Method ----------
        //getWindow().setFeatureDrawable(featureId, drawable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.296 -0400", hash_original_method = "4D2A81FF8C2C83F47460DEB3120C04CB", hash_generated_method = "564585A21472A470FEFAB96CE1D2314B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setFeatureDrawableAlpha(int featureId, int alpha) {
        dsTaint.addTaint(alpha);
        dsTaint.addTaint(featureId);
        getWindow().setFeatureDrawableAlpha(featureId, alpha);
        // ---------- Original Method ----------
        //getWindow().setFeatureDrawableAlpha(featureId, alpha);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.297 -0400", hash_original_method = "2F200E491A9F2CDC38C392035D21ED48", hash_generated_method = "10B5D506FC01414934CAC971F0D89E56")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LayoutInflater getLayoutInflater() {
        LayoutInflater var3465C34A946175F3636FF96D45866694_84151249 = (getWindow().getLayoutInflater());
        return (LayoutInflater)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getWindow().getLayoutInflater();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.297 -0400", hash_original_method = "C80CDCB014C953B0801E95FEB1706C5F", hash_generated_method = "A49B9373293B1C7E9D9381ED2BCDD021")
    @DSModeled(DSC.SAFE)
    public void setCancelable(boolean flag) {
        dsTaint.addTaint(flag);
        // ---------- Original Method ----------
        //mCancelable = flag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.298 -0400", hash_original_method = "BD7DFECDBEA3F81451B9076CEFC17564", hash_generated_method = "9A7EE3DD5DFED540DF3CCC81C5A551B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCanceledOnTouchOutside(boolean cancel) {
        dsTaint.addTaint(cancel);
        {
            mCancelable = true;
        } //End block
        mWindow.setCloseOnTouchOutside(cancel);
        // ---------- Original Method ----------
        //if (cancel && !mCancelable) {
            //mCancelable = true;
        //}
        //mWindow.setCloseOnTouchOutside(cancel);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.298 -0400", hash_original_method = "4DD1D51C0E16D279CD855F2D66BA21A6", hash_generated_method = "04D5A6A3EA2A41A883B809CB24D2E65F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void cancel() {
        {
            mCanceled = true;
            Message.obtain(mCancelMessage).sendToTarget();
        } //End block
        dismiss();
        // ---------- Original Method ----------
        //if (!mCanceled && mCancelMessage != null) {
            //mCanceled = true;
            //Message.obtain(mCancelMessage).sendToTarget();
        //}
        //dismiss();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.299 -0400", hash_original_method = "B6A3C715E726D4D77D298D569C13057A", hash_generated_method = "AADDD9292A8D13584CD89AAFE72877B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOnCancelListener(final OnCancelListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "OnCancelListener is already taken by "
                    + mCancelAndDismissTaken + " and can not be replaced.");
        } //End block
        {
            mCancelMessage = mListenersHandler.obtainMessage(CANCEL, listener);
        } //End block
        {
            mCancelMessage = null;
        } //End block
        // ---------- Original Method ----------
        //if (mCancelAndDismissTaken != null) {
            //throw new IllegalStateException(
                    //"OnCancelListener is already taken by "
                    //+ mCancelAndDismissTaken + " and can not be replaced.");
        //}
        //if (listener != null) {
            //mCancelMessage = mListenersHandler.obtainMessage(CANCEL, listener);
        //} else {
            //mCancelMessage = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.299 -0400", hash_original_method = "774019D9ADE46FB9924B78D145C17F36", hash_generated_method = "26E69396245ED2B397A17F9EF0C6C707")
    @DSModeled(DSC.SAFE)
    public void setCancelMessage(final Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        // ---------- Original Method ----------
        //mCancelMessage = msg;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.300 -0400", hash_original_method = "464A84E289A7DD535A8EA3034BC5D33F", hash_generated_method = "93607EF787429EDDF77283CE8A5166F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOnDismissListener(final OnDismissListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "OnDismissListener is already taken by "
                    + mCancelAndDismissTaken + " and can not be replaced.");
        } //End block
        {
            mDismissMessage = mListenersHandler.obtainMessage(DISMISS, listener);
        } //End block
        {
            mDismissMessage = null;
        } //End block
        // ---------- Original Method ----------
        //if (mCancelAndDismissTaken != null) {
            //throw new IllegalStateException(
                    //"OnDismissListener is already taken by "
                    //+ mCancelAndDismissTaken + " and can not be replaced.");
        //}
        //if (listener != null) {
            //mDismissMessage = mListenersHandler.obtainMessage(DISMISS, listener);
        //} else {
            //mDismissMessage = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.300 -0400", hash_original_method = "0B69163DC80B46ACDA2709DE4C77DC2F", hash_generated_method = "71C44FB9375C31444CAC5CA91CF4BE8D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOnShowListener(OnShowListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        {
            mShowMessage = mListenersHandler.obtainMessage(SHOW, listener);
        } //End block
        {
            mShowMessage = null;
        } //End block
        // ---------- Original Method ----------
        //if (listener != null) {
            //mShowMessage = mListenersHandler.obtainMessage(SHOW, listener);
        //} else {
            //mShowMessage = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.301 -0400", hash_original_method = "2BD742B46509FC81ABA0DF4EC8F37AEC", hash_generated_method = "04A55F89B8D51B5DE1A95E0EBA19ADC1")
    @DSModeled(DSC.SAFE)
    public void setDismissMessage(final Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        // ---------- Original Method ----------
        //mDismissMessage = msg;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.301 -0400", hash_original_method = "4322D13EDCAAC15D5143567F42FC68A2", hash_generated_method = "9AFA728A406CAE1DB52B9F40C5BFB4D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean takeCancelAndDismissListeners(String msg, final OnCancelListener cancel,
            final OnDismissListener dismiss) {
        dsTaint.addTaint(cancel.dsTaint);
        dsTaint.addTaint(msg);
        dsTaint.addTaint(dismiss.dsTaint);
        {
            mCancelAndDismissTaken = null;
        } //End block
        setOnCancelListener(cancel);
        setOnDismissListener(dismiss);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mCancelAndDismissTaken != null) {
            //mCancelAndDismissTaken = null;
        //} else if (mCancelMessage != null || mDismissMessage != null) {
            //return false;
        //}
        //setOnCancelListener(cancel);
        //setOnDismissListener(dismiss);
        //mCancelAndDismissTaken = msg;
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.302 -0400", hash_original_method = "70729F29EB37CCBEC739A5986214C32F", hash_generated_method = "79E7D5D14A84C736F35D1632499544A6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setVolumeControlStream(int streamType) {
        dsTaint.addTaint(streamType);
        getWindow().setVolumeControlStream(streamType);
        // ---------- Original Method ----------
        //getWindow().setVolumeControlStream(streamType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.302 -0400", hash_original_method = "03A841DC7655848901B3CE2C14084AAE", hash_generated_method = "39AE5639DEA7165A7B1C68B9DF9F2FA2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getVolumeControlStream() {
        int var10019DD6073F3F6675C482019A78518D_938734638 = (getWindow().getVolumeControlStream());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getWindow().getVolumeControlStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.302 -0400", hash_original_method = "A9C3EE1B48BA32717B6024C41DF4E1F6", hash_generated_method = "5CC6CD37EF8629AE9F69154D3305B4D7")
    @DSModeled(DSC.SAFE)
    public void setOnKeyListener(final OnKeyListener onKeyListener) {
        dsTaint.addTaint(onKeyListener.dsTaint);
        // ---------- Original Method ----------
        //mOnKeyListener = onKeyListener;
    }

    
    private static final class ListenersHandler extends Handler {
        private WeakReference<DialogInterface> mDialog;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.303 -0400", hash_original_method = "92DAC0D6E122198BF26AB724936B6539", hash_generated_method = "8EF453DB58F4AD0C4956857AFE0AB657")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ListenersHandler(Dialog dialog) {
            dsTaint.addTaint(dialog.dsTaint);
            mDialog = new WeakReference<DialogInterface>(dialog);
            // ---------- Original Method ----------
            //mDialog = new WeakReference<DialogInterface>(dialog);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.303 -0400", hash_original_method = "0AC2BA822DE6E333F562D01CFB6CE49A", hash_generated_method = "95A12D6AC2CE842FDBC9298D6301F8D3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void handleMessage(Message msg) {
            dsTaint.addTaint(msg.dsTaint);
            //Begin case DISMISS 
            ((OnDismissListener) msg.obj).onDismiss(mDialog.get());
            //End case DISMISS 
            //Begin case CANCEL 
            ((OnCancelListener) msg.obj).onCancel(mDialog.get());
            //End case CANCEL 
            //Begin case SHOW 
            ((OnShowListener) msg.obj).onShow(mDialog.get());
            //End case SHOW 
            // ---------- Original Method ----------
            //switch (msg.what) {
                //case DISMISS:
                    //((OnDismissListener) msg.obj).onDismiss(mDialog.get());
                    //break;
                //case CANCEL:
                    //((OnCancelListener) msg.obj).onCancel(mDialog.get());
                    //break;
                //case SHOW:
                    //((OnShowListener) msg.obj).onShow(mDialog.get());
                    //break;
            //}
        }

        
    }


    
    private static final String TAG = "Dialog";
    private static final int DISMISS = 0x43;
    private static final int CANCEL = 0x44;
    private static final int SHOW = 0x45;
    private static final String DIALOG_SHOWING_TAG = "android:dialogShowing";
    private static final String DIALOG_HIERARCHY_TAG = "android:dialogHierarchy";
}

