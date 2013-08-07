package com.android.internal.policy.impl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import com.android.internal.R;
import android.os.IBinder;
import android.os.SystemProperties;
import android.util.Log;
import android.view.WindowManager;
import android.app.ActivityManager;
import android.graphics.Color;
import android.view.ViewManager;
import android.view.View;
import android.content.pm.ActivityInfo;
import android.widget.FrameLayout;
import android.content.Context;
import android.graphics.PixelFormat;
import android.graphics.Canvas;
import android.view.ViewGroup;
import android.content.res.Resources;
public class KeyguardViewManager implements KeyguardWindowController {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.326 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.327 -0400", hash_original_field = "E0A5EC485E1AB1339DCAF115AA8CA6AB", hash_generated_field = "4A75709E71366A349ACCAA71DCF2EC4A")

    private ViewManager mViewManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.327 -0400", hash_original_field = "1804C5EC7AAE0B28B15CFDA061D25829", hash_generated_field = "2E854999F8FF3F1BC54ABCA08FA19468")

    private KeyguardViewCallback mCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.328 -0400", hash_original_field = "E016F0C9E138EBE95B0E787A66BF2EC6", hash_generated_field = "4F4B4FB3EFE847696CBBFFBFC6C14CCC")

    private KeyguardViewProperties mKeyguardViewProperties;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.328 -0400", hash_original_field = "E8A7E633D99E3BACB8ADFBBABB173D14", hash_generated_field = "22DCE3AFB482F86E6B2E96F873097CE0")

    private KeyguardUpdateMonitor mUpdateMonitor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.328 -0400", hash_original_field = "F88D27B6821F66E9A7A8DBF0731A03B7", hash_generated_field = "AFF0D8313A0307A43EC895886E99A631")

    private WindowManager.LayoutParams mWindowLayoutParams;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.329 -0400", hash_original_field = "0522E229E6795E0A6146E09C3072E661", hash_generated_field = "F235EF6B41195064C37CB35F43CBC213")

    private boolean mNeedsInput = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.329 -0400", hash_original_field = "B5B2D30E938C0104614C8431FA8A0293", hash_generated_field = "65A2BA4CA76D967EF0A4E85F866B718D")

    private FrameLayout mKeyguardHost;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.329 -0400", hash_original_field = "67EE1E654DDCCE86E80F09EEB1E462EB", hash_generated_field = "E378161CD8077536328B46B5959B29EE")

    private KeyguardViewBase mKeyguardView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.330 -0400", hash_original_field = "827F65345D6ECF634C239C686A751B07", hash_generated_field = "C33AFD7DADA62D8CDED907E93833EEC1")

    private boolean mScreenOn = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.330 -0400", hash_original_method = "600E00A6409A904A2CA76CB38BF39354", hash_generated_method = "9E06AF0E661D25F0387DA64FBA7EAE28")
    public  KeyguardViewManager(Context context, ViewManager viewManager,
            KeyguardViewCallback callback, KeyguardViewProperties keyguardViewProperties,
            KeyguardUpdateMonitor updateMonitor) {
        addTaint(updateMonitor.getTaint());
        addTaint(keyguardViewProperties.getTaint());
        addTaint(callback.getTaint());
        addTaint(viewManager.getTaint());
        addTaint(context.getTaint());
mContext=contextmViewManager=viewManagermCallback=callbackmKeyguardViewProperties=keyguardViewPropertiesmUpdateMonitor=updateMonitor
        // ---------- Original Method ----------
        //mContext = context;
        //mViewManager = viewManager;
        //mCallback = callback;
        //mKeyguardViewProperties = keyguardViewProperties;
        //mUpdateMonitor = updateMonitor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.332 -0400", hash_original_method = "3787D2E031F129386EB10FCB4066D441", hash_generated_method = "C9DB93A88A145FF9BA632929546F891B")
    public synchronized void show() {
        if(DEBUG)        
Log.d(TAG, "show(); mKeyguardView=="+mKeyguardView)
        Resources res = mContext.getResources();
        boolean enableScreenRotation = SystemProperties.getBoolean("lockscreen.rot_override",false)
                || res.getBoolean(R.bool.config_enableLockScreenRotation);
        if(mKeyguardHost==null)        
        {
            if(DEBUG)            
Log.d(TAG, "keyguard host is null, creating it...")
mKeyguardHost=new KeyguardViewHost(mContext, mCallback)            final int stretch = ViewGroup.LayoutParams.MATCH_PARENT;
            int flags = WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN
                    | WindowManager.LayoutParams.FLAG_SHOW_WALLPAPER
                    | WindowManager.LayoutParams.FLAG_KEEP_SURFACE_WHILE_ANIMATING;
            if(!mNeedsInput)            
            {
flags|=WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM
            } //End block
            if(ActivityManager.isHighEndGfx(((WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay()))            
            {
flags|=WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED
            } //End block
            WindowManager.LayoutParams lp = new WindowManager.LayoutParams(
                    stretch, stretch, WindowManager.LayoutParams.TYPE_KEYGUARD,
                    flags, PixelFormat.TRANSLUCENT);
lp.softInputMode=WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZElp.windowAnimations=com.android.internal.R.style.Animation_LockScreen            if(ActivityManager.isHighEndGfx(((WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay()))            
            {
lp.flags|=WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATEDlp.privateFlags|=WindowManager.LayoutParams.PRIVATE_FLAG_FORCE_HARDWARE_ACCELERATED
            } //End block
lp.privateFlags|=WindowManager.LayoutParams.PRIVATE_FLAG_SET_NEEDS_MENU_KEYlp.setTitle("Keyguard")mWindowLayoutParams=lpmViewManager.addView(mKeyguardHost, lp)
        } //End block
        if(enableScreenRotation)        
        {
            if(DEBUG)            
Log.d(TAG, "Rotation sensor for lock screen On!")
mWindowLayoutParams.screenOrientation=ActivityInfo.SCREEN_ORIENTATION_SENSOR
        } //End block
        else
        {
            if(DEBUG)            
Log.d(TAG, "Rotation sensor for lock screen Off!")
mWindowLayoutParams.screenOrientation=ActivityInfo.SCREEN_ORIENTATION_NOSENSOR
        } //End block
mViewManager.updateViewLayout(mKeyguardHost, mWindowLayoutParams)        if(mKeyguardView==null)        
        {
            if(DEBUG)            
Log.d(TAG, "keyguard view is null, creating it...")
mKeyguardView=mKeyguardViewProperties.createKeyguardView(mContext, mUpdateMonitor, this)mKeyguardView.setId(R.id.lock_screen)mKeyguardView.setCallback(mCallback)            final ViewGroup.LayoutParams lp = new FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT);
mKeyguardHost.addView(mKeyguardView, lp)            if(mScreenOn)            
            {
mKeyguardView.show()
            } //End block
        } //End block
        int visFlags = ( View.STATUS_BAR_DISABLE_BACK
                | View.STATUS_BAR_DISABLE_HOME
                );
mKeyguardHost.setSystemUiVisibility(visFlags)mViewManager.updateViewLayout(mKeyguardHost, mWindowLayoutParams)mKeyguardHost.setVisibility(View.VISIBLE)mKeyguardView.requestFocus()
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.333 -0400", hash_original_method = "1D42CF4BA65DC7DEE23FD757B28C20F3", hash_generated_method = "E6AF3D8DC2E838A6852EDAE4E01C958D")
    public void setNeedsInput(boolean needsInput) {
        addTaint(needsInput);
mNeedsInput=needsInput        if(mWindowLayoutParams!=null)        
        {
            if(needsInput)            
            {
mWindowLayoutParams.flags&=~WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM
            } //End block
            else
            {
mWindowLayoutParams.flags|=WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM
            } //End block
mViewManager.updateViewLayout(mKeyguardHost, mWindowLayoutParams)
        } //End block
        // ---------- Original Method ----------
        //mNeedsInput = needsInput;
        //if (mWindowLayoutParams != null) {
            //if (needsInput) {
                //mWindowLayoutParams.flags &=
                    //~WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM;
            //} else {
                //mWindowLayoutParams.flags |=
                    //WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM;
            //}
            //mViewManager.updateViewLayout(mKeyguardHost, mWindowLayoutParams);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.334 -0400", hash_original_method = "E22779A153776F596C19E1DA7158620E", hash_generated_method = "4C3D8E7C4E8A5F1BF95AC536E7C10F53")
    public synchronized void reset() {
        if(DEBUG)        
Log.d(TAG, "reset()")
        if(mKeyguardView!=null)        
        {
mKeyguardView.reset()
        } //End block
        // ---------- Original Method ----------
        //if (DEBUG) Log.d(TAG, "reset()");
        //if (mKeyguardView != null) {
            //mKeyguardView.reset();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.335 -0400", hash_original_method = "7C8BEE0913AA1B58BFDA42F0BC94319F", hash_generated_method = "01A82DDD5F4025063E0FAAB92F75EF56")
    public synchronized void onScreenTurnedOff() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        if(DEBUG)        
Log.d(TAG, "onScreenTurnedOff()")
mScreenOn=false        if(mKeyguardView!=null)        
        {
mKeyguardView.onScreenTurnedOff()
        } //End block
        // ---------- Original Method ----------
        //if (DEBUG) Log.d(TAG, "onScreenTurnedOff()");
        //mScreenOn = false;
        //if (mKeyguardView != null) {
            //mKeyguardView.onScreenTurnedOff();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.337 -0400", hash_original_method = "38C7F8F5FBE6B7DAC7E5FB5AC2D68871", hash_generated_method = "C7C9389A29AC92867CE2F2740CE6B055")
    public synchronized void onScreenTurnedOn(
            final KeyguardViewManager.ShowListener showListener) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(showListener.getTaint());
        if(DEBUG)        
Log.d(TAG, "onScreenTurnedOn()")
mScreenOn=true        if(mKeyguardView!=null)        
        {
mKeyguardView.onScreenTurnedOn()            if(mKeyguardHost.getVisibility()==View.VISIBLE)            
            {
mKeyguardHost.post(new Runnable()                {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.336 -0400", hash_original_method = "0C2C008606EB84E95B7C398862A1F9B2", hash_generated_method = "8E371F8E0BD91C86D2C4FC2B202FCEAC")
        @Override
        public void run() {
            if(mKeyguardHost.getVisibility()==View.VISIBLE)            
            {
showListener.onShown(mKeyguardHost.getWindowToken())
            } //End block
            else
            {
showListener.onShown(null)
            } //End block
            // ---------- Original Method ----------
            //if (mKeyguardHost.getVisibility() == View.VISIBLE) {
                            //showListener.onShown(mKeyguardHost.getWindowToken());
                        //} else {
                            //showListener.onShown(null);
                        //}
        }
                }
)
            } //End block
            else
            {
showListener.onShown(null)
            } //End block
        } //End block
        else
        {
showListener.onShown(null)
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.338 -0400", hash_original_method = "C23F1E498E12DC6443883D1EBA2B9968", hash_generated_method = "1C59B43923DAA8D93C98A5D92ACA34F2")
    public synchronized void verifyUnlock() {
        if(DEBUG)        
Log.d(TAG, "verifyUnlock()")
show()mKeyguardView.verifyUnlock()
        // ---------- Original Method ----------
        //if (DEBUG) Log.d(TAG, "verifyUnlock()");
        //show();
        //mKeyguardView.verifyUnlock();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.339 -0400", hash_original_method = "70BEE87CC182ECA677B43A74B62C4980", hash_generated_method = "01959114AE7C078744F5593130902447")
    public boolean wakeWhenReadyTq(int keyCode) {
        addTaint(keyCode);
        if(DEBUG)        
Log.d(TAG, "wakeWhenReady("+keyCode+")")
        if(mKeyguardView!=null)        
        {
mKeyguardView.wakeWhenReadyTq(keyCode)            boolean varB326B5062B2F0E69046810717534CB09_1274539256 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1693208245 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1693208245;
        } //End block
        else
        {
            boolean var68934A3E9455FA72420237EB05902327_1289714965 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2105405573 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2105405573;
        } //End block
        // ---------- Original Method ----------
        //if (DEBUG) Log.d(TAG, "wakeWhenReady(" + keyCode + ")");
        //if (mKeyguardView != null) {
            //mKeyguardView.wakeWhenReadyTq(keyCode);
            //return true;
        //} else {
            //Log.w(TAG, "mKeyguardView is null in wakeWhenReadyTq");
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.341 -0400", hash_original_method = "2B2F4B3D5B250BB0D744FC37CBC48028", hash_generated_method = "18DB23C45E9980A12F0C3888771E0332")
    public synchronized void hide() {
        if(DEBUG)        
Log.d(TAG, "hide()")
        if(mKeyguardHost!=null)        
        {
mKeyguardHost.setVisibility(View.GONE)            if(mKeyguardView!=null)            
            {
                final KeyguardViewBase lastView = mKeyguardView;
mKeyguardView=nullmKeyguardHost.postDelayed(new Runnable()                {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.340 -0400", hash_original_method = "CE413FF80D179648FFE86E1004149F8A", hash_generated_method = "AAD1F7E0750D0716A0EC7C1217597BAD")
        public void run() {
            synchronized
(KeyguardViewManager.this)            {
lastView.cleanUp()mKeyguardHost.removeView(lastView)
            } //End block
            // ---------- Original Method ----------
            //synchronized (KeyguardViewManager.this) {
                            //lastView.cleanUp();
                            //mKeyguardHost.removeView(lastView);
                        //}
        }
                }
, 500)
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (DEBUG) Log.d(TAG, "hide()");
        //if (mKeyguardHost != null) {
            //mKeyguardHost.setVisibility(View.GONE);
            //if (mKeyguardView != null) {
                //final KeyguardViewBase lastView = mKeyguardView;
                //mKeyguardView = null;
                //mKeyguardHost.postDelayed(new Runnable() {
                    //public void run() {
                        //synchronized (KeyguardViewManager.this) {
                            //lastView.cleanUp();
                            //mKeyguardHost.removeView(lastView);
                        //}
                    //}
                //}, 500);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.342 -0400", hash_original_method = "3B8F5AAD8A448E8D65306058817DB2B5", hash_generated_method = "B1BAB663E855BC920D4FC40007E01C9B")
    public synchronized boolean isShowing() {
        boolean varF89591B390F69A095B6AFA200A339EFA_1601728484 = ((mKeyguardHost!=null&&mKeyguardHost.getVisibility()==View.VISIBLE));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1836444252 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1836444252;
        // ---------- Original Method ----------
        //return (mKeyguardHost != null && mKeyguardHost.getVisibility() == View.VISIBLE);
    }

    
    private static class KeyguardViewHost extends FrameLayout {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.342 -0400", hash_original_field = "1804C5EC7AAE0B28B15CFDA061D25829", hash_generated_field = "2E854999F8FF3F1BC54ABCA08FA19468")

        private KeyguardViewCallback mCallback;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.343 -0400", hash_original_method = "3445EB19B666803A211B4CCFFEDD5409", hash_generated_method = "B7149058499DFDCBC78D304211E6F965")
        private  KeyguardViewHost(Context context, KeyguardViewCallback callback) {
            super(context);
            addTaint(callback.getTaint());
            addTaint(context.getTaint());
mCallback=callback
            // ---------- Original Method ----------
            //mCallback = callback;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.344 -0400", hash_original_method = "8EB411325B26ACBCECE5FA92DFC1B6F4", hash_generated_method = "970AB118711E4744D94369120B7B27FC")
        @Override
        protected void dispatchDraw(Canvas canvas) {
            addTaint(canvas.getTaint());
super.dispatchDraw(canvas)mCallback.keyguardDoneDrawing()
            // ---------- Original Method ----------
            //super.dispatchDraw(canvas);
            //mCallback.keyguardDoneDrawing();
        }

        
    }


    
    public interface ShowListener {
        void onShown(IBinder windowToken);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.344 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "7841AA055B417A7E8C3D727A4ADDD91D")

    private final static boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.344 -0400", hash_original_field = "82F8ECB796CD4E22017EB5F0E9810CB0", hash_generated_field = "A374B7526C0FA7AF34367BFC22F2E7DB")

    private static String TAG = "KeyguardViewManager";
}

