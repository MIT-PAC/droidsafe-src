package com.android.internal.policy.impl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.widget;
import com.android.internal.R;
import android.media.AudioManager;
import android.util.Log;
import android.provider.Settings;
import android.app.ActivityManager;
import android.view.View;
import com.android.internal.widget.multiwaveview.MultiWaveView;
import com.android.internal.widget.LockPatternUtils;
import com.android.internal.widget.WaveView;
import android.content.Intent;
import android.content.Context;
import android.view.ViewGroup;
import android.view.KeyEvent;
import java.io.File;
import com.android.internal.widget.SlidingTab;
import android.provider.MediaStore;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
class LockScreen extends LinearLayout implements KeyguardScreen {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.798 -0400", hash_original_field = "EAA1758ACB8C3815224ED7417E5328B5", hash_generated_field = "FB69BB5EA99FF1AC6B151A37F4FEA26C")

    private LockPatternUtils mLockPatternUtils;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.799 -0400", hash_original_field = "E8A7E633D99E3BACB8ADFBBABB173D14", hash_generated_field = "22DCE3AFB482F86E6B2E96F873097CE0")

    private KeyguardUpdateMonitor mUpdateMonitor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.799 -0400", hash_original_field = "1804C5EC7AAE0B28B15CFDA061D25829", hash_generated_field = "56BFB4929FFB5B85E16CE5933F964A09")

    private KeyguardScreenCallback mCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.799 -0400", hash_original_field = "DBC9BD3F128308E3E39537030A1C88EF", hash_generated_field = "69947A686D730ED6BFB8241A3DBF0C42")

    private int mKeyboardHidden;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.800 -0400", hash_original_field = "8650EFA3EAFF9E8580ED2BAF39D373A4", hash_generated_field = "D4F52B2DF2B3F133070FDB68D5444936")

    private int mCreationOrientation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.800 -0400", hash_original_field = "0322DDFF4C28D89874C85ED7CB058E85", hash_generated_field = "BFDD04F76094D94E25479FE90FC4AC74")

    private boolean mSilentMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.800 -0400", hash_original_field = "DC563AE6C758BE979A84432D84FFAC40", hash_generated_field = "B52B11818937F27E927A20CDEBA27654")

    private AudioManager mAudioManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.800 -0400", hash_original_field = "128B139233862435658CCE5E26A48595", hash_generated_field = "AAA687CD102115AFDB201F6883B6D3FC")

    private boolean mEnableMenuKeyInLockScreen;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.800 -0400", hash_original_field = "8A1A7BF80985C1BAE77D52C5BE41E88F", hash_generated_field = "70CA6DA7CBDF33F352C6E3B7572B9A7F")

    private KeyguardStatusViewManager mStatusViewManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.801 -0400", hash_original_field = "2D592A5FCABFDDE39E9E3B3DA056B4F7", hash_generated_field = "113248FA586A6B96495B5879A4733557")

    private UnlockWidgetCommonMethods mUnlockWidgetMethods;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.801 -0400", hash_original_field = "55D06569CBD3C45F5FED2B31172BE4CE", hash_generated_field = "D615F539BAD71D50D684EB7D49DC58E3")

    private View mUnlockWidget;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.808 -0400", hash_original_field = "137DDA49EA7F41E4D8320C33B502F97B", hash_generated_field = "8AFCE622E5ACD2BAC890ACA65583C962")

    private final Runnable mOnResumePing = new Runnable()    {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.806 -0400", hash_original_method = "CB414BE89D53D1B0DB745A62E457D82E", hash_generated_method = "673DDEA51A30F4C362F498D8B3703C63")
        public void run() {
mUnlockWidgetMethods.ping()
            // ---------- Original Method ----------
            //mUnlockWidgetMethods.ping();
        }

        
    }
;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.814 -0400", hash_original_method = "4BC5FD66783BFAD217A07E867132CFAC", hash_generated_method = "ED684981E24AB26C6D23200365B2DD75")
      LockScreen(Context context, Configuration configuration, LockPatternUtils lockPatternUtils,
            KeyguardUpdateMonitor updateMonitor,
            KeyguardScreenCallback callback) {
        super(context);
        addTaint(callback.getTaint());
        addTaint(updateMonitor.getTaint());
        addTaint(lockPatternUtils.getTaint());
        addTaint(configuration.getTaint());
        addTaint(context.getTaint());
mLockPatternUtils=lockPatternUtilsmUpdateMonitor=updateMonitormCallback=callbackmEnableMenuKeyInLockScreen=shouldEnableMenuKey()mCreationOrientation=configuration.orientationmKeyboardHidden=configuration.hardKeyboardHidden        if(LockPatternKeyguardView.DEBUG_CONFIGURATION)        
        {
        } //End block
        final LayoutInflater inflater = LayoutInflater.from(context);
        if(DBG){ }        if(mCreationOrientation!=Configuration.ORIENTATION_LANDSCAPE)        
        {
inflater.inflate(R.layout.keyguard_screen_tab_unlock, this, true)
        } //End block
        else
        {
inflater.inflate(R.layout.keyguard_screen_tab_unlock_land, this, true)
        } //End block
mStatusViewManager=new KeyguardStatusViewManager(this, mUpdateMonitor, mLockPatternUtils, mCallback, false)setFocusable(true)setFocusableInTouchMode(true)setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS)mAudioManager=(AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE)mSilentMode=isSilentMode()mUnlockWidget=findViewById(R.id.unlock_widget)        if(mUnlockWidget instanceof SlidingTab)        
        {
            SlidingTab slidingTabView = (SlidingTab) mUnlockWidget;
slidingTabView.setHoldAfterTrigger(true, false)slidingTabView.setLeftHintText(R.string.lockscreen_unlock_label)slidingTabView.setLeftTabResources(R.drawable.ic_jog_dial_unlock, R.drawable.jog_tab_target_green, R.drawable.jog_tab_bar_left_unlock, R.drawable.jog_tab_left_unlock)            SlidingTabMethods slidingTabMethods = new SlidingTabMethods(slidingTabView);
slidingTabView.setOnTriggerListener(slidingTabMethods)mUnlockWidgetMethods=slidingTabMethods
        } //End block
        else
        if(mUnlockWidget instanceof WaveView)        
        {
            WaveView waveView = (WaveView) mUnlockWidget;
            WaveViewMethods waveViewMethods = new WaveViewMethods(waveView);
waveView.setOnTriggerListener(waveViewMethods)mUnlockWidgetMethods=waveViewMethods
        } //End block
        else
        if(mUnlockWidget instanceof MultiWaveView)        
        {
            MultiWaveView multiWaveView = (MultiWaveView) mUnlockWidget;
            MultiWaveViewMethods multiWaveViewMethods = new MultiWaveViewMethods(multiWaveView);
multiWaveView.setOnTriggerListener(multiWaveViewMethods)mUnlockWidgetMethods=multiWaveViewMethods
        } //End block
        else
        {
            IllegalStateException varC2814123D2C50A0CED39FD0EE1BA2E1F_1346849883 = new IllegalStateException("Unrecognized unlock widget: " + mUnlockWidget);
            varC2814123D2C50A0CED39FD0EE1BA2E1F_1346849883.addTaint(taint);
            throw varC2814123D2C50A0CED39FD0EE1BA2E1F_1346849883;
        } //End block
mUnlockWidgetMethods.updateResources()        if(DBG){ }
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.847 -0400", hash_original_method = "B040990DE4E026C51958B053F6926B37", hash_generated_method = "9C6092F527D51386E2F72CC8D0CDB4A1")
    private void requestUnlockScreen() {
postDelayed(new Runnable()        {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.844 -0400", hash_original_method = "B6984071836D78057DD8BE9D560EF328", hash_generated_method = "7BC06983BAAAA35BC7EE03AB357802B0")
        public void run() {
mCallback.goToUnlockScreen()
            // ---------- Original Method ----------
            //mCallback.goToUnlockScreen();
        }
        }
, WAIT_FOR_ANIMATION_TIMEOUT)
        // ---------- Original Method ----------
        //postDelayed(new Runnable() {
            //public void run() {
                //mCallback.goToUnlockScreen();
            //}
        //}, WAIT_FOR_ANIMATION_TIMEOUT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.858 -0400", hash_original_method = "88484444B48FC659CE36E7B4AB6AD865", hash_generated_method = "EE9BB2D918E589499ED1F32C1B843A5D")
    private void toggleRingMode() {
mSilentMode=!mSilentMode        if(mSilentMode)        
        {
            final boolean vibe = (Settings.System.getInt(
                mContext.getContentResolver(),
                Settings.System.VIBRATE_IN_SILENT, 1) == 1);
mAudioManager.setRingerMode(vibe?AudioManager.RINGER_MODE_VIBRATE:AudioManager.RINGER_MODE_VIBRATE)
        } //End block
        else
        {
mAudioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL)
        } //End block
        // ---------- Original Method ----------
        //mSilentMode = !mSilentMode;
        //if (mSilentMode) {
            //final boolean vibe = (Settings.System.getInt(
                //mContext.getContentResolver(),
                //Settings.System.VIBRATE_IN_SILENT, 1) == 1);
            //mAudioManager.setRingerMode(vibe
                //? AudioManager.RINGER_MODE_VIBRATE
                //: AudioManager.RINGER_MODE_SILENT);
        //} else {
            //mAudioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.869 -0400", hash_original_method = "0744D3349EDA901296F877685BBC3A20", hash_generated_method = "8B27EF3A9E2F5EBBA71DCCDCE391836D")
    private boolean shouldEnableMenuKey() {
        final Resources res = getResources();
        final boolean configDisabled = res.getBoolean(R.bool.config_disableMenuKeyInLockScreen);
        final boolean isTestHarness = ActivityManager.isRunningInTestHarness();
        final boolean fileOverride = (new File(ENABLE_MENU_KEY_FILE)).exists();
        boolean var9F13BCE518E20ED220F5CD4C6712C5B4_880915111 = (!configDisabled||isTestHarness||fileOverride);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1008501420 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1008501420;
        // ---------- Original Method ----------
        //final Resources res = getResources();
        //final boolean configDisabled = res.getBoolean(R.bool.config_disableMenuKeyInLockScreen);
        //final boolean isTestHarness = ActivityManager.isRunningInTestHarness();
        //final boolean fileOverride = (new File(ENABLE_MENU_KEY_FILE)).exists();
        //return !configDisabled || isTestHarness || fileOverride;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.879 -0400", hash_original_method = "5A1FEF4E98839B3467567E33476F7045", hash_generated_method = "4D705334E343C4F3D7754FEA861EBDB3")
    private boolean isSilentMode() {
        boolean varB7E154B630C44421A4308056AB973078_831515478 = (mAudioManager.getRingerMode()!=AudioManager.RINGER_MODE_NORMAL);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_679326645 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_679326645;
        // ---------- Original Method ----------
        //return mAudioManager.getRingerMode() != AudioManager.RINGER_MODE_NORMAL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.890 -0400", hash_original_method = "F343F372DA00DA98DB06E81E1100899F", hash_generated_method = "A5E369257AA08F26E822633CF4D4E85B")
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
        if(keyCode==KeyEvent.KEYCODE_MENU&&mEnableMenuKeyInLockScreen)        
        {
mCallback.goToUnlockScreen()
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1088772586 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1383460392 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1383460392;
        // ---------- Original Method ----------
        //if (keyCode == KeyEvent.KEYCODE_MENU && mEnableMenuKeyInLockScreen) {
            //mCallback.goToUnlockScreen();
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.904 -0400", hash_original_method = "41FD104E5C88C6B282E84F54A5E345DD", hash_generated_method = "8FFA7AEB4CFD6FF4761C77BFE69E66B3")
     void updateConfiguration() {
        Configuration newConfig = getResources().getConfiguration();
        if(newConfig.orientation!=mCreationOrientation)        
        {
mCallback.recreateMe(newConfig)
        } //End block
        else
        if(newConfig.hardKeyboardHidden!=mKeyboardHidden)        
        {
mKeyboardHidden=newConfig.hardKeyboardHidden            final boolean isKeyboardOpen = mKeyboardHidden == Configuration.HARDKEYBOARDHIDDEN_NO;
            if(mUpdateMonitor.isKeyguardBypassEnabled()&&isKeyboardOpen)            
            {
mCallback.goToUnlockScreen()
            } //End block
        } //End block
        // ---------- Original Method ----------
        //Configuration newConfig = getResources().getConfiguration();
        //if (newConfig.orientation != mCreationOrientation) {
            //mCallback.recreateMe(newConfig);
        //} else if (newConfig.hardKeyboardHidden != mKeyboardHidden) {
            //mKeyboardHidden = newConfig.hardKeyboardHidden;
            //final boolean isKeyboardOpen = mKeyboardHidden == Configuration.HARDKEYBOARDHIDDEN_NO;
            //if (mUpdateMonitor.isKeyguardBypassEnabled() && isKeyboardOpen) {
                //mCallback.goToUnlockScreen();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.917 -0400", hash_original_method = "3258DC4719163D39F92F02F5CA58297E", hash_generated_method = "8C62817E9153DB0A7D540C86DD022455")
    @Override
    protected void onAttachedToWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
super.onAttachedToWindow()        if(LockPatternKeyguardView.DEBUG_CONFIGURATION)        
        {
        } //End block
updateConfiguration()
        // ---------- Original Method ----------
        //super.onAttachedToWindow();
        //if (LockPatternKeyguardView.DEBUG_CONFIGURATION) {
            //Log.v(TAG, "***** LOCK ATTACHED TO WINDOW");
            //Log.v(TAG, "Cur orient=" + mCreationOrientation
                    //+ ", new config=" + getResources().getConfiguration());
        //}
        //updateConfiguration();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.927 -0400", hash_original_method = "7EFB4DFE5C13AA96C553907E0F9801EC", hash_generated_method = "FAB11B66DA8EF015D196F7E75D59F1C3")
    @Override
    protected void onConfigurationChanged(Configuration newConfig) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(newConfig.getTaint());
super.onConfigurationChanged(newConfig)        if(LockPatternKeyguardView.DEBUG_CONFIGURATION)        
        {
        } //End block
updateConfiguration()
        // ---------- Original Method ----------
        //super.onConfigurationChanged(newConfig);
        //if (LockPatternKeyguardView.DEBUG_CONFIGURATION) {
            //Log.w(TAG, "***** LOCK CONFIG CHANGING", new RuntimeException());
            //Log.v(TAG, "Cur orient=" + mCreationOrientation
                    //+ ", new config=" + newConfig);
        //}
        //updateConfiguration();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.937 -0400", hash_original_method = "DF5F83115DF90D07C5FFC8E05F96ABEA", hash_generated_method = "4DD11AA54C251A369F0547915C9E24BD")
    public boolean needsInput() {
        boolean var68934A3E9455FA72420237EB05902327_1647477929 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_839023661 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_839023661;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.946 -0400", hash_original_method = "75C0FEE41B50170200F078A250D962BD", hash_generated_method = "12D4BBCEBA3D78AB6598177263719F47")
    public void onPause() {
        //DSFIXME:  CODE0009: Possible callback target function detected
mStatusViewManager.onPause()mUnlockWidgetMethods.reset(false)
        // ---------- Original Method ----------
        //mStatusViewManager.onPause();
        //mUnlockWidgetMethods.reset(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.952 -0400", hash_original_method = "E989E9074DA791BAED5C41C58B8F0513", hash_generated_method = "CB680A620A621C8D3F5A6FF4298B68A3")
    public void onResume() {
        //DSFIXME:  CODE0009: Possible callback target function detected
mStatusViewManager.onResume()postDelayed(mOnResumePing, ON_RESUME_PING_DELAY)
        // ---------- Original Method ----------
        //mStatusViewManager.onResume();
        //postDelayed(mOnResumePing, ON_RESUME_PING_DELAY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.958 -0400", hash_original_method = "A4909A8542CC51BD570CD8C285CE987B", hash_generated_method = "0DA19217795C5F817D3901BF301223E7")
    public void cleanUp() {
mUpdateMonitor.removeCallback(this)mLockPatternUtils=nullmUpdateMonitor=nullmCallback=null
        // ---------- Original Method ----------
        //mUpdateMonitor.removeCallback(this);
        //mLockPatternUtils = null;
        //mUpdateMonitor = null;
        //mCallback = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.964 -0400", hash_original_method = "CF0E6B9C590130B30AA9E24369BD518F", hash_generated_method = "C07ED0183422C3937B5543125E2A7E6A")
    public void onRingerModeChanged(int state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(state);
        boolean silent = AudioManager.RINGER_MODE_NORMAL != state;
        if(silent!=mSilentMode)        
        {
mSilentMode=silentmUnlockWidgetMethods.updateResources()
        } //End block
        // ---------- Original Method ----------
        //boolean silent = AudioManager.RINGER_MODE_NORMAL != state;
        //if (silent != mSilentMode) {
            //mSilentMode = silent;
            //mUnlockWidgetMethods.updateResources();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.972 -0400", hash_original_method = "41721AAACBCF6ADA152844FE2A2BF394", hash_generated_method = "55332CE5679D2F3171B3C40F4899B8EF")
    public void onPhoneStateChanged(String newState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(newState.getTaint());
        // ---------- Original Method ----------
    }

    
    class SlidingTabMethods implements SlidingTab.OnTriggerListener, UnlockWidgetCommonMethods {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.978 -0400", hash_original_field = "487A2BE27910DA5791BEDD657457915D", hash_generated_field = "CD7C597AC919EDED025C1787DF6056ED")

        private SlidingTab mSlidingTab;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.980 -0400", hash_original_method = "95B96D132BF3B0D161473413363D4D08", hash_generated_method = "579FEE14798CEEE0A3B2672F68FCE8FE")
          SlidingTabMethods(SlidingTab slidingTab) {
            addTaint(slidingTab.getTaint());
mSlidingTab=slidingTab
            // ---------- Original Method ----------
            //mSlidingTab = slidingTab;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.981 -0400", hash_original_method = "151E721C513805EC89A4D303277F3D58", hash_generated_method = "4E5386C651838FCCCA58C3C8959F3580")
        public void updateResources() {
            boolean vibe = mSilentMode
                && (mAudioManager.getRingerMode() == AudioManager.RINGER_MODE_VIBRATE);
mSlidingTab.setRightTabResources(mSilentMode?(vibe?R.drawable.ic_jog_dial_vibrate_on:R.drawable.ic_jog_dial_vibrate_on):(vibe?R.drawable.ic_jog_dial_vibrate_on:R.drawable.ic_jog_dial_vibrate_on), mSilentMode?R.drawable.jog_tab_target_yellow:R.drawable.jog_tab_target_yellow, mSilentMode?R.drawable.jog_tab_bar_right_sound_on:R.drawable.jog_tab_bar_right_sound_on, mSilentMode?R.drawable.jog_tab_right_sound_on:R.drawable.jog_tab_right_sound_on)
            // ---------- Original Method ----------
            //boolean vibe = mSilentMode
                //&& (mAudioManager.getRingerMode() == AudioManager.RINGER_MODE_VIBRATE);
            //mSlidingTab.setRightTabResources(
                    //mSilentMode ? ( vibe ? R.drawable.ic_jog_dial_vibrate_on
                                         //: R.drawable.ic_jog_dial_sound_off )
                                //: R.drawable.ic_jog_dial_sound_on,
                    //mSilentMode ? R.drawable.jog_tab_target_yellow
                                //: R.drawable.jog_tab_target_gray,
                    //mSilentMode ? R.drawable.jog_tab_bar_right_sound_on
                                //: R.drawable.jog_tab_bar_right_sound_off,
                    //mSilentMode ? R.drawable.jog_tab_right_sound_on
                                //: R.drawable.jog_tab_right_sound_off);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.982 -0400", hash_original_method = "6F111EEF05E087CDCB559A197A455012", hash_generated_method = "0E8978970637016C6E40C78C34556120")
        public void onTrigger(View v, int whichHandle) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(whichHandle);
            addTaint(v.getTaint());
            if(whichHandle==SlidingTab.OnTriggerListener.LEFT_HANDLE)            
            {
mCallback.goToUnlockScreen()
            } //End block
            else
            if(whichHandle==SlidingTab.OnTriggerListener.RIGHT_HANDLE)            
            {
toggleRingMode()mCallback.pokeWakelock()
            } //End block
            // ---------- Original Method ----------
            //if (whichHandle == SlidingTab.OnTriggerListener.LEFT_HANDLE) {
                //mCallback.goToUnlockScreen();
            //} else if (whichHandle == SlidingTab.OnTriggerListener.RIGHT_HANDLE) {
                //toggleRingMode();
                //mCallback.pokeWakelock();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.983 -0400", hash_original_method = "986D6B0A47DFAFDBC161EB1AF99FBFC8", hash_generated_method = "548704D40A4A05920561591961CB6D23")
        public void onGrabbedStateChange(View v, int grabbedState) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(grabbedState);
            addTaint(v.getTaint());
            if(grabbedState==SlidingTab.OnTriggerListener.RIGHT_HANDLE)            
            {
mSilentMode=isSilentMode()mSlidingTab.setRightHintText(mSilentMode?R.string.lockscreen_sound_on_label:R.string.lockscreen_sound_on_label)
            } //End block
            if(grabbedState!=SlidingTab.OnTriggerListener.NO_HANDLE)            
            {
mCallback.pokeWakelock()
            } //End block
            // ---------- Original Method ----------
            //if (grabbedState == SlidingTab.OnTriggerListener.RIGHT_HANDLE) {
                //mSilentMode = isSilentMode();
                //mSlidingTab.setRightHintText(mSilentMode ? R.string.lockscreen_sound_on_label
                        //: R.string.lockscreen_sound_off_label);
            //}
            //if (grabbedState != SlidingTab.OnTriggerListener.NO_HANDLE) {
                //mCallback.pokeWakelock();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.983 -0400", hash_original_method = "4CDB39CD4D8B4E64D3208DD7A9D6E3FB", hash_generated_method = "82DF6AEA142BC25D4B130BDC4180AD79")
        public View getView() {
View var0B773890D3B89D64C7293331EBD6E7B4_1186659597 = mSlidingTab            var0B773890D3B89D64C7293331EBD6E7B4_1186659597.addTaint(taint);
            return var0B773890D3B89D64C7293331EBD6E7B4_1186659597;
            // ---------- Original Method ----------
            //return mSlidingTab;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.984 -0400", hash_original_method = "63CDFFE4D3C84217B036190E88895293", hash_generated_method = "776D61CAF325DF430A88137CD1F00B5A")
        public void reset(boolean animate) {
            addTaint(animate);
mSlidingTab.reset(animate)
            // ---------- Original Method ----------
            //mSlidingTab.reset(animate);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.984 -0400", hash_original_method = "725BF3DEAD6ECD586A3B1B92FAE3AAE7", hash_generated_method = "94D35BC3785739700807CD339762532C")
        public void ping() {
            // ---------- Original Method ----------
        }

        
    }


    
    class WaveViewMethods implements WaveView.OnTriggerListener, UnlockWidgetCommonMethods {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.984 -0400", hash_original_field = "2635589419FD1EEC9F79042959F02507", hash_generated_field = "0E5294C30A5CB6564BC3B53D2182BAFF")

        private WaveView mWaveView;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.985 -0400", hash_original_method = "C545B5D3F97D4554568C41C9C462D09E", hash_generated_method = "4A4C083849BF76F03FAAD8255AA31BBB")
          WaveViewMethods(WaveView waveView) {
            addTaint(waveView.getTaint());
mWaveView=waveView
            // ---------- Original Method ----------
            //mWaveView = waveView;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.985 -0400", hash_original_method = "373EAE24A8294E7920C55CD37A1D8C59", hash_generated_method = "D5328C65F655FFD796C3A480666907FC")
        public void onTrigger(View v, int whichHandle) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(whichHandle);
            addTaint(v.getTaint());
            if(whichHandle==WaveView.OnTriggerListener.CENTER_HANDLE)            
            {
requestUnlockScreen()
            } //End block
            // ---------- Original Method ----------
            //if (whichHandle == WaveView.OnTriggerListener.CENTER_HANDLE) {
                //requestUnlockScreen();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.987 -0400", hash_original_method = "E3336F8750DCB30564481F48506F1D39", hash_generated_method = "956AE762E93F13347209FB248876017F")
        public void onGrabbedStateChange(View v, int grabbedState) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(grabbedState);
            addTaint(v.getTaint());
            if(grabbedState==WaveView.OnTriggerListener.CENTER_HANDLE)            
            {
mCallback.pokeWakelock(STAY_ON_WHILE_GRABBED_TIMEOUT)
            } //End block
            // ---------- Original Method ----------
            //if (grabbedState == WaveView.OnTriggerListener.CENTER_HANDLE) {
                //mCallback.pokeWakelock(STAY_ON_WHILE_GRABBED_TIMEOUT);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.987 -0400", hash_original_method = "0E9770158D7AE39B2A56F4B31D2E33D9", hash_generated_method = "81119DAD9EB14155D3D2E3E2F5559EED")
        public void updateResources() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.988 -0400", hash_original_method = "465128FC045E856DBEBFAA82341107D5", hash_generated_method = "6EC10F9F2D7BF269C9B7B4FF9C4DA61C")
        public View getView() {
View varD592C2925309E6C4DD8FDB829448CAE9_2048533947 = mWaveView            varD592C2925309E6C4DD8FDB829448CAE9_2048533947.addTaint(taint);
            return varD592C2925309E6C4DD8FDB829448CAE9_2048533947;
            // ---------- Original Method ----------
            //return mWaveView;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.989 -0400", hash_original_method = "AE8F265749EF792C66D09F34B261CACC", hash_generated_method = "7D45CF7697049D96027DC9FEECE47A6D")
        public void reset(boolean animate) {
            addTaint(animate);
mWaveView.reset()
            // ---------- Original Method ----------
            //mWaveView.reset();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.990 -0400", hash_original_method = "725BF3DEAD6ECD586A3B1B92FAE3AAE7", hash_generated_method = "94D35BC3785739700807CD339762532C")
        public void ping() {
            // ---------- Original Method ----------
        }

        
    }


    
    class MultiWaveViewMethods implements MultiWaveView.OnTriggerListener, UnlockWidgetCommonMethods {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.990 -0400", hash_original_field = "E470DDA7863D0668FB9E3E153260D03C", hash_generated_field = "CC28A4216399A7267771FC5AED6187DD")

        private MultiWaveView mMultiWaveView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.991 -0400", hash_original_field = "B38F37B6E029CFFB060CE6442E445076", hash_generated_field = "55DB8998C56C6C15FC5CD1F6E1D4A86F")

        private boolean mCameraDisabled;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.992 -0400", hash_original_method = "ED07A01E1FE43DD6F324680D44720B0E", hash_generated_method = "F3E5D8C2F150243CE4A87560B74EA3E8")
          MultiWaveViewMethods(MultiWaveView multiWaveView) {
            addTaint(multiWaveView.getTaint());
mMultiWaveView=multiWaveView            final boolean cameraDisabled = mLockPatternUtils.getDevicePolicyManager()
                    .getCameraDisabled(null);
            if(cameraDisabled)            
            {
mCameraDisabled=true
            } //End block
            else
            {
mCameraDisabled=mMultiWaveView.getTargetResourceId()!=R.array.lockscreen_targets_with_camera
            } //End block
            // ---------- Original Method ----------
            //mMultiWaveView = multiWaveView;
            //final boolean cameraDisabled = mLockPatternUtils.getDevicePolicyManager()
                    //.getCameraDisabled(null);
            //if (cameraDisabled) {
                //Log.v(TAG, "Camera disabled by Device Policy");
                //mCameraDisabled = true;
            //} else {
                //mCameraDisabled = mMultiWaveView.getTargetResourceId()
                        //!= R.array.lockscreen_targets_with_camera;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.993 -0400", hash_original_method = "F6571CB1425DC9DBE6591E83B76F3ACA", hash_generated_method = "B0C4B8929FD93398F03534F4CC4FFE1C")
        public void updateResources() {
            int resId;
            if(mCameraDisabled)            
            {
resId=mSilentMode?R.array.lockscreen_targets_when_silent:R.array.lockscreen_targets_when_silent
            } //End block
            else
            {
resId=R.array.lockscreen_targets_with_camera
            } //End block
mMultiWaveView.setTargetResources(resId)
            // ---------- Original Method ----------
            //int resId;
            //if (mCameraDisabled) {
                //resId = mSilentMode ? R.array.lockscreen_targets_when_silent
                    //: R.array.lockscreen_targets_when_soundon;
            //} else {
                //resId = R.array.lockscreen_targets_with_camera;
            //}
            //mMultiWaveView.setTargetResources(resId);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.994 -0400", hash_original_method = "8778F14BE51434F882B892B2905F7639", hash_generated_method = "DFC510583C44EC3FBD39F1B95A03CB52")
        public void onGrabbed(View v, int handle) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(handle);
            addTaint(v.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.995 -0400", hash_original_method = "3F44917E40736A695B2B5D9C620E62B3", hash_generated_method = "E44AB1768B7F188EAECDD7669150A46E")
        public void onReleased(View v, int handle) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(handle);
            addTaint(v.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.997 -0400", hash_original_method = "5259729E07C6BB1A09BEE06F9DF9CAE2", hash_generated_method = "1E57AA81BA0D755DA34702422739D2BD")
        public void onTrigger(View v, int target) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(target);
            addTaint(v.getTaint());
            if(target==0||target==1)            
            {
mCallback.goToUnlockScreen()
            } //End block
            else
            if(target==2||target==3)            
            {
                if(!mCameraDisabled)                
                {
                    Intent intent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)mContext.startActivity(intent)mCallback.goToUnlockScreen()
                } //End block
                else
                {
toggleRingMode()mUnlockWidgetMethods.updateResources()mCallback.pokeWakelock()
                } //End block
            } //End block
            // ---------- Original Method ----------
            //if (target == 0 || target == 1) { 
                //mCallback.goToUnlockScreen();
            //} else if (target == 2 || target == 3) { 
                //if (!mCameraDisabled) {
                    //Intent intent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
                    //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    //mContext.startActivity(intent);
                    //mCallback.goToUnlockScreen();
                //} else {
                    //toggleRingMode();
                    //mUnlockWidgetMethods.updateResources();
                    //mCallback.pokeWakelock();
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.999 -0400", hash_original_method = "636FA46C5DC424D50547ED0ACAE16A28", hash_generated_method = "9CBF2801EFD57066E6E583569B88C732")
        public void onGrabbedStateChange(View v, int handle) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(handle);
            addTaint(v.getTaint());
            if(handle!=MultiWaveView.OnTriggerListener.NO_HANDLE)            
            {
mCallback.pokeWakelock()
            } //End block
            // ---------- Original Method ----------
            //if (handle != MultiWaveView.OnTriggerListener.NO_HANDLE) {
                //mCallback.pokeWakelock();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.000 -0400", hash_original_method = "97E6D75D8D08656BF13F123C18C3BE76", hash_generated_method = "AED1307304DB33829D00917E7C26C757")
        public View getView() {
View varCD2BD19935BB69D4762EC2E72255B4A4_104150728 = mMultiWaveView            varCD2BD19935BB69D4762EC2E72255B4A4_104150728.addTaint(taint);
            return varCD2BD19935BB69D4762EC2E72255B4A4_104150728;
            // ---------- Original Method ----------
            //return mMultiWaveView;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.001 -0400", hash_original_method = "B618B6886919A3AF21486F3D4BDE92D7", hash_generated_method = "6B5718CCC9C3EBC747E7DE4FA2AC4FEB")
        public void reset(boolean animate) {
            addTaint(animate);
mMultiWaveView.reset(animate)
            // ---------- Original Method ----------
            //mMultiWaveView.reset(animate);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.001 -0400", hash_original_method = "62AE8AEDD5672DA0CB3C326958F34960", hash_generated_method = "CD205BC73341903CAB0086CD7E2C5646")
        public void ping() {
mMultiWaveView.ping()
            // ---------- Original Method ----------
            //mMultiWaveView.ping();
        }

        
    }


    
    private interface UnlockWidgetCommonMethods {
        
        public void updateResources();

        
        public View getView();

        
        public void reset(boolean animate);

        
        public void ping();
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.002 -0400", hash_original_field = "8D44B816E4C43657C84A0221807947F9", hash_generated_field = "876246A7A91157A614426A2FCE4C007C")

    private static final int ON_RESUME_PING_DELAY = 500;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.003 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.003 -0400", hash_original_field = "95E9FA17E99206E045DB16944FBC4064", hash_generated_field = "58B7711AC7DA9B23F84A7BA362B750B9")

    private static final String TAG = "LockScreen";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.003 -0400", hash_original_field = "44A53755A1AF8E894F9186C79926532B", hash_generated_field = "3DA846A479886BBEC88AD58E1D8FD5D2")

    private static final String ENABLE_MENU_KEY_FILE = "/data/local/enable_menu_key";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.004 -0400", hash_original_field = "7A5F54C0C50CB9B5FE1BF81EF29ACC0A", hash_generated_field = "6C6A0599F18233D0FB10E54391F052E8")

    private static final int WAIT_FOR_ANIMATION_TIMEOUT = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.004 -0400", hash_original_field = "ACD6A6ED1FEAA2365DAB8DCE9CD63A1D", hash_generated_field = "43C709575DF9B09E951B2A6B11E140E1")

    private static final int STAY_ON_WHILE_GRABBED_TIMEOUT = 30000;
}

