package android.media;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class ToneGenerator {
    public static final int TONE_DTMF_0 = 0;
    public static final int TONE_DTMF_1 = 1;
    public static final int TONE_DTMF_2 = 2;
    public static final int TONE_DTMF_3 = 3;
    public static final int TONE_DTMF_4 = 4;
    public static final int TONE_DTMF_5 = 5;
    public static final int TONE_DTMF_6 = 6;
    public static final int TONE_DTMF_7 = 7;
    public static final int TONE_DTMF_8 = 8;
    public static final int TONE_DTMF_9 = 9;
    public static final int TONE_DTMF_S = 10;
    public static final int TONE_DTMF_P = 11;
    public static final int TONE_DTMF_A = 12;
    public static final int TONE_DTMF_B = 13;
    public static final int TONE_DTMF_C = 14;
    public static final int TONE_DTMF_D = 15;
    public static final int TONE_SUP_DIAL = 16;
    public static final int TONE_SUP_BUSY = 17;
    public static final int TONE_SUP_CONGESTION = 18;
    public static final int TONE_SUP_RADIO_ACK = 19;
    public static final int TONE_SUP_RADIO_NOTAVAIL = 20;
    public static final int TONE_SUP_ERROR = 21;
    public static final int TONE_SUP_CALL_WAITING = 22;
    public static final int TONE_SUP_RINGTONE = 23;
    public static final int TONE_PROP_BEEP = 24;
    public static final int TONE_PROP_ACK = 25;
    public static final int TONE_PROP_NACK = 26;
    public static final int  TONE_PROP_PROMPT = 27;
    public static final int TONE_PROP_BEEP2 = 28;
    public static final int TONE_SUP_INTERCEPT = 29;
    public static final int TONE_SUP_INTERCEPT_ABBREV = 30;
    public static final int TONE_SUP_CONGESTION_ABBREV = 31;
    public static final int TONE_SUP_CONFIRM = 32;
    public static final int TONE_SUP_PIP = 33;
    public static final int TONE_CDMA_DIAL_TONE_LITE = 34;
    public static final int TONE_CDMA_NETWORK_USA_RINGBACK = 35;
    public static final int TONE_CDMA_INTERCEPT = 36;
    public static final int TONE_CDMA_ABBR_INTERCEPT = 37;
    public static final int TONE_CDMA_REORDER = 38;
    public static final int TONE_CDMA_ABBR_REORDER = 39;
    public static final int TONE_CDMA_NETWORK_BUSY = 40;
    public static final int TONE_CDMA_CONFIRM = 41;
    public static final int TONE_CDMA_ANSWER = 42;
    public static final int TONE_CDMA_NETWORK_CALLWAITING = 43;
    public static final int TONE_CDMA_PIP = 44;
    public static final int TONE_CDMA_CALL_SIGNAL_ISDN_NORMAL = 45;
    public static final int TONE_CDMA_CALL_SIGNAL_ISDN_INTERGROUP = 46;
    public static final int TONE_CDMA_CALL_SIGNAL_ISDN_SP_PRI = 47;
    public static final int TONE_CDMA_CALL_SIGNAL_ISDN_PAT3 = 48;
    public static final int TONE_CDMA_CALL_SIGNAL_ISDN_PING_RING = 49;
    public static final int TONE_CDMA_CALL_SIGNAL_ISDN_PAT5 = 50;
    public static final int TONE_CDMA_CALL_SIGNAL_ISDN_PAT6 = 51;
    public static final int TONE_CDMA_CALL_SIGNAL_ISDN_PAT7 = 52;
    public static final int TONE_CDMA_HIGH_L = 53;
    public static final int TONE_CDMA_MED_L = 54;
    public static final int TONE_CDMA_LOW_L = 55;
    public static final int TONE_CDMA_HIGH_SS = 56;
    public static final int TONE_CDMA_MED_SS = 57;
    public static final int TONE_CDMA_LOW_SS = 58;
    public static final int TONE_CDMA_HIGH_SSL = 59;
    public static final int TONE_CDMA_MED_SSL = 60;
    public static final int TONE_CDMA_LOW_SSL = 61;
    public static final int TONE_CDMA_HIGH_SS_2 = 62;
    public static final int TONE_CDMA_MED_SS_2 = 63;
    public static final int TONE_CDMA_LOW_SS_2 = 64;
    public static final int TONE_CDMA_HIGH_SLS = 65;
    public static final int TONE_CDMA_MED_SLS = 66;
    public static final int TONE_CDMA_LOW_SLS = 67;
    public static final int TONE_CDMA_HIGH_S_X4 = 68;
    public static final int TONE_CDMA_MED_S_X4 = 69;
    public static final int TONE_CDMA_LOW_S_X4 = 70;
    public static final int TONE_CDMA_HIGH_PBX_L = 71;
    public static final int TONE_CDMA_MED_PBX_L = 72;
    public static final int TONE_CDMA_LOW_PBX_L = 73;
    public static final int TONE_CDMA_HIGH_PBX_SS = 74;
    public static final int TONE_CDMA_MED_PBX_SS = 75;
    public static final int TONE_CDMA_LOW_PBX_SS = 76;
    public static final int TONE_CDMA_HIGH_PBX_SSL = 77;
    public static final int TONE_CDMA_MED_PBX_SSL = 78;
    public static final int TONE_CDMA_LOW_PBX_SSL = 79;
    public static final int TONE_CDMA_HIGH_PBX_SLS = 80;
    public static final int TONE_CDMA_MED_PBX_SLS = 81;
    public static final int TONE_CDMA_LOW_PBX_SLS = 82;
    public static final int TONE_CDMA_HIGH_PBX_S_X4 = 83;
    public static final int TONE_CDMA_MED_PBX_S_X4 = 84;
    public static final int TONE_CDMA_LOW_PBX_S_X4 = 85;
    public static final int    TONE_CDMA_ALERT_NETWORK_LITE = 86;
    public static final int    TONE_CDMA_ALERT_AUTOREDIAL_LITE = 87;
    public static final int    TONE_CDMA_ONE_MIN_BEEP = 88;
    public static final int    TONE_CDMA_KEYPAD_VOLUME_KEY_LITE = 89;
    public static final int    TONE_CDMA_PRESSHOLDKEY_LITE = 90;
    public static final int    TONE_CDMA_ALERT_INCALL_LITE = 91;
    public static final int    TONE_CDMA_EMERGENCY_RINGBACK = 92;
    public static final int    TONE_CDMA_ALERT_CALL_GUARD = 93;
    public static final int    TONE_CDMA_SOFT_ERROR_LITE = 94;
    public static final int    TONE_CDMA_CALLDROP_LITE = 95;
    public static final int    TONE_CDMA_NETWORK_BUSY_ONE_SHOT = 96;
    public static final int    TONE_CDMA_ABBR_ALERT = 97;
    public static final int TONE_CDMA_SIGNAL_OFF = 98;
    public static final int MAX_VOLUME = 100;
    public static final int MIN_VOLUME = 0;
    @SuppressWarnings("unused")
    private int mNativeContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.996 -0400", hash_original_method = "F456C830515CA57E64333B5502C7B0DC", hash_generated_method = "9467A965450D1808CE19658C1DABFB5D")
    @DSModeled(DSC.SAFE)
    public ToneGenerator(int streamType, int volume) {
        dsTaint.addTaint(streamType);
        dsTaint.addTaint(volume);
        native_setup(streamType, volume);
        // ---------- Original Method ----------
        //native_setup(streamType, volume);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.996 -0400", hash_original_method = "8EAA66237FD0D657A6089CD6D204D973", hash_generated_method = "9A5D16B61D6366DA87BDC2E18E773C65")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean startTone(int toneType) {
        dsTaint.addTaint(toneType);
        boolean var2E928CF4DD2D67A5CD8E69138D8B3E3E_403841826 = (startTone(toneType, -1));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return startTone(toneType, -1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.996 -0400", hash_original_method = "F753AB60830D7C8A33F2091CC5455863", hash_generated_method = "4599152C2405816A611C611A379DF32D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean startTone(int toneType, int durationMs) {
        dsTaint.addTaint(durationMs);
        dsTaint.addTaint(toneType);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.996 -0400", hash_original_method = "DE1F7EDB373D887510AEE90FFA73BFA3", hash_generated_method = "E200178D6BDF60B87EA19AD4B54E9C60")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void stopTone() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.996 -0400", hash_original_method = "1E8C38EACEA1E94FE658824D01FD2A18", hash_generated_method = "D2584A9F2F8C3801A0BB432618FEF48E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void release() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.997 -0400", hash_original_method = "097066EF57BB064C231D14FA51E98EB9", hash_generated_method = "4D6CD67973D7833EB8182876C31798FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final void native_setup(int streamType, int volume) {
        dsTaint.addTaint(streamType);
        dsTaint.addTaint(volume);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.997 -0400", hash_original_method = "B81676966F6941B90240D7A24C9E2FD3", hash_generated_method = "07892C9045EEFAC960AD527F85526543")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final void native_finalize() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.997 -0400", hash_original_method = "3228EA20CE4FEF9678E1F1862B5AB446", hash_generated_method = "2A5F99104A7626AF3A9C05307F5FED64")
    @DSModeled(DSC.SAFE)
    @Override
    protected void finalize() {
        native_finalize();
        // ---------- Original Method ----------
        //native_finalize();
    }

    
}


