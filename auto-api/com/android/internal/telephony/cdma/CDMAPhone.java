package com.android.internal.telephony.cdma;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.963 -0400", hash_original_field = "EA09C636C379E17EBA9E1A0866EC0796", hash_generated_field = "EC3246CB1DC699CB7AAC1E49E6B00916")

    private String mVmNumber = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.963 -0400", hash_original_field = "1D14D2D55BC367CD6AE3740CDB7152AF", hash_generated_field = "FB56FB2CCEDB5FF40D60B0E1FF012DC7")

    CdmaCallTracker mCT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.963 -0400", hash_original_field = "72BFF8190B34BEEE16406717B341412A", hash_generated_field = "97103F1B8DA1A01BC27456D6E3D45BD7")

    CdmaServiceStateTracker mSST;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.963 -0400", hash_original_field = "AF9E4B265579DF9690B194FA007294E8", hash_generated_field = "D1A76B98E2C9695E066872EF0F2A70D1")

    ArrayList <CdmaMmiCode> mPendingMmis = new ArrayList<CdmaMmiCode>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.963 -0400", hash_original_field = "5E8EA195206083E32FDBF6E6099D5D6E", hash_generated_field = "CC6C54ADD522D3CBE4AB79FC4C1AC885")

    RuimPhoneBookInterfaceManager mRuimPhoneBookInterfaceManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.963 -0400", hash_original_field = "A6CE63222F1F9B27D76D3EFFD0637A73", hash_generated_field = "52B0967754C377F16D6ECE26A27604BC")

    RuimSmsInterfaceManager mRuimSmsInterfaceManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.963 -0400", hash_original_field = "2C01F66E136181E8D582317306CCAC30", hash_generated_field = "F066FAD7B5AEEA27E2872ED159BF1CA4")

    PhoneSubInfo mSubInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.963 -0400", hash_original_field = "D2A1C9BF1A12B6A3A40E07BE541CCFEE", hash_generated_field = "5D6E15ED8D3AB433E5BB540845A155BB")

    EriManager mEriManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.963 -0400", hash_original_field = "69E45E7E240C011D8CB3CFDE90D76B33", hash_generated_field = "33E56F28B2B8FE4608887A854590880D")

    WakeLock mWakeLock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.963 -0400", hash_original_field = "74DE9B4DC153E7DBF167AFAC069421EB", hash_generated_field = "8E0942E84D2F17846D93DF1A3D310CA4")

    CatService mCcatService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.963 -0400", hash_original_field = "4CDA2C9561C6A6C20487424E5EB400E6", hash_generated_field = "1B28BD53602D31B33657F29EFDF49E1C")

    private RegistrantList mNvLoadedRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.963 -0400", hash_original_field = "42E8008744B539D2A4BE195C758A52AD", hash_generated_field = "C2A21B980E416310724E5FE9E25C7E88")

    private RegistrantList mEriFileLoadedRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.963 -0400", hash_original_field = "E5961082E6F858D1F4DC7E89696FE2B2", hash_generated_field = "768A030B81D88E97F336C8C7709B4D01")

    private RegistrantList mEcmTimerResetRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.963 -0400", hash_original_field = "955CE82CD3A5151723EB19D6614F559B", hash_generated_field = "1771FD97E99F7F7ADB6C6B6F1AD7072C")

    private boolean mIsPhoneInEcmState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.963 -0400", hash_original_field = "0ED8E01E502CF8564596FEC2F99A39EF", hash_generated_field = "1BDAC9D71123A8DEB653B2C84AF01BA0")

    private Registrant mEcmExitRespRegistrant;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.963 -0400", hash_original_field = "453C2995A2CC7C51188981A0F3965EED", hash_generated_field = "A314A9B894E97303A992D075673C95F0")

    protected String mImei;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.963 -0400", hash_original_field = "225448F5B7EE27E6F9CC21B80A6466DB", hash_generated_field = "86781DA86EE57C5A1DD8A1C30699806C")

    protected String mImeiSv;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.963 -0400", hash_original_field = "941CECC3CFC825DE92ED3B472B7DE551", hash_generated_field = "D60FA66B4CDB744384FC242287466EE9")

    private String mEsn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.963 -0400", hash_original_field = "39E558836DC399944C3B0229DC5337CC", hash_generated_field = "4AF7BD5643CFD768CB253CD96C809185")

    private String mMeid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.963 -0400", hash_original_field = "9A2CB205F5ACBD0C68BA41B8A9632D2A", hash_generated_field = "317DA458812FD117268BB82503CFDA82")

    private String mCarrierOtaSpNumSchema;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.964 -0400", hash_original_field = "5E0153DE5EDFE60861980DB630071DCD", hash_generated_field = "3532B15E601ED87C43014070670650E6")

    private Runnable mExitEcmRunnable = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.964 -0400", hash_original_method = "F3DC5BFDA25D02344EBFE8F4AEC767D8", hash_generated_method = "13E58FFF08C64D739C7C2CEA1DFD40E8")
        @Override
        public void run() {
            exitEmergencyCallbackMode();
            // ---------- Original Method ----------
            //exitEmergencyCallbackMode();
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.964 -0400", hash_original_field = "B70FAC06870FA211D668F462A2DBA212", hash_generated_field = "126D29D3ACD6141B3CF1C156D9BC8C27")

    Registrant mPostDialHandler;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.964 -0400", hash_original_method = "DAE6B8BFE7F70789DB7C3B99D4D5F7DA", hash_generated_method = "FD43AF827A5A82862FD3C5AC44A504A7")
    public  CDMAPhone(Context context, CommandsInterface ci, PhoneNotifier notifier) {
        super(notifier, context, ci, false);
        initSstIcc();
        init(context, notifier);
        addTaint(context.getTaint());
        addTaint(ci.getTaint());
        addTaint(notifier.getTaint());
        // ---------- Original Method ----------
        //initSstIcc();
        //init(context, notifier);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.964 -0400", hash_original_method = "467D4326BF1EF0C31B8D509189D4E2E0", hash_generated_method = "4C9CA93E067E888ACB7D4C62B21DB886")
    public  CDMAPhone(Context context, CommandsInterface ci, PhoneNotifier notifier,
            boolean unitTestMode) {
        super(notifier, context, ci, unitTestMode);
        initSstIcc();
        init(context, notifier);
        addTaint(context.getTaint());
        addTaint(ci.getTaint());
        addTaint(notifier.getTaint());
        addTaint(unitTestMode);
        // ---------- Original Method ----------
        //initSstIcc();
        //init(context, notifier);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.060 -0400", hash_original_method = "1B7DFBB42AE4FBFECC004BFFF3CFFDDB", hash_generated_method = "EC0DA6F48DC1646B607F03DA38DBAF6C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.062 -0400", hash_original_method = "8461B888D034831850AE73E07FC3F149", hash_generated_method = "C6FC25720DC5EE8FF0EE987A3E16EA7B")
    protected void init(Context context, PhoneNotifier notifier) {
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
        PowerManager pm;
        pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        mWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,LOG_TAG);
        SystemProperties.set(TelephonyProperties.CURRENT_ACTIVE_PHONE,
                Integer.toString(Phone.PHONE_TYPE_CDMA));
        String inEcm;
        inEcm = SystemProperties.get(TelephonyProperties.PROPERTY_INECM_MODE, "false");
        mIsPhoneInEcmState = inEcm.equals("true");
        {
            mCM.exitEmergencyCallbackMode(obtainMessage(EVENT_EXIT_EMERGENCY_CALLBACK_RESPONSE));
        } //End block
        mCarrierOtaSpNumSchema = SystemProperties.get(
                TelephonyProperties.PROPERTY_OTASP_NUM_SCHEMA,"");
        String operatorAlpha;
        operatorAlpha = SystemProperties.get("ro.cdma.home.operator.alpha");
        setSystemProperty(PROPERTY_ICC_OPERATOR_ALPHA, operatorAlpha);
        String operatorNumeric;
        operatorNumeric = SystemProperties.get(PROPERTY_CDMA_HOME_OPERATOR_NUMERIC);
        setSystemProperty(PROPERTY_ICC_OPERATOR_NUMERIC, operatorNumeric);
        setIsoCountryProperty(operatorNumeric);
        updateCurrentCarrierInProvider(operatorNumeric);
        notifier.notifyMessageWaitingChanged(this);
        addTaint(notifier.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.065 -0400", hash_original_method = "9DE3C78959AC59CCA27F149210FA77A8", hash_generated_method = "F3FEEAA479B2FA983331D6EBDEFF4F44")
    @Override
    public void dispose() {
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.070 -0400", hash_original_method = "EE2FF8AAD85928FB8E8B4233881FEB3A", hash_generated_method = "123CADA6CF62D4FBD8FD71E77576DE69")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.070 -0400", hash_original_method = "717E537581BE31A7DC523FEE6B0DDE4B", hash_generated_method = "B825BA19BA9786EB036B7878DB14A359")
    @Override
    protected void finalize() {
        Log.d(LOG_TAG, "CDMAPhone finalized");
        {
            boolean varC8E4FB4CC0E8CC6621CB9ECC0FDC7EC6_567712430 = (mWakeLock.isHeld());
            {
                mWakeLock.release();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if(DBG) Log.d(LOG_TAG, "CDMAPhone finalized");
        //if (mWakeLock.isHeld()) {
            //Log.e(LOG_TAG, "UNEXPECTED; mWakeLock is held when finalizing.");
            //mWakeLock.release();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.071 -0400", hash_original_method = "DA0F221C2247572C4D631280E4033E9A", hash_generated_method = "F8AECE0E5C7B440A13BB78250720584B")
    public ServiceState getServiceState() {
        ServiceState varB4EAC82CA7396A68D541C85D26508E83_306281739 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_306281739 = mSST.ss;
        varB4EAC82CA7396A68D541C85D26508E83_306281739.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_306281739;
        // ---------- Original Method ----------
        //return mSST.ss;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.071 -0400", hash_original_method = "79AFD9B845E4547B981131DAC9E3A14D", hash_generated_method = "FEB6B4F4CF6170223F21F910C9F8E724")
    public CallTracker getCallTracker() {
        CallTracker varB4EAC82CA7396A68D541C85D26508E83_1728846314 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1728846314 = mCT;
        varB4EAC82CA7396A68D541C85D26508E83_1728846314.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1728846314;
        // ---------- Original Method ----------
        //return mCT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.073 -0400", hash_original_method = "8AEFB373111A9C8AD30F3E8C75C461D2", hash_generated_method = "E139DB5B6C0862D70EC68CF9A45C88D1")
    public Phone.State getState() {
        Phone.State varB4EAC82CA7396A68D541C85D26508E83_2140306701 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2140306701 = mCT.state;
        varB4EAC82CA7396A68D541C85D26508E83_2140306701.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2140306701;
        // ---------- Original Method ----------
        //return mCT.state;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.075 -0400", hash_original_method = "BD481539215D5A66E62B4E6909625141", hash_generated_method = "2FBC2AC4CFBE785FB44D8D7416223F45")
    public ServiceStateTracker getServiceStateTracker() {
        ServiceStateTracker varB4EAC82CA7396A68D541C85D26508E83_373426175 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_373426175 = mSST;
        varB4EAC82CA7396A68D541C85D26508E83_373426175.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_373426175;
        // ---------- Original Method ----------
        //return mSST;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.090 -0400", hash_original_method = "B0BDAF041F7F636A26D0F46F60D4BC7B", hash_generated_method = "F88C0E080CA12495F5A7DB72FF3BA93F")
    public String getPhoneName() {
        String varB4EAC82CA7396A68D541C85D26508E83_388397203 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_388397203 = "CDMA";
        varB4EAC82CA7396A68D541C85D26508E83_388397203.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_388397203;
        // ---------- Original Method ----------
        //return "CDMA";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.102 -0400", hash_original_method = "94F6AF6179535CBD756D5B387D52C3CA", hash_generated_method = "E1C1402DB885F8F0FE0429593F92680D")
    public int getPhoneType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_983662201 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_983662201;
        // ---------- Original Method ----------
        //return Phone.PHONE_TYPE_CDMA;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.103 -0400", hash_original_method = "F828A2F1845194FFD82C471D7E89F726", hash_generated_method = "63A085AE71B7AA89AE426BE1C1540EDD")
    public boolean canTransfer() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_550511119 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_550511119;
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "canTransfer: not possible in CDMA");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.104 -0400", hash_original_method = "31E0316605311F71BD2BE82139C4C7B1", hash_generated_method = "A3E905B7F42CEE11F2704D0BF4CBAC7E")
    public CdmaCall getRingingCall() {
        CdmaCall varB4EAC82CA7396A68D541C85D26508E83_1727789607 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1727789607 = mCT.ringingCall;
        varB4EAC82CA7396A68D541C85D26508E83_1727789607.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1727789607;
        // ---------- Original Method ----------
        //return mCT.ringingCall;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.104 -0400", hash_original_method = "E892EC268DCFDF5C9C27A7DDC7E00573", hash_generated_method = "77B440C2480B73790494E18A49E29D56")
    public void setMute(boolean muted) {
        mCT.setMute(muted);
        addTaint(muted);
        // ---------- Original Method ----------
        //mCT.setMute(muted);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.104 -0400", hash_original_method = "FA6E824680C8944626A1A959DCEA6499", hash_generated_method = "D9C7F77C27EE982BF2C169D14AE2E477")
    public boolean getMute() {
        boolean var20663A120A6F5E860F4EB58F2E5B9228_1895414806 = (mCT.getMute());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_535228205 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_535228205;
        // ---------- Original Method ----------
        //return mCT.getMute();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.104 -0400", hash_original_method = "593DDE28AC9DCA9096C93A9D0D1099FC", hash_generated_method = "EFBC49A5AD73E9A3CBDEEDFF40E8B0EA")
    public void conference() throws CallStateException {
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "conference: not possible in CDMA");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.104 -0400", hash_original_method = "F90799FAE99EB431CF7F205DFD6DDD5D", hash_generated_method = "BE7111E41193CEA5B7239AE1DFAEDB0E")
    public void enableEnhancedVoicePrivacy(boolean enable, Message onComplete) {
        this.mCM.setPreferredVoicePrivacy(enable, onComplete);
        addTaint(enable);
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //this.mCM.setPreferredVoicePrivacy(enable, onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.105 -0400", hash_original_method = "5CE753EAA3145BBCA6A00800B2884B4E", hash_generated_method = "F103ED469C3205417264AB80600932E6")
    public void getEnhancedVoicePrivacy(Message onComplete) {
        this.mCM.getPreferredVoicePrivacy(onComplete);
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //this.mCM.getPreferredVoicePrivacy(onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.105 -0400", hash_original_method = "B9932A8A8BD16A4F0D461DDC6FDE6B49", hash_generated_method = "BEFA10EB4DBC56DB633604D1159E6D30")
    public void clearDisconnected() {
        mCT.clearDisconnected();
        // ---------- Original Method ----------
        //mCT.clearDisconnected();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.106 -0400", hash_original_method = "34BFC6F1F77B77A760EA5A249CE3FEFD", hash_generated_method = "7C4C30A95FDA5463A556D0EAE87A1315")
    public DataActivityState getDataActivityState() {
        DataActivityState varB4EAC82CA7396A68D541C85D26508E83_1102078285 = null; //Variable for return #1
        DataActivityState ret;
        ret = DataActivityState.NONE;
        {
            boolean varA31FE6075ED3D4825296DCCB8274BE5E_797681424 = (mSST.getCurrentDataConnectionState() == ServiceState.STATE_IN_SERVICE);
            {
                {
                    Object var27C7E0FDBE09DE35AC2FD606F73591E2_1633179826 = (mDataConnectionTracker.getActivity());
                    //Begin case DATAIN 
                    ret = DataActivityState.DATAIN;
                    //End case DATAIN 
                    //Begin case DATAOUT 
                    ret = DataActivityState.DATAOUT;
                    //End case DATAOUT 
                    //Begin case DATAINANDOUT 
                    ret = DataActivityState.DATAINANDOUT;
                    //End case DATAINANDOUT 
                    //Begin case DORMANT 
                    ret = DataActivityState.DORMANT;
                    //End case DORMANT 
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1102078285 = ret;
        varB4EAC82CA7396A68D541C85D26508E83_1102078285.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1102078285;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.106 -0400", hash_original_method = "FCBAE539BB72BE21647FF37299DC2B96", hash_generated_method = "0C6B7A0FF6350CF17887F3D234BB96C8")
     void notifySignalStrength() {
        mNotifier.notifySignalStrength(this);
        // ---------- Original Method ----------
        //mNotifier.notifySignalStrength(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.107 -0400", hash_original_method = "3B6D00BA5404778271A196326B2492C1", hash_generated_method = "3E0549F95ED748D7D925AEE5FAF585F8")
    public Connection dial(String dialString) throws CallStateException {
        Connection varB4EAC82CA7396A68D541C85D26508E83_233805246 = null; //Variable for return #1
        String newDialString;
        newDialString = PhoneNumberUtils.stripSeparators(dialString);
        varB4EAC82CA7396A68D541C85D26508E83_233805246 = mCT.dial(newDialString);
        addTaint(dialString.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_233805246.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_233805246;
        // ---------- Original Method ----------
        //String newDialString = PhoneNumberUtils.stripSeparators(dialString);
        //return mCT.dial(newDialString);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.107 -0400", hash_original_method = "C4CAEF0C07F27C620A5D9B835D3227D9", hash_generated_method = "BA3B5AAEB841E7D511F645CA14FFC0EE")
    public Connection dial(String dialString, UUSInfo uusInfo) throws CallStateException {
        if (DroidSafeAndroidRuntime.control) throw new CallStateException("Sending UUS information NOT supported in CDMA!");
        addTaint(dialString.getTaint());
        addTaint(uusInfo.getTaint());
        // ---------- Original Method ----------
        //throw new CallStateException("Sending UUS information NOT supported in CDMA!");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.113 -0400", hash_original_method = "46D9BC6E3280014832CD8FC523C20E6E", hash_generated_method = "B85BC1C121FD0C8CF56C0F7BEFFBECD3")
    public SignalStrength getSignalStrength() {
        SignalStrength varB4EAC82CA7396A68D541C85D26508E83_595099816 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_595099816 = mSST.mSignalStrength;
        varB4EAC82CA7396A68D541C85D26508E83_595099816.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_595099816;
        // ---------- Original Method ----------
        //return mSST.mSignalStrength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.126 -0400", hash_original_method = "391334830335544CEFDB5805671813C7", hash_generated_method = "0E5CCCA8373D51445CC1E552711BE319")
    public boolean getMessageWaitingIndicator() {
        boolean var197AD52F07C983B246C350347281E552_1148666859 = ((getVoiceMessageCount() > 0));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_761730026 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_761730026;
        // ---------- Original Method ----------
        //return (getVoiceMessageCount() > 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.127 -0400", hash_original_method = "A1DC624417B44DF11F4CA5E5B97277AF", hash_generated_method = "E96A7B638A69D416428C65AC32A6B83F")
    public List<? extends MmiCode> getPendingMmiCodes() {
        List<? extends MmiCode> varB4EAC82CA7396A68D541C85D26508E83_1980399308 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1980399308 = mPendingMmis;
        varB4EAC82CA7396A68D541C85D26508E83_1980399308.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1980399308;
        // ---------- Original Method ----------
        //return mPendingMmis;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.127 -0400", hash_original_method = "7C5A8D3C952528E3E4A994337305A33B", hash_generated_method = "2EF193B6258D7D83DEEB43DBE8494D8B")
    public void registerForSuppServiceNotification(
            Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "method registerForSuppServiceNotification is NOT supported in CDMA!");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.128 -0400", hash_original_method = "9F7E8D6F89A6C75F0A7653B179AA02CE", hash_generated_method = "0A98E92B095C32BD17780ACB88305C66")
    public CdmaCall getBackgroundCall() {
        CdmaCall varB4EAC82CA7396A68D541C85D26508E83_1442289749 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1442289749 = mCT.backgroundCall;
        varB4EAC82CA7396A68D541C85D26508E83_1442289749.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1442289749;
        // ---------- Original Method ----------
        //return mCT.backgroundCall;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.128 -0400", hash_original_method = "99F7E880D5431452FB99636E33872BD4", hash_generated_method = "071E1AECB53704FBFA3F0749B8B2AB06")
    public boolean handleInCallMmiCommands(String dialString) {
        addTaint(dialString.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_707334111 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_707334111;
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "method handleInCallMmiCommands is NOT supported in CDMA!");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.128 -0400", hash_original_method = "F6112A9AE3405415322B12D2CA172B80", hash_generated_method = "37078250358B3A8B5CBA05529B099F74")
     boolean isInCall() {
        CdmaCall.State foregroundCallState;
        foregroundCallState = getForegroundCall().getState();
        CdmaCall.State backgroundCallState;
        backgroundCallState = getBackgroundCall().getState();
        CdmaCall.State ringingCallState;
        ringingCallState = getRingingCall().getState();
        boolean var4B59C8CBE40B3534DD50EEA545B62F2B_1483708180 = ((foregroundCallState.isAlive() || backgroundCallState.isAlive() || ringingCallState
                .isAlive()));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2016631260 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2016631260;
        // ---------- Original Method ----------
        //CdmaCall.State foregroundCallState = getForegroundCall().getState();
        //CdmaCall.State backgroundCallState = getBackgroundCall().getState();
        //CdmaCall.State ringingCallState = getRingingCall().getState();
        //return (foregroundCallState.isAlive() || backgroundCallState.isAlive() || ringingCallState
                //.isAlive());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.129 -0400", hash_original_method = "573D1DDDB474C2914324D2DBB21AD4BF", hash_generated_method = "DA6E2EE7F182C05429B80E37E1A19F32")
    public void setNetworkSelectionModeAutomatic(Message response) {
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "method setNetworkSelectionModeAutomatic is NOT supported in CDMA!");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.129 -0400", hash_original_method = "7239EAF7B36D814AB7CF7CD5314FF0C2", hash_generated_method = "CFC7F3A052695995B32633E4C83F6A7E")
    public void unregisterForSuppServiceNotification(Handler h) {
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "method unregisterForSuppServiceNotification is NOT supported in CDMA!");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.129 -0400", hash_original_method = "C62CCD6CF2D9D7F7FA17BB7B58067AAC", hash_generated_method = "229941362132B3EA463C13061274E96C")
    public void acceptCall() throws CallStateException {
        mCT.acceptCall();
        // ---------- Original Method ----------
        //mCT.acceptCall();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.130 -0400", hash_original_method = "A64616985F0D82C6750D71CF8DADC6F4", hash_generated_method = "35B0F59F3248405A594AAB683856BD2F")
    public void rejectCall() throws CallStateException {
        mCT.rejectCall();
        // ---------- Original Method ----------
        //mCT.rejectCall();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.131 -0400", hash_original_method = "4BD56579DA53A7A8E0646A63E1978FC8", hash_generated_method = "4EFDBB8DAC4DC308937F3C30BD26241D")
    public void switchHoldingAndActive() throws CallStateException {
        mCT.switchWaitingOrHoldingAndActive();
        // ---------- Original Method ----------
        //mCT.switchWaitingOrHoldingAndActive();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.147 -0400", hash_original_method = "B121BB30C6EA08968FF3C722126FC795", hash_generated_method = "E00D35C37202B67E485EA17E212EE7F1")
    public String getLine1Number() {
        String varB4EAC82CA7396A68D541C85D26508E83_373980335 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_373980335 = mSST.getMdnNumber();
        varB4EAC82CA7396A68D541C85D26508E83_373980335.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_373980335;
        // ---------- Original Method ----------
        //return mSST.getMdnNumber();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.149 -0400", hash_original_method = "3BC6D82D8BFD82220414E9A1151516B0", hash_generated_method = "F4595C75EBFD2084BBB4B5D348CEA851")
    public String getCdmaPrlVersion() {
        String varB4EAC82CA7396A68D541C85D26508E83_1520335796 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1520335796 = mSST.getPrlVersion();
        varB4EAC82CA7396A68D541C85D26508E83_1520335796.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1520335796;
        // ---------- Original Method ----------
        //return mSST.getPrlVersion();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.150 -0400", hash_original_method = "5F3989DCB2E6CEB13D99C9EB5DB3E7E9", hash_generated_method = "DCD4AB1F17541E93BF59A3CE78560660")
    public String getCdmaMin() {
        String varB4EAC82CA7396A68D541C85D26508E83_1723259665 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1723259665 = mSST.getCdmaMin();
        varB4EAC82CA7396A68D541C85D26508E83_1723259665.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1723259665;
        // ---------- Original Method ----------
        //return mSST.getCdmaMin();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.150 -0400", hash_original_method = "8703C344BAEB4A9DC4BE8D85F2A2B471", hash_generated_method = "A25809A1A4686BAC4EF5AF81ABAE1355")
    public boolean isMinInfoReady() {
        boolean var9484B5471A0F2E2C668270A249557278_1103018517 = (mSST.isMinInfoReady());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_259115706 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_259115706;
        // ---------- Original Method ----------
        //return mSST.isMinInfoReady();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.151 -0400", hash_original_method = "4561349219664D3BF60D1FEC45B8BB02", hash_generated_method = "1CFC687675A85F7A2FB7991AE326B3B9")
    public void getCallWaiting(Message onComplete) {
        mCM.queryCallWaiting(CommandsInterface.SERVICE_CLASS_VOICE, onComplete);
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //mCM.queryCallWaiting(CommandsInterface.SERVICE_CLASS_VOICE, onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.151 -0400", hash_original_method = "6583EBFAAE11F5B271B0C202AB11C3E9", hash_generated_method = "05A63141C9EA8439A5D53E7DA83CD61B")
    public void setRadioPower(boolean power) {
        mSST.setRadioPower(power);
        addTaint(power);
        // ---------- Original Method ----------
        //mSST.setRadioPower(power);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.152 -0400", hash_original_method = "A71BC42B8E5B39F885F4E0F3CDCE1523", hash_generated_method = "3441DCF10699D0C77D16D466132CE069")
    public String getEsn() {
        String varB4EAC82CA7396A68D541C85D26508E83_1742523524 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1742523524 = mEsn;
        varB4EAC82CA7396A68D541C85D26508E83_1742523524.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1742523524;
        // ---------- Original Method ----------
        //return mEsn;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.152 -0400", hash_original_method = "7E7AAA89C01F3229F1902E361A6CD86F", hash_generated_method = "33689E16C6F96DA7451F71201FFBC4C7")
    public String getMeid() {
        String varB4EAC82CA7396A68D541C85D26508E83_1498992082 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1498992082 = mMeid;
        varB4EAC82CA7396A68D541C85D26508E83_1498992082.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1498992082;
        // ---------- Original Method ----------
        //return mMeid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.160 -0400", hash_original_method = "7766C412A244B7E9ACAC69FB73BBB546", hash_generated_method = "C0F58A822115726C6E4325AB8B0BF931")
    public String getDeviceId() {
        String varB4EAC82CA7396A68D541C85D26508E83_724653917 = null; //Variable for return #1
        String id;
        id = getMeid();
        {
            boolean varAF1C852358631BCBFACC3CD12BED0C0E_1510786861 = ((id == null) || id.matches("^0*$"));
            {
                Log.d(LOG_TAG, "getDeviceId(): MEID is not initialized use ESN");
                id = getEsn();
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_724653917 = id;
        varB4EAC82CA7396A68D541C85D26508E83_724653917.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_724653917;
        // ---------- Original Method ----------
        //String id = getMeid();
        //if ((id == null) || id.matches("^0*$")) {
            //Log.d(LOG_TAG, "getDeviceId(): MEID is not initialized use ESN");
            //id = getEsn();
        //}
        //return id;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.161 -0400", hash_original_method = "BA19C271165532D38DF9C2A2EC7580FC", hash_generated_method = "A61665B9C3FF259565E76F1D57A29529")
    public String getDeviceSvn() {
        String varB4EAC82CA7396A68D541C85D26508E83_885691141 = null; //Variable for return #1
        Log.d(LOG_TAG, "getDeviceSvn(): return 0");
        varB4EAC82CA7396A68D541C85D26508E83_885691141 = "0";
        varB4EAC82CA7396A68D541C85D26508E83_885691141.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_885691141;
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "getDeviceSvn(): return 0");
        //return "0";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.162 -0400", hash_original_method = "32994E1C8E091DA1F8318F6B29B65F50", hash_generated_method = "984ED007FE898BAB9F8AE723F98D0486")
    public String getSubscriberId() {
        String varB4EAC82CA7396A68D541C85D26508E83_2053290073 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2053290073 = mSST.getImsi();
        varB4EAC82CA7396A68D541C85D26508E83_2053290073.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2053290073;
        // ---------- Original Method ----------
        //return mSST.getImsi();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.163 -0400", hash_original_method = "FAD82CEAF9DD41800ADBC5F4734356D8", hash_generated_method = "0F08D7C8911B009C8B9D35B9245ACA27")
    public String getImei() {
        String varB4EAC82CA7396A68D541C85D26508E83_147300810 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_147300810 = null;
        varB4EAC82CA7396A68D541C85D26508E83_147300810.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_147300810;
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "IMEI is not available in CDMA");
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.163 -0400", hash_original_method = "3D81DB016065E96128526DD50CCAAE05", hash_generated_method = "FAE854890848F6BA7A1E5EB8D3397575")
    public boolean canConference() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1282883029 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1282883029;
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "canConference: not possible in CDMA");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.167 -0400", hash_original_method = "E38329BE2FF507326358BBAF596945E6", hash_generated_method = "742DD45D8524AE99D5A1D4597E1710A1")
    public CellLocation getCellLocation() {
        CellLocation varB4EAC82CA7396A68D541C85D26508E83_1948503247 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1948503247 = mSST.cellLoc;
        varB4EAC82CA7396A68D541C85D26508E83_1948503247.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1948503247;
        // ---------- Original Method ----------
        //return mSST.cellLoc;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.167 -0400", hash_original_method = "5D417D4C057D78BF0DEF3D949E557B3C", hash_generated_method = "49DCDE5BED0E01CB314A5B141264527F")
    public CdmaCall getForegroundCall() {
        CdmaCall varB4EAC82CA7396A68D541C85D26508E83_1297948998 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1297948998 = mCT.foregroundCall;
        varB4EAC82CA7396A68D541C85D26508E83_1297948998.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1297948998;
        // ---------- Original Method ----------
        //return mCT.foregroundCall;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.174 -0400", hash_original_method = "6287E103949DE4B29FC1760D95391284", hash_generated_method = "234D6E4521D81E5987646E7F3CA2EB2F")
    public void selectNetworkManually(OperatorInfo network,
            Message response) {
        addTaint(network.getTaint());
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "selectNetworkManually: not possible in CDMA");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.175 -0400", hash_original_method = "A54F4B18F21B3A39961648F4BDA2F061", hash_generated_method = "0D9A74204B6FB987A29697E2CA304A25")
    public void setOnPostDialCharacter(Handler h, int what, Object obj) {
        mPostDialHandler = new Registrant(h, what, obj);
        // ---------- Original Method ----------
        //mPostDialHandler = new Registrant(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.175 -0400", hash_original_method = "3D832E28FC020C3451E1ECD577F7705D", hash_generated_method = "65752CE77F13C93AA8E51F6955CAAC39")
    public boolean handlePinMmi(String dialString) {
        CdmaMmiCode mmi;
        mmi = CdmaMmiCode.newFromDialString(dialString, this);
        {
            boolean var1028666450F47101F5E9163275C14E96_1501074883 = (mmi.isPukCommand());
            {
                mPendingMmis.add(mmi);
                mMmiRegistrants.notifyRegistrants(new AsyncResult(null, mmi, null));
                mmi.processCode();
            } //End block
        } //End collapsed parenthetic
        addTaint(dialString.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1327243519 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1327243519;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.186 -0400", hash_original_method = "574EFAE567BAC054324E4789AB0ACA21", hash_generated_method = "BF710EFFE91D9CB3EE54A9E604EE7C5C")
     void onMMIDone(CdmaMmiCode mmi) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var2994F1DD658E93A134FDDE87066FC8E4_1853536132 = (mPendingMmis.remove(mmi));
            {
                mMmiCompleteRegistrants.notifyRegistrants(new AsyncResult(null, mmi, null));
            } //End block
        } //End collapsed parenthetic
        addTaint(mmi.getTaint());
        // ---------- Original Method ----------
        //if (mPendingMmis.remove(mmi)) {
            //mMmiCompleteRegistrants.notifyRegistrants(new AsyncResult(null, mmi, null));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.187 -0400", hash_original_method = "8885A01E1E8D54116E470B45B5958287", hash_generated_method = "68CC409C8C91BBCEBA82FD1BAD1512E5")
    public void setLine1Number(String alphaTag, String number, Message onComplete) {
        addTaint(alphaTag.getTaint());
        addTaint(number.getTaint());
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "setLine1Number: not possible in CDMA");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.187 -0400", hash_original_method = "9F48D83DEE90081423E43167EA0B9F32", hash_generated_method = "25B02E2673BBB3968E9E2B7E83315343")
    public void setCallWaiting(boolean enable, Message onComplete) {
        addTaint(enable);
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "method setCallWaiting is NOT supported in CDMA!");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.187 -0400", hash_original_method = "96CADC2872DB4F7FDEDEDD322815973F", hash_generated_method = "822C445C5B4D9120BF9FC0E8634D50FF")
    public void updateServiceLocation() {
        mSST.enableSingleLocationUpdate();
        // ---------- Original Method ----------
        //mSST.enableSingleLocationUpdate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.188 -0400", hash_original_method = "910AE5D7D70CC37EC2511A21C3761E3A", hash_generated_method = "833E210D6BAC589C67F646388318201A")
    public void setDataRoamingEnabled(boolean enable) {
        mDataConnectionTracker.setDataOnRoamingEnabled(enable);
        addTaint(enable);
        // ---------- Original Method ----------
        //mDataConnectionTracker.setDataOnRoamingEnabled(enable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.188 -0400", hash_original_method = "610E8C97A082907006BA954BE534B9EC", hash_generated_method = "5C66AFAF2A635561F285A473F4D6234D")
    public void registerForCdmaOtaStatusChange(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mCM.registerForCdmaOtaProvision(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mCM.registerForCdmaOtaProvision(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.188 -0400", hash_original_method = "BBA791A1BBD0F6B3058E9616045D8082", hash_generated_method = "44E7B7C84703223EACA634CEDB159B91")
    public void unregisterForCdmaOtaStatusChange(Handler h) {
        mCM.unregisterForCdmaOtaProvision(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mCM.unregisterForCdmaOtaProvision(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.189 -0400", hash_original_method = "832A3DCDB2173345E213F4FEE097F4C8", hash_generated_method = "B943F9B1788E248634D26A76F6A3DC53")
    public void registerForSubscriptionInfoReady(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mSST.registerForSubscriptionInfoReady(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mSST.registerForSubscriptionInfoReady(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.189 -0400", hash_original_method = "8678E3A1722432B3AEE20746D6239509", hash_generated_method = "13936C1F120A6D2B31EDD26D36794A8E")
    public void unregisterForSubscriptionInfoReady(Handler h) {
        mSST.unregisterForSubscriptionInfoReady(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mSST.unregisterForSubscriptionInfoReady(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.189 -0400", hash_original_method = "9CC75D31629A3B23A63ED4AF8AC1CC3C", hash_generated_method = "2AE548BBA18B79FB631489C387E3DABC")
    public void setOnEcbModeExitResponse(Handler h, int what, Object obj) {
        mEcmExitRespRegistrant = new Registrant (h, what, obj);
        // ---------- Original Method ----------
        //mEcmExitRespRegistrant = new Registrant (h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.193 -0400", hash_original_method = "40447D9C1BA4AF14D98FB8C3ACDE2526", hash_generated_method = "2853CE94543B3513F1C353DD44BE3889")
    public void unsetOnEcbModeExitResponse(Handler h) {
        mEcmExitRespRegistrant.clear();
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mEcmExitRespRegistrant.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.197 -0400", hash_original_method = "0F8C6CFDB05E5D9DD9E146C1B344047B", hash_generated_method = "E9152FD47833DCF3AA4B8315856C5289")
    public void registerForCallWaiting(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mCT.registerForCallWaiting(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mCT.registerForCallWaiting(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.197 -0400", hash_original_method = "0239428C6B544E5C48B7505010514559", hash_generated_method = "81FFEA55A48F85AAF2E95F140B0F811B")
    public void unregisterForCallWaiting(Handler h) {
        mCT.unregisterForCallWaiting(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mCT.unregisterForCallWaiting(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.198 -0400", hash_original_method = "639F59C576968CC215A4C16BCF60725F", hash_generated_method = "BF6A54E7A9C0015F00590D0FC668B41A")
    public void getNeighboringCids(Message response) {
        {
            CommandException ce;
            ce = new CommandException(
                    CommandException.Error.REQUEST_NOT_SUPPORTED);
            AsyncResult.forMessage(response).exception = ce;
            response.sendToTarget();
        } //End block
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //if (response != null) {
            //CommandException ce = new CommandException(
                    //CommandException.Error.REQUEST_NOT_SUPPORTED);
            //AsyncResult.forMessage(response).exception = ce;
            //response.sendToTarget();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.206 -0400", hash_original_method = "872EFAB028EF9345A6D84A5CBF27D619", hash_generated_method = "8457D2357417937208900439280F0971")
    public DataState getDataConnectionState(String apnType) {
        DataState varB4EAC82CA7396A68D541C85D26508E83_200386580 = null; //Variable for return #1
        DataState ret;
        ret = DataState.DISCONNECTED;
        {
            ret = DataState.DISCONNECTED;
        } //End block
        {
            boolean var2B4A8E6DAE4C8B61542DA3830F844B7B_1148969223 = (mSST.getCurrentDataConnectionState() != ServiceState.STATE_IN_SERVICE);
            {
                ret = DataState.DISCONNECTED;
            } //End block
            {
                boolean varEDC38D72B2381B58A0F3730E74C3817C_1994261004 = (mDataConnectionTracker.isApnTypeEnabled(apnType) == false ||
                mDataConnectionTracker.isApnTypeActive(apnType) == false);
                {
                    ret = DataState.DISCONNECTED;
                } //End block
                {
                    {
                        Object var819139837D42C0AD62155AA1D23C5AD5_1545997975 = (mDataConnectionTracker.getState(apnType));
                        //Begin case FAILED IDLE 
                        ret = DataState.DISCONNECTED;
                        //End case FAILED IDLE 
                        //Begin case CONNECTED DISCONNECTING 
                        {
                            boolean var398FF6E0DCA52B02F79A9CB272BA56EC_1162047937 = (mCT.state != Phone.State.IDLE
                            && !mSST.isConcurrentVoiceAndDataAllowed());
                            {
                                ret = DataState.SUSPENDED;
                            } //End block
                            {
                                ret = DataState.CONNECTED;
                            } //End block
                        } //End collapsed parenthetic
                        //End case CONNECTED DISCONNECTING 
                        //Begin case INITING CONNECTING SCANNING 
                        ret = DataState.CONNECTING;
                        //End case INITING CONNECTING SCANNING 
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        log("getDataConnectionState apnType=" + apnType + " ret=" + ret);
        varB4EAC82CA7396A68D541C85D26508E83_200386580 = ret;
        addTaint(apnType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_200386580.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_200386580;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.211 -0400", hash_original_method = "F7E968145C01057A311E794FEA9BAA95", hash_generated_method = "3E54EE4F692E423D458C417C017276DF")
    public void sendUssdResponse(String ussdMessge) {
        addTaint(ussdMessge.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "sendUssdResponse: not possible in CDMA");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.215 -0400", hash_original_method = "98607162C44D8873925496654D522BF8", hash_generated_method = "9923F1F35E623BD6467C95B19DD752AA")
    public void sendDtmf(char c) {
        {
            boolean varD5E376D61876D980336EC59E5D202EEE_2017026810 = (!PhoneNumberUtils.is12Key(c));
            {
                {
                    mCM.sendDtmf(c, null);
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(c);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.216 -0400", hash_original_method = "3FBA1333099AE68AF02019D712D23AB2", hash_generated_method = "AEA4802DB9426FE647E1303AC7FE9ECA")
    public void startDtmf(char c) {
        {
            boolean varD5E376D61876D980336EC59E5D202EEE_51771864 = (!PhoneNumberUtils.is12Key(c));
            {
                mCM.startDtmf(c, null);
            } //End block
        } //End collapsed parenthetic
        addTaint(c);
        // ---------- Original Method ----------
        //if (!PhoneNumberUtils.is12Key(c)) {
            //Log.e(LOG_TAG,
                    //"startDtmf called with invalid character '" + c + "'");
        //} else {
            //mCM.startDtmf(c, null);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.216 -0400", hash_original_method = "3DAC039DE959EF34631E2B825CE1F213", hash_generated_method = "E3ACE99405ED7C4AFBEE2F93E02370EB")
    public void stopDtmf() {
        mCM.stopDtmf(null);
        // ---------- Original Method ----------
        //mCM.stopDtmf(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.220 -0400", hash_original_method = "E3E7B97B548DE87ECFE3195659B23FF9", hash_generated_method = "5F1D280E18EC0DE1832BED753150F31C")
    public void sendBurstDtmf(String dtmfString, int on, int off, Message onComplete) {
        boolean check;
        check = true;
        {
            int itr;
            itr = 0;
            boolean varC203A73757365FB141AA417E652E019C_1528429317 = (itr < dtmfString.length());
            {
                {
                    boolean var6A7122EA2D2E6A95C8F93E4E1672AD9E_239406106 = (!PhoneNumberUtils.is12Key(dtmfString.charAt(itr)));
                    {
                        check = false;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            mCM.sendBurstDtmf(dtmfString, on, off, onComplete);
        } //End block
        addTaint(dtmfString.getTaint());
        addTaint(on);
        addTaint(off);
        addTaint(onComplete.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.221 -0400", hash_original_method = "FE0764939BCED80E9275F681708ABC99", hash_generated_method = "CE0FD7A774643873975F7B429D4D1C54")
    public void getAvailableNetworks(Message response) {
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "getAvailableNetworks: not possible in CDMA");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.221 -0400", hash_original_method = "9C1B6A588127C991585EBB349A2379DB", hash_generated_method = "1476F4AE1E5E06DF49897D4E9E90D55A")
    public void setOutgoingCallerIdDisplay(int commandInterfaceCLIRMode, Message onComplete) {
        addTaint(commandInterfaceCLIRMode);
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "setOutgoingCallerIdDisplay: not possible in CDMA");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.221 -0400", hash_original_method = "85721F5820CF0128BD1EA66BA785E274", hash_generated_method = "8061BA0AAC1F798918E946EB98E60D31")
    public void enableLocationUpdates() {
        mSST.enableLocationUpdates();
        // ---------- Original Method ----------
        //mSST.enableLocationUpdates();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.228 -0400", hash_original_method = "E6FECC87DDBB4D4FE984E494757397E3", hash_generated_method = "3FDC902944764AB6B7139C73765CF957")
    public void disableLocationUpdates() {
        mSST.disableLocationUpdates();
        // ---------- Original Method ----------
        //mSST.disableLocationUpdates();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.228 -0400", hash_original_method = "DAED77F9218E0449A772CA04214CC7F0", hash_generated_method = "13BB02467E7237F3DCAA27B785AFC8DE")
    public void getDataCallList(Message response) {
        mCM.getDataCallList(response);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //mCM.getDataCallList(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.232 -0400", hash_original_method = "33CDF43696035DC3E16A234222A80D64", hash_generated_method = "FB969C04886BE781C9B987F81DCC7B54")
    public boolean getDataRoamingEnabled() {
        boolean var6ACB2ECE8621241EECE599BD6243F11B_1755652857 = (mDataConnectionTracker.getDataOnRoamingEnabled());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_982908499 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_982908499;
        // ---------- Original Method ----------
        //return mDataConnectionTracker.getDataOnRoamingEnabled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.233 -0400", hash_original_method = "63103D1CE9C7888BE66C8CE520564C7E", hash_generated_method = "FB951956CF6FF915B0F35F192179D19D")
    public void setVoiceMailNumber(String alphaTag,
                                   String voiceMailNumber,
                                   Message onComplete) {
        Message resp;
        mVmNumber = voiceMailNumber;
        resp = obtainMessage(EVENT_SET_VM_NUMBER_DONE, 0, 0, onComplete);
        mIccRecords.setVoiceMailNumber(alphaTag, mVmNumber, resp);
        addTaint(alphaTag.getTaint());
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //Message resp;
        //mVmNumber = voiceMailNumber;
        //resp = obtainMessage(EVENT_SET_VM_NUMBER_DONE, 0, 0, onComplete);
        //mIccRecords.setVoiceMailNumber(alphaTag, mVmNumber, resp);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.237 -0400", hash_original_method = "EC96491CC2681D27125B6B3540F74113", hash_generated_method = "859895677A89FA4211A42BDEC6958394")
    public String getVoiceMailNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_178676517 = null; //Variable for return #1
        String number;
        number = null;
        SharedPreferences sp;
        sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        {
            boolean var8B403152FA0B86F979BAF5F52F130215_126520634 = (getContext().getResources().getBoolean(com.android.internal
                .R.bool.config_telephony_use_own_number_for_voicemail));
            {
                number = sp.getString(VM_NUMBER_CDMA, getLine1Number());
            } //End block
            {
                number = sp.getString(VM_NUMBER_CDMA, "*86");
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_178676517 = number;
        varB4EAC82CA7396A68D541C85D26508E83_178676517.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_178676517;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.244 -0400", hash_original_method = "5D69EEC40343498AF4F71AD96BF8D875", hash_generated_method = "169967D8C8AE4EE8A3FF17C3DBEAF748")
    public int getVoiceMessageCount() {
        int voicemailCount;
        voicemailCount = mIccRecords.getVoiceMessageCount();
        {
            SharedPreferences sp;
            sp = PreferenceManager.getDefaultSharedPreferences(getContext());
            voicemailCount = sp.getInt(VM_COUNT_CDMA, 0);
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_806006316 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_806006316;
        // ---------- Original Method ----------
        //int voicemailCount =  mIccRecords.getVoiceMessageCount();
        //if (voicemailCount == 0) {
            //SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
            //voicemailCount = sp.getInt(VM_COUNT_CDMA, 0);
        //}
        //return voicemailCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.245 -0400", hash_original_method = "72DF9B0892372ADFAD7DE65056384F5E", hash_generated_method = "DAF611B86ACCD605D7B5C7D2A60509EF")
    public String getVoiceMailAlphaTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_1456269498 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1042889581 = null; //Variable for return #2
        String ret;
        ret = "";
        {
            boolean var0709D69E6C2648B4A0C93BD0750A7DE0_199019890 = (ret == null || ret.length() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1456269498 = mContext.getText(
                com.android.internal.R.string.defaultVoiceMailAlphaTag).toString();
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1042889581 = ret;
        String varA7E53CE21691AB073D9660D615818899_1425594800; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1425594800 = varB4EAC82CA7396A68D541C85D26508E83_1456269498;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1425594800 = varB4EAC82CA7396A68D541C85D26508E83_1042889581;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1425594800.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1425594800;
        // ---------- Original Method ----------
        //String ret = "";
        //if (ret == null || ret.length() == 0) {
            //return mContext.getText(
                //com.android.internal.R.string.defaultVoiceMailAlphaTag).toString();
        //}
        //return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.246 -0400", hash_original_method = "E23DBF1DA2409183D56D85932A9D038B", hash_generated_method = "F366042A00F69A3A6DE9BD64B616AC1E")
    public void getCallForwardingOption(int commandInterfaceCFReason, Message onComplete) {
        addTaint(commandInterfaceCFReason);
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "getCallForwardingOption: not possible in CDMA");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.252 -0400", hash_original_method = "A636525DAEF6D9A554C143CAF44D5772", hash_generated_method = "C4B2CB6A675CF46FE55128145F8D0E54")
    public void setCallForwardingOption(int commandInterfaceCFAction,
            int commandInterfaceCFReason,
            String dialingNumber,
            int timerSeconds,
            Message onComplete) {
        addTaint(commandInterfaceCFAction);
        addTaint(commandInterfaceCFReason);
        addTaint(dialingNumber.getTaint());
        addTaint(timerSeconds);
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "setCallForwardingOption: not possible in CDMA");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.252 -0400", hash_original_method = "C44463D6A0E6885F3CB7F2F8669CD319", hash_generated_method = "ADBAB1426A71D3D9A56FE5B6102AAD33")
    public void getOutgoingCallerIdDisplay(Message onComplete) {
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "getOutgoingCallerIdDisplay: not possible in CDMA");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.253 -0400", hash_original_method = "D57FAF7F6BF0B2A3D2D79072DE461E12", hash_generated_method = "D4C9E7896837C96A57D7978D8435647B")
    public boolean getCallForwardingIndicator() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1157259236 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1157259236;
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "getCallForwardingIndicator: not possible in CDMA");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.253 -0400", hash_original_method = "4D4FE78E3983A39BD949CCB232763B54", hash_generated_method = "64D6052E7E469134BF989A118677B658")
    public void explicitCallTransfer() {
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "explicitCallTransfer: not possible in CDMA");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.253 -0400", hash_original_method = "280CC3981F581DF1B137B098EEA6AAEB", hash_generated_method = "764B1E5D792E9B215B72DCF5E3165B34")
    public String getLine1AlphaTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_1376609671 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1376609671 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1376609671.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1376609671;
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "getLine1AlphaTag: not possible in CDMA");
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.254 -0400", hash_original_method = "812A77A153EDB691C43A0B58CAFAA77A", hash_generated_method = "AB35579F49622E7A241F12B7DDB4EC19")
     void notifyPhoneStateChanged() {
        mNotifier.notifyPhoneState(this);
        // ---------- Original Method ----------
        //mNotifier.notifyPhoneState(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.258 -0400", hash_original_method = "3EB8461625C29B29FD6CB8E5D60B43F3", hash_generated_method = "D04CBC6D94303085010D6FD72DFDF138")
     void notifyPreciseCallStateChanged() {
        super.notifyPreciseCallStateChangedP();
        // ---------- Original Method ----------
        //super.notifyPreciseCallStateChangedP();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.258 -0400", hash_original_method = "73E7BFF04E4E9785E6146409272926BA", hash_generated_method = "A54D16F558EC12982CF56FB0933CD181")
     void notifyServiceStateChanged(ServiceState ss) {
        super.notifyServiceStateChangedP(ss);
        addTaint(ss.getTaint());
        // ---------- Original Method ----------
        //super.notifyServiceStateChangedP(ss);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.258 -0400", hash_original_method = "482FE18FBD1949DAF708F2E65940DE8F", hash_generated_method = "0723685B826BB9996EC0449E7B1A8FCF")
     void notifyLocationChanged() {
        mNotifier.notifyCellLocation(this);
        // ---------- Original Method ----------
        //mNotifier.notifyCellLocation(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.258 -0400", hash_original_method = "292444BE96E352C8E8312B338E19EF02", hash_generated_method = "9CAE80423F167649B545BC55A8273188")
     void notifyNewRingingConnection(Connection c) {
        super.notifyNewRingingConnectionP(c);
        addTaint(c.getTaint());
        // ---------- Original Method ----------
        //super.notifyNewRingingConnectionP(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.265 -0400", hash_original_method = "1858091673D3A4B62C058FCC91892C36", hash_generated_method = "0756798023112E23775C5ED34868F8B8")
     void notifyDisconnect(Connection cn) {
        mDisconnectRegistrants.notifyResult(cn);
        addTaint(cn.getTaint());
        // ---------- Original Method ----------
        //mDisconnectRegistrants.notifyResult(cn);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.265 -0400", hash_original_method = "4DFA3B176AED92FABCFB596FBC88C127", hash_generated_method = "78FF0EBB369D5E48C88943009DE8A38C")
     void notifyUnknownConnection() {
        mUnknownConnectionRegistrants.notifyResult(this);
        // ---------- Original Method ----------
        //mUnknownConnectionRegistrants.notifyResult(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.265 -0400", hash_original_method = "393DB826FD1453B6BE0DEA71B818C50D", hash_generated_method = "5716C5AA3F2239C20C3A0B583FCE5EDF")
    public boolean isInEmergencyCall() {
        boolean varD8A2457FC2EBCE0C63162FEE0C7B8E1B_642940940 = (mCT.isInEmergencyCall());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1644133208 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1644133208;
        // ---------- Original Method ----------
        //return mCT.isInEmergencyCall();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.266 -0400", hash_original_method = "B4B2A6F2428B54DDD4A7791B2905A02A", hash_generated_method = "D3B42A5CCBF53C62E6A58DAB33CBA042")
    public boolean isInEcm() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1561818970 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1561818970;
        // ---------- Original Method ----------
        //return mIsPhoneInEcmState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.266 -0400", hash_original_method = "00543A79BC25C997F29F0DAD4E28E830", hash_generated_method = "C554F53B49B78857328BE86DADBC7C80")
     void sendEmergencyCallbackModeChange() {
        Intent intent;
        intent = new Intent(TelephonyIntents.ACTION_EMERGENCY_CALLBACK_MODE_CHANGED);
        intent.putExtra(PHONE_IN_ECM_STATE, mIsPhoneInEcmState);
        ActivityManagerNative.broadcastStickyIntent(intent,null);
        Log.d(LOG_TAG, "sendEmergencyCallbackModeChange");
        // ---------- Original Method ----------
        //Intent intent = new Intent(TelephonyIntents.ACTION_EMERGENCY_CALLBACK_MODE_CHANGED);
        //intent.putExtra(PHONE_IN_ECM_STATE, mIsPhoneInEcmState);
        //ActivityManagerNative.broadcastStickyIntent(intent,null);
        //if (DBG) Log.d(LOG_TAG, "sendEmergencyCallbackModeChange");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.266 -0400", hash_original_method = "B67535D9EC35CAA35F8134AB61AC3782", hash_generated_method = "E07082397182DC847EF951F327B9503E")
    @Override
    public void exitEmergencyCallbackMode() {
        {
            boolean varC8E4FB4CC0E8CC6621CB9ECC0FDC7EC6_231190371 = (mWakeLock.isHeld());
            {
                mWakeLock.release();
            } //End block
        } //End collapsed parenthetic
        mCM.exitEmergencyCallbackMode(obtainMessage(EVENT_EXIT_EMERGENCY_CALLBACK_RESPONSE));
        // ---------- Original Method ----------
        //if (mWakeLock.isHeld()) {
            //mWakeLock.release();
        //}
        //mCM.exitEmergencyCallbackMode(obtainMessage(EVENT_EXIT_EMERGENCY_CALLBACK_RESPONSE));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.270 -0400", hash_original_method = "379601A1C426F495327BF8B224FF5B5D", hash_generated_method = "DE2CE1D8B39D048CEBF6E5D200A90F05")
    private void handleEnterEmergencyCallbackMode(Message msg) {
        {
            Log.d(LOG_TAG, "handleEnterEmergencyCallbackMode,mIsPhoneInEcmState= "
                    + mIsPhoneInEcmState);
        } //End block
        {
            mIsPhoneInEcmState = true;
            sendEmergencyCallbackModeChange();
            setSystemProperty(TelephonyProperties.PROPERTY_INECM_MODE, "true");
            long delayInMillis;
            delayInMillis = SystemProperties.getLong(
                    TelephonyProperties.PROPERTY_ECM_EXIT_TIMER, DEFAULT_ECM_EXIT_TIMER_VALUE);
            postDelayed(mExitEcmRunnable, delayInMillis);
            mWakeLock.acquire();
        } //End block
        addTaint(msg.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.279 -0400", hash_original_method = "DE92BF7F05810FB5E0BD1EEEAFEB4B90", hash_generated_method = "B06A06385BC9B0D2490C9A0BF88BC815")
    private void handleExitEmergencyCallbackMode(Message msg) {
        AsyncResult ar;
        ar = (AsyncResult)msg.obj;
        {
            Log.d(LOG_TAG, "handleExitEmergencyCallbackMode,ar.exception , mIsPhoneInEcmState "
                    + ar.exception + mIsPhoneInEcmState);
        } //End block
        removeCallbacks(mExitEcmRunnable);
        {
            mEcmExitRespRegistrant.notifyRegistrant(ar);
        } //End block
        {
            {
                mIsPhoneInEcmState = false;
                setSystemProperty(TelephonyProperties.PROPERTY_INECM_MODE, "false");
            } //End block
            sendEmergencyCallbackModeChange();
            mDataConnectionTracker.setInternalDataEnabled(true);
        } //End block
        addTaint(msg.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.280 -0400", hash_original_method = "C8EF6B60BE95B81385F7554432463CF1", hash_generated_method = "A77DEDD260D971249F3C0755B7BE8A7E")
     void handleTimerInEmergencyCallbackMode(int action) {
        //Begin case CANCEL_ECM_TIMER 
        removeCallbacks(mExitEcmRunnable);
        //End case CANCEL_ECM_TIMER 
        //Begin case CANCEL_ECM_TIMER 
        mEcmTimerResetRegistrants.notifyResult(Boolean.TRUE);
        //End case CANCEL_ECM_TIMER 
        //Begin case RESTART_ECM_TIMER 
        long delayInMillis;
        delayInMillis = SystemProperties.getLong(
                    TelephonyProperties.PROPERTY_ECM_EXIT_TIMER, DEFAULT_ECM_EXIT_TIMER_VALUE);
        //End case RESTART_ECM_TIMER 
        //Begin case RESTART_ECM_TIMER 
        postDelayed(mExitEcmRunnable, delayInMillis);
        //End case RESTART_ECM_TIMER 
        //Begin case RESTART_ECM_TIMER 
        mEcmTimerResetRegistrants.notifyResult(Boolean.FALSE);
        //End case RESTART_ECM_TIMER 
        addTaint(action);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.283 -0400", hash_original_method = "BEFF27391F370909F03A02FD6CE5C8E1", hash_generated_method = "802A8F092CF8BEF4917442D4D9031D0A")
    public void registerForEcmTimerReset(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mEcmTimerResetRegistrants.addUnique(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mEcmTimerResetRegistrants.addUnique(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.283 -0400", hash_original_method = "2652F35782787E1271AD631A33A0033B", hash_generated_method = "94498A7539C5CF9A67AD26014202949A")
    public void unregisterForEcmTimerReset(Handler h) {
        mEcmTimerResetRegistrants.remove(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mEcmTimerResetRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.288 -0400", hash_original_method = "69FA59CB460FF0A097B9F7F6B4D5A187", hash_generated_method = "B30B375AB066402CC7A9433B0DC45A6D")
    @Override
    public void handleMessage(Message msg) {
        AsyncResult ar;
        Message onComplete;
        //Begin case EVENT_RADIO_AVAILABLE 
        {
            mCM.getBasebandVersion(obtainMessage(EVENT_GET_BASEBAND_VERSION_DONE));
            mCM.getDeviceIdentity(obtainMessage(EVENT_GET_DEVICE_IDENTITY_DONE));
        } //End block
        //End case EVENT_RADIO_AVAILABLE 
        //Begin case EVENT_GET_BASEBAND_VERSION_DONE 
        {
            ar = (AsyncResult)msg.obj;
            Log.d(LOG_TAG, "Baseband version: " + ar.result);
            setSystemProperty(TelephonyProperties.PROPERTY_BASEBAND_VERSION, (String)ar.result);
        } //End block
        //End case EVENT_GET_BASEBAND_VERSION_DONE 
        //Begin case EVENT_GET_DEVICE_IDENTITY_DONE 
        {
            ar = (AsyncResult)msg.obj;
            String[] respId;
            respId = (String[])ar.result;
            mImei = respId[0];
            mImeiSv = respId[1];
            mEsn  =  respId[2];
            mMeid =  respId[3];
        } //End block
        //End case EVENT_GET_DEVICE_IDENTITY_DONE 
        //Begin case EVENT_EMERGENCY_CALLBACK_MODE_ENTER 
        {
            handleEnterEmergencyCallbackMode(msg);
        } //End block
        //End case EVENT_EMERGENCY_CALLBACK_MODE_ENTER 
        //Begin case EVENT_EXIT_EMERGENCY_CALLBACK_RESPONSE 
        {
            handleExitEmergencyCallbackMode(msg);
        } //End block
        //End case EVENT_EXIT_EMERGENCY_CALLBACK_RESPONSE 
        //Begin case EVENT_RUIM_RECORDS_LOADED 
        {
            Log.d(LOG_TAG, "Event EVENT_RUIM_RECORDS_LOADED Received");
            updateCurrentCarrierInProvider();
        } //End block
        //End case EVENT_RUIM_RECORDS_LOADED 
        //Begin case EVENT_RADIO_OFF_OR_NOT_AVAILABLE 
        {
            Log.d(LOG_TAG, "Event EVENT_RADIO_OFF_OR_NOT_AVAILABLE Received");
        } //End block
        //End case EVENT_RADIO_OFF_OR_NOT_AVAILABLE 
        //Begin case EVENT_RADIO_ON 
        {
            Log.d(LOG_TAG, "Event EVENT_RADIO_ON Received");
        } //End block
        //End case EVENT_RADIO_ON 
        //Begin case EVENT_SSN 
        {
            Log.d(LOG_TAG, "Event EVENT_SSN Received");
        } //End block
        //End case EVENT_SSN 
        //Begin case EVENT_REGISTERED_TO_NETWORK 
        {
            Log.d(LOG_TAG, "Event EVENT_REGISTERED_TO_NETWORK Received");
        } //End block
        //End case EVENT_REGISTERED_TO_NETWORK 
        //Begin case EVENT_NV_READY 
        {
            Log.d(LOG_TAG, "Event EVENT_NV_READY Received");
            mNvLoadedRegistrants.notifyRegistrants();
            prepareEri();
        } //End block
        //End case EVENT_NV_READY 
        //Begin case EVENT_SET_VM_NUMBER_DONE 
        {
            ar = (AsyncResult)msg.obj;
            {
                boolean varBCC2AAC262927329DC1DDFC23398E7CA_722734488 = (IccException.class.isInstance(ar.exception));
                {
                    storeVoiceMailNumber(mVmNumber);
                    ar.exception = null;
                } //End block
            } //End collapsed parenthetic
            onComplete = (Message) ar.userObj;
            {
                AsyncResult.forMessage(onComplete, ar.result, ar.exception);
                onComplete.sendToTarget();
            } //End block
        } //End block
        //End case EVENT_SET_VM_NUMBER_DONE 
        //Begin case default 
        {
            super.handleMessage(msg);
        } //End block
        //End case default 
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.300 -0400", hash_original_method = "4BF16EE42BDE3709043B0CD4BA1346D5", hash_generated_method = "8826D9A1F38286626F617E82397B2FB2")
    public PhoneSubInfo getPhoneSubInfo() {
        PhoneSubInfo varB4EAC82CA7396A68D541C85D26508E83_521403815 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_521403815 = mSubInfo;
        varB4EAC82CA7396A68D541C85D26508E83_521403815.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_521403815;
        // ---------- Original Method ----------
        //return mSubInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.301 -0400", hash_original_method = "A5B3830D3022369CFD45112AC4A19D05", hash_generated_method = "8892315397D4DEE5B5FD8C3014A73B96")
    public IccSmsInterfaceManager getIccSmsInterfaceManager() {
        IccSmsInterfaceManager varB4EAC82CA7396A68D541C85D26508E83_1221636247 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1221636247 = mRuimSmsInterfaceManager;
        varB4EAC82CA7396A68D541C85D26508E83_1221636247.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1221636247;
        // ---------- Original Method ----------
        //return mRuimSmsInterfaceManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.310 -0400", hash_original_method = "F4C16F1EDC7887AFA610A21C85E2FBBC", hash_generated_method = "788D88E0C86F9B81D440CCD9929DE105")
    public IccPhoneBookInterfaceManager getIccPhoneBookInterfaceManager() {
        IccPhoneBookInterfaceManager varB4EAC82CA7396A68D541C85D26508E83_1195662186 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1195662186 = mRuimPhoneBookInterfaceManager;
        varB4EAC82CA7396A68D541C85D26508E83_1195662186.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1195662186;
        // ---------- Original Method ----------
        //return mRuimPhoneBookInterfaceManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.310 -0400", hash_original_method = "631C425442894A51F9E1215F7444839C", hash_generated_method = "3393DD326A6C741AD03DB8FF07067C8D")
    public void registerForNvLoaded(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Registrant r;
        r = new Registrant (h, what, obj);
        mNvLoadedRegistrants.add(r);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //mNvLoadedRegistrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.310 -0400", hash_original_method = "FC47AF6104E2994A09ED5540AEE820A5", hash_generated_method = "1BAF190EE3D5D043167914001634FD8C")
    public void unregisterForNvLoaded(Handler h) {
        mNvLoadedRegistrants.remove(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mNvLoadedRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.311 -0400", hash_original_method = "76D872D60E8DF5A817173A7970E48DAF", hash_generated_method = "C847BFF1DBF62B62B0C4470BA5992AB7")
    public void registerForEriFileLoaded(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Registrant r;
        r = new Registrant (h, what, obj);
        mEriFileLoadedRegistrants.add(r);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //mEriFileLoadedRegistrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.311 -0400", hash_original_method = "609ACFE0DF3AD88014ED023EE4CC2BBF", hash_generated_method = "9D3DB37E087DCED5F348DC4C1E35429E")
    public void unregisterForEriFileLoaded(Handler h) {
        mEriFileLoadedRegistrants.remove(h);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mEriFileLoadedRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.311 -0400", hash_original_method = "C4157CB043EC8B3384F8270EB7DCD5BB", hash_generated_method = "159F2D28E3AC8B75EED9336F04B42E2B")
    public final void setSystemProperty(String property, String value) {
        super.setSystemProperty(property, value);
        addTaint(property.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //super.setSystemProperty(property, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.312 -0400", hash_original_method = "515987807F65054AFA6AA9A268DDB599", hash_generated_method = "3BAB1D4E7E96599FB817B919FB87D699")
    public IccFileHandler getIccFileHandler() {
        IccFileHandler varB4EAC82CA7396A68D541C85D26508E83_2067561661 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2067561661 = this.mIccFileHandler;
        varB4EAC82CA7396A68D541C85D26508E83_2067561661.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2067561661;
        // ---------- Original Method ----------
        //return this.mIccFileHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.312 -0400", hash_original_method = "793C414C17B853DD540D3B3DFD8290DE", hash_generated_method = "3A6B4BB2D15E44636A5D86BA61E9E72E")
    public void activateCellBroadcastSms(int activate, Message response) {
        response.sendToTarget();
        addTaint(activate);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[CDMAPhone] activateCellBroadcastSms() is obsolete; use SmsManager");
        //response.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.312 -0400", hash_original_method = "81E322CF525B990EC666DA306E1980A6", hash_generated_method = "2DC8511B8DEAA625E54F0B3CA6D0FC70")
    public void getCellBroadcastSmsConfig(Message response) {
        response.sendToTarget();
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[CDMAPhone] getCellBroadcastSmsConfig() is obsolete; use SmsManager");
        //response.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.316 -0400", hash_original_method = "718A796BA1FEFA7B8760E97D0CFF0F71", hash_generated_method = "C3142A16265BA5B9C66F462373D7D902")
    public void setCellBroadcastSmsConfig(int[] configValuesArray, Message response) {
        response.sendToTarget();
        addTaint(configValuesArray[0]);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[CDMAPhone] setCellBroadcastSmsConfig() is obsolete; use SmsManager");
        //response.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.317 -0400", hash_original_method = "C10911F486938B4F93DC849B5E1085A3", hash_generated_method = "A1283F2C4EBC406877456543653E92BA")
    @Override
    public boolean needsOtaServiceProvisioning() {
        boolean var3814F4E6C3697558290520EC0B4891A9_444907409 = (mSST.getOtasp() != ServiceStateTracker.OTASP_NOT_NEEDED);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1646066776 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1646066776;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.329 -0400", hash_original_method = "2F4529BDEA4C79E5E2F449E50272F3AC", hash_generated_method = "482E85A9B859877742A118B7D4BEE683")
    private boolean isCarrierOtaSpNum(String dialStr) {
        boolean isOtaSpNum;
        isOtaSpNum = false;
        int sysSelCodeInt;
        sysSelCodeInt = extractSelCodeFromOtaSpNum(dialStr);
        {
            boolean varC25E28587E797B4B1D25D8A223D7987E_1577845789 = (!TextUtils.isEmpty(mCarrierOtaSpNumSchema));
            {
                Matcher m;
                m = pOtaSpNumSchema.matcher(mCarrierOtaSpNumSchema);
                {
                    Log.d(LOG_TAG, "isCarrierOtaSpNum,schema" + mCarrierOtaSpNumSchema);
                } //End block
                {
                    boolean var39BD3106C7A2329BC5A3364836FB2CF9_296974639 = (m.find());
                    {
                        String sch[];
                        sch = pOtaSpNumSchema.split(mCarrierOtaSpNumSchema);
                        {
                            boolean varB2BFE86D7B99BED62C3AF16905511122_2088994735 = (!TextUtils.isEmpty(sch[0]) && sch[0].equals("SELC"));
                            {
                                {
                                    isOtaSpNum=checkOtaSpNumBasedOnSysSelCode(sysSelCodeInt,sch);
                                } //End block
                                {
                                    {
                                        Log.d(LOG_TAG, "isCarrierOtaSpNum,sysSelCodeInt is invalid");
                                    } //End block
                                } //End block
                            } //End block
                            {
                                boolean var981C353E34C8504891CF0AE981C84F35_1202486307 = (!TextUtils.isEmpty(sch[0]) && sch[0].equals("FC"));
                                {
                                    int fcLen;
                                    fcLen = Integer.parseInt((String)sch[1]);
                                    String fc;
                                    fc = (String)sch[2];
                                    {
                                        boolean varCF1EF44489814B5931C694BEAA6AF449_1102141709 = (dialStr.regionMatches(0,fc,0,fcLen));
                                        {
                                            isOtaSpNum = true;
                                        } //End block
                                        {
                                            Log.d(LOG_TAG, "isCarrierOtaSpNum,not otasp number");
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                                {
                                    {
                                        Log.d(LOG_TAG, "isCarrierOtaSpNum,ota schema not supported" + sch[0]);
                                    } //End block
                                } //End block
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End block
                    {
                        {
                            Log.d(LOG_TAG, "isCarrierOtaSpNum,ota schema pattern not right" +
                          mCarrierOtaSpNumSchema);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                Log.d(LOG_TAG, "isCarrierOtaSpNum,ota schema pattern empty");
            } //End block
        } //End collapsed parenthetic
        addTaint(dialStr.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1671376805 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1671376805;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.330 -0400", hash_original_method = "AE6C103DE6DE549189EC8F2DC89B4935", hash_generated_method = "2F29AEF174DFAE5F81644EE9F553E36B")
    @Override
    public boolean isOtaSpNumber(String dialStr) {
        boolean isOtaSpNum;
        isOtaSpNum = false;
        String dialableStr;
        dialableStr = PhoneNumberUtils.extractNetworkPortionAlt(dialStr);
        {
            isOtaSpNum = isIs683OtaSpDialStr(dialableStr);
            {
                isOtaSpNum = isCarrierOtaSpNum(dialableStr);
            } //End block
        } //End block
        Log.d(LOG_TAG, "isOtaSpNumber " + isOtaSpNum);
        addTaint(dialStr.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1675117542 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1675117542;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.330 -0400", hash_original_method = "CBAF5F4AF9A1C44FBA957D2F8ABDCEC2", hash_generated_method = "691C680035C890B9D705B034CECC7DAB")
    @Override
    public int getCdmaEriIconIndex() {
        int var7D21F14EF91E1D5E5A5201CD691F6EC1_324062773 = (getServiceState().getCdmaEriIconIndex());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_968940613 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_968940613;
        // ---------- Original Method ----------
        //return getServiceState().getCdmaEriIconIndex();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.334 -0400", hash_original_method = "505B53637594CBFFA64F8CC821649187", hash_generated_method = "BBAFE34FC64D155D4F89150AF809E485")
    @Override
    public int getCdmaEriIconMode() {
        int var14A1514753E21C20C1CFD187FB3391BF_504754432 = (getServiceState().getCdmaEriIconMode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1388949794 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1388949794;
        // ---------- Original Method ----------
        //return getServiceState().getCdmaEriIconMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.335 -0400", hash_original_method = "FF25B4C2C2FD6DDBAFFF02AC278A249A", hash_generated_method = "827D6F9F47E4701DD073DD5151C45D8C")
    @Override
    public String getCdmaEriText() {
        String varB4EAC82CA7396A68D541C85D26508E83_1727558434 = null; //Variable for return #1
        int roamInd;
        roamInd = getServiceState().getCdmaRoamingIndicator();
        int defRoamInd;
        defRoamInd = getServiceState().getCdmaDefaultRoamingIndicator();
        varB4EAC82CA7396A68D541C85D26508E83_1727558434 = mEriManager.getCdmaEriText(roamInd, defRoamInd);
        varB4EAC82CA7396A68D541C85D26508E83_1727558434.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1727558434;
        // ---------- Original Method ----------
        //int roamInd = getServiceState().getCdmaRoamingIndicator();
        //int defRoamInd = getServiceState().getCdmaDefaultRoamingIndicator();
        //return mEriManager.getCdmaEriText(roamInd, defRoamInd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.335 -0400", hash_original_method = "1FA484546C7B73CA49B2C4AE64A8C83E", hash_generated_method = "2074B8E4C80239FA504C484938C07809")
    private void storeVoiceMailNumber(String number) {
        SharedPreferences sp;
        sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor editor;
        editor = sp.edit();
        editor.putString(VM_NUMBER_CDMA, number);
        editor.apply();
        addTaint(number.getTaint());
        // ---------- Original Method ----------
        //SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        //SharedPreferences.Editor editor = sp.edit();
        //editor.putString(VM_NUMBER_CDMA, number);
        //editor.apply();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.350 -0400", hash_original_method = "04903824830A3F9FD2759E9C177CC0CB", hash_generated_method = "F5EDCD31CE1D9C3719D736AF90837D31")
    private void setIsoCountryProperty(String operatorNumeric) {
        {
            boolean var1C5534FDAA00A1B387A79218D6BAEF6C_1053349217 = (TextUtils.isEmpty(operatorNumeric));
            {
                setSystemProperty(PROPERTY_ICC_OPERATOR_ISO_COUNTRY, "");
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
                { }
                catch (StringIndexOutOfBoundsException ex)
                { }
                setSystemProperty(PROPERTY_ICC_OPERATOR_ISO_COUNTRY, iso);
            } //End block
        } //End collapsed parenthetic
        addTaint(operatorNumeric.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.351 -0400", hash_original_method = "B076A318D7F3CB7E259ECDC99FDB3D0D", hash_generated_method = "2A18EC95A2C725425F9AACCF0092A314")
     boolean updateCurrentCarrierInProvider(String operatorNumeric) {
        {
            boolean var94B3144E977DE08BBD4DC30162F60334_424869051 = (!TextUtils.isEmpty(operatorNumeric));
            {
                try 
                {
                    Uri uri;
                    uri = Uri.withAppendedPath(Telephony.Carriers.CONTENT_URI, "current");
                    ContentValues map;
                    map = new ContentValues();
                    map.put(Telephony.Carriers.NUMERIC, operatorNumeric);
                    log("updateCurrentCarrierInProvider from system: numeric=" + operatorNumeric);
                    getContext().getContentResolver().insert(uri, map);
                    MccTable.updateMccMncConfiguration(this, operatorNumeric);
                } //End block
                catch (SQLException e)
                { }
            } //End block
        } //End collapsed parenthetic
        addTaint(operatorNumeric.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_195793263 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_195793263;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.371 -0400", hash_original_method = "A95BEE5F1920F9C579D7A59FC4DBB414", hash_generated_method = "28EA9A3DDEC390CACA29F82C59FE3237")
     boolean updateCurrentCarrierInProvider() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1362615897 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1362615897;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.372 -0400", hash_original_method = "5CB32743CEBF9A8556BB2E144A975CB3", hash_generated_method = "1EE822DC960593C5A2FFD8B1756A969D")
    public void prepareEri() {
        mEriManager.loadEriFile();
        {
            boolean var07BA6C1E3CEBF9422B7FD30B01BA2995_942516500 = (mEriManager.isEriFileLoaded());
            {
                log("ERI read, notify registrants");
                mEriFileLoadedRegistrants.notifyRegistrants();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //mEriManager.loadEriFile();
        //if(mEriManager.isEriFileLoaded()) {
            //log("ERI read, notify registrants");
            //mEriFileLoadedRegistrants.notifyRegistrants();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.372 -0400", hash_original_method = "71144CF5C8B23350BF31931D81A1C3AC", hash_generated_method = "F7C134FD09EA36FFED33D30FADE0D871")
    public boolean isEriFileLoaded() {
        boolean varAA8EBCEDF474BF00A450A0F8740F0DD7_1751627255 = (mEriManager.isEriFileLoaded());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_546698770 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_546698770;
        // ---------- Original Method ----------
        //return mEriManager.isEriFileLoaded();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.376 -0400", hash_original_method = "CBB2DC533610D724567F0136955B7014", hash_generated_method = "02E1A2D63A196E8B73A1855751D4CA7E")
    protected void log(String s) {
        Log.d(LOG_TAG, "[CDMAPhone] " + s);
        addTaint(s.getTaint());
        // ---------- Original Method ----------
        //if (DBG)
            //Log.d(LOG_TAG, "[CDMAPhone] " + s);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.377 -0400", hash_original_field = "951C150E6D062E6AED2C45BB9B756185", hash_generated_field = "3985FC5365F0E17AC0BA70F3DC93B852")

    static String LOG_TAG = "CDMA";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.377 -0400", hash_original_field = "A4622F7F72162611C8E075EE443BC26E", hash_generated_field = "EA7FF8772A7B2A0121F9F6C2158F8474")

    private static boolean DBG = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.377 -0400", hash_original_field = "5320633AA3BFE71644D90157C1CD824C", hash_generated_field = "7A6BCC5D4E8F0880115E636F0FD6E94D")

    private static int DEFAULT_ECM_EXIT_TIMER_VALUE = 300000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.379 -0400", hash_original_field = "3EDCC9CC37CA195649B1285985E473C3", hash_generated_field = "99D13DA451F9583FD0BE871BE056EC3A")

    static String VM_COUNT_CDMA = "vm_count_key_cdma";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.379 -0400", hash_original_field = "668CB3B3609C678099375254C8D95AA7", hash_generated_field = "16CC418648C2B1DF8A3231D33D39A301")

    private static String VM_NUMBER_CDMA = "vm_number_key_cdma";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.379 -0400", hash_original_field = "EC49609D403603D3B7721BA3617C00E8", hash_generated_field = "2D13232720EFED9A89C25E2FAA9213CA")

    static int RESTART_ECM_TIMER = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.379 -0400", hash_original_field = "2985483F14B41C74EABD7BCA0321F3DF", hash_generated_field = "77623487C4F19223F00476FF1264E0E0")

    static int CANCEL_ECM_TIMER = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.379 -0400", hash_original_field = "843F0250B369902370F83939F540B081", hash_generated_field = "1B6AA95D9706EED43D662EF600D64CB5")

    static String PROPERTY_CDMA_HOME_OPERATOR_NUMERIC = "ro.cdma.home.operator.numeric";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.379 -0400", hash_original_field = "3BA08B3453AFD8EBCFB22E951AED80DF", hash_generated_field = "97CFA891A924147FD0557348A7F1DD4D")

    private static String IS683A_FEATURE_CODE = "*228";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.379 -0400", hash_original_field = "9DBDB8BAEDF244A1BD45FE7B339131C9", hash_generated_field = "1489149C7176EA88123BFC3653B76DBF")

    private static int IS683A_FEATURE_CODE_NUM_DIGITS = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.379 -0400", hash_original_field = "11A59DFDA1E768721414AA1C69B63C9E", hash_generated_field = "4C4AB96343A529D08C1B61C41F59DFFA")

    private static int IS683A_SYS_SEL_CODE_NUM_DIGITS = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.379 -0400", hash_original_field = "C25262C71335F27E381F2311FF881E33", hash_generated_field = "3E300640F34DE1876DDA7227F7DA9D74")

    private static int IS683A_SYS_SEL_CODE_OFFSET = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.380 -0400", hash_original_field = "8C6441FCC50B0830A2410221AE8A4925", hash_generated_field = "ED78F4ADC22BC53939EA39045D13041A")

    private static int IS683_CONST_800MHZ_A_BAND = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.380 -0400", hash_original_field = "B34BEF5E9252F376624F20F747B810F8", hash_generated_field = "2CEAC531207EA66CC3C4CF6458F749C5")

    private static int IS683_CONST_800MHZ_B_BAND = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.380 -0400", hash_original_field = "DF632DFB5EF94CD03C3D2D9E67F0C0E8", hash_generated_field = "5D356D24EFD9818BEDD1DCE39325712E")

    private static int IS683_CONST_1900MHZ_A_BLOCK = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.380 -0400", hash_original_field = "6977A7F81CF8832CE0006DC6B400488F", hash_generated_field = "152D29FD1F9C486F181A88FCDA9ED466")

    private static int IS683_CONST_1900MHZ_B_BLOCK = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.380 -0400", hash_original_field = "5E9B40F193BFBBDABC03738CDD356C56", hash_generated_field = "49D76BC72156A406D2291E2861D55719")

    private static int IS683_CONST_1900MHZ_C_BLOCK = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.380 -0400", hash_original_field = "812E250D039979870F8BF7827DD6942E", hash_generated_field = "40AB120B3469E8FA738CADF70E06E7B3")

    private static int IS683_CONST_1900MHZ_D_BLOCK = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.380 -0400", hash_original_field = "6900F8029CB6DAC6B0B3C8BC7FA5584A", hash_generated_field = "42E2AD70A0DA030179C804E3883E3404")

    private static int IS683_CONST_1900MHZ_E_BLOCK = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.380 -0400", hash_original_field = "59BD6B30FEF1B370EA610752E954CE82", hash_generated_field = "80E282146FC2BB6301CFC1F87D4FBE1D")

    private static int IS683_CONST_1900MHZ_F_BLOCK = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.380 -0400", hash_original_field = "B5DE06BE2A525381D4B4AD5CFA1561B2", hash_generated_field = "10B929B44306EC75D82249FA1A477A37")

    private static int INVALID_SYSTEM_SELECTION_CODE = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.380 -0400", hash_original_field = "7B0F019D05983EE374EEDBA360DA6CD2", hash_generated_field = "A75E56C661E3C1889447602EFA0983FC")

    private static Pattern pOtaSpNumSchema = Pattern.compile("[,\\s]+");
}

