package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.net.LinkCapabilities;
import android.net.LinkProperties;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import android.util.Log;





public class DefaultPhoneNotifier implements PhoneNotifier {

    /**
     * Convert the {@link State} enum into the TelephonyManager.CALL_STATE_* constants
     * for the public API.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.585 -0500", hash_original_method = "258B469CC2028700F6D5512B744F2097", hash_generated_method = "25EDC5FBA8CA763F24F9D72426C687DE")
    
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

    /**
     * Convert the TelephonyManager.CALL_STATE_* constants into the {@link State} enum
     * for the public API.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.587 -0500", hash_original_method = "902608589E83049ED3D3CDE24F5A5CF4", hash_generated_method = "1327E8E12255A854AD0687BDAA8DDA4F")
    
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

    /**
     * Convert the {@link DataState} enum into the TelephonyManager.DATA_* constants
     * for the public API.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.589 -0500", hash_original_method = "28E854EBC0F9965981190D2225921EE4", hash_generated_method = "EEB35AC884CEFA19BA7612701EC9FD72")
    
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

    /**
     * Convert the TelephonyManager.DATA_* constants into {@link DataState} enum
     * for the public API.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.593 -0500", hash_original_method = "02198A37F278E170B10BF88CCE9448EF", hash_generated_method = "344ADD029CA15C021AD4D3F8972CD199")
    
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

    /**
     * Convert the {@link DataState} enum into the TelephonyManager.DATA_* constants
     * for the public API.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.596 -0500", hash_original_method = "89E904B4FEB281B63E2DDFB630F1798A", hash_generated_method = "08AC34F7C8B4281BCA4C102A174262D6")
    
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

    /**
     * Convert the TelephonyManager.DATA_* constants into the {@link DataState} enum
     * for the public API.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.599 -0500", hash_original_method = "164CA82910081A92E5B3C2BCD3EA2757", hash_generated_method = "773CC05D9909CDB3EAA20645FA2AB77D")
    
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.545 -0500", hash_original_field = "28DECCA9F494133CD6F61BCA99A50ECA", hash_generated_field = "B8386CD6D900777C9D6A0A5CA1D0B217")


    static final String LOG_TAG = "GSM";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.547 -0500", hash_original_field = "95D5733A0C83DB3D047D109C028C9F02", hash_generated_field = "B7707D757F0604821CCAF673B2122320")

    private static final boolean DBG = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.550 -0500", hash_original_field = "9479C81BE2F7DA237E4997D2BF1BD99C", hash_generated_field = "4C8DBF7E7839184D9CCCD54726CB48C0")

    private ITelephonyRegistry mRegistry;

    /*package*/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.552 -0500", hash_original_method = "0D80097176ECBA025B5ECF690723E738", hash_generated_method = "0D80097176ECBA025B5ECF690723E738")
    
DefaultPhoneNotifier() {
        mRegistry = ITelephonyRegistry.Stub.asInterface(ServiceManager.getService(
                    "telephony.registry"));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.555 -0500", hash_original_method = "B1B04D5C561E6616E6BB5E666E01B9EA", hash_generated_method = "75B353FDF9C269FD78B6050AF826F7C4")
    
public void notifyPhoneState(Phone sender) {
        Call ringingCall = sender.getRingingCall();
        String incomingNumber = "";
        if (ringingCall != null && ringingCall.getEarliestConnection() != null){
            incomingNumber = ringingCall.getEarliestConnection().getAddress();
        }
        try {
            mRegistry.notifyCallState(convertCallState(sender.getState()), incomingNumber);
        } catch (RemoteException ex) {
            // system process is dead
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.557 -0500", hash_original_method = "8120B7915F3C7B653A108168FE940FC9", hash_generated_method = "FC7CEA322F05FB608F63A479FA15C8C3")
    
public void notifyServiceState(Phone sender) {
        ServiceState ss = sender.getServiceState();
        if (ss == null) {
            ss = new ServiceState();
            ss.setStateOutOfService();
        }
        try {
            mRegistry.notifyServiceState(ss);
        } catch (RemoteException ex) {
            // system process is dead
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.560 -0500", hash_original_method = "51C3EBD9D5F86649F01134EE2C844096", hash_generated_method = "53B417BF970B7F12F1FC27F427569B2E")
    
public void notifySignalStrength(Phone sender) {
        try {
            mRegistry.notifySignalStrength(sender.getSignalStrength());
        } catch (RemoteException ex) {
            // system process is dead
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.563 -0500", hash_original_method = "EEA6E3D036FE30A21A0E7B01738A2091", hash_generated_method = "C2D38217FCD840C7437FDEE1D53082FE")
    
public void notifyMessageWaitingChanged(Phone sender) {
        try {
            mRegistry.notifyMessageWaitingChanged(sender.getMessageWaitingIndicator());
        } catch (RemoteException ex) {
            // system process is dead
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.565 -0500", hash_original_method = "61F204C17435F73A0638C1B2194C11D4", hash_generated_method = "8545250FCA24CA8B809D0BF17E0D6803")
    
public void notifyCallForwardingChanged(Phone sender) {
        try {
            mRegistry.notifyCallForwardingChanged(sender.getCallForwardingIndicator());
        } catch (RemoteException ex) {
            // system process is dead
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.568 -0500", hash_original_method = "6186BE83E934F018920409C47A141A66", hash_generated_method = "375686E4CD9931079B003861D3AE79A0")
    
public void notifyDataActivity(Phone sender) {
        try {
            mRegistry.notifyDataActivity(convertDataActivityState(sender.getDataActivityState()));
        } catch (RemoteException ex) {
            // system process is dead
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.570 -0500", hash_original_method = "C38F00340F2CC27E90424052E94F9D23", hash_generated_method = "F57575633A01BAE5E60581179322EB34")
    
public void notifyDataConnection(Phone sender, String reason, String apnType,
            Phone.DataState state) {
        doNotifyDataConnection(sender, reason, apnType, state);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.573 -0500", hash_original_method = "45F138472694590FF541E86BA364ACA8", hash_generated_method = "940F5BA6E02251E446B9C49314F081E5")
    
private void doNotifyDataConnection(Phone sender, String reason, String apnType,
            Phone.DataState state) {
        // TODO
        // use apnType as the key to which connection we're talking about.
        // pass apnType back up to fetch particular for this one.
        TelephonyManager telephony = TelephonyManager.getDefault();
        LinkProperties linkProperties = null;
        LinkCapabilities linkCapabilities = null;
        boolean roaming = false;

        if (state == Phone.DataState.CONNECTED) {
            linkProperties = sender.getLinkProperties(apnType);
            linkCapabilities = sender.getLinkCapabilities(apnType);
        }
        ServiceState ss = sender.getServiceState();
        if (ss != null) roaming = ss.getRoaming();

        try {
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
        } catch (RemoteException ex) {
            // system process is dead
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.575 -0500", hash_original_method = "67482F4F9D9E6F44C4639F27C32CCD68", hash_generated_method = "E94B950F7188F9DDEE7FC4532B511B75")
    
public void notifyDataConnectionFailed(Phone sender, String reason, String apnType) {
        try {
            mRegistry.notifyDataConnectionFailed(reason, apnType);
        } catch (RemoteException ex) {
            // system process is dead
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.578 -0500", hash_original_method = "200E0849AE67515A7A87FAAD1F0CCF5A", hash_generated_method = "60CF1506EAB08994A10216DABBD21A34")
    
public void notifyCellLocation(Phone sender) {
        Bundle data = new Bundle();
        sender.getCellLocation().fillInNotifierBundle(data);
        try {
            mRegistry.notifyCellLocation(data);
        } catch (RemoteException ex) {
            // system process is dead
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.580 -0500", hash_original_method = "E58B6ECC0D24F432EA477897C3B146BA", hash_generated_method = "ED0BE3664FB78F8DE0E5B3A241483969")
    
public void notifyOtaspChanged(Phone sender, int otaspMode) {
        try {
            mRegistry.notifyOtaspChanged(otaspMode);
        } catch (RemoteException ex) {
            // system process is dead
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.582 -0500", hash_original_method = "2A392D1FEF0E39928D559AB442BF53B9", hash_generated_method = "618CB3583BAA2EBDAF2653A3417F5D39")
    
private void log(String s) {
        Log.d(LOG_TAG, "[PhoneNotifier] " + s);
    }
}

