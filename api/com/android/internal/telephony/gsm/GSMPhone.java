package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import static com.android.internal.telephony.CommandsInterface.CF_ACTION_DISABLE;
import static com.android.internal.telephony.CommandsInterface.CF_ACTION_ENABLE;
import static com.android.internal.telephony.CommandsInterface.CF_ACTION_ERASURE;
import static com.android.internal.telephony.CommandsInterface.CF_ACTION_REGISTRATION;
import static com.android.internal.telephony.CommandsInterface.CF_REASON_ALL;
import static com.android.internal.telephony.CommandsInterface.CF_REASON_ALL_CONDITIONAL;
import static com.android.internal.telephony.CommandsInterface.CF_REASON_BUSY;
import static com.android.internal.telephony.CommandsInterface.CF_REASON_NOT_REACHABLE;
import static com.android.internal.telephony.CommandsInterface.CF_REASON_NO_REPLY;
import static com.android.internal.telephony.CommandsInterface.CF_REASON_UNCONDITIONAL;
import static com.android.internal.telephony.CommandsInterface.SERVICE_CLASS_VOICE;
import static com.android.internal.telephony.TelephonyProperties.PROPERTY_BASEBAND_VERSION;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

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
import android.text.TextUtils;
import android.util.Log;

import com.android.internal.telephony.CallForwardInfo;
import com.android.internal.telephony.CallStateException;
import com.android.internal.telephony.CallTracker;
import com.android.internal.telephony.CommandsInterface;
import com.android.internal.telephony.Connection;
import com.android.internal.telephony.IccFileHandler;
import com.android.internal.telephony.IccPhoneBookInterfaceManager;
import com.android.internal.telephony.IccSmsInterfaceManager;
import com.android.internal.telephony.IccVmNotSupportedException;
import com.android.internal.telephony.MmiCode;
import com.android.internal.telephony.OperatorInfo;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.PhoneBase;
import com.android.internal.telephony.PhoneNotifier;
import com.android.internal.telephony.PhoneProxy;
import com.android.internal.telephony.PhoneSubInfo;
import com.android.internal.telephony.ServiceStateTracker;
import com.android.internal.telephony.TelephonyProperties;
import com.android.internal.telephony.UUSInfo;
import com.android.internal.telephony.cat.CatService;
import com.android.internal.telephony.test.SimulatedRadioControl;

public class GSMPhone extends PhoneBase {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.051 -0500", hash_original_field = "28DECCA9F494133CD6F61BCA99A50ECA", hash_generated_field = "FB0FBF4E6E507A7F16BF61EA2E4CADB8")

    // from this file will go into the radio log rather than the main
    // log.  (Use "adb logcat -b radio" to see them.)
    static final String LOG_TAG = "GSM";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.053 -0500", hash_original_field = "8F859C7BC8BA9F3C885E9F7F5FE6F39E", hash_generated_field = "F62F4824E5D90C8C9780C2AB171AAEE3")

    private static final boolean LOCAL_DEBUG = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.056 -0500", hash_original_field = "180831429526E93D1568D707AC86CF77", hash_generated_field = "F3DA441E75937751070EF22397051A39")

    public static final String CIPHERING_KEY = "ciphering_key";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.059 -0500", hash_original_field = "84E28A775D122B69632BB3634365C198", hash_generated_field = "9B3C30C83DCADEE3DE0A0EB64ED01323")

    public static final String VM_NUMBER = "vm_number_key";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.061 -0500", hash_original_field = "ED1AA2901EB4AAD2FB8ADA61FE1C76B1", hash_generated_field = "45605E617A76B49A021FF496D3F936B3")

    public static final String VM_SIM_IMSI = "vm_sim_imsi_key";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.064 -0500", hash_original_field = "7E950EFC4355B7AA0B0D4941C05A3E53", hash_generated_field = "7E950EFC4355B7AA0B0D4941C05A3E53")

    GsmCallTracker mCT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.066 -0500", hash_original_field = "AE636E648E782E05B0819C59ED7424AB", hash_generated_field = "AE636E648E782E05B0819C59ED7424AB")

    GsmServiceStateTracker mSST;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.068 -0500", hash_original_field = "CBD9585363E06B1CD5BA731CBD0F7A80", hash_generated_field = "CBD9585363E06B1CD5BA731CBD0F7A80")

    CatService mStkService;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.070 -0500", hash_original_field = "16CBC86166E203C30D8494A6E3AFFFBC", hash_generated_field = "16CBC86166E203C30D8494A6E3AFFFBC")

    ArrayList <GsmMmiCode> mPendingMMIs = new ArrayList<GsmMmiCode>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.072 -0500", hash_original_field = "BBEE3B2E599EE94DA4981B9B890C1513", hash_generated_field = "BBEE3B2E599EE94DA4981B9B890C1513")

    SimPhoneBookInterfaceManager mSimPhoneBookIntManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.074 -0500", hash_original_field = "3969837BA2D4BBD6356E9579AAD42F25", hash_generated_field = "3969837BA2D4BBD6356E9579AAD42F25")

    SimSmsInterfaceManager mSimSmsIntManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.077 -0500", hash_original_field = "F066FAD7B5AEEA27E2872ED159BF1CA4", hash_generated_field = "F066FAD7B5AEEA27E2872ED159BF1CA4")

    PhoneSubInfo mSubInfo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.079 -0500", hash_original_field = "126D29D3ACD6141B3CF1C156D9BC8C27", hash_generated_field = "126D29D3ACD6141B3CF1C156D9BC8C27")

    Registrant mPostDialHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.081 -0500", hash_original_field = "53A51CC9ADC1518A34F3208AF5D19A18", hash_generated_field = "53A51CC9ADC1518A34F3208AF5D19A18")

    RegistrantList mSsnRegistrants = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.083 -0500", hash_original_field = "74116952885B195B8407FD19FB3B03C8", hash_generated_field = "74116952885B195B8407FD19FB3B03C8")

    Thread debugPortThread;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.085 -0500", hash_original_field = "B2950783CBB152418ABB498147763A3B", hash_generated_field = "B2950783CBB152418ABB498147763A3B")

    ServerSocket debugSocket;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.087 -0500", hash_original_field = "87110AB01243FB897510B65582BCA335", hash_generated_field = "21C761E6867BA70678F0E7ADB70A1FBD")

    private String mImei;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.089 -0500", hash_original_field = "802D89AD0B9D3DF89A4EF610905A2C56", hash_generated_field = "B9E6756233427283AB4830B86393B4EE")

    private String mImeiSv;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.092 -0500", hash_original_field = "36DE24026D2D57B0D295813EDE5A4B20", hash_generated_field = "C290BF4C64FB14015B233D46098DB0A5")

    private String mVmNumber;

    // Constructors

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.095 -0500", hash_original_method = "996B91F3E8316CE3D841721FC6425644", hash_generated_method = "59133F5390BB1C0AF80A4F2EF462E926")
    
public
    GSMPhone (Context context, CommandsInterface ci, PhoneNotifier notifier) {
        this(context,ci,notifier, false);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.887 -0400", hash_original_method = "E0F14E16A0D8C4916EDEAC018BF6C407", hash_generated_method = "D6F344D5F2EE413249DD025FECDBA8A5")
    public  GSMPhone(Context context, CommandsInterface ci, PhoneNotifier notifier, boolean unitTestMode) {
        super(notifier, context, ci, unitTestMode);
        addTaint(unitTestMode);
        addTaint(notifier.getTaint());
        addTaint(ci.getTaint());
        addTaint(context.getTaint());
        if(ci instanceof SimulatedRadioControl)        
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
        if(!unitTestMode)        
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
        if(false)        
        {
            try 
            {
                debugSocket = new ServerSocket();
                debugSocket.setReuseAddress(true);
                debugSocket.bind (new InetSocketAddress("127.0.0.1", 6666));
                debugPortThread
                    = new Thread(
                        new Runnable() {
                            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.099 -0500", hash_original_method = "4E77C2C2171044E4A2A86AC9695E0AD3", hash_generated_method = "67B9D9F93B0DA7BBBD6EF31B8F6A6023")
                    
public void run() {
                                for(;;) {
                                    try {
                                        Socket sock;
                                        sock = debugSocket.accept();
                                        Log.i(LOG_TAG, "New connection; resetting radio");
                                        mCM.resetRadio(null);
                                        sock.close();
                                    } catch (IOException ex) {
                                        Log.w(LOG_TAG,
                                            "Exception accepting socket", ex);
                                    }
                                }
                            }
},
                        "GSMPhone debug");
                debugPortThread.start();
            } //End block
            catch (IOException ex)
            {
            } //End block
        } //End block
        SystemProperties.set(TelephonyProperties.CURRENT_ACTIVE_PHONE,
                new Integer(Phone.PHONE_TYPE_GSM).toString());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.106 -0500", hash_original_method = "CEF48F17C6DF6ACB05893EA0A2EE33F8", hash_generated_method = "615292312D180ADB689F5F4C07192C5C")
    
@Override
    public void dispose() {
        synchronized(PhoneProxy.lockForRadioTechnologyChange) {
            super.dispose();

            //Unregister from all former registered events
            mCM.unregisterForAvailable(this); //EVENT_RADIO_AVAILABLE
            mIccRecords.unregisterForRecordsLoaded(this); //EVENT_SIM_RECORDS_LOADED
            mCM.unregisterForOffOrNotAvailable(this); //EVENT_RADIO_OFF_OR_NOT_AVAILABLE
            mCM.unregisterForOn(this); //EVENT_RADIO_ON
            mSST.unregisterForNetworkAttached(this); //EVENT_REGISTERED_TO_NETWORK
            mCM.unSetOnUSSD(this);
            mCM.unSetOnSuppServiceNotification(this);

            mPendingMMIs.clear();

            //Force all referenced classes to unregister their former registered events
            mStkService.dispose();
            mCT.dispose();
            mDataConnectionTracker.dispose();
            mSST.dispose();
            mIccFileHandler.dispose(); // instance of SimFileHandler
            mIccRecords.dispose();
            mIccCard.dispose();
            mSimPhoneBookIntManager.dispose();
            mSimSmsIntManager.dispose();
            mSubInfo.dispose();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.108 -0500", hash_original_method = "F5F23F3B17FF3156952338384B3C94C7", hash_generated_method = "FFB9F8E843B4608FD19B0B18E3F51878")
    
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
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.111 -0500", hash_original_method = "B0A9A9B5818DC886F2534146C8893E7F", hash_generated_method = "1179F7324EA010BDF974A36FBF6DC607")
    
protected void finalize() {
        if(LOCAL_DEBUG) Log.d(LOG_TAG, "GSMPhone finalized");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.113 -0500", hash_original_method = "DA0F221C2247572C4D631280E4033E9A", hash_generated_method = "D478D89558ABAB62076DEF8330267072")
    
public ServiceState
    getServiceState() {
        return mSST.ss;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.115 -0500", hash_original_method = "E38329BE2FF507326358BBAF596945E6", hash_generated_method = "AC8CC4104D0FCBE937A2BAB0898984B6")
    
public CellLocation getCellLocation() {
        return mSST.cellLoc;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.117 -0500", hash_original_method = "8AEFB373111A9C8AD30F3E8C75C461D2", hash_generated_method = "72A05AA87A2A1A968094CFC764157F1B")
    
public Phone.State getState() {
        return mCT.state;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.120 -0500", hash_original_method = "59C2B6A3B95086A76D74A4AD572CD9E8", hash_generated_method = "EFB1237C84532CEA63D1AF53D1AAB4FD")
    
public String getPhoneName() {
        return "GSM";
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.122 -0500", hash_original_method = "8F0362114FB07F54B581B179D597F815", hash_generated_method = "F6ABF6B6D76CBFA3612F9B0DDC282765")
    
public int getPhoneType() {
        return Phone.PHONE_TYPE_GSM;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.124 -0500", hash_original_method = "46D9BC6E3280014832CD8FC523C20E6E", hash_generated_method = "C1C229BFE464B33E6EAAFB029141C168")
    
public SignalStrength getSignalStrength() {
        return mSST.mSignalStrength;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.126 -0500", hash_original_method = "79AFD9B845E4547B981131DAC9E3A14D", hash_generated_method = "42619EEC092A0EA3A9A304ABD8213F11")
    
public CallTracker getCallTracker() {
        return mCT;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.128 -0500", hash_original_method = "BD481539215D5A66E62B4E6909625141", hash_generated_method = "0972DE88684B8D25204CEF316794F013")
    
public ServiceStateTracker getServiceStateTracker() {
        return mSST;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.130 -0500", hash_original_method = "077104DE86BE536BE2C981492E640B74", hash_generated_method = "B7D25768B4ED693EE044BF8E201BD6BD")
    
public List<? extends MmiCode>
    getPendingMmiCodes() {
        return mPendingMMIs;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.133 -0500", hash_original_method = "7454904C7C93C1818F679756511639F1", hash_generated_method = "F4270F258185B5BBCCCDE26622A75D35")
    
public DataState getDataConnectionState(String apnType) {
        DataState ret = DataState.DISCONNECTED;

        if (mSST == null) {
            // Radio Technology Change is ongoning, dispose() and removeReferences() have
            // already been called

            ret = DataState.DISCONNECTED;
        } else if (mSST.getCurrentGprsState()
                != ServiceState.STATE_IN_SERVICE) {
            // If we're out of service, open TCP sockets may still work
            // but no data will flow
            ret = DataState.DISCONNECTED;
        } else if (mDataConnectionTracker.isApnTypeEnabled(apnType) == false ||
                mDataConnectionTracker.isApnTypeActive(apnType) == false) {
            //TODO: isApnTypeActive() is just checking whether ApnContext holds
            //      Dataconnection or not. Checking each ApnState below should
            //      provide the same state. Calling isApnTypeActive() can be removed.
            ret = DataState.DISCONNECTED;
        } else { /* mSST.gprsState == ServiceState.STATE_IN_SERVICE */
            switch (mDataConnectionTracker.getState(apnType)) {
                case FAILED:
                case IDLE:
                    ret = DataState.DISCONNECTED;
                break;

                case CONNECTED:
                case DISCONNECTING:
                    if ( mCT.state != Phone.State.IDLE
                            && !mSST.isConcurrentVoiceAndDataAllowed()) {
                        ret = DataState.SUSPENDED;
                    } else {
                        ret = DataState.CONNECTED;
                    }
                break;

                case INITING:
                case CONNECTING:
                case SCANNING:
                    ret = DataState.CONNECTING;
                break;
            }
        }

        return ret;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.136 -0500", hash_original_method = "1B8E5DE4B6A16D073AB6DF5ECB4F317E", hash_generated_method = "DA2121264E0ECCE722C6376964F0B077")
    
public DataActivityState getDataActivityState() {
        DataActivityState ret = DataActivityState.NONE;

        if (mSST.getCurrentGprsState() == ServiceState.STATE_IN_SERVICE) {
            switch (mDataConnectionTracker.getActivity()) {
                case DATAIN:
                    ret = DataActivityState.DATAIN;
                break;

                case DATAOUT:
                    ret = DataActivityState.DATAOUT;
                break;

                case DATAINANDOUT:
                    ret = DataActivityState.DATAINANDOUT;
                break;
            }
        }

        return ret;
    }

    /**
     * Notify any interested party of a Phone state change {@link Phone.State}
     */
    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.139 -0500", hash_original_method = "812A77A153EDB691C43A0B58CAFAA77A", hash_generated_method = "812A77A153EDB691C43A0B58CAFAA77A")
    
void notifyPhoneStateChanged() {
        mNotifier.notifyPhoneState(this);
    }

    /**
     * Notify registrants of a change in the call state. This notifies changes in {@link Call.State}
     * Use this when changes in the precise call state are needed, else use notifyPhoneStateChanged.
     */
    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.141 -0500", hash_original_method = "3EB8461625C29B29FD6CB8E5D60B43F3", hash_generated_method = "12015DBC20468C486AF905F9802DB743")
    
void notifyPreciseCallStateChanged() {
        /* we'd love it if this was package-scoped*/
        super.notifyPreciseCallStateChangedP();
    }

    /*package*/ @DSSink({DSSinkKind.PHONE_STATE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.143 -0500", hash_original_method = "292444BE96E352C8E8312B338E19EF02", hash_generated_method = "990C97FD08BF8064CCDF498BC93F23E9")
    
void
    notifyNewRingingConnection(Connection c) {
        /* we'd love it if this was package-scoped*/
        super.notifyNewRingingConnectionP(c);
    }

    /*package*/ @DSSink({DSSinkKind.PHONE_STATE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.145 -0500", hash_original_method = "1858091673D3A4B62C058FCC91892C36", hash_generated_method = "1858091673D3A4B62C058FCC91892C36")
    
void
    notifyDisconnect(Connection cn) {
        mDisconnectRegistrants.notifyResult(cn);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.147 -0500", hash_original_method = "4DFA3B176AED92FABCFB596FBC88C127", hash_generated_method = "4DFA3B176AED92FABCFB596FBC88C127")
    
void notifyUnknownConnection() {
        mUnknownConnectionRegistrants.notifyResult(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.149 -0500", hash_original_method = "952D093251486E722309085461233179", hash_generated_method = "952D093251486E722309085461233179")
    
void notifySuppServiceFailed(SuppService code) {
        mSuppServiceFailedRegistrants.notifyResult(code);
    }

    /*package*/ @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.152 -0500", hash_original_method = "73E7BFF04E4E9785E6146409272926BA", hash_generated_method = "73E7BFF04E4E9785E6146409272926BA")
    
void
    notifyServiceStateChanged(ServiceState ss) {
        super.notifyServiceStateChangedP(ss);
    }

    /*package*/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.154 -0500", hash_original_method = "482FE18FBD1949DAF708F2E65940DE8F", hash_generated_method = "482FE18FBD1949DAF708F2E65940DE8F")
    
void notifyLocationChanged() {
        mNotifier.notifyCellLocation(this);
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.156 -0500", hash_original_method = "FCBAE539BB72BE21647FF37299DC2B96", hash_generated_method = "FCBAE539BB72BE21647FF37299DC2B96")
    
void
    notifySignalStrength() {
        mNotifier.notifySignalStrength(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.159 -0500", hash_original_method = "25487D51A5547C84DC8EEF33482B43EF", hash_generated_method = "27274BB1C80ABA32305B3C620B24E439")
    
public void
    notifyCallForwardingIndicator() {
        mNotifier.notifyCallForwardingChanged(this);
    }

    // override for allowing access from other classes of this package
    /**
     * {@inheritDoc}
     */
    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.161 -0500", hash_original_method = "C4157CB043EC8B3384F8270EB7DCD5BB", hash_generated_method = "A23F33679D922B6A305F95FDA36AFC9C")
    
public final void
    setSystemProperty(String property, String value) {
        super.setSystemProperty(property, value);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.163 -0500", hash_original_method = "02E1DF9EF058739EC655251AF002C09F", hash_generated_method = "784B0E93E982FE2DA18A184A81D941FE")
    
public void registerForSuppServiceNotification(
            Handler h, int what, Object obj) {
        mSsnRegistrants.addUnique(h, what, obj);
        if (mSsnRegistrants.size() == 1) mCM.setSuppServiceNotifications(true, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.166 -0500", hash_original_method = "001FDCA2544BEBF92715B871E5466F8E", hash_generated_method = "88EE42E3C9CDF5E03DD3FB43B50B382D")
    
public void unregisterForSuppServiceNotification(Handler h) {
        mSsnRegistrants.remove(h);
        if (mSsnRegistrants.size() == 0) mCM.setSuppServiceNotifications(false, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.168 -0500", hash_original_method = "C62CCD6CF2D9D7F7FA17BB7B58067AAC", hash_generated_method = "52AF5C8600DFA81FDF4490B3A5F0068E")
    
public void
    acceptCall() throws CallStateException {
        mCT.acceptCall();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.170 -0500", hash_original_method = "A64616985F0D82C6750D71CF8DADC6F4", hash_generated_method = "C876DE01453AEC50846B853D1624B6C4")
    
public void
    rejectCall() throws CallStateException {
        mCT.rejectCall();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.172 -0500", hash_original_method = "4BD56579DA53A7A8E0646A63E1978FC8", hash_generated_method = "EE9FD5B84F981002A80E9AC478CE174B")
    
public void
    switchHoldingAndActive() throws CallStateException {
        mCT.switchWaitingOrHoldingAndActive();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.174 -0500", hash_original_method = "01AA81103C1764FB5FE5BC7D2791F36E", hash_generated_method = "05529C28334D75DCCC303F4B1DD0E300")
    
public boolean canConference() {
        return mCT.canConference();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.177 -0500", hash_original_method = "27A0C6F6921751B2F5D5EAA31130917E", hash_generated_method = "1F540670AB6AF102030C40074E31E2E1")
    
public boolean canDial() {
        return mCT.canDial();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.179 -0500", hash_original_method = "ED1426E2C308CED60BE3C0151AD877C7", hash_generated_method = "15C0EAE9A711A6FEEBC1E3349DA7E485")
    
public void conference() throws CallStateException {
        mCT.conference();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.182 -0500", hash_original_method = "B9932A8A8BD16A4F0D461DDC6FDE6B49", hash_generated_method = "B80DF2078F3D95B23D221CA91BE45CDD")
    
public void clearDisconnected() {
        mCT.clearDisconnected();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.184 -0500", hash_original_method = "36A0747921C9C16BA6E56F404827E4EB", hash_generated_method = "FED18D212487A54B406928DC8D55DFB1")
    
public boolean canTransfer() {
        return mCT.canTransfer();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.186 -0500", hash_original_method = "844E9AE7DC0EF8644470861505601222", hash_generated_method = "A58D2D19C3506320FEA1BD6488A2C97B")
    
public void explicitCallTransfer() throws CallStateException {
        mCT.explicitCallTransfer();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.188 -0500", hash_original_method = "A46545098103F91B00276659EE365887", hash_generated_method = "7EBE4709BC35DDB302D87496D7F71BB6")
    
public GsmCall
    getForegroundCall() {
        return mCT.foregroundCall;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.191 -0500", hash_original_method = "142F0A4524F2CBB8716568AB3A761D12", hash_generated_method = "54F3C579F8EB0B744BA929B5A2AC6C0F")
    
public GsmCall
    getBackgroundCall() {
        return mCT.backgroundCall;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.193 -0500", hash_original_method = "F87806E8E26806695F0525D42F1D7DD4", hash_generated_method = "6D2CF7E61CE9430049A25C49C3CCF6C3")
    
public GsmCall
    getRingingCall() {
        return mCT.ringingCall;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.196 -0500", hash_original_method = "3A1042FC51BD24241CBFB1D3DBD11D23", hash_generated_method = "57AD1696A711001DC3233D60CE07A924")
    
private boolean handleCallDeflectionIncallSupplementaryService(
            String dialString) throws CallStateException {
        if (dialString.length() > 1) {
            return false;
        }

        if (getRingingCall().getState() != GsmCall.State.IDLE) {
            if (LOCAL_DEBUG) Log.d(LOG_TAG, "MmiCode 0: rejectCall");
            try {
                mCT.rejectCall();
            } catch (CallStateException e) {
                if (LOCAL_DEBUG) Log.d(LOG_TAG,
                    "reject failed", e);
                notifySuppServiceFailed(Phone.SuppService.REJECT);
            }
        } else if (getBackgroundCall().getState() != GsmCall.State.IDLE) {
            if (LOCAL_DEBUG) Log.d(LOG_TAG,
                    "MmiCode 0: hangupWaitingOrBackground");
            mCT.hangupWaitingOrBackground();
        }

        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.199 -0500", hash_original_method = "54841B6AA04B8F69693CDF35FACFE6EA", hash_generated_method = "A6E1E38B7B339950D10BB7953094BC41")
    
private boolean handleCallWaitingIncallSupplementaryService(
            String dialString) throws CallStateException {
        int len = dialString.length();

        if (len > 2) {
            return false;
        }

        GsmCall call = (GsmCall) getForegroundCall();

        try {
            if (len > 1) {
                char ch = dialString.charAt(1);
                int callIndex = ch - '0';

                if (callIndex >= 1 && callIndex <= GsmCallTracker.MAX_CONNECTIONS) {
                    if (LOCAL_DEBUG) Log.d(LOG_TAG,
                            "MmiCode 1: hangupConnectionByIndex " +
                            callIndex);
                    mCT.hangupConnectionByIndex(call, callIndex);
                }
            } else {
                if (call.getState() != GsmCall.State.IDLE) {
                    if (LOCAL_DEBUG) Log.d(LOG_TAG,
                            "MmiCode 1: hangup foreground");
                    //mCT.hangupForegroundResumeBackground();
                    mCT.hangup(call);
                } else {
                    if (LOCAL_DEBUG) Log.d(LOG_TAG,
                            "MmiCode 1: switchWaitingOrHoldingAndActive");
                    mCT.switchWaitingOrHoldingAndActive();
                }
            }
        } catch (CallStateException e) {
            if (LOCAL_DEBUG) Log.d(LOG_TAG,
                "hangup failed", e);
            notifySuppServiceFailed(Phone.SuppService.HANGUP);
        }

        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.203 -0500", hash_original_method = "F4FAEC22329B0BDDF008B69FB760B2A4", hash_generated_method = "136BAF85F2698147BDFD8E6DC852E790")
    
private boolean handleCallHoldIncallSupplementaryService(String dialString)
            throws CallStateException {
        int len = dialString.length();

        if (len > 2) {
            return false;
        }

        GsmCall call = (GsmCall) getForegroundCall();

        if (len > 1) {
            try {
                char ch = dialString.charAt(1);
                int callIndex = ch - '0';
                GsmConnection conn = mCT.getConnectionByIndex(call, callIndex);

                // gsm index starts at 1, up to 5 connections in a call,
                if (conn != null && callIndex >= 1 && callIndex <= GsmCallTracker.MAX_CONNECTIONS) {
                    if (LOCAL_DEBUG) Log.d(LOG_TAG, "MmiCode 2: separate call "+
                            callIndex);
                    mCT.separate(conn);
                } else {
                    if (LOCAL_DEBUG) Log.d(LOG_TAG, "separate: invalid call index "+
                            callIndex);
                    notifySuppServiceFailed(Phone.SuppService.SEPARATE);
                }
            } catch (CallStateException e) {
                if (LOCAL_DEBUG) Log.d(LOG_TAG,
                    "separate failed", e);
                notifySuppServiceFailed(Phone.SuppService.SEPARATE);
            }
        } else {
            try {
                if (getRingingCall().getState() != GsmCall.State.IDLE) {
                    if (LOCAL_DEBUG) Log.d(LOG_TAG,
                    "MmiCode 2: accept ringing call");
                    mCT.acceptCall();
                } else {
                    if (LOCAL_DEBUG) Log.d(LOG_TAG,
                    "MmiCode 2: switchWaitingOrHoldingAndActive");
                    mCT.switchWaitingOrHoldingAndActive();
                }
            } catch (CallStateException e) {
                if (LOCAL_DEBUG) Log.d(LOG_TAG,
                    "switch failed", e);
                notifySuppServiceFailed(Phone.SuppService.SWITCH);
            }
        }

        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.205 -0500", hash_original_method = "A61A93477751B5EFFB3B26065CE7F8F7", hash_generated_method = "E4BDD904788275B41F3BCABCB582FDC9")
    
private boolean handleMultipartyIncallSupplementaryService(
            String dialString) throws CallStateException {
        if (dialString.length() > 1) {
            return false;
        }

        if (LOCAL_DEBUG) Log.d(LOG_TAG, "MmiCode 3: merge calls");
        try {
            conference();
        } catch (CallStateException e) {
            if (LOCAL_DEBUG) Log.d(LOG_TAG,
                "conference failed", e);
            notifySuppServiceFailed(Phone.SuppService.CONFERENCE);
        }
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.208 -0500", hash_original_method = "D22F8E83AE3C2E24760F930E8B1C0AF8", hash_generated_method = "8F3B39A29624D2DBC036FB8473D99B56")
    
private boolean handleEctIncallSupplementaryService(String dialString)
            throws CallStateException {

        int len = dialString.length();

        if (len != 1) {
            return false;
        }

        if (LOCAL_DEBUG) Log.d(LOG_TAG, "MmiCode 4: explicit call transfer");
        try {
            explicitCallTransfer();
        } catch (CallStateException e) {
            if (LOCAL_DEBUG) Log.d(LOG_TAG,
                "transfer failed", e);
            notifySuppServiceFailed(Phone.SuppService.TRANSFER);
        }
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.210 -0500", hash_original_method = "F0B7315BB3E501E36AB72E6B89A34578", hash_generated_method = "27E7DBADD784154319EDA25F0FA0EFEE")
    
private boolean handleCcbsIncallSupplementaryService(String dialString)
            throws CallStateException {
        if (dialString.length() > 1) {
            return false;
        }

        Log.i(LOG_TAG, "MmiCode 5: CCBS not supported!");
        // Treat it as an "unknown" service.
        notifySuppServiceFailed(Phone.SuppService.UNKNOWN);
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.213 -0500", hash_original_method = "ADE3D3CB52AC1581EEE1CFCBED33E09A", hash_generated_method = "706C13E4C1FC337E4C725F7BD25D5A6C")
    
public boolean handleInCallMmiCommands(String dialString)
            throws CallStateException {
        if (!isInCall()) {
            return false;
        }

        if (TextUtils.isEmpty(dialString)) {
            return false;
        }

        boolean result = false;
        char ch = dialString.charAt(0);
        switch (ch) {
            case '0':
                result = handleCallDeflectionIncallSupplementaryService(
                        dialString);
                break;
            case '1':
                result = handleCallWaitingIncallSupplementaryService(
                        dialString);
                break;
            case '2':
                result = handleCallHoldIncallSupplementaryService(dialString);
                break;
            case '3':
                result = handleMultipartyIncallSupplementaryService(dialString);
                break;
            case '4':
                result = handleEctIncallSupplementaryService(dialString);
                break;
            case '5':
                result = handleCcbsIncallSupplementaryService(dialString);
                break;
            default:
                break;
        }

        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.215 -0500", hash_original_method = "711944CD15C0B30B5C3E1DF07833B9CC", hash_generated_method = "711944CD15C0B30B5C3E1DF07833B9CC")
    
boolean isInCall() {
        GsmCall.State foregroundCallState = getForegroundCall().getState();
        GsmCall.State backgroundCallState = getBackgroundCall().getState();
        GsmCall.State ringingCallState = getRingingCall().getState();

       return (foregroundCallState.isAlive() ||
                backgroundCallState.isAlive() ||
                ringingCallState.isAlive());
    }

    @DSSink({DSSinkKind.VOIP})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.217 -0500", hash_original_method = "869C8D5C9810AA3DB7F9F221ECFAACBF", hash_generated_method = "FA27F8B52A91659234A63A8ACEBB51B3")
    
public Connection
    dial(String dialString) throws CallStateException {
        return dial(dialString, null);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.220 -0500", hash_original_method = "905878DD9E4370A9706866C1B8D62D03", hash_generated_method = "8B515940060533A36817B33EFC195750")
    
public Connection
    dial (String dialString, UUSInfo uusInfo) throws CallStateException {
        // Need to make sure dialString gets parsed properly
        String newDialString = PhoneNumberUtils.stripSeparators(dialString);

        // handle in-call MMI first if applicable
        if (handleInCallMmiCommands(newDialString)) {
            return null;
        }

        // Only look at the Network portion for mmi
        String networkPortion = PhoneNumberUtils.extractNetworkPortionAlt(newDialString);
        GsmMmiCode mmi = GsmMmiCode.newFromDialString(networkPortion, this);
        if (LOCAL_DEBUG) Log.d(LOG_TAG,
                               "dialing w/ mmi '" + mmi + "'...");

        if (mmi == null) {
            return mCT.dial(newDialString, uusInfo);
        } else if (mmi.isTemporaryModeCLIR()) {
            return mCT.dial(mmi.dialingNumber, mmi.getCLIRMode(), uusInfo);
        } else {
            mPendingMMIs.add(mmi);
            mMmiRegistrants.notifyRegistrants(new AsyncResult(null, mmi, null));
            mmi.processCode();

            // FIXME should this return null or something else?
            return null;
        }
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.222 -0500", hash_original_method = "4BA0C4BD36DFB68226B2317C39970473", hash_generated_method = "C2F2F22EDE4BCECA199985561EF0FFEB")
    
public boolean handlePinMmi(String dialString) {
        GsmMmiCode mmi = GsmMmiCode.newFromDialString(dialString, this);

        if (mmi != null && mmi.isPinCommand()) {
            mPendingMMIs.add(mmi);
            mMmiRegistrants.notifyRegistrants(new AsyncResult(null, mmi, null));
            mmi.processCode();
            return true;
        }

        return false;
    }

    @DSSink({DSSinkKind.PHONE_CONNECTION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.225 -0500", hash_original_method = "0D802E3B18B63F6835A66AA15E37A07D", hash_generated_method = "F9B58B413F471AB454A3FF1BCF20AEE9")
    
public void sendUssdResponse(String ussdMessge) {
        GsmMmiCode mmi = GsmMmiCode.newFromUssdUserInput(ussdMessge, this);
        mPendingMMIs.add(mmi);
        mMmiRegistrants.notifyRegistrants(new AsyncResult(null, mmi, null));
        mmi.sendUssd(ussdMessge);
    }

    @DSSink({DSSinkKind.PHONE_CONNECTION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.228 -0500", hash_original_method = "98607162C44D8873925496654D522BF8", hash_generated_method = "A80C5B09DA17CC16D06DE98B01BF320A")
    
public void
    sendDtmf(char c) {
        if (!PhoneNumberUtils.is12Key(c)) {
            Log.e(LOG_TAG,
                    "sendDtmf called with invalid character '" + c + "'");
        } else {
            if (mCT.state ==  Phone.State.OFFHOOK) {
                mCM.sendDtmf(c, null);
            }
        }
    }

    @DSSink({DSSinkKind.PHONE_CONNECTION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.230 -0500", hash_original_method = "3FBA1333099AE68AF02019D712D23AB2", hash_generated_method = "D9801C8D2F605F56D81343C15291222C")
    
public void
    startDtmf(char c) {
        if (!PhoneNumberUtils.is12Key(c)) {
            Log.e(LOG_TAG,
                "startDtmf called with invalid character '" + c + "'");
        } else {
            mCM.startDtmf(c, null);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.232 -0500", hash_original_method = "3DAC039DE959EF34631E2B825CE1F213", hash_generated_method = "6AAF589BD7BAF018024B86F06E00F6CF")
    
public void
    stopDtmf() {
        mCM.stopDtmf(null);
    }

    @DSSink({DSSinkKind.PHONE_CONNECTION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.235 -0500", hash_original_method = "632DA8A1165B474AAA75C1A965AA7035", hash_generated_method = "B53A9D4C03F6FD3EB455054DE971EED3")
    
public void
    sendBurstDtmf(String dtmfString) {
        Log.e(LOG_TAG, "[GSMPhone] sendBurstDtmf() is a CDMA method");
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.237 -0500", hash_original_method = "6583EBFAAE11F5B271B0C202AB11C3E9", hash_generated_method = "80FF770A1CF7676AE7FE5F84ACA216E2")
    
public void
    setRadioPower(boolean power) {
        mSST.setRadioPower(power);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.239 -0500", hash_original_method = "E7F586CDCE74786257222FAC0983E7F9", hash_generated_method = "7DF998760D0420343E77842D2907A756")
    
private void storeVoiceMailNumber(String number) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(VM_NUMBER, number);
        editor.apply();
        setVmSimImsi(getSubscriberId());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.242 -0500", hash_original_method = "69924A8239B9858372407D5C2A54772B", hash_generated_method = "222D07FB41F2E740DF384A68456A0BE8")
    
public String getVoiceMailNumber() {
        // Read from the SIM. If its null, try reading from the shared preference area.
        String number = mIccRecords.getVoiceMailNumber();
        if (TextUtils.isEmpty(number)) {
            SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
            number = sp.getString(VM_NUMBER, null);
        }
        return number;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.244 -0500", hash_original_method = "767A05C9F746992519407618C38B7609", hash_generated_method = "6E3F72505581669574E1B4CD0DE18BD0")
    
private String getVmSimImsi() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        return sp.getString(VM_SIM_IMSI, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.247 -0500", hash_original_method = "8C96CC1C916F049093DF13C1B1327265", hash_generated_method = "DED54D2AA554230BDCFCF35CB0D3640A")
    
private void setVmSimImsi(String imsi) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(VM_SIM_IMSI, imsi);
        editor.apply();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.249 -0500", hash_original_method = "445A2067BED895487F73AC5A870ED091", hash_generated_method = "8E8A9AC5E842E746ED6EBC6B12B3B6DA")
    
public String getVoiceMailAlphaTag() {
        String ret;

        ret = mIccRecords.getVoiceMailAlphaTag();

        if (ret == null || ret.length() == 0) {
            return mContext.getText(
                com.android.internal.R.string.defaultVoiceMailAlphaTag).toString();
        }

        return ret;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.252 -0500", hash_original_method = "40864F79C0287ACEFC2860E74923A158", hash_generated_method = "B560E42634F81F7F31852A8B9B8AEFA7")
    
public String getDeviceId() {
        return mImei;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.254 -0500", hash_original_method = "14B7BB34E0FC203F73344BD326AAB989", hash_generated_method = "EBF80782E55C6D8958328B1617A5FD71")
    
public String getDeviceSvn() {
        return mImeiSv;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.256 -0500", hash_original_method = "2BFB931234EFCBDA06B75AE314A70B6B", hash_generated_method = "03CE2169B9C4CE55BC796943935E9D1A")
    
public String getImei() {
        return mImei;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.259 -0500", hash_original_method = "8337C263E1C0C858E7E7356286A6EE86", hash_generated_method = "4DAF9CF678BC234784E11F987FBC8F35")
    
public String getEsn() {
        Log.e(LOG_TAG, "[GSMPhone] getEsn() is a CDMA method");
        return "0";
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.261 -0500", hash_original_method = "92AF0460E6B1DF6A22F32869474C6DE7", hash_generated_method = "389ADF9FE18E10A2C6979F77591B5DD9")
    
public String getMeid() {
        Log.e(LOG_TAG, "[GSMPhone] getMeid() is a CDMA method");
        return "0";
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.263 -0500", hash_original_method = "418ED398A6A3FF53B03B4C5008FE3F90", hash_generated_method = "4AD08ABB9F3E988512FE6A84DCBF57B4")
    
public String getSubscriberId() {
        return mIccRecords.getIMSI();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.265 -0500", hash_original_method = "084DD7ECDC7A6E289A4C2D9F1DE10A12", hash_generated_method = "77FB3EEE026F5657C535D724F143D99A")
    
public String getLine1Number() {
        return mIccRecords.getMsisdnNumber();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.267 -0500", hash_original_method = "0F1A42666FEB7039E59CE38A804A2571", hash_generated_method = "C643750F6EC44E71120807E5FC6FB0C0")
    
@Override
    public String getMsisdn() {
        return mIccRecords.getMsisdnNumber();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.270 -0500", hash_original_method = "D360BD2B0AE3500C93B786BA943E8C4F", hash_generated_method = "5DBE54EDDCBD1B238CBF8E3D9E3CF330")
    
public String getLine1AlphaTag() {
        return mIccRecords.getMsisdnAlphaTag();
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.272 -0500", hash_original_method = "F8CED3952B50871548C8F8795A72A874", hash_generated_method = "21AD4B002987DFB4F8F07C73DC43714C")
    
public void setLine1Number(String alphaTag, String number, Message onComplete) {
        mIccRecords.setMsisdnNumber(alphaTag, number, onComplete);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.275 -0500", hash_original_method = "63103D1CE9C7888BE66C8CE520564C7E", hash_generated_method = "3348F01B1BE6A390D1B7E60FC9671A08")
    
public void setVoiceMailNumber(String alphaTag,
                            String voiceMailNumber,
                            Message onComplete) {

        Message resp;
        mVmNumber = voiceMailNumber;
        resp = obtainMessage(EVENT_SET_VM_NUMBER_DONE, 0, 0, onComplete);
        mIccRecords.setVoiceMailNumber(alphaTag, mVmNumber, resp);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.277 -0500", hash_original_method = "9DDD364B83D4A188246C8EC4129A09D5", hash_generated_method = "C71F1E003435C95189167808EC761653")
    
private boolean isValidCommandInterfaceCFReason (int commandInterfaceCFReason) {
        switch (commandInterfaceCFReason) {
        case CF_REASON_UNCONDITIONAL:
        case CF_REASON_BUSY:
        case CF_REASON_NO_REPLY:
        case CF_REASON_NOT_REACHABLE:
        case CF_REASON_ALL:
        case CF_REASON_ALL_CONDITIONAL:
            return true;
        default:
            return false;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.280 -0500", hash_original_method = "138625FFD93D7E6FCFD9298408C66777", hash_generated_method = "2981A28DD24632006859DAE4F7765269")
    
private boolean isValidCommandInterfaceCFAction (int commandInterfaceCFAction) {
        switch (commandInterfaceCFAction) {
        case CF_ACTION_DISABLE:
        case CF_ACTION_ENABLE:
        case CF_ACTION_REGISTRATION:
        case CF_ACTION_ERASURE:
            return true;
        default:
            return false;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.282 -0500", hash_original_method = "E62FA7EF147A8759C3C5908B3838581B", hash_generated_method = "0DEE53D4F266FF81B24E833928979074")
    
protected  boolean isCfEnable(int action) {
        return (action == CF_ACTION_ENABLE) || (action == CF_ACTION_REGISTRATION);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.284 -0500", hash_original_method = "08670889C34D44E522747D6078786295", hash_generated_method = "EBE722E7AF8A405FE0708C5FEF4E75F0")
    
public void getCallForwardingOption(int commandInterfaceCFReason, Message onComplete) {
        if (isValidCommandInterfaceCFReason(commandInterfaceCFReason)) {
            if (LOCAL_DEBUG) Log.d(LOG_TAG, "requesting call forwarding query.");
            Message resp;
            if (commandInterfaceCFReason == CF_REASON_UNCONDITIONAL) {
                resp = obtainMessage(EVENT_GET_CALL_FORWARD_DONE, onComplete);
            } else {
                resp = onComplete;
            }
            mCM.queryCallForwardStatus(commandInterfaceCFReason,0,null,resp);
        }
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.288 -0500", hash_original_method = "C31B5CE81010007284F85A1CC1A97426", hash_generated_method = "095CECBA079113CD7E6FA28894066D00")
    
public void setCallForwardingOption(int commandInterfaceCFAction,
            int commandInterfaceCFReason,
            String dialingNumber,
            int timerSeconds,
            Message onComplete) {
        if (    (isValidCommandInterfaceCFAction(commandInterfaceCFAction)) &&
                (isValidCommandInterfaceCFReason(commandInterfaceCFReason))) {

            Message resp;
            if (commandInterfaceCFReason == CF_REASON_UNCONDITIONAL) {
                resp = obtainMessage(EVENT_SET_CALL_FORWARD_DONE,
                        isCfEnable(commandInterfaceCFAction) ? 1 : 0, 0, onComplete);
            } else {
                resp = onComplete;
            }
            mCM.setCallForward(commandInterfaceCFAction,
                    commandInterfaceCFReason,
                    CommandsInterface.SERVICE_CLASS_VOICE,
                    dialingNumber,
                    timerSeconds,
                    resp);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.290 -0500", hash_original_method = "211ADA06D97F0C35F6F35D44159D1041", hash_generated_method = "A00C675719A0FCBE60CEB014698D9A39")
    
public void getOutgoingCallerIdDisplay(Message onComplete) {
        mCM.getCLIR(onComplete);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.292 -0500", hash_original_method = "9A33528D3F7EB56FD0CAE46DED766DA5", hash_generated_method = "570B8F0D24BE0DC1400C391CC67F28A3")
    
public void setOutgoingCallerIdDisplay(int commandInterfaceCLIRMode,
                                           Message onComplete) {
        mCM.setCLIR(commandInterfaceCLIRMode,
                obtainMessage(EVENT_SET_CLIR_COMPLETE, commandInterfaceCLIRMode, 0, onComplete));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.295 -0500", hash_original_method = "5AA95CCFAB839BE19F56DECDE6C06EAE", hash_generated_method = "97FD81E0EF8E66910236514B0DC7D936")
    
public void getCallWaiting(Message onComplete) {
        //As per 3GPP TS 24.083, section 1.6 UE doesn't need to send service
        //class parameter in call waiting interrogation  to network
        mCM.queryCallWaiting(CommandsInterface.SERVICE_CLASS_NONE, onComplete);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.297 -0500", hash_original_method = "378FD22E0CB0CF1CC5C649D301CEF0C1", hash_generated_method = "9B2A24761A19C0DDCE12B070EE76CB02")
    
public void setCallWaiting(boolean enable, Message onComplete) {
        mCM.setCallWaiting(enable, CommandsInterface.SERVICE_CLASS_VOICE, onComplete);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.299 -0500", hash_original_method = "4DC55439AC7C450EEFD22BFFC07D3CE9", hash_generated_method = "F692D6EBF3F75FCD96D227D6D65E6E5B")
    
public void
    getAvailableNetworks(Message response) {
        mCM.getAvailableNetworks(response);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.312 -0500", hash_original_method = "21AFB30263A6CEDCB2E90901BACA2953", hash_generated_method = "8EE0F0574BF9E4C2E1F63BBD88CEA7E5")
    
public void
    setNetworkSelectionModeAutomatic(Message response) {
        // wrap the response message in our own message along with
        // an empty string (to indicate automatic selection) for the
        // operator's id.
        NetworkSelectMessage nsm = new NetworkSelectMessage();
        nsm.message = response;
        nsm.operatorNumeric = "";
        nsm.operatorAlphaLong = "";

        // get the message
        Message msg = obtainMessage(EVENT_SET_NETWORK_AUTOMATIC_COMPLETE, nsm);
        if (LOCAL_DEBUG)
            Log.d(LOG_TAG, "wrapping and sending message to connect automatically");

        mCM.setNetworkSelectionModeAutomatic(msg);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.314 -0500", hash_original_method = "388CF66FD02B64F200B61D1E744A0B56", hash_generated_method = "0E968BC1617A80DED1425F4C1B5CA3F7")
    
public void
    selectNetworkManually(OperatorInfo network,
            Message response) {
        // wrap the response message in our own message along with
        // the operator's id.
        NetworkSelectMessage nsm = new NetworkSelectMessage();
        nsm.message = response;
        nsm.operatorNumeric = network.getOperatorNumeric();
        nsm.operatorAlphaLong = network.getOperatorAlphaLong();

        // get the message
        Message msg = obtainMessage(EVENT_SET_NETWORK_MANUAL_COMPLETE, nsm);

        mCM.setNetworkSelectionModeManual(network.getOperatorNumeric(), msg);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.316 -0500", hash_original_method = "3A54DC42D0DFD8C763BDF4414C51677B", hash_generated_method = "86DA474FBF22886F99F7D1EF378806B3")
    
public void
    getNeighboringCids(Message response) {
        mCM.getNeighboringCids(response);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.319 -0500", hash_original_method = "A54F4B18F21B3A39961648F4BDA2F061", hash_generated_method = "95390C406E6E2FA690715623B2F3AA59")
    
public void setOnPostDialCharacter(Handler h, int what, Object obj) {
        mPostDialHandler = new Registrant(h, what, obj);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.322 -0500", hash_original_method = "E892EC268DCFDF5C9C27A7DDC7E00573", hash_generated_method = "6702E37291BD1A4A6BCF74E7D5962B7E")
    
public void setMute(boolean muted) {
        mCT.setMute(muted);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.324 -0500", hash_original_method = "FA6E824680C8944626A1A959DCEA6499", hash_generated_method = "3E1D6B8514C7CF066D919EF92B2E88D5")
    
public boolean getMute() {
        return mCT.getMute();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.326 -0500", hash_original_method = "DAED77F9218E0449A772CA04214CC7F0", hash_generated_method = "DF9F743D65FEFF6BF334F9A94A48954F")
    
public void getDataCallList(Message response) {
        mCM.getDataCallList(response);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.328 -0500", hash_original_method = "96CADC2872DB4F7FDEDEDD322815973F", hash_generated_method = "BE019B870DE311876CD1A9479D007B37")
    
public void updateServiceLocation() {
        mSST.enableSingleLocationUpdate();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.331 -0500", hash_original_method = "85721F5820CF0128BD1EA66BA785E274", hash_generated_method = "E20D8DD4B2C4455D6BDD1A294D2C6018")
    
public void enableLocationUpdates() {
        mSST.enableLocationUpdates();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.333 -0500", hash_original_method = "E6FECC87DDBB4D4FE984E494757397E3", hash_generated_method = "B48F59D8CA25DC490DCA5F8946EC478C")
    
public void disableLocationUpdates() {
        mSST.disableLocationUpdates();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.335 -0500", hash_original_method = "33CDF43696035DC3E16A234222A80D64", hash_generated_method = "0A4E3A1DD4AA9D90F0E17CE7435D79D6")
    
public boolean getDataRoamingEnabled() {
        return mDataConnectionTracker.getDataOnRoamingEnabled();
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.337 -0500", hash_original_method = "910AE5D7D70CC37EC2511A21C3761E3A", hash_generated_method = "9007A6C5DAD94BD2A91DDACD886335AD")
    
public void setDataRoamingEnabled(boolean enable) {
        mDataConnectionTracker.setDataOnRoamingEnabled(enable);
    }

    /**
     * Removes the given MMI from the pending list and notifies
     * registrants that it is complete.
     * @param mmi MMI that is done
     */
    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.340 -0500", hash_original_method = "AC949E64AEE76B7FF936E7A1B08DF381", hash_generated_method = "07410662D5F8988EAC507F19EF8D94E0")
    
void
    onMMIDone(GsmMmiCode mmi) {
        /* Only notify complete if it's on the pending list.
         * Otherwise, it's already been handled (eg, previously canceled).
         * The exception is cancellation of an incoming USSD-REQUEST, which is
         * not on the list.
         */
        if (mPendingMMIs.remove(mmi) || mmi.isUssdRequest()) {
            mMmiCompleteRegistrants.notifyRegistrants(
                new AsyncResult(null, mmi, null));
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.342 -0500", hash_original_method = "7B2BAD4339ABD08CFCEAE93D5F289166", hash_generated_method = "851E35E3CAB4CEF0A1E5C7A3D21F67FA")
    
private void
    onNetworkInitiatedUssd(GsmMmiCode mmi) {
        mMmiCompleteRegistrants.notifyRegistrants(
            new AsyncResult(null, mmi, null));
    }

    /** ussdMode is one of CommandsInterface.USSD_MODE_* */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.344 -0500", hash_original_method = "FA8827AA61AE68EAA1082E2A36657BA2", hash_generated_method = "C7016AD65B82B5A023FDD69FD823ADA1")
    
private void
    onIncomingUSSD (int ussdMode, String ussdMessage) {
        boolean isUssdError;
        boolean isUssdRequest;

        isUssdRequest
            = (ussdMode == CommandsInterface.USSD_MODE_REQUEST);

        isUssdError
            = (ussdMode != CommandsInterface.USSD_MODE_NOTIFY
                && ussdMode != CommandsInterface.USSD_MODE_REQUEST);

        // See comments in GsmMmiCode.java
        // USSD requests aren't finished until one
        // of these two events happen
        GsmMmiCode found = null;
        for (int i = 0, s = mPendingMMIs.size() ; i < s; i++) {
            if(mPendingMMIs.get(i).isPendingUSSD()) {
                found = mPendingMMIs.get(i);
                break;
            }
        }

        if (found != null) {
            // Complete pending USSD

            if (isUssdError) {
                found.onUssdFinishedError();
            } else {
                found.onUssdFinished(ussdMessage, isUssdRequest);
            }
        } else { // pending USSD not found
            // The network may initiate its own USSD request

            // ignore everything that isnt a Notify or a Request
            // also, discard if there is no message to present
            if (!isUssdError && ussdMessage != null) {
                GsmMmiCode mmi;
                mmi = GsmMmiCode.newNetworkInitiatedUssd(ussdMessage,
                                                   isUssdRequest,
                                                   GSMPhone.this);
                onNetworkInitiatedUssd(mmi);
            }
        }
    }

    /**
     * Make sure the network knows our preferred setting.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.347 -0500", hash_original_method = "B501A93D9CBCF588AB28D650AA03E986", hash_generated_method = "3AF269BE68360F55A86A36CC1C885EF7")
    
protected  void syncClirSetting() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        int clirSetting = sp.getInt(CLIR_KEY, -1);
        if (clirSetting >= 0) {
            mCM.setCLIR(clirSetting, null);
        }
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.352 -0500", hash_original_method = "EA4D9CE5B4912647996EC04703971BF3", hash_generated_method = "3A2C0D534C66AFA2B2C8B0441F3E0186")
    
@Override
    public void handleMessage (Message msg) {
        AsyncResult ar;
        Message onComplete;

        switch (msg.what) {
            case EVENT_RADIO_AVAILABLE: {
                mCM.getBasebandVersion(
                        obtainMessage(EVENT_GET_BASEBAND_VERSION_DONE));

                mCM.getIMEI(obtainMessage(EVENT_GET_IMEI_DONE));
                mCM.getIMEISV(obtainMessage(EVENT_GET_IMEISV_DONE));
            }
            break;

            case EVENT_RADIO_ON:
            break;

            case EVENT_REGISTERED_TO_NETWORK:
                syncClirSetting();
                break;

            case EVENT_SIM_RECORDS_LOADED:
                updateCurrentCarrierInProvider();

                // Check if this is a different SIM than the previous one. If so unset the
                // voice mail number.
                String imsi = getVmSimImsi();
                String imsiFromSIM = getSubscriberId();
                if (imsi != null && imsiFromSIM != null && !imsiFromSIM.equals(imsi)) {
                    storeVoiceMailNumber(null);
                    setVmSimImsi(null);
                }

            break;

            case EVENT_GET_BASEBAND_VERSION_DONE:
                ar = (AsyncResult)msg.obj;

                if (ar.exception != null) {
                    break;
                }

                if (LOCAL_DEBUG) Log.d(LOG_TAG, "Baseband version: " + ar.result);
                setSystemProperty(PROPERTY_BASEBAND_VERSION, (String)ar.result);
            break;

            case EVENT_GET_IMEI_DONE:
                ar = (AsyncResult)msg.obj;

                if (ar.exception != null) {
                    break;
                }

                mImei = (String)ar.result;
            break;

            case EVENT_GET_IMEISV_DONE:
                ar = (AsyncResult)msg.obj;

                if (ar.exception != null) {
                    break;
                }

                mImeiSv = (String)ar.result;
            break;

            case EVENT_USSD:
                ar = (AsyncResult)msg.obj;

                String[] ussdResult = (String[]) ar.result;

                if (ussdResult.length > 1) {
                    try {
                        onIncomingUSSD(Integer.parseInt(ussdResult[0]), ussdResult[1]);
                    } catch (NumberFormatException e) {
                        Log.w(LOG_TAG, "error parsing USSD");
                    }
                }
            break;

            case EVENT_RADIO_OFF_OR_NOT_AVAILABLE:
                // Some MMI requests (eg USSD) are not completed
                // within the course of a CommandsInterface request
                // If the radio shuts off or resets while one of these
                // is pending, we need to clean up.

                for (int i = 0, s = mPendingMMIs.size() ; i < s; i++) {
                    if (mPendingMMIs.get(i).isPendingUSSD()) {
                        mPendingMMIs.get(i).onUssdFinishedError();
                    }
                }
            break;

            case EVENT_SSN:
                ar = (AsyncResult)msg.obj;
                SuppServiceNotification not = (SuppServiceNotification) ar.result;
                mSsnRegistrants.notifyRegistrants(ar);
            break;

            case EVENT_SET_CALL_FORWARD_DONE:
                ar = (AsyncResult)msg.obj;
                if (ar.exception == null) {
                    mIccRecords.setVoiceCallForwardingFlag(1, msg.arg1 == 1);
                }
                onComplete = (Message) ar.userObj;
                if (onComplete != null) {
                    AsyncResult.forMessage(onComplete, ar.result, ar.exception);
                    onComplete.sendToTarget();
                }
                break;

            case EVENT_SET_VM_NUMBER_DONE:
                ar = (AsyncResult)msg.obj;
                if (IccVmNotSupportedException.class.isInstance(ar.exception)) {
                    storeVoiceMailNumber(mVmNumber);
                    ar.exception = null;
                }
                onComplete = (Message) ar.userObj;
                if (onComplete != null) {
                    AsyncResult.forMessage(onComplete, ar.result, ar.exception);
                    onComplete.sendToTarget();
                }
                break;

            case EVENT_GET_CALL_FORWARD_DONE:
                ar = (AsyncResult)msg.obj;
                if (ar.exception == null) {
                    handleCfuQueryResult((CallForwardInfo[])ar.result);
                }
                onComplete = (Message) ar.userObj;
                if (onComplete != null) {
                    AsyncResult.forMessage(onComplete, ar.result, ar.exception);
                    onComplete.sendToTarget();
                }
                break;

            // handle the select network completion callbacks.
            case EVENT_SET_NETWORK_MANUAL_COMPLETE:
            case EVENT_SET_NETWORK_AUTOMATIC_COMPLETE:
                handleSetSelectNetwork((AsyncResult) msg.obj);
                break;

            case EVENT_SET_CLIR_COMPLETE:
                ar = (AsyncResult)msg.obj;
                if (ar.exception == null) {
                    saveClirSetting(msg.arg1);
                }
                onComplete = (Message) ar.userObj;
                if (onComplete != null) {
                    AsyncResult.forMessage(onComplete, ar.result, ar.exception);
                    onComplete.sendToTarget();
                }
                break;

             default:
                 super.handleMessage(msg);
        }
    }

    /**
     * Sets the "current" field in the telephony provider according to the SIM's operator
     *
     * @return true for success; false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.355 -0500", hash_original_method = "0F23F53D1861BCD51C7CF85FD75916D2", hash_generated_method = "0F23F53D1861BCD51C7CF85FD75916D2")
    
boolean updateCurrentCarrierInProvider() {
        if (mIccRecords != null) {
            try {
                Uri uri = Uri.withAppendedPath(Telephony.Carriers.CONTENT_URI, "current");
                ContentValues map = new ContentValues();
                map.put(Telephony.Carriers.NUMERIC, mIccRecords.getOperatorNumeric());
                mContext.getContentResolver().insert(uri, map);
                return true;
            } catch (SQLException e) {
                Log.e(LOG_TAG, "Can't store current operator", e);
            }
        }
        return false;
    }

    /**
     * Used to track the settings upon completion of the network change.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.358 -0500", hash_original_method = "8C87E0C6EBD471788AC0CD93A9D4E893", hash_generated_method = "4E3BD280C1BAB2E4AFBDDAC8A45B8091")
    
private void handleSetSelectNetwork(AsyncResult ar) {
        // look for our wrapper within the asyncresult, skip the rest if it
        // is null.
        if (!(ar.userObj instanceof NetworkSelectMessage)) {
            if (LOCAL_DEBUG) Log.d(LOG_TAG, "unexpected result from user object.");
            return;
        }

        NetworkSelectMessage nsm = (NetworkSelectMessage) ar.userObj;

        // found the object, now we send off the message we had originally
        // attached to the request.
        if (nsm.message != null) {
            if (LOCAL_DEBUG) Log.d(LOG_TAG, "sending original message to recipient");
            AsyncResult.forMessage(nsm.message, ar.result, ar.exception);
            nsm.message.sendToTarget();
        }

        // open the shared preferences editor, and write the value.
        // nsm.operatorNumeric is "" if we're in automatic.selection.
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(NETWORK_SELECTION_KEY, nsm.operatorNumeric);
        editor.putString(NETWORK_SELECTION_NAME_KEY, nsm.operatorAlphaLong);

        // commit and log the result.
        if (! editor.commit()) {
            Log.e(LOG_TAG, "failed to commit network selection preference");
        }

    }

    /**
     * Saves CLIR setting so that we can re-apply it as necessary
     * (in case the RIL resets it across reboots).
     */
    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.360 -0500", hash_original_method = "C8B4A3CF4267A4CC2FA2952E385D70CE", hash_generated_method = "B79B3B8D410BA539197C8D7A7231B716")
    
public void saveClirSetting(int commandInterfaceCLIRMode) {
        // open the shared preferences editor, and write the value.
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(CLIR_KEY, commandInterfaceCLIRMode);

        // commit and log the result.
        if (! editor.commit()) {
            Log.e(LOG_TAG, "failed to commit CLIR preference");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.364 -0500", hash_original_method = "5FFF1291CED37081608080EEE820D6BC", hash_generated_method = "7B3E195696F084FC8BAF78BF189D601D")
    
private void handleCfuQueryResult(CallForwardInfo[] infos) {
        if (infos == null || infos.length == 0) {
            // Assume the default is not active
            // Set unconditional CFF in SIM to false
            mIccRecords.setVoiceCallForwardingFlag(1, false);
        } else {
            for (int i = 0, s = infos.length; i < s; i++) {
                if ((infos[i].serviceClass & SERVICE_CLASS_VOICE) != 0) {
                    mIccRecords.setVoiceCallForwardingFlag(1, (infos[i].status == 1));
                    // should only have the one
                    break;
                }
            }
        }
    }

    /**
     * Retrieves the PhoneSubInfo of the GSMPhone
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.366 -0500", hash_original_method = "4BF16EE42BDE3709043B0CD4BA1346D5", hash_generated_method = "2BAFF6EDDAB4B6CCB86F157BB9EE1177")
    
public PhoneSubInfo getPhoneSubInfo(){
        return mSubInfo;
    }

    /**
     * Retrieves the IccSmsInterfaceManager of the GSMPhone
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.368 -0500", hash_original_method = "3207E33C673BD37AF8FDF81E31830AE6", hash_generated_method = "E0617445F495205DED357DCB7FB34B1D")
    
public IccSmsInterfaceManager getIccSmsInterfaceManager(){
        return mSimSmsIntManager;
    }

    /**
     * Retrieves the IccPhoneBookInterfaceManager of the GSMPhone
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.371 -0500", hash_original_method = "6E6477AE345E3D007CED20614912A5C4", hash_generated_method = "0241F763B37857992D012ADBFF624E35")
    
public IccPhoneBookInterfaceManager getIccPhoneBookInterfaceManager(){
        return mSimPhoneBookIntManager;
    }
    
    private static class NetworkSelectMessage {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.303 -0500", hash_original_field = "917CC93E170BCDBC06457BE4F50622BF", hash_generated_field = "81254C6170A9E52E0AD3BB76A481765A")

        public Message message;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.305 -0500", hash_original_field = "EDEB2AE49295E0D0131E5CCBDF250E4F", hash_generated_field = "8CA2393560EE8C751F612DF94EBF8B4B")

        public String operatorNumeric;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.307 -0500", hash_original_field = "D5205C75E0728BD5532E96497C7DFA52", hash_generated_field = "D8A2785302661C77D4C9BAD0912DCC8E")

        public String operatorAlphaLong;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.921 -0400", hash_original_method = "3039E12EC83A8AA31D55051619D54055", hash_generated_method = "3039E12EC83A8AA31D55051619D54055")
        public NetworkSelectMessage ()
        {
            //Synthesized constructor
        }

    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.373 -0500", hash_original_method = "515987807F65054AFA6AA9A268DDB599", hash_generated_method = "6444A67C7A7DD857ADA0E22CE9EE207B")
    
public IccFileHandler getIccFileHandler(){
        return this.mIccFileHandler;
    }

    /**
     * Activate or deactivate cell broadcast SMS.
     *
     * @param activate 0 = activate, 1 = deactivate
     * @param response Callback message is empty on completion
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.376 -0500", hash_original_method = "93A82B64CE4B13442120BE4FDBB45597", hash_generated_method = "EAA52092786556470D88FF60B9D59A47")
    
public void activateCellBroadcastSms(int activate, Message response) {
        Log.e(LOG_TAG, "[GSMPhone] activateCellBroadcastSms() is obsolete; use SmsManager");
        response.sendToTarget();
    }

    /**
     * Query the current configuration of cdma cell broadcast SMS.
     *
     * @param response Callback message is empty on completion
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.378 -0500", hash_original_method = "67DD91319C4A7AB6B9A5C1E784682816", hash_generated_method = "8C269F16AB0599B1332407DF46B19588")
    
public void getCellBroadcastSmsConfig(Message response) {
        Log.e(LOG_TAG, "[GSMPhone] getCellBroadcastSmsConfig() is obsolete; use SmsManager");
        response.sendToTarget();
    }

    /**
     * Configure cdma cell broadcast SMS.
     *
     * @param response Callback message is empty on completion
     */
    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.380 -0500", hash_original_method = "1D706FBF2447232FA856B129DB0956D5", hash_generated_method = "5228E4BCBBF43CF67E2C89106B2BE918")
    
public void setCellBroadcastSmsConfig(int[] configValuesArray, Message response) {
        Log.e(LOG_TAG, "[GSMPhone] setCellBroadcastSmsConfig() is obsolete; use SmsManager");
        response.sendToTarget();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:26.382 -0500", hash_original_method = "99B79EB3DF02CDEF6145664CC8FD0F29", hash_generated_method = "09D349C8B8F726354754EF5CEA6ACE2F")
    
public boolean isCspPlmnEnabled() {
        return mIccRecords.isCspPlmnEnabled();
    }
}

