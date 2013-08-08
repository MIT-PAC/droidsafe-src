package com.android.internal.telephony.gsm;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.882 -0400", hash_original_field = "1D14D2D55BC367CD6AE3740CDB7152AF", hash_generated_field = "7E950EFC4355B7AA0B0D4941C05A3E53")

    GsmCallTracker mCT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.882 -0400", hash_original_field = "72BFF8190B34BEEE16406717B341412A", hash_generated_field = "AE636E648E782E05B0819C59ED7424AB")

    GsmServiceStateTracker mSST;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.882 -0400", hash_original_field = "F908D4D8A62B20E1013F1B849891738F", hash_generated_field = "CBD9585363E06B1CD5BA731CBD0F7A80")

    CatService mStkService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.882 -0400", hash_original_field = "00ADA57B43BDE5C478787B959A96A0CB", hash_generated_field = "16CBC86166E203C30D8494A6E3AFFFBC")

    ArrayList <GsmMmiCode> mPendingMMIs = new ArrayList<GsmMmiCode>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.882 -0400", hash_original_field = "212535A59AA4026EB1840135D5A6A54C", hash_generated_field = "BBEE3B2E599EE94DA4981B9B890C1513")

    SimPhoneBookInterfaceManager mSimPhoneBookIntManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.882 -0400", hash_original_field = "D5309C419B424DD63B187C852A2C29B9", hash_generated_field = "3969837BA2D4BBD6356E9579AAD42F25")

    SimSmsInterfaceManager mSimSmsIntManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.882 -0400", hash_original_field = "2C01F66E136181E8D582317306CCAC30", hash_generated_field = "F066FAD7B5AEEA27E2872ED159BF1CA4")

    PhoneSubInfo mSubInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.882 -0400", hash_original_field = "B70FAC06870FA211D668F462A2DBA212", hash_generated_field = "126D29D3ACD6141B3CF1C156D9BC8C27")

    Registrant mPostDialHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.882 -0400", hash_original_field = "F3323DA9DC0741EA4D28240971AFB640", hash_generated_field = "53A51CC9ADC1518A34F3208AF5D19A18")

    RegistrantList mSsnRegistrants = new RegistrantList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.882 -0400", hash_original_field = "DD2963357D2DA6A58CA505E758F62F10", hash_generated_field = "74116952885B195B8407FD19FB3B03C8")

    Thread debugPortThread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.882 -0400", hash_original_field = "0AF201A4B355A633BEDC98F2C2779D46", hash_generated_field = "B2950783CBB152418ABB498147763A3B")

    ServerSocket debugSocket;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.882 -0400", hash_original_field = "453C2995A2CC7C51188981A0F3965EED", hash_generated_field = "21C761E6867BA70678F0E7ADB70A1FBD")

    private String mImei;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.882 -0400", hash_original_field = "225448F5B7EE27E6F9CC21B80A6466DB", hash_generated_field = "B9E6756233427283AB4830B86393B4EE")

    private String mImeiSv;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.882 -0400", hash_original_field = "9B277DEC9B14E7B002627F05BEB0402A", hash_generated_field = "C290BF4C64FB14015B233D46098DB0A5")

    private String mVmNumber;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.883 -0400", hash_original_method = "996B91F3E8316CE3D841721FC6425644", hash_generated_method = "D577076EA01C6F53FBCB9505F0D83A57")
    public  GSMPhone(Context context, CommandsInterface ci, PhoneNotifier notifier) {
        this(context,ci,notifier, false);
        addTaint(notifier.getTaint());
        addTaint(ci.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
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
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.887 -0400", hash_original_method = "4E77C2C2171044E4A2A86AC9695E0AD3", hash_generated_method = "14575FDF60F9A6B5E330FF1BF6380000")
        public void run() {
for(;;)
            {
                try 
                {
                    Socket sock;
                    sock = debugSocket.accept();
                    mCM.resetRadio(null);
                    sock.close();
                } //End block
                catch (IOException ex)
                {
                } //End block
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
            {
            } //End block
        } //End block
        SystemProperties.set(TelephonyProperties.CURRENT_ACTIVE_PHONE,
                new Integer(Phone.PHONE_TYPE_GSM).toString());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.888 -0400", hash_original_method = "CEF48F17C6DF6ACB05893EA0A2EE33F8", hash_generated_method = "2841DDBC30C7832BD88515B793977C4E")
    @Override
    public void dispose() {
        synchronized
(PhoneProxy.lockForRadioTechnologyChange)        {
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.889 -0400", hash_original_method = "F5F23F3B17FF3156952338384B3C94C7", hash_generated_method = "C0585341C604244A83CFF366F7C62C3E")
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.890 -0400", hash_original_method = "B0A9A9B5818DC886F2534146C8893E7F", hash_generated_method = "F94CFB850F64B5C4778A55309CB4E7DC")
    protected void finalize() {
        if(LOCAL_DEBUG)        
        Log.d(LOG_TAG, "GSMPhone finalized");
        // ---------- Original Method ----------
        //if(LOCAL_DEBUG) Log.d(LOG_TAG, "GSMPhone finalized");
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.890 -0400", hash_original_method = "DA0F221C2247572C4D631280E4033E9A", hash_generated_method = "EB2EF5C400F339A1ADA7CF68546C390C")
    public ServiceState getServiceState() {
ServiceState varB63DD69AFCB2944A942E2A441DF92309_1443456708 =         mSST.ss;
        varB63DD69AFCB2944A942E2A441DF92309_1443456708.addTaint(taint);
        return varB63DD69AFCB2944A942E2A441DF92309_1443456708;
        // ---------- Original Method ----------
        //return mSST.ss;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.890 -0400", hash_original_method = "E38329BE2FF507326358BBAF596945E6", hash_generated_method = "84C544F8794A7F325C01234E6DC6863E")
    public CellLocation getCellLocation() {
CellLocation var99C49AD3DE160D9A941A8CB95CA2CC55_251531772 =         mSST.cellLoc;
        var99C49AD3DE160D9A941A8CB95CA2CC55_251531772.addTaint(taint);
        return var99C49AD3DE160D9A941A8CB95CA2CC55_251531772;
        // ---------- Original Method ----------
        //return mSST.cellLoc;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.890 -0400", hash_original_method = "8AEFB373111A9C8AD30F3E8C75C461D2", hash_generated_method = "92BCE6D82EFC0111CA1A89C0D53EE8DD")
    public Phone.State getState() {
Phone.State var76BC78A6228F2C8635D3A39BC739D237_1833688943 =         mCT.state;
        var76BC78A6228F2C8635D3A39BC739D237_1833688943.addTaint(taint);
        return var76BC78A6228F2C8635D3A39BC739D237_1833688943;
        // ---------- Original Method ----------
        //return mCT.state;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.890 -0400", hash_original_method = "59C2B6A3B95086A76D74A4AD572CD9E8", hash_generated_method = "F5437A90BA4DC2DBB3EB09607FBD48E3")
    public String getPhoneName() {
String var37447433510FF676EBF4CB596D554199_725927999 =         "GSM";
        var37447433510FF676EBF4CB596D554199_725927999.addTaint(taint);
        return var37447433510FF676EBF4CB596D554199_725927999;
        // ---------- Original Method ----------
        //return "GSM";
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.891 -0400", hash_original_method = "8F0362114FB07F54B581B179D597F815", hash_generated_method = "3ECBAF773524B827860660C6D45E9C81")
    public int getPhoneType() {
        int var95892063D986DD10DC2861C5CB9AD1AF_1593688592 = (Phone.PHONE_TYPE_GSM);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2077894532 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2077894532;
        // ---------- Original Method ----------
        //return Phone.PHONE_TYPE_GSM;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.891 -0400", hash_original_method = "46D9BC6E3280014832CD8FC523C20E6E", hash_generated_method = "1C5E2B3D0C6FB333E86DC309AD566ACC")
    public SignalStrength getSignalStrength() {
SignalStrength varD5A83A3C6D3D3BC3F870FC808BD3DAF7_502123212 =         mSST.mSignalStrength;
        varD5A83A3C6D3D3BC3F870FC808BD3DAF7_502123212.addTaint(taint);
        return varD5A83A3C6D3D3BC3F870FC808BD3DAF7_502123212;
        // ---------- Original Method ----------
        //return mSST.mSignalStrength;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.891 -0400", hash_original_method = "79AFD9B845E4547B981131DAC9E3A14D", hash_generated_method = "22B1A7C6F6B7A809C8ED9792783B57A1")
    public CallTracker getCallTracker() {
CallTracker var3528ED268C30F3C1C217C40E97751AC8_1458321554 =         mCT;
        var3528ED268C30F3C1C217C40E97751AC8_1458321554.addTaint(taint);
        return var3528ED268C30F3C1C217C40E97751AC8_1458321554;
        // ---------- Original Method ----------
        //return mCT;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.891 -0400", hash_original_method = "BD481539215D5A66E62B4E6909625141", hash_generated_method = "1073552CD270BF7B8AD1ABBB87EFD162")
    public ServiceStateTracker getServiceStateTracker() {
ServiceStateTracker var615613A1D046F80E6B9B13A16A2791AB_1913758978 =         mSST;
        var615613A1D046F80E6B9B13A16A2791AB_1913758978.addTaint(taint);
        return var615613A1D046F80E6B9B13A16A2791AB_1913758978;
        // ---------- Original Method ----------
        //return mSST;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.892 -0400", hash_original_method = "077104DE86BE536BE2C981492E640B74", hash_generated_method = "3773E6B215CCFF45088461B4E58467D5")
    public List<? extends MmiCode> getPendingMmiCodes() {
List<? extends MmiCode> varE8C0A474A7F3AF50883AA5B51924928B_1408565726 =         mPendingMMIs;
        varE8C0A474A7F3AF50883AA5B51924928B_1408565726.addTaint(taint);
        return varE8C0A474A7F3AF50883AA5B51924928B_1408565726;
        // ---------- Original Method ----------
        //return mPendingMMIs;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.893 -0400", hash_original_method = "7454904C7C93C1818F679756511639F1", hash_generated_method = "D3CB42275D0330CE33A5D04916951A80")
    public DataState getDataConnectionState(String apnType) {
        addTaint(apnType.getTaint());
        DataState ret = DataState.DISCONNECTED;
        if(mSST == null)        
        {
            ret = DataState.DISCONNECTED;
        } //End block
        else
        if(mSST.getCurrentGprsState()
                != ServiceState.STATE_IN_SERVICE)        
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
DataState varEDFF4FBBF053B5DC2B444ADFA049EE0F_717233517 =         ret;
        varEDFF4FBBF053B5DC2B444ADFA049EE0F_717233517.addTaint(taint);
        return varEDFF4FBBF053B5DC2B444ADFA049EE0F_717233517;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.893 -0400", hash_original_method = "1B8E5DE4B6A16D073AB6DF5ECB4F317E", hash_generated_method = "0891D59FD2D9ACAD49C1F65A572564D0")
    public DataActivityState getDataActivityState() {
        DataActivityState ret = DataActivityState.NONE;
        if(mSST.getCurrentGprsState() == ServiceState.STATE_IN_SERVICE)        
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
}
        } //End block
DataActivityState varEDFF4FBBF053B5DC2B444ADFA049EE0F_1168325596 =         ret;
        varEDFF4FBBF053B5DC2B444ADFA049EE0F_1168325596.addTaint(taint);
        return varEDFF4FBBF053B5DC2B444ADFA049EE0F_1168325596;
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.893 -0400", hash_original_method = "812A77A153EDB691C43A0B58CAFAA77A", hash_generated_method = "AB35579F49622E7A241F12B7DDB4EC19")
     void notifyPhoneStateChanged() {
        mNotifier.notifyPhoneState(this);
        // ---------- Original Method ----------
        //mNotifier.notifyPhoneState(this);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.894 -0400", hash_original_method = "3EB8461625C29B29FD6CB8E5D60B43F3", hash_generated_method = "D04CBC6D94303085010D6FD72DFDF138")
     void notifyPreciseCallStateChanged() {
        super.notifyPreciseCallStateChangedP();
        // ---------- Original Method ----------
        //super.notifyPreciseCallStateChangedP();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.894 -0400", hash_original_method = "292444BE96E352C8E8312B338E19EF02", hash_generated_method = "1834271AD9115788FB6995456D8952DC")
     void notifyNewRingingConnection(Connection c) {
        addTaint(c.getTaint());
        super.notifyNewRingingConnectionP(c);
        // ---------- Original Method ----------
        //super.notifyNewRingingConnectionP(c);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.894 -0400", hash_original_method = "1858091673D3A4B62C058FCC91892C36", hash_generated_method = "C0967CF5B0AC71AC9086A2946F168D51")
     void notifyDisconnect(Connection cn) {
        addTaint(cn.getTaint());
        mDisconnectRegistrants.notifyResult(cn);
        // ---------- Original Method ----------
        //mDisconnectRegistrants.notifyResult(cn);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.894 -0400", hash_original_method = "4DFA3B176AED92FABCFB596FBC88C127", hash_generated_method = "78FF0EBB369D5E48C88943009DE8A38C")
     void notifyUnknownConnection() {
        mUnknownConnectionRegistrants.notifyResult(this);
        // ---------- Original Method ----------
        //mUnknownConnectionRegistrants.notifyResult(this);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.894 -0400", hash_original_method = "952D093251486E722309085461233179", hash_generated_method = "D2A891901727494D8E369385B797C6BA")
     void notifySuppServiceFailed(SuppService code) {
        addTaint(code.getTaint());
        mSuppServiceFailedRegistrants.notifyResult(code);
        // ---------- Original Method ----------
        //mSuppServiceFailedRegistrants.notifyResult(code);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.894 -0400", hash_original_method = "73E7BFF04E4E9785E6146409272926BA", hash_generated_method = "3C10FF86EDD5B27D27F8FAD326A596AF")
     void notifyServiceStateChanged(ServiceState ss) {
        addTaint(ss.getTaint());
        super.notifyServiceStateChangedP(ss);
        // ---------- Original Method ----------
        //super.notifyServiceStateChangedP(ss);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.894 -0400", hash_original_method = "482FE18FBD1949DAF708F2E65940DE8F", hash_generated_method = "0723685B826BB9996EC0449E7B1A8FCF")
     void notifyLocationChanged() {
        mNotifier.notifyCellLocation(this);
        // ---------- Original Method ----------
        //mNotifier.notifyCellLocation(this);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.894 -0400", hash_original_method = "FCBAE539BB72BE21647FF37299DC2B96", hash_generated_method = "0C6B7A0FF6350CF17887F3D234BB96C8")
     void notifySignalStrength() {
        mNotifier.notifySignalStrength(this);
        // ---------- Original Method ----------
        //mNotifier.notifySignalStrength(this);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.895 -0400", hash_original_method = "25487D51A5547C84DC8EEF33482B43EF", hash_generated_method = "C35621F7AF385D2C45B899F83A20A075")
    public void notifyCallForwardingIndicator() {
        mNotifier.notifyCallForwardingChanged(this);
        // ---------- Original Method ----------
        //mNotifier.notifyCallForwardingChanged(this);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.895 -0400", hash_original_method = "C4157CB043EC8B3384F8270EB7DCD5BB", hash_generated_method = "54F20FED80F5A0DAA58DCF01A510D5E2")
    public final void setSystemProperty(String property, String value) {
        addTaint(value.getTaint());
        addTaint(property.getTaint());
        super.setSystemProperty(property, value);
        // ---------- Original Method ----------
        //super.setSystemProperty(property, value);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.895 -0400", hash_original_method = "02E1DF9EF058739EC655251AF002C09F", hash_generated_method = "7BFCFAD63607828336EBEDC5E163BE35")
    public void registerForSuppServiceNotification(
            Handler h, int what, Object obj) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(h.getTaint());
        mSsnRegistrants.addUnique(h, what, obj);
        if(mSsnRegistrants.size() == 1)        
        mCM.setSuppServiceNotifications(true, null);
        // ---------- Original Method ----------
        //mSsnRegistrants.addUnique(h, what, obj);
        //if (mSsnRegistrants.size() == 1) mCM.setSuppServiceNotifications(true, null);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.896 -0400", hash_original_method = "001FDCA2544BEBF92715B871E5466F8E", hash_generated_method = "CDA185A965A612FEBCCC60F3CF2E0670")
    public void unregisterForSuppServiceNotification(Handler h) {
        addTaint(h.getTaint());
        mSsnRegistrants.remove(h);
        if(mSsnRegistrants.size() == 0)        
        mCM.setSuppServiceNotifications(false, null);
        // ---------- Original Method ----------
        //mSsnRegistrants.remove(h);
        //if (mSsnRegistrants.size() == 0) mCM.setSuppServiceNotifications(false, null);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.896 -0400", hash_original_method = "C62CCD6CF2D9D7F7FA17BB7B58067AAC", hash_generated_method = "229941362132B3EA463C13061274E96C")
    public void acceptCall() throws CallStateException {
        mCT.acceptCall();
        // ---------- Original Method ----------
        //mCT.acceptCall();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.896 -0400", hash_original_method = "A64616985F0D82C6750D71CF8DADC6F4", hash_generated_method = "35B0F59F3248405A594AAB683856BD2F")
    public void rejectCall() throws CallStateException {
        mCT.rejectCall();
        // ---------- Original Method ----------
        //mCT.rejectCall();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.896 -0400", hash_original_method = "4BD56579DA53A7A8E0646A63E1978FC8", hash_generated_method = "4EFDBB8DAC4DC308937F3C30BD26241D")
    public void switchHoldingAndActive() throws CallStateException {
        mCT.switchWaitingOrHoldingAndActive();
        // ---------- Original Method ----------
        //mCT.switchWaitingOrHoldingAndActive();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.897 -0400", hash_original_method = "01AA81103C1764FB5FE5BC7D2791F36E", hash_generated_method = "34E67CA3BF9F91B2303C32ED450642BB")
    public boolean canConference() {
        boolean var1F3E46ACB3077DDD6B4564BAA6E39992_1610673797 = (mCT.canConference());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_841410526 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_841410526;
        // ---------- Original Method ----------
        //return mCT.canConference();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.897 -0400", hash_original_method = "27A0C6F6921751B2F5D5EAA31130917E", hash_generated_method = "82E7BB487A3C5B4014B64FF9ACAB00EF")
    public boolean canDial() {
        boolean varB878F6FC0654D8BBB898A336202292BE_1903844310 = (mCT.canDial());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_361376826 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_361376826;
        // ---------- Original Method ----------
        //return mCT.canDial();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.897 -0400", hash_original_method = "ED1426E2C308CED60BE3C0151AD877C7", hash_generated_method = "2CFDCF5C26A4C2BD5811B87BFB8C4AB4")
    public void conference() throws CallStateException {
        mCT.conference();
        // ---------- Original Method ----------
        //mCT.conference();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.897 -0400", hash_original_method = "B9932A8A8BD16A4F0D461DDC6FDE6B49", hash_generated_method = "BEFA10EB4DBC56DB633604D1159E6D30")
    public void clearDisconnected() {
        mCT.clearDisconnected();
        // ---------- Original Method ----------
        //mCT.clearDisconnected();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.897 -0400", hash_original_method = "36A0747921C9C16BA6E56F404827E4EB", hash_generated_method = "51A5AFEA99D0AF05EBDB8D0242873326")
    public boolean canTransfer() {
        boolean var92D3BA8CFC74510CF62AB9BDC1850EE0_1765377188 = (mCT.canTransfer());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_741692889 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_741692889;
        // ---------- Original Method ----------
        //return mCT.canTransfer();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.897 -0400", hash_original_method = "844E9AE7DC0EF8644470861505601222", hash_generated_method = "C4108AEC931486BDFF732FB315DE5DD6")
    public void explicitCallTransfer() throws CallStateException {
        mCT.explicitCallTransfer();
        // ---------- Original Method ----------
        //mCT.explicitCallTransfer();
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.898 -0400", hash_original_method = "A46545098103F91B00276659EE365887", hash_generated_method = "06678061391446EE1D3FEF47BEC6E3CF")
    public GsmCall getForegroundCall() {
GsmCall var27EE6C6A3390EC6B8D26B508C9FD500B_562615542 =         mCT.foregroundCall;
        var27EE6C6A3390EC6B8D26B508C9FD500B_562615542.addTaint(taint);
        return var27EE6C6A3390EC6B8D26B508C9FD500B_562615542;
        // ---------- Original Method ----------
        //return mCT.foregroundCall;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.898 -0400", hash_original_method = "142F0A4524F2CBB8716568AB3A761D12", hash_generated_method = "27BC31FDDD1AD4C72CA9BAB175E7EC54")
    public GsmCall getBackgroundCall() {
GsmCall var6A75FAAFEF760596343E2AE0F8499357_185442442 =         mCT.backgroundCall;
        var6A75FAAFEF760596343E2AE0F8499357_185442442.addTaint(taint);
        return var6A75FAAFEF760596343E2AE0F8499357_185442442;
        // ---------- Original Method ----------
        //return mCT.backgroundCall;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.898 -0400", hash_original_method = "F87806E8E26806695F0525D42F1D7DD4", hash_generated_method = "22A7BDE2BB73A6DF97BA1B9AB5D48840")
    public GsmCall getRingingCall() {
GsmCall var0C933E5C350902B3323CAF4D9F4DBF29_1706630166 =         mCT.ringingCall;
        var0C933E5C350902B3323CAF4D9F4DBF29_1706630166.addTaint(taint);
        return var0C933E5C350902B3323CAF4D9F4DBF29_1706630166;
        // ---------- Original Method ----------
        //return mCT.ringingCall;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.898 -0400", hash_original_method = "3A1042FC51BD24241CBFB1D3DBD11D23", hash_generated_method = "0613BAED8EC253B4900D201EC8D121D2")
    private boolean handleCallDeflectionIncallSupplementaryService(
            String dialString) throws CallStateException {
        addTaint(dialString.getTaint());
        if(dialString.length() > 1)        
        {
            boolean var68934A3E9455FA72420237EB05902327_666892363 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2140538590 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2140538590;
        } //End block
        if(getRingingCall().getState() != GsmCall.State.IDLE)        
        {
            if(LOCAL_DEBUG)            
            Log.d(LOG_TAG, "MmiCode 0: rejectCall");
            try 
            {
                mCT.rejectCall();
            } //End block
            catch (CallStateException e)
            {
                if(LOCAL_DEBUG)                
                Log.d(LOG_TAG,
                    "reject failed", e);
                notifySuppServiceFailed(Phone.SuppService.REJECT);
            } //End block
        } //End block
        else
        if(getBackgroundCall().getState() != GsmCall.State.IDLE)        
        {
            if(LOCAL_DEBUG)            
            Log.d(LOG_TAG,
                    "MmiCode 0: hangupWaitingOrBackground");
            mCT.hangupWaitingOrBackground();
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1931107281 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1308151359 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1308151359;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.899 -0400", hash_original_method = "54841B6AA04B8F69693CDF35FACFE6EA", hash_generated_method = "C78F8DE60CA69086560A72E085BF983D")
    private boolean handleCallWaitingIncallSupplementaryService(
            String dialString) throws CallStateException {
        addTaint(dialString.getTaint());
        int len = dialString.length();
        if(len > 2)        
        {
            boolean var68934A3E9455FA72420237EB05902327_97334314 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1688082540 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1688082540;
        } //End block
        GsmCall call = (GsmCall) getForegroundCall();
        try 
        {
            if(len > 1)            
            {
                char ch = dialString.charAt(1);
                int callIndex = ch - '0';
                if(callIndex >= 1 && callIndex <= GsmCallTracker.MAX_CONNECTIONS)                
                {
                    if(LOCAL_DEBUG)                    
                    Log.d(LOG_TAG,
                            "MmiCode 1: hangupConnectionByIndex " +
                            callIndex);
                    mCT.hangupConnectionByIndex(call, callIndex);
                } //End block
            } //End block
            else
            {
                if(call.getState() != GsmCall.State.IDLE)                
                {
                    if(LOCAL_DEBUG)                    
                    Log.d(LOG_TAG,
                            "MmiCode 1: hangup foreground");
                    mCT.hangup(call);
                } //End block
                else
                {
                    if(LOCAL_DEBUG)                    
                    Log.d(LOG_TAG,
                            "MmiCode 1: switchWaitingOrHoldingAndActive");
                    mCT.switchWaitingOrHoldingAndActive();
                } //End block
            } //End block
        } //End block
        catch (CallStateException e)
        {
            if(LOCAL_DEBUG)            
            Log.d(LOG_TAG,
                "hangup failed", e);
            notifySuppServiceFailed(Phone.SuppService.HANGUP);
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1694872663 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_538784899 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_538784899;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.900 -0400", hash_original_method = "F4FAEC22329B0BDDF008B69FB760B2A4", hash_generated_method = "BA3908A9FAD03BDFED71C7A05F8983A3")
    private boolean handleCallHoldIncallSupplementaryService(String dialString) throws CallStateException {
        addTaint(dialString.getTaint());
        int len = dialString.length();
        if(len > 2)        
        {
            boolean var68934A3E9455FA72420237EB05902327_511092472 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1468294951 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1468294951;
        } //End block
        GsmCall call = (GsmCall) getForegroundCall();
        if(len > 1)        
        {
            try 
            {
                char ch = dialString.charAt(1);
                int callIndex = ch - '0';
                GsmConnection conn = mCT.getConnectionByIndex(call, callIndex);
                if(conn != null && callIndex >= 1 && callIndex <= GsmCallTracker.MAX_CONNECTIONS)                
                {
                    if(LOCAL_DEBUG)                    
                    Log.d(LOG_TAG, "MmiCode 2: separate call "+
                            callIndex);
                    mCT.separate(conn);
                } //End block
                else
                {
                    if(LOCAL_DEBUG)                    
                    Log.d(LOG_TAG, "separate: invalid call index "+
                            callIndex);
                    notifySuppServiceFailed(Phone.SuppService.SEPARATE);
                } //End block
            } //End block
            catch (CallStateException e)
            {
                if(LOCAL_DEBUG)                
                Log.d(LOG_TAG,
                    "separate failed", e);
                notifySuppServiceFailed(Phone.SuppService.SEPARATE);
            } //End block
        } //End block
        else
        {
            try 
            {
                if(getRingingCall().getState() != GsmCall.State.IDLE)                
                {
                    if(LOCAL_DEBUG)                    
                    Log.d(LOG_TAG,
                    "MmiCode 2: accept ringing call");
                    mCT.acceptCall();
                } //End block
                else
                {
                    if(LOCAL_DEBUG)                    
                    Log.d(LOG_TAG,
                    "MmiCode 2: switchWaitingOrHoldingAndActive");
                    mCT.switchWaitingOrHoldingAndActive();
                } //End block
            } //End block
            catch (CallStateException e)
            {
                if(LOCAL_DEBUG)                
                Log.d(LOG_TAG,
                    "switch failed", e);
                notifySuppServiceFailed(Phone.SuppService.SWITCH);
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_152516261 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_611329064 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_611329064;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.900 -0400", hash_original_method = "A61A93477751B5EFFB3B26065CE7F8F7", hash_generated_method = "E368D53B59AC28F50B98C069FBA1BBE5")
    private boolean handleMultipartyIncallSupplementaryService(
            String dialString) throws CallStateException {
        addTaint(dialString.getTaint());
        if(dialString.length() > 1)        
        {
            boolean var68934A3E9455FA72420237EB05902327_815703829 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1022525693 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1022525693;
        } //End block
        if(LOCAL_DEBUG)        
        Log.d(LOG_TAG, "MmiCode 3: merge calls");
        try 
        {
            conference();
        } //End block
        catch (CallStateException e)
        {
            if(LOCAL_DEBUG)            
            Log.d(LOG_TAG,
                "conference failed", e);
            notifySuppServiceFailed(Phone.SuppService.CONFERENCE);
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_380955684 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2125738763 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2125738763;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.901 -0400", hash_original_method = "D22F8E83AE3C2E24760F930E8B1C0AF8", hash_generated_method = "EE6FFB89C278AD7F468645E37F6C0B20")
    private boolean handleEctIncallSupplementaryService(String dialString) throws CallStateException {
        addTaint(dialString.getTaint());
        int len = dialString.length();
        if(len != 1)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1439932908 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_558260870 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_558260870;
        } //End block
        if(LOCAL_DEBUG)        
        Log.d(LOG_TAG, "MmiCode 4: explicit call transfer");
        try 
        {
            explicitCallTransfer();
        } //End block
        catch (CallStateException e)
        {
            if(LOCAL_DEBUG)            
            Log.d(LOG_TAG,
                "transfer failed", e);
            notifySuppServiceFailed(Phone.SuppService.TRANSFER);
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1091472637 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_360726788 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_360726788;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.901 -0400", hash_original_method = "F0B7315BB3E501E36AB72E6B89A34578", hash_generated_method = "F65C94AD2398C0573FEED83697CE5FA2")
    private boolean handleCcbsIncallSupplementaryService(String dialString) throws CallStateException {
        addTaint(dialString.getTaint());
        if(dialString.length() > 1)        
        {
            boolean var68934A3E9455FA72420237EB05902327_555780719 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1140630738 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1140630738;
        } //End block
        notifySuppServiceFailed(Phone.SuppService.UNKNOWN);
        boolean varB326B5062B2F0E69046810717534CB09_14652682 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_681742955 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_681742955;
        // ---------- Original Method ----------
        //if (dialString.length() > 1) {
            //return false;
        //}
        //Log.i(LOG_TAG, "MmiCode 5: CCBS not supported!");
        //notifySuppServiceFailed(Phone.SuppService.UNKNOWN);
        //return true;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.902 -0400", hash_original_method = "ADE3D3CB52AC1581EEE1CFCBED33E09A", hash_generated_method = "DACEBB11D469F7C1F8FD65BF456A17D8")
    public boolean handleInCallMmiCommands(String dialString) throws CallStateException {
        addTaint(dialString.getTaint());
        if(!isInCall())        
        {
            boolean var68934A3E9455FA72420237EB05902327_1503975915 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2046388196 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2046388196;
        } //End block
        if(TextUtils.isEmpty(dialString))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1163620784 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1867357142 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1867357142;
        } //End block
        boolean result = false;
        char ch = dialString.charAt(0);
switch(ch){
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
}        boolean varB4A88417B3D0170D754C647C30B7216A_984809360 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_47442149 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_47442149;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.902 -0400", hash_original_method = "711944CD15C0B30B5C3E1DF07833B9CC", hash_generated_method = "2A13021F8940B7616E4F86C06F65C695")
     boolean isInCall() {
        GsmCall.State foregroundCallState = getForegroundCall().getState();
        GsmCall.State backgroundCallState = getBackgroundCall().getState();
        GsmCall.State ringingCallState = getRingingCall().getState();
        boolean var7B76D848408E35CD299581192DA5C7E0_1067914463 = ((foregroundCallState.isAlive() ||
                backgroundCallState.isAlive() ||
                ringingCallState.isAlive()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1498152705 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1498152705;
        // ---------- Original Method ----------
        //GsmCall.State foregroundCallState = getForegroundCall().getState();
        //GsmCall.State backgroundCallState = getBackgroundCall().getState();
        //GsmCall.State ringingCallState = getRingingCall().getState();
        //return (foregroundCallState.isAlive() ||
                //backgroundCallState.isAlive() ||
                //ringingCallState.isAlive());
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.902 -0400", hash_original_method = "869C8D5C9810AA3DB7F9F221ECFAACBF", hash_generated_method = "DA67F22DA2B0E8474080AF36C26C0ECB")
    public Connection dial(String dialString) throws CallStateException {
        addTaint(dialString.getTaint());
Connection var2225D5813EDB72A45A55B7E09B9C5B96_1703625066 =         dial(dialString, null);
        var2225D5813EDB72A45A55B7E09B9C5B96_1703625066.addTaint(taint);
        return var2225D5813EDB72A45A55B7E09B9C5B96_1703625066;
        // ---------- Original Method ----------
        //return dial(dialString, null);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.903 -0400", hash_original_method = "905878DD9E4370A9706866C1B8D62D03", hash_generated_method = "98123D52D83A0EF66BF8E88C53BFB9EB")
    public Connection dial(String dialString, UUSInfo uusInfo) throws CallStateException {
        addTaint(uusInfo.getTaint());
        addTaint(dialString.getTaint());
        String newDialString = PhoneNumberUtils.stripSeparators(dialString);
        if(handleInCallMmiCommands(newDialString))        
        {
Connection var540C13E9E156B687226421B24F2DF178_208666048 =             null;
            var540C13E9E156B687226421B24F2DF178_208666048.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_208666048;
        } //End block
        String networkPortion = PhoneNumberUtils.extractNetworkPortionAlt(newDialString);
        GsmMmiCode mmi = GsmMmiCode.newFromDialString(networkPortion, this);
        if(LOCAL_DEBUG)        
        Log.d(LOG_TAG,
                               "dialing w/ mmi '" + mmi + "'...");
        if(mmi == null)        
        {
Connection var3FFCA0CFFD4F59FD0BA922F58F918D65_1353870993 =             mCT.dial(newDialString, uusInfo);
            var3FFCA0CFFD4F59FD0BA922F58F918D65_1353870993.addTaint(taint);
            return var3FFCA0CFFD4F59FD0BA922F58F918D65_1353870993;
        } //End block
        else
        if(mmi.isTemporaryModeCLIR())        
        {
Connection var4DF4E4C4F10024227A68B9D4D10D9FA9_164757995 =             mCT.dial(mmi.dialingNumber, mmi.getCLIRMode(), uusInfo);
            var4DF4E4C4F10024227A68B9D4D10D9FA9_164757995.addTaint(taint);
            return var4DF4E4C4F10024227A68B9D4D10D9FA9_164757995;
        } //End block
        else
        {
            mPendingMMIs.add(mmi);
            mMmiRegistrants.notifyRegistrants(new AsyncResult(null, mmi, null));
            mmi.processCode();
Connection var540C13E9E156B687226421B24F2DF178_1932495821 =             null;
            var540C13E9E156B687226421B24F2DF178_1932495821.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1932495821;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.903 -0400", hash_original_method = "4BA0C4BD36DFB68226B2317C39970473", hash_generated_method = "A057202C2DB4B5263968B9A06AB2A94D")
    public boolean handlePinMmi(String dialString) {
        addTaint(dialString.getTaint());
        GsmMmiCode mmi = GsmMmiCode.newFromDialString(dialString, this);
        if(mmi != null && mmi.isPinCommand())        
        {
            mPendingMMIs.add(mmi);
            mMmiRegistrants.notifyRegistrants(new AsyncResult(null, mmi, null));
            mmi.processCode();
            boolean varB326B5062B2F0E69046810717534CB09_630302732 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1202030774 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1202030774;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_986375368 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1789232233 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1789232233;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.904 -0400", hash_original_method = "0D802E3B18B63F6835A66AA15E37A07D", hash_generated_method = "A0869A73BAA2B25AC6C40B5994100D74")
    public void sendUssdResponse(String ussdMessge) {
        addTaint(ussdMessge.getTaint());
        GsmMmiCode mmi = GsmMmiCode.newFromUssdUserInput(ussdMessge, this);
        mPendingMMIs.add(mmi);
        mMmiRegistrants.notifyRegistrants(new AsyncResult(null, mmi, null));
        mmi.sendUssd(ussdMessge);
        // ---------- Original Method ----------
        //GsmMmiCode mmi = GsmMmiCode.newFromUssdUserInput(ussdMessge, this);
        //mPendingMMIs.add(mmi);
        //mMmiRegistrants.notifyRegistrants(new AsyncResult(null, mmi, null));
        //mmi.sendUssd(ussdMessge);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.904 -0400", hash_original_method = "98607162C44D8873925496654D522BF8", hash_generated_method = "75DBB739F17E6C3625C4907B8B257293")
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.904 -0400", hash_original_method = "3FBA1333099AE68AF02019D712D23AB2", hash_generated_method = "9F64E57D36406D1E9C6B8E3C5C92AB3F")
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.905 -0400", hash_original_method = "3DAC039DE959EF34631E2B825CE1F213", hash_generated_method = "E3ACE99405ED7C4AFBEE2F93E02370EB")
    public void stopDtmf() {
        mCM.stopDtmf(null);
        // ---------- Original Method ----------
        //mCM.stopDtmf(null);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.905 -0400", hash_original_method = "632DA8A1165B474AAA75C1A965AA7035", hash_generated_method = "A6BBC7BAC7B5E358A183AE12DC1C1071")
    public void sendBurstDtmf(String dtmfString) {
        addTaint(dtmfString.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[GSMPhone] sendBurstDtmf() is a CDMA method");
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.905 -0400", hash_original_method = "6583EBFAAE11F5B271B0C202AB11C3E9", hash_generated_method = "40BF0BF01FE4299F00D19584AD116527")
    public void setRadioPower(boolean power) {
        addTaint(power);
        mSST.setRadioPower(power);
        // ---------- Original Method ----------
        //mSST.setRadioPower(power);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.906 -0400", hash_original_method = "E7F586CDCE74786257222FAC0983E7F9", hash_generated_method = "3691D838E7656CE1F4B0A3564F7BAB87")
    private void storeVoiceMailNumber(String number) {
        addTaint(number.getTaint());
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor editor = sp.edit();
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.906 -0400", hash_original_method = "69924A8239B9858372407D5C2A54772B", hash_generated_method = "ED7FC01427430242042EC42DC4E3C276")
    public String getVoiceMailNumber() {
        String number = mIccRecords.getVoiceMailNumber();
        if(TextUtils.isEmpty(number))        
        {
            SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
            number = sp.getString(VM_NUMBER, null);
        } //End block
String var63E80DF571E08DAA47BEFBF0BD0EEBAD_366846122 =         number;
        var63E80DF571E08DAA47BEFBF0BD0EEBAD_366846122.addTaint(taint);
        return var63E80DF571E08DAA47BEFBF0BD0EEBAD_366846122;
        // ---------- Original Method ----------
        //String number = mIccRecords.getVoiceMailNumber();
        //if (TextUtils.isEmpty(number)) {
            //SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
            //number = sp.getString(VM_NUMBER, null);
        //}
        //return number;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.906 -0400", hash_original_method = "767A05C9F746992519407618C38B7609", hash_generated_method = "82B80499E09E5F2F2F3DB97D92B8F8DA")
    private String getVmSimImsi() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
String varA829DC64171AF4772A5CAF9D2BD20AD1_1827762816 =         sp.getString(VM_SIM_IMSI, null);
        varA829DC64171AF4772A5CAF9D2BD20AD1_1827762816.addTaint(taint);
        return varA829DC64171AF4772A5CAF9D2BD20AD1_1827762816;
        // ---------- Original Method ----------
        //SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        //return sp.getString(VM_SIM_IMSI, null);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.906 -0400", hash_original_method = "8C96CC1C916F049093DF13C1B1327265", hash_generated_method = "7D775CFB7C7B7D6C117DD5B3865554BE")
    private void setVmSimImsi(String imsi) {
        addTaint(imsi.getTaint());
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(VM_SIM_IMSI, imsi);
        editor.apply();
        // ---------- Original Method ----------
        //SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        //SharedPreferences.Editor editor = sp.edit();
        //editor.putString(VM_SIM_IMSI, imsi);
        //editor.apply();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.907 -0400", hash_original_method = "445A2067BED895487F73AC5A870ED091", hash_generated_method = "61EB03BAACACAF40031DC3CB8E5DBC71")
    public String getVoiceMailAlphaTag() {
        String ret;
        ret = mIccRecords.getVoiceMailAlphaTag();
        if(ret == null || ret.length() == 0)        
        {
String var2475348DE58D950BB6D9ACEB638F1798_499568709 =             mContext.getText(
                com.android.internal.R.string.defaultVoiceMailAlphaTag).toString();
            var2475348DE58D950BB6D9ACEB638F1798_499568709.addTaint(taint);
            return var2475348DE58D950BB6D9ACEB638F1798_499568709;
        } //End block
String varEDFF4FBBF053B5DC2B444ADFA049EE0F_601030503 =         ret;
        varEDFF4FBBF053B5DC2B444ADFA049EE0F_601030503.addTaint(taint);
        return varEDFF4FBBF053B5DC2B444ADFA049EE0F_601030503;
        // ---------- Original Method ----------
        //String ret;
        //ret = mIccRecords.getVoiceMailAlphaTag();
        //if (ret == null || ret.length() == 0) {
            //return mContext.getText(
                //com.android.internal.R.string.defaultVoiceMailAlphaTag).toString();
        //}
        //return ret;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.907 -0400", hash_original_method = "40864F79C0287ACEFC2860E74923A158", hash_generated_method = "92629DA65EEFDA2FD31E2A7955B764B6")
    public String getDeviceId() {
String varDEC341D68DE51B3F93C3763FDA1DF1F5_254230006 =         mImei;
        varDEC341D68DE51B3F93C3763FDA1DF1F5_254230006.addTaint(taint);
        return varDEC341D68DE51B3F93C3763FDA1DF1F5_254230006;
        // ---------- Original Method ----------
        //return mImei;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.907 -0400", hash_original_method = "14B7BB34E0FC203F73344BD326AAB989", hash_generated_method = "4F8419586CAA0FBEE1DCC81D2E43E67F")
    public String getDeviceSvn() {
String var440DA0F542A7DF067CD1A564FADAEE1C_550519549 =         mImeiSv;
        var440DA0F542A7DF067CD1A564FADAEE1C_550519549.addTaint(taint);
        return var440DA0F542A7DF067CD1A564FADAEE1C_550519549;
        // ---------- Original Method ----------
        //return mImeiSv;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.908 -0400", hash_original_method = "2BFB931234EFCBDA06B75AE314A70B6B", hash_generated_method = "42F058ADD119C31CE1DDEB0EC5963A30")
    public String getImei() {
String varDEC341D68DE51B3F93C3763FDA1DF1F5_937957393 =         mImei;
        varDEC341D68DE51B3F93C3763FDA1DF1F5_937957393.addTaint(taint);
        return varDEC341D68DE51B3F93C3763FDA1DF1F5_937957393;
        // ---------- Original Method ----------
        //return mImei;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.908 -0400", hash_original_method = "8337C263E1C0C858E7E7356286A6EE86", hash_generated_method = "216BF6316D298AE0ABF285ABDBEE53D8")
    public String getEsn() {
String var50F9DEEC38DD489662C457BCE7AD28CE_563490248 =         "0";
        var50F9DEEC38DD489662C457BCE7AD28CE_563490248.addTaint(taint);
        return var50F9DEEC38DD489662C457BCE7AD28CE_563490248;
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[GSMPhone] getEsn() is a CDMA method");
        //return "0";
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.908 -0400", hash_original_method = "92AF0460E6B1DF6A22F32869474C6DE7", hash_generated_method = "17109D59ADD6D22128133FF66AEF6826")
    public String getMeid() {
String var50F9DEEC38DD489662C457BCE7AD28CE_407899703 =         "0";
        var50F9DEEC38DD489662C457BCE7AD28CE_407899703.addTaint(taint);
        return var50F9DEEC38DD489662C457BCE7AD28CE_407899703;
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[GSMPhone] getMeid() is a CDMA method");
        //return "0";
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.908 -0400", hash_original_method = "418ED398A6A3FF53B03B4C5008FE3F90", hash_generated_method = "F9C1380D12D0ACEE9D54DCF5B1763C6D")
    public String getSubscriberId() {
String var9E0F6CF9E749066E7163DA637BDC770E_73542173 =         mIccRecords.getIMSI();
        var9E0F6CF9E749066E7163DA637BDC770E_73542173.addTaint(taint);
        return var9E0F6CF9E749066E7163DA637BDC770E_73542173;
        // ---------- Original Method ----------
        //return mIccRecords.getIMSI();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.909 -0400", hash_original_method = "084DD7ECDC7A6E289A4C2D9F1DE10A12", hash_generated_method = "E211CB7D583A46B3DDDA6CCD2B810FBB")
    public String getLine1Number() {
String var5C9367DA2C8CEA98FE0C3A1CC04F5C4B_1001537161 =         mIccRecords.getMsisdnNumber();
        var5C9367DA2C8CEA98FE0C3A1CC04F5C4B_1001537161.addTaint(taint);
        return var5C9367DA2C8CEA98FE0C3A1CC04F5C4B_1001537161;
        // ---------- Original Method ----------
        //return mIccRecords.getMsisdnNumber();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.909 -0400", hash_original_method = "0F1A42666FEB7039E59CE38A804A2571", hash_generated_method = "195F019A8A1FDE6DF492BB63354CDFE3")
    @Override
    public String getMsisdn() {
String var5C9367DA2C8CEA98FE0C3A1CC04F5C4B_170351633 =         mIccRecords.getMsisdnNumber();
        var5C9367DA2C8CEA98FE0C3A1CC04F5C4B_170351633.addTaint(taint);
        return var5C9367DA2C8CEA98FE0C3A1CC04F5C4B_170351633;
        // ---------- Original Method ----------
        //return mIccRecords.getMsisdnNumber();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.909 -0400", hash_original_method = "D360BD2B0AE3500C93B786BA943E8C4F", hash_generated_method = "D24E5FD6DB2F0D54F6B4EDFF8FD8B7A2")
    public String getLine1AlphaTag() {
String varD20E9E80043A142276C43969A86316C3_1828671750 =         mIccRecords.getMsisdnAlphaTag();
        varD20E9E80043A142276C43969A86316C3_1828671750.addTaint(taint);
        return varD20E9E80043A142276C43969A86316C3_1828671750;
        // ---------- Original Method ----------
        //return mIccRecords.getMsisdnAlphaTag();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.909 -0400", hash_original_method = "F8CED3952B50871548C8F8795A72A874", hash_generated_method = "2E354A6056641DF4B7C7FFCE3F969C11")
    public void setLine1Number(String alphaTag, String number, Message onComplete) {
        addTaint(onComplete.getTaint());
        addTaint(number.getTaint());
        addTaint(alphaTag.getTaint());
        mIccRecords.setMsisdnNumber(alphaTag, number, onComplete);
        // ---------- Original Method ----------
        //mIccRecords.setMsisdnNumber(alphaTag, number, onComplete);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.909 -0400", hash_original_method = "63103D1CE9C7888BE66C8CE520564C7E", hash_generated_method = "B59D834340A7ADC7047E9CD2FC0AA1E2")
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.909 -0400", hash_original_method = "9DDD364B83D4A188246C8EC4129A09D5", hash_generated_method = "6AA8E7A9636504B35031CB4642FB234E")
    private boolean isValidCommandInterfaceCFReason(int commandInterfaceCFReason) {
        addTaint(commandInterfaceCFReason);
switch(commandInterfaceCFReason){
        case CF_REASON_UNCONDITIONAL:
        case CF_REASON_BUSY:
        case CF_REASON_NO_REPLY:
        case CF_REASON_NOT_REACHABLE:
        case CF_REASON_ALL:
        case CF_REASON_ALL_CONDITIONAL:
        boolean varB326B5062B2F0E69046810717534CB09_534989327 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_571404655 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_571404655;
        default:
        boolean var68934A3E9455FA72420237EB05902327_1690153179 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1058065066 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1058065066;
}
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.910 -0400", hash_original_method = "138625FFD93D7E6FCFD9298408C66777", hash_generated_method = "AC526A750335AEAF891DD4A819FDA397")
    private boolean isValidCommandInterfaceCFAction(int commandInterfaceCFAction) {
        addTaint(commandInterfaceCFAction);
switch(commandInterfaceCFAction){
        case CF_ACTION_DISABLE:
        case CF_ACTION_ENABLE:
        case CF_ACTION_REGISTRATION:
        case CF_ACTION_ERASURE:
        boolean varB326B5062B2F0E69046810717534CB09_871327228 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_476713172 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_476713172;
        default:
        boolean var68934A3E9455FA72420237EB05902327_395524465 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_217616611 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_217616611;
}
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.910 -0400", hash_original_method = "E62FA7EF147A8759C3C5908B3838581B", hash_generated_method = "B03123ED92202BADC55375887B0B5BAC")
    protected boolean isCfEnable(int action) {
        addTaint(action);
        boolean varEC6505F08C0AA104EC06705215FA7040_1139796447 = ((action == CF_ACTION_ENABLE) || (action == CF_ACTION_REGISTRATION));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_839554228 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_839554228;
        // ---------- Original Method ----------
        //return (action == CF_ACTION_ENABLE) || (action == CF_ACTION_REGISTRATION);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.910 -0400", hash_original_method = "08670889C34D44E522747D6078786295", hash_generated_method = "94A9AA0F0ACD4FD7BF2C5C333C37B5D4")
    public void getCallForwardingOption(int commandInterfaceCFReason, Message onComplete) {
        addTaint(onComplete.getTaint());
        addTaint(commandInterfaceCFReason);
        if(isValidCommandInterfaceCFReason(commandInterfaceCFReason))        
        {
            if(LOCAL_DEBUG)            
            Log.d(LOG_TAG, "requesting call forwarding query.");
            Message resp;
            if(commandInterfaceCFReason == CF_REASON_UNCONDITIONAL)            
            {
                resp = obtainMessage(EVENT_GET_CALL_FORWARD_DONE, onComplete);
            } //End block
            else
            {
                resp = onComplete;
            } //End block
            mCM.queryCallForwardStatus(commandInterfaceCFReason,0,null,resp);
        } //End block
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.910 -0400", hash_original_method = "C31B5CE81010007284F85A1CC1A97426", hash_generated_method = "CEEE0950A60A350E3B60A1AE97CF9DB0")
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
        if((isValidCommandInterfaceCFAction(commandInterfaceCFAction)) &&
                (isValidCommandInterfaceCFReason(commandInterfaceCFReason)))        
        {
            Message resp;
            if(commandInterfaceCFReason == CF_REASON_UNCONDITIONAL)            
            {
                resp = obtainMessage(EVENT_SET_CALL_FORWARD_DONE,
                        isCfEnable(commandInterfaceCFAction) ? 1 : 0, 0, onComplete);
            } //End block
            else
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.911 -0400", hash_original_method = "211ADA06D97F0C35F6F35D44159D1041", hash_generated_method = "C2F2D8EBA65DB4BBE2CC56C1348AB902")
    public void getOutgoingCallerIdDisplay(Message onComplete) {
        addTaint(onComplete.getTaint());
        mCM.getCLIR(onComplete);
        // ---------- Original Method ----------
        //mCM.getCLIR(onComplete);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.911 -0400", hash_original_method = "9A33528D3F7EB56FD0CAE46DED766DA5", hash_generated_method = "A4B7EBADF930E73AEE9F541776FCCB3E")
    public void setOutgoingCallerIdDisplay(int commandInterfaceCLIRMode,
                                           Message onComplete) {
        addTaint(onComplete.getTaint());
        addTaint(commandInterfaceCLIRMode);
        mCM.setCLIR(commandInterfaceCLIRMode,
                obtainMessage(EVENT_SET_CLIR_COMPLETE, commandInterfaceCLIRMode, 0, onComplete));
        // ---------- Original Method ----------
        //mCM.setCLIR(commandInterfaceCLIRMode,
                //obtainMessage(EVENT_SET_CLIR_COMPLETE, commandInterfaceCLIRMode, 0, onComplete));
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.911 -0400", hash_original_method = "5AA95CCFAB839BE19F56DECDE6C06EAE", hash_generated_method = "FD33A286D555CA7EE2BA940B53A015D6")
    public void getCallWaiting(Message onComplete) {
        addTaint(onComplete.getTaint());
        mCM.queryCallWaiting(CommandsInterface.SERVICE_CLASS_NONE, onComplete);
        // ---------- Original Method ----------
        //mCM.queryCallWaiting(CommandsInterface.SERVICE_CLASS_NONE, onComplete);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.911 -0400", hash_original_method = "378FD22E0CB0CF1CC5C649D301CEF0C1", hash_generated_method = "C94CD8C21E49EB43119067F339C440AF")
    public void setCallWaiting(boolean enable, Message onComplete) {
        addTaint(onComplete.getTaint());
        addTaint(enable);
        mCM.setCallWaiting(enable, CommandsInterface.SERVICE_CLASS_VOICE, onComplete);
        // ---------- Original Method ----------
        //mCM.setCallWaiting(enable, CommandsInterface.SERVICE_CLASS_VOICE, onComplete);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.911 -0400", hash_original_method = "4DC55439AC7C450EEFD22BFFC07D3CE9", hash_generated_method = "71000917EDFD72687C06CD5B00C6C943")
    public void getAvailableNetworks(Message response) {
        addTaint(response.getTaint());
        mCM.getAvailableNetworks(response);
        // ---------- Original Method ----------
        //mCM.getAvailableNetworks(response);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.911 -0400", hash_original_method = "21AFB30263A6CEDCB2E90901BACA2953", hash_generated_method = "9FDCA691B4D955627803DE3AC7FE3013")
    public void setNetworkSelectionModeAutomatic(Message response) {
        addTaint(response.getTaint());
        NetworkSelectMessage nsm = new NetworkSelectMessage();
        nsm.message = response;
        nsm.operatorNumeric = "";
        nsm.operatorAlphaLong = "";
        Message msg = obtainMessage(EVENT_SET_NETWORK_AUTOMATIC_COMPLETE, nsm);
        if(LOCAL_DEBUG)        
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.912 -0400", hash_original_method = "388CF66FD02B64F200B61D1E744A0B56", hash_generated_method = "399C10761A32389882C030432E932386")
    public void selectNetworkManually(OperatorInfo network,
            Message response) {
        addTaint(response.getTaint());
        addTaint(network.getTaint());
        NetworkSelectMessage nsm = new NetworkSelectMessage();
        nsm.message = response;
        nsm.operatorNumeric = network.getOperatorNumeric();
        nsm.operatorAlphaLong = network.getOperatorAlphaLong();
        Message msg = obtainMessage(EVENT_SET_NETWORK_MANUAL_COMPLETE, nsm);
        mCM.setNetworkSelectionModeManual(network.getOperatorNumeric(), msg);
        // ---------- Original Method ----------
        //NetworkSelectMessage nsm = new NetworkSelectMessage();
        //nsm.message = response;
        //nsm.operatorNumeric = network.getOperatorNumeric();
        //nsm.operatorAlphaLong = network.getOperatorAlphaLong();
        //Message msg = obtainMessage(EVENT_SET_NETWORK_MANUAL_COMPLETE, nsm);
        //mCM.setNetworkSelectionModeManual(network.getOperatorNumeric(), msg);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.912 -0400", hash_original_method = "3A54DC42D0DFD8C763BDF4414C51677B", hash_generated_method = "6BB9D3082993989B3AAC630D18D81D5D")
    public void getNeighboringCids(Message response) {
        addTaint(response.getTaint());
        mCM.getNeighboringCids(response);
        // ---------- Original Method ----------
        //mCM.getNeighboringCids(response);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.912 -0400", hash_original_method = "A54F4B18F21B3A39961648F4BDA2F061", hash_generated_method = "0D9A74204B6FB987A29697E2CA304A25")
    public void setOnPostDialCharacter(Handler h, int what, Object obj) {
        mPostDialHandler = new Registrant(h, what, obj);
        // ---------- Original Method ----------
        //mPostDialHandler = new Registrant(h, what, obj);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.912 -0400", hash_original_method = "E892EC268DCFDF5C9C27A7DDC7E00573", hash_generated_method = "6619A2B15F7D54045D03352B752C3F87")
    public void setMute(boolean muted) {
        addTaint(muted);
        mCT.setMute(muted);
        // ---------- Original Method ----------
        //mCT.setMute(muted);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.912 -0400", hash_original_method = "FA6E824680C8944626A1A959DCEA6499", hash_generated_method = "557DD85697074D3E0642B2FA0D4148B7")
    public boolean getMute() {
        boolean varA6D59716EFBEAD6BC174CD94D4F29A83_829307520 = (mCT.getMute());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1967120097 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1967120097;
        // ---------- Original Method ----------
        //return mCT.getMute();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.912 -0400", hash_original_method = "DAED77F9218E0449A772CA04214CC7F0", hash_generated_method = "A4539120C6EC9E203706F3837BE80718")
    public void getDataCallList(Message response) {
        addTaint(response.getTaint());
        mCM.getDataCallList(response);
        // ---------- Original Method ----------
        //mCM.getDataCallList(response);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.912 -0400", hash_original_method = "96CADC2872DB4F7FDEDEDD322815973F", hash_generated_method = "822C445C5B4D9120BF9FC0E8634D50FF")
    public void updateServiceLocation() {
        mSST.enableSingleLocationUpdate();
        // ---------- Original Method ----------
        //mSST.enableSingleLocationUpdate();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.912 -0400", hash_original_method = "85721F5820CF0128BD1EA66BA785E274", hash_generated_method = "8061BA0AAC1F798918E946EB98E60D31")
    public void enableLocationUpdates() {
        mSST.enableLocationUpdates();
        // ---------- Original Method ----------
        //mSST.enableLocationUpdates();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.913 -0400", hash_original_method = "E6FECC87DDBB4D4FE984E494757397E3", hash_generated_method = "3FDC902944764AB6B7139C73765CF957")
    public void disableLocationUpdates() {
        mSST.disableLocationUpdates();
        // ---------- Original Method ----------
        //mSST.disableLocationUpdates();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.913 -0400", hash_original_method = "33CDF43696035DC3E16A234222A80D64", hash_generated_method = "4186F3E1C6740C8DB6E6DA4EE2CFAD3C")
    public boolean getDataRoamingEnabled() {
        boolean var05EB48F135E17AD66E5DF608D5E538E9_1320058926 = (mDataConnectionTracker.getDataOnRoamingEnabled());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_282481264 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_282481264;
        // ---------- Original Method ----------
        //return mDataConnectionTracker.getDataOnRoamingEnabled();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.913 -0400", hash_original_method = "910AE5D7D70CC37EC2511A21C3761E3A", hash_generated_method = "51E0805AD01FE356CC54EA9F756ED9A4")
    public void setDataRoamingEnabled(boolean enable) {
        addTaint(enable);
        mDataConnectionTracker.setDataOnRoamingEnabled(enable);
        // ---------- Original Method ----------
        //mDataConnectionTracker.setDataOnRoamingEnabled(enable);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.913 -0400", hash_original_method = "AC949E64AEE76B7FF936E7A1B08DF381", hash_generated_method = "AC95DBA47FD131BDE3D33B5EB982C5AC")
     void onMMIDone(GsmMmiCode mmi) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(mmi.getTaint());
        if(mPendingMMIs.remove(mmi) || mmi.isUssdRequest())        
        {
            mMmiCompleteRegistrants.notifyRegistrants(
                new AsyncResult(null, mmi, null));
        } //End block
        // ---------- Original Method ----------
        //if (mPendingMMIs.remove(mmi) || mmi.isUssdRequest()) {
            //mMmiCompleteRegistrants.notifyRegistrants(
                //new AsyncResult(null, mmi, null));
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.913 -0400", hash_original_method = "7B2BAD4339ABD08CFCEAE93D5F289166", hash_generated_method = "0B12AC9AAF3792CC858AF41BECC3DB79")
    private void onNetworkInitiatedUssd(GsmMmiCode mmi) {
        addTaint(mmi.getTaint());
        mMmiCompleteRegistrants.notifyRegistrants(
            new AsyncResult(null, mmi, null));
        // ---------- Original Method ----------
        //mMmiCompleteRegistrants.notifyRegistrants(
            //new AsyncResult(null, mmi, null));
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.913 -0400", hash_original_method = "FA8827AA61AE68EAA1082E2A36657BA2", hash_generated_method = "A45552CCA6653B41DF3289B2A5EF6F96")
    private void onIncomingUSSD(int ussdMode, String ussdMessage) {
        addTaint(ussdMessage.getTaint());
        addTaint(ussdMode);
        boolean isUssdError;
        boolean isUssdRequest;
        isUssdRequest
            = (ussdMode == CommandsInterface.USSD_MODE_REQUEST);
        isUssdError
            = (ussdMode != CommandsInterface.USSD_MODE_NOTIFY
                && ussdMode != CommandsInterface.USSD_MODE_REQUEST);
        GsmMmiCode found = null;
for(int i = 0, s = mPendingMMIs.size();i < s;i++)
        {
            if(mPendingMMIs.get(i).isPendingUSSD())            
            {
                found = mPendingMMIs.get(i);
                break;
            } //End block
        } //End block
        if(found != null)        
        {
            if(isUssdError)            
            {
                found.onUssdFinishedError();
            } //End block
            else
            {
                found.onUssdFinished(ussdMessage, isUssdRequest);
            } //End block
        } //End block
        else
        {
            if(!isUssdError && ussdMessage != null)            
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.914 -0400", hash_original_method = "B501A93D9CBCF588AB28D650AA03E986", hash_generated_method = "CB03FBECA9D7DDEC621A8E5FD40C5F69")
    protected void syncClirSetting() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        int clirSetting = sp.getInt(CLIR_KEY, -1);
        if(clirSetting >= 0)        
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.915 -0400", hash_original_method = "EA4D9CE5B4912647996EC04703971BF3", hash_generated_method = "927ACBA10386F22F7AD845FF4240981C")
    @Override
    public void handleMessage(Message msg) {
        addTaint(msg.getTaint());
        AsyncResult ar;
        Message onComplete;
switch(msg.what){
        case EVENT_RADIO_AVAILABLE:
        {
            mCM.getBasebandVersion(
                        obtainMessage(EVENT_GET_BASEBAND_VERSION_DONE));
            mCM.getIMEI(obtainMessage(EVENT_GET_IMEI_DONE));
            mCM.getIMEISV(obtainMessage(EVENT_GET_IMEISV_DONE));
        } //End block
        break;
        case EVENT_RADIO_ON:
        break;
        case EVENT_REGISTERED_TO_NETWORK:
        syncClirSetting();
        break;
        case EVENT_SIM_RECORDS_LOADED:
        updateCurrentCarrierInProvider();
        String imsi = getVmSimImsi();
        String imsiFromSIM = getSubscriberId();
        if(imsi != null && imsiFromSIM != null && !imsiFromSIM.equals(imsi))        
        {
            storeVoiceMailNumber(null);
            setVmSimImsi(null);
        } //End block
        break;
        case EVENT_GET_BASEBAND_VERSION_DONE:
        ar = (AsyncResult)msg.obj;
        if(ar.exception != null)        
        {
            break;
        } //End block
        if(LOCAL_DEBUG)        
        Log.d(LOG_TAG, "Baseband version: " + ar.result);
        setSystemProperty(PROPERTY_BASEBAND_VERSION, (String)ar.result);
        break;
        case EVENT_GET_IMEI_DONE:
        ar = (AsyncResult)msg.obj;
        if(ar.exception != null)        
        {
            break;
        } //End block
        mImei = (String)ar.result;
        break;
        case EVENT_GET_IMEISV_DONE:
        ar = (AsyncResult)msg.obj;
        if(ar.exception != null)        
        {
            break;
        } //End block
        mImeiSv = (String)ar.result;
        break;
        case EVENT_USSD:
        ar = (AsyncResult)msg.obj;
        String[] ussdResult = (String[]) ar.result;
        if(ussdResult.length > 1)        
        {
            try 
            {
                onIncomingUSSD(Integer.parseInt(ussdResult[0]), ussdResult[1]);
            } //End block
            catch (NumberFormatException e)
            {
            } //End block
        } //End block
        break;
        case EVENT_RADIO_OFF_OR_NOT_AVAILABLE:
for(int i = 0, s = mPendingMMIs.size();i < s;i++)
        {
            if(mPendingMMIs.get(i).isPendingUSSD())            
            {
                mPendingMMIs.get(i).onUssdFinishedError();
            } //End block
        } //End block
        break;
        case EVENT_SSN:
        ar = (AsyncResult)msg.obj;
        SuppServiceNotification not = (SuppServiceNotification) ar.result;
        mSsnRegistrants.notifyRegistrants(ar);
        break;
        case EVENT_SET_CALL_FORWARD_DONE:
        ar = (AsyncResult)msg.obj;
        if(ar.exception == null)        
        {
            mIccRecords.setVoiceCallForwardingFlag(1, msg.arg1 == 1);
        } //End block
        onComplete = (Message) ar.userObj;
        if(onComplete != null)        
        {
            AsyncResult.forMessage(onComplete, ar.result, ar.exception);
            onComplete.sendToTarget();
        } //End block
        break;
        case EVENT_SET_VM_NUMBER_DONE:
        ar = (AsyncResult)msg.obj;
        if(IccVmNotSupportedException.class.isInstance(ar.exception))        
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
        break;
        case EVENT_GET_CALL_FORWARD_DONE:
        ar = (AsyncResult)msg.obj;
        if(ar.exception == null)        
        {
            handleCfuQueryResult((CallForwardInfo[])ar.result);
        } //End block
        onComplete = (Message) ar.userObj;
        if(onComplete != null)        
        {
            AsyncResult.forMessage(onComplete, ar.result, ar.exception);
            onComplete.sendToTarget();
        } //End block
        break;
        case EVENT_SET_NETWORK_MANUAL_COMPLETE:
        case EVENT_SET_NETWORK_AUTOMATIC_COMPLETE:
        handleSetSelectNetwork((AsyncResult) msg.obj);
        break;
        case EVENT_SET_CLIR_COMPLETE:
        ar = (AsyncResult)msg.obj;
        if(ar.exception == null)        
        {
            saveClirSetting(msg.arg1);
        } //End block
        onComplete = (Message) ar.userObj;
        if(onComplete != null)        
        {
            AsyncResult.forMessage(onComplete, ar.result, ar.exception);
            onComplete.sendToTarget();
        } //End block
        break;
        default:
        super.handleMessage(msg);
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.915 -0400", hash_original_method = "0F23F53D1861BCD51C7CF85FD75916D2", hash_generated_method = "1EBED1D7EB58CBA4ADC483298C83D0D5")
     boolean updateCurrentCarrierInProvider() {
        if(mIccRecords != null)        
        {
            try 
            {
                Uri uri = Uri.withAppendedPath(Telephony.Carriers.CONTENT_URI, "current");
                ContentValues map = new ContentValues();
                map.put(Telephony.Carriers.NUMERIC, mIccRecords.getOperatorNumeric());
                mContext.getContentResolver().insert(uri, map);
                boolean varB326B5062B2F0E69046810717534CB09_541142627 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1385168214 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1385168214;
            } //End block
            catch (SQLException e)
            {
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1595668281 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_341535263 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_341535263;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.915 -0400", hash_original_method = "8C87E0C6EBD471788AC0CD93A9D4E893", hash_generated_method = "9F89E4A5B015EA6FF4DE1BCCFB9D8E0F")
    private void handleSetSelectNetwork(AsyncResult ar) {
        addTaint(ar.getTaint());
        if(!(ar.userObj instanceof NetworkSelectMessage))        
        {
            if(LOCAL_DEBUG)            
            Log.d(LOG_TAG, "unexpected result from user object.");
            return;
        } //End block
        NetworkSelectMessage nsm = (NetworkSelectMessage) ar.userObj;
        if(nsm.message != null)        
        {
            if(LOCAL_DEBUG)            
            Log.d(LOG_TAG, "sending original message to recipient");
            AsyncResult.forMessage(nsm.message, ar.result, ar.exception);
            nsm.message.sendToTarget();
        } //End block
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(NETWORK_SELECTION_KEY, nsm.operatorNumeric);
        editor.putString(NETWORK_SELECTION_NAME_KEY, nsm.operatorAlphaLong);
        if(! editor.commit())        
        {
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.918 -0400", hash_original_method = "C8B4A3CF4267A4CC2FA2952E385D70CE", hash_generated_method = "7ED42078732A80C28FFB4734A469164A")
    public void saveClirSetting(int commandInterfaceCLIRMode) {
        addTaint(commandInterfaceCLIRMode);
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(CLIR_KEY, commandInterfaceCLIRMode);
        if(! editor.commit())        
        {
        } //End block
        // ---------- Original Method ----------
        //SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        //SharedPreferences.Editor editor = sp.edit();
        //editor.putInt(CLIR_KEY, commandInterfaceCLIRMode);
        //if (! editor.commit()) {
            //Log.e(LOG_TAG, "failed to commit CLIR preference");
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.918 -0400", hash_original_method = "5FFF1291CED37081608080EEE820D6BC", hash_generated_method = "D75880C79C625D7931F74838081C1E19")
    private void handleCfuQueryResult(CallForwardInfo[] infos) {
        addTaint(infos[0].getTaint());
        if(infos == null || infos.length == 0)        
        {
            mIccRecords.setVoiceCallForwardingFlag(1, false);
        } //End block
        else
        {
for(int i = 0, s = infos.length;i < s;i++)
            {
                if((infos[i].serviceClass & SERVICE_CLASS_VOICE) != 0)                
                {
                    mIccRecords.setVoiceCallForwardingFlag(1, (infos[i].status == 1));
                    break;
                } //End block
            } //End block
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.918 -0400", hash_original_method = "4BF16EE42BDE3709043B0CD4BA1346D5", hash_generated_method = "C803701F5837ABC383EEF17690F7F714")
    public PhoneSubInfo getPhoneSubInfo() {
PhoneSubInfo varF38609CC566E79D788257133E374AE10_1768963652 =         mSubInfo;
        varF38609CC566E79D788257133E374AE10_1768963652.addTaint(taint);
        return varF38609CC566E79D788257133E374AE10_1768963652;
        // ---------- Original Method ----------
        //return mSubInfo;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.918 -0400", hash_original_method = "3207E33C673BD37AF8FDF81E31830AE6", hash_generated_method = "5091FD6F43F5F85EC102178CA381C231")
    public IccSmsInterfaceManager getIccSmsInterfaceManager() {
IccSmsInterfaceManager varF9AFADDB555B0199842DBA2C49358A5C_484506373 =         mSimSmsIntManager;
        varF9AFADDB555B0199842DBA2C49358A5C_484506373.addTaint(taint);
        return varF9AFADDB555B0199842DBA2C49358A5C_484506373;
        // ---------- Original Method ----------
        //return mSimSmsIntManager;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.918 -0400", hash_original_method = "6E6477AE345E3D007CED20614912A5C4", hash_generated_method = "E3A7E9B8562D16FD66299B5824B98F7E")
    public IccPhoneBookInterfaceManager getIccPhoneBookInterfaceManager() {
IccPhoneBookInterfaceManager var53AAAB2C40A5C3EC7D103E41784CE813_2029813965 =         mSimPhoneBookIntManager;
        var53AAAB2C40A5C3EC7D103E41784CE813_2029813965.addTaint(taint);
        return var53AAAB2C40A5C3EC7D103E41784CE813_2029813965;
        // ---------- Original Method ----------
        //return mSimPhoneBookIntManager;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.919 -0400", hash_original_method = "515987807F65054AFA6AA9A268DDB599", hash_generated_method = "5109248967E70CF982AE5C83504E4337")
    public IccFileHandler getIccFileHandler() {
IccFileHandler var60C625BDD447562094F87D9E98CECDB3_284189966 =         this.mIccFileHandler;
        var60C625BDD447562094F87D9E98CECDB3_284189966.addTaint(taint);
        return var60C625BDD447562094F87D9E98CECDB3_284189966;
        // ---------- Original Method ----------
        //return this.mIccFileHandler;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.919 -0400", hash_original_method = "93A82B64CE4B13442120BE4FDBB45597", hash_generated_method = "F1B360206E8120FB3DC1D54785BCDA81")
    public void activateCellBroadcastSms(int activate, Message response) {
        addTaint(response.getTaint());
        addTaint(activate);
        response.sendToTarget();
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[GSMPhone] activateCellBroadcastSms() is obsolete; use SmsManager");
        //response.sendToTarget();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.920 -0400", hash_original_method = "67DD91319C4A7AB6B9A5C1E784682816", hash_generated_method = "7311D8FD847E1EA1BE0BC06BD9C67DE4")
    public void getCellBroadcastSmsConfig(Message response) {
        addTaint(response.getTaint());
        response.sendToTarget();
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[GSMPhone] getCellBroadcastSmsConfig() is obsolete; use SmsManager");
        //response.sendToTarget();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.920 -0400", hash_original_method = "1D706FBF2447232FA856B129DB0956D5", hash_generated_method = "F9A388288F44E6046636ED90EFF85BE4")
    public void setCellBroadcastSmsConfig(int[] configValuesArray, Message response) {
        addTaint(response.getTaint());
        addTaint(configValuesArray[0]);
        response.sendToTarget();
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[GSMPhone] setCellBroadcastSmsConfig() is obsolete; use SmsManager");
        //response.sendToTarget();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.920 -0400", hash_original_method = "99B79EB3DF02CDEF6145664CC8FD0F29", hash_generated_method = "DF11305836D53AAC9C411CEBBD304A86")
    public boolean isCspPlmnEnabled() {
        boolean varBAA62C78149258B7C09EEFF7BAD8C727_408777831 = (mIccRecords.isCspPlmnEnabled());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1062328845 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1062328845;
        // ---------- Original Method ----------
        //return mIccRecords.isCspPlmnEnabled();
    }

    
    private static class NetworkSelectMessage {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.921 -0400", hash_original_field = "78E731027D8FD50ED642340B7C9A63B3", hash_generated_field = "81254C6170A9E52E0AD3BB76A481765A")

        public Message message;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.921 -0400", hash_original_field = "283D783309AC858AFD001B18F5F912C5", hash_generated_field = "8CA2393560EE8C751F612DF94EBF8B4B")

        public String operatorNumeric;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.921 -0400", hash_original_field = "EBA1AB368B4E5EA262B356E9FEB5DBFF", hash_generated_field = "D8A2785302661C77D4C9BAD0912DCC8E")

        public String operatorAlphaLong;
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.921 -0400", hash_original_method = "3039E12EC83A8AA31D55051619D54055", hash_generated_method = "3039E12EC83A8AA31D55051619D54055")
        public NetworkSelectMessage ()
        {
            //Synthesized constructor
        }


    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.921 -0400", hash_original_field = "41EBE7F32B96C1E2E9C209710486A443", hash_generated_field = "B8386CD6D900777C9D6A0A5CA1D0B217")

    static final String LOG_TAG = "GSM";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.921 -0400", hash_original_field = "7F1E46EB212D9379AF8B593E529EF4C2", hash_generated_field = "F62F4824E5D90C8C9780C2AB171AAEE3")

    private static final boolean LOCAL_DEBUG = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.921 -0400", hash_original_field = "EF81B5D96B53AEF2D500834A3DA6EF48", hash_generated_field = "F3DA441E75937751070EF22397051A39")

    public static final String CIPHERING_KEY = "ciphering_key";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.921 -0400", hash_original_field = "E66EAE6BBE4F2F42919E1A4E2896F710", hash_generated_field = "9B3C30C83DCADEE3DE0A0EB64ED01323")

    public static final String VM_NUMBER = "vm_number_key";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.921 -0400", hash_original_field = "B8DF52CD1BE962208AFE9FAF61C00759", hash_generated_field = "45605E617A76B49A021FF496D3F936B3")

    public static final String VM_SIM_IMSI = "vm_sim_imsi_key";
}

