package android.app;

// Droidsafe Imports
import java.lang.ref.WeakReference;

import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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

import com.android.internal.app.ActionBarImpl;
import com.android.internal.policy.PolicyManager;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class Dialog implements DialogInterface, Window.Callback, KeyEvent.Callback, OnCreateContextMenuListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.711 -0400", hash_original_field = "581D71027A593FE178E11F8CF96A261F", hash_generated_field = "8ACEFA51F1C212AC94944686D7E3BDFC")

    private Activity mOwnerActivity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.711 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "B997E37019471EC8FC5B98148C7A8AD7")

    Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.711 -0400", hash_original_field = "306519E50E3A91B9733D09F5D8EB985C", hash_generated_field = "83A062836C11DD52DC32F4325712F233")

    WindowManager mWindowManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.711 -0400", hash_original_field = "F4214BE1FFE044F8CA79EEDDDED72016", hash_generated_field = "C6B08D42C8EA2CB56500460CAF662F4C")

    Window mWindow;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.712 -0400", hash_original_field = "90456FC221E7A82F02F5F0D86665E9D8", hash_generated_field = "B4A10D2FE94FCA7877DCD1F8197DA38F")

    View mDecor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.712 -0400", hash_original_field = "6468B2E0460CFBFD40C03C7A36A45FDF", hash_generated_field = "7F8EF508978F38B8BCEC28D592DBFC22")

    private ActionBarImpl mActionBar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.712 -0400", hash_original_field = "CBE9C1F82FCE1BB545B279BE8BBA93EE", hash_generated_field = "6123942D1383A17F765E6BC984B8086E")

    protected boolean mCancelable = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.712 -0400", hash_original_field = "5EECE75098F1C3EE2E7D5C5604E7ABBE", hash_generated_field = "B13EDAE25BF4DFF139CD5FAE4D2A0A25")

    private String mCancelAndDismissTaken;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.712 -0400", hash_original_field = "4D534CFD5536B7EAE26E671B61999A02", hash_generated_field = "76C74178C09C090FAEDAAD0E8B0CF7A0")

    private Message mCancelMessage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.712 -0400", hash_original_field = "BE5032B19401D6C75DF159B7C44D7C01", hash_generated_field = "E192DE29CF3B86E1D4D51306D6613B44")

    private Message mDismissMessage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.712 -0400", hash_original_field = "9FDEEA4D408D357BE228AE1A75ED9410", hash_generated_field = "9DF7AF46D4C4365744738EB8C5D01451")

    private Message mShowMessage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.713 -0400", hash_original_field = "2A4FF7110738976278729426D6DBEF1F", hash_generated_field = "E9EAFA3F5F183CD7232E888DAC035728")

    private OnKeyListener mOnKeyListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.713 -0400", hash_original_field = "721C926D9558D59E55B02399D96F5508", hash_generated_field = "AE31AA5AE388883F7650182C0E3C7933")

    private boolean mCreated = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.713 -0400", hash_original_field = "B150E8FC39372026A2B260E47009CF79", hash_generated_field = "524E990B3B93C6331366CC3FFD800C87")

    private boolean mShowing = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.713 -0400", hash_original_field = "D91530AF3D6C660AC2C0C8D4CBB2367B", hash_generated_field = "67D6DA73468F2D6E84B945FD38F1CC1D")

    private boolean mCanceled = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.713 -0400", hash_original_field = "C5D62B7C4F8BE6B828DA51239EC692E0", hash_generated_field = "A94051227A36AE91A6CE3B31BF1DD3E6")

    private Thread mUiThread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.713 -0400", hash_original_field = "6781893E9FA50A9B7103FD3F674E566B", hash_generated_field = "2C33E5889A8CDA732A297DBE7101DB89")

    private final Handler mHandler = new Handler();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.713 -0400", hash_original_field = "A7C53D678AF31C89461A94B80C89667F", hash_generated_field = "BE6770D46FDA6621A2256CC938B90138")

    private Handler mListenersHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.713 -0400", hash_original_field = "3B382D379664B509F22D0EB5D96F2BA8", hash_generated_field = "941205D807AC4DF9704A65BDAF4756EC")

    private ActionMode mActionMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.380 -0400", hash_original_field = "90764B7AE877EFFD33D3124ADF85860E", hash_generated_field = "8FA22581A256DB33942DF76F392B65DC")

    private final Runnable mDismissAction = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.380 -0400", hash_original_method = "BEE19A9C5B7D04B78955A3FD8170F1CA", hash_generated_method = "4B98EED19700DEC05BCE304A452DAE0F")
        public void run() {
            dismissDialog();
            
            
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.714 -0400", hash_original_method = "BC9D2F22217346E354BF7BFC78A2D0C2", hash_generated_method = "6CD06A2CC25407F07D3CFC5AD07F9ABC")
    public  Dialog(Context context) {
        this(context, 0, true);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.714 -0400", hash_original_method = "E8683E6729C8449A45D83189604DFAE9", hash_generated_method = "108757FF77802F0B0AA5BC2DBAC4044F")
    public  Dialog(Context context, int theme) {
        this(context, theme, true);
        addTaint(theme);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.717 -0400", hash_original_method = "C6D5E1D2CF37954F320E3261297EC417", hash_generated_method = "5EAAE6526580FD747741313DD59D3181")
      Dialog(Context context, int theme, boolean createContextWrapper) {
        if(theme == 0)        
        {
            TypedValue outValue = new TypedValue();
            context.getTheme().resolveAttribute(com.android.internal.R.attr.dialogTheme,
                    outValue, true);
            theme = outValue.resourceId;
        } //End block
        mContext = createContextWrapper ? new ContextThemeWrapper(context, theme) : context;
        mWindowManager = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        Window w = PolicyManager.makeNewWindow(mContext);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.718 -0400", hash_original_method = "845C16E53E1BE45A2BA7FF67CD257C6C", hash_generated_method = "E1811EB5F89C0A6FE0913B6E63230420")
    @Deprecated
    protected  Dialog(Context context, boolean cancelable,
            Message cancelCallback) {
        this(context);
        addTaint(context.getTaint());
        mCancelable = cancelable;
        mCancelMessage = cancelCallback;
        // ---------- Original Method ----------
        //mCancelable = cancelable;
        //mCancelMessage = cancelCallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.720 -0400", hash_original_method = "C9ADA56967BDAFB742C2181BE637639A", hash_generated_method = "C486698F1BBF0EDF2603E7FB98C64E63")
    protected  Dialog(Context context, boolean cancelable,
            OnCancelListener cancelListener) {
        this(context);
        addTaint(cancelListener.getTaint());
        addTaint(context.getTaint());
        mCancelable = cancelable;
        setOnCancelListener(cancelListener);
        // ---------- Original Method ----------
        //mCancelable = cancelable;
        //setOnCancelListener(cancelListener);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.720 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "1DDC3AE4E3FBAC06939C1066C31173A2")
    public final Context getContext() {
Context var178E2AD52D6FBBB503F908168856B574_1112435172 =         mContext;
        var178E2AD52D6FBBB503F908168856B574_1112435172.addTaint(taint);
        return var178E2AD52D6FBBB503F908168856B574_1112435172;
        // ---------- Original Method ----------
        //return mContext;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.720 -0400", hash_original_method = "624FE63EC935EE8F7C5CD37954EA0AEA", hash_generated_method = "A6EB01B2163A76711451CB6CF6FAD6B9")
    public ActionBar getActionBar() {
ActionBar var02D7B9E52DFDAF29F050C055F2B0A03C_795902496 =         mActionBar;
        var02D7B9E52DFDAF29F050C055F2B0A03C_795902496.addTaint(taint);
        return var02D7B9E52DFDAF29F050C055F2B0A03C_795902496;
        // ---------- Original Method ----------
        //return mActionBar;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.721 -0400", hash_original_method = "AEEF4868262FBFB181A318E6FDCF1973", hash_generated_method = "2225ED786D910828047D511078A525A3")
    public final void setOwnerActivity(Activity activity) {
        mOwnerActivity = activity;
        getWindow().setVolumeControlStream(mOwnerActivity.getVolumeControlStream());
        // ---------- Original Method ----------
        //mOwnerActivity = activity;
        //getWindow().setVolumeControlStream(mOwnerActivity.getVolumeControlStream());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.722 -0400", hash_original_method = "D833D4731703AD671D7AED3C45CAE756", hash_generated_method = "216EF9FD0362286B6C17B05DAA75B304")
    public final Activity getOwnerActivity() {
Activity var1F93BAB3C8E73BD5DD59D84CA7D69EBB_626784901 =         mOwnerActivity;
        var1F93BAB3C8E73BD5DD59D84CA7D69EBB_626784901.addTaint(taint);
        return var1F93BAB3C8E73BD5DD59D84CA7D69EBB_626784901;
        // ---------- Original Method ----------
        //return mOwnerActivity;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.722 -0400", hash_original_method = "F21458EB6FE36A924A49B40493E1F9F8", hash_generated_method = "81A93947B0000D638683E8E5BD4513B9")
    public boolean isShowing() {
        boolean varED7142E6C56E85275A9E1F55586553C1_1469042026 = (mShowing);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_286909543 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_286909543;
        // ---------- Original Method ----------
        //return mShowing;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.724 -0400", hash_original_method = "079FA2E5CA600A12F7067E75E853F614", hash_generated_method = "0D6731633B441978A86CBFA46E37F5A2")
    public void show() {
        if(mShowing)        
        {
            if(mDecor != null)            
            {
                if(mWindow.hasFeature(Window.FEATURE_ACTION_BAR))                
                {
                    mWindow.invalidatePanelMenu(Window.FEATURE_ACTION_BAR);
                } //End block
                mDecor.setVisibility(View.VISIBLE);
            } //End block
            return;
        } //End block
        mCanceled = false;
        if(!mCreated)        
        {
            dispatchOnCreate(null);
        } //End block
        onStart();
        mDecor = mWindow.getDecorView();
        if(mActionBar == null && mWindow.hasFeature(Window.FEATURE_ACTION_BAR))        
        {
            mActionBar = new ActionBarImpl(this);
        } //End block
        WindowManager.LayoutParams l = mWindow.getAttributes();
        if((l.softInputMode
                & WindowManager.LayoutParams.SOFT_INPUT_IS_FORWARD_NAVIGATION) == 0)        
        {
            WindowManager.LayoutParams nl = new WindowManager.LayoutParams();
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
        {
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.725 -0400", hash_original_method = "4A0CDBB7EA97DC376E25E0EE43387CF4", hash_generated_method = "36C617C412CD5E025545E98033C55937")
    public void hide() {
        if(mDecor != null)        
        {
            mDecor.setVisibility(View.GONE);
        } //End block
        // ---------- Original Method ----------
        //if (mDecor != null) {
            //mDecor.setVisibility(View.GONE);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.725 -0400", hash_original_method = "33443011198828BD072B057DA719765A", hash_generated_method = "91D25D057127796858709A51A2608F95")
    public void dismiss() {
        if(Thread.currentThread() != mUiThread)        
        {
            mHandler.post(mDismissAction);
        } //End block
        else
        {
            mHandler.removeCallbacks(mDismissAction);
            mDismissAction.run();
        } //End block
        // ---------- Original Method ----------
        //if (Thread.currentThread() != mUiThread) {
            //mHandler.post(mDismissAction);
        //} else {
            //mHandler.removeCallbacks(mDismissAction);
            //mDismissAction.run();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.726 -0400", hash_original_method = "4ECC78F105BA2AD2FA21893BA556AFFD", hash_generated_method = "242D66148C2A6C04E17F2276D222F8BC")
     void dismissDialog() {
        if(mDecor == null || !mShowing)        
        {
            return;
        } //End block
        if(mWindow.isDestroyed())        
        {
            return;
        } //End block
        try 
        {
            mWindowManager.removeView(mDecor);
        } //End block
        finally 
        {
            if(mActionMode != null)            
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.727 -0400", hash_original_method = "866BAFBEBC09B92D7388CA2F75E61BAD", hash_generated_method = "02F2465081B30BD7BCD9FE91F06BA52C")
    private void sendDismissMessage() {
        if(mDismissMessage != null)        
        {
            Message.obtain(mDismissMessage).sendToTarget();
        } //End block
        // ---------- Original Method ----------
        //if (mDismissMessage != null) {
            //Message.obtain(mDismissMessage).sendToTarget();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.728 -0400", hash_original_method = "02D405BDD0443049D755381D9E715694", hash_generated_method = "21B6817432E19F232C011E2D2DD82365")
    private void sendShowMessage() {
        if(mShowMessage != null)        
        {
            Message.obtain(mShowMessage).sendToTarget();
        } //End block
        // ---------- Original Method ----------
        //if (mShowMessage != null) {
            //Message.obtain(mShowMessage).sendToTarget();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.728 -0400", hash_original_method = "CD27A7CE58254212F040E7B7DA65BCA4", hash_generated_method = "6D6D2A14DD6BC0D9DF03209869664ABF")
     void dispatchOnCreate(Bundle savedInstanceState) {
        addTaint(savedInstanceState.getTaint());
        if(!mCreated)        
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.729 -0400", hash_original_method = "B84ED822BC6011EB138B2F6F1D018FE5", hash_generated_method = "DE98DECCC817096DF1B839F626292181")
    protected void onCreate(Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(savedInstanceState.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.730 -0400", hash_original_method = "1B4F9BFF1D832A07D0E1F41D0B16D2FF", hash_generated_method = "F707B3C87F748353E072C3436E18C9C9")
    protected void onStart() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        if(mActionBar != null)        
        mActionBar.setShowHideAnimationEnabled(true);
        // ---------- Original Method ----------
        //if (mActionBar != null) mActionBar.setShowHideAnimationEnabled(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.731 -0400", hash_original_method = "28173EE669492C23D10F671D2D034693", hash_generated_method = "0B0C97EE9D52265E6D2DE60AB7FF1853")
    protected void onStop() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        if(mActionBar != null)        
        mActionBar.setShowHideAnimationEnabled(false);
        // ---------- Original Method ----------
        //if (mActionBar != null) mActionBar.setShowHideAnimationEnabled(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.731 -0400", hash_original_method = "2D855197EA1046BD8EC8CA2E991844E1", hash_generated_method = "111BDA493B1C368F0B4B13DE73B31D17")
    public Bundle onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Bundle bundle = new Bundle();
        bundle.putBoolean(DIALOG_SHOWING_TAG, mShowing);
        if(mCreated)        
        {
            bundle.putBundle(DIALOG_HIERARCHY_TAG, mWindow.saveHierarchyState());
        } //End block
Bundle var7B2862195409742DCA365D8C6330AB92_142920196 =         bundle;
        var7B2862195409742DCA365D8C6330AB92_142920196.addTaint(taint);
        return var7B2862195409742DCA365D8C6330AB92_142920196;
        // ---------- Original Method ----------
        //Bundle bundle = new Bundle();
        //bundle.putBoolean(DIALOG_SHOWING_TAG, mShowing);
        //if (mCreated) {
            //bundle.putBundle(DIALOG_HIERARCHY_TAG, mWindow.saveHierarchyState());
        //}
        //return bundle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.733 -0400", hash_original_method = "EE5C9B4EF0AAEC8AB3AF49A30F3FD2D3", hash_generated_method = "84D84E77EA175E7C86D012B938DE2131")
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(savedInstanceState.getTaint());
        final Bundle dialogHierarchyState = savedInstanceState.getBundle(DIALOG_HIERARCHY_TAG);
        if(dialogHierarchyState == null)        
        {
            return;
        } //End block
        dispatchOnCreate(savedInstanceState);
        mWindow.restoreHierarchyState(dialogHierarchyState);
        if(savedInstanceState.getBoolean(DIALOG_SHOWING_TAG))        
        {
            show();
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.734 -0400", hash_original_method = "51ACB33F24592F8ED3FAFF9D96DEAF2A", hash_generated_method = "E7F985D07D523F302F7C8DBC12C9CC93")
    public Window getWindow() {
Window var125511BCCBD4CDF7BDF315F5AA8A1CE3_123934539 =         mWindow;
        var125511BCCBD4CDF7BDF315F5AA8A1CE3_123934539.addTaint(taint);
        return var125511BCCBD4CDF7BDF315F5AA8A1CE3_123934539;
        // ---------- Original Method ----------
        //return mWindow;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.735 -0400", hash_original_method = "44957F5326E5A87B91E438DCD3C71232", hash_generated_method = "15EC743FBC4B455028853F3F033CE211")
    public View getCurrentFocus() {
View varE3E79DFDA423BE71E1BD830287B2C373_626523959 =         mWindow != null ? mWindow.getCurrentFocus() : null;
        varE3E79DFDA423BE71E1BD830287B2C373_626523959.addTaint(taint);
        return varE3E79DFDA423BE71E1BD830287B2C373_626523959;
        // ---------- Original Method ----------
        //return mWindow != null ? mWindow.getCurrentFocus() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.736 -0400", hash_original_method = "FBC1E026CFF410D335B7C0F9A45B0829", hash_generated_method = "7CE9B8CD5D1342A6E9BA1D13526267C7")
    public View findViewById(int id) {
        addTaint(id);
View var2EFFDC7A452E405931BA682E5046627A_221022289 =         mWindow.findViewById(id);
        var2EFFDC7A452E405931BA682E5046627A_221022289.addTaint(taint);
        return var2EFFDC7A452E405931BA682E5046627A_221022289;
        // ---------- Original Method ----------
        //return mWindow.findViewById(id);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.737 -0400", hash_original_method = "A6A8A3E553FD4B026D939E9AE3AC9985", hash_generated_method = "D42EABBC50BA73153301183635A696DB")
    public void setContentView(int layoutResID) {
        addTaint(layoutResID);
        mWindow.setContentView(layoutResID);
        // ---------- Original Method ----------
        //mWindow.setContentView(layoutResID);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.738 -0400", hash_original_method = "64A976C0ECE03B8AD97B801012E7B71B", hash_generated_method = "D878E663FCDD77C5051363CB448EA627")
    public void setContentView(View view) {
        addTaint(view.getTaint());
        mWindow.setContentView(view);
        // ---------- Original Method ----------
        //mWindow.setContentView(view);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.738 -0400", hash_original_method = "21FC0CE0727282A96780C185A7B70535", hash_generated_method = "09471B7B677F14A3E67F832D24AD58A4")
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        addTaint(params.getTaint());
        addTaint(view.getTaint());
        mWindow.setContentView(view, params);
        // ---------- Original Method ----------
        //mWindow.setContentView(view, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.739 -0400", hash_original_method = "54F8942E4EAEA6A93BE827863701CD23", hash_generated_method = "665B09C7A3EF5BBC249A7EFB789F9C6D")
    public void addContentView(View view, ViewGroup.LayoutParams params) {
        addTaint(params.getTaint());
        addTaint(view.getTaint());
        mWindow.addContentView(view, params);
        // ---------- Original Method ----------
        //mWindow.addContentView(view, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.739 -0400", hash_original_method = "A94A4616451E43B03E2FA5DD3DFB9ED3", hash_generated_method = "A0CEE0FAC86FA4A9BF32E5F8AF2F20CF")
    public void setTitle(CharSequence title) {
        addTaint(title.getTaint());
        mWindow.setTitle(title);
        mWindow.getAttributes().setTitle(title);
        // ---------- Original Method ----------
        //mWindow.setTitle(title);
        //mWindow.getAttributes().setTitle(title);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.740 -0400", hash_original_method = "0D914ED2883864B655DBF2629252A595", hash_generated_method = "E07D46779BB459B487B0A1D885E37983")
    public void setTitle(int titleId) {
        addTaint(titleId);
        setTitle(mContext.getText(titleId));
        // ---------- Original Method ----------
        //setTitle(mContext.getText(titleId));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.740 -0400", hash_original_method = "EB61104CC8357BEAF109072385D21C38", hash_generated_method = "344E19486025675562084A8CB1FFAA45")
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
        if(keyCode == KeyEvent.KEYCODE_BACK)        
        {
            event.startTracking();
            boolean varB326B5062B2F0E69046810717534CB09_682639598 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1752533675 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1752533675;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1472926852 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2028520645 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2028520645;
        // ---------- Original Method ----------
        //if (keyCode == KeyEvent.KEYCODE_BACK) {
            //event.startTracking();
            //return true;
        //}
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.741 -0400", hash_original_method = "2A75FF2C44C4D96068DDAFC2643F0C8B", hash_generated_method = "A4F53B683D13F0834A1FAE8619BAEE01")
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
        boolean var68934A3E9455FA72420237EB05902327_1371361668 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_338989755 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_338989755;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.741 -0400", hash_original_method = "CFFAC7119271281C27F3BEDCE8D82CC2", hash_generated_method = "8923B367F8032B5B8162BBEE0D77B899")
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
        if(keyCode == KeyEvent.KEYCODE_BACK && event.isTracking()
                && !event.isCanceled())        
        {
            onBackPressed();
            boolean varB326B5062B2F0E69046810717534CB09_1009463905 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_492247303 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_492247303;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_865042527 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1217047373 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1217047373;
        // ---------- Original Method ----------
        //if (keyCode == KeyEvent.KEYCODE_BACK && event.isTracking()
                //&& !event.isCanceled()) {
            //onBackPressed();
            //return true;
        //}
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.742 -0400", hash_original_method = "E364C67ED15F0AA31C6DCFFA6137C8C0", hash_generated_method = "4AE9E53222DC8D7014E892AADB106BE1")
    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(repeatCount);
        addTaint(keyCode);
        boolean var68934A3E9455FA72420237EB05902327_1304402858 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1282772364 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1282772364;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.743 -0400", hash_original_method = "EAEAA0DB8B83D24D321D98459F4FA29E", hash_generated_method = "79E2784B0F7F34B3F9AAFD2B90728F36")
    public void onBackPressed() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        if(mCancelable)        
        {
            cancel();
        } //End block
        // ---------- Original Method ----------
        //if (mCancelable) {
            //cancel();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.743 -0400", hash_original_method = "2ECF3E4914B4B3BE2238F799B7435A51", hash_generated_method = "658DCD155689FA488A768DBF74544B4B")
    public boolean onKeyShortcut(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
        boolean var68934A3E9455FA72420237EB05902327_1451206434 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2051973346 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2051973346;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.744 -0400", hash_original_method = "5A4B1024EA76F961E6155B7F9E2B0909", hash_generated_method = "2F801E4904AD8320A0F165996965F00D")
    public boolean onTouchEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        if(mCancelable && mShowing && mWindow.shouldCloseOnTouch(mContext, event))        
        {
            cancel();
            boolean varB326B5062B2F0E69046810717534CB09_1844638871 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_236639194 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_236639194;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_811795306 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_900317030 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_900317030;
        // ---------- Original Method ----------
        //if (mCancelable && mShowing && mWindow.shouldCloseOnTouch(mContext, event)) {
            //cancel();
            //return true;
        //}
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.745 -0400", hash_original_method = "4A983FDB3FF481E2165B7D8D641CDD48", hash_generated_method = "0543C7BFD56435CB0CA0FF92D23D9F3F")
    public boolean onTrackballEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_1217380425 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_862777412 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_862777412;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.746 -0400", hash_original_method = "0E59A005881F30C798F764BCF32D89A3", hash_generated_method = "7715B8138A410F5DB73458AE230DE441")
    public boolean onGenericMotionEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_1712644990 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_866561632 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_866561632;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.746 -0400", hash_original_method = "4EF468126ED8F0323D4288D03F894270", hash_generated_method = "DA0BFB7C3887B4609A1A5BE9B6E4CD7C")
    public void onWindowAttributesChanged(WindowManager.LayoutParams params) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(params.getTaint());
        if(mDecor != null)        
        {
            mWindowManager.updateViewLayout(mDecor, params);
        } //End block
        // ---------- Original Method ----------
        //if (mDecor != null) {
            //mWindowManager.updateViewLayout(mDecor, params);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.747 -0400", hash_original_method = "32D7339793DCE0D5AEFE6621981EC978", hash_generated_method = "15CE33052F85E41C1BB65E1E6B2C108A")
    public void onContentChanged() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.747 -0400", hash_original_method = "C7622FC561A602386C2112BC0445F7C6", hash_generated_method = "EEF2114A935228AD19BFEE6FAB48379F")
    public void onWindowFocusChanged(boolean hasFocus) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(hasFocus);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.747 -0400", hash_original_method = "D6E949EE9F0768F47016EEA4FC0347A8", hash_generated_method = "0E08FFA9282E502085CC6973CB60CDA1")
    public void onAttachedToWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.748 -0400", hash_original_method = "E592299EBB4DE1D6696EB8C4009A9EF4", hash_generated_method = "1328510831112E7A424EFCA8583CA87C")
    public void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.748 -0400", hash_original_method = "1435B67C8334D2AC8987004B54F10264", hash_generated_method = "53F24EB3BEF1EB31B719CC1B7AB108E3")
    public boolean dispatchKeyEvent(KeyEvent event) {
        addTaint(event.getTaint());
        if((mOnKeyListener != null) && (mOnKeyListener.onKey(this, event.getKeyCode(), event)))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1546425511 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_952474146 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_952474146;
        } //End block
        if(mWindow.superDispatchKeyEvent(event))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1280551671 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_287282750 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_287282750;
        } //End block
        boolean varCCCCDC1EFAB25FDBFAE8D80010C4EC8E_1041813739 = (event.dispatch(this, mDecor != null
                ? mDecor.getKeyDispatcherState() : null, this));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_727721181 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_727721181;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.749 -0400", hash_original_method = "BA9D4031BD488C1D379B1950A362F8D4", hash_generated_method = "ADC419B01C43DB89518984423C436EB7")
    public boolean dispatchKeyShortcutEvent(KeyEvent event) {
        addTaint(event.getTaint());
        if(mWindow.superDispatchKeyShortcutEvent(event))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_885436641 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_494407451 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_494407451;
        } //End block
        boolean var156E4CB1D436F15C72AC6FC64572DBC8_1957066375 = (onKeyShortcut(event.getKeyCode(), event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_817350079 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_817350079;
        // ---------- Original Method ----------
        //if (mWindow.superDispatchKeyShortcutEvent(event)) {
            //return true;
        //}
        //return onKeyShortcut(event.getKeyCode(), event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.750 -0400", hash_original_method = "D3052CDDAC0630315E0F5E7AF5478D0E", hash_generated_method = "B7195154959A0AE1C7A5DD5F332F6810")
    public boolean dispatchTouchEvent(MotionEvent ev) {
        addTaint(ev.getTaint());
        if(mWindow.superDispatchTouchEvent(ev))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1721497725 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_409650395 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_409650395;
        } //End block
        boolean var6A82C8DBC967C7DCA9B560132CC6DCB4_974414997 = (onTouchEvent(ev));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1251030216 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1251030216;
        // ---------- Original Method ----------
        //if (mWindow.superDispatchTouchEvent(ev)) {
            //return true;
        //}
        //return onTouchEvent(ev);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.751 -0400", hash_original_method = "2B935C89EDDE71F28E7C978B3C9DCAB0", hash_generated_method = "EBAB8A632FF6A5722928B8C57154FDE1")
    public boolean dispatchTrackballEvent(MotionEvent ev) {
        addTaint(ev.getTaint());
        if(mWindow.superDispatchTrackballEvent(ev))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_160665108 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_289006773 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_289006773;
        } //End block
        boolean var29D71352E688331DEA01A8CD09B7572F_843178022 = (onTrackballEvent(ev));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1831299360 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1831299360;
        // ---------- Original Method ----------
        //if (mWindow.superDispatchTrackballEvent(ev)) {
            //return true;
        //}
        //return onTrackballEvent(ev);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.752 -0400", hash_original_method = "B6AB9C2BD67E148832650E309163688C", hash_generated_method = "F6181B7C53BE03460742A39C546A13D5")
    public boolean dispatchGenericMotionEvent(MotionEvent ev) {
        addTaint(ev.getTaint());
        if(mWindow.superDispatchGenericMotionEvent(ev))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1727442376 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1440621436 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1440621436;
        } //End block
        boolean varE3EC3986EBBB841CE7203BD438C75A8B_1741127614 = (onGenericMotionEvent(ev));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1404796061 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1404796061;
        // ---------- Original Method ----------
        //if (mWindow.superDispatchGenericMotionEvent(ev)) {
            //return true;
        //}
        //return onGenericMotionEvent(ev);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.752 -0400", hash_original_method = "3CC377981D86463D050A06CF1F7ED782", hash_generated_method = "EADA6FFACDF1E767E6B894856BF869D1")
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        addTaint(event.getTaint());
        event.setClassName(getClass().getName());
        event.setPackageName(mContext.getPackageName());
        LayoutParams params = getWindow().getAttributes();
        boolean isFullScreen = (params.width == LayoutParams.MATCH_PARENT) &&
            (params.height == LayoutParams.MATCH_PARENT);
        event.setFullScreen(isFullScreen);
        boolean var68934A3E9455FA72420237EB05902327_220264076 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1042989711 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1042989711;
        // ---------- Original Method ----------
        //event.setClassName(getClass().getName());
        //event.setPackageName(mContext.getPackageName());
        //LayoutParams params = getWindow().getAttributes();
        //boolean isFullScreen = (params.width == LayoutParams.MATCH_PARENT) &&
            //(params.height == LayoutParams.MATCH_PARENT);
        //event.setFullScreen(isFullScreen);
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.753 -0400", hash_original_method = "8FB2859FE43E0606E21921E291A18BDA", hash_generated_method = "5C81E5AB257EE0D0A951F6B98B1D4287")
    public View onCreatePanelView(int featureId) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(featureId);
View var540C13E9E156B687226421B24F2DF178_347437671 =         null;
        var540C13E9E156B687226421B24F2DF178_347437671.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_347437671;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.753 -0400", hash_original_method = "1B30E4AD9FCCEF2C81163B46B66D301C", hash_generated_method = "0F16E87D1570C1CE9D65945F7762CA51")
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(menu.getTaint());
        addTaint(featureId);
        if(featureId == Window.FEATURE_OPTIONS_PANEL)        
        {
            boolean varC89E509CAF9218615C834839CA8189E8_1949573329 = (onCreateOptionsMenu(menu));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1873724977 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1873724977;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1338564418 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_983000239 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_983000239;
        // ---------- Original Method ----------
        //if (featureId == Window.FEATURE_OPTIONS_PANEL) {
            //return onCreateOptionsMenu(menu);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.754 -0400", hash_original_method = "A95440A37102593BE255304F4188998E", hash_generated_method = "7E6F1E213D603A965E7BBA8EEABE026E")
    public boolean onPreparePanel(int featureId, View view, Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(menu.getTaint());
        addTaint(view.getTaint());
        addTaint(featureId);
        if(featureId == Window.FEATURE_OPTIONS_PANEL && menu != null)        
        {
            boolean goforit = onPrepareOptionsMenu(menu);
            boolean var6F30EC4F22FBB3CC309B851E4D801F61_1554969276 = (goforit && menu.hasVisibleItems());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1165364184 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1165364184;
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1011130265 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_195949090 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_195949090;
        // ---------- Original Method ----------
        //if (featureId == Window.FEATURE_OPTIONS_PANEL && menu != null) {
            //boolean goforit = onPrepareOptionsMenu(menu);
            //return goforit && menu.hasVisibleItems();
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.755 -0400", hash_original_method = "F5A72D2A4A42C0CE2781798802611276", hash_generated_method = "8A4652CC7A9F7BDCD7F8956E0FE4D1EE")
    public boolean onMenuOpened(int featureId, Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(menu.getTaint());
        addTaint(featureId);
        if(featureId == Window.FEATURE_ACTION_BAR)        
        {
            mActionBar.dispatchMenuVisibilityChanged(true);
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_658188496 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_111380676 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_111380676;
        // ---------- Original Method ----------
        //if (featureId == Window.FEATURE_ACTION_BAR) {
            //mActionBar.dispatchMenuVisibilityChanged(true);
        //}
        //return true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.755 -0400", hash_original_method = "CDCEA93B87CB4399825B767626A61473", hash_generated_method = "753653E20F015A47902F4A57CCF275EA")
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(item.getTaint());
        addTaint(featureId);
        boolean var68934A3E9455FA72420237EB05902327_1732676499 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_153779980 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_153779980;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.755 -0400", hash_original_method = "20C3110FD341FFE95CFF6A6C95609D00", hash_generated_method = "55596AD77CCFB11415C38DB66566F366")
    public void onPanelClosed(int featureId, Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(menu.getTaint());
        addTaint(featureId);
        if(featureId == Window.FEATURE_ACTION_BAR)        
        {
            mActionBar.dispatchMenuVisibilityChanged(false);
        } //End block
        // ---------- Original Method ----------
        //if (featureId == Window.FEATURE_ACTION_BAR) {
            //mActionBar.dispatchMenuVisibilityChanged(false);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.756 -0400", hash_original_method = "F3CAA7B8E21AB403B530132B4E52A4EB", hash_generated_method = "56CADAC6A459F6B4A30682D08E6607A6")
    public boolean onCreateOptionsMenu(Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(menu.getTaint());
        boolean varB326B5062B2F0E69046810717534CB09_232685007 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2108494372 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2108494372;
        // ---------- Original Method ----------
        //return true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.757 -0400", hash_original_method = "BF0F08B18C75FC62D01E0D6DB107696E", hash_generated_method = "88B62F70A765B02C87565A6968286374")
    public boolean onPrepareOptionsMenu(Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(menu.getTaint());
        boolean varB326B5062B2F0E69046810717534CB09_179971042 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1326910294 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1326910294;
        // ---------- Original Method ----------
        //return true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.757 -0400", hash_original_method = "8EF9A1828892EFEBF4B93362A866125C", hash_generated_method = "F3BB833F6BE9A083C289BCEA6B772BFF")
    public boolean onOptionsItemSelected(MenuItem item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(item.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_1481734980 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1211672272 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1211672272;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.758 -0400", hash_original_method = "D53E4189B6E7F0EC0F9883E9844F2140", hash_generated_method = "CC9F879215C8D6911F3F43FE45124EF9")
    public void onOptionsMenuClosed(Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(menu.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.759 -0400", hash_original_method = "756759165F6AB2C8C6E469E63BE14186", hash_generated_method = "8F36C449192E9A4FC8F578B78BE7C244")
    public void openOptionsMenu() {
        mWindow.openPanel(Window.FEATURE_OPTIONS_PANEL, null);
        // ---------- Original Method ----------
        //mWindow.openPanel(Window.FEATURE_OPTIONS_PANEL, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.759 -0400", hash_original_method = "D12ED1735BBB9BCDCD831C99F03640D7", hash_generated_method = "249BD0BDCB652EF31D4B735086D0BDEC")
    public void closeOptionsMenu() {
        mWindow.closePanel(Window.FEATURE_OPTIONS_PANEL);
        // ---------- Original Method ----------
        //mWindow.closePanel(Window.FEATURE_OPTIONS_PANEL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.760 -0400", hash_original_method = "319389EBA801B290FB41D02473EB2E9E", hash_generated_method = "E3CB03CA5E4EB5916215E567B4276E95")
    public void invalidateOptionsMenu() {
        mWindow.invalidatePanelMenu(Window.FEATURE_OPTIONS_PANEL);
        // ---------- Original Method ----------
        //mWindow.invalidatePanelMenu(Window.FEATURE_OPTIONS_PANEL);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.760 -0400", hash_original_method = "85F2A519B2781A30F4BC68DB47459C98", hash_generated_method = "7E675DA5E9A426B1D0A463AC60958A2A")
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(menuInfo.getTaint());
        addTaint(v.getTaint());
        addTaint(menu.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.761 -0400", hash_original_method = "1A123249F7C2C892EA53E2F44D60C1FB", hash_generated_method = "A6804032F4A398F98AB72F29BB096EED")
    public void registerForContextMenu(View view) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(view.getTaint());
        view.setOnCreateContextMenuListener(this);
        // ---------- Original Method ----------
        //view.setOnCreateContextMenuListener(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.761 -0400", hash_original_method = "6A7E2B106BB1CEE7C3B668A773DE5A5B", hash_generated_method = "00514E90EA9081E765956475D78499EF")
    public void unregisterForContextMenu(View view) {
        addTaint(view.getTaint());
        view.setOnCreateContextMenuListener(null);
        // ---------- Original Method ----------
        //view.setOnCreateContextMenuListener(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.762 -0400", hash_original_method = "D1451DBD5DFD14FAE397660897192E3C", hash_generated_method = "C843096FC988D7D7DCCAAEBAE1988481")
    public void openContextMenu(View view) {
        addTaint(view.getTaint());
        view.showContextMenu();
        // ---------- Original Method ----------
        //view.showContextMenu();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.763 -0400", hash_original_method = "801D77DFDCCE5570587CA592634E3D3B", hash_generated_method = "2F6DB32593F56AE6F7F44563B067B637")
    public boolean onContextItemSelected(MenuItem item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(item.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_1259075302 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1509228196 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1509228196;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.763 -0400", hash_original_method = "5C6F377B774E414E6D9422BBC7AAE81F", hash_generated_method = "F6A83BFE417F19EC2EE2F1DD7A9E9351")
    public void onContextMenuClosed(Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(menu.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.764 -0400", hash_original_method = "38790ED2FB6D0EF1B7954716C7615F0D", hash_generated_method = "F3136CB466E468CF08274FF902074CFD")
    public boolean onSearchRequested() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        final SearchManager searchManager = (SearchManager) mContext
                .getSystemService(Context.SEARCH_SERVICE);
        final ComponentName appName = getAssociatedActivity();
        if(appName != null && searchManager.getSearchableInfo(appName) != null)        
        {
            searchManager.startSearch(null, false, appName, null, false);
            dismiss();
            boolean varB326B5062B2F0E69046810717534CB09_714105652 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_744116897 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_744116897;
        } //End block
        else
        {
            boolean var68934A3E9455FA72420237EB05902327_178666277 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_908160465 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_908160465;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.765 -0400", hash_original_method = "5D1C131301342FA877A860064E23A1A6", hash_generated_method = "11F77F7DD9A40A1BCF2A392CF025ED1D")
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(callback.getTaint());
        if(mActionBar != null)        
        {
ActionMode var8AEDBD2BEB8F07A00A535933A5F34D1D_1694554814 =             mActionBar.startActionMode(callback);
            var8AEDBD2BEB8F07A00A535933A5F34D1D_1694554814.addTaint(taint);
            return var8AEDBD2BEB8F07A00A535933A5F34D1D_1694554814;
        } //End block
ActionMode var540C13E9E156B687226421B24F2DF178_1917337497 =         null;
        var540C13E9E156B687226421B24F2DF178_1917337497.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1917337497;
        // ---------- Original Method ----------
        //if (mActionBar != null) {
            //return mActionBar.startActionMode(callback);
        //}
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.766 -0400", hash_original_method = "00C0B67E273850713F0D88B8DE976F73", hash_generated_method = "CC0EA6E92777768F9F821B7C1ECE81BA")
    public void onActionModeStarted(ActionMode mode) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mActionMode = mode;
        // ---------- Original Method ----------
        //mActionMode = mode;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.767 -0400", hash_original_method = "9FD315390CEABDE5B2497E2EE78C905A", hash_generated_method = "DFA92AA12F83EF5842BA7577776AC407")
    public void onActionModeFinished(ActionMode mode) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(mode.getTaint());
        if(mode == mActionMode)        
        {
            mActionMode = null;
        } //End block
        // ---------- Original Method ----------
        //if (mode == mActionMode) {
            //mActionMode = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.768 -0400", hash_original_method = "2C0F3C4A58B092DBFC10EA72C5A7ED76", hash_generated_method = "648F7D99CDDB85661F4AA09CE095CE8B")
    private ComponentName getAssociatedActivity() {
        Activity activity = mOwnerActivity;
        Context context = getContext();
        while
(activity == null && context != null)        
        {
            if(context instanceof Activity)            
            {
                activity = (Activity) context;
            } //End block
            else
            {
                context = (context instanceof ContextWrapper) ?
                        ((ContextWrapper) context).getBaseContext() : 
                        null;
            } //End block
        } //End block
ComponentName var86A97AAEFB0079F028A4C489F4F84789_324732896 =         activity == null ? null : activity.getComponentName();
        var86A97AAEFB0079F028A4C489F4F84789_324732896.addTaint(taint);
        return var86A97AAEFB0079F028A4C489F4F84789_324732896;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.769 -0400", hash_original_method = "18F720E0A5C2702D89E6608BD6B708CA", hash_generated_method = "FD1B3CCF50845769CEE10F3988196F47")
    public void takeKeyEvents(boolean get) {
        addTaint(get);
        mWindow.takeKeyEvents(get);
        // ---------- Original Method ----------
        //mWindow.takeKeyEvents(get);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.770 -0400", hash_original_method = "3CDF417FCD4F33EAE6CFCF0FB6D583A8", hash_generated_method = "E2551BB2BDCA391014D9F52E619D10A2")
    public final boolean requestWindowFeature(int featureId) {
        addTaint(featureId);
        boolean varE4F9C4B29456CD18692A96646504123C_869760097 = (getWindow().requestFeature(featureId));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_453531701 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_453531701;
        // ---------- Original Method ----------
        //return getWindow().requestFeature(featureId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.770 -0400", hash_original_method = "E7AFD534CB1DF8060614ED36111B2407", hash_generated_method = "2BFA4306CBED4C696B6B062B629554E3")
    public final void setFeatureDrawableResource(int featureId, int resId) {
        addTaint(resId);
        addTaint(featureId);
        getWindow().setFeatureDrawableResource(featureId, resId);
        // ---------- Original Method ----------
        //getWindow().setFeatureDrawableResource(featureId, resId);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.771 -0400", hash_original_method = "2E53659D6309BF8C5C8E8AD82BD6A577", hash_generated_method = "29B383C4D5EDB762E45EC352A7CB31AA")
    public final void setFeatureDrawableUri(int featureId, Uri uri) {
        addTaint(uri.getTaint());
        addTaint(featureId);
        getWindow().setFeatureDrawableUri(featureId, uri);
        // ---------- Original Method ----------
        //getWindow().setFeatureDrawableUri(featureId, uri);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.771 -0400", hash_original_method = "D3FA0A5870730A6F3C959B16FC004BCD", hash_generated_method = "C76B89C9812B57A2354090A517CBDED8")
    public final void setFeatureDrawable(int featureId, Drawable drawable) {
        addTaint(drawable.getTaint());
        addTaint(featureId);
        getWindow().setFeatureDrawable(featureId, drawable);
        // ---------- Original Method ----------
        //getWindow().setFeatureDrawable(featureId, drawable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.772 -0400", hash_original_method = "4D2A81FF8C2C83F47460DEB3120C04CB", hash_generated_method = "22F02FBFF89811CD2F189F47D063D4BD")
    public final void setFeatureDrawableAlpha(int featureId, int alpha) {
        addTaint(alpha);
        addTaint(featureId);
        getWindow().setFeatureDrawableAlpha(featureId, alpha);
        // ---------- Original Method ----------
        //getWindow().setFeatureDrawableAlpha(featureId, alpha);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.772 -0400", hash_original_method = "2F200E491A9F2CDC38C392035D21ED48", hash_generated_method = "39D20B6357C24CC57E0CDC008D91B139")
    public LayoutInflater getLayoutInflater() {
LayoutInflater var8D6DD3C28714B51EAA9625A43B68EFD5_1258320974 =         getWindow().getLayoutInflater();
        var8D6DD3C28714B51EAA9625A43B68EFD5_1258320974.addTaint(taint);
        return var8D6DD3C28714B51EAA9625A43B68EFD5_1258320974;
        // ---------- Original Method ----------
        //return getWindow().getLayoutInflater();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.773 -0400", hash_original_method = "C80CDCB014C953B0801E95FEB1706C5F", hash_generated_method = "99A166D313D0204F9E1B3BB77DF8F04A")
    public void setCancelable(boolean flag) {
        mCancelable = flag;
        // ---------- Original Method ----------
        //mCancelable = flag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.774 -0400", hash_original_method = "BD7DFECDBEA3F81451B9076CEFC17564", hash_generated_method = "69E8732D885DAEE34F4F0A9BFA9E1A81")
    public void setCanceledOnTouchOutside(boolean cancel) {
        addTaint(cancel);
        if(cancel && !mCancelable)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.774 -0400", hash_original_method = "4DD1D51C0E16D279CD855F2D66BA21A6", hash_generated_method = "2EB3F927676DC268FDB8A129F638A4AE")
    public void cancel() {
        if(!mCanceled && mCancelMessage != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.775 -0400", hash_original_method = "B6A3C715E726D4D77D298D569C13057A", hash_generated_method = "95F41A85B90A80A4E33B245BB5BA05B6")
    public void setOnCancelListener(final OnCancelListener listener) {
        if(mCancelAndDismissTaken != null)        
        {
            IllegalStateException varCACB09F99126C682072324933B827989_2008162334 = new IllegalStateException(
                    "OnCancelListener is already taken by "
                    + mCancelAndDismissTaken + " and can not be replaced.");
            varCACB09F99126C682072324933B827989_2008162334.addTaint(taint);
            throw varCACB09F99126C682072324933B827989_2008162334;
        } //End block
        if(listener != null)        
        {
            mCancelMessage = mListenersHandler.obtainMessage(CANCEL, listener);
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.776 -0400", hash_original_method = "774019D9ADE46FB9924B78D145C17F36", hash_generated_method = "3D496AF9B1B4D7260FDDA232E220A62F")
    public void setCancelMessage(final Message msg) {
        mCancelMessage = msg;
        // ---------- Original Method ----------
        //mCancelMessage = msg;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.777 -0400", hash_original_method = "464A84E289A7DD535A8EA3034BC5D33F", hash_generated_method = "AB374898C720DF34A158B1DDAF079A54")
    public void setOnDismissListener(final OnDismissListener listener) {
        if(mCancelAndDismissTaken != null)        
        {
            IllegalStateException varBDD9AF49F036C6867A9FB6BDD9E944FB_89703885 = new IllegalStateException(
                    "OnDismissListener is already taken by "
                    + mCancelAndDismissTaken + " and can not be replaced.");
            varBDD9AF49F036C6867A9FB6BDD9E944FB_89703885.addTaint(taint);
            throw varBDD9AF49F036C6867A9FB6BDD9E944FB_89703885;
        } //End block
        if(listener != null)        
        {
            mDismissMessage = mListenersHandler.obtainMessage(DISMISS, listener);
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.777 -0400", hash_original_method = "0B69163DC80B46ACDA2709DE4C77DC2F", hash_generated_method = "2252EDD037E9787C69B4BCA10D2B4BA9")
    public void setOnShowListener(OnShowListener listener) {
        if(listener != null)        
        {
            mShowMessage = mListenersHandler.obtainMessage(SHOW, listener);
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.778 -0400", hash_original_method = "2BD742B46509FC81ABA0DF4EC8F37AEC", hash_generated_method = "86E89A398CB75A38D126DF12BF88B627")
    public void setDismissMessage(final Message msg) {
        mDismissMessage = msg;
        // ---------- Original Method ----------
        //mDismissMessage = msg;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.778 -0400", hash_original_method = "4322D13EDCAAC15D5143567F42FC68A2", hash_generated_method = "25459E49C2406440CF2B581360E31CE1")
    public boolean takeCancelAndDismissListeners(String msg, final OnCancelListener cancel,
            final OnDismissListener dismiss) {
        addTaint(dismiss.getTaint());
        addTaint(cancel.getTaint());
        if(mCancelAndDismissTaken != null)        
        {
            mCancelAndDismissTaken = null;
        } //End block
        else
        if(mCancelMessage != null || mDismissMessage != null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_8430069 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_397277409 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_397277409;
        } //End block
        setOnCancelListener(cancel);
        setOnDismissListener(dismiss);
        mCancelAndDismissTaken = msg;
        boolean varB326B5062B2F0E69046810717534CB09_1476092442 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_375460422 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_375460422;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.779 -0400", hash_original_method = "70729F29EB37CCBEC739A5986214C32F", hash_generated_method = "80B29B3BBD8F623411679BA79F1EADEC")
    public final void setVolumeControlStream(int streamType) {
        addTaint(streamType);
        getWindow().setVolumeControlStream(streamType);
        // ---------- Original Method ----------
        //getWindow().setVolumeControlStream(streamType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.780 -0400", hash_original_method = "03A841DC7655848901B3CE2C14084AAE", hash_generated_method = "2D4D0164104CFCA5B691E578D9ED7757")
    public final int getVolumeControlStream() {
        int var160AF96B101FDFAA7B104A380D7A015D_2009644785 = (getWindow().getVolumeControlStream());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2057011338 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2057011338;
        // ---------- Original Method ----------
        //return getWindow().getVolumeControlStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.781 -0400", hash_original_method = "A9C3EE1B48BA32717B6024C41DF4E1F6", hash_generated_method = "EEA474A83FE4C7A6A402FA07BCAB4982")
    public void setOnKeyListener(final OnKeyListener onKeyListener) {
        mOnKeyListener = onKeyListener;
        // ---------- Original Method ----------
        //mOnKeyListener = onKeyListener;
    }

    
    private static final class ListenersHandler extends Handler {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.781 -0400", hash_original_field = "58806F2D99FD4DF33CF42E0C232738D7", hash_generated_field = "436872B12AE04B06D18A845CB0719BC2")

        private WeakReference<DialogInterface> mDialog;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.782 -0400", hash_original_method = "92DAC0D6E122198BF26AB724936B6539", hash_generated_method = "DF7B51E0F2F5846DF16713C1A26DD53E")
        public  ListenersHandler(Dialog dialog) {
            mDialog = new WeakReference<DialogInterface>(dialog);
            // ---------- Original Method ----------
            //mDialog = new WeakReference<DialogInterface>(dialog);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.783 -0400", hash_original_method = "0AC2BA822DE6E333F562D01CFB6CE49A", hash_generated_method = "B2DA8B896971D65C7825A8EC66D5DBEE")
        @Override
        public void handleMessage(Message msg) {
            addTaint(msg.getTaint());
switch(msg.what){
            case DISMISS:
            ((OnDismissListener) msg.obj).onDismiss(mDialog.get());
            break;
            case CANCEL:
            ((OnCancelListener) msg.obj).onCancel(mDialog.get());
            break;
            case SHOW:
            ((OnShowListener) msg.obj).onShow(mDialog.get());
            break;
}
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.783 -0400", hash_original_field = "C8104907E2C15136387E1FF354F2E289", hash_generated_field = "EFC22AB7F88AB7E35035F4D3FC081168")

    private static final String TAG = "Dialog";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.784 -0400", hash_original_field = "50C73827946947CD861F4B61AEA55633", hash_generated_field = "214E1AE6D64D144B8D5F29D5AF8A5A07")

    private static final int DISMISS = 0x43;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.784 -0400", hash_original_field = "9BA42FA53C623D78B24D53CDAE971C70", hash_generated_field = "5FAD2102A44A31CE5E01758518DF50F5")

    private static final int CANCEL = 0x44;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.784 -0400", hash_original_field = "7A4F616BE8122BA90E30406327492376", hash_generated_field = "12A0D52245758771AF8948C47070B9C1")

    private static final int SHOW = 0x45;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.785 -0400", hash_original_field = "9D0239578906B64ECBA46B3D33341F50", hash_generated_field = "A896FC35ACED801674ADC56E7BBC39CB")

    private static final String DIALOG_SHOWING_TAG = "android:dialogShowing";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.785 -0400", hash_original_field = "9B9870DF294A5143109BE6CEAFCC0E45", hash_generated_field = "7504B7324AA77CD343365D491A1E51D5")

    private static final String DIALOG_HIERARCHY_TAG = "android:dialogHierarchy";
}

