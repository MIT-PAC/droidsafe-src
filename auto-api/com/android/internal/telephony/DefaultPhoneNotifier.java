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
    private ITelephonyRegistry mRegistry;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.121 -0400", hash_original_method = "0D80097176ECBA025B5ECF690723E738", hash_generated_method = "48C13188610C75D77DD7EDC9D4536829")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     DefaultPhoneNotifier() {
        mRegistry = ITelephonyRegistry.Stub.asInterface(ServiceManager.getService(
                    "telephony.registry"));
        // ---------- Original Method ----------
        //mRegistry = ITelephonyRegistry.Stub.asInterface(ServiceManager.getService(
                    //"telephony.registry"));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.121 -0400", hash_original_method = "B1B04D5C561E6616E6BB5E666E01B9EA", hash_generated_method = "CBD279684F5258BA224ACF233FF1F03F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void notifyPhoneState(Phone sender) {
        dsTaint.addTaint(sender.dsTaint);
        Call ringingCall;
        ringingCall = sender.getRingingCall();
        String incomingNumber;
        incomingNumber = "";
        {
            boolean varB2F9A460C50567A982B58D3FB96A1538_481846310 = (ringingCall != null && ringingCall.getEarliestConnection() != null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.122 -0400", hash_original_method = "8120B7915F3C7B653A108168FE940FC9", hash_generated_method = "D3BFA629F8806D01FDD6CE85DF5980DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void notifyServiceState(Phone sender) {
        dsTaint.addTaint(sender.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.122 -0400", hash_original_method = "51C3EBD9D5F86649F01134EE2C844096", hash_generated_method = "A22B9DEA9AFB71AABC97B9950F6CDE9E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void notifySignalStrength(Phone sender) {
        dsTaint.addTaint(sender.dsTaint);
        try 
        {
            mRegistry.notifySignalStrength(sender.getSignalStrength());
        } //End block
        catch (RemoteException ex)
        { }
        // ---------- Original Method ----------
        //try {
            //mRegistry.notifySignalStrength(sender.getSignalStrength());
        //} catch (RemoteException ex) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.122 -0400", hash_original_method = "EEA6E3D036FE30A21A0E7B01738A2091", hash_generated_method = "303E7F61C14EA1F9BCC36D6847F26BEC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void notifyMessageWaitingChanged(Phone sender) {
        dsTaint.addTaint(sender.dsTaint);
        try 
        {
            mRegistry.notifyMessageWaitingChanged(sender.getMessageWaitingIndicator());
        } //End block
        catch (RemoteException ex)
        { }
        // ---------- Original Method ----------
        //try {
            //mRegistry.notifyMessageWaitingChanged(sender.getMessageWaitingIndicator());
        //} catch (RemoteException ex) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.122 -0400", hash_original_method = "61F204C17435F73A0638C1B2194C11D4", hash_generated_method = "54695A0662B4467CC5DF7EE001DBB687")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void notifyCallForwardingChanged(Phone sender) {
        dsTaint.addTaint(sender.dsTaint);
        try 
        {
            mRegistry.notifyCallForwardingChanged(sender.getCallForwardingIndicator());
        } //End block
        catch (RemoteException ex)
        { }
        // ---------- Original Method ----------
        //try {
            //mRegistry.notifyCallForwardingChanged(sender.getCallForwardingIndicator());
        //} catch (RemoteException ex) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.122 -0400", hash_original_method = "6186BE83E934F018920409C47A141A66", hash_generated_method = "D5AD2E2EA8EB1EE119B5151D7B5C7074")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void notifyDataActivity(Phone sender) {
        dsTaint.addTaint(sender.dsTaint);
        try 
        {
            mRegistry.notifyDataActivity(convertDataActivityState(sender.getDataActivityState()));
        } //End block
        catch (RemoteException ex)
        { }
        // ---------- Original Method ----------
        //try {
            //mRegistry.notifyDataActivity(convertDataActivityState(sender.getDataActivityState()));
        //} catch (RemoteException ex) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.123 -0400", hash_original_method = "C38F00340F2CC27E90424052E94F9D23", hash_generated_method = "42567E2F4DFCA13391BA5C6A3043F60B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void notifyDataConnection(Phone sender, String reason, String apnType,
            Phone.DataState state) {
        dsTaint.addTaint(sender.dsTaint);
        dsTaint.addTaint(reason);
        dsTaint.addTaint(state.dsTaint);
        dsTaint.addTaint(apnType);
        doNotifyDataConnection(sender, reason, apnType, state);
        // ---------- Original Method ----------
        //doNotifyDataConnection(sender, reason, apnType, state);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.123 -0400", hash_original_method = "45F138472694590FF541E86BA364ACA8", hash_generated_method = "FF1C24BAD8AB5F2482347A51E0DCF41F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void doNotifyDataConnection(Phone sender, String reason, String apnType,
            Phone.DataState state) {
        dsTaint.addTaint(sender.dsTaint);
        dsTaint.addTaint(reason);
        dsTaint.addTaint(state.dsTaint);
        dsTaint.addTaint(apnType);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.123 -0400", hash_original_method = "67482F4F9D9E6F44C4639F27C32CCD68", hash_generated_method = "470976DBD3B8F4E9491A14E6CF8BAF26")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void notifyDataConnectionFailed(Phone sender, String reason, String apnType) {
        dsTaint.addTaint(sender.dsTaint);
        dsTaint.addTaint(reason);
        dsTaint.addTaint(apnType);
        try 
        {
            mRegistry.notifyDataConnectionFailed(reason, apnType);
        } //End block
        catch (RemoteException ex)
        { }
        // ---------- Original Method ----------
        //try {
            //mRegistry.notifyDataConnectionFailed(reason, apnType);
        //} catch (RemoteException ex) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.123 -0400", hash_original_method = "200E0849AE67515A7A87FAAD1F0CCF5A", hash_generated_method = "5908FDA7569E8C55E468EE40CEB101BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void notifyCellLocation(Phone sender) {
        dsTaint.addTaint(sender.dsTaint);
        Bundle data;
        data = new Bundle();
        sender.getCellLocation().fillInNotifierBundle(data);
        try 
        {
            mRegistry.notifyCellLocation(data);
        } //End block
        catch (RemoteException ex)
        { }
        // ---------- Original Method ----------
        //Bundle data = new Bundle();
        //sender.getCellLocation().fillInNotifierBundle(data);
        //try {
            //mRegistry.notifyCellLocation(data);
        //} catch (RemoteException ex) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.124 -0400", hash_original_method = "E58B6ECC0D24F432EA477897C3B146BA", hash_generated_method = "0877C28381339BBD0410AF8051DFEEB9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void notifyOtaspChanged(Phone sender, int otaspMode) {
        dsTaint.addTaint(sender.dsTaint);
        dsTaint.addTaint(otaspMode);
        try 
        {
            mRegistry.notifyOtaspChanged(otaspMode);
        } //End block
        catch (RemoteException ex)
        { }
        // ---------- Original Method ----------
        //try {
            //mRegistry.notifyOtaspChanged(otaspMode);
        //} catch (RemoteException ex) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.124 -0400", hash_original_method = "2A392D1FEF0E39928D559AB442BF53B9", hash_generated_method = "BBE16758585C5523C3EC1E036B6FA962")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void log(String s) {
        dsTaint.addTaint(s);
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

    
    static final String LOG_TAG = "GSM";
    private static final boolean DBG = true;
}

