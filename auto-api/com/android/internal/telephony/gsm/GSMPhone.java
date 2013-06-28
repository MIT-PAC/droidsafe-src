package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.SQLException;
import android.net.Uri;
import android.os.AsyncResult;
import android.os.Handler;
import android.os.Message;
import android.os.Registrant;
import android.os.RegistrantList;
import android.os.SystemProperties;
import android.preference.PreferenceManager;
import android.provider.Telephony;
import android.telephony.CellLocation;
import android.telephony.PhoneNumberUtils;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import com.android.internal.telephony.CallTracker;
import android.text.TextUtils;
import android.util.Log;
import static com.android.internal.telephony.CommandsInterface.CF_ACTION_DISABLE;
import static com.android.internal.telephony.CommandsInterface.CF_ACTION_ENABLE;
import static com.android.internal.telephony.CommandsInterface.CF_ACTION_ERASURE;
import static com.android.internal.telephony.CommandsInterface.CF_ACTION_REGISTRATION;
import static com.android.internal.telephony.CommandsInterface.CF_REASON_ALL;
import static com.android.internal.telephony.CommandsInterface.CF_REASON_ALL_CONDITIONAL;
import static com.android.internal.telephony.CommandsInterface.CF_REASON_NO_REPLY;
import static com.android.internal.telephony.CommandsInterface.CF_REASON_NOT_REACHABLE;
import static com.android.internal.telephony.CommandsInterface.CF_REASON_BUSY;
import static com.android.internal.telephony.CommandsInterface.CF_REASON_UNCONDITIONAL;
import static com.android.internal.telephony.CommandsInterface.SERVICE_CLASS_VOICE;
import static com.android.internal.telephony.TelephonyProperties.PROPERTY_BASEBAND_VERSION;
import com.android.internal.telephony.cat.CatService;
import com.android.internal.telephony.Call;
import com.android.internal.telephony.CallForwardInfo;
import com.android.internal.telephony.CallStateException;
import com.android.internal.telephony.CommandsInterface;
import com.android.internal.telephony.Connection;
import com.android.internal.telephony.IccFileHandler;
import com.android.internal.telephony.IccPhoneBookInterfaceManager;
import com.android.internal.telephony.IccSmsInterfaceManager;
import com.android.internal.telephony.MmiCode;
import com.android.internal.telephony.OperatorInfo;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.PhoneBase;
import com.android.internal.telephony.PhoneNotifier;
import com.android.internal.telephony.PhoneProxy;
import com.android.internal.telephony.PhoneSubInfo;
import com.android.internal.telephony.TelephonyProperties;
import com.android.internal.telephony.UUSInfo;
import com.android.internal.telephony.test.SimulatedRadioControl;
import com.android.internal.telephony.IccVmNotSupportedException;
import com.android.internal.telephony.ServiceStateTracker;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class GSMPhone extends PhoneBase {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.014 -0400", hash_original_field = "1D14D2D55BC367CD6AE3740CDB7152AF", hash_generated_field = "7E950EFC4355B7AA0B0D4941C05A3E53")

    GsmCallTracker mCT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.014 -0400", hash_original_field = "72BFF8190B34BEEE16406717B341412A", hash_generated_field = "AE636E648E782E05B0819C59ED7424AB")

    GsmServiceStateTracker mSST;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.014 -0400", hash_original_field = "F908D4D8A62B20E1013F1B849891738F", hash_generated_field = "CBD9585363E06B1CD5BA731CBD0F7A80")

    CatService mStkService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.014 -0400", hash_original_field = "00ADA57B43BDE5C478787B959A96A0CB", hash_generated_field = "16CBC86166E203C30D8494A6E3AFFFBC")

    ArrayList <GsmMmiCode> mPendingMMIs = new ArrayList<GsmMmiCode>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.014 -0400", hash_original_field = "212535A59AA4026EB1840135D5A6A54C", hash_generated_field = "BBEE3B2E599EE94DA4981B9B890C1513")

    SimPhoneBookInterfaceManager mSimPhoneBookIntManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.014 -0400", hash_original_field = "D5309C419B424DD63B187C852A2C29B9", hash_generated_field = "3969837BA2D4BBD6356E9579AAD42F25")

    SimSmsInterfaceManager mSimSmsIntManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.014 -0400", hash_original_field = "2C01F66E136181E8D582317306CCAC30", hash_generated_field = "F066FAD7B5AEEA27E2872ED159BF1CA4")

    PhoneSubInfo mSubInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.014 -0400", hash_original_field = "B70FAC06870FA211D668F462A2DBA212", hash_generated_field = "126D29D3ACD6141B3CF1C156D9BC8C27")

    Registrant mPostDialHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.014 -0400", hash_original_field = "F3323DA9DC0741EA4D28240971AFB640", hash_generated_field = "53A51CC9ADC1518A34F3208AF5D19A18")

    RegistrantList mSsnRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.014 -0400", hash_original_field = "DD2963357D2DA6A58CA505E758F62F10", hash_generated_field = "74116952885B195B8407FD19FB3B03C8")

    Thread debugPortThread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.014 -0400", hash_original_field = "0AF201A4B355A633BEDC98F2C2779D46", hash_generated_field = "B2950783CBB152418ABB498147763A3B")

    ServerSocket debugSocket;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.014 -0400", hash_original_field = "453C2995A2CC7C51188981A0F3965EED", hash_generated_field = "21C761E6867BA70678F0E7ADB70A1FBD")

    private String mImei;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.014 -0400", hash_original_field = "225448F5B7EE27E6F9CC21B80A6466DB", hash_generated_field = "B9E6756233427283AB4830B86393B4EE")

    private String mImeiSv;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.014 -0400", hash_original_field = "9B277DEC9B14E7B002627F05BEB0402A", hash_generated_field = "C290BF4C64FB14015B233D46098DB0A5")

    private String mVmNumber;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.014 -0400", hash_original_method = "996B91F3E8316CE3D841721FC6425644", hash_generated_method = "63B323EEC1874ED8DC5201890D3F8220")
    public  GSMPhone(Context context, CommandsInterface ci, PhoneNotifier notifier) {
        this(context,ci,notifier, false);
        addTaint(context.getTaint());
        addTaint(ci.getTaint());
        addTaint(notifier.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.016 -0400", hash_original_method = "E0F14E16A0D8C4916EDEAC018BF6C407", hash_generated_method = "D2C2CF1E93D8982B60AB2801D49FCE65")
    public  GSMPhone(Context context, CommandsInterface ci, PhoneNotifier notifier, boolean unitTestMode) {
        super(notifier, context, ci, unitTestMode);
        {
            mSimulatedRadioControl = (SimulatedRadioControl) ci;
        } //End block
        mCM.setPhoneType(Phone.PHONE_TYPE_GSM);
        mCT = new GsmCallTracker(this);
        mSST = new GsmServiceStateTracker (this);
        mSMS = new GsmSMSDispatcher(this, mSmsStorageMonitor, mSmsUsageMonitor);
        mIccFileHandler = new SIMFileHandler(this);
        mIccRecords = new SIMRecords(this);
        mDataConnectionTracker = new GsmDataConnectionTracker (this);
        mIccCard = new SimCard(this);
        {
            mSimPhoneBookIntManager = new SimPhoneBookInterfaceManager(this);
            mSimSmsIntManager = new SimSmsInterfaceManager(this, mSMS);
            mSubInfo = new PhoneSubInfo(this);
        } //End block
        mStkService = CatService.getInstance(mCM, mIccRecords, mContext, mIccFileHandler, mIccCard);
        mCM.registerForAvailable(this, EVENT_RADIO_AVAILABLE, null);
        mIccRecords.registerForRecordsLoaded(this, EVENT_SIM_RECORDS_LOADED, null);
        mCM.registerForOffOrNotAvailable(this, EVENT_RADIO_OFF_OR_NOT_AVAILABLE, null);
        mCM.registerForOn(this, EVENT_RADIO_ON, null);
        mCM.setOnUSSD(this, EVENT_USSD, null);
        mCM.setOnSuppServiceNotification(this, EVENT_SSN, null);
        mSST.registerForNetworkAttached(this, EVENT_REGISTERED_TO_NETWORK, null);
        {
            try 
            {
                debugSocket = new ServerSocket();
                debugSocket.setReuseAddress(true);
                debugSocket.bind (new InetSocketAddress("127.0.0.1", 6666));
                debugPortThread
                    = new Thread(
                        new Runnable() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.016 -0400", hash_original_method = "4E77C2C2171044E4A2A86AC9695E0AD3", hash_generated_method = "344719F817D0045DB5D27299E79C4A7B")
                    public void run() {
                        {
                            try 
                            {
                                Socket sock;
                                sock = debugSocket.accept();
                                mCM.resetRadio(null);
                                sock.close();
                            } //End block
                            catch (IOException ex)
                            { }
                        } //End block
                        // ---------- Original Method ----------
                        //for(;;) {
                                    //try {
                                        //Socket sock;
                                        //sock = debugSocket.accept();
                                        //Log.i(LOG_TAG, "New connection; resetting radio");
                                        //mCM.resetRadio(null);
                                        //sock.close();
                                    //} catch (IOException ex) {
                                        //Log.w(LOG_TAG,
                                            //"Exception accepting socket", ex);
                                    //}
                                //}
                    }
},
                        "GSMPhone debug");
                debugPortThread.start();
            } //End block
            catch (IOException ex)
            { }
        } //End block
        SystemProperties.set(TelephonyProperties.CURRENT_ACTIVE_PHONE,
                new Integer(Phone.PHONE_TYPE_GSM).toString());
        addTaint(context.getTaint());
        addTaint(ci.getTaint());
        addTaint(notifier.getTaint());
        addTaint(unitTestMode);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.017 -0400", hash_original_method = "CEF48F17C6DF6ACB05893EA0A2EE33F8", hash_generated_method = "B71D38D11653193226E3F8E6531ACE0E")
    @Override
    public void dispose() {
        {
            super.dispose();
            mCM.unregisterForAvailable(this);
            mIccRecords.unregisterForRecordsLoaded(this);
            mCM.unregisterForOffOrNotAvailable(this);
            mCM.unregisterForOn(this);
            mSST.unregisterForNetworkAttached(this);
            mCM.unSetOnUSSD(this);
            mCM.unSetOnSuppServiceNotification(this);
            mPendingMMIs.clear();
            mStkService.dispose();
            mCT.dispose();
            mDataConnectionTracker.dispose();
            mSST.dispose();
            mIccFileHandler.dispose();
            mIccRecords.dispose();
            mIccCard.dispose();
            mSimPhoneBookIntManager.dispose();
            mSimSmsIntManager.dispose();
            mSubInfo.dispose();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.018 -0400", hash_original_method = "F5F23F3B17FF3156952338384B3C94C7", hash_generated_method = "C0585341C604244A83CFF366F7C62C3E")
    @Override
    public void removeReferences() {
        Log.d(LOG_TAG, "removeReferences");
        super.removeReferences();
        mSimulatedRadioControl = null;
        mStkService = null;
        mSimPhoneBookIntManager = null;
        mSimSmsIntManager = null;
        mSMS = null;
        mSubInfo = null;
        mIccRecords = null;
        mIccFileHandler = null;
        mIccCard = null;
        mDataConnectionTracker = null;
        mCT = null;
        mSST = null;
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "removeReferences");
        //super.removeReferences();
        //mSimulatedRadioControl = null;
        //mStkService = null;
        //mSimPhoneBookIntManager = null;
        //mSimSmsIntManager = null;
        //mSMS = null;
        //mSubInfo = null;
        //mIccRecords = null;
        //mIccFileHandler = null;
        //mIccCard = null;
        //mDataConnectionTracker = null;
        //mCT = null;
        //mSST = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.018 -0400", hash_original_method = "B0A9A9B5818DC886F2534146C8893E7F", hash_generated_method = "346B68F817EC52430AB8DB08BE054D6D")
    protected void finalize() {
        Log.d(LOG_TAG, "GSMPhone finalized");
        // ---------- Original Method ----------
        //if(LOCAL_DEBUG) Log.d(LOG_TAG, "GSMPhone finalized");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.019 -0400", hash_original_method = "DA0F221C2247572C4D631280E4033E9A", hash_generated_method = "FF35A28D87656F3C3DDFA2280596636A")
    public ServiceState getServiceState() {
        ServiceState varB4EAC82CA7396A68D541C85D26508E83_1140951574 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1140951574 = mSST.ss;
        varB4EAC82CA7396A68D541C85D26508E83_1140951574.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1140951574;
        // ---------- Original Method ----------
        //return mSST.ss;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.019 -0400", hash_original_method = "E38329BE2FF507326358BBAF596945E6", hash_generated_method = "9BE152FDA7B99BC983A14464C24E1A98")
    public CellLocation getCellLocation() {
        CellLocation varB4EAC82CA7396A68D541C85D26508E83_1000487642 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1000487642 = mSST.cellLoc;
        varB4EAC82CA7396A68D541C85D26508E83_1000487642.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1000487642;
        // ---------- Original Method ----------
        //return mSST.cellLoc;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.020 -0400", hash_original_method = "8AEFB373111A9C8AD30F3E8C75C461D2", hash_generated_method = "587EFF8D27A1A23549841813837BDF9C")
    public Phone.State getState() {
        Phone.State varB4EAC82CA7396A68D541C85D26508E83_231437897 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_231437897 = mCT.state;
        varB4EAC82CA7396A68D541C85D26508E83_231437897.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_231437897;
        // ---------- Original Method ----------
        //return mCT.state;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.020 -0400", hash_original_method = "59C2B6A3B95086A76D74A4AD572CD9E8", hash_generated_method = "2E2FB8FE28670A61907ED5A2B5CAFCBA")
    public String getPhoneName() {
        String varB4EAC82CA7396A68D541C85D26508E83_660546943 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_660546943 = "GSM";
        varB4EAC82CA7396A68D541C85D26508E83_660546943.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_660546943;
        // ---------- Original Method ----------
        //return "GSM";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.020 -0400", hash_original_method = "8F0362114FB07F54B581B179D597F815", hash_generated_method = "319C0F9D6365ACA5685ED4969361ACEB")
    public int getPhoneType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_222271758 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_222271758;
        // ---------- Original Method ----------
        //return Phone.PHONE_TYPE_GSM;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.021 -0400", hash_original_method = "46D9BC6E3280014832CD8FC523C20E6E", hash_generated_method = "AA32894F2428928B016762311CC07308")
    public SignalStrength getSignalStrength() {
        SignalStrength varB4EAC82CA7396A68D541C85D26508E83_1088859214 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1088859214 = mSST.mSignalStrength;
        varB4EAC82CA7396A68D541C85D26508E83_1088859214.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1088859214;
        // ---------- Original Method ----------
        //return mSST.mSignalStrength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.021 -0400", hash_original_method = "79AFD9B845E4547B981131DAC9E3A14D", hash_generated_method = "B6D1D59B00EDE0CBB3F6DB494A0DEFCF")
    public CallTracker getCallTracker() {
        CallTracker varB4EAC82CA7396A68D541C85D26508E83_1149875498 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1149875498 = mCT;
        varB4EAC82CA7396A68D541C85D26508E83_1149875498.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1149875498;
        // ---------- Original Method ----------
        //return mCT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.021 -0400", hash_original_method = "BD481539215D5A66E62B4E6909625141", hash_generated_method = "7104E1C70F8FC161FC7510C68F7FBBD8")
    public ServiceStateTracker getServiceStateTracker() {
        ServiceStateTracker varB4EAC82CA7396A68D541C85D26508E83_1616340693 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1616340693 = mSST;
        varB4EAC82CA7396A68D541C85D26508E83_1616340693.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1616340693;
        // ---------- Original Method ----------
        //return mSST;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.022 -0400", hash_original_method = "077104DE86BE536BE2C981492E640B74", hash_generated_method = "E6B1ACF7C95305AA9E6ABE159862237C")
    public List<? extends MmiCode> getPendingMmiCodes() {
        List<? extends MmiCode> varB4EAC82CA7396A68D541C85D26508E83_1487439138 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1487439138 = mPendingMMIs;
        varB4EAC82CA7396A68D541C85D26508E83_1487439138.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1487439138;
        // ---------- Original Method ----------
        //return mPendingMMIs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.023 -0400", hash_original_method = "7454904C7C93C1818F679756511639F1", hash_generated_method = "CA3BF4A84C4A42FEC175FA5713B161F6")
    public DataState getDataConnectionState(String apnType) {
        DataState varB4EAC82CA7396A68D541C85D26508E83_894249180 = null; //Variable for return #1
        DataState ret = DataState.DISCONNECTED;
        {
            ret = DataState.DISCONNECTED;
        } //End block
        {
            boolean var01D4A7B95FF96B8BA58C75CB12149B2D_404197953 = (mSST.getCurrentGprsState()
                != ServiceState.STATE_IN_SERVICE);
            {
                ret = DataState.DISCONNECTED;
            } //End block
            {
                boolean varEDC38D72B2381B58A0F3730E74C3817C_1432497044 = (mDataConnectionTracker.isApnTypeEnabled(apnType) == false ||
                mDataConnectionTracker.isApnTypeActive(apnType) == false);
                {
                    ret = DataState.DISCONNECTED;
                } //End block
                {
                    {
                        Object var819139837D42C0AD62155AA1D23C5AD5_286258121 = (mDataConnectionTracker.getState(apnType));
                        //Begin case FAILED IDLE 
                        ret = DataState.DISCONNECTED;
                        //End case FAILED IDLE 
                        //Begin case CONNECTED DISCONNECTING 
                        {
                            boolean var398FF6E0DCA52B02F79A9CB272BA56EC_1335306708 = (mCT.state != Phone.State.IDLE
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
        varB4EAC82CA7396A68D541C85D26508E83_894249180 = ret;
        addTaint(apnType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_894249180.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_894249180;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.024 -0400", hash_original_method = "1B8E5DE4B6A16D073AB6DF5ECB4F317E", hash_generated_method = "4CAB4B76EEAE48C67CD522FD9DF5E85E")
    public DataActivityState getDataActivityState() {
        DataActivityState varB4EAC82CA7396A68D541C85D26508E83_916593496 = null; //Variable for return #1
        DataActivityState ret = DataActivityState.NONE;
        {
            boolean var1BD7F40DFB9082C5149DCE8D977AF125_641265068 = (mSST.getCurrentGprsState() == ServiceState.STATE_IN_SERVICE);
            {
                {
                    Object var27C7E0FDBE09DE35AC2FD606F73591E2_1373960965 = (mDataConnectionTracker.getActivity());
                    //Begin case DATAIN 
                    ret = DataActivityState.DATAIN;
                    //End case DATAIN 
                    //Begin case DATAOUT 
                    ret = DataActivityState.DATAOUT;
                    //End case DATAOUT 
                    //Begin case DATAINANDOUT 
                    ret = DataActivityState.DATAINANDOUT;
                    //End case DATAINANDOUT 
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_916593496 = ret;
        varB4EAC82CA7396A68D541C85D26508E83_916593496.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_916593496;
        // ---------- Original Method ----------
        //DataActivityState ret = DataActivityState.NONE;
        //if (mSST.getCurrentGprsState() == ServiceState.STATE_IN_SERVICE) {
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
            //}
        //}
        //return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.024 -0400", hash_original_method = "812A77A153EDB691C43A0B58CAFAA77A", hash_generated_method = "AB35579F49622E7A241F12B7DDB4EC19")
     void notifyPhoneStateChanged() {
        mNotifier.notifyPhoneState(this);
        // ---------- Original Method ----------
        //mNotifier.notifyPhoneState(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.024 -0400", hash_original_method = "3EB8461625C29B29FD6CB8E5D60B43F3", hash_generated_method = "D04CBC6D94303085010D6FD72DFDF138")
     void notifyPreciseCallStateChanged() {
        super.notifyPreciseCallStateChangedP();
        // ---------- Original Method ----------
        //super.notifyPreciseCallStateChangedP();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.024 -0400", hash_original_method = "292444BE96E352C8E8312B338E19EF02", hash_generated_method = "9CAE80423F167649B545BC55A8273188")
     void notifyNewRingingConnection(Connection c) {
        super.notifyNewRingingConnectionP(c);
        addTaint(c.getTaint());
        // ---------- Original Method ----------
        //super.notifyNewRingingConnectionP(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.025 -0400", hash_original_method = "1858091673D3A4B62C058FCC91892C36", hash_generated_method = "0756798023112E23775C5ED34868F8B8")
     void notifyDisconnect(Connection cn) {
        mDisconnectRegistrants.notifyResult(cn);
        addTaint(cn.getTaint());
        // ---------- Original Method ----------
        //mDisconnectRegistrants.notifyResult(cn);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.025 -0400", hash_original_method = "4DFA3B176AED92FABCFB596FBC88C127", hash_generated_method = "78FF0EBB369D5E48C88943009DE8A38C")
     void notifyUnknownConnection() {
        mUnknownConnectionRegistrants.notifyResult(this);
        // ---------- Original Method ----------
        //mUnknownConnectionRegistrants.notifyResult(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.025 -0400", hash_original_method = "952D093251486E722309085461233179", hash_generated_method = "0D459839BFD4CE2D513A693B187FDF40")
     void notifySuppServiceFailed(SuppService code) {
        mSuppServiceFailedRegistrants.notifyResult(code);
        addTaint(code.getTaint());
        // ---------- Original Method ----------
        //mSuppServiceFailedRegistrants.notifyResult(code);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.025 -0400", hash_original_method = "73E7BFF04E4E9785E6146409272926BA", hash_generated_method = "A54D16F558EC12982CF56FB0933CD181")
     void notifyServiceStateChanged(ServiceState ss) {
        super.notifyServiceStateChangedP(ss);
        addTaint(ss.getTaint());
        // ---------- Original Method ----------
        //super.notifyServiceStateChangedP(ss);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.026 -0400", hash_original_method = "482FE18FBD1949DAF708F2E65940DE8F", hash_generated_method = "0723685B826BB9996EC0449E7B1A8FCF")
     void notifyLocationChanged() {
        mNotifier.notifyCellLocation(this);
        // ---------- Original Method ----------
        //mNotifier.notifyCellLocation(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.026 -0400", hash_original_method = "FCBAE539BB72BE21647FF37299DC2B96", hash_generated_method = "0C6B7A0FF6350CF17887F3D234BB96C8")
     void notifySignalStrength() {
        mNotifier.notifySignalStrength(this);
        // ---------- Original Method ----------
        //mNotifier.notifySignalStrength(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.026 -0400", hash_original_method = "25487D51A5547C84DC8EEF33482B43EF", hash_generated_method = "C35621F7AF385D2C45B899F83A20A075")
    public void notifyCallForwardingIndicator() {
        mNotifier.notifyCallForwardingChanged(this);
        // ---------- Original Method ----------
        //mNotifier.notifyCallForwardingChanged(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.026 -0400", hash_original_method = "C4157CB043EC8B3384F8270EB7DCD5BB", hash_generated_method = "159F2D28E3AC8B75EED9336F04B42E2B")
    public final void setSystemProperty(String property, String value) {
        super.setSystemProperty(property, value);
        addTaint(property.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //super.setSystemProperty(property, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.026 -0400", hash_original_method = "02E1DF9EF058739EC655251AF002C09F", hash_generated_method = "7505EBF55F3934F6E1EE67B842242AF0")
    public void registerForSuppServiceNotification(
            Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mSsnRegistrants.addUnique(h, what, obj);
        {
            boolean varFAB3B0CB4521CD623976F107F015373C_1483041890 = (mSsnRegistrants.size() == 1);
            mCM.setSuppServiceNotifications(true, null);
        } //End collapsed parenthetic
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mSsnRegistrants.addUnique(h, what, obj);
        //if (mSsnRegistrants.size() == 1) mCM.setSuppServiceNotifications(true, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.027 -0400", hash_original_method = "001FDCA2544BEBF92715B871E5466F8E", hash_generated_method = "8F314C74FECD2086DD9360052670A644")
    public void unregisterForSuppServiceNotification(Handler h) {
        mSsnRegistrants.remove(h);
        {
            boolean varB3BC4AC108FB9749A749F1E20FAFF8A8_2008022046 = (mSsnRegistrants.size() == 0);
            mCM.setSuppServiceNotifications(false, null);
        } //End collapsed parenthetic
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mSsnRegistrants.remove(h);
        //if (mSsnRegistrants.size() == 0) mCM.setSuppServiceNotifications(false, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.027 -0400", hash_original_method = "C62CCD6CF2D9D7F7FA17BB7B58067AAC", hash_generated_method = "229941362132B3EA463C13061274E96C")
    public void acceptCall() throws CallStateException {
        mCT.acceptCall();
        // ---------- Original Method ----------
        //mCT.acceptCall();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.027 -0400", hash_original_method = "A64616985F0D82C6750D71CF8DADC6F4", hash_generated_method = "35B0F59F3248405A594AAB683856BD2F")
    public void rejectCall() throws CallStateException {
        mCT.rejectCall();
        // ---------- Original Method ----------
        //mCT.rejectCall();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.028 -0400", hash_original_method = "4BD56579DA53A7A8E0646A63E1978FC8", hash_generated_method = "4EFDBB8DAC4DC308937F3C30BD26241D")
    public void switchHoldingAndActive() throws CallStateException {
        mCT.switchWaitingOrHoldingAndActive();
        // ---------- Original Method ----------
        //mCT.switchWaitingOrHoldingAndActive();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.028 -0400", hash_original_method = "01AA81103C1764FB5FE5BC7D2791F36E", hash_generated_method = "38F405FC066D4ED4C8E3CFFDF923B517")
    public boolean canConference() {
        boolean var62676EA7A977651B04FEF7B6AA776FCC_1293910252 = (mCT.canConference());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1598214770 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1598214770;
        // ---------- Original Method ----------
        //return mCT.canConference();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.028 -0400", hash_original_method = "27A0C6F6921751B2F5D5EAA31130917E", hash_generated_method = "B27986C7B829A8978F2D75FC6A9F9B6F")
    public boolean canDial() {
        boolean var17F304E4F3B49DB2D1D736D9DD207194_950846980 = (mCT.canDial());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_939360916 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_939360916;
        // ---------- Original Method ----------
        //return mCT.canDial();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.028 -0400", hash_original_method = "ED1426E2C308CED60BE3C0151AD877C7", hash_generated_method = "2CFDCF5C26A4C2BD5811B87BFB8C4AB4")
    public void conference() throws CallStateException {
        mCT.conference();
        // ---------- Original Method ----------
        //mCT.conference();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.029 -0400", hash_original_method = "B9932A8A8BD16A4F0D461DDC6FDE6B49", hash_generated_method = "BEFA10EB4DBC56DB633604D1159E6D30")
    public void clearDisconnected() {
        mCT.clearDisconnected();
        // ---------- Original Method ----------
        //mCT.clearDisconnected();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.029 -0400", hash_original_method = "36A0747921C9C16BA6E56F404827E4EB", hash_generated_method = "69757846A3B66336D180C0AE10BD8A41")
    public boolean canTransfer() {
        boolean var8E3EEF73488C19B8AFD5D0569E1452B3_1698691865 = (mCT.canTransfer());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_323511920 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_323511920;
        // ---------- Original Method ----------
        //return mCT.canTransfer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.029 -0400", hash_original_method = "844E9AE7DC0EF8644470861505601222", hash_generated_method = "C4108AEC931486BDFF732FB315DE5DD6")
    public void explicitCallTransfer() throws CallStateException {
        mCT.explicitCallTransfer();
        // ---------- Original Method ----------
        //mCT.explicitCallTransfer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.030 -0400", hash_original_method = "A46545098103F91B00276659EE365887", hash_generated_method = "D2D626327AB91FCC9B47D0DD679B9236")
    public GsmCall getForegroundCall() {
        GsmCall varB4EAC82CA7396A68D541C85D26508E83_1461101344 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1461101344 = mCT.foregroundCall;
        varB4EAC82CA7396A68D541C85D26508E83_1461101344.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1461101344;
        // ---------- Original Method ----------
        //return mCT.foregroundCall;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.031 -0400", hash_original_method = "142F0A4524F2CBB8716568AB3A761D12", hash_generated_method = "7371E24204E8621116C85AB2865E551E")
    public GsmCall getBackgroundCall() {
        GsmCall varB4EAC82CA7396A68D541C85D26508E83_1061638130 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1061638130 = mCT.backgroundCall;
        varB4EAC82CA7396A68D541C85D26508E83_1061638130.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1061638130;
        // ---------- Original Method ----------
        //return mCT.backgroundCall;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.031 -0400", hash_original_method = "F87806E8E26806695F0525D42F1D7DD4", hash_generated_method = "25A899866654F0BAC8983598AE0B874C")
    public GsmCall getRingingCall() {
        GsmCall varB4EAC82CA7396A68D541C85D26508E83_1521975762 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1521975762 = mCT.ringingCall;
        varB4EAC82CA7396A68D541C85D26508E83_1521975762.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1521975762;
        // ---------- Original Method ----------
        //return mCT.ringingCall;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.032 -0400", hash_original_method = "3A1042FC51BD24241CBFB1D3DBD11D23", hash_generated_method = "55B8194A2607CA4B37934BE483F6B036")
    private boolean handleCallDeflectionIncallSupplementaryService(
            String dialString) throws CallStateException {
        {
            boolean var599183C7EFEA223E987C253B1794A663_1118605038 = (dialString.length() > 1);
        } //End collapsed parenthetic
        {
            boolean varC3EC61EA57D8BAD50CBB2912B8C19CD0_473483040 = (getRingingCall().getState() != GsmCall.State.IDLE);
            {
                Log.d(LOG_TAG, "MmiCode 0: rejectCall");
                try 
                {
                    mCT.rejectCall();
                } //End block
                catch (CallStateException e)
                {
                    Log.d(LOG_TAG,
                    "reject failed", e);
                    notifySuppServiceFailed(Phone.SuppService.REJECT);
                } //End block
            } //End block
            {
                boolean var3939D4E7861BC6B97F7F3D876A35B1D2_970869674 = (getBackgroundCall().getState() != GsmCall.State.IDLE);
                {
                    Log.d(LOG_TAG,
                    "MmiCode 0: hangupWaitingOrBackground");
                    mCT.hangupWaitingOrBackground();
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        addTaint(dialString.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_27564579 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_27564579;
        // ---------- Original Method ----------
        //if (dialString.length() > 1) {
            //return false;
        //}
        //if (getRingingCall().getState() != GsmCall.State.IDLE) {
            //if (LOCAL_DEBUG) Log.d(LOG_TAG, "MmiCode 0: rejectCall");
            //try {
                //mCT.rejectCall();
            //} catch (CallStateException e) {
                //if (LOCAL_DEBUG) Log.d(LOG_TAG,
                    //"reject failed", e);
                //notifySuppServiceFailed(Phone.SuppService.REJECT);
            //}
        //} else if (getBackgroundCall().getState() != GsmCall.State.IDLE) {
            //if (LOCAL_DEBUG) Log.d(LOG_TAG,
                    //"MmiCode 0: hangupWaitingOrBackground");
            //mCT.hangupWaitingOrBackground();
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.033 -0400", hash_original_method = "54841B6AA04B8F69693CDF35FACFE6EA", hash_generated_method = "FC4AAC7A08681BEACF4C3BC596BB629F")
    private boolean handleCallWaitingIncallSupplementaryService(
            String dialString) throws CallStateException {
        int len = dialString.length();
        GsmCall call = (GsmCall) getForegroundCall();
        try 
        {
            {
                char ch = dialString.charAt(1);
                int callIndex = ch - '0';
                {
                    Log.d(LOG_TAG,
                            "MmiCode 1: hangupConnectionByIndex " +
                            callIndex);
                    mCT.hangupConnectionByIndex(call, callIndex);
                } //End block
            } //End block
            {
                {
                    boolean varAA260EC3CDDC603D103B4D5D62C46E51_1138236202 = (call.getState() != GsmCall.State.IDLE);
                    {
                        Log.d(LOG_TAG,
                            "MmiCode 1: hangup foreground");
                        mCT.hangup(call);
                    } //End block
                    {
                        Log.d(LOG_TAG,
                            "MmiCode 1: switchWaitingOrHoldingAndActive");
                        mCT.switchWaitingOrHoldingAndActive();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        catch (CallStateException e)
        {
            Log.d(LOG_TAG,
                "hangup failed", e);
            notifySuppServiceFailed(Phone.SuppService.HANGUP);
        } //End block
        addTaint(dialString.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1147130788 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1147130788;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.033 -0400", hash_original_method = "F4FAEC22329B0BDDF008B69FB760B2A4", hash_generated_method = "C4931B7AD85BAF31BBCFA0B7E7023BA3")
    private boolean handleCallHoldIncallSupplementaryService(String dialString) throws CallStateException {
        int len = dialString.length();
        GsmCall call = (GsmCall) getForegroundCall();
        {
            try 
            {
                char ch = dialString.charAt(1);
                int callIndex = ch - '0';
                GsmConnection conn = mCT.getConnectionByIndex(call, callIndex);
                {
                    Log.d(LOG_TAG, "MmiCode 2: separate call "+
                            callIndex);
                    mCT.separate(conn);
                } //End block
                {
                    Log.d(LOG_TAG, "separate: invalid call index "+
                            callIndex);
                    notifySuppServiceFailed(Phone.SuppService.SEPARATE);
                } //End block
            } //End block
            catch (CallStateException e)
            {
                Log.d(LOG_TAG,
                    "separate failed", e);
                notifySuppServiceFailed(Phone.SuppService.SEPARATE);
            } //End block
        } //End block
        {
            try 
            {
                {
                    boolean var3B586179DB1A75B5DE869C498B98014C_1078064510 = (getRingingCall().getState() != GsmCall.State.IDLE);
                    {
                        Log.d(LOG_TAG,
                    "MmiCode 2: accept ringing call");
                        mCT.acceptCall();
                    } //End block
                    {
                        Log.d(LOG_TAG,
                    "MmiCode 2: switchWaitingOrHoldingAndActive");
                        mCT.switchWaitingOrHoldingAndActive();
                    } //End block
                } //End collapsed parenthetic
            } //End block
            catch (CallStateException e)
            {
                Log.d(LOG_TAG,
                    "switch failed", e);
                notifySuppServiceFailed(Phone.SuppService.SWITCH);
            } //End block
        } //End block
        addTaint(dialString.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1602923030 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1602923030;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.034 -0400", hash_original_method = "A61A93477751B5EFFB3B26065CE7F8F7", hash_generated_method = "4289CEDEF0C07F9B17582F62D88ADFF1")
    private boolean handleMultipartyIncallSupplementaryService(
            String dialString) throws CallStateException {
        {
            boolean var599183C7EFEA223E987C253B1794A663_1268524853 = (dialString.length() > 1);
        } //End collapsed parenthetic
        Log.d(LOG_TAG, "MmiCode 3: merge calls");
        try 
        {
            conference();
        } //End block
        catch (CallStateException e)
        {
            Log.d(LOG_TAG,
                "conference failed", e);
            notifySuppServiceFailed(Phone.SuppService.CONFERENCE);
        } //End block
        addTaint(dialString.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_835447947 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_835447947;
        // ---------- Original Method ----------
        //if (dialString.length() > 1) {
            //return false;
        //}
        //if (LOCAL_DEBUG) Log.d(LOG_TAG, "MmiCode 3: merge calls");
        //try {
            //conference();
        //} catch (CallStateException e) {
            //if (LOCAL_DEBUG) Log.d(LOG_TAG,
                //"conference failed", e);
            //notifySuppServiceFailed(Phone.SuppService.CONFERENCE);
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.034 -0400", hash_original_method = "D22F8E83AE3C2E24760F930E8B1C0AF8", hash_generated_method = "E5B3F6EF25009ADAD7600C3D8D8C1A3D")
    private boolean handleEctIncallSupplementaryService(String dialString) throws CallStateException {
        int len = dialString.length();
        Log.d(LOG_TAG, "MmiCode 4: explicit call transfer");
        try 
        {
            explicitCallTransfer();
        } //End block
        catch (CallStateException e)
        {
            Log.d(LOG_TAG,
                "transfer failed", e);
            notifySuppServiceFailed(Phone.SuppService.TRANSFER);
        } //End block
        addTaint(dialString.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1076052405 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1076052405;
        // ---------- Original Method ----------
        //int len = dialString.length();
        //if (len != 1) {
            //return false;
        //}
        //if (LOCAL_DEBUG) Log.d(LOG_TAG, "MmiCode 4: explicit call transfer");
        //try {
            //explicitCallTransfer();
        //} catch (CallStateException e) {
            //if (LOCAL_DEBUG) Log.d(LOG_TAG,
                //"transfer failed", e);
            //notifySuppServiceFailed(Phone.SuppService.TRANSFER);
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.035 -0400", hash_original_method = "F0B7315BB3E501E36AB72E6B89A34578", hash_generated_method = "D5BB11C4074746CA909F9614184D72F3")
    private boolean handleCcbsIncallSupplementaryService(String dialString) throws CallStateException {
        {
            boolean var599183C7EFEA223E987C253B1794A663_1312982290 = (dialString.length() > 1);
        } //End collapsed parenthetic
        notifySuppServiceFailed(Phone.SuppService.UNKNOWN);
        addTaint(dialString.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_188037811 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_188037811;
        // ---------- Original Method ----------
        //if (dialString.length() > 1) {
            //return false;
        //}
        //Log.i(LOG_TAG, "MmiCode 5: CCBS not supported!");
        //notifySuppServiceFailed(Phone.SuppService.UNKNOWN);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.035 -0400", hash_original_method = "ADE3D3CB52AC1581EEE1CFCBED33E09A", hash_generated_method = "B6EB0DFAD8AE889A6B343A84559B857A")
    public boolean handleInCallMmiCommands(String dialString) throws CallStateException {
        {
            boolean var2DA7186072441CB83C6A969D8B16A442_1218106568 = (!isInCall());
        } //End collapsed parenthetic
        {
            boolean varE12969D5E25DB7CCEEFA6845C2569D2D_1314851728 = (TextUtils.isEmpty(dialString));
        } //End collapsed parenthetic
        boolean result = false;
        char ch = dialString.charAt(0);
        //Begin case '0' 
        result = handleCallDeflectionIncallSupplementaryService(
                        dialString);
        //End case '0' 
        //Begin case '1' 
        result = handleCallWaitingIncallSupplementaryService(
                        dialString);
        //End case '1' 
        //Begin case '2' 
        result = handleCallHoldIncallSupplementaryService(dialString);
        //End case '2' 
        //Begin case '3' 
        result = handleMultipartyIncallSupplementaryService(dialString);
        //End case '3' 
        //Begin case '4' 
        result = handleEctIncallSupplementaryService(dialString);
        //End case '4' 
        //Begin case '5' 
        result = handleCcbsIncallSupplementaryService(dialString);
        //End case '5' 
        addTaint(dialString.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_121471048 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_121471048;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.035 -0400", hash_original_method = "711944CD15C0B30B5C3E1DF07833B9CC", hash_generated_method = "32F618B1DEEBA2C01123F48A3844181D")
     boolean isInCall() {
        GsmCall.State foregroundCallState = getForegroundCall().getState();
        GsmCall.State backgroundCallState = getBackgroundCall().getState();
        GsmCall.State ringingCallState = getRingingCall().getState();
        boolean var40D567FED010B1806D41F17B742032B9_1707020420 = ((foregroundCallState.isAlive() ||
                backgroundCallState.isAlive() ||
                ringingCallState.isAlive()));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_424573705 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_424573705;
        // ---------- Original Method ----------
        //GsmCall.State foregroundCallState = getForegroundCall().getState();
        //GsmCall.State backgroundCallState = getBackgroundCall().getState();
        //GsmCall.State ringingCallState = getRingingCall().getState();
        //return (foregroundCallState.isAlive() ||
                //backgroundCallState.isAlive() ||
                //ringingCallState.isAlive());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.036 -0400", hash_original_method = "869C8D5C9810AA3DB7F9F221ECFAACBF", hash_generated_method = "682F40037DD558710458EA4761C99BA4")
    public Connection dial(String dialString) throws CallStateException {
        Connection varB4EAC82CA7396A68D541C85D26508E83_705060859 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_705060859 = dial(dialString, null);
        addTaint(dialString.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_705060859.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_705060859;
        // ---------- Original Method ----------
        //return dial(dialString, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.037 -0400", hash_original_method = "905878DD9E4370A9706866C1B8D62D03", hash_generated_method = "3C67FDB8CEB65EE53C44AF440FF3D64B")
    public Connection dial(String dialString, UUSInfo uusInfo) throws CallStateException {
        Connection varB4EAC82CA7396A68D541C85D26508E83_1955792327 = null; //Variable for return #1
        Connection varB4EAC82CA7396A68D541C85D26508E83_163002117 = null; //Variable for return #2
        Connection varB4EAC82CA7396A68D541C85D26508E83_2131614247 = null; //Variable for return #3
        Connection varB4EAC82CA7396A68D541C85D26508E83_618481892 = null; //Variable for return #4
        String newDialString = PhoneNumberUtils.stripSeparators(dialString);
        {
            boolean var22047FA7216835015EF1E811EC89577D_1708336103 = (handleInCallMmiCommands(newDialString));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1955792327 = null;
            } //End block
        } //End collapsed parenthetic
        String networkPortion = PhoneNumberUtils.extractNetworkPortionAlt(newDialString);
        GsmMmiCode mmi = GsmMmiCode.newFromDialString(networkPortion, this);
        Log.d(LOG_TAG,
                               "dialing w/ mmi '" + mmi + "'...");
        {
            varB4EAC82CA7396A68D541C85D26508E83_163002117 = mCT.dial(newDialString, uusInfo);
        } //End block
        {
            boolean varD000FF2B694DE8E860A4E505705D97D0_526192311 = (mmi.isTemporaryModeCLIR());
            {
                varB4EAC82CA7396A68D541C85D26508E83_2131614247 = mCT.dial(mmi.dialingNumber, mmi.getCLIRMode(), uusInfo);
            } //End block
            {
                mPendingMMIs.add(mmi);
                mMmiRegistrants.notifyRegistrants(new AsyncResult(null, mmi, null));
                mmi.processCode();
                varB4EAC82CA7396A68D541C85D26508E83_618481892 = null;
            } //End block
        } //End collapsed parenthetic
        addTaint(dialString.getTaint());
        addTaint(uusInfo.getTaint());
        Connection varA7E53CE21691AB073D9660D615818899_1507010074; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1507010074 = varB4EAC82CA7396A68D541C85D26508E83_1955792327;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1507010074 = varB4EAC82CA7396A68D541C85D26508E83_163002117;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1507010074 = varB4EAC82CA7396A68D541C85D26508E83_2131614247;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1507010074 = varB4EAC82CA7396A68D541C85D26508E83_618481892;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1507010074.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1507010074;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.038 -0400", hash_original_method = "4BA0C4BD36DFB68226B2317C39970473", hash_generated_method = "C6D4D9D82741A376D913BCC3BEB854E5")
    public boolean handlePinMmi(String dialString) {
        GsmMmiCode mmi = GsmMmiCode.newFromDialString(dialString, this);
        {
            boolean var182AE2F3D97AC06A48466C4D43389C30_639014821 = (mmi != null && mmi.isPinCommand());
            {
                mPendingMMIs.add(mmi);
                mMmiRegistrants.notifyRegistrants(new AsyncResult(null, mmi, null));
                mmi.processCode();
            } //End block
        } //End collapsed parenthetic
        addTaint(dialString.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1940416288 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1940416288;
        // ---------- Original Method ----------
        //GsmMmiCode mmi = GsmMmiCode.newFromDialString(dialString, this);
        //if (mmi != null && mmi.isPinCommand()) {
            //mPendingMMIs.add(mmi);
            //mMmiRegistrants.notifyRegistrants(new AsyncResult(null, mmi, null));
            //mmi.processCode();
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.041 -0400", hash_original_method = "0D802E3B18B63F6835A66AA15E37A07D", hash_generated_method = "378DCB2D780489805F375BE2BB396A09")
    public void sendUssdResponse(String ussdMessge) {
        GsmMmiCode mmi = GsmMmiCode.newFromUssdUserInput(ussdMessge, this);
        mPendingMMIs.add(mmi);
        mMmiRegistrants.notifyRegistrants(new AsyncResult(null, mmi, null));
        mmi.sendUssd(ussdMessge);
        addTaint(ussdMessge.getTaint());
        // ---------- Original Method ----------
        //GsmMmiCode mmi = GsmMmiCode.newFromUssdUserInput(ussdMessge, this);
        //mPendingMMIs.add(mmi);
        //mMmiRegistrants.notifyRegistrants(new AsyncResult(null, mmi, null));
        //mmi.sendUssd(ussdMessge);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.042 -0400", hash_original_method = "98607162C44D8873925496654D522BF8", hash_generated_method = "993F9372139EE8BE48FE253AF4587EC3")
    public void sendDtmf(char c) {
        {
            boolean varD5E376D61876D980336EC59E5D202EEE_522549388 = (!PhoneNumberUtils.is12Key(c));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.042 -0400", hash_original_method = "3FBA1333099AE68AF02019D712D23AB2", hash_generated_method = "860F2ACA0F4B76C85B893917B720D391")
    public void startDtmf(char c) {
        {
            boolean varD5E376D61876D980336EC59E5D202EEE_971272067 = (!PhoneNumberUtils.is12Key(c));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.043 -0400", hash_original_method = "3DAC039DE959EF34631E2B825CE1F213", hash_generated_method = "E3ACE99405ED7C4AFBEE2F93E02370EB")
    public void stopDtmf() {
        mCM.stopDtmf(null);
        // ---------- Original Method ----------
        //mCM.stopDtmf(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.043 -0400", hash_original_method = "632DA8A1165B474AAA75C1A965AA7035", hash_generated_method = "A6BBC7BAC7B5E358A183AE12DC1C1071")
    public void sendBurstDtmf(String dtmfString) {
        addTaint(dtmfString.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[GSMPhone] sendBurstDtmf() is a CDMA method");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.044 -0400", hash_original_method = "6583EBFAAE11F5B271B0C202AB11C3E9", hash_generated_method = "05A63141C9EA8439A5D53E7DA83CD61B")
    public void setRadioPower(boolean power) {
        mSST.setRadioPower(power);
        addTaint(power);
        // ---------- Original Method ----------
        //mSST.setRadioPower(power);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.044 -0400", hash_original_method = "E7F586CDCE74786257222FAC0983E7F9", hash_generated_method = "AAEF2180C2A029D18DA7932416D2C0E8")
    private void storeVoiceMailNumber(String number) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(VM_NUMBER, number);
        editor.apply();
        setVmSimImsi(getSubscriberId());
        addTaint(number.getTaint());
        // ---------- Original Method ----------
        //SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        //SharedPreferences.Editor editor = sp.edit();
        //editor.putString(VM_NUMBER, number);
        //editor.apply();
        //setVmSimImsi(getSubscriberId());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.046 -0400", hash_original_method = "69924A8239B9858372407D5C2A54772B", hash_generated_method = "ACCD27037E3B869AC558E7873DF033A8")
    public String getVoiceMailNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_1100924204 = null; //Variable for return #1
        String number = mIccRecords.getVoiceMailNumber();
        {
            boolean varDC814D5E0DD02381050A532714A4AE08_1667043783 = (TextUtils.isEmpty(number));
            {
                SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
                number = sp.getString(VM_NUMBER, null);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1100924204 = number;
        varB4EAC82CA7396A68D541C85D26508E83_1100924204.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1100924204;
        // ---------- Original Method ----------
        //String number = mIccRecords.getVoiceMailNumber();
        //if (TextUtils.isEmpty(number)) {
            //SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
            //number = sp.getString(VM_NUMBER, null);
        //}
        //return number;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.049 -0400", hash_original_method = "767A05C9F746992519407618C38B7609", hash_generated_method = "554DFE6338114664969E2DC6EE529AC9")
    private String getVmSimImsi() {
        String varB4EAC82CA7396A68D541C85D26508E83_262839858 = null; //Variable for return #1
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        varB4EAC82CA7396A68D541C85D26508E83_262839858 = sp.getString(VM_SIM_IMSI, null);
        varB4EAC82CA7396A68D541C85D26508E83_262839858.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_262839858;
        // ---------- Original Method ----------
        //SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        //return sp.getString(VM_SIM_IMSI, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.050 -0400", hash_original_method = "8C96CC1C916F049093DF13C1B1327265", hash_generated_method = "3CCC8D6BA43C9240C893073ACDBD2058")
    private void setVmSimImsi(String imsi) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(VM_SIM_IMSI, imsi);
        editor.apply();
        addTaint(imsi.getTaint());
        // ---------- Original Method ----------
        //SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        //SharedPreferences.Editor editor = sp.edit();
        //editor.putString(VM_SIM_IMSI, imsi);
        //editor.apply();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.053 -0400", hash_original_method = "445A2067BED895487F73AC5A870ED091", hash_generated_method = "3C36D4392D2AECFD7E5D923085904BA4")
    public String getVoiceMailAlphaTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_339579581 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_2063669632 = null; //Variable for return #2
        String ret;
        ret = mIccRecords.getVoiceMailAlphaTag();
        {
            boolean var0709D69E6C2648B4A0C93BD0750A7DE0_1029577892 = (ret == null || ret.length() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_339579581 = mContext.getText(
                com.android.internal.R.string.defaultVoiceMailAlphaTag).toString();
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_2063669632 = ret;
        String varA7E53CE21691AB073D9660D615818899_877743024; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_877743024 = varB4EAC82CA7396A68D541C85D26508E83_339579581;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_877743024 = varB4EAC82CA7396A68D541C85D26508E83_2063669632;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_877743024.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_877743024;
        // ---------- Original Method ----------
        //String ret;
        //ret = mIccRecords.getVoiceMailAlphaTag();
        //if (ret == null || ret.length() == 0) {
            //return mContext.getText(
                //com.android.internal.R.string.defaultVoiceMailAlphaTag).toString();
        //}
        //return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.054 -0400", hash_original_method = "40864F79C0287ACEFC2860E74923A158", hash_generated_method = "41DF1F6189237201B3DF728F2294BD36")
    public String getDeviceId() {
        String varB4EAC82CA7396A68D541C85D26508E83_1225089182 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1225089182 = mImei;
        varB4EAC82CA7396A68D541C85D26508E83_1225089182.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1225089182;
        // ---------- Original Method ----------
        //return mImei;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.055 -0400", hash_original_method = "14B7BB34E0FC203F73344BD326AAB989", hash_generated_method = "3B45968665744F6A84B71860E1CCDF5A")
    public String getDeviceSvn() {
        String varB4EAC82CA7396A68D541C85D26508E83_1990107778 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1990107778 = mImeiSv;
        varB4EAC82CA7396A68D541C85D26508E83_1990107778.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1990107778;
        // ---------- Original Method ----------
        //return mImeiSv;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.056 -0400", hash_original_method = "2BFB931234EFCBDA06B75AE314A70B6B", hash_generated_method = "9BEEB2AC654AED0FA9D17DEB44A069A1")
    public String getImei() {
        String varB4EAC82CA7396A68D541C85D26508E83_1385918680 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1385918680 = mImei;
        varB4EAC82CA7396A68D541C85D26508E83_1385918680.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1385918680;
        // ---------- Original Method ----------
        //return mImei;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.056 -0400", hash_original_method = "8337C263E1C0C858E7E7356286A6EE86", hash_generated_method = "4A872F730130A530DBD5B7318CD9883D")
    public String getEsn() {
        String varB4EAC82CA7396A68D541C85D26508E83_1613758586 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1613758586 = "0";
        varB4EAC82CA7396A68D541C85D26508E83_1613758586.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1613758586;
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[GSMPhone] getEsn() is a CDMA method");
        //return "0";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.057 -0400", hash_original_method = "92AF0460E6B1DF6A22F32869474C6DE7", hash_generated_method = "9BEF7EE0D05BADCAC70501DE42B40E2C")
    public String getMeid() {
        String varB4EAC82CA7396A68D541C85D26508E83_787778392 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_787778392 = "0";
        varB4EAC82CA7396A68D541C85D26508E83_787778392.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_787778392;
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[GSMPhone] getMeid() is a CDMA method");
        //return "0";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.057 -0400", hash_original_method = "418ED398A6A3FF53B03B4C5008FE3F90", hash_generated_method = "F94BA9BC9D9C85B0E0B5F27218061102")
    public String getSubscriberId() {
        String varB4EAC82CA7396A68D541C85D26508E83_1113932942 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1113932942 = mIccRecords.getIMSI();
        varB4EAC82CA7396A68D541C85D26508E83_1113932942.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1113932942;
        // ---------- Original Method ----------
        //return mIccRecords.getIMSI();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.058 -0400", hash_original_method = "084DD7ECDC7A6E289A4C2D9F1DE10A12", hash_generated_method = "711FAD4D814E4EFCD21251AB96A2AD5F")
    public String getLine1Number() {
        String varB4EAC82CA7396A68D541C85D26508E83_1974716736 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1974716736 = mIccRecords.getMsisdnNumber();
        varB4EAC82CA7396A68D541C85D26508E83_1974716736.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1974716736;
        // ---------- Original Method ----------
        //return mIccRecords.getMsisdnNumber();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.058 -0400", hash_original_method = "0F1A42666FEB7039E59CE38A804A2571", hash_generated_method = "6CA6E7221275A6B897CE4BB11FD3524F")
    @Override
    public String getMsisdn() {
        String varB4EAC82CA7396A68D541C85D26508E83_1994301341 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1994301341 = mIccRecords.getMsisdnNumber();
        varB4EAC82CA7396A68D541C85D26508E83_1994301341.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1994301341;
        // ---------- Original Method ----------
        //return mIccRecords.getMsisdnNumber();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.059 -0400", hash_original_method = "D360BD2B0AE3500C93B786BA943E8C4F", hash_generated_method = "F25BAF95BB3ED8CEBE2C2E136CB95FCE")
    public String getLine1AlphaTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_866164900 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_866164900 = mIccRecords.getMsisdnAlphaTag();
        varB4EAC82CA7396A68D541C85D26508E83_866164900.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_866164900;
        // ---------- Original Method ----------
        //return mIccRecords.getMsisdnAlphaTag();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.059 -0400", hash_original_method = "F8CED3952B50871548C8F8795A72A874", hash_generated_method = "2F83E945254E4C14314DD3FEF8E5E644")
    public void setLine1Number(String alphaTag, String number, Message onComplete) {
        mIccRecords.setMsisdnNumber(alphaTag, number, onComplete);
        addTaint(alphaTag.getTaint());
        addTaint(number.getTaint());
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //mIccRecords.setMsisdnNumber(alphaTag, number, onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.059 -0400", hash_original_method = "63103D1CE9C7888BE66C8CE520564C7E", hash_generated_method = "FB951956CF6FF915B0F35F192179D19D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.060 -0400", hash_original_method = "9DDD364B83D4A188246C8EC4129A09D5", hash_generated_method = "E7B1531DED350D6F28C5A319A7D9CF6C")
    private boolean isValidCommandInterfaceCFReason(int commandInterfaceCFReason) {
        addTaint(commandInterfaceCFReason);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_442115333 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_442115333;
        // ---------- Original Method ----------
        //switch (commandInterfaceCFReason) {
        //case CF_REASON_UNCONDITIONAL:
        //case CF_REASON_BUSY:
        //case CF_REASON_NO_REPLY:
        //case CF_REASON_NOT_REACHABLE:
        //case CF_REASON_ALL:
        //case CF_REASON_ALL_CONDITIONAL:
            //return true;
        //default:
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.060 -0400", hash_original_method = "138625FFD93D7E6FCFD9298408C66777", hash_generated_method = "7895AEC77089548799B40EEB044B09C3")
    private boolean isValidCommandInterfaceCFAction(int commandInterfaceCFAction) {
        addTaint(commandInterfaceCFAction);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1111573053 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1111573053;
        // ---------- Original Method ----------
        //switch (commandInterfaceCFAction) {
        //case CF_ACTION_DISABLE:
        //case CF_ACTION_ENABLE:
        //case CF_ACTION_REGISTRATION:
        //case CF_ACTION_ERASURE:
            //return true;
        //default:
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.061 -0400", hash_original_method = "E62FA7EF147A8759C3C5908B3838581B", hash_generated_method = "8E6347892EA78943CEAB79099AE8A003")
    protected boolean isCfEnable(int action) {
        addTaint(action);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1586827503 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1586827503;
        // ---------- Original Method ----------
        //return (action == CF_ACTION_ENABLE) || (action == CF_ACTION_REGISTRATION);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.061 -0400", hash_original_method = "08670889C34D44E522747D6078786295", hash_generated_method = "3BB0BCA10E14B54C76AEA4B872E48645")
    public void getCallForwardingOption(int commandInterfaceCFReason, Message onComplete) {
        {
            boolean varB6A05407BFCE3D15C223CC07E884F337_132721107 = (isValidCommandInterfaceCFReason(commandInterfaceCFReason));
            {
                Log.d(LOG_TAG, "requesting call forwarding query.");
                Message resp;
                {
                    resp = obtainMessage(EVENT_GET_CALL_FORWARD_DONE, onComplete);
                } //End block
                {
                    resp = onComplete;
                } //End block
                mCM.queryCallForwardStatus(commandInterfaceCFReason,0,null,resp);
            } //End block
        } //End collapsed parenthetic
        addTaint(commandInterfaceCFReason);
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //if (isValidCommandInterfaceCFReason(commandInterfaceCFReason)) {
            //if (LOCAL_DEBUG) Log.d(LOG_TAG, "requesting call forwarding query.");
            //Message resp;
            //if (commandInterfaceCFReason == CF_REASON_UNCONDITIONAL) {
                //resp = obtainMessage(EVENT_GET_CALL_FORWARD_DONE, onComplete);
            //} else {
                //resp = onComplete;
            //}
            //mCM.queryCallForwardStatus(commandInterfaceCFReason,0,null,resp);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.062 -0400", hash_original_method = "C31B5CE81010007284F85A1CC1A97426", hash_generated_method = "60676B4277F874BE2319AA0DD3EFD772")
    public void setCallForwardingOption(int commandInterfaceCFAction,
            int commandInterfaceCFReason,
            String dialingNumber,
            int timerSeconds,
            Message onComplete) {
        {
            boolean var1CEEA491E3B272BF616FE6FFF10B0258_1525703854 = ((isValidCommandInterfaceCFAction(commandInterfaceCFAction)) &&
                (isValidCommandInterfaceCFReason(commandInterfaceCFReason)));
            {
                Message resp;
                {
                    resp = obtainMessage(EVENT_SET_CALL_FORWARD_DONE,
                        isCfEnable(commandInterfaceCFAction) ? 1 : 0, 0, onComplete);
                } //End block
                {
                    resp = onComplete;
                } //End block
                mCM.setCallForward(commandInterfaceCFAction,
                    commandInterfaceCFReason,
                    CommandsInterface.SERVICE_CLASS_VOICE,
                    dialingNumber,
                    timerSeconds,
                    resp);
            } //End block
        } //End collapsed parenthetic
        addTaint(commandInterfaceCFAction);
        addTaint(commandInterfaceCFReason);
        addTaint(dialingNumber.getTaint());
        addTaint(timerSeconds);
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //if (    (isValidCommandInterfaceCFAction(commandInterfaceCFAction)) &&
                //(isValidCommandInterfaceCFReason(commandInterfaceCFReason))) {
            //Message resp;
            //if (commandInterfaceCFReason == CF_REASON_UNCONDITIONAL) {
                //resp = obtainMessage(EVENT_SET_CALL_FORWARD_DONE,
                        //isCfEnable(commandInterfaceCFAction) ? 1 : 0, 0, onComplete);
            //} else {
                //resp = onComplete;
            //}
            //mCM.setCallForward(commandInterfaceCFAction,
                    //commandInterfaceCFReason,
                    //CommandsInterface.SERVICE_CLASS_VOICE,
                    //dialingNumber,
                    //timerSeconds,
                    //resp);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.063 -0400", hash_original_method = "211ADA06D97F0C35F6F35D44159D1041", hash_generated_method = "4E0A5EBB9EA472EF008B883B43A17BB7")
    public void getOutgoingCallerIdDisplay(Message onComplete) {
        mCM.getCLIR(onComplete);
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //mCM.getCLIR(onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.064 -0400", hash_original_method = "9A33528D3F7EB56FD0CAE46DED766DA5", hash_generated_method = "CBEFDBA5BEA31A14D6710BCF53022067")
    public void setOutgoingCallerIdDisplay(int commandInterfaceCLIRMode,
                                           Message onComplete) {
        mCM.setCLIR(commandInterfaceCLIRMode,
                obtainMessage(EVENT_SET_CLIR_COMPLETE, commandInterfaceCLIRMode, 0, onComplete));
        addTaint(commandInterfaceCLIRMode);
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //mCM.setCLIR(commandInterfaceCLIRMode,
                //obtainMessage(EVENT_SET_CLIR_COMPLETE, commandInterfaceCLIRMode, 0, onComplete));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.065 -0400", hash_original_method = "5AA95CCFAB839BE19F56DECDE6C06EAE", hash_generated_method = "7673F821F9D71A843888D86E7DC4611F")
    public void getCallWaiting(Message onComplete) {
        mCM.queryCallWaiting(CommandsInterface.SERVICE_CLASS_NONE, onComplete);
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //mCM.queryCallWaiting(CommandsInterface.SERVICE_CLASS_NONE, onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.065 -0400", hash_original_method = "378FD22E0CB0CF1CC5C649D301CEF0C1", hash_generated_method = "629281880C4B7E8CCD82DBA8A7023133")
    public void setCallWaiting(boolean enable, Message onComplete) {
        mCM.setCallWaiting(enable, CommandsInterface.SERVICE_CLASS_VOICE, onComplete);
        addTaint(enable);
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //mCM.setCallWaiting(enable, CommandsInterface.SERVICE_CLASS_VOICE, onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.066 -0400", hash_original_method = "4DC55439AC7C450EEFD22BFFC07D3CE9", hash_generated_method = "3367B26B3B2FC6C5AD7648EC92FDB787")
    public void getAvailableNetworks(Message response) {
        mCM.getAvailableNetworks(response);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //mCM.getAvailableNetworks(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.066 -0400", hash_original_method = "21AFB30263A6CEDCB2E90901BACA2953", hash_generated_method = "E5E82EC1549986E19660CFCF7CD2304D")
    public void setNetworkSelectionModeAutomatic(Message response) {
        NetworkSelectMessage nsm = new NetworkSelectMessage();
        nsm.message = response;
        nsm.operatorNumeric = "";
        nsm.operatorAlphaLong = "";
        Message msg = obtainMessage(EVENT_SET_NETWORK_AUTOMATIC_COMPLETE, nsm);
        Log.d(LOG_TAG, "wrapping and sending message to connect automatically");
        mCM.setNetworkSelectionModeAutomatic(msg);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //NetworkSelectMessage nsm = new NetworkSelectMessage();
        //nsm.message = response;
        //nsm.operatorNumeric = "";
        //nsm.operatorAlphaLong = "";
        //Message msg = obtainMessage(EVENT_SET_NETWORK_AUTOMATIC_COMPLETE, nsm);
        //if (LOCAL_DEBUG)
            //Log.d(LOG_TAG, "wrapping and sending message to connect automatically");
        //mCM.setNetworkSelectionModeAutomatic(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.067 -0400", hash_original_method = "388CF66FD02B64F200B61D1E744A0B56", hash_generated_method = "9C3F90396A27BE0C36C66C5211C792F0")
    public void selectNetworkManually(OperatorInfo network,
            Message response) {
        NetworkSelectMessage nsm = new NetworkSelectMessage();
        nsm.message = response;
        nsm.operatorNumeric = network.getOperatorNumeric();
        nsm.operatorAlphaLong = network.getOperatorAlphaLong();
        Message msg = obtainMessage(EVENT_SET_NETWORK_MANUAL_COMPLETE, nsm);
        mCM.setNetworkSelectionModeManual(network.getOperatorNumeric(), msg);
        addTaint(network.getTaint());
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //NetworkSelectMessage nsm = new NetworkSelectMessage();
        //nsm.message = response;
        //nsm.operatorNumeric = network.getOperatorNumeric();
        //nsm.operatorAlphaLong = network.getOperatorAlphaLong();
        //Message msg = obtainMessage(EVENT_SET_NETWORK_MANUAL_COMPLETE, nsm);
        //mCM.setNetworkSelectionModeManual(network.getOperatorNumeric(), msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.067 -0400", hash_original_method = "3A54DC42D0DFD8C763BDF4414C51677B", hash_generated_method = "64B88CABA725194290584FBC40E665D5")
    public void getNeighboringCids(Message response) {
        mCM.getNeighboringCids(response);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //mCM.getNeighboringCids(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.068 -0400", hash_original_method = "A54F4B18F21B3A39961648F4BDA2F061", hash_generated_method = "0D9A74204B6FB987A29697E2CA304A25")
    public void setOnPostDialCharacter(Handler h, int what, Object obj) {
        mPostDialHandler = new Registrant(h, what, obj);
        // ---------- Original Method ----------
        //mPostDialHandler = new Registrant(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.068 -0400", hash_original_method = "E892EC268DCFDF5C9C27A7DDC7E00573", hash_generated_method = "77B440C2480B73790494E18A49E29D56")
    public void setMute(boolean muted) {
        mCT.setMute(muted);
        addTaint(muted);
        // ---------- Original Method ----------
        //mCT.setMute(muted);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.068 -0400", hash_original_method = "FA6E824680C8944626A1A959DCEA6499", hash_generated_method = "23C358B44C6014D04CB50729D14B3A4F")
    public boolean getMute() {
        boolean var20663A120A6F5E860F4EB58F2E5B9228_532716356 = (mCT.getMute());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_259252746 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_259252746;
        // ---------- Original Method ----------
        //return mCT.getMute();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.069 -0400", hash_original_method = "DAED77F9218E0449A772CA04214CC7F0", hash_generated_method = "13BB02467E7237F3DCAA27B785AFC8DE")
    public void getDataCallList(Message response) {
        mCM.getDataCallList(response);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //mCM.getDataCallList(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.070 -0400", hash_original_method = "96CADC2872DB4F7FDEDEDD322815973F", hash_generated_method = "822C445C5B4D9120BF9FC0E8634D50FF")
    public void updateServiceLocation() {
        mSST.enableSingleLocationUpdate();
        // ---------- Original Method ----------
        //mSST.enableSingleLocationUpdate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.070 -0400", hash_original_method = "85721F5820CF0128BD1EA66BA785E274", hash_generated_method = "8061BA0AAC1F798918E946EB98E60D31")
    public void enableLocationUpdates() {
        mSST.enableLocationUpdates();
        // ---------- Original Method ----------
        //mSST.enableLocationUpdates();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.071 -0400", hash_original_method = "E6FECC87DDBB4D4FE984E494757397E3", hash_generated_method = "3FDC902944764AB6B7139C73765CF957")
    public void disableLocationUpdates() {
        mSST.disableLocationUpdates();
        // ---------- Original Method ----------
        //mSST.disableLocationUpdates();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.072 -0400", hash_original_method = "33CDF43696035DC3E16A234222A80D64", hash_generated_method = "FC41B4528C5262C4DE2C5DB30FEBBAB8")
    public boolean getDataRoamingEnabled() {
        boolean var6ACB2ECE8621241EECE599BD6243F11B_158592241 = (mDataConnectionTracker.getDataOnRoamingEnabled());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1169084312 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1169084312;
        // ---------- Original Method ----------
        //return mDataConnectionTracker.getDataOnRoamingEnabled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.073 -0400", hash_original_method = "910AE5D7D70CC37EC2511A21C3761E3A", hash_generated_method = "833E210D6BAC589C67F646388318201A")
    public void setDataRoamingEnabled(boolean enable) {
        mDataConnectionTracker.setDataOnRoamingEnabled(enable);
        addTaint(enable);
        // ---------- Original Method ----------
        //mDataConnectionTracker.setDataOnRoamingEnabled(enable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.075 -0400", hash_original_method = "AC949E64AEE76B7FF936E7A1B08DF381", hash_generated_method = "DD18599D06BBC3260D0A483F0AE0FBA0")
     void onMMIDone(GsmMmiCode mmi) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var1EA6EA5746ECD4584B3A274E648709FA_1858828475 = (mPendingMMIs.remove(mmi) || mmi.isUssdRequest());
            {
                mMmiCompleteRegistrants.notifyRegistrants(
                new AsyncResult(null, mmi, null));
            } //End block
        } //End collapsed parenthetic
        addTaint(mmi.getTaint());
        // ---------- Original Method ----------
        //if (mPendingMMIs.remove(mmi) || mmi.isUssdRequest()) {
            //mMmiCompleteRegistrants.notifyRegistrants(
                //new AsyncResult(null, mmi, null));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.076 -0400", hash_original_method = "7B2BAD4339ABD08CFCEAE93D5F289166", hash_generated_method = "FD05A26848D851E06F917F392A8B9191")
    private void onNetworkInitiatedUssd(GsmMmiCode mmi) {
        mMmiCompleteRegistrants.notifyRegistrants(
            new AsyncResult(null, mmi, null));
        addTaint(mmi.getTaint());
        // ---------- Original Method ----------
        //mMmiCompleteRegistrants.notifyRegistrants(
            //new AsyncResult(null, mmi, null));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.077 -0400", hash_original_method = "FA8827AA61AE68EAA1082E2A36657BA2", hash_generated_method = "EB310289B07AC3B65FAD36DDC169028D")
    private void onIncomingUSSD(int ussdMode, String ussdMessage) {
        boolean isUssdError;
        boolean isUssdRequest;
        isUssdRequest
            = (ussdMode == CommandsInterface.USSD_MODE_REQUEST);
        isUssdError
            = (ussdMode != CommandsInterface.USSD_MODE_NOTIFY
                && ussdMode != CommandsInterface.USSD_MODE_REQUEST);
        GsmMmiCode found = null;
        {
            int i = 0;
            int s = mPendingMMIs.size();
            {
                {
                    boolean varA016EF5F6E1ECC7C98CFC15BB240BDED_1964955605 = (mPendingMMIs.get(i).isPendingUSSD());
                    {
                        found = mPendingMMIs.get(i);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            {
                found.onUssdFinishedError();
            } //End block
            {
                found.onUssdFinished(ussdMessage, isUssdRequest);
            } //End block
        } //End block
        {
            {
                GsmMmiCode mmi;
                mmi = GsmMmiCode.newNetworkInitiatedUssd(ussdMessage,
                                                   isUssdRequest,
                                                   GSMPhone.this);
                onNetworkInitiatedUssd(mmi);
            } //End block
        } //End block
        addTaint(ussdMode);
        addTaint(ussdMessage.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.078 -0400", hash_original_method = "B501A93D9CBCF588AB28D650AA03E986", hash_generated_method = "7C4535C627B55A959011CDB01A08021D")
    protected void syncClirSetting() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        int clirSetting = sp.getInt(CLIR_KEY, -1);
        {
            mCM.setCLIR(clirSetting, null);
        } //End block
        // ---------- Original Method ----------
        //SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        //int clirSetting = sp.getInt(CLIR_KEY, -1);
        //if (clirSetting >= 0) {
            //mCM.setCLIR(clirSetting, null);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.079 -0400", hash_original_method = "EA4D9CE5B4912647996EC04703971BF3", hash_generated_method = "4337191265CE5DBB60D70D92CDB47EDD")
    @Override
    public void handleMessage(Message msg) {
        AsyncResult ar;
        Message onComplete;
        //Begin case EVENT_RADIO_AVAILABLE 
        {
            mCM.getBasebandVersion(
                        obtainMessage(EVENT_GET_BASEBAND_VERSION_DONE));
            mCM.getIMEI(obtainMessage(EVENT_GET_IMEI_DONE));
            mCM.getIMEISV(obtainMessage(EVENT_GET_IMEISV_DONE));
        } //End block
        //End case EVENT_RADIO_AVAILABLE 
        //Begin case EVENT_REGISTERED_TO_NETWORK 
        syncClirSetting();
        //End case EVENT_REGISTERED_TO_NETWORK 
        //Begin case EVENT_SIM_RECORDS_LOADED 
        updateCurrentCarrierInProvider();
        //End case EVENT_SIM_RECORDS_LOADED 
        //Begin case EVENT_SIM_RECORDS_LOADED 
        String imsi = getVmSimImsi();
        //End case EVENT_SIM_RECORDS_LOADED 
        //Begin case EVENT_SIM_RECORDS_LOADED 
        String imsiFromSIM = getSubscriberId();
        //End case EVENT_SIM_RECORDS_LOADED 
        //Begin case EVENT_SIM_RECORDS_LOADED 
        {
            boolean var3AAC275703146E8A94381DBD8E1509A5_538032659 = (imsi != null && imsiFromSIM != null && !imsiFromSIM.equals(imsi));
            {
                storeVoiceMailNumber(null);
                setVmSimImsi(null);
            } //End block
        } //End collapsed parenthetic
        //End case EVENT_SIM_RECORDS_LOADED 
        //Begin case EVENT_GET_BASEBAND_VERSION_DONE 
        ar = (AsyncResult)msg.obj;
        //End case EVENT_GET_BASEBAND_VERSION_DONE 
        //Begin case EVENT_GET_BASEBAND_VERSION_DONE 
        Log.d(LOG_TAG, "Baseband version: " + ar.result);
        //End case EVENT_GET_BASEBAND_VERSION_DONE 
        //Begin case EVENT_GET_BASEBAND_VERSION_DONE 
        setSystemProperty(PROPERTY_BASEBAND_VERSION, (String)ar.result);
        //End case EVENT_GET_BASEBAND_VERSION_DONE 
        //Begin case EVENT_GET_IMEI_DONE 
        ar = (AsyncResult)msg.obj;
        //End case EVENT_GET_IMEI_DONE 
        //Begin case EVENT_GET_IMEI_DONE 
        mImei = (String)ar.result;
        //End case EVENT_GET_IMEI_DONE 
        //Begin case EVENT_GET_IMEISV_DONE 
        ar = (AsyncResult)msg.obj;
        //End case EVENT_GET_IMEISV_DONE 
        //Begin case EVENT_GET_IMEISV_DONE 
        mImeiSv = (String)ar.result;
        //End case EVENT_GET_IMEISV_DONE 
        //Begin case EVENT_USSD 
        ar = (AsyncResult)msg.obj;
        //End case EVENT_USSD 
        //Begin case EVENT_USSD 
        String[] ussdResult = (String[]) ar.result;
        //End case EVENT_USSD 
        //Begin case EVENT_USSD 
        {
            try 
            {
                onIncomingUSSD(Integer.parseInt(ussdResult[0]), ussdResult[1]);
            } //End block
            catch (NumberFormatException e)
            { }
        } //End block
        //End case EVENT_USSD 
        //Begin case EVENT_RADIO_OFF_OR_NOT_AVAILABLE 
        {
            int i = 0;
            int s = mPendingMMIs.size();
            {
                {
                    boolean varA016EF5F6E1ECC7C98CFC15BB240BDED_1611229531 = (mPendingMMIs.get(i).isPendingUSSD());
                    {
                        mPendingMMIs.get(i).onUssdFinishedError();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        //End case EVENT_RADIO_OFF_OR_NOT_AVAILABLE 
        //Begin case EVENT_SSN 
        ar = (AsyncResult)msg.obj;
        //End case EVENT_SSN 
        //Begin case EVENT_SSN 
        SuppServiceNotification not = (SuppServiceNotification) ar.result;
        //End case EVENT_SSN 
        //Begin case EVENT_SSN 
        mSsnRegistrants.notifyRegistrants(ar);
        //End case EVENT_SSN 
        //Begin case EVENT_SET_CALL_FORWARD_DONE 
        ar = (AsyncResult)msg.obj;
        //End case EVENT_SET_CALL_FORWARD_DONE 
        //Begin case EVENT_SET_CALL_FORWARD_DONE 
        {
            mIccRecords.setVoiceCallForwardingFlag(1, msg.arg1 == 1);
        } //End block
        //End case EVENT_SET_CALL_FORWARD_DONE 
        //Begin case EVENT_SET_CALL_FORWARD_DONE 
        onComplete = (Message) ar.userObj;
        //End case EVENT_SET_CALL_FORWARD_DONE 
        //Begin case EVENT_SET_CALL_FORWARD_DONE 
        {
            AsyncResult.forMessage(onComplete, ar.result, ar.exception);
            onComplete.sendToTarget();
        } //End block
        //End case EVENT_SET_CALL_FORWARD_DONE 
        //Begin case EVENT_SET_VM_NUMBER_DONE 
        ar = (AsyncResult)msg.obj;
        //End case EVENT_SET_VM_NUMBER_DONE 
        //Begin case EVENT_SET_VM_NUMBER_DONE 
        {
            boolean varAE18DF4A9D4BF791512D5DD4EB3D1497_1232522724 = (IccVmNotSupportedException.class.isInstance(ar.exception));
            {
                storeVoiceMailNumber(mVmNumber);
                ar.exception = null;
            } //End block
        } //End collapsed parenthetic
        //End case EVENT_SET_VM_NUMBER_DONE 
        //Begin case EVENT_SET_VM_NUMBER_DONE 
        onComplete = (Message) ar.userObj;
        //End case EVENT_SET_VM_NUMBER_DONE 
        //Begin case EVENT_SET_VM_NUMBER_DONE 
        {
            AsyncResult.forMessage(onComplete, ar.result, ar.exception);
            onComplete.sendToTarget();
        } //End block
        //End case EVENT_SET_VM_NUMBER_DONE 
        //Begin case EVENT_GET_CALL_FORWARD_DONE 
        ar = (AsyncResult)msg.obj;
        //End case EVENT_GET_CALL_FORWARD_DONE 
        //Begin case EVENT_GET_CALL_FORWARD_DONE 
        {
            handleCfuQueryResult((CallForwardInfo[])ar.result);
        } //End block
        //End case EVENT_GET_CALL_FORWARD_DONE 
        //Begin case EVENT_GET_CALL_FORWARD_DONE 
        onComplete = (Message) ar.userObj;
        //End case EVENT_GET_CALL_FORWARD_DONE 
        //Begin case EVENT_GET_CALL_FORWARD_DONE 
        {
            AsyncResult.forMessage(onComplete, ar.result, ar.exception);
            onComplete.sendToTarget();
        } //End block
        //End case EVENT_GET_CALL_FORWARD_DONE 
        //Begin case EVENT_SET_NETWORK_MANUAL_COMPLETE EVENT_SET_NETWORK_AUTOMATIC_COMPLETE 
        handleSetSelectNetwork((AsyncResult) msg.obj);
        //End case EVENT_SET_NETWORK_MANUAL_COMPLETE EVENT_SET_NETWORK_AUTOMATIC_COMPLETE 
        //Begin case EVENT_SET_CLIR_COMPLETE 
        ar = (AsyncResult)msg.obj;
        //End case EVENT_SET_CLIR_COMPLETE 
        //Begin case EVENT_SET_CLIR_COMPLETE 
        {
            saveClirSetting(msg.arg1);
        } //End block
        //End case EVENT_SET_CLIR_COMPLETE 
        //Begin case EVENT_SET_CLIR_COMPLETE 
        onComplete = (Message) ar.userObj;
        //End case EVENT_SET_CLIR_COMPLETE 
        //Begin case EVENT_SET_CLIR_COMPLETE 
        {
            AsyncResult.forMessage(onComplete, ar.result, ar.exception);
            onComplete.sendToTarget();
        } //End block
        //End case EVENT_SET_CLIR_COMPLETE 
        //Begin case default 
        super.handleMessage(msg);
        //End case default 
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.080 -0400", hash_original_method = "0F23F53D1861BCD51C7CF85FD75916D2", hash_generated_method = "A35D1F676C86866684C3599568039FBF")
     boolean updateCurrentCarrierInProvider() {
        {
            try 
            {
                Uri uri = Uri.withAppendedPath(Telephony.Carriers.CONTENT_URI, "current");
                ContentValues map = new ContentValues();
                map.put(Telephony.Carriers.NUMERIC, mIccRecords.getOperatorNumeric());
                mContext.getContentResolver().insert(uri, map);
            } //End block
            catch (SQLException e)
            { }
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1402905015 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1402905015;
        // ---------- Original Method ----------
        //if (mIccRecords != null) {
            //try {
                //Uri uri = Uri.withAppendedPath(Telephony.Carriers.CONTENT_URI, "current");
                //ContentValues map = new ContentValues();
                //map.put(Telephony.Carriers.NUMERIC, mIccRecords.getOperatorNumeric());
                //mContext.getContentResolver().insert(uri, map);
                //return true;
            //} catch (SQLException e) {
                //Log.e(LOG_TAG, "Can't store current operator", e);
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.081 -0400", hash_original_method = "8C87E0C6EBD471788AC0CD93A9D4E893", hash_generated_method = "C563DDAD943199DCAD50BCD868DF394C")
    private void handleSetSelectNetwork(AsyncResult ar) {
        {
            Log.d(LOG_TAG, "unexpected result from user object.");
        } //End block
        NetworkSelectMessage nsm = (NetworkSelectMessage) ar.userObj;
        {
            Log.d(LOG_TAG, "sending original message to recipient");
            AsyncResult.forMessage(nsm.message, ar.result, ar.exception);
            nsm.message.sendToTarget();
        } //End block
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(NETWORK_SELECTION_KEY, nsm.operatorNumeric);
        editor.putString(NETWORK_SELECTION_NAME_KEY, nsm.operatorAlphaLong);
        {
            boolean var15A115D7A2E98F40805CADB6914BBE5F_1566914404 = (! editor.commit());
        } //End collapsed parenthetic
        addTaint(ar.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.082 -0400", hash_original_method = "C8B4A3CF4267A4CC2FA2952E385D70CE", hash_generated_method = "F15AF2097C5E52D0B15620080705D859")
    public void saveClirSetting(int commandInterfaceCLIRMode) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(CLIR_KEY, commandInterfaceCLIRMode);
        {
            boolean var15A115D7A2E98F40805CADB6914BBE5F_1504065918 = (! editor.commit());
        } //End collapsed parenthetic
        addTaint(commandInterfaceCLIRMode);
        // ---------- Original Method ----------
        //SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        //SharedPreferences.Editor editor = sp.edit();
        //editor.putInt(CLIR_KEY, commandInterfaceCLIRMode);
        //if (! editor.commit()) {
            //Log.e(LOG_TAG, "failed to commit CLIR preference");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.083 -0400", hash_original_method = "5FFF1291CED37081608080EEE820D6BC", hash_generated_method = "DD21B7530D105156CF136145DE723BC2")
    private void handleCfuQueryResult(CallForwardInfo[] infos) {
        {
            mIccRecords.setVoiceCallForwardingFlag(1, false);
        } //End block
        {
            {
                int i = 0;
                int s = infos.length;
                {
                    {
                        mIccRecords.setVoiceCallForwardingFlag(1, (infos[i].status == 1));
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(infos[0].getTaint());
        // ---------- Original Method ----------
        //if (infos == null || infos.length == 0) {
            //mIccRecords.setVoiceCallForwardingFlag(1, false);
        //} else {
            //for (int i = 0, s = infos.length; i < s; i++) {
                //if ((infos[i].serviceClass & SERVICE_CLASS_VOICE) != 0) {
                    //mIccRecords.setVoiceCallForwardingFlag(1, (infos[i].status == 1));
                    //break;
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.084 -0400", hash_original_method = "4BF16EE42BDE3709043B0CD4BA1346D5", hash_generated_method = "CD128DE94D8B9311158BD10630BA7240")
    public PhoneSubInfo getPhoneSubInfo() {
        PhoneSubInfo varB4EAC82CA7396A68D541C85D26508E83_464770790 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_464770790 = mSubInfo;
        varB4EAC82CA7396A68D541C85D26508E83_464770790.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_464770790;
        // ---------- Original Method ----------
        //return mSubInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.085 -0400", hash_original_method = "3207E33C673BD37AF8FDF81E31830AE6", hash_generated_method = "1E34778A82603F232B89B4806A18138F")
    public IccSmsInterfaceManager getIccSmsInterfaceManager() {
        IccSmsInterfaceManager varB4EAC82CA7396A68D541C85D26508E83_884688306 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_884688306 = mSimSmsIntManager;
        varB4EAC82CA7396A68D541C85D26508E83_884688306.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_884688306;
        // ---------- Original Method ----------
        //return mSimSmsIntManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.086 -0400", hash_original_method = "6E6477AE345E3D007CED20614912A5C4", hash_generated_method = "533A1A47360340F0F21ED11EEAA69ACA")
    public IccPhoneBookInterfaceManager getIccPhoneBookInterfaceManager() {
        IccPhoneBookInterfaceManager varB4EAC82CA7396A68D541C85D26508E83_999296483 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_999296483 = mSimPhoneBookIntManager;
        varB4EAC82CA7396A68D541C85D26508E83_999296483.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_999296483;
        // ---------- Original Method ----------
        //return mSimPhoneBookIntManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.086 -0400", hash_original_method = "515987807F65054AFA6AA9A268DDB599", hash_generated_method = "74AE427F2FE96DFDE4F5E1F2CB6394E2")
    public IccFileHandler getIccFileHandler() {
        IccFileHandler varB4EAC82CA7396A68D541C85D26508E83_1882433339 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1882433339 = this.mIccFileHandler;
        varB4EAC82CA7396A68D541C85D26508E83_1882433339.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1882433339;
        // ---------- Original Method ----------
        //return this.mIccFileHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.086 -0400", hash_original_method = "93A82B64CE4B13442120BE4FDBB45597", hash_generated_method = "E12DDFC0154755786ACB8EB6DEF86590")
    public void activateCellBroadcastSms(int activate, Message response) {
        response.sendToTarget();
        addTaint(activate);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[GSMPhone] activateCellBroadcastSms() is obsolete; use SmsManager");
        //response.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.087 -0400", hash_original_method = "67DD91319C4A7AB6B9A5C1E784682816", hash_generated_method = "A4A79E53CFABE50528F1F6B4B8F32765")
    public void getCellBroadcastSmsConfig(Message response) {
        response.sendToTarget();
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[GSMPhone] getCellBroadcastSmsConfig() is obsolete; use SmsManager");
        //response.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.087 -0400", hash_original_method = "1D706FBF2447232FA856B129DB0956D5", hash_generated_method = "6F5D42CA3C311376A4E323F5CA7ECBD8")
    public void setCellBroadcastSmsConfig(int[] configValuesArray, Message response) {
        response.sendToTarget();
        addTaint(configValuesArray[0]);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[GSMPhone] setCellBroadcastSmsConfig() is obsolete; use SmsManager");
        //response.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.087 -0400", hash_original_method = "99B79EB3DF02CDEF6145664CC8FD0F29", hash_generated_method = "282CAC1F644E431C169BAF137153FC50")
    public boolean isCspPlmnEnabled() {
        boolean varDB15A307B35D48340572A8BACE2EEC2D_709904568 = (mIccRecords.isCspPlmnEnabled());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_581842832 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_581842832;
        // ---------- Original Method ----------
        //return mIccRecords.isCspPlmnEnabled();
    }

    
    private static class NetworkSelectMessage {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.087 -0400", hash_original_field = "78E731027D8FD50ED642340B7C9A63B3", hash_generated_field = "81254C6170A9E52E0AD3BB76A481765A")

        public Message message;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.087 -0400", hash_original_field = "283D783309AC858AFD001B18F5F912C5", hash_generated_field = "8CA2393560EE8C751F612DF94EBF8B4B")

        public String operatorNumeric;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.087 -0400", hash_original_field = "EBA1AB368B4E5EA262B356E9FEB5DBFF", hash_generated_field = "D8A2785302661C77D4C9BAD0912DCC8E")

        public String operatorAlphaLong;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.087 -0400", hash_original_method = "3039E12EC83A8AA31D55051619D54055", hash_generated_method = "3039E12EC83A8AA31D55051619D54055")
        public NetworkSelectMessage ()
        {
            //Synthesized constructor
        }


    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.087 -0400", hash_original_field = "41EBE7F32B96C1E2E9C209710486A443", hash_generated_field = "B8386CD6D900777C9D6A0A5CA1D0B217")

    static final String LOG_TAG = "GSM";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.087 -0400", hash_original_field = "7F1E46EB212D9379AF8B593E529EF4C2", hash_generated_field = "F62F4824E5D90C8C9780C2AB171AAEE3")

    private static final boolean LOCAL_DEBUG = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.087 -0400", hash_original_field = "EF81B5D96B53AEF2D500834A3DA6EF48", hash_generated_field = "F3DA441E75937751070EF22397051A39")

    public static final String CIPHERING_KEY = "ciphering_key";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.087 -0400", hash_original_field = "E66EAE6BBE4F2F42919E1A4E2896F710", hash_generated_field = "9B3C30C83DCADEE3DE0A0EB64ED01323")

    public static final String VM_NUMBER = "vm_number_key";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.087 -0400", hash_original_field = "B8DF52CD1BE962208AFE9FAF61C00759", hash_generated_field = "45605E617A76B49A021FF496D3F936B3")

    public static final String VM_SIM_IMSI = "vm_sim_imsi_key";
}

