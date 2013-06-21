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
    protected String LOG_TAG = "GSM";
    private boolean mReregisterOnReconnectFailure = false;
    private ContentResolver mResolver;
    private boolean canSetPreferApn = false;
    private ApnChangeObserver mApnObserver;
    private Runnable mPollNetStat = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.507 -0400", hash_original_method = "12521CBB0E1762BFCDF7B49EB5CC9977", hash_generated_method = "EEDFDA3636D0462EB4B15FD97B22B6E4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.508 -0400", hash_original_method = "11FDC14BF2164142AF8732E525079D07", hash_generated_method = "5EE8C8E00C0EFAE04664971CD4F6DD43")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public GsmDataConnectionTracker(PhoneBase p) {
        super(p);
        dsTaint.addTaint(p.dsTaint);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.508 -0400", hash_original_method = "3545EE6BB84B537BCF88623776AFA30D", hash_generated_method = "D618C4D187C242DA79CC6035275C1918")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getRecoveryAction() {
        int action;
        action = Settings.System.getInt(mPhone.getContext().getContentResolver(),
                "radio.data.stall.recovery.action", RecoveryAction.GET_DATA_CALL_LIST);
        log("getRecoveryAction: " + action);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int action = Settings.System.getInt(mPhone.getContext().getContentResolver(),
                //"radio.data.stall.recovery.action", RecoveryAction.GET_DATA_CALL_LIST);
        //if (VDBG) log("getRecoveryAction: " + action);
        //return action;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.508 -0400", hash_original_method = "D18EC99E3BCC3D9A76595B0D702BEA57", hash_generated_method = "F8185EA312BC351F5756FA05C7D6B6B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void putRecoveryAction(int action) {
        dsTaint.addTaint(action);
        Settings.System.putInt(mPhone.getContext().getContentResolver(),
                "radio.data.stall.recovery.action", action);
        log("putRecoveryAction: " + action);
        // ---------- Original Method ----------
        //Settings.System.putInt(mPhone.getContext().getContentResolver(),
                //"radio.data.stall.recovery.action", action);
        //if (VDBG) log("putRecoveryAction: " + action);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.523 -0400", hash_original_method = "DABEDBF19FEC4514BE5AAA6475C962EB", hash_generated_method = "E7EA47E57D307EDBE1DAA4AF55DDBE67")
    @DSModeled(DSC.SPEC)
    @Override
    protected void onActionIntentReconnectAlarm(Intent intent) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(intent.dsTaint);
        log("GPRS reconnect alarm. Previous state was " + mState);
        String reason;
        reason = intent.getStringExtra(INTENT_RECONNECT_ALARM_EXTRA_REASON);
        int connectionId;
        connectionId = intent.getIntExtra(INTENT_RECONNECT_ALARM_EXTRA_TYPE, -1);
        DataConnectionAc dcac;
        dcac = mDataConnectionAsyncChannels.get(connectionId);
        {
            {
                Iterator<ApnContext> varEF92E30A3FB0B00CC855D485C129D6BC_516557589 = (dcac.getApnListSync()).iterator();
                varEF92E30A3FB0B00CC855D485C129D6BC_516557589.hasNext();
                ApnContext apnContext = varEF92E30A3FB0B00CC855D485C129D6BC_516557589.next();
                {
                    apnContext.setReason(reason);
                    {
                        boolean var8C3F5A245E8CD46D727CA60CA79AEBA0_641392984 = (apnContext.getState() == State.FAILED);
                        {
                            apnContext.setState(State.IDLE);
                        } //End block
                    } //End collapsed parenthetic
                    sendMessage(obtainMessage(EVENT_TRY_SETUP_DATA, apnContext));
                } //End block
            } //End collapsed parenthetic
            dcac.setReconnectIntentSync(null);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.524 -0400", hash_original_method = "4494E5E1AF62FA72ED21CBDD59685023", hash_generated_method = "2CEC678BFD48E0CD7A4526D23263E43F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.524 -0400", hash_original_method = "7B2466E598494011616B7E0248698FD2", hash_generated_method = "30C4C8A8918802A1A9E99D08A6EC5671")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isApnTypeActive(String type) {
        dsTaint.addTaint(type);
        ApnContext apnContext;
        apnContext = mApnContexts.get(type);
        boolean varFD30B4DFFE3E84898874278558C9F3D1_659726322 = ((apnContext.getDataConnection() != null));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //ApnContext apnContext = mApnContexts.get(type);
        //if (apnContext == null) return false;
        //return (apnContext.getDataConnection() != null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.524 -0400", hash_original_method = "63B54477A01480F02B741F41FE0D8DBF", hash_generated_method = "43F41286B9D9ADBC136BDFD31AE0D0BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean isDataPossible(String apnType) {
        dsTaint.addTaint(apnType);
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.524 -0400", hash_original_method = "6FB50CEA8307C4B6093E637FBC3F2923", hash_generated_method = "586E4F0B9964C893B65A8A5D4241A99C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void finalize() {
        log("finalize");
        // ---------- Original Method ----------
        //if(DBG) log("finalize");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.524 -0400", hash_original_method = "477FAE9A0F7056536F0C43A4344C1E00", hash_generated_method = "2601B2CD85742A490DD38F2EDDD6E837")
    @DSModeled(DSC.SAFE)
    @Override
    protected String getActionIntentReconnectAlarm() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return INTENT_RECONNECT_ALARM;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.525 -0400", hash_original_method = "BBE23E9137760572C0B9E85F7DE2F87D", hash_generated_method = "D995B620F1284E6CCA92E01C960F1FC5")
    @DSModeled(DSC.SAFE)
    @Override
    protected String getActionIntentDataStallAlarm() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return INTENT_DATA_STALL_ALARM;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.525 -0400", hash_original_method = "0E3E3502B5D9BF75D72D228425E0F7B7", hash_generated_method = "8D76E0D79120A9691EBACA754123C5F2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ApnContext addApnContext(String type) {
        dsTaint.addTaint(type);
        ApnContext apnContext;
        apnContext = new ApnContext(type, LOG_TAG);
        apnContext.setDependencyMet(false);
        mApnContexts.put(type, apnContext);
        return (ApnContext)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ApnContext apnContext = new ApnContext(type, LOG_TAG);
        //apnContext.setDependencyMet(false);
        //mApnContexts.put(type, apnContext);
        //return apnContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.532 -0400", hash_original_method = "8959993CE2EB92BA5CEF3E2E51BAABDD", hash_generated_method = "FEDC5A314AE9CD5E41FFDA3B22D9355F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void initApnContextsAndDataConnection() {
        boolean defaultEnabled;
        defaultEnabled = SystemProperties.getBoolean(DEFALUT_DATA_ON_BOOT_PROP, true);
        String[] networkConfigStrings;
        networkConfigStrings = mPhone.getContext().getResources().getStringArray(
                com.android.internal.R.array.networkAttributes);
        {
            String networkConfigString = networkConfigStrings[0];
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.533 -0400", hash_original_method = "C5F45AE4298273442B50BBFD614E8417", hash_generated_method = "3EA099F69E6457A82BDBA1C80C33C05D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected LinkProperties getLinkProperties(String apnType) {
        dsTaint.addTaint(apnType);
        ApnContext apnContext;
        apnContext = mApnContexts.get(apnType);
        {
            DataConnectionAc dcac;
            dcac = apnContext.getDataConnectionAc();
            {
                log("return link properites for " + apnType);
                LinkProperties varD2C3B5E0EEB3E50593471FB5FD58F663_977975050 = (dcac.getLinkPropertiesSync());
            } //End block
        } //End block
        log("return new LinkProperties");
        LinkProperties varF77719563C1A04A9BF912A34C5CC7620_1555558714 = (new LinkProperties());
        return (LinkProperties)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.533 -0400", hash_original_method = "94651B427B7F42F00ED4B45503EF287D", hash_generated_method = "5AB30A7FCC5B17EBBCB5007C67033B52")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected LinkCapabilities getLinkCapabilities(String apnType) {
        dsTaint.addTaint(apnType);
        ApnContext apnContext;
        apnContext = mApnContexts.get(apnType);
        {
            DataConnectionAc dataConnectionAc;
            dataConnectionAc = apnContext.getDataConnectionAc();
            {
                log("get active pdp is not null, return link Capabilities for " + apnType);
                LinkCapabilities var8C6E24374294553E22B3139C465E1861_122546294 = (dataConnectionAc.getLinkCapabilitiesSync());
            } //End block
        } //End block
        log("return new LinkCapabilities");
        LinkCapabilities var2003A1B72F79B833FC1E954AF2ABB585_700758363 = (new LinkCapabilities());
        return (LinkCapabilities)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.549 -0400", hash_original_method = "BFF203ED461E9185DBA7A58AF111F0F3", hash_generated_method = "EA202F546F31D3E16EEFB5935BA51311")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String[] getActiveApnTypes() {
        log("get all active apn types");
        ArrayList<String> result;
        result = new ArrayList<String>();
        {
            Iterator<ApnContext> var9CD107E7BA0F92F9952456E34FCCDBF9_1619102518 = (mApnContexts.values()).iterator();
            var9CD107E7BA0F92F9952456E34FCCDBF9_1619102518.hasNext();
            ApnContext apnContext = var9CD107E7BA0F92F9952456E34FCCDBF9_1619102518.next();
            {
                {
                    boolean varF0467FF71AC99F0BE559C0B01AC11D76_1599802557 = (apnContext.isReady());
                    {
                        result.add(apnContext.getApnType());
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        String[] varED1D165AB64C9ACDD1507C830BD491DE_1699436117 = ((String[])result.toArray(new String[0]));
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.550 -0400", hash_original_method = "8D1CDDA6C04920E256FCAAE007846C5E", hash_generated_method = "9EEBD26B79D80C0489791B02CD7CDEE3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String getActiveApnString(String apnType) {
        dsTaint.addTaint(apnType);
        log( "get active apn string for type:" + apnType);
        ApnContext apnContext;
        apnContext = mApnContexts.get(apnType);
        {
            ApnSetting apnSetting;
            apnSetting = apnContext.getApnSetting();
        } //End block
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.551 -0400", hash_original_method = "5E11C1BF7F74A775167DAE6DA061B097", hash_generated_method = "E127F24D781E381239C164F0777B6749")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isApnTypeEnabled(String apnType) {
        dsTaint.addTaint(apnType);
        ApnContext apnContext;
        apnContext = mApnContexts.get(apnType);
        boolean varDFED02B8DB0BBFAE1CF1947E145E6BAC_1195143964 = (apnContext.isEnabled());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //ApnContext apnContext = mApnContexts.get(apnType);
        //if (apnContext == null) {
            //return false;
        //}
        //return apnContext.isEnabled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.552 -0400", hash_original_method = "06373F80BD4BEEF603E49D19A1DC6DA1", hash_generated_method = "B3549D9AC32714B482875C3939C69C10")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void setState(State s) {
        dsTaint.addTaint(s.dsTaint);
        log("setState should not be used in GSM" + s);
        // ---------- Original Method ----------
        //if (DBG) log("setState should not be used in GSM" + s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.554 -0400", hash_original_method = "F24CC52DF36174C789130EC41124E06F", hash_generated_method = "835FB611A11C61A06302B21CB3B9755D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public State getState(String apnType) {
        dsTaint.addTaint(apnType);
        ApnContext apnContext;
        apnContext = mApnContexts.get(apnType);
        {
            State varCC6C8A28F935122C65EE8C4D104696CB_808540972 = (apnContext.getState());
        } //End block
        return (State)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ApnContext apnContext = mApnContexts.get(apnType);
        //if (apnContext != null) {
            //return apnContext.getState();
        //}
        //return State.FAILED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.563 -0400", hash_original_method = "3A07E102C7877AE139AF74E35A92CB31", hash_generated_method = "5FC024CFCA17CE5CF5EE032F70903DAC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public State getOverallState() {
        boolean isConnecting;
        isConnecting = false;
        boolean isFailed;
        isFailed = true;
        boolean isAnyEnabled;
        isAnyEnabled = false;
        {
            Iterator<ApnContext> var9CD107E7BA0F92F9952456E34FCCDBF9_1433484608 = (mApnContexts.values()).iterator();
            var9CD107E7BA0F92F9952456E34FCCDBF9_1433484608.hasNext();
            ApnContext apnContext = var9CD107E7BA0F92F9952456E34FCCDBF9_1433484608.next();
            {
                {
                    boolean var74352AE28F2089CB53B9CCFDDD397A5B_1279866053 = (apnContext.isEnabled());
                    {
                        isAnyEnabled = true;
                        {
                            Object var9700B9CEEDE7EF1C802BA1A530973D22_1625622466 = (apnContext.getState());
                            //Begin case CONNECTED DISCONNECTING 
                            log("overall state is CONNECTED");
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
        } //End block
        {
            log( "overall state is CONNECTING");
        } //End block
        {
            log( "overall state is IDLE");
        } //End block
        {
            log( "overall state is FAILED");
        } //End block
        return (State)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.563 -0400", hash_original_method = "DED9CF35B00E99A5C3539FDABA142E11", hash_generated_method = "401FFD1ED8C5DCC89825BBEBE198BFD2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized int enableApnType(String apnType) {
        dsTaint.addTaint(apnType);
        ApnContext apnContext;
        apnContext = mApnContexts.get(apnType);
        {
            boolean var40721DBF76B6A7B6E8BADFF44F346C7D_1392021192 = (apnContext == null || !isApnTypeAvailable(apnType));
            {
                log("enableApnType: " + apnType + " is type not available");
            } //End block
        } //End collapsed parenthetic
        log("enableApnType: " + apnType + " mState(" + apnContext.getState() + ")");
        {
            boolean varDB1637033A9F9F6454E8C3CF2D34A73D_113494519 = (apnContext.getState() == State.CONNECTED);
            {
                log("enableApnType: return APN_ALREADY_ACTIVE");
            } //End block
        } //End collapsed parenthetic
        setEnabled(apnTypeToId(apnType), true);
        {
            log("enableApnType: new apn request for type " + apnType +
                    " return APN_REQUEST_STARTED");
        } //End block
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.563 -0400", hash_original_method = "6BE0F7A51104BACC1DFB5733CC5E30CC", hash_generated_method = "47DA42F6A8DC83F8D2215311FE28A816")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void notifyApnIdUpToCurrent(String reason, ApnContext apnContext, String type) {
        dsTaint.addTaint(apnContext.dsTaint);
        dsTaint.addTaint(reason);
        dsTaint.addTaint(type);
        {
            Object varCC6C8A28F935122C65EE8C4D104696CB_2043891577 = (apnContext.getState());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.564 -0400", hash_original_method = "68A04474A9A6C009171326D545E43C31", hash_generated_method = "1979147DCEA83F2750A524000965552B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized int disableApnType(String type) {
        dsTaint.addTaint(type);
        log("disableApnType:" + type);
        ApnContext apnContext;
        apnContext = mApnContexts.get(type);
        {
            setEnabled(apnTypeToId(type), false);
            {
                boolean var7103B42DD56954FC04F4B2365C64FC7D_1932088847 = (apnContext.getState() != State.IDLE && apnContext.getState() != State.FAILED);
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
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.572 -0400", hash_original_method = "A26AD8C394281D1D0A1213181383C4F5", hash_generated_method = "B05DF89C02491E37B443A6E20D6217C5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean isApnTypeAvailable(String type) {
        dsTaint.addTaint(type);
        {
            boolean var3E24ADAA978C2A1617DE6CE4C1277596_1190279171 = (type.equals(Phone.APN_TYPE_DUN) && fetchDunApn() != null);
        } //End collapsed parenthetic
        {
            {
                Iterator<ApnSetting> var02F4BAA28E3266E2CCAC36540E0DBAE4_1575114964 = (mAllApns).iterator();
                var02F4BAA28E3266E2CCAC36540E0DBAE4_1575114964.hasNext();
                ApnSetting apn = var02F4BAA28E3266E2CCAC36540E0DBAE4_1575114964.next();
                {
                    {
                        boolean varCE4968051D63BE091B6671C08AC1461B_1142007235 = (apn.canHandleType(type));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.581 -0400", hash_original_method = "C851438642EDA5AB3134873854010685", hash_generated_method = "97DF1E93A5EB73B2158FD159D0257C59")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getAnyDataEnabled() {
        {
            {
                Iterator<ApnContext> var9CD107E7BA0F92F9952456E34FCCDBF9_358528441 = (mApnContexts.values()).iterator();
                var9CD107E7BA0F92F9952456E34FCCDBF9_358528441.hasNext();
                ApnContext apnContext = var9CD107E7BA0F92F9952456E34FCCDBF9_358528441.next();
                {
                    {
                        boolean varD0085CFE2AE3A9FD75A21E639E837206_1046389504 = (isDataAllowed(apnContext));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.582 -0400", hash_original_method = "7A177E6FBAF2829724A437FA44770C6E", hash_generated_method = "513D45A6B8B4C6443AC927D18FC30587")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isDataAllowed(ApnContext apnContext) {
        dsTaint.addTaint(apnContext.dsTaint);
        boolean var3F4B19E1911E206B03500C4E7AFD578E_921074717 = (apnContext.isReady() && isDataAllowed());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return apnContext.isReady() && isDataAllowed();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.582 -0400", hash_original_method = "DBAD0221F2A53A2AC3E8556324A28A19", hash_generated_method = "70865B629C043E2B67ECAB7D5418421A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.582 -0400", hash_original_method = "5C53501E16056276F20AC7E7EDF79BD4", hash_generated_method = "C21258A43D4B0C8CFA495FEE901EAB18")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void onDataConnectionAttached() {
        log("onDataConnectionAttached");
        {
            boolean varD6A7948C24B6C2236B4862C980AEEE69_506609929 = (getOverallState() == State.CONNECTED);
            {
                log("onDataConnectionAttached: start polling notify attached");
                startNetStatPoll();
                startDataStallAlarm(DATA_STALL_NOT_SUSPECTED);
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
            //startDataStallAlarm(DATA_STALL_NOT_SUSPECTED);
            //notifyDataConnection(Phone.REASON_DATA_ATTACHED);
        //} else {
            //notifyOffApnsOfAvailability(Phone.REASON_DATA_ATTACHED);
        //}
        //setupDataOnReadyApns(Phone.REASON_DATA_ATTACHED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.583 -0400", hash_original_method = "000E90D5C33553E8124AA0C75E4D9E4F", hash_generated_method = "2455469E7040198E4D21EDAEB7CC8091")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
                boolean varF2489385CBDDB7E3A0ACE2F09C15B0F9_2111484926 = (!mPhone.mIccRecords.getRecordsLoaded());
                reason += " - SIM not loaded";
            } //End collapsed parenthetic
            {
                boolean var28FCD7715CD53D3D0F5A3AC4104C9F7E_1916920582 = (mPhone.getState() != Phone.State.IDLE &&
                    !mPhone.getServiceStateTracker().isConcurrentVoiceAndDataAllowed());
                {
                    reason += " - PhoneState= " + mPhone.getState();
                    reason += " - Concurrent voice and data not allowed";
                } //End block
            } //End collapsed parenthetic
            reason += " - mInternalDataEnabled= false";
            {
                boolean varA43BAC19CA96DD278C9F67CBBD3CA8CE_170634503 = (mPhone.getServiceState().getRoaming() && !getDataOnRoamingEnabled());
                {
                    reason += " - Roaming and data roaming not enabled";
                } //End block
            } //End collapsed parenthetic
            reason += " - mIsPsRestricted= true";
            reason += " - desiredPowerState= false";
            log("isDataAllowed: not allowed due to" + reason);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.592 -0400", hash_original_method = "625A02DD3D04B0C927BA692603CBFCC6", hash_generated_method = "FCE4432E9072392F2CD13B727CBF83CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setupDataOnReadyApns(String reason) {
        dsTaint.addTaint(reason);
        {
            DataConnectionAc dcac = mDataConnectionAsyncChannels.values()[0];
            {
                {
                    boolean var9F52EC3EC3AC7E94BDD16A1A7AB208DF_1163473057 = (dcac.getReconnectIntentSync() != null);
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
                        Iterator<ApnContext> varB87ED0964EC6294E1148D70C8996DEB3_698319197 = (apns).iterator();
                        varB87ED0964EC6294E1148D70C8996DEB3_698319197.hasNext();
                        ApnContext apnContext = varB87ED0964EC6294E1148D70C8996DEB3_698319197.next();
                        {
                            {
                                boolean var9434236FBB7E6A998E8474EDA4EA2A94_1883096108 = (apnContext.getApnType().equals(Phone.APN_TYPE_DEFAULT));
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
            Iterator<ApnContext> var9CD107E7BA0F92F9952456E34FCCDBF9_1801082277 = (mApnContexts.values()).iterator();
            var9CD107E7BA0F92F9952456E34FCCDBF9_1801082277.hasNext();
            ApnContext apnContext = var9CD107E7BA0F92F9952456E34FCCDBF9_1801082277.next();
            {
                {
                    boolean var28727C373B0301059C7D64663A365FCB_1367070334 = (apnContext.getState() == State.FAILED);
                    {
                        apnContext.setState(State.IDLE);
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varF0467FF71AC99F0BE559C0B01AC11D76_1098172466 = (apnContext.isReady());
                    {
                        {
                            boolean var8AB36F3FADA76FDD70758859DCE39C3A_1838145987 = (apnContext.getState() == State.IDLE);
                            {
                                apnContext.setReason(reason);
                                trySetupData(apnContext);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.593 -0400", hash_original_method = "293D247CD6F3CD381680AFA4CF477431", hash_generated_method = "7BC713BDC2C420B6E83B1FE2B4363CC4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean trySetupData(String reason, String type) {
        dsTaint.addTaint(reason);
        dsTaint.addTaint(type);
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
        boolean varD10E5DDD0548397420B754E479BF3D26_2053247018 = (trySetupData(apnContext));
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.593 -0400", hash_original_method = "01B865917AB0716CB4ECB273F41078C0", hash_generated_method = "65E9954FD130ACFD3366914A64D7FCB9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean trySetupData(ApnContext apnContext) {
        dsTaint.addTaint(apnContext.dsTaint);
        {
            log("trySetupData for type:" + apnContext.getApnType() +
                    " due to " + apnContext.getReason());
            log("trySetupData with mIsPsRestricted=" + mIsPsRestricted);
        } //End block
        {
            boolean varA62B422C35237A9A4A0C0A75D57190F8_429570585 = (mPhone.getSimulatedRadioControl() != null);
            {
                apnContext.setState(State.CONNECTED);
                mPhone.notifyDataConnection(apnContext.getReason(), apnContext.getApnType());
                log("trySetupData: (fix?) We're on the simulator; assuming data is connected");
            } //End block
        } //End collapsed parenthetic
        boolean desiredPowerState;
        desiredPowerState = mPhone.getServiceStateTracker().getDesiredPowerState();
        {
            boolean var5A171EFB50513FF177155112D610371D_301250214 = ((apnContext.getState() == State.IDLE || apnContext.getState() == State.SCANNING) &&
                isDataAllowed(apnContext) && getAnyDataEnabled() && !isEmergency());
            {
                {
                    boolean varC9E447884E4C233ED7168B30C06B00A1_92988431 = (apnContext.getState() == State.IDLE);
                    {
                        ArrayList<ApnSetting> waitingApns;
                        waitingApns = buildWaitingApns(apnContext.getApnType());
                        {
                            boolean varBC6ECF00D7C0418D64AB187B0B88E0B6_856472247 = (waitingApns.isEmpty());
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
                    boolean var6997658875C9EE68C32AF30989EDEC44_1317468856 = (!apnContext.getApnType().equals(Phone.APN_TYPE_DEFAULT)
                && (apnContext.getState() == State.IDLE
                    || apnContext.getState() == State.SCANNING));
                    mPhone.notifyDataConnectionFailed(apnContext.getReason(), apnContext.getApnType());
                } //End collapsed parenthetic
                notifyOffApnsOfAvailability(apnContext.getReason());
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.600 -0400", hash_original_method = "9CD870BA8C542E1D80FC2F2D725750C0", hash_generated_method = "D0E1DEC7C43728B901D4133FAF1CBFA7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void notifyOffApnsOfAvailability(String reason) {
        dsTaint.addTaint(reason);
        {
            ApnContext apnContext = mApnContexts.values()[0];
            {
                {
                    boolean varD681883FCEAD4BAE1DEE9A0AA56202F0_1218425003 = (!apnContext.isReady());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.606 -0400", hash_original_method = "66E1568E09B68AEC1E9A7CA6629E1BE4", hash_generated_method = "BFEC88A49CA02F37DEFE1F5326C2785E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void cleanUpAllConnections(boolean tearDown, String reason) {
        dsTaint.addTaint(reason);
        dsTaint.addTaint(tearDown);
        log("cleanUpAllConnections: tearDown=" + tearDown + " reason=" + reason);
        {
            Iterator<ApnContext> var9CD107E7BA0F92F9952456E34FCCDBF9_16038664 = (mApnContexts.values()).iterator();
            var9CD107E7BA0F92F9952456E34FCCDBF9_16038664.hasNext();
            ApnContext apnContext = var9CD107E7BA0F92F9952456E34FCCDBF9_16038664.next();
            {
                apnContext.setReason(reason);
                cleanUpConnection(tearDown, apnContext);
            } //End block
        } //End collapsed parenthetic
        stopNetStatPoll();
        stopDataStallAlarm();
        mRequestedApnType = Phone.APN_TYPE_DEFAULT;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.606 -0400", hash_original_method = "CD47D8147DAAE254C6F8BD59780442CD", hash_generated_method = "22921BBF56C8E798CF58FAA8E680BBED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onCleanUpAllConnections(String cause) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(cause);
        cleanUpAllConnections(true, cause);
        // ---------- Original Method ----------
        //cleanUpAllConnections(true, cause);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.607 -0400", hash_original_method = "93E0ED2B7F6740BCFA09628007B4F734", hash_generated_method = "2947788703FC62C6F182EF217858A9F4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void cleanUpConnection(boolean tearDown, ApnContext apnContext) {
        dsTaint.addTaint(apnContext.dsTaint);
        dsTaint.addTaint(tearDown);
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
                boolean varBD1E2AD5899AFE289CE08DB683D4CF33_1428352952 = (apnContext.isDisconnected());
                {
                    apnContext.setState(State.IDLE);
                    {
                        boolean varC29F4942D61E6248F4ED50CF015D5956_1464030799 = (!apnContext.isReady());
                        {
                            apnContext.setDataConnection(null);
                            apnContext.setDataConnectionAc(null);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    {
                        {
                            boolean varA35A04BCD0D81151EFACE0D975BA0673_1714623081 = (apnContext.getState() != State.DISCONNECTING);
                            {
                                boolean disconnectAll;
                                disconnectAll = false;
                                {
                                    boolean var2BCA60C050889DFD6D8D41CC2794C0F6_364057435 = (Phone.APN_TYPE_DUN.equals(apnContext.getApnType()));
                                    {
                                        ApnSetting dunSetting;
                                        dunSetting = fetchDunApn();
                                        {
                                            boolean var52F84A9B2C5C1668323FC758369CD7F9_1026397244 = (dunSetting != null &&
                                    dunSetting.equals(apnContext.getApnSetting()));
                                            {
                                                log("tearing down dedicated DUN connection");
                                                disconnectAll = true;
                                            } //End block
                                        } //End collapsed parenthetic
                                    } //End block
                                } //End collapsed parenthetic
                                {
                                    log("cleanUpConnection: tearing down" + (disconnectAll ? " all" :""));
                                } //End block
                                Message msg;
                                msg = obtainMessage(EVENT_DISCONNECT_DONE, apnContext);
                                {
                                    apnContext.getDataConnection().tearDownAll(apnContext.getReason(), msg);
                                } //End block
                                {
                                    apnContext.getDataConnection().tearDown(apnContext.getReason(), msg);
                                } //End block
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
                boolean var1752AEEE95D46EA2CE0A4ED286F446DA_149051699 = (apnList.isEmpty());
                {
                    cancelReconnectAlarm(dcac);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.607 -0400", hash_original_method = "1F926905027AA18BF39C8A7A893395A9", hash_generated_method = "96B43D9E3E59C3870B73B7DFCD609921")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void cancelReconnectAlarm(DataConnectionAc dcac) {
        dsTaint.addTaint(dcac.dsTaint);
        PendingIntent intent;
        intent = dcac.getReconnectIntentSync();
        {
            AlarmManager am;
            am = (AlarmManager) mPhone.getContext().getSystemService(Context.ALARM_SERVICE);
            am.cancel(intent);
            dcac.setReconnectIntentSync(null);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.607 -0400", hash_original_method = "08930E35848EBECD6CC869C9C6D6B1F8", hash_generated_method = "D5CAF6AC1A5163D94B012612FEF52527")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String[] parseTypes(String types) {
        dsTaint.addTaint(types);
        String[] result;
        {
            boolean var42B66898C7E13316B0BD3608BC7660AE_1490391195 = (types == null || types.equals(""));
            {
                result = new String[1];
                result[0] = Phone.APN_TYPE_ALL;
            } //End block
            {
                result = types.split(",");
            } //End block
        } //End collapsed parenthetic
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.608 -0400", hash_original_method = "25E446029D7F780B1E04F89AE12B062D", hash_generated_method = "9B68082A88D88BC5D359DDAE35C29642")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ArrayList<ApnSetting> createApnList(Cursor cursor) {
        dsTaint.addTaint(cursor.dsTaint);
        ArrayList<ApnSetting> result;
        result = new ArrayList<ApnSetting>();
        {
            boolean var445CF6247CB476E157B6738CE3BD5910_496732536 = (cursor.moveToFirst());
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
                    boolean var916090E1B2D032E1EC67FFC8B3451FBE_730928994 = (cursor.moveToNext());
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        log("createApnList: X result=" + result);
        return (ArrayList<ApnSetting>)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.614 -0400", hash_original_method = "2E87B4CBA5BF77A80284005F43D6FB91", hash_generated_method = "55E34914D53560A0F9F55E254CF1D1EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean dataConnectionNotInUse(DataConnectionAc dcac) {
        dsTaint.addTaint(dcac.dsTaint);
        {
            Iterator<ApnContext> var9CD107E7BA0F92F9952456E34FCCDBF9_718871372 = (mApnContexts.values()).iterator();
            var9CD107E7BA0F92F9952456E34FCCDBF9_718871372.hasNext();
            ApnContext apnContext = var9CD107E7BA0F92F9952456E34FCCDBF9_718871372.next();
            {
                {
                    boolean var9070B85FEFA5513E0174013C4F0F50BF_1395180341 = (apnContext.getDataConnectionAc() == dcac);
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //for (ApnContext apnContext : mApnContexts.values()) {
            //if (apnContext.getDataConnectionAc() == dcac) return false;
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.619 -0400", hash_original_method = "871B8246FCDE157C8EBBD019FC69C7EE", hash_generated_method = "26B169962D36B7F0F232A802AEB82A5A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private GsmDataConnection findFreeDataConnection() {
        {
            Iterator<DataConnectionAc> varEB8626173DB084FB4853115B28BD3F62_2054735049 = (mDataConnectionAsyncChannels.values()).iterator();
            varEB8626173DB084FB4853115B28BD3F62_2054735049.hasNext();
            DataConnectionAc dcac = varEB8626173DB084FB4853115B28BD3F62_2054735049.next();
            {
                {
                    boolean var2573ECF0D7C55708069274523D3C7C3C_1113974393 = (dcac.isInactiveSync() && dataConnectionNotInUse(dcac));
                    {
                        log("findFreeDataConnection: found free GsmDataConnection");
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        log("findFreeDataConnection: NO free GsmDataConnection");
        return (GsmDataConnection)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.626 -0400", hash_original_method = "9845808D61EC26568899ACA30184D52E", hash_generated_method = "96D3CFB37511B71346D1D56C9A0A0351")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected GsmDataConnection findReadyDataConnection(ApnSetting apn) {
        dsTaint.addTaint(apn.dsTaint);
        log("findReadyDataConnection: apn string <" +
                (apn!=null?(apn.toString()):"null") +">");
        {
            Iterator<DataConnectionAc> varEB8626173DB084FB4853115B28BD3F62_8831009 = (mDataConnectionAsyncChannels.values()).iterator();
            varEB8626173DB084FB4853115B28BD3F62_8831009.hasNext();
            DataConnectionAc dcac = varEB8626173DB084FB4853115B28BD3F62_8831009.next();
            {
                ApnSetting apnSetting;
                apnSetting = dcac.getApnSettingSync();
                {
                    log("findReadyDataConnection: dc apn string <" +
                         (apnSetting != null ? (apnSetting.toString()) : "null") + ">");
                } //End block
                {
                    boolean var546C0C38294DE3324D3082DFC127AE3A_1247970024 = ((apnSetting != null) && TextUtils.equals(apnSetting.toString(), apn.toString()));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return (GsmDataConnection)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.629 -0400", hash_original_method = "BBFF3626F623A28B2260A4B879BEB776", hash_generated_method = "CF9D7C6216411FE75602F60B66E74A2C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean setupData(ApnContext apnContext) {
        dsTaint.addTaint(apnContext.dsTaint);
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
            boolean varC4178D8C99BD7F6792B45CFB3EEFE060_1376719791 = (apnContext.getDataConnectionAc().getReconnectIntentSync() != null);
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
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.630 -0400", hash_original_method = "651F557B6A8D0D165E9CDD4391DC0D13", hash_generated_method = "B17DB31BD0DFCE8674F02B068963A0E4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.634 -0400", hash_original_method = "65E72951AE41561D32861B862A9CCB8A", hash_generated_method = "83A2C909AD423C7AB0031C4807C1A3D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private DataConnectionAc findDataConnectionAcByCid(int cid) {
        dsTaint.addTaint(cid);
        {
            Iterator<DataConnectionAc> varEB8626173DB084FB4853115B28BD3F62_339857328 = (mDataConnectionAsyncChannels.values()).iterator();
            varEB8626173DB084FB4853115B28BD3F62_339857328.hasNext();
            DataConnectionAc dcac = varEB8626173DB084FB4853115B28BD3F62_339857328.next();
            {
                {
                    boolean var44AE56803E65C65A63242637F17A76CE_576930482 = (dcac.getCidSync() == cid);
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return (DataConnectionAc)dsTaint.getTaint();
        // ---------- Original Method ----------
        //for (DataConnectionAc dcac : mDataConnectionAsyncChannels.values()) {
            //if (dcac.getCidSync() == cid) {
                //return dcac;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.647 -0400", hash_original_method = "3E391A4D32CF36E6E02EF7EB45223170", hash_generated_method = "85CAB4CD2347FC159EF11DF1F3D5EBE7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private List<ApnContext> findApnContextToClean(Collection<DataConnectionAc> dcacs) {
        dsTaint.addTaint(dcacs.dsTaint);
        ArrayList<ApnContext> list;
        list = new ArrayList<ApnContext>();
        {
            Iterator<ApnContext> var9CD107E7BA0F92F9952456E34FCCDBF9_1927997905 = (mApnContexts.values()).iterator();
            var9CD107E7BA0F92F9952456E34FCCDBF9_1927997905.hasNext();
            ApnContext apnContext = var9CD107E7BA0F92F9952456E34FCCDBF9_1927997905.next();
            {
                {
                    boolean varE485268814C4AFB5EDDFB3001575EFDB_33356109 = (apnContext.getState() == State.CONNECTED);
                    {
                        boolean found;
                        found = false;
                        {
                            Iterator<DataConnectionAc> varD36661AE30AFDBEDE4E14981910E8874_1409845066 = (dcacs).iterator();
                            varD36661AE30AFDBEDE4E14981910E8874_1409845066.hasNext();
                            DataConnectionAc dcac = varD36661AE30AFDBEDE4E14981910E8874_1409845066.next();
                            {
                                {
                                    boolean var0D1B2614B8B112ED60682FB66D70B775_1879385970 = (dcac == apnContext.getDataConnectionAc());
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
                                boolean var365CFE2CF50045A315EC59FCB108BE3D_1686133934 = (apnContext.getDataConnectionAc() != null);
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
        return (List<ApnContext>)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.678 -0400", hash_original_method = "2CAD8F6019A6EE1B4B77B4750A278A68", hash_generated_method = "0FD816FE10922774C3A4D78D4724C161")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void onDataStateChanged(AsyncResult ar) {
        dsTaint.addTaint(ar.dsTaint);
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
            Iterator<DataCallState> var890D5D9F35AC8194E211B756D8B449D5_1866003532 = (dataCallStates).iterator();
            var890D5D9F35AC8194E211B756D8B449D5_1866003532.hasNext();
            DataCallState dataCallState = var890D5D9F35AC8194E211B756D8B449D5_1866003532.next();
            {
                DataConnectionAc dcac;
                dcac = findDataConnectionAcByCid(dataCallState.cid);
                dataCallStateToDcac.put(dataCallState, dcac);
            } //End block
        } //End collapsed parenthetic
        List<ApnContext> apnsToCleanup;
        apnsToCleanup = findApnContextToClean(dataCallStateToDcac.values());
        {
            Iterator<DataCallState> varBAD99AA6F7F24D65A5EC2CF095E57993_116116799 = (dataCallStates).iterator();
            varBAD99AA6F7F24D65A5EC2CF095E57993_116116799.hasNext();
            DataCallState newState = varBAD99AA6F7F24D65A5EC2CF095E57993_116116799.next();
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
                    ApnContext apnContext = apns[0];
                    {
                        {
                            boolean var7D51A9C3981F8C57F447F4E083C1733A_782766590 = (apnContext.getState() == State.CONNECTED ||
                       apnContext.getState() == State.CONNECTING ||
                       apnContext.getState() == State.INITING);
                            {
                                connectedApns.add(apnContext);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var5000E345BB413FFA3E31E234111713FF_1500606123 = (connectedApns.size() == 0);
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
                                boolean var1B3E4D2CD1EAEB2455EA2C214D755032_2126442432 = (result.oldLp.equals(result.newLp));
                                {
                                    log("onDataStateChanged(ar): no change");
                                } //End block
                                {
                                    {
                                        boolean var74AB4D1C511598866AA9D48139B76D67_558554421 = (result.oldLp.isIdenticalInterfaceName(result.newLp));
                                        {
                                            {
                                                boolean var7DF81F5C5F07963E97224562298FE75A_2050169740 = (! result.oldLp.isIdenticalDnses(result.newLp) ||
                                    ! result.oldLp.isIdenticalRoutes(result.newLp) ||
                                    ! result.oldLp.isIdenticalHttpProxy(result.newLp) ||
                                    ! result.oldLp.isIdenticalAddresses(result.newLp));
                                                {
                                                    CompareResult<LinkAddress> car;
                                                    car = result.oldLp.compareAddresses(result.newLp);
                                                    boolean needToClean;
                                                    needToClean = false;
                                                    {
                                                        Iterator<LinkAddress> var23B27F8B5241376F0116E88BAF37B0B8_389562299 = (car.added).iterator();
                                                        var23B27F8B5241376F0116E88BAF37B0B8_389562299.hasNext();
                                                        LinkAddress added = var23B27F8B5241376F0116E88BAF37B0B8_389562299.next();
                                                        {
                                                            {
                                                                LinkAddress removed = car.removed[0];
                                                                {
                                                                    {
                                                                        boolean varB57B56F1E352D523157536C76D64F31A_994179649 = (NetworkUtils.addressTypeMatches(removed.getAddress(),
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
                                                            ApnContext apnContext = connectedApns[0];
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
            boolean varAC8520286CDD2B23D82BD3D80BB8D83D_1037640146 = (apnsToCleanup.size() != 0);
            {
                int cid;
                cid = getCellLocationId();
                EventLog.writeEvent(EventLogTags.PDP_NETWORK_DROP, cid,
                                TelephonyManager.getDefault().getNetworkType());
            } //End block
        } //End collapsed parenthetic
        {
            Iterator<ApnContext> varAED058FB30F7183EC8FD798F4A2CC59E_209628206 = (apnsToCleanup).iterator();
            varAED058FB30F7183EC8FD798F4A2CC59E_209628206.hasNext();
            ApnContext apnContext = varAED058FB30F7183EC8FD798F4A2CC59E_209628206.next();
            {
                cleanUpConnection(true, apnContext);
            } //End block
        } //End collapsed parenthetic
        log("onDataStateChanged(ar): X");
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.679 -0400", hash_original_method = "13971E1D1E8CA80CAFB744C7A0A3E07F", hash_generated_method = "5EE1787F5E8EE5223DEBEF2AB49E9188")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void notifyDefaultData(ApnContext apnContext) {
        dsTaint.addTaint(apnContext.dsTaint);
        {
            log("notifyDefaultData: type=" + apnContext.getApnType()
                + ", reason:" + apnContext.getReason());
        } //End block
        apnContext.setState(State.CONNECTED);
        mPhone.notifyDataConnection(apnContext.getReason(), apnContext.getApnType());
        startNetStatPoll();
        startDataStallAlarm(DATA_STALL_NOT_SUSPECTED);
        apnContext.getDataConnection().resetRetryCount();
        // ---------- Original Method ----------
        //if (DBG) {
            //log("notifyDefaultData: type=" + apnContext.getApnType()
                //+ ", reason:" + apnContext.getReason());
        //}
        //apnContext.setState(State.CONNECTED);
        //mPhone.notifyDataConnection(apnContext.getReason(), apnContext.getApnType());
        //startNetStatPoll();
        //startDataStallAlarm(DATA_STALL_NOT_SUSPECTED);
        //apnContext.getDataConnection().resetRetryCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.679 -0400", hash_original_method = "06C0A537C422D51FEBC3A4D7FED033FC", hash_generated_method = "DB5A9DD6D57BC4AB5482EBBDB36DC2AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void gotoIdleAndNotifyDataConnection(String reason) {
        dsTaint.addTaint(reason);
        log("gotoIdleAndNotifyDataConnection: reason=" + reason);
        notifyDataConnection(reason);
        mActiveApn = null;
        // ---------- Original Method ----------
        //if (DBG) log("gotoIdleAndNotifyDataConnection: reason=" + reason);
        //notifyDataConnection(reason);
        //mActiveApn = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.680 -0400", hash_original_method = "E0A0A9601ED58F14AFBBF23896E64411", hash_generated_method = "B15AEEE94D49A3A4F6A6C846243A9553")
    @DSModeled(DSC.SAFE)
    private void resetPollStats() {
        mTxPkts = -1;
        mRxPkts = -1;
        mNetStatPollPeriod = POLL_NETSTAT_MILLIS;
        // ---------- Original Method ----------
        //mTxPkts = -1;
        //mRxPkts = -1;
        //mNetStatPollPeriod = POLL_NETSTAT_MILLIS;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.680 -0400", hash_original_method = "85BF013ED3EA874C77BCE8B69E224FC2", hash_generated_method = "DD29F17489549970931A35C1CDFF47A8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void doRecovery() {
        {
            boolean varD6A7948C24B6C2236B4862C980AEEE69_1212692672 = (getOverallState() == State.CONNECTED);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.681 -0400", hash_original_method = "6E590AA3974E9F6C1EEF78A59E60FE7C", hash_generated_method = "EC98F229C7B7719E755C8CBBBDC49677")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void startNetStatPoll() {
        {
            boolean var4E0798726B6E95AA9A651DC17C8A16FD_884559908 = (getOverallState() == State.CONNECTED && mNetStatPollEnabled == false);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.681 -0400", hash_original_method = "A8EA63C8FD8E985352F3B26222CD114C", hash_generated_method = "95EAC4FD2FEFFA5C54BF4D45F2043A3F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.681 -0400", hash_original_method = "7B64E8A50E5FAE405E2B8EDB2C4EA1BE", hash_generated_method = "BD1853EBBC82788F1B29C0451ECD6E7A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.682 -0400", hash_original_method = "A7D682C6BB5AE30439F13EEA2F18409A", hash_generated_method = "DD427A5F0D8A68F7F4E5EB31288AB1F6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
                boolean var7C0CC8ECFFCEF537CCFB463FE517A260_1277478814 = (SystemProperties.getBoolean("radio.test.data.stall", false));
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
                boolean varC70CC77B08458828B44DBD70EF60D18F_1481122904 = (mPhone.getState() == Phone.State.IDLE);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.683 -0400", hash_original_method = "8537D637F246437B66DEDCE9BA149189", hash_generated_method = "F86A64FACE8B0D5B809A3B611A0B90E0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onDataStallAlarm(int tag) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(tag);
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
        boolean suspectedStall;
        suspectedStall = DATA_STALL_NOT_SUSPECTED;
        {
            {
                log("onDataStallAlarm: tag=" + tag + " do recovery action=" + getRecoveryAction());
            } //End block
            suspectedStall = DATA_STALL_SUSPECTED;
            sendMessage(obtainMessage(EVENT_DO_RECOVERY));
        } //End block
        {
            {
                log("onDataStallAlarm: tag=" + tag + " Sent " + String.valueOf(mSentSinceLastRecv) +
                    " pkts since last received, < watchdogTrigger=" + hangWatchdogTrigger);
            } //End block
        } //End block
        startDataStallAlarm(suspectedStall);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.683 -0400", hash_original_method = "94396473B615B857A09FF1389DF39C19", hash_generated_method = "1CCF070327F8D3EA84700E3C17DB300B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.684 -0400", hash_original_method = "2F0F0316C5E4D930E75010F1BAA9D392", hash_generated_method = "349003FDC817FC67B6E5D9E83937BA41")
    @DSModeled(DSC.SAFE)
    private boolean shouldPostNotification(GsmDataConnection.FailCause  cause) {
        dsTaint.addTaint(cause.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (cause != GsmDataConnection.FailCause.UNKNOWN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.685 -0400", hash_original_method = "62A24BB1F647222AA978F8E837B2D330", hash_generated_method = "1BDC894D3A2D618212561D9A8DB8A497")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean retryAfterDisconnected(String reason) {
        dsTaint.addTaint(reason);
        boolean retry;
        retry = true;
        {
            boolean var3CB82CF3031EDB1F7F9E067EE7B1B74E_1208746734 = (Phone.REASON_RADIO_TURNED_OFF.equals(reason));
            {
                retry = false;
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean retry = true;
        //if ( Phone.REASON_RADIO_TURNED_OFF.equals(reason) ) {
            //retry = false;
        //}
        //return retry;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.686 -0400", hash_original_method = "B5DAD52C5259D76162A701D0CC3F0E5D", hash_generated_method = "493AC0FF376F04C550D427C540AC70B6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void reconnectAfterFail(FailCause lastFailCauseCode,
                                    ApnContext apnContext, int retryOverride) {
        dsTaint.addTaint(apnContext.dsTaint);
        dsTaint.addTaint(retryOverride);
        dsTaint.addTaint(lastFailCauseCode.dsTaint);
        {
            loge("reconnectAfterFail: apnContext == null, impossible");
        } //End block
        {
            boolean var30FA7C33083B1EC6F834026AE8058702_696141517 = ((apnContext.getState() == State.FAILED) &&
            (apnContext.getDataConnection() != null));
            {
                {
                    boolean varE5EB462BBE8443D160BD1FB45CF7935B_2122565776 = (!apnContext.getDataConnection().isRetryNeeded());
                    {
                        {
                            boolean var922F49E2215CF7A16F73F26F0F3737B6_1039669919 = (!apnContext.getApnType().equals(Phone.APN_TYPE_DEFAULT));
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
                    boolean var2A1839E9F3FAB784CE5EE5D4D0AE0D4B_1325649659 = (!shouldPostNotification(lastFailCauseCode));
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.686 -0400", hash_original_method = "68704E7FD0A79E29C0B17E36042D228F", hash_generated_method = "0219BAF65891F385EE66005DBA400A3B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void startAlarmForReconnect(int delay, ApnContext apnContext) {
        dsTaint.addTaint(apnContext.dsTaint);
        dsTaint.addTaint(delay);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.687 -0400", hash_original_method = "B93C86D6B627A29FECBAD17E305E1155", hash_generated_method = "27A23D7D5D92AB817AE4B146238AE5D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void startDataStallAlarm(boolean suspectedStall) {
        dsTaint.addTaint(suspectedStall);
        int nextAction;
        nextAction = getRecoveryAction();
        int delayInMs;
        {
            boolean varD018D692F7838A2441A89F15D54C03D1_2014592452 = (mIsScreenOn || suspectedStall || RecoveryAction.isAggressiveRecovery(nextAction));
            {
                delayInMs = Settings.Secure.getInt(mResolver,
                                       Settings.Secure.DATA_STALL_ALARM_AGGRESSIVE_DELAY_IN_MS,
                                       DATA_STALL_ALARM_AGGRESSIVE_DELAY_IN_MS_DEFAULT);
            } //End block
            {
                delayInMs = Settings.Secure.getInt(mResolver,
                                       Settings.Secure.DATA_STALL_ALARM_NON_AGGRESSIVE_DELAY_IN_MS,
                                       DATA_STALL_ALARM_NON_AGGRESSIVE_DELAY_IN_MS_DEFAULT);
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.687 -0400", hash_original_method = "9CFC369C9AE6A2831F865DCDD5760991", hash_generated_method = "3895AC549DC097BA38353904DAE5AB35")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        //if (VDBG) {
            //log("stopDataStallAlarm: current tag=" + mDataStallAlarmTag +
                    //" mDataStallAlarmIntent=" + mDataStallAlarmIntent);
        //}
        //mDataStallAlarmTag += 1;
        //if (mDataStallAlarmIntent != null) {
            //am.cancel(mDataStallAlarmIntent);
            //mDataStallAlarmIntent = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.689 -0400", hash_original_method = "E11588DBC7CAEA40F234C97E128BA9F7", hash_generated_method = "0EB29CD27ECABC20F8961E04A77CCADB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void restartDataStallAlarm() {
        int nextAction;
        nextAction = getRecoveryAction();
        {
            boolean var3CFFE8B1C66F5EC88FB8D3538439D606_2027907582 = (RecoveryAction.isAggressiveRecovery(nextAction));
            {
                log("data stall recovery action is pending. not resetting the alarm.");
            } //End block
        } //End collapsed parenthetic
        stopDataStallAlarm();
        startDataStallAlarm(DATA_STALL_NOT_SUSPECTED);
        // ---------- Original Method ----------
        //int nextAction = getRecoveryAction();
        //if (RecoveryAction.isAggressiveRecovery(nextAction)) {
            //if (DBG) log("data stall recovery action is pending. not resetting the alarm.");
            //return;
        //}
        //stopDataStallAlarm();
        //startDataStallAlarm(DATA_STALL_NOT_SUSPECTED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.689 -0400", hash_original_method = "B7B20E847D290047FDFE77B8D734C484", hash_generated_method = "8C7348C79162672D81F2D98253743F45")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void notifyNoData(GsmDataConnection.FailCause lastFailCauseCode,
                              ApnContext apnContext) {
        dsTaint.addTaint(apnContext.dsTaint);
        dsTaint.addTaint(lastFailCauseCode.dsTaint);
        log( "notifyNoData: type=" + apnContext.getApnType());
        apnContext.setState(State.FAILED);
        {
            boolean var4EEBF6159081CCB6B98E337119003EE1_1466446275 = (lastFailCauseCode.isPermanentFail()
            && (!apnContext.getApnType().equals(Phone.APN_TYPE_DEFAULT)));
            {
                mPhone.notifyDataConnectionFailed(apnContext.getReason(), apnContext.getApnType());
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (DBG) log( "notifyNoData: type=" + apnContext.getApnType());
        //apnContext.setState(State.FAILED);
        //if (lastFailCauseCode.isPermanentFail()
            //&& (!apnContext.getApnType().equals(Phone.APN_TYPE_DEFAULT))) {
            //mPhone.notifyDataConnectionFailed(apnContext.getReason(), apnContext.getApnType());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.689 -0400", hash_original_method = "E0D6F2F660096B71ECF89DBFFFD7E4A9", hash_generated_method = "6B39F892FFDD14E7C76C6DC5FB315278")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void onRecordsLoaded() {
        log("onRecordsLoaded: createAllApnList");
        createAllApnList();
        {
            boolean varBF6B2CF5258A9CC53BF3EF6E8D75A257_655800471 = (mPhone.mCM.getRadioState().isOn());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.690 -0400", hash_original_method = "4B71314721E8EC7414109EE47221FD04", hash_generated_method = "80F3BEA767CC8A59D4080A42F8703CC5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onSetDependencyMet(String apnType, boolean met) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(met);
        dsTaint.addTaint(apnType);
        {
            boolean var26625207EA129FA6C81C0427CE84CA93_554628110 = (Phone.APN_TYPE_HIPRI.equals(apnType));
        } //End collapsed parenthetic
        ApnContext apnContext;
        apnContext = mApnContexts.get(apnType);
        {
            loge("onSetDependencyMet: ApnContext not found in onSetDependencyMet(" +
                    apnType + ", " + met + ")");
        } //End block
        applyNewState(apnContext, apnContext.isEnabled(), met);
        {
            boolean var9DC01820B4CF39C526DE14A3F8F65164_1024899028 = (Phone.APN_TYPE_DEFAULT.equals(apnType));
            {
                apnContext = mApnContexts.get(Phone.APN_TYPE_HIPRI);
                applyNewState(apnContext, apnContext.isEnabled(), met);
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.690 -0400", hash_original_method = "99E85476A8EB35B364BDD45037DA3C4C", hash_generated_method = "329D92E69F258CC68B59A340F01F8E4E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void applyNewState(ApnContext apnContext, boolean enabled, boolean met) {
        dsTaint.addTaint(met);
        dsTaint.addTaint(enabled);
        dsTaint.addTaint(apnContext.dsTaint);
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
            boolean var71D7772E371594A9E183FDA441CA7053_253872879 = (apnContext.isReady());
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
                        boolean varD838083F139117E3D29CE4817418915A_1941285666 = (apnContext.isEnabled());
                        {
                            apnContext.setReason(Phone.REASON_DATA_DEPENDENCY_MET);
                        } //End block
                        {
                            apnContext.setReason(Phone.REASON_DATA_ENABLED);
                        } //End block
                    } //End collapsed parenthetic
                    {
                        boolean var8C3F5A245E8CD46D727CA60CA79AEBA0_1033889657 = (apnContext.getState() == State.FAILED);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.702 -0400", hash_original_method = "CD0E8AA9DA59D5F15CB3DBA9C10480A3", hash_generated_method = "2F35744FB066F75208BE00F4A00EE00F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private DataConnection checkForConnectionForApnContext(ApnContext apnContext) {
        dsTaint.addTaint(apnContext.dsTaint);
        String apnType;
        apnType = apnContext.getApnType();
        ApnSetting dunSetting;
        dunSetting = null;
        {
            boolean var733FD876202A992F48D44A26A7FD0196_33206879 = (Phone.APN_TYPE_DUN.equals(apnType));
            {
                dunSetting = fetchDunApn();
            } //End block
        } //End collapsed parenthetic
        {
            Iterator<ApnContext> var6DC0F8F93D4890C09FB88A4F42664788_1352722370 = (mApnContexts.values()).iterator();
            var6DC0F8F93D4890C09FB88A4F42664788_1352722370.hasNext();
            ApnContext c = var6DC0F8F93D4890C09FB88A4F42664788_1352722370.next();
            {
                DataConnection conn;
                conn = c.getDataConnection();
                {
                    ApnSetting apnSetting;
                    apnSetting = c.getApnSetting();
                    {
                        {
                            boolean var8C1D5273F63F2A795463E07E2AA32767_288836182 = (dunSetting.equals(apnSetting));
                            {
                                {
                                    log("checkForConnectionForApnContext: apnContext=" + apnContext +
                                    " found conn=" + conn);
                                } //End block
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        boolean var9D1B5F46420F9179EBDCA60D125A22B4_683423863 = (apnSetting != null && apnSetting.canHandleType(apnType));
                        {
                            {
                                log("checkForConnectionForApnContext: apnContext=" + apnContext +
                                " found conn=" + conn);
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End collapsed parenthetic
        log("checkForConnectionForApnContext: apnContext=" + apnContext + " NO conn");
        return (DataConnection)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.703 -0400", hash_original_method = "C4FAA9463FB18AA2956D630E0A7A0FC4", hash_generated_method = "3DC73DF09D1812671B9720A30DDA6CE1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onEnableApn(int apnId, int enabled) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(enabled);
        dsTaint.addTaint(apnId);
        ApnContext apnContext;
        apnContext = mApnContexts.get(apnIdToType(apnId));
        {
            loge("onEnableApn(" + apnId + ", " + enabled + "): NO ApnContext");
        } //End block
        log("onEnableApn: apnContext=" + apnContext + " call applyNewState");
        applyNewState(apnContext, enabled == ENABLED, apnContext.getDependencyMet());
        // ---------- Original Method ----------
        //ApnContext apnContext = mApnContexts.get(apnIdToType(apnId));
        //if (apnContext == null) {
            //loge("onEnableApn(" + apnId + ", " + enabled + "): NO ApnContext");
            //return;
        //}
        //if (DBG) log("onEnableApn: apnContext=" + apnContext + " call applyNewState");
        //applyNewState(apnContext, enabled == ENABLED, apnContext.getDependencyMet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.704 -0400", hash_original_method = "885166865223FFC382706A95C40269FC", hash_generated_method = "0FDF369DAC73BA99EBA4585125264BBC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean onTrySetupData(String reason) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(reason);
        log("onTrySetupData: reason=" + reason);
        setupDataOnReadyApns(reason);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (DBG) log("onTrySetupData: reason=" + reason);
        //setupDataOnReadyApns(reason);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.704 -0400", hash_original_method = "0F081CC5E381F07585D5A8591D9B8176", hash_generated_method = "F726AF3758078E2FD5E41D9DFFB109C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean onTrySetupData(ApnContext apnContext) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(apnContext.dsTaint);
        log("onTrySetupData: apnContext=" + apnContext);
        boolean varD10E5DDD0548397420B754E479BF3D26_650305312 = (trySetupData(apnContext));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (DBG) log("onTrySetupData: apnContext=" + apnContext);
        //return trySetupData(apnContext);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.705 -0400", hash_original_method = "94279F194E7EEE60FDEB34DD3123F420", hash_generated_method = "66C2F4B2BF3CFD8E872445E054AAA2DD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onRoamingOff() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        log("onRoamingOff");
        {
            boolean var6A4EDF3FAFEE8B58E0E885094E7C645E_1370248065 = (getDataOnRoamingEnabled() == false);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.706 -0400", hash_original_method = "F695F1E8C2AB53D2ED55D91C043A1972", hash_generated_method = "C5FFDD0B393A858B5E76E5938F1DB0D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onRoamingOn() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var178FD459AA12B1549B96EFDE7D504A27_680157532 = (getDataOnRoamingEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.707 -0400", hash_original_method = "2023A2D13D03549C0A5EFF7393A0A72A", hash_generated_method = "BAF45E65BF8A16A7F548D6A284B460F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onRadioAvailable() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        log("onRadioAvailable");
        {
            boolean varA62B422C35237A9A4A0C0A75D57190F8_451099365 = (mPhone.getSimulatedRadioControl() != null);
            {
                notifyDataConnection(null);
                log("onRadioAvailable: We're on the simulator; assuming data is connected");
            } //End block
        } //End collapsed parenthetic
        {
            boolean varBF0727A83B7DC3B32BB422410729B3B0_959816737 = (mPhone.mIccRecords.getRecordsLoaded());
            {
                notifyOffApnsOfAvailability(null);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var7B94654969E16A4794216154E8FB917C_564075839 = (getOverallState() != State.IDLE);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.714 -0400", hash_original_method = "3A8D622B44F84A55C5B45212A617D18F", hash_generated_method = "841C7BF911EBE75E5F73F38D594EBADA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onRadioOffOrNotAvailable() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            Iterator<DataConnection> var8D54139306CE59DA2A79305B93065ACC_995792246 = (mDataConnections.values()).iterator();
            var8D54139306CE59DA2A79305B93065ACC_995792246.hasNext();
            DataConnection dc = var8D54139306CE59DA2A79305B93065ACC_995792246.next();
            {
                dc.resetRetryCount();
            } //End block
        } //End collapsed parenthetic
        mReregisterOnReconnectFailure = false;
        {
            boolean varA62B422C35237A9A4A0C0A75D57190F8_579507895 = (mPhone.getSimulatedRadioControl() != null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.716 -0400", hash_original_method = "D16E9D0E751B364A620376A0BED0AC69", hash_generated_method = "F571A9BCB56DD76ECCFEAE699F3DB403")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onDataSetupComplete(AsyncResult ar) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(ar.dsTaint);
        DataConnection.FailCause cause;
        cause = DataConnection.FailCause.UNKNOWN;
        boolean handleError;
        handleError = false;
        ApnContext apnContext;
        apnContext = null;
        {
            apnContext = (ApnContext)ar.userObj;
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("onDataSetupComplete: No apnContext");
        } //End block
        {
            boolean varB5E9B7D9BBFA45BCF027FCB550EA1FBB_916703706 = (isDataSetupCompleteOk(ar));
            {
                DataConnectionAc dcac;
                dcac = apnContext.getDataConnectionAc();
                {
                    ContentResolver cr;
                    cr = mPhone.getContext().getContentResolver();
                    String radioTestProperty;
                    radioTestProperty = "radio.test.onDSC.null.dcac";
                    {
                        boolean var6C3937B55D6D7EDEF84E3ED188776B0A_133580796 = (Settings.System.getInt(cr, radioTestProperty, 0) == 1);
                        {
                            log("onDataSetupComplete: " + radioTestProperty +
                            " is true, set dcac to null and reset property to false");
                            dcac = null;
                            Settings.System.putInt(cr, radioTestProperty, 0);
                            log("onDataSetupComplete: " + radioTestProperty + "=" +
                            Settings.System.getInt(mPhone.getContext().getContentResolver(),
                                    radioTestProperty, -1));
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    log("onDataSetupComplete: no connection to DC, handle as error");
                    cause = DataConnection.FailCause.CONNECTION_TO_DATACONNECTIONAC_BROKEN;
                    handleError = true;
                } //End block
                {
                    DataConnection dc;
                    dc = apnContext.getDataConnection();
                    {
                        String apnStr;
                        apnStr = "<unknown>";
                        {
                            boolean varC629FF2D56F30F97D28AAEA2BB960F70_897418913 = (apnContext.getWaitingApns() != null
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
                        boolean varD0AB2DD6D799FBD1D915F41811B7BABA_1684451628 = (apn.proxy != null && apn.proxy.length() != 0);
                        {
                            try 
                            {
                                String port;
                                port = apn.port;
                                {
                                    boolean var1EEA344F651B3003AA69616F7B2E12D8_272641636 = (TextUtils.isEmpty(port));
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
                        boolean var246254CF6FAEFDB9014D4C528A756DE8_1607766974 = (TextUtils.equals(apnContext.getApnType(),Phone.APN_TYPE_DEFAULT));
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
            } //End block
            {
                String apnString;
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
                    boolean var70C8C044708A6E33F44340F8299B6975_1593019805 = (cause.isEventLoggable());
                    {
                        int cid;
                        cid = getCellLocationId();
                        EventLog.writeEvent(EventLogTags.PDP_SETUP_FAIL,
                        cause.ordinal(), cid, TelephonyManager.getDefault().getNetworkType());
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var66182ADBA155CABC56AA3975E9DBF19F_246296001 = (cause.isPermanentFail());
                    apnContext.decWaitingApnsPermFailCount();
                } //End collapsed parenthetic
                apnContext.removeNextWaitingApn();
                {
                    log(String.format("onDataSetupComplete: WaitingApns.size=%d" +
                        " WaitingApnsPermFailureCountDown=%d",
                        apnContext.getWaitingApns().size(),
                        apnContext.getWaitingApnsPermFailCount()));
                } //End block
                handleError = true;
            } //End block
        } //End collapsed parenthetic
        {
            {
                boolean var25064B015FAE3D1F07E0BF83B505BDD4_1814697538 = (apnContext.getWaitingApns().isEmpty());
                {
                    {
                        boolean var3C7E233370953E5404DE069D13931ABA_1642929612 = (apnContext.getWaitingApnsPermFailCount() == 0);
                        {
                            {
                                log("onDataSetupComplete: All APN's had permanent failures, stop retrying");
                            } //End block
                            apnContext.setState(State.FAILED);
                            mPhone.notifyDataConnection(Phone.REASON_APN_FAILED, apnContext.getApnType());
                            apnContext.setDataConnection(null);
                            apnContext.setDataConnectionAc(null);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.718 -0400", hash_original_method = "D4180B029AFCA66C11673889FF654292", hash_generated_method = "A54EBEBCD6828E5F0984B58C8957EAF8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onDisconnectDone(int connId, AsyncResult ar) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(connId);
        dsTaint.addTaint(ar.dsTaint);
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
            boolean var786CBED095C8588B57078CC7EF2AF454_162702781 = (isDisconnected());
            {
                {
                    boolean var846205B09CBBB48260D2ACA57A03090A_157907830 = (mPhone.getServiceStateTracker().processPendingRadioPowerOffAfterDataOff());
                    {
                        apnContext.setApnSetting(null);
                        apnContext.setDataConnection(null);
                        apnContext.setDataConnectionAc(null);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean var8F8F15CFAD1D995C4B76EF8FCB948AA5_939527787 = (apnContext.isReady() && retryAfterDisconnected(apnContext.getReason()));
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.721 -0400", hash_original_method = "F62EA026E4AEAA1F320C05AA5A1ED4A9", hash_generated_method = "D438F93EC76D0C9800FEEE674160A65C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void onPollPdp() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean varD6A7948C24B6C2236B4862C980AEEE69_295733433 = (getOverallState() == State.CONNECTED);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.722 -0400", hash_original_method = "7D6F87E7A2D5372F8DAAC4AE4D373312", hash_generated_method = "F2AF4BDE36538D3E787B46BBE1F89639")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onVoiceCallStarted() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        log("onVoiceCallStarted");
        {
            boolean var457C185A27A25C3794C4F48127E1858B_2048192345 = (isConnected() && ! mPhone.getServiceStateTracker().isConcurrentVoiceAndDataAllowed());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.722 -0400", hash_original_method = "E17A71140CA37F7A1735220B212ECBE3", hash_generated_method = "B2574096682D8D1E5FC57F30B980BC30")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onVoiceCallEnded() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        log("onVoiceCallEnded");
        {
            boolean var5153987C55DB41759ADC1D7527E9459D_2047746590 = (isConnected());
            {
                {
                    boolean var52415700B3EB5881C35C2B7439253DD7_640072707 = (!mPhone.getServiceStateTracker().isConcurrentVoiceAndDataAllowed());
                    {
                        startNetStatPoll();
                        startDataStallAlarm(DATA_STALL_NOT_SUSPECTED);
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
                //startDataStallAlarm(DATA_STALL_NOT_SUSPECTED);
                //notifyDataConnection(Phone.REASON_VOICE_CALL_ENDED);
            //} else {
                //resetPollStats();
            //}
        //} else {
            //setupDataOnReadyApns(Phone.REASON_VOICE_CALL_ENDED);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.723 -0400", hash_original_method = "2BB2576C993A3562ED602CBB829AED3C", hash_generated_method = "1C770EFD91612EFA867ECA89246FB01C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onCleanUpConnection(boolean tearDown, int apnId, String reason) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(reason);
        dsTaint.addTaint(apnId);
        dsTaint.addTaint(tearDown);
        log("onCleanUpConnection");
        ApnContext apnContext;
        apnContext = mApnContexts.get(apnIdToType(apnId));
        {
            apnContext.setReason(reason);
            cleanUpConnection(tearDown, apnContext);
        } //End block
        // ---------- Original Method ----------
        //if (DBG) log("onCleanUpConnection");
        //ApnContext apnContext = mApnContexts.get(apnIdToType(apnId));
        //if (apnContext != null) {
            //apnContext.setReason(reason);
            //cleanUpConnection(tearDown, apnContext);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.729 -0400", hash_original_method = "F3A5D3BC82C41DBBBC23CC041FBF5A0E", hash_generated_method = "12DBE25A8455A27636FC1C13E8CACBD3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean isConnected() {
        {
            Iterator<ApnContext> var9CD107E7BA0F92F9952456E34FCCDBF9_1971969888 = (mApnContexts.values()).iterator();
            var9CD107E7BA0F92F9952456E34FCCDBF9_1971969888.hasNext();
            ApnContext apnContext = var9CD107E7BA0F92F9952456E34FCCDBF9_1971969888.next();
            {
                {
                    boolean varE485268814C4AFB5EDDFB3001575EFDB_884806744 = (apnContext.getState() == State.CONNECTED);
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //for (ApnContext apnContext : mApnContexts.values()) {
            //if (apnContext.getState() == State.CONNECTED) {
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.734 -0400", hash_original_method = "82B1D5E02818D0100BE3FB5300291D89", hash_generated_method = "99566CE9A95AE2074ABFFED171E6E1DD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isDisconnected() {
        {
            Iterator<ApnContext> var9CD107E7BA0F92F9952456E34FCCDBF9_1971364575 = (mApnContexts.values()).iterator();
            var9CD107E7BA0F92F9952456E34FCCDBF9_1971364575.hasNext();
            ApnContext apnContext = var9CD107E7BA0F92F9952456E34FCCDBF9_1971364575.next();
            {
                {
                    boolean varBE5D0A772BCE39989337B7BA0425FA24_1603392327 = (!apnContext.isDisconnected());
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //for (ApnContext apnContext : mApnContexts.values()) {
            //if (!apnContext.isDisconnected()) {
                //return false;
            //}
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.743 -0400", hash_original_method = "85B9B626BCFF754F4C98AF3615661037", hash_generated_method = "E466344F6685D126419D1ACB0939A7E5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void notifyDataConnection(String reason) {
        dsTaint.addTaint(reason);
        log("notifyDataConnection: reason=" + reason);
        {
            Iterator<ApnContext> var9CD107E7BA0F92F9952456E34FCCDBF9_246644816 = (mApnContexts.values()).iterator();
            var9CD107E7BA0F92F9952456E34FCCDBF9_246644816.hasNext();
            ApnContext apnContext = var9CD107E7BA0F92F9952456E34FCCDBF9_246644816.next();
            {
                {
                    boolean varF0467FF71AC99F0BE559C0B01AC11D76_495083698 = (apnContext.isReady());
                    {
                        log("notifyDataConnection: type:"+apnContext.getApnType());
                        mPhone.notifyDataConnection(reason != null ? reason : apnContext.getReason(),
                        apnContext.getApnType());
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        notifyOffApnsOfAvailability(reason);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.743 -0400", hash_original_method = "FAE53DB9273E730E3BB3527C1EA0C82D", hash_generated_method = "7A4C5387FE9BE4D7D9881E84DAAFBCFA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
                    boolean var6498CD0999E209A4A0BE7E263562F997_519405965 = (cursor.getCount() > 0);
                    {
                        mAllApns = createApnList(cursor);
                    } //End block
                } //End collapsed parenthetic
                cursor.close();
            } //End block
        } //End block
        {
            boolean var20904D2BF548C0A6496A2E4B42EE1318_1676302197 = (mAllApns.isEmpty());
            {
                log("createAllApnList: No APN found for carrier: " + operator);
                mPreferredApn = null;
            } //End block
            {
                mPreferredApn = getPreferredApn();
                {
                    boolean var13AFC7FCEAEC4340EFADEAB1DEAC5B7B_676427498 = (mPreferredApn != null && !mPreferredApn.numeric.equals(operator));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.744 -0400", hash_original_method = "D852CA0D301C451CEC71F89E8253F809", hash_generated_method = "2349A77B566B36786928AD5B07E25789")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private GsmDataConnection createDataConnection() {
        log("createDataConnection E");
        RetryManager rm;
        rm = new RetryManager();
        int id;
        id = mUniqueIdGenerator.getAndIncrement();
        GsmDataConnection conn;
        conn = GsmDataConnection.makeDataConnection(mPhone, id, rm, this);
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
        return (GsmDataConnection)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.744 -0400", hash_original_method = "E3018B8151F871DAB6348A26AB9C8E22", hash_generated_method = "80624ADEF7F18907928661E3B8E08295")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void configureRetry(DataConnection dc, boolean forDefault) {
        dsTaint.addTaint(dc.dsTaint);
        dsTaint.addTaint(forDefault);
        {
            boolean var37AECCB3C8FAA31888C49CC20AC6C0E3_269415779 = (!dc.configureRetry(getReryConfig(forDefault)));
            {
                {
                    {
                        boolean varFFEFB308EB1258042E3805C355CEE781_601557384 = (!dc.configureRetry(DEFAULT_DATA_RETRY_CONFIG));
                        {
                            loge("configureRetry: Could not configure using " +
                            "DEFAULT_DATA_RETRY_CONFIG=" + DEFAULT_DATA_RETRY_CONFIG);
                            dc.configureRetry(20, 2000, 1000);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    {
                        boolean var4382F1220AB91F0872206EBC52B619CA_157290718 = (!dc.configureRetry(SECONDARY_DATA_RETRY_CONFIG));
                        {
                            loge("configureRetry: Could note configure using " +
                            "SECONDARY_DATA_RETRY_CONFIG=" + SECONDARY_DATA_RETRY_CONFIG);
                            dc.configureRetry("max_retries=3, 333, 333, 333");
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.744 -0400", hash_original_method = "3AA2B8847F1D4D39DED653A1D9ABBA74", hash_generated_method = "455308BA51294DCD6485094FF2A285F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.755 -0400", hash_original_method = "848BE9CB29607B1E2AFE44721BE481D7", hash_generated_method = "8F4B64BECE44260CD02395A6A89B34F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ArrayList<ApnSetting> buildWaitingApns(String requestedApnType) {
        dsTaint.addTaint(requestedApnType);
        ArrayList<ApnSetting> apnList;
        apnList = new ArrayList<ApnSetting>();
        {
            boolean varA533E6DA53DC5795B731548F019117DF_544653527 = (requestedApnType.equals(Phone.APN_TYPE_DUN));
            {
                ApnSetting dun;
                dun = fetchDunApn();
                {
                    apnList.add(dun);
                    log("buildWaitingApns: X added APN_TYPE_DUN apnList=" + apnList);
                } //End block
            } //End block
        } //End collapsed parenthetic
        String operator;
        operator = mPhone.mIccRecords.getOperatorNumeric();
        int radioTech;
        radioTech = mPhone.getServiceState().getRadioTechnology();
        {
            boolean varF99E18D293403D65F0831E88076378E8_113564418 = (requestedApnType.equals(Phone.APN_TYPE_DEFAULT));
            {
                {
                    {
                        log("buildWaitingApns: Preferred APN:" + operator + ":"
                        + mPreferredApn.numeric + ":" + mPreferredApn);
                    } //End block
                    {
                        boolean var856A96AD897866EDDA41D8E0648BCB11_55144348 = (mPreferredApn.numeric.equals(operator));
                        {
                            {
                                apnList.add(mPreferredApn);
                                log("buildWaitingApns: X added preferred apnList=" + apnList);
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
                Iterator<ApnSetting> var02F4BAA28E3266E2CCAC36540E0DBAE4_1947319115 = (mAllApns).iterator();
                var02F4BAA28E3266E2CCAC36540E0DBAE4_1947319115.hasNext();
                ApnSetting apn = var02F4BAA28E3266E2CCAC36540E0DBAE4_1947319115.next();
                {
                    {
                        boolean varA06A3C6237577CA78B4AB7FBA1B54C4C_564737634 = (apn.canHandleType(requestedApnType));
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
        return (ArrayList<ApnSetting>)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.756 -0400", hash_original_method = "E41D316825399ADA7868FFC16CE8AB28", hash_generated_method = "8496C713757FA4C85713CA7A7BD58B3B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String apnListToString(ArrayList<ApnSetting> apns) {
        dsTaint.addTaint(apns.dsTaint);
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
        String varEA70154FDA28CC59402440C6317B57EF_901627107 = (result.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder result = new StringBuilder();
        //for (int i = 0, size = apns.size(); i < size; i++) {
            //result.append('[')
                  //.append(apns.get(i).toString())
                  //.append(']');
        //}
        //return result.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.756 -0400", hash_original_method = "3866195B872E529451BB06B2525880D5", hash_generated_method = "D1191D37D7DBEE31C2BFEAC404A282BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void startDelayedRetry(GsmDataConnection.FailCause cause,
                                   ApnContext apnContext, int retryOverride) {
        dsTaint.addTaint(apnContext.dsTaint);
        dsTaint.addTaint(cause.dsTaint);
        dsTaint.addTaint(retryOverride);
        notifyNoData(cause, apnContext);
        reconnectAfterFail(cause, apnContext, retryOverride);
        // ---------- Original Method ----------
        //notifyNoData(cause, apnContext);
        //reconnectAfterFail(cause, apnContext, retryOverride);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.756 -0400", hash_original_method = "22E3490C8EB6FB91490F2A1E004AD822", hash_generated_method = "E988128F9631D3DE7B4C0FE9C86CCD68")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setPreferredApn(int pos) {
        dsTaint.addTaint(pos);
        {
            log("setPreferredApn: X !canSEtPreferApn");
        } //End block
        log("setPreferredApn: delete");
        ContentResolver resolver;
        resolver = mPhone.getContext().getContentResolver();
        resolver.delete(PREFERAPN_NO_UPDATE_URI, null, null);
        {
            log("setPreferredApn: insert");
            ContentValues values;
            values = new ContentValues();
            values.put(APN_ID, pos);
            resolver.insert(PREFERAPN_NO_UPDATE_URI, values);
        } //End block
        // ---------- Original Method ----------
        //if (!canSetPreferApn) {
            //log("setPreferredApn: X !canSEtPreferApn");
            //return;
        //}
        //log("setPreferredApn: delete");
        //ContentResolver resolver = mPhone.getContext().getContentResolver();
        //resolver.delete(PREFERAPN_NO_UPDATE_URI, null, null);
        //if (pos >= 0) {
            //log("setPreferredApn: insert");
            //ContentValues values = new ContentValues();
            //values.put(APN_ID, pos);
            //resolver.insert(PREFERAPN_NO_UPDATE_URI, values);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.767 -0400", hash_original_method = "187338B4BAD9BF24F2E67FCF482C7DBA", hash_generated_method = "04EAEDD767F5923BE908C5D58D54E98E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ApnSetting getPreferredApn() {
        {
            boolean var20904D2BF548C0A6496A2E4B42EE1318_130072267 = (mAllApns.isEmpty());
            {
                log("getPreferredApn: X not found mAllApns.isEmpty");
            } //End block
        } //End collapsed parenthetic
        Cursor cursor;
        cursor = mPhone.getContext().getContentResolver().query(
                PREFERAPN_NO_UPDATE_URI, new String[] { "_id", "name", "apn" },
                null, null, Telephony.Carriers.DEFAULT_SORT_ORDER);
        {
            canSetPreferApn = true;
        } //End block
        {
            canSetPreferApn = false;
        } //End block
        {
            boolean varCD3E4FB8DC5266FE4AD30A8E880E316C_898864680 = (canSetPreferApn && cursor.getCount() > 0);
            {
                int pos;
                cursor.moveToFirst();
                pos = cursor.getInt(cursor.getColumnIndexOrThrow(Telephony.Carriers._ID));
                {
                    Iterator<ApnSetting> varA7D7DBA24E2BB41A4D22D64A1DC6CF6C_24466131 = (mAllApns).iterator();
                    varA7D7DBA24E2BB41A4D22D64A1DC6CF6C_24466131.hasNext();
                    ApnSetting p = varA7D7DBA24E2BB41A4D22D64A1DC6CF6C_24466131.next();
                    {
                        {
                            boolean var4306E6E526674BBE5742814C2949F546_1112577948 = (p.id == pos && p.canHandleType(mRequestedApnType));
                            {
                                log("getPreferredApn: X found apnSetting" + p);
                                cursor.close();
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            cursor.close();
        } //End block
        log("getPreferredApn: X not found");
        return (ApnSetting)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.768 -0400", hash_original_method = "3F5045BA8DE7525B5E4F320532794D71", hash_generated_method = "57A2F35A915E0833EA532AA650E04366")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void handleMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
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
            boolean var5153987C55DB41759ADC1D7527E9459D_813497438 = (isConnected());
            {
                startNetStatPoll();
                startDataStallAlarm(DATA_STALL_NOT_SUSPECTED);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.769 -0400", hash_original_method = "46AFDD0964E9004EF08AD58B2795A021", hash_generated_method = "6B379071D898F6624E89AE38EC257425")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected int getApnProfileID(String apnType) {
        dsTaint.addTaint(apnType);
        {
            boolean varBD5A51DA361F3966223B48A5CF932C78_1107190964 = (TextUtils.equals(apnType, Phone.APN_TYPE_IMS));
            {
                boolean varD564B10DB28FA322978443E532F7503A_633243780 = (TextUtils.equals(apnType, Phone.APN_TYPE_FOTA));
                {
                    boolean var3A4BC1B957119377C5312013BE2E7BF3_815515059 = (TextUtils.equals(apnType, Phone.APN_TYPE_CBS));
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.769 -0400", hash_original_method = "EC98DB8AAEBCEBF774D7D372A9BC5BED", hash_generated_method = "F36EA30CE1C09027E5B55EB2C9B4D2DA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.770 -0400", hash_original_method = "74A1E45944BDF6EB75FE1BB75B450C28", hash_generated_method = "7A1D43CEB645B2A395E217B2E0A098FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void log(String s) {
        dsTaint.addTaint(s);
        Log.d(LOG_TAG, "[GsmDCT] "+ s);
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[GsmDCT] "+ s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.770 -0400", hash_original_method = "F4E978940BCE74A01AFD260967E7D0F1", hash_generated_method = "B06DC2EC9AA66DB19DAB07882BF0AB18")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void loge(String s) {
        dsTaint.addTaint(s);
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[GsmDCT] " + s);
    }

    
    private class ApnChangeObserver extends ContentObserver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.770 -0400", hash_original_method = "6B7B68FCD4064976D9DFC8282278DEB2", hash_generated_method = "B25D6445CFCAAC6EBB935C2E1EA4D894")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ApnChangeObserver() {
            super(mDataConnectionTracker);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.770 -0400", hash_original_method = "C002DCEBDDA1BCF98FA65E6C3DFBEDC7", hash_generated_method = "126844261C80FA055C098D35932CF548")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void onChange(boolean selfChange) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(selfChange);
            sendMessage(obtainMessage(EVENT_APN_CHANGED));
            // ---------- Original Method ----------
            //sendMessage(obtainMessage(EVENT_APN_CHANGED));
        }

        
    }


    
    private static class RecoveryAction {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.770 -0400", hash_original_method = "905DD0277E54FF8F0334E1C17CC98F0E", hash_generated_method = "905DD0277E54FF8F0334E1C17CC98F0E")
                public RecoveryAction ()
        {
        }


                private static boolean isAggressiveRecovery(int value) {
            return ((value == RecoveryAction.CLEANUP) ||
                    (value == RecoveryAction.REREGISTER) ||
                    (value == RecoveryAction.RADIO_RESTART) ||
                    (value == RecoveryAction.RADIO_RESTART_WITH_PROP));
        }

        
        public static final int GET_DATA_CALL_LIST      = 0;
        public static final int CLEANUP                 = 1;
        public static final int REREGISTER              = 2;
        public static final int RADIO_RESTART           = 3;
        public static final int RADIO_RESTART_WITH_PROP = 4;
    }


    
    private static final boolean RADIO_TESTS = false;
    private static final int POLL_PDP_MILLIS = 5 * 1000;
    private static final String INTENT_RECONNECT_ALARM =
        "com.android.internal.telephony.gprs-reconnect";
    private static final String INTENT_RECONNECT_ALARM_EXTRA_TYPE = "type";
    private static final String INTENT_DATA_STALL_ALARM =
        "com.android.internal.telephony.gprs-data-stall";
    static final Uri PREFERAPN_NO_UPDATE_URI =
                        Uri.parse("content://telephony/carriers/preferapn_no_update");
    static final String APN_ID = "apn_id";
    private static final boolean DATA_STALL_SUSPECTED = true;
    private static final boolean DATA_STALL_NOT_SUSPECTED = false;
}

