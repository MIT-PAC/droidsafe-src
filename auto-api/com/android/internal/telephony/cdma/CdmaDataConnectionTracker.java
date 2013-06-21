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
import com.android.internal.telephony.RILConstants;
import com.android.internal.telephony.Phone;
import com.android.internal.util.AsyncChannel;
import java.util.ArrayList;

public final class CdmaDataConnectionTracker extends DataConnectionTracker {
    protected String LOG_TAG = "CDMA";
    private CDMAPhone mCdmaPhone;
    private CdmaDataConnection mPendingDataConnection;
    private boolean mPendingRestartRadio = false;
    private String[] mDunApnTypes = {
            Phone.APN_TYPE_DUN };
    private Runnable mPollNetStat = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.435 -0400", hash_original_method = "2461514E52B21E636B4BA6EEA10AC2AC", hash_generated_method = "BDBE748D2F2A0E2B2F26E6A30F582B17")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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
                        boolean varBBAB054B93002BE077662707D96150A8_1658218898 = (mPhone.getState()  == Phone.State.IDLE);
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

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.436 -0400", hash_original_method = "E727B326B8B79B2FCD5BA791E85007D7", hash_generated_method = "13C7C049B843E38729FCEDBDB6405D8D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     CdmaDataConnectionTracker(CDMAPhone p) {
        super(p);
        dsTaint.addTaint(p.dsTaint);
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
        Context c;
        c = mCdmaPhone.getContext();
        String[] t;
        t = c.getResources().getStringArray(
                com.android.internal.R.array.config_cdma_dun_supported_types);
        {
            ArrayList<String> temp;
            temp = new ArrayList<String>();
            {
                int i;
                i = 0;
                {
                    {
                        boolean var41C37A1B84985D7F3E75B60C153770EC_1029704734 = (!Phone.APN_TYPE_DUN.equalsIgnoreCase(t[i]));
                        {
                            temp.add(t[i]);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            temp.add(0, Phone.APN_TYPE_DUN);
            mDunApnTypes = temp.toArray(t);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.436 -0400", hash_original_method = "9776A85903E6D9EBA65DAB07962EE007", hash_generated_method = "334D3D2DE1A6097F9BC65830352655A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void dispose() {
        cleanUpConnection(false, null, false);
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
        //cleanUpConnection(false, null, false);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.436 -0400", hash_original_method = "3DB74CB183E0997C0A31C0F47FB531FD", hash_generated_method = "56792E5FE8E366D5E4E3C9786B081157")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void finalize() {
        log("CdmaDataConnectionTracker finalized");
        // ---------- Original Method ----------
        //if(DBG) log("CdmaDataConnectionTracker finalized");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.437 -0400", hash_original_method = "477FAE9A0F7056536F0C43A4344C1E00", hash_generated_method = "2601B2CD85742A490DD38F2EDDD6E837")
    @DSModeled(DSC.SAFE)
    @Override
    protected String getActionIntentReconnectAlarm() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return INTENT_RECONNECT_ALARM;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.437 -0400", hash_original_method = "BBE23E9137760572C0B9E85F7DE2F87D", hash_generated_method = "D995B620F1284E6CCA92E01C960F1FC5")
    @DSModeled(DSC.SAFE)
    @Override
    protected String getActionIntentDataStallAlarm() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return INTENT_DATA_STALL_ALARM;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.437 -0400", hash_original_method = "7C4A424CA47A5D9C8651DA37E1912616", hash_generated_method = "281DFBC53F7E41BACAFC3FD7F6BF240D")
    @DSModeled(DSC.SAFE)
    @Override
    protected void restartDataStallAlarm() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.437 -0400", hash_original_method = "8F51415486D92DEB617BF78EBB2ED95B", hash_generated_method = "C164EEC6785AE4BA93B37D6A11CE8C08")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void setState(State s) {
        dsTaint.addTaint(s.dsTaint);
        log ("setState: " + s);
        {
            EventLog.writeEvent(EventLogTags.CDMA_DATA_STATE_CHANGE,
                    mState.toString(), s.toString());
            mState = s;
        } //End block
        // ---------- Original Method ----------
        //if (DBG) log ("setState: " + s);
        //if (mState != s) {
            //EventLog.writeEvent(EventLogTags.CDMA_DATA_STATE_CHANGE,
                    //mState.toString(), s.toString());
            //mState = s;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.437 -0400", hash_original_method = "53DA179904795C28B8C89E7D1C885E11", hash_generated_method = "0D7D9D19BEFE06E385974662CC85079A")
    @DSModeled(DSC.SAFE)
    @Override
    public synchronized State getState(String apnType) {
        dsTaint.addTaint(apnType);
        return (State)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.440 -0400", hash_original_method = "3AFAE11AEA6F5EDA9B4571182280207F", hash_generated_method = "E756C5C11A69965672F1A95AD1EC4CF1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean isApnTypeAvailable(String type) {
        dsTaint.addTaint(type);
        {
            Iterator<String> var371F9C1ED12B38A1BF6177EB240D4150_679226034 = (mSupportedApnTypes).iterator();
            var371F9C1ED12B38A1BF6177EB240D4150_679226034.hasNext();
            String s = var371F9C1ED12B38A1BF6177EB240D4150_679226034.next();
            {
                {
                    boolean varB6BAD33EB61876AC704EE691A9BB5A05_1041037525 = (TextUtils.equals(type, s));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //for (String s : mSupportedApnTypes) {
            //if (TextUtils.equals(type, s)) {
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.441 -0400", hash_original_method = "9C8BD4DF5E16D62D69E8FF9092013691", hash_generated_method = "7B3DC5428E17D72F2457B552A4A3AFE2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
                    ((mPhone.getLteOnCdmaMode() == Phone.LTE_ON_CDMA_TRUE) ||
                            !mCdmaPhone.needsOtaServiceProvisioning());
        {
            String reason;
            reason = "";
            {
                reason += " - psState= " + psState;
            } //End block
            {
                boolean var27C7393FEEA9515E8D28CD63EF68AAD3_1332306012 = (!(mPhone.mCM.getNvState() == CommandsInterface.RadioState.NV_READY ||
                    mCdmaPhone.mIccRecords.getRecordsLoaded()));
                {
                    reason += " - radioState= " + mPhone.mCM.getNvState() + " - RUIM not loaded";
                } //End block
            } //End collapsed parenthetic
            {
                boolean var97339E74162EFDAB27E8C356C17FDB93_700105368 = (!(mCdmaPhone.mSST.isConcurrentVoiceAndDataAllowed() ||
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
                boolean varAED17B66ECABE29ECB94AC584BD19AFC_1653782074 = (mCdmaPhone.needsOtaServiceProvisioning());
                reason += " - needs Provisioning";
            } //End collapsed parenthetic
            log("Data not allowed due to" + reason);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.441 -0400", hash_original_method = "F4A377E51CCB46CDBA97F4F221100777", hash_generated_method = "EEDE2E5370DF9A42808C49FF1BCDD3C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean isDataPossible(String apnType) {
        dsTaint.addTaint(apnType);
        boolean possible;
        possible = isDataAllowed() && !(getAnyDataEnabled() &&
                (mState == State.FAILED || mState == State.IDLE));
        {
            boolean var9B048D6DEF0B0137767C8E3F72E8439A_733354478 = (!possible && DBG && isDataAllowed());
            {
                log("Data not possible.  No coverage: dataState = " + mState);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean possible = isDataAllowed() && !(getAnyDataEnabled() &&
                //(mState == State.FAILED || mState == State.IDLE));
        //if (!possible && DBG && isDataAllowed()) {
            //log("Data not possible.  No coverage: dataState = " + mState);
        //}
        //return possible;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.441 -0400", hash_original_method = "394F83083B165868EFF2D0029A637488", hash_generated_method = "234E6B74ACCBB8A65E819C066928E3A9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean trySetupData(String reason) {
        dsTaint.addTaint(reason);
        log("***trySetupData due to " + (reason == null ? "(unspecified)" : reason));
        {
            boolean varA62B422C35237A9A4A0C0A75D57190F8_1631960604 = (mPhone.getSimulatedRadioControl() != null);
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
            boolean var949370AE43AD6FBCD95157798F7FB0DF_573813499 = ((mState == State.IDLE || mState == State.SCANNING) &&
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
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.445 -0400", hash_original_method = "ACDE3C2501408E85726B9386971AC1E8", hash_generated_method = "548774FF4C7425C9361AA87DBFAA80EC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void cleanUpConnection(boolean tearDown, String reason, boolean doAll) {
        dsTaint.addTaint(reason);
        dsTaint.addTaint(doAll);
        dsTaint.addTaint(tearDown);
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
            Iterator<DataConnection> var5FF8B81A220FD894D705CD5B3B4CA034_261634201 = (mDataConnections.values()).iterator();
            var5FF8B81A220FD894D705CD5B3B4CA034_261634201.hasNext();
            DataConnection conn = var5FF8B81A220FD894D705CD5B3B4CA034_261634201.next();
            {
                {
                    DataConnectionAc dcac;
                    dcac = mDataConnectionAsyncChannels.get(conn.getDataConnectionId());
                    {
                        {
                            log("cleanUpConnection: teardown, conn.tearDownAll");
                            conn.tearDownAll(reason, obtainMessage(EVENT_DISCONNECT_DONE,
                                conn.getDataConnectionId(), 0, reason));
                        } //End block
                        {
                            log("cleanUpConnection: teardown, conn.tearDown");
                            conn.tearDown(reason, obtainMessage(EVENT_DISCONNECT_DONE,
                                conn.getDataConnectionId(), 0, reason));
                        } //End block
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.448 -0400", hash_original_method = "CCC265A96715FBE2FE51B6C51A4C9789", hash_generated_method = "6389D78139D435970BA09F08D6866CF0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private CdmaDataConnection findFreeDataConnection() {
        {
            Iterator<DataConnectionAc> varEB8626173DB084FB4853115B28BD3F62_305248629 = (mDataConnectionAsyncChannels.values()).iterator();
            varEB8626173DB084FB4853115B28BD3F62_305248629.hasNext();
            DataConnectionAc dcac = varEB8626173DB084FB4853115B28BD3F62_305248629.next();
            {
                {
                    boolean var63D661D51186954ED4E8C4223E8E3B75_35781773 = (dcac.isInactiveSync());
                    {
                        log("found free GsmDataConnection");
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        log("NO free CdmaDataConnection");
        return (CdmaDataConnection)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.449 -0400", hash_original_method = "D44F39F8D3A8EAB211A4C2A2503CC421", hash_generated_method = "D97337BE16F43E088BE1EDDE919BD917")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean setupData(String reason) {
        dsTaint.addTaint(reason);
        CdmaDataConnection conn;
        conn = findFreeDataConnection();
        {
            log("setupData: No free CdmaDataConnection found!");
        } //End block
        mPendingDataConnection = conn;
        String[] types;
        int apnId;
        {
            boolean var606A60405C260349B54220DED9004DA3_1033255832 = (mRequestedApnType.equals(Phone.APN_TYPE_DUN));
            {
                types = mDunApnTypes;
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
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.449 -0400", hash_original_method = "A9B26E176D50C7947D632921998F13D5", hash_generated_method = "E61F1301DD7D2973A7D4428D49BFB99F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void notifyDefaultData(String reason) {
        dsTaint.addTaint(reason);
        setState(State.CONNECTED);
        notifyDataConnection(reason);
        startNetStatPoll();
        mDataConnections.get(0).resetRetryCount();
        // ---------- Original Method ----------
        //setState(State.CONNECTED);
        //notifyDataConnection(reason);
        //startNetStatPoll();
        //mDataConnections.get(0).resetRetryCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.449 -0400", hash_original_method = "4334EC28628BC2618150E7F73B49358F", hash_generated_method = "CA71E84F421FB531DEE0DB608D05FC5A")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.450 -0400", hash_original_method = "89653F3210B52B01F9AED56AD5EFB50E", hash_generated_method = "201C936746B18BFA4DD690E4BE58C178")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.450 -0400", hash_original_method = "B87E2D0F3C8EA5B297B25E95FDB4C600", hash_generated_method = "E63291039876CC2FCDDBA8BE3EFC765C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.450 -0400", hash_original_method = "5AA50F54A3015F5F6ACA18B3174FAEC2", hash_generated_method = "E201AD4E8952C0DEB5AFC8EBC32D5FF2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.450 -0400", hash_original_method = "7D555C87655E096A1AB206CCF6046FBB", hash_generated_method = "2BFA36410B78F4873DC9632BC9BA8D38")
    @DSModeled(DSC.SAFE)
    private boolean shouldPostNotification(FailCause cause) {
        dsTaint.addTaint(cause.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (cause != FailCause.UNKNOWN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.450 -0400", hash_original_method = "62A24BB1F647222AA978F8E837B2D330", hash_generated_method = "4A71D0C3F2C4B95FF1265FE034DC21DE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean retryAfterDisconnected(String reason) {
        dsTaint.addTaint(reason);
        boolean retry;
        retry = true;
        {
            boolean var3CB82CF3031EDB1F7F9E067EE7B1B74E_1295535768 = (Phone.REASON_RADIO_TURNED_OFF.equals(reason));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.451 -0400", hash_original_method = "0F3E1A9BD48FDD78A940EF7E069D2A10", hash_generated_method = "BD312955C2D795433085B3730B7E125C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void reconnectAfterFail(FailCause lastFailCauseCode, String reason, int retryOverride) {
        dsTaint.addTaint(reason);
        dsTaint.addTaint(retryOverride);
        dsTaint.addTaint(lastFailCauseCode.dsTaint);
        {
            int nextReconnectDelay;
            nextReconnectDelay = retryOverride;
            {
                nextReconnectDelay = mDataConnections.get(0).getRetryTimer();
                mDataConnections.get(0).increaseRetryCount();
            } //End block
            startAlarmForReconnect(nextReconnectDelay, reason);
            {
                boolean varFD6404B1A9502D19A8FBA94C0DD3DAAF_1258612569 = (!shouldPostNotification(lastFailCauseCode));
                {
                    log("NOT Posting Data Connection Unavailable notification "
                                + "-- likely transient error");
                } //End block
                {
                    notifyNoData(lastFailCauseCode);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //if (mState == State.FAILED) {
            //int nextReconnectDelay = retryOverride;
            //if (nextReconnectDelay < 0) {
                //nextReconnectDelay = mDataConnections.get(0).getRetryTimer();
                //mDataConnections.get(0).increaseRetryCount();
            //}
            //startAlarmForReconnect(nextReconnectDelay, reason);
            //if (!shouldPostNotification(lastFailCauseCode)) {
                //log("NOT Posting Data Connection Unavailable notification "
                                //+ "-- likely transient error");
            //} else {
                //notifyNoData(lastFailCauseCode);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.451 -0400", hash_original_method = "E44CA37DEACEC190565F77C6CB5940AA", hash_generated_method = "BDB914084626088911272F3702FF1DE2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void startAlarmForReconnect(int delay, String reason) {
        dsTaint.addTaint(reason);
        dsTaint.addTaint(delay);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.452 -0400", hash_original_method = "906A69878943A02EC5DE4E13B27C21B4", hash_generated_method = "D46EE40C725A37D2D98F6F4CA7CEAA84")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void notifyNoData(FailCause lastFailCauseCode) {
        dsTaint.addTaint(lastFailCauseCode.dsTaint);
        setState(State.FAILED);
        notifyOffApnsOfAvailability(null);
        // ---------- Original Method ----------
        //setState(State.FAILED);
        //notifyOffApnsOfAvailability(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.452 -0400", hash_original_method = "FC06F936895E8DDA4082B1191F41BF76", hash_generated_method = "60CD61297DA51501E39C3C8CBE729557")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void gotoIdleAndNotifyDataConnection(String reason) {
        dsTaint.addTaint(reason);
        log("gotoIdleAndNotifyDataConnection: reason=" + reason);
        setState(State.IDLE);
        notifyDataConnection(reason);
        mActiveApn = null;
        // ---------- Original Method ----------
        //if (DBG) log("gotoIdleAndNotifyDataConnection: reason=" + reason);
        //setState(State.IDLE);
        //notifyDataConnection(reason);
        //mActiveApn = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.452 -0400", hash_original_method = "E23B6E1AC9BCA9F124B3E389B7DEE3CE", hash_generated_method = "BAF01EAB267D3A439EDB52D7CFEB8542")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.453 -0400", hash_original_method = "E1428BF12D5C40E221347D3CB6592677", hash_generated_method = "6B849ADC5E2E4D55E726038CDBD0525A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.453 -0400", hash_original_method = "32EF5FE45C92585EFB8684C0DBC07DA3", hash_generated_method = "AC7A6A67510BBA094110D9B86CF95839")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onEnableNewApn() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        cleanUpConnection(true, Phone.REASON_APN_SWITCHED, false);
        // ---------- Original Method ----------
        //cleanUpConnection(true, Phone.REASON_APN_SWITCHED, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.453 -0400", hash_original_method = "D1EA04ADDFE8BEB96FCA5B0EBDBE27E4", hash_generated_method = "8771064D753430D63A737FD713429C97")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean onTrySetupData(String reason) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(reason);
        boolean varEF2870B84D286EC80F19694D55F0ACD0_1042496675 = (trySetupData(reason));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return trySetupData(reason);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.453 -0400", hash_original_method = "456B5B4117DFD69A8357ABE29B636ADA", hash_generated_method = "C00B1A1D29607F53AE4E5441F2A0A1C9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onRoamingOff() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var6A4EDF3FAFEE8B58E0E885094E7C645E_409396342 = (getDataOnRoamingEnabled() == false);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.453 -0400", hash_original_method = "05517986BB1CA537C6FCF607816BF093", hash_generated_method = "38BBCBFD92507CF87FBFB7DFE341F7BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onRoamingOn() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var178FD459AA12B1549B96EFDE7D504A27_1762026853 = (getDataOnRoamingEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.454 -0400", hash_original_method = "F74A764B82D382E1DF4133E695EBD591", hash_generated_method = "DDB3524E905647D7D1A6BAD67860F984")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onRadioAvailable() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean varA62B422C35237A9A4A0C0A75D57190F8_957991552 = (mPhone.getSimulatedRadioControl() != null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.454 -0400", hash_original_method = "13044BD14789126E4C7F4A6581DB22DE", hash_generated_method = "49348CAF3FA1BB78A3BF238D7E0570ED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onRadioOffOrNotAvailable() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mDataConnections.get(0).resetRetryCount();
        {
            boolean varA62B422C35237A9A4A0C0A75D57190F8_870114454 = (mPhone.getSimulatedRadioControl() != null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.454 -0400", hash_original_method = "950404173D811F936962213890C3F2A0", hash_generated_method = "403B7F643606CB05DC8479B85C085C4E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onDataSetupComplete(AsyncResult ar) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(ar.dsTaint);
        String reason;
        reason = null;
        {
            reason = (String) ar.userObj;
        } //End block
        {
            boolean varB5E9B7D9BBFA45BCF027FCB550EA1FBB_854892555 = (isDataSetupCompleteOk(ar));
            {
                notifyDefaultData(reason);
            } //End block
            {
                FailCause cause;
                cause = (FailCause) (ar.result);
                log("Data Connection setup failed " + cause);
                {
                    boolean var66182ADBA155CABC56AA3975E9DBF19F_397318955 = (cause.isPermanentFail());
                    {
                        notifyNoData(cause);
                    } //End block
                } //End collapsed parenthetic
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
                    startDelayedRetry(cause, reason, retryOverride);
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.455 -0400", hash_original_method = "B64AD173877EB61F2BA995A6B9586953", hash_generated_method = "D3E77617BC8F0EC5327290DF9D3BAAF6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onDisconnectDone(int connId, AsyncResult ar) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(connId);
        dsTaint.addTaint(ar.dsTaint);
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
            boolean var3BF0D3CF7742E29D226663A325AF3E66_829191798 = (ssTracker.processPendingRadioPowerOffAfterDataOff());
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
            boolean var617E4454D58A131493E80C30AF839FE7_677521145 = (retryAfterDisconnected(reason));
            {
                startAlarmForReconnect(APN_DELAY_MILLIS, reason);
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.455 -0400", hash_original_method = "8669708C7F9DB85ADE9303FE8B7AF6BC", hash_generated_method = "A6429B393B3E8B77A4076E1D9AB4AB74")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onVoiceCallStarted() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var6AA65BBEFDBDAA95AEEF52A5CA0586D8_972167863 = (mState == State.CONNECTED && !mCdmaPhone.mSST.isConcurrentVoiceAndDataAllowed());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.455 -0400", hash_original_method = "A8CF6D26E9B870CF97B1A301601A4493", hash_generated_method = "7D7EC73A506EDE9878438B5DD52FE372")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onVoiceCallEnded() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            {
                boolean var894FAD0CD22FBCEF534C22052BAF7B7C_1956393303 = (!mCdmaPhone.mSST.isConcurrentVoiceAndDataAllowed());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.455 -0400", hash_original_method = "CBC649919A741D0112C400C279B6FB04", hash_generated_method = "865597ED5576A3587E3B5BB56937F26B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onCleanUpConnection(boolean tearDown, int apnId, String reason) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(reason);
        dsTaint.addTaint(apnId);
        dsTaint.addTaint(tearDown);
        cleanUpConnection(tearDown, reason, (apnId == APN_DUN_ID));
        // ---------- Original Method ----------
        //cleanUpConnection(tearDown, reason, (apnId == APN_DUN_ID));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.456 -0400", hash_original_method = "BC46AEB4FB2296D7112F191C89A86DF9", hash_generated_method = "7D68D3C053AC9F394CA921FDE6A94A33")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onCleanUpAllConnections(String cause) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(cause);
        cleanUpConnection(true, cause, false);
        // ---------- Original Method ----------
        //cleanUpConnection(true, cause, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.456 -0400", hash_original_method = "344B7BD155952984B55976C77E8E3628", hash_generated_method = "6B01C7474BF381B39E5E37C748052094")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
                    boolean var2A9F58BFB955FE221076F10F69C4E35A_1886195653 = (!rm.configure(retryConfig));
                    {
                        {
                            boolean varC9DB307BFBF42DC07215EF2C6586368D_459607228 = (!rm.configure(DEFAULT_DATA_RETRY_CONFIG));
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
                dataConn = CdmaDataConnection.makeDataConnection(mCdmaPhone, id, rm, this);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.456 -0400", hash_original_method = "8430EFDC31AB81EB1D7F0972246BF5F1", hash_generated_method = "69D95EAEF6987DF2357B662FCADD27F0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void destroyAllDataConnectionList() {
        {
            mDataConnections.clear();
        } //End block
        // ---------- Original Method ----------
        //if(mDataConnections != null) {
            //mDataConnections.clear();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.456 -0400", hash_original_method = "32A9BC2A3953147A4E76AB531D8177F8", hash_generated_method = "F36AF8EC462EA8D3EC831536C9598F2E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void onCdmaDataDetached() {
        {
            startNetStatPoll();
            notifyDataConnection(Phone.REASON_CDMA_DATA_DETACHED);
        } //End block
        {
            {
                cleanUpConnection(false, Phone.REASON_CDMA_DATA_DETACHED, false);
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
                //cleanUpConnection(false, Phone.REASON_CDMA_DATA_DETACHED, false);
                //mDataConnections.get(0).resetRetryCount();
                //CdmaCellLocation loc = (CdmaCellLocation)(mPhone.getCellLocation());
                //EventLog.writeEvent(EventLogTags.CDMA_DATA_SETUP_FAILED,
                        //loc != null ? loc.getBaseStationId() : -1,
                        //TelephonyManager.getDefault().getNetworkType());
            //}
            //trySetupData(Phone.REASON_CDMA_DATA_DETACHED);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.457 -0400", hash_original_method = "A262DC774CC921F05CC1B098B136C4F6", hash_generated_method = "622DA3EB3165F774367225A6A29330C6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void onCdmaOtaProvision(AsyncResult ar) {
        dsTaint.addTaint(ar.dsTaint);
        {
            int [] otaPrivision;
            otaPrivision = (int [])ar.result;
            {
                //Begin case Phone.CDMA_OTA_PROVISION_STATUS_COMMITTED Phone.CDMA_OTA_PROVISION_STATUS_OTAPA_STOPPED 
                mDataConnections.get(0).resetRetryCount();
                //End case Phone.CDMA_OTA_PROVISION_STATUS_COMMITTED Phone.CDMA_OTA_PROVISION_STATUS_OTAPA_STOPPED 
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.457 -0400", hash_original_method = "7F30476887B77149E22CB7625A399926", hash_generated_method = "ABB791C7D2C9D9C7140CE2D9AD137349")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.457 -0400", hash_original_method = "A45AA34613360795905157920DD95009", hash_generated_method = "1AABBA6C205145A35E9E0B4B37CF44E5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.458 -0400", hash_original_method = "29591FB4377C34C32A5776457A523D7E", hash_generated_method = "081C842A05356B705C85C45C612429B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void onDataStateChanged(AsyncResult ar) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(ar.dsTaint);
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
                boolean varAB81A6C3AD8914A2AA2E8C9A0D6C9CA7_420425 = (index < dataCallStates.size());
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
                cleanUpConnection(true, null, false);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.458 -0400", hash_original_method = "684FE473590173694DFF6F10A020E7ED", hash_generated_method = "88BB92A25B886997DDD8B872CE4D7557")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void startDelayedRetry(FailCause cause, String reason, int retryOverride) {
        dsTaint.addTaint(cause.dsTaint);
        dsTaint.addTaint(reason);
        dsTaint.addTaint(retryOverride);
        notifyNoData(cause);
        reconnectAfterFail(cause, reason, retryOverride);
        // ---------- Original Method ----------
        //notifyNoData(cause);
        //reconnectAfterFail(cause, reason, retryOverride);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.458 -0400", hash_original_method = "23AB21BFEE9B8AADED0100AF4BC4730D", hash_generated_method = "C2505CF7213C7B4E17CCEC4B0C3BC011")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void handleMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.458 -0400", hash_original_method = "40E4BCBCB488969F7D8EBF5CAA1BFE5A", hash_generated_method = "451B0A71199647824F6640AE3386B510")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isDisconnected() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return ((mState == State.IDLE) || (mState == State.FAILED));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.459 -0400", hash_original_method = "C5FFF855C74ADBDA37AC74CEDF90027C", hash_generated_method = "BFB047000830F317C791AA7470547DCC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void log(String s) {
        dsTaint.addTaint(s);
        Log.d(LOG_TAG, "[CdmaDCT] " + s);
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[CdmaDCT] " + s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.459 -0400", hash_original_method = "509A4E6BF6CDBAFC8ECDCC1462D37923", hash_generated_method = "95D7AE83ECDFB88BE96465EA52057F9C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void loge(String s) {
        dsTaint.addTaint(s);
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[CdmaDCT] " + s);
    }

    
    private static final int TIME_DELAYED_TO_RESTART_RADIO =
            SystemProperties.getInt("ro.cdma.timetoradiorestart", 60000);
    private static final int DATA_CONNECTION_POOL_SIZE = 1;
    private static final String INTENT_RECONNECT_ALARM =
        "com.android.internal.telephony.cdma-reconnect";
    private static final String INTENT_DATA_STALL_ALARM =
        "com.android.internal.telephony.cdma-data-stall";
    private static final int DATA_CONNECTION_ACTIVE_PH_LINK_INACTIVE = 0;
    private static final int DATA_CONNECTION_ACTIVE_PH_LINK_DOWN = 1;
    private static final int DATA_CONNECTION_ACTIVE_PH_LINK_UP = 2;
    private static final String[] mSupportedApnTypes = {
            Phone.APN_TYPE_DEFAULT,
            Phone.APN_TYPE_MMS,
            Phone.APN_TYPE_DUN,
            Phone.APN_TYPE_HIPRI };
    private static final String[] mDefaultApnTypes = {
            Phone.APN_TYPE_DEFAULT,
            Phone.APN_TYPE_MMS,
            Phone.APN_TYPE_HIPRI };
    private static final int mDefaultApnId = DataConnectionTracker.APN_DEFAULT_ID;
}

