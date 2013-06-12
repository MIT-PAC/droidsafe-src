package com.android.internal.telephony.cdma;

// Droidsafe Imports
import static com.android.internal.telephony.TelephonyProperties.PROPERTY_ICC_OPERATOR_ALPHA;
import static com.android.internal.telephony.TelephonyProperties.PROPERTY_ICC_OPERATOR_ISO_COUNTRY;
import static com.android.internal.telephony.TelephonyProperties.PROPERTY_ICC_OPERATOR_NUMERIC;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import com.android.internal.telephony.PhoneSubInfo;
import com.android.internal.telephony.ServiceStateTracker;
import com.android.internal.telephony.TelephonyIntents;
import com.android.internal.telephony.TelephonyProperties;
import com.android.internal.telephony.UUSInfo;
import com.android.internal.telephony.cat.CatService;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.runtime.DroidSafeAndroidRuntime;
// import Iterator to deal with enhanced for loop translation

public class CDMAPhone extends PhoneBase {
    static final String LOG_TAG = "CDMA";
    private static final boolean DBG = true;
    private static final int DEFAULT_ECM_EXIT_TIMER_VALUE = 300000;
    static final String VM_COUNT_CDMA = "vm_count_key_cdma";
    private static final String VM_NUMBER_CDMA = "vm_number_key_cdma";
    private String mVmNumber = null;
    static final int RESTART_ECM_TIMER = 0;
    static final int CANCEL_ECM_TIMER = 1;
    CdmaCallTracker mCT;
    CdmaServiceStateTracker mSST;
    ArrayList <CdmaMmiCode> mPendingMmis = new ArrayList<CdmaMmiCode>();
    RuimPhoneBookInterfaceManager mRuimPhoneBookInterfaceManager;
    RuimSmsInterfaceManager mRuimSmsInterfaceManager;
    PhoneSubInfo mSubInfo;
    EriManager mEriManager;
    WakeLock mWakeLock;
    CatService mCcatService;
    private final RegistrantList mNvLoadedRegistrants = new RegistrantList();
    private final RegistrantList mEriFileLoadedRegistrants = new RegistrantList();
    private final RegistrantList mEcmTimerResetRegistrants = new RegistrantList();
    private boolean mIsPhoneInEcmState;
    private Registrant mEcmExitRespRegistrant;
    protected String mImei;
    protected String mImeiSv;
    private String mEsn;
    private String mMeid;
    private String mCarrierOtaSpNumSchema;
    private Runnable mExitEcmRunnable = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.710 -0400", hash_original_method = "F3DC5BFDA25D02344EBFE8F4AEC767D8", hash_generated_method = "3D3A519E83E7E2DEC6F223EBAB43CE23")
        @DSModeled(DSC.SAFE)
        @Override
        public void run() {
            exitEmergencyCallbackMode();
            // ---------- Original Method ----------
            //exitEmergencyCallbackMode();
        }

        
}; //Transformed anonymous class
    Registrant mPostDialHandler;
    static String PROPERTY_CDMA_HOME_OPERATOR_NUMERIC = "ro.cdma.home.operator.numeric";
    private static final String IS683A_FEATURE_CODE = "*228";
    private static final int IS683A_FEATURE_CODE_NUM_DIGITS = 4;
    private static final int IS683A_SYS_SEL_CODE_NUM_DIGITS = 2;
    private static final int IS683A_SYS_SEL_CODE_OFFSET = 4;
    private static final int IS683_CONST_800MHZ_A_BAND = 0;
    private static final int IS683_CONST_800MHZ_B_BAND = 1;
    private static final int IS683_CONST_1900MHZ_A_BLOCK = 2;
    private static final int IS683_CONST_1900MHZ_B_BLOCK = 3;
    private static final int IS683_CONST_1900MHZ_C_BLOCK = 4;
    private static final int IS683_CONST_1900MHZ_D_BLOCK = 5;
    private static final int IS683_CONST_1900MHZ_E_BLOCK = 6;
    private static final int IS683_CONST_1900MHZ_F_BLOCK = 7;
    private static final int INVALID_SYSTEM_SELECTION_CODE = -1;
    private static Pattern pOtaSpNumSchema = Pattern.compile("[,\\s]+");
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.710 -0400", hash_original_method = "DAE6B8BFE7F70789DB7C3B99D4D5F7DA", hash_generated_method = "80EAB55DCC59F78C14144E01099AD374")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CDMAPhone(Context context, CommandsInterface ci, PhoneNotifier notifier) {
        super(notifier, context, ci, false);
        dsTaint.addTaint(notifier.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(ci.dsTaint);
        initSstIcc();
        init(context, notifier);
        // ---------- Original Method ----------
        //initSstIcc();
        //init(context, notifier);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.710 -0400", hash_original_method = "467D4326BF1EF0C31B8D509189D4E2E0", hash_generated_method = "D2C56E23D5445D0BBC83EA3C55D8AED5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CDMAPhone(Context context, CommandsInterface ci, PhoneNotifier notifier,
            boolean unitTestMode) {
        super(notifier, context, ci, unitTestMode);
        dsTaint.addTaint(unitTestMode);
        dsTaint.addTaint(notifier.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(ci.dsTaint);
        initSstIcc();
        init(context, notifier);
        // ---------- Original Method ----------
        //initSstIcc();
        //init(context, notifier);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.710 -0400", hash_original_method = "1B7DFBB42AE4FBFECC004BFFF3CFFDDB", hash_generated_method = "C0AB6AEE39231959BCEDFA13E282FAE5")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.710 -0400", hash_original_method = "8461B888D034831850AE73E07FC3F149", hash_generated_method = "A4F9FD1DD410DECA7391386B22FD6645")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void init(Context context, PhoneNotifier notifier) {
        dsTaint.addTaint(notifier.dsTaint);
        dsTaint.addTaint(context.dsTaint);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.711 -0400", hash_original_method = "9DE3C78959AC59CCA27F149210FA77A8", hash_generated_method = "9B4CA81CA0A3609CF622000E8507F4A8")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.711 -0400", hash_original_method = "EE2FF8AAD85928FB8E8B4233881FEB3A", hash_generated_method = "0CE8263A6BF34FE2B578C57676E37DEF")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.711 -0400", hash_original_method = "717E537581BE31A7DC523FEE6B0DDE4B", hash_generated_method = "466AC80FACB36686A92D5500DF844316")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void finalize() {
        Log.d(LOG_TAG, "CDMAPhone finalized");
        {
            boolean varC8E4FB4CC0E8CC6621CB9ECC0FDC7EC6_1009201823 = (mWakeLock.isHeld());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.711 -0400", hash_original_method = "DA0F221C2247572C4D631280E4033E9A", hash_generated_method = "E5B6B1EB690F6D9B088917DBAE500728")
    @DSModeled(DSC.SAFE)
    public ServiceState getServiceState() {
        return (ServiceState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mSST.ss;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.711 -0400", hash_original_method = "79AFD9B845E4547B981131DAC9E3A14D", hash_generated_method = "B3B044A0E4933B0511AB40BCB30872E5")
    @DSModeled(DSC.SAFE)
    public CallTracker getCallTracker() {
        return (CallTracker)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.711 -0400", hash_original_method = "8AEFB373111A9C8AD30F3E8C75C461D2", hash_generated_method = "C213A0F99DA8FA5EE553344DA708C105")
    @DSModeled(DSC.SAFE)
    public Phone.State getState() {
        return (Phone.State)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCT.state;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.711 -0400", hash_original_method = "BD481539215D5A66E62B4E6909625141", hash_generated_method = "275A6A34F7E687340703DD9210B6F4DE")
    @DSModeled(DSC.SAFE)
    public ServiceStateTracker getServiceStateTracker() {
        return (ServiceStateTracker)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mSST;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.711 -0400", hash_original_method = "B0BDAF041F7F636A26D0F46F60D4BC7B", hash_generated_method = "6AEC5622E059313F06CDA2E0F7DE04B7")
    @DSModeled(DSC.SAFE)
    public String getPhoneName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "CDMA";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.711 -0400", hash_original_method = "94F6AF6179535CBD756D5B387D52C3CA", hash_generated_method = "A9D268ADDD20B1F2B797410F89306418")
    @DSModeled(DSC.SAFE)
    public int getPhoneType() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return Phone.PHONE_TYPE_CDMA;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.711 -0400", hash_original_method = "F828A2F1845194FFD82C471D7E89F726", hash_generated_method = "CC15A32A2BE79712E9F10E2D58350953")
    @DSModeled(DSC.SAFE)
    public boolean canTransfer() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "canTransfer: not possible in CDMA");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.711 -0400", hash_original_method = "31E0316605311F71BD2BE82139C4C7B1", hash_generated_method = "113F33037B09F925222C1607ED5C4649")
    @DSModeled(DSC.SAFE)
    public CdmaCall getRingingCall() {
        return (CdmaCall)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCT.ringingCall;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.711 -0400", hash_original_method = "E892EC268DCFDF5C9C27A7DDC7E00573", hash_generated_method = "32B6FA271BB0C59B1698D317D84B7276")
    @DSModeled(DSC.SAFE)
    public void setMute(boolean muted) {
        dsTaint.addTaint(muted);
        mCT.setMute(muted);
        // ---------- Original Method ----------
        //mCT.setMute(muted);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.711 -0400", hash_original_method = "FA6E824680C8944626A1A959DCEA6499", hash_generated_method = "4DF2CEA1D187A6118E020758FB9CD3BB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getMute() {
        boolean var20663A120A6F5E860F4EB58F2E5B9228_1754694810 = (mCT.getMute());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCT.getMute();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.711 -0400", hash_original_method = "593DDE28AC9DCA9096C93A9D0D1099FC", hash_generated_method = "AFA63F7018E14C8871A1B1E74CE7DBC3")
    @DSModeled(DSC.SAFE)
    public void conference() throws CallStateException {
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "conference: not possible in CDMA");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.712 -0400", hash_original_method = "F90799FAE99EB431CF7F205DFD6DDD5D", hash_generated_method = "B36F42E90B7A8480DA06667CD844A8D0")
    @DSModeled(DSC.SAFE)
    public void enableEnhancedVoicePrivacy(boolean enable, Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(enable);
        this.mCM.setPreferredVoicePrivacy(enable, onComplete);
        // ---------- Original Method ----------
        //this.mCM.setPreferredVoicePrivacy(enable, onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.712 -0400", hash_original_method = "5CE753EAA3145BBCA6A00800B2884B4E", hash_generated_method = "5242C6FB861F69C86577E99DEFDCD236")
    @DSModeled(DSC.SAFE)
    public void getEnhancedVoicePrivacy(Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        this.mCM.getPreferredVoicePrivacy(onComplete);
        // ---------- Original Method ----------
        //this.mCM.getPreferredVoicePrivacy(onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.712 -0400", hash_original_method = "B9932A8A8BD16A4F0D461DDC6FDE6B49", hash_generated_method = "393DE7A74F05B4DF79434488A3AC122A")
    @DSModeled(DSC.SAFE)
    public void clearDisconnected() {
        mCT.clearDisconnected();
        // ---------- Original Method ----------
        //mCT.clearDisconnected();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.712 -0400", hash_original_method = "34BFC6F1F77B77A760EA5A249CE3FEFD", hash_generated_method = "AEFF2D4123CEF337CF578A74D8229A31")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DataActivityState getDataActivityState() {
        DataActivityState ret;
        ret = DataActivityState.NONE;
        {
            boolean varA31FE6075ED3D4825296DCCB8274BE5E_1525386596 = (mSST.getCurrentDataConnectionState() == ServiceState.STATE_IN_SERVICE);
            {
                {
                    Object var27C7E0FDBE09DE35AC2FD606F73591E2_387265738 = (mDataConnectionTracker.getActivity());
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
        return (DataActivityState)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.712 -0400", hash_original_method = "FCBAE539BB72BE21647FF37299DC2B96", hash_generated_method = "CEEF8D82465CDCDFD1F53A1B040E9431")
    @DSModeled(DSC.SAFE)
     void notifySignalStrength() {
        mNotifier.notifySignalStrength(this);
        // ---------- Original Method ----------
        //mNotifier.notifySignalStrength(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.712 -0400", hash_original_method = "3B6D00BA5404778271A196326B2492C1", hash_generated_method = "036BFCF30627646DBBEF143AD443A4A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Connection dial(String dialString) throws CallStateException {
        dsTaint.addTaint(dialString);
        String newDialString;
        newDialString = PhoneNumberUtils.stripSeparators(dialString);
        Connection var6E19EB04677F631A73FAB796C0759274_2135022107 = (mCT.dial(newDialString));
        return (Connection)dsTaint.getTaint();
        // ---------- Original Method ----------
        //String newDialString = PhoneNumberUtils.stripSeparators(dialString);
        //return mCT.dial(newDialString);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.712 -0400", hash_original_method = "C4CAEF0C07F27C620A5D9B835D3227D9", hash_generated_method = "B10E1D4801BEDD12D107B8EF1F55ACB0")
    @DSModeled(DSC.SAFE)
    public Connection dial(String dialString, UUSInfo uusInfo) throws CallStateException {
        dsTaint.addTaint(uusInfo.dsTaint);
        dsTaint.addTaint(dialString);
        if (DroidSafeAndroidRuntime.control) throw new CallStateException("Sending UUS information NOT supported in CDMA!");
        return (Connection)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new CallStateException("Sending UUS information NOT supported in CDMA!");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.712 -0400", hash_original_method = "46D9BC6E3280014832CD8FC523C20E6E", hash_generated_method = "EA00D66BFBB261E1E499401384677B14")
    @DSModeled(DSC.SAFE)
    public SignalStrength getSignalStrength() {
        return (SignalStrength)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mSST.mSignalStrength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.712 -0400", hash_original_method = "391334830335544CEFDB5805671813C7", hash_generated_method = "9E57C24C5C46FD6CE368A264BB80D61C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getMessageWaitingIndicator() {
        boolean var197AD52F07C983B246C350347281E552_501429179 = ((getVoiceMessageCount() > 0));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (getVoiceMessageCount() > 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.712 -0400", hash_original_method = "A1DC624417B44DF11F4CA5E5B97277AF", hash_generated_method = "718BD551958B19C2C389AB902196A3CA")
    @DSModeled(DSC.SAFE)
    public List<? extends MmiCode> getPendingMmiCodes() {
        return (List<? extends MmiCode>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mPendingMmis;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.712 -0400", hash_original_method = "7C5A8D3C952528E3E4A994337305A33B", hash_generated_method = "CDF6DE44E7C0FF0FC9F4939871FC906F")
    @DSModeled(DSC.SAFE)
    public void registerForSuppServiceNotification(
            Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "method registerForSuppServiceNotification is NOT supported in CDMA!");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.712 -0400", hash_original_method = "9F7E8D6F89A6C75F0A7653B179AA02CE", hash_generated_method = "B85C6563A85D861A72BDAC21C055BF33")
    @DSModeled(DSC.SAFE)
    public CdmaCall getBackgroundCall() {
        return (CdmaCall)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCT.backgroundCall;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.712 -0400", hash_original_method = "99F7E880D5431452FB99636E33872BD4", hash_generated_method = "4461BA28C27AFBF922F76E8DD511237C")
    @DSModeled(DSC.SAFE)
    public boolean handleInCallMmiCommands(String dialString) {
        dsTaint.addTaint(dialString);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "method handleInCallMmiCommands is NOT supported in CDMA!");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.712 -0400", hash_original_method = "F6112A9AE3405415322B12D2CA172B80", hash_generated_method = "40C127ECB02FBBDD2FC4D6083E6258B4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean isInCall() {
        CdmaCall.State foregroundCallState;
        foregroundCallState = getForegroundCall().getState();
        CdmaCall.State backgroundCallState;
        backgroundCallState = getBackgroundCall().getState();
        CdmaCall.State ringingCallState;
        ringingCallState = getRingingCall().getState();
        boolean var4B59C8CBE40B3534DD50EEA545B62F2B_1613352420 = ((foregroundCallState.isAlive() || backgroundCallState.isAlive() || ringingCallState
                .isAlive()));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //CdmaCall.State foregroundCallState = getForegroundCall().getState();
        //CdmaCall.State backgroundCallState = getBackgroundCall().getState();
        //CdmaCall.State ringingCallState = getRingingCall().getState();
        //return (foregroundCallState.isAlive() || backgroundCallState.isAlive() || ringingCallState
                //.isAlive());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.712 -0400", hash_original_method = "573D1DDDB474C2914324D2DBB21AD4BF", hash_generated_method = "0B053796FF76EA32FE86B437CC6F60B2")
    @DSModeled(DSC.SAFE)
    public void setNetworkSelectionModeAutomatic(Message response) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(response.dsTaint);
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "method setNetworkSelectionModeAutomatic is NOT supported in CDMA!");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.713 -0400", hash_original_method = "7239EAF7B36D814AB7CF7CD5314FF0C2", hash_generated_method = "94DD1E70A7C934BDAE66E5C5AC8A6E19")
    @DSModeled(DSC.SAFE)
    public void unregisterForSuppServiceNotification(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "method unregisterForSuppServiceNotification is NOT supported in CDMA!");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.713 -0400", hash_original_method = "C62CCD6CF2D9D7F7FA17BB7B58067AAC", hash_generated_method = "6B190360036E3A5244EB456775084C95")
    @DSModeled(DSC.SAFE)
    public void acceptCall() throws CallStateException {
        mCT.acceptCall();
        // ---------- Original Method ----------
        //mCT.acceptCall();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.713 -0400", hash_original_method = "A64616985F0D82C6750D71CF8DADC6F4", hash_generated_method = "D7FCF62E2A54A2E94882B5B7CDAE3B04")
    @DSModeled(DSC.SAFE)
    public void rejectCall() throws CallStateException {
        mCT.rejectCall();
        // ---------- Original Method ----------
        //mCT.rejectCall();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.713 -0400", hash_original_method = "4BD56579DA53A7A8E0646A63E1978FC8", hash_generated_method = "0DE95364DCB508E20E9E381CA156DCA7")
    @DSModeled(DSC.SAFE)
    public void switchHoldingAndActive() throws CallStateException {
        mCT.switchWaitingOrHoldingAndActive();
        // ---------- Original Method ----------
        //mCT.switchWaitingOrHoldingAndActive();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.713 -0400", hash_original_method = "B121BB30C6EA08968FF3C722126FC795", hash_generated_method = "A1EAF65273FFCE9AD30828D641499163")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getLine1Number() {
        String var22E79D7850EE159DBDC01B7FDFB474E0_996594654 = (mSST.getMdnNumber());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mSST.getMdnNumber();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.713 -0400", hash_original_method = "3BC6D82D8BFD82220414E9A1151516B0", hash_generated_method = "D50E77D63C4DBB926C31EE1FB70A7674")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getCdmaPrlVersion() {
        String var7FA4B923BA239B2BAD6CE387E9196018_128765726 = (mSST.getPrlVersion());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mSST.getPrlVersion();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.713 -0400", hash_original_method = "5F3989DCB2E6CEB13D99C9EB5DB3E7E9", hash_generated_method = "0F60A43B518F096A36B2383BD56C1878")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getCdmaMin() {
        String varF449B47F9FD9B580D1FDC5BF81456080_1918085974 = (mSST.getCdmaMin());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mSST.getCdmaMin();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.713 -0400", hash_original_method = "8703C344BAEB4A9DC4BE8D85F2A2B471", hash_generated_method = "0F68BD228D7DEB13DC6AE0295F902D14")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isMinInfoReady() {
        boolean var9484B5471A0F2E2C668270A249557278_844046371 = (mSST.isMinInfoReady());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mSST.isMinInfoReady();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.713 -0400", hash_original_method = "4561349219664D3BF60D1FEC45B8BB02", hash_generated_method = "F54BDC38A2D2C04FDB06165D2EB1939A")
    @DSModeled(DSC.SAFE)
    public void getCallWaiting(Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        mCM.queryCallWaiting(CommandsInterface.SERVICE_CLASS_VOICE, onComplete);
        // ---------- Original Method ----------
        //mCM.queryCallWaiting(CommandsInterface.SERVICE_CLASS_VOICE, onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.713 -0400", hash_original_method = "6583EBFAAE11F5B271B0C202AB11C3E9", hash_generated_method = "5BEBA30A01D6E016F48B42CCFEFBCC2D")
    @DSModeled(DSC.SAFE)
    public void setRadioPower(boolean power) {
        dsTaint.addTaint(power);
        mSST.setRadioPower(power);
        // ---------- Original Method ----------
        //mSST.setRadioPower(power);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.713 -0400", hash_original_method = "A71BC42B8E5B39F885F4E0F3CDCE1523", hash_generated_method = "0A73F82F27D42266CC71316EA6738631")
    @DSModeled(DSC.SAFE)
    public String getEsn() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mEsn;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.713 -0400", hash_original_method = "7E7AAA89C01F3229F1902E361A6CD86F", hash_generated_method = "EC0213B6FB51C5F73DC9E448B925229A")
    @DSModeled(DSC.SAFE)
    public String getMeid() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mMeid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.713 -0400", hash_original_method = "7766C412A244B7E9ACAC69FB73BBB546", hash_generated_method = "0CF4E06A6146A478C764A2D85C0818C0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getDeviceId() {
        String id;
        id = getMeid();
        {
            boolean varAF1C852358631BCBFACC3CD12BED0C0E_1972965081 = ((id == null) || id.matches("^0*$"));
            {
                Log.d(LOG_TAG, "getDeviceId(): MEID is not initialized use ESN");
                id = getEsn();
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String id = getMeid();
        //if ((id == null) || id.matches("^0*$")) {
            //Log.d(LOG_TAG, "getDeviceId(): MEID is not initialized use ESN");
            //id = getEsn();
        //}
        //return id;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.713 -0400", hash_original_method = "BA19C271165532D38DF9C2A2EC7580FC", hash_generated_method = "A3F7CE9A340230338C2E498711D4CE8A")
    @DSModeled(DSC.SAFE)
    public String getDeviceSvn() {
        Log.d(LOG_TAG, "getDeviceSvn(): return 0");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "getDeviceSvn(): return 0");
        //return "0";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.713 -0400", hash_original_method = "32994E1C8E091DA1F8318F6B29B65F50", hash_generated_method = "0818232FC4E2CA020B3FAFDD838791EC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getSubscriberId() {
        String varF1487D2964529CABB8DF8FF6340A599E_2147269038 = (mSST.getImsi());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mSST.getImsi();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.713 -0400", hash_original_method = "FAD82CEAF9DD41800ADBC5F4734356D8", hash_generated_method = "1FDE0B5476283F80FA066646A377E33D")
    @DSModeled(DSC.SAFE)
    public String getImei() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "IMEI is not available in CDMA");
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.713 -0400", hash_original_method = "3D81DB016065E96128526DD50CCAAE05", hash_generated_method = "0C64F3ED3A2B0B1E3CA4889BC1783930")
    @DSModeled(DSC.SAFE)
    public boolean canConference() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "canConference: not possible in CDMA");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.713 -0400", hash_original_method = "E38329BE2FF507326358BBAF596945E6", hash_generated_method = "D4688C8F6494DE9BFCEE607AF443C552")
    @DSModeled(DSC.SAFE)
    public CellLocation getCellLocation() {
        return (CellLocation)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mSST.cellLoc;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.713 -0400", hash_original_method = "5D417D4C057D78BF0DEF3D949E557B3C", hash_generated_method = "0710EF53F20DC49CC79F3E0E2DDA53BA")
    @DSModeled(DSC.SAFE)
    public CdmaCall getForegroundCall() {
        return (CdmaCall)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCT.foregroundCall;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.713 -0400", hash_original_method = "6287E103949DE4B29FC1760D95391284", hash_generated_method = "38DE71B1ED36C66FD87259429521CC88")
    @DSModeled(DSC.SAFE)
    public void selectNetworkManually(OperatorInfo network,
            Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(network.dsTaint);
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "selectNetworkManually: not possible in CDMA");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.714 -0400", hash_original_method = "A54F4B18F21B3A39961648F4BDA2F061", hash_generated_method = "A825A34554D8D2C4EA026942A600A43D")
    @DSModeled(DSC.SAFE)
    public void setOnPostDialCharacter(Handler h, int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mPostDialHandler = new Registrant(h, what, obj);
        // ---------- Original Method ----------
        //mPostDialHandler = new Registrant(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.714 -0400", hash_original_method = "3D832E28FC020C3451E1ECD577F7705D", hash_generated_method = "0B4D92173E113A6528E342AA60846627")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean handlePinMmi(String dialString) {
        dsTaint.addTaint(dialString);
        CdmaMmiCode mmi;
        mmi = CdmaMmiCode.newFromDialString(dialString, this);
        {
            boolean var1028666450F47101F5E9163275C14E96_192532386 = (mmi.isPukCommand());
            {
                mPendingMmis.add(mmi);
                mMmiRegistrants.notifyRegistrants(new AsyncResult(null, mmi, null));
                mmi.processCode();
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.714 -0400", hash_original_method = "574EFAE567BAC054324E4789AB0ACA21", hash_generated_method = "4715014804DDC53DD573E008133886BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void onMMIDone(CdmaMmiCode mmi) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(mmi.dsTaint);
        {
            boolean var2994F1DD658E93A134FDDE87066FC8E4_1850802893 = (mPendingMmis.remove(mmi));
            {
                mMmiCompleteRegistrants.notifyRegistrants(new AsyncResult(null, mmi, null));
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (mPendingMmis.remove(mmi)) {
            //mMmiCompleteRegistrants.notifyRegistrants(new AsyncResult(null, mmi, null));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.714 -0400", hash_original_method = "8885A01E1E8D54116E470B45B5958287", hash_generated_method = "301D13E2ABA7FF442F7374658B90659D")
    @DSModeled(DSC.SAFE)
    public void setLine1Number(String alphaTag, String number, Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(number);
        dsTaint.addTaint(alphaTag);
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "setLine1Number: not possible in CDMA");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.714 -0400", hash_original_method = "9F48D83DEE90081423E43167EA0B9F32", hash_generated_method = "3320EF149A1A4FE05001C93FC80E35DF")
    @DSModeled(DSC.SAFE)
    public void setCallWaiting(boolean enable, Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(enable);
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "method setCallWaiting is NOT supported in CDMA!");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.714 -0400", hash_original_method = "96CADC2872DB4F7FDEDEDD322815973F", hash_generated_method = "A022147E6D33714727376A653DCDE620")
    @DSModeled(DSC.SAFE)
    public void updateServiceLocation() {
        mSST.enableSingleLocationUpdate();
        // ---------- Original Method ----------
        //mSST.enableSingleLocationUpdate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.714 -0400", hash_original_method = "910AE5D7D70CC37EC2511A21C3761E3A", hash_generated_method = "8EAF68FE7CE73B4AB3E06DCEFBF1E67C")
    @DSModeled(DSC.SAFE)
    public void setDataRoamingEnabled(boolean enable) {
        dsTaint.addTaint(enable);
        mDataConnectionTracker.setDataOnRoamingEnabled(enable);
        // ---------- Original Method ----------
        //mDataConnectionTracker.setDataOnRoamingEnabled(enable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.714 -0400", hash_original_method = "610E8C97A082907006BA954BE534B9EC", hash_generated_method = "77B787724385EA2050CC419BB0F659E0")
    @DSModeled(DSC.SAFE)
    public void registerForCdmaOtaStatusChange(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mCM.registerForCdmaOtaProvision(h, what, obj);
        // ---------- Original Method ----------
        //mCM.registerForCdmaOtaProvision(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.714 -0400", hash_original_method = "BBA791A1BBD0F6B3058E9616045D8082", hash_generated_method = "979082F46F7FDB824D3331861EE6F37A")
    @DSModeled(DSC.SAFE)
    public void unregisterForCdmaOtaStatusChange(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mCM.unregisterForCdmaOtaProvision(h);
        // ---------- Original Method ----------
        //mCM.unregisterForCdmaOtaProvision(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.714 -0400", hash_original_method = "832A3DCDB2173345E213F4FEE097F4C8", hash_generated_method = "43FAC0860E9E4C8D4C16A5CEC9DA6090")
    @DSModeled(DSC.SAFE)
    public void registerForSubscriptionInfoReady(Handler h, int what, Object obj) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mSST.registerForSubscriptionInfoReady(h, what, obj);
        // ---------- Original Method ----------
        //mSST.registerForSubscriptionInfoReady(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.714 -0400", hash_original_method = "8678E3A1722432B3AEE20746D6239509", hash_generated_method = "FD35B2FC7362DA74EAA8BBF309E1A913")
    @DSModeled(DSC.SAFE)
    public void unregisterForSubscriptionInfoReady(Handler h) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mSST.unregisterForSubscriptionInfoReady(h);
        // ---------- Original Method ----------
        //mSST.unregisterForSubscriptionInfoReady(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.714 -0400", hash_original_method = "9CC75D31629A3B23A63ED4AF8AC1CC3C", hash_generated_method = "FA6EE3DB40739582EF60C4CCF277090B")
    @DSModeled(DSC.SAFE)
    public void setOnEcbModeExitResponse(Handler h, int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mEcmExitRespRegistrant = new Registrant (h, what, obj);
        // ---------- Original Method ----------
        //mEcmExitRespRegistrant = new Registrant (h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.714 -0400", hash_original_method = "40447D9C1BA4AF14D98FB8C3ACDE2526", hash_generated_method = "D31291B163797AFA1AACF9C0FBE2D463")
    @DSModeled(DSC.SAFE)
    public void unsetOnEcbModeExitResponse(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mEcmExitRespRegistrant.clear();
        // ---------- Original Method ----------
        //mEcmExitRespRegistrant.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.714 -0400", hash_original_method = "0F8C6CFDB05E5D9DD9E146C1B344047B", hash_generated_method = "BBA8081C8E8C4F0E80F1DE302ACC5A34")
    @DSModeled(DSC.SAFE)
    public void registerForCallWaiting(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mCT.registerForCallWaiting(h, what, obj);
        // ---------- Original Method ----------
        //mCT.registerForCallWaiting(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.714 -0400", hash_original_method = "0239428C6B544E5C48B7505010514559", hash_generated_method = "F80FB5C095F274071CD00DFECD07F8BB")
    @DSModeled(DSC.SAFE)
    public void unregisterForCallWaiting(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mCT.unregisterForCallWaiting(h);
        // ---------- Original Method ----------
        //mCT.unregisterForCallWaiting(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.714 -0400", hash_original_method = "639F59C576968CC215A4C16BCF60725F", hash_generated_method = "471630F1239BE109084914A85CC1D62F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getNeighboringCids(Message response) {
        dsTaint.addTaint(response.dsTaint);
        {
            CommandException ce;
            ce = new CommandException(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.715 -0400", hash_original_method = "872EFAB028EF9345A6D84A5CBF27D619", hash_generated_method = "6E3B560878A7001FE85177FC2A2248C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DataState getDataConnectionState(String apnType) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(apnType);
        DataState ret;
        ret = DataState.DISCONNECTED;
        {
            ret = DataState.DISCONNECTED;
        } //End block
        {
            boolean var2B4A8E6DAE4C8B61542DA3830F844B7B_434427925 = (mSST.getCurrentDataConnectionState() != ServiceState.STATE_IN_SERVICE);
            {
                ret = DataState.DISCONNECTED;
            } //End block
            {
                boolean varEDC38D72B2381B58A0F3730E74C3817C_599846198 = (mDataConnectionTracker.isApnTypeEnabled(apnType) == false ||
                mDataConnectionTracker.isApnTypeActive(apnType) == false);
                {
                    ret = DataState.DISCONNECTED;
                } //End block
                {
                    {
                        Object var819139837D42C0AD62155AA1D23C5AD5_58332420 = (mDataConnectionTracker.getState(apnType));
                        //Begin case FAILED IDLE 
                        ret = DataState.DISCONNECTED;
                        //End case FAILED IDLE 
                        //Begin case CONNECTED DISCONNECTING 
                        {
                            boolean var398FF6E0DCA52B02F79A9CB272BA56EC_1492989347 = (mCT.state != Phone.State.IDLE
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
        return (DataState)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.715 -0400", hash_original_method = "F7E968145C01057A311E794FEA9BAA95", hash_generated_method = "39FBFC40A01D794780939467E9AED955")
    @DSModeled(DSC.SAFE)
    public void sendUssdResponse(String ussdMessge) {
        dsTaint.addTaint(ussdMessge);
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "sendUssdResponse: not possible in CDMA");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.715 -0400", hash_original_method = "98607162C44D8873925496654D522BF8", hash_generated_method = "03DBDF7AB1224F77A355C5DFCAF81291")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendDtmf(char c) {
        dsTaint.addTaint(c);
        {
            boolean varD5E376D61876D980336EC59E5D202EEE_1930427646 = (!PhoneNumberUtils.is12Key(c));
            {
                {
                    mCM.sendDtmf(c, null);
                } //End block
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.715 -0400", hash_original_method = "3FBA1333099AE68AF02019D712D23AB2", hash_generated_method = "B1AEBDCE6EFD1676B7BE2CB2A25A4CB4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void startDtmf(char c) {
        dsTaint.addTaint(c);
        {
            boolean varD5E376D61876D980336EC59E5D202EEE_1709293364 = (!PhoneNumberUtils.is12Key(c));
            {
                mCM.startDtmf(c, null);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!PhoneNumberUtils.is12Key(c)) {
            //Log.e(LOG_TAG,
                    //"startDtmf called with invalid character '" + c + "'");
        //} else {
            //mCM.startDtmf(c, null);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.715 -0400", hash_original_method = "3DAC039DE959EF34631E2B825CE1F213", hash_generated_method = "99354F65987E33161D4C71C94D255852")
    @DSModeled(DSC.SAFE)
    public void stopDtmf() {
        mCM.stopDtmf(null);
        // ---------- Original Method ----------
        //mCM.stopDtmf(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.715 -0400", hash_original_method = "E3E7B97B548DE87ECFE3195659B23FF9", hash_generated_method = "18899A4DEE3BB16A3FBDC68CE6465925")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendBurstDtmf(String dtmfString, int on, int off, Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(off);
        dsTaint.addTaint(on);
        dsTaint.addTaint(dtmfString);
        boolean check;
        check = true;
        {
            int itr;
            itr = 0;
            boolean varC203A73757365FB141AA417E652E019C_1061736339 = (itr < dtmfString.length());
            {
                {
                    boolean var6A7122EA2D2E6A95C8F93E4E1672AD9E_435035118 = (!PhoneNumberUtils.is12Key(dtmfString.charAt(itr)));
                    {
                        check = false;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.715 -0400", hash_original_method = "FE0764939BCED80E9275F681708ABC99", hash_generated_method = "9190BF1F2A94DB058D7E3BB8238687F5")
    @DSModeled(DSC.SAFE)
    public void getAvailableNetworks(Message response) {
        dsTaint.addTaint(response.dsTaint);
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "getAvailableNetworks: not possible in CDMA");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.715 -0400", hash_original_method = "9C1B6A588127C991585EBB349A2379DB", hash_generated_method = "A3FE1B7D48DC109D8BDF56215928708C")
    @DSModeled(DSC.SAFE)
    public void setOutgoingCallerIdDisplay(int commandInterfaceCLIRMode, Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(commandInterfaceCLIRMode);
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "setOutgoingCallerIdDisplay: not possible in CDMA");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.715 -0400", hash_original_method = "85721F5820CF0128BD1EA66BA785E274", hash_generated_method = "D50464E812E0B06564DA16F6714FF0AD")
    @DSModeled(DSC.SAFE)
    public void enableLocationUpdates() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mSST.enableLocationUpdates();
        // ---------- Original Method ----------
        //mSST.enableLocationUpdates();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.715 -0400", hash_original_method = "E6FECC87DDBB4D4FE984E494757397E3", hash_generated_method = "65D7CA7E3870C2C4A9FCDCC8D7F89A35")
    @DSModeled(DSC.SAFE)
    public void disableLocationUpdates() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mSST.disableLocationUpdates();
        // ---------- Original Method ----------
        //mSST.disableLocationUpdates();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.716 -0400", hash_original_method = "DAED77F9218E0449A772CA04214CC7F0", hash_generated_method = "8E28313666463CDB1C255669E63152E6")
    @DSModeled(DSC.SAFE)
    public void getDataCallList(Message response) {
        dsTaint.addTaint(response.dsTaint);
        mCM.getDataCallList(response);
        // ---------- Original Method ----------
        //mCM.getDataCallList(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.716 -0400", hash_original_method = "33CDF43696035DC3E16A234222A80D64", hash_generated_method = "1965D313CCEE4F4FA0F5CDD3600F8848")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getDataRoamingEnabled() {
        boolean var6ACB2ECE8621241EECE599BD6243F11B_2075425587 = (mDataConnectionTracker.getDataOnRoamingEnabled());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mDataConnectionTracker.getDataOnRoamingEnabled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.716 -0400", hash_original_method = "63103D1CE9C7888BE66C8CE520564C7E", hash_generated_method = "D890C0682761B7021916DD7E606E6917")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setVoiceMailNumber(String alphaTag,
                                   String voiceMailNumber,
                                   Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(alphaTag);
        dsTaint.addTaint(voiceMailNumber);
        Message resp;
        resp = obtainMessage(EVENT_SET_VM_NUMBER_DONE, 0, 0, onComplete);
        mIccRecords.setVoiceMailNumber(alphaTag, mVmNumber, resp);
        // ---------- Original Method ----------
        //Message resp;
        //mVmNumber = voiceMailNumber;
        //resp = obtainMessage(EVENT_SET_VM_NUMBER_DONE, 0, 0, onComplete);
        //mIccRecords.setVoiceMailNumber(alphaTag, mVmNumber, resp);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.716 -0400", hash_original_method = "EC96491CC2681D27125B6B3540F74113", hash_generated_method = "F2042132E71006797E59ABFEBF5E591F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getVoiceMailNumber() {
        String number;
        number = null;
        SharedPreferences sp;
        sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        {
            boolean var8B403152FA0B86F979BAF5F52F130215_453352566 = (getContext().getResources().getBoolean(com.android.internal
                .R.bool.config_telephony_use_own_number_for_voicemail));
            {
                number = sp.getString(VM_NUMBER_CDMA, getLine1Number());
            } //End block
            {
                number = sp.getString(VM_NUMBER_CDMA, "*86");
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.716 -0400", hash_original_method = "5D69EEC40343498AF4F71AD96BF8D875", hash_generated_method = "367FE7BABAC1A82B7453A6529F114793")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getVoiceMessageCount() {
        int voicemailCount;
        voicemailCount = mIccRecords.getVoiceMessageCount();
        {
            SharedPreferences sp;
            sp = PreferenceManager.getDefaultSharedPreferences(getContext());
            voicemailCount = sp.getInt(VM_COUNT_CDMA, 0);
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int voicemailCount =  mIccRecords.getVoiceMessageCount();
        //if (voicemailCount == 0) {
            //SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
            //voicemailCount = sp.getInt(VM_COUNT_CDMA, 0);
        //}
        //return voicemailCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.716 -0400", hash_original_method = "72DF9B0892372ADFAD7DE65056384F5E", hash_generated_method = "0A32CDFCFD1CA5EA2CC80A810B453A5F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getVoiceMailAlphaTag() {
        String ret;
        ret = "";
        {
            boolean var0709D69E6C2648B4A0C93BD0750A7DE0_874649089 = (ret == null || ret.length() == 0);
            {
                String varA530EF9D7F6A4C3687908C13A6C584D5_1130460420 = (mContext.getText(
                com.android.internal.R.string.defaultVoiceMailAlphaTag).toString());
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String ret = "";
        //if (ret == null || ret.length() == 0) {
            //return mContext.getText(
                //com.android.internal.R.string.defaultVoiceMailAlphaTag).toString();
        //}
        //return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.716 -0400", hash_original_method = "E23DBF1DA2409183D56D85932A9D038B", hash_generated_method = "E627C4550BC774E666436843F220D893")
    @DSModeled(DSC.SAFE)
    public void getCallForwardingOption(int commandInterfaceCFReason, Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(commandInterfaceCFReason);
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "getCallForwardingOption: not possible in CDMA");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.716 -0400", hash_original_method = "A636525DAEF6D9A554C143CAF44D5772", hash_generated_method = "CD15ED7D3BDE4016DF6D084A83EF99B7")
    @DSModeled(DSC.SAFE)
    public void setCallForwardingOption(int commandInterfaceCFAction,
            int commandInterfaceCFReason,
            String dialingNumber,
            int timerSeconds,
            Message onComplete) {
        dsTaint.addTaint(timerSeconds);
        dsTaint.addTaint(commandInterfaceCFAction);
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(dialingNumber);
        dsTaint.addTaint(commandInterfaceCFReason);
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "setCallForwardingOption: not possible in CDMA");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.716 -0400", hash_original_method = "C44463D6A0E6885F3CB7F2F8669CD319", hash_generated_method = "26ECE6FAE9724B562057D077CF545514")
    @DSModeled(DSC.SAFE)
    public void getOutgoingCallerIdDisplay(Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "getOutgoingCallerIdDisplay: not possible in CDMA");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.716 -0400", hash_original_method = "D57FAF7F6BF0B2A3D2D79072DE461E12", hash_generated_method = "CC4ED21FA51FF0E7ED1C7D1717DF7FAC")
    @DSModeled(DSC.SAFE)
    public boolean getCallForwardingIndicator() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "getCallForwardingIndicator: not possible in CDMA");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.716 -0400", hash_original_method = "4D4FE78E3983A39BD949CCB232763B54", hash_generated_method = "C006293025D77529C7B3FE621AE01CDC")
    @DSModeled(DSC.SAFE)
    public void explicitCallTransfer() {
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "explicitCallTransfer: not possible in CDMA");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.716 -0400", hash_original_method = "280CC3981F581DF1B137B098EEA6AAEB", hash_generated_method = "A0FFDCD037AA653DC1F736001534FA46")
    @DSModeled(DSC.SAFE)
    public String getLine1AlphaTag() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "getLine1AlphaTag: not possible in CDMA");
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.716 -0400", hash_original_method = "812A77A153EDB691C43A0B58CAFAA77A", hash_generated_method = "D88E16D17ED4309B5F77471CE77F05EC")
    @DSModeled(DSC.SAFE)
     void notifyPhoneStateChanged() {
        mNotifier.notifyPhoneState(this);
        // ---------- Original Method ----------
        //mNotifier.notifyPhoneState(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.716 -0400", hash_original_method = "3EB8461625C29B29FD6CB8E5D60B43F3", hash_generated_method = "DE6645BED63D7A84DCC69657109FEA5D")
    @DSModeled(DSC.SAFE)
     void notifyPreciseCallStateChanged() {
        super.notifyPreciseCallStateChangedP();
        // ---------- Original Method ----------
        //super.notifyPreciseCallStateChangedP();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.716 -0400", hash_original_method = "73E7BFF04E4E9785E6146409272926BA", hash_generated_method = "E3DFCCC90DF88D6FEFDEB33D49CA936F")
    @DSModeled(DSC.SAFE)
     void notifyServiceStateChanged(ServiceState ss) {
        dsTaint.addTaint(ss.dsTaint);
        super.notifyServiceStateChangedP(ss);
        // ---------- Original Method ----------
        //super.notifyServiceStateChangedP(ss);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.717 -0400", hash_original_method = "482FE18FBD1949DAF708F2E65940DE8F", hash_generated_method = "021882CF98B4FB93B61C157BB7AF1FCF")
    @DSModeled(DSC.SAFE)
     void notifyLocationChanged() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mNotifier.notifyCellLocation(this);
        // ---------- Original Method ----------
        //mNotifier.notifyCellLocation(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.717 -0400", hash_original_method = "292444BE96E352C8E8312B338E19EF02", hash_generated_method = "1D252363C24CD454F85D9BE194A8E32A")
    @DSModeled(DSC.SAFE)
     void notifyNewRingingConnection(Connection c) {
        dsTaint.addTaint(c.dsTaint);
        super.notifyNewRingingConnectionP(c);
        // ---------- Original Method ----------
        //super.notifyNewRingingConnectionP(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.717 -0400", hash_original_method = "1858091673D3A4B62C058FCC91892C36", hash_generated_method = "7FC21AD219962FFC4D31C1D7A498D364")
    @DSModeled(DSC.SAFE)
     void notifyDisconnect(Connection cn) {
        dsTaint.addTaint(cn.dsTaint);
        mDisconnectRegistrants.notifyResult(cn);
        // ---------- Original Method ----------
        //mDisconnectRegistrants.notifyResult(cn);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.717 -0400", hash_original_method = "4DFA3B176AED92FABCFB596FBC88C127", hash_generated_method = "B69649D87585A24DDF770C28059017C4")
    @DSModeled(DSC.SAFE)
     void notifyUnknownConnection() {
        mUnknownConnectionRegistrants.notifyResult(this);
        // ---------- Original Method ----------
        //mUnknownConnectionRegistrants.notifyResult(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.717 -0400", hash_original_method = "393DB826FD1453B6BE0DEA71B818C50D", hash_generated_method = "31685E3960DBD30E94EE39C74E38441F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isInEmergencyCall() {
        boolean varD8A2457FC2EBCE0C63162FEE0C7B8E1B_1191941496 = (mCT.isInEmergencyCall());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCT.isInEmergencyCall();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.717 -0400", hash_original_method = "B4B2A6F2428B54DDD4A7791B2905A02A", hash_generated_method = "92ECF5CCB0320AC083CB124C1E2A4DFE")
    @DSModeled(DSC.SAFE)
    public boolean isInEcm() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIsPhoneInEcmState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.717 -0400", hash_original_method = "00543A79BC25C997F29F0DAD4E28E830", hash_generated_method = "F6BF4F3FB79FB9E2EAD6E383E2D8A445")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.717 -0400", hash_original_method = "B67535D9EC35CAA35F8134AB61AC3782", hash_generated_method = "963192E77591F7CA3AF6B6C50FD6240D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void exitEmergencyCallbackMode() {
        {
            boolean varC8E4FB4CC0E8CC6621CB9ECC0FDC7EC6_233311481 = (mWakeLock.isHeld());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.717 -0400", hash_original_method = "379601A1C426F495327BF8B224FF5B5D", hash_generated_method = "C52C99DC7F5922D982598BEFD3A260AF")
    @DSModeled(DSC.SAFE)
    private void handleEnterEmergencyCallbackMode(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.717 -0400", hash_original_method = "DE92BF7F05810FB5E0BD1EEEAFEB4B90", hash_generated_method = "630BEECE10BA1A7E4CF9A1F0A7C57B7C")
    @DSModeled(DSC.SAFE)
    private void handleExitEmergencyCallbackMode(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.717 -0400", hash_original_method = "C8EF6B60BE95B81385F7554432463CF1", hash_generated_method = "4698FE0A02184BCA067B64CA2EFC525B")
    @DSModeled(DSC.SAFE)
     void handleTimerInEmergencyCallbackMode(int action) {
        dsTaint.addTaint(action);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.717 -0400", hash_original_method = "BEFF27391F370909F03A02FD6CE5C8E1", hash_generated_method = "71156F5BB535A803726F03F3FEDF7B71")
    @DSModeled(DSC.SAFE)
    public void registerForEcmTimerReset(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mEcmTimerResetRegistrants.addUnique(h, what, obj);
        // ---------- Original Method ----------
        //mEcmTimerResetRegistrants.addUnique(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.717 -0400", hash_original_method = "2652F35782787E1271AD631A33A0033B", hash_generated_method = "F0B898093646F427D9F7268E802A5427")
    @DSModeled(DSC.SAFE)
    public void unregisterForEcmTimerReset(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mEcmTimerResetRegistrants.remove(h);
        // ---------- Original Method ----------
        //mEcmTimerResetRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.718 -0400", hash_original_method = "69FA59CB460FF0A097B9F7F6B4D5A187", hash_generated_method = "724317F6FDDA7ACCE3A04044A23A86F4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void handleMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
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
                boolean varBCC2AAC262927329DC1DDFC23398E7CA_636946954 = (IccException.class.isInstance(ar.exception));
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.718 -0400", hash_original_method = "4BF16EE42BDE3709043B0CD4BA1346D5", hash_generated_method = "AC2BAD2ADC97C1D4E88D3F3201764F16")
    @DSModeled(DSC.SAFE)
    public PhoneSubInfo getPhoneSubInfo() {
        return (PhoneSubInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mSubInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.718 -0400", hash_original_method = "A5B3830D3022369CFD45112AC4A19D05", hash_generated_method = "DB2E39118C1002A0182A77400146C30D")
    @DSModeled(DSC.SAFE)
    public IccSmsInterfaceManager getIccSmsInterfaceManager() {
        return (IccSmsInterfaceManager)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mRuimSmsInterfaceManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.718 -0400", hash_original_method = "F4C16F1EDC7887AFA610A21C85E2FBBC", hash_generated_method = "9E27BBB764EA2302FD19BC14297D1CA7")
    @DSModeled(DSC.SAFE)
    public IccPhoneBookInterfaceManager getIccPhoneBookInterfaceManager() {
        return (IccPhoneBookInterfaceManager)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mRuimPhoneBookInterfaceManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.718 -0400", hash_original_method = "631C425442894A51F9E1215F7444839C", hash_generated_method = "B1936B9FEF369C6353F9DE99416519E4")
    @DSModeled(DSC.SAFE)
    public void registerForNvLoaded(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        Registrant r;
        r = new Registrant (h, what, obj);
        mNvLoadedRegistrants.add(r);
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //mNvLoadedRegistrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.718 -0400", hash_original_method = "FC47AF6104E2994A09ED5540AEE820A5", hash_generated_method = "3D59ED8F865AFC6EA90C8BA043135978")
    @DSModeled(DSC.SAFE)
    public void unregisterForNvLoaded(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mNvLoadedRegistrants.remove(h);
        // ---------- Original Method ----------
        //mNvLoadedRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.718 -0400", hash_original_method = "76D872D60E8DF5A817173A7970E48DAF", hash_generated_method = "C6BBBCB7EB89AD0FA0D721E4D4D9EA9C")
    @DSModeled(DSC.SAFE)
    public void registerForEriFileLoaded(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        Registrant r;
        r = new Registrant (h, what, obj);
        mEriFileLoadedRegistrants.add(r);
        // ---------- Original Method ----------
        //Registrant r = new Registrant (h, what, obj);
        //mEriFileLoadedRegistrants.add(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.718 -0400", hash_original_method = "609ACFE0DF3AD88014ED023EE4CC2BBF", hash_generated_method = "0823B4D45A9F959B7122A6484D3183F3")
    @DSModeled(DSC.SAFE)
    public void unregisterForEriFileLoaded(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mEriFileLoadedRegistrants.remove(h);
        // ---------- Original Method ----------
        //mEriFileLoadedRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.718 -0400", hash_original_method = "C4157CB043EC8B3384F8270EB7DCD5BB", hash_generated_method = "E476AF6907BF3995FD9A8B5CD0688E7D")
    @DSModeled(DSC.SAFE)
    public final void setSystemProperty(String property, String value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(property);
        super.setSystemProperty(property, value);
        // ---------- Original Method ----------
        //super.setSystemProperty(property, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.718 -0400", hash_original_method = "515987807F65054AFA6AA9A268DDB599", hash_generated_method = "4C459E888C01535E2CB51C13749B6FD0")
    @DSModeled(DSC.SAFE)
    public IccFileHandler getIccFileHandler() {
        return (IccFileHandler)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.mIccFileHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.718 -0400", hash_original_method = "793C414C17B853DD540D3B3DFD8290DE", hash_generated_method = "0B8451D24CCA117E35CB1CCAEE5AA319")
    @DSModeled(DSC.SAFE)
    public void activateCellBroadcastSms(int activate, Message response) {
        dsTaint.addTaint(activate);
        dsTaint.addTaint(response.dsTaint);
        response.sendToTarget();
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[CDMAPhone] activateCellBroadcastSms() is obsolete; use SmsManager");
        //response.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.719 -0400", hash_original_method = "81E322CF525B990EC666DA306E1980A6", hash_generated_method = "C1131220A2B2C469336EABFDE24C29D5")
    @DSModeled(DSC.SAFE)
    public void getCellBroadcastSmsConfig(Message response) {
        dsTaint.addTaint(response.dsTaint);
        response.sendToTarget();
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[CDMAPhone] getCellBroadcastSmsConfig() is obsolete; use SmsManager");
        //response.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.719 -0400", hash_original_method = "718A796BA1FEFA7B8760E97D0CFF0F71", hash_generated_method = "777BB632C7750244AFB28A786EE6788D")
    @DSModeled(DSC.SAFE)
    public void setCellBroadcastSmsConfig(int[] configValuesArray, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(configValuesArray);
        response.sendToTarget();
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[CDMAPhone] setCellBroadcastSmsConfig() is obsolete; use SmsManager");
        //response.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.719 -0400", hash_original_method = "C10911F486938B4F93DC849B5E1085A3", hash_generated_method = "3989FBEABC5892A4B78DAC382D168D53")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean needsOtaServiceProvisioning() {
        boolean var3814F4E6C3697558290520EC0B4891A9_1481431032 = (mSST.getOtasp() != ServiceStateTracker.OTASP_NOT_NEEDED);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mSST.getOtasp() != ServiceStateTracker.OTASP_NOT_NEEDED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.719 -0400", hash_original_method = "0987EB9B752C2AE0A39CB183394EC719", hash_generated_method = "BD516A911B886CE33B25F5EEA604FBDE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.719 -0400", hash_original_method = "A91F01B0D3E07B9BAFA73C694BEFBC5B", hash_generated_method = "2984DFE46DD42FB12169ABF4CB739AA5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.719 -0400", hash_original_method = "68BC2FB84293153DDA759DD543D07116", hash_generated_method = "275E119E8EEC25305525349916BB5D97")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.719 -0400", hash_original_method = "2F4529BDEA4C79E5E2F449E50272F3AC", hash_generated_method = "6565301EA0DCD75A9B9AFF4B1F73F52F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isCarrierOtaSpNum(String dialStr) {
        dsTaint.addTaint(dialStr);
        boolean isOtaSpNum;
        isOtaSpNum = false;
        int sysSelCodeInt;
        sysSelCodeInt = extractSelCodeFromOtaSpNum(dialStr);
        {
            boolean varC25E28587E797B4B1D25D8A223D7987E_772693204 = (!TextUtils.isEmpty(mCarrierOtaSpNumSchema));
            {
                Matcher m;
                m = pOtaSpNumSchema.matcher(mCarrierOtaSpNumSchema);
                {
                    Log.d(LOG_TAG, "isCarrierOtaSpNum,schema" + mCarrierOtaSpNumSchema);
                } //End block
                {
                    boolean var39BD3106C7A2329BC5A3364836FB2CF9_2044763392 = (m.find());
                    {
                        String sch[];
                        sch = pOtaSpNumSchema.split(mCarrierOtaSpNumSchema);
                        {
                            boolean varB2BFE86D7B99BED62C3AF16905511122_164558789 = (!TextUtils.isEmpty(sch[0]) && sch[0].equals("SELC"));
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
                                boolean var981C353E34C8504891CF0AE981C84F35_1675940423 = (!TextUtils.isEmpty(sch[0]) && sch[0].equals("FC"));
                                {
                                    int fcLen;
                                    fcLen = Integer.parseInt((String)sch[1]);
                                    String fc;
                                    fc = (String)sch[2];
                                    {
                                        boolean varCF1EF44489814B5931C694BEAA6AF449_962433090 = (dialStr.regionMatches(0,fc,0,fcLen));
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
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.719 -0400", hash_original_method = "AE6C103DE6DE549189EC8F2DC89B4935", hash_generated_method = "7741AF57B1D78EBD8F68AB115E414608")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isOtaSpNumber(String dialStr) {
        dsTaint.addTaint(dialStr);
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.720 -0400", hash_original_method = "CBAF5F4AF9A1C44FBA957D2F8ABDCEC2", hash_generated_method = "2549A0D7451CBD3944DFC810EC44F1BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getCdmaEriIconIndex() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        int var7D21F14EF91E1D5E5A5201CD691F6EC1_1000060339 = (getServiceState().getCdmaEriIconIndex());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getServiceState().getCdmaEriIconIndex();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.720 -0400", hash_original_method = "505B53637594CBFFA64F8CC821649187", hash_generated_method = "28515D513153267D0E67C36313E58B2E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getCdmaEriIconMode() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        int var14A1514753E21C20C1CFD187FB3391BF_1787499391 = (getServiceState().getCdmaEriIconMode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getServiceState().getCdmaEriIconMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.720 -0400", hash_original_method = "FF25B4C2C2FD6DDBAFFF02AC278A249A", hash_generated_method = "981D50415291E5BD1B9570B63C7FD0BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String getCdmaEriText() {
        int roamInd;
        roamInd = getServiceState().getCdmaRoamingIndicator();
        int defRoamInd;
        defRoamInd = getServiceState().getCdmaDefaultRoamingIndicator();
        String var9E1574EDCAF4CECB844B84DF6CC8DDF2_1565554700 = (mEriManager.getCdmaEriText(roamInd, defRoamInd));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //int roamInd = getServiceState().getCdmaRoamingIndicator();
        //int defRoamInd = getServiceState().getCdmaDefaultRoamingIndicator();
        //return mEriManager.getCdmaEriText(roamInd, defRoamInd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.720 -0400", hash_original_method = "1FA484546C7B73CA49B2C4AE64A8C83E", hash_generated_method = "FB1312943431C04484220B880C346501")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void storeVoiceMailNumber(String number) {
        dsTaint.addTaint(number);
        SharedPreferences sp;
        sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor editor;
        editor = sp.edit();
        editor.putString(VM_NUMBER_CDMA, number);
        editor.apply();
        // ---------- Original Method ----------
        //SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        //SharedPreferences.Editor editor = sp.edit();
        //editor.putString(VM_NUMBER_CDMA, number);
        //editor.apply();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.720 -0400", hash_original_method = "04903824830A3F9FD2759E9C177CC0CB", hash_generated_method = "48F576C8D94511799CC45386856447AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setIsoCountryProperty(String operatorNumeric) {
        dsTaint.addTaint(operatorNumeric);
        {
            boolean var1C5534FDAA00A1B387A79218D6BAEF6C_1404085944 = (TextUtils.isEmpty(operatorNumeric));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.720 -0400", hash_original_method = "B076A318D7F3CB7E259ECDC99FDB3D0D", hash_generated_method = "4E71C2B352C065F8D798F9363FD16126")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean updateCurrentCarrierInProvider(String operatorNumeric) {
        dsTaint.addTaint(operatorNumeric);
        {
            boolean var94B3144E977DE08BBD4DC30162F60334_934199184 = (!TextUtils.isEmpty(operatorNumeric));
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.720 -0400", hash_original_method = "A95BEE5F1920F9C579D7A59FC4DBB414", hash_generated_method = "5A95BBD77AE5A874E147E0090D3E2327")
    @DSModeled(DSC.SAFE)
     boolean updateCurrentCarrierInProvider() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.720 -0400", hash_original_method = "5CB32743CEBF9A8556BB2E144A975CB3", hash_generated_method = "11708629AD24FE433604228D08A61ADA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void prepareEri() {
        mEriManager.loadEriFile();
        {
            boolean var07BA6C1E3CEBF9422B7FD30B01BA2995_1599254904 = (mEriManager.isEriFileLoaded());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.720 -0400", hash_original_method = "71144CF5C8B23350BF31931D81A1C3AC", hash_generated_method = "D35829F99349545B609637FFD23102FF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isEriFileLoaded() {
        boolean varAA8EBCEDF474BF00A450A0F8740F0DD7_1608348150 = (mEriManager.isEriFileLoaded());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mEriManager.isEriFileLoaded();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.720 -0400", hash_original_method = "CBB2DC533610D724567F0136955B7014", hash_generated_method = "17F5656E31FC608DB16031581176FCDE")
    @DSModeled(DSC.SAFE)
    protected void log(String s) {
        dsTaint.addTaint(s);
        Log.d(LOG_TAG, "[CDMAPhone] " + s);
        // ---------- Original Method ----------
        //if (DBG)
            //Log.d(LOG_TAG, "[CDMAPhone] " + s);
    }

    
}


