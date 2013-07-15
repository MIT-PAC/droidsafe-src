package android.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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

        
        @DSModeled(DSC.SAFE)
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.931 -0400", hash_original_method = "20EF8DCC516BA3C0FC2B58EA0CC3EA6E", hash_generated_method = "D7C1BF839242BC9415BC61355D4D609D")
    public  PhoneStateListener() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.932 -0400", hash_original_method = "71FF02CB37AAD9FA42E430343744C95D", hash_generated_method = "2EDE1453352DA2CC85CC298DFB3AD551")
    public void onServiceStateChanged(ServiceState serviceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(serviceState.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.932 -0400", hash_original_method = "BC041D78EED5B299AE554E075ADF39D8", hash_generated_method = "CAA24713F8D0C0D31C4734D103475E49")
    @Deprecated
    public void onSignalStrengthChanged(int asu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(asu);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.932 -0400", hash_original_method = "75359DDCF2D0B158439199FBAF05E06A", hash_generated_method = "A0E000790569C0C318FE63F6F64EBC1C")
    public void onMessageWaitingIndicatorChanged(boolean mwi) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(mwi);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.932 -0400", hash_original_method = "D5A60C39C845CE2458AA9D81FF0C97F9", hash_generated_method = "EF33A9F2D8350F2C64273438D422888A")
    public void onCallForwardingIndicatorChanged(boolean cfi) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(cfi);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.932 -0400", hash_original_method = "DC558EBD989E1315B12793B36376A79E", hash_generated_method = "DD90CABC50B85CB7BBFA627CF56F9C7F")
    public void onCellLocationChanged(CellLocation location) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(location.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.932 -0400", hash_original_method = "B1A721EFB2ABF6430D11EDB26008EF34", hash_generated_method = "E7F9E21E50E7DE2EAAC1DC911C01A5EA")
    public void onCallStateChanged(int state, String incomingNumber) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(incomingNumber.getTaint());
        addTaint(state);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.932 -0400", hash_original_method = "1C4CEBBE82C84ACE1203815C2B422383", hash_generated_method = "9619C47A3336B5F864DDE0F2FC04754E")
    public void onDataConnectionStateChanged(int state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(state);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.932 -0400", hash_original_method = "BFD2027492A8CA27CCE6A852F5D0D4BF", hash_generated_method = "EFB040C320234AEBFEE6F620E299C9B7")
    public void onDataConnectionStateChanged(int state, int networkType) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(networkType);
        addTaint(state);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.932 -0400", hash_original_method = "F374B48EE0586B0F56A0A6BEC28E9201", hash_generated_method = "D3FF69ABDB90917CDA7D7150D27A23CC")
    public void onDataActivity(int direction) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(direction);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.933 -0400", hash_original_method = "A22E0BB42B0E543666A17B7B6AC4EDC6", hash_generated_method = "4E58CB508883B0A99DFC47209005250D")
    public void onSignalStrengthsChanged(SignalStrength signalStrength) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(signalStrength.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.933 -0400", hash_original_method = "AF1EBC6D8A2DA1E39265DEC2CD9D5FBB", hash_generated_method = "D71E5EE2F05952023B3DADF0BC31A241")
    public void onOtaspChanged(int otaspMode) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(otaspMode);
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.933 -0400", hash_original_field = "65513605A7876782BF214BA51D405DDF", hash_generated_field = "2668A1FA15452EF095AB309D80143EE2")

    public static final int LISTEN_NONE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.933 -0400", hash_original_field = "58866ACC120A420F53EBAEA0E548CED8", hash_generated_field = "EA9E1D843E5D2F2EE9DA84427F443A73")

    public static final int LISTEN_SERVICE_STATE                            = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.933 -0400", hash_original_field = "D1819298BAA9CA498662D79A3DBCF88D", hash_generated_field = "9BC789C2DC17C2E7F01200D42FB2EB97")

    @Deprecated
    public static final int LISTEN_SIGNAL_STRENGTH                          = 0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.933 -0400", hash_original_field = "D0EE56F4A846615BA39FAF77ADF909E1", hash_generated_field = "079948D5A4839C139ABA266A60E8C43C")

    public static final int LISTEN_MESSAGE_WAITING_INDICATOR                = 0x00000004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.933 -0400", hash_original_field = "C967547E9CBAD5A6BDA8A51BA31AD031", hash_generated_field = "2C407633607152A9A58FA3E2F3D251BB")

    public static final int LISTEN_CALL_FORWARDING_INDICATOR                = 0x00000008;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.933 -0400", hash_original_field = "BF369976C1837285709872EEEBCC54A8", hash_generated_field = "F17C79B6214A465ED14A618D91A65DF0")

    public static final int LISTEN_CELL_LOCATION                            = 0x00000010;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.933 -0400", hash_original_field = "E0B2231B5C408A791B1C96A2A8B21075", hash_generated_field = "D3BB80D3E20C59C05E5F09DD4A108121")

    public static final int LISTEN_CALL_STATE                               = 0x00000020;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.933 -0400", hash_original_field = "80C8E6D6B78C6EC46A655B02BC193121", hash_generated_field = "A053609FFB1B37F86F11B4AAF5456228")

    public static final int LISTEN_DATA_CONNECTION_STATE                    = 0x00000040;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.933 -0400", hash_original_field = "2BE5F895AF9C950BF947248377CB3610", hash_generated_field = "BDF733827267C32D8D3126F1C48BBB7A")

    public static final int LISTEN_DATA_ACTIVITY                            = 0x00000080;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.933 -0400", hash_original_field = "C70951CC015509B3952FBA56DF732394", hash_generated_field = "02B62E9690B51D18532269564CEA0526")

    public static final int LISTEN_SIGNAL_STRENGTHS                         = 0x00000100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.933 -0400", hash_original_field = "A12D6119D3C2262352EE09AB8810F7DB", hash_generated_field = "89E2C5A9EA4D2DDF310DBED68B5CBDAB")

    public static final int LISTEN_OTASP_CHANGED                            = 0x00000200;
}

