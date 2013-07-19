package com.android.internal.telephony;

// Droidsafe Imports
import android.net.LinkCapabilities;
import android.net.LinkProperties;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import android.util.Log;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class DefaultPhoneNotifier implements PhoneNotifier {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:16.220 -0400", hash_original_field = "DD0FB23439ECB9C0C2624C354888EAF5", hash_generated_field = "4C8DBF7E7839184D9CCCD54726CB48C0")

    private ITelephonyRegistry mRegistry;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:16.220 -0400", hash_original_method = "0D80097176ECBA025B5ECF690723E738", hash_generated_method = "48C13188610C75D77DD7EDC9D4536829")
      DefaultPhoneNotifier() {
        mRegistry = ITelephonyRegistry.Stub.asInterface(ServiceManager.getService(
                    "telephony.registry"));
        // ---------- Original Method ----------
        //mRegistry = ITelephonyRegistry.Stub.asInterface(ServiceManager.getService(
                    //"telephony.registry"));
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:16.221 -0400", hash_original_method = "B1B04D5C561E6616E6BB5E666E01B9EA", hash_generated_method = "72D090356AA24BE56084406CA18E405D")
    public void notifyPhoneState(Phone sender) {
        addTaint(sender.getTaint());
        Call ringingCall = sender.getRingingCall();
        String incomingNumber = "";
        if(ringingCall != null && ringingCall.getEarliestConnection() != null)        
        {
            incomingNumber = ringingCall.getEarliestConnection().getAddress();
        } //End block
        try 
        {
            mRegistry.notifyCallState(convertCallState(sender.getState()), incomingNumber);
        } //End block
        catch (RemoteException ex)
        {
        } //End block
        // ---------- Original Method ----------
        //Call ringingCall = sender.getRingingCall();
        //String incomingNumber = "";
        //if (ringingCall != null && ringingCall.getEarliestConnection() != null){
            //incomingNumber = ringingCall.getEarliestConnection().getAddress();
        //}
        //try {
            //mRegistry.notifyCallState(convertCallState(sender.getState()), incomingNumber);
        //} catch (RemoteException ex) {
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:16.221 -0400", hash_original_method = "8120B7915F3C7B653A108168FE940FC9", hash_generated_method = "DB2E0C7F747300AB45AE321EE1C486CD")
    public void notifyServiceState(Phone sender) {
        addTaint(sender.getTaint());
        ServiceState ss = sender.getServiceState();
        if(ss == null)        
        {
            ss = new ServiceState();
            ss.setStateOutOfService();
        } //End block
        try 
        {
            mRegistry.notifyServiceState(ss);
        } //End block
        catch (RemoteException ex)
        {
        } //End block
        // ---------- Original Method ----------
        //ServiceState ss = sender.getServiceState();
        //if (ss == null) {
            //ss = new ServiceState();
            //ss.setStateOutOfService();
        //}
        //try {
            //mRegistry.notifyServiceState(ss);
        //} catch (RemoteException ex) {
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:16.221 -0400", hash_original_method = "51C3EBD9D5F86649F01134EE2C844096", hash_generated_method = "C6B9CE9D627B682BF49F32A95E975C57")
    public void notifySignalStrength(Phone sender) {
        addTaint(sender.getTaint());
        try 
        {
            mRegistry.notifySignalStrength(sender.getSignalStrength());
        } //End block
        catch (RemoteException ex)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mRegistry.notifySignalStrength(sender.getSignalStrength());
        //} catch (RemoteException ex) {
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:16.221 -0400", hash_original_method = "EEA6E3D036FE30A21A0E7B01738A2091", hash_generated_method = "E0171F8EEF192E2A0004C48A2A704753")
    public void notifyMessageWaitingChanged(Phone sender) {
        addTaint(sender.getTaint());
        try 
        {
            mRegistry.notifyMessageWaitingChanged(sender.getMessageWaitingIndicator());
        } //End block
        catch (RemoteException ex)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mRegistry.notifyMessageWaitingChanged(sender.getMessageWaitingIndicator());
        //} catch (RemoteException ex) {
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:16.221 -0400", hash_original_method = "61F204C17435F73A0638C1B2194C11D4", hash_generated_method = "451E9CFEA85F0CA5D41CB5B713559ECF")
    public void notifyCallForwardingChanged(Phone sender) {
        addTaint(sender.getTaint());
        try 
        {
            mRegistry.notifyCallForwardingChanged(sender.getCallForwardingIndicator());
        } //End block
        catch (RemoteException ex)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mRegistry.notifyCallForwardingChanged(sender.getCallForwardingIndicator());
        //} catch (RemoteException ex) {
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:16.221 -0400", hash_original_method = "6186BE83E934F018920409C47A141A66", hash_generated_method = "9EC5744F0BDB119C8FD9A307F87AAB12")
    public void notifyDataActivity(Phone sender) {
        addTaint(sender.getTaint());
        try 
        {
            mRegistry.notifyDataActivity(convertDataActivityState(sender.getDataActivityState()));
        } //End block
        catch (RemoteException ex)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mRegistry.notifyDataActivity(convertDataActivityState(sender.getDataActivityState()));
        //} catch (RemoteException ex) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:16.221 -0400", hash_original_method = "C38F00340F2CC27E90424052E94F9D23", hash_generated_method = "CE263F12A974B7508C64FD18BAC2A4D5")
    public void notifyDataConnection(Phone sender, String reason, String apnType,
            Phone.DataState state) {
        addTaint(state.getTaint());
        addTaint(apnType.getTaint());
        addTaint(reason.getTaint());
        addTaint(sender.getTaint());
        doNotifyDataConnection(sender, reason, apnType, state);
        // ---------- Original Method ----------
        //doNotifyDataConnection(sender, reason, apnType, state);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:16.222 -0400", hash_original_method = "45F138472694590FF541E86BA364ACA8", hash_generated_method = "E8DAE81C97C9283870DABAB63D16519E")
    private void doNotifyDataConnection(Phone sender, String reason, String apnType,
            Phone.DataState state) {
        addTaint(state.getTaint());
        addTaint(apnType.getTaint());
        addTaint(reason.getTaint());
        addTaint(sender.getTaint());
        TelephonyManager telephony = TelephonyManager.getDefault();
        LinkProperties linkProperties = null;
        LinkCapabilities linkCapabilities = null;
        boolean roaming = false;
        if(state == Phone.DataState.CONNECTED)        
        {
            linkProperties = sender.getLinkProperties(apnType);
            linkCapabilities = sender.getLinkCapabilities(apnType);
        } //End block
        ServiceState ss = sender.getServiceState();
        if(ss != null)        
        roaming = ss.getRoaming();
        try 
        {
            mRegistry.notifyDataConnection(
                    convertDataState(state),
                    sender.isDataConnectivityPossible(apnType), reason,
                    sender.getActiveApnHost(apnType),
                    apnType,
                    linkProperties,
                    linkCapabilities,
                    ((telephony!=null) ? telephony.getNetworkType() :
                    TelephonyManager.NETWORK_TYPE_UNKNOWN),
                    roaming);
        } //End block
        catch (RemoteException ex)
        {
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:16.222 -0400", hash_original_method = "67482F4F9D9E6F44C4639F27C32CCD68", hash_generated_method = "719D18BE205D27FCFA5F0CAC82E561DD")
    public void notifyDataConnectionFailed(Phone sender, String reason, String apnType) {
        addTaint(apnType.getTaint());
        addTaint(reason.getTaint());
        addTaint(sender.getTaint());
        try 
        {
            mRegistry.notifyDataConnectionFailed(reason, apnType);
        } //End block
        catch (RemoteException ex)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mRegistry.notifyDataConnectionFailed(reason, apnType);
        //} catch (RemoteException ex) {
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:16.222 -0400", hash_original_method = "200E0849AE67515A7A87FAAD1F0CCF5A", hash_generated_method = "5D4F98D2D9648B85C64571EAA13A54CF")
    public void notifyCellLocation(Phone sender) {
        addTaint(sender.getTaint());
        Bundle data = new Bundle();
        sender.getCellLocation().fillInNotifierBundle(data);
        try 
        {
            mRegistry.notifyCellLocation(data);
        } //End block
        catch (RemoteException ex)
        {
        } //End block
        // ---------- Original Method ----------
        //Bundle data = new Bundle();
        //sender.getCellLocation().fillInNotifierBundle(data);
        //try {
            //mRegistry.notifyCellLocation(data);
        //} catch (RemoteException ex) {
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:16.222 -0400", hash_original_method = "E58B6ECC0D24F432EA477897C3B146BA", hash_generated_method = "41C7AEFFC1A7DF23A22090536AD8817E")
    public void notifyOtaspChanged(Phone sender, int otaspMode) {
        addTaint(otaspMode);
        addTaint(sender.getTaint());
        try 
        {
            mRegistry.notifyOtaspChanged(otaspMode);
        } //End block
        catch (RemoteException ex)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mRegistry.notifyOtaspChanged(otaspMode);
        //} catch (RemoteException ex) {
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:16.222 -0400", hash_original_method = "2A392D1FEF0E39928D559AB442BF53B9", hash_generated_method = "F7E2F6E2C1BD30D3529804142CCA13F9")
    private void log(String s) {
        addTaint(s.getTaint());
        Log.d(LOG_TAG, "[PhoneNotifier] " + s);
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[PhoneNotifier] " + s);
    }

    
    public static int convertCallState(Phone.State state) {
        switch (state) {
            case RINGING:
                return TelephonyManager.CALL_STATE_RINGING;
            case OFFHOOK:
                return TelephonyManager.CALL_STATE_OFFHOOK;
            default:
                return TelephonyManager.CALL_STATE_IDLE;
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static Phone.State convertCallState(int state) {
        switch (state) {
            case TelephonyManager.CALL_STATE_RINGING:
                return Phone.State.RINGING;
            case TelephonyManager.CALL_STATE_OFFHOOK:
                return Phone.State.OFFHOOK;
            default:
                return Phone.State.IDLE;
        }
    }

    
    public static int convertDataState(Phone.DataState state) {
        switch (state) {
            case CONNECTING:
                return TelephonyManager.DATA_CONNECTING;
            case CONNECTED:
                return TelephonyManager.DATA_CONNECTED;
            case SUSPENDED:
                return TelephonyManager.DATA_SUSPENDED;
            default:
                return TelephonyManager.DATA_DISCONNECTED;
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static Phone.DataState convertDataState(int state) {
        switch (state) {
            case TelephonyManager.DATA_CONNECTING:
                return Phone.DataState.CONNECTING;
            case TelephonyManager.DATA_CONNECTED:
                return Phone.DataState.CONNECTED;
            case TelephonyManager.DATA_SUSPENDED:
                return Phone.DataState.SUSPENDED;
            default:
                return Phone.DataState.DISCONNECTED;
        }
    }

    
    public static int convertDataActivityState(Phone.DataActivityState state) {
        switch (state) {
            case DATAIN:
                return TelephonyManager.DATA_ACTIVITY_IN;
            case DATAOUT:
                return TelephonyManager.DATA_ACTIVITY_OUT;
            case DATAINANDOUT:
                return TelephonyManager.DATA_ACTIVITY_INOUT;
            case DORMANT:
                return TelephonyManager.DATA_ACTIVITY_DORMANT;
            default:
                return TelephonyManager.DATA_ACTIVITY_NONE;
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static Phone.DataActivityState convertDataActivityState(int state) {
        switch (state) {
            case TelephonyManager.DATA_ACTIVITY_IN:
                return Phone.DataActivityState.DATAIN;
            case TelephonyManager.DATA_ACTIVITY_OUT:
                return Phone.DataActivityState.DATAOUT;
            case TelephonyManager.DATA_ACTIVITY_INOUT:
                return Phone.DataActivityState.DATAINANDOUT;
            case TelephonyManager.DATA_ACTIVITY_DORMANT:
                return Phone.DataActivityState.DORMANT;
            default:
                return Phone.DataActivityState.NONE;
        }
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:16.223 -0400", hash_original_field = "41EBE7F32B96C1E2E9C209710486A443", hash_generated_field = "B8386CD6D900777C9D6A0A5CA1D0B217")

    static final String LOG_TAG = "GSM";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:16.223 -0400", hash_original_field = "A4622F7F72162611C8E075EE443BC26E", hash_generated_field = "B7707D757F0604821CCAF673B2122320")

    private static final boolean DBG = true;
}

