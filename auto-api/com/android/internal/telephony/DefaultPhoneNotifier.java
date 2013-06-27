package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.net.LinkCapabilities;
import android.net.LinkProperties;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.android.internal.telephony.ITelephonyRegistry;

public class DefaultPhoneNotifier implements PhoneNotifier {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.017 -0400", hash_original_field = "DD0FB23439ECB9C0C2624C354888EAF5", hash_generated_field = "4C8DBF7E7839184D9CCCD54726CB48C0")

    private ITelephonyRegistry mRegistry;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.018 -0400", hash_original_method = "0D80097176ECBA025B5ECF690723E738", hash_generated_method = "48C13188610C75D77DD7EDC9D4536829")
      DefaultPhoneNotifier() {
        mRegistry = ITelephonyRegistry.Stub.asInterface(ServiceManager.getService(
                    "telephony.registry"));
        // ---------- Original Method ----------
        //mRegistry = ITelephonyRegistry.Stub.asInterface(ServiceManager.getService(
                    //"telephony.registry"));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.018 -0400", hash_original_method = "B1B04D5C561E6616E6BB5E666E01B9EA", hash_generated_method = "F2BC8EC25D996FC0F0E9EEC53E189E0F")
    public void notifyPhoneState(Phone sender) {
        Call ringingCall;
        ringingCall = sender.getRingingCall();
        String incomingNumber;
        incomingNumber = "";
        {
            boolean varB2F9A460C50567A982B58D3FB96A1538_91985142 = (ringingCall != null && ringingCall.getEarliestConnection() != null);
            {
                incomingNumber = ringingCall.getEarliestConnection().getAddress();
            } //End block
        } //End collapsed parenthetic
        try 
        {
            mRegistry.notifyCallState(convertCallState(sender.getState()), incomingNumber);
        } //End block
        catch (RemoteException ex)
        { }
        addTaint(sender.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.019 -0400", hash_original_method = "8120B7915F3C7B653A108168FE940FC9", hash_generated_method = "FA4940AE922F38C1FE43C9FBEE6E8AC5")
    public void notifyServiceState(Phone sender) {
        ServiceState ss;
        ss = sender.getServiceState();
        {
            ss = new ServiceState();
            ss.setStateOutOfService();
        } //End block
        try 
        {
            mRegistry.notifyServiceState(ss);
        } //End block
        catch (RemoteException ex)
        { }
        addTaint(sender.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.019 -0400", hash_original_method = "51C3EBD9D5F86649F01134EE2C844096", hash_generated_method = "5EAC87B18CC4F279FD8999C7C7149B06")
    public void notifySignalStrength(Phone sender) {
        try 
        {
            mRegistry.notifySignalStrength(sender.getSignalStrength());
        } //End block
        catch (RemoteException ex)
        { }
        addTaint(sender.getTaint());
        // ---------- Original Method ----------
        //try {
            //mRegistry.notifySignalStrength(sender.getSignalStrength());
        //} catch (RemoteException ex) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.019 -0400", hash_original_method = "EEA6E3D036FE30A21A0E7B01738A2091", hash_generated_method = "6CBFD25648C8FF77BE6DCD7F8710C9BB")
    public void notifyMessageWaitingChanged(Phone sender) {
        try 
        {
            mRegistry.notifyMessageWaitingChanged(sender.getMessageWaitingIndicator());
        } //End block
        catch (RemoteException ex)
        { }
        addTaint(sender.getTaint());
        // ---------- Original Method ----------
        //try {
            //mRegistry.notifyMessageWaitingChanged(sender.getMessageWaitingIndicator());
        //} catch (RemoteException ex) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.026 -0400", hash_original_method = "61F204C17435F73A0638C1B2194C11D4", hash_generated_method = "349712B2920A4FEA7C33E1DD6933682A")
    public void notifyCallForwardingChanged(Phone sender) {
        try 
        {
            mRegistry.notifyCallForwardingChanged(sender.getCallForwardingIndicator());
        } //End block
        catch (RemoteException ex)
        { }
        addTaint(sender.getTaint());
        // ---------- Original Method ----------
        //try {
            //mRegistry.notifyCallForwardingChanged(sender.getCallForwardingIndicator());
        //} catch (RemoteException ex) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.031 -0400", hash_original_method = "6186BE83E934F018920409C47A141A66", hash_generated_method = "0C4FD0525427BDC6CD03B9D20D4B640B")
    public void notifyDataActivity(Phone sender) {
        try 
        {
            mRegistry.notifyDataActivity(convertDataActivityState(sender.getDataActivityState()));
        } //End block
        catch (RemoteException ex)
        { }
        addTaint(sender.getTaint());
        // ---------- Original Method ----------
        //try {
            //mRegistry.notifyDataActivity(convertDataActivityState(sender.getDataActivityState()));
        //} catch (RemoteException ex) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.032 -0400", hash_original_method = "C38F00340F2CC27E90424052E94F9D23", hash_generated_method = "B852C3F95009F5AED8BEAD1A8332CC54")
    public void notifyDataConnection(Phone sender, String reason, String apnType,
            Phone.DataState state) {
        doNotifyDataConnection(sender, reason, apnType, state);
        addTaint(sender.getTaint());
        addTaint(reason.getTaint());
        addTaint(apnType.getTaint());
        addTaint(state.getTaint());
        // ---------- Original Method ----------
        //doNotifyDataConnection(sender, reason, apnType, state);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.037 -0400", hash_original_method = "45F138472694590FF541E86BA364ACA8", hash_generated_method = "EE7FEB527664C8CA894B75A0E6538D75")
    private void doNotifyDataConnection(Phone sender, String reason, String apnType,
            Phone.DataState state) {
        TelephonyManager telephony;
        telephony = TelephonyManager.getDefault();
        LinkProperties linkProperties;
        linkProperties = null;
        LinkCapabilities linkCapabilities;
        linkCapabilities = null;
        boolean roaming;
        roaming = false;
        {
            linkProperties = sender.getLinkProperties(apnType);
            linkCapabilities = sender.getLinkCapabilities(apnType);
        } //End block
        ServiceState ss;
        ss = sender.getServiceState();
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
        { }
        addTaint(sender.getTaint());
        addTaint(reason.getTaint());
        addTaint(apnType.getTaint());
        addTaint(state.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.038 -0400", hash_original_method = "67482F4F9D9E6F44C4639F27C32CCD68", hash_generated_method = "E97A741C6B570CE3A8934B1D4214F16B")
    public void notifyDataConnectionFailed(Phone sender, String reason, String apnType) {
        try 
        {
            mRegistry.notifyDataConnectionFailed(reason, apnType);
        } //End block
        catch (RemoteException ex)
        { }
        addTaint(sender.getTaint());
        addTaint(reason.getTaint());
        addTaint(apnType.getTaint());
        // ---------- Original Method ----------
        //try {
            //mRegistry.notifyDataConnectionFailed(reason, apnType);
        //} catch (RemoteException ex) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.038 -0400", hash_original_method = "200E0849AE67515A7A87FAAD1F0CCF5A", hash_generated_method = "05537DBAA3F465655338683E870BD3F0")
    public void notifyCellLocation(Phone sender) {
        Bundle data;
        data = new Bundle();
        sender.getCellLocation().fillInNotifierBundle(data);
        try 
        {
            mRegistry.notifyCellLocation(data);
        } //End block
        catch (RemoteException ex)
        { }
        addTaint(sender.getTaint());
        // ---------- Original Method ----------
        //Bundle data = new Bundle();
        //sender.getCellLocation().fillInNotifierBundle(data);
        //try {
            //mRegistry.notifyCellLocation(data);
        //} catch (RemoteException ex) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.039 -0400", hash_original_method = "E58B6ECC0D24F432EA477897C3B146BA", hash_generated_method = "332D44B9638D2AFF2029BF7B0A47D264")
    public void notifyOtaspChanged(Phone sender, int otaspMode) {
        try 
        {
            mRegistry.notifyOtaspChanged(otaspMode);
        } //End block
        catch (RemoteException ex)
        { }
        addTaint(sender.getTaint());
        addTaint(otaspMode);
        // ---------- Original Method ----------
        //try {
            //mRegistry.notifyOtaspChanged(otaspMode);
        //} catch (RemoteException ex) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.039 -0400", hash_original_method = "2A392D1FEF0E39928D559AB442BF53B9", hash_generated_method = "C7D03FB155FFDF71D6836A4B5D6F6366")
    private void log(String s) {
        Log.d(LOG_TAG, "[PhoneNotifier] " + s);
        addTaint(s.getTaint());
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.040 -0400", hash_original_field = "41EBE7F32B96C1E2E9C209710486A443", hash_generated_field = "D3C0B237A982707BF0906F1B27E7321D")

    static String LOG_TAG = "GSM";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:14.040 -0400", hash_original_field = "A4622F7F72162611C8E075EE443BC26E", hash_generated_field = "EA7FF8772A7B2A0121F9F6C2158F8474")

    private static boolean DBG = true;
}

