package com.android.internal.telephony.gsm;

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
import com.android.internal.telephony.RestrictedState;
import com.android.internal.telephony.RILConstants;
import com.android.internal.telephony.ServiceStateTracker;
import com.android.internal.telephony.TelephonyIntents;
import com.android.internal.telephony.TelephonyProperties;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
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
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.util.EventLog;
import android.util.Log;
import android.util.TimeUtils;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

final class GsmServiceStateTracker extends ServiceStateTracker {
    GSMPhone phone;
    GsmCellLocation cellLoc;
    GsmCellLocation newCellLoc;
    int mPreferredNetworkType;
    private int gprsState = ServiceState.STATE_OUT_OF_SERVICE;
    private int newGPRSState = ServiceState.STATE_OUT_OF_SERVICE;
    private int mMaxDataCalls = 1;
    private int mNewMaxDataCalls = 1;
    private int mReasonDataDenied = -1;
    private int mNewReasonDataDenied = -1;
    private boolean mGsmRoaming = false;
    private boolean mDataRoaming = false;
    private boolean mEmergencyOnly = false;
    private boolean mNeedFixZone = false;
    private int mZoneOffset;
    private boolean mZoneDst;
    private long mZoneTime;
    private boolean mGotCountryCode = false;
    private ContentResolver cr;
    String mSavedTimeZone;
    long mSavedTime;
    long mSavedAtTime;
    private boolean mNeedToRegForSimLoaded;
    private boolean mStartedGprsRegCheck = false;
    private boolean mReportedGprsNoReg = false;
    private Notification mNotification;
    private PowerManager.WakeLock mWakeLock;
    private String curSpn = null;
    private String curPlmn = null;
    private int curSpnRule = 0;
    private BroadcastReceiver mIntentReceiver = new BroadcastReceiver() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.103 -0400", hash_original_method = "7D33A0984FFB123C6674B46896DDEB1E", hash_generated_method = "7496830E40233A96273E00E5F46601E1")
        @DSModeled(DSC.SPEC)
        @Override
        public void onReceive(Context context, Intent intent) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(context.dsTaint);
            dsTaint.addTaint(intent.dsTaint);
            {
                boolean varD74456F3A5211D970550D171BFD231F1_1889877935 = (intent.getAction().equals(Intent.ACTION_LOCALE_CHANGED));
                {
                    updateSpnDisplay();
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if (intent.getAction().equals(Intent.ACTION_LOCALE_CHANGED)) {
                //updateSpnDisplay();
            //}
        }

        
}; //Transformed anonymous class
    private ContentObserver mAutoTimeObserver = new ContentObserver(new Handler()) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.103 -0400", hash_original_method = "227D40A344094AD4B591040BC6F6DC3D", hash_generated_method = "FDF9127C8053E068FAAD397E8CCFDC66")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void onChange(boolean selfChange) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(selfChange);
            revertToNitzTime();
            // ---------- Original Method ----------
            //Log.i("GsmServiceStateTracker", "Auto time state changed");
            //revertToNitzTime();
        }

        
}; //Transformed anonymous class
    private ContentObserver mAutoTimeZoneObserver = new ContentObserver(new Handler()) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.103 -0400", hash_original_method = "CFFF91BA86D25926B76415F80D2C8421", hash_generated_method = "53B98E2957007ABE10304C4680BDDF10")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void onChange(boolean selfChange) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(selfChange);
            revertToNitzTimeZone();
            // ---------- Original Method ----------
            //Log.i("GsmServiceStateTracker", "Auto time zone state changed");
            //revertToNitzTimeZone();
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.104 -0400", hash_original_method = "89B681C68F2C3DCA55179D15C34AC4AC", hash_generated_method = "85FF0C36AB9B604D18C549B6CF0092BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public GsmServiceStateTracker(GSMPhone phone) {
        super();
        dsTaint.addTaint(phone.dsTaint);
        cm = phone.mCM;
        ss = new ServiceState();
        newSS = new ServiceState();
        cellLoc = new GsmCellLocation();
        newCellLoc = new GsmCellLocation();
        mSignalStrength = new SignalStrength();
        PowerManager powerManager;
        powerManager = (PowerManager)phone.getContext().getSystemService(Context.POWER_SERVICE);
        mWakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, WAKELOCK_TAG);
        cm.registerForAvailable(this, EVENT_RADIO_AVAILABLE, null);
        cm.registerForRadioStateChanged(this, EVENT_RADIO_STATE_CHANGED, null);
        cm.registerForVoiceNetworkStateChanged(this, EVENT_NETWORK_STATE_CHANGED, null);
        cm.setOnNITZTime(this, EVENT_NITZ_TIME, null);
        cm.setOnSignalStrengthUpdate(this, EVENT_SIGNAL_STRENGTH_UPDATE, null);
        cm.setOnRestrictedStateChanged(this, EVENT_RESTRICTED_STATE_CHANGED, null);
        cm.registerForSIMReady(this, EVENT_SIM_READY, null);
        int airplaneMode;
        airplaneMode = Settings.System.getInt(
                phone.getContext().getContentResolver(),
                Settings.System.AIRPLANE_MODE_ON, 0);
        mDesiredPowerState = ! (airplaneMode > 0);
        cr = phone.getContext().getContentResolver();
        cr.registerContentObserver(
                Settings.System.getUriFor(Settings.System.AUTO_TIME), true,
                mAutoTimeObserver);
        cr.registerContentObserver(
                Settings.System.getUriFor(Settings.System.AUTO_TIME_ZONE), true,
                mAutoTimeZoneObserver);
        setSignalStrengthDefaultValues();
        mNeedToRegForSimLoaded = true;
        IntentFilter filter;
        filter = new IntentFilter();
        filter.addAction(Intent.ACTION_LOCALE_CHANGED);
        phone.getContext().registerReceiver(mIntentReceiver, filter);
        phone.notifyOtaspChanged(OTASP_NOT_NEEDED);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.104 -0400", hash_original_method = "D8900B5121A238BBC317864D0A18F1DD", hash_generated_method = "B40ED7CB9364FAE6479A4D45B656DCB0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dispose() {
        cm.unregisterForAvailable(this);
        cm.unregisterForRadioStateChanged(this);
        cm.unregisterForVoiceNetworkStateChanged(this);
        cm.unregisterForSIMReady(this);
        phone.mIccRecords.unregisterForRecordsLoaded(this);
        cm.unSetOnSignalStrengthUpdate(this);
        cm.unSetOnRestrictedStateChanged(this);
        cm.unSetOnNITZTime(this);
        cr.unregisterContentObserver(this.mAutoTimeObserver);
        cr.unregisterContentObserver(this.mAutoTimeZoneObserver);
        // ---------- Original Method ----------
        //cm.unregisterForAvailable(this);
        //cm.unregisterForRadioStateChanged(this);
        //cm.unregisterForVoiceNetworkStateChanged(this);
        //cm.unregisterForSIMReady(this);
        //phone.mIccRecords.unregisterForRecordsLoaded(this);
        //cm.unSetOnSignalStrengthUpdate(this);
        //cm.unSetOnRestrictedStateChanged(this);
        //cm.unSetOnNITZTime(this);
        //cr.unregisterContentObserver(this.mAutoTimeObserver);
        //cr.unregisterContentObserver(this.mAutoTimeZoneObserver);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.104 -0400", hash_original_method = "6FB50CEA8307C4B6093E637FBC3F2923", hash_generated_method = "61ECE0E646E8B1764F5B7DA5FA912912")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void finalize() {
        log("finalize");
        // ---------- Original Method ----------
        //if(DBG) log("finalize");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.105 -0400", hash_original_method = "A0DE0F5E4F4D4787509D60C270D17835", hash_generated_method = "12FC1D7757A2C7075F6CD93B39A12661")
    @DSModeled(DSC.SAFE)
    @Override
    protected Phone getPhone() {
        return (Phone)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return phone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.106 -0400", hash_original_method = "8D6E3CD042747DF0CD652F21C9ED2A0B", hash_generated_method = "CB3A5B2884B0DFE77EF0DBE3702612F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void handleMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        AsyncResult ar;
        int[] ints;
        String[] strings;
        Message message;
        //Begin case EVENT_SIM_READY 
        cm.setCurrentPreferredNetworkType();
        //End case EVENT_SIM_READY 
        //Begin case EVENT_SIM_READY 
        {
            phone.mIccRecords.registerForRecordsLoaded(this,
                            EVENT_SIM_RECORDS_LOADED, null);
            mNeedToRegForSimLoaded = false;
        } //End block
        //End case EVENT_SIM_READY 
        //Begin case EVENT_SIM_READY 
        boolean skipRestoringSelection;
        skipRestoringSelection = phone.getContext().getResources().getBoolean(
                        com.android.internal.R.bool.skip_restoring_network_selection);
        //End case EVENT_SIM_READY 
        //Begin case EVENT_SIM_READY 
        {
            phone.restoreSavedNetworkSelection(null);
        } //End block
        //End case EVENT_SIM_READY 
        //Begin case EVENT_SIM_READY 
        pollState();
        //End case EVENT_SIM_READY 
        //Begin case EVENT_SIM_READY 
        queueNextSignalStrengthPoll();
        //End case EVENT_SIM_READY 
        //Begin case EVENT_RADIO_STATE_CHANGED 
        setPowerStateToDesired();
        //End case EVENT_RADIO_STATE_CHANGED 
        //Begin case EVENT_RADIO_STATE_CHANGED 
        pollState();
        //End case EVENT_RADIO_STATE_CHANGED 
        //Begin case EVENT_NETWORK_STATE_CHANGED 
        pollState();
        //End case EVENT_NETWORK_STATE_CHANGED 
        //Begin case EVENT_GET_SIGNAL_STRENGTH 
        {
            boolean var073B81928925E9A842A5B7D6E127E98B_140975144 = (!(cm.getRadioState().isOn()) || (cm.getRadioState().isCdma()));
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
        //Begin case EVENT_GET_LOC_DONE 
        ar = (AsyncResult) msg.obj;
        //End case EVENT_GET_LOC_DONE 
        //Begin case EVENT_GET_LOC_DONE 
        {
            String states[];
            states = (String[])ar.result;
            int lac;
            lac = -1;
            int cid;
            cid = -1;
            {
                try 
                {
                    {
                        boolean var9D5A64E58810D558AB453A876F76F10A_352283239 = (states[1] != null && states[1].length() > 0);
                        {
                            lac = Integer.parseInt(states[1], 16);
                        } //End block
                    } //End collapsed parenthetic
                    {
                        boolean varE1384D31A474A975FC250415D1CF0A98_806831946 = (states[2] != null && states[2].length() > 0);
                        {
                            cid = Integer.parseInt(states[2], 16);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                catch (NumberFormatException ex)
                { }
            } //End block
            cellLoc.setLacAndCid(lac, cid);
            phone.notifyLocationChanged();
        } //End block
        //End case EVENT_GET_LOC_DONE 
        //Begin case EVENT_GET_LOC_DONE 
        disableSingleLocationUpdate();
        //End case EVENT_GET_LOC_DONE 
        //Begin case EVENT_POLL_STATE_REGISTRATION EVENT_POLL_STATE_GPRS EVENT_POLL_STATE_OPERATOR EVENT_POLL_STATE_NETWORK_SELECTION_MODE 
        ar = (AsyncResult) msg.obj;
        //End case EVENT_POLL_STATE_REGISTRATION EVENT_POLL_STATE_GPRS EVENT_POLL_STATE_OPERATOR EVENT_POLL_STATE_NETWORK_SELECTION_MODE 
        //Begin case EVENT_POLL_STATE_REGISTRATION EVENT_POLL_STATE_GPRS EVENT_POLL_STATE_OPERATOR EVENT_POLL_STATE_NETWORK_SELECTION_MODE 
        handlePollStateResult(msg.what, ar);
        //End case EVENT_POLL_STATE_REGISTRATION EVENT_POLL_STATE_GPRS EVENT_POLL_STATE_OPERATOR EVENT_POLL_STATE_NETWORK_SELECTION_MODE 
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
        //Begin case EVENT_SIM_RECORDS_LOADED 
        updateSpnDisplay();
        //End case EVENT_SIM_RECORDS_LOADED 
        //Begin case EVENT_LOCATION_UPDATES_ENABLED 
        ar = (AsyncResult) msg.obj;
        //End case EVENT_LOCATION_UPDATES_ENABLED 
        //Begin case EVENT_LOCATION_UPDATES_ENABLED 
        {
            cm.getVoiceRegistrationState(obtainMessage(EVENT_GET_LOC_DONE, null));
        } //End block
        //End case EVENT_LOCATION_UPDATES_ENABLED 
        //Begin case EVENT_SET_PREFERRED_NETWORK_TYPE 
        ar = (AsyncResult) msg.obj;
        //End case EVENT_SET_PREFERRED_NETWORK_TYPE 
        //Begin case EVENT_SET_PREFERRED_NETWORK_TYPE 
        message = obtainMessage(EVENT_RESET_PREFERRED_NETWORK_TYPE, ar.userObj);
        //End case EVENT_SET_PREFERRED_NETWORK_TYPE 
        //Begin case EVENT_SET_PREFERRED_NETWORK_TYPE 
        cm.setPreferredNetworkType(mPreferredNetworkType, message);
        //End case EVENT_SET_PREFERRED_NETWORK_TYPE 
        //Begin case EVENT_RESET_PREFERRED_NETWORK_TYPE 
        ar = (AsyncResult) msg.obj;
        //End case EVENT_RESET_PREFERRED_NETWORK_TYPE 
        //Begin case EVENT_RESET_PREFERRED_NETWORK_TYPE 
        {
            AsyncResult.forMessage(((Message) ar.userObj)).exception
                            = ar.exception;
            ((Message) ar.userObj).sendToTarget();
        } //End block
        //End case EVENT_RESET_PREFERRED_NETWORK_TYPE 
        //Begin case EVENT_GET_PREFERRED_NETWORK_TYPE 
        ar = (AsyncResult) msg.obj;
        //End case EVENT_GET_PREFERRED_NETWORK_TYPE 
        //Begin case EVENT_GET_PREFERRED_NETWORK_TYPE 
        {
            mPreferredNetworkType = ((int[])ar.result)[0];
        } //End block
        {
            mPreferredNetworkType = RILConstants.NETWORK_MODE_GLOBAL;
        } //End block
        //End case EVENT_GET_PREFERRED_NETWORK_TYPE 
        //Begin case EVENT_GET_PREFERRED_NETWORK_TYPE 
        message = obtainMessage(EVENT_SET_PREFERRED_NETWORK_TYPE, ar.userObj);
        //End case EVENT_GET_PREFERRED_NETWORK_TYPE 
        //Begin case EVENT_GET_PREFERRED_NETWORK_TYPE 
        int toggledNetworkType;
        toggledNetworkType = RILConstants.NETWORK_MODE_GLOBAL;
        //End case EVENT_GET_PREFERRED_NETWORK_TYPE 
        //Begin case EVENT_GET_PREFERRED_NETWORK_TYPE 
        cm.setPreferredNetworkType(toggledNetworkType, message);
        //End case EVENT_GET_PREFERRED_NETWORK_TYPE 
        //Begin case EVENT_CHECK_REPORT_GPRS 
        {
            boolean varFC20FFEE0B571214859D080B805B15AB_1890460792 = (ss != null && !isGprsConsistent(gprsState, ss.getState()));
            {
                GsmCellLocation loc;
                loc = ((GsmCellLocation)phone.getCellLocation());
                EventLog.writeEvent(EventLogTags.DATA_NETWORK_REGISTRATION_FAIL,
                            ss.getOperatorNumeric(), loc != null ? loc.getCid() : -1);
                mReportedGprsNoReg = true;
            } //End block
        } //End collapsed parenthetic
        //End case EVENT_CHECK_REPORT_GPRS 
        //Begin case EVENT_CHECK_REPORT_GPRS 
        mStartedGprsRegCheck = false;
        //End case EVENT_CHECK_REPORT_GPRS 
        //Begin case EVENT_RESTRICTED_STATE_CHANGED 
        log("EVENT_RESTRICTED_STATE_CHANGED");
        //End case EVENT_RESTRICTED_STATE_CHANGED 
        //Begin case EVENT_RESTRICTED_STATE_CHANGED 
        ar = (AsyncResult) msg.obj;
        //End case EVENT_RESTRICTED_STATE_CHANGED 
        //Begin case EVENT_RESTRICTED_STATE_CHANGED 
        onRestrictedStateChanged(ar);
        //End case EVENT_RESTRICTED_STATE_CHANGED 
        //Begin case default 
        super.handleMessage(msg);
        //End case default 
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.107 -0400", hash_original_method = "BC2E3346E1E8D048BB892FC104E776BC", hash_generated_method = "BB5E1F959FE623BCB57D24EBEACE0DB8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void setPowerStateToDesired() {
        {
            boolean var132800EA641B7653EC59634384D41AC8_1287771159 = (mDesiredPowerState
            && cm.getRadioState() == CommandsInterface.RadioState.RADIO_OFF);
            {
                cm.setRadioPower(true, null);
            } //End block
            {
                boolean var9EF9CD1D5966856073F2A7E801160763_142035502 = (!mDesiredPowerState && cm.getRadioState().isOn());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.107 -0400", hash_original_method = "E3C7A91B3D91C3ACB7BE5D936C3A4029", hash_generated_method = "9053B627112B886056FA48CF9C47D36F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void hangupAndPowerOff() {
        {
            boolean varC2DAA1612218A41C583800F71FEEEFE0_810769773 = (phone.isInCall());
            {
                phone.mCT.ringingCall.hangupIfAlive();
                phone.mCT.backgroundCall.hangupIfAlive();
                phone.mCT.foregroundCall.hangupIfAlive();
            } //End block
        } //End collapsed parenthetic
        cm.setRadioPower(false, null);
        // ---------- Original Method ----------
        //if (phone.isInCall()) {
            //phone.mCT.ringingCall.hangupIfAlive();
            //phone.mCT.backgroundCall.hangupIfAlive();
            //phone.mCT.foregroundCall.hangupIfAlive();
        //}
        //cm.setRadioPower(false, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.107 -0400", hash_original_method = "12AE11DB9489E0514D18AAE66522FB76", hash_generated_method = "A3215562848538C03DB03BE95A016688")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void updateSpnDisplay() {
        int rule;
        rule = phone.mIccRecords.getDisplayRule(ss.getOperatorNumeric());
        String spn;
        spn = phone.mIccRecords.getServiceProviderName();
        String plmn;
        plmn = ss.getOperatorAlphaLong();
        {
            boolean var06D0886726202C33A42C3319B2FBCFA6_222941142 = (mEmergencyOnly && cm.getRadioState().isOn());
            {
                plmn = Resources.getSystem().
                getText(com.android.internal.R.string.emergency_calls_only).toString();
                log("updateSpnDisplay: emergency only and radio is on plmn='" + plmn + "'");
            } //End block
        } //End collapsed parenthetic
        {
            boolean varBB23ADBA0F49FDA2EE72E8A6C8D8F6D8_72736784 = (rule != curSpnRule
                || !TextUtils.equals(spn, curSpn)
                || !TextUtils.equals(plmn, curPlmn));
            {
                boolean showSpn;
                showSpn = !mEmergencyOnly && !TextUtils.isEmpty(spn)
                && (rule & SIMRecords.SPN_RULE_SHOW_SPN) == SIMRecords.SPN_RULE_SHOW_SPN;
                boolean showPlmn;
                showPlmn = !TextUtils.isEmpty(plmn) &&
                (rule & SIMRecords.SPN_RULE_SHOW_PLMN) == SIMRecords.SPN_RULE_SHOW_PLMN;
                {
                    log(String.format("updateSpnDisplay: changed sending intent" + " rule=" + rule +
                            " showPlmn='%b' plmn='%s' showSpn='%b' spn='%s'",
                            showPlmn, plmn, showSpn, spn));
                } //End block
                Intent intent;
                intent = new Intent(Intents.SPN_STRINGS_UPDATED_ACTION);
                intent.addFlags(Intent.FLAG_RECEIVER_REPLACE_PENDING);
                intent.putExtra(Intents.EXTRA_SHOW_SPN, showSpn);
                intent.putExtra(Intents.EXTRA_SPN, spn);
                intent.putExtra(Intents.EXTRA_SHOW_PLMN, showPlmn);
                intent.putExtra(Intents.EXTRA_PLMN, plmn);
                phone.getContext().sendStickyBroadcast(intent);
            } //End block
        } //End collapsed parenthetic
        curSpnRule = rule;
        curSpn = spn;
        curPlmn = plmn;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.109 -0400", hash_original_method = "715C325B720DBA72DF5B4684F1B692D5", hash_generated_method = "ECE9554B28ABC36537357555B818BFC9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void handlePollStateResult(int what, AsyncResult ar) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(ar.dsTaint);
        int ints[];
        String states[];
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
                boolean var0F541275CA306A5F1AC77D786FD54CFD_898872132 = (!cm.getRadioState().isOn());
                {
                    cancelPollState();
                } //End block
            } //End collapsed parenthetic
            {
                loge("RIL implementation has returned an error where it must succeed" +
                        ar.exception);
            } //End block
        } //End block
        try 
        {
            //Begin case EVENT_POLL_STATE_REGISTRATION 
            states = (String[])ar.result;
            //End case EVENT_POLL_STATE_REGISTRATION 
            //Begin case EVENT_POLL_STATE_REGISTRATION 
            int lac;
            lac = -1;
            //End case EVENT_POLL_STATE_REGISTRATION 
            //Begin case EVENT_POLL_STATE_REGISTRATION 
            int cid;
            cid = -1;
            //End case EVENT_POLL_STATE_REGISTRATION 
            //Begin case EVENT_POLL_STATE_REGISTRATION 
            int regState;
            regState = -1;
            //End case EVENT_POLL_STATE_REGISTRATION 
            //Begin case EVENT_POLL_STATE_REGISTRATION 
            int reasonRegStateDenied;
            reasonRegStateDenied = -1;
            //End case EVENT_POLL_STATE_REGISTRATION 
            //Begin case EVENT_POLL_STATE_REGISTRATION 
            int psc;
            psc = -1;
            //End case EVENT_POLL_STATE_REGISTRATION 
            //Begin case EVENT_POLL_STATE_REGISTRATION 
            {
                try 
                {
                    regState = Integer.parseInt(states[0]);
                    {
                        {
                            boolean varC8FB6E238E31780D1F2471C052768A12_382821492 = (states[1] != null && states[1].length() > 0);
                            {
                                lac = Integer.parseInt(states[1], 16);
                            } //End block
                        } //End collapsed parenthetic
                        {
                            boolean var8EA46D418EFE8869C53A8FFB1B763349_2049079115 = (states[2] != null && states[2].length() > 0);
                            {
                                cid = Integer.parseInt(states[2], 16);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        {
                            boolean var4770B9A59F4D2AA52CA9C0062D193D69_8979614 = (states[14] != null && states[14].length() > 0);
                            {
                                psc = Integer.parseInt(states[14], 16);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End block
                catch (NumberFormatException ex)
                {
                    loge("error parsing RegistrationState: " + ex);
                } //End block
            } //End block
            //End case EVENT_POLL_STATE_REGISTRATION 
            //Begin case EVENT_POLL_STATE_REGISTRATION 
            mGsmRoaming = regCodeIsRoaming(regState);
            //End case EVENT_POLL_STATE_REGISTRATION 
            //Begin case EVENT_POLL_STATE_REGISTRATION 
            newSS.setState (regCodeToServiceState(regState));
            //End case EVENT_POLL_STATE_REGISTRATION 
            //Begin case EVENT_POLL_STATE_REGISTRATION 
            {
                mEmergencyOnly = true;
            } //End block
            {
                mEmergencyOnly = false;
            } //End block
            //End case EVENT_POLL_STATE_REGISTRATION 
            //Begin case EVENT_POLL_STATE_REGISTRATION 
            newCellLoc.setLacAndCid(lac, cid);
            //End case EVENT_POLL_STATE_REGISTRATION 
            //Begin case EVENT_POLL_STATE_REGISTRATION 
            newCellLoc.setPsc(psc);
            //End case EVENT_POLL_STATE_REGISTRATION 
            //Begin case EVENT_POLL_STATE_GPRS 
            states = (String[])ar.result;
            //End case EVENT_POLL_STATE_GPRS 
            //Begin case EVENT_POLL_STATE_GPRS 
            int type;
            type = 0;
            //End case EVENT_POLL_STATE_GPRS 
            //Begin case EVENT_POLL_STATE_GPRS 
            regState = -1;
            //End case EVENT_POLL_STATE_GPRS 
            //Begin case EVENT_POLL_STATE_GPRS 
            mNewReasonDataDenied = -1;
            //End case EVENT_POLL_STATE_GPRS 
            //Begin case EVENT_POLL_STATE_GPRS 
            mNewMaxDataCalls = 1;
            //End case EVENT_POLL_STATE_GPRS 
            //Begin case EVENT_POLL_STATE_GPRS 
            {
                try 
                {
                    regState = Integer.parseInt(states[0]);
                    {
                        type = Integer.parseInt(states[3]);
                    } //End block
                    {
                        mNewReasonDataDenied = Integer.parseInt(states[4]);
                    } //End block
                    {
                        mNewMaxDataCalls = Integer.parseInt(states[5]);
                    } //End block
                } //End block
                catch (NumberFormatException ex)
                {
                    loge("error parsing GprsRegistrationState: " + ex);
                } //End block
            } //End block
            //End case EVENT_POLL_STATE_GPRS 
            //Begin case EVENT_POLL_STATE_GPRS 
            newGPRSState = regCodeToServiceState(regState);
            //End case EVENT_POLL_STATE_GPRS 
            //Begin case EVENT_POLL_STATE_GPRS 
            mDataRoaming = regCodeIsRoaming(regState);
            //End case EVENT_POLL_STATE_GPRS 
            //Begin case EVENT_POLL_STATE_GPRS 
            mNewRadioTechnology = type;
            //End case EVENT_POLL_STATE_GPRS 
            //Begin case EVENT_POLL_STATE_GPRS 
            newSS.setRadioTechnology(type);
            //End case EVENT_POLL_STATE_GPRS 
            //Begin case EVENT_POLL_STATE_OPERATOR 
            String opNames[];
            opNames = (String[])ar.result;
            //End case EVENT_POLL_STATE_OPERATOR 
            //Begin case EVENT_POLL_STATE_OPERATOR 
            {
                newSS.setOperatorName (
                                opNames[0], opNames[1], opNames[2]);
            } //End block
            //End case EVENT_POLL_STATE_OPERATOR 
            //Begin case EVENT_POLL_STATE_NETWORK_SELECTION_MODE 
            ints = (int[])ar.result;
            //End case EVENT_POLL_STATE_NETWORK_SELECTION_MODE 
            //Begin case EVENT_POLL_STATE_NETWORK_SELECTION_MODE 
            newSS.setIsManualSelection(ints[0] == 1);
            //End case EVENT_POLL_STATE_NETWORK_SELECTION_MODE 
        } //End block
        catch (RuntimeException ex)
        {
            loge("Exception while polling service state. Probably malformed RIL response." + ex);
        } //End block
        {
            boolean roaming;
            roaming = (mGsmRoaming || mDataRoaming);
            {
                boolean varAD836B3792BA6824B78D98F7D142DE65_1930810648 = (mGsmRoaming && !isRoamingBetweenOperators(mGsmRoaming, newSS));
                {
                    roaming = false;
                } //End block
            } //End collapsed parenthetic
            newSS.setRoaming(roaming);
            newSS.setEmergencyOnly(mEmergencyOnly);
            pollStateDone();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.109 -0400", hash_original_method = "EDDD8B52093FAB0325AD8F1D0B8DD010", hash_generated_method = "64B9469868212149744CDD3832E179AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setSignalStrengthDefaultValues() {
        mSignalStrength = new SignalStrength(99, -1, -1, -1, -1, -1, -1,
                -1, -1, -1, SignalStrength.INVALID_SNR, -1, true);
        // ---------- Original Method ----------
        //mSignalStrength = new SignalStrength(99, -1, -1, -1, -1, -1, -1,
                //-1, -1, -1, SignalStrength.INVALID_SNR, -1, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.110 -0400", hash_original_method = "4A9AA9B5E92E73D941CD4914D7782EA3", hash_generated_method = "0D57CC3D2AD7ED2C70380D8CFB414FE9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void pollState() {
        pollingContext = new int[1];
        pollingContext[0] = 0;
        {
            Object varA9E12DC9226BD6A76EE86EBF3C63475C_1063118967 = (cm.getRadioState());
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
            //Begin case RUIM_NOT_READY RUIM_READY RUIM_LOCKED_OR_ABSENT NV_NOT_READY NV_READY 
            log("Radio Technology Change ongoing, setting SS to off");
            //End case RUIM_NOT_READY RUIM_READY RUIM_LOCKED_OR_ABSENT NV_NOT_READY NV_READY 
            //Begin case RUIM_NOT_READY RUIM_READY RUIM_LOCKED_OR_ABSENT NV_NOT_READY NV_READY 
            newSS.setStateOff();
            //End case RUIM_NOT_READY RUIM_READY RUIM_LOCKED_OR_ABSENT NV_NOT_READY NV_READY 
            //Begin case RUIM_NOT_READY RUIM_READY RUIM_LOCKED_OR_ABSENT NV_NOT_READY NV_READY 
            newCellLoc.setStateInvalid();
            //End case RUIM_NOT_READY RUIM_READY RUIM_LOCKED_OR_ABSENT NV_NOT_READY NV_READY 
            //Begin case RUIM_NOT_READY RUIM_READY RUIM_LOCKED_OR_ABSENT NV_NOT_READY NV_READY 
            setSignalStrengthDefaultValues();
            //End case RUIM_NOT_READY RUIM_READY RUIM_LOCKED_OR_ABSENT NV_NOT_READY NV_READY 
            //Begin case RUIM_NOT_READY RUIM_READY RUIM_LOCKED_OR_ABSENT NV_NOT_READY NV_READY 
            mGotCountryCode = false;
            //End case RUIM_NOT_READY RUIM_READY RUIM_LOCKED_OR_ABSENT NV_NOT_READY NV_READY 
            //Begin case default 
            cm.getOperator(
                    obtainMessage(
                        EVENT_POLL_STATE_OPERATOR, pollingContext));
            //End case default 
            //Begin case default 
            cm.getDataRegistrationState(
                    obtainMessage(
                        EVENT_POLL_STATE_GPRS, pollingContext));
            //End case default 
            //Begin case default 
            cm.getVoiceRegistrationState(
                    obtainMessage(
                        EVENT_POLL_STATE_REGISTRATION, pollingContext));
            //End case default 
            //Begin case default 
            cm.getNetworkSelectionMode(
                    obtainMessage(
                        EVENT_POLL_STATE_NETWORK_SELECTION_MODE, pollingContext));
            //End case default 
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.112 -0400", hash_original_method = "9E4E42BAC69A7F7033D249A5EA2291CC", hash_generated_method = "8F14E367E16F6641AE4AE09D527F4BA5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void pollStateDone() {
        {
            log("Poll ServiceState done: " +
                " oldSS=[" + ss + "] newSS=[" + newSS +
                "] oldGprs=" + gprsState + " newData=" + newGPRSState +
                " oldMaxDataCalls=" + mMaxDataCalls +
                " mNewMaxDataCalls=" + mNewMaxDataCalls +
                " oldReasonDataDenied=" + mReasonDataDenied +
                " mNewReasonDataDenied=" + mNewReasonDataDenied +
                " oldType=" + ServiceState.radioTechnologyToString(mRadioTechnology) +
                " newType=" + ServiceState.radioTechnologyToString(mNewRadioTechnology));
        } //End block
        boolean hasRegistered;
        hasRegistered = ss.getState() != ServiceState.STATE_IN_SERVICE
            && newSS.getState() == ServiceState.STATE_IN_SERVICE;
        boolean hasDeregistered;
        hasDeregistered = ss.getState() == ServiceState.STATE_IN_SERVICE
            && newSS.getState() != ServiceState.STATE_IN_SERVICE;
        boolean hasGprsAttached;
        hasGprsAttached = gprsState != ServiceState.STATE_IN_SERVICE
                && newGPRSState == ServiceState.STATE_IN_SERVICE;
        boolean hasGprsDetached;
        hasGprsDetached = gprsState == ServiceState.STATE_IN_SERVICE
                && newGPRSState != ServiceState.STATE_IN_SERVICE;
        boolean hasRadioTechnologyChanged;
        hasRadioTechnologyChanged = mRadioTechnology != mNewRadioTechnology;
        boolean hasChanged;
        hasChanged = !newSS.equals(ss);
        boolean hasRoamingOn;
        hasRoamingOn = !ss.getRoaming() && newSS.getRoaming();
        boolean hasRoamingOff;
        hasRoamingOff = ss.getRoaming() && !newSS.getRoaming();
        boolean hasLocationChanged;
        hasLocationChanged = !newCellLoc.equals(cellLoc);
        {
            boolean var143E8442CDD705F27BFDBD395C253EC4_990313356 = (ss.getState() != newSS.getState() || gprsState != newGPRSState);
            {
                EventLog.writeEvent(EventLogTags.GSM_SERVICE_STATE_CHANGE,
                ss.getState(), gprsState, newSS.getState(), newGPRSState);
            } //End block
        } //End collapsed parenthetic
        ServiceState tss;
        tss = ss;
        ss = newSS;
        newSS = tss;
        newSS.setStateOutOfService();
        GsmCellLocation tcl;
        tcl = cellLoc;
        cellLoc = newCellLoc;
        newCellLoc = tcl;
        {
            int cid;
            cid = -1;
            GsmCellLocation loc;
            loc = ((GsmCellLocation)phone.getCellLocation());
            cid = loc.getCid();
            EventLog.writeEvent(EventLogTags.GSM_RAT_SWITCHED, cid, mRadioTechnology,
                    mNewRadioTechnology);
            {
                log("RAT switched " + ServiceState.radioTechnologyToString(mRadioTechnology) +
                        " -> " + ServiceState.radioTechnologyToString(mNewRadioTechnology) +
                        " at cell " + cid);
            } //End block
        } //End block
        gprsState = newGPRSState;
        mReasonDataDenied = mNewReasonDataDenied;
        mMaxDataCalls = mNewMaxDataCalls;
        mRadioTechnology = mNewRadioTechnology;
        mNewRadioTechnology = 0;
        newSS.setStateOutOfService();
        {
            phone.setSystemProperty(TelephonyProperties.PROPERTY_DATA_NETWORK_TYPE,
                    ServiceState.radioTechnologyToString(mRadioTechnology));
        } //End block
        {
            mNetworkAttachedRegistrants.notifyRegistrants();
        } //End block
        {
            String operatorNumeric;
            updateSpnDisplay();
            phone.setSystemProperty(TelephonyProperties.PROPERTY_OPERATOR_ALPHA,
                ss.getOperatorAlphaLong());
            operatorNumeric = ss.getOperatorNumeric();
            phone.setSystemProperty(TelephonyProperties.PROPERTY_OPERATOR_NUMERIC, operatorNumeric);
            {
                phone.setSystemProperty(TelephonyProperties.PROPERTY_OPERATOR_ISO_COUNTRY, "");
                mGotCountryCode = false;
            } //End block
            {
                String iso;
                iso = "";
                try 
                {
                    iso = MccTable.countryCodeForMcc(Integer.parseInt(
                            operatorNumeric.substring(0,3)));
                } //End block
                catch (NumberFormatException ex)
                {
                    loge("countryCodeForMcc error" + ex);
                } //End block
                catch (StringIndexOutOfBoundsException ex)
                {
                    loge("countryCodeForMcc error" + ex);
                } //End block
                phone.setSystemProperty(TelephonyProperties.PROPERTY_OPERATOR_ISO_COUNTRY, iso);
                mGotCountryCode = true;
                {
                    TimeZone zone;
                    zone = null;
                    String zoneName;
                    zoneName = SystemProperties.get(TIMEZONE_PROPERTY);
                    {
                        boolean var68D6F084332C821EF64E4C77B25B0DC4_138874423 = ((mZoneOffset == 0) && (mZoneDst == false) &&
                        (zoneName != null) && (zoneName.length() > 0) &&
                        (Arrays.binarySearch(GMT_COUNTRY_CODES, iso) < 0));
                        {
                            zone = TimeZone.getDefault();
                            long tzOffset;
                            tzOffset = zone.getOffset(System.currentTimeMillis());
                            {
                                boolean var7389FF14414E14F8B6D3FDF104094769_1291091082 = (getAutoTime());
                                {
                                    setAndBroadcastNetworkSetTime(System.currentTimeMillis() - tzOffset);
                                } //End block
                                {
                                    mSavedTime = mSavedTime - tzOffset;
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                        {
                            boolean var9783B72CD950E393F287DC68561B68E2_1511651028 = (iso.equals(""));
                            {
                                zone = getNitzTimeZone(mZoneOffset, mZoneDst, mZoneTime);
                            } //End block
                            {
                                zone = TimeUtils.getTimeZone(mZoneOffset,
                            mZoneDst, mZoneTime, iso);
                            } //End block
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                    mNeedFixZone = false;
                    {
                        {
                            boolean var8C3187FEB0B5319AAFFAA38FD3B51A47_865373202 = (getAutoTimeZone());
                            {
                                setAndBroadcastNetworkSetTimeZone(zone.getID());
                            } //End block
                        } //End collapsed parenthetic
                        saveNitzTimeZone(zone.getID());
                    } //End block
                } //End block
            } //End block
            phone.setSystemProperty(TelephonyProperties.PROPERTY_OPERATOR_ISROAMING,
                ss.getRoaming() ? "true" : "false");
            phone.notifyServiceStateChanged(ss);
        } //End block
        {
            mAttachedRegistrants.notifyRegistrants();
        } //End block
        {
            mDetachedRegistrants.notifyRegistrants();
        } //End block
        {
            phone.notifyDataConnection(Phone.REASON_NW_TYPE_CHANGED);
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
        {
            boolean var6FA3360FAB78058EDA6E2BDBDB6E6F00_2116437646 = (! isGprsConsistent(gprsState, ss.getState()));
            {
                {
                    mStartedGprsRegCheck = true;
                    int check_period;
                    check_period = Settings.Secure.getInt(
                        phone.getContext().getContentResolver(),
                        Settings.Secure.GPRS_REGISTER_CHECK_PERIOD_MS,
                        DEFAULT_GPRS_CHECK_PERIOD_MILLIS);
                    sendMessageDelayed(obtainMessage(EVENT_CHECK_REPORT_GPRS),
                        check_period);
                } //End block
            } //End block
            {
                mReportedGprsNoReg = false;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.112 -0400", hash_original_method = "FF36AACCF1BD8DBC263BCA1FAF3CB26B", hash_generated_method = "DDDFEC78FD14C7A4C4EBE051815FDEAF")
    @DSModeled(DSC.SAFE)
    private boolean isGprsConsistent(int gprsState, int serviceState) {
        dsTaint.addTaint(gprsState);
        dsTaint.addTaint(serviceState);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return !((serviceState == ServiceState.STATE_IN_SERVICE) &&
                //(gprsState != ServiceState.STATE_IN_SERVICE));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.112 -0400", hash_original_method = "99CED85D89C5E9DD8967FF1E935BF80B", hash_generated_method = "67DA25E7A51F40CCD2B2BD5C93ECDFB3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.117 -0400", hash_original_method = "950DB35A634BB86898B3E74AA5BE6013", hash_generated_method = "1CBAF0EE7B4C28B06E357B665393EF8D")
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
                    boolean varB4FE0ADBDC9FF1B95A6CA053AB3FC7C2_1501539821 = (tz.getOffset(when) == offset &&
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.118 -0400", hash_original_method = "C454880D3BFCEEC9D9AA3258CF5DFAC4", hash_generated_method = "F981CE051876B1FF970225543F7F9B33")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void queueNextSignalStrengthPoll() {
        {
            boolean varFABDBA341AB8460B23C73AA303ECC474_1523338088 = (dontPollSignalStrength || (cm.getRadioState().isCdma()));
        } //End collapsed parenthetic
        Message msg;
        msg = obtainMessage();
        msg.what = EVENT_POLL_SIGNAL_STRENGTH;
        long nextTime;
        sendMessageDelayed(msg, POLL_PERIOD_MILLIS);
        // ---------- Original Method ----------
        //if (dontPollSignalStrength || (cm.getRadioState().isCdma())) {
            //return;
        //}
        //Message msg;
        //msg = obtainMessage();
        //msg.what = EVENT_POLL_SIGNAL_STRENGTH;
        //long nextTime;
        //sendMessageDelayed(msg, POLL_PERIOD_MILLIS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.119 -0400", hash_original_method = "B7FC7124E4251D4EAC65F3E54CB69CDB", hash_generated_method = "E15D52C0444F1C56121D6877E93355B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void onSignalStrengthResult(AsyncResult ar) {
        dsTaint.addTaint(ar.dsTaint);
        SignalStrength oldSignalStrength;
        oldSignalStrength = mSignalStrength;
        int rssi;
        rssi = 99;
        int lteSignalStrength;
        lteSignalStrength = -1;
        int lteRsrp;
        lteRsrp = -1;
        int lteRsrq;
        lteRsrq = -1;
        int lteRssnr;
        lteRssnr = SignalStrength.INVALID_SNR;
        int lteCqi;
        lteCqi = -1;
        {
            setSignalStrengthDefaultValues();
        } //End block
        {
            int[] ints;
            ints = (int[])ar.result;
            {
                rssi = ints[0];
                lteSignalStrength = ints[7];
                lteRsrp = ints[8];
                lteRsrq = ints[9];
                lteRssnr = ints[10];
                lteCqi = ints[11];
            } //End block
            {
                loge("Bogus signal strength response");
                rssi = 99;
            } //End block
        } //End block
        mSignalStrength = new SignalStrength(rssi, -1, -1, -1,
                -1, -1, -1, lteSignalStrength, lteRsrp, lteRsrq, lteRssnr, lteCqi, true);
        {
            boolean varD8EB70D7FE26A23D3B6D37D6BCE88E3C_951853700 = (!mSignalStrength.equals(oldSignalStrength));
            {
                try 
                {
                    phone.notifySignalStrength();
                } //End block
                catch (NullPointerException ex)
                {
                    log("onSignalStrengthResult() Phone already destroyed: " + ex
                        + "SignalStrength not notified");
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.121 -0400", hash_original_method = "F4F35E6AADE0C2C218C2CEC9E86259B9", hash_generated_method = "1C38FED5CC36EFF7C68FBBD26C94BE14")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void onRestrictedStateChanged(AsyncResult ar) {
        dsTaint.addTaint(ar.dsTaint);
        RestrictedState newRs;
        newRs = new RestrictedState();
        log("onRestrictedStateChanged: E rs "+ mRestrictedState);
        {
            int[] ints;
            ints = (int[])ar.result;
            int state;
            state = ints[0];
            newRs.setCsEmergencyRestricted(
                    ((state & RILConstants.RIL_RESTRICTED_STATE_CS_EMERGENCY) != 0) ||
                    ((state & RILConstants.RIL_RESTRICTED_STATE_CS_ALL) != 0) );
            {
                boolean var8951092E4795D8AB36D9F0A620B3D692_898187316 = (phone.getIccCard().getState() == IccCard.State.READY);
                {
                    newRs.setCsNormalRestricted(
                        ((state & RILConstants.RIL_RESTRICTED_STATE_CS_NORMAL) != 0) ||
                        ((state & RILConstants.RIL_RESTRICTED_STATE_CS_ALL) != 0) );
                    newRs.setPsRestricted(
                        (state & RILConstants.RIL_RESTRICTED_STATE_PS_ALL)!= 0);
                } //End block
            } //End collapsed parenthetic
            log("onRestrictedStateChanged: new rs "+ newRs);
            {
                boolean var66F9C6FA34536C8CECFFECE8CBFB966C_261906418 = (!mRestrictedState.isPsRestricted() && newRs.isPsRestricted());
                {
                    mPsRestrictEnabledRegistrants.notifyRegistrants();
                    setNotification(PS_ENABLED);
                } //End block
                {
                    boolean var47985A63347641E23B69047B0CA95809_5631883 = (mRestrictedState.isPsRestricted() && !newRs.isPsRestricted());
                    {
                        mPsRestrictDisabledRegistrants.notifyRegistrants();
                        setNotification(PS_DISABLED);
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            {
                boolean var53CEA09ECC26E3CE282C559753298FAD_498969194 = (mRestrictedState.isCsRestricted());
                {
                    {
                        boolean varFD345861E06AAC1F02808B8100871262_878638903 = (!newRs.isCsRestricted());
                        {
                            setNotification(CS_DISABLED);
                        } //End block
                        {
                            boolean varF775F10526A2915A904B830F05D29343_1838751492 = (!newRs.isCsNormalRestricted());
                            {
                                setNotification(CS_EMERGENCY_ENABLED);
                            } //End block
                            {
                                boolean var848D99B0CB2E1F9969677D8CFB6BDE41_177850652 = (!newRs.isCsEmergencyRestricted());
                                {
                                    setNotification(CS_NORMAL_ENABLED);
                                } //End block
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean var8425B7AAE555ACB534CBBFB232933383_2048119029 = (mRestrictedState.isCsEmergencyRestricted() &&
                    !mRestrictedState.isCsNormalRestricted());
                    {
                        {
                            boolean var57C46803FA0EBC9793E13B85074E4774_76196551 = (!newRs.isCsRestricted());
                            {
                                setNotification(CS_DISABLED);
                            } //End block
                            {
                                boolean var27346B4CFE3FD828EAA0C980B0F71B77_2142313663 = (newRs.isCsRestricted());
                                {
                                    setNotification(CS_ENABLED);
                                } //End block
                                {
                                    boolean varA6445632BAC49F059B36EB0EE223CBF3_721885285 = (newRs.isCsNormalRestricted());
                                    {
                                        setNotification(CS_NORMAL_ENABLED);
                                    } //End block
                                } //End collapsed parenthetic
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End block
                    {
                        boolean var8B9B8A10D1E1D0780F2ADC08103E1156_1244226005 = (!mRestrictedState.isCsEmergencyRestricted() &&
                    mRestrictedState.isCsNormalRestricted());
                        {
                            {
                                boolean var0C960E3B23E0FE22C0136CA55F39BD3C_1825118813 = (!newRs.isCsRestricted());
                                {
                                    setNotification(CS_DISABLED);
                                } //End block
                                {
                                    boolean var781BCA8B76F7E4DD7490A8CCA199987B_1276991583 = (newRs.isCsRestricted());
                                    {
                                        setNotification(CS_ENABLED);
                                    } //End block
                                    {
                                        boolean var8D1515582205D7E6089169936842A19F_684395334 = (newRs.isCsEmergencyRestricted());
                                        {
                                            setNotification(CS_EMERGENCY_ENABLED);
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End collapsed parenthetic
                            } //End collapsed parenthetic
                        } //End block
                        {
                            {
                                boolean var27346B4CFE3FD828EAA0C980B0F71B77_192188533 = (newRs.isCsRestricted());
                                {
                                    setNotification(CS_ENABLED);
                                } //End block
                                {
                                    boolean varE95AEEA60DFE465EF47CAD9470E42413_2020205840 = (newRs.isCsEmergencyRestricted());
                                    {
                                        setNotification(CS_EMERGENCY_ENABLED);
                                    } //End block
                                    {
                                        boolean varEA89AD4C45E7AF96B724F608A04DFDEA_80241130 = (newRs.isCsNormalRestricted());
                                        {
                                            setNotification(CS_NORMAL_ENABLED);
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End collapsed parenthetic
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            mRestrictedState = newRs;
        } //End block
        log("onRestrictedStateChanged: X rs "+ mRestrictedState);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.121 -0400", hash_original_method = "224D5C409E7F86CE5414891CFB70A981", hash_generated_method = "F3C87F297CB12FEA01E74D8710BD7069")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int regCodeToServiceState(int code) {
        dsTaint.addTaint(code);
        //Begin case default 
        loge("regCodeToServiceState: unexpected service state " + code);
        //End case default 
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //switch (code) {
            //case 0:
            //case 2: 
            //case 3: 
            //case 4: 
            //case 10:
            //case 12:
            //case 13:
            //case 14:
                //return ServiceState.STATE_OUT_OF_SERVICE;
            //case 1:
                //return ServiceState.STATE_IN_SERVICE;
            //case 5:
                //return ServiceState.STATE_IN_SERVICE;
            //default:
                //loge("regCodeToServiceState: unexpected service state " + code);
                //return ServiceState.STATE_OUT_OF_SERVICE;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.121 -0400", hash_original_method = "19036A7D1DADA943DC912DAB6396B9AD", hash_generated_method = "9B3D37513C4FBD9D354402F41CDD50EE")
    @DSModeled(DSC.SAFE)
    private boolean regCodeIsRoaming(int code) {
        dsTaint.addTaint(code);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return 5 == code;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.122 -0400", hash_original_method = "A83CC5F0F34C62E2D3BC7866CECAC756", hash_generated_method = "CE6DC5879BB7CA4B96D48741041697B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isRoamingBetweenOperators(boolean gsmRoaming, ServiceState s) {
        dsTaint.addTaint(s.dsTaint);
        dsTaint.addTaint(gsmRoaming);
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
        String simNumeric;
        simNumeric = SystemProperties.get(
                TelephonyProperties.PROPERTY_ICC_OPERATOR_NUMERIC, "");
        String operatorNumeric;
        operatorNumeric = s.getOperatorNumeric();
        boolean equalsMcc;
        equalsMcc = true;
        try 
        {
            equalsMcc = simNumeric.substring(0, 3).
                    equals(operatorNumeric.substring(0, 3));
        } //End block
        catch (Exception e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //String spn = SystemProperties.get(TelephonyProperties.PROPERTY_ICC_OPERATOR_ALPHA, "empty");
        //String onsl = s.getOperatorAlphaLong();
        //String onss = s.getOperatorAlphaShort();
        //boolean equalsOnsl = onsl != null && spn.equals(onsl);
        //boolean equalsOnss = onss != null && spn.equals(onss);
        //String simNumeric = SystemProperties.get(
                //TelephonyProperties.PROPERTY_ICC_OPERATOR_NUMERIC, "");
        //String  operatorNumeric = s.getOperatorNumeric();
        //boolean equalsMcc = true;
        //try {
            //equalsMcc = simNumeric.substring(0, 3).
                    //equals(operatorNumeric.substring(0, 3));
        //} catch (Exception e){
        //}
        //return gsmRoaming && !(equalsMcc && (equalsOnsl || equalsOnss));
    }

    
        private static int twoDigitsAt(String s, int offset) {
        int a, b;
        a = Character.digit(s.charAt(offset), 10);
        b = Character.digit(s.charAt(offset+1), 10);
        if (a < 0 || b < 0) {
            throw new RuntimeException("invalid format");
        }
        return a*10 + b;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.122 -0400", hash_original_method = "462522C9E25E239E090C32F4DC1CCDBD", hash_generated_method = "09C4F87226AE49F2588D5C33F518360E")
    @DSModeled(DSC.SAFE)
     int getCurrentGprsState() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return gprsState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.122 -0400", hash_original_method = "76A0DFDE7E82168261B9485993735FA8", hash_generated_method = "653ED686E5CCAD8B2501A756EA9BF1D9")
    @DSModeled(DSC.SAFE)
    public int getCurrentDataConnectionState() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return gprsState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.123 -0400", hash_original_method = "35025CCE5222CF7AFA718FFADECE80EF", hash_generated_method = "AE0241AF28E6BE7D2FA4EF6FD3790015")
    @DSModeled(DSC.SAFE)
    public boolean isConcurrentVoiceAndDataAllowed() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mRadioTechnology >= ServiceState.RADIO_TECHNOLOGY_UMTS);
    }

    
        private static String displayNameFor(int off) {
        off = off / 1000 / 60;
        char[] buf = new char[9];
        buf[0] = 'G';
        buf[1] = 'M';
        buf[2] = 'T';
        if (off < 0) {
            buf[3] = '-';
            off = -off;
        } else {
            buf[3] = '+';
        }
        int hours = off / 60;
        int minutes = off % 60;
        buf[4] = (char) ('0' + hours / 10);
        buf[5] = (char) ('0' + hours % 10);
        buf[6] = ':';
        buf[7] = (char) ('0' + minutes / 10);
        buf[8] = (char) ('0' + minutes % 10);
        return new String(buf);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.124 -0400", hash_original_method = "D8515350C34B3E7CC6A83CEBE4C1FE6C", hash_generated_method = "53AA0AE89523BB3D18E6EBAAB526B13F")
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
                        boolean var8053821E6225ABE6D6EDD5F45C9DBCB8_2990662 = (iso != null && iso.length() > 0);
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
                    boolean var624415BE8DA2189070E2F3831D7C1692_19409006 = (getAutoTimeZone());
                    {
                        setAndBroadcastNetworkSetTimeZone(zone.getID());
                    } //End block
                } //End collapsed parenthetic
                saveNitzTimeZone(zone.getID());
            } //End block
            String ignore;
            ignore = SystemProperties.get("gsm.ignore-nitz");
            {
                boolean varE5D77747E14F70AD020ECEBD14623725_470159589 = (ignore != null && ignore.equals("yes"));
                {
                    log("NITZ: Not setting clock because gsm.ignore-nitz is set");
                } //End block
            } //End collapsed parenthetic
            try 
            {
                mWakeLock.acquire();
                {
                    boolean varEEB7CD030807CE702D36FA7DEF7E06F9_154903581 = (getAutoTime());
                    {
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
                            log("NITZ: Setting time of day to " + c.getTime()
                            + " NITZ receive delay(ms): " + millisSinceNitzReceived
                            + " gained(ms): "
                            + (c.getTimeInMillis() - System.currentTimeMillis())
                            + " from " + nitz);
                        } //End block
                        setAndBroadcastNetworkSetTime(c.getTimeInMillis());
                    } //End block
                } //End collapsed parenthetic
                SystemProperties.set("gsm.nitz.time", String.valueOf(c.getTimeInMillis()));
                saveNitzTime(c.getTimeInMillis());
                {
                    long end;
                    end = SystemClock.elapsedRealtime();
                    log("NITZ: end=" + end + " dur=" + (end - start));
                } //End block
            } //End block
            finally 
            {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.124 -0400", hash_original_method = "10C2AC47FB9B2FA38284A276FBC39461", hash_generated_method = "97C2EB173501B1440044943D776EDCA8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean getAutoTime() {
        try 
        {
            boolean var0E961C85A40349516FBBBA448F8C2528_1431989012 = (Settings.System.getInt(phone.getContext().getContentResolver(),
                    Settings.System.AUTO_TIME) > 0);
        } //End block
        catch (SettingNotFoundException snfe)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return Settings.System.getInt(phone.getContext().getContentResolver(),
                    //Settings.System.AUTO_TIME) > 0;
        //} catch (SettingNotFoundException snfe) {
            //return true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.125 -0400", hash_original_method = "46367736BD7DFDD485A94174DBA3ECD3", hash_generated_method = "C7248536209EE1E2BA70014749AC531F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean getAutoTimeZone() {
        try 
        {
            boolean var4E86644AAFB80825EAF556B6919FD175_1515205937 = (Settings.System.getInt(phone.getContext().getContentResolver(),
                    Settings.System.AUTO_TIME_ZONE) > 0);
        } //End block
        catch (SettingNotFoundException snfe)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return Settings.System.getInt(phone.getContext().getContentResolver(),
                    //Settings.System.AUTO_TIME_ZONE) > 0;
        //} catch (SettingNotFoundException snfe) {
            //return true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.125 -0400", hash_original_method = "AC4D6B705E7065D39BD6B0621414F077", hash_generated_method = "260099C4DBC8FC5C5A994C182DB538E4")
    @DSModeled(DSC.SAFE)
    private void saveNitzTimeZone(String zoneId) {
        dsTaint.addTaint(zoneId);
        // ---------- Original Method ----------
        //mSavedTimeZone = zoneId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.125 -0400", hash_original_method = "BBC081DF5E9AA5E0F675E4C4D97D41FA", hash_generated_method = "E65C9E4CB7E29CEF4A7E83B62B19ACF9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void saveNitzTime(long time) {
        dsTaint.addTaint(time);
        mSavedAtTime = SystemClock.elapsedRealtime();
        // ---------- Original Method ----------
        //mSavedTime = time;
        //mSavedAtTime = SystemClock.elapsedRealtime();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.125 -0400", hash_original_method = "28A8B5328B033F98ED5E62B240AD20B6", hash_generated_method = "97B2E61036F4E46F8F4A6C34F9AFD002")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.126 -0400", hash_original_method = "062E38B571EEA7E979075562F8B40A5D", hash_generated_method = "D9FF09D6F184A3F7764EDFC62EC78ED6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.126 -0400", hash_original_method = "2770201C4A137564A500CEEFB3D4E467", hash_generated_method = "DDD7F944CB211B5B3239D6678A6FDC11")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void revertToNitzTime() {
        {
            boolean var2ACAD0BBF60577A314AB894E465C1761_1566922759 = (Settings.System.getInt(phone.getContext().getContentResolver(),
                Settings.System.AUTO_TIME, 0) == 0);
        } //End collapsed parenthetic
        {
            log("Reverting to NITZ Time: mSavedTime=" + mSavedTime
                + " mSavedAtTime=" + mSavedAtTime);
        } //End block
        {
            setAndBroadcastNetworkSetTime(mSavedTime
                    + (SystemClock.elapsedRealtime() - mSavedAtTime));
        } //End block
        // ---------- Original Method ----------
        //if (Settings.System.getInt(phone.getContext().getContentResolver(),
                //Settings.System.AUTO_TIME, 0) == 0) {
            //return;
        //}
        //if (DBG) {
            //log("Reverting to NITZ Time: mSavedTime=" + mSavedTime
                //+ " mSavedAtTime=" + mSavedAtTime);
        //}
        //if (mSavedTime != 0 && mSavedAtTime != 0) {
            //setAndBroadcastNetworkSetTime(mSavedTime
                    //+ (SystemClock.elapsedRealtime() - mSavedAtTime));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.126 -0400", hash_original_method = "846FA792EAB8BB56C921A6228BC9EB73", hash_generated_method = "616B9BBEB1165DDE6ED8905D0E0E28E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void revertToNitzTimeZone() {
        {
            boolean var368E56141E4682CFD54AD9DE0B6F4586_2120212760 = (Settings.System.getInt(phone.getContext().getContentResolver(),
                Settings.System.AUTO_TIME_ZONE, 0) == 0);
        } //End collapsed parenthetic
        log("Reverting to NITZ TimeZone: tz='" + mSavedTimeZone);
        {
            setAndBroadcastNetworkSetTimeZone(mSavedTimeZone);
        } //End block
        // ---------- Original Method ----------
        //if (Settings.System.getInt(phone.getContext().getContentResolver(),
                //Settings.System.AUTO_TIME_ZONE, 0) == 0) {
            //return;
        //}
        //if (DBG) log("Reverting to NITZ TimeZone: tz='" + mSavedTimeZone);
        //if (mSavedTimeZone != null) {
            //setAndBroadcastNetworkSetTimeZone(mSavedTimeZone);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.127 -0400", hash_original_method = "90EFCD7762032B11006E493EA631CF1F", hash_generated_method = "C1D774D25443B075E6BF03894E10E15B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setNotification(int notifyType) {
        dsTaint.addTaint(notifyType);
        log("setNotification: create notification " + notifyType);
        Context context;
        context = phone.getContext();
        mNotification = new Notification();
        mNotification.when = System.currentTimeMillis();
        mNotification.flags = Notification.FLAG_AUTO_CANCEL;
        mNotification.icon = com.android.internal.R.drawable.stat_sys_warning;
        Intent intent;
        intent = new Intent();
        mNotification.contentIntent = PendingIntent
        .getActivity(context, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        CharSequence details;
        details = "";
        CharSequence title;
        title = context.getText(com.android.internal.R.string.RestrictedChangedTitle);
        int notificationId;
        notificationId = CS_NOTIFICATION;
        //Begin case PS_ENABLED 
        notificationId = PS_NOTIFICATION;
        //End case PS_ENABLED 
        //Begin case PS_ENABLED 
        details = context.getText(com.android.internal.R.string.RestrictedOnData);
        //End case PS_ENABLED 
        //Begin case PS_ENABLED 
        ;
        //End case PS_ENABLED 
        //Begin case PS_DISABLED 
        notificationId = PS_NOTIFICATION;
        //End case PS_DISABLED 
        //Begin case CS_ENABLED 
        details = context.getText(com.android.internal.R.string.RestrictedOnAllVoice);
        //End case CS_ENABLED 
        //Begin case CS_ENABLED 
        ;
        //End case CS_ENABLED 
        //Begin case CS_NORMAL_ENABLED 
        details = context.getText(com.android.internal.R.string.RestrictedOnNormal);
        //End case CS_NORMAL_ENABLED 
        //Begin case CS_NORMAL_ENABLED 
        ;
        //End case CS_NORMAL_ENABLED 
        //Begin case CS_EMERGENCY_ENABLED 
        details = context.getText(com.android.internal.R.string.RestrictedOnEmergency);
        //End case CS_EMERGENCY_ENABLED 
        //Begin case CS_EMERGENCY_ENABLED 
        ;
        //End case CS_EMERGENCY_ENABLED 
        log("setNotification: put notification " + title + " / " +details);
        mNotification.tickerText = title;
        mNotification.setLatestEventInfo(context, title, details,
                mNotification.contentIntent);
        NotificationManager notificationManager;
        notificationManager = (NotificationManager)
            context.getSystemService(Context.NOTIFICATION_SERVICE);
        {
            notificationManager.cancel(notificationId);
        } //End block
        {
            notificationManager.notify(notificationId, mNotification);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.127 -0400", hash_original_method = "4109BBDDE3BB927415F4177275F054A2", hash_generated_method = "5F09FF4AFAD3360816B63103CBD975D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void log(String s) {
        dsTaint.addTaint(s);
        Log.d(LOG_TAG, "[GsmSST] " + s);
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[GsmSST] " + s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.128 -0400", hash_original_method = "E8A9D45B999B20E24B18F0E2F50C667F", hash_generated_method = "7B0E1A96A55100862C5AB8F86767F4A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void loge(String s) {
        dsTaint.addTaint(s);
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[GsmSST] " + s);
    }

    
        private static void sloge(String s) {
        Log.e(LOG_TAG, "[GsmSST] " + s);
    }

    
    static final String LOG_TAG = "GSM";
    static final boolean DBG = true;
    private static final String WAKELOCK_TAG = "ServiceStateTracker";
    static final int DEFAULT_GPRS_CHECK_PERIOD_MILLIS = 60 * 1000;
    static final int PS_ENABLED = 1001;
    static final int PS_DISABLED = 1002;
    static final int CS_ENABLED = 1003;
    static final int CS_DISABLED = 1004;
    static final int CS_NORMAL_ENABLED = 1005;
    static final int CS_EMERGENCY_ENABLED = 1006;
    static final int PS_NOTIFICATION = 888;
    static final int CS_NOTIFICATION = 999;
}

