package com.android.internal.policy.impl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.SystemClock;
import com.android.internal.widget.LockPatternView;
import com.android.internal.R;
import com.android.internal.widget.LockPatternView.Cell;
import java.util.List;
import android.util.Log;
import android.view.View;
import android.view.MotionEvent;
import android.widget.Button;
import android.security.KeyStore;
import com.android.internal.widget.LockPatternUtils;
import android.content.Context;
import android.os.CountDownTimer;
import com.android.internal.widget.LinearLayoutWithDefaultTouchRecepient;
import android.content.res.Configuration;
import android.view.LayoutInflater;
class PatternUnlockScreen extends LinearLayoutWithDefaultTouchRecepient implements KeyguardScreen {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.127 -0400", hash_original_field = "D3C5C6E4AF807E4E4D10FE2A79885869", hash_generated_field = "DAD6EEC7C298BF4AE9F19D739E4EFC04")

    private int mFailedPatternAttemptsSinceLastTimeout = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.127 -0400", hash_original_field = "A783D7A429646C96C23B984A757BC38F", hash_generated_field = "FC40855B91161741822D93508F041B68")

    private int mTotalFailedPatternAttempts = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.128 -0400", hash_original_field = "342F806B5DE10921213028D1A29F7B92", hash_generated_field = "7E381B35EA8C4CE8E1061E65F7444B60")

    private CountDownTimer mCountdownTimer = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.128 -0400", hash_original_field = "EAA1758ACB8C3815224ED7417E5328B5", hash_generated_field = "FB69BB5EA99FF1AC6B151A37F4FEA26C")

    private LockPatternUtils mLockPatternUtils;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.128 -0400", hash_original_field = "E8A7E633D99E3BACB8ADFBBABB173D14", hash_generated_field = "22DCE3AFB482F86E6B2E96F873097CE0")

    private KeyguardUpdateMonitor mUpdateMonitor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.128 -0400", hash_original_field = "1804C5EC7AAE0B28B15CFDA061D25829", hash_generated_field = "56BFB4929FFB5B85E16CE5933F964A09")

    private KeyguardScreenCallback mCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.128 -0400", hash_original_field = "0E52283E4B12B2F3A8BC966856829B09", hash_generated_field = "85C5EE6DEF1F00E5529242A9FE8231E3")

    private boolean mEnableFallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.128 -0400", hash_original_field = "CA3AE29687B50BD85F0CB06CCFB84E11", hash_generated_field = "D443E37F869F21F4F6889602CFB5CE23")

    private KeyguardStatusViewManager mKeyguardStatusViewManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.128 -0400", hash_original_field = "A86CAA50CF96FD3E05D7F6D04C50BBC3", hash_generated_field = "19C04F8A0E4B92E10CA9CDB8D6BDE325")

    private LockPatternView mLockPatternView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.128 -0400", hash_original_field = "52626D72937FB65ED914C45C6821092C", hash_generated_field = "CD9B4B9DA2A0E2AB3BFE7C2CF30DC474")

    private long mLastPokeTime = -UNLOCK_PATTERN_WAKE_INTERVAL_MS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.129 -0400", hash_original_field = "A5E26671ED04CAEAA25931CB1FA2E3AB", hash_generated_field = "EEB854D1F5BB811CE9B8674B744AB9BB")

    private Runnable mCancelPatternRunnable = new Runnable()    {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.129 -0400", hash_original_method = "B5718B5D5459A79532D8C97C0F585468", hash_generated_method = "6B32AFED61A2BC85FC9F605B7FEC8889")
        public void run() {
mLockPatternView.clearPattern()
            // ---------- Original Method ----------
            //mLockPatternView.clearPattern();
        }

        
    }
;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.130 -0400", hash_original_field = "06D44B4F2459AFE776AF1181C208F0F5", hash_generated_field = "924A0C7E7DE7D8BFA71F98D071E259FC")

    private final OnClickListener mForgotPatternClick = new OnClickListener()    {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.130 -0400", hash_original_method = "52BF466312D7503FD0E9B257ACE8378D", hash_generated_method = "31B179B73DD033F124EEA8A63D030342")
        public void onClick(View v) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(v.getTaint());
mCallback.forgotPattern(true)
            // ---------- Original Method ----------
            //mCallback.forgotPattern(true);
        }

        
    }
;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.131 -0400", hash_original_field = "58AF443503B1DD98FDC5E12554B1945E", hash_generated_field = "2C940732417A81EFBA57842C8A6E96E3")

    private Button mForgotPatternButton;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.131 -0400", hash_original_field = "8650EFA3EAFF9E8580ED2BAF39D373A4", hash_generated_field = "D4F52B2DF2B3F133070FDB68D5444936")

    private int mCreationOrientation;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.133 -0400", hash_original_method = "4925122297B237965D4EFDEA8677E18A", hash_generated_method = "5ED187F4178C1BF489036A1E8E0172EC")
      PatternUnlockScreen(Context context,
                 Configuration configuration, LockPatternUtils lockPatternUtils,
                 KeyguardUpdateMonitor updateMonitor,
                 KeyguardScreenCallback callback,
                 int totalFailedAttempts) {
        super(context);
        addTaint(totalFailedAttempts);
        addTaint(callback.getTaint());
        addTaint(updateMonitor.getTaint());
        addTaint(lockPatternUtils.getTaint());
        addTaint(configuration.getTaint());
        addTaint(context.getTaint());
mLockPatternUtils=lockPatternUtilsmUpdateMonitor=updateMonitormCallback=callbackmTotalFailedPatternAttempts=totalFailedAttemptsmFailedPatternAttemptsSinceLastTimeout=totalFailedAttempts%LockPatternUtils.FAILED_ATTEMPTS_BEFORE_TIMEOUT        if(DEBUG)        
Log.d(TAG, "UnlockScreen() ctor: totalFailedAttempts="+totalFailedAttempts+", mFailedPat...="+mFailedPatternAttemptsSinceLastTimeout)
mCreationOrientation=configuration.orientation        LayoutInflater inflater = LayoutInflater.from(context);
        if(mCreationOrientation!=Configuration.ORIENTATION_LANDSCAPE)        
        {
Log.d(TAG, "portrait mode")inflater.inflate(R.layout.keyguard_screen_unlock_portrait, this, true)
        } //End block
        else
        {
Log.d(TAG, "landscape mode")inflater.inflate(R.layout.keyguard_screen_unlock_landscape, this, true)
        } //End block
mKeyguardStatusViewManager=new KeyguardStatusViewManager(this, mUpdateMonitor, mLockPatternUtils, mCallback, true)mLockPatternView=(LockPatternView) findViewById(R.id.lockPattern)mForgotPatternButton=(Button) findViewById(R.id.forgotPatternButton)mForgotPatternButton.setText(R.string.lockscreen_forgot_pattern_button_text)mForgotPatternButton.setOnClickListener(mForgotPatternClick)setDefaultTouchRecepient(mLockPatternView)mLockPatternView.setSaveEnabled(false)mLockPatternView.setFocusable(false)mLockPatternView.setOnPatternListener(new UnlockPatternListener())mLockPatternView.setInStealthMode(!mLockPatternUtils.isVisiblePatternEnabled())mLockPatternView.setTactileFeedbackEnabled(mLockPatternUtils.isTactileFeedbackEnabled())updateFooter(FooterMode.Normal)setFocusableInTouchMode(true)
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.134 -0400", hash_original_method = "85981E52C19ADA75205C991FC328DBFC", hash_generated_method = "7E4230D64310B1A2A12286B978F8B7C6")
    private void hideForgotPatternButton() {
mForgotPatternButton.setVisibility(View.GONE)
        // ---------- Original Method ----------
        //mForgotPatternButton.setVisibility(View.GONE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.135 -0400", hash_original_method = "2FA938391E2391C633A876A54EFB754E", hash_generated_method = "CF5F5F1A33CA7C2DC6925E34C6E76A69")
    private void showForgotPatternButton() {
mForgotPatternButton.setVisibility(View.VISIBLE)
        // ---------- Original Method ----------
        //mForgotPatternButton.setVisibility(View.VISIBLE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.136 -0400", hash_original_method = "7B1F5DD96304B1B5FDCCBB699AF363C1", hash_generated_method = "A2004E39678147C0280B9ABE44866A76")
    private void updateFooter(FooterMode mode) {
        addTaint(mode.getTaint());
        switch(mode){
        case Normal:
        if(DEBUG)        
Log.d(TAG, "mode normal")
hideForgotPatternButton()        break;
        case ForgotLockPattern:
        if(DEBUG)        
Log.d(TAG, "mode ForgotLockPattern")
showForgotPatternButton()        break;
        case VerifyUnlocked:
        if(DEBUG)        
Log.d(TAG, "mode VerifyUnlocked")
hideForgotPatternButton()}
        // ---------- Original Method ----------
        //switch (mode) {
            //case Normal:
                //if (DEBUG) Log.d(TAG, "mode normal");
                //hideForgotPatternButton();
                //break;
            //case ForgotLockPattern:
                //if (DEBUG) Log.d(TAG, "mode ForgotLockPattern");
                //showForgotPatternButton();
                //break;
            //case VerifyUnlocked:
                //if (DEBUG) Log.d(TAG, "mode VerifyUnlocked");
                //hideForgotPatternButton();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.138 -0400", hash_original_method = "AE24C4CEFC086A809583D6E9E692D2EF", hash_generated_method = "F613E209FF0FC3015F6259F7FBF23072")
    public void setEnableFallback(boolean state) {
        addTaint(state);
        if(DEBUG)        
Log.d(TAG, "setEnableFallback("+state+")")
mEnableFallback=state
        // ---------- Original Method ----------
        //if (DEBUG) Log.d(TAG, "setEnableFallback(" + state + ")");
        //mEnableFallback = state;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.139 -0400", hash_original_method = "1C94701811A272BEAF6B4075ACB94F9A", hash_generated_method = "7152C98FB4C443DFB93D6D08B5309A30")
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        addTaint(ev.getTaint());
        final boolean result = super.dispatchTouchEvent(ev);
        if(result&&((SystemClock.elapsedRealtime()-mLastPokeTime)>(UNLOCK_PATTERN_WAKE_INTERVAL_MS-100)))        
        {
mLastPokeTime=SystemClock.elapsedRealtime()
        } //End block
        boolean varB4A88417B3D0170D754C647C30B7216A_218781570 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1252442704 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1252442704;
        // ---------- Original Method ----------
        //final boolean result = super.dispatchTouchEvent(ev);
        //if (result &&
                //((SystemClock.elapsedRealtime() - mLastPokeTime)
                        //>  (UNLOCK_PATTERN_WAKE_INTERVAL_MS - 100))) {
            //mLastPokeTime = SystemClock.elapsedRealtime();
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.140 -0400", hash_original_method = "6331E3040958B514A97D037B2388D5C3", hash_generated_method = "43C1BC2DFE566DCEB04263453C0ECD05")
    @Override
    protected void onAttachedToWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
super.onAttachedToWindow()        if(LockPatternKeyguardView.DEBUG_CONFIGURATION)        
        {
        } //End block
        if(getResources().getConfiguration().orientation!=mCreationOrientation)        
        {
mCallback.recreateMe(getResources().getConfiguration())
        } //End block
        // ---------- Original Method ----------
        //super.onAttachedToWindow();
        //if (LockPatternKeyguardView.DEBUG_CONFIGURATION) {
            //Log.v(TAG, "***** PATTERN ATTACHED TO WINDOW");
            //Log.v(TAG, "Cur orient=" + mCreationOrientation
                    //+ ", new config=" + getResources().getConfiguration());
        //}
        //if (getResources().getConfiguration().orientation != mCreationOrientation) {
            //mCallback.recreateMe(getResources().getConfiguration());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.142 -0400", hash_original_method = "417016E93A46124359574DEBCEDC3F21", hash_generated_method = "2AF2A65369AEC99736930A53E9B15CD0")
    @Override
    protected void onConfigurationChanged(Configuration newConfig) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(newConfig.getTaint());
super.onConfigurationChanged(newConfig)        if(LockPatternKeyguardView.DEBUG_CONFIGURATION)        
        {
        } //End block
        if(newConfig.orientation!=mCreationOrientation)        
        {
mCallback.recreateMe(newConfig)
        } //End block
        // ---------- Original Method ----------
        //super.onConfigurationChanged(newConfig);
        //if (LockPatternKeyguardView.DEBUG_CONFIGURATION) {
            //Log.v(TAG, "***** PATTERN CONFIGURATION CHANGED");
            //Log.v(TAG, "Cur orient=" + mCreationOrientation
                    //+ ", new config=" + getResources().getConfiguration());
        //}
        //if (newConfig.orientation != mCreationOrientation) {
            //mCallback.recreateMe(newConfig);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.142 -0400", hash_original_method = "E1543D3AF8A14BBD892E014F96AC979A", hash_generated_method = "5FE3FB98B5032C984108E7F5ED72DF3B")
    public void onKeyboardChange(boolean isKeyboardOpen) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(isKeyboardOpen);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.143 -0400", hash_original_method = "DF5F83115DF90D07C5FFC8E05F96ABEA", hash_generated_method = "76EE73F53E06189AF5F9AD188F09272E")
    public boolean needsInput() {
        boolean var68934A3E9455FA72420237EB05902327_444036601 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2138579980 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2138579980;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.143 -0400", hash_original_method = "158198E562FEAED9B4C6D325CD456325", hash_generated_method = "2AF82B76E510D4DA97AD90ED4E7E26C2")
    public void onPause() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        if(mCountdownTimer!=null)        
        {
mCountdownTimer.cancel()mCountdownTimer=null
        } //End block
mKeyguardStatusViewManager.onPause()
        // ---------- Original Method ----------
        //if (mCountdownTimer != null) {
            //mCountdownTimer.cancel();
            //mCountdownTimer = null;
        //}
        //mKeyguardStatusViewManager.onPause();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.144 -0400", hash_original_method = "12B0E9850BEF3C2B76AA7A9F1620D00C", hash_generated_method = "50DD5DA647116FB86E6CCDB9388A5D45")
    public void onResume() {
        //DSFIXME:  CODE0009: Possible callback target function detected
mKeyguardStatusViewManager.onResume()mLockPatternView.enableInput()mLockPatternView.setEnabled(true)mLockPatternView.clearPattern()        if(mCallback.doesFallbackUnlockScreenExist())        
        {
showForgotPatternButton()
        } //End block
        else
        {
hideForgotPatternButton()
        } //End block
        long deadline = mLockPatternUtils.getLockoutAttemptDeadline();
        if(deadline!=0)        
        {
handleAttemptLockout(deadline)
        } //End block
        if(mCallback.isVerifyUnlockOnly())        
        {
updateFooter(FooterMode.VerifyUnlocked)
        } //End block
        else
        if(mEnableFallback&&(mTotalFailedPatternAttempts>=LockPatternUtils.FAILED_ATTEMPTS_BEFORE_TIMEOUT))        
        {
updateFooter(FooterMode.ForgotLockPattern)
        } //End block
        else
        {
updateFooter(FooterMode.Normal)
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.145 -0400", hash_original_method = "43E1FE381346B1F4FDD553B93B0977FE", hash_generated_method = "B4FD3AE04B5A3C9A9A5F69B9C5B398D2")
    public void cleanUp() {
        if(DEBUG){ }mUpdateMonitor.removeCallback(this)mLockPatternUtils=nullmUpdateMonitor=nullmCallback=nullmLockPatternView.setOnPatternListener(null)
        // ---------- Original Method ----------
        //if (DEBUG) Log.v(TAG, "Cleanup() called on " + this);
        //mUpdateMonitor.removeCallback(this);
        //mLockPatternUtils = null;
        //mUpdateMonitor = null;
        //mCallback = null;
        //mLockPatternView.setOnPatternListener(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.146 -0400", hash_original_method = "4D4D7D9A7B5FA4AFFE1BAE4903058369", hash_generated_method = "E893BD26CEFECD317166B40F14E010C8")
    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(hasWindowFocus);
super.onWindowFocusChanged(hasWindowFocus)        if(hasWindowFocus)        
        {
onResume()
        } //End block
        // ---------- Original Method ----------
        //super.onWindowFocusChanged(hasWindowFocus);
        //if (hasWindowFocus) {
            //onResume();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.148 -0400", hash_original_method = "45C0687D67EB1FDCB0FCE3D4EFC6772E", hash_generated_method = "8FC74838CBEDF73A9446ABF9FEFFE630")
    private void handleAttemptLockout(long elapsedRealtimeDeadline) {
        addTaint(elapsedRealtimeDeadline);
mLockPatternView.clearPattern()mLockPatternView.setEnabled(false)        long elapsedRealtime = SystemClock.elapsedRealtime();
mCountdownTimer=new CountDownTimer(elapsedRealtimeDeadline-elapsedRealtime, 1000)        {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.147 -0400", hash_original_method = "931161BEAE696EDFBE7B256A4A227D1E", hash_generated_method = "2A04E0840268028BD2E5B051ABAA40A8")
        @Override
        public void onTick(long millisUntilFinished) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(millisUntilFinished);
            int secondsRemaining = (int) (millisUntilFinished / 1000);
mKeyguardStatusViewManager.setInstructionText(getContext().getString(R.string.lockscreen_too_many_failed_attempts_countdown, secondsRemaining))mKeyguardStatusViewManager.updateStatusLines(true)
            // ---------- Original Method ----------
            //int secondsRemaining = (int) (millisUntilFinished / 1000);
            //mKeyguardStatusViewManager.setInstructionText(getContext().getString(
                        //R.string.lockscreen_too_many_failed_attempts_countdown,
                        //secondsRemaining));
            //mKeyguardStatusViewManager.updateStatusLines(true);
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.148 -0400", hash_original_method = "93CF480A2ED5C66A5FB576AB86E794CC", hash_generated_method = "0E780BB939D6A737E85616FA5D7809BE")
        @Override
        public void onFinish() {
            //DSFIXME:  CODE0009: Possible callback target function detected
mLockPatternView.setEnabled(true)mKeyguardStatusViewManager.setInstructionText(getContext().getString(R.string.lockscreen_pattern_instructions))mKeyguardStatusViewManager.updateStatusLines(true)mFailedPatternAttemptsSinceLastTimeout=0            if(mEnableFallback)            
            {
updateFooter(FooterMode.ForgotLockPattern)
            } //End block
            else
            {
updateFooter(FooterMode.Normal)
            } //End block
            // ---------- Original Method ----------
            //mLockPatternView.setEnabled(true);
            //mKeyguardStatusViewManager.setInstructionText(getContext().getString(
                        //R.string.lockscreen_pattern_instructions));
            //mKeyguardStatusViewManager.updateStatusLines(true);
            //mFailedPatternAttemptsSinceLastTimeout = 0;
            //if (mEnableFallback) {
                    //updateFooter(FooterMode.ForgotLockPattern);
                //} else {
                    //updateFooter(FooterMode.Normal);
                //}
        }
        }
.start()
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    enum FooterMode {
        Normal,
        ForgotLockPattern,
        VerifyUnlocked
    }

    
    private class UnlockPatternListener implements LockPatternView.OnPatternListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.149 -0400", hash_original_method = "D492FB4ADBD9242B1A79387988F8E6AD", hash_generated_method = "D492FB4ADBD9242B1A79387988F8E6AD")
        public UnlockPatternListener ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.149 -0400", hash_original_method = "7A316A2DB7A101DC454EDF649BCC540E", hash_generated_method = "1EC38E0C1285B28F37D5BAC72054929A")
        public void onPatternStart() {
            //DSFIXME:  CODE0009: Possible callback target function detected
mLockPatternView.removeCallbacks(mCancelPatternRunnable)
            // ---------- Original Method ----------
            //mLockPatternView.removeCallbacks(mCancelPatternRunnable);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.150 -0400", hash_original_method = "D08F4CDE059756C1B4769F0149E20E0B", hash_generated_method = "097D47F43CA0856F37357B426CD07EC8")
        public void onPatternCleared() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.151 -0400", hash_original_method = "820B5338B82E1A4BCDE936D0F185375D", hash_generated_method = "BAAF3C3556B40BD063211A0F878B3084")
        public void onPatternCellAdded(List<Cell> pattern) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(pattern.getTaint());
            if(pattern.size()>MIN_PATTERN_BEFORE_POKE_WAKELOCK)            
            {
mCallback.pokeWakelock(UNLOCK_PATTERN_WAKE_INTERVAL_MS)
            } //End block
            else
            {
mCallback.pokeWakelock(UNLOCK_PATTERN_WAKE_INTERVAL_FIRST_DOTS_MS)
            } //End block
            // ---------- Original Method ----------
            //if (pattern.size() > MIN_PATTERN_BEFORE_POKE_WAKELOCK) {
                //mCallback.pokeWakelock(UNLOCK_PATTERN_WAKE_INTERVAL_MS);
            //} else {
                //mCallback.pokeWakelock(UNLOCK_PATTERN_WAKE_INTERVAL_FIRST_DOTS_MS);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.153 -0400", hash_original_method = "318C3341EB9FF2C1AA6A72222C88794A", hash_generated_method = "18F7193FD4C4F9F2B9F61B6ED6555459")
        public void onPatternDetected(List<LockPatternView.Cell> pattern) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(pattern.getTaint());
            if(mLockPatternUtils.checkPattern(pattern))            
            {
mLockPatternView.setDisplayMode(LockPatternView.DisplayMode.Correct)mKeyguardStatusViewManager.setInstructionText("")mKeyguardStatusViewManager.updateStatusLines(true)mCallback.keyguardDone(true)mCallback.reportSuccessfulUnlockAttempt()KeyStore.getInstance().password(LockPatternUtils.patternToString(pattern))
            } //End block
            else
            {
                boolean reportFailedAttempt = false;
                if(pattern.size()>MIN_PATTERN_BEFORE_POKE_WAKELOCK)                
                {
mCallback.pokeWakelock(UNLOCK_PATTERN_WAKE_INTERVAL_MS)
                } //End block
mLockPatternView.setDisplayMode(LockPatternView.DisplayMode.Wrong)                if(pattern.size()>=LockPatternUtils.MIN_PATTERN_REGISTER_FAIL)                
                {
mTotalFailedPatternAttemptsmFailedPatternAttemptsSinceLastTimeoutreportFailedAttempt=true
                } //End block
                if(mFailedPatternAttemptsSinceLastTimeout>=LockPatternUtils.FAILED_ATTEMPTS_BEFORE_TIMEOUT)                
                {
                    long deadline = mLockPatternUtils.setLockoutAttemptDeadline();
handleAttemptLockout(deadline)
                } //End block
                else
                {
mKeyguardStatusViewManager.setInstructionText(getContext().getString(R.string.lockscreen_pattern_wrong))mKeyguardStatusViewManager.updateStatusLines(true)mLockPatternView.postDelayed(mCancelPatternRunnable, PATTERN_CLEAR_TIMEOUT_MS)
                } //End block
                if(reportFailedAttempt)                
                {
mCallback.reportFailedUnlockAttempt()
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.154 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.154 -0400", hash_original_field = "09BC7355F3A213F3FE5790F6DA8D545E", hash_generated_field = "F5C6BB0E020456BF1F8A5B934ED38724")

    private static final String TAG = "UnlockScreen";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.154 -0400", hash_original_field = "46D6510F74BB97E468907A40D152E0B6", hash_generated_field = "929251D6494E679AE37F4A52B7242B88")

    private static final int PATTERN_CLEAR_TIMEOUT_MS = 2000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.154 -0400", hash_original_field = "A622E137EBF0961C74297795E0B7EBBA", hash_generated_field = "20F207B1685F337B274B96EB94F5F850")

    private static final int UNLOCK_PATTERN_WAKE_INTERVAL_MS = 7000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.155 -0400", hash_original_field = "7A845DD18C59502D25F87CDBE4D73B22", hash_generated_field = "C31CB243DFE9F0B2FABF9E80CB93FC30")

    private static final int UNLOCK_PATTERN_WAKE_INTERVAL_FIRST_DOTS_MS = 2000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.155 -0400", hash_original_field = "8864E6BB20F8CDAB28A29B44A8FE3C20", hash_generated_field = "5101B6D6A84A29104F183CB879DE6BA4")

    private static final int MIN_PATTERN_BEFORE_POKE_WAKELOCK = 2;
}

