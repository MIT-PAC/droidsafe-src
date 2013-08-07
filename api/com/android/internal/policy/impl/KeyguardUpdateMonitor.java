package com.android.internal.policy.impl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import com.android.internal.R;
import com.android.internal.telephony.TelephonyIntents;
import android.util.Log;
import android.os.BatteryManager.BATTERY_HEALTH_UNKNOWN;
import android.media.AudioManager;
import com.android.internal.telephony.IccCard;
import android.os.Message;
import android.provider.Telephony.Intents.SPN_STRINGS_UPDATED_ACTION;
import android.os.BatteryManager.EXTRA_LEVEL;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.provider.Telephony.Intents.EXTRA_SHOW_PLMN;
import android.telephony.TelephonyManager;
import android.database.ContentObserver;
import android.os.Handler;
import com.google.android.collect.Lists;
import java.util.ArrayList;
import android.provider.Telephony.Intents.EXTRA_PLMN;
import android.os.BatteryManager.EXTRA_STATUS;
import android.os.BatteryManager.BATTERY_STATUS_FULL;
import android.os.BatteryManager;
import android.provider.Settings;
import android.provider.Telephony.Intents.EXTRA_SHOW_SPN;
import android.provider.Telephony;
import android.os.BatteryManager.BATTERY_STATUS_UNKNOWN;
import android.os.BatteryManager.EXTRA_PLUGGED;
import android.content.IntentFilter;
import android.os.BatteryManager.EXTRA_HEALTH;
import android.content.Context;
import android.provider.Telephony.Intents.EXTRA_SPN;
public class KeyguardUpdateMonitor {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.216 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.216 -0400", hash_original_field = "4422E45D4225F697937BA7D66EC364AB", hash_generated_field = "B98476F3B1E4A638F36E1CB34957245A")

    private IccCard.State mSimState = IccCard.State.READY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.217 -0400", hash_original_field = "2B297AC04470BE6DA7AC24E9E8DEF7A9", hash_generated_field = "C454A06B7FA195A1ADF4671F4BDB7D24")

    private boolean mKeyguardBypassEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.217 -0400", hash_original_field = "B4F3C212912D9B2BE592C46544AEA650", hash_generated_field = "FA1E87221DD3189EEA913792173CBE7A")

    private boolean mDeviceProvisioned;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.217 -0400", hash_original_field = "D6A27DBE817CFF9EC63C02C9F962A4E6", hash_generated_field = "309189131482704C54490D340652867B")

    private BatteryStatus mBatteryStatus;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.218 -0400", hash_original_field = "81CE4D77BBC67640051115070357E8BF", hash_generated_field = "B42290CEC1489F20E01751CD576C4767")

    private CharSequence mTelephonyPlmn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.218 -0400", hash_original_field = "C9EB6991D9B80DA374BD521E42DA4B28", hash_generated_field = "2F81F7625D08CE7B4D57B9E593B175D4")

    private CharSequence mTelephonySpn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.218 -0400", hash_original_field = "33706EA484BAFF9E4CCFE775367AFB02", hash_generated_field = "71F32BE219887A8D1D2DFD69803E8F5E")

    private int mFailedAttempts = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.218 -0400", hash_original_field = "592C96D6D3D0D1F84AFFF058E1AFE74E", hash_generated_field = "A1A0B506458BA8678A50E3973F948DA2")

    private boolean mClockVisible;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.219 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

    private Handler mHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.219 -0400", hash_original_field = "4C82DB91CECC9BCB63B341AF2B957593", hash_generated_field = "B3A0667A205F97D7403E02C8C4A366E6")

    private ArrayList<InfoCallback> mInfoCallbacks = Lists.newArrayList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.219 -0400", hash_original_field = "8AAD4C9DD38943A4684ABE32FD6AA6EA", hash_generated_field = "22ED51C794A496AA92472EBE637C06C2")

    private ArrayList<SimStateCallback> mSimStateCallbacks = Lists.newArrayList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.220 -0400", hash_original_field = "C267D355D6BA0921A3D8E50CDCC2651C", hash_generated_field = "EF5C1593EA063EC8C771F8FAE6B6BCB6")

    private ContentObserver mContentObserver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.220 -0400", hash_original_field = "E39AD35402F7BD374ACE42C14A9CE20A", hash_generated_field = "9DB21CA352B093E689E368C8DB05935A")

    private int mRingMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.220 -0400", hash_original_field = "7AC0737DCEF621593084D09C0D6B7D3F", hash_generated_field = "06F7D7A8CD2D0F460ABB567572234DEF")

    private int mPhoneState;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.229 -0400", hash_original_method = "2BD20B0F89C5BADD80ED2B74B079CFF4", hash_generated_method = "0C52CFE90645B204773BF7AA4F6CDD4D")
    public  KeyguardUpdateMonitor(Context context) {
        addTaint(context.getTaint());
mContext=contextmHandler=new Handler()        {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.222 -0400", hash_original_method = "6747A1219880A0489B60111DB8CBA7CA", hash_generated_method = "A77862C3728662CBE706987C8FF3AC39")
        @Override
        public void handleMessage(Message msg) {
            addTaint(msg.getTaint());
            switch(msg.what){
            case MSG_TIME_UPDATE:
handleTimeUpdate()            break;
            case MSG_BATTERY_UPDATE:
handleBatteryUpdate((BatteryStatus) msg.obj)            break;
            case MSG_CARRIER_INFO_UPDATE:
handleCarrierInfoUpdate()            break;
            case MSG_SIM_STATE_CHANGE:
handleSimStateChange((SimArgs) msg.obj)            break;
            case MSG_RINGER_MODE_CHANGED:
handleRingerModeChange(msg.arg1)            break;
            case MSG_PHONE_STATE_CHANGED:
handlePhoneStateChanged((String) msg.obj)            break;
            case MSG_CLOCK_VISIBILITY_CHANGED:
handleClockVisibilityChanged()            break;
            case MSG_DEVICE_PROVISIONED:
handleDeviceProvisioned()            break;
}
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }
        }
mKeyguardBypassEnabled=context.getResources().getBoolean(com.android.internal.R.bool.config_bypass_keyguard_if_slider_open)mDeviceProvisioned=Settings.Secure.getInt(mContext.getContentResolver(), Settings.Secure.DEVICE_PROVISIONED, 0)!=0        if(!mDeviceProvisioned)        
        {
mContentObserver=new ContentObserver(mHandler)            {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.223 -0400", hash_original_method = "5211FDD809C0EEEB716A93FBBC8C2FC1", hash_generated_method = "1F26B6F9E50102C25D0F2E05670C7032")
        @Override
        public void onChange(boolean selfChange) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(selfChange);
super.onChange(selfChange)mDeviceProvisioned=Settings.Secure.getInt(mContext.getContentResolver(), Settings.Secure.DEVICE_PROVISIONED, 0)!=0            if(mDeviceProvisioned)            
            {
mHandler.sendMessage(mHandler.obtainMessage(MSG_DEVICE_PROVISIONED))
            } //End block
            if(DEBUG)            
Log.d(TAG, "DEVICE_PROVISIONED state = "+mDeviceProvisioned)
            // ---------- Original Method ----------
            //super.onChange(selfChange);
            //mDeviceProvisioned = Settings.Secure.getInt(mContext.getContentResolver(),
                        //Settings.Secure.DEVICE_PROVISIONED, 0) != 0;
            //if (mDeviceProvisioned) {
                        //mHandler.sendMessage(mHandler.obtainMessage(MSG_DEVICE_PROVISIONED));
                    //}
            //if (DEBUG) Log.d(TAG, "DEVICE_PROVISIONED state = " + mDeviceProvisioned);
        }
            }
mContext.getContentResolver().registerContentObserver(Settings.Secure.getUriFor(Settings.Secure.DEVICE_PROVISIONED), false, mContentObserver)            boolean provisioned = Settings.Secure.getInt(mContext.getContentResolver(),
                Settings.Secure.DEVICE_PROVISIONED, 0) != 0;
            if(provisioned!=mDeviceProvisioned)            
            {
mDeviceProvisioned=provisioned                if(mDeviceProvisioned)                
                {
mHandler.sendMessage(mHandler.obtainMessage(MSG_DEVICE_PROVISIONED))
                } //End block
            } //End block
        } //End block
mSimState=IccCard.State.READYmBatteryStatus=new BatteryStatus(BATTERY_STATUS_UNKNOWN, 100, 0, 0)mTelephonyPlmn=getDefaultPlmn()        final IntentFilter filter = new IntentFilter();
filter.addAction(Intent.ACTION_TIME_TICK)filter.addAction(Intent.ACTION_TIME_CHANGED)filter.addAction(Intent.ACTION_BATTERY_CHANGED)filter.addAction(Intent.ACTION_TIMEZONE_CHANGED)filter.addAction(TelephonyIntents.ACTION_SIM_STATE_CHANGED)filter.addAction(TelephonyManager.ACTION_PHONE_STATE_CHANGED)filter.addAction(SPN_STRINGS_UPDATED_ACTION)filter.addAction(AudioManager.RINGER_MODE_CHANGED_ACTION)context.registerReceiver(new BroadcastReceiver()        {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.227 -0400", hash_original_method = "D8C40666F922DD426C6229CC1C755D50", hash_generated_method = "6A06C3D14013B767EC2177C21F4D884D")
        public void onReceive(Context context, Intent intent) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(intent.getTaint());
            addTaint(context.getTaint());
            final String action = intent.getAction();
            if(DEBUG)            
Log.d(TAG, "received broadcast "+action)
            if(Intent.ACTION_TIME_TICK.equals(action)||Intent.ACTION_TIME_CHANGED.equals(action)||Intent.ACTION_TIMEZONE_CHANGED.equals(action))            
            {
mHandler.sendMessage(mHandler.obtainMessage(MSG_TIME_UPDATE))
            } //End block
            else
            if(SPN_STRINGS_UPDATED_ACTION.equals(action))            
            {
mTelephonyPlmn=getTelephonyPlmnFrom(intent)mTelephonySpn=getTelephonySpnFrom(intent)mHandler.sendMessage(mHandler.obtainMessage(MSG_CARRIER_INFO_UPDATE))
            } //End block
            else
            if(Intent.ACTION_BATTERY_CHANGED.equals(action))            
            {
                final int status = intent.getIntExtra(EXTRA_STATUS, BATTERY_STATUS_UNKNOWN);
                final int plugged = intent.getIntExtra(EXTRA_PLUGGED, 0);
                final int level = intent.getIntExtra(EXTRA_LEVEL, 0);
                final int health = intent.getIntExtra(EXTRA_HEALTH, BATTERY_HEALTH_UNKNOWN);
                final Message msg = mHandler.obtainMessage(
                            MSG_BATTERY_UPDATE, new BatteryStatus(status, level, plugged, health));
mHandler.sendMessage(msg)
            } //End block
            else
            if(TelephonyIntents.ACTION_SIM_STATE_CHANGED.equals(action))            
            {
mHandler.sendMessage(mHandler.obtainMessage(MSG_SIM_STATE_CHANGE, SimArgs.fromIntent(intent)))
            } //End block
            else
            if(AudioManager.RINGER_MODE_CHANGED_ACTION.equals(action))            
            {
mHandler.sendMessage(mHandler.obtainMessage(MSG_RINGER_MODE_CHANGED, intent.getIntExtra(AudioManager.EXTRA_RINGER_MODE, -1), 0))
            } //End block
            else
            if(TelephonyManager.ACTION_PHONE_STATE_CHANGED.equals(action))            
            {
                String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
mHandler.sendMessage(mHandler.obtainMessage(MSG_PHONE_STATE_CHANGED, state))
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }
        }
, filter)
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.231 -0400", hash_original_method = "7737C254956BFD799804F65B0E8D6438", hash_generated_method = "B16ABF069D807AE5F7B6A87D5C18B816")
    protected void handleDeviceProvisioned() {
for(int i = 0;i<mInfoCallbacks.size();i)
        {
mInfoCallbacks.get(i).onDeviceProvisioned()
        } //End block
        if(mContentObserver!=null)        
        {
mContext.getContentResolver().unregisterContentObserver(mContentObserver)mContentObserver=null
        } //End block
        // ---------- Original Method ----------
        //for (int i = 0; i < mInfoCallbacks.size(); i++) {
            //mInfoCallbacks.get(i).onDeviceProvisioned();
        //}
        //if (mContentObserver != null) {
            //mContext.getContentResolver().unregisterContentObserver(mContentObserver);
            //mContentObserver = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.232 -0400", hash_original_method = "62C551CF0D2308965FDBC8B6FD0EE038", hash_generated_method = "443D93DB6FB1AE5312C87545D9901909")
    protected void handlePhoneStateChanged(String newState) {
        addTaint(newState.getTaint());
        if(DEBUG)        
Log.d(TAG, "handlePhoneStateChanged("+newState+")")
        if(TelephonyManager.EXTRA_STATE_IDLE.equals(newState))        
        {
mPhoneState=TelephonyManager.CALL_STATE_IDLE
        } //End block
        else
        if(TelephonyManager.EXTRA_STATE_OFFHOOK.equals(newState))        
        {
mPhoneState=TelephonyManager.CALL_STATE_OFFHOOK
        } //End block
        else
        if(TelephonyManager.EXTRA_STATE_RINGING.equals(newState))        
        {
mPhoneState=TelephonyManager.CALL_STATE_RINGING
        } //End block
for(int i = 0;i<mInfoCallbacks.size();i)
        {
mInfoCallbacks.get(i).onPhoneStateChanged(mPhoneState)
        } //End block
        // ---------- Original Method ----------
        //if (DEBUG) Log.d(TAG, "handlePhoneStateChanged(" + newState + ")");
        //if (TelephonyManager.EXTRA_STATE_IDLE.equals(newState)) {
            //mPhoneState = TelephonyManager.CALL_STATE_IDLE;
        //} else if (TelephonyManager.EXTRA_STATE_OFFHOOK.equals(newState)) {
            //mPhoneState = TelephonyManager.CALL_STATE_OFFHOOK;
        //} else if (TelephonyManager.EXTRA_STATE_RINGING.equals(newState)) {
            //mPhoneState = TelephonyManager.CALL_STATE_RINGING;
        //}
        //for (int i = 0; i < mInfoCallbacks.size(); i++) {
            //mInfoCallbacks.get(i).onPhoneStateChanged(mPhoneState);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.234 -0400", hash_original_method = "05DF96F94E5DEFF1CFED33A5E644B342", hash_generated_method = "B759C405D4CB3DA18D543FA315680736")
    protected void handleRingerModeChange(int mode) {
        addTaint(mode);
        if(DEBUG)        
Log.d(TAG, "handleRingerModeChange("+mode+")")
mRingMode=modefor(int i = 0;i<mInfoCallbacks.size();i)
        {
mInfoCallbacks.get(i).onRingerModeChanged(mode)
        } //End block
        // ---------- Original Method ----------
        //if (DEBUG) Log.d(TAG, "handleRingerModeChange(" + mode + ")");
        //mRingMode = mode;
        //for (int i = 0; i < mInfoCallbacks.size(); i++) {
            //mInfoCallbacks.get(i).onRingerModeChanged(mode);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.235 -0400", hash_original_method = "3DCFC404C08AC82F10E4210FFEB8F2D5", hash_generated_method = "6AB33D3FDA0372F62BCFF970CF2E3525")
    private void handleTimeUpdate() {
        if(DEBUG)        
Log.d(TAG, "handleTimeUpdate")
for(int i = 0;i<mInfoCallbacks.size();i)
        {
mInfoCallbacks.get(i).onTimeChanged()
        } //End block
        // ---------- Original Method ----------
        //if (DEBUG) Log.d(TAG, "handleTimeUpdate");
        //for (int i = 0; i < mInfoCallbacks.size(); i++) {
            //mInfoCallbacks.get(i).onTimeChanged();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.236 -0400", hash_original_method = "95FB0AD123F45EBAD2DE32CA2024B96A", hash_generated_method = "501F61A98E35FB1747A069DB407C3896")
    private void handleBatteryUpdate(BatteryStatus batteryStatus) {
        addTaint(batteryStatus.getTaint());
        if(DEBUG)        
Log.d(TAG, "handleBatteryUpdate")
        final boolean batteryUpdateInteresting = isBatteryUpdateInteresting(mBatteryStatus, batteryStatus);
mBatteryStatus=batteryStatus        if(batteryUpdateInteresting)        
        {
for(int i = 0;i<mInfoCallbacks.size();i)
            {
mInfoCallbacks.get(i).onRefreshBatteryInfo(shouldShowBatteryInfo(), isPluggedIn(batteryStatus), batteryStatus.level)
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (DEBUG) Log.d(TAG, "handleBatteryUpdate");
        //final boolean batteryUpdateInteresting =
                //isBatteryUpdateInteresting(mBatteryStatus, batteryStatus);
        //mBatteryStatus = batteryStatus;
        //if (batteryUpdateInteresting) {
            //for (int i = 0; i < mInfoCallbacks.size(); i++) {
                //mInfoCallbacks.get(i).onRefreshBatteryInfo(
                    //shouldShowBatteryInfo(),isPluggedIn(batteryStatus), batteryStatus.level);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.237 -0400", hash_original_method = "153DB40D2BADEBB54D0CC63F4657FC13", hash_generated_method = "53EC070C1CC7DCC9F8F3C39EB3039350")
    private void handleCarrierInfoUpdate() {
        if(DEBUG)        
Log.d(TAG, "handleCarrierInfoUpdate: plmn = "+mTelephonyPlmn+", spn = "+mTelephonySpn)
for(int i = 0;i<mInfoCallbacks.size();i)
        {
mInfoCallbacks.get(i).onRefreshCarrierInfo(mTelephonyPlmn, mTelephonySpn)
        } //End block
        // ---------- Original Method ----------
        //if (DEBUG) Log.d(TAG, "handleCarrierInfoUpdate: plmn = " + mTelephonyPlmn
            //+ ", spn = " + mTelephonySpn);
        //for (int i = 0; i < mInfoCallbacks.size(); i++) {
            //mInfoCallbacks.get(i).onRefreshCarrierInfo(mTelephonyPlmn, mTelephonySpn);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.239 -0400", hash_original_method = "2DCDB602F62A7CB305E5C8FDA0C51620", hash_generated_method = "D29152A71C7604EFA5183512357A92FB")
    private void handleSimStateChange(SimArgs simArgs) {
        addTaint(simArgs.getTaint());
        final IccCard.State state = simArgs.simState;
        if(DEBUG)        
        {
Log.d(TAG, "handleSimStateChange: intentValue = "+simArgs+" "+"state resolved to "+state.toString())
        } //End block
        if(state!=IccCard.State.UNKNOWN&&state!=mSimState)        
        {
mSimState=statefor(int i = 0;i<mSimStateCallbacks.size();i)
            {
mSimStateCallbacks.get(i).onSimStateChanged(state)
            } //End block
        } //End block
        // ---------- Original Method ----------
        //final IccCard.State state = simArgs.simState;
        //if (DEBUG) {
            //Log.d(TAG, "handleSimStateChange: intentValue = " + simArgs + " "
                    //+ "state resolved to " + state.toString());
        //}
        //if (state != IccCard.State.UNKNOWN && state != mSimState) {
            //mSimState = state;
            //for (int i = 0; i < mSimStateCallbacks.size(); i++) {
                //mSimStateCallbacks.get(i).onSimStateChanged(state);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.240 -0400", hash_original_method = "301137316ABEE813E5AF171A910A9D42", hash_generated_method = "25DA62607ADA71E73986F9146003CAA8")
    private void handleClockVisibilityChanged() {
        if(DEBUG)        
Log.d(TAG, "handleClockVisibilityChanged()")
for(int i = 0;i<mInfoCallbacks.size();i)
        {
mInfoCallbacks.get(i).onClockVisibilityChanged()
        } //End block
        // ---------- Original Method ----------
        //if (DEBUG) Log.d(TAG, "handleClockVisibilityChanged()");
        //for (int i = 0; i < mInfoCallbacks.size(); i++) {
            //mInfoCallbacks.get(i).onClockVisibilityChanged();
        //}
    }

    
        private static boolean isPluggedIn(BatteryStatus status) {
        return status.plugged == BatteryManager.BATTERY_PLUGGED_AC
                || status.plugged == BatteryManager.BATTERY_PLUGGED_USB;
    }

    
        private static boolean isBatteryUpdateInteresting(BatteryStatus old, BatteryStatus current) {
        final boolean nowPluggedIn = isPluggedIn(current);
        final boolean wasPluggedIn = isPluggedIn(old);
        final boolean stateChangedWhilePluggedIn =
            wasPluggedIn == true && nowPluggedIn == true
            && (old.status != current.status);
        if (wasPluggedIn != nowPluggedIn || stateChangedWhilePluggedIn) {
            return true;
        }
        if (nowPluggedIn && old.level != current.level) {
            return true;
        }
        if (!nowPluggedIn && isBatteryLow(current) && current.level != old.level) {
            return true;
        }
        return false;
    }

    
        private static boolean isBatteryLow(BatteryStatus status) {
        return status.level < LOW_BATTERY_THRESHOLD;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.242 -0400", hash_original_method = "A53CDDDEFA065899FD70BAA393E3A9B7", hash_generated_method = "885E89957994EB02A4D74ADF3BF247A8")
    private CharSequence getTelephonyPlmnFrom(Intent intent) {
        addTaint(intent.getTaint());
        if(intent.getBooleanExtra(EXTRA_SHOW_PLMN, false))        
        {
            final String plmn = intent.getStringExtra(EXTRA_PLMN);
            if(plmn!=null)            
            {
CharSequence var52C4B7303C6FA40CDD1CADF819AAE392_899091249 = plmn                var52C4B7303C6FA40CDD1CADF819AAE392_899091249.addTaint(taint);
                return var52C4B7303C6FA40CDD1CADF819AAE392_899091249;
            } //End block
            else
            {
CharSequence var2252534768A8953CD6F259AFD9F8E2E5_329274548 = getDefaultPlmn()                var2252534768A8953CD6F259AFD9F8E2E5_329274548.addTaint(taint);
                return var2252534768A8953CD6F259AFD9F8E2E5_329274548;
            } //End block
        } //End block
CharSequence var540C13E9E156B687226421B24F2DF178_1507248923 = null        var540C13E9E156B687226421B24F2DF178_1507248923.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1507248923;
        // ---------- Original Method ----------
        //if (intent.getBooleanExtra(EXTRA_SHOW_PLMN, false)) {
            //final String plmn = intent.getStringExtra(EXTRA_PLMN);
            //if (plmn != null) {
                //return plmn;
            //} else {
                //return getDefaultPlmn();
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.245 -0400", hash_original_method = "C005216B496C511FE5D4E21B5255C2A6", hash_generated_method = "CC810D225E0BAF78FA3C80A4C0BC42FF")
    private CharSequence getDefaultPlmn() {
CharSequence var71F6241A302FF6DD12B864857344F6C5_1024340189 = mContext.getResources().getText(R.string.lockscreen_carrier_default)        var71F6241A302FF6DD12B864857344F6C5_1024340189.addTaint(taint);
        return var71F6241A302FF6DD12B864857344F6C5_1024340189;
        // ---------- Original Method ----------
        //return mContext.getResources().getText(
                        //R.string.lockscreen_carrier_default);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.246 -0400", hash_original_method = "239B859F6F27B52D666F66CEA7134947", hash_generated_method = "E7F39E29FCCE5ABFB2F42522BE94711C")
    private CharSequence getTelephonySpnFrom(Intent intent) {
        addTaint(intent.getTaint());
        if(intent.getBooleanExtra(EXTRA_SHOW_SPN, false))        
        {
            final String spn = intent.getStringExtra(EXTRA_SPN);
            if(spn!=null)            
            {
CharSequence var45568158EF0C540A1756B7B70BA9D156_1786942692 = spn                var45568158EF0C540A1756B7B70BA9D156_1786942692.addTaint(taint);
                return var45568158EF0C540A1756B7B70BA9D156_1786942692;
            } //End block
        } //End block
CharSequence var540C13E9E156B687226421B24F2DF178_399105985 = null        var540C13E9E156B687226421B24F2DF178_399105985.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_399105985;
        // ---------- Original Method ----------
        //if (intent.getBooleanExtra(EXTRA_SHOW_SPN, false)) {
            //final String spn = intent.getStringExtra(EXTRA_SPN);
            //if (spn != null) {
                //return spn;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.247 -0400", hash_original_method = "D555B5C3830A676737FFDBAEA41CF554", hash_generated_method = "365C278FAE024842DD4DE792C197E8C6")
    public void removeCallback(Object observer) {
        addTaint(observer.getTaint());
mInfoCallbacks.remove(observer)mSimStateCallbacks.remove(observer)
        // ---------- Original Method ----------
        //mInfoCallbacks.remove(observer);
        //mSimStateCallbacks.remove(observer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.248 -0400", hash_original_method = "0451EB6CAFBBAD1EEBC900EDEA88657D", hash_generated_method = "39054A98A40F1AC28AC045FDB024C903")
    public void registerInfoCallback(InfoCallback callback) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(callback.getTaint());
        if(!mInfoCallbacks.contains(callback))        
        {
mInfoCallbacks.add(callback)callback.onRefreshBatteryInfo(shouldShowBatteryInfo(), isPluggedIn(mBatteryStatus), mBatteryStatus.level)callback.onTimeChanged()callback.onRingerModeChanged(mRingMode)callback.onPhoneStateChanged(mPhoneState)callback.onRefreshCarrierInfo(mTelephonyPlmn, mTelephonySpn)callback.onClockVisibilityChanged()
        } //End block
        else
        {
            if(DEBUG){ }
        } //End block
        // ---------- Original Method ----------
        //if (!mInfoCallbacks.contains(callback)) {
            //mInfoCallbacks.add(callback);
            //callback.onRefreshBatteryInfo(shouldShowBatteryInfo(),isPluggedIn(mBatteryStatus),
                    //mBatteryStatus.level);
            //callback.onTimeChanged();
            //callback.onRingerModeChanged(mRingMode);
            //callback.onPhoneStateChanged(mPhoneState);
            //callback.onRefreshCarrierInfo(mTelephonyPlmn, mTelephonySpn);
            //callback.onClockVisibilityChanged();
        //} else {
            //if (DEBUG) Log.e(TAG, "Object tried to add another INFO callback",
                    //new Exception("Whoops"));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.249 -0400", hash_original_method = "B5D9FBB26DD0A0D031245BC190AB8A2B", hash_generated_method = "AECFA8B6789F3D612E06FD6B3311C55C")
    public void registerSimStateCallback(SimStateCallback callback) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(callback.getTaint());
        if(!mSimStateCallbacks.contains(callback))        
        {
mSimStateCallbacks.add(callback)callback.onSimStateChanged(mSimState)
        } //End block
        else
        {
            if(DEBUG){ }
        } //End block
        // ---------- Original Method ----------
        //if (!mSimStateCallbacks.contains(callback)) {
            //mSimStateCallbacks.add(callback);
            //callback.onSimStateChanged(mSimState);
        //} else {
            //if (DEBUG) Log.e(TAG, "Object tried to add another SIM callback",
                    //new Exception("Whoops"));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.250 -0400", hash_original_method = "F7FFEF0BB120A0CCBCC51CEB6F4F019D", hash_generated_method = "10019E1ABE4E7FF5CB2A33346D062FE0")
    public void reportClockVisible(boolean visible) {
        addTaint(visible);
mClockVisible=visiblemHandler.obtainMessage(MSG_CLOCK_VISIBILITY_CHANGED).sendToTarget()
        // ---------- Original Method ----------
        //mClockVisible = visible;
        //mHandler.obtainMessage(MSG_CLOCK_VISIBILITY_CHANGED).sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.251 -0400", hash_original_method = "609E8082CA42E2C67AFA326886192258", hash_generated_method = "A6155AE46E7EDC6013531C49508F100E")
    public IccCard.State getSimState() {
IccCard.State varD1D6E3D81133E46F67B78341F3AF951B_361349501 = mSimState        varD1D6E3D81133E46F67B78341F3AF951B_361349501.addTaint(taint);
        return varD1D6E3D81133E46F67B78341F3AF951B_361349501;
        // ---------- Original Method ----------
        //return mSimState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.252 -0400", hash_original_method = "EDB3EC8A0580D1749FE0D433E0FFAB91", hash_generated_method = "5D5AE113401F7080EA7F838FD72FD7E8")
    public void reportSimUnlocked() {
handleSimStateChange(new SimArgs(IccCard.State.READY))
        // ---------- Original Method ----------
        //handleSimStateChange(new SimArgs(IccCard.State.READY));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.253 -0400", hash_original_method = "387E371914BF94315BC840068A405913", hash_generated_method = "2FE43B456AB7229D1D4B7C6B66AD4528")
    public boolean isKeyguardBypassEnabled() {
        boolean var2B297AC04470BE6DA7AC24E9E8DEF7A9_20929694 = (mKeyguardBypassEnabled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_982662518 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_982662518;
        // ---------- Original Method ----------
        //return mKeyguardBypassEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.253 -0400", hash_original_method = "07D6C865DCEC4CD9DF275902F3552CE6", hash_generated_method = "BEEDECCF6B6A6759E46A3B24482FAC26")
    public boolean isDevicePluggedIn() {
        boolean var817A728FBCDB41762D03D6A2988EAB7E_1258522999 = (isPluggedIn(mBatteryStatus));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_666526608 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_666526608;
        // ---------- Original Method ----------
        //return isPluggedIn(mBatteryStatus);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.254 -0400", hash_original_method = "2D53C7DBDCA8EF70D95C1A5697432AC6", hash_generated_method = "BF7DC3EDC1CEE253A51476B9E0203FC0")
    public boolean isDeviceCharged() {
        boolean var39B95D3B87816120F6A5A57C0CD2840C_592595625 = (mBatteryStatus.status==BATTERY_STATUS_FULL||mBatteryStatus.level>=100);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1795599425 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1795599425;
        // ---------- Original Method ----------
        //return mBatteryStatus.status == BATTERY_STATUS_FULL
                //|| mBatteryStatus.level >= 100;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.255 -0400", hash_original_method = "76836B4D2D58D3CA43307EA83731AB74", hash_generated_method = "B0F3A7C78BAACDE5515578C2428E5EAB")
    public int getBatteryLevel() {
        int var5D7B41FB267819240A96EBDC7531DD8C_1312983779 = (mBatteryStatus.level);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1282447130 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1282447130;
        // ---------- Original Method ----------
        //return mBatteryStatus.level;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.256 -0400", hash_original_method = "7CAD5099056635A95095AA6A9B836213", hash_generated_method = "73F7B5FF994862DFB0003D758C3EC49D")
    public boolean shouldShowBatteryInfo() {
        boolean var9B9B2C7228881FF7521EBBA933202B16_62726651 = (isPluggedIn(mBatteryStatus)||isBatteryLow(mBatteryStatus));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1435225003 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1435225003;
        // ---------- Original Method ----------
        //return isPluggedIn(mBatteryStatus) || isBatteryLow(mBatteryStatus);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.257 -0400", hash_original_method = "788306596A6E66A3F48DCC5C7D772063", hash_generated_method = "6AC564125B6326035ABD0CB29E01EA45")
    public CharSequence getTelephonyPlmn() {
CharSequence var1EBE69DA8FAF5E9FC9041FBA1CA1EC01_1394122920 = mTelephonyPlmn        var1EBE69DA8FAF5E9FC9041FBA1CA1EC01_1394122920.addTaint(taint);
        return var1EBE69DA8FAF5E9FC9041FBA1CA1EC01_1394122920;
        // ---------- Original Method ----------
        //return mTelephonyPlmn;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.258 -0400", hash_original_method = "09420DA8BA9B4EAF421F744FF114B2B7", hash_generated_method = "B6CD3005D4EF84027D909138D28BBD48")
    public CharSequence getTelephonySpn() {
CharSequence var915AACE378E443C3499F82B20C8183A4_2056261424 = mTelephonySpn        var915AACE378E443C3499F82B20C8183A4_2056261424.addTaint(taint);
        return var915AACE378E443C3499F82B20C8183A4_2056261424;
        // ---------- Original Method ----------
        //return mTelephonySpn;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.259 -0400", hash_original_method = "ED95517A8080FBB0EAF4FFF9DB81F6A3", hash_generated_method = "F2828784CA469B3E8DB2A7D07C831701")
    public boolean isDeviceProvisioned() {
        boolean varB4F3C212912D9B2BE592C46544AEA650_152416505 = (mDeviceProvisioned);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_187271164 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_187271164;
        // ---------- Original Method ----------
        //return mDeviceProvisioned;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.260 -0400", hash_original_method = "79AAB6DF2BE77A10C87545AFDFDB5CE6", hash_generated_method = "525EE104914D7A07619525F77B86BE48")
    public int getFailedAttempts() {
        int var5A9585685765E5CC5131BA0693ABC36A_438262179 = (mFailedAttempts);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_605856650 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_605856650;
        // ---------- Original Method ----------
        //return mFailedAttempts;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.261 -0400", hash_original_method = "6F372F930AF5EF4F6ABAFE1E5E2C4AE3", hash_generated_method = "1D3E164F1D78557286808283F3211E2C")
    public void clearFailedAttempts() {
mFailedAttempts=0
        // ---------- Original Method ----------
        //mFailedAttempts = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.261 -0400", hash_original_method = "7CDA6C86C03DA7AA14E49139BF0C6236", hash_generated_method = "2EFB1060B62D89C89BC41EC16CEEF635")
    public void reportFailedAttempt() {
mFailedAttempts
        // ---------- Original Method ----------
        //mFailedAttempts++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.262 -0400", hash_original_method = "DCDADDBC587CB04551224EE6741E32AE", hash_generated_method = "029A623477AC5C23186CBAAC824E1001")
    public boolean isClockVisible() {
        boolean var592C96D6D3D0D1F84AFFF058E1AFE74E_915201794 = (mClockVisible);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_370897871 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_370897871;
        // ---------- Original Method ----------
        //return mClockVisible;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.263 -0400", hash_original_method = "A0B694F7214611E61FA99C37251706FE", hash_generated_method = "2CBF9DADE0C8F7864E2B28C4AE35A91E")
    public int getPhoneState() {
        int var7AC0737DCEF621593084D09C0D6B7D3F_1335958816 = (mPhoneState);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1595871810 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1595871810;
        // ---------- Original Method ----------
        //return mPhoneState;
    }

    
    private static class SimArgs {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.264 -0400", hash_original_field = "D28C7EFDE6A17567754E7F558FC1EB16", hash_generated_field = "8711D6ECD7C5794C23F4869A25C26247")

        public IccCard.State simState;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.264 -0400", hash_original_method = "36712DF8CA7AFBE2B7BCAE9022E35814", hash_generated_method = "7A077105EA9DCFAA9F7CDE4B26B53C09")
          SimArgs(IccCard.State state) {
            addTaint(state.getTaint());
simState=state
            // ---------- Original Method ----------
            //simState = state;
        }

        
                static SimArgs fromIntent(Intent intent) {
            IccCard.State state;
            if (!TelephonyIntents.ACTION_SIM_STATE_CHANGED.equals(intent.getAction())) {
                throw new IllegalArgumentException("only handles intent ACTION_SIM_STATE_CHANGED");
            }
            String stateExtra = intent.getStringExtra(IccCard.INTENT_KEY_ICC_STATE);
            if (IccCard.INTENT_VALUE_ICC_ABSENT.equals(stateExtra)) {
                final String absentReason = intent
                    .getStringExtra(IccCard.INTENT_KEY_LOCKED_REASON);
                if (IccCard.INTENT_VALUE_ABSENT_ON_PERM_DISABLED.equals(
                        absentReason)) {
                    state = IccCard.State.PERM_DISABLED;
                } else {
                    state = IccCard.State.ABSENT;
                }
            } else if (IccCard.INTENT_VALUE_ICC_READY.equals(stateExtra)) {
                state = IccCard.State.READY;
            } else if (IccCard.INTENT_VALUE_ICC_LOCKED.equals(stateExtra)) {
                final String lockedReason = intent
                        .getStringExtra(IccCard.INTENT_KEY_LOCKED_REASON);
                if (IccCard.INTENT_VALUE_LOCKED_ON_PIN.equals(lockedReason)) {
                    state = IccCard.State.PIN_REQUIRED;
                } else if (IccCard.INTENT_VALUE_LOCKED_ON_PUK.equals(lockedReason)) {
                    state = IccCard.State.PUK_REQUIRED;
                } else {
                    state = IccCard.State.UNKNOWN;
                }
            } else if (IccCard.INTENT_VALUE_LOCKED_NETWORK.equals(stateExtra)) {
                state = IccCard.State.NETWORK_LOCKED;
            } else {
                state = IccCard.State.UNKNOWN;
            }
            return new SimArgs(state);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.265 -0400", hash_original_method = "3B3B9DC0A55159AF1F7D5FEF0F5CA2AA", hash_generated_method = "ECEEB75E144E237D5A5BA35B93CD2584")
        public String toString() {
String var36DA583CA003BE1399D755D55B1936F8_83426968 = simState.toString()            var36DA583CA003BE1399D755D55B1936F8_83426968.addTaint(taint);
            return var36DA583CA003BE1399D755D55B1936F8_83426968;
            // ---------- Original Method ----------
            //return simState.toString();
        }

        
    }


    
    private static class BatteryStatus {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.265 -0400", hash_original_field = "9ACB44549B41563697BB490144EC6258", hash_generated_field = "E9243AA6ACDC688110619DDCF59ACF0B")

        public int status;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.266 -0400", hash_original_field = "C9E9A848920877E76685B2E4E76DE38D", hash_generated_field = "D6582AE921E596E1A991761518312A0E")

        public int level;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.266 -0400", hash_original_field = "105E814EA56C024B39A265695A61244D", hash_generated_field = "B94796D192249B55493F4966B0F55079")

        public int plugged;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.266 -0400", hash_original_field = "555BF8344CA0CAF09B42F55E185526D8", hash_generated_field = "2E41432AAA8364DF88EF38AED861B364")

        public int health;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.267 -0400", hash_original_method = "BC61215314D9A1F174A4DBC889284388", hash_generated_method = "0B566E6F72DE95D91FE26AA238ED7670")
        public  BatteryStatus(int status, int level, int plugged, int health) {
            addTaint(health);
            addTaint(plugged);
            addTaint(level);
            addTaint(status);
this.status=statusthis.level=levelthis.plugged=pluggedthis.health=health
            // ---------- Original Method ----------
            //this.status = status;
            //this.level = level;
            //this.plugged = plugged;
            //this.health = health;
        }

        
    }


    
    interface InfoCallback {
        void onRefreshBatteryInfo(boolean showBatteryInfo, boolean pluggedIn, int batteryLevel);
        void onTimeChanged();

        
        void onRefreshCarrierInfo(CharSequence plmn, CharSequence spn);

        
        void onRingerModeChanged(int state);

        
        void onPhoneStateChanged(int phoneState);

        
        void onClockVisibilityChanged();

        
        void onDeviceProvisioned();
    }
    
    interface SimStateCallback {
        void onSimStateChanged(IccCard.State simState);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.267 -0400", hash_original_field = "D02258F40F6985BC29DA6D43148B165B", hash_generated_field = "583BA387D6290ECFA303207E2012E435")

    static private final String TAG = "KeyguardUpdateMonitor";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.267 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "AC679AD647C8EB62DD459B8B7830EF02")

    static private final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.267 -0400", hash_original_field = "28276700ABDF0B53650FF64401C7270A", hash_generated_field = "17BC6300B530DF6EF46507334FDBF71F")

    static final int LOW_BATTERY_THRESHOLD = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.267 -0400", hash_original_field = "5E66AB1D29A2D38E987ADD461B58CB53", hash_generated_field = "6F2FE286245F4C2E2CF73009AAEE5E56")

    private static final int MSG_TIME_UPDATE = 301;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.268 -0400", hash_original_field = "6622C4180554AEC72969D9BF5771CB82", hash_generated_field = "2746058C15B2C60AB54F105B11B00B68")

    private static final int MSG_BATTERY_UPDATE = 302;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.268 -0400", hash_original_field = "72FF2BF706EBDEBE9AAC92F4927D0708", hash_generated_field = "E157BA1E36813BA8386BC56DA3014989")

    private static final int MSG_CARRIER_INFO_UPDATE = 303;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.268 -0400", hash_original_field = "91F209DBB98768BFF9A45DC8F2CB48A5", hash_generated_field = "0E62083BC0576B1A99E723436900767E")

    private static final int MSG_SIM_STATE_CHANGE = 304;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.268 -0400", hash_original_field = "9AE99417CB2EFB6C1210135E5CA23B75", hash_generated_field = "6961137957474CA417489516D72D2B5E")

    private static final int MSG_RINGER_MODE_CHANGED = 305;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.268 -0400", hash_original_field = "05F2B75868AC2F03379953146239D6CD", hash_generated_field = "C017587C166DE55C7FC6F4C30CB659D6")

    private static final int MSG_PHONE_STATE_CHANGED = 306;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.269 -0400", hash_original_field = "7C172E3DFC9F29E26045F124F791E20F", hash_generated_field = "638CDD1AFE9C5BFBFD539FC5DFAD915D")

    private static final int MSG_CLOCK_VISIBILITY_CHANGED = 307;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.269 -0400", hash_original_field = "1FB70183ADEE9CFA3C2960AC9A716F20", hash_generated_field = "6A472D291FB460DA2D4ABF2BDF21D706")

    private static final int MSG_DEVICE_PROVISIONED = 308;
}

