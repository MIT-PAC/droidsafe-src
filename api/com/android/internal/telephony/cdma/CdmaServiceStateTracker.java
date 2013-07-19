package com.android.internal.telephony.cdma;

// Droidsafe Imports
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

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

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class CdmaServiceStateTracker extends ServiceStateTracker {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.173 -0400", hash_original_field = "F7A42FE7211F98AC7A60A285AC3A9E87", hash_generated_field = "F2FC592D71DA2BCBED04F0F797B7B907")

    CDMAPhone phone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.173 -0400", hash_original_field = "B9C5653E1C2BC689F2CC98D72803F0E0", hash_generated_field = "1A281DAC68E94EBC3C9265E4C6804ABC")

    CdmaCellLocation cellLoc;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.173 -0400", hash_original_field = "B325523B8771CAA3A7FB54CA6901D43A", hash_generated_field = "112CC4F0BCF75AC193E83D25A1A12E28")

    CdmaCellLocation newCellLoc;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.173 -0400", hash_original_field = "D4A968BFE5AB5B6B5F72FF2278D320C8", hash_generated_field = "C268A03E211A935F68CB30F65DE990CF")

    int mCurrentOtaspMode = OTASP_UNINITIALIZED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.173 -0400", hash_original_field = "51A382D865188FBA729B2C568FCAA2DA", hash_generated_field = "8FA8A33F6DDC8D75DBA6EFF5836E7BA6")

    private int mNitzUpdateSpacing = SystemProperties.getInt("ro.nitz_update_spacing",
            NITZ_UPDATE_SPACING_DEFAULT);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.173 -0400", hash_original_field = "D3E08DBFA7A72655E305CA89425054B0", hash_generated_field = "A819537E3CEB6132C6CD534B4324860B")

    private int mNitzUpdateDiff = SystemProperties.getInt("ro.nitz_update_diff",
            NITZ_UPDATE_DIFF_DEFAULT);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.173 -0400", hash_original_field = "C5F2560A8D9B22CCD80EC1CE39891FC4", hash_generated_field = "2254D45123DBAABDA74A70C8825DF7C5")

    protected int networkType = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.173 -0400", hash_original_field = "2A9799DDD6C5AEC4622693FE2B8707B6", hash_generated_field = "09A6CDB7CC734BA27C3A1ED81C96ED19")

    protected int newNetworkType = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.173 -0400", hash_original_field = "7C9F8A5B19FBA7C31D25AC01B79BDFBF", hash_generated_field = "608A719DA0321C304B26B483F08AA8A5")

    private boolean mCdmaRoaming = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.173 -0400", hash_original_field = "2205C1E1EAD21E90ACBCE20887A9493C", hash_generated_field = "08036C3C13314229BA2FC25470511F82")

    private int mRoamingIndicator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.173 -0400", hash_original_field = "A62393CD06A4FECD3E6EE53D91EDBDC5", hash_generated_field = "4EA0EC8E3E2882B499B7BDCFF794E5F5")

    private boolean mIsInPrl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.173 -0400", hash_original_field = "02CD5DFBA3BDA0AA0448B97023581AD2", hash_generated_field = "78D9E7B3C682DFCD1DCE797D9FCC238E")

    private int mDefaultRoamingIndicator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.174 -0400", hash_original_field = "18B43B82AC17F4B9E0233B9C9F0B1757", hash_generated_field = "FE2191FF26651B4CE149D535F21B2DAC")

    protected int mDataConnectionState = ServiceState.STATE_OUT_OF_SERVICE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.174 -0400", hash_original_field = "918DDA872539F57E3BE097F104ACC1D9", hash_generated_field = "54950431EC1A81B46E3B586A8FF192E6")

    protected int mNewDataConnectionState = ServiceState.STATE_OUT_OF_SERVICE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.174 -0400", hash_original_field = "B4ADFDC9516ADE43ED9184DDD8D05B3B", hash_generated_field = "6833B331C88851685D637C397C325D06")

    protected int mRegistrationState = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.174 -0400", hash_original_field = "3F07FCA154EC4DA7DD03E851B4862336", hash_generated_field = "DA7A96044F3831CDD3E9F5AB50677517")

    protected RegistrantList cdmaForSubscriptionInfoReadyRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.174 -0400", hash_original_field = "28BAF9CE3F67CB31A5C7E4A1C64709A2", hash_generated_field = "15E4D1DE2B58A497BF813FB4D9666469")

    protected boolean mNeedFixZone = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.174 -0400", hash_original_field = "F22170EE4512552F24101CBB42D416D7", hash_generated_field = "C126894205DFD14FA38D307801001C6F")

    private int mZoneOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.174 -0400", hash_original_field = "C93085FA426E2C8BDD28EDA54293198A", hash_generated_field = "63800483D80F5CB684E683BC24E0A820")

    private boolean mZoneDst;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.174 -0400", hash_original_field = "0A09D50B767A402C68BB8923B251B081", hash_generated_field = "7498B22AB24D6B5E081FF2DDE0FD21C8")

    private long mZoneTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.174 -0400", hash_original_field = "91657A67842D433756013CCE7BEFC8EA", hash_generated_field = "4E375AF9C401CE06580F194AE87749C8")

    protected boolean mGotCountryCode = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.174 -0400", hash_original_field = "629AB99995100B7F6B737671E7028A77", hash_generated_field = "30A17FCDED9983DC17E4B0241936D019")

    String mSavedTimeZone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.174 -0400", hash_original_field = "0870ED367B81A3D199CC36F4FF58F6E3", hash_generated_field = "56DFA99AB6C2048EFF6A2B28FFEF5620")

    long mSavedTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.174 -0400", hash_original_field = "E11E42BBA30EA79639217C987535FA76", hash_generated_field = "2B2B2F1D0E3CAC70A6D7541E3BA2D300")

    long mSavedAtTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.174 -0400", hash_original_field = "09F7D0603642FFAF47D52D1E6E1EC85E", hash_generated_field = "CCE24EE182EA5616F66D6BDEF1A52E90")

    private boolean mNeedToRegForRuimLoaded = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.174 -0400", hash_original_field = "69E45E7E240C011D8CB3CFDE90D76B33", hash_generated_field = "C0FF63B0998195CF037A71BFC5C5B113")

    private PowerManager.WakeLock mWakeLock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.174 -0400", hash_original_field = "BDDBD37CEC4B7238A2DBE3BABF74133D", hash_generated_field = "1DC5D4A83EC6372807837FD2589E7AC2")

    protected String mCurPlmn = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.175 -0400", hash_original_field = "B0D4CDB0FCBA4EE3FCA427C54FA0C7FB", hash_generated_field = "B709DEC8C3A1F430EB7B11AA6EE2EC2C")

    protected String mMdn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.175 -0400", hash_original_field = "25D3BB19289A9BEDD740B76BD79657D2", hash_generated_field = "9E7F4F352D9BD51BA557A4D6106F3396")

    protected int mHomeSystemId[] = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.175 -0400", hash_original_field = "37475CC2CE89E70FEF720FCCDF1F7B46", hash_generated_field = "FFCC16392D86F43DB3487C9739E54F95")

    protected int mHomeNetworkId[] = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.175 -0400", hash_original_field = "5226ADEF3F3B32783B4143237DC7F62E", hash_generated_field = "08259C9A6FC8D318A401FBBE53AFEB88")

    protected String mMin;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.175 -0400", hash_original_field = "A827974BD61A1F359EC3DE16B0B1E1C5", hash_generated_field = "750BD22734A2BF0B542BDCBA0D5DD4FA")

    protected String mPrlVersion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.175 -0400", hash_original_field = "AD07C3F14C8E3CE1725F0751C8501839", hash_generated_field = "F9833AA7D1D680BFE701856BF633E8CF")

    protected boolean mIsMinInfoReady = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.175 -0400", hash_original_field = "15640D9B0B36BDC20633E53EC16423E7", hash_generated_field = "D6E8E3B7AD5D24A742CC13AA70A64F63")

    private boolean isEriTextLoaded = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.175 -0400", hash_original_field = "8A1E3B909DBBB0E5FDD59EF5FFDEC3E5", hash_generated_field = "EBB4A27CD6CDA92F928E719D02425A52")

    protected boolean isSubscriptionFromRuim = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.175 -0400", hash_original_field = "2F689554B1DD1BCD330B1F900CAE6C70", hash_generated_field = "B4AF510D630F6D0ABA0DA5E3978D4F1B")

    private String mRegistrationDeniedReason;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.175 -0400", hash_original_field = "324D8A1D3F81E730D5099A48CEE0C5B6", hash_generated_field = "CC964D293F1703643DB273FCC0901562")

    private ContentResolver cr;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.175 -0400", hash_original_field = "B4A4615841D0A979D099D70EEA1A37DE", hash_generated_field = "7317EA2E3861B648BD5D2085310B5F7A")

    private String currentCarrier = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.329 -0400", hash_original_field = "11E7010812F1C4E8B149974C6F93DD15", hash_generated_field = "3DB856DB274FA4CFDAF726CF9C6DE586")

    private ContentObserver mAutoTimeObserver = new ContentObserver(new Handler()) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.329 -0400", hash_original_method = "6B8D04F75A24E09E038AB230F1FA031E", hash_generated_method = "172CE0A53ECBD305539544F2E56D2E30")
        @Override
        public void onChange(boolean selfChange) {
            
            log("Auto time state changed");
            revertToNitzTime();
            addTaint(selfChange);
            
            
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.330 -0400", hash_original_field = "5FB03C4834787FF054B0ABAC3DB94EDA", hash_generated_field = "46087C315DFAC870959E9567F3E3929A")

    private ContentObserver mAutoTimeZoneObserver = new ContentObserver(new Handler()) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.330 -0400", hash_original_method = "8FD17110C48D1CBE2477FC41B8E67E94", hash_generated_method = "937331EFFBE00AA83A94C8B5D850F5AD")
        @Override
        public void onChange(boolean selfChange) {
            
            log("Auto time zone state changed");
            revertToNitzTimeZone();
            addTaint(selfChange);
            
            
            
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.178 -0400", hash_original_method = "FF3701A2004D17249B7B4B59CF4365CF", hash_generated_method = "AAD107B650219D75DA1C91D4E8348839")
    public  CdmaServiceStateTracker(CDMAPhone phone) {
        super();
        this.phone = phone;
        cr = phone.getContext().getContentResolver();
        cm = phone.mCM;
        ss = new ServiceState();
        newSS = new ServiceState();
        cellLoc = new CdmaCellLocation();
        newCellLoc = new CdmaCellLocation();
        mSignalStrength = new SignalStrength();
        PowerManager powerManager = (PowerManager)phone.getContext().getSystemService(Context.POWER_SERVICE);
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
        int airplaneMode = Settings.System.getInt(cr, Settings.System.AIRPLANE_MODE_ON, 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.179 -0400", hash_original_method = "4D5D490C37798965D77553069E20CD07", hash_generated_method = "2493853BE4052E2639ABC612314A5661")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.179 -0400", hash_original_method = "BA9FDB49D0B6CB52D4E369B5C2B6B17A", hash_generated_method = "CB8D35497CBA6F6E8F83868D065A752E")
    @Override
    protected void finalize() {
        if(DBG)        
        log("CdmaServiceStateTracker finalized");
        // ---------- Original Method ----------
        //if (DBG) log("CdmaServiceStateTracker finalized");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.179 -0400", hash_original_method = "70290EDA16C74DFE014583BB384DB8B5", hash_generated_method = "6A333C90D495DEF77CBBFC0C9411AC0B")
    public void registerForSubscriptionInfoReady(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        Registrant r = new Registrant(h, what, obj);
        cdmaForSubscriptionInfoReadyRegistrants.add(r);
        if(isMinInfoReady())        
        {
            r.notifyRegistrant();
        } //End block
        // ---------- Original Method ----------
        //Registrant r = new Registrant(h, what, obj);
        //cdmaForSubscriptionInfoReadyRegistrants.add(r);
        //if (isMinInfoReady()) {
            //r.notifyRegistrant();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.180 -0400", hash_original_method = "19125607721EAC24124C4D5516B60F75", hash_generated_method = "14EE06E3EBF3BFEF4D51121C72D9B227")
    public void unregisterForSubscriptionInfoReady(Handler h) {
        addTaint(h.getTaint());
        cdmaForSubscriptionInfoReadyRegistrants.remove(h);
        // ---------- Original Method ----------
        //cdmaForSubscriptionInfoReadyRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.183 -0400", hash_original_method = "754E8D2400977D5A28AAECFFE4ABD510", hash_generated_method = "A06C7140B10E61CBF7F586560BEAFF71")
    @Override
    public void handleMessage(Message msg) {
        addTaint(msg.getTaint());
        AsyncResult ar;
        int[] ints;
        String[] strings;
switch(msg.what){
        case EVENT_RADIO_AVAILABLE:
        if(DBG)        
        log("handleMessage: EVENT_RADIO_AVAILABLE");
        break;
        case EVENT_RUIM_READY:
        isSubscriptionFromRuim = true;
        if(mNeedToRegForRuimLoaded)        
        {
            phone.mIccRecords.registerForRecordsLoaded(this,
                        EVENT_RUIM_RECORDS_LOADED, null);
            mNeedToRegForRuimLoaded = false;
        } //End block
        cm.getCDMASubscription(obtainMessage(EVENT_POLL_STATE_CDMA_SUBSCRIPTION));
        if(DBG)        
        log("handleMessage: EVENT_RUIM_READY, Send Request getCDMASubscription.");
        pollState();
        queueNextSignalStrengthPoll();
        break;
        case EVENT_NV_READY:
        isSubscriptionFromRuim = false;
        if(DBG)        
        log("handleMessage: EVENT_NV_READY, Send Request getCDMASubscription.");
        cm.getCDMASubscription( obtainMessage(EVENT_POLL_STATE_CDMA_SUBSCRIPTION));
        pollState();
        queueNextSignalStrengthPoll();
        break;
        case EVENT_RADIO_STATE_CHANGED:
        setPowerStateToDesired();
        pollState();
        break;
        case EVENT_NETWORK_STATE_CHANGED_CDMA:
        pollState();
        break;
        case EVENT_GET_SIGNAL_STRENGTH:
        if(!(cm.getRadioState().isOn()) || (cm.getRadioState().isGsm()))        
        {
            return;
        } //End block
        ar = (AsyncResult) msg.obj;
        onSignalStrengthResult(ar);
        queueNextSignalStrengthPoll();
        break;
        case EVENT_GET_LOC_DONE_CDMA:
        ar = (AsyncResult) msg.obj;
        if(ar.exception == null)        
        {
            String states[] = (String[])ar.result;
            int baseStationId = -1;
            int baseStationLatitude = CdmaCellLocation.INVALID_LAT_LONG;
            int baseStationLongitude = CdmaCellLocation.INVALID_LAT_LONG;
            int systemId = -1;
            int networkId = -1;
            if(states.length > 9)            
            {
                try 
                {
                    if(states[4] != null)                    
                    {
                        baseStationId = Integer.parseInt(states[4]);
                    } //End block
                    if(states[5] != null)                    
                    {
                        baseStationLatitude = Integer.parseInt(states[5]);
                    } //End block
                    if(states[6] != null)                    
                    {
                        baseStationLongitude = Integer.parseInt(states[6]);
                    } //End block
                    if(baseStationLatitude == 0 && baseStationLongitude == 0)                    
                    {
                        baseStationLatitude  = CdmaCellLocation.INVALID_LAT_LONG;
                        baseStationLongitude = CdmaCellLocation.INVALID_LAT_LONG;
                    } //End block
                    if(states[8] != null)                    
                    {
                        systemId = Integer.parseInt(states[8]);
                    } //End block
                    if(states[9] != null)                    
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
        disableSingleLocationUpdate();
        break;
        case EVENT_POLL_STATE_REGISTRATION_CDMA:
        case EVENT_POLL_STATE_OPERATOR_CDMA:
        ar = (AsyncResult) msg.obj;
        handlePollStateResult(msg.what, ar);
        break;
        case EVENT_POLL_STATE_CDMA_SUBSCRIPTION:
        ar = (AsyncResult) msg.obj;
        if(ar.exception == null)        
        {
            String cdmaSubscription[] = (String[])ar.result;
            if(cdmaSubscription != null && cdmaSubscription.length >= 5)            
            {
                mMdn = cdmaSubscription[0];
                parseSidNid(cdmaSubscription[1], cdmaSubscription[2]);
                mMin = cdmaSubscription[3];
                mPrlVersion = cdmaSubscription[4];
                if(DBG)                
                log("GET_CDMA_SUBSCRIPTION: MDN=" + mMdn);
                mIsMinInfoReady = true;
                updateOtaspState();
                phone.getIccCard().broadcastIccStateChangedIntent(IccCard.INTENT_VALUE_ICC_IMSI,
                            null);
            } //End block
            else
            {
                if(DBG)                
                {
                    log("GET_CDMA_SUBSCRIPTION: error parsing cdmaSubscription params num="
                            + cdmaSubscription.length);
                } //End block
            } //End block
        } //End block
        break;
        case EVENT_POLL_SIGNAL_STRENGTH:
        cm.getSignalStrength(obtainMessage(EVENT_GET_SIGNAL_STRENGTH));
        break;
        case EVENT_NITZ_TIME:
        ar = (AsyncResult) msg.obj;
        String nitzString = (String)((Object[])ar.result)[0];
        long nitzReceiveTime = ((Long)((Object[])ar.result)[1]).longValue();
        setTimeFromNITZString(nitzString, nitzReceiveTime);
        break;
        case EVENT_SIGNAL_STRENGTH_UPDATE:
        ar = (AsyncResult) msg.obj;
        dontPollSignalStrength = true;
        onSignalStrengthResult(ar);
        break;
        case EVENT_RUIM_RECORDS_LOADED:
        updateSpnDisplay();
        break;
        case EVENT_LOCATION_UPDATES_ENABLED:
        ar = (AsyncResult) msg.obj;
        if(ar.exception == null)        
        {
            cm.getVoiceRegistrationState(obtainMessage(EVENT_GET_LOC_DONE_CDMA, null));
        } //End block
        break;
        case EVENT_ERI_FILE_LOADED:
        if(DBG)        
        log("[CdmaServiceStateTracker] ERI file has been loaded, repolling.");
        pollState();
        break;
        case EVENT_OTA_PROVISION_STATUS_CHANGE:
        ar = (AsyncResult)msg.obj;
        if(ar.exception == null)        
        {
            ints = (int[]) ar.result;
            int otaStatus = ints[0];
            if(otaStatus == Phone.CDMA_OTA_PROVISION_STATUS_COMMITTED
                    || otaStatus == Phone.CDMA_OTA_PROVISION_STATUS_OTAPA_STOPPED)            
            {
                if(DBG)                
                log("EVENT_OTA_PROVISION_STATUS_CHANGE: Complete, Reload MDN");
                cm.getCDMASubscription( obtainMessage(EVENT_POLL_STATE_CDMA_SUBSCRIPTION));
            } //End block
        } //End block
        break;
        default:
        super.handleMessage(msg);
        break;
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.185 -0400", hash_original_method = "BC2E3346E1E8D048BB892FC104E776BC", hash_generated_method = "A80D37EB81C087D9207678B173E5409D")
    @Override
    protected void setPowerStateToDesired() {
        if(mDesiredPowerState
            && cm.getRadioState() == CommandsInterface.RadioState.RADIO_OFF)        
        {
            cm.setRadioPower(true, null);
        } //End block
        else
        if(!mDesiredPowerState && cm.getRadioState().isOn())        
        {
            DataConnectionTracker dcTracker = phone.mDataConnectionTracker;
            powerOffRadioSafely(dcTracker);
        } //End block
        // ---------- Original Method ----------
        //if (mDesiredPowerState
            //&& cm.getRadioState() == CommandsInterface.RadioState.RADIO_OFF) {
            //cm.setRadioPower(true, null);
        //} else if (!mDesiredPowerState && cm.getRadioState().isOn()) {
            //DataConnectionTracker dcTracker = phone.mDataConnectionTracker;
            //powerOffRadioSafely(dcTracker);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.185 -0400", hash_original_method = "BDCA4E41D3AB74048D93171255E149A7", hash_generated_method = "C88B7F9ADF5C6CA1E70778826FCABB04")
    @Override
    protected void updateSpnDisplay() {
        String plmn = ss.getOperatorAlphaLong();
        if(!TextUtils.equals(plmn, mCurPlmn))        
        {
            boolean showPlmn = plmn != null;
            if(DBG)            
            {
                log(String.format("updateSpnDisplay: changed sending intent" +
                            " showPlmn='%b' plmn='%s'", showPlmn, plmn));
            } //End block
            Intent intent = new Intent(Intents.SPN_STRINGS_UPDATED_ACTION);
            intent.addFlags(Intent.FLAG_RECEIVER_REPLACE_PENDING);
            intent.putExtra(Intents.EXTRA_SHOW_SPN, false);
            intent.putExtra(Intents.EXTRA_SPN, "");
            intent.putExtra(Intents.EXTRA_SHOW_PLMN, showPlmn);
            intent.putExtra(Intents.EXTRA_PLMN, plmn);
            phone.getContext().sendStickyBroadcast(intent);
        } //End block
        mCurPlmn = plmn;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.185 -0400", hash_original_method = "A0DE0F5E4F4D4787509D60C270D17835", hash_generated_method = "4DA420C733E1132C790F792AA54F22DB")
    @Override
    protected Phone getPhone() {
Phone var3DF544D9611CD6A47CD50808F9E2E7D5_595560108 =         phone;
        var3DF544D9611CD6A47CD50808F9E2E7D5_595560108.addTaint(taint);
        return var3DF544D9611CD6A47CD50808F9E2E7D5_595560108;
        // ---------- Original Method ----------
        //return phone;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.186 -0400", hash_original_method = "E924685B280F7636BB1194CB1DB8B328", hash_generated_method = "F22C14614B1CFF5C8AFC818FD3CB961A")
    protected void setCdmaTechnology(int radioTechnology) {
        mNewDataConnectionState = radioTechnologyToDataServiceState(radioTechnology);
        newSS.setRadioTechnology(radioTechnology);
        newNetworkType = radioTechnology;
        // ---------- Original Method ----------
        //mNewDataConnectionState = radioTechnologyToDataServiceState(radioTechnology);
        //newSS.setRadioTechnology(radioTechnology);
        //newNetworkType = radioTechnology;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.188 -0400", hash_original_method = "BE829AA0C3B19F93CC8F98530D925AC3", hash_generated_method = "5FAE7978379D676AE306E88481CE5A31")
    protected void handlePollStateResultMessage(int what, AsyncResult ar) {
        addTaint(ar.getTaint());
        addTaint(what);
        int ints[];
        String states[];
switch(what){
        case EVENT_POLL_STATE_REGISTRATION_CDMA:
        states = (String[])ar.result;
        int registrationState = 4;
        int radioTechnology = -1;
        int baseStationId = -1;
        int baseStationLatitude = CdmaCellLocation.INVALID_LAT_LONG;
        int baseStationLongitude = CdmaCellLocation.INVALID_LAT_LONG;
        int cssIndicator = 0;
        int systemId = 0;
        int networkId = 0;
        int roamingIndicator = -1;
        int systemIsInPrl = 0;
        int defaultRoamingIndicator = 0;
        int reasonForDenial = 0;
        if(states.length >= 14)        
        {
            try 
            {
                if(states[0] != null)                
                {
                    registrationState = Integer.parseInt(states[0]);
                } //End block
                if(states[3] != null)                
                {
                    radioTechnology = Integer.parseInt(states[3]);
                } //End block
                if(states[4] != null)                
                {
                    baseStationId = Integer.parseInt(states[4]);
                } //End block
                if(states[5] != null)                
                {
                    baseStationLatitude = Integer.parseInt(states[5]);
                } //End block
                if(states[6] != null)                
                {
                    baseStationLongitude = Integer.parseInt(states[6]);
                } //End block
                if(baseStationLatitude == 0 && baseStationLongitude == 0)                
                {
                    baseStationLatitude  = CdmaCellLocation.INVALID_LAT_LONG;
                    baseStationLongitude = CdmaCellLocation.INVALID_LAT_LONG;
                } //End block
                if(states[7] != null)                
                {
                    cssIndicator = Integer.parseInt(states[7]);
                } //End block
                if(states[8] != null)                
                {
                    systemId = Integer.parseInt(states[8]);
                } //End block
                if(states[9] != null)                
                {
                    networkId = Integer.parseInt(states[9]);
                } //End block
                if(states[10] != null)                
                {
                    roamingIndicator = Integer.parseInt(states[10]);
                } //End block
                if(states[11] != null)                
                {
                    systemIsInPrl = Integer.parseInt(states[11]);
                } //End block
                if(states[12] != null)                
                {
                    defaultRoamingIndicator = Integer.parseInt(states[12]);
                } //End block
                if(states[13] != null)                
                {
                    reasonForDenial = Integer.parseInt(states[13]);
                } //End block
            } //End block
            catch (NumberFormatException ex)
            {
                loge("EVENT_POLL_STATE_REGISTRATION_CDMA: error parsing: " + ex);
            } //End block
        } //End block
        else
        {
            RuntimeException varB3F6CC4C10760056F989569A5EB89495_1402052000 = new RuntimeException("Warning! Wrong number of parameters returned from "
                                     + "RIL_REQUEST_REGISTRATION_STATE: expected 14 or more "
                                     + "strings and got " + states.length + " strings");
            varB3F6CC4C10760056F989569A5EB89495_1402052000.addTaint(taint);
            throw varB3F6CC4C10760056F989569A5EB89495_1402052000;
        } //End block
        mRegistrationState = registrationState;
        mCdmaRoaming =
                    regCodeIsRoaming(registrationState) && !isRoamIndForHomeSystem(states[10]);
        newSS.setState (regCodeToServiceState(registrationState));
        setCdmaTechnology(radioTechnology);
        newSS.setCssIndicator(cssIndicator);
        newSS.setSystemAndNetworkId(systemId, networkId);
        mRoamingIndicator = roamingIndicator;
        mIsInPrl = (systemIsInPrl == 0) ? false : true;
        mDefaultRoamingIndicator = defaultRoamingIndicator;
        newCellLoc.setCellLocationData(baseStationId, baseStationLatitude,
                    baseStationLongitude, systemId, networkId);
        if(reasonForDenial == 0)        
        {
            mRegistrationDeniedReason = ServiceStateTracker.REGISTRATION_DENIED_GEN;
        } //End block
        else
        if(reasonForDenial == 1)        
        {
            mRegistrationDeniedReason = ServiceStateTracker.REGISTRATION_DENIED_AUTH;
        } //End block
        else
        {
            mRegistrationDeniedReason = "";
        } //End block
        if(mRegistrationState == 3)        
        {
            if(DBG)            
            log("Registration denied, " + mRegistrationDeniedReason);
        } //End block
        break;
        case EVENT_POLL_STATE_OPERATOR_CDMA:
        String opNames[] = (String[])ar.result;
        if(opNames != null && opNames.length >= 3)        
        {
            if((opNames[2] == null) || (opNames[2].length() < 5)
                        || ("00000".equals(opNames[2])))            
            {
                opNames[2] = SystemProperties.get(
                            CDMAPhone.PROPERTY_CDMA_HOME_OPERATOR_NUMERIC, "00000");
                if(DBG)                
                {
                    log("RIL_REQUEST_OPERATOR.response[2], the numeric, " +
                                " is bad. Using SystemProperties '" +
                                        CDMAPhone.PROPERTY_CDMA_HOME_OPERATOR_NUMERIC +
                                "'= " + opNames[2]);
                } //End block
            } //End block
            if(cm.getNvState().isNVReady())            
            {
                newSS.setOperatorName(null, opNames[1], opNames[2]);
            } //End block
            else
            {
                newSS.setOperatorName(opNames[0], opNames[1], opNames[2]);
            } //End block
        } //End block
        else
        {
            if(DBG)            
            log("EVENT_POLL_STATE_OPERATOR_CDMA: error parsing opNames");
        } //End block
        break;
        default:
        loge("handlePollStateResultMessage: RIL response handle in wrong phone!"
                    + " Expected CDMA RIL request and get GSM RIL request.");
        break;
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.189 -0400", hash_original_method = "1B5F4BD94220D105FC0E737C13196363", hash_generated_method = "94C8ACB881E860FEC146A62277EBFD05")
    @Override
    protected void handlePollStateResult(int what, AsyncResult ar) {
        addTaint(ar.getTaint());
        addTaint(what);
        if(ar.userObj != pollingContext)        
        return;
        if(ar.exception != null)        
        {
            CommandException.Error err = null;
            if(ar.exception instanceof CommandException)            
            {
                err = ((CommandException)(ar.exception)).getCommandError();
            } //End block
            if(err == CommandException.Error.RADIO_NOT_AVAILABLE)            
            {
                cancelPollState();
                return;
            } //End block
            if(!cm.getRadioState().isOn())            
            {
                cancelPollState();
                return;
            } //End block
            if(err != CommandException.Error.OP_NOT_ALLOWED_BEFORE_REG_NW)            
            {
                loge("handlePollStateResult: RIL returned an error where it must succeed"
                        + ar.exception);
            } //End block
        } //End block
        else
        try 
        {
            handlePollStateResultMessage(what, ar);
        } //End block
        catch (RuntimeException ex)
        {
            loge("handlePollStateResult: Exception while polling service state. "
                    + "Probably malformed RIL response." + ex);
        } //End block
        pollingContext[0]--;
        if(pollingContext[0] == 0)        
        {
            boolean namMatch = false;
            if(!isSidsAllZeros() && isHomeSid(newSS.getSystemId()))            
            {
                namMatch = true;
            } //End block
            if(isSubscriptionFromRuim)            
            {
                newSS.setRoaming(isRoamingBetweenOperators(mCdmaRoaming, newSS));
            } //End block
            else
            {
                newSS.setRoaming(mCdmaRoaming);
            } //End block
            newSS.setCdmaDefaultRoamingIndicator(mDefaultRoamingIndicator);
            newSS.setCdmaRoamingIndicator(mRoamingIndicator);
            boolean isPrlLoaded = true;
            if(TextUtils.isEmpty(mPrlVersion))            
            {
                isPrlLoaded = false;
            } //End block
            if(!isPrlLoaded)            
            {
                newSS.setCdmaRoamingIndicator(EriInfo.ROAMING_INDICATOR_OFF);
            } //End block
            else
            if(!isSidsAllZeros())            
            {
                if(!namMatch && !mIsInPrl)                
                {
                    newSS.setCdmaRoamingIndicator(mDefaultRoamingIndicator);
                } //End block
                else
                if(namMatch && !mIsInPrl)                
                {
                    newSS.setCdmaRoamingIndicator(EriInfo.ROAMING_INDICATOR_FLASH);
                } //End block
                else
                if(!namMatch && mIsInPrl)                
                {
                    newSS.setCdmaRoamingIndicator(mRoamingIndicator);
                } //End block
                else
                {
                    if((mRoamingIndicator <= 2))                    
                    {
                        newSS.setCdmaRoamingIndicator(EriInfo.ROAMING_INDICATOR_OFF);
                    } //End block
                    else
                    {
                        newSS.setCdmaRoamingIndicator(mRoamingIndicator);
                    } //End block
                } //End block
            } //End block
            int roamingIndicator = newSS.getCdmaRoamingIndicator();
            newSS.setCdmaEriIconIndex(phone.mEriManager.getCdmaEriIconIndex(roamingIndicator,
                    mDefaultRoamingIndicator));
            newSS.setCdmaEriIconMode(phone.mEriManager.getCdmaEriIconMode(roamingIndicator,
                    mDefaultRoamingIndicator));
            if(DBG)            
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.191 -0400", hash_original_method = "6C8071E15167CEBD3E2C13FCDC5BEC69", hash_generated_method = "4F34229AB8DB2417A1A42514981ACCDB")
    protected void setSignalStrengthDefaultValues() {
        mSignalStrength = new SignalStrength(99, -1, -1, -1, -1, -1, -1, false);
        // ---------- Original Method ----------
        //mSignalStrength = new SignalStrength(99, -1, -1, -1, -1, -1, -1, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.192 -0400", hash_original_method = "518F03C8AA7D2E41BBC9B0EF8F2349B8", hash_generated_method = "37A8DDDD8F5249449E33A496A7FEF962")
    protected void pollState() {
        pollingContext = new int[1];
        pollingContext[0] = 0;
switch(cm.getRadioState()){
        case RADIO_UNAVAILABLE:
        newSS.setStateOutOfService();
        newCellLoc.setStateInvalid();
        setSignalStrengthDefaultValues();
        mGotCountryCode = false;
        pollStateDone();
        break;
        case RADIO_OFF:
        newSS.setStateOff();
        newCellLoc.setStateInvalid();
        setSignalStrengthDefaultValues();
        mGotCountryCode = false;
        pollStateDone();
        break;
        case SIM_NOT_READY:
        case SIM_LOCKED_OR_ABSENT:
        case SIM_READY:
        if(DBG)        
        log("Radio Technology Change ongoing, setting SS to off");
        newSS.setStateOff();
        newCellLoc.setStateInvalid();
        setSignalStrengthDefaultValues();
        mGotCountryCode = false;
        break;
        default:
        pollingContext[0]++;
        cm.getOperator(
                    obtainMessage(EVENT_POLL_STATE_OPERATOR_CDMA, pollingContext));
        pollingContext[0]++;
        cm.getVoiceRegistrationState(
                    obtainMessage(EVENT_POLL_STATE_REGISTRATION_CDMA, pollingContext));
        break;
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.193 -0400", hash_original_method = "E69BA838DECF1BB5E62D048E955B2CB0", hash_generated_method = "8C00B00E01FE05D5D8FC26D662199017")
    protected void fixTimeZone(String isoCountryCode) {
        addTaint(isoCountryCode.getTaint());
        TimeZone zone = null;
        String zoneName = SystemProperties.get(TIMEZONE_PROPERTY);
        if((mZoneOffset == 0) && (mZoneDst == false) && (zoneName != null)
                && (zoneName.length() > 0)
                && (Arrays.binarySearch(GMT_COUNTRY_CODES, isoCountryCode) < 0))        
        {
            zone = TimeZone.getDefault();
            long tzOffset;
            tzOffset = zone.getOffset(System.currentTimeMillis());
            if(getAutoTime())            
            {
                setAndBroadcastNetworkSetTime(System.currentTimeMillis() - tzOffset);
            } //End block
            else
            {
                mSavedTime = mSavedTime - tzOffset;
            } //End block
        } //End block
        else
        if(isoCountryCode.equals(""))        
        {
            zone = getNitzTimeZone(mZoneOffset, mZoneDst, mZoneTime);
        } //End block
        else
        {
            zone = TimeUtils.getTimeZone(mZoneOffset, mZoneDst, mZoneTime, isoCountryCode);
        } //End block
        mNeedFixZone = false;
        if(zone != null)        
        {
            if(getAutoTimeZone())            
            {
                setAndBroadcastNetworkSetTimeZone(zone.getID());
            } //End block
            saveNitzTimeZone(zone.getID());
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.195 -0400", hash_original_method = "0FA304F04B86F76391D3D9DA6F1DEA62", hash_generated_method = "D45E0DE265A438DF68B81D30CBF5066C")
    protected void pollStateDone() {
        if(DBG)        
        log("pollStateDone: oldSS=[" + ss + "] newSS=[" + newSS + "]");
        boolean hasRegistered = ss.getState() != ServiceState.STATE_IN_SERVICE
            && newSS.getState() == ServiceState.STATE_IN_SERVICE;
        boolean hasDeregistered = ss.getState() == ServiceState.STATE_IN_SERVICE
            && newSS.getState() != ServiceState.STATE_IN_SERVICE;
        boolean hasCdmaDataConnectionAttached = mDataConnectionState != ServiceState.STATE_IN_SERVICE
            && mNewDataConnectionState == ServiceState.STATE_IN_SERVICE;
        boolean hasCdmaDataConnectionDetached = mDataConnectionState == ServiceState.STATE_IN_SERVICE
            && mNewDataConnectionState != ServiceState.STATE_IN_SERVICE;
        boolean hasCdmaDataConnectionChanged = mDataConnectionState != mNewDataConnectionState;
        boolean hasNetworkTypeChanged = networkType != newNetworkType;
        boolean hasChanged = !newSS.equals(ss);
        boolean hasRoamingOn = !ss.getRoaming() && newSS.getRoaming();
        boolean hasRoamingOff = ss.getRoaming() && !newSS.getRoaming();
        boolean hasLocationChanged = !newCellLoc.equals(cellLoc);
        if(ss.getState() != newSS.getState() ||
                mDataConnectionState != mNewDataConnectionState)        
        {
            EventLog.writeEvent(EventLogTags.CDMA_SERVICE_STATE_CHANGE,
                    ss.getState(), mDataConnectionState,
                    newSS.getState(), mNewDataConnectionState);
        } //End block
        ServiceState tss;
        tss = ss;
        ss = newSS;
        newSS = tss;
        newSS.setStateOutOfService();
        CdmaCellLocation tcl = cellLoc;
        cellLoc = newCellLoc;
        newCellLoc = tcl;
        mDataConnectionState = mNewDataConnectionState;
        networkType = newNetworkType;
        newNetworkType = 0;
        newSS.setStateOutOfService();
        if(hasNetworkTypeChanged)        
        {
            phone.setSystemProperty(TelephonyProperties.PROPERTY_DATA_NETWORK_TYPE,
                    ServiceState.radioTechnologyToString(networkType));
        } //End block
        if(hasRegistered)        
        {
            mNetworkAttachedRegistrants.notifyRegistrants();
        } //End block
        if(hasChanged)        
        {
            if(cm.getRadioState().isNVReady())            
            {
                String eriText;
                if(ss.getState() == ServiceState.STATE_IN_SERVICE)                
                {
                    eriText = phone.getCdmaEriText();
                } //End block
                else
                {
                    eriText = phone.getContext().getText(
                            com.android.internal.R.string.roamingTextSearching).toString();
                } //End block
                ss.setOperatorAlphaLong(eriText);
            } //End block
            String operatorNumeric;
            phone.setSystemProperty(TelephonyProperties.PROPERTY_OPERATOR_ALPHA,
                    ss.getOperatorAlphaLong());
            operatorNumeric = ss.getOperatorNumeric();
            phone.setSystemProperty(TelephonyProperties.PROPERTY_OPERATOR_NUMERIC, operatorNumeric);
            if(operatorNumeric == null)            
            {
                phone.setSystemProperty(TelephonyProperties.PROPERTY_OPERATOR_ISO_COUNTRY, "");
                mGotCountryCode = false;
            } //End block
            else
            {
                String isoCountryCode = "";
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
                if(mNeedFixZone)                
                {
                    fixTimeZone(isoCountryCode);
                } //End block
            } //End block
            phone.setSystemProperty(TelephonyProperties.PROPERTY_OPERATOR_ISROAMING,
                    ss.getRoaming() ? "true" : "false");
            updateSpnDisplay();
            phone.notifyServiceStateChanged(ss);
        } //End block
        if(hasCdmaDataConnectionAttached)        
        {
            mAttachedRegistrants.notifyRegistrants();
        } //End block
        if(hasCdmaDataConnectionDetached)        
        {
            mDetachedRegistrants.notifyRegistrants();
        } //End block
        if(hasCdmaDataConnectionChanged || hasNetworkTypeChanged)        
        {
            phone.notifyDataConnection(null);
        } //End block
        if(hasRoamingOn)        
        {
            mRoamingOnRegistrants.notifyRegistrants();
        } //End block
        if(hasRoamingOff)        
        {
            mRoamingOffRegistrants.notifyRegistrants();
        } //End block
        if(hasLocationChanged)        
        {
            phone.notifyLocationChanged();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.197 -0400", hash_original_method = "99CED85D89C5E9DD8967FF1E935BF80B", hash_generated_method = "98AB80837CC218CD307EBA0B22222FC7")
    private TimeZone getNitzTimeZone(int offset, boolean dst, long when) {
        addTaint(when);
        addTaint(dst);
        addTaint(offset);
        TimeZone guess = findTimeZone(offset, dst, when);
        if(guess == null)        
        {
            guess = findTimeZone(offset, !dst, when);
        } //End block
        if(DBG)        
        log("getNitzTimeZone returning " + (guess == null ? guess : guess.getID()));
TimeZone varA35CE51C1E6ED128CADF188DCC68AF4C_758925968 =         guess;
        varA35CE51C1E6ED128CADF188DCC68AF4C_758925968.addTaint(taint);
        return varA35CE51C1E6ED128CADF188DCC68AF4C_758925968;
        // ---------- Original Method ----------
        //TimeZone guess = findTimeZone(offset, dst, when);
        //if (guess == null) {
            //guess = findTimeZone(offset, !dst, when);
        //}
        //if (DBG) log("getNitzTimeZone returning " + (guess == null ? guess : guess.getID()));
        //return guess;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.197 -0400", hash_original_method = "950DB35A634BB86898B3E74AA5BE6013", hash_generated_method = "16FA2961F6E94DB66C0AFE8B671FD665")
    private TimeZone findTimeZone(int offset, boolean dst, long when) {
        addTaint(when);
        addTaint(dst);
        addTaint(offset);
        int rawOffset = offset;
        if(dst)        
        {
            rawOffset -= 3600000;
        } //End block
        String[] zones = TimeZone.getAvailableIDs(rawOffset);
        TimeZone guess = null;
        Date d = new Date(when);
for(String zone : zones)
        {
            TimeZone tz = TimeZone.getTimeZone(zone);
            if(tz.getOffset(when) == offset &&
                    tz.inDaylightTime(d) == dst)            
            {
                guess = tz;
                break;
            } //End block
        } //End block
TimeZone varA35CE51C1E6ED128CADF188DCC68AF4C_1180824244 =         guess;
        varA35CE51C1E6ED128CADF188DCC68AF4C_1180824244.addTaint(taint);
        return varA35CE51C1E6ED128CADF188DCC68AF4C_1180824244;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.198 -0400", hash_original_method = "75DB599AC418C41475672A1B4451EF2E", hash_generated_method = "54DBF7FDA425F60D18B5FCFA7D3FF438")
    protected void queueNextSignalStrengthPoll() {
        if(dontPollSignalStrength || (cm.getRadioState().isGsm()))        
        {
            return;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.199 -0400", hash_original_method = "76CDF956056DDB53150BD0C17057AE41", hash_generated_method = "C69F65686E896AE0402268A4C7D997E1")
    protected void onSignalStrengthResult(AsyncResult ar) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(ar.getTaint());
        SignalStrength oldSignalStrength = mSignalStrength;
        if(ar.exception != null)        
        {
            setSignalStrengthDefaultValues();
        } //End block
        else
        {
            int[] ints = (int[])ar.result;
            int offset = 2;
            int cdmaDbm = (ints[offset] > 0) ? -ints[offset] : -120;
            int cdmaEcio = (ints[offset+1] > 0) ? -ints[offset+1] : -160;
            int evdoRssi = (ints[offset+2] > 0) ? -ints[offset+2] : -120;
            int evdoEcio = (ints[offset+3] > 0) ? -ints[offset+3] : -1;
            int evdoSnr = ((ints[offset+4] > 0) && (ints[offset+4] <= 8)) ? ints[offset+4] : -1;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.199 -0400", hash_original_method = "DF77DC7CB442AC6CF875159BD0FE26E0", hash_generated_method = "EB6D2ABEAA7DC22A743F2E0FCD2611D2")
    protected int radioTechnologyToDataServiceState(int code) {
        addTaint(code);
        int retVal = ServiceState.STATE_OUT_OF_SERVICE;
switch(code){
        case 0:
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        break;
        case 6:
        case 7:
        case 8:
        case 12:
        case 13:
        retVal = ServiceState.STATE_IN_SERVICE;
        break;
        default:
        loge("radioTechnologyToDataServiceState: Wrong radioTechnology code.");
        break;
}        int var51A27CE8D80905CA37FA5D02C396915F_1226056844 = ((retVal));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_390661500 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_390661500;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.200 -0400", hash_original_method = "DA573DADA483FE1143660303AA3E0D9F", hash_generated_method = "932259EC93D801A50B1CAD35632ECADD")
    protected int regCodeToServiceState(int code) {
        addTaint(code);
switch(code){
        case 0:
        int var71E69F293A199F4F0590F716ED221A1D_237933687 = (ServiceState.STATE_OUT_OF_SERVICE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1876028291 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1876028291;
        case 1:
        int varC8CBA89C9D33ADF2399F2C790EB21113_309074523 = (ServiceState.STATE_IN_SERVICE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1250314355 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1250314355;
        case 2:
        case 3:
        case 4:
        int var71E69F293A199F4F0590F716ED221A1D_703388655 = (ServiceState.STATE_OUT_OF_SERVICE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_156630964 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_156630964;
        case 5:
        int varC8CBA89C9D33ADF2399F2C790EB21113_545827686 = (ServiceState.STATE_IN_SERVICE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2005215521 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2005215521;
        default:
        loge("regCodeToServiceState: unexpected service state " + code);
        int var71E69F293A199F4F0590F716ED221A1D_1751339272 = (ServiceState.STATE_OUT_OF_SERVICE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_745130418 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_745130418;
}
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.200 -0400", hash_original_method = "2F7466C178280C26D6BC47DE1AFB7432", hash_generated_method = "249C2586D346083C086D40323E9A1025")
    public int getCurrentDataConnectionState() {
        int var2D1929376B7B92F1E40241332CED4F31_1613604261 = (mDataConnectionState);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1711358010 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1711358010;
        // ---------- Original Method ----------
        //return mDataConnectionState;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.200 -0400", hash_original_method = "19036A7D1DADA943DC912DAB6396B9AD", hash_generated_method = "BE3DF39A1863EA8C941906313479559E")
    private boolean regCodeIsRoaming(int code) {
        addTaint(code);
        boolean var9BC16EB4B57D49EAF3C5553D2A5A7562_1813374644 = (5 == code);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_835735195 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_835735195;
        // ---------- Original Method ----------
        //return 5 == code;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.200 -0400", hash_original_method = "B4323D2F9A07343D2462A4D59ED08046", hash_generated_method = "B3C659C142208028B7F1E86915123C76")
    private boolean isRoamIndForHomeSystem(String roamInd) {
        addTaint(roamInd.getTaint());
        String homeRoamIndicators = SystemProperties.get("ro.cdma.homesystem");
        if(!TextUtils.isEmpty(homeRoamIndicators))        
        {
for(String homeRoamInd : homeRoamIndicators.split(","))
            {
                if(homeRoamInd.equals(roamInd))                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_818747157 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_49162076 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_49162076;
                } //End block
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_597549672 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1616496361 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1616496361;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1027698828 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2142607380 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2142607380;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.201 -0400", hash_original_method = "011C4920ECDF4CF24EF92E838B11DA6F", hash_generated_method = "5C6C1B8F9DEEF70565DB74577684C76B")
    private boolean isRoamingBetweenOperators(boolean cdmaRoaming, ServiceState s) {
        addTaint(s.getTaint());
        addTaint(cdmaRoaming);
        String spn = SystemProperties.get(TelephonyProperties.PROPERTY_ICC_OPERATOR_ALPHA, "empty");
        String onsl = s.getOperatorAlphaLong();
        String onss = s.getOperatorAlphaShort();
        boolean equalsOnsl = onsl != null && spn.equals(onsl);
        boolean equalsOnss = onss != null && spn.equals(onss);
        boolean var2F188220AF5865F0DFCE43FC974F4ADD_243284935 = (cdmaRoaming && !(equalsOnsl || equalsOnss));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1418103588 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1418103588;
        // ---------- Original Method ----------
        //String spn = SystemProperties.get(TelephonyProperties.PROPERTY_ICC_OPERATOR_ALPHA, "empty");
        //String onsl = s.getOperatorAlphaLong();
        //String onss = s.getOperatorAlphaShort();
        //boolean equalsOnsl = onsl != null && spn.equals(onsl);
        //boolean equalsOnss = onss != null && spn.equals(onss);
        //return cdmaRoaming && !(equalsOnsl || equalsOnss);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.203 -0400", hash_original_method = "7ADA939B474B339ADDF025B993055C9A", hash_generated_method = "74DF54FAC3F466D1D1702476D45BA8CA")
    private void setTimeFromNITZString(String nitz, long nitzReceiveTime) {
        addTaint(nitzReceiveTime);
        addTaint(nitz.getTaint());
        long start = SystemClock.elapsedRealtime();
        if(DBG)        
        {
            log("NITZ: " + nitz + "," + nitzReceiveTime +
                        " start=" + start + " delay=" + (start - nitzReceiveTime));
        } //End block
        try 
        {
            Calendar c = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
            c.clear();
            c.set(Calendar.DST_OFFSET, 0);
            String[] nitzSubs = nitz.split("[/:,+-]");
            int year = 2000 + Integer.parseInt(nitzSubs[0]);
            c.set(Calendar.YEAR, year);
            int month = Integer.parseInt(nitzSubs[1]) - 1;
            c.set(Calendar.MONTH, month);
            int date = Integer.parseInt(nitzSubs[2]);
            c.set(Calendar.DATE, date);
            int hour = Integer.parseInt(nitzSubs[3]);
            c.set(Calendar.HOUR, hour);
            int minute = Integer.parseInt(nitzSubs[4]);
            c.set(Calendar.MINUTE, minute);
            int second = Integer.parseInt(nitzSubs[5]);
            c.set(Calendar.SECOND, second);
            boolean sign = (nitz.indexOf('-') == -1);
            int tzOffset = Integer.parseInt(nitzSubs[6]);
            int dst = (nitzSubs.length >= 8 ) ? Integer.parseInt(nitzSubs[7])
                                              : 0;
            tzOffset = (sign ? 1 : -1) * tzOffset * 15 * 60 * 1000;
            TimeZone zone = null;
            if(nitzSubs.length >= 9)            
            {
                String tzname = nitzSubs[8].replace('!','/');
                zone = TimeZone.getTimeZone( tzname );
            } //End block
            String iso = SystemProperties.get(TelephonyProperties.PROPERTY_OPERATOR_ISO_COUNTRY);
            if(zone == null)            
            {
                if(mGotCountryCode)                
                {
                    if(iso != null && iso.length() > 0)                    
                    {
                        zone = TimeUtils.getTimeZone(tzOffset, dst != 0,
                                c.getTimeInMillis(),
                                iso);
                    } //End block
                    else
                    {
                        zone = getNitzTimeZone(tzOffset, (dst != 0), c.getTimeInMillis());
                    } //End block
                } //End block
            } //End block
            if(zone == null)            
            {
                mNeedFixZone = true;
                mZoneOffset  = tzOffset;
                mZoneDst     = dst != 0;
                mZoneTime    = c.getTimeInMillis();
            } //End block
            if(zone != null)            
            {
                if(getAutoTimeZone())                
                {
                    setAndBroadcastNetworkSetTimeZone(zone.getID());
                } //End block
                saveNitzTimeZone(zone.getID());
            } //End block
            String ignore = SystemProperties.get("gsm.ignore-nitz");
            if(ignore != null && ignore.equals("yes"))            
            {
                if(DBG)                
                log("NITZ: Not setting clock because gsm.ignore-nitz is set");
                return;
            } //End block
            try 
            {
                mWakeLock.acquire();
                long millisSinceNitzReceived = SystemClock.elapsedRealtime() - nitzReceiveTime;
                if(millisSinceNitzReceived < 0)                
                {
                    if(DBG)                    
                    {
                        log("NITZ: not setting time, clock has rolled "
                                        + "backwards since NITZ time was received, "
                                        + nitz);
                    } //End block
                    return;
                } //End block
                if(millisSinceNitzReceived > Integer.MAX_VALUE)                
                {
                    if(DBG)                    
                    {
                        log("NITZ: not setting time, processing has taken "
                                    + (millisSinceNitzReceived / (1000 * 60 * 60 * 24))
                                    + " days");
                    } //End block
                    return;
                } //End block
                c.add(Calendar.MILLISECOND, (int)millisSinceNitzReceived);
                if(getAutoTime())                
                {
                    long gained = c.getTimeInMillis() - System.currentTimeMillis();
                    long timeSinceLastUpdate = SystemClock.elapsedRealtime() - mSavedAtTime;
                    int nitzUpdateSpacing = Settings.Secure.getInt(cr,
                            Settings.Secure.NITZ_UPDATE_SPACING, mNitzUpdateSpacing);
                    int nitzUpdateDiff = Settings.Secure.getInt(cr,
                            Settings.Secure.NITZ_UPDATE_DIFF, mNitzUpdateDiff);
                    if((mSavedAtTime == 0) || (timeSinceLastUpdate > nitzUpdateSpacing)
                            || (Math.abs(gained) > nitzUpdateDiff))                    
                    {
                        if(DBG)                        
                        {
                            log("NITZ: Auto updating time of day to " + c.getTime()
                                + " NITZ receive delay=" + millisSinceNitzReceived
                                + "ms gained=" + gained + "ms from " + nitz);
                        } //End block
                        setAndBroadcastNetworkSetTime(c.getTimeInMillis());
                    } //End block
                    else
                    {
                        if(DBG)                        
                        {
                            log("NITZ: ignore, a previous update was "
                                + timeSinceLastUpdate + "ms ago and gained=" + gained + "ms");
                        } //End block
                        return;
                    } //End block
                } //End block
                if(DBG)                
                log("NITZ: update nitz time property");
                SystemProperties.set("gsm.nitz.time", String.valueOf(c.getTimeInMillis()));
                mSavedTime = c.getTimeInMillis();
                mSavedAtTime = SystemClock.elapsedRealtime();
            } //End block
            finally 
            {
                long end = SystemClock.elapsedRealtime();
                if(DBG)                
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.204 -0400", hash_original_method = "606CF17A4D40300EAFFE0BD67B82E0B6", hash_generated_method = "DDA334F9D777B547E3FF628FD1611DD8")
    private boolean getAutoTime() {
        try 
        {
            boolean varC6B6EEA1884BE737ACED15FBD641243A_91540998 = (Settings.System.getInt(cr, Settings.System.AUTO_TIME) > 0);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1355035165 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1355035165;
        } //End block
        catch (SettingNotFoundException snfe)
        {
            boolean varB326B5062B2F0E69046810717534CB09_186775383 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1889761020 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1889761020;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return Settings.System.getInt(cr, Settings.System.AUTO_TIME) > 0;
        //} catch (SettingNotFoundException snfe) {
            //return true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.204 -0400", hash_original_method = "46A307C7AC0E208B22907DFB9CC04F45", hash_generated_method = "AE255BFCCBDF47B48E5C5E582F9D0FF1")
    private boolean getAutoTimeZone() {
        try 
        {
            boolean var3027FF3E1EB855AEABBF351B73872018_36388390 = (Settings.System.getInt(cr, Settings.System.AUTO_TIME_ZONE) > 0);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_982826995 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_982826995;
        } //End block
        catch (SettingNotFoundException snfe)
        {
            boolean varB326B5062B2F0E69046810717534CB09_1669935645 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_835961099 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_835961099;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return Settings.System.getInt(cr, Settings.System.AUTO_TIME_ZONE) > 0;
        //} catch (SettingNotFoundException snfe) {
            //return true;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.204 -0400", hash_original_method = "AC4D6B705E7065D39BD6B0621414F077", hash_generated_method = "89E6488BB9B703C7CA9BBABF73A30618")
    private void saveNitzTimeZone(String zoneId) {
        mSavedTimeZone = zoneId;
        // ---------- Original Method ----------
        //mSavedTimeZone = zoneId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.204 -0400", hash_original_method = "28A8B5328B033F98ED5E62B240AD20B6", hash_generated_method = "984A6F220FA299B6040E2A27C2DE4419")
    private void setAndBroadcastNetworkSetTimeZone(String zoneId) {
        addTaint(zoneId.getTaint());
        AlarmManager alarm = (AlarmManager) phone.getContext().getSystemService(Context.ALARM_SERVICE);
        alarm.setTimeZone(zoneId);
        Intent intent = new Intent(TelephonyIntents.ACTION_NETWORK_SET_TIMEZONE);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.204 -0400", hash_original_method = "062E38B571EEA7E979075562F8B40A5D", hash_generated_method = "5F6CE596255AD73B6FA27FE77554A384")
    private void setAndBroadcastNetworkSetTime(long time) {
        addTaint(time);
        SystemClock.setCurrentTimeMillis(time);
        Intent intent = new Intent(TelephonyIntents.ACTION_NETWORK_SET_TIME);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.205 -0400", hash_original_method = "FAE09FD02085B2FF4E1D8E37B65790F8", hash_generated_method = "D1378FF323306CB50856EA0A3C1E7250")
    private void revertToNitzTime() {
        if(Settings.System.getInt(cr, Settings.System.AUTO_TIME, 0) == 0)        
        {
            return;
        } //End block
        if(DBG)        
        {
            log("revertToNitzTime: mSavedTime=" + mSavedTime + " mSavedAtTime=" + mSavedAtTime);
        } //End block
        if(mSavedTime != 0 && mSavedAtTime != 0)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.205 -0400", hash_original_method = "72156026C5CBDDA4CCFB821F20D0E263", hash_generated_method = "E2739FE2AE5033B9CB1278F0325F8DD0")
    private void revertToNitzTimeZone() {
        if(Settings.System.getInt(phone.getContext().getContentResolver(),
                Settings.System.AUTO_TIME_ZONE, 0) == 0)        
        {
            return;
        } //End block
        if(DBG)        
        log("revertToNitzTimeZone: tz='" + mSavedTimeZone);
        if(mSavedTimeZone != null)        
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.205 -0400", hash_original_method = "32C0C58A5E03F7E404DD21382316ACEF", hash_generated_method = "AE39BA02E614CB82B892CCA5AD27A172")
    protected boolean isSidsAllZeros() {
        if(mHomeSystemId != null)        
        {
for(int i=0;i < mHomeSystemId.length;i++)
            {
                if(mHomeSystemId[i] != 0)                
                {
                    boolean var68934A3E9455FA72420237EB05902327_1414725264 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1928827037 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1928827037;
                } //End block
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_2059296934 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_575724662 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_575724662;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.205 -0400", hash_original_method = "D3D57AE588662EF8725CB60FCA1C3072", hash_generated_method = "034179EA53FBF452E26492E04D8ECE18")
    private boolean isHomeSid(int sid) {
        addTaint(sid);
        if(mHomeSystemId != null)        
        {
for(int i=0;i < mHomeSystemId.length;i++)
            {
                if(sid == mHomeSystemId[i])                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_1325463351 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_331945820 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_331945820;
                } //End block
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1408362813 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2099840499 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2099840499;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.206 -0400", hash_original_method = "5C4C41F870A905A307BF05376EE79383", hash_generated_method = "82F70F9AF66B0BFF322FCA3BC53F45DB")
    public boolean isConcurrentVoiceAndDataAllowed() {
        boolean var68934A3E9455FA72420237EB05902327_1538842896 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1692932154 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1692932154;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.206 -0400", hash_original_method = "A5028D79B927656E45CDFA536F16F5AB", hash_generated_method = "8480FDAE9778EA83707D3B53AE604EB6")
    public String getMdnNumber() {
String var393C1D26E06E9DFB5EBF371AB98AA875_1513746171 =         mMdn;
        var393C1D26E06E9DFB5EBF371AB98AA875_1513746171.addTaint(taint);
        return var393C1D26E06E9DFB5EBF371AB98AA875_1513746171;
        // ---------- Original Method ----------
        //return mMdn;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.206 -0400", hash_original_method = "133C132C72A1734541959456CF27FF0A", hash_generated_method = "14C1021EDB994BD90414D43B8A2A44E9")
    public String getCdmaMin() {
String varFF498CE7DB7B276D58AE6690DD82E33E_1687423975 =         mMin;
        varFF498CE7DB7B276D58AE6690DD82E33E_1687423975.addTaint(taint);
        return varFF498CE7DB7B276D58AE6690DD82E33E_1687423975;
        // ---------- Original Method ----------
        //return mMin;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.206 -0400", hash_original_method = "B5AD5686CB21B47DB5A2223CCDBB4F42", hash_generated_method = "8B70A0D51B9BD15248479F9422FC0D16")
    public String getPrlVersion() {
String varF0DFA2A5AE60E78166448A9BF5899625_115871508 =         mPrlVersion;
        varF0DFA2A5AE60E78166448A9BF5899625_115871508.addTaint(taint);
        return varF0DFA2A5AE60E78166448A9BF5899625_115871508;
        // ---------- Original Method ----------
        //return mPrlVersion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.206 -0400", hash_original_method = "B26D3610EF4478BB5ED2ADA9EDE43E3B", hash_generated_method = "0BDDEBE8B95BC3B818A425E24B6D1C8A")
     String getImsi() {
        String operatorNumeric = SystemProperties.get(
                TelephonyProperties.PROPERTY_ICC_OPERATOR_NUMERIC, "");
        if(!TextUtils.isEmpty(operatorNumeric) && getCdmaMin() != null)        
        {
String varED1793D6F5E39345D6726DCA1C12D8DA_2065824258 =             (operatorNumeric + getCdmaMin());
            varED1793D6F5E39345D6726DCA1C12D8DA_2065824258.addTaint(taint);
            return varED1793D6F5E39345D6726DCA1C12D8DA_2065824258;
        } //End block
        else
        {
String var540C13E9E156B687226421B24F2DF178_1639077330 =             null;
            var540C13E9E156B687226421B24F2DF178_1639077330.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1639077330;
        } //End block
        // ---------- Original Method ----------
        //String operatorNumeric = SystemProperties.get(
                //TelephonyProperties.PROPERTY_ICC_OPERATOR_NUMERIC, "");
        //if (!TextUtils.isEmpty(operatorNumeric) && getCdmaMin() != null) {
            //return (operatorNumeric + getCdmaMin());
        //} else {
            //return null;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.207 -0400", hash_original_method = "8F0255C2E086694196AF7CFC36B7EF43", hash_generated_method = "360F35E9117F6339BB06712FBEC7AF6D")
    public boolean isMinInfoReady() {
        boolean varBA3526A29BD0203FBBE0C94BC5C3805A_363973396 = (mIsMinInfoReady);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_652301235 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_652301235;
        // ---------- Original Method ----------
        //return mIsMinInfoReady;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.207 -0400", hash_original_method = "0E452BF490F5457F3887197BA13C1AF4", hash_generated_method = "FAE6842EE57E8DFF33828F1553629F07")
     int getOtasp() {
        int provisioningState;
        if(mMin == null || (mMin.length() < 6))        
        {
            if(DBG)            
            log("getOtasp: bad mMin='" + mMin + "'");
            provisioningState = OTASP_UNKNOWN;
        } //End block
        else
        {
            if((mMin.equals(UNACTIVATED_MIN_VALUE)
                    || mMin.substring(0,6).equals(UNACTIVATED_MIN2_VALUE))
                    || SystemProperties.getBoolean("test_cdma_setup", false))            
            {
                provisioningState = OTASP_NEEDED;
            } //End block
            else
            {
                provisioningState = OTASP_NOT_NEEDED;
            } //End block
        } //End block
        if(DBG)        
        log("getOtasp: state=" + provisioningState);
        int var1524079ADBC4DDBCD4D714106EC444AB_1102723858 = (provisioningState);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1400158898 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1400158898;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.207 -0400", hash_original_method = "99845E4FDDAE6236D8C7F396E4374533", hash_generated_method = "8E63CE6D461F9471D4482A19BF636C81")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.208 -0400", hash_original_method = "B2E611749AA45590CADF6B42B9066FE3", hash_generated_method = "A264935CF740DBA9775146C4F872CD3F")
    protected void parseSidNid(String sidStr, String nidStr) {
        addTaint(nidStr.getTaint());
        addTaint(sidStr.getTaint());
        if(sidStr != null)        
        {
            String[] sid = sidStr.split(",");
            mHomeSystemId = new int[sid.length];
for(int i = 0;i < sid.length;i++)
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
        } //End block
        if(DBG)        
        log("CDMA_SUBSCRIPTION: SID=" + sidStr);
        if(nidStr != null)        
        {
            String[] nid = nidStr.split(",");
            mHomeNetworkId = new int[nid.length];
for(int i = 0;i < nid.length;i++)
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
        } //End block
        if(DBG)        
        log("CDMA_SUBSCRIPTION: NID=" + nidStr);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.208 -0400", hash_original_method = "610B4A562CE77C76E210E506F221FC8A", hash_generated_method = "4703870F8554997A0742A9402BEE1286")
    protected void updateOtaspState() {
        int otaspMode = getOtasp();
        int oldOtaspMode = mCurrentOtaspMode;
        mCurrentOtaspMode = otaspMode;
        if(cdmaForSubscriptionInfoReadyRegistrants != null)        
        {
            if(DBG)            
            log("CDMA_SUBSCRIPTION: call notifyRegistrants()");
            cdmaForSubscriptionInfoReadyRegistrants.notifyRegistrants();
        } //End block
        if(oldOtaspMode != mCurrentOtaspMode)        
        {
            if(DBG)            
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.209 -0400", hash_original_method = "F8EA3CF0B7D491A29C0D20E35CC8F967", hash_generated_method = "D17EBC6D48E97211D95DFBFC705268A0")
    @Override
    protected void log(String s) {
        addTaint(s.getTaint());
        Log.d(LOG_TAG, "[CdmaSST] " + s);
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[CdmaSST] " + s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.209 -0400", hash_original_method = "385CD47B6889905FF3482AEA1E26688E", hash_generated_method = "1D118F9E2F2137E0FEA65546C90AEC19")
    @Override
    protected void loge(String s) {
        addTaint(s.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[CdmaSST] " + s);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.209 -0400", hash_original_field = "951C150E6D062E6AED2C45BB9B756185", hash_generated_field = "37C2AB96DD7CCDC96FF809DAC1A6D712")

    static final String LOG_TAG = "CDMA";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.209 -0400", hash_original_field = "2B146BBE35382830495275AE51C5D56A", hash_generated_field = "67F82722D9B3E1632BEE93AB01A1C764")

    private static final String UNACTIVATED_MIN2_VALUE = "000000";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.209 -0400", hash_original_field = "7C397EFDB6962B89448A70E2E1E3F1A3", hash_generated_field = "E8B0DB0F253EC257370D59DB09E2FF20")

    private static final String UNACTIVATED_MIN_VALUE = "1111110111";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.209 -0400", hash_original_field = "7DF72EDD77ED799A10D52A26EC030B80", hash_generated_field = "74B7D3939018D54D4AE0C659740B1204")

    private static final int NITZ_UPDATE_SPACING_DEFAULT = 1000 * 60 * 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.209 -0400", hash_original_field = "381D94A5C9F60BF73CB0E258FB89F604", hash_generated_field = "D671D393E86B81C1C1E262CE0658A52F")

    private static final int NITZ_UPDATE_DIFF_DEFAULT = 2000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.209 -0400", hash_original_field = "8AA5488317F9A54E56045D1AAF74BB75", hash_generated_field = "3E784668308EA1C4770734C39504B13F")

    private static final String WAKELOCK_TAG = "ServiceStateTracker";
}

