package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    static final String LOG_TAG = "GSM";
    private static final boolean LOCAL_DEBUG = true;
    public static final String CIPHERING_KEY = "ciphering_key";
    public static final String VM_NUMBER = "vm_number_key";
    public static final String VM_SIM_IMSI = "vm_sim_imsi_key";
    GsmCallTracker mCT;
    GsmServiceStateTracker mSST;
    CatService mStkService;
    ArrayList <GsmMmiCode> mPendingMMIs = new ArrayList<GsmMmiCode>();
    SimPhoneBookInterfaceManager mSimPhoneBookIntManager;
    SimSmsInterfaceManager mSimSmsIntManager;
    PhoneSubInfo mSubInfo;
    Registrant mPostDialHandler;
    RegistrantList mSsnRegistrants = new RegistrantList();
    Thread debugPortThread;
    ServerSocket debugSocket;
    private String mImei;
    private String mImeiSv;
    private String mVmNumber;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.864 -0400", hash_original_method = "996B91F3E8316CE3D841721FC6425644", hash_generated_method = "90C8BCC32DDECA1DCC5A937F97BACEA3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public GSMPhone(Context context, CommandsInterface ci, PhoneNotifier notifier) {
        this(context,ci,notifier, false);
        dsTaint.addTaint(notifier.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(ci.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.864 -0400", hash_original_method = "E0F14E16A0D8C4916EDEAC018BF6C407", hash_generated_method = "B2BDFFB462F25B98057420A97A80C778")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public GSMPhone(Context context, CommandsInterface ci, PhoneNotifier notifier, boolean unitTestMode) {
        super(notifier, context, ci, unitTestMode);
        dsTaint.addTaint(unitTestMode);
        dsTaint.addTaint(notifier.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(ci.dsTaint);
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
            { }
        } //End block
        SystemProperties.set(TelephonyProperties.CURRENT_ACTIVE_PHONE,
                new Integer(Phone.PHONE_TYPE_GSM).toString());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.865 -0400", hash_original_method = "CEF48F17C6DF6ACB05893EA0A2EE33F8", hash_generated_method = "BC0CA2321F6E50F94EB4EAAD585F081F")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.865 -0400", hash_original_method = "F5F23F3B17FF3156952338384B3C94C7", hash_generated_method = "F0C366AF54A5D85AB0F8F6CB03E89322")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.865 -0400", hash_original_method = "B0A9A9B5818DC886F2534146C8893E7F", hash_generated_method = "1772CB1378942946B4ECC1CA990D89A4")
    @DSModeled(DSC.SAFE)
    protected void finalize() {
        Log.d(LOG_TAG, "GSMPhone finalized");
        // ---------- Original Method ----------
        //if(LOCAL_DEBUG) Log.d(LOG_TAG, "GSMPhone finalized");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.865 -0400", hash_original_method = "DA0F221C2247572C4D631280E4033E9A", hash_generated_method = "E5B6B1EB690F6D9B088917DBAE500728")
    @DSModeled(DSC.SAFE)
    public ServiceState getServiceState() {
        return (ServiceState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mSST.ss;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.865 -0400", hash_original_method = "E38329BE2FF507326358BBAF596945E6", hash_generated_method = "D4688C8F6494DE9BFCEE607AF443C552")
    @DSModeled(DSC.SAFE)
    public CellLocation getCellLocation() {
        return (CellLocation)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mSST.cellLoc;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.865 -0400", hash_original_method = "8AEFB373111A9C8AD30F3E8C75C461D2", hash_generated_method = "C213A0F99DA8FA5EE553344DA708C105")
    @DSModeled(DSC.SAFE)
    public Phone.State getState() {
        return (Phone.State)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCT.state;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.865 -0400", hash_original_method = "59C2B6A3B95086A76D74A4AD572CD9E8", hash_generated_method = "12B489476090EFF73E08992233CF7106")
    @DSModeled(DSC.SAFE)
    public String getPhoneName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "GSM";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.865 -0400", hash_original_method = "8F0362114FB07F54B581B179D597F815", hash_generated_method = "C9B60A7889171EE9ACBDE279DE04A638")
    @DSModeled(DSC.SAFE)
    public int getPhoneType() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return Phone.PHONE_TYPE_GSM;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.865 -0400", hash_original_method = "46D9BC6E3280014832CD8FC523C20E6E", hash_generated_method = "EA00D66BFBB261E1E499401384677B14")
    @DSModeled(DSC.SAFE)
    public SignalStrength getSignalStrength() {
        return (SignalStrength)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mSST.mSignalStrength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.865 -0400", hash_original_method = "79AFD9B845E4547B981131DAC9E3A14D", hash_generated_method = "B3B044A0E4933B0511AB40BCB30872E5")
    @DSModeled(DSC.SAFE)
    public CallTracker getCallTracker() {
        return (CallTracker)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.865 -0400", hash_original_method = "BD481539215D5A66E62B4E6909625141", hash_generated_method = "275A6A34F7E687340703DD9210B6F4DE")
    @DSModeled(DSC.SAFE)
    public ServiceStateTracker getServiceStateTracker() {
        return (ServiceStateTracker)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mSST;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.865 -0400", hash_original_method = "077104DE86BE536BE2C981492E640B74", hash_generated_method = "A2A101E3274F214D46C4B751C90CBA77")
    @DSModeled(DSC.SAFE)
    public List<? extends MmiCode> getPendingMmiCodes() {
        return (List<? extends MmiCode>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mPendingMMIs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.865 -0400", hash_original_method = "7454904C7C93C1818F679756511639F1", hash_generated_method = "75F8AF263B7F0BC8A2CFD71D3315B01D")
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
            boolean var01D4A7B95FF96B8BA58C75CB12149B2D_1494745588 = (mSST.getCurrentGprsState()
                != ServiceState.STATE_IN_SERVICE);
            {
                ret = DataState.DISCONNECTED;
            } //End block
            {
                boolean varEDC38D72B2381B58A0F3730E74C3817C_422656226 = (mDataConnectionTracker.isApnTypeEnabled(apnType) == false ||
                mDataConnectionTracker.isApnTypeActive(apnType) == false);
                {
                    ret = DataState.DISCONNECTED;
                } //End block
                {
                    {
                        Object var819139837D42C0AD62155AA1D23C5AD5_331463625 = (mDataConnectionTracker.getState(apnType));
                        //Begin case FAILED IDLE 
                        ret = DataState.DISCONNECTED;
                        //End case FAILED IDLE 
                        //Begin case CONNECTED DISCONNECTING 
                        {
                            boolean var398FF6E0DCA52B02F79A9CB272BA56EC_1697158917 = (mCT.state != Phone.State.IDLE
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
        return (DataState)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.866 -0400", hash_original_method = "1B8E5DE4B6A16D073AB6DF5ECB4F317E", hash_generated_method = "EDC006BC318D2EAFF47BA6A43CBE50A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DataActivityState getDataActivityState() {
        DataActivityState ret;
        ret = DataActivityState.NONE;
        {
            boolean var1BD7F40DFB9082C5149DCE8D977AF125_437328752 = (mSST.getCurrentGprsState() == ServiceState.STATE_IN_SERVICE);
            {
                {
                    Object var27C7E0FDBE09DE35AC2FD606F73591E2_924299870 = (mDataConnectionTracker.getActivity());
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
        return (DataActivityState)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.866 -0400", hash_original_method = "812A77A153EDB691C43A0B58CAFAA77A", hash_generated_method = "D88E16D17ED4309B5F77471CE77F05EC")
    @DSModeled(DSC.SAFE)
     void notifyPhoneStateChanged() {
        mNotifier.notifyPhoneState(this);
        // ---------- Original Method ----------
        //mNotifier.notifyPhoneState(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.866 -0400", hash_original_method = "3EB8461625C29B29FD6CB8E5D60B43F3", hash_generated_method = "DE6645BED63D7A84DCC69657109FEA5D")
    @DSModeled(DSC.SAFE)
     void notifyPreciseCallStateChanged() {
        super.notifyPreciseCallStateChangedP();
        // ---------- Original Method ----------
        //super.notifyPreciseCallStateChangedP();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.866 -0400", hash_original_method = "292444BE96E352C8E8312B338E19EF02", hash_generated_method = "1D252363C24CD454F85D9BE194A8E32A")
    @DSModeled(DSC.SAFE)
     void notifyNewRingingConnection(Connection c) {
        dsTaint.addTaint(c.dsTaint);
        super.notifyNewRingingConnectionP(c);
        // ---------- Original Method ----------
        //super.notifyNewRingingConnectionP(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.866 -0400", hash_original_method = "1858091673D3A4B62C058FCC91892C36", hash_generated_method = "7FC21AD219962FFC4D31C1D7A498D364")
    @DSModeled(DSC.SAFE)
     void notifyDisconnect(Connection cn) {
        dsTaint.addTaint(cn.dsTaint);
        mDisconnectRegistrants.notifyResult(cn);
        // ---------- Original Method ----------
        //mDisconnectRegistrants.notifyResult(cn);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.866 -0400", hash_original_method = "4DFA3B176AED92FABCFB596FBC88C127", hash_generated_method = "B69649D87585A24DDF770C28059017C4")
    @DSModeled(DSC.SAFE)
     void notifyUnknownConnection() {
        mUnknownConnectionRegistrants.notifyResult(this);
        // ---------- Original Method ----------
        //mUnknownConnectionRegistrants.notifyResult(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.866 -0400", hash_original_method = "952D093251486E722309085461233179", hash_generated_method = "C910474C0CCCC8841497029D11F1407C")
    @DSModeled(DSC.SAFE)
     void notifySuppServiceFailed(SuppService code) {
        dsTaint.addTaint(code.dsTaint);
        mSuppServiceFailedRegistrants.notifyResult(code);
        // ---------- Original Method ----------
        //mSuppServiceFailedRegistrants.notifyResult(code);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.866 -0400", hash_original_method = "73E7BFF04E4E9785E6146409272926BA", hash_generated_method = "E3DFCCC90DF88D6FEFDEB33D49CA936F")
    @DSModeled(DSC.SAFE)
     void notifyServiceStateChanged(ServiceState ss) {
        dsTaint.addTaint(ss.dsTaint);
        super.notifyServiceStateChangedP(ss);
        // ---------- Original Method ----------
        //super.notifyServiceStateChangedP(ss);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.866 -0400", hash_original_method = "482FE18FBD1949DAF708F2E65940DE8F", hash_generated_method = "021882CF98B4FB93B61C157BB7AF1FCF")
    @DSModeled(DSC.SAFE)
     void notifyLocationChanged() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mNotifier.notifyCellLocation(this);
        // ---------- Original Method ----------
        //mNotifier.notifyCellLocation(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.866 -0400", hash_original_method = "FCBAE539BB72BE21647FF37299DC2B96", hash_generated_method = "CEEF8D82465CDCDFD1F53A1B040E9431")
    @DSModeled(DSC.SAFE)
     void notifySignalStrength() {
        mNotifier.notifySignalStrength(this);
        // ---------- Original Method ----------
        //mNotifier.notifySignalStrength(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.866 -0400", hash_original_method = "25487D51A5547C84DC8EEF33482B43EF", hash_generated_method = "B67860FC5E01F8E973648065978AE075")
    @DSModeled(DSC.SAFE)
    public void notifyCallForwardingIndicator() {
        mNotifier.notifyCallForwardingChanged(this);
        // ---------- Original Method ----------
        //mNotifier.notifyCallForwardingChanged(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.866 -0400", hash_original_method = "C4157CB043EC8B3384F8270EB7DCD5BB", hash_generated_method = "E476AF6907BF3995FD9A8B5CD0688E7D")
    @DSModeled(DSC.SAFE)
    public final void setSystemProperty(String property, String value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(property);
        super.setSystemProperty(property, value);
        // ---------- Original Method ----------
        //super.setSystemProperty(property, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.866 -0400", hash_original_method = "02E1DF9EF058739EC655251AF002C09F", hash_generated_method = "5E654E19004456ECF6535F0C5A0F8754")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForSuppServiceNotification(
            Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mSsnRegistrants.addUnique(h, what, obj);
        {
            boolean varFAB3B0CB4521CD623976F107F015373C_1995884740 = (mSsnRegistrants.size() == 1);
            mCM.setSuppServiceNotifications(true, null);
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //mSsnRegistrants.addUnique(h, what, obj);
        //if (mSsnRegistrants.size() == 1) mCM.setSuppServiceNotifications(true, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.866 -0400", hash_original_method = "001FDCA2544BEBF92715B871E5466F8E", hash_generated_method = "F7C29C94D694A49150AF1B903D0681D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForSuppServiceNotification(Handler h) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(h.dsTaint);
        mSsnRegistrants.remove(h);
        {
            boolean varB3BC4AC108FB9749A749F1E20FAFF8A8_170294640 = (mSsnRegistrants.size() == 0);
            mCM.setSuppServiceNotifications(false, null);
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //mSsnRegistrants.remove(h);
        //if (mSsnRegistrants.size() == 0) mCM.setSuppServiceNotifications(false, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.866 -0400", hash_original_method = "C62CCD6CF2D9D7F7FA17BB7B58067AAC", hash_generated_method = "6B190360036E3A5244EB456775084C95")
    @DSModeled(DSC.SAFE)
    public void acceptCall() throws CallStateException {
        mCT.acceptCall();
        // ---------- Original Method ----------
        //mCT.acceptCall();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.866 -0400", hash_original_method = "A64616985F0D82C6750D71CF8DADC6F4", hash_generated_method = "D7FCF62E2A54A2E94882B5B7CDAE3B04")
    @DSModeled(DSC.SAFE)
    public void rejectCall() throws CallStateException {
        mCT.rejectCall();
        // ---------- Original Method ----------
        //mCT.rejectCall();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.867 -0400", hash_original_method = "4BD56579DA53A7A8E0646A63E1978FC8", hash_generated_method = "0DE95364DCB508E20E9E381CA156DCA7")
    @DSModeled(DSC.SAFE)
    public void switchHoldingAndActive() throws CallStateException {
        mCT.switchWaitingOrHoldingAndActive();
        // ---------- Original Method ----------
        //mCT.switchWaitingOrHoldingAndActive();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.867 -0400", hash_original_method = "01AA81103C1764FB5FE5BC7D2791F36E", hash_generated_method = "7CDBE55814B5A6E1F814091BC2EC072B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean canConference() {
        boolean var62676EA7A977651B04FEF7B6AA776FCC_904856244 = (mCT.canConference());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCT.canConference();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.867 -0400", hash_original_method = "27A0C6F6921751B2F5D5EAA31130917E", hash_generated_method = "A1DCB13F7BA8BFA40DC0B320F43F2E02")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean canDial() {
        boolean var17F304E4F3B49DB2D1D736D9DD207194_410519286 = (mCT.canDial());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCT.canDial();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.867 -0400", hash_original_method = "ED1426E2C308CED60BE3C0151AD877C7", hash_generated_method = "03CE4A311B938F2C8B0878CE3F063210")
    @DSModeled(DSC.SAFE)
    public void conference() throws CallStateException {
        mCT.conference();
        // ---------- Original Method ----------
        //mCT.conference();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.867 -0400", hash_original_method = "B9932A8A8BD16A4F0D461DDC6FDE6B49", hash_generated_method = "393DE7A74F05B4DF79434488A3AC122A")
    @DSModeled(DSC.SAFE)
    public void clearDisconnected() {
        mCT.clearDisconnected();
        // ---------- Original Method ----------
        //mCT.clearDisconnected();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.867 -0400", hash_original_method = "36A0747921C9C16BA6E56F404827E4EB", hash_generated_method = "114B9A738C47A059D241933AC09BF0DF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean canTransfer() {
        boolean var8E3EEF73488C19B8AFD5D0569E1452B3_347378800 = (mCT.canTransfer());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCT.canTransfer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.867 -0400", hash_original_method = "844E9AE7DC0EF8644470861505601222", hash_generated_method = "4FBAB781AF70186F83D37077F0D5863B")
    @DSModeled(DSC.SAFE)
    public void explicitCallTransfer() throws CallStateException {
        mCT.explicitCallTransfer();
        // ---------- Original Method ----------
        //mCT.explicitCallTransfer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.867 -0400", hash_original_method = "A46545098103F91B00276659EE365887", hash_generated_method = "8ABE1015DE4B4CD9CF43F402EF2A6F15")
    @DSModeled(DSC.SAFE)
    public GsmCall getForegroundCall() {
        return (GsmCall)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCT.foregroundCall;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.867 -0400", hash_original_method = "142F0A4524F2CBB8716568AB3A761D12", hash_generated_method = "7753380D7F737D16E695D1E8E94CF359")
    @DSModeled(DSC.SAFE)
    public GsmCall getBackgroundCall() {
        return (GsmCall)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCT.backgroundCall;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.867 -0400", hash_original_method = "F87806E8E26806695F0525D42F1D7DD4", hash_generated_method = "53202503AA4A7B180B99CB9B174B621F")
    @DSModeled(DSC.SAFE)
    public GsmCall getRingingCall() {
        return (GsmCall)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCT.ringingCall;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.867 -0400", hash_original_method = "3A1042FC51BD24241CBFB1D3DBD11D23", hash_generated_method = "B021F2EBA54C95AA9CD11A65748F2D90")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean handleCallDeflectionIncallSupplementaryService(
            String dialString) throws CallStateException {
        dsTaint.addTaint(dialString);
        {
            boolean var599183C7EFEA223E987C253B1794A663_631281228 = (dialString.length() > 1);
        } //End collapsed parenthetic
        {
            boolean varC3EC61EA57D8BAD50CBB2912B8C19CD0_684568676 = (getRingingCall().getState() != GsmCall.State.IDLE);
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
                boolean var3939D4E7861BC6B97F7F3D876A35B1D2_1148771324 = (getBackgroundCall().getState() != GsmCall.State.IDLE);
                {
                    Log.d(LOG_TAG,
                    "MmiCode 0: hangupWaitingOrBackground");
                    mCT.hangupWaitingOrBackground();
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.867 -0400", hash_original_method = "54841B6AA04B8F69693CDF35FACFE6EA", hash_generated_method = "1698183D8C4FCA8CDE3720CFF4B70666")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean handleCallWaitingIncallSupplementaryService(
            String dialString) throws CallStateException {
        dsTaint.addTaint(dialString);
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
                    boolean varAA260EC3CDDC603D103B4D5D62C46E51_801156318 = (call.getState() != GsmCall.State.IDLE);
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
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.868 -0400", hash_original_method = "F4FAEC22329B0BDDF008B69FB760B2A4", hash_generated_method = "8F552F12F1F01C0408EFF21B7EEBF125")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean handleCallHoldIncallSupplementaryService(String dialString) throws CallStateException {
        dsTaint.addTaint(dialString);
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
                    boolean var3B586179DB1A75B5DE869C498B98014C_622953131 = (getRingingCall().getState() != GsmCall.State.IDLE);
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
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.868 -0400", hash_original_method = "A61A93477751B5EFFB3B26065CE7F8F7", hash_generated_method = "F1A271612C4044152D70625C03CA73A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean handleMultipartyIncallSupplementaryService(
            String dialString) throws CallStateException {
        dsTaint.addTaint(dialString);
        {
            boolean var599183C7EFEA223E987C253B1794A663_305155391 = (dialString.length() > 1);
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.868 -0400", hash_original_method = "D22F8E83AE3C2E24760F930E8B1C0AF8", hash_generated_method = "574CCEAA8E205B5F7B84A28DDC1D7F13")
    @DSModeled(DSC.SAFE)
    private boolean handleEctIncallSupplementaryService(String dialString) throws CallStateException {
        dsTaint.addTaint(dialString);
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.868 -0400", hash_original_method = "F0B7315BB3E501E36AB72E6B89A34578", hash_generated_method = "2D063787D5C1CFE53E320EBE5BF02906")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean handleCcbsIncallSupplementaryService(String dialString) throws CallStateException {
        dsTaint.addTaint(dialString);
        {
            boolean var599183C7EFEA223E987C253B1794A663_1883090298 = (dialString.length() > 1);
        } //End collapsed parenthetic
        notifySuppServiceFailed(Phone.SuppService.UNKNOWN);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (dialString.length() > 1) {
            //return false;
        //}
        //Log.i(LOG_TAG, "MmiCode 5: CCBS not supported!");
        //notifySuppServiceFailed(Phone.SuppService.UNKNOWN);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.868 -0400", hash_original_method = "ADE3D3CB52AC1581EEE1CFCBED33E09A", hash_generated_method = "4D6B6BD5AAD8AF67DF6F60665C674C15")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean handleInCallMmiCommands(String dialString) throws CallStateException {
        dsTaint.addTaint(dialString);
        {
            boolean var2DA7186072441CB83C6A969D8B16A442_1686477168 = (!isInCall());
        } //End collapsed parenthetic
        {
            boolean varE12969D5E25DB7CCEEFA6845C2569D2D_901200074 = (TextUtils.isEmpty(dialString));
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
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.868 -0400", hash_original_method = "711944CD15C0B30B5C3E1DF07833B9CC", hash_generated_method = "B9E3228E2BC7CC907B43CF99A57B7AC8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean isInCall() {
        GsmCall.State foregroundCallState;
        foregroundCallState = getForegroundCall().getState();
        GsmCall.State backgroundCallState;
        backgroundCallState = getBackgroundCall().getState();
        GsmCall.State ringingCallState;
        ringingCallState = getRingingCall().getState();
        boolean var40D567FED010B1806D41F17B742032B9_1587032996 = ((foregroundCallState.isAlive() ||
                backgroundCallState.isAlive() ||
                ringingCallState.isAlive()));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //GsmCall.State foregroundCallState = getForegroundCall().getState();
        //GsmCall.State backgroundCallState = getBackgroundCall().getState();
        //GsmCall.State ringingCallState = getRingingCall().getState();
        //return (foregroundCallState.isAlive() ||
                //backgroundCallState.isAlive() ||
                //ringingCallState.isAlive());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.869 -0400", hash_original_method = "869C8D5C9810AA3DB7F9F221ECFAACBF", hash_generated_method = "FA1A305601040A7E0F411346AF607C8E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Connection dial(String dialString) throws CallStateException {
        dsTaint.addTaint(dialString);
        Connection var34C1005EC897F05961460403C9DF9563_974255752 = (dial(dialString, null));
        return (Connection)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return dial(dialString, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.869 -0400", hash_original_method = "905878DD9E4370A9706866C1B8D62D03", hash_generated_method = "B5C3A8AF2ACC0A2DAA28958FC0B2B617")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Connection dial(String dialString, UUSInfo uusInfo) throws CallStateException {
        dsTaint.addTaint(uusInfo.dsTaint);
        dsTaint.addTaint(dialString);
        String newDialString;
        newDialString = PhoneNumberUtils.stripSeparators(dialString);
        {
            boolean var22047FA7216835015EF1E811EC89577D_1668429724 = (handleInCallMmiCommands(newDialString));
        } //End collapsed parenthetic
        String networkPortion;
        networkPortion = PhoneNumberUtils.extractNetworkPortionAlt(newDialString);
        GsmMmiCode mmi;
        mmi = GsmMmiCode.newFromDialString(networkPortion, this);
        Log.d(LOG_TAG,
                               "dialing w/ mmi '" + mmi + "'...");
        {
            Connection varE7EE6EF4EDE78F08791B23369411EF24_773226981 = (mCT.dial(newDialString, uusInfo));
        } //End block
        {
            boolean varD000FF2B694DE8E860A4E505705D97D0_1863205913 = (mmi.isTemporaryModeCLIR());
            {
                Connection var1180887CC82FCCAA16E8DB97CDC8B2EA_976493943 = (mCT.dial(mmi.dialingNumber, mmi.getCLIRMode(), uusInfo));
            } //End block
            {
                mPendingMMIs.add(mmi);
                mMmiRegistrants.notifyRegistrants(new AsyncResult(null, mmi, null));
                mmi.processCode();
            } //End block
        } //End collapsed parenthetic
        return (Connection)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.869 -0400", hash_original_method = "4BA0C4BD36DFB68226B2317C39970473", hash_generated_method = "9699DF4ECC31C5336B071C76AC10D9D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean handlePinMmi(String dialString) {
        dsTaint.addTaint(dialString);
        GsmMmiCode mmi;
        mmi = GsmMmiCode.newFromDialString(dialString, this);
        {
            boolean var182AE2F3D97AC06A48466C4D43389C30_1033134097 = (mmi != null && mmi.isPinCommand());
            {
                mPendingMMIs.add(mmi);
                mMmiRegistrants.notifyRegistrants(new AsyncResult(null, mmi, null));
                mmi.processCode();
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.869 -0400", hash_original_method = "0D802E3B18B63F6835A66AA15E37A07D", hash_generated_method = "D7B6FA2358BC67D20E8743B4BDB30964")
    @DSModeled(DSC.SAFE)
    public void sendUssdResponse(String ussdMessge) {
        dsTaint.addTaint(ussdMessge);
        GsmMmiCode mmi;
        mmi = GsmMmiCode.newFromUssdUserInput(ussdMessge, this);
        mPendingMMIs.add(mmi);
        mMmiRegistrants.notifyRegistrants(new AsyncResult(null, mmi, null));
        mmi.sendUssd(ussdMessge);
        // ---------- Original Method ----------
        //GsmMmiCode mmi = GsmMmiCode.newFromUssdUserInput(ussdMessge, this);
        //mPendingMMIs.add(mmi);
        //mMmiRegistrants.notifyRegistrants(new AsyncResult(null, mmi, null));
        //mmi.sendUssd(ussdMessge);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.869 -0400", hash_original_method = "98607162C44D8873925496654D522BF8", hash_generated_method = "CF6E69F979FC8EDA99DDB9BB258B2C47")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendDtmf(char c) {
        dsTaint.addTaint(c);
        {
            boolean varD5E376D61876D980336EC59E5D202EEE_1824646644 = (!PhoneNumberUtils.is12Key(c));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.869 -0400", hash_original_method = "3FBA1333099AE68AF02019D712D23AB2", hash_generated_method = "CCAD3B4D02719BA076F24F646A58215F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void startDtmf(char c) {
        dsTaint.addTaint(c);
        {
            boolean varD5E376D61876D980336EC59E5D202EEE_557041079 = (!PhoneNumberUtils.is12Key(c));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.869 -0400", hash_original_method = "3DAC039DE959EF34631E2B825CE1F213", hash_generated_method = "99354F65987E33161D4C71C94D255852")
    @DSModeled(DSC.SAFE)
    public void stopDtmf() {
        mCM.stopDtmf(null);
        // ---------- Original Method ----------
        //mCM.stopDtmf(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.869 -0400", hash_original_method = "632DA8A1165B474AAA75C1A965AA7035", hash_generated_method = "423142D0A48F59F710017E3293521370")
    @DSModeled(DSC.SAFE)
    public void sendBurstDtmf(String dtmfString) {
        dsTaint.addTaint(dtmfString);
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[GSMPhone] sendBurstDtmf() is a CDMA method");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.869 -0400", hash_original_method = "6583EBFAAE11F5B271B0C202AB11C3E9", hash_generated_method = "5BEBA30A01D6E016F48B42CCFEFBCC2D")
    @DSModeled(DSC.SAFE)
    public void setRadioPower(boolean power) {
        dsTaint.addTaint(power);
        mSST.setRadioPower(power);
        // ---------- Original Method ----------
        //mSST.setRadioPower(power);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.869 -0400", hash_original_method = "E7F586CDCE74786257222FAC0983E7F9", hash_generated_method = "E7941B5067F900410EE1EF8967090542")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void storeVoiceMailNumber(String number) {
        dsTaint.addTaint(number);
        SharedPreferences sp;
        sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor editor;
        editor = sp.edit();
        editor.putString(VM_NUMBER, number);
        editor.apply();
        setVmSimImsi(getSubscriberId());
        // ---------- Original Method ----------
        //SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        //SharedPreferences.Editor editor = sp.edit();
        //editor.putString(VM_NUMBER, number);
        //editor.apply();
        //setVmSimImsi(getSubscriberId());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.870 -0400", hash_original_method = "69924A8239B9858372407D5C2A54772B", hash_generated_method = "49E9C25B203976F14B0279189EB6E53A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getVoiceMailNumber() {
        String number;
        number = mIccRecords.getVoiceMailNumber();
        {
            boolean varDC814D5E0DD02381050A532714A4AE08_15425985 = (TextUtils.isEmpty(number));
            {
                SharedPreferences sp;
                sp = PreferenceManager.getDefaultSharedPreferences(getContext());
                number = sp.getString(VM_NUMBER, null);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String number = mIccRecords.getVoiceMailNumber();
        //if (TextUtils.isEmpty(number)) {
            //SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
            //number = sp.getString(VM_NUMBER, null);
        //}
        //return number;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.870 -0400", hash_original_method = "767A05C9F746992519407618C38B7609", hash_generated_method = "381BF314FAB227F04CD8D13D720BEB05")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String getVmSimImsi() {
        SharedPreferences sp;
        sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        String varE426CC5947B82483C49233A789FBF788_1644812117 = (sp.getString(VM_SIM_IMSI, null));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        //return sp.getString(VM_SIM_IMSI, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.870 -0400", hash_original_method = "8C96CC1C916F049093DF13C1B1327265", hash_generated_method = "D6717310F3810C393D186CFD14523E85")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setVmSimImsi(String imsi) {
        dsTaint.addTaint(imsi);
        SharedPreferences sp;
        sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor editor;
        editor = sp.edit();
        editor.putString(VM_SIM_IMSI, imsi);
        editor.apply();
        // ---------- Original Method ----------
        //SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        //SharedPreferences.Editor editor = sp.edit();
        //editor.putString(VM_SIM_IMSI, imsi);
        //editor.apply();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.870 -0400", hash_original_method = "445A2067BED895487F73AC5A870ED091", hash_generated_method = "5F9CDD44ACF043A2FD5A06AC5EAE183B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getVoiceMailAlphaTag() {
        String ret;
        ret = mIccRecords.getVoiceMailAlphaTag();
        {
            boolean var0709D69E6C2648B4A0C93BD0750A7DE0_1656667625 = (ret == null || ret.length() == 0);
            {
                String varA530EF9D7F6A4C3687908C13A6C584D5_1456737728 = (mContext.getText(
                com.android.internal.R.string.defaultVoiceMailAlphaTag).toString());
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String ret;
        //ret = mIccRecords.getVoiceMailAlphaTag();
        //if (ret == null || ret.length() == 0) {
            //return mContext.getText(
                //com.android.internal.R.string.defaultVoiceMailAlphaTag).toString();
        //}
        //return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.870 -0400", hash_original_method = "40864F79C0287ACEFC2860E74923A158", hash_generated_method = "FCD6475442BDAEC1DC5C33B582DB7FBA")
    @DSModeled(DSC.SAFE)
    public String getDeviceId() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mImei;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.870 -0400", hash_original_method = "14B7BB34E0FC203F73344BD326AAB989", hash_generated_method = "2BA99D40BCAA5CC989C4B6AC92546DCC")
    @DSModeled(DSC.SAFE)
    public String getDeviceSvn() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mImeiSv;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.870 -0400", hash_original_method = "2BFB931234EFCBDA06B75AE314A70B6B", hash_generated_method = "B6CAF027166D04D94A25D273587716D5")
    @DSModeled(DSC.SAFE)
    public String getImei() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mImei;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.870 -0400", hash_original_method = "8337C263E1C0C858E7E7356286A6EE86", hash_generated_method = "82C1552087C3F9289566CB025A1765A6")
    @DSModeled(DSC.SAFE)
    public String getEsn() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[GSMPhone] getEsn() is a CDMA method");
        //return "0";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.870 -0400", hash_original_method = "92AF0460E6B1DF6A22F32869474C6DE7", hash_generated_method = "0E572575F8B7984DFD1028794CD5C740")
    @DSModeled(DSC.SAFE)
    public String getMeid() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[GSMPhone] getMeid() is a CDMA method");
        //return "0";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.870 -0400", hash_original_method = "418ED398A6A3FF53B03B4C5008FE3F90", hash_generated_method = "5205B474BAE79BB3DCB9B048A3AB7D9D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getSubscriberId() {
        String var7FD2EEB6F75B5B5070336667783F1237_1121009944 = (mIccRecords.getIMSI());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mIccRecords.getIMSI();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.870 -0400", hash_original_method = "084DD7ECDC7A6E289A4C2D9F1DE10A12", hash_generated_method = "CAB904DC9BBD96E55B7819B65157DECF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getLine1Number() {
        String var371895645902F934A5DFC882DDC1D4C9_1072181097 = (mIccRecords.getMsisdnNumber());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mIccRecords.getMsisdnNumber();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.870 -0400", hash_original_method = "0F1A42666FEB7039E59CE38A804A2571", hash_generated_method = "F409ED94566DEBEF6500D4C77470C810")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String getMsisdn() {
        String var371895645902F934A5DFC882DDC1D4C9_919928022 = (mIccRecords.getMsisdnNumber());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mIccRecords.getMsisdnNumber();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.870 -0400", hash_original_method = "D360BD2B0AE3500C93B786BA943E8C4F", hash_generated_method = "DF89E5E14305A9A3BD3A5D277EE8B966")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getLine1AlphaTag() {
        String varB05EBF7484E80902F440A44EB7346A0D_1720443395 = (mIccRecords.getMsisdnAlphaTag());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mIccRecords.getMsisdnAlphaTag();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.870 -0400", hash_original_method = "F8CED3952B50871548C8F8795A72A874", hash_generated_method = "C983E779823010416CDEBB79952DDD7D")
    @DSModeled(DSC.SAFE)
    public void setLine1Number(String alphaTag, String number, Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(number);
        dsTaint.addTaint(alphaTag);
        mIccRecords.setMsisdnNumber(alphaTag, number, onComplete);
        // ---------- Original Method ----------
        //mIccRecords.setMsisdnNumber(alphaTag, number, onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.870 -0400", hash_original_method = "63103D1CE9C7888BE66C8CE520564C7E", hash_generated_method = "D890C0682761B7021916DD7E606E6917")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.870 -0400", hash_original_method = "9DDD364B83D4A188246C8EC4129A09D5", hash_generated_method = "1B8C5D713CA7DE65185FDD401445C50C")
    @DSModeled(DSC.SAFE)
    private boolean isValidCommandInterfaceCFReason(int commandInterfaceCFReason) {
        dsTaint.addTaint(commandInterfaceCFReason);
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.871 -0400", hash_original_method = "138625FFD93D7E6FCFD9298408C66777", hash_generated_method = "781CD3E171EC85A2FED918FD9362FCE6")
    @DSModeled(DSC.SAFE)
    private boolean isValidCommandInterfaceCFAction(int commandInterfaceCFAction) {
        dsTaint.addTaint(commandInterfaceCFAction);
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.871 -0400", hash_original_method = "E62FA7EF147A8759C3C5908B3838581B", hash_generated_method = "8539A593FA482B3E7B35967361AB7BAF")
    @DSModeled(DSC.SAFE)
    protected boolean isCfEnable(int action) {
        dsTaint.addTaint(action);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (action == CF_ACTION_ENABLE) || (action == CF_ACTION_REGISTRATION);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.871 -0400", hash_original_method = "08670889C34D44E522747D6078786295", hash_generated_method = "CC9C2DB1C69DCBD3B1BFE39F65EE7F23")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getCallForwardingOption(int commandInterfaceCFReason, Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(commandInterfaceCFReason);
        {
            boolean varB6A05407BFCE3D15C223CC07E884F337_1314678340 = (isValidCommandInterfaceCFReason(commandInterfaceCFReason));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.871 -0400", hash_original_method = "C31B5CE81010007284F85A1CC1A97426", hash_generated_method = "38BD4741AFE80FFBD2C82EA6F559ACA8")
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
        {
            boolean var1CEEA491E3B272BF616FE6FFF10B0258_1856798172 = ((isValidCommandInterfaceCFAction(commandInterfaceCFAction)) &&
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.871 -0400", hash_original_method = "211ADA06D97F0C35F6F35D44159D1041", hash_generated_method = "613AEF781DA5022C52C53A0935E9AE79")
    @DSModeled(DSC.SAFE)
    public void getOutgoingCallerIdDisplay(Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        mCM.getCLIR(onComplete);
        // ---------- Original Method ----------
        //mCM.getCLIR(onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.871 -0400", hash_original_method = "9A33528D3F7EB56FD0CAE46DED766DA5", hash_generated_method = "13DCAE5675A592392A6D5FDACD1D716A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOutgoingCallerIdDisplay(int commandInterfaceCLIRMode,
                                           Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(commandInterfaceCLIRMode);
        mCM.setCLIR(commandInterfaceCLIRMode,
                obtainMessage(EVENT_SET_CLIR_COMPLETE, commandInterfaceCLIRMode, 0, onComplete));
        // ---------- Original Method ----------
        //mCM.setCLIR(commandInterfaceCLIRMode,
                //obtainMessage(EVENT_SET_CLIR_COMPLETE, commandInterfaceCLIRMode, 0, onComplete));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.871 -0400", hash_original_method = "5AA95CCFAB839BE19F56DECDE6C06EAE", hash_generated_method = "0271CC794417C00DF071944C4F98270D")
    @DSModeled(DSC.SAFE)
    public void getCallWaiting(Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        mCM.queryCallWaiting(CommandsInterface.SERVICE_CLASS_NONE, onComplete);
        // ---------- Original Method ----------
        //mCM.queryCallWaiting(CommandsInterface.SERVICE_CLASS_NONE, onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.871 -0400", hash_original_method = "378FD22E0CB0CF1CC5C649D301CEF0C1", hash_generated_method = "DDCC080A94F41E1C969FEB8102554726")
    @DSModeled(DSC.SAFE)
    public void setCallWaiting(boolean enable, Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(enable);
        mCM.setCallWaiting(enable, CommandsInterface.SERVICE_CLASS_VOICE, onComplete);
        // ---------- Original Method ----------
        //mCM.setCallWaiting(enable, CommandsInterface.SERVICE_CLASS_VOICE, onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.871 -0400", hash_original_method = "4DC55439AC7C450EEFD22BFFC07D3CE9", hash_generated_method = "C12A0ADE5EE0EA92839122171FEBA302")
    @DSModeled(DSC.SAFE)
    public void getAvailableNetworks(Message response) {
        dsTaint.addTaint(response.dsTaint);
        mCM.getAvailableNetworks(response);
        // ---------- Original Method ----------
        //mCM.getAvailableNetworks(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.871 -0400", hash_original_method = "21AFB30263A6CEDCB2E90901BACA2953", hash_generated_method = "28E3E9AD2F862DA17560B6B692D50D6A")
    @DSModeled(DSC.SAFE)
    public void setNetworkSelectionModeAutomatic(Message response) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(response.dsTaint);
        NetworkSelectMessage nsm;
        nsm = new NetworkSelectMessage();
        nsm.message = response;
        nsm.operatorNumeric = "";
        nsm.operatorAlphaLong = "";
        Message msg;
        msg = obtainMessage(EVENT_SET_NETWORK_AUTOMATIC_COMPLETE, nsm);
        Log.d(LOG_TAG, "wrapping and sending message to connect automatically");
        mCM.setNetworkSelectionModeAutomatic(msg);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.871 -0400", hash_original_method = "388CF66FD02B64F200B61D1E744A0B56", hash_generated_method = "23FE5DD52716F250327964A634146E20")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void selectNetworkManually(OperatorInfo network,
            Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(network.dsTaint);
        NetworkSelectMessage nsm;
        nsm = new NetworkSelectMessage();
        nsm.message = response;
        nsm.operatorNumeric = network.getOperatorNumeric();
        nsm.operatorAlphaLong = network.getOperatorAlphaLong();
        Message msg;
        msg = obtainMessage(EVENT_SET_NETWORK_MANUAL_COMPLETE, nsm);
        mCM.setNetworkSelectionModeManual(network.getOperatorNumeric(), msg);
        // ---------- Original Method ----------
        //NetworkSelectMessage nsm = new NetworkSelectMessage();
        //nsm.message = response;
        //nsm.operatorNumeric = network.getOperatorNumeric();
        //nsm.operatorAlphaLong = network.getOperatorAlphaLong();
        //Message msg = obtainMessage(EVENT_SET_NETWORK_MANUAL_COMPLETE, nsm);
        //mCM.setNetworkSelectionModeManual(network.getOperatorNumeric(), msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.871 -0400", hash_original_method = "3A54DC42D0DFD8C763BDF4414C51677B", hash_generated_method = "A4231DEC58FD6C973D8FF1C95F793C56")
    @DSModeled(DSC.SAFE)
    public void getNeighboringCids(Message response) {
        dsTaint.addTaint(response.dsTaint);
        mCM.getNeighboringCids(response);
        // ---------- Original Method ----------
        //mCM.getNeighboringCids(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.872 -0400", hash_original_method = "A54F4B18F21B3A39961648F4BDA2F061", hash_generated_method = "A825A34554D8D2C4EA026942A600A43D")
    @DSModeled(DSC.SAFE)
    public void setOnPostDialCharacter(Handler h, int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        mPostDialHandler = new Registrant(h, what, obj);
        // ---------- Original Method ----------
        //mPostDialHandler = new Registrant(h, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.872 -0400", hash_original_method = "E892EC268DCFDF5C9C27A7DDC7E00573", hash_generated_method = "32B6FA271BB0C59B1698D317D84B7276")
    @DSModeled(DSC.SAFE)
    public void setMute(boolean muted) {
        dsTaint.addTaint(muted);
        mCT.setMute(muted);
        // ---------- Original Method ----------
        //mCT.setMute(muted);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.872 -0400", hash_original_method = "FA6E824680C8944626A1A959DCEA6499", hash_generated_method = "B3B8740B3CAAB1544400591DE8294CC7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getMute() {
        boolean var20663A120A6F5E860F4EB58F2E5B9228_274164621 = (mCT.getMute());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCT.getMute();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.872 -0400", hash_original_method = "DAED77F9218E0449A772CA04214CC7F0", hash_generated_method = "8E28313666463CDB1C255669E63152E6")
    @DSModeled(DSC.SAFE)
    public void getDataCallList(Message response) {
        dsTaint.addTaint(response.dsTaint);
        mCM.getDataCallList(response);
        // ---------- Original Method ----------
        //mCM.getDataCallList(response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.872 -0400", hash_original_method = "96CADC2872DB4F7FDEDEDD322815973F", hash_generated_method = "A022147E6D33714727376A653DCDE620")
    @DSModeled(DSC.SAFE)
    public void updateServiceLocation() {
        mSST.enableSingleLocationUpdate();
        // ---------- Original Method ----------
        //mSST.enableSingleLocationUpdate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.872 -0400", hash_original_method = "85721F5820CF0128BD1EA66BA785E274", hash_generated_method = "D50464E812E0B06564DA16F6714FF0AD")
    @DSModeled(DSC.SAFE)
    public void enableLocationUpdates() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mSST.enableLocationUpdates();
        // ---------- Original Method ----------
        //mSST.enableLocationUpdates();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.872 -0400", hash_original_method = "E6FECC87DDBB4D4FE984E494757397E3", hash_generated_method = "65D7CA7E3870C2C4A9FCDCC8D7F89A35")
    @DSModeled(DSC.SAFE)
    public void disableLocationUpdates() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mSST.disableLocationUpdates();
        // ---------- Original Method ----------
        //mSST.disableLocationUpdates();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.872 -0400", hash_original_method = "33CDF43696035DC3E16A234222A80D64", hash_generated_method = "1DC9FEE7D4012B210179C7581857518C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getDataRoamingEnabled() {
        boolean var6ACB2ECE8621241EECE599BD6243F11B_1875898537 = (mDataConnectionTracker.getDataOnRoamingEnabled());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mDataConnectionTracker.getDataOnRoamingEnabled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.872 -0400", hash_original_method = "910AE5D7D70CC37EC2511A21C3761E3A", hash_generated_method = "8EAF68FE7CE73B4AB3E06DCEFBF1E67C")
    @DSModeled(DSC.SAFE)
    public void setDataRoamingEnabled(boolean enable) {
        dsTaint.addTaint(enable);
        mDataConnectionTracker.setDataOnRoamingEnabled(enable);
        // ---------- Original Method ----------
        //mDataConnectionTracker.setDataOnRoamingEnabled(enable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.872 -0400", hash_original_method = "AC949E64AEE76B7FF936E7A1B08DF381", hash_generated_method = "0D58E575AB66508CD483657EC8B8F65B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void onMMIDone(GsmMmiCode mmi) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(mmi.dsTaint);
        {
            boolean var1EA6EA5746ECD4584B3A274E648709FA_1332092428 = (mPendingMMIs.remove(mmi) || mmi.isUssdRequest());
            {
                mMmiCompleteRegistrants.notifyRegistrants(
                new AsyncResult(null, mmi, null));
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (mPendingMMIs.remove(mmi) || mmi.isUssdRequest()) {
            //mMmiCompleteRegistrants.notifyRegistrants(
                //new AsyncResult(null, mmi, null));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.872 -0400", hash_original_method = "7B2BAD4339ABD08CFCEAE93D5F289166", hash_generated_method = "55E7219B359EE50871523A346D815F74")
    @DSModeled(DSC.SAFE)
    private void onNetworkInitiatedUssd(GsmMmiCode mmi) {
        dsTaint.addTaint(mmi.dsTaint);
        mMmiCompleteRegistrants.notifyRegistrants(
            new AsyncResult(null, mmi, null));
        // ---------- Original Method ----------
        //mMmiCompleteRegistrants.notifyRegistrants(
            //new AsyncResult(null, mmi, null));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.872 -0400", hash_original_method = "FA8827AA61AE68EAA1082E2A36657BA2", hash_generated_method = "D7B6E317D2D608524F71380C1AE8C0EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void onIncomingUSSD(int ussdMode, String ussdMessage) {
        dsTaint.addTaint(ussdMode);
        dsTaint.addTaint(ussdMessage);
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
                    boolean varA016EF5F6E1ECC7C98CFC15BB240BDED_418583571 = (mPendingMMIs.get(i).isPendingUSSD());
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.872 -0400", hash_original_method = "B501A93D9CBCF588AB28D650AA03E986", hash_generated_method = "A6D2BBBF5127448C06646CDA91AABCF1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.873 -0400", hash_original_method = "EA4D9CE5B4912647996EC04703971BF3", hash_generated_method = "64E67388F1F36558A154FD5D97F75FE4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void handleMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
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
            boolean var3AAC275703146E8A94381DBD8E1509A5_1854668190 = (imsi != null && imsiFromSIM != null && !imsiFromSIM.equals(imsi));
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
                    boolean varA016EF5F6E1ECC7C98CFC15BB240BDED_724628938 = (mPendingMMIs.get(i).isPendingUSSD());
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
            boolean varAE18DF4A9D4BF791512D5DD4EB3D1497_116321632 = (IccVmNotSupportedException.class.isInstance(ar.exception));
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.873 -0400", hash_original_method = "0F23F53D1861BCD51C7CF85FD75916D2", hash_generated_method = "88D593E02C825AE076B9C14C3CE7B3D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.874 -0400", hash_original_method = "8C87E0C6EBD471788AC0CD93A9D4E893", hash_generated_method = "9F0EE8C10A7CF18D22C0BFEC308FF7E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void handleSetSelectNetwork(AsyncResult ar) {
        dsTaint.addTaint(ar.dsTaint);
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
            boolean var15A115D7A2E98F40805CADB6914BBE5F_692087400 = (! editor.commit());
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.874 -0400", hash_original_method = "C8B4A3CF4267A4CC2FA2952E385D70CE", hash_generated_method = "CEED4D614A96E7B74F721BB7B746E25B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void saveClirSetting(int commandInterfaceCLIRMode) {
        dsTaint.addTaint(commandInterfaceCLIRMode);
        SharedPreferences sp;
        sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor editor;
        editor = sp.edit();
        editor.putInt(CLIR_KEY, commandInterfaceCLIRMode);
        {
            boolean var15A115D7A2E98F40805CADB6914BBE5F_1715574904 = (! editor.commit());
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        //SharedPreferences.Editor editor = sp.edit();
        //editor.putInt(CLIR_KEY, commandInterfaceCLIRMode);
        //if (! editor.commit()) {
            //Log.e(LOG_TAG, "failed to commit CLIR preference");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.874 -0400", hash_original_method = "5FFF1291CED37081608080EEE820D6BC", hash_generated_method = "4C25FACD87248D517628BF9D120B690B")
    @DSModeled(DSC.SAFE)
    private void handleCfuQueryResult(CallForwardInfo[] infos) {
        dsTaint.addTaint(infos.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.874 -0400", hash_original_method = "4BF16EE42BDE3709043B0CD4BA1346D5", hash_generated_method = "AC2BAD2ADC97C1D4E88D3F3201764F16")
    @DSModeled(DSC.SAFE)
    public PhoneSubInfo getPhoneSubInfo() {
        return (PhoneSubInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mSubInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.874 -0400", hash_original_method = "3207E33C673BD37AF8FDF81E31830AE6", hash_generated_method = "637E7466A5023822223D20E674D4AE9E")
    @DSModeled(DSC.SAFE)
    public IccSmsInterfaceManager getIccSmsInterfaceManager() {
        return (IccSmsInterfaceManager)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mSimSmsIntManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.874 -0400", hash_original_method = "6E6477AE345E3D007CED20614912A5C4", hash_generated_method = "F33F52B914FA10D4124C02C90D675658")
    @DSModeled(DSC.SAFE)
    public IccPhoneBookInterfaceManager getIccPhoneBookInterfaceManager() {
        return (IccPhoneBookInterfaceManager)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mSimPhoneBookIntManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.874 -0400", hash_original_method = "515987807F65054AFA6AA9A268DDB599", hash_generated_method = "4C459E888C01535E2CB51C13749B6FD0")
    @DSModeled(DSC.SAFE)
    public IccFileHandler getIccFileHandler() {
        return (IccFileHandler)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.mIccFileHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.874 -0400", hash_original_method = "93A82B64CE4B13442120BE4FDBB45597", hash_generated_method = "86B4CFE69805FC0ECF113E148FB12567")
    @DSModeled(DSC.SAFE)
    public void activateCellBroadcastSms(int activate, Message response) {
        dsTaint.addTaint(activate);
        dsTaint.addTaint(response.dsTaint);
        response.sendToTarget();
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[GSMPhone] activateCellBroadcastSms() is obsolete; use SmsManager");
        //response.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.874 -0400", hash_original_method = "67DD91319C4A7AB6B9A5C1E784682816", hash_generated_method = "E9E06565223873E95CB2454E09B6FCB1")
    @DSModeled(DSC.SAFE)
    public void getCellBroadcastSmsConfig(Message response) {
        dsTaint.addTaint(response.dsTaint);
        response.sendToTarget();
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[GSMPhone] getCellBroadcastSmsConfig() is obsolete; use SmsManager");
        //response.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.874 -0400", hash_original_method = "1D706FBF2447232FA856B129DB0956D5", hash_generated_method = "13489450C6DBF64BFD4DC6400A76C1E6")
    @DSModeled(DSC.SAFE)
    public void setCellBroadcastSmsConfig(int[] configValuesArray, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(configValuesArray);
        response.sendToTarget();
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[GSMPhone] setCellBroadcastSmsConfig() is obsolete; use SmsManager");
        //response.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.874 -0400", hash_original_method = "99B79EB3DF02CDEF6145664CC8FD0F29", hash_generated_method = "C8FA6E748D5870BE008ACF93192F7D68")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isCspPlmnEnabled() {
        boolean varDB15A307B35D48340572A8BACE2EEC2D_149886822 = (mIccRecords.isCspPlmnEnabled());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIccRecords.isCspPlmnEnabled();
    }

    
    private static class NetworkSelectMessage {
        public Message message;
        public String operatorNumeric;
        public String operatorAlphaLong;
        
    }


    
}


