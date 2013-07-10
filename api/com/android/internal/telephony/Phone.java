package com.android.internal.telephony;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.content.Context;
import android.net.LinkCapabilities;
import android.net.LinkProperties;
import android.os.Handler;
import android.os.Message;
import android.os.SystemProperties;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import com.android.internal.telephony.DataConnection;
import com.android.internal.telephony.gsm.UsimServiceTable;
import com.android.internal.telephony.ims.IsimRecords;
import com.android.internal.telephony.test.SimulatedRadioControl;
import java.util.List;

public interface Phone {

    
    static final boolean DEBUG_PHONE = true;


    
    enum State {
        IDLE, RINGING, OFFHOOK;
    };

    
    enum DataState {
        CONNECTED, CONNECTING, DISCONNECTED, SUSPENDED;
    };

    public enum DataActivityState {
        
        NONE, DATAIN, DATAOUT, DATAINANDOUT, DORMANT;
    };

    enum SuppService {
      UNKNOWN, SWITCH, SEPARATE, TRANSFER, CONFERENCE, REJECT, HANGUP;
    };

    static final String STATE_KEY = "state";
    static final String PHONE_NAME_KEY = "phoneName";
    static final String FAILURE_REASON_KEY = "reason";
    static final String STATE_CHANGE_REASON_KEY = "reason";
    static final String DATA_APN_TYPE_KEY = "apnType";
    static final String DATA_APN_KEY = "apn";
    static final String DATA_LINK_PROPERTIES_KEY = "linkProperties";
    static final String DATA_LINK_CAPABILITIES_KEY = "linkCapabilities";

    static final String DATA_IFACE_NAME_KEY = "iface";
    static final String NETWORK_UNAVAILABLE_KEY = "networkUnvailable";
    static final String DATA_NETWORK_ROAMING_KEY = "networkRoaming";
    static final String PHONE_IN_ECM_STATE = "phoneinECMState";

    
    static final String APN_TYPE_ALL = "*";
    
    static final String APN_TYPE_DEFAULT = "default";
    
    static final String APN_TYPE_MMS = "mms";
    
    static final String APN_TYPE_SUPL = "supl";
    
    static final String APN_TYPE_DUN = "dun";
    
    static final String APN_TYPE_HIPRI = "hipri";
    
    static final String APN_TYPE_FOTA = "fota";
    
    static final String APN_TYPE_IMS = "ims";
    
    static final String APN_TYPE_CBS = "cbs";

    
    static final String FEATURE_ENABLE_MMS = "enableMMS";
    static final String FEATURE_ENABLE_SUPL = "enableSUPL";
    static final String FEATURE_ENABLE_DUN = "enableDUN";
    static final String FEATURE_ENABLE_HIPRI = "enableHIPRI";
    static final String FEATURE_ENABLE_DUN_ALWAYS = "enableDUNAlways";
    static final String FEATURE_ENABLE_FOTA = "enableFOTA";
    static final String FEATURE_ENABLE_IMS = "enableIMS";
    static final String FEATURE_ENABLE_CBS = "enableCBS";

    
    static final int APN_ALREADY_ACTIVE     = 0;
    static final int APN_REQUEST_STARTED    = 1;
    static final int APN_TYPE_NOT_AVAILABLE = 2;
    static final int APN_REQUEST_FAILED     = 3;
    static final int APN_ALREADY_INACTIVE   = 4;


    
    static final String REASON_ROAMING_ON = "roamingOn";
    static final String REASON_ROAMING_OFF = "roamingOff";
    static final String REASON_DATA_DISABLED = "dataDisabled";
    static final String REASON_DATA_ENABLED = "dataEnabled";
    static final String REASON_DATA_ATTACHED = "dataAttached";
    static final String REASON_DATA_DETACHED = "dataDetached";
    static final String REASON_CDMA_DATA_ATTACHED = "cdmaDataAttached";
    static final String REASON_CDMA_DATA_DETACHED = "cdmaDataDetached";
    static final String REASON_APN_CHANGED = "apnChanged";
    static final String REASON_APN_SWITCHED = "apnSwitched";
    static final String REASON_APN_FAILED = "apnFailed";
    static final String REASON_RESTORE_DEFAULT_APN = "restoreDefaultApn";
    static final String REASON_RADIO_TURNED_OFF = "radioTurnedOff";
    static final String REASON_PDP_RESET = "pdpReset";
    static final String REASON_VOICE_CALL_ENDED = "2GVoiceCallEnded";
    static final String REASON_VOICE_CALL_STARTED = "2GVoiceCallStarted";
    static final String REASON_PS_RESTRICT_ENABLED = "psRestrictEnabled";
    static final String REASON_PS_RESTRICT_DISABLED = "psRestrictDisabled";
    static final String REASON_SIM_LOADED = "simLoaded";
    static final String REASON_NW_TYPE_CHANGED = "nwTypeChanged";
    static final String REASON_DATA_DEPENDENCY_MET = "dependencyMet";
    static final String REASON_DATA_DEPENDENCY_UNMET = "dependencyUnmet";
    static final String REASON_LINK_PROPERTIES_CHANGED = "linkPropertiesChanged";

    
    static final int BM_UNSPECIFIED = 0; 
    static final int BM_EURO_BAND   = 1; 
    static final int BM_US_BAND     = 2; 
    static final int BM_JPN_BAND    = 3; 
    static final int BM_AUS_BAND    = 4; 
    static final int BM_AUS2_BAND   = 5; 
    static final int BM_BOUNDARY    = 6; 

    
    static final int PHONE_TYPE_NONE = RILConstants.NO_PHONE;
    static final int PHONE_TYPE_GSM = RILConstants.GSM_PHONE;
    static final int PHONE_TYPE_CDMA = RILConstants.CDMA_PHONE;
    static final int PHONE_TYPE_SIP = RILConstants.SIP_PHONE;

    
    static final int LTE_ON_CDMA_UNKNOWN = RILConstants.LTE_ON_CDMA_UNKNOWN;
    static final int LTE_ON_CDMA_FALSE = RILConstants.LTE_ON_CDMA_FALSE;
    static final int LTE_ON_CDMA_TRUE = RILConstants.LTE_ON_CDMA_TRUE;

    
    
    int NT_MODE_WCDMA_PREF   = RILConstants.NETWORK_MODE_WCDMA_PREF;
    int NT_MODE_GSM_ONLY     = RILConstants.NETWORK_MODE_GSM_ONLY;
    int NT_MODE_WCDMA_ONLY   = RILConstants.NETWORK_MODE_WCDMA_ONLY;
    int NT_MODE_GSM_UMTS     = RILConstants.NETWORK_MODE_GSM_UMTS;

    int NT_MODE_CDMA         = RILConstants.NETWORK_MODE_CDMA;

    int NT_MODE_CDMA_NO_EVDO = RILConstants.NETWORK_MODE_CDMA_NO_EVDO;
    int NT_MODE_EVDO_NO_CDMA = RILConstants.NETWORK_MODE_EVDO_NO_CDMA;
    int NT_MODE_GLOBAL       = RILConstants.NETWORK_MODE_GLOBAL;

    int NT_MODE_LTE_ONLY     = RILConstants.NETWORK_MODE_LTE_ONLY;
    int PREFERRED_NT_MODE    = RILConstants.PREFERRED_NETWORK_MODE;


    
    static final int CDMA_RM_HOME        = 0;  
    static final int CDMA_RM_AFFILIATED  = 1;  
    static final int CDMA_RM_ANY         = 2;  

    
    static final int CDMA_SUBSCRIPTION_RUIM_SIM = 0; 
    static final int CDMA_SUBSCRIPTION_NV       = 1; 

    static final int PREFERRED_CDMA_SUBSCRIPTION = CDMA_SUBSCRIPTION_NV;

    static final int TTY_MODE_OFF = 0;
    static final int TTY_MODE_FULL = 1;
    static final int TTY_MODE_HCO = 2;
    static final int TTY_MODE_VCO = 3;

     

    public static final int CDMA_OTA_PROVISION_STATUS_SPL_UNLOCKED = 0;
    public static final int CDMA_OTA_PROVISION_STATUS_SPC_RETRIES_EXCEEDED = 1;
    public static final int CDMA_OTA_PROVISION_STATUS_A_KEY_EXCHANGED = 2;
    public static final int CDMA_OTA_PROVISION_STATUS_SSD_UPDATED = 3;
    public static final int CDMA_OTA_PROVISION_STATUS_NAM_DOWNLOADED = 4;
    public static final int CDMA_OTA_PROVISION_STATUS_MDN_DOWNLOADED = 5;
    public static final int CDMA_OTA_PROVISION_STATUS_IMSI_DOWNLOADED = 6;
    public static final int CDMA_OTA_PROVISION_STATUS_PRL_DOWNLOADED = 7;
    public static final int CDMA_OTA_PROVISION_STATUS_COMMITTED = 8;
    public static final int CDMA_OTA_PROVISION_STATUS_OTAPA_STARTED = 9;
    public static final int CDMA_OTA_PROVISION_STATUS_OTAPA_STOPPED = 10;
    public static final int CDMA_OTA_PROVISION_STATUS_OTAPA_ABORTED = 11;


    
    ServiceState getServiceState();

    
    CellLocation getCellLocation();

    
    DataState getDataConnectionState();

    
    DataState getDataConnectionState(String apnType);

    
    DataActivityState getDataActivityState();

    
    Context getContext();

    
    void disableDnsCheck(boolean b);

    
    boolean isDnsCheckDisabled();

    
    State getState();

    
    String getPhoneName();

    
    int getPhoneType();

    
    String[] getActiveApnTypes();

    
    String getActiveApnHost(String apnType);

    
    LinkProperties getLinkProperties(String apnType);

    
    LinkCapabilities getLinkCapabilities(String apnType);

    
    SignalStrength getSignalStrength();

    
    void registerForUnknownConnection(Handler h, int what, Object obj);

    
    void unregisterForUnknownConnection(Handler h);

    
    void registerForPreciseCallStateChanged(Handler h, int what, Object obj);

    
    void unregisterForPreciseCallStateChanged(Handler h);


    
    void registerForNewRingingConnection(Handler h, int what, Object obj);

    

    void unregisterForNewRingingConnection(Handler h);

    
    void registerForIncomingRing(Handler h, int what, Object obj);

    

    void unregisterForIncomingRing(Handler h);

    
    void registerForRingbackTone(Handler h, int what, Object obj);

    

    void unregisterForRingbackTone(Handler h);

    
    void registerForResendIncallMute(Handler h, int what, Object obj);

    
    void unregisterForResendIncallMute(Handler h);

    
    void registerForDisconnect(Handler h, int what, Object obj);

    
    void unregisterForDisconnect(Handler h);


    
    void registerForMmiInitiate(Handler h, int what, Object obj);

    
    void unregisterForMmiInitiate(Handler h);

    
    void registerForMmiComplete(Handler h, int what, Object obj);

    
    void unregisterForMmiComplete(Handler h);

    
    public void registerForEcmTimerReset(Handler h, int what, Object obj);

    
    public void unregisterForEcmTimerReset(Handler h);

    
    public List<? extends MmiCode> getPendingMmiCodes();

    
    public void sendUssdResponse(String ussdMessge);

    
    void registerForServiceStateChanged(Handler h, int what, Object obj);

    
    void unregisterForServiceStateChanged(Handler h);

    
    void registerForSuppServiceNotification(Handler h, int what, Object obj);

    
    void unregisterForSuppServiceNotification(Handler h);

    
    void registerForSuppServiceFailed(Handler h, int what, Object obj);

    
    void unregisterForSuppServiceFailed(Handler h);

    
    void registerForInCallVoicePrivacyOn(Handler h, int what, Object obj);

    
    void unregisterForInCallVoicePrivacyOn(Handler h);

    
    void registerForInCallVoicePrivacyOff(Handler h, int what, Object obj);

    
    void unregisterForInCallVoicePrivacyOff(Handler h);

    
    void registerForCdmaOtaStatusChange(Handler h, int what, Object obj);

    
    void unregisterForCdmaOtaStatusChange(Handler h);

    
    public void registerForSubscriptionInfoReady(Handler h, int what, Object obj);

    
    public void unregisterForSubscriptionInfoReady(Handler h);

    
    boolean getIccRecordsLoaded();

    
    IccCard getIccCard();

    
    void acceptCall() throws CallStateException;

    
    void rejectCall() throws CallStateException;

    
    void switchHoldingAndActive() throws CallStateException;

    
    boolean canConference();

    
    void conference() throws CallStateException;

    
    void enableEnhancedVoicePrivacy(boolean enable, Message onComplete);

    
    void getEnhancedVoicePrivacy(Message onComplete);

    
    boolean canTransfer();

    
    void explicitCallTransfer() throws CallStateException;

    
    void clearDisconnected();


    
    Call getForegroundCall();

    
    Call getBackgroundCall();

    
    Call getRingingCall();

    
    Connection dial(String dialString) throws CallStateException;

    
    Connection dial(String dialString, UUSInfo uusInfo) throws CallStateException;

    
    boolean handlePinMmi(String dialString);

    
    boolean handleInCallMmiCommands(String command) throws CallStateException;

    
    void sendDtmf(char c);

    
    void startDtmf(char c);

    
    void stopDtmf();

    
    void sendBurstDtmf(String dtmfString, int on, int off, Message onComplete);

    
    void setRadioPower(boolean power);

    
    boolean getMessageWaitingIndicator();

    
    boolean getCallForwardingIndicator();

    
    String getLine1Number();

    
    String getLine1AlphaTag();

    
    void setLine1Number(String alphaTag, String number, Message onComplete);

    
    String getVoiceMailNumber();

    
    int getVoiceMessageCount();

    
    String getVoiceMailAlphaTag();

    
    void setVoiceMailNumber(String alphaTag,
                            String voiceMailNumber,
                            Message onComplete);

    
    void getCallForwardingOption(int commandInterfaceCFReason,
                                  Message onComplete);

    
    void setCallForwardingOption(int commandInterfaceCFReason,
                                 int commandInterfaceCFAction,
                                 String dialingNumber,
                                 int timerSeconds,
                                 Message onComplete);

    
    void getOutgoingCallerIdDisplay(Message onComplete);

    
    void setOutgoingCallerIdDisplay(int commandInterfaceCLIRMode,
                                    Message onComplete);

    
    void getCallWaiting(Message onComplete);

    
    void setCallWaiting(boolean enable, Message onComplete);

    
    void getAvailableNetworks(Message response);

    
    void setNetworkSelectionModeAutomatic(Message response);

    
    void selectNetworkManually(OperatorInfo network,
                            Message response);

    
    void setPreferredNetworkType(int networkType, Message response);

    
    void getPreferredNetworkType(Message response);

    
    void getSmscAddress(Message result);

    
    void setSmscAddress(String address, Message result);

    
    void getNeighboringCids(Message response);

    
    void setOnPostDialCharacter(Handler h, int what, Object obj);


    

    void setMute(boolean muted);

    
    boolean getMute();

    
    void setEchoSuppressionEnabled(boolean enabled);

    
    void invokeOemRilRequestRaw(byte[] data, Message response);

    
    void invokeOemRilRequestStrings(String[] strings, Message response);

    
    void getDataCallList(Message response);

    
    void updateServiceLocation();

    
    void enableLocationUpdates();

    
    void disableLocationUpdates();

    
    void setUnitTestMode(boolean f);

    
    boolean getUnitTestMode();

    
    void setBandMode(int bandMode, Message response);

    
    void queryAvailableBandMode(Message response);

    
    boolean getDataRoamingEnabled();

    
    void setDataRoamingEnabled(boolean enable);

    
    void queryCdmaRoamingPreference(Message response);

    
    void setCdmaRoamingPreference(int cdmaRoamingType, Message response);

    
    void setCdmaSubscription(int cdmaSubscriptionType, Message response);

    
    SimulatedRadioControl getSimulatedRadioControl();

    
    int enableApnType(String type);

    
    int disableApnType(String type);

    
    boolean isDataConnectivityPossible();

    
    boolean isDataConnectivityPossible(String apnType);

    
    String getDeviceId();

    
    String getDeviceSvn();

    
    String getSubscriberId();

    
    String getIccSerialNumber();

    

    
    String getCdmaMin();

    
    boolean isMinInfoReady();

    
    String getCdmaPrlVersion();

    
    String getEsn();

    
    String getMeid();

    
    String getMsisdn();

    
    String getImei();

    
    public PhoneSubInfo getPhoneSubInfo();

    
    public IccSmsInterfaceManager getIccSmsInterfaceManager();

    
    public IccPhoneBookInterfaceManager getIccPhoneBookInterfaceManager();

    
    void setTTYMode(int ttyMode, Message onComplete);

    
    void queryTTYMode(Message onComplete);

    
    void activateCellBroadcastSms(int activate, Message response);

    
    void getCellBroadcastSmsConfig(Message response);

    
    public void setCellBroadcastSmsConfig(int[] configValuesArray, Message response);

    public void notifyDataActivity();

    
    public int getCdmaEriIconIndex();

    
    public int getCdmaEriIconMode();

    
    public String getCdmaEriText();

    
    void exitEmergencyCallbackMode();

    
    boolean isOtaSpNumber(String dialStr);

    
    boolean needsOtaServiceProvisioning();

    
    void registerForCallWaiting(Handler h, int what, Object obj);

    
    void unregisterForCallWaiting(Handler h);


    

    void registerForSignalInfo(Handler h, int what, Object obj) ;
    
    void unregisterForSignalInfo(Handler h);

    
    void registerForDisplayInfo(Handler h, int what, Object obj);

    
    void unregisterForDisplayInfo(Handler h) ;

    
    void registerForNumberInfo(Handler h, int what, Object obj);

    
    void unregisterForNumberInfo(Handler h);

    
    void registerForRedirectedNumberInfo(Handler h, int what, Object obj);

    
    void unregisterForRedirectedNumberInfo(Handler h);

    
    void registerForLineControlInfo(Handler h, int what, Object obj);

    
    void unregisterForLineControlInfo(Handler h);

    
    void registerFoT53ClirlInfo(Handler h, int what, Object obj);

    
    void unregisterForT53ClirInfo(Handler h);

    
    void registerForT53AudioControlInfo(Handler h, int what, Object obj);

    
    void unregisterForT53AudioControlInfo(Handler h);

    

    void setOnEcbModeExitResponse(Handler h, int what, Object obj);

    
    void unsetOnEcbModeExitResponse(Handler h);

    
    public int getLteOnCdmaMode();

    
    boolean isCspPlmnEnabled();

    
    IsimRecords getIsimRecords();

    
    void requestIsimAuthentication(String nonce, Message response);

    
    void setVoiceMessageWaiting(int line, int countWaiting);

    
    UsimServiceTable getUsimServiceTable();
}
