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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.277 -0400", hash_original_field = "581D71027A593FE178E11F8CF96A261F", hash_generated_field = "8ACEFA51F1C212AC94944686D7E3BDFC")

    private Activity mOwnerActivity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.277 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "B997E37019471EC8FC5B98148C7A8AD7")

    Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.278 -0400", hash_original_field = "306519E50E3A91B9733D09F5D8EB985C", hash_generated_field = "83A062836C11DD52DC32F4325712F233")

    WindowManager mWindowManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.279 -0400", hash_original_field = "F4214BE1FFE044F8CA79EEDDDED72016", hash_generated_field = "C6B08D42C8EA2CB56500460CAF662F4C")

    Window mWindow;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.279 -0400", hash_original_field = "90456FC221E7A82F02F5F0D86665E9D8", hash_generated_field = "B4A10D2FE94FCA7877DCD1F8197DA38F")

    View mDecor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.280 -0400", hash_original_field = "6468B2E0460CFBFD40C03C7A36A45FDF", hash_generated_field = "7F8EF508978F38B8BCEC28D592DBFC22")

    private ActionBarImpl mActionBar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.292 -0400", hash_original_field = "CBE9C1F82FCE1BB545B279BE8BBA93EE", hash_generated_field = "6123942D1383A17F765E6BC984B8086E")

    protected boolean mCancelable = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.292 -0400", hash_original_field = "5EECE75098F1C3EE2E7D5C5604E7ABBE", hash_generated_field = "B13EDAE25BF4DFF139CD5FAE4D2A0A25")

    private String mCancelAndDismissTaken;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.293 -0400", hash_original_field = "4D534CFD5536B7EAE26E671B61999A02", hash_generated_field = "76C74178C09C090FAEDAAD0E8B0CF7A0")

    private Message mCancelMessage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.293 -0400", hash_original_field = "BE5032B19401D6C75DF159B7C44D7C01", hash_generated_field = "E192DE29CF3B86E1D4D51306D6613B44")

    private Message mDismissMessage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.298 -0400", hash_original_field = "9FDEEA4D408D357BE228AE1A75ED9410", hash_generated_field = "9DF7AF46D4C4365744738EB8C5D01451")

    private Message mShowMessage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.299 -0400", hash_original_field = "2A4FF7110738976278729426D6DBEF1F", hash_generated_field = "E9EAFA3F5F183CD7232E888DAC035728")

    private OnKeyListener mOnKeyListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.299 -0400", hash_original_field = "721C926D9558D59E55B02399D96F5508", hash_generated_field = "AE31AA5AE388883F7650182C0E3C7933")

    private boolean mCreated = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.300 -0400", hash_original_field = "B150E8FC39372026A2B260E47009CF79", hash_generated_field = "524E990B3B93C6331366CC3FFD800C87")

    private boolean mShowing = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.301 -0400", hash_original_field = "D91530AF3D6C660AC2C0C8D4CBB2367B", hash_generated_field = "67D6DA73468F2D6E84B945FD38F1CC1D")

    private boolean mCanceled = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.301 -0400", hash_original_field = "C5D62B7C4F8BE6B828DA51239EC692E0", hash_generated_field = "A94051227A36AE91A6CE3B31BF1DD3E6")

    private Thread mUiThread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.310 -0400", hash_original_field = "6781893E9FA50A9B7103FD3F674E566B", hash_generated_field = "2E60E17486AAEB1A4E1F1878A0354061")

    private Handler mHandler = new Handler();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.311 -0400", hash_original_field = "A7C53D678AF31C89461A94B80C89667F", hash_generated_field = "BE6770D46FDA6621A2256CC938B90138")

    private Handler mListenersHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.311 -0400", hash_original_field = "3B382D379664B509F22D0EB5D96F2BA8", hash_generated_field = "941205D807AC4DF9704A65BDAF4756EC")

    private ActionMode mActionMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.337 -0400", hash_original_field = "90764B7AE877EFFD33D3124ADF85860E", hash_generated_field = "24E8D998709B7B220E055562AA07F5CB")

    private Runnable mDismissAction = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.332 -0400", hash_original_method = "BEE19A9C5B7D04B78955A3FD8170F1CA", hash_generated_method = "4B98EED19700DEC05BCE304A452DAE0F")
        public void run() {
            dismissDialog();
            // ---------- Original Method ----------
            //dismissDialog();
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.338 -0400", hash_original_method = "BC9D2F22217346E354BF7BFC78A2D0C2", hash_generated_method = "6CD06A2CC25407F07D3CFC5AD07F9ABC")
    public  Dialog(Context context) {
        this(context, 0, true);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.340 -0400", hash_original_method = "E8683E6729C8449A45D83189604DFAE9", hash_generated_method = "5CA78AFC53891D0639109A18F53ECD42")
    public  Dialog(Context context, int theme) {
        this(context, theme, true);
        addTaint(context.getTaint());
        addTaint(theme);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.369 -0400", hash_original_method = "C6D5E1D2CF37954F320E3261297EC417", hash_generated_method = "959D8CDB5F1DCF6DCEC14DFCC3B6911C")
      Dialog(Context context, int theme, boolean createContextWrapper) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.388 -0400", hash_original_method = "845C16E53E1BE45A2BA7FF67CD257C6C", hash_generated_method = "8FF4AE7B837C1FEB8E9EA8FAA6828F71")
    @Deprecated
    protected  Dialog(Context context, boolean cancelable,
            Message cancelCallback) {
        this(context);
        mCancelable = cancelable;
        mCancelMessage = cancelCallback;
        addTaint(context.getTaint());
        // ---------- Original Method ----------
        //mCancelable = cancelable;
        //mCancelMessage = cancelCallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.390 -0400", hash_original_method = "C9ADA56967BDAFB742C2181BE637639A", hash_generated_method = "C6A8EE2383DA47A24EC7C78C286387AF")
    protected  Dialog(Context context, boolean cancelable,
            OnCancelListener cancelListener) {
        this(context);
        mCancelable = cancelable;
        setOnCancelListener(cancelListener);
        addTaint(context.getTaint());
        addTaint(cancelListener.getTaint());
        // ---------- Original Method ----------
        //mCancelable = cancelable;
        //setOnCancelListener(cancelListener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.408 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "AC1DD68EACCA6BE3351E48EEFB1F01D4")
    public final Context getContext() {
        Context varB4EAC82CA7396A68D541C85D26508E83_218071018 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_218071018 = mContext;
        varB4EAC82CA7396A68D541C85D26508E83_218071018.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_218071018;
        // ---------- Original Method ----------
        //return mContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.410 -0400", hash_original_method = "624FE63EC935EE8F7C5CD37954EA0AEA", hash_generated_method = "1F90EB7D408C98252DB72D835D930185")
    public ActionBar getActionBar() {
        ActionBar varB4EAC82CA7396A68D541C85D26508E83_2104568607 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2104568607 = mActionBar;
        varB4EAC82CA7396A68D541C85D26508E83_2104568607.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2104568607;
        // ---------- Original Method ----------
        //return mActionBar;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.427 -0400", hash_original_method = "AEEF4868262FBFB181A318E6FDCF1973", hash_generated_method = "2225ED786D910828047D511078A525A3")
    public final void setOwnerActivity(Activity activity) {
        mOwnerActivity = activity;
        getWindow().setVolumeControlStream(mOwnerActivity.getVolumeControlStream());
        // ---------- Original Method ----------
        //mOwnerActivity = activity;
        //getWindow().setVolumeControlStream(mOwnerActivity.getVolumeControlStream());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.458 -0400", hash_original_method = "D833D4731703AD671D7AED3C45CAE756", hash_generated_method = "BD351BCF148BF65B60991C47A7032257")
    public final Activity getOwnerActivity() {
        Activity varB4EAC82CA7396A68D541C85D26508E83_1913783573 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1913783573 = mOwnerActivity;
        varB4EAC82CA7396A68D541C85D26508E83_1913783573.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1913783573;
        // ---------- Original Method ----------
        //return mOwnerActivity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.460 -0400", hash_original_method = "F21458EB6FE36A924A49B40493E1F9F8", hash_generated_method = "C412F6C3AC2514649174AFF7A7320995")
    public boolean isShowing() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1276314857 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1276314857;
        // ---------- Original Method ----------
        //return mShowing;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.492 -0400", hash_original_method = "079FA2E5CA600A12F7067E75E853F614", hash_generated_method = "986A615B07F3273C928B7B2C65DD0C14")
    public void show() {
        {
            {
                {
                    boolean varDF79E2FDC0F8C38E07A73A6CD2C66427_1783566249 = (mWindow.hasFeature(Window.FEATURE_ACTION_BAR));
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
            boolean varF4E6C6330D33A37486BAA82B7DDC231D_203035251 = (mActionBar == null && mWindow.hasFeature(Window.FEATURE_ACTION_BAR));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.501 -0400", hash_original_method = "4A0CDBB7EA97DC376E25E0EE43387CF4", hash_generated_method = "D960C5A95FEB753FEAD909D760B2CA18")
    public void hide() {
        {
            mDecor.setVisibility(View.GONE);
        } //End block
        // ---------- Original Method ----------
        //if (mDecor != null) {
            //mDecor.setVisibility(View.GONE);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.516 -0400", hash_original_method = "33443011198828BD072B057DA719765A", hash_generated_method = "400AC50248A9559C408683B78FF8638E")
    public void dismiss() {
        {
            boolean varD46220B6DBDB2780BC14591AF2433BD7_182288052 = (Thread.currentThread() != mUiThread);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.531 -0400", hash_original_method = "4ECC78F105BA2AD2FA21893BA556AFFD", hash_generated_method = "3BA0C610BFC3D9518776F169E84C15D7")
     void dismissDialog() {
        {
            boolean varAA9215BBF1FF733067DEC864B8F4AC12_614700944 = (mWindow.isDestroyed());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.541 -0400", hash_original_method = "866BAFBEBC09B92D7388CA2F75E61BAD", hash_generated_method = "1EA55A4647FD1A132F53711D4AB8E09B")
    private void sendDismissMessage() {
        {
            Message.obtain(mDismissMessage).sendToTarget();
        } //End block
        // ---------- Original Method ----------
        //if (mDismissMessage != null) {
            //Message.obtain(mDismissMessage).sendToTarget();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.554 -0400", hash_original_method = "02D405BDD0443049D755381D9E715694", hash_generated_method = "FB6E6E412C3BA60E0F71F6858C0C0653")
    private void sendShowMessage() {
        {
            Message.obtain(mShowMessage).sendToTarget();
        } //End block
        // ---------- Original Method ----------
        //if (mShowMessage != null) {
            //Message.obtain(mShowMessage).sendToTarget();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.577 -0400", hash_original_method = "CD27A7CE58254212F040E7B7DA65BCA4", hash_generated_method = "6838EEEF28CAB6EF9F4A845156456478")
     void dispatchOnCreate(Bundle savedInstanceState) {
        {
            onCreate(savedInstanceState);
            mCreated = true;
        } //End block
        addTaint(savedInstanceState.getTaint());
        // ---------- Original Method ----------
        //if (!mCreated) {
            //onCreate(savedInstanceState);
            //mCreated = true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.578 -0400", hash_original_method = "B84ED822BC6011EB138B2F6F1D018FE5", hash_generated_method = "DE98DECCC817096DF1B839F626292181")
    protected void onCreate(Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(savedInstanceState.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.594 -0400", hash_original_method = "1B4F9BFF1D832A07D0E1F41D0B16D2FF", hash_generated_method = "BE9AD01CB83E36F19DAEE7EFF770DFAE")
    protected void onStart() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mActionBar.setShowHideAnimationEnabled(true);
        // ---------- Original Method ----------
        //if (mActionBar != null) mActionBar.setShowHideAnimationEnabled(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.595 -0400", hash_original_method = "28173EE669492C23D10F671D2D034693", hash_generated_method = "EFC4CEDE95009F9A2C76BCB60E4786BD")
    protected void onStop() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mActionBar.setShowHideAnimationEnabled(false);
        // ---------- Original Method ----------
        //if (mActionBar != null) mActionBar.setShowHideAnimationEnabled(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.615 -0400", hash_original_method = "2D855197EA1046BD8EC8CA2E991844E1", hash_generated_method = "70D4A69CFE37A8CA60E47D3EC2D0122E")
    public Bundle onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Bundle varB4EAC82CA7396A68D541C85D26508E83_918348975 = null; //Variable for return #1
        Bundle bundle;
        bundle = new Bundle();
        bundle.putBoolean(DIALOG_SHOWING_TAG, mShowing);
        {
            bundle.putBundle(DIALOG_HIERARCHY_TAG, mWindow.saveHierarchyState());
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_918348975 = bundle;
        varB4EAC82CA7396A68D541C85D26508E83_918348975.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_918348975;
        // ---------- Original Method ----------
        //Bundle bundle = new Bundle();
        //bundle.putBoolean(DIALOG_SHOWING_TAG, mShowing);
        //if (mCreated) {
            //bundle.putBundle(DIALOG_HIERARCHY_TAG, mWindow.saveHierarchyState());
        //}
        //return bundle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.633 -0400", hash_original_method = "EE5C9B4EF0AAEC8AB3AF49A30F3FD2D3", hash_generated_method = "CEFB328E0B81CDA6DE366B45CEEB2AA7")
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Bundle dialogHierarchyState;
        dialogHierarchyState = savedInstanceState.getBundle(DIALOG_HIERARCHY_TAG);
        dispatchOnCreate(savedInstanceState);
        mWindow.restoreHierarchyState(dialogHierarchyState);
        {
            boolean varB08F34606D5FAE48568279D4B22B1AC4_1721255734 = (savedInstanceState.getBoolean(DIALOG_SHOWING_TAG));
            {
                show();
            } //End block
        } //End collapsed parenthetic
        addTaint(savedInstanceState.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.663 -0400", hash_original_method = "51ACB33F24592F8ED3FAFF9D96DEAF2A", hash_generated_method = "2D5A2D7DCC094C6FE322BEA82322BB26")
    public Window getWindow() {
        Window varB4EAC82CA7396A68D541C85D26508E83_1347371791 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1347371791 = mWindow;
        varB4EAC82CA7396A68D541C85D26508E83_1347371791.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1347371791;
        // ---------- Original Method ----------
        //return mWindow;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.669 -0400", hash_original_method = "44957F5326E5A87B91E438DCD3C71232", hash_generated_method = "6EF6699E62D208035D1CD5F6AC829E90")
    public View getCurrentFocus() {
        View varB4EAC82CA7396A68D541C85D26508E83_379067855 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_379067855 = mWindow != null ? mWindow.getCurrentFocus() : null;
        varB4EAC82CA7396A68D541C85D26508E83_379067855.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_379067855;
        // ---------- Original Method ----------
        //return mWindow != null ? mWindow.getCurrentFocus() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.681 -0400", hash_original_method = "FBC1E026CFF410D335B7C0F9A45B0829", hash_generated_method = "D09EE6B98DC2CE30F701BFE6BEC18835")
    public View findViewById(int id) {
        View varB4EAC82CA7396A68D541C85D26508E83_1366834818 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1366834818 = mWindow.findViewById(id);
        addTaint(id);
        varB4EAC82CA7396A68D541C85D26508E83_1366834818.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1366834818;
        // ---------- Original Method ----------
        //return mWindow.findViewById(id);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.689 -0400", hash_original_method = "A6A8A3E553FD4B026D939E9AE3AC9985", hash_generated_method = "5BA5DE54653E468ED261AF17341460E4")
    public void setContentView(int layoutResID) {
        mWindow.setContentView(layoutResID);
        addTaint(layoutResID);
        // ---------- Original Method ----------
        //mWindow.setContentView(layoutResID);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.707 -0400", hash_original_method = "64A976C0ECE03B8AD97B801012E7B71B", hash_generated_method = "83BB1502EB00C9A91C40A63992C5E5C7")
    public void setContentView(View view) {
        mWindow.setContentView(view);
        addTaint(view.getTaint());
        // ---------- Original Method ----------
        //mWindow.setContentView(view);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.716 -0400", hash_original_method = "21FC0CE0727282A96780C185A7B70535", hash_generated_method = "775EDF340CB355EB7BAEEA14FC205BED")
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        mWindow.setContentView(view, params);
        addTaint(view.getTaint());
        addTaint(params.getTaint());
        // ---------- Original Method ----------
        //mWindow.setContentView(view, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.718 -0400", hash_original_method = "54F8942E4EAEA6A93BE827863701CD23", hash_generated_method = "15B77E54CD19304DD85623BB759F93F1")
    public void addContentView(View view, ViewGroup.LayoutParams params) {
        mWindow.addContentView(view, params);
        addTaint(view.getTaint());
        addTaint(params.getTaint());
        // ---------- Original Method ----------
        //mWindow.addContentView(view, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.719 -0400", hash_original_method = "A94A4616451E43B03E2FA5DD3DFB9ED3", hash_generated_method = "18EC9867F86BB156A1BB912D7DD6716A")
    public void setTitle(CharSequence title) {
        mWindow.setTitle(title);
        mWindow.getAttributes().setTitle(title);
        addTaint(title.getTaint());
        // ---------- Original Method ----------
        //mWindow.setTitle(title);
        //mWindow.getAttributes().setTitle(title);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.743 -0400", hash_original_method = "0D914ED2883864B655DBF2629252A595", hash_generated_method = "B8F1170F5CE57BA5A12A340C7E51CDBA")
    public void setTitle(int titleId) {
        setTitle(mContext.getText(titleId));
        addTaint(titleId);
        // ---------- Original Method ----------
        //setTitle(mContext.getText(titleId));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.745 -0400", hash_original_method = "EB61104CC8357BEAF109072385D21C38", hash_generated_method = "D51FA68870BF9CE12C9E07C1845D3DEE")
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            event.startTracking();
        } //End block
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_634327446 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_634327446;
        // ---------- Original Method ----------
        //if (keyCode == KeyEvent.KEYCODE_BACK) {
            //event.startTracking();
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.762 -0400", hash_original_method = "2A75FF2C44C4D96068DDAFC2643F0C8B", hash_generated_method = "8A56BCC42085787A5B2391D4BED7303C")
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1097614531 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1097614531;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.764 -0400", hash_original_method = "CFFAC7119271281C27F3BEDCE8D82CC2", hash_generated_method = "3359204C4E45AAD18FA07D44CF5955D9")
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var0632AF553088255946876F04AB1E8E7D_1775486973 = (keyCode == KeyEvent.KEYCODE_BACK && event.isTracking()
                && !event.isCanceled());
            {
                onBackPressed();
            } //End block
        } //End collapsed parenthetic
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1432031761 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1432031761;
        // ---------- Original Method ----------
        //if (keyCode == KeyEvent.KEYCODE_BACK && event.isTracking()
                //&& !event.isCanceled()) {
            //onBackPressed();
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.782 -0400", hash_original_method = "E364C67ED15F0AA31C6DCFFA6137C8C0", hash_generated_method = "F69A1E2E41F6B36AC53E21768208E00C")
    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(keyCode);
        addTaint(repeatCount);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_663980253 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_663980253;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.784 -0400", hash_original_method = "EAEAA0DB8B83D24D321D98459F4FA29E", hash_generated_method = "3E313C8978C5A46580C6435094C7FE54")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.804 -0400", hash_original_method = "2ECF3E4914B4B3BE2238F799B7435A51", hash_generated_method = "F118FB2385AA65A137D2EF5DE747E474")
    public boolean onKeyShortcut(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_819919521 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_819919521;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.810 -0400", hash_original_method = "5A4B1024EA76F961E6155B7F9E2B0909", hash_generated_method = "A72A9BC49CAE9C7957B63BB52697BF84")
    public boolean onTouchEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var31C1B547289343DCAE6EBC7208A847F8_1239358756 = (mCancelable && mShowing && mWindow.shouldCloseOnTouch(mContext, event));
            {
                cancel();
            } //End block
        } //End collapsed parenthetic
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1430154897 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1430154897;
        // ---------- Original Method ----------
        //if (mCancelable && mShowing && mWindow.shouldCloseOnTouch(mContext, event)) {
            //cancel();
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.811 -0400", hash_original_method = "4A983FDB3FF481E2165B7D8D641CDD48", hash_generated_method = "376BE45DA12EEBFEDFB4A375564E1F20")
    public boolean onTrackballEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_504120691 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_504120691;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.834 -0400", hash_original_method = "0E59A005881F30C798F764BCF32D89A3", hash_generated_method = "E7BBAE686E55399BCA1D8CE3FDCB666E")
    public boolean onGenericMotionEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_882673975 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_882673975;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.836 -0400", hash_original_method = "4EF468126ED8F0323D4288D03F894270", hash_generated_method = "6B6C48478E3743661D0D5A8E8111C607")
    public void onWindowAttributesChanged(WindowManager.LayoutParams params) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            mWindowManager.updateViewLayout(mDecor, params);
        } //End block
        addTaint(params.getTaint());
        // ---------- Original Method ----------
        //if (mDecor != null) {
            //mWindowManager.updateViewLayout(mDecor, params);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.838 -0400", hash_original_method = "32D7339793DCE0D5AEFE6621981EC978", hash_generated_method = "15CE33052F85E41C1BB65E1E6B2C108A")
    public void onContentChanged() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.858 -0400", hash_original_method = "C7622FC561A602386C2112BC0445F7C6", hash_generated_method = "EEF2114A935228AD19BFEE6FAB48379F")
    public void onWindowFocusChanged(boolean hasFocus) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(hasFocus);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.860 -0400", hash_original_method = "D6E949EE9F0768F47016EEA4FC0347A8", hash_generated_method = "0E08FFA9282E502085CC6973CB60CDA1")
    public void onAttachedToWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.874 -0400", hash_original_method = "E592299EBB4DE1D6696EB8C4009A9EF4", hash_generated_method = "1328510831112E7A424EFCA8583CA87C")
    public void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.899 -0400", hash_original_method = "1435B67C8334D2AC8987004B54F10264", hash_generated_method = "53969E891F43882B01AD76409E2837C8")
    public boolean dispatchKeyEvent(KeyEvent event) {
        {
            boolean var119FC86DBD10D0451AA68681D2661AF8_254961033 = ((mOnKeyListener != null) && (mOnKeyListener.onKey(this, event.getKeyCode(), event)));
        } //End collapsed parenthetic
        {
            boolean var524CC85D3B1F7496F0129E1D66C889FF_1571232354 = (mWindow.superDispatchKeyEvent(event));
        } //End collapsed parenthetic
        boolean var9A9ACA17DE81B47807106F3C8C61EFB2_139997088 = (event.dispatch(this, mDecor != null
                ? mDecor.getKeyDispatcherState() : null, this)); //DSFIXME:  CODE0008: Nested ternary operator in expression
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_394567126 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_394567126;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.908 -0400", hash_original_method = "BA9D4031BD488C1D379B1950A362F8D4", hash_generated_method = "F4D36C7C3D3F69D358EA6AC0AF33A105")
    public boolean dispatchKeyShortcutEvent(KeyEvent event) {
        {
            boolean var1506FC9A951093FEBE1E9D9D60B77FAA_108361480 = (mWindow.superDispatchKeyShortcutEvent(event));
        } //End collapsed parenthetic
        boolean varB65319FC5255424F872A964CBDE1432E_74020968 = (onKeyShortcut(event.getKeyCode(), event));
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_257769063 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_257769063;
        // ---------- Original Method ----------
        //if (mWindow.superDispatchKeyShortcutEvent(event)) {
            //return true;
        //}
        //return onKeyShortcut(event.getKeyCode(), event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.920 -0400", hash_original_method = "D3052CDDAC0630315E0F5E7AF5478D0E", hash_generated_method = "3A6A0337AC338A3B79F9A58C35074840")
    public boolean dispatchTouchEvent(MotionEvent ev) {
        {
            boolean var5240AC15FBF7E8C8943B586A077531B5_1223443465 = (mWindow.superDispatchTouchEvent(ev));
        } //End collapsed parenthetic
        boolean var985DA2294C2CD7796EE4EFA7F3FBE91B_1946569447 = (onTouchEvent(ev));
        addTaint(ev.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1274407319 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1274407319;
        // ---------- Original Method ----------
        //if (mWindow.superDispatchTouchEvent(ev)) {
            //return true;
        //}
        //return onTouchEvent(ev);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.935 -0400", hash_original_method = "2B935C89EDDE71F28E7C978B3C9DCAB0", hash_generated_method = "F704C748CFDB3BF1E6A644AE2B8FD0DA")
    public boolean dispatchTrackballEvent(MotionEvent ev) {
        {
            boolean varF25A212D3CF06F711C8BBD649E0977F2_1476148925 = (mWindow.superDispatchTrackballEvent(ev));
        } //End collapsed parenthetic
        boolean varE24895B72E913D801FFC5B9D9055D482_1377306949 = (onTrackballEvent(ev));
        addTaint(ev.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_130205536 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_130205536;
        // ---------- Original Method ----------
        //if (mWindow.superDispatchTrackballEvent(ev)) {
            //return true;
        //}
        //return onTrackballEvent(ev);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.948 -0400", hash_original_method = "B6AB9C2BD67E148832650E309163688C", hash_generated_method = "DEA11C30B870210F91D851E510EEBDBF")
    public boolean dispatchGenericMotionEvent(MotionEvent ev) {
        {
            boolean varC6CFD9FB7BF4B51FA19B29CFED05E764_2016192410 = (mWindow.superDispatchGenericMotionEvent(ev));
        } //End collapsed parenthetic
        boolean var82ABE1E641E95D27D650D268E959F965_628406316 = (onGenericMotionEvent(ev));
        addTaint(ev.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1628660078 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1628660078;
        // ---------- Original Method ----------
        //if (mWindow.superDispatchGenericMotionEvent(ev)) {
            //return true;
        //}
        //return onGenericMotionEvent(ev);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.032 -0400", hash_original_method = "3CC377981D86463D050A06CF1F7ED782", hash_generated_method = "70BE4A7042BD508D42067D039542ADF8")
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        event.setClassName(getClass().getName());
        event.setPackageName(mContext.getPackageName());
        LayoutParams params;
        params = getWindow().getAttributes();
        boolean isFullScreen;
        isFullScreen = (params.width == LayoutParams.MATCH_PARENT) &&
            (params.height == LayoutParams.MATCH_PARENT);
        event.setFullScreen(isFullScreen);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_34828637 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_34828637;
        // ---------- Original Method ----------
        //event.setClassName(getClass().getName());
        //event.setPackageName(mContext.getPackageName());
        //LayoutParams params = getWindow().getAttributes();
        //boolean isFullScreen = (params.width == LayoutParams.MATCH_PARENT) &&
            //(params.height == LayoutParams.MATCH_PARENT);
        //event.setFullScreen(isFullScreen);
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.042 -0400", hash_original_method = "8FB2859FE43E0606E21921E291A18BDA", hash_generated_method = "712720FF4EA4E48FC55E43D47AC71D7D")
    public View onCreatePanelView(int featureId) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        View varB4EAC82CA7396A68D541C85D26508E83_1623694710 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1623694710 = null;
        addTaint(featureId);
        varB4EAC82CA7396A68D541C85D26508E83_1623694710.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1623694710;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.058 -0400", hash_original_method = "1B30E4AD9FCCEF2C81163B46B66D301C", hash_generated_method = "FBBD6E08901AB03050EC4D6067E6F9F8")
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var3ADDFAB895A7216D8503161675C1D088_98103916 = (onCreateOptionsMenu(menu));
        } //End block
        addTaint(featureId);
        addTaint(menu.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_515364339 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_515364339;
        // ---------- Original Method ----------
        //if (featureId == Window.FEATURE_OPTIONS_PANEL) {
            //return onCreateOptionsMenu(menu);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.060 -0400", hash_original_method = "A95440A37102593BE255304F4188998E", hash_generated_method = "F6D4DA4981F28FE841345E101B153651")
    public boolean onPreparePanel(int featureId, View view, Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean goforit;
            goforit = onPrepareOptionsMenu(menu);
            boolean var7116118DD297E6C08BE1AD40992AA51A_1622510103 = (goforit && menu.hasVisibleItems());
        } //End block
        addTaint(featureId);
        addTaint(view.getTaint());
        addTaint(menu.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1055689368 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1055689368;
        // ---------- Original Method ----------
        //if (featureId == Window.FEATURE_OPTIONS_PANEL && menu != null) {
            //boolean goforit = onPrepareOptionsMenu(menu);
            //return goforit && menu.hasVisibleItems();
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.073 -0400", hash_original_method = "F5A72D2A4A42C0CE2781798802611276", hash_generated_method = "965E4457393486D0CF06F10ABCDAD48C")
    public boolean onMenuOpened(int featureId, Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            mActionBar.dispatchMenuVisibilityChanged(true);
        } //End block
        addTaint(featureId);
        addTaint(menu.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_610385907 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_610385907;
        // ---------- Original Method ----------
        //if (featureId == Window.FEATURE_ACTION_BAR) {
            //mActionBar.dispatchMenuVisibilityChanged(true);
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.077 -0400", hash_original_method = "CDCEA93B87CB4399825B767626A61473", hash_generated_method = "5996B3FE4DBC9407814DF23C773BE43C")
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(featureId);
        addTaint(item.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1115971074 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1115971074;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.102 -0400", hash_original_method = "20C3110FD341FFE95CFF6A6C95609D00", hash_generated_method = "649371478EDA55D24504EB4DA0FA2064")
    public void onPanelClosed(int featureId, Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            mActionBar.dispatchMenuVisibilityChanged(false);
        } //End block
        addTaint(featureId);
        addTaint(menu.getTaint());
        // ---------- Original Method ----------
        //if (featureId == Window.FEATURE_ACTION_BAR) {
            //mActionBar.dispatchMenuVisibilityChanged(false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.103 -0400", hash_original_method = "F3CAA7B8E21AB403B530132B4E52A4EB", hash_generated_method = "51B9DDCC3EDC5191D0BAB60122C8C001")
    public boolean onCreateOptionsMenu(Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(menu.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1740855778 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1740855778;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.124 -0400", hash_original_method = "BF0F08B18C75FC62D01E0D6DB107696E", hash_generated_method = "1D07C61F45E975A69920A48B6F8B4483")
    public boolean onPrepareOptionsMenu(Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(menu.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_39579987 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_39579987;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.128 -0400", hash_original_method = "8EF9A1828892EFEBF4B93362A866125C", hash_generated_method = "2A23D02D0568EA40328F05A214CD8AB2")
    public boolean onOptionsItemSelected(MenuItem item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(item.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_622802855 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_622802855;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.145 -0400", hash_original_method = "D53E4189B6E7F0EC0F9883E9844F2140", hash_generated_method = "CC9F879215C8D6911F3F43FE45124EF9")
    public void onOptionsMenuClosed(Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(menu.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.147 -0400", hash_original_method = "756759165F6AB2C8C6E469E63BE14186", hash_generated_method = "8F36C449192E9A4FC8F578B78BE7C244")
    public void openOptionsMenu() {
        mWindow.openPanel(Window.FEATURE_OPTIONS_PANEL, null);
        // ---------- Original Method ----------
        //mWindow.openPanel(Window.FEATURE_OPTIONS_PANEL, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.159 -0400", hash_original_method = "D12ED1735BBB9BCDCD831C99F03640D7", hash_generated_method = "249BD0BDCB652EF31D4B735086D0BDEC")
    public void closeOptionsMenu() {
        mWindow.closePanel(Window.FEATURE_OPTIONS_PANEL);
        // ---------- Original Method ----------
        //mWindow.closePanel(Window.FEATURE_OPTIONS_PANEL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.176 -0400", hash_original_method = "319389EBA801B290FB41D02473EB2E9E", hash_generated_method = "E3CB03CA5E4EB5916215E567B4276E95")
    public void invalidateOptionsMenu() {
        mWindow.invalidatePanelMenu(Window.FEATURE_OPTIONS_PANEL);
        // ---------- Original Method ----------
        //mWindow.invalidatePanelMenu(Window.FEATURE_OPTIONS_PANEL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.178 -0400", hash_original_method = "85F2A519B2781A30F4BC68DB47459C98", hash_generated_method = "170D9A5A5BFA1A654CA19943D4D0F496")
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(menu.getTaint());
        addTaint(v.getTaint());
        addTaint(menuInfo.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.193 -0400", hash_original_method = "1A123249F7C2C892EA53E2F44D60C1FB", hash_generated_method = "0FEECD9EF1102B65D35844FDFD151864")
    public void registerForContextMenu(View view) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        view.setOnCreateContextMenuListener(this);
        addTaint(view.getTaint());
        // ---------- Original Method ----------
        //view.setOnCreateContextMenuListener(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.195 -0400", hash_original_method = "6A7E2B106BB1CEE7C3B668A773DE5A5B", hash_generated_method = "344591114B98358744F7FCF1C426D7AD")
    public void unregisterForContextMenu(View view) {
        view.setOnCreateContextMenuListener(null);
        addTaint(view.getTaint());
        // ---------- Original Method ----------
        //view.setOnCreateContextMenuListener(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.214 -0400", hash_original_method = "D1451DBD5DFD14FAE397660897192E3C", hash_generated_method = "0E259D70C84DA1F0D8EA55F14095AA14")
    public void openContextMenu(View view) {
        view.showContextMenu();
        addTaint(view.getTaint());
        // ---------- Original Method ----------
        //view.showContextMenu();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.215 -0400", hash_original_method = "801D77DFDCCE5570587CA592634E3D3B", hash_generated_method = "54D0DEDA232D1704CE5F99BB89EE74FD")
    public boolean onContextItemSelected(MenuItem item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(item.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1300706665 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1300706665;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.246 -0400", hash_original_method = "5C6F377B774E414E6D9422BBC7AAE81F", hash_generated_method = "F6A83BFE417F19EC2EE2F1DD7A9E9351")
    public void onContextMenuClosed(Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(menu.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.249 -0400", hash_original_method = "38790ED2FB6D0EF1B7954716C7615F0D", hash_generated_method = "9EF663C42DBC49B88D92FCC5B578FF97")
    public boolean onSearchRequested() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        SearchManager searchManager;
        searchManager = (SearchManager) mContext
                .getSystemService(Context.SEARCH_SERVICE);
        ComponentName appName;
        appName = getAssociatedActivity();
        {
            boolean var39077EF7EA373069B451847B267FD676_955685648 = (appName != null && searchManager.getSearchableInfo(appName) != null);
            {
                searchManager.startSearch(null, false, appName, null, false);
                dismiss();
            } //End block
        } //End collapsed parenthetic
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_45943051 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_45943051;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.266 -0400", hash_original_method = "5D1C131301342FA877A860064E23A1A6", hash_generated_method = "8238A36562AB7324A92652DA8AE682C4")
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        ActionMode varB4EAC82CA7396A68D541C85D26508E83_1706515218 = null; //Variable for return #1
        ActionMode varB4EAC82CA7396A68D541C85D26508E83_2037932290 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1706515218 = mActionBar.startActionMode(callback);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2037932290 = null;
        addTaint(callback.getTaint());
        ActionMode varA7E53CE21691AB073D9660D615818899_1580371535; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1580371535 = varB4EAC82CA7396A68D541C85D26508E83_1706515218;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1580371535 = varB4EAC82CA7396A68D541C85D26508E83_2037932290;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1580371535.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1580371535;
        // ---------- Original Method ----------
        //if (mActionBar != null) {
            //return mActionBar.startActionMode(callback);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.274 -0400", hash_original_method = "00C0B67E273850713F0D88B8DE976F73", hash_generated_method = "CC0EA6E92777768F9F821B7C1ECE81BA")
    public void onActionModeStarted(ActionMode mode) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mActionMode = mode;
        // ---------- Original Method ----------
        //mActionMode = mode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.276 -0400", hash_original_method = "9FD315390CEABDE5B2497E2EE78C905A", hash_generated_method = "267373F481F3A04D55725F51391EFFC9")
    public void onActionModeFinished(ActionMode mode) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            mActionMode = null;
        } //End block
        addTaint(mode.getTaint());
        // ---------- Original Method ----------
        //if (mode == mActionMode) {
            //mActionMode = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.323 -0400", hash_original_method = "2C0F3C4A58B092DBFC10EA72C5A7ED76", hash_generated_method = "9B17C86F3D5E942C4BDDADB164511650")
    private ComponentName getAssociatedActivity() {
        ComponentName varB4EAC82CA7396A68D541C85D26508E83_59942994 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_59942994 = activity == null ? null : activity.getComponentName();
        varB4EAC82CA7396A68D541C85D26508E83_59942994.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_59942994;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.325 -0400", hash_original_method = "18F720E0A5C2702D89E6608BD6B708CA", hash_generated_method = "3C2EA7DA6ECB94A09F7FB8C9056E4114")
    public void takeKeyEvents(boolean get) {
        mWindow.takeKeyEvents(get);
        addTaint(get);
        // ---------- Original Method ----------
        //mWindow.takeKeyEvents(get);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.326 -0400", hash_original_method = "3CDF417FCD4F33EAE6CFCF0FB6D583A8", hash_generated_method = "0A33106008297449E5F375FE37AA0AA4")
    public final boolean requestWindowFeature(int featureId) {
        boolean varB82514052F40771017139C27F50D7D45_1033358108 = (getWindow().requestFeature(featureId));
        addTaint(featureId);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1355963176 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1355963176;
        // ---------- Original Method ----------
        //return getWindow().requestFeature(featureId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.339 -0400", hash_original_method = "E7AFD534CB1DF8060614ED36111B2407", hash_generated_method = "1D84D45038FD5866F8926E34F140C5A2")
    public final void setFeatureDrawableResource(int featureId, int resId) {
        getWindow().setFeatureDrawableResource(featureId, resId);
        addTaint(featureId);
        addTaint(resId);
        // ---------- Original Method ----------
        //getWindow().setFeatureDrawableResource(featureId, resId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.359 -0400", hash_original_method = "2E53659D6309BF8C5C8E8AD82BD6A577", hash_generated_method = "2B27B06D57220A2D7BDBB2E34E6E392C")
    public final void setFeatureDrawableUri(int featureId, Uri uri) {
        getWindow().setFeatureDrawableUri(featureId, uri);
        addTaint(featureId);
        addTaint(uri.getTaint());
        // ---------- Original Method ----------
        //getWindow().setFeatureDrawableUri(featureId, uri);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.360 -0400", hash_original_method = "D3FA0A5870730A6F3C959B16FC004BCD", hash_generated_method = "F557D4B7A04B56974C87A9013515B72F")
    public final void setFeatureDrawable(int featureId, Drawable drawable) {
        getWindow().setFeatureDrawable(featureId, drawable);
        addTaint(featureId);
        addTaint(drawable.getTaint());
        // ---------- Original Method ----------
        //getWindow().setFeatureDrawable(featureId, drawable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.363 -0400", hash_original_method = "4D2A81FF8C2C83F47460DEB3120C04CB", hash_generated_method = "04310BD6B9B4218E4C6AF4E9D6650F61")
    public final void setFeatureDrawableAlpha(int featureId, int alpha) {
        getWindow().setFeatureDrawableAlpha(featureId, alpha);
        addTaint(featureId);
        addTaint(alpha);
        // ---------- Original Method ----------
        //getWindow().setFeatureDrawableAlpha(featureId, alpha);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.382 -0400", hash_original_method = "2F200E491A9F2CDC38C392035D21ED48", hash_generated_method = "5EB38A4EE92EF743B9F53EF8A037F294")
    public LayoutInflater getLayoutInflater() {
        LayoutInflater varB4EAC82CA7396A68D541C85D26508E83_1270393838 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1270393838 = getWindow().getLayoutInflater();
        varB4EAC82CA7396A68D541C85D26508E83_1270393838.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1270393838;
        // ---------- Original Method ----------
        //return getWindow().getLayoutInflater();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.386 -0400", hash_original_method = "C80CDCB014C953B0801E95FEB1706C5F", hash_generated_method = "99A166D313D0204F9E1B3BB77DF8F04A")
    public void setCancelable(boolean flag) {
        mCancelable = flag;
        // ---------- Original Method ----------
        //mCancelable = flag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.393 -0400", hash_original_method = "BD7DFECDBEA3F81451B9076CEFC17564", hash_generated_method = "E597A25CAB63B5D5D20442EDE74A5230")
    public void setCanceledOnTouchOutside(boolean cancel) {
        {
            mCancelable = true;
        } //End block
        mWindow.setCloseOnTouchOutside(cancel);
        addTaint(cancel);
        // ---------- Original Method ----------
        //if (cancel && !mCancelable) {
            //mCancelable = true;
        //}
        //mWindow.setCloseOnTouchOutside(cancel);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.403 -0400", hash_original_method = "4DD1D51C0E16D279CD855F2D66BA21A6", hash_generated_method = "04D5A6A3EA2A41A883B809CB24D2E65F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.419 -0400", hash_original_method = "B6A3C715E726D4D77D298D569C13057A", hash_generated_method = "7A261DB80575EF8DC8F845C992F9F763")
    public void setOnCancelListener(final OnCancelListener listener) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.421 -0400", hash_original_method = "774019D9ADE46FB9924B78D145C17F36", hash_generated_method = "3D496AF9B1B4D7260FDDA232E220A62F")
    public void setCancelMessage(final Message msg) {
        mCancelMessage = msg;
        // ---------- Original Method ----------
        //mCancelMessage = msg;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.439 -0400", hash_original_method = "464A84E289A7DD535A8EA3034BC5D33F", hash_generated_method = "A0B01C16C706719BDDBBD3355AEA722B")
    public void setOnDismissListener(final OnDismissListener listener) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.441 -0400", hash_original_method = "0B69163DC80B46ACDA2709DE4C77DC2F", hash_generated_method = "1FB93D4E451DF60586CA95B02D8839CF")
    public void setOnShowListener(OnShowListener listener) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.455 -0400", hash_original_method = "2BD742B46509FC81ABA0DF4EC8F37AEC", hash_generated_method = "86E89A398CB75A38D126DF12BF88B627")
    public void setDismissMessage(final Message msg) {
        mDismissMessage = msg;
        // ---------- Original Method ----------
        //mDismissMessage = msg;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.458 -0400", hash_original_method = "4322D13EDCAAC15D5143567F42FC68A2", hash_generated_method = "58D24FBA3DC72FB85C0863C72ECA2469")
    public boolean takeCancelAndDismissListeners(String msg, final OnCancelListener cancel,
            final OnDismissListener dismiss) {
        {
            mCancelAndDismissTaken = null;
        } //End block
        setOnCancelListener(cancel);
        setOnDismissListener(dismiss);
        mCancelAndDismissTaken = msg;
        addTaint(cancel.getTaint());
        addTaint(dismiss.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1355078565 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1355078565;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.483 -0400", hash_original_method = "70729F29EB37CCBEC739A5986214C32F", hash_generated_method = "2764BD226534A1A95BF3BECEF1136ABC")
    public final void setVolumeControlStream(int streamType) {
        getWindow().setVolumeControlStream(streamType);
        addTaint(streamType);
        // ---------- Original Method ----------
        //getWindow().setVolumeControlStream(streamType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.486 -0400", hash_original_method = "03A841DC7655848901B3CE2C14084AAE", hash_generated_method = "07E84EC5E80FDF91300533F7E103A4C4")
    public final int getVolumeControlStream() {
        int var10019DD6073F3F6675C482019A78518D_1129302889 = (getWindow().getVolumeControlStream());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1613983918 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1613983918;
        // ---------- Original Method ----------
        //return getWindow().getVolumeControlStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.506 -0400", hash_original_method = "A9C3EE1B48BA32717B6024C41DF4E1F6", hash_generated_method = "EEA474A83FE4C7A6A402FA07BCAB4982")
    public void setOnKeyListener(final OnKeyListener onKeyListener) {
        mOnKeyListener = onKeyListener;
        // ---------- Original Method ----------
        //mOnKeyListener = onKeyListener;
    }

    
    private static final class ListenersHandler extends Handler {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.506 -0400", hash_original_field = "58806F2D99FD4DF33CF42E0C232738D7", hash_generated_field = "436872B12AE04B06D18A845CB0719BC2")

        private WeakReference<DialogInterface> mDialog;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.513 -0400", hash_original_method = "92DAC0D6E122198BF26AB724936B6539", hash_generated_method = "DF7B51E0F2F5846DF16713C1A26DD53E")
        public  ListenersHandler(Dialog dialog) {
            mDialog = new WeakReference<DialogInterface>(dialog);
            // ---------- Original Method ----------
            //mDialog = new WeakReference<DialogInterface>(dialog);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.531 -0400", hash_original_method = "0AC2BA822DE6E333F562D01CFB6CE49A", hash_generated_method = "2828C4C27220D31C29AC9562F6AB3134")
        @Override
        public void handleMessage(Message msg) {
            //Begin case DISMISS 
            ((OnDismissListener) msg.obj).onDismiss(mDialog.get());
            //End case DISMISS 
            //Begin case CANCEL 
            ((OnCancelListener) msg.obj).onCancel(mDialog.get());
            //End case CANCEL 
            //Begin case SHOW 
            ((OnShowListener) msg.obj).onShow(mDialog.get());
            //End case SHOW 
            addTaint(msg.getTaint());
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.532 -0400", hash_original_field = "C8104907E2C15136387E1FF354F2E289", hash_generated_field = "AF1420DC8DD054A8C8AC9FF328783A41")

    private static String TAG = "Dialog";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.532 -0400", hash_original_field = "50C73827946947CD861F4B61AEA55633", hash_generated_field = "8BC158EB29226ED298B9C26CA4FB1ED9")

    private static int DISMISS = 0x43;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.549 -0400", hash_original_field = "9BA42FA53C623D78B24D53CDAE971C70", hash_generated_field = "572F635B5B3BBB4A58234F51E1654B73")

    private static int CANCEL = 0x44;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.550 -0400", hash_original_field = "7A4F616BE8122BA90E30406327492376", hash_generated_field = "0F3656B85C89B3B168121AEF556F3414")

    private static int SHOW = 0x45;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.550 -0400", hash_original_field = "9D0239578906B64ECBA46B3D33341F50", hash_generated_field = "16F80A0AE9CF6786FF2C798745A9C593")

    private static String DIALOG_SHOWING_TAG = "android:dialogShowing";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.551 -0400", hash_original_field = "9B9870DF294A5143109BE6CEAFCC0E45", hash_generated_field = "9378C8E09580AD3D596663DC434D50C2")

    private static String DIALOG_HIERARCHY_TAG = "android:dialogHierarchy";
}

