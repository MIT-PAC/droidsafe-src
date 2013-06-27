package com.android.internal.telephony.cdma;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
import com.android.internal.telephony.DataConnection.FailCause;
import com.android.internal.telephony.DataConnection;
import com.android.internal.telephony.DataConnectionAc;
import com.android.internal.telephony.DataConnectionTracker;
import com.android.internal.telephony.EventLogTags;
import com.android.internal.telephony.RetryManager;
import com.android.internal.telephony.Phone;
import com.android.internal.util.AsyncChannel;
import java.util.ArrayList;

public final class CdmaDataConnectionTracker extends DataConnectionTracker {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.435 -0400", hash_original_field = "951C150E6D062E6AED2C45BB9B756185", hash_generated_field = "9DA11A426082E7D6EB090C89B0C11372")

    protected String LOG_TAG = "CDMA";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.435 -0400", hash_original_field = "C77218B74238AF8B3595D58067947274", hash_generated_field = "A784BE3C2CA8A9A5385EEA88DD6D3A29")

    private CDMAPhone mCdmaPhone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.435 -0400", hash_original_field = "0A4D06AADF5B2F71B9FA6A482FB61442", hash_generated_field = "EEA8F8B0B01EEAD84F4D26DF11EB97B7")

    private CdmaDataConnection mPendingDataConnection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.435 -0400", hash_original_field = "916FC477FFD163966FA31F037869DCA9", hash_generated_field = "BCBF943C87814D8571E314787E73F3AA")

    private boolean mPendingRestartRadio = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.542 -0400", hash_original_field = "68EB667E7E7B7993A857B9AAE78D0D14", hash_generated_field = "2A6B9119939FEEA4E8143E1668DB6DEA")

    private Runnable mPollNetStat = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.457 -0400", hash_original_method = "2461514E52B21E636B4BA6EEA10AC2AC", hash_generated_method = "B95AADE40DA15369A954DF564D8B2303")
        public void run() {
            long sent, received;
            long preTxPkts, preRxPkts;
            preTxPkts = -1;
            preRxPkts = -1;
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
                } //End block
                {
                    {
                        boolean varBBAB054B93002BE077662707D96150A8_2062707035 = (mPhone.getState()  == Phone.State.IDLE);
                        {
                            mSentSinceLastRecv += sent;
                        } //End block
                        {
                            mSentSinceLastRecv = 0;
                        } //End block
                    } //End collapsed parenthetic
                    newActivity = Activity.DATAOUT;
                } //End block
                {
                    mSentSinceLastRecv = 0;
                    newActivity = Activity.DATAIN;
                } //End block
                {
                    newActivity = (mActivity == Activity.DORMANT) ? mActivity : Activity.NONE;
                } //End block
                {
                    mSentSinceLastRecv = 0;
                    newActivity = (mActivity == Activity.DORMANT) ? mActivity : Activity.NONE;
                } //End block
                {
                    mActivity = newActivity;
                    mPhone.notifyDataActivity();
                } //End block
            } //End block
            {
                {
                    EventLog.writeEvent(
                            EventLogTags.PDP_RADIO_RESET_COUNTDOWN_TRIGGERED,
                            mSentSinceLastRecv);
                } //End block
                {
                    mNetStatPollPeriod = POLL_NETSTAT_SLOW_MILLIS;
                } //End block
                {
                    log("Sent " + String.valueOf(mSentSinceLastRecv) +
                                        " pkts since last received");
                    mNetStatPollEnabled = false;
                    stopNetStatPoll();
                    restartRadio();
                    EventLog.writeEvent(EventLogTags.PDP_RADIO_RESET, NO_RECV_POLL_LIMIT);
                } //End block
            } //End block
            {
                mNoRecvPollCount = 0;
                mNetStatPollPeriod = POLL_NETSTAT_MILLIS;
            } //End block
            {
                mDataConnectionTracker.postDelayed(this, mNetStatPollPeriod);
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.548 -0400", hash_original_method = "2C5FD67C25932D4938DCF727D105250A", hash_generated_method = "3F43862F61079BC5E612945DBAC96707")
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.549 -0400", hash_original_method = "D7D3BFC7AEBB4A854053D0E671EEEB9F", hash_generated_method = "FE4B0CA0759BD685AB39AF74717B1307")
    @Override
    public void dispose() {
        cleanUpConnection(false, null);
        super.dispose();
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
        // ---------- Original Method ----------
        //cleanUpConnection(false, null);
        //super.dispose();
        //mPhone.mCM.unregisterForAvailable(this);
        //mPhone.mCM.unregisterForOffOrNotAvailable(this);
        //mCdmaPhone.mIccRecords.unregisterForRecordsLoaded(this);
        //mPhone.mCM.unregisterForNVReady(this);
        //mPhone.mCM.unregisterForDataNetworkStateChanged(this);
        //mCdmaPhone.mCT.unregisterForVoiceCallEnded(this);
        //mCdmaPhone.mCT.unregisterForVoiceCallStarted(this);
        //mCdmaPhone.mSST.unregisterForDataConnectionAttached(this);
        //mCdmaPhone.mSST.unregisterForDataConnectionDetached(this);
        //mCdmaPhone.mSST.unregisterForRoamingOn(this);
        //mCdmaPhone.mSST.unregisterForRoamingOff(this);
        //mPhone.mCM.unregisterForCdmaOtaProvision(this);
        //destroyAllDataConnectionList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.549 -0400", hash_original_method = "3DB74CB183E0997C0A31C0F47FB531FD", hash_generated_method = "56792E5FE8E366D5E4E3C9786B081157")
    @Override
    protected void finalize() {
        log("CdmaDataConnectionTracker finalized");
        // ---------- Original Method ----------
        //if(DBG) log("CdmaDataConnectionTracker finalized");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.549 -0400", hash_original_method = "477FAE9A0F7056536F0C43A4344C1E00", hash_generated_method = "C338C3F9D3BD61C359C9AB8B481C31E0")
    @Override
    protected String getActionIntentReconnectAlarm() {
        String varB4EAC82CA7396A68D541C85D26508E83_1786690872 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1786690872 = INTENT_RECONNECT_ALARM;
        varB4EAC82CA7396A68D541C85D26508E83_1786690872.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1786690872;
        // ---------- Original Method ----------
        //return INTENT_RECONNECT_ALARM;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.550 -0400", hash_original_method = "BBE23E9137760572C0B9E85F7DE2F87D", hash_generated_method = "2045EBBA7DA65EDFB9D77FBAA64C801D")
    @Override
    protected String getActionIntentDataStallAlarm() {
        String varB4EAC82CA7396A68D541C85D26508E83_1770506018 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1770506018 = INTENT_DATA_STALL_ALARM;
        varB4EAC82CA7396A68D541C85D26508E83_1770506018.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1770506018;
        // ---------- Original Method ----------
        //return INTENT_DATA_STALL_ALARM;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.550 -0400", hash_original_method = "8F51415486D92DEB617BF78EBB2ED95B", hash_generated_method = "4EB4B0C8CDF67C54D9A95DEBFB099627")
    @Override
    protected void setState(State s) {
        log ("setState: " + s);
        {
            EventLog.writeEvent(EventLogTags.CDMA_DATA_STATE_CHANGE,
                    mState.toString(), s.toString());
            mState = s;
        } //End block
        addTaint(s.getTaint());
        // ---------- Original Method ----------
        //if (DBG) log ("setState: " + s);
        //if (mState != s) {
            //EventLog.writeEvent(EventLogTags.CDMA_DATA_STATE_CHANGE,
                    //mState.toString(), s.toString());
            //mState = s;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.551 -0400", hash_original_method = "53DA179904795C28B8C89E7D1C885E11", hash_generated_method = "F90E16813E6E757F46D373EC0368AAF7")
    @Override
    public synchronized State getState(String apnType) {
        State varB4EAC82CA7396A68D541C85D26508E83_825161133 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_825161133 = mState;
        addTaint(apnType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_825161133.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_825161133;
        // ---------- Original Method ----------
        //return mState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.568 -0400", hash_original_method = "3AFAE11AEA6F5EDA9B4571182280207F", hash_generated_method = "2673F11D7C9AF247D821D97EED4B165F")
    @Override
    protected boolean isApnTypeAvailable(String type) {
        {
            Iterator<String> var371F9C1ED12B38A1BF6177EB240D4150_490778653 = (mSupportedApnTypes).iterator();
            var371F9C1ED12B38A1BF6177EB240D4150_490778653.hasNext();
            String s = var371F9C1ED12B38A1BF6177EB240D4150_490778653.next();
            {
                {
                    boolean varB6BAD33EB61876AC704EE691A9BB5A05_714989491 = (TextUtils.equals(type, s));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(type.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_222983213 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_222983213;
        // ---------- Original Method ----------
        //for (String s : mSupportedApnTypes) {
            //if (TextUtils.equals(type, s)) {
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.604 -0400", hash_original_method = "542CE147EB1490D3575F0586BDB29C5B", hash_generated_method = "8298D417C07240B0E1634228A87BF263")
    @Override
    protected boolean isDataAllowed() {
        boolean internalDataEnabled;
        {
            internalDataEnabled = mInternalDataEnabled;
        } //End block
        int psState;
        psState = mCdmaPhone.mSST.getCurrentDataConnectionState();
        boolean roaming;
        roaming = (mPhone.getServiceState().getRoaming() && !getDataOnRoamingEnabled());
        boolean desiredPowerState;
        desiredPowerState = mCdmaPhone.mSST.getDesiredPowerState();
        boolean allowed;
        allowed = (psState == ServiceState.STATE_IN_SERVICE ||
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
        {
            String reason;
            reason = "";
            {
                reason += " - psState= " + psState;
            } //End block
            {
                boolean var27C7393FEEA9515E8D28CD63EF68AAD3_281166368 = (!(mPhone.mCM.getNvState() == CommandsInterface.RadioState.NV_READY ||
                    mCdmaPhone.mIccRecords.getRecordsLoaded()));
                {
                    reason += " - radioState= " + mPhone.mCM.getNvState() + " - RUIM not loaded";
                } //End block
            } //End collapsed parenthetic
            {
                boolean var97339E74162EFDAB27E8C356C17FDB93_1748021690 = (!(mCdmaPhone.mSST.isConcurrentVoiceAndDataAllowed() ||
                    mPhone.getState() == Phone.State.IDLE));
                {
                    reason += " - concurrentVoiceAndData not allowed and state= " + mPhone.getState();
                } //End block
            } //End collapsed parenthetic
            reason += " - Roaming";
            reason += " - mInternalDataEnabled= false";
            reason += " - desiredPowerState= false";
            reason += " - mPendingRestartRadio= true";
            {
                boolean varAED17B66ECABE29ECB94AC584BD19AFC_1956293246 = (mCdmaPhone.needsOtaServiceProvisioning());
                reason += " - needs Provisioning";
            } //End collapsed parenthetic
            log("Data not allowed due to" + reason);
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_614135005 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_614135005;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.605 -0400", hash_original_method = "F4A377E51CCB46CDBA97F4F221100777", hash_generated_method = "87EF51A847A25C99C1991130F8CBD8C1")
    @Override
    protected boolean isDataPossible(String apnType) {
        boolean possible;
        possible = isDataAllowed() && !(getAnyDataEnabled() &&
                (mState == State.FAILED || mState == State.IDLE));
        {
            boolean var9B048D6DEF0B0137767C8E3F72E8439A_249292716 = (!possible && DBG && isDataAllowed());
            {
                log("Data not possible.  No coverage: dataState = " + mState);
            } //End block
        } //End collapsed parenthetic
        addTaint(apnType.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_725368033 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_725368033;
        // ---------- Original Method ----------
        //boolean possible = isDataAllowed() && !(getAnyDataEnabled() &&
                //(mState == State.FAILED || mState == State.IDLE));
        //if (!possible && DBG && isDataAllowed()) {
            //log("Data not possible.  No coverage: dataState = " + mState);
        //}
        //return possible;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.620 -0400", hash_original_method = "394F83083B165868EFF2D0029A637488", hash_generated_method = "2F71171706FAD1A3910411AF6331669C")
    private boolean trySetupData(String reason) {
        log("***trySetupData due to " + (reason == null ? "(unspecified)" : reason));
        {
            boolean varA62B422C35237A9A4A0C0A75D57190F8_1361279844 = (mPhone.getSimulatedRadioControl() != null);
            {
                setState(State.CONNECTED);
                notifyDataConnection(reason);
                notifyOffApnsOfAvailability(reason);
                log("(fix?) We're on the simulator; assuming data is connected");
            } //End block
        } //End collapsed parenthetic
        int psState;
        psState = mCdmaPhone.mSST.getCurrentDataConnectionState();
        boolean roaming;
        roaming = mPhone.getServiceState().getRoaming();
        boolean desiredPowerState;
        desiredPowerState = mCdmaPhone.mSST.getDesiredPowerState();
        {
            boolean var949370AE43AD6FBCD95157798F7FB0DF_1831748311 = ((mState == State.IDLE || mState == State.SCANNING) &&
                isDataAllowed() && getAnyDataEnabled() && !isEmergency());
            {
                boolean retValue;
                retValue = setupData(reason);
                notifyOffApnsOfAvailability(reason);
            } //End block
            {
                notifyOffApnsOfAvailability(reason);
            } //End block
        } //End collapsed parenthetic
        addTaint(reason.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1126335057 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1126335057;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.698 -0400", hash_original_method = "5189B04FA529AAC9DBE4ECDA45A08A99", hash_generated_method = "B559CD1A8E54CA245B42D326B63B6A56")
    private void cleanUpConnection(boolean tearDown, String reason) {
        log("cleanUpConnection: reason: " + reason);
        {
            AlarmManager am;
            am = (AlarmManager) mPhone.getContext().getSystemService(Context.ALARM_SERVICE);
            am.cancel(mReconnectIntent);
            mReconnectIntent = null;
        } //End block
        setState(State.DISCONNECTING);
        notifyOffApnsOfAvailability(reason);
        boolean notificationDeferred;
        notificationDeferred = false;
        {
            Iterator<DataConnection> var5FF8B81A220FD894D705CD5B3B4CA034_53200411 = (mDataConnections.values()).iterator();
            var5FF8B81A220FD894D705CD5B3B4CA034_53200411.hasNext();
            DataConnection conn = var5FF8B81A220FD894D705CD5B3B4CA034_53200411.next();
            {
                {
                    DataConnectionAc dcac;
                    dcac = mDataConnectionAsyncChannels.get(conn.getDataConnectionId());
                    {
                        log("cleanUpConnection: teardown, call conn.disconnect");
                        conn.tearDown(reason, obtainMessage(EVENT_DISCONNECT_DONE,
                            conn.getDataConnectionId(), 0, reason));
                        notificationDeferred = true;
                    } //End block
                    {
                        log("cleanUpConnection: !tearDown, call conn.resetSynchronously");
                        {
                            dcac.resetSync();
                        } //End block
                        notificationDeferred = false;
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        stopNetStatPoll();
        {
            log("cleanupConnection: !notificationDeferred");
            gotoIdleAndNotifyDataConnection(reason);
        } //End block
        addTaint(tearDown);
        addTaint(reason.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.720 -0400", hash_original_method = "CCC265A96715FBE2FE51B6C51A4C9789", hash_generated_method = "D4EA5E542ECAF1B3551FBD0879FE5DA4")
    private CdmaDataConnection findFreeDataConnection() {
        CdmaDataConnection varB4EAC82CA7396A68D541C85D26508E83_504023495 = null; //Variable for return #1
        CdmaDataConnection varB4EAC82CA7396A68D541C85D26508E83_301921425 = null; //Variable for return #2
        {
            Iterator<DataConnectionAc> varEB8626173DB084FB4853115B28BD3F62_1082460332 = (mDataConnectionAsyncChannels.values()).iterator();
            varEB8626173DB084FB4853115B28BD3F62_1082460332.hasNext();
            DataConnectionAc dcac = varEB8626173DB084FB4853115B28BD3F62_1082460332.next();
            {
                {
                    boolean var63D661D51186954ED4E8C4223E8E3B75_989601129 = (dcac.isInactiveSync());
                    {
                        log("found free GsmDataConnection");
                        varB4EAC82CA7396A68D541C85D26508E83_504023495 = (CdmaDataConnection) dcac.dataConnection;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        log("NO free CdmaDataConnection");
        varB4EAC82CA7396A68D541C85D26508E83_301921425 = null;
        CdmaDataConnection varA7E53CE21691AB073D9660D615818899_99470336; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_99470336 = varB4EAC82CA7396A68D541C85D26508E83_504023495;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_99470336 = varB4EAC82CA7396A68D541C85D26508E83_301921425;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_99470336.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_99470336;
        // ---------- Original Method ----------
        //for (DataConnectionAc dcac : mDataConnectionAsyncChannels.values()) {
            //if (dcac.isInactiveSync()) {
                //log("found free GsmDataConnection");
                //return (CdmaDataConnection) dcac.dataConnection;
            //}
        //}
        //log("NO free CdmaDataConnection");
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.730 -0400", hash_original_method = "021C7DB7B25544657AF7783D8DE6441E", hash_generated_method = "29F9215A33F25C85FE09AA7DF4F4A9EB")
    private boolean setupData(String reason) {
        CdmaDataConnection conn;
        conn = findFreeDataConnection();
        {
            log("setupData: No free CdmaDataConnection found!");
        } //End block
        mPendingDataConnection = conn;
        String[] types;
        int apnId;
        {
            boolean var606A60405C260349B54220DED9004DA3_392437520 = (mRequestedApnType.equals(Phone.APN_TYPE_DUN));
            {
                types = new String[1];
                types[0] = Phone.APN_TYPE_DUN;
                apnId = DataConnectionTracker.APN_DUN_ID;
            } //End block
            {
                types = mDefaultApnTypes;
                apnId = mDefaultApnId;
            } //End block
        } //End collapsed parenthetic
        mActiveApn = new ApnSetting(apnId, "", "", "", "", "", "", "", "", "",
                                    "", 0, types, "IP", "IP", true, 0);
        log("call conn.bringUp mActiveApn=" + mActiveApn);
        Message msg;
        msg = obtainMessage();
        msg.what = EVENT_DATA_SETUP_COMPLETE;
        msg.obj = reason;
        conn.bringUp(msg, mActiveApn);
        setState(State.INITING);
        notifyDataConnection(reason);
        addTaint(reason.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_265574837 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_265574837;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.731 -0400", hash_original_method = "A9B26E176D50C7947D632921998F13D5", hash_generated_method = "FDA3493BB98F3D46DD2DABAF9B9F44B7")
    private void notifyDefaultData(String reason) {
        setState(State.CONNECTED);
        notifyDataConnection(reason);
        startNetStatPoll();
        mDataConnections.get(0).resetRetryCount();
        addTaint(reason.getTaint());
        // ---------- Original Method ----------
        //setState(State.CONNECTED);
        //notifyDataConnection(reason);
        //startNetStatPoll();
        //mDataConnections.get(0).resetRetryCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.746 -0400", hash_original_method = "4334EC28628BC2618150E7F73B49358F", hash_generated_method = "CA71E84F421FB531DEE0DB608D05FC5A")
    private void resetPollStats() {
        mTxPkts = -1;
        mRxPkts = -1;
        mSentSinceLastRecv = 0;
        mNetStatPollPeriod = POLL_NETSTAT_MILLIS;
        mNoRecvPollCount = 0;
        // ---------- Original Method ----------
        //mTxPkts = -1;
        //mRxPkts = -1;
        //mSentSinceLastRecv = 0;
        //mNetStatPollPeriod = POLL_NETSTAT_MILLIS;
        //mNoRecvPollCount = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.746 -0400", hash_original_method = "89653F3210B52B01F9AED56AD5EFB50E", hash_generated_method = "201C936746B18BFA4DD690E4BE58C178")
    @Override
    protected void startNetStatPoll() {
        {
            log("[DataConnection] Start poll NetStat");
            resetPollStats();
            mNetStatPollEnabled = true;
            mPollNetStat.run();
        } //End block
        // ---------- Original Method ----------
        //if (mState == State.CONNECTED && mNetStatPollEnabled == false) {
            //log("[DataConnection] Start poll NetStat");
            //resetPollStats();
            //mNetStatPollEnabled = true;
            //mPollNetStat.run();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.747 -0400", hash_original_method = "B87E2D0F3C8EA5B297B25E95FDB4C600", hash_generated_method = "E63291039876CC2FCDDBA8BE3EFC765C")
    @Override
    protected void stopNetStatPoll() {
        mNetStatPollEnabled = false;
        removeCallbacks(mPollNetStat);
        log("[DataConnection] Stop poll NetStat");
        // ---------- Original Method ----------
        //mNetStatPollEnabled = false;
        //removeCallbacks(mPollNetStat);
        //log("[DataConnection] Stop poll NetStat");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.754 -0400", hash_original_method = "5AA50F54A3015F5F6ACA18B3174FAEC2", hash_generated_method = "E201AD4E8952C0DEB5AFC8EBC32D5FF2")
    @Override
    protected void restartRadio() {
        log("Cleanup connection and wait " +
                (TIME_DELAYED_TO_RESTART_RADIO / 1000) + "s to restart radio");
        cleanUpAllConnections(null);
        sendEmptyMessageDelayed(EVENT_RESTART_RADIO, TIME_DELAYED_TO_RESTART_RADIO);
        mPendingRestartRadio = true;
        // ---------- Original Method ----------
        //if (DBG) log("Cleanup connection and wait " +
                //(TIME_DELAYED_TO_RESTART_RADIO / 1000) + "s to restart radio");
        //cleanUpAllConnections(null);
        //sendEmptyMessageDelayed(EVENT_RESTART_RADIO, TIME_DELAYED_TO_RESTART_RADIO);
        //mPendingRestartRadio = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.755 -0400", hash_original_method = "7D555C87655E096A1AB206CCF6046FBB", hash_generated_method = "F65704D593057F7CB3F7450B92A7E4B6")
    private boolean shouldPostNotification(FailCause cause) {
        addTaint(cause.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1251836449 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1251836449;
        // ---------- Original Method ----------
        //return (cause != FailCause.UNKNOWN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.755 -0400", hash_original_method = "62A24BB1F647222AA978F8E837B2D330", hash_generated_method = "42637D9E325548D28A2180BB391F5AD1")
    private boolean retryAfterDisconnected(String reason) {
        boolean retry;
        retry = true;
        {
            boolean var3CB82CF3031EDB1F7F9E067EE7B1B74E_666993378 = (Phone.REASON_RADIO_TURNED_OFF.equals(reason));
            {
                retry = false;
            } //End block
        } //End collapsed parenthetic
        addTaint(reason.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1206155652 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1206155652;
        // ---------- Original Method ----------
        //boolean retry = true;
        //if ( Phone.REASON_RADIO_TURNED_OFF.equals(reason) ) {
            //retry = false;
        //}
        //return retry;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.755 -0400", hash_original_method = "B6E77C65C80021F4CC0DAD9B1CC533BA", hash_generated_method = "1EA74B992C5AB636811937661F91BF5A")
    private void reconnectAfterFail(FailCause lastFailCauseCode, String reason) {
        {
            int nextReconnectDelay;
            nextReconnectDelay = mDataConnections.get(0).getRetryTimer();
            startAlarmForReconnect(nextReconnectDelay, reason);
            mDataConnections.get(0).increaseRetryCount();
            {
                boolean varFD6404B1A9502D19A8FBA94C0DD3DAAF_1233444388 = (!shouldPostNotification(lastFailCauseCode));
                {
                    log("NOT Posting Data Connection Unavailable notification "
                                + "-- likely transient error");
                } //End block
                {
                    notifyNoData(lastFailCauseCode);
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(lastFailCauseCode.getTaint());
        addTaint(reason.getTaint());
        // ---------- Original Method ----------
        //if (mState == State.FAILED) {
            //int nextReconnectDelay = mDataConnections.get(0).getRetryTimer();
            //startAlarmForReconnect(nextReconnectDelay, reason);
            //mDataConnections.get(0).increaseRetryCount();
            //if (!shouldPostNotification(lastFailCauseCode)) {
                //log("NOT Posting Data Connection Unavailable notification "
                                //+ "-- likely transient error");
            //} else {
                //notifyNoData(lastFailCauseCode);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.756 -0400", hash_original_method = "E44CA37DEACEC190565F77C6CB5940AA", hash_generated_method = "9B606251EEA528BA583BBE2940B8C058")
    private void startAlarmForReconnect(int delay, String reason) {
        log("Data Connection activate failed. Scheduling next attempt for "
                + (delay / 1000) + "s");
        AlarmManager am;
        am = (AlarmManager) mPhone.getContext().getSystemService(Context.ALARM_SERVICE);
        Intent intent;
        intent = new Intent(INTENT_RECONNECT_ALARM);
        intent.putExtra(INTENT_RECONNECT_ALARM_EXTRA_REASON, reason);
        mReconnectIntent = PendingIntent.getBroadcast(
                mPhone.getContext(), 0, intent, 0);
        am.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                SystemClock.elapsedRealtime() + delay, mReconnectIntent);
        addTaint(delay);
        addTaint(reason.getTaint());
        // ---------- Original Method ----------
        //log("Data Connection activate failed. Scheduling next attempt for "
                //+ (delay / 1000) + "s");
        //AlarmManager am =
            //(AlarmManager) mPhone.getContext().getSystemService(Context.ALARM_SERVICE);
        //Intent intent = new Intent(INTENT_RECONNECT_ALARM);
        //intent.putExtra(INTENT_RECONNECT_ALARM_EXTRA_REASON, reason);
        //mReconnectIntent = PendingIntent.getBroadcast(
                //mPhone.getContext(), 0, intent, 0);
        //am.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                //SystemClock.elapsedRealtime() + delay, mReconnectIntent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.756 -0400", hash_original_method = "906A69878943A02EC5DE4E13B27C21B4", hash_generated_method = "232F7572C989ABA3FE4CA0C57747C4A6")
    private void notifyNoData(FailCause lastFailCauseCode) {
        setState(State.FAILED);
        notifyOffApnsOfAvailability(null);
        addTaint(lastFailCauseCode.getTaint());
        // ---------- Original Method ----------
        //setState(State.FAILED);
        //notifyOffApnsOfAvailability(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.757 -0400", hash_original_method = "FC06F936895E8DDA4082B1191F41BF76", hash_generated_method = "4F7B61574E4C2169EC8918C6326500B9")
    protected void gotoIdleAndNotifyDataConnection(String reason) {
        log("gotoIdleAndNotifyDataConnection: reason=" + reason);
        setState(State.IDLE);
        notifyDataConnection(reason);
        mActiveApn = null;
        addTaint(reason.getTaint());
        // ---------- Original Method ----------
        //if (DBG) log("gotoIdleAndNotifyDataConnection: reason=" + reason);
        //setState(State.IDLE);
        //notifyDataConnection(reason);
        //mActiveApn = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.757 -0400", hash_original_method = "E23B6E1AC9BCA9F124B3E389B7DEE3CE", hash_generated_method = "BAF01EAB267D3A439EDB52D7CFEB8542")
    protected void onRecordsLoaded() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            cleanUpAllConnections(null);
        } //End block
        sendMessage(obtainMessage(EVENT_TRY_SETUP_DATA, Phone.REASON_SIM_LOADED));
        // ---------- Original Method ----------
        //if (mState == State.FAILED) {
            //cleanUpAllConnections(null);
        //}
        //sendMessage(obtainMessage(EVENT_TRY_SETUP_DATA, Phone.REASON_SIM_LOADED));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.757 -0400", hash_original_method = "E1428BF12D5C40E221347D3CB6592677", hash_generated_method = "6B849ADC5E2E4D55E726038CDBD0525A")
    protected void onNVReady() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            cleanUpAllConnections(null);
        } //End block
        sendMessage(obtainMessage(EVENT_TRY_SETUP_DATA));
        // ---------- Original Method ----------
        //if (mState == State.FAILED) {
            //cleanUpAllConnections(null);
        //}
        //sendMessage(obtainMessage(EVENT_TRY_SETUP_DATA));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.768 -0400", hash_original_method = "EA596D7E6B7BB6E966347390783DCB75", hash_generated_method = "928C176826E83B168C4FA2AB3091EDBA")
    @Override
    protected void onEnableNewApn() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        cleanUpConnection(true, Phone.REASON_APN_SWITCHED);
        // ---------- Original Method ----------
        //cleanUpConnection(true, Phone.REASON_APN_SWITCHED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.769 -0400", hash_original_method = "D1EA04ADDFE8BEB96FCA5B0EBDBE27E4", hash_generated_method = "2166E03454AD8C49D157E6E95DE8DC61")
    @Override
    protected boolean onTrySetupData(String reason) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        boolean varEF2870B84D286EC80F19694D55F0ACD0_468710782 = (trySetupData(reason));
        addTaint(reason.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1430225491 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1430225491;
        // ---------- Original Method ----------
        //return trySetupData(reason);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.769 -0400", hash_original_method = "456B5B4117DFD69A8357ABE29B636ADA", hash_generated_method = "52247722537051AE202560BEC87E3943")
    @Override
    protected void onRoamingOff() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var6A4EDF3FAFEE8B58E0E885094E7C645E_358692339 = (getDataOnRoamingEnabled() == false);
            {
                notifyOffApnsOfAvailability(Phone.REASON_ROAMING_OFF);
                trySetupData(Phone.REASON_ROAMING_OFF);
            } //End block
            {
                notifyDataConnection(Phone.REASON_ROAMING_OFF);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (getDataOnRoamingEnabled() == false) {
            //notifyOffApnsOfAvailability(Phone.REASON_ROAMING_OFF);
            //trySetupData(Phone.REASON_ROAMING_OFF);
        //} else {
            //notifyDataConnection(Phone.REASON_ROAMING_OFF);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.770 -0400", hash_original_method = "05517986BB1CA537C6FCF607816BF093", hash_generated_method = "7C39B76925C69253FA6802B78D00A31E")
    @Override
    protected void onRoamingOn() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var178FD459AA12B1549B96EFDE7D504A27_1145558456 = (getDataOnRoamingEnabled());
            {
                trySetupData(Phone.REASON_ROAMING_ON);
                notifyDataConnection(Phone.REASON_ROAMING_ON);
            } //End block
            {
                log("Tear down data connection on roaming.");
                cleanUpAllConnections(null);
                notifyOffApnsOfAvailability(Phone.REASON_ROAMING_ON);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (getDataOnRoamingEnabled()) {
            //trySetupData(Phone.REASON_ROAMING_ON);
            //notifyDataConnection(Phone.REASON_ROAMING_ON);
        //} else {
            //if (DBG) log("Tear down data connection on roaming.");
            //cleanUpAllConnections(null);
            //notifyOffApnsOfAvailability(Phone.REASON_ROAMING_ON);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.770 -0400", hash_original_method = "F74A764B82D382E1DF4133E695EBD591", hash_generated_method = "E50DA11EBF943BBC68267235B0211FD9")
    @Override
    protected void onRadioAvailable() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean varA62B422C35237A9A4A0C0A75D57190F8_1362471228 = (mPhone.getSimulatedRadioControl() != null);
            {
                setState(State.CONNECTED);
                notifyDataConnection(null);
                log("We're on the simulator; assuming data is connected");
            } //End block
        } //End collapsed parenthetic
        notifyOffApnsOfAvailability(null);
        {
            cleanUpAllConnections(null);
        } //End block
        // ---------- Original Method ----------
        //if (mPhone.getSimulatedRadioControl() != null) {
            //setState(State.CONNECTED);
            //notifyDataConnection(null);
            //log("We're on the simulator; assuming data is connected");
        //}
        //notifyOffApnsOfAvailability(null);
        //if (mState != State.IDLE) {
            //cleanUpAllConnections(null);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.770 -0400", hash_original_method = "13044BD14789126E4C7F4A6581DB22DE", hash_generated_method = "7C92018C4712981986E68F3B830F950B")
    @Override
    protected void onRadioOffOrNotAvailable() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mDataConnections.get(0).resetRetryCount();
        {
            boolean varA62B422C35237A9A4A0C0A75D57190F8_360547840 = (mPhone.getSimulatedRadioControl() != null);
            {
                log("We're on the simulator; assuming radio off is meaningless");
            } //End block
            {
                log("Radio is off and clean up all connection");
                cleanUpAllConnections(null);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //mDataConnections.get(0).resetRetryCount();
        //if (mPhone.getSimulatedRadioControl() != null) {
            //log("We're on the simulator; assuming radio off is meaningless");
        //} else {
            //if (DBG) log("Radio is off and clean up all connection");
            //cleanUpAllConnections(null);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.771 -0400", hash_original_method = "F38E677B8F89E946D32F2D1EC6556506", hash_generated_method = "A2C9C79A3079D0729EE68C3A36DDB44D")
    @Override
    protected void onDataSetupComplete(AsyncResult ar) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        String reason;
        reason = null;
        {
            reason = (String) ar.userObj;
        } //End block
        {
            boolean varB5E9B7D9BBFA45BCF027FCB550EA1FBB_1817633457 = (isDataSetupCompleteOk(ar));
            {
                notifyDefaultData(reason);
            } //End block
            {
                FailCause cause;
                cause = (FailCause) (ar.result);
                log("Data Connection setup failed " + cause);
                {
                    boolean var66182ADBA155CABC56AA3975E9DBF19F_31347287 = (cause.isPermanentFail());
                    {
                        notifyNoData(cause);
                    } //End block
                } //End collapsed parenthetic
                startDelayedRetry(cause, reason);
            } //End block
        } //End collapsed parenthetic
        addTaint(ar.getTaint());
        // ---------- Original Method ----------
        //String reason = null;
        //if (ar.userObj instanceof String) {
            //reason = (String) ar.userObj;
        //}
        //if (isDataSetupCompleteOk(ar)) {
            //notifyDefaultData(reason);
        //} else {
            //FailCause cause = (FailCause) (ar.result);
            //if(DBG) log("Data Connection setup failed " + cause);
            //if (cause.isPermanentFail()) {
                //notifyNoData(cause);
                //return;
            //}
            //startDelayedRetry(cause, reason);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.772 -0400", hash_original_method = "B64AD173877EB61F2BA995A6B9586953", hash_generated_method = "2813DDFBA635823F7F1F38A7D3A7B28E")
    @Override
    protected void onDisconnectDone(int connId, AsyncResult ar) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        log("EVENT_DISCONNECT_DONE connId=" + connId);
        String reason;
        reason = null;
        {
            reason = (String) ar.userObj;
        } //End block
        setState(State.IDLE);
        removeMessages(EVENT_RESTART_RADIO);
        CdmaServiceStateTracker ssTracker;
        ssTracker = mCdmaPhone.mSST;
        {
            boolean var3BF0D3CF7742E29D226663A325AF3E66_2128483468 = (ssTracker.processPendingRadioPowerOffAfterDataOff());
            {
                mPendingRestartRadio = false;
            } //End block
            {
                onRestartRadio();
            } //End block
        } //End collapsed parenthetic
        notifyDataConnection(reason);
        mActiveApn = null;
        {
            boolean var617E4454D58A131493E80C30AF839FE7_206063535 = (retryAfterDisconnected(reason));
            {
                startAlarmForReconnect(APN_DELAY_MILLIS, reason);
            } //End block
        } //End collapsed parenthetic
        addTaint(connId);
        addTaint(ar.getTaint());
        // ---------- Original Method ----------
        //if(DBG) log("EVENT_DISCONNECT_DONE connId=" + connId);
        //String reason = null;
        //if (ar.userObj instanceof String) {
            //reason = (String) ar.userObj;
        //}
        //setState(State.IDLE);
        //if (mPendingRestartRadio) removeMessages(EVENT_RESTART_RADIO);
        //CdmaServiceStateTracker ssTracker = mCdmaPhone.mSST;
        //if (ssTracker.processPendingRadioPowerOffAfterDataOff()) {
            //mPendingRestartRadio = false;
        //} else {
            //onRestartRadio();
        //}
        //notifyDataConnection(reason);
        //mActiveApn = null;
        //if (retryAfterDisconnected(reason)) {
          //startAlarmForReconnect(APN_DELAY_MILLIS, reason);
      //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.782 -0400", hash_original_method = "8669708C7F9DB85ADE9303FE8B7AF6BC", hash_generated_method = "8F84735651DEEF137B63E2F830D7FFDA")
    @Override
    protected void onVoiceCallStarted() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var6AA65BBEFDBDAA95AEEF52A5CA0586D8_1912413952 = (mState == State.CONNECTED && !mCdmaPhone.mSST.isConcurrentVoiceAndDataAllowed());
            {
                stopNetStatPoll();
                notifyDataConnection(Phone.REASON_VOICE_CALL_STARTED);
                notifyOffApnsOfAvailability(Phone.REASON_VOICE_CALL_STARTED);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (mState == State.CONNECTED && !mCdmaPhone.mSST.isConcurrentVoiceAndDataAllowed()) {
            //stopNetStatPoll();
            //notifyDataConnection(Phone.REASON_VOICE_CALL_STARTED);
            //notifyOffApnsOfAvailability(Phone.REASON_VOICE_CALL_STARTED);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.783 -0400", hash_original_method = "A8CF6D26E9B870CF97B1A301601A4493", hash_generated_method = "F6363F037561FF11A0A80820C7BAE5B5")
    @Override
    protected void onVoiceCallEnded() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            {
                boolean var894FAD0CD22FBCEF534C22052BAF7B7C_1127914716 = (!mCdmaPhone.mSST.isConcurrentVoiceAndDataAllowed());
                {
                    startNetStatPoll();
                    notifyDataConnection(Phone.REASON_VOICE_CALL_ENDED);
                } //End block
                {
                    resetPollStats();
                } //End block
            } //End collapsed parenthetic
            notifyOffApnsOfAvailability(Phone.REASON_VOICE_CALL_ENDED);
        } //End block
        {
            mDataConnections.get(0).resetRetryCount();
            trySetupData(Phone.REASON_VOICE_CALL_ENDED);
        } //End block
        // ---------- Original Method ----------
        //if (mState == State.CONNECTED) {
            //if (!mCdmaPhone.mSST.isConcurrentVoiceAndDataAllowed()) {
                //startNetStatPoll();
                //notifyDataConnection(Phone.REASON_VOICE_CALL_ENDED);
            //} else {
                //resetPollStats();
            //}
            //notifyOffApnsOfAvailability(Phone.REASON_VOICE_CALL_ENDED);
        //} else {
            //mDataConnections.get(0).resetRetryCount();
            //trySetupData(Phone.REASON_VOICE_CALL_ENDED);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.805 -0400", hash_original_method = "1767BD771DD5F6B59CD03646F3315F79", hash_generated_method = "BF3A558B0FB95ED31D32EEE76E812232")
    @Override
    protected void onCleanUpConnection(boolean tearDown, int apnId, String reason) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        cleanUpConnection(tearDown, reason);
        addTaint(tearDown);
        addTaint(apnId);
        addTaint(reason.getTaint());
        // ---------- Original Method ----------
        //cleanUpConnection(tearDown, reason);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.805 -0400", hash_original_method = "6A2ACA33DA32338447596FF020294793", hash_generated_method = "138CE5447D62FE8D421A13417B3A7A44")
    @Override
    protected void onCleanUpAllConnections(String cause) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        cleanUpConnection(true, cause);
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
        //cleanUpConnection(true, cause);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.819 -0400", hash_original_method = "7F3FB415E824AE28DE838EAC0023F542", hash_generated_method = "88E55C277C0349A510AC8CB42B4A49C4")
    private void createAllDataConnectionList() {
        CdmaDataConnection dataConn;
        String retryConfig;
        retryConfig = SystemProperties.get("ro.cdma.data_retry_config");
        {
            int i;
            i = 0;
            {
                RetryManager rm;
                rm = new RetryManager();
                {
                    boolean var2A9F58BFB955FE221076F10F69C4E35A_1845210999 = (!rm.configure(retryConfig));
                    {
                        {
                            boolean varC9DB307BFBF42DC07215EF2C6586368D_1193902493 = (!rm.configure(DEFAULT_DATA_RETRY_CONFIG));
                            {
                                log("Could not configure using DEFAULT_DATA_RETRY_CONFIG="
                            + DEFAULT_DATA_RETRY_CONFIG);
                                rm.configure(20, 2000, 1000);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                int id;
                id = mUniqueIdGenerator.getAndIncrement();
                dataConn = CdmaDataConnection.makeDataConnection(mCdmaPhone, id, rm);
                mDataConnections.put(id, dataConn);
                DataConnectionAc dcac;
                dcac = new DataConnectionAc(dataConn, LOG_TAG);
                int status;
                status = dcac.fullyConnectSync(mPhone.getContext(), this, dataConn.getHandler());
                {
                    log("Fully connected");
                    mDataConnectionAsyncChannels.put(dcac.dataConnection.getDataConnectionId(), dcac);
                } //End block
                {
                    log("Could not connect to dcac.dataConnection=" + dcac.dataConnection +
                        " status=" + status);
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.819 -0400", hash_original_method = "8430EFDC31AB81EB1D7F0972246BF5F1", hash_generated_method = "69D95EAEF6987DF2357B662FCADD27F0")
    private void destroyAllDataConnectionList() {
        {
            mDataConnections.clear();
        } //End block
        // ---------- Original Method ----------
        //if(mDataConnections != null) {
            //mDataConnections.clear();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.820 -0400", hash_original_method = "94CE8407A5E1B53B6799DEAF3D95D61E", hash_generated_method = "309DC9945B995DFD84D12DF54033D057")
    private void onCdmaDataDetached() {
        {
            startNetStatPoll();
            notifyDataConnection(Phone.REASON_CDMA_DATA_DETACHED);
        } //End block
        {
            {
                cleanUpConnection(false, Phone.REASON_CDMA_DATA_DETACHED);
                mDataConnections.get(0).resetRetryCount();
                CdmaCellLocation loc;
                loc = (CdmaCellLocation)(mPhone.getCellLocation());
                EventLog.writeEvent(EventLogTags.CDMA_DATA_SETUP_FAILED,
                        loc != null ? loc.getBaseStationId() : -1,
                        TelephonyManager.getDefault().getNetworkType());
            } //End block
            trySetupData(Phone.REASON_CDMA_DATA_DETACHED);
        } //End block
        // ---------- Original Method ----------
        //if (mState == State.CONNECTED) {
            //startNetStatPoll();
            //notifyDataConnection(Phone.REASON_CDMA_DATA_DETACHED);
        //} else {
            //if (mState == State.FAILED) {
                //cleanUpConnection(false, Phone.REASON_CDMA_DATA_DETACHED);
                //mDataConnections.get(0).resetRetryCount();
                //CdmaCellLocation loc = (CdmaCellLocation)(mPhone.getCellLocation());
                //EventLog.writeEvent(EventLogTags.CDMA_DATA_SETUP_FAILED,
                        //loc != null ? loc.getBaseStationId() : -1,
                        //TelephonyManager.getDefault().getNetworkType());
            //}
            //trySetupData(Phone.REASON_CDMA_DATA_DETACHED);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.820 -0400", hash_original_method = "A262DC774CC921F05CC1B098B136C4F6", hash_generated_method = "46280725906B02D3B60011131AB4DC20")
    private void onCdmaOtaProvision(AsyncResult ar) {
        {
            int [] otaPrivision;
            otaPrivision = (int [])ar.result;
            {
                //Begin case Phone.CDMA_OTA_PROVISION_STATUS_COMMITTED Phone.CDMA_OTA_PROVISION_STATUS_OTAPA_STOPPED 
                mDataConnections.get(0).resetRetryCount();
                //End case Phone.CDMA_OTA_PROVISION_STATUS_COMMITTED Phone.CDMA_OTA_PROVISION_STATUS_OTAPA_STOPPED 
            } //End block
        } //End block
        addTaint(ar.getTaint());
        // ---------- Original Method ----------
        //if (ar.exception != null) {
            //int [] otaPrivision = (int [])ar.result;
            //if ((otaPrivision != null) && (otaPrivision.length > 1)) {
                //switch (otaPrivision[0]) {
                //case Phone.CDMA_OTA_PROVISION_STATUS_COMMITTED:
                //case Phone.CDMA_OTA_PROVISION_STATUS_OTAPA_STOPPED:
                    //mDataConnections.get(0).resetRetryCount();
                    //break;
                //default:
                    //break;
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.821 -0400", hash_original_method = "7F30476887B77149E22CB7625A399926", hash_generated_method = "ABB791C7D2C9D9C7140CE2D9AD137349")
    private void onRestartRadio() {
        {
            log("************TURN OFF RADIO**************");
            mPhone.mCM.setRadioPower(false, null);
            mPendingRestartRadio = false;
        } //End block
        // ---------- Original Method ----------
        //if (mPendingRestartRadio) {
            //log("************TURN OFF RADIO**************");
            //mPhone.mCM.setRadioPower(false, null);
            //mPendingRestartRadio = false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.821 -0400", hash_original_method = "A45AA34613360795905157920DD95009", hash_generated_method = "1AABBA6C205145A35E9E0B4B37CF44E5")
    private void writeEventLogCdmaDataDrop() {
        CdmaCellLocation loc;
        loc = (CdmaCellLocation)(mPhone.getCellLocation());
        EventLog.writeEvent(EventLogTags.CDMA_DATA_DROP,
                loc != null ? loc.getBaseStationId() : -1,
                TelephonyManager.getDefault().getNetworkType());
        // ---------- Original Method ----------
        //CdmaCellLocation loc = (CdmaCellLocation)(mPhone.getCellLocation());
        //EventLog.writeEvent(EventLogTags.CDMA_DATA_DROP,
                //loc != null ? loc.getBaseStationId() : -1,
                //TelephonyManager.getDefault().getNetworkType());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.822 -0400", hash_original_method = "D056F1F93E1FCCA005B3D5C4043A4B41", hash_generated_method = "C70A0AC3A55FA4EFF36A77D416B872FB")
    protected void onDataStateChanged(AsyncResult ar) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        ArrayList<DataCallState> dataCallStates;
        dataCallStates = (ArrayList<DataCallState>)(ar.result);
        {
            boolean isActiveOrDormantConnectionPresent;
            isActiveOrDormantConnectionPresent = false;
            int connectionState;
            connectionState = DATA_CONNECTION_ACTIVE_PH_LINK_INACTIVE;
            {
                int index;
                index = 0;
                boolean varAB81A6C3AD8914A2AA2E8C9A0D6C9CA7_1069312647 = (index < dataCallStates.size());
                {
                    connectionState = dataCallStates.get(index).active;
                    {
                        isActiveOrDormantConnectionPresent = true;
                    } //End block
                } //End block
            } //End collapsed parenthetic
            {
                log("onDataStateChanged: No active connection"
                        + "state is CONNECTED, disconnecting/cleanup");
                writeEventLogCdmaDataDrop();
                cleanUpConnection(true, null);
            } //End block
            //Begin case DATA_CONNECTION_ACTIVE_PH_LINK_UP 
            log("onDataStateChanged: active=LINK_ACTIVE && CONNECTED, ignore");
            //End case DATA_CONNECTION_ACTIVE_PH_LINK_UP 
            //Begin case DATA_CONNECTION_ACTIVE_PH_LINK_UP 
            mActivity = Activity.NONE;
            //End case DATA_CONNECTION_ACTIVE_PH_LINK_UP 
            //Begin case DATA_CONNECTION_ACTIVE_PH_LINK_UP 
            mPhone.notifyDataActivity();
            //End case DATA_CONNECTION_ACTIVE_PH_LINK_UP 
            //Begin case DATA_CONNECTION_ACTIVE_PH_LINK_UP 
            startNetStatPoll();
            //End case DATA_CONNECTION_ACTIVE_PH_LINK_UP 
            //Begin case DATA_CONNECTION_ACTIVE_PH_LINK_DOWN 
            log("onDataStateChanged active=LINK_DOWN && CONNECTED, dormant");
            //End case DATA_CONNECTION_ACTIVE_PH_LINK_DOWN 
            //Begin case DATA_CONNECTION_ACTIVE_PH_LINK_DOWN 
            mActivity = Activity.DORMANT;
            //End case DATA_CONNECTION_ACTIVE_PH_LINK_DOWN 
            //Begin case DATA_CONNECTION_ACTIVE_PH_LINK_DOWN 
            mPhone.notifyDataActivity();
            //End case DATA_CONNECTION_ACTIVE_PH_LINK_DOWN 
            //Begin case DATA_CONNECTION_ACTIVE_PH_LINK_DOWN 
            stopNetStatPoll();
            //End case DATA_CONNECTION_ACTIVE_PH_LINK_DOWN 
            //Begin case default 
            log("onDataStateChanged: IGNORE unexpected DataCallState.active="
                            + connectionState);
            //End case default 
        } //End block
        {
            log("onDataStateChanged: not connected, state=" + mState + " ignoring");
        } //End block
        addTaint(ar.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.825 -0400", hash_original_method = "E7620C231D98F2722A026ACACB1534C7", hash_generated_method = "C8E00807E70088D572C043DE0B3AC1E4")
    private void startDelayedRetry(FailCause cause, String reason) {
        notifyNoData(cause);
        reconnectAfterFail(cause, reason);
        addTaint(cause.getTaint());
        addTaint(reason.getTaint());
        // ---------- Original Method ----------
        //notifyNoData(cause);
        //reconnectAfterFail(cause, reason);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.826 -0400", hash_original_method = "23AB21BFEE9B8AADED0100AF4BC4730D", hash_generated_method = "07AA25C5AE07946E0F46515B1F8A6822")
    @Override
    public void handleMessage(Message msg) {
        log("CdmaDCT handleMessage msg=" + msg);
        {
            log("Ignore CDMA msgs since CDMA phone is inactive");
        } //End block
        //Begin case EVENT_RECORDS_LOADED 
        onRecordsLoaded();
        //End case EVENT_RECORDS_LOADED 
        //Begin case EVENT_NV_READY 
        onNVReady();
        //End case EVENT_NV_READY 
        //Begin case EVENT_CDMA_DATA_DETACHED 
        onCdmaDataDetached();
        //End case EVENT_CDMA_DATA_DETACHED 
        //Begin case EVENT_DATA_STATE_CHANGED 
        onDataStateChanged((AsyncResult) msg.obj);
        //End case EVENT_DATA_STATE_CHANGED 
        //Begin case EVENT_CDMA_OTA_PROVISION 
        onCdmaOtaProvision((AsyncResult) msg.obj);
        //End case EVENT_CDMA_OTA_PROVISION 
        //Begin case EVENT_RESTART_RADIO 
        log("EVENT_RESTART_RADIO");
        //End case EVENT_RESTART_RADIO 
        //Begin case EVENT_RESTART_RADIO 
        onRestartRadio();
        //End case EVENT_RESTART_RADIO 
        //Begin case default 
        super.handleMessage(msg);
        //End case default 
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.826 -0400", hash_original_method = "40E4BCBCB488969F7D8EBF5CAA1BFE5A", hash_generated_method = "81924A886BF652D8A6163CEB785FA7CC")
    @Override
    public boolean isDisconnected() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_719958030 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_719958030;
        // ---------- Original Method ----------
        //return ((mState == State.IDLE) || (mState == State.FAILED));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.827 -0400", hash_original_method = "C5FFF855C74ADBDA37AC74CEDF90027C", hash_generated_method = "558A1E3C9DFBF9E05BDDD5DEF2EF1EBE")
    @Override
    protected void log(String s) {
        Log.d(LOG_TAG, "[CdmaDCT] " + s);
        addTaint(s.getTaint());
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[CdmaDCT] " + s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.827 -0400", hash_original_method = "509A4E6BF6CDBAFC8ECDCC1462D37923", hash_generated_method = "0979C2E06128B79454FA9227F61207E5")
    @Override
    protected void loge(String s) {
        addTaint(s.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[CdmaDCT] " + s);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.827 -0400", hash_original_field = "07521AF9343CE7B0F1FDA0931E9D1853", hash_generated_field = "FF8345B059D372151950C89948FDBB22")

    private static int TIME_DELAYED_TO_RESTART_RADIO = SystemProperties.getInt("ro.cdma.timetoradiorestart", 60000);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.827 -0400", hash_original_field = "8BDC86CA7F932B0E570620C076050629", hash_generated_field = "C108A839D65499C52E19757AC109557B")

    private static int DATA_CONNECTION_POOL_SIZE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.827 -0400", hash_original_field = "9BD7934FD72152CF2A0C509972E1348D", hash_generated_field = "BF97A0BC88083EF7CA6688E96F6C1BE7")

    private static String INTENT_RECONNECT_ALARM = "com.android.internal.telephony.cdma-reconnect";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.827 -0400", hash_original_field = "3E7D706FF7519F453045457C432050D2", hash_generated_field = "33AEFE1BEFED9D0E50EBE530D10C2548")

    private static String INTENT_DATA_STALL_ALARM = "com.android.internal.telephony.cdma-data-stall";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.827 -0400", hash_original_field = "B0662EDCAF5EB88046EB78EE4B5A76C2", hash_generated_field = "E87CC3F75BF1737849CE5FD02A69C674")

    private static int DATA_CONNECTION_ACTIVE_PH_LINK_INACTIVE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.827 -0400", hash_original_field = "5C6E63602F34ECBFD0F2B713F582E11D", hash_generated_field = "0D292C9607B36F727D1333BCD13D54B1")

    private static int DATA_CONNECTION_ACTIVE_PH_LINK_DOWN = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.827 -0400", hash_original_field = "470D920CDB15F9878B90DEB2DE9258C1", hash_generated_field = "092FE99E144772077602076595097725")

    private static int DATA_CONNECTION_ACTIVE_PH_LINK_UP = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.827 -0400", hash_original_field = "C74D643B2F20AEC802C28072AC8B3CD3", hash_generated_field = "7941676928A79488864AF4D722813404")

    private static String[] mSupportedApnTypes = {
            Phone.APN_TYPE_DEFAULT,
            Phone.APN_TYPE_MMS,
            Phone.APN_TYPE_DUN,
            Phone.APN_TYPE_HIPRI };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.827 -0400", hash_original_field = "0EF95A41F9DB20AECFBBE93D89AB06A4", hash_generated_field = "8487AB5548CDCCAEE0CACAF89A32D9D2")

    private static String[] mDefaultApnTypes = {
            Phone.APN_TYPE_DEFAULT,
            Phone.APN_TYPE_MMS,
            Phone.APN_TYPE_HIPRI };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.827 -0400", hash_original_field = "0808FF718AAFC80A11429FFA40CC973A", hash_generated_field = "8522C402CC7B04156F21CFCC2BAA91B7")

    private static int mDefaultApnId = DataConnectionTracker.APN_DEFAULT_ID;
}

