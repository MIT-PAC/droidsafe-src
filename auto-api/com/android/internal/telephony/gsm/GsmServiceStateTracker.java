package com.android.internal.telephony.gsm;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.696 -0400", hash_original_field = "F7A42FE7211F98AC7A60A285AC3A9E87", hash_generated_field = "690DC9441FA6BD04E0472B4DF9E035F8")

    GSMPhone phone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.696 -0400", hash_original_field = "B9C5653E1C2BC689F2CC98D72803F0E0", hash_generated_field = "6501E6CCC6A627167D828A01CEBF7711")

    GsmCellLocation cellLoc;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.696 -0400", hash_original_field = "B325523B8771CAA3A7FB54CA6901D43A", hash_generated_field = "B261F7AD66455AA0C3F3A08229915B3D")

    GsmCellLocation newCellLoc;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.696 -0400", hash_original_field = "5E797CD98A6F48EA74102A194ABE8414", hash_generated_field = "5BA84AC7CBE58E4EDB6614D7B15D6E0E")

    int mPreferredNetworkType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.696 -0400", hash_original_field = "09ADCB4D8E411083650BF094C0F5A282", hash_generated_field = "07B777CC7BF8F0F7679AC97DE6B0C153")

    private int gprsState = ServiceState.STATE_OUT_OF_SERVICE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.696 -0400", hash_original_field = "3DD74F5CB43F87ECACC4768DBADF0137", hash_generated_field = "7035A3B0948B79A30C2C00DECE9F4570")

    private int newGPRSState = ServiceState.STATE_OUT_OF_SERVICE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.696 -0400", hash_original_field = "2AFEACA217B557D16E803474269AC334", hash_generated_field = "5F1A31BADD427D5DFCB23ECFD73B8B95")

    private int mMaxDataCalls = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.696 -0400", hash_original_field = "E93FE6CD696F5691F32A4C7A9078BA63", hash_generated_field = "D1E578B67E4CC593BE870B60F03AA83C")

    private int mNewMaxDataCalls = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.696 -0400", hash_original_field = "A834835F3CEDAC8AC7E64228C76E5077", hash_generated_field = "981E84B4948A11F540AE3C83118D725F")

    private int mReasonDataDenied = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.696 -0400", hash_original_field = "D821D524FB7806A8991C807AE4CA7635", hash_generated_field = "3DCB78EC6066191396204C4D07EB7548")

    private int mNewReasonDataDenied = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.696 -0400", hash_original_field = "9380C85BAA057C151A0AF0A172BD132A", hash_generated_field = "0E48791EFF44078585E96EA7C7ED6E26")

    private boolean mGsmRoaming = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.696 -0400", hash_original_field = "BD02E473C1C27AC87C52110872C4EBF8", hash_generated_field = "4F72E8DCBAFD6C5A4FC303F5B439CC14")

    private boolean mDataRoaming = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.696 -0400", hash_original_field = "85105C0E76607ED02FD2FDEB8B0B0D87", hash_generated_field = "A81A887211F7F6A8BF5C317C7E4646E5")

    private boolean mEmergencyOnly = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.696 -0400", hash_original_field = "28BAF9CE3F67CB31A5C7E4A1C64709A2", hash_generated_field = "2D2C0A8AA7022D57AB24C477C9212676")

    private boolean mNeedFixZone = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.696 -0400", hash_original_field = "F22170EE4512552F24101CBB42D416D7", hash_generated_field = "C126894205DFD14FA38D307801001C6F")

    private int mZoneOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.696 -0400", hash_original_field = "C93085FA426E2C8BDD28EDA54293198A", hash_generated_field = "63800483D80F5CB684E683BC24E0A820")

    private boolean mZoneDst;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.696 -0400", hash_original_field = "0A09D50B767A402C68BB8923B251B081", hash_generated_field = "7498B22AB24D6B5E081FF2DDE0FD21C8")

    private long mZoneTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.696 -0400", hash_original_field = "91657A67842D433756013CCE7BEFC8EA", hash_generated_field = "C304726703E30667C2FAD4B6BFDDEB63")

    private boolean mGotCountryCode = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.696 -0400", hash_original_field = "324D8A1D3F81E730D5099A48CEE0C5B6", hash_generated_field = "CC964D293F1703643DB273FCC0901562")

    private ContentResolver cr;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.696 -0400", hash_original_field = "629AB99995100B7F6B737671E7028A77", hash_generated_field = "30A17FCDED9983DC17E4B0241936D019")

    String mSavedTimeZone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.696 -0400", hash_original_field = "0870ED367B81A3D199CC36F4FF58F6E3", hash_generated_field = "56DFA99AB6C2048EFF6A2B28FFEF5620")

    long mSavedTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.696 -0400", hash_original_field = "E11E42BBA30EA79639217C987535FA76", hash_generated_field = "2B2B2F1D0E3CAC70A6D7541E3BA2D300")

    long mSavedAtTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.696 -0400", hash_original_field = "794B9E75544086325155A72AA171A32E", hash_generated_field = "1929EEEAE2485E3C7781EBAA0F354C99")

    private boolean mNeedToRegForSimLoaded;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.696 -0400", hash_original_field = "8845867B8D05D961286A1A19CE10D2DC", hash_generated_field = "EA9A1384C97DE38DCF8B990AF3F83712")

    private boolean mStartedGprsRegCheck = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.696 -0400", hash_original_field = "D7F7DA1A823510EF7DFA18A7D3740A12", hash_generated_field = "69E634E61A627800AF487B771D6ECAD0")

    private boolean mReportedGprsNoReg = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.696 -0400", hash_original_field = "FA180D1FC40F4514789E94C434050443", hash_generated_field = "74FBA8E8F4402404F407A6E0DBC8943E")

    private Notification mNotification;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.696 -0400", hash_original_field = "69E45E7E240C011D8CB3CFDE90D76B33", hash_generated_field = "C0FF63B0998195CF037A71BFC5C5B113")

    private PowerManager.WakeLock mWakeLock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.696 -0400", hash_original_field = "438E769CBE3194E31EE3583D475755E2", hash_generated_field = "D741E5B3B277519D91E4FE02D3FAFF01")

    private String curSpn = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.696 -0400", hash_original_field = "8F0345704253C4ABC1429588E7767D95", hash_generated_field = "9047898EE9FB6E0F59121E370CC3C8CF")

    private String curPlmn = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.696 -0400", hash_original_field = "980A06D55B7D1D17AD8917BD8B3AD170", hash_generated_field = "E51B211F12EB3D4199E57F38674CC690")

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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.698 -0400", hash_original_method = "89B681C68F2C3DCA55179D15C34AC4AC", hash_generated_method = "3674E78DB0738469C53C072BA81027AE")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.699 -0400", hash_original_method = "D8900B5121A238BBC317864D0A18F1DD", hash_generated_method = "B40ED7CB9364FAE6479A4D45B656DCB0")
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.699 -0400", hash_original_method = "6FB50CEA8307C4B6093E637FBC3F2923", hash_generated_method = "61ECE0E646E8B1764F5B7DA5FA912912")
    protected void finalize() {
        log("finalize");
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.700 -0400", hash_original_method = "A0DE0F5E4F4D4787509D60C270D17835", hash_generated_method = "D99C06D5F30F658E1214C17505D5A577")
    @Override
    protected Phone getPhone() {
        Phone varB4EAC82CA7396A68D541C85D26508E83_1448557869 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1448557869 = phone;
        varB4EAC82CA7396A68D541C85D26508E83_1448557869.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1448557869;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.701 -0400", hash_original_method = "8D6E3CD042747DF0CD652F21C9ED2A0B", hash_generated_method = "5BA5D66EFBDA4EE5A2AE1113CAE162B1")
    public void handleMessage(Message msg) {
        AsyncResult ar;
        int[] ints;
        String[] strings;
        Message message;
        
        cm.setCurrentPreferredNetworkType();
        
        
        {
            phone.mIccRecords.registerForRecordsLoaded(this,
                            EVENT_SIM_RECORDS_LOADED, null);
            mNeedToRegForSimLoaded = false;
        } 
        
        
        boolean skipRestoringSelection = phone.getContext().getResources().getBoolean(
                        com.android.internal.R.bool.skip_restoring_network_selection);
        
        
        {
            phone.restoreSavedNetworkSelection(null);
        } 
        
        
        pollState();
        
        
        queueNextSignalStrengthPoll();
        
        
        setPowerStateToDesired();
        
        
        pollState();
        
        
        pollState();
        
        
        {
            boolean var073B81928925E9A842A5B7D6E127E98B_2137893404 = (!(cm.getRadioState().isOn()) || (cm.getRadioState().isCdma()));
        } 
        
        
        ar = (AsyncResult) msg.obj;
        
        
        onSignalStrengthResult(ar);
        
        
        queueNextSignalStrengthPoll();
        
        
        ar = (AsyncResult) msg.obj;
        
        
        {
            String states[] = (String[])ar.result;
            int lac = -1;
            int cid = -1;
            {
                try 
                {
                    {
                        boolean var9D5A64E58810D558AB453A876F76F10A_754685017 = (states[1] != null && states[1].length() > 0);
                        {
                            lac = Integer.parseInt(states[1], 16);
                        } 
                    } 
                    {
                        boolean varE1384D31A474A975FC250415D1CF0A98_362245478 = (states[2] != null && states[2].length() > 0);
                        {
                            cid = Integer.parseInt(states[2], 16);
                        } 
                    } 
                } 
                catch (NumberFormatException ex)
                { }
            } 
            cellLoc.setLacAndCid(lac, cid);
            phone.notifyLocationChanged();
        } 
        
        
        disableSingleLocationUpdate();
        
        
        ar = (AsyncResult) msg.obj;
        
        
        handlePollStateResult(msg.what, ar);
        
        
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
            cm.getVoiceRegistrationState(obtainMessage(EVENT_GET_LOC_DONE, null));
        } 
        
        
        ar = (AsyncResult) msg.obj;
        
        
        message = obtainMessage(EVENT_RESET_PREFERRED_NETWORK_TYPE, ar.userObj);
        
        
        cm.setPreferredNetworkType(mPreferredNetworkType, message);
        
        
        ar = (AsyncResult) msg.obj;
        
        
        {
            AsyncResult.forMessage(((Message) ar.userObj)).exception
                            = ar.exception;
            ((Message) ar.userObj).sendToTarget();
        } 
        
        
        ar = (AsyncResult) msg.obj;
        
        
        {
            mPreferredNetworkType = ((int[])ar.result)[0];
        } 
        {
            mPreferredNetworkType = RILConstants.NETWORK_MODE_GLOBAL;
        } 
        
        
        message = obtainMessage(EVENT_SET_PREFERRED_NETWORK_TYPE, ar.userObj);
        
        
        int toggledNetworkType = RILConstants.NETWORK_MODE_GLOBAL;
        
        
        cm.setPreferredNetworkType(toggledNetworkType, message);
        
        
        {
            boolean varFC20FFEE0B571214859D080B805B15AB_1292449572 = (ss != null && !isGprsConsistent(gprsState, ss.getState()));
            {
                GsmCellLocation loc = ((GsmCellLocation)phone.getCellLocation());
                EventLog.writeEvent(EventLogTags.DATA_NETWORK_REGISTRATION_FAIL,
                            ss.getOperatorNumeric(), loc != null ? loc.getCid() : -1);
                mReportedGprsNoReg = true;
            } 
        } 
        
        
        mStartedGprsRegCheck = false;
        
        
        log("EVENT_RESTRICTED_STATE_CHANGED");
        
        
        ar = (AsyncResult) msg.obj;
        
        
        onRestrictedStateChanged(ar);
        
        
        super.handleMessage(msg);
        
        addTaint(msg.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.702 -0400", hash_original_method = "BC2E3346E1E8D048BB892FC104E776BC", hash_generated_method = "F84B4BA0851574705AB50FAAE193E301")
    protected void setPowerStateToDesired() {
        {
            boolean var132800EA641B7653EC59634384D41AC8_914055048 = (mDesiredPowerState
            && cm.getRadioState() == CommandsInterface.RadioState.RADIO_OFF);
            {
                cm.setRadioPower(true, null);
            } 
            {
                boolean var9EF9CD1D5966856073F2A7E801160763_940041191 = (!mDesiredPowerState && cm.getRadioState().isOn());
                {
                    DataConnectionTracker dcTracker = phone.mDataConnectionTracker;
                    powerOffRadioSafely(dcTracker);
                } 
            } 
        } 
        
        
            
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.702 -0400", hash_original_method = "E3C7A91B3D91C3ACB7BE5D936C3A4029", hash_generated_method = "BFB54E2E64E1425F33844B574EC0F4D1")
    @Override
    protected void hangupAndPowerOff() {
        {
            boolean varC2DAA1612218A41C583800F71FEEEFE0_73411127 = (phone.isInCall());
            {
                phone.mCT.ringingCall.hangupIfAlive();
                phone.mCT.backgroundCall.hangupIfAlive();
                phone.mCT.foregroundCall.hangupIfAlive();
            } 
        } 
        cm.setRadioPower(false, null);
        
        
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.703 -0400", hash_original_method = "12AE11DB9489E0514D18AAE66522FB76", hash_generated_method = "F930CCAF31C6F2DA62F0A5830CE8C8E0")
    protected void updateSpnDisplay() {
        int rule = phone.mIccRecords.getDisplayRule(ss.getOperatorNumeric());
        String spn = phone.mIccRecords.getServiceProviderName();
        String plmn = ss.getOperatorAlphaLong();
        {
            boolean var06D0886726202C33A42C3319B2FBCFA6_1401008751 = (mEmergencyOnly && cm.getRadioState().isOn());
            {
                plmn = Resources.getSystem().
                getText(com.android.internal.R.string.emergency_calls_only).toString();
                log("updateSpnDisplay: emergency only and radio is on plmn='" + plmn + "'");
            } 
        } 
        {
            boolean varBB23ADBA0F49FDA2EE72E8A6C8D8F6D8_1437108076 = (rule != curSpnRule
                || !TextUtils.equals(spn, curSpn)
                || !TextUtils.equals(plmn, curPlmn));
            {
                boolean showSpn = !mEmergencyOnly && !TextUtils.isEmpty(spn)
                && (rule & SIMRecords.SPN_RULE_SHOW_SPN) == SIMRecords.SPN_RULE_SHOW_SPN;
                boolean showPlmn = !TextUtils.isEmpty(plmn) &&
                (rule & SIMRecords.SPN_RULE_SHOW_PLMN) == SIMRecords.SPN_RULE_SHOW_PLMN;
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
        } 
        curSpnRule = rule;
        curSpn = spn;
        curPlmn = plmn;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.704 -0400", hash_original_method = "715C325B720DBA72DF5B4684F1B692D5", hash_generated_method = "C824729C72AFD27E13E93F01D07736E7")
    protected void handlePollStateResult(int what, AsyncResult ar) {
        int ints[];
        String states[];
        {
            CommandException.Error err = null;
            {
                err = ((CommandException)(ar.exception)).getCommandError();
            } 
            {
                cancelPollState();
            } 
            {
                boolean var0F541275CA306A5F1AC77D786FD54CFD_1587094310 = (!cm.getRadioState().isOn());
                {
                    cancelPollState();
                } 
            } 
            {
                loge("RIL implementation has returned an error where it must succeed" +
                        ar.exception);
            } 
        } 
        try 
        {
            
            states = (String[])ar.result;
            
            
            int lac = -1;
            
            
            int cid = -1;
            
            
            int regState = -1;
            
            
            int reasonRegStateDenied = -1;
            
            
            int psc = -1;
            
            
            {
                try 
                {
                    regState = Integer.parseInt(states[0]);
                    {
                        {
                            boolean varC8FB6E238E31780D1F2471C052768A12_850570997 = (states[1] != null && states[1].length() > 0);
                            {
                                lac = Integer.parseInt(states[1], 16);
                            } 
                        } 
                        {
                            boolean var8EA46D418EFE8869C53A8FFB1B763349_2018226944 = (states[2] != null && states[2].length() > 0);
                            {
                                cid = Integer.parseInt(states[2], 16);
                            } 
                        } 
                    } 
                    {
                        {
                            boolean var4770B9A59F4D2AA52CA9C0062D193D69_931013030 = (states[14] != null && states[14].length() > 0);
                            {
                                psc = Integer.parseInt(states[14], 16);
                            } 
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
            
            
            {
                mEmergencyOnly = true;
            } 
            {
                mEmergencyOnly = false;
            } 
            
            
            newCellLoc.setLacAndCid(lac, cid);
            
            
            newCellLoc.setPsc(psc);
            
            
            states = (String[])ar.result;
            
            
            int type = 0;
            
            
            regState = -1;
            
            
            mNewReasonDataDenied = -1;
            
            
            mNewMaxDataCalls = 1;
            
            
            {
                try 
                {
                    regState = Integer.parseInt(states[0]);
                    {
                        type = Integer.parseInt(states[3]);
                    } 
                    {
                        mNewReasonDataDenied = Integer.parseInt(states[4]);
                    } 
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
            
            
            String opNames[] = (String[])ar.result;
            
            
            {
                newSS.setOperatorName (
                                opNames[0], opNames[1], opNames[2]);
            } 
            
            
            ints = (int[])ar.result;
            
            
            newSS.setIsManualSelection(ints[0] == 1);
            
        } 
        catch (RuntimeException ex)
        {
            loge("Exception while polling service state. Probably malformed RIL response." + ex);
        } 
        {
            boolean roaming = (mGsmRoaming || mDataRoaming);
            {
                boolean varAD836B3792BA6824B78D98F7D142DE65_74428281 = (mGsmRoaming && !isRoamingBetweenOperators(mGsmRoaming, newSS));
                {
                    roaming = false;
                } 
            } 
            newSS.setRoaming(roaming);
            newSS.setEmergencyOnly(mEmergencyOnly);
            pollStateDone();
        } 
        addTaint(what);
        addTaint(ar.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.705 -0400", hash_original_method = "76DE4C6A99E85827FF76DDCBD0A680F0", hash_generated_method = "FB6F947C716BD93C04B4BB847C77356E")
    private void setSignalStrengthDefaultValues() {
        mSignalStrength = new SignalStrength(99, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, true);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.706 -0400", hash_original_method = "4A9AA9B5E92E73D941CD4914D7782EA3", hash_generated_method = "B6BDD691BA8B1907BEB93FB713D3A028")
    private void pollState() {
        pollingContext = new int[1];
        pollingContext[0] = 0;
        {
            Object varA9E12DC9226BD6A76EE86EBF3C63475C_1281438638 = (cm.getRadioState());
            
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
                    obtainMessage(
                        EVENT_POLL_STATE_OPERATOR, pollingContext));
            
            
            cm.getDataRegistrationState(
                    obtainMessage(
                        EVENT_POLL_STATE_GPRS, pollingContext));
            
            
            cm.getVoiceRegistrationState(
                    obtainMessage(
                        EVENT_POLL_STATE_REGISTRATION, pollingContext));
            
            
            cm.getNetworkSelectionMode(
                    obtainMessage(
                        EVENT_POLL_STATE_NETWORK_SELECTION_MODE, pollingContext));
            
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.708 -0400", hash_original_method = "9E4E42BAC69A7F7033D249A5EA2291CC", hash_generated_method = "7B8D978D222AA7C30BF10892D1DACA2F")
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
        {
            boolean var143E8442CDD705F27BFDBD395C253EC4_919135484 = (ss.getState() != newSS.getState() || gprsState != newGPRSState);
            {
                EventLog.writeEvent(EventLogTags.GSM_SERVICE_STATE_CHANGE,
                ss.getState(), gprsState, newSS.getState(), newGPRSState);
            } 
        } 
        ServiceState tss;
        tss = ss;
        ss = newSS;
        newSS = tss;
        newSS.setStateOutOfService();
        GsmCellLocation tcl = cellLoc;
        cellLoc = newCellLoc;
        newCellLoc = tcl;
        {
            int cid = -1;
            GsmCellLocation loc = ((GsmCellLocation)phone.getCellLocation());
            cid = loc.getCid();
            EventLog.writeEvent(EventLogTags.GSM_RAT_SWITCHED, cid, mRadioTechnology,
                    mNewRadioTechnology);
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
        {
            phone.setSystemProperty(TelephonyProperties.PROPERTY_DATA_NETWORK_TYPE,
                    ServiceState.radioTechnologyToString(mRadioTechnology));
        } 
        {
            mNetworkAttachedRegistrants.notifyRegistrants();
        } 
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
            } 
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
                {
                    TimeZone zone = null;
                    String zoneName = SystemProperties.get(TIMEZONE_PROPERTY);
                    {
                        boolean var68D6F084332C821EF64E4C77B25B0DC4_1608522910 = ((mZoneOffset == 0) && (mZoneDst == false) &&
                        (zoneName != null) && (zoneName.length() > 0) &&
                        (Arrays.binarySearch(GMT_COUNTRY_CODES, iso) < 0));
                        {
                            zone = TimeZone.getDefault();
                            long tzOffset;
                            tzOffset = zone.getOffset(System.currentTimeMillis());
                            {
                                boolean var7389FF14414E14F8B6D3FDF104094769_2059701699 = (getAutoTime());
                                {
                                    setAndBroadcastNetworkSetTime(System.currentTimeMillis() - tzOffset);
                                } 
                                {
                                    mSavedTime = mSavedTime - tzOffset;
                                } 
                            } 
                        } 
                        {
                            boolean var9783B72CD950E393F287DC68561B68E2_1585847226 = (iso.equals(""));
                            {
                                zone = getNitzTimeZone(mZoneOffset, mZoneDst, mZoneTime);
                            } 
                            {
                                zone = TimeUtils.getTimeZone(mZoneOffset,
                            mZoneDst, mZoneTime, iso);
                            } 
                        } 
                    } 
                    mNeedFixZone = false;
                    {
                        {
                            boolean var8C3187FEB0B5319AAFFAA38FD3B51A47_824814462 = (getAutoTimeZone());
                            {
                                setAndBroadcastNetworkSetTimeZone(zone.getID());
                            } 
                        } 
                        saveNitzTimeZone(zone.getID());
                    } 
                } 
            } 
            phone.setSystemProperty(TelephonyProperties.PROPERTY_OPERATOR_ISROAMING,
                ss.getRoaming() ? "true" : "false");
            phone.notifyServiceStateChanged(ss);
        } 
        {
            mAttachedRegistrants.notifyRegistrants();
        } 
        {
            mDetachedRegistrants.notifyRegistrants();
        } 
        {
            phone.notifyDataConnection(Phone.REASON_NW_TYPE_CHANGED);
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
        {
            boolean var6FA3360FAB78058EDA6E2BDBDB6E6F00_533209291 = (! isGprsConsistent(gprsState, ss.getState()));
            {
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
            {
                mReportedGprsNoReg = false;
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.708 -0400", hash_original_method = "FF36AACCF1BD8DBC263BCA1FAF3CB26B", hash_generated_method = "7CAE983F78C62645774EC7ECB755141D")
    private boolean isGprsConsistent(int gprsState, int serviceState) {
        addTaint(gprsState);
        addTaint(serviceState);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_856637431 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_856637431;
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.709 -0400", hash_original_method = "99CED85D89C5E9DD8967FF1E935BF80B", hash_generated_method = "349805B1991C76DA75618E7B3AB605E6")
    private TimeZone getNitzTimeZone(int offset, boolean dst, long when) {
        TimeZone varB4EAC82CA7396A68D541C85D26508E83_1082070777 = null; 
        TimeZone guess = findTimeZone(offset, dst, when);
        {
            guess = findTimeZone(offset, !dst, when);
        } 
        log("getNitzTimeZone returning " + (guess == null ? guess : guess.getID()));
        varB4EAC82CA7396A68D541C85D26508E83_1082070777 = guess;
        addTaint(offset);
        addTaint(dst);
        addTaint(when);
        varB4EAC82CA7396A68D541C85D26508E83_1082070777.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1082070777;
        
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.716 -0400", hash_original_method = "950DB35A634BB86898B3E74AA5BE6013", hash_generated_method = "064D1804524BA45EF59EB6291BFDB2F0")
    private TimeZone findTimeZone(int offset, boolean dst, long when) {
        TimeZone varB4EAC82CA7396A68D541C85D26508E83_613909654 = null; 
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
                    boolean varB4FE0ADBDC9FF1B95A6CA053AB3FC7C2_1143317070 = (tz.getOffset(when) == offset &&
                tz.inDaylightTime(d) == dst);
                    {
                        guess = tz;
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_613909654 = guess;
        addTaint(offset);
        addTaint(dst);
        addTaint(when);
        varB4EAC82CA7396A68D541C85D26508E83_613909654.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_613909654;
        
        
        
            
        
        
        
        
        
            
            
                
                
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.716 -0400", hash_original_method = "C454880D3BFCEEC9D9AA3258CF5DFAC4", hash_generated_method = "54CAE7716212312AD26FA3CFEE521242")
    private void queueNextSignalStrengthPoll() {
        {
            boolean varFABDBA341AB8460B23C73AA303ECC474_269129673 = (dontPollSignalStrength || (cm.getRadioState().isCdma()));
        } 
        Message msg;
        msg = obtainMessage();
        msg.what = EVENT_POLL_SIGNAL_STRENGTH;
        long nextTime;
        sendMessageDelayed(msg, POLL_PERIOD_MILLIS);
        
        
            
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.717 -0400", hash_original_method = "313D4989F4A5423E3CAD270FA74FCE9F", hash_generated_method = "71419970C1CA2EFBC757AEF8B724482B")
    private void onSignalStrengthResult(AsyncResult ar) {
        SignalStrength oldSignalStrength = mSignalStrength;
        int rssi = 99;
        int lteSignalStrength = -1;
        int lteRsrp = -1;
        int lteRsrq = -1;
        int lteRssnr = -1;
        int lteCqi = -1;
        {
            setSignalStrengthDefaultValues();
        } 
        {
            int[] ints = (int[])ar.result;
            {
                rssi = ints[0];
                lteSignalStrength = ints[7];
                lteRsrp = ints[8];
                lteRsrq = ints[9];
                lteRssnr = ints[10];
                lteCqi = ints[11];
            } 
            {
                loge("Bogus signal strength response");
                rssi = 99;
            } 
        } 
        mSignalStrength = new SignalStrength(rssi, -1, -1, -1,
                -1, -1, -1, lteSignalStrength, lteRsrp, lteRsrq, lteRssnr, lteCqi, true);
        {
            boolean varD8EB70D7FE26A23D3B6D37D6BCE88E3C_319167197 = (!mSignalStrength.equals(oldSignalStrength));
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
        addTaint(ar.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.718 -0400", hash_original_method = "F4F35E6AADE0C2C218C2CEC9E86259B9", hash_generated_method = "6B4F8D4B656D189C8E925ECF7498B9A5")
    private void onRestrictedStateChanged(AsyncResult ar) {
        RestrictedState newRs = new RestrictedState();
        log("onRestrictedStateChanged: E rs "+ mRestrictedState);
        {
            int[] ints = (int[])ar.result;
            int state = ints[0];
            newRs.setCsEmergencyRestricted(
                    ((state & RILConstants.RIL_RESTRICTED_STATE_CS_EMERGENCY) != 0) ||
                    ((state & RILConstants.RIL_RESTRICTED_STATE_CS_ALL) != 0) );
            {
                boolean var8951092E4795D8AB36D9F0A620B3D692_1604867145 = (phone.getIccCard().getState() == IccCard.State.READY);
                {
                    newRs.setCsNormalRestricted(
                        ((state & RILConstants.RIL_RESTRICTED_STATE_CS_NORMAL) != 0) ||
                        ((state & RILConstants.RIL_RESTRICTED_STATE_CS_ALL) != 0) );
                    newRs.setPsRestricted(
                        (state & RILConstants.RIL_RESTRICTED_STATE_PS_ALL)!= 0);
                } 
            } 
            log("onRestrictedStateChanged: new rs "+ newRs);
            {
                boolean var66F9C6FA34536C8CECFFECE8CBFB966C_1054666384 = (!mRestrictedState.isPsRestricted() && newRs.isPsRestricted());
                {
                    mPsRestrictEnabledRegistrants.notifyRegistrants();
                    setNotification(PS_ENABLED);
                } 
                {
                    boolean var47985A63347641E23B69047B0CA95809_93370531 = (mRestrictedState.isPsRestricted() && !newRs.isPsRestricted());
                    {
                        mPsRestrictDisabledRegistrants.notifyRegistrants();
                        setNotification(PS_DISABLED);
                    } 
                } 
            } 
            {
                boolean var53CEA09ECC26E3CE282C559753298FAD_1608704082 = (mRestrictedState.isCsRestricted());
                {
                    {
                        boolean varFD345861E06AAC1F02808B8100871262_2080777960 = (!newRs.isCsRestricted());
                        {
                            setNotification(CS_DISABLED);
                        } 
                        {
                            boolean varF775F10526A2915A904B830F05D29343_2075606858 = (!newRs.isCsNormalRestricted());
                            {
                                setNotification(CS_EMERGENCY_ENABLED);
                            } 
                            {
                                boolean var848D99B0CB2E1F9969677D8CFB6BDE41_59672142 = (!newRs.isCsEmergencyRestricted());
                                {
                                    setNotification(CS_NORMAL_ENABLED);
                                } 
                            } 
                        } 
                    } 
                } 
                {
                    boolean var8425B7AAE555ACB534CBBFB232933383_1188758013 = (mRestrictedState.isCsEmergencyRestricted() &&
                    !mRestrictedState.isCsNormalRestricted());
                    {
                        {
                            boolean var57C46803FA0EBC9793E13B85074E4774_900968529 = (!newRs.isCsRestricted());
                            {
                                setNotification(CS_DISABLED);
                            } 
                            {
                                boolean var27346B4CFE3FD828EAA0C980B0F71B77_1867532094 = (newRs.isCsRestricted());
                                {
                                    setNotification(CS_ENABLED);
                                } 
                                {
                                    boolean varA6445632BAC49F059B36EB0EE223CBF3_1664538986 = (newRs.isCsNormalRestricted());
                                    {
                                        setNotification(CS_NORMAL_ENABLED);
                                    } 
                                } 
                            } 
                        } 
                    } 
                    {
                        boolean var8B9B8A10D1E1D0780F2ADC08103E1156_1861147392 = (!mRestrictedState.isCsEmergencyRestricted() &&
                    mRestrictedState.isCsNormalRestricted());
                        {
                            {
                                boolean var0C960E3B23E0FE22C0136CA55F39BD3C_384443710 = (!newRs.isCsRestricted());
                                {
                                    setNotification(CS_DISABLED);
                                } 
                                {
                                    boolean var781BCA8B76F7E4DD7490A8CCA199987B_60687347 = (newRs.isCsRestricted());
                                    {
                                        setNotification(CS_ENABLED);
                                    } 
                                    {
                                        boolean var8D1515582205D7E6089169936842A19F_229369295 = (newRs.isCsEmergencyRestricted());
                                        {
                                            setNotification(CS_EMERGENCY_ENABLED);
                                        } 
                                    } 
                                } 
                            } 
                        } 
                        {
                            {
                                boolean var27346B4CFE3FD828EAA0C980B0F71B77_1555371768 = (newRs.isCsRestricted());
                                {
                                    setNotification(CS_ENABLED);
                                } 
                                {
                                    boolean varE95AEEA60DFE465EF47CAD9470E42413_104623577 = (newRs.isCsEmergencyRestricted());
                                    {
                                        setNotification(CS_EMERGENCY_ENABLED);
                                    } 
                                    {
                                        boolean varEA89AD4C45E7AF96B724F608A04DFDEA_1178900029 = (newRs.isCsNormalRestricted());
                                        {
                                            setNotification(CS_NORMAL_ENABLED);
                                        } 
                                    } 
                                } 
                            } 
                        } 
                    } 
                } 
            } 
            mRestrictedState = newRs;
        } 
        log("onRestrictedStateChanged: X rs "+ mRestrictedState);
        addTaint(ar.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.719 -0400", hash_original_method = "224D5C409E7F86CE5414891CFB70A981", hash_generated_method = "C2906C2C928873F7BE635F1B3CCE3E92")
    private int regCodeToServiceState(int code) {
        
        loge("regCodeToServiceState: unexpected service state " + code);
        
        addTaint(code);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1616446964 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1616446964;
        
        
            
            
            
            
            
            
            
            
                
            
                
            
                
            
                
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.719 -0400", hash_original_method = "19036A7D1DADA943DC912DAB6396B9AD", hash_generated_method = "FA07919D09439535A3E9DF19E558BA64")
    private boolean regCodeIsRoaming(int code) {
        addTaint(code);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1261380619 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1261380619;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.720 -0400", hash_original_method = "A83CC5F0F34C62E2D3BC7866CECAC756", hash_generated_method = "1622794BC34F399E9940E60AC8937B01")
    private boolean isRoamingBetweenOperators(boolean gsmRoaming, ServiceState s) {
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
        { }
        addTaint(gsmRoaming);
        addTaint(s.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1337816031 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1337816031;
        
        
        
        
        
        
        
                
        
        
        
            
                    
        
        
        
    }

    
        @DSModeled(DSC.SPEC)
    private static int twoDigitsAt(String s, int offset) {
        int a, b;
        a = Character.digit(s.charAt(offset), 10);
        b = Character.digit(s.charAt(offset+1), 10);
        if (a < 0 || b < 0) {
            throw new RuntimeException("invalid format");
        }
        return a*10 + b;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.721 -0400", hash_original_method = "462522C9E25E239E090C32F4DC1CCDBD", hash_generated_method = "17A04E31F546474D4D9F901D6AF25514")
     int getCurrentGprsState() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1423405654 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1423405654;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.721 -0400", hash_original_method = "76A0DFDE7E82168261B9485993735FA8", hash_generated_method = "EB9D937BF4B10F838BC637D07157B45D")
    public int getCurrentDataConnectionState() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1141375666 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1141375666;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.722 -0400", hash_original_method = "35025CCE5222CF7AFA718FFADECE80EF", hash_generated_method = "7CBEFDBA701E2DF70B463A5D0DC97E27")
    public boolean isConcurrentVoiceAndDataAllowed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_388129913 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_388129913;
        
        
    }

    
        @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.726 -0400", hash_original_method = "D8515350C34B3E7CC6A83CEBE4C1FE6C", hash_generated_method = "78F2B9343E9DAE4804C820EFE1DE082D")
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
                        boolean var8053821E6225ABE6D6EDD5F45C9DBCB8_2131696051 = (iso != null && iso.length() > 0);
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
                    boolean var624415BE8DA2189070E2F3831D7C1692_664671522 = (getAutoTimeZone());
                    {
                        setAndBroadcastNetworkSetTimeZone(zone.getID());
                    } 
                } 
                saveNitzTimeZone(zone.getID());
            } 
            String ignore = SystemProperties.get("gsm.ignore-nitz");
            {
                boolean varE5D77747E14F70AD020ECEBD14623725_1005431275 = (ignore != null && ignore.equals("yes"));
                {
                    log("NITZ: Not setting clock because gsm.ignore-nitz is set");
                } 
            } 
            try 
            {
                mWakeLock.acquire();
                {
                    boolean varEEB7CD030807CE702D36FA7DEF7E06F9_1083416054 = (getAutoTime());
                    {
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
                            log("NITZ: Setting time of day to " + c.getTime()
                            + " NITZ receive delay(ms): " + millisSinceNitzReceived
                            + " gained(ms): "
                            + (c.getTimeInMillis() - System.currentTimeMillis())
                            + " from " + nitz);
                        } 
                        setAndBroadcastNetworkSetTime(c.getTimeInMillis());
                    } 
                } 
                SystemProperties.set("gsm.nitz.time", String.valueOf(c.getTimeInMillis()));
                saveNitzTime(c.getTimeInMillis());
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
        addTaint(nitz.getTaint());
        addTaint(nitzReceiveTime);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.727 -0400", hash_original_method = "10C2AC47FB9B2FA38284A276FBC39461", hash_generated_method = "7CC3C69B48FBD0CE8FEEF80B8DBBCE70")
    private boolean getAutoTime() {
        try 
        {
            boolean var0E961C85A40349516FBBBA448F8C2528_139079611 = (Settings.System.getInt(phone.getContext().getContentResolver(),
                    Settings.System.AUTO_TIME) > 0);
        } 
        catch (SettingNotFoundException snfe)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2069323603 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2069323603;
        
        
            
                    
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.727 -0400", hash_original_method = "46367736BD7DFDD485A94174DBA3ECD3", hash_generated_method = "1C842A503E1A4ABD4EECC5BD68B2C406")
    private boolean getAutoTimeZone() {
        try 
        {
            boolean var4E86644AAFB80825EAF556B6919FD175_17996294 = (Settings.System.getInt(phone.getContext().getContentResolver(),
                    Settings.System.AUTO_TIME_ZONE) > 0);
        } 
        catch (SettingNotFoundException snfe)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1282719770 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1282719770;
        
        
            
                    
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.728 -0400", hash_original_method = "AC4D6B705E7065D39BD6B0621414F077", hash_generated_method = "89E6488BB9B703C7CA9BBABF73A30618")
    private void saveNitzTimeZone(String zoneId) {
        mSavedTimeZone = zoneId;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.729 -0400", hash_original_method = "BBC081DF5E9AA5E0F675E4C4D97D41FA", hash_generated_method = "FA812F2463447E256E093AB70BACE34A")
    private void saveNitzTime(long time) {
        mSavedTime = time;
        mSavedAtTime = SystemClock.elapsedRealtime();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.732 -0400", hash_original_method = "28A8B5328B033F98ED5E62B240AD20B6", hash_generated_method = "615D9BCC0526644A6FABF0729825DCD5")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.733 -0400", hash_original_method = "062E38B571EEA7E979075562F8B40A5D", hash_generated_method = "156D578D330D03E3808034F191771B34")
    private void setAndBroadcastNetworkSetTime(long time) {
        SystemClock.setCurrentTimeMillis(time);
        Intent intent = new Intent(TelephonyIntents.ACTION_NETWORK_SET_TIME);
        intent.addFlags(Intent.FLAG_RECEIVER_REPLACE_PENDING);
        intent.putExtra("time", time);
        phone.getContext().sendStickyBroadcast(intent);
        addTaint(time);
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.734 -0400", hash_original_method = "2770201C4A137564A500CEEFB3D4E467", hash_generated_method = "4A1978B635FE339543328A2F16403BA8")
    private void revertToNitzTime() {
        {
            boolean var2ACAD0BBF60577A314AB894E465C1761_769550190 = (Settings.System.getInt(phone.getContext().getContentResolver(),
                Settings.System.AUTO_TIME, 0) == 0);
        } 
        {
            log("Reverting to NITZ Time: mSavedTime=" + mSavedTime
                + " mSavedAtTime=" + mSavedAtTime);
        } 
        {
            setAndBroadcastNetworkSetTime(mSavedTime
                    + (SystemClock.elapsedRealtime() - mSavedAtTime));
        } 
        
        
                
            
        
        
            
                
        
        
            
                    
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.736 -0400", hash_original_method = "846FA792EAB8BB56C921A6228BC9EB73", hash_generated_method = "678B3A3E1A904963AD0D877FBE4FC4B7")
    private void revertToNitzTimeZone() {
        {
            boolean var368E56141E4682CFD54AD9DE0B6F4586_1265572770 = (Settings.System.getInt(phone.getContext().getContentResolver(),
                Settings.System.AUTO_TIME_ZONE, 0) == 0);
        } 
        log("Reverting to NITZ TimeZone: tz='" + mSavedTimeZone);
        {
            setAndBroadcastNetworkSetTimeZone(mSavedTimeZone);
        } 
        
        
                
            
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.738 -0400", hash_original_method = "90EFCD7762032B11006E493EA631CF1F", hash_generated_method = "D488895FFF2D87C2381A9A5E38F16CF1")
    private void setNotification(int notifyType) {
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
        
        notificationId = PS_NOTIFICATION;
        
        
        details = context.getText(com.android.internal.R.string.RestrictedOnData);
        
        
        ;
        
        
        notificationId = PS_NOTIFICATION;
        
        
        details = context.getText(com.android.internal.R.string.RestrictedOnAllVoice);
        
        
        ;
        
        
        details = context.getText(com.android.internal.R.string.RestrictedOnNormal);
        
        
        ;
        
        
        details = context.getText(com.android.internal.R.string.RestrictedOnEmergency);
        
        
        ;
        
        log("setNotification: put notification " + title + " / " +details);
        mNotification.tickerText = title;
        mNotification.setLatestEventInfo(context, title, details,
                mNotification.contentIntent);
        NotificationManager notificationManager = (NotificationManager)
            context.getSystemService(Context.NOTIFICATION_SERVICE);
        {
            notificationManager.cancel(notificationId);
        } 
        {
            notificationManager.notify(notificationId, mNotification);
        } 
        addTaint(notifyType);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.738 -0400", hash_original_method = "4109BBDDE3BB927415F4177275F054A2", hash_generated_method = "F00A9135B0DCAA52FF85009B99A2E828")
    @Override
    protected void log(String s) {
        Log.d(LOG_TAG, "[GsmSST] " + s);
        addTaint(s.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.739 -0400", hash_original_method = "E8A9D45B999B20E24B18F0E2F50C667F", hash_generated_method = "5D4ED3A9E70D2AABB538EA7C903DDA44")
    @Override
    protected void loge(String s) {
        addTaint(s.getTaint());
        
        
    }

    
        @DSModeled(DSC.SPEC)
    private static void sloge(String s) {
        Log.e(LOG_TAG, "[GsmSST] " + s);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.739 -0400", hash_original_field = "41EBE7F32B96C1E2E9C209710486A443", hash_generated_field = "B8386CD6D900777C9D6A0A5CA1D0B217")

    static final String LOG_TAG = "GSM";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.739 -0400", hash_original_field = "A4622F7F72162611C8E075EE443BC26E", hash_generated_field = "3860CF443CF1EC2A1FAD1F55FBF8A7F5")

    static final boolean DBG = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.739 -0400", hash_original_field = "8AA5488317F9A54E56045D1AAF74BB75", hash_generated_field = "3E784668308EA1C4770734C39504B13F")

    private static final String WAKELOCK_TAG = "ServiceStateTracker";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.739 -0400", hash_original_field = "78DBFEDA4D4BF3B7443050756EB706DA", hash_generated_field = "4A5D9F03FAE9E50AE63B4C35022FAF17")

    static final int DEFAULT_GPRS_CHECK_PERIOD_MILLIS = 60 * 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.739 -0400", hash_original_field = "0EDCF36F1C7515917C6C8C6960C44E94", hash_generated_field = "3591FCEB08077E36696EAEB77DBB3180")

    static final int PS_ENABLED = 1001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.739 -0400", hash_original_field = "74ECF90DF353CA07A72C88F6756E63FD", hash_generated_field = "8C26EED9E7268BEDBBAF04F084560166")

    static final int PS_DISABLED = 1002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.739 -0400", hash_original_field = "B3D8643D85377D116361C3F5C8140E0B", hash_generated_field = "B2781F5CE66230CC973402FB9B2889B2")

    static final int CS_ENABLED = 1003;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.739 -0400", hash_original_field = "AE9874F242E8D117F7BAE3E010B557AB", hash_generated_field = "D51C56159F181C83643165D845D52483")

    static final int CS_DISABLED = 1004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.739 -0400", hash_original_field = "8B193C5B10382A1D1FD53AB21D3BD2E3", hash_generated_field = "C31DA0EA8EA157BEB2FE7CB33DF402A6")

    static final int CS_NORMAL_ENABLED = 1005;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.739 -0400", hash_original_field = "EEF6FD506D2FA8B090021A1D296EDD7B", hash_generated_field = "F9B78C4A6E79981FE3F71480BC07396C")

    static final int CS_EMERGENCY_ENABLED = 1006;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.739 -0400", hash_original_field = "ED6B67AB4D0B4DF3C237651AC21D2816", hash_generated_field = "798CDAD9FDD0BFCBF4723E408D009540")

    static final int PS_NOTIFICATION = 888;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.739 -0400", hash_original_field = "97AFCBF220761A84FA450E75A3CE004D", hash_generated_field = "EBBCDE09A71FA16B42C4199ACB2E765C")

    static final int CS_NOTIFICATION = 999;
}

