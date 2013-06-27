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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.697 -0400", hash_original_field = "1D14D2D55BC367CD6AE3740CDB7152AF", hash_generated_field = "7E950EFC4355B7AA0B0D4941C05A3E53")

    GsmCallTracker mCT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.697 -0400", hash_original_field = "72BFF8190B34BEEE16406717B341412A", hash_generated_field = "AE636E648E782E05B0819C59ED7424AB")

    GsmServiceStateTracker mSST;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.697 -0400", hash_original_field = "F908D4D8A62B20E1013F1B849891738F", hash_generated_field = "CBD9585363E06B1CD5BA731CBD0F7A80")

    CatService mStkService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.697 -0400", hash_original_field = "00ADA57B43BDE5C478787B959A96A0CB", hash_generated_field = "16CBC86166E203C30D8494A6E3AFFFBC")

    ArrayList <GsmMmiCode> mPendingMMIs = new ArrayList<GsmMmiCode>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.697 -0400", hash_original_field = "212535A59AA4026EB1840135D5A6A54C", hash_generated_field = "BBEE3B2E599EE94DA4981B9B890C1513")

    SimPhoneBookInterfaceManager mSimPhoneBookIntManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.697 -0400", hash_original_field = "D5309C419B424DD63B187C852A2C29B9", hash_generated_field = "3969837BA2D4BBD6356E9579AAD42F25")

    SimSmsInterfaceManager mSimSmsIntManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.697 -0400", hash_original_field = "2C01F66E136181E8D582317306CCAC30", hash_generated_field = "F066FAD7B5AEEA27E2872ED159BF1CA4")

    PhoneSubInfo mSubInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.697 -0400", hash_original_field = "B70FAC06870FA211D668F462A2DBA212", hash_generated_field = "126D29D3ACD6141B3CF1C156D9BC8C27")

    Registrant mPostDialHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.697 -0400", hash_original_field = "F3323DA9DC0741EA4D28240971AFB640", hash_generated_field = "53A51CC9ADC1518A34F3208AF5D19A18")

    RegistrantList mSsnRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.697 -0400", hash_original_field = "DD2963357D2DA6A58CA505E758F62F10", hash_generated_field = "74116952885B195B8407FD19FB3B03C8")

    Thread debugPortThread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.697 -0400", hash_original_field = "0AF201A4B355A633BEDC98F2C2779D46", hash_generated_field = "B2950783CBB152418ABB498147763A3B")

    ServerSocket debugSocket;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.697 -0400", hash_original_field = "453C2995A2CC7C51188981A0F3965EED", hash_generated_field = "21C761E6867BA70678F0E7ADB70A1FBD")

    private String mImei;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.697 -0400", hash_original_field = "225448F5B7EE27E6F9CC21B80A6466DB", hash_generated_field = "B9E6756233427283AB4830B86393B4EE")

    private String mImeiSv;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.697 -0400", hash_original_field = "9B277DEC9B14E7B002627F05BEB0402A", hash_generated_field = "C290BF4C64FB14015B233D46098DB0A5")

    private String mVmNumber;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.698 -0400", hash_original_method = "996B91F3E8316CE3D841721FC6425644", hash_generated_method = "63B323EEC1874ED8DC5201890D3F8220")
    public  GSMPhone(Context context, CommandsInterface ci, PhoneNotifier notifier) {
        this(context,ci,notifier, false);
        addTaint(context.getTaint());
        addTaint(ci.getTaint());
        addTaint(notifier.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.701 -0400", hash_original_method = "E0F14E16A0D8C4916EDEAC018BF6C407", hash_generated_method = "38394946E69A8244E815DBE5D8BB6288")
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
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.701 -0400", hash_original_method = "4E77C2C2171044E4A2A86AC9695E0AD3", hash_generated_method = "344719F817D0045DB5D27299E79C4A7B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.712 -0400", hash_original_method = "CEF48F17C6DF6ACB05893EA0A2EE33F8", hash_generated_method = "B71D38D11653193226E3F8E6531ACE0E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.713 -0400", hash_original_method = "F5F23F3B17FF3156952338384B3C94C7", hash_generated_method = "C0585341C604244A83CFF366F7C62C3E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.718 -0400", hash_original_method = "B0A9A9B5818DC886F2534146C8893E7F", hash_generated_method = "346B68F817EC52430AB8DB08BE054D6D")
    protected void finalize() {
        Log.d(LOG_TAG, "GSMPhone finalized");
        // ---------- Original Method ----------
        //if(LOCAL_DEBUG) Log.d(LOG_TAG, "GSMPhone finalized");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.719 -0400", hash_original_method = "DA0F221C2247572C4D631280E4033E9A", hash_generated_method = "E5D80BFEEC99F937E9F143BEAFFD2AEC")
    public ServiceState getServiceState() {
        ServiceState varB4EAC82CA7396A68D541C85D26508E83_971733678 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_971733678 = mSST.ss;
        varB4EAC82CA7396A68D541C85D26508E83_971733678.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_971733678;
        // ---------- Original Method ----------
        //return mSST.ss;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.724 -0400", hash_original_method = "E38329BE2FF507326358BBAF596945E6", hash_generated_method = "C8D95CEBCF08B3EC7D2C0D2744C1284A")
    public CellLocation getCellLocation() {
        CellLocation varB4EAC82CA7396A68D541C85D26508E83_1175477124 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1175477124 = mSST.cellLoc;
        varB4EAC82CA7396A68D541C85D26508E83_1175477124.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1175477124;
        // ---------- Original Method ----------
        //return mSST.cellLoc;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.724 -0400", hash_original_method = "8AEFB373111A9C8AD30F3E8C75C461D2", hash_generated_method = "66FCAEB45DA22FE9A1C0E264B0DE0C67")
    public Phone.State getState() {
        Phone.State varB4EAC82CA7396A68D541C85D26508E83_930724278 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_930724278 = mCT.state;
        varB4EAC82CA7396A68D541C85D26508E83_930724278.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_930724278;
        // ---------- Original Method ----------
        //return mCT.state;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.724 -0400", hash_original_method = "59C2B6A3B95086A76D74A4AD572CD9E8", hash_generated_method = "EC448905EB18C4734CAAB7B7762A1CA0")
    public String getPhoneName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1280000392 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1280000392 = "GSM";
        varB4EAC82CA7396A68D541C85D26508E83_1280000392.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1280000392;
        // ---------- Original Method ----------
        //return "GSM";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.725 -0400", hash_original_method = "8F0362114FB07F54B581B179D597F815", hash_generated_method = "374E522170D3EDF18A7CCC4169DBEF55")
    public int getPhoneType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1402166443 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1402166443;
        // ---------- Original Method ----------
        //return Phone.PHONE_TYPE_GSM;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.725 -0400", hash_original_method = "46D9BC6E3280014832CD8FC523C20E6E", hash_generated_method = "ECD9C56138FA17434C9D5DE819E5FB30")
    public SignalStrength getSignalStrength() {
        SignalStrength varB4EAC82CA7396A68D541C85D26508E83_1678948460 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1678948460 = mSST.mSignalStrength;
        varB4EAC82CA7396A68D541C85D26508E83_1678948460.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1678948460;
        // ---------- Original Method ----------
        //return mSST.mSignalStrength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.730 -0400", hash_original_method = "79AFD9B845E4547B981131DAC9E3A14D", hash_generated_method = "4913BC5F1DCB693B4CF8A5557603357C")
    public CallTracker getCallTracker() {
        CallTracker varB4EAC82CA7396A68D541C85D26508E83_1186910550 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1186910550 = mCT;
        varB4EAC82CA7396A68D541C85D26508E83_1186910550.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1186910550;
        // ---------- Original Method ----------
        //return mCT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.731 -0400", hash_original_method = "BD481539215D5A66E62B4E6909625141", hash_generated_method = "77421A4AB56D078CFE021CD9FDC5F8E5")
    public ServiceStateTracker getServiceStateTracker() {
        ServiceStateTracker varB4EAC82CA7396A68D541C85D26508E83_1726532995 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1726532995 = mSST;
        varB4EAC82CA7396A68D541C85D26508E83_1726532995.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1726532995;
        // ---------- Original Method ----------
        //return mSST;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.731 -0400", hash_original_method = "077104DE86BE536BE2C981492E640B74", hash_generated_method = "F0E37AADD024C02CF1A14940D946EDBA")
    public List<? extends MmiCode> getPendingMmiCodes() {
        List<? extends MmiCode> varB4EAC82CA7396A68D541C85D26508E83_103237830 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_103237830 = mPendingMMIs;
        varB4EAC82CA7396A68D541C85D26508E83_103237830.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_103237830;
        // ---------- Original Method ----------
        //return mPendingMMIs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.737 -0400", hash_original_method = "7454904C7C93C1818F679756511639F1", hash_generated_method = "0EBD80E5979C52DA3ABB5B535A1511D3")
    public DataState getDataConnectionState(String apnType) {
        DataState varB4EAC82CA7396A68D541C85D26508E83_1600142260 = null; //Variable for return #1
        DataState ret;
        ret = DataState.DISCONNECTED;
        {
            ret = DataState.DISCONNECTED;
        } //End block
        {
            boolean var01D4A7B95FF96B8BA58C75CB12149B2D_738699727 = (mSST.getCurrentGprsState()
                != ServiceState.STATE_IN_SERVICE);
            {
                ret = DataState.DISCONNECTED;
            } //End block
            {
                boolean varEDC38D72B2381B58A0F3730E74C3817C_968348341 = (mDataConnectionTracker.isApnTypeEnabled(apnType) == false ||
                mDataConnectionTracker.isApnTypeActive(apnType) == false);
                {
                    ret = DataState.DISCONNECTED;
                } //End block
                {
                    {
                        Object var819139837D42C0AD62155AA1D23C5AD5_743961355 = (mDataConnectionTracker.getState(apnType));
                        //Begin case FAILED IDLE 
                        ret = DataState.DISCONNECTED;
                        //End case FAILED IDLE 
                        //Begin case CONNECTED DISCONNECTING 
                        {
                            boolean var398FF6E0DCA52B02F79A9CB272BA56EC_1630129852 = (mCT.state != Phone.State.IDLE
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
        varB4EAC82CA7396A68D541C85D26508E83_1600142260 = ret;
        addTaint(apnType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1600142260.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1600142260;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.738 -0400", hash_original_method = "1B8E5DE4B6A16D073AB6DF5ECB4F317E", hash_generated_method = "0EB9D03CD7848E091D82959A36A0DD44")
    public DataActivityState getDataActivityState() {
        DataActivityState varB4EAC82CA7396A68D541C85D26508E83_2081851761 = null; //Variable for return #1
        DataActivityState ret;
        ret = DataActivityState.NONE;
        {
            boolean var1BD7F40DFB9082C5149DCE8D977AF125_1078240505 = (mSST.getCurrentGprsState() == ServiceState.STATE_IN_SERVICE);
            {
                {
                    Object var27C7E0FDBE09DE35AC2FD606F73591E2_697320825 = (mDataConnectionTracker.getActivity());
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
        varB4EAC82CA7396A68D541C85D26508E83_2081851761 = ret;
        varB4EAC82CA7396A68D541C85D26508E83_2081851761.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2081851761;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.738 -0400", hash_original_method = "812A77A153EDB691C43A0B58CAFAA77A", hash_generated_method = "AB35579F49622E7A241F12B7DDB4EC19")
     void notifyPhoneStateChanged() {
        mNotifier.notifyPhoneState(this);
        // ---------- Original Method ----------
        //mNotifier.notifyPhoneState(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.738 -0400", hash_original_method = "3EB8461625C29B29FD6CB8E5D60B43F3", hash_generated_method = "D04CBC6D94303085010D6FD72DFDF138")
     void notifyPreciseCallStateChanged() {
        super.notifyPreciseCallStateChangedP();
        // ---------- Original Method ----------
        //super.notifyPreciseCallStateChangedP();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.739 -0400", hash_original_method = "292444BE96E352C8E8312B338E19EF02", hash_generated_method = "9CAE80423F167649B545BC55A8273188")
     void notifyNewRingingConnection(Connection c) {
        super.notifyNewRingingConnectionP(c);
        addTaint(c.getTaint());
        // ---------- Original Method ----------
        //super.notifyNewRingingConnectionP(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.739 -0400", hash_original_method = "1858091673D3A4B62C058FCC91892C36", hash_generated_method = "0756798023112E23775C5ED34868F8B8")
     void notifyDisconnect(Connection cn) {
        mDisconnectRegistrants.notifyResult(cn);
        addTaint(cn.getTaint());
        // ---------- Original Method ----------
        //mDisconnectRegistrants.notifyResult(cn);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.739 -0400", hash_original_method = "4DFA3B176AED92FABCFB596FBC88C127", hash_generated_method = "78FF0EBB369D5E48C88943009DE8A38C")
     void notifyUnknownConnection() {
        mUnknownConnectionRegistrants.notifyResult(this);
        // ---------- Original Method ----------
        //mUnknownConnectionRegistrants.notifyResult(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.739 -0400", hash_original_method = "952D093251486E722309085461233179", hash_generated_method = "0D459839BFD4CE2D513A693B187FDF40")
     void notifySuppServiceFailed(SuppService code) {
        mSuppServiceFailedRegistrants.notifyResult(code);
        addTaint(code.getTaint());
        // ---------- Original Method ----------
        //mSuppServiceFailedRegistrants.notifyResult(code);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.744 -0400", hash_original_method = "73E7BFF04E4E9785E6146409272926BA", hash_generated_method = "A54D16F558EC12982CF56FB0933CD181")
     void notifyServiceStateChanged(ServiceState ss) {
        super.notifyServiceStateChangedP(ss);
        addTaint(ss.getTaint());
        // ---------- Original Method ----------
        //super.notifyServiceStateChangedP(ss);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.744 -0400", hash_original_method = "482FE18FBD1949DAF708F2E65940DE8F", hash_generated_method = "0723685B826BB9996EC0449E7B1A8FCF")
     void notifyLocationChanged() {
        mNotifier.notifyCellLocation(this);
        // ---------- Original Method ----------
        //mNotifier.notifyCellLocation(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.745 -0400", hash_original_method = "FCBAE539BB72BE21647FF37299DC2B96", hash_generated_method = "0C6B7A0FF6350CF17887F3D234BB96C8")
     void notifySignalStrength() {
        mNotifier.notifySignalStrength(this);
        // ---------- Original Method ----------
        //mNotifier.notifySignalStrength(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.745 -0400", hash_original_method = "25487D51A5547C84DC8EEF33482B43EF", hash_generated_method = "C35621F7AF385D2C45B899F83A20A075")
    public void notifyCallForwardingIndicator() {
        mNotifier.notifyCallForwardingChanged(this);
        // ---------- Original Method ----------
        //mNotifier.notifyCallForwardingChanged(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.750 -0400", hash_original_method = "C4157CB043EC8B3384F8270EB7DCD5BB", hash_generated_method = "159F2D28E3AC8B75EED9336F04B42E2B")
    public final void setSystemProperty(String property, String value) {
        super.setSystemProperty(property, value);
        addTaint(property.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //super.setSystemProperty(property, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.750 -0400", hash_original_method = "02E1DF9EF058739EC655251AF002C09F", hash_generated_method = "CE73E8E822E1F93FA41B9B2B00013C0C")
    public void registerForSuppServiceNotification(
            Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mSsnRegistrants.addUnique(h, what, obj);
        {
            boolean varFAB3B0CB4521CD623976F107F015373C_649325427 = (mSsnRegistrants.size() == 1);
            mCM.setSuppServiceNotifications(true, null);
        } //End collapsed parenthetic
        addTaint(h.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mSsnRegistrants.addUnique(h, what, obj);
        //if (mSsnRegistrants.size() == 1) mCM.setSuppServiceNotifications(true, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.750 -0400", hash_original_method = "001FDCA2544BEBF92715B871E5466F8E", hash_generated_method = "3EBBAF94410A7BA1BF33802A488EEFC7")
    public void unregisterForSuppServiceNotification(Handler h) {
        mSsnRegistrants.remove(h);
        {
            boolean varB3BC4AC108FB9749A749F1E20FAFF8A8_810779763 = (mSsnRegistrants.size() == 0);
            mCM.setSuppServiceNotifications(false, null);
        } //End collapsed parenthetic
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //mSsnRegistrants.remove(h);
        //if (mSsnRegistrants.size() == 0) mCM.setSuppServiceNotifications(false, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.751 -0400", hash_original_method = "C62CCD6CF2D9D7F7FA17BB7B58067AAC", hash_generated_method = "229941362132B3EA463C13061274E96C")
    public void acceptCall() throws CallStateException {
        mCT.acceptCall();
        // ---------- Original Method ----------
        //mCT.acceptCall();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.751 -0400", hash_original_method = "A64616985F0D82C6750D71CF8DADC6F4", hash_generated_method = "35B0F59F3248405A594AAB683856BD2F")
    public void rejectCall() throws CallStateException {
        mCT.rejectCall();
        // ---------- Original Method ----------
        //mCT.rejectCall();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.751 -0400", hash_original_method = "4BD56579DA53A7A8E0646A63E1978FC8", hash_generated_method = "4EFDBB8DAC4DC308937F3C30BD26241D")
    public void switchHoldingAndActive() throws CallStateException {
        mCT.switchWaitingOrHoldingAndActive();
        // ---------- Original Method ----------
        //mCT.switchWaitingOrHoldingAndActive();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.756 -0400", hash_original_method = "01AA81103C1764FB5FE5BC7D2791F36E", hash_generated_method = "B2AE0CA21618C6A6397A0B5BFB81F4E0")
    public boolean canConference() {
        boolean var62676EA7A977651B04FEF7B6AA776FCC_1941062940 = (mCT.canConference());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_671873415 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_671873415;
        // ---------- Original Method ----------
        //return mCT.canConference();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.756 -0400", hash_original_method = "27A0C6F6921751B2F5D5EAA31130917E", hash_generated_method = "74CEBD63CA8B98FCC2DA9D5F0D46AC3A")
    public boolean canDial() {
        boolean var17F304E4F3B49DB2D1D736D9DD207194_1912931259 = (mCT.canDial());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1603850582 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1603850582;
        // ---------- Original Method ----------
        //return mCT.canDial();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.757 -0400", hash_original_method = "ED1426E2C308CED60BE3C0151AD877C7", hash_generated_method = "2CFDCF5C26A4C2BD5811B87BFB8C4AB4")
    public void conference() throws CallStateException {
        mCT.conference();
        // ---------- Original Method ----------
        //mCT.conference();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.757 -0400", hash_original_method = "B9932A8A8BD16A4F0D461DDC6FDE6B49", hash_generated_method = "BEFA10EB4DBC56DB633604D1159E6D30")
    public void clearDisconnected() {
        mCT.clearDisconnected();
        // ---------- Original Method ----------
        //mCT.clearDisconnected();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.757 -0400", hash_original_method = "36A0747921C9C16BA6E56F404827E4EB", hash_generated_method = "5AD8712C2083DD247EBF46BA4ED29930")
    public boolean canTransfer() {
        boolean var8E3EEF73488C19B8AFD5D0569E1452B3_163913876 = (mCT.canTransfer());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_588592660 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_588592660;
        // ---------- Original Method ----------
        //return mCT.canTransfer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.757 -0400", hash_original_method = "844E9AE7DC0EF8644470861505601222", hash_generated_method = "C4108AEC931486BDFF732FB315DE5DD6")
    public void explicitCallTransfer() throws CallStateException {
        mCT.explicitCallTransfer();
        // ---------- Original Method ----------
        //mCT.explicitCallTransfer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.763 -0400", hash_original_method = "A46545098103F91B00276659EE365887", hash_generated_method = "2D61490610DF857BA5453C14D67E47ED")
    public GsmCall getForegroundCall() {
        GsmCall varB4EAC82CA7396A68D541C85D26508E83_933115515 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_933115515 = mCT.foregroundCall;
        varB4EAC82CA7396A68D541C85D26508E83_933115515.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_933115515;
        // ---------- Original Method ----------
        //return mCT.foregroundCall;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.763 -0400", hash_original_method = "142F0A4524F2CBB8716568AB3A761D12", hash_generated_method = "BAEB9530D6C18ED035D81E13113A09CC")
    public GsmCall getBackgroundCall() {
        GsmCall varB4EAC82CA7396A68D541C85D26508E83_1508233771 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1508233771 = mCT.backgroundCall;
        varB4EAC82CA7396A68D541C85D26508E83_1508233771.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1508233771;
        // ---------- Original Method ----------
        //return mCT.backgroundCall;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.764 -0400", hash_original_method = "F87806E8E26806695F0525D42F1D7DD4", hash_generated_method = "671AE1F6B139268AA8BDB5264DFD46FD")
    public GsmCall getRingingCall() {
        GsmCall varB4EAC82CA7396A68D541C85D26508E83_2097081584 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2097081584 = mCT.ringingCall;
        varB4EAC82CA7396A68D541C85D26508E83_2097081584.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2097081584;
        // ---------- Original Method ----------
        //return mCT.ringingCall;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.764 -0400", hash_original_method = "3A1042FC51BD24241CBFB1D3DBD11D23", hash_generated_method = "05C0AA8328F9EB50B81C519CD213EADD")
    private boolean handleCallDeflectionIncallSupplementaryService(
            String dialString) throws CallStateException {
        {
            boolean var599183C7EFEA223E987C253B1794A663_1730893833 = (dialString.length() > 1);
        } //End collapsed parenthetic
        {
            boolean varC3EC61EA57D8BAD50CBB2912B8C19CD0_1013012116 = (getRingingCall().getState() != GsmCall.State.IDLE);
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
                boolean var3939D4E7861BC6B97F7F3D876A35B1D2_1857272904 = (getBackgroundCall().getState() != GsmCall.State.IDLE);
                {
                    Log.d(LOG_TAG,
                    "MmiCode 0: hangupWaitingOrBackground");
                    mCT.hangupWaitingOrBackground();
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        addTaint(dialString.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_367588946 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_367588946;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.768 -0400", hash_original_method = "54841B6AA04B8F69693CDF35FACFE6EA", hash_generated_method = "88E7C964FC04699C10A1096AD8A9239E")
    private boolean handleCallWaitingIncallSupplementaryService(
            String dialString) throws CallStateException {
        int len;
        len = dialString.length();
        GsmCall call;
        call = (GsmCall) getForegroundCall();
        try 
        {
            {
                char ch;
                ch = dialString.charAt(1);
                int callIndex;
                callIndex = ch - '0';
                {
                    Log.d(LOG_TAG,
                            "MmiCode 1: hangupConnectionByIndex " +
                            callIndex);
                    mCT.hangupConnectionByIndex(call, callIndex);
                } //End block
            } //End block
            {
                {
                    boolean varAA260EC3CDDC603D103B4D5D62C46E51_1830520952 = (call.getState() != GsmCall.State.IDLE);
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1357424173 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1357424173;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.830 -0400", hash_original_method = "F4FAEC22329B0BDDF008B69FB760B2A4", hash_generated_method = "7802153E3CDBC91967F3EE6BD7C2C41B")
    private boolean handleCallHoldIncallSupplementaryService(String dialString) throws CallStateException {
        int len;
        len = dialString.length();
        GsmCall call;
        call = (GsmCall) getForegroundCall();
        {
            try 
            {
                char ch;
                ch = dialString.charAt(1);
                int callIndex;
                callIndex = ch - '0';
                GsmConnection conn;
                conn = mCT.getConnectionByIndex(call, callIndex);
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
                    boolean var3B586179DB1A75B5DE869C498B98014C_1668471981 = (getRingingCall().getState() != GsmCall.State.IDLE);
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_572131630 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_572131630;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.838 -0400", hash_original_method = "A61A93477751B5EFFB3B26065CE7F8F7", hash_generated_method = "3D0A002A1391A1B2B4021657B5F98882")
    private boolean handleMultipartyIncallSupplementaryService(
            String dialString) throws CallStateException {
        {
            boolean var599183C7EFEA223E987C253B1794A663_977830525 = (dialString.length() > 1);
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_46975374 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_46975374;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.839 -0400", hash_original_method = "D22F8E83AE3C2E24760F930E8B1C0AF8", hash_generated_method = "C29F5347FB89B7EB38AB99FDFA8FF4B7")
    private boolean handleEctIncallSupplementaryService(String dialString) throws CallStateException {
        int len;
        len = dialString.length();
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2057983906 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2057983906;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.839 -0400", hash_original_method = "F0B7315BB3E501E36AB72E6B89A34578", hash_generated_method = "ED47CC8312E9FB607C18472AF799CDA2")
    private boolean handleCcbsIncallSupplementaryService(String dialString) throws CallStateException {
        {
            boolean var599183C7EFEA223E987C253B1794A663_529524118 = (dialString.length() > 1);
        } //End collapsed parenthetic
        notifySuppServiceFailed(Phone.SuppService.UNKNOWN);
        addTaint(dialString.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1225336491 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1225336491;
        // ---------- Original Method ----------
        //if (dialString.length() > 1) {
            //return false;
        //}
        //Log.i(LOG_TAG, "MmiCode 5: CCBS not supported!");
        //notifySuppServiceFailed(Phone.SuppService.UNKNOWN);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.840 -0400", hash_original_method = "ADE3D3CB52AC1581EEE1CFCBED33E09A", hash_generated_method = "1D12EE5B881607D3FA2C8271C7D7EEC2")
    public boolean handleInCallMmiCommands(String dialString) throws CallStateException {
        {
            boolean var2DA7186072441CB83C6A969D8B16A442_2095098135 = (!isInCall());
        } //End collapsed parenthetic
        {
            boolean varE12969D5E25DB7CCEEFA6845C2569D2D_1335156851 = (TextUtils.isEmpty(dialString));
        } //End collapsed parenthetic
        boolean result;
        result = false;
        char ch;
        ch = dialString.charAt(0);
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1210012784 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1210012784;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.851 -0400", hash_original_method = "711944CD15C0B30B5C3E1DF07833B9CC", hash_generated_method = "BADBF3C4C7D65300FA6374FF1EA38795")
     boolean isInCall() {
        GsmCall.State foregroundCallState;
        foregroundCallState = getForegroundCall().getState();
        GsmCall.State backgroundCallState;
        backgroundCallState = getBackgroundCall().getState();
        GsmCall.State ringingCallState;
        ringingCallState = getRingingCall().getState();
        boolean var40D567FED010B1806D41F17B742032B9_1390585901 = ((foregroundCallState.isAlive() ||
                backgroundCallState.isAlive() ||
                ringingCallState.isAlive()));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1593159497 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1593159497;
        // ---------- Original Method ----------
        //GsmCall.State foregroundCallState = getForegroundCall().getState();
        //GsmCall.State backgroundCallState = getBackgroundCall().getState();
        //GsmCall.State ringingCallState = getRingingCall().getState();
        //return (foregroundCallState.isAlive() ||
                //backgroundCallState.isAlive() ||
                //ringingCallState.isAlive());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.852 -0400", hash_original_method = "869C8D5C9810AA3DB7F9F221ECFAACBF", hash_generated_method = "C38172F108D41351435A258DE87F6D00")
    public Connection dial(String dialString) throws CallStateException {
        Connection varB4EAC82CA7396A68D541C85D26508E83_2142379672 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2142379672 = dial(dialString, null);
        addTaint(dialString.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2142379672.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2142379672;
        // ---------- Original Method ----------
        //return dial(dialString, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.853 -0400", hash_original_method = "905878DD9E4370A9706866C1B8D62D03", hash_generated_method = "8F95080FA1A58F596D6B1EB8A529811F")
    public Connection dial(String dialString, UUSInfo uusInfo) throws CallStateException {
        Connection varB4EAC82CA7396A68D541C85D26508E83_607489564 = null; //Variable for return #1
        Connection varB4EAC82CA7396A68D541C85D26508E83_292002008 = null; //Variable for return #2
        Connection varB4EAC82CA7396A68D541C85D26508E83_135623485 = null; //Variable for return #3
        Connection varB4EAC82CA7396A68D541C85D26508E83_1338934119 = null; //Variable for return #4
        String newDialString;
        newDialString = PhoneNumberUtils.stripSeparators(dialString);
        {
            boolean var22047FA7216835015EF1E811EC89577D_368756943 = (handleInCallMmiCommands(newDialString));
            {
                varB4EAC82CA7396A68D541C85D26508E83_607489564 = null;
            } //End block
        } //End collapsed parenthetic
        String networkPortion;
        networkPortion = PhoneNumberUtils.extractNetworkPortionAlt(newDialString);
        GsmMmiCode mmi;
        mmi = GsmMmiCode.newFromDialString(networkPortion, this);
        Log.d(LOG_TAG,
                               "dialing w/ mmi '" + mmi + "'...");
        {
            varB4EAC82CA7396A68D541C85D26508E83_292002008 = mCT.dial(newDialString, uusInfo);
        } //End block
        {
            boolean varD000FF2B694DE8E860A4E505705D97D0_1634919080 = (mmi.isTemporaryModeCLIR());
            {
                varB4EAC82CA7396A68D541C85D26508E83_135623485 = mCT.dial(mmi.dialingNumber, mmi.getCLIRMode(), uusInfo);
            } //End block
            {
                mPendingMMIs.add(mmi);
                mMmiRegistrants.notifyRegistrants(new AsyncResult(null, mmi, null));
                mmi.processCode();
                varB4EAC82CA7396A68D541C85D26508E83_1338934119 = null;
            } //End block
        } //End collapsed parenthetic
        addTaint(dialString.getTaint());
        addTaint(uusInfo.getTaint());
        Connection varA7E53CE21691AB073D9660D615818899_332878034; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_332878034 = varB4EAC82CA7396A68D541C85D26508E83_607489564;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_332878034 = varB4EAC82CA7396A68D541C85D26508E83_292002008;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_332878034 = varB4EAC82CA7396A68D541C85D26508E83_135623485;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_332878034 = varB4EAC82CA7396A68D541C85D26508E83_1338934119;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_332878034.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_332878034;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.860 -0400", hash_original_method = "4BA0C4BD36DFB68226B2317C39970473", hash_generated_method = "38FA2D020F1D18144CD29A224E409C9D")
    public boolean handlePinMmi(String dialString) {
        GsmMmiCode mmi;
        mmi = GsmMmiCode.newFromDialString(dialString, this);
        {
            boolean var182AE2F3D97AC06A48466C4D43389C30_258458535 = (mmi != null && mmi.isPinCommand());
            {
                mPendingMMIs.add(mmi);
                mMmiRegistrants.notifyRegistrants(new AsyncResult(null, mmi, null));
                mmi.processCode();
            } //End block
        } //End collapsed parenthetic
        addTaint(dialString.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1425461039 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1425461039;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.861 -0400", hash_original_method = "0D802E3B18B63F6835A66AA15E37A07D", hash_generated_method = "057D7C128A606923D05A260AA1F2E4B5")
    public void sendUssdResponse(String ussdMessge) {
        GsmMmiCode mmi;
        mmi = GsmMmiCode.newFromUssdUserInput(ussdMessge, this);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.861 -0400", hash_original_method = "98607162C44D8873925496654D522BF8", hash_generated_method = "2E9F9A2602253BBF55CFCA4642138C90")
    public void sendDtmf(char c) {
        {
            boolean varD5E376D61876D980336EC59E5D202EEE_1900409639 = (!PhoneNumberUtils.is12Key(c));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.869 -0400", hash_original_method = "3FBA1333099AE68AF02019D712D23AB2", hash_generated_method = "88B4A46B14901E2788E4622A0AEE115E")
    public void startDtmf(char c) {
        {
            boolean varD5E376D61876D980336EC59E5D202EEE_1153414130 = (!PhoneNumberUtils.is12Key(c));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.869 -0400", hash_original_method = "3DAC039DE959EF34631E2B825CE1F213", hash_generated_method = "E3ACE99405ED7C4AFBEE2F93E02370EB")
    public void stopDtmf() {
        mCM.stopDtmf(null);
        // ---------- Original Method ----------
        //mCM.stopDtmf(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.869 -0400", hash_original_method = "632DA8A1165B474AAA75C1A965AA7035", hash_generated_method = "A6BBC7BAC7B5E358A183AE12DC1C1071")
    public void sendBurstDtmf(String dtmfString) {
        addTaint(dtmfString.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[GSMPhone] sendBurstDtmf() is a CDMA method");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.873 -0400", hash_original_method = "6583EBFAAE11F5B271B0C202AB11C3E9", hash_generated_method = "05A63141C9EA8439A5D53E7DA83CD61B")
    public void setRadioPower(boolean power) {
        mSST.setRadioPower(power);
        addTaint(power);
        // ---------- Original Method ----------
        //mSST.setRadioPower(power);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.873 -0400", hash_original_method = "E7F586CDCE74786257222FAC0983E7F9", hash_generated_method = "EA744CB9B2AC7258DD1BD6C5AF535726")
    private void storeVoiceMailNumber(String number) {
        SharedPreferences sp;
        sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor editor;
        editor = sp.edit();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.874 -0400", hash_original_method = "69924A8239B9858372407D5C2A54772B", hash_generated_method = "8AA2FDE0AF76634EF10D00B3C2F8E9B9")
    public String getVoiceMailNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_14908727 = null; //Variable for return #1
        String number;
        number = mIccRecords.getVoiceMailNumber();
        {
            boolean varDC814D5E0DD02381050A532714A4AE08_467885166 = (TextUtils.isEmpty(number));
            {
                SharedPreferences sp;
                sp = PreferenceManager.getDefaultSharedPreferences(getContext());
                number = sp.getString(VM_NUMBER, null);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_14908727 = number;
        varB4EAC82CA7396A68D541C85D26508E83_14908727.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_14908727;
        // ---------- Original Method ----------
        //String number = mIccRecords.getVoiceMailNumber();
        //if (TextUtils.isEmpty(number)) {
            //SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
            //number = sp.getString(VM_NUMBER, null);
        //}
        //return number;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.874 -0400", hash_original_method = "767A05C9F746992519407618C38B7609", hash_generated_method = "952830EA1D33EA577FBB922E07E1DF71")
    private String getVmSimImsi() {
        String varB4EAC82CA7396A68D541C85D26508E83_1599381156 = null; //Variable for return #1
        SharedPreferences sp;
        sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        varB4EAC82CA7396A68D541C85D26508E83_1599381156 = sp.getString(VM_SIM_IMSI, null);
        varB4EAC82CA7396A68D541C85D26508E83_1599381156.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1599381156;
        // ---------- Original Method ----------
        //SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        //return sp.getString(VM_SIM_IMSI, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.886 -0400", hash_original_method = "8C96CC1C916F049093DF13C1B1327265", hash_generated_method = "5D6943894752E7B6994C798E7FD087AC")
    private void setVmSimImsi(String imsi) {
        SharedPreferences sp;
        sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor editor;
        editor = sp.edit();
        editor.putString(VM_SIM_IMSI, imsi);
        editor.apply();
        addTaint(imsi.getTaint());
        // ---------- Original Method ----------
        //SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        //SharedPreferences.Editor editor = sp.edit();
        //editor.putString(VM_SIM_IMSI, imsi);
        //editor.apply();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.886 -0400", hash_original_method = "445A2067BED895487F73AC5A870ED091", hash_generated_method = "D23B68F542B4BFE2CC1E91AE95155A71")
    public String getVoiceMailAlphaTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_1691150392 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_2014908866 = null; //Variable for return #2
        String ret;
        ret = mIccRecords.getVoiceMailAlphaTag();
        {
            boolean var0709D69E6C2648B4A0C93BD0750A7DE0_590588113 = (ret == null || ret.length() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1691150392 = mContext.getText(
                com.android.internal.R.string.defaultVoiceMailAlphaTag).toString();
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_2014908866 = ret;
        String varA7E53CE21691AB073D9660D615818899_278045503; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_278045503 = varB4EAC82CA7396A68D541C85D26508E83_1691150392;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_278045503 = varB4EAC82CA7396A68D541C85D26508E83_2014908866;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_278045503.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_278045503;
        // ---------- Original Method ----------
        //String ret;
        //ret = mIccRecords.getVoiceMailAlphaTag();
        //if (ret == null || ret.length() == 0) {
            //return mContext.getText(
                //com.android.internal.R.string.defaultVoiceMailAlphaTag).toString();
        //}
        //return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.887 -0400", hash_original_method = "40864F79C0287ACEFC2860E74923A158", hash_generated_method = "FFCAC54EC95C312182F606FD6E561742")
    public String getDeviceId() {
        String varB4EAC82CA7396A68D541C85D26508E83_1621526684 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1621526684 = mImei;
        varB4EAC82CA7396A68D541C85D26508E83_1621526684.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1621526684;
        // ---------- Original Method ----------
        //return mImei;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.887 -0400", hash_original_method = "14B7BB34E0FC203F73344BD326AAB989", hash_generated_method = "22778C21B245B6835E6293ABB0AC9461")
    public String getDeviceSvn() {
        String varB4EAC82CA7396A68D541C85D26508E83_1236997119 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1236997119 = mImeiSv;
        varB4EAC82CA7396A68D541C85D26508E83_1236997119.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1236997119;
        // ---------- Original Method ----------
        //return mImeiSv;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.887 -0400", hash_original_method = "2BFB931234EFCBDA06B75AE314A70B6B", hash_generated_method = "47DF90CA84E39D3BD158AA952F53C31C")
    public String getImei() {
        String varB4EAC82CA7396A68D541C85D26508E83_1399303222 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1399303222 = mImei;
        varB4EAC82CA7396A68D541C85D26508E83_1399303222.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1399303222;
        // ---------- Original Method ----------
        //return mImei;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.888 -0400", hash_original_method = "8337C263E1C0C858E7E7356286A6EE86", hash_generated_method = "2A8282B022FD11D8DD4E2959E2455445")
    public String getEsn() {
        String varB4EAC82CA7396A68D541C85D26508E83_1514718521 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1514718521 = "0";
        varB4EAC82CA7396A68D541C85D26508E83_1514718521.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1514718521;
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[GSMPhone] getEsn() is a CDMA method");
        //return "0";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.888 -0400", hash_original_method = "92AF0460E6B1DF6A22F32869474C6DE7", hash_generated_method = "5B695A28028383A5AEDCBC0A0A2F2731")
    public String getMeid() {
        String varB4EAC82CA7396A68D541C85D26508E83_714891928 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_714891928 = "0";
        varB4EAC82CA7396A68D541C85D26508E83_714891928.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_714891928;
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[GSMPhone] getMeid() is a CDMA method");
        //return "0";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.896 -0400", hash_original_method = "418ED398A6A3FF53B03B4C5008FE3F90", hash_generated_method = "4BA6F109F998A6EAE81E0B84CCB18520")
    public String getSubscriberId() {
        String varB4EAC82CA7396A68D541C85D26508E83_1489931700 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1489931700 = mIccRecords.getIMSI();
        varB4EAC82CA7396A68D541C85D26508E83_1489931700.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1489931700;
        // ---------- Original Method ----------
        //return mIccRecords.getIMSI();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.900 -0400", hash_original_method = "084DD7ECDC7A6E289A4C2D9F1DE10A12", hash_generated_method = "F21E4821AC7040F83938AFD2C36C8DB0")
    public String getLine1Number() {
        String varB4EAC82CA7396A68D541C85D26508E83_1324067558 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1324067558 = mIccRecords.getMsisdnNumber();
        varB4EAC82CA7396A68D541C85D26508E83_1324067558.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1324067558;
        // ---------- Original Method ----------
        //return mIccRecords.getMsisdnNumber();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.901 -0400", hash_original_method = "0F1A42666FEB7039E59CE38A804A2571", hash_generated_method = "5D6DC348671964586B39A5B81C98F6F8")
    @Override
    public String getMsisdn() {
        String varB4EAC82CA7396A68D541C85D26508E83_969057118 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_969057118 = mIccRecords.getMsisdnNumber();
        varB4EAC82CA7396A68D541C85D26508E83_969057118.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_969057118;
        // ---------- Original Method ----------
        //return mIccRecords.getMsisdnNumber();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.901 -0400", hash_original_method = "D360BD2B0AE3500C93B786BA943E8C4F", hash_generated_method = "13A80F463038626877F157F3BE4A3C38")
    public String getLine1AlphaTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_1957369329 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1957369329 = mIccRecords.getMsisdnAlphaTag();
        varB4EAC82CA7396A68D541C85D26508E83_1957369329.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1957369329;
        // ---------- Original Method ----------
        //return mIccRecords.getMsisdnAlphaTag();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.901 -0400", hash_original_method = "F8CED3952B50871548C8F8795A72A874", hash_generated_method = "2F83E945254E4C14314DD3FEF8E5E644")
    public void setLine1Number(String alphaTag, String number, Message onComplete) {
        mIccRecords.setMsisdnNumber(alphaTag, number, onComplete);
        addTaint(alphaTag.getTaint());
        addTaint(number.getTaint());
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //mIccRecords.setMsisdnNumber(alphaTag, number, onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.902 -0400", hash_original_method = "63103D1CE9C7888BE66C8CE520564C7E", hash_generated_method = "FB951956CF6FF915B0F35F192179D19D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.902 -0400", hash_original_method = "9DDD364B83D4A188246C8EC4129A09D5", hash_generated_method = "3617D7BB16E50115B1A24585FD97BF7A")
    private boolean isValidCommandInterfaceCFReason(int commandInterfaceCFReason) {
        addTaint(commandInterfaceCFReason);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1280807549 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1280807549;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.915 -0400", hash_original_method = "138625FFD93D7E6FCFD9298408C66777", hash_generated_method = "1BAAE01732AB319B7FABF351D51AA485")
    private boolean isValidCommandInterfaceCFAction(int commandInterfaceCFAction) {
        addTaint(commandInterfaceCFAction);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_947527213 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_947527213;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.915 -0400", hash_original_method = "E62FA7EF147A8759C3C5908B3838581B", hash_generated_method = "A9FBE1CF3FCF32209508CE1BE37F0B5D")
    protected boolean isCfEnable(int action) {
        addTaint(action);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_23071852 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_23071852;
        // ---------- Original Method ----------
        //return (action == CF_ACTION_ENABLE) || (action == CF_ACTION_REGISTRATION);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.916 -0400", hash_original_method = "08670889C34D44E522747D6078786295", hash_generated_method = "5F9A6E727ADE62C156198DF8FB0EAC8A")
    public void getCallForwardingOption(int commandInterfaceCFReason, Message onComplete) {
        {
            boolean varB6A05407BFCE3D15C223CC07E884F337_1811176749 = (isValidCommandInterfaceCFReason(commandInterfaceCFReason));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.917 -0400", hash_original_method = "C31B5CE81010007284F85A1CC1A97426", hash_generated_method = "316B2AD260A1B7556783BC0420E8F1C1")
    public void setCallForwardingOption(int commandInterfaceCFAction,
            int commandInterfaceCFReason,
            String dialingNumber,
            int timerSeconds,
            Message onComplete) {
        {
            boolean var1CEEA491E3B272BF616FE6FFF10B0258_606778769 = ((isValidCommandInterfaceCFAction(commandInterfaceCFAction)) &&
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.917 -0400", hash_original_method = "211ADA06D97F0C35F6F35D44159D1041", hash_generated_method = "4E0A5EBB9EA472EF008B883B43A17BB7")
    public void getOutgoingCallerIdDisplay(Message onComplete) {
        mCM.getCLIR(onComplete);
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //mCM.getCLIR(onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.925 -0400", hash_original_method = "9A33528D3F7EB56FD0CAE46DED766DA5", hash_generated_method = "CBEFDBA5BEA31A14D6710BCF53022067")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.926 -0400", hash_original_method = "5AA95CCFAB839BE19F56DECDE6C06EAE", hash_generated_method = "7673F821F9D71A843888D86E7DC4611F")
    public void getCallWaiting(Message onComplete) {
        mCM.queryCallWaiting(CommandsInterface.SERVICE_CLASS_NONE, onComplete);
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //mCM.queryCallWaiting(CommandsInterface.SERVICE_CLASS_NONE, onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.926 -0400", hash_original_method = "378FD22E0CB0CF1CC5C649D301CEF0C1", hash_generated_method = "629281880C4B7E8CCD82DBA8A7023133")
    public void setCallWaiting(boolean enable, Message onComplete) {
        mCM.setCallWaiting(enable, CommandsInterface.SERVICE_CLASS_VOICE, onComplete);
        addTaint(enable);
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //mCM.setCallWaiting(enable, CommandsInterface.SERVICE_CLASS_VOICE, onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.926 -0400", hash_original_method = "4DC55439AC7C450EEFD22BFFC07D3CE9", hash_generated_method = "3367B26B3B2FC6C5AD7648EC92FDB787")
    public void getAvailableNetworks(Message response) {
        mCM.getAvailableNetworks(response);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //mCM.getAvailableNetworks(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.927 -0400", hash_original_method = "21AFB30263A6CEDCB2E90901BACA2953", hash_generated_method = "084A20C30F8F1A00194FDD4BF083B053")
    public void setNetworkSelectionModeAutomatic(Message response) {
        NetworkSelectMessage nsm;
        nsm = new NetworkSelectMessage();
        nsm.message = response;
        nsm.operatorNumeric = "";
        nsm.operatorAlphaLong = "";
        Message msg;
        msg = obtainMessage(EVENT_SET_NETWORK_AUTOMATIC_COMPLETE, nsm);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.927 -0400", hash_original_method = "388CF66FD02B64F200B61D1E744A0B56", hash_generated_method = "1208460382C0A34D17921F82E3784804")
    public void selectNetworkManually(OperatorInfo network,
            Message response) {
        NetworkSelectMessage nsm;
        nsm = new NetworkSelectMessage();
        nsm.message = response;
        nsm.operatorNumeric = network.getOperatorNumeric();
        nsm.operatorAlphaLong = network.getOperatorAlphaLong();
        Message msg;
        msg = obtainMessage(EVENT_SET_NETWORK_MANUAL_COMPLETE, nsm);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.927 -0400", hash_original_method = "3A54DC42D0DFD8C763BDF4414C51677B", hash_generated_method = "64B88CABA725194290584FBC40E665D5")
    public void getNeighboringCids(Message response) {
        mCM.getNeighboringCids(response);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //mCM.getNeighboringCids(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.928 -0400", hash_original_method = "A54F4B18F21B3A39961648F4BDA2F061", hash_generated_method = "0D9A74204B6FB987A29697E2CA304A25")
    public void setOnPostDialCharacter(Handler h, int what, Object obj) {
        mPostDialHandler = new Registrant(h, what, obj);
        // ---------- Original Method ----------
        //mPostDialHandler = new Registrant(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.928 -0400", hash_original_method = "E892EC268DCFDF5C9C27A7DDC7E00573", hash_generated_method = "77B440C2480B73790494E18A49E29D56")
    public void setMute(boolean muted) {
        mCT.setMute(muted);
        addTaint(muted);
        // ---------- Original Method ----------
        //mCT.setMute(muted);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.928 -0400", hash_original_method = "FA6E824680C8944626A1A959DCEA6499", hash_generated_method = "B184DD0491549AD738DC6787B68569DB")
    public boolean getMute() {
        boolean var20663A120A6F5E860F4EB58F2E5B9228_337070319 = (mCT.getMute());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1550219158 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1550219158;
        // ---------- Original Method ----------
        //return mCT.getMute();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.935 -0400", hash_original_method = "DAED77F9218E0449A772CA04214CC7F0", hash_generated_method = "13BB02467E7237F3DCAA27B785AFC8DE")
    public void getDataCallList(Message response) {
        mCM.getDataCallList(response);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //mCM.getDataCallList(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.935 -0400", hash_original_method = "96CADC2872DB4F7FDEDEDD322815973F", hash_generated_method = "822C445C5B4D9120BF9FC0E8634D50FF")
    public void updateServiceLocation() {
        mSST.enableSingleLocationUpdate();
        // ---------- Original Method ----------
        //mSST.enableSingleLocationUpdate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.936 -0400", hash_original_method = "85721F5820CF0128BD1EA66BA785E274", hash_generated_method = "8061BA0AAC1F798918E946EB98E60D31")
    public void enableLocationUpdates() {
        mSST.enableLocationUpdates();
        // ---------- Original Method ----------
        //mSST.enableLocationUpdates();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.936 -0400", hash_original_method = "E6FECC87DDBB4D4FE984E494757397E3", hash_generated_method = "3FDC902944764AB6B7139C73765CF957")
    public void disableLocationUpdates() {
        mSST.disableLocationUpdates();
        // ---------- Original Method ----------
        //mSST.disableLocationUpdates();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.948 -0400", hash_original_method = "33CDF43696035DC3E16A234222A80D64", hash_generated_method = "2133E9724EC7569871C6EF908E3573AD")
    public boolean getDataRoamingEnabled() {
        boolean var6ACB2ECE8621241EECE599BD6243F11B_1613451975 = (mDataConnectionTracker.getDataOnRoamingEnabled());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_524489784 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_524489784;
        // ---------- Original Method ----------
        //return mDataConnectionTracker.getDataOnRoamingEnabled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.949 -0400", hash_original_method = "910AE5D7D70CC37EC2511A21C3761E3A", hash_generated_method = "833E210D6BAC589C67F646388318201A")
    public void setDataRoamingEnabled(boolean enable) {
        mDataConnectionTracker.setDataOnRoamingEnabled(enable);
        addTaint(enable);
        // ---------- Original Method ----------
        //mDataConnectionTracker.setDataOnRoamingEnabled(enable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.949 -0400", hash_original_method = "AC949E64AEE76B7FF936E7A1B08DF381", hash_generated_method = "E8655AF924D9C0427F4ACC938D8EACD1")
     void onMMIDone(GsmMmiCode mmi) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var1EA6EA5746ECD4584B3A274E648709FA_507885700 = (mPendingMMIs.remove(mmi) || mmi.isUssdRequest());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.949 -0400", hash_original_method = "7B2BAD4339ABD08CFCEAE93D5F289166", hash_generated_method = "FD05A26848D851E06F917F392A8B9191")
    private void onNetworkInitiatedUssd(GsmMmiCode mmi) {
        mMmiCompleteRegistrants.notifyRegistrants(
            new AsyncResult(null, mmi, null));
        addTaint(mmi.getTaint());
        // ---------- Original Method ----------
        //mMmiCompleteRegistrants.notifyRegistrants(
            //new AsyncResult(null, mmi, null));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.950 -0400", hash_original_method = "FA8827AA61AE68EAA1082E2A36657BA2", hash_generated_method = "E4B20B5E60633348941839730B2FBAFE")
    private void onIncomingUSSD(int ussdMode, String ussdMessage) {
        boolean isUssdError;
        boolean isUssdRequest;
        isUssdRequest
            = (ussdMode == CommandsInterface.USSD_MODE_REQUEST);
        isUssdError
            = (ussdMode != CommandsInterface.USSD_MODE_NOTIFY
                && ussdMode != CommandsInterface.USSD_MODE_REQUEST);
        GsmMmiCode found;
        found = null;
        {
            int i, s;
            i = 0;
            s = mPendingMMIs.size();
            {
                {
                    boolean varA016EF5F6E1ECC7C98CFC15BB240BDED_695087454 = (mPendingMMIs.get(i).isPendingUSSD());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.951 -0400", hash_original_method = "B501A93D9CBCF588AB28D650AA03E986", hash_generated_method = "4FA264C77DC40C25C12B6C20DAF6C12D")
    protected void syncClirSetting() {
        SharedPreferences sp;
        sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        int clirSetting;
        clirSetting = sp.getInt(CLIR_KEY, -1);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.953 -0400", hash_original_method = "EA4D9CE5B4912647996EC04703971BF3", hash_generated_method = "597C6B0B2DE8D405E366C630A66CEB9C")
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
        String imsi;
        imsi = getVmSimImsi();
        //End case EVENT_SIM_RECORDS_LOADED 
        //Begin case EVENT_SIM_RECORDS_LOADED 
        String imsiFromSIM;
        imsiFromSIM = getSubscriberId();
        //End case EVENT_SIM_RECORDS_LOADED 
        //Begin case EVENT_SIM_RECORDS_LOADED 
        {
            boolean var3AAC275703146E8A94381DBD8E1509A5_312736620 = (imsi != null && imsiFromSIM != null && !imsiFromSIM.equals(imsi));
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
        String[] ussdResult;
        ussdResult = (String[]) ar.result;
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
            int i, s;
            i = 0;
            s = mPendingMMIs.size();
            {
                {
                    boolean varA016EF5F6E1ECC7C98CFC15BB240BDED_2084071951 = (mPendingMMIs.get(i).isPendingUSSD());
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
        SuppServiceNotification not;
        not = (SuppServiceNotification) ar.result;
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
            boolean varAE18DF4A9D4BF791512D5DD4EB3D1497_1130049171 = (IccVmNotSupportedException.class.isInstance(ar.exception));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.954 -0400", hash_original_method = "0F23F53D1861BCD51C7CF85FD75916D2", hash_generated_method = "A96BAA2EC62EE147ED41CBCC297CA09C")
     boolean updateCurrentCarrierInProvider() {
        {
            try 
            {
                Uri uri;
                uri = Uri.withAppendedPath(Telephony.Carriers.CONTENT_URI, "current");
                ContentValues map;
                map = new ContentValues();
                map.put(Telephony.Carriers.NUMERIC, mIccRecords.getOperatorNumeric());
                mContext.getContentResolver().insert(uri, map);
            } //End block
            catch (SQLException e)
            { }
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_579814733 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_579814733;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.970 -0400", hash_original_method = "8C87E0C6EBD471788AC0CD93A9D4E893", hash_generated_method = "285ADE3BFD380590A5C1CA00C8ECC8F3")
    private void handleSetSelectNetwork(AsyncResult ar) {
        {
            Log.d(LOG_TAG, "unexpected result from user object.");
        } //End block
        NetworkSelectMessage nsm;
        nsm = (NetworkSelectMessage) ar.userObj;
        {
            Log.d(LOG_TAG, "sending original message to recipient");
            AsyncResult.forMessage(nsm.message, ar.result, ar.exception);
            nsm.message.sendToTarget();
        } //End block
        SharedPreferences sp;
        sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor editor;
        editor = sp.edit();
        editor.putString(NETWORK_SELECTION_KEY, nsm.operatorNumeric);
        editor.putString(NETWORK_SELECTION_NAME_KEY, nsm.operatorAlphaLong);
        {
            boolean var15A115D7A2E98F40805CADB6914BBE5F_1075769260 = (! editor.commit());
        } //End collapsed parenthetic
        addTaint(ar.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.970 -0400", hash_original_method = "C8B4A3CF4267A4CC2FA2952E385D70CE", hash_generated_method = "5F5D1F14A4FAB28B232C2986C2ACE00A")
    public void saveClirSetting(int commandInterfaceCLIRMode) {
        SharedPreferences sp;
        sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor editor;
        editor = sp.edit();
        editor.putInt(CLIR_KEY, commandInterfaceCLIRMode);
        {
            boolean var15A115D7A2E98F40805CADB6914BBE5F_1808577994 = (! editor.commit());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.971 -0400", hash_original_method = "5FFF1291CED37081608080EEE820D6BC", hash_generated_method = "8B24DBBABD1861BD83B0DA8B17421B37")
    private void handleCfuQueryResult(CallForwardInfo[] infos) {
        {
            mIccRecords.setVoiceCallForwardingFlag(1, false);
        } //End block
        {
            {
                int i, s;
                i = 0;
                s = infos.length;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.971 -0400", hash_original_method = "4BF16EE42BDE3709043B0CD4BA1346D5", hash_generated_method = "65092997067C0BD7943C676E6CEE472F")
    public PhoneSubInfo getPhoneSubInfo() {
        PhoneSubInfo varB4EAC82CA7396A68D541C85D26508E83_2013914684 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2013914684 = mSubInfo;
        varB4EAC82CA7396A68D541C85D26508E83_2013914684.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2013914684;
        // ---------- Original Method ----------
        //return mSubInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.972 -0400", hash_original_method = "3207E33C673BD37AF8FDF81E31830AE6", hash_generated_method = "AD99DF8DA7327CBAA49C729F938AFC30")
    public IccSmsInterfaceManager getIccSmsInterfaceManager() {
        IccSmsInterfaceManager varB4EAC82CA7396A68D541C85D26508E83_1426958218 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1426958218 = mSimSmsIntManager;
        varB4EAC82CA7396A68D541C85D26508E83_1426958218.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1426958218;
        // ---------- Original Method ----------
        //return mSimSmsIntManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.972 -0400", hash_original_method = "6E6477AE345E3D007CED20614912A5C4", hash_generated_method = "DF26E37EB42008F524F5748692321D0D")
    public IccPhoneBookInterfaceManager getIccPhoneBookInterfaceManager() {
        IccPhoneBookInterfaceManager varB4EAC82CA7396A68D541C85D26508E83_1997897516 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1997897516 = mSimPhoneBookIntManager;
        varB4EAC82CA7396A68D541C85D26508E83_1997897516.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1997897516;
        // ---------- Original Method ----------
        //return mSimPhoneBookIntManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.982 -0400", hash_original_method = "515987807F65054AFA6AA9A268DDB599", hash_generated_method = "F871BDF089139309529B141506FE2492")
    public IccFileHandler getIccFileHandler() {
        IccFileHandler varB4EAC82CA7396A68D541C85D26508E83_560370374 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_560370374 = this.mIccFileHandler;
        varB4EAC82CA7396A68D541C85D26508E83_560370374.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_560370374;
        // ---------- Original Method ----------
        //return this.mIccFileHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.983 -0400", hash_original_method = "93A82B64CE4B13442120BE4FDBB45597", hash_generated_method = "E12DDFC0154755786ACB8EB6DEF86590")
    public void activateCellBroadcastSms(int activate, Message response) {
        response.sendToTarget();
        addTaint(activate);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[GSMPhone] activateCellBroadcastSms() is obsolete; use SmsManager");
        //response.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.983 -0400", hash_original_method = "67DD91319C4A7AB6B9A5C1E784682816", hash_generated_method = "A4A79E53CFABE50528F1F6B4B8F32765")
    public void getCellBroadcastSmsConfig(Message response) {
        response.sendToTarget();
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[GSMPhone] getCellBroadcastSmsConfig() is obsolete; use SmsManager");
        //response.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.983 -0400", hash_original_method = "1D706FBF2447232FA856B129DB0956D5", hash_generated_method = "6F5D42CA3C311376A4E323F5CA7ECBD8")
    public void setCellBroadcastSmsConfig(int[] configValuesArray, Message response) {
        response.sendToTarget();
        addTaint(configValuesArray[0]);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[GSMPhone] setCellBroadcastSmsConfig() is obsolete; use SmsManager");
        //response.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.983 -0400", hash_original_method = "99B79EB3DF02CDEF6145664CC8FD0F29", hash_generated_method = "7FAB0E2A695D98F02383BAE253B6DC05")
    public boolean isCspPlmnEnabled() {
        boolean varDB15A307B35D48340572A8BACE2EEC2D_1761046870 = (mIccRecords.isCspPlmnEnabled());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_677526662 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_677526662;
        // ---------- Original Method ----------
        //return mIccRecords.isCspPlmnEnabled();
    }

    
    private static class NetworkSelectMessage {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.984 -0400", hash_original_field = "78E731027D8FD50ED642340B7C9A63B3", hash_generated_field = "81254C6170A9E52E0AD3BB76A481765A")

        public Message message;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.984 -0400", hash_original_field = "283D783309AC858AFD001B18F5F912C5", hash_generated_field = "8CA2393560EE8C751F612DF94EBF8B4B")

        public String operatorNumeric;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.984 -0400", hash_original_field = "EBA1AB368B4E5EA262B356E9FEB5DBFF", hash_generated_field = "D8A2785302661C77D4C9BAD0912DCC8E")

        public String operatorAlphaLong;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.984 -0400", hash_original_method = "3039E12EC83A8AA31D55051619D54055", hash_generated_method = "3039E12EC83A8AA31D55051619D54055")
        public NetworkSelectMessage ()
        {
            //Synthesized constructor
        }


    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.984 -0400", hash_original_field = "41EBE7F32B96C1E2E9C209710486A443", hash_generated_field = "D3C0B237A982707BF0906F1B27E7321D")

    static String LOG_TAG = "GSM";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.984 -0400", hash_original_field = "7F1E46EB212D9379AF8B593E529EF4C2", hash_generated_field = "5CAE480CB22B62FE8C5DA9BB47B33BCD")

    private static boolean LOCAL_DEBUG = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.984 -0400", hash_original_field = "EF81B5D96B53AEF2D500834A3DA6EF48", hash_generated_field = "F3DA441E75937751070EF22397051A39")

    public static final String CIPHERING_KEY = "ciphering_key";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.984 -0400", hash_original_field = "E66EAE6BBE4F2F42919E1A4E2896F710", hash_generated_field = "9B3C30C83DCADEE3DE0A0EB64ED01323")

    public static final String VM_NUMBER = "vm_number_key";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.984 -0400", hash_original_field = "B8DF52CD1BE962208AFE9FAF61C00759", hash_generated_field = "45605E617A76B49A021FF496D3F936B3")

    public static final String VM_SIM_IMSI = "vm_sim_imsi_key";
}

