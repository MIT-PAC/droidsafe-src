package com.android.internal.telephony.cdma;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.328 -0400", hash_original_field = "F7A42FE7211F98AC7A60A285AC3A9E87", hash_generated_field = "F2FC592D71DA2BCBED04F0F797B7B907")

    CDMAPhone phone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.328 -0400", hash_original_field = "B9C5653E1C2BC689F2CC98D72803F0E0", hash_generated_field = "1A281DAC68E94EBC3C9265E4C6804ABC")

    CdmaCellLocation cellLoc;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.328 -0400", hash_original_field = "B325523B8771CAA3A7FB54CA6901D43A", hash_generated_field = "112CC4F0BCF75AC193E83D25A1A12E28")

    CdmaCellLocation newCellLoc;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.328 -0400", hash_original_field = "D4A968BFE5AB5B6B5F72FF2278D320C8", hash_generated_field = "C268A03E211A935F68CB30F65DE990CF")

    int mCurrentOtaspMode = OTASP_UNINITIALIZED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.328 -0400", hash_original_field = "51A382D865188FBA729B2C568FCAA2DA", hash_generated_field = "8FA8A33F6DDC8D75DBA6EFF5836E7BA6")

    private int mNitzUpdateSpacing = SystemProperties.getInt("ro.nitz_update_spacing",
            NITZ_UPDATE_SPACING_DEFAULT);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.328 -0400", hash_original_field = "D3E08DBFA7A72655E305CA89425054B0", hash_generated_field = "A819537E3CEB6132C6CD534B4324860B")

    private int mNitzUpdateDiff = SystemProperties.getInt("ro.nitz_update_diff",
            NITZ_UPDATE_DIFF_DEFAULT);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.328 -0400", hash_original_field = "C5F2560A8D9B22CCD80EC1CE39891FC4", hash_generated_field = "2254D45123DBAABDA74A70C8825DF7C5")

    protected int networkType = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.328 -0400", hash_original_field = "2A9799DDD6C5AEC4622693FE2B8707B6", hash_generated_field = "09A6CDB7CC734BA27C3A1ED81C96ED19")

    protected int newNetworkType = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.328 -0400", hash_original_field = "7C9F8A5B19FBA7C31D25AC01B79BDFBF", hash_generated_field = "608A719DA0321C304B26B483F08AA8A5")

    private boolean mCdmaRoaming = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.328 -0400", hash_original_field = "2205C1E1EAD21E90ACBCE20887A9493C", hash_generated_field = "08036C3C13314229BA2FC25470511F82")

    private int mRoamingIndicator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.328 -0400", hash_original_field = "A62393CD06A4FECD3E6EE53D91EDBDC5", hash_generated_field = "4EA0EC8E3E2882B499B7BDCFF794E5F5")

    private boolean mIsInPrl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.328 -0400", hash_original_field = "02CD5DFBA3BDA0AA0448B97023581AD2", hash_generated_field = "78D9E7B3C682DFCD1DCE797D9FCC238E")

    private int mDefaultRoamingIndicator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.328 -0400", hash_original_field = "18B43B82AC17F4B9E0233B9C9F0B1757", hash_generated_field = "FE2191FF26651B4CE149D535F21B2DAC")

    protected int mDataConnectionState = ServiceState.STATE_OUT_OF_SERVICE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.328 -0400", hash_original_field = "918DDA872539F57E3BE097F104ACC1D9", hash_generated_field = "54950431EC1A81B46E3B586A8FF192E6")

    protected int mNewDataConnectionState = ServiceState.STATE_OUT_OF_SERVICE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.328 -0400", hash_original_field = "B4ADFDC9516ADE43ED9184DDD8D05B3B", hash_generated_field = "6833B331C88851685D637C397C325D06")

    protected int mRegistrationState = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.328 -0400", hash_original_field = "3F07FCA154EC4DA7DD03E851B4862336", hash_generated_field = "DA7A96044F3831CDD3E9F5AB50677517")

    protected RegistrantList cdmaForSubscriptionInfoReadyRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.328 -0400", hash_original_field = "28BAF9CE3F67CB31A5C7E4A1C64709A2", hash_generated_field = "15E4D1DE2B58A497BF813FB4D9666469")

    protected boolean mNeedFixZone = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.328 -0400", hash_original_field = "F22170EE4512552F24101CBB42D416D7", hash_generated_field = "C126894205DFD14FA38D307801001C6F")

    private int mZoneOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.328 -0400", hash_original_field = "C93085FA426E2C8BDD28EDA54293198A", hash_generated_field = "63800483D80F5CB684E683BC24E0A820")

    private boolean mZoneDst;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.328 -0400", hash_original_field = "0A09D50B767A402C68BB8923B251B081", hash_generated_field = "7498B22AB24D6B5E081FF2DDE0FD21C8")

    private long mZoneTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.328 -0400", hash_original_field = "91657A67842D433756013CCE7BEFC8EA", hash_generated_field = "4E375AF9C401CE06580F194AE87749C8")

    protected boolean mGotCountryCode = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.328 -0400", hash_original_field = "629AB99995100B7F6B737671E7028A77", hash_generated_field = "30A17FCDED9983DC17E4B0241936D019")

    String mSavedTimeZone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.328 -0400", hash_original_field = "0870ED367B81A3D199CC36F4FF58F6E3", hash_generated_field = "56DFA99AB6C2048EFF6A2B28FFEF5620")

    long mSavedTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.328 -0400", hash_original_field = "E11E42BBA30EA79639217C987535FA76", hash_generated_field = "2B2B2F1D0E3CAC70A6D7541E3BA2D300")

    long mSavedAtTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.328 -0400", hash_original_field = "09F7D0603642FFAF47D52D1E6E1EC85E", hash_generated_field = "CCE24EE182EA5616F66D6BDEF1A52E90")

    private boolean mNeedToRegForRuimLoaded = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.328 -0400", hash_original_field = "69E45E7E240C011D8CB3CFDE90D76B33", hash_generated_field = "C0FF63B0998195CF037A71BFC5C5B113")

    private PowerManager.WakeLock mWakeLock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.328 -0400", hash_original_field = "BDDBD37CEC4B7238A2DBE3BABF74133D", hash_generated_field = "1DC5D4A83EC6372807837FD2589E7AC2")

    protected String mCurPlmn = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.328 -0400", hash_original_field = "B0D4CDB0FCBA4EE3FCA427C54FA0C7FB", hash_generated_field = "B709DEC8C3A1F430EB7B11AA6EE2EC2C")

    protected String mMdn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.328 -0400", hash_original_field = "25D3BB19289A9BEDD740B76BD79657D2", hash_generated_field = "9E7F4F352D9BD51BA557A4D6106F3396")

    protected int mHomeSystemId[] = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.328 -0400", hash_original_field = "37475CC2CE89E70FEF720FCCDF1F7B46", hash_generated_field = "FFCC16392D86F43DB3487C9739E54F95")

    protected int mHomeNetworkId[] = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.328 -0400", hash_original_field = "5226ADEF3F3B32783B4143237DC7F62E", hash_generated_field = "08259C9A6FC8D318A401FBBE53AFEB88")

    protected String mMin;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.328 -0400", hash_original_field = "A827974BD61A1F359EC3DE16B0B1E1C5", hash_generated_field = "750BD22734A2BF0B542BDCBA0D5DD4FA")

    protected String mPrlVersion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.328 -0400", hash_original_field = "AD07C3F14C8E3CE1725F0751C8501839", hash_generated_field = "F9833AA7D1D680BFE701856BF633E8CF")

    protected boolean mIsMinInfoReady = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.328 -0400", hash_original_field = "15640D9B0B36BDC20633E53EC16423E7", hash_generated_field = "D6E8E3B7AD5D24A742CC13AA70A64F63")

    private boolean isEriTextLoaded = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.328 -0400", hash_original_field = "8A1E3B909DBBB0E5FDD59EF5FFDEC3E5", hash_generated_field = "EBB4A27CD6CDA92F928E719D02425A52")

    protected boolean isSubscriptionFromRuim = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.329 -0400", hash_original_field = "2F689554B1DD1BCD330B1F900CAE6C70", hash_generated_field = "B4AF510D630F6D0ABA0DA5E3978D4F1B")

    private String mRegistrationDeniedReason;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.329 -0400", hash_original_field = "324D8A1D3F81E730D5099A48CEE0C5B6", hash_generated_field = "CC964D293F1703643DB273FCC0901562")

    private ContentResolver cr;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.329 -0400", hash_original_field = "B4A4615841D0A979D099D70EEA1A37DE", hash_generated_field = "7317EA2E3861B648BD5D2085310B5F7A")

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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.330 -0400", hash_original_method = "FF3701A2004D17249B7B4B59CF4365CF", hash_generated_method = "AAD107B650219D75DA1C91D4E8348839")
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
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.331 -0400", hash_original_method = "4D5D490C37798965D77553069E20CD07", hash_generated_method = "2493853BE4052E2639ABC612314A5661")
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
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.331 -0400", hash_original_method = "BA9FDB49D0B6CB52D4E369B5C2B6B17A", hash_generated_method = "C9E7FAAD0D714F705898C9CAA8F5C6C2")
    @Override
    protected void finalize() {
        log("CdmaServiceStateTracker finalized");
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.331 -0400", hash_original_method = "70290EDA16C74DFE014583BB384DB8B5", hash_generated_method = "7C8540ABFE3E7C046CA55F1E7FE71856")
    public void registerForSubscriptionInfoReady(Handler h, int what, Object obj) {
        
        Registrant r = new Registrant(h, what, obj);
        cdmaForSubscriptionInfoReadyRegistrants.add(r);
        {
            boolean varE32EA0BBDD6B91C9D19F50A2B5A8A1E3_379565108 = (isMinInfoReady());
            {
                r.notifyRegistrant();
            } 
        } 
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.332 -0400", hash_original_method = "19125607721EAC24124C4D5516B60F75", hash_generated_method = "F3352F927858508B726C27C8F8D97BBA")
    public void unregisterForSubscriptionInfoReady(Handler h) {
        cdmaForSubscriptionInfoReadyRegistrants.remove(h);
        addTaint(h.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.334 -0400", hash_original_method = "754E8D2400977D5A28AAECFFE4ABD510", hash_generated_method = "67DD4B7A5D3B1E83AEC07FC88994FDE5")
    @Override
    public void handleMessage(Message msg) {
        AsyncResult ar;
        int[] ints;
        String[] strings;
        
        log("handleMessage: EVENT_RADIO_AVAILABLE");
        
        
        isSubscriptionFromRuim = true;
        
        
        {
            phone.mIccRecords.registerForRecordsLoaded(this,
                        EVENT_RUIM_RECORDS_LOADED, null);
            mNeedToRegForRuimLoaded = false;
        } 
        
        
        cm.getCDMASubscription(obtainMessage(EVENT_POLL_STATE_CDMA_SUBSCRIPTION));
        
        
        log("handleMessage: EVENT_RUIM_READY, Send Request getCDMASubscription.");
        
        
        pollState();
        
        
        queueNextSignalStrengthPoll();
        
        
        isSubscriptionFromRuim = false;
        
        
        log("handleMessage: EVENT_NV_READY, Send Request getCDMASubscription.");
        
        
        cm.getCDMASubscription( obtainMessage(EVENT_POLL_STATE_CDMA_SUBSCRIPTION));
        
        
        pollState();
        
        
        queueNextSignalStrengthPoll();
        
        
        setPowerStateToDesired();
        
        
        pollState();
        
        
        pollState();
        
        
        {
            boolean var526F1BDDC71532C049873C5302565E55_885355343 = (!(cm.getRadioState().isOn()) || (cm.getRadioState().isGsm()));
        } 
        
        
        ar = (AsyncResult) msg.obj;
        
        
        onSignalStrengthResult(ar);
        
        
        queueNextSignalStrengthPoll();
        
        
        ar = (AsyncResult) msg.obj;
        
        
        {
            String states[] = (String[])ar.result;
            int baseStationId = -1;
            int baseStationLatitude = CdmaCellLocation.INVALID_LAT_LONG;
            int baseStationLongitude = CdmaCellLocation.INVALID_LAT_LONG;
            int systemId = -1;
            int networkId = -1;
            {
                try 
                {
                    {
                        baseStationId = Integer.parseInt(states[4]);
                    } 
                    {
                        baseStationLatitude = Integer.parseInt(states[5]);
                    } 
                    {
                        baseStationLongitude = Integer.parseInt(states[6]);
                    } 
                    {
                        baseStationLatitude  = CdmaCellLocation.INVALID_LAT_LONG;
                        baseStationLongitude = CdmaCellLocation.INVALID_LAT_LONG;
                    } 
                    {
                        systemId = Integer.parseInt(states[8]);
                    } 
                    {
                        networkId = Integer.parseInt(states[9]);
                    } 
                } 
                catch (NumberFormatException ex)
                {
                    loge("error parsing cell location data: " + ex);
                } 
            } 
            cellLoc.setCellLocationData(baseStationId, baseStationLatitude,
                        baseStationLongitude, systemId, networkId);
            phone.notifyLocationChanged();
        } 
        
        
        disableSingleLocationUpdate();
        
        
        ar = (AsyncResult) msg.obj;
        
        
        handlePollStateResult(msg.what, ar);
        
        
        ar = (AsyncResult) msg.obj;
        
        
        {
            String cdmaSubscription[] = (String[])ar.result;
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
            } 
            {
                {
                    log("GET_CDMA_SUBSCRIPTION: error parsing cdmaSubscription params num="
                            + cdmaSubscription.length);
                } 
            } 
        } 
        
        
        cm.getSignalStrength(obtainMessage(EVENT_GET_SIGNAL_STRENGTH));
        
        
        ar = (AsyncResult) msg.obj;
        
        
        String nitzString = (String)((Object[])ar.result)[0];
        
        
        long nitzReceiveTime = ((Long)((Object[])ar.result)[1]).longValue();
        
        
        setTimeFromNITZString(nitzString, nitzReceiveTime);
        
        
        ar = (AsyncResult) msg.obj;
        
        
        dontPollSignalStrength = true;
        
        
        onSignalStrengthResult(ar);
        
        
        updateSpnDisplay();
        
        
        ar = (AsyncResult) msg.obj;
        
        
        {
            cm.getVoiceRegistrationState(obtainMessage(EVENT_GET_LOC_DONE_CDMA, null));
        } 
        
        
        log("[CdmaServiceStateTracker] ERI file has been loaded, repolling.");
        
        
        pollState();
        
        
        ar = (AsyncResult)msg.obj;
        
        
        {
            ints = (int[]) ar.result;
            int otaStatus = ints[0];
            {
                log("EVENT_OTA_PROVISION_STATUS_CHANGE: Complete, Reload MDN");
                cm.getCDMASubscription( obtainMessage(EVENT_POLL_STATE_CDMA_SUBSCRIPTION));
            } 
        } 
        
        
        super.handleMessage(msg);
        
        addTaint(msg.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.335 -0400", hash_original_method = "BC2E3346E1E8D048BB892FC104E776BC", hash_generated_method = "8C4B2B119010790F73ABDBA86F8A9748")
    @Override
    protected void setPowerStateToDesired() {
        {
            boolean var132800EA641B7653EC59634384D41AC8_944132218 = (mDesiredPowerState
            && cm.getRadioState() == CommandsInterface.RadioState.RADIO_OFF);
            {
                cm.setRadioPower(true, null);
            } 
            {
                boolean var9EF9CD1D5966856073F2A7E801160763_53952544 = (!mDesiredPowerState && cm.getRadioState().isOn());
                {
                    DataConnectionTracker dcTracker = phone.mDataConnectionTracker;
                    powerOffRadioSafely(dcTracker);
                } 
            } 
        } 
        
        
            
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.335 -0400", hash_original_method = "BDCA4E41D3AB74048D93171255E149A7", hash_generated_method = "9AE83399D19EEE1D735B7BC38DDE559A")
    @Override
    protected void updateSpnDisplay() {
        String plmn = ss.getOperatorAlphaLong();
        {
            boolean varBC9C6DD660615C6E1E2DD0233001B92B_988040128 = (!TextUtils.equals(plmn, mCurPlmn));
            {
                boolean showPlmn = plmn != null;
                {
                    log(String.format("updateSpnDisplay: changed sending intent" +
                            " showPlmn='%b' plmn='%s'", showPlmn, plmn));
                } 
                Intent intent = new Intent(Intents.SPN_STRINGS_UPDATED_ACTION);
                intent.addFlags(Intent.FLAG_RECEIVER_REPLACE_PENDING);
                intent.putExtra(Intents.EXTRA_SHOW_SPN, false);
                intent.putExtra(Intents.EXTRA_SPN, "");
                intent.putExtra(Intents.EXTRA_SHOW_PLMN, showPlmn);
                intent.putExtra(Intents.EXTRA_PLMN, plmn);
                phone.getContext().sendStickyBroadcast(intent);
            } 
        } 
        mCurPlmn = plmn;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.336 -0400", hash_original_method = "A0DE0F5E4F4D4787509D60C270D17835", hash_generated_method = "284CA33FA4D8508586DB084A046F5842")
    @Override
    protected Phone getPhone() {
        Phone varB4EAC82CA7396A68D541C85D26508E83_1402735462 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1402735462 = phone;
        varB4EAC82CA7396A68D541C85D26508E83_1402735462.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1402735462;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.336 -0400", hash_original_method = "E924685B280F7636BB1194CB1DB8B328", hash_generated_method = "F22C14614B1CFF5C8AFC818FD3CB961A")
    protected void setCdmaTechnology(int radioTechnology) {
        mNewDataConnectionState = radioTechnologyToDataServiceState(radioTechnology);
        newSS.setRadioTechnology(radioTechnology);
        newNetworkType = radioTechnology;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.338 -0400", hash_original_method = "BE829AA0C3B19F93CC8F98530D925AC3", hash_generated_method = "D8CB02D6B82F0A060AFD56E29DD80115")
    protected void handlePollStateResultMessage(int what, AsyncResult ar) {
        int ints[];
        String states[];
        
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
        
        
        {
            try 
            {
                {
                    registrationState = Integer.parseInt(states[0]);
                } 
                {
                    radioTechnology = Integer.parseInt(states[3]);
                } 
                {
                    baseStationId = Integer.parseInt(states[4]);
                } 
                {
                    baseStationLatitude = Integer.parseInt(states[5]);
                } 
                {
                    baseStationLongitude = Integer.parseInt(states[6]);
                } 
                {
                    baseStationLatitude  = CdmaCellLocation.INVALID_LAT_LONG;
                    baseStationLongitude = CdmaCellLocation.INVALID_LAT_LONG;
                } 
                {
                    cssIndicator = Integer.parseInt(states[7]);
                } 
                {
                    systemId = Integer.parseInt(states[8]);
                } 
                {
                    networkId = Integer.parseInt(states[9]);
                } 
                {
                    roamingIndicator = Integer.parseInt(states[10]);
                } 
                {
                    systemIsInPrl = Integer.parseInt(states[11]);
                } 
                {
                    defaultRoamingIndicator = Integer.parseInt(states[12]);
                } 
                {
                    reasonForDenial = Integer.parseInt(states[13]);
                } 
            } 
            catch (NumberFormatException ex)
            {
                loge("EVENT_POLL_STATE_REGISTRATION_CDMA: error parsing: " + ex);
            } 
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Warning! Wrong number of parameters returned from "
                                     + "RIL_REQUEST_REGISTRATION_STATE: expected 14 or more "
                                     + "strings and got " + states.length + " strings");
        } 
        
        
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
        
        
        {
            mRegistrationDeniedReason = ServiceStateTracker.REGISTRATION_DENIED_GEN;
        } 
        {
            mRegistrationDeniedReason = ServiceStateTracker.REGISTRATION_DENIED_AUTH;
        } 
        {
            mRegistrationDeniedReason = "";
        } 
        
        
        {
            log("Registration denied, " + mRegistrationDeniedReason);
        } 
        
        
        String opNames[] = (String[])ar.result;
        
        
        {
            {
                boolean var64F902D6C515FBF5301383078A8A1810_230045222 = ((opNames[2] == null) || (opNames[2].length() < 5)
                        || ("00000".equals(opNames[2])));
                {
                    opNames[2] = SystemProperties.get(
                            CDMAPhone.PROPERTY_CDMA_HOME_OPERATOR_NUMERIC, "00000");
                    {
                        log("RIL_REQUEST_OPERATOR.response[2], the numeric, " +
                                " is bad. Using SystemProperties '" +
                                        CDMAPhone.PROPERTY_CDMA_HOME_OPERATOR_NUMERIC +
                                "'= " + opNames[2]);
                    } 
                } 
            } 
            {
                boolean varBC92A3357E9408F0FD52AC7CBCDE6A5F_1705052071 = (cm.getNvState().isNVReady());
                {
                    newSS.setOperatorName(null, opNames[1], opNames[2]);
                } 
                {
                    newSS.setOperatorName(opNames[0], opNames[1], opNames[2]);
                } 
            } 
        } 
        {
            log("EVENT_POLL_STATE_OPERATOR_CDMA: error parsing opNames");
        } 
        
        
        loge("handlePollStateResultMessage: RIL response handle in wrong phone!"
                    + " Expected CDMA RIL request and get GSM RIL request.");
        
        addTaint(what);
        addTaint(ar.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.339 -0400", hash_original_method = "1B5F4BD94220D105FC0E737C13196363", hash_generated_method = "7AC9D526FA63ECD587FE1B3CE9EAF99F")
    @Override
    protected void handlePollStateResult(int what, AsyncResult ar) {
        {
            CommandException.Error err = null;
            {
                err = ((CommandException)(ar.exception)).getCommandError();
            } 
            {
                cancelPollState();
            } 
            {
                boolean var0F541275CA306A5F1AC77D786FD54CFD_1306474582 = (!cm.getRadioState().isOn());
                {
                    cancelPollState();
                } 
            } 
            {
                loge("handlePollStateResult: RIL returned an error where it must succeed"
                        + ar.exception);
            } 
        } 
        try 
        {
            handlePollStateResultMessage(what, ar);
        } 
        catch (RuntimeException ex)
        {
            loge("handlePollStateResult: Exception while polling service state. "
                    + "Probably malformed RIL response." + ex);
        } 
        {
            boolean namMatch = false;
            {
                boolean var29AC97C0502F6AB3FF9782C48F8FA76A_1772925383 = (!isSidsAllZeros() && isHomeSid(newSS.getSystemId()));
                {
                    namMatch = true;
                } 
            } 
            {
                newSS.setRoaming(isRoamingBetweenOperators(mCdmaRoaming, newSS));
            } 
            {
                newSS.setRoaming(mCdmaRoaming);
            } 
            newSS.setCdmaDefaultRoamingIndicator(mDefaultRoamingIndicator);
            newSS.setCdmaRoamingIndicator(mRoamingIndicator);
            boolean isPrlLoaded = true;
            {
                boolean varA035E8FBCA988F8B349976EEFE0F689A_493561064 = (TextUtils.isEmpty(mPrlVersion));
                {
                    isPrlLoaded = false;
                } 
            } 
            {
                newSS.setCdmaRoamingIndicator(EriInfo.ROAMING_INDICATOR_OFF);
            } 
            {
                boolean varF459B34130F5C1301CC31DC3B09702EA_1159673588 = (!isSidsAllZeros());
                {
                    {
                        newSS.setCdmaRoamingIndicator(mDefaultRoamingIndicator);
                    } 
                    {
                        newSS.setCdmaRoamingIndicator(EriInfo.ROAMING_INDICATOR_FLASH);
                    } 
                    {
                        newSS.setCdmaRoamingIndicator(mRoamingIndicator);
                    } 
                    {
                        {
                            newSS.setCdmaRoamingIndicator(EriInfo.ROAMING_INDICATOR_OFF);
                        } 
                        {
                            newSS.setCdmaRoamingIndicator(mRoamingIndicator);
                        } 
                    } 
                } 
            } 
            int roamingIndicator = newSS.getCdmaRoamingIndicator();
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
            } 
            pollStateDone();
        } 
        addTaint(what);
        addTaint(ar.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.339 -0400", hash_original_method = "6C8071E15167CEBD3E2C13FCDC5BEC69", hash_generated_method = "4F34229AB8DB2417A1A42514981ACCDB")
    protected void setSignalStrengthDefaultValues() {
        mSignalStrength = new SignalStrength(99, -1, -1, -1, -1, -1, -1, false);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.340 -0400", hash_original_method = "518F03C8AA7D2E41BBC9B0EF8F2349B8", hash_generated_method = "9F44F55174C7BB046495264C40A5575A")
    protected void pollState() {
        pollingContext = new int[1];
        pollingContext[0] = 0;
        {
            Object varA9E12DC9226BD6A76EE86EBF3C63475C_1904163854 = (cm.getRadioState());
            
            newSS.setStateOutOfService();
            
            
            newCellLoc.setStateInvalid();
            
            
            setSignalStrengthDefaultValues();
            
            
            mGotCountryCode = false;
            
            
            pollStateDone();
            
            
            newSS.setStateOff();
            
            
            newCellLoc.setStateInvalid();
            
            
            setSignalStrengthDefaultValues();
            
            
            mGotCountryCode = false;
            
            
            pollStateDone();
            
            
            log("Radio Technology Change ongoing, setting SS to off");
            
            
            newSS.setStateOff();
            
            
            newCellLoc.setStateInvalid();
            
            
            setSignalStrengthDefaultValues();
            
            
            mGotCountryCode = false;
            
            
            cm.getOperator(
                    obtainMessage(EVENT_POLL_STATE_OPERATOR_CDMA, pollingContext));
            
            
            cm.getVoiceRegistrationState(
                    obtainMessage(EVENT_POLL_STATE_REGISTRATION_CDMA, pollingContext));
            
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.341 -0400", hash_original_method = "E69BA838DECF1BB5E62D048E955B2CB0", hash_generated_method = "788B94D71F2B2EF9C1F4C7030F174A56")
    protected void fixTimeZone(String isoCountryCode) {
        TimeZone zone = null;
        String zoneName = SystemProperties.get(TIMEZONE_PROPERTY);
        {
            boolean varCB8564F90A8584AF96581816886E97BA_1254389561 = ((mZoneOffset == 0) && (mZoneDst == false) && (zoneName != null)
                && (zoneName.length() > 0)
                && (Arrays.binarySearch(GMT_COUNTRY_CODES, isoCountryCode) < 0));
            {
                zone = TimeZone.getDefault();
                long tzOffset;
                tzOffset = zone.getOffset(System.currentTimeMillis());
                {
                    boolean varEEB7CD030807CE702D36FA7DEF7E06F9_335642460 = (getAutoTime());
                    {
                        setAndBroadcastNetworkSetTime(System.currentTimeMillis() - tzOffset);
                    } 
                    {
                        mSavedTime = mSavedTime - tzOffset;
                    } 
                } 
            } 
            {
                boolean var26136DD7D51CA801EC28D07A7D018010_967686305 = (isoCountryCode.equals(""));
                {
                    zone = getNitzTimeZone(mZoneOffset, mZoneDst, mZoneTime);
                } 
                {
                    zone = TimeUtils.getTimeZone(mZoneOffset, mZoneDst, mZoneTime, isoCountryCode);
                } 
            } 
        } 
        mNeedFixZone = false;
        {
            {
                boolean var8B664356E036D01AFB0F5E4CF908C02F_2030902812 = (getAutoTimeZone());
                {
                    setAndBroadcastNetworkSetTimeZone(zone.getID());
                } 
            } 
            saveNitzTimeZone(zone.getID());
        } 
        addTaint(isoCountryCode.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.342 -0400", hash_original_method = "0FA304F04B86F76391D3D9DA6F1DEA62", hash_generated_method = "A47E916C7DBC8E86C3E33A7C1C3E83BB")
    protected void pollStateDone() {
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
        {
            boolean varF88E9DCD3AEEB219F0C2A6585652E72B_1443080907 = (ss.getState() != newSS.getState() ||
                mDataConnectionState != mNewDataConnectionState);
            {
                EventLog.writeEvent(EventLogTags.CDMA_SERVICE_STATE_CHANGE,
                    ss.getState(), mDataConnectionState,
                    newSS.getState(), mNewDataConnectionState);
            } 
        } 
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
        {
            phone.setSystemProperty(TelephonyProperties.PROPERTY_DATA_NETWORK_TYPE,
                    ServiceState.radioTechnologyToString(networkType));
        } 
        {
            mNetworkAttachedRegistrants.notifyRegistrants();
        } 
        {
            {
                boolean var1644C0B76D1EEAE538D65F783B0A10D2_1181315994 = (cm.getRadioState().isNVReady());
                {
                    String eriText;
                    {
                        boolean var0782B3C53497F07CDAB38A690B362545_1424827206 = (ss.getState() == ServiceState.STATE_IN_SERVICE);
                        {
                            eriText = phone.getCdmaEriText();
                        } 
                        {
                            eriText = phone.getContext().getText(
                            com.android.internal.R.string.roamingTextSearching).toString();
                        } 
                    } 
                    ss.setOperatorAlphaLong(eriText);
                } 
            } 
            String operatorNumeric;
            phone.setSystemProperty(TelephonyProperties.PROPERTY_OPERATOR_ALPHA,
                    ss.getOperatorAlphaLong());
            operatorNumeric = ss.getOperatorNumeric();
            phone.setSystemProperty(TelephonyProperties.PROPERTY_OPERATOR_NUMERIC, operatorNumeric);
            {
                phone.setSystemProperty(TelephonyProperties.PROPERTY_OPERATOR_ISO_COUNTRY, "");
                mGotCountryCode = false;
            } 
            {
                String isoCountryCode = "";
                try 
                {
                    isoCountryCode = MccTable.countryCodeForMcc(Integer.parseInt(
                            operatorNumeric.substring(0,3)));
                } 
                catch (NumberFormatException ex)
                {
                    loge("pollStateDone: countryCodeForMcc error" + ex);
                } 
                catch (StringIndexOutOfBoundsException ex)
                {
                    loge("pollStateDone: countryCodeForMcc error" + ex);
                } 
                phone.setSystemProperty(TelephonyProperties.PROPERTY_OPERATOR_ISO_COUNTRY,
                        isoCountryCode);
                mGotCountryCode = true;
                {
                    fixTimeZone(isoCountryCode);
                } 
            } 
            phone.setSystemProperty(TelephonyProperties.PROPERTY_OPERATOR_ISROAMING,
                    ss.getRoaming() ? "true" : "false");
            updateSpnDisplay();
            phone.notifyServiceStateChanged(ss);
        } 
        {
            mAttachedRegistrants.notifyRegistrants();
        } 
        {
            mDetachedRegistrants.notifyRegistrants();
        } 
        {
            phone.notifyDataConnection(null);
        } 
        {
            mRoamingOnRegistrants.notifyRegistrants();
        } 
        {
            mRoamingOffRegistrants.notifyRegistrants();
        } 
        {
            phone.notifyLocationChanged();
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.344 -0400", hash_original_method = "99CED85D89C5E9DD8967FF1E935BF80B", hash_generated_method = "BEEC44FC2CD3F8287BF519AD699CC173")
    private TimeZone getNitzTimeZone(int offset, boolean dst, long when) {
        TimeZone varB4EAC82CA7396A68D541C85D26508E83_1141043549 = null; 
        TimeZone guess = findTimeZone(offset, dst, when);
        {
            guess = findTimeZone(offset, !dst, when);
        } 
        log("getNitzTimeZone returning " + (guess == null ? guess : guess.getID()));
        varB4EAC82CA7396A68D541C85D26508E83_1141043549 = guess;
        addTaint(offset);
        addTaint(dst);
        addTaint(when);
        varB4EAC82CA7396A68D541C85D26508E83_1141043549.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1141043549;
        
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.350 -0400", hash_original_method = "950DB35A634BB86898B3E74AA5BE6013", hash_generated_method = "ECFD3BD7F0F965D68EACBAFECD486575")
    private TimeZone findTimeZone(int offset, boolean dst, long when) {
        TimeZone varB4EAC82CA7396A68D541C85D26508E83_2055525431 = null; 
        int rawOffset = offset;
        {
            rawOffset -= 3600000;
        } 
        String[] zones = TimeZone.getAvailableIDs(rawOffset);
        TimeZone guess = null;
        Date d = new Date(when);
        {
            String zone = zones[0];
            {
                TimeZone tz = TimeZone.getTimeZone(zone);
                {
                    boolean var1060EAEE62A1A81001DA148F1CCC674A_950451847 = (tz.getOffset(when) == offset &&
                    tz.inDaylightTime(d) == dst);
                    {
                        guess = tz;
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2055525431 = guess;
        addTaint(offset);
        addTaint(dst);
        addTaint(when);
        varB4EAC82CA7396A68D541C85D26508E83_2055525431.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2055525431;
        
        
        
            
        
        
        
        
        
            
            
                    
                
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.351 -0400", hash_original_method = "75DB599AC418C41475672A1B4451EF2E", hash_generated_method = "D7D8331F0EE655F73AEDBA537A775557")
    protected void queueNextSignalStrengthPoll() {
        {
            boolean varADAA48EFD9B70BA23908E80A474BFA5A_1969281037 = (dontPollSignalStrength || (cm.getRadioState().isGsm()));
        } 
        Message msg;
        msg = obtainMessage();
        msg.what = EVENT_POLL_SIGNAL_STRENGTH;
        sendMessageDelayed(msg, POLL_PERIOD_MILLIS);
        
        
            
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.352 -0400", hash_original_method = "76CDF956056DDB53150BD0C17057AE41", hash_generated_method = "B542436360A03D63F8ABF7991254BEF9")
    protected void onSignalStrengthResult(AsyncResult ar) {
        
        SignalStrength oldSignalStrength = mSignalStrength;
        {
            setSignalStrengthDefaultValues();
        } 
        {
            int[] ints = (int[])ar.result;
            int offset = 2;
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
        } 
        try 
        {
            phone.notifySignalStrength();
        } 
        catch (NullPointerException ex)
        {
            loge("onSignalStrengthResult() Phone already destroyed: " + ex
                    + "SignalStrength not notified");
        } 
        addTaint(ar.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.352 -0400", hash_original_method = "DF77DC7CB442AC6CF875159BD0FE26E0", hash_generated_method = "74C8FE48135B14E7EB49FDB99FE4C0E2")
    protected int radioTechnologyToDataServiceState(int code) {
        int retVal = ServiceState.STATE_OUT_OF_SERVICE;
        
        retVal = ServiceState.STATE_IN_SERVICE;
        
        
        loge("radioTechnologyToDataServiceState: Wrong radioTechnology code.");
        
        addTaint(code);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1748794846 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1748794846;
        
        
        
        
        
        
        
        
        
            
        
        
        
        
        
            
            
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.353 -0400", hash_original_method = "DA573DADA483FE1143660303AA3E0D9F", hash_generated_method = "4C4973E727395EE35DC905698450A24B")
    protected int regCodeToServiceState(int code) {
        
        loge("regCodeToServiceState: unexpected service state " + code);
        
        addTaint(code);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1399778590 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1399778590;
        
        
        
            
        
            
        
        
        
            
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.353 -0400", hash_original_method = "2F7466C178280C26D6BC47DE1AFB7432", hash_generated_method = "16829C31E96ED70AC051081267DCB24B")
    public int getCurrentDataConnectionState() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_102943184 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_102943184;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.354 -0400", hash_original_method = "19036A7D1DADA943DC912DAB6396B9AD", hash_generated_method = "C551F4BAB2DE101C685C7297F132308D")
    private boolean regCodeIsRoaming(int code) {
        addTaint(code);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1495358123 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1495358123;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.359 -0400", hash_original_method = "B4323D2F9A07343D2462A4D59ED08046", hash_generated_method = "F1DF689269823D4BCDBCF8AB10F5A8D7")
    private boolean isRoamIndForHomeSystem(String roamInd) {
        String homeRoamIndicators = SystemProperties.get("ro.cdma.homesystem");
        {
            boolean var315D147B17EF94F7C5366417A7792112_1336422354 = (!TextUtils.isEmpty(homeRoamIndicators));
            {
                {
                    String homeRoamInd = homeRoamIndicators.split(",")[0];
                    {
                        {
                            boolean varA386460DA3595176FB4BAA16B8D8F859_522181732 = (homeRoamInd.equals(roamInd));
                        } 
                    } 
                } 
            } 
        } 
        addTaint(roamInd.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_104365476 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_104365476;
        
        
        
            
                
                    
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.360 -0400", hash_original_method = "011C4920ECDF4CF24EF92E838B11DA6F", hash_generated_method = "FB397C3A180AE930529870F922427D24")
    private boolean isRoamingBetweenOperators(boolean cdmaRoaming, ServiceState s) {
        String spn = SystemProperties.get(TelephonyProperties.PROPERTY_ICC_OPERATOR_ALPHA, "empty");
        String onsl = s.getOperatorAlphaLong();
        String onss = s.getOperatorAlphaShort();
        boolean equalsOnsl = onsl != null && spn.equals(onsl);
        boolean equalsOnss = onss != null && spn.equals(onss);
        addTaint(cdmaRoaming);
        addTaint(s.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1912761253 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1912761253;
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.362 -0400", hash_original_method = "7ADA939B474B339ADDF025B993055C9A", hash_generated_method = "BCF2BA1380B66DEE0626498D721A6AFB")
    private void setTimeFromNITZString(String nitz, long nitzReceiveTime) {
        long start = SystemClock.elapsedRealtime();
        {
            log("NITZ: " + nitz + "," + nitzReceiveTime +
                        " start=" + start + " delay=" + (start - nitzReceiveTime));
        } 
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
            int dst;
            dst = Integer.parseInt(nitzSubs[7]);
            dst = 0;
            tzOffset = (sign ? 1 : -1) * tzOffset * 15 * 60 * 1000;
            TimeZone zone = null;
            {
                String tzname = nitzSubs[8].replace('!','/');
                zone = TimeZone.getTimeZone( tzname );
            } 
            String iso = SystemProperties.get(TelephonyProperties.PROPERTY_OPERATOR_ISO_COUNTRY);
            {
                {
                    {
                        boolean var8053821E6225ABE6D6EDD5F45C9DBCB8_1531606687 = (iso != null && iso.length() > 0);
                        {
                            zone = TimeUtils.getTimeZone(tzOffset, dst != 0,
                                c.getTimeInMillis(),
                                iso);
                        } 
                        {
                            zone = getNitzTimeZone(tzOffset, (dst != 0), c.getTimeInMillis());
                        } 
                    } 
                } 
            } 
            {
                mNeedFixZone = true;
                mZoneOffset  = tzOffset;
                mZoneDst     = dst != 0;
                mZoneTime    = c.getTimeInMillis();
            } 
            {
                {
                    boolean var624415BE8DA2189070E2F3831D7C1692_268874446 = (getAutoTimeZone());
                    {
                        setAndBroadcastNetworkSetTimeZone(zone.getID());
                    } 
                } 
                saveNitzTimeZone(zone.getID());
            } 
            String ignore = SystemProperties.get("gsm.ignore-nitz");
            {
                boolean varE5D77747E14F70AD020ECEBD14623725_2107114260 = (ignore != null && ignore.equals("yes"));
                {
                    log("NITZ: Not setting clock because gsm.ignore-nitz is set");
                } 
            } 
            try 
            {
                mWakeLock.acquire();
                long millisSinceNitzReceived = SystemClock.elapsedRealtime() - nitzReceiveTime;
                {
                    {
                        log("NITZ: not setting time, clock has rolled "
                                        + "backwards since NITZ time was received, "
                                        + nitz);
                    } 
                } 
                {
                    {
                        log("NITZ: not setting time, processing has taken "
                                    + (millisSinceNitzReceived / (1000 * 60 * 60 * 24))
                                    + " days");
                    } 
                } 
                c.add(Calendar.MILLISECOND, (int)millisSinceNitzReceived);
                {
                    boolean varEEB7CD030807CE702D36FA7DEF7E06F9_428019072 = (getAutoTime());
                    {
                        long gained = c.getTimeInMillis() - System.currentTimeMillis();
                        long timeSinceLastUpdate = SystemClock.elapsedRealtime() - mSavedAtTime;
                        int nitzUpdateSpacing = Settings.Secure.getInt(cr,
                            Settings.Secure.NITZ_UPDATE_SPACING, mNitzUpdateSpacing);
                        int nitzUpdateDiff = Settings.Secure.getInt(cr,
                            Settings.Secure.NITZ_UPDATE_DIFF, mNitzUpdateDiff);
                        {
                            boolean var824386FFC5EE5DF55B4AAF406EE0D224_1011398802 = ((mSavedAtTime == 0) || (timeSinceLastUpdate > nitzUpdateSpacing)
                            || (Math.abs(gained) > nitzUpdateDiff));
                            {
                                {
                                    log("NITZ: Auto updating time of day to " + c.getTime()
                                + " NITZ receive delay=" + millisSinceNitzReceived
                                + "ms gained=" + gained + "ms from " + nitz);
                                } 
                                setAndBroadcastNetworkSetTime(c.getTimeInMillis());
                            } 
                            {
                                {
                                    log("NITZ: ignore, a previous update was "
                                + timeSinceLastUpdate + "ms ago and gained=" + gained + "ms");
                                } 
                            } 
                        } 
                    } 
                } 
                log("NITZ: update nitz time property");
                SystemProperties.set("gsm.nitz.time", String.valueOf(c.getTimeInMillis()));
                mSavedTime = c.getTimeInMillis();
                mSavedAtTime = SystemClock.elapsedRealtime();
            } 
            finally 
            {
                long end = SystemClock.elapsedRealtime();
                log("NITZ: end=" + end + " dur=" + (end - start));
                mWakeLock.release();
            } 
        } 
        catch (RuntimeException ex)
        {
            loge("NITZ: Parsing NITZ time " + nitz + " ex=" + ex);
        } 
        addTaint(nitz.getTaint());
        addTaint(nitzReceiveTime);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.363 -0400", hash_original_method = "606CF17A4D40300EAFFE0BD67B82E0B6", hash_generated_method = "27E6DFD7B6D35EDE9C40C3EC13DD740B")
    private boolean getAutoTime() {
        try 
        {
            boolean var0318692E4935505BFEE97424BA2C2BDC_479170489 = (Settings.System.getInt(cr, Settings.System.AUTO_TIME) > 0);
        } 
        catch (SettingNotFoundException snfe)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1242625990 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1242625990;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.364 -0400", hash_original_method = "46A307C7AC0E208B22907DFB9CC04F45", hash_generated_method = "DE7909C32BC6234F34139A3E5BC07077")
    private boolean getAutoTimeZone() {
        try 
        {
            boolean var6E6BE051602FD448D5A310EEAFCD9E4E_1910555141 = (Settings.System.getInt(cr, Settings.System.AUTO_TIME_ZONE) > 0);
        } 
        catch (SettingNotFoundException snfe)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_129989818 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_129989818;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.365 -0400", hash_original_method = "AC4D6B705E7065D39BD6B0621414F077", hash_generated_method = "89E6488BB9B703C7CA9BBABF73A30618")
    private void saveNitzTimeZone(String zoneId) {
        mSavedTimeZone = zoneId;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.365 -0400", hash_original_method = "28A8B5328B033F98ED5E62B240AD20B6", hash_generated_method = "615D9BCC0526644A6FABF0729825DCD5")
    private void setAndBroadcastNetworkSetTimeZone(String zoneId) {
        AlarmManager alarm = (AlarmManager) phone.getContext().getSystemService(Context.ALARM_SERVICE);
        alarm.setTimeZone(zoneId);
        Intent intent = new Intent(TelephonyIntents.ACTION_NETWORK_SET_TIMEZONE);
        intent.addFlags(Intent.FLAG_RECEIVER_REPLACE_PENDING);
        intent.putExtra("time-zone", zoneId);
        phone.getContext().sendStickyBroadcast(intent);
        addTaint(zoneId.getTaint());
        
        
            
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.367 -0400", hash_original_method = "062E38B571EEA7E979075562F8B40A5D", hash_generated_method = "156D578D330D03E3808034F191771B34")
    private void setAndBroadcastNetworkSetTime(long time) {
        SystemClock.setCurrentTimeMillis(time);
        Intent intent = new Intent(TelephonyIntents.ACTION_NETWORK_SET_TIME);
        intent.addFlags(Intent.FLAG_RECEIVER_REPLACE_PENDING);
        intent.putExtra("time", time);
        phone.getContext().sendStickyBroadcast(intent);
        addTaint(time);
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.370 -0400", hash_original_method = "FAE09FD02085B2FF4E1D8E37B65790F8", hash_generated_method = "C09818EFBDBC92EDEB2BB84420ADBF75")
    private void revertToNitzTime() {
        {
            boolean var295A15F3D6D43E502B81033D23E388EE_1950030629 = (Settings.System.getInt(cr, Settings.System.AUTO_TIME, 0) == 0);
        } 
        {
            log("revertToNitzTime: mSavedTime=" + mSavedTime + " mSavedAtTime=" + mSavedAtTime);
        } 
        {
            setAndBroadcastNetworkSetTime(mSavedTime
                    + (SystemClock.elapsedRealtime() - mSavedAtTime));
        } 
        
        
            
        
        
            
        
        
            
                    
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.370 -0400", hash_original_method = "72156026C5CBDDA4CCFB821F20D0E263", hash_generated_method = "20E7E44C77B0820F3813E949AE8B9029")
    private void revertToNitzTimeZone() {
        {
            boolean var368E56141E4682CFD54AD9DE0B6F4586_566907884 = (Settings.System.getInt(phone.getContext().getContentResolver(),
                Settings.System.AUTO_TIME_ZONE, 0) == 0);
        } 
        log("revertToNitzTimeZone: tz='" + mSavedTimeZone);
        {
            setAndBroadcastNetworkSetTimeZone(mSavedTimeZone);
        } 
        
        
                
            
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.371 -0400", hash_original_method = "32C0C58A5E03F7E404DD21382316ACEF", hash_generated_method = "7CC345D5D7C9224C3BD49A704CA44B81")
    protected boolean isSidsAllZeros() {
        {
            {
                int i = 0;
            } 
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_469701099 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_469701099;
        
        
            
                
                    
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.372 -0400", hash_original_method = "D3D57AE588662EF8725CB60FCA1C3072", hash_generated_method = "443757D458DE1D99A2E08E5D1DCAE0EC")
    private boolean isHomeSid(int sid) {
        {
            {
                int i = 0;
            } 
        } 
        addTaint(sid);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_477700763 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_477700763;
        
        
            
                
                    
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.373 -0400", hash_original_method = "5C4C41F870A905A307BF05376EE79383", hash_generated_method = "466E5A3D41A5F23CA936A834A2D15B31")
    public boolean isConcurrentVoiceAndDataAllowed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_174189654 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_174189654;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.374 -0400", hash_original_method = "A5028D79B927656E45CDFA536F16F5AB", hash_generated_method = "BDB18B661E1A31B27C82DE5ACAD6D454")
    public String getMdnNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_700157978 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_700157978 = mMdn;
        varB4EAC82CA7396A68D541C85D26508E83_700157978.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_700157978;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.374 -0400", hash_original_method = "133C132C72A1734541959456CF27FF0A", hash_generated_method = "90714EF9E05309E269C98E1217B3AFEE")
    public String getCdmaMin() {
        String varB4EAC82CA7396A68D541C85D26508E83_2047227656 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2047227656 = mMin;
        varB4EAC82CA7396A68D541C85D26508E83_2047227656.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2047227656;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.375 -0400", hash_original_method = "B5AD5686CB21B47DB5A2223CCDBB4F42", hash_generated_method = "0DC74FE9352E97A8D2D4E6BF89FA744C")
    public String getPrlVersion() {
        String varB4EAC82CA7396A68D541C85D26508E83_590134224 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_590134224 = mPrlVersion;
        varB4EAC82CA7396A68D541C85D26508E83_590134224.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_590134224;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.376 -0400", hash_original_method = "B26D3610EF4478BB5ED2ADA9EDE43E3B", hash_generated_method = "5116F6A5138493B90A727B0403A28971")
     String getImsi() {
        String varB4EAC82CA7396A68D541C85D26508E83_1099153366 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1942809839 = null; 
        String operatorNumeric = SystemProperties.get(
                TelephonyProperties.PROPERTY_ICC_OPERATOR_NUMERIC, "");
        {
            boolean varF68187D93855D84C5AED475661AA07AC_590653925 = (!TextUtils.isEmpty(operatorNumeric) && getCdmaMin() != null);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1099153366 = (operatorNumeric + getCdmaMin());
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1942809839 = null;
            } 
        } 
        String varA7E53CE21691AB073D9660D615818899_54113394; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_54113394 = varB4EAC82CA7396A68D541C85D26508E83_1099153366;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_54113394 = varB4EAC82CA7396A68D541C85D26508E83_1942809839;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_54113394.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_54113394;
        
        
                
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.376 -0400", hash_original_method = "8F0255C2E086694196AF7CFC36B7EF43", hash_generated_method = "D0200A390CE0043F7EB0F8D2E8FB9089")
    public boolean isMinInfoReady() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_522257301 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_522257301;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.377 -0400", hash_original_method = "0E452BF490F5457F3887197BA13C1AF4", hash_generated_method = "949CDD6BB74971E3C98E9D86D9006F7E")
     int getOtasp() {
        int provisioningState;
        {
            boolean varBE6EA1BEB15C6575B4E6862F8C2A1A4E_1183689640 = (mMin == null || (mMin.length() < 6));
            {
                log("getOtasp: bad mMin='" + mMin + "'");
                provisioningState = OTASP_UNKNOWN;
            } 
            {
                {
                    boolean varC1F4BAB057A6E1164C1F9ABE5370C980_343040471 = ((mMin.equals(UNACTIVATED_MIN_VALUE)
                    || mMin.substring(0,6).equals(UNACTIVATED_MIN2_VALUE))
                    || SystemProperties.getBoolean("test_cdma_setup", false));
                    {
                        provisioningState = OTASP_NEEDED;
                    } 
                    {
                        provisioningState = OTASP_NOT_NEEDED;
                    } 
                } 
            } 
        } 
        log("getOtasp: state=" + provisioningState);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1979076597 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1979076597;
        
        
        
            
            
        
            
                    
                    
                
            
                
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.378 -0400", hash_original_method = "99845E4FDDAE6236D8C7F396E4374533", hash_generated_method = "8E63CE6D461F9471D4482A19BF636C81")
    @Override
    protected void hangupAndPowerOff() {
        phone.mCT.ringingCall.hangupIfAlive();
        phone.mCT.backgroundCall.hangupIfAlive();
        phone.mCT.foregroundCall.hangupIfAlive();
        cm.setRadioPower(false, null);
        
        
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.379 -0400", hash_original_method = "B2E611749AA45590CADF6B42B9066FE3", hash_generated_method = "E563D6D68115CAC5F4BC3513EA5A2101")
    protected void parseSidNid(String sidStr, String nidStr) {
        {
            String[] sid = sidStr.split(",");
            mHomeSystemId = new int[sid.length];
            {
                int i = 0;
                {
                    try 
                    {
                        mHomeSystemId[i] = Integer.parseInt(sid[i]);
                    } 
                    catch (NumberFormatException ex)
                    {
                        loge("error parsing system id: " + ex);
                    } 
                } 
            } 
        } 
        log("CDMA_SUBSCRIPTION: SID=" + sidStr);
        {
            String[] nid = nidStr.split(",");
            mHomeNetworkId = new int[nid.length];
            {
                int i = 0;
                {
                    try 
                    {
                        mHomeNetworkId[i] = Integer.parseInt(nid[i]);
                    } 
                    catch (NumberFormatException ex)
                    {
                        loge("CDMA_SUBSCRIPTION: error parsing network id: " + ex);
                    } 
                } 
            } 
        } 
        log("CDMA_SUBSCRIPTION: NID=" + nidStr);
        addTaint(sidStr.getTaint());
        addTaint(nidStr.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.379 -0400", hash_original_method = "610B4A562CE77C76E210E506F221FC8A", hash_generated_method = "CE43EB21460EA63C3DFA1428FAF555C2")
    protected void updateOtaspState() {
        int otaspMode = getOtasp();
        int oldOtaspMode = mCurrentOtaspMode;
        mCurrentOtaspMode = otaspMode;
        {
            log("CDMA_SUBSCRIPTION: call notifyRegistrants()");
            cdmaForSubscriptionInfoReadyRegistrants.notifyRegistrants();
        } 
        {
            {
                log("CDMA_SUBSCRIPTION: call notifyOtaspChanged old otaspMode=" +
                    oldOtaspMode + " new otaspMode=" + mCurrentOtaspMode);
            } 
            phone.notifyOtaspChanged(mCurrentOtaspMode);
        } 
        
        
        
        
        
            
            
        
        
            
                
                    
            
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.380 -0400", hash_original_method = "F8EA3CF0B7D491A29C0D20E35CC8F967", hash_generated_method = "33CC4D22E3E33A24B75B8A1903D1B3D7")
    @Override
    protected void log(String s) {
        Log.d(LOG_TAG, "[CdmaSST] " + s);
        addTaint(s.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.380 -0400", hash_original_method = "385CD47B6889905FF3482AEA1E26688E", hash_generated_method = "1D118F9E2F2137E0FEA65546C90AEC19")
    @Override
    protected void loge(String s) {
        addTaint(s.getTaint());
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.380 -0400", hash_original_field = "951C150E6D062E6AED2C45BB9B756185", hash_generated_field = "37C2AB96DD7CCDC96FF809DAC1A6D712")

    static final String LOG_TAG = "CDMA";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.380 -0400", hash_original_field = "2B146BBE35382830495275AE51C5D56A", hash_generated_field = "67F82722D9B3E1632BEE93AB01A1C764")

    private static final String UNACTIVATED_MIN2_VALUE = "000000";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.380 -0400", hash_original_field = "7C397EFDB6962B89448A70E2E1E3F1A3", hash_generated_field = "E8B0DB0F253EC257370D59DB09E2FF20")

    private static final String UNACTIVATED_MIN_VALUE = "1111110111";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.380 -0400", hash_original_field = "7DF72EDD77ED799A10D52A26EC030B80", hash_generated_field = "74B7D3939018D54D4AE0C659740B1204")

    private static final int NITZ_UPDATE_SPACING_DEFAULT = 1000 * 60 * 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.380 -0400", hash_original_field = "381D94A5C9F60BF73CB0E258FB89F604", hash_generated_field = "D671D393E86B81C1C1E262CE0658A52F")

    private static final int NITZ_UPDATE_DIFF_DEFAULT = 2000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.380 -0400", hash_original_field = "8AA5488317F9A54E56045D1AAF74BB75", hash_generated_field = "3E784668308EA1C4770734C39504B13F")

    private static final String WAKELOCK_TAG = "ServiceStateTracker";
}

