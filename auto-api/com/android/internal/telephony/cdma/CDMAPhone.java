package com.android.internal.telephony.cdma;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.999 -0400", hash_original_field = "EA09C636C379E17EBA9E1A0866EC0796", hash_generated_field = "EC3246CB1DC699CB7AAC1E49E6B00916")

    private String mVmNumber = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.999 -0400", hash_original_field = "1D14D2D55BC367CD6AE3740CDB7152AF", hash_generated_field = "FB56FB2CCEDB5FF40D60B0E1FF012DC7")

    CdmaCallTracker mCT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.999 -0400", hash_original_field = "72BFF8190B34BEEE16406717B341412A", hash_generated_field = "97103F1B8DA1A01BC27456D6E3D45BD7")

    CdmaServiceStateTracker mSST;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.999 -0400", hash_original_field = "AF9E4B265579DF9690B194FA007294E8", hash_generated_field = "D1A76B98E2C9695E066872EF0F2A70D1")

    ArrayList <CdmaMmiCode> mPendingMmis = new ArrayList<CdmaMmiCode>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.999 -0400", hash_original_field = "5E8EA195206083E32FDBF6E6099D5D6E", hash_generated_field = "CC6C54ADD522D3CBE4AB79FC4C1AC885")

    RuimPhoneBookInterfaceManager mRuimPhoneBookInterfaceManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.999 -0400", hash_original_field = "A6CE63222F1F9B27D76D3EFFD0637A73", hash_generated_field = "52B0967754C377F16D6ECE26A27604BC")

    RuimSmsInterfaceManager mRuimSmsInterfaceManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.999 -0400", hash_original_field = "2C01F66E136181E8D582317306CCAC30", hash_generated_field = "F066FAD7B5AEEA27E2872ED159BF1CA4")

    PhoneSubInfo mSubInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.999 -0400", hash_original_field = "D2A1C9BF1A12B6A3A40E07BE541CCFEE", hash_generated_field = "5D6E15ED8D3AB433E5BB540845A155BB")

    EriManager mEriManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.999 -0400", hash_original_field = "69E45E7E240C011D8CB3CFDE90D76B33", hash_generated_field = "33E56F28B2B8FE4608887A854590880D")

    WakeLock mWakeLock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.999 -0400", hash_original_field = "74DE9B4DC153E7DBF167AFAC069421EB", hash_generated_field = "8E0942E84D2F17846D93DF1A3D310CA4")

    CatService mCcatService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.999 -0400", hash_original_field = "4CDA2C9561C6A6C20487424E5EB400E6", hash_generated_field = "962FB4C4696AA137E9F4B34F6067EBE9")

    private final RegistrantList mNvLoadedRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.999 -0400", hash_original_field = "42E8008744B539D2A4BE195C758A52AD", hash_generated_field = "FDA1F534CB258FBCC142BC692B71ACD1")

    private final RegistrantList mEriFileLoadedRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.999 -0400", hash_original_field = "E5961082E6F858D1F4DC7E89696FE2B2", hash_generated_field = "5B4BDBC7A862DE1A873EE80476741013")

    private final RegistrantList mEcmTimerResetRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.999 -0400", hash_original_field = "955CE82CD3A5151723EB19D6614F559B", hash_generated_field = "1771FD97E99F7F7ADB6C6B6F1AD7072C")

    private boolean mIsPhoneInEcmState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.999 -0400", hash_original_field = "0ED8E01E502CF8564596FEC2F99A39EF", hash_generated_field = "1BDAC9D71123A8DEB653B2C84AF01BA0")

    private Registrant mEcmExitRespRegistrant;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.999 -0400", hash_original_field = "453C2995A2CC7C51188981A0F3965EED", hash_generated_field = "A314A9B894E97303A992D075673C95F0")

    protected String mImei;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.999 -0400", hash_original_field = "225448F5B7EE27E6F9CC21B80A6466DB", hash_generated_field = "86781DA86EE57C5A1DD8A1C30699806C")

    protected String mImeiSv;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.999 -0400", hash_original_field = "941CECC3CFC825DE92ED3B472B7DE551", hash_generated_field = "D60FA66B4CDB744384FC242287466EE9")

    private String mEsn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.999 -0400", hash_original_field = "39E558836DC399944C3B0229DC5337CC", hash_generated_field = "4AF7BD5643CFD768CB253CD96C809185")

    private String mMeid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.999 -0400", hash_original_field = "9A2CB205F5ACBD0C68BA41B8A9632D2A", hash_generated_field = "317DA458812FD117268BB82503CFDA82")

    private String mCarrierOtaSpNumSchema;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.000 -0400", hash_original_field = "5E0153DE5EDFE60861980DB630071DCD", hash_generated_field = "A9D48B4F37E6DEE9FEDDDBF0EA9949F0")

    private Runnable mExitEcmRunnable = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.000 -0400", hash_original_method = "F3DC5BFDA25D02344EBFE8F4AEC767D8", hash_generated_method = "13E58FFF08C64D739C7C2CEA1DFD40E8")
        @Override
        public void run() {
            exitEmergencyCallbackMode();
            
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.000 -0400", hash_original_field = "B70FAC06870FA211D668F462A2DBA212", hash_generated_field = "126D29D3ACD6141B3CF1C156D9BC8C27")

    Registrant mPostDialHandler;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.000 -0400", hash_original_method = "DAE6B8BFE7F70789DB7C3B99D4D5F7DA", hash_generated_method = "FD43AF827A5A82862FD3C5AC44A504A7")
    public  CDMAPhone(Context context, CommandsInterface ci, PhoneNotifier notifier) {
        super(notifier, context, ci, false);
        initSstIcc();
        init(context, notifier);
        addTaint(context.getTaint());
        addTaint(ci.getTaint());
        addTaint(notifier.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.000 -0400", hash_original_method = "467D4326BF1EF0C31B8D509189D4E2E0", hash_generated_method = "4C9CA93E067E888ACB7D4C62B21DB886")
    public  CDMAPhone(Context context, CommandsInterface ci, PhoneNotifier notifier,
            boolean unitTestMode) {
        super(notifier, context, ci, unitTestMode);
        initSstIcc();
        init(context, notifier);
        addTaint(context.getTaint());
        addTaint(ci.getTaint());
        addTaint(notifier.getTaint());
        addTaint(unitTestMode);
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.001 -0400", hash_original_method = "1B7DFBB42AE4FBFECC004BFFF3CFFDDB", hash_generated_method = "EC0DA6F48DC1646B607F03DA38DBAF6C")
    protected void initSstIcc() {
        mSST = new CdmaServiceStateTracker(this);
        mIccRecords = new RuimRecords(this);
        mIccCard = new RuimCard(this, LOG_TAG, DBG);
        mIccFileHandler = new RuimFileHandler(this);
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.001 -0400", hash_original_method = "8461B888D034831850AE73E07FC3F149", hash_generated_method = "A152798CAA9E16F935B6FB2DDA179158")
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
        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        mWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,LOG_TAG);
        SystemProperties.set(TelephonyProperties.CURRENT_ACTIVE_PHONE,
                Integer.toString(Phone.PHONE_TYPE_CDMA));
        String inEcm = SystemProperties.get(TelephonyProperties.PROPERTY_INECM_MODE, "false");
        mIsPhoneInEcmState = inEcm.equals("true");
        {
            mCM.exitEmergencyCallbackMode(obtainMessage(EVENT_EXIT_EMERGENCY_CALLBACK_RESPONSE));
        } 
        mCarrierOtaSpNumSchema = SystemProperties.get(
                TelephonyProperties.PROPERTY_OTASP_NUM_SCHEMA,"");
        String operatorAlpha = SystemProperties.get("ro.cdma.home.operator.alpha");
        setSystemProperty(PROPERTY_ICC_OPERATOR_ALPHA, operatorAlpha);
        String operatorNumeric = SystemProperties.get(PROPERTY_CDMA_HOME_OPERATOR_NUMERIC);
        setSystemProperty(PROPERTY_ICC_OPERATOR_NUMERIC, operatorNumeric);
        setIsoCountryProperty(operatorNumeric);
        updateCurrentCarrierInProvider(operatorNumeric);
        notifier.notifyMessageWaitingChanged(this);
        addTaint(notifier.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.003 -0400", hash_original_method = "9DE3C78959AC59CCA27F149210FA77A8", hash_generated_method = "F3FEEAA479B2FA983331D6EBDEFF4F44")
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
        } 
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.004 -0400", hash_original_method = "EE2FF8AAD85928FB8E8B4233881FEB3A", hash_generated_method = "123CADA6CF62D4FBD8FD71E77576DE69")
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
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.004 -0400", hash_original_method = "717E537581BE31A7DC523FEE6B0DDE4B", hash_generated_method = "2A4B3F2D388A2F76E145116CF4A21074")
    @Override
    protected void finalize() {
        Log.d(LOG_TAG, "CDMAPhone finalized");
        {
            boolean varC8E4FB4CC0E8CC6621CB9ECC0FDC7EC6_1903253058 = (mWakeLock.isHeld());
            {
                mWakeLock.release();
            } 
        } 
        
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.005 -0400", hash_original_method = "DA0F221C2247572C4D631280E4033E9A", hash_generated_method = "75C9A4DC009E7C6E8BD6E3E6F2F54641")
    public ServiceState getServiceState() {
        ServiceState varB4EAC82CA7396A68D541C85D26508E83_1485372939 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1485372939 = mSST.ss;
        varB4EAC82CA7396A68D541C85D26508E83_1485372939.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1485372939;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.005 -0400", hash_original_method = "79AFD9B845E4547B981131DAC9E3A14D", hash_generated_method = "0673B097E808358AAA4A724CD276D518")
    public CallTracker getCallTracker() {
        CallTracker varB4EAC82CA7396A68D541C85D26508E83_508399122 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_508399122 = mCT;
        varB4EAC82CA7396A68D541C85D26508E83_508399122.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_508399122;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.005 -0400", hash_original_method = "8AEFB373111A9C8AD30F3E8C75C461D2", hash_generated_method = "C25F6042B38E07CB84DA41946A21558C")
    public Phone.State getState() {
        Phone.State varB4EAC82CA7396A68D541C85D26508E83_338276763 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_338276763 = mCT.state;
        varB4EAC82CA7396A68D541C85D26508E83_338276763.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_338276763;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.006 -0400", hash_original_method = "BD481539215D5A66E62B4E6909625141", hash_generated_method = "10FE0B72DAB737EE17BD0C7491F0CE0D")
    public ServiceStateTracker getServiceStateTracker() {
        ServiceStateTracker varB4EAC82CA7396A68D541C85D26508E83_288066415 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_288066415 = mSST;
        varB4EAC82CA7396A68D541C85D26508E83_288066415.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_288066415;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.006 -0400", hash_original_method = "B0BDAF041F7F636A26D0F46F60D4BC7B", hash_generated_method = "AFEAEA8D04B74239FD71EE57DCC1133B")
    public String getPhoneName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1281937172 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1281937172 = "CDMA";
        varB4EAC82CA7396A68D541C85D26508E83_1281937172.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1281937172;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.006 -0400", hash_original_method = "94F6AF6179535CBD756D5B387D52C3CA", hash_generated_method = "B61FB36BB46B43BE7F9F2FBE72676F86")
    public int getPhoneType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2137106739 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2137106739;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.007 -0400", hash_original_method = "F828A2F1845194FFD82C471D7E89F726", hash_generated_method = "0169E179288AEE3AAD464E78651B60DA")
    public boolean canTransfer() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1070396021 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1070396021;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.007 -0400", hash_original_method = "31E0316605311F71BD2BE82139C4C7B1", hash_generated_method = "CD0E32DC791EC1AD2D28822995AD3F6B")
    public CdmaCall getRingingCall() {
        CdmaCall varB4EAC82CA7396A68D541C85D26508E83_796364633 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_796364633 = mCT.ringingCall;
        varB4EAC82CA7396A68D541C85D26508E83_796364633.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_796364633;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.007 -0400", hash_original_method = "E892EC268DCFDF5C9C27A7DDC7E00573", hash_generated_method = "77B440C2480B73790494E18A49E29D56")
    public void setMute(boolean muted) {
        mCT.setMute(muted);
        addTaint(muted);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.007 -0400", hash_original_method = "FA6E824680C8944626A1A959DCEA6499", hash_generated_method = "BC61116B5FC5F9CC9ECDD08C2FE7C82D")
    public boolean getMute() {
        boolean var20663A120A6F5E860F4EB58F2E5B9228_1859574082 = (mCT.getMute());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1013061894 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1013061894;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.008 -0400", hash_original_method = "593DDE28AC9DCA9096C93A9D0D1099FC", hash_generated_method = "EFBC49A5AD73E9A3CBDEEDFF40E8B0EA")
    public void conference() throws CallStateException {
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.008 -0400", hash_original_method = "F90799FAE99EB431CF7F205DFD6DDD5D", hash_generated_method = "BE7111E41193CEA5B7239AE1DFAEDB0E")
    public void enableEnhancedVoicePrivacy(boolean enable, Message onComplete) {
        this.mCM.setPreferredVoicePrivacy(enable, onComplete);
        addTaint(enable);
        addTaint(onComplete.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.008 -0400", hash_original_method = "5CE753EAA3145BBCA6A00800B2884B4E", hash_generated_method = "F103ED469C3205417264AB80600932E6")
    public void getEnhancedVoicePrivacy(Message onComplete) {
        this.mCM.getPreferredVoicePrivacy(onComplete);
        addTaint(onComplete.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.008 -0400", hash_original_method = "B9932A8A8BD16A4F0D461DDC6FDE6B49", hash_generated_method = "BEFA10EB4DBC56DB633604D1159E6D30")
    public void clearDisconnected() {
        mCT.clearDisconnected();
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.009 -0400", hash_original_method = "34BFC6F1F77B77A760EA5A249CE3FEFD", hash_generated_method = "09A9B46D30B88B3E2D6ED0D31211A0B2")
    public DataActivityState getDataActivityState() {
        DataActivityState varB4EAC82CA7396A68D541C85D26508E83_1797007388 = null; 
        DataActivityState ret = DataActivityState.NONE;
        {
            boolean varA31FE6075ED3D4825296DCCB8274BE5E_778548078 = (mSST.getCurrentDataConnectionState() == ServiceState.STATE_IN_SERVICE);
            {
                {
                    Object var27C7E0FDBE09DE35AC2FD606F73591E2_344069134 = (mDataConnectionTracker.getActivity());
                    
                    ret = DataActivityState.DATAIN;
                    
                    
                    ret = DataActivityState.DATAOUT;
                    
                    
                    ret = DataActivityState.DATAINANDOUT;
                    
                    
                    ret = DataActivityState.DORMANT;
                    
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1797007388 = ret;
        varB4EAC82CA7396A68D541C85D26508E83_1797007388.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1797007388;
        
        
        
            
                
                    
                
                
                    
                
                
                    
                
                
                    
                
            
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.009 -0400", hash_original_method = "FCBAE539BB72BE21647FF37299DC2B96", hash_generated_method = "0C6B7A0FF6350CF17887F3D234BB96C8")
     void notifySignalStrength() {
        mNotifier.notifySignalStrength(this);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.009 -0400", hash_original_method = "3B6D00BA5404778271A196326B2492C1", hash_generated_method = "8582C69F183CFA9610E6935DEAC0FD5C")
    public Connection dial(String dialString) throws CallStateException {
        Connection varB4EAC82CA7396A68D541C85D26508E83_987189388 = null; 
        String newDialString = PhoneNumberUtils.stripSeparators(dialString);
        varB4EAC82CA7396A68D541C85D26508E83_987189388 = mCT.dial(newDialString);
        addTaint(dialString.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_987189388.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_987189388;
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.010 -0400", hash_original_method = "C4CAEF0C07F27C620A5D9B835D3227D9", hash_generated_method = "BA3B5AAEB841E7D511F645CA14FFC0EE")
    public Connection dial(String dialString, UUSInfo uusInfo) throws CallStateException {
    	throw new CallStateException("Sending UUS information NOT supported in CDMA!");
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.010 -0400", hash_original_method = "46D9BC6E3280014832CD8FC523C20E6E", hash_generated_method = "829F177786477F8FA37306C1D0E3D67E")
    public SignalStrength getSignalStrength() {
        SignalStrength varB4EAC82CA7396A68D541C85D26508E83_1282167116 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1282167116 = mSST.mSignalStrength;
        varB4EAC82CA7396A68D541C85D26508E83_1282167116.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1282167116;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.010 -0400", hash_original_method = "391334830335544CEFDB5805671813C7", hash_generated_method = "5CE14FF23FAE69A84DF07D9F50162709")
    public boolean getMessageWaitingIndicator() {
        boolean var197AD52F07C983B246C350347281E552_1674000066 = ((getVoiceMessageCount() > 0));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_343915771 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_343915771;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.011 -0400", hash_original_method = "A1DC624417B44DF11F4CA5E5B97277AF", hash_generated_method = "F4D5DCA1AD779430EEA90365442419CB")
    public List<? extends MmiCode> getPendingMmiCodes() {
        List<? extends MmiCode> varB4EAC82CA7396A68D541C85D26508E83_1727256210 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1727256210 = mPendingMmis;
        varB4EAC82CA7396A68D541C85D26508E83_1727256210.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1727256210;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.011 -0400", hash_original_method = "7C5A8D3C952528E3E4A994337305A33B", hash_generated_method = "2EF193B6258D7D83DEEB43DBE8494D8B")
    public void registerForSuppServiceNotification(
            Handler h, int what, Object obj) {
        
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.011 -0400", hash_original_method = "9F7E8D6F89A6C75F0A7653B179AA02CE", hash_generated_method = "5492E631BBCE3BA7A6A7F5219DAB0AAB")
    public CdmaCall getBackgroundCall() {
        CdmaCall varB4EAC82CA7396A68D541C85D26508E83_2003440185 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2003440185 = mCT.backgroundCall;
        varB4EAC82CA7396A68D541C85D26508E83_2003440185.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2003440185;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.012 -0400", hash_original_method = "99F7E880D5431452FB99636E33872BD4", hash_generated_method = "2852E9EF22926A9BBD44B654559EBA5C")
    public boolean handleInCallMmiCommands(String dialString) {
        addTaint(dialString.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1731349610 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1731349610;
        
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.012 -0400", hash_original_method = "F6112A9AE3405415322B12D2CA172B80", hash_generated_method = "9E808C7A4AF328A8AC337670E89384BE")
     boolean isInCall() {
        CdmaCall.State foregroundCallState = getForegroundCall().getState();
        CdmaCall.State backgroundCallState = getBackgroundCall().getState();
        CdmaCall.State ringingCallState = getRingingCall().getState();
        boolean var4B59C8CBE40B3534DD50EEA545B62F2B_126413835 = ((foregroundCallState.isAlive() || backgroundCallState.isAlive() || ringingCallState
                .isAlive()));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_168340035 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_168340035;
        
        
        
        
        
                
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.012 -0400", hash_original_method = "573D1DDDB474C2914324D2DBB21AD4BF", hash_generated_method = "DA6E2EE7F182C05429B80E37E1A19F32")
    public void setNetworkSelectionModeAutomatic(Message response) {
        addTaint(response.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.013 -0400", hash_original_method = "7239EAF7B36D814AB7CF7CD5314FF0C2", hash_generated_method = "CFC7F3A052695995B32633E4C83F6A7E")
    public void unregisterForSuppServiceNotification(Handler h) {
        addTaint(h.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.013 -0400", hash_original_method = "C62CCD6CF2D9D7F7FA17BB7B58067AAC", hash_generated_method = "229941362132B3EA463C13061274E96C")
    public void acceptCall() throws CallStateException {
        mCT.acceptCall();
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.013 -0400", hash_original_method = "A64616985F0D82C6750D71CF8DADC6F4", hash_generated_method = "35B0F59F3248405A594AAB683856BD2F")
    public void rejectCall() throws CallStateException {
        mCT.rejectCall();
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.013 -0400", hash_original_method = "4BD56579DA53A7A8E0646A63E1978FC8", hash_generated_method = "4EFDBB8DAC4DC308937F3C30BD26241D")
    public void switchHoldingAndActive() throws CallStateException {
        mCT.switchWaitingOrHoldingAndActive();
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.014 -0400", hash_original_method = "B121BB30C6EA08968FF3C722126FC795", hash_generated_method = "FE2700DB2A7A252F9B74CE757E573447")
    public String getLine1Number() {
        String varB4EAC82CA7396A68D541C85D26508E83_147065662 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_147065662 = mSST.getMdnNumber();
        varB4EAC82CA7396A68D541C85D26508E83_147065662.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_147065662;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.015 -0400", hash_original_method = "3BC6D82D8BFD82220414E9A1151516B0", hash_generated_method = "7CB14D06D5225368242A14E0FE59D2FA")
    public String getCdmaPrlVersion() {
        String varB4EAC82CA7396A68D541C85D26508E83_1718810020 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1718810020 = mSST.getPrlVersion();
        varB4EAC82CA7396A68D541C85D26508E83_1718810020.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1718810020;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.015 -0400", hash_original_method = "5F3989DCB2E6CEB13D99C9EB5DB3E7E9", hash_generated_method = "2E1E8FB83EACB2C2EA7ED2CD3269C205")
    public String getCdmaMin() {
        String varB4EAC82CA7396A68D541C85D26508E83_850079985 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_850079985 = mSST.getCdmaMin();
        varB4EAC82CA7396A68D541C85D26508E83_850079985.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_850079985;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.015 -0400", hash_original_method = "8703C344BAEB4A9DC4BE8D85F2A2B471", hash_generated_method = "9EE4E847C7E4A5D0C6DC8C843F774E10")
    public boolean isMinInfoReady() {
        boolean var9484B5471A0F2E2C668270A249557278_1811410125 = (mSST.isMinInfoReady());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_785396479 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_785396479;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.016 -0400", hash_original_method = "4561349219664D3BF60D1FEC45B8BB02", hash_generated_method = "1CFC687675A85F7A2FB7991AE326B3B9")
    public void getCallWaiting(Message onComplete) {
        mCM.queryCallWaiting(CommandsInterface.SERVICE_CLASS_VOICE, onComplete);
        addTaint(onComplete.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.016 -0400", hash_original_method = "6583EBFAAE11F5B271B0C202AB11C3E9", hash_generated_method = "05A63141C9EA8439A5D53E7DA83CD61B")
    public void setRadioPower(boolean power) {
        mSST.setRadioPower(power);
        addTaint(power);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.017 -0400", hash_original_method = "A71BC42B8E5B39F885F4E0F3CDCE1523", hash_generated_method = "582F3198B5948D0FCAAE8A0582840ED1")
    public String getEsn() {
        String varB4EAC82CA7396A68D541C85D26508E83_659363438 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_659363438 = mEsn;
        varB4EAC82CA7396A68D541C85D26508E83_659363438.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_659363438;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.017 -0400", hash_original_method = "7E7AAA89C01F3229F1902E361A6CD86F", hash_generated_method = "1378386CCBA4646243B52C3E1861E04D")
    public String getMeid() {
        String varB4EAC82CA7396A68D541C85D26508E83_662233374 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_662233374 = mMeid;
        varB4EAC82CA7396A68D541C85D26508E83_662233374.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_662233374;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.018 -0400", hash_original_method = "7766C412A244B7E9ACAC69FB73BBB546", hash_generated_method = "03C828045840B6C04603720780F2F729")
    public String getDeviceId() {
        String varB4EAC82CA7396A68D541C85D26508E83_127697374 = null; 
        String id = getMeid();
        {
            boolean varAF1C852358631BCBFACC3CD12BED0C0E_1182307628 = ((id == null) || id.matches("^0*$"));
            {
                Log.d(LOG_TAG, "getDeviceId(): MEID is not initialized use ESN");
                id = getEsn();
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_127697374 = id;
        varB4EAC82CA7396A68D541C85D26508E83_127697374.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_127697374;
        
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.018 -0400", hash_original_method = "BA19C271165532D38DF9C2A2EC7580FC", hash_generated_method = "3E9A3F9DA81CCEEBD97BA66611717065")
    public String getDeviceSvn() {
        String varB4EAC82CA7396A68D541C85D26508E83_440303985 = null; 
        Log.d(LOG_TAG, "getDeviceSvn(): return 0");
        varB4EAC82CA7396A68D541C85D26508E83_440303985 = "0";
        varB4EAC82CA7396A68D541C85D26508E83_440303985.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_440303985;
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.019 -0400", hash_original_method = "32994E1C8E091DA1F8318F6B29B65F50", hash_generated_method = "B132201BDED20621F5CD56B90539AAD2")
    public String getSubscriberId() {
        String varB4EAC82CA7396A68D541C85D26508E83_1051251608 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1051251608 = mSST.getImsi();
        varB4EAC82CA7396A68D541C85D26508E83_1051251608.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1051251608;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.019 -0400", hash_original_method = "FAD82CEAF9DD41800ADBC5F4734356D8", hash_generated_method = "56AFD5228A80E42A6A446E05E1EDB093")
    public String getImei() {
        String varB4EAC82CA7396A68D541C85D26508E83_1847263506 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1847263506 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1847263506.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1847263506;
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.019 -0400", hash_original_method = "3D81DB016065E96128526DD50CCAAE05", hash_generated_method = "AEF33B0B73A948F5D4C34AF19B534410")
    public boolean canConference() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_121851742 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_121851742;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.020 -0400", hash_original_method = "E38329BE2FF507326358BBAF596945E6", hash_generated_method = "098F07C3AD48228F1BE65129E56263B2")
    public CellLocation getCellLocation() {
        CellLocation varB4EAC82CA7396A68D541C85D26508E83_2057313913 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2057313913 = mSST.cellLoc;
        varB4EAC82CA7396A68D541C85D26508E83_2057313913.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2057313913;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.020 -0400", hash_original_method = "5D417D4C057D78BF0DEF3D949E557B3C", hash_generated_method = "DE86B7ACF673C82DD7545F34B174B1EA")
    public CdmaCall getForegroundCall() {
        CdmaCall varB4EAC82CA7396A68D541C85D26508E83_1607024970 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1607024970 = mCT.foregroundCall;
        varB4EAC82CA7396A68D541C85D26508E83_1607024970.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1607024970;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.020 -0400", hash_original_method = "6287E103949DE4B29FC1760D95391284", hash_generated_method = "234D6E4521D81E5987646E7F3CA2EB2F")
    public void selectNetworkManually(OperatorInfo network,
            Message response) {
        addTaint(network.getTaint());
        addTaint(response.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.020 -0400", hash_original_method = "A54F4B18F21B3A39961648F4BDA2F061", hash_generated_method = "0D9A74204B6FB987A29697E2CA304A25")
    public void setOnPostDialCharacter(Handler h, int what, Object obj) {
        mPostDialHandler = new Registrant(h, what, obj);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.021 -0400", hash_original_method = "3D832E28FC020C3451E1ECD577F7705D", hash_generated_method = "932CA5B6FCD7E6FE5101984DCE2809CA")
    public boolean handlePinMmi(String dialString) {
        CdmaMmiCode mmi = CdmaMmiCode.newFromDialString(dialString, this);
        {
            boolean var1028666450F47101F5E9163275C14E96_428162221 = (mmi.isPukCommand());
            {
                mPendingMmis.add(mmi);
                mMmiRegistrants.notifyRegistrants(new AsyncResult(null, mmi, null));
                mmi.processCode();
            } 
        } 
        addTaint(dialString.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_425052294 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_425052294;
        
        
        
            
            
        
            
            
            
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.021 -0400", hash_original_method = "574EFAE567BAC054324E4789AB0ACA21", hash_generated_method = "C79F5F5BCF38E7300C41532FDC2741B6")
     void onMMIDone(CdmaMmiCode mmi) {
        
        {
            boolean var2994F1DD658E93A134FDDE87066FC8E4_1032384968 = (mPendingMmis.remove(mmi));
            {
                mMmiCompleteRegistrants.notifyRegistrants(new AsyncResult(null, mmi, null));
            } 
        } 
        addTaint(mmi.getTaint());
        
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.021 -0400", hash_original_method = "8885A01E1E8D54116E470B45B5958287", hash_generated_method = "68CC409C8C91BBCEBA82FD1BAD1512E5")
    public void setLine1Number(String alphaTag, String number, Message onComplete) {
        addTaint(alphaTag.getTaint());
        addTaint(number.getTaint());
        addTaint(onComplete.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.021 -0400", hash_original_method = "9F48D83DEE90081423E43167EA0B9F32", hash_generated_method = "25B02E2673BBB3968E9E2B7E83315343")
    public void setCallWaiting(boolean enable, Message onComplete) {
        addTaint(enable);
        addTaint(onComplete.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.022 -0400", hash_original_method = "96CADC2872DB4F7FDEDEDD322815973F", hash_generated_method = "822C445C5B4D9120BF9FC0E8634D50FF")
    public void updateServiceLocation() {
        mSST.enableSingleLocationUpdate();
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.022 -0400", hash_original_method = "910AE5D7D70CC37EC2511A21C3761E3A", hash_generated_method = "833E210D6BAC589C67F646388318201A")
    public void setDataRoamingEnabled(boolean enable) {
        mDataConnectionTracker.setDataOnRoamingEnabled(enable);
        addTaint(enable);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.022 -0400", hash_original_method = "610E8C97A082907006BA954BE534B9EC", hash_generated_method = "5C66AFAF2A635561F285A473F4D6234D")
    public void registerForCdmaOtaStatusChange(Handler h, int what, Object obj) {
        
        mCM.registerForCdmaOtaProvision(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.022 -0400", hash_original_method = "BBA791A1BBD0F6B3058E9616045D8082", hash_generated_method = "44E7B7C84703223EACA634CEDB159B91")
    public void unregisterForCdmaOtaStatusChange(Handler h) {
        mCM.unregisterForCdmaOtaProvision(h);
        addTaint(h.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.023 -0400", hash_original_method = "832A3DCDB2173345E213F4FEE097F4C8", hash_generated_method = "B943F9B1788E248634D26A76F6A3DC53")
    public void registerForSubscriptionInfoReady(Handler h, int what, Object obj) {
        
        mSST.registerForSubscriptionInfoReady(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.023 -0400", hash_original_method = "8678E3A1722432B3AEE20746D6239509", hash_generated_method = "13936C1F120A6D2B31EDD26D36794A8E")
    public void unregisterForSubscriptionInfoReady(Handler h) {
        mSST.unregisterForSubscriptionInfoReady(h);
        addTaint(h.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.023 -0400", hash_original_method = "9CC75D31629A3B23A63ED4AF8AC1CC3C", hash_generated_method = "2AE548BBA18B79FB631489C387E3DABC")
    public void setOnEcbModeExitResponse(Handler h, int what, Object obj) {
        mEcmExitRespRegistrant = new Registrant (h, what, obj);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.023 -0400", hash_original_method = "40447D9C1BA4AF14D98FB8C3ACDE2526", hash_generated_method = "2853CE94543B3513F1C353DD44BE3889")
    public void unsetOnEcbModeExitResponse(Handler h) {
        mEcmExitRespRegistrant.clear();
        addTaint(h.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.024 -0400", hash_original_method = "0F8C6CFDB05E5D9DD9E146C1B344047B", hash_generated_method = "E9152FD47833DCF3AA4B8315856C5289")
    public void registerForCallWaiting(Handler h, int what, Object obj) {
        
        mCT.registerForCallWaiting(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.024 -0400", hash_original_method = "0239428C6B544E5C48B7505010514559", hash_generated_method = "81FFEA55A48F85AAF2E95F140B0F811B")
    public void unregisterForCallWaiting(Handler h) {
        mCT.unregisterForCallWaiting(h);
        addTaint(h.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.025 -0400", hash_original_method = "639F59C576968CC215A4C16BCF60725F", hash_generated_method = "122F104516FD1B31E1AC4255F2D4AD48")
    public void getNeighboringCids(Message response) {
        {
            CommandException ce = new CommandException(
                    CommandException.Error.REQUEST_NOT_SUPPORTED);
            AsyncResult.forMessage(response).exception = ce;
            response.sendToTarget();
        } 
        addTaint(response.getTaint());
        
        
            
                    
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.026 -0400", hash_original_method = "872EFAB028EF9345A6D84A5CBF27D619", hash_generated_method = "9A4A5EB540D6A60F6C9B6A079E829D86")
    public DataState getDataConnectionState(String apnType) {
        DataState varB4EAC82CA7396A68D541C85D26508E83_659304337 = null; 
        DataState ret = DataState.DISCONNECTED;
        {
            ret = DataState.DISCONNECTED;
        } 
        {
            boolean var2B4A8E6DAE4C8B61542DA3830F844B7B_1993803010 = (mSST.getCurrentDataConnectionState() != ServiceState.STATE_IN_SERVICE);
            {
                ret = DataState.DISCONNECTED;
            } 
            {
                boolean varEDC38D72B2381B58A0F3730E74C3817C_2125760674 = (mDataConnectionTracker.isApnTypeEnabled(apnType) == false ||
                mDataConnectionTracker.isApnTypeActive(apnType) == false);
                {
                    ret = DataState.DISCONNECTED;
                } 
                {
                    {
                        Object var819139837D42C0AD62155AA1D23C5AD5_280188957 = (mDataConnectionTracker.getState(apnType));
                        
                        ret = DataState.DISCONNECTED;
                        
                        
                        {
                            boolean var398FF6E0DCA52B02F79A9CB272BA56EC_1634054713 = (mCT.state != Phone.State.IDLE
                            && !mSST.isConcurrentVoiceAndDataAllowed());
                            {
                                ret = DataState.SUSPENDED;
                            } 
                            {
                                ret = DataState.CONNECTED;
                            } 
                        } 
                        
                        
                        ret = DataState.CONNECTING;
                        
                    } 
                } 
            } 
        } 
        log("getDataConnectionState apnType=" + apnType + " ret=" + ret);
        varB4EAC82CA7396A68D541C85D26508E83_659304337 = ret;
        addTaint(apnType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_659304337.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_659304337;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.027 -0400", hash_original_method = "F7E968145C01057A311E794FEA9BAA95", hash_generated_method = "3E54EE4F692E423D458C417C017276DF")
    public void sendUssdResponse(String ussdMessge) {
        addTaint(ussdMessge.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.027 -0400", hash_original_method = "98607162C44D8873925496654D522BF8", hash_generated_method = "2085710F535987BCE23277457C103BE7")
    public void sendDtmf(char c) {
        {
            boolean varD5E376D61876D980336EC59E5D202EEE_2122818010 = (!PhoneNumberUtils.is12Key(c));
            {
                {
                    mCM.sendDtmf(c, null);
                } 
            } 
        } 
        addTaint(c);
        
        
            
                    
        
            
                
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.028 -0400", hash_original_method = "3FBA1333099AE68AF02019D712D23AB2", hash_generated_method = "E7FB2B9072FC94E430007ED0D207F654")
    public void startDtmf(char c) {
        {
            boolean varD5E376D61876D980336EC59E5D202EEE_2046160384 = (!PhoneNumberUtils.is12Key(c));
            {
                mCM.startDtmf(c, null);
            } 
        } 
        addTaint(c);
        
        
            
                    
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.028 -0400", hash_original_method = "3DAC039DE959EF34631E2B825CE1F213", hash_generated_method = "E3ACE99405ED7C4AFBEE2F93E02370EB")
    public void stopDtmf() {
        mCM.stopDtmf(null);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.029 -0400", hash_original_method = "E3E7B97B548DE87ECFE3195659B23FF9", hash_generated_method = "B961DD103E5ED34D4D8814D1E23B7DEF")
    public void sendBurstDtmf(String dtmfString, int on, int off, Message onComplete) {
        boolean check = true;
        {
            int itr = 0;
            boolean varC203A73757365FB141AA417E652E019C_710144174 = (itr < dtmfString.length());
            {
                {
                    boolean var6A7122EA2D2E6A95C8F93E4E1672AD9E_744122500 = (!PhoneNumberUtils.is12Key(dtmfString.charAt(itr)));
                    {
                        check = false;
                    } 
                } 
            } 
        } 
        {
            mCM.sendBurstDtmf(dtmfString, on, off, onComplete);
        } 
        addTaint(dtmfString.getTaint());
        addTaint(on);
        addTaint(off);
        addTaint(onComplete.getTaint());
        
        
        
            
                
                        
                
                
            
        
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.029 -0400", hash_original_method = "FE0764939BCED80E9275F681708ABC99", hash_generated_method = "CE0FD7A774643873975F7B429D4D1C54")
    public void getAvailableNetworks(Message response) {
        addTaint(response.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.030 -0400", hash_original_method = "9C1B6A588127C991585EBB349A2379DB", hash_generated_method = "1476F4AE1E5E06DF49897D4E9E90D55A")
    public void setOutgoingCallerIdDisplay(int commandInterfaceCLIRMode, Message onComplete) {
        addTaint(commandInterfaceCLIRMode);
        addTaint(onComplete.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.030 -0400", hash_original_method = "85721F5820CF0128BD1EA66BA785E274", hash_generated_method = "8061BA0AAC1F798918E946EB98E60D31")
    public void enableLocationUpdates() {
        mSST.enableLocationUpdates();
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.030 -0400", hash_original_method = "E6FECC87DDBB4D4FE984E494757397E3", hash_generated_method = "3FDC902944764AB6B7139C73765CF957")
    public void disableLocationUpdates() {
        mSST.disableLocationUpdates();
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.030 -0400", hash_original_method = "DAED77F9218E0449A772CA04214CC7F0", hash_generated_method = "13BB02467E7237F3DCAA27B785AFC8DE")
    public void getDataCallList(Message response) {
        mCM.getDataCallList(response);
        addTaint(response.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.030 -0400", hash_original_method = "33CDF43696035DC3E16A234222A80D64", hash_generated_method = "18AADAE0524889596F3858855F4592A5")
    public boolean getDataRoamingEnabled() {
        boolean var6ACB2ECE8621241EECE599BD6243F11B_67643234 = (mDataConnectionTracker.getDataOnRoamingEnabled());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_497044148 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_497044148;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.031 -0400", hash_original_method = "63103D1CE9C7888BE66C8CE520564C7E", hash_generated_method = "FB951956CF6FF915B0F35F192179D19D")
    public void setVoiceMailNumber(String alphaTag,
                                   String voiceMailNumber,
                                   Message onComplete) {
        Message resp;
        mVmNumber = voiceMailNumber;
        resp = obtainMessage(EVENT_SET_VM_NUMBER_DONE, 0, 0, onComplete);
        mIccRecords.setVoiceMailNumber(alphaTag, mVmNumber, resp);
        addTaint(alphaTag.getTaint());
        addTaint(onComplete.getTaint());
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.032 -0400", hash_original_method = "EC96491CC2681D27125B6B3540F74113", hash_generated_method = "A1A6C8BA741845B0ADEA8D3A85FA5F97")
    public String getVoiceMailNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_1330019175 = null; 
        String number = null;
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        {
            boolean var8B403152FA0B86F979BAF5F52F130215_641915297 = (getContext().getResources().getBoolean(com.android.internal
                .R.bool.config_telephony_use_own_number_for_voicemail));
            {
                number = sp.getString(VM_NUMBER_CDMA, getLine1Number());
            } 
            {
                number = sp.getString(VM_NUMBER_CDMA, "*86");
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1330019175 = number;
        varB4EAC82CA7396A68D541C85D26508E83_1330019175.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1330019175;
        
        
        
        
                
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.032 -0400", hash_original_method = "5D69EEC40343498AF4F71AD96BF8D875", hash_generated_method = "D53528B58BE502B816DDF29229817B52")
    public int getVoiceMessageCount() {
        int voicemailCount = mIccRecords.getVoiceMessageCount();
        {
            SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
            voicemailCount = sp.getInt(VM_COUNT_CDMA, 0);
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2056803610 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2056803610;
        
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.034 -0400", hash_original_method = "72DF9B0892372ADFAD7DE65056384F5E", hash_generated_method = "2509489637D086CB97A48CDFF582292A")
    public String getVoiceMailAlphaTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_148736281 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1927115086 = null; 
        String ret = "";
        {
            boolean var0709D69E6C2648B4A0C93BD0750A7DE0_1212880776 = (ret == null || ret.length() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_148736281 = mContext.getText(
                com.android.internal.R.string.defaultVoiceMailAlphaTag).toString();
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1927115086 = ret;
        String varA7E53CE21691AB073D9660D615818899_1064174540; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1064174540 = varB4EAC82CA7396A68D541C85D26508E83_148736281;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1064174540 = varB4EAC82CA7396A68D541C85D26508E83_1927115086;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1064174540.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1064174540;
        
        
        
            
                
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.036 -0400", hash_original_method = "E23DBF1DA2409183D56D85932A9D038B", hash_generated_method = "F366042A00F69A3A6DE9BD64B616AC1E")
    public void getCallForwardingOption(int commandInterfaceCFReason, Message onComplete) {
        addTaint(commandInterfaceCFReason);
        addTaint(onComplete.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.038 -0400", hash_original_method = "A636525DAEF6D9A554C143CAF44D5772", hash_generated_method = "C4B2CB6A675CF46FE55128145F8D0E54")
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
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.040 -0400", hash_original_method = "C44463D6A0E6885F3CB7F2F8669CD319", hash_generated_method = "ADBAB1426A71D3D9A56FE5B6102AAD33")
    public void getOutgoingCallerIdDisplay(Message onComplete) {
        addTaint(onComplete.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.040 -0400", hash_original_method = "D57FAF7F6BF0B2A3D2D79072DE461E12", hash_generated_method = "5615D75C7278E20CB25342E511427D3C")
    public boolean getCallForwardingIndicator() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1513961674 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1513961674;
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.041 -0400", hash_original_method = "4D4FE78E3983A39BD949CCB232763B54", hash_generated_method = "64D6052E7E469134BF989A118677B658")
    public void explicitCallTransfer() {
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.042 -0400", hash_original_method = "280CC3981F581DF1B137B098EEA6AAEB", hash_generated_method = "224E7A9D5CEA3A506E13F8DE8F5B7142")
    public String getLine1AlphaTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_1683124751 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1683124751 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1683124751.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1683124751;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.043 -0400", hash_original_method = "812A77A153EDB691C43A0B58CAFAA77A", hash_generated_method = "AB35579F49622E7A241F12B7DDB4EC19")
     void notifyPhoneStateChanged() {
        mNotifier.notifyPhoneState(this);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.043 -0400", hash_original_method = "3EB8461625C29B29FD6CB8E5D60B43F3", hash_generated_method = "D04CBC6D94303085010D6FD72DFDF138")
     void notifyPreciseCallStateChanged() {
        super.notifyPreciseCallStateChangedP();
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.044 -0400", hash_original_method = "73E7BFF04E4E9785E6146409272926BA", hash_generated_method = "A54D16F558EC12982CF56FB0933CD181")
     void notifyServiceStateChanged(ServiceState ss) {
        super.notifyServiceStateChangedP(ss);
        addTaint(ss.getTaint());
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.044 -0400", hash_original_method = "482FE18FBD1949DAF708F2E65940DE8F", hash_generated_method = "0723685B826BB9996EC0449E7B1A8FCF")
     void notifyLocationChanged() {
        mNotifier.notifyCellLocation(this);
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.045 -0400", hash_original_method = "292444BE96E352C8E8312B338E19EF02", hash_generated_method = "9CAE80423F167649B545BC55A8273188")
     void notifyNewRingingConnection(Connection c) {
        super.notifyNewRingingConnectionP(c);
        addTaint(c.getTaint());
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.046 -0400", hash_original_method = "1858091673D3A4B62C058FCC91892C36", hash_generated_method = "0756798023112E23775C5ED34868F8B8")
     void notifyDisconnect(Connection cn) {
        mDisconnectRegistrants.notifyResult(cn);
        addTaint(cn.getTaint());
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.046 -0400", hash_original_method = "4DFA3B176AED92FABCFB596FBC88C127", hash_generated_method = "78FF0EBB369D5E48C88943009DE8A38C")
     void notifyUnknownConnection() {
        mUnknownConnectionRegistrants.notifyResult(this);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.047 -0400", hash_original_method = "393DB826FD1453B6BE0DEA71B818C50D", hash_generated_method = "D86444D466150181333516E9A247DE7A")
    public boolean isInEmergencyCall() {
        boolean varD8A2457FC2EBCE0C63162FEE0C7B8E1B_1513169833 = (mCT.isInEmergencyCall());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1212153680 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1212153680;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.048 -0400", hash_original_method = "B4B2A6F2428B54DDD4A7791B2905A02A", hash_generated_method = "36CBF34C0991E901B5A36EBE982248DC")
    public boolean isInEcm() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1557256671 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1557256671;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.048 -0400", hash_original_method = "00543A79BC25C997F29F0DAD4E28E830", hash_generated_method = "7CE6F5517B8FC79E1089086F9F4C05A9")
     void sendEmergencyCallbackModeChange() {
        Intent intent = new Intent(TelephonyIntents.ACTION_EMERGENCY_CALLBACK_MODE_CHANGED);
        intent.putExtra(PHONE_IN_ECM_STATE, mIsPhoneInEcmState);
        ActivityManagerNative.broadcastStickyIntent(intent,null);
        Log.d(LOG_TAG, "sendEmergencyCallbackModeChange");
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.049 -0400", hash_original_method = "B67535D9EC35CAA35F8134AB61AC3782", hash_generated_method = "EED7ADDCE6B16FE232D8725BD08731F3")
    @Override
    public void exitEmergencyCallbackMode() {
        {
            boolean varC8E4FB4CC0E8CC6621CB9ECC0FDC7EC6_724107303 = (mWakeLock.isHeld());
            {
                mWakeLock.release();
            } 
        } 
        mCM.exitEmergencyCallbackMode(obtainMessage(EVENT_EXIT_EMERGENCY_CALLBACK_RESPONSE));
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.049 -0400", hash_original_method = "379601A1C426F495327BF8B224FF5B5D", hash_generated_method = "51D844B8F456FE2C97A4E98121FEE8C1")
    private void handleEnterEmergencyCallbackMode(Message msg) {
        {
            Log.d(LOG_TAG, "handleEnterEmergencyCallbackMode,mIsPhoneInEcmState= "
                    + mIsPhoneInEcmState);
        } 
        {
            mIsPhoneInEcmState = true;
            sendEmergencyCallbackModeChange();
            setSystemProperty(TelephonyProperties.PROPERTY_INECM_MODE, "true");
            long delayInMillis = SystemProperties.getLong(
                    TelephonyProperties.PROPERTY_ECM_EXIT_TIMER, DEFAULT_ECM_EXIT_TIMER_VALUE);
            postDelayed(mExitEcmRunnable, delayInMillis);
            mWakeLock.acquire();
        } 
        addTaint(msg.getTaint());
        
        
            
                    
        
        
            
            
            
            
                    
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.050 -0400", hash_original_method = "DE92BF7F05810FB5E0BD1EEEAFEB4B90", hash_generated_method = "A515BD3E4E427975ECE742AEA4B35D58")
    private void handleExitEmergencyCallbackMode(Message msg) {
        AsyncResult ar = (AsyncResult)msg.obj;
        {
            Log.d(LOG_TAG, "handleExitEmergencyCallbackMode,ar.exception , mIsPhoneInEcmState "
                    + ar.exception + mIsPhoneInEcmState);
        } 
        removeCallbacks(mExitEcmRunnable);
        {
            mEcmExitRespRegistrant.notifyRegistrant(ar);
        } 
        {
            {
                mIsPhoneInEcmState = false;
                setSystemProperty(TelephonyProperties.PROPERTY_INECM_MODE, "false");
            } 
            sendEmergencyCallbackModeChange();
            mDataConnectionTracker.setInternalDataEnabled(true);
        } 
        addTaint(msg.getTaint());
        
        
        
            
                    
        
        
        
            
        
        
            
                
                
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.050 -0400", hash_original_method = "C8EF6B60BE95B81385F7554432463CF1", hash_generated_method = "6DE650C1108F81E57E43EDB5157C6F7D")
     void handleTimerInEmergencyCallbackMode(int action) {
        
        removeCallbacks(mExitEcmRunnable);
        
        
        mEcmTimerResetRegistrants.notifyResult(Boolean.TRUE);
        
        
        long delayInMillis = SystemProperties.getLong(
                    TelephonyProperties.PROPERTY_ECM_EXIT_TIMER, DEFAULT_ECM_EXIT_TIMER_VALUE);
        
        
        postDelayed(mExitEcmRunnable, delayInMillis);
        
        
        mEcmTimerResetRegistrants.notifyResult(Boolean.FALSE);
        
        addTaint(action);
        
        
        
            
            
            
        
            
                    
            
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.051 -0400", hash_original_method = "BEFF27391F370909F03A02FD6CE5C8E1", hash_generated_method = "802A8F092CF8BEF4917442D4D9031D0A")
    public void registerForEcmTimerReset(Handler h, int what, Object obj) {
        
        mEcmTimerResetRegistrants.addUnique(h, what, obj);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.051 -0400", hash_original_method = "2652F35782787E1271AD631A33A0033B", hash_generated_method = "94498A7539C5CF9A67AD26014202949A")
    public void unregisterForEcmTimerReset(Handler h) {
        mEcmTimerResetRegistrants.remove(h);
        addTaint(h.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.052 -0400", hash_original_method = "69FA59CB460FF0A097B9F7F6B4D5A187", hash_generated_method = "04A1BDE1A846464C09CBCB32EC9B6284")
    @Override
    public void handleMessage(Message msg) {
        AsyncResult ar;
        Message onComplete;
        
        {
            mCM.getBasebandVersion(obtainMessage(EVENT_GET_BASEBAND_VERSION_DONE));
            mCM.getDeviceIdentity(obtainMessage(EVENT_GET_DEVICE_IDENTITY_DONE));
        } 
        
        
        {
            ar = (AsyncResult)msg.obj;
            Log.d(LOG_TAG, "Baseband version: " + ar.result);
            setSystemProperty(TelephonyProperties.PROPERTY_BASEBAND_VERSION, (String)ar.result);
        } 
        
        
        {
            ar = (AsyncResult)msg.obj;
            String[] respId = (String[])ar.result;
            mImei = respId[0];
            mImeiSv = respId[1];
            mEsn  =  respId[2];
            mMeid =  respId[3];
        } 
        
        
        {
            handleEnterEmergencyCallbackMode(msg);
        } 
        
        
        {
            handleExitEmergencyCallbackMode(msg);
        } 
        
        
        {
            Log.d(LOG_TAG, "Event EVENT_RUIM_RECORDS_LOADED Received");
            updateCurrentCarrierInProvider();
        } 
        
        
        {
            Log.d(LOG_TAG, "Event EVENT_RADIO_OFF_OR_NOT_AVAILABLE Received");
        } 
        
        
        {
            Log.d(LOG_TAG, "Event EVENT_RADIO_ON Received");
        } 
        
        
        {
            Log.d(LOG_TAG, "Event EVENT_SSN Received");
        } 
        
        
        {
            Log.d(LOG_TAG, "Event EVENT_REGISTERED_TO_NETWORK Received");
        } 
        
        
        {
            Log.d(LOG_TAG, "Event EVENT_NV_READY Received");
            mNvLoadedRegistrants.notifyRegistrants();
            prepareEri();
        } 
        
        
        {
            ar = (AsyncResult)msg.obj;
            {
                boolean varBCC2AAC262927329DC1DDFC23398E7CA_980866731 = (IccException.class.isInstance(ar.exception));
                {
                    storeVoiceMailNumber(mVmNumber);
                    ar.exception = null;
                } 
            } 
            onComplete = (Message) ar.userObj;
            {
                AsyncResult.forMessage(onComplete, ar.result, ar.exception);
                onComplete.sendToTarget();
            } 
        } 
        
        
        {
            super.handleMessage(msg);
        } 
        
        addTaint(msg.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.053 -0400", hash_original_method = "4BF16EE42BDE3709043B0CD4BA1346D5", hash_generated_method = "267CA4BBDFA1B84480561FEE7BAA1ECB")
    public PhoneSubInfo getPhoneSubInfo() {
        PhoneSubInfo varB4EAC82CA7396A68D541C85D26508E83_452397847 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_452397847 = mSubInfo;
        varB4EAC82CA7396A68D541C85D26508E83_452397847.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_452397847;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.054 -0400", hash_original_method = "A5B3830D3022369CFD45112AC4A19D05", hash_generated_method = "0A72CB2E6197079D4C99739441805E94")
    public IccSmsInterfaceManager getIccSmsInterfaceManager() {
        IccSmsInterfaceManager varB4EAC82CA7396A68D541C85D26508E83_556907683 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_556907683 = mRuimSmsInterfaceManager;
        varB4EAC82CA7396A68D541C85D26508E83_556907683.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_556907683;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.055 -0400", hash_original_method = "F4C16F1EDC7887AFA610A21C85E2FBBC", hash_generated_method = "0262E094BA7789D6DA84D8A0376D8215")
    public IccPhoneBookInterfaceManager getIccPhoneBookInterfaceManager() {
        IccPhoneBookInterfaceManager varB4EAC82CA7396A68D541C85D26508E83_1859327422 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1859327422 = mRuimPhoneBookInterfaceManager;
        varB4EAC82CA7396A68D541C85D26508E83_1859327422.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1859327422;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.056 -0400", hash_original_method = "631C425442894A51F9E1215F7444839C", hash_generated_method = "985AF6D95CE5AAF03AE033CB1C39F3B9")
    public void registerForNvLoaded(Handler h, int what, Object obj) {
        
        Registrant r = new Registrant (h, what, obj);
        mNvLoadedRegistrants.add(r);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.056 -0400", hash_original_method = "FC47AF6104E2994A09ED5540AEE820A5", hash_generated_method = "1BAF190EE3D5D043167914001634FD8C")
    public void unregisterForNvLoaded(Handler h) {
        mNvLoadedRegistrants.remove(h);
        addTaint(h.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.057 -0400", hash_original_method = "76D872D60E8DF5A817173A7970E48DAF", hash_generated_method = "CFAA09AB91A822BE594A3FC3F9ED2BA0")
    public void registerForEriFileLoaded(Handler h, int what, Object obj) {
        
        Registrant r = new Registrant (h, what, obj);
        mEriFileLoadedRegistrants.add(r);
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.057 -0400", hash_original_method = "609ACFE0DF3AD88014ED023EE4CC2BBF", hash_generated_method = "9D3DB37E087DCED5F348DC4C1E35429E")
    public void unregisterForEriFileLoaded(Handler h) {
        mEriFileLoadedRegistrants.remove(h);
        addTaint(h.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.058 -0400", hash_original_method = "C4157CB043EC8B3384F8270EB7DCD5BB", hash_generated_method = "159F2D28E3AC8B75EED9336F04B42E2B")
    public final void setSystemProperty(String property, String value) {
        super.setSystemProperty(property, value);
        addTaint(property.getTaint());
        addTaint(value.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.059 -0400", hash_original_method = "515987807F65054AFA6AA9A268DDB599", hash_generated_method = "2BE774D668194C3B5B9E7123D9E9B6B9")
    public IccFileHandler getIccFileHandler() {
        IccFileHandler varB4EAC82CA7396A68D541C85D26508E83_1394709311 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1394709311 = this.mIccFileHandler;
        varB4EAC82CA7396A68D541C85D26508E83_1394709311.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1394709311;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.060 -0400", hash_original_method = "793C414C17B853DD540D3B3DFD8290DE", hash_generated_method = "3A6B4BB2D15E44636A5D86BA61E9E72E")
    public void activateCellBroadcastSms(int activate, Message response) {
        response.sendToTarget();
        addTaint(activate);
        addTaint(response.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.060 -0400", hash_original_method = "81E322CF525B990EC666DA306E1980A6", hash_generated_method = "2DC8511B8DEAA625E54F0B3CA6D0FC70")
    public void getCellBroadcastSmsConfig(Message response) {
        response.sendToTarget();
        addTaint(response.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.061 -0400", hash_original_method = "718A796BA1FEFA7B8760E97D0CFF0F71", hash_generated_method = "C3142A16265BA5B9C66F462373D7D902")
    public void setCellBroadcastSmsConfig(int[] configValuesArray, Message response) {
        response.sendToTarget();
        addTaint(configValuesArray[0]);
        addTaint(response.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.062 -0400", hash_original_method = "C10911F486938B4F93DC849B5E1085A3", hash_generated_method = "7605A87B685A75D1F14156ABD3C086B6")
    @Override
    public boolean needsOtaServiceProvisioning() {
        boolean var3814F4E6C3697558290520EC0B4891A9_1133673129 = (mSST.getOtasp() != ServiceStateTracker.OTASP_NOT_NEEDED);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1281855411 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1281855411;
        
        
    }

    
        @DSModeled(DSC.SPEC)
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

    
        @DSModeled(DSC.SAFE)
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

    
        @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.067 -0400", hash_original_method = "2F4529BDEA4C79E5E2F449E50272F3AC", hash_generated_method = "3835728AA20C7FC64E48BA851C096F45")
    private boolean isCarrierOtaSpNum(String dialStr) {
        boolean isOtaSpNum = false;
        int sysSelCodeInt = extractSelCodeFromOtaSpNum(dialStr);
        {
            boolean varC25E28587E797B4B1D25D8A223D7987E_837183683 = (!TextUtils.isEmpty(mCarrierOtaSpNumSchema));
            {
                Matcher m = pOtaSpNumSchema.matcher(mCarrierOtaSpNumSchema);
                {
                    Log.d(LOG_TAG, "isCarrierOtaSpNum,schema" + mCarrierOtaSpNumSchema);
                } 
                {
                    boolean var39BD3106C7A2329BC5A3364836FB2CF9_1365292610 = (m.find());
                    {
                        String sch[] = pOtaSpNumSchema.split(mCarrierOtaSpNumSchema);
                        {
                            boolean varB2BFE86D7B99BED62C3AF16905511122_1089995842 = (!TextUtils.isEmpty(sch[0]) && sch[0].equals("SELC"));
                            {
                                {
                                    isOtaSpNum=checkOtaSpNumBasedOnSysSelCode(sysSelCodeInt,sch);
                                } 
                                {
                                    {
                                        Log.d(LOG_TAG, "isCarrierOtaSpNum,sysSelCodeInt is invalid");
                                    } 
                                } 
                            } 
                            {
                                boolean var981C353E34C8504891CF0AE981C84F35_2054857016 = (!TextUtils.isEmpty(sch[0]) && sch[0].equals("FC"));
                                {
                                    int fcLen = Integer.parseInt((String)sch[1]);
                                    String fc = (String)sch[2];
                                    {
                                        boolean varCF1EF44489814B5931C694BEAA6AF449_1334843243 = (dialStr.regionMatches(0,fc,0,fcLen));
                                        {
                                            isOtaSpNum = true;
                                        } 
                                        {
                                            Log.d(LOG_TAG, "isCarrierOtaSpNum,not otasp number");
                                        } 
                                    } 
                                } 
                                {
                                    {
                                        Log.d(LOG_TAG, "isCarrierOtaSpNum,ota schema not supported" + sch[0]);
                                    } 
                                } 
                            } 
                        } 
                    } 
                    {
                        {
                            Log.d(LOG_TAG, "isCarrierOtaSpNum,ota schema pattern not right" +
                          mCarrierOtaSpNumSchema);
                        } 
                    } 
                } 
            } 
            {
                Log.d(LOG_TAG, "isCarrierOtaSpNum,ota schema pattern empty");
            } 
        } 
        addTaint(dialStr.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1041671030 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1041671030;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.069 -0400", hash_original_method = "AE6C103DE6DE549189EC8F2DC89B4935", hash_generated_method = "6508E405923DDE440AE30CA58E8FD146")
    @Override
    public boolean isOtaSpNumber(String dialStr) {
        boolean isOtaSpNum = false;
        String dialableStr = PhoneNumberUtils.extractNetworkPortionAlt(dialStr);
        {
            isOtaSpNum = isIs683OtaSpDialStr(dialableStr);
            {
                isOtaSpNum = isCarrierOtaSpNum(dialableStr);
            } 
        } 
        Log.d(LOG_TAG, "isOtaSpNumber " + isOtaSpNum);
        addTaint(dialStr.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1220416121 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1220416121;
        
        
        
        
            
            
                
            
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.070 -0400", hash_original_method = "CBAF5F4AF9A1C44FBA957D2F8ABDCEC2", hash_generated_method = "589874A16EF9C3B9CFA7DD384A8C2A39")
    @Override
    public int getCdmaEriIconIndex() {
        int var7D21F14EF91E1D5E5A5201CD691F6EC1_526848964 = (getServiceState().getCdmaEriIconIndex());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1397626252 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1397626252;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.071 -0400", hash_original_method = "505B53637594CBFFA64F8CC821649187", hash_generated_method = "076AA993B33C315891DBAFAF5CB19811")
    @Override
    public int getCdmaEriIconMode() {
        int var14A1514753E21C20C1CFD187FB3391BF_9619806 = (getServiceState().getCdmaEriIconMode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2138947267 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2138947267;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.072 -0400", hash_original_method = "FF25B4C2C2FD6DDBAFFF02AC278A249A", hash_generated_method = "EE537427C0EFFA14E9A1EB6C731A72EA")
    @Override
    public String getCdmaEriText() {
        String varB4EAC82CA7396A68D541C85D26508E83_400327353 = null; 
        int roamInd = getServiceState().getCdmaRoamingIndicator();
        int defRoamInd = getServiceState().getCdmaDefaultRoamingIndicator();
        varB4EAC82CA7396A68D541C85D26508E83_400327353 = mEriManager.getCdmaEriText(roamInd, defRoamInd);
        varB4EAC82CA7396A68D541C85D26508E83_400327353.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_400327353;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.072 -0400", hash_original_method = "1FA484546C7B73CA49B2C4AE64A8C83E", hash_generated_method = "DB086DDE59CEF7DC31A9874E882586A1")
    private void storeVoiceMailNumber(String number) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(VM_NUMBER_CDMA, number);
        editor.apply();
        addTaint(number.getTaint());
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.072 -0400", hash_original_method = "04903824830A3F9FD2759E9C177CC0CB", hash_generated_method = "396FEBA21CF7815178F30F449E0C7C80")
    private void setIsoCountryProperty(String operatorNumeric) {
        {
            boolean var1C5534FDAA00A1B387A79218D6BAEF6C_254725974 = (TextUtils.isEmpty(operatorNumeric));
            {
                setSystemProperty(PROPERTY_ICC_OPERATOR_ISO_COUNTRY, "");
            } 
            {
                String iso = "";
                try 
                {
                    iso = MccTable.countryCodeForMcc(Integer.parseInt(
                        operatorNumeric.substring(0,3)));
                } 
                catch (NumberFormatException ex)
                { }
                catch (StringIndexOutOfBoundsException ex)
                { }
                setSystemProperty(PROPERTY_ICC_OPERATOR_ISO_COUNTRY, iso);
            } 
        } 
        addTaint(operatorNumeric.getTaint());
        
        
            
        
            
            
                
                        
            
                
            
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.073 -0400", hash_original_method = "B076A318D7F3CB7E259ECDC99FDB3D0D", hash_generated_method = "F64EA7C93E40044E120E02D1FEED002E")
     boolean updateCurrentCarrierInProvider(String operatorNumeric) {
        {
            boolean var94B3144E977DE08BBD4DC30162F60334_1823093158 = (!TextUtils.isEmpty(operatorNumeric));
            {
                try 
                {
                    Uri uri = Uri.withAppendedPath(Telephony.Carriers.CONTENT_URI, "current");
                    ContentValues map = new ContentValues();
                    map.put(Telephony.Carriers.NUMERIC, operatorNumeric);
                    log("updateCurrentCarrierInProvider from system: numeric=" + operatorNumeric);
                    getContext().getContentResolver().insert(uri, map);
                    MccTable.updateMccMncConfiguration(this, operatorNumeric);
                } 
                catch (SQLException e)
                { }
            } 
        } 
        addTaint(operatorNumeric.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_164360953 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_164360953;
        
        
            
                
                
                
                
                
                
                
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.074 -0400", hash_original_method = "A95BEE5F1920F9C579D7A59FC4DBB414", hash_generated_method = "4852DBE4EBDE1D0CC3992D0FA5E5692C")
     boolean updateCurrentCarrierInProvider() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_456799353 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_456799353;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.074 -0400", hash_original_method = "5CB32743CEBF9A8556BB2E144A975CB3", hash_generated_method = "8CCC0C2674C31C7ED20DE6BECB061E15")
    public void prepareEri() {
        mEriManager.loadEriFile();
        {
            boolean var07BA6C1E3CEBF9422B7FD30B01BA2995_796149639 = (mEriManager.isEriFileLoaded());
            {
                log("ERI read, notify registrants");
                mEriFileLoadedRegistrants.notifyRegistrants();
            } 
        } 
        
        
        
            
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.074 -0400", hash_original_method = "71144CF5C8B23350BF31931D81A1C3AC", hash_generated_method = "BC2EC568763C8D2A12FC51C9186D6E1D")
    public boolean isEriFileLoaded() {
        boolean varAA8EBCEDF474BF00A450A0F8740F0DD7_1014036924 = (mEriManager.isEriFileLoaded());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_76465733 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_76465733;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.075 -0400", hash_original_method = "CBB2DC533610D724567F0136955B7014", hash_generated_method = "02E1A2D63A196E8B73A1855751D4CA7E")
    protected void log(String s) {
        Log.d(LOG_TAG, "[CDMAPhone] " + s);
        addTaint(s.getTaint());
        
        
            
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.075 -0400", hash_original_field = "951C150E6D062E6AED2C45BB9B756185", hash_generated_field = "37C2AB96DD7CCDC96FF809DAC1A6D712")

    static final String LOG_TAG = "CDMA";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.075 -0400", hash_original_field = "A4622F7F72162611C8E075EE443BC26E", hash_generated_field = "B7707D757F0604821CCAF673B2122320")

    private static final boolean DBG = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.075 -0400", hash_original_field = "5320633AA3BFE71644D90157C1CD824C", hash_generated_field = "E6DA1D723C3EE1AB56712584EA58C137")

    private static final int DEFAULT_ECM_EXIT_TIMER_VALUE = 300000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.075 -0400", hash_original_field = "3EDCC9CC37CA195649B1285985E473C3", hash_generated_field = "DBE7E6AE93BA06B2FF1DBE92EBF7667B")

    static final String VM_COUNT_CDMA = "vm_count_key_cdma";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.075 -0400", hash_original_field = "668CB3B3609C678099375254C8D95AA7", hash_generated_field = "C50FD41AD9C8ECFDE260B639E8718D3D")

    private static final String VM_NUMBER_CDMA = "vm_number_key_cdma";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.075 -0400", hash_original_field = "EC49609D403603D3B7721BA3617C00E8", hash_generated_field = "7149CAB7A993D6EFECE4128061F9865F")

    static final int RESTART_ECM_TIMER = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.075 -0400", hash_original_field = "2985483F14B41C74EABD7BCA0321F3DF", hash_generated_field = "0BF8B228276AC1D84F7C2766F8B74E6C")

    static final int CANCEL_ECM_TIMER = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.075 -0400", hash_original_field = "843F0250B369902370F83939F540B081", hash_generated_field = "1B6AA95D9706EED43D662EF600D64CB5")

    static String PROPERTY_CDMA_HOME_OPERATOR_NUMERIC = "ro.cdma.home.operator.numeric";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.075 -0400", hash_original_field = "3BA08B3453AFD8EBCFB22E951AED80DF", hash_generated_field = "8D504081DB72AA9930792378E569BE2E")

    private static final String IS683A_FEATURE_CODE = "*228";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.075 -0400", hash_original_field = "9DBDB8BAEDF244A1BD45FE7B339131C9", hash_generated_field = "6B01468F83B67C83DBE6AEB2D62A09FF")

    private static final int IS683A_FEATURE_CODE_NUM_DIGITS = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.075 -0400", hash_original_field = "11A59DFDA1E768721414AA1C69B63C9E", hash_generated_field = "DA2F29DBADB6D87260FE5B4BED8B1598")

    private static final int IS683A_SYS_SEL_CODE_NUM_DIGITS = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.075 -0400", hash_original_field = "C25262C71335F27E381F2311FF881E33", hash_generated_field = "E358300F1015F9A17C96E8811D0A4AD9")

    private static final int IS683A_SYS_SEL_CODE_OFFSET = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.075 -0400", hash_original_field = "8C6441FCC50B0830A2410221AE8A4925", hash_generated_field = "98531D0FD7604827F4C9BCEA781B49A3")

    private static final int IS683_CONST_800MHZ_A_BAND = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.075 -0400", hash_original_field = "B34BEF5E9252F376624F20F747B810F8", hash_generated_field = "0C7295C5D8889FCCE0C85B637D40E60C")

    private static final int IS683_CONST_800MHZ_B_BAND = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.075 -0400", hash_original_field = "DF632DFB5EF94CD03C3D2D9E67F0C0E8", hash_generated_field = "489A1CED9728DCA2C0C1D3DFC6A97DA7")

    private static final int IS683_CONST_1900MHZ_A_BLOCK = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.075 -0400", hash_original_field = "6977A7F81CF8832CE0006DC6B400488F", hash_generated_field = "CCF6ADEAC5D925D88FECCAAF8BA9CB9A")

    private static final int IS683_CONST_1900MHZ_B_BLOCK = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.075 -0400", hash_original_field = "5E9B40F193BFBBDABC03738CDD356C56", hash_generated_field = "4A09DC42BBD46B04747F40997180D304")

    private static final int IS683_CONST_1900MHZ_C_BLOCK = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.075 -0400", hash_original_field = "812E250D039979870F8BF7827DD6942E", hash_generated_field = "A402BF3C8CF075F873509D0D2B17E022")

    private static final int IS683_CONST_1900MHZ_D_BLOCK = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.075 -0400", hash_original_field = "6900F8029CB6DAC6B0B3C8BC7FA5584A", hash_generated_field = "360201E7861089684816302DB16F5849")

    private static final int IS683_CONST_1900MHZ_E_BLOCK = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.075 -0400", hash_original_field = "59BD6B30FEF1B370EA610752E954CE82", hash_generated_field = "D6596E49D61F4540FAE2D5DA6864F28B")

    private static final int IS683_CONST_1900MHZ_F_BLOCK = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.075 -0400", hash_original_field = "B5DE06BE2A525381D4B4AD5CFA1561B2", hash_generated_field = "0DE336CC04DA9F72A5B4A85D6CE8519B")

    private static final int INVALID_SYSTEM_SELECTION_CODE = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.075 -0400", hash_original_field = "7B0F019D05983EE374EEDBA360DA6CD2", hash_generated_field = "A75E56C661E3C1889447602EFA0983FC")

    private static Pattern pOtaSpNumSchema = Pattern.compile("[,\\s]+");
}

