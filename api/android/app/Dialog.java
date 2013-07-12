package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.824 -0400", hash_original_field = "581D71027A593FE178E11F8CF96A261F", hash_generated_field = "8ACEFA51F1C212AC94944686D7E3BDFC")

    private Activity mOwnerActivity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.825 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "B997E37019471EC8FC5B98148C7A8AD7")

    Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.825 -0400", hash_original_field = "306519E50E3A91B9733D09F5D8EB985C", hash_generated_field = "83A062836C11DD52DC32F4325712F233")

    WindowManager mWindowManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.825 -0400", hash_original_field = "F4214BE1FFE044F8CA79EEDDDED72016", hash_generated_field = "C6B08D42C8EA2CB56500460CAF662F4C")

    Window mWindow;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.825 -0400", hash_original_field = "90456FC221E7A82F02F5F0D86665E9D8", hash_generated_field = "B4A10D2FE94FCA7877DCD1F8197DA38F")

    View mDecor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.825 -0400", hash_original_field = "6468B2E0460CFBFD40C03C7A36A45FDF", hash_generated_field = "7F8EF508978F38B8BCEC28D592DBFC22")

    private ActionBarImpl mActionBar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.825 -0400", hash_original_field = "CBE9C1F82FCE1BB545B279BE8BBA93EE", hash_generated_field = "6123942D1383A17F765E6BC984B8086E")

    protected boolean mCancelable = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.826 -0400", hash_original_field = "5EECE75098F1C3EE2E7D5C5604E7ABBE", hash_generated_field = "B13EDAE25BF4DFF139CD5FAE4D2A0A25")

    private String mCancelAndDismissTaken;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.826 -0400", hash_original_field = "4D534CFD5536B7EAE26E671B61999A02", hash_generated_field = "76C74178C09C090FAEDAAD0E8B0CF7A0")

    private Message mCancelMessage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.826 -0400", hash_original_field = "BE5032B19401D6C75DF159B7C44D7C01", hash_generated_field = "E192DE29CF3B86E1D4D51306D6613B44")

    private Message mDismissMessage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.826 -0400", hash_original_field = "9FDEEA4D408D357BE228AE1A75ED9410", hash_generated_field = "9DF7AF46D4C4365744738EB8C5D01451")

    private Message mShowMessage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.826 -0400", hash_original_field = "2A4FF7110738976278729426D6DBEF1F", hash_generated_field = "E9EAFA3F5F183CD7232E888DAC035728")

    private OnKeyListener mOnKeyListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.826 -0400", hash_original_field = "721C926D9558D59E55B02399D96F5508", hash_generated_field = "AE31AA5AE388883F7650182C0E3C7933")

    private boolean mCreated = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.826 -0400", hash_original_field = "B150E8FC39372026A2B260E47009CF79", hash_generated_field = "524E990B3B93C6331366CC3FFD800C87")

    private boolean mShowing = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.826 -0400", hash_original_field = "D91530AF3D6C660AC2C0C8D4CBB2367B", hash_generated_field = "67D6DA73468F2D6E84B945FD38F1CC1D")

    private boolean mCanceled = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.827 -0400", hash_original_field = "C5D62B7C4F8BE6B828DA51239EC692E0", hash_generated_field = "A94051227A36AE91A6CE3B31BF1DD3E6")

    private Thread mUiThread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.827 -0400", hash_original_field = "6781893E9FA50A9B7103FD3F674E566B", hash_generated_field = "2C33E5889A8CDA732A297DBE7101DB89")

    private final Handler mHandler = new Handler();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.827 -0400", hash_original_field = "A7C53D678AF31C89461A94B80C89667F", hash_generated_field = "BE6770D46FDA6621A2256CC938B90138")

    private Handler mListenersHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.827 -0400", hash_original_field = "3B382D379664B509F22D0EB5D96F2BA8", hash_generated_field = "941205D807AC4DF9704A65BDAF4756EC")

    private ActionMode mActionMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.380 -0400", hash_original_field = "90764B7AE877EFFD33D3124ADF85860E", hash_generated_field = "8FA22581A256DB33942DF76F392B65DC")

    private final Runnable mDismissAction = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.380 -0400", hash_original_method = "BEE19A9C5B7D04B78955A3FD8170F1CA", hash_generated_method = "4B98EED19700DEC05BCE304A452DAE0F")
        public void run() {
            dismissDialog();
            
            
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.828 -0400", hash_original_method = "BC9D2F22217346E354BF7BFC78A2D0C2", hash_generated_method = "6CD06A2CC25407F07D3CFC5AD07F9ABC")
    public  Dialog(Context context) {
        this(context, 0, true);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.828 -0400", hash_original_method = "E8683E6729C8449A45D83189604DFAE9", hash_generated_method = "108757FF77802F0B0AA5BC2DBAC4044F")
    public  Dialog(Context context, int theme) {
        this(context, theme, true);
        addTaint(theme);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.830 -0400", hash_original_method = "C6D5E1D2CF37954F320E3261297EC417", hash_generated_method = "5EAAE6526580FD747741313DD59D3181")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.831 -0400", hash_original_method = "845C16E53E1BE45A2BA7FF67CD257C6C", hash_generated_method = "E1811EB5F89C0A6FE0913B6E63230420")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.831 -0400", hash_original_method = "C9ADA56967BDAFB742C2181BE637639A", hash_generated_method = "C486698F1BBF0EDF2603E7FB98C64E63")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.832 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "079F71627FD0421D329AB8DE0AD30ED4")
    public final Context getContext() {
Context var178E2AD52D6FBBB503F908168856B574_67040668 =         mContext;
        var178E2AD52D6FBBB503F908168856B574_67040668.addTaint(taint);
        return var178E2AD52D6FBBB503F908168856B574_67040668;
        // ---------- Original Method ----------
        //return mContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.833 -0400", hash_original_method = "624FE63EC935EE8F7C5CD37954EA0AEA", hash_generated_method = "B6955C5EB478FD944D7F40DF8A05018A")
    public ActionBar getActionBar() {
ActionBar var02D7B9E52DFDAF29F050C055F2B0A03C_506315376 =         mActionBar;
        var02D7B9E52DFDAF29F050C055F2B0A03C_506315376.addTaint(taint);
        return var02D7B9E52DFDAF29F050C055F2B0A03C_506315376;
        // ---------- Original Method ----------
        //return mActionBar;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.834 -0400", hash_original_method = "AEEF4868262FBFB181A318E6FDCF1973", hash_generated_method = "2225ED786D910828047D511078A525A3")
    public final void setOwnerActivity(Activity activity) {
        mOwnerActivity = activity;
        getWindow().setVolumeControlStream(mOwnerActivity.getVolumeControlStream());
        // ---------- Original Method ----------
        //mOwnerActivity = activity;
        //getWindow().setVolumeControlStream(mOwnerActivity.getVolumeControlStream());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.834 -0400", hash_original_method = "D833D4731703AD671D7AED3C45CAE756", hash_generated_method = "87B4BA05093E382956098A251CC95B01")
    public final Activity getOwnerActivity() {
Activity var1F93BAB3C8E73BD5DD59D84CA7D69EBB_1826720456 =         mOwnerActivity;
        var1F93BAB3C8E73BD5DD59D84CA7D69EBB_1826720456.addTaint(taint);
        return var1F93BAB3C8E73BD5DD59D84CA7D69EBB_1826720456;
        // ---------- Original Method ----------
        //return mOwnerActivity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.835 -0400", hash_original_method = "F21458EB6FE36A924A49B40493E1F9F8", hash_generated_method = "9CC3DE35721D63C70C6A4917A6FFDFBA")
    public boolean isShowing() {
        boolean varED7142E6C56E85275A9E1F55586553C1_40204391 = (mShowing);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1632487732 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1632487732;
        // ---------- Original Method ----------
        //return mShowing;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.836 -0400", hash_original_method = "079FA2E5CA600A12F7067E75E853F614", hash_generated_method = "0D6731633B441978A86CBFA46E37F5A2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.837 -0400", hash_original_method = "4A0CDBB7EA97DC376E25E0EE43387CF4", hash_generated_method = "36C617C412CD5E025545E98033C55937")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.837 -0400", hash_original_method = "33443011198828BD072B057DA719765A", hash_generated_method = "91D25D057127796858709A51A2608F95")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.838 -0400", hash_original_method = "4ECC78F105BA2AD2FA21893BA556AFFD", hash_generated_method = "242D66148C2A6C04E17F2276D222F8BC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.839 -0400", hash_original_method = "866BAFBEBC09B92D7388CA2F75E61BAD", hash_generated_method = "02F2465081B30BD7BCD9FE91F06BA52C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.839 -0400", hash_original_method = "02D405BDD0443049D755381D9E715694", hash_generated_method = "21B6817432E19F232C011E2D2DD82365")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.840 -0400", hash_original_method = "CD27A7CE58254212F040E7B7DA65BCA4", hash_generated_method = "6D6D2A14DD6BC0D9DF03209869664ABF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.840 -0400", hash_original_method = "B84ED822BC6011EB138B2F6F1D018FE5", hash_generated_method = "DE98DECCC817096DF1B839F626292181")
    protected void onCreate(Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(savedInstanceState.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.841 -0400", hash_original_method = "1B4F9BFF1D832A07D0E1F41D0B16D2FF", hash_generated_method = "F707B3C87F748353E072C3436E18C9C9")
    protected void onStart() {
        //DSFIXME:  CODE0009: Possible callback target function detected
    if(mActionBar != null)        
        mActionBar.setShowHideAnimationEnabled(true);
        // ---------- Original Method ----------
        //if (mActionBar != null) mActionBar.setShowHideAnimationEnabled(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.841 -0400", hash_original_method = "28173EE669492C23D10F671D2D034693", hash_generated_method = "0B0C97EE9D52265E6D2DE60AB7FF1853")
    protected void onStop() {
        //DSFIXME:  CODE0009: Possible callback target function detected
    if(mActionBar != null)        
        mActionBar.setShowHideAnimationEnabled(false);
        // ---------- Original Method ----------
        //if (mActionBar != null) mActionBar.setShowHideAnimationEnabled(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.842 -0400", hash_original_method = "2D855197EA1046BD8EC8CA2E991844E1", hash_generated_method = "7319B7295383E346D5FD78B2EB26DB19")
    public Bundle onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Bundle bundle = new Bundle();
        bundle.putBoolean(DIALOG_SHOWING_TAG, mShowing);
    if(mCreated)        
        {
            bundle.putBundle(DIALOG_HIERARCHY_TAG, mWindow.saveHierarchyState());
        } //End block
Bundle var7B2862195409742DCA365D8C6330AB92_1146878724 =         bundle;
        var7B2862195409742DCA365D8C6330AB92_1146878724.addTaint(taint);
        return var7B2862195409742DCA365D8C6330AB92_1146878724;
        // ---------- Original Method ----------
        //Bundle bundle = new Bundle();
        //bundle.putBoolean(DIALOG_SHOWING_TAG, mShowing);
        //if (mCreated) {
            //bundle.putBundle(DIALOG_HIERARCHY_TAG, mWindow.saveHierarchyState());
        //}
        //return bundle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.842 -0400", hash_original_method = "EE5C9B4EF0AAEC8AB3AF49A30F3FD2D3", hash_generated_method = "84D84E77EA175E7C86D012B938DE2131")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.843 -0400", hash_original_method = "51ACB33F24592F8ED3FAFF9D96DEAF2A", hash_generated_method = "938DE1188B871995DC85ABF998325CDA")
    public Window getWindow() {
Window var125511BCCBD4CDF7BDF315F5AA8A1CE3_607792361 =         mWindow;
        var125511BCCBD4CDF7BDF315F5AA8A1CE3_607792361.addTaint(taint);
        return var125511BCCBD4CDF7BDF315F5AA8A1CE3_607792361;
        // ---------- Original Method ----------
        //return mWindow;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.843 -0400", hash_original_method = "44957F5326E5A87B91E438DCD3C71232", hash_generated_method = "82296F40CF6A45A5A63221A19F2D009A")
    public View getCurrentFocus() {
View varE3E79DFDA423BE71E1BD830287B2C373_863509020 =         mWindow != null ? mWindow.getCurrentFocus() : null;
        varE3E79DFDA423BE71E1BD830287B2C373_863509020.addTaint(taint);
        return varE3E79DFDA423BE71E1BD830287B2C373_863509020;
        // ---------- Original Method ----------
        //return mWindow != null ? mWindow.getCurrentFocus() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.844 -0400", hash_original_method = "FBC1E026CFF410D335B7C0F9A45B0829", hash_generated_method = "A44055903601B0A322C77FE56987E43F")
    public View findViewById(int id) {
        addTaint(id);
View var2EFFDC7A452E405931BA682E5046627A_843152522 =         mWindow.findViewById(id);
        var2EFFDC7A452E405931BA682E5046627A_843152522.addTaint(taint);
        return var2EFFDC7A452E405931BA682E5046627A_843152522;
        // ---------- Original Method ----------
        //return mWindow.findViewById(id);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.844 -0400", hash_original_method = "A6A8A3E553FD4B026D939E9AE3AC9985", hash_generated_method = "D42EABBC50BA73153301183635A696DB")
    public void setContentView(int layoutResID) {
        addTaint(layoutResID);
        mWindow.setContentView(layoutResID);
        // ---------- Original Method ----------
        //mWindow.setContentView(layoutResID);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.844 -0400", hash_original_method = "64A976C0ECE03B8AD97B801012E7B71B", hash_generated_method = "D878E663FCDD77C5051363CB448EA627")
    public void setContentView(View view) {
        addTaint(view.getTaint());
        mWindow.setContentView(view);
        // ---------- Original Method ----------
        //mWindow.setContentView(view);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.845 -0400", hash_original_method = "21FC0CE0727282A96780C185A7B70535", hash_generated_method = "09471B7B677F14A3E67F832D24AD58A4")
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        addTaint(params.getTaint());
        addTaint(view.getTaint());
        mWindow.setContentView(view, params);
        // ---------- Original Method ----------
        //mWindow.setContentView(view, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.845 -0400", hash_original_method = "54F8942E4EAEA6A93BE827863701CD23", hash_generated_method = "665B09C7A3EF5BBC249A7EFB789F9C6D")
    public void addContentView(View view, ViewGroup.LayoutParams params) {
        addTaint(params.getTaint());
        addTaint(view.getTaint());
        mWindow.addContentView(view, params);
        // ---------- Original Method ----------
        //mWindow.addContentView(view, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.846 -0400", hash_original_method = "A94A4616451E43B03E2FA5DD3DFB9ED3", hash_generated_method = "A0CEE0FAC86FA4A9BF32E5F8AF2F20CF")
    public void setTitle(CharSequence title) {
        addTaint(title.getTaint());
        mWindow.setTitle(title);
        mWindow.getAttributes().setTitle(title);
        // ---------- Original Method ----------
        //mWindow.setTitle(title);
        //mWindow.getAttributes().setTitle(title);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.847 -0400", hash_original_method = "0D914ED2883864B655DBF2629252A595", hash_generated_method = "E07D46779BB459B487B0A1D885E37983")
    public void setTitle(int titleId) {
        addTaint(titleId);
        setTitle(mContext.getText(titleId));
        // ---------- Original Method ----------
        //setTitle(mContext.getText(titleId));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.848 -0400", hash_original_method = "EB61104CC8357BEAF109072385D21C38", hash_generated_method = "A21B276ADCED2C8B7C8E2315BA7E34A2")
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
    if(keyCode == KeyEvent.KEYCODE_BACK)        
        {
            event.startTracking();
            boolean varB326B5062B2F0E69046810717534CB09_991763225 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1067186771 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1067186771;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1614083388 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1619837459 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1619837459;
        // ---------- Original Method ----------
        //if (keyCode == KeyEvent.KEYCODE_BACK) {
            //event.startTracking();
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.849 -0400", hash_original_method = "2A75FF2C44C4D96068DDAFC2643F0C8B", hash_generated_method = "B770A954D787A9C98816CDBFF9B21120")
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
        boolean var68934A3E9455FA72420237EB05902327_1718103157 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1098067326 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1098067326;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.850 -0400", hash_original_method = "CFFAC7119271281C27F3BEDCE8D82CC2", hash_generated_method = "7CA2E3EE0BC5BD48A85D5E2471814DAC")
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
    if(keyCode == KeyEvent.KEYCODE_BACK && event.isTracking()
                && !event.isCanceled())        
        {
            onBackPressed();
            boolean varB326B5062B2F0E69046810717534CB09_421802771 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1964104646 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1964104646;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_424781793 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_217236060 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_217236060;
        // ---------- Original Method ----------
        //if (keyCode == KeyEvent.KEYCODE_BACK && event.isTracking()
                //&& !event.isCanceled()) {
            //onBackPressed();
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.851 -0400", hash_original_method = "E364C67ED15F0AA31C6DCFFA6137C8C0", hash_generated_method = "76F4789663B78550584317CB3C434B88")
    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(repeatCount);
        addTaint(keyCode);
        boolean var68934A3E9455FA72420237EB05902327_69197595 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1199121111 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1199121111;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.851 -0400", hash_original_method = "EAEAA0DB8B83D24D321D98459F4FA29E", hash_generated_method = "79E2784B0F7F34B3F9AAFD2B90728F36")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.852 -0400", hash_original_method = "2ECF3E4914B4B3BE2238F799B7435A51", hash_generated_method = "9B128DD95BE6CC05B2B09CE70C171181")
    public boolean onKeyShortcut(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
        boolean var68934A3E9455FA72420237EB05902327_2106112052 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_780978437 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_780978437;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.853 -0400", hash_original_method = "5A4B1024EA76F961E6155B7F9E2B0909", hash_generated_method = "B164E9F0D59C7BB385649E703BF6A612")
    public boolean onTouchEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
    if(mCancelable && mShowing && mWindow.shouldCloseOnTouch(mContext, event))        
        {
            cancel();
            boolean varB326B5062B2F0E69046810717534CB09_64143391 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_922508294 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_922508294;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_836487532 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1052155878 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1052155878;
        // ---------- Original Method ----------
        //if (mCancelable && mShowing && mWindow.shouldCloseOnTouch(mContext, event)) {
            //cancel();
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.853 -0400", hash_original_method = "4A983FDB3FF481E2165B7D8D641CDD48", hash_generated_method = "26CBDDD915928FFB70C79CEAE3580630")
    public boolean onTrackballEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_255911289 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1735007470 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1735007470;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.854 -0400", hash_original_method = "0E59A005881F30C798F764BCF32D89A3", hash_generated_method = "37CD18BA4403426A5C93F2E7C312F328")
    public boolean onGenericMotionEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_93490743 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1397624195 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1397624195;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.856 -0400", hash_original_method = "4EF468126ED8F0323D4288D03F894270", hash_generated_method = "DA0BFB7C3887B4609A1A5BE9B6E4CD7C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.857 -0400", hash_original_method = "32D7339793DCE0D5AEFE6621981EC978", hash_generated_method = "15CE33052F85E41C1BB65E1E6B2C108A")
    public void onContentChanged() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.857 -0400", hash_original_method = "C7622FC561A602386C2112BC0445F7C6", hash_generated_method = "EEF2114A935228AD19BFEE6FAB48379F")
    public void onWindowFocusChanged(boolean hasFocus) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(hasFocus);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.858 -0400", hash_original_method = "D6E949EE9F0768F47016EEA4FC0347A8", hash_generated_method = "0E08FFA9282E502085CC6973CB60CDA1")
    public void onAttachedToWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.858 -0400", hash_original_method = "E592299EBB4DE1D6696EB8C4009A9EF4", hash_generated_method = "1328510831112E7A424EFCA8583CA87C")
    public void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.859 -0400", hash_original_method = "1435B67C8334D2AC8987004B54F10264", hash_generated_method = "69FF35F7901E9FAD1CCC5A2CBECFB54E")
    public boolean dispatchKeyEvent(KeyEvent event) {
        addTaint(event.getTaint());
    if((mOnKeyListener != null) && (mOnKeyListener.onKey(this, event.getKeyCode(), event)))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_942612547 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1674971314 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1674971314;
        } //End block
    if(mWindow.superDispatchKeyEvent(event))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_402194429 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_399281183 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_399281183;
        } //End block
        boolean varCCCCDC1EFAB25FDBFAE8D80010C4EC8E_1221889506 = (event.dispatch(this, mDecor != null
                ? mDecor.getKeyDispatcherState() : null, this));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1432191630 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1432191630;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.859 -0400", hash_original_method = "BA9D4031BD488C1D379B1950A362F8D4", hash_generated_method = "16C7582420F20A667E165106E72FEA88")
    public boolean dispatchKeyShortcutEvent(KeyEvent event) {
        addTaint(event.getTaint());
    if(mWindow.superDispatchKeyShortcutEvent(event))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1439983811 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1237490412 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1237490412;
        } //End block
        boolean var156E4CB1D436F15C72AC6FC64572DBC8_1729787408 = (onKeyShortcut(event.getKeyCode(), event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1759723867 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1759723867;
        // ---------- Original Method ----------
        //if (mWindow.superDispatchKeyShortcutEvent(event)) {
            //return true;
        //}
        //return onKeyShortcut(event.getKeyCode(), event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.860 -0400", hash_original_method = "D3052CDDAC0630315E0F5E7AF5478D0E", hash_generated_method = "F52F5A5D44D5CFC4B1BD87B4C096F8ED")
    public boolean dispatchTouchEvent(MotionEvent ev) {
        addTaint(ev.getTaint());
    if(mWindow.superDispatchTouchEvent(ev))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_693496666 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_620318991 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_620318991;
        } //End block
        boolean var6A82C8DBC967C7DCA9B560132CC6DCB4_167761198 = (onTouchEvent(ev));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1660949204 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1660949204;
        // ---------- Original Method ----------
        //if (mWindow.superDispatchTouchEvent(ev)) {
            //return true;
        //}
        //return onTouchEvent(ev);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.860 -0400", hash_original_method = "2B935C89EDDE71F28E7C978B3C9DCAB0", hash_generated_method = "551A11969A41930FCFE5203A2547DAE9")
    public boolean dispatchTrackballEvent(MotionEvent ev) {
        addTaint(ev.getTaint());
    if(mWindow.superDispatchTrackballEvent(ev))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_304866609 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1007579457 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1007579457;
        } //End block
        boolean var29D71352E688331DEA01A8CD09B7572F_1062748834 = (onTrackballEvent(ev));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1181119801 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1181119801;
        // ---------- Original Method ----------
        //if (mWindow.superDispatchTrackballEvent(ev)) {
            //return true;
        //}
        //return onTrackballEvent(ev);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.861 -0400", hash_original_method = "B6AB9C2BD67E148832650E309163688C", hash_generated_method = "DBAD4EF25DE6B5DF9B108BCDE6045B34")
    public boolean dispatchGenericMotionEvent(MotionEvent ev) {
        addTaint(ev.getTaint());
    if(mWindow.superDispatchGenericMotionEvent(ev))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1360895149 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1189162095 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1189162095;
        } //End block
        boolean varE3EC3986EBBB841CE7203BD438C75A8B_255364301 = (onGenericMotionEvent(ev));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1827506228 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1827506228;
        // ---------- Original Method ----------
        //if (mWindow.superDispatchGenericMotionEvent(ev)) {
            //return true;
        //}
        //return onGenericMotionEvent(ev);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.861 -0400", hash_original_method = "3CC377981D86463D050A06CF1F7ED782", hash_generated_method = "F00E1F0B7CB8B81433C6351E5DDD4B21")
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        addTaint(event.getTaint());
        event.setClassName(getClass().getName());
        event.setPackageName(mContext.getPackageName());
        LayoutParams params = getWindow().getAttributes();
        boolean isFullScreen = (params.width == LayoutParams.MATCH_PARENT) &&
            (params.height == LayoutParams.MATCH_PARENT);
        event.setFullScreen(isFullScreen);
        boolean var68934A3E9455FA72420237EB05902327_1949862870 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1950409408 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1950409408;
        // ---------- Original Method ----------
        //event.setClassName(getClass().getName());
        //event.setPackageName(mContext.getPackageName());
        //LayoutParams params = getWindow().getAttributes();
        //boolean isFullScreen = (params.width == LayoutParams.MATCH_PARENT) &&
            //(params.height == LayoutParams.MATCH_PARENT);
        //event.setFullScreen(isFullScreen);
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.862 -0400", hash_original_method = "8FB2859FE43E0606E21921E291A18BDA", hash_generated_method = "05A9F70D0DC546DD39289BCE90D6B1B8")
    public View onCreatePanelView(int featureId) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(featureId);
View var540C13E9E156B687226421B24F2DF178_1196661102 =         null;
        var540C13E9E156B687226421B24F2DF178_1196661102.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1196661102;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.862 -0400", hash_original_method = "1B30E4AD9FCCEF2C81163B46B66D301C", hash_generated_method = "2E6B8E9C1B421D9D9B334FD1174880AA")
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(menu.getTaint());
        addTaint(featureId);
    if(featureId == Window.FEATURE_OPTIONS_PANEL)        
        {
            boolean varC89E509CAF9218615C834839CA8189E8_388562942 = (onCreateOptionsMenu(menu));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_599312704 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_599312704;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_169908898 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1588948375 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1588948375;
        // ---------- Original Method ----------
        //if (featureId == Window.FEATURE_OPTIONS_PANEL) {
            //return onCreateOptionsMenu(menu);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.863 -0400", hash_original_method = "A95440A37102593BE255304F4188998E", hash_generated_method = "EAF5E867ACA88515D748EED6D66AAB93")
    public boolean onPreparePanel(int featureId, View view, Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(menu.getTaint());
        addTaint(view.getTaint());
        addTaint(featureId);
    if(featureId == Window.FEATURE_OPTIONS_PANEL && menu != null)        
        {
            boolean goforit = onPrepareOptionsMenu(menu);
            boolean var6F30EC4F22FBB3CC309B851E4D801F61_351040478 = (goforit && menu.hasVisibleItems());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_284820551 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_284820551;
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1936410845 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_798340679 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_798340679;
        // ---------- Original Method ----------
        //if (featureId == Window.FEATURE_OPTIONS_PANEL && menu != null) {
            //boolean goforit = onPrepareOptionsMenu(menu);
            //return goforit && menu.hasVisibleItems();
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.864 -0400", hash_original_method = "F5A72D2A4A42C0CE2781798802611276", hash_generated_method = "73917E34373C43F7AE8F7F07E7213101")
    public boolean onMenuOpened(int featureId, Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(menu.getTaint());
        addTaint(featureId);
    if(featureId == Window.FEATURE_ACTION_BAR)        
        {
            mActionBar.dispatchMenuVisibilityChanged(true);
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_881250256 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_728079388 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_728079388;
        // ---------- Original Method ----------
        //if (featureId == Window.FEATURE_ACTION_BAR) {
            //mActionBar.dispatchMenuVisibilityChanged(true);
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.865 -0400", hash_original_method = "CDCEA93B87CB4399825B767626A61473", hash_generated_method = "AC1B11F5A7CB0E3EF6A8557DCCAF5428")
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(item.getTaint());
        addTaint(featureId);
        boolean var68934A3E9455FA72420237EB05902327_806695928 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1805900587 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1805900587;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.865 -0400", hash_original_method = "20C3110FD341FFE95CFF6A6C95609D00", hash_generated_method = "55596AD77CCFB11415C38DB66566F366")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.866 -0400", hash_original_method = "F3CAA7B8E21AB403B530132B4E52A4EB", hash_generated_method = "5808E091F363FCEB9F2339EE0534EE38")
    public boolean onCreateOptionsMenu(Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(menu.getTaint());
        boolean varB326B5062B2F0E69046810717534CB09_1493466316 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_744025564 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_744025564;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.866 -0400", hash_original_method = "BF0F08B18C75FC62D01E0D6DB107696E", hash_generated_method = "6FDC1DE9A7EA025A0FCA21385B9EDF6C")
    public boolean onPrepareOptionsMenu(Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(menu.getTaint());
        boolean varB326B5062B2F0E69046810717534CB09_1434299837 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1770412411 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1770412411;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.867 -0400", hash_original_method = "8EF9A1828892EFEBF4B93362A866125C", hash_generated_method = "087DB67EEA040CD3E47ADA651F3D3275")
    public boolean onOptionsItemSelected(MenuItem item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(item.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_324296247 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_127980912 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_127980912;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.867 -0400", hash_original_method = "D53E4189B6E7F0EC0F9883E9844F2140", hash_generated_method = "CC9F879215C8D6911F3F43FE45124EF9")
    public void onOptionsMenuClosed(Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(menu.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.868 -0400", hash_original_method = "756759165F6AB2C8C6E469E63BE14186", hash_generated_method = "8F36C449192E9A4FC8F578B78BE7C244")
    public void openOptionsMenu() {
        mWindow.openPanel(Window.FEATURE_OPTIONS_PANEL, null);
        // ---------- Original Method ----------
        //mWindow.openPanel(Window.FEATURE_OPTIONS_PANEL, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.868 -0400", hash_original_method = "D12ED1735BBB9BCDCD831C99F03640D7", hash_generated_method = "249BD0BDCB652EF31D4B735086D0BDEC")
    public void closeOptionsMenu() {
        mWindow.closePanel(Window.FEATURE_OPTIONS_PANEL);
        // ---------- Original Method ----------
        //mWindow.closePanel(Window.FEATURE_OPTIONS_PANEL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.868 -0400", hash_original_method = "319389EBA801B290FB41D02473EB2E9E", hash_generated_method = "E3CB03CA5E4EB5916215E567B4276E95")
    public void invalidateOptionsMenu() {
        mWindow.invalidatePanelMenu(Window.FEATURE_OPTIONS_PANEL);
        // ---------- Original Method ----------
        //mWindow.invalidatePanelMenu(Window.FEATURE_OPTIONS_PANEL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.869 -0400", hash_original_method = "85F2A519B2781A30F4BC68DB47459C98", hash_generated_method = "7E675DA5E9A426B1D0A463AC60958A2A")
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(menuInfo.getTaint());
        addTaint(v.getTaint());
        addTaint(menu.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.869 -0400", hash_original_method = "1A123249F7C2C892EA53E2F44D60C1FB", hash_generated_method = "A6804032F4A398F98AB72F29BB096EED")
    public void registerForContextMenu(View view) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(view.getTaint());
        view.setOnCreateContextMenuListener(this);
        // ---------- Original Method ----------
        //view.setOnCreateContextMenuListener(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.870 -0400", hash_original_method = "6A7E2B106BB1CEE7C3B668A773DE5A5B", hash_generated_method = "00514E90EA9081E765956475D78499EF")
    public void unregisterForContextMenu(View view) {
        addTaint(view.getTaint());
        view.setOnCreateContextMenuListener(null);
        // ---------- Original Method ----------
        //view.setOnCreateContextMenuListener(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.870 -0400", hash_original_method = "D1451DBD5DFD14FAE397660897192E3C", hash_generated_method = "C843096FC988D7D7DCCAAEBAE1988481")
    public void openContextMenu(View view) {
        addTaint(view.getTaint());
        view.showContextMenu();
        // ---------- Original Method ----------
        //view.showContextMenu();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.871 -0400", hash_original_method = "801D77DFDCCE5570587CA592634E3D3B", hash_generated_method = "5E02256C4AADB4986E4CF87B6C3A6383")
    public boolean onContextItemSelected(MenuItem item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(item.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_113350128 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_785354915 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_785354915;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.871 -0400", hash_original_method = "5C6F377B774E414E6D9422BBC7AAE81F", hash_generated_method = "F6A83BFE417F19EC2EE2F1DD7A9E9351")
    public void onContextMenuClosed(Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(menu.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.872 -0400", hash_original_method = "38790ED2FB6D0EF1B7954716C7615F0D", hash_generated_method = "934DA76C90BF551873CCF11F5BCAB455")
    public boolean onSearchRequested() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        final SearchManager searchManager = (SearchManager) mContext
                .getSystemService(Context.SEARCH_SERVICE);
        final ComponentName appName = getAssociatedActivity();
    if(appName != null && searchManager.getSearchableInfo(appName) != null)        
        {
            searchManager.startSearch(null, false, appName, null, false);
            dismiss();
            boolean varB326B5062B2F0E69046810717534CB09_1016611444 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_639427810 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_639427810;
        } //End block
        else
        {
            boolean var68934A3E9455FA72420237EB05902327_2105268156 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_760679219 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_760679219;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.873 -0400", hash_original_method = "5D1C131301342FA877A860064E23A1A6", hash_generated_method = "C9A76866940DCD70F39F1309D4D7E91C")
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(callback.getTaint());
    if(mActionBar != null)        
        {
ActionMode var8AEDBD2BEB8F07A00A535933A5F34D1D_1828609240 =             mActionBar.startActionMode(callback);
            var8AEDBD2BEB8F07A00A535933A5F34D1D_1828609240.addTaint(taint);
            return var8AEDBD2BEB8F07A00A535933A5F34D1D_1828609240;
        } //End block
ActionMode var540C13E9E156B687226421B24F2DF178_231667888 =         null;
        var540C13E9E156B687226421B24F2DF178_231667888.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_231667888;
        // ---------- Original Method ----------
        //if (mActionBar != null) {
            //return mActionBar.startActionMode(callback);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.874 -0400", hash_original_method = "00C0B67E273850713F0D88B8DE976F73", hash_generated_method = "CC0EA6E92777768F9F821B7C1ECE81BA")
    public void onActionModeStarted(ActionMode mode) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mActionMode = mode;
        // ---------- Original Method ----------
        //mActionMode = mode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.875 -0400", hash_original_method = "9FD315390CEABDE5B2497E2EE78C905A", hash_generated_method = "DFA92AA12F83EF5842BA7577776AC407")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.878 -0400", hash_original_method = "2C0F3C4A58B092DBFC10EA72C5A7ED76", hash_generated_method = "C8B563B2E39A5C7123AEBBC3E2826D92")
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
ComponentName var86A97AAEFB0079F028A4C489F4F84789_1563205729 =         activity == null ? null : activity.getComponentName();
        var86A97AAEFB0079F028A4C489F4F84789_1563205729.addTaint(taint);
        return var86A97AAEFB0079F028A4C489F4F84789_1563205729;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.879 -0400", hash_original_method = "18F720E0A5C2702D89E6608BD6B708CA", hash_generated_method = "FD1B3CCF50845769CEE10F3988196F47")
    public void takeKeyEvents(boolean get) {
        addTaint(get);
        mWindow.takeKeyEvents(get);
        // ---------- Original Method ----------
        //mWindow.takeKeyEvents(get);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.880 -0400", hash_original_method = "3CDF417FCD4F33EAE6CFCF0FB6D583A8", hash_generated_method = "A0E74E324574951BCC84E96D700F0984")
    public final boolean requestWindowFeature(int featureId) {
        addTaint(featureId);
        boolean varE4F9C4B29456CD18692A96646504123C_219445528 = (getWindow().requestFeature(featureId));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2025983976 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2025983976;
        // ---------- Original Method ----------
        //return getWindow().requestFeature(featureId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.881 -0400", hash_original_method = "E7AFD534CB1DF8060614ED36111B2407", hash_generated_method = "2BFA4306CBED4C696B6B062B629554E3")
    public final void setFeatureDrawableResource(int featureId, int resId) {
        addTaint(resId);
        addTaint(featureId);
        getWindow().setFeatureDrawableResource(featureId, resId);
        // ---------- Original Method ----------
        //getWindow().setFeatureDrawableResource(featureId, resId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.882 -0400", hash_original_method = "2E53659D6309BF8C5C8E8AD82BD6A577", hash_generated_method = "29B383C4D5EDB762E45EC352A7CB31AA")
    public final void setFeatureDrawableUri(int featureId, Uri uri) {
        addTaint(uri.getTaint());
        addTaint(featureId);
        getWindow().setFeatureDrawableUri(featureId, uri);
        // ---------- Original Method ----------
        //getWindow().setFeatureDrawableUri(featureId, uri);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.882 -0400", hash_original_method = "D3FA0A5870730A6F3C959B16FC004BCD", hash_generated_method = "C76B89C9812B57A2354090A517CBDED8")
    public final void setFeatureDrawable(int featureId, Drawable drawable) {
        addTaint(drawable.getTaint());
        addTaint(featureId);
        getWindow().setFeatureDrawable(featureId, drawable);
        // ---------- Original Method ----------
        //getWindow().setFeatureDrawable(featureId, drawable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.883 -0400", hash_original_method = "4D2A81FF8C2C83F47460DEB3120C04CB", hash_generated_method = "22F02FBFF89811CD2F189F47D063D4BD")
    public final void setFeatureDrawableAlpha(int featureId, int alpha) {
        addTaint(alpha);
        addTaint(featureId);
        getWindow().setFeatureDrawableAlpha(featureId, alpha);
        // ---------- Original Method ----------
        //getWindow().setFeatureDrawableAlpha(featureId, alpha);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.883 -0400", hash_original_method = "2F200E491A9F2CDC38C392035D21ED48", hash_generated_method = "E543096BB4AC993DB6AD12758AD51E36")
    public LayoutInflater getLayoutInflater() {
LayoutInflater var8D6DD3C28714B51EAA9625A43B68EFD5_491379368 =         getWindow().getLayoutInflater();
        var8D6DD3C28714B51EAA9625A43B68EFD5_491379368.addTaint(taint);
        return var8D6DD3C28714B51EAA9625A43B68EFD5_491379368;
        // ---------- Original Method ----------
        //return getWindow().getLayoutInflater();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.883 -0400", hash_original_method = "C80CDCB014C953B0801E95FEB1706C5F", hash_generated_method = "99A166D313D0204F9E1B3BB77DF8F04A")
    public void setCancelable(boolean flag) {
        mCancelable = flag;
        // ---------- Original Method ----------
        //mCancelable = flag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.884 -0400", hash_original_method = "BD7DFECDBEA3F81451B9076CEFC17564", hash_generated_method = "69E8732D885DAEE34F4F0A9BFA9E1A81")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.885 -0400", hash_original_method = "4DD1D51C0E16D279CD855F2D66BA21A6", hash_generated_method = "2EB3F927676DC268FDB8A129F638A4AE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.886 -0400", hash_original_method = "B6A3C715E726D4D77D298D569C13057A", hash_generated_method = "57628CFB320576A0CE9356316F576F50")
    public void setOnCancelListener(final OnCancelListener listener) {
    if(mCancelAndDismissTaken != null)        
        {
            IllegalStateException varCACB09F99126C682072324933B827989_1720535192 = new IllegalStateException(
                    "OnCancelListener is already taken by "
                    + mCancelAndDismissTaken + " and can not be replaced.");
            varCACB09F99126C682072324933B827989_1720535192.addTaint(taint);
            throw varCACB09F99126C682072324933B827989_1720535192;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.887 -0400", hash_original_method = "774019D9ADE46FB9924B78D145C17F36", hash_generated_method = "3D496AF9B1B4D7260FDDA232E220A62F")
    public void setCancelMessage(final Message msg) {
        mCancelMessage = msg;
        // ---------- Original Method ----------
        //mCancelMessage = msg;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.887 -0400", hash_original_method = "464A84E289A7DD535A8EA3034BC5D33F", hash_generated_method = "E291CF58F373D1A2CEF2E6FFE1053CD3")
    public void setOnDismissListener(final OnDismissListener listener) {
    if(mCancelAndDismissTaken != null)        
        {
            IllegalStateException varBDD9AF49F036C6867A9FB6BDD9E944FB_757709557 = new IllegalStateException(
                    "OnDismissListener is already taken by "
                    + mCancelAndDismissTaken + " and can not be replaced.");
            varBDD9AF49F036C6867A9FB6BDD9E944FB_757709557.addTaint(taint);
            throw varBDD9AF49F036C6867A9FB6BDD9E944FB_757709557;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.888 -0400", hash_original_method = "0B69163DC80B46ACDA2709DE4C77DC2F", hash_generated_method = "2252EDD037E9787C69B4BCA10D2B4BA9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.889 -0400", hash_original_method = "2BD742B46509FC81ABA0DF4EC8F37AEC", hash_generated_method = "86E89A398CB75A38D126DF12BF88B627")
    public void setDismissMessage(final Message msg) {
        mDismissMessage = msg;
        // ---------- Original Method ----------
        //mDismissMessage = msg;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.890 -0400", hash_original_method = "4322D13EDCAAC15D5143567F42FC68A2", hash_generated_method = "076E290060428A6D96AEAB5B4C85B139")
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
            boolean var68934A3E9455FA72420237EB05902327_405749181 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_347770323 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_347770323;
        } //End block
        setOnCancelListener(cancel);
        setOnDismissListener(dismiss);
        mCancelAndDismissTaken = msg;
        boolean varB326B5062B2F0E69046810717534CB09_1381100658 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1809023356 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1809023356;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.891 -0400", hash_original_method = "70729F29EB37CCBEC739A5986214C32F", hash_generated_method = "80B29B3BBD8F623411679BA79F1EADEC")
    public final void setVolumeControlStream(int streamType) {
        addTaint(streamType);
        getWindow().setVolumeControlStream(streamType);
        // ---------- Original Method ----------
        //getWindow().setVolumeControlStream(streamType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.891 -0400", hash_original_method = "03A841DC7655848901B3CE2C14084AAE", hash_generated_method = "B7C57DEF953C1D517D6301A2B16A40D2")
    public final int getVolumeControlStream() {
        int var160AF96B101FDFAA7B104A380D7A015D_1274572631 = (getWindow().getVolumeControlStream());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_580830493 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_580830493;
        // ---------- Original Method ----------
        //return getWindow().getVolumeControlStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.892 -0400", hash_original_method = "A9C3EE1B48BA32717B6024C41DF4E1F6", hash_generated_method = "EEA474A83FE4C7A6A402FA07BCAB4982")
    public void setOnKeyListener(final OnKeyListener onKeyListener) {
        mOnKeyListener = onKeyListener;
        // ---------- Original Method ----------
        //mOnKeyListener = onKeyListener;
    }

    
    private static final class ListenersHandler extends Handler {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.892 -0400", hash_original_field = "58806F2D99FD4DF33CF42E0C232738D7", hash_generated_field = "436872B12AE04B06D18A845CB0719BC2")

        private WeakReference<DialogInterface> mDialog;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.893 -0400", hash_original_method = "92DAC0D6E122198BF26AB724936B6539", hash_generated_method = "DF7B51E0F2F5846DF16713C1A26DD53E")
        public  ListenersHandler(Dialog dialog) {
            mDialog = new WeakReference<DialogInterface>(dialog);
            // ---------- Original Method ----------
            //mDialog = new WeakReference<DialogInterface>(dialog);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.894 -0400", hash_original_method = "0AC2BA822DE6E333F562D01CFB6CE49A", hash_generated_method = "B2DA8B896971D65C7825A8EC66D5DBEE")
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.895 -0400", hash_original_field = "C8104907E2C15136387E1FF354F2E289", hash_generated_field = "EFC22AB7F88AB7E35035F4D3FC081168")

    private static final String TAG = "Dialog";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.895 -0400", hash_original_field = "50C73827946947CD861F4B61AEA55633", hash_generated_field = "214E1AE6D64D144B8D5F29D5AF8A5A07")

    private static final int DISMISS = 0x43;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.895 -0400", hash_original_field = "9BA42FA53C623D78B24D53CDAE971C70", hash_generated_field = "5FAD2102A44A31CE5E01758518DF50F5")

    private static final int CANCEL = 0x44;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.896 -0400", hash_original_field = "7A4F616BE8122BA90E30406327492376", hash_generated_field = "12A0D52245758771AF8948C47070B9C1")

    private static final int SHOW = 0x45;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.896 -0400", hash_original_field = "9D0239578906B64ECBA46B3D33341F50", hash_generated_field = "A896FC35ACED801674ADC56E7BBC39CB")

    private static final String DIALOG_SHOWING_TAG = "android:dialogShowing";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.896 -0400", hash_original_field = "9B9870DF294A5143109BE6CEAFCC0E45", hash_generated_field = "7504B7324AA77CD343365D491A1E51D5")

    private static final String DIALOG_HIERARCHY_TAG = "android:dialogHierarchy";
}

