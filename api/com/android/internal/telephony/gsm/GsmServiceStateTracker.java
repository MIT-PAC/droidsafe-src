package com.android.internal.telephony.gsm;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.245 -0400", hash_original_field = "F7A42FE7211F98AC7A60A285AC3A9E87", hash_generated_field = "690DC9441FA6BD04E0472B4DF9E035F8")

    GSMPhone phone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.245 -0400", hash_original_field = "B9C5653E1C2BC689F2CC98D72803F0E0", hash_generated_field = "6501E6CCC6A627167D828A01CEBF7711")

    GsmCellLocation cellLoc;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.245 -0400", hash_original_field = "B325523B8771CAA3A7FB54CA6901D43A", hash_generated_field = "B261F7AD66455AA0C3F3A08229915B3D")

    GsmCellLocation newCellLoc;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.245 -0400", hash_original_field = "5E797CD98A6F48EA74102A194ABE8414", hash_generated_field = "5BA84AC7CBE58E4EDB6614D7B15D6E0E")

    int mPreferredNetworkType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.245 -0400", hash_original_field = "09ADCB4D8E411083650BF094C0F5A282", hash_generated_field = "07B777CC7BF8F0F7679AC97DE6B0C153")

    private int gprsState = ServiceState.STATE_OUT_OF_SERVICE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.245 -0400", hash_original_field = "3DD74F5CB43F87ECACC4768DBADF0137", hash_generated_field = "7035A3B0948B79A30C2C00DECE9F4570")

    private int newGPRSState = ServiceState.STATE_OUT_OF_SERVICE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.245 -0400", hash_original_field = "2AFEACA217B557D16E803474269AC334", hash_generated_field = "5F1A31BADD427D5DFCB23ECFD73B8B95")

    private int mMaxDataCalls = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.245 -0400", hash_original_field = "E93FE6CD696F5691F32A4C7A9078BA63", hash_generated_field = "D1E578B67E4CC593BE870B60F03AA83C")

    private int mNewMaxDataCalls = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.245 -0400", hash_original_field = "A834835F3CEDAC8AC7E64228C76E5077", hash_generated_field = "981E84B4948A11F540AE3C83118D725F")

    private int mReasonDataDenied = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.245 -0400", hash_original_field = "D821D524FB7806A8991C807AE4CA7635", hash_generated_field = "3DCB78EC6066191396204C4D07EB7548")

    private int mNewReasonDataDenied = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.246 -0400", hash_original_field = "9380C85BAA057C151A0AF0A172BD132A", hash_generated_field = "0E48791EFF44078585E96EA7C7ED6E26")

    private boolean mGsmRoaming = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.246 -0400", hash_original_field = "BD02E473C1C27AC87C52110872C4EBF8", hash_generated_field = "4F72E8DCBAFD6C5A4FC303F5B439CC14")

    private boolean mDataRoaming = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.246 -0400", hash_original_field = "85105C0E76607ED02FD2FDEB8B0B0D87", hash_generated_field = "A81A887211F7F6A8BF5C317C7E4646E5")

    private boolean mEmergencyOnly = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.246 -0400", hash_original_field = "28BAF9CE3F67CB31A5C7E4A1C64709A2", hash_generated_field = "2D2C0A8AA7022D57AB24C477C9212676")

    private boolean mNeedFixZone = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.246 -0400", hash_original_field = "F22170EE4512552F24101CBB42D416D7", hash_generated_field = "C126894205DFD14FA38D307801001C6F")

    private int mZoneOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.246 -0400", hash_original_field = "C93085FA426E2C8BDD28EDA54293198A", hash_generated_field = "63800483D80F5CB684E683BC24E0A820")

    private boolean mZoneDst;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.246 -0400", hash_original_field = "0A09D50B767A402C68BB8923B251B081", hash_generated_field = "7498B22AB24D6B5E081FF2DDE0FD21C8")

    private long mZoneTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.246 -0400", hash_original_field = "91657A67842D433756013CCE7BEFC8EA", hash_generated_field = "C304726703E30667C2FAD4B6BFDDEB63")

    private boolean mGotCountryCode = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.246 -0400", hash_original_field = "324D8A1D3F81E730D5099A48CEE0C5B6", hash_generated_field = "CC964D293F1703643DB273FCC0901562")

    private ContentResolver cr;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.246 -0400", hash_original_field = "629AB99995100B7F6B737671E7028A77", hash_generated_field = "30A17FCDED9983DC17E4B0241936D019")

    String mSavedTimeZone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.246 -0400", hash_original_field = "0870ED367B81A3D199CC36F4FF58F6E3", hash_generated_field = "56DFA99AB6C2048EFF6A2B28FFEF5620")

    long mSavedTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.246 -0400", hash_original_field = "E11E42BBA30EA79639217C987535FA76", hash_generated_field = "2B2B2F1D0E3CAC70A6D7541E3BA2D300")

    long mSavedAtTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.246 -0400", hash_original_field = "794B9E75544086325155A72AA171A32E", hash_generated_field = "1929EEEAE2485E3C7781EBAA0F354C99")

    private boolean mNeedToRegForSimLoaded;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.246 -0400", hash_original_field = "8845867B8D05D961286A1A19CE10D2DC", hash_generated_field = "EA9A1384C97DE38DCF8B990AF3F83712")

    private boolean mStartedGprsRegCheck = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.246 -0400", hash_original_field = "D7F7DA1A823510EF7DFA18A7D3740A12", hash_generated_field = "69E634E61A627800AF487B771D6ECAD0")

    private boolean mReportedGprsNoReg = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.246 -0400", hash_original_field = "FA180D1FC40F4514789E94C434050443", hash_generated_field = "74FBA8E8F4402404F407A6E0DBC8943E")

    private Notification mNotification;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.246 -0400", hash_original_field = "69E45E7E240C011D8CB3CFDE90D76B33", hash_generated_field = "C0FF63B0998195CF037A71BFC5C5B113")

    private PowerManager.WakeLock mWakeLock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.246 -0400", hash_original_field = "438E769CBE3194E31EE3583D475755E2", hash_generated_field = "D741E5B3B277519D91E4FE02D3FAFF01")

    private String curSpn = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.247 -0400", hash_original_field = "8F0345704253C4ABC1429588E7767D95", hash_generated_field = "9047898EE9FB6E0F59121E370CC3C8CF")

    private String curPlmn = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.247 -0400", hash_original_field = "980A06D55B7D1D17AD8917BD8B3AD170", hash_generated_field = "E51B211F12EB3D4199E57F38674CC690")

    private int curSpnRule = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.697 -0400", hash_original_field = "AB74790817CE8598B3B84738E53E435A", hash_generated_field = "829A6BC80DDB03BAE60150DE88BC0EA8")

    private BroadcastReceiver mIntentReceiver = new BroadcastReceiver() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.697 -0400", hash_original_method = "7D33A0984FFB123C6674B46896DDEB1E", hash_generated_method = "CF369C8FCB5C79AAA993EA2D6A6CBEC9")
        @Override
        public void onReceive(Context context, Intent intent) {
            
            {
                boolean varD74456F3A5211D970550D171BFD231F1_1627726162 = (intent.getAction().equals(Intent.ACTION_LOCALE_CHANGED));
                {
                    updateSpnDisplay();
                } 
            } 
            addTaint(context.getTaint());
            addTaint(intent.getTaint());
            
            
                
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.697 -0400", hash_original_field = "DE088C6BF9EC1AFE67E7551680F21C7E", hash_generated_field = "EEAFB5DE9D002A7C986305AE1C501C25")

    private ContentObserver mAutoTimeObserver = new ContentObserver(new Handler()) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.697 -0400", hash_original_method = "227D40A344094AD4B591040BC6F6DC3D", hash_generated_method = "F4315810E745D16A27460B49034466AB")
        @Override
        public void onChange(boolean selfChange) {
            
            revertToNitzTime();
            addTaint(selfChange);
            
            
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.698 -0400", hash_original_field = "160828814E36CFDE204FECD88170AF0C", hash_generated_field = "B61F354992F7CF3E33A4CCB97A3FF08A")

    private ContentObserver mAutoTimeZoneObserver = new ContentObserver(new Handler()) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.698 -0400", hash_original_method = "CFFF91BA86D25926B76415F80D2C8421", hash_generated_method = "E308D52C44EEB3156885DEEED1F0C5D9")
        @Override
        public void onChange(boolean selfChange) {
            
            revertToNitzTimeZone();
            addTaint(selfChange);
            
            
            
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.249 -0400", hash_original_method = "89B681C68F2C3DCA55179D15C34AC4AC", hash_generated_method = "3674E78DB0738469C53C072BA81027AE")
    public  GsmServiceStateTracker(GSMPhone phone) {
        super();
        this.phone = phone;
        cm = phone.mCM;
        ss = new ServiceState();
        newSS = new ServiceState();
        cellLoc = new GsmCellLocation();
        newCellLoc = new GsmCellLocation();
        mSignalStrength = new SignalStrength();
        PowerManager powerManager = (PowerManager)phone.getContext().getSystemService(Context.POWER_SERVICE);
        mWakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, WAKELOCK_TAG);
        cm.registerForAvailable(this, EVENT_RADIO_AVAILABLE, null);
        cm.registerForRadioStateChanged(this, EVENT_RADIO_STATE_CHANGED, null);
        cm.registerForVoiceNetworkStateChanged(this, EVENT_NETWORK_STATE_CHANGED, null);
        cm.setOnNITZTime(this, EVENT_NITZ_TIME, null);
        cm.setOnSignalStrengthUpdate(this, EVENT_SIGNAL_STRENGTH_UPDATE, null);
        cm.setOnRestrictedStateChanged(this, EVENT_RESTRICTED_STATE_CHANGED, null);
        cm.registerForSIMReady(this, EVENT_SIM_READY, null);
        int airplaneMode = Settings.System.getInt(
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
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_LOCALE_CHANGED);
        phone.getContext().registerReceiver(mIntentReceiver, filter);
        phone.notifyOtaspChanged(OTASP_NOT_NEEDED);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.249 -0400", hash_original_method = "D8900B5121A238BBC317864D0A18F1DD", hash_generated_method = "B40ED7CB9364FAE6479A4D45B656DCB0")
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
        
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.249 -0400", hash_original_method = "6FB50CEA8307C4B6093E637FBC3F2923", hash_generated_method = "40BDA4D14701B8CE588BCB1AD2B486E8")
    protected void finalize() {
    if(DBG)        
        log("finalize");
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.250 -0400", hash_original_method = "A0DE0F5E4F4D4787509D60C270D17835", hash_generated_method = "0F81ACBC6F6FB1E12B3A00D606E32462")
    @Override
    protected Phone getPhone() {
Phone var3DF544D9611CD6A47CD50808F9E2E7D5_223417554 =         phone;
        var3DF544D9611CD6A47CD50808F9E2E7D5_223417554.addTaint(taint);
        return var3DF544D9611CD6A47CD50808F9E2E7D5_223417554;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.253 -0400", hash_original_method = "8D6E3CD042747DF0CD652F21C9ED2A0B", hash_generated_method = "60410A48D33DDE1A6DF861650696F9DF")
    public void handleMessage(Message msg) {
        addTaint(msg.getTaint());
        AsyncResult ar;
        int[] ints;
        String[] strings;
        Message message;
switch(msg.what){
        case EVENT_RADIO_AVAILABLE:
        break;
        case EVENT_SIM_READY:
        cm.setCurrentPreferredNetworkType();
    if(mNeedToRegForSimLoaded)        
        {
            phone.mIccRecords.registerForRecordsLoaded(this,
                            EVENT_SIM_RECORDS_LOADED, null);
            mNeedToRegForSimLoaded = false;
        } 
        boolean skipRestoringSelection = phone.getContext().getResources().getBoolean(
                        com.android.internal.R.bool.skip_restoring_network_selection);
    if(!skipRestoringSelection)        
        {
            phone.restoreSavedNetworkSelection(null);
        } 
        pollState();
        queueNextSignalStrengthPoll();
        break;
        case EVENT_RADIO_STATE_CHANGED:
        setPowerStateToDesired();
        pollState();
        break;
        case EVENT_NETWORK_STATE_CHANGED:
        pollState();
        break;
        case EVENT_GET_SIGNAL_STRENGTH:
    if(!(cm.getRadioState().isOn()) || (cm.getRadioState().isCdma()))        
        {
            return;
        } 
        ar = (AsyncResult) msg.obj;
        onSignalStrengthResult(ar);
        queueNextSignalStrengthPoll();
        break;
        case EVENT_GET_LOC_DONE:
        ar = (AsyncResult) msg.obj;
    if(ar.exception == null)        
        {
            String states[] = (String[])ar.result;
            int lac = -1;
            int cid = -1;
    if(states.length >= 3)            
            {
                try 
                {
    if(states[1] != null && states[1].length() > 0)                    
                    {
                        lac = Integer.parseInt(states[1], 16);
                    } 
    if(states[2] != null && states[2].length() > 0)                    
                    {
                        cid = Integer.parseInt(states[2], 16);
                    } 
                } 
                catch (NumberFormatException ex)
                {
                } 
            } 
            cellLoc.setLacAndCid(lac, cid);
            phone.notifyLocationChanged();
        } 
        disableSingleLocationUpdate();
        break;
        case EVENT_POLL_STATE_REGISTRATION:
        case EVENT_POLL_STATE_GPRS:
        case EVENT_POLL_STATE_OPERATOR:
        case EVENT_POLL_STATE_NETWORK_SELECTION_MODE:
        ar = (AsyncResult) msg.obj;
        handlePollStateResult(msg.what, ar);
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
        case EVENT_SIM_RECORDS_LOADED:
        updateSpnDisplay();
        break;
        case EVENT_LOCATION_UPDATES_ENABLED:
        ar = (AsyncResult) msg.obj;
    if(ar.exception == null)        
        {
            cm.getVoiceRegistrationState(obtainMessage(EVENT_GET_LOC_DONE, null));
        } 
        break;
        case EVENT_SET_PREFERRED_NETWORK_TYPE:
        ar = (AsyncResult) msg.obj;
        message = obtainMessage(EVENT_RESET_PREFERRED_NETWORK_TYPE, ar.userObj);
        cm.setPreferredNetworkType(mPreferredNetworkType, message);
        break;
        case EVENT_RESET_PREFERRED_NETWORK_TYPE:
        ar = (AsyncResult) msg.obj;
    if(ar.userObj != null)        
        {
            AsyncResult.forMessage(((Message) ar.userObj)).exception
                            = ar.exception;
            ((Message) ar.userObj).sendToTarget();
        } 
        break;
        case EVENT_GET_PREFERRED_NETWORK_TYPE:
        ar = (AsyncResult) msg.obj;
    if(ar.exception == null)        
        {
            mPreferredNetworkType = ((int[])ar.result)[0];
        } 
        else
        {
            mPreferredNetworkType = RILConstants.NETWORK_MODE_GLOBAL;
        } 
        message = obtainMessage(EVENT_SET_PREFERRED_NETWORK_TYPE, ar.userObj);
        int toggledNetworkType = RILConstants.NETWORK_MODE_GLOBAL;
        cm.setPreferredNetworkType(toggledNetworkType, message);
        break;
        case EVENT_CHECK_REPORT_GPRS:
    if(ss != null && !isGprsConsistent(gprsState, ss.getState()))        
        {
            GsmCellLocation loc = ((GsmCellLocation)phone.getCellLocation());
            EventLog.writeEvent(EventLogTags.DATA_NETWORK_REGISTRATION_FAIL,
                            ss.getOperatorNumeric(), loc != null ? loc.getCid() : -1);
            mReportedGprsNoReg = true;
        } 
        mStartedGprsRegCheck = false;
        break;
        case EVENT_RESTRICTED_STATE_CHANGED:
    if(DBG)        
        log("EVENT_RESTRICTED_STATE_CHANGED");
        ar = (AsyncResult) msg.obj;
        onRestrictedStateChanged(ar);
        break;
        default:
        super.handleMessage(msg);
        break;
}
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.254 -0400", hash_original_method = "BC2E3346E1E8D048BB892FC104E776BC", hash_generated_method = "1EBDA37B0127C1DB8911540E5C24C3D7")
    protected void setPowerStateToDesired() {
    if(mDesiredPowerState
            && cm.getRadioState() == CommandsInterface.RadioState.RADIO_OFF)        
        {
            cm.setRadioPower(true, null);
        } 
        else
    if(!mDesiredPowerState && cm.getRadioState().isOn())        
        {
            DataConnectionTracker dcTracker = phone.mDataConnectionTracker;
            powerOffRadioSafely(dcTracker);
        } 
        
        
            
            
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.254 -0400", hash_original_method = "E3C7A91B3D91C3ACB7BE5D936C3A4029", hash_generated_method = "7B80391196098382748D93DB9B77989F")
    @Override
    protected void hangupAndPowerOff() {
    if(phone.isInCall())        
        {
            phone.mCT.ringingCall.hangupIfAlive();
            phone.mCT.backgroundCall.hangupIfAlive();
            phone.mCT.foregroundCall.hangupIfAlive();
        } 
        cm.setRadioPower(false, null);
        
        
            
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.255 -0400", hash_original_method = "12AE11DB9489E0514D18AAE66522FB76", hash_generated_method = "726EC9BA479C3BADDC83DA12A726D188")
    protected void updateSpnDisplay() {
        int rule = phone.mIccRecords.getDisplayRule(ss.getOperatorNumeric());
        String spn = phone.mIccRecords.getServiceProviderName();
        String plmn = ss.getOperatorAlphaLong();
    if(mEmergencyOnly && cm.getRadioState().isOn())        
        {
            plmn = Resources.getSystem().
                getText(com.android.internal.R.string.emergency_calls_only).toString();
    if(DBG)            
            log("updateSpnDisplay: emergency only and radio is on plmn='" + plmn + "'");
        } 
    if(rule != curSpnRule
                || !TextUtils.equals(spn, curSpn)
                || !TextUtils.equals(plmn, curPlmn))        
        {
            boolean showSpn = !mEmergencyOnly && !TextUtils.isEmpty(spn)
                && (rule & SIMRecords.SPN_RULE_SHOW_SPN) == SIMRecords.SPN_RULE_SHOW_SPN;
            boolean showPlmn = !TextUtils.isEmpty(plmn) &&
                (rule & SIMRecords.SPN_RULE_SHOW_PLMN) == SIMRecords.SPN_RULE_SHOW_PLMN;
    if(DBG)            
            {
                log(String.format("updateSpnDisplay: changed sending intent" + " rule=" + rule +
                            " showPlmn='%b' plmn='%s' showSpn='%b' spn='%s'",
                            showPlmn, plmn, showSpn, spn));
            } 
            Intent intent = new Intent(Intents.SPN_STRINGS_UPDATED_ACTION);
            intent.addFlags(Intent.FLAG_RECEIVER_REPLACE_PENDING);
            intent.putExtra(Intents.EXTRA_SHOW_SPN, showSpn);
            intent.putExtra(Intents.EXTRA_SPN, spn);
            intent.putExtra(Intents.EXTRA_SHOW_PLMN, showPlmn);
            intent.putExtra(Intents.EXTRA_PLMN, plmn);
            phone.getContext().sendStickyBroadcast(intent);
        } 
        curSpnRule = rule;
        curSpn = spn;
        curPlmn = plmn;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.258 -0400", hash_original_method = "715C325B720DBA72DF5B4684F1B692D5", hash_generated_method = "39BCDF1C522917A80D14E71E0DA9061F")
    protected void handlePollStateResult(int what, AsyncResult ar) {
        addTaint(ar.getTaint());
        addTaint(what);
        int ints[];
        String states[];
    if(ar.userObj != pollingContext)        
        return;
    if(ar.exception != null)        
        {
            CommandException.Error err = null;
    if(ar.exception instanceof CommandException)            
            {
                err = ((CommandException)(ar.exception)).getCommandError();
            } 
    if(err == CommandException.Error.RADIO_NOT_AVAILABLE)            
            {
                cancelPollState();
                return;
            } 
    if(!cm.getRadioState().isOn())            
            {
                cancelPollState();
                return;
            } 
    if(err != CommandException.Error.OP_NOT_ALLOWED_BEFORE_REG_NW)            
            {
                loge("RIL implementation has returned an error where it must succeed" +
                        ar.exception);
            } 
        } 
        else
        try 
        {
switch(what){
            case EVENT_POLL_STATE_REGISTRATION:
            states = (String[])ar.result;
            int lac = -1;
            int cid = -1;
            int regState = -1;
            int reasonRegStateDenied = -1;
            int psc = -1;
    if(states.length > 0)            
            {
                try 
                {
                    regState = Integer.parseInt(states[0]);
    if(states.length >= 3)                    
                    {
    if(states[1] != null && states[1].length() > 0)                        
                        {
                            lac = Integer.parseInt(states[1], 16);
                        } 
    if(states[2] != null && states[2].length() > 0)                        
                        {
                            cid = Integer.parseInt(states[2], 16);
                        } 
                    } 
    if(states.length > 14)                    
                    {
    if(states[14] != null && states[14].length() > 0)                        
                        {
                            psc = Integer.parseInt(states[14], 16);
                        } 
                    } 
                } 
                catch (NumberFormatException ex)
                {
                    loge("error parsing RegistrationState: " + ex);
                } 
            } 
            mGsmRoaming = regCodeIsRoaming(regState);
            newSS.setState (regCodeToServiceState(regState));
    if(regState == 10 || regState == 12 || regState == 13 || regState == 14)            
            {
                mEmergencyOnly = true;
            } 
            else
            {
                mEmergencyOnly = false;
            } 
            newCellLoc.setLacAndCid(lac, cid);
            newCellLoc.setPsc(psc);
            break;
            case EVENT_POLL_STATE_GPRS:
            states = (String[])ar.result;
            int type = 0;
            regState = -1;
            mNewReasonDataDenied = -1;
            mNewMaxDataCalls = 1;
    if(states.length > 0)            
            {
                try 
                {
                    regState = Integer.parseInt(states[0]);
    if(states.length >= 4 && states[3] != null)                    
                    {
                        type = Integer.parseInt(states[3]);
                    } 
    if((states.length >= 5 ) && (regState == 3))                    
                    {
                        mNewReasonDataDenied = Integer.parseInt(states[4]);
                    } 
    if(states.length >= 6)                    
                    {
                        mNewMaxDataCalls = Integer.parseInt(states[5]);
                    } 
                } 
                catch (NumberFormatException ex)
                {
                    loge("error parsing GprsRegistrationState: " + ex);
                } 
            } 
            newGPRSState = regCodeToServiceState(regState);
            mDataRoaming = regCodeIsRoaming(regState);
            mNewRadioTechnology = type;
            newSS.setRadioTechnology(type);
            break;
            case EVENT_POLL_STATE_OPERATOR:
            String opNames[] = (String[])ar.result;
    if(opNames != null && opNames.length >= 3)            
            {
                newSS.setOperatorName (
                                opNames[0], opNames[1], opNames[2]);
            } 
            break;
            case EVENT_POLL_STATE_NETWORK_SELECTION_MODE:
            ints = (int[])ar.result;
            newSS.setIsManualSelection(ints[0] == 1);
            break;
}
        } 
        catch (RuntimeException ex)
        {
            loge("Exception while polling service state. Probably malformed RIL response." + ex);
        } 
        pollingContext[0]--;
    if(pollingContext[0] == 0)        
        {
            boolean roaming = (mGsmRoaming || mDataRoaming);
    if(mGsmRoaming && !isRoamingBetweenOperators(mGsmRoaming, newSS))            
            {
                roaming = false;
            } 
            newSS.setRoaming(roaming);
            newSS.setEmergencyOnly(mEmergencyOnly);
            pollStateDone();
        } 
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.260 -0400", hash_original_method = "76DE4C6A99E85827FF76DDCBD0A680F0", hash_generated_method = "FB6F947C716BD93C04B4BB847C77356E")
    private void setSignalStrengthDefaultValues() {
        mSignalStrength = new SignalStrength(99, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, true);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.261 -0400", hash_original_method = "4A9AA9B5E92E73D941CD4914D7782EA3", hash_generated_method = "2717FBF28FEDF837B9CA385A0EBBCFAD")
    private void pollState() {
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
        case RUIM_NOT_READY:
        case RUIM_READY:
        case RUIM_LOCKED_OR_ABSENT:
        case NV_NOT_READY:
        case NV_READY:
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
                    obtainMessage(
                        EVENT_POLL_STATE_OPERATOR, pollingContext));
        pollingContext[0]++;
        cm.getDataRegistrationState(
                    obtainMessage(
                        EVENT_POLL_STATE_GPRS, pollingContext));
        pollingContext[0]++;
        cm.getVoiceRegistrationState(
                    obtainMessage(
                        EVENT_POLL_STATE_REGISTRATION, pollingContext));
        pollingContext[0]++;
        cm.getNetworkSelectionMode(
                    obtainMessage(
                        EVENT_POLL_STATE_NETWORK_SELECTION_MODE, pollingContext));
        break;
}
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.266 -0400", hash_original_method = "9E4E42BAC69A7F7033D249A5EA2291CC", hash_generated_method = "1AED95EF47C48D4E18180853867EAA78")
    private void pollStateDone() {
    if(DBG)        
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
        } 
        boolean hasRegistered = ss.getState() != ServiceState.STATE_IN_SERVICE
            && newSS.getState() == ServiceState.STATE_IN_SERVICE;
        boolean hasDeregistered = ss.getState() == ServiceState.STATE_IN_SERVICE
            && newSS.getState() != ServiceState.STATE_IN_SERVICE;
        boolean hasGprsAttached = gprsState != ServiceState.STATE_IN_SERVICE
                && newGPRSState == ServiceState.STATE_IN_SERVICE;
        boolean hasGprsDetached = gprsState == ServiceState.STATE_IN_SERVICE
                && newGPRSState != ServiceState.STATE_IN_SERVICE;
        boolean hasRadioTechnologyChanged = mRadioTechnology != mNewRadioTechnology;
        boolean hasChanged = !newSS.equals(ss);
        boolean hasRoamingOn = !ss.getRoaming() && newSS.getRoaming();
        boolean hasRoamingOff = ss.getRoaming() && !newSS.getRoaming();
        boolean hasLocationChanged = !newCellLoc.equals(cellLoc);
    if(ss.getState() != newSS.getState() || gprsState != newGPRSState)        
        {
            EventLog.writeEvent(EventLogTags.GSM_SERVICE_STATE_CHANGE,
                ss.getState(), gprsState, newSS.getState(), newGPRSState);
        } 
        ServiceState tss;
        tss = ss;
        ss = newSS;
        newSS = tss;
        newSS.setStateOutOfService();
        GsmCellLocation tcl = cellLoc;
        cellLoc = newCellLoc;
        newCellLoc = tcl;
    if(hasRadioTechnologyChanged)        
        {
            int cid = -1;
            GsmCellLocation loc = ((GsmCellLocation)phone.getCellLocation());
    if(loc != null)            
            cid = loc.getCid();
            EventLog.writeEvent(EventLogTags.GSM_RAT_SWITCHED, cid, mRadioTechnology,
                    mNewRadioTechnology);
    if(DBG)            
            {
                log("RAT switched " + ServiceState.radioTechnologyToString(mRadioTechnology) +
                        " -> " + ServiceState.radioTechnologyToString(mNewRadioTechnology) +
                        " at cell " + cid);
            } 
        } 
        gprsState = newGPRSState;
        mReasonDataDenied = mNewReasonDataDenied;
        mMaxDataCalls = mNewMaxDataCalls;
        mRadioTechnology = mNewRadioTechnology;
        mNewRadioTechnology = 0;
        newSS.setStateOutOfService();
    if(hasRadioTechnologyChanged)        
        {
            phone.setSystemProperty(TelephonyProperties.PROPERTY_DATA_NETWORK_TYPE,
                    ServiceState.radioTechnologyToString(mRadioTechnology));
        } 
    if(hasRegistered)        
        {
            mNetworkAttachedRegistrants.notifyRegistrants();
        } 
    if(hasChanged)        
        {
            String operatorNumeric;
            updateSpnDisplay();
            phone.setSystemProperty(TelephonyProperties.PROPERTY_OPERATOR_ALPHA,
                ss.getOperatorAlphaLong());
            operatorNumeric = ss.getOperatorNumeric();
            phone.setSystemProperty(TelephonyProperties.PROPERTY_OPERATOR_NUMERIC, operatorNumeric);
    if(operatorNumeric == null)            
            {
                phone.setSystemProperty(TelephonyProperties.PROPERTY_OPERATOR_ISO_COUNTRY, "");
                mGotCountryCode = false;
            } 
            else
            {
                String iso = "";
                try 
                {
                    iso = MccTable.countryCodeForMcc(Integer.parseInt(
                            operatorNumeric.substring(0,3)));
                } 
                catch (NumberFormatException ex)
                {
                    loge("countryCodeForMcc error" + ex);
                } 
                catch (StringIndexOutOfBoundsException ex)
                {
                    loge("countryCodeForMcc error" + ex);
                } 
                phone.setSystemProperty(TelephonyProperties.PROPERTY_OPERATOR_ISO_COUNTRY, iso);
                mGotCountryCode = true;
    if(mNeedFixZone)                
                {
                    TimeZone zone = null;
                    String zoneName = SystemProperties.get(TIMEZONE_PROPERTY);
    if((mZoneOffset == 0) && (mZoneDst == false) &&
                        (zoneName != null) && (zoneName.length() > 0) &&
                        (Arrays.binarySearch(GMT_COUNTRY_CODES, iso) < 0))                    
                    {
                        zone = TimeZone.getDefault();
                        long tzOffset;
                        tzOffset = zone.getOffset(System.currentTimeMillis());
    if(getAutoTime())                        
                        {
                            setAndBroadcastNetworkSetTime(System.currentTimeMillis() - tzOffset);
                        } 
                        else
                        {
                            mSavedTime = mSavedTime - tzOffset;
                        } 
                    } 
                    else
    if(iso.equals(""))                    
                    {
                        zone = getNitzTimeZone(mZoneOffset, mZoneDst, mZoneTime);
                    } 
                    else
                    {
                        zone = TimeUtils.getTimeZone(mZoneOffset,
                            mZoneDst, mZoneTime, iso);
                    } 
                    mNeedFixZone = false;
    if(zone != null)                    
                    {
    if(getAutoTimeZone())                        
                        {
                            setAndBroadcastNetworkSetTimeZone(zone.getID());
                        } 
                        saveNitzTimeZone(zone.getID());
                    } 
                } 
            } 
            phone.setSystemProperty(TelephonyProperties.PROPERTY_OPERATOR_ISROAMING,
                ss.getRoaming() ? "true" : "false");
            phone.notifyServiceStateChanged(ss);
        } 
    if(hasGprsAttached)        
        {
            mAttachedRegistrants.notifyRegistrants();
        } 
    if(hasGprsDetached)        
        {
            mDetachedRegistrants.notifyRegistrants();
        } 
    if(hasRadioTechnologyChanged)        
        {
            phone.notifyDataConnection(Phone.REASON_NW_TYPE_CHANGED);
        } 
    if(hasRoamingOn)        
        {
            mRoamingOnRegistrants.notifyRegistrants();
        } 
    if(hasRoamingOff)        
        {
            mRoamingOffRegistrants.notifyRegistrants();
        } 
    if(hasLocationChanged)        
        {
            phone.notifyLocationChanged();
        } 
    if(! isGprsConsistent(gprsState, ss.getState()))        
        {
    if(!mStartedGprsRegCheck && !mReportedGprsNoReg)            
            {
                mStartedGprsRegCheck = true;
                int check_period = Settings.Secure.getInt(
                        phone.getContext().getContentResolver(),
                        Settings.Secure.GPRS_REGISTER_CHECK_PERIOD_MS,
                        DEFAULT_GPRS_CHECK_PERIOD_MILLIS);
                sendMessageDelayed(obtainMessage(EVENT_CHECK_REPORT_GPRS),
                        check_period);
            } 
        } 
        else
        {
            mReportedGprsNoReg = false;
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.269 -0400", hash_original_method = "FF36AACCF1BD8DBC263BCA1FAF3CB26B", hash_generated_method = "E0ED4285366072545B862DA41E281316")
    private boolean isGprsConsistent(int gprsState, int serviceState) {
        addTaint(serviceState);
        addTaint(gprsState);
        boolean var064A7DB196DAE6DE63C419EF1A1B4DD2_1976684592 = (!((serviceState == ServiceState.STATE_IN_SERVICE) &&
                (gprsState != ServiceState.STATE_IN_SERVICE)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1184954682 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1184954682;
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.269 -0400", hash_original_method = "99CED85D89C5E9DD8967FF1E935BF80B", hash_generated_method = "DEE372212AEDC147F1802DA11C949F63")
    private TimeZone getNitzTimeZone(int offset, boolean dst, long when) {
        addTaint(when);
        addTaint(dst);
        addTaint(offset);
        TimeZone guess = findTimeZone(offset, dst, when);
    if(guess == null)        
        {
            guess = findTimeZone(offset, !dst, when);
        } 
    if(DBG)        
        log("getNitzTimeZone returning " + (guess == null ? guess : guess.getID()));
TimeZone varA35CE51C1E6ED128CADF188DCC68AF4C_53507371 =         guess;
        varA35CE51C1E6ED128CADF188DCC68AF4C_53507371.addTaint(taint);
        return varA35CE51C1E6ED128CADF188DCC68AF4C_53507371;
        
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.270 -0400", hash_original_method = "950DB35A634BB86898B3E74AA5BE6013", hash_generated_method = "2A1A764FA5864BFEB8A07C4D75A06F2F")
    private TimeZone findTimeZone(int offset, boolean dst, long when) {
        addTaint(when);
        addTaint(dst);
        addTaint(offset);
        int rawOffset = offset;
    if(dst)        
        {
            rawOffset -= 3600000;
        } 
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
            } 
        } 
TimeZone varA35CE51C1E6ED128CADF188DCC68AF4C_1970651510 =         guess;
        varA35CE51C1E6ED128CADF188DCC68AF4C_1970651510.addTaint(taint);
        return varA35CE51C1E6ED128CADF188DCC68AF4C_1970651510;
        
        
        
            
        
        
        
        
        
            
            
                
                
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.271 -0400", hash_original_method = "C454880D3BFCEEC9D9AA3258CF5DFAC4", hash_generated_method = "A81797C278C3BF65AB5D07A5FD8E56AD")
    private void queueNextSignalStrengthPoll() {
    if(dontPollSignalStrength || (cm.getRadioState().isCdma()))        
        {
            return;
        } 
        Message msg;
        msg = obtainMessage();
        msg.what = EVENT_POLL_SIGNAL_STRENGTH;
        long nextTime;
        sendMessageDelayed(msg, POLL_PERIOD_MILLIS);
        
        
            
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.272 -0400", hash_original_method = "313D4989F4A5423E3CAD270FA74FCE9F", hash_generated_method = "335424F3BC3B0819809A2075A04A4AEB")
    private void onSignalStrengthResult(AsyncResult ar) {
        addTaint(ar.getTaint());
        SignalStrength oldSignalStrength = mSignalStrength;
        int rssi = 99;
        int lteSignalStrength = -1;
        int lteRsrp = -1;
        int lteRsrq = -1;
        int lteRssnr = -1;
        int lteCqi = -1;
    if(ar.exception != null)        
        {
            setSignalStrengthDefaultValues();
        } 
        else
        {
            int[] ints = (int[])ar.result;
    if(ints.length != 0)            
            {
                rssi = ints[0];
                lteSignalStrength = ints[7];
                lteRsrp = ints[8];
                lteRsrq = ints[9];
                lteRssnr = ints[10];
                lteCqi = ints[11];
            } 
            else
            {
                loge("Bogus signal strength response");
                rssi = 99;
            } 
        } 
        mSignalStrength = new SignalStrength(rssi, -1, -1, -1,
                -1, -1, -1, lteSignalStrength, lteRsrp, lteRsrq, lteRssnr, lteCqi, true);
    if(!mSignalStrength.equals(oldSignalStrength))        
        {
            try 
            {
                phone.notifySignalStrength();
            } 
            catch (NullPointerException ex)
            {
                log("onSignalStrengthResult() Phone already destroyed: " + ex
                        + "SignalStrength not notified");
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.274 -0400", hash_original_method = "F4F35E6AADE0C2C218C2CEC9E86259B9", hash_generated_method = "28EB821A759AC046ACDE147C4D566A78")
    private void onRestrictedStateChanged(AsyncResult ar) {
        addTaint(ar.getTaint());
        RestrictedState newRs = new RestrictedState();
    if(DBG)        
        log("onRestrictedStateChanged: E rs "+ mRestrictedState);
    if(ar.exception == null)        
        {
            int[] ints = (int[])ar.result;
            int state = ints[0];
            newRs.setCsEmergencyRestricted(
                    ((state & RILConstants.RIL_RESTRICTED_STATE_CS_EMERGENCY) != 0) ||
                    ((state & RILConstants.RIL_RESTRICTED_STATE_CS_ALL) != 0) );
    if(phone.getIccCard().getState() == IccCard.State.READY)            
            {
                newRs.setCsNormalRestricted(
                        ((state & RILConstants.RIL_RESTRICTED_STATE_CS_NORMAL) != 0) ||
                        ((state & RILConstants.RIL_RESTRICTED_STATE_CS_ALL) != 0) );
                newRs.setPsRestricted(
                        (state & RILConstants.RIL_RESTRICTED_STATE_PS_ALL)!= 0);
            } 
    if(DBG)            
            log("onRestrictedStateChanged: new rs "+ newRs);
    if(!mRestrictedState.isPsRestricted() && newRs.isPsRestricted())            
            {
                mPsRestrictEnabledRegistrants.notifyRegistrants();
                setNotification(PS_ENABLED);
            } 
            else
    if(mRestrictedState.isPsRestricted() && !newRs.isPsRestricted())            
            {
                mPsRestrictDisabledRegistrants.notifyRegistrants();
                setNotification(PS_DISABLED);
            } 
    if(mRestrictedState.isCsRestricted())            
            {
    if(!newRs.isCsRestricted())                
                {
                    setNotification(CS_DISABLED);
                } 
                else
    if(!newRs.isCsNormalRestricted())                
                {
                    setNotification(CS_EMERGENCY_ENABLED);
                } 
                else
    if(!newRs.isCsEmergencyRestricted())                
                {
                    setNotification(CS_NORMAL_ENABLED);
                } 
            } 
            else
    if(mRestrictedState.isCsEmergencyRestricted() &&
                    !mRestrictedState.isCsNormalRestricted())            
            {
    if(!newRs.isCsRestricted())                
                {
                    setNotification(CS_DISABLED);
                } 
                else
    if(newRs.isCsRestricted())                
                {
                    setNotification(CS_ENABLED);
                } 
                else
    if(newRs.isCsNormalRestricted())                
                {
                    setNotification(CS_NORMAL_ENABLED);
                } 
            } 
            else
    if(!mRestrictedState.isCsEmergencyRestricted() &&
                    mRestrictedState.isCsNormalRestricted())            
            {
    if(!newRs.isCsRestricted())                
                {
                    setNotification(CS_DISABLED);
                } 
                else
    if(newRs.isCsRestricted())                
                {
                    setNotification(CS_ENABLED);
                } 
                else
    if(newRs.isCsEmergencyRestricted())                
                {
                    setNotification(CS_EMERGENCY_ENABLED);
                } 
            } 
            else
            {
    if(newRs.isCsRestricted())                
                {
                    setNotification(CS_ENABLED);
                } 
                else
    if(newRs.isCsEmergencyRestricted())                
                {
                    setNotification(CS_EMERGENCY_ENABLED);
                } 
                else
    if(newRs.isCsNormalRestricted())                
                {
                    setNotification(CS_NORMAL_ENABLED);
                } 
            } 
            mRestrictedState = newRs;
        } 
        log("onRestrictedStateChanged: X rs "+ mRestrictedState);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.275 -0400", hash_original_method = "224D5C409E7F86CE5414891CFB70A981", hash_generated_method = "5221ADB28F9553A91F6B568E9F097D96")
    private int regCodeToServiceState(int code) {
        addTaint(code);
switch(code){
        case 0:
        case 2:
        case 3:
        case 4:
        case 10:
        case 12:
        case 13:
        case 14:
        int var71E69F293A199F4F0590F716ED221A1D_1962815674 = (ServiceState.STATE_OUT_OF_SERVICE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2017660088 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2017660088;
        case 1:
        int varC8CBA89C9D33ADF2399F2C790EB21113_725160197 = (ServiceState.STATE_IN_SERVICE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_571801814 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_571801814;
        case 5:
        int varC8CBA89C9D33ADF2399F2C790EB21113_386208980 = (ServiceState.STATE_IN_SERVICE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1354225758 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1354225758;
        default:
        loge("regCodeToServiceState: unexpected service state " + code);
        int var71E69F293A199F4F0590F716ED221A1D_1301537859 = (ServiceState.STATE_OUT_OF_SERVICE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1104108936 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1104108936;
}
        
        
            
            
            
            
            
            
            
            
                
            
                
            
                
            
                
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.276 -0400", hash_original_method = "19036A7D1DADA943DC912DAB6396B9AD", hash_generated_method = "8019EE73A8BCE3F8921542820D2183B2")
    private boolean regCodeIsRoaming(int code) {
        addTaint(code);
        boolean var9BC16EB4B57D49EAF3C5553D2A5A7562_1812017239 = (5 == code);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1591312970 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1591312970;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.276 -0400", hash_original_method = "A83CC5F0F34C62E2D3BC7866CECAC756", hash_generated_method = "9851725ADB116B064D7FA4AC67B75131")
    private boolean isRoamingBetweenOperators(boolean gsmRoaming, ServiceState s) {
        addTaint(s.getTaint());
        addTaint(gsmRoaming);
        String spn = SystemProperties.get(TelephonyProperties.PROPERTY_ICC_OPERATOR_ALPHA, "empty");
        String onsl = s.getOperatorAlphaLong();
        String onss = s.getOperatorAlphaShort();
        boolean equalsOnsl = onsl != null && spn.equals(onsl);
        boolean equalsOnss = onss != null && spn.equals(onss);
        String simNumeric = SystemProperties.get(
                TelephonyProperties.PROPERTY_ICC_OPERATOR_NUMERIC, "");
        String operatorNumeric = s.getOperatorNumeric();
        boolean equalsMcc = true;
        try 
        {
            equalsMcc = simNumeric.substring(0, 3).
                    equals(operatorNumeric.substring(0, 3));
        } 
        catch (Exception e)
        {
        } 
        boolean varA5D48A73A95542B1E929FEBE3FF47945_1538463119 = (gsmRoaming && !(equalsMcc && (equalsOnsl || equalsOnss)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1743423803 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1743423803;
        
        
        
        
        
        
        
                
        
        
        
            
                    
        
        
        
    }

    
        @DSModeled(DSC.BAN)
    private static int twoDigitsAt(String s, int offset) {
        int a, b;
        a = Character.digit(s.charAt(offset), 10);
        b = Character.digit(s.charAt(offset+1), 10);
        if (a < 0 || b < 0) {
            throw new RuntimeException("invalid format");
        }
        return a*10 + b;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.277 -0400", hash_original_method = "462522C9E25E239E090C32F4DC1CCDBD", hash_generated_method = "6D40461D2ABE4E5264E6B28B49BE9DE5")
     int getCurrentGprsState() {
        int varAE002CCACEDC16E1ADAE58BCD2D9B837_326522190 = (gprsState);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_811725376 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_811725376;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.277 -0400", hash_original_method = "76A0DFDE7E82168261B9485993735FA8", hash_generated_method = "48710503F3C4D9A599FAC1FA827EFB19")
    public int getCurrentDataConnectionState() {
        int varAE002CCACEDC16E1ADAE58BCD2D9B837_1432636318 = (gprsState);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_255532666 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_255532666;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.277 -0400", hash_original_method = "35025CCE5222CF7AFA718FFADECE80EF", hash_generated_method = "676CFBEA4B16809AACEEA2BCC9B90D91")
    public boolean isConcurrentVoiceAndDataAllowed() {
        boolean var10896807F1D0D24F85768ECF425B98D6_2065247344 = ((mRadioTechnology >= ServiceState.RADIO_TECHNOLOGY_UMTS));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_247740612 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_247740612;
        
        
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.280 -0400", hash_original_method = "D8515350C34B3E7CC6A83CEBE4C1FE6C", hash_generated_method = "BF98506DF60295183DE892B5DAD82D9E")
    private void setTimeFromNITZString(String nitz, long nitzReceiveTime) {
        addTaint(nitzReceiveTime);
        addTaint(nitz.getTaint());
        long start = SystemClock.elapsedRealtime();
    if(DBG)        
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
            int dst = (nitzSubs.length >= 8 ) ? Integer.parseInt(nitzSubs[7])
                                              : 0;
            tzOffset = (sign ? 1 : -1) * tzOffset * 15 * 60 * 1000;
            TimeZone zone = null;
    if(nitzSubs.length >= 9)            
            {
                String tzname = nitzSubs[8].replace('!','/');
                zone = TimeZone.getTimeZone( tzname );
            } 
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
                    } 
                    else
                    {
                        zone = getNitzTimeZone(tzOffset, (dst != 0), c.getTimeInMillis());
                    } 
                } 
            } 
    if(zone == null)            
            {
                mNeedFixZone = true;
                mZoneOffset  = tzOffset;
                mZoneDst     = dst != 0;
                mZoneTime    = c.getTimeInMillis();
            } 
    if(zone != null)            
            {
    if(getAutoTimeZone())                
                {
                    setAndBroadcastNetworkSetTimeZone(zone.getID());
                } 
                saveNitzTimeZone(zone.getID());
            } 
            String ignore = SystemProperties.get("gsm.ignore-nitz");
    if(ignore != null && ignore.equals("yes"))            
            {
                log("NITZ: Not setting clock because gsm.ignore-nitz is set");
                return;
            } 
            try 
            {
                mWakeLock.acquire();
    if(getAutoTime())                
                {
                    long millisSinceNitzReceived = SystemClock.elapsedRealtime() - nitzReceiveTime;
    if(millisSinceNitzReceived < 0)                    
                    {
    if(DBG)                        
                        {
                            log("NITZ: not setting time, clock has rolled "
                                            + "backwards since NITZ time was received, "
                                            + nitz);
                        } 
                        return;
                    } 
    if(millisSinceNitzReceived > Integer.MAX_VALUE)                    
                    {
    if(DBG)                        
                        {
                            log("NITZ: not setting time, processing has taken "
                                        + (millisSinceNitzReceived / (1000 * 60 * 60 * 24))
                                        + " days");
                        } 
                        return;
                    } 
                    c.add(Calendar.MILLISECOND, (int)millisSinceNitzReceived);
    if(DBG)                    
                    {
                        log("NITZ: Setting time of day to " + c.getTime()
                            + " NITZ receive delay(ms): " + millisSinceNitzReceived
                            + " gained(ms): "
                            + (c.getTimeInMillis() - System.currentTimeMillis())
                            + " from " + nitz);
                    } 
                    setAndBroadcastNetworkSetTime(c.getTimeInMillis());
                } 
                SystemProperties.set("gsm.nitz.time", String.valueOf(c.getTimeInMillis()));
                saveNitzTime(c.getTimeInMillis());
    if(false)                
                {
                    long end = SystemClock.elapsedRealtime();
                    log("NITZ: end=" + end + " dur=" + (end - start));
                } 
            } 
            finally 
            {
                mWakeLock.release();
            } 
        } 
        catch (RuntimeException ex)
        {
            loge("NITZ: Parsing NITZ time " + nitz + " ex=" + ex);
        } 
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.281 -0400", hash_original_method = "10C2AC47FB9B2FA38284A276FBC39461", hash_generated_method = "F085EE31F48FD7A0B4D2F4DFBA12024C")
    private boolean getAutoTime() {
        try 
        {
            boolean var23666C841658CCF993821D103DA1B99B_2022428974 = (Settings.System.getInt(phone.getContext().getContentResolver(),
                    Settings.System.AUTO_TIME) > 0);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1084463138 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1084463138;
        } 
        catch (SettingNotFoundException snfe)
        {
            boolean varB326B5062B2F0E69046810717534CB09_82130324 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_935491170 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_935491170;
        } 
        
        
            
                    
        
            
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.281 -0400", hash_original_method = "46367736BD7DFDD485A94174DBA3ECD3", hash_generated_method = "7BE559B06DD6591F9B7060AB89B75258")
    private boolean getAutoTimeZone() {
        try 
        {
            boolean var67F2942DBB30A12A5915AD3396DFFCDF_1623664209 = (Settings.System.getInt(phone.getContext().getContentResolver(),
                    Settings.System.AUTO_TIME_ZONE) > 0);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_905742229 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_905742229;
        } 
        catch (SettingNotFoundException snfe)
        {
            boolean varB326B5062B2F0E69046810717534CB09_662681539 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_22091138 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_22091138;
        } 
        
        
            
                    
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.282 -0400", hash_original_method = "AC4D6B705E7065D39BD6B0621414F077", hash_generated_method = "89E6488BB9B703C7CA9BBABF73A30618")
    private void saveNitzTimeZone(String zoneId) {
        mSavedTimeZone = zoneId;
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.282 -0400", hash_original_method = "BBC081DF5E9AA5E0F675E4C4D97D41FA", hash_generated_method = "FA812F2463447E256E093AB70BACE34A")
    private void saveNitzTime(long time) {
        mSavedTime = time;
        mSavedAtTime = SystemClock.elapsedRealtime();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.283 -0400", hash_original_method = "28A8B5328B033F98ED5E62B240AD20B6", hash_generated_method = "984A6F220FA299B6040E2A27C2DE4419")
    private void setAndBroadcastNetworkSetTimeZone(String zoneId) {
        addTaint(zoneId.getTaint());
        AlarmManager alarm = (AlarmManager) phone.getContext().getSystemService(Context.ALARM_SERVICE);
        alarm.setTimeZone(zoneId);
        Intent intent = new Intent(TelephonyIntents.ACTION_NETWORK_SET_TIMEZONE);
        intent.addFlags(Intent.FLAG_RECEIVER_REPLACE_PENDING);
        intent.putExtra("time-zone", zoneId);
        phone.getContext().sendStickyBroadcast(intent);
        
        
            
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.283 -0400", hash_original_method = "062E38B571EEA7E979075562F8B40A5D", hash_generated_method = "5F6CE596255AD73B6FA27FE77554A384")
    private void setAndBroadcastNetworkSetTime(long time) {
        addTaint(time);
        SystemClock.setCurrentTimeMillis(time);
        Intent intent = new Intent(TelephonyIntents.ACTION_NETWORK_SET_TIME);
        intent.addFlags(Intent.FLAG_RECEIVER_REPLACE_PENDING);
        intent.putExtra("time", time);
        phone.getContext().sendStickyBroadcast(intent);
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.284 -0400", hash_original_method = "2770201C4A137564A500CEEFB3D4E467", hash_generated_method = "5BADBCC49182FF711778A01027AE3216")
    private void revertToNitzTime() {
    if(Settings.System.getInt(phone.getContext().getContentResolver(),
                Settings.System.AUTO_TIME, 0) == 0)        
        {
            return;
        } 
    if(DBG)        
        {
            log("Reverting to NITZ Time: mSavedTime=" + mSavedTime
                + " mSavedAtTime=" + mSavedAtTime);
        } 
    if(mSavedTime != 0 && mSavedAtTime != 0)        
        {
            setAndBroadcastNetworkSetTime(mSavedTime
                    + (SystemClock.elapsedRealtime() - mSavedAtTime));
        } 
        
        
                
            
        
        
            
                
        
        
            
                    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.284 -0400", hash_original_method = "846FA792EAB8BB56C921A6228BC9EB73", hash_generated_method = "B09F98EA2BB5CD5FB4D0F420DE98A6B4")
    private void revertToNitzTimeZone() {
    if(Settings.System.getInt(phone.getContext().getContentResolver(),
                Settings.System.AUTO_TIME_ZONE, 0) == 0)        
        {
            return;
        } 
    if(DBG)        
        log("Reverting to NITZ TimeZone: tz='" + mSavedTimeZone);
    if(mSavedTimeZone != null)        
        {
            setAndBroadcastNetworkSetTimeZone(mSavedTimeZone);
        } 
        
        
                
            
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.286 -0400", hash_original_method = "90EFCD7762032B11006E493EA631CF1F", hash_generated_method = "D78259CB3733203062F28383224859A4")
    private void setNotification(int notifyType) {
        addTaint(notifyType);
    if(DBG)        
        log("setNotification: create notification " + notifyType);
        Context context = phone.getContext();
        mNotification = new Notification();
        mNotification.when = System.currentTimeMillis();
        mNotification.flags = Notification.FLAG_AUTO_CANCEL;
        mNotification.icon = com.android.internal.R.drawable.stat_sys_warning;
        Intent intent = new Intent();
        mNotification.contentIntent = PendingIntent
        .getActivity(context, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        CharSequence details = "";
        CharSequence title = context.getText(com.android.internal.R.string.RestrictedChangedTitle);
        int notificationId = CS_NOTIFICATION;
switch(notifyType){
        case PS_ENABLED:
        notificationId = PS_NOTIFICATION;
        details = context.getText(com.android.internal.R.string.RestrictedOnData);
        ;
        break;
        case PS_DISABLED:
        notificationId = PS_NOTIFICATION;
        break;
        case CS_ENABLED:
        details = context.getText(com.android.internal.R.string.RestrictedOnAllVoice);
        ;
        break;
        case CS_NORMAL_ENABLED:
        details = context.getText(com.android.internal.R.string.RestrictedOnNormal);
        ;
        break;
        case CS_EMERGENCY_ENABLED:
        details = context.getText(com.android.internal.R.string.RestrictedOnEmergency);
        ;
        break;
        case CS_DISABLED:
        break;
}    if(DBG)        
        log("setNotification: put notification " + title + " / " +details);
        mNotification.tickerText = title;
        mNotification.setLatestEventInfo(context, title, details,
                mNotification.contentIntent);
        NotificationManager notificationManager = (NotificationManager)
            context.getSystemService(Context.NOTIFICATION_SERVICE);
    if(notifyType == PS_DISABLED || notifyType == CS_DISABLED)        
        {
            notificationManager.cancel(notificationId);
        } 
        else
        {
            notificationManager.notify(notificationId, mNotification);
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.287 -0400", hash_original_method = "4109BBDDE3BB927415F4177275F054A2", hash_generated_method = "0C024BC85B4018640CE69C4B1B93B00C")
    @Override
    protected void log(String s) {
        addTaint(s.getTaint());
        Log.d(LOG_TAG, "[GsmSST] " + s);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.287 -0400", hash_original_method = "E8A9D45B999B20E24B18F0E2F50C667F", hash_generated_method = "5D4ED3A9E70D2AABB538EA7C903DDA44")
    @Override
    protected void loge(String s) {
        addTaint(s.getTaint());
        
        
    }

    
        private static void sloge(String s) {
        Log.e(LOG_TAG, "[GsmSST] " + s);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.287 -0400", hash_original_field = "41EBE7F32B96C1E2E9C209710486A443", hash_generated_field = "B8386CD6D900777C9D6A0A5CA1D0B217")

    static final String LOG_TAG = "GSM";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.287 -0400", hash_original_field = "A4622F7F72162611C8E075EE443BC26E", hash_generated_field = "3860CF443CF1EC2A1FAD1F55FBF8A7F5")

    static final boolean DBG = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.287 -0400", hash_original_field = "8AA5488317F9A54E56045D1AAF74BB75", hash_generated_field = "3E784668308EA1C4770734C39504B13F")

    private static final String WAKELOCK_TAG = "ServiceStateTracker";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.287 -0400", hash_original_field = "78DBFEDA4D4BF3B7443050756EB706DA", hash_generated_field = "4A5D9F03FAE9E50AE63B4C35022FAF17")

    static final int DEFAULT_GPRS_CHECK_PERIOD_MILLIS = 60 * 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.288 -0400", hash_original_field = "0EDCF36F1C7515917C6C8C6960C44E94", hash_generated_field = "3591FCEB08077E36696EAEB77DBB3180")

    static final int PS_ENABLED = 1001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.288 -0400", hash_original_field = "74ECF90DF353CA07A72C88F6756E63FD", hash_generated_field = "8C26EED9E7268BEDBBAF04F084560166")

    static final int PS_DISABLED = 1002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.288 -0400", hash_original_field = "B3D8643D85377D116361C3F5C8140E0B", hash_generated_field = "B2781F5CE66230CC973402FB9B2889B2")

    static final int CS_ENABLED = 1003;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.288 -0400", hash_original_field = "AE9874F242E8D117F7BAE3E010B557AB", hash_generated_field = "D51C56159F181C83643165D845D52483")

    static final int CS_DISABLED = 1004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.288 -0400", hash_original_field = "8B193C5B10382A1D1FD53AB21D3BD2E3", hash_generated_field = "C31DA0EA8EA157BEB2FE7CB33DF402A6")

    static final int CS_NORMAL_ENABLED = 1005;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.288 -0400", hash_original_field = "EEF6FD506D2FA8B090021A1D296EDD7B", hash_generated_field = "F9B78C4A6E79981FE3F71480BC07396C")

    static final int CS_EMERGENCY_ENABLED = 1006;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.288 -0400", hash_original_field = "ED6B67AB4D0B4DF3C237651AC21D2816", hash_generated_field = "798CDAD9FDD0BFCBF4723E408D009540")

    static final int PS_NOTIFICATION = 888;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.288 -0400", hash_original_field = "97AFCBF220761A84FA450E75A3CE004D", hash_generated_field = "EBBCDE09A71FA16B42C4199ACB2E765C")

    static final int CS_NOTIFICATION = 999;
}

