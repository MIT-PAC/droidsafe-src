package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.net.LinkCapabilities;
import android.net.LinkProperties;
import android.net.NetworkInfo;
import android.net.TrafficStats;
import android.net.wifi.WifiManager;
import android.os.AsyncResult;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.provider.Settings.SettingNotFoundException;
import android.telephony.ServiceState;
import android.text.TextUtils;
import android.util.Log;
import com.android.internal.R;
import com.android.internal.telephony.DataConnection.FailCause;
import com.android.internal.util.AsyncChannel;
import com.android.internal.util.Protocol;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class DataConnectionTracker extends Handler {
    protected Object mDataEnabledLock = new Object();
    protected boolean mInternalDataEnabled = true;
    protected boolean mUserDataEnabled = true;
    private boolean[] dataEnabled = new boolean[APN_NUM_TYPES];
    private int enabledCount = 0;
    protected String mRequestedApnType = Phone.APN_TYPE_DEFAULT;
    protected int mFailDataSetupCounter = 0;
    protected FailCause mFailDataSetupFailCause = FailCause.ERROR_UNSPECIFIED;
    protected PhoneBase mPhone;
    protected Activity mActivity = Activity.NONE;
    protected State mState = State.IDLE;
    protected Handler mDataConnectionTracker = null;
    protected long mTxPkts;
    protected long mRxPkts;
    protected int mNetStatPollPeriod;
    protected boolean mNetStatPollEnabled = false;
    protected TxRxSum mDataStallTxRxSum = new TxRxSum(0, 0);
    protected int mDataStallAlarmTag = (int) SystemClock.elapsedRealtime();
    protected PendingIntent mDataStallAlarmIntent = null;
    protected long mSentSinceLastRecv;
    protected int mNoRecvPollCount = 0;
    protected boolean mIsWifiConnected = false;
    protected PendingIntent mReconnectIntent = null;
    protected int mCidActive;
    protected boolean mAutoAttachOnCreation = false;
    protected boolean mIsScreenOn = true;
    protected AtomicInteger mUniqueIdGenerator = new AtomicInteger(0);
    protected HashMap<Integer, DataConnection> mDataConnections =
        new HashMap<Integer, DataConnection>();
    protected HashMap<Integer, DataConnectionAc> mDataConnectionAsyncChannels =
        new HashMap<Integer, DataConnectionAc>();
    protected HashMap<String, Integer> mApnToDataConnectionId =
                                    new HashMap<String, Integer>();
    protected ConcurrentHashMap<String, ApnContext> mApnContexts;
    protected ApnSetting mActiveApn;
    protected ArrayList<ApnSetting> mAllApns = null;
    protected ApnSetting mPreferredApn = null;
    protected boolean mIsPsRestricted = false;
    protected boolean mIsDisposed = false;
    protected BroadcastReceiver mIntentReceiver = new BroadcastReceiver() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.067 -0400", hash_original_method = "6A1F8749505D777AB5417234ADC2062B", hash_generated_method = "F0AE8FD851A1F8400243FB303BA87556")
        @DSModeled(DSC.SPEC)
        @Override
        public void onReceive(Context context, Intent intent) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(context.dsTaint);
            dsTaint.addTaint(intent.dsTaint);
            String action;
            action = intent.getAction();
            log("onReceive: action=" + action);
            {
                boolean var96145FA3EA33578069DB26D54E8F101D_500157208 = (action.equals(Intent.ACTION_SCREEN_ON));
                {
                    mIsScreenOn = true;
                    stopNetStatPoll();
                    startNetStatPoll();
                    restartDataStallAlarm();
                } //End block
                {
                    boolean var767BEBC8FC1BF29BC19AA771B91C30DC_1982922821 = (action.equals(Intent.ACTION_SCREEN_OFF));
                    {
                        mIsScreenOn = false;
                        stopNetStatPoll();
                        startNetStatPoll();
                        restartDataStallAlarm();
                    } //End block
                    {
                        boolean var657B0255569FEE532E29E31650D4768F_139352934 = (action.startsWith(getActionIntentReconnectAlarm()));
                        {
                            log("Reconnect alarm. Previous state was " + mState);
                            onActionIntentReconnectAlarm(intent);
                        } //End block
                        {
                            boolean var36F8FFF0AF59FF54D7904599A20B6C27_1219651341 = (action.equals(getActionIntentDataStallAlarm()));
                            {
                                onActionIntentDataStallAlarm(intent);
                            } //End block
                            {
                                boolean varAEED26211C259A659D32D3D5886FD918_312793045 = (action.equals(WifiManager.NETWORK_STATE_CHANGED_ACTION));
                                {
                                    android.net.NetworkInfo networkInfo;
                                    networkInfo = (NetworkInfo)
                        intent.getParcelableExtra(WifiManager.EXTRA_NETWORK_INFO);
                                    mIsWifiConnected = (networkInfo != null && networkInfo.isConnected());
                                } //End block
                                {
                                    boolean var63C3653546FDFD746F5A5E4F5D93A7DF_1471406527 = (action.equals(WifiManager.WIFI_STATE_CHANGED_ACTION));
                                    {
                                        boolean enabled;
                                        enabled = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE,
                        WifiManager.WIFI_STATE_UNKNOWN) == WifiManager.WIFI_STATE_ENABLED;
                                        {
                                            mIsWifiConnected = false;
                                        } //End block
                                    } //End block
                                    {
                                        boolean varC1CD06FA6A7988C248E9A4EC09E1418D_1818325387 = (action.equals(INTENT_SET_FAIL_DATA_SETUP_COUNTER));
                                        {
                                            mFailDataSetupCounter = intent.getIntExtra(FAIL_DATA_SETUP_COUNTER, 1);
                                            mFailDataSetupFailCause = FailCause.fromInt(
                        intent.getIntExtra(FAIL_DATA_SETUP_FAIL_CAUSE,
                                                    FailCause.ERROR_UNSPECIFIED.getErrorCode()));
                                            log("set mFailDataSetupCounter=" + mFailDataSetupCounter +
                        " mFailDataSetupFailCause=" + mFailDataSetupFailCause);
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End collapsed parenthetic
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
}; //Transformed anonymous class
    private DataRoamingSettingObserver mDataRoamingSettingObserver;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.068 -0400", hash_original_method = "3BD12FD7917DD1B6F1FA4984E09C99CB", hash_generated_method = "CFEA4434E6D4787817001B5B4114A038")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected DataConnectionTracker(PhoneBase phone) {
        super();
        dsTaint.addTaint(phone.dsTaint);
        IntentFilter filter;
        filter = new IntentFilter();
        filter.addAction(getActionIntentReconnectAlarm());
        filter.addAction(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        filter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION);
        filter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);
        filter.addAction(INTENT_SET_FAIL_DATA_SETUP_COUNTER);
        mUserDataEnabled = Settings.Secure.getInt(
                mPhone.getContext().getContentResolver(), Settings.Secure.MOBILE_DATA, 1) == 1;
        mPhone.getContext().registerReceiver(mIntentReceiver, filter, null, mPhone);
        dataEnabled[APN_DEFAULT_ID] = SystemProperties.getBoolean(DEFALUT_DATA_ON_BOOT_PROP,
                                                                  true);
        SharedPreferences sp;
        sp = PreferenceManager.getDefaultSharedPreferences(mPhone.getContext());
        mAutoAttachOnCreation = sp.getBoolean(PhoneBase.DATA_DISABLED_ON_BOOT_KEY, false);
        mDataRoamingSettingObserver = new DataRoamingSettingObserver(mPhone);
        mDataRoamingSettingObserver.register(mPhone.getContext());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.068 -0400", hash_original_method = "C16C211E95AFFD72D353E5EF5692A650", hash_generated_method = "D5F2EE63B1138F87665137E2F793EB47")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean isDataSetupCompleteOk(AsyncResult ar) {
        dsTaint.addTaint(ar.dsTaint);
        {
            log("isDataSetupCompleteOk return false, ar.result=" + ar.result);
        } //End block
        {
            log("isDataSetupCompleteOk return true");
        } //End block
        ar.result = mFailDataSetupFailCause;
        {
            log("isDataSetupCompleteOk return false" +
                    " mFailDataSetupCounter=" + mFailDataSetupCounter +
                    " mFailDataSetupFailCause=" + mFailDataSetupFailCause);
        } //End block
        mFailDataSetupCounter -= 1;
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (ar.exception != null) {
            //if (DBG) log("isDataSetupCompleteOk return false, ar.result=" + ar.result);
            //return false;
        //}
        //if (mFailDataSetupCounter <= 0) {
            //if (DBG) log("isDataSetupCompleteOk return true");
            //return true;
        //}
        //ar.result = mFailDataSetupFailCause;
        //if (DBG) {
            //log("isDataSetupCompleteOk return false" +
                    //" mFailDataSetupCounter=" + mFailDataSetupCounter +
                    //" mFailDataSetupFailCause=" + mFailDataSetupFailCause);
        //}
        //mFailDataSetupCounter -= 1;
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.069 -0400", hash_original_method = "838D9E0EFB087A153045FCBAD3FD613D", hash_generated_method = "654ADD4F87489750DBA87334E50FEB1A")
    @DSModeled(DSC.SPEC)
    protected void onActionIntentReconnectAlarm(Intent intent) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(intent.dsTaint);
        String reason;
        reason = intent.getStringExtra(INTENT_RECONNECT_ALARM_EXTRA_REASON);
        {
            Message msg;
            msg = obtainMessage(EVENT_CLEAN_UP_CONNECTION);
            msg.arg1 = 0;
            msg.arg2 = 0;
            msg.obj = reason;
            sendMessage(msg);
        } //End block
        sendMessage(obtainMessage(EVENT_TRY_SETUP_DATA));
        // ---------- Original Method ----------
        //String reason = intent.getStringExtra(INTENT_RECONNECT_ALARM_EXTRA_REASON);
        //if (mState == State.FAILED) {
            //Message msg = obtainMessage(EVENT_CLEAN_UP_CONNECTION);
            //msg.arg1 = 0; 
            //msg.arg2 = 0;
            //msg.obj = reason;
            //sendMessage(msg);
        //}
        //sendMessage(obtainMessage(EVENT_TRY_SETUP_DATA));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.069 -0400", hash_original_method = "A1F89C02319CA5D605879D459A1AC731", hash_generated_method = "ADC34BF781CF7AC91C63D818CA73FC3C")
    @DSModeled(DSC.SPEC)
    protected void onActionIntentDataStallAlarm(Intent intent) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(intent.dsTaint);
        log("onActionIntentDataStallAlarm: action=" + intent.getAction());
        Message msg;
        msg = obtainMessage(EVENT_DATA_STALL_ALARM, intent.getAction());
        msg.arg1 = intent.getIntExtra(DATA_STALL_ALARM_TAG_EXTRA, 0);
        sendMessage(msg);
        // ---------- Original Method ----------
        //if (VDBG) log("onActionIntentDataStallAlarm: action=" + intent.getAction());
        //Message msg = obtainMessage(EVENT_DATA_STALL_ALARM, intent.getAction());
        //msg.arg1 = intent.getIntExtra(DATA_STALL_ALARM_TAG_EXTRA, 0);
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.072 -0400", hash_original_method = "D3ED6AC13F3F749DE4F1E160957198B8", hash_generated_method = "A708E644525537465CBD69D93018D5C1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dispose() {
        {
            DataConnectionAc dcac = mDataConnectionAsyncChannels.values()[0];
            {
                dcac.disconnect();
            } //End block
        } //End collapsed parenthetic
        mDataConnectionAsyncChannels.clear();
        mIsDisposed = true;
        mPhone.getContext().unregisterReceiver(this.mIntentReceiver);
        mDataRoamingSettingObserver.unregister(mPhone.getContext());
        // ---------- Original Method ----------
        //for (DataConnectionAc dcac : mDataConnectionAsyncChannels.values()) {
            //dcac.disconnect();
        //}
        //mDataConnectionAsyncChannels.clear();
        //mIsDisposed = true;
        //mPhone.getContext().unregisterReceiver(this.mIntentReceiver);
        //mDataRoamingSettingObserver.unregister(mPhone.getContext());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.072 -0400", hash_original_method = "DDDDA1A5545DB0A17ACC18101B011287", hash_generated_method = "0488109B2960F54AA95604FF69CA581E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void broadcastMessenger() {
        Intent intent;
        intent = new Intent(ACTION_DATA_CONNECTION_TRACKER_MESSENGER);
        intent.putExtra(EXTRA_MESSENGER, new Messenger(this));
        mPhone.getContext().sendBroadcast(intent);
        // ---------- Original Method ----------
        //Intent intent = new Intent(ACTION_DATA_CONNECTION_TRACKER_MESSENGER);
        //intent.putExtra(EXTRA_MESSENGER, new Messenger(this));
        //mPhone.getContext().sendBroadcast(intent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.072 -0400", hash_original_method = "3F17133E8D63AE8C7414DC58966291E3", hash_generated_method = "EA5ED6C7AD559DE8BEC9EC10DF2A4427")
    @DSModeled(DSC.SAFE)
    public Activity getActivity() {
        return (Activity)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActivity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.072 -0400", hash_original_method = "125099B58F8163C25EB6B1F0707923F4", hash_generated_method = "B1C9E0CB2360F06CBF1FC6B8CC4F25BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isApnTypeActive(String type) {
        dsTaint.addTaint(type);
        {
            boolean var406626E19CADC2843874188E79EE9835_755567246 = (Phone.APN_TYPE_DUN.equals(type));
            {
                ApnSetting dunApn;
                dunApn = fetchDunApn();
                {
                    boolean var4EA0CE97F3A12CE0F2A51BCC7C48DA8F_1182073681 = (((mActiveApn != null) && (dunApn.toString().equals(mActiveApn.toString()))));
                } //End block
            } //End block
        } //End collapsed parenthetic
        boolean var169544BDB9440CDE71D63DA907E8F9A7_1433414291 = (mActiveApn != null && mActiveApn.canHandleType(type));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (Phone.APN_TYPE_DUN.equals(type)) {
            //ApnSetting dunApn = fetchDunApn();
            //if (dunApn != null) {
                //return ((mActiveApn != null) && (dunApn.toString().equals(mActiveApn.toString())));
            //}
        //}
        //return mActiveApn != null && mActiveApn.canHandleType(type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.073 -0400", hash_original_method = "616B5B126FC289B3EB6BE1030B710468", hash_generated_method = "631AA6A167A9258FC56FBE1768B1D69D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected ApnSetting fetchDunApn() {
        Context c;
        c = mPhone.getContext();
        String apnData;
        apnData = Settings.Secure.getString(c.getContentResolver(),
                Settings.Secure.TETHER_DUN_APN);
        ApnSetting dunSetting;
        dunSetting = ApnSetting.fromString(apnData);
        apnData = c.getResources().getString(R.string.config_tether_apndata);
        ApnSetting var678C33B373BC2543758DDD5993BF1DB7_292300464 = (ApnSetting.fromString(apnData));
        return (ApnSetting)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Context c = mPhone.getContext();
        //String apnData = Settings.Secure.getString(c.getContentResolver(),
                //Settings.Secure.TETHER_DUN_APN);
        //ApnSetting dunSetting = ApnSetting.fromString(apnData);
        //if (dunSetting != null) return dunSetting;
        //apnData = c.getResources().getString(R.string.config_tether_apndata);
        //return ApnSetting.fromString(apnData);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.073 -0400", hash_original_method = "F0E40F922DBB5D19CCBEC497FB284EC5", hash_generated_method = "79DEEA5D6ACC072BD85AF5AD9DDC04A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] getActiveApnTypes() {
        String[] result;
        {
            result = mActiveApn.types;
        } //End block
        {
            result = new String[1];
            result[0] = Phone.APN_TYPE_DEFAULT;
        } //End block
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //String[] result;
        //if (mActiveApn != null) {
            //result = mActiveApn.types;
        //} else {
            //result = new String[1];
            //result[0] = Phone.APN_TYPE_DEFAULT;
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.073 -0400", hash_original_method = "8A278F7563F3F2CC899D3E200DD135CD", hash_generated_method = "0308EA8D8E3F18748807553B2A559029")
    @DSModeled(DSC.SAFE)
    public String getActiveApnString(String apnType) {
        dsTaint.addTaint(apnType);
        String result;
        result = null;
        {
            result = mActiveApn.apn;
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String result = null;
        //if (mActiveApn != null) {
            //result = mActiveApn.apn;
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.074 -0400", hash_original_method = "B18C74BBD4D71B87D6CD20822DAEB60C", hash_generated_method = "DFC8FA4C6E63262A50E9EEA06C5381B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDataOnRoamingEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        {
            boolean varB54F03CDB64176FFCB855FF42639A95B_1766899857 = (getDataOnRoamingEnabled() != enabled);
            {
                ContentResolver resolver;
                resolver = mPhone.getContext().getContentResolver();
                Settings.Secure.putInt(resolver, Settings.Secure.DATA_ROAMING, enabled ? 1 : 0);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (getDataOnRoamingEnabled() != enabled) {
            //final ContentResolver resolver = mPhone.getContext().getContentResolver();
            //Settings.Secure.putInt(resolver, Settings.Secure.DATA_ROAMING, enabled ? 1 : 0);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.074 -0400", hash_original_method = "CA847DB1E96260749F912EC65B12A685", hash_generated_method = "95F6A0210EE6E8AED64FE28B1502A502")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getDataOnRoamingEnabled() {
        try 
        {
            ContentResolver resolver;
            resolver = mPhone.getContext().getContentResolver();
            boolean varE702C72B406FC62334614256CE642190_1247865870 = (Settings.Secure.getInt(resolver, Settings.Secure.DATA_ROAMING) != 0);
        } //End block
        catch (SettingNotFoundException snfe)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //final ContentResolver resolver = mPhone.getContext().getContentResolver();
            //return Settings.Secure.getInt(resolver, Settings.Secure.DATA_ROAMING) != 0;
        //} catch (SettingNotFoundException snfe) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.074 -0400", hash_original_method = "D53421F789432FAA1BE4F347AFB92C88", hash_generated_method = "CFB2A472F3C925B998D7D2F61A0224F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void handleDataOnRoamingChange() {
        {
            boolean var1B4EADABCFD05CFDD8C3D1EDB2CE784D_1933196410 = (mPhone.getServiceState().getRoaming());
            {
                {
                    boolean var83E97FA6F6D360AB5803CC641FB0388C_1124275386 = (getDataOnRoamingEnabled());
                    {
                        resetAllRetryCounts();
                    } //End block
                } //End collapsed parenthetic
                sendMessage(obtainMessage(EVENT_ROAMING_ON));
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (mPhone.getServiceState().getRoaming()) {
            //if (getDataOnRoamingEnabled()) {
                //resetAllRetryCounts();
            //}
            //sendMessage(obtainMessage(EVENT_ROAMING_ON));
        //}
    }

    
    protected abstract String getActionIntentReconnectAlarm();

    
    protected abstract String getActionIntentDataStallAlarm();

    
    protected abstract void startNetStatPoll();

    
    protected abstract void stopNetStatPoll();

    
    protected abstract void restartDataStallAlarm();

    
    protected abstract void restartRadio();

    
    protected abstract void log(String s);

    
    protected abstract void loge(String s);

    
    protected abstract boolean isDataAllowed();

    
    protected abstract boolean isApnTypeAvailable(String type);

    
    public abstract State getState(String apnType);

    
    protected abstract void setState(State s);

    
    protected abstract void gotoIdleAndNotifyDataConnection(String reason);

    
    protected abstract boolean onTrySetupData(String reason);

    
    protected abstract void onRoamingOff();

    
    protected abstract void onRoamingOn();

    
    protected abstract void onRadioAvailable();

    
    protected abstract void onRadioOffOrNotAvailable();

    
    protected abstract void onDataSetupComplete(AsyncResult ar);

    
    protected abstract void onDisconnectDone(int connId, AsyncResult ar);

    
    protected abstract void onVoiceCallStarted();

    
    protected abstract void onVoiceCallEnded();

    
    protected abstract void onCleanUpConnection(boolean tearDown, int apnId, String reason);

    
    protected abstract void onCleanUpAllConnections(String cause);

    
    protected abstract boolean isDataPossible(String apnType);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.079 -0400", hash_original_method = "664FE2A04A36F386D94369A328F3D0AD", hash_generated_method = "E940108042E3C849D3A5B9E2C91E4FA5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void onDataStallAlarm(int tag) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(tag);
        loge("onDataStallAlarm: not impleted tag=" + tag);
        // ---------- Original Method ----------
        //loge("onDataStallAlarm: not impleted tag=" + tag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.080 -0400", hash_original_method = "F3EE7F03AAF60471D3A97F562455D5DC", hash_generated_method = "ACDC0E24A46313882D7108848D723231")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void handleMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        //Begin case AsyncChannel.CMD_CHANNEL_DISCONNECTED 
        {
            log("DISCONNECTED_CONNECTED: msg=" + msg);
            DataConnectionAc dcac;
            dcac = (DataConnectionAc) msg.obj;
            mDataConnectionAsyncChannels.remove(dcac.dataConnection.getDataConnectionId());
            dcac.disconnected();
        } //End block
        //End case AsyncChannel.CMD_CHANNEL_DISCONNECTED 
        //Begin case EVENT_ENABLE_NEW_APN 
        onEnableApn(msg.arg1, msg.arg2);
        //End case EVENT_ENABLE_NEW_APN 
        //Begin case EVENT_TRY_SETUP_DATA 
        String reason;
        reason = null;
        //End case EVENT_TRY_SETUP_DATA 
        //Begin case EVENT_TRY_SETUP_DATA 
        {
            reason = (String) msg.obj;
        } //End block
        //End case EVENT_TRY_SETUP_DATA 
        //Begin case EVENT_TRY_SETUP_DATA 
        onTrySetupData(reason);
        //End case EVENT_TRY_SETUP_DATA 
        //Begin case EVENT_DATA_STALL_ALARM 
        onDataStallAlarm(msg.arg1);
        //End case EVENT_DATA_STALL_ALARM 
        //Begin case EVENT_ROAMING_OFF 
        {
            boolean var6A4EDF3FAFEE8B58E0E885094E7C645E_298698463 = (getDataOnRoamingEnabled() == false);
            {
                resetAllRetryCounts();
            } //End block
        } //End collapsed parenthetic
        //End case EVENT_ROAMING_OFF 
        //Begin case EVENT_ROAMING_OFF 
        onRoamingOff();
        //End case EVENT_ROAMING_OFF 
        //Begin case EVENT_ROAMING_ON 
        onRoamingOn();
        //End case EVENT_ROAMING_ON 
        //Begin case EVENT_RADIO_AVAILABLE 
        onRadioAvailable();
        //End case EVENT_RADIO_AVAILABLE 
        //Begin case EVENT_RADIO_OFF_OR_NOT_AVAILABLE 
        onRadioOffOrNotAvailable();
        //End case EVENT_RADIO_OFF_OR_NOT_AVAILABLE 
        //Begin case EVENT_DATA_SETUP_COMPLETE 
        mCidActive = msg.arg1;
        //End case EVENT_DATA_SETUP_COMPLETE 
        //Begin case EVENT_DATA_SETUP_COMPLETE 
        onDataSetupComplete((AsyncResult) msg.obj);
        //End case EVENT_DATA_SETUP_COMPLETE 
        //Begin case EVENT_DISCONNECT_DONE 
        log("DataConnectoinTracker.handleMessage: EVENT_DISCONNECT_DONE msg=" + msg);
        //End case EVENT_DISCONNECT_DONE 
        //Begin case EVENT_DISCONNECT_DONE 
        onDisconnectDone(msg.arg1, (AsyncResult) msg.obj);
        //End case EVENT_DISCONNECT_DONE 
        //Begin case EVENT_VOICE_CALL_STARTED 
        onVoiceCallStarted();
        //End case EVENT_VOICE_CALL_STARTED 
        //Begin case EVENT_VOICE_CALL_ENDED 
        onVoiceCallEnded();
        //End case EVENT_VOICE_CALL_ENDED 
        //Begin case EVENT_CLEAN_UP_ALL_CONNECTIONS 
        {
            onCleanUpAllConnections((String) msg.obj);
        } //End block
        //End case EVENT_CLEAN_UP_ALL_CONNECTIONS 
        //Begin case EVENT_CLEAN_UP_CONNECTION 
        {
            boolean tearDown;
            tearDown = false;
            tearDown = true;
            onCleanUpConnection(tearDown, msg.arg2, (String) msg.obj);
        } //End block
        //End case EVENT_CLEAN_UP_CONNECTION 
        //Begin case EVENT_SET_INTERNAL_DATA_ENABLE 
        {
            boolean enabled;
            enabled = true;
            enabled = false;
            onSetInternalDataEnabled(enabled);
        } //End block
        //End case EVENT_SET_INTERNAL_DATA_ENABLE 
        //Begin case EVENT_RESET_DONE 
        {
            log("EVENT_RESET_DONE");
            onResetDone((AsyncResult) msg.obj);
        } //End block
        //End case EVENT_RESET_DONE 
        //Begin case CMD_SET_USER_DATA_ENABLE 
        {
            boolean enabled;
            enabled = true;
            enabled = false;
            log("CMD_SET_USER_DATA_ENABLE enabled=" + enabled);
            onSetUserDataEnabled(enabled);
        } //End block
        //End case CMD_SET_USER_DATA_ENABLE 
        //Begin case CMD_SET_DEPENDENCY_MET 
        {
            boolean met;
            met = true;
            met = false;
            log("CMD_SET_DEPENDENCY_MET met=" + met);
            Bundle bundle;
            bundle = msg.getData();
            {
                String apnType;
                apnType = (String)bundle.get(APN_TYPE_KEY);
                {
                    onSetDependencyMet(apnType, met);
                } //End block
            } //End block
        } //End block
        //End case CMD_SET_DEPENDENCY_MET 
        //Begin case CMD_SET_POLICY_DATA_ENABLE 
        {
            boolean enabled;
            enabled = true;
            enabled = false;
            onSetPolicyDataEnabled(enabled);
        } //End block
        //End case CMD_SET_POLICY_DATA_ENABLE 
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.081 -0400", hash_original_method = "8F4FE806494E709DA803471FC4054850", hash_generated_method = "A364D04B6D559BCAA85A64A73E70BF0A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getAnyDataEnabled() {
        boolean result;
        {
            result = (mInternalDataEnabled && mUserDataEnabled && sPolicyDataEnabled
                    && (enabledCount != 0));
        } //End block
        log("getAnyDataEnabled " + result);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final boolean result;
        //synchronized (mDataEnabledLock) {
            //result = (mInternalDataEnabled && mUserDataEnabled && sPolicyDataEnabled
                    //&& (enabledCount != 0));
        //}
        //if (!result && DBG) log("getAnyDataEnabled " + result);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.081 -0400", hash_original_method = "01BBE084CAD104CD5BF824EF92BD879D", hash_generated_method = "8AB1D1DFACC1B7B800D2A9820F18E790")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean isEmergency() {
        boolean result;
        {
            result = mPhone.isInEcm() || mPhone.isInEmergencyCall();
        } //End block
        log("isEmergency: result=" + result);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final boolean result;
        //synchronized (mDataEnabledLock) {
            //result = mPhone.isInEcm() || mPhone.isInEmergencyCall();
        //}
        //log("isEmergency: result=" + result);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.081 -0400", hash_original_method = "5D23D8F3C80DDDEC0087C53C5035314E", hash_generated_method = "95F2F9D8CFE827AB7408F081CF24FB19")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected int apnTypeToId(String type) {
        dsTaint.addTaint(type);
        {
            boolean var309D3C860D69C9DD812B86CF681881B6_1865513963 = (TextUtils.equals(type, Phone.APN_TYPE_DEFAULT));
            {
                boolean var5A453EEDD3E3976BB49C9508291B2AF1_604166559 = (TextUtils.equals(type, Phone.APN_TYPE_MMS));
                {
                    boolean var3CE0D478E88EB81F167085762129B382_1974950504 = (TextUtils.equals(type, Phone.APN_TYPE_SUPL));
                    {
                        boolean varF95EB5896A1FFC653B2B4EDAB9BA81D0_664624792 = (TextUtils.equals(type, Phone.APN_TYPE_DUN));
                        {
                            boolean var869DCC811C6B09B9BEDB01CBDB8E3BB8_309196401 = (TextUtils.equals(type, Phone.APN_TYPE_HIPRI));
                            {
                                boolean var6BF0B7241C25AB8D91947F3EF585FCE9_281098959 = (TextUtils.equals(type, Phone.APN_TYPE_IMS));
                                {
                                    boolean var87D249D8144B57A4B6191CE038D7E433_1713125933 = (TextUtils.equals(type, Phone.APN_TYPE_FOTA));
                                    {
                                        boolean var14F7602C7EF2A0501FF08693C56BFA7B_743637552 = (TextUtils.equals(type, Phone.APN_TYPE_CBS));
                                    } //End collapsed parenthetic
                                } //End collapsed parenthetic
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.082 -0400", hash_original_method = "C8FDA5A0B2174A5D621C26D6E6AEF75F", hash_generated_method = "BBA5687B2F0F9697E5410060850292B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected String apnIdToType(int id) {
        dsTaint.addTaint(id);
        //Begin case default 
        log("Unknown id (" + id + ") in apnIdToType");
        //End case default 
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //switch (id) {
        //case APN_DEFAULT_ID:
            //return Phone.APN_TYPE_DEFAULT;
        //case APN_MMS_ID:
            //return Phone.APN_TYPE_MMS;
        //case APN_SUPL_ID:
            //return Phone.APN_TYPE_SUPL;
        //case APN_DUN_ID:
            //return Phone.APN_TYPE_DUN;
        //case APN_HIPRI_ID:
            //return Phone.APN_TYPE_HIPRI;
        //case APN_IMS_ID:
            //return Phone.APN_TYPE_IMS;
        //case APN_FOTA_ID:
            //return Phone.APN_TYPE_FOTA;
        //case APN_CBS_ID:
            //return Phone.APN_TYPE_CBS;
        //default:
            //log("Unknown id (" + id + ") in apnIdToType");
            //return Phone.APN_TYPE_DEFAULT;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.082 -0400", hash_original_method = "C93C3112872052D96A1B607494195947", hash_generated_method = "A81CAA878C4A361130B1EE236EAC6A57")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected LinkProperties getLinkProperties(String apnType) {
        dsTaint.addTaint(apnType);
        int id;
        id = apnTypeToId(apnType);
        {
            boolean var3B28DF70088D079134A00EB30AD60CE7_1889726433 = (isApnIdEnabled(id));
            {
                DataConnectionAc dcac;
                dcac = mDataConnectionAsyncChannels.get(0);
                LinkProperties varD2C3B5E0EEB3E50593471FB5FD58F663_1692178879 = (dcac.getLinkPropertiesSync());
            } //End block
            {
                LinkProperties var9115121DE7CF6C3B59C54A1C097704C8_729385250 = (new LinkProperties());
            } //End block
        } //End collapsed parenthetic
        return (LinkProperties)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int id = apnTypeToId(apnType);
        //if (isApnIdEnabled(id)) {
            //DataConnectionAc dcac = mDataConnectionAsyncChannels.get(0);
            //return dcac.getLinkPropertiesSync();
        //} else {
            //return new LinkProperties();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.083 -0400", hash_original_method = "8B34AF8E1FD52F7524E0692F560388F1", hash_generated_method = "A4DB0DA32DB5710D2479E45D439BD81D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected LinkCapabilities getLinkCapabilities(String apnType) {
        dsTaint.addTaint(apnType);
        int id;
        id = apnTypeToId(apnType);
        {
            boolean var3B28DF70088D079134A00EB30AD60CE7_788794486 = (isApnIdEnabled(id));
            {
                DataConnectionAc dcac;
                dcac = mDataConnectionAsyncChannels.get(0);
                LinkCapabilities var095CAF9E8DE69284B3A44F75C1170695_2070757064 = (dcac.getLinkCapabilitiesSync());
            } //End block
            {
                LinkCapabilities varBE2E482C221B9C622000BAAA2A05D1B5_1931881706 = (new LinkCapabilities());
            } //End block
        } //End collapsed parenthetic
        return (LinkCapabilities)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int id = apnTypeToId(apnType);
        //if (isApnIdEnabled(id)) {
            //DataConnectionAc dcac = mDataConnectionAsyncChannels.get(0);
            //return dcac.getLinkCapabilitiesSync();
        //} else {
            //return new LinkCapabilities();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.083 -0400", hash_original_method = "EA8A5478D5AABF3FA098569BF99381B3", hash_generated_method = "5CF98EADECC4F12DBA19C0427375BE13")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void notifyDataConnection(String reason) {
        dsTaint.addTaint(reason);
        {
            int id;
            id = 0;
            {
                {
                    mPhone.notifyDataConnection(reason, apnIdToType(id));
                } //End block
            } //End block
        } //End collapsed parenthetic
        notifyOffApnsOfAvailability(reason);
        // ---------- Original Method ----------
        //for (int id = 0; id < APN_NUM_TYPES; id++) {
            //if (dataEnabled[id]) {
                //mPhone.notifyDataConnection(reason, apnIdToType(id));
            //}
        //}
        //notifyOffApnsOfAvailability(reason);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.083 -0400", hash_original_method = "0EE2FD1B724C501D31FB7072BBECFF7B", hash_generated_method = "DBB438AC9B2BC5C548D8BF5DEE4FF891")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void notifyApnIdUpToCurrent(String reason, int apnId) {
        dsTaint.addTaint(reason);
        dsTaint.addTaint(apnId);
        //Begin case CONNECTING SCANNING 
        mPhone.notifyDataConnection(reason, apnIdToType(apnId), Phone.DataState.CONNECTING);
        //End case CONNECTING SCANNING 
        //Begin case CONNECTED DISCONNECTING 
        mPhone.notifyDataConnection(reason, apnIdToType(apnId), Phone.DataState.CONNECTING);
        //End case CONNECTED DISCONNECTING 
        //Begin case CONNECTED DISCONNECTING 
        mPhone.notifyDataConnection(reason, apnIdToType(apnId), Phone.DataState.CONNECTED);
        //End case CONNECTED DISCONNECTING 
        // ---------- Original Method ----------
        //switch (mState) {
            //case IDLE:
            //case INITING:
                //break;
            //case CONNECTING:
            //case SCANNING:
                //mPhone.notifyDataConnection(reason, apnIdToType(apnId), Phone.DataState.CONNECTING);
                //break;
            //case CONNECTED:
            //case DISCONNECTING:
                //mPhone.notifyDataConnection(reason, apnIdToType(apnId), Phone.DataState.CONNECTING);
                //mPhone.notifyDataConnection(reason, apnIdToType(apnId), Phone.DataState.CONNECTED);
                //break;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.083 -0400", hash_original_method = "D45BD11E51C479A3FCCFFBAFE72F463B", hash_generated_method = "7C3822E212C3E261CBE285A64D5AD829")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void notifyApnIdDisconnected(String reason, int apnId) {
        dsTaint.addTaint(reason);
        dsTaint.addTaint(apnId);
        mPhone.notifyDataConnection(reason, apnIdToType(apnId), Phone.DataState.DISCONNECTED);
        // ---------- Original Method ----------
        //mPhone.notifyDataConnection(reason, apnIdToType(apnId), Phone.DataState.DISCONNECTED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.084 -0400", hash_original_method = "AD67DC7D8E779758CC2EF151B8EB9A25", hash_generated_method = "6C1756EBAAFB1EDD2E39AE2F71A9CC1D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void notifyOffApnsOfAvailability(String reason) {
        dsTaint.addTaint(reason);
        log("notifyOffApnsOfAvailability - reason= " + reason);
        {
            int id;
            id = 0;
            {
                {
                    boolean var4E5CD2F83AC285F39052DC55CB4A94E1_262330004 = (!isApnIdEnabled(id));
                    {
                        notifyApnIdDisconnected(reason, id);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (DBG) log("notifyOffApnsOfAvailability - reason= " + reason);
        //for (int id = 0; id < APN_NUM_TYPES; id++) {
            //if (!isApnIdEnabled(id)) {
                //notifyApnIdDisconnected(reason, id);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.085 -0400", hash_original_method = "8B5C5B568EA76224959243C3FA291570", hash_generated_method = "49237935BB718F678C02DF1E8EACEE5A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isApnTypeEnabled(String apnType) {
        dsTaint.addTaint(apnType);
        {
            boolean varCF600E2D886E7589A9F5438BC08F9D5E_1684387141 = (isApnIdEnabled(apnTypeToId(apnType)));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (apnType == null) {
            //return false;
        //} else {
            //return isApnIdEnabled(apnTypeToId(apnType));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.086 -0400", hash_original_method = "453A43A7EADEB97159250F7F1E9B04E5", hash_generated_method = "8DE17FE03D620C7015A97E8C1BD8CCDA")
    @DSModeled(DSC.SAFE)
    protected synchronized boolean isApnIdEnabled(int id) {
        dsTaint.addTaint(id);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (id != APN_INVALID_ID) {
            //return dataEnabled[id];
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.087 -0400", hash_original_method = "B518CE0EFC616BFFCBE5135F2BCA33B7", hash_generated_method = "1FC27DA25D39F76E12C4A856CFEC2F51")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized int enableApnType(String type) {
        dsTaint.addTaint(type);
        int id;
        id = apnTypeToId(type);
        {
            log("enableApnType(" + type + "), isApnTypeActive = " + isApnTypeActive(type)
                    + ", isApnIdEnabled =" + isApnIdEnabled(id) + " and state = " + mState);
        } //End block
        {
            boolean varA853C8852E4D73E41EF53078A12AEAC4_1395064424 = (!isApnTypeAvailable(type));
            {
                log("type not available");
            } //End block
        } //End collapsed parenthetic
        {
            boolean var3B28DF70088D079134A00EB30AD60CE7_602589145 = (isApnIdEnabled(id));
            {
                setEnabled(id, true);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int id = apnTypeToId(type);
        //if (id == APN_INVALID_ID) {
            //return Phone.APN_REQUEST_FAILED;
        //}
        //if (DBG) {
            //log("enableApnType(" + type + "), isApnTypeActive = " + isApnTypeActive(type)
                    //+ ", isApnIdEnabled =" + isApnIdEnabled(id) + " and state = " + mState);
        //}
        //if (!isApnTypeAvailable(type)) {
            //if (DBG) log("type not available");
            //return Phone.APN_TYPE_NOT_AVAILABLE;
        //}
        //if (isApnIdEnabled(id)) {
            //return Phone.APN_ALREADY_ACTIVE;
        //} else {
            //setEnabled(id, true);
        //}
        //return Phone.APN_REQUEST_STARTED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.087 -0400", hash_original_method = "A5E4EE0A9C6812357B5B6B8F3C042D82", hash_generated_method = "11D10E96D7681B6026B72F8939A828DE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized int disableApnType(String type) {
        dsTaint.addTaint(type);
        log("disableApnType(" + type + ")");
        int id;
        id = apnTypeToId(type);
        {
            boolean var3B28DF70088D079134A00EB30AD60CE7_1615429940 = (isApnIdEnabled(id));
            {
                setEnabled(id, false);
                {
                    boolean var4038903CF6895B879BB8F22E571F633C_1290284243 = (isApnTypeActive(Phone.APN_TYPE_DEFAULT));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (DBG) log("disableApnType(" + type + ")");
        //int id = apnTypeToId(type);
        //if (id == APN_INVALID_ID) {
            //return Phone.APN_REQUEST_FAILED;
        //}
        //if (isApnIdEnabled(id)) {
            //setEnabled(id, false);
            //if (isApnTypeActive(Phone.APN_TYPE_DEFAULT)) {
                //if (dataEnabled[APN_DEFAULT_ID]) {
                    //return Phone.APN_ALREADY_ACTIVE;
                //} else {
                    //return Phone.APN_REQUEST_STARTED;
                //}
            //} else {
                //return Phone.APN_REQUEST_STARTED;
            //}
        //} else {
            //return Phone.APN_REQUEST_FAILED;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.088 -0400", hash_original_method = "25F13BA52E496C8972985CBEE5B69F23", hash_generated_method = "6E0A28AF6B67EFC625CB79D6D88A0FA5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void setEnabled(int id, boolean enable) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(enable);
        {
            log("setEnabled(" + id + ", " + enable + ") with old state = " + dataEnabled[id]
                    + " and enabledCount = " + enabledCount);
        } //End block
        Message msg;
        msg = obtainMessage(EVENT_ENABLE_NEW_APN);
        msg.arg1 = id;
        msg.arg2 = (enable ? ENABLED : DISABLED);
        sendMessage(msg);
        // ---------- Original Method ----------
        //if (DBG) {
            //log("setEnabled(" + id + ", " + enable + ") with old state = " + dataEnabled[id]
                    //+ " and enabledCount = " + enabledCount);
        //}
        //Message msg = obtainMessage(EVENT_ENABLE_NEW_APN);
        //msg.arg1 = id;
        //msg.arg2 = (enable ? ENABLED : DISABLED);
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.088 -0400", hash_original_method = "D525667770711BA9B2F4548C5B6FFD4C", hash_generated_method = "458EE09B843F5CF999AC4D0409ED352A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void onEnableApn(int apnId, int enabled) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(enabled);
        dsTaint.addTaint(apnId);
        {
            log("EVENT_APN_ENABLE_REQUEST apnId=" + apnId + ", apnType=" + apnIdToType(apnId) +
                    ", enabled=" + enabled + ", dataEnabled = " + dataEnabled[apnId] +
                    ", enabledCount = " + enabledCount + ", isApnTypeActive = " +
                    isApnTypeActive(apnIdToType(apnId)));
        } //End block
        {
            {
                {
                    dataEnabled[apnId] = true;
                } //End block
            } //End block
            String type;
            type = apnIdToType(apnId);
            {
                boolean varF392DA59AED5AF7339423DB9E4235404_786579121 = (!isApnTypeActive(type));
                {
                    mRequestedApnType = type;
                    onEnableNewApn();
                } //End block
                {
                    notifyApnIdUpToCurrent(Phone.REASON_APN_SWITCHED, apnId);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean didDisable;
            didDisable = false;
            {
                {
                    dataEnabled[apnId] = false;
                    didDisable = true;
                } //End block
            } //End block
            {
                {
                    mRequestedApnType = Phone.APN_TYPE_DEFAULT;
                    onCleanUpConnection(true, apnId, Phone.REASON_DATA_DISABLED);
                } //End block
                notifyApnIdDisconnected(Phone.REASON_DATA_DISABLED, apnId);
                {
                    boolean var77362D34A9ADAA4D41EE076EC20EEB8C_1409519525 = (dataEnabled[APN_DEFAULT_ID] == true
                        && !isApnTypeActive(Phone.APN_TYPE_DEFAULT));
                    {
                        mRequestedApnType = Phone.APN_TYPE_DEFAULT;
                        onEnableNewApn();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.089 -0400", hash_original_method = "FBAA4A80E4538BA497646C5AED60D911", hash_generated_method = "32D68D2D8870859115DE7BFCF2679FE7")
    @DSModeled(DSC.SAFE)
    protected void onEnableNewApn() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.089 -0400", hash_original_method = "58B3A2A4D2FF1B49B3A412CB94198F76", hash_generated_method = "D78E94ECE49B88AB8B0AA2C813B1376B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void onResetDone(AsyncResult ar) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(ar.dsTaint);
        log("EVENT_RESET_DONE");
        String reason;
        reason = null;
        {
            reason = (String) ar.userObj;
        } //End block
        gotoIdleAndNotifyDataConnection(reason);
        // ---------- Original Method ----------
        //if (DBG) log("EVENT_RESET_DONE");
        //String reason = null;
        //if (ar.userObj instanceof String) {
            //reason = (String) ar.userObj;
        //}
        //gotoIdleAndNotifyDataConnection(reason);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.089 -0400", hash_original_method = "DE9C8D1FA305A86440711210D5CC0DFB", hash_generated_method = "BF9E6BC2967594C959287976DF949CB2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setInternalDataEnabled(boolean enable) {
        dsTaint.addTaint(enable);
        log("setInternalDataEnabled(" + enable + ")");
        Message msg;
        msg = obtainMessage(EVENT_SET_INTERNAL_DATA_ENABLE);
        msg.arg1 = (enable ? ENABLED : DISABLED);
        sendMessage(msg);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (DBG)
            //log("setInternalDataEnabled(" + enable + ")");
        //Message msg = obtainMessage(EVENT_SET_INTERNAL_DATA_ENABLE);
        //msg.arg1 = (enable ? ENABLED : DISABLED);
        //sendMessage(msg);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.089 -0400", hash_original_method = "2FFC27FC9820E2F3BAEE3098A222A5B3", hash_generated_method = "4B54933AFE01766EC17C6D661F0CC17D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void onSetInternalDataEnabled(boolean enabled) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(enabled);
        {
            {
                log("onSetInternalDataEnabled: changed to enabled, try to setup data call");
                resetAllRetryCounts();
                onTrySetupData(Phone.REASON_DATA_ENABLED);
            } //End block
            {
                log("onSetInternalDataEnabled: changed to disabled, cleanUpAllConnections");
                cleanUpAllConnections(null);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (mDataEnabledLock) {
            //mInternalDataEnabled = enabled;
            //if (enabled) {
                //log("onSetInternalDataEnabled: changed to enabled, try to setup data call");
                //resetAllRetryCounts();
                //onTrySetupData(Phone.REASON_DATA_ENABLED);
            //} else {
                //log("onSetInternalDataEnabled: changed to disabled, cleanUpAllConnections");
                //cleanUpAllConnections(null);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.090 -0400", hash_original_method = "68E67092B4266000A5BC48E8C37B6ED2", hash_generated_method = "762132D4D2B736D3809615ABF3046E66")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void cleanUpAllConnections(String cause) {
        dsTaint.addTaint(cause);
        Message msg;
        msg = obtainMessage(EVENT_CLEAN_UP_ALL_CONNECTIONS);
        msg.obj = cause;
        sendMessage(msg);
        // ---------- Original Method ----------
        //Message msg = obtainMessage(EVENT_CLEAN_UP_ALL_CONNECTIONS);
        //msg.obj = cause;
        //sendMessage(msg);
    }

    
    public abstract boolean isDisconnected();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.090 -0400", hash_original_method = "49C3C07E31C3EAA572D4F39FF0B691FA", hash_generated_method = "6DD80FE64F947B2BAA782810ED3291A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void onSetUserDataEnabled(boolean enabled) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(enabled);
        {
            boolean prevEnabled;
            prevEnabled = getAnyDataEnabled();
            {
                Settings.Secure.putInt(mPhone.getContext().getContentResolver(),
                        Settings.Secure.MOBILE_DATA, enabled ? 1 : 0);
                {
                    boolean varE966989352CF1A89B6BCE35C2FF5420E_1607354987 = (prevEnabled != getAnyDataEnabled());
                    {
                        {
                            resetAllRetryCounts();
                            onTrySetupData(Phone.REASON_DATA_ENABLED);
                        } //End block
                        {
                            onCleanUpAllConnections(Phone.REASON_DATA_DISABLED);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (mDataEnabledLock) {
            //final boolean prevEnabled = getAnyDataEnabled();
            //if (mUserDataEnabled != enabled) {
                //mUserDataEnabled = enabled;
                //Settings.Secure.putInt(mPhone.getContext().getContentResolver(),
                        //Settings.Secure.MOBILE_DATA, enabled ? 1 : 0);
                //if (prevEnabled != getAnyDataEnabled()) {
                    //if (!prevEnabled) {
                        //resetAllRetryCounts();
                        //onTrySetupData(Phone.REASON_DATA_ENABLED);
                    //} else {
                        //onCleanUpAllConnections(Phone.REASON_DATA_DISABLED);
                    //}
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.090 -0400", hash_original_method = "CE2949FE6361D634BBA79ED70CC5EAE2", hash_generated_method = "79B6A67B23A9EF43A718AB4EB1471C31")
    @DSModeled(DSC.SAFE)
    protected void onSetDependencyMet(String apnType, boolean met) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(met);
        dsTaint.addTaint(apnType);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.090 -0400", hash_original_method = "5C2A966CAC36731C633B25393BAF4799", hash_generated_method = "764B8F542F6D251C5B0075E832708D0E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void onSetPolicyDataEnabled(boolean enabled) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(enabled);
        {
            boolean prevEnabled;
            prevEnabled = getAnyDataEnabled();
            {
                sPolicyDataEnabled = enabled;
                {
                    boolean varE966989352CF1A89B6BCE35C2FF5420E_851792132 = (prevEnabled != getAnyDataEnabled());
                    {
                        {
                            resetAllRetryCounts();
                            onTrySetupData(Phone.REASON_DATA_ENABLED);
                        } //End block
                        {
                            onCleanUpAllConnections(Phone.REASON_DATA_DISABLED);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (mDataEnabledLock) {
            //final boolean prevEnabled = getAnyDataEnabled();
            //if (sPolicyDataEnabled != enabled) {
                //sPolicyDataEnabled = enabled;
                //if (prevEnabled != getAnyDataEnabled()) {
                    //if (!prevEnabled) {
                        //resetAllRetryCounts();
                        //onTrySetupData(Phone.REASON_DATA_ENABLED);
                    //} else {
                        //onCleanUpAllConnections(Phone.REASON_DATA_DISABLED);
                    //}
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.091 -0400", hash_original_method = "E5EFA23236CE13ACC69B88C6F16F1B0C", hash_generated_method = "182C6CD83E4787F0C8ABEAD172BCE88A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected String getReryConfig(boolean forDefault) {
        dsTaint.addTaint(forDefault);
        int rt;
        rt = mPhone.getServiceState().getRadioTechnology();
        {
            String var5531B8FD3A885F8BE8C6569A158C9CE5_2005962992 = (SystemProperties.get("ro.cdma.data_retry_config"));
        } //End block
        {
            {
                String var8531BE0890427EF3DE9AD6DFBEDAAE28_998605411 = (SystemProperties.get("ro.gsm.data_retry_config"));
            } //End block
            {
                String varE62999E49CB43D09BED6B877030DBAC0_1342636861 = (SystemProperties.get("ro.gsm.2nd_data_retry_config"));
            } //End block
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.096 -0400", hash_original_method = "0FD4DA1D85F6AEE253925BB7FDB228BD", hash_generated_method = "2123BF91CEA86E056B1EC3D4E2E01F04")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void resetAllRetryCounts() {
        {
            Iterator<DataConnection> var8D54139306CE59DA2A79305B93065ACC_1084351935 = (mDataConnections.values()).iterator();
            var8D54139306CE59DA2A79305B93065ACC_1084351935.hasNext();
            DataConnection dc = var8D54139306CE59DA2A79305B93065ACC_1084351935.next();
            {
                dc.resetRetryCount();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (DataConnection dc : mDataConnections.values()) {
            //dc.resetRetryCount();
        //}
    }

    
    public enum State {
        IDLE,
        INITING,
        CONNECTING,
        SCANNING,
        CONNECTED,
        DISCONNECTING,
        FAILED
    }

    
    public enum Activity {
        NONE,
        DATAIN,
        DATAOUT,
        DATAINANDOUT,
        DORMANT
    }

    
    private class DataRoamingSettingObserver extends ContentObserver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.096 -0400", hash_original_method = "BA61ACB3318576C64C09DAC113E0795F", hash_generated_method = "335FD47E795536A59EE2901689E5D6E8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public DataRoamingSettingObserver(Handler handler) {
            super(handler);
            dsTaint.addTaint(handler.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.096 -0400", hash_original_method = "B90ABFF6DE01DDCB354DDF92EE51905A", hash_generated_method = "3B7CD74C8233B94EB3D581B11D411B27")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void register(Context context) {
            dsTaint.addTaint(context.dsTaint);
            ContentResolver resolver;
            resolver = context.getContentResolver();
            resolver.registerContentObserver(
                    Settings.Secure.getUriFor(Settings.Secure.DATA_ROAMING), false, this);
            // ---------- Original Method ----------
            //final ContentResolver resolver = context.getContentResolver();
            //resolver.registerContentObserver(
                    //Settings.Secure.getUriFor(Settings.Secure.DATA_ROAMING), false, this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.096 -0400", hash_original_method = "A96EEB9B30A252CB5EDDDA8B92E0867E", hash_generated_method = "4C259930253BBDFFBC38B10DC012013A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void unregister(Context context) {
            dsTaint.addTaint(context.dsTaint);
            ContentResolver resolver;
            resolver = context.getContentResolver();
            resolver.unregisterContentObserver(this);
            // ---------- Original Method ----------
            //final ContentResolver resolver = context.getContentResolver();
            //resolver.unregisterContentObserver(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.097 -0400", hash_original_method = "169C7D81EE3F2154C9E94D652CC4F700", hash_generated_method = "EF61AE10D58C8E620E4248F94AD036EA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void onChange(boolean selfChange) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(selfChange);
            handleDataOnRoamingChange();
            // ---------- Original Method ----------
            //handleDataOnRoamingChange();
        }

        
    }


    
    public class TxRxSum {
        public long txPkts;
        public long rxPkts;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.097 -0400", hash_original_method = "A9FFC39802399C2580CE69B9ED52FB70", hash_generated_method = "3480E04706A82CC0FC15FF716763F24D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public TxRxSum() {
            reset();
            // ---------- Original Method ----------
            //reset();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.097 -0400", hash_original_method = "CBCCCAC9E5E65AD1C4A36F84309761F3", hash_generated_method = "ABE2C60C1EFF522FEA577497F4B5FFE5")
        @DSModeled(DSC.SAFE)
        public TxRxSum(long txPkts, long rxPkts) {
            dsTaint.addTaint(rxPkts);
            dsTaint.addTaint(txPkts);
            // ---------- Original Method ----------
            //this.txPkts = txPkts;
            //this.rxPkts = rxPkts;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.097 -0400", hash_original_method = "AD3F4A8C32B5AB82EFF11F34262CA97C", hash_generated_method = "1CB766FD03C5BDE724FF96BC5CB6BDA8")
        @DSModeled(DSC.SAFE)
        public TxRxSum(TxRxSum sum) {
            dsTaint.addTaint(sum.dsTaint);
            txPkts = sum.txPkts;
            rxPkts = sum.rxPkts;
            // ---------- Original Method ----------
            //txPkts = sum.txPkts;
            //rxPkts = sum.rxPkts;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.097 -0400", hash_original_method = "AC7E7693FF46B721A881337A05B09C85", hash_generated_method = "8B79F23D5DA55C534A1AF5C4055F1390")
        @DSModeled(DSC.SAFE)
        public void reset() {
            txPkts = -1;
            rxPkts = -1;
            // ---------- Original Method ----------
            //txPkts = -1;
            //rxPkts = -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.097 -0400", hash_original_method = "1CA3D86B2E80A8520E2DD65A646FFF96", hash_generated_method = "7AC3526D8EDFDD2B75C09F164B304BCC")
        @DSModeled(DSC.SAFE)
        public String toString() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return "{txSum=" + txPkts + " rxSum=" + rxPkts + "}";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.104 -0400", hash_original_method = "4A3A2BC6E4110C10924DC1B1F4DD1644", hash_generated_method = "1B754712EA634B8D869408D14A7188B5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void updateTxRxSum() {
            boolean txUpdated, rxUpdated;
            txUpdated = false;
            rxUpdated = false;
            long txSum, rxSum;
            txSum = 0;
            rxSum = 0;
            {
                Iterator<ApnContext> var9CD107E7BA0F92F9952456E34FCCDBF9_1846884042 = (mApnContexts.values()).iterator();
                var9CD107E7BA0F92F9952456E34FCCDBF9_1846884042.hasNext();
                ApnContext apnContext = var9CD107E7BA0F92F9952456E34FCCDBF9_1846884042.next();
                {
                    {
                        boolean var2276B48A10025B18D3ED30F6663560D1_1877722986 = (apnContext.getState() == State.CONNECTED);
                        {
                            DataConnectionAc dcac;
                            dcac = apnContext.getDataConnectionAc();
                            LinkProperties linkProp;
                            linkProp = dcac.getLinkPropertiesSync();
                            String iface;
                            iface = linkProp.getInterfaceName();
                            {
                                long stats;
                                stats = TrafficStats.getTxPackets(iface);
                                {
                                    txUpdated = true;
                                    txSum += stats;
                                } //End block
                                stats = TrafficStats.getRxPackets(iface);
                                {
                                    rxUpdated = true;
                                    rxSum += stats;
                                } //End block
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            this.txPkts = txSum;
            this.rxPkts = rxSum;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    protected static final boolean DBG = true;
    protected static final boolean VDBG = false;
    public static String ACTION_DATA_CONNECTION_TRACKER_MESSENGER =
        "com.android.internal.telephony";
    public static String EXTRA_MESSENGER = "EXTRA_MESSENGER";
    protected static final int BASE = Protocol.BASE_DATA_CONNECTION_TRACKER;
    protected static final int EVENT_DATA_SETUP_COMPLETE = BASE + 0;
    protected static final int EVENT_RADIO_AVAILABLE = BASE + 1;
    protected static final int EVENT_RECORDS_LOADED = BASE + 2;
    protected static final int EVENT_TRY_SETUP_DATA = BASE + 3;
    protected static final int EVENT_DATA_STATE_CHANGED = BASE + 4;
    protected static final int EVENT_POLL_PDP = BASE + 5;
    protected static final int EVENT_RADIO_OFF_OR_NOT_AVAILABLE = BASE + 6;
    protected static final int EVENT_VOICE_CALL_STARTED = BASE + 7;
    protected static final int EVENT_VOICE_CALL_ENDED = BASE + 8;
    protected static final int EVENT_DATA_CONNECTION_DETACHED = BASE + 9;
    protected static final int EVENT_LINK_STATE_CHANGED = BASE + 10;
    protected static final int EVENT_ROAMING_ON = BASE + 11;
    protected static final int EVENT_ROAMING_OFF = BASE + 12;
    protected static final int EVENT_ENABLE_NEW_APN = BASE + 13;
    protected static final int EVENT_RESTORE_DEFAULT_APN = BASE + 14;
    protected static final int EVENT_DISCONNECT_DONE = BASE + 15;
    protected static final int EVENT_DATA_CONNECTION_ATTACHED = BASE + 16;
    protected static final int EVENT_DATA_STALL_ALARM = BASE + 17;
    protected static final int EVENT_DO_RECOVERY = BASE + 18;
    protected static final int EVENT_APN_CHANGED = BASE + 19;
    protected static final int EVENT_CDMA_DATA_DETACHED = BASE + 20;
    protected static final int EVENT_NV_READY = BASE + 21;
    protected static final int EVENT_PS_RESTRICT_ENABLED = BASE + 22;
    protected static final int EVENT_PS_RESTRICT_DISABLED = BASE + 23;
    public static final int EVENT_CLEAN_UP_CONNECTION = BASE + 24;
    protected static final int EVENT_CDMA_OTA_PROVISION = BASE + 25;
    protected static final int EVENT_RESTART_RADIO = BASE + 26;
    protected static final int EVENT_SET_INTERNAL_DATA_ENABLE = BASE + 27;
    protected static final int EVENT_RESET_DONE = BASE + 28;
    public static final int CMD_SET_USER_DATA_ENABLE = BASE + 29;
    public static final int EVENT_CLEAN_UP_ALL_CONNECTIONS = BASE + 30;
    public static final int CMD_SET_DEPENDENCY_MET = BASE + 31;
    public static final int CMD_SET_POLICY_DATA_ENABLE = BASE + 32;
    protected static final int APN_INVALID_ID = -1;
    protected static final int APN_DEFAULT_ID = 0;
    protected static final int APN_MMS_ID = 1;
    protected static final int APN_SUPL_ID = 2;
    protected static final int APN_DUN_ID = 3;
    protected static final int APN_HIPRI_ID = 4;
    protected static final int APN_IMS_ID = 5;
    protected static final int APN_FOTA_ID = 6;
    protected static final int APN_CBS_ID = 7;
    protected static final int APN_NUM_TYPES = 8;
    public static final int DISABLED = 0;
    public static final int ENABLED = 1;
    public static final String APN_TYPE_KEY = "apnType";
    protected static final int APN_DELAY_MILLIS =
                                SystemProperties.getInt("persist.radio.apn_delay", 5000);
    protected static boolean sPolicyDataEnabled = true;
    protected static final String DEFAULT_DATA_RETRY_CONFIG = "default_randomization=2000,"
        + "5000,10000,20000,40000,80000:5000,160000:5000,"
        + "320000:5000,640000:5000,1280000:5000,1800000:5000";
    protected static final String SECONDARY_DATA_RETRY_CONFIG =
            "max_retries=3, 5000, 5000, 5000";
    protected static final int POLL_NETSTAT_SLOW_MILLIS = 5000;
    protected static final int DEFAULT_MAX_PDP_RESET_FAIL = 3;
    protected static final int NO_RECV_POLL_LIMIT = 24;
    protected static final int POLL_NETSTAT_MILLIS = 1000;
    protected static final int POLL_NETSTAT_SCREEN_OFF_MILLIS = 1000*60*10;
    protected static final int POLL_LONGEST_RTT = 120 * 1000;
    protected static final int NUMBER_SENT_PACKETS_OF_HANG = 10;
    protected static final int RESTORE_DEFAULT_APN_DELAY = 1 * 60 * 1000;
    protected static final String APN_RESTORE_DELAY_PROP_NAME = "android.telephony.apn-restore";
    protected static final String NULL_IP = "0.0.0.0";
    protected static final int DATA_STALL_ALARM_NON_AGGRESSIVE_DELAY_IN_MS_DEFAULT = 1000 * 60 * 6;
    protected static final int DATA_STALL_ALARM_AGGRESSIVE_DELAY_IN_MS_DEFAULT = 1000 * 60;
    protected static final int DATA_STALL_NO_RECV_POLL_LIMIT = 1;
    protected static final String DATA_STALL_ALARM_TAG_EXTRA = "data.stall.alram.tag";
    protected static final String INTENT_RECONNECT_ALARM_EXTRA_REASON = "reason";
    protected static final String INTENT_SET_FAIL_DATA_SETUP_COUNTER =
        "com.android.internal.telephony.dataconnectiontracker.intent_set_fail_data_setup_counter";
    protected static final String FAIL_DATA_SETUP_COUNTER = "fail_data_setup_counter";
    protected static final String FAIL_DATA_SETUP_FAIL_CAUSE = "fail_data_setup_fail_cause";
    protected static final String DEFALUT_DATA_ON_BOOT_PROP = "net.def_data_on_boot";
}

