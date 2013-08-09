package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

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






public final class GsmDataConnectionTracker extends DataConnectionTracker {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.695 -0400", hash_original_field = "41EBE7F32B96C1E2E9C209710486A443", hash_generated_field = "7EC1F2F34382E79A9367C16E4BB8DCA3")

    protected final String LOG_TAG = "GSM";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.695 -0400", hash_original_field = "CB443E461AA44F68B1DC476C038F72CE", hash_generated_field = "AFBF9D057D14B66BDF7B1FCB26AAA726")

    private boolean mReregisterOnReconnectFailure = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.695 -0400", hash_original_field = "CF849E3C15214EFD093D4303B542BF44", hash_generated_field = "2ABF989C5B8F051BCBEE638ED1EA2586")

    private ContentResolver mResolver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.695 -0400", hash_original_field = "FA9556560FEE15D3226A9A0A646DC9DC", hash_generated_field = "9743D11ECCACBF447559588D9C3455D1")

    private boolean canSetPreferApn = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.695 -0400", hash_original_field = "93901191D4EDD5699E27D54768404908", hash_generated_field = "7AE0CA44A8148D1733CD8642E6D8D32F")

    private ApnChangeObserver mApnObserver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.843 -0400", hash_original_field = "DCC8D3A9D9C8D2BC581A6F46B0C096D3", hash_generated_field = "DDDFB867C728C3E0E4EFF5278B63FB83")

    private Runnable mPollNetStat = new Runnable() {        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.843 -0400", hash_original_method = "12521CBB0E1762BFCDF7B49EB5CC9977", hash_generated_method = "EEDFDA3636D0462EB4B15FD97B22B6E4")
        @Override
        public void run() {
            updateDataActivity();
            {
                mNetStatPollPeriod = Settings.Secure.getInt(mResolver,
                        Settings.Secure.PDP_WATCHDOG_POLL_INTERVAL_MS, POLL_NETSTAT_MILLIS);
            } 
            {
                mNetStatPollPeriod = Settings.Secure.getInt(mResolver,
                        Settings.Secure.PDP_WATCHDOG_LONG_POLL_INTERVAL_MS,
                        POLL_NETSTAT_SCREEN_OFF_MILLIS);
            } 
            {
                mDataConnectionTracker.postDelayed(this, mNetStatPollPeriod);
            } 
            
            
            
                
                        
            
                
                        
                        
            
            
                
            
        }

        
};
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.696 -0400", hash_original_method = "11FDC14BF2164142AF8732E525079D07", hash_generated_method = "9BB35ECA4CE2F8D428F1776FF242B804")
    public  GsmDataConnectionTracker(PhoneBase p) {
        super(p);
        addTaint(p.getTaint());
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
        IntentFilter filter = new IntentFilter();
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.696 -0400", hash_original_method = "3545EE6BB84B537BCF88623776AFA30D", hash_generated_method = "1737DC5C2B38796452A544CEE48A3277")
    public int getRecoveryAction() {
        int action = Settings.System.getInt(mPhone.getContext().getContentResolver(),
                "radio.data.stall.recovery.action", RecoveryAction.GET_DATA_CALL_LIST);
        if(VDBG)        
        log("getRecoveryAction: " + action);
        int var418C5509E2171D55B0AEE5C2EA4442B5_942169456 = (action);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1694575671 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1694575671;
        // ---------- Original Method ----------
        //int action = Settings.System.getInt(mPhone.getContext().getContentResolver(),
                //"radio.data.stall.recovery.action", RecoveryAction.GET_DATA_CALL_LIST);
        //if (VDBG) log("getRecoveryAction: " + action);
        //return action;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.696 -0400", hash_original_method = "D18EC99E3BCC3D9A76595B0D702BEA57", hash_generated_method = "4915CB2D6436D51D205C41680AC9A600")
    public void putRecoveryAction(int action) {
        addTaint(action);
        Settings.System.putInt(mPhone.getContext().getContentResolver(),
                "radio.data.stall.recovery.action", action);
        if(VDBG)        
        log("putRecoveryAction: " + action);
        // ---------- Original Method ----------
        //Settings.System.putInt(mPhone.getContext().getContentResolver(),
                //"radio.data.stall.recovery.action", action);
        //if (VDBG) log("putRecoveryAction: " + action);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.697 -0400", hash_original_method = "DABEDBF19FEC4514BE5AAA6475C962EB", hash_generated_method = "1A10F629513B738DD341C2BD813B2882")
    @Override
    protected void onActionIntentReconnectAlarm(Intent intent) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(intent.getTaint());
        if(DBG)        
        log("GPRS reconnect alarm. Previous state was " + mState);
        String reason = intent.getStringExtra(INTENT_RECONNECT_ALARM_EXTRA_REASON);
        int connectionId = intent.getIntExtra(INTENT_RECONNECT_ALARM_EXTRA_TYPE, -1);
        DataConnectionAc dcac = mDataConnectionAsyncChannels.get(connectionId);
        if(dcac != null)        
        {
for(ApnContext apnContext : dcac.getApnListSync())
            {
                apnContext.setReason(reason);
                if(apnContext.getState() == State.FAILED)                
                {
                    apnContext.setState(State.IDLE);
                } //End block
                sendMessage(obtainMessage(EVENT_TRY_SETUP_DATA, apnContext));
            } //End block
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.698 -0400", hash_original_method = "4494E5E1AF62FA72ED21CBDD59685023", hash_generated_method = "2CEC678BFD48E0CD7A4526D23263E43F")
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.698 -0400", hash_original_method = "7B2466E598494011616B7E0248698FD2", hash_generated_method = "2B4BB2A1C5F56EC12BA245189DC8902A")
    @Override
    public boolean isApnTypeActive(String type) {
        addTaint(type.getTaint());
        ApnContext apnContext = mApnContexts.get(type);
        if(apnContext == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_216100862 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_601946859 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_601946859;
        }
        boolean var54EBDCB0D8C3DAE7E520C08267482D67_1965951243 = ((apnContext.getDataConnection() != null));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1162444966 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1162444966;
        // ---------- Original Method ----------
        //ApnContext apnContext = mApnContexts.get(type);
        //if (apnContext == null) return false;
        //return (apnContext.getDataConnection() != null);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.699 -0400", hash_original_method = "63B54477A01480F02B741F41FE0D8DBF", hash_generated_method = "A6EEE2BF148D80CF4C3AD5F47F0BF333")
    @Override
    protected boolean isDataPossible(String apnType) {
        addTaint(apnType.getTaint());
        ApnContext apnContext = mApnContexts.get(apnType);
        if(apnContext == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1768615042 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_909766393 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_909766393;
        } //End block
        boolean apnContextIsEnabled = apnContext.isEnabled();
        State apnContextState = apnContext.getState();
        boolean apnTypePossible = !(apnContextIsEnabled &&
                (apnContextState == State.FAILED));
        boolean dataAllowed = isDataAllowed();
        boolean possible = dataAllowed && apnTypePossible;
        if(DBG)        
        {
            log(String.format("isDataPossible(%s): possible=%b isDataAllowed=%b " +
                    "apnTypePossible=%b apnContextisEnabled=%b apnContextState()=%s",
                    apnType, possible, dataAllowed, apnTypePossible,
                    apnContextIsEnabled, apnContextState));
        } //End block
        boolean var6FCC4B7D36184BA33346B4BE2D5D8244_1319236897 = (possible);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_18769879 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_18769879;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.700 -0400", hash_original_method = "6FB50CEA8307C4B6093E637FBC3F2923", hash_generated_method = "758B007E72E5165CA9C8567AC9EFA11A")
    @Override
    protected void finalize() {
        if(DBG)        
        log("finalize");
        // ---------- Original Method ----------
        //if(DBG) log("finalize");
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.700 -0400", hash_original_method = "477FAE9A0F7056536F0C43A4344C1E00", hash_generated_method = "BB7CD7F99A4308A8081325643B157F90")
    @Override
    protected String getActionIntentReconnectAlarm() {
String var329BD4E79853976212F297A2D79B9594_1477581043 =         INTENT_RECONNECT_ALARM;
        var329BD4E79853976212F297A2D79B9594_1477581043.addTaint(taint);
        return var329BD4E79853976212F297A2D79B9594_1477581043;
        // ---------- Original Method ----------
        //return INTENT_RECONNECT_ALARM;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.700 -0400", hash_original_method = "BBE23E9137760572C0B9E85F7DE2F87D", hash_generated_method = "383C5973359C9809F9622FBA80272BFE")
    @Override
    protected String getActionIntentDataStallAlarm() {
String var91B284560FDB6DF833F06E9F3D4A1EF3_1091883027 =         INTENT_DATA_STALL_ALARM;
        var91B284560FDB6DF833F06E9F3D4A1EF3_1091883027.addTaint(taint);
        return var91B284560FDB6DF833F06E9F3D4A1EF3_1091883027;
        // ---------- Original Method ----------
        //return INTENT_DATA_STALL_ALARM;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.701 -0400", hash_original_method = "0E3E3502B5D9BF75D72D228425E0F7B7", hash_generated_method = "7930A6653B8633EF0E12C54EF9ED9193")
    private ApnContext addApnContext(String type) {
        addTaint(type.getTaint());
        ApnContext apnContext = new ApnContext(type, LOG_TAG);
        apnContext.setDependencyMet(false);
        mApnContexts.put(type, apnContext);
ApnContext varCF4B811E793262ABD77EF06D86F9643C_152451624 =         apnContext;
        varCF4B811E793262ABD77EF06D86F9643C_152451624.addTaint(taint);
        return varCF4B811E793262ABD77EF06D86F9643C_152451624;
        // ---------- Original Method ----------
        //ApnContext apnContext = new ApnContext(type, LOG_TAG);
        //apnContext.setDependencyMet(false);
        //mApnContexts.put(type, apnContext);
        //return apnContext;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.702 -0400", hash_original_method = "8959993CE2EB92BA5CEF3E2E51BAABDD", hash_generated_method = "0BD192C276C19E4DE5BE66B496FF4B76")
    protected void initApnContextsAndDataConnection() {
        boolean defaultEnabled = SystemProperties.getBoolean(DEFALUT_DATA_ON_BOOT_PROP, true);
        String[] networkConfigStrings = mPhone.getContext().getResources().getStringArray(
                com.android.internal.R.array.networkAttributes);
for(String networkConfigString : networkConfigStrings)
        {
            NetworkConfig networkConfig = new NetworkConfig(networkConfigString);
            ApnContext apnContext = null;
switch(networkConfig.type){
            case ConnectivityManager.TYPE_MOBILE:
            apnContext = addApnContext(Phone.APN_TYPE_DEFAULT);
            apnContext.setEnabled(defaultEnabled);
            break;
            case ConnectivityManager.TYPE_MOBILE_MMS:
            apnContext = addApnContext(Phone.APN_TYPE_MMS);
            break;
            case ConnectivityManager.TYPE_MOBILE_SUPL:
            apnContext = addApnContext(Phone.APN_TYPE_SUPL);
            break;
            case ConnectivityManager.TYPE_MOBILE_DUN:
            apnContext = addApnContext(Phone.APN_TYPE_DUN);
            break;
            case ConnectivityManager.TYPE_MOBILE_HIPRI:
            apnContext = addApnContext(Phone.APN_TYPE_HIPRI);
            ApnContext defaultContext = mApnContexts.get(Phone.APN_TYPE_DEFAULT);
            if(defaultContext != null)            
            {
                applyNewState(apnContext, apnContext.isEnabled(),
                            defaultContext.getDependencyMet());
            } //End block
            else
            {
            } //End block
            continue;
            case ConnectivityManager.TYPE_MOBILE_FOTA:
            apnContext = addApnContext(Phone.APN_TYPE_FOTA);
            break;
            case ConnectivityManager.TYPE_MOBILE_IMS:
            apnContext = addApnContext(Phone.APN_TYPE_IMS);
            break;
            case ConnectivityManager.TYPE_MOBILE_CBS:
            apnContext = addApnContext(Phone.APN_TYPE_CBS);
            break;
            default:
            continue;
}            if(apnContext != null)            
            {
                onSetDependencyMet(apnContext.getApnType(), networkConfig.dependencyMet);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.702 -0400", hash_original_method = "C5F45AE4298273442B50BBFD614E8417", hash_generated_method = "572C05D22834B8491D42BEB374105C9D")
    @Override
    protected LinkProperties getLinkProperties(String apnType) {
        addTaint(apnType.getTaint());
        ApnContext apnContext = mApnContexts.get(apnType);
        if(apnContext != null)        
        {
            DataConnectionAc dcac = apnContext.getDataConnectionAc();
            if(dcac != null)            
            {
                if(DBG)                
                log("return link properites for " + apnType);
LinkProperties var8BD4388B7A3814FD10D806AF7ED51688_22336288 =                 dcac.getLinkPropertiesSync();
                var8BD4388B7A3814FD10D806AF7ED51688_22336288.addTaint(taint);
                return var8BD4388B7A3814FD10D806AF7ED51688_22336288;
            } //End block
        } //End block
        if(DBG)        
        log("return new LinkProperties");
LinkProperties varF900AB9E8929FEE5E70A9D065AB8EDB8_356631149 =         new LinkProperties();
        varF900AB9E8929FEE5E70A9D065AB8EDB8_356631149.addTaint(taint);
        return varF900AB9E8929FEE5E70A9D065AB8EDB8_356631149;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.703 -0400", hash_original_method = "94651B427B7F42F00ED4B45503EF287D", hash_generated_method = "9B34C5065B29882B30CC160921EFC01C")
    @Override
    protected LinkCapabilities getLinkCapabilities(String apnType) {
        addTaint(apnType.getTaint());
        ApnContext apnContext = mApnContexts.get(apnType);
        if(apnContext!=null)        
        {
            DataConnectionAc dataConnectionAc = apnContext.getDataConnectionAc();
            if(dataConnectionAc != null)            
            {
                if(DBG)                
                log("get active pdp is not null, return link Capabilities for " + apnType);
LinkCapabilities var29905B5F038DAF89E326E3E71B5EFF05_1796864802 =                 dataConnectionAc.getLinkCapabilitiesSync();
                var29905B5F038DAF89E326E3E71B5EFF05_1796864802.addTaint(taint);
                return var29905B5F038DAF89E326E3E71B5EFF05_1796864802;
            } //End block
        } //End block
        if(DBG)        
        log("return new LinkCapabilities");
LinkCapabilities var5BB424D660FE96EE1DB16C6054B1CD0C_1135578155 =         new LinkCapabilities();
        var5BB424D660FE96EE1DB16C6054B1CD0C_1135578155.addTaint(taint);
        return var5BB424D660FE96EE1DB16C6054B1CD0C_1135578155;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.703 -0400", hash_original_method = "BFF203ED461E9185DBA7A58AF111F0F3", hash_generated_method = "CFE19DA105B5F190A0F2D0C7BDFFC59E")
    @Override
    public String[] getActiveApnTypes() {
        if(DBG)        
        log("get all active apn types");
        ArrayList<String> result = new ArrayList<String>();
for(ApnContext apnContext : mApnContexts.values())
        {
            if(apnContext.isReady())            
            {
                result.add(apnContext.getApnType());
            } //End block
        } //End block
String[] var0DC708DD5D4C3EE2353654471D9E74FF_219549989 =         (String[])result.toArray(new String[0]);
        var0DC708DD5D4C3EE2353654471D9E74FF_219549989.addTaint(taint);
        return var0DC708DD5D4C3EE2353654471D9E74FF_219549989;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.704 -0400", hash_original_method = "8D1CDDA6C04920E256FCAAE007846C5E", hash_generated_method = "89230DDB34D87C4A3CF2E3B241CA9A1E")
    @Override
    public String getActiveApnString(String apnType) {
        addTaint(apnType.getTaint());
        if(DBG)        
        log( "get active apn string for type:" + apnType);
        ApnContext apnContext = mApnContexts.get(apnType);
        if(apnContext != null)        
        {
            ApnSetting apnSetting = apnContext.getApnSetting();
            if(apnSetting != null)            
            {
String var7151830B6BA624A30363614FF86DFCBF_1373884583 =                 apnSetting.apn;
                var7151830B6BA624A30363614FF86DFCBF_1373884583.addTaint(taint);
                return var7151830B6BA624A30363614FF86DFCBF_1373884583;
            } //End block
        } //End block
String var540C13E9E156B687226421B24F2DF178_1102299304 =         null;
        var540C13E9E156B687226421B24F2DF178_1102299304.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1102299304;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.704 -0400", hash_original_method = "5E11C1BF7F74A775167DAE6DA061B097", hash_generated_method = "3095B322D583B68EB2913F149ADCAD80")
    @Override
    public boolean isApnTypeEnabled(String apnType) {
        addTaint(apnType.getTaint());
        ApnContext apnContext = mApnContexts.get(apnType);
        if(apnContext == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1226189585 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_579350739 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_579350739;
        } //End block
        boolean varF209F25DF06DF2E56BC2E1B68AAE1FAC_721750052 = (apnContext.isEnabled());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1606987238 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1606987238;
        // ---------- Original Method ----------
        //ApnContext apnContext = mApnContexts.get(apnType);
        //if (apnContext == null) {
            //return false;
        //}
        //return apnContext.isEnabled();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.704 -0400", hash_original_method = "06373F80BD4BEEF603E49D19A1DC6DA1", hash_generated_method = "945F45D655F72B24D6A2158AD21FE98E")
    @Override
    protected void setState(State s) {
        addTaint(s.getTaint());
        if(DBG)        
        log("setState should not be used in GSM" + s);
        // ---------- Original Method ----------
        //if (DBG) log("setState should not be used in GSM" + s);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.704 -0400", hash_original_method = "F24CC52DF36174C789130EC41124E06F", hash_generated_method = "A83FF816E106CA31644524FB2E39F96B")
    @Override
    public State getState(String apnType) {
        addTaint(apnType.getTaint());
        ApnContext apnContext = mApnContexts.get(apnType);
        if(apnContext != null)        
        {
State var39DD99C3EDAB2F9B605847A2ED5E8C65_504801348 =             apnContext.getState();
            var39DD99C3EDAB2F9B605847A2ED5E8C65_504801348.addTaint(taint);
            return var39DD99C3EDAB2F9B605847A2ED5E8C65_504801348;
        } //End block
State varC0DC3708F3E928943B2805F3F9CB2E19_1776183859 =         State.FAILED;
        varC0DC3708F3E928943B2805F3F9CB2E19_1776183859.addTaint(taint);
        return varC0DC3708F3E928943B2805F3F9CB2E19_1776183859;
        // ---------- Original Method ----------
        //ApnContext apnContext = mApnContexts.get(apnType);
        //if (apnContext != null) {
            //return apnContext.getState();
        //}
        //return State.FAILED;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.705 -0400", hash_original_method = "3A07E102C7877AE139AF74E35A92CB31", hash_generated_method = "62D182681FB804DED59BFF538DCBDE20")
    public State getOverallState() {
        boolean isConnecting = false;
        boolean isFailed = true;
        boolean isAnyEnabled = false;
for(ApnContext apnContext : mApnContexts.values())
        {
            if(apnContext.isEnabled())            
            {
                isAnyEnabled = true;
switch(apnContext.getState()){
                case CONNECTED:
                case DISCONNECTING:
                if(DBG)                
                log("overall state is CONNECTED");
State var560B735D9012988A1B35887C4968D978_790907919 =                 State.CONNECTED;
                var560B735D9012988A1B35887C4968D978_790907919.addTaint(taint);
                return var560B735D9012988A1B35887C4968D978_790907919;
                case CONNECTING:
                case INITING:
                isConnecting = true;
                isFailed = false;
                break;
                case IDLE:
                case SCANNING:
                isFailed = false;
                break;
}
            } //End block
        } //End block
        if(!isAnyEnabled)        
        {
            if(DBG)            
            log( "overall state is IDLE");
State var3D89DEB992719400511F77A4DCAD3F69_1960175448 =             State.IDLE;
            var3D89DEB992719400511F77A4DCAD3F69_1960175448.addTaint(taint);
            return var3D89DEB992719400511F77A4DCAD3F69_1960175448;
        } //End block
        if(isConnecting)        
        {
            if(DBG)            
            log( "overall state is CONNECTING");
State var0E9FBEE765D13CE6A4D6FCABA7024869_1241211732 =             State.CONNECTING;
            var0E9FBEE765D13CE6A4D6FCABA7024869_1241211732.addTaint(taint);
            return var0E9FBEE765D13CE6A4D6FCABA7024869_1241211732;
        } //End block
        else
        if(!isFailed)        
        {
            if(DBG)            
            log( "overall state is IDLE");
State var3D89DEB992719400511F77A4DCAD3F69_2084264433 =             State.IDLE;
            var3D89DEB992719400511F77A4DCAD3F69_2084264433.addTaint(taint);
            return var3D89DEB992719400511F77A4DCAD3F69_2084264433;
        } //End block
        else
        {
            if(DBG)            
            log( "overall state is FAILED");
State varC0DC3708F3E928943B2805F3F9CB2E19_1601243859 =             State.FAILED;
            varC0DC3708F3E928943B2805F3F9CB2E19_1601243859.addTaint(taint);
            return varC0DC3708F3E928943B2805F3F9CB2E19_1601243859;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.706 -0400", hash_original_method = "DED9CF35B00E99A5C3539FDABA142E11", hash_generated_method = "1CA58DFC2E6A12A8758A94675B5170EB")
    @Override
    public synchronized int enableApnType(String apnType) {
        addTaint(apnType.getTaint());
        ApnContext apnContext = mApnContexts.get(apnType);
        if(apnContext == null || !isApnTypeAvailable(apnType))        
        {
            if(DBG)            
            log("enableApnType: " + apnType + " is type not available");
            int var8DA92D2F202C4CA76CA9A68B75D9B1E3_943853834 = (Phone.APN_TYPE_NOT_AVAILABLE);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_672205324 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_672205324;
        } //End block
        if(DBG)        
        log("enableApnType: " + apnType + " mState(" + apnContext.getState() + ")");
        if(apnContext.getState() == State.CONNECTED)        
        {
            if(DBG)            
            log("enableApnType: return APN_ALREADY_ACTIVE");
            int var10EDC12F6E39EB6E652C0E451BD3FCA6_802459001 = (Phone.APN_ALREADY_ACTIVE);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1643227014 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1643227014;
        } //End block
        setEnabled(apnTypeToId(apnType), true);
        if(DBG)        
        {
            log("enableApnType: new apn request for type " + apnType +
                    " return APN_REQUEST_STARTED");
        } //End block
        int var294B3FA049569E2B8E6FC7D927E71152_2015787675 = (Phone.APN_REQUEST_STARTED);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1126311177 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1126311177;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.707 -0400", hash_original_method = "6BE0F7A51104BACC1DFB5733CC5E30CC", hash_generated_method = "AEC7D1F1F39E4380066CE86B73C1BBE9")
    private void notifyApnIdUpToCurrent(String reason, ApnContext apnContext, String type) {
        addTaint(type.getTaint());
        addTaint(apnContext.getTaint());
        addTaint(reason.getTaint());
switch(apnContext.getState()){
        case IDLE:
        case INITING:
        break;
        case CONNECTING:
        case SCANNING:
        mPhone.notifyDataConnection(reason, type, Phone.DataState.CONNECTING);
        break;
        case CONNECTED:
        case DISCONNECTING:
        mPhone.notifyDataConnection(reason, type, Phone.DataState.CONNECTING);
        mPhone.notifyDataConnection(reason, type, Phone.DataState.CONNECTED);
        break;
}
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.707 -0400", hash_original_method = "68A04474A9A6C009171326D545E43C31", hash_generated_method = "6580072D0D7DC737F43AABC33D9B1DEE")
    @Override
    public synchronized int disableApnType(String type) {
        addTaint(type.getTaint());
        if(DBG)        
        log("disableApnType:" + type);
        ApnContext apnContext = mApnContexts.get(type);
        if(apnContext != null)        
        {
            setEnabled(apnTypeToId(type), false);
            if(apnContext.getState() != State.IDLE && apnContext.getState() != State.FAILED)            
            {
                if(DBG)                
                log("diableApnType: return APN_REQUEST_STARTED");
                int var294B3FA049569E2B8E6FC7D927E71152_1447085800 = (Phone.APN_REQUEST_STARTED);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_857723591 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_857723591;
            } //End block
            else
            {
                if(DBG)                
                log("disableApnType: return APN_ALREADY_INACTIVE");
                int var91E8AE9C5AF8A58CEBA118DB824217B8_1707740704 = (Phone.APN_ALREADY_INACTIVE);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1597293747 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1597293747;
            } //End block
        } //End block
        else
        {
            if(DBG)            
            {
                log("disableApnType: no apn context was found, return APN_REQUEST_FAILED");
            } //End block
            int var828862E346BB9F0775660355A8FF69D9_214412623 = (Phone.APN_REQUEST_FAILED);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1541723375 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1541723375;
        } //End block
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.708 -0400", hash_original_method = "A26AD8C394281D1D0A1213181383C4F5", hash_generated_method = "9764B10E9C554F3652C7F95F840A86FE")
    @Override
    protected boolean isApnTypeAvailable(String type) {
        addTaint(type.getTaint());
        if(type.equals(Phone.APN_TYPE_DUN) && fetchDunApn() != null)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1744329957 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_27489542 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_27489542;
        } //End block
        if(mAllApns != null)        
        {
for(ApnSetting apn : mAllApns)
            {
                if(apn.canHandleType(type))                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_120525215 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_942338533 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_942338533;
                } //End block
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_80959073 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_610183890 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_610183890;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.708 -0400", hash_original_method = "C851438642EDA5AB3134873854010685", hash_generated_method = "B75438F412CF2A06D1C56A015372F8AE")
    @Override
    public boolean getAnyDataEnabled() {
        synchronized
(mDataEnabledLock)        {
            if(!(mInternalDataEnabled && mUserDataEnabled && sPolicyDataEnabled))            
            {
            boolean var68934A3E9455FA72420237EB05902327_265067073 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_283312037 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_283312037;
            }
for(ApnContext apnContext : mApnContexts.values())
            {
                if(isDataAllowed(apnContext))                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_1036057110 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_789142832 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_789142832;
                } //End block
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_2138058734 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1075878708 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1075878708;
        } //End block
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.709 -0400", hash_original_method = "7A177E6FBAF2829724A437FA44770C6E", hash_generated_method = "0AFF6E1AC9321F3F52DC45163866D9B1")
    private boolean isDataAllowed(ApnContext apnContext) {
        addTaint(apnContext.getTaint());
        boolean var2F3B447EE18FDB9E879ED2DF25717D84_1445606888 = (apnContext.isReady() && isDataAllowed());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2085504086 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2085504086;
        // ---------- Original Method ----------
        //return apnContext.isReady() && isDataAllowed();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.709 -0400", hash_original_method = "DBAD0221F2A53A2AC3E8556324A28A19", hash_generated_method = "63CDEA985F972FC14F1A6DB6531AF1DD")
    protected void onDataConnectionDetached() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        if(DBG)        
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.709 -0400", hash_original_method = "F401CBF6A4FFFF291696606C3EE2FE85", hash_generated_method = "F5664691DC862F1CD59F21FEFCB2F8CA")
    private void onDataConnectionAttached() {
        if(DBG)        
        log("onDataConnectionAttached");
        if(getOverallState() == State.CONNECTED)        
        {
            if(DBG)            
            log("onDataConnectionAttached: start polling notify attached");
            startNetStatPoll();
            startDataStallAlarm();
            notifyDataConnection(Phone.REASON_DATA_ATTACHED);
        } //End block
        else
        {
            notifyOffApnsOfAvailability(Phone.REASON_DATA_ATTACHED);
        } //End block
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.711 -0400", hash_original_method = "000E90D5C33553E8124AA0C75E4D9E4F", hash_generated_method = "DAB42CC3EE8D5C2C6F1B7BE06C7222DC")
    @Override
    protected boolean isDataAllowed() {
        boolean internalDataEnabled;
        synchronized
(mDataEnabledLock)        {
            internalDataEnabled = mInternalDataEnabled;
        } //End block
        int gprsState = mPhone.getServiceStateTracker().getCurrentDataConnectionState();
        boolean desiredPowerState = mPhone.getServiceStateTracker().getDesiredPowerState();
        boolean allowed = (gprsState == ServiceState.STATE_IN_SERVICE || mAutoAttachOnCreation) &&
                    mPhone.mIccRecords.getRecordsLoaded() &&
                    (mPhone.getState() == Phone.State.IDLE ||
                     mPhone.getServiceStateTracker().isConcurrentVoiceAndDataAllowed()) &&
                    internalDataEnabled &&
                    (!mPhone.getServiceState().getRoaming() || getDataOnRoamingEnabled()) &&
                    !mIsPsRestricted &&
                    desiredPowerState;
        if(!allowed && DBG)        
        {
            String reason = "";
            if(!((gprsState == ServiceState.STATE_IN_SERVICE) || mAutoAttachOnCreation))            
            {
                reason += " - gprs= " + gprsState;
            } //End block
            if(!mPhone.mIccRecords.getRecordsLoaded())            
            reason += " - SIM not loaded";
            if(mPhone.getState() != Phone.State.IDLE &&
                    !mPhone.getServiceStateTracker().isConcurrentVoiceAndDataAllowed())            
            {
                reason += " - PhoneState= " + mPhone.getState();
                reason += " - Concurrent voice and data not allowed";
            } //End block
            if(!internalDataEnabled)            
            reason += " - mInternalDataEnabled= false";
            if(mPhone.getServiceState().getRoaming() && !getDataOnRoamingEnabled())            
            {
                reason += " - Roaming and data roaming not enabled";
            } //End block
            if(mIsPsRestricted)            
            reason += " - mIsPsRestricted= true";
            if(!desiredPowerState)            
            reason += " - desiredPowerState= false";
            if(DBG)            
            log("isDataAllowed: not allowed due to" + reason);
        } //End block
        boolean var22EE71E9DCC9CA12FC313C6E1CE3F806_1120436216 = (allowed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1614687161 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1614687161;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.712 -0400", hash_original_method = "625A02DD3D04B0C927BA692603CBFCC6", hash_generated_method = "AA6F16FC0E1C09AE38C93A09D76220B8")
    private void setupDataOnReadyApns(String reason) {
        addTaint(reason.getTaint());
for(DataConnectionAc dcac : mDataConnectionAsyncChannels.values())
        {
            if(dcac.getReconnectIntentSync() != null)            
            {
                cancelReconnectAlarm(dcac);
            } //End block
            if(dcac.dataConnection != null)            
            {
                Collection<ApnContext> apns = dcac.getApnListSync();
                boolean hasDefault = false;
for(ApnContext apnContext : apns)
                {
                    if(apnContext.getApnType().equals(Phone.APN_TYPE_DEFAULT))                    
                    {
                        hasDefault = true;
                        break;
                    } //End block
                } //End block
                configureRetry(dcac.dataConnection, hasDefault);
            } //End block
        } //End block
for(ApnContext apnContext : mApnContexts.values())
        {
            if(apnContext.getState() == State.FAILED)            
            {
                apnContext.setState(State.IDLE);
            } //End block
            if(apnContext.isReady())            
            {
                if(apnContext.getState() == State.IDLE)                
                {
                    apnContext.setReason(reason);
                    trySetupData(apnContext);
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.713 -0400", hash_original_method = "293D247CD6F3CD381680AFA4CF477431", hash_generated_method = "F052C66F8F4E4D3A901321FBE9F7CB6B")
    private boolean trySetupData(String reason, String type) {
        addTaint(type.getTaint());
        addTaint(reason.getTaint());
        if(DBG)        
        {
            log("trySetupData: " + type + " due to " + (reason == null ? "(unspecified)" : reason)
                    + " isPsRestricted=" + mIsPsRestricted);
        } //End block
        if(type == null)        
        {
            type = Phone.APN_TYPE_DEFAULT;
        } //End block
        ApnContext apnContext = mApnContexts.get(type);
        if(apnContext == null)        
        {
            if(DBG)            
            log("trySetupData new apn context for type:" + type);
            apnContext = new ApnContext(type, LOG_TAG);
            mApnContexts.put(type, apnContext);
        } //End block
        apnContext.setReason(reason);
        boolean var4B0B7DA8605CF08A23D3A47E6BE927CC_228412646 = (trySetupData(apnContext));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_759008655 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_759008655;
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.713 -0400", hash_original_method = "01B865917AB0716CB4ECB273F41078C0", hash_generated_method = "0EA66E62005312C4CAB0230A417FA561")
    private boolean trySetupData(ApnContext apnContext) {
        addTaint(apnContext.getTaint());
        if(DBG)        
        {
            log("trySetupData for type:" + apnContext.getApnType() +
                    " due to " + apnContext.getReason());
            log("trySetupData with mIsPsRestricted=" + mIsPsRestricted);
        } //End block
        if(mPhone.getSimulatedRadioControl() != null)        
        {
            apnContext.setState(State.CONNECTED);
            mPhone.notifyDataConnection(apnContext.getReason(), apnContext.getApnType());
            log("trySetupData: (fix?) We're on the simulator; assuming data is connected");
            boolean varB326B5062B2F0E69046810717534CB09_1609728479 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1739860562 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1739860562;
        } //End block
        boolean desiredPowerState = mPhone.getServiceStateTracker().getDesiredPowerState();
        if((apnContext.getState() == State.IDLE || apnContext.getState() == State.SCANNING) &&
                isDataAllowed(apnContext) && getAnyDataEnabled() && !isEmergency())        
        {
            if(apnContext.getState() == State.IDLE)            
            {
                ArrayList<ApnSetting> waitingApns = buildWaitingApns(apnContext.getApnType());
                if(waitingApns.isEmpty())                
                {
                    if(DBG)                    
                    log("trySetupData: No APN found");
                    notifyNoData(GsmDataConnection.FailCause.MISSING_UNKNOWN_APN, apnContext);
                    notifyOffApnsOfAvailability(apnContext.getReason());
                    boolean var68934A3E9455FA72420237EB05902327_2122545567 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_164022925 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_164022925;
                } //End block
                else
                {
                    apnContext.setWaitingApns(waitingApns);
                    if(DBG)                    
                    {
                        log ("trySetupData: Create from mAllApns : " + apnListToString(mAllApns));
                    } //End block
                } //End block
            } //End block
            if(DBG)            
            {
                log ("Setup watingApns : " + apnListToString(apnContext.getWaitingApns()));
            } //End block
            boolean retValue = setupData(apnContext);
            notifyOffApnsOfAvailability(apnContext.getReason());
            boolean var9C7BD17E8EB1C3D0F843684A79A18570_1385632845 = (retValue);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_520263400 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_520263400;
        } //End block
        else
        {
            if(!apnContext.getApnType().equals(Phone.APN_TYPE_DEFAULT)
                && (apnContext.getState() == State.IDLE
                    || apnContext.getState() == State.SCANNING))            
            mPhone.notifyDataConnectionFailed(apnContext.getReason(), apnContext.getApnType());
            notifyOffApnsOfAvailability(apnContext.getReason());
            boolean var68934A3E9455FA72420237EB05902327_1308429715 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2001714308 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2001714308;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.715 -0400", hash_original_method = "9CD870BA8C542E1D80FC2F2D725750C0", hash_generated_method = "ED1C95FB4B92A2A975CE6A7A020BFFFD")
    @Override
    protected void notifyOffApnsOfAvailability(String reason) {
        addTaint(reason.getTaint());
for(ApnContext apnContext : mApnContexts.values())
        {
            if(!apnContext.isReady())            
            {
                if(DBG)                
                log("notifyOffApnOfAvailability type:" + apnContext.getApnType());
                mPhone.notifyDataConnection(reason != null ? reason : apnContext.getReason(),
                                            apnContext.getApnType(),
                                            Phone.DataState.DISCONNECTED);
            } //End block
            else
            {
                if(DBG)                
                {
                    log("notifyOffApnsOfAvailability skipped apn due to isReady==false: " +
                            apnContext.toString());
                } //End block
            } //End block
        } //End block
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.716 -0400", hash_original_method = "66E1568E09B68AEC1E9A7CA6629E1BE4", hash_generated_method = "FAF12D0C0A24F1B66149C9887B597D50")
    protected void cleanUpAllConnections(boolean tearDown, String reason) {
        addTaint(reason.getTaint());
        addTaint(tearDown);
        if(DBG)        
        log("cleanUpAllConnections: tearDown=" + tearDown + " reason=" + reason);
for(ApnContext apnContext : mApnContexts.values())
        {
            apnContext.setReason(reason);
            cleanUpConnection(tearDown, apnContext);
        } //End block
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.716 -0400", hash_original_method = "CD47D8147DAAE254C6F8BD59780442CD", hash_generated_method = "2D088F3876E1383B088B94DAEFF2ED24")
    @Override
    protected void onCleanUpAllConnections(String cause) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(cause.getTaint());
        cleanUpAllConnections(true, cause);
        // ---------- Original Method ----------
        //cleanUpAllConnections(true, cause);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.716 -0400", hash_original_method = "2562A19804F84494AABD51DA4769B2BA", hash_generated_method = "56A3DA4642D9BA1FAE4DAD04A19FB87F")
    private void cleanUpConnection(boolean tearDown, ApnContext apnContext) {
        addTaint(apnContext.getTaint());
        addTaint(tearDown);
        if(apnContext == null)        
        {
            if(DBG)            
            log("cleanUpConnection: apn context is null");
            return;
        } //End block
        if(DBG)        
        {
            log("cleanUpConnection: tearDown=" + tearDown + " reason=" + apnContext.getReason());
        } //End block
        DataConnectionAc dcac = apnContext.getDataConnectionAc();
        if(tearDown)        
        {
            if(apnContext.isDisconnected())            
            {
                apnContext.setState(State.IDLE);
                if(!apnContext.isReady())                
                {
                    apnContext.setDataConnection(null);
                    apnContext.setDataConnectionAc(null);
                } //End block
            } //End block
            else
            {
                if(dcac != null)                
                {
                    if(apnContext.getState() != State.DISCONNECTING)                    
                    {
                        if(DBG)                        
                        log("cleanUpConnection: tearing down");
                        Message msg = obtainMessage(EVENT_DISCONNECT_DONE, apnContext);
                        apnContext.getDataConnection().tearDown(apnContext.getReason(), msg);
                        apnContext.setState(State.DISCONNECTING);
                    } //End block
                } //End block
                else
                {
                    apnContext.setState(State.IDLE);
                    mPhone.notifyDataConnection(apnContext.getReason(),
                                                apnContext.getApnType());
                } //End block
            } //End block
        } //End block
        else
        {
            if(dcac != null)            
            dcac.resetSync();
            apnContext.setState(State.IDLE);
            mPhone.notifyDataConnection(apnContext.getReason(), apnContext.getApnType());
            apnContext.setDataConnection(null);
            apnContext.setDataConnectionAc(null);
        } //End block
        if(dcac != null)        
        {
            Collection<ApnContext> apnList = dcac.getApnListSync();
            if(apnList.isEmpty())            
            {
                cancelReconnectAlarm(dcac);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.717 -0400", hash_original_method = "1F926905027AA18BF39C8A7A893395A9", hash_generated_method = "EFF3D3EDBD279CE88D9AC9CAE51B09E4")
    private void cancelReconnectAlarm(DataConnectionAc dcac) {
        addTaint(dcac.getTaint());
        if(dcac == null)        
        return;
        PendingIntent intent = dcac.getReconnectIntentSync();
        if(intent != null)        
        {
            AlarmManager am = (AlarmManager) mPhone.getContext().getSystemService(Context.ALARM_SERVICE);
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.718 -0400", hash_original_method = "08930E35848EBECD6CC869C9C6D6B1F8", hash_generated_method = "BC213494F4ECDED0DEC79D99264DB123")
    private String[] parseTypes(String types) {
        addTaint(types.getTaint());
        String[] result;
        if(types == null || types.equals(""))        
        {
            result = new String[1];
            result[0] = Phone.APN_TYPE_ALL;
        } //End block
        else
        {
            result = types.split(",");
        } //End block
String[] varDC838461EE2FA0CA4C9BBB70A15456B0_704813433 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_704813433.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_704813433;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.718 -0400", hash_original_method = "25E446029D7F780B1E04F89AE12B062D", hash_generated_method = "38B3AF6C86547375FFF20102E039F285")
    private ArrayList<ApnSetting> createApnList(Cursor cursor) {
        addTaint(cursor.getTaint());
        ArrayList<ApnSetting> result = new ArrayList<ApnSetting>();
        if(cursor.moveToFirst())        
        {
            do {
                {
                    String[] types = parseTypes(
                        cursor.getString(cursor.getColumnIndexOrThrow(Telephony.Carriers.TYPE)));
                    ApnSetting apn = new ApnSetting(
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
} while (cursor.moveToNext());
        } //End block
        if(DBG)        
        log("createApnList: X result=" + result);
ArrayList<ApnSetting> varDC838461EE2FA0CA4C9BBB70A15456B0_1378360060 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1378360060.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1378360060;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.719 -0400", hash_original_method = "2E87B4CBA5BF77A80284005F43D6FB91", hash_generated_method = "8131A0B87CC412980EE71B7781491EF8")
    private boolean dataConnectionNotInUse(DataConnectionAc dcac) {
        addTaint(dcac.getTaint());
for(ApnContext apnContext : mApnContexts.values())
        {
            if(apnContext.getDataConnectionAc() == dcac)            
            {
            boolean var68934A3E9455FA72420237EB05902327_354529906 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_978588087 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_978588087;
            }
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1623475179 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_399920764 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_399920764;
        // ---------- Original Method ----------
        //for (ApnContext apnContext : mApnContexts.values()) {
            //if (apnContext.getDataConnectionAc() == dcac) return false;
        //}
        //return true;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.719 -0400", hash_original_method = "871B8246FCDE157C8EBBD019FC69C7EE", hash_generated_method = "9CEB3698982C9F63175774AB60599C28")
    private GsmDataConnection findFreeDataConnection() {
for(DataConnectionAc dcac : mDataConnectionAsyncChannels.values())
        {
            if(dcac.isInactiveSync() && dataConnectionNotInUse(dcac))            
            {
                log("findFreeDataConnection: found free GsmDataConnection");
GsmDataConnection varC8C3EA578D0E30F917A062408458FE73_953364080 =                 (GsmDataConnection) dcac.dataConnection;
                varC8C3EA578D0E30F917A062408458FE73_953364080.addTaint(taint);
                return varC8C3EA578D0E30F917A062408458FE73_953364080;
            } //End block
        } //End block
        log("findFreeDataConnection: NO free GsmDataConnection");
GsmDataConnection var540C13E9E156B687226421B24F2DF178_489365810 =         null;
        var540C13E9E156B687226421B24F2DF178_489365810.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_489365810;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.720 -0400", hash_original_method = "9845808D61EC26568899ACA30184D52E", hash_generated_method = "2E10706A4D450F8E3AB6BC24178C6827")
    protected GsmDataConnection findReadyDataConnection(ApnSetting apn) {
        addTaint(apn.getTaint());
        if(DBG)        
        log("findReadyDataConnection: apn string <" +
                (apn!=null?(apn.toString()):"null") +">");
        if(apn == null)        
        {
GsmDataConnection var540C13E9E156B687226421B24F2DF178_572590763 =             null;
            var540C13E9E156B687226421B24F2DF178_572590763.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_572590763;
        } //End block
for(DataConnectionAc dcac : mDataConnectionAsyncChannels.values())
        {
            ApnSetting apnSetting = dcac.getApnSettingSync();
            if(DBG)            
            {
                log("findReadyDataConnection: dc apn string <" +
                         (apnSetting != null ? (apnSetting.toString()) : "null") + ">");
            } //End block
            if((apnSetting != null) && TextUtils.equals(apnSetting.toString(), apn.toString()))            
            {
GsmDataConnection varC8C3EA578D0E30F917A062408458FE73_399544183 =                 (GsmDataConnection) dcac.dataConnection;
                varC8C3EA578D0E30F917A062408458FE73_399544183.addTaint(taint);
                return varC8C3EA578D0E30F917A062408458FE73_399544183;
            } //End block
        } //End block
GsmDataConnection var540C13E9E156B687226421B24F2DF178_2905146 =         null;
        var540C13E9E156B687226421B24F2DF178_2905146.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_2905146;
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.722 -0400", hash_original_method = "BBFF3626F623A28B2260A4B879BEB776", hash_generated_method = "AC33185B6D72E3F4F186A5677E7B2640")
    private boolean setupData(ApnContext apnContext) {
        addTaint(apnContext.getTaint());
        if(DBG)        
        log("setupData: apnContext=" + apnContext);
        ApnSetting apn;
        GsmDataConnection dc;
        int profileId = getApnProfileID(apnContext.getApnType());
        apn = apnContext.getNextWaitingApn();
        if(apn == null)        
        {
            if(DBG)            
            log("setupData: return for no apn found!");
            boolean var68934A3E9455FA72420237EB05902327_828568747 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_698308047 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_698308047;
        } //End block
        dc = (GsmDataConnection)apnContext.getDataConnection();
        if(dc == null)        
        {
            dc = (GsmDataConnection) checkForConnectionForApnContext(apnContext);
            if(dc == null)            
            {
                dc = findReadyDataConnection(apn);
            } //End block
            if(dc == null)            
            {
                if(DBG)                
                log("setupData: No ready GsmDataConnection found!");
                dc = findFreeDataConnection();
            } //End block
            if(dc == null)            
            {
                dc = createDataConnection();
            } //End block
            if(dc == null)            
            {
                if(DBG)                
                log("setupData: No free GsmDataConnection found!");
                boolean var68934A3E9455FA72420237EB05902327_1441869694 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_405837022 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_405837022;
            } //End block
            DataConnectionAc dcac = mDataConnectionAsyncChannels.get(dc.getDataConnectionId());
            dc.setProfileId( profileId );
            dc.setActiveApnType(apnContext.getApnType());
            int refCount = dcac.getRefCountSync();
            if(DBG)            
            log("setupData: init dc and apnContext refCount=" + refCount);
            if(refCount == 0)            
            {
                configureRetry(dc, apn.canHandleType(Phone.APN_TYPE_DEFAULT));
            } //End block
            apnContext.setDataConnectionAc(dcac);
            apnContext.setDataConnection(dc);
        } //End block
        apnContext.setApnSetting(apn);
        apnContext.setState(State.INITING);
        mPhone.notifyDataConnection(apnContext.getReason(), apnContext.getApnType());
        if(apnContext.getDataConnectionAc().getReconnectIntentSync() != null)        
        {
            if(DBG)            
            log("setupData: data reconnection pending");
            apnContext.setState(State.FAILED);
            mPhone.notifyDataConnection(apnContext.getReason(), apnContext.getApnType());
            boolean varB326B5062B2F0E69046810717534CB09_206850046 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1020182623 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1020182623;
        } //End block
        Message msg = obtainMessage();
        msg.what = EVENT_DATA_SETUP_COMPLETE;
        msg.obj = apnContext;
        dc.bringUp(msg, apn);
        if(DBG)        
        log("setupData: initing!");
        boolean varB326B5062B2F0E69046810717534CB09_1740934509 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_918939023 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_918939023;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.722 -0400", hash_original_method = "651F557B6A8D0D165E9CDD4391DC0D13", hash_generated_method = "599592C8D5A013379EA76526A72731C8")
    private void onApnChanged() {
        State overallState = getOverallState();
        boolean isDisconnected = (overallState == State.IDLE || overallState == State.FAILED);
        if(mPhone instanceof GSMPhone)        
        {
            ((GSMPhone)mPhone).updateCurrentCarrierInProvider();
        } //End block
        if(DBG)        
        log("onApnChanged: createAllApnList and cleanUpAllConnections");
        createAllApnList();
        cleanUpAllConnections(!isDisconnected, Phone.REASON_APN_CHANGED);
        if(isDisconnected)        
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.723 -0400", hash_original_method = "65E72951AE41561D32861B862A9CCB8A", hash_generated_method = "4C40C0F0CD676573F221A7633483581D")
    private DataConnectionAc findDataConnectionAcByCid(int cid) {
        addTaint(cid);
for(DataConnectionAc dcac : mDataConnectionAsyncChannels.values())
        {
            if(dcac.getCidSync() == cid)            
            {
DataConnectionAc var54D1C39D0CE66900888CCBDBACFCE49D_445987337 =                 dcac;
                var54D1C39D0CE66900888CCBDBACFCE49D_445987337.addTaint(taint);
                return var54D1C39D0CE66900888CCBDBACFCE49D_445987337;
            } //End block
        } //End block
DataConnectionAc var540C13E9E156B687226421B24F2DF178_920833103 =         null;
        var540C13E9E156B687226421B24F2DF178_920833103.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_920833103;
        // ---------- Original Method ----------
        //for (DataConnectionAc dcac : mDataConnectionAsyncChannels.values()) {
            //if (dcac.getCidSync() == cid) {
                //return dcac;
            //}
        //}
        //return null;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.723 -0400", hash_original_method = "3E391A4D32CF36E6E02EF7EB45223170", hash_generated_method = "E33E3B7D4CD2B75AAC4E054DFC6AF12D")
    private List<ApnContext> findApnContextToClean(Collection<DataConnectionAc> dcacs) {
        addTaint(dcacs.getTaint());
        if(dcacs == null)        
        {
List<ApnContext> var540C13E9E156B687226421B24F2DF178_706347597 =         null;
        var540C13E9E156B687226421B24F2DF178_706347597.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_706347597;
        }
        ArrayList<ApnContext> list = new ArrayList<ApnContext>();
for(ApnContext apnContext : mApnContexts.values())
        {
            if(apnContext.getState() == State.CONNECTED)            
            {
                boolean found = false;
for(DataConnectionAc dcac : dcacs)
                {
                    if(dcac == apnContext.getDataConnectionAc())                    
                    {
                        found = true;
                        break;
                    } //End block
                } //End block
                if(!found)                
                {
                    if(DBG)                    
                    log("onDataStateChanged(ar): Connected apn not found in the list (" +
                                 apnContext.toString() + ")");
                    if(apnContext.getDataConnectionAc() != null)                    
                    {
                        list.addAll(apnContext.getDataConnectionAc().getApnListSync());
                    } //End block
                    else
                    {
                        list.add(apnContext);
                    } //End block
                } //End block
            } //End block
        } //End block
List<ApnContext> varED12C351C2E8CA4F85F097DDC7E77B4D_1311743148 =         list;
        varED12C351C2E8CA4F85F097DDC7E77B4D_1311743148.addTaint(taint);
        return varED12C351C2E8CA4F85F097DDC7E77B4D_1311743148;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.725 -0400", hash_original_method = "2CAD8F6019A6EE1B4B77B4750A278A68", hash_generated_method = "8D337B0D3DDAF54F59B8A44C11A20658")
    private void onDataStateChanged(AsyncResult ar) {
        addTaint(ar.getTaint());
        ArrayList<DataCallState> dataCallStates;
        if(DBG)        
        log("onDataStateChanged(ar): E");
        dataCallStates = (ArrayList<DataCallState>)(ar.result);
        if(ar.exception != null)        
        {
            if(DBG)            
            log("onDataStateChanged(ar): exception; likely radio not available, ignore");
            return;
        } //End block
        if(DBG)        
        log("onDataStateChanged(ar): DataCallState size=" + dataCallStates.size());
        HashMap<DataCallState, DataConnectionAc> dataCallStateToDcac;
        dataCallStateToDcac = new HashMap<DataCallState, DataConnectionAc>();
for(DataCallState dataCallState : dataCallStates)
        {
            DataConnectionAc dcac = findDataConnectionAcByCid(dataCallState.cid);
            if(dcac != null)            
            dataCallStateToDcac.put(dataCallState, dcac);
        } //End block
        List<ApnContext> apnsToCleanup = findApnContextToClean(dataCallStateToDcac.values());
for(DataCallState newState : dataCallStates)
        {
            DataConnectionAc dcac = dataCallStateToDcac.get(newState);
            if(dcac == null)            
            {
                loge("onDataStateChanged(ar): No associated DataConnection ignore");
                continue;
            } //End block
            Collection<ApnContext> apns = dcac.getApnListSync();
            ArrayList<ApnContext> connectedApns = new ArrayList<ApnContext>();
for(ApnContext apnContext : apns)
            {
                if(apnContext.getState() == State.CONNECTED ||
                       apnContext.getState() == State.CONNECTING ||
                       apnContext.getState() == State.INITING)                
                {
                    connectedApns.add(apnContext);
                } //End block
            } //End block
            if(connectedApns.size() == 0)            
            {
                if(DBG)                
                log("onDataStateChanged(ar): no connected apns");
            } //End block
            else
            {
                if(DBG)                
                log("onDataStateChanged(ar): Found ConnId=" + newState.cid
                        + " newState=" + newState.toString());
                if(newState.active == 0)                
                {
                    if(DBG)                    
                    {
                        log("onDataStateChanged(ar): inactive, cleanup apns=" + connectedApns);
                    } //End block
                    apnsToCleanup.addAll(connectedApns);
                } //End block
                else
                {
                    UpdateLinkPropertyResult result = dcac.updateLinkPropertiesDataCallStateSync(newState);
                    if(result.oldLp.equals(result.newLp))                    
                    {
                        if(DBG)                        
                        log("onDataStateChanged(ar): no change");
                    } //End block
                    else
                    {
                        if(result.oldLp.isIdenticalInterfaceName(result.newLp))                        
                        {
                            if(! result.oldLp.isIdenticalDnses(result.newLp) ||
                                    ! result.oldLp.isIdenticalRoutes(result.newLp) ||
                                    ! result.oldLp.isIdenticalHttpProxy(result.newLp) ||
                                    ! result.oldLp.isIdenticalAddresses(result.newLp))                            
                            {
                                CompareResult<LinkAddress> car = result.oldLp.compareAddresses(result.newLp);
                                boolean needToClean = false;
for(LinkAddress added : car.added)
                                {
for(LinkAddress removed : car.removed)
                                    {
                                        if(NetworkUtils.addressTypeMatches(removed.getAddress(),
                                                added.getAddress()))                                        
                                        {
                                            needToClean = true;
                                            break;
                                        } //End block
                                    } //End block
                                } //End block
                                if(needToClean)                                
                                {
                                    if(DBG)                                    
                                    {
                                        log("onDataStateChanged(ar): addr change, cleanup apns=" +
                                                connectedApns);
                                    } //End block
                                    apnsToCleanup.addAll(connectedApns);
                                } //End block
                                else
                                {
                                    if(DBG)                                    
                                    log("onDataStateChanged(ar): simple change");
for(ApnContext apnContext : connectedApns)
                                    {
                                        mPhone.notifyDataConnection(
                                                 Phone.REASON_LINK_PROPERTIES_CHANGED,
                                                 apnContext.getApnType());
                                    } //End block
                                } //End block
                            } //End block
                            else
                            {
                                if(DBG)                                
                                {
                                    log("onDataStateChanged(ar): no changes");
                                } //End block
                            } //End block
                        } //End block
                        else
                        {
                            if(DBG)                            
                            {
                                log("onDataStateChanged(ar): interface change, cleanup apns="
                                        + connectedApns);
                            } //End block
                            apnsToCleanup.addAll(connectedApns);
                        } //End block
                    } //End block
                } //End block
            } //End block
        } //End block
        if(apnsToCleanup.size() != 0)        
        {
            int cid = getCellLocationId();
            EventLog.writeEvent(EventLogTags.PDP_NETWORK_DROP, cid,
                                TelephonyManager.getDefault().getNetworkType());
        } //End block
for(ApnContext apnContext : apnsToCleanup)
        {
            cleanUpConnection(true, apnContext);
        } //End block
        if(DBG)        
        log("onDataStateChanged(ar): X");
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.728 -0400", hash_original_method = "66B167D0E0A206B2D44C874F7CFFABF5", hash_generated_method = "962239666915B16008D0E0C5B8056895")
    private void notifyDefaultData(ApnContext apnContext) {
        addTaint(apnContext.getTaint());
        if(DBG)        
        {
            log("notifyDefaultData: type=" + apnContext.getApnType()
                + ", reason:" + apnContext.getReason());
        } //End block
        apnContext.setState(State.CONNECTED);
        mPhone.notifyDataConnection(apnContext.getReason(), apnContext.getApnType());
        startNetStatPoll();
        startDataStallAlarm();
        apnContext.getDataConnection().resetRetryCount();
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.728 -0400", hash_original_method = "06C0A537C422D51FEBC3A4D7FED033FC", hash_generated_method = "C116D794B971757484B1407B0688B8E0")
    protected void gotoIdleAndNotifyDataConnection(String reason) {
        addTaint(reason.getTaint());
        if(DBG)        
        log("gotoIdleAndNotifyDataConnection: reason=" + reason);
        notifyDataConnection(reason);
        mActiveApn = null;
        // ---------- Original Method ----------
        //if (DBG) log("gotoIdleAndNotifyDataConnection: reason=" + reason);
        //notifyDataConnection(reason);
        //mActiveApn = null;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.729 -0400", hash_original_method = "E0A0A9601ED58F14AFBBF23896E64411", hash_generated_method = "B15AEEE94D49A3A4F6A6C846243A9553")
    private void resetPollStats() {
        mTxPkts = -1;
        mRxPkts = -1;
        mNetStatPollPeriod = POLL_NETSTAT_MILLIS;
        // ---------- Original Method ----------
        //mTxPkts = -1;
        //mRxPkts = -1;
        //mNetStatPollPeriod = POLL_NETSTAT_MILLIS;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.730 -0400", hash_original_method = "85BF013ED3EA874C77BCE8B69E224FC2", hash_generated_method = "CE016FE8E803B5DE1FA3BD1E94E9F46F")
    private void doRecovery() {
        if(getOverallState() == State.CONNECTED)        
        {
            int recoveryAction = getRecoveryAction();
switch(recoveryAction){
            case RecoveryAction.GET_DATA_CALL_LIST:
            EventLog.writeEvent(EventLogTags.DATA_STALL_RECOVERY_GET_DATA_CALL_LIST,
                        mSentSinceLastRecv);
            if(DBG)            
            log("doRecovery() get data call list");
            mPhone.mCM.getDataCallList(obtainMessage(EVENT_DATA_STATE_CHANGED));
            putRecoveryAction(RecoveryAction.CLEANUP);
            break;
            case RecoveryAction.CLEANUP:
            EventLog.writeEvent(EventLogTags.DATA_STALL_RECOVERY_CLEANUP, mSentSinceLastRecv);
            if(DBG)            
            log("doRecovery() cleanup all connections");
            cleanUpAllConnections(true, Phone.REASON_PDP_RESET);
            putRecoveryAction(RecoveryAction.REREGISTER);
            break;
            case RecoveryAction.REREGISTER:
            EventLog.writeEvent(EventLogTags.DATA_STALL_RECOVERY_REREGISTER,
                        mSentSinceLastRecv);
            if(DBG)            
            log("doRecovery() re-register");
            mPhone.getServiceStateTracker().reRegisterNetwork(null);
            putRecoveryAction(RecoveryAction.RADIO_RESTART);
            break;
            case RecoveryAction.RADIO_RESTART:
            EventLog.writeEvent(EventLogTags.DATA_STALL_RECOVERY_RADIO_RESTART,
                        mSentSinceLastRecv);
            if(DBG)            
            log("restarting radio");
            putRecoveryAction(RecoveryAction.RADIO_RESTART_WITH_PROP);
            restartRadio();
            break;
            case RecoveryAction.RADIO_RESTART_WITH_PROP:
            EventLog.writeEvent(EventLogTags.DATA_STALL_RECOVERY_RADIO_RESTART_WITH_PROP, -1);
            if(DBG)            
            log("restarting radio with gsm.radioreset to true");
            SystemProperties.set("gsm.radioreset", "true");
            try 
            {
                Thread.sleep(1000);
            } //End block
            catch (InterruptedException e)
            {
            } //End block
            restartRadio();
            putRecoveryAction(RecoveryAction.GET_DATA_CALL_LIST);
            break;
            default:
            RuntimeException varD518E7B20A028226676A410C16368B23_1914898667 = new RuntimeException("doRecovery: Invalid recoveryAction=" +
                    recoveryAction);
            varD518E7B20A028226676A410C16368B23_1914898667.addTaint(taint);
            throw varD518E7B20A028226676A410C16368B23_1914898667;
}
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.730 -0400", hash_original_method = "6E590AA3974E9F6C1EEF78A59E60FE7C", hash_generated_method = "010FE0636D382155AE57AF8D3D3519A7")
    @Override
    protected void startNetStatPoll() {
        if(getOverallState() == State.CONNECTED && mNetStatPollEnabled == false)        
        {
            if(DBG)            
            log("startNetStatPoll");
            resetPollStats();
            mNetStatPollEnabled = true;
            mPollNetStat.run();
        } //End block
        // ---------- Original Method ----------
        //if (getOverallState() == State.CONNECTED && mNetStatPollEnabled == false) {
            //if (DBG) log("startNetStatPoll");
            //resetPollStats();
            //mNetStatPollEnabled = true;
            //mPollNetStat.run();
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.730 -0400", hash_original_method = "A8EA63C8FD8E985352F3B26222CD114C", hash_generated_method = "D7CA93D025B983F0AF8C323CC6587828")
    @Override
    protected void stopNetStatPoll() {
        mNetStatPollEnabled = false;
        removeCallbacks(mPollNetStat);
        if(DBG)        
        log("stopNetStatPoll");
        // ---------- Original Method ----------
        //mNetStatPollEnabled = false;
        //removeCallbacks(mPollNetStat);
        //if (DBG) log("stopNetStatPoll");
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.730 -0400", hash_original_method = "7B64E8A50E5FAE405E2B8EDB2C4EA1BE", hash_generated_method = "C9C1CBD5BAA4F3D3FB589B30654E6A75")
    @Override
    protected void restartRadio() {
        if(DBG)        
        log("restartRadio: ************TURN OFF RADIO**************");
        cleanUpAllConnections(true, Phone.REASON_RADIO_TURNED_OFF);
        mPhone.getServiceStateTracker().powerOffRadioSafely(this);
        int reset = Integer.parseInt(SystemProperties.get("net.ppp.reset-by-timeout", "0"));
        SystemProperties.set("net.ppp.reset-by-timeout", String.valueOf(reset+1));
        // ---------- Original Method ----------
        //if (DBG) log("restartRadio: ************TURN OFF RADIO**************");
        //cleanUpAllConnections(true, Phone.REASON_RADIO_TURNED_OFF);
        //mPhone.getServiceStateTracker().powerOffRadioSafely(this);
        //int reset = Integer.parseInt(SystemProperties.get("net.ppp.reset-by-timeout", "0"));
        //SystemProperties.set("net.ppp.reset-by-timeout", String.valueOf(reset+1));
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.731 -0400", hash_original_method = "757A180615AA792B2C29A1B55C4F521C", hash_generated_method = "459BA30632063A79C451974BA18AF91B")
    private void updateDataStallInfo() {
        long sent;
        long received;
        TxRxSum preTxRxSum = new TxRxSum(mDataStallTxRxSum);
        mDataStallTxRxSum.updateTxRxSum();
        if(VDBG)        
        {
            log("updateDataStallInfo: mDataStallTxRxSum=" + mDataStallTxRxSum +
                    " preTxRxSum=" + preTxRxSum);
        } //End block
        sent = mDataStallTxRxSum.txPkts - preTxRxSum.txPkts;
        received = mDataStallTxRxSum.rxPkts - preTxRxSum.rxPkts;
        if(VDBG)        
        {
            if(SystemProperties.getBoolean("radio.test.data.stall", false))            
            {
                log("updateDataStallInfo: radio.test.data.stall true received = 0;");
                received = 0;
            } //End block
        } //End block
        if(sent > 0 && received > 0)        
        {
            if(VDBG)            
            log("updateDataStallInfo: IN/OUT");
            mSentSinceLastRecv = 0;
            putRecoveryAction(RecoveryAction.GET_DATA_CALL_LIST);
        } //End block
        else
        if(sent > 0 && received == 0)        
        {
            if(mPhone.getState() == Phone.State.IDLE)            
            {
                mSentSinceLastRecv += sent;
            } //End block
            else
            {
                mSentSinceLastRecv = 0;
            } //End block
            if(DBG)            
            {
                log("updateDataStallInfo: OUT sent=" + sent +
                        " mSentSinceLastRecv=" + mSentSinceLastRecv);
            } //End block
        } //End block
        else
        if(sent == 0 && received > 0)        
        {
            if(VDBG)            
            log("updateDataStallInfo: IN");
            mSentSinceLastRecv = 0;
            putRecoveryAction(RecoveryAction.GET_DATA_CALL_LIST);
        } //End block
        else
        {
            if(VDBG)            
            log("updateDataStallInfo: NONE");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.731 -0400", hash_original_method = "81664D2568F01996EC1331372DE6C46E", hash_generated_method = "0C919AAA37BDC8B676499B03E550F7C0")
    @Override
    protected void onDataStallAlarm(int tag) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(tag);
        if(mDataStallAlarmTag != tag)        
        {
            if(DBG)            
            {
                log("onDataStallAlarm: ignore, tag=" + tag + " expecting " + mDataStallAlarmTag);
            } //End block
            return;
        } //End block
        updateDataStallInfo();
        int hangWatchdogTrigger = Settings.Secure.getInt(mResolver,
                Settings.Secure.PDP_WATCHDOG_TRIGGER_PACKET_COUNT,
                NUMBER_SENT_PACKETS_OF_HANG);
        if(mSentSinceLastRecv >= hangWatchdogTrigger)        
        {
            if(DBG)            
            {
                log("onDataStallAlarm: tag=" + tag + " do recovery action=" + getRecoveryAction());
            } //End block
            sendMessage(obtainMessage(EVENT_DO_RECOVERY));
        } //End block
        else
        {
            if(VDBG)            
            {
                log("onDataStallAlarm: tag=" + tag + " Sent " + String.valueOf(mSentSinceLastRecv) +
                    " pkts since last received, < watchdogTrigger=" + hangWatchdogTrigger);
            } //End block
        } //End block
        startDataStallAlarm();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.732 -0400", hash_original_method = "94396473B615B857A09FF1389DF39C19", hash_generated_method = "AFB8109DF791DDC8574130F792E8355D")
    private void updateDataActivity() {
        long sent;
        long received;
        Activity newActivity;
        TxRxSum preTxRxSum = new TxRxSum(mTxPkts, mRxPkts);
        TxRxSum curTxRxSum = new TxRxSum();
        curTxRxSum.updateTxRxSum();
        mTxPkts = curTxRxSum.txPkts;
        mRxPkts = curTxRxSum.rxPkts;
        if(VDBG)        
        {
            log("updateDataActivity: curTxRxSum=" + curTxRxSum + " preTxRxSum=" + preTxRxSum);
        } //End block
        if(mNetStatPollEnabled && (preTxRxSum.txPkts > 0 || preTxRxSum.rxPkts > 0))        
        {
            sent = mTxPkts - preTxRxSum.txPkts;
            received = mRxPkts - preTxRxSum.rxPkts;
            if(VDBG)            
            log("updateDataActivity: sent=" + sent + " received=" + received);
            if(sent > 0 && received > 0)            
            {
                newActivity = Activity.DATAINANDOUT;
            } //End block
            else
            if(sent > 0 && received == 0)            
            {
                newActivity = Activity.DATAOUT;
            } //End block
            else
            if(sent == 0 && received > 0)            
            {
                newActivity = Activity.DATAIN;
            } //End block
            else
            {
                newActivity = Activity.NONE;
            } //End block
            if(mActivity != newActivity && mIsScreenOn)            
            {
                if(VDBG)                
                log("updateDataActivity: newActivity=" + newActivity);
                mActivity = newActivity;
                mPhone.notifyDataActivity();
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.732 -0400", hash_original_method = "2F0F0316C5E4D930E75010F1BAA9D392", hash_generated_method = "FB5C73A58E6D3BD038499945CF0C79A0")
    private boolean shouldPostNotification(GsmDataConnection.FailCause  cause) {
        addTaint(cause.getTaint());
        boolean var3303623702288E59E268834E260F2BC2_1143560626 = ((cause != GsmDataConnection.FailCause.UNKNOWN));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2077001031 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2077001031;
        // ---------- Original Method ----------
        //return (cause != GsmDataConnection.FailCause.UNKNOWN);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.732 -0400", hash_original_method = "62A24BB1F647222AA978F8E837B2D330", hash_generated_method = "3214FF33D428A71CB6BF74348470B674")
    private boolean retryAfterDisconnected(String reason) {
        addTaint(reason.getTaint());
        boolean retry = true;
        if(Phone.REASON_RADIO_TURNED_OFF.equals(reason))        
        {
            retry = false;
        } //End block
        boolean var165E6D21E0A2CC9EBB32CA05F90E0FA7_548076173 = (retry);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_205408141 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_205408141;
        // ---------- Original Method ----------
        //boolean retry = true;
        //if ( Phone.REASON_RADIO_TURNED_OFF.equals(reason) ) {
            //retry = false;
        //}
        //return retry;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.732 -0400", hash_original_method = "B5DAD52C5259D76162A701D0CC3F0E5D", hash_generated_method = "6F6D248B9B6C609B4F78D9EB2744A358")
    private void reconnectAfterFail(FailCause lastFailCauseCode,
                                    ApnContext apnContext, int retryOverride) {
        addTaint(retryOverride);
        addTaint(apnContext.getTaint());
        addTaint(lastFailCauseCode.getTaint());
        if(apnContext == null)        
        {
            loge("reconnectAfterFail: apnContext == null, impossible");
            return;
        } //End block
        if((apnContext.getState() == State.FAILED) &&
            (apnContext.getDataConnection() != null))        
        {
            if(!apnContext.getDataConnection().isRetryNeeded())            
            {
                if(!apnContext.getApnType().equals(Phone.APN_TYPE_DEFAULT))                
                {
                    mPhone.notifyDataConnection(Phone.REASON_APN_FAILED, apnContext.getApnType());
                    return;
                } //End block
                if(mReregisterOnReconnectFailure)                
                {
                    apnContext.getDataConnection().retryForeverUsingLastTimeout();
                } //End block
                else
                {
                    if(DBG)                    
                    log("reconnectAfterFail: activate failed, Reregistering to network");
                    mReregisterOnReconnectFailure = true;
                    mPhone.getServiceStateTracker().reRegisterNetwork(null);
                    apnContext.getDataConnection().resetRetryCount();
                    return;
                } //End block
            } //End block
            int nextReconnectDelay = retryOverride;
            if(nextReconnectDelay < 0)            
            {
                nextReconnectDelay = apnContext.getDataConnection().getRetryTimer();
                apnContext.getDataConnection().increaseRetryCount();
            } //End block
            startAlarmForReconnect(nextReconnectDelay, apnContext);
            if(!shouldPostNotification(lastFailCauseCode))            
            {
                if(DBG)                
                {
                    log("reconnectAfterFail: NOT Posting GPRS Unavailable notification "
                                + "-- likely transient error");
                } //End block
            } //End block
            else
            {
                notifyNoData(lastFailCauseCode, apnContext);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.733 -0400", hash_original_method = "68704E7FD0A79E29C0B17E36042D228F", hash_generated_method = "B0FF02F9676987296FB6684E36116819")
    private void startAlarmForReconnect(int delay, ApnContext apnContext) {
        addTaint(apnContext.getTaint());
        addTaint(delay);
        if(DBG)        
        {
            log("Schedule alarm for reconnect: activate failed. Scheduling next attempt for "
                + (delay / 1000) + "s");
        } //End block
        DataConnectionAc dcac = apnContext.getDataConnectionAc();
        if((dcac == null) || (dcac.dataConnection == null))        
        {
            loge("null dcac or dc.");
            return;
        } //End block
        AlarmManager am = (AlarmManager) mPhone.getContext().getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(INTENT_RECONNECT_ALARM + '.' +
                                   dcac.dataConnection.getDataConnectionId());
        intent.putExtra(INTENT_RECONNECT_ALARM_EXTRA_REASON, apnContext.getReason());
        intent.putExtra(INTENT_RECONNECT_ALARM_EXTRA_TYPE,
                        dcac.dataConnection.getDataConnectionId());
        PendingIntent alarmIntent = PendingIntent.getBroadcast (mPhone.getContext(), 0,
                                                                intent, 0);
        dcac.setReconnectIntentSync(alarmIntent);
        am.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                SystemClock.elapsedRealtime() + delay, alarmIntent);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.733 -0400", hash_original_method = "752A3E1271AADAA161C9D22B1F08D3F3", hash_generated_method = "5FCAFB9BE390D9C0FE2A136407D25865")
    private void startDataStallAlarm() {
        int delayInMs = Settings.Secure.getInt(mResolver,
                            Settings.Secure.DATA_STALL_ALARM_DELAY_IN_MS,
                            DATA_STALL_ALARM_DELAY_IN_MS_DEFAULT);
        mDataStallAlarmTag += 1;
        if(DBG)        
        {
            log("startDataStallAlarm: tag=" + mDataStallAlarmTag +
                    " delay=" + (delayInMs / 1000) + "s");
        } //End block
        AlarmManager am = (AlarmManager) mPhone.getContext().getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(INTENT_DATA_STALL_ALARM);
        intent.putExtra(DATA_STALL_ALARM_TAG_EXTRA, mDataStallAlarmTag);
        mDataStallAlarmIntent = PendingIntent.getBroadcast(mPhone.getContext(), 0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        am.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                SystemClock.elapsedRealtime() + delayInMs, mDataStallAlarmIntent);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.733 -0400", hash_original_method = "9BAB3B8D9CDA09D3CE76C98C24705EFE", hash_generated_method = "BFB228B8553C579BB49D94879F6ED52B")
    private void stopDataStallAlarm() {
        AlarmManager am = (AlarmManager) mPhone.getContext().getSystemService(Context.ALARM_SERVICE);
        if(DBG)        
        {
            log("stopDataStallAlarm: current tag=" + mDataStallAlarmTag +
                    " mDataStallAlarmIntent=" + mDataStallAlarmIntent);
        } //End block
        mDataStallAlarmTag += 1;
        if(mDataStallAlarmIntent != null)        
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.733 -0400", hash_original_method = "B7B20E847D290047FDFE77B8D734C484", hash_generated_method = "D2DBAD1267102255FA345B0463AE3E83")
    private void notifyNoData(GsmDataConnection.FailCause lastFailCauseCode,
                              ApnContext apnContext) {
        addTaint(apnContext.getTaint());
        addTaint(lastFailCauseCode.getTaint());
        if(DBG)        
        log( "notifyNoData: type=" + apnContext.getApnType());
        apnContext.setState(State.FAILED);
        if(lastFailCauseCode.isPermanentFail()
            && (!apnContext.getApnType().equals(Phone.APN_TYPE_DEFAULT)))        
        {
            mPhone.notifyDataConnectionFailed(apnContext.getReason(), apnContext.getApnType());
        } //End block
        // ---------- Original Method ----------
        //if (DBG) log( "notifyNoData: type=" + apnContext.getApnType());
        //apnContext.setState(State.FAILED);
        //if (lastFailCauseCode.isPermanentFail()
            //&& (!apnContext.getApnType().equals(Phone.APN_TYPE_DEFAULT))) {
            //mPhone.notifyDataConnectionFailed(apnContext.getReason(), apnContext.getApnType());
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.734 -0400", hash_original_method = "E0D6F2F660096B71ECF89DBFFFD7E4A9", hash_generated_method = "106CF87F5F82D3A67D066FCAE4049BEB")
    private void onRecordsLoaded() {
        if(DBG)        
        log("onRecordsLoaded: createAllApnList");
        createAllApnList();
        if(mPhone.mCM.getRadioState().isOn())        
        {
            if(DBG)            
            log("onRecordsLoaded: notifying data availability");
            notifyOffApnsOfAvailability(Phone.REASON_SIM_LOADED);
        } //End block
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.734 -0400", hash_original_method = "4B71314721E8EC7414109EE47221FD04", hash_generated_method = "BB0631E6E6A53EF8C99D14ACA6F0100F")
    @Override
    protected void onSetDependencyMet(String apnType, boolean met) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(met);
        addTaint(apnType.getTaint());
        if(Phone.APN_TYPE_HIPRI.equals(apnType))        
        return;
        ApnContext apnContext = mApnContexts.get(apnType);
        if(apnContext == null)        
        {
            loge("onSetDependencyMet: ApnContext not found in onSetDependencyMet(" +
                    apnType + ", " + met + ")");
            return;
        } //End block
        applyNewState(apnContext, apnContext.isEnabled(), met);
        if(Phone.APN_TYPE_DEFAULT.equals(apnType))        
        {
            apnContext = mApnContexts.get(Phone.APN_TYPE_HIPRI);
            if(apnContext != null)            
            applyNewState(apnContext, apnContext.isEnabled(), met);
        } //End block
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.734 -0400", hash_original_method = "99E85476A8EB35B364BDD45037DA3C4C", hash_generated_method = "79EC980420D135438278A8B2F1C79BBB")
    private void applyNewState(ApnContext apnContext, boolean enabled, boolean met) {
        addTaint(met);
        addTaint(enabled);
        addTaint(apnContext.getTaint());
        boolean cleanup = false;
        boolean trySetup = false;
        if(DBG)        
        {
            log("applyNewState(" + apnContext.getApnType() + ", " + enabled +
                    "(" + apnContext.isEnabled() + "), " + met + "(" +
                    apnContext.getDependencyMet() +"))");
        } //End block
        if(apnContext.isReady())        
        {
            if(enabled && met)            
            return;
            if(!enabled)            
            {
                apnContext.setReason(Phone.REASON_DATA_DISABLED);
            } //End block
            else
            {
                apnContext.setReason(Phone.REASON_DATA_DEPENDENCY_UNMET);
            } //End block
            cleanup = true;
        } //End block
        else
        {
            if(enabled && met)            
            {
                if(apnContext.isEnabled())                
                {
                    apnContext.setReason(Phone.REASON_DATA_DEPENDENCY_MET);
                } //End block
                else
                {
                    apnContext.setReason(Phone.REASON_DATA_ENABLED);
                } //End block
                if(apnContext.getState() == State.FAILED)                
                {
                    apnContext.setState(State.IDLE);
                } //End block
                trySetup = true;
            } //End block
        } //End block
        apnContext.setEnabled(enabled);
        apnContext.setDependencyMet(met);
        if(cleanup)        
        cleanUpConnection(true, apnContext);
        if(trySetup)        
        trySetupData(apnContext);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.735 -0400", hash_original_method = "CD0E8AA9DA59D5F15CB3DBA9C10480A3", hash_generated_method = "CC574663736B66F46A74D4C9B823DA89")
    private DataConnection checkForConnectionForApnContext(ApnContext apnContext) {
        addTaint(apnContext.getTaint());
        String apnType = apnContext.getApnType();
        ApnSetting dunSetting = null;
        if(Phone.APN_TYPE_DUN.equals(apnType))        
        {
            dunSetting = fetchDunApn();
        } //End block
for(ApnContext c : mApnContexts.values())
        {
            DataConnection conn = c.getDataConnection();
            if(conn != null)            
            {
                ApnSetting apnSetting = c.getApnSetting();
                if(dunSetting != null)                
                {
                    if(dunSetting.equals(apnSetting))                    
                    {
                        if(DBG)                        
                        {
                            log("checkForConnectionForApnContext: apnContext=" + apnContext +
                                    " found conn=" + conn);
                        } //End block
DataConnection varE92EA799FE726EFFA481FDDF43ADE4CF_709398705 =                         conn;
                        varE92EA799FE726EFFA481FDDF43ADE4CF_709398705.addTaint(taint);
                        return varE92EA799FE726EFFA481FDDF43ADE4CF_709398705;
                    } //End block
                } //End block
                else
                if(apnSetting != null && apnSetting.canHandleType(apnType))                
                {
                    if(DBG)                    
                    {
                        log("checkForConnectionForApnContext: apnContext=" + apnContext +
                                " found conn=" + conn);
                    } //End block
DataConnection varE92EA799FE726EFFA481FDDF43ADE4CF_452147013 =                     conn;
                    varE92EA799FE726EFFA481FDDF43ADE4CF_452147013.addTaint(taint);
                    return varE92EA799FE726EFFA481FDDF43ADE4CF_452147013;
                } //End block
            } //End block
        } //End block
        if(DBG)        
        log("checkForConnectionForApnContext: apnContext=" + apnContext + " NO conn");
DataConnection var540C13E9E156B687226421B24F2DF178_915245723 =         null;
        var540C13E9E156B687226421B24F2DF178_915245723.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_915245723;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.735 -0400", hash_original_method = "C4FAA9463FB18AA2956D630E0A7A0FC4", hash_generated_method = "C5CAC4A0CE32F77B19EA42AC996BBDBC")
    @Override
    protected void onEnableApn(int apnId, int enabled) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(enabled);
        addTaint(apnId);
        ApnContext apnContext = mApnContexts.get(apnIdToType(apnId));
        if(apnContext == null)        
        {
            loge("onEnableApn(" + apnId + ", " + enabled + "): NO ApnContext");
            return;
        } //End block
        if(DBG)        
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.735 -0400", hash_original_method = "885166865223FFC382706A95C40269FC", hash_generated_method = "BDB3D08D59BCEC23F895D208F7965C94")
    @Override
    protected boolean onTrySetupData(String reason) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(reason.getTaint());
        if(DBG)        
        log("onTrySetupData: reason=" + reason);
        setupDataOnReadyApns(reason);
        boolean varB326B5062B2F0E69046810717534CB09_2076171546 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1918386356 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1918386356;
        // ---------- Original Method ----------
        //if (DBG) log("onTrySetupData: reason=" + reason);
        //setupDataOnReadyApns(reason);
        //return true;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.735 -0400", hash_original_method = "0F081CC5E381F07585D5A8591D9B8176", hash_generated_method = "224E758F4D1DBBC8216B6F8992B72398")
    protected boolean onTrySetupData(ApnContext apnContext) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(apnContext.getTaint());
        if(DBG)        
        log("onTrySetupData: apnContext=" + apnContext);
        boolean var4B0B7DA8605CF08A23D3A47E6BE927CC_1084907625 = (trySetupData(apnContext));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_516852948 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_516852948;
        // ---------- Original Method ----------
        //if (DBG) log("onTrySetupData: apnContext=" + apnContext);
        //return trySetupData(apnContext);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.736 -0400", hash_original_method = "94279F194E7EEE60FDEB34DD3123F420", hash_generated_method = "9D5F07F226C9E3D104EC5F0744DDEF27")
    @Override
    protected void onRoamingOff() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        if(DBG)        
        log("onRoamingOff");
        if(getDataOnRoamingEnabled() == false)        
        {
            notifyOffApnsOfAvailability(Phone.REASON_ROAMING_OFF);
            setupDataOnReadyApns(Phone.REASON_ROAMING_OFF);
        } //End block
        else
        {
            notifyDataConnection(Phone.REASON_ROAMING_OFF);
        } //End block
        // ---------- Original Method ----------
        //if (DBG) log("onRoamingOff");
        //if (getDataOnRoamingEnabled() == false) {
            //notifyOffApnsOfAvailability(Phone.REASON_ROAMING_OFF);
            //setupDataOnReadyApns(Phone.REASON_ROAMING_OFF);
        //} else {
            //notifyDataConnection(Phone.REASON_ROAMING_OFF);
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.736 -0400", hash_original_method = "F695F1E8C2AB53D2ED55D91C043A1972", hash_generated_method = "B5264246AB2783E2CA48F8407E7CCAD2")
    @Override
    protected void onRoamingOn() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        if(getDataOnRoamingEnabled())        
        {
            if(DBG)            
            log("onRoamingOn: setup data on roaming");
            setupDataOnReadyApns(Phone.REASON_ROAMING_ON);
            notifyDataConnection(Phone.REASON_ROAMING_ON);
        } //End block
        else
        {
            if(DBG)            
            log("onRoamingOn: Tear down data connection on roaming.");
            cleanUpAllConnections(true, Phone.REASON_ROAMING_ON);
            notifyOffApnsOfAvailability(Phone.REASON_ROAMING_ON);
        } //End block
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.736 -0400", hash_original_method = "2023A2D13D03549C0A5EFF7393A0A72A", hash_generated_method = "C49CC14473AB35436F2C4874A44695CD")
    @Override
    protected void onRadioAvailable() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        if(DBG)        
        log("onRadioAvailable");
        if(mPhone.getSimulatedRadioControl() != null)        
        {
            notifyDataConnection(null);
            log("onRadioAvailable: We're on the simulator; assuming data is connected");
        } //End block
        if(mPhone.mIccRecords.getRecordsLoaded())        
        {
            notifyOffApnsOfAvailability(null);
        } //End block
        if(getOverallState() != State.IDLE)        
        {
            cleanUpConnection(true, null);
        } //End block
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.736 -0400", hash_original_method = "3A8D622B44F84A55C5B45212A617D18F", hash_generated_method = "932FD2A17E149DF5C70A79B675E3C95F")
    @Override
    protected void onRadioOffOrNotAvailable() {
        //DSFIXME:  CODE0009: Possible callback target function detected
for(DataConnection dc : mDataConnections.values())
        {
            dc.resetRetryCount();
        } //End block
        mReregisterOnReconnectFailure = false;
        if(mPhone.getSimulatedRadioControl() != null)        
        {
            log("We're on the simulator; assuming radio off is meaningless");
        } //End block
        else
        {
            if(DBG)            
            log("onRadioOffOrNotAvailable: is off and clean up all connections");
            cleanUpAllConnections(false, Phone.REASON_RADIO_TURNED_OFF);
        } //End block
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.738 -0400", hash_original_method = "31196134743B1AB9B97F59AB7F4DD6B0", hash_generated_method = "A8FBD35D198D9661EFFCBC8FBFFC4D47")
    @Override
    protected void onDataSetupComplete(AsyncResult ar) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(ar.getTaint());
        ApnContext apnContext = null;
        if(ar.userObj instanceof ApnContext)        
        {
            apnContext = (ApnContext)ar.userObj;
        } //End block
        else
        {
            RuntimeException varFC086E599FE2CED38283300B391774C3_1500589093 = new RuntimeException("onDataSetupComplete: No apnContext");
            varFC086E599FE2CED38283300B391774C3_1500589093.addTaint(taint);
            throw varFC086E599FE2CED38283300B391774C3_1500589093;
        } //End block
        if(isDataSetupCompleteOk(ar))        
        {
            DataConnectionAc dcac = apnContext.getDataConnectionAc();
            if(dcac == null)            
            {
                RuntimeException var936E6D06FD108BA0BFF8429AE8E5C49D_1276671917 = new RuntimeException("onDataSetupCompete: No dcac");
                var936E6D06FD108BA0BFF8429AE8E5C49D_1276671917.addTaint(taint);
                throw var936E6D06FD108BA0BFF8429AE8E5C49D_1276671917;
            } //End block
            DataConnection dc = apnContext.getDataConnection();
            if(DBG)            
            {
                String apnStr = "<unknown>";
                if(apnContext.getWaitingApns() != null
                        && !apnContext.getWaitingApns().isEmpty())                
                {
                    apnStr = apnContext.getWaitingApns().get(0).apn;
                } //End block
                log("onDataSetupComplete: success apn=" + apnStr);
            } //End block
            ApnSetting apn = apnContext.getApnSetting();
            if(apn.proxy != null && apn.proxy.length() != 0)            
            {
                try 
                {
                    String port = apn.port;
                    if(TextUtils.isEmpty(port))                    
                    port = "8080";
                    ProxyProperties proxy = new ProxyProperties(apn.proxy,
                            Integer.parseInt(port), null);
                    dcac.setLinkPropertiesHttpProxySync(proxy);
                } //End block
                catch (NumberFormatException e)
                {
                    loge("onDataSetupComplete: NumberFormatException making ProxyProperties (" +
                            apn.port + "): " + e);
                } //End block
            } //End block
            if(TextUtils.equals(apnContext.getApnType(),Phone.APN_TYPE_DEFAULT))            
            {
                SystemProperties.set("gsm.defaultpdpcontext.active", "true");
                if(canSetPreferApn && mPreferredApn == null)                
                {
                    if(DBG)                    
                    log("onDataSetupComplete: PREFERED APN is null");
                    mPreferredApn = apnContext.getApnSetting();
                    if(mPreferredApn != null)                    
                    {
                        setPreferredApn(mPreferredApn.id);
                    } //End block
                } //End block
            } //End block
            else
            {
                SystemProperties.set("gsm.defaultpdpcontext.active", "false");
            } //End block
            notifyDefaultData(apnContext);
        } //End block
        else
        {
            String apnString;
            DataConnection.FailCause cause;
            cause = (DataConnection.FailCause) (ar.result);
            if(DBG)            
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
            if(cause.isEventLoggable())            
            {
                int cid = getCellLocationId();
                EventLog.writeEvent(EventLogTags.PDP_SETUP_FAIL,
                        cause.ordinal(), cid, TelephonyManager.getDefault().getNetworkType());
            } //End block
            if(cause.isPermanentFail())            
            apnContext.decWaitingApnsPermFailCount();
            apnContext.removeNextWaitingApn();
            if(DBG)            
            {
                log(String.format("onDataSetupComplete: WaitingApns.size=%d" +
                        " WaitingApnsPermFailureCountDown=%d",
                        apnContext.getWaitingApns().size(),
                        apnContext.getWaitingApnsPermFailCount()));
            } //End block
            if(apnContext.getWaitingApns().isEmpty())            
            {
                if(apnContext.getWaitingApnsPermFailCount() == 0)                
                {
                    if(DBG)                    
                    {
                        log("onDataSetupComplete: All APN's had permanent failures, stop retrying");
                    } //End block
                    apnContext.setState(State.FAILED);
                    mPhone.notifyDataConnection(Phone.REASON_APN_FAILED, apnContext.getApnType());
                    apnContext.setDataConnection(null);
                    apnContext.setDataConnectionAc(null);
                    if(DBG)                    
                    {
                        log("onDataSetupComplete: permanent error apn=%s" + apnString );
                    } //End block
                } //End block
                else
                {
                    if(DBG)                    
                    log("onDataSetupComplete: Not all permanent failures, retry");
                    int retryOverride = -1;
                    if(ar.exception instanceof DataConnection.CallSetupException)                    
                    {
                        retryOverride =
                            ((DataConnection.CallSetupException)ar.exception).getRetryOverride();
                    } //End block
                    if(retryOverride == RILConstants.MAX_INT)                    
                    {
                        if(DBG)                        
                        log("No retry is suggested.");
                    } //End block
                    else
                    {
                        startDelayedRetry(cause, apnContext, retryOverride);
                    } //End block
                } //End block
            } //End block
            else
            {
                if(DBG)                
                log("onDataSetupComplete: Try next APN");
                apnContext.setState(State.SCANNING);
                startAlarmForReconnect(APN_DELAY_MILLIS, apnContext);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.739 -0400", hash_original_method = "D4180B029AFCA66C11673889FF654292", hash_generated_method = "B322B19A3DA392CEA1B0F471E0810C8B")
    @Override
    protected void onDisconnectDone(int connId, AsyncResult ar) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(ar.getTaint());
        addTaint(connId);
        ApnContext apnContext = null;
        if(DBG)        
        log("onDisconnectDone: EVENT_DISCONNECT_DONE connId=" + connId);
        if(ar.userObj instanceof ApnContext)        
        {
            apnContext = (ApnContext) ar.userObj;
        } //End block
        else
        {
            loge("Invalid ar in onDisconnectDone");
            return;
        } //End block
        apnContext.setState(State.IDLE);
        mPhone.notifyDataConnection(apnContext.getReason(), apnContext.getApnType());
        if(isDisconnected())        
        {
            if(mPhone.getServiceStateTracker().processPendingRadioPowerOffAfterDataOff())            
            {
                apnContext.setApnSetting(null);
                apnContext.setDataConnection(null);
                apnContext.setDataConnectionAc(null);
                return;
            } //End block
        } //End block
        if(apnContext.isReady() && retryAfterDisconnected(apnContext.getReason()))        
        {
            SystemProperties.set("gsm.defaultpdpcontext.active", "false");
            startAlarmForReconnect(APN_DELAY_MILLIS, apnContext);
        } //End block
        else
        {
            apnContext.setApnSetting(null);
            apnContext.setDataConnection(null);
            apnContext.setDataConnectionAc(null);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.739 -0400", hash_original_method = "F62EA026E4AEAA1F320C05AA5A1ED4A9", hash_generated_method = "F76C2C9C91DD3732E2E9AC8837F9040E")
    protected void onPollPdp() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        if(getOverallState() == State.CONNECTED)        
        {
            mPhone.mCM.getDataCallList(this.obtainMessage(EVENT_DATA_STATE_CHANGED));
            sendMessageDelayed(obtainMessage(EVENT_POLL_PDP), POLL_PDP_MILLIS);
        } //End block
        // ---------- Original Method ----------
        //if (getOverallState() == State.CONNECTED) {
            //mPhone.mCM.getDataCallList(this.obtainMessage(EVENT_DATA_STATE_CHANGED));
            //sendMessageDelayed(obtainMessage(EVENT_POLL_PDP), POLL_PDP_MILLIS);
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.739 -0400", hash_original_method = "7D6F87E7A2D5372F8DAAC4AE4D373312", hash_generated_method = "EB550115938A95F3BB1D1E97D6FDB5CC")
    @Override
    protected void onVoiceCallStarted() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        if(DBG)        
        log("onVoiceCallStarted");
        if(isConnected() && ! mPhone.getServiceStateTracker().isConcurrentVoiceAndDataAllowed())        
        {
            if(DBG)            
            log("onVoiceCallStarted stop polling");
            stopNetStatPoll();
            stopDataStallAlarm();
            notifyDataConnection(Phone.REASON_VOICE_CALL_STARTED);
        } //End block
        // ---------- Original Method ----------
        //if (DBG) log("onVoiceCallStarted");
        //if (isConnected() && ! mPhone.getServiceStateTracker().isConcurrentVoiceAndDataAllowed()) {
            //if (DBG) log("onVoiceCallStarted stop polling");
            //stopNetStatPoll();
            //stopDataStallAlarm();
            //notifyDataConnection(Phone.REASON_VOICE_CALL_STARTED);
        //}
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.740 -0400", hash_original_method = "F668A2FA6E26D3D907651D9C8494921A", hash_generated_method = "DA9AF2D33FABB16D9BFD1A23510A0A65")
    @Override
    protected void onVoiceCallEnded() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        if(DBG)        
        log("onVoiceCallEnded");
        if(isConnected())        
        {
            if(!mPhone.getServiceStateTracker().isConcurrentVoiceAndDataAllowed())            
            {
                startNetStatPoll();
                startDataStallAlarm();
                notifyDataConnection(Phone.REASON_VOICE_CALL_ENDED);
            } //End block
            else
            {
                resetPollStats();
            } //End block
        } //End block
        else
        {
            setupDataOnReadyApns(Phone.REASON_VOICE_CALL_ENDED);
        } //End block
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.740 -0400", hash_original_method = "2BB2576C993A3562ED602CBB829AED3C", hash_generated_method = "7C7D6FFDBD5FEFAEACC654AD315A4B25")
    @Override
    protected void onCleanUpConnection(boolean tearDown, int apnId, String reason) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(reason.getTaint());
        addTaint(apnId);
        addTaint(tearDown);
        if(DBG)        
        log("onCleanUpConnection");
        ApnContext apnContext = mApnContexts.get(apnIdToType(apnId));
        if(apnContext != null)        
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.740 -0400", hash_original_method = "F3A5D3BC82C41DBBBC23CC041FBF5A0E", hash_generated_method = "AD9049177610305C245BF2FD30C40014")
    protected boolean isConnected() {
for(ApnContext apnContext : mApnContexts.values())
        {
            if(apnContext.getState() == State.CONNECTED)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_2036719805 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_784558119 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_784558119;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_669519196 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1763153131 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1763153131;
        // ---------- Original Method ----------
        //for (ApnContext apnContext : mApnContexts.values()) {
            //if (apnContext.getState() == State.CONNECTED) {
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.740 -0400", hash_original_method = "82B1D5E02818D0100BE3FB5300291D89", hash_generated_method = "AE8BCDA27817B5F2C59C660858A96ECE")
    @Override
    public boolean isDisconnected() {
for(ApnContext apnContext : mApnContexts.values())
        {
            if(!apnContext.isDisconnected())            
            {
                boolean var68934A3E9455FA72420237EB05902327_113043664 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_865230860 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_865230860;
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1986004204 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1394034733 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1394034733;
        // ---------- Original Method ----------
        //for (ApnContext apnContext : mApnContexts.values()) {
            //if (!apnContext.isDisconnected()) {
                //return false;
            //}
        //}
        //return true;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.740 -0400", hash_original_method = "85B9B626BCFF754F4C98AF3615661037", hash_generated_method = "BCF1938E5D8E79FBA143AE55F8F3C449")
    @Override
    protected void notifyDataConnection(String reason) {
        addTaint(reason.getTaint());
        if(DBG)        
        log("notifyDataConnection: reason=" + reason);
for(ApnContext apnContext : mApnContexts.values())
        {
            if(apnContext.isReady())            
            {
                if(DBG)                
                log("notifyDataConnection: type:"+apnContext.getApnType());
                mPhone.notifyDataConnection(reason != null ? reason : apnContext.getReason(),
                        apnContext.getApnType());
            } //End block
        } //End block
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.741 -0400", hash_original_method = "FAE53DB9273E730E3BB3527C1EA0C82D", hash_generated_method = "462B135CDB90AF8F6514D7958C8A409E")
    private void createAllApnList() {
        mAllApns = new ArrayList<ApnSetting>();
        String operator = mPhone.mIccRecords.getOperatorNumeric();
        if(operator != null)        
        {
            String selection = "numeric = '" + operator + "'";
            selection += " and carrier_enabled = 1";
            if(DBG)            
            log("createAllApnList: selection=" + selection);
            Cursor cursor = mPhone.getContext().getContentResolver().query(
                    Telephony.Carriers.CONTENT_URI, null, selection, null, null);
            if(cursor != null)            
            {
                if(cursor.getCount() > 0)                
                {
                    mAllApns = createApnList(cursor);
                } //End block
                cursor.close();
            } //End block
        } //End block
        if(mAllApns.isEmpty())        
        {
            if(DBG)            
            log("createAllApnList: No APN found for carrier: " + operator);
            mPreferredApn = null;
        } //End block
        else
        {
            mPreferredApn = getPreferredApn();
            if(mPreferredApn != null && !mPreferredApn.numeric.equals(operator))            
            {
                mPreferredApn = null;
                setPreferredApn(-1);
            } //End block
            if(DBG)            
            log("createAllApnList: mPreferredApn=" + mPreferredApn);
        } //End block
        if(DBG)        
        log("createAllApnList: X mAllApns=" + mAllApns);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.741 -0400", hash_original_method = "5EA4CC699810E4F50A6EFC012301B7BB", hash_generated_method = "28F720EE85F8E87BDE04B08A47368CBD")
    private GsmDataConnection createDataConnection() {
        if(DBG)        
        log("createDataConnection E");
        RetryManager rm = new RetryManager();
        int id = mUniqueIdGenerator.getAndIncrement();
        GsmDataConnection conn = GsmDataConnection.makeDataConnection(mPhone, id, rm);
        mDataConnections.put(id, conn);
        DataConnectionAc dcac = new DataConnectionAc(conn, LOG_TAG);
        int status = dcac.fullyConnectSync(mPhone.getContext(), this, conn.getHandler());
        if(status == AsyncChannel.STATUS_SUCCESSFUL)        
        {
            mDataConnectionAsyncChannels.put(dcac.dataConnection.getDataConnectionId(), dcac);
        } //End block
        else
        {
            loge("createDataConnection: Could not connect to dcac.mDc=" + dcac.dataConnection +
                    " status=" + status);
        } //End block
        IntentFilter filter = new IntentFilter();
        filter.addAction(INTENT_RECONNECT_ALARM + '.' + id);
        mPhone.getContext().registerReceiver(mIntentReceiver, filter, null, mPhone);
        if(DBG)        
        log("createDataConnection() X id=" + id);
GsmDataConnection varE92EA799FE726EFFA481FDDF43ADE4CF_1105468179 =         conn;
        varE92EA799FE726EFFA481FDDF43ADE4CF_1105468179.addTaint(taint);
        return varE92EA799FE726EFFA481FDDF43ADE4CF_1105468179;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.741 -0400", hash_original_method = "E3018B8151F871DAB6348A26AB9C8E22", hash_generated_method = "05B7A71E4725DA1EEA4BFAFFBAD252A5")
    private void configureRetry(DataConnection dc, boolean forDefault) {
        addTaint(forDefault);
        addTaint(dc.getTaint());
        if(dc == null)        
        return;
        if(!dc.configureRetry(getReryConfig(forDefault)))        
        {
            if(forDefault)            
            {
                if(!dc.configureRetry(DEFAULT_DATA_RETRY_CONFIG))                
                {
                    loge("configureRetry: Could not configure using " +
                            "DEFAULT_DATA_RETRY_CONFIG=" + DEFAULT_DATA_RETRY_CONFIG);
                    dc.configureRetry(20, 2000, 1000);
                } //End block
            } //End block
            else
            {
                if(!dc.configureRetry(SECONDARY_DATA_RETRY_CONFIG))                
                {
                    loge("configureRetry: Could note configure using " +
                            "SECONDARY_DATA_RETRY_CONFIG=" + SECONDARY_DATA_RETRY_CONFIG);
                    dc.configureRetry("max_retries=3, 333, 333, 333");
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.741 -0400", hash_original_method = "3AA2B8847F1D4D39DED653A1D9ABBA74", hash_generated_method = "51D74C1D9AA9264E887748B87160A222")
    private void destroyDataConnections() {
        if(mDataConnections != null)        
        {
            if(DBG)            
            log("destroyDataConnections: clear mDataConnectionList");
            mDataConnections.clear();
        } //End block
        else
        {
            if(DBG)            
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.742 -0400", hash_original_method = "848BE9CB29607B1E2AFE44721BE481D7", hash_generated_method = "AD2F2DF8DBFDD8AB3592ABA5710A0F1B")
    private ArrayList<ApnSetting> buildWaitingApns(String requestedApnType) {
        addTaint(requestedApnType.getTaint());
        ArrayList<ApnSetting> apnList = new ArrayList<ApnSetting>();
        if(requestedApnType.equals(Phone.APN_TYPE_DUN))        
        {
            ApnSetting dun = fetchDunApn();
            if(dun != null)            
            {
                apnList.add(dun);
                if(DBG)                
                log("buildWaitingApns: X added APN_TYPE_DUN apnList=" + apnList);
ArrayList<ApnSetting> var96869C0A4A98E2663B7AE018A1369DF2_1229574248 =                 apnList;
                var96869C0A4A98E2663B7AE018A1369DF2_1229574248.addTaint(taint);
                return var96869C0A4A98E2663B7AE018A1369DF2_1229574248;
            } //End block
        } //End block
        String operator = mPhone.mIccRecords.getOperatorNumeric();
        int radioTech = mPhone.getServiceState().getRadioTechnology();
        if(requestedApnType.equals(Phone.APN_TYPE_DEFAULT))        
        {
            if(canSetPreferApn && mPreferredApn != null)            
            {
                if(DBG)                
                {
                    log("buildWaitingApns: Preferred APN:" + operator + ":"
                        + mPreferredApn.numeric + ":" + mPreferredApn);
                } //End block
                if(mPreferredApn.numeric.equals(operator))                
                {
                    if(mPreferredApn.bearer == 0 || mPreferredApn.bearer == radioTech)                    
                    {
                        apnList.add(mPreferredApn);
                        if(DBG)                        
                        log("buildWaitingApns: X added preferred apnList=" + apnList);
ArrayList<ApnSetting> var96869C0A4A98E2663B7AE018A1369DF2_1361062715 =                         apnList;
                        var96869C0A4A98E2663B7AE018A1369DF2_1361062715.addTaint(taint);
                        return var96869C0A4A98E2663B7AE018A1369DF2_1361062715;
                    } //End block
                    else
                    {
                        if(DBG)                        
                        log("buildWaitingApns: no preferred APN");
                        setPreferredApn(-1);
                        mPreferredApn = null;
                    } //End block
                } //End block
                else
                {
                    if(DBG)                    
                    log("buildWaitingApns: no preferred APN");
                    setPreferredApn(-1);
                    mPreferredApn = null;
                } //End block
            } //End block
        } //End block
        if(mAllApns != null)        
        {
for(ApnSetting apn : mAllApns)
            {
                if(apn.canHandleType(requestedApnType))                
                {
                    if(apn.bearer == 0 || apn.bearer == radioTech)                    
                    {
                        if(DBG)                        
                        log("apn info : " +apn.toString());
                        apnList.add(apn);
                    } //End block
                } //End block
            } //End block
        } //End block
        else
        {
            loge("mAllApns is empty!");
        } //End block
        if(DBG)        
        log("buildWaitingApns: X apnList=" + apnList);
ArrayList<ApnSetting> var96869C0A4A98E2663B7AE018A1369DF2_960109105 =         apnList;
        var96869C0A4A98E2663B7AE018A1369DF2_960109105.addTaint(taint);
        return var96869C0A4A98E2663B7AE018A1369DF2_960109105;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.742 -0400", hash_original_method = "E41D316825399ADA7868FFC16CE8AB28", hash_generated_method = "B804E5691CDC97AC30206520787B7420")
    private String apnListToString(ArrayList<ApnSetting> apns) {
        addTaint(apns.getTaint());
        StringBuilder result = new StringBuilder();
for(int i = 0, size = apns.size();i < size;i++)
        {
            result.append('[')
                  .append(apns.get(i).toString())
                  .append(']');
        } //End block
String varE65B3A02759122992CB82C0E651AD408_112435128 =         result.toString();
        varE65B3A02759122992CB82C0E651AD408_112435128.addTaint(taint);
        return varE65B3A02759122992CB82C0E651AD408_112435128;
        // ---------- Original Method ----------
        //StringBuilder result = new StringBuilder();
        //for (int i = 0, size = apns.size(); i < size; i++) {
            //result.append('[')
                  //.append(apns.get(i).toString())
                  //.append(']');
        //}
        //return result.toString();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.742 -0400", hash_original_method = "3866195B872E529451BB06B2525880D5", hash_generated_method = "6EA2D6C203F1AADDD825685665726055")
    private void startDelayedRetry(GsmDataConnection.FailCause cause,
                                   ApnContext apnContext, int retryOverride) {
        addTaint(retryOverride);
        addTaint(apnContext.getTaint());
        addTaint(cause.getTaint());
        notifyNoData(cause, apnContext);
        reconnectAfterFail(cause, apnContext, retryOverride);
        // ---------- Original Method ----------
        //notifyNoData(cause, apnContext);
        //reconnectAfterFail(cause, apnContext, retryOverride);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.743 -0400", hash_original_method = "A60F121DAB80740EFF8A86C7BC5BA500", hash_generated_method = "E99F7542C07DC52105E6E69CE27355B1")
    private void setPreferredApn(int pos) {
        addTaint(pos);
        if(!canSetPreferApn)        
        {
            return;
        } //End block
        ContentResolver resolver = mPhone.getContext().getContentResolver();
        resolver.delete(PREFERAPN_URI, null, null);
        if(pos >= 0)        
        {
            ContentValues values = new ContentValues();
            values.put(APN_ID, pos);
            resolver.insert(PREFERAPN_URI, values);
        } //End block
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.743 -0400", hash_original_method = "C73C211081CDB852B85A3162F1169F83", hash_generated_method = "941FD96AD6938BA35085A0D4BA668752")
    private ApnSetting getPreferredApn() {
        if(mAllApns.isEmpty())        
        {
ApnSetting var540C13E9E156B687226421B24F2DF178_645861277 =             null;
            var540C13E9E156B687226421B24F2DF178_645861277.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_645861277;
        } //End block
        Cursor cursor = mPhone.getContext().getContentResolver().query(
                PREFERAPN_URI, new String[] { "_id", "name", "apn" },
                null, null, Telephony.Carriers.DEFAULT_SORT_ORDER);
        if(cursor != null)        
        {
            canSetPreferApn = true;
        } //End block
        else
        {
            canSetPreferApn = false;
        } //End block
        if(canSetPreferApn && cursor.getCount() > 0)        
        {
            int pos;
            cursor.moveToFirst();
            pos = cursor.getInt(cursor.getColumnIndexOrThrow(Telephony.Carriers._ID));
for(ApnSetting p : mAllApns)
            {
                if(p.id == pos && p.canHandleType(mRequestedApnType))                
                {
                    cursor.close();
ApnSetting var74E4690D9F2A026504928C017944E149_1537949915 =                     p;
                    var74E4690D9F2A026504928C017944E149_1537949915.addTaint(taint);
                    return var74E4690D9F2A026504928C017944E149_1537949915;
                } //End block
            } //End block
        } //End block
        if(cursor != null)        
        {
            cursor.close();
        } //End block
ApnSetting var540C13E9E156B687226421B24F2DF178_2091246715 =         null;
        var540C13E9E156B687226421B24F2DF178_2091246715.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_2091246715;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.743 -0400", hash_original_method = "AE6FD47652B0A19C805CE62DFEA0E86E", hash_generated_method = "D8716E53F858CD1DFB35269829764780")
    @Override
    public void handleMessage(Message msg) {
        addTaint(msg.getTaint());
        if(DBG)        
        log("handleMessage msg=" + msg);
        if(!mPhone.mIsTheCurrentActivePhone || mIsDisposed)        
        {
            loge("handleMessage: Ignore GSM msgs since GSM phone is inactive");
            return;
        } //End block
switch(msg.what){
        case EVENT_RECORDS_LOADED:
        onRecordsLoaded();
        break;
        case EVENT_DATA_CONNECTION_DETACHED:
        onDataConnectionDetached();
        break;
        case EVENT_DATA_CONNECTION_ATTACHED:
        onDataConnectionAttached();
        break;
        case EVENT_DATA_STATE_CHANGED:
        onDataStateChanged((AsyncResult) msg.obj);
        break;
        case EVENT_POLL_PDP:
        onPollPdp();
        break;
        case EVENT_DO_RECOVERY:
        doRecovery();
        break;
        case EVENT_APN_CHANGED:
        onApnChanged();
        break;
        case EVENT_PS_RESTRICT_ENABLED:
        if(DBG)        
        log("EVENT_PS_RESTRICT_ENABLED " + mIsPsRestricted);
        stopNetStatPoll();
        stopDataStallAlarm();
        mIsPsRestricted = true;
        break;
        case EVENT_PS_RESTRICT_DISABLED:
        if(DBG)        
        log("EVENT_PS_RESTRICT_DISABLED " + mIsPsRestricted);
        mIsPsRestricted  = false;
        if(isConnected())        
        {
            startNetStatPoll();
            startDataStallAlarm();
        } //End block
        else
        {
            if(mState == State.FAILED)            
            {
                cleanUpAllConnections(false, Phone.REASON_PS_RESTRICT_ENABLED);
                resetAllRetryCounts();
                mReregisterOnReconnectFailure = false;
            } //End block
            trySetupData(Phone.REASON_PS_RESTRICT_ENABLED, Phone.APN_TYPE_DEFAULT);
        } //End block
        break;
        case EVENT_TRY_SETUP_DATA:
        if(msg.obj instanceof ApnContext)        
        {
            onTrySetupData((ApnContext)msg.obj);
        } //End block
        else
        if(msg.obj instanceof String)        
        {
            onTrySetupData((String)msg.obj);
        } //End block
        else
        {
            loge("EVENT_TRY_SETUP request w/o apnContext or String");
        } //End block
        break;
        case EVENT_CLEAN_UP_CONNECTION:
        boolean tearDown = (msg.arg1 == 0) ? false : true;
        if(DBG)        
        log("EVENT_CLEAN_UP_CONNECTION tearDown=" + tearDown);
        if(msg.obj instanceof ApnContext)        
        {
            cleanUpConnection(tearDown, (ApnContext)msg.obj);
        } //End block
        else
        {
            loge("EVENT_CLEAN_UP_CONNECTION request w/o apn context");
        } //End block
        break;
        default:
        super.handleMessage(msg);
        break;
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.744 -0400", hash_original_method = "46AFDD0964E9004EF08AD58B2795A021", hash_generated_method = "68750A9E24C1A789520704EF76941572")
    protected int getApnProfileID(String apnType) {
        addTaint(apnType.getTaint());
        if(TextUtils.equals(apnType, Phone.APN_TYPE_IMS))        
        {
            int var07819C9E78907294937E0030DAFA7674_1524294389 = (RILConstants.DATA_PROFILE_IMS);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_519109574 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_519109574;
        } //End block
        else
        if(TextUtils.equals(apnType, Phone.APN_TYPE_FOTA))        
        {
            int varB74444F133973834A73711B7A0AD0A6E_2067047301 = (RILConstants.DATA_PROFILE_FOTA);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1484701003 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1484701003;
        } //End block
        else
        if(TextUtils.equals(apnType, Phone.APN_TYPE_CBS))        
        {
            int var45C2C3686AC836E3F37508B1F876BE45_192689279 = (RILConstants.DATA_PROFILE_CBS);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1011913335 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1011913335;
        } //End block
        else
        {
            int var47B281536EB0D9F4142009739C659BC8_654350557 = (RILConstants.DATA_PROFILE_DEFAULT);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_964369115 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_964369115;
        } //End block
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.745 -0400", hash_original_method = "EC98DB8AAEBCEBF774D7D372A9BC5BED", hash_generated_method = "0DF2195CE7E22C3C1A7DD2D03814877B")
    private int getCellLocationId() {
        int cid = -1;
        CellLocation loc = mPhone.getCellLocation();
        if(loc != null)        
        {
            if(loc instanceof GsmCellLocation)            
            {
                cid = ((GsmCellLocation)loc).getCid();
            } //End block
            else
            if(loc instanceof CdmaCellLocation)            
            {
                cid = ((CdmaCellLocation)loc).getBaseStationId();
            } //End block
        } //End block
        int var4B7CC5694DD3A265BAC326EABA31266E_903184776 = (cid);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1406025081 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1406025081;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.745 -0400", hash_original_method = "74A1E45944BDF6EB75FE1BB75B450C28", hash_generated_method = "45E2D47826A0A2B2C80FFB8CA4A323DB")
    @Override
    protected void log(String s) {
        addTaint(s.getTaint());
        Log.d(LOG_TAG, "[GsmDCT] "+ s);
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[GsmDCT] "+ s);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.747 -0400", hash_original_method = "F4E978940BCE74A01AFD260967E7D0F1", hash_generated_method = "4161D7256990615E95C2D94DA5F096C5")
    @Override
    protected void loge(String s) {
        addTaint(s.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[GsmDCT] " + s);
    }

    
    private class ApnChangeObserver extends ContentObserver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.747 -0400", hash_original_method = "6B7B68FCD4064976D9DFC8282278DEB2", hash_generated_method = "B25D6445CFCAAC6EBB935C2E1EA4D894")
        public  ApnChangeObserver() {
            super(mDataConnectionTracker);
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.747 -0400", hash_original_method = "C002DCEBDDA1BCF98FA65E6C3DFBEDC7", hash_generated_method = "40A9A6E843A4E7FC3F3A0C67AFDC74A6")
        @Override
        public void onChange(boolean selfChange) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(selfChange);
            sendMessage(obtainMessage(EVENT_APN_CHANGED));
            // ---------- Original Method ----------
            //sendMessage(obtainMessage(EVENT_APN_CHANGED));
        }

        
    }


    
    class RecoveryAction {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.747 -0400", hash_original_method = "32173E3A0316410E8650FB75524992A2", hash_generated_method = "32173E3A0316410E8650FB75524992A2")
        public RecoveryAction ()
        {
            //Synthesized constructor
        }


        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.747 -0400", hash_original_field = "AC1EA81D2E3E1333FCD96E718694DE5D", hash_generated_field = "9444F7385ED075FD957CBF2705B431F2")

        public static final int GET_DATA_CALL_LIST      = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.747 -0400", hash_original_field = "77820D853702E26D80B8C5CEA6391818", hash_generated_field = "C5F9F5C8FD7BE9C11274D2A4D79064AC")

        public static final int CLEANUP                 = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.747 -0400", hash_original_field = "690E9D42D7A38621C7BC9124DC929AB4", hash_generated_field = "78C8CA1646CB6F57C71EDA35CC71F4A7")

        public static final int REREGISTER              = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.747 -0400", hash_original_field = "C1DF1F0D781602F33B43E37AA0307536", hash_generated_field = "B5EDD1906682D24DD1AADF7FCCE7CBB3")

        public static final int RADIO_RESTART           = 3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.747 -0400", hash_original_field = "8D896D16951798ED3179A1A1D27840B1", hash_generated_field = "F6B83BCA43B3D6989BC81E37B804B55C")

        public static final int RADIO_RESTART_WITH_PROP = 4;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.747 -0400", hash_original_field = "D4A6B3BD4E6EDE29866B8BB1C029F206", hash_generated_field = "C9FB38F627C73B34915C008C4B97786E")

    private static final int POLL_PDP_MILLIS = 5 * 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.747 -0400", hash_original_field = "59E7B103A5A98DA445972D780805A6D8", hash_generated_field = "3F0DFEA36BDA364CA4A128DD5BBDCB82")

    private static final String INTENT_RECONNECT_ALARM = "com.android.internal.telephony.gprs-reconnect";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.747 -0400", hash_original_field = "7ABDEEA49CD4421170D8FEE10D4A15DF", hash_generated_field = "091C02C0CEE6186F56DC0EBFBD34017F")

    private static final String INTENT_RECONNECT_ALARM_EXTRA_TYPE = "type";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.747 -0400", hash_original_field = "F2578B81B366A9F860AC7401704D9A14", hash_generated_field = "9461591A366A8FD20ABDFA87B9E748FC")

    private static final String INTENT_DATA_STALL_ALARM = "com.android.internal.telephony.gprs-data-stall";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.747 -0400", hash_original_field = "C3EC4B88B73C081C68A3ED1B75DA3E0C", hash_generated_field = "A2FF73A6831E557DF156E50F2528DB14")

    static final Uri PREFERAPN_URI = Uri.parse("content://telephony/carriers/preferapn");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.747 -0400", hash_original_field = "4F133E66E8DCA457A37645FE662A9FD3", hash_generated_field = "96F341EB2887175B3841B4870CDD9608")

    static final String APN_ID = "apn_id";
}

