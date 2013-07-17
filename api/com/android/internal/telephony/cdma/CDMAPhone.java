package com.android.internal.telephony.cdma;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.app.ActivityManagerNative;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.SQLException;
import android.net.Uri;
import android.os.AsyncResult;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.Registrant;
import android.os.RegistrantList;
import android.os.SystemProperties;
import android.preference.PreferenceManager;
import android.provider.Telephony;
import android.telephony.CellLocation;
import android.telephony.PhoneNumberUtils;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.text.TextUtils;
import android.util.Log;
import com.android.internal.telephony.Call;
import com.android.internal.telephony.CallStateException;
import com.android.internal.telephony.CallTracker;
import com.android.internal.telephony.CommandException;
import com.android.internal.telephony.CommandsInterface;
import com.android.internal.telephony.Connection;
import com.android.internal.telephony.IccException;
import com.android.internal.telephony.IccFileHandler;
import com.android.internal.telephony.IccPhoneBookInterfaceManager;
import com.android.internal.telephony.IccSmsInterfaceManager;
import com.android.internal.telephony.MccTable;
import com.android.internal.telephony.MmiCode;
import com.android.internal.telephony.OperatorInfo;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.PhoneBase;
import com.android.internal.telephony.PhoneNotifier;
import com.android.internal.telephony.PhoneProxy;
import com.android.internal.telephony.PhoneSubInfo;
import com.android.internal.telephony.ServiceStateTracker;
import com.android.internal.telephony.TelephonyIntents;
import com.android.internal.telephony.TelephonyProperties;
import com.android.internal.telephony.UUSInfo;
import com.android.internal.telephony.cat.CatService;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static com.android.internal.telephony.TelephonyProperties.PROPERTY_ICC_OPERATOR_ALPHA;
import static com.android.internal.telephony.TelephonyProperties.PROPERTY_ICC_OPERATOR_ISO_COUNTRY;
import static com.android.internal.telephony.TelephonyProperties.PROPERTY_ICC_OPERATOR_NUMERIC;

public class CDMAPhone extends PhoneBase {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.016 -0400", hash_original_field = "EA09C636C379E17EBA9E1A0866EC0796", hash_generated_field = "EC3246CB1DC699CB7AAC1E49E6B00916")

    private String mVmNumber = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.016 -0400", hash_original_field = "1D14D2D55BC367CD6AE3740CDB7152AF", hash_generated_field = "FB56FB2CCEDB5FF40D60B0E1FF012DC7")

    CdmaCallTracker mCT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.016 -0400", hash_original_field = "72BFF8190B34BEEE16406717B341412A", hash_generated_field = "97103F1B8DA1A01BC27456D6E3D45BD7")

    CdmaServiceStateTracker mSST;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.016 -0400", hash_original_field = "AF9E4B265579DF9690B194FA007294E8", hash_generated_field = "D1A76B98E2C9695E066872EF0F2A70D1")

    ArrayList <CdmaMmiCode> mPendingMmis = new ArrayList<CdmaMmiCode>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.016 -0400", hash_original_field = "5E8EA195206083E32FDBF6E6099D5D6E", hash_generated_field = "CC6C54ADD522D3CBE4AB79FC4C1AC885")

    RuimPhoneBookInterfaceManager mRuimPhoneBookInterfaceManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.016 -0400", hash_original_field = "A6CE63222F1F9B27D76D3EFFD0637A73", hash_generated_field = "52B0967754C377F16D6ECE26A27604BC")

    RuimSmsInterfaceManager mRuimSmsInterfaceManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.016 -0400", hash_original_field = "2C01F66E136181E8D582317306CCAC30", hash_generated_field = "F066FAD7B5AEEA27E2872ED159BF1CA4")

    PhoneSubInfo mSubInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.017 -0400", hash_original_field = "D2A1C9BF1A12B6A3A40E07BE541CCFEE", hash_generated_field = "5D6E15ED8D3AB433E5BB540845A155BB")

    EriManager mEriManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.017 -0400", hash_original_field = "69E45E7E240C011D8CB3CFDE90D76B33", hash_generated_field = "33E56F28B2B8FE4608887A854590880D")

    WakeLock mWakeLock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.017 -0400", hash_original_field = "74DE9B4DC153E7DBF167AFAC069421EB", hash_generated_field = "8E0942E84D2F17846D93DF1A3D310CA4")

    CatService mCcatService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.017 -0400", hash_original_field = "4CDA2C9561C6A6C20487424E5EB400E6", hash_generated_field = "962FB4C4696AA137E9F4B34F6067EBE9")

    private final RegistrantList mNvLoadedRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.017 -0400", hash_original_field = "42E8008744B539D2A4BE195C758A52AD", hash_generated_field = "FDA1F534CB258FBCC142BC692B71ACD1")

    private final RegistrantList mEriFileLoadedRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.017 -0400", hash_original_field = "E5961082E6F858D1F4DC7E89696FE2B2", hash_generated_field = "5B4BDBC7A862DE1A873EE80476741013")

    private final RegistrantList mEcmTimerResetRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.017 -0400", hash_original_field = "955CE82CD3A5151723EB19D6614F559B", hash_generated_field = "1771FD97E99F7F7ADB6C6B6F1AD7072C")

    private boolean mIsPhoneInEcmState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.017 -0400", hash_original_field = "0ED8E01E502CF8564596FEC2F99A39EF", hash_generated_field = "1BDAC9D71123A8DEB653B2C84AF01BA0")

    private Registrant mEcmExitRespRegistrant;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.017 -0400", hash_original_field = "453C2995A2CC7C51188981A0F3965EED", hash_generated_field = "A314A9B894E97303A992D075673C95F0")

    protected String mImei;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.017 -0400", hash_original_field = "225448F5B7EE27E6F9CC21B80A6466DB", hash_generated_field = "86781DA86EE57C5A1DD8A1C30699806C")

    protected String mImeiSv;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.017 -0400", hash_original_field = "941CECC3CFC825DE92ED3B472B7DE551", hash_generated_field = "D60FA66B4CDB744384FC242287466EE9")

    private String mEsn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.017 -0400", hash_original_field = "39E558836DC399944C3B0229DC5337CC", hash_generated_field = "4AF7BD5643CFD768CB253CD96C809185")

    private String mMeid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.017 -0400", hash_original_field = "9A2CB205F5ACBD0C68BA41B8A9632D2A", hash_generated_field = "317DA458812FD117268BB82503CFDA82")

    private String mCarrierOtaSpNumSchema;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.000 -0400", hash_original_field = "5E0153DE5EDFE60861980DB630071DCD", hash_generated_field = "A9D48B4F37E6DEE9FEDDDBF0EA9949F0")

    private Runnable mExitEcmRunnable = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.000 -0400", hash_original_method = "F3DC5BFDA25D02344EBFE8F4AEC767D8", hash_generated_method = "13E58FFF08C64D739C7C2CEA1DFD40E8")
        @Override
        public void run() {
            exitEmergencyCallbackMode();
            
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.018 -0400", hash_original_field = "B70FAC06870FA211D668F462A2DBA212", hash_generated_field = "126D29D3ACD6141B3CF1C156D9BC8C27")

    Registrant mPostDialHandler;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.018 -0400", hash_original_method = "DAE6B8BFE7F70789DB7C3B99D4D5F7DA", hash_generated_method = "E1CBC30F5A7BB640F8E32B1EB6416DE7")
    public  CDMAPhone(Context context, CommandsInterface ci, PhoneNotifier notifier) {
        super(notifier, context, ci, false);
        addTaint(notifier.getTaint());
        addTaint(ci.getTaint());
        addTaint(context.getTaint());
        initSstIcc();
        init(context, notifier);
        // ---------- Original Method ----------
        //initSstIcc();
        //init(context, notifier);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.019 -0400", hash_original_method = "467D4326BF1EF0C31B8D509189D4E2E0", hash_generated_method = "6BD333524F759DB1B14BD8403752DEAE")
    public  CDMAPhone(Context context, CommandsInterface ci, PhoneNotifier notifier,
            boolean unitTestMode) {
        super(notifier, context, ci, unitTestMode);
        addTaint(unitTestMode);
        addTaint(notifier.getTaint());
        addTaint(ci.getTaint());
        addTaint(context.getTaint());
        initSstIcc();
        init(context, notifier);
        // ---------- Original Method ----------
        //initSstIcc();
        //init(context, notifier);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.020 -0400", hash_original_method = "1B7DFBB42AE4FBFECC004BFFF3CFFDDB", hash_generated_method = "EC0DA6F48DC1646B607F03DA38DBAF6C")
    protected void initSstIcc() {
        mSST = new CdmaServiceStateTracker(this);
        mIccRecords = new RuimRecords(this);
        mIccCard = new RuimCard(this, LOG_TAG, DBG);
        mIccFileHandler = new RuimFileHandler(this);
        // ---------- Original Method ----------
        //mSST = new CdmaServiceStateTracker(this);
        //mIccRecords = new RuimRecords(this);
        //mIccCard = new RuimCard(this, LOG_TAG, DBG);
        //mIccFileHandler = new RuimFileHandler(this);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.022 -0400", hash_original_method = "8461B888D034831850AE73E07FC3F149", hash_generated_method = "B1D2B03FC110C2663FA18EA5DE77A9F3")
    protected void init(Context context, PhoneNotifier notifier) {
        addTaint(notifier.getTaint());
        mCM.setPhoneType(Phone.PHONE_TYPE_CDMA);
        mCT = new CdmaCallTracker(this);
        mSMS = new CdmaSMSDispatcher(this, mSmsStorageMonitor, mSmsUsageMonitor);
        mDataConnectionTracker = new CdmaDataConnectionTracker (this);
        mRuimPhoneBookInterfaceManager = new RuimPhoneBookInterfaceManager(this);
        mRuimSmsInterfaceManager = new RuimSmsInterfaceManager(this, mSMS);
        mSubInfo = new PhoneSubInfo(this);
        mEriManager = new EriManager(this, context, EriManager.ERI_FROM_XML);
        mCcatService = CatService.getInstance(mCM, mIccRecords, mContext,
                mIccFileHandler, mIccCard);
        mCM.registerForAvailable(this, EVENT_RADIO_AVAILABLE, null);
        mIccRecords.registerForRecordsLoaded(this, EVENT_RUIM_RECORDS_LOADED, null);
        mCM.registerForOffOrNotAvailable(this, EVENT_RADIO_OFF_OR_NOT_AVAILABLE, null);
        mCM.registerForOn(this, EVENT_RADIO_ON, null);
        mCM.setOnSuppServiceNotification(this, EVENT_SSN, null);
        mSST.registerForNetworkAttached(this, EVENT_REGISTERED_TO_NETWORK, null);
        mCM.registerForNVReady(this, EVENT_NV_READY, null);
        mCM.setEmergencyCallbackMode(this, EVENT_EMERGENCY_CALLBACK_MODE_ENTER, null);
        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        mWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,LOG_TAG);
        SystemProperties.set(TelephonyProperties.CURRENT_ACTIVE_PHONE,
                Integer.toString(Phone.PHONE_TYPE_CDMA));
        String inEcm = SystemProperties.get(TelephonyProperties.PROPERTY_INECM_MODE, "false");
        mIsPhoneInEcmState = inEcm.equals("true");
        if(mIsPhoneInEcmState)        
        {
            mCM.exitEmergencyCallbackMode(obtainMessage(EVENT_EXIT_EMERGENCY_CALLBACK_RESPONSE));
        } //End block
        mCarrierOtaSpNumSchema = SystemProperties.get(
                TelephonyProperties.PROPERTY_OTASP_NUM_SCHEMA,"");
        String operatorAlpha = SystemProperties.get("ro.cdma.home.operator.alpha");
        setSystemProperty(PROPERTY_ICC_OPERATOR_ALPHA, operatorAlpha);
        String operatorNumeric = SystemProperties.get(PROPERTY_CDMA_HOME_OPERATOR_NUMERIC);
        setSystemProperty(PROPERTY_ICC_OPERATOR_NUMERIC, operatorNumeric);
        setIsoCountryProperty(operatorNumeric);
        updateCurrentCarrierInProvider(operatorNumeric);
        notifier.notifyMessageWaitingChanged(this);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.023 -0400", hash_original_method = "9DE3C78959AC59CCA27F149210FA77A8", hash_generated_method = "76A426C4B62C7D16EDE37B1A09C2DB73")
    @Override
    public void dispose() {
        synchronized
(PhoneProxy.lockForRadioTechnologyChange)        {
            super.dispose();
            log("dispose");
            mIccRecords.unregisterForRecordsLoaded(this);
            mCM.unregisterForAvailable(this);
            mCM.unregisterForOffOrNotAvailable(this);
            mCM.unregisterForOn(this);
            mCM.unregisterForNVReady(this);
            mSST.unregisterForNetworkAttached(this);
            mCM.unSetOnSuppServiceNotification(this);
            removeCallbacks(mExitEcmRunnable);
            mPendingMmis.clear();
            mCT.dispose();
            mDataConnectionTracker.dispose();
            mSST.dispose();
            mSMS.dispose();
            mIccFileHandler.dispose();
            mIccRecords.dispose();
            mIccCard.dispose();
            mRuimPhoneBookInterfaceManager.dispose();
            mRuimSmsInterfaceManager.dispose();
            mSubInfo.dispose();
            mEriManager.dispose();
            mCcatService.dispose();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.024 -0400", hash_original_method = "EE2FF8AAD85928FB8E8B4233881FEB3A", hash_generated_method = "123CADA6CF62D4FBD8FD71E77576DE69")
    @Override
    public void removeReferences() {
        log("removeReferences");
        super.removeReferences();
        mRuimPhoneBookInterfaceManager = null;
        mRuimSmsInterfaceManager = null;
        mSMS = null;
        mSubInfo = null;
        mIccRecords = null;
        mIccFileHandler = null;
        mIccCard = null;
        mDataConnectionTracker = null;
        mCT = null;
        mSST = null;
        mEriManager = null;
        mCcatService = null;
        mExitEcmRunnable = null;
        // ---------- Original Method ----------
        //log("removeReferences");
        //super.removeReferences();
        //mRuimPhoneBookInterfaceManager = null;
        //mRuimSmsInterfaceManager = null;
        //mSMS = null;
        //mSubInfo = null;
        //mIccRecords = null;
        //mIccFileHandler = null;
        //mIccCard = null;
        //mDataConnectionTracker = null;
        //mCT = null;
        //mSST = null;
        //mEriManager = null;
        //mCcatService = null;
        //mExitEcmRunnable = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.025 -0400", hash_original_method = "717E537581BE31A7DC523FEE6B0DDE4B", hash_generated_method = "40BA020E777877F748174B380513E711")
    @Override
    protected void finalize() {
        if(DBG)        
        Log.d(LOG_TAG, "CDMAPhone finalized");
        if(mWakeLock.isHeld())        
        {
            mWakeLock.release();
        } //End block
        // ---------- Original Method ----------
        //if(DBG) Log.d(LOG_TAG, "CDMAPhone finalized");
        //if (mWakeLock.isHeld()) {
            //Log.e(LOG_TAG, "UNEXPECTED; mWakeLock is held when finalizing.");
            //mWakeLock.release();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.025 -0400", hash_original_method = "DA0F221C2247572C4D631280E4033E9A", hash_generated_method = "6EEE751B97E397BCCFD702E857077E38")
    public ServiceState getServiceState() {
ServiceState varB63DD69AFCB2944A942E2A441DF92309_1285683425 =         mSST.ss;
        varB63DD69AFCB2944A942E2A441DF92309_1285683425.addTaint(taint);
        return varB63DD69AFCB2944A942E2A441DF92309_1285683425;
        // ---------- Original Method ----------
        //return mSST.ss;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.025 -0400", hash_original_method = "79AFD9B845E4547B981131DAC9E3A14D", hash_generated_method = "66161BBDB23D190C04C89336618483FD")
    public CallTracker getCallTracker() {
CallTracker var3528ED268C30F3C1C217C40E97751AC8_1910477829 =         mCT;
        var3528ED268C30F3C1C217C40E97751AC8_1910477829.addTaint(taint);
        return var3528ED268C30F3C1C217C40E97751AC8_1910477829;
        // ---------- Original Method ----------
        //return mCT;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.025 -0400", hash_original_method = "8AEFB373111A9C8AD30F3E8C75C461D2", hash_generated_method = "FB7159AF57FCB56E68A7F40DE8863D49")
    public Phone.State getState() {
Phone.State var76BC78A6228F2C8635D3A39BC739D237_1985741496 =         mCT.state;
        var76BC78A6228F2C8635D3A39BC739D237_1985741496.addTaint(taint);
        return var76BC78A6228F2C8635D3A39BC739D237_1985741496;
        // ---------- Original Method ----------
        //return mCT.state;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.026 -0400", hash_original_method = "BD481539215D5A66E62B4E6909625141", hash_generated_method = "FFC733A8C0450CA9A27F6C9FE8B82C74")
    public ServiceStateTracker getServiceStateTracker() {
ServiceStateTracker var615613A1D046F80E6B9B13A16A2791AB_416826795 =         mSST;
        var615613A1D046F80E6B9B13A16A2791AB_416826795.addTaint(taint);
        return var615613A1D046F80E6B9B13A16A2791AB_416826795;
        // ---------- Original Method ----------
        //return mSST;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.026 -0400", hash_original_method = "B0BDAF041F7F636A26D0F46F60D4BC7B", hash_generated_method = "F65A1FB38D725D2DE3791F6EF8FE5411")
    public String getPhoneName() {
String var77216E4A335D5B3A7C364F52611910E2_33620220 =         "CDMA";
        var77216E4A335D5B3A7C364F52611910E2_33620220.addTaint(taint);
        return var77216E4A335D5B3A7C364F52611910E2_33620220;
        // ---------- Original Method ----------
        //return "CDMA";
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.026 -0400", hash_original_method = "94F6AF6179535CBD756D5B387D52C3CA", hash_generated_method = "34D9D2C455C1FB3B2824EF1E97ABC18F")
    public int getPhoneType() {
        int var3567B9B06A39177B1F7C97FBD481DDCF_2120481854 = (Phone.PHONE_TYPE_CDMA);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_4990869 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_4990869;
        // ---------- Original Method ----------
        //return Phone.PHONE_TYPE_CDMA;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.026 -0400", hash_original_method = "F828A2F1845194FFD82C471D7E89F726", hash_generated_method = "173A6D3C0BAD82DDCD6859C82B32F758")
    public boolean canTransfer() {
        boolean var68934A3E9455FA72420237EB05902327_768671745 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1373974469 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1373974469;
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "canTransfer: not possible in CDMA");
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.027 -0400", hash_original_method = "31E0316605311F71BD2BE82139C4C7B1", hash_generated_method = "0FF02D5080F99F988F270D9ADDC99E28")
    public CdmaCall getRingingCall() {
CdmaCall var0C933E5C350902B3323CAF4D9F4DBF29_1146565148 =         mCT.ringingCall;
        var0C933E5C350902B3323CAF4D9F4DBF29_1146565148.addTaint(taint);
        return var0C933E5C350902B3323CAF4D9F4DBF29_1146565148;
        // ---------- Original Method ----------
        //return mCT.ringingCall;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.027 -0400", hash_original_method = "E892EC268DCFDF5C9C27A7DDC7E00573", hash_generated_method = "6619A2B15F7D54045D03352B752C3F87")
    public void setMute(boolean muted) {
        addTaint(muted);
        mCT.setMute(muted);
        // ---------- Original Method ----------
        //mCT.setMute(muted);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.027 -0400", hash_original_method = "FA6E824680C8944626A1A959DCEA6499", hash_generated_method = "C1AEADCEF123D58B837D17FFDA8C4280")
    public boolean getMute() {
        boolean varA6D59716EFBEAD6BC174CD94D4F29A83_534490590 = (mCT.getMute());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1510057756 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1510057756;
        // ---------- Original Method ----------
        //return mCT.getMute();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.027 -0400", hash_original_method = "593DDE28AC9DCA9096C93A9D0D1099FC", hash_generated_method = "EFBC49A5AD73E9A3CBDEEDFF40E8B0EA")
    public void conference() throws CallStateException {
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "conference: not possible in CDMA");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.028 -0400", hash_original_method = "F90799FAE99EB431CF7F205DFD6DDD5D", hash_generated_method = "166634301FF051643358E48E3562B632")
    public void enableEnhancedVoicePrivacy(boolean enable, Message onComplete) {
        addTaint(onComplete.getTaint());
        addTaint(enable);
        this.mCM.setPreferredVoicePrivacy(enable, onComplete);
        // ---------- Original Method ----------
        //this.mCM.setPreferredVoicePrivacy(enable, onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.028 -0400", hash_original_method = "5CE753EAA3145BBCA6A00800B2884B4E", hash_generated_method = "BE100CC76DE6657A1A23222F7BBD5BBD")
    public void getEnhancedVoicePrivacy(Message onComplete) {
        addTaint(onComplete.getTaint());
        this.mCM.getPreferredVoicePrivacy(onComplete);
        // ---------- Original Method ----------
        //this.mCM.getPreferredVoicePrivacy(onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.028 -0400", hash_original_method = "B9932A8A8BD16A4F0D461DDC6FDE6B49", hash_generated_method = "BEFA10EB4DBC56DB633604D1159E6D30")
    public void clearDisconnected() {
        mCT.clearDisconnected();
        // ---------- Original Method ----------
        //mCT.clearDisconnected();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.029 -0400", hash_original_method = "34BFC6F1F77B77A760EA5A249CE3FEFD", hash_generated_method = "B01D90CF0917EBEA04004E6868795B6D")
    public DataActivityState getDataActivityState() {
        DataActivityState ret = DataActivityState.NONE;
        if(mSST.getCurrentDataConnectionState() == ServiceState.STATE_IN_SERVICE)        
        {
switch(mDataConnectionTracker.getActivity()){
            case DATAIN:
            ret = DataActivityState.DATAIN;
            break;
            case DATAOUT:
            ret = DataActivityState.DATAOUT;
            break;
            case DATAINANDOUT:
            ret = DataActivityState.DATAINANDOUT;
            break;
            case DORMANT:
            ret = DataActivityState.DORMANT;
            break;
}
        } //End block
DataActivityState varEDFF4FBBF053B5DC2B444ADFA049EE0F_283028792 =         ret;
        varEDFF4FBBF053B5DC2B444ADFA049EE0F_283028792.addTaint(taint);
        return varEDFF4FBBF053B5DC2B444ADFA049EE0F_283028792;
        // ---------- Original Method ----------
        //DataActivityState ret = DataActivityState.NONE;
        //if (mSST.getCurrentDataConnectionState() == ServiceState.STATE_IN_SERVICE) {
            //switch (mDataConnectionTracker.getActivity()) {
                //case DATAIN:
                    //ret = DataActivityState.DATAIN;
                //break;
                //case DATAOUT:
                    //ret = DataActivityState.DATAOUT;
                //break;
                //case DATAINANDOUT:
                    //ret = DataActivityState.DATAINANDOUT;
                //break;
                //case DORMANT:
                    //ret = DataActivityState.DORMANT;
                //break;
            //}
        //}
        //return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.029 -0400", hash_original_method = "FCBAE539BB72BE21647FF37299DC2B96", hash_generated_method = "0C6B7A0FF6350CF17887F3D234BB96C8")
     void notifySignalStrength() {
        mNotifier.notifySignalStrength(this);
        // ---------- Original Method ----------
        //mNotifier.notifySignalStrength(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.029 -0400", hash_original_method = "3B6D00BA5404778271A196326B2492C1", hash_generated_method = "8A57BFE29AD10D0A3A0D8B4CB3900F7F")
    public Connection dial(String dialString) throws CallStateException {
        addTaint(dialString.getTaint());
        String newDialString = PhoneNumberUtils.stripSeparators(dialString);
Connection var4B126064346A3A5A755B1CEEA9715364_1424696604 =         mCT.dial(newDialString);
        var4B126064346A3A5A755B1CEEA9715364_1424696604.addTaint(taint);
        return var4B126064346A3A5A755B1CEEA9715364_1424696604;
        // ---------- Original Method ----------
        //String newDialString = PhoneNumberUtils.stripSeparators(dialString);
        //return mCT.dial(newDialString);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.030 -0400", hash_original_method = "C4CAEF0C07F27C620A5D9B835D3227D9", hash_generated_method = "60652D385BF2CB56196437D4B513A552")
    public Connection dial(String dialString, UUSInfo uusInfo) throws CallStateException {
        addTaint(uusInfo.getTaint());
        addTaint(dialString.getTaint());
        CallStateException var105A6DDF0E50A04ABFF56D79C54E96D9_109719858 = new CallStateException("Sending UUS information NOT supported in CDMA!");
        var105A6DDF0E50A04ABFF56D79C54E96D9_109719858.addTaint(taint);
        throw var105A6DDF0E50A04ABFF56D79C54E96D9_109719858;
        // ---------- Original Method ----------
        //throw new CallStateException("Sending UUS information NOT supported in CDMA!");
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.030 -0400", hash_original_method = "46D9BC6E3280014832CD8FC523C20E6E", hash_generated_method = "02515C8343FF8583BA87FCE5A29826FD")
    public SignalStrength getSignalStrength() {
SignalStrength varD5A83A3C6D3D3BC3F870FC808BD3DAF7_616778466 =         mSST.mSignalStrength;
        varD5A83A3C6D3D3BC3F870FC808BD3DAF7_616778466.addTaint(taint);
        return varD5A83A3C6D3D3BC3F870FC808BD3DAF7_616778466;
        // ---------- Original Method ----------
        //return mSST.mSignalStrength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.030 -0400", hash_original_method = "391334830335544CEFDB5805671813C7", hash_generated_method = "DD14DF5EF7CE2635BC6F5FD00D6ADD88")
    public boolean getMessageWaitingIndicator() {
        boolean varC3BCD11E53A48FF3A5E60C41FC7F2DA8_177302282 = ((getVoiceMessageCount() > 0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1814062676 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1814062676;
        // ---------- Original Method ----------
        //return (getVoiceMessageCount() > 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.030 -0400", hash_original_method = "A1DC624417B44DF11F4CA5E5B97277AF", hash_generated_method = "454E6ECB6CD88C6A82FC08B14714D181")
    public List<? extends MmiCode> getPendingMmiCodes() {
List<? extends MmiCode> var3ABA598F70BB314EB4CF2CEF54338041_277187875 =         mPendingMmis;
        var3ABA598F70BB314EB4CF2CEF54338041_277187875.addTaint(taint);
        return var3ABA598F70BB314EB4CF2CEF54338041_277187875;
        // ---------- Original Method ----------
        //return mPendingMmis;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.031 -0400", hash_original_method = "7C5A8D3C952528E3E4A994337305A33B", hash_generated_method = "A510A573445795999F66AE97FB44BC3A")
    public void registerForSuppServiceNotification(
            Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "method registerForSuppServiceNotification is NOT supported in CDMA!");
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.031 -0400", hash_original_method = "9F7E8D6F89A6C75F0A7653B179AA02CE", hash_generated_method = "1B6D2300B4E033377B0F6F71559EAE3A")
    public CdmaCall getBackgroundCall() {
CdmaCall var6A75FAAFEF760596343E2AE0F8499357_137341443 =         mCT.backgroundCall;
        var6A75FAAFEF760596343E2AE0F8499357_137341443.addTaint(taint);
        return var6A75FAAFEF760596343E2AE0F8499357_137341443;
        // ---------- Original Method ----------
        //return mCT.backgroundCall;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.031 -0400", hash_original_method = "99F7E880D5431452FB99636E33872BD4", hash_generated_method = "AEA3451A57A3FA6FC4F252E42A7B6105")
    public boolean handleInCallMmiCommands(String dialString) {
        addTaint(dialString.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_2108939341 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2059924225 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2059924225;
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "method handleInCallMmiCommands is NOT supported in CDMA!");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.031 -0400", hash_original_method = "F6112A9AE3405415322B12D2CA172B80", hash_generated_method = "9EDC40743239412885A99364DE71B956")
     boolean isInCall() {
        CdmaCall.State foregroundCallState = getForegroundCall().getState();
        CdmaCall.State backgroundCallState = getBackgroundCall().getState();
        CdmaCall.State ringingCallState = getRingingCall().getState();
        boolean var3FF433C767F318D2903F5F2792E48F32_44483495 = ((foregroundCallState.isAlive() || backgroundCallState.isAlive() || ringingCallState
                .isAlive()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1863348675 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1863348675;
        // ---------- Original Method ----------
        //CdmaCall.State foregroundCallState = getForegroundCall().getState();
        //CdmaCall.State backgroundCallState = getBackgroundCall().getState();
        //CdmaCall.State ringingCallState = getRingingCall().getState();
        //return (foregroundCallState.isAlive() || backgroundCallState.isAlive() || ringingCallState
                //.isAlive());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.031 -0400", hash_original_method = "573D1DDDB474C2914324D2DBB21AD4BF", hash_generated_method = "DA6E2EE7F182C05429B80E37E1A19F32")
    public void setNetworkSelectionModeAutomatic(Message response) {
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "method setNetworkSelectionModeAutomatic is NOT supported in CDMA!");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.031 -0400", hash_original_method = "7239EAF7B36D814AB7CF7CD5314FF0C2", hash_generated_method = "CFC7F3A052695995B32633E4C83F6A7E")
    public void unregisterForSuppServiceNotification(Handler h) {
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "method unregisterForSuppServiceNotification is NOT supported in CDMA!");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.032 -0400", hash_original_method = "C62CCD6CF2D9D7F7FA17BB7B58067AAC", hash_generated_method = "229941362132B3EA463C13061274E96C")
    public void acceptCall() throws CallStateException {
        mCT.acceptCall();
        // ---------- Original Method ----------
        //mCT.acceptCall();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.032 -0400", hash_original_method = "A64616985F0D82C6750D71CF8DADC6F4", hash_generated_method = "35B0F59F3248405A594AAB683856BD2F")
    public void rejectCall() throws CallStateException {
        mCT.rejectCall();
        // ---------- Original Method ----------
        //mCT.rejectCall();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.032 -0400", hash_original_method = "4BD56579DA53A7A8E0646A63E1978FC8", hash_generated_method = "4EFDBB8DAC4DC308937F3C30BD26241D")
    public void switchHoldingAndActive() throws CallStateException {
        mCT.switchWaitingOrHoldingAndActive();
        // ---------- Original Method ----------
        //mCT.switchWaitingOrHoldingAndActive();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.033 -0400", hash_original_method = "B121BB30C6EA08968FF3C722126FC795", hash_generated_method = "41F5773ABE503A75D375ECD5FBE46CA0")
    public String getLine1Number() {
String varE97F7B3B6A20D820724012E98E1F8E03_457116782 =         mSST.getMdnNumber();
        varE97F7B3B6A20D820724012E98E1F8E03_457116782.addTaint(taint);
        return varE97F7B3B6A20D820724012E98E1F8E03_457116782;
        // ---------- Original Method ----------
        //return mSST.getMdnNumber();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.033 -0400", hash_original_method = "3BC6D82D8BFD82220414E9A1151516B0", hash_generated_method = "FB5554922C7E2D1D910F6C84B2CCDF08")
    public String getCdmaPrlVersion() {
String varFE002F74B1C3FF8BF16B25E86A8AD371_16136602 =         mSST.getPrlVersion();
        varFE002F74B1C3FF8BF16B25E86A8AD371_16136602.addTaint(taint);
        return varFE002F74B1C3FF8BF16B25E86A8AD371_16136602;
        // ---------- Original Method ----------
        //return mSST.getPrlVersion();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.033 -0400", hash_original_method = "5F3989DCB2E6CEB13D99C9EB5DB3E7E9", hash_generated_method = "AB8A3E0A161095B4BB538A6B81FDDD65")
    public String getCdmaMin() {
String var5AC22B81138A6FAC66E0CD92843405D6_1337875057 =         mSST.getCdmaMin();
        var5AC22B81138A6FAC66E0CD92843405D6_1337875057.addTaint(taint);
        return var5AC22B81138A6FAC66E0CD92843405D6_1337875057;
        // ---------- Original Method ----------
        //return mSST.getCdmaMin();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.034 -0400", hash_original_method = "8703C344BAEB4A9DC4BE8D85F2A2B471", hash_generated_method = "13D8A4B4AC5A58226B815149DC893454")
    public boolean isMinInfoReady() {
        boolean var6FB33487AA0AE1B58AB188DB35DB735B_561196338 = (mSST.isMinInfoReady());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1261733860 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1261733860;
        // ---------- Original Method ----------
        //return mSST.isMinInfoReady();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.034 -0400", hash_original_method = "4561349219664D3BF60D1FEC45B8BB02", hash_generated_method = "6C7C08C4A90FAFEF506342CC79180D44")
    public void getCallWaiting(Message onComplete) {
        addTaint(onComplete.getTaint());
        mCM.queryCallWaiting(CommandsInterface.SERVICE_CLASS_VOICE, onComplete);
        // ---------- Original Method ----------
        //mCM.queryCallWaiting(CommandsInterface.SERVICE_CLASS_VOICE, onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.034 -0400", hash_original_method = "6583EBFAAE11F5B271B0C202AB11C3E9", hash_generated_method = "40BF0BF01FE4299F00D19584AD116527")
    public void setRadioPower(boolean power) {
        addTaint(power);
        mSST.setRadioPower(power);
        // ---------- Original Method ----------
        //mSST.setRadioPower(power);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.035 -0400", hash_original_method = "A71BC42B8E5B39F885F4E0F3CDCE1523", hash_generated_method = "7FA1B9B1E1C994B7A91197F2D9A4A638")
    public String getEsn() {
String varA2BBC39B293E8C3A152F96E6F2A19C35_514883452 =         mEsn;
        varA2BBC39B293E8C3A152F96E6F2A19C35_514883452.addTaint(taint);
        return varA2BBC39B293E8C3A152F96E6F2A19C35_514883452;
        // ---------- Original Method ----------
        //return mEsn;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.035 -0400", hash_original_method = "7E7AAA89C01F3229F1902E361A6CD86F", hash_generated_method = "61E1745031BF35BF015803B5A4BC8FBB")
    public String getMeid() {
String varAC51F00EE65912EA40DAE9565FAFC3C1_502917886 =         mMeid;
        varAC51F00EE65912EA40DAE9565FAFC3C1_502917886.addTaint(taint);
        return varAC51F00EE65912EA40DAE9565FAFC3C1_502917886;
        // ---------- Original Method ----------
        //return mMeid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.035 -0400", hash_original_method = "7766C412A244B7E9ACAC69FB73BBB546", hash_generated_method = "BD70881D74A840A5943ED3D6F90FEDFE")
    public String getDeviceId() {
        String id = getMeid();
        if((id == null) || id.matches("^0*$"))        
        {
            Log.d(LOG_TAG, "getDeviceId(): MEID is not initialized use ESN");
            id = getEsn();
        } //End block
String var6481E79D4B9F990E7C69C0523E4A3DFE_222521428 =         id;
        var6481E79D4B9F990E7C69C0523E4A3DFE_222521428.addTaint(taint);
        return var6481E79D4B9F990E7C69C0523E4A3DFE_222521428;
        // ---------- Original Method ----------
        //String id = getMeid();
        //if ((id == null) || id.matches("^0*$")) {
            //Log.d(LOG_TAG, "getDeviceId(): MEID is not initialized use ESN");
            //id = getEsn();
        //}
        //return id;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.036 -0400", hash_original_method = "BA19C271165532D38DF9C2A2EC7580FC", hash_generated_method = "E5DEEC1CA8B31963E41978F77691DEF0")
    public String getDeviceSvn() {
        Log.d(LOG_TAG, "getDeviceSvn(): return 0");
String var50F9DEEC38DD489662C457BCE7AD28CE_922617291 =         "0";
        var50F9DEEC38DD489662C457BCE7AD28CE_922617291.addTaint(taint);
        return var50F9DEEC38DD489662C457BCE7AD28CE_922617291;
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "getDeviceSvn(): return 0");
        //return "0";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.036 -0400", hash_original_method = "32994E1C8E091DA1F8318F6B29B65F50", hash_generated_method = "E332BAD6DB34C56E07C9C183DB600603")
    public String getSubscriberId() {
String var88BB1E5A1962B28B215DD215BB24805B_456039148 =         mSST.getImsi();
        var88BB1E5A1962B28B215DD215BB24805B_456039148.addTaint(taint);
        return var88BB1E5A1962B28B215DD215BB24805B_456039148;
        // ---------- Original Method ----------
        //return mSST.getImsi();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.036 -0400", hash_original_method = "FAD82CEAF9DD41800ADBC5F4734356D8", hash_generated_method = "8B067F430FCFC29A24CFAE567E02F5EB")
    public String getImei() {
String var540C13E9E156B687226421B24F2DF178_430544572 =         null;
        var540C13E9E156B687226421B24F2DF178_430544572.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_430544572;
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "IMEI is not available in CDMA");
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.036 -0400", hash_original_method = "3D81DB016065E96128526DD50CCAAE05", hash_generated_method = "EEDF276454048E8343FC76716F9E23C5")
    public boolean canConference() {
        boolean var68934A3E9455FA72420237EB05902327_1809271666 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_285750955 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_285750955;
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "canConference: not possible in CDMA");
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.036 -0400", hash_original_method = "E38329BE2FF507326358BBAF596945E6", hash_generated_method = "4B33D7E697ACFBE7F01AF41406DCFD00")
    public CellLocation getCellLocation() {
CellLocation var99C49AD3DE160D9A941A8CB95CA2CC55_156712470 =         mSST.cellLoc;
        var99C49AD3DE160D9A941A8CB95CA2CC55_156712470.addTaint(taint);
        return var99C49AD3DE160D9A941A8CB95CA2CC55_156712470;
        // ---------- Original Method ----------
        //return mSST.cellLoc;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.037 -0400", hash_original_method = "5D417D4C057D78BF0DEF3D949E557B3C", hash_generated_method = "4DE62BADA2201E832293ADA8FF7A18A3")
    public CdmaCall getForegroundCall() {
CdmaCall var27EE6C6A3390EC6B8D26B508C9FD500B_1035979272 =         mCT.foregroundCall;
        var27EE6C6A3390EC6B8D26B508C9FD500B_1035979272.addTaint(taint);
        return var27EE6C6A3390EC6B8D26B508C9FD500B_1035979272;
        // ---------- Original Method ----------
        //return mCT.foregroundCall;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.037 -0400", hash_original_method = "6287E103949DE4B29FC1760D95391284", hash_generated_method = "E6E3DDF268B4B202DFEB8DF9FA84A417")
    public void selectNetworkManually(OperatorInfo network,
            Message response) {
        addTaint(response.getTaint());
        addTaint(network.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "selectNetworkManually: not possible in CDMA");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.037 -0400", hash_original_method = "A54F4B18F21B3A39961648F4BDA2F061", hash_generated_method = "0D9A74204B6FB987A29697E2CA304A25")
    public void setOnPostDialCharacter(Handler h, int what, Object obj) {
        mPostDialHandler = new Registrant(h, what, obj);
        // ---------- Original Method ----------
        //mPostDialHandler = new Registrant(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.038 -0400", hash_original_method = "3D832E28FC020C3451E1ECD577F7705D", hash_generated_method = "31B5048AED96367F33EE954A53B164AF")
    public boolean handlePinMmi(String dialString) {
        addTaint(dialString.getTaint());
        CdmaMmiCode mmi = CdmaMmiCode.newFromDialString(dialString, this);
        if(mmi == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_2071667682 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_916502495 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_916502495;
        } //End block
        else
        if(mmi.isPukCommand())        
        {
            mPendingMmis.add(mmi);
            mMmiRegistrants.notifyRegistrants(new AsyncResult(null, mmi, null));
            mmi.processCode();
            boolean varB326B5062B2F0E69046810717534CB09_178051049 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1856750996 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1856750996;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1429183344 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_618662922 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_618662922;
        // ---------- Original Method ----------
        //CdmaMmiCode mmi = CdmaMmiCode.newFromDialString(dialString, this);
        //if (mmi == null) {
            //Log.e(LOG_TAG, "Mmi is NULL!");
            //return false;
        //} else if (mmi.isPukCommand()) {
            //mPendingMmis.add(mmi);
            //mMmiRegistrants.notifyRegistrants(new AsyncResult(null, mmi, null));
            //mmi.processCode();
            //return true;
        //}
        //Log.e(LOG_TAG, "Unrecognized mmi!");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.039 -0400", hash_original_method = "574EFAE567BAC054324E4789AB0ACA21", hash_generated_method = "764FAAEA4DD4B55527F82E0500F98256")
     void onMMIDone(CdmaMmiCode mmi) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(mmi.getTaint());
        if(mPendingMmis.remove(mmi))        
        {
            mMmiCompleteRegistrants.notifyRegistrants(new AsyncResult(null, mmi, null));
        } //End block
        // ---------- Original Method ----------
        //if (mPendingMmis.remove(mmi)) {
            //mMmiCompleteRegistrants.notifyRegistrants(new AsyncResult(null, mmi, null));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.039 -0400", hash_original_method = "8885A01E1E8D54116E470B45B5958287", hash_generated_method = "3E18B430F1DC3D5E99898E5BCDA342C5")
    public void setLine1Number(String alphaTag, String number, Message onComplete) {
        addTaint(onComplete.getTaint());
        addTaint(number.getTaint());
        addTaint(alphaTag.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "setLine1Number: not possible in CDMA");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.039 -0400", hash_original_method = "9F48D83DEE90081423E43167EA0B9F32", hash_generated_method = "0A93717D63346D8CDD8B5550EC84A6DB")
    public void setCallWaiting(boolean enable, Message onComplete) {
        addTaint(onComplete.getTaint());
        addTaint(enable);
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "method setCallWaiting is NOT supported in CDMA!");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.039 -0400", hash_original_method = "96CADC2872DB4F7FDEDEDD322815973F", hash_generated_method = "822C445C5B4D9120BF9FC0E8634D50FF")
    public void updateServiceLocation() {
        mSST.enableSingleLocationUpdate();
        // ---------- Original Method ----------
        //mSST.enableSingleLocationUpdate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.039 -0400", hash_original_method = "910AE5D7D70CC37EC2511A21C3761E3A", hash_generated_method = "51E0805AD01FE356CC54EA9F756ED9A4")
    public void setDataRoamingEnabled(boolean enable) {
        addTaint(enable);
        mDataConnectionTracker.setDataOnRoamingEnabled(enable);
        // ---------- Original Method ----------
        //mDataConnectionTracker.setDataOnRoamingEnabled(enable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.040 -0400", hash_original_method = "610E8C97A082907006BA954BE534B9EC", hash_generated_method = "8F40A0227E70706C0035695B4840126A")
    public void registerForCdmaOtaStatusChange(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mCM.registerForCdmaOtaProvision(h, what, obj);
        // ---------- Original Method ----------
        //mCM.registerForCdmaOtaProvision(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.040 -0400", hash_original_method = "BBA791A1BBD0F6B3058E9616045D8082", hash_generated_method = "ACBD939DE4EE9B5B72166C5DB9C6ABF4")
    public void unregisterForCdmaOtaStatusChange(Handler h) {
        addTaint(h.getTaint());
        mCM.unregisterForCdmaOtaProvision(h);
        // ---------- Original Method ----------
        //mCM.unregisterForCdmaOtaProvision(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.040 -0400", hash_original_method = "832A3DCDB2173345E213F4FEE097F4C8", hash_generated_method = "52A2D71FAECAF7DB065D41514136146E")
    public void registerForSubscriptionInfoReady(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mSST.registerForSubscriptionInfoReady(h, what, obj);
        // ---------- Original Method ----------
        //mSST.registerForSubscriptionInfoReady(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.040 -0400", hash_original_method = "8678E3A1722432B3AEE20746D6239509", hash_generated_method = "164B2607B1B1C939CA397492D50B66B0")
    public void unregisterForSubscriptionInfoReady(Handler h) {
        addTaint(h.getTaint());
        mSST.unregisterForSubscriptionInfoReady(h);
        // ---------- Original Method ----------
        //mSST.unregisterForSubscriptionInfoReady(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.041 -0400", hash_original_method = "9CC75D31629A3B23A63ED4AF8AC1CC3C", hash_generated_method = "2AE548BBA18B79FB631489C387E3DABC")
    public void setOnEcbModeExitResponse(Handler h, int what, Object obj) {
        mEcmExitRespRegistrant = new Registrant (h, what, obj);
        // ---------- Original Method ----------
        //mEcmExitRespRegistrant = new Registrant (h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.041 -0400", hash_original_method = "40447D9C1BA4AF14D98FB8C3ACDE2526", hash_generated_method = "25D0D5A1574FBF501EEDE29E3315A1C4")
    public void unsetOnEcbModeExitResponse(Handler h) {
        addTaint(h.getTaint());
        mEcmExitRespRegistrant.clear();
        // ---------- Original Method ----------
        //mEcmExitRespRegistrant.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.041 -0400", hash_original_method = "0F8C6CFDB05E5D9DD9E146C1B344047B", hash_generated_method = "0D507A524288D91A91E8B078B69D9C96")
    public void registerForCallWaiting(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mCT.registerForCallWaiting(h, what, obj);
        // ---------- Original Method ----------
        //mCT.registerForCallWaiting(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.041 -0400", hash_original_method = "0239428C6B544E5C48B7505010514559", hash_generated_method = "C6ABA376E5DAAF4E2E51234B9F2FBBF9")
    public void unregisterForCallWaiting(Handler h) {
        addTaint(h.getTaint());
        mCT.unregisterForCallWaiting(h);
        // ---------- Original Method ----------
        //mCT.unregisterForCallWaiting(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.042 -0400", hash_original_method = "639F59C576968CC215A4C16BCF60725F", hash_generated_method = "216F9504A0E2949E5C7B433B0DEB49FB")
    public void getNeighboringCids(Message response) {
        addTaint(response.getTaint());
        if(response != null)        
        {
            CommandException ce = new CommandException(
                    CommandException.Error.REQUEST_NOT_SUPPORTED);
            AsyncResult.forMessage(response).exception = ce;
            response.sendToTarget();
        } //End block
        // ---------- Original Method ----------
        //if (response != null) {
            //CommandException ce = new CommandException(
                    //CommandException.Error.REQUEST_NOT_SUPPORTED);
            //AsyncResult.forMessage(response).exception = ce;
            //response.sendToTarget();
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.043 -0400", hash_original_method = "872EFAB028EF9345A6D84A5CBF27D619", hash_generated_method = "B437F6E3C6AF4DF34CAE54A6FFF44883")
    public DataState getDataConnectionState(String apnType) {
        addTaint(apnType.getTaint());
        DataState ret = DataState.DISCONNECTED;
        if(mSST == null)        
        {
            ret = DataState.DISCONNECTED;
        } //End block
        else
        if(mSST.getCurrentDataConnectionState() != ServiceState.STATE_IN_SERVICE)        
        {
            ret = DataState.DISCONNECTED;
        } //End block
        else
        if(mDataConnectionTracker.isApnTypeEnabled(apnType) == false ||
                mDataConnectionTracker.isApnTypeActive(apnType) == false)        
        {
            ret = DataState.DISCONNECTED;
        } //End block
        else
        {
switch(mDataConnectionTracker.getState(apnType)){
            case FAILED:
            case IDLE:
            ret = DataState.DISCONNECTED;
            break;
            case CONNECTED:
            case DISCONNECTING:
            if(mCT.state != Phone.State.IDLE
                            && !mSST.isConcurrentVoiceAndDataAllowed())            
            {
                ret = DataState.SUSPENDED;
            } //End block
            else
            {
                ret = DataState.CONNECTED;
            } //End block
            break;
            case INITING:
            case CONNECTING:
            case SCANNING:
            ret = DataState.CONNECTING;
            break;
}
        } //End block
        log("getDataConnectionState apnType=" + apnType + " ret=" + ret);
DataState varEDFF4FBBF053B5DC2B444ADFA049EE0F_1017286931 =         ret;
        varEDFF4FBBF053B5DC2B444ADFA049EE0F_1017286931.addTaint(taint);
        return varEDFF4FBBF053B5DC2B444ADFA049EE0F_1017286931;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.043 -0400", hash_original_method = "F7E968145C01057A311E794FEA9BAA95", hash_generated_method = "3E54EE4F692E423D458C417C017276DF")
    public void sendUssdResponse(String ussdMessge) {
        addTaint(ussdMessge.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "sendUssdResponse: not possible in CDMA");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.043 -0400", hash_original_method = "98607162C44D8873925496654D522BF8", hash_generated_method = "75DBB739F17E6C3625C4907B8B257293")
    public void sendDtmf(char c) {
        addTaint(c);
        if(!PhoneNumberUtils.is12Key(c))        
        {
        } //End block
        else
        {
            if(mCT.state ==  Phone.State.OFFHOOK)            
            {
                mCM.sendDtmf(c, null);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (!PhoneNumberUtils.is12Key(c)) {
            //Log.e(LOG_TAG,
                    //"sendDtmf called with invalid character '" + c + "'");
        //} else {
            //if (mCT.state ==  Phone.State.OFFHOOK) {
                //mCM.sendDtmf(c, null);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.044 -0400", hash_original_method = "3FBA1333099AE68AF02019D712D23AB2", hash_generated_method = "9F64E57D36406D1E9C6B8E3C5C92AB3F")
    public void startDtmf(char c) {
        addTaint(c);
        if(!PhoneNumberUtils.is12Key(c))        
        {
        } //End block
        else
        {
            mCM.startDtmf(c, null);
        } //End block
        // ---------- Original Method ----------
        //if (!PhoneNumberUtils.is12Key(c)) {
            //Log.e(LOG_TAG,
                    //"startDtmf called with invalid character '" + c + "'");
        //} else {
            //mCM.startDtmf(c, null);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.044 -0400", hash_original_method = "3DAC039DE959EF34631E2B825CE1F213", hash_generated_method = "E3ACE99405ED7C4AFBEE2F93E02370EB")
    public void stopDtmf() {
        mCM.stopDtmf(null);
        // ---------- Original Method ----------
        //mCM.stopDtmf(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.044 -0400", hash_original_method = "E3E7B97B548DE87ECFE3195659B23FF9", hash_generated_method = "3354493678B176C3F26702631EAA6438")
    public void sendBurstDtmf(String dtmfString, int on, int off, Message onComplete) {
        addTaint(onComplete.getTaint());
        addTaint(off);
        addTaint(on);
        addTaint(dtmfString.getTaint());
        boolean check = true;
for(int itr = 0;itr < dtmfString.length();itr++)
        {
            if(!PhoneNumberUtils.is12Key(dtmfString.charAt(itr)))            
            {
                check = false;
                break;
            } //End block
        } //End block
        if((mCT.state ==  Phone.State.OFFHOOK)&&(check))        
        {
            mCM.sendBurstDtmf(dtmfString, on, off, onComplete);
        } //End block
        // ---------- Original Method ----------
        //boolean check = true;
        //for (int itr = 0;itr < dtmfString.length(); itr++) {
            //if (!PhoneNumberUtils.is12Key(dtmfString.charAt(itr))) {
                //Log.e(LOG_TAG,
                        //"sendDtmf called with invalid character '" + dtmfString.charAt(itr)+ "'");
                //check = false;
                //break;
            //}
        //}
        //if ((mCT.state ==  Phone.State.OFFHOOK)&&(check)) {
            //mCM.sendBurstDtmf(dtmfString, on, off, onComplete);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.044 -0400", hash_original_method = "FE0764939BCED80E9275F681708ABC99", hash_generated_method = "CE0FD7A774643873975F7B429D4D1C54")
    public void getAvailableNetworks(Message response) {
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "getAvailableNetworks: not possible in CDMA");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.044 -0400", hash_original_method = "9C1B6A588127C991585EBB349A2379DB", hash_generated_method = "089DACF1321DC0F5E6411DE5285A540F")
    public void setOutgoingCallerIdDisplay(int commandInterfaceCLIRMode, Message onComplete) {
        addTaint(onComplete.getTaint());
        addTaint(commandInterfaceCLIRMode);
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "setOutgoingCallerIdDisplay: not possible in CDMA");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.045 -0400", hash_original_method = "85721F5820CF0128BD1EA66BA785E274", hash_generated_method = "8061BA0AAC1F798918E946EB98E60D31")
    public void enableLocationUpdates() {
        mSST.enableLocationUpdates();
        // ---------- Original Method ----------
        //mSST.enableLocationUpdates();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.045 -0400", hash_original_method = "E6FECC87DDBB4D4FE984E494757397E3", hash_generated_method = "3FDC902944764AB6B7139C73765CF957")
    public void disableLocationUpdates() {
        mSST.disableLocationUpdates();
        // ---------- Original Method ----------
        //mSST.disableLocationUpdates();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.045 -0400", hash_original_method = "DAED77F9218E0449A772CA04214CC7F0", hash_generated_method = "A4539120C6EC9E203706F3837BE80718")
    public void getDataCallList(Message response) {
        addTaint(response.getTaint());
        mCM.getDataCallList(response);
        // ---------- Original Method ----------
        //mCM.getDataCallList(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.045 -0400", hash_original_method = "33CDF43696035DC3E16A234222A80D64", hash_generated_method = "DA8CEB7DA80E5A079B4910B3E27D4289")
    public boolean getDataRoamingEnabled() {
        boolean var05EB48F135E17AD66E5DF608D5E538E9_236274485 = (mDataConnectionTracker.getDataOnRoamingEnabled());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1822723430 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1822723430;
        // ---------- Original Method ----------
        //return mDataConnectionTracker.getDataOnRoamingEnabled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.045 -0400", hash_original_method = "63103D1CE9C7888BE66C8CE520564C7E", hash_generated_method = "B59D834340A7ADC7047E9CD2FC0AA1E2")
    public void setVoiceMailNumber(String alphaTag,
                                   String voiceMailNumber,
                                   Message onComplete) {
        addTaint(onComplete.getTaint());
        addTaint(alphaTag.getTaint());
        Message resp;
        mVmNumber = voiceMailNumber;
        resp = obtainMessage(EVENT_SET_VM_NUMBER_DONE, 0, 0, onComplete);
        mIccRecords.setVoiceMailNumber(alphaTag, mVmNumber, resp);
        // ---------- Original Method ----------
        //Message resp;
        //mVmNumber = voiceMailNumber;
        //resp = obtainMessage(EVENT_SET_VM_NUMBER_DONE, 0, 0, onComplete);
        //mIccRecords.setVoiceMailNumber(alphaTag, mVmNumber, resp);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.045 -0400", hash_original_method = "EC96491CC2681D27125B6B3540F74113", hash_generated_method = "7CB50312D24CD071694D11D12926BBE0")
    public String getVoiceMailNumber() {
        String number = null;
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        if(getContext().getResources().getBoolean(com.android.internal
                .R.bool.config_telephony_use_own_number_for_voicemail))        
        {
            number = sp.getString(VM_NUMBER_CDMA, getLine1Number());
        } //End block
        else
        {
            number = sp.getString(VM_NUMBER_CDMA, "*86");
        } //End block
String var63E80DF571E08DAA47BEFBF0BD0EEBAD_46086667 =         number;
        var63E80DF571E08DAA47BEFBF0BD0EEBAD_46086667.addTaint(taint);
        return var63E80DF571E08DAA47BEFBF0BD0EEBAD_46086667;
        // ---------- Original Method ----------
        //String number = null;
        //SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        //if (getContext().getResources().getBoolean(com.android.internal
                //.R.bool.config_telephony_use_own_number_for_voicemail)) {
            //number = sp.getString(VM_NUMBER_CDMA, getLine1Number());
        //} else {
            //number = sp.getString(VM_NUMBER_CDMA, "*86");
        //}
        //return number;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.046 -0400", hash_original_method = "5D69EEC40343498AF4F71AD96BF8D875", hash_generated_method = "A7F5BC916CB9FF880A621E648A200FCE")
    public int getVoiceMessageCount() {
        int voicemailCount = mIccRecords.getVoiceMessageCount();
        if(voicemailCount == 0)        
        {
            SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
            voicemailCount = sp.getInt(VM_COUNT_CDMA, 0);
        } //End block
        int var5FB2CD30778F6EFA2EE11F0D55F82E75_1536271678 = (voicemailCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_212221641 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_212221641;
        // ---------- Original Method ----------
        //int voicemailCount =  mIccRecords.getVoiceMessageCount();
        //if (voicemailCount == 0) {
            //SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
            //voicemailCount = sp.getInt(VM_COUNT_CDMA, 0);
        //}
        //return voicemailCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.046 -0400", hash_original_method = "72DF9B0892372ADFAD7DE65056384F5E", hash_generated_method = "DA9CFB3C4A6AFA3D00EAB5C293A9A0C3")
    public String getVoiceMailAlphaTag() {
        String ret = "";
        if(ret == null || ret.length() == 0)        
        {
String var2475348DE58D950BB6D9ACEB638F1798_959719589 =             mContext.getText(
                com.android.internal.R.string.defaultVoiceMailAlphaTag).toString();
            var2475348DE58D950BB6D9ACEB638F1798_959719589.addTaint(taint);
            return var2475348DE58D950BB6D9ACEB638F1798_959719589;
        } //End block
String varEDFF4FBBF053B5DC2B444ADFA049EE0F_678095671 =         ret;
        varEDFF4FBBF053B5DC2B444ADFA049EE0F_678095671.addTaint(taint);
        return varEDFF4FBBF053B5DC2B444ADFA049EE0F_678095671;
        // ---------- Original Method ----------
        //String ret = "";
        //if (ret == null || ret.length() == 0) {
            //return mContext.getText(
                //com.android.internal.R.string.defaultVoiceMailAlphaTag).toString();
        //}
        //return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.046 -0400", hash_original_method = "E23DBF1DA2409183D56D85932A9D038B", hash_generated_method = "3F6FF6C21F4B0F0AE750B246F2A5A49C")
    public void getCallForwardingOption(int commandInterfaceCFReason, Message onComplete) {
        addTaint(onComplete.getTaint());
        addTaint(commandInterfaceCFReason);
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "getCallForwardingOption: not possible in CDMA");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.046 -0400", hash_original_method = "A636525DAEF6D9A554C143CAF44D5772", hash_generated_method = "BE5905C9E18EB752AC3EA089BBEB4B4C")
    public void setCallForwardingOption(int commandInterfaceCFAction,
            int commandInterfaceCFReason,
            String dialingNumber,
            int timerSeconds,
            Message onComplete) {
        addTaint(onComplete.getTaint());
        addTaint(timerSeconds);
        addTaint(dialingNumber.getTaint());
        addTaint(commandInterfaceCFReason);
        addTaint(commandInterfaceCFAction);
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "setCallForwardingOption: not possible in CDMA");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.046 -0400", hash_original_method = "C44463D6A0E6885F3CB7F2F8669CD319", hash_generated_method = "ADBAB1426A71D3D9A56FE5B6102AAD33")
    public void getOutgoingCallerIdDisplay(Message onComplete) {
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "getOutgoingCallerIdDisplay: not possible in CDMA");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.046 -0400", hash_original_method = "D57FAF7F6BF0B2A3D2D79072DE461E12", hash_generated_method = "E0234C9E6102E3DC4339D08BD0CBFEF6")
    public boolean getCallForwardingIndicator() {
        boolean var68934A3E9455FA72420237EB05902327_489667590 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1499167909 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1499167909;
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "getCallForwardingIndicator: not possible in CDMA");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.046 -0400", hash_original_method = "4D4FE78E3983A39BD949CCB232763B54", hash_generated_method = "64D6052E7E469134BF989A118677B658")
    public void explicitCallTransfer() {
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "explicitCallTransfer: not possible in CDMA");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.046 -0400", hash_original_method = "280CC3981F581DF1B137B098EEA6AAEB", hash_generated_method = "BEEFBE6E4A66ECFEFF36D1779475B6A1")
    public String getLine1AlphaTag() {
String var540C13E9E156B687226421B24F2DF178_1154094708 =         null;
        var540C13E9E156B687226421B24F2DF178_1154094708.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1154094708;
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "getLine1AlphaTag: not possible in CDMA");
        //return null;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.046 -0400", hash_original_method = "812A77A153EDB691C43A0B58CAFAA77A", hash_generated_method = "AB35579F49622E7A241F12B7DDB4EC19")
     void notifyPhoneStateChanged() {
        mNotifier.notifyPhoneState(this);
        // ---------- Original Method ----------
        //mNotifier.notifyPhoneState(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.046 -0400", hash_original_method = "3EB8461625C29B29FD6CB8E5D60B43F3", hash_generated_method = "D04CBC6D94303085010D6FD72DFDF138")
     void notifyPreciseCallStateChanged() {
        super.notifyPreciseCallStateChangedP();
        // ---------- Original Method ----------
        //super.notifyPreciseCallStateChangedP();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.047 -0400", hash_original_method = "73E7BFF04E4E9785E6146409272926BA", hash_generated_method = "3C10FF86EDD5B27D27F8FAD326A596AF")
     void notifyServiceStateChanged(ServiceState ss) {
        addTaint(ss.getTaint());
        super.notifyServiceStateChangedP(ss);
        // ---------- Original Method ----------
        //super.notifyServiceStateChangedP(ss);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.047 -0400", hash_original_method = "482FE18FBD1949DAF708F2E65940DE8F", hash_generated_method = "0723685B826BB9996EC0449E7B1A8FCF")
     void notifyLocationChanged() {
        mNotifier.notifyCellLocation(this);
        // ---------- Original Method ----------
        //mNotifier.notifyCellLocation(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.047 -0400", hash_original_method = "292444BE96E352C8E8312B338E19EF02", hash_generated_method = "1834271AD9115788FB6995456D8952DC")
     void notifyNewRingingConnection(Connection c) {
        addTaint(c.getTaint());
        super.notifyNewRingingConnectionP(c);
        // ---------- Original Method ----------
        //super.notifyNewRingingConnectionP(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.047 -0400", hash_original_method = "1858091673D3A4B62C058FCC91892C36", hash_generated_method = "C0967CF5B0AC71AC9086A2946F168D51")
     void notifyDisconnect(Connection cn) {
        addTaint(cn.getTaint());
        mDisconnectRegistrants.notifyResult(cn);
        // ---------- Original Method ----------
        //mDisconnectRegistrants.notifyResult(cn);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.047 -0400", hash_original_method = "4DFA3B176AED92FABCFB596FBC88C127", hash_generated_method = "78FF0EBB369D5E48C88943009DE8A38C")
     void notifyUnknownConnection() {
        mUnknownConnectionRegistrants.notifyResult(this);
        // ---------- Original Method ----------
        //mUnknownConnectionRegistrants.notifyResult(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.047 -0400", hash_original_method = "393DB826FD1453B6BE0DEA71B818C50D", hash_generated_method = "250895F80AC1B9541B0624B109EBD04B")
    public boolean isInEmergencyCall() {
        boolean varC50EB6DDD62699F8E2B83C9A5F978084_854071836 = (mCT.isInEmergencyCall());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_745638090 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_745638090;
        // ---------- Original Method ----------
        //return mCT.isInEmergencyCall();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.047 -0400", hash_original_method = "B4B2A6F2428B54DDD4A7791B2905A02A", hash_generated_method = "1240CB343DC0CAA9C315AFD347C7ED13")
    public boolean isInEcm() {
        boolean var955CE82CD3A5151723EB19D6614F559B_488719824 = (mIsPhoneInEcmState);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1585216606 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1585216606;
        // ---------- Original Method ----------
        //return mIsPhoneInEcmState;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.047 -0400", hash_original_method = "00543A79BC25C997F29F0DAD4E28E830", hash_generated_method = "1259144038E5F63266306060ABEAC7B0")
     void sendEmergencyCallbackModeChange() {
        Intent intent = new Intent(TelephonyIntents.ACTION_EMERGENCY_CALLBACK_MODE_CHANGED);
        intent.putExtra(PHONE_IN_ECM_STATE, mIsPhoneInEcmState);
        ActivityManagerNative.broadcastStickyIntent(intent,null);
        if(DBG)        
        Log.d(LOG_TAG, "sendEmergencyCallbackModeChange");
        // ---------- Original Method ----------
        //Intent intent = new Intent(TelephonyIntents.ACTION_EMERGENCY_CALLBACK_MODE_CHANGED);
        //intent.putExtra(PHONE_IN_ECM_STATE, mIsPhoneInEcmState);
        //ActivityManagerNative.broadcastStickyIntent(intent,null);
        //if (DBG) Log.d(LOG_TAG, "sendEmergencyCallbackModeChange");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.047 -0400", hash_original_method = "B67535D9EC35CAA35F8134AB61AC3782", hash_generated_method = "D384C946F9FCC6C8BE38FA0B702D8596")
    @Override
    public void exitEmergencyCallbackMode() {
        if(mWakeLock.isHeld())        
        {
            mWakeLock.release();
        } //End block
        mCM.exitEmergencyCallbackMode(obtainMessage(EVENT_EXIT_EMERGENCY_CALLBACK_RESPONSE));
        // ---------- Original Method ----------
        //if (mWakeLock.isHeld()) {
            //mWakeLock.release();
        //}
        //mCM.exitEmergencyCallbackMode(obtainMessage(EVENT_EXIT_EMERGENCY_CALLBACK_RESPONSE));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.048 -0400", hash_original_method = "379601A1C426F495327BF8B224FF5B5D", hash_generated_method = "D5E65C810F1FDC9CBF8EBFA07912D065")
    private void handleEnterEmergencyCallbackMode(Message msg) {
        addTaint(msg.getTaint());
        if(DBG)        
        {
            Log.d(LOG_TAG, "handleEnterEmergencyCallbackMode,mIsPhoneInEcmState= "
                    + mIsPhoneInEcmState);
        } //End block
        if(mIsPhoneInEcmState == false)        
        {
            mIsPhoneInEcmState = true;
            sendEmergencyCallbackModeChange();
            setSystemProperty(TelephonyProperties.PROPERTY_INECM_MODE, "true");
            long delayInMillis = SystemProperties.getLong(
                    TelephonyProperties.PROPERTY_ECM_EXIT_TIMER, DEFAULT_ECM_EXIT_TIMER_VALUE);
            postDelayed(mExitEcmRunnable, delayInMillis);
            mWakeLock.acquire();
        } //End block
        // ---------- Original Method ----------
        //if (DBG) {
            //Log.d(LOG_TAG, "handleEnterEmergencyCallbackMode,mIsPhoneInEcmState= "
                    //+ mIsPhoneInEcmState);
        //}
        //if (mIsPhoneInEcmState == false) {
            //mIsPhoneInEcmState = true;
            //sendEmergencyCallbackModeChange();
            //setSystemProperty(TelephonyProperties.PROPERTY_INECM_MODE, "true");
            //long delayInMillis = SystemProperties.getLong(
                    //TelephonyProperties.PROPERTY_ECM_EXIT_TIMER, DEFAULT_ECM_EXIT_TIMER_VALUE);
            //postDelayed(mExitEcmRunnable, delayInMillis);
            //mWakeLock.acquire();
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.048 -0400", hash_original_method = "DE92BF7F05810FB5E0BD1EEEAFEB4B90", hash_generated_method = "A7D4589237BEDD464A3DC57D974C1A5D")
    private void handleExitEmergencyCallbackMode(Message msg) {
        addTaint(msg.getTaint());
        AsyncResult ar = (AsyncResult)msg.obj;
        if(DBG)        
        {
            Log.d(LOG_TAG, "handleExitEmergencyCallbackMode,ar.exception , mIsPhoneInEcmState "
                    + ar.exception + mIsPhoneInEcmState);
        } //End block
        removeCallbacks(mExitEcmRunnable);
        if(mEcmExitRespRegistrant != null)        
        {
            mEcmExitRespRegistrant.notifyRegistrant(ar);
        } //End block
        if(ar.exception == null)        
        {
            if(mIsPhoneInEcmState)            
            {
                mIsPhoneInEcmState = false;
                setSystemProperty(TelephonyProperties.PROPERTY_INECM_MODE, "false");
            } //End block
            sendEmergencyCallbackModeChange();
            mDataConnectionTracker.setInternalDataEnabled(true);
        } //End block
        // ---------- Original Method ----------
        //AsyncResult ar = (AsyncResult)msg.obj;
        //if (DBG) {
            //Log.d(LOG_TAG, "handleExitEmergencyCallbackMode,ar.exception , mIsPhoneInEcmState "
                    //+ ar.exception + mIsPhoneInEcmState);
        //}
        //removeCallbacks(mExitEcmRunnable);
        //if (mEcmExitRespRegistrant != null) {
            //mEcmExitRespRegistrant.notifyRegistrant(ar);
        //}
        //if (ar.exception == null) {
            //if (mIsPhoneInEcmState) {
                //mIsPhoneInEcmState = false;
                //setSystemProperty(TelephonyProperties.PROPERTY_INECM_MODE, "false");
            //}
            //sendEmergencyCallbackModeChange();
            //mDataConnectionTracker.setInternalDataEnabled(true);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.048 -0400", hash_original_method = "C8EF6B60BE95B81385F7554432463CF1", hash_generated_method = "481FBD0FB9A1491CBF291C8C20F5FA6B")
     void handleTimerInEmergencyCallbackMode(int action) {
        addTaint(action);
switch(action){
        case CANCEL_ECM_TIMER:
        removeCallbacks(mExitEcmRunnable);
        mEcmTimerResetRegistrants.notifyResult(Boolean.TRUE);
        break;
        case RESTART_ECM_TIMER:
        long delayInMillis = SystemProperties.getLong(
                    TelephonyProperties.PROPERTY_ECM_EXIT_TIMER, DEFAULT_ECM_EXIT_TIMER_VALUE);
        postDelayed(mExitEcmRunnable, delayInMillis);
        mEcmTimerResetRegistrants.notifyResult(Boolean.FALSE);
        break;
        default:
}
        // ---------- Original Method ----------
        //switch(action) {
        //case CANCEL_ECM_TIMER:
            //removeCallbacks(mExitEcmRunnable);
            //mEcmTimerResetRegistrants.notifyResult(Boolean.TRUE);
            //break;
        //case RESTART_ECM_TIMER:
            //long delayInMillis = SystemProperties.getLong(
                    //TelephonyProperties.PROPERTY_ECM_EXIT_TIMER, DEFAULT_ECM_EXIT_TIMER_VALUE);
            //postDelayed(mExitEcmRunnable, delayInMillis);
            //mEcmTimerResetRegistrants.notifyResult(Boolean.FALSE);
            //break;
        //default:
            //Log.e(LOG_TAG, "handleTimerInEmergencyCallbackMode, unsupported action " + action);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.048 -0400", hash_original_method = "BEFF27391F370909F03A02FD6CE5C8E1", hash_generated_method = "EEDB2D9591FD07C3A48CCC58D2B7AA33")
    public void registerForEcmTimerReset(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mEcmTimerResetRegistrants.addUnique(h, what, obj);
        // ---------- Original Method ----------
        //mEcmTimerResetRegistrants.addUnique(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.048 -0400", hash_original_method = "2652F35782787E1271AD631A33A0033B", hash_generated_method = "5C2E355B379ED741D69CA6BA6C09872E")
    public void unregisterForEcmTimerReset(Handler h) {
        addTaint(h.getTaint());
        mEcmTimerResetRegistrants.remove(h);
        // ---------- Original Method ----------
        //mEcmTimerResetRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.049 -0400", hash_original_method = "69FA59CB460FF0A097B9F7F6B4D5A187", hash_generated_method = "727FAAA101B1A0C76E4B0BF9FA146297")
    @Override
    public void handleMessage(Message msg) {
        addTaint(msg.getTaint());
        AsyncResult ar;
        Message onComplete;
switch(msg.what){
        case EVENT_RADIO_AVAILABLE:
        {
            mCM.getBasebandVersion(obtainMessage(EVENT_GET_BASEBAND_VERSION_DONE));
            mCM.getDeviceIdentity(obtainMessage(EVENT_GET_DEVICE_IDENTITY_DONE));
        } //End block
        break;
        case EVENT_GET_BASEBAND_VERSION_DONE:
        {
            ar = (AsyncResult)msg.obj;
            if(ar.exception != null)            
            {
                break;
            } //End block
            if(DBG)            
            Log.d(LOG_TAG, "Baseband version: " + ar.result);
            setSystemProperty(TelephonyProperties.PROPERTY_BASEBAND_VERSION, (String)ar.result);
        } //End block
        break;
        case EVENT_GET_DEVICE_IDENTITY_DONE:
        {
            ar = (AsyncResult)msg.obj;
            if(ar.exception != null)            
            {
                break;
            } //End block
            String[] respId = (String[])ar.result;
            mImei = respId[0];
            mImeiSv = respId[1];
            mEsn  =  respId[2];
            mMeid =  respId[3];
        } //End block
        break;
        case EVENT_EMERGENCY_CALLBACK_MODE_ENTER:
        {
            handleEnterEmergencyCallbackMode(msg);
        } //End block
        break;
        case  EVENT_EXIT_EMERGENCY_CALLBACK_RESPONSE:
        {
            handleExitEmergencyCallbackMode(msg);
        } //End block
        break;
        case EVENT_RUIM_RECORDS_LOADED:
        {
            Log.d(LOG_TAG, "Event EVENT_RUIM_RECORDS_LOADED Received");
            updateCurrentCarrierInProvider();
        } //End block
        break;
        case EVENT_RADIO_OFF_OR_NOT_AVAILABLE:
        {
            Log.d(LOG_TAG, "Event EVENT_RADIO_OFF_OR_NOT_AVAILABLE Received");
        } //End block
        break;
        case EVENT_RADIO_ON:
        {
            Log.d(LOG_TAG, "Event EVENT_RADIO_ON Received");
        } //End block
        break;
        case EVENT_SSN:
        {
            Log.d(LOG_TAG, "Event EVENT_SSN Received");
        } //End block
        break;
        case EVENT_REGISTERED_TO_NETWORK:
        {
            Log.d(LOG_TAG, "Event EVENT_REGISTERED_TO_NETWORK Received");
        } //End block
        break;
        case EVENT_NV_READY:
        {
            Log.d(LOG_TAG, "Event EVENT_NV_READY Received");
            mNvLoadedRegistrants.notifyRegistrants();
            prepareEri();
        } //End block
        break;
        case EVENT_SET_VM_NUMBER_DONE:
        {
            ar = (AsyncResult)msg.obj;
            if(IccException.class.isInstance(ar.exception))            
            {
                storeVoiceMailNumber(mVmNumber);
                ar.exception = null;
            } //End block
            onComplete = (Message) ar.userObj;
            if(onComplete != null)            
            {
                AsyncResult.forMessage(onComplete, ar.result, ar.exception);
                onComplete.sendToTarget();
            } //End block
        } //End block
        break;
        default:
        {
            super.handleMessage(msg);
        } //End block
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.049 -0400", hash_original_method = "4BF16EE42BDE3709043B0CD4BA1346D5", hash_generated_method = "B5AFF59637F184DAC02D9AD7CA4554D2")
    public PhoneSubInfo getPhoneSubInfo() {
PhoneSubInfo varF38609CC566E79D788257133E374AE10_1884740428 =         mSubInfo;
        varF38609CC566E79D788257133E374AE10_1884740428.addTaint(taint);
        return varF38609CC566E79D788257133E374AE10_1884740428;
        // ---------- Original Method ----------
        //return mSubInfo;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.049 -0400", hash_original_method = "A5B3830D3022369CFD45112AC4A19D05", hash_generated_method = "22CAC77955A3CE7994149F45D6EBE371")
    public IccSmsInterfaceManager getIccSmsInterfaceManager() {
IccSmsInterfaceManager varC43C36FE4B4A1A4D07AC7B20CA68C0D6_1554694293 =         mRuimSmsInterfaceManager;
        varC43C36FE4B4A1A4D07AC7B20CA68C0D6_1554694293.addTaint(taint);
        return varC43C36FE4B4A1A4D07AC7B20CA68C0D6_1554694293;
        // ---------- Original Method ----------
        //return mRuimSmsInterfaceManager;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.049 -0400", hash_original_method = "F4C16F1EDC7887AFA610A21C85E2FBBC", hash_generated_method = "E9229AAFDE4B2E5F9628A5A1DCD4685C")
    public IccPhoneBookInterfaceManager getIccPhoneBookInterfaceManager() {
IccPhoneBookInterfaceManager var44867D0A74CDD1B592C1A2310CC480BA_1261963581 =         mRuimPhoneBookInterfaceManager;
        var44867D0A74CDD1B592C1A2310CC480BA_1261963581.addTaint(taint);
        return var44867D0A74CDD1B592C1A2310CC480BA_1261963581;
        // ---------- Original Method ----------
        //return mRuimPhoneBookInterfaceManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.049 -0400", hash_original_method = "631C425442894A51F9E1215F7444839C", hash_generated_method = "27FE1EA5654F55B579390BEC4505EA7F")
    public void registerForNvLoaded(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        Registrant r = new Registrant (h, what, obj);
        mNvLoadedRegistrants.add(r);
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //mNvLoadedRegistrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.050 -0400", hash_original_method = "FC47AF6104E2994A09ED5540AEE820A5", hash_generated_method = "BCE929372302F23AD4FFB30A4F1DA4B1")
    public void unregisterForNvLoaded(Handler h) {
        addTaint(h.getTaint());
        mNvLoadedRegistrants.remove(h);
        // ---------- Original Method ----------
        //mNvLoadedRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.050 -0400", hash_original_method = "76D872D60E8DF5A817173A7970E48DAF", hash_generated_method = "8CEAA3E453A6F5F2BD802B21BA0891A1")
    public void registerForEriFileLoaded(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        Registrant r = new Registrant (h, what, obj);
        mEriFileLoadedRegistrants.add(r);
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //mEriFileLoadedRegistrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.050 -0400", hash_original_method = "609ACFE0DF3AD88014ED023EE4CC2BBF", hash_generated_method = "CAAFAD56376C099B5D2E440F0DE78441")
    public void unregisterForEriFileLoaded(Handler h) {
        addTaint(h.getTaint());
        mEriFileLoadedRegistrants.remove(h);
        // ---------- Original Method ----------
        //mEriFileLoadedRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.050 -0400", hash_original_method = "C4157CB043EC8B3384F8270EB7DCD5BB", hash_generated_method = "54F20FED80F5A0DAA58DCF01A510D5E2")
    public final void setSystemProperty(String property, String value) {
        addTaint(value.getTaint());
        addTaint(property.getTaint());
        super.setSystemProperty(property, value);
        // ---------- Original Method ----------
        //super.setSystemProperty(property, value);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.050 -0400", hash_original_method = "515987807F65054AFA6AA9A268DDB599", hash_generated_method = "31E8FF569B0B059690A4EEAFBF8556AA")
    public IccFileHandler getIccFileHandler() {
IccFileHandler var60C625BDD447562094F87D9E98CECDB3_290097145 =         this.mIccFileHandler;
        var60C625BDD447562094F87D9E98CECDB3_290097145.addTaint(taint);
        return var60C625BDD447562094F87D9E98CECDB3_290097145;
        // ---------- Original Method ----------
        //return this.mIccFileHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.050 -0400", hash_original_method = "793C414C17B853DD540D3B3DFD8290DE", hash_generated_method = "B586B6B1449E029F3A3F79C68056598D")
    public void activateCellBroadcastSms(int activate, Message response) {
        addTaint(response.getTaint());
        addTaint(activate);
        response.sendToTarget();
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[CDMAPhone] activateCellBroadcastSms() is obsolete; use SmsManager");
        //response.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.050 -0400", hash_original_method = "81E322CF525B990EC666DA306E1980A6", hash_generated_method = "2B89A1455CABD1C525047CAF7E2D66B6")
    public void getCellBroadcastSmsConfig(Message response) {
        addTaint(response.getTaint());
        response.sendToTarget();
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[CDMAPhone] getCellBroadcastSmsConfig() is obsolete; use SmsManager");
        //response.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.050 -0400", hash_original_method = "718A796BA1FEFA7B8760E97D0CFF0F71", hash_generated_method = "BDA8B7A9F58D47843AA6968075FA6F97")
    public void setCellBroadcastSmsConfig(int[] configValuesArray, Message response) {
        addTaint(response.getTaint());
        addTaint(configValuesArray[0]);
        response.sendToTarget();
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[CDMAPhone] setCellBroadcastSmsConfig() is obsolete; use SmsManager");
        //response.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.050 -0400", hash_original_method = "C10911F486938B4F93DC849B5E1085A3", hash_generated_method = "5AACA030193E98C0E33B7F2B42F5E702")
    @Override
    public boolean needsOtaServiceProvisioning() {
        boolean varE39B7877E44696E21561D6846DA1A14B_2123589982 = (mSST.getOtasp() != ServiceStateTracker.OTASP_NOT_NEEDED);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_372721925 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_372721925;
        // ---------- Original Method ----------
        //return mSST.getOtasp() != ServiceStateTracker.OTASP_NOT_NEEDED;
    }

    
    private static boolean isIs683OtaSpDialStr(String dialStr) {
        int sysSelCodeInt;
        boolean isOtaspDialString = false;
        int dialStrLen = dialStr.length();
        if (dialStrLen == IS683A_FEATURE_CODE_NUM_DIGITS) {
            if (dialStr.equals(IS683A_FEATURE_CODE)) {
                isOtaspDialString = true;
            }
        } else {
            sysSelCodeInt = extractSelCodeFromOtaSpNum(dialStr);
            switch (sysSelCodeInt) {
                case IS683_CONST_800MHZ_A_BAND:
                case IS683_CONST_800MHZ_B_BAND:
                case IS683_CONST_1900MHZ_A_BLOCK:
                case IS683_CONST_1900MHZ_B_BLOCK:
                case IS683_CONST_1900MHZ_C_BLOCK:
                case IS683_CONST_1900MHZ_D_BLOCK:
                case IS683_CONST_1900MHZ_E_BLOCK:
                case IS683_CONST_1900MHZ_F_BLOCK:
                    isOtaspDialString = true;
                    break;
                default:
                    break;
            }
        }
        return isOtaspDialString;
    }

    
    private static int extractSelCodeFromOtaSpNum(String dialStr) {
        int dialStrLen = dialStr.length();
        int sysSelCodeInt = INVALID_SYSTEM_SELECTION_CODE;
        if ((dialStr.regionMatches(0, IS683A_FEATURE_CODE,
                                   0, IS683A_FEATURE_CODE_NUM_DIGITS)) &&
            (dialStrLen >= (IS683A_FEATURE_CODE_NUM_DIGITS +
                            IS683A_SYS_SEL_CODE_NUM_DIGITS))) {
                sysSelCodeInt = Integer.parseInt (
                                dialStr.substring (IS683A_FEATURE_CODE_NUM_DIGITS,
                                IS683A_FEATURE_CODE_NUM_DIGITS + IS683A_SYS_SEL_CODE_NUM_DIGITS));
        }
        if (DBG) Log.d(LOG_TAG, "extractSelCodeFromOtaSpNum " + sysSelCodeInt);
        return sysSelCodeInt;
    }

    
    private static boolean checkOtaSpNumBasedOnSysSelCode(int sysSelCodeInt, String sch[]) {
        boolean isOtaSpNum = false;
        try {
            int selRc = Integer.parseInt((String)sch[1]);
            for (int i = 0; i < selRc; i++) {
                if (!TextUtils.isEmpty(sch[i+2]) && !TextUtils.isEmpty(sch[i+3])) {
                    int selMin = Integer.parseInt((String)sch[i+2]);
                    int selMax = Integer.parseInt((String)sch[i+3]);
                    if ((sysSelCodeInt >= selMin) && (sysSelCodeInt <= selMax)) {
                        isOtaSpNum = true;
                        break;
                    }
                }
            }
        } catch (NumberFormatException ex) {
            Log.e(LOG_TAG, "checkOtaSpNumBasedOnSysSelCode, error", ex);
        }
        return isOtaSpNum;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.051 -0400", hash_original_method = "2F4529BDEA4C79E5E2F449E50272F3AC", hash_generated_method = "BBBAB9D00E162550E3756663ED6AABCF")
    private boolean isCarrierOtaSpNum(String dialStr) {
        addTaint(dialStr.getTaint());
        boolean isOtaSpNum = false;
        int sysSelCodeInt = extractSelCodeFromOtaSpNum(dialStr);
        if(sysSelCodeInt == INVALID_SYSTEM_SELECTION_CODE)        
        {
            boolean var8631BB990FB12453B9EC3FB97C98FF96_1500396557 = (isOtaSpNum);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1439584737 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1439584737;
        } //End block
        if(!TextUtils.isEmpty(mCarrierOtaSpNumSchema))        
        {
            Matcher m = pOtaSpNumSchema.matcher(mCarrierOtaSpNumSchema);
            if(DBG)            
            {
                Log.d(LOG_TAG, "isCarrierOtaSpNum,schema" + mCarrierOtaSpNumSchema);
            } //End block
            if(m.find())            
            {
                String sch[] = pOtaSpNumSchema.split(mCarrierOtaSpNumSchema);
                if(!TextUtils.isEmpty(sch[0]) && sch[0].equals("SELC"))                
                {
                    if(sysSelCodeInt!=INVALID_SYSTEM_SELECTION_CODE)                    
                    {
                        isOtaSpNum=checkOtaSpNumBasedOnSysSelCode(sysSelCodeInt,sch);
                    } //End block
                    else
                    {
                        if(DBG)                        
                        {
                            Log.d(LOG_TAG, "isCarrierOtaSpNum,sysSelCodeInt is invalid");
                        } //End block
                    } //End block
                } //End block
                else
                if(!TextUtils.isEmpty(sch[0]) && sch[0].equals("FC"))                
                {
                    int fcLen = Integer.parseInt((String)sch[1]);
                    String fc = (String)sch[2];
                    if(dialStr.regionMatches(0,fc,0,fcLen))                    
                    {
                        isOtaSpNum = true;
                    } //End block
                    else
                    {
                        if(DBG)                        
                        Log.d(LOG_TAG, "isCarrierOtaSpNum,not otasp number");
                    } //End block
                } //End block
                else
                {
                    if(DBG)                    
                    {
                        Log.d(LOG_TAG, "isCarrierOtaSpNum,ota schema not supported" + sch[0]);
                    } //End block
                } //End block
            } //End block
            else
            {
                if(DBG)                
                {
                    Log.d(LOG_TAG, "isCarrierOtaSpNum,ota schema pattern not right" +
                          mCarrierOtaSpNumSchema);
                } //End block
            } //End block
        } //End block
        else
        {
            if(DBG)            
            Log.d(LOG_TAG, "isCarrierOtaSpNum,ota schema pattern empty");
        } //End block
        boolean var8631BB990FB12453B9EC3FB97C98FF96_2113426382 = (isOtaSpNum);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2112096494 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2112096494;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.052 -0400", hash_original_method = "AE6C103DE6DE549189EC8F2DC89B4935", hash_generated_method = "A03BBC82D8F3EEA074211D7E8A7D2391")
    @Override
    public boolean isOtaSpNumber(String dialStr) {
        addTaint(dialStr.getTaint());
        boolean isOtaSpNum = false;
        String dialableStr = PhoneNumberUtils.extractNetworkPortionAlt(dialStr);
        if(dialableStr != null)        
        {
            isOtaSpNum = isIs683OtaSpDialStr(dialableStr);
            if(isOtaSpNum == false)            
            {
                isOtaSpNum = isCarrierOtaSpNum(dialableStr);
            } //End block
        } //End block
        if(DBG)        
        Log.d(LOG_TAG, "isOtaSpNumber " + isOtaSpNum);
        boolean var8631BB990FB12453B9EC3FB97C98FF96_909537963 = (isOtaSpNum);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1197636945 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1197636945;
        // ---------- Original Method ----------
        //boolean isOtaSpNum = false;
        //String dialableStr = PhoneNumberUtils.extractNetworkPortionAlt(dialStr);
        //if (dialableStr != null) {
            //isOtaSpNum = isIs683OtaSpDialStr(dialableStr);
            //if (isOtaSpNum == false) {
                //isOtaSpNum = isCarrierOtaSpNum(dialableStr);
            //}
        //}
        //if (DBG) Log.d(LOG_TAG, "isOtaSpNumber " + isOtaSpNum);
        //return isOtaSpNum;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.052 -0400", hash_original_method = "CBAF5F4AF9A1C44FBA957D2F8ABDCEC2", hash_generated_method = "E0F389801579FFBA38205874F22A14DE")
    @Override
    public int getCdmaEriIconIndex() {
        int var059926CD2257B01A992EDE767723C0CE_24980728 = (getServiceState().getCdmaEriIconIndex());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1011483874 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1011483874;
        // ---------- Original Method ----------
        //return getServiceState().getCdmaEriIconIndex();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.052 -0400", hash_original_method = "505B53637594CBFFA64F8CC821649187", hash_generated_method = "91FA8DBF0DB23E444EB9D7E6518E3560")
    @Override
    public int getCdmaEriIconMode() {
        int var4B882ADB9A861964E78BD04AE5F5EED7_1031718501 = (getServiceState().getCdmaEriIconMode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_398259647 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_398259647;
        // ---------- Original Method ----------
        //return getServiceState().getCdmaEriIconMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.052 -0400", hash_original_method = "FF25B4C2C2FD6DDBAFFF02AC278A249A", hash_generated_method = "B8B7F3C17D92E42AA689F8FDE61B1902")
    @Override
    public String getCdmaEriText() {
        int roamInd = getServiceState().getCdmaRoamingIndicator();
        int defRoamInd = getServiceState().getCdmaDefaultRoamingIndicator();
String varB93F3092AFB42616E9EB718AF806656A_648899614 =         mEriManager.getCdmaEriText(roamInd, defRoamInd);
        varB93F3092AFB42616E9EB718AF806656A_648899614.addTaint(taint);
        return varB93F3092AFB42616E9EB718AF806656A_648899614;
        // ---------- Original Method ----------
        //int roamInd = getServiceState().getCdmaRoamingIndicator();
        //int defRoamInd = getServiceState().getCdmaDefaultRoamingIndicator();
        //return mEriManager.getCdmaEriText(roamInd, defRoamInd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.057 -0400", hash_original_method = "1FA484546C7B73CA49B2C4AE64A8C83E", hash_generated_method = "CFBFA06C524A9049EAB68A3A1AD7DEE2")
    private void storeVoiceMailNumber(String number) {
        addTaint(number.getTaint());
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(VM_NUMBER_CDMA, number);
        editor.apply();
        // ---------- Original Method ----------
        //SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        //SharedPreferences.Editor editor = sp.edit();
        //editor.putString(VM_NUMBER_CDMA, number);
        //editor.apply();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.058 -0400", hash_original_method = "04903824830A3F9FD2759E9C177CC0CB", hash_generated_method = "C69C024E6BE0ED9CB062557FCBA33089")
    private void setIsoCountryProperty(String operatorNumeric) {
        addTaint(operatorNumeric.getTaint());
        if(TextUtils.isEmpty(operatorNumeric))        
        {
            setSystemProperty(PROPERTY_ICC_OPERATOR_ISO_COUNTRY, "");
        } //End block
        else
        {
            String iso = "";
            try 
            {
                iso = MccTable.countryCodeForMcc(Integer.parseInt(
                        operatorNumeric.substring(0,3)));
            } //End block
            catch (NumberFormatException ex)
            {
            } //End block
            catch (StringIndexOutOfBoundsException ex)
            {
            } //End block
            setSystemProperty(PROPERTY_ICC_OPERATOR_ISO_COUNTRY, iso);
        } //End block
        // ---------- Original Method ----------
        //if (TextUtils.isEmpty(operatorNumeric)) {
            //setSystemProperty(PROPERTY_ICC_OPERATOR_ISO_COUNTRY, "");
        //} else {
            //String iso = "";
            //try {
                //iso = MccTable.countryCodeForMcc(Integer.parseInt(
                        //operatorNumeric.substring(0,3)));
            //} catch (NumberFormatException ex) {
                //Log.w(LOG_TAG, "countryCodeForMcc error" + ex);
            //} catch (StringIndexOutOfBoundsException ex) {
                //Log.w(LOG_TAG, "countryCodeForMcc error" + ex);
            //}
            //setSystemProperty(PROPERTY_ICC_OPERATOR_ISO_COUNTRY, iso);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.058 -0400", hash_original_method = "B076A318D7F3CB7E259ECDC99FDB3D0D", hash_generated_method = "9BC67F63038FE603D52DF7378160D24C")
     boolean updateCurrentCarrierInProvider(String operatorNumeric) {
        addTaint(operatorNumeric.getTaint());
        if(!TextUtils.isEmpty(operatorNumeric))        
        {
            try 
            {
                Uri uri = Uri.withAppendedPath(Telephony.Carriers.CONTENT_URI, "current");
                ContentValues map = new ContentValues();
                map.put(Telephony.Carriers.NUMERIC, operatorNumeric);
                log("updateCurrentCarrierInProvider from system: numeric=" + operatorNumeric);
                getContext().getContentResolver().insert(uri, map);
                MccTable.updateMccMncConfiguration(this, operatorNumeric);
                boolean varB326B5062B2F0E69046810717534CB09_416800364 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1296500915 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1296500915;
            } //End block
            catch (SQLException e)
            {
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1681952581 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2103522021 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2103522021;
        // ---------- Original Method ----------
        //if (!TextUtils.isEmpty(operatorNumeric)) {
            //try {
                //Uri uri = Uri.withAppendedPath(Telephony.Carriers.CONTENT_URI, "current");
                //ContentValues map = new ContentValues();
                //map.put(Telephony.Carriers.NUMERIC, operatorNumeric);
                //log("updateCurrentCarrierInProvider from system: numeric=" + operatorNumeric);
                //getContext().getContentResolver().insert(uri, map);
                //MccTable.updateMccMncConfiguration(this, operatorNumeric);
                //return true;
            //} catch (SQLException e) {
                //Log.e(LOG_TAG, "Can't store current operator", e);
            //}
        //}
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.058 -0400", hash_original_method = "A95BEE5F1920F9C579D7A59FC4DBB414", hash_generated_method = "5188AAE0839A2999015AEB0022254244")
     boolean updateCurrentCarrierInProvider() {
        boolean varB326B5062B2F0E69046810717534CB09_2068393965 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_176955218 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_176955218;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.058 -0400", hash_original_method = "5CB32743CEBF9A8556BB2E144A975CB3", hash_generated_method = "0C8DA2D9434460C5D421F4D31702F14B")
    public void prepareEri() {
        mEriManager.loadEriFile();
        if(mEriManager.isEriFileLoaded())        
        {
            log("ERI read, notify registrants");
            mEriFileLoadedRegistrants.notifyRegistrants();
        } //End block
        // ---------- Original Method ----------
        //mEriManager.loadEriFile();
        //if(mEriManager.isEriFileLoaded()) {
            //log("ERI read, notify registrants");
            //mEriFileLoadedRegistrants.notifyRegistrants();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.058 -0400", hash_original_method = "71144CF5C8B23350BF31931D81A1C3AC", hash_generated_method = "1A8B6ABADADCB19B56F73D07BC0AA35B")
    public boolean isEriFileLoaded() {
        boolean varFC37B500999B0D163D7D006B7A3A5C1B_2123262948 = (mEriManager.isEriFileLoaded());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1657992969 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1657992969;
        // ---------- Original Method ----------
        //return mEriManager.isEriFileLoaded();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.059 -0400", hash_original_method = "CBB2DC533610D724567F0136955B7014", hash_generated_method = "3308980FEC5C03BA05A3B53D08CF473A")
    protected void log(String s) {
        addTaint(s.getTaint());
        if(DBG)        
        Log.d(LOG_TAG, "[CDMAPhone] " + s);
        // ---------- Original Method ----------
        //if (DBG)
            //Log.d(LOG_TAG, "[CDMAPhone] " + s);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.059 -0400", hash_original_field = "951C150E6D062E6AED2C45BB9B756185", hash_generated_field = "37C2AB96DD7CCDC96FF809DAC1A6D712")

    static final String LOG_TAG = "CDMA";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.060 -0400", hash_original_field = "A4622F7F72162611C8E075EE443BC26E", hash_generated_field = "B7707D757F0604821CCAF673B2122320")

    private static final boolean DBG = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.060 -0400", hash_original_field = "5320633AA3BFE71644D90157C1CD824C", hash_generated_field = "E6DA1D723C3EE1AB56712584EA58C137")

    private static final int DEFAULT_ECM_EXIT_TIMER_VALUE = 300000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.060 -0400", hash_original_field = "3EDCC9CC37CA195649B1285985E473C3", hash_generated_field = "DBE7E6AE93BA06B2FF1DBE92EBF7667B")

    static final String VM_COUNT_CDMA = "vm_count_key_cdma";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.060 -0400", hash_original_field = "668CB3B3609C678099375254C8D95AA7", hash_generated_field = "C50FD41AD9C8ECFDE260B639E8718D3D")

    private static final String VM_NUMBER_CDMA = "vm_number_key_cdma";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.060 -0400", hash_original_field = "EC49609D403603D3B7721BA3617C00E8", hash_generated_field = "7149CAB7A993D6EFECE4128061F9865F")

    static final int RESTART_ECM_TIMER = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.060 -0400", hash_original_field = "2985483F14B41C74EABD7BCA0321F3DF", hash_generated_field = "0BF8B228276AC1D84F7C2766F8B74E6C")

    static final int CANCEL_ECM_TIMER = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.060 -0400", hash_original_field = "843F0250B369902370F83939F540B081", hash_generated_field = "1B6AA95D9706EED43D662EF600D64CB5")

    static String PROPERTY_CDMA_HOME_OPERATOR_NUMERIC = "ro.cdma.home.operator.numeric";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.060 -0400", hash_original_field = "3BA08B3453AFD8EBCFB22E951AED80DF", hash_generated_field = "8D504081DB72AA9930792378E569BE2E")

    private static final String IS683A_FEATURE_CODE = "*228";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.060 -0400", hash_original_field = "9DBDB8BAEDF244A1BD45FE7B339131C9", hash_generated_field = "6B01468F83B67C83DBE6AEB2D62A09FF")

    private static final int IS683A_FEATURE_CODE_NUM_DIGITS = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.060 -0400", hash_original_field = "11A59DFDA1E768721414AA1C69B63C9E", hash_generated_field = "DA2F29DBADB6D87260FE5B4BED8B1598")

    private static final int IS683A_SYS_SEL_CODE_NUM_DIGITS = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.060 -0400", hash_original_field = "C25262C71335F27E381F2311FF881E33", hash_generated_field = "E358300F1015F9A17C96E8811D0A4AD9")

    private static final int IS683A_SYS_SEL_CODE_OFFSET = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.060 -0400", hash_original_field = "8C6441FCC50B0830A2410221AE8A4925", hash_generated_field = "98531D0FD7604827F4C9BCEA781B49A3")

    private static final int IS683_CONST_800MHZ_A_BAND = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.060 -0400", hash_original_field = "B34BEF5E9252F376624F20F747B810F8", hash_generated_field = "0C7295C5D8889FCCE0C85B637D40E60C")

    private static final int IS683_CONST_800MHZ_B_BAND = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.060 -0400", hash_original_field = "DF632DFB5EF94CD03C3D2D9E67F0C0E8", hash_generated_field = "489A1CED9728DCA2C0C1D3DFC6A97DA7")

    private static final int IS683_CONST_1900MHZ_A_BLOCK = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.060 -0400", hash_original_field = "6977A7F81CF8832CE0006DC6B400488F", hash_generated_field = "CCF6ADEAC5D925D88FECCAAF8BA9CB9A")

    private static final int IS683_CONST_1900MHZ_B_BLOCK = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.060 -0400", hash_original_field = "5E9B40F193BFBBDABC03738CDD356C56", hash_generated_field = "4A09DC42BBD46B04747F40997180D304")

    private static final int IS683_CONST_1900MHZ_C_BLOCK = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.060 -0400", hash_original_field = "812E250D039979870F8BF7827DD6942E", hash_generated_field = "A402BF3C8CF075F873509D0D2B17E022")

    private static final int IS683_CONST_1900MHZ_D_BLOCK = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.060 -0400", hash_original_field = "6900F8029CB6DAC6B0B3C8BC7FA5584A", hash_generated_field = "360201E7861089684816302DB16F5849")

    private static final int IS683_CONST_1900MHZ_E_BLOCK = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.060 -0400", hash_original_field = "59BD6B30FEF1B370EA610752E954CE82", hash_generated_field = "D6596E49D61F4540FAE2D5DA6864F28B")

    private static final int IS683_CONST_1900MHZ_F_BLOCK = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.060 -0400", hash_original_field = "B5DE06BE2A525381D4B4AD5CFA1561B2", hash_generated_field = "0DE336CC04DA9F72A5B4A85D6CE8519B")

    private static final int INVALID_SYSTEM_SELECTION_CODE = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.060 -0400", hash_original_field = "7B0F019D05983EE374EEDBA360DA6CD2", hash_generated_field = "A75E56C661E3C1889447602EFA0983FC")

    private static Pattern pOtaSpNumSchema = Pattern.compile("[,\\s]+");
}

