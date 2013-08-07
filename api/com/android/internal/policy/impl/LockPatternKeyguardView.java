package com.android.internal.policy.impl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.SystemClock;
import android.accounts.OperationCanceledException;
import com.android.internal.R;
import android.content.ComponentName;
import android.os.Parcelable;
import com.android.internal.policy.impl.LockPatternKeyguardView.UnlockMode;
import android.util.Log;
import com.android.internal.telephony.IccCard;
import android.view.WindowManager;
import android.os.Message;
import android.view.View;
import android.accounts.AccountManager;
import com.android.internal.policy.IFaceLockInterface;
import java.io.IOException;
import android.view.accessibility.AccessibilityManager;
import com.android.internal.widget.LockScreenWidgetInterface;
import android.os.RemoteException;
import android.graphics.Bitmap;
import com.android.internal.widget.LockPatternUtils;
import android.accounts.Account;
import com.android.internal.widget.TransportControlView;
import android.content.Intent;
import android.view.KeyEvent;
import android.telephony.TelephonyManager;
import android.graphics.Canvas;
import android.accounts.AccountManagerFuture;
import android.os.Handler;
import android.app.admin.DevicePolicyManager;
import android.accounts.AccountManagerCallback;
import com.android.internal.widget.LockScreenWidgetCallback;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.accounts.AuthenticatorException;
import android.os.IBinder;
import android.os.SystemProperties;
import android.view.MotionEvent;
import android.graphics.drawable.Drawable;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.util.Slog;
import android.os.Bundle;
import android.text.TextUtils;
import android.app.AlertDialog;
import android.content.ServiceConnection;
import android.graphics.drawable.ColorDrawable;
import android.graphics.PixelFormat;
import android.content.Context;
import com.android.internal.policy.IFaceLockCallback;
public class LockPatternKeyguardView extends KeyguardViewBase implements Handler.Callback, KeyguardUpdateMonitor.InfoCallback {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.611 -0400", hash_original_field = "E8A7E633D99E3BACB8ADFBBABB173D14", hash_generated_field = "22DCE3AFB482F86E6B2E96F873097CE0")

    private KeyguardUpdateMonitor mUpdateMonitor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.612 -0400", hash_original_field = "593FC713C73D8C2967DA705EE43DBB36", hash_generated_field = "61E4A57EB9F70D8797882D6516576BFC")

    private KeyguardWindowController mWindowController;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.612 -0400", hash_original_field = "F8B22D98D26B311BF19FA69447D4A74D", hash_generated_field = "1EB06E739D9B44185DD3EA2F202F7E30")

    private View mLockScreen;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.612 -0400", hash_original_field = "B53C2F3AA6E5E7B392FC6E02B2C332CF", hash_generated_field = "ABA9B158587968DC7BF5E5200D08FD62")

    private View mUnlockScreen;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.613 -0400", hash_original_field = "827F65345D6ECF634C239C686A751B07", hash_generated_field = "FB2C56F3984265A725C9E41B4FAE9958")

    private volatile boolean mScreenOn = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.613 -0400", hash_original_field = "B44D8FFAC19E02A1F8CF4C9E17B4C4A3", hash_generated_field = "9893A49BC9E8DE9D7CD5F16B5EEFFC94")

    private volatile boolean mWindowFocused = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.613 -0400", hash_original_field = "BDDBF069A0D72D74A1899157A1F4EC97", hash_generated_field = "770C5E549D23580F9C36576FE2669373")

    private boolean mEnableFallback = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.613 -0400", hash_original_field = "619E39B3622C599BDC1263A052F39BEB", hash_generated_field = "73C047B05A8A8A7FA6D1BC4439ED03CE")

    private boolean mShowLockBeforeUnlock = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.613 -0400", hash_original_field = "C95F75B0E2D530288F2F4C2A33A13876", hash_generated_field = "1E267AFCB986459CD0E2615A31EE219E")

    private IFaceLockInterface mFaceLockService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.613 -0400", hash_original_field = "363063BFE019255B59F28635EE33CB65", hash_generated_field = "6526713C9EC088738DD4DF660542E93B")

    private boolean mBoundToFaceLockService = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.614 -0400", hash_original_field = "CC43710969EDC14887F721ACC2ACFFAF", hash_generated_field = "47EE3C3997A7FBFBEF115728F32D5939")

    private View mFaceLockAreaView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.614 -0400", hash_original_field = "DE8D27B069224EBC29E5E0FEB7C78B41", hash_generated_field = "1492876F14D692C5C2F580745CA2FD52")

    private boolean mFaceLockServiceRunning = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.614 -0400", hash_original_field = "C5C5CE2580EB9BBCDAB19FFE638D6467", hash_generated_field = "4D4E1EF5BEE713822BC57BD330539852")

    private final Object mFaceLockServiceRunningLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.614 -0400", hash_original_field = "6BB43B6063EBB36EA19D217D6AF015D2", hash_generated_field = "8107DF57BB16EF453100BE466A4FF6B7")

    private final Object mFaceLockStartupLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.614 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

    private Handler mHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.614 -0400", hash_original_field = "28E89A51D16287DF0A6A8BDA24CE68CA", hash_generated_field = "EA8BA5F65C2DB93238DF169F536569D7")

    private final int MSG_SHOW_FACELOCK_AREA_VIEW = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.614 -0400", hash_original_field = "ADA858C75265EBEFF97134F6651D2582", hash_generated_field = "142D2BDBAD534BA58F1622D0350D03A9")

    private final int MSG_HIDE_FACELOCK_AREA_VIEW = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.615 -0400", hash_original_field = "81E0FC48B151529FAF102F304BADE076", hash_generated_field = "79D05731B55D4ED21735937D4F5B5C13")

    private final int FACELOCK_VIEW_AREA_EMERGENCY_DIALER_TIMEOUT = 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.615 -0400", hash_original_field = "B27F014A952C0379223359F80841D65E", hash_generated_field = "0BB329739F9C67006280CB4AD59B172C")

    private final int FACELOCK_VIEW_AREA_SERVICE_TIMEOUT = 3000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.615 -0400", hash_original_field = "34CF2AB2D09B9F94B161C652F30F22A1", hash_generated_field = "7836B012C99E16CC5F1147E9F179E6B8")

    private final int BACKUP_LOCK_TIMEOUT = 5000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.615 -0400", hash_original_field = "E751CDD499A6AA7908E09FEDA3F061DA", hash_generated_field = "A65934AED30537A80CB103E90B4F5AE5")

    private int mFailedFaceUnlockAttempts = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.615 -0400", hash_original_field = "D19F1A3B5DFBCF2266F539DEC98F952C", hash_generated_field = "1C860327CBD45D9826BD224D24C43873")

    KeyguardScreenCallback mKeyguardScreenCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.615 -0400", hash_original_field = "8714D6B290024F542B0D9C5BDBDF538A", hash_generated_field = "6ECF2B8DE1BF37CCF0239C16C6BECEA6")

    private boolean mRequiresSim;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.615 -0400", hash_original_field = "AABE8E795666FA6C797CA086E962B25B", hash_generated_field = "CA4F0D39D8A4563492B99D83E98D9A6E")

    private boolean mHasOverlay;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.616 -0400", hash_original_field = "8BD90DBF7B1ADDA42C359DD765170FB3", hash_generated_field = "1D02A8ADA62A3E26DB345B829694E98E")

    private Mode mMode = Mode.LockScreen;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.616 -0400", hash_original_field = "1868799358AECBD9251FDBF7EAC79C03", hash_generated_field = "BD42D371EFB30D0D5B2C27EC3CA6818D")

    private UnlockMode mUnlockScreenMode = UnlockMode.Unknown;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.616 -0400", hash_original_field = "EA3E18FF92A6C0E98827080580FC843F", hash_generated_field = "BD75BEF56DAE78E8CC1C81A87A3A7D2D")

    private boolean mForgotPattern;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.616 -0400", hash_original_field = "6381692E023F366D9D9585B8F354646D", hash_generated_field = "D8ACF29D1CE41BB9DE7CFCD9B16B8BF1")

    private boolean mIsVerifyUnlockOnly = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.616 -0400", hash_original_field = "EAA1758ACB8C3815224ED7417E5328B5", hash_generated_field = "FB69BB5EA99FF1AC6B151A37F4FEA26C")

    private LockPatternUtils mLockPatternUtils;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.616 -0400", hash_original_field = "2A37B83F421C69FA65AB0336DCD40F61", hash_generated_field = "9B9B88487B30E1BFDA8237815507FB38")

    private Configuration mConfiguration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.618 -0400", hash_original_field = "7A7F6D3F771291D0FDBD5C66DE7ED576", hash_generated_field = "62DCF6B68ADA88835481832232448444")

    private Runnable mRecreateRunnable = new Runnable()    {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.617 -0400", hash_original_method = "8617D22CA4CAD1831E5EB38D740CA3F4", hash_generated_method = "DCCCC1AD8C1E7DC06F984B054D40DE49")
        public void run() {
updateScreen(mMode, true)restoreWidgetState()
            // ---------- Original Method ----------
            //updateScreen(mMode, true);
            //restoreWidgetState();
        }

        
    }
;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.622 -0400", hash_original_field = "8E5C5C78E215B8A02D546939CC931A2C", hash_generated_field = "C65323D8A3050C853A7F017B13D565F7")

    private LockScreenWidgetCallback mWidgetCallback = new LockScreenWidgetCallback()    {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.618 -0400", hash_original_method = "BB8090B207C5CF299E131DF55B032898", hash_generated_method = "126E80A6E1CBCBA570459FD38BF729E1")
        public void userActivity(View self) {
            addTaint(self.getTaint());
mKeyguardScreenCallback.pokeWakelock(TRANSPORT_USERACTIVITY_TIMEOUT)
            // ---------- Original Method ----------
            //mKeyguardScreenCallback.pokeWakelock(TRANSPORT_USERACTIVITY_TIMEOUT);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.619 -0400", hash_original_method = "6473BF8B50328BEEFE46E77EAD6A97DB", hash_generated_method = "19BC6A9F93A7F9DF40F6E929EA509FB5")
        public void requestShow(View view) {
            addTaint(view.getTaint());
            if(DEBUG){ }view.setVisibility(View.VISIBLE)mUpdateMonitor.reportClockVisible(false)            if(findViewById(R.id.transport_bg_protect)==null)            
            {
setBackgroundColor(0xff000000)
            } //End block
            else
            {
resetBackground()
            } //End block
            // ---------- Original Method ----------
            //if (DEBUG) Log.v(TAG, "View " + view + " requested show transports");
            //view.setVisibility(View.VISIBLE);
            //mUpdateMonitor.reportClockVisible(false);
            //if (findViewById(R.id.transport_bg_protect) == null) {
                //setBackgroundColor(0xff000000);
            //} else {
                //resetBackground();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.620 -0400", hash_original_method = "B4EF15CCC0FAE7D6C2B884D298390942", hash_generated_method = "AA783AA5F86D67291583364A7613D47F")
        public void requestHide(View view) {
            addTaint(view.getTaint());
            if(DEBUG){ }view.setVisibility(View.GONE)mUpdateMonitor.reportClockVisible(true)resetBackground()
            // ---------- Original Method ----------
            //if (DEBUG) Log.v(TAG, "View " + view + " requested hide transports");
            //view.setVisibility(View.GONE);
            //mUpdateMonitor.reportClockVisible(true);
            //resetBackground();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.621 -0400", hash_original_method = "F78367B33C50956A345FE1820EFDC92F", hash_generated_method = "6A85534417E119A84F785DACCA78BE7C")
        public boolean isVisible(View self) {
            addTaint(self.getTaint());
            boolean var2F1130BFF7F38F4CF082065EFAD7F6E6_4330297 = (self.getVisibility()==View.VISIBLE);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2025505217 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2025505217;
            // ---------- Original Method ----------
            //return self.getVisibility() == View.VISIBLE;
        }

        
    }
;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.622 -0400", hash_original_field = "63E5F3DFD7A0222949E2539594122D5C", hash_generated_field = "730ACBAA783CBFA918E41C49E0B1B4D2")

    private TransportControlView mTransportControlView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.622 -0400", hash_original_field = "CE4C1836B804AD6C5F768D9D49C10FED", hash_generated_field = "EA4FACD9AD58FC490EFFECA331AA22E8")

    private Parcelable mSavedState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.625 -0400", hash_original_field = "6F9F582DA4D325F287BDF836AD25C15C", hash_generated_field = "D69D98DDBF2C34FA5F72D9067A7BDD0D")

    private ServiceConnection mFaceLockConnection = new ServiceConnection()    {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.624 -0400", hash_original_method = "F100E38BF3E48D6EF9E1C1EF4B04B2CA", hash_generated_method = "66E6011C167AD7577FE439128BED8FEF")
        @Override
        public void onServiceConnected(ComponentName className, IBinder iservice) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(iservice.getTaint());
            addTaint(className.getTaint());
mFaceLockService=IFaceLockInterface.Stub.asInterface(iservice)            if(DEBUG)            
Log.d(TAG, "Connected to FaceLock service")
            try 
            {
mFaceLockService.registerCallback(mFaceLockCallback)
            } //End block
            catch (RemoteException e)
            {
mFaceLockService=nullmBoundToFaceLockService=false                return;
            } //End block
            if(mFaceLockAreaView!=null)            
            {
                int[] faceLockPosition;
faceLockPosition=new intmFaceLockAreaView.getLocationInWindow(faceLockPosition)startFaceLock(mFaceLockAreaView.getWindowToken(), faceLockPosition[0], faceLockPosition[1], mFaceLockAreaView.getWidth(), mFaceLockAreaView.getHeight())
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.625 -0400", hash_original_method = "5E67C7C0E0AC474A784DA69F6AC36961", hash_generated_method = "5C9FA289BD4CBD4F9B4EF1B22F6192FC")
        @Override
        public void onServiceDisconnected(ComponentName className) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(className.getTaint());
            synchronized
(mFaceLockServiceRunningLock)            {
mFaceLockService=nullmFaceLockServiceRunning=false
            } //End block
mBoundToFaceLockService=false
            // ---------- Original Method ----------
            //synchronized(mFaceLockServiceRunningLock) {
                //mFaceLockService = null;
                //mFaceLockServiceRunning = false;
            //}
            //mBoundToFaceLockService = false;
            //Log.w(TAG, "Unexpected disconnect from FaceLock service");
        }

        
    }
;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.629 -0400", hash_original_field = "90056D27D933C4358D59697E72275497", hash_generated_field = "5ACCF2B707A686DBBB9E5F427B60C239")

    private final IFaceLockCallback mFaceLockCallback = new IFaceLockCallback.Stub()    {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.626 -0400", hash_original_method = "17D035C7CF03CC6C45B16210DA237716", hash_generated_method = "E063D98B22F48770984AC0CA12D06B9E")
        @Override
        public void unlock() {
            if(DEBUG)            
Log.d(TAG, "FaceLock unlock()")
showFaceLockArea()stopAndUnbindFromFaceLock()mKeyguardScreenCallback.keyguardDone(true)mKeyguardScreenCallback.reportSuccessfulUnlockAttempt()
            // ---------- Original Method ----------
            //if (DEBUG) Log.d(TAG, "FaceLock unlock()");
            //showFaceLockArea();
            //stopAndUnbindFromFaceLock();
            //mKeyguardScreenCallback.keyguardDone(true);
            //mKeyguardScreenCallback.reportSuccessfulUnlockAttempt();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.627 -0400", hash_original_method = "A9A64500E6F3E5EB1DF66594E9D28724", hash_generated_method = "EA0F7E6E507122ED32931DC1BBD5B1B5")
        @Override
        public void cancel() {
            if(DEBUG)            
Log.d(TAG, "FaceLock cancel()")
hideFaceLockArea()stopAndUnbindFromFaceLock()mKeyguardScreenCallback.pokeWakelock(BACKUP_LOCK_TIMEOUT)
            // ---------- Original Method ----------
            //if (DEBUG) Log.d(TAG, "FaceLock cancel()");
            //hideFaceLockArea();
            //stopAndUnbindFromFaceLock();
            //mKeyguardScreenCallback.pokeWakelock(BACKUP_LOCK_TIMEOUT);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.628 -0400", hash_original_method = "C42B48EEDD05ED63F49EA71ABFE210DF", hash_generated_method = "AB58F44C58D922952DDE221D02D97EEC")
        @Override
        public void reportFailedAttempt() {
            if(DEBUG)            
Log.d(TAG, "FaceLock reportFailedAttempt()")
mFailedFaceUnlockAttemptshideFaceLockArea()stopAndUnbindFromFaceLock()mKeyguardScreenCallback.pokeWakelock(BACKUP_LOCK_TIMEOUT)
            // ---------- Original Method ----------
            //if (DEBUG) Log.d(TAG, "FaceLock reportFailedAttempt()");
            //mFailedFaceUnlockAttempts++;
            //hideFaceLockArea();
            //stopAndUnbindFromFaceLock();
            //mKeyguardScreenCallback.pokeWakelock(BACKUP_LOCK_TIMEOUT);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.628 -0400", hash_original_method = "F9AB4B38888E1D7E55F5F8DA59E47E13", hash_generated_method = "BE9CD0EA45D6B7C290D66388F3B898CE")
        @Override
        public void exposeFallback() {
            if(DEBUG)            
Log.d(TAG, "FaceLock exposeFallback()")
hideFaceLockArea()
            // ---------- Original Method ----------
            //if (DEBUG) Log.d(TAG, "FaceLock exposeFallback()");
            //hideFaceLockArea();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.629 -0400", hash_original_method = "5AC01614A9DFBC61CC1432C028E12BDB", hash_generated_method = "12884BDFF1828EEEB855C13D55786856")
        @Override
        public void pokeWakelock() {
            if(DEBUG)            
Log.d(TAG, "FaceLock pokeWakelock()")
mKeyguardScreenCallback.pokeWakelock()
            // ---------- Original Method ----------
            //if (DEBUG) Log.d(TAG, "FaceLock pokeWakelock()");
            //mKeyguardScreenCallback.pokeWakelock();
        }

        
    }
;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.642 -0400", hash_original_method = "12FFFA6EADBC048780C81764326809B4", hash_generated_method = "F96535259E0B99CE3F87934EB0D7A8A1")
    public  LockPatternKeyguardView(
            Context context,
            KeyguardUpdateMonitor updateMonitor,
            LockPatternUtils lockPatternUtils,
            KeyguardWindowController controller) {
        super(context);
        addTaint(controller.getTaint());
        addTaint(lockPatternUtils.getTaint());
        addTaint(updateMonitor.getTaint());
        addTaint(context.getTaint());
mHandler=new Handler(this)mConfiguration=context.getResources().getConfiguration()mEnableFallback=falsemRequiresSim=TextUtils.isEmpty(SystemProperties.get("keyguard.no_require_sim"))mUpdateMonitor=updateMonitormLockPatternUtils=lockPatternUtilsmWindowController=controllermHasOverlay=falsemUpdateMonitor.registerInfoCallback(this)mKeyguardScreenCallback=new KeyguardScreenCallback()        {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.631 -0400", hash_original_method = "DAE7750A9BABCF8B8D1A56C1C75F951F", hash_generated_method = "E56EC4798268E5916D73E4F84D7EEAB5")
        public void goToLockScreen() {
mForgotPattern=false            if(mIsVerifyUnlockOnly)            
            {
mIsVerifyUnlockOnly=falsegetCallback().keyguardDone(false)
            } //End block
            else
            {
updateScreen(Mode.LockScreen, false)
            } //End block
            // ---------- Original Method ----------
            //mForgotPattern = false;
            //if (mIsVerifyUnlockOnly) {
                    //mIsVerifyUnlockOnly = false;
                    //getCallback().keyguardDone(false);
                //} else {
                    //updateScreen(Mode.LockScreen, false);
                //}
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.632 -0400", hash_original_method = "4993DFB805C9A3A15F1824C64B1563C5", hash_generated_method = "22088F97060FD79DF54E6EDED1AA1496")
        public void goToUnlockScreen() {
            final IccCard.State simState = mUpdateMonitor.getSimState();
            if(stuckOnLockScreenBecauseSimMissing()||(simState==IccCard.State.PUK_REQUIRED&&!mLockPatternUtils.isPukUnlockScreenEnable()))            
            {
                return;
            } //End block
            if(!isSecure())            
            {
getCallback().keyguardDone(true)
            } //End block
            else
            {
updateScreen(Mode.UnlockScreen, false)
            } //End block
            // ---------- Original Method ----------
            //final IccCard.State simState = mUpdateMonitor.getSimState();
            //if (stuckOnLockScreenBecauseSimMissing()
                         //|| (simState == IccCard.State.PUK_REQUIRED
                             //&& !mLockPatternUtils.isPukUnlockScreenEnable())){
                    //return;
                //}
            //if (!isSecure()) {
                    //getCallback().keyguardDone(true);
                //} else {
                    //updateScreen(Mode.UnlockScreen, false);
                //}
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.633 -0400", hash_original_method = "C32E95E24435162456514A57FAF3669A", hash_generated_method = "DA4DC6CCF543A93698902F08427390B0")
        public void forgotPattern(boolean isForgotten) {
            addTaint(isForgotten);
            if(mEnableFallback)            
            {
mForgotPattern=isForgottenupdateScreen(Mode.UnlockScreen, false)
            } //End block
            // ---------- Original Method ----------
            //if (mEnableFallback) {
                    //mForgotPattern = isForgotten;
                    //updateScreen(Mode.UnlockScreen, false);
                //}
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.633 -0400", hash_original_method = "2CD33A151F4E8FF51FE5D315CBCA96DF", hash_generated_method = "AF777F40416E289CC4F9719A4D0502FD")
        public boolean isSecure() {
            boolean var57C4F8A889F35FE102E6D7EEAA1A8964_1803764832 = (LockPatternKeyguardView.this.isSecure());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_192981722 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_192981722;
            // ---------- Original Method ----------
            //return LockPatternKeyguardView.this.isSecure();
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.634 -0400", hash_original_method = "D58CC1EC3F5C22CE4D3CF11D83EF6E86", hash_generated_method = "7823940CBBF45388DD1C6F4CA4427F90")
        public boolean isVerifyUnlockOnly() {
            boolean var0880F6F147A0A2C49828D331166AF159_1707411001 = (mIsVerifyUnlockOnly);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1195193870 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1195193870;
            // ---------- Original Method ----------
            //return mIsVerifyUnlockOnly;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.635 -0400", hash_original_method = "E22C1B94AA2D693C9CDE7050D580B759", hash_generated_method = "89BA825F0662C510FDFE90880FB25A00")
        public void recreateMe(Configuration config) {
            addTaint(config.getTaint());
removeCallbacks(mRecreateRunnable)post(mRecreateRunnable)
            // ---------- Original Method ----------
            //removeCallbacks(mRecreateRunnable);
            //post(mRecreateRunnable);
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.635 -0400", hash_original_method = "ED8AB936D4B8E9CA74646E724F4C6505", hash_generated_method = "F0004DFD437A6A56AB5A7F58A730465D")
        public void takeEmergencyCallAction() {
mHasOverlay=true            if(usingFaceLock()&&mFaceLockServiceRunning)            
            {
showFaceLockAreaWithTimeout(FACELOCK_VIEW_AREA_EMERGENCY_DIALER_TIMEOUT)
            } //End block
stopAndUnbindFromFaceLock()pokeWakelock(EMERGENCY_CALL_TIMEOUT)            if(TelephonyManager.getDefault().getCallState()==TelephonyManager.CALL_STATE_OFFHOOK)            
            {
mLockPatternUtils.resumeCall()
            } //End block
            else
            {
                Intent intent = new Intent(ACTION_EMERGENCY_DIAL);
intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS)getContext().startActivity(intent)
            } //End block
            // ---------- Original Method ----------
            //mHasOverlay = true;
            //if (usingFaceLock() && mFaceLockServiceRunning) {
                    //showFaceLockAreaWithTimeout(FACELOCK_VIEW_AREA_EMERGENCY_DIALER_TIMEOUT);
                //}
            //stopAndUnbindFromFaceLock();
            //pokeWakelock(EMERGENCY_CALL_TIMEOUT);
            //if (TelephonyManager.getDefault().getCallState()
                        //== TelephonyManager.CALL_STATE_OFFHOOK) {
                    //mLockPatternUtils.resumeCall();
                //} else {
                    //Intent intent = new Intent(ACTION_EMERGENCY_DIAL);
                    //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                            //| Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                    //getContext().startActivity(intent);
                //}
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.636 -0400", hash_original_method = "4D440C5FF62D0BDCE3EACDD4974096C2", hash_generated_method = "D00BAA602F9B856331D741DFFF3FFAFE")
        public void pokeWakelock() {
getCallback().pokeWakelock()
            // ---------- Original Method ----------
            //getCallback().pokeWakelock();
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.637 -0400", hash_original_method = "24F37B5F78D597EFA090E0F8267295BA", hash_generated_method = "7EA20000DAF65FAFBB8CB434317300E7")
        public void pokeWakelock(int millis) {
            addTaint(millis);
getCallback().pokeWakelock(millis)
            // ---------- Original Method ----------
            //getCallback().pokeWakelock(millis);
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.637 -0400", hash_original_method = "468DC39C4A208FFBB9E29CE629E66F49", hash_generated_method = "68573F49E62D591E0233BB00FA262FE6")
        public void keyguardDone(boolean authenticated) {
            addTaint(authenticated);
getCallback().keyguardDone(authenticated)mSavedState=null
            // ---------- Original Method ----------
            //getCallback().keyguardDone(authenticated);
            //mSavedState = null;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.638 -0400", hash_original_method = "0E8965BBF10F43F11F53D9606B928F81", hash_generated_method = "5D9AF1ABC811997AAFC93A89266FD5F1")
        public void keyguardDoneDrawing() {
            // ---------- Original Method ----------
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.639 -0400", hash_original_method = "FE54DFDCEAACBFE0EEB2CF27A1C7C56E", hash_generated_method = "0DFA28FC6E5A1270078114BA23891EE4")
        public void reportFailedUnlockAttempt() {
mUpdateMonitor.reportFailedAttempt()            final int failedAttempts = mUpdateMonitor.getFailedAttempts();
            if(DEBUG)            
Log.d(TAG, "reportFailedPatternAttempt: #"+failedAttempts+" (enableFallback="+mEnableFallback+")")
            final boolean usingPattern = mLockPatternUtils.getKeyguardStoredPasswordQuality()
                        == DevicePolicyManager.PASSWORD_QUALITY_SOMETHING;
            final int failedAttemptsBeforeWipe = mLockPatternUtils.getDevicePolicyManager()
                        .getMaximumFailedPasswordsForWipe(null);
            final int failedAttemptWarning = LockPatternUtils.FAILED_ATTEMPTS_BEFORE_RESET
                        - LockPatternUtils.FAILED_ATTEMPTS_BEFORE_TIMEOUT;
            final int remainingBeforeWipe = failedAttemptsBeforeWipe > 0 ?
                        (failedAttemptsBeforeWipe - failedAttempts)
                        : Integer.MAX_VALUE;
            if(remainingBeforeWipe<LockPatternUtils.FAILED_ATTEMPTS_BEFORE_WIPE_GRACE)            
            {
                if(remainingBeforeWipe>0)                
                {
showAlmostAtWipeDialog(failedAttempts, remainingBeforeWipe)
                } //End block
                else
                {
showWipeDialog(failedAttempts)
                } //End block
            } //End block
            else
            {
                boolean showTimeout = (failedAttempts % LockPatternUtils.FAILED_ATTEMPTS_BEFORE_TIMEOUT) == 0;
                if(usingPattern&&mEnableFallback)                
                {
                    if(failedAttempts==failedAttemptWarning)                    
                    {
showAlmostAtAccountLoginDialog()showTimeout=false
                    } //End block
                    else
                    if(failedAttempts>=LockPatternUtils.FAILED_ATTEMPTS_BEFORE_RESET)                    
                    {
mLockPatternUtils.setPermanentlyLocked(true)updateScreen(mMode, false)showTimeout=false
                    } //End block
                } //End block
                if(showTimeout)                
                {
showTimeoutDialog()
                } //End block
            } //End block
mLockPatternUtils.reportFailedPasswordAttempt()
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.641 -0400", hash_original_method = "97806899AC7AC15D91B592A7C1C20429", hash_generated_method = "62F65054C07AB45DB86B535D5492A9AA")
        public boolean doesFallbackUnlockScreenExist() {
            boolean var0E52283E4B12B2F3A8BC966856829B09_841732784 = (mEnableFallback);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_335755503 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_335755503;
            // ---------- Original Method ----------
            //return mEnableFallback;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.641 -0400", hash_original_method = "26FC3ECCC82AD0BCDDD63DDA1C29FE48", hash_generated_method = "6FB9C2F20D62B1DD6C2180113B7A188E")
        public void reportSuccessfulUnlockAttempt() {
mFailedFaceUnlockAttempts=0mLockPatternUtils.reportSuccessfulPasswordAttempt()
            // ---------- Original Method ----------
            //mFailedFaceUnlockAttempts = 0;
            //mLockPatternUtils.reportSuccessfulPasswordAttempt();
        }
        }
setFocusableInTouchMode(true)setDescendantFocusability(FOCUS_AFTER_DESCENDANTS)updateScreen(getInitialMode(), false)maybeEnableFallback(context)
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.644 -0400", hash_original_method = "316B3102F81FA45FAA40C328F904E902", hash_generated_method = "F162EECB68898ED731CC3BD19CD4CEC2")
    private boolean stuckOnLockScreenBecauseSimMissing() {
        boolean varE10AE555F0E882FEA2D8EFBDB0FA9363_726556836 = (mRequiresSim&&(!mUpdateMonitor.isDeviceProvisioned())&&(mUpdateMonitor.getSimState()==IccCard.State.ABSENT||mUpdateMonitor.getSimState()==IccCard.State.PERM_DISABLED));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_645736472 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_645736472;
        // ---------- Original Method ----------
        //return mRequiresSim
                //&& (!mUpdateMonitor.isDeviceProvisioned())
                //&& (mUpdateMonitor.getSimState() == IccCard.State.ABSENT ||
                    //mUpdateMonitor.getSimState() == IccCard.State.PERM_DISABLED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.645 -0400", hash_original_method = "D6A22B8AAF0E1D86494DECC5407A921B", hash_generated_method = "C33E7F16A2C6FAE1D96B10BF0CA68201")
    private void maybeEnableFallback(Context context) {
        addTaint(context.getTaint());
        AccountAnalyzer accountAnalyzer = new AccountAnalyzer(AccountManager.get(context));
accountAnalyzer.start()
        // ---------- Original Method ----------
        //AccountAnalyzer accountAnalyzer = new AccountAnalyzer(AccountManager.get(context));
        //accountAnalyzer.start();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.647 -0400", hash_original_method = "3357081EF3B3F64B7B1E6070092DA737", hash_generated_method = "6BEF9AAE10C2D3E98AA308152B5CF361")
    @Override
    protected void dispatchDraw(Canvas canvas) {
        addTaint(canvas.getTaint());
        if(DEBUG){ }super.dispatchDraw(canvas)
        // ---------- Original Method ----------
        //if (DEBUG) Log.v(TAG, "*** dispatchDraw() time: " + SystemClock.elapsedRealtime());
        //super.dispatchDraw(canvas);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.648 -0400", hash_original_method = "E073660F851D8B09E09ADA073623F8AD", hash_generated_method = "9D7E48DDD79D931534FD5E2D9CD056C0")
    @Override
    public void reset() {
mIsVerifyUnlockOnly=falsemForgotPattern=falsepost(mRecreateRunnable)
        // ---------- Original Method ----------
        //mIsVerifyUnlockOnly = false;
        //mForgotPattern = false;
        //post(mRecreateRunnable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.649 -0400", hash_original_method = "EEE8218031E051D8A6CCAA0DF5CBD9C4", hash_generated_method = "A2AD46423CD66AF42F771F7FE7B635CC")
    @Override
    public void onScreenTurnedOff() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        if(DEBUG)        
Log.d(TAG, "screen off")
mScreenOn=falsemForgotPattern=falsemHasOverlay=mUpdateMonitor.getPhoneState()!=TelephonyManager.CALL_STATE_IDLE        if(mLockScreen!=null)        
        {
((KeyguardScreen) mLockScreen).onPause()
        } //End block
        if(mUnlockScreen!=null)        
        {
((KeyguardScreen) mUnlockScreen).onPause()
        } //End block
saveWidgetState()stopAndUnbindFromFaceLock()
        // ---------- Original Method ----------
        //if (DEBUG) Log.d(TAG, "screen off");
        //mScreenOn = false;
        //mForgotPattern = false;
        //mHasOverlay = mUpdateMonitor.getPhoneState() != TelephonyManager.CALL_STATE_IDLE;
        //if (mLockScreen != null) {
            //((KeyguardScreen) mLockScreen).onPause();
        //}
        //if (mUnlockScreen != null) {
            //((KeyguardScreen) mUnlockScreen).onPause();
        //}
        //saveWidgetState();
        //stopAndUnbindFromFaceLock();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.650 -0400", hash_original_method = "C8B178877EC04AC85075E9F7613741FA", hash_generated_method = "7C0C2FB5EF90CAF41732C25D5C24321F")
    private void activateFaceLockIfAble() {
        final boolean tooManyFaceUnlockTries = (mFailedFaceUnlockAttempts >= FAILED_FACE_UNLOCK_ATTEMPTS_BEFORE_BACKUP);
        final int failedBackupAttempts = mUpdateMonitor.getFailedAttempts();
        final boolean backupIsTimedOut = (failedBackupAttempts >= LockPatternUtils.FAILED_ATTEMPTS_BEFORE_TIMEOUT);
        if(tooManyFaceUnlockTries){ }        if(mUpdateMonitor.getPhoneState()==TelephonyManager.CALL_STATE_IDLE&&usingFaceLock()&&!mHasOverlay&&!tooManyFaceUnlockTries&&!backupIsTimedOut)        
        {
bindToFaceLock()showFaceLockAreaWithTimeout(FACELOCK_VIEW_AREA_SERVICE_TIMEOUT)mKeyguardScreenCallback.pokeWakelock()
        } //End block
        else
        {
hideFaceLockArea()
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.651 -0400", hash_original_method = "CCD392B6784E30BF5BE18F0EDB091ECB", hash_generated_method = "0CB14247BC4621B85DFF507F02F4D9A5")
    @Override
    public void onScreenTurnedOn() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        if(DEBUG)        
Log.d(TAG, "screen on")
        boolean runFaceLock = false;
        synchronized
(mFaceLockStartupLock)        {
mScreenOn=truerunFaceLock=mWindowFocused
        } //End block
show()restoreWidgetState()        if(runFaceLock)        
activateFaceLockIfAble()
        // ---------- Original Method ----------
        //if (DEBUG) Log.d(TAG, "screen on");
        //boolean runFaceLock = false;
        //synchronized(mFaceLockStartupLock) {
            //mScreenOn = true;
            //runFaceLock = mWindowFocused;
        //}
        //show();
        //restoreWidgetState();
        //if (runFaceLock) activateFaceLockIfAble();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.652 -0400", hash_original_method = "06D4E7A3FB69E40962267F88FAA2FD0E", hash_generated_method = "DA9F6D3DABBB430FF611A7F21D75118B")
    private void saveWidgetState() {
        if(mTransportControlView!=null)        
        {
            if(DEBUG){ }mSavedState=mTransportControlView.onSaveInstanceState()
        } //End block
        // ---------- Original Method ----------
        //if (mTransportControlView != null) {
            //if (DEBUG) Log.v(TAG, "Saving widget state");
            //mSavedState = mTransportControlView.onSaveInstanceState();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.654 -0400", hash_original_method = "EB0ADA8013A8404F7538148C50C40953", hash_generated_method = "35E3D243A4A2C786C412933C529E0379")
    private void restoreWidgetState() {
        if(mTransportControlView!=null)        
        {
            if(DEBUG){ }            if(mSavedState!=null)            
            {
mTransportControlView.onRestoreInstanceState(mSavedState)
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mTransportControlView != null) {
            //if (DEBUG) Log.v(TAG, "Restoring widget state");
            //if (mSavedState != null) {
                //mTransportControlView.onRestoreInstanceState(mSavedState);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.655 -0400", hash_original_method = "9078EE146CCF96D7E62521E9952D0D0B", hash_generated_method = "5B990588BBC9CB6FDBA161D833B80AFC")
    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(hasWindowFocus);
        if(DEBUG)        
Log.d(TAG, hasWindowFocus?"focused":"focused")
        boolean runFaceLock = false;
        synchronized
(mFaceLockStartupLock)        {
            if(mScreenOn&&!mWindowFocused)            
runFaceLock=hasWindowFocus
mWindowFocused=hasWindowFocus
        } //End block
        if(!hasWindowFocus)        
        {
mHasOverlay=truestopAndUnbindFromFaceLock()hideFaceLockArea()
        } //End block
        else
        if(runFaceLock)        
        {
activateFaceLockIfAble()
        } //End block
        // ---------- Original Method ----------
        //if (DEBUG) Log.d(TAG, hasWindowFocus ? "focused" : "unfocused");
        //boolean runFaceLock = false;
        //synchronized(mFaceLockStartupLock) {
            //if(mScreenOn && !mWindowFocused) runFaceLock = hasWindowFocus;
            //mWindowFocused = hasWindowFocus;
        //}
        //if(!hasWindowFocus) {
            //mHasOverlay = true;
            //stopAndUnbindFromFaceLock();
            //hideFaceLockArea();
        //} else if (runFaceLock) {
            //activateFaceLockIfAble();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.657 -0400", hash_original_method = "42ECBC2072487A60F4FF5757020157A6", hash_generated_method = "666C633FACC9F9F6F2FF18E2C7B0F838")
    @Override
    public void show() {
        if(mLockScreen!=null)        
        {
((KeyguardScreen) mLockScreen).onResume()
        } //End block
        if(mUnlockScreen!=null)        
        {
((KeyguardScreen) mUnlockScreen).onResume()
        } //End block
        if(usingFaceLock()&&!mHasOverlay)        
        {
showFaceLockArea()
        } //End block
        else
        {
hideFaceLockArea()
        } //End block
        // ---------- Original Method ----------
        //if (mLockScreen != null) {
            //((KeyguardScreen) mLockScreen).onResume();
        //}
        //if (mUnlockScreen != null) {
            //((KeyguardScreen) mUnlockScreen).onResume();
        //}
        //if (usingFaceLock() && !mHasOverlay) {
            //showFaceLockArea();
        //} else {
            //hideFaceLockArea();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.658 -0400", hash_original_method = "7178352850B0278466F75DE097CD9E12", hash_generated_method = "4A03965C61D81953470DA59436AA621A")
    private void recreateLockScreen() {
        if(mLockScreen!=null)        
        {
((KeyguardScreen) mLockScreen).onPause()((KeyguardScreen) mLockScreen).cleanUp()removeView(mLockScreen)
        } //End block
mLockScreen=createLockScreen()mLockScreen.setVisibility(View.INVISIBLE)addView(mLockScreen)
        // ---------- Original Method ----------
        //if (mLockScreen != null) {
            //((KeyguardScreen) mLockScreen).onPause();
            //((KeyguardScreen) mLockScreen).cleanUp();
            //removeView(mLockScreen);
        //}
        //mLockScreen = createLockScreen();
        //mLockScreen.setVisibility(View.INVISIBLE);
        //addView(mLockScreen);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.659 -0400", hash_original_method = "DDFCFB6C4288332A07CFE770628F69EF", hash_generated_method = "A56BBC81C21B6395775CF1CD5176E3D1")
    private void recreateUnlockScreen(UnlockMode unlockMode) {
        addTaint(unlockMode.getTaint());
        if(mUnlockScreen!=null)        
        {
((KeyguardScreen) mUnlockScreen).onPause()((KeyguardScreen) mUnlockScreen).cleanUp()removeView(mUnlockScreen)
        } //End block
mUnlockScreen=createUnlockScreenFor(unlockMode)mUnlockScreen.setVisibility(View.INVISIBLE)addView(mUnlockScreen)
        // ---------- Original Method ----------
        //if (mUnlockScreen != null) {
            //((KeyguardScreen) mUnlockScreen).onPause();
            //((KeyguardScreen) mUnlockScreen).cleanUp();
            //removeView(mUnlockScreen);
        //}
        //mUnlockScreen = createUnlockScreenFor(unlockMode);
        //mUnlockScreen.setVisibility(View.INVISIBLE);
        //addView(mUnlockScreen);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.659 -0400", hash_original_method = "0CB6E34CB8183F396725133990778AC5", hash_generated_method = "D23817B72A6FC25DFB663B33918C50BD")
    @Override
    protected void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
removeCallbacks(mRecreateRunnable)stopAndUnbindFromFaceLock()super.onDetachedFromWindow()
        // ---------- Original Method ----------
        //removeCallbacks(mRecreateRunnable);
        //stopAndUnbindFromFaceLock();
        //super.onDetachedFromWindow();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.660 -0400", hash_original_method = "B56C1F5E7F51D34E8DD5A0E47EBFE8BA", hash_generated_method = "D872826E4A6A941B1CEB48E5B82329D5")
    protected void onConfigurationChanged(Configuration newConfig) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(newConfig.getTaint());
        Resources resources = getResources();
mShowLockBeforeUnlock=resources.getBoolean(R.bool.config_enableLockBeforeUnlockScreen)mConfiguration=newConfig        if(DEBUG_CONFIGURATION){ }saveWidgetState()removeCallbacks(mRecreateRunnable)post(mRecreateRunnable)
        // ---------- Original Method ----------
        //Resources resources = getResources();
        //mShowLockBeforeUnlock = resources.getBoolean(R.bool.config_enableLockBeforeUnlockScreen);
        //mConfiguration = newConfig;
        //if (DEBUG_CONFIGURATION) Log.v(TAG, "**** re-creating lock screen since config changed");
        //saveWidgetState();
        //removeCallbacks(mRecreateRunnable);
        //post(mRecreateRunnable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.661 -0400", hash_original_method = "4D8D83CF6E23DB5409DEF076CF56C21F", hash_generated_method = "13D1AAB5D8A91810E9676325DB05BA74")
    @Override
    public void onRefreshBatteryInfo(boolean showBatteryInfo, boolean pluggedIn, int batteryLevel) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(batteryLevel);
        addTaint(pluggedIn);
        addTaint(showBatteryInfo);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.661 -0400", hash_original_method = "434A1591B741E49285DB2249C0490224", hash_generated_method = "4A32ED83132B4916B02B494E0EFC3618")
    @Override
    public void onTimeChanged() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.662 -0400", hash_original_method = "4BA21EF23ECF97F1E021A0EA81C75239", hash_generated_method = "B57D30F9B5173C53ECA9D47EDFBF7931")
    @Override
    public void onRefreshCarrierInfo(CharSequence plmn, CharSequence spn) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(spn.getTaint());
        addTaint(plmn.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.663 -0400", hash_original_method = "BA0B67437B81C41F05DFFCECF2CA0F9A", hash_generated_method = "3F085565C8A224FE76D934647DE8E616")
    @Override
    public void onRingerModeChanged(int state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(state);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.664 -0400", hash_original_method = "8F5239C2CE3F3DE119BB3646155B73F9", hash_generated_method = "16C870736AE33AF57E1CBCD131EAF60B")
    @Override
    public void onClockVisibilityChanged() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        int visFlags = getSystemUiVisibility() & ~View.STATUS_BAR_DISABLE_CLOCK;
setSystemUiVisibility(visFlags|(mUpdateMonitor.isClockVisible()?View.STATUS_BAR_DISABLE_CLOCK:View.STATUS_BAR_DISABLE_CLOCK))
        // ---------- Original Method ----------
        //int visFlags = getSystemUiVisibility() & ~View.STATUS_BAR_DISABLE_CLOCK;
        //setSystemUiVisibility(visFlags
                //| (mUpdateMonitor.isClockVisible() ? View.STATUS_BAR_DISABLE_CLOCK : 0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.664 -0400", hash_original_method = "7F2CD05A8542D375736A3C5ABB1CBE6D", hash_generated_method = "271983B7411DBAFBDEA35032C24B1D40")
    @Override
    public void onDeviceProvisioned() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.665 -0400", hash_original_method = "CEA508A7FD8520CCEDFBB34D6152F19D", hash_generated_method = "3D163D549B6F3B0805A5B6999027FF58")
    @Override
    public void onPhoneStateChanged(int phoneState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(phoneState);
        if(DEBUG)        
Log.d(TAG, "phone state: "+phoneState)
        if(phoneState==TelephonyManager.CALL_STATE_RINGING)        
        {
mHasOverlay=truestopAndUnbindFromFaceLock()hideFaceLockArea()
        } //End block
        // ---------- Original Method ----------
        //if (DEBUG) Log.d(TAG, "phone state: " + phoneState);
        //if(phoneState == TelephonyManager.CALL_STATE_RINGING) {
            //mHasOverlay = true;
            //stopAndUnbindFromFaceLock();
            //hideFaceLockArea();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.666 -0400", hash_original_method = "DDFAD35C781D17E571431A2BD738EFF3", hash_generated_method = "8BF01F928BDF33B3FE852631BC768D62")
    @Override
    protected boolean dispatchHoverEvent(MotionEvent event) {
        addTaint(event.getTaint());
        AccessibilityManager accessibilityManager = AccessibilityManager.getInstance(mContext);
        if(accessibilityManager.isEnabled()&&accessibilityManager.isTouchExplorationEnabled())        
        {
getCallback().pokeWakelock()
        } //End block
        boolean varA0E74381799B9BE55CD43281186F09A9_1155029090 = (super.dispatchHoverEvent(event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_570964177 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_570964177;
        // ---------- Original Method ----------
        //AccessibilityManager accessibilityManager = AccessibilityManager.getInstance(mContext);
        //if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            //getCallback().pokeWakelock();
        //}
        //return super.dispatchHoverEvent(event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.667 -0400", hash_original_method = "7A4FFFEE0E1CF12A38B2E2E705FF9DC0", hash_generated_method = "F7B1E505B5460F9F5234D7DAD7CE7D2C")
    @Override
    public void wakeWhenReadyTq(int keyCode) {
        addTaint(keyCode);
        if(DEBUG)        
Log.d(TAG, "onWakeKey")
        if(keyCode==KeyEvent.KEYCODE_MENU&&isSecure()&&(mMode==Mode.LockScreen)&&(mUpdateMonitor.getSimState()!=IccCard.State.PUK_REQUIRED))        
        {
            if(DEBUG)            
Log.d(TAG, "switching screens to unlock screen because wake key was MENU")
updateScreen(Mode.UnlockScreen, false)getCallback().pokeWakelock()
        } //End block
        else
        {
            if(DEBUG)            
Log.d(TAG, "poking wake lock immediately")
getCallback().pokeWakelock()
        } //End block
        // ---------- Original Method ----------
        //if (DEBUG) Log.d(TAG, "onWakeKey");
        //if (keyCode == KeyEvent.KEYCODE_MENU && isSecure() && (mMode == Mode.LockScreen)
                //&& (mUpdateMonitor.getSimState() != IccCard.State.PUK_REQUIRED)) {
            //if (DEBUG) Log.d(TAG, "switching screens to unlock screen because wake key was MENU");
            //updateScreen(Mode.UnlockScreen, false);
            //getCallback().pokeWakelock();
        //} else {
            //if (DEBUG) Log.d(TAG, "poking wake lock immediately");
            //getCallback().pokeWakelock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.669 -0400", hash_original_method = "42353CBA41B24641D2766DB418906D43", hash_generated_method = "6AF90B8355D0DC7F6D1643C90C69E66A")
    @Override
    public void verifyUnlock() {
        if(!isSecure())        
        {
getCallback().keyguardDone(true)
        } //End block
        else
        if(mUnlockScreenMode!=UnlockMode.Pattern&&mUnlockScreenMode!=UnlockMode.Password)        
        {
getCallback().keyguardDone(false)
        } //End block
        else
        {
mIsVerifyUnlockOnly=trueupdateScreen(Mode.UnlockScreen, false)
        } //End block
        // ---------- Original Method ----------
        //if (!isSecure()) {
            //getCallback().keyguardDone(true);
        //} else if (mUnlockScreenMode != UnlockMode.Pattern
                //&& mUnlockScreenMode != UnlockMode.Password) {
            //getCallback().keyguardDone(false);
        //} else {
            //mIsVerifyUnlockOnly = true;
            //updateScreen(Mode.UnlockScreen, false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.670 -0400", hash_original_method = "3339FA8A14177E4BC540AC81398231D0", hash_generated_method = "A3D61D39AD4DB07A0F5123AD1D63825B")
    @Override
    public void cleanUp() {
        if(mLockScreen!=null)        
        {
((KeyguardScreen) mLockScreen).onPause()((KeyguardScreen) mLockScreen).cleanUp()this.removeView(mLockScreen)mLockScreen=null
        } //End block
        if(mUnlockScreen!=null)        
        {
((KeyguardScreen) mUnlockScreen).onPause()((KeyguardScreen) mUnlockScreen).cleanUp()this.removeView(mUnlockScreen)mUnlockScreen=null
        } //End block
mUpdateMonitor.removeCallback(this)        if(mFaceLockService!=null)        
        {
            try 
            {
mFaceLockService.unregisterCallback(mFaceLockCallback)
            } //End block
            catch (RemoteException e)
            {
            } //End block
stopFaceLock()mFaceLockService=null
        } //End block
        // ---------- Original Method ----------
        //if (mLockScreen != null) {
            //((KeyguardScreen) mLockScreen).onPause();
            //((KeyguardScreen) mLockScreen).cleanUp();
            //this.removeView(mLockScreen);
            //mLockScreen = null;
        //}
        //if (mUnlockScreen != null) {
            //((KeyguardScreen) mUnlockScreen).onPause();
            //((KeyguardScreen) mUnlockScreen).cleanUp();
            //this.removeView(mUnlockScreen);
            //mUnlockScreen = null;
        //}
        //mUpdateMonitor.removeCallback(this);
        //if (mFaceLockService != null) {
            //try {
                //mFaceLockService.unregisterCallback(mFaceLockCallback);
            //} catch (RemoteException e) {
            //}
            //stopFaceLock();
            //mFaceLockService = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.672 -0400", hash_original_method = "9ECC638D2BFAA20EB15467D001829FA6", hash_generated_method = "CB6DF5DDC0A3D50D7E29E756085826AD")
    private boolean isSecure() {
        UnlockMode unlockMode = getUnlockMode();
        boolean secure = false;
        switch(unlockMode){
        case Pattern:
secure=mLockPatternUtils.isLockPatternEnabled()        break;
        case SimPin:
secure=mUpdateMonitor.getSimState()==IccCard.State.PIN_REQUIRED        break;
        case SimPuk:
secure=mUpdateMonitor.getSimState()==IccCard.State.PUK_REQUIRED        break;
        case Account:
secure=true        break;
        case Password:
secure=mLockPatternUtils.isLockPasswordEnabled()        break;
        default:
        IllegalStateException varA5147E47808B01D12DB3C1DEE23551FA_1410671576 = new IllegalStateException("unknown unlock mode " + unlockMode);
        varA5147E47808B01D12DB3C1DEE23551FA_1410671576.addTaint(taint);
        throw varA5147E47808B01D12DB3C1DEE23551FA_1410671576;
}        boolean var1C0B76FCE779F78F51BE339C49445C49_798483703 = (secure);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1140279492 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1140279492;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.676 -0400", hash_original_method = "10F024CFE143264CDEB4C457C3C4E945", hash_generated_method = "8C52C0333E396C08F3DD34F7796D2028")
    private void updateScreen(Mode mode, boolean force) {
        addTaint(force);
        addTaint(mode.getTaint());
        if(DEBUG_CONFIGURATION){ }mMode=mode        if(mode==Mode.LockScreen||mShowLockBeforeUnlock)        
        {
            if(force||mLockScreen==null)            
            {
recreateLockScreen()
            } //End block
        } //End block
        if(mode==Mode.UnlockScreen)        
        {
            final UnlockMode unlockMode = getUnlockMode();
            if(force||mUnlockScreen==null||unlockMode!=mUnlockScreenMode)            
            {
                boolean restartFaceLock = stopFaceLockIfRunning();
recreateUnlockScreen(unlockMode)                if(restartFaceLock)                
activateFaceLockIfAble()
            } //End block
        } //End block
        final View goneScreen = (mode == Mode.LockScreen) ? mUnlockScreen : mLockScreen;
        final View visibleScreen = (mode == Mode.LockScreen) ? mLockScreen : mUnlockScreen;
mWindowController.setNeedsInput(((KeyguardScreen) visibleScreen).needsInput())        if(DEBUG_CONFIGURATION)        
        {
        } //End block
        if(mScreenOn)        
        {
            if(goneScreen!=null&&goneScreen.getVisibility()==View.VISIBLE)            
            {
((KeyguardScreen) goneScreen).onPause()
            } //End block
            if(visibleScreen.getVisibility()!=View.VISIBLE)            
            {
((KeyguardScreen) visibleScreen).onResume()
            } //End block
        } //End block
        if(goneScreen!=null)        
        {
goneScreen.setVisibility(View.GONE)
        } //End block
visibleScreen.setVisibility(View.VISIBLE)requestLayout()        if(!visibleScreen.requestFocus())        
        {
            IllegalStateException var3C53F1F1908ABCDEC901B5789F755F36_1824630164 = new IllegalStateException("keyguard screen must be able to take "
                    + "focus when shown " + visibleScreen.getClass().getCanonicalName());
            var3C53F1F1908ABCDEC901B5789F755F36_1824630164.addTaint(taint);
            throw var3C53F1F1908ABCDEC901B5789F755F36_1824630164;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.679 -0400", hash_original_method = "734E71D9DCA8E58452E972C0BF31ED5C", hash_generated_method = "C5D133B673084398D3D7E43BE90F3640")
     View createLockScreen() {
        View lockView = new LockScreen(
                mContext,
                mConfiguration,
                mLockPatternUtils,
                mUpdateMonitor,
                mKeyguardScreenCallback);
initializeTransportControlView(lockView)View var3394989581057429F9E511727EB4416C_382031112 = lockView        var3394989581057429F9E511727EB4416C_382031112.addTaint(taint);
        return var3394989581057429F9E511727EB4416C_382031112;
        // ---------- Original Method ----------
        //View lockView = new LockScreen(
                //mContext,
                //mConfiguration,
                //mLockPatternUtils,
                //mUpdateMonitor,
                //mKeyguardScreenCallback);
        //initializeTransportControlView(lockView);
        //return lockView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.682 -0400", hash_original_method = "1B7378FFEFF54FF8C3F88676818E56F7", hash_generated_method = "64F4FD3C95E27BAE7BBA96818F7932E3")
     View createUnlockScreenFor(UnlockMode unlockMode) {
        addTaint(unlockMode.getTaint());
        View unlockView = null;
        if(DEBUG)        
Log.d(TAG, "createUnlockScreenFor("+unlockMode+"): mEnableFallback="+mEnableFallback)
        if(unlockMode==UnlockMode.Pattern)        
        {
            PatternUnlockScreen view = new PatternUnlockScreen(
                    mContext,
                    mConfiguration,
                    mLockPatternUtils,
                    mUpdateMonitor,
                    mKeyguardScreenCallback,
                    mUpdateMonitor.getFailedAttempts());
view.setEnableFallback(mEnableFallback)unlockView=view
        } //End block
        else
        if(unlockMode==UnlockMode.SimPuk)        
        {
unlockView=new SimPukUnlockScreen(mContext, mConfiguration, mUpdateMonitor, mKeyguardScreenCallback, mLockPatternUtils)
        } //End block
        else
        if(unlockMode==UnlockMode.SimPin)        
        {
unlockView=new SimUnlockScreen(mContext, mConfiguration, mUpdateMonitor, mKeyguardScreenCallback, mLockPatternUtils)
        } //End block
        else
        if(unlockMode==UnlockMode.Account)        
        {
            try 
            {
unlockView=new AccountUnlockScreen(mContext, mConfiguration, mUpdateMonitor, mKeyguardScreenCallback, mLockPatternUtils)
            } //End block
            catch (IllegalStateException e)
            {
View var4FD084291386EE6DCF1640A0EDD96E29_486569417 = createUnlockScreenFor(UnlockMode.Pattern)                var4FD084291386EE6DCF1640A0EDD96E29_486569417.addTaint(taint);
                return var4FD084291386EE6DCF1640A0EDD96E29_486569417;
            } //End block
        } //End block
        else
        if(unlockMode==UnlockMode.Password)        
        {
unlockView=new PasswordUnlockScreen(mContext, mConfiguration, mLockPatternUtils, mUpdateMonitor, mKeyguardScreenCallback)
        } //End block
        else
        {
            IllegalArgumentException var8CCE5732969809D188BCADC85F1D4CD9_232370292 = new IllegalArgumentException("unknown unlock mode " + unlockMode);
            var8CCE5732969809D188BCADC85F1D4CD9_232370292.addTaint(taint);
            throw var8CCE5732969809D188BCADC85F1D4CD9_232370292;
        } //End block
initializeTransportControlView(unlockView)initializeFaceLockAreaView(unlockView)mUnlockScreenMode=unlockModeView var9A165698CA118C2791462F11FE1A181B_1335653949 = unlockView        var9A165698CA118C2791462F11FE1A181B_1335653949.addTaint(taint);
        return var9A165698CA118C2791462F11FE1A181B_1335653949;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.685 -0400", hash_original_method = "D29F4EC775DC7818F9B001BE3F38CE3A", hash_generated_method = "DD74420B2D443B6A2566E9017B1526E0")
    private void initializeTransportControlView(View view) {
        addTaint(view.getTaint());
mTransportControlView=(TransportControlView) view.findViewById(R.id.transport)        if(mTransportControlView==null)        
        {
            if(DEBUG){ }
        } //End block
        else
        {
mUpdateMonitor.reportClockVisible(true)mTransportControlView.setVisibility(View.GONE)mTransportControlView.setCallback(mWidgetCallback)
        } //End block
        // ---------- Original Method ----------
        //mTransportControlView = (TransportControlView) view.findViewById(R.id.transport);
        //if (mTransportControlView == null) {
            //if (DEBUG) Log.w(TAG, "Couldn't find transport control widget");
        //} else {
            //mUpdateMonitor.reportClockVisible(true);
            //mTransportControlView.setVisibility(View.GONE); 
            //mTransportControlView.setCallback(mWidgetCallback);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.688 -0400", hash_original_method = "66D92C5D48356F76F69796ED48175879", hash_generated_method = "183F312BB48C2218A0AE9E1A24EC40AD")
    private Mode getInitialMode() {
        final IccCard.State simState = mUpdateMonitor.getSimState();
        if(stuckOnLockScreenBecauseSimMissing()||(simState==IccCard.State.PUK_REQUIRED&&!mLockPatternUtils.isPukUnlockScreenEnable()))        
        {
Mode var008778CC3F28CC43496ED482EBA22C3E_389931091 = Mode.LockScreen            var008778CC3F28CC43496ED482EBA22C3E_389931091.addTaint(taint);
            return var008778CC3F28CC43496ED482EBA22C3E_389931091;
        } //End block
        else
        {
            if(!isSecure()||mShowLockBeforeUnlock)            
            {
Mode var008778CC3F28CC43496ED482EBA22C3E_1557503368 = Mode.LockScreen                var008778CC3F28CC43496ED482EBA22C3E_1557503368.addTaint(taint);
                return var008778CC3F28CC43496ED482EBA22C3E_1557503368;
            } //End block
            else
            {
Mode varB6284C8283F6D70C3B6E867B108EE565_343807392 = Mode.UnlockScreen                varB6284C8283F6D70C3B6E867B108EE565_343807392.addTaint(taint);
                return varB6284C8283F6D70C3B6E867B108EE565_343807392;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //final IccCard.State simState = mUpdateMonitor.getSimState();
        //if (stuckOnLockScreenBecauseSimMissing() ||
                //(simState == IccCard.State.PUK_REQUIRED &&
                        //!mLockPatternUtils.isPukUnlockScreenEnable())) {
            //return Mode.LockScreen;
        //} else {
            //if (!isSecure() || mShowLockBeforeUnlock) {
                //return Mode.LockScreen;
            //} else {
                //return Mode.UnlockScreen;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.691 -0400", hash_original_method = "D8EE9A8357189508B4BD8A6DECEC2D1D", hash_generated_method = "9427C9E2CF4336F92FFDC4EB1F373E3A")
    private UnlockMode getUnlockMode() {
        final IccCard.State simState = mUpdateMonitor.getSimState();
        UnlockMode currentMode;
        if(simState==IccCard.State.PIN_REQUIRED)        
        {
currentMode=UnlockMode.SimPin
        } //End block
        else
        if(simState==IccCard.State.PUK_REQUIRED)        
        {
currentMode=UnlockMode.SimPuk
        } //End block
        else
        {
            final int mode = mLockPatternUtils.getKeyguardStoredPasswordQuality();
            switch(mode){
            case DevicePolicyManager.PASSWORD_QUALITY_NUMERIC:
            case DevicePolicyManager.PASSWORD_QUALITY_ALPHABETIC:
            case DevicePolicyManager.PASSWORD_QUALITY_ALPHANUMERIC:
            case DevicePolicyManager.PASSWORD_QUALITY_COMPLEX:
currentMode=UnlockMode.Password            break;
            case DevicePolicyManager.PASSWORD_QUALITY_SOMETHING:
            case DevicePolicyManager.PASSWORD_QUALITY_UNSPECIFIED:
            if(mForgotPattern||mLockPatternUtils.isPermanentlyLocked())            
            {
currentMode=UnlockMode.Account
            } //End block
            else
            {
currentMode=UnlockMode.Pattern
            } //End block
            break;
            default:
            IllegalStateException var3F5AE16931D8375370945E428C5E0F64_1072066189 = new IllegalStateException("Unknown unlock mode:" + mode);
            var3F5AE16931D8375370945E428C5E0F64_1072066189.addTaint(taint);
            throw var3F5AE16931D8375370945E428C5E0F64_1072066189;
}
        } //End block
UnlockMode varCA9E71E815B26724AF9385261729A805_1523266881 = currentMode        varCA9E71E815B26724AF9385261729A805_1523266881.addTaint(taint);
        return varCA9E71E815B26724AF9385261729A805_1523266881;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.694 -0400", hash_original_method = "F3CB2FA76BC3F3C20C69C157123B0B67", hash_generated_method = "DF21A808BB7D99B94E2EF8CE9A171C69")
    private void showDialog(String title, String message) {
        addTaint(message.getTaint());
        addTaint(title.getTaint());
        final AlertDialog dialog = new AlertDialog.Builder(mContext)
            .setTitle(title)
            .setMessage(message)
            .setNeutralButton(R.string.ok, null)
            .create();
dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_KEYGUARD_DIALOG)dialog.show()
        // ---------- Original Method ----------
        //final AlertDialog dialog = new AlertDialog.Builder(mContext)
            //.setTitle(title)
            //.setMessage(message)
            //.setNeutralButton(R.string.ok, null)
            //.create();
        //dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_KEYGUARD_DIALOG);
        //dialog.show();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.695 -0400", hash_original_method = "555F6EF0AAA599106863537942B7C51C", hash_generated_method = "8CD1F1EEF1EC36C049041E73CD1441D9")
    private void showTimeoutDialog() {
        int timeoutInSeconds = (int) LockPatternUtils.FAILED_ATTEMPT_TIMEOUT_MS / 1000;
        int messageId = R.string.lockscreen_too_many_failed_attempts_dialog_message;
        if(getUnlockMode()==UnlockMode.Password)        
        {
            if(mLockPatternUtils.getKeyguardStoredPasswordQuality()==DevicePolicyManager.PASSWORD_QUALITY_NUMERIC)            
            {
messageId=R.string.lockscreen_too_many_failed_pin_attempts_dialog_message
            } //End block
            else
            {
messageId=R.string.lockscreen_too_many_failed_password_attempts_dialog_message
            } //End block
        } //End block
        String message = mContext.getString(messageId, mUpdateMonitor.getFailedAttempts(),
                timeoutInSeconds);
showDialog(null, message)
        // ---------- Original Method ----------
        //int timeoutInSeconds = (int) LockPatternUtils.FAILED_ATTEMPT_TIMEOUT_MS / 1000;
        //int messageId = R.string.lockscreen_too_many_failed_attempts_dialog_message;
        //if (getUnlockMode() == UnlockMode.Password) {
            //if(mLockPatternUtils.getKeyguardStoredPasswordQuality() ==
                //DevicePolicyManager.PASSWORD_QUALITY_NUMERIC) {
                //messageId = R.string.lockscreen_too_many_failed_pin_attempts_dialog_message;
            //} else {
                //messageId = R.string.lockscreen_too_many_failed_password_attempts_dialog_message;
            //}
        //}
        //String message = mContext.getString(messageId, mUpdateMonitor.getFailedAttempts(),
                //timeoutInSeconds);
        //showDialog(null, message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.698 -0400", hash_original_method = "1E813B124479D93F0AC066BBB546E33A", hash_generated_method = "D5D279A08EAB648D15C634D827E15AA9")
    private void showAlmostAtAccountLoginDialog() {
        final int timeoutInSeconds = (int) LockPatternUtils.FAILED_ATTEMPT_TIMEOUT_MS / 1000;
        final int count = LockPatternUtils.FAILED_ATTEMPTS_BEFORE_RESET
                - LockPatternUtils.FAILED_ATTEMPTS_BEFORE_TIMEOUT;
        String message = mContext.getString(R.string.lockscreen_failed_attempts_almost_glogin,
                count, LockPatternUtils.FAILED_ATTEMPTS_BEFORE_TIMEOUT, timeoutInSeconds);
showDialog(null, message)
        // ---------- Original Method ----------
        //final int timeoutInSeconds = (int) LockPatternUtils.FAILED_ATTEMPT_TIMEOUT_MS / 1000;
        //final int count = LockPatternUtils.FAILED_ATTEMPTS_BEFORE_RESET
                //- LockPatternUtils.FAILED_ATTEMPTS_BEFORE_TIMEOUT;
        //String message = mContext.getString(R.string.lockscreen_failed_attempts_almost_glogin,
                //count, LockPatternUtils.FAILED_ATTEMPTS_BEFORE_TIMEOUT, timeoutInSeconds);
        //showDialog(null, message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.700 -0400", hash_original_method = "0E31DFF0107DA79BCF280699A4DCB2D5", hash_generated_method = "F80AC2CD0A19CE1C89D7F4D7D2B999D5")
    private void showAlmostAtWipeDialog(int attempts, int remaining) {
        addTaint(remaining);
        addTaint(attempts);
        int timeoutInSeconds = (int) LockPatternUtils.FAILED_ATTEMPT_TIMEOUT_MS / 1000;
        String message = mContext.getString(
                R.string.lockscreen_failed_attempts_almost_at_wipe, attempts, remaining);
showDialog(null, message)
        // ---------- Original Method ----------
        //int timeoutInSeconds = (int) LockPatternUtils.FAILED_ATTEMPT_TIMEOUT_MS / 1000;
        //String message = mContext.getString(
                //R.string.lockscreen_failed_attempts_almost_at_wipe, attempts, remaining);
        //showDialog(null, message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.702 -0400", hash_original_method = "6225ACBE1DCB5F24700B556D0E9427FD", hash_generated_method = "4D91A9640B9AE17AB6BD56913581DCF7")
    private void showWipeDialog(int attempts) {
        addTaint(attempts);
        String message = mContext.getString(
                R.string.lockscreen_failed_attempts_now_wiping, attempts);
showDialog(null, message)
        // ---------- Original Method ----------
        //String message = mContext.getString(
                //R.string.lockscreen_failed_attempts_now_wiping, attempts);
        //showDialog(null, message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.703 -0400", hash_original_method = "E59D1E9CE4D514E523F93D75483798AF", hash_generated_method = "0602316D11D56767C238CAA1B09299AD")
    private boolean usingFaceLock() {
        boolean varFF4B997A207B6C93C84D1EC07F9C471F_2107672843 = ((mLockPatternUtils.usingBiometricWeak()&&mLockPatternUtils.isBiometricWeakInstalled()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1363076276 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1363076276;
        // ---------- Original Method ----------
        //return (mLockPatternUtils.usingBiometricWeak() &&
                //mLockPatternUtils.isBiometricWeakInstalled());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.705 -0400", hash_original_method = "67AC19C6F4A78F1E2B03DBB943627627", hash_generated_method = "71AA1E8FC3BE62C1509B2E860FCAC43D")
    private void initializeFaceLockAreaView(View view) {
        addTaint(view.getTaint());
        if(usingFaceLock())        
        {
mFaceLockAreaView=view.findViewById(R.id.faceLockAreaView)            if(mFaceLockAreaView==null)            
            {
            } //End block
        } //End block
        else
        {
mFaceLockAreaView=null
        } //End block
        // ---------- Original Method ----------
        //if (usingFaceLock()) {
            //mFaceLockAreaView = view.findViewById(R.id.faceLockAreaView);
            //if (mFaceLockAreaView == null) {
                //Log.e(TAG, "Layout does not have faceLockAreaView and FaceLock is enabled");
            //}
        //} else {
            //mFaceLockAreaView = null; 
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.707 -0400", hash_original_method = "B1975D0006BFBCAA1D8E36B6FB3CA790", hash_generated_method = "167324A001FBD0897FAAFDDA1DFFC5E2")
    private boolean stopFaceLockIfRunning() {
        if(usingFaceLock()&&mBoundToFaceLockService)        
        {
stopAndUnbindFromFaceLock()            boolean varB326B5062B2F0E69046810717534CB09_375744619 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_539833739 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_539833739;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_230790684 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_899282252 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_899282252;
        // ---------- Original Method ----------
        //if (usingFaceLock() && mBoundToFaceLockService) {
            //stopAndUnbindFromFaceLock();
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.709 -0400", hash_original_method = "8DCBF561A032814DD2EF017D667FE9FE", hash_generated_method = "E7C2877DAC5A4307056E203C252C0DAD")
    @Override
    public boolean handleMessage(Message msg) {
        addTaint(msg.getTaint());
        switch(msg.what){
        case MSG_SHOW_FACELOCK_AREA_VIEW:
        if(mFaceLockAreaView!=null)        
        {
mFaceLockAreaView.setVisibility(View.VISIBLE)
        } //End block
        break;
        case MSG_HIDE_FACELOCK_AREA_VIEW:
        if(mFaceLockAreaView!=null)        
        {
mFaceLockAreaView.setVisibility(View.INVISIBLE)
        } //End block
        break;
        default:
        boolean var68934A3E9455FA72420237EB05902327_275179414 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1200485217 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1200485217;
}        boolean varB326B5062B2F0E69046810717534CB09_1903676486 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_327812156 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_327812156;
        // ---------- Original Method ----------
        //switch (msg.what) {
        //case MSG_SHOW_FACELOCK_AREA_VIEW:
            //if (mFaceLockAreaView != null) {
                //mFaceLockAreaView.setVisibility(View.VISIBLE);
            //}
            //break;
        //case MSG_HIDE_FACELOCK_AREA_VIEW:
            //if (mFaceLockAreaView != null) {
                //mFaceLockAreaView.setVisibility(View.INVISIBLE);
            //}
            //break;
        //default:
            //Log.w(TAG, "Unhandled message");
            //return false;
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.710 -0400", hash_original_method = "B05F67A169814B98659F6BCFD660C781", hash_generated_method = "B9A30A51FDA6158D56BCE450608FF23B")
    private void removeFaceLockAreaDisplayMessages() {
mHandler.removeMessages(MSG_SHOW_FACELOCK_AREA_VIEW)mHandler.removeMessages(MSG_HIDE_FACELOCK_AREA_VIEW)
        // ---------- Original Method ----------
        //mHandler.removeMessages(MSG_SHOW_FACELOCK_AREA_VIEW);
        //mHandler.removeMessages(MSG_HIDE_FACELOCK_AREA_VIEW);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.711 -0400", hash_original_method = "E4860F866A9E16C8C10F3C32E612441A", hash_generated_method = "80A49559E0BF32DB8048EA8B0AA35B2B")
    private void showFaceLockArea() {
removeFaceLockAreaDisplayMessages()mHandler.sendEmptyMessage(MSG_SHOW_FACELOCK_AREA_VIEW)
        // ---------- Original Method ----------
        //removeFaceLockAreaDisplayMessages();
        //mHandler.sendEmptyMessage(MSG_SHOW_FACELOCK_AREA_VIEW);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.712 -0400", hash_original_method = "805396A8E0F4980F40ECC395AA54D1B2", hash_generated_method = "2552B9C1102B94D22BBFDEB3D7F4EFA3")
    private void hideFaceLockArea() {
removeFaceLockAreaDisplayMessages()mHandler.sendEmptyMessage(MSG_HIDE_FACELOCK_AREA_VIEW)
        // ---------- Original Method ----------
        //removeFaceLockAreaDisplayMessages();
        //mHandler.sendEmptyMessage(MSG_HIDE_FACELOCK_AREA_VIEW);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.712 -0400", hash_original_method = "FF40CF75A547783002C627F8639C069E", hash_generated_method = "6937B335F896FE3FDB4507627DD0348E")
    private void showFaceLockAreaWithTimeout(long timeoutMillis) {
        addTaint(timeoutMillis);
showFaceLockArea()mHandler.sendEmptyMessageDelayed(MSG_HIDE_FACELOCK_AREA_VIEW, timeoutMillis)
        // ---------- Original Method ----------
        //showFaceLockArea();
        //mHandler.sendEmptyMessageDelayed(MSG_HIDE_FACELOCK_AREA_VIEW, timeoutMillis);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.713 -0400", hash_original_method = "4F934278ACAE126D50CE3922815F947C", hash_generated_method = "DAEFE4DEB2697FE51CEED68681825F19")
    public void bindToFaceLock() {
        if(usingFaceLock())        
        {
            if(!mBoundToFaceLockService)            
            {
                if(DEBUG)                
Log.d(TAG, "before bind to FaceLock service")
mContext.bindService(new Intent(IFaceLockInterface.class.getName()), mFaceLockConnection, Context.BIND_AUTO_CREATE)                if(DEBUG)                
Log.d(TAG, "after bind to FaceLock service")
mBoundToFaceLockService=true
            } //End block
            else
            {
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (usingFaceLock()) {
            //if (!mBoundToFaceLockService) {
                //if (DEBUG) Log.d(TAG, "before bind to FaceLock service");
                //mContext.bindService(new Intent(IFaceLockInterface.class.getName()),
                        //mFaceLockConnection,
                        //Context.BIND_AUTO_CREATE);
                //if (DEBUG) Log.d(TAG, "after bind to FaceLock service");
                //mBoundToFaceLockService = true;
            //} else {
                //Log.w(TAG, "Attempt to bind to FaceLock when already bound");
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.715 -0400", hash_original_method = "1358F85D816CAEE43676912901CD89CA", hash_generated_method = "B24D9B3BF763823E8A48DBE57375B076")
    public void stopAndUnbindFromFaceLock() {
        if(usingFaceLock())        
        {
stopFaceLock()            if(mBoundToFaceLockService)            
            {
                if(DEBUG)                
Log.d(TAG, "before unbind from FaceLock service")
                if(mFaceLockService!=null)                
                {
                    try 
                    {
mFaceLockService.unregisterCallback(mFaceLockCallback)
                    } //End block
                    catch (RemoteException e)
                    {
                    } //End block
                } //End block
mContext.unbindService(mFaceLockConnection)                if(DEBUG)                
Log.d(TAG, "after unbind from FaceLock service")
mBoundToFaceLockService=false
            } //End block
            else
            {
                if(DEBUG)                
Log.d(TAG, "Attempt to unbind from FaceLock when not bound")
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.717 -0400", hash_original_method = "746EA190AF07BA09104DAEE53E067960", hash_generated_method = "B0B2055985AB497A53736589EA8C9FCC")
    public void startFaceLock(IBinder windowToken, int x, int y, int w, int h) {
        addTaint(h);
        addTaint(w);
        addTaint(y);
        addTaint(x);
        addTaint(windowToken.getTaint());
        if(usingFaceLock())        
        {
            synchronized
(mFaceLockServiceRunningLock)            {
                if(!mFaceLockServiceRunning)                
                {
                    if(DEBUG)                    
Log.d(TAG, "Starting FaceLock")
                    try 
                    {
mFaceLockService.startUi(windowToken, x, y, w, h)
                    } //End block
                    catch (RemoteException e)
                    {
                        return;
                    } //End block
mFaceLockServiceRunning=true
                } //End block
                else
                {
                    if(DEBUG){ }
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (usingFaceLock()) {
            //synchronized (mFaceLockServiceRunningLock) {
                //if (!mFaceLockServiceRunning) {
                    //if (DEBUG) Log.d(TAG, "Starting FaceLock");
                    //try {
                        //mFaceLockService.startUi(windowToken, x, y, w, h);
                    //} catch (RemoteException e) {
                        //Log.e(TAG, "Caught exception starting FaceLock: " + e.toString());
                        //return;
                    //}
                    //mFaceLockServiceRunning = true;
                //} else {
                    //if (DEBUG) Log.w(TAG, "startFaceLock() attempted while running");
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.718 -0400", hash_original_method = "7B1FDB597125BD8556003AF5124662AA", hash_generated_method = "BFC6A1CC021EFC5B40962A6C2BC96D31")
    public void stopFaceLock() {
        if(usingFaceLock())        
        {
            synchronized
(mFaceLockServiceRunningLock)            {
                if(mFaceLockServiceRunning)                
                {
                    try 
                    {
                        if(DEBUG)                        
Log.d(TAG, "Stopping FaceLock")
mFaceLockService.stopUi()
                    } //End block
                    catch (RemoteException e)
                    {
                    } //End block
mFaceLockServiceRunning=false
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (usingFaceLock()) {
            //synchronized (mFaceLockServiceRunningLock) {
                //if (mFaceLockServiceRunning) {
                    //try {
                        //if (DEBUG) Log.d(TAG, "Stopping FaceLock");
                        //mFaceLockService.stopUi();
                    //} catch (RemoteException e) {
                        //Log.e(TAG, "Caught exception stopping FaceLock: " + e.toString());
                    //}
                    //mFaceLockServiceRunning = false;
                //}
            //}
        //}
    }

    
    enum Mode {
        LockScreen,
        UnlockScreen
    }

    
    enum UnlockMode {
        Pattern,
        SimPin,
        SimPuk,
        Account,
        Password,
        Unknown
    }

    
    private class AccountAnalyzer implements AccountManagerCallback<Bundle> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.719 -0400", hash_original_field = "55C62D532C4EAE9F726820746C51450F", hash_generated_field = "C35AB4184AB4878E22C04730960328F4")

        private AccountManager mAccountManager;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.720 -0400", hash_original_field = "F801232B9FFD0D00185EF079B29A17DD", hash_generated_field = "9845A6E49327CA643977BBD2412992D7")

        private Account[] mAccounts;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.720 -0400", hash_original_field = "8D9D462324EE4EE9A77E747715C81DA1", hash_generated_field = "97CE5F993C4F407D888587CCCC9597D5")

        private int mAccountIndex;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.721 -0400", hash_original_method = "0B55DD009D09BEEC6E8E7BD89C65E374", hash_generated_method = "56EE809B341CB4D992C781BBE87E8F26")
        private  AccountAnalyzer(AccountManager accountManager) {
            addTaint(accountManager.getTaint());
mAccountManager=accountManagermAccounts=accountManager.getAccountsByType("com.google")
            // ---------- Original Method ----------
            //mAccountManager = accountManager;
            //mAccounts = accountManager.getAccountsByType("com.google");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.723 -0400", hash_original_method = "0063E501D53B19FDDF8CC0663636AB18", hash_generated_method = "BE3A6242E06B78499AEDEABE65ACB8BC")
        private void next() {
            if(mEnableFallback||mAccountIndex>=mAccounts.length)            
            {
                if(mUnlockScreen==null)                
                {
                    if(DEBUG){ }
                } //End block
                else
                if(mUnlockScreen instanceof PatternUnlockScreen)                
                {
((PatternUnlockScreen) mUnlockScreen).setEnableFallback(mEnableFallback)
                } //End block
                return;
            } //End block
mAccountManager.confirmCredentials(mAccounts[mAccountIndex], null, null, this, null)
            // ---------- Original Method ----------
            //if (mEnableFallback || mAccountIndex >= mAccounts.length) {
                //if (mUnlockScreen == null) {
                    //if (DEBUG) Log.w(TAG, "no unlock screen when trying to enable fallback");
                //} else if (mUnlockScreen instanceof PatternUnlockScreen) {
                    //((PatternUnlockScreen)mUnlockScreen).setEnableFallback(mEnableFallback);
                //}
                //return;
            //}
            //mAccountManager.confirmCredentials(mAccounts[mAccountIndex], null, null, this, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.725 -0400", hash_original_method = "ECBB5EE8225BAAADFFC330D14A33E24B", hash_generated_method = "76DF71BBECD29063ABFB0B12FB92D763")
        public void start() {
mEnableFallback=falsemAccountIndex=0next()
            // ---------- Original Method ----------
            //mEnableFallback = false;
            //mAccountIndex = 0;
            //next();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.726 -0400", hash_original_method = "5ED73D65B7459D6431317457DDED8B85", hash_generated_method = "A3A251B591E6DFA0CA6BA4B2CFCAED89")
        public void run(AccountManagerFuture<Bundle> future) {
            addTaint(future.getTaint());
            try 
            {
                Bundle result = future.getResult();
                if(result.getParcelable(AccountManager.KEY_INTENT)!=null)                
                {
mEnableFallback=true
                } //End block
            } //End block
            catch (OperationCanceledException e)
            {
            } //End block
            catch (IOException e)
            {
            } //End block
            catch (AuthenticatorException e)
            {
            } //End block
            finally 
            {
mAccountIndexnext()
            } //End block
            // ---------- Original Method ----------
            //try {
                //Bundle result = future.getResult();
                //if (result.getParcelable(AccountManager.KEY_INTENT) != null) {
                    //mEnableFallback = true;
                //}
            //} catch (OperationCanceledException e) {
            //} catch (IOException e) {
            //} catch (AuthenticatorException e) {
            //} finally {
                //mAccountIndex++;
                //next();
            //}
        }

        
    }


    
    static private class FastBitmapDrawable extends Drawable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.727 -0400", hash_original_field = "C4C105852193F50EEB9E84F09C746611", hash_generated_field = "4EFA3179E01F3A6C04DAAC2298E5BFE4")

        private Bitmap mBitmap;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.728 -0400", hash_original_field = "9D334A125EE4B3831821AB1264C029B9", hash_generated_field = "05E7E4BE80B060037CF88AC66652FF58")

        private int mOpacity;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.729 -0400", hash_original_method = "CC854FE782C866726903B1E58A264E18", hash_generated_method = "E0BCCEB75ACC5F1AB6FD93F05475A527")
        private  FastBitmapDrawable(Bitmap bitmap) {
            addTaint(bitmap.getTaint());
mBitmap=bitmapmOpacity=mBitmap.hasAlpha()?PixelFormat.TRANSLUCENT:PixelFormat.TRANSLUCENT
            // ---------- Original Method ----------
            //mBitmap = bitmap;
            //mOpacity = mBitmap.hasAlpha() ? PixelFormat.TRANSLUCENT : PixelFormat.OPAQUE;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.729 -0400", hash_original_method = "E0592BA0BA808CF9FCAE11D78B3AFA31", hash_generated_method = "71B60D9B8BCE3D908FC58B69513513E5")
        @Override
        public void draw(Canvas canvas) {
            addTaint(canvas.getTaint());
canvas.drawBitmap(mBitmap, (getBounds().width()-mBitmap.getWidth())/2, (getBounds().height()-mBitmap.getHeight()), null)
            // ---------- Original Method ----------
            //canvas.drawBitmap(
                    //mBitmap,
                    //(getBounds().width() - mBitmap.getWidth()) / 2,
                    //(getBounds().height() - mBitmap.getHeight()),
                    //null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.730 -0400", hash_original_method = "DA87630A0FCBBC6549E4C88376DBA500", hash_generated_method = "7992EF61F7CDDF9D43BE2F0CD2C5EAF4")
        @Override
        public int getOpacity() {
            int var9D334A125EE4B3831821AB1264C029B9_1573363487 = (mOpacity);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_776912528 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_776912528;
            // ---------- Original Method ----------
            //return mOpacity;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.731 -0400", hash_original_method = "5784D116F3F796E4D5324F7E68A41209", hash_generated_method = "DCDCC287CA9BC5217D3FA2BC94984F3E")
        @Override
        public void setAlpha(int alpha) {
            addTaint(alpha);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.732 -0400", hash_original_method = "77240A7357C6E5E7293BFF14ACDD79D8", hash_generated_method = "18D8B35FAE562ED5B4F19A1CD78B9AEE")
        @Override
        public void setColorFilter(ColorFilter cf) {
            addTaint(cf.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.733 -0400", hash_original_method = "78594233BF21EDB92D5FCFC99B092BFE", hash_generated_method = "6218FCA5356964F8D18597FAEB66EFA1")
        @Override
        public int getIntrinsicWidth() {
            int varF582257C9BC06C3475683DA9F9AE7919_647183728 = (mBitmap.getWidth());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1862390555 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1862390555;
            // ---------- Original Method ----------
            //return mBitmap.getWidth();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.734 -0400", hash_original_method = "5C5DE1E04D9972884E02DDE51895ABA3", hash_generated_method = "93A0396DB5E354C9E28618BAF646E7A6")
        @Override
        public int getIntrinsicHeight() {
            int varC25E084EBC4D9358C01EBD9A3B801212_430780761 = (mBitmap.getHeight());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2084070669 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2084070669;
            // ---------- Original Method ----------
            //return mBitmap.getHeight();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.735 -0400", hash_original_method = "9332A595A115BCF24359E3165303B8F5", hash_generated_method = "86133038DFA4944E5C4A4878BDFF5D0D")
        @Override
        public int getMinimumWidth() {
            int varF582257C9BC06C3475683DA9F9AE7919_884539066 = (mBitmap.getWidth());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1102172103 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1102172103;
            // ---------- Original Method ----------
            //return mBitmap.getWidth();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.735 -0400", hash_original_method = "155046944E937B6147C12379FBA44310", hash_generated_method = "C5B686243BFFF63CB72FBB8A8354A560")
        @Override
        public int getMinimumHeight() {
            int varC25E084EBC4D9358C01EBD9A3B801212_1142650850 = (mBitmap.getHeight());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1092408790 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1092408790;
            // ---------- Original Method ----------
            //return mBitmap.getHeight();
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.736 -0400", hash_original_field = "BDAB70A81798D73CF5457FEB241D1BA3", hash_generated_field = "F90CE328A4213E7883120D2B3718D19B")

    private static final int TRANSPORT_USERACTIVITY_TIMEOUT = 10000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.736 -0400", hash_original_field = "D146DDB94A0D3A63C400058639AEBC96", hash_generated_field = "49456B7B04CBDE39E39247076FD8C32A")

    static final boolean DEBUG_CONFIGURATION = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.737 -0400", hash_original_field = "F3922CB3FC516F8D81E7D3721E257360", hash_generated_field = "5B12C43F7785F8D95A8CCF1A9993236F")

    private static final int EMERGENCY_CALL_TIMEOUT = 10000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.737 -0400", hash_original_field = "C5F507FB3964484811A0FCE93585A341", hash_generated_field = "1A7BFF791FFD10D89E3C325459C16F7D")

    static final String ACTION_EMERGENCY_DIAL = "com.android.phone.EmergencyDialer.DIAL";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.737 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.738 -0400", hash_original_field = "85E35F99FECB2F6106105505052CE5F9", hash_generated_field = "46E4F74FC303C3678DEADD1A04D81570")

    private static final String TAG = "LockPatternKeyguardView";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.738 -0400", hash_original_field = "854C433D5FEB371D5E5104384DFB68CE", hash_generated_field = "929176B25558A75907566B3557CF2877")

    private static final int FAILED_FACE_UNLOCK_ATTEMPTS_BEFORE_BACKUP = 15;
}

