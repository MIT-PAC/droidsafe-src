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
    private String mVmNumber = null;
    CdmaCallTracker mCT;
    CdmaServiceStateTracker mSST;
    ArrayList <CdmaMmiCode> mPendingMmis = new ArrayList<CdmaMmiCode>();
    RuimPhoneBookInterfaceManager mRuimPhoneBookInterfaceManager;
    RuimSmsInterfaceManager mRuimSmsInterfaceManager;
    PhoneSubInfo mSubInfo;
    EriManager mEriManager;
    WakeLock mWakeLock;
    CatService mCcatService;
    private RegistrantList mNvLoadedRegistrants = new RegistrantList();
    private RegistrantList mEriFileLoadedRegistrants = new RegistrantList();
    private RegistrantList mEcmTimerResetRegistrants = new RegistrantList();
    private boolean mIsPhoneInEcmState;
    private Registrant mEcmExitRespRegistrant;
    protected String mImei;
    protected String mImeiSv;
    private String mEsn;
    private String mMeid;
    private String mCarrierOtaSpNumSchema;
    private Runnable mExitEcmRunnable = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.122 -0400", hash_original_method = "F3DC5BFDA25D02344EBFE8F4AEC767D8", hash_generated_method = "13E58FFF08C64D739C7C2CEA1DFD40E8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void run() {
            exitEmergencyCallbackMode();
            // ---------- Original Method ----------
            //exitEmergencyCallbackMode();
        }

        
}; //Transformed anonymous class
    Registrant mPostDialHandler;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.122 -0400", hash_original_method = "DAE6B8BFE7F70789DB7C3B99D4D5F7DA", hash_generated_method = "6932448B6A6573823F4C7C87F3F6CC85")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CDMAPhone(Context context, CommandsInterface ci, PhoneNotifier notifier) {
        super(notifier, context, ci, false);
        dsTaint.addTaint(notifier.dsTaint);
        dsTaint.addTaint(ci.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        initSstIcc();
        init(context, notifier);
        // ---------- Original Method ----------
        //initSstIcc();
        //init(context, notifier);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.123 -0400", hash_original_method = "467D4326BF1EF0C31B8D509189D4E2E0", hash_generated_method = "06566EC7D3693CC5895D0653DBCA70AE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CDMAPhone(Context context, CommandsInterface ci, PhoneNotifier notifier,
            boolean unitTestMode) {
        super(notifier, context, ci, unitTestMode);
        dsTaint.addTaint(unitTestMode);
        dsTaint.addTaint(notifier.dsTaint);
        dsTaint.addTaint(ci.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        initSstIcc();
        init(context, notifier);
        // ---------- Original Method ----------
        //initSstIcc();
        //init(context, notifier);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.123 -0400", hash_original_method = "1B7DFBB42AE4FBFECC004BFFF3CFFDDB", hash_generated_method = "EC0DA6F48DC1646B607F03DA38DBAF6C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.123 -0400", hash_original_method = "8461B888D034831850AE73E07FC3F149", hash_generated_method = "C91C5D77522D043AEABD4D6D721CC42E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.124 -0400", hash_original_method = "9DE3C78959AC59CCA27F149210FA77A8", hash_generated_method = "F3FEEAA479B2FA983331D6EBDEFF4F44")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.124 -0400", hash_original_method = "EE2FF8AAD85928FB8E8B4233881FEB3A", hash_generated_method = "123CADA6CF62D4FBD8FD71E77576DE69")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.124 -0400", hash_original_method = "717E537581BE31A7DC523FEE6B0DDE4B", hash_generated_method = "CBBCC22818DEF4D7B2F0917F1F38D8A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void finalize() {
        Log.d(LOG_TAG, "CDMAPhone finalized");
        {
            boolean varC8E4FB4CC0E8CC6621CB9ECC0FDC7EC6_499331046 = (mWakeLock.isHeld());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.125 -0400", hash_original_method = "DA0F221C2247572C4D631280E4033E9A", hash_generated_method = "FC3662E440FD3765C0BCB5CC60CA3FE5")
    @DSModeled(DSC.SAFE)
    public ServiceState getServiceState() {
        return (ServiceState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mSST.ss;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.125 -0400", hash_original_method = "79AFD9B845E4547B981131DAC9E3A14D", hash_generated_method = "5D9B987C72AF0F100B5DAE52C9AE6FF7")
    @DSModeled(DSC.SAFE)
    public CallTracker getCallTracker() {
        return (CallTracker)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.125 -0400", hash_original_method = "8AEFB373111A9C8AD30F3E8C75C461D2", hash_generated_method = "F84554A9D23EFBD108142BA6D2D4DDB7")
    @DSModeled(DSC.SAFE)
    public Phone.State getState() {
        return (Phone.State)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCT.state;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.125 -0400", hash_original_method = "BD481539215D5A66E62B4E6909625141", hash_generated_method = "100D2458280FF91D75D69B113FFF8324")
    @DSModeled(DSC.SAFE)
    public ServiceStateTracker getServiceStateTracker() {
        return (ServiceStateTracker)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mSST;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.125 -0400", hash_original_method = "B0BDAF041F7F636A26D0F46F60D4BC7B", hash_generated_method = "E11E6C442F974D2C11B0D69FFD026BE7")
    @DSModeled(DSC.SAFE)
    public String getPhoneName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "CDMA";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.125 -0400", hash_original_method = "94F6AF6179535CBD756D5B387D52C3CA", hash_generated_method = "16564EC138230898C6445C461E0E7DB5")
    @DSModeled(DSC.SAFE)
    public int getPhoneType() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return Phone.PHONE_TYPE_CDMA;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.126 -0400", hash_original_method = "F828A2F1845194FFD82C471D7E89F726", hash_generated_method = "6C47C96B86FF344B344FA5D18E28D936")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean canTransfer() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "canTransfer: not possible in CDMA");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.126 -0400", hash_original_method = "31E0316605311F71BD2BE82139C4C7B1", hash_generated_method = "E7315BC26244A72F71819D1D699BDF69")
    @DSModeled(DSC.SAFE)
    public CdmaCall getRingingCall() {
        return (CdmaCall)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCT.ringingCall;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.126 -0400", hash_original_method = "E892EC268DCFDF5C9C27A7DDC7E00573", hash_generated_method = "6BAE63C4A28DBAC9885CECD08BF45BE2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMute(boolean muted) {
        dsTaint.addTaint(muted);
        mCT.setMute(muted);
        // ---------- Original Method ----------
        //mCT.setMute(muted);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.126 -0400", hash_original_method = "FA6E824680C8944626A1A959DCEA6499", hash_generated_method = "DAC298BD5516786AE4ED2E075F1683D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getMute() {
        boolean var20663A120A6F5E860F4EB58F2E5B9228_1943054931 = (mCT.getMute());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCT.getMute();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.127 -0400", hash_original_method = "593DDE28AC9DCA9096C93A9D0D1099FC", hash_generated_method = "EFBC49A5AD73E9A3CBDEEDFF40E8B0EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void conference() throws CallStateException {
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "conference: not possible in CDMA");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.127 -0400", hash_original_method = "F90799FAE99EB431CF7F205DFD6DDD5D", hash_generated_method = "4A346A1A3CBDC31879DC437AC0EAB64B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void enableEnhancedVoicePrivacy(boolean enable, Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(enable);
        this.mCM.setPreferredVoicePrivacy(enable, onComplete);
        // ---------- Original Method ----------
        //this.mCM.setPreferredVoicePrivacy(enable, onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.127 -0400", hash_original_method = "5CE753EAA3145BBCA6A00800B2884B4E", hash_generated_method = "A582236EB5A87836F9BD66A0F6C7F5DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getEnhancedVoicePrivacy(Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        this.mCM.getPreferredVoicePrivacy(onComplete);
        // ---------- Original Method ----------
        //this.mCM.getPreferredVoicePrivacy(onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.127 -0400", hash_original_method = "B9932A8A8BD16A4F0D461DDC6FDE6B49", hash_generated_method = "BEFA10EB4DBC56DB633604D1159E6D30")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clearDisconnected() {
        mCT.clearDisconnected();
        // ---------- Original Method ----------
        //mCT.clearDisconnected();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.128 -0400", hash_original_method = "34BFC6F1F77B77A760EA5A249CE3FEFD", hash_generated_method = "EB7D01158E50425261011FF73CFF786A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DataActivityState getDataActivityState() {
        DataActivityState ret;
        ret = DataActivityState.NONE;
        {
            boolean varA31FE6075ED3D4825296DCCB8274BE5E_991559056 = (mSST.getCurrentDataConnectionState() == ServiceState.STATE_IN_SERVICE);
            {
                {
                    Object var27C7E0FDBE09DE35AC2FD606F73591E2_1354744515 = (mDataConnectionTracker.getActivity());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.128 -0400", hash_original_method = "FCBAE539BB72BE21647FF37299DC2B96", hash_generated_method = "0C6B7A0FF6350CF17887F3D234BB96C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void notifySignalStrength() {
        mNotifier.notifySignalStrength(this);
        // ---------- Original Method ----------
        //mNotifier.notifySignalStrength(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.128 -0400", hash_original_method = "3B6D00BA5404778271A196326B2492C1", hash_generated_method = "F639CAB61EA75C3CC12EF5FA5E84C220")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Connection dial(String dialString) throws CallStateException {
        dsTaint.addTaint(dialString);
        String newDialString;
        newDialString = PhoneNumberUtils.stripSeparators(dialString);
        Connection var6E19EB04677F631A73FAB796C0759274_107162100 = (mCT.dial(newDialString));
        return (Connection)dsTaint.getTaint();
        // ---------- Original Method ----------
        //String newDialString = PhoneNumberUtils.stripSeparators(dialString);
        //return mCT.dial(newDialString);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.129 -0400", hash_original_method = "C4CAEF0C07F27C620A5D9B835D3227D9", hash_generated_method = "B6A38D109BB149B977925B1F91500E76")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Connection dial(String dialString, UUSInfo uusInfo) throws CallStateException {
        dsTaint.addTaint(uusInfo.dsTaint);
        dsTaint.addTaint(dialString);
        if (DroidSafeAndroidRuntime.control) throw new CallStateException("Sending UUS information NOT supported in CDMA!");
        return (Connection)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new CallStateException("Sending UUS information NOT supported in CDMA!");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.129 -0400", hash_original_method = "46D9BC6E3280014832CD8FC523C20E6E", hash_generated_method = "1325ADA4CCC35C506F4F2D0414FD5D5A")
    @DSModeled(DSC.SAFE)
    public SignalStrength getSignalStrength() {
        return (SignalStrength)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mSST.mSignalStrength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.129 -0400", hash_original_method = "391334830335544CEFDB5805671813C7", hash_generated_method = "7CED4E333071D86DE141010FC2C0A0C0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getMessageWaitingIndicator() {
        boolean var197AD52F07C983B246C350347281E552_1112039412 = ((getVoiceMessageCount() > 0));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (getVoiceMessageCount() > 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.129 -0400", hash_original_method = "A1DC624417B44DF11F4CA5E5B97277AF", hash_generated_method = "E9941CD186E7AF61C0CAA0126EEF9ECB")
    @DSModeled(DSC.SAFE)
    public List<? extends MmiCode> getPendingMmiCodes() {
        return (List<? extends MmiCode>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mPendingMmis;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.130 -0400", hash_original_method = "7C5A8D3C952528E3E4A994337305A33B", hash_generated_method = "38C15FE18D0C93DE44F95B9C00E06041")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForSuppServiceNotification(
            Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "method registerForSuppServiceNotification is NOT supported in CDMA!");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.130 -0400", hash_original_method = "9F7E8D6F89A6C75F0A7653B179AA02CE", hash_generated_method = "466AD5113B47CB4E2CB6591FD7816B6E")
    @DSModeled(DSC.SAFE)
    public CdmaCall getBackgroundCall() {
        return (CdmaCall)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCT.backgroundCall;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.130 -0400", hash_original_method = "99F7E880D5431452FB99636E33872BD4", hash_generated_method = "9CE39E1867CC9C174EFBC98B8CB5903F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean handleInCallMmiCommands(String dialString) {
        dsTaint.addTaint(dialString);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "method handleInCallMmiCommands is NOT supported in CDMA!");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.131 -0400", hash_original_method = "F6112A9AE3405415322B12D2CA172B80", hash_generated_method = "8FBD1B4EB4014CA76C5B34670469FCF7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean isInCall() {
        CdmaCall.State foregroundCallState;
        foregroundCallState = getForegroundCall().getState();
        CdmaCall.State backgroundCallState;
        backgroundCallState = getBackgroundCall().getState();
        CdmaCall.State ringingCallState;
        ringingCallState = getRingingCall().getState();
        boolean var4B59C8CBE40B3534DD50EEA545B62F2B_176790577 = ((foregroundCallState.isAlive() || backgroundCallState.isAlive() || ringingCallState
                .isAlive()));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //CdmaCall.State foregroundCallState = getForegroundCall().getState();
        //CdmaCall.State backgroundCallState = getBackgroundCall().getState();
        //CdmaCall.State ringingCallState = getRingingCall().getState();
        //return (foregroundCallState.isAlive() || backgroundCallState.isAlive() || ringingCallState
                //.isAlive());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.131 -0400", hash_original_method = "573D1DDDB474C2914324D2DBB21AD4BF", hash_generated_method = "17A4A99F34FED5C7A6C53E57FA580F1E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setNetworkSelectionModeAutomatic(Message response) {
        dsTaint.addTaint(response.dsTaint);
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "method setNetworkSelectionModeAutomatic is NOT supported in CDMA!");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.131 -0400", hash_original_method = "7239EAF7B36D814AB7CF7CD5314FF0C2", hash_generated_method = "18545BA77617FF9DD1AE43B0080A9461")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForSuppServiceNotification(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "method unregisterForSuppServiceNotification is NOT supported in CDMA!");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.131 -0400", hash_original_method = "C62CCD6CF2D9D7F7FA17BB7B58067AAC", hash_generated_method = "229941362132B3EA463C13061274E96C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void acceptCall() throws CallStateException {
        mCT.acceptCall();
        // ---------- Original Method ----------
        //mCT.acceptCall();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.131 -0400", hash_original_method = "A64616985F0D82C6750D71CF8DADC6F4", hash_generated_method = "35B0F59F3248405A594AAB683856BD2F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void rejectCall() throws CallStateException {
        mCT.rejectCall();
        // ---------- Original Method ----------
        //mCT.rejectCall();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.132 -0400", hash_original_method = "4BD56579DA53A7A8E0646A63E1978FC8", hash_generated_method = "4EFDBB8DAC4DC308937F3C30BD26241D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void switchHoldingAndActive() throws CallStateException {
        mCT.switchWaitingOrHoldingAndActive();
        // ---------- Original Method ----------
        //mCT.switchWaitingOrHoldingAndActive();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.132 -0400", hash_original_method = "B121BB30C6EA08968FF3C722126FC795", hash_generated_method = "6923998A7EEA10371C6DF111282B416E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getLine1Number() {
        String var22E79D7850EE159DBDC01B7FDFB474E0_288441093 = (mSST.getMdnNumber());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mSST.getMdnNumber();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.132 -0400", hash_original_method = "3BC6D82D8BFD82220414E9A1151516B0", hash_generated_method = "9FBA21DD6D7F5B164E43F65A51851CDB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getCdmaPrlVersion() {
        String var7FA4B923BA239B2BAD6CE387E9196018_1415739382 = (mSST.getPrlVersion());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mSST.getPrlVersion();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.132 -0400", hash_original_method = "5F3989DCB2E6CEB13D99C9EB5DB3E7E9", hash_generated_method = "8718FF4DA0A3ED6BDA3754077DFAFD67")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getCdmaMin() {
        String varF449B47F9FD9B580D1FDC5BF81456080_22813029 = (mSST.getCdmaMin());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mSST.getCdmaMin();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.133 -0400", hash_original_method = "8703C344BAEB4A9DC4BE8D85F2A2B471", hash_generated_method = "0D26A3D857D0038AEEFC31F658DD60A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isMinInfoReady() {
        boolean var9484B5471A0F2E2C668270A249557278_886277398 = (mSST.isMinInfoReady());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mSST.isMinInfoReady();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.133 -0400", hash_original_method = "4561349219664D3BF60D1FEC45B8BB02", hash_generated_method = "C87D6A2CEBA4425F373ED7156748D5DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getCallWaiting(Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        mCM.queryCallWaiting(CommandsInterface.SERVICE_CLASS_VOICE, onComplete);
        // ---------- Original Method ----------
        //mCM.queryCallWaiting(CommandsInterface.SERVICE_CLASS_VOICE, onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.133 -0400", hash_original_method = "6583EBFAAE11F5B271B0C202AB11C3E9", hash_generated_method = "3ACA7B12EE0462C4C6C30C6362243F5B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setRadioPower(boolean power) {
        dsTaint.addTaint(power);
        mSST.setRadioPower(power);
        // ---------- Original Method ----------
        //mSST.setRadioPower(power);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.133 -0400", hash_original_method = "A71BC42B8E5B39F885F4E0F3CDCE1523", hash_generated_method = "0088E6B198BA6422391F1C0347254B84")
    @DSModeled(DSC.SAFE)
    public String getEsn() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mEsn;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.134 -0400", hash_original_method = "7E7AAA89C01F3229F1902E361A6CD86F", hash_generated_method = "0AA6E4263C1050FC9857E119D9F80571")
    @DSModeled(DSC.SAFE)
    public String getMeid() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mMeid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.134 -0400", hash_original_method = "7766C412A244B7E9ACAC69FB73BBB546", hash_generated_method = "DBF7EF1B901E62E103829DC62B002075")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getDeviceId() {
        String id;
        id = getMeid();
        {
            boolean varAF1C852358631BCBFACC3CD12BED0C0E_1247118289 = ((id == null) || id.matches("^0*$"));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.134 -0400", hash_original_method = "BA19C271165532D38DF9C2A2EC7580FC", hash_generated_method = "2A3D9DB4E4E78C189F5B9E386AAD3DC3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getDeviceSvn() {
        Log.d(LOG_TAG, "getDeviceSvn(): return 0");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "getDeviceSvn(): return 0");
        //return "0";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.134 -0400", hash_original_method = "32994E1C8E091DA1F8318F6B29B65F50", hash_generated_method = "1EAA09C263E6FEE74E474E88F41E8975")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getSubscriberId() {
        String varF1487D2964529CABB8DF8FF6340A599E_425424776 = (mSST.getImsi());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mSST.getImsi();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.135 -0400", hash_original_method = "FAD82CEAF9DD41800ADBC5F4734356D8", hash_generated_method = "BB6316E998EE59FEE9B9E5128C703E26")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getImei() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "IMEI is not available in CDMA");
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.135 -0400", hash_original_method = "3D81DB016065E96128526DD50CCAAE05", hash_generated_method = "9A5F3B1D383E553E33F8886EF1C7BEF5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean canConference() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "canConference: not possible in CDMA");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.135 -0400", hash_original_method = "E38329BE2FF507326358BBAF596945E6", hash_generated_method = "4BF92BFA96FE0F27C21BD96F425A61FB")
    @DSModeled(DSC.SAFE)
    public CellLocation getCellLocation() {
        return (CellLocation)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mSST.cellLoc;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.135 -0400", hash_original_method = "5D417D4C057D78BF0DEF3D949E557B3C", hash_generated_method = "99BCC3C4FEF1C22A187820FCA94D3C6F")
    @DSModeled(DSC.SAFE)
    public CdmaCall getForegroundCall() {
        return (CdmaCall)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCT.foregroundCall;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.136 -0400", hash_original_method = "6287E103949DE4B29FC1760D95391284", hash_generated_method = "6720AC267E2095E6644148FD6C0C7887")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void selectNetworkManually(OperatorInfo network,
            Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(network.dsTaint);
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "selectNetworkManually: not possible in CDMA");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.136 -0400", hash_original_method = "A54F4B18F21B3A39961648F4BDA2F061", hash_generated_method = "9EDB52CDA14C8129BE65EFAD662EDF17")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOnPostDialCharacter(Handler h, int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mPostDialHandler = new Registrant(h, what, obj);
        // ---------- Original Method ----------
        //mPostDialHandler = new Registrant(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.136 -0400", hash_original_method = "3D832E28FC020C3451E1ECD577F7705D", hash_generated_method = "0362BB490D9D9CF90A148DD5A63626B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean handlePinMmi(String dialString) {
        dsTaint.addTaint(dialString);
        CdmaMmiCode mmi;
        mmi = CdmaMmiCode.newFromDialString(dialString, this);
        {
            boolean var1028666450F47101F5E9163275C14E96_2091757172 = (mmi.isPukCommand());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.137 -0400", hash_original_method = "574EFAE567BAC054324E4789AB0ACA21", hash_generated_method = "28900FA4F35B1E20DF89911B50DFA870")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void onMMIDone(CdmaMmiCode mmi) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(mmi.dsTaint);
        {
            boolean var2994F1DD658E93A134FDDE87066FC8E4_1268474513 = (mPendingMmis.remove(mmi));
            {
                mMmiCompleteRegistrants.notifyRegistrants(new AsyncResult(null, mmi, null));
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (mPendingMmis.remove(mmi)) {
            //mMmiCompleteRegistrants.notifyRegistrants(new AsyncResult(null, mmi, null));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.137 -0400", hash_original_method = "8885A01E1E8D54116E470B45B5958287", hash_generated_method = "9AAC1C9A8178C64BD9CABE7E958D4749")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setLine1Number(String alphaTag, String number, Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(number);
        dsTaint.addTaint(alphaTag);
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "setLine1Number: not possible in CDMA");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.137 -0400", hash_original_method = "9F48D83DEE90081423E43167EA0B9F32", hash_generated_method = "12340DCBAFCB867E6528565CF1FD3116")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCallWaiting(boolean enable, Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(enable);
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "method setCallWaiting is NOT supported in CDMA!");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.137 -0400", hash_original_method = "96CADC2872DB4F7FDEDEDD322815973F", hash_generated_method = "822C445C5B4D9120BF9FC0E8634D50FF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void updateServiceLocation() {
        mSST.enableSingleLocationUpdate();
        // ---------- Original Method ----------
        //mSST.enableSingleLocationUpdate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.138 -0400", hash_original_method = "910AE5D7D70CC37EC2511A21C3761E3A", hash_generated_method = "2E73E2747928E437CDA1C67E033E6420")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDataRoamingEnabled(boolean enable) {
        dsTaint.addTaint(enable);
        mDataConnectionTracker.setDataOnRoamingEnabled(enable);
        // ---------- Original Method ----------
        //mDataConnectionTracker.setDataOnRoamingEnabled(enable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.138 -0400", hash_original_method = "610E8C97A082907006BA954BE534B9EC", hash_generated_method = "FC532D5EB2E2D098864E614C59DC1302")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForCdmaOtaStatusChange(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mCM.registerForCdmaOtaProvision(h, what, obj);
        // ---------- Original Method ----------
        //mCM.registerForCdmaOtaProvision(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.138 -0400", hash_original_method = "BBA791A1BBD0F6B3058E9616045D8082", hash_generated_method = "3247FFF523EA18F0EA14A20E91394762")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForCdmaOtaStatusChange(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mCM.unregisterForCdmaOtaProvision(h);
        // ---------- Original Method ----------
        //mCM.unregisterForCdmaOtaProvision(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.138 -0400", hash_original_method = "832A3DCDB2173345E213F4FEE097F4C8", hash_generated_method = "350A16C1E6DE0F59AB43B394BEC311F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForSubscriptionInfoReady(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mSST.registerForSubscriptionInfoReady(h, what, obj);
        // ---------- Original Method ----------
        //mSST.registerForSubscriptionInfoReady(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.139 -0400", hash_original_method = "8678E3A1722432B3AEE20746D6239509", hash_generated_method = "91F80B8C9BCD698DAAC425DF4EB5FE5B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForSubscriptionInfoReady(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mSST.unregisterForSubscriptionInfoReady(h);
        // ---------- Original Method ----------
        //mSST.unregisterForSubscriptionInfoReady(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.139 -0400", hash_original_method = "9CC75D31629A3B23A63ED4AF8AC1CC3C", hash_generated_method = "930C19CAEE57573592801DA219F35630")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOnEcbModeExitResponse(Handler h, int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mEcmExitRespRegistrant = new Registrant (h, what, obj);
        // ---------- Original Method ----------
        //mEcmExitRespRegistrant = new Registrant (h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.139 -0400", hash_original_method = "40447D9C1BA4AF14D98FB8C3ACDE2526", hash_generated_method = "B02EEC55D538E9A7C8F8A8E93FF314EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unsetOnEcbModeExitResponse(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mEcmExitRespRegistrant.clear();
        // ---------- Original Method ----------
        //mEcmExitRespRegistrant.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.139 -0400", hash_original_method = "0F8C6CFDB05E5D9DD9E146C1B344047B", hash_generated_method = "DADB314647E305A822A5E85E209BB736")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForCallWaiting(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mCT.registerForCallWaiting(h, what, obj);
        // ---------- Original Method ----------
        //mCT.registerForCallWaiting(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.140 -0400", hash_original_method = "0239428C6B544E5C48B7505010514559", hash_generated_method = "37470FDD0029C1A4EBD554EA51AFC93A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForCallWaiting(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mCT.unregisterForCallWaiting(h);
        // ---------- Original Method ----------
        //mCT.unregisterForCallWaiting(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.140 -0400", hash_original_method = "639F59C576968CC215A4C16BCF60725F", hash_generated_method = "8350F8AAC85DA2984CA4738A93F6F240")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.140 -0400", hash_original_method = "872EFAB028EF9345A6D84A5CBF27D619", hash_generated_method = "A6500CE6C9FC2BD7F1F992A3F8DC1DED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DataState getDataConnectionState(String apnType) {
        dsTaint.addTaint(apnType);
        DataState ret;
        ret = DataState.DISCONNECTED;
        {
            ret = DataState.DISCONNECTED;
        } //End block
        {
            boolean var2B4A8E6DAE4C8B61542DA3830F844B7B_2005851065 = (mSST.getCurrentDataConnectionState() != ServiceState.STATE_IN_SERVICE);
            {
                ret = DataState.DISCONNECTED;
            } //End block
            {
                boolean varEDC38D72B2381B58A0F3730E74C3817C_226936810 = (mDataConnectionTracker.isApnTypeEnabled(apnType) == false ||
                mDataConnectionTracker.isApnTypeActive(apnType) == false);
                {
                    ret = DataState.DISCONNECTED;
                } //End block
                {
                    {
                        Object var819139837D42C0AD62155AA1D23C5AD5_1606144720 = (mDataConnectionTracker.getState(apnType));
                        //Begin case FAILED IDLE 
                        ret = DataState.DISCONNECTED;
                        //End case FAILED IDLE 
                        //Begin case CONNECTED DISCONNECTING 
                        {
                            boolean var398FF6E0DCA52B02F79A9CB272BA56EC_280279922 = (mCT.state != Phone.State.IDLE
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.141 -0400", hash_original_method = "F7E968145C01057A311E794FEA9BAA95", hash_generated_method = "6DE30B3A4ACFDBE9A9A94E28FD773756")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendUssdResponse(String ussdMessge) {
        dsTaint.addTaint(ussdMessge);
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "sendUssdResponse: not possible in CDMA");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.141 -0400", hash_original_method = "98607162C44D8873925496654D522BF8", hash_generated_method = "2796D7390EBC3703077A12FDF51D0406")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendDtmf(char c) {
        dsTaint.addTaint(c);
        {
            boolean varD5E376D61876D980336EC59E5D202EEE_1830353446 = (!PhoneNumberUtils.is12Key(c));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.141 -0400", hash_original_method = "3FBA1333099AE68AF02019D712D23AB2", hash_generated_method = "0DA5592E8014A67A8D5B9D534A5B3B61")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void startDtmf(char c) {
        dsTaint.addTaint(c);
        {
            boolean varD5E376D61876D980336EC59E5D202EEE_424590346 = (!PhoneNumberUtils.is12Key(c));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.142 -0400", hash_original_method = "3DAC039DE959EF34631E2B825CE1F213", hash_generated_method = "E3ACE99405ED7C4AFBEE2F93E02370EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void stopDtmf() {
        mCM.stopDtmf(null);
        // ---------- Original Method ----------
        //mCM.stopDtmf(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.142 -0400", hash_original_method = "E3E7B97B548DE87ECFE3195659B23FF9", hash_generated_method = "73FB0C8A864784B0EA5E1EED55B448A0")
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
            boolean varC203A73757365FB141AA417E652E019C_1344242787 = (itr < dtmfString.length());
            {
                {
                    boolean var6A7122EA2D2E6A95C8F93E4E1672AD9E_1851637036 = (!PhoneNumberUtils.is12Key(dtmfString.charAt(itr)));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.143 -0400", hash_original_method = "FE0764939BCED80E9275F681708ABC99", hash_generated_method = "870F38DC6B9EC0109986638D766DE62C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getAvailableNetworks(Message response) {
        dsTaint.addTaint(response.dsTaint);
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "getAvailableNetworks: not possible in CDMA");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.144 -0400", hash_original_method = "9C1B6A588127C991585EBB349A2379DB", hash_generated_method = "407836156E50C83ED99C3093C4151E61")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOutgoingCallerIdDisplay(int commandInterfaceCLIRMode, Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(commandInterfaceCLIRMode);
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "setOutgoingCallerIdDisplay: not possible in CDMA");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.144 -0400", hash_original_method = "85721F5820CF0128BD1EA66BA785E274", hash_generated_method = "8061BA0AAC1F798918E946EB98E60D31")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void enableLocationUpdates() {
        mSST.enableLocationUpdates();
        // ---------- Original Method ----------
        //mSST.enableLocationUpdates();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.144 -0400", hash_original_method = "E6FECC87DDBB4D4FE984E494757397E3", hash_generated_method = "3FDC902944764AB6B7139C73765CF957")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void disableLocationUpdates() {
        mSST.disableLocationUpdates();
        // ---------- Original Method ----------
        //mSST.disableLocationUpdates();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.145 -0400", hash_original_method = "DAED77F9218E0449A772CA04214CC7F0", hash_generated_method = "695C32289DCD7DAE07301ADFF341D49F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getDataCallList(Message response) {
        dsTaint.addTaint(response.dsTaint);
        mCM.getDataCallList(response);
        // ---------- Original Method ----------
        //mCM.getDataCallList(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.145 -0400", hash_original_method = "33CDF43696035DC3E16A234222A80D64", hash_generated_method = "24E4766D4E16B5F5D801378AAAD4ADEC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getDataRoamingEnabled() {
        boolean var6ACB2ECE8621241EECE599BD6243F11B_1144454376 = (mDataConnectionTracker.getDataOnRoamingEnabled());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mDataConnectionTracker.getDataOnRoamingEnabled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.145 -0400", hash_original_method = "63103D1CE9C7888BE66C8CE520564C7E", hash_generated_method = "A9DE00EFFC13F4089A11258E9D792C4C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setVoiceMailNumber(String alphaTag,
                                   String voiceMailNumber,
                                   Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(voiceMailNumber);
        dsTaint.addTaint(alphaTag);
        Message resp;
        resp = obtainMessage(EVENT_SET_VM_NUMBER_DONE, 0, 0, onComplete);
        mIccRecords.setVoiceMailNumber(alphaTag, mVmNumber, resp);
        // ---------- Original Method ----------
        //Message resp;
        //mVmNumber = voiceMailNumber;
        //resp = obtainMessage(EVENT_SET_VM_NUMBER_DONE, 0, 0, onComplete);
        //mIccRecords.setVoiceMailNumber(alphaTag, mVmNumber, resp);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.145 -0400", hash_original_method = "EC96491CC2681D27125B6B3540F74113", hash_generated_method = "726600CE775B9ED0AE93360853BE57BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getVoiceMailNumber() {
        String number;
        number = null;
        SharedPreferences sp;
        sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        {
            boolean var8B403152FA0B86F979BAF5F52F130215_1020704327 = (getContext().getResources().getBoolean(com.android.internal
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.146 -0400", hash_original_method = "5D69EEC40343498AF4F71AD96BF8D875", hash_generated_method = "A5CBFA9A670997E5A4B297426696E5E6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.146 -0400", hash_original_method = "72DF9B0892372ADFAD7DE65056384F5E", hash_generated_method = "67F86C47436EE0DAFDBE0AC7CD9625BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getVoiceMailAlphaTag() {
        String ret;
        ret = "";
        {
            boolean var0709D69E6C2648B4A0C93BD0750A7DE0_212823164 = (ret == null || ret.length() == 0);
            {
                String varA530EF9D7F6A4C3687908C13A6C584D5_1977366585 = (mContext.getText(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.146 -0400", hash_original_method = "E23DBF1DA2409183D56D85932A9D038B", hash_generated_method = "72741121265CEDDF90136053F1A4DFA2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getCallForwardingOption(int commandInterfaceCFReason, Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(commandInterfaceCFReason);
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "getCallForwardingOption: not possible in CDMA");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.146 -0400", hash_original_method = "A636525DAEF6D9A554C143CAF44D5772", hash_generated_method = "A5CF6B281B030C66B6CF3CBB9101FD77")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.146 -0400", hash_original_method = "C44463D6A0E6885F3CB7F2F8669CD319", hash_generated_method = "1E278D72B4F6C12209F1B7392DEB3508")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getOutgoingCallerIdDisplay(Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "getOutgoingCallerIdDisplay: not possible in CDMA");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.146 -0400", hash_original_method = "D57FAF7F6BF0B2A3D2D79072DE461E12", hash_generated_method = "654CFC62A07315396263A8F5878E75EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getCallForwardingIndicator() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "getCallForwardingIndicator: not possible in CDMA");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.147 -0400", hash_original_method = "4D4FE78E3983A39BD949CCB232763B54", hash_generated_method = "64D6052E7E469134BF989A118677B658")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void explicitCallTransfer() {
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "explicitCallTransfer: not possible in CDMA");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.147 -0400", hash_original_method = "280CC3981F581DF1B137B098EEA6AAEB", hash_generated_method = "FC4A974B31D689198CA34F99765C659F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getLine1AlphaTag() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "getLine1AlphaTag: not possible in CDMA");
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.147 -0400", hash_original_method = "812A77A153EDB691C43A0B58CAFAA77A", hash_generated_method = "AB35579F49622E7A241F12B7DDB4EC19")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void notifyPhoneStateChanged() {
        mNotifier.notifyPhoneState(this);
        // ---------- Original Method ----------
        //mNotifier.notifyPhoneState(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.147 -0400", hash_original_method = "3EB8461625C29B29FD6CB8E5D60B43F3", hash_generated_method = "D04CBC6D94303085010D6FD72DFDF138")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void notifyPreciseCallStateChanged() {
        super.notifyPreciseCallStateChangedP();
        // ---------- Original Method ----------
        //super.notifyPreciseCallStateChangedP();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.147 -0400", hash_original_method = "73E7BFF04E4E9785E6146409272926BA", hash_generated_method = "E90FF12135FFFA3180D191EA7D408C6A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void notifyServiceStateChanged(ServiceState ss) {
        dsTaint.addTaint(ss.dsTaint);
        super.notifyServiceStateChangedP(ss);
        // ---------- Original Method ----------
        //super.notifyServiceStateChangedP(ss);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.147 -0400", hash_original_method = "482FE18FBD1949DAF708F2E65940DE8F", hash_generated_method = "0723685B826BB9996EC0449E7B1A8FCF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void notifyLocationChanged() {
        mNotifier.notifyCellLocation(this);
        // ---------- Original Method ----------
        //mNotifier.notifyCellLocation(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.147 -0400", hash_original_method = "292444BE96E352C8E8312B338E19EF02", hash_generated_method = "31C9E56614FB3AAD40C46802EAC18158")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void notifyNewRingingConnection(Connection c) {
        dsTaint.addTaint(c.dsTaint);
        super.notifyNewRingingConnectionP(c);
        // ---------- Original Method ----------
        //super.notifyNewRingingConnectionP(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.148 -0400", hash_original_method = "1858091673D3A4B62C058FCC91892C36", hash_generated_method = "2C4B5AD2DBE6251947A4E99B58E84719")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void notifyDisconnect(Connection cn) {
        dsTaint.addTaint(cn.dsTaint);
        mDisconnectRegistrants.notifyResult(cn);
        // ---------- Original Method ----------
        //mDisconnectRegistrants.notifyResult(cn);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.148 -0400", hash_original_method = "4DFA3B176AED92FABCFB596FBC88C127", hash_generated_method = "78FF0EBB369D5E48C88943009DE8A38C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void notifyUnknownConnection() {
        mUnknownConnectionRegistrants.notifyResult(this);
        // ---------- Original Method ----------
        //mUnknownConnectionRegistrants.notifyResult(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.148 -0400", hash_original_method = "393DB826FD1453B6BE0DEA71B818C50D", hash_generated_method = "D38008E42755717C7B6DD62941F2E594")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isInEmergencyCall() {
        boolean varD8A2457FC2EBCE0C63162FEE0C7B8E1B_1700770017 = (mCT.isInEmergencyCall());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCT.isInEmergencyCall();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.148 -0400", hash_original_method = "B4B2A6F2428B54DDD4A7791B2905A02A", hash_generated_method = "654A601D2AF1505720A14BECD738D890")
    @DSModeled(DSC.SAFE)
    public boolean isInEcm() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIsPhoneInEcmState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.148 -0400", hash_original_method = "00543A79BC25C997F29F0DAD4E28E830", hash_generated_method = "C554F53B49B78857328BE86DADBC7C80")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.148 -0400", hash_original_method = "B67535D9EC35CAA35F8134AB61AC3782", hash_generated_method = "52CEF7F46B32E47ED84AC5D9C919244C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void exitEmergencyCallbackMode() {
        {
            boolean varC8E4FB4CC0E8CC6621CB9ECC0FDC7EC6_792531115 = (mWakeLock.isHeld());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.149 -0400", hash_original_method = "379601A1C426F495327BF8B224FF5B5D", hash_generated_method = "7CD466DCB8019A2018E209B6FD0099CB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.149 -0400", hash_original_method = "DE92BF7F05810FB5E0BD1EEEAFEB4B90", hash_generated_method = "0EF5337AB07414464093E82E466A42F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.149 -0400", hash_original_method = "C8EF6B60BE95B81385F7554432463CF1", hash_generated_method = "2C1ADAE7469CF39B86DA6704EBE14132")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.150 -0400", hash_original_method = "BEFF27391F370909F03A02FD6CE5C8E1", hash_generated_method = "AA9CC66ECB98D5286D0E62D674900A59")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForEcmTimerReset(Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mEcmTimerResetRegistrants.addUnique(h, what, obj);
        // ---------- Original Method ----------
        //mEcmTimerResetRegistrants.addUnique(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.150 -0400", hash_original_method = "2652F35782787E1271AD631A33A0033B", hash_generated_method = "EFA360886AF54B104FE3178FFFF35550")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForEcmTimerReset(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mEcmTimerResetRegistrants.remove(h);
        // ---------- Original Method ----------
        //mEcmTimerResetRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.151 -0400", hash_original_method = "69FA59CB460FF0A097B9F7F6B4D5A187", hash_generated_method = "166D4F2675EC32CB51470A23E494ABC5")
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
                boolean varBCC2AAC262927329DC1DDFC23398E7CA_1937692740 = (IccException.class.isInstance(ar.exception));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.151 -0400", hash_original_method = "4BF16EE42BDE3709043B0CD4BA1346D5", hash_generated_method = "CE36A8A4D7D696266EB6543D64E6F2A5")
    @DSModeled(DSC.SAFE)
    public PhoneSubInfo getPhoneSubInfo() {
        return (PhoneSubInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mSubInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.151 -0400", hash_original_method = "A5B3830D3022369CFD45112AC4A19D05", hash_generated_method = "F1D5FE1C53FE6D1FA97AB97534A3A0FD")
    @DSModeled(DSC.SAFE)
    public IccSmsInterfaceManager getIccSmsInterfaceManager() {
        return (IccSmsInterfaceManager)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mRuimSmsInterfaceManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.151 -0400", hash_original_method = "F4C16F1EDC7887AFA610A21C85E2FBBC", hash_generated_method = "47BAA4C748AECE4E043F264F70505D69")
    @DSModeled(DSC.SAFE)
    public IccPhoneBookInterfaceManager getIccPhoneBookInterfaceManager() {
        return (IccPhoneBookInterfaceManager)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mRuimPhoneBookInterfaceManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.152 -0400", hash_original_method = "631C425442894A51F9E1215F7444839C", hash_generated_method = "96689D0A48EE8724D551227EC7570E91")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.152 -0400", hash_original_method = "FC47AF6104E2994A09ED5540AEE820A5", hash_generated_method = "C6E46E8FAFFFAAC201F2213ADC50F94D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForNvLoaded(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mNvLoadedRegistrants.remove(h);
        // ---------- Original Method ----------
        //mNvLoadedRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.152 -0400", hash_original_method = "76D872D60E8DF5A817173A7970E48DAF", hash_generated_method = "1749B6BE144CB50499D380443BB37820")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.152 -0400", hash_original_method = "609ACFE0DF3AD88014ED023EE4CC2BBF", hash_generated_method = "8E5EEF6203319E0F85F1432D091AEE13")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForEriFileLoaded(Handler h) {
        dsTaint.addTaint(h.dsTaint);
        mEriFileLoadedRegistrants.remove(h);
        // ---------- Original Method ----------
        //mEriFileLoadedRegistrants.remove(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.152 -0400", hash_original_method = "C4157CB043EC8B3384F8270EB7DCD5BB", hash_generated_method = "0789F4BF69E5002EE8299BC73ED51C2B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setSystemProperty(String property, String value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(property);
        super.setSystemProperty(property, value);
        // ---------- Original Method ----------
        //super.setSystemProperty(property, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.153 -0400", hash_original_method = "515987807F65054AFA6AA9A268DDB599", hash_generated_method = "3E9E03406BCF20EAA226CD3B13F7CA06")
    @DSModeled(DSC.SAFE)
    public IccFileHandler getIccFileHandler() {
        return (IccFileHandler)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.mIccFileHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.153 -0400", hash_original_method = "793C414C17B853DD540D3B3DFD8290DE", hash_generated_method = "99A8D3C554C6FECDCFDF520030660766")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void activateCellBroadcastSms(int activate, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(activate);
        response.sendToTarget();
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[CDMAPhone] activateCellBroadcastSms() is obsolete; use SmsManager");
        //response.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.153 -0400", hash_original_method = "81E322CF525B990EC666DA306E1980A6", hash_generated_method = "CE0AD5A92439584083AF8BCBD3A7394B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getCellBroadcastSmsConfig(Message response) {
        dsTaint.addTaint(response.dsTaint);
        response.sendToTarget();
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[CDMAPhone] getCellBroadcastSmsConfig() is obsolete; use SmsManager");
        //response.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.153 -0400", hash_original_method = "718A796BA1FEFA7B8760E97D0CFF0F71", hash_generated_method = "46221FDC6909E09CC98443641AB334A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCellBroadcastSmsConfig(int[] configValuesArray, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(configValuesArray[0]);
        response.sendToTarget();
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[CDMAPhone] setCellBroadcastSmsConfig() is obsolete; use SmsManager");
        //response.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.153 -0400", hash_original_method = "C10911F486938B4F93DC849B5E1085A3", hash_generated_method = "5B7A83DEA6477A0D8F7AF7AED7636D34")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean needsOtaServiceProvisioning() {
        boolean var3814F4E6C3697558290520EC0B4891A9_1502203504 = (mSST.getOtasp() != ServiceStateTracker.OTASP_NOT_NEEDED);
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.154 -0400", hash_original_method = "2F4529BDEA4C79E5E2F449E50272F3AC", hash_generated_method = "E0F2C226410CFFA736E8A03E45350570")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isCarrierOtaSpNum(String dialStr) {
        dsTaint.addTaint(dialStr);
        boolean isOtaSpNum;
        isOtaSpNum = false;
        int sysSelCodeInt;
        sysSelCodeInt = extractSelCodeFromOtaSpNum(dialStr);
        {
            boolean varC25E28587E797B4B1D25D8A223D7987E_740479820 = (!TextUtils.isEmpty(mCarrierOtaSpNumSchema));
            {
                Matcher m;
                m = pOtaSpNumSchema.matcher(mCarrierOtaSpNumSchema);
                {
                    Log.d(LOG_TAG, "isCarrierOtaSpNum,schema" + mCarrierOtaSpNumSchema);
                } //End block
                {
                    boolean var39BD3106C7A2329BC5A3364836FB2CF9_2028580369 = (m.find());
                    {
                        String sch[];
                        sch = pOtaSpNumSchema.split(mCarrierOtaSpNumSchema);
                        {
                            boolean varB2BFE86D7B99BED62C3AF16905511122_590932231 = (!TextUtils.isEmpty(sch[0]) && sch[0].equals("SELC"));
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
                                boolean var981C353E34C8504891CF0AE981C84F35_177303439 = (!TextUtils.isEmpty(sch[0]) && sch[0].equals("FC"));
                                {
                                    int fcLen;
                                    fcLen = Integer.parseInt((String)sch[1]);
                                    String fc;
                                    fc = (String)sch[2];
                                    {
                                        boolean varCF1EF44489814B5931C694BEAA6AF449_1350671374 = (dialStr.regionMatches(0,fc,0,fcLen));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.155 -0400", hash_original_method = "AE6C103DE6DE549189EC8F2DC89B4935", hash_generated_method = "1E9F0475A3460D3272286F0DA123F711")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.155 -0400", hash_original_method = "CBAF5F4AF9A1C44FBA957D2F8ABDCEC2", hash_generated_method = "7BFA76A1C8ABC2DEC04C21E55730D0A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getCdmaEriIconIndex() {
        int var7D21F14EF91E1D5E5A5201CD691F6EC1_1850440610 = (getServiceState().getCdmaEriIconIndex());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getServiceState().getCdmaEriIconIndex();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.155 -0400", hash_original_method = "505B53637594CBFFA64F8CC821649187", hash_generated_method = "BF4AD1CF842CAB3A92AF126DFC24C790")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getCdmaEriIconMode() {
        int var14A1514753E21C20C1CFD187FB3391BF_1722754646 = (getServiceState().getCdmaEriIconMode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getServiceState().getCdmaEriIconMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.155 -0400", hash_original_method = "FF25B4C2C2FD6DDBAFFF02AC278A249A", hash_generated_method = "2335510F604A95D2428F9C4D0ACA639F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String getCdmaEriText() {
        int roamInd;
        roamInd = getServiceState().getCdmaRoamingIndicator();
        int defRoamInd;
        defRoamInd = getServiceState().getCdmaDefaultRoamingIndicator();
        String var9E1574EDCAF4CECB844B84DF6CC8DDF2_1614480772 = (mEriManager.getCdmaEriText(roamInd, defRoamInd));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //int roamInd = getServiceState().getCdmaRoamingIndicator();
        //int defRoamInd = getServiceState().getCdmaDefaultRoamingIndicator();
        //return mEriManager.getCdmaEriText(roamInd, defRoamInd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.155 -0400", hash_original_method = "1FA484546C7B73CA49B2C4AE64A8C83E", hash_generated_method = "AC686ED20C1F38DE14C512AFE0E70593")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.156 -0400", hash_original_method = "04903824830A3F9FD2759E9C177CC0CB", hash_generated_method = "D3EE4BA85D79B147E770BBFC72FAF7E3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setIsoCountryProperty(String operatorNumeric) {
        dsTaint.addTaint(operatorNumeric);
        {
            boolean var1C5534FDAA00A1B387A79218D6BAEF6C_340190772 = (TextUtils.isEmpty(operatorNumeric));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.156 -0400", hash_original_method = "B076A318D7F3CB7E259ECDC99FDB3D0D", hash_generated_method = "C7B9C68012DE06B9CF181FDDC7BD69C9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean updateCurrentCarrierInProvider(String operatorNumeric) {
        dsTaint.addTaint(operatorNumeric);
        {
            boolean var94B3144E977DE08BBD4DC30162F60334_1722039187 = (!TextUtils.isEmpty(operatorNumeric));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.156 -0400", hash_original_method = "A95BEE5F1920F9C579D7A59FC4DBB414", hash_generated_method = "01C0A9BD2B813E631FB4FA9B98E5DA73")
    @DSModeled(DSC.SAFE)
     boolean updateCurrentCarrierInProvider() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.156 -0400", hash_original_method = "5CB32743CEBF9A8556BB2E144A975CB3", hash_generated_method = "E62F0DA7E4AC9A209EB2AC38AFE1BF0F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void prepareEri() {
        mEriManager.loadEriFile();
        {
            boolean var07BA6C1E3CEBF9422B7FD30B01BA2995_1493487628 = (mEriManager.isEriFileLoaded());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.157 -0400", hash_original_method = "71144CF5C8B23350BF31931D81A1C3AC", hash_generated_method = "669DF593E5ED95D0C1D5CF50EC2EC3E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isEriFileLoaded() {
        boolean varAA8EBCEDF474BF00A450A0F8740F0DD7_600090099 = (mEriManager.isEriFileLoaded());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mEriManager.isEriFileLoaded();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.157 -0400", hash_original_method = "CBB2DC533610D724567F0136955B7014", hash_generated_method = "37CC785F16F06D220BC214B4FB0B1F7F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void log(String s) {
        dsTaint.addTaint(s);
        Log.d(LOG_TAG, "[CDMAPhone] " + s);
        // ---------- Original Method ----------
        //if (DBG)
            //Log.d(LOG_TAG, "[CDMAPhone] " + s);
    }

    
    static final String LOG_TAG = "CDMA";
    private static final boolean DBG = true;
    private static final int DEFAULT_ECM_EXIT_TIMER_VALUE = 300000;
    static final String VM_COUNT_CDMA = "vm_count_key_cdma";
    private static final String VM_NUMBER_CDMA = "vm_number_key_cdma";
    static final int RESTART_ECM_TIMER = 0;
    static final int CANCEL_ECM_TIMER = 1;
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
}

