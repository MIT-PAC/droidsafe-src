package com.android.internal.telephony.cdma;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.686 -0400", hash_original_field = "951C150E6D062E6AED2C45BB9B756185", hash_generated_field = "692A09C40EE40FAEE399CBCFE2A5ACE4")

    protected final String LOG_TAG = "CDMA";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.686 -0400", hash_original_field = "C77218B74238AF8B3595D58067947274", hash_generated_field = "A784BE3C2CA8A9A5385EEA88DD6D3A29")

    private CDMAPhone mCdmaPhone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.686 -0400", hash_original_field = "0A4D06AADF5B2F71B9FA6A482FB61442", hash_generated_field = "EEA8F8B0B01EEAD84F4D26DF11EB97B7")

    private CdmaDataConnection mPendingDataConnection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.686 -0400", hash_original_field = "916FC477FFD163966FA31F037869DCA9", hash_generated_field = "BCBF943C87814D8571E314787E73F3AA")

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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.688 -0400", hash_original_method = "2C5FD67C25932D4938DCF727D105250A", hash_generated_method = "3F43862F61079BC5E612945DBAC96707")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.688 -0400", hash_original_method = "D7D3BFC7AEBB4A854053D0E671EEEB9F", hash_generated_method = "FE4B0CA0759BD685AB39AF74717B1307")
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.689 -0400", hash_original_method = "3DB74CB183E0997C0A31C0F47FB531FD", hash_generated_method = "56792E5FE8E366D5E4E3C9786B081157")
    @Override
    protected void finalize() {
        log("CdmaDataConnectionTracker finalized");
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.690 -0400", hash_original_method = "477FAE9A0F7056536F0C43A4344C1E00", hash_generated_method = "6D1D3C34D18E8312020C9D9EAB9A7D81")
    @Override
    protected String getActionIntentReconnectAlarm() {
        String varB4EAC82CA7396A68D541C85D26508E83_70541343 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_70541343 = INTENT_RECONNECT_ALARM;
        varB4EAC82CA7396A68D541C85D26508E83_70541343.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_70541343;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.691 -0400", hash_original_method = "BBE23E9137760572C0B9E85F7DE2F87D", hash_generated_method = "2557FE477B4FA3EA6862A9FA633B887A")
    @Override
    protected String getActionIntentDataStallAlarm() {
        String varB4EAC82CA7396A68D541C85D26508E83_574384942 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_574384942 = INTENT_DATA_STALL_ALARM;
        varB4EAC82CA7396A68D541C85D26508E83_574384942.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_574384942;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.691 -0400", hash_original_method = "8F51415486D92DEB617BF78EBB2ED95B", hash_generated_method = "4EB4B0C8CDF67C54D9A95DEBFB099627")
    @Override
    protected void setState(State s) {
        log ("setState: " + s);
        {
            EventLog.writeEvent(EventLogTags.CDMA_DATA_STATE_CHANGE,
                    mState.toString(), s.toString());
            mState = s;
        } 
        addTaint(s.getTaint());
        
        
        
            
                    
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.692 -0400", hash_original_method = "53DA179904795C28B8C89E7D1C885E11", hash_generated_method = "F24D9A2A9B245FD12206C5749B40249A")
    @Override
    public synchronized State getState(String apnType) {
        State varB4EAC82CA7396A68D541C85D26508E83_2058991746 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2058991746 = mState;
        addTaint(apnType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2058991746.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2058991746;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.695 -0400", hash_original_method = "3AFAE11AEA6F5EDA9B4571182280207F", hash_generated_method = "5FEB4BE03543812A137F09BCBBAE4BC2")
    @Override
    protected boolean isApnTypeAvailable(String type) {
        {
            String s = mSupportedApnTypes[0];
            {
                {
                    boolean varB6BAD33EB61876AC704EE691A9BB5A05_328764481 = (TextUtils.equals(type, s));
                } 
            } 
        } 
        addTaint(type.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1385696101 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1385696101;
        
        
            
                
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.696 -0400", hash_original_method = "542CE147EB1490D3575F0586BDB29C5B", hash_generated_method = "26943D2C990B4226AAED0D90A8DA3B94")
    @Override
    protected boolean isDataAllowed() {
        boolean internalDataEnabled;
        {
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
        {
            String reason = "";
            {
                reason += " - psState= " + psState;
            } 
            {
                boolean var27C7393FEEA9515E8D28CD63EF68AAD3_1316978304 = (!(mPhone.mCM.getNvState() == CommandsInterface.RadioState.NV_READY ||
                    mCdmaPhone.mIccRecords.getRecordsLoaded()));
                {
                    reason += " - radioState= " + mPhone.mCM.getNvState() + " - RUIM not loaded";
                } 
            } 
            {
                boolean var97339E74162EFDAB27E8C356C17FDB93_1352044063 = (!(mCdmaPhone.mSST.isConcurrentVoiceAndDataAllowed() ||
                    mPhone.getState() == Phone.State.IDLE));
                {
                    reason += " - concurrentVoiceAndData not allowed and state= " + mPhone.getState();
                } 
            } 
            reason += " - Roaming";
            reason += " - mInternalDataEnabled= false";
            reason += " - desiredPowerState= false";
            reason += " - mPendingRestartRadio= true";
            {
                boolean varAED17B66ECABE29ECB94AC584BD19AFC_715694040 = (mCdmaPhone.needsOtaServiceProvisioning());
                reason += " - needs Provisioning";
            } 
            log("Data not allowed due to" + reason);
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_924650751 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_924650751;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.696 -0400", hash_original_method = "F4A377E51CCB46CDBA97F4F221100777", hash_generated_method = "63CD2D4D9A73ACE4CF90424EAED11275")
    @Override
    protected boolean isDataPossible(String apnType) {
        boolean possible = isDataAllowed() && !(getAnyDataEnabled() &&
                (mState == State.FAILED || mState == State.IDLE));
        {
            boolean var9B048D6DEF0B0137767C8E3F72E8439A_432060057 = (!possible && DBG && isDataAllowed());
            {
                log("Data not possible.  No coverage: dataState = " + mState);
            } 
        } 
        addTaint(apnType.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1799468123 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1799468123;
        
        
                
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.697 -0400", hash_original_method = "394F83083B165868EFF2D0029A637488", hash_generated_method = "899DEA47C45EEB0686860F17E3B2B550")
    private boolean trySetupData(String reason) {
        log("***trySetupData due to " + (reason == null ? "(unspecified)" : reason));
        {
            boolean varA62B422C35237A9A4A0C0A75D57190F8_40436488 = (mPhone.getSimulatedRadioControl() != null);
            {
                setState(State.CONNECTED);
                notifyDataConnection(reason);
                notifyOffApnsOfAvailability(reason);
                log("(fix?) We're on the simulator; assuming data is connected");
            } 
        } 
        int psState = mCdmaPhone.mSST.getCurrentDataConnectionState();
        boolean roaming = mPhone.getServiceState().getRoaming();
        boolean desiredPowerState = mCdmaPhone.mSST.getDesiredPowerState();
        {
            boolean var949370AE43AD6FBCD95157798F7FB0DF_896144277 = ((mState == State.IDLE || mState == State.SCANNING) &&
                isDataAllowed() && getAnyDataEnabled() && !isEmergency());
            {
                boolean retValue = setupData(reason);
                notifyOffApnsOfAvailability(reason);
            } 
            {
                notifyOffApnsOfAvailability(reason);
            } 
        } 
        addTaint(reason.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_804167038 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_804167038;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.704 -0400", hash_original_method = "5189B04FA529AAC9DBE4ECDA45A08A99", hash_generated_method = "E27F1DEBBF51C6E46169EDDDE34AB1D2")
    private void cleanUpConnection(boolean tearDown, String reason) {
        log("cleanUpConnection: reason: " + reason);
        {
            AlarmManager am = (AlarmManager) mPhone.getContext().getSystemService(Context.ALARM_SERVICE);
            am.cancel(mReconnectIntent);
            mReconnectIntent = null;
        } 
        setState(State.DISCONNECTING);
        notifyOffApnsOfAvailability(reason);
        boolean notificationDeferred = false;
        {
            Iterator<DataConnection> var5FF8B81A220FD894D705CD5B3B4CA034_1445265402 = (mDataConnections.values()).iterator();
            var5FF8B81A220FD894D705CD5B3B4CA034_1445265402.hasNext();
            DataConnection conn = var5FF8B81A220FD894D705CD5B3B4CA034_1445265402.next();
            {
                {
                    DataConnectionAc dcac = mDataConnectionAsyncChannels.get(conn.getDataConnectionId());
                    {
                        log("cleanUpConnection: teardown, call conn.disconnect");
                        conn.tearDown(reason, obtainMessage(EVENT_DISCONNECT_DONE,
                            conn.getDataConnectionId(), 0, reason));
                        notificationDeferred = true;
                    } 
                    {
                        log("cleanUpConnection: !tearDown, call conn.resetSynchronously");
                        {
                            dcac.resetSync();
                        } 
                        notificationDeferred = false;
                    } 
                } 
            } 
        } 
        stopNetStatPoll();
        {
            log("cleanupConnection: !notificationDeferred");
            gotoIdleAndNotifyDataConnection(reason);
        } 
        addTaint(tearDown);
        addTaint(reason.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.708 -0400", hash_original_method = "CCC265A96715FBE2FE51B6C51A4C9789", hash_generated_method = "881DA9458BED6B6B3040AC70744A25AC")
    private CdmaDataConnection findFreeDataConnection() {
        CdmaDataConnection varB4EAC82CA7396A68D541C85D26508E83_688488744 = null; 
        CdmaDataConnection varB4EAC82CA7396A68D541C85D26508E83_1257687833 = null; 
        {
            Iterator<DataConnectionAc> varEB8626173DB084FB4853115B28BD3F62_284717694 = (mDataConnectionAsyncChannels.values()).iterator();
            varEB8626173DB084FB4853115B28BD3F62_284717694.hasNext();
            DataConnectionAc dcac = varEB8626173DB084FB4853115B28BD3F62_284717694.next();
            {
                {
                    boolean var63D661D51186954ED4E8C4223E8E3B75_1374784458 = (dcac.isInactiveSync());
                    {
                        log("found free GsmDataConnection");
                        varB4EAC82CA7396A68D541C85D26508E83_688488744 = (CdmaDataConnection) dcac.dataConnection;
                    } 
                } 
            } 
        } 
        log("NO free CdmaDataConnection");
        varB4EAC82CA7396A68D541C85D26508E83_1257687833 = null;
        CdmaDataConnection varA7E53CE21691AB073D9660D615818899_2038619875; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_2038619875 = varB4EAC82CA7396A68D541C85D26508E83_688488744;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2038619875 = varB4EAC82CA7396A68D541C85D26508E83_1257687833;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2038619875.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_2038619875;
        
        
            
                
                
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.709 -0400", hash_original_method = "021C7DB7B25544657AF7783D8DE6441E", hash_generated_method = "33C362BD943E38C59FF7AB273673E7FD")
    private boolean setupData(String reason) {
        CdmaDataConnection conn = findFreeDataConnection();
        {
            log("setupData: No free CdmaDataConnection found!");
        } 
        mPendingDataConnection = conn;
        String[] types;
        int apnId;
        {
            boolean var606A60405C260349B54220DED9004DA3_188986312 = (mRequestedApnType.equals(Phone.APN_TYPE_DUN));
            {
                types = new String[1];
                types[0] = Phone.APN_TYPE_DUN;
                apnId = DataConnectionTracker.APN_DUN_ID;
            } 
            {
                types = mDefaultApnTypes;
                apnId = mDefaultApnId;
            } 
        } 
        mActiveApn = new ApnSetting(apnId, "", "", "", "", "", "", "", "", "",
                                    "", 0, types, "IP", "IP", true, 0);
        log("call conn.bringUp mActiveApn=" + mActiveApn);
        Message msg = obtainMessage();
        msg.what = EVENT_DATA_SETUP_COMPLETE;
        msg.obj = reason;
        conn.bringUp(msg, mActiveApn);
        setState(State.INITING);
        notifyDataConnection(reason);
        addTaint(reason.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1438289371 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1438289371;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.710 -0400", hash_original_method = "A9B26E176D50C7947D632921998F13D5", hash_generated_method = "FDA3493BB98F3D46DD2DABAF9B9F44B7")
    private void notifyDefaultData(String reason) {
        setState(State.CONNECTED);
        notifyDataConnection(reason);
        startNetStatPoll();
        mDataConnections.get(0).resetRetryCount();
        addTaint(reason.getTaint());
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.711 -0400", hash_original_method = "4334EC28628BC2618150E7F73B49358F", hash_generated_method = "CA71E84F421FB531DEE0DB608D05FC5A")
    private void resetPollStats() {
        mTxPkts = -1;
        mRxPkts = -1;
        mSentSinceLastRecv = 0;
        mNetStatPollPeriod = POLL_NETSTAT_MILLIS;
        mNoRecvPollCount = 0;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.712 -0400", hash_original_method = "89653F3210B52B01F9AED56AD5EFB50E", hash_generated_method = "201C936746B18BFA4DD690E4BE58C178")
    @Override
    protected void startNetStatPoll() {
        {
            log("[DataConnection] Start poll NetStat");
            resetPollStats();
            mNetStatPollEnabled = true;
            mPollNetStat.run();
        } 
        
        
            
            
            
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.713 -0400", hash_original_method = "B87E2D0F3C8EA5B297B25E95FDB4C600", hash_generated_method = "E63291039876CC2FCDDBA8BE3EFC765C")
    @Override
    protected void stopNetStatPoll() {
        mNetStatPollEnabled = false;
        removeCallbacks(mPollNetStat);
        log("[DataConnection] Stop poll NetStat");
        
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.715 -0400", hash_original_method = "5AA50F54A3015F5F6ACA18B3174FAEC2", hash_generated_method = "E201AD4E8952C0DEB5AFC8EBC32D5FF2")
    @Override
    protected void restartRadio() {
        log("Cleanup connection and wait " +
                (TIME_DELAYED_TO_RESTART_RADIO / 1000) + "s to restart radio");
        cleanUpAllConnections(null);
        sendEmptyMessageDelayed(EVENT_RESTART_RADIO, TIME_DELAYED_TO_RESTART_RADIO);
        mPendingRestartRadio = true;
        
        
                
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.717 -0400", hash_original_method = "7D555C87655E096A1AB206CCF6046FBB", hash_generated_method = "331F3E2AE6DCF6DE891818BCB0F97F54")
    private boolean shouldPostNotification(FailCause cause) {
        addTaint(cause.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1029313128 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1029313128;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.718 -0400", hash_original_method = "62A24BB1F647222AA978F8E837B2D330", hash_generated_method = "66DF80534E80809E1911A23D87B8B7E9")
    private boolean retryAfterDisconnected(String reason) {
        boolean retry = true;
        {
            boolean var3CB82CF3031EDB1F7F9E067EE7B1B74E_347070120 = (Phone.REASON_RADIO_TURNED_OFF.equals(reason));
            {
                retry = false;
            } 
        } 
        addTaint(reason.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_704501686 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_704501686;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.718 -0400", hash_original_method = "B6E77C65C80021F4CC0DAD9B1CC533BA", hash_generated_method = "4D33C9AFC0E83A7DC30918C4E34EB2DD")
    private void reconnectAfterFail(FailCause lastFailCauseCode, String reason) {
        {
            int nextReconnectDelay = mDataConnections.get(0).getRetryTimer();
            startAlarmForReconnect(nextReconnectDelay, reason);
            mDataConnections.get(0).increaseRetryCount();
            {
                boolean varFD6404B1A9502D19A8FBA94C0DD3DAAF_1568991478 = (!shouldPostNotification(lastFailCauseCode));
                {
                    log("NOT Posting Data Connection Unavailable notification "
                                + "-- likely transient error");
                } 
                {
                    notifyNoData(lastFailCauseCode);
                } 
            } 
        } 
        addTaint(lastFailCauseCode.getTaint());
        addTaint(reason.getTaint());
        
        
            
            
            
            
                
                                
            
                
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.719 -0400", hash_original_method = "E44CA37DEACEC190565F77C6CB5940AA", hash_generated_method = "61034E8790872F8CC70E293F038282FE")
    private void startAlarmForReconnect(int delay, String reason) {
        log("Data Connection activate failed. Scheduling next attempt for "
                + (delay / 1000) + "s");
        AlarmManager am = (AlarmManager) mPhone.getContext().getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(INTENT_RECONNECT_ALARM);
        intent.putExtra(INTENT_RECONNECT_ALARM_EXTRA_REASON, reason);
        mReconnectIntent = PendingIntent.getBroadcast(
                mPhone.getContext(), 0, intent, 0);
        am.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                SystemClock.elapsedRealtime() + delay, mReconnectIntent);
        addTaint(delay);
        addTaint(reason.getTaint());
        
        
                
        
            
        
        
        
                
        
                
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.720 -0400", hash_original_method = "906A69878943A02EC5DE4E13B27C21B4", hash_generated_method = "232F7572C989ABA3FE4CA0C57747C4A6")
    private void notifyNoData(FailCause lastFailCauseCode) {
        setState(State.FAILED);
        notifyOffApnsOfAvailability(null);
        addTaint(lastFailCauseCode.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.720 -0400", hash_original_method = "FC06F936895E8DDA4082B1191F41BF76", hash_generated_method = "4F7B61574E4C2169EC8918C6326500B9")
    protected void gotoIdleAndNotifyDataConnection(String reason) {
        log("gotoIdleAndNotifyDataConnection: reason=" + reason);
        setState(State.IDLE);
        notifyDataConnection(reason);
        mActiveApn = null;
        addTaint(reason.getTaint());
        
        
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.721 -0400", hash_original_method = "E23B6E1AC9BCA9F124B3E389B7DEE3CE", hash_generated_method = "BAF01EAB267D3A439EDB52D7CFEB8542")
    protected void onRecordsLoaded() {
        
        {
            cleanUpAllConnections(null);
        } 
        sendMessage(obtainMessage(EVENT_TRY_SETUP_DATA, Phone.REASON_SIM_LOADED));
        
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.722 -0400", hash_original_method = "E1428BF12D5C40E221347D3CB6592677", hash_generated_method = "6B849ADC5E2E4D55E726038CDBD0525A")
    protected void onNVReady() {
        
        {
            cleanUpAllConnections(null);
        } 
        sendMessage(obtainMessage(EVENT_TRY_SETUP_DATA));
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.722 -0400", hash_original_method = "EA596D7E6B7BB6E966347390783DCB75", hash_generated_method = "928C176826E83B168C4FA2AB3091EDBA")
    @Override
    protected void onEnableNewApn() {
        
        cleanUpConnection(true, Phone.REASON_APN_SWITCHED);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.722 -0400", hash_original_method = "D1EA04ADDFE8BEB96FCA5B0EBDBE27E4", hash_generated_method = "523763AE088164C36D1E47624BB5B1AB")
    @Override
    protected boolean onTrySetupData(String reason) {
        
        boolean varEF2870B84D286EC80F19694D55F0ACD0_1841542268 = (trySetupData(reason));
        addTaint(reason.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_464925835 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_464925835;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.723 -0400", hash_original_method = "456B5B4117DFD69A8357ABE29B636ADA", hash_generated_method = "CDD1629A6B4F494A8004D65E34D11D5F")
    @Override
    protected void onRoamingOff() {
        
        {
            boolean var6A4EDF3FAFEE8B58E0E885094E7C645E_1387609939 = (getDataOnRoamingEnabled() == false);
            {
                notifyOffApnsOfAvailability(Phone.REASON_ROAMING_OFF);
                trySetupData(Phone.REASON_ROAMING_OFF);
            } 
            {
                notifyDataConnection(Phone.REASON_ROAMING_OFF);
            } 
        } 
        
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.724 -0400", hash_original_method = "05517986BB1CA537C6FCF607816BF093", hash_generated_method = "F2D4295CB93C14454B9AAB4CFF97F542")
    @Override
    protected void onRoamingOn() {
        
        {
            boolean var178FD459AA12B1549B96EFDE7D504A27_605689155 = (getDataOnRoamingEnabled());
            {
                trySetupData(Phone.REASON_ROAMING_ON);
                notifyDataConnection(Phone.REASON_ROAMING_ON);
            } 
            {
                log("Tear down data connection on roaming.");
                cleanUpAllConnections(null);
                notifyOffApnsOfAvailability(Phone.REASON_ROAMING_ON);
            } 
        } 
        
        
            
            
        
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.725 -0400", hash_original_method = "F74A764B82D382E1DF4133E695EBD591", hash_generated_method = "4996A8FE6A74B18E71B01F576772389C")
    @Override
    protected void onRadioAvailable() {
        
        {
            boolean varA62B422C35237A9A4A0C0A75D57190F8_1003633381 = (mPhone.getSimulatedRadioControl() != null);
            {
                setState(State.CONNECTED);
                notifyDataConnection(null);
                log("We're on the simulator; assuming data is connected");
            } 
        } 
        notifyOffApnsOfAvailability(null);
        {
            cleanUpAllConnections(null);
        } 
        
        
            
            
            
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.725 -0400", hash_original_method = "13044BD14789126E4C7F4A6581DB22DE", hash_generated_method = "72A09C720FACF71247EFFABC49B7CB1F")
    @Override
    protected void onRadioOffOrNotAvailable() {
        
        mDataConnections.get(0).resetRetryCount();
        {
            boolean varA62B422C35237A9A4A0C0A75D57190F8_1405752590 = (mPhone.getSimulatedRadioControl() != null);
            {
                log("We're on the simulator; assuming radio off is meaningless");
            } 
            {
                log("Radio is off and clean up all connection");
                cleanUpAllConnections(null);
            } 
        } 
        
        
        
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.726 -0400", hash_original_method = "F38E677B8F89E946D32F2D1EC6556506", hash_generated_method = "39C03C2959ACCC2F5FE0CA970EC846A3")
    @Override
    protected void onDataSetupComplete(AsyncResult ar) {
        
        String reason = null;
        {
            reason = (String) ar.userObj;
        } 
        {
            boolean varB5E9B7D9BBFA45BCF027FCB550EA1FBB_669055600 = (isDataSetupCompleteOk(ar));
            {
                notifyDefaultData(reason);
            } 
            {
                FailCause cause = (FailCause) (ar.result);
                log("Data Connection setup failed " + cause);
                {
                    boolean var66182ADBA155CABC56AA3975E9DBF19F_78623015 = (cause.isPermanentFail());
                    {
                        notifyNoData(cause);
                    } 
                } 
                startDelayedRetry(cause, reason);
            } 
        } 
        addTaint(ar.getTaint());
        
        
        
            
        
        
            
        
            
            
            
                
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.726 -0400", hash_original_method = "B64AD173877EB61F2BA995A6B9586953", hash_generated_method = "491BA5E8E28537B52FE5C5080B6CBEA7")
    @Override
    protected void onDisconnectDone(int connId, AsyncResult ar) {
        
        log("EVENT_DISCONNECT_DONE connId=" + connId);
        String reason = null;
        {
            reason = (String) ar.userObj;
        } 
        setState(State.IDLE);
        removeMessages(EVENT_RESTART_RADIO);
        CdmaServiceStateTracker ssTracker = mCdmaPhone.mSST;
        {
            boolean var3BF0D3CF7742E29D226663A325AF3E66_2029200849 = (ssTracker.processPendingRadioPowerOffAfterDataOff());
            {
                mPendingRestartRadio = false;
            } 
            {
                onRestartRadio();
            } 
        } 
        notifyDataConnection(reason);
        mActiveApn = null;
        {
            boolean var617E4454D58A131493E80C30AF839FE7_1834481600 = (retryAfterDisconnected(reason));
            {
                startAlarmForReconnect(APN_DELAY_MILLIS, reason);
            } 
        } 
        addTaint(connId);
        addTaint(ar.getTaint());
        
        
        
        
            
        
        
        
        
        
            
        
            
        
        
        
        
          
      
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.727 -0400", hash_original_method = "8669708C7F9DB85ADE9303FE8B7AF6BC", hash_generated_method = "DFEE240E6656CA96A38CBD2077272109")
    @Override
    protected void onVoiceCallStarted() {
        
        {
            boolean var6AA65BBEFDBDAA95AEEF52A5CA0586D8_1592894467 = (mState == State.CONNECTED && !mCdmaPhone.mSST.isConcurrentVoiceAndDataAllowed());
            {
                stopNetStatPoll();
                notifyDataConnection(Phone.REASON_VOICE_CALL_STARTED);
                notifyOffApnsOfAvailability(Phone.REASON_VOICE_CALL_STARTED);
            } 
        } 
        
        
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.727 -0400", hash_original_method = "A8CF6D26E9B870CF97B1A301601A4493", hash_generated_method = "9F70EB8CB811F448208DFCA2DAFF39B6")
    @Override
    protected void onVoiceCallEnded() {
        
        {
            {
                boolean var894FAD0CD22FBCEF534C22052BAF7B7C_907502029 = (!mCdmaPhone.mSST.isConcurrentVoiceAndDataAllowed());
                {
                    startNetStatPoll();
                    notifyDataConnection(Phone.REASON_VOICE_CALL_ENDED);
                } 
                {
                    resetPollStats();
                } 
            } 
            notifyOffApnsOfAvailability(Phone.REASON_VOICE_CALL_ENDED);
        } 
        {
            mDataConnections.get(0).resetRetryCount();
            trySetupData(Phone.REASON_VOICE_CALL_ENDED);
        } 
        
        
            
                
                
            
                
            
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.728 -0400", hash_original_method = "1767BD771DD5F6B59CD03646F3315F79", hash_generated_method = "BF3A558B0FB95ED31D32EEE76E812232")
    @Override
    protected void onCleanUpConnection(boolean tearDown, int apnId, String reason) {
        
        cleanUpConnection(tearDown, reason);
        addTaint(tearDown);
        addTaint(apnId);
        addTaint(reason.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.728 -0400", hash_original_method = "6A2ACA33DA32338447596FF020294793", hash_generated_method = "138CE5447D62FE8D421A13417B3A7A44")
    @Override
    protected void onCleanUpAllConnections(String cause) {
        
        cleanUpConnection(true, cause);
        addTaint(cause.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.728 -0400", hash_original_method = "7F3FB415E824AE28DE838EAC0023F542", hash_generated_method = "A7FD1E98248A0E496EE8C7E3C0870A86")
    private void createAllDataConnectionList() {
        CdmaDataConnection dataConn;
        String retryConfig = SystemProperties.get("ro.cdma.data_retry_config");
        {
            int i = 0;
            {
                RetryManager rm = new RetryManager();
                {
                    boolean var2A9F58BFB955FE221076F10F69C4E35A_300282467 = (!rm.configure(retryConfig));
                    {
                        {
                            boolean varC9DB307BFBF42DC07215EF2C6586368D_26783112 = (!rm.configure(DEFAULT_DATA_RETRY_CONFIG));
                            {
                                log("Could not configure using DEFAULT_DATA_RETRY_CONFIG="
                            + DEFAULT_DATA_RETRY_CONFIG);
                                rm.configure(20, 2000, 1000);
                            } 
                        } 
                    } 
                } 
                int id = mUniqueIdGenerator.getAndIncrement();
                dataConn = CdmaDataConnection.makeDataConnection(mCdmaPhone, id, rm);
                mDataConnections.put(id, dataConn);
                DataConnectionAc dcac = new DataConnectionAc(dataConn, LOG_TAG);
                int status = dcac.fullyConnectSync(mPhone.getContext(), this, dataConn.getHandler());
                {
                    log("Fully connected");
                    mDataConnectionAsyncChannels.put(dcac.dataConnection.getDataConnectionId(), dcac);
                } 
                {
                    log("Could not connect to dcac.dataConnection=" + dcac.dataConnection +
                        " status=" + status);
                } 
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.729 -0400", hash_original_method = "8430EFDC31AB81EB1D7F0972246BF5F1", hash_generated_method = "69D95EAEF6987DF2357B662FCADD27F0")
    private void destroyAllDataConnectionList() {
        {
            mDataConnections.clear();
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.729 -0400", hash_original_method = "94CE8407A5E1B53B6799DEAF3D95D61E", hash_generated_method = "C52516F9016CE3B1CBFF641BB04D1A71")
    private void onCdmaDataDetached() {
        {
            startNetStatPoll();
            notifyDataConnection(Phone.REASON_CDMA_DATA_DETACHED);
        } 
        {
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.730 -0400", hash_original_method = "A262DC774CC921F05CC1B098B136C4F6", hash_generated_method = "30972AF4C5C6DC24BEBE7FC9067EE928")
    private void onCdmaOtaProvision(AsyncResult ar) {
        {
            int [] otaPrivision = (int [])ar.result;
            {
                
                mDataConnections.get(0).resetRetryCount();
                
            } 
        } 
        addTaint(ar.getTaint());
        
        
            
            
                
                
                
                    
                    
                
                    
                
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.730 -0400", hash_original_method = "7F30476887B77149E22CB7625A399926", hash_generated_method = "ABB791C7D2C9D9C7140CE2D9AD137349")
    private void onRestartRadio() {
        {
            log("************TURN OFF RADIO**************");
            mPhone.mCM.setRadioPower(false, null);
            mPendingRestartRadio = false;
        } 
        
        
            
            
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.730 -0400", hash_original_method = "A45AA34613360795905157920DD95009", hash_generated_method = "D8CBF94090EEDA7198B858102066F497")
    private void writeEventLogCdmaDataDrop() {
        CdmaCellLocation loc = (CdmaCellLocation)(mPhone.getCellLocation());
        EventLog.writeEvent(EventLogTags.CDMA_DATA_DROP,
                loc != null ? loc.getBaseStationId() : -1,
                TelephonyManager.getDefault().getNetworkType());
        
        
        
                
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.731 -0400", hash_original_method = "D056F1F93E1FCCA005B3D5C4043A4B41", hash_generated_method = "2F273E96F95392527096281E3EBB4E7C")
    protected void onDataStateChanged(AsyncResult ar) {
        
        ArrayList<DataCallState> dataCallStates = (ArrayList<DataCallState>)(ar.result);
        {
            boolean isActiveOrDormantConnectionPresent = false;
            int connectionState = DATA_CONNECTION_ACTIVE_PH_LINK_INACTIVE;
            {
                int index = 0;
                boolean varAB81A6C3AD8914A2AA2E8C9A0D6C9CA7_168040585 = (index < dataCallStates.size());
                {
                    connectionState = dataCallStates.get(index).active;
                    {
                        isActiveOrDormantConnectionPresent = true;
                    } 
                } 
            } 
            {
                log("onDataStateChanged: No active connection"
                        + "state is CONNECTED, disconnecting/cleanup");
                writeEventLogCdmaDataDrop();
                cleanUpConnection(true, null);
            } 
            
            log("onDataStateChanged: active=LINK_ACTIVE && CONNECTED, ignore");
            
            
            mActivity = Activity.NONE;
            
            
            mPhone.notifyDataActivity();
            
            
            startNetStatPoll();
            
            
            log("onDataStateChanged active=LINK_DOWN && CONNECTED, dormant");
            
            
            mActivity = Activity.DORMANT;
            
            
            mPhone.notifyDataActivity();
            
            
            stopNetStatPoll();
            
            
            log("onDataStateChanged: IGNORE unexpected DataCallState.active="
                            + connectionState);
            
        } 
        {
            log("onDataStateChanged: not connected, state=" + mState + " ignoring");
        } 
        addTaint(ar.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.732 -0400", hash_original_method = "E7620C231D98F2722A026ACACB1534C7", hash_generated_method = "C8E00807E70088D572C043DE0B3AC1E4")
    private void startDelayedRetry(FailCause cause, String reason) {
        notifyNoData(cause);
        reconnectAfterFail(cause, reason);
        addTaint(cause.getTaint());
        addTaint(reason.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.733 -0400", hash_original_method = "23AB21BFEE9B8AADED0100AF4BC4730D", hash_generated_method = "07AA25C5AE07946E0F46515B1F8A6822")
    @Override
    public void handleMessage(Message msg) {
        log("CdmaDCT handleMessage msg=" + msg);
        {
            log("Ignore CDMA msgs since CDMA phone is inactive");
        } 
        
        onRecordsLoaded();
        
        
        onNVReady();
        
        
        onCdmaDataDetached();
        
        
        onDataStateChanged((AsyncResult) msg.obj);
        
        
        onCdmaOtaProvision((AsyncResult) msg.obj);
        
        
        log("EVENT_RESTART_RADIO");
        
        
        onRestartRadio();
        
        
        super.handleMessage(msg);
        
        addTaint(msg.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.734 -0400", hash_original_method = "40E4BCBCB488969F7D8EBF5CAA1BFE5A", hash_generated_method = "2FFD0454B38995749CC68A4ED2F6A6D4")
    @Override
    public boolean isDisconnected() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_149958092 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_149958092;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.734 -0400", hash_original_method = "C5FFF855C74ADBDA37AC74CEDF90027C", hash_generated_method = "558A1E3C9DFBF9E05BDDD5DEF2EF1EBE")
    @Override
    protected void log(String s) {
        Log.d(LOG_TAG, "[CdmaDCT] " + s);
        addTaint(s.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.735 -0400", hash_original_method = "509A4E6BF6CDBAFC8ECDCC1462D37923", hash_generated_method = "0979C2E06128B79454FA9227F61207E5")
    @Override
    protected void loge(String s) {
        addTaint(s.getTaint());
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.735 -0400", hash_original_field = "07521AF9343CE7B0F1FDA0931E9D1853", hash_generated_field = "026E142D8E01249707E04DC78D4EFF35")

    private static final int TIME_DELAYED_TO_RESTART_RADIO = SystemProperties.getInt("ro.cdma.timetoradiorestart", 60000);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.735 -0400", hash_original_field = "8BDC86CA7F932B0E570620C076050629", hash_generated_field = "01674A6D3DB885DCC7AB5BE2BD593ACF")

    private static final int DATA_CONNECTION_POOL_SIZE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.735 -0400", hash_original_field = "9BD7934FD72152CF2A0C509972E1348D", hash_generated_field = "20166A867EF23E7504249EF3C9B5AB3C")

    private static final String INTENT_RECONNECT_ALARM = "com.android.internal.telephony.cdma-reconnect";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.735 -0400", hash_original_field = "3E7D706FF7519F453045457C432050D2", hash_generated_field = "6C8FF74EEDEE440F89F3FC7EF70C27D7")

    private static final String INTENT_DATA_STALL_ALARM = "com.android.internal.telephony.cdma-data-stall";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.735 -0400", hash_original_field = "B0662EDCAF5EB88046EB78EE4B5A76C2", hash_generated_field = "AF0632B78D1BD6B15A396B584EB3F7C0")

    private static final int DATA_CONNECTION_ACTIVE_PH_LINK_INACTIVE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.735 -0400", hash_original_field = "5C6E63602F34ECBFD0F2B713F582E11D", hash_generated_field = "F92E1A7741887DC6DAF4708B5127D20F")

    private static final int DATA_CONNECTION_ACTIVE_PH_LINK_DOWN = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.735 -0400", hash_original_field = "470D920CDB15F9878B90DEB2DE9258C1", hash_generated_field = "823EB0FF5FCBDCE6A1A71833F5D13138")

    private static final int DATA_CONNECTION_ACTIVE_PH_LINK_UP = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.735 -0400", hash_original_field = "C74D643B2F20AEC802C28072AC8B3CD3", hash_generated_field = "48ED62C0AD71722F4945340F0A7FF5F9")

    private static final String[] mSupportedApnTypes = {
            Phone.APN_TYPE_DEFAULT,
            Phone.APN_TYPE_MMS,
            Phone.APN_TYPE_DUN,
            Phone.APN_TYPE_HIPRI };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.735 -0400", hash_original_field = "0EF95A41F9DB20AECFBBE93D89AB06A4", hash_generated_field = "561E37C406B565A7F36A37780ECC9AAF")

    private static final String[] mDefaultApnTypes = {
            Phone.APN_TYPE_DEFAULT,
            Phone.APN_TYPE_MMS,
            Phone.APN_TYPE_HIPRI };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.735 -0400", hash_original_field = "0808FF718AAFC80A11429FFA40CC973A", hash_generated_field = "897EE016BFDB188E89DEC9B85F66301D")

    private static final int mDefaultApnId = DataConnectionTracker.APN_DEFAULT_ID;
}

