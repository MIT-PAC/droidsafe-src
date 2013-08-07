package com.android.internal.policy.impl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.SystemClock;
import android.app.PendingIntent;
import android.view.WindowManagerImpl;
import android.util.Log;
import com.android.internal.telephony.IccCard;
import android.media.AudioManager;
import android.os.Message;
import android.app.StatusBarManager;
import android.util.EventLog;
import android.media.SoundPool;
import android.os.RemoteException;
import android.content.BroadcastReceiver;
import com.android.internal.widget.LockPatternUtils;
import android.content.Intent;
import android.view.KeyEvent;
import android.telephony.TelephonyManager;
import android.os.Handler;
import android.app.ActivityManagerNative;
import android.content.ContentResolver;
import android.view.WindowManagerPolicy;
import android.app.AlarmManager;
import android.os.SystemProperties;
import android.provider.Settings;
import android.content.IntentFilter;
import android.os.LocalPowerManager;
import android.provider.Settings.System.SCREEN_OFF_TIMEOUT;
import android.content.Context;
import android.os.PowerManager;
public class KeyguardViewMediator implements KeyguardViewCallback, KeyguardUpdateMonitor.InfoCallback, KeyguardUpdateMonitor.SimStateCallback {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.393 -0400", hash_original_field = "832145652B3F4EDE2DA191ABFCE9BE86", hash_generated_field = "02F543B0A1C8A11E343C8DEF5117A259")

    final float MIN_LOCK_VOLUME = 0.05f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.394 -0400", hash_original_field = "599A4FB9D62EE331EBD7C09E6F105BD8", hash_generated_field = "B4F70CCD4E132F4AC1238CBF7ABABD48")

    final float MAX_LOCK_VOLUME = 0.4f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.394 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.394 -0400", hash_original_field = "23123B9B5BA4EECD4657E91D670DFADA", hash_generated_field = "0F11717942EB050C6E2406F2976F5C6A")

    private AlarmManager mAlarmManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.395 -0400", hash_original_field = "DC563AE6C758BE979A84432D84FFAC40", hash_generated_field = "B52B11818937F27E927A20CDEBA27654")

    private AudioManager mAudioManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.395 -0400", hash_original_field = "80B9AA2EA60D5467377789878EB692A8", hash_generated_field = "FA1A2978875234B7C2CF7B4F18B280C5")

    private StatusBarManager mStatusBarManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.395 -0400", hash_original_field = "89A91EDC573D193B2345D93CC2768435", hash_generated_field = "8981CB0C1D84379FD9E8AE20D1DB348B")

    private boolean mShowLockIcon;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.395 -0400", hash_original_field = "D9F79C1431657343FE7F1EC8EC9D4EA7", hash_generated_field = "86F0450B4B9294CBA536D4CF54C3F8D4")

    private boolean mShowingLockIcon;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.396 -0400", hash_original_field = "E686BD4BFC5A90E09B877B21565DC3C2", hash_generated_field = "4D9BA7596FF16EA505DE22309190831F")

    private boolean mSystemReady;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.396 -0400", hash_original_field = "9925AC73EAF7D598923A4EF755C26B57", hash_generated_field = "6E826E0CE785C70FBD1D4390AC8F69E7")

    private boolean mSuppressNextLockSound = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.396 -0400", hash_original_field = "FA1C2C5229E40C28203F183D6CC91366", hash_generated_field = "D26235B145E7565A45B993939E3415A0")

    LocalPowerManager mRealPowerManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.396 -0400", hash_original_field = "3D87516393C6B091D0B0E6C38455BD37", hash_generated_field = "D887640ADBC08AC06C7E862F6B2948A7")

    private PowerManager mPM;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.396 -0400", hash_original_field = "69E45E7E240C011D8CB3CFDE90D76B33", hash_generated_field = "C0FF63B0998195CF037A71BFC5C5B113")

    private PowerManager.WakeLock mWakeLock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.397 -0400", hash_original_field = "DB22CBBBA4232CCCF970C3FC49AB0E66", hash_generated_field = "B4049EFC834BB6737E313A170325906D")

    private PowerManager.WakeLock mShowKeyguardWakeLock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.397 -0400", hash_original_field = "0EFF25E6ABD115AE896E7222592093F0", hash_generated_field = "E428E6C01983426A7B60DDC4FCE7BDD3")

    private PowerManager.WakeLock mWakeAndHandOff;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.397 -0400", hash_original_field = "84E503572656FC78D473292D7834055E", hash_generated_field = "0A1613EB8179D3E619F4AE51A8D0DB08")

    private KeyguardViewManager mKeyguardViewManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.397 -0400", hash_original_field = "9ECB499D95A980A328EE6AF10E58635B", hash_generated_field = "334166752652B026EB72B04DEF1CD364")

    private boolean mExternallyEnabled = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.398 -0400", hash_original_field = "658316B8951419F5A495D54336640E46", hash_generated_field = "5F4E59529E64265F78AEEDA6282A4962")

    private boolean mNeedToReshowWhenReenabled = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.398 -0400", hash_original_field = "B150E8FC39372026A2B260E47009CF79", hash_generated_field = "524E990B3B93C6331366CC3FFD800C87")

    private boolean mShowing = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.398 -0400", hash_original_field = "1EB318E8278226E717511D46CDE67B89", hash_generated_field = "E1705B6ADDE006B7DD1DA0CDAD52B28C")

    private boolean mHidden = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.398 -0400", hash_original_field = "99599EDF589B1556B983F19A870C27B5", hash_generated_field = "ADD175D5FE415818592BC6DE0F3426E6")

    private int mDelayedShowingSequence;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.398 -0400", hash_original_field = "6A9758579C542D9F5443CF167CC66F2D", hash_generated_field = "9E07085859E4BFF0C77DAFED7FCCFB16")

    private int mWakelockSequence;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.399 -0400", hash_original_field = "1804C5EC7AAE0B28B15CFDA061D25829", hash_generated_field = "02113C44C8B24676B65BA7F6A553542B")

    private PhoneWindowManager mCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.399 -0400", hash_original_field = "5E304D9D07A9952F5A9918AEDB970AD9", hash_generated_field = "E58670D5C58697D94B905E52820B1CB0")

    private WindowManagerPolicy.OnKeyguardExitResult mExitSecureCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.399 -0400", hash_original_field = "E016F0C9E138EBE95B0E787A66BF2EC6", hash_generated_field = "4F4B4FB3EFE847696CBBFFBFC6C14CCC")

    private KeyguardViewProperties mKeyguardViewProperties;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.399 -0400", hash_original_field = "E8A7E633D99E3BACB8ADFBBABB173D14", hash_generated_field = "22DCE3AFB482F86E6B2E96F873097CE0")

    private KeyguardUpdateMonitor mUpdateMonitor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.399 -0400", hash_original_field = "E9B5B52E8CE74F603A2ABB9A66A9E4DC", hash_generated_field = "E664E36C7B6A0371A0EDDAE74F27F2FF")

    private boolean mKeyboardOpen = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.399 -0400", hash_original_field = "827F65345D6ECF634C239C686A751B07", hash_generated_field = "C33AFD7DADA62D8CDED907E93833EEC1")

    private boolean mScreenOn = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.400 -0400", hash_original_field = "EC585D092493663D8616AA1464C9107C", hash_generated_field = "836D36657C2FFD967663DF511B06E526")

    private String mPhoneState = TelephonyManager.EXTRA_STATE_IDLE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.400 -0400", hash_original_field = "B38C1D38E94433EC8052A97DF33AD13A", hash_generated_field = "E591C88ED33E020CCF89A688D74ACA3B")

    private Intent mUserPresentIntent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.400 -0400", hash_original_field = "D0FE1767883EBB98AFA9DB5615B35EC9", hash_generated_field = "07360DA6F36DA90A55380355FBE6AF10")

    private boolean mWaitingUntilKeyguardVisible = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.400 -0400", hash_original_field = "EAA1758ACB8C3815224ED7417E5328B5", hash_generated_field = "FB69BB5EA99FF1AC6B151A37F4FEA26C")

    private LockPatternUtils mLockPatternUtils;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.400 -0400", hash_original_field = "267A92507BAD20108733D166462E567A", hash_generated_field = "7D8EE22DA6CC16B10D1483BAB0070E39")

    private SoundPool mLockSounds;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.400 -0400", hash_original_field = "3BA1D9788DA5A938E889E58A74876C57", hash_generated_field = "86DE795C36E48BF8632B1BD9CDAE9CEE")

    private int mLockSoundId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.400 -0400", hash_original_field = "37729672B000AC9FAACF675A290E62B5", hash_generated_field = "6B123BA6CF13DC4478200C61D15EB80D")

    private int mUnlockSoundId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.401 -0400", hash_original_field = "F049AFD11ACCC3FD44CC454546242164", hash_generated_field = "1E78738108622DC709CD8A8817458C9F")

    private int mLockSoundStreamId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.401 -0400", hash_original_field = "2B914065F042876989509B1444F54753", hash_generated_field = "61D9EA954496E0E8E65D95A2D5281860")

    private int mMasterStreamMaxVolume;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.403 -0400", hash_original_field = "58E5AF20EC901B9DD3CA72D38EE2FF95", hash_generated_field = "498C1616BC844FA80DE93E5E2B594E90")

    private BroadcastReceiver mBroadCastReceiver = new BroadcastReceiver()    {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.402 -0400", hash_original_method = "D504872DDB764928CA65D5C5C12ACB41", hash_generated_method = "02767C704E63637A042937657749B3F1")
        @Override
        public void onReceive(Context context, Intent intent) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(intent.getTaint());
            addTaint(context.getTaint());
            final String action = intent.getAction();
            if(action.equals(DELAYED_KEYGUARD_ACTION))            
            {
                int sequence = intent.getIntExtra("seq", 0);
                if(DEBUG)                
Log.d(TAG, "received DELAYED_KEYGUARD_ACTION with seq = "+sequence+", mDelayedShowingSequence = "+mDelayedShowingSequence)
                synchronized
(KeyguardViewMediator.this)                {
                    if(mDelayedShowingSequence==sequence)                    
                    {
mSuppressNextLockSound=truedoKeyguardLocked()
                    } //End block
                } //End block
            } //End block
            else
            if(TelephonyManager.ACTION_PHONE_STATE_CHANGED.equals(action))            
            {
mPhoneState=intent.getStringExtra(TelephonyManager.EXTRA_STATE)                synchronized
(KeyguardViewMediator.this)                {
                    if(TelephonyManager.EXTRA_STATE_IDLE.equals(mPhoneState)&&!mScreenOn&&mExternallyEnabled)                    
                    {
                        if(DEBUG)                        
Log.d(TAG, "screen is off and call ended, let's make sure the "+"keyguard is showing")
doKeyguardLocked()
                    } //End block
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }
;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.405 -0400", hash_original_field = "6716F474C5111FE534FA0C2EF266F750", hash_generated_field = "ACCC58508A0E930545196E92F19E2B6E")

    private Handler mHandler = new Handler()    {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.404 -0400", hash_original_method = "4E37F2113D176203DA63E570EDFBEEB7", hash_generated_method = "8C4427C325FE3FF11BFBC9C163D9FA37")
        @Override
        public void handleMessage(Message msg) {
            addTaint(msg.getTaint());
            switch(msg.what){
            case TIMEOUT:
handleTimeout(msg.arg1)            return;
            case SHOW:
handleShow()            return;
            case HIDE:
handleHide()            return;
            case RESET:
handleReset()            return;
            case VERIFY_UNLOCK:
handleVerifyUnlock()            return;
            case NOTIFY_SCREEN_OFF:
handleNotifyScreenOff()            return;
            case NOTIFY_SCREEN_ON:
handleNotifyScreenOn((KeyguardViewManager.ShowListener) msg.obj)            return;
            case WAKE_WHEN_READY:
handleWakeWhenReady(msg.arg1)            return;
            case KEYGUARD_DONE:
handleKeyguardDone(msg.arg1!=0)            return;
            case KEYGUARD_DONE_DRAWING:
handleKeyguardDoneDrawing()            return;
            case KEYGUARD_DONE_AUTHENTICATING:
keyguardDone(true)            return;
            case SET_HIDDEN:
handleSetHidden(msg.arg1!=0)            break;
            case KEYGUARD_TIMEOUT:
            synchronized
(KeyguardViewMediator.this)            {
doKeyguardLocked()
            } //End block
            break;
}
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }
;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.408 -0400", hash_original_method = "DC07C388AD568F8180272F4E33E103F3", hash_generated_method = "4DE4217DA3A1FD8B36692E50DA2FDF0E")
    public  KeyguardViewMediator(Context context, PhoneWindowManager callback,
            LocalPowerManager powerManager) {
        addTaint(powerManager.getTaint());
        addTaint(callback.getTaint());
        addTaint(context.getTaint());
mContext=contextmRealPowerManager=powerManagermPM=(PowerManager) context.getSystemService(Context.POWER_SERVICE)mWakeLock=mPM.newWakeLock(PowerManager.FULL_WAKE_LOCK|PowerManager.ACQUIRE_CAUSES_WAKEUP, "keyguard")mWakeLock.setReferenceCounted(false)mShowKeyguardWakeLock=mPM.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "show keyguard")mShowKeyguardWakeLock.setReferenceCounted(false)mWakeAndHandOff=mPM.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "keyguardWakeAndHandOff")mWakeAndHandOff.setReferenceCounted(false)        IntentFilter filter = new IntentFilter();
filter.addAction(DELAYED_KEYGUARD_ACTION)filter.addAction(TelephonyManager.ACTION_PHONE_STATE_CHANGED)context.registerReceiver(mBroadCastReceiver, filter)mAlarmManager=(AlarmManager) context.getSystemService(Context.ALARM_SERVICE)mCallback=callbackmUpdateMonitor=new KeyguardUpdateMonitor(context)mUpdateMonitor.registerInfoCallback(this)mUpdateMonitor.registerSimStateCallback(this)mLockPatternUtils=new LockPatternUtils(mContext)mKeyguardViewProperties=new LockPatternKeyguardViewProperties(mLockPatternUtils, mUpdateMonitor)mKeyguardViewManager=new KeyguardViewManager(context, WindowManagerImpl.getDefault(), this, mKeyguardViewProperties, mUpdateMonitor)mUserPresentIntent=new Intent(Intent.ACTION_USER_PRESENT)mUserPresentIntent.addFlags(Intent.FLAG_RECEIVER_REPLACE_PENDING|Intent.FLAG_RECEIVER_REGISTERED_ONLY_BEFORE_BOOT)        final ContentResolver cr = mContext.getContentResolver();
mShowLockIcon=(Settings.System.getInt(cr, "show_status_bar_lock", 0)==1)mLockSounds=new SoundPool(1, AudioManager.STREAM_SYSTEM, 0)        String soundPath = Settings.System.getString(cr, Settings.System.LOCK_SOUND);
        if(soundPath!=null)        
        {
mLockSoundId=mLockSounds.load(soundPath, 1)
        } //End block
        if(soundPath==null||mLockSoundId==0)        
        {
            if(DEBUG)            
Log.d(TAG, "failed to load sound from "+soundPath)
        } //End block
soundPath=Settings.System.getString(cr, Settings.System.UNLOCK_SOUND)        if(soundPath!=null)        
        {
mUnlockSoundId=mLockSounds.load(soundPath, 1)
        } //End block
        if(soundPath==null||mUnlockSoundId==0)        
        {
            if(DEBUG)            
Log.d(TAG, "failed to load sound from "+soundPath)
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.410 -0400", hash_original_method = "27C3FE5B6A67ED7297049B67B790913E", hash_generated_method = "141DEE45EC16D834A7B0C23D381E8A5C")
    public void onSystemReady() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        synchronized
(this)        {
            if(DEBUG)            
Log.d(TAG, "onSystemReady")
mSystemReady=truedoKeyguardLocked()
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (DEBUG) Log.d(TAG, "onSystemReady");
            //mSystemReady = true;
            //doKeyguardLocked();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.412 -0400", hash_original_method = "409CC136ADCFB8D313545ED1DAA843DC", hash_generated_method = "42AF772D308E6F1159FEB3B9D9CBCD3C")
    public void onScreenTurnedOff(int why) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(why);
        synchronized
(this)        {
mScreenOn=false            if(DEBUG)            
Log.d(TAG, "onScreenTurnedOff("+why+")")
            final boolean lockImmediately = mLockPatternUtils.getPowerButtonInstantlyLocks() || !mLockPatternUtils.isSecure();
            if(mExitSecureCallback!=null)            
            {
                if(DEBUG)                
Log.d(TAG, "pending exit secure callback cancelled")
mExitSecureCallback.onKeyguardExitResult(false)mExitSecureCallback=null                if(!mExternallyEnabled)                
                {
hideLocked()
                } //End block
            } //End block
            else
            if(mShowing)            
            {
notifyScreenOffLocked()resetStateLocked()
            } //End block
            else
            if(why==WindowManagerPolicy.OFF_BECAUSE_OF_TIMEOUT||(why==WindowManagerPolicy.OFF_BECAUSE_OF_USER&&!lockImmediately))            
            {
                final ContentResolver cr = mContext.getContentResolver();
                long displayTimeout = Settings.System.getInt(cr, SCREEN_OFF_TIMEOUT,
                        KEYGUARD_DISPLAY_TIMEOUT_DELAY_DEFAULT);
                final long lockAfterTimeout = Settings.Secure.getInt(cr,
                        Settings.Secure.LOCK_SCREEN_LOCK_AFTER_TIMEOUT,
                        KEYGUARD_LOCK_AFTER_DELAY_DEFAULT);
                final long policyTimeout = mLockPatternUtils.getDevicePolicyManager()
                        .getMaximumTimeToLock(null);
                long timeout;
                if(policyTimeout>0)                
                {
displayTimeout=Math.max(displayTimeout, 0)timeout=Math.min(policyTimeout-displayTimeout, lockAfterTimeout)
                } //End block
                else
                {
timeout=lockAfterTimeout
                } //End block
                if(timeout<=0)                
                {
mSuppressNextLockSound=truedoKeyguardLocked()
                } //End block
                else
                {
                    long when = SystemClock.elapsedRealtime() + timeout;
                    Intent intent = new Intent(DELAYED_KEYGUARD_ACTION);
intent.putExtra("seq", mDelayedShowingSequence)                    PendingIntent sender = PendingIntent.getBroadcast(mContext,
                            0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
mAlarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, when, sender)                    if(DEBUG)                    
Log.d(TAG, "setting alarm to turn off keyguard, seq = "+mDelayedShowingSequence)
                } //End block
            } //End block
            else
            if(why==WindowManagerPolicy.OFF_BECAUSE_OF_PROX_SENSOR)            
            {
            } //End block
            else
            {
doKeyguardLocked()
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.415 -0400", hash_original_method = "38D06C5E2734C5266A71ABB89E19F15C", hash_generated_method = "F1B2E5492008A713AEBC323E0C782EA7")
    public void onScreenTurnedOn(KeyguardViewManager.ShowListener showListener) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(showListener.getTaint());
        synchronized
(this)        {
mScreenOn=truemDelayedShowingSequence            if(DEBUG)            
Log.d(TAG, "onScreenTurnedOn, seq = "+mDelayedShowingSequence)
notifyScreenOnLocked(showListener)
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //mScreenOn = true;
            //mDelayedShowingSequence++;
            //if (DEBUG) Log.d(TAG, "onScreenTurnedOn, seq = " + mDelayedShowingSequence);
            //notifyScreenOnLocked(showListener);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.417 -0400", hash_original_method = "E206D035B6BAB454BA004CD200A3DF0C", hash_generated_method = "C1A6E9346D1FCA8B644D109A6D0A9D77")
    public void setKeyguardEnabled(boolean enabled) {
        addTaint(enabled);
        synchronized
(this)        {
            if(DEBUG)            
Log.d(TAG, "setKeyguardEnabled("+enabled+")")
mExternallyEnabled=enabled            if(!enabled&&mShowing)            
            {
                if(mExitSecureCallback!=null)                
                {
                    if(DEBUG)                    
Log.d(TAG, "in process of verifyUnlock request, ignoring")
                    return;
                } //End block
                if(DEBUG)                
Log.d(TAG, "remembering to reshow, hiding keyguard, "+"disabling status bar expansion")
mNeedToReshowWhenReenabled=truehideLocked()
            } //End block
            else
            if(enabled&&mNeedToReshowWhenReenabled)            
            {
                if(DEBUG)                
Log.d(TAG, "previously hidden, reshowing, reenabling "+"status bar expansion")
mNeedToReshowWhenReenabled=false                if(mExitSecureCallback!=null)                
                {
                    if(DEBUG)                    
Log.d(TAG, "onKeyguardExitResult(false), resetting")
mExitSecureCallback.onKeyguardExitResult(false)mExitSecureCallback=nullresetStateLocked()
                } //End block
                else
                {
showLocked()mWaitingUntilKeyguardVisible=truemHandler.sendEmptyMessageDelayed(KEYGUARD_DONE_DRAWING, KEYGUARD_DONE_DRAWING_TIMEOUT_MS)                    if(DEBUG)                    
Log.d(TAG, "waiting until mWaitingUntilKeyguardVisible is false")
                    while
(mWaitingUntilKeyguardVisible)                    
                    {
                        try 
                        {
wait()
                        } //End block
                        catch (InterruptedException e)
                        {
Thread.currentThread().interrupt()
                        } //End block
                    } //End block
                    if(DEBUG)                    
Log.d(TAG, "done waiting for mWaitingUntilKeyguardVisible")
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.419 -0400", hash_original_method = "A764B1296D95970869391C0C32C405FA", hash_generated_method = "0C1ECE69FF5CCA674AC847A454880062")
    public void verifyUnlock(WindowManagerPolicy.OnKeyguardExitResult callback) {
        addTaint(callback.getTaint());
        synchronized
(this)        {
            if(DEBUG)            
Log.d(TAG, "verifyUnlock")
            if(!mUpdateMonitor.isDeviceProvisioned())            
            {
                if(DEBUG)                
Log.d(TAG, "ignoring because device isn't provisioned")
callback.onKeyguardExitResult(false)
            } //End block
            else
            if(mExternallyEnabled)            
            {
callback.onKeyguardExitResult(false)
            } //End block
            else
            if(mExitSecureCallback!=null)            
            {
callback.onKeyguardExitResult(false)
            } //End block
            else
            {
mExitSecureCallback=callbackverifyUnlockLocked()
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (DEBUG) Log.d(TAG, "verifyUnlock");
            //if (!mUpdateMonitor.isDeviceProvisioned()) {
                //if (DEBUG) Log.d(TAG, "ignoring because device isn't provisioned");
                //callback.onKeyguardExitResult(false);
            //} else if (mExternallyEnabled) {
                //Log.w(TAG, "verifyUnlock called when not externally disabled");
                //callback.onKeyguardExitResult(false);
            //} else if (mExitSecureCallback != null) {
                //callback.onKeyguardExitResult(false);
            //} else {
                //mExitSecureCallback = callback;
                //verifyUnlockLocked();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.421 -0400", hash_original_method = "F21458EB6FE36A924A49B40493E1F9F8", hash_generated_method = "73B94EF97199BF339E74BB0A0A3582E4")
    public boolean isShowing() {
        boolean varED7142E6C56E85275A9E1F55586553C1_543244187 = (mShowing);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_815130142 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_815130142;
        // ---------- Original Method ----------
        //return mShowing;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.424 -0400", hash_original_method = "CB843FAA6AF259F41DCA59C086908B96", hash_generated_method = "E8CCD4356BD8636F361DE3EF21EE35B7")
    public boolean isShowingAndNotHidden() {
        boolean var249C5512191AF08CB5F21C97CC248E72_72713889 = (mShowing&&!mHidden);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1245015185 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1245015185;
        // ---------- Original Method ----------
        //return mShowing && !mHidden;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.425 -0400", hash_original_method = "54193805F4888FF9439089446F775B83", hash_generated_method = "7469E486B7F6845B4A577902BB4F575C")
    public void setHidden(boolean isHidden) {
        addTaint(isHidden);
        if(DEBUG)        
Log.d(TAG, "setHidden "+isHidden)
mHandler.removeMessages(SET_HIDDEN)        Message msg = mHandler.obtainMessage(SET_HIDDEN, (isHidden ? 1 : 0), 0);
mHandler.sendMessage(msg)
        // ---------- Original Method ----------
        //if (DEBUG) Log.d(TAG, "setHidden " + isHidden);
        //mHandler.removeMessages(SET_HIDDEN);
        //Message msg = mHandler.obtainMessage(SET_HIDDEN, (isHidden ? 1 : 0), 0);
        //mHandler.sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.427 -0400", hash_original_method = "4942A1C5FBBC4FCAE66D7F0340B17444", hash_generated_method = "F70BDAEB9A8EBA09E6D0C0B8DB9F362A")
    private void handleSetHidden(boolean isHidden) {
        addTaint(isHidden);
        synchronized
(KeyguardViewMediator.this)        {
            if(mHidden!=isHidden)            
            {
mHidden=isHiddenadjustUserActivityLocked()adjustStatusBarLocked()
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (KeyguardViewMediator.this) {
            //if (mHidden != isHidden) {
                //mHidden = isHidden;
                //adjustUserActivityLocked();
                //adjustStatusBarLocked();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.428 -0400", hash_original_method = "D9E7660D783D5773EA962F32212798DE", hash_generated_method = "C015C8F71C96642D1DAA0514AC89138F")
    public void doKeyguardTimeout() {
mHandler.removeMessages(KEYGUARD_TIMEOUT)        Message msg = mHandler.obtainMessage(KEYGUARD_TIMEOUT);
mHandler.sendMessage(msg)
        // ---------- Original Method ----------
        //mHandler.removeMessages(KEYGUARD_TIMEOUT);
        //Message msg = mHandler.obtainMessage(KEYGUARD_TIMEOUT);
        //mHandler.sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.430 -0400", hash_original_method = "4CA49A5E6D4B083A90B8D6B815EB9E9F", hash_generated_method = "887BD0DEDBE595C96BF075684795D46F")
    public boolean isInputRestricted() {
        boolean var2590FCFA81938AAB24D7E0BF4A4BAD9C_124744035 = (mShowing||mNeedToReshowWhenReenabled||!mUpdateMonitor.isDeviceProvisioned());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_922239513 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_922239513;
        // ---------- Original Method ----------
        //return mShowing || mNeedToReshowWhenReenabled || !mUpdateMonitor.isDeviceProvisioned();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.431 -0400", hash_original_method = "4B499D55EE4B69AC7FD7704C49CC9D75", hash_generated_method = "EBEBE7EAD4AC156076F24668652BA053")
    public boolean doLidChangeTq(boolean isLidOpen) {
        addTaint(isLidOpen);
mKeyboardOpen=isLidOpen        if(mUpdateMonitor.isKeyguardBypassEnabled()&&mKeyboardOpen&&!mKeyguardViewProperties.isSecure()&&mKeyguardViewManager.isShowing())        
        {
            if(DEBUG)            
Log.d(TAG, "bypassing keyguard on sliding open of keyboard with non-secure keyguard")
mHandler.sendEmptyMessage(KEYGUARD_DONE_AUTHENTICATING)            boolean varB326B5062B2F0E69046810717534CB09_1135969359 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_953459034 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_953459034;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1611728047 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2146788458 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2146788458;
        // ---------- Original Method ----------
        //mKeyboardOpen = isLidOpen;
        //if (mUpdateMonitor.isKeyguardBypassEnabled() && mKeyboardOpen
                //&& !mKeyguardViewProperties.isSecure() && mKeyguardViewManager.isShowing()) {
            //if (DEBUG) Log.d(TAG, "bypassing keyguard on sliding open of keyboard with non-secure keyguard");
            //mHandler.sendEmptyMessage(KEYGUARD_DONE_AUTHENTICATING);
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.433 -0400", hash_original_method = "4161D2866F0C6E5454434FC3D5E7522D", hash_generated_method = "61A35C73EC2B00DF56A8331E7094A1BD")
    private void doKeyguardLocked() {
        if(!mExternallyEnabled)        
        {
            if(DEBUG)            
Log.d(TAG, "doKeyguard: not showing because externally disabled")
            return;
        } //End block
        if(mKeyguardViewManager.isShowing())        
        {
            if(DEBUG)            
Log.d(TAG, "doKeyguard: not showing because it is already showing")
            return;
        } //End block
        final boolean requireSim = !SystemProperties.getBoolean("keyguard.no_require_sim",
                false);
        final boolean provisioned = mUpdateMonitor.isDeviceProvisioned();
        final IccCard.State state = mUpdateMonitor.getSimState();
        final boolean lockedOrMissing = state.isPinLocked()
                || ((state == IccCard.State.ABSENT
                || state == IccCard.State.PERM_DISABLED)
                && requireSim);
        if(!lockedOrMissing&&!provisioned)        
        {
            if(DEBUG)            
Log.d(TAG, "doKeyguard: not showing because device isn't provisioned"+" and the sim is not locked or missing")
            return;
        } //End block
        if(mLockPatternUtils.isLockScreenDisabled()&&!lockedOrMissing)        
        {
            if(DEBUG)            
Log.d(TAG, "doKeyguard: not showing because lockscreen is off")
            return;
        } //End block
        if(DEBUG)        
Log.d(TAG, "doKeyguard: showing the lock screen")
showLocked()
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.436 -0400", hash_original_method = "582C386D9C457D875216789BAEFC0B05", hash_generated_method = "44B76DC23231675DD861F3FC7CE6983E")
    private void resetStateLocked() {
        if(DEBUG)        
Log.d(TAG, "resetStateLocked")
        Message msg = mHandler.obtainMessage(RESET);
mHandler.sendMessage(msg)
        // ---------- Original Method ----------
        //if (DEBUG) Log.d(TAG, "resetStateLocked");
        //Message msg = mHandler.obtainMessage(RESET);
        //mHandler.sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.438 -0400", hash_original_method = "DE75454DC2F05F7752BC9998496FE30E", hash_generated_method = "71980BC575B70AB04AC20A08CADF9DB8")
    private void verifyUnlockLocked() {
        if(DEBUG)        
Log.d(TAG, "verifyUnlockLocked")
mHandler.sendEmptyMessage(VERIFY_UNLOCK)
        // ---------- Original Method ----------
        //if (DEBUG) Log.d(TAG, "verifyUnlockLocked");
        //mHandler.sendEmptyMessage(VERIFY_UNLOCK);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.439 -0400", hash_original_method = "B7D62ABE83F770A5F784A26328B4CE12", hash_generated_method = "6819552CAE47A1F15D24CCC5135F51E5")
    private void notifyScreenOffLocked() {
        if(DEBUG)        
Log.d(TAG, "notifyScreenOffLocked")
mHandler.sendEmptyMessage(NOTIFY_SCREEN_OFF)
        // ---------- Original Method ----------
        //if (DEBUG) Log.d(TAG, "notifyScreenOffLocked");
        //mHandler.sendEmptyMessage(NOTIFY_SCREEN_OFF);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.440 -0400", hash_original_method = "31970844DB530050B49D6EA1F117777E", hash_generated_method = "5A9517475E562750D13B541150EEA5AB")
    private void notifyScreenOnLocked(KeyguardViewManager.ShowListener showListener) {
        addTaint(showListener.getTaint());
        if(DEBUG)        
Log.d(TAG, "notifyScreenOnLocked")
        Message msg = mHandler.obtainMessage(NOTIFY_SCREEN_ON, showListener);
mHandler.sendMessage(msg)
        // ---------- Original Method ----------
        //if (DEBUG) Log.d(TAG, "notifyScreenOnLocked");
        //Message msg = mHandler.obtainMessage(NOTIFY_SCREEN_ON, showListener);
        //mHandler.sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.441 -0400", hash_original_method = "DCC8A74C3062484F18896D352EC2BAD6", hash_generated_method = "E8DC59FEAD739EEADBF3FC424769EE3B")
    private void wakeWhenReadyLocked(int keyCode) {
        addTaint(keyCode);
        if(DBG_WAKE)        
Log.d(TAG, "wakeWhenReadyLocked("+keyCode+")")
mWakeAndHandOff.acquire()        Message msg = mHandler.obtainMessage(WAKE_WHEN_READY, keyCode, 0);
mHandler.sendMessage(msg)
        // ---------- Original Method ----------
        //if (DBG_WAKE) Log.d(TAG, "wakeWhenReadyLocked(" + keyCode + ")");
        //mWakeAndHandOff.acquire();
        //Message msg = mHandler.obtainMessage(WAKE_WHEN_READY, keyCode, 0);
        //mHandler.sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.442 -0400", hash_original_method = "3298B213893E372B4D32A3DA29ACD279", hash_generated_method = "90D9A166C283E3E43F8473504A8F0F8D")
    private void showLocked() {
        if(DEBUG)        
Log.d(TAG, "showLocked")
mShowKeyguardWakeLock.acquire()        Message msg = mHandler.obtainMessage(SHOW);
mHandler.sendMessage(msg)
        // ---------- Original Method ----------
        //if (DEBUG) Log.d(TAG, "showLocked");
        //mShowKeyguardWakeLock.acquire();
        //Message msg = mHandler.obtainMessage(SHOW);
        //mHandler.sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.444 -0400", hash_original_method = "2A6E8FB6A8537E28B60E1338D7539BA7", hash_generated_method = "FD59229CA5FCD7FBD0A6E2659B381B96")
    private void hideLocked() {
        if(DEBUG)        
Log.d(TAG, "hideLocked")
        Message msg = mHandler.obtainMessage(HIDE);
mHandler.sendMessage(msg)
        // ---------- Original Method ----------
        //if (DEBUG) Log.d(TAG, "hideLocked");
        //Message msg = mHandler.obtainMessage(HIDE);
        //mHandler.sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.446 -0400", hash_original_method = "886B3B85454CF5276DF9242F2B7CC98B", hash_generated_method = "CF5754A2903530112C36E8BE0625A590")
    public void onSimStateChanged(IccCard.State simState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(simState.getTaint());
        if(DEBUG)        
Log.d(TAG, "onSimStateChanged: "+simState)
        switch(simState){
        case ABSENT:
        synchronized
(this)        {
            if(!mUpdateMonitor.isDeviceProvisioned())            
            {
                if(!isShowing())                
                {
                    if(DEBUG)                    
Log.d(TAG, "ICC_ABSENT isn't showing,"+" we need to show the keyguard since the "+"device isn't provisioned yet.")
doKeyguardLocked()
                } //End block
                else
                {
resetStateLocked()
                } //End block
            } //End block
        } //End block
        break;
        case PIN_REQUIRED:
        case PUK_REQUIRED:
        synchronized
(this)        {
            if(!isShowing())            
            {
                if(DEBUG)                
Log.d(TAG, "INTENT_VALUE_ICC_LOCKED and keygaurd isn't showing, we need "+"to show the keyguard so the user can enter their sim pin")
doKeyguardLocked()
            } //End block
            else
            {
resetStateLocked()
            } //End block
        } //End block
        break;
        case PERM_DISABLED:
        synchronized
(this)        {
            if(!isShowing())            
            {
                if(DEBUG)                
Log.d(TAG, "PERM_DISABLED and "+"keygaurd isn't showing.")
doKeyguardLocked()
            } //End block
            else
            {
                if(DEBUG)                
Log.d(TAG, "PERM_DISABLED, resetStateLocked to"+"show permanently disabled message in lockscreen.")
resetStateLocked()
            } //End block
        } //End block
        break;
        case READY:
        synchronized
(this)        {
            if(isShowing())            
            {
resetStateLocked()
            } //End block
        } //End block
        break;
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.450 -0400", hash_original_method = "D8840B1C659EAA95D5AAC839F103C0E4", hash_generated_method = "825E266380034DADD8C8A5542F372962")
    public boolean isSecure() {
        boolean var2C299A1141F4A6B156846B647DC41410_443777251 = (mKeyguardViewProperties.isSecure());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_800794737 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_800794737;
        // ---------- Original Method ----------
        //return mKeyguardViewProperties.isSecure();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.454 -0400", hash_original_method = "B347C0DF1F016E0771A376DB2382FFB2", hash_generated_method = "0C0CB6597A9DA27126487543B3356A73")
    public boolean onWakeKeyWhenKeyguardShowingTq(int keyCode, boolean isDocked) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(isDocked);
        addTaint(keyCode);
        if(DEBUG)        
Log.d(TAG, "onWakeKeyWhenKeyguardShowing("+keyCode+")")
        if(isWakeKeyWhenKeyguardShowing(keyCode, isDocked))        
        {
wakeWhenReadyLocked(keyCode)            boolean varB326B5062B2F0E69046810717534CB09_1121917157 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1319885455 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1319885455;
        } //End block
        else
        {
            boolean var68934A3E9455FA72420237EB05902327_421561225 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_595027031 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_595027031;
        } //End block
        // ---------- Original Method ----------
        //if (DEBUG) Log.d(TAG, "onWakeKeyWhenKeyguardShowing(" + keyCode + ")");
        //if (isWakeKeyWhenKeyguardShowing(keyCode, isDocked)) {
            //wakeWhenReadyLocked(keyCode);
            //return true;
        //} else {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.457 -0400", hash_original_method = "A0F91849DFC76F2BEB9F72C6A4618140", hash_generated_method = "FAA8507EE0F844D2DC390069437B8703")
    private boolean isWakeKeyWhenKeyguardShowing(int keyCode, boolean isDocked) {
        addTaint(isDocked);
        addTaint(keyCode);
        switch(keyCode){
        case KeyEvent.KEYCODE_VOLUME_UP:
        case KeyEvent.KEYCODE_VOLUME_DOWN:
        case KeyEvent.KEYCODE_VOLUME_MUTE:
        boolean var3B7CB6FEDC251481443F7A87B374788B_1962786097 = (isDocked);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1131626485 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1131626485;
        case KeyEvent.KEYCODE_MUTE:
        case KeyEvent.KEYCODE_HEADSETHOOK:
        case KeyEvent.KEYCODE_MEDIA_PLAY:
        case KeyEvent.KEYCODE_MEDIA_PAUSE:
        case KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE:
        case KeyEvent.KEYCODE_MEDIA_STOP:
        case KeyEvent.KEYCODE_MEDIA_NEXT:
        case KeyEvent.KEYCODE_MEDIA_PREVIOUS:
        case KeyEvent.KEYCODE_MEDIA_REWIND:
        case KeyEvent.KEYCODE_MEDIA_RECORD:
        case KeyEvent.KEYCODE_MEDIA_FAST_FORWARD:
        case KeyEvent.KEYCODE_CAMERA:
        boolean var68934A3E9455FA72420237EB05902327_736379717 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_422384117 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_422384117;
}        boolean varB326B5062B2F0E69046810717534CB09_1918399412 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_71657258 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_71657258;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.460 -0400", hash_original_method = "A4442CD00D76E22D37756FD9E682E1B1", hash_generated_method = "ED5FC2B1E6D8C2F3B0CD094EDD288DFE")
    public boolean onWakeMotionWhenKeyguardShowingTq() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        if(DEBUG)        
Log.d(TAG, "onWakeMotionWhenKeyguardShowing()")
wakeWhenReadyLocked(KeyEvent.KEYCODE_UNKNOWN)        boolean varB326B5062B2F0E69046810717534CB09_1250205154 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_374963783 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_374963783;
        // ---------- Original Method ----------
        //if (DEBUG) Log.d(TAG, "onWakeMotionWhenKeyguardShowing()");
        //wakeWhenReadyLocked(KeyEvent.KEYCODE_UNKNOWN);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.461 -0400", hash_original_method = "BA52AE927A87937201694EEBD6D0C0F6", hash_generated_method = "215A12F50AD87DA7639DD1FDD05E500A")
    public void pokeWakelock() {
pokeWakelock(mKeyboardOpen?AWAKE_INTERVAL_DEFAULT_KEYBOARD_OPEN_MS:AWAKE_INTERVAL_DEFAULT_KEYBOARD_OPEN_MS)
        // ---------- Original Method ----------
        //pokeWakelock(mKeyboardOpen ?
                //AWAKE_INTERVAL_DEFAULT_KEYBOARD_OPEN_MS : AWAKE_INTERVAL_DEFAULT_MS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.463 -0400", hash_original_method = "5CF2F634ECB813509BFA5ECF29C8BB99", hash_generated_method = "B1BE8174A9957D8F581EB19935A67B72")
    public void pokeWakelock(int holdMs) {
        addTaint(holdMs);
        synchronized
(this)        {
            if(DBG_WAKE)            
Log.d(TAG, "pokeWakelock("+holdMs+")")
mWakeLock.acquire()mHandler.removeMessages(TIMEOUT)mWakelockSequence            Message msg = mHandler.obtainMessage(TIMEOUT, mWakelockSequence, 0);
mHandler.sendMessageDelayed(msg, holdMs)
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (DBG_WAKE) Log.d(TAG, "pokeWakelock(" + holdMs + ")");
            //mWakeLock.acquire();
            //mHandler.removeMessages(TIMEOUT);
            //mWakelockSequence++;
            //Message msg = mHandler.obtainMessage(TIMEOUT, mWakelockSequence, 0);
            //mHandler.sendMessageDelayed(msg, holdMs);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.464 -0400", hash_original_method = "826FABDE89518BF9318BCCB12B1C77DA", hash_generated_method = "21ECE233CC84194EC3394BCE97B3E89C")
    public void keyguardDone(boolean authenticated) {
        addTaint(authenticated);
keyguardDone(authenticated, true)
        // ---------- Original Method ----------
        //keyguardDone(authenticated, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.467 -0400", hash_original_method = "E60955BB2E2EFC4C048FFA6DBFD010BB", hash_generated_method = "8394FE2C81D22D9B1004C1784F843BC3")
    public void keyguardDone(boolean authenticated, boolean wakeup) {
        addTaint(wakeup);
        addTaint(authenticated);
        synchronized
(this)        {
EventLog.writeEvent(70000, 2)            if(DEBUG)            
Log.d(TAG, "keyguardDone("+authenticated+")")
            Message msg = mHandler.obtainMessage(KEYGUARD_DONE);
msg.arg1=wakeup?1:1mHandler.sendMessage(msg)            if(authenticated)            
            {
mUpdateMonitor.clearFailedAttempts()
            } //End block
            if(mExitSecureCallback!=null)            
            {
mExitSecureCallback.onKeyguardExitResult(authenticated)mExitSecureCallback=null                if(authenticated)                
                {
mExternallyEnabled=truemNeedToReshowWhenReenabled=false
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //EventLog.writeEvent(70000, 2);
            //if (DEBUG) Log.d(TAG, "keyguardDone(" + authenticated + ")");
            //Message msg = mHandler.obtainMessage(KEYGUARD_DONE);
            //msg.arg1 = wakeup ? 1 : 0;
            //mHandler.sendMessage(msg);
            //if (authenticated) {
                //mUpdateMonitor.clearFailedAttempts();
            //}
            //if (mExitSecureCallback != null) {
                //mExitSecureCallback.onKeyguardExitResult(authenticated);
                //mExitSecureCallback = null;
                //if (authenticated) {
                    //mExternallyEnabled = true;
                    //mNeedToReshowWhenReenabled = false;
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.469 -0400", hash_original_method = "5B02F2E5FA290763B024133F06976F8F", hash_generated_method = "FABF5DBB71750546E95F516CDF0347B8")
    public void keyguardDoneDrawing() {
mHandler.sendEmptyMessage(KEYGUARD_DONE_DRAWING)
        // ---------- Original Method ----------
        //mHandler.sendEmptyMessage(KEYGUARD_DONE_DRAWING);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.471 -0400", hash_original_method = "F8A3D0A4029822754906EA3420202F09", hash_generated_method = "EDF9D2F14BFEFBBD49FB9525EDF103FA")
    private void handleKeyguardDone(boolean wakeup) {
        addTaint(wakeup);
        if(DEBUG)        
Log.d(TAG, "handleKeyguardDone")
handleHide()        if(wakeup)        
        {
mPM.userActivity(SystemClock.uptimeMillis(), true)
        } //End block
mWakeLock.release()mContext.sendBroadcast(mUserPresentIntent)
        // ---------- Original Method ----------
        //if (DEBUG) Log.d(TAG, "handleKeyguardDone");
        //handleHide();
        //if (wakeup) {
            //mPM.userActivity(SystemClock.uptimeMillis(), true);
        //}
        //mWakeLock.release();
        //mContext.sendBroadcast(mUserPresentIntent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.473 -0400", hash_original_method = "17C37AE3BFFF5EFB5E4E7065B94980D8", hash_generated_method = "8906AC6AC77912943A83BD8982F76DD7")
    private void handleKeyguardDoneDrawing() {
        synchronized
(this)        {
            if(false)            
Log.d(TAG, "handleKeyguardDoneDrawing")
            if(mWaitingUntilKeyguardVisible)            
            {
                if(DEBUG)                
Log.d(TAG, "handleKeyguardDoneDrawing: notifying mWaitingUntilKeyguardVisible")
mWaitingUntilKeyguardVisible=falsenotifyAll()mHandler.removeMessages(KEYGUARD_DONE_DRAWING)
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized(this) {
            //if (false) Log.d(TAG, "handleKeyguardDoneDrawing");
            //if (mWaitingUntilKeyguardVisible) {
                //if (DEBUG) Log.d(TAG, "handleKeyguardDoneDrawing: notifying mWaitingUntilKeyguardVisible");
                //mWaitingUntilKeyguardVisible = false;
                //notifyAll();
                //mHandler.removeMessages(KEYGUARD_DONE_DRAWING);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.476 -0400", hash_original_method = "203C569340FA906D5FA6A4CFEC051EF9", hash_generated_method = "2563762972487F0F55D3BDA744637AB7")
    private void handleTimeout(int seq) {
        addTaint(seq);
        synchronized
(KeyguardViewMediator.this)        {
            if(DEBUG)            
Log.d(TAG, "handleTimeout")
            if(seq==mWakelockSequence)            
            {
mWakeLock.release()
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (KeyguardViewMediator.this) {
            //if (DEBUG) Log.d(TAG, "handleTimeout");
            //if (seq == mWakelockSequence) {
                //mWakeLock.release();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.479 -0400", hash_original_method = "4E74A3A3B6258DD9858CF89D32BF59D1", hash_generated_method = "E765DA4F24EE943C1541839DDEFDCBFC")
    private void playSounds(boolean locked) {
        addTaint(locked);
        if(mSuppressNextLockSound)        
        {
mSuppressNextLockSound=false            return;
        } //End block
        final ContentResolver cr = mContext.getContentResolver();
        if(Settings.System.getInt(cr, Settings.System.LOCKSCREEN_SOUNDS_ENABLED, 1)==1)        
        {
            final int whichSound = locked
                ? mLockSoundId
                : mUnlockSoundId;
mLockSounds.stop(mLockSoundStreamId)            if(mAudioManager==null)            
            {
mAudioManager=(AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE)                if(mAudioManager==null)                
                return;
mMasterStreamMaxVolume=mAudioManager.getStreamMaxVolume(MASTER_STREAM_TYPE)
            } //End block
            if(mAudioManager.isStreamMute(MASTER_STREAM_TYPE))            
            return;
            float lockSoundVolume;
            int masterStreamVolume = mAudioManager.getStreamVolume(MASTER_STREAM_TYPE);
            if(masterStreamVolume==0)            
            {
                return;
            } //End block
            else
            {
lockSoundVolume=MIN_LOCK_VOLUME+(MAX_LOCK_VOLUME-MIN_LOCK_VOLUME)*((float) masterStreamVolume/mMasterStreamMaxVolume)
            } //End block
mLockSoundStreamId=mLockSounds.play(whichSound, lockSoundVolume, lockSoundVolume, 1, 0, 1.0f)
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.483 -0400", hash_original_method = "8F80ED2223B8803A28AC093D1982BA6B", hash_generated_method = "209C8841E2C4400A0DF7A261CA6D58C8")
    private void handleShow() {
        synchronized
(KeyguardViewMediator.this)        {
            if(DEBUG)            
Log.d(TAG, "handleShow")
            if(!mSystemReady)            
            return;
mKeyguardViewManager.show()mShowing=trueadjustUserActivityLocked()adjustStatusBarLocked()            try 
            {
ActivityManagerNative.getDefault().closeSystemDialogs("lock")
            } //End block
            catch (RemoteException e)
            {
            } //End block
playSounds(true)mShowKeyguardWakeLock.release()
        } //End block
        // ---------- Original Method ----------
        //synchronized (KeyguardViewMediator.this) {
            //if (DEBUG) Log.d(TAG, "handleShow");
            //if (!mSystemReady) return;
            //mKeyguardViewManager.show();
            //mShowing = true;
            //adjustUserActivityLocked();
            //adjustStatusBarLocked();
            //try {
                //ActivityManagerNative.getDefault().closeSystemDialogs("lock");
            //} catch (RemoteException e) {
            //}
            //playSounds(true);
            //mShowKeyguardWakeLock.release();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.485 -0400", hash_original_method = "35D6156A5468C5E90836466938841E86", hash_generated_method = "5A263C9D5D942CD316DB526DE7F0F3C4")
    private void handleHide() {
        synchronized
(KeyguardViewMediator.this)        {
            if(DEBUG)            
Log.d(TAG, "handleHide")
            if(mWakeAndHandOff.isHeld())            
            {
                return;
            } //End block
            if(TelephonyManager.EXTRA_STATE_IDLE.equals(mPhoneState))            
            {
playSounds(false)
            } //End block
mKeyguardViewManager.hide()mShowing=falseadjustUserActivityLocked()adjustStatusBarLocked()
        } //End block
        // ---------- Original Method ----------
        //synchronized (KeyguardViewMediator.this) {
            //if (DEBUG) Log.d(TAG, "handleHide");
            //if (mWakeAndHandOff.isHeld()) {
                //Log.w(TAG, "attempt to hide the keyguard while waking, ignored");
                //return;
            //}
            //if (TelephonyManager.EXTRA_STATE_IDLE.equals(mPhoneState)) {
                //playSounds(false);
            //}
            //mKeyguardViewManager.hide();
            //mShowing = false;
            //adjustUserActivityLocked();
            //adjustStatusBarLocked();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.487 -0400", hash_original_method = "260167DCE16AB67A60A69D63FB8EF40F", hash_generated_method = "72415A79FD9BF216730AFB0ABC0B9A7C")
    private void adjustUserActivityLocked() {
        if(DEBUG)        
Log.d(TAG, "adjustUserActivityLocked mShowing: "+mShowing+" mHidden: "+mHidden)
        boolean enabled = !mShowing || mHidden;
mRealPowerManager.enableUserActivity(enabled)        if(!enabled&&mScreenOn)        
        {
pokeWakelock()
        } //End block
        // ---------- Original Method ----------
        //if (DEBUG) Log.d(TAG, "adjustUserActivityLocked mShowing: " + mShowing + " mHidden: " + mHidden);
        //boolean enabled = !mShowing || mHidden;
        //mRealPowerManager.enableUserActivity(enabled);
        //if (!enabled && mScreenOn) {
            //pokeWakelock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.489 -0400", hash_original_method = "F5FFEF7EE8616FB689BD7AEDBCBB85BC", hash_generated_method = "9744A000D7E4745C5F275B43B48C1ED4")
    private void adjustStatusBarLocked() {
        if(mStatusBarManager==null)        
        {
mStatusBarManager=(StatusBarManager) mContext.getSystemService(Context.STATUS_BAR_SERVICE)
        } //End block
        if(mStatusBarManager==null)        
        {
        } //End block
        else
        {
            if(mShowLockIcon)            
            {
                if(mShowing&&isSecure())                
                {
                    if(!mShowingLockIcon)                    
                    {
                        String contentDescription = mContext.getString(
                                com.android.internal.R.string.status_bar_device_locked);
mStatusBarManager.setIcon("secure", com.android.internal.R.drawable.stat_sys_secure, 0, contentDescription)mShowingLockIcon=true
                    } //End block
                } //End block
                else
                {
                    if(mShowingLockIcon)                    
                    {
mStatusBarManager.removeIcon("secure")mShowingLockIcon=false
                    } //End block
                } //End block
            } //End block
            int flags = StatusBarManager.DISABLE_NONE;
            if(mShowing)            
            {
flags|=StatusBarManager.DISABLE_RECENT                if(isSecure()||!ENABLE_INSECURE_STATUS_BAR_EXPAND)                
                {
flags|=StatusBarManager.DISABLE_EXPAND
                } //End block
                if(isSecure())                
                {
flags|=StatusBarManager.DISABLE_NOTIFICATION_TICKER
                } //End block
            } //End block
            if(DEBUG)            
            {
Log.d(TAG, "adjustStatusBarLocked: mShowing="+mShowing+" mHidden="+mHidden+" isSecure="+isSecure()+" --> flags=0x"+Integer.toHexString(flags))
            } //End block
mStatusBarManager.disable(flags)
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.492 -0400", hash_original_method = "29E6AEABA1247B1C2F2D2671B77D9A2B", hash_generated_method = "8AA7DBDCF362038B7122D9C98978710A")
    private void handleWakeWhenReady(int keyCode) {
        addTaint(keyCode);
        synchronized
(KeyguardViewMediator.this)        {
            if(DBG_WAKE)            
Log.d(TAG, "handleWakeWhenReady("+keyCode+")")
            if(!mKeyguardViewManager.wakeWhenReadyTq(keyCode))            
            {
pokeWakelock()
            } //End block
mWakeAndHandOff.release()            if(!mWakeLock.isHeld())            
            {
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (KeyguardViewMediator.this) {
            //if (DBG_WAKE) Log.d(TAG, "handleWakeWhenReady(" + keyCode + ")");
            //if (!mKeyguardViewManager.wakeWhenReadyTq(keyCode)) {
                //Log.w(TAG, "mKeyguardViewManager.wakeWhenReadyTq did not poke wake lock, so poke it ourselves");
                //pokeWakelock();
            //}
            //mWakeAndHandOff.release();
            //if (!mWakeLock.isHeld()) {
                //Log.w(TAG, "mWakeLock not held in mKeyguardViewManager.wakeWhenReadyTq");
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.495 -0400", hash_original_method = "F3EEA97F707C979B0F8D15E6FBAAA3CC", hash_generated_method = "D67553F0DC68543D29D85A87A99F9E4F")
    private void handleReset() {
        synchronized
(KeyguardViewMediator.this)        {
            if(DEBUG)            
Log.d(TAG, "handleReset")
mKeyguardViewManager.reset()
        } //End block
        // ---------- Original Method ----------
        //synchronized (KeyguardViewMediator.this) {
            //if (DEBUG) Log.d(TAG, "handleReset");
            //mKeyguardViewManager.reset();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.498 -0400", hash_original_method = "DADB089A4CF4A8E00840978109CEC008", hash_generated_method = "228F597F97E8D05371931D0E6E7BD65E")
    private void handleVerifyUnlock() {
        synchronized
(KeyguardViewMediator.this)        {
            if(DEBUG)            
Log.d(TAG, "handleVerifyUnlock")
mKeyguardViewManager.verifyUnlock()mShowing=true
        } //End block
        // ---------- Original Method ----------
        //synchronized (KeyguardViewMediator.this) {
            //if (DEBUG) Log.d(TAG, "handleVerifyUnlock");
            //mKeyguardViewManager.verifyUnlock();
            //mShowing = true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.499 -0400", hash_original_method = "E5EDEB53B9F32AE58BC3C870E27F29F7", hash_generated_method = "7A9E1942671D99110BC65083F6C49D4D")
    private void handleNotifyScreenOff() {
        synchronized
(KeyguardViewMediator.this)        {
            if(DEBUG)            
Log.d(TAG, "handleNotifyScreenOff")
mKeyguardViewManager.onScreenTurnedOff()
        } //End block
        // ---------- Original Method ----------
        //synchronized (KeyguardViewMediator.this) {
            //if (DEBUG) Log.d(TAG, "handleNotifyScreenOff");
            //mKeyguardViewManager.onScreenTurnedOff();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.502 -0400", hash_original_method = "D1D7CA274023FC9A34E88582997D7EBF", hash_generated_method = "D18C22DD57D853689614BF05C6E4F9C5")
    private void handleNotifyScreenOn(KeyguardViewManager.ShowListener showListener) {
        addTaint(showListener.getTaint());
        synchronized
(KeyguardViewMediator.this)        {
            if(DEBUG)            
Log.d(TAG, "handleNotifyScreenOn")
mKeyguardViewManager.onScreenTurnedOn(showListener)
        } //End block
        // ---------- Original Method ----------
        //synchronized (KeyguardViewMediator.this) {
            //if (DEBUG) Log.d(TAG, "handleNotifyScreenOn");
            //mKeyguardViewManager.onScreenTurnedOn(showListener);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.504 -0400", hash_original_method = "35520B12AD608B2996E7C0A68D26A567", hash_generated_method = "089D388B160D82BF50D2E38374FAB014")
    public void onClockVisibilityChanged() {
        //DSFIXME:  CODE0009: Possible callback target function detected
adjustStatusBarLocked()
        // ---------- Original Method ----------
        //adjustStatusBarLocked();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.506 -0400", hash_original_method = "4B9E9460F026DE76884A8E3A89492E86", hash_generated_method = "D18E1F693ECD7FA1C4C570EAE3A27080")
    public void onPhoneStateChanged(int phoneState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(phoneState);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.507 -0400", hash_original_method = "4D8D83CF6E23DB5409DEF076CF56C21F", hash_generated_method = "65A9E8172E6D6914B92836185FBD061F")
    public void onRefreshBatteryInfo(boolean showBatteryInfo, boolean pluggedIn, int batteryLevel) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(batteryLevel);
        addTaint(pluggedIn);
        addTaint(showBatteryInfo);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.509 -0400", hash_original_method = "4BA21EF23ECF97F1E021A0EA81C75239", hash_generated_method = "FE14AC3168D62EE902EBB63E85ECF540")
    public void onRefreshCarrierInfo(CharSequence plmn, CharSequence spn) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(spn.getTaint());
        addTaint(plmn.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.510 -0400", hash_original_method = "BA0B67437B81C41F05DFFCECF2CA0F9A", hash_generated_method = "2BE7F90954C478572E0F6B2C4C1C7AF7")
    public void onRingerModeChanged(int state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(state);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.511 -0400", hash_original_method = "434A1591B741E49285DB2249C0490224", hash_generated_method = "AB6D6AF56F0CCCB69975B4131D786962")
    public void onTimeChanged() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.513 -0400", hash_original_method = "BECDF026B1BBC582649D687AE8596AFF", hash_generated_method = "15BE4971B200BD4734F0E369FA0AE6AE")
    public void onDeviceProvisioned() {
        //DSFIXME:  CODE0009: Possible callback target function detected
mContext.sendBroadcast(mUserPresentIntent)
        // ---------- Original Method ----------
        //mContext.sendBroadcast(mUserPresentIntent);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.514 -0400", hash_original_field = "43BF80547420D58CBDBFBF8C72ACB64B", hash_generated_field = "7066B2454AF770827CED0F9EFD959F06")

    private static final int KEYGUARD_DISPLAY_TIMEOUT_DELAY_DEFAULT = 30000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.514 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "7841AA055B417A7E8C3D727A4ADDD91D")

    private final static boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.515 -0400", hash_original_field = "A856EFB7BB6C4318596C8B4F2620061D", hash_generated_field = "78DC917E348B3971C13FC65D625D92EF")

    private final static boolean DBG_WAKE = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.515 -0400", hash_original_field = "A9E4AA399C575D2F000DAA7EDFB14FF3", hash_generated_field = "7F10486A03C074FBB73BA95C7829BF3D")

    private final static String TAG = "KeyguardViewMediator";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.516 -0400", hash_original_field = "CBF6D645C955340188807BD01F6686F3", hash_generated_field = "ED6EA1599230F895E3103E9678ECC30A")

    private static final String DELAYED_KEYGUARD_ACTION = "com.android.internal.policy.impl.PhoneWindowManager.DELAYED_KEYGUARD";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.516 -0400", hash_original_field = "1BC901D92AF7A80C04577841B6107CC2", hash_generated_field = "E7BB4550132B563D4ABADCCFC6EF1B96")

    private static final int TIMEOUT = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.517 -0400", hash_original_field = "43C97303CFD198F2FCC81B8AECA7C00D", hash_generated_field = "433F24F76384FDE38C0AD105615910D6")

    private static final int SHOW = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.517 -0400", hash_original_field = "BC8CDEBFBB33DAF9A11372157BFCDF49", hash_generated_field = "9622514EC554E1F8149DFA3DB73EDCA6")

    private static final int HIDE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.517 -0400", hash_original_field = "6D9905F76ABF1CEC0FDE43A3A7844479", hash_generated_field = "C3CEEF4C1233AD1CBDD5B5DCD9122689")

    private static final int RESET = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.518 -0400", hash_original_field = "A077B9E84D92A7A8D938594E28007D68", hash_generated_field = "8BA1EBD04F5AF09236959BA5B001EC6C")

    private static final int VERIFY_UNLOCK = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.518 -0400", hash_original_field = "76D62D0A704F17D0172CF6AC1796437A", hash_generated_field = "1745E60C978091740BC4876F6E72314A")

    private static final int NOTIFY_SCREEN_OFF = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.518 -0400", hash_original_field = "574A83EB75FC6A68DEC72740F7C91463", hash_generated_field = "A4D2FAF5838B13986657A89668F16B1E")

    private static final int NOTIFY_SCREEN_ON = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.519 -0400", hash_original_field = "F8F93D199BF037D4EFC5B70394F990CB", hash_generated_field = "9BCB27C3A4BA63421437FA2CB2E04AA0")

    private static final int WAKE_WHEN_READY = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.519 -0400", hash_original_field = "3FFAE8200FD7947A2666F7DAEDE989B1", hash_generated_field = "3F77DF86DE3D77CBB3E8593D2E9C4CC7")

    private static final int KEYGUARD_DONE = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.520 -0400", hash_original_field = "A095D1F010E4351771CB926822A39092", hash_generated_field = "DCAB1778D69533CC7502E1D662A1760E")

    private static final int KEYGUARD_DONE_DRAWING = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.520 -0400", hash_original_field = "30902868268E81E55A1F2A6D8DE88B8C", hash_generated_field = "5035C506B0BDBE1517D2452528B56C62")

    private static final int KEYGUARD_DONE_AUTHENTICATING = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.520 -0400", hash_original_field = "97312A5903FE9060F81A97DA3D3048B9", hash_generated_field = "3D6C5F18214CAC9C5BBE8D47035CB54B")

    private static final int SET_HIDDEN = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.520 -0400", hash_original_field = "AD1654A78A59950B04AF82CE8CF52108", hash_generated_field = "341F63DED1FD92A6FBD99154BCF92551")

    private static final int KEYGUARD_TIMEOUT = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.521 -0400", hash_original_field = "A5928A4C5BCCD71946239707F052694E", hash_generated_field = "148FE5F1F8DF883A525EB3AA0754C65D")

    protected static final int AWAKE_INTERVAL_DEFAULT_MS = 10000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.521 -0400", hash_original_field = "7BA4256991E38BA11ECFE1F26565F82E", hash_generated_field = "9396F834A23A8557A450DD89733D6FFA")

    protected static final int AWAKE_INTERVAL_DEFAULT_KEYBOARD_OPEN_MS = 10000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.522 -0400", hash_original_field = "A2BF440A3E41A114964C6C0428D79ED6", hash_generated_field = "C18CE95FA2181874B208F9B62FBF64F2")

    private static final int KEYGUARD_LOCK_AFTER_DELAY_DEFAULT = 5000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.522 -0400", hash_original_field = "121E657F5419C739EFBCDBA86025526C", hash_generated_field = "BDC2292A18ED0E65C28B8BE66F1679F7")

    private static final int KEYGUARD_DONE_DRAWING_TIMEOUT_MS = 2000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.522 -0400", hash_original_field = "304EE326DBA1FE496057A8124ABB4098", hash_generated_field = "EBB68AAD3E0B56D27D282972545C5902")

    private static final boolean ENABLE_INSECURE_STATUS_BAR_EXPAND = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.523 -0400", hash_original_field = "5D354C7A67D479B0F1BC26591C12C947", hash_generated_field = "F8A11B1A8EE31792B7D4D50453CB1E33")

    private static final int MASTER_STREAM_TYPE = AudioManager.STREAM_RING;
}

