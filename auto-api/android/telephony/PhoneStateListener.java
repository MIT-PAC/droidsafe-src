package android.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.CellLocation;
import android.util.Log;
import com.android.internal.telephony.IPhoneStateListener;
import com.android.internal.telephony.Phone;

public class PhoneStateListener {
    IPhoneStateListener callback = new IPhoneStateListener.Stub() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.535 -0400", hash_original_method = "54E0979B60176178E05220CE78D63618", hash_generated_method = "742E3F9070F8A94D9B7C788DE477CF9D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onServiceStateChanged(ServiceState serviceState) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(serviceState.dsTaint);
            Message.obtain(mHandler, LISTEN_SERVICE_STATE, 0, 0, serviceState).sendToTarget();
            // ---------- Original Method ----------
            //Message.obtain(mHandler, LISTEN_SERVICE_STATE, 0, 0, serviceState).sendToTarget();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.535 -0400", hash_original_method = "807A7BFCEA1B0191C8F013A742695986", hash_generated_method = "5C4FE9F2FFDA6906A984B69A67FA0F43")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onSignalStrengthChanged(int asu) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(asu);
            Message.obtain(mHandler, LISTEN_SIGNAL_STRENGTH, asu, 0, null).sendToTarget();
            // ---------- Original Method ----------
            //Message.obtain(mHandler, LISTEN_SIGNAL_STRENGTH, asu, 0, null).sendToTarget();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.535 -0400", hash_original_method = "40C12FC55DD6857044A738B96618D76E", hash_generated_method = "B1C31857EA90DE561113E44EAB973398")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onMessageWaitingIndicatorChanged(boolean mwi) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(mwi);
            Message.obtain(mHandler, LISTEN_MESSAGE_WAITING_INDICATOR, mwi ? 1 : 0, 0, null)
                    .sendToTarget();
            // ---------- Original Method ----------
            //Message.obtain(mHandler, LISTEN_MESSAGE_WAITING_INDICATOR, mwi ? 1 : 0, 0, null)
                    //.sendToTarget();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.536 -0400", hash_original_method = "1303F4851FC7C46811AB3FA9BCFA27AC", hash_generated_method = "8D7859300912DF76AE09FC6BBCAA31E3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onCallForwardingIndicatorChanged(boolean cfi) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(cfi);
            Message.obtain(mHandler, LISTEN_CALL_FORWARDING_INDICATOR, cfi ? 1 : 0, 0, null)
                    .sendToTarget();
            // ---------- Original Method ----------
            //Message.obtain(mHandler, LISTEN_CALL_FORWARDING_INDICATOR, cfi ? 1 : 0, 0, null)
                    //.sendToTarget();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.536 -0400", hash_original_method = "BD352F057E242D69FEFF4C00A841F3C5", hash_generated_method = "A9C5CA7C1559E03255B6C0EC972FE359")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onCellLocationChanged(Bundle bundle) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(bundle.dsTaint);
            CellLocation location;
            location = CellLocation.newFromBundle(bundle);
            Message.obtain(mHandler, LISTEN_CELL_LOCATION, 0, 0, location).sendToTarget();
            // ---------- Original Method ----------
            //CellLocation location = CellLocation.newFromBundle(bundle);
            //Message.obtain(mHandler, LISTEN_CELL_LOCATION, 0, 0, location).sendToTarget();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.536 -0400", hash_original_method = "90D240AD7654D8CDBBE9240E4026EEC0", hash_generated_method = "578546FA7F9AFF7B8F6A7DB8F20CD7B2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onCallStateChanged(int state, String incomingNumber) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(state);
            dsTaint.addTaint(incomingNumber);
            Message.obtain(mHandler, LISTEN_CALL_STATE, state, 0, incomingNumber).sendToTarget();
            // ---------- Original Method ----------
            //Message.obtain(mHandler, LISTEN_CALL_STATE, state, 0, incomingNumber).sendToTarget();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.536 -0400", hash_original_method = "8A3A12A8CE80BED5FCCDE994C492901B", hash_generated_method = "7D571A15C228E0AEBC232B0FD100235D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onDataConnectionStateChanged(int state, int networkType) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(networkType);
            dsTaint.addTaint(state);
            Message.obtain(mHandler, LISTEN_DATA_CONNECTION_STATE, state, networkType).
                    sendToTarget();
            // ---------- Original Method ----------
            //Message.obtain(mHandler, LISTEN_DATA_CONNECTION_STATE, state, networkType).
                    //sendToTarget();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.537 -0400", hash_original_method = "72B647041610C54487B6FB3ED574136B", hash_generated_method = "0EC8C6CA0B6E3711DD198CE3FCCE156F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onDataActivity(int direction) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(direction);
            Message.obtain(mHandler, LISTEN_DATA_ACTIVITY, direction, 0, null).sendToTarget();
            // ---------- Original Method ----------
            //Message.obtain(mHandler, LISTEN_DATA_ACTIVITY, direction, 0, null).sendToTarget();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.537 -0400", hash_original_method = "58C30AB3401BEDE34047CE21CBA2332D", hash_generated_method = "152ED966CD3329F360FE6B86604039CD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(signalStrength.dsTaint);
            Message.obtain(mHandler, LISTEN_SIGNAL_STRENGTHS, 0, 0, signalStrength).sendToTarget();
            // ---------- Original Method ----------
            //Message.obtain(mHandler, LISTEN_SIGNAL_STRENGTHS, 0, 0, signalStrength).sendToTarget();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.537 -0400", hash_original_method = "5CE4B3BDFCEEE2F8239B6E7FA479E13E", hash_generated_method = "E802CEFE6CC9C4BBB9A8A2FE1B71B7F5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onOtaspChanged(int otaspMode) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(otaspMode);
            Message.obtain(mHandler, LISTEN_OTASP_CHANGED, otaspMode, 0).sendToTarget();
            // ---------- Original Method ----------
            //Message.obtain(mHandler, LISTEN_OTASP_CHANGED, otaspMode, 0).sendToTarget();
        }

        
}; //Transformed anonymous class
    Handler mHandler = new Handler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.538 -0400", hash_original_method = "6E54091CCEB0E4C4829EFF16721C7D7A", hash_generated_method = "D9AEF8B507C691A423C39E99C23B46A0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void handleMessage(Message msg) {
            dsTaint.addTaint(msg.dsTaint);
            //Begin case LISTEN_SERVICE_STATE 
            PhoneStateListener.this.onServiceStateChanged((ServiceState)msg.obj);
            //End case LISTEN_SERVICE_STATE 
            //Begin case LISTEN_SIGNAL_STRENGTH 
            PhoneStateListener.this.onSignalStrengthChanged(msg.arg1);
            //End case LISTEN_SIGNAL_STRENGTH 
            //Begin case LISTEN_MESSAGE_WAITING_INDICATOR 
            PhoneStateListener.this.onMessageWaitingIndicatorChanged(msg.arg1 != 0);
            //End case LISTEN_MESSAGE_WAITING_INDICATOR 
            //Begin case LISTEN_CALL_FORWARDING_INDICATOR 
            PhoneStateListener.this.onCallForwardingIndicatorChanged(msg.arg1 != 0);
            //End case LISTEN_CALL_FORWARDING_INDICATOR 
            //Begin case LISTEN_CELL_LOCATION 
            PhoneStateListener.this.onCellLocationChanged((CellLocation)msg.obj);
            //End case LISTEN_CELL_LOCATION 
            //Begin case LISTEN_CALL_STATE 
            PhoneStateListener.this.onCallStateChanged(msg.arg1, (String)msg.obj);
            //End case LISTEN_CALL_STATE 
            //Begin case LISTEN_DATA_CONNECTION_STATE 
            PhoneStateListener.this.onDataConnectionStateChanged(msg.arg1, msg.arg2);
            //End case LISTEN_DATA_CONNECTION_STATE 
            //Begin case LISTEN_DATA_CONNECTION_STATE 
            PhoneStateListener.this.onDataConnectionStateChanged(msg.arg1);
            //End case LISTEN_DATA_CONNECTION_STATE 
            //Begin case LISTEN_DATA_ACTIVITY 
            PhoneStateListener.this.onDataActivity(msg.arg1);
            //End case LISTEN_DATA_ACTIVITY 
            //Begin case LISTEN_SIGNAL_STRENGTHS 
            PhoneStateListener.this.onSignalStrengthsChanged((SignalStrength)msg.obj);
            //End case LISTEN_SIGNAL_STRENGTHS 
            //Begin case LISTEN_OTASP_CHANGED 
            PhoneStateListener.this.onOtaspChanged(msg.arg1);
            //End case LISTEN_OTASP_CHANGED 
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.538 -0400", hash_original_method = "20EF8DCC516BA3C0FC2B58EA0CC3EA6E", hash_generated_method = "D7C1BF839242BC9415BC61355D4D609D")
    @DSModeled(DSC.SAFE)
    public PhoneStateListener() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.539 -0400", hash_original_method = "71FF02CB37AAD9FA42E430343744C95D", hash_generated_method = "6A0CF956D9218994EB34FA93C46D1A0E")
    @DSModeled(DSC.SAFE)
    public void onServiceStateChanged(ServiceState serviceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(serviceState.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.539 -0400", hash_original_method = "BC041D78EED5B299AE554E075ADF39D8", hash_generated_method = "9602AF96DE358A9ADF5638F933C326EB")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void onSignalStrengthChanged(int asu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(asu);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.539 -0400", hash_original_method = "75359DDCF2D0B158439199FBAF05E06A", hash_generated_method = "409F4CBEDBE2CD810B639E632156FB77")
    @DSModeled(DSC.SAFE)
    public void onMessageWaitingIndicatorChanged(boolean mwi) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(mwi);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.539 -0400", hash_original_method = "D5A60C39C845CE2458AA9D81FF0C97F9", hash_generated_method = "D529BF6F418E252C4AA251B77BCD765F")
    @DSModeled(DSC.SAFE)
    public void onCallForwardingIndicatorChanged(boolean cfi) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(cfi);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.540 -0400", hash_original_method = "DC558EBD989E1315B12793B36376A79E", hash_generated_method = "C3CF56F4DAD19E9F5838271449398B40")
    @DSModeled(DSC.SAFE)
    public void onCellLocationChanged(CellLocation location) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(location.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.540 -0400", hash_original_method = "B1A721EFB2ABF6430D11EDB26008EF34", hash_generated_method = "B197A9A6AFA083DEAE46E92A756059D5")
    @DSModeled(DSC.SAFE)
    public void onCallStateChanged(int state, String incomingNumber) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(state);
        dsTaint.addTaint(incomingNumber);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.540 -0400", hash_original_method = "1C4CEBBE82C84ACE1203815C2B422383", hash_generated_method = "25DCEC2BD51D21D775DC04BBADD1259C")
    @DSModeled(DSC.SAFE)
    public void onDataConnectionStateChanged(int state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(state);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.540 -0400", hash_original_method = "BFD2027492A8CA27CCE6A852F5D0D4BF", hash_generated_method = "5CC72854BD6EBE56241703FF56E44DE6")
    @DSModeled(DSC.SAFE)
    public void onDataConnectionStateChanged(int state, int networkType) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(networkType);
        dsTaint.addTaint(state);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.541 -0400", hash_original_method = "F374B48EE0586B0F56A0A6BEC28E9201", hash_generated_method = "75FC8C6BA2317B18F1E760AF92DA0531")
    @DSModeled(DSC.SAFE)
    public void onDataActivity(int direction) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(direction);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.541 -0400", hash_original_method = "A22E0BB42B0E543666A17B7B6AC4EDC6", hash_generated_method = "86FB9BCA26D6CA0909A445393C949A1C")
    @DSModeled(DSC.SAFE)
    public void onSignalStrengthsChanged(SignalStrength signalStrength) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(signalStrength.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.541 -0400", hash_original_method = "AF1EBC6D8A2DA1E39265DEC2CD9D5FBB", hash_generated_method = "A6C37FA858BDA51D2A3D2311B5F69385")
    @DSModeled(DSC.SAFE)
    public void onOtaspChanged(int otaspMode) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(otaspMode);
        // ---------- Original Method ----------
    }

    
    public static final int LISTEN_NONE = 0;
    public static final int LISTEN_SERVICE_STATE                            = 0x00000001;
    @Deprecated public static final int LISTEN_SIGNAL_STRENGTH                          = 0x00000002;
    public static final int LISTEN_MESSAGE_WAITING_INDICATOR                = 0x00000004;
    public static final int LISTEN_CALL_FORWARDING_INDICATOR                = 0x00000008;
    public static final int LISTEN_CELL_LOCATION                            = 0x00000010;
    public static final int LISTEN_CALL_STATE                               = 0x00000020;
    public static final int LISTEN_DATA_CONNECTION_STATE                    = 0x00000040;
    public static final int LISTEN_DATA_ACTIVITY                            = 0x00000080;
    public static final int LISTEN_SIGNAL_STRENGTHS                         = 0x00000100;
    public static final int LISTEN_OTASP_CHANGED                            = 0x00000200;
}

