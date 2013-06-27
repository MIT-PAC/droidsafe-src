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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.120 -0400", hash_original_field = "F7A42FE7211F98AC7A60A285AC3A9E87", hash_generated_field = "F2FC592D71DA2BCBED04F0F797B7B907")

    CDMAPhone phone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.120 -0400", hash_original_field = "B9C5653E1C2BC689F2CC98D72803F0E0", hash_generated_field = "1A281DAC68E94EBC3C9265E4C6804ABC")

    CdmaCellLocation cellLoc;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.120 -0400", hash_original_field = "B325523B8771CAA3A7FB54CA6901D43A", hash_generated_field = "112CC4F0BCF75AC193E83D25A1A12E28")

    CdmaCellLocation newCellLoc;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.120 -0400", hash_original_field = "D4A968BFE5AB5B6B5F72FF2278D320C8", hash_generated_field = "C268A03E211A935F68CB30F65DE990CF")

    int mCurrentOtaspMode = OTASP_UNINITIALIZED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.120 -0400", hash_original_field = "51A382D865188FBA729B2C568FCAA2DA", hash_generated_field = "8FA8A33F6DDC8D75DBA6EFF5836E7BA6")

    private int mNitzUpdateSpacing = SystemProperties.getInt("ro.nitz_update_spacing",
            NITZ_UPDATE_SPACING_DEFAULT);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.120 -0400", hash_original_field = "D3E08DBFA7A72655E305CA89425054B0", hash_generated_field = "A819537E3CEB6132C6CD534B4324860B")

    private int mNitzUpdateDiff = SystemProperties.getInt("ro.nitz_update_diff",
            NITZ_UPDATE_DIFF_DEFAULT);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.120 -0400", hash_original_field = "C5F2560A8D9B22CCD80EC1CE39891FC4", hash_generated_field = "2254D45123DBAABDA74A70C8825DF7C5")

    protected int networkType = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.120 -0400", hash_original_field = "2A9799DDD6C5AEC4622693FE2B8707B6", hash_generated_field = "09A6CDB7CC734BA27C3A1ED81C96ED19")

    protected int newNetworkType = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.120 -0400", hash_original_field = "7C9F8A5B19FBA7C31D25AC01B79BDFBF", hash_generated_field = "608A719DA0321C304B26B483F08AA8A5")

    private boolean mCdmaRoaming = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.120 -0400", hash_original_field = "2205C1E1EAD21E90ACBCE20887A9493C", hash_generated_field = "08036C3C13314229BA2FC25470511F82")

    private int mRoamingIndicator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.120 -0400", hash_original_field = "A62393CD06A4FECD3E6EE53D91EDBDC5", hash_generated_field = "4EA0EC8E3E2882B499B7BDCFF794E5F5")

    private boolean mIsInPrl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.120 -0400", hash_original_field = "02CD5DFBA3BDA0AA0448B97023581AD2", hash_generated_field = "78D9E7B3C682DFCD1DCE797D9FCC238E")

    private int mDefaultRoamingIndicator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.120 -0400", hash_original_field = "18B43B82AC17F4B9E0233B9C9F0B1757", hash_generated_field = "FE2191FF26651B4CE149D535F21B2DAC")

    protected int mDataConnectionState = ServiceState.STATE_OUT_OF_SERVICE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.120 -0400", hash_original_field = "918DDA872539F57E3BE097F104ACC1D9", hash_generated_field = "54950431EC1A81B46E3B586A8FF192E6")

    protected int mNewDataConnectionState = ServiceState.STATE_OUT_OF_SERVICE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.120 -0400", hash_original_field = "B4ADFDC9516ADE43ED9184DDD8D05B3B", hash_generated_field = "6833B331C88851685D637C397C325D06")

    protected int mRegistrationState = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.121 -0400", hash_original_field = "3F07FCA154EC4DA7DD03E851B4862336", hash_generated_field = "DA7A96044F3831CDD3E9F5AB50677517")

    protected RegistrantList cdmaForSubscriptionInfoReadyRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.121 -0400", hash_original_field = "28BAF9CE3F67CB31A5C7E4A1C64709A2", hash_generated_field = "15E4D1DE2B58A497BF813FB4D9666469")

    protected boolean mNeedFixZone = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.121 -0400", hash_original_field = "F22170EE4512552F24101CBB42D416D7", hash_generated_field = "C126894205DFD14FA38D307801001C6F")

    private int mZoneOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.121 -0400", hash_original_field = "C93085FA426E2C8BDD28EDA54293198A", hash_generated_field = "63800483D80F5CB684E683BC24E0A820")

    private boolean mZoneDst;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.121 -0400", hash_original_field = "0A09D50B767A402C68BB8923B251B081", hash_generated_field = "7498B22AB24D6B5E081FF2DDE0FD21C8")

    private long mZoneTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.121 -0400", hash_original_field = "91657A67842D433756013CCE7BEFC8EA", hash_generated_field = "4E375AF9C401CE06580F194AE87749C8")

    protected boolean mGotCountryCode = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.121 -0400", hash_original_field = "629AB99995100B7F6B737671E7028A77", hash_generated_field = "30A17FCDED9983DC17E4B0241936D019")

    String mSavedTimeZone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.121 -0400", hash_original_field = "0870ED367B81A3D199CC36F4FF58F6E3", hash_generated_field = "56DFA99AB6C2048EFF6A2B28FFEF5620")

    long mSavedTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.121 -0400", hash_original_field = "E11E42BBA30EA79639217C987535FA76", hash_generated_field = "2B2B2F1D0E3CAC70A6D7541E3BA2D300")

    long mSavedAtTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.121 -0400", hash_original_field = "09F7D0603642FFAF47D52D1E6E1EC85E", hash_generated_field = "CCE24EE182EA5616F66D6BDEF1A52E90")

    private boolean mNeedToRegForRuimLoaded = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.121 -0400", hash_original_field = "69E45E7E240C011D8CB3CFDE90D76B33", hash_generated_field = "C0FF63B0998195CF037A71BFC5C5B113")

    private PowerManager.WakeLock mWakeLock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.121 -0400", hash_original_field = "BDDBD37CEC4B7238A2DBE3BABF74133D", hash_generated_field = "1DC5D4A83EC6372807837FD2589E7AC2")

    protected String mCurPlmn = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.121 -0400", hash_original_field = "B0D4CDB0FCBA4EE3FCA427C54FA0C7FB", hash_generated_field = "B709DEC8C3A1F430EB7B11AA6EE2EC2C")

    protected String mMdn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.121 -0400", hash_original_field = "25D3BB19289A9BEDD740B76BD79657D2", hash_generated_field = "9E7F4F352D9BD51BA557A4D6106F3396")

    protected int mHomeSystemId[] = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.121 -0400", hash_original_field = "37475CC2CE89E70FEF720FCCDF1F7B46", hash_generated_field = "FFCC16392D86F43DB3487C9739E54F95")

    protected int mHomeNetworkId[] = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.121 -0400", hash_original_field = "5226ADEF3F3B32783B4143237DC7F62E", hash_generated_field = "08259C9A6FC8D318A401FBBE53AFEB88")

    protected String mMin;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.121 -0400", hash_original_field = "A827974BD61A1F359EC3DE16B0B1E1C5", hash_generated_field = "750BD22734A2BF0B542BDCBA0D5DD4FA")

    protected String mPrlVersion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.121 -0400", hash_original_field = "AD07C3F14C8E3CE1725F0751C8501839", hash_generated_field = "F9833AA7D1D680BFE701856BF633E8CF")

    protected boolean mIsMinInfoReady = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.121 -0400", hash_original_field = "15640D9B0B36BDC20633E53EC16423E7", hash_generated_field = "D6E8E3B7AD5D24A742CC13AA70A64F63")

    private boolean isEriTextLoaded = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.121 -0400", hash_original_field = "8A1E3B909DBBB0E5FDD59EF5FFDEC3E5", hash_generated_field = "EBB4A27CD6CDA92F928E719D02425A52")

    protected boolean isSubscriptionFromRuim = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.121 -0400", hash_original_field = "2F689554B1DD1BCD330B1F900CAE6C70", hash_generated_field = "B4AF510D630F6D0ABA0DA5E3978D4F1B")

    private String mRegistrationDeniedReason;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.121 -0400", hash_original_field = "324D8A1D3F81E730D5099A48CEE0C5B6", hash_generated_field = "CC964D293F1703643DB273FCC0901562")

    private ContentResolver cr;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.121 -0400", hash_original_field = "B4A4615841D0A979D099D70EEA1A37DE", hash_generated_field = "7317EA2E3861B648BD5D2085310B5F7A")

    private String currentCarrier = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.122 -0400", hash_original_field = "11E7010812F1C4E8B149974C6F93DD15", hash_generated_field = "03D73698E5EDB62B6DF95EF124F43A7C")

    private ContentObserver mAutoTimeObserver = new ContentObserver(new Handler()) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.122 -0400", hash_original_method = "6B8D04F75A24E09E038AB230F1FA031E", hash_generated_method = "172CE0A53ECBD305539544F2E56D2E30")
        @Override
        public void onChange(boolean selfChange) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            log("Auto time state changed");
            revertToNitzTime();
            addTaint(selfChange);
            // ---------- Original Method ----------
            //if (DBG) log("Auto time state changed");
            //revertToNitzTime();
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.123 -0400", hash_original_field = "5FB03C4834787FF054B0ABAC3DB94EDA", hash_generated_field = "C5BEA179082ACFE3262F4154B536A120")

    private ContentObserver mAutoTimeZoneObserver = new ContentObserver(new Handler()) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.123 -0400", hash_original_method = "8FD17110C48D1CBE2477FC41B8E67E94", hash_generated_method = "937331EFFBE00AA83A94C8B5D850F5AD")
        @Override
        public void onChange(boolean selfChange) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            log("Auto time zone state changed");
            revertToNitzTimeZone();
            addTaint(selfChange);
            // ---------- Original Method ----------
            //if (DBG) log("Auto time zone state changed");
            //revertToNitzTimeZone();
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.128 -0400", hash_original_method = "FF3701A2004D17249B7B4B59CF4365CF", hash_generated_method = "7518CF33BF464FCB9CA023B679C929FE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.129 -0400", hash_original_method = "4D5D490C37798965D77553069E20CD07", hash_generated_method = "2493853BE4052E2639ABC612314A5661")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.129 -0400", hash_original_method = "BA9FDB49D0B6CB52D4E369B5C2B6B17A", hash_generated_method = "C9E7FAAD0D714F705898C9CAA8F5C6C2")
    @Override
    protected void finalize() {
        log("CdmaServiceStateTracker finalized");
        // ---------- Original Method ----------
        //if (DBG) log("CdmaServiceStateTracker finalized");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.143 -0400", hash_original_method = "70290EDA16C74DFE014583BB384DB8B5", hash_generated_method = "4011C962E7859DF77090BE4FC5F51A5C")
    public void registerForSubscriptionInfoReady(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Registrant r;
        r = new Registrant(h, what, obj);
        cdmaForSubscriptionInfoReadyRegistrants.add(r);
        {
            boolean varE32EA0BBDD6B91C9D19F50A2B5A8A1E3_1555791634 = (isMinInfoReady());
            {
                r.notifyRegistrant();
            } //End block
        } //End collapsed parenthetic
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //Registrant r = new Registrant(h, what, obj);
        //cdmaForSubscriptionInfoReadyRegistrants.add(r);
        //if (isMinInfoReady()) {
            //r.notifyRegistrant();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.144 -0400", hash_original_method = "19125607721EAC24124C4D5516B60F75", hash_generated_method = "F3352F927858508B726C27C8F8D97BBA")
    public void unregisterForSubscriptionInfoReady(Handler h) {
        cdmaForSubscriptionInfoReadyRegistrants.remove(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //cdmaForSubscriptionInfoReadyRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.147 -0400", hash_original_method = "754E8D2400977D5A28AAECFFE4ABD510", hash_generated_method = "80B341477FBF26C7525322465CF3FC81")
    @Override
    public void handleMessage(Message msg) {
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
            boolean var526F1BDDC71532C049873C5302565E55_1727415699 = (!(cm.getRadioState().isOn()) || (cm.getRadioState().isGsm()));
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
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.166 -0400", hash_original_method = "BC2E3346E1E8D048BB892FC104E776BC", hash_generated_method = "1E7CC85DBEA7DABEEA3808AC4F52841E")
    @Override
    protected void setPowerStateToDesired() {
        {
            boolean var132800EA641B7653EC59634384D41AC8_1044111060 = (mDesiredPowerState
            && cm.getRadioState() == CommandsInterface.RadioState.RADIO_OFF);
            {
                cm.setRadioPower(true, null);
            } //End block
            {
                boolean var9EF9CD1D5966856073F2A7E801160763_390867356 = (!mDesiredPowerState && cm.getRadioState().isOn());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.167 -0400", hash_original_method = "BDCA4E41D3AB74048D93171255E149A7", hash_generated_method = "B8B08E3FA5B90982E303220DD974FAD3")
    @Override
    protected void updateSpnDisplay() {
        String plmn;
        plmn = ss.getOperatorAlphaLong();
        {
            boolean varBC9C6DD660615C6E1E2DD0233001B92B_971118282 = (!TextUtils.equals(plmn, mCurPlmn));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.167 -0400", hash_original_method = "A0DE0F5E4F4D4787509D60C270D17835", hash_generated_method = "DD65FBBAE51CA729A14CE3CCA25C9309")
    @Override
    protected Phone getPhone() {
        Phone varB4EAC82CA7396A68D541C85D26508E83_588014966 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_588014966 = phone;
        varB4EAC82CA7396A68D541C85D26508E83_588014966.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_588014966;
        // ---------- Original Method ----------
        //return phone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.167 -0400", hash_original_method = "E924685B280F7636BB1194CB1DB8B328", hash_generated_method = "F22C14614B1CFF5C8AFC818FD3CB961A")
    protected void setCdmaTechnology(int radioTechnology) {
        mNewDataConnectionState = radioTechnologyToDataServiceState(radioTechnology);
        newSS.setRadioTechnology(radioTechnology);
        newNetworkType = radioTechnology;
        // ---------- Original Method ----------
        //mNewDataConnectionState = radioTechnologyToDataServiceState(radioTechnology);
        //newSS.setRadioTechnology(radioTechnology);
        //newNetworkType = radioTechnology;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.195 -0400", hash_original_method = "BE829AA0C3B19F93CC8F98530D925AC3", hash_generated_method = "15E55BADE76ADE876A4242CF5B223FC9")
    protected void handlePollStateResultMessage(int what, AsyncResult ar) {
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
                boolean var64F902D6C515FBF5301383078A8A1810_184822724 = ((opNames[2] == null) || (opNames[2].length() < 5)
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
                boolean varBC92A3357E9408F0FD52AC7CBCDE6A5F_93636285 = (cm.getNvState().isNVReady());
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
        addTaint(what);
        addTaint(ar.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.198 -0400", hash_original_method = "1B5F4BD94220D105FC0E737C13196363", hash_generated_method = "B305C7126472BC8B00D0E142C14818BC")
    @Override
    protected void handlePollStateResult(int what, AsyncResult ar) {
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
                boolean var0F541275CA306A5F1AC77D786FD54CFD_600378753 = (!cm.getRadioState().isOn());
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
                boolean var29AC97C0502F6AB3FF9782C48F8FA76A_1755581742 = (!isSidsAllZeros() && isHomeSid(newSS.getSystemId()));
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
                boolean varA035E8FBCA988F8B349976EEFE0F689A_1384317018 = (TextUtils.isEmpty(mPrlVersion));
                {
                    isPrlLoaded = false;
                } //End block
            } //End collapsed parenthetic
            {
                newSS.setCdmaRoamingIndicator(EriInfo.ROAMING_INDICATOR_OFF);
            } //End block
            {
                boolean varF459B34130F5C1301CC31DC3B09702EA_480341464 = (!isSidsAllZeros());
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
        addTaint(what);
        addTaint(ar.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.199 -0400", hash_original_method = "6C8071E15167CEBD3E2C13FCDC5BEC69", hash_generated_method = "4F34229AB8DB2417A1A42514981ACCDB")
    protected void setSignalStrengthDefaultValues() {
        mSignalStrength = new SignalStrength(99, -1, -1, -1, -1, -1, -1, false);
        // ---------- Original Method ----------
        //mSignalStrength = new SignalStrength(99, -1, -1, -1, -1, -1, -1, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.200 -0400", hash_original_method = "518F03C8AA7D2E41BBC9B0EF8F2349B8", hash_generated_method = "3C4EB7591E80BAD3CC100C4B5DDDF137")
    protected void pollState() {
        pollingContext = new int[1];
        pollingContext[0] = 0;
        {
            Object varA9E12DC9226BD6A76EE86EBF3C63475C_1456241209 = (cm.getRadioState());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.213 -0400", hash_original_method = "E69BA838DECF1BB5E62D048E955B2CB0", hash_generated_method = "B35CF2F80327B30C1A76042C1E66AE3A")
    protected void fixTimeZone(String isoCountryCode) {
        TimeZone zone;
        zone = null;
        String zoneName;
        zoneName = SystemProperties.get(TIMEZONE_PROPERTY);
        {
            boolean varCB8564F90A8584AF96581816886E97BA_1954241290 = ((mZoneOffset == 0) && (mZoneDst == false) && (zoneName != null)
                && (zoneName.length() > 0)
                && (Arrays.binarySearch(GMT_COUNTRY_CODES, isoCountryCode) < 0));
            {
                zone = TimeZone.getDefault();
                long tzOffset;
                tzOffset = zone.getOffset(System.currentTimeMillis());
                {
                    boolean varEEB7CD030807CE702D36FA7DEF7E06F9_692979601 = (getAutoTime());
                    {
                        setAndBroadcastNetworkSetTime(System.currentTimeMillis() - tzOffset);
                    } //End block
                    {
                        mSavedTime = mSavedTime - tzOffset;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                boolean var26136DD7D51CA801EC28D07A7D018010_183578629 = (isoCountryCode.equals(""));
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
                boolean var8B664356E036D01AFB0F5E4CF908C02F_736078540 = (getAutoTimeZone());
                {
                    setAndBroadcastNetworkSetTimeZone(zone.getID());
                } //End block
            } //End collapsed parenthetic
            saveNitzTimeZone(zone.getID());
        } //End block
        addTaint(isoCountryCode.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.216 -0400", hash_original_method = "0FA304F04B86F76391D3D9DA6F1DEA62", hash_generated_method = "9EB5008221B82FDD59D55F698B2A8DA2")
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
            boolean varF88E9DCD3AEEB219F0C2A6585652E72B_783578877 = (ss.getState() != newSS.getState() ||
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
                boolean var1644C0B76D1EEAE538D65F783B0A10D2_926281346 = (cm.getRadioState().isNVReady());
                {
                    String eriText;
                    {
                        boolean var0782B3C53497F07CDAB38A690B362545_1123374841 = (ss.getState() == ServiceState.STATE_IN_SERVICE);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.237 -0400", hash_original_method = "99CED85D89C5E9DD8967FF1E935BF80B", hash_generated_method = "915F0B7DBF9C91E6A6F06C7494AADA20")
    private TimeZone getNitzTimeZone(int offset, boolean dst, long when) {
        TimeZone varB4EAC82CA7396A68D541C85D26508E83_352597469 = null; //Variable for return #1
        TimeZone guess;
        guess = findTimeZone(offset, dst, when);
        {
            guess = findTimeZone(offset, !dst, when);
        } //End block
        log("getNitzTimeZone returning " + (guess == null ? guess : guess.getID()));
        varB4EAC82CA7396A68D541C85D26508E83_352597469 = guess;
        addTaint(offset);
        addTaint(dst);
        addTaint(when);
        varB4EAC82CA7396A68D541C85D26508E83_352597469.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_352597469;
        // ---------- Original Method ----------
        //TimeZone guess = findTimeZone(offset, dst, when);
        //if (guess == null) {
            //guess = findTimeZone(offset, !dst, when);
        //}
        //if (DBG) log("getNitzTimeZone returning " + (guess == null ? guess : guess.getID()));
        //return guess;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.332 -0400", hash_original_method = "950DB35A634BB86898B3E74AA5BE6013", hash_generated_method = "14E949DAD4246FBD3A28A5324081243C")
    private TimeZone findTimeZone(int offset, boolean dst, long when) {
        TimeZone varB4EAC82CA7396A68D541C85D26508E83_1001023408 = null; //Variable for return #1
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
                    boolean var1060EAEE62A1A81001DA148F1CCC674A_114604150 = (tz.getOffset(when) == offset &&
                    tz.inDaylightTime(d) == dst);
                    {
                        guess = tz;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1001023408 = guess;
        addTaint(offset);
        addTaint(dst);
        addTaint(when);
        varB4EAC82CA7396A68D541C85D26508E83_1001023408.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1001023408;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.332 -0400", hash_original_method = "75DB599AC418C41475672A1B4451EF2E", hash_generated_method = "487572D30F5A8FD38ADD868B081A2150")
    protected void queueNextSignalStrengthPoll() {
        {
            boolean varADAA48EFD9B70BA23908E80A474BFA5A_285483635 = (dontPollSignalStrength || (cm.getRadioState().isGsm()));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.349 -0400", hash_original_method = "76CDF956056DDB53150BD0C17057AE41", hash_generated_method = "A17F2F5543DD39DF010B6FBCC8F83669")
    protected void onSignalStrengthResult(AsyncResult ar) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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
        addTaint(ar.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.350 -0400", hash_original_method = "DF77DC7CB442AC6CF875159BD0FE26E0", hash_generated_method = "F288B792A6644045321493351F225755")
    protected int radioTechnologyToDataServiceState(int code) {
        int retVal;
        retVal = ServiceState.STATE_OUT_OF_SERVICE;
        //Begin case 6 7 8 12 13 
        retVal = ServiceState.STATE_IN_SERVICE;
        //End case 6 7 8 12 13 
        //Begin case default 
        loge("radioTechnologyToDataServiceState: Wrong radioTechnology code.");
        //End case default 
        addTaint(code);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1068538840 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1068538840;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.350 -0400", hash_original_method = "DA573DADA483FE1143660303AA3E0D9F", hash_generated_method = "C0FEB605F930A6811BDA166D41DE127B")
    protected int regCodeToServiceState(int code) {
        //Begin case default 
        loge("regCodeToServiceState: unexpected service state " + code);
        //End case default 
        addTaint(code);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_168438819 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_168438819;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.365 -0400", hash_original_method = "2F7466C178280C26D6BC47DE1AFB7432", hash_generated_method = "A15C4FAE0C15509B588BE6F2E97FAA07")
    public int getCurrentDataConnectionState() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1902766218 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1902766218;
        // ---------- Original Method ----------
        //return mDataConnectionState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.365 -0400", hash_original_method = "19036A7D1DADA943DC912DAB6396B9AD", hash_generated_method = "01C5466CB3B058A3FDEB7BB48F842069")
    private boolean regCodeIsRoaming(int code) {
        addTaint(code);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1592445809 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1592445809;
        // ---------- Original Method ----------
        //return 5 == code;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.417 -0400", hash_original_method = "B4323D2F9A07343D2462A4D59ED08046", hash_generated_method = "08C357FFF99150849423450206D19CA7")
    private boolean isRoamIndForHomeSystem(String roamInd) {
        String homeRoamIndicators;
        homeRoamIndicators = SystemProperties.get("ro.cdma.homesystem");
        {
            boolean var315D147B17EF94F7C5366417A7792112_2058266842 = (!TextUtils.isEmpty(homeRoamIndicators));
            {
                {
                    String homeRoamInd = homeRoamIndicators.split(",")[0];
                    {
                        {
                            boolean varA386460DA3595176FB4BAA16B8D8F859_1356813916 = (homeRoamInd.equals(roamInd));
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(roamInd.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1894200556 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1894200556;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.418 -0400", hash_original_method = "011C4920ECDF4CF24EF92E838B11DA6F", hash_generated_method = "7A9F195596F76156BD619BEDE4B56749")
    private boolean isRoamingBetweenOperators(boolean cdmaRoaming, ServiceState s) {
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
        addTaint(cdmaRoaming);
        addTaint(s.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_378291158 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_378291158;
        // ---------- Original Method ----------
        //String spn = SystemProperties.get(TelephonyProperties.PROPERTY_ICC_OPERATOR_ALPHA, "empty");
        //String onsl = s.getOperatorAlphaLong();
        //String onss = s.getOperatorAlphaShort();
        //boolean equalsOnsl = onsl != null && spn.equals(onsl);
        //boolean equalsOnss = onss != null && spn.equals(onss);
        //return cdmaRoaming && !(equalsOnsl || equalsOnss);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.423 -0400", hash_original_method = "7ADA939B474B339ADDF025B993055C9A", hash_generated_method = "C8BA6A5733E51EC7A23AFB0472F9FBF4")
    private void setTimeFromNITZString(String nitz, long nitzReceiveTime) {
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
                        boolean var8053821E6225ABE6D6EDD5F45C9DBCB8_1838057758 = (iso != null && iso.length() > 0);
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
                    boolean var624415BE8DA2189070E2F3831D7C1692_20997181 = (getAutoTimeZone());
                    {
                        setAndBroadcastNetworkSetTimeZone(zone.getID());
                    } //End block
                } //End collapsed parenthetic
                saveNitzTimeZone(zone.getID());
            } //End block
            String ignore;
            ignore = SystemProperties.get("gsm.ignore-nitz");
            {
                boolean varE5D77747E14F70AD020ECEBD14623725_242244286 = (ignore != null && ignore.equals("yes"));
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
                    boolean varEEB7CD030807CE702D36FA7DEF7E06F9_1173313521 = (getAutoTime());
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
                            boolean var824386FFC5EE5DF55B4AAF406EE0D224_1963901827 = ((mSavedAtTime == 0) || (timeSinceLastUpdate > nitzUpdateSpacing)
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
        addTaint(nitz.getTaint());
        addTaint(nitzReceiveTime);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.447 -0400", hash_original_method = "606CF17A4D40300EAFFE0BD67B82E0B6", hash_generated_method = "CF1D71AD45D29C0989AC084346C95817")
    private boolean getAutoTime() {
        try 
        {
            boolean var0318692E4935505BFEE97424BA2C2BDC_1990023769 = (Settings.System.getInt(cr, Settings.System.AUTO_TIME) > 0);
        } //End block
        catch (SettingNotFoundException snfe)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1910146242 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1910146242;
        // ---------- Original Method ----------
        //try {
            //return Settings.System.getInt(cr, Settings.System.AUTO_TIME) > 0;
        //} catch (SettingNotFoundException snfe) {
            //return true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.448 -0400", hash_original_method = "46A307C7AC0E208B22907DFB9CC04F45", hash_generated_method = "652EF1D8F9C320AD6305FEFE0EBA1972")
    private boolean getAutoTimeZone() {
        try 
        {
            boolean var6E6BE051602FD448D5A310EEAFCD9E4E_280528872 = (Settings.System.getInt(cr, Settings.System.AUTO_TIME_ZONE) > 0);
        } //End block
        catch (SettingNotFoundException snfe)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_787515551 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_787515551;
        // ---------- Original Method ----------
        //try {
            //return Settings.System.getInt(cr, Settings.System.AUTO_TIME_ZONE) > 0;
        //} catch (SettingNotFoundException snfe) {
            //return true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.448 -0400", hash_original_method = "AC4D6B705E7065D39BD6B0621414F077", hash_generated_method = "89E6488BB9B703C7CA9BBABF73A30618")
    private void saveNitzTimeZone(String zoneId) {
        mSavedTimeZone = zoneId;
        // ---------- Original Method ----------
        //mSavedTimeZone = zoneId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.452 -0400", hash_original_method = "28A8B5328B033F98ED5E62B240AD20B6", hash_generated_method = "66F8BCE0B21D2935AA49F19A85909AFC")
    private void setAndBroadcastNetworkSetTimeZone(String zoneId) {
        AlarmManager alarm;
        alarm = (AlarmManager) phone.getContext().getSystemService(Context.ALARM_SERVICE);
        alarm.setTimeZone(zoneId);
        Intent intent;
        intent = new Intent(TelephonyIntents.ACTION_NETWORK_SET_TIMEZONE);
        intent.addFlags(Intent.FLAG_RECEIVER_REPLACE_PENDING);
        intent.putExtra("time-zone", zoneId);
        phone.getContext().sendStickyBroadcast(intent);
        addTaint(zoneId.getTaint());
        // ---------- Original Method ----------
        //AlarmManager alarm =
            //(AlarmManager) phone.getContext().getSystemService(Context.ALARM_SERVICE);
        //alarm.setTimeZone(zoneId);
        //Intent intent = new Intent(TelephonyIntents.ACTION_NETWORK_SET_TIMEZONE);
        //intent.addFlags(Intent.FLAG_RECEIVER_REPLACE_PENDING);
        //intent.putExtra("time-zone", zoneId);
        //phone.getContext().sendStickyBroadcast(intent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.452 -0400", hash_original_method = "062E38B571EEA7E979075562F8B40A5D", hash_generated_method = "D501F05FE0035386C06CD721A684230F")
    private void setAndBroadcastNetworkSetTime(long time) {
        SystemClock.setCurrentTimeMillis(time);
        Intent intent;
        intent = new Intent(TelephonyIntents.ACTION_NETWORK_SET_TIME);
        intent.addFlags(Intent.FLAG_RECEIVER_REPLACE_PENDING);
        intent.putExtra("time", time);
        phone.getContext().sendStickyBroadcast(intent);
        addTaint(time);
        // ---------- Original Method ----------
        //SystemClock.setCurrentTimeMillis(time);
        //Intent intent = new Intent(TelephonyIntents.ACTION_NETWORK_SET_TIME);
        //intent.addFlags(Intent.FLAG_RECEIVER_REPLACE_PENDING);
        //intent.putExtra("time", time);
        //phone.getContext().sendStickyBroadcast(intent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.453 -0400", hash_original_method = "FAE09FD02085B2FF4E1D8E37B65790F8", hash_generated_method = "24F8DDBFF23DCC8EE415C68AACC244E2")
    private void revertToNitzTime() {
        {
            boolean var295A15F3D6D43E502B81033D23E388EE_2080122399 = (Settings.System.getInt(cr, Settings.System.AUTO_TIME, 0) == 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.453 -0400", hash_original_method = "72156026C5CBDDA4CCFB821F20D0E263", hash_generated_method = "414DE152622BFA8739C10545CCC04923")
    private void revertToNitzTimeZone() {
        {
            boolean var368E56141E4682CFD54AD9DE0B6F4586_329769370 = (Settings.System.getInt(phone.getContext().getContentResolver(),
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.465 -0400", hash_original_method = "32C0C58A5E03F7E404DD21382316ACEF", hash_generated_method = "6CE41D9364121246937C89DE65BB20DE")
    protected boolean isSidsAllZeros() {
        {
            {
                int i;
                i = 0;
            } //End collapsed parenthetic
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1205816842 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1205816842;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.466 -0400", hash_original_method = "D3D57AE588662EF8725CB60FCA1C3072", hash_generated_method = "17E9CF560BDA5530FE544867BD95E8D5")
    private boolean isHomeSid(int sid) {
        {
            {
                int i;
                i = 0;
            } //End collapsed parenthetic
        } //End block
        addTaint(sid);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1118368888 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1118368888;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.466 -0400", hash_original_method = "5C4C41F870A905A307BF05376EE79383", hash_generated_method = "2047EE8F3DFF50038578B7AEE41A2859")
    public boolean isConcurrentVoiceAndDataAllowed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_914117575 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_914117575;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.480 -0400", hash_original_method = "A5028D79B927656E45CDFA536F16F5AB", hash_generated_method = "D3600EAE37A0F5C4148EC438ACE37758")
    public String getMdnNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_17526910 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_17526910 = mMdn;
        varB4EAC82CA7396A68D541C85D26508E83_17526910.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_17526910;
        // ---------- Original Method ----------
        //return mMdn;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.481 -0400", hash_original_method = "133C132C72A1734541959456CF27FF0A", hash_generated_method = "9C8EEADAEBF1063DC84DAE73BCF620BF")
    public String getCdmaMin() {
        String varB4EAC82CA7396A68D541C85D26508E83_104305986 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_104305986 = mMin;
        varB4EAC82CA7396A68D541C85D26508E83_104305986.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_104305986;
        // ---------- Original Method ----------
        //return mMin;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.482 -0400", hash_original_method = "B5AD5686CB21B47DB5A2223CCDBB4F42", hash_generated_method = "42DCF8D8F9408949D03379DD2B6CA768")
    public String getPrlVersion() {
        String varB4EAC82CA7396A68D541C85D26508E83_775123978 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_775123978 = mPrlVersion;
        varB4EAC82CA7396A68D541C85D26508E83_775123978.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_775123978;
        // ---------- Original Method ----------
        //return mPrlVersion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.487 -0400", hash_original_method = "B26D3610EF4478BB5ED2ADA9EDE43E3B", hash_generated_method = "4275F94964840C474B53E27D86C2EC44")
     String getImsi() {
        String varB4EAC82CA7396A68D541C85D26508E83_476939206 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1106780378 = null; //Variable for return #2
        String operatorNumeric;
        operatorNumeric = SystemProperties.get(
                TelephonyProperties.PROPERTY_ICC_OPERATOR_NUMERIC, "");
        {
            boolean varF68187D93855D84C5AED475661AA07AC_961708004 = (!TextUtils.isEmpty(operatorNumeric) && getCdmaMin() != null);
            {
                varB4EAC82CA7396A68D541C85D26508E83_476939206 = (operatorNumeric + getCdmaMin());
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1106780378 = null;
            } //End block
        } //End collapsed parenthetic
        String varA7E53CE21691AB073D9660D615818899_651369783; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_651369783 = varB4EAC82CA7396A68D541C85D26508E83_476939206;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_651369783 = varB4EAC82CA7396A68D541C85D26508E83_1106780378;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_651369783.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_651369783;
        // ---------- Original Method ----------
        //String operatorNumeric = SystemProperties.get(
                //TelephonyProperties.PROPERTY_ICC_OPERATOR_NUMERIC, "");
        //if (!TextUtils.isEmpty(operatorNumeric) && getCdmaMin() != null) {
            //return (operatorNumeric + getCdmaMin());
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.487 -0400", hash_original_method = "8F0255C2E086694196AF7CFC36B7EF43", hash_generated_method = "842ADB1263523F70E2FCBA4B21D98629")
    public boolean isMinInfoReady() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_636855506 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_636855506;
        // ---------- Original Method ----------
        //return mIsMinInfoReady;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.494 -0400", hash_original_method = "0E452BF490F5457F3887197BA13C1AF4", hash_generated_method = "4F8A882FD05383BBE4FA375AE1429C50")
     int getOtasp() {
        int provisioningState;
        {
            boolean varBE6EA1BEB15C6575B4E6862F8C2A1A4E_15008529 = (mMin == null || (mMin.length() < 6));
            {
                log("getOtasp: bad mMin='" + mMin + "'");
                provisioningState = OTASP_UNKNOWN;
            } //End block
            {
                {
                    boolean varC1F4BAB057A6E1164C1F9ABE5370C980_183546775 = ((mMin.equals(UNACTIVATED_MIN_VALUE)
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_380288819 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_380288819;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.494 -0400", hash_original_method = "99845E4FDDAE6236D8C7F396E4374533", hash_generated_method = "8E63CE6D461F9471D4482A19BF636C81")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.496 -0400", hash_original_method = "B2E611749AA45590CADF6B42B9066FE3", hash_generated_method = "D41A4D04B472AC40C460E75FF25956DA")
    protected void parseSidNid(String sidStr, String nidStr) {
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
        addTaint(sidStr.getTaint());
        addTaint(nidStr.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.498 -0400", hash_original_method = "610B4A562CE77C76E210E506F221FC8A", hash_generated_method = "D98156DC904682BC1D051A9E298FF84F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.499 -0400", hash_original_method = "F8EA3CF0B7D491A29C0D20E35CC8F967", hash_generated_method = "33CC4D22E3E33A24B75B8A1903D1B3D7")
    @Override
    protected void log(String s) {
        Log.d(LOG_TAG, "[CdmaSST] " + s);
        addTaint(s.getTaint());
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[CdmaSST] " + s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.499 -0400", hash_original_method = "385CD47B6889905FF3482AEA1E26688E", hash_generated_method = "1D118F9E2F2137E0FEA65546C90AEC19")
    @Override
    protected void loge(String s) {
        addTaint(s.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[CdmaSST] " + s);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.499 -0400", hash_original_field = "951C150E6D062E6AED2C45BB9B756185", hash_generated_field = "3985FC5365F0E17AC0BA70F3DC93B852")

    static String LOG_TAG = "CDMA";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.499 -0400", hash_original_field = "2B146BBE35382830495275AE51C5D56A", hash_generated_field = "BD899A96E1F0F06402A26C36279519B0")

    private static String UNACTIVATED_MIN2_VALUE = "000000";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.499 -0400", hash_original_field = "7C397EFDB6962B89448A70E2E1E3F1A3", hash_generated_field = "112EAEE40A85C18567E2AB3EC357B877")

    private static String UNACTIVATED_MIN_VALUE = "1111110111";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.499 -0400", hash_original_field = "7DF72EDD77ED799A10D52A26EC030B80", hash_generated_field = "E645996FF2120F701CC634E835B06AD4")

    private static int NITZ_UPDATE_SPACING_DEFAULT = 1000 * 60 * 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.499 -0400", hash_original_field = "381D94A5C9F60BF73CB0E258FB89F604", hash_generated_field = "DA818E9F60EF83605404FBB6C6645552")

    private static int NITZ_UPDATE_DIFF_DEFAULT = 2000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:20.499 -0400", hash_original_field = "8AA5488317F9A54E56045D1AAF74BB75", hash_generated_field = "0B91C15402C3808CD55E3FD76F0A1C48")

    private static String WAKELOCK_TAG = "ServiceStateTracker";
}

