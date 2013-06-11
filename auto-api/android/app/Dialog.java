package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private static final String TAG = "Dialog";
    private Activity mOwnerActivity;
    final Context mContext;
    final WindowManager mWindowManager;
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
    private final Thread mUiThread;
    private final Handler mHandler = new Handler();
    private static final int DISMISS = 0x43;
    private static final int CANCEL = 0x44;
    private static final int SHOW = 0x45;
    private Handler mListenersHandler;
    private ActionMode mActionMode;
    private final Runnable mDismissAction = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.879 -0400", hash_original_method = "BEE19A9C5B7D04B78955A3FD8170F1CA", hash_generated_method = "93D7661F4DC3F28FEDA8D6FC148EF97D")
        @DSModeled(DSC.SAFE)
        public void run() {
            dismissDialog();
            // ---------- Original Method ----------
            //dismissDialog();
        }

        
}; //Transformed anonymous class
    private static final String DIALOG_SHOWING_TAG = "android:dialogShowing";
    private static final String DIALOG_HIERARCHY_TAG = "android:dialogHierarchy";
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.880 -0400", hash_original_method = "BC9D2F22217346E354BF7BFC78A2D0C2", hash_generated_method = "D84125F6EBFCE4953C85E629DFECC1D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Dialog(Context context) {
        this(context, 0, true);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.880 -0400", hash_original_method = "E8683E6729C8449A45D83189604DFAE9", hash_generated_method = "226A62C82F094243B78CEA8F8E33D8E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Dialog(Context context, int theme) {
        this(context, theme, true);
        dsTaint.addTaint(theme);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.880 -0400", hash_original_method = "C6D5E1D2CF37954F320E3261297EC417", hash_generated_method = "E97753EA1AE94A06D2A6D9E09F23FAC1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.881 -0400", hash_original_method = "845C16E53E1BE45A2BA7FF67CD257C6C", hash_generated_method = "5344C36045A4E54B8ADDB12AC067C033")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.881 -0400", hash_original_method = "C9ADA56967BDAFB742C2181BE637639A", hash_generated_method = "83C86C4C567D6B28CA21F086FAD718BE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.881 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "DBB43A20BBBE6CCCD86C4B46BDAF1D4B")
    @DSModeled(DSC.SAFE)
    public final Context getContext() {
        return (Context)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.882 -0400", hash_original_method = "624FE63EC935EE8F7C5CD37954EA0AEA", hash_generated_method = "8D29D8A072820C59ED2E467FB9ED61D2")
    @DSModeled(DSC.SAFE)
    public ActionBar getActionBar() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return (ActionBar)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActionBar;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.882 -0400", hash_original_method = "AEEF4868262FBFB181A318E6FDCF1973", hash_generated_method = "74E9E8F215F2F1E6F1D82043E2BF13C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setOwnerActivity(Activity activity) {
        dsTaint.addTaint(activity.dsTaint);
        getWindow().setVolumeControlStream(mOwnerActivity.getVolumeControlStream());
        // ---------- Original Method ----------
        //mOwnerActivity = activity;
        //getWindow().setVolumeControlStream(mOwnerActivity.getVolumeControlStream());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.882 -0400", hash_original_method = "D833D4731703AD671D7AED3C45CAE756", hash_generated_method = "5902D7CD20B8923E5CA9B2B570A4C3ED")
    @DSModeled(DSC.SAFE)
    public final Activity getOwnerActivity() {
        return (Activity)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mOwnerActivity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.882 -0400", hash_original_method = "F21458EB6FE36A924A49B40493E1F9F8", hash_generated_method = "D0D1F0F40215446BC0F4AAD370E6AFB7")
    @DSModeled(DSC.SAFE)
    public boolean isShowing() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mShowing;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.883 -0400", hash_original_method = "079FA2E5CA600A12F7067E75E853F614", hash_generated_method = "BF51E6AEB08B1BF66EDFC8B6659EF236")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void show() {
        {
            {
                {
                    boolean varDF79E2FDC0F8C38E07A73A6CD2C66427_2005849179 = (mWindow.hasFeature(Window.FEATURE_ACTION_BAR));
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
            boolean varF4E6C6330D33A37486BAA82B7DDC231D_1373998373 = (mActionBar == null && mWindow.hasFeature(Window.FEATURE_ACTION_BAR));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.883 -0400", hash_original_method = "4A0CDBB7EA97DC376E25E0EE43387CF4", hash_generated_method = "3B223E2FECE0863E749551CB0C668038")
    @DSModeled(DSC.SAFE)
    public void hide() {
        {
            mDecor.setVisibility(View.GONE);
        } //End block
        // ---------- Original Method ----------
        //if (mDecor != null) {
            //mDecor.setVisibility(View.GONE);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.884 -0400", hash_original_method = "33443011198828BD072B057DA719765A", hash_generated_method = "D13762339C62B160D0AF258131FE984C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dismiss() {
        {
            boolean varD46220B6DBDB2780BC14591AF2433BD7_882399261 = (Thread.currentThread() != mUiThread);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.884 -0400", hash_original_method = "4ECC78F105BA2AD2FA21893BA556AFFD", hash_generated_method = "DBAE141D55F415BD44F6F935A49CD4C7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void dismissDialog() {
        {
            boolean varAA9215BBF1FF733067DEC864B8F4AC12_930155151 = (mWindow.isDestroyed());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.885 -0400", hash_original_method = "866BAFBEBC09B92D7388CA2F75E61BAD", hash_generated_method = "AF2608DA0D149C612661F7B87CBFDF7B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.885 -0400", hash_original_method = "02D405BDD0443049D755381D9E715694", hash_generated_method = "F914BFBA2A7B52519E821AF137344182")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.885 -0400", hash_original_method = "CD27A7CE58254212F040E7B7DA65BCA4", hash_generated_method = "4FC82A929C5183876C996D400258701B")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.886 -0400", hash_original_method = "B84ED822BC6011EB138B2F6F1D018FE5", hash_generated_method = "7399DFC8E28E76A3EF6D9ED079755666")
    @DSModeled(DSC.SAFE)
    protected void onCreate(Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(savedInstanceState.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.886 -0400", hash_original_method = "1B4F9BFF1D832A07D0E1F41D0B16D2FF", hash_generated_method = "ECEA8B0D3073EC6DF2B8283AA34A12C8")
    @DSModeled(DSC.SAFE)
    protected void onStart() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mActionBar.setShowHideAnimationEnabled(true);
        // ---------- Original Method ----------
        //if (mActionBar != null) mActionBar.setShowHideAnimationEnabled(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.886 -0400", hash_original_method = "28173EE669492C23D10F671D2D034693", hash_generated_method = "E1D086C19E9D222273A37EB81E464CB5")
    @DSModeled(DSC.SAFE)
    protected void onStop() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mActionBar.setShowHideAnimationEnabled(false);
        // ---------- Original Method ----------
        //if (mActionBar != null) mActionBar.setShowHideAnimationEnabled(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.886 -0400", hash_original_method = "2D855197EA1046BD8EC8CA2E991844E1", hash_generated_method = "41CB199FF598C5765FA3298CDBB3853C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.887 -0400", hash_original_method = "EE5C9B4EF0AAEC8AB3AF49A30F3FD2D3", hash_generated_method = "6D9965839A9F3A4648DCBD7612FDC6CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(savedInstanceState.dsTaint);
        final Bundle dialogHierarchyState;
        dialogHierarchyState = savedInstanceState.getBundle(DIALOG_HIERARCHY_TAG);
        dispatchOnCreate(savedInstanceState);
        mWindow.restoreHierarchyState(dialogHierarchyState);
        {
            boolean varB08F34606D5FAE48568279D4B22B1AC4_736040778 = (savedInstanceState.getBoolean(DIALOG_SHOWING_TAG));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.887 -0400", hash_original_method = "51ACB33F24592F8ED3FAFF9D96DEAF2A", hash_generated_method = "BC1575FB97618B2B4FE295C2D61E7F0E")
    @DSModeled(DSC.SAFE)
    public Window getWindow() {
        return (Window)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mWindow;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.888 -0400", hash_original_method = "44957F5326E5A87B91E438DCD3C71232", hash_generated_method = "05C772A8020249D795E2E510FAFF011D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public View getCurrentFocus() {
        {
            Object varF2CA58DC7834394B6A347593E17E623A_1875075658 = (mWindow.getCurrentFocus());
        } //End flattened ternary
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mWindow != null ? mWindow.getCurrentFocus() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.888 -0400", hash_original_method = "FBC1E026CFF410D335B7C0F9A45B0829", hash_generated_method = "74E9C54CCFC8D81B1B4CD20CEAC35CD8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public View findViewById(int id) {
        dsTaint.addTaint(id);
        View var86E7B55A02A98C723837B51FAC1DA5D6_668652137 = (mWindow.findViewById(id));
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mWindow.findViewById(id);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.888 -0400", hash_original_method = "A6A8A3E553FD4B026D939E9AE3AC9985", hash_generated_method = "8B6F35BBE3152FE23AD194E6F74DC1B1")
    @DSModeled(DSC.SAFE)
    public void setContentView(int layoutResID) {
        dsTaint.addTaint(layoutResID);
        mWindow.setContentView(layoutResID);
        // ---------- Original Method ----------
        //mWindow.setContentView(layoutResID);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.889 -0400", hash_original_method = "64A976C0ECE03B8AD97B801012E7B71B", hash_generated_method = "395E33EF5BB83481E82BDC789B082DC3")
    @DSModeled(DSC.SAFE)
    public void setContentView(View view) {
        dsTaint.addTaint(view.dsTaint);
        mWindow.setContentView(view);
        // ---------- Original Method ----------
        //mWindow.setContentView(view);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.889 -0400", hash_original_method = "21FC0CE0727282A96780C185A7B70535", hash_generated_method = "60C850003A58C4F94BFAF9B5010088C9")
    @DSModeled(DSC.SAFE)
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        dsTaint.addTaint(view.dsTaint);
        dsTaint.addTaint(params.dsTaint);
        mWindow.setContentView(view, params);
        // ---------- Original Method ----------
        //mWindow.setContentView(view, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.889 -0400", hash_original_method = "54F8942E4EAEA6A93BE827863701CD23", hash_generated_method = "8F9D7CE11FEFC7E2581EA380589172CC")
    @DSModeled(DSC.SAFE)
    public void addContentView(View view, ViewGroup.LayoutParams params) {
        dsTaint.addTaint(view.dsTaint);
        dsTaint.addTaint(params.dsTaint);
        mWindow.addContentView(view, params);
        // ---------- Original Method ----------
        //mWindow.addContentView(view, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.890 -0400", hash_original_method = "A94A4616451E43B03E2FA5DD3DFB9ED3", hash_generated_method = "15E5B8A722A4CE130FC2382BBDE1C8D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTitle(CharSequence title) {
        dsTaint.addTaint(title);
        mWindow.setTitle(title);
        mWindow.getAttributes().setTitle(title);
        // ---------- Original Method ----------
        //mWindow.setTitle(title);
        //mWindow.getAttributes().setTitle(title);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.890 -0400", hash_original_method = "0D914ED2883864B655DBF2629252A595", hash_generated_method = "70872D1EDC5FF2274BA489802BF1CE0A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTitle(int titleId) {
        dsTaint.addTaint(titleId);
        setTitle(mContext.getText(titleId));
        // ---------- Original Method ----------
        //setTitle(mContext.getText(titleId));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.890 -0400", hash_original_method = "EB61104CC8357BEAF109072385D21C38", hash_generated_method = "8AE8AE62855FE3D3993726E270E40DAD")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.890 -0400", hash_original_method = "2A75FF2C44C4D96068DDAFC2643F0C8B", hash_generated_method = "DA9BC46836632D5DE2442CF165E2ADA1")
    @DSModeled(DSC.SAFE)
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.891 -0400", hash_original_method = "CFFAC7119271281C27F3BEDCE8D82CC2", hash_generated_method = "2AFAF45AA9406DF307A92F98054BE83B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        {
            boolean var0632AF553088255946876F04AB1E8E7D_1079073409 = (keyCode == KeyEvent.KEYCODE_BACK && event.isTracking()
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.891 -0400", hash_original_method = "E364C67ED15F0AA31C6DCFFA6137C8C0", hash_generated_method = "0E01544320A5CC465E03FDA462609D24")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.891 -0400", hash_original_method = "EAEAA0DB8B83D24D321D98459F4FA29E", hash_generated_method = "7828C55E410FD4A2AA83CE6157B6FAF1")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.892 -0400", hash_original_method = "2ECF3E4914B4B3BE2238F799B7435A51", hash_generated_method = "364CE6898BE65A7CFF9904AA77AFAA75")
    @DSModeled(DSC.SAFE)
    public boolean onKeyShortcut(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.892 -0400", hash_original_method = "5A4B1024EA76F961E6155B7F9E2B0909", hash_generated_method = "E6835EF490AF11C2AB9AA6D4448AAA6E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onTouchEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        {
            boolean var31C1B547289343DCAE6EBC7208A847F8_1744923652 = (mCancelable && mShowing && mWindow.shouldCloseOnTouch(mContext, event));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.892 -0400", hash_original_method = "4A983FDB3FF481E2165B7D8D641CDD48", hash_generated_method = "B408743212A32554110D224D6DDF0567")
    @DSModeled(DSC.SAFE)
    public boolean onTrackballEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.893 -0400", hash_original_method = "0E59A005881F30C798F764BCF32D89A3", hash_generated_method = "BEBEED24402A14C8538F8CE978A041B5")
    @DSModeled(DSC.SAFE)
    public boolean onGenericMotionEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.893 -0400", hash_original_method = "4EF468126ED8F0323D4288D03F894270", hash_generated_method = "5607E2C9CD5DB444D6D654AEE73231B7")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.893 -0400", hash_original_method = "32D7339793DCE0D5AEFE6621981EC978", hash_generated_method = "C607EECEEAC7DDCEB734C893F2AC41C9")
    @DSModeled(DSC.SAFE)
    public void onContentChanged() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.894 -0400", hash_original_method = "C7622FC561A602386C2112BC0445F7C6", hash_generated_method = "BD7B79E860C99002DF5F485F018D51C5")
    @DSModeled(DSC.SAFE)
    public void onWindowFocusChanged(boolean hasFocus) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(hasFocus);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.894 -0400", hash_original_method = "D6E949EE9F0768F47016EEA4FC0347A8", hash_generated_method = "2D900B79CAA57F7254CAD443BA396CFB")
    @DSModeled(DSC.SAFE)
    public void onAttachedToWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.894 -0400", hash_original_method = "E592299EBB4DE1D6696EB8C4009A9EF4", hash_generated_method = "431528BFA4E4D3D6E01BD7811B5265F1")
    @DSModeled(DSC.SAFE)
    public void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.895 -0400", hash_original_method = "1435B67C8334D2AC8987004B54F10264", hash_generated_method = "0B273A4287F1B3FE17D7E1392CC2E75A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean dispatchKeyEvent(KeyEvent event) {
        dsTaint.addTaint(event.dsTaint);
        {
            boolean var119FC86DBD10D0451AA68681D2661AF8_1187835355 = ((mOnKeyListener != null) && (mOnKeyListener.onKey(this, event.getKeyCode(), event)));
        } //End collapsed parenthetic
        {
            boolean var524CC85D3B1F7496F0129E1D66C889FF_1595292218 = (mWindow.superDispatchKeyEvent(event));
        } //End collapsed parenthetic
        boolean var9A9ACA17DE81B47807106F3C8C61EFB2_514604644 = (event.dispatch(this, mDecor != null
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.895 -0400", hash_original_method = "BA9D4031BD488C1D379B1950A362F8D4", hash_generated_method = "6F06349F788DBD324603A80996760D0B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean dispatchKeyShortcutEvent(KeyEvent event) {
        dsTaint.addTaint(event.dsTaint);
        {
            boolean var1506FC9A951093FEBE1E9D9D60B77FAA_2089517909 = (mWindow.superDispatchKeyShortcutEvent(event));
        } //End collapsed parenthetic
        boolean varB65319FC5255424F872A964CBDE1432E_1515688710 = (onKeyShortcut(event.getKeyCode(), event));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mWindow.superDispatchKeyShortcutEvent(event)) {
            //return true;
        //}
        //return onKeyShortcut(event.getKeyCode(), event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.895 -0400", hash_original_method = "D3052CDDAC0630315E0F5E7AF5478D0E", hash_generated_method = "99D6A00702D95EA8ED642B27D998BB75")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean dispatchTouchEvent(MotionEvent ev) {
        dsTaint.addTaint(ev.dsTaint);
        {
            boolean var5240AC15FBF7E8C8943B586A077531B5_1905860438 = (mWindow.superDispatchTouchEvent(ev));
        } //End collapsed parenthetic
        boolean var985DA2294C2CD7796EE4EFA7F3FBE91B_385215520 = (onTouchEvent(ev));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mWindow.superDispatchTouchEvent(ev)) {
            //return true;
        //}
        //return onTouchEvent(ev);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.896 -0400", hash_original_method = "2B935C89EDDE71F28E7C978B3C9DCAB0", hash_generated_method = "21806BA4EB383A2AF48315520F5230C1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean dispatchTrackballEvent(MotionEvent ev) {
        dsTaint.addTaint(ev.dsTaint);
        {
            boolean varF25A212D3CF06F711C8BBD649E0977F2_1000504133 = (mWindow.superDispatchTrackballEvent(ev));
        } //End collapsed parenthetic
        boolean varE24895B72E913D801FFC5B9D9055D482_1384835481 = (onTrackballEvent(ev));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mWindow.superDispatchTrackballEvent(ev)) {
            //return true;
        //}
        //return onTrackballEvent(ev);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.896 -0400", hash_original_method = "B6AB9C2BD67E148832650E309163688C", hash_generated_method = "3B64FCD26C8CDD3FC1E13CA9E8C499A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean dispatchGenericMotionEvent(MotionEvent ev) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(ev.dsTaint);
        {
            boolean varC6CFD9FB7BF4B51FA19B29CFED05E764_391354681 = (mWindow.superDispatchGenericMotionEvent(ev));
        } //End collapsed parenthetic
        boolean var82ABE1E641E95D27D650D268E959F965_1024451474 = (onGenericMotionEvent(ev));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mWindow.superDispatchGenericMotionEvent(ev)) {
            //return true;
        //}
        //return onGenericMotionEvent(ev);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.897 -0400", hash_original_method = "3CC377981D86463D050A06CF1F7ED782", hash_generated_method = "E3BE1844E11E8BD7D524A399CEC7BB9D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.897 -0400", hash_original_method = "8FB2859FE43E0606E21921E291A18BDA", hash_generated_method = "C714261247E9068E376FB32B63F0F6DE")
    @DSModeled(DSC.SAFE)
    public View onCreatePanelView(int featureId) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(featureId);
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.897 -0400", hash_original_method = "1B30E4AD9FCCEF2C81163B46B66D301C", hash_generated_method = "E03E7CBA4BDF915D2F5B0CF94303044B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(menu.dsTaint);
        dsTaint.addTaint(featureId);
        {
            boolean var3ADDFAB895A7216D8503161675C1D088_1081568326 = (onCreateOptionsMenu(menu));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (featureId == Window.FEATURE_OPTIONS_PANEL) {
            //return onCreateOptionsMenu(menu);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.898 -0400", hash_original_method = "A95440A37102593BE255304F4188998E", hash_generated_method = "7656D38323F6351DD6E3937F41357FAF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onPreparePanel(int featureId, View view, Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(menu.dsTaint);
        dsTaint.addTaint(featureId);
        dsTaint.addTaint(view.dsTaint);
        {
            boolean goforit;
            goforit = onPrepareOptionsMenu(menu);
            boolean var7116118DD297E6C08BE1AD40992AA51A_188675778 = (goforit && menu.hasVisibleItems());
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (featureId == Window.FEATURE_OPTIONS_PANEL && menu != null) {
            //boolean goforit = onPrepareOptionsMenu(menu);
            //return goforit && menu.hasVisibleItems();
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.898 -0400", hash_original_method = "F5A72D2A4A42C0CE2781798802611276", hash_generated_method = "E43B6FFE82869B3527E85EE2802516F8")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.898 -0400", hash_original_method = "CDCEA93B87CB4399825B767626A61473", hash_generated_method = "0E3EC90A74B901ACE513538E9D8FDE75")
    @DSModeled(DSC.SAFE)
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(item.dsTaint);
        dsTaint.addTaint(featureId);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.899 -0400", hash_original_method = "20C3110FD341FFE95CFF6A6C95609D00", hash_generated_method = "B97E45C25D873892F7B7C8EC604B6248")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.899 -0400", hash_original_method = "F3CAA7B8E21AB403B530132B4E52A4EB", hash_generated_method = "6200108827B4798DA5BC673CD209A0DD")
    @DSModeled(DSC.SAFE)
    public boolean onCreateOptionsMenu(Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(menu.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.899 -0400", hash_original_method = "BF0F08B18C75FC62D01E0D6DB107696E", hash_generated_method = "DDAAFE6B25CD169D60557C010E0DA449")
    @DSModeled(DSC.SAFE)
    public boolean onPrepareOptionsMenu(Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(menu.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.899 -0400", hash_original_method = "8EF9A1828892EFEBF4B93362A866125C", hash_generated_method = "0AF550FBB2F74B7651173930F60DFCDD")
    @DSModeled(DSC.SAFE)
    public boolean onOptionsItemSelected(MenuItem item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(item.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.900 -0400", hash_original_method = "D53E4189B6E7F0EC0F9883E9844F2140", hash_generated_method = "0A714B4CAA88DA60D064B9C926EE7A19")
    @DSModeled(DSC.SAFE)
    public void onOptionsMenuClosed(Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(menu.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.900 -0400", hash_original_method = "756759165F6AB2C8C6E469E63BE14186", hash_generated_method = "C5E1420A924619BD7FCF42769B926EC3")
    @DSModeled(DSC.SAFE)
    public void openOptionsMenu() {
        mWindow.openPanel(Window.FEATURE_OPTIONS_PANEL, null);
        // ---------- Original Method ----------
        //mWindow.openPanel(Window.FEATURE_OPTIONS_PANEL, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.900 -0400", hash_original_method = "D12ED1735BBB9BCDCD831C99F03640D7", hash_generated_method = "C293EABC3EADEC19F8893BAA898F2287")
    @DSModeled(DSC.SAFE)
    public void closeOptionsMenu() {
        mWindow.closePanel(Window.FEATURE_OPTIONS_PANEL);
        // ---------- Original Method ----------
        //mWindow.closePanel(Window.FEATURE_OPTIONS_PANEL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.900 -0400", hash_original_method = "319389EBA801B290FB41D02473EB2E9E", hash_generated_method = "3B7DE101242C5001DBDB882784A7446C")
    @DSModeled(DSC.SAFE)
    public void invalidateOptionsMenu() {
        mWindow.invalidatePanelMenu(Window.FEATURE_OPTIONS_PANEL);
        // ---------- Original Method ----------
        //mWindow.invalidatePanelMenu(Window.FEATURE_OPTIONS_PANEL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.901 -0400", hash_original_method = "85F2A519B2781A30F4BC68DB47459C98", hash_generated_method = "A9507FF45074975C3CAE4CED12E5ABE8")
    @DSModeled(DSC.SAFE)
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(v.dsTaint);
        dsTaint.addTaint(menuInfo.dsTaint);
        dsTaint.addTaint(menu.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.901 -0400", hash_original_method = "1A123249F7C2C892EA53E2F44D60C1FB", hash_generated_method = "D5AEBE7AEEC7D3E3B101DF78C9A3E75E")
    @DSModeled(DSC.SAFE)
    public void registerForContextMenu(View view) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(view.dsTaint);
        view.setOnCreateContextMenuListener(this);
        // ---------- Original Method ----------
        //view.setOnCreateContextMenuListener(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.901 -0400", hash_original_method = "6A7E2B106BB1CEE7C3B668A773DE5A5B", hash_generated_method = "4D9E35D385EF9B5B213AA7FF4E0572BB")
    @DSModeled(DSC.SAFE)
    public void unregisterForContextMenu(View view) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(view.dsTaint);
        view.setOnCreateContextMenuListener(null);
        // ---------- Original Method ----------
        //view.setOnCreateContextMenuListener(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.901 -0400", hash_original_method = "D1451DBD5DFD14FAE397660897192E3C", hash_generated_method = "42C797A24C9EE1616F70442E1C396D9D")
    @DSModeled(DSC.SAFE)
    public void openContextMenu(View view) {
        dsTaint.addTaint(view.dsTaint);
        view.showContextMenu();
        // ---------- Original Method ----------
        //view.showContextMenu();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.902 -0400", hash_original_method = "801D77DFDCCE5570587CA592634E3D3B", hash_generated_method = "34946BF7D2F7704FFE3D5B01C891788E")
    @DSModeled(DSC.SAFE)
    public boolean onContextItemSelected(MenuItem item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(item.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.902 -0400", hash_original_method = "5C6F377B774E414E6D9422BBC7AAE81F", hash_generated_method = "C7A98BC42ED1974DF1F33000E38081E3")
    @DSModeled(DSC.SAFE)
    public void onContextMenuClosed(Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(menu.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.902 -0400", hash_original_method = "38790ED2FB6D0EF1B7954716C7615F0D", hash_generated_method = "1BEA52F0A7AF3591BCCA607CB5622B36")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onSearchRequested() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        final SearchManager searchManager;
        searchManager = (SearchManager) mContext
                .getSystemService(Context.SEARCH_SERVICE);
        final ComponentName appName;
        appName = getAssociatedActivity();
        {
            boolean var39077EF7EA373069B451847B267FD676_527489537 = (appName != null && searchManager.getSearchableInfo(appName) != null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.903 -0400", hash_original_method = "5D1C131301342FA877A860064E23A1A6", hash_generated_method = "55A51F9D443937FC7647B1BB72A69554")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(callback.dsTaint);
        {
            ActionMode varC7B1CFD44B51A75C688A1BA10AC498EB_1986640633 = (mActionBar.startActionMode(callback));
        } //End block
        return (ActionMode)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mActionBar != null) {
            //return mActionBar.startActionMode(callback);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.903 -0400", hash_original_method = "00C0B67E273850713F0D88B8DE976F73", hash_generated_method = "BB1C6F06C76B8E019D3BFC6658406C69")
    @DSModeled(DSC.SAFE)
    public void onActionModeStarted(ActionMode mode) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(mode.dsTaint);
        // ---------- Original Method ----------
        //mActionMode = mode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.903 -0400", hash_original_method = "9FD315390CEABDE5B2497E2EE78C905A", hash_generated_method = "D9C8A28A7D78E81EC8575DF43260F943")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.904 -0400", hash_original_method = "2C0F3C4A58B092DBFC10EA72C5A7ED76", hash_generated_method = "F8E4A738DDE0B457B112CDE66D080C37")
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
            Object var7B6A584389FB07906F86D920B4F0B19A_1175713492 = (activity.getComponentName());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.904 -0400", hash_original_method = "18F720E0A5C2702D89E6608BD6B708CA", hash_generated_method = "DE31726ADAFC95E67B79903F40DF32EB")
    @DSModeled(DSC.SAFE)
    public void takeKeyEvents(boolean get) {
        dsTaint.addTaint(get);
        mWindow.takeKeyEvents(get);
        // ---------- Original Method ----------
        //mWindow.takeKeyEvents(get);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.904 -0400", hash_original_method = "3CDF417FCD4F33EAE6CFCF0FB6D583A8", hash_generated_method = "A2D21E73070F7176037B471D956FE9EC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean requestWindowFeature(int featureId) {
        dsTaint.addTaint(featureId);
        boolean varB82514052F40771017139C27F50D7D45_859177692 = (getWindow().requestFeature(featureId));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getWindow().requestFeature(featureId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.905 -0400", hash_original_method = "E7AFD534CB1DF8060614ED36111B2407", hash_generated_method = "AE2A3CD5F810F5101A122FDB79D1405C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setFeatureDrawableResource(int featureId, int resId) {
        dsTaint.addTaint(featureId);
        dsTaint.addTaint(resId);
        getWindow().setFeatureDrawableResource(featureId, resId);
        // ---------- Original Method ----------
        //getWindow().setFeatureDrawableResource(featureId, resId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.905 -0400", hash_original_method = "2E53659D6309BF8C5C8E8AD82BD6A577", hash_generated_method = "120A5780594DBF5623D7F9B160CF8F62")
    @DSModeled(DSC.SPEC)
    public final void setFeatureDrawableUri(int featureId, Uri uri) {
        dsTaint.addTaint(featureId);
        dsTaint.addTaint(uri.dsTaint);
        getWindow().setFeatureDrawableUri(featureId, uri);
        // ---------- Original Method ----------
        //getWindow().setFeatureDrawableUri(featureId, uri);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.905 -0400", hash_original_method = "D3FA0A5870730A6F3C959B16FC004BCD", hash_generated_method = "8AE8BFF4603816CA319428F6ACD8E111")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setFeatureDrawable(int featureId, Drawable drawable) {
        dsTaint.addTaint(featureId);
        dsTaint.addTaint(drawable.dsTaint);
        getWindow().setFeatureDrawable(featureId, drawable);
        // ---------- Original Method ----------
        //getWindow().setFeatureDrawable(featureId, drawable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.906 -0400", hash_original_method = "4D2A81FF8C2C83F47460DEB3120C04CB", hash_generated_method = "B796E379B5D7A6026F0198D5CFE3899E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setFeatureDrawableAlpha(int featureId, int alpha) {
        dsTaint.addTaint(alpha);
        dsTaint.addTaint(featureId);
        getWindow().setFeatureDrawableAlpha(featureId, alpha);
        // ---------- Original Method ----------
        //getWindow().setFeatureDrawableAlpha(featureId, alpha);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.906 -0400", hash_original_method = "2F200E491A9F2CDC38C392035D21ED48", hash_generated_method = "83E3D2A21E3109CBFBC0896BC815A6FA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LayoutInflater getLayoutInflater() {
        LayoutInflater var3465C34A946175F3636FF96D45866694_1409359766 = (getWindow().getLayoutInflater());
        return (LayoutInflater)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getWindow().getLayoutInflater();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.906 -0400", hash_original_method = "C80CDCB014C953B0801E95FEB1706C5F", hash_generated_method = "14ECFB74B85D3E1E112426AB4B2F4CED")
    @DSModeled(DSC.SAFE)
    public void setCancelable(boolean flag) {
        dsTaint.addTaint(flag);
        // ---------- Original Method ----------
        //mCancelable = flag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.906 -0400", hash_original_method = "BD7DFECDBEA3F81451B9076CEFC17564", hash_generated_method = "020CC3FFBD620E35CDE067177076804A")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.907 -0400", hash_original_method = "4DD1D51C0E16D279CD855F2D66BA21A6", hash_generated_method = "F500F627CAA2F95EA45E3C6F3579B403")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.907 -0400", hash_original_method = "B6A3C715E726D4D77D298D569C13057A", hash_generated_method = "F870029CF10A64B5A867865342D01767")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOnCancelListener(final OnCancelListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        {
            throw new IllegalStateException(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.907 -0400", hash_original_method = "774019D9ADE46FB9924B78D145C17F36", hash_generated_method = "9C37CEBDADA04E7E49616A9952FACA34")
    @DSModeled(DSC.SAFE)
    public void setCancelMessage(final Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        // ---------- Original Method ----------
        //mCancelMessage = msg;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.908 -0400", hash_original_method = "464A84E289A7DD535A8EA3034BC5D33F", hash_generated_method = "E8DECA402D21283D54DF2CE6303935B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOnDismissListener(final OnDismissListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        {
            throw new IllegalStateException(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.908 -0400", hash_original_method = "0B69163DC80B46ACDA2709DE4C77DC2F", hash_generated_method = "35D7E739D09E92D1E563F618306DF051")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.908 -0400", hash_original_method = "2BD742B46509FC81ABA0DF4EC8F37AEC", hash_generated_method = "1BBDF49AE1E7130FE30D199CDB4B0687")
    @DSModeled(DSC.SAFE)
    public void setDismissMessage(final Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        // ---------- Original Method ----------
        //mDismissMessage = msg;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.909 -0400", hash_original_method = "4322D13EDCAAC15D5143567F42FC68A2", hash_generated_method = "8D002EFEAD9F9931F6FD4D68C1BA5635")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.909 -0400", hash_original_method = "70729F29EB37CCBEC739A5986214C32F", hash_generated_method = "448C76726BFAB336F3C6D49C85E5F133")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setVolumeControlStream(int streamType) {
        dsTaint.addTaint(streamType);
        getWindow().setVolumeControlStream(streamType);
        // ---------- Original Method ----------
        //getWindow().setVolumeControlStream(streamType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.909 -0400", hash_original_method = "03A841DC7655848901B3CE2C14084AAE", hash_generated_method = "76F75C112E004E6D9A909AA05CD41C61")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getVolumeControlStream() {
        int var10019DD6073F3F6675C482019A78518D_747613925 = (getWindow().getVolumeControlStream());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getWindow().getVolumeControlStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.910 -0400", hash_original_method = "A9C3EE1B48BA32717B6024C41DF4E1F6", hash_generated_method = "4A9D906F38E0C80EA7D129E8804F458E")
    @DSModeled(DSC.SAFE)
    public void setOnKeyListener(final OnKeyListener onKeyListener) {
        dsTaint.addTaint(onKeyListener.dsTaint);
        // ---------- Original Method ----------
        //mOnKeyListener = onKeyListener;
    }

    
    private static final class ListenersHandler extends Handler {
        private WeakReference<DialogInterface> mDialog;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.910 -0400", hash_original_method = "92DAC0D6E122198BF26AB724936B6539", hash_generated_method = "33C0581D9A8EF942D3E6C652F577918C")
        @DSModeled(DSC.SAFE)
        public ListenersHandler(Dialog dialog) {
            dsTaint.addTaint(dialog.dsTaint);
            mDialog = new WeakReference<DialogInterface>(dialog);
            // ---------- Original Method ----------
            //mDialog = new WeakReference<DialogInterface>(dialog);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.910 -0400", hash_original_method = "0AC2BA822DE6E333F562D01CFB6CE49A", hash_generated_method = "A30B675977F58E739EE53B00B96D3538")
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


    
}


