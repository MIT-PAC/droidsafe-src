package com.android.internal.telephony.cdma;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.telephony.CommandException;
import com.android.internal.telephony.CommandsInterface;
import com.android.internal.telephony.DataConnectionTracker;
import com.android.internal.telephony.EventLogTags;
import com.android.internal.telephony.IccCard;
import com.android.internal.telephony.MccTable;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.ServiceStateTracker;
import com.android.internal.telephony.TelephonyIntents;
import com.android.internal.telephony.TelephonyProperties;
import android.app.AlarmManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.os.AsyncResult;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.os.Registrant;
import android.os.RegistrantList;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.provider.Settings;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Telephony.Intents;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.util.EventLog;
import android.util.Log;
import android.util.TimeUtils;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class CdmaServiceStateTracker extends ServiceStateTracker {
    CDMAPhone phone;
    CdmaCellLocation cellLoc;
    CdmaCellLocation newCellLoc;
    int mCurrentOtaspMode = OTASP_UNINITIALIZED;
    private int mNitzUpdateSpacing = SystemProperties.getInt("ro.nitz_update_spacing",
            NITZ_UPDATE_SPACING_DEFAULT);
    private int mNitzUpdateDiff = SystemProperties.getInt("ro.nitz_update_diff",
            NITZ_UPDATE_DIFF_DEFAULT);
    protected int networkType = 0;
    protected int newNetworkType = 0;
    private boolean mCdmaRoaming = false;
    private int mRoamingIndicator;
    private boolean mIsInPrl;
    private int mDefaultRoamingIndicator;
    protected int mDataConnectionState = ServiceState.STATE_OUT_OF_SERVICE;
    protected int mNewDataConnectionState = ServiceState.STATE_OUT_OF_SERVICE;
    protected int mRegistrationState = -1;
    protected RegistrantList cdmaForSubscriptionInfoReadyRegistrants = new RegistrantList();
    protected boolean mNeedFixZone = false;
    private int mZoneOffset;
    private boolean mZoneDst;
    private long mZoneTime;
    protected boolean mGotCountryCode = false;
    String mSavedTimeZone;
    long mSavedTime;
    long mSavedAtTime;
    private boolean mNeedToRegForRuimLoaded = false;
    private PowerManager.WakeLock mWakeLock;
    protected String mCurPlmn = null;
    protected String mMdn;
    protected int mHomeSystemId[] = null;
    protected int mHomeNetworkId[] = null;
    protected String mMin;
    protected String mPrlVersion;
    protected boolean mIsMinInfoReady = false;
    private boolean isEriTextLoaded = false;
    protected boolean isSubscriptionFromRuim = false;
    private String mRegistrationDeniedReason;
    private ContentResolver cr;
    private String currentCarrier = null;
    private ContentObserver mAutoTimeObserver = new ContentObserver(new Handler()) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.744 -0400", hash_original_method = "6B8D04F75A24E09E038AB230F1FA031E", hash_generated_method = "5EA51F759B1C2124A60EFAB7A687EE49")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void onChange(boolean selfChange) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(selfChange);
            log("Auto time state changed");
            revertToNitzTime();
            // ---------- Original Method ----------
            //if (DBG) log("Auto time state changed");
            //revertToNitzTime();
        }

        
}; //Transformed anonymous class
    private ContentObserver mAutoTimeZoneObserver = new ContentObserver(new Handler()) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.744 -0400", hash_original_method = "8FD17110C48D1CBE2477FC41B8E67E94", hash_generated_method = "5C981F99F17CB4507927C4517C229BBE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void onChange(boolean selfChange) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(selfChange);
            log("Auto time zone state changed");
            revertToNitzTimeZone();
            // ---------- Original Method ----------
            //if (DBG) log("Auto time zone state changed");
            //revertToNitzTimeZone();
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.744 -0400", hash_original_method = "FF3701A2004D17249B7B4B59CF4365CF", hash_generated_method = "7858619B19597A92E56124E14C9E3009")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CdmaServiceStateTracker(CDMAPhone phone) {
        super();
        dsTaint.addTaint(phone.dsTaint);
        cr = phone.getContext().getContentResolver();
        cm = phone.mCM;
        ss = new ServiceState();
        newSS = new ServiceState();
        cellLoc = new CdmaCellLocation();
        newCellLoc = new CdmaCellLocation();
        mSignalStrength = new SignalStrength();
        PowerManager powerManager;
        powerManager = (PowerManager)phone.getContext().getSystemService(Context.POWER_SERVICE);
        mWakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, WAKELOCK_TAG);
        cm.registerForAvailable(this, EVENT_RADIO_AVAILABLE, null);
        cm.registerForRadioStateChanged(this, EVENT_RADIO_STATE_CHANGED, null);
        cm.registerForVoiceNetworkStateChanged(this, EVENT_NETWORK_STATE_CHANGED_CDMA, null);
        cm.setOnNITZTime(this, EVENT_NITZ_TIME, null);
        cm.setOnSignalStrengthUpdate(this, EVENT_SIGNAL_STRENGTH_UPDATE, null);
        cm.registerForRUIMReady(this, EVENT_RUIM_READY, null);
        cm.registerForNVReady(this, EVENT_NV_READY, null);
        phone.registerForEriFileLoaded(this, EVENT_ERI_FILE_LOADED, null);
        cm.registerForCdmaOtaProvision(this,EVENT_OTA_PROVISION_STATUS_CHANGE, null);
        int airplaneMode;
        airplaneMode = Settings.System.getInt(cr, Settings.System.AIRPLANE_MODE_ON, 0);
        mDesiredPowerState = ! (airplaneMode > 0);
        cr.registerContentObserver(
                Settings.System.getUriFor(Settings.System.AUTO_TIME), true,
                mAutoTimeObserver);
        cr.registerContentObserver(
            Settings.System.getUriFor(Settings.System.AUTO_TIME_ZONE), true,
            mAutoTimeZoneObserver);
        setSignalStrengthDefaultValues();
        mNeedToRegForRuimLoaded = true;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.745 -0400", hash_original_method = "4D5D490C37798965D77553069E20CD07", hash_generated_method = "2493853BE4052E2639ABC612314A5661")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dispose() {
        cm.unregisterForAvailable(this);
        cm.unregisterForRadioStateChanged(this);
        cm.unregisterForVoiceNetworkStateChanged(this);
        cm.unregisterForRUIMReady(this);
        cm.unregisterForNVReady(this);
        cm.unregisterForCdmaOtaProvision(this);
        phone.unregisterForEriFileLoaded(this);
        phone.mIccRecords.unregisterForRecordsLoaded(this);
        cm.unSetOnSignalStrengthUpdate(this);
        cm.unSetOnNITZTime(this);
        cr.unregisterContentObserver(mAutoTimeObserver);
        cr.unregisterContentObserver(mAutoTimeZoneObserver);
        // ---------- Original Method ----------
        //cm.unregisterForAvailable(this);
        //cm.unregisterForRadioStateChanged(this);
        //cm.unregisterForVoiceNetworkStateChanged(this);
        //cm.unregisterForRUIMReady(this);
        //cm.unregisterForNVReady(this);
        //cm.unregisterForCdmaOtaProvision(this);
        //phone.unregisterForEriFileLoaded(this);
        //phone.mIccRecords.unregisterForRecordsLoaded(this);
        //cm.unSetOnSignalStrengthUpdate(this);
        //cm.unSetOnNITZTime(this);
        //cr.unregisterContentObserver(mAutoTimeObserver);
        //cr.unregisterContentObserver(mAutoTimeZoneObserver);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.745 -0400", hash_original_method = "BA9FDB49D0B6CB52D4E369B5C2B6B17A", hash_generated_method = "C9E7FAAD0D714F705898C9CAA8F5C6C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void finalize() {
        log("CdmaServiceStateTracker finalized");
        // ---------- Original Method ----------
        //if (DBG) log("CdmaServiceStateTracker finalized");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.745 -0400", hash_original_method = "70290EDA16C74DFE014583BB384DB8B5", hash_generated_method = "1FC4106B87195DD50188AB05B548327F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForSubscriptionInfoReady(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        Registrant r;
        r = new Registrant(h, what, obj);
        cdmaForSubscriptionInfoReadyRegistrants.add(r);
        {
            boolean varE32EA0BBDD6B91C9D19F50A2B5A8A1E3_1122377978 = (isMinInfoReady());
            {
                r.notifyRegistrant();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //Registrant r = new Registrant(h, what, obj);
        //cdmaForSubscriptionInfoReadyRegistrants.add(r);
        //if (isMinInfoReady()) {
            //r.notifyRegistrant();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.745 -0400", hash_original_method = "19125607721EAC24124C4D5516B60F75", hash_generated_method = "3A15EC6898004760CBE643A8480ABB9C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForSubscriptionInfoReady(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        cdmaForSubscriptionInfoReadyRegistrants.remove(h);
        // ---------- Original Method ----------
        //cdmaForSubscriptionInfoReadyRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.747 -0400", hash_original_method = "754E8D2400977D5A28AAECFFE4ABD510", hash_generated_method = "F003169B2920D56A34634A3EEE947DB3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void handleMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        AsyncResult ar;
        int[] ints;
        String[] strings;
        //Begin case EVENT_RADIO_AVAILABLE 
        log("handleMessage: EVENT_RADIO_AVAILABLE");
        //End case EVENT_RADIO_AVAILABLE 
        //Begin case EVENT_RUIM_READY 
        isSubscriptionFromRuim = true;
        //End case EVENT_RUIM_READY 
        //Begin case EVENT_RUIM_READY 
        {
            phone.mIccRecords.registerForRecordsLoaded(this,
                        EVENT_RUIM_RECORDS_LOADED, null);
            mNeedToRegForRuimLoaded = false;
        } //End block
        //End case EVENT_RUIM_READY 
        //Begin case EVENT_RUIM_READY 
        cm.getCDMASubscription(obtainMessage(EVENT_POLL_STATE_CDMA_SUBSCRIPTION));
        //End case EVENT_RUIM_READY 
        //Begin case EVENT_RUIM_READY 
        log("handleMessage: EVENT_RUIM_READY, Send Request getCDMASubscription.");
        //End case EVENT_RUIM_READY 
        //Begin case EVENT_RUIM_READY 
        pollState();
        //End case EVENT_RUIM_READY 
        //Begin case EVENT_RUIM_READY 
        queueNextSignalStrengthPoll();
        //End case EVENT_RUIM_READY 
        //Begin case EVENT_NV_READY 
        isSubscriptionFromRuim = false;
        //End case EVENT_NV_READY 
        //Begin case EVENT_NV_READY 
        log("handleMessage: EVENT_NV_READY, Send Request getCDMASubscription.");
        //End case EVENT_NV_READY 
        //Begin case EVENT_NV_READY 
        cm.getCDMASubscription( obtainMessage(EVENT_POLL_STATE_CDMA_SUBSCRIPTION));
        //End case EVENT_NV_READY 
        //Begin case EVENT_NV_READY 
        pollState();
        //End case EVENT_NV_READY 
        //Begin case EVENT_NV_READY 
        queueNextSignalStrengthPoll();
        //End case EVENT_NV_READY 
        //Begin case EVENT_RADIO_STATE_CHANGED 
        setPowerStateToDesired();
        //End case EVENT_RADIO_STATE_CHANGED 
        //Begin case EVENT_RADIO_STATE_CHANGED 
        pollState();
        //End case EVENT_RADIO_STATE_CHANGED 
        //Begin case EVENT_NETWORK_STATE_CHANGED_CDMA 
        pollState();
        //End case EVENT_NETWORK_STATE_CHANGED_CDMA 
        //Begin case EVENT_GET_SIGNAL_STRENGTH 
        {
            boolean var526F1BDDC71532C049873C5302565E55_1630668837 = (!(cm.getRadioState().isOn()) || (cm.getRadioState().isGsm()));
        } //End collapsed parenthetic
        //End case EVENT_GET_SIGNAL_STRENGTH 
        //Begin case EVENT_GET_SIGNAL_STRENGTH 
        ar = (AsyncResult) msg.obj;
        //End case EVENT_GET_SIGNAL_STRENGTH 
        //Begin case EVENT_GET_SIGNAL_STRENGTH 
        onSignalStrengthResult(ar);
        //End case EVENT_GET_SIGNAL_STRENGTH 
        //Begin case EVENT_GET_SIGNAL_STRENGTH 
        queueNextSignalStrengthPoll();
        //End case EVENT_GET_SIGNAL_STRENGTH 
        //Begin case EVENT_GET_LOC_DONE_CDMA 
        ar = (AsyncResult) msg.obj;
        //End case EVENT_GET_LOC_DONE_CDMA 
        //Begin case EVENT_GET_LOC_DONE_CDMA 
        {
            String states[];
            states = (String[])ar.result;
            int baseStationId;
            baseStationId = -1;
            int baseStationLatitude;
            baseStationLatitude = CdmaCellLocation.INVALID_LAT_LONG;
            int baseStationLongitude;
            baseStationLongitude = CdmaCellLocation.INVALID_LAT_LONG;
            int systemId;
            systemId = -1;
            int networkId;
            networkId = -1;
            {
                try 
                {
                    {
                        baseStationId = Integer.parseInt(states[4]);
                    } //End block
                    {
                        baseStationLatitude = Integer.parseInt(states[5]);
                    } //End block
                    {
                        baseStationLongitude = Integer.parseInt(states[6]);
                    } //End block
                    {
                        baseStationLatitude  = CdmaCellLocation.INVALID_LAT_LONG;
                        baseStationLongitude = CdmaCellLocation.INVALID_LAT_LONG;
                    } //End block
                    {
                        systemId = Integer.parseInt(states[8]);
                    } //End block
                    {
                        networkId = Integer.parseInt(states[9]);
                    } //End block
                } //End block
                catch (NumberFormatException ex)
                {
                    loge("error parsing cell location data: " + ex);
                } //End block
            } //End block
            cellLoc.setCellLocationData(baseStationId, baseStationLatitude,
                        baseStationLongitude, systemId, networkId);
            phone.notifyLocationChanged();
        } //End block
        //End case EVENT_GET_LOC_DONE_CDMA 
        //Begin case EVENT_GET_LOC_DONE_CDMA 
        disableSingleLocationUpdate();
        //End case EVENT_GET_LOC_DONE_CDMA 
        //Begin case EVENT_POLL_STATE_REGISTRATION_CDMA EVENT_POLL_STATE_OPERATOR_CDMA 
        ar = (AsyncResult) msg.obj;
        //End case EVENT_POLL_STATE_REGISTRATION_CDMA EVENT_POLL_STATE_OPERATOR_CDMA 
        //Begin case EVENT_POLL_STATE_REGISTRATION_CDMA EVENT_POLL_STATE_OPERATOR_CDMA 
        handlePollStateResult(msg.what, ar);
        //End case EVENT_POLL_STATE_REGISTRATION_CDMA EVENT_POLL_STATE_OPERATOR_CDMA 
        //Begin case EVENT_POLL_STATE_CDMA_SUBSCRIPTION 
        ar = (AsyncResult) msg.obj;
        //End case EVENT_POLL_STATE_CDMA_SUBSCRIPTION 
        //Begin case EVENT_POLL_STATE_CDMA_SUBSCRIPTION 
        {
            String cdmaSubscription[];
            cdmaSubscription = (String[])ar.result;
            {
                mMdn = cdmaSubscription[0];
                parseSidNid(cdmaSubscription[1], cdmaSubscription[2]);
                mMin = cdmaSubscription[3];
                mPrlVersion = cdmaSubscription[4];
                log("GET_CDMA_SUBSCRIPTION: MDN=" + mMdn);
                mIsMinInfoReady = true;
                updateOtaspState();
                phone.getIccCard().broadcastIccStateChangedIntent(IccCard.INTENT_VALUE_ICC_IMSI,
                            null);
            } //End block
            {
                {
                    log("GET_CDMA_SUBSCRIPTION: error parsing cdmaSubscription params num="
                            + cdmaSubscription.length);
                } //End block
            } //End block
        } //End block
        //End case EVENT_POLL_STATE_CDMA_SUBSCRIPTION 
        //Begin case EVENT_POLL_SIGNAL_STRENGTH 
        cm.getSignalStrength(obtainMessage(EVENT_GET_SIGNAL_STRENGTH));
        //End case EVENT_POLL_SIGNAL_STRENGTH 
        //Begin case EVENT_NITZ_TIME 
        ar = (AsyncResult) msg.obj;
        //End case EVENT_NITZ_TIME 
        //Begin case EVENT_NITZ_TIME 
        String nitzString;
        nitzString = (String)((Object[])ar.result)[0];
        //End case EVENT_NITZ_TIME 
        //Begin case EVENT_NITZ_TIME 
        long nitzReceiveTime;
        nitzReceiveTime = ((Long)((Object[])ar.result)[1]).longValue();
        //End case EVENT_NITZ_TIME 
        //Begin case EVENT_NITZ_TIME 
        setTimeFromNITZString(nitzString, nitzReceiveTime);
        //End case EVENT_NITZ_TIME 
        //Begin case EVENT_SIGNAL_STRENGTH_UPDATE 
        ar = (AsyncResult) msg.obj;
        //End case EVENT_SIGNAL_STRENGTH_UPDATE 
        //Begin case EVENT_SIGNAL_STRENGTH_UPDATE 
        dontPollSignalStrength = true;
        //End case EVENT_SIGNAL_STRENGTH_UPDATE 
        //Begin case EVENT_SIGNAL_STRENGTH_UPDATE 
        onSignalStrengthResult(ar);
        //End case EVENT_SIGNAL_STRENGTH_UPDATE 
        //Begin case EVENT_RUIM_RECORDS_LOADED 
        updateSpnDisplay();
        //End case EVENT_RUIM_RECORDS_LOADED 
        //Begin case EVENT_LOCATION_UPDATES_ENABLED 
        ar = (AsyncResult) msg.obj;
        //End case EVENT_LOCATION_UPDATES_ENABLED 
        //Begin case EVENT_LOCATION_UPDATES_ENABLED 
        {
            cm.getVoiceRegistrationState(obtainMessage(EVENT_GET_LOC_DONE_CDMA, null));
        } //End block
        //End case EVENT_LOCATION_UPDATES_ENABLED 
        //Begin case EVENT_ERI_FILE_LOADED 
        log("[CdmaServiceStateTracker] ERI file has been loaded, repolling.");
        //End case EVENT_ERI_FILE_LOADED 
        //Begin case EVENT_ERI_FILE_LOADED 
        pollState();
        //End case EVENT_ERI_FILE_LOADED 
        //Begin case EVENT_OTA_PROVISION_STATUS_CHANGE 
        ar = (AsyncResult)msg.obj;
        //End case EVENT_OTA_PROVISION_STATUS_CHANGE 
        //Begin case EVENT_OTA_PROVISION_STATUS_CHANGE 
        {
            ints = (int[]) ar.result;
            int otaStatus;
            otaStatus = ints[0];
            {
                log("EVENT_OTA_PROVISION_STATUS_CHANGE: Complete, Reload MDN");
                cm.getCDMASubscription( obtainMessage(EVENT_POLL_STATE_CDMA_SUBSCRIPTION));
            } //End block
        } //End block
        //End case EVENT_OTA_PROVISION_STATUS_CHANGE 
        //Begin case default 
        super.handleMessage(msg);
        //End case default 
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.747 -0400", hash_original_method = "BC2E3346E1E8D048BB892FC104E776BC", hash_generated_method = "B6A24B943E953D8D180DC7953BD03EEC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void setPowerStateToDesired() {
        {
            boolean var132800EA641B7653EC59634384D41AC8_1007204599 = (mDesiredPowerState
            && cm.getRadioState() == CommandsInterface.RadioState.RADIO_OFF);
            {
                cm.setRadioPower(true, null);
            } //End block
            {
                boolean var9EF9CD1D5966856073F2A7E801160763_765482466 = (!mDesiredPowerState && cm.getRadioState().isOn());
                {
                    DataConnectionTracker dcTracker;
                    dcTracker = phone.mDataConnectionTracker;
                    powerOffRadioSafely(dcTracker);
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (mDesiredPowerState
            //&& cm.getRadioState() == CommandsInterface.RadioState.RADIO_OFF) {
            //cm.setRadioPower(true, null);
        //} else if (!mDesiredPowerState && cm.getRadioState().isOn()) {
            //DataConnectionTracker dcTracker = phone.mDataConnectionTracker;
            //powerOffRadioSafely(dcTracker);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.748 -0400", hash_original_method = "BDCA4E41D3AB74048D93171255E149A7", hash_generated_method = "7C1EB6234B812B79F1124EADEFCD582E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void updateSpnDisplay() {
        String plmn;
        plmn = ss.getOperatorAlphaLong();
        {
            boolean varBC9C6DD660615C6E1E2DD0233001B92B_1846574452 = (!TextUtils.equals(plmn, mCurPlmn));
            {
                boolean showPlmn;
                showPlmn = plmn != null;
                {
                    log(String.format("updateSpnDisplay: changed sending intent" +
                            " showPlmn='%b' plmn='%s'", showPlmn, plmn));
                } //End block
                Intent intent;
                intent = new Intent(Intents.SPN_STRINGS_UPDATED_ACTION);
                intent.addFlags(Intent.FLAG_RECEIVER_REPLACE_PENDING);
                intent.putExtra(Intents.EXTRA_SHOW_SPN, false);
                intent.putExtra(Intents.EXTRA_SPN, "");
                intent.putExtra(Intents.EXTRA_SHOW_PLMN, showPlmn);
                intent.putExtra(Intents.EXTRA_PLMN, plmn);
                phone.getContext().sendStickyBroadcast(intent);
            } //End block
        } //End collapsed parenthetic
        mCurPlmn = plmn;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.748 -0400", hash_original_method = "A0DE0F5E4F4D4787509D60C270D17835", hash_generated_method = "12FC1D7757A2C7075F6CD93B39A12661")
    @DSModeled(DSC.SAFE)
    @Override
    protected Phone getPhone() {
        return (Phone)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return phone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.748 -0400", hash_original_method = "E924685B280F7636BB1194CB1DB8B328", hash_generated_method = "E30E860D2CAFC3B27310495C94AE8229")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void setCdmaTechnology(int radioTechnology) {
        dsTaint.addTaint(radioTechnology);
        mNewDataConnectionState = radioTechnologyToDataServiceState(radioTechnology);
        newSS.setRadioTechnology(radioTechnology);
        // ---------- Original Method ----------
        //mNewDataConnectionState = radioTechnologyToDataServiceState(radioTechnology);
        //newSS.setRadioTechnology(radioTechnology);
        //newNetworkType = radioTechnology;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.749 -0400", hash_original_method = "BE829AA0C3B19F93CC8F98530D925AC3", hash_generated_method = "2F7D97880D423083779BCA431DEDAA0A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void handlePollStateResultMessage(int what, AsyncResult ar) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(ar.dsTaint);
        int ints[];
        String states[];
        //Begin case EVENT_POLL_STATE_REGISTRATION_CDMA 
        states = (String[])ar.result;
        //End case EVENT_POLL_STATE_REGISTRATION_CDMA 
        //Begin case EVENT_POLL_STATE_REGISTRATION_CDMA 
        int registrationState;
        registrationState = 4;
        //End case EVENT_POLL_STATE_REGISTRATION_CDMA 
        //Begin case EVENT_POLL_STATE_REGISTRATION_CDMA 
        int radioTechnology;
        radioTechnology = -1;
        //End case EVENT_POLL_STATE_REGISTRATION_CDMA 
        //Begin case EVENT_POLL_STATE_REGISTRATION_CDMA 
        int baseStationId;
        baseStationId = -1;
        //End case EVENT_POLL_STATE_REGISTRATION_CDMA 
        //Begin case EVENT_POLL_STATE_REGISTRATION_CDMA 
        int baseStationLatitude;
        baseStationLatitude = CdmaCellLocation.INVALID_LAT_LONG;
        //End case EVENT_POLL_STATE_REGISTRATION_CDMA 
        //Begin case EVENT_POLL_STATE_REGISTRATION_CDMA 
        int baseStationLongitude;
        baseStationLongitude = CdmaCellLocation.INVALID_LAT_LONG;
        //End case EVENT_POLL_STATE_REGISTRATION_CDMA 
        //Begin case EVENT_POLL_STATE_REGISTRATION_CDMA 
        int cssIndicator;
        cssIndicator = 0;
        //End case EVENT_POLL_STATE_REGISTRATION_CDMA 
        //Begin case EVENT_POLL_STATE_REGISTRATION_CDMA 
        int systemId;
        systemId = 0;
        //End case EVENT_POLL_STATE_REGISTRATION_CDMA 
        //Begin case EVENT_POLL_STATE_REGISTRATION_CDMA 
        int networkId;
        networkId = 0;
        //End case EVENT_POLL_STATE_REGISTRATION_CDMA 
        //Begin case EVENT_POLL_STATE_REGISTRATION_CDMA 
        int roamingIndicator;
        roamingIndicator = -1;
        //End case EVENT_POLL_STATE_REGISTRATION_CDMA 
        //Begin case EVENT_POLL_STATE_REGISTRATION_CDMA 
        int systemIsInPrl;
        systemIsInPrl = 0;
        //End case EVENT_POLL_STATE_REGISTRATION_CDMA 
        //Begin case EVENT_POLL_STATE_REGISTRATION_CDMA 
        int defaultRoamingIndicator;
        defaultRoamingIndicator = 0;
        //End case EVENT_POLL_STATE_REGISTRATION_CDMA 
        //Begin case EVENT_POLL_STATE_REGISTRATION_CDMA 
        int reasonForDenial;
        reasonForDenial = 0;
        //End case EVENT_POLL_STATE_REGISTRATION_CDMA 
        //Begin case EVENT_POLL_STATE_REGISTRATION_CDMA 
        {
            try 
            {
                {
                    registrationState = Integer.parseInt(states[0]);
                } //End block
                {
                    radioTechnology = Integer.parseInt(states[3]);
                } //End block
                {
                    baseStationId = Integer.parseInt(states[4]);
                } //End block
                {
                    baseStationLatitude = Integer.parseInt(states[5]);
                } //End block
                {
                    baseStationLongitude = Integer.parseInt(states[6]);
                } //End block
                {
                    baseStationLatitude  = CdmaCellLocation.INVALID_LAT_LONG;
                    baseStationLongitude = CdmaCellLocation.INVALID_LAT_LONG;
                } //End block
                {
                    cssIndicator = Integer.parseInt(states[7]);
                } //End block
                {
                    systemId = Integer.parseInt(states[8]);
                } //End block
                {
                    networkId = Integer.parseInt(states[9]);
                } //End block
                {
                    roamingIndicator = Integer.parseInt(states[10]);
                } //End block
                {
                    systemIsInPrl = Integer.parseInt(states[11]);
                } //End block
                {
                    defaultRoamingIndicator = Integer.parseInt(states[12]);
                } //End block
                {
                    reasonForDenial = Integer.parseInt(states[13]);
                } //End block
            } //End block
            catch (NumberFormatException ex)
            {
                loge("EVENT_POLL_STATE_REGISTRATION_CDMA: error parsing: " + ex);
            } //End block
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Warning! Wrong number of parameters returned from "
                                     + "RIL_REQUEST_REGISTRATION_STATE: expected 14 or more "
                                     + "strings and got " + states.length + " strings");
        } //End block
        //End case EVENT_POLL_STATE_REGISTRATION_CDMA 
        //Begin case EVENT_POLL_STATE_REGISTRATION_CDMA 
        mRegistrationState = registrationState;
        //End case EVENT_POLL_STATE_REGISTRATION_CDMA 
        //Begin case EVENT_POLL_STATE_REGISTRATION_CDMA 
        mCdmaRoaming =
                    regCodeIsRoaming(registrationState) && !isRoamIndForHomeSystem(states[10]);
        //End case EVENT_POLL_STATE_REGISTRATION_CDMA 
        //Begin case EVENT_POLL_STATE_REGISTRATION_CDMA 
        newSS.setState (regCodeToServiceState(registrationState));
        //End case EVENT_POLL_STATE_REGISTRATION_CDMA 
        //Begin case EVENT_POLL_STATE_REGISTRATION_CDMA 
        setCdmaTechnology(radioTechnology);
        //End case EVENT_POLL_STATE_REGISTRATION_CDMA 
        //Begin case EVENT_POLL_STATE_REGISTRATION_CDMA 
        newSS.setCssIndicator(cssIndicator);
        //End case EVENT_POLL_STATE_REGISTRATION_CDMA 
        //Begin case EVENT_POLL_STATE_REGISTRATION_CDMA 
        newSS.setSystemAndNetworkId(systemId, networkId);
        //End case EVENT_POLL_STATE_REGISTRATION_CDMA 
        //Begin case EVENT_POLL_STATE_REGISTRATION_CDMA 
        mRoamingIndicator = roamingIndicator;
        //End case EVENT_POLL_STATE_REGISTRATION_CDMA 
        //Begin case EVENT_POLL_STATE_REGISTRATION_CDMA 
        mIsInPrl = (systemIsInPrl == 0) ? false : true;
        //End case EVENT_POLL_STATE_REGISTRATION_CDMA 
        //Begin case EVENT_POLL_STATE_REGISTRATION_CDMA 
        mDefaultRoamingIndicator = defaultRoamingIndicator;
        //End case EVENT_POLL_STATE_REGISTRATION_CDMA 
        //Begin case EVENT_POLL_STATE_REGISTRATION_CDMA 
        newCellLoc.setCellLocationData(baseStationId, baseStationLatitude,
                    baseStationLongitude, systemId, networkId);
        //End case EVENT_POLL_STATE_REGISTRATION_CDMA 
        //Begin case EVENT_POLL_STATE_REGISTRATION_CDMA 
        {
            mRegistrationDeniedReason = ServiceStateTracker.REGISTRATION_DENIED_GEN;
        } //End block
        {
            mRegistrationDeniedReason = ServiceStateTracker.REGISTRATION_DENIED_AUTH;
        } //End block
        {
            mRegistrationDeniedReason = "";
        } //End block
        //End case EVENT_POLL_STATE_REGISTRATION_CDMA 
        //Begin case EVENT_POLL_STATE_REGISTRATION_CDMA 
        {
            log("Registration denied, " + mRegistrationDeniedReason);
        } //End block
        //End case EVENT_POLL_STATE_REGISTRATION_CDMA 
        //Begin case EVENT_POLL_STATE_OPERATOR_CDMA 
        String opNames[];
        opNames = (String[])ar.result;
        //End case EVENT_POLL_STATE_OPERATOR_CDMA 
        //Begin case EVENT_POLL_STATE_OPERATOR_CDMA 
        {
            {
                boolean var64F902D6C515FBF5301383078A8A1810_1145121255 = ((opNames[2] == null) || (opNames[2].length() < 5)
                        || ("00000".equals(opNames[2])));
                {
                    opNames[2] = SystemProperties.get(
                            CDMAPhone.PROPERTY_CDMA_HOME_OPERATOR_NUMERIC, "00000");
                    {
                        log("RIL_REQUEST_OPERATOR.response[2], the numeric, " +
                                " is bad. Using SystemProperties '" +
                                        CDMAPhone.PROPERTY_CDMA_HOME_OPERATOR_NUMERIC +
                                "'= " + opNames[2]);
                    } //End block
                } //End block
            } //End collapsed parenthetic
            {
                boolean varBC92A3357E9408F0FD52AC7CBCDE6A5F_916005494 = (cm.getNvState().isNVReady());
                {
                    newSS.setOperatorName(null, opNames[1], opNames[2]);
                } //End block
                {
                    newSS.setOperatorName(opNames[0], opNames[1], opNames[2]);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            log("EVENT_POLL_STATE_OPERATOR_CDMA: error parsing opNames");
        } //End block
        //End case EVENT_POLL_STATE_OPERATOR_CDMA 
        //Begin case default 
        loge("handlePollStateResultMessage: RIL response handle in wrong phone!"
                    + " Expected CDMA RIL request and get GSM RIL request.");
        //End case default 
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.750 -0400", hash_original_method = "1B5F4BD94220D105FC0E737C13196363", hash_generated_method = "FA8BBF9A2BDA1762627C88B1D0A41664")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void handlePollStateResult(int what, AsyncResult ar) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(ar.dsTaint);
        {
            CommandException.Error err;
            err = null;
            {
                err = ((CommandException)(ar.exception)).getCommandError();
            } //End block
            {
                cancelPollState();
            } //End block
            {
                boolean var0F541275CA306A5F1AC77D786FD54CFD_214680547 = (!cm.getRadioState().isOn());
                {
                    cancelPollState();
                } //End block
            } //End collapsed parenthetic
            {
                loge("handlePollStateResult: RIL returned an error where it must succeed"
                        + ar.exception);
            } //End block
        } //End block
        try 
        {
            handlePollStateResultMessage(what, ar);
        } //End block
        catch (RuntimeException ex)
        {
            loge("handlePollStateResult: Exception while polling service state. "
                    + "Probably malformed RIL response." + ex);
        } //End block
        {
            boolean namMatch;
            namMatch = false;
            {
                boolean var29AC97C0502F6AB3FF9782C48F8FA76A_726511480 = (!isSidsAllZeros() && isHomeSid(newSS.getSystemId()));
                {
                    namMatch = true;
                } //End block
            } //End collapsed parenthetic
            {
                newSS.setRoaming(isRoamingBetweenOperators(mCdmaRoaming, newSS));
            } //End block
            {
                newSS.setRoaming(mCdmaRoaming);
            } //End block
            newSS.setCdmaDefaultRoamingIndicator(mDefaultRoamingIndicator);
            newSS.setCdmaRoamingIndicator(mRoamingIndicator);
            boolean isPrlLoaded;
            isPrlLoaded = true;
            {
                boolean varA035E8FBCA988F8B349976EEFE0F689A_1692645816 = (TextUtils.isEmpty(mPrlVersion));
                {
                    isPrlLoaded = false;
                } //End block
            } //End collapsed parenthetic
            {
                newSS.setCdmaRoamingIndicator(EriInfo.ROAMING_INDICATOR_OFF);
            } //End block
            {
                boolean varF459B34130F5C1301CC31DC3B09702EA_1916164869 = (!isSidsAllZeros());
                {
                    {
                        newSS.setCdmaRoamingIndicator(mDefaultRoamingIndicator);
                    } //End block
                    {
                        newSS.setCdmaRoamingIndicator(EriInfo.ROAMING_INDICATOR_FLASH);
                    } //End block
                    {
                        newSS.setCdmaRoamingIndicator(mRoamingIndicator);
                    } //End block
                    {
                        {
                            newSS.setCdmaRoamingIndicator(EriInfo.ROAMING_INDICATOR_OFF);
                        } //End block
                        {
                            newSS.setCdmaRoamingIndicator(mRoamingIndicator);
                        } //End block
                    } //End block
                } //End block
            } //End collapsed parenthetic
            int roamingIndicator;
            roamingIndicator = newSS.getCdmaRoamingIndicator();
            newSS.setCdmaEriIconIndex(phone.mEriManager.getCdmaEriIconIndex(roamingIndicator,
                    mDefaultRoamingIndicator));
            newSS.setCdmaEriIconMode(phone.mEriManager.getCdmaEriIconMode(roamingIndicator,
                    mDefaultRoamingIndicator));
            {
                log("Set CDMA Roaming Indicator to: " + newSS.getCdmaRoamingIndicator()
                    + ". mCdmaRoaming = " + mCdmaRoaming + ", isPrlLoaded = " + isPrlLoaded
                    + ". namMatch = " + namMatch + " , mIsInPrl = " + mIsInPrl
                    + ", mRoamingIndicator = " + mRoamingIndicator
                    + ", mDefaultRoamingIndicator= " + mDefaultRoamingIndicator);
            } //End block
            pollStateDone();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.751 -0400", hash_original_method = "6C8071E15167CEBD3E2C13FCDC5BEC69", hash_generated_method = "4F34229AB8DB2417A1A42514981ACCDB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void setSignalStrengthDefaultValues() {
        mSignalStrength = new SignalStrength(99, -1, -1, -1, -1, -1, -1, false);
        // ---------- Original Method ----------
        //mSignalStrength = new SignalStrength(99, -1, -1, -1, -1, -1, -1, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.751 -0400", hash_original_method = "518F03C8AA7D2E41BBC9B0EF8F2349B8", hash_generated_method = "EE237AAAB23AADB5FF8FA52DB1C7E7EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void pollState() {
        pollingContext = new int[1];
        pollingContext[0] = 0;
        {
            Object varA9E12DC9226BD6A76EE86EBF3C63475C_1274879206 = (cm.getRadioState());
            //Begin case RADIO_UNAVAILABLE 
            newSS.setStateOutOfService();
            //End case RADIO_UNAVAILABLE 
            //Begin case RADIO_UNAVAILABLE 
            newCellLoc.setStateInvalid();
            //End case RADIO_UNAVAILABLE 
            //Begin case RADIO_UNAVAILABLE 
            setSignalStrengthDefaultValues();
            //End case RADIO_UNAVAILABLE 
            //Begin case RADIO_UNAVAILABLE 
            mGotCountryCode = false;
            //End case RADIO_UNAVAILABLE 
            //Begin case RADIO_UNAVAILABLE 
            pollStateDone();
            //End case RADIO_UNAVAILABLE 
            //Begin case RADIO_OFF 
            newSS.setStateOff();
            //End case RADIO_OFF 
            //Begin case RADIO_OFF 
            newCellLoc.setStateInvalid();
            //End case RADIO_OFF 
            //Begin case RADIO_OFF 
            setSignalStrengthDefaultValues();
            //End case RADIO_OFF 
            //Begin case RADIO_OFF 
            mGotCountryCode = false;
            //End case RADIO_OFF 
            //Begin case RADIO_OFF 
            pollStateDone();
            //End case RADIO_OFF 
            //Begin case SIM_NOT_READY SIM_LOCKED_OR_ABSENT SIM_READY 
            log("Radio Technology Change ongoing, setting SS to off");
            //End case SIM_NOT_READY SIM_LOCKED_OR_ABSENT SIM_READY 
            //Begin case SIM_NOT_READY SIM_LOCKED_OR_ABSENT SIM_READY 
            newSS.setStateOff();
            //End case SIM_NOT_READY SIM_LOCKED_OR_ABSENT SIM_READY 
            //Begin case SIM_NOT_READY SIM_LOCKED_OR_ABSENT SIM_READY 
            newCellLoc.setStateInvalid();
            //End case SIM_NOT_READY SIM_LOCKED_OR_ABSENT SIM_READY 
            //Begin case SIM_NOT_READY SIM_LOCKED_OR_ABSENT SIM_READY 
            setSignalStrengthDefaultValues();
            //End case SIM_NOT_READY SIM_LOCKED_OR_ABSENT SIM_READY 
            //Begin case SIM_NOT_READY SIM_LOCKED_OR_ABSENT SIM_READY 
            mGotCountryCode = false;
            //End case SIM_NOT_READY SIM_LOCKED_OR_ABSENT SIM_READY 
            //Begin case default 
            cm.getOperator(
                    obtainMessage(EVENT_POLL_STATE_OPERATOR_CDMA, pollingContext));
            //End case default 
            //Begin case default 
            cm.getVoiceRegistrationState(
                    obtainMessage(EVENT_POLL_STATE_REGISTRATION_CDMA, pollingContext));
            //End case default 
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.752 -0400", hash_original_method = "E69BA838DECF1BB5E62D048E955B2CB0", hash_generated_method = "3ABDB82D0E3AF7B94A3BA6C82F0B5A60")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void fixTimeZone(String isoCountryCode) {
        dsTaint.addTaint(isoCountryCode);
        TimeZone zone;
        zone = null;
        String zoneName;
        zoneName = SystemProperties.get(TIMEZONE_PROPERTY);
        {
            boolean varCB8564F90A8584AF96581816886E97BA_358325361 = ((mZoneOffset == 0) && (mZoneDst == false) && (zoneName != null)
                && (zoneName.length() > 0)
                && (Arrays.binarySearch(GMT_COUNTRY_CODES, isoCountryCode) < 0));
            {
                zone = TimeZone.getDefault();
                long tzOffset;
                tzOffset = zone.getOffset(System.currentTimeMillis());
                {
                    boolean varEEB7CD030807CE702D36FA7DEF7E06F9_116653297 = (getAutoTime());
                    {
                        setAndBroadcastNetworkSetTime(System.currentTimeMillis() - tzOffset);
                    } //End block
                    {
                        mSavedTime = mSavedTime - tzOffset;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                boolean var26136DD7D51CA801EC28D07A7D018010_1369712139 = (isoCountryCode.equals(""));
                {
                    zone = getNitzTimeZone(mZoneOffset, mZoneDst, mZoneTime);
                } //End block
                {
                    zone = TimeUtils.getTimeZone(mZoneOffset, mZoneDst, mZoneTime, isoCountryCode);
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        mNeedFixZone = false;
        {
            {
                boolean var8B664356E036D01AFB0F5E4CF908C02F_1645429575 = (getAutoTimeZone());
                {
                    setAndBroadcastNetworkSetTimeZone(zone.getID());
                } //End block
            } //End collapsed parenthetic
            saveNitzTimeZone(zone.getID());
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.753 -0400", hash_original_method = "0FA304F04B86F76391D3D9DA6F1DEA62", hash_generated_method = "5E7F62F5C00EACBC448C5B515CEB3AD2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void pollStateDone() {
        log("pollStateDone: oldSS=[" + ss + "] newSS=[" + newSS + "]");
        boolean hasRegistered;
        hasRegistered = ss.getState() != ServiceState.STATE_IN_SERVICE
            && newSS.getState() == ServiceState.STATE_IN_SERVICE;
        boolean hasDeregistered;
        hasDeregistered = ss.getState() == ServiceState.STATE_IN_SERVICE
            && newSS.getState() != ServiceState.STATE_IN_SERVICE;
        boolean hasCdmaDataConnectionAttached;
        hasCdmaDataConnectionAttached = mDataConnectionState != ServiceState.STATE_IN_SERVICE
            && mNewDataConnectionState == ServiceState.STATE_IN_SERVICE;
        boolean hasCdmaDataConnectionDetached;
        hasCdmaDataConnectionDetached = mDataConnectionState == ServiceState.STATE_IN_SERVICE
            && mNewDataConnectionState != ServiceState.STATE_IN_SERVICE;
        boolean hasCdmaDataConnectionChanged;
        hasCdmaDataConnectionChanged = mDataConnectionState != mNewDataConnectionState;
        boolean hasNetworkTypeChanged;
        hasNetworkTypeChanged = networkType != newNetworkType;
        boolean hasChanged;
        hasChanged = !newSS.equals(ss);
        boolean hasRoamingOn;
        hasRoamingOn = !ss.getRoaming() && newSS.getRoaming();
        boolean hasRoamingOff;
        hasRoamingOff = ss.getRoaming() && !newSS.getRoaming();
        boolean hasLocationChanged;
        hasLocationChanged = !newCellLoc.equals(cellLoc);
        {
            boolean varF88E9DCD3AEEB219F0C2A6585652E72B_2063393950 = (ss.getState() != newSS.getState() ||
                mDataConnectionState != mNewDataConnectionState);
            {
                EventLog.writeEvent(EventLogTags.CDMA_SERVICE_STATE_CHANGE,
                    ss.getState(), mDataConnectionState,
                    newSS.getState(), mNewDataConnectionState);
            } //End block
        } //End collapsed parenthetic
        ServiceState tss;
        tss = ss;
        ss = newSS;
        newSS = tss;
        newSS.setStateOutOfService();
        CdmaCellLocation tcl;
        tcl = cellLoc;
        cellLoc = newCellLoc;
        newCellLoc = tcl;
        mDataConnectionState = mNewDataConnectionState;
        networkType = newNetworkType;
        newNetworkType = 0;
        newSS.setStateOutOfService();
        {
            phone.setSystemProperty(TelephonyProperties.PROPERTY_DATA_NETWORK_TYPE,
                    ServiceState.radioTechnologyToString(networkType));
        } //End block
        {
            mNetworkAttachedRegistrants.notifyRegistrants();
        } //End block
        {
            {
                boolean var1644C0B76D1EEAE538D65F783B0A10D2_1083128845 = (cm.getRadioState().isNVReady());
                {
                    String eriText;
                    {
                        boolean var0782B3C53497F07CDAB38A690B362545_2137310858 = (ss.getState() == ServiceState.STATE_IN_SERVICE);
                        {
                            eriText = phone.getCdmaEriText();
                        } //End block
                        {
                            eriText = phone.getContext().getText(
                            com.android.internal.R.string.roamingTextSearching).toString();
                        } //End block
                    } //End collapsed parenthetic
                    ss.setOperatorAlphaLong(eriText);
                } //End block
            } //End collapsed parenthetic
            String operatorNumeric;
            phone.setSystemProperty(TelephonyProperties.PROPERTY_OPERATOR_ALPHA,
                    ss.getOperatorAlphaLong());
            operatorNumeric = ss.getOperatorNumeric();
            phone.setSystemProperty(TelephonyProperties.PROPERTY_OPERATOR_NUMERIC, operatorNumeric);
            {
                phone.setSystemProperty(TelephonyProperties.PROPERTY_OPERATOR_ISO_COUNTRY, "");
                mGotCountryCode = false;
            } //End block
            {
                String isoCountryCode;
                isoCountryCode = "";
                try 
                {
                    isoCountryCode = MccTable.countryCodeForMcc(Integer.parseInt(
                            operatorNumeric.substring(0,3)));
                } //End block
                catch (NumberFormatException ex)
                {
                    loge("pollStateDone: countryCodeForMcc error" + ex);
                } //End block
                catch (StringIndexOutOfBoundsException ex)
                {
                    loge("pollStateDone: countryCodeForMcc error" + ex);
                } //End block
                phone.setSystemProperty(TelephonyProperties.PROPERTY_OPERATOR_ISO_COUNTRY,
                        isoCountryCode);
                mGotCountryCode = true;
                {
                    fixTimeZone(isoCountryCode);
                } //End block
            } //End block
            phone.setSystemProperty(TelephonyProperties.PROPERTY_OPERATOR_ISROAMING,
                    ss.getRoaming() ? "true" : "false");
            updateSpnDisplay();
            phone.notifyServiceStateChanged(ss);
        } //End block
        {
            mAttachedRegistrants.notifyRegistrants();
        } //End block
        {
            mDetachedRegistrants.notifyRegistrants();
        } //End block
        {
            phone.notifyDataConnection(null);
        } //End block
        {
            mRoamingOnRegistrants.notifyRegistrants();
        } //End block
        {
            mRoamingOffRegistrants.notifyRegistrants();
        } //End block
        {
            phone.notifyLocationChanged();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.753 -0400", hash_original_method = "99CED85D89C5E9DD8967FF1E935BF80B", hash_generated_method = "67DA25E7A51F40CCD2B2BD5C93ECDFB3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private TimeZone getNitzTimeZone(int offset, boolean dst, long when) {
        dsTaint.addTaint(when);
        dsTaint.addTaint(dst);
        dsTaint.addTaint(offset);
        TimeZone guess;
        guess = findTimeZone(offset, dst, when);
        {
            guess = findTimeZone(offset, !dst, when);
        } //End block
        log("getNitzTimeZone returning " + (guess == null ? guess : guess.getID()));
        return (TimeZone)dsTaint.getTaint();
        // ---------- Original Method ----------
        //TimeZone guess = findTimeZone(offset, dst, when);
        //if (guess == null) {
            //guess = findTimeZone(offset, !dst, when);
        //}
        //if (DBG) log("getNitzTimeZone returning " + (guess == null ? guess : guess.getID()));
        //return guess;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.757 -0400", hash_original_method = "950DB35A634BB86898B3E74AA5BE6013", hash_generated_method = "77C1CA89F8A2E1E6BE37750666E35F85")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private TimeZone findTimeZone(int offset, boolean dst, long when) {
        dsTaint.addTaint(when);
        dsTaint.addTaint(dst);
        dsTaint.addTaint(offset);
        int rawOffset;
        rawOffset = offset;
        {
            rawOffset -= 3600000;
        } //End block
        String[] zones;
        zones = TimeZone.getAvailableIDs(rawOffset);
        TimeZone guess;
        guess = null;
        Date d;
        d = new Date(when);
        {
            String zone = zones[0];
            {
                TimeZone tz;
                tz = TimeZone.getTimeZone(zone);
                {
                    boolean var1060EAEE62A1A81001DA148F1CCC674A_1175183933 = (tz.getOffset(when) == offset &&
                    tz.inDaylightTime(d) == dst);
                    {
                        guess = tz;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return (TimeZone)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int rawOffset = offset;
        //if (dst) {
            //rawOffset -= 3600000;
        //}
        //String[] zones = TimeZone.getAvailableIDs(rawOffset);
        //TimeZone guess = null;
        //Date d = new Date(when);
        //for (String zone : zones) {
            //TimeZone tz = TimeZone.getTimeZone(zone);
            //if (tz.getOffset(when) == offset &&
                    //tz.inDaylightTime(d) == dst) {
                //guess = tz;
                //break;
            //}
        //}
        //return guess;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.757 -0400", hash_original_method = "75DB599AC418C41475672A1B4451EF2E", hash_generated_method = "F2591626EF4ECE350160F27C11C79686")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void queueNextSignalStrengthPoll() {
        {
            boolean varADAA48EFD9B70BA23908E80A474BFA5A_1440532632 = (dontPollSignalStrength || (cm.getRadioState().isGsm()));
        } //End collapsed parenthetic
        Message msg;
        msg = obtainMessage();
        msg.what = EVENT_POLL_SIGNAL_STRENGTH;
        sendMessageDelayed(msg, POLL_PERIOD_MILLIS);
        // ---------- Original Method ----------
        //if (dontPollSignalStrength || (cm.getRadioState().isGsm())) {
            //return;
        //}
        //Message msg;
        //msg = obtainMessage();
        //msg.what = EVENT_POLL_SIGNAL_STRENGTH;
        //sendMessageDelayed(msg, POLL_PERIOD_MILLIS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.758 -0400", hash_original_method = "76CDF956056DDB53150BD0C17057AE41", hash_generated_method = "45823E8997F2B33E5D624F72D5B634FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void onSignalStrengthResult(AsyncResult ar) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(ar.dsTaint);
        SignalStrength oldSignalStrength;
        oldSignalStrength = mSignalStrength;
        {
            setSignalStrengthDefaultValues();
        } //End block
        {
            int[] ints;
            ints = (int[])ar.result;
            int offset;
            offset = 2;
            int cdmaDbm;
            cdmaDbm = -ints[offset];
            cdmaDbm = -120;
            int cdmaEcio;
            cdmaEcio = -ints[offset+1];
            cdmaEcio = -160;
            int evdoRssi;
            evdoRssi = -ints[offset+2];
            evdoRssi = -120;
            int evdoEcio;
            evdoEcio = -ints[offset+3];
            evdoEcio = -1;
            int evdoSnr;
            evdoSnr = ints[offset+4];
            evdoSnr = -1;
            mSignalStrength = new SignalStrength(99, -1, cdmaDbm, cdmaEcio,
                    evdoRssi, evdoEcio, evdoSnr, false);
        } //End block
        try 
        {
            phone.notifySignalStrength();
        } //End block
        catch (NullPointerException ex)
        {
            loge("onSignalStrengthResult() Phone already destroyed: " + ex
                    + "SignalStrength not notified");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.758 -0400", hash_original_method = "DF77DC7CB442AC6CF875159BD0FE26E0", hash_generated_method = "9F4E502F22AD72C6742BE1AF8927426F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected int radioTechnologyToDataServiceState(int code) {
        dsTaint.addTaint(code);
        int retVal;
        retVal = ServiceState.STATE_OUT_OF_SERVICE;
        //Begin case 6 7 8 12 13 
        retVal = ServiceState.STATE_IN_SERVICE;
        //End case 6 7 8 12 13 
        //Begin case default 
        loge("radioTechnologyToDataServiceState: Wrong radioTechnology code.");
        //End case default 
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int retVal = ServiceState.STATE_OUT_OF_SERVICE;
        //switch(code) {
        //case 0:
        //case 1:
        //case 2:
        //case 3:
        //case 4:
        //case 5:
            //break;
        //case 6: 
        //case 7: 
        //case 8: 
        //case 12: 
        //case 13: 
            //retVal = ServiceState.STATE_IN_SERVICE;
            //break;
        //default:
            //loge("radioTechnologyToDataServiceState: Wrong radioTechnology code.");
        //break;
        //}
        //return(retVal);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.758 -0400", hash_original_method = "DA573DADA483FE1143660303AA3E0D9F", hash_generated_method = "1BFDCEFE249A9C34C7B0871B0BD74367")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected int regCodeToServiceState(int code) {
        dsTaint.addTaint(code);
        //Begin case default 
        loge("regCodeToServiceState: unexpected service state " + code);
        //End case default 
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //switch (code) {
        //case 0: 
            //return ServiceState.STATE_OUT_OF_SERVICE;
        //case 1:
            //return ServiceState.STATE_IN_SERVICE;
        //case 2: 
        //case 3: 
        //case 4: 
            //return ServiceState.STATE_OUT_OF_SERVICE;
        //case 5:
            //return ServiceState.STATE_IN_SERVICE;
        //default:
            //loge("regCodeToServiceState: unexpected service state " + code);
        //return ServiceState.STATE_OUT_OF_SERVICE;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.758 -0400", hash_original_method = "2F7466C178280C26D6BC47DE1AFB7432", hash_generated_method = "8B19B0491216C6980B95E468643F68AC")
    @DSModeled(DSC.SAFE)
    public int getCurrentDataConnectionState() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mDataConnectionState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.759 -0400", hash_original_method = "19036A7D1DADA943DC912DAB6396B9AD", hash_generated_method = "9B3D37513C4FBD9D354402F41CDD50EE")
    @DSModeled(DSC.SAFE)
    private boolean regCodeIsRoaming(int code) {
        dsTaint.addTaint(code);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return 5 == code;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.763 -0400", hash_original_method = "B4323D2F9A07343D2462A4D59ED08046", hash_generated_method = "67640900AFE7C2B47A9B939C809262C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isRoamIndForHomeSystem(String roamInd) {
        dsTaint.addTaint(roamInd);
        String homeRoamIndicators;
        homeRoamIndicators = SystemProperties.get("ro.cdma.homesystem");
        {
            boolean var315D147B17EF94F7C5366417A7792112_432217743 = (!TextUtils.isEmpty(homeRoamIndicators));
            {
                {
                    String homeRoamInd = homeRoamIndicators.split(",")[0];
                    {
                        {
                            boolean varA386460DA3595176FB4BAA16B8D8F859_1223747420 = (homeRoamInd.equals(roamInd));
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //String homeRoamIndicators = SystemProperties.get("ro.cdma.homesystem");
        //if (!TextUtils.isEmpty(homeRoamIndicators)) {
            //for (String homeRoamInd : homeRoamIndicators.split(",")) {
                //if (homeRoamInd.equals(roamInd)) {
                    //return true;
                //}
            //}
            //return false;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.763 -0400", hash_original_method = "011C4920ECDF4CF24EF92E838B11DA6F", hash_generated_method = "BDE7B91C91CCC42F86261E3D0EA5BBC1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isRoamingBetweenOperators(boolean cdmaRoaming, ServiceState s) {
        dsTaint.addTaint(s.dsTaint);
        dsTaint.addTaint(cdmaRoaming);
        String spn;
        spn = SystemProperties.get(TelephonyProperties.PROPERTY_ICC_OPERATOR_ALPHA, "empty");
        String onsl;
        onsl = s.getOperatorAlphaLong();
        String onss;
        onss = s.getOperatorAlphaShort();
        boolean equalsOnsl;
        equalsOnsl = onsl != null && spn.equals(onsl);
        boolean equalsOnss;
        equalsOnss = onss != null && spn.equals(onss);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //String spn = SystemProperties.get(TelephonyProperties.PROPERTY_ICC_OPERATOR_ALPHA, "empty");
        //String onsl = s.getOperatorAlphaLong();
        //String onss = s.getOperatorAlphaShort();
        //boolean equalsOnsl = onsl != null && spn.equals(onsl);
        //boolean equalsOnss = onss != null && spn.equals(onss);
        //return cdmaRoaming && !(equalsOnsl || equalsOnss);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.765 -0400", hash_original_method = "7ADA939B474B339ADDF025B993055C9A", hash_generated_method = "2FCEF644A9D80AC4C24D116608418663")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setTimeFromNITZString(String nitz, long nitzReceiveTime) {
        dsTaint.addTaint(nitz);
        dsTaint.addTaint(nitzReceiveTime);
        long start;
        start = SystemClock.elapsedRealtime();
        {
            log("NITZ: " + nitz + "," + nitzReceiveTime +
                        " start=" + start + " delay=" + (start - nitzReceiveTime));
        } //End block
        try 
        {
            Calendar c;
            c = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
            c.clear();
            c.set(Calendar.DST_OFFSET, 0);
            String[] nitzSubs;
            nitzSubs = nitz.split("[/:,+-]");
            int year;
            year = 2000 + Integer.parseInt(nitzSubs[0]);
            c.set(Calendar.YEAR, year);
            int month;
            month = Integer.parseInt(nitzSubs[1]) - 1;
            c.set(Calendar.MONTH, month);
            int date;
            date = Integer.parseInt(nitzSubs[2]);
            c.set(Calendar.DATE, date);
            int hour;
            hour = Integer.parseInt(nitzSubs[3]);
            c.set(Calendar.HOUR, hour);
            int minute;
            minute = Integer.parseInt(nitzSubs[4]);
            c.set(Calendar.MINUTE, minute);
            int second;
            second = Integer.parseInt(nitzSubs[5]);
            c.set(Calendar.SECOND, second);
            boolean sign;
            sign = (nitz.indexOf('-') == -1);
            int tzOffset;
            tzOffset = Integer.parseInt(nitzSubs[6]);
            int dst;
            dst = Integer.parseInt(nitzSubs[7]);
            dst = 0;
            tzOffset = (sign ? 1 : -1) * tzOffset * 15 * 60 * 1000;
            TimeZone zone;
            zone = null;
            {
                String tzname;
                tzname = nitzSubs[8].replace('!','/');
                zone = TimeZone.getTimeZone( tzname );
            } //End block
            String iso;
            iso = SystemProperties.get(TelephonyProperties.PROPERTY_OPERATOR_ISO_COUNTRY);
            {
                {
                    {
                        boolean var8053821E6225ABE6D6EDD5F45C9DBCB8_54109772 = (iso != null && iso.length() > 0);
                        {
                            zone = TimeUtils.getTimeZone(tzOffset, dst != 0,
                                c.getTimeInMillis(),
                                iso);
                        } //End block
                        {
                            zone = getNitzTimeZone(tzOffset, (dst != 0), c.getTimeInMillis());
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
            {
                mNeedFixZone = true;
                mZoneOffset  = tzOffset;
                mZoneDst     = dst != 0;
                mZoneTime    = c.getTimeInMillis();
            } //End block
            {
                {
                    boolean var624415BE8DA2189070E2F3831D7C1692_354660459 = (getAutoTimeZone());
                    {
                        setAndBroadcastNetworkSetTimeZone(zone.getID());
                    } //End block
                } //End collapsed parenthetic
                saveNitzTimeZone(zone.getID());
            } //End block
            String ignore;
            ignore = SystemProperties.get("gsm.ignore-nitz");
            {
                boolean varE5D77747E14F70AD020ECEBD14623725_810468332 = (ignore != null && ignore.equals("yes"));
                {
                    log("NITZ: Not setting clock because gsm.ignore-nitz is set");
                } //End block
            } //End collapsed parenthetic
            try 
            {
                mWakeLock.acquire();
                long millisSinceNitzReceived;
                millisSinceNitzReceived = SystemClock.elapsedRealtime() - nitzReceiveTime;
                {
                    {
                        log("NITZ: not setting time, clock has rolled "
                                        + "backwards since NITZ time was received, "
                                        + nitz);
                    } //End block
                } //End block
                {
                    {
                        log("NITZ: not setting time, processing has taken "
                                    + (millisSinceNitzReceived / (1000 * 60 * 60 * 24))
                                    + " days");
                    } //End block
                } //End block
                c.add(Calendar.MILLISECOND, (int)millisSinceNitzReceived);
                {
                    boolean varEEB7CD030807CE702D36FA7DEF7E06F9_801359184 = (getAutoTime());
                    {
                        long gained;
                        gained = c.getTimeInMillis() - System.currentTimeMillis();
                        long timeSinceLastUpdate;
                        timeSinceLastUpdate = SystemClock.elapsedRealtime() - mSavedAtTime;
                        int nitzUpdateSpacing;
                        nitzUpdateSpacing = Settings.Secure.getInt(cr,
                            Settings.Secure.NITZ_UPDATE_SPACING, mNitzUpdateSpacing);
                        int nitzUpdateDiff;
                        nitzUpdateDiff = Settings.Secure.getInt(cr,
                            Settings.Secure.NITZ_UPDATE_DIFF, mNitzUpdateDiff);
                        {
                            boolean var824386FFC5EE5DF55B4AAF406EE0D224_949353688 = ((mSavedAtTime == 0) || (timeSinceLastUpdate > nitzUpdateSpacing)
                            || (Math.abs(gained) > nitzUpdateDiff));
                            {
                                {
                                    log("NITZ: Auto updating time of day to " + c.getTime()
                                + " NITZ receive delay=" + millisSinceNitzReceived
                                + "ms gained=" + gained + "ms from " + nitz);
                                } //End block
                                setAndBroadcastNetworkSetTime(c.getTimeInMillis());
                            } //End block
                            {
                                {
                                    log("NITZ: ignore, a previous update was "
                                + timeSinceLastUpdate + "ms ago and gained=" + gained + "ms");
                                } //End block
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                log("NITZ: update nitz time property");
                SystemProperties.set("gsm.nitz.time", String.valueOf(c.getTimeInMillis()));
                mSavedTime = c.getTimeInMillis();
                mSavedAtTime = SystemClock.elapsedRealtime();
            } //End block
            finally 
            {
                long end;
                end = SystemClock.elapsedRealtime();
                log("NITZ: end=" + end + " dur=" + (end - start));
                mWakeLock.release();
            } //End block
        } //End block
        catch (RuntimeException ex)
        {
            loge("NITZ: Parsing NITZ time " + nitz + " ex=" + ex);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.765 -0400", hash_original_method = "606CF17A4D40300EAFFE0BD67B82E0B6", hash_generated_method = "F8BDDAB7698E992589E19AA41EF2ED84")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean getAutoTime() {
        try 
        {
            boolean var0318692E4935505BFEE97424BA2C2BDC_1184905323 = (Settings.System.getInt(cr, Settings.System.AUTO_TIME) > 0);
        } //End block
        catch (SettingNotFoundException snfe)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return Settings.System.getInt(cr, Settings.System.AUTO_TIME) > 0;
        //} catch (SettingNotFoundException snfe) {
            //return true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.766 -0400", hash_original_method = "46A307C7AC0E208B22907DFB9CC04F45", hash_generated_method = "5E6C3DF99BE9307E898F946375D64944")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean getAutoTimeZone() {
        try 
        {
            boolean var6E6BE051602FD448D5A310EEAFCD9E4E_1477300260 = (Settings.System.getInt(cr, Settings.System.AUTO_TIME_ZONE) > 0);
        } //End block
        catch (SettingNotFoundException snfe)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return Settings.System.getInt(cr, Settings.System.AUTO_TIME_ZONE) > 0;
        //} catch (SettingNotFoundException snfe) {
            //return true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.766 -0400", hash_original_method = "AC4D6B705E7065D39BD6B0621414F077", hash_generated_method = "260099C4DBC8FC5C5A994C182DB538E4")
    @DSModeled(DSC.SAFE)
    private void saveNitzTimeZone(String zoneId) {
        dsTaint.addTaint(zoneId);
        // ---------- Original Method ----------
        //mSavedTimeZone = zoneId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.766 -0400", hash_original_method = "28A8B5328B033F98ED5E62B240AD20B6", hash_generated_method = "97B2E61036F4E46F8F4A6C34F9AFD002")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setAndBroadcastNetworkSetTimeZone(String zoneId) {
        dsTaint.addTaint(zoneId);
        AlarmManager alarm;
        alarm = (AlarmManager) phone.getContext().getSystemService(Context.ALARM_SERVICE);
        alarm.setTimeZone(zoneId);
        Intent intent;
        intent = new Intent(TelephonyIntents.ACTION_NETWORK_SET_TIMEZONE);
        intent.addFlags(Intent.FLAG_RECEIVER_REPLACE_PENDING);
        intent.putExtra("time-zone", zoneId);
        phone.getContext().sendStickyBroadcast(intent);
        // ---------- Original Method ----------
        //AlarmManager alarm =
            //(AlarmManager) phone.getContext().getSystemService(Context.ALARM_SERVICE);
        //alarm.setTimeZone(zoneId);
        //Intent intent = new Intent(TelephonyIntents.ACTION_NETWORK_SET_TIMEZONE);
        //intent.addFlags(Intent.FLAG_RECEIVER_REPLACE_PENDING);
        //intent.putExtra("time-zone", zoneId);
        //phone.getContext().sendStickyBroadcast(intent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.766 -0400", hash_original_method = "062E38B571EEA7E979075562F8B40A5D", hash_generated_method = "D9FF09D6F184A3F7764EDFC62EC78ED6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setAndBroadcastNetworkSetTime(long time) {
        dsTaint.addTaint(time);
        SystemClock.setCurrentTimeMillis(time);
        Intent intent;
        intent = new Intent(TelephonyIntents.ACTION_NETWORK_SET_TIME);
        intent.addFlags(Intent.FLAG_RECEIVER_REPLACE_PENDING);
        intent.putExtra("time", time);
        phone.getContext().sendStickyBroadcast(intent);
        // ---------- Original Method ----------
        //SystemClock.setCurrentTimeMillis(time);
        //Intent intent = new Intent(TelephonyIntents.ACTION_NETWORK_SET_TIME);
        //intent.addFlags(Intent.FLAG_RECEIVER_REPLACE_PENDING);
        //intent.putExtra("time", time);
        //phone.getContext().sendStickyBroadcast(intent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.766 -0400", hash_original_method = "FAE09FD02085B2FF4E1D8E37B65790F8", hash_generated_method = "883D82E39A98DD7E6F6868A9D7CB014B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void revertToNitzTime() {
        {
            boolean var295A15F3D6D43E502B81033D23E388EE_76080480 = (Settings.System.getInt(cr, Settings.System.AUTO_TIME, 0) == 0);
        } //End collapsed parenthetic
        {
            log("revertToNitzTime: mSavedTime=" + mSavedTime + " mSavedAtTime=" + mSavedAtTime);
        } //End block
        {
            setAndBroadcastNetworkSetTime(mSavedTime
                    + (SystemClock.elapsedRealtime() - mSavedAtTime));
        } //End block
        // ---------- Original Method ----------
        //if (Settings.System.getInt(cr, Settings.System.AUTO_TIME, 0) == 0) {
            //return;
        //}
        //if (DBG) {
            //log("revertToNitzTime: mSavedTime=" + mSavedTime + " mSavedAtTime=" + mSavedAtTime);
        //}
        //if (mSavedTime != 0 && mSavedAtTime != 0) {
            //setAndBroadcastNetworkSetTime(mSavedTime
                    //+ (SystemClock.elapsedRealtime() - mSavedAtTime));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.767 -0400", hash_original_method = "72156026C5CBDDA4CCFB821F20D0E263", hash_generated_method = "87EDD9DFC39FCA9378E29A61E31302BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void revertToNitzTimeZone() {
        {
            boolean var368E56141E4682CFD54AD9DE0B6F4586_551476145 = (Settings.System.getInt(phone.getContext().getContentResolver(),
                Settings.System.AUTO_TIME_ZONE, 0) == 0);
        } //End collapsed parenthetic
        log("revertToNitzTimeZone: tz='" + mSavedTimeZone);
        {
            setAndBroadcastNetworkSetTimeZone(mSavedTimeZone);
        } //End block
        // ---------- Original Method ----------
        //if (Settings.System.getInt(phone.getContext().getContentResolver(),
                //Settings.System.AUTO_TIME_ZONE, 0) == 0) {
            //return;
        //}
        //if (DBG) log("revertToNitzTimeZone: tz='" + mSavedTimeZone);
        //if (mSavedTimeZone != null) {
            //setAndBroadcastNetworkSetTimeZone(mSavedTimeZone);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.767 -0400", hash_original_method = "32C0C58A5E03F7E404DD21382316ACEF", hash_generated_method = "658E208D0A09815036369925EA8AE225")
    @DSModeled(DSC.SAFE)
    protected boolean isSidsAllZeros() {
        {
            {
                int i;
                i = 0;
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mHomeSystemId != null) {
            //for (int i=0; i < mHomeSystemId.length; i++) {
                //if (mHomeSystemId[i] != 0) {
                    //return false;
                //}
            //}
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.767 -0400", hash_original_method = "D3D57AE588662EF8725CB60FCA1C3072", hash_generated_method = "4E190082FA8C39806FA34D7B76E52AA7")
    @DSModeled(DSC.SAFE)
    private boolean isHomeSid(int sid) {
        dsTaint.addTaint(sid);
        {
            {
                int i;
                i = 0;
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mHomeSystemId != null) {
            //for (int i=0; i < mHomeSystemId.length; i++) {
                //if (sid == mHomeSystemId[i]) {
                    //return true;
                //}
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.767 -0400", hash_original_method = "5C4C41F870A905A307BF05376EE79383", hash_generated_method = "A7A518FC200E95CA5AA7AF35078F78BE")
    @DSModeled(DSC.SAFE)
    public boolean isConcurrentVoiceAndDataAllowed() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.767 -0400", hash_original_method = "A5028D79B927656E45CDFA536F16F5AB", hash_generated_method = "F0338C7249CF667EF5303AB40A58075F")
    @DSModeled(DSC.SAFE)
    public String getMdnNumber() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mMdn;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.768 -0400", hash_original_method = "133C132C72A1734541959456CF27FF0A", hash_generated_method = "6DADCF5B3C916C0FAE2D30DAC6876FAD")
    @DSModeled(DSC.SAFE)
    public String getCdmaMin() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mMin;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.768 -0400", hash_original_method = "B5AD5686CB21B47DB5A2223CCDBB4F42", hash_generated_method = "85BC9F48A4C2AD64441235A9DB32E994")
    @DSModeled(DSC.SAFE)
    public String getPrlVersion() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mPrlVersion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.768 -0400", hash_original_method = "B26D3610EF4478BB5ED2ADA9EDE43E3B", hash_generated_method = "A66F8479EF5EC46E12AA78D9464F2D53")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     String getImsi() {
        String operatorNumeric;
        operatorNumeric = SystemProperties.get(
                TelephonyProperties.PROPERTY_ICC_OPERATOR_NUMERIC, "");
        {
            boolean varF68187D93855D84C5AED475661AA07AC_1295343388 = (!TextUtils.isEmpty(operatorNumeric) && getCdmaMin() != null);
            {
                String varEF9F64EE4CF4D1D3FB861C1D24AB284D_1800609182 = ((operatorNumeric + getCdmaMin()));
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String operatorNumeric = SystemProperties.get(
                //TelephonyProperties.PROPERTY_ICC_OPERATOR_NUMERIC, "");
        //if (!TextUtils.isEmpty(operatorNumeric) && getCdmaMin() != null) {
            //return (operatorNumeric + getCdmaMin());
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.768 -0400", hash_original_method = "8F0255C2E086694196AF7CFC36B7EF43", hash_generated_method = "5CB2C68FBD39ACA2216076055897315A")
    @DSModeled(DSC.SAFE)
    public boolean isMinInfoReady() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIsMinInfoReady;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.768 -0400", hash_original_method = "0E452BF490F5457F3887197BA13C1AF4", hash_generated_method = "F065CB8C2C56146186F61145ACC8C4EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int getOtasp() {
        int provisioningState;
        {
            boolean varBE6EA1BEB15C6575B4E6862F8C2A1A4E_1529295545 = (mMin == null || (mMin.length() < 6));
            {
                log("getOtasp: bad mMin='" + mMin + "'");
                provisioningState = OTASP_UNKNOWN;
            } //End block
            {
                {
                    boolean varC1F4BAB057A6E1164C1F9ABE5370C980_1557669702 = ((mMin.equals(UNACTIVATED_MIN_VALUE)
                    || mMin.substring(0,6).equals(UNACTIVATED_MIN2_VALUE))
                    || SystemProperties.getBoolean("test_cdma_setup", false));
                    {
                        provisioningState = OTASP_NEEDED;
                    } //End block
                    {
                        provisioningState = OTASP_NOT_NEEDED;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        log("getOtasp: state=" + provisioningState);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int provisioningState;
        //if (mMin == null || (mMin.length() < 6)) {
            //if (DBG) log("getOtasp: bad mMin='" + mMin + "'");
            //provisioningState = OTASP_UNKNOWN;
        //} else {
            //if ((mMin.equals(UNACTIVATED_MIN_VALUE)
                    //|| mMin.substring(0,6).equals(UNACTIVATED_MIN2_VALUE))
                    //|| SystemProperties.getBoolean("test_cdma_setup", false)) {
                //provisioningState = OTASP_NEEDED;
            //} else {
                //provisioningState = OTASP_NOT_NEEDED;
            //}
        //}
        //if (DBG) log("getOtasp: state=" + provisioningState);
        //return provisioningState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.769 -0400", hash_original_method = "99845E4FDDAE6236D8C7F396E4374533", hash_generated_method = "8E63CE6D461F9471D4482A19BF636C81")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void hangupAndPowerOff() {
        phone.mCT.ringingCall.hangupIfAlive();
        phone.mCT.backgroundCall.hangupIfAlive();
        phone.mCT.foregroundCall.hangupIfAlive();
        cm.setRadioPower(false, null);
        // ---------- Original Method ----------
        //phone.mCT.ringingCall.hangupIfAlive();
        //phone.mCT.backgroundCall.hangupIfAlive();
        //phone.mCT.foregroundCall.hangupIfAlive();
        //cm.setRadioPower(false, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.769 -0400", hash_original_method = "B2E611749AA45590CADF6B42B9066FE3", hash_generated_method = "D88D5736B8B767C6D886EBE4444AF431")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void parseSidNid(String sidStr, String nidStr) {
        dsTaint.addTaint(nidStr);
        dsTaint.addTaint(sidStr);
        {
            String[] sid;
            sid = sidStr.split(",");
            mHomeSystemId = new int[sid.length];
            {
                int i;
                i = 0;
                {
                    try 
                    {
                        mHomeSystemId[i] = Integer.parseInt(sid[i]);
                    } //End block
                    catch (NumberFormatException ex)
                    {
                        loge("error parsing system id: " + ex);
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        log("CDMA_SUBSCRIPTION: SID=" + sidStr);
        {
            String[] nid;
            nid = nidStr.split(",");
            mHomeNetworkId = new int[nid.length];
            {
                int i;
                i = 0;
                {
                    try 
                    {
                        mHomeNetworkId[i] = Integer.parseInt(nid[i]);
                    } //End block
                    catch (NumberFormatException ex)
                    {
                        loge("CDMA_SUBSCRIPTION: error parsing network id: " + ex);
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        log("CDMA_SUBSCRIPTION: NID=" + nidStr);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.769 -0400", hash_original_method = "610B4A562CE77C76E210E506F221FC8A", hash_generated_method = "D98156DC904682BC1D051A9E298FF84F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void updateOtaspState() {
        int otaspMode;
        otaspMode = getOtasp();
        int oldOtaspMode;
        oldOtaspMode = mCurrentOtaspMode;
        mCurrentOtaspMode = otaspMode;
        {
            log("CDMA_SUBSCRIPTION: call notifyRegistrants()");
            cdmaForSubscriptionInfoReadyRegistrants.notifyRegistrants();
        } //End block
        {
            {
                log("CDMA_SUBSCRIPTION: call notifyOtaspChanged old otaspMode=" +
                    oldOtaspMode + " new otaspMode=" + mCurrentOtaspMode);
            } //End block
            phone.notifyOtaspChanged(mCurrentOtaspMode);
        } //End block
        // ---------- Original Method ----------
        //int otaspMode = getOtasp();
        //int oldOtaspMode = mCurrentOtaspMode;
        //mCurrentOtaspMode = otaspMode;
        //if (cdmaForSubscriptionInfoReadyRegistrants != null) {
            //if (DBG) log("CDMA_SUBSCRIPTION: call notifyRegistrants()");
            //cdmaForSubscriptionInfoReadyRegistrants.notifyRegistrants();
        //}
        //if (oldOtaspMode != mCurrentOtaspMode) {
            //if (DBG) {
                //log("CDMA_SUBSCRIPTION: call notifyOtaspChanged old otaspMode=" +
                    //oldOtaspMode + " new otaspMode=" + mCurrentOtaspMode);
            //}
            //phone.notifyOtaspChanged(mCurrentOtaspMode);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.770 -0400", hash_original_method = "F8EA3CF0B7D491A29C0D20E35CC8F967", hash_generated_method = "D71DFB889F9CF0F0113FDBBF99A8AD4E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void log(String s) {
        dsTaint.addTaint(s);
        Log.d(LOG_TAG, "[CdmaSST] " + s);
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[CdmaSST] " + s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.770 -0400", hash_original_method = "385CD47B6889905FF3482AEA1E26688E", hash_generated_method = "805756270C078279872D509D68B37565")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void loge(String s) {
        dsTaint.addTaint(s);
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[CdmaSST] " + s);
    }

    
    static final String LOG_TAG = "CDMA";
    private static final String UNACTIVATED_MIN2_VALUE = "000000";
    private static final String UNACTIVATED_MIN_VALUE = "1111110111";
    private static final int NITZ_UPDATE_SPACING_DEFAULT = 1000 * 60 * 10;
    private static final int NITZ_UPDATE_DIFF_DEFAULT = 2000;
    private static final String WAKELOCK_TAG = "ServiceStateTracker";
}

