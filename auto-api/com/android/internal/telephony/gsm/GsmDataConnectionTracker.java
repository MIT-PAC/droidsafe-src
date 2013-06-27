package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.LinkAddress;
import android.net.LinkCapabilities;
import android.net.LinkProperties;
import android.net.LinkProperties.CompareResult;
import android.net.NetworkConfig;
import android.net.NetworkUtils;
import android.net.ProxyProperties;
import android.net.TrafficStats;
import android.net.Uri;
import android.os.AsyncResult;
import android.os.Message;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.provider.Settings;
import android.provider.Telephony;
import android.telephony.CellLocation;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.util.EventLog;
import android.util.Log;
import com.android.internal.telephony.ApnContext;
import com.android.internal.telephony.ApnSetting;
import com.android.internal.telephony.DataCallState;
import com.android.internal.telephony.DataConnection;
import com.android.internal.telephony.DataConnection.FailCause;
import com.android.internal.telephony.DataConnection.UpdateLinkPropertyResult;
import com.android.internal.telephony.DataConnectionAc;
import com.android.internal.telephony.DataConnectionTracker;
import com.android.internal.telephony.EventLogTags;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.PhoneBase;
import com.android.internal.telephony.RILConstants;
import com.android.internal.telephony.RetryManager;
import com.android.internal.util.AsyncChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public final class GsmDataConnectionTracker extends DataConnectionTracker {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.442 -0400", hash_original_field = "41EBE7F32B96C1E2E9C209710486A443", hash_generated_field = "BAD328EA3346076F0231E9749A628503")

    protected String LOG_TAG = "GSM";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.442 -0400", hash_original_field = "CB443E461AA44F68B1DC476C038F72CE", hash_generated_field = "AFBF9D057D14B66BDF7B1FCB26AAA726")

    private boolean mReregisterOnReconnectFailure = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.442 -0400", hash_original_field = "CF849E3C15214EFD093D4303B542BF44", hash_generated_field = "2ABF989C5B8F051BCBEE638ED1EA2586")

    private ContentResolver mResolver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.444 -0400", hash_original_field = "FA9556560FEE15D3226A9A0A646DC9DC", hash_generated_field = "9743D11ECCACBF447559588D9C3455D1")

    private boolean canSetPreferApn = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.445 -0400", hash_original_field = "93901191D4EDD5699E27D54768404908", hash_generated_field = "7AE0CA44A8148D1733CD8642E6D8D32F")

    private ApnChangeObserver mApnObserver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.445 -0400", hash_original_field = "DCC8D3A9D9C8D2BC581A6F46B0C096D3", hash_generated_field = "5FF6BB30FC5538CA9B1C3C54EDD3B6FC")

    private Runnable mPollNetStat = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.445 -0400", hash_original_method = "12521CBB0E1762BFCDF7B49EB5CC9977", hash_generated_method = "EEDFDA3636D0462EB4B15FD97B22B6E4")
        @Override
        public void run() {
            updateDataActivity();
            {
                mNetStatPollPeriod = Settings.Secure.getInt(mResolver,
                        Settings.Secure.PDP_WATCHDOG_POLL_INTERVAL_MS, POLL_NETSTAT_MILLIS);
            } //End block
            {
                mNetStatPollPeriod = Settings.Secure.getInt(mResolver,
                        Settings.Secure.PDP_WATCHDOG_LONG_POLL_INTERVAL_MS,
                        POLL_NETSTAT_SCREEN_OFF_MILLIS);
            } //End block
            {
                mDataConnectionTracker.postDelayed(this, mNetStatPollPeriod);
            } //End block
            // ---------- Original Method ----------
            //updateDataActivity();
            //if (mIsScreenOn) {
                //mNetStatPollPeriod = Settings.Secure.getInt(mResolver,
                        //Settings.Secure.PDP_WATCHDOG_POLL_INTERVAL_MS, POLL_NETSTAT_MILLIS);
            //} else {
                //mNetStatPollPeriod = Settings.Secure.getInt(mResolver,
                        //Settings.Secure.PDP_WATCHDOG_LONG_POLL_INTERVAL_MS,
                        //POLL_NETSTAT_SCREEN_OFF_MILLIS);
            //}
            //if (mNetStatPollEnabled) {
                //mDataConnectionTracker.postDelayed(this, mNetStatPollPeriod);
            //}
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.446 -0400", hash_original_method = "11FDC14BF2164142AF8732E525079D07", hash_generated_method = "3B3236F8510984A3D9AB9F41B771F759")
    public  GsmDataConnectionTracker(PhoneBase p) {
        super(p);
        p.mCM.registerForAvailable (this, EVENT_RADIO_AVAILABLE, null);
        p.mCM.registerForOffOrNotAvailable(this, EVENT_RADIO_OFF_OR_NOT_AVAILABLE, null);
        p.mIccRecords.registerForRecordsLoaded(this, EVENT_RECORDS_LOADED, null);
        p.mCM.registerForDataNetworkStateChanged (this, EVENT_DATA_STATE_CHANGED, null);
        p.getCallTracker().registerForVoiceCallEnded (this, EVENT_VOICE_CALL_ENDED, null);
        p.getCallTracker().registerForVoiceCallStarted (this, EVENT_VOICE_CALL_STARTED, null);
        p.getServiceStateTracker().registerForDataConnectionAttached(this,
                EVENT_DATA_CONNECTION_ATTACHED, null);
        p.getServiceStateTracker().registerForDataConnectionDetached(this,
                EVENT_DATA_CONNECTION_DETACHED, null);
        p.getServiceStateTracker().registerForRoamingOn(this, EVENT_ROAMING_ON, null);
        p.getServiceStateTracker().registerForRoamingOff(this, EVENT_ROAMING_OFF, null);
        p.getServiceStateTracker().registerForPsRestrictedEnabled(this,
                EVENT_PS_RESTRICT_ENABLED, null);
        p.getServiceStateTracker().registerForPsRestrictedDisabled(this,
                EVENT_PS_RESTRICT_DISABLED, null);
        IntentFilter filter;
        filter = new IntentFilter();
        filter.addAction(INTENT_DATA_STALL_ALARM);
        p.getContext().registerReceiver(mIntentReceiver, filter, null, p);
        mDataConnectionTracker = this;
        mResolver = mPhone.getContext().getContentResolver();
        mApnObserver = new ApnChangeObserver();
        p.getContext().getContentResolver().registerContentObserver(
                Telephony.Carriers.CONTENT_URI, true, mApnObserver);
        mApnContexts = new ConcurrentHashMap<String, ApnContext>();
        initApnContextsAndDataConnection();
        broadcastMessenger();
        addTaint(p.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.462 -0400", hash_original_method = "3545EE6BB84B537BCF88623776AFA30D", hash_generated_method = "C4210369C6CDA227640CCB2417E0EDFA")
    public int getRecoveryAction() {
        int action;
        action = Settings.System.getInt(mPhone.getContext().getContentResolver(),
                "radio.data.stall.recovery.action", RecoveryAction.GET_DATA_CALL_LIST);
        log("getRecoveryAction: " + action);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_650365691 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_650365691;
        // ---------- Original Method ----------
        //int action = Settings.System.getInt(mPhone.getContext().getContentResolver(),
                //"radio.data.stall.recovery.action", RecoveryAction.GET_DATA_CALL_LIST);
        //if (VDBG) log("getRecoveryAction: " + action);
        //return action;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.462 -0400", hash_original_method = "D18EC99E3BCC3D9A76595B0D702BEA57", hash_generated_method = "6BEFE1BF09EA4008074177F733C4D192")
    public void putRecoveryAction(int action) {
        Settings.System.putInt(mPhone.getContext().getContentResolver(),
                "radio.data.stall.recovery.action", action);
        log("putRecoveryAction: " + action);
        addTaint(action);
        // ---------- Original Method ----------
        //Settings.System.putInt(mPhone.getContext().getContentResolver(),
                //"radio.data.stall.recovery.action", action);
        //if (VDBG) log("putRecoveryAction: " + action);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.522 -0400", hash_original_method = "DABEDBF19FEC4514BE5AAA6475C962EB", hash_generated_method = "6D32ABB185F3C2E73AF1475C7827DB73")
    @Override
    protected void onActionIntentReconnectAlarm(Intent intent) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        log("GPRS reconnect alarm. Previous state was " + mState);
        String reason;
        reason = intent.getStringExtra(INTENT_RECONNECT_ALARM_EXTRA_REASON);
        int connectionId;
        connectionId = intent.getIntExtra(INTENT_RECONNECT_ALARM_EXTRA_TYPE, -1);
        DataConnectionAc dcac;
        dcac = mDataConnectionAsyncChannels.get(connectionId);
        {
            {
                Iterator<ApnContext> varEF92E30A3FB0B00CC855D485C129D6BC_294316236 = (dcac.getApnListSync()).iterator();
                varEF92E30A3FB0B00CC855D485C129D6BC_294316236.hasNext();
                ApnContext apnContext = varEF92E30A3FB0B00CC855D485C129D6BC_294316236.next();
                {
                    apnContext.setReason(reason);
                    {
                        boolean var8C3F5A245E8CD46D727CA60CA79AEBA0_82586269 = (apnContext.getState() == State.FAILED);
                        {
                            apnContext.setState(State.IDLE);
                        } //End block
                    } //End collapsed parenthetic
                    sendMessage(obtainMessage(EVENT_TRY_SETUP_DATA, apnContext));
                } //End block
            } //End collapsed parenthetic
            dcac.setReconnectIntentSync(null);
        } //End block
        addTaint(intent.getTaint());
        // ---------- Original Method ----------
        //if (DBG) log("GPRS reconnect alarm. Previous state was " + mState);
        //String reason = intent.getStringExtra(INTENT_RECONNECT_ALARM_EXTRA_REASON);
        //int connectionId = intent.getIntExtra(INTENT_RECONNECT_ALARM_EXTRA_TYPE, -1);
        //DataConnectionAc dcac= mDataConnectionAsyncChannels.get(connectionId);
        //if (dcac != null) {
            //for (ApnContext apnContext : dcac.getApnListSync()) {
                //apnContext.setReason(reason);
                //if (apnContext.getState() == State.FAILED) {
                    //apnContext.setState(State.IDLE);
                //}
                //sendMessage(obtainMessage(EVENT_TRY_SETUP_DATA, apnContext));
            //}
            //dcac.setReconnectIntentSync(null);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.532 -0400", hash_original_method = "4494E5E1AF62FA72ED21CBDD59685023", hash_generated_method = "2CEC678BFD48E0CD7A4526D23263E43F")
    @Override
    public void dispose() {
        cleanUpAllConnections(false, null);
        super.dispose();
        mPhone.mCM.unregisterForAvailable(this);
        mPhone.mCM.unregisterForOffOrNotAvailable(this);
        mPhone.mIccRecords.unregisterForRecordsLoaded(this);
        mPhone.mCM.unregisterForDataNetworkStateChanged(this);
        mPhone.getCallTracker().unregisterForVoiceCallEnded(this);
        mPhone.getCallTracker().unregisterForVoiceCallStarted(this);
        mPhone.getServiceStateTracker().unregisterForDataConnectionAttached(this);
        mPhone.getServiceStateTracker().unregisterForDataConnectionDetached(this);
        mPhone.getServiceStateTracker().unregisterForRoamingOn(this);
        mPhone.getServiceStateTracker().unregisterForRoamingOff(this);
        mPhone.getServiceStateTracker().unregisterForPsRestrictedEnabled(this);
        mPhone.getServiceStateTracker().unregisterForPsRestrictedDisabled(this);
        mPhone.getContext().getContentResolver().unregisterContentObserver(this.mApnObserver);
        mApnContexts.clear();
        destroyDataConnections();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.533 -0400", hash_original_method = "7B2466E598494011616B7E0248698FD2", hash_generated_method = "1A2DBB99FA870C0282DFBB58C5B8DE7E")
    @Override
    public boolean isApnTypeActive(String type) {
        ApnContext apnContext;
        apnContext = mApnContexts.get(type);
        boolean varFD30B4DFFE3E84898874278558C9F3D1_453094240 = ((apnContext.getDataConnection() != null));
        addTaint(type.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1364385081 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1364385081;
        // ---------- Original Method ----------
        //ApnContext apnContext = mApnContexts.get(type);
        //if (apnContext == null) return false;
        //return (apnContext.getDataConnection() != null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.533 -0400", hash_original_method = "63B54477A01480F02B741F41FE0D8DBF", hash_generated_method = "4F05F4882C2AFE8F526E6A598FDF6DC3")
    @Override
    protected boolean isDataPossible(String apnType) {
        ApnContext apnContext;
        apnContext = mApnContexts.get(apnType);
        boolean apnContextIsEnabled;
        apnContextIsEnabled = apnContext.isEnabled();
        State apnContextState;
        apnContextState = apnContext.getState();
        boolean apnTypePossible;
        apnTypePossible = !(apnContextIsEnabled &&
                (apnContextState == State.FAILED));
        boolean dataAllowed;
        dataAllowed = isDataAllowed();
        boolean possible;
        possible = dataAllowed && apnTypePossible;
        {
            log(String.format("isDataPossible(%s): possible=%b isDataAllowed=%b " +
                    "apnTypePossible=%b apnContextisEnabled=%b apnContextState()=%s",
                    apnType, possible, dataAllowed, apnTypePossible,
                    apnContextIsEnabled, apnContextState));
        } //End block
        addTaint(apnType.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1484482471 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1484482471;
        // ---------- Original Method ----------
        //ApnContext apnContext = mApnContexts.get(apnType);
        //if (apnContext == null) {
            //return false;
        //}
        //boolean apnContextIsEnabled = apnContext.isEnabled();
        //State apnContextState = apnContext.getState();
        //boolean apnTypePossible = !(apnContextIsEnabled &&
                //(apnContextState == State.FAILED));
        //boolean dataAllowed = isDataAllowed();
        //boolean possible = dataAllowed && apnTypePossible;
        //if (DBG) {
            //log(String.format("isDataPossible(%s): possible=%b isDataAllowed=%b " +
                    //"apnTypePossible=%b apnContextisEnabled=%b apnContextState()=%s",
                    //apnType, possible, dataAllowed, apnTypePossible,
                    //apnContextIsEnabled, apnContextState));
        //}
        //return possible;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.533 -0400", hash_original_method = "6FB50CEA8307C4B6093E637FBC3F2923", hash_generated_method = "586E4F0B9964C893B65A8A5D4241A99C")
    @Override
    protected void finalize() {
        log("finalize");
        // ---------- Original Method ----------
        //if(DBG) log("finalize");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.534 -0400", hash_original_method = "477FAE9A0F7056536F0C43A4344C1E00", hash_generated_method = "428FB6CDE0E340CEDAB41F554B19B810")
    @Override
    protected String getActionIntentReconnectAlarm() {
        String varB4EAC82CA7396A68D541C85D26508E83_169876614 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_169876614 = INTENT_RECONNECT_ALARM;
        varB4EAC82CA7396A68D541C85D26508E83_169876614.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_169876614;
        // ---------- Original Method ----------
        //return INTENT_RECONNECT_ALARM;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.534 -0400", hash_original_method = "BBE23E9137760572C0B9E85F7DE2F87D", hash_generated_method = "FB4300907EA2B269807AC026A1C61C22")
    @Override
    protected String getActionIntentDataStallAlarm() {
        String varB4EAC82CA7396A68D541C85D26508E83_1896761032 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1896761032 = INTENT_DATA_STALL_ALARM;
        varB4EAC82CA7396A68D541C85D26508E83_1896761032.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1896761032;
        // ---------- Original Method ----------
        //return INTENT_DATA_STALL_ALARM;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.535 -0400", hash_original_method = "0E3E3502B5D9BF75D72D228425E0F7B7", hash_generated_method = "5E5277B145BA27D85E24EEBFFAFDAD3D")
    private ApnContext addApnContext(String type) {
        ApnContext varB4EAC82CA7396A68D541C85D26508E83_843752076 = null; //Variable for return #1
        ApnContext apnContext;
        apnContext = new ApnContext(type, LOG_TAG);
        apnContext.setDependencyMet(false);
        mApnContexts.put(type, apnContext);
        varB4EAC82CA7396A68D541C85D26508E83_843752076 = apnContext;
        addTaint(type.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_843752076.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_843752076;
        // ---------- Original Method ----------
        //ApnContext apnContext = new ApnContext(type, LOG_TAG);
        //apnContext.setDependencyMet(false);
        //mApnContexts.put(type, apnContext);
        //return apnContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.595 -0400", hash_original_method = "8959993CE2EB92BA5CEF3E2E51BAABDD", hash_generated_method = "15DD095AF8A0BFF06A4DB0FDA6A0383C")
    protected void initApnContextsAndDataConnection() {
        boolean defaultEnabled;
        defaultEnabled = SystemProperties.getBoolean(DEFALUT_DATA_ON_BOOT_PROP, true);
        String[] networkConfigStrings;
        networkConfigStrings = mPhone.getContext().getResources().getStringArray(
                com.android.internal.R.array.networkAttributes);
        {
            Iterator<String> varFCBF4F45EEFB0EB5B1058673AF74B5F6_1687490933 = (networkConfigStrings).iterator();
            varFCBF4F45EEFB0EB5B1058673AF74B5F6_1687490933.hasNext();
            String networkConfigString = varFCBF4F45EEFB0EB5B1058673AF74B5F6_1687490933.next();
            {
                NetworkConfig networkConfig;
                networkConfig = new NetworkConfig(networkConfigString);
                ApnContext apnContext;
                apnContext = null;
                //Begin case ConnectivityManager.TYPE_MOBILE 
                apnContext = addApnContext(Phone.APN_TYPE_DEFAULT);
                //End case ConnectivityManager.TYPE_MOBILE 
                //Begin case ConnectivityManager.TYPE_MOBILE 
                apnContext.setEnabled(defaultEnabled);
                //End case ConnectivityManager.TYPE_MOBILE 
                //Begin case ConnectivityManager.TYPE_MOBILE_MMS 
                apnContext = addApnContext(Phone.APN_TYPE_MMS);
                //End case ConnectivityManager.TYPE_MOBILE_MMS 
                //Begin case ConnectivityManager.TYPE_MOBILE_SUPL 
                apnContext = addApnContext(Phone.APN_TYPE_SUPL);
                //End case ConnectivityManager.TYPE_MOBILE_SUPL 
                //Begin case ConnectivityManager.TYPE_MOBILE_DUN 
                apnContext = addApnContext(Phone.APN_TYPE_DUN);
                //End case ConnectivityManager.TYPE_MOBILE_DUN 
                //Begin case ConnectivityManager.TYPE_MOBILE_HIPRI 
                apnContext = addApnContext(Phone.APN_TYPE_HIPRI);
                //End case ConnectivityManager.TYPE_MOBILE_HIPRI 
                //Begin case ConnectivityManager.TYPE_MOBILE_HIPRI 
                ApnContext defaultContext;
                defaultContext = mApnContexts.get(Phone.APN_TYPE_DEFAULT);
                //End case ConnectivityManager.TYPE_MOBILE_HIPRI 
                //Begin case ConnectivityManager.TYPE_MOBILE_HIPRI 
                {
                    applyNewState(apnContext, apnContext.isEnabled(),
                            defaultContext.getDependencyMet());
                } //End block
                //End case ConnectivityManager.TYPE_MOBILE_HIPRI 
                //Begin case ConnectivityManager.TYPE_MOBILE_FOTA 
                apnContext = addApnContext(Phone.APN_TYPE_FOTA);
                //End case ConnectivityManager.TYPE_MOBILE_FOTA 
                //Begin case ConnectivityManager.TYPE_MOBILE_IMS 
                apnContext = addApnContext(Phone.APN_TYPE_IMS);
                //End case ConnectivityManager.TYPE_MOBILE_IMS 
                //Begin case ConnectivityManager.TYPE_MOBILE_CBS 
                apnContext = addApnContext(Phone.APN_TYPE_CBS);
                //End case ConnectivityManager.TYPE_MOBILE_CBS 
                {
                    onSetDependencyMet(apnContext.getApnType(), networkConfig.dependencyMet);
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.597 -0400", hash_original_method = "C5F45AE4298273442B50BBFD614E8417", hash_generated_method = "D8AD6C97723F96A0D7A61E06387D71B4")
    @Override
    protected LinkProperties getLinkProperties(String apnType) {
        LinkProperties varB4EAC82CA7396A68D541C85D26508E83_275660346 = null; //Variable for return #1
        LinkProperties varB4EAC82CA7396A68D541C85D26508E83_292215600 = null; //Variable for return #2
        ApnContext apnContext;
        apnContext = mApnContexts.get(apnType);
        {
            DataConnectionAc dcac;
            dcac = apnContext.getDataConnectionAc();
            {
                log("return link properites for " + apnType);
                varB4EAC82CA7396A68D541C85D26508E83_275660346 = dcac.getLinkPropertiesSync();
            } //End block
        } //End block
        log("return new LinkProperties");
        varB4EAC82CA7396A68D541C85D26508E83_292215600 = new LinkProperties();
        addTaint(apnType.getTaint());
        LinkProperties varA7E53CE21691AB073D9660D615818899_2067565892; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2067565892 = varB4EAC82CA7396A68D541C85D26508E83_275660346;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2067565892 = varB4EAC82CA7396A68D541C85D26508E83_292215600;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2067565892.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2067565892;
        // ---------- Original Method ----------
        //ApnContext apnContext = mApnContexts.get(apnType);
        //if (apnContext != null) {
            //DataConnectionAc dcac = apnContext.getDataConnectionAc();
            //if (dcac != null) {
                //if (DBG) log("return link properites for " + apnType);
                //return dcac.getLinkPropertiesSync();
            //}
        //}
        //if (DBG) log("return new LinkProperties");
        //return new LinkProperties();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.598 -0400", hash_original_method = "94651B427B7F42F00ED4B45503EF287D", hash_generated_method = "F594E09AB752C4F06572D6196FEB6A8A")
    @Override
    protected LinkCapabilities getLinkCapabilities(String apnType) {
        LinkCapabilities varB4EAC82CA7396A68D541C85D26508E83_1639413248 = null; //Variable for return #1
        LinkCapabilities varB4EAC82CA7396A68D541C85D26508E83_682887733 = null; //Variable for return #2
        ApnContext apnContext;
        apnContext = mApnContexts.get(apnType);
        {
            DataConnectionAc dataConnectionAc;
            dataConnectionAc = apnContext.getDataConnectionAc();
            {
                log("get active pdp is not null, return link Capabilities for " + apnType);
                varB4EAC82CA7396A68D541C85D26508E83_1639413248 = dataConnectionAc.getLinkCapabilitiesSync();
            } //End block
        } //End block
        log("return new LinkCapabilities");
        varB4EAC82CA7396A68D541C85D26508E83_682887733 = new LinkCapabilities();
        addTaint(apnType.getTaint());
        LinkCapabilities varA7E53CE21691AB073D9660D615818899_1307802112; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1307802112 = varB4EAC82CA7396A68D541C85D26508E83_1639413248;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1307802112 = varB4EAC82CA7396A68D541C85D26508E83_682887733;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1307802112.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1307802112;
        // ---------- Original Method ----------
        //ApnContext apnContext = mApnContexts.get(apnType);
        //if (apnContext!=null) {
            //DataConnectionAc dataConnectionAc = apnContext.getDataConnectionAc();
            //if (dataConnectionAc != null) {
                //if (DBG) log("get active pdp is not null, return link Capabilities for " + apnType);
                //return dataConnectionAc.getLinkCapabilitiesSync();
            //}
        //}
        //if (DBG) log("return new LinkCapabilities");
        //return new LinkCapabilities();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.629 -0400", hash_original_method = "BFF203ED461E9185DBA7A58AF111F0F3", hash_generated_method = "379D9F3D15057BB19013B39044FE91A1")
    @Override
    public String[] getActiveApnTypes() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1729835016 = null; //Variable for return #1
        log("get all active apn types");
        ArrayList<String> result;
        result = new ArrayList<String>();
        {
            Iterator<ApnContext> var9CD107E7BA0F92F9952456E34FCCDBF9_208531245 = (mApnContexts.values()).iterator();
            var9CD107E7BA0F92F9952456E34FCCDBF9_208531245.hasNext();
            ApnContext apnContext = var9CD107E7BA0F92F9952456E34FCCDBF9_208531245.next();
            {
                {
                    boolean varF0467FF71AC99F0BE559C0B01AC11D76_1253380148 = (apnContext.isReady());
                    {
                        result.add(apnContext.getApnType());
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1729835016 = (String[])result.toArray(new String[0]);
        varB4EAC82CA7396A68D541C85D26508E83_1729835016.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1729835016;
        // ---------- Original Method ----------
        //if (DBG) log("get all active apn types");
        //ArrayList<String> result = new ArrayList<String>();
        //for (ApnContext apnContext : mApnContexts.values()) {
            //if (apnContext.isReady()) {
                //result.add(apnContext.getApnType());
            //}
        //}
        //return (String[])result.toArray(new String[0]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.650 -0400", hash_original_method = "8D1CDDA6C04920E256FCAAE007846C5E", hash_generated_method = "4A55771202D068817C74F78B9FB0D4D2")
    @Override
    public String getActiveApnString(String apnType) {
        String varB4EAC82CA7396A68D541C85D26508E83_1947180526 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_324792146 = null; //Variable for return #2
        log( "get active apn string for type:" + apnType);
        ApnContext apnContext;
        apnContext = mApnContexts.get(apnType);
        {
            ApnSetting apnSetting;
            apnSetting = apnContext.getApnSetting();
            {
                varB4EAC82CA7396A68D541C85D26508E83_1947180526 = apnSetting.apn;
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_324792146 = null;
        addTaint(apnType.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1966625894; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1966625894 = varB4EAC82CA7396A68D541C85D26508E83_1947180526;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1966625894 = varB4EAC82CA7396A68D541C85D26508E83_324792146;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1966625894.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1966625894;
        // ---------- Original Method ----------
        //if (DBG) log( "get active apn string for type:" + apnType);
        //ApnContext apnContext = mApnContexts.get(apnType);
        //if (apnContext != null) {
            //ApnSetting apnSetting = apnContext.getApnSetting();
            //if (apnSetting != null) {
                //return apnSetting.apn;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.661 -0400", hash_original_method = "5E11C1BF7F74A775167DAE6DA061B097", hash_generated_method = "9970E954D549E1A73B9579BA48AD7CE7")
    @Override
    public boolean isApnTypeEnabled(String apnType) {
        ApnContext apnContext;
        apnContext = mApnContexts.get(apnType);
        boolean varDFED02B8DB0BBFAE1CF1947E145E6BAC_1779503353 = (apnContext.isEnabled());
        addTaint(apnType.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2030052308 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2030052308;
        // ---------- Original Method ----------
        //ApnContext apnContext = mApnContexts.get(apnType);
        //if (apnContext == null) {
            //return false;
        //}
        //return apnContext.isEnabled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.661 -0400", hash_original_method = "06373F80BD4BEEF603E49D19A1DC6DA1", hash_generated_method = "D7196D73A56AF8FF635A6AA9C0C49BAB")
    @Override
    protected void setState(State s) {
        log("setState should not be used in GSM" + s);
        addTaint(s.getTaint());
        // ---------- Original Method ----------
        //if (DBG) log("setState should not be used in GSM" + s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.662 -0400", hash_original_method = "F24CC52DF36174C789130EC41124E06F", hash_generated_method = "82E50E18BCFE17475EE4A06206969119")
    @Override
    public State getState(String apnType) {
        State varB4EAC82CA7396A68D541C85D26508E83_1877330225 = null; //Variable for return #1
        State varB4EAC82CA7396A68D541C85D26508E83_525543539 = null; //Variable for return #2
        ApnContext apnContext;
        apnContext = mApnContexts.get(apnType);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1877330225 = apnContext.getState();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_525543539 = State.FAILED;
        addTaint(apnType.getTaint());
        State varA7E53CE21691AB073D9660D615818899_264244978; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_264244978 = varB4EAC82CA7396A68D541C85D26508E83_1877330225;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_264244978 = varB4EAC82CA7396A68D541C85D26508E83_525543539;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_264244978.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_264244978;
        // ---------- Original Method ----------
        //ApnContext apnContext = mApnContexts.get(apnType);
        //if (apnContext != null) {
            //return apnContext.getState();
        //}
        //return State.FAILED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.708 -0400", hash_original_method = "3A07E102C7877AE139AF74E35A92CB31", hash_generated_method = "F2CE311FCE20EAD3B3058DE64E9AFBBB")
    public State getOverallState() {
        State varB4EAC82CA7396A68D541C85D26508E83_303013804 = null; //Variable for return #1
        State varB4EAC82CA7396A68D541C85D26508E83_1378757999 = null; //Variable for return #2
        State varB4EAC82CA7396A68D541C85D26508E83_1376231438 = null; //Variable for return #3
        State varB4EAC82CA7396A68D541C85D26508E83_1348430929 = null; //Variable for return #4
        State varB4EAC82CA7396A68D541C85D26508E83_963348903 = null; //Variable for return #5
        boolean isConnecting;
        isConnecting = false;
        boolean isFailed;
        isFailed = true;
        boolean isAnyEnabled;
        isAnyEnabled = false;
        {
            Iterator<ApnContext> var9CD107E7BA0F92F9952456E34FCCDBF9_108573733 = (mApnContexts.values()).iterator();
            var9CD107E7BA0F92F9952456E34FCCDBF9_108573733.hasNext();
            ApnContext apnContext = var9CD107E7BA0F92F9952456E34FCCDBF9_108573733.next();
            {
                {
                    boolean var74352AE28F2089CB53B9CCFDDD397A5B_501832973 = (apnContext.isEnabled());
                    {
                        isAnyEnabled = true;
                        {
                            Object var9700B9CEEDE7EF1C802BA1A530973D22_246962175 = (apnContext.getState());
                            //Begin case CONNECTED DISCONNECTING 
                            log("overall state is CONNECTED");
                            //End case CONNECTED DISCONNECTING 
                            //Begin case CONNECTED DISCONNECTING 
                            varB4EAC82CA7396A68D541C85D26508E83_303013804 = State.CONNECTED;
                            //End case CONNECTED DISCONNECTING 
                            //Begin case CONNECTING INITING 
                            isConnecting = true;
                            //End case CONNECTING INITING 
                            //Begin case CONNECTING INITING 
                            isFailed = false;
                            //End case CONNECTING INITING 
                            //Begin case IDLE SCANNING 
                            isFailed = false;
                            //End case IDLE SCANNING 
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            log( "overall state is IDLE");
            varB4EAC82CA7396A68D541C85D26508E83_1378757999 = State.IDLE;
        } //End block
        {
            log( "overall state is CONNECTING");
            varB4EAC82CA7396A68D541C85D26508E83_1376231438 = State.CONNECTING;
        } //End block
        {
            log( "overall state is IDLE");
            varB4EAC82CA7396A68D541C85D26508E83_1348430929 = State.IDLE;
        } //End block
        {
            log( "overall state is FAILED");
            varB4EAC82CA7396A68D541C85D26508E83_963348903 = State.FAILED;
        } //End block
        State varA7E53CE21691AB073D9660D615818899_1196586891; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1196586891 = varB4EAC82CA7396A68D541C85D26508E83_303013804;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1196586891 = varB4EAC82CA7396A68D541C85D26508E83_1378757999;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1196586891 = varB4EAC82CA7396A68D541C85D26508E83_1376231438;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1196586891 = varB4EAC82CA7396A68D541C85D26508E83_1348430929;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1196586891 = varB4EAC82CA7396A68D541C85D26508E83_963348903;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1196586891.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1196586891;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.715 -0400", hash_original_method = "DED9CF35B00E99A5C3539FDABA142E11", hash_generated_method = "190A39CF7602F4932A2C7E470D44F092")
    @Override
    public synchronized int enableApnType(String apnType) {
        ApnContext apnContext;
        apnContext = mApnContexts.get(apnType);
        {
            boolean var40721DBF76B6A7B6E8BADFF44F346C7D_703146141 = (apnContext == null || !isApnTypeAvailable(apnType));
            {
                log("enableApnType: " + apnType + " is type not available");
            } //End block
        } //End collapsed parenthetic
        log("enableApnType: " + apnType + " mState(" + apnContext.getState() + ")");
        {
            boolean varDB1637033A9F9F6454E8C3CF2D34A73D_908083560 = (apnContext.getState() == State.CONNECTED);
            {
                log("enableApnType: return APN_ALREADY_ACTIVE");
            } //End block
        } //End collapsed parenthetic
        setEnabled(apnTypeToId(apnType), true);
        {
            log("enableApnType: new apn request for type " + apnType +
                    " return APN_REQUEST_STARTED");
        } //End block
        addTaint(apnType.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_512900346 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_512900346;
        // ---------- Original Method ----------
        //ApnContext apnContext = mApnContexts.get(apnType);
        //if (apnContext == null || !isApnTypeAvailable(apnType)) {
            //if (DBG) log("enableApnType: " + apnType + " is type not available");
            //return Phone.APN_TYPE_NOT_AVAILABLE;
        //}
        //if (DBG) log("enableApnType: " + apnType + " mState(" + apnContext.getState() + ")");
        //if (apnContext.getState() == State.CONNECTED) {
            //if (DBG) log("enableApnType: return APN_ALREADY_ACTIVE");
            //return Phone.APN_ALREADY_ACTIVE;
        //}
        //setEnabled(apnTypeToId(apnType), true);
        //if (DBG) {
            //log("enableApnType: new apn request for type " + apnType +
                    //" return APN_REQUEST_STARTED");
        //}
        //return Phone.APN_REQUEST_STARTED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.716 -0400", hash_original_method = "6BE0F7A51104BACC1DFB5733CC5E30CC", hash_generated_method = "5FFCDDEB4A9A1A3E88FD4B26374AA7BD")
    private void notifyApnIdUpToCurrent(String reason, ApnContext apnContext, String type) {
        {
            Object varCC6C8A28F935122C65EE8C4D104696CB_107872546 = (apnContext.getState());
            //Begin case CONNECTING SCANNING 
            mPhone.notifyDataConnection(reason, type, Phone.DataState.CONNECTING);
            //End case CONNECTING SCANNING 
            //Begin case CONNECTED DISCONNECTING 
            mPhone.notifyDataConnection(reason, type, Phone.DataState.CONNECTING);
            //End case CONNECTED DISCONNECTING 
            //Begin case CONNECTED DISCONNECTING 
            mPhone.notifyDataConnection(reason, type, Phone.DataState.CONNECTED);
            //End case CONNECTED DISCONNECTING 
        } //End collapsed parenthetic
        addTaint(reason.getTaint());
        addTaint(apnContext.getTaint());
        addTaint(type.getTaint());
        // ---------- Original Method ----------
        //switch (apnContext.getState()) {
            //case IDLE:
            //case INITING:
                //break;
            //case CONNECTING:
            //case SCANNING:
                //mPhone.notifyDataConnection(reason, type, Phone.DataState.CONNECTING);
                //break;
            //case CONNECTED:
            //case DISCONNECTING:
                //mPhone.notifyDataConnection(reason, type, Phone.DataState.CONNECTING);
                //mPhone.notifyDataConnection(reason, type, Phone.DataState.CONNECTED);
                //break;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.724 -0400", hash_original_method = "68A04474A9A6C009171326D545E43C31", hash_generated_method = "522E287084D72428040625A5A643DE0D")
    @Override
    public synchronized int disableApnType(String type) {
        log("disableApnType:" + type);
        ApnContext apnContext;
        apnContext = mApnContexts.get(type);
        {
            setEnabled(apnTypeToId(type), false);
            {
                boolean var7103B42DD56954FC04F4B2365C64FC7D_1800991183 = (apnContext.getState() != State.IDLE && apnContext.getState() != State.FAILED);
                {
                    log("diableApnType: return APN_REQUEST_STARTED");
                } //End block
                {
                    log("disableApnType: return APN_ALREADY_INACTIVE");
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                log("disableApnType: no apn context was found, return APN_REQUEST_FAILED");
            } //End block
        } //End block
        addTaint(type.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_905512676 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_905512676;
        // ---------- Original Method ----------
        //if (DBG) log("disableApnType:" + type);
        //ApnContext apnContext = mApnContexts.get(type);
        //if (apnContext != null) {
            //setEnabled(apnTypeToId(type), false);
            //if (apnContext.getState() != State.IDLE && apnContext.getState() != State.FAILED) {
                //if (DBG) log("diableApnType: return APN_REQUEST_STARTED");
                //return Phone.APN_REQUEST_STARTED;
            //} else {
                //if (DBG) log("disableApnType: return APN_ALREADY_INACTIVE");
                //return Phone.APN_ALREADY_INACTIVE;
            //}
        //} else {
            //if (DBG) {
                //log("disableApnType: no apn context was found, return APN_REQUEST_FAILED");
            //}
            //return Phone.APN_REQUEST_FAILED;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.757 -0400", hash_original_method = "A26AD8C394281D1D0A1213181383C4F5", hash_generated_method = "EDA854D73183632C491936066B29FBAA")
    @Override
    protected boolean isApnTypeAvailable(String type) {
        {
            boolean var3E24ADAA978C2A1617DE6CE4C1277596_596484050 = (type.equals(Phone.APN_TYPE_DUN) && fetchDunApn() != null);
        } //End collapsed parenthetic
        {
            {
                Iterator<ApnSetting> var02F4BAA28E3266E2CCAC36540E0DBAE4_1856096138 = (mAllApns).iterator();
                var02F4BAA28E3266E2CCAC36540E0DBAE4_1856096138.hasNext();
                ApnSetting apn = var02F4BAA28E3266E2CCAC36540E0DBAE4_1856096138.next();
                {
                    {
                        boolean varCE4968051D63BE091B6671C08AC1461B_1471398998 = (apn.canHandleType(type));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(type.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_686656575 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_686656575;
        // ---------- Original Method ----------
        //if (type.equals(Phone.APN_TYPE_DUN) && fetchDunApn() != null) {
            //return true;
        //}
        //if (mAllApns != null) {
            //for (ApnSetting apn : mAllApns) {
                //if (apn.canHandleType(type)) {
                    //return true;
                //}
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.825 -0400", hash_original_method = "C851438642EDA5AB3134873854010685", hash_generated_method = "BC0390C4ED8C44B4ED18A28F5DFED8DB")
    @Override
    public boolean getAnyDataEnabled() {
        {
            {
                Iterator<ApnContext> var9CD107E7BA0F92F9952456E34FCCDBF9_395225672 = (mApnContexts.values()).iterator();
                var9CD107E7BA0F92F9952456E34FCCDBF9_395225672.hasNext();
                ApnContext apnContext = var9CD107E7BA0F92F9952456E34FCCDBF9_395225672.next();
                {
                    {
                        boolean varD0085CFE2AE3A9FD75A21E639E837206_694889214 = (isDataAllowed(apnContext));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_920960626 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_920960626;
        // ---------- Original Method ----------
        //synchronized (mDataEnabledLock) {
            //if (!(mInternalDataEnabled && mUserDataEnabled && sPolicyDataEnabled)) return false;
            //for (ApnContext apnContext : mApnContexts.values()) {
                //if (isDataAllowed(apnContext)) {
                    //return true;
                //}
            //}
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.825 -0400", hash_original_method = "7A177E6FBAF2829724A437FA44770C6E", hash_generated_method = "474DC4A0449AA81B91796AB6A69668BB")
    private boolean isDataAllowed(ApnContext apnContext) {
        boolean var3F4B19E1911E206B03500C4E7AFD578E_1066035837 = (apnContext.isReady() && isDataAllowed());
        addTaint(apnContext.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1037953492 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1037953492;
        // ---------- Original Method ----------
        //return apnContext.isReady() && isDataAllowed();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.826 -0400", hash_original_method = "DBAD0221F2A53A2AC3E8556324A28A19", hash_generated_method = "70865B629C043E2B67ECAB7D5418421A")
    protected void onDataConnectionDetached() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        log ("onDataConnectionDetached: stop polling and notify detached");
        stopNetStatPoll();
        stopDataStallAlarm();
        notifyDataConnection(Phone.REASON_DATA_DETACHED);
        // ---------- Original Method ----------
        //if (DBG) log ("onDataConnectionDetached: stop polling and notify detached");
        //stopNetStatPoll();
        //stopDataStallAlarm();
        //notifyDataConnection(Phone.REASON_DATA_DETACHED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.826 -0400", hash_original_method = "F401CBF6A4FFFF291696606C3EE2FE85", hash_generated_method = "03AE06F88795827C98F5A375B2E77652")
    private void onDataConnectionAttached() {
        log("onDataConnectionAttached");
        {
            boolean varD6A7948C24B6C2236B4862C980AEEE69_1866082235 = (getOverallState() == State.CONNECTED);
            {
                log("onDataConnectionAttached: start polling notify attached");
                startNetStatPoll();
                startDataStallAlarm();
                notifyDataConnection(Phone.REASON_DATA_ATTACHED);
            } //End block
            {
                notifyOffApnsOfAvailability(Phone.REASON_DATA_ATTACHED);
            } //End block
        } //End collapsed parenthetic
        setupDataOnReadyApns(Phone.REASON_DATA_ATTACHED);
        // ---------- Original Method ----------
        //if (DBG) log("onDataConnectionAttached");
        //if (getOverallState() == State.CONNECTED) {
            //if (DBG) log("onDataConnectionAttached: start polling notify attached");
            //startNetStatPoll();
            //startDataStallAlarm();
            //notifyDataConnection(Phone.REASON_DATA_ATTACHED);
        //} else {
            //notifyOffApnsOfAvailability(Phone.REASON_DATA_ATTACHED);
        //}
        //setupDataOnReadyApns(Phone.REASON_DATA_ATTACHED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.837 -0400", hash_original_method = "000E90D5C33553E8124AA0C75E4D9E4F", hash_generated_method = "478243175995E6E62F3DE8FC6356E15F")
    @Override
    protected boolean isDataAllowed() {
        boolean internalDataEnabled;
        {
            internalDataEnabled = mInternalDataEnabled;
        } //End block
        int gprsState;
        gprsState = mPhone.getServiceStateTracker().getCurrentDataConnectionState();
        boolean desiredPowerState;
        desiredPowerState = mPhone.getServiceStateTracker().getDesiredPowerState();
        boolean allowed;
        allowed = (gprsState == ServiceState.STATE_IN_SERVICE || mAutoAttachOnCreation) &&
                    mPhone.mIccRecords.getRecordsLoaded() &&
                    (mPhone.getState() == Phone.State.IDLE ||
                     mPhone.getServiceStateTracker().isConcurrentVoiceAndDataAllowed()) &&
                    internalDataEnabled &&
                    (!mPhone.getServiceState().getRoaming() || getDataOnRoamingEnabled()) &&
                    !mIsPsRestricted &&
                    desiredPowerState;
        {
            String reason;
            reason = "";
            {
                reason += " - gprs= " + gprsState;
            } //End block
            {
                boolean varF2489385CBDDB7E3A0ACE2F09C15B0F9_355953359 = (!mPhone.mIccRecords.getRecordsLoaded());
                reason += " - SIM not loaded";
            } //End collapsed parenthetic
            {
                boolean var28FCD7715CD53D3D0F5A3AC4104C9F7E_1711298193 = (mPhone.getState() != Phone.State.IDLE &&
                    !mPhone.getServiceStateTracker().isConcurrentVoiceAndDataAllowed());
                {
                    reason += " - PhoneState= " + mPhone.getState();
                    reason += " - Concurrent voice and data not allowed";
                } //End block
            } //End collapsed parenthetic
            reason += " - mInternalDataEnabled= false";
            {
                boolean varA43BAC19CA96DD278C9F67CBBD3CA8CE_2049919604 = (mPhone.getServiceState().getRoaming() && !getDataOnRoamingEnabled());
                {
                    reason += " - Roaming and data roaming not enabled";
                } //End block
            } //End collapsed parenthetic
            reason += " - mIsPsRestricted= true";
            reason += " - desiredPowerState= false";
            log("isDataAllowed: not allowed due to" + reason);
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_805817496 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_805817496;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.910 -0400", hash_original_method = "625A02DD3D04B0C927BA692603CBFCC6", hash_generated_method = "F62BF271F61A49BDA3AB3928CBFFAE79")
    private void setupDataOnReadyApns(String reason) {
        {
            Iterator<DataConnectionAc> varEB8626173DB084FB4853115B28BD3F62_63369400 = (mDataConnectionAsyncChannels.values()).iterator();
            varEB8626173DB084FB4853115B28BD3F62_63369400.hasNext();
            DataConnectionAc dcac = varEB8626173DB084FB4853115B28BD3F62_63369400.next();
            {
                {
                    boolean var9F52EC3EC3AC7E94BDD16A1A7AB208DF_1107589788 = (dcac.getReconnectIntentSync() != null);
                    {
                        cancelReconnectAlarm(dcac);
                    } //End block
                } //End collapsed parenthetic
                {
                    Collection<ApnContext> apns;
                    apns = dcac.getApnListSync();
                    boolean hasDefault;
                    hasDefault = false;
                    {
                        Iterator<ApnContext> varB87ED0964EC6294E1148D70C8996DEB3_729704109 = (apns).iterator();
                        varB87ED0964EC6294E1148D70C8996DEB3_729704109.hasNext();
                        ApnContext apnContext = varB87ED0964EC6294E1148D70C8996DEB3_729704109.next();
                        {
                            {
                                boolean var9434236FBB7E6A998E8474EDA4EA2A94_713114264 = (apnContext.getApnType().equals(Phone.APN_TYPE_DEFAULT));
                                {
                                    hasDefault = true;
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                    configureRetry(dcac.dataConnection, hasDefault);
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            Iterator<ApnContext> var9CD107E7BA0F92F9952456E34FCCDBF9_825144225 = (mApnContexts.values()).iterator();
            var9CD107E7BA0F92F9952456E34FCCDBF9_825144225.hasNext();
            ApnContext apnContext = var9CD107E7BA0F92F9952456E34FCCDBF9_825144225.next();
            {
                {
                    boolean var28727C373B0301059C7D64663A365FCB_573310171 = (apnContext.getState() == State.FAILED);
                    {
                        apnContext.setState(State.IDLE);
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varF0467FF71AC99F0BE559C0B01AC11D76_242108614 = (apnContext.isReady());
                    {
                        {
                            boolean var8AB36F3FADA76FDD70758859DCE39C3A_1314020032 = (apnContext.getState() == State.IDLE);
                            {
                                apnContext.setReason(reason);
                                trySetupData(apnContext);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(reason.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.933 -0400", hash_original_method = "293D247CD6F3CD381680AFA4CF477431", hash_generated_method = "8F4F7228745E389981E18FAE3C167BE1")
    private boolean trySetupData(String reason, String type) {
        {
            log("trySetupData: " + type + " due to " + (reason == null ? "(unspecified)" : reason)
                    + " isPsRestricted=" + mIsPsRestricted);
        } //End block
        {
            type = Phone.APN_TYPE_DEFAULT;
        } //End block
        ApnContext apnContext;
        apnContext = mApnContexts.get(type);
        {
            log("trySetupData new apn context for type:" + type);
            apnContext = new ApnContext(type, LOG_TAG);
            mApnContexts.put(type, apnContext);
        } //End block
        apnContext.setReason(reason);
        boolean varD10E5DDD0548397420B754E479BF3D26_1669127260 = (trySetupData(apnContext));
        addTaint(reason.getTaint());
        addTaint(type.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1383961832 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1383961832;
        // ---------- Original Method ----------
        //if (DBG) {
            //log("trySetupData: " + type + " due to " + (reason == null ? "(unspecified)" : reason)
                    //+ " isPsRestricted=" + mIsPsRestricted);
        //}
        //if (type == null) {
            //type = Phone.APN_TYPE_DEFAULT;
        //}
        //ApnContext apnContext = mApnContexts.get(type);
        //if (apnContext == null ){
            //if (DBG) log("trySetupData new apn context for type:" + type);
            //apnContext = new ApnContext(type, LOG_TAG);
            //mApnContexts.put(type, apnContext);
        //}
        //apnContext.setReason(reason);
        //return trySetupData(apnContext);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.934 -0400", hash_original_method = "01B865917AB0716CB4ECB273F41078C0", hash_generated_method = "202DF068EDBE9290069A16928A36C63E")
    private boolean trySetupData(ApnContext apnContext) {
        {
            log("trySetupData for type:" + apnContext.getApnType() +
                    " due to " + apnContext.getReason());
            log("trySetupData with mIsPsRestricted=" + mIsPsRestricted);
        } //End block
        {
            boolean varA62B422C35237A9A4A0C0A75D57190F8_1540017692 = (mPhone.getSimulatedRadioControl() != null);
            {
                apnContext.setState(State.CONNECTED);
                mPhone.notifyDataConnection(apnContext.getReason(), apnContext.getApnType());
                log("trySetupData: (fix?) We're on the simulator; assuming data is connected");
            } //End block
        } //End collapsed parenthetic
        boolean desiredPowerState;
        desiredPowerState = mPhone.getServiceStateTracker().getDesiredPowerState();
        {
            boolean var5A171EFB50513FF177155112D610371D_1247093274 = ((apnContext.getState() == State.IDLE || apnContext.getState() == State.SCANNING) &&
                isDataAllowed(apnContext) && getAnyDataEnabled() && !isEmergency());
            {
                {
                    boolean varC9E447884E4C233ED7168B30C06B00A1_419858104 = (apnContext.getState() == State.IDLE);
                    {
                        ArrayList<ApnSetting> waitingApns;
                        waitingApns = buildWaitingApns(apnContext.getApnType());
                        {
                            boolean varBC6ECF00D7C0418D64AB187B0B88E0B6_793531659 = (waitingApns.isEmpty());
                            {
                                log("trySetupData: No APN found");
                                notifyNoData(GsmDataConnection.FailCause.MISSING_UNKNOWN_APN, apnContext);
                                notifyOffApnsOfAvailability(apnContext.getReason());
                            } //End block
                            {
                                apnContext.setWaitingApns(waitingApns);
                                {
                                    log ("trySetupData: Create from mAllApns : " + apnListToString(mAllApns));
                                } //End block
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                {
                    log ("Setup watingApns : " + apnListToString(apnContext.getWaitingApns()));
                } //End block
                boolean retValue;
                retValue = setupData(apnContext);
                notifyOffApnsOfAvailability(apnContext.getReason());
            } //End block
            {
                {
                    boolean var6997658875C9EE68C32AF30989EDEC44_1066802894 = (!apnContext.getApnType().equals(Phone.APN_TYPE_DEFAULT)
                && (apnContext.getState() == State.IDLE
                    || apnContext.getState() == State.SCANNING));
                    mPhone.notifyDataConnectionFailed(apnContext.getReason(), apnContext.getApnType());
                } //End collapsed parenthetic
                notifyOffApnsOfAvailability(apnContext.getReason());
            } //End block
        } //End collapsed parenthetic
        addTaint(apnContext.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_155921059 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_155921059;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.965 -0400", hash_original_method = "9CD870BA8C542E1D80FC2F2D725750C0", hash_generated_method = "143CB018A8526EC958556340C99400C8")
    @Override
    protected void notifyOffApnsOfAvailability(String reason) {
        {
            Iterator<ApnContext> var9CD107E7BA0F92F9952456E34FCCDBF9_900101463 = (mApnContexts.values()).iterator();
            var9CD107E7BA0F92F9952456E34FCCDBF9_900101463.hasNext();
            ApnContext apnContext = var9CD107E7BA0F92F9952456E34FCCDBF9_900101463.next();
            {
                {
                    boolean varD681883FCEAD4BAE1DEE9A0AA56202F0_1790405404 = (!apnContext.isReady());
                    {
                        log("notifyOffApnOfAvailability type:" + apnContext.getApnType());
                        mPhone.notifyDataConnection(reason != null ? reason : apnContext.getReason(),
                                            apnContext.getApnType(),
                                            Phone.DataState.DISCONNECTED);
                    } //End block
                    {
                        {
                            log("notifyOffApnsOfAvailability skipped apn due to isReady==false: " +
                            apnContext.toString());
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(reason.getTaint());
        // ---------- Original Method ----------
        //for (ApnContext apnContext : mApnContexts.values()) {
            //if (!apnContext.isReady()) {
                //if (DBG) log("notifyOffApnOfAvailability type:" + apnContext.getApnType());
                //mPhone.notifyDataConnection(reason != null ? reason : apnContext.getReason(),
                                            //apnContext.getApnType(),
                                            //Phone.DataState.DISCONNECTED);
            //} else {
                //if (DBG) {
                    //log("notifyOffApnsOfAvailability skipped apn due to isReady==false: " +
                            //apnContext.toString());
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.019 -0400", hash_original_method = "66E1568E09B68AEC1E9A7CA6629E1BE4", hash_generated_method = "3315930E3B18F890510017C56F8F9E60")
    protected void cleanUpAllConnections(boolean tearDown, String reason) {
        log("cleanUpAllConnections: tearDown=" + tearDown + " reason=" + reason);
        {
            Iterator<ApnContext> var9CD107E7BA0F92F9952456E34FCCDBF9_1799802482 = (mApnContexts.values()).iterator();
            var9CD107E7BA0F92F9952456E34FCCDBF9_1799802482.hasNext();
            ApnContext apnContext = var9CD107E7BA0F92F9952456E34FCCDBF9_1799802482.next();
            {
                apnContext.setReason(reason);
                cleanUpConnection(tearDown, apnContext);
            } //End block
        } //End collapsed parenthetic
        stopNetStatPoll();
        stopDataStallAlarm();
        mRequestedApnType = Phone.APN_TYPE_DEFAULT;
        addTaint(tearDown);
        addTaint(reason.getTaint());
        // ---------- Original Method ----------
        //if (DBG) log("cleanUpAllConnections: tearDown=" + tearDown + " reason=" + reason);
        //for (ApnContext apnContext : mApnContexts.values()) {
            //apnContext.setReason(reason);
            //cleanUpConnection(tearDown, apnContext);
        //}
        //stopNetStatPoll();
        //stopDataStallAlarm();
        //mRequestedApnType = Phone.APN_TYPE_DEFAULT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.019 -0400", hash_original_method = "CD47D8147DAAE254C6F8BD59780442CD", hash_generated_method = "B32904545BB63084247E15D1C5DBBAD1")
    @Override
    protected void onCleanUpAllConnections(String cause) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        cleanUpAllConnections(true, cause);
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
        //cleanUpAllConnections(true, cause);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.020 -0400", hash_original_method = "2562A19804F84494AABD51DA4769B2BA", hash_generated_method = "573CE41ED1E7C02921418F0170553D88")
    private void cleanUpConnection(boolean tearDown, ApnContext apnContext) {
        {
            log("cleanUpConnection: apn context is null");
        } //End block
        {
            log("cleanUpConnection: tearDown=" + tearDown + " reason=" + apnContext.getReason());
        } //End block
        DataConnectionAc dcac;
        dcac = apnContext.getDataConnectionAc();
        {
            {
                boolean varBD1E2AD5899AFE289CE08DB683D4CF33_1184908710 = (apnContext.isDisconnected());
                {
                    apnContext.setState(State.IDLE);
                    {
                        boolean varC29F4942D61E6248F4ED50CF015D5956_2066283190 = (!apnContext.isReady());
                        {
                            apnContext.setDataConnection(null);
                            apnContext.setDataConnectionAc(null);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    {
                        {
                            boolean varA35A04BCD0D81151EFACE0D975BA0673_219646980 = (apnContext.getState() != State.DISCONNECTING);
                            {
                                log("cleanUpConnection: tearing down");
                                Message msg;
                                msg = obtainMessage(EVENT_DISCONNECT_DONE, apnContext);
                                apnContext.getDataConnection().tearDown(apnContext.getReason(), msg);
                                apnContext.setState(State.DISCONNECTING);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        apnContext.setState(State.IDLE);
                        mPhone.notifyDataConnection(apnContext.getReason(),
                                                apnContext.getApnType());
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            dcac.resetSync();
            apnContext.setState(State.IDLE);
            mPhone.notifyDataConnection(apnContext.getReason(), apnContext.getApnType());
            apnContext.setDataConnection(null);
            apnContext.setDataConnectionAc(null);
        } //End block
        {
            Collection<ApnContext> apnList;
            apnList = dcac.getApnListSync();
            {
                boolean var1752AEEE95D46EA2CE0A4ED286F446DA_1455746030 = (apnList.isEmpty());
                {
                    cancelReconnectAlarm(dcac);
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(tearDown);
        addTaint(apnContext.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.021 -0400", hash_original_method = "1F926905027AA18BF39C8A7A893395A9", hash_generated_method = "F264649A3E315339EBF44C1BAB62ADC8")
    private void cancelReconnectAlarm(DataConnectionAc dcac) {
        PendingIntent intent;
        intent = dcac.getReconnectIntentSync();
        {
            AlarmManager am;
            am = (AlarmManager) mPhone.getContext().getSystemService(Context.ALARM_SERVICE);
            am.cancel(intent);
            dcac.setReconnectIntentSync(null);
        } //End block
        addTaint(dcac.getTaint());
        // ---------- Original Method ----------
        //if (dcac == null) return;
        //PendingIntent intent = dcac.getReconnectIntentSync();
        //if (intent != null) {
                //AlarmManager am =
                    //(AlarmManager) mPhone.getContext().getSystemService(Context.ALARM_SERVICE);
                //am.cancel(intent);
                //dcac.setReconnectIntentSync(null);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.021 -0400", hash_original_method = "08930E35848EBECD6CC869C9C6D6B1F8", hash_generated_method = "9F176AFA1FA32DF038B1BB45899CB0EF")
    private String[] parseTypes(String types) {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1723872136 = null; //Variable for return #1
        String[] result;
        {
            boolean var42B66898C7E13316B0BD3608BC7660AE_1561950070 = (types == null || types.equals(""));
            {
                result = new String[1];
                result[0] = Phone.APN_TYPE_ALL;
            } //End block
            {
                result = types.split(",");
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1723872136 = result;
        addTaint(types.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1723872136.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1723872136;
        // ---------- Original Method ----------
        //String[] result;
        //if (types == null || types.equals("")) {
            //result = new String[1];
            //result[0] = Phone.APN_TYPE_ALL;
        //} else {
            //result = types.split(",");
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.040 -0400", hash_original_method = "25E446029D7F780B1E04F89AE12B062D", hash_generated_method = "62BC418B0E5A6862A86E5A6BAA08CBD4")
    private ArrayList<ApnSetting> createApnList(Cursor cursor) {
        ArrayList<ApnSetting> varB4EAC82CA7396A68D541C85D26508E83_2056012663 = null; //Variable for return #1
        ArrayList<ApnSetting> result;
        result = new ArrayList<ApnSetting>();
        {
            boolean var445CF6247CB476E157B6738CE3BD5910_2077455417 = (cursor.moveToFirst());
            {
                {
                    String[] types;
                    types = parseTypes(
                        cursor.getString(cursor.getColumnIndexOrThrow(Telephony.Carriers.TYPE)));
                    ApnSetting apn;
                    apn = new ApnSetting(
                        cursor.getInt(cursor.getColumnIndexOrThrow(Telephony.Carriers._ID)),
                        cursor.getString(cursor.getColumnIndexOrThrow(Telephony.Carriers.NUMERIC)),
                        cursor.getString(cursor.getColumnIndexOrThrow(Telephony.Carriers.NAME)),
                        cursor.getString(cursor.getColumnIndexOrThrow(Telephony.Carriers.APN)),
                        NetworkUtils.trimV4AddrZeros(
                                cursor.getString(
                                cursor.getColumnIndexOrThrow(Telephony.Carriers.PROXY))),
                        cursor.getString(cursor.getColumnIndexOrThrow(Telephony.Carriers.PORT)),
                        NetworkUtils.trimV4AddrZeros(
                                cursor.getString(
                                cursor.getColumnIndexOrThrow(Telephony.Carriers.MMSC))),
                        NetworkUtils.trimV4AddrZeros(
                                cursor.getString(
                                cursor.getColumnIndexOrThrow(Telephony.Carriers.MMSPROXY))),
                        cursor.getString(cursor.getColumnIndexOrThrow(Telephony.Carriers.MMSPORT)),
                        cursor.getString(cursor.getColumnIndexOrThrow(Telephony.Carriers.USER)),
                        cursor.getString(cursor.getColumnIndexOrThrow(Telephony.Carriers.PASSWORD)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(Telephony.Carriers.AUTH_TYPE)),
                        types,
                        cursor.getString(cursor.getColumnIndexOrThrow(Telephony.Carriers.PROTOCOL)),
                        cursor.getString(cursor.getColumnIndexOrThrow(
                                Telephony.Carriers.ROAMING_PROTOCOL)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(
                                Telephony.Carriers.CARRIER_ENABLED)) == 1,
                        cursor.getInt(cursor.getColumnIndexOrThrow(Telephony.Carriers.BEARER)));
                    result.add(apn);
                } //End block
                {
                    boolean var916090E1B2D032E1EC67FFC8B3451FBE_1504130353 = (cursor.moveToNext());
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        log("createApnList: X result=" + result);
        varB4EAC82CA7396A68D541C85D26508E83_2056012663 = result;
        addTaint(cursor.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2056012663.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2056012663;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.199 -0400", hash_original_method = "2E87B4CBA5BF77A80284005F43D6FB91", hash_generated_method = "17E45F78C3E1EE07A35624BE3FE416F5")
    private boolean dataConnectionNotInUse(DataConnectionAc dcac) {
        {
            Iterator<ApnContext> var9CD107E7BA0F92F9952456E34FCCDBF9_1748705361 = (mApnContexts.values()).iterator();
            var9CD107E7BA0F92F9952456E34FCCDBF9_1748705361.hasNext();
            ApnContext apnContext = var9CD107E7BA0F92F9952456E34FCCDBF9_1748705361.next();
            {
                {
                    boolean var9070B85FEFA5513E0174013C4F0F50BF_328290404 = (apnContext.getDataConnectionAc() == dcac);
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(dcac.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1136041975 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1136041975;
        // ---------- Original Method ----------
        //for (ApnContext apnContext : mApnContexts.values()) {
            //if (apnContext.getDataConnectionAc() == dcac) return false;
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.245 -0400", hash_original_method = "871B8246FCDE157C8EBBD019FC69C7EE", hash_generated_method = "B27F9915B19214DC7C63802EAB6F29EF")
    private GsmDataConnection findFreeDataConnection() {
        GsmDataConnection varB4EAC82CA7396A68D541C85D26508E83_324782380 = null; //Variable for return #1
        GsmDataConnection varB4EAC82CA7396A68D541C85D26508E83_1311016051 = null; //Variable for return #2
        {
            Iterator<DataConnectionAc> varEB8626173DB084FB4853115B28BD3F62_1016151281 = (mDataConnectionAsyncChannels.values()).iterator();
            varEB8626173DB084FB4853115B28BD3F62_1016151281.hasNext();
            DataConnectionAc dcac = varEB8626173DB084FB4853115B28BD3F62_1016151281.next();
            {
                {
                    boolean var2573ECF0D7C55708069274523D3C7C3C_526515098 = (dcac.isInactiveSync() && dataConnectionNotInUse(dcac));
                    {
                        log("findFreeDataConnection: found free GsmDataConnection");
                        varB4EAC82CA7396A68D541C85D26508E83_324782380 = (GsmDataConnection) dcac.dataConnection;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        log("findFreeDataConnection: NO free GsmDataConnection");
        varB4EAC82CA7396A68D541C85D26508E83_1311016051 = null;
        GsmDataConnection varA7E53CE21691AB073D9660D615818899_1701429835; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1701429835 = varB4EAC82CA7396A68D541C85D26508E83_324782380;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1701429835 = varB4EAC82CA7396A68D541C85D26508E83_1311016051;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1701429835.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1701429835;
        // ---------- Original Method ----------
        //for (DataConnectionAc dcac : mDataConnectionAsyncChannels.values()) {
            //if (dcac.isInactiveSync() && dataConnectionNotInUse(dcac)) {
                //log("findFreeDataConnection: found free GsmDataConnection");
                //return (GsmDataConnection) dcac.dataConnection;
            //}
        //}
        //log("findFreeDataConnection: NO free GsmDataConnection");
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.326 -0400", hash_original_method = "9845808D61EC26568899ACA30184D52E", hash_generated_method = "3FAA5A515B0F67CCB1D1199EFA2407F1")
    protected GsmDataConnection findReadyDataConnection(ApnSetting apn) {
        GsmDataConnection varB4EAC82CA7396A68D541C85D26508E83_375926217 = null; //Variable for return #1
        GsmDataConnection varB4EAC82CA7396A68D541C85D26508E83_1229178761 = null; //Variable for return #2
        GsmDataConnection varB4EAC82CA7396A68D541C85D26508E83_693462218 = null; //Variable for return #3
        log("findReadyDataConnection: apn string <" +
                (apn!=null?(apn.toString()):"null") +">");
        {
            varB4EAC82CA7396A68D541C85D26508E83_375926217 = null;
        } //End block
        {
            Iterator<DataConnectionAc> varEB8626173DB084FB4853115B28BD3F62_990021339 = (mDataConnectionAsyncChannels.values()).iterator();
            varEB8626173DB084FB4853115B28BD3F62_990021339.hasNext();
            DataConnectionAc dcac = varEB8626173DB084FB4853115B28BD3F62_990021339.next();
            {
                ApnSetting apnSetting;
                apnSetting = dcac.getApnSettingSync();
                {
                    log("findReadyDataConnection: dc apn string <" +
                         (apnSetting != null ? (apnSetting.toString()) : "null") + ">");
                } //End block
                {
                    boolean var546C0C38294DE3324D3082DFC127AE3A_1794547137 = ((apnSetting != null) && TextUtils.equals(apnSetting.toString(), apn.toString()));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1229178761 = (GsmDataConnection) dcac.dataConnection;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_693462218 = null;
        addTaint(apn.getTaint());
        GsmDataConnection varA7E53CE21691AB073D9660D615818899_555108929; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_555108929 = varB4EAC82CA7396A68D541C85D26508E83_375926217;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_555108929 = varB4EAC82CA7396A68D541C85D26508E83_1229178761;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_555108929 = varB4EAC82CA7396A68D541C85D26508E83_693462218;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_555108929.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_555108929;
        // ---------- Original Method ----------
        //if (DBG)
            //log("findReadyDataConnection: apn string <" +
                //(apn!=null?(apn.toString()):"null") +">");
        //if (apn == null) {
            //return null;
        //}
        //for (DataConnectionAc dcac : mDataConnectionAsyncChannels.values()) {
            //ApnSetting apnSetting = dcac.getApnSettingSync();
            //if (DBG) {
                //log("findReadyDataConnection: dc apn string <" +
                         //(apnSetting != null ? (apnSetting.toString()) : "null") + ">");
            //}
            //if ((apnSetting != null) && TextUtils.equals(apnSetting.toString(), apn.toString())) {
                //return (GsmDataConnection) dcac.dataConnection;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.328 -0400", hash_original_method = "BBFF3626F623A28B2260A4B879BEB776", hash_generated_method = "4F44587AA1B81630D588BFB011BF2831")
    private boolean setupData(ApnContext apnContext) {
        log("setupData: apnContext=" + apnContext);
        ApnSetting apn;
        GsmDataConnection dc;
        int profileId;
        profileId = getApnProfileID(apnContext.getApnType());
        apn = apnContext.getNextWaitingApn();
        {
            log("setupData: return for no apn found!");
        } //End block
        dc = (GsmDataConnection)apnContext.getDataConnection();
        {
            dc = (GsmDataConnection) checkForConnectionForApnContext(apnContext);
            {
                dc = findReadyDataConnection(apn);
            } //End block
            {
                log("setupData: No ready GsmDataConnection found!");
                dc = findFreeDataConnection();
            } //End block
            {
                dc = createDataConnection();
            } //End block
            {
                log("setupData: No free GsmDataConnection found!");
            } //End block
            DataConnectionAc dcac;
            dcac = mDataConnectionAsyncChannels.get(dc.getDataConnectionId());
            dc.setProfileId( profileId );
            dc.setActiveApnType(apnContext.getApnType());
            int refCount;
            refCount = dcac.getRefCountSync();
            log("setupData: init dc and apnContext refCount=" + refCount);
            {
                configureRetry(dc, apn.canHandleType(Phone.APN_TYPE_DEFAULT));
            } //End block
            apnContext.setDataConnectionAc(dcac);
            apnContext.setDataConnection(dc);
        } //End block
        apnContext.setApnSetting(apn);
        apnContext.setState(State.INITING);
        mPhone.notifyDataConnection(apnContext.getReason(), apnContext.getApnType());
        {
            boolean varC4178D8C99BD7F6792B45CFB3EEFE060_385163612 = (apnContext.getDataConnectionAc().getReconnectIntentSync() != null);
            {
                log("setupData: data reconnection pending");
                apnContext.setState(State.FAILED);
                mPhone.notifyDataConnection(apnContext.getReason(), apnContext.getApnType());
            } //End block
        } //End collapsed parenthetic
        Message msg;
        msg = obtainMessage();
        msg.what = EVENT_DATA_SETUP_COMPLETE;
        msg.obj = apnContext;
        dc.bringUp(msg, apn);
        log("setupData: initing!");
        addTaint(apnContext.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1153835593 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1153835593;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.329 -0400", hash_original_method = "651F557B6A8D0D165E9CDD4391DC0D13", hash_generated_method = "B17DB31BD0DFCE8674F02B068963A0E4")
    private void onApnChanged() {
        State overallState;
        overallState = getOverallState();
        boolean isDisconnected;
        isDisconnected = (overallState == State.IDLE || overallState == State.FAILED);
        {
            ((GSMPhone)mPhone).updateCurrentCarrierInProvider();
        } //End block
        log("onApnChanged: createAllApnList and cleanUpAllConnections");
        createAllApnList();
        cleanUpAllConnections(!isDisconnected, Phone.REASON_APN_CHANGED);
        {
            setupDataOnReadyApns(Phone.REASON_APN_CHANGED);
        } //End block
        // ---------- Original Method ----------
        //State overallState = getOverallState();
        //boolean isDisconnected = (overallState == State.IDLE || overallState == State.FAILED);
        //if (mPhone instanceof GSMPhone) {
            //((GSMPhone)mPhone).updateCurrentCarrierInProvider();
        //}
        //if (DBG) log("onApnChanged: createAllApnList and cleanUpAllConnections");
        //createAllApnList();
        //cleanUpAllConnections(!isDisconnected, Phone.REASON_APN_CHANGED);
        //if (isDisconnected) {
            //setupDataOnReadyApns(Phone.REASON_APN_CHANGED);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.375 -0400", hash_original_method = "65E72951AE41561D32861B862A9CCB8A", hash_generated_method = "1C6721DB1A119B2764089E78764E93EC")
    private DataConnectionAc findDataConnectionAcByCid(int cid) {
        DataConnectionAc varB4EAC82CA7396A68D541C85D26508E83_1533030541 = null; //Variable for return #1
        DataConnectionAc varB4EAC82CA7396A68D541C85D26508E83_498838319 = null; //Variable for return #2
        {
            Iterator<DataConnectionAc> varEB8626173DB084FB4853115B28BD3F62_460504006 = (mDataConnectionAsyncChannels.values()).iterator();
            varEB8626173DB084FB4853115B28BD3F62_460504006.hasNext();
            DataConnectionAc dcac = varEB8626173DB084FB4853115B28BD3F62_460504006.next();
            {
                {
                    boolean var44AE56803E65C65A63242637F17A76CE_1266751996 = (dcac.getCidSync() == cid);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1533030541 = dcac;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_498838319 = null;
        addTaint(cid);
        DataConnectionAc varA7E53CE21691AB073D9660D615818899_967576912; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_967576912 = varB4EAC82CA7396A68D541C85D26508E83_1533030541;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_967576912 = varB4EAC82CA7396A68D541C85D26508E83_498838319;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_967576912.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_967576912;
        // ---------- Original Method ----------
        //for (DataConnectionAc dcac : mDataConnectionAsyncChannels.values()) {
            //if (dcac.getCidSync() == cid) {
                //return dcac;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.462 -0400", hash_original_method = "3E391A4D32CF36E6E02EF7EB45223170", hash_generated_method = "89AB16C254E1CB1C0D2FC620A239E2AD")
    private List<ApnContext> findApnContextToClean(Collection<DataConnectionAc> dcacs) {
        List<ApnContext> varB4EAC82CA7396A68D541C85D26508E83_398170300 = null; //Variable for return #1
        List<ApnContext> varB4EAC82CA7396A68D541C85D26508E83_697336588 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_398170300 = null;
        ArrayList<ApnContext> list;
        list = new ArrayList<ApnContext>();
        {
            Iterator<ApnContext> var9CD107E7BA0F92F9952456E34FCCDBF9_486738482 = (mApnContexts.values()).iterator();
            var9CD107E7BA0F92F9952456E34FCCDBF9_486738482.hasNext();
            ApnContext apnContext = var9CD107E7BA0F92F9952456E34FCCDBF9_486738482.next();
            {
                {
                    boolean varE485268814C4AFB5EDDFB3001575EFDB_2070449247 = (apnContext.getState() == State.CONNECTED);
                    {
                        boolean found;
                        found = false;
                        {
                            Iterator<DataConnectionAc> varD36661AE30AFDBEDE4E14981910E8874_1078404962 = (dcacs).iterator();
                            varD36661AE30AFDBEDE4E14981910E8874_1078404962.hasNext();
                            DataConnectionAc dcac = varD36661AE30AFDBEDE4E14981910E8874_1078404962.next();
                            {
                                {
                                    boolean var0D1B2614B8B112ED60682FB66D70B775_1427262683 = (dcac == apnContext.getDataConnectionAc());
                                    {
                                        found = true;
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                        {
                            log("onDataStateChanged(ar): Connected apn not found in the list (" +
                                 apnContext.toString() + ")");
                            {
                                boolean var365CFE2CF50045A315EC59FCB108BE3D_2055616592 = (apnContext.getDataConnectionAc() != null);
                                {
                                    list.addAll(apnContext.getDataConnectionAc().getApnListSync());
                                } //End block
                                {
                                    list.add(apnContext);
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_697336588 = list;
        addTaint(dcacs.getTaint());
        List<ApnContext> varA7E53CE21691AB073D9660D615818899_1118472405; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1118472405 = varB4EAC82CA7396A68D541C85D26508E83_398170300;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1118472405 = varB4EAC82CA7396A68D541C85D26508E83_697336588;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1118472405.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1118472405;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.662 -0400", hash_original_method = "2CAD8F6019A6EE1B4B77B4750A278A68", hash_generated_method = "76E01911C5077AEDE3CBABA3A8280DDA")
    private void onDataStateChanged(AsyncResult ar) {
        ArrayList<DataCallState> dataCallStates;
        log("onDataStateChanged(ar): E");
        dataCallStates = (ArrayList<DataCallState>)(ar.result);
        {
            log("onDataStateChanged(ar): exception; likely radio not available, ignore");
        } //End block
        log("onDataStateChanged(ar): DataCallState size=" + dataCallStates.size());
        HashMap<DataCallState, DataConnectionAc> dataCallStateToDcac;
        dataCallStateToDcac = new HashMap<DataCallState, DataConnectionAc>();
        {
            Iterator<DataCallState> var890D5D9F35AC8194E211B756D8B449D5_1681684761 = (dataCallStates).iterator();
            var890D5D9F35AC8194E211B756D8B449D5_1681684761.hasNext();
            DataCallState dataCallState = var890D5D9F35AC8194E211B756D8B449D5_1681684761.next();
            {
                DataConnectionAc dcac;
                dcac = findDataConnectionAcByCid(dataCallState.cid);
                dataCallStateToDcac.put(dataCallState, dcac);
            } //End block
        } //End collapsed parenthetic
        List<ApnContext> apnsToCleanup;
        apnsToCleanup = findApnContextToClean(dataCallStateToDcac.values());
        {
            Iterator<DataCallState> varBAD99AA6F7F24D65A5EC2CF095E57993_135815555 = (dataCallStates).iterator();
            varBAD99AA6F7F24D65A5EC2CF095E57993_135815555.hasNext();
            DataCallState newState = varBAD99AA6F7F24D65A5EC2CF095E57993_135815555.next();
            {
                DataConnectionAc dcac;
                dcac = dataCallStateToDcac.get(newState);
                {
                    loge("onDataStateChanged(ar): No associated DataConnection ignore");
                } //End block
                Collection<ApnContext> apns;
                apns = dcac.getApnListSync();
                ArrayList<ApnContext> connectedApns;
                connectedApns = new ArrayList<ApnContext>();
                {
                    Iterator<ApnContext> varB87ED0964EC6294E1148D70C8996DEB3_1112548595 = (apns).iterator();
                    varB87ED0964EC6294E1148D70C8996DEB3_1112548595.hasNext();
                    ApnContext apnContext = varB87ED0964EC6294E1148D70C8996DEB3_1112548595.next();
                    {
                        {
                            boolean var7D51A9C3981F8C57F447F4E083C1733A_41946574 = (apnContext.getState() == State.CONNECTED ||
                       apnContext.getState() == State.CONNECTING ||
                       apnContext.getState() == State.INITING);
                            {
                                connectedApns.add(apnContext);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var5000E345BB413FFA3E31E234111713FF_550560576 = (connectedApns.size() == 0);
                    {
                        log("onDataStateChanged(ar): no connected apns");
                    } //End block
                    {
                        log("onDataStateChanged(ar): Found ConnId=" + newState.cid
                        + " newState=" + newState.toString());
                        {
                            {
                                log("onDataStateChanged(ar): inactive, cleanup apns=" + connectedApns);
                            } //End block
                            apnsToCleanup.addAll(connectedApns);
                        } //End block
                        {
                            UpdateLinkPropertyResult result;
                            result = dcac.updateLinkPropertiesDataCallStateSync(newState);
                            {
                                boolean var1B3E4D2CD1EAEB2455EA2C214D755032_140411735 = (result.oldLp.equals(result.newLp));
                                {
                                    log("onDataStateChanged(ar): no change");
                                } //End block
                                {
                                    {
                                        boolean var74AB4D1C511598866AA9D48139B76D67_785530969 = (result.oldLp.isIdenticalInterfaceName(result.newLp));
                                        {
                                            {
                                                boolean var7DF81F5C5F07963E97224562298FE75A_839037008 = (! result.oldLp.isIdenticalDnses(result.newLp) ||
                                    ! result.oldLp.isIdenticalRoutes(result.newLp) ||
                                    ! result.oldLp.isIdenticalHttpProxy(result.newLp) ||
                                    ! result.oldLp.isIdenticalAddresses(result.newLp));
                                                {
                                                    CompareResult<LinkAddress> car;
                                                    car = result.oldLp.compareAddresses(result.newLp);
                                                    boolean needToClean;
                                                    needToClean = false;
                                                    {
                                                        Iterator<LinkAddress> var23B27F8B5241376F0116E88BAF37B0B8_2044679194 = (car.added).iterator();
                                                        var23B27F8B5241376F0116E88BAF37B0B8_2044679194.hasNext();
                                                        LinkAddress added = var23B27F8B5241376F0116E88BAF37B0B8_2044679194.next();
                                                        {
                                                            {
                                                                Iterator<LinkAddress> var7F421F3A918E0DA72CB36906036E82ED_1577922425 = (car.removed).iterator();
                                                                var7F421F3A918E0DA72CB36906036E82ED_1577922425.hasNext();
                                                                LinkAddress removed = var7F421F3A918E0DA72CB36906036E82ED_1577922425.next();
                                                                {
                                                                    {
                                                                        boolean varB57B56F1E352D523157536C76D64F31A_613572265 = (NetworkUtils.addressTypeMatches(removed.getAddress(),
                                                added.getAddress()));
                                                                        {
                                                                            needToClean = true;
                                                                        } //End block
                                                                    } //End collapsed parenthetic
                                                                } //End block
                                                            } //End collapsed parenthetic
                                                        } //End block
                                                    } //End collapsed parenthetic
                                                    {
                                                        {
                                                            log("onDataStateChanged(ar): addr change, cleanup apns=" +
                                                connectedApns);
                                                        } //End block
                                                        apnsToCleanup.addAll(connectedApns);
                                                    } //End block
                                                    {
                                                        log("onDataStateChanged(ar): simple change");
                                                        {
                                                            Iterator<ApnContext> varFEC3827E0AA5748C7AEE84D60E555D44_581391841 = (connectedApns).iterator();
                                                            varFEC3827E0AA5748C7AEE84D60E555D44_581391841.hasNext();
                                                            ApnContext apnContext = varFEC3827E0AA5748C7AEE84D60E555D44_581391841.next();
                                                            {
                                                                mPhone.notifyDataConnection(
                                                 Phone.REASON_LINK_PROPERTIES_CHANGED,
                                                 apnContext.getApnType());
                                                            } //End block
                                                        } //End collapsed parenthetic
                                                    } //End block
                                                } //End block
                                                {
                                                    {
                                                        log("onDataStateChanged(ar): no changes");
                                                    } //End block
                                                } //End block
                                            } //End collapsed parenthetic
                                        } //End block
                                        {
                                            {
                                                log("onDataStateChanged(ar): interface change, cleanup apns="
                                        + connectedApns);
                                            } //End block
                                            apnsToCleanup.addAll(connectedApns);
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean varAC8520286CDD2B23D82BD3D80BB8D83D_840426858 = (apnsToCleanup.size() != 0);
            {
                int cid;
                cid = getCellLocationId();
                EventLog.writeEvent(EventLogTags.PDP_NETWORK_DROP, cid,
                                TelephonyManager.getDefault().getNetworkType());
            } //End block
        } //End collapsed parenthetic
        {
            Iterator<ApnContext> varAED058FB30F7183EC8FD798F4A2CC59E_1761453240 = (apnsToCleanup).iterator();
            varAED058FB30F7183EC8FD798F4A2CC59E_1761453240.hasNext();
            ApnContext apnContext = varAED058FB30F7183EC8FD798F4A2CC59E_1761453240.next();
            {
                cleanUpConnection(true, apnContext);
            } //End block
        } //End collapsed parenthetic
        log("onDataStateChanged(ar): X");
        addTaint(ar.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.667 -0400", hash_original_method = "66B167D0E0A206B2D44C874F7CFFABF5", hash_generated_method = "E754477CAFCADBA28851A1BEE702C056")
    private void notifyDefaultData(ApnContext apnContext) {
        {
            log("notifyDefaultData: type=" + apnContext.getApnType()
                + ", reason:" + apnContext.getReason());
        } //End block
        apnContext.setState(State.CONNECTED);
        mPhone.notifyDataConnection(apnContext.getReason(), apnContext.getApnType());
        startNetStatPoll();
        startDataStallAlarm();
        apnContext.getDataConnection().resetRetryCount();
        addTaint(apnContext.getTaint());
        // ---------- Original Method ----------
        //if (DBG) {
            //log("notifyDefaultData: type=" + apnContext.getApnType()
                //+ ", reason:" + apnContext.getReason());
        //}
        //apnContext.setState(State.CONNECTED);
        //mPhone.notifyDataConnection(apnContext.getReason(), apnContext.getApnType());
        //startNetStatPoll();
        //startDataStallAlarm();
        //apnContext.getDataConnection().resetRetryCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.668 -0400", hash_original_method = "06C0A537C422D51FEBC3A4D7FED033FC", hash_generated_method = "F73C2E1491460D3AF533DA0A4AD08E62")
    protected void gotoIdleAndNotifyDataConnection(String reason) {
        log("gotoIdleAndNotifyDataConnection: reason=" + reason);
        notifyDataConnection(reason);
        mActiveApn = null;
        addTaint(reason.getTaint());
        // ---------- Original Method ----------
        //if (DBG) log("gotoIdleAndNotifyDataConnection: reason=" + reason);
        //notifyDataConnection(reason);
        //mActiveApn = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.672 -0400", hash_original_method = "E0A0A9601ED58F14AFBBF23896E64411", hash_generated_method = "B15AEEE94D49A3A4F6A6C846243A9553")
    private void resetPollStats() {
        mTxPkts = -1;
        mRxPkts = -1;
        mNetStatPollPeriod = POLL_NETSTAT_MILLIS;
        // ---------- Original Method ----------
        //mTxPkts = -1;
        //mRxPkts = -1;
        //mNetStatPollPeriod = POLL_NETSTAT_MILLIS;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.690 -0400", hash_original_method = "85BF013ED3EA874C77BCE8B69E224FC2", hash_generated_method = "F391DBF2A06BEE435AC1078545AA5ECC")
    private void doRecovery() {
        {
            boolean varD6A7948C24B6C2236B4862C980AEEE69_590908942 = (getOverallState() == State.CONNECTED);
            {
                int recoveryAction;
                recoveryAction = getRecoveryAction();
                //Begin case RecoveryAction.GET_DATA_CALL_LIST 
                EventLog.writeEvent(EventLogTags.DATA_STALL_RECOVERY_GET_DATA_CALL_LIST,
                        mSentSinceLastRecv);
                //End case RecoveryAction.GET_DATA_CALL_LIST 
                //Begin case RecoveryAction.GET_DATA_CALL_LIST 
                log("doRecovery() get data call list");
                //End case RecoveryAction.GET_DATA_CALL_LIST 
                //Begin case RecoveryAction.GET_DATA_CALL_LIST 
                mPhone.mCM.getDataCallList(obtainMessage(EVENT_DATA_STATE_CHANGED));
                //End case RecoveryAction.GET_DATA_CALL_LIST 
                //Begin case RecoveryAction.GET_DATA_CALL_LIST 
                putRecoveryAction(RecoveryAction.CLEANUP);
                //End case RecoveryAction.GET_DATA_CALL_LIST 
                //Begin case RecoveryAction.CLEANUP 
                EventLog.writeEvent(EventLogTags.DATA_STALL_RECOVERY_CLEANUP, mSentSinceLastRecv);
                //End case RecoveryAction.CLEANUP 
                //Begin case RecoveryAction.CLEANUP 
                log("doRecovery() cleanup all connections");
                //End case RecoveryAction.CLEANUP 
                //Begin case RecoveryAction.CLEANUP 
                cleanUpAllConnections(true, Phone.REASON_PDP_RESET);
                //End case RecoveryAction.CLEANUP 
                //Begin case RecoveryAction.CLEANUP 
                putRecoveryAction(RecoveryAction.REREGISTER);
                //End case RecoveryAction.CLEANUP 
                //Begin case RecoveryAction.REREGISTER 
                EventLog.writeEvent(EventLogTags.DATA_STALL_RECOVERY_REREGISTER,
                        mSentSinceLastRecv);
                //End case RecoveryAction.REREGISTER 
                //Begin case RecoveryAction.REREGISTER 
                log("doRecovery() re-register");
                //End case RecoveryAction.REREGISTER 
                //Begin case RecoveryAction.REREGISTER 
                mPhone.getServiceStateTracker().reRegisterNetwork(null);
                //End case RecoveryAction.REREGISTER 
                //Begin case RecoveryAction.REREGISTER 
                putRecoveryAction(RecoveryAction.RADIO_RESTART);
                //End case RecoveryAction.REREGISTER 
                //Begin case RecoveryAction.RADIO_RESTART 
                EventLog.writeEvent(EventLogTags.DATA_STALL_RECOVERY_RADIO_RESTART,
                        mSentSinceLastRecv);
                //End case RecoveryAction.RADIO_RESTART 
                //Begin case RecoveryAction.RADIO_RESTART 
                log("restarting radio");
                //End case RecoveryAction.RADIO_RESTART 
                //Begin case RecoveryAction.RADIO_RESTART 
                putRecoveryAction(RecoveryAction.RADIO_RESTART_WITH_PROP);
                //End case RecoveryAction.RADIO_RESTART 
                //Begin case RecoveryAction.RADIO_RESTART 
                restartRadio();
                //End case RecoveryAction.RADIO_RESTART 
                //Begin case RecoveryAction.RADIO_RESTART_WITH_PROP 
                EventLog.writeEvent(EventLogTags.DATA_STALL_RECOVERY_RADIO_RESTART_WITH_PROP, -1);
                //End case RecoveryAction.RADIO_RESTART_WITH_PROP 
                //Begin case RecoveryAction.RADIO_RESTART_WITH_PROP 
                log("restarting radio with gsm.radioreset to true");
                //End case RecoveryAction.RADIO_RESTART_WITH_PROP 
                //Begin case RecoveryAction.RADIO_RESTART_WITH_PROP 
                SystemProperties.set("gsm.radioreset", "true");
                //End case RecoveryAction.RADIO_RESTART_WITH_PROP 
                //Begin case RecoveryAction.RADIO_RESTART_WITH_PROP 
                try 
                {
                    Thread.sleep(1000);
                } //End block
                catch (InterruptedException e)
                { }
                //End case RecoveryAction.RADIO_RESTART_WITH_PROP 
                //Begin case RecoveryAction.RADIO_RESTART_WITH_PROP 
                restartRadio();
                //End case RecoveryAction.RADIO_RESTART_WITH_PROP 
                //Begin case RecoveryAction.RADIO_RESTART_WITH_PROP 
                putRecoveryAction(RecoveryAction.GET_DATA_CALL_LIST);
                //End case RecoveryAction.RADIO_RESTART_WITH_PROP 
                //Begin case default 
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException("doRecovery: Invalid recoveryAction=" +
                    recoveryAction);
                //End case default 
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.691 -0400", hash_original_method = "6E590AA3974E9F6C1EEF78A59E60FE7C", hash_generated_method = "4D42D2C703A02F9C80C4C39ABD6E810A")
    @Override
    protected void startNetStatPoll() {
        {
            boolean var4E0798726B6E95AA9A651DC17C8A16FD_670275583 = (getOverallState() == State.CONNECTED && mNetStatPollEnabled == false);
            {
                log("startNetStatPoll");
                resetPollStats();
                mNetStatPollEnabled = true;
                mPollNetStat.run();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (getOverallState() == State.CONNECTED && mNetStatPollEnabled == false) {
            //if (DBG) log("startNetStatPoll");
            //resetPollStats();
            //mNetStatPollEnabled = true;
            //mPollNetStat.run();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.691 -0400", hash_original_method = "A8EA63C8FD8E985352F3B26222CD114C", hash_generated_method = "95EAC4FD2FEFFA5C54BF4D45F2043A3F")
    @Override
    protected void stopNetStatPoll() {
        mNetStatPollEnabled = false;
        removeCallbacks(mPollNetStat);
        log("stopNetStatPoll");
        // ---------- Original Method ----------
        //mNetStatPollEnabled = false;
        //removeCallbacks(mPollNetStat);
        //if (DBG) log("stopNetStatPoll");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.699 -0400", hash_original_method = "7B64E8A50E5FAE405E2B8EDB2C4EA1BE", hash_generated_method = "BD1853EBBC82788F1B29C0451ECD6E7A")
    @Override
    protected void restartRadio() {
        log("restartRadio: ************TURN OFF RADIO**************");
        cleanUpAllConnections(true, Phone.REASON_RADIO_TURNED_OFF);
        mPhone.getServiceStateTracker().powerOffRadioSafely(this);
        int reset;
        reset = Integer.parseInt(SystemProperties.get("net.ppp.reset-by-timeout", "0"));
        SystemProperties.set("net.ppp.reset-by-timeout", String.valueOf(reset+1));
        // ---------- Original Method ----------
        //if (DBG) log("restartRadio: ************TURN OFF RADIO**************");
        //cleanUpAllConnections(true, Phone.REASON_RADIO_TURNED_OFF);
        //mPhone.getServiceStateTracker().powerOffRadioSafely(this);
        //int reset = Integer.parseInt(SystemProperties.get("net.ppp.reset-by-timeout", "0"));
        //SystemProperties.set("net.ppp.reset-by-timeout", String.valueOf(reset+1));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.700 -0400", hash_original_method = "757A180615AA792B2C29A1B55C4F521C", hash_generated_method = "1F1B4EB498DA4DBCC264F6A22CC33CB4")
    private void updateDataStallInfo() {
        long sent, received;
        TxRxSum preTxRxSum;
        preTxRxSum = new TxRxSum(mDataStallTxRxSum);
        mDataStallTxRxSum.updateTxRxSum();
        {
            log("updateDataStallInfo: mDataStallTxRxSum=" + mDataStallTxRxSum +
                    " preTxRxSum=" + preTxRxSum);
        } //End block
        sent = mDataStallTxRxSum.txPkts - preTxRxSum.txPkts;
        received = mDataStallTxRxSum.rxPkts - preTxRxSum.rxPkts;
        {
            {
                boolean var7C0CC8ECFFCEF537CCFB463FE517A260_1002817829 = (SystemProperties.getBoolean("radio.test.data.stall", false));
                {
                    log("updateDataStallInfo: radio.test.data.stall true received = 0;");
                    received = 0;
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            log("updateDataStallInfo: IN/OUT");
            mSentSinceLastRecv = 0;
            putRecoveryAction(RecoveryAction.GET_DATA_CALL_LIST);
        } //End block
        {
            {
                boolean varC70CC77B08458828B44DBD70EF60D18F_1917665722 = (mPhone.getState() == Phone.State.IDLE);
                {
                    mSentSinceLastRecv += sent;
                } //End block
                {
                    mSentSinceLastRecv = 0;
                } //End block
            } //End collapsed parenthetic
            {
                log("updateDataStallInfo: OUT sent=" + sent +
                        " mSentSinceLastRecv=" + mSentSinceLastRecv);
            } //End block
        } //End block
        {
            log("updateDataStallInfo: IN");
            mSentSinceLastRecv = 0;
            putRecoveryAction(RecoveryAction.GET_DATA_CALL_LIST);
        } //End block
        {
            log("updateDataStallInfo: NONE");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.702 -0400", hash_original_method = "81664D2568F01996EC1331372DE6C46E", hash_generated_method = "7BB9BB05E41656C795102850BEDEC8DA")
    @Override
    protected void onDataStallAlarm(int tag) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            {
                log("onDataStallAlarm: ignore, tag=" + tag + " expecting " + mDataStallAlarmTag);
            } //End block
        } //End block
        updateDataStallInfo();
        int hangWatchdogTrigger;
        hangWatchdogTrigger = Settings.Secure.getInt(mResolver,
                Settings.Secure.PDP_WATCHDOG_TRIGGER_PACKET_COUNT,
                NUMBER_SENT_PACKETS_OF_HANG);
        {
            {
                log("onDataStallAlarm: tag=" + tag + " do recovery action=" + getRecoveryAction());
            } //End block
            sendMessage(obtainMessage(EVENT_DO_RECOVERY));
        } //End block
        {
            {
                log("onDataStallAlarm: tag=" + tag + " Sent " + String.valueOf(mSentSinceLastRecv) +
                    " pkts since last received, < watchdogTrigger=" + hangWatchdogTrigger);
            } //End block
        } //End block
        startDataStallAlarm();
        addTaint(tag);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.715 -0400", hash_original_method = "94396473B615B857A09FF1389DF39C19", hash_generated_method = "1CCF070327F8D3EA84700E3C17DB300B")
    private void updateDataActivity() {
        long sent, received;
        Activity newActivity;
        TxRxSum preTxRxSum;
        preTxRxSum = new TxRxSum(mTxPkts, mRxPkts);
        TxRxSum curTxRxSum;
        curTxRxSum = new TxRxSum();
        curTxRxSum.updateTxRxSum();
        mTxPkts = curTxRxSum.txPkts;
        mRxPkts = curTxRxSum.rxPkts;
        {
            log("updateDataActivity: curTxRxSum=" + curTxRxSum + " preTxRxSum=" + preTxRxSum);
        } //End block
        {
            sent = mTxPkts - preTxRxSum.txPkts;
            received = mRxPkts - preTxRxSum.rxPkts;
            log("updateDataActivity: sent=" + sent + " received=" + received);
            {
                newActivity = Activity.DATAINANDOUT;
            } //End block
            {
                newActivity = Activity.DATAOUT;
            } //End block
            {
                newActivity = Activity.DATAIN;
            } //End block
            {
                newActivity = Activity.NONE;
            } //End block
            {
                log("updateDataActivity: newActivity=" + newActivity);
                mActivity = newActivity;
                mPhone.notifyDataActivity();
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.716 -0400", hash_original_method = "2F0F0316C5E4D930E75010F1BAA9D392", hash_generated_method = "AEC83EB1028C9285BCE0131F75CBB755")
    private boolean shouldPostNotification(GsmDataConnection.FailCause  cause) {
        addTaint(cause.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_103590158 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_103590158;
        // ---------- Original Method ----------
        //return (cause != GsmDataConnection.FailCause.UNKNOWN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.717 -0400", hash_original_method = "62A24BB1F647222AA978F8E837B2D330", hash_generated_method = "63F8A329DDB510465F5B25B5BFAE0E84")
    private boolean retryAfterDisconnected(String reason) {
        boolean retry;
        retry = true;
        {
            boolean var3CB82CF3031EDB1F7F9E067EE7B1B74E_1558897384 = (Phone.REASON_RADIO_TURNED_OFF.equals(reason));
            {
                retry = false;
            } //End block
        } //End collapsed parenthetic
        addTaint(reason.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_128414401 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_128414401;
        // ---------- Original Method ----------
        //boolean retry = true;
        //if ( Phone.REASON_RADIO_TURNED_OFF.equals(reason) ) {
            //retry = false;
        //}
        //return retry;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.731 -0400", hash_original_method = "B5DAD52C5259D76162A701D0CC3F0E5D", hash_generated_method = "C54E583B5EFC8B47F28342D223518690")
    private void reconnectAfterFail(FailCause lastFailCauseCode,
                                    ApnContext apnContext, int retryOverride) {
        {
            loge("reconnectAfterFail: apnContext == null, impossible");
        } //End block
        {
            boolean var30FA7C33083B1EC6F834026AE8058702_882908177 = ((apnContext.getState() == State.FAILED) &&
            (apnContext.getDataConnection() != null));
            {
                {
                    boolean varE5EB462BBE8443D160BD1FB45CF7935B_1474985494 = (!apnContext.getDataConnection().isRetryNeeded());
                    {
                        {
                            boolean var922F49E2215CF7A16F73F26F0F3737B6_222041783 = (!apnContext.getApnType().equals(Phone.APN_TYPE_DEFAULT));
                            {
                                mPhone.notifyDataConnection(Phone.REASON_APN_FAILED, apnContext.getApnType());
                            } //End block
                        } //End collapsed parenthetic
                        {
                            apnContext.getDataConnection().retryForeverUsingLastTimeout();
                        } //End block
                        {
                            log("reconnectAfterFail: activate failed, Reregistering to network");
                            mReregisterOnReconnectFailure = true;
                            mPhone.getServiceStateTracker().reRegisterNetwork(null);
                            apnContext.getDataConnection().resetRetryCount();
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                int nextReconnectDelay;
                nextReconnectDelay = retryOverride;
                {
                    nextReconnectDelay = apnContext.getDataConnection().getRetryTimer();
                    apnContext.getDataConnection().increaseRetryCount();
                } //End block
                startAlarmForReconnect(nextReconnectDelay, apnContext);
                {
                    boolean var2A1839E9F3FAB784CE5EE5D4D0AE0D4B_246627620 = (!shouldPostNotification(lastFailCauseCode));
                    {
                        {
                            log("reconnectAfterFail: NOT Posting GPRS Unavailable notification "
                                + "-- likely transient error");
                        } //End block
                    } //End block
                    {
                        notifyNoData(lastFailCauseCode, apnContext);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(lastFailCauseCode.getTaint());
        addTaint(apnContext.getTaint());
        addTaint(retryOverride);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.732 -0400", hash_original_method = "68704E7FD0A79E29C0B17E36042D228F", hash_generated_method = "FCD6AEEB904243BADD81FFDA3C7AC91A")
    private void startAlarmForReconnect(int delay, ApnContext apnContext) {
        {
            log("Schedule alarm for reconnect: activate failed. Scheduling next attempt for "
                + (delay / 1000) + "s");
        } //End block
        DataConnectionAc dcac;
        dcac = apnContext.getDataConnectionAc();
        {
            loge("null dcac or dc.");
        } //End block
        AlarmManager am;
        am = (AlarmManager) mPhone.getContext().getSystemService(Context.ALARM_SERVICE);
        Intent intent;
        intent = new Intent(INTENT_RECONNECT_ALARM + '.' +
                                   dcac.dataConnection.getDataConnectionId());
        intent.putExtra(INTENT_RECONNECT_ALARM_EXTRA_REASON, apnContext.getReason());
        intent.putExtra(INTENT_RECONNECT_ALARM_EXTRA_TYPE,
                        dcac.dataConnection.getDataConnectionId());
        PendingIntent alarmIntent;
        alarmIntent = PendingIntent.getBroadcast (mPhone.getContext(), 0,
                                                                intent, 0);
        dcac.setReconnectIntentSync(alarmIntent);
        am.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                SystemClock.elapsedRealtime() + delay, alarmIntent);
        addTaint(delay);
        addTaint(apnContext.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.732 -0400", hash_original_method = "752A3E1271AADAA161C9D22B1F08D3F3", hash_generated_method = "33761A70156AD50B166531289CBCB7E2")
    private void startDataStallAlarm() {
        int delayInMs;
        delayInMs = Settings.Secure.getInt(mResolver,
                            Settings.Secure.DATA_STALL_ALARM_DELAY_IN_MS,
                            DATA_STALL_ALARM_DELAY_IN_MS_DEFAULT);
        mDataStallAlarmTag += 1;
        {
            log("startDataStallAlarm: tag=" + mDataStallAlarmTag +
                    " delay=" + (delayInMs / 1000) + "s");
        } //End block
        AlarmManager am;
        am = (AlarmManager) mPhone.getContext().getSystemService(Context.ALARM_SERVICE);
        Intent intent;
        intent = new Intent(INTENT_DATA_STALL_ALARM);
        intent.putExtra(DATA_STALL_ALARM_TAG_EXTRA, mDataStallAlarmTag);
        mDataStallAlarmIntent = PendingIntent.getBroadcast(mPhone.getContext(), 0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        am.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                SystemClock.elapsedRealtime() + delayInMs, mDataStallAlarmIntent);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.733 -0400", hash_original_method = "9BAB3B8D9CDA09D3CE76C98C24705EFE", hash_generated_method = "0EF7F8AC5CED26584D6762E5790D8AD3")
    private void stopDataStallAlarm() {
        AlarmManager am;
        am = (AlarmManager) mPhone.getContext().getSystemService(Context.ALARM_SERVICE);
        {
            log("stopDataStallAlarm: current tag=" + mDataStallAlarmTag +
                    " mDataStallAlarmIntent=" + mDataStallAlarmIntent);
        } //End block
        mDataStallAlarmTag += 1;
        {
            am.cancel(mDataStallAlarmIntent);
            mDataStallAlarmIntent = null;
        } //End block
        // ---------- Original Method ----------
        //AlarmManager am =
            //(AlarmManager) mPhone.getContext().getSystemService(Context.ALARM_SERVICE);
        //if (DBG) {
            //log("stopDataStallAlarm: current tag=" + mDataStallAlarmTag +
                    //" mDataStallAlarmIntent=" + mDataStallAlarmIntent);
        //}
        //mDataStallAlarmTag += 1;
        //if (mDataStallAlarmIntent != null) {
            //am.cancel(mDataStallAlarmIntent);
            //mDataStallAlarmIntent = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.734 -0400", hash_original_method = "B7B20E847D290047FDFE77B8D734C484", hash_generated_method = "7F6FC2E0C74F30FE0A12D3474496D284")
    private void notifyNoData(GsmDataConnection.FailCause lastFailCauseCode,
                              ApnContext apnContext) {
        log( "notifyNoData: type=" + apnContext.getApnType());
        apnContext.setState(State.FAILED);
        {
            boolean var4EEBF6159081CCB6B98E337119003EE1_70227542 = (lastFailCauseCode.isPermanentFail()
            && (!apnContext.getApnType().equals(Phone.APN_TYPE_DEFAULT)));
            {
                mPhone.notifyDataConnectionFailed(apnContext.getReason(), apnContext.getApnType());
            } //End block
        } //End collapsed parenthetic
        addTaint(lastFailCauseCode.getTaint());
        addTaint(apnContext.getTaint());
        // ---------- Original Method ----------
        //if (DBG) log( "notifyNoData: type=" + apnContext.getApnType());
        //apnContext.setState(State.FAILED);
        //if (lastFailCauseCode.isPermanentFail()
            //&& (!apnContext.getApnType().equals(Phone.APN_TYPE_DEFAULT))) {
            //mPhone.notifyDataConnectionFailed(apnContext.getReason(), apnContext.getApnType());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.746 -0400", hash_original_method = "E0D6F2F660096B71ECF89DBFFFD7E4A9", hash_generated_method = "97C548092C5BAA19F518268162AB5357")
    private void onRecordsLoaded() {
        log("onRecordsLoaded: createAllApnList");
        createAllApnList();
        {
            boolean varBF6B2CF5258A9CC53BF3EF6E8D75A257_1836933012 = (mPhone.mCM.getRadioState().isOn());
            {
                log("onRecordsLoaded: notifying data availability");
                notifyOffApnsOfAvailability(Phone.REASON_SIM_LOADED);
            } //End block
        } //End collapsed parenthetic
        setupDataOnReadyApns(Phone.REASON_SIM_LOADED);
        // ---------- Original Method ----------
        //if (DBG) log("onRecordsLoaded: createAllApnList");
        //createAllApnList();
        //if (mPhone.mCM.getRadioState().isOn()) {
            //if (DBG) log("onRecordsLoaded: notifying data availability");
            //notifyOffApnsOfAvailability(Phone.REASON_SIM_LOADED);
        //}
        //setupDataOnReadyApns(Phone.REASON_SIM_LOADED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.747 -0400", hash_original_method = "4B71314721E8EC7414109EE47221FD04", hash_generated_method = "1DBC443AB10EBA6D59C2D79356928CBB")
    @Override
    protected void onSetDependencyMet(String apnType, boolean met) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var26625207EA129FA6C81C0427CE84CA93_912291548 = (Phone.APN_TYPE_HIPRI.equals(apnType));
        } //End collapsed parenthetic
        ApnContext apnContext;
        apnContext = mApnContexts.get(apnType);
        {
            loge("onSetDependencyMet: ApnContext not found in onSetDependencyMet(" +
                    apnType + ", " + met + ")");
        } //End block
        applyNewState(apnContext, apnContext.isEnabled(), met);
        {
            boolean var9DC01820B4CF39C526DE14A3F8F65164_741345996 = (Phone.APN_TYPE_DEFAULT.equals(apnType));
            {
                apnContext = mApnContexts.get(Phone.APN_TYPE_HIPRI);
                applyNewState(apnContext, apnContext.isEnabled(), met);
            } //End block
        } //End collapsed parenthetic
        addTaint(apnType.getTaint());
        addTaint(met);
        // ---------- Original Method ----------
        //if (Phone.APN_TYPE_HIPRI.equals(apnType)) return;
        //ApnContext apnContext = mApnContexts.get(apnType);
        //if (apnContext == null) {
            //loge("onSetDependencyMet: ApnContext not found in onSetDependencyMet(" +
                    //apnType + ", " + met + ")");
            //return;
        //}
        //applyNewState(apnContext, apnContext.isEnabled(), met);
        //if (Phone.APN_TYPE_DEFAULT.equals(apnType)) {
            //apnContext = mApnContexts.get(Phone.APN_TYPE_HIPRI);
            //if (apnContext != null) applyNewState(apnContext, apnContext.isEnabled(), met);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.756 -0400", hash_original_method = "99E85476A8EB35B364BDD45037DA3C4C", hash_generated_method = "A4BD45F46D90CA54123E66116BFD4E9F")
    private void applyNewState(ApnContext apnContext, boolean enabled, boolean met) {
        boolean cleanup;
        cleanup = false;
        boolean trySetup;
        trySetup = false;
        {
            log("applyNewState(" + apnContext.getApnType() + ", " + enabled +
                    "(" + apnContext.isEnabled() + "), " + met + "(" +
                    apnContext.getDependencyMet() +"))");
        } //End block
        {
            boolean var71D7772E371594A9E183FDA441CA7053_665616416 = (apnContext.isReady());
            {
                {
                    apnContext.setReason(Phone.REASON_DATA_DISABLED);
                } //End block
                {
                    apnContext.setReason(Phone.REASON_DATA_DEPENDENCY_UNMET);
                } //End block
                cleanup = true;
            } //End block
            {
                {
                    {
                        boolean varD838083F139117E3D29CE4817418915A_2027576886 = (apnContext.isEnabled());
                        {
                            apnContext.setReason(Phone.REASON_DATA_DEPENDENCY_MET);
                        } //End block
                        {
                            apnContext.setReason(Phone.REASON_DATA_ENABLED);
                        } //End block
                    } //End collapsed parenthetic
                    {
                        boolean var8C3F5A245E8CD46D727CA60CA79AEBA0_1601067758 = (apnContext.getState() == State.FAILED);
                        {
                            apnContext.setState(State.IDLE);
                        } //End block
                    } //End collapsed parenthetic
                    trySetup = true;
                } //End block
            } //End block
        } //End collapsed parenthetic
        apnContext.setEnabled(enabled);
        apnContext.setDependencyMet(met);
        cleanUpConnection(true, apnContext);
        trySetupData(apnContext);
        addTaint(apnContext.getTaint());
        addTaint(enabled);
        addTaint(met);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.911 -0400", hash_original_method = "CD0E8AA9DA59D5F15CB3DBA9C10480A3", hash_generated_method = "6F87ACF4C0AEA7767FCB4926BB8565E1")
    private DataConnection checkForConnectionForApnContext(ApnContext apnContext) {
        DataConnection varB4EAC82CA7396A68D541C85D26508E83_983684461 = null; //Variable for return #1
        DataConnection varB4EAC82CA7396A68D541C85D26508E83_1923212008 = null; //Variable for return #2
        DataConnection varB4EAC82CA7396A68D541C85D26508E83_69460458 = null; //Variable for return #3
        String apnType;
        apnType = apnContext.getApnType();
        ApnSetting dunSetting;
        dunSetting = null;
        {
            boolean var733FD876202A992F48D44A26A7FD0196_1392233163 = (Phone.APN_TYPE_DUN.equals(apnType));
            {
                dunSetting = fetchDunApn();
            } //End block
        } //End collapsed parenthetic
        {
            Iterator<ApnContext> var6DC0F8F93D4890C09FB88A4F42664788_620927476 = (mApnContexts.values()).iterator();
            var6DC0F8F93D4890C09FB88A4F42664788_620927476.hasNext();
            ApnContext c = var6DC0F8F93D4890C09FB88A4F42664788_620927476.next();
            {
                DataConnection conn;
                conn = c.getDataConnection();
                {
                    ApnSetting apnSetting;
                    apnSetting = c.getApnSetting();
                    {
                        {
                            boolean var8C1D5273F63F2A795463E07E2AA32767_767633705 = (dunSetting.equals(apnSetting));
                            {
                                {
                                    log("checkForConnectionForApnContext: apnContext=" + apnContext +
                                    " found conn=" + conn);
                                } //End block
                                varB4EAC82CA7396A68D541C85D26508E83_983684461 = conn;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        boolean var9D1B5F46420F9179EBDCA60D125A22B4_812517983 = (apnSetting != null && apnSetting.canHandleType(apnType));
                        {
                            {
                                log("checkForConnectionForApnContext: apnContext=" + apnContext +
                                " found conn=" + conn);
                            } //End block
                            varB4EAC82CA7396A68D541C85D26508E83_1923212008 = conn;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End collapsed parenthetic
        log("checkForConnectionForApnContext: apnContext=" + apnContext + " NO conn");
        varB4EAC82CA7396A68D541C85D26508E83_69460458 = null;
        addTaint(apnContext.getTaint());
        DataConnection varA7E53CE21691AB073D9660D615818899_1656543442; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1656543442 = varB4EAC82CA7396A68D541C85D26508E83_983684461;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1656543442 = varB4EAC82CA7396A68D541C85D26508E83_1923212008;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1656543442 = varB4EAC82CA7396A68D541C85D26508E83_69460458;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1656543442.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1656543442;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.912 -0400", hash_original_method = "C4FAA9463FB18AA2956D630E0A7A0FC4", hash_generated_method = "A81CFD5081E5A8A97540E1ADD281B035")
    @Override
    protected void onEnableApn(int apnId, int enabled) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        ApnContext apnContext;
        apnContext = mApnContexts.get(apnIdToType(apnId));
        {
            loge("onEnableApn(" + apnId + ", " + enabled + "): NO ApnContext");
        } //End block
        log("onEnableApn: apnContext=" + apnContext + " call applyNewState");
        applyNewState(apnContext, enabled == ENABLED, apnContext.getDependencyMet());
        addTaint(apnId);
        addTaint(enabled);
        // ---------- Original Method ----------
        //ApnContext apnContext = mApnContexts.get(apnIdToType(apnId));
        //if (apnContext == null) {
            //loge("onEnableApn(" + apnId + ", " + enabled + "): NO ApnContext");
            //return;
        //}
        //if (DBG) log("onEnableApn: apnContext=" + apnContext + " call applyNewState");
        //applyNewState(apnContext, enabled == ENABLED, apnContext.getDependencyMet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.913 -0400", hash_original_method = "885166865223FFC382706A95C40269FC", hash_generated_method = "976EAD1793DFB0D22BDFD63037B99AE3")
    @Override
    protected boolean onTrySetupData(String reason) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        log("onTrySetupData: reason=" + reason);
        setupDataOnReadyApns(reason);
        addTaint(reason.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_679327401 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_679327401;
        // ---------- Original Method ----------
        //if (DBG) log("onTrySetupData: reason=" + reason);
        //setupDataOnReadyApns(reason);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.913 -0400", hash_original_method = "0F081CC5E381F07585D5A8591D9B8176", hash_generated_method = "AB0E3D121F602B29A485E83F5AFA6944")
    protected boolean onTrySetupData(ApnContext apnContext) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        log("onTrySetupData: apnContext=" + apnContext);
        boolean varD10E5DDD0548397420B754E479BF3D26_173603962 = (trySetupData(apnContext));
        addTaint(apnContext.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_948658487 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_948658487;
        // ---------- Original Method ----------
        //if (DBG) log("onTrySetupData: apnContext=" + apnContext);
        //return trySetupData(apnContext);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.913 -0400", hash_original_method = "94279F194E7EEE60FDEB34DD3123F420", hash_generated_method = "7FC7514BF494EEF83E04D82C65BDFAFF")
    @Override
    protected void onRoamingOff() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        log("onRoamingOff");
        {
            boolean var6A4EDF3FAFEE8B58E0E885094E7C645E_599822066 = (getDataOnRoamingEnabled() == false);
            {
                notifyOffApnsOfAvailability(Phone.REASON_ROAMING_OFF);
                setupDataOnReadyApns(Phone.REASON_ROAMING_OFF);
            } //End block
            {
                notifyDataConnection(Phone.REASON_ROAMING_OFF);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (DBG) log("onRoamingOff");
        //if (getDataOnRoamingEnabled() == false) {
            //notifyOffApnsOfAvailability(Phone.REASON_ROAMING_OFF);
            //setupDataOnReadyApns(Phone.REASON_ROAMING_OFF);
        //} else {
            //notifyDataConnection(Phone.REASON_ROAMING_OFF);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.914 -0400", hash_original_method = "F695F1E8C2AB53D2ED55D91C043A1972", hash_generated_method = "390FE594A9028DC21DA16618B1EA855D")
    @Override
    protected void onRoamingOn() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var178FD459AA12B1549B96EFDE7D504A27_605829618 = (getDataOnRoamingEnabled());
            {
                log("onRoamingOn: setup data on roaming");
                setupDataOnReadyApns(Phone.REASON_ROAMING_ON);
                notifyDataConnection(Phone.REASON_ROAMING_ON);
            } //End block
            {
                log("onRoamingOn: Tear down data connection on roaming.");
                cleanUpAllConnections(true, Phone.REASON_ROAMING_ON);
                notifyOffApnsOfAvailability(Phone.REASON_ROAMING_ON);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (getDataOnRoamingEnabled()) {
            //if (DBG) log("onRoamingOn: setup data on roaming");
            //setupDataOnReadyApns(Phone.REASON_ROAMING_ON);
            //notifyDataConnection(Phone.REASON_ROAMING_ON);
        //} else {
            //if (DBG) log("onRoamingOn: Tear down data connection on roaming.");
            //cleanUpAllConnections(true, Phone.REASON_ROAMING_ON);
            //notifyOffApnsOfAvailability(Phone.REASON_ROAMING_ON);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.914 -0400", hash_original_method = "2023A2D13D03549C0A5EFF7393A0A72A", hash_generated_method = "D001D856B45912BB4AD98E03C0D4D94F")
    @Override
    protected void onRadioAvailable() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        log("onRadioAvailable");
        {
            boolean varA62B422C35237A9A4A0C0A75D57190F8_899447540 = (mPhone.getSimulatedRadioControl() != null);
            {
                notifyDataConnection(null);
                log("onRadioAvailable: We're on the simulator; assuming data is connected");
            } //End block
        } //End collapsed parenthetic
        {
            boolean varBF0727A83B7DC3B32BB422410729B3B0_2101744809 = (mPhone.mIccRecords.getRecordsLoaded());
            {
                notifyOffApnsOfAvailability(null);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var7B94654969E16A4794216154E8FB917C_1482639008 = (getOverallState() != State.IDLE);
            {
                cleanUpConnection(true, null);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (DBG) log("onRadioAvailable");
        //if (mPhone.getSimulatedRadioControl() != null) {
            //notifyDataConnection(null);
            //log("onRadioAvailable: We're on the simulator; assuming data is connected");
        //}
        //if (mPhone.mIccRecords.getRecordsLoaded()) {
            //notifyOffApnsOfAvailability(null);
        //}
        //if (getOverallState() != State.IDLE) {
            //cleanUpConnection(true, null);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:24.990 -0400", hash_original_method = "3A8D622B44F84A55C5B45212A617D18F", hash_generated_method = "3EE723F1817D4FBCB0C3AC86681C5C68")
    @Override
    protected void onRadioOffOrNotAvailable() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            Iterator<DataConnection> var8D54139306CE59DA2A79305B93065ACC_973622950 = (mDataConnections.values()).iterator();
            var8D54139306CE59DA2A79305B93065ACC_973622950.hasNext();
            DataConnection dc = var8D54139306CE59DA2A79305B93065ACC_973622950.next();
            {
                dc.resetRetryCount();
            } //End block
        } //End collapsed parenthetic
        mReregisterOnReconnectFailure = false;
        {
            boolean varA62B422C35237A9A4A0C0A75D57190F8_1351048906 = (mPhone.getSimulatedRadioControl() != null);
            {
                log("We're on the simulator; assuming radio off is meaningless");
            } //End block
            {
                log("onRadioOffOrNotAvailable: is off and clean up all connections");
                cleanUpAllConnections(false, Phone.REASON_RADIO_TURNED_OFF);
            } //End block
        } //End collapsed parenthetic
        notifyOffApnsOfAvailability(null);
        // ---------- Original Method ----------
        //for (DataConnection dc : mDataConnections.values()) {
            //dc.resetRetryCount();
        //}
        //mReregisterOnReconnectFailure = false;
        //if (mPhone.getSimulatedRadioControl() != null) {
            //log("We're on the simulator; assuming radio off is meaningless");
        //} else {
            //if (DBG) log("onRadioOffOrNotAvailable: is off and clean up all connections");
            //cleanUpAllConnections(false, Phone.REASON_RADIO_TURNED_OFF);
        //}
        //notifyOffApnsOfAvailability(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.000 -0400", hash_original_method = "31196134743B1AB9B97F59AB7F4DD6B0", hash_generated_method = "94ABF3D8CCFBEFDB8472C7B07F274645")
    @Override
    protected void onDataSetupComplete(AsyncResult ar) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        ApnContext apnContext;
        apnContext = null;
        {
            apnContext = (ApnContext)ar.userObj;
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("onDataSetupComplete: No apnContext");
        } //End block
        {
            boolean varB5E9B7D9BBFA45BCF027FCB550EA1FBB_2041995004 = (isDataSetupCompleteOk(ar));
            {
                DataConnectionAc dcac;
                dcac = apnContext.getDataConnectionAc();
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException("onDataSetupCompete: No dcac");
                } //End block
                DataConnection dc;
                dc = apnContext.getDataConnection();
                {
                    String apnStr;
                    apnStr = "<unknown>";
                    {
                        boolean var42EF12F4CB67FC41B1F91CE3324F0C03_1345432992 = (apnContext.getWaitingApns() != null
                        && !apnContext.getWaitingApns().isEmpty());
                        {
                            apnStr = apnContext.getWaitingApns().get(0).apn;
                        } //End block
                    } //End collapsed parenthetic
                    log("onDataSetupComplete: success apn=" + apnStr);
                } //End block
                ApnSetting apn;
                apn = apnContext.getApnSetting();
                {
                    boolean var00FF597132A341DE3BF2E746162A900F_1801004529 = (apn.proxy != null && apn.proxy.length() != 0);
                    {
                        try 
                        {
                            String port;
                            port = apn.port;
                            {
                                boolean var043EAD4723AA14ECD7762C02F18E1A34_1402653129 = (TextUtils.isEmpty(port));
                                port = "8080";
                            } //End collapsed parenthetic
                            ProxyProperties proxy;
                            proxy = new ProxyProperties(apn.proxy,
                            Integer.parseInt(port), null);
                            dcac.setLinkPropertiesHttpProxySync(proxy);
                        } //End block
                        catch (NumberFormatException e)
                        {
                            loge("onDataSetupComplete: NumberFormatException making ProxyProperties (" +
                            apn.port + "): " + e);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varEC69DD651013C51F6ACA2A20413C3B78_657416981 = (TextUtils.equals(apnContext.getApnType(),Phone.APN_TYPE_DEFAULT));
                    {
                        SystemProperties.set("gsm.defaultpdpcontext.active", "true");
                        {
                            log("onDataSetupComplete: PREFERED APN is null");
                            mPreferredApn = apnContext.getApnSetting();
                            {
                                setPreferredApn(mPreferredApn.id);
                            } //End block
                        } //End block
                    } //End block
                    {
                        SystemProperties.set("gsm.defaultpdpcontext.active", "false");
                    } //End block
                } //End collapsed parenthetic
                notifyDefaultData(apnContext);
            } //End block
            {
                String apnString;
                DataConnection.FailCause cause;
                cause = (DataConnection.FailCause) (ar.result);
                {
                    try 
                    {
                        apnString = apnContext.getWaitingApns().get(0).apn;
                    } //End block
                    catch (Exception e)
                    {
                        apnString = "<unknown>";
                    } //End block
                    log(String.format("onDataSetupComplete: error apn=%s cause=%s", apnString, cause));
                } //End block
                {
                    boolean var70C8C044708A6E33F44340F8299B6975_123304846 = (cause.isEventLoggable());
                    {
                        int cid;
                        cid = getCellLocationId();
                        EventLog.writeEvent(EventLogTags.PDP_SETUP_FAIL,
                        cause.ordinal(), cid, TelephonyManager.getDefault().getNetworkType());
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var66182ADBA155CABC56AA3975E9DBF19F_358262387 = (cause.isPermanentFail());
                    apnContext.decWaitingApnsPermFailCount();
                } //End collapsed parenthetic
                apnContext.removeNextWaitingApn();
                {
                    log(String.format("onDataSetupComplete: WaitingApns.size=%d" +
                        " WaitingApnsPermFailureCountDown=%d",
                        apnContext.getWaitingApns().size(),
                        apnContext.getWaitingApnsPermFailCount()));
                } //End block
                {
                    boolean varAE862190C9752AEFC117247928D51FE4_1185897998 = (apnContext.getWaitingApns().isEmpty());
                    {
                        {
                            boolean varEEED2F76BD3397C488FB9DFF0EAF6871_2032929714 = (apnContext.getWaitingApnsPermFailCount() == 0);
                            {
                                {
                                    log("onDataSetupComplete: All APN's had permanent failures, stop retrying");
                                } //End block
                                apnContext.setState(State.FAILED);
                                mPhone.notifyDataConnection(Phone.REASON_APN_FAILED, apnContext.getApnType());
                                apnContext.setDataConnection(null);
                                apnContext.setDataConnectionAc(null);
                                {
                                    log("onDataSetupComplete: permanent error apn=%s" + apnString );
                                } //End block
                            } //End block
                            {
                                log("onDataSetupComplete: Not all permanent failures, retry");
                                int retryOverride;
                                retryOverride = -1;
                                {
                                    retryOverride =
                            ((DataConnection.CallSetupException)ar.exception).getRetryOverride();
                                } //End block
                                {
                                    log("No retry is suggested.");
                                } //End block
                                {
                                    startDelayedRetry(cause, apnContext, retryOverride);
                                } //End block
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        log("onDataSetupComplete: Try next APN");
                        apnContext.setState(State.SCANNING);
                        startAlarmForReconnect(APN_DELAY_MILLIS, apnContext);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(ar.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.015 -0400", hash_original_method = "D4180B029AFCA66C11673889FF654292", hash_generated_method = "C38C8D892ECF201F48C445A008235E94")
    @Override
    protected void onDisconnectDone(int connId, AsyncResult ar) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        ApnContext apnContext;
        apnContext = null;
        log("onDisconnectDone: EVENT_DISCONNECT_DONE connId=" + connId);
        {
            apnContext = (ApnContext) ar.userObj;
        } //End block
        {
            loge("Invalid ar in onDisconnectDone");
        } //End block
        apnContext.setState(State.IDLE);
        mPhone.notifyDataConnection(apnContext.getReason(), apnContext.getApnType());
        {
            boolean var786CBED095C8588B57078CC7EF2AF454_2088960719 = (isDisconnected());
            {
                {
                    boolean var846205B09CBBB48260D2ACA57A03090A_843925343 = (mPhone.getServiceStateTracker().processPendingRadioPowerOffAfterDataOff());
                    {
                        apnContext.setApnSetting(null);
                        apnContext.setDataConnection(null);
                        apnContext.setDataConnectionAc(null);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean var8F8F15CFAD1D995C4B76EF8FCB948AA5_747585782 = (apnContext.isReady() && retryAfterDisconnected(apnContext.getReason()));
            {
                SystemProperties.set("gsm.defaultpdpcontext.active", "false");
                startAlarmForReconnect(APN_DELAY_MILLIS, apnContext);
            } //End block
            {
                apnContext.setApnSetting(null);
                apnContext.setDataConnection(null);
                apnContext.setDataConnectionAc(null);
            } //End block
        } //End collapsed parenthetic
        addTaint(connId);
        addTaint(ar.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.015 -0400", hash_original_method = "F62EA026E4AEAA1F320C05AA5A1ED4A9", hash_generated_method = "9F8B438D273558C3CCA97CC5E1A148AD")
    protected void onPollPdp() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean varD6A7948C24B6C2236B4862C980AEEE69_930215696 = (getOverallState() == State.CONNECTED);
            {
                mPhone.mCM.getDataCallList(this.obtainMessage(EVENT_DATA_STATE_CHANGED));
                sendMessageDelayed(obtainMessage(EVENT_POLL_PDP), POLL_PDP_MILLIS);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (getOverallState() == State.CONNECTED) {
            //mPhone.mCM.getDataCallList(this.obtainMessage(EVENT_DATA_STATE_CHANGED));
            //sendMessageDelayed(obtainMessage(EVENT_POLL_PDP), POLL_PDP_MILLIS);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.016 -0400", hash_original_method = "7D6F87E7A2D5372F8DAAC4AE4D373312", hash_generated_method = "91FA461EB4BDEB6A4D4D92C5E015C6D8")
    @Override
    protected void onVoiceCallStarted() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        log("onVoiceCallStarted");
        {
            boolean var457C185A27A25C3794C4F48127E1858B_1405768240 = (isConnected() && ! mPhone.getServiceStateTracker().isConcurrentVoiceAndDataAllowed());
            {
                log("onVoiceCallStarted stop polling");
                stopNetStatPoll();
                stopDataStallAlarm();
                notifyDataConnection(Phone.REASON_VOICE_CALL_STARTED);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (DBG) log("onVoiceCallStarted");
        //if (isConnected() && ! mPhone.getServiceStateTracker().isConcurrentVoiceAndDataAllowed()) {
            //if (DBG) log("onVoiceCallStarted stop polling");
            //stopNetStatPoll();
            //stopDataStallAlarm();
            //notifyDataConnection(Phone.REASON_VOICE_CALL_STARTED);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.016 -0400", hash_original_method = "F668A2FA6E26D3D907651D9C8494921A", hash_generated_method = "AD0F1DD23176E7B70A8FC96E4CFB526B")
    @Override
    protected void onVoiceCallEnded() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        log("onVoiceCallEnded");
        {
            boolean var5153987C55DB41759ADC1D7527E9459D_1052015160 = (isConnected());
            {
                {
                    boolean var52415700B3EB5881C35C2B7439253DD7_1495879239 = (!mPhone.getServiceStateTracker().isConcurrentVoiceAndDataAllowed());
                    {
                        startNetStatPoll();
                        startDataStallAlarm();
                        notifyDataConnection(Phone.REASON_VOICE_CALL_ENDED);
                    } //End block
                    {
                        resetPollStats();
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                setupDataOnReadyApns(Phone.REASON_VOICE_CALL_ENDED);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (DBG) log("onVoiceCallEnded");
        //if (isConnected()) {
            //if (!mPhone.getServiceStateTracker().isConcurrentVoiceAndDataAllowed()) {
                //startNetStatPoll();
                //startDataStallAlarm();
                //notifyDataConnection(Phone.REASON_VOICE_CALL_ENDED);
            //} else {
                //resetPollStats();
            //}
        //} else {
            //setupDataOnReadyApns(Phone.REASON_VOICE_CALL_ENDED);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.020 -0400", hash_original_method = "2BB2576C993A3562ED602CBB829AED3C", hash_generated_method = "0774FF41DB2BE8F15A006E56ED416AB8")
    @Override
    protected void onCleanUpConnection(boolean tearDown, int apnId, String reason) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        log("onCleanUpConnection");
        ApnContext apnContext;
        apnContext = mApnContexts.get(apnIdToType(apnId));
        {
            apnContext.setReason(reason);
            cleanUpConnection(tearDown, apnContext);
        } //End block
        addTaint(tearDown);
        addTaint(apnId);
        addTaint(reason.getTaint());
        // ---------- Original Method ----------
        //if (DBG) log("onCleanUpConnection");
        //ApnContext apnContext = mApnContexts.get(apnIdToType(apnId));
        //if (apnContext != null) {
            //apnContext.setReason(reason);
            //cleanUpConnection(tearDown, apnContext);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.087 -0400", hash_original_method = "F3A5D3BC82C41DBBBC23CC041FBF5A0E", hash_generated_method = "C2F4AE0AF179A033B355F937161F2656")
    protected boolean isConnected() {
        {
            Iterator<ApnContext> var9CD107E7BA0F92F9952456E34FCCDBF9_1757302714 = (mApnContexts.values()).iterator();
            var9CD107E7BA0F92F9952456E34FCCDBF9_1757302714.hasNext();
            ApnContext apnContext = var9CD107E7BA0F92F9952456E34FCCDBF9_1757302714.next();
            {
                {
                    boolean varE485268814C4AFB5EDDFB3001575EFDB_1555386142 = (apnContext.getState() == State.CONNECTED);
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1550135673 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1550135673;
        // ---------- Original Method ----------
        //for (ApnContext apnContext : mApnContexts.values()) {
            //if (apnContext.getState() == State.CONNECTED) {
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.126 -0400", hash_original_method = "82B1D5E02818D0100BE3FB5300291D89", hash_generated_method = "BDA4B611E686F387B94300CF51E96023")
    @Override
    public boolean isDisconnected() {
        {
            Iterator<ApnContext> var9CD107E7BA0F92F9952456E34FCCDBF9_395318115 = (mApnContexts.values()).iterator();
            var9CD107E7BA0F92F9952456E34FCCDBF9_395318115.hasNext();
            ApnContext apnContext = var9CD107E7BA0F92F9952456E34FCCDBF9_395318115.next();
            {
                {
                    boolean varBE5D0A772BCE39989337B7BA0425FA24_133941003 = (!apnContext.isDisconnected());
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_656247779 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_656247779;
        // ---------- Original Method ----------
        //for (ApnContext apnContext : mApnContexts.values()) {
            //if (!apnContext.isDisconnected()) {
                //return false;
            //}
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.210 -0400", hash_original_method = "85B9B626BCFF754F4C98AF3615661037", hash_generated_method = "147C574EDE75BD99A34B58B8AB824328")
    @Override
    protected void notifyDataConnection(String reason) {
        log("notifyDataConnection: reason=" + reason);
        {
            Iterator<ApnContext> var9CD107E7BA0F92F9952456E34FCCDBF9_1718749868 = (mApnContexts.values()).iterator();
            var9CD107E7BA0F92F9952456E34FCCDBF9_1718749868.hasNext();
            ApnContext apnContext = var9CD107E7BA0F92F9952456E34FCCDBF9_1718749868.next();
            {
                {
                    boolean varF0467FF71AC99F0BE559C0B01AC11D76_1244422190 = (apnContext.isReady());
                    {
                        log("notifyDataConnection: type:"+apnContext.getApnType());
                        mPhone.notifyDataConnection(reason != null ? reason : apnContext.getReason(),
                        apnContext.getApnType());
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        notifyOffApnsOfAvailability(reason);
        addTaint(reason.getTaint());
        // ---------- Original Method ----------
        //if (DBG) log("notifyDataConnection: reason=" + reason);
        //for (ApnContext apnContext : mApnContexts.values()) {
            //if (apnContext.isReady()) {
                //if (DBG) log("notifyDataConnection: type:"+apnContext.getApnType());
                //mPhone.notifyDataConnection(reason != null ? reason : apnContext.getReason(),
                        //apnContext.getApnType());
            //}
        //}
        //notifyOffApnsOfAvailability(reason);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.214 -0400", hash_original_method = "FAE53DB9273E730E3BB3527C1EA0C82D", hash_generated_method = "A2BD1FFB7D74C5066B4933D85D9F5255")
    private void createAllApnList() {
        mAllApns = new ArrayList<ApnSetting>();
        String operator;
        operator = mPhone.mIccRecords.getOperatorNumeric();
        {
            String selection;
            selection = "numeric = '" + operator + "'";
            selection += " and carrier_enabled = 1";
            log("createAllApnList: selection=" + selection);
            Cursor cursor;
            cursor = mPhone.getContext().getContentResolver().query(
                    Telephony.Carriers.CONTENT_URI, null, selection, null, null);
            {
                {
                    boolean var6498CD0999E209A4A0BE7E263562F997_1607998727 = (cursor.getCount() > 0);
                    {
                        mAllApns = createApnList(cursor);
                    } //End block
                } //End collapsed parenthetic
                cursor.close();
            } //End block
        } //End block
        {
            boolean var20904D2BF548C0A6496A2E4B42EE1318_253739037 = (mAllApns.isEmpty());
            {
                log("createAllApnList: No APN found for carrier: " + operator);
                mPreferredApn = null;
            } //End block
            {
                mPreferredApn = getPreferredApn();
                {
                    boolean var13AFC7FCEAEC4340EFADEAB1DEAC5B7B_781983785 = (mPreferredApn != null && !mPreferredApn.numeric.equals(operator));
                    {
                        mPreferredApn = null;
                        setPreferredApn(-1);
                    } //End block
                } //End collapsed parenthetic
                log("createAllApnList: mPreferredApn=" + mPreferredApn);
            } //End block
        } //End collapsed parenthetic
        log("createAllApnList: X mAllApns=" + mAllApns);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.216 -0400", hash_original_method = "5EA4CC699810E4F50A6EFC012301B7BB", hash_generated_method = "A118C2CDEC0806F4E9B0FD2CAC15613E")
    private GsmDataConnection createDataConnection() {
        GsmDataConnection varB4EAC82CA7396A68D541C85D26508E83_1259029053 = null; //Variable for return #1
        log("createDataConnection E");
        RetryManager rm;
        rm = new RetryManager();
        int id;
        id = mUniqueIdGenerator.getAndIncrement();
        GsmDataConnection conn;
        conn = GsmDataConnection.makeDataConnection(mPhone, id, rm);
        mDataConnections.put(id, conn);
        DataConnectionAc dcac;
        dcac = new DataConnectionAc(conn, LOG_TAG);
        int status;
        status = dcac.fullyConnectSync(mPhone.getContext(), this, conn.getHandler());
        {
            mDataConnectionAsyncChannels.put(dcac.dataConnection.getDataConnectionId(), dcac);
        } //End block
        {
            loge("createDataConnection: Could not connect to dcac.mDc=" + dcac.dataConnection +
                    " status=" + status);
        } //End block
        IntentFilter filter;
        filter = new IntentFilter();
        filter.addAction(INTENT_RECONNECT_ALARM + '.' + id);
        mPhone.getContext().registerReceiver(mIntentReceiver, filter, null, mPhone);
        log("createDataConnection() X id=" + id);
        varB4EAC82CA7396A68D541C85D26508E83_1259029053 = conn;
        varB4EAC82CA7396A68D541C85D26508E83_1259029053.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1259029053;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.217 -0400", hash_original_method = "E3018B8151F871DAB6348A26AB9C8E22", hash_generated_method = "974DD8C14E900405FC0E0135D3860F57")
    private void configureRetry(DataConnection dc, boolean forDefault) {
        {
            boolean var37AECCB3C8FAA31888C49CC20AC6C0E3_607436435 = (!dc.configureRetry(getReryConfig(forDefault)));
            {
                {
                    {
                        boolean varFFEFB308EB1258042E3805C355CEE781_580166172 = (!dc.configureRetry(DEFAULT_DATA_RETRY_CONFIG));
                        {
                            loge("configureRetry: Could not configure using " +
                            "DEFAULT_DATA_RETRY_CONFIG=" + DEFAULT_DATA_RETRY_CONFIG);
                            dc.configureRetry(20, 2000, 1000);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    {
                        boolean var4382F1220AB91F0872206EBC52B619CA_201982248 = (!dc.configureRetry(SECONDARY_DATA_RETRY_CONFIG));
                        {
                            loge("configureRetry: Could note configure using " +
                            "SECONDARY_DATA_RETRY_CONFIG=" + SECONDARY_DATA_RETRY_CONFIG);
                            dc.configureRetry("max_retries=3, 333, 333, 333");
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(dc.getTaint());
        addTaint(forDefault);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.221 -0400", hash_original_method = "3AA2B8847F1D4D39DED653A1D9ABBA74", hash_generated_method = "455308BA51294DCD6485094FF2A285F1")
    private void destroyDataConnections() {
        {
            log("destroyDataConnections: clear mDataConnectionList");
            mDataConnections.clear();
        } //End block
        {
            log("destroyDataConnections: mDataConnecitonList is empty, ignore");
        } //End block
        // ---------- Original Method ----------
        //if(mDataConnections != null) {
            //if (DBG) log("destroyDataConnections: clear mDataConnectionList");
            //mDataConnections.clear();
        //} else {
            //if (DBG) log("destroyDataConnections: mDataConnecitonList is empty, ignore");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.270 -0400", hash_original_method = "848BE9CB29607B1E2AFE44721BE481D7", hash_generated_method = "CB8E3FF943B1F144CAAD719421F6A1D7")
    private ArrayList<ApnSetting> buildWaitingApns(String requestedApnType) {
        ArrayList<ApnSetting> varB4EAC82CA7396A68D541C85D26508E83_104996837 = null; //Variable for return #1
        ArrayList<ApnSetting> varB4EAC82CA7396A68D541C85D26508E83_887680296 = null; //Variable for return #2
        ArrayList<ApnSetting> varB4EAC82CA7396A68D541C85D26508E83_764353596 = null; //Variable for return #3
        ArrayList<ApnSetting> apnList;
        apnList = new ArrayList<ApnSetting>();
        {
            boolean varA533E6DA53DC5795B731548F019117DF_299544048 = (requestedApnType.equals(Phone.APN_TYPE_DUN));
            {
                ApnSetting dun;
                dun = fetchDunApn();
                {
                    apnList.add(dun);
                    log("buildWaitingApns: X added APN_TYPE_DUN apnList=" + apnList);
                    varB4EAC82CA7396A68D541C85D26508E83_104996837 = apnList;
                } //End block
            } //End block
        } //End collapsed parenthetic
        String operator;
        operator = mPhone.mIccRecords.getOperatorNumeric();
        int radioTech;
        radioTech = mPhone.getServiceState().getRadioTechnology();
        {
            boolean varF99E18D293403D65F0831E88076378E8_445878388 = (requestedApnType.equals(Phone.APN_TYPE_DEFAULT));
            {
                {
                    {
                        log("buildWaitingApns: Preferred APN:" + operator + ":"
                        + mPreferredApn.numeric + ":" + mPreferredApn);
                    } //End block
                    {
                        boolean var856A96AD897866EDDA41D8E0648BCB11_16440798 = (mPreferredApn.numeric.equals(operator));
                        {
                            {
                                apnList.add(mPreferredApn);
                                log("buildWaitingApns: X added preferred apnList=" + apnList);
                                varB4EAC82CA7396A68D541C85D26508E83_887680296 = apnList;
                            } //End block
                            {
                                log("buildWaitingApns: no preferred APN");
                                setPreferredApn(-1);
                                mPreferredApn = null;
                            } //End block
                        } //End block
                        {
                            log("buildWaitingApns: no preferred APN");
                            setPreferredApn(-1);
                            mPreferredApn = null;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            {
                Iterator<ApnSetting> var02F4BAA28E3266E2CCAC36540E0DBAE4_516292164 = (mAllApns).iterator();
                var02F4BAA28E3266E2CCAC36540E0DBAE4_516292164.hasNext();
                ApnSetting apn = var02F4BAA28E3266E2CCAC36540E0DBAE4_516292164.next();
                {
                    {
                        boolean varA06A3C6237577CA78B4AB7FBA1B54C4C_1889490840 = (apn.canHandleType(requestedApnType));
                        {
                            {
                                log("apn info : " +apn.toString());
                                apnList.add(apn);
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            loge("mAllApns is empty!");
        } //End block
        log("buildWaitingApns: X apnList=" + apnList);
        varB4EAC82CA7396A68D541C85D26508E83_764353596 = apnList;
        addTaint(requestedApnType.getTaint());
        ArrayList<ApnSetting> varA7E53CE21691AB073D9660D615818899_61217829; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_61217829 = varB4EAC82CA7396A68D541C85D26508E83_104996837;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_61217829 = varB4EAC82CA7396A68D541C85D26508E83_887680296;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_61217829 = varB4EAC82CA7396A68D541C85D26508E83_764353596;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_61217829.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_61217829;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.284 -0400", hash_original_method = "E41D316825399ADA7868FFC16CE8AB28", hash_generated_method = "430452E5F513F9757E09802D21C51853")
    private String apnListToString(ArrayList<ApnSetting> apns) {
        String varB4EAC82CA7396A68D541C85D26508E83_1673329699 = null; //Variable for return #1
        StringBuilder result;
        result = new StringBuilder();
        {
            int i, size;
            i = 0;
            size = apns.size();
            {
                result.append('[')
                  .append(apns.get(i).toString())
                  .append(']');
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1673329699 = result.toString();
        addTaint(apns.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1673329699.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1673329699;
        // ---------- Original Method ----------
        //StringBuilder result = new StringBuilder();
        //for (int i = 0, size = apns.size(); i < size; i++) {
            //result.append('[')
                  //.append(apns.get(i).toString())
                  //.append(']');
        //}
        //return result.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.285 -0400", hash_original_method = "3866195B872E529451BB06B2525880D5", hash_generated_method = "87B4C3E20A474E2672BC7EA5B9929236")
    private void startDelayedRetry(GsmDataConnection.FailCause cause,
                                   ApnContext apnContext, int retryOverride) {
        notifyNoData(cause, apnContext);
        reconnectAfterFail(cause, apnContext, retryOverride);
        addTaint(cause.getTaint());
        addTaint(apnContext.getTaint());
        addTaint(retryOverride);
        // ---------- Original Method ----------
        //notifyNoData(cause, apnContext);
        //reconnectAfterFail(cause, apnContext, retryOverride);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.285 -0400", hash_original_method = "A60F121DAB80740EFF8A86C7BC5BA500", hash_generated_method = "0B436F4AF91A08A39583A1859B6B73EF")
    private void setPreferredApn(int pos) {
        ContentResolver resolver;
        resolver = mPhone.getContext().getContentResolver();
        resolver.delete(PREFERAPN_URI, null, null);
        {
            ContentValues values;
            values = new ContentValues();
            values.put(APN_ID, pos);
            resolver.insert(PREFERAPN_URI, values);
        } //End block
        addTaint(pos);
        // ---------- Original Method ----------
        //if (!canSetPreferApn) {
            //return;
        //}
        //ContentResolver resolver = mPhone.getContext().getContentResolver();
        //resolver.delete(PREFERAPN_URI, null, null);
        //if (pos >= 0) {
            //ContentValues values = new ContentValues();
            //values.put(APN_ID, pos);
            //resolver.insert(PREFERAPN_URI, values);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.352 -0400", hash_original_method = "C73C211081CDB852B85A3162F1169F83", hash_generated_method = "B098B5CF1E16E7F6395B4133EA0F319D")
    private ApnSetting getPreferredApn() {
        ApnSetting varB4EAC82CA7396A68D541C85D26508E83_1079387552 = null; //Variable for return #1
        ApnSetting varB4EAC82CA7396A68D541C85D26508E83_1690388660 = null; //Variable for return #2
        ApnSetting varB4EAC82CA7396A68D541C85D26508E83_127695443 = null; //Variable for return #3
        {
            boolean var20904D2BF548C0A6496A2E4B42EE1318_194080806 = (mAllApns.isEmpty());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1079387552 = null;
            } //End block
        } //End collapsed parenthetic
        Cursor cursor;
        cursor = mPhone.getContext().getContentResolver().query(
                PREFERAPN_URI, new String[] { "_id", "name", "apn" },
                null, null, Telephony.Carriers.DEFAULT_SORT_ORDER);
        {
            canSetPreferApn = true;
        } //End block
        {
            canSetPreferApn = false;
        } //End block
        {
            boolean varCD3E4FB8DC5266FE4AD30A8E880E316C_439510641 = (canSetPreferApn && cursor.getCount() > 0);
            {
                int pos;
                cursor.moveToFirst();
                pos = cursor.getInt(cursor.getColumnIndexOrThrow(Telephony.Carriers._ID));
                {
                    Iterator<ApnSetting> varA7D7DBA24E2BB41A4D22D64A1DC6CF6C_2029183254 = (mAllApns).iterator();
                    varA7D7DBA24E2BB41A4D22D64A1DC6CF6C_2029183254.hasNext();
                    ApnSetting p = varA7D7DBA24E2BB41A4D22D64A1DC6CF6C_2029183254.next();
                    {
                        {
                            boolean var4306E6E526674BBE5742814C2949F546_1220109006 = (p.id == pos && p.canHandleType(mRequestedApnType));
                            {
                                cursor.close();
                                varB4EAC82CA7396A68D541C85D26508E83_1690388660 = p;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            cursor.close();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_127695443 = null;
        ApnSetting varA7E53CE21691AB073D9660D615818899_581598793; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_581598793 = varB4EAC82CA7396A68D541C85D26508E83_1079387552;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_581598793 = varB4EAC82CA7396A68D541C85D26508E83_1690388660;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_581598793 = varB4EAC82CA7396A68D541C85D26508E83_127695443;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_581598793.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_581598793;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.354 -0400", hash_original_method = "AE6FD47652B0A19C805CE62DFEA0E86E", hash_generated_method = "13EB465254E9624247720EC7088082C3")
    @Override
    public void handleMessage(Message msg) {
        log("handleMessage msg=" + msg);
        {
            loge("handleMessage: Ignore GSM msgs since GSM phone is inactive");
        } //End block
        //Begin case EVENT_RECORDS_LOADED 
        onRecordsLoaded();
        //End case EVENT_RECORDS_LOADED 
        //Begin case EVENT_DATA_CONNECTION_DETACHED 
        onDataConnectionDetached();
        //End case EVENT_DATA_CONNECTION_DETACHED 
        //Begin case EVENT_DATA_CONNECTION_ATTACHED 
        onDataConnectionAttached();
        //End case EVENT_DATA_CONNECTION_ATTACHED 
        //Begin case EVENT_DATA_STATE_CHANGED 
        onDataStateChanged((AsyncResult) msg.obj);
        //End case EVENT_DATA_STATE_CHANGED 
        //Begin case EVENT_POLL_PDP 
        onPollPdp();
        //End case EVENT_POLL_PDP 
        //Begin case EVENT_DO_RECOVERY 
        doRecovery();
        //End case EVENT_DO_RECOVERY 
        //Begin case EVENT_APN_CHANGED 
        onApnChanged();
        //End case EVENT_APN_CHANGED 
        //Begin case EVENT_PS_RESTRICT_ENABLED 
        log("EVENT_PS_RESTRICT_ENABLED " + mIsPsRestricted);
        //End case EVENT_PS_RESTRICT_ENABLED 
        //Begin case EVENT_PS_RESTRICT_ENABLED 
        stopNetStatPoll();
        //End case EVENT_PS_RESTRICT_ENABLED 
        //Begin case EVENT_PS_RESTRICT_ENABLED 
        stopDataStallAlarm();
        //End case EVENT_PS_RESTRICT_ENABLED 
        //Begin case EVENT_PS_RESTRICT_ENABLED 
        mIsPsRestricted = true;
        //End case EVENT_PS_RESTRICT_ENABLED 
        //Begin case EVENT_PS_RESTRICT_DISABLED 
        log("EVENT_PS_RESTRICT_DISABLED " + mIsPsRestricted);
        //End case EVENT_PS_RESTRICT_DISABLED 
        //Begin case EVENT_PS_RESTRICT_DISABLED 
        mIsPsRestricted  = false;
        //End case EVENT_PS_RESTRICT_DISABLED 
        //Begin case EVENT_PS_RESTRICT_DISABLED 
        {
            boolean var5153987C55DB41759ADC1D7527E9459D_579273494 = (isConnected());
            {
                startNetStatPoll();
                startDataStallAlarm();
            } //End block
            {
                {
                    cleanUpAllConnections(false, Phone.REASON_PS_RESTRICT_ENABLED);
                    resetAllRetryCounts();
                    mReregisterOnReconnectFailure = false;
                } //End block
                trySetupData(Phone.REASON_PS_RESTRICT_ENABLED, Phone.APN_TYPE_DEFAULT);
            } //End block
        } //End collapsed parenthetic
        //End case EVENT_PS_RESTRICT_DISABLED 
        //Begin case EVENT_TRY_SETUP_DATA 
        {
            onTrySetupData((ApnContext)msg.obj);
        } //End block
        {
            onTrySetupData((String)msg.obj);
        } //End block
        {
            loge("EVENT_TRY_SETUP request w/o apnContext or String");
        } //End block
        //End case EVENT_TRY_SETUP_DATA 
        //Begin case EVENT_CLEAN_UP_CONNECTION 
        boolean tearDown;
        tearDown = false;
        tearDown = true;
        //End case EVENT_CLEAN_UP_CONNECTION 
        //Begin case EVENT_CLEAN_UP_CONNECTION 
        log("EVENT_CLEAN_UP_CONNECTION tearDown=" + tearDown);
        //End case EVENT_CLEAN_UP_CONNECTION 
        //Begin case EVENT_CLEAN_UP_CONNECTION 
        {
            cleanUpConnection(tearDown, (ApnContext)msg.obj);
        } //End block
        {
            loge("EVENT_CLEAN_UP_CONNECTION request w/o apn context");
        } //End block
        //End case EVENT_CLEAN_UP_CONNECTION 
        //Begin case default 
        super.handleMessage(msg);
        //End case default 
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.355 -0400", hash_original_method = "46AFDD0964E9004EF08AD58B2795A021", hash_generated_method = "A38C986879A6A462C277B001F2C9A3BD")
    protected int getApnProfileID(String apnType) {
        {
            boolean varBD5A51DA361F3966223B48A5CF932C78_1865075341 = (TextUtils.equals(apnType, Phone.APN_TYPE_IMS));
            {
                boolean varD564B10DB28FA322978443E532F7503A_1433023434 = (TextUtils.equals(apnType, Phone.APN_TYPE_FOTA));
                {
                    boolean var3A4BC1B957119377C5312013BE2E7BF3_1537089002 = (TextUtils.equals(apnType, Phone.APN_TYPE_CBS));
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        addTaint(apnType.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_901376794 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_901376794;
        // ---------- Original Method ----------
        //if (TextUtils.equals(apnType, Phone.APN_TYPE_IMS)) {
            //return RILConstants.DATA_PROFILE_IMS;
        //} else if (TextUtils.equals(apnType, Phone.APN_TYPE_FOTA)) {
            //return RILConstants.DATA_PROFILE_FOTA;
        //} else if (TextUtils.equals(apnType, Phone.APN_TYPE_CBS)) {
            //return RILConstants.DATA_PROFILE_CBS;
        //} else {
            //return RILConstants.DATA_PROFILE_DEFAULT;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.369 -0400", hash_original_method = "EC98DB8AAEBCEBF774D7D372A9BC5BED", hash_generated_method = "29F96E2E5307D820CF8CAAA38F663E26")
    private int getCellLocationId() {
        int cid;
        cid = -1;
        CellLocation loc;
        loc = mPhone.getCellLocation();
        {
            {
                cid = ((GsmCellLocation)loc).getCid();
            } //End block
            {
                cid = ((CdmaCellLocation)loc).getBaseStationId();
            } //End block
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_605181140 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_605181140;
        // ---------- Original Method ----------
        //int cid = -1;
        //CellLocation loc = mPhone.getCellLocation();
        //if (loc != null) {
            //if (loc instanceof GsmCellLocation) {
                //cid = ((GsmCellLocation)loc).getCid();
            //} else if (loc instanceof CdmaCellLocation) {
                //cid = ((CdmaCellLocation)loc).getBaseStationId();
            //}
        //}
        //return cid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.369 -0400", hash_original_method = "74A1E45944BDF6EB75FE1BB75B450C28", hash_generated_method = "B6B302AEF97CB34BD5F51313217CD2BA")
    @Override
    protected void log(String s) {
        Log.d(LOG_TAG, "[GsmDCT] "+ s);
        addTaint(s.getTaint());
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[GsmDCT] "+ s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.370 -0400", hash_original_method = "F4E978940BCE74A01AFD260967E7D0F1", hash_generated_method = "4161D7256990615E95C2D94DA5F096C5")
    @Override
    protected void loge(String s) {
        addTaint(s.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[GsmDCT] " + s);
    }

    
    private class ApnChangeObserver extends ContentObserver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.370 -0400", hash_original_method = "6B7B68FCD4064976D9DFC8282278DEB2", hash_generated_method = "B25D6445CFCAAC6EBB935C2E1EA4D894")
        public  ApnChangeObserver() {
            super(mDataConnectionTracker);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.370 -0400", hash_original_method = "C002DCEBDDA1BCF98FA65E6C3DFBEDC7", hash_generated_method = "551FF4B549181F8354763D27FD001C97")
        @Override
        public void onChange(boolean selfChange) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            sendMessage(obtainMessage(EVENT_APN_CHANGED));
            addTaint(selfChange);
            // ---------- Original Method ----------
            //sendMessage(obtainMessage(EVENT_APN_CHANGED));
        }

        
    }


    
    class RecoveryAction {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.371 -0400", hash_original_method = "32173E3A0316410E8650FB75524992A2", hash_generated_method = "32173E3A0316410E8650FB75524992A2")
        public RecoveryAction ()
        {
            //Synthesized constructor
        }


        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.371 -0400", hash_original_field = "AC1EA81D2E3E1333FCD96E718694DE5D", hash_generated_field = "9444F7385ED075FD957CBF2705B431F2")

        public static final int GET_DATA_CALL_LIST      = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.371 -0400", hash_original_field = "77820D853702E26D80B8C5CEA6391818", hash_generated_field = "C5F9F5C8FD7BE9C11274D2A4D79064AC")

        public static final int CLEANUP                 = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.371 -0400", hash_original_field = "690E9D42D7A38621C7BC9124DC929AB4", hash_generated_field = "78C8CA1646CB6F57C71EDA35CC71F4A7")

        public static final int REREGISTER              = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.371 -0400", hash_original_field = "C1DF1F0D781602F33B43E37AA0307536", hash_generated_field = "B5EDD1906682D24DD1AADF7FCCE7CBB3")

        public static final int RADIO_RESTART           = 3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.371 -0400", hash_original_field = "8D896D16951798ED3179A1A1D27840B1", hash_generated_field = "F6B83BCA43B3D6989BC81E37B804B55C")

        public static final int RADIO_RESTART_WITH_PROP = 4;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.371 -0400", hash_original_field = "D4A6B3BD4E6EDE29866B8BB1C029F206", hash_generated_field = "A4633A5F307BBC96632EA766FF18A55C")

    private static int POLL_PDP_MILLIS = 5 * 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.371 -0400", hash_original_field = "59E7B103A5A98DA445972D780805A6D8", hash_generated_field = "2AED5B8AE6AE957AB053EB6BDD3A0773")

    private static String INTENT_RECONNECT_ALARM = "com.android.internal.telephony.gprs-reconnect";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.371 -0400", hash_original_field = "7ABDEEA49CD4421170D8FEE10D4A15DF", hash_generated_field = "7403908083145632021814C37D7FAF00")

    private static String INTENT_RECONNECT_ALARM_EXTRA_TYPE = "type";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.371 -0400", hash_original_field = "F2578B81B366A9F860AC7401704D9A14", hash_generated_field = "3D25F7AE3FB6E2CEA8B1713D175A5EC9")

    private static String INTENT_DATA_STALL_ALARM = "com.android.internal.telephony.gprs-data-stall";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.371 -0400", hash_original_field = "C3EC4B88B73C081C68A3ED1B75DA3E0C", hash_generated_field = "EE892B602B1CCB0C687DADFC08D1A5BD")

    static Uri PREFERAPN_URI = Uri.parse("content://telephony/carriers/preferapn");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.371 -0400", hash_original_field = "4F133E66E8DCA457A37645FE662A9FD3", hash_generated_field = "3632C2F81C624F426C153348127F26B6")

    static String APN_ID = "apn_id";
}

