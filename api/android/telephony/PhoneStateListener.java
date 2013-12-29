package android.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.android.internal.telephony.IPhoneStateListener;






public class PhoneStateListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:46.653 -0500", hash_original_field = "0A5B2BD023693D413E9F75E8C9DF4974", hash_generated_field = "2668A1FA15452EF095AB309D80143EE2")

    public static final int LISTEN_NONE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:46.653 -0500", hash_original_field = "545A41CD8D79514D679CF51C880B507E", hash_generated_field = "EA9E1D843E5D2F2EE9DA84427F443A73")

    public static final int LISTEN_SERVICE_STATE                            = 0x00000001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:46.654 -0500", hash_original_field = "B1470D2A81F84D336EBC18EC8117755B", hash_generated_field = "9BC789C2DC17C2E7F01200D42FB2EB97")

    @Deprecated
    public static final int LISTEN_SIGNAL_STRENGTH                          = 0x00000002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:46.655 -0500", hash_original_field = "DED8686712ED774AC38C2D21866004F3", hash_generated_field = "079948D5A4839C139ABA266A60E8C43C")

    public static final int LISTEN_MESSAGE_WAITING_INDICATOR                = 0x00000004;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:46.656 -0500", hash_original_field = "00BAA4EB48F13F0F7D8481F78311CB5B", hash_generated_field = "2C407633607152A9A58FA3E2F3D251BB")

    public static final int LISTEN_CALL_FORWARDING_INDICATOR                = 0x00000008;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:46.657 -0500", hash_original_field = "037DABF206A79C6758B9F9A43AA30764", hash_generated_field = "F17C79B6214A465ED14A618D91A65DF0")

    public static final int LISTEN_CELL_LOCATION                            = 0x00000010;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:46.658 -0500", hash_original_field = "566B325860F5FE5C11F035A7297E8189", hash_generated_field = "D3BB80D3E20C59C05E5F09DD4A108121")

    public static final int LISTEN_CALL_STATE                               = 0x00000020;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:46.658 -0500", hash_original_field = "20B371119F4B6E7A301374915C827B4B", hash_generated_field = "A053609FFB1B37F86F11B4AAF5456228")

    public static final int LISTEN_DATA_CONNECTION_STATE                    = 0x00000040;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:46.659 -0500", hash_original_field = "BF5371B8760C7EA8492CDA00F31BDB2E", hash_generated_field = "BDF733827267C32D8D3126F1C48BBB7A")

    public static final int LISTEN_DATA_ACTIVITY                            = 0x00000080;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:46.661 -0500", hash_original_field = "E1E165A361CD0396949D72C569DEF7EB", hash_generated_field = "02B62E9690B51D18532269564CEA0526")

    public static final int LISTEN_SIGNAL_STRENGTHS                         = 0x00000100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:46.662 -0500", hash_original_field = "56C5CACE6BB82AB388AB35E3EBA742A6", hash_generated_field = "89E2C5A9EA4D2DDF310DBED68B5CBDAB")

    public static final int LISTEN_OTASP_CHANGED                            = 0x00000200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.692 -0400", hash_original_field = "93DBE9FBF8EA760E573744A3CB51F49C", hash_generated_field = "240FC5CF3A1E5844CEA1A4686BC3A90E")

    IPhoneStateListener callback = new IPhoneStateListener.Stub() {        
        @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.687 -0400", hash_original_method = "54E0979B60176178E05220CE78D63618", hash_generated_method = "896ABB9DB951EA538F465FE17351BE4A")
        public void onServiceStateChanged(ServiceState serviceState) {
            
            Message.obtain(mHandler, LISTEN_SERVICE_STATE, 0, 0, serviceState).sendToTarget();
            addTaint(serviceState.getTaint());
            
            
        }

        
        @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.688 -0400", hash_original_method = "807A7BFCEA1B0191C8F013A742695986", hash_generated_method = "29834ADFED34C96085CF9647637FC6F8")
        public void onSignalStrengthChanged(int asu) {
            
            Message.obtain(mHandler, LISTEN_SIGNAL_STRENGTH, asu, 0, null).sendToTarget();
            addTaint(asu);
            
            
        }

        
        @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.688 -0400", hash_original_method = "40C12FC55DD6857044A738B96618D76E", hash_generated_method = "2D0FB5DC734B2BC99447979336864A85")
        public void onMessageWaitingIndicatorChanged(boolean mwi) {
            
            Message.obtain(mHandler, LISTEN_MESSAGE_WAITING_INDICATOR, mwi ? 1 : 0, 0, null)
                    .sendToTarget();
            addTaint(mwi);
            
            
                    
        }

        
        @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.689 -0400", hash_original_method = "1303F4851FC7C46811AB3FA9BCFA27AC", hash_generated_method = "B417E7A99383BB44A23E06E52F8B01FA")
        public void onCallForwardingIndicatorChanged(boolean cfi) {
            
            Message.obtain(mHandler, LISTEN_CALL_FORWARDING_INDICATOR, cfi ? 1 : 0, 0, null)
                    .sendToTarget();
            addTaint(cfi);
            
            
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.689 -0400", hash_original_method = "BD352F057E242D69FEFF4C00A841F3C5", hash_generated_method = "2DB70183ECA77F0A5D7F76F2BC8256E0")
        public void onCellLocationChanged(Bundle bundle) {
            
            CellLocation location = CellLocation.newFromBundle(bundle);
            Message.obtain(mHandler, LISTEN_CELL_LOCATION, 0, 0, location).sendToTarget();
            addTaint(bundle.getTaint());
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.689 -0400", hash_original_method = "90D240AD7654D8CDBBE9240E4026EEC0", hash_generated_method = "25AEEEC8B7BE7C28EA289FC604A8FEBC")
        public void onCallStateChanged(int state, String incomingNumber) {
            
            Message.obtain(mHandler, LISTEN_CALL_STATE, state, 0, incomingNumber).sendToTarget();
            addTaint(state);
            addTaint(incomingNumber.getTaint());
            
            
        }

        
        @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.690 -0400", hash_original_method = "8A3A12A8CE80BED5FCCDE994C492901B", hash_generated_method = "7450F5546A11573F436C66EC50152E2E")
        public void onDataConnectionStateChanged(int state, int networkType) {
            
            Message.obtain(mHandler, LISTEN_DATA_CONNECTION_STATE, state, networkType).
                    sendToTarget();
            addTaint(state);
            addTaint(networkType);
            
            
                    
        }

        
        @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.691 -0400", hash_original_method = "72B647041610C54487B6FB3ED574136B", hash_generated_method = "BB99BAE6935407A4C54BCB9677E95F39")
        public void onDataActivity(int direction) {
            
            Message.obtain(mHandler, LISTEN_DATA_ACTIVITY, direction, 0, null).sendToTarget();
            addTaint(direction);
            
            
        }

        
        @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.691 -0400", hash_original_method = "58C30AB3401BEDE34047CE21CBA2332D", hash_generated_method = "92D058096ABB283F84DD7FE07FFD567B")
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            
            Message.obtain(mHandler, LISTEN_SIGNAL_STRENGTHS, 0, 0, signalStrength).sendToTarget();
            addTaint(signalStrength.getTaint());
            
            
        }

        
        @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.692 -0400", hash_original_method = "5CE4B3BDFCEEE2F8239B6E7FA479E13E", hash_generated_method = "6DBBD590ED3BF273738C91D64A6C9B53")
        public void onOtaspChanged(int otaspMode) {
            
            Message.obtain(mHandler, LISTEN_OTASP_CHANGED, otaspMode, 0).sendToTarget();
            addTaint(otaspMode);
            
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.693 -0400", hash_original_field = "3403CCDA1EA40BE76B26F17C3A252FEF", hash_generated_field = "232E72B4CB2D72FAB017EC4947B8CAB1")

    Handler mHandler = new Handler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.693 -0400", hash_original_method = "6E54091CCEB0E4C4829EFF16721C7D7A", hash_generated_method = "22BEE3C02190EB16B2F2B97BE882EF49")
        public void handleMessage(Message msg) {
            
            PhoneStateListener.this.onServiceStateChanged((ServiceState)msg.obj);
            
            
            PhoneStateListener.this.onSignalStrengthChanged(msg.arg1);
            
            
            PhoneStateListener.this.onMessageWaitingIndicatorChanged(msg.arg1 != 0);
            
            
            PhoneStateListener.this.onCallForwardingIndicatorChanged(msg.arg1 != 0);
            
            
            PhoneStateListener.this.onCellLocationChanged((CellLocation)msg.obj);
            
            
            PhoneStateListener.this.onCallStateChanged(msg.arg1, (String)msg.obj);
            
            
            PhoneStateListener.this.onDataConnectionStateChanged(msg.arg1, msg.arg2);
            
            
            PhoneStateListener.this.onDataConnectionStateChanged(msg.arg1);
            
            
            PhoneStateListener.this.onDataActivity(msg.arg1);
            
            
            PhoneStateListener.this.onSignalStrengthsChanged((SignalStrength)msg.obj);
            
            
            PhoneStateListener.this.onOtaspChanged(msg.arg1);
            
            addTaint(msg.getTaint());
            
            
        }

        
};

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:46.662 -0500", hash_original_method = "20EF8DCC516BA3C0FC2B58EA0CC3EA6E", hash_generated_method = "473E9BD4D0B5D3C1F663E2739D183347")
    public PhoneStateListener() {
    }

    /**
     * Callback invoked when device service state changes.
     *
     * @see ServiceState#STATE_EMERGENCY_ONLY
     * @see ServiceState#STATE_IN_SERVICE
     * @see ServiceState#STATE_OUT_OF_SERVICE
     * @see ServiceState#STATE_POWER_OFF
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:46.663 -0500", hash_original_method = "71FF02CB37AAD9FA42E430343744C95D", hash_generated_method = "6A4D437F0A4E6015B235F63BCD713402")
    public void onServiceStateChanged(ServiceState serviceState) {
        // default implementation empty
    }

    /**
     * Callback invoked when network signal strength changes.
     *
     * @see ServiceState#STATE_EMERGENCY_ONLY
     * @see ServiceState#STATE_IN_SERVICE
     * @see ServiceState#STATE_OUT_OF_SERVICE
     * @see ServiceState#STATE_POWER_OFF
     * @deprecated Use {@link #onSignalStrengthsChanged(SignalStrength)}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:46.664 -0500", hash_original_method = "BC041D78EED5B299AE554E075ADF39D8", hash_generated_method = "C4605B4B9EFC12A82E9A03E0D3B83614")
    @Deprecated
public void onSignalStrengthChanged(int asu) {
        // default implementation empty
    }

    /**
     * Callback invoked when the message-waiting indicator changes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:46.665 -0500", hash_original_method = "75359DDCF2D0B158439199FBAF05E06A", hash_generated_method = "AB13BA3AF446FA82A306C47744A3DBAF")
    public void onMessageWaitingIndicatorChanged(boolean mwi) {
        // default implementation empty
    }

    /**
     * Callback invoked when the call-forwarding indicator changes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:46.666 -0500", hash_original_method = "D5A60C39C845CE2458AA9D81FF0C97F9", hash_generated_method = "7809D56E1A90252DAF5A9AE579827AF4")
    public void onCallForwardingIndicatorChanged(boolean cfi) {
        // default implementation empty
    }

    /**
     * Callback invoked when device cell location changes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:46.667 -0500", hash_original_method = "DC558EBD989E1315B12793B36376A79E", hash_generated_method = "A454123B2928F5DAF408E04F1BFD9C75")
    public void onCellLocationChanged(CellLocation location) {
        // default implementation empty
    }

    /**
     * Callback invoked when device call state changes.
     *
     * @see TelephonyManager#CALL_STATE_IDLE
     * @see TelephonyManager#CALL_STATE_RINGING
     * @see TelephonyManager#CALL_STATE_OFFHOOK
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:46.667 -0500", hash_original_method = "B1A721EFB2ABF6430D11EDB26008EF34", hash_generated_method = "0F512FAE81769FBE457784B1828B9765")
    public void onCallStateChanged(int state, String incomingNumber) {
        // default implementation empty
    }

    /**
     * Callback invoked when connection state changes.
     *
     * @see TelephonyManager#DATA_DISCONNECTED
     * @see TelephonyManager#DATA_CONNECTING
     * @see TelephonyManager#DATA_CONNECTED
     * @see TelephonyManager#DATA_SUSPENDED
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:46.668 -0500", hash_original_method = "1C4CEBBE82C84ACE1203815C2B422383", hash_generated_method = "0135B9E40705D7E3105DAB72CC525AB0")
    public void onDataConnectionStateChanged(int state) {
        // default implementation empty
    }

    /**
     * same as above, but with the network type.  Both called.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:46.669 -0500", hash_original_method = "BFD2027492A8CA27CCE6A852F5D0D4BF", hash_generated_method = "CFB27AB400DD88FBC877D4D8B3607B54")
    public void onDataConnectionStateChanged(int state, int networkType) {
    }

    /**
     * Callback invoked when data activity state changes.
     *
     * @see TelephonyManager#DATA_ACTIVITY_NONE
     * @see TelephonyManager#DATA_ACTIVITY_IN
     * @see TelephonyManager#DATA_ACTIVITY_OUT
     * @see TelephonyManager#DATA_ACTIVITY_INOUT
     * @see TelephonyManager#DATA_ACTIVITY_DORMANT
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:46.670 -0500", hash_original_method = "F374B48EE0586B0F56A0A6BEC28E9201", hash_generated_method = "81C50F436205C428E7EDDB5CEAEA2CA5")
    public void onDataActivity(int direction) {
        // default implementation empty
    }

    /**
     * Callback invoked when network signal strengths changes.
     *
     * @see ServiceState#STATE_EMERGENCY_ONLY
     * @see ServiceState#STATE_IN_SERVICE
     * @see ServiceState#STATE_OUT_OF_SERVICE
     * @see ServiceState#STATE_POWER_OFF
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:46.670 -0500", hash_original_method = "A22E0BB42B0E543666A17B7B6AC4EDC6", hash_generated_method = "8B634D2C9D16E7C7160326010210C3DD")
    public void onSignalStrengthsChanged(SignalStrength signalStrength) {
        // default implementation empty
    }


    /**
     * The Over The Air Service Provisioning (OTASP) has changed. Requires
     * the READ_PHONE_STATE permission.
     * @param otaspMode is integer <code>OTASP_UNKNOWN=1<code>
     *   means the value is currently unknown and the system should wait until
     *   <code>OTASP_NEEDED=2<code> or <code>OTASP_NOT_NEEDED=3<code> is received before
     *   making the decisision to perform OTASP or not.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:46.671 -0500", hash_original_method = "AF1EBC6D8A2DA1E39265DEC2CD9D5FBB", hash_generated_method = "2DDFFB18789BDBA4467A3333F5000805")
    public void onOtaspChanged(int otaspMode) {
        // default implementation empty
    }
}

