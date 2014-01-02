package android.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
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






public class Dialog implements DialogInterface, Window.Callback, KeyEvent.Callback, OnCreateContextMenuListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.991 -0500", hash_original_field = "086DFBC7BC837F5BACC9A967FDC19303", hash_generated_field = "EFC22AB7F88AB7E35035F4D3FC081168")

    private static final String TAG = "Dialog";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.030 -0500", hash_original_field = "80638025183CEDD46CF5FDAB60F3AEC2", hash_generated_field = "214E1AE6D64D144B8D5F29D5AF8A5A07")


    private static final int DISMISS = 0x43;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.033 -0500", hash_original_field = "8169580360B404703429FA3DEEB53EF2", hash_generated_field = "5FAD2102A44A31CE5E01758518DF50F5")

    private static final int CANCEL = 0x44;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.035 -0500", hash_original_field = "645E69F0567B572C759673F9A57A654D", hash_generated_field = "12A0D52245758771AF8948C47070B9C1")

    private static final int SHOW = 0x45;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.093 -0500", hash_original_field = "30633E1CCD3D5789E9E5D2CE7F996EE0", hash_generated_field = "A896FC35ACED801674ADC56E7BBC39CB")


    private static final String DIALOG_SHOWING_TAG = "android:dialogShowing";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.096 -0500", hash_original_field = "BB82A6D34648882F9995CF3123B9C136", hash_generated_field = "7504B7324AA77CD343365D491A1E51D5")

    private static final String DIALOG_HIERARCHY_TAG = "android:dialogHierarchy";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.993 -0500", hash_original_field = "445EDBA21410FC6FABC0283661BAD211", hash_generated_field = "8ACEFA51F1C212AC94944686D7E3BDFC")

    private Activity mOwnerActivity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.995 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "B997E37019471EC8FC5B98148C7A8AD7")

    
     Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.997 -0500", hash_original_field = "83A062836C11DD52DC32F4325712F233", hash_generated_field = "83A062836C11DD52DC32F4325712F233")

     WindowManager mWindowManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.999 -0500", hash_original_field = "C6B08D42C8EA2CB56500460CAF662F4C", hash_generated_field = "C6B08D42C8EA2CB56500460CAF662F4C")

    Window mWindow;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.001 -0500", hash_original_field = "B4A10D2FE94FCA7877DCD1F8197DA38F", hash_generated_field = "B4A10D2FE94FCA7877DCD1F8197DA38F")

    View mDecor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.003 -0500", hash_original_field = "FE6429732ED1A6877CD2B8C433775852", hash_generated_field = "7F8EF508978F38B8BCEC28D592DBFC22")

    private ActionBarImpl mActionBar;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.005 -0500", hash_original_field = "5D88854104F09F0EBF08FB1F80A11401", hash_generated_field = "6123942D1383A17F765E6BC984B8086E")

    protected boolean mCancelable = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.008 -0500", hash_original_field = "A42DE90960EF4709AEA396BA4E6C4C4D", hash_generated_field = "B13EDAE25BF4DFF139CD5FAE4D2A0A25")


    private String mCancelAndDismissTaken;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.010 -0500", hash_original_field = "A7C0594296F9C7AF2F2199F05E3670D8", hash_generated_field = "76C74178C09C090FAEDAAD0E8B0CF7A0")

    private Message mCancelMessage;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.012 -0500", hash_original_field = "188DA18F200F801BE3F0E52E671C4079", hash_generated_field = "E192DE29CF3B86E1D4D51306D6613B44")

    private Message mDismissMessage;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.014 -0500", hash_original_field = "11C1B7B784B453396B68441DB450A561", hash_generated_field = "9DF7AF46D4C4365744738EB8C5D01451")

    private Message mShowMessage;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.016 -0500", hash_original_field = "015168FBB2FF4C181AE52DE804ABA4A4", hash_generated_field = "E9EAFA3F5F183CD7232E888DAC035728")


    private OnKeyListener mOnKeyListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.019 -0500", hash_original_field = "A8D9F85A3B5CDEF086D3B2DF626FB110", hash_generated_field = "AE31AA5AE388883F7650182C0E3C7933")


    private boolean mCreated = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.021 -0500", hash_original_field = "7ABFB7C6D38D9AB108E3B918C41F97E6", hash_generated_field = "524E990B3B93C6331366CC3FFD800C87")

    private boolean mShowing = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.023 -0500", hash_original_field = "88E0F93494857DA513393E07912CD8CE", hash_generated_field = "67D6DA73468F2D6E84B945FD38F1CC1D")

    private boolean mCanceled = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.025 -0500", hash_original_field = "348A8677E1E3F1084FC4FBEC2A3E1F5D", hash_generated_field = "A94051227A36AE91A6CE3B31BF1DD3E6")


    private  Thread mUiThread;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.028 -0500", hash_original_field = "AD9C3D1E48D73BF1547D53C4C62401B2", hash_generated_field = "2C33E5889A8CDA732A297DBE7101DB89")

    private final Handler mHandler = new Handler();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.037 -0500", hash_original_field = "BF0D726FB6FA34DA0D2571FA4203078C", hash_generated_field = "BE6770D46FDA6621A2256CC938B90138")


    private Handler mListenersHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.039 -0500", hash_original_field = "B7BD8B12490FD42C33E24469AF6B48C1", hash_generated_field = "941205D807AC4DF9704A65BDAF4756EC")


    private ActionMode mActionMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.380 -0400", hash_original_field = "90764B7AE877EFFD33D3124ADF85860E", hash_generated_field = "8FA22581A256DB33942DF76F392B65DC")

    private final Runnable mDismissAction = new Runnable() {        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.380 -0400", hash_original_method = "BEE19A9C5B7D04B78955A3FD8170F1CA", hash_generated_method = "4B98EED19700DEC05BCE304A452DAE0F")
        public void run() {
            dismissDialog();
            
            
        }

        
};

    /**
     * Create a Dialog window that uses the default dialog frame style.
     * 
     * @param context The Context the Dialog is to run it.  In particular, it
     *                uses the window manager and theme in this context to
     *                present its UI.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.047 -0500", hash_original_method = "BC9D2F22217346E354BF7BFC78A2D0C2", hash_generated_method = "DDBAE1C6053AAADDEEB81EF120BBEB14")
    
public Dialog(Context context) {
        this(context, 0, true);
    }

    /**
     * Create a Dialog window that uses a custom dialog style.
     * 
     * @param context The Context in which the Dialog should run. In particular, it
     *                uses the window manager and theme from this context to
     *                present its UI.
     * @param theme A style resource describing the theme to use for the 
     * window. See <a href="{@docRoot}guide/topics/resources/available-resources.html#stylesandthemes">Style 
     * and Theme Resources</a> for more information about defining and using 
     * styles.  This theme is applied on top of the current theme in 
     * <var>context</var>.  If 0, the default dialog theme will be used.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.049 -0500", hash_original_method = "E8683E6729C8449A45D83189604DFAE9", hash_generated_method = "98259AAF2CBADD065607919899437452")
    
public Dialog(Context context, int theme) {
        this(context, theme, true);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.052 -0500", hash_original_method = "C6D5E1D2CF37954F320E3261297EC417", hash_generated_method = "C6D5E1D2CF37954F320E3261297EC417")
    
Dialog(Context context, int theme, boolean createContextWrapper) {
        if (theme == 0) {
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
    
    /**
     * @deprecated
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.055 -0500", hash_original_method = "845C16E53E1BE45A2BA7FF67CD257C6C", hash_generated_method = "04D95BF1921307A71C49AA44DAF21A88")
    
@Deprecated
    protected Dialog(Context context, boolean cancelable,
            Message cancelCallback) {
        this(context);
        mCancelable = cancelable;
        mCancelMessage = cancelCallback;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.057 -0500", hash_original_method = "C9ADA56967BDAFB742C2181BE637639A", hash_generated_method = "97FBC2BE4A86EB17DA33D5BA2C676D09")
    
protected Dialog(Context context, boolean cancelable,
            OnCancelListener cancelListener) {
        this(context);
        mCancelable = cancelable;
        setOnCancelListener(cancelListener);
    }

    /**
     * Retrieve the Context this Dialog is running in.
     * 
     * @return Context The Context used by the Dialog.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.059 -0500", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "DDB999668EFCAD36DFA58D5D665B592E")
    
public final Context getContext() {
        return mContext;
    }

    /**
     * Retrieve the {@link ActionBar} attached to this dialog, if present.
     *
     * @return The ActionBar attached to the dialog or null if no ActionBar is present.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.061 -0500", hash_original_method = "624FE63EC935EE8F7C5CD37954EA0AEA", hash_generated_method = "33D66BF8FD53038F6F7DC0896F5CE635")
    
public ActionBar getActionBar() {
        return mActionBar;
    }

    /**
     * Sets the Activity that owns this dialog. An example use: This Dialog will
     * use the suggested volume control stream of the Activity.
     * 
     * @param activity The Activity that owns this dialog.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.064 -0500", hash_original_method = "AEEF4868262FBFB181A318E6FDCF1973", hash_generated_method = "0944C07C997A59B39D804809DA1CAB6E")
    
public final void setOwnerActivity(Activity activity) {
        mOwnerActivity = activity;
        
        getWindow().setVolumeControlStream(mOwnerActivity.getVolumeControlStream());
    }

    /**
     * Returns the Activity that owns this Dialog. For example, if
     * {@link Activity#showDialog(int)} is used to show this Dialog, that
     * Activity will be the owner (by default). Depending on how this dialog was
     * created, this may return null.
     * 
     * @return The Activity that owns this Dialog.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.066 -0500", hash_original_method = "D833D4731703AD671D7AED3C45CAE756", hash_generated_method = "7B9A6CA941CAE2C4730333AA7BFF9AEB")
    
public final Activity getOwnerActivity() {
        return mOwnerActivity;
    }
    
    /**
     * @return Whether the dialog is currently showing.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.069 -0500", hash_original_method = "F21458EB6FE36A924A49B40493E1F9F8", hash_generated_method = "C14BB39171429278E5F75B94242D6C8F")
    
public boolean isShowing() {
        return mShowing;
    }

    /**
     * Start the dialog and display it on screen.  The window is placed in the
     * application layer and opaque.  Note that you should not override this
     * method to do initialization when the dialog is shown, instead implement
     * that in {@link #onStart}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.072 -0500", hash_original_method = "079FA2E5CA600A12F7067E75E853F614", hash_generated_method = "11E4DB30ED79C6CDA041FA909FA3550C")
    
public void show() {
        if (mShowing) {
            if (mDecor != null) {
                if (mWindow.hasFeature(Window.FEATURE_ACTION_BAR)) {
                    mWindow.invalidatePanelMenu(Window.FEATURE_ACTION_BAR);
                }
                mDecor.setVisibility(View.VISIBLE);
            }
            return;
        }

        mCanceled = false;
        
        if (!mCreated) {
            dispatchOnCreate(null);
        }

        onStart();
        mDecor = mWindow.getDecorView();

        if (mActionBar == null && mWindow.hasFeature(Window.FEATURE_ACTION_BAR)) {
            mActionBar = new ActionBarImpl(this);
        }

        WindowManager.LayoutParams l = mWindow.getAttributes();
        if ((l.softInputMode
                & WindowManager.LayoutParams.SOFT_INPUT_IS_FORWARD_NAVIGATION) == 0) {
            WindowManager.LayoutParams nl = new WindowManager.LayoutParams();
            nl.copyFrom(l);
            nl.softInputMode |=
                    WindowManager.LayoutParams.SOFT_INPUT_IS_FORWARD_NAVIGATION;
            l = nl;
        }

        try {
            mWindowManager.addView(mDecor, l);
            mShowing = true;
    
            sendShowMessage();
        } finally {
        }
    }
    
    /**
     * Hide the dialog, but do not dismiss it.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.074 -0500", hash_original_method = "4A0CDBB7EA97DC376E25E0EE43387CF4", hash_generated_method = "2974FADFA5947469B520D265DBDEB530")
    
public void hide() {
        if (mDecor != null) {
            mDecor.setVisibility(View.GONE);
        }
    }

    /**
     * Dismiss this dialog, removing it from the screen. This method can be
     * invoked safely from any thread.  Note that you should not override this
     * method to do cleanup when the dialog is dismissed, instead implement
     * that in {@link #onStop}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.076 -0500", hash_original_method = "33443011198828BD072B057DA719765A", hash_generated_method = "08FD4653A4C402E0581A74D32401A496")
    
public void dismiss() {
        if (Thread.currentThread() != mUiThread) {
            mHandler.post(mDismissAction);
        } else {
            mHandler.removeCallbacks(mDismissAction);
            mDismissAction.run();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.078 -0500", hash_original_method = "4ECC78F105BA2AD2FA21893BA556AFFD", hash_generated_method = "4ECC78F105BA2AD2FA21893BA556AFFD")
    
void dismissDialog() {
        if (mDecor == null || !mShowing) {
            return;
        }

        if (mWindow.isDestroyed()) {
            Log.e(TAG, "Tried to dismissDialog() but the Dialog's window was already destroyed!");
            return;
        }

        try {
            mWindowManager.removeView(mDecor);
        } finally {
            if (mActionMode != null) {
                mActionMode.finish();
            }
            mDecor = null;
            mWindow.closeAllPanels();
            onStop();
            mShowing = false;
            
            sendDismissMessage();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.081 -0500", hash_original_method = "866BAFBEBC09B92D7388CA2F75E61BAD", hash_generated_method = "FD5789CE329610B36688F6BABE62CDDC")
    
private void sendDismissMessage() {
        if (mDismissMessage != null) {
            // Obtain a new message so this dialog can be re-used
            Message.obtain(mDismissMessage).sendToTarget();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.083 -0500", hash_original_method = "02D405BDD0443049D755381D9E715694", hash_generated_method = "96649B57B7C1C3DD4F8E7E2163C9158E")
    
private void sendShowMessage() {
        if (mShowMessage != null) {
            // Obtain a new message so this dialog can be re-used
            Message.obtain(mShowMessage).sendToTarget();
        }
    }

    // internal method to make sure mcreated is set properly without requiring
    // users to call through to super in onCreate
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.084 -0500", hash_original_method = "CD27A7CE58254212F040E7B7DA65BCA4", hash_generated_method = "CD27A7CE58254212F040E7B7DA65BCA4")
    
void dispatchOnCreate(Bundle savedInstanceState) {
        if (!mCreated) {
            onCreate(savedInstanceState);
            mCreated = true;
        }
    }

    /**
     * Similar to {@link Activity#onCreate}, you should initialize your dialog
     * in this method, including calling {@link #setContentView}.
     * @param savedInstanceState If this dialog is being reinitalized after a
     *     the hosting activity was previously shut down, holds the result from
     *     the most recent call to {@link #onSaveInstanceState}, or null if this
     *     is the first time.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.086 -0500", hash_original_method = "B84ED822BC6011EB138B2F6F1D018FE5", hash_generated_method = "77A2481F58483133CF549B870D7F844F")
    
protected void onCreate(Bundle savedInstanceState) {
    }

    /**
     * Called when the dialog is starting.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.088 -0500", hash_original_method = "1B4F9BFF1D832A07D0E1F41D0B16D2FF", hash_generated_method = "5D26BC6CD7492E3645E935033A475185")
    
protected void onStart() {
        if (mActionBar != null) mActionBar.setShowHideAnimationEnabled(true);
    }

    /**
     * Called to tell you that you're stopping.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.091 -0500", hash_original_method = "28173EE669492C23D10F671D2D034693", hash_generated_method = "67FB30F07373DAF067C9EA6C2F3D55DD")
    
protected void onStop() {
        if (mActionBar != null) mActionBar.setShowHideAnimationEnabled(false);
    }

    /**
     * Saves the state of the dialog into a bundle.
     *
     * The default implementation saves the state of its view hierarchy, so you'll
     * likely want to call through to super if you override this to save additional
     * state.
     * @return A bundle with the state of the dialog.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.098 -0500", hash_original_method = "2D855197EA1046BD8EC8CA2E991844E1", hash_generated_method = "D37FA2CB6FD8B56BC1A93315A28DB0DC")
    
public Bundle onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putBoolean(DIALOG_SHOWING_TAG, mShowing);
        if (mCreated) {
            bundle.putBundle(DIALOG_HIERARCHY_TAG, mWindow.saveHierarchyState());
        }
        return bundle;
    }

    /**
     * Restore the state of the dialog from a previously saved bundle.
     *
     * The default implementation restores the state of the dialog's view
     * hierarchy that was saved in the default implementation of {@link #onSaveInstanceState()},
     * so be sure to call through to super when overriding unless you want to
     * do all restoring of state yourself.
     * @param savedInstanceState The state of the dialog previously saved by
     *     {@link #onSaveInstanceState()}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.100 -0500", hash_original_method = "EE5C9B4EF0AAEC8AB3AF49A30F3FD2D3", hash_generated_method = "BEE22EB7A0FCFB296E957648A81A3257")
    
public void onRestoreInstanceState(Bundle savedInstanceState) {
        final Bundle dialogHierarchyState = savedInstanceState.getBundle(DIALOG_HIERARCHY_TAG);
        if (dialogHierarchyState == null) {
            // dialog has never been shown, or onCreated, nothing to restore.
            return;
        }
        dispatchOnCreate(savedInstanceState);
        mWindow.restoreHierarchyState(dialogHierarchyState);
        if (savedInstanceState.getBoolean(DIALOG_SHOWING_TAG)) {
            show();
        }
    }

    /**
     * Retrieve the current Window for the activity.  This can be used to
     * directly access parts of the Window API that are not available
     * through Activity/Screen.
     * 
     * @return Window The current window, or null if the activity is not
     *         visual.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.103 -0500", hash_original_method = "51ACB33F24592F8ED3FAFF9D96DEAF2A", hash_generated_method = "331876D44C3CE896E388411794B32F6E")
    
public Window getWindow() {
        return mWindow;
    }

    /**
     * Call {@link android.view.Window#getCurrentFocus} on the
     * Window if this Activity to return the currently focused view.
     * 
     * @return View The current View with focus or null.
     * 
     * @see #getWindow
     * @see android.view.Window#getCurrentFocus
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.105 -0500", hash_original_method = "44957F5326E5A87B91E438DCD3C71232", hash_generated_method = "09E1957E53D3994EE33E68D897FC3623")
    
public View getCurrentFocus() {
        return mWindow != null ? mWindow.getCurrentFocus() : null;
    }

    /**
     * Finds a view that was identified by the id attribute from the XML that
     * was processed in {@link #onStart}.
     *
     * @param id the identifier of the view to find
     * @return The view if found or null otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.108 -0500", hash_original_method = "FBC1E026CFF410D335B7C0F9A45B0829", hash_generated_method = "DF935DC9559B6B34CF7AC16F65849BAE")
    
public View findViewById(int id) {
        return mWindow.findViewById(id);
    }

    /**
     * Set the screen content from a layout resource.  The resource will be
     * inflated, adding all top-level views to the screen.
     * 
     * @param layoutResID Resource ID to be inflated.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.110 -0500", hash_original_method = "A6A8A3E553FD4B026D939E9AE3AC9985", hash_generated_method = "34F06CEA5B574E84E31D5E5187CA0961")
    
public void setContentView(int layoutResID) {
        mWindow.setContentView(layoutResID);
    }

    /**
     * Set the screen content to an explicit view.  This view is placed
     * directly into the screen's view hierarchy.  It can itself be a complex
     * view hierarhcy.
     * 
     * @param view The desired content to display.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.112 -0500", hash_original_method = "64A976C0ECE03B8AD97B801012E7B71B", hash_generated_method = "8505878B7681F77E00CE8368877013C5")
    
public void setContentView(View view) {
        mWindow.setContentView(view);
    }

    /**
     * Set the screen content to an explicit view.  This view is placed
     * directly into the screen's view hierarchy.  It can itself be a complex
     * view hierarhcy.
     * 
     * @param view The desired content to display.
     * @param params Layout parameters for the view.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.114 -0500", hash_original_method = "21FC0CE0727282A96780C185A7B70535", hash_generated_method = "47989C8CCE46AD610759CFB799BD8925")
    
public void setContentView(View view, ViewGroup.LayoutParams params) {
        mWindow.setContentView(view, params);
    }

    /**
     * Add an additional content view to the screen.  Added after any existing
     * ones in the screen -- existing views are NOT removed.
     * 
     * @param view The desired content to display.
     * @param params Layout parameters for the view.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.116 -0500", hash_original_method = "54F8942E4EAEA6A93BE827863701CD23", hash_generated_method = "24C1FB443391771714C3EF0404DD3E41")
    
public void addContentView(View view, ViewGroup.LayoutParams params) {
        mWindow.addContentView(view, params);
    }

    /**
     * Set the title text for this dialog's window.
     * 
     * @param title The new text to display in the title.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.118 -0500", hash_original_method = "A94A4616451E43B03E2FA5DD3DFB9ED3", hash_generated_method = "B2573109B4DF5AAEEABA79F58E13CFC1")
    
public void setTitle(CharSequence title) {
        mWindow.setTitle(title);
        mWindow.getAttributes().setTitle(title);
    }

    /**
     * Set the title text for this dialog's window. The text is retrieved
     * from the resources with the supplied identifier.
     *
     * @param titleId the title's text resource identifier
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.121 -0500", hash_original_method = "0D914ED2883864B655DBF2629252A595", hash_generated_method = "7E20A4D7759EB3A7DD02C09CD2AF955C")
    
public void setTitle(int titleId) {
        setTitle(mContext.getText(titleId));
    }

    /**
     * A key was pressed down.
     * 
     * <p>If the focused view didn't want this event, this method is called.
     *
     * <p>The default implementation consumed the KEYCODE_BACK to later
     * handle it in {@link #onKeyUp}.
     *
     * @see #onKeyUp
     * @see android.view.KeyEvent
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.123 -0500", hash_original_method = "EB61104CC8357BEAF109072385D21C38", hash_generated_method = "4DB4151A8E7D7BA689F07BA0B4F11E71")
    
public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            event.startTracking();
            return true;
        }

        return false;
    }

    /**
     * Default implementation of {@link KeyEvent.Callback#onKeyLongPress(int, KeyEvent)
     * KeyEvent.Callback.onKeyLongPress()}: always returns false (doesn't handle
     * the event).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.125 -0500", hash_original_method = "2A75FF2C44C4D96068DDAFC2643F0C8B", hash_generated_method = "DCA1BD8CD57F309EE5CB42ADAEA0EA5E")
    
public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        return false;
    }

    /**
     * A key was released.
     * 
     * <p>The default implementation handles KEYCODE_BACK to close the
     * dialog.
     *
     * @see #onKeyDown
     * @see KeyEvent
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.127 -0500", hash_original_method = "CFFAC7119271281C27F3BEDCE8D82CC2", hash_generated_method = "BC3FF5FBCBFE43EA50C5393C14A1E8FC")
    
public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.isTracking()
                && !event.isCanceled()) {
            onBackPressed();
            return true;
        }
        return false;
    }

    /**
     * Default implementation of {@link KeyEvent.Callback#onKeyMultiple(int, int, KeyEvent)
     * KeyEvent.Callback.onKeyMultiple()}: always returns false (doesn't handle
     * the event).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.129 -0500", hash_original_method = "E364C67ED15F0AA31C6DCFFA6137C8C0", hash_generated_method = "36A8C90D805E1CE396E3F79E76A992E5")
    
public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        return false;
    }
    
    /**
     * Called when the dialog has detected the user's press of the back
     * key.  The default implementation simply cancels the dialog (only if
     * it is cancelable), but you can override this to do whatever you want.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.131 -0500", hash_original_method = "EAEAA0DB8B83D24D321D98459F4FA29E", hash_generated_method = "6807D6D1E53693E5868F1A8094B9D433")
    
public void onBackPressed() {
        if (mCancelable) {
            cancel();
        }
    }

    /**
     * Called when an key shortcut event is not handled by any of the views in the Dialog.
     * Override this method to implement global key shortcuts for the Dialog.
     * Key shortcuts can also be implemented by setting the
     * {@link MenuItem#setShortcut(char, char) shortcut} property of menu items.
     *
     * @param keyCode The value in event.getKeyCode().
     * @param event Description of the key event.
     * @return True if the key shortcut was handled.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.133 -0500", hash_original_method = "2ECF3E4914B4B3BE2238F799B7435A51", hash_generated_method = "79AEB00DA58A022844D17B2E04B426A1")
    
public boolean onKeyShortcut(int keyCode, KeyEvent event) {
        return false;
    }

    /**
     * Called when a touch screen event was not handled by any of the views
     * under it. This is most useful to process touch events that happen outside
     * of your window bounds, where there is no view to receive it.
     * 
     * @param event The touch screen event being processed.
     * @return Return true if you have consumed the event, false if you haven't.
     *         The default implementation will cancel the dialog when a touch
     *         happens outside of the window bounds.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.136 -0500", hash_original_method = "5A4B1024EA76F961E6155B7F9E2B0909", hash_generated_method = "879CE84D681F7773D6C675C97C27C330")
    
public boolean onTouchEvent(MotionEvent event) {
        if (mCancelable && mShowing && mWindow.shouldCloseOnTouch(mContext, event)) {
            cancel();
            return true;
        }
        
        return false;
    }

    /**
     * Called when the trackball was moved and not handled by any of the
     * views inside of the activity.  So, for example, if the trackball moves
     * while focus is on a button, you will receive a call here because
     * buttons do not normally do anything with trackball events.  The call
     * here happens <em>before</em> trackball movements are converted to
     * DPAD key events, which then get sent back to the view hierarchy, and
     * will be processed at the point for things like focus navigation.
     * 
     * @param event The trackball event being processed.
     * 
     * @return Return true if you have consumed the event, false if you haven't.
     * The default implementation always returns false.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.138 -0500", hash_original_method = "4A983FDB3FF481E2165B7D8D641CDD48", hash_generated_method = "3CA4089EBE14436E733AD365EF1361B8")
    
public boolean onTrackballEvent(MotionEvent event) {
        return false;
    }

    /**
     * Called when a generic motion event was not handled by any of the
     * views inside of the dialog.
     * <p>
     * Generic motion events describe joystick movements, mouse hovers, track pad
     * touches, scroll wheel movements and other input events.  The
     * {@link MotionEvent#getSource() source} of the motion event specifies
     * the class of input that was received.  Implementations of this method
     * must examine the bits in the source before processing the event.
     * The following code example shows how this is done.
     * </p><p>
     * Generic motion events with source class
     * {@link android.view.InputDevice#SOURCE_CLASS_POINTER}
     * are delivered to the view under the pointer.  All other generic motion events are
     * delivered to the focused view.
     * </p><p>
     * See {@link View#onGenericMotionEvent(MotionEvent)} for an example of how to
     * handle this event.
     * </p>
     *
     * @param event The generic motion event being processed.
     *
     * @return Return true if you have consumed the event, false if you haven't.
     * The default implementation always returns false.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.141 -0500", hash_original_method = "0E59A005881F30C798F764BCF32D89A3", hash_generated_method = "FC042457DA14CABBB898ABC65A695166")
    
public boolean onGenericMotionEvent(MotionEvent event) {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.143 -0500", hash_original_method = "4EF468126ED8F0323D4288D03F894270", hash_generated_method = "0B65BF87FD38A097377B2BB6269818B9")
    
public void onWindowAttributesChanged(WindowManager.LayoutParams params) {
        if (mDecor != null) {
            mWindowManager.updateViewLayout(mDecor, params);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.145 -0500", hash_original_method = "32D7339793DCE0D5AEFE6621981EC978", hash_generated_method = "C45B7C15E316FF99AA579496D4660410")
    
public void onContentChanged() {
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.147 -0500", hash_original_method = "C7622FC561A602386C2112BC0445F7C6", hash_generated_method = "A78A7C6B763B8F194C5AA376EFC516AD")
    
public void onWindowFocusChanged(boolean hasFocus) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.149 -0500", hash_original_method = "D6E949EE9F0768F47016EEA4FC0347A8", hash_generated_method = "36EB06ADAB10E1C549B25F3883CC9A04")
    
public void onAttachedToWindow() {
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.151 -0500", hash_original_method = "E592299EBB4DE1D6696EB8C4009A9EF4", hash_generated_method = "2C686A74CA98AB92B59E2086FB62185D")
    
public void onDetachedFromWindow() {
    }
    
    /**
     * Called to process key events.  You can override this to intercept all 
     * key events before they are dispatched to the window.  Be sure to call 
     * this implementation for key events that should be handled normally.
     * 
     * @param event The key event.
     * 
     * @return boolean Return true if this event was consumed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.153 -0500", hash_original_method = "1435B67C8334D2AC8987004B54F10264", hash_generated_method = "04F91395206B54F10C8CEF6DB25CA04D")
    
public boolean dispatchKeyEvent(KeyEvent event) {
        if ((mOnKeyListener != null) && (mOnKeyListener.onKey(this, event.getKeyCode(), event))) {
            return true;
        }
        if (mWindow.superDispatchKeyEvent(event)) {
            return true;
        }
        return event.dispatch(this, mDecor != null
                ? mDecor.getKeyDispatcherState() : null, this);
    }

    /**
     * Called to process a key shortcut event.
     * You can override this to intercept all key shortcut events before they are
     * dispatched to the window.  Be sure to call this implementation for key shortcut
     * events that should be handled normally.
     *
     * @param event The key shortcut event.
     * @return True if this event was consumed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.156 -0500", hash_original_method = "BA9D4031BD488C1D379B1950A362F8D4", hash_generated_method = "4894634EDDCA3FC9A62B97AC03EE312F")
    
public boolean dispatchKeyShortcutEvent(KeyEvent event) {
        if (mWindow.superDispatchKeyShortcutEvent(event)) {
            return true;
        }
        return onKeyShortcut(event.getKeyCode(), event);
    }

    /**
     * Called to process touch screen events.  You can override this to
     * intercept all touch screen events before they are dispatched to the
     * window.  Be sure to call this implementation for touch screen events
     * that should be handled normally.
     * 
     * @param ev The touch screen event.
     * 
     * @return boolean Return true if this event was consumed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.158 -0500", hash_original_method = "D3052CDDAC0630315E0F5E7AF5478D0E", hash_generated_method = "1AC90B09F693C4241E7446E01951470C")
    
public boolean dispatchTouchEvent(MotionEvent ev) {
        if (mWindow.superDispatchTouchEvent(ev)) {
            return true;
        }
        return onTouchEvent(ev);
    }
    
    /**
     * Called to process trackball events.  You can override this to
     * intercept all trackball events before they are dispatched to the
     * window.  Be sure to call this implementation for trackball events
     * that should be handled normally.
     * 
     * @param ev The trackball event.
     * 
     * @return boolean Return true if this event was consumed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.160 -0500", hash_original_method = "2B935C89EDDE71F28E7C978B3C9DCAB0", hash_generated_method = "C578ECCB44A8A96163A33635B24D9E97")
    
public boolean dispatchTrackballEvent(MotionEvent ev) {
        if (mWindow.superDispatchTrackballEvent(ev)) {
            return true;
        }
        return onTrackballEvent(ev);
    }

    /**
     * Called to process generic motion events.  You can override this to
     * intercept all generic motion events before they are dispatched to the
     * window.  Be sure to call this implementation for generic motion events
     * that should be handled normally.
     *
     * @param ev The generic motion event.
     *
     * @return boolean Return true if this event was consumed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.162 -0500", hash_original_method = "B6AB9C2BD67E148832650E309163688C", hash_generated_method = "B848B6DC63319F80C3C05AEAF05408E5")
    
public boolean dispatchGenericMotionEvent(MotionEvent ev) {
        if (mWindow.superDispatchGenericMotionEvent(ev)) {
            return true;
        }
        return onGenericMotionEvent(ev);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.165 -0500", hash_original_method = "3CC377981D86463D050A06CF1F7ED782", hash_generated_method = "D9F3EAF53DD83388CEFB9D1088708A1A")
    
public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        event.setClassName(getClass().getName());
        event.setPackageName(mContext.getPackageName());

        LayoutParams params = getWindow().getAttributes();
        boolean isFullScreen = (params.width == LayoutParams.MATCH_PARENT) &&
            (params.height == LayoutParams.MATCH_PARENT);
        event.setFullScreen(isFullScreen);

        return false;
    }

    /**
     * @see Activity#onCreatePanelView(int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.167 -0500", hash_original_method = "8FB2859FE43E0606E21921E291A18BDA", hash_generated_method = "25B127EBCB57EFECBD95579CCC6F2900")
    
public View onCreatePanelView(int featureId) {
        return null;
    }

    /**
     * @see Activity#onCreatePanelMenu(int, Menu)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.169 -0500", hash_original_method = "1B30E4AD9FCCEF2C81163B46B66D301C", hash_generated_method = "E03553A532F29A4B47F37E31A8D9FA27")
    
public boolean onCreatePanelMenu(int featureId, Menu menu) {
        if (featureId == Window.FEATURE_OPTIONS_PANEL) {
            return onCreateOptionsMenu(menu);
        }
        
        return false;
    }

    /**
     * @see Activity#onPreparePanel(int, View, Menu)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.171 -0500", hash_original_method = "A95440A37102593BE255304F4188998E", hash_generated_method = "D875CC67F0458609CF6A973F23B89175")
    
public boolean onPreparePanel(int featureId, View view, Menu menu) {
        if (featureId == Window.FEATURE_OPTIONS_PANEL && menu != null) {
            boolean goforit = onPrepareOptionsMenu(menu);
            return goforit && menu.hasVisibleItems();
        }
        return true;
    }

    /**
     * @see Activity#onMenuOpened(int, Menu)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.173 -0500", hash_original_method = "F5A72D2A4A42C0CE2781798802611276", hash_generated_method = "011043E93B40870F0BDA52D358B46C16")
    
public boolean onMenuOpened(int featureId, Menu menu) {
        if (featureId == Window.FEATURE_ACTION_BAR) {
            mActionBar.dispatchMenuVisibilityChanged(true);
        }
        return true;
    }

    /**
     * @see Activity#onMenuItemSelected(int, MenuItem)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.175 -0500", hash_original_method = "CDCEA93B87CB4399825B767626A61473", hash_generated_method = "234B6579A2BA704FF322BE2796BEDB2B")
    
public boolean onMenuItemSelected(int featureId, MenuItem item) {
        return false;
    }

    /**
     * @see Activity#onPanelClosed(int, Menu)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.177 -0500", hash_original_method = "20C3110FD341FFE95CFF6A6C95609D00", hash_generated_method = "29C7BCF17E32E00DA290EB413F2AE599")
    
public void onPanelClosed(int featureId, Menu menu) {
        if (featureId == Window.FEATURE_ACTION_BAR) {
            mActionBar.dispatchMenuVisibilityChanged(false);
        }
    }

    /**
     * It is usually safe to proxy this call to the owner activity's
     * {@link Activity#onCreateOptionsMenu(Menu)} if the client desires the same
     * menu for this Dialog.
     * 
     * @see Activity#onCreateOptionsMenu(Menu)
     * @see #getOwnerActivity()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.181 -0500", hash_original_method = "F3CAA7B8E21AB403B530132B4E52A4EB", hash_generated_method = "4A2EB9F983B5D64CDF1DFFBFB4980E58")
    
public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    /**
     * It is usually safe to proxy this call to the owner activity's
     * {@link Activity#onPrepareOptionsMenu(Menu)} if the client desires the
     * same menu for this Dialog.
     * 
     * @see Activity#onPrepareOptionsMenu(Menu)
     * @see #getOwnerActivity()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.183 -0500", hash_original_method = "BF0F08B18C75FC62D01E0D6DB107696E", hash_generated_method = "A21AD95DA0C9DA81EA628EB9AA3873D3")
    
public boolean onPrepareOptionsMenu(Menu menu) {
        return true;
    }

    /**
     * @see Activity#onOptionsItemSelected(MenuItem)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.185 -0500", hash_original_method = "8EF9A1828892EFEBF4B93362A866125C", hash_generated_method = "69E9D8B4009D997BC9EE261646EC81E4")
    
public boolean onOptionsItemSelected(MenuItem item) {
        return false;
    }

    /**
     * @see Activity#onOptionsMenuClosed(Menu)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.187 -0500", hash_original_method = "D53E4189B6E7F0EC0F9883E9844F2140", hash_generated_method = "105C77F54F2D3DE304E191D655D9615E")
    
public void onOptionsMenuClosed(Menu menu) {
    }

    /**
     * @see Activity#openOptionsMenu()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.189 -0500", hash_original_method = "756759165F6AB2C8C6E469E63BE14186", hash_generated_method = "3C023A20572EFC197D0EAE2E2611F4F2")
    
public void openOptionsMenu() {
        mWindow.openPanel(Window.FEATURE_OPTIONS_PANEL, null);
    }
    
    /**
     * @see Activity#closeOptionsMenu()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.191 -0500", hash_original_method = "D12ED1735BBB9BCDCD831C99F03640D7", hash_generated_method = "3DAF793AB131627C85D80372FC993355")
    
public void closeOptionsMenu() {
        mWindow.closePanel(Window.FEATURE_OPTIONS_PANEL);
    }

    /**
     * @see Activity#invalidateOptionsMenu()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.193 -0500", hash_original_method = "319389EBA801B290FB41D02473EB2E9E", hash_generated_method = "D884060298BD2094521858E602829233")
    
public void invalidateOptionsMenu() {
        mWindow.invalidatePanelMenu(Window.FEATURE_OPTIONS_PANEL);
    }

    /**
     * @see Activity#onCreateContextMenu(ContextMenu, View, ContextMenuInfo)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.195 -0500", hash_original_method = "85F2A519B2781A30F4BC68DB47459C98", hash_generated_method = "1B44B70B0D6B4F288A41A01A283212DF")
    
public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
    }

    /**
     * @see Activity#registerForContextMenu(View)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.198 -0500", hash_original_method = "1A123249F7C2C892EA53E2F44D60C1FB", hash_generated_method = "C1ED4C2C40B6DEE495507BA44925204D")
    
public void registerForContextMenu(View view) {
        view.setOnCreateContextMenuListener(this);
    }
    
    /**
     * @see Activity#unregisterForContextMenu(View)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.200 -0500", hash_original_method = "6A7E2B106BB1CEE7C3B668A773DE5A5B", hash_generated_method = "75D2DB67C93B9FA99A912C90753A67CE")
    
public void unregisterForContextMenu(View view) {
        view.setOnCreateContextMenuListener(null);
    }
    
    /**
     * @see Activity#openContextMenu(View)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.202 -0500", hash_original_method = "D1451DBD5DFD14FAE397660897192E3C", hash_generated_method = "320EBE9DAC491AFFCE2D5802170E7386")
    
public void openContextMenu(View view) {
        view.showContextMenu();
    }

    /**
     * @see Activity#onContextItemSelected(MenuItem)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.204 -0500", hash_original_method = "801D77DFDCCE5570587CA592634E3D3B", hash_generated_method = "8B3B439BA7ABB6AA146B4A585B36ACCC")
    
public boolean onContextItemSelected(MenuItem item) {
        return false;
    }
    
    /**
     * @see Activity#onContextMenuClosed(Menu)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.206 -0500", hash_original_method = "5C6F377B774E414E6D9422BBC7AAE81F", hash_generated_method = "0B365FF2BD060E33D17A1C5DD359133C")
    
public void onContextMenuClosed(Menu menu) {
    }
    
    /**
     * This hook is called when the user signals the desire to start a search.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.208 -0500", hash_original_method = "38790ED2FB6D0EF1B7954716C7615F0D", hash_generated_method = "8F4CC75C5322703DE6168A66DB4A0AED")
    
public boolean onSearchRequested() {
        final SearchManager searchManager = (SearchManager) mContext
                .getSystemService(Context.SEARCH_SERVICE);

        // associate search with owner activity
        final ComponentName appName = getAssociatedActivity();
        if (appName != null && searchManager.getSearchableInfo(appName) != null) {
            searchManager.startSearch(null, false, appName, null, false);
            dismiss();
            return true;
        } else {
            return false;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.211 -0500", hash_original_method = "5D1C131301342FA877A860064E23A1A6", hash_generated_method = "ADB9CD66379AA411334D133DA74C3784")
    
public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        if (mActionBar != null) {
            return mActionBar.startActionMode(callback);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * Note that if you override this method you should always call through
     * to the superclass implementation by calling super.onActionModeStarted(mode).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.213 -0500", hash_original_method = "00C0B67E273850713F0D88B8DE976F73", hash_generated_method = "50B78CCCCC03921D5397A78F91B9B2DA")
    
public void onActionModeStarted(ActionMode mode) {
        mActionMode = mode;
    }

    /**
     * {@inheritDoc}
     *
     * Note that if you override this method you should always call through
     * to the superclass implementation by calling super.onActionModeFinished(mode).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.215 -0500", hash_original_method = "9FD315390CEABDE5B2497E2EE78C905A", hash_generated_method = "BA03EF9EA31D4CA28509FF660B8525CD")
    
public void onActionModeFinished(ActionMode mode) {
        if (mode == mActionMode) {
            mActionMode = null;
        }
    }

    /**
     * @return The activity associated with this dialog, or null if there is no associated activity.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.218 -0500", hash_original_method = "2C0F3C4A58B092DBFC10EA72C5A7ED76", hash_generated_method = "275C32D8E91155BA86B5F29FC6D158C1")
    
private ComponentName getAssociatedActivity() {
        Activity activity = mOwnerActivity;
        Context context = getContext();
        while (activity == null && context != null) {
            if (context instanceof Activity) {
                activity = (Activity) context;  // found it!
            } else {
                context = (context instanceof ContextWrapper) ?
                        ((ContextWrapper) context).getBaseContext() : // unwrap one level
                        null;                                         // done
            }
        }
        return activity == null ? null : activity.getComponentName();
    }


    /**
     * Request that key events come to this dialog. Use this if your
     * dialog has no views with focus, but the dialog still wants
     * a chance to process key events.
     * 
     * @param get true if the dialog should receive key events, false otherwise
     * @see android.view.Window#takeKeyEvents
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.220 -0500", hash_original_method = "18F720E0A5C2702D89E6608BD6B708CA", hash_generated_method = "001D589E1621EE22204A165962D52DE4")
    
public void takeKeyEvents(boolean get) {
        mWindow.takeKeyEvents(get);
    }

    /**
     * Enable extended window features.  This is a convenience for calling
     * {@link android.view.Window#requestFeature getWindow().requestFeature()}.
     * 
     * @param featureId The desired feature as defined in
     *                  {@link android.view.Window}.
     * @return Returns true if the requested feature is supported and now
     *         enabled.
     * 
     * @see android.view.Window#requestFeature
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.222 -0500", hash_original_method = "3CDF417FCD4F33EAE6CFCF0FB6D583A8", hash_generated_method = "881FBD2BDEED0015ADB64FC143BF0105")
    
public final boolean requestWindowFeature(int featureId) {
        return getWindow().requestFeature(featureId);
    }

    /**
     * Convenience for calling
     * {@link android.view.Window#setFeatureDrawableResource}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.224 -0500", hash_original_method = "E7AFD534CB1DF8060614ED36111B2407", hash_generated_method = "77462D4BD7A21F99BAD57C59CACE9BF5")
    
public final void setFeatureDrawableResource(int featureId, int resId) {
        getWindow().setFeatureDrawableResource(featureId, resId);
    }

    /**
     * Convenience for calling
     * {@link android.view.Window#setFeatureDrawableUri}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.227 -0500", hash_original_method = "2E53659D6309BF8C5C8E8AD82BD6A577", hash_generated_method = "CA522E500B91F795335EC5BB8DD09937")
    
public final void setFeatureDrawableUri(int featureId, Uri uri) {
        getWindow().setFeatureDrawableUri(featureId, uri);
    }

    /**
     * Convenience for calling
     * {@link android.view.Window#setFeatureDrawable(int, Drawable)}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.229 -0500", hash_original_method = "D3FA0A5870730A6F3C959B16FC004BCD", hash_generated_method = "845589EF459B40468B119030F6839003")
    
public final void setFeatureDrawable(int featureId, Drawable drawable) {
        getWindow().setFeatureDrawable(featureId, drawable);
    }

    /**
     * Convenience for calling
     * {@link android.view.Window#setFeatureDrawableAlpha}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.231 -0500", hash_original_method = "4D2A81FF8C2C83F47460DEB3120C04CB", hash_generated_method = "42B6BECB117F777AFB6F11B60A38D749")
    
public final void setFeatureDrawableAlpha(int featureId, int alpha) {
        getWindow().setFeatureDrawableAlpha(featureId, alpha);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.233 -0500", hash_original_method = "2F200E491A9F2CDC38C392035D21ED48", hash_generated_method = "3A16D6A7B6ED88109371E767B4893157")
    
public LayoutInflater getLayoutInflater() {
        return getWindow().getLayoutInflater();
    }

    /**
     * Sets whether this dialog is cancelable with the
     * {@link KeyEvent#KEYCODE_BACK BACK} key.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.235 -0500", hash_original_method = "C80CDCB014C953B0801E95FEB1706C5F", hash_generated_method = "5952C6CEE01EE86227B86B0B3007B0FF")
    
public void setCancelable(boolean flag) {
        mCancelable = flag;
    }

    /**
     * Sets whether this dialog is canceled when touched outside the window's
     * bounds. If setting to true, the dialog is set to be cancelable if not
     * already set.
     * 
     * @param cancel Whether the dialog should be canceled when touched outside
     *            the window.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.238 -0500", hash_original_method = "BD7DFECDBEA3F81451B9076CEFC17564", hash_generated_method = "FFDB8DA5023282815789B2E8846CC855")
    
public void setCanceledOnTouchOutside(boolean cancel) {
        if (cancel && !mCancelable) {
            mCancelable = true;
        }
        
        mWindow.setCloseOnTouchOutside(cancel);
    }
    
    /**
     * Cancel the dialog.  This is essentially the same as calling {@link #dismiss()}, but it will
     * also call your {@link DialogInterface.OnCancelListener} (if registered).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.240 -0500", hash_original_method = "4DD1D51C0E16D279CD855F2D66BA21A6", hash_generated_method = "66AEF5625C67A64B920D22182D77DF83")
    
public void cancel() {
        if (!mCanceled && mCancelMessage != null) {
            mCanceled = true;
            // Obtain a new message so this dialog can be re-used
            Message.obtain(mCancelMessage).sendToTarget();
        }
        dismiss();
    }

    /**
     * Set a listener to be invoked when the dialog is canceled.
     * <p>
     * This will only be invoked when the dialog is canceled, if the creator
     * needs to know when it is dismissed in general, use
     * {@link #setOnDismissListener}.
     * 
     * @param listener The {@link DialogInterface.OnCancelListener} to use.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.242 -0500", hash_original_method = "B6A3C715E726D4D77D298D569C13057A", hash_generated_method = "A4129EBA16B106E20EC01A33D83D4381")
    
public void setOnCancelListener(final OnCancelListener listener) {
        if (mCancelAndDismissTaken != null) {
            throw new IllegalStateException(
                    "OnCancelListener is already taken by "
                    + mCancelAndDismissTaken + " and can not be replaced.");
        }
        if (listener != null) {
            mCancelMessage = mListenersHandler.obtainMessage(CANCEL, listener);
        } else {
            mCancelMessage = null;
        }
    }

    /**
     * Set a message to be sent when the dialog is canceled.
     * @param msg The msg to send when the dialog is canceled.
     * @see #setOnCancelListener(android.content.DialogInterface.OnCancelListener)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.244 -0500", hash_original_method = "774019D9ADE46FB9924B78D145C17F36", hash_generated_method = "CEEE1E615A7056ADDC3C7E93AFB8155D")
    
public void setCancelMessage(final Message msg) {
        mCancelMessage = msg;
    }

    /**
     * Set a listener to be invoked when the dialog is dismissed.
     * @param listener The {@link DialogInterface.OnDismissListener} to use.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.247 -0500", hash_original_method = "464A84E289A7DD535A8EA3034BC5D33F", hash_generated_method = "AA09BB623862B4C8757C3CDC5F3F8F50")
    
public void setOnDismissListener(final OnDismissListener listener) {
        if (mCancelAndDismissTaken != null) {
            throw new IllegalStateException(
                    "OnDismissListener is already taken by "
                    + mCancelAndDismissTaken + " and can not be replaced.");
        }
        if (listener != null) {
            mDismissMessage = mListenersHandler.obtainMessage(DISMISS, listener);
        } else {
            mDismissMessage = null;
        }
    }

    
    private static final class ListenersHandler extends Handler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.264 -0500", hash_original_field = "DC7483C81552C4D76DF4759BE53BA423", hash_generated_field = "436872B12AE04B06D18A845CB0719BC2")

        private WeakReference<DialogInterface> mDialog;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.266 -0500", hash_original_method = "92DAC0D6E122198BF26AB724936B6539", hash_generated_method = "84DBB351EFCA296C180FC18A76D81CD0")
        
public ListenersHandler(Dialog dialog) {
            mDialog = new WeakReference<DialogInterface>(dialog);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.269 -0500", hash_original_method = "0AC2BA822DE6E333F562D01CFB6CE49A", hash_generated_method = "2DD88F184922AF15640C87AEA2DA6C0A")
        
@Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
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
        }

        
    }

    /**
     * Sets a listener to be invoked when the dialog is shown.
     * @param listener The {@link DialogInterface.OnShowListener} to use.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.249 -0500", hash_original_method = "0B69163DC80B46ACDA2709DE4C77DC2F", hash_generated_method = "87A3D93A28F439C62A18E848E86BC529")
    
public void setOnShowListener(OnShowListener listener) {
        if (listener != null) {
            mShowMessage = mListenersHandler.obtainMessage(SHOW, listener);
        } else {
            mShowMessage = null;
        }
    }

    /**
     * Set a message to be sent when the dialog is dismissed.
     * @param msg The msg to send when the dialog is dismissed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.252 -0500", hash_original_method = "2BD742B46509FC81ABA0DF4EC8F37AEC", hash_generated_method = "65DD030D495E2DBE6234C3607957BB12")
    
public void setDismissMessage(final Message msg) {
        mDismissMessage = msg;
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.254 -0500", hash_original_method = "4322D13EDCAAC15D5143567F42FC68A2", hash_generated_method = "D0767F129DA2BE6A2E1F540A5050903B")
    
public boolean takeCancelAndDismissListeners(String msg, final OnCancelListener cancel,
            final OnDismissListener dismiss) {
        if (mCancelAndDismissTaken != null) {
            mCancelAndDismissTaken = null;
        } else if (mCancelMessage != null || mDismissMessage != null) {
            return false;
        }
        
        setOnCancelListener(cancel);
        setOnDismissListener(dismiss);
        mCancelAndDismissTaken = msg;
        
        return true;
    }
    
    /**
     * By default, this will use the owner Activity's suggested stream type.
     * 
     * @see Activity#setVolumeControlStream(int)
     * @see #setOwnerActivity(Activity)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.257 -0500", hash_original_method = "70729F29EB37CCBEC739A5986214C32F", hash_generated_method = "3084C39BB70D3B6F524464E54969131C")
    
public final void setVolumeControlStream(int streamType) {
        getWindow().setVolumeControlStream(streamType);
    }

    /**
     * @see Activity#getVolumeControlStream()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.259 -0500", hash_original_method = "03A841DC7655848901B3CE2C14084AAE", hash_generated_method = "0A136881DA0A667DEE6F55CE255E857C")
    
public final int getVolumeControlStream() {
        return getWindow().getVolumeControlStream();
    }
    
    /**
     * Sets the callback that will be called if a key is dispatched to the dialog.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:17.261 -0500", hash_original_method = "A9C3EE1B48BA32717B6024C41DF4E1F6", hash_generated_method = "472DF197C926507F0B9B35ECE002C55F")
    
public void setOnKeyListener(final OnKeyListener onKeyListener) {
        mOnKeyListener = onKeyListener;
    }
}

