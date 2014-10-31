package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.285 -0500", hash_original_field = "A19A6252FB6285D713AF780D4C1E10E4", hash_generated_field = "C9FB38F627C73B34915C008C4B97786E")

    private static final int POLL_PDP_MILLIS = 5 * 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.287 -0500", hash_original_field = "564366ED892BF26BAF29BD0D4D77E73A", hash_generated_field = "3F0DFEA36BDA364CA4A128DD5BBDCB82")

    private static final String INTENT_RECONNECT_ALARM =
        "com.android.internal.telephony.gprs-reconnect";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.290 -0500", hash_original_field = "446C89EA69BC4B81FAD21D831F8553C1", hash_generated_field = "091C02C0CEE6186F56DC0EBFBD34017F")

    private static final String INTENT_RECONNECT_ALARM_EXTRA_TYPE = "type";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.293 -0500", hash_original_field = "4B5AB618D260F6FB4C64F9599D4B5623", hash_generated_field = "9461591A366A8FD20ABDFA87B9E748FC")

    private static final String INTENT_DATA_STALL_ALARM =
        "com.android.internal.telephony.gprs-data-stall";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.296 -0500", hash_original_field = "FAD2EA7566683D5D0F4ECD787EB58565", hash_generated_field = "A2FF73A6831E557DF156E50F2528DB14")

    static final Uri PREFERAPN_URI = Uri.parse("content://telephony/carriers/preferapn");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.298 -0500", hash_original_field = "80A2D95FF1E87DFA60FFC76882696171", hash_generated_field = "96F341EB2887175B3841B4870CDD9608")

    static final String APN_ID = "apn_id";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.239 -0500", hash_original_field = "28DECCA9F494133CD6F61BCA99A50ECA", hash_generated_field = "7EC1F2F34382E79A9367C16E4BB8DCA3")

    protected final String LOG_TAG = "GSM";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.255 -0500", hash_original_field = "9597C9D00B31606CED18BB02EFDCCE27", hash_generated_field = "AFBF9D057D14B66BDF7B1FCB26AAA726")

    private boolean mReregisterOnReconnectFailure = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.258 -0500", hash_original_field = "D9EFC53032006A099035E3EBF749F453", hash_generated_field = "2ABF989C5B8F051BCBEE638ED1EA2586")

    private ContentResolver mResolver;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.300 -0500", hash_original_field = "681560C486C3A932FC067ED1878A3E14", hash_generated_field = "9743D11ECCACBF447559588D9C3455D1")

    private boolean canSetPreferApn = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.306 -0500", hash_original_field = "075613DD05C767F659F4C4F3125F931B", hash_generated_field = "7AE0CA44A8148D1733CD8642E6D8D32F")

    private ApnChangeObserver mApnObserver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.843 -0400", hash_original_field = "DCC8D3A9D9C8D2BC581A6F46B0C096D3", hash_generated_field = "DDDFB867C728C3E0E4EFF5278B63FB83")

    private Runnable mPollNetStat = new Runnable() {
        
        @DSSafe(DSCat.SAFE_LIST)
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

    //***** Constructor

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.309 -0500", hash_original_method = "11FDC14BF2164142AF8732E525079D07", hash_generated_method = "3D750F1598709C0BBBA1CE470C1F2E93")
    
public GsmDataConnectionTracker(PhoneBase p) {
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

        // install reconnect intent filter for this data connection.
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
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.280 -0500", hash_original_method = "3545EE6BB84B537BCF88623776AFA30D", hash_generated_method = "56DBF0FA30C3A6DABD0C313CA5D63FDC")
    
public int getRecoveryAction() {
        int action = Settings.System.getInt(mPhone.getContext().getContentResolver(),
                "radio.data.stall.recovery.action", RecoveryAction.GET_DATA_CALL_LIST);
        if (VDBG) log("getRecoveryAction: " + action);
        return action;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.282 -0500", hash_original_method = "D18EC99E3BCC3D9A76595B0D702BEA57", hash_generated_method = "437E47804714BA45BD10E54B8E34F53F")
    
public void putRecoveryAction(int action) {
        Settings.System.putInt(mPhone.getContext().getContentResolver(),
                "radio.data.stall.recovery.action", action);
        if (VDBG) log("putRecoveryAction: " + action);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.303 -0500", hash_original_method = "DABEDBF19FEC4514BE5AAA6475C962EB", hash_generated_method = "F0A842FA6C0B66DF70A6F47555659D82")
    
@Override
    protected void onActionIntentReconnectAlarm(Intent intent) {
        if (DBG) log("GPRS reconnect alarm. Previous state was " + mState);

        String reason = intent.getStringExtra(INTENT_RECONNECT_ALARM_EXTRA_REASON);
        int connectionId = intent.getIntExtra(INTENT_RECONNECT_ALARM_EXTRA_TYPE, -1);

        DataConnectionAc dcac= mDataConnectionAsyncChannels.get(connectionId);

        if (dcac != null) {
            for (ApnContext apnContext : dcac.getApnListSync()) {
                apnContext.setReason(reason);
                if (apnContext.getState() == State.FAILED) {
                    apnContext.setState(State.IDLE);
                }
                sendMessage(obtainMessage(EVENT_TRY_SETUP_DATA, apnContext));
            }
            // Alram had expired. Clear pending intent recorded on the DataConnection.
            dcac.setReconnectIntentSync(null);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.312 -0500", hash_original_method = "4494E5E1AF62FA72ED21CBDD59685023", hash_generated_method = "98567E3A4287D17F578BB19CABC7B3C3")
    
@Override
    public void dispose() {
        cleanUpAllConnections(false, null);

        super.dispose();

        //Unregister for all events
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
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.315 -0500", hash_original_method = "7B2466E598494011616B7E0248698FD2", hash_generated_method = "4BBC16735590D1FD5B010005513A2A4F")
    
@Override
    public boolean isApnTypeActive(String type) {
        ApnContext apnContext = mApnContexts.get(type);
        if (apnContext == null) return false;

        return (apnContext.getDataConnection() != null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.318 -0500", hash_original_method = "63B54477A01480F02B741F41FE0D8DBF", hash_generated_method = "F0914C365E40A60F18869FED7EEF23CB")
    
@Override
    protected boolean isDataPossible(String apnType) {
        ApnContext apnContext = mApnContexts.get(apnType);
        if (apnContext == null) {
            return false;
        }
        boolean apnContextIsEnabled = apnContext.isEnabled();
        State apnContextState = apnContext.getState();
        boolean apnTypePossible = !(apnContextIsEnabled &&
                (apnContextState == State.FAILED));
        boolean dataAllowed = isDataAllowed();
        boolean possible = dataAllowed && apnTypePossible;

        if (DBG) {
            log(String.format("isDataPossible(%s): possible=%b isDataAllowed=%b " +
                    "apnTypePossible=%b apnContextisEnabled=%b apnContextState()=%s",
                    apnType, possible, dataAllowed, apnTypePossible,
                    apnContextIsEnabled, apnContextState));
        }
        return possible;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.320 -0500", hash_original_method = "6FB50CEA8307C4B6093E637FBC3F2923", hash_generated_method = "6833A2ECD72E43D23E79C9C60B3F654A")
    
@Override
    protected void finalize() {
        if(DBG) log("finalize");
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.323 -0500", hash_original_method = "477FAE9A0F7056536F0C43A4344C1E00", hash_generated_method = "58DC5E0B547B76E3202A7DA74D639207")
    
@Override
    protected String getActionIntentReconnectAlarm() {
        return INTENT_RECONNECT_ALARM;
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.326 -0500", hash_original_method = "BBE23E9137760572C0B9E85F7DE2F87D", hash_generated_method = "CFB7B25A01C80653B18E3F8820B6F01C")
    
@Override
    protected String getActionIntentDataStallAlarm() {
        return INTENT_DATA_STALL_ALARM;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.329 -0500", hash_original_method = "0E3E3502B5D9BF75D72D228425E0F7B7", hash_generated_method = "9617E78808A203DD57F55FA668C1F0EB")
    
private ApnContext addApnContext(String type) {
        ApnContext apnContext = new ApnContext(type, LOG_TAG);
        apnContext.setDependencyMet(false);
        mApnContexts.put(type, apnContext);
        return apnContext;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.332 -0500", hash_original_method = "8959993CE2EB92BA5CEF3E2E51BAABDD", hash_generated_method = "8A6EFCA6999B14DF6B0F65D870E4CBA9")
    
protected void initApnContextsAndDataConnection() {
        boolean defaultEnabled = SystemProperties.getBoolean(DEFALUT_DATA_ON_BOOT_PROP, true);
        // Load device network attributes from resources
        String[] networkConfigStrings = mPhone.getContext().getResources().getStringArray(
                com.android.internal.R.array.networkAttributes);
        for (String networkConfigString : networkConfigStrings) {
            NetworkConfig networkConfig = new NetworkConfig(networkConfigString);
            ApnContext apnContext = null;

            switch (networkConfig.type) {
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
                if (defaultContext != null) {
                    applyNewState(apnContext, apnContext.isEnabled(),
                            defaultContext.getDependencyMet());
                } else {
                    // the default will set the hipri dep-met when it is created
                }
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
                // skip unknown types
                continue;
            }
            if (apnContext != null) {
                // set the prop, but also apply the newly set enabled and dependency values
                onSetDependencyMet(apnContext.getApnType(), networkConfig.dependencyMet);
            }
        }
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.335 -0500", hash_original_method = "C5F45AE4298273442B50BBFD614E8417", hash_generated_method = "CDDDCFCAC18F106C1CD8E224690E2CAA")
    
@Override
    protected LinkProperties getLinkProperties(String apnType) {
        ApnContext apnContext = mApnContexts.get(apnType);
        if (apnContext != null) {
            DataConnectionAc dcac = apnContext.getDataConnectionAc();
            if (dcac != null) {
                if (DBG) log("return link properites for " + apnType);
                return dcac.getLinkPropertiesSync();
            }
        }
        if (DBG) log("return new LinkProperties");
        return new LinkProperties();
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.338 -0500", hash_original_method = "94651B427B7F42F00ED4B45503EF287D", hash_generated_method = "2662BFFB264F3686489C711DBA1D6988")
    
@Override
    protected LinkCapabilities getLinkCapabilities(String apnType) {
        ApnContext apnContext = mApnContexts.get(apnType);
        if (apnContext!=null) {
            DataConnectionAc dataConnectionAc = apnContext.getDataConnectionAc();
            if (dataConnectionAc != null) {
                if (DBG) log("get active pdp is not null, return link Capabilities for " + apnType);
                return dataConnectionAc.getLinkCapabilitiesSync();
            }
        }
        if (DBG) log("return new LinkCapabilities");
        return new LinkCapabilities();
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.341 -0500", hash_original_method = "BFF203ED461E9185DBA7A58AF111F0F3", hash_generated_method = "F8DDC8A9E3D31A5200BCC078890D3309")
    
@Override
    // Return all active apn types
    public String[] getActiveApnTypes() {
        if (DBG) log("get all active apn types");
        ArrayList<String> result = new ArrayList<String>();

        for (ApnContext apnContext : mApnContexts.values()) {
            if (apnContext.isReady()) {
                result.add(apnContext.getApnType());
            }
        }

        return (String[])result.toArray(new String[0]);
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.344 -0500", hash_original_method = "8D1CDDA6C04920E256FCAAE007846C5E", hash_generated_method = "6DA70545AF43A8FDE04454996FA47281")
    
@Override
    // Return active apn of specific apn type
    public String getActiveApnString(String apnType) {
        if (DBG) log( "get active apn string for type:" + apnType);
        ApnContext apnContext = mApnContexts.get(apnType);
        if (apnContext != null) {
            ApnSetting apnSetting = apnContext.getApnSetting();
            if (apnSetting != null) {
                return apnSetting.apn;
            }
        }
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.346 -0500", hash_original_method = "5E11C1BF7F74A775167DAE6DA061B097", hash_generated_method = "6B85850DE3FB8510CB458A3D7BE274F4")
    
@Override
    public boolean isApnTypeEnabled(String apnType) {
        ApnContext apnContext = mApnContexts.get(apnType);
        if (apnContext == null) {
            return false;
        }
        return apnContext.isEnabled();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.348 -0500", hash_original_method = "06373F80BD4BEEF603E49D19A1DC6DA1", hash_generated_method = "DE64B2354EBD7C859F3349851EFC72B3")
    
@Override
    protected void setState(State s) {
        if (DBG) log("setState should not be used in GSM" + s);
    }

    // Return state of specific apn type
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.351 -0500", hash_original_method = "F24CC52DF36174C789130EC41124E06F", hash_generated_method = "860AE322B212D195FF9F0BB92B84790C")
    
@Override
    public State getState(String apnType) {
        ApnContext apnContext = mApnContexts.get(apnType);
        if (apnContext != null) {
            return apnContext.getState();
        }
        return State.FAILED;
    }

    // Return state of overall
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.355 -0500", hash_original_method = "3A07E102C7877AE139AF74E35A92CB31", hash_generated_method = "F6F1AB6C1321DD42F7AC24331DD951A1")
    
public State getOverallState() {
        boolean isConnecting = false;
        boolean isFailed = true; // All enabled Apns should be FAILED.
        boolean isAnyEnabled = false;

        for (ApnContext apnContext : mApnContexts.values()) {
            if (apnContext.isEnabled()) {
                isAnyEnabled = true;
                switch (apnContext.getState()) {
                case CONNECTED:
                case DISCONNECTING:
                    if (DBG) log("overall state is CONNECTED");
                    return State.CONNECTED;
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
            }
        }

        if (!isAnyEnabled) { // Nothing enabled. return IDLE.
            if (DBG) log( "overall state is IDLE");
            return State.IDLE;
        }

        if (isConnecting) {
            if (DBG) log( "overall state is CONNECTING");
            return State.CONNECTING;
        } else if (!isFailed) {
            if (DBG) log( "overall state is IDLE");
            return State.IDLE;
        } else {
            if (DBG) log( "overall state is FAILED");
            return State.FAILED;
        }
    }

    /**
     * Ensure that we are connected to an APN of the specified type.
     *
     * @param type the APN type
     * @return Success is indicated by {@code Phone.APN_ALREADY_ACTIVE} or
     *         {@code Phone.APN_REQUEST_STARTED}. In the latter case, a
     *         broadcast will be sent by the ConnectivityManager when a
     *         connection to the APN has been established.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.358 -0500", hash_original_method = "DED9CF35B00E99A5C3539FDABA142E11", hash_generated_method = "0CB332E1F3969BC82F1D26FCBE91FD13")
    
@Override
    public synchronized int enableApnType(String apnType) {
        ApnContext apnContext = mApnContexts.get(apnType);
        if (apnContext == null || !isApnTypeAvailable(apnType)) {
            if (DBG) log("enableApnType: " + apnType + " is type not available");
            return Phone.APN_TYPE_NOT_AVAILABLE;
        }

        // If already active, return
        if (DBG) log("enableApnType: " + apnType + " mState(" + apnContext.getState() + ")");

        if (apnContext.getState() == State.CONNECTED) {
            if (DBG) log("enableApnType: return APN_ALREADY_ACTIVE");
            return Phone.APN_ALREADY_ACTIVE;
        }
        setEnabled(apnTypeToId(apnType), true);
        if (DBG) {
            log("enableApnType: new apn request for type " + apnType +
                    " return APN_REQUEST_STARTED");
        }
        return Phone.APN_REQUEST_STARTED;
    }

    // A new APN has gone active and needs to send events to catch up with the
    // current condition
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.361 -0500", hash_original_method = "6BE0F7A51104BACC1DFB5733CC5E30CC", hash_generated_method = "D8FD8D562E2DBFDA0157FAE0CCC865E0")
    
private void notifyApnIdUpToCurrent(String reason, ApnContext apnContext, String type) {
        switch (apnContext.getState()) {
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
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.365 -0500", hash_original_method = "68A04474A9A6C009171326D545E43C31", hash_generated_method = "4A99D98304DF42A6927A00898C098B8C")
    
@Override
    public synchronized int disableApnType(String type) {
        if (DBG) log("disableApnType:" + type);
        ApnContext apnContext = mApnContexts.get(type);

        if (apnContext != null) {
            setEnabled(apnTypeToId(type), false);
            if (apnContext.getState() != State.IDLE && apnContext.getState() != State.FAILED) {
                if (DBG) log("diableApnType: return APN_REQUEST_STARTED");
                return Phone.APN_REQUEST_STARTED;
            } else {
                if (DBG) log("disableApnType: return APN_ALREADY_INACTIVE");
                return Phone.APN_ALREADY_INACTIVE;
            }

        } else {
            if (DBG) {
                log("disableApnType: no apn context was found, return APN_REQUEST_FAILED");
            }
            return Phone.APN_REQUEST_FAILED;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.368 -0500", hash_original_method = "A26AD8C394281D1D0A1213181383C4F5", hash_generated_method = "07D9CF7F2AA117FFB838CFB09FEA279B")
    
@Override
    protected boolean isApnTypeAvailable(String type) {
        if (type.equals(Phone.APN_TYPE_DUN) && fetchDunApn() != null) {
            return true;
        }

        if (mAllApns != null) {
            for (ApnSetting apn : mAllApns) {
                if (apn.canHandleType(type)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Report on whether data connectivity is enabled for any APN.
     * @return {@code false} if data connectivity has been explicitly disabled,
     * {@code true} otherwise.
     */
    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.371 -0500", hash_original_method = "C851438642EDA5AB3134873854010685", hash_generated_method = "BF9AA5E9B289454189B71C8F78AFCEB5")
    
@Override
    public boolean getAnyDataEnabled() {
        synchronized (mDataEnabledLock) {
            if (!(mInternalDataEnabled && mUserDataEnabled && sPolicyDataEnabled)) return false;
            for (ApnContext apnContext : mApnContexts.values()) {
                // Make sure we dont have a context that going down
                // and is explicitly disabled.
                if (isDataAllowed(apnContext)) {
                    return true;
                }
            }
            return false;
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.374 -0500", hash_original_method = "7A177E6FBAF2829724A437FA44770C6E", hash_generated_method = "84EA95D2044D5038C6956C33C6DB45B9")
    
private boolean isDataAllowed(ApnContext apnContext) {
        return apnContext.isReady() && isDataAllowed();
    }

    //****** Called from ServiceStateTracker
    /**
     * Invoked when ServiceStateTracker observes a transition from GPRS
     * attach to detach.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.376 -0500", hash_original_method = "DBAD0221F2A53A2AC3E8556324A28A19", hash_generated_method = "F864472904C142D8743E9F52F7418252")
    
protected void onDataConnectionDetached() {
        /*
         * We presently believe it is unnecessary to tear down the PDP context
         * when GPRS detaches, but we should stop the network polling.
         */
        if (DBG) log ("onDataConnectionDetached: stop polling and notify detached");
        stopNetStatPoll();
        stopDataStallAlarm();
        notifyDataConnection(Phone.REASON_DATA_DETACHED);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.379 -0500", hash_original_method = "F401CBF6A4FFFF291696606C3EE2FE85", hash_generated_method = "0A903CD212D8C423334C1A54F72A2A8E")
    
private void onDataConnectionAttached() {
        if (DBG) log("onDataConnectionAttached");
        if (getOverallState() == State.CONNECTED) {
            if (DBG) log("onDataConnectionAttached: start polling notify attached");
            startNetStatPoll();
            startDataStallAlarm();
            notifyDataConnection(Phone.REASON_DATA_ATTACHED);
        } else {
            // update APN availability so that APN can be enabled.
            notifyOffApnsOfAvailability(Phone.REASON_DATA_ATTACHED);
        }

        setupDataOnReadyApns(Phone.REASON_DATA_ATTACHED);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.383 -0500", hash_original_method = "000E90D5C33553E8124AA0C75E4D9E4F", hash_generated_method = "D6EA117A06A45569F9C78B3AF90717D9")
    
@Override
    protected boolean isDataAllowed() {
        final boolean internalDataEnabled;
        synchronized (mDataEnabledLock) {
            internalDataEnabled = mInternalDataEnabled;
        }

        int gprsState = mPhone.getServiceStateTracker().getCurrentDataConnectionState();
        boolean desiredPowerState = mPhone.getServiceStateTracker().getDesiredPowerState();

        boolean allowed =
                    (gprsState == ServiceState.STATE_IN_SERVICE || mAutoAttachOnCreation) &&
                    mPhone.mIccRecords.getRecordsLoaded() &&
                    (mPhone.getState() == Phone.State.IDLE ||
                     mPhone.getServiceStateTracker().isConcurrentVoiceAndDataAllowed()) &&
                    internalDataEnabled &&
                    (!mPhone.getServiceState().getRoaming() || getDataOnRoamingEnabled()) &&
                    !mIsPsRestricted &&
                    desiredPowerState;
        if (!allowed && DBG) {
            String reason = "";
            if (!((gprsState == ServiceState.STATE_IN_SERVICE) || mAutoAttachOnCreation)) {
                reason += " - gprs= " + gprsState;
            }
            if (!mPhone.mIccRecords.getRecordsLoaded()) reason += " - SIM not loaded";
            if (mPhone.getState() != Phone.State.IDLE &&
                    !mPhone.getServiceStateTracker().isConcurrentVoiceAndDataAllowed()) {
                reason += " - PhoneState= " + mPhone.getState();
                reason += " - Concurrent voice and data not allowed";
            }
            if (!internalDataEnabled) reason += " - mInternalDataEnabled= false";
            if (mPhone.getServiceState().getRoaming() && !getDataOnRoamingEnabled()) {
                reason += " - Roaming and data roaming not enabled";
            }
            if (mIsPsRestricted) reason += " - mIsPsRestricted= true";
            if (!desiredPowerState) reason += " - desiredPowerState= false";
            if (DBG) log("isDataAllowed: not allowed due to" + reason);
        }
        return allowed;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.386 -0500", hash_original_method = "625A02DD3D04B0C927BA692603CBFCC6", hash_generated_method = "0F49FCB08DE0522635AFD9AB30E85D63")
    
private void setupDataOnReadyApns(String reason) {
        // Stop reconnect alarms on all data connections pending
        // retry. Reset ApnContext state to IDLE.
        for (DataConnectionAc dcac : mDataConnectionAsyncChannels.values()) {
            if (dcac.getReconnectIntentSync() != null) {
                cancelReconnectAlarm(dcac);
            }
            // update retry config for existing calls to match up
            // ones for the new RAT.
            if (dcac.dataConnection != null) {
                Collection<ApnContext> apns = dcac.getApnListSync();

                boolean hasDefault = false;
                for (ApnContext apnContext : apns) {
                    if (apnContext.getApnType().equals(Phone.APN_TYPE_DEFAULT)) {
                        hasDefault = true;
                        break;
                    }
                }
                configureRetry(dcac.dataConnection, hasDefault);
            }
        }

        // Only check for default APN state
        for (ApnContext apnContext : mApnContexts.values()) {
            if (apnContext.getState() == State.FAILED) {
                // By this time, alarms for all failed Apns
                // should be stopped if any.
                // Make sure to set the state back to IDLE
                // so that setup data can happen.
                apnContext.setState(State.IDLE);
            }
            if (apnContext.isReady()) {
                if (apnContext.getState() == State.IDLE) {
                    apnContext.setReason(reason);
                    trySetupData(apnContext);
                }
            }
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.389 -0500", hash_original_method = "293D247CD6F3CD381680AFA4CF477431", hash_generated_method = "61A2FC1F4DCB2BD149CBE8E66810FC0C")
    
private boolean trySetupData(String reason, String type) {
        if (DBG) {
            log("trySetupData: " + type + " due to " + (reason == null ? "(unspecified)" : reason)
                    + " isPsRestricted=" + mIsPsRestricted);
        }

        if (type == null) {
            type = Phone.APN_TYPE_DEFAULT;
        }

        ApnContext apnContext = mApnContexts.get(type);

        if (apnContext == null ){
            if (DBG) log("trySetupData new apn context for type:" + type);
            apnContext = new ApnContext(type, LOG_TAG);
            mApnContexts.put(type, apnContext);
        }
        apnContext.setReason(reason);

        return trySetupData(apnContext);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.393 -0500", hash_original_method = "01B865917AB0716CB4ECB273F41078C0", hash_generated_method = "2DF39C2748B26938E8D79B96073C63C9")
    
private boolean trySetupData(ApnContext apnContext) {
        if (DBG) {
            log("trySetupData for type:" + apnContext.getApnType() +
                    " due to " + apnContext.getReason());
            log("trySetupData with mIsPsRestricted=" + mIsPsRestricted);
        }

        if (mPhone.getSimulatedRadioControl() != null) {
            // Assume data is connected on the simulator
            // FIXME  this can be improved
            apnContext.setState(State.CONNECTED);
            mPhone.notifyDataConnection(apnContext.getReason(), apnContext.getApnType());

            log("trySetupData: (fix?) We're on the simulator; assuming data is connected");
            return true;
        }

        boolean desiredPowerState = mPhone.getServiceStateTracker().getDesiredPowerState();

        if ((apnContext.getState() == State.IDLE || apnContext.getState() == State.SCANNING) &&
                isDataAllowed(apnContext) && getAnyDataEnabled() && !isEmergency()) {

            if (apnContext.getState() == State.IDLE) {
                ArrayList<ApnSetting> waitingApns = buildWaitingApns(apnContext.getApnType());
                if (waitingApns.isEmpty()) {
                    if (DBG) log("trySetupData: No APN found");
                    notifyNoData(GsmDataConnection.FailCause.MISSING_UNKNOWN_APN, apnContext);
                    notifyOffApnsOfAvailability(apnContext.getReason());
                    return false;
                } else {
                    apnContext.setWaitingApns(waitingApns);
                    if (DBG) {
                        log ("trySetupData: Create from mAllApns : " + apnListToString(mAllApns));
                    }
                }
            }

            if (DBG) {
                log ("Setup watingApns : " + apnListToString(apnContext.getWaitingApns()));
            }
            // apnContext.setReason(apnContext.getReason());
            boolean retValue = setupData(apnContext);
            notifyOffApnsOfAvailability(apnContext.getReason());
            return retValue;
        } else {
            // TODO: check the condition.
            if (!apnContext.getApnType().equals(Phone.APN_TYPE_DEFAULT)
                && (apnContext.getState() == State.IDLE
                    || apnContext.getState() == State.SCANNING))
                mPhone.notifyDataConnectionFailed(apnContext.getReason(), apnContext.getApnType());
            notifyOffApnsOfAvailability(apnContext.getReason());
            return false;
        }
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.396 -0500", hash_original_method = "9CD870BA8C542E1D80FC2F2D725750C0", hash_generated_method = "C6C6E4C15CDB257E8F082BAAF3388C25")
    
@Override
    // Disabled apn's still need avail/unavail notificiations - send them out
    protected void notifyOffApnsOfAvailability(String reason) {
        for (ApnContext apnContext : mApnContexts.values()) {
            if (!apnContext.isReady()) {
                if (DBG) log("notifyOffApnOfAvailability type:" + apnContext.getApnType());
                mPhone.notifyDataConnection(reason != null ? reason : apnContext.getReason(),
                                            apnContext.getApnType(),
                                            Phone.DataState.DISCONNECTED);
            } else {
                if (DBG) {
                    log("notifyOffApnsOfAvailability skipped apn due to isReady==false: " +
                            apnContext.toString());
                }
            }
        }
    }

    /**
     * If tearDown is true, this only tears down a CONNECTED session. Presently,
     * there is no mechanism for abandoning an INITING/CONNECTING session,
     * but would likely involve cancelling pending async requests or
     * setting a flag or new state to ignore them when they came in
     * @param tearDown true if the underlying GsmDataConnection should be
     * disconnected.
     * @param reason reason for the clean up.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.399 -0500", hash_original_method = "66E1568E09B68AEC1E9A7CA6629E1BE4", hash_generated_method = "8742976A845D6D3D7CC261BE9E725202")
    
protected void cleanUpAllConnections(boolean tearDown, String reason) {
        if (DBG) log("cleanUpAllConnections: tearDown=" + tearDown + " reason=" + reason);

        for (ApnContext apnContext : mApnContexts.values()) {
            apnContext.setReason(reason);
            cleanUpConnection(tearDown, apnContext);
        }

        stopNetStatPoll();
        stopDataStallAlarm();

        // TODO: Do we need mRequestedApnType?
        mRequestedApnType = Phone.APN_TYPE_DEFAULT;
    }

    /**
     * Cleanup all connections.
     *
     * TODO: Cleanup only a specified connection passed as a parameter.
     *       Also, make sure when you clean up a conn, if it is last apply
     *       logic as though it is cleanupAllConnections
     *
     * @param tearDown true if the underlying DataConnection should be disconnected.
     * @param reason for the clean up.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.402 -0500", hash_original_method = "CD47D8147DAAE254C6F8BD59780442CD", hash_generated_method = "94EC0761D9B928E7003FF2BDA1042097")
    
@Override
    protected void onCleanUpAllConnections(String cause) {
        cleanUpAllConnections(true, cause);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.405 -0500", hash_original_method = "2562A19804F84494AABD51DA4769B2BA", hash_generated_method = "7CF66ADBF25FBF5D08FD9AB13DA04553")
    
private void cleanUpConnection(boolean tearDown, ApnContext apnContext) {

        if (apnContext == null) {
            if (DBG) log("cleanUpConnection: apn context is null");
            return;
        }

        if (DBG) {
            log("cleanUpConnection: tearDown=" + tearDown + " reason=" + apnContext.getReason());
        }
        DataConnectionAc dcac = apnContext.getDataConnectionAc();
        if (tearDown) {
            if (apnContext.isDisconnected()) {
                // The request is tearDown and but ApnContext is not connected.
                // If apnContext is not enabled anymore, break the linkage to the DCAC/DC.
                apnContext.setState(State.IDLE);
                if (!apnContext.isReady()) {
                    apnContext.setDataConnection(null);
                    apnContext.setDataConnectionAc(null);
                }
            } else {
                // Connection is still there. Try to clean up.
                if (dcac != null) {
                    if (apnContext.getState() != State.DISCONNECTING) {
                        if (DBG) log("cleanUpConnection: tearing down");
                        Message msg = obtainMessage(EVENT_DISCONNECT_DONE, apnContext);
                        apnContext.getDataConnection().tearDown(apnContext.getReason(), msg);
                        apnContext.setState(State.DISCONNECTING);
                    }
                } else {
                    // apn is connected but no reference to dcac.
                    // Should not be happen, but reset the state in case.
                    apnContext.setState(State.IDLE);
                    mPhone.notifyDataConnection(apnContext.getReason(),
                                                apnContext.getApnType());
                }
            }
        } else {
            // force clean up the data connection.
            if (dcac != null) dcac.resetSync();
            apnContext.setState(State.IDLE);
            mPhone.notifyDataConnection(apnContext.getReason(), apnContext.getApnType());
            apnContext.setDataConnection(null);
            apnContext.setDataConnectionAc(null);
        }

        // make sure reconnection alarm is cleaned up if there is no ApnContext
        // associated to the connection.
        if (dcac != null) {
            Collection<ApnContext> apnList = dcac.getApnListSync();
            if (apnList.isEmpty()) {
                cancelReconnectAlarm(dcac);
            }
        }
    }

    /**
     * Cancels the alarm associated with DCAC.
     *
     * @param DataConnectionAc on which the alarm should be stopped.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.408 -0500", hash_original_method = "1F926905027AA18BF39C8A7A893395A9", hash_generated_method = "CE549DC87D1EC01EC2BEE46F103ED306")
    
private void cancelReconnectAlarm(DataConnectionAc dcac) {
        if (dcac == null) return;

        PendingIntent intent = dcac.getReconnectIntentSync();

        if (intent != null) {
                AlarmManager am =
                    (AlarmManager) mPhone.getContext().getSystemService(Context.ALARM_SERVICE);
                am.cancel(intent);
                dcac.setReconnectIntentSync(null);
        }
    }

    /**
     * @param types comma delimited list of APN types
     * @return array of APN types
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.410 -0500", hash_original_method = "08930E35848EBECD6CC869C9C6D6B1F8", hash_generated_method = "5A092E2D72BD8DF3DE8814F8AE9F0DCF")
    
private String[] parseTypes(String types) {
        String[] result;
        // If unset, set to DEFAULT.
        if (types == null || types.equals("")) {
            result = new String[1];
            result[0] = Phone.APN_TYPE_ALL;
        } else {
            result = types.split(",");
        }
        return result;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.414 -0500", hash_original_method = "25E446029D7F780B1E04F89AE12B062D", hash_generated_method = "782521DDE4894C6986D63D7B355B6DB2")
    
private ArrayList<ApnSetting> createApnList(Cursor cursor) {
        ArrayList<ApnSetting> result = new ArrayList<ApnSetting>();
        if (cursor.moveToFirst()) {
            do {
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
            } while (cursor.moveToNext());
        }
        if (DBG) log("createApnList: X result=" + result);
        return result;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.417 -0500", hash_original_method = "2E87B4CBA5BF77A80284005F43D6FB91", hash_generated_method = "8F2951C6420CAD67C2445EE1EE088DF8")
    
private boolean dataConnectionNotInUse(DataConnectionAc dcac) {
        for (ApnContext apnContext : mApnContexts.values()) {
            if (apnContext.getDataConnectionAc() == dcac) return false;
        }
        return true;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.419 -0500", hash_original_method = "871B8246FCDE157C8EBBD019FC69C7EE", hash_generated_method = "CCD569290CCFAF5FD630610961309917")
    
private GsmDataConnection findFreeDataConnection() {
        for (DataConnectionAc dcac : mDataConnectionAsyncChannels.values()) {
            if (dcac.isInactiveSync() && dataConnectionNotInUse(dcac)) {
                log("findFreeDataConnection: found free GsmDataConnection");
                return (GsmDataConnection) dcac.dataConnection;
            }
        }
        log("findFreeDataConnection: NO free GsmDataConnection");
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.423 -0500", hash_original_method = "9845808D61EC26568899ACA30184D52E", hash_generated_method = "BFAF42D543D6F07AF86216D13E6B5B9F")
    
protected GsmDataConnection findReadyDataConnection(ApnSetting apn) {
        if (DBG)
            log("findReadyDataConnection: apn string <" +
                (apn!=null?(apn.toString()):"null") +">");
        if (apn == null) {
            return null;
        }
        for (DataConnectionAc dcac : mDataConnectionAsyncChannels.values()) {
            ApnSetting apnSetting = dcac.getApnSettingSync();
            if (DBG) {
                log("findReadyDataConnection: dc apn string <" +
                         (apnSetting != null ? (apnSetting.toString()) : "null") + ">");
            }
            if ((apnSetting != null) && TextUtils.equals(apnSetting.toString(), apn.toString())) {
                return (GsmDataConnection) dcac.dataConnection;
            }
        }
        return null;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.426 -0500", hash_original_method = "BBFF3626F623A28B2260A4B879BEB776", hash_generated_method = "505676C2966DA4CA8985882D822A3431")
    
private boolean setupData(ApnContext apnContext) {
        if (DBG) log("setupData: apnContext=" + apnContext);
        ApnSetting apn;
        GsmDataConnection dc;

        int profileId = getApnProfileID(apnContext.getApnType());
        apn = apnContext.getNextWaitingApn();
        if (apn == null) {
            if (DBG) log("setupData: return for no apn found!");
            return false;
        }

        // First, check to see if ApnContext already has DC.
        // This could happen if the retries are currently  engaged.
        dc = (GsmDataConnection)apnContext.getDataConnection();

        if (dc == null) {

            dc = (GsmDataConnection) checkForConnectionForApnContext(apnContext);

            if (dc == null) {
                dc = findReadyDataConnection(apn);
            }

            if (dc == null) {
                if (DBG) log("setupData: No ready GsmDataConnection found!");
                // TODO: When allocating you are mapping type to id. If more than 1 free,
                // then could findFreeDataConnection get the wrong one??
                dc = findFreeDataConnection();
            }

            if (dc == null) {
                dc = createDataConnection();
            }

            if (dc == null) {
                if (DBG) log("setupData: No free GsmDataConnection found!");
                return false;
            }

            DataConnectionAc dcac = mDataConnectionAsyncChannels.get(dc.getDataConnectionId());
            dc.setProfileId( profileId );
            dc.setActiveApnType(apnContext.getApnType());
            int refCount = dcac.getRefCountSync();
            if (DBG) log("setupData: init dc and apnContext refCount=" + refCount);

            // configure retry count if no other Apn is using the same connection.
            if (refCount == 0) {
                configureRetry(dc, apn.canHandleType(Phone.APN_TYPE_DEFAULT));
            }
            apnContext.setDataConnectionAc(dcac);
            apnContext.setDataConnection(dc);
        }

        apnContext.setApnSetting(apn);
        apnContext.setState(State.INITING);
        mPhone.notifyDataConnection(apnContext.getReason(), apnContext.getApnType());
        // If reconnect alarm is active on this DataConnection, wait for the alarm being
        // fired so that we don't disruppt data retry pattern engaged.
        if (apnContext.getDataConnectionAc().getReconnectIntentSync() != null) {
            if (DBG) log("setupData: data reconnection pending");
            apnContext.setState(State.FAILED);
            mPhone.notifyDataConnection(apnContext.getReason(), apnContext.getApnType());
            return true;
        }

        Message msg = obtainMessage();
        msg.what = EVENT_DATA_SETUP_COMPLETE;
        msg.obj = apnContext;
        dc.bringUp(msg, apn);

        if (DBG) log("setupData: initing!");
        return true;
    }

    /**
     * Handles changes to the APN database.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.429 -0500", hash_original_method = "651F557B6A8D0D165E9CDD4391DC0D13", hash_generated_method = "F3DD0A711FEDFB8A162FBFF01A23EE08")
    
private void onApnChanged() {
        State overallState = getOverallState();
        boolean isDisconnected = (overallState == State.IDLE || overallState == State.FAILED);

        if (mPhone instanceof GSMPhone) {
            // The "current" may no longer be valid.  MMS depends on this to send properly. TBD
            ((GSMPhone)mPhone).updateCurrentCarrierInProvider();
        }

        // TODO: It'd be nice to only do this if the changed entrie(s)
        // match the current operator.
        if (DBG) log("onApnChanged: createAllApnList and cleanUpAllConnections");
        createAllApnList();
        cleanUpAllConnections(!isDisconnected, Phone.REASON_APN_CHANGED);
        if (isDisconnected) {
            setupDataOnReadyApns(Phone.REASON_APN_CHANGED);
        }
    }

    /**
     * @param cid Connection id provided from RIL.
     * @return DataConnectionAc associated with specified cid.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.431 -0500", hash_original_method = "65E72951AE41561D32861B862A9CCB8A", hash_generated_method = "7522C9572C390838E67A7746F84509A6")
    
private DataConnectionAc findDataConnectionAcByCid(int cid) {
        for (DataConnectionAc dcac : mDataConnectionAsyncChannels.values()) {
            if (dcac.getCidSync() == cid) {
                return dcac;
            }
        }
        return null;
    }

    /**
     * @param dcacs Collection of DataConnectionAc reported from RIL.
     * @return List of ApnContext which is connected, but is not present in
     *         data connection list reported from RIL.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.434 -0500", hash_original_method = "3E391A4D32CF36E6E02EF7EB45223170", hash_generated_method = "BA1A5570B01E85F6CE3B608DB7480C49")
    
private List<ApnContext> findApnContextToClean(Collection<DataConnectionAc> dcacs) {
        if (dcacs == null) return null;

        ArrayList<ApnContext> list = new ArrayList<ApnContext>();
        for (ApnContext apnContext : mApnContexts.values()) {
            if (apnContext.getState() == State.CONNECTED) {
                boolean found = false;
                for (DataConnectionAc dcac : dcacs) {
                    if (dcac == apnContext.getDataConnectionAc()) {
                        // ApnContext holds the ref to dcac present in data call list.
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    // ApnContext does not have dcac reported in data call list.
                    // Fetch all the ApnContexts that map to this dcac which are in
                    // INITING state too.
                    if (DBG) log("onDataStateChanged(ar): Connected apn not found in the list (" +
                                 apnContext.toString() + ")");
                    if (apnContext.getDataConnectionAc() != null) {
                        list.addAll(apnContext.getDataConnectionAc().getApnListSync());
                    } else {
                        list.add(apnContext);
                    }
                }
            }
        }
        return list;
    }

    /**
     * @param ar is the result of RIL_REQUEST_DATA_CALL_LIST
     * or RIL_UNSOL_DATA_CALL_LIST_CHANGED
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.439 -0500", hash_original_method = "2CAD8F6019A6EE1B4B77B4750A278A68", hash_generated_method = "A5EC7A31BE384542071566F0AA392777")
    
private void onDataStateChanged (AsyncResult ar) {
        ArrayList<DataCallState> dataCallStates;

        if (DBG) log("onDataStateChanged(ar): E");
        dataCallStates = (ArrayList<DataCallState>)(ar.result);

        if (ar.exception != null) {
            // This is probably "radio not available" or something
            // of that sort. If so, the whole connection is going
            // to come down soon anyway
            if (DBG) log("onDataStateChanged(ar): exception; likely radio not available, ignore");
            return;
        }
        if (DBG) log("onDataStateChanged(ar): DataCallState size=" + dataCallStates.size());

        // Create a hash map to store the dataCallState of each DataConnectionAc
        HashMap<DataCallState, DataConnectionAc> dataCallStateToDcac;
        dataCallStateToDcac = new HashMap<DataCallState, DataConnectionAc>();
        for (DataCallState dataCallState : dataCallStates) {
            DataConnectionAc dcac = findDataConnectionAcByCid(dataCallState.cid);

            if (dcac != null) dataCallStateToDcac.put(dataCallState, dcac);
        }

        // A list of apns to cleanup, those that aren't in the list we know we have to cleanup
        List<ApnContext> apnsToCleanup = findApnContextToClean(dataCallStateToDcac.values());

        // Find which connections have changed state and send a notification or cleanup
        for (DataCallState newState : dataCallStates) {
            DataConnectionAc dcac = dataCallStateToDcac.get(newState);

            if (dcac == null) {
                loge("onDataStateChanged(ar): No associated DataConnection ignore");
                continue;
            }

            // The list of apn's associated with this DataConnection
            Collection<ApnContext> apns = dcac.getApnListSync();

            // Find which ApnContexts of this DC are in the "Connected/Connecting" state.
            ArrayList<ApnContext> connectedApns = new ArrayList<ApnContext>();
            for (ApnContext apnContext : apns) {
                if (apnContext.getState() == State.CONNECTED ||
                       apnContext.getState() == State.CONNECTING ||
                       apnContext.getState() == State.INITING) {
                    connectedApns.add(apnContext);
                }
            }
            if (connectedApns.size() == 0) {
                if (DBG) log("onDataStateChanged(ar): no connected apns");
            } else {
                // Determine if the connection/apnContext should be cleaned up
                // or just a notification should be sent out.
                if (DBG) log("onDataStateChanged(ar): Found ConnId=" + newState.cid
                        + " newState=" + newState.toString());
                if (newState.active == 0) {
                    if (DBG) {
                        log("onDataStateChanged(ar): inactive, cleanup apns=" + connectedApns);
                    }
                    apnsToCleanup.addAll(connectedApns);
                } else {
                    // Its active so update the DataConnections link properties
                    UpdateLinkPropertyResult result =
                        dcac.updateLinkPropertiesDataCallStateSync(newState);
                    if (result.oldLp.equals(result.newLp)) {
                        if (DBG) log("onDataStateChanged(ar): no change");
                    } else {
                        if (result.oldLp.isIdenticalInterfaceName(result.newLp)) {
                            if (! result.oldLp.isIdenticalDnses(result.newLp) ||
                                    ! result.oldLp.isIdenticalRoutes(result.newLp) ||
                                    ! result.oldLp.isIdenticalHttpProxy(result.newLp) ||
                                    ! result.oldLp.isIdenticalAddresses(result.newLp)) {
                                // If the same address type was removed and added we need to cleanup
                                CompareResult<LinkAddress> car =
                                    result.oldLp.compareAddresses(result.newLp);
                                boolean needToClean = false;
                                for (LinkAddress added : car.added) {
                                    for (LinkAddress removed : car.removed) {
                                        if (NetworkUtils.addressTypeMatches(removed.getAddress(),
                                                added.getAddress())) {
                                            needToClean = true;
                                            break;
                                        }
                                    }
                                }
                                if (needToClean) {
                                    if (DBG) {
                                        log("onDataStateChanged(ar): addr change, cleanup apns=" +
                                                connectedApns);
                                    }
                                    apnsToCleanup.addAll(connectedApns);
                                } else {
                                    if (DBG) log("onDataStateChanged(ar): simple change");
                                    for (ApnContext apnContext : connectedApns) {
                                         mPhone.notifyDataConnection(
                                                 Phone.REASON_LINK_PROPERTIES_CHANGED,
                                                 apnContext.getApnType());
                                    }
                                }
                            } else {
                                if (DBG) {
                                    log("onDataStateChanged(ar): no changes");
                                }
                            }
                        } else {
                            if (DBG) {
                                log("onDataStateChanged(ar): interface change, cleanup apns="
                                        + connectedApns);
                            }
                            apnsToCleanup.addAll(connectedApns);
                        }
                    }
                }
            }
        }

        if (apnsToCleanup.size() != 0) {
            // Add an event log when the network drops PDP
            int cid = getCellLocationId();
            EventLog.writeEvent(EventLogTags.PDP_NETWORK_DROP, cid,
                                TelephonyManager.getDefault().getNetworkType());
        }

        // Cleanup those dropped connections
        for (ApnContext apnContext : apnsToCleanup) {
            cleanUpConnection(true, apnContext);
        }

        if (DBG) log("onDataStateChanged(ar): X");
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.442 -0500", hash_original_method = "66B167D0E0A206B2D44C874F7CFFABF5", hash_generated_method = "89CEAE71B786C389C731D386CCC63A92")
    
private void notifyDefaultData(ApnContext apnContext) {
        if (DBG) {
            log("notifyDefaultData: type=" + apnContext.getApnType()
                + ", reason:" + apnContext.getReason());
        }
        apnContext.setState(State.CONNECTED);
        // setState(State.CONNECTED);
        mPhone.notifyDataConnection(apnContext.getReason(), apnContext.getApnType());
        startNetStatPoll();
        startDataStallAlarm();
        // reset reconnect timer
        apnContext.getDataConnection().resetRetryCount();
    }

    // TODO: For multiple Active APNs not exactly sure how to do this.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.445 -0500", hash_original_method = "06C0A537C422D51FEBC3A4D7FED033FC", hash_generated_method = "95C7AA04E557B168D96C230686C3ABE4")
    
protected void gotoIdleAndNotifyDataConnection(String reason) {
        if (DBG) log("gotoIdleAndNotifyDataConnection: reason=" + reason);
        notifyDataConnection(reason);
        mActiveApn = null;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.447 -0500", hash_original_method = "E0A0A9601ED58F14AFBBF23896E64411", hash_generated_method = "DB5476E53DC5255B75D7FFF7609104DC")
    
private void resetPollStats() {
        mTxPkts = -1;
        mRxPkts = -1;
        mNetStatPollPeriod = POLL_NETSTAT_MILLIS;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.451 -0500", hash_original_method = "85BF013ED3EA874C77BCE8B69E224FC2", hash_generated_method = "F8EB7C3945F31622869BACD037F884D6")
    
private void doRecovery() {
        if (getOverallState() == State.CONNECTED) {
            // Go through a series of recovery steps, each action transitions to the next action
            int recoveryAction = getRecoveryAction();
            switch (recoveryAction) {
            case RecoveryAction.GET_DATA_CALL_LIST:
                EventLog.writeEvent(EventLogTags.DATA_STALL_RECOVERY_GET_DATA_CALL_LIST,
                        mSentSinceLastRecv);
                if (DBG) log("doRecovery() get data call list");
                mPhone.mCM.getDataCallList(obtainMessage(EVENT_DATA_STATE_CHANGED));
                putRecoveryAction(RecoveryAction.CLEANUP);
                break;
            case RecoveryAction.CLEANUP:
                EventLog.writeEvent(EventLogTags.DATA_STALL_RECOVERY_CLEANUP, mSentSinceLastRecv);
                if (DBG) log("doRecovery() cleanup all connections");
                cleanUpAllConnections(true, Phone.REASON_PDP_RESET);
                putRecoveryAction(RecoveryAction.REREGISTER);
                break;
            case RecoveryAction.REREGISTER:
                EventLog.writeEvent(EventLogTags.DATA_STALL_RECOVERY_REREGISTER,
                        mSentSinceLastRecv);
                if (DBG) log("doRecovery() re-register");
                mPhone.getServiceStateTracker().reRegisterNetwork(null);
                putRecoveryAction(RecoveryAction.RADIO_RESTART);
                break;
            case RecoveryAction.RADIO_RESTART:
                EventLog.writeEvent(EventLogTags.DATA_STALL_RECOVERY_RADIO_RESTART,
                        mSentSinceLastRecv);
                if (DBG) log("restarting radio");
                putRecoveryAction(RecoveryAction.RADIO_RESTART_WITH_PROP);
                restartRadio();
                break;
            case RecoveryAction.RADIO_RESTART_WITH_PROP:
                // This is in case radio restart has not recovered the data.
                // It will set an additional "gsm.radioreset" property to tell
                // RIL or system to take further action.
                // The implementation of hard reset recovery action is up to OEM product.
                // Once gsm.radioreset property is consumed, it is expected to set back
                // to false by RIL.
                EventLog.writeEvent(EventLogTags.DATA_STALL_RECOVERY_RADIO_RESTART_WITH_PROP, -1);
                if (DBG) log("restarting radio with gsm.radioreset to true");
                SystemProperties.set("gsm.radioreset", "true");
                // give 1 sec so property change can be notified.
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {}
                restartRadio();
                putRecoveryAction(RecoveryAction.GET_DATA_CALL_LIST);
                break;
            default:
                throw new RuntimeException("doRecovery: Invalid recoveryAction=" +
                    recoveryAction);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.454 -0500", hash_original_method = "6E590AA3974E9F6C1EEF78A59E60FE7C", hash_generated_method = "9A0723E66975CE51D519FB01A0489C6D")
    
@Override
    protected void startNetStatPoll() {
        if (getOverallState() == State.CONNECTED && mNetStatPollEnabled == false) {
            if (DBG) log("startNetStatPoll");
            resetPollStats();
            mNetStatPollEnabled = true;
            mPollNetStat.run();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.456 -0500", hash_original_method = "A8EA63C8FD8E985352F3B26222CD114C", hash_generated_method = "2AD85D290BE89C1A5D1ED470CF92C0BF")
    
@Override
    protected void stopNetStatPoll() {
        mNetStatPollEnabled = false;
        removeCallbacks(mPollNetStat);
        if (DBG) log("stopNetStatPoll");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.460 -0500", hash_original_method = "7B64E8A50E5FAE405E2B8EDB2C4EA1BE", hash_generated_method = "B57AAEC2D53B776F3478E320593604F2")
    
@Override
    protected void restartRadio() {
        if (DBG) log("restartRadio: ************TURN OFF RADIO**************");
        cleanUpAllConnections(true, Phone.REASON_RADIO_TURNED_OFF);
        mPhone.getServiceStateTracker().powerOffRadioSafely(this);
        /* Note: no need to call setRadioPower(true).  Assuming the desired
         * radio power state is still ON (as tracked by ServiceStateTracker),
         * ServiceStateTracker will call setRadioPower when it receives the
         * RADIO_STATE_CHANGED notification for the power off.  And if the
         * desired power state has changed in the interim, we don't want to
         * override it with an unconditional power on.
         */

        int reset = Integer.parseInt(SystemProperties.get("net.ppp.reset-by-timeout", "0"));
        SystemProperties.set("net.ppp.reset-by-timeout", String.valueOf(reset+1));
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.463 -0500", hash_original_method = "757A180615AA792B2C29A1B55C4F521C", hash_generated_method = "9FB1C6C6D1B06005638D85163201726B")
    
private void updateDataStallInfo() {
        long sent, received;

        TxRxSum preTxRxSum = new TxRxSum(mDataStallTxRxSum);
        mDataStallTxRxSum.updateTxRxSum();

        if (VDBG) {
            log("updateDataStallInfo: mDataStallTxRxSum=" + mDataStallTxRxSum +
                    " preTxRxSum=" + preTxRxSum);
        }

        sent = mDataStallTxRxSum.txPkts - preTxRxSum.txPkts;
        received = mDataStallTxRxSum.rxPkts - preTxRxSum.rxPkts;

        if (VDBG) {
            if (SystemProperties.getBoolean("radio.test.data.stall", false)) {
                log("updateDataStallInfo: radio.test.data.stall true received = 0;");
                received = 0;
            }
        }
        if ( sent > 0 && received > 0 ) {
            if (VDBG) log("updateDataStallInfo: IN/OUT");
            mSentSinceLastRecv = 0;
            putRecoveryAction(RecoveryAction.GET_DATA_CALL_LIST);
        } else if (sent > 0 && received == 0) {
            if (mPhone.getState() == Phone.State.IDLE) {
                mSentSinceLastRecv += sent;
            } else {
                mSentSinceLastRecv = 0;
            }
            if (DBG) {
                log("updateDataStallInfo: OUT sent=" + sent +
                        " mSentSinceLastRecv=" + mSentSinceLastRecv);
            }
        } else if (sent == 0 && received > 0) {
            if (VDBG) log("updateDataStallInfo: IN");
            mSentSinceLastRecv = 0;
            putRecoveryAction(RecoveryAction.GET_DATA_CALL_LIST);
        } else {
            if (VDBG) log("updateDataStallInfo: NONE");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.466 -0500", hash_original_method = "81664D2568F01996EC1331372DE6C46E", hash_generated_method = "53AB0908A856FAA76C425E3CE5885A5A")
    
@Override
    protected void onDataStallAlarm(int tag) {
        if (mDataStallAlarmTag != tag) {
            if (DBG) {
                log("onDataStallAlarm: ignore, tag=" + tag + " expecting " + mDataStallAlarmTag);
            }
            return;
        }
        updateDataStallInfo();

        int hangWatchdogTrigger = Settings.Secure.getInt(mResolver,
                Settings.Secure.PDP_WATCHDOG_TRIGGER_PACKET_COUNT,
                NUMBER_SENT_PACKETS_OF_HANG);

        if (mSentSinceLastRecv >= hangWatchdogTrigger) {
            if (DBG) {
                log("onDataStallAlarm: tag=" + tag + " do recovery action=" + getRecoveryAction());
            }
            sendMessage(obtainMessage(EVENT_DO_RECOVERY));
        } else {
            if (VDBG) {
                log("onDataStallAlarm: tag=" + tag + " Sent " + String.valueOf(mSentSinceLastRecv) +
                    " pkts since last received, < watchdogTrigger=" + hangWatchdogTrigger);
            }
        }
        startDataStallAlarm();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.469 -0500", hash_original_method = "94396473B615B857A09FF1389DF39C19", hash_generated_method = "A4C614E16E5CD1D91E96A6D12B8D7215")
    
private void updateDataActivity() {
        long sent, received;

        Activity newActivity;

        TxRxSum preTxRxSum = new TxRxSum(mTxPkts, mRxPkts);
        TxRxSum curTxRxSum = new TxRxSum();
        curTxRxSum.updateTxRxSum();
        mTxPkts = curTxRxSum.txPkts;
        mRxPkts = curTxRxSum.rxPkts;

        if (VDBG) {
            log("updateDataActivity: curTxRxSum=" + curTxRxSum + " preTxRxSum=" + preTxRxSum);
        }

        if (mNetStatPollEnabled && (preTxRxSum.txPkts > 0 || preTxRxSum.rxPkts > 0)) {
            sent = mTxPkts - preTxRxSum.txPkts;
            received = mRxPkts - preTxRxSum.rxPkts;

            if (VDBG) log("updateDataActivity: sent=" + sent + " received=" + received);
            if ( sent > 0 && received > 0 ) {
                newActivity = Activity.DATAINANDOUT;
            } else if (sent > 0 && received == 0) {
                newActivity = Activity.DATAOUT;
            } else if (sent == 0 && received > 0) {
                newActivity = Activity.DATAIN;
            } else {
                newActivity = Activity.NONE;
            }

            if (mActivity != newActivity && mIsScreenOn) {
                if (VDBG) log("updateDataActivity: newActivity=" + newActivity);
                mActivity = newActivity;
                mPhone.notifyDataActivity();
            }
        }
    }

    /**
     * Returns true if the last fail cause is something that
     * seems like it deserves an error notification.
     * Transient errors are ignored
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.479 -0500", hash_original_method = "2F0F0316C5E4D930E75010F1BAA9D392", hash_generated_method = "681A781EC2437AC68684B5DBAE6EAD4D")
    
private boolean shouldPostNotification(GsmDataConnection.FailCause  cause) {
        return (cause != GsmDataConnection.FailCause.UNKNOWN);
    }

    /**
     * Return true if data connection need to be setup after disconnected due to
     * reason.
     *
     * @param reason the reason why data is disconnected
     * @return true if try setup data connection is need for this reason
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.483 -0500", hash_original_method = "62A24BB1F647222AA978F8E837B2D330", hash_generated_method = "D168F58C77AFC7F485C17CA9A1350579")
    
private boolean retryAfterDisconnected(String reason) {
        boolean retry = true;

        if ( Phone.REASON_RADIO_TURNED_OFF.equals(reason) ) {
            retry = false;
        }
        return retry;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.489 -0500", hash_original_method = "B5DAD52C5259D76162A701D0CC3F0E5D", hash_generated_method = "9C2F17542C01E416F9B8E10C62DBD19A")
    
private void reconnectAfterFail(FailCause lastFailCauseCode,
                                    ApnContext apnContext, int retryOverride) {
        if (apnContext == null) {
            loge("reconnectAfterFail: apnContext == null, impossible");
            return;
        }
        if ((apnContext.getState() == State.FAILED) &&
            (apnContext.getDataConnection() != null)) {
            if (!apnContext.getDataConnection().isRetryNeeded()) {
                if (!apnContext.getApnType().equals(Phone.APN_TYPE_DEFAULT)) {
                    mPhone.notifyDataConnection(Phone.REASON_APN_FAILED, apnContext.getApnType());
                    return;
                }
                if (mReregisterOnReconnectFailure) {
                    // We've re-registerd once now just retry forever.
                    apnContext.getDataConnection().retryForeverUsingLastTimeout();
                } else {
                    // Try to Re-register to the network.
                    if (DBG) log("reconnectAfterFail: activate failed, Reregistering to network");
                    mReregisterOnReconnectFailure = true;
                    mPhone.getServiceStateTracker().reRegisterNetwork(null);
                    apnContext.getDataConnection().resetRetryCount();
                    return;
                }
            }

            // If retry needs to be backed off for specific case (determined by RIL/Modem)
            // use the specified timer instead of pre-configured retry pattern.
            int nextReconnectDelay = retryOverride;
            if (nextReconnectDelay < 0) {
                nextReconnectDelay = apnContext.getDataConnection().getRetryTimer();
                apnContext.getDataConnection().increaseRetryCount();
            }
            startAlarmForReconnect(nextReconnectDelay, apnContext);

            if (!shouldPostNotification(lastFailCauseCode)) {
                if (DBG) {
                    log("reconnectAfterFail: NOT Posting GPRS Unavailable notification "
                                + "-- likely transient error");
                }
            } else {
                notifyNoData(lastFailCauseCode, apnContext);
            }
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.494 -0500", hash_original_method = "68704E7FD0A79E29C0B17E36042D228F", hash_generated_method = "A8D3F05F1741B0AFF25DC590D901A19F")
    
private void startAlarmForReconnect(int delay, ApnContext apnContext) {

        if (DBG) {
            log("Schedule alarm for reconnect: activate failed. Scheduling next attempt for "
                + (delay / 1000) + "s");
        }

        DataConnectionAc dcac = apnContext.getDataConnectionAc();

        if ((dcac == null) || (dcac.dataConnection == null)) {
            // should not happen, but just in case.
            loge("null dcac or dc.");
            return;
        }

        AlarmManager am =
            (AlarmManager) mPhone.getContext().getSystemService(Context.ALARM_SERVICE);

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

    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.498 -0500", hash_original_method = "752A3E1271AADAA161C9D22B1F08D3F3", hash_generated_method = "85A7D1443FBA2BAA06A6A1B2C7966A94")
    
private void startDataStallAlarm() {
        int delayInMs = Settings.Secure.getInt(mResolver,
                            Settings.Secure.DATA_STALL_ALARM_DELAY_IN_MS,
                            DATA_STALL_ALARM_DELAY_IN_MS_DEFAULT);
        mDataStallAlarmTag += 1;
        if (DBG) {
            log("startDataStallAlarm: tag=" + mDataStallAlarmTag +
                    " delay=" + (delayInMs / 1000) + "s");
        }
        AlarmManager am =
            (AlarmManager) mPhone.getContext().getSystemService(Context.ALARM_SERVICE);

        Intent intent = new Intent(INTENT_DATA_STALL_ALARM);
        intent.putExtra(DATA_STALL_ALARM_TAG_EXTRA, mDataStallAlarmTag);
        mDataStallAlarmIntent = PendingIntent.getBroadcast(mPhone.getContext(), 0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        am.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                SystemClock.elapsedRealtime() + delayInMs, mDataStallAlarmIntent);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.501 -0500", hash_original_method = "9BAB3B8D9CDA09D3CE76C98C24705EFE", hash_generated_method = "451791A6F34E0262DB8E37F3DDD0D7DA")
    
private void stopDataStallAlarm() {
        AlarmManager am =
            (AlarmManager) mPhone.getContext().getSystemService(Context.ALARM_SERVICE);

        if (DBG) {
            log("stopDataStallAlarm: current tag=" + mDataStallAlarmTag +
                    " mDataStallAlarmIntent=" + mDataStallAlarmIntent);
        }
        mDataStallAlarmTag += 1;
        if (mDataStallAlarmIntent != null) {
            am.cancel(mDataStallAlarmIntent);
            mDataStallAlarmIntent = null;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.504 -0500", hash_original_method = "B7B20E847D290047FDFE77B8D734C484", hash_generated_method = "A4AC3EF4714E063ADBAF01C0DA6B03D7")
    
private void notifyNoData(GsmDataConnection.FailCause lastFailCauseCode,
                              ApnContext apnContext) {
        if (DBG) log( "notifyNoData: type=" + apnContext.getApnType());
        apnContext.setState(State.FAILED);
        if (lastFailCauseCode.isPermanentFail()
            && (!apnContext.getApnType().equals(Phone.APN_TYPE_DEFAULT))) {
            mPhone.notifyDataConnectionFailed(apnContext.getReason(), apnContext.getApnType());
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.506 -0500", hash_original_method = "E0D6F2F660096B71ECF89DBFFFD7E4A9", hash_generated_method = "E2E692B7274532DF733628E52C3DE417")
    
private void onRecordsLoaded() {
        if (DBG) log("onRecordsLoaded: createAllApnList");
        createAllApnList();
        if (mPhone.mCM.getRadioState().isOn()) {
            if (DBG) log("onRecordsLoaded: notifying data availability");
            notifyOffApnsOfAvailability(Phone.REASON_SIM_LOADED);
        }
        setupDataOnReadyApns(Phone.REASON_SIM_LOADED);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.510 -0500", hash_original_method = "4B71314721E8EC7414109EE47221FD04", hash_generated_method = "A4E50CF3379CC766023BAB8FB044F638")
    
@Override
    protected void onSetDependencyMet(String apnType, boolean met) {
        // don't allow users to tweak hipri to work around default dependency not met
        if (Phone.APN_TYPE_HIPRI.equals(apnType)) return;

        ApnContext apnContext = mApnContexts.get(apnType);
        if (apnContext == null) {
            loge("onSetDependencyMet: ApnContext not found in onSetDependencyMet(" +
                    apnType + ", " + met + ")");
            return;
        }
        applyNewState(apnContext, apnContext.isEnabled(), met);
        if (Phone.APN_TYPE_DEFAULT.equals(apnType)) {
            // tie actions on default to similar actions on HIPRI regarding dependencyMet
            apnContext = mApnContexts.get(Phone.APN_TYPE_HIPRI);
            if (apnContext != null) applyNewState(apnContext, apnContext.isEnabled(), met);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.516 -0500", hash_original_method = "99E85476A8EB35B364BDD45037DA3C4C", hash_generated_method = "A3E5BDE64D386629286A6585A4079858")
    
private void applyNewState(ApnContext apnContext, boolean enabled, boolean met) {
        boolean cleanup = false;
        boolean trySetup = false;
        if (DBG) {
            log("applyNewState(" + apnContext.getApnType() + ", " + enabled +
                    "(" + apnContext.isEnabled() + "), " + met + "(" +
                    apnContext.getDependencyMet() +"))");
        }
        if (apnContext.isReady()) {
            if (enabled && met) return;
            if (!enabled) {
                apnContext.setReason(Phone.REASON_DATA_DISABLED);
            } else {
                apnContext.setReason(Phone.REASON_DATA_DEPENDENCY_UNMET);
            }
            cleanup = true;
        } else {
            if (enabled && met) {
                if (apnContext.isEnabled()) {
                    apnContext.setReason(Phone.REASON_DATA_DEPENDENCY_MET);
                } else {
                    apnContext.setReason(Phone.REASON_DATA_ENABLED);
                }
                if (apnContext.getState() == State.FAILED) {
                    apnContext.setState(State.IDLE);
                }
                trySetup = true;
            }
        }
        apnContext.setEnabled(enabled);
        apnContext.setDependencyMet(met);
        if (cleanup) cleanUpConnection(true, apnContext);
        if (trySetup) trySetupData(apnContext);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.521 -0500", hash_original_method = "CD0E8AA9DA59D5F15CB3DBA9C10480A3", hash_generated_method = "3851297CE6E6FE53920FEEDD4FD03638")
    
private DataConnection checkForConnectionForApnContext(ApnContext apnContext) {
        // Loop through all apnContexts looking for one with a conn that satisfies this apnType
        String apnType = apnContext.getApnType();
        ApnSetting dunSetting = null;

        if (Phone.APN_TYPE_DUN.equals(apnType)) {
            dunSetting = fetchDunApn();
        }

        for (ApnContext c : mApnContexts.values()) {
            DataConnection conn = c.getDataConnection();
            if (conn != null) {
                ApnSetting apnSetting = c.getApnSetting();
                if (dunSetting != null) {
                    if (dunSetting.equals(apnSetting)) {
                        if (DBG) {
                            log("checkForConnectionForApnContext: apnContext=" + apnContext +
                                    " found conn=" + conn);
                        }
                        return conn;
                    }
                } else if (apnSetting != null && apnSetting.canHandleType(apnType)) {
                    if (DBG) {
                        log("checkForConnectionForApnContext: apnContext=" + apnContext +
                                " found conn=" + conn);
                    }
                    return conn;
                }
            }
        }
        if (DBG) log("checkForConnectionForApnContext: apnContext=" + apnContext + " NO conn");
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.526 -0500", hash_original_method = "C4FAA9463FB18AA2956D630E0A7A0FC4", hash_generated_method = "388EBCF594662564A2F13B1558348269")
    
@Override
    protected void onEnableApn(int apnId, int enabled) {
        ApnContext apnContext = mApnContexts.get(apnIdToType(apnId));
        if (apnContext == null) {
            loge("onEnableApn(" + apnId + ", " + enabled + "): NO ApnContext");
            return;
        }
        // TODO change our retry manager to use the appropriate numbers for the new APN
        if (DBG) log("onEnableApn: apnContext=" + apnContext + " call applyNewState");
        applyNewState(apnContext, enabled == ENABLED, apnContext.getDependencyMet());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.531 -0500", hash_original_method = "885166865223FFC382706A95C40269FC", hash_generated_method = "0185593C10C91A732A7922F9F21DED02")
    
@Override
    // TODO: We shouldnt need this.
    protected boolean onTrySetupData(String reason) {
        if (DBG) log("onTrySetupData: reason=" + reason);
        setupDataOnReadyApns(reason);
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.535 -0500", hash_original_method = "0F081CC5E381F07585D5A8591D9B8176", hash_generated_method = "6135CBC65297667518D3CE4BBCFB5593")
    
protected boolean onTrySetupData(ApnContext apnContext) {
        if (DBG) log("onTrySetupData: apnContext=" + apnContext);
        return trySetupData(apnContext);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.540 -0500", hash_original_method = "94279F194E7EEE60FDEB34DD3123F420", hash_generated_method = "BE22F4DD2007022DB999979806923F79")
    
@Override
    protected void onRoamingOff() {
        if (DBG) log("onRoamingOff");

        if (getDataOnRoamingEnabled() == false) {
            notifyOffApnsOfAvailability(Phone.REASON_ROAMING_OFF);
            setupDataOnReadyApns(Phone.REASON_ROAMING_OFF);
        } else {
            notifyDataConnection(Phone.REASON_ROAMING_OFF);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.544 -0500", hash_original_method = "F695F1E8C2AB53D2ED55D91C043A1972", hash_generated_method = "F8031BD81B222E4DBC8F59F1181B8DAC")
    
@Override
    protected void onRoamingOn() {
        if (getDataOnRoamingEnabled()) {
            if (DBG) log("onRoamingOn: setup data on roaming");
            setupDataOnReadyApns(Phone.REASON_ROAMING_ON);
            notifyDataConnection(Phone.REASON_ROAMING_ON);
        } else {
            if (DBG) log("onRoamingOn: Tear down data connection on roaming.");
            cleanUpAllConnections(true, Phone.REASON_ROAMING_ON);
            notifyOffApnsOfAvailability(Phone.REASON_ROAMING_ON);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.547 -0500", hash_original_method = "2023A2D13D03549C0A5EFF7393A0A72A", hash_generated_method = "38E3610B15176F7B35E7B4B4E1C6DD64")
    
@Override
    protected void onRadioAvailable() {
        if (DBG) log("onRadioAvailable");
        if (mPhone.getSimulatedRadioControl() != null) {
            // Assume data is connected on the simulator
            // FIXME  this can be improved
            // setState(State.CONNECTED);
            notifyDataConnection(null);

            log("onRadioAvailable: We're on the simulator; assuming data is connected");
        }

        if (mPhone.mIccRecords.getRecordsLoaded()) {
            notifyOffApnsOfAvailability(null);
        }

        if (getOverallState() != State.IDLE) {
            cleanUpConnection(true, null);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.550 -0500", hash_original_method = "3A8D622B44F84A55C5B45212A617D18F", hash_generated_method = "19BB8FB68B50D6D8BA1D8CE80FE508BF")
    
@Override
    protected void onRadioOffOrNotAvailable() {
        // Make sure our reconnect delay starts at the initial value
        // next time the radio comes on

        for (DataConnection dc : mDataConnections.values()) {
            dc.resetRetryCount();
        }
        mReregisterOnReconnectFailure = false;

        if (mPhone.getSimulatedRadioControl() != null) {
            // Assume data is connected on the simulator
            // FIXME  this can be improved
            log("We're on the simulator; assuming radio off is meaningless");
        } else {
            if (DBG) log("onRadioOffOrNotAvailable: is off and clean up all connections");
            cleanUpAllConnections(false, Phone.REASON_RADIO_TURNED_OFF);
        }
        notifyOffApnsOfAvailability(null);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.555 -0500", hash_original_method = "31196134743B1AB9B97F59AB7F4DD6B0", hash_generated_method = "C870D80AF9AB55A2E03CDE276B2D189D")
    
@Override
    protected void onDataSetupComplete(AsyncResult ar) {

        ApnContext apnContext = null;

        if(ar.userObj instanceof ApnContext){
            apnContext = (ApnContext)ar.userObj;
        } else {
            throw new RuntimeException("onDataSetupComplete: No apnContext");
        }

        if (isDataSetupCompleteOk(ar)) {
            DataConnectionAc dcac = apnContext.getDataConnectionAc();
            if (dcac == null) {
                throw new RuntimeException("onDataSetupCompete: No dcac");
            }
            DataConnection dc = apnContext.getDataConnection();

            if (DBG) {
                // TODO We may use apnContext.getApnSetting() directly
                // instead of getWaitingApns().get(0)
                String apnStr = "<unknown>";
                if (apnContext.getWaitingApns() != null
                        && !apnContext.getWaitingApns().isEmpty()){
                    apnStr = apnContext.getWaitingApns().get(0).apn;
                }
                log("onDataSetupComplete: success apn=" + apnStr);
            }
            ApnSetting apn = apnContext.getApnSetting();
            if (apn.proxy != null && apn.proxy.length() != 0) {
                try {
                    String port = apn.port;
                    if (TextUtils.isEmpty(port)) port = "8080";
                    ProxyProperties proxy = new ProxyProperties(apn.proxy,
                            Integer.parseInt(port), null);
                    dcac.setLinkPropertiesHttpProxySync(proxy);
                } catch (NumberFormatException e) {
                    loge("onDataSetupComplete: NumberFormatException making ProxyProperties (" +
                            apn.port + "): " + e);
                }
            }

            // everything is setup
            if(TextUtils.equals(apnContext.getApnType(),Phone.APN_TYPE_DEFAULT)) {
                SystemProperties.set("gsm.defaultpdpcontext.active", "true");
                if (canSetPreferApn && mPreferredApn == null) {
                    if (DBG) log("onDataSetupComplete: PREFERED APN is null");
                    mPreferredApn = apnContext.getApnSetting();
                    if (mPreferredApn != null) {
                        setPreferredApn(mPreferredApn.id);
                    }
                }
            } else {
                SystemProperties.set("gsm.defaultpdpcontext.active", "false");
            }
            notifyDefaultData(apnContext);
        } else {
            String apnString;
            DataConnection.FailCause cause;

            cause = (DataConnection.FailCause) (ar.result);
            if (DBG) {
                try {
                    apnString = apnContext.getWaitingApns().get(0).apn;
                } catch (Exception e) {
                    apnString = "<unknown>";
                }
                log(String.format("onDataSetupComplete: error apn=%s cause=%s", apnString, cause));
            }
            if (cause.isEventLoggable()) {
                // Log this failure to the Event Logs.
                int cid = getCellLocationId();
                EventLog.writeEvent(EventLogTags.PDP_SETUP_FAIL,
                        cause.ordinal(), cid, TelephonyManager.getDefault().getNetworkType());
            }

            // Count permanent failures and remove the APN we just tried
            if (cause.isPermanentFail()) apnContext.decWaitingApnsPermFailCount();

            apnContext.removeNextWaitingApn();
            if (DBG) {
                log(String.format("onDataSetupComplete: WaitingApns.size=%d" +
                        " WaitingApnsPermFailureCountDown=%d",
                        apnContext.getWaitingApns().size(),
                        apnContext.getWaitingApnsPermFailCount()));
            }

            // See if there are more APN's to try
            if (apnContext.getWaitingApns().isEmpty()) {
                if (apnContext.getWaitingApnsPermFailCount() == 0) {
                    if (DBG) {
                        log("onDataSetupComplete: All APN's had permanent failures, stop retrying");
                    }
                    apnContext.setState(State.FAILED);
                    mPhone.notifyDataConnection(Phone.REASON_APN_FAILED, apnContext.getApnType());

                    apnContext.setDataConnection(null);
                    apnContext.setDataConnectionAc(null);
                    if (DBG) {
                        log("onDataSetupComplete: permanent error apn=%s" + apnString );
                    }
                } else {
                    if (DBG) log("onDataSetupComplete: Not all permanent failures, retry");
                    // check to see if retry should be overridden for this failure.
                    int retryOverride = -1;
                    if (ar.exception instanceof DataConnection.CallSetupException) {
                        retryOverride =
                            ((DataConnection.CallSetupException)ar.exception).getRetryOverride();
                    }
                    if (retryOverride == RILConstants.MAX_INT) {
                        if (DBG) log("No retry is suggested.");
                    } else {
                        startDelayedRetry(cause, apnContext, retryOverride);
                    }
                }
            } else {
                if (DBG) log("onDataSetupComplete: Try next APN");
                apnContext.setState(State.SCANNING);
                // Wait a bit before trying the next APN, so that
                // we're not tying up the RIL command channel
                startAlarmForReconnect(APN_DELAY_MILLIS, apnContext);
            }
        }
    }

    /**
     * Called when EVENT_DISCONNECT_DONE is received.
     */
    @DSSink({DSSinkKind.PHONE_CONNECTION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.558 -0500", hash_original_method = "D4180B029AFCA66C11673889FF654292", hash_generated_method = "0CFCD8979FEB552E8BECCD6E367673FE")
    
@Override
    protected void onDisconnectDone(int connId, AsyncResult ar) {
        ApnContext apnContext = null;

        if(DBG) log("onDisconnectDone: EVENT_DISCONNECT_DONE connId=" + connId);
        if (ar.userObj instanceof ApnContext) {
            apnContext = (ApnContext) ar.userObj;
        } else {
            loge("Invalid ar in onDisconnectDone");
            return;
        }

        apnContext.setState(State.IDLE);

        mPhone.notifyDataConnection(apnContext.getReason(), apnContext.getApnType());

        // if all data connection are gone, check whether Airplane mode request was
        // pending.
        if (isDisconnected()) {
            if (mPhone.getServiceStateTracker().processPendingRadioPowerOffAfterDataOff()) {
                // Radio will be turned off. No need to retry data setup
                apnContext.setApnSetting(null);
                apnContext.setDataConnection(null);
                apnContext.setDataConnectionAc(null);
                return;
            }
        }

        // If APN is still enabled, try to bring it back up automatically
        if (apnContext.isReady() && retryAfterDisconnected(apnContext.getReason())) {
            SystemProperties.set("gsm.defaultpdpcontext.active", "false");  // TODO - what the heck?  This shoudld go
            // Wait a bit before trying the next APN, so that
            // we're not tying up the RIL command channel.
            // This also helps in any external dependency to turn off the context.
            startAlarmForReconnect(APN_DELAY_MILLIS, apnContext);
        } else {
            apnContext.setApnSetting(null);
            apnContext.setDataConnection(null);
            apnContext.setDataConnectionAc(null);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.561 -0500", hash_original_method = "F62EA026E4AEAA1F320C05AA5A1ED4A9", hash_generated_method = "475B334D05ED67F65C07E579F6B5889A")
    
protected void onPollPdp() {
        if (getOverallState() == State.CONNECTED) {
            // only poll when connected
            mPhone.mCM.getDataCallList(this.obtainMessage(EVENT_DATA_STATE_CHANGED));
            sendMessageDelayed(obtainMessage(EVENT_POLL_PDP), POLL_PDP_MILLIS);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.565 -0500", hash_original_method = "7D6F87E7A2D5372F8DAAC4AE4D373312", hash_generated_method = "8EDAFA7946D3A72CCE5D485ACCAD3888")
    
@Override
    protected void onVoiceCallStarted() {
        if (DBG) log("onVoiceCallStarted");
        if (isConnected() && ! mPhone.getServiceStateTracker().isConcurrentVoiceAndDataAllowed()) {
            if (DBG) log("onVoiceCallStarted stop polling");
            stopNetStatPoll();
            stopDataStallAlarm();
            notifyDataConnection(Phone.REASON_VOICE_CALL_STARTED);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.570 -0500", hash_original_method = "F668A2FA6E26D3D907651D9C8494921A", hash_generated_method = "74966A116C40A574F981C640EEA2D2E5")
    
@Override
    protected void onVoiceCallEnded() {
        if (DBG) log("onVoiceCallEnded");
        if (isConnected()) {
            if (!mPhone.getServiceStateTracker().isConcurrentVoiceAndDataAllowed()) {
                startNetStatPoll();
                startDataStallAlarm();
                notifyDataConnection(Phone.REASON_VOICE_CALL_ENDED);
            } else {
                // clean slate after call end.
                resetPollStats();
            }
        } else {
            // reset reconnect timer
            setupDataOnReadyApns(Phone.REASON_VOICE_CALL_ENDED);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.573 -0500", hash_original_method = "2BB2576C993A3562ED602CBB829AED3C", hash_generated_method = "6B6B8864B6E089D5CCFFDD462C0763CC")
    
@Override
    protected void onCleanUpConnection(boolean tearDown, int apnId, String reason) {
        if (DBG) log("onCleanUpConnection");
        ApnContext apnContext = mApnContexts.get(apnIdToType(apnId));
        if (apnContext != null) {
            apnContext.setReason(reason);
            cleanUpConnection(tearDown, apnContext);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.576 -0500", hash_original_method = "F3A5D3BC82C41DBBBC23CC041FBF5A0E", hash_generated_method = "0F9D9580F25DD693E952CA115203244E")
    
protected boolean isConnected() {
        for (ApnContext apnContext : mApnContexts.values()) {
            if (apnContext.getState() == State.CONNECTED) {
                // At least one context is connected, return true
                return true;
            }
        }
        // There are not any contexts connected, return false
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.578 -0500", hash_original_method = "82B1D5E02818D0100BE3FB5300291D89", hash_generated_method = "9A65AC62E9AF61AE8C11C8CE5FA2E584")
    
@Override
    public boolean isDisconnected() {
        for (ApnContext apnContext : mApnContexts.values()) {
            if (!apnContext.isDisconnected()) {
                // At least one context was not disconnected return false
                return false;
            }
        }
        // All contexts were disconnected so return true
        return true;
    }

    @DSSink({DSSinkKind.PHONE_STATE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.581 -0500", hash_original_method = "85B9B626BCFF754F4C98AF3615661037", hash_generated_method = "64393B861CF6A8AAA352323D18D6F93D")
    
@Override
    protected void notifyDataConnection(String reason) {
        if (DBG) log("notifyDataConnection: reason=" + reason);
        for (ApnContext apnContext : mApnContexts.values()) {
            if (apnContext.isReady()) {
                if (DBG) log("notifyDataConnection: type:"+apnContext.getApnType());
                mPhone.notifyDataConnection(reason != null ? reason : apnContext.getReason(),
                        apnContext.getApnType());
            }
        }
        notifyOffApnsOfAvailability(reason);
    }

    /**
     * Based on the sim operator numeric, create a list for all possible
     * Data Connections and setup the preferredApn.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.584 -0500", hash_original_method = "FAE53DB9273E730E3BB3527C1EA0C82D", hash_generated_method = "8434F909E03B4589EDAD548442697F2B")
    
private void createAllApnList() {
        mAllApns = new ArrayList<ApnSetting>();
        String operator = mPhone.mIccRecords.getOperatorNumeric();
        if (operator != null) {
            String selection = "numeric = '" + operator + "'";
            // query only enabled apn.
            // carrier_enabled : 1 means enabled apn, 0 disabled apn.
            selection += " and carrier_enabled = 1";
            if (DBG) log("createAllApnList: selection=" + selection);

            Cursor cursor = mPhone.getContext().getContentResolver().query(
                    Telephony.Carriers.CONTENT_URI, null, selection, null, null);

            if (cursor != null) {
                if (cursor.getCount() > 0) {
                    mAllApns = createApnList(cursor);
                }
                cursor.close();
            }
        }

        if (mAllApns.isEmpty()) {
            if (DBG) log("createAllApnList: No APN found for carrier: " + operator);
            mPreferredApn = null;
            // TODO: What is the right behaviour?
            //notifyNoData(GsmDataConnection.FailCause.MISSING_UNKNOWN_APN);
        } else {
            mPreferredApn = getPreferredApn();
            if (mPreferredApn != null && !mPreferredApn.numeric.equals(operator)) {
                mPreferredApn = null;
                setPreferredApn(-1);
            }
            if (DBG) log("createAllApnList: mPreferredApn=" + mPreferredApn);
        }
        if (DBG) log("createAllApnList: X mAllApns=" + mAllApns);
    }

    /** Return the id for a new data connection */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.587 -0500", hash_original_method = "5EA4CC699810E4F50A6EFC012301B7BB", hash_generated_method = "0BA4858ECD5A4BD94F468B1B6F8520E2")
    
private GsmDataConnection createDataConnection() {
        if (DBG) log("createDataConnection E");

        RetryManager rm = new RetryManager();
        int id = mUniqueIdGenerator.getAndIncrement();
        GsmDataConnection conn = GsmDataConnection.makeDataConnection(mPhone, id, rm);
        mDataConnections.put(id, conn);
        DataConnectionAc dcac = new DataConnectionAc(conn, LOG_TAG);
        int status = dcac.fullyConnectSync(mPhone.getContext(), this, conn.getHandler());
        if (status == AsyncChannel.STATUS_SUCCESSFUL) {
            mDataConnectionAsyncChannels.put(dcac.dataConnection.getDataConnectionId(), dcac);
        } else {
            loge("createDataConnection: Could not connect to dcac.mDc=" + dcac.dataConnection +
                    " status=" + status);
        }

        // install reconnect intent filter for this data connection.
        IntentFilter filter = new IntentFilter();
        filter.addAction(INTENT_RECONNECT_ALARM + '.' + id);
        mPhone.getContext().registerReceiver(mIntentReceiver, filter, null, mPhone);

        if (DBG) log("createDataConnection() X id=" + id);
        return conn;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.591 -0500", hash_original_method = "E3018B8151F871DAB6348A26AB9C8E22", hash_generated_method = "C9C5656F402CDB474A212F9A863DEED5")
    
private void configureRetry(DataConnection dc, boolean forDefault) {
        if (dc == null) return;

        if (!dc.configureRetry(getReryConfig(forDefault))) {
            if (forDefault) {
                if (!dc.configureRetry(DEFAULT_DATA_RETRY_CONFIG)) {
                    // Should never happen, log an error and default to a simple linear sequence.
                    loge("configureRetry: Could not configure using " +
                            "DEFAULT_DATA_RETRY_CONFIG=" + DEFAULT_DATA_RETRY_CONFIG);
                    dc.configureRetry(20, 2000, 1000);
                }
            } else {
                if (!dc.configureRetry(SECONDARY_DATA_RETRY_CONFIG)) {
                    // Should never happen, log an error and default to a simple sequence.
                    loge("configureRetry: Could note configure using " +
                            "SECONDARY_DATA_RETRY_CONFIG=" + SECONDARY_DATA_RETRY_CONFIG);
                    dc.configureRetry("max_retries=3, 333, 333, 333");
                }
            }
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.594 -0500", hash_original_method = "3AA2B8847F1D4D39DED653A1D9ABBA74", hash_generated_method = "C1137FAFEFB49822FA777F99D0AE97DB")
    
private void destroyDataConnections() {
        if(mDataConnections != null) {
            if (DBG) log("destroyDataConnections: clear mDataConnectionList");
            mDataConnections.clear();
        } else {
            if (DBG) log("destroyDataConnections: mDataConnecitonList is empty, ignore");
        }
    }

    /**
     * Build a list of APNs to be used to create PDP's.
     *
     * @param requestedApnType
     * @return waitingApns list to be used to create PDP
     *          error when waitingApns.isEmpty()
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.597 -0500", hash_original_method = "848BE9CB29607B1E2AFE44721BE481D7", hash_generated_method = "C3456B90876EA554F99D5D9A6A620D47")
    
private ArrayList<ApnSetting> buildWaitingApns(String requestedApnType) {
        ArrayList<ApnSetting> apnList = new ArrayList<ApnSetting>();

        if (requestedApnType.equals(Phone.APN_TYPE_DUN)) {
            ApnSetting dun = fetchDunApn();
            if (dun != null) {
                apnList.add(dun);
                if (DBG) log("buildWaitingApns: X added APN_TYPE_DUN apnList=" + apnList);
                return apnList;
            }
        }

        String operator = mPhone.mIccRecords.getOperatorNumeric();
        int radioTech = mPhone.getServiceState().getRadioTechnology();

        if (requestedApnType.equals(Phone.APN_TYPE_DEFAULT)) {
            if (canSetPreferApn && mPreferredApn != null) {
                if (DBG) {
                    log("buildWaitingApns: Preferred APN:" + operator + ":"
                        + mPreferredApn.numeric + ":" + mPreferredApn);
                }
                if (mPreferredApn.numeric.equals(operator)) {
                    if (mPreferredApn.bearer == 0 || mPreferredApn.bearer == radioTech) {
                        apnList.add(mPreferredApn);
                        if (DBG) log("buildWaitingApns: X added preferred apnList=" + apnList);
                        return apnList;
                    } else {
                        if (DBG) log("buildWaitingApns: no preferred APN");
                        setPreferredApn(-1);
                        mPreferredApn = null;
                    }
                } else {
                    if (DBG) log("buildWaitingApns: no preferred APN");
                    setPreferredApn(-1);
                    mPreferredApn = null;
                }
            }
        }
        if (mAllApns != null) {
            for (ApnSetting apn : mAllApns) {
                if (apn.canHandleType(requestedApnType)) {
                    if (apn.bearer == 0 || apn.bearer == radioTech) {
                        if (DBG) log("apn info : " +apn.toString());
                        apnList.add(apn);
                    }
                }
            }
        } else {
            loge("mAllApns is empty!");
        }
        if (DBG) log("buildWaitingApns: X apnList=" + apnList);
        return apnList;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.600 -0500", hash_original_method = "E41D316825399ADA7868FFC16CE8AB28", hash_generated_method = "51EFF3E91EBC9C2E27E278C75F133544")
    
private String apnListToString (ArrayList<ApnSetting> apns) {
        StringBuilder result = new StringBuilder();
        for (int i = 0, size = apns.size(); i < size; i++) {
            result.append('[')
                  .append(apns.get(i).toString())
                  .append(']');
        }
        return result.toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.603 -0500", hash_original_method = "3866195B872E529451BB06B2525880D5", hash_generated_method = "3F8BC985DD0F309DF2A705C6E18E79DA")
    
private void startDelayedRetry(GsmDataConnection.FailCause cause,
                                   ApnContext apnContext, int retryOverride) {
        notifyNoData(cause, apnContext);
        reconnectAfterFail(cause, apnContext, retryOverride);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.606 -0500", hash_original_method = "A60F121DAB80740EFF8A86C7BC5BA500", hash_generated_method = "84A620A49767372C8F304DAB1FD5126A")
    
private void setPreferredApn(int pos) {
        if (!canSetPreferApn) {
            return;
        }

        ContentResolver resolver = mPhone.getContext().getContentResolver();
        resolver.delete(PREFERAPN_URI, null, null);

        if (pos >= 0) {
            ContentValues values = new ContentValues();
            values.put(APN_ID, pos);
            resolver.insert(PREFERAPN_URI, values);
        }
    }
    
    private class ApnChangeObserver extends ContentObserver {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.244 -0500", hash_original_method = "6B7B68FCD4064976D9DFC8282278DEB2", hash_generated_method = "18735F46BE4E032E84106EF845DF0BDE")
        
public ApnChangeObserver () {
            super(mDataConnectionTracker);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.249 -0500", hash_original_method = "C002DCEBDDA1BCF98FA65E6C3DFBEDC7", hash_generated_method = "6FEC07385EF4561BB4CCC313491AEE61")
        
@Override
        public void onChange(boolean selfChange) {
            sendMessage(obtainMessage(EVENT_APN_CHANGED));
        }
        
    }
    
    class RecoveryAction {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.263 -0500", hash_original_field = "B1BC5B86C343AFE2CAC02DC48AF5EB0D", hash_generated_field = "9444F7385ED075FD957CBF2705B431F2")

        public static final int GET_DATA_CALL_LIST      = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.266 -0500", hash_original_field = "411745859EA6E8161F5CC8AF3A4EC2ED", hash_generated_field = "C5F9F5C8FD7BE9C11274D2A4D79064AC")

        public static final int CLEANUP                 = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.269 -0500", hash_original_field = "04CF52EB9E9BE689938C67A7045AA479", hash_generated_field = "78C8CA1646CB6F57C71EDA35CC71F4A7")

        public static final int REREGISTER              = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.272 -0500", hash_original_field = "072F7D450E201C10AF1D69C3738177D2", hash_generated_field = "B5EDD1906682D24DD1AADF7FCCE7CBB3")

        public static final int RADIO_RESTART           = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.275 -0500", hash_original_field = "D77B838F666A2F28554F0780987DFF1E", hash_generated_field = "F6B83BCA43B3D6989BC81E37B804B55C")

        public static final int RADIO_RESTART_WITH_PROP = 4;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.747 -0400", hash_original_method = "32173E3A0316410E8650FB75524992A2", hash_generated_method = "32173E3A0316410E8650FB75524992A2")
        public RecoveryAction ()
        {
            //Synthesized constructor
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.609 -0500", hash_original_method = "C73C211081CDB852B85A3162F1169F83", hash_generated_method = "76033FCFACDDDF9F1E92955EC0353258")
    
private ApnSetting getPreferredApn() {
        if (mAllApns.isEmpty()) {
            return null;
        }

        Cursor cursor = mPhone.getContext().getContentResolver().query(
                PREFERAPN_URI, new String[] { "_id", "name", "apn" },
                null, null, Telephony.Carriers.DEFAULT_SORT_ORDER);

        if (cursor != null) {
            canSetPreferApn = true;
        } else {
            canSetPreferApn = false;
        }

        if (canSetPreferApn && cursor.getCount() > 0) {
            int pos;
            cursor.moveToFirst();
            pos = cursor.getInt(cursor.getColumnIndexOrThrow(Telephony.Carriers._ID));
            for(ApnSetting p:mAllApns) {
                if (p.id == pos && p.canHandleType(mRequestedApnType)) {
                    cursor.close();
                    return p;
                }
            }
        }

        if (cursor != null) {
            cursor.close();
        }

        return null;
    }

    @DSSafe(DSCat.IPC_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.613 -0500", hash_original_method = "AE6FD47652B0A19C805CE62DFEA0E86E", hash_generated_method = "79300E137E121C247946983526D12410")
    
@Override
    public void handleMessage (Message msg) {
        if (DBG) log("handleMessage msg=" + msg);

        if (!mPhone.mIsTheCurrentActivePhone || mIsDisposed) {
            loge("handleMessage: Ignore GSM msgs since GSM phone is inactive");
            return;
        }

        switch (msg.what) {
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
                /**
                 * We don't need to explicitly to tear down the PDP context
                 * when PS restricted is enabled. The base band will deactive
                 * PDP context and notify us with PDP_CONTEXT_CHANGED.
                 * But we should stop the network polling and prevent reset PDP.
                 */
                if (DBG) log("EVENT_PS_RESTRICT_ENABLED " + mIsPsRestricted);
                stopNetStatPoll();
                stopDataStallAlarm();
                mIsPsRestricted = true;
                break;

            case EVENT_PS_RESTRICT_DISABLED:
                /**
                 * When PS restrict is removed, we need setup PDP connection if
                 * PDP connection is down.
                 */
                if (DBG) log("EVENT_PS_RESTRICT_DISABLED " + mIsPsRestricted);
                mIsPsRestricted  = false;
                if (isConnected()) {
                    startNetStatPoll();
                    startDataStallAlarm();
                } else {
                    // TODO: Should all PDN states be checked to fail?
                    if (mState == State.FAILED) {
                        cleanUpAllConnections(false, Phone.REASON_PS_RESTRICT_ENABLED);
                        resetAllRetryCounts();
                        mReregisterOnReconnectFailure = false;
                    }
                    trySetupData(Phone.REASON_PS_RESTRICT_ENABLED, Phone.APN_TYPE_DEFAULT);
                }
                break;
            case EVENT_TRY_SETUP_DATA:
                if (msg.obj instanceof ApnContext) {
                    onTrySetupData((ApnContext)msg.obj);
                } else if (msg.obj instanceof String) {
                    onTrySetupData((String)msg.obj);
                } else {
                    loge("EVENT_TRY_SETUP request w/o apnContext or String");
                }
                break;

            case EVENT_CLEAN_UP_CONNECTION:
                boolean tearDown = (msg.arg1 == 0) ? false : true;
                if (DBG) log("EVENT_CLEAN_UP_CONNECTION tearDown=" + tearDown);
                if (msg.obj instanceof ApnContext) {
                    cleanUpConnection(tearDown, (ApnContext)msg.obj);
                } else {
                    loge("EVENT_CLEAN_UP_CONNECTION request w/o apn context");
                }
                break;
            default:
                // handle the message in the super class DataConnectionTracker
                super.handleMessage(msg);
                break;
        }
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.616 -0500", hash_original_method = "46AFDD0964E9004EF08AD58B2795A021", hash_generated_method = "C508FDF04104DD6BFFA574041A143375")
    
protected int getApnProfileID(String apnType) {
        if (TextUtils.equals(apnType, Phone.APN_TYPE_IMS)) {
            return RILConstants.DATA_PROFILE_IMS;
        } else if (TextUtils.equals(apnType, Phone.APN_TYPE_FOTA)) {
            return RILConstants.DATA_PROFILE_FOTA;
        } else if (TextUtils.equals(apnType, Phone.APN_TYPE_CBS)) {
            return RILConstants.DATA_PROFILE_CBS;
        } else {
            return RILConstants.DATA_PROFILE_DEFAULT;
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.619 -0500", hash_original_method = "EC98DB8AAEBCEBF774D7D372A9BC5BED", hash_generated_method = "BF0DCD56F5DC06CC9A7BCFD522065FEB")
    
private int getCellLocationId() {
        int cid = -1;
        CellLocation loc = mPhone.getCellLocation();

        if (loc != null) {
            if (loc instanceof GsmCellLocation) {
                cid = ((GsmCellLocation)loc).getCid();
            } else if (loc instanceof CdmaCellLocation) {
                cid = ((CdmaCellLocation)loc).getBaseStationId();
            }
        }
        return cid;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.622 -0500", hash_original_method = "74A1E45944BDF6EB75FE1BB75B450C28", hash_generated_method = "60F20D945104B116B333F130426939CE")
    
@Override
    protected void log(String s) {
        Log.d(LOG_TAG, "[GsmDCT] "+ s);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:24.624 -0500", hash_original_method = "F4E978940BCE74A01AFD260967E7D0F1", hash_generated_method = "3750F28C95152AB6E7995DB65D485CBF")
    
@Override
    protected void loge(String s) {
        Log.e(LOG_TAG, "[GsmDCT] " + s);
    }
}

