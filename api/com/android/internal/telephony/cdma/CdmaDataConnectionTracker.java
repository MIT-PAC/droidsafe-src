package com.android.internal.telephony.cdma;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.TrafficStats;
import android.os.AsyncResult;
import android.os.Message;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.util.EventLog;
import android.util.Log;

import com.android.internal.telephony.ApnSetting;
import com.android.internal.telephony.CommandsInterface;
import com.android.internal.telephony.DataCallState;
import com.android.internal.telephony.DataConnection;
import com.android.internal.telephony.DataConnection.FailCause;
import com.android.internal.telephony.DataConnectionAc;
import com.android.internal.telephony.DataConnectionTracker;
import com.android.internal.telephony.EventLogTags;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.RetryManager;
import com.android.internal.util.AsyncChannel;

public final class CdmaDataConnectionTracker extends DataConnectionTracker {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:02.910 -0500", hash_original_field = "39593F3F283A7C4E599199A281E0F77E", hash_generated_field = "026E142D8E01249707E04DC78D4EFF35")

    private static final int TIME_DELAYED_TO_RESTART_RADIO =
            SystemProperties.getInt("ro.cdma.timetoradiorestart", 60000);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:02.912 -0500", hash_original_field = "8713C486314BC54FCF9392881FF37BE5", hash_generated_field = "01674A6D3DB885DCC7AB5BE2BD593ACF")

    private static final int DATA_CONNECTION_POOL_SIZE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:02.915 -0500", hash_original_field = "658C3720E0EDB4870346917DDEC41F5B", hash_generated_field = "20166A867EF23E7504249EF3C9B5AB3C")

    private static final String INTENT_RECONNECT_ALARM =
        "com.android.internal.telephony.cdma-reconnect";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:02.918 -0500", hash_original_field = "067A82CB4288FFC7439862C475B01EE5", hash_generated_field = "6C8FF74EEDEE440F89F3FC7EF70C27D7")

    private static final String INTENT_DATA_STALL_ALARM =
        "com.android.internal.telephony.cdma-data-stall";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:02.920 -0500", hash_original_field = "BDFDD9A8FB6BECCBCFEE11571D79D119", hash_generated_field = "AF0632B78D1BD6B15A396B584EB3F7C0")

     private static final int DATA_CONNECTION_ACTIVE_PH_LINK_INACTIVE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:02.923 -0500", hash_original_field = "45C38A15FCFE721F2AE9CE36DD75968D", hash_generated_field = "F92E1A7741887DC6DAF4708B5127D20F")

     private static final int DATA_CONNECTION_ACTIVE_PH_LINK_DOWN = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:02.925 -0500", hash_original_field = "2C245F82F71FF62F10EEC56F1B5496CB", hash_generated_field = "823EB0FF5FCBDCE6A1A71833F5D13138")

     private static final int DATA_CONNECTION_ACTIVE_PH_LINK_UP = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:02.928 -0500", hash_original_field = "9F1EC5C41D884C2EB60146BB4B86F872", hash_generated_field = "48ED62C0AD71722F4945340F0A7FF5F9")

    private static final String[] mSupportedApnTypes = {
            Phone.APN_TYPE_DEFAULT,
            Phone.APN_TYPE_MMS,
            Phone.APN_TYPE_DUN,
            Phone.APN_TYPE_HIPRI };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:02.930 -0500", hash_original_field = "B8846B9D4E1BB9C3DFAF6E36AE018CA1", hash_generated_field = "561E37C406B565A7F36A37780ECC9AAF")

    private static final String[] mDefaultApnTypes = {
            Phone.APN_TYPE_DEFAULT,
            Phone.APN_TYPE_MMS,
            Phone.APN_TYPE_HIPRI };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:02.933 -0500", hash_original_field = "43F75A3DC81C24126AB60DAC70098E0E", hash_generated_field = "897EE016BFDB188E89DEC9B85F66301D")

    private static final int mDefaultApnId = DataConnectionTracker.APN_DEFAULT_ID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:02.901 -0500", hash_original_field = "DB10E3AE28CC9996A816C3CCD7216A83", hash_generated_field = "692A09C40EE40FAEE399CBCFE2A5ACE4")

    protected final String LOG_TAG = "CDMA";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:02.903 -0500", hash_original_field = "341D8271DE8DA7FEB72F6D3E11054C49", hash_generated_field = "A784BE3C2CA8A9A5385EEA88DD6D3A29")

    private CDMAPhone mCdmaPhone;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:02.905 -0500", hash_original_field = "95AD106586328D2DAF794DA1FDEF09F0", hash_generated_field = "EEA8F8B0B01EEAD84F4D26DF11EB97B7")

    private CdmaDataConnection mPendingDataConnection;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:02.907 -0500", hash_original_field = "38D50769CBD57FF7142F92BED5EFF055", hash_generated_field = "BCBF943C87814D8571E314787E73F3AA")

    private boolean mPendingRestartRadio = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.687 -0400", hash_original_field = "68EB667E7E7B7993A857B9AAE78D0D14", hash_generated_field = "27B43CDF8D3F1F6F3904923441B9E353")

    private Runnable mPollNetStat = new Runnable() {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.687 -0400", hash_original_method = "2461514E52B21E636B4BA6EEA10AC2AC", hash_generated_method = "123F17F6A359605D3CB3DF7D7D153FFC")
        public void run() {
            long sent;
            long received;
            long preTxPkts = -1;
            long preRxPkts = -1;
            Activity newActivity;
            preTxPkts = mTxPkts;
            preRxPkts = mRxPkts;
            mTxPkts = TrafficStats.getMobileTxPackets();
            mRxPkts = TrafficStats.getMobileRxPackets();
            {
                sent = mTxPkts - preTxPkts;
                received = mRxPkts - preRxPkts;
                {
                    mSentSinceLastRecv = 0;
                    newActivity = Activity.DATAINANDOUT;
                } 
                {
                    {
                        boolean varBBAB054B93002BE077662707D96150A8_426467871 = (mPhone.getState()  == Phone.State.IDLE);
                        {
                            mSentSinceLastRecv += sent;
                        } 
                        {
                            mSentSinceLastRecv = 0;
                        } 
                    } 
                    newActivity = Activity.DATAOUT;
                } 
                {
                    mSentSinceLastRecv = 0;
                    newActivity = Activity.DATAIN;
                } 
                {
                    newActivity = (mActivity == Activity.DORMANT) ? mActivity : Activity.NONE;
                } 
                {
                    mSentSinceLastRecv = 0;
                    newActivity = (mActivity == Activity.DORMANT) ? mActivity : Activity.NONE;
                } 
                {
                    mActivity = newActivity;
                    mPhone.notifyDataActivity();
                } 
            } 
            {
                {
                    EventLog.writeEvent(
                            EventLogTags.PDP_RADIO_RESET_COUNTDOWN_TRIGGERED,
                            mSentSinceLastRecv);
                } 
                {
                    mNetStatPollPeriod = POLL_NETSTAT_SLOW_MILLIS;
                } 
                {
                    log("Sent " + String.valueOf(mSentSinceLastRecv) +
                                        " pkts since last received");
                    mNetStatPollEnabled = false;
                    stopNetStatPoll();
                    restartRadio();
                    EventLog.writeEvent(EventLogTags.PDP_RADIO_RESET, NO_RECV_POLL_LIMIT);
                } 
            } 
            {
                mNoRecvPollCount = 0;
                mNetStatPollPeriod = POLL_NETSTAT_MILLIS;
            } 
            {
                mDataConnectionTracker.postDelayed(this, mNetStatPollPeriod);
            }
            
        }
        
};

    /* Constructor */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:02.936 -0500", hash_original_method = "2C5FD67C25932D4938DCF727D105250A", hash_generated_method = "2C5FD67C25932D4938DCF727D105250A")
    
CdmaDataConnectionTracker(CDMAPhone p) {
        super(p);
        mCdmaPhone = p;

        p.mCM.registerForAvailable (this, EVENT_RADIO_AVAILABLE, null);
        p.mCM.registerForOffOrNotAvailable(this, EVENT_RADIO_OFF_OR_NOT_AVAILABLE, null);
        p.mIccRecords.registerForRecordsLoaded(this, EVENT_RECORDS_LOADED, null);
        p.mCM.registerForNVReady(this, EVENT_NV_READY, null);
        p.mCM.registerForDataNetworkStateChanged (this, EVENT_DATA_STATE_CHANGED, null);
        p.mCT.registerForVoiceCallEnded (this, EVENT_VOICE_CALL_ENDED, null);
        p.mCT.registerForVoiceCallStarted (this, EVENT_VOICE_CALL_STARTED, null);
        p.mSST.registerForDataConnectionAttached(this, EVENT_TRY_SETUP_DATA, null);
        p.mSST.registerForDataConnectionDetached(this, EVENT_CDMA_DATA_DETACHED, null);
        p.mSST.registerForRoamingOn(this, EVENT_ROAMING_ON, null);
        p.mSST.registerForRoamingOff(this, EVENT_ROAMING_OFF, null);
        p.mCM.registerForCdmaOtaProvision(this, EVENT_CDMA_OTA_PROVISION, null);

        mDataConnectionTracker = this;

        createAllDataConnectionList();
        broadcastMessenger();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:02.939 -0500", hash_original_method = "D7D3BFC7AEBB4A854053D0E671EEEB9F", hash_generated_method = "D0A1761398390BA101D88970C14BE2D6")
    
@Override
    public void dispose() {
        cleanUpConnection(false, null);

        super.dispose();

        // Unregister from all events
        mPhone.mCM.unregisterForAvailable(this);
        mPhone.mCM.unregisterForOffOrNotAvailable(this);
        mCdmaPhone.mIccRecords.unregisterForRecordsLoaded(this);
        mPhone.mCM.unregisterForNVReady(this);
        mPhone.mCM.unregisterForDataNetworkStateChanged(this);
        mCdmaPhone.mCT.unregisterForVoiceCallEnded(this);
        mCdmaPhone.mCT.unregisterForVoiceCallStarted(this);
        mCdmaPhone.mSST.unregisterForDataConnectionAttached(this);
        mCdmaPhone.mSST.unregisterForDataConnectionDetached(this);
        mCdmaPhone.mSST.unregisterForRoamingOn(this);
        mCdmaPhone.mSST.unregisterForRoamingOff(this);
        mPhone.mCM.unregisterForCdmaOtaProvision(this);

        destroyAllDataConnectionList();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:02.942 -0500", hash_original_method = "3DB74CB183E0997C0A31C0F47FB531FD", hash_generated_method = "CA561ABD926D4FF921463A06960533AC")
    
@Override
    protected void finalize() {
        if(DBG) log("CdmaDataConnectionTracker finalized");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:02.944 -0500", hash_original_method = "477FAE9A0F7056536F0C43A4344C1E00", hash_generated_method = "58DC5E0B547B76E3202A7DA74D639207")
    
@Override
    protected String getActionIntentReconnectAlarm() {
        return INTENT_RECONNECT_ALARM;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:02.947 -0500", hash_original_method = "BBE23E9137760572C0B9E85F7DE2F87D", hash_generated_method = "CFB7B25A01C80653B18E3F8820B6F01C")
    
@Override
    protected String getActionIntentDataStallAlarm() {
        return INTENT_DATA_STALL_ALARM;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:02.949 -0500", hash_original_method = "8F51415486D92DEB617BF78EBB2ED95B", hash_generated_method = "28FA1FDE1D8CAE64EF9E1FC499568CBB")
    
@Override
    protected void setState(State s) {
        if (DBG) log ("setState: " + s);
        if (mState != s) {
            EventLog.writeEvent(EventLogTags.CDMA_DATA_STATE_CHANGE,
                    mState.toString(), s.toString());
            mState = s;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:02.951 -0500", hash_original_method = "53DA179904795C28B8C89E7D1C885E11", hash_generated_method = "D36BDF81EF116A41E6300016D0EE99A2")
    
@Override
    public synchronized State getState(String apnType) {
        return mState;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:02.953 -0500", hash_original_method = "3AFAE11AEA6F5EDA9B4571182280207F", hash_generated_method = "BAEF6302C333020D92C634A7F7B5AF3D")
    
@Override
    protected boolean isApnTypeAvailable(String type) {
        for (String s : mSupportedApnTypes) {
            if (TextUtils.equals(type, s)) {
                return true;
            }
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:02.957 -0500", hash_original_method = "542CE147EB1490D3575F0586BDB29C5B", hash_generated_method = "70F1AF30CE3AAFF74622CAC021943986")
    
@Override
    protected boolean isDataAllowed() {
        final boolean internalDataEnabled;
        synchronized (mDataEnabledLock) {
            internalDataEnabled = mInternalDataEnabled;
        }

        int psState = mCdmaPhone.mSST.getCurrentDataConnectionState();
        boolean roaming = (mPhone.getServiceState().getRoaming() && !getDataOnRoamingEnabled());
        boolean desiredPowerState = mCdmaPhone.mSST.getDesiredPowerState();

        boolean allowed =
                    (psState == ServiceState.STATE_IN_SERVICE ||
                            mAutoAttachOnCreation) &&
                    (mPhone.mCM.getNvState() == CommandsInterface.RadioState.NV_READY ||
                            mCdmaPhone.mIccRecords.getRecordsLoaded()) &&
                    (mCdmaPhone.mSST.isConcurrentVoiceAndDataAllowed() ||
                            mPhone.getState() == Phone.State.IDLE) &&
                    !roaming &&
                    internalDataEnabled &&
                    desiredPowerState &&
                    !mPendingRestartRadio &&
                    !mCdmaPhone.needsOtaServiceProvisioning();
        if (!allowed && DBG) {
            String reason = "";
            if (!((psState == ServiceState.STATE_IN_SERVICE) || mAutoAttachOnCreation)) {
                reason += " - psState= " + psState;
            }
            if (!(mPhone.mCM.getNvState() == CommandsInterface.RadioState.NV_READY ||
                    mCdmaPhone.mIccRecords.getRecordsLoaded())) {
                reason += " - radioState= " + mPhone.mCM.getNvState() + " - RUIM not loaded";
            }
            if (!(mCdmaPhone.mSST.isConcurrentVoiceAndDataAllowed() ||
                    mPhone.getState() == Phone.State.IDLE)) {
                reason += " - concurrentVoiceAndData not allowed and state= " + mPhone.getState();
            }
            if (roaming) reason += " - Roaming";
            if (!internalDataEnabled) reason += " - mInternalDataEnabled= false";
            if (!desiredPowerState) reason += " - desiredPowerState= false";
            if (mPendingRestartRadio) reason += " - mPendingRestartRadio= true";
            if (mCdmaPhone.needsOtaServiceProvisioning()) reason += " - needs Provisioning";
            log("Data not allowed due to" + reason);
        }
        return allowed;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:02.959 -0500", hash_original_method = "F4A377E51CCB46CDBA97F4F221100777", hash_generated_method = "9FAD9F24175DB734A34152F06F9FECD0")
    
@Override
    protected boolean isDataPossible(String apnType) {
        boolean possible = isDataAllowed() && !(getAnyDataEnabled() &&
                (mState == State.FAILED || mState == State.IDLE));
        if (!possible && DBG && isDataAllowed()) {
            log("Data not possible.  No coverage: dataState = " + mState);
        }
        return possible;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:02.962 -0500", hash_original_method = "394F83083B165868EFF2D0029A637488", hash_generated_method = "625DA3663F36DFBEA8136E119B895BE1")
    
private boolean trySetupData(String reason) {
        if (DBG) log("***trySetupData due to " + (reason == null ? "(unspecified)" : reason));

        if (mPhone.getSimulatedRadioControl() != null) {
            // Assume data is connected on the simulator
            // FIXME  this can be improved
            setState(State.CONNECTED);
            notifyDataConnection(reason);
            notifyOffApnsOfAvailability(reason);

            log("(fix?) We're on the simulator; assuming data is connected");
            return true;
        }

        int psState = mCdmaPhone.mSST.getCurrentDataConnectionState();
        boolean roaming = mPhone.getServiceState().getRoaming();
        boolean desiredPowerState = mCdmaPhone.mSST.getDesiredPowerState();

        if ((mState == State.IDLE || mState == State.SCANNING) &&
                isDataAllowed() && getAnyDataEnabled() && !isEmergency()) {
            boolean retValue = setupData(reason);
            notifyOffApnsOfAvailability(reason);
            return retValue;
        } else {
            notifyOffApnsOfAvailability(reason);
            return false;
        }
    }

    /**
     * Cleanup the CDMA data connection (only one is supported)
     *
     * @param tearDown true if the underlying DataConnection should be disconnected.
     * @param reason for the clean up.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:02.965 -0500", hash_original_method = "5189B04FA529AAC9DBE4ECDA45A08A99", hash_generated_method = "E1E79B5EE63821F0719AF30B4C2C9253")
    
private void cleanUpConnection(boolean tearDown, String reason) {
        if (DBG) log("cleanUpConnection: reason: " + reason);

        // Clear the reconnect alarm, if set.
        if (mReconnectIntent != null) {
            AlarmManager am =
                (AlarmManager) mPhone.getContext().getSystemService(Context.ALARM_SERVICE);
            am.cancel(mReconnectIntent);
            mReconnectIntent = null;
        }

        setState(State.DISCONNECTING);
        notifyOffApnsOfAvailability(reason);

        boolean notificationDeferred = false;
        for (DataConnection conn : mDataConnections.values()) {
            if(conn != null) {
                DataConnectionAc dcac =
                    mDataConnectionAsyncChannels.get(conn.getDataConnectionId());
                if (tearDown) {
                    if (DBG) log("cleanUpConnection: teardown, call conn.disconnect");
                    conn.tearDown(reason, obtainMessage(EVENT_DISCONNECT_DONE,
                            conn.getDataConnectionId(), 0, reason));
                    notificationDeferred = true;
                } else {
                    if (DBG) log("cleanUpConnection: !tearDown, call conn.resetSynchronously");
                    if (dcac != null) {
                        dcac.resetSync();
                    }
                    notificationDeferred = false;
                }
            }
        }

        stopNetStatPoll();

        if (!notificationDeferred) {
            if (DBG) log("cleanupConnection: !notificationDeferred");
            gotoIdleAndNotifyDataConnection(reason);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:02.968 -0500", hash_original_method = "CCC265A96715FBE2FE51B6C51A4C9789", hash_generated_method = "670AECFAEADF9F2E335745C83D6CED99")
    
private CdmaDataConnection findFreeDataConnection() {
        for (DataConnectionAc dcac : mDataConnectionAsyncChannels.values()) {
            if (dcac.isInactiveSync()) {
                log("found free GsmDataConnection");
                return (CdmaDataConnection) dcac.dataConnection;
            }
        }
        log("NO free CdmaDataConnection");
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:02.971 -0500", hash_original_method = "021C7DB7B25544657AF7783D8DE6441E", hash_generated_method = "F28419E5ACE4CF3F9CCDA10330AE4E76")
    
private boolean setupData(String reason) {
        CdmaDataConnection conn = findFreeDataConnection();

        if (conn == null) {
            if (DBG) log("setupData: No free CdmaDataConnection found!");
            return false;
        }

        /** TODO: We probably want the connection being setup to a parameter passed around */
        mPendingDataConnection = conn;
        String[] types;
        int apnId;
        if (mRequestedApnType.equals(Phone.APN_TYPE_DUN)) {
            types = new String[1];
            types[0] = Phone.APN_TYPE_DUN;
            apnId = DataConnectionTracker.APN_DUN_ID;
        } else {
            types = mDefaultApnTypes;
            apnId = mDefaultApnId;
        }
        mActiveApn = new ApnSetting(apnId, "", "", "", "", "", "", "", "", "",
                                    "", 0, types, "IP", "IP", true, 0);
        if (DBG) log("call conn.bringUp mActiveApn=" + mActiveApn);

        Message msg = obtainMessage();
        msg.what = EVENT_DATA_SETUP_COMPLETE;
        msg.obj = reason;
        conn.bringUp(msg, mActiveApn);

        setState(State.INITING);
        notifyDataConnection(reason);
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:02.973 -0500", hash_original_method = "A9B26E176D50C7947D632921998F13D5", hash_generated_method = "A18071108FDF1EB38D9A7365E0C396AC")
    
private void notifyDefaultData(String reason) {
        setState(State.CONNECTED);
        notifyDataConnection(reason);
        startNetStatPoll();
        mDataConnections.get(0).resetRetryCount();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:02.976 -0500", hash_original_method = "4334EC28628BC2618150E7F73B49358F", hash_generated_method = "4D418A16CC6A76101B107E9308AB208F")
    
private void resetPollStats() {
        mTxPkts = -1;
        mRxPkts = -1;
        mSentSinceLastRecv = 0;
        mNetStatPollPeriod = POLL_NETSTAT_MILLIS;
        mNoRecvPollCount = 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:02.978 -0500", hash_original_method = "89653F3210B52B01F9AED56AD5EFB50E", hash_generated_method = "FBD180442162657BA0F61EC7FEFBA55D")
    
@Override
    protected void startNetStatPoll() {
        if (mState == State.CONNECTED && mNetStatPollEnabled == false) {
            log("[DataConnection] Start poll NetStat");
            resetPollStats();
            mNetStatPollEnabled = true;
            mPollNetStat.run();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:02.981 -0500", hash_original_method = "B87E2D0F3C8EA5B297B25E95FDB4C600", hash_generated_method = "15D4C640DE8C82602B191771B207B219")
    
@Override
    protected void stopNetStatPoll() {
        mNetStatPollEnabled = false;
        removeCallbacks(mPollNetStat);
        log("[DataConnection] Stop poll NetStat");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:02.983 -0500", hash_original_method = "5AA50F54A3015F5F6ACA18B3174FAEC2", hash_generated_method = "0B5B196B5588563C638782D3800BEB74")
    
@Override
    protected void restartRadio() {
        if (DBG) log("Cleanup connection and wait " +
                (TIME_DELAYED_TO_RESTART_RADIO / 1000) + "s to restart radio");
        cleanUpAllConnections(null);
        sendEmptyMessageDelayed(EVENT_RESTART_RADIO, TIME_DELAYED_TO_RESTART_RADIO);
        mPendingRestartRadio = true;
    }

    /**
     * Returns true if the last fail cause is something that
     * seems like it deserves an error notification.
     * Transient errors are ignored
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:02.993 -0500", hash_original_method = "7D555C87655E096A1AB206CCF6046FBB", hash_generated_method = "DCDF332367FDF65B6154F1DE58068709")
    
private boolean
    shouldPostNotification(FailCause cause) {
        return (cause != FailCause.UNKNOWN);
    }

    /**
     * Return true if data connection need to be setup after disconnected due to
     * reason.
     *
     * @param reason the reason why data is disconnected
     * @return true if try setup data connection is need for this reason
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:02.995 -0500", hash_original_method = "62A24BB1F647222AA978F8E837B2D330", hash_generated_method = "D168F58C77AFC7F485C17CA9A1350579")
    
private boolean retryAfterDisconnected(String reason) {
        boolean retry = true;

        if ( Phone.REASON_RADIO_TURNED_OFF.equals(reason) ) {
            retry = false;
        }
        return retry;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:02.997 -0500", hash_original_method = "B6E77C65C80021F4CC0DAD9B1CC533BA", hash_generated_method = "F033D31AD11EC6D650649EACDA8B9065")
    
private void reconnectAfterFail(FailCause lastFailCauseCode, String reason) {
        if (mState == State.FAILED) {
            /**
             * For now With CDMA we never try to reconnect on
             * error and instead just continue to retry
             * at the last time until the state is changed.
             * TODO: Make this configurable?
             */
            int nextReconnectDelay = mDataConnections.get(0).getRetryTimer();
            startAlarmForReconnect(nextReconnectDelay, reason);
            mDataConnections.get(0).increaseRetryCount();

            if (!shouldPostNotification(lastFailCauseCode)) {
                log("NOT Posting Data Connection Unavailable notification "
                                + "-- likely transient error");
            } else {
                notifyNoData(lastFailCauseCode);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:03.000 -0500", hash_original_method = "E44CA37DEACEC190565F77C6CB5940AA", hash_generated_method = "50706A2763F2F8959B670BE23386CF77")
    
private void startAlarmForReconnect(int delay, String reason) {

        log("Data Connection activate failed. Scheduling next attempt for "
                + (delay / 1000) + "s");

        AlarmManager am =
            (AlarmManager) mPhone.getContext().getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(INTENT_RECONNECT_ALARM);
        intent.putExtra(INTENT_RECONNECT_ALARM_EXTRA_REASON, reason);
        mReconnectIntent = PendingIntent.getBroadcast(
                mPhone.getContext(), 0, intent, 0);
        am.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                SystemClock.elapsedRealtime() + delay, mReconnectIntent);

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:03.002 -0500", hash_original_method = "906A69878943A02EC5DE4E13B27C21B4", hash_generated_method = "E47D9A60220E79487A6E7756D54BFCCD")
    
private void notifyNoData(FailCause lastFailCauseCode) {
        setState(State.FAILED);
        notifyOffApnsOfAvailability(null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:03.005 -0500", hash_original_method = "FC06F936895E8DDA4082B1191F41BF76", hash_generated_method = "D36AF7CE96E3ED7D1AC8B207095E3D12")
    
protected void gotoIdleAndNotifyDataConnection(String reason) {
        if (DBG) log("gotoIdleAndNotifyDataConnection: reason=" + reason);
        setState(State.IDLE);
        notifyDataConnection(reason);
        mActiveApn = null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:03.007 -0500", hash_original_method = "E23B6E1AC9BCA9F124B3E389B7DEE3CE", hash_generated_method = "6AAB8A6D152AFAD9948DD5FF3A1AE341")
    
protected void onRecordsLoaded() {
        if (mState == State.FAILED) {
            cleanUpAllConnections(null);
        }
        sendMessage(obtainMessage(EVENT_TRY_SETUP_DATA, Phone.REASON_SIM_LOADED));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:03.010 -0500", hash_original_method = "E1428BF12D5C40E221347D3CB6592677", hash_generated_method = "2D56CAE696B5A1549F00214C62DDFB7D")
    
protected void onNVReady() {
        if (mState == State.FAILED) {
            cleanUpAllConnections(null);
        }
        sendMessage(obtainMessage(EVENT_TRY_SETUP_DATA));
    }

    /**
     * @override com.android.internal.telephony.DataConnectionTracker
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:03.012 -0500", hash_original_method = "EA596D7E6B7BB6E966347390783DCB75", hash_generated_method = "7788FA647CFC7B090C22DBBEC5CA33BB")
    
@Override
    protected void onEnableNewApn() {
        // No mRequestedApnType check; only one connection is supported
        cleanUpConnection(true, Phone.REASON_APN_SWITCHED);
    }

    /**
     * @override com.android.internal.telephony.DataConnectionTracker
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:03.014 -0500", hash_original_method = "D1EA04ADDFE8BEB96FCA5B0EBDBE27E4", hash_generated_method = "9A2843AEFB9648D9099A4514CE2047AD")
    
@Override
    protected boolean onTrySetupData(String reason) {
        return trySetupData(reason);
    }

    /**
     * @override com.android.internal.telephony.DataConnectionTracker
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:03.017 -0500", hash_original_method = "456B5B4117DFD69A8357ABE29B636ADA", hash_generated_method = "8D2DAFB92E14AA7EAD55E23EC2878EC9")
    
@Override
    protected void onRoamingOff() {
        if (getDataOnRoamingEnabled() == false) {
            notifyOffApnsOfAvailability(Phone.REASON_ROAMING_OFF);
            trySetupData(Phone.REASON_ROAMING_OFF);
        } else {
            notifyDataConnection(Phone.REASON_ROAMING_OFF);
        }
    }

    /**
     * @override com.android.internal.telephony.DataConnectionTracker
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:03.019 -0500", hash_original_method = "05517986BB1CA537C6FCF607816BF093", hash_generated_method = "F64A401D9185FA4048FAB4490D28B71C")
    
@Override
    protected void onRoamingOn() {
        if (getDataOnRoamingEnabled()) {
            trySetupData(Phone.REASON_ROAMING_ON);
            notifyDataConnection(Phone.REASON_ROAMING_ON);
        } else {
            if (DBG) log("Tear down data connection on roaming.");
            cleanUpAllConnections(null);
            notifyOffApnsOfAvailability(Phone.REASON_ROAMING_ON);
        }
    }

    /**
     * @override com.android.internal.telephony.DataConnectionTracker
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:03.022 -0500", hash_original_method = "F74A764B82D382E1DF4133E695EBD591", hash_generated_method = "B128FDDF8FD9D08011C0246023133967")
    
@Override
    protected void onRadioAvailable() {
        if (mPhone.getSimulatedRadioControl() != null) {
            // Assume data is connected on the simulator
            // FIXME  this can be improved
            setState(State.CONNECTED);
            notifyDataConnection(null);

            log("We're on the simulator; assuming data is connected");
        }

        notifyOffApnsOfAvailability(null);

        if (mState != State.IDLE) {
            cleanUpAllConnections(null);
        }
    }

    /**
     * @override com.android.internal.telephony.DataConnectionTracker
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:03.024 -0500", hash_original_method = "13044BD14789126E4C7F4A6581DB22DE", hash_generated_method = "AC501B221DFCB9F843F050AA94410B0E")
    
@Override
    protected void onRadioOffOrNotAvailable() {
        mDataConnections.get(0).resetRetryCount();

        if (mPhone.getSimulatedRadioControl() != null) {
            // Assume data is connected on the simulator
            // FIXME  this can be improved
            log("We're on the simulator; assuming radio off is meaningless");
        } else {
            if (DBG) log("Radio is off and clean up all connection");
            cleanUpAllConnections(null);
        }
    }

    /**
     * @override com.android.internal.telephony.DataConnectionTracker
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:03.027 -0500", hash_original_method = "F38E677B8F89E946D32F2D1EC6556506", hash_generated_method = "EA8D515A427E4949045167C284AF051B")
    
@Override
    protected void onDataSetupComplete(AsyncResult ar) {
        String reason = null;
        if (ar.userObj instanceof String) {
            reason = (String) ar.userObj;
        }

        if (isDataSetupCompleteOk(ar)) {
            // Everything is setup
            notifyDefaultData(reason);
        } else {
            FailCause cause = (FailCause) (ar.result);
            if(DBG) log("Data Connection setup failed " + cause);

            // No try for permanent failure
            if (cause.isPermanentFail()) {
                notifyNoData(cause);
                return;
            }
            startDelayedRetry(cause, reason);
        }
    }

    /**
     * Called when EVENT_DISCONNECT_DONE is received.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:03.030 -0500", hash_original_method = "B64AD173877EB61F2BA995A6B9586953", hash_generated_method = "3BEC82F339A99D67F7E9DDFDF498F7D3")
    
@Override
    protected void onDisconnectDone(int connId, AsyncResult ar) {
        if(DBG) log("EVENT_DISCONNECT_DONE connId=" + connId);
        String reason = null;
        if (ar.userObj instanceof String) {
            reason = (String) ar.userObj;
        }
        setState(State.IDLE);

        // Since the pending request to turn off or restart radio will be processed here,
        // remove the pending event to restart radio from the message queue.
        if (mPendingRestartRadio) removeMessages(EVENT_RESTART_RADIO);

        // Process the pending request to turn off radio in ServiceStateTracker first.
        // If radio is turned off in ServiceStateTracker, ignore the pending event to restart radio.
        CdmaServiceStateTracker ssTracker = mCdmaPhone.mSST;
        if (ssTracker.processPendingRadioPowerOffAfterDataOff()) {
            mPendingRestartRadio = false;
        } else {
            onRestartRadio();
        }

        notifyDataConnection(reason);
        mActiveApn = null;
        if (retryAfterDisconnected(reason)) {
          // Wait a bit before trying, so we're not tying up RIL command channel.
          startAlarmForReconnect(APN_DELAY_MILLIS, reason);
      }
    }

    /**
     * @override com.android.internal.telephony.DataConnectionTracker
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:03.033 -0500", hash_original_method = "8669708C7F9DB85ADE9303FE8B7AF6BC", hash_generated_method = "6AA2FB844A95C2449D621C64560C6637")
    
@Override
    protected void onVoiceCallStarted() {
        if (mState == State.CONNECTED && !mCdmaPhone.mSST.isConcurrentVoiceAndDataAllowed()) {
            stopNetStatPoll();
            notifyDataConnection(Phone.REASON_VOICE_CALL_STARTED);
            notifyOffApnsOfAvailability(Phone.REASON_VOICE_CALL_STARTED);
        }
    }

    /**
     * @override com.android.internal.telephony.DataConnectionTracker
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:03.036 -0500", hash_original_method = "A8CF6D26E9B870CF97B1A301601A4493", hash_generated_method = "19A46C9969280250585DB89897DA31A7")
    
@Override
    protected void onVoiceCallEnded() {
        if (mState == State.CONNECTED) {
            if (!mCdmaPhone.mSST.isConcurrentVoiceAndDataAllowed()) {
                startNetStatPoll();
                notifyDataConnection(Phone.REASON_VOICE_CALL_ENDED);
            } else {
                // clean slate after call end.
                resetPollStats();
            }
            notifyOffApnsOfAvailability(Phone.REASON_VOICE_CALL_ENDED);
        } else {
            mDataConnections.get(0).resetRetryCount();
            // in case data setup was attempted when we were on a voice call
            trySetupData(Phone.REASON_VOICE_CALL_ENDED);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:03.038 -0500", hash_original_method = "1767BD771DD5F6B59CD03646F3315F79", hash_generated_method = "734E756FFA67E3EEE27224896419C54F")
    
@Override
    protected void onCleanUpConnection(boolean tearDown, int apnId, String reason) {
        // No apnId check; only one connection is supported
        cleanUpConnection(tearDown, reason);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:03.041 -0500", hash_original_method = "6A2ACA33DA32338447596FF020294793", hash_generated_method = "C865532A2A196C5A964CEDEC94869A7F")
    
@Override
    protected void onCleanUpAllConnections(String cause) {
        // Only one CDMA connection is supported
        cleanUpConnection(true, cause);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:03.043 -0500", hash_original_method = "7F3FB415E824AE28DE838EAC0023F542", hash_generated_method = "DF1A68F0FBCE96E95B317EB7A2CA9AA3")
    
private void createAllDataConnectionList() {
        CdmaDataConnection dataConn;

        String retryConfig = SystemProperties.get("ro.cdma.data_retry_config");
        for (int i = 0; i < DATA_CONNECTION_POOL_SIZE; i++) {
            RetryManager rm = new RetryManager();
            if (!rm.configure(retryConfig)) {
                if (!rm.configure(DEFAULT_DATA_RETRY_CONFIG)) {
                    // Should never happen, log an error and default to a simple linear sequence.
                    log("Could not configure using DEFAULT_DATA_RETRY_CONFIG="
                            + DEFAULT_DATA_RETRY_CONFIG);
                    rm.configure(20, 2000, 1000);
                }
            }

            int id = mUniqueIdGenerator.getAndIncrement();
            dataConn = CdmaDataConnection.makeDataConnection(mCdmaPhone, id, rm);
            mDataConnections.put(id, dataConn);
            DataConnectionAc dcac = new DataConnectionAc(dataConn, LOG_TAG);
            int status = dcac.fullyConnectSync(mPhone.getContext(), this, dataConn.getHandler());
            if (status == AsyncChannel.STATUS_SUCCESSFUL) {
                log("Fully connected");
                mDataConnectionAsyncChannels.put(dcac.dataConnection.getDataConnectionId(), dcac);
            } else {
                log("Could not connect to dcac.dataConnection=" + dcac.dataConnection +
                        " status=" + status);
            }

        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:03.046 -0500", hash_original_method = "8430EFDC31AB81EB1D7F0972246BF5F1", hash_generated_method = "C5B00461A74E6FCFC71B8164DF20DC36")
    
private void destroyAllDataConnectionList() {
        if(mDataConnections != null) {
            mDataConnections.clear();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:03.048 -0500", hash_original_method = "94CE8407A5E1B53B6799DEAF3D95D61E", hash_generated_method = "69B71B5989BA6BAA09DF07185470B0A2")
    
private void onCdmaDataDetached() {
        if (mState == State.CONNECTED) {
            startNetStatPoll();
            notifyDataConnection(Phone.REASON_CDMA_DATA_DETACHED);
        } else {
            if (mState == State.FAILED) {
                cleanUpConnection(false, Phone.REASON_CDMA_DATA_DETACHED);
                mDataConnections.get(0).resetRetryCount();

                CdmaCellLocation loc = (CdmaCellLocation)(mPhone.getCellLocation());
                EventLog.writeEvent(EventLogTags.CDMA_DATA_SETUP_FAILED,
                        loc != null ? loc.getBaseStationId() : -1,
                        TelephonyManager.getDefault().getNetworkType());
            }
            trySetupData(Phone.REASON_CDMA_DATA_DETACHED);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:03.051 -0500", hash_original_method = "A262DC774CC921F05CC1B098B136C4F6", hash_generated_method = "52A3F995DCE1810526D479D64982E8B7")
    
private void onCdmaOtaProvision(AsyncResult ar) {
        if (ar.exception != null) {
            int [] otaPrivision = (int [])ar.result;
            if ((otaPrivision != null) && (otaPrivision.length > 1)) {
                switch (otaPrivision[0]) {
                case Phone.CDMA_OTA_PROVISION_STATUS_COMMITTED:
                case Phone.CDMA_OTA_PROVISION_STATUS_OTAPA_STOPPED:
                    mDataConnections.get(0).resetRetryCount();
                    break;
                default:
                    break;
                }
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:03.053 -0500", hash_original_method = "7F30476887B77149E22CB7625A399926", hash_generated_method = "325D11CFFD8C3BB1F0E4B296D76E4B26")
    
private void onRestartRadio() {
        if (mPendingRestartRadio) {
            log("************TURN OFF RADIO**************");
            mPhone.mCM.setRadioPower(false, null);
            /* Note: no need to call setRadioPower(true).  Assuming the desired
             * radio power state is still ON (as tracked by ServiceStateTracker),
             * ServiceStateTracker will call setRadioPower when it receives the
             * RADIO_STATE_CHANGED notification for the power off.  And if the
             * desired power state has changed in the interim, we don't want to
             * override it with an unconditional power on.
             */
            mPendingRestartRadio = false;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:03.055 -0500", hash_original_method = "A45AA34613360795905157920DD95009", hash_generated_method = "65FB92C000CAB40FA0AA338B707A035B")
    
private void writeEventLogCdmaDataDrop() {
        CdmaCellLocation loc = (CdmaCellLocation)(mPhone.getCellLocation());
        EventLog.writeEvent(EventLogTags.CDMA_DATA_DROP,
                loc != null ? loc.getBaseStationId() : -1,
                TelephonyManager.getDefault().getNetworkType());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:03.058 -0500", hash_original_method = "D056F1F93E1FCCA005B3D5C4043A4B41", hash_generated_method = "4138A7DC2E0F6ADE384D42BB96C16E77")
    
protected void onDataStateChanged(AsyncResult ar) {
        ArrayList<DataCallState> dataCallStates = (ArrayList<DataCallState>)(ar.result);

        if (ar.exception != null) {
            // This is probably "radio not available" or something
            // of that sort. If so, the whole connection is going
            // to come down soon anyway
            return;
        }

        if (mState == State.CONNECTED) {
            boolean isActiveOrDormantConnectionPresent = false;
            int connectionState = DATA_CONNECTION_ACTIVE_PH_LINK_INACTIVE;

            // Check for an active or dormant connection element in
            // the DATA_CALL_LIST array
            for (int index = 0; index < dataCallStates.size(); index++) {
                connectionState = dataCallStates.get(index).active;
                if (connectionState != DATA_CONNECTION_ACTIVE_PH_LINK_INACTIVE) {
                    isActiveOrDormantConnectionPresent = true;
                    break;
                }
            }

            if (!isActiveOrDormantConnectionPresent) {
                // No active or dormant connection
                log("onDataStateChanged: No active connection"
                        + "state is CONNECTED, disconnecting/cleanup");
                writeEventLogCdmaDataDrop();
                cleanUpConnection(true, null);
                return;
            }

            switch (connectionState) {
                case DATA_CONNECTION_ACTIVE_PH_LINK_UP:
                    log("onDataStateChanged: active=LINK_ACTIVE && CONNECTED, ignore");
                    mActivity = Activity.NONE;
                    mPhone.notifyDataActivity();
                    startNetStatPoll();
                    break;

                case DATA_CONNECTION_ACTIVE_PH_LINK_DOWN:
                    log("onDataStateChanged active=LINK_DOWN && CONNECTED, dormant");
                    mActivity = Activity.DORMANT;
                    mPhone.notifyDataActivity();
                    stopNetStatPoll();
                    break;

                default:
                    log("onDataStateChanged: IGNORE unexpected DataCallState.active="
                            + connectionState);
            }
        } else {
            // TODO: Do we need to do anything?
            log("onDataStateChanged: not connected, state=" + mState + " ignoring");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:03.061 -0500", hash_original_method = "E7620C231D98F2722A026ACACB1534C7", hash_generated_method = "D5AA45AF139F8666ABA35C76D7331B28")
    
private void startDelayedRetry(FailCause cause, String reason) {
        notifyNoData(cause);
        reconnectAfterFail(cause, reason);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:03.064 -0500", hash_original_method = "23AB21BFEE9B8AADED0100AF4BC4730D", hash_generated_method = "EDFADB223652E13C1FA514763F6FA328")
    
@Override
    public void handleMessage (Message msg) {
        if (DBG) log("CdmaDCT handleMessage msg=" + msg);

        if (!mPhone.mIsTheCurrentActivePhone || mIsDisposed) {
            log("Ignore CDMA msgs since CDMA phone is inactive");
            return;
        }

        switch (msg.what) {
            case EVENT_RECORDS_LOADED:
                onRecordsLoaded();
                break;

            case EVENT_NV_READY:
                onNVReady();
                break;

            case EVENT_CDMA_DATA_DETACHED:
                onCdmaDataDetached();
                break;

            case EVENT_DATA_STATE_CHANGED:
                onDataStateChanged((AsyncResult) msg.obj);
                break;

            case EVENT_CDMA_OTA_PROVISION:
                onCdmaOtaProvision((AsyncResult) msg.obj);
                break;

            case EVENT_RESTART_RADIO:
                if (DBG) log("EVENT_RESTART_RADIO");
                onRestartRadio();
                break;

            default:
                // handle the message in the super class DataConnectionTracker
                super.handleMessage(msg);
                break;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:03.067 -0500", hash_original_method = "40E4BCBCB488969F7D8EBF5CAA1BFE5A", hash_generated_method = "8CEECDDC98C89F9BC207D6D026575FDB")
    
@Override
    public boolean isDisconnected() {
        return ((mState == State.IDLE) || (mState == State.FAILED));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:03.069 -0500", hash_original_method = "C5FFF855C74ADBDA37AC74CEDF90027C", hash_generated_method = "63F33314EAD587D05588B4EFB6E7ABBD")
    
@Override
    protected void log(String s) {
        Log.d(LOG_TAG, "[CdmaDCT] " + s);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:03.071 -0500", hash_original_method = "509A4E6BF6CDBAFC8ECDCC1462D37923", hash_generated_method = "AD9D85E5CF0039F0FCFBB529D4E04E94")
    
@Override
    protected void loge(String s) {
        Log.e(LOG_TAG, "[CdmaDCT] " + s);
    }
}

