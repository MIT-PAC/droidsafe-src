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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.669 -0400", hash_original_field = "F7A42FE7211F98AC7A60A285AC3A9E87", hash_generated_field = "690DC9441FA6BD04E0472B4DF9E035F8")

    GSMPhone phone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.669 -0400", hash_original_field = "B9C5653E1C2BC689F2CC98D72803F0E0", hash_generated_field = "6501E6CCC6A627167D828A01CEBF7711")

    GsmCellLocation cellLoc;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.669 -0400", hash_original_field = "B325523B8771CAA3A7FB54CA6901D43A", hash_generated_field = "B261F7AD66455AA0C3F3A08229915B3D")

    GsmCellLocation newCellLoc;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.669 -0400", hash_original_field = "5E797CD98A6F48EA74102A194ABE8414", hash_generated_field = "5BA84AC7CBE58E4EDB6614D7B15D6E0E")

    int mPreferredNetworkType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.669 -0400", hash_original_field = "09ADCB4D8E411083650BF094C0F5A282", hash_generated_field = "07B777CC7BF8F0F7679AC97DE6B0C153")

    private int gprsState = ServiceState.STATE_OUT_OF_SERVICE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.669 -0400", hash_original_field = "3DD74F5CB43F87ECACC4768DBADF0137", hash_generated_field = "7035A3B0948B79A30C2C00DECE9F4570")

    private int newGPRSState = ServiceState.STATE_OUT_OF_SERVICE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.669 -0400", hash_original_field = "2AFEACA217B557D16E803474269AC334", hash_generated_field = "5F1A31BADD427D5DFCB23ECFD73B8B95")

    private int mMaxDataCalls = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.669 -0400", hash_original_field = "E93FE6CD696F5691F32A4C7A9078BA63", hash_generated_field = "D1E578B67E4CC593BE870B60F03AA83C")

    private int mNewMaxDataCalls = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.669 -0400", hash_original_field = "A834835F3CEDAC8AC7E64228C76E5077", hash_generated_field = "981E84B4948A11F540AE3C83118D725F")

    private int mReasonDataDenied = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.669 -0400", hash_original_field = "D821D524FB7806A8991C807AE4CA7635", hash_generated_field = "3DCB78EC6066191396204C4D07EB7548")

    private int mNewReasonDataDenied = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.669 -0400", hash_original_field = "9380C85BAA057C151A0AF0A172BD132A", hash_generated_field = "0E48791EFF44078585E96EA7C7ED6E26")

    private boolean mGsmRoaming = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.669 -0400", hash_original_field = "BD02E473C1C27AC87C52110872C4EBF8", hash_generated_field = "4F72E8DCBAFD6C5A4FC303F5B439CC14")

    private boolean mDataRoaming = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.669 -0400", hash_original_field = "85105C0E76607ED02FD2FDEB8B0B0D87", hash_generated_field = "A81A887211F7F6A8BF5C317C7E4646E5")

    private boolean mEmergencyOnly = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.669 -0400", hash_original_field = "28BAF9CE3F67CB31A5C7E4A1C64709A2", hash_generated_field = "2D2C0A8AA7022D57AB24C477C9212676")

    private boolean mNeedFixZone = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.669 -0400", hash_original_field = "F22170EE4512552F24101CBB42D416D7", hash_generated_field = "C126894205DFD14FA38D307801001C6F")

    private int mZoneOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.669 -0400", hash_original_field = "C93085FA426E2C8BDD28EDA54293198A", hash_generated_field = "63800483D80F5CB684E683BC24E0A820")

    private boolean mZoneDst;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.669 -0400", hash_original_field = "0A09D50B767A402C68BB8923B251B081", hash_generated_field = "7498B22AB24D6B5E081FF2DDE0FD21C8")

    private long mZoneTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.676 -0400", hash_original_field = "91657A67842D433756013CCE7BEFC8EA", hash_generated_field = "C304726703E30667C2FAD4B6BFDDEB63")

    private boolean mGotCountryCode = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.676 -0400", hash_original_field = "324D8A1D3F81E730D5099A48CEE0C5B6", hash_generated_field = "CC964D293F1703643DB273FCC0901562")

    private ContentResolver cr;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.676 -0400", hash_original_field = "629AB99995100B7F6B737671E7028A77", hash_generated_field = "30A17FCDED9983DC17E4B0241936D019")

    String mSavedTimeZone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.676 -0400", hash_original_field = "0870ED367B81A3D199CC36F4FF58F6E3", hash_generated_field = "56DFA99AB6C2048EFF6A2B28FFEF5620")

    long mSavedTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.676 -0400", hash_original_field = "E11E42BBA30EA79639217C987535FA76", hash_generated_field = "2B2B2F1D0E3CAC70A6D7541E3BA2D300")

    long mSavedAtTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.676 -0400", hash_original_field = "794B9E75544086325155A72AA171A32E", hash_generated_field = "1929EEEAE2485E3C7781EBAA0F354C99")

    private boolean mNeedToRegForSimLoaded;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.676 -0400", hash_original_field = "8845867B8D05D961286A1A19CE10D2DC", hash_generated_field = "EA9A1384C97DE38DCF8B990AF3F83712")

    private boolean mStartedGprsRegCheck = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.676 -0400", hash_original_field = "D7F7DA1A823510EF7DFA18A7D3740A12", hash_generated_field = "69E634E61A627800AF487B771D6ECAD0")

    private boolean mReportedGprsNoReg = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.676 -0400", hash_original_field = "FA180D1FC40F4514789E94C434050443", hash_generated_field = "74FBA8E8F4402404F407A6E0DBC8943E")

    private Notification mNotification;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.676 -0400", hash_original_field = "69E45E7E240C011D8CB3CFDE90D76B33", hash_generated_field = "C0FF63B0998195CF037A71BFC5C5B113")

    private PowerManager.WakeLock mWakeLock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.676 -0400", hash_original_field = "438E769CBE3194E31EE3583D475755E2", hash_generated_field = "D741E5B3B277519D91E4FE02D3FAFF01")

    private String curSpn = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.676 -0400", hash_original_field = "8F0345704253C4ABC1429588E7767D95", hash_generated_field = "9047898EE9FB6E0F59121E370CC3C8CF")

    private String curPlmn = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.676 -0400", hash_original_field = "980A06D55B7D1D17AD8917BD8B3AD170", hash_generated_field = "E51B211F12EB3D4199E57F38674CC690")

    private int curSpnRule = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.679 -0400", hash_original_field = "AB74790817CE8598B3B84738E53E435A", hash_generated_field = "377A9DD6AC5218446AC344EE1B25EA67")

    private BroadcastReceiver mIntentReceiver = new BroadcastReceiver() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.679 -0400", hash_original_method = "7D33A0984FFB123C6674B46896DDEB1E", hash_generated_method = "6E9BF3CCDC7AD2788568DC1478C00971")
        @Override
        public void onReceive(Context context, Intent intent) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                boolean varD74456F3A5211D970550D171BFD231F1_462588278 = (intent.getAction().equals(Intent.ACTION_LOCALE_CHANGED));
                {
                    updateSpnDisplay();
                } //End block
            } //End collapsed parenthetic
            addTaint(context.getTaint());
            addTaint(intent.getTaint());
            // ---------- Original Method ----------
            //if (intent.getAction().equals(Intent.ACTION_LOCALE_CHANGED)) {
                //updateSpnDisplay();
            //}
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.679 -0400", hash_original_field = "DE088C6BF9EC1AFE67E7551680F21C7E", hash_generated_field = "D45A79733BE593C3FE503FC536081894")

    private ContentObserver mAutoTimeObserver = new ContentObserver(new Handler()) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.679 -0400", hash_original_method = "227D40A344094AD4B591040BC6F6DC3D", hash_generated_method = "F4315810E745D16A27460B49034466AB")
        @Override
        public void onChange(boolean selfChange) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            revertToNitzTime();
            addTaint(selfChange);
            // ---------- Original Method ----------
            //Log.i("GsmServiceStateTracker", "Auto time state changed");
            //revertToNitzTime();
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.686 -0400", hash_original_field = "160828814E36CFDE204FECD88170AF0C", hash_generated_field = "B926CBE1267F37893DF9E24C448E7D98")

    private ContentObserver mAutoTimeZoneObserver = new ContentObserver(new Handler()) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.685 -0400", hash_original_method = "CFFF91BA86D25926B76415F80D2C8421", hash_generated_method = "E308D52C44EEB3156885DEEED1F0C5D9")
        @Override
        public void onChange(boolean selfChange) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            revertToNitzTimeZone();
            addTaint(selfChange);
            // ---------- Original Method ----------
            //Log.i("GsmServiceStateTracker", "Auto time zone state changed");
            //revertToNitzTimeZone();
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.698 -0400", hash_original_method = "89B681C68F2C3DCA55179D15C34AC4AC", hash_generated_method = "CE037C64C71EA89F70B55F526ED2B011")
    public  GsmServiceStateTracker(GSMPhone phone) {
        super();
        this.phone = phone;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.699 -0400", hash_original_method = "D8900B5121A238BBC317864D0A18F1DD", hash_generated_method = "B40ED7CB9364FAE6479A4D45B656DCB0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.699 -0400", hash_original_method = "6FB50CEA8307C4B6093E637FBC3F2923", hash_generated_method = "61ECE0E646E8B1764F5B7DA5FA912912")
    protected void finalize() {
        log("finalize");
        // ---------- Original Method ----------
        //if(DBG) log("finalize");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.700 -0400", hash_original_method = "A0DE0F5E4F4D4787509D60C270D17835", hash_generated_method = "840AA5E835FCBEE4C9C3A056FBAD30C7")
    @Override
    protected Phone getPhone() {
        Phone varB4EAC82CA7396A68D541C85D26508E83_2043109560 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2043109560 = phone;
        varB4EAC82CA7396A68D541C85D26508E83_2043109560.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2043109560;
        // ---------- Original Method ----------
        //return phone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.714 -0400", hash_original_method = "8D6E3CD042747DF0CD652F21C9ED2A0B", hash_generated_method = "3216F7CCBB7AF8BC1837351E7FFA7AEE")
    public void handleMessage(Message msg) {
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
            boolean var073B81928925E9A842A5B7D6E127E98B_363241842 = (!(cm.getRadioState().isOn()) || (cm.getRadioState().isCdma()));
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
                        boolean var9D5A64E58810D558AB453A876F76F10A_2104271265 = (states[1] != null && states[1].length() > 0);
                        {
                            lac = Integer.parseInt(states[1], 16);
                        } //End block
                    } //End collapsed parenthetic
                    {
                        boolean varE1384D31A474A975FC250415D1CF0A98_178659866 = (states[2] != null && states[2].length() > 0);
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
            boolean varFC20FFEE0B571214859D080B805B15AB_484925435 = (ss != null && !isGprsConsistent(gprsState, ss.getState()));
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
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.715 -0400", hash_original_method = "BC2E3346E1E8D048BB892FC104E776BC", hash_generated_method = "2F32BB8698CAAE86369A43EE2F82BC5E")
    protected void setPowerStateToDesired() {
        {
            boolean var132800EA641B7653EC59634384D41AC8_1051649957 = (mDesiredPowerState
            && cm.getRadioState() == CommandsInterface.RadioState.RADIO_OFF);
            {
                cm.setRadioPower(true, null);
            } //End block
            {
                boolean var9EF9CD1D5966856073F2A7E801160763_2042627520 = (!mDesiredPowerState && cm.getRadioState().isOn());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.739 -0400", hash_original_method = "E3C7A91B3D91C3ACB7BE5D936C3A4029", hash_generated_method = "037E4DF8B9DE2E6FA3D94F09CE7AA0CD")
    @Override
    protected void hangupAndPowerOff() {
        {
            boolean varC2DAA1612218A41C583800F71FEEEFE0_1548054743 = (phone.isInCall());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.740 -0400", hash_original_method = "12AE11DB9489E0514D18AAE66522FB76", hash_generated_method = "8524BEDC76E0AE09397E78EE1F9A2B99")
    protected void updateSpnDisplay() {
        int rule;
        rule = phone.mIccRecords.getDisplayRule(ss.getOperatorNumeric());
        String spn;
        spn = phone.mIccRecords.getServiceProviderName();
        String plmn;
        plmn = ss.getOperatorAlphaLong();
        {
            boolean var06D0886726202C33A42C3319B2FBCFA6_106912718 = (mEmergencyOnly && cm.getRadioState().isOn());
            {
                plmn = Resources.getSystem().
                getText(com.android.internal.R.string.emergency_calls_only).toString();
                log("updateSpnDisplay: emergency only and radio is on plmn='" + plmn + "'");
            } //End block
        } //End collapsed parenthetic
        {
            boolean varBB23ADBA0F49FDA2EE72E8A6C8D8F6D8_513013044 = (rule != curSpnRule
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.781 -0400", hash_original_method = "715C325B720DBA72DF5B4684F1B692D5", hash_generated_method = "86E97E6618B37AD752F96B696B6C6D16")
    protected void handlePollStateResult(int what, AsyncResult ar) {
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
                boolean var0F541275CA306A5F1AC77D786FD54CFD_2098724461 = (!cm.getRadioState().isOn());
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
                            boolean varC8FB6E238E31780D1F2471C052768A12_605840314 = (states[1] != null && states[1].length() > 0);
                            {
                                lac = Integer.parseInt(states[1], 16);
                            } //End block
                        } //End collapsed parenthetic
                        {
                            boolean var8EA46D418EFE8869C53A8FFB1B763349_276058325 = (states[2] != null && states[2].length() > 0);
                            {
                                cid = Integer.parseInt(states[2], 16);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        {
                            boolean var4770B9A59F4D2AA52CA9C0062D193D69_751077320 = (states[14] != null && states[14].length() > 0);
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
                boolean varAD836B3792BA6824B78D98F7D142DE65_2102863385 = (mGsmRoaming && !isRoamingBetweenOperators(mGsmRoaming, newSS));
                {
                    roaming = false;
                } //End block
            } //End collapsed parenthetic
            newSS.setRoaming(roaming);
            newSS.setEmergencyOnly(mEmergencyOnly);
            pollStateDone();
        } //End block
        addTaint(what);
        addTaint(ar.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.783 -0400", hash_original_method = "76DE4C6A99E85827FF76DDCBD0A680F0", hash_generated_method = "FB6F947C716BD93C04B4BB847C77356E")
    private void setSignalStrengthDefaultValues() {
        mSignalStrength = new SignalStrength(99, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, true);
        // ---------- Original Method ----------
        //mSignalStrength = new SignalStrength(99, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.795 -0400", hash_original_method = "4A9AA9B5E92E73D941CD4914D7782EA3", hash_generated_method = "3E4A932EF11895EF9796D1BFB8F21EA9")
    private void pollState() {
        pollingContext = new int[1];
        pollingContext[0] = 0;
        {
            Object varA9E12DC9226BD6A76EE86EBF3C63475C_1109934181 = (cm.getRadioState());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.813 -0400", hash_original_method = "9E4E42BAC69A7F7033D249A5EA2291CC", hash_generated_method = "4ECBAC0EF26B0D6C11BDF5968F53E021")
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
            boolean var143E8442CDD705F27BFDBD395C253EC4_1583414513 = (ss.getState() != newSS.getState() || gprsState != newGPRSState);
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
                        boolean var68D6F084332C821EF64E4C77B25B0DC4_630452709 = ((mZoneOffset == 0) && (mZoneDst == false) &&
                        (zoneName != null) && (zoneName.length() > 0) &&
                        (Arrays.binarySearch(GMT_COUNTRY_CODES, iso) < 0));
                        {
                            zone = TimeZone.getDefault();
                            long tzOffset;
                            tzOffset = zone.getOffset(System.currentTimeMillis());
                            {
                                boolean var7389FF14414E14F8B6D3FDF104094769_518631060 = (getAutoTime());
                                {
                                    setAndBroadcastNetworkSetTime(System.currentTimeMillis() - tzOffset);
                                } //End block
                                {
                                    mSavedTime = mSavedTime - tzOffset;
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                        {
                            boolean var9783B72CD950E393F287DC68561B68E2_1700404911 = (iso.equals(""));
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
                            boolean var8C3187FEB0B5319AAFFAA38FD3B51A47_1914213447 = (getAutoTimeZone());
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
            boolean var6FA3360FAB78058EDA6E2BDBDB6E6F00_599638271 = (! isGprsConsistent(gprsState, ss.getState()));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.830 -0400", hash_original_method = "FF36AACCF1BD8DBC263BCA1FAF3CB26B", hash_generated_method = "5780A4A7CAFFAFA305EDF6C39003132D")
    private boolean isGprsConsistent(int gprsState, int serviceState) {
        addTaint(gprsState);
        addTaint(serviceState);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_975784981 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_975784981;
        // ---------- Original Method ----------
        //return !((serviceState == ServiceState.STATE_IN_SERVICE) &&
                //(gprsState != ServiceState.STATE_IN_SERVICE));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.831 -0400", hash_original_method = "99CED85D89C5E9DD8967FF1E935BF80B", hash_generated_method = "EEC93E4CAC39AA3F0DFF208DA1FC0113")
    private TimeZone getNitzTimeZone(int offset, boolean dst, long when) {
        TimeZone varB4EAC82CA7396A68D541C85D26508E83_1159087308 = null; //Variable for return #1
        TimeZone guess;
        guess = findTimeZone(offset, dst, when);
        {
            guess = findTimeZone(offset, !dst, when);
        } //End block
        log("getNitzTimeZone returning " + (guess == null ? guess : guess.getID()));
        varB4EAC82CA7396A68D541C85D26508E83_1159087308 = guess;
        addTaint(offset);
        addTaint(dst);
        addTaint(when);
        varB4EAC82CA7396A68D541C85D26508E83_1159087308.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1159087308;
        // ---------- Original Method ----------
        //TimeZone guess = findTimeZone(offset, dst, when);
        //if (guess == null) {
            //guess = findTimeZone(offset, !dst, when);
        //}
        //if (DBG) log("getNitzTimeZone returning " + (guess == null ? guess : guess.getID()));
        //return guess;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.889 -0400", hash_original_method = "950DB35A634BB86898B3E74AA5BE6013", hash_generated_method = "C81D18550A9B4E9766829155FA9AD7E6")
    private TimeZone findTimeZone(int offset, boolean dst, long when) {
        TimeZone varB4EAC82CA7396A68D541C85D26508E83_1655785503 = null; //Variable for return #1
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
                    boolean varB4FE0ADBDC9FF1B95A6CA053AB3FC7C2_676358910 = (tz.getOffset(when) == offset &&
                tz.inDaylightTime(d) == dst);
                    {
                        guess = tz;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1655785503 = guess;
        addTaint(offset);
        addTaint(dst);
        addTaint(when);
        varB4EAC82CA7396A68D541C85D26508E83_1655785503.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1655785503;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.902 -0400", hash_original_method = "C454880D3BFCEEC9D9AA3258CF5DFAC4", hash_generated_method = "956F602BFC0AD0C0F92DB54B6B3F661E")
    private void queueNextSignalStrengthPoll() {
        {
            boolean varFABDBA341AB8460B23C73AA303ECC474_533202743 = (dontPollSignalStrength || (cm.getRadioState().isCdma()));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.904 -0400", hash_original_method = "313D4989F4A5423E3CAD270FA74FCE9F", hash_generated_method = "6971158E4DDB34807C6A96729808B911")
    private void onSignalStrengthResult(AsyncResult ar) {
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
        lteRssnr = -1;
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
            boolean varD8EB70D7FE26A23D3B6D37D6BCE88E3C_1849864448 = (!mSignalStrength.equals(oldSignalStrength));
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
        addTaint(ar.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.910 -0400", hash_original_method = "F4F35E6AADE0C2C218C2CEC9E86259B9", hash_generated_method = "9DEBABFDF8D0C8E95CC243D6FB71F286")
    private void onRestrictedStateChanged(AsyncResult ar) {
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
                boolean var8951092E4795D8AB36D9F0A620B3D692_736571386 = (phone.getIccCard().getState() == IccCard.State.READY);
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
                boolean var66F9C6FA34536C8CECFFECE8CBFB966C_521903993 = (!mRestrictedState.isPsRestricted() && newRs.isPsRestricted());
                {
                    mPsRestrictEnabledRegistrants.notifyRegistrants();
                    setNotification(PS_ENABLED);
                } //End block
                {
                    boolean var47985A63347641E23B69047B0CA95809_1424774977 = (mRestrictedState.isPsRestricted() && !newRs.isPsRestricted());
                    {
                        mPsRestrictDisabledRegistrants.notifyRegistrants();
                        setNotification(PS_DISABLED);
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            {
                boolean var53CEA09ECC26E3CE282C559753298FAD_1121300961 = (mRestrictedState.isCsRestricted());
                {
                    {
                        boolean varFD345861E06AAC1F02808B8100871262_698502796 = (!newRs.isCsRestricted());
                        {
                            setNotification(CS_DISABLED);
                        } //End block
                        {
                            boolean varF775F10526A2915A904B830F05D29343_1015226957 = (!newRs.isCsNormalRestricted());
                            {
                                setNotification(CS_EMERGENCY_ENABLED);
                            } //End block
                            {
                                boolean var848D99B0CB2E1F9969677D8CFB6BDE41_1048961038 = (!newRs.isCsEmergencyRestricted());
                                {
                                    setNotification(CS_NORMAL_ENABLED);
                                } //End block
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean var8425B7AAE555ACB534CBBFB232933383_1585670900 = (mRestrictedState.isCsEmergencyRestricted() &&
                    !mRestrictedState.isCsNormalRestricted());
                    {
                        {
                            boolean var57C46803FA0EBC9793E13B85074E4774_171858401 = (!newRs.isCsRestricted());
                            {
                                setNotification(CS_DISABLED);
                            } //End block
                            {
                                boolean var27346B4CFE3FD828EAA0C980B0F71B77_1936857206 = (newRs.isCsRestricted());
                                {
                                    setNotification(CS_ENABLED);
                                } //End block
                                {
                                    boolean varA6445632BAC49F059B36EB0EE223CBF3_615960174 = (newRs.isCsNormalRestricted());
                                    {
                                        setNotification(CS_NORMAL_ENABLED);
                                    } //End block
                                } //End collapsed parenthetic
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End block
                    {
                        boolean var8B9B8A10D1E1D0780F2ADC08103E1156_1001858145 = (!mRestrictedState.isCsEmergencyRestricted() &&
                    mRestrictedState.isCsNormalRestricted());
                        {
                            {
                                boolean var0C960E3B23E0FE22C0136CA55F39BD3C_2062615814 = (!newRs.isCsRestricted());
                                {
                                    setNotification(CS_DISABLED);
                                } //End block
                                {
                                    boolean var781BCA8B76F7E4DD7490A8CCA199987B_1206727324 = (newRs.isCsRestricted());
                                    {
                                        setNotification(CS_ENABLED);
                                    } //End block
                                    {
                                        boolean var8D1515582205D7E6089169936842A19F_397986599 = (newRs.isCsEmergencyRestricted());
                                        {
                                            setNotification(CS_EMERGENCY_ENABLED);
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End collapsed parenthetic
                            } //End collapsed parenthetic
                        } //End block
                        {
                            {
                                boolean var27346B4CFE3FD828EAA0C980B0F71B77_1519243233 = (newRs.isCsRestricted());
                                {
                                    setNotification(CS_ENABLED);
                                } //End block
                                {
                                    boolean varE95AEEA60DFE465EF47CAD9470E42413_1620949700 = (newRs.isCsEmergencyRestricted());
                                    {
                                        setNotification(CS_EMERGENCY_ENABLED);
                                    } //End block
                                    {
                                        boolean varEA89AD4C45E7AF96B724F608A04DFDEA_1452512798 = (newRs.isCsNormalRestricted());
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
        addTaint(ar.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.911 -0400", hash_original_method = "224D5C409E7F86CE5414891CFB70A981", hash_generated_method = "7B47F8E39466D9E98061C0DBB3E53FB2")
    private int regCodeToServiceState(int code) {
        //Begin case default 
        loge("regCodeToServiceState: unexpected service state " + code);
        //End case default 
        addTaint(code);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1428831599 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1428831599;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.924 -0400", hash_original_method = "19036A7D1DADA943DC912DAB6396B9AD", hash_generated_method = "82E2C1193D5FCF47665DB3C7F2AF6A0E")
    private boolean regCodeIsRoaming(int code) {
        addTaint(code);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1634524670 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1634524670;
        // ---------- Original Method ----------
        //return 5 == code;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.934 -0400", hash_original_method = "A83CC5F0F34C62E2D3BC7866CECAC756", hash_generated_method = "B200DD3BCCB905389C129B98FDF87169")
    private boolean isRoamingBetweenOperators(boolean gsmRoaming, ServiceState s) {
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
        addTaint(gsmRoaming);
        addTaint(s.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1331699472 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1331699472;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.935 -0400", hash_original_method = "462522C9E25E239E090C32F4DC1CCDBD", hash_generated_method = "6888D9D4F7E2D77139F35DFB0E601F28")
     int getCurrentGprsState() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1432665418 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1432665418;
        // ---------- Original Method ----------
        //return gprsState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.935 -0400", hash_original_method = "76A0DFDE7E82168261B9485993735FA8", hash_generated_method = "2CE3846315EF9BD264C88B3E611DD96B")
    public int getCurrentDataConnectionState() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1303739346 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1303739346;
        // ---------- Original Method ----------
        //return gprsState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.936 -0400", hash_original_method = "35025CCE5222CF7AFA718FFADECE80EF", hash_generated_method = "8B6F7CFCFFDAE203764E4F180E72691A")
    public boolean isConcurrentVoiceAndDataAllowed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1391577104 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1391577104;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.047 -0400", hash_original_method = "D8515350C34B3E7CC6A83CEBE4C1FE6C", hash_generated_method = "4620192D535EF8B48B435E5023013227")
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
                        boolean var8053821E6225ABE6D6EDD5F45C9DBCB8_1283319751 = (iso != null && iso.length() > 0);
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
                    boolean var624415BE8DA2189070E2F3831D7C1692_1755455307 = (getAutoTimeZone());
                    {
                        setAndBroadcastNetworkSetTimeZone(zone.getID());
                    } //End block
                } //End collapsed parenthetic
                saveNitzTimeZone(zone.getID());
            } //End block
            String ignore;
            ignore = SystemProperties.get("gsm.ignore-nitz");
            {
                boolean varE5D77747E14F70AD020ECEBD14623725_1825679162 = (ignore != null && ignore.equals("yes"));
                {
                    log("NITZ: Not setting clock because gsm.ignore-nitz is set");
                } //End block
            } //End collapsed parenthetic
            try 
            {
                mWakeLock.acquire();
                {
                    boolean varEEB7CD030807CE702D36FA7DEF7E06F9_419272430 = (getAutoTime());
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
        addTaint(nitz.getTaint());
        addTaint(nitzReceiveTime);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.055 -0400", hash_original_method = "10C2AC47FB9B2FA38284A276FBC39461", hash_generated_method = "5C40257B16167F37BCEFE9B72523520E")
    private boolean getAutoTime() {
        try 
        {
            boolean var0E961C85A40349516FBBBA448F8C2528_706426376 = (Settings.System.getInt(phone.getContext().getContentResolver(),
                    Settings.System.AUTO_TIME) > 0);
        } //End block
        catch (SettingNotFoundException snfe)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1870025452 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1870025452;
        // ---------- Original Method ----------
        //try {
            //return Settings.System.getInt(phone.getContext().getContentResolver(),
                    //Settings.System.AUTO_TIME) > 0;
        //} catch (SettingNotFoundException snfe) {
            //return true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.056 -0400", hash_original_method = "46367736BD7DFDD485A94174DBA3ECD3", hash_generated_method = "10CE1308CBFA16181FE5E3AF98EA4AFF")
    private boolean getAutoTimeZone() {
        try 
        {
            boolean var4E86644AAFB80825EAF556B6919FD175_1971125680 = (Settings.System.getInt(phone.getContext().getContentResolver(),
                    Settings.System.AUTO_TIME_ZONE) > 0);
        } //End block
        catch (SettingNotFoundException snfe)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_454377978 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_454377978;
        // ---------- Original Method ----------
        //try {
            //return Settings.System.getInt(phone.getContext().getContentResolver(),
                    //Settings.System.AUTO_TIME_ZONE) > 0;
        //} catch (SettingNotFoundException snfe) {
            //return true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.056 -0400", hash_original_method = "AC4D6B705E7065D39BD6B0621414F077", hash_generated_method = "89E6488BB9B703C7CA9BBABF73A30618")
    private void saveNitzTimeZone(String zoneId) {
        mSavedTimeZone = zoneId;
        // ---------- Original Method ----------
        //mSavedTimeZone = zoneId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.064 -0400", hash_original_method = "BBC081DF5E9AA5E0F675E4C4D97D41FA", hash_generated_method = "FA812F2463447E256E093AB70BACE34A")
    private void saveNitzTime(long time) {
        mSavedTime = time;
        mSavedAtTime = SystemClock.elapsedRealtime();
        // ---------- Original Method ----------
        //mSavedTime = time;
        //mSavedAtTime = SystemClock.elapsedRealtime();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.065 -0400", hash_original_method = "28A8B5328B033F98ED5E62B240AD20B6", hash_generated_method = "66F8BCE0B21D2935AA49F19A85909AFC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.066 -0400", hash_original_method = "062E38B571EEA7E979075562F8B40A5D", hash_generated_method = "D501F05FE0035386C06CD721A684230F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.076 -0400", hash_original_method = "2770201C4A137564A500CEEFB3D4E467", hash_generated_method = "ADD63199E5284B3C6A92B45BB70821A2")
    private void revertToNitzTime() {
        {
            boolean var2ACAD0BBF60577A314AB894E465C1761_809709289 = (Settings.System.getInt(phone.getContext().getContentResolver(),
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.077 -0400", hash_original_method = "846FA792EAB8BB56C921A6228BC9EB73", hash_generated_method = "99BB72D26285AC9511FA17F7C95ACD22")
    private void revertToNitzTimeZone() {
        {
            boolean var368E56141E4682CFD54AD9DE0B6F4586_1682861957 = (Settings.System.getInt(phone.getContext().getContentResolver(),
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.091 -0400", hash_original_method = "90EFCD7762032B11006E493EA631CF1F", hash_generated_method = "F3E7E970F65F9D82E60B1233BF98989B")
    private void setNotification(int notifyType) {
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
        addTaint(notifyType);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.091 -0400", hash_original_method = "4109BBDDE3BB927415F4177275F054A2", hash_generated_method = "F00A9135B0DCAA52FF85009B99A2E828")
    @Override
    protected void log(String s) {
        Log.d(LOG_TAG, "[GsmSST] " + s);
        addTaint(s.getTaint());
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[GsmSST] " + s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.092 -0400", hash_original_method = "E8A9D45B999B20E24B18F0E2F50C667F", hash_generated_method = "5D4ED3A9E70D2AABB538EA7C903DDA44")
    @Override
    protected void loge(String s) {
        addTaint(s.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[GsmSST] " + s);
    }

    
        private static void sloge(String s) {
        Log.e(LOG_TAG, "[GsmSST] " + s);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.092 -0400", hash_original_field = "41EBE7F32B96C1E2E9C209710486A443", hash_generated_field = "D3C0B237A982707BF0906F1B27E7321D")

    static String LOG_TAG = "GSM";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.092 -0400", hash_original_field = "A4622F7F72162611C8E075EE443BC26E", hash_generated_field = "BA31E82B2F843C2330C45AAEA0F35804")

    static boolean DBG = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.092 -0400", hash_original_field = "8AA5488317F9A54E56045D1AAF74BB75", hash_generated_field = "0B91C15402C3808CD55E3FD76F0A1C48")

    private static String WAKELOCK_TAG = "ServiceStateTracker";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.092 -0400", hash_original_field = "78DBFEDA4D4BF3B7443050756EB706DA", hash_generated_field = "F7F51E03D3811E2F5472837259B906D5")

    static int DEFAULT_GPRS_CHECK_PERIOD_MILLIS = 60 * 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.092 -0400", hash_original_field = "0EDCF36F1C7515917C6C8C6960C44E94", hash_generated_field = "F5AE3EBE58F63DC9AED1F19B0FD1150A")

    static int PS_ENABLED = 1001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.092 -0400", hash_original_field = "74ECF90DF353CA07A72C88F6756E63FD", hash_generated_field = "7D11F5EFE92A48F86CB9F808B46A880D")

    static int PS_DISABLED = 1002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.092 -0400", hash_original_field = "B3D8643D85377D116361C3F5C8140E0B", hash_generated_field = "2724692AF1D37FD5BBD0920540DA4570")

    static int CS_ENABLED = 1003;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.092 -0400", hash_original_field = "AE9874F242E8D117F7BAE3E010B557AB", hash_generated_field = "D62C1B1AF773C7B55AF3B843C1E15FCB")

    static int CS_DISABLED = 1004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.092 -0400", hash_original_field = "8B193C5B10382A1D1FD53AB21D3BD2E3", hash_generated_field = "F05212C15BD53C70BF668F7C64F2F549")

    static int CS_NORMAL_ENABLED = 1005;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.092 -0400", hash_original_field = "EEF6FD506D2FA8B090021A1D296EDD7B", hash_generated_field = "5731D64B5D31C9C4449A5920AE74DDFE")

    static int CS_EMERGENCY_ENABLED = 1006;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.092 -0400", hash_original_field = "ED6B67AB4D0B4DF3C237651AC21D2816", hash_generated_field = "2D3FF1E003F4A22DF09C519954D3123A")

    static int PS_NOTIFICATION = 888;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.092 -0400", hash_original_field = "97AFCBF220761A84FA450E75A3CE004D", hash_generated_field = "0934288EC390CA8A4150A1CA8DA04A7D")

    static int CS_NOTIFICATION = 999;
}

