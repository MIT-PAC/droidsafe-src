package android.app;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.378 -0400", hash_original_field = "581D71027A593FE178E11F8CF96A261F", hash_generated_field = "8ACEFA51F1C212AC94944686D7E3BDFC")

    private Activity mOwnerActivity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.378 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "B997E37019471EC8FC5B98148C7A8AD7")

    Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.378 -0400", hash_original_field = "306519E50E3A91B9733D09F5D8EB985C", hash_generated_field = "83A062836C11DD52DC32F4325712F233")

    WindowManager mWindowManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.378 -0400", hash_original_field = "F4214BE1FFE044F8CA79EEDDDED72016", hash_generated_field = "C6B08D42C8EA2CB56500460CAF662F4C")

    Window mWindow;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.378 -0400", hash_original_field = "90456FC221E7A82F02F5F0D86665E9D8", hash_generated_field = "B4A10D2FE94FCA7877DCD1F8197DA38F")

    View mDecor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.378 -0400", hash_original_field = "6468B2E0460CFBFD40C03C7A36A45FDF", hash_generated_field = "7F8EF508978F38B8BCEC28D592DBFC22")

    private ActionBarImpl mActionBar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.378 -0400", hash_original_field = "CBE9C1F82FCE1BB545B279BE8BBA93EE", hash_generated_field = "6123942D1383A17F765E6BC984B8086E")

    protected boolean mCancelable = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.378 -0400", hash_original_field = "5EECE75098F1C3EE2E7D5C5604E7ABBE", hash_generated_field = "B13EDAE25BF4DFF139CD5FAE4D2A0A25")

    private String mCancelAndDismissTaken;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.378 -0400", hash_original_field = "4D534CFD5536B7EAE26E671B61999A02", hash_generated_field = "76C74178C09C090FAEDAAD0E8B0CF7A0")

    private Message mCancelMessage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.378 -0400", hash_original_field = "BE5032B19401D6C75DF159B7C44D7C01", hash_generated_field = "E192DE29CF3B86E1D4D51306D6613B44")

    private Message mDismissMessage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.378 -0400", hash_original_field = "9FDEEA4D408D357BE228AE1A75ED9410", hash_generated_field = "9DF7AF46D4C4365744738EB8C5D01451")

    private Message mShowMessage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.379 -0400", hash_original_field = "2A4FF7110738976278729426D6DBEF1F", hash_generated_field = "E9EAFA3F5F183CD7232E888DAC035728")

    private OnKeyListener mOnKeyListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.379 -0400", hash_original_field = "721C926D9558D59E55B02399D96F5508", hash_generated_field = "AE31AA5AE388883F7650182C0E3C7933")

    private boolean mCreated = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.379 -0400", hash_original_field = "B150E8FC39372026A2B260E47009CF79", hash_generated_field = "524E990B3B93C6331366CC3FFD800C87")

    private boolean mShowing = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.379 -0400", hash_original_field = "D91530AF3D6C660AC2C0C8D4CBB2367B", hash_generated_field = "67D6DA73468F2D6E84B945FD38F1CC1D")

    private boolean mCanceled = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.379 -0400", hash_original_field = "C5D62B7C4F8BE6B828DA51239EC692E0", hash_generated_field = "A94051227A36AE91A6CE3B31BF1DD3E6")

    private Thread mUiThread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.379 -0400", hash_original_field = "6781893E9FA50A9B7103FD3F674E566B", hash_generated_field = "2C33E5889A8CDA732A297DBE7101DB89")

    private final Handler mHandler = new Handler();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.380 -0400", hash_original_field = "A7C53D678AF31C89461A94B80C89667F", hash_generated_field = "BE6770D46FDA6621A2256CC938B90138")

    private Handler mListenersHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.380 -0400", hash_original_field = "3B382D379664B509F22D0EB5D96F2BA8", hash_generated_field = "941205D807AC4DF9704A65BDAF4756EC")

    private ActionMode mActionMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.380 -0400", hash_original_field = "90764B7AE877EFFD33D3124ADF85860E", hash_generated_field = "8FA22581A256DB33942DF76F392B65DC")

    private final Runnable mDismissAction = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.380 -0400", hash_original_method = "BEE19A9C5B7D04B78955A3FD8170F1CA", hash_generated_method = "4B98EED19700DEC05BCE304A452DAE0F")
        public void run() {
            dismissDialog();
            
            
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.381 -0400", hash_original_method = "BC9D2F22217346E354BF7BFC78A2D0C2", hash_generated_method = "6CD06A2CC25407F07D3CFC5AD07F9ABC")
    public  Dialog(Context context) {
        this(context, 0, true);
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.381 -0400", hash_original_method = "E8683E6729C8449A45D83189604DFAE9", hash_generated_method = "5CA78AFC53891D0639109A18F53ECD42")
    public  Dialog(Context context, int theme) {
        this(context, theme, true);
        addTaint(context.getTaint());
        addTaint(theme);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.382 -0400", hash_original_method = "C6D5E1D2CF37954F320E3261297EC417", hash_generated_method = "D7EF38D11784D6996ECA2C460CC94A83")
      Dialog(Context context, int theme, boolean createContextWrapper) {
        {
            TypedValue outValue = new TypedValue();
            context.getTheme().resolveAttribute(com.android.internal.R.attr.dialogTheme,
                    outValue, true);
            theme = outValue.resourceId;
        } 
        mContext = createContextWrapper ? new ContextThemeWrapper(context, theme) : context;
        mWindowManager = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        Window w = PolicyManager.makeNewWindow(mContext);
        mWindow = w;
        w.setCallback(this);
        w.setWindowManager(mWindowManager, null, null);
        w.setGravity(Gravity.CENTER);
        mUiThread = Thread.currentThread();
        mListenersHandler = new ListenersHandler(this);
        
        
            
            
                    
            
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.383 -0400", hash_original_method = "845C16E53E1BE45A2BA7FF67CD257C6C", hash_generated_method = "8FF4AE7B837C1FEB8E9EA8FAA6828F71")
    @Deprecated
    protected  Dialog(Context context, boolean cancelable,
            Message cancelCallback) {
        this(context);
        mCancelable = cancelable;
        mCancelMessage = cancelCallback;
        addTaint(context.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.384 -0400", hash_original_method = "C9ADA56967BDAFB742C2181BE637639A", hash_generated_method = "C6A8EE2383DA47A24EC7C78C286387AF")
    protected  Dialog(Context context, boolean cancelable,
            OnCancelListener cancelListener) {
        this(context);
        mCancelable = cancelable;
        setOnCancelListener(cancelListener);
        addTaint(context.getTaint());
        addTaint(cancelListener.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.385 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "CF6E38CF11897DB75B82B62B3C27BD65")
    public final Context getContext() {
        Context varB4EAC82CA7396A68D541C85D26508E83_172294133 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_172294133 = mContext;
        varB4EAC82CA7396A68D541C85D26508E83_172294133.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_172294133;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.386 -0400", hash_original_method = "624FE63EC935EE8F7C5CD37954EA0AEA", hash_generated_method = "0387E29C009C8728E843071D53B7F56D")
    public ActionBar getActionBar() {
        ActionBar varB4EAC82CA7396A68D541C85D26508E83_195234825 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_195234825 = mActionBar;
        varB4EAC82CA7396A68D541C85D26508E83_195234825.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_195234825;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.387 -0400", hash_original_method = "AEEF4868262FBFB181A318E6FDCF1973", hash_generated_method = "2225ED786D910828047D511078A525A3")
    public final void setOwnerActivity(Activity activity) {
        mOwnerActivity = activity;
        getWindow().setVolumeControlStream(mOwnerActivity.getVolumeControlStream());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.388 -0400", hash_original_method = "D833D4731703AD671D7AED3C45CAE756", hash_generated_method = "1305BC9FD3B434B6BE1D2D0FA9F132C4")
    public final Activity getOwnerActivity() {
        Activity varB4EAC82CA7396A68D541C85D26508E83_101985217 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_101985217 = mOwnerActivity;
        varB4EAC82CA7396A68D541C85D26508E83_101985217.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_101985217;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.389 -0400", hash_original_method = "F21458EB6FE36A924A49B40493E1F9F8", hash_generated_method = "D7F5A8A4AE8D69278613F8487CB42831")
    public boolean isShowing() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1625438776 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1625438776;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.390 -0400", hash_original_method = "079FA2E5CA600A12F7067E75E853F614", hash_generated_method = "A32807CF4D3F0475062EAF368D2D251B")
    public void show() {
        {
            {
                {
                    boolean varDF79E2FDC0F8C38E07A73A6CD2C66427_696354869 = (mWindow.hasFeature(Window.FEATURE_ACTION_BAR));
                    {
                        mWindow.invalidatePanelMenu(Window.FEATURE_ACTION_BAR);
                    } 
                } 
                mDecor.setVisibility(View.VISIBLE);
            } 
        } 
        mCanceled = false;
        {
            dispatchOnCreate(null);
        } 
        onStart();
        mDecor = mWindow.getDecorView();
        {
            boolean varF4E6C6330D33A37486BAA82B7DDC231D_175559291 = (mActionBar == null && mWindow.hasFeature(Window.FEATURE_ACTION_BAR));
            {
                mActionBar = new ActionBarImpl(this);
            } 
        } 
        WindowManager.LayoutParams l = mWindow.getAttributes();
        {
            WindowManager.LayoutParams nl = new WindowManager.LayoutParams();
            nl.copyFrom(l);
            nl.softInputMode |=
                    WindowManager.LayoutParams.SOFT_INPUT_IS_FORWARD_NAVIGATION;
            l = nl;
        } 
        try 
        {
            mWindowManager.addView(mDecor, l);
            mShowing = true;
            sendShowMessage();
        } 
        finally 
        { }
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.391 -0400", hash_original_method = "4A0CDBB7EA97DC376E25E0EE43387CF4", hash_generated_method = "D960C5A95FEB753FEAD909D760B2CA18")
    public void hide() {
        {
            mDecor.setVisibility(View.GONE);
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.391 -0400", hash_original_method = "33443011198828BD072B057DA719765A", hash_generated_method = "3C9106BDBAF372AC4F0C8D0EB5C482C0")
    public void dismiss() {
        {
            boolean varD46220B6DBDB2780BC14591AF2433BD7_1903306396 = (Thread.currentThread() != mUiThread);
            {
                mHandler.post(mDismissAction);
            } 
            {
                mHandler.removeCallbacks(mDismissAction);
                mDismissAction.run();
            } 
        } 
        
        
            
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.392 -0400", hash_original_method = "4ECC78F105BA2AD2FA21893BA556AFFD", hash_generated_method = "137709D9E71D78B85D688FD352F6319D")
     void dismissDialog() {
        {
            boolean varAA9215BBF1FF733067DEC864B8F4AC12_480725743 = (mWindow.isDestroyed());
        } 
        try 
        {
            mWindowManager.removeView(mDecor);
        } 
        finally 
        {
            {
                mActionMode.finish();
            } 
            mDecor = null;
            mWindow.closeAllPanels();
            onStop();
            mShowing = false;
            sendDismissMessage();
        } 
        
        
            
        
        
            
            
        
        
            
        
            
                
            
            
            
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.393 -0400", hash_original_method = "866BAFBEBC09B92D7388CA2F75E61BAD", hash_generated_method = "1EA55A4647FD1A132F53711D4AB8E09B")
    private void sendDismissMessage() {
        {
            Message.obtain(mDismissMessage).sendToTarget();
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.394 -0400", hash_original_method = "02D405BDD0443049D755381D9E715694", hash_generated_method = "FB6E6E412C3BA60E0F71F6858C0C0653")
    private void sendShowMessage() {
        {
            Message.obtain(mShowMessage).sendToTarget();
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.396 -0400", hash_original_method = "CD27A7CE58254212F040E7B7DA65BCA4", hash_generated_method = "6838EEEF28CAB6EF9F4A845156456478")
     void dispatchOnCreate(Bundle savedInstanceState) {
        {
            onCreate(savedInstanceState);
            mCreated = true;
        } 
        addTaint(savedInstanceState.getTaint());
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.397 -0400", hash_original_method = "B84ED822BC6011EB138B2F6F1D018FE5", hash_generated_method = "DE98DECCC817096DF1B839F626292181")
    protected void onCreate(Bundle savedInstanceState) {
        
        addTaint(savedInstanceState.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.398 -0400", hash_original_method = "1B4F9BFF1D832A07D0E1F41D0B16D2FF", hash_generated_method = "BE9AD01CB83E36F19DAEE7EFF770DFAE")
    protected void onStart() {
        
        mActionBar.setShowHideAnimationEnabled(true);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.398 -0400", hash_original_method = "28173EE669492C23D10F671D2D034693", hash_generated_method = "EFC4CEDE95009F9A2C76BCB60E4786BD")
    protected void onStop() {
        
        mActionBar.setShowHideAnimationEnabled(false);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.399 -0400", hash_original_method = "2D855197EA1046BD8EC8CA2E991844E1", hash_generated_method = "85FDE83B84A5396E27940AFB933323BA")
    public Bundle onSaveInstanceState() {
        
        Bundle varB4EAC82CA7396A68D541C85D26508E83_542494666 = null; 
        Bundle bundle = new Bundle();
        bundle.putBoolean(DIALOG_SHOWING_TAG, mShowing);
        {
            bundle.putBundle(DIALOG_HIERARCHY_TAG, mWindow.saveHierarchyState());
        } 
        varB4EAC82CA7396A68D541C85D26508E83_542494666 = bundle;
        varB4EAC82CA7396A68D541C85D26508E83_542494666.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_542494666;
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.400 -0400", hash_original_method = "EE5C9B4EF0AAEC8AB3AF49A30F3FD2D3", hash_generated_method = "63A963E62292755EDEFF51C9F2544A1E")
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        
        final Bundle dialogHierarchyState = savedInstanceState.getBundle(DIALOG_HIERARCHY_TAG);
        dispatchOnCreate(savedInstanceState);
        mWindow.restoreHierarchyState(dialogHierarchyState);
        {
            boolean varB08F34606D5FAE48568279D4B22B1AC4_1180929065 = (savedInstanceState.getBoolean(DIALOG_SHOWING_TAG));
            {
                show();
            } 
        } 
        addTaint(savedInstanceState.getTaint());
        
        
        
            
        
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.401 -0400", hash_original_method = "51ACB33F24592F8ED3FAFF9D96DEAF2A", hash_generated_method = "2D3B6EE8FB798A72EB48646F15EB4142")
    public Window getWindow() {
        Window varB4EAC82CA7396A68D541C85D26508E83_1247115004 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1247115004 = mWindow;
        varB4EAC82CA7396A68D541C85D26508E83_1247115004.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1247115004;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.402 -0400", hash_original_method = "44957F5326E5A87B91E438DCD3C71232", hash_generated_method = "7BFFBF733A35860BDAF03CA9F2930C4F")
    public View getCurrentFocus() {
        View varB4EAC82CA7396A68D541C85D26508E83_994782925 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_994782925 = mWindow != null ? mWindow.getCurrentFocus() : null;
        varB4EAC82CA7396A68D541C85D26508E83_994782925.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_994782925;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.404 -0400", hash_original_method = "FBC1E026CFF410D335B7C0F9A45B0829", hash_generated_method = "60CC81366B413B28E05E9E3F22D399DE")
    public View findViewById(int id) {
        View varB4EAC82CA7396A68D541C85D26508E83_641390192 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_641390192 = mWindow.findViewById(id);
        addTaint(id);
        varB4EAC82CA7396A68D541C85D26508E83_641390192.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_641390192;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.404 -0400", hash_original_method = "A6A8A3E553FD4B026D939E9AE3AC9985", hash_generated_method = "5BA5DE54653E468ED261AF17341460E4")
    public void setContentView(int layoutResID) {
        mWindow.setContentView(layoutResID);
        addTaint(layoutResID);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.407 -0400", hash_original_method = "64A976C0ECE03B8AD97B801012E7B71B", hash_generated_method = "83BB1502EB00C9A91C40A63992C5E5C7")
    public void setContentView(View view) {
        mWindow.setContentView(view);
        addTaint(view.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.408 -0400", hash_original_method = "21FC0CE0727282A96780C185A7B70535", hash_generated_method = "775EDF340CB355EB7BAEEA14FC205BED")
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        mWindow.setContentView(view, params);
        addTaint(view.getTaint());
        addTaint(params.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.409 -0400", hash_original_method = "54F8942E4EAEA6A93BE827863701CD23", hash_generated_method = "15B77E54CD19304DD85623BB759F93F1")
    public void addContentView(View view, ViewGroup.LayoutParams params) {
        mWindow.addContentView(view, params);
        addTaint(view.getTaint());
        addTaint(params.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.409 -0400", hash_original_method = "A94A4616451E43B03E2FA5DD3DFB9ED3", hash_generated_method = "18EC9867F86BB156A1BB912D7DD6716A")
    public void setTitle(CharSequence title) {
        mWindow.setTitle(title);
        mWindow.getAttributes().setTitle(title);
        addTaint(title.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.410 -0400", hash_original_method = "0D914ED2883864B655DBF2629252A595", hash_generated_method = "B8F1170F5CE57BA5A12A340C7E51CDBA")
    public void setTitle(int titleId) {
        setTitle(mContext.getText(titleId));
        addTaint(titleId);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.411 -0400", hash_original_method = "EB61104CC8357BEAF109072385D21C38", hash_generated_method = "31C0093A46353541C1184FDBEADA0823")
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        
        {
            event.startTracking();
        } 
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1562707089 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1562707089;
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.412 -0400", hash_original_method = "2A75FF2C44C4D96068DDAFC2643F0C8B", hash_generated_method = "7D7B32C8A7F968F96E1AFA61D86248A7")
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1432412779 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1432412779;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.413 -0400", hash_original_method = "CFFAC7119271281C27F3BEDCE8D82CC2", hash_generated_method = "4D841728EF17D92E718AD6F62F053F38")
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        
        {
            boolean var0632AF553088255946876F04AB1E8E7D_956329441 = (keyCode == KeyEvent.KEYCODE_BACK && event.isTracking()
                && !event.isCanceled());
            {
                onBackPressed();
            } 
        } 
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_314100893 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_314100893;
        
        
                
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.414 -0400", hash_original_method = "E364C67ED15F0AA31C6DCFFA6137C8C0", hash_generated_method = "DEC42C112BBE2CAC3AF5979BF17236EB")
    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        
        addTaint(keyCode);
        addTaint(repeatCount);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1052446242 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1052446242;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.415 -0400", hash_original_method = "EAEAA0DB8B83D24D321D98459F4FA29E", hash_generated_method = "3E313C8978C5A46580C6435094C7FE54")
    public void onBackPressed() {
        
        {
            cancel();
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.417 -0400", hash_original_method = "2ECF3E4914B4B3BE2238F799B7435A51", hash_generated_method = "554C0FD3012FA51BC2C384B02FBAFC10")
    public boolean onKeyShortcut(int keyCode, KeyEvent event) {
        
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1551994150 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1551994150;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.418 -0400", hash_original_method = "5A4B1024EA76F961E6155B7F9E2B0909", hash_generated_method = "D1B32029180D5CDA9FC91D068C9D0C1D")
    public boolean onTouchEvent(MotionEvent event) {
        
        {
            boolean var31C1B547289343DCAE6EBC7208A847F8_1469218934 = (mCancelable && mShowing && mWindow.shouldCloseOnTouch(mContext, event));
            {
                cancel();
            } 
        } 
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1904192056 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1904192056;
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.419 -0400", hash_original_method = "4A983FDB3FF481E2165B7D8D641CDD48", hash_generated_method = "BAADEDD1330ECB80DA86226A475B49E1")
    public boolean onTrackballEvent(MotionEvent event) {
        
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1113159960 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1113159960;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.420 -0400", hash_original_method = "0E59A005881F30C798F764BCF32D89A3", hash_generated_method = "BA5DD93E9D7DECD417A0D2B15F3AA495")
    public boolean onGenericMotionEvent(MotionEvent event) {
        
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1281036833 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1281036833;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.420 -0400", hash_original_method = "4EF468126ED8F0323D4288D03F894270", hash_generated_method = "6B6C48478E3743661D0D5A8E8111C607")
    public void onWindowAttributesChanged(WindowManager.LayoutParams params) {
        
        {
            mWindowManager.updateViewLayout(mDecor, params);
        } 
        addTaint(params.getTaint());
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.421 -0400", hash_original_method = "32D7339793DCE0D5AEFE6621981EC978", hash_generated_method = "15CE33052F85E41C1BB65E1E6B2C108A")
    public void onContentChanged() {
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.421 -0400", hash_original_method = "C7622FC561A602386C2112BC0445F7C6", hash_generated_method = "EEF2114A935228AD19BFEE6FAB48379F")
    public void onWindowFocusChanged(boolean hasFocus) {
        
        addTaint(hasFocus);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.422 -0400", hash_original_method = "D6E949EE9F0768F47016EEA4FC0347A8", hash_generated_method = "0E08FFA9282E502085CC6973CB60CDA1")
    public void onAttachedToWindow() {
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.422 -0400", hash_original_method = "E592299EBB4DE1D6696EB8C4009A9EF4", hash_generated_method = "1328510831112E7A424EFCA8583CA87C")
    public void onDetachedFromWindow() {
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.424 -0400", hash_original_method = "1435B67C8334D2AC8987004B54F10264", hash_generated_method = "09B1475D3C17816B4EC2A3D4A0E544E6")
    public boolean dispatchKeyEvent(KeyEvent event) {
        {
            boolean var119FC86DBD10D0451AA68681D2661AF8_2103181864 = ((mOnKeyListener != null) && (mOnKeyListener.onKey(this, event.getKeyCode(), event)));
        } 
        {
            boolean var524CC85D3B1F7496F0129E1D66C889FF_1421210752 = (mWindow.superDispatchKeyEvent(event));
        } 
        boolean var9A9ACA17DE81B47807106F3C8C61EFB2_2009614606 = (event.dispatch(this, mDecor != null
                ? mDecor.getKeyDispatcherState() : null, this)); 
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1414900944 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1414900944;
        
        
            
        
        
            
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.425 -0400", hash_original_method = "BA9D4031BD488C1D379B1950A362F8D4", hash_generated_method = "4FBCEF58E5B5902BF5F3F4A4B52D6793")
    public boolean dispatchKeyShortcutEvent(KeyEvent event) {
        {
            boolean var1506FC9A951093FEBE1E9D9D60B77FAA_1336596871 = (mWindow.superDispatchKeyShortcutEvent(event));
        } 
        boolean varB65319FC5255424F872A964CBDE1432E_535398356 = (onKeyShortcut(event.getKeyCode(), event));
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1823934466 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1823934466;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.427 -0400", hash_original_method = "D3052CDDAC0630315E0F5E7AF5478D0E", hash_generated_method = "FD256DEAF80A4ED13024CEEA9FC66C09")
    public boolean dispatchTouchEvent(MotionEvent ev) {
        {
            boolean var5240AC15FBF7E8C8943B586A077531B5_1669445923 = (mWindow.superDispatchTouchEvent(ev));
        } 
        boolean var985DA2294C2CD7796EE4EFA7F3FBE91B_316448939 = (onTouchEvent(ev));
        addTaint(ev.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1668581164 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1668581164;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.428 -0400", hash_original_method = "2B935C89EDDE71F28E7C978B3C9DCAB0", hash_generated_method = "AEC73ABF3F90C8598956E7EBA8C5BFEC")
    public boolean dispatchTrackballEvent(MotionEvent ev) {
        {
            boolean varF25A212D3CF06F711C8BBD649E0977F2_908062710 = (mWindow.superDispatchTrackballEvent(ev));
        } 
        boolean varE24895B72E913D801FFC5B9D9055D482_574135472 = (onTrackballEvent(ev));
        addTaint(ev.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_97202806 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_97202806;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.429 -0400", hash_original_method = "B6AB9C2BD67E148832650E309163688C", hash_generated_method = "6A8EEFF5F1AFB47DB9830E73E9FFA1B2")
    public boolean dispatchGenericMotionEvent(MotionEvent ev) {
        {
            boolean varC6CFD9FB7BF4B51FA19B29CFED05E764_851254927 = (mWindow.superDispatchGenericMotionEvent(ev));
        } 
        boolean var82ABE1E641E95D27D650D268E959F965_860424612 = (onGenericMotionEvent(ev));
        addTaint(ev.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1072550138 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1072550138;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.430 -0400", hash_original_method = "3CC377981D86463D050A06CF1F7ED782", hash_generated_method = "9CA71FABB804FBFB405ADD24BCA70EF4")
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        event.setClassName(getClass().getName());
        event.setPackageName(mContext.getPackageName());
        LayoutParams params = getWindow().getAttributes();
        boolean isFullScreen = (params.width == LayoutParams.MATCH_PARENT) &&
            (params.height == LayoutParams.MATCH_PARENT);
        event.setFullScreen(isFullScreen);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_989048551 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_989048551;
        
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.431 -0400", hash_original_method = "8FB2859FE43E0606E21921E291A18BDA", hash_generated_method = "D2A5C1AB21513413257BD9AF0E55D9D1")
    public View onCreatePanelView(int featureId) {
        
        View varB4EAC82CA7396A68D541C85D26508E83_2026954972 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2026954972 = null;
        addTaint(featureId);
        varB4EAC82CA7396A68D541C85D26508E83_2026954972.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2026954972;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.431 -0400", hash_original_method = "1B30E4AD9FCCEF2C81163B46B66D301C", hash_generated_method = "2D7C14DCEDA25DABA14A6A39A81BD060")
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        
        {
            boolean var3ADDFAB895A7216D8503161675C1D088_499882259 = (onCreateOptionsMenu(menu));
        } 
        addTaint(featureId);
        addTaint(menu.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1869623819 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1869623819;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.432 -0400", hash_original_method = "A95440A37102593BE255304F4188998E", hash_generated_method = "E5F84B372201CD29DE65F8F09F7C22FC")
    public boolean onPreparePanel(int featureId, View view, Menu menu) {
        
        {
            boolean goforit = onPrepareOptionsMenu(menu);
            boolean var7116118DD297E6C08BE1AD40992AA51A_1574985711 = (goforit && menu.hasVisibleItems());
        } 
        addTaint(featureId);
        addTaint(view.getTaint());
        addTaint(menu.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1617360325 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1617360325;
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.433 -0400", hash_original_method = "F5A72D2A4A42C0CE2781798802611276", hash_generated_method = "9A4FB3785B75DA396CCDB782123AB5CA")
    public boolean onMenuOpened(int featureId, Menu menu) {
        
        {
            mActionBar.dispatchMenuVisibilityChanged(true);
        } 
        addTaint(featureId);
        addTaint(menu.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2041942004 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2041942004;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.435 -0400", hash_original_method = "CDCEA93B87CB4399825B767626A61473", hash_generated_method = "E8DA7203A2E618FC50D8C1935DCBF227")
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        
        addTaint(featureId);
        addTaint(item.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1582393143 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1582393143;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.436 -0400", hash_original_method = "20C3110FD341FFE95CFF6A6C95609D00", hash_generated_method = "649371478EDA55D24504EB4DA0FA2064")
    public void onPanelClosed(int featureId, Menu menu) {
        
        {
            mActionBar.dispatchMenuVisibilityChanged(false);
        } 
        addTaint(featureId);
        addTaint(menu.getTaint());
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.438 -0400", hash_original_method = "F3CAA7B8E21AB403B530132B4E52A4EB", hash_generated_method = "5B427224E6F03C8F95A872BACEE285B9")
    public boolean onCreateOptionsMenu(Menu menu) {
        
        addTaint(menu.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_707125651 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_707125651;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.439 -0400", hash_original_method = "BF0F08B18C75FC62D01E0D6DB107696E", hash_generated_method = "99B2F53E20C6CC96724B428265E60325")
    public boolean onPrepareOptionsMenu(Menu menu) {
        
        addTaint(menu.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_25262015 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_25262015;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.439 -0400", hash_original_method = "8EF9A1828892EFEBF4B93362A866125C", hash_generated_method = "2A2E5D35E0987843EAEF5AFE897AEBA7")
    public boolean onOptionsItemSelected(MenuItem item) {
        
        addTaint(item.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1771234351 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1771234351;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.440 -0400", hash_original_method = "D53E4189B6E7F0EC0F9883E9844F2140", hash_generated_method = "CC9F879215C8D6911F3F43FE45124EF9")
    public void onOptionsMenuClosed(Menu menu) {
        
        addTaint(menu.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.440 -0400", hash_original_method = "756759165F6AB2C8C6E469E63BE14186", hash_generated_method = "8F36C449192E9A4FC8F578B78BE7C244")
    public void openOptionsMenu() {
        mWindow.openPanel(Window.FEATURE_OPTIONS_PANEL, null);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.441 -0400", hash_original_method = "D12ED1735BBB9BCDCD831C99F03640D7", hash_generated_method = "249BD0BDCB652EF31D4B735086D0BDEC")
    public void closeOptionsMenu() {
        mWindow.closePanel(Window.FEATURE_OPTIONS_PANEL);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.441 -0400", hash_original_method = "319389EBA801B290FB41D02473EB2E9E", hash_generated_method = "E3CB03CA5E4EB5916215E567B4276E95")
    public void invalidateOptionsMenu() {
        mWindow.invalidatePanelMenu(Window.FEATURE_OPTIONS_PANEL);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.442 -0400", hash_original_method = "85F2A519B2781A30F4BC68DB47459C98", hash_generated_method = "170D9A5A5BFA1A654CA19943D4D0F496")
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        
        addTaint(menu.getTaint());
        addTaint(v.getTaint());
        addTaint(menuInfo.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.442 -0400", hash_original_method = "1A123249F7C2C892EA53E2F44D60C1FB", hash_generated_method = "0FEECD9EF1102B65D35844FDFD151864")
    public void registerForContextMenu(View view) {
        
        view.setOnCreateContextMenuListener(this);
        addTaint(view.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.443 -0400", hash_original_method = "6A7E2B106BB1CEE7C3B668A773DE5A5B", hash_generated_method = "344591114B98358744F7FCF1C426D7AD")
    public void unregisterForContextMenu(View view) {
        view.setOnCreateContextMenuListener(null);
        addTaint(view.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.444 -0400", hash_original_method = "D1451DBD5DFD14FAE397660897192E3C", hash_generated_method = "0E259D70C84DA1F0D8EA55F14095AA14")
    public void openContextMenu(View view) {
        view.showContextMenu();
        addTaint(view.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.445 -0400", hash_original_method = "801D77DFDCCE5570587CA592634E3D3B", hash_generated_method = "4895A6DD8639162624E5DE11476F5063")
    public boolean onContextItemSelected(MenuItem item) {
        
        addTaint(item.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1766458666 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1766458666;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.446 -0400", hash_original_method = "5C6F377B774E414E6D9422BBC7AAE81F", hash_generated_method = "F6A83BFE417F19EC2EE2F1DD7A9E9351")
    public void onContextMenuClosed(Menu menu) {
        
        addTaint(menu.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.448 -0400", hash_original_method = "38790ED2FB6D0EF1B7954716C7615F0D", hash_generated_method = "F6B112404BF0ACED067D782012BD514F")
    public boolean onSearchRequested() {
        
        final SearchManager searchManager = (SearchManager) mContext
                .getSystemService(Context.SEARCH_SERVICE);
        final ComponentName appName = getAssociatedActivity();
        {
            boolean var39077EF7EA373069B451847B267FD676_2020547250 = (appName != null && searchManager.getSearchableInfo(appName) != null);
            {
                searchManager.startSearch(null, false, appName, null, false);
                dismiss();
            } 
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1761840934 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1761840934;
        
        
                
        
        
            
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.449 -0400", hash_original_method = "5D1C131301342FA877A860064E23A1A6", hash_generated_method = "6B0953CAB46962DEEE690BE016F954D1")
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        
        ActionMode varB4EAC82CA7396A68D541C85D26508E83_1042599752 = null; 
        ActionMode varB4EAC82CA7396A68D541C85D26508E83_1276795656 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1042599752 = mActionBar.startActionMode(callback);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1276795656 = null;
        addTaint(callback.getTaint());
        ActionMode varA7E53CE21691AB073D9660D615818899_539774465; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_539774465 = varB4EAC82CA7396A68D541C85D26508E83_1042599752;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_539774465 = varB4EAC82CA7396A68D541C85D26508E83_1276795656;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_539774465.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_539774465;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.450 -0400", hash_original_method = "00C0B67E273850713F0D88B8DE976F73", hash_generated_method = "CC0EA6E92777768F9F821B7C1ECE81BA")
    public void onActionModeStarted(ActionMode mode) {
        
        mActionMode = mode;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.451 -0400", hash_original_method = "9FD315390CEABDE5B2497E2EE78C905A", hash_generated_method = "267373F481F3A04D55725F51391EFFC9")
    public void onActionModeFinished(ActionMode mode) {
        
        {
            mActionMode = null;
        } 
        addTaint(mode.getTaint());
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.452 -0400", hash_original_method = "2C0F3C4A58B092DBFC10EA72C5A7ED76", hash_generated_method = "0F9CBC496C7C0F5148E4DBCC6C89BA27")
    private ComponentName getAssociatedActivity() {
        ComponentName varB4EAC82CA7396A68D541C85D26508E83_1465013391 = null; 
        Activity activity = mOwnerActivity;
        Context context = getContext();
        {
            {
                activity = (Activity) context;
            } 
            {
                context = (context instanceof ContextWrapper) ?
                        ((ContextWrapper) context).getBaseContext() : 
                        null;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1465013391 = activity == null ? null : activity.getComponentName();
        varB4EAC82CA7396A68D541C85D26508E83_1465013391.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1465013391;
        
        
        
        
            
                
            
                
                        
                        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.452 -0400", hash_original_method = "18F720E0A5C2702D89E6608BD6B708CA", hash_generated_method = "3C2EA7DA6ECB94A09F7FB8C9056E4114")
    public void takeKeyEvents(boolean get) {
        mWindow.takeKeyEvents(get);
        addTaint(get);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.453 -0400", hash_original_method = "3CDF417FCD4F33EAE6CFCF0FB6D583A8", hash_generated_method = "70AD9333853CD5425A08D591E25FADCF")
    public final boolean requestWindowFeature(int featureId) {
        boolean varB82514052F40771017139C27F50D7D45_281048796 = (getWindow().requestFeature(featureId));
        addTaint(featureId);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1502724875 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1502724875;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.454 -0400", hash_original_method = "E7AFD534CB1DF8060614ED36111B2407", hash_generated_method = "1D84D45038FD5866F8926E34F140C5A2")
    public final void setFeatureDrawableResource(int featureId, int resId) {
        getWindow().setFeatureDrawableResource(featureId, resId);
        addTaint(featureId);
        addTaint(resId);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.454 -0400", hash_original_method = "2E53659D6309BF8C5C8E8AD82BD6A577", hash_generated_method = "2B27B06D57220A2D7BDBB2E34E6E392C")
    public final void setFeatureDrawableUri(int featureId, Uri uri) {
        getWindow().setFeatureDrawableUri(featureId, uri);
        addTaint(featureId);
        addTaint(uri.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.455 -0400", hash_original_method = "D3FA0A5870730A6F3C959B16FC004BCD", hash_generated_method = "F557D4B7A04B56974C87A9013515B72F")
    public final void setFeatureDrawable(int featureId, Drawable drawable) {
        getWindow().setFeatureDrawable(featureId, drawable);
        addTaint(featureId);
        addTaint(drawable.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.456 -0400", hash_original_method = "4D2A81FF8C2C83F47460DEB3120C04CB", hash_generated_method = "04310BD6B9B4218E4C6AF4E9D6650F61")
    public final void setFeatureDrawableAlpha(int featureId, int alpha) {
        getWindow().setFeatureDrawableAlpha(featureId, alpha);
        addTaint(featureId);
        addTaint(alpha);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.458 -0400", hash_original_method = "2F200E491A9F2CDC38C392035D21ED48", hash_generated_method = "D16237912EDAFEA5B27510467055F83B")
    public LayoutInflater getLayoutInflater() {
        LayoutInflater varB4EAC82CA7396A68D541C85D26508E83_721905880 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_721905880 = getWindow().getLayoutInflater();
        varB4EAC82CA7396A68D541C85D26508E83_721905880.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_721905880;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.459 -0400", hash_original_method = "C80CDCB014C953B0801E95FEB1706C5F", hash_generated_method = "99A166D313D0204F9E1B3BB77DF8F04A")
    public void setCancelable(boolean flag) {
        mCancelable = flag;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.459 -0400", hash_original_method = "BD7DFECDBEA3F81451B9076CEFC17564", hash_generated_method = "E597A25CAB63B5D5D20442EDE74A5230")
    public void setCanceledOnTouchOutside(boolean cancel) {
        {
            mCancelable = true;
        } 
        mWindow.setCloseOnTouchOutside(cancel);
        addTaint(cancel);
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.460 -0400", hash_original_method = "4DD1D51C0E16D279CD855F2D66BA21A6", hash_generated_method = "04D5A6A3EA2A41A883B809CB24D2E65F")
    public void cancel() {
        {
            mCanceled = true;
            Message.obtain(mCancelMessage).sendToTarget();
        } 
        dismiss();
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.460 -0400", hash_original_method = "B6A3C715E726D4D77D298D569C13057A", hash_generated_method = "7A261DB80575EF8DC8F845C992F9F763")
    public void setOnCancelListener(final OnCancelListener listener) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "OnCancelListener is already taken by "
                    + mCancelAndDismissTaken + " and can not be replaced.");
        } 
        {
            mCancelMessage = mListenersHandler.obtainMessage(CANCEL, listener);
        } 
        {
            mCancelMessage = null;
        } 
        
        
            
                    
                    
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.461 -0400", hash_original_method = "774019D9ADE46FB9924B78D145C17F36", hash_generated_method = "3D496AF9B1B4D7260FDDA232E220A62F")
    public void setCancelMessage(final Message msg) {
        mCancelMessage = msg;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.461 -0400", hash_original_method = "464A84E289A7DD535A8EA3034BC5D33F", hash_generated_method = "A0B01C16C706719BDDBBD3355AEA722B")
    public void setOnDismissListener(final OnDismissListener listener) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "OnDismissListener is already taken by "
                    + mCancelAndDismissTaken + " and can not be replaced.");
        } 
        {
            mDismissMessage = mListenersHandler.obtainMessage(DISMISS, listener);
        } 
        {
            mDismissMessage = null;
        } 
        
        
            
                    
                    
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.462 -0400", hash_original_method = "0B69163DC80B46ACDA2709DE4C77DC2F", hash_generated_method = "1FB93D4E451DF60586CA95B02D8839CF")
    public void setOnShowListener(OnShowListener listener) {
        {
            mShowMessage = mListenersHandler.obtainMessage(SHOW, listener);
        } 
        {
            mShowMessage = null;
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.462 -0400", hash_original_method = "2BD742B46509FC81ABA0DF4EC8F37AEC", hash_generated_method = "86E89A398CB75A38D126DF12BF88B627")
    public void setDismissMessage(final Message msg) {
        mDismissMessage = msg;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.463 -0400", hash_original_method = "4322D13EDCAAC15D5143567F42FC68A2", hash_generated_method = "16584DD95D50EDE665CF062E3298531C")
    public boolean takeCancelAndDismissListeners(String msg, final OnCancelListener cancel,
            final OnDismissListener dismiss) {
        {
            mCancelAndDismissTaken = null;
        } 
        setOnCancelListener(cancel);
        setOnDismissListener(dismiss);
        mCancelAndDismissTaken = msg;
        addTaint(cancel.getTaint());
        addTaint(dismiss.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_188632570 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_188632570;
        
        
            
        
            
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.463 -0400", hash_original_method = "70729F29EB37CCBEC739A5986214C32F", hash_generated_method = "2764BD226534A1A95BF3BECEF1136ABC")
    public final void setVolumeControlStream(int streamType) {
        getWindow().setVolumeControlStream(streamType);
        addTaint(streamType);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.464 -0400", hash_original_method = "03A841DC7655848901B3CE2C14084AAE", hash_generated_method = "55A524AFB33FA561AF09B55712A0F84A")
    public final int getVolumeControlStream() {
        int var10019DD6073F3F6675C482019A78518D_301198917 = (getWindow().getVolumeControlStream());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1624949681 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1624949681;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.464 -0400", hash_original_method = "A9C3EE1B48BA32717B6024C41DF4E1F6", hash_generated_method = "EEA474A83FE4C7A6A402FA07BCAB4982")
    public void setOnKeyListener(final OnKeyListener onKeyListener) {
        mOnKeyListener = onKeyListener;
        
        
    }

    
    private static final class ListenersHandler extends Handler {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.465 -0400", hash_original_field = "58806F2D99FD4DF33CF42E0C232738D7", hash_generated_field = "436872B12AE04B06D18A845CB0719BC2")

        private WeakReference<DialogInterface> mDialog;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.465 -0400", hash_original_method = "92DAC0D6E122198BF26AB724936B6539", hash_generated_method = "DF7B51E0F2F5846DF16713C1A26DD53E")
        public  ListenersHandler(Dialog dialog) {
            mDialog = new WeakReference<DialogInterface>(dialog);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.467 -0400", hash_original_method = "0AC2BA822DE6E333F562D01CFB6CE49A", hash_generated_method = "2828C4C27220D31C29AC9562F6AB3134")
        @Override
        public void handleMessage(Message msg) {
            
            ((OnDismissListener) msg.obj).onDismiss(mDialog.get());
            
            
            ((OnCancelListener) msg.obj).onCancel(mDialog.get());
            
            
            ((OnShowListener) msg.obj).onShow(mDialog.get());
            
            addTaint(msg.getTaint());
            
            
                
                    
                    
                
                    
                    
                
                    
                    
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.467 -0400", hash_original_field = "C8104907E2C15136387E1FF354F2E289", hash_generated_field = "EFC22AB7F88AB7E35035F4D3FC081168")

    private static final String TAG = "Dialog";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.467 -0400", hash_original_field = "50C73827946947CD861F4B61AEA55633", hash_generated_field = "214E1AE6D64D144B8D5F29D5AF8A5A07")

    private static final int DISMISS = 0x43;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.467 -0400", hash_original_field = "9BA42FA53C623D78B24D53CDAE971C70", hash_generated_field = "5FAD2102A44A31CE5E01758518DF50F5")

    private static final int CANCEL = 0x44;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.467 -0400", hash_original_field = "7A4F616BE8122BA90E30406327492376", hash_generated_field = "12A0D52245758771AF8948C47070B9C1")

    private static final int SHOW = 0x45;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.467 -0400", hash_original_field = "9D0239578906B64ECBA46B3D33341F50", hash_generated_field = "A896FC35ACED801674ADC56E7BBC39CB")

    private static final String DIALOG_SHOWING_TAG = "android:dialogShowing";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.467 -0400", hash_original_field = "9B9870DF294A5143109BE6CEAFCC0E45", hash_generated_field = "7504B7324AA77CD343365D491A1E51D5")

    private static final String DIALOG_HIERARCHY_TAG = "android:dialogHierarchy";
}

