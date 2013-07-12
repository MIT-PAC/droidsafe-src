package com.android.internal.telephony.cdma;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.330 -0400", hash_original_field = "951C150E6D062E6AED2C45BB9B756185", hash_generated_field = "692A09C40EE40FAEE399CBCFE2A5ACE4")

    protected final String LOG_TAG = "CDMA";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.330 -0400", hash_original_field = "C77218B74238AF8B3595D58067947274", hash_generated_field = "A784BE3C2CA8A9A5385EEA88DD6D3A29")

    private CDMAPhone mCdmaPhone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.330 -0400", hash_original_field = "0A4D06AADF5B2F71B9FA6A482FB61442", hash_generated_field = "EEA8F8B0B01EEAD84F4D26DF11EB97B7")

    private CdmaDataConnection mPendingDataConnection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.330 -0400", hash_original_field = "916FC477FFD163966FA31F037869DCA9", hash_generated_field = "BCBF943C87814D8571E314787E73F3AA")

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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.331 -0400", hash_original_method = "2C5FD67C25932D4938DCF727D105250A", hash_generated_method = "3F43862F61079BC5E612945DBAC96707")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.332 -0400", hash_original_method = "D7D3BFC7AEBB4A854053D0E671EEEB9F", hash_generated_method = "FE4B0CA0759BD685AB39AF74717B1307")
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
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.332 -0400", hash_original_method = "3DB74CB183E0997C0A31C0F47FB531FD", hash_generated_method = "80999DFA62EE4CA8D4449A230C5D2FDE")
    @Override
    protected void finalize() {
    if(DBG)        
        log("CdmaDataConnectionTracker finalized");
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.332 -0400", hash_original_method = "477FAE9A0F7056536F0C43A4344C1E00", hash_generated_method = "EDF6AB68233AEF98A4557E88688983D7")
    @Override
    protected String getActionIntentReconnectAlarm() {
String var329BD4E79853976212F297A2D79B9594_1982353819 =         INTENT_RECONNECT_ALARM;
        var329BD4E79853976212F297A2D79B9594_1982353819.addTaint(taint);
        return var329BD4E79853976212F297A2D79B9594_1982353819;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.333 -0400", hash_original_method = "BBE23E9137760572C0B9E85F7DE2F87D", hash_generated_method = "7E3910F406479878E849A6CFDE6A203B")
    @Override
    protected String getActionIntentDataStallAlarm() {
String var91B284560FDB6DF833F06E9F3D4A1EF3_57160619 =         INTENT_DATA_STALL_ALARM;
        var91B284560FDB6DF833F06E9F3D4A1EF3_57160619.addTaint(taint);
        return var91B284560FDB6DF833F06E9F3D4A1EF3_57160619;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.333 -0400", hash_original_method = "8F51415486D92DEB617BF78EBB2ED95B", hash_generated_method = "8F5FCBB41EE0B10A115B11164E85E5DB")
    @Override
    protected void setState(State s) {
        addTaint(s.getTaint());
    if(DBG)        
        log ("setState: " + s);
    if(mState != s)        
        {
            EventLog.writeEvent(EventLogTags.CDMA_DATA_STATE_CHANGE,
                    mState.toString(), s.toString());
            mState = s;
        } 
        
        
        
            
                    
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.333 -0400", hash_original_method = "53DA179904795C28B8C89E7D1C885E11", hash_generated_method = "0F585238B64608ADD246C8A8A6904E61")
    @Override
    public synchronized State getState(String apnType) {
        addTaint(apnType.getTaint());
State var8B975C85F13BECB9FD4D21A5F3C8A56D_1083569124 =         mState;
        var8B975C85F13BECB9FD4D21A5F3C8A56D_1083569124.addTaint(taint);
        return var8B975C85F13BECB9FD4D21A5F3C8A56D_1083569124;
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.334 -0400", hash_original_method = "3AFAE11AEA6F5EDA9B4571182280207F", hash_generated_method = "57830BAE0E8ACC80B028E5DFFDDA3724")
    @Override
    protected boolean isApnTypeAvailable(String type) {
        addTaint(type.getTaint());
for(String s : mSupportedApnTypes)
        {
    if(TextUtils.equals(type, s))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1223254918 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1915885749 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1915885749;
            } 
        } 
        boolean var68934A3E9455FA72420237EB05902327_535822793 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_321556083 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_321556083;
        
        
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.335 -0400", hash_original_method = "542CE147EB1490D3575F0586BDB29C5B", hash_generated_method = "146B7BB61421A9605273A22CA95B2860")
    @Override
    protected boolean isDataAllowed() {
        boolean internalDataEnabled;
        synchronized
(mDataEnabledLock)        {
            internalDataEnabled = mInternalDataEnabled;
        } 
        int psState = mCdmaPhone.mSST.getCurrentDataConnectionState();
        boolean roaming = (mPhone.getServiceState().getRoaming() && !getDataOnRoamingEnabled());
        boolean desiredPowerState = mCdmaPhone.mSST.getDesiredPowerState();
        boolean allowed = (psState == ServiceState.STATE_IN_SERVICE ||
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
    if(!allowed && DBG)        
        {
            String reason = "";
    if(!((psState == ServiceState.STATE_IN_SERVICE) || mAutoAttachOnCreation))            
            {
                reason += " - psState= " + psState;
            } 
    if(!(mPhone.mCM.getNvState() == CommandsInterface.RadioState.NV_READY ||
                    mCdmaPhone.mIccRecords.getRecordsLoaded()))            
            {
                reason += " - radioState= " + mPhone.mCM.getNvState() + " - RUIM not loaded";
            } 
    if(!(mCdmaPhone.mSST.isConcurrentVoiceAndDataAllowed() ||
                    mPhone.getState() == Phone.State.IDLE))            
            {
                reason += " - concurrentVoiceAndData not allowed and state= " + mPhone.getState();
            } 
    if(roaming)            
            reason += " - Roaming";
    if(!internalDataEnabled)            
            reason += " - mInternalDataEnabled= false";
    if(!desiredPowerState)            
            reason += " - desiredPowerState= false";
    if(mPendingRestartRadio)            
            reason += " - mPendingRestartRadio= true";
    if(mCdmaPhone.needsOtaServiceProvisioning())            
            reason += " - needs Provisioning";
            log("Data not allowed due to" + reason);
        } 
        boolean var22EE71E9DCC9CA12FC313C6E1CE3F806_413488901 = (allowed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1550510808 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1550510808;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.336 -0400", hash_original_method = "F4A377E51CCB46CDBA97F4F221100777", hash_generated_method = "E56B3770B9E8BD5C4FE5AACE01591BAF")
    @Override
    protected boolean isDataPossible(String apnType) {
        addTaint(apnType.getTaint());
        boolean possible = isDataAllowed() && !(getAnyDataEnabled() &&
                (mState == State.FAILED || mState == State.IDLE));
    if(!possible && DBG && isDataAllowed())        
        {
            log("Data not possible.  No coverage: dataState = " + mState);
        } 
        boolean var6FCC4B7D36184BA33346B4BE2D5D8244_1505024844 = (possible);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1526408387 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1526408387;
        
        
                
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.337 -0400", hash_original_method = "394F83083B165868EFF2D0029A637488", hash_generated_method = "BAF2884920DF8E4626BEF95D20A7BC39")
    private boolean trySetupData(String reason) {
        addTaint(reason.getTaint());
    if(DBG)        
        log("***trySetupData due to " + (reason == null ? "(unspecified)" : reason));
    if(mPhone.getSimulatedRadioControl() != null)        
        {
            setState(State.CONNECTED);
            notifyDataConnection(reason);
            notifyOffApnsOfAvailability(reason);
            log("(fix?) We're on the simulator; assuming data is connected");
            boolean varB326B5062B2F0E69046810717534CB09_8811199 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1559574581 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1559574581;
        } 
        int psState = mCdmaPhone.mSST.getCurrentDataConnectionState();
        boolean roaming = mPhone.getServiceState().getRoaming();
        boolean desiredPowerState = mCdmaPhone.mSST.getDesiredPowerState();
    if((mState == State.IDLE || mState == State.SCANNING) &&
                isDataAllowed() && getAnyDataEnabled() && !isEmergency())        
        {
            boolean retValue = setupData(reason);
            notifyOffApnsOfAvailability(reason);
            boolean var9C7BD17E8EB1C3D0F843684A79A18570_1429265151 = (retValue);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1636383824 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1636383824;
        } 
        else
        {
            notifyOffApnsOfAvailability(reason);
            boolean var68934A3E9455FA72420237EB05902327_23354727 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_142236238 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_142236238;
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.338 -0400", hash_original_method = "5189B04FA529AAC9DBE4ECDA45A08A99", hash_generated_method = "2CB1586EF44941036D768B09EA2577C8")
    private void cleanUpConnection(boolean tearDown, String reason) {
        addTaint(reason.getTaint());
        addTaint(tearDown);
    if(DBG)        
        log("cleanUpConnection: reason: " + reason);
    if(mReconnectIntent != null)        
        {
            AlarmManager am = (AlarmManager) mPhone.getContext().getSystemService(Context.ALARM_SERVICE);
            am.cancel(mReconnectIntent);
            mReconnectIntent = null;
        } 
        setState(State.DISCONNECTING);
        notifyOffApnsOfAvailability(reason);
        boolean notificationDeferred = false;
for(DataConnection conn : mDataConnections.values())
        {
    if(conn != null)            
            {
                DataConnectionAc dcac = mDataConnectionAsyncChannels.get(conn.getDataConnectionId());
    if(tearDown)                
                {
    if(DBG)                    
                    log("cleanUpConnection: teardown, call conn.disconnect");
                    conn.tearDown(reason, obtainMessage(EVENT_DISCONNECT_DONE,
                            conn.getDataConnectionId(), 0, reason));
                    notificationDeferred = true;
                } 
                else
                {
    if(DBG)                    
                    log("cleanUpConnection: !tearDown, call conn.resetSynchronously");
    if(dcac != null)                    
                    {
                        dcac.resetSync();
                    } 
                    notificationDeferred = false;
                } 
            } 
        } 
        stopNetStatPoll();
    if(!notificationDeferred)        
        {
    if(DBG)            
            log("cleanupConnection: !notificationDeferred");
            gotoIdleAndNotifyDataConnection(reason);
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.338 -0400", hash_original_method = "CCC265A96715FBE2FE51B6C51A4C9789", hash_generated_method = "A4F0A847C181AD76F5162D4FBBDE367C")
    private CdmaDataConnection findFreeDataConnection() {
for(DataConnectionAc dcac : mDataConnectionAsyncChannels.values())
        {
    if(dcac.isInactiveSync())            
            {
                log("found free GsmDataConnection");
CdmaDataConnection var64F4870CCAF38C0A05ADA975D81BB478_1523615629 =                 (CdmaDataConnection) dcac.dataConnection;
                var64F4870CCAF38C0A05ADA975D81BB478_1523615629.addTaint(taint);
                return var64F4870CCAF38C0A05ADA975D81BB478_1523615629;
            } 
        } 
        log("NO free CdmaDataConnection");
CdmaDataConnection var540C13E9E156B687226421B24F2DF178_295927554 =         null;
        var540C13E9E156B687226421B24F2DF178_295927554.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_295927554;
        
        
            
                
                
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.340 -0400", hash_original_method = "021C7DB7B25544657AF7783D8DE6441E", hash_generated_method = "62D972DBDA9532C8BC72A2D7EA8230B0")
    private boolean setupData(String reason) {
        addTaint(reason.getTaint());
        CdmaDataConnection conn = findFreeDataConnection();
    if(conn == null)        
        {
    if(DBG)            
            log("setupData: No free CdmaDataConnection found!");
            boolean var68934A3E9455FA72420237EB05902327_1065628152 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1928895099 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1928895099;
        } 
        mPendingDataConnection = conn;
        String[] types;
        int apnId;
    if(mRequestedApnType.equals(Phone.APN_TYPE_DUN))        
        {
            types = new String[1];
            types[0] = Phone.APN_TYPE_DUN;
            apnId = DataConnectionTracker.APN_DUN_ID;
        } 
        else
        {
            types = mDefaultApnTypes;
            apnId = mDefaultApnId;
        } 
        mActiveApn = new ApnSetting(apnId, "", "", "", "", "", "", "", "", "",
                                    "", 0, types, "IP", "IP", true, 0);
    if(DBG)        
        log("call conn.bringUp mActiveApn=" + mActiveApn);
        Message msg = obtainMessage();
        msg.what = EVENT_DATA_SETUP_COMPLETE;
        msg.obj = reason;
        conn.bringUp(msg, mActiveApn);
        setState(State.INITING);
        notifyDataConnection(reason);
        boolean varB326B5062B2F0E69046810717534CB09_342673732 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_291270857 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_291270857;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.340 -0400", hash_original_method = "A9B26E176D50C7947D632921998F13D5", hash_generated_method = "AC8CA33C18F2770A97BA4742E7C11720")
    private void notifyDefaultData(String reason) {
        addTaint(reason.getTaint());
        setState(State.CONNECTED);
        notifyDataConnection(reason);
        startNetStatPoll();
        mDataConnections.get(0).resetRetryCount();
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.341 -0400", hash_original_method = "4334EC28628BC2618150E7F73B49358F", hash_generated_method = "CA71E84F421FB531DEE0DB608D05FC5A")
    private void resetPollStats() {
        mTxPkts = -1;
        mRxPkts = -1;
        mSentSinceLastRecv = 0;
        mNetStatPollPeriod = POLL_NETSTAT_MILLIS;
        mNoRecvPollCount = 0;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.341 -0400", hash_original_method = "89653F3210B52B01F9AED56AD5EFB50E", hash_generated_method = "5820AAB04D2D50067D2D638FE6D867A4")
    @Override
    protected void startNetStatPoll() {
    if(mState == State.CONNECTED && mNetStatPollEnabled == false)        
        {
            log("[DataConnection] Start poll NetStat");
            resetPollStats();
            mNetStatPollEnabled = true;
            mPollNetStat.run();
        } 
        
        
            
            
            
            
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.341 -0400", hash_original_method = "B87E2D0F3C8EA5B297B25E95FDB4C600", hash_generated_method = "E63291039876CC2FCDDBA8BE3EFC765C")
    @Override
    protected void stopNetStatPoll() {
        mNetStatPollEnabled = false;
        removeCallbacks(mPollNetStat);
        log("[DataConnection] Stop poll NetStat");
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.342 -0400", hash_original_method = "5AA50F54A3015F5F6ACA18B3174FAEC2", hash_generated_method = "2F347A6FBDA0B0622987AEB074524C3C")
    @Override
    protected void restartRadio() {
    if(DBG)        
        log("Cleanup connection and wait " +
                (TIME_DELAYED_TO_RESTART_RADIO / 1000) + "s to restart radio");
        cleanUpAllConnections(null);
        sendEmptyMessageDelayed(EVENT_RESTART_RADIO, TIME_DELAYED_TO_RESTART_RADIO);
        mPendingRestartRadio = true;
        
        
                
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.342 -0400", hash_original_method = "7D555C87655E096A1AB206CCF6046FBB", hash_generated_method = "10CB814415FA70A0FB84BF7A995CB8BB")
    private boolean shouldPostNotification(FailCause cause) {
        addTaint(cause.getTaint());
        boolean var0946A14484CB86EA252A404504EBE2CF_1613799579 = ((cause != FailCause.UNKNOWN));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_681321497 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_681321497;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.342 -0400", hash_original_method = "62A24BB1F647222AA978F8E837B2D330", hash_generated_method = "EF63A516CC9E96C6FD03F722225F626B")
    private boolean retryAfterDisconnected(String reason) {
        addTaint(reason.getTaint());
        boolean retry = true;
    if(Phone.REASON_RADIO_TURNED_OFF.equals(reason))        
        {
            retry = false;
        } 
        boolean var165E6D21E0A2CC9EBB32CA05F90E0FA7_1102579685 = (retry);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1410489131 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1410489131;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.343 -0400", hash_original_method = "B6E77C65C80021F4CC0DAD9B1CC533BA", hash_generated_method = "B16AB78CDFCF4C88574D2DA6C7659D8F")
    private void reconnectAfterFail(FailCause lastFailCauseCode, String reason) {
        addTaint(reason.getTaint());
        addTaint(lastFailCauseCode.getTaint());
    if(mState == State.FAILED)        
        {
            int nextReconnectDelay = mDataConnections.get(0).getRetryTimer();
            startAlarmForReconnect(nextReconnectDelay, reason);
            mDataConnections.get(0).increaseRetryCount();
    if(!shouldPostNotification(lastFailCauseCode))            
            {
                log("NOT Posting Data Connection Unavailable notification "
                                + "-- likely transient error");
            } 
            else
            {
                notifyNoData(lastFailCauseCode);
            } 
        } 
        
        
            
            
            
            
                
                                
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.343 -0400", hash_original_method = "E44CA37DEACEC190565F77C6CB5940AA", hash_generated_method = "EB3764573927D6F78543BAAFCA927AF8")
    private void startAlarmForReconnect(int delay, String reason) {
        addTaint(reason.getTaint());
        addTaint(delay);
        log("Data Connection activate failed. Scheduling next attempt for "
                + (delay / 1000) + "s");
        AlarmManager am = (AlarmManager) mPhone.getContext().getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(INTENT_RECONNECT_ALARM);
        intent.putExtra(INTENT_RECONNECT_ALARM_EXTRA_REASON, reason);
        mReconnectIntent = PendingIntent.getBroadcast(
                mPhone.getContext(), 0, intent, 0);
        am.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                SystemClock.elapsedRealtime() + delay, mReconnectIntent);
        
        
                
        
            
        
        
        
                
        
                
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.344 -0400", hash_original_method = "906A69878943A02EC5DE4E13B27C21B4", hash_generated_method = "6F1D01950156D637CE9DEA87990354C8")
    private void notifyNoData(FailCause lastFailCauseCode) {
        addTaint(lastFailCauseCode.getTaint());
        setState(State.FAILED);
        notifyOffApnsOfAvailability(null);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.344 -0400", hash_original_method = "FC06F936895E8DDA4082B1191F41BF76", hash_generated_method = "AE47B3851A83D01B8A282ADD271799BB")
    protected void gotoIdleAndNotifyDataConnection(String reason) {
        addTaint(reason.getTaint());
    if(DBG)        
        log("gotoIdleAndNotifyDataConnection: reason=" + reason);
        setState(State.IDLE);
        notifyDataConnection(reason);
        mActiveApn = null;
        
        
        
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.344 -0400", hash_original_method = "E23B6E1AC9BCA9F124B3E389B7DEE3CE", hash_generated_method = "C7174DB275A861F7A2E2E7084E9AB211")
    protected void onRecordsLoaded() {
        
    if(mState == State.FAILED)        
        {
            cleanUpAllConnections(null);
        } 
        sendMessage(obtainMessage(EVENT_TRY_SETUP_DATA, Phone.REASON_SIM_LOADED));
        
        
            
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.345 -0400", hash_original_method = "E1428BF12D5C40E221347D3CB6592677", hash_generated_method = "FEB4C482E38D3FFF49B4DF4AA6CFC39E")
    protected void onNVReady() {
        
    if(mState == State.FAILED)        
        {
            cleanUpAllConnections(null);
        } 
        sendMessage(obtainMessage(EVENT_TRY_SETUP_DATA));
        
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.345 -0400", hash_original_method = "EA596D7E6B7BB6E966347390783DCB75", hash_generated_method = "928C176826E83B168C4FA2AB3091EDBA")
    @Override
    protected void onEnableNewApn() {
        
        cleanUpConnection(true, Phone.REASON_APN_SWITCHED);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.345 -0400", hash_original_method = "D1EA04ADDFE8BEB96FCA5B0EBDBE27E4", hash_generated_method = "3AC891FAA179A6E2213F12DACA70185D")
    @Override
    protected boolean onTrySetupData(String reason) {
        
        addTaint(reason.getTaint());
        boolean varD2506CFB1DEDC3EFB3089D571DE3694B_1520045975 = (trySetupData(reason));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1197284692 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1197284692;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.345 -0400", hash_original_method = "456B5B4117DFD69A8357ABE29B636ADA", hash_generated_method = "5809DD5928A3761F6A7669039A1B830A")
    @Override
    protected void onRoamingOff() {
        
    if(getDataOnRoamingEnabled() == false)        
        {
            notifyOffApnsOfAvailability(Phone.REASON_ROAMING_OFF);
            trySetupData(Phone.REASON_ROAMING_OFF);
        } 
        else
        {
            notifyDataConnection(Phone.REASON_ROAMING_OFF);
        } 
        
        
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.346 -0400", hash_original_method = "05517986BB1CA537C6FCF607816BF093", hash_generated_method = "A43C2BAAE51C314CB5B984D2457C0671")
    @Override
    protected void onRoamingOn() {
        
    if(getDataOnRoamingEnabled())        
        {
            trySetupData(Phone.REASON_ROAMING_ON);
            notifyDataConnection(Phone.REASON_ROAMING_ON);
        } 
        else
        {
    if(DBG)            
            log("Tear down data connection on roaming.");
            cleanUpAllConnections(null);
            notifyOffApnsOfAvailability(Phone.REASON_ROAMING_ON);
        } 
        
        
            
            
        
            
            
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.346 -0400", hash_original_method = "F74A764B82D382E1DF4133E695EBD591", hash_generated_method = "781D9550DDE70B054BCF4BB515D66B50")
    @Override
    protected void onRadioAvailable() {
        
    if(mPhone.getSimulatedRadioControl() != null)        
        {
            setState(State.CONNECTED);
            notifyDataConnection(null);
            log("We're on the simulator; assuming data is connected");
        } 
        notifyOffApnsOfAvailability(null);
    if(mState != State.IDLE)        
        {
            cleanUpAllConnections(null);
        } 
        
        
            
            
            
        
        
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.347 -0400", hash_original_method = "13044BD14789126E4C7F4A6581DB22DE", hash_generated_method = "5FE64ED2AB322C5FD15B0FDAE71EEBCA")
    @Override
    protected void onRadioOffOrNotAvailable() {
        
        mDataConnections.get(0).resetRetryCount();
    if(mPhone.getSimulatedRadioControl() != null)        
        {
            log("We're on the simulator; assuming radio off is meaningless");
        } 
        else
        {
    if(DBG)            
            log("Radio is off and clean up all connection");
            cleanUpAllConnections(null);
        } 
        
        
        
            
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.347 -0400", hash_original_method = "F38E677B8F89E946D32F2D1EC6556506", hash_generated_method = "A38B0B6CF4EB0D53BA4440D453EC45FE")
    @Override
    protected void onDataSetupComplete(AsyncResult ar) {
        
        addTaint(ar.getTaint());
        String reason = null;
    if(ar.userObj instanceof String)        
        {
            reason = (String) ar.userObj;
        } 
    if(isDataSetupCompleteOk(ar))        
        {
            notifyDefaultData(reason);
        } 
        else
        {
            FailCause cause = (FailCause) (ar.result);
    if(DBG)            
            log("Data Connection setup failed " + cause);
    if(cause.isPermanentFail())            
            {
                notifyNoData(cause);
                return;
            } 
            startDelayedRetry(cause, reason);
        } 
        
        
        
            
        
        
            
        
            
            
            
                
                
            
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.348 -0400", hash_original_method = "B64AD173877EB61F2BA995A6B9586953", hash_generated_method = "DFC81BA76AB345B641BFE76CE215A2D8")
    @Override
    protected void onDisconnectDone(int connId, AsyncResult ar) {
        
        addTaint(ar.getTaint());
        addTaint(connId);
    if(DBG)        
        log("EVENT_DISCONNECT_DONE connId=" + connId);
        String reason = null;
    if(ar.userObj instanceof String)        
        {
            reason = (String) ar.userObj;
        } 
        setState(State.IDLE);
    if(mPendingRestartRadio)        
        removeMessages(EVENT_RESTART_RADIO);
        CdmaServiceStateTracker ssTracker = mCdmaPhone.mSST;
    if(ssTracker.processPendingRadioPowerOffAfterDataOff())        
        {
            mPendingRestartRadio = false;
        } 
        else
        {
            onRestartRadio();
        } 
        notifyDataConnection(reason);
        mActiveApn = null;
    if(retryAfterDisconnected(reason))        
        {
            startAlarmForReconnect(APN_DELAY_MILLIS, reason);
        } 
        
        
        
        
            
        
        
        
        
        
            
        
            
        
        
        
        
          
      
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.349 -0400", hash_original_method = "8669708C7F9DB85ADE9303FE8B7AF6BC", hash_generated_method = "956DAA5B465A8D40CC1CBDE2B69093F3")
    @Override
    protected void onVoiceCallStarted() {
        
    if(mState == State.CONNECTED && !mCdmaPhone.mSST.isConcurrentVoiceAndDataAllowed())        
        {
            stopNetStatPoll();
            notifyDataConnection(Phone.REASON_VOICE_CALL_STARTED);
            notifyOffApnsOfAvailability(Phone.REASON_VOICE_CALL_STARTED);
        } 
        
        
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.349 -0400", hash_original_method = "A8CF6D26E9B870CF97B1A301601A4493", hash_generated_method = "D7FC8B39AE60857D7A8DF5AEA93BC6FD")
    @Override
    protected void onVoiceCallEnded() {
        
    if(mState == State.CONNECTED)        
        {
    if(!mCdmaPhone.mSST.isConcurrentVoiceAndDataAllowed())            
            {
                startNetStatPoll();
                notifyDataConnection(Phone.REASON_VOICE_CALL_ENDED);
            } 
            else
            {
                resetPollStats();
            } 
            notifyOffApnsOfAvailability(Phone.REASON_VOICE_CALL_ENDED);
        } 
        else
        {
            mDataConnections.get(0).resetRetryCount();
            trySetupData(Phone.REASON_VOICE_CALL_ENDED);
        } 
        
        
            
                
                
            
                
            
            
        
            
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.349 -0400", hash_original_method = "1767BD771DD5F6B59CD03646F3315F79", hash_generated_method = "FBAF9C086BCC793D56D46036746FD672")
    @Override
    protected void onCleanUpConnection(boolean tearDown, int apnId, String reason) {
        
        addTaint(reason.getTaint());
        addTaint(apnId);
        addTaint(tearDown);
        cleanUpConnection(tearDown, reason);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.350 -0400", hash_original_method = "6A2ACA33DA32338447596FF020294793", hash_generated_method = "B80D5F9B327B51B1A60F6F0F1430B62B")
    @Override
    protected void onCleanUpAllConnections(String cause) {
        
        addTaint(cause.getTaint());
        cleanUpConnection(true, cause);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.350 -0400", hash_original_method = "7F3FB415E824AE28DE838EAC0023F542", hash_generated_method = "FC98E5742FDC33CCB1E2F638E8845C2C")
    private void createAllDataConnectionList() {
        CdmaDataConnection dataConn;
        String retryConfig = SystemProperties.get("ro.cdma.data_retry_config");
for(int i = 0;i < DATA_CONNECTION_POOL_SIZE;i++)
        {
            RetryManager rm = new RetryManager();
    if(!rm.configure(retryConfig))            
            {
    if(!rm.configure(DEFAULT_DATA_RETRY_CONFIG))                
                {
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
    if(status == AsyncChannel.STATUS_SUCCESSFUL)            
            {
                log("Fully connected");
                mDataConnectionAsyncChannels.put(dcac.dataConnection.getDataConnectionId(), dcac);
            } 
            else
            {
                log("Could not connect to dcac.dataConnection=" + dcac.dataConnection +
                        " status=" + status);
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.351 -0400", hash_original_method = "8430EFDC31AB81EB1D7F0972246BF5F1", hash_generated_method = "16F6D5B538D560F45EE61E834ADB5D19")
    private void destroyAllDataConnectionList() {
    if(mDataConnections != null)        
        {
            mDataConnections.clear();
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.352 -0400", hash_original_method = "94CE8407A5E1B53B6799DEAF3D95D61E", hash_generated_method = "6CAD9E0228206216C5BDBE04ECFBC76B")
    private void onCdmaDataDetached() {
    if(mState == State.CONNECTED)        
        {
            startNetStatPoll();
            notifyDataConnection(Phone.REASON_CDMA_DATA_DETACHED);
        } 
        else
        {
    if(mState == State.FAILED)            
            {
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.353 -0400", hash_original_method = "A262DC774CC921F05CC1B098B136C4F6", hash_generated_method = "B973EA0872CAAC7B291B579E6280869F")
    private void onCdmaOtaProvision(AsyncResult ar) {
        addTaint(ar.getTaint());
    if(ar.exception != null)        
        {
            int [] otaPrivision = (int [])ar.result;
    if((otaPrivision != null) && (otaPrivision.length > 1))            
            {
switch(otaPrivision[0]){
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.353 -0400", hash_original_method = "7F30476887B77149E22CB7625A399926", hash_generated_method = "D801E5B0596B9E348F2096220744198D")
    private void onRestartRadio() {
    if(mPendingRestartRadio)        
        {
            log("************TURN OFF RADIO**************");
            mPhone.mCM.setRadioPower(false, null);
            mPendingRestartRadio = false;
        } 
        
        
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.354 -0400", hash_original_method = "A45AA34613360795905157920DD95009", hash_generated_method = "D8CBF94090EEDA7198B858102066F497")
    private void writeEventLogCdmaDataDrop() {
        CdmaCellLocation loc = (CdmaCellLocation)(mPhone.getCellLocation());
        EventLog.writeEvent(EventLogTags.CDMA_DATA_DROP,
                loc != null ? loc.getBaseStationId() : -1,
                TelephonyManager.getDefault().getNetworkType());
        
        
        
                
                
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.355 -0400", hash_original_method = "D056F1F93E1FCCA005B3D5C4043A4B41", hash_generated_method = "6BAE02B38689D67F1D6D57048BBACD01")
    protected void onDataStateChanged(AsyncResult ar) {
        
        addTaint(ar.getTaint());
        ArrayList<DataCallState> dataCallStates = (ArrayList<DataCallState>)(ar.result);
    if(ar.exception != null)        
        {
            return;
        } 
    if(mState == State.CONNECTED)        
        {
            boolean isActiveOrDormantConnectionPresent = false;
            int connectionState = DATA_CONNECTION_ACTIVE_PH_LINK_INACTIVE;
for(int index = 0;index < dataCallStates.size();index++)
            {
                connectionState = dataCallStates.get(index).active;
    if(connectionState != DATA_CONNECTION_ACTIVE_PH_LINK_INACTIVE)                
                {
                    isActiveOrDormantConnectionPresent = true;
                    break;
                } 
            } 
    if(!isActiveOrDormantConnectionPresent)            
            {
                log("onDataStateChanged: No active connection"
                        + "state is CONNECTED, disconnecting/cleanup");
                writeEventLogCdmaDataDrop();
                cleanUpConnection(true, null);
                return;
            } 
switch(connectionState){
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
        } 
        else
        {
            log("onDataStateChanged: not connected, state=" + mState + " ignoring");
        } 
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.355 -0400", hash_original_method = "E7620C231D98F2722A026ACACB1534C7", hash_generated_method = "CF2D093B244C86B07429DF8C52566AC3")
    private void startDelayedRetry(FailCause cause, String reason) {
        addTaint(reason.getTaint());
        addTaint(cause.getTaint());
        notifyNoData(cause);
        reconnectAfterFail(cause, reason);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.355 -0400", hash_original_method = "23AB21BFEE9B8AADED0100AF4BC4730D", hash_generated_method = "F81DEAF73DE7A7DEC9EEA23B3EBEAB70")
    @Override
    public void handleMessage(Message msg) {
        addTaint(msg.getTaint());
    if(DBG)        
        log("CdmaDCT handleMessage msg=" + msg);
    if(!mPhone.mIsTheCurrentActivePhone || mIsDisposed)        
        {
            log("Ignore CDMA msgs since CDMA phone is inactive");
            return;
        } 
switch(msg.what){
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
    if(DBG)        
        log("EVENT_RESTART_RADIO");
        onRestartRadio();
        break;
        default:
        super.handleMessage(msg);
        break;
}
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.355 -0400", hash_original_method = "40E4BCBCB488969F7D8EBF5CAA1BFE5A", hash_generated_method = "5621D3AD3C086B6CBB30F4C8C9D97A64")
    @Override
    public boolean isDisconnected() {
        boolean varC1DAD21B7942DEF10781808DB2161507_1799404042 = (((mState == State.IDLE) || (mState == State.FAILED)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1827980802 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1827980802;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.356 -0400", hash_original_method = "C5FFF855C74ADBDA37AC74CEDF90027C", hash_generated_method = "3E1247A9DE64AB158D76CF0E28B9AC92")
    @Override
    protected void log(String s) {
        addTaint(s.getTaint());
        Log.d(LOG_TAG, "[CdmaDCT] " + s);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.356 -0400", hash_original_method = "509A4E6BF6CDBAFC8ECDCC1462D37923", hash_generated_method = "0979C2E06128B79454FA9227F61207E5")
    @Override
    protected void loge(String s) {
        addTaint(s.getTaint());
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.356 -0400", hash_original_field = "07521AF9343CE7B0F1FDA0931E9D1853", hash_generated_field = "026E142D8E01249707E04DC78D4EFF35")

    private static final int TIME_DELAYED_TO_RESTART_RADIO = SystemProperties.getInt("ro.cdma.timetoradiorestart", 60000);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.356 -0400", hash_original_field = "8BDC86CA7F932B0E570620C076050629", hash_generated_field = "01674A6D3DB885DCC7AB5BE2BD593ACF")

    private static final int DATA_CONNECTION_POOL_SIZE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.356 -0400", hash_original_field = "9BD7934FD72152CF2A0C509972E1348D", hash_generated_field = "20166A867EF23E7504249EF3C9B5AB3C")

    private static final String INTENT_RECONNECT_ALARM = "com.android.internal.telephony.cdma-reconnect";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.356 -0400", hash_original_field = "3E7D706FF7519F453045457C432050D2", hash_generated_field = "6C8FF74EEDEE440F89F3FC7EF70C27D7")

    private static final String INTENT_DATA_STALL_ALARM = "com.android.internal.telephony.cdma-data-stall";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.356 -0400", hash_original_field = "B0662EDCAF5EB88046EB78EE4B5A76C2", hash_generated_field = "AF0632B78D1BD6B15A396B584EB3F7C0")

    private static final int DATA_CONNECTION_ACTIVE_PH_LINK_INACTIVE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.356 -0400", hash_original_field = "5C6E63602F34ECBFD0F2B713F582E11D", hash_generated_field = "F92E1A7741887DC6DAF4708B5127D20F")

    private static final int DATA_CONNECTION_ACTIVE_PH_LINK_DOWN = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.356 -0400", hash_original_field = "470D920CDB15F9878B90DEB2DE9258C1", hash_generated_field = "823EB0FF5FCBDCE6A1A71833F5D13138")

    private static final int DATA_CONNECTION_ACTIVE_PH_LINK_UP = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.356 -0400", hash_original_field = "C74D643B2F20AEC802C28072AC8B3CD3", hash_generated_field = "48ED62C0AD71722F4945340F0A7FF5F9")

    private static final String[] mSupportedApnTypes = {
            Phone.APN_TYPE_DEFAULT,
            Phone.APN_TYPE_MMS,
            Phone.APN_TYPE_DUN,
            Phone.APN_TYPE_HIPRI };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.356 -0400", hash_original_field = "0EF95A41F9DB20AECFBBE93D89AB06A4", hash_generated_field = "561E37C406B565A7F36A37780ECC9AAF")

    private static final String[] mDefaultApnTypes = {
            Phone.APN_TYPE_DEFAULT,
            Phone.APN_TYPE_MMS,
            Phone.APN_TYPE_HIPRI };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.356 -0400", hash_original_field = "0808FF718AAFC80A11429FFA40CC973A", hash_generated_field = "897EE016BFDB188E89DEC9B85F66301D")

    private static final int mDefaultApnId = DataConnectionTracker.APN_DEFAULT_ID;
}

