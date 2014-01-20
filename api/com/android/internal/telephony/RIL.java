package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import static android.telephony.TelephonyManager.NETWORK_TYPE_EDGE;
import static android.telephony.TelephonyManager.NETWORK_TYPE_GPRS;
import static android.telephony.TelephonyManager.NETWORK_TYPE_HSDPA;
import static android.telephony.TelephonyManager.NETWORK_TYPE_HSPA;
import static android.telephony.TelephonyManager.NETWORK_TYPE_HSUPA;
import static android.telephony.TelephonyManager.NETWORK_TYPE_UMTS;
import static android.telephony.TelephonyManager.NETWORK_TYPE_UNKNOWN;
import static com.android.internal.telephony.RILConstants.*;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import android.os.AsyncResult;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.SystemProperties;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneNumberUtils;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.text.TextUtils;
import android.util.Log;

import com.android.internal.telephony.cdma.CdmaCallWaitingNotification;
import com.android.internal.telephony.cdma.CdmaInformationRecords;
import com.android.internal.telephony.gsm.SmsBroadcastConfigInfo;
import com.android.internal.telephony.gsm.SuppServiceNotification;

class RILRequest {

    /**
     * Retrieves a new RILRequest instance from the pool.
     *
     * @param request RIL_REQUEST_*
     * @param result sent when operation completes
     * @return a RILRequest instance from the pool.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.037 -0500", hash_original_method = "6A7FA32ED0AD9506923594ED32C4601A", hash_generated_method = "A7F67091EA6B158F41DE9930ED9770EF")
    
static RILRequest obtain(int request, Message result) {
        RILRequest rr = null;

        synchronized(sPoolSync) {
            if (sPool != null) {
                rr = sPool;
                sPool = rr.mNext;
                rr.mNext = null;
                sPoolSize--;
            }
        }

        if (rr == null) {
            rr = new RILRequest();
        }

        synchronized(sSerialMonitor) {
            rr.mSerial = sNextSerial++;
        }
        rr.mRequest = request;
        rr.mResult = result;
        rr.mp = Parcel.obtain();

        if (result != null && result.getTarget() == null) {
            throw new NullPointerException("Message target must not be null");
        }

        // first elements in any RIL Parcel
        rr.mp.writeInt(request);
        rr.mp.writeInt(rr.mSerial);

        return rr;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.045 -0500", hash_original_method = "090F8DC2C2098B0DB717AD347DCE04D3", hash_generated_method = "AD20F5051567213539C070678E314170")
    
static void
    resetSerial() {
        synchronized(sSerialMonitor) {
            sNextSerial = 0;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.010 -0500", hash_original_field = "5DB06ACB907164DDFD56CB65AEF4A643", hash_generated_field = "21AA8117BA78E2A6B7853733E283EBA4")

    static final String LOG_TAG = "RILJ";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.012 -0500", hash_original_field = "D3306DFE5B4A0ABFAD51D71C18B9CF84", hash_generated_field = "4648C36C9B39D123F3C2DC203738A8FE")

    static int sNextSerial = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.015 -0500", hash_original_field = "79EAD435D05FFA812BC1F9BA764B9F2B", hash_generated_field = "A7E278FEB1EC2BFEA3ED505503B40F1D")

    static Object sSerialMonitor = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.017 -0500", hash_original_field = "FF70C662CB92BB1987F6CF4637424D6E", hash_generated_field = "8885194D9D2ADA6648AB65C43BA7A18A")

    private static Object sPoolSync = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.019 -0500", hash_original_field = "EAD385387EEE4256509C93E26B7757D8", hash_generated_field = "29AEB546B72810AE137F2724EB8AC46F")

    private static RILRequest sPool = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.021 -0500", hash_original_field = "58C64529682BFD4E11D662842F129355", hash_generated_field = "A60993B78066ACEFAC0F4A6F4AB10BB4")

    private static int sPoolSize = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.024 -0500", hash_original_field = "97C7BDD81D087D5FA5CE96AB2991A5FB", hash_generated_field = "E10F8FF6B26141CA5E230C0B750B2798")

    private static final int MAX_POOL_SIZE = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.026 -0500", hash_original_field = "2C995DC68A290AA0E91A0F8065297DF6", hash_generated_field = "2C995DC68A290AA0E91A0F8065297DF6")

    int mSerial;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.028 -0500", hash_original_field = "6C368ED9CE82768FD0B5A0D34D844F82", hash_generated_field = "6C368ED9CE82768FD0B5A0D34D844F82")

    int mRequest;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.030 -0500", hash_original_field = "275BCCDB24FCA985A62252086534EA41", hash_generated_field = "275BCCDB24FCA985A62252086534EA41")

    Message mResult;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.032 -0500", hash_original_field = "EEF79C3D9374B5C2140B6DF15C81B0D3", hash_generated_field = "EEF79C3D9374B5C2140B6DF15C81B0D3")

    Parcel mp;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.034 -0500", hash_original_field = "64C9DCC5A15FF3A81952EE0FF77BF4DE", hash_generated_field = "64C9DCC5A15FF3A81952EE0FF77BF4DE")

    RILRequest mNext;

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.042 -0500", hash_original_method = "9C4E8F6E2A10EF2C06F20638ED2CBC6D", hash_generated_method = "9161999B880C7E10C983CA44E7AAFCBF")
    
private RILRequest() {
    }

    /**
     * Returns a RILRequest instance to the pool.
     *
     * Note: This should only be called once per use.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.039 -0500", hash_original_method = "E7EE736E24A2BE53AC107C249FFB0880", hash_generated_method = "E7EE736E24A2BE53AC107C249FFB0880")
    
void release() {
        synchronized (sPoolSync) {
            if (sPoolSize < MAX_POOL_SIZE) {
                this.mNext = sPool;
                sPool = this;
                sPoolSize++;
                mResult = null;
            }
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.047 -0500", hash_original_method = "9C13ECBB4C9B57CD7FC06025C6091C8F", hash_generated_method = "FDAAF67AB401FFBE9EE7FECBE302FD4B")
    
String
    serialString() {
        //Cheesy way to do %04d
        StringBuilder sb = new StringBuilder(8);
        String sn;

        sn = Integer.toString(mSerial);

        //sb.append("J[");
        sb.append('[');
        for (int i = 0, s = sn.length() ; i < 4 - s; i++) {
            sb.append('0');
        }

        sb.append(sn);
        sb.append(']');
        return sb.toString();
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.049 -0500", hash_original_method = "DAF6125A6A3BAA8EA4AAF17920DB80E6", hash_generated_method = "DAF6125A6A3BAA8EA4AAF17920DB80E6")
    
void
    onError(int error, Object ret) {
        CommandException ex;

        ex = CommandException.fromRilErrno(error);

        if (RIL.RILJ_LOGD) Log.d(LOG_TAG, serialString() + "< "
            + RIL.requestToString(mRequest)
            + " error: " + ex);

        if (mResult != null) {
            AsyncResult.forMessage(mResult, ret, ex);
            mResult.sendToTarget();
        }

        if (mp != null) {
            mp.recycle();
            mp = null;
        }
    }
}

public final class RIL extends BaseCommands implements CommandsInterface {

    /**
     * Reads in a single RIL message off the wire. A RIL message consists
     * of a 4-byte little-endian length and a subsequent series of bytes.
     * The final message (length header omitted) is read into
     * <code>buffer</code> and the length of the final message (less header)
     * is returned. A return value of -1 indicates end-of-stream.
     *
     * @param is non-null; Stream to read from
     * @param buffer Buffer to fill in. Must be as large as maximum
     * message size, or an ArrayOutOfBounds exception will be thrown.
     * @return Length of message less header, or -1 on end of stream.
     * @throws IOException
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.133 -0500", hash_original_method = "276911B1F31C12ADE55317E1DBA28A10", hash_generated_method = "CB85081F1CD1198E5F33E7DDF76DB880")
    
private static int readRilMessage(InputStream is, byte[] buffer)
            throws IOException {
        int countRead;
        int offset;
        int remaining;
        int messageLength;

        // First, read in the length of the message
        offset = 0;
        remaining = 4;
        do {
            countRead = is.read(buffer, offset, remaining);

            if (countRead < 0 ) {
                Log.e(LOG_TAG, "Hit EOS reading message length");
                return -1;
            }

            offset += countRead;
            remaining -= countRead;
        } while (remaining > 0);

        messageLength = ((buffer[0] & 0xff) << 24)
                | ((buffer[1] & 0xff) << 16)
                | ((buffer[2] & 0xff) << 8)
                | (buffer[3] & 0xff);

        // Then, re-use the buffer and read in the message itself
        offset = 0;
        remaining = messageLength;
        do {
            countRead = is.read(buffer, offset, remaining);

            if (countRead < 0 ) {
                Log.e(LOG_TAG, "Hit EOS reading message.  messageLength=" + messageLength
                        + " remaining=" + remaining);
                return -1;
            }

            offset += countRead;
            remaining -= countRead;
        } while (remaining > 0);

        return messageLength;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.520 -0500", hash_original_method = "A6BE0A2E0E75DCD61AF717228F0C001C", hash_generated_method = "A36B10338A6834F66F5F4B915A83374D")
    
static String
    requestToString(int request) {
/*
 cat libs/telephony/ril_commands.h \
 | egrep "^ *{RIL_" \
 | sed -re 's/\{RIL_([^,]+),[^,]+,([^}]+).+/case RIL_\1: return "\1";/'
*/
        switch(request) {
            case RIL_REQUEST_GET_SIM_STATUS: return "GET_SIM_STATUS";
            case RIL_REQUEST_ENTER_SIM_PIN: return "ENTER_SIM_PIN";
            case RIL_REQUEST_ENTER_SIM_PUK: return "ENTER_SIM_PUK";
            case RIL_REQUEST_ENTER_SIM_PIN2: return "ENTER_SIM_PIN2";
            case RIL_REQUEST_ENTER_SIM_PUK2: return "ENTER_SIM_PUK2";
            case RIL_REQUEST_CHANGE_SIM_PIN: return "CHANGE_SIM_PIN";
            case RIL_REQUEST_CHANGE_SIM_PIN2: return "CHANGE_SIM_PIN2";
            case RIL_REQUEST_ENTER_NETWORK_DEPERSONALIZATION: return "ENTER_NETWORK_DEPERSONALIZATION";
            case RIL_REQUEST_GET_CURRENT_CALLS: return "GET_CURRENT_CALLS";
            case RIL_REQUEST_DIAL: return "DIAL";
            case RIL_REQUEST_GET_IMSI: return "GET_IMSI";
            case RIL_REQUEST_HANGUP: return "HANGUP";
            case RIL_REQUEST_HANGUP_WAITING_OR_BACKGROUND: return "HANGUP_WAITING_OR_BACKGROUND";
            case RIL_REQUEST_HANGUP_FOREGROUND_RESUME_BACKGROUND: return "HANGUP_FOREGROUND_RESUME_BACKGROUND";
            case RIL_REQUEST_SWITCH_WAITING_OR_HOLDING_AND_ACTIVE: return "REQUEST_SWITCH_WAITING_OR_HOLDING_AND_ACTIVE";
            case RIL_REQUEST_CONFERENCE: return "CONFERENCE";
            case RIL_REQUEST_UDUB: return "UDUB";
            case RIL_REQUEST_LAST_CALL_FAIL_CAUSE: return "LAST_CALL_FAIL_CAUSE";
            case RIL_REQUEST_SIGNAL_STRENGTH: return "SIGNAL_STRENGTH";
            case RIL_REQUEST_VOICE_REGISTRATION_STATE: return "VOICE_REGISTRATION_STATE";
            case RIL_REQUEST_DATA_REGISTRATION_STATE: return "DATA_REGISTRATION_STATE";
            case RIL_REQUEST_OPERATOR: return "OPERATOR";
            case RIL_REQUEST_RADIO_POWER: return "RADIO_POWER";
            case RIL_REQUEST_DTMF: return "DTMF";
            case RIL_REQUEST_SEND_SMS: return "SEND_SMS";
            case RIL_REQUEST_SEND_SMS_EXPECT_MORE: return "SEND_SMS_EXPECT_MORE";
            case RIL_REQUEST_SETUP_DATA_CALL: return "SETUP_DATA_CALL";
            case RIL_REQUEST_SIM_IO: return "SIM_IO";
            case RIL_REQUEST_SEND_USSD: return "SEND_USSD";
            case RIL_REQUEST_CANCEL_USSD: return "CANCEL_USSD";
            case RIL_REQUEST_GET_CLIR: return "GET_CLIR";
            case RIL_REQUEST_SET_CLIR: return "SET_CLIR";
            case RIL_REQUEST_QUERY_CALL_FORWARD_STATUS: return "QUERY_CALL_FORWARD_STATUS";
            case RIL_REQUEST_SET_CALL_FORWARD: return "SET_CALL_FORWARD";
            case RIL_REQUEST_QUERY_CALL_WAITING: return "QUERY_CALL_WAITING";
            case RIL_REQUEST_SET_CALL_WAITING: return "SET_CALL_WAITING";
            case RIL_REQUEST_SMS_ACKNOWLEDGE: return "SMS_ACKNOWLEDGE";
            case RIL_REQUEST_GET_IMEI: return "GET_IMEI";
            case RIL_REQUEST_GET_IMEISV: return "GET_IMEISV";
            case RIL_REQUEST_ANSWER: return "ANSWER";
            case RIL_REQUEST_DEACTIVATE_DATA_CALL: return "DEACTIVATE_DATA_CALL";
            case RIL_REQUEST_QUERY_FACILITY_LOCK: return "QUERY_FACILITY_LOCK";
            case RIL_REQUEST_SET_FACILITY_LOCK: return "SET_FACILITY_LOCK";
            case RIL_REQUEST_CHANGE_BARRING_PASSWORD: return "CHANGE_BARRING_PASSWORD";
            case RIL_REQUEST_QUERY_NETWORK_SELECTION_MODE: return "QUERY_NETWORK_SELECTION_MODE";
            case RIL_REQUEST_SET_NETWORK_SELECTION_AUTOMATIC: return "SET_NETWORK_SELECTION_AUTOMATIC";
            case RIL_REQUEST_SET_NETWORK_SELECTION_MANUAL: return "SET_NETWORK_SELECTION_MANUAL";
            case RIL_REQUEST_QUERY_AVAILABLE_NETWORKS : return "QUERY_AVAILABLE_NETWORKS ";
            case RIL_REQUEST_DTMF_START: return "DTMF_START";
            case RIL_REQUEST_DTMF_STOP: return "DTMF_STOP";
            case RIL_REQUEST_BASEBAND_VERSION: return "BASEBAND_VERSION";
            case RIL_REQUEST_SEPARATE_CONNECTION: return "SEPARATE_CONNECTION";
            case RIL_REQUEST_SET_MUTE: return "SET_MUTE";
            case RIL_REQUEST_GET_MUTE: return "GET_MUTE";
            case RIL_REQUEST_QUERY_CLIP: return "QUERY_CLIP";
            case RIL_REQUEST_LAST_DATA_CALL_FAIL_CAUSE: return "LAST_DATA_CALL_FAIL_CAUSE";
            case RIL_REQUEST_DATA_CALL_LIST: return "DATA_CALL_LIST";
            case RIL_REQUEST_RESET_RADIO: return "RESET_RADIO";
            case RIL_REQUEST_OEM_HOOK_RAW: return "OEM_HOOK_RAW";
            case RIL_REQUEST_OEM_HOOK_STRINGS: return "OEM_HOOK_STRINGS";
            case RIL_REQUEST_SCREEN_STATE: return "SCREEN_STATE";
            case RIL_REQUEST_SET_SUPP_SVC_NOTIFICATION: return "SET_SUPP_SVC_NOTIFICATION";
            case RIL_REQUEST_WRITE_SMS_TO_SIM: return "WRITE_SMS_TO_SIM";
            case RIL_REQUEST_DELETE_SMS_ON_SIM: return "DELETE_SMS_ON_SIM";
            case RIL_REQUEST_SET_BAND_MODE: return "SET_BAND_MODE";
            case RIL_REQUEST_QUERY_AVAILABLE_BAND_MODE: return "QUERY_AVAILABLE_BAND_MODE";
            case RIL_REQUEST_STK_GET_PROFILE: return "REQUEST_STK_GET_PROFILE";
            case RIL_REQUEST_STK_SET_PROFILE: return "REQUEST_STK_SET_PROFILE";
            case RIL_REQUEST_STK_SEND_ENVELOPE_COMMAND: return "REQUEST_STK_SEND_ENVELOPE_COMMAND";
            case RIL_REQUEST_STK_SEND_TERMINAL_RESPONSE: return "REQUEST_STK_SEND_TERMINAL_RESPONSE";
            case RIL_REQUEST_STK_HANDLE_CALL_SETUP_REQUESTED_FROM_SIM: return "REQUEST_STK_HANDLE_CALL_SETUP_REQUESTED_FROM_SIM";
            case RIL_REQUEST_EXPLICIT_CALL_TRANSFER: return "REQUEST_EXPLICIT_CALL_TRANSFER";
            case RIL_REQUEST_SET_PREFERRED_NETWORK_TYPE: return "REQUEST_SET_PREFERRED_NETWORK_TYPE";
            case RIL_REQUEST_GET_PREFERRED_NETWORK_TYPE: return "REQUEST_GET_PREFERRED_NETWORK_TYPE";
            case RIL_REQUEST_GET_NEIGHBORING_CELL_IDS: return "REQUEST_GET_NEIGHBORING_CELL_IDS";
            case RIL_REQUEST_SET_LOCATION_UPDATES: return "REQUEST_SET_LOCATION_UPDATES";
            case RIL_REQUEST_CDMA_SET_SUBSCRIPTION_SOURCE: return "RIL_REQUEST_CDMA_SET_SUBSCRIPTION_SOURCE";
            case RIL_REQUEST_CDMA_SET_ROAMING_PREFERENCE: return "RIL_REQUEST_CDMA_SET_ROAMING_PREFERENCE";
            case RIL_REQUEST_CDMA_QUERY_ROAMING_PREFERENCE: return "RIL_REQUEST_CDMA_QUERY_ROAMING_PREFERENCE";
            case RIL_REQUEST_SET_TTY_MODE: return "RIL_REQUEST_SET_TTY_MODE";
            case RIL_REQUEST_QUERY_TTY_MODE: return "RIL_REQUEST_QUERY_TTY_MODE";
            case RIL_REQUEST_CDMA_SET_PREFERRED_VOICE_PRIVACY_MODE: return "RIL_REQUEST_CDMA_SET_PREFERRED_VOICE_PRIVACY_MODE";
            case RIL_REQUEST_CDMA_QUERY_PREFERRED_VOICE_PRIVACY_MODE: return "RIL_REQUEST_CDMA_QUERY_PREFERRED_VOICE_PRIVACY_MODE";
            case RIL_REQUEST_CDMA_FLASH: return "RIL_REQUEST_CDMA_FLASH";
            case RIL_REQUEST_CDMA_BURST_DTMF: return "RIL_REQUEST_CDMA_BURST_DTMF";
            case RIL_REQUEST_CDMA_SEND_SMS: return "RIL_REQUEST_CDMA_SEND_SMS";
            case RIL_REQUEST_CDMA_SMS_ACKNOWLEDGE: return "RIL_REQUEST_CDMA_SMS_ACKNOWLEDGE";
            case RIL_REQUEST_GSM_GET_BROADCAST_CONFIG: return "RIL_REQUEST_GSM_GET_BROADCAST_CONFIG";
            case RIL_REQUEST_GSM_SET_BROADCAST_CONFIG: return "RIL_REQUEST_GSM_SET_BROADCAST_CONFIG";
            case RIL_REQUEST_CDMA_GET_BROADCAST_CONFIG: return "RIL_REQUEST_CDMA_GET_BROADCAST_CONFIG";
            case RIL_REQUEST_CDMA_SET_BROADCAST_CONFIG: return "RIL_REQUEST_CDMA_SET_BROADCAST_CONFIG";
            case RIL_REQUEST_GSM_BROADCAST_ACTIVATION: return "RIL_REQUEST_GSM_BROADCAST_ACTIVATION";
            case RIL_REQUEST_CDMA_VALIDATE_AND_WRITE_AKEY: return "RIL_REQUEST_CDMA_VALIDATE_AND_WRITE_AKEY";
            case RIL_REQUEST_CDMA_BROADCAST_ACTIVATION: return "RIL_REQUEST_CDMA_BROADCAST_ACTIVATION";
            case RIL_REQUEST_CDMA_SUBSCRIPTION: return "RIL_REQUEST_CDMA_SUBSCRIPTION";
            case RIL_REQUEST_CDMA_WRITE_SMS_TO_RUIM: return "RIL_REQUEST_CDMA_WRITE_SMS_TO_RUIM";
            case RIL_REQUEST_CDMA_DELETE_SMS_ON_RUIM: return "RIL_REQUEST_CDMA_DELETE_SMS_ON_RUIM";
            case RIL_REQUEST_DEVICE_IDENTITY: return "RIL_REQUEST_DEVICE_IDENTITY";
            case RIL_REQUEST_GET_SMSC_ADDRESS: return "RIL_REQUEST_GET_SMSC_ADDRESS";
            case RIL_REQUEST_SET_SMSC_ADDRESS: return "RIL_REQUEST_SET_SMSC_ADDRESS";
            case RIL_REQUEST_EXIT_EMERGENCY_CALLBACK_MODE: return "REQUEST_EXIT_EMERGENCY_CALLBACK_MODE";
            case RIL_REQUEST_REPORT_SMS_MEMORY_STATUS: return "RIL_REQUEST_REPORT_SMS_MEMORY_STATUS";
            case RIL_REQUEST_REPORT_STK_SERVICE_IS_RUNNING: return "RIL_REQUEST_REPORT_STK_SERVICE_IS_RUNNING";
            case RIL_REQUEST_CDMA_GET_SUBSCRIPTION_SOURCE: return "RIL_REQUEST_CDMA_GET_SUBSCRIPTION_SOURCE";
            case RIL_REQUEST_ISIM_AUTHENTICATION: return "RIL_REQUEST_ISIM_AUTHENTICATION";
            case RIL_REQUEST_ACKNOWLEDGE_INCOMING_GSM_SMS_WITH_PDU: return "RIL_REQUEST_ACKNOWLEDGE_INCOMING_GSM_SMS_WITH_PDU";
            case RIL_REQUEST_STK_SEND_ENVELOPE_WITH_STATUS: return "RIL_REQUEST_STK_SEND_ENVELOPE_WITH_STATUS";
            default: return "<unknown request>";
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.524 -0500", hash_original_method = "D2B90A548E62E677ED47B4C8A846A41D", hash_generated_method = "1972C5F5D69CCA9A4C3A8EC2103BBBB8")
    
static String
    responseToString(int request)
    {
/*
 cat libs/telephony/ril_unsol_commands.h \
 | egrep "^ *{RIL_" \
 | sed -re 's/\{RIL_([^,]+),[^,]+,([^}]+).+/case RIL_\1: return "\1";/'
*/
        switch(request) {
            case RIL_UNSOL_RESPONSE_RADIO_STATE_CHANGED: return "UNSOL_RESPONSE_RADIO_STATE_CHANGED";
            case RIL_UNSOL_RESPONSE_CALL_STATE_CHANGED: return "UNSOL_RESPONSE_CALL_STATE_CHANGED";
            case RIL_UNSOL_RESPONSE_VOICE_NETWORK_STATE_CHANGED: return "UNSOL_RESPONSE_VOICE_NETWORK_STATE_CHANGED";
            case RIL_UNSOL_RESPONSE_NEW_SMS: return "UNSOL_RESPONSE_NEW_SMS";
            case RIL_UNSOL_RESPONSE_NEW_SMS_STATUS_REPORT: return "UNSOL_RESPONSE_NEW_SMS_STATUS_REPORT";
            case RIL_UNSOL_RESPONSE_NEW_SMS_ON_SIM: return "UNSOL_RESPONSE_NEW_SMS_ON_SIM";
            case RIL_UNSOL_ON_USSD: return "UNSOL_ON_USSD";
            case RIL_UNSOL_ON_USSD_REQUEST: return "UNSOL_ON_USSD_REQUEST";
            case RIL_UNSOL_NITZ_TIME_RECEIVED: return "UNSOL_NITZ_TIME_RECEIVED";
            case RIL_UNSOL_SIGNAL_STRENGTH: return "UNSOL_SIGNAL_STRENGTH";
            case RIL_UNSOL_DATA_CALL_LIST_CHANGED: return "UNSOL_DATA_CALL_LIST_CHANGED";
            case RIL_UNSOL_SUPP_SVC_NOTIFICATION: return "UNSOL_SUPP_SVC_NOTIFICATION";
            case RIL_UNSOL_STK_SESSION_END: return "UNSOL_STK_SESSION_END";
            case RIL_UNSOL_STK_PROACTIVE_COMMAND: return "UNSOL_STK_PROACTIVE_COMMAND";
            case RIL_UNSOL_STK_EVENT_NOTIFY: return "UNSOL_STK_EVENT_NOTIFY";
            case RIL_UNSOL_STK_CALL_SETUP: return "UNSOL_STK_CALL_SETUP";
            case RIL_UNSOL_SIM_SMS_STORAGE_FULL: return "UNSOL_SIM_SMS_STORAGE_FULL";
            case RIL_UNSOL_SIM_REFRESH: return "UNSOL_SIM_REFRESH";
            case RIL_UNSOL_CALL_RING: return "UNSOL_CALL_RING";
            case RIL_UNSOL_RESPONSE_SIM_STATUS_CHANGED: return "UNSOL_RESPONSE_SIM_STATUS_CHANGED";
            case RIL_UNSOL_RESPONSE_CDMA_NEW_SMS: return "UNSOL_RESPONSE_CDMA_NEW_SMS";
            case RIL_UNSOL_RESPONSE_NEW_BROADCAST_SMS: return "UNSOL_RESPONSE_NEW_BROADCAST_SMS";
            case RIL_UNSOL_CDMA_RUIM_SMS_STORAGE_FULL: return "UNSOL_CDMA_RUIM_SMS_STORAGE_FULL";
            case RIL_UNSOL_RESTRICTED_STATE_CHANGED: return "UNSOL_RESTRICTED_STATE_CHANGED";
            case RIL_UNSOL_ENTER_EMERGENCY_CALLBACK_MODE: return "UNSOL_ENTER_EMERGENCY_CALLBACK_MODE";
            case RIL_UNSOL_CDMA_CALL_WAITING: return "UNSOL_CDMA_CALL_WAITING";
            case RIL_UNSOL_CDMA_OTA_PROVISION_STATUS: return "UNSOL_CDMA_OTA_PROVISION_STATUS";
            case RIL_UNSOL_CDMA_INFO_REC: return "UNSOL_CDMA_INFO_REC";
            case RIL_UNSOL_OEM_HOOK_RAW: return "UNSOL_OEM_HOOK_RAW";
            case RIL_UNSOL_RINGBACK_TONE: return "UNSOL_RINGBACK_TONG";
            case RIL_UNSOL_RESEND_INCALL_MUTE: return "UNSOL_RESEND_INCALL_MUTE";
            case RIL_UNSOL_CDMA_SUBSCRIPTION_SOURCE_CHANGED: return "CDMA_SUBSCRIPTION_SOURCE_CHANGED";
            case RIL_UNSOl_CDMA_PRL_CHANGED: return "UNSOL_CDMA_PRL_CHANGED";
            case RIL_UNSOL_EXIT_EMERGENCY_CALLBACK_MODE: return "UNSOL_EXIT_EMERGENCY_CALLBACK_MODE";
            case RIL_UNSOL_RIL_CONNECTED: return "UNSOL_RIL_CONNECTED";
            default: return "<unknown reponse>";
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.056 -0500", hash_original_field = "5DB06ACB907164DDFD56CB65AEF4A643", hash_generated_field = "21AA8117BA78E2A6B7853733E283EBA4")

    static final String LOG_TAG = "RILJ";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.058 -0500", hash_original_field = "2224FD0C8B94519C5DA953BCAE383B64", hash_generated_field = "E8AEBB7BC1E8DE7102DD065D634CC293")

    static final boolean RILJ_LOGD = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.061 -0500", hash_original_field = "A9764A09E8D58C6EAA25BCAF58113079", hash_generated_field = "0C6948A169D6E1D2E1ADEB0F80785D40")

    static final boolean RILJ_LOGV = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.063 -0500", hash_original_field = "4214191B75EC7610CB78A60A83ABB237", hash_generated_field = "2A5370CA35CD21108F4ED0D2665FA27C")

    /**
     * Wake lock timeout should be longer than the longest timeout in
     * the vendor ril.
     */
    private static final int DEFAULT_WAKE_LOCK_TIMEOUT = 60000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.089 -0500", hash_original_field = "F1DEE3A771D3E3CFF213C021D2728FB5", hash_generated_field = "EAFA57C607FF50983754A1B1A1DB0736")

    static final int EVENT_SEND                 = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.092 -0500", hash_original_field = "6E7DCBFDBC7E8D011B39730FA3200D48", hash_generated_field = "6A179A477F6E9E6E9040DC18977E01CB")

    static final int EVENT_WAKE_LOCK_TIMEOUT    = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.094 -0500", hash_original_field = "DDB9DBAE4150B6B7D23DA2AFBFDE0205", hash_generated_field = "C9C6661CA6015E3437D26DDF8A3F4C47")

    // match with constant in ril.cpp
    static final int RIL_MAX_COMMAND_BYTES = (8 * 1024);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.097 -0500", hash_original_field = "771CD4999349A71CCF74C56975058AF4", hash_generated_field = "7A9920177945AAD6E3BDD930CB1D5FDA")

    static final int RESPONSE_SOLICITED = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.099 -0500", hash_original_field = "C3C1AC8D4B2CE02A384A0B3F6DF62E2A", hash_generated_field = "F7189327FBCA5256349AE6998692EE59")

    static final int RESPONSE_UNSOLICITED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.101 -0500", hash_original_field = "99FCBA019863F85C570EF386F45BF3C5", hash_generated_field = "66495E17EC0A0057CA4BC33F77ACB85F")

    static final String SOCKET_NAME_RIL = "rild";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.103 -0500", hash_original_field = "34C5F94ABB1E632304D783A0CE1FE12B", hash_generated_field = "0C3577BF4F60D2979C4EC6F1261A00D0")

    static final int SOCKET_OPEN_RETRY_MILLIS = 4 * 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.106 -0500", hash_original_field = "EA5E9D4D9E25D1C3C36F8DE3FFA2BA27", hash_generated_field = "2AAB4923DC15ECFCD362A5FDA717AEC9")

    // RIL_CDMA_BroadcastServiceInfo
    private static final int CDMA_BSI_NO_OF_INTS_STRUCT = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.109 -0500", hash_original_field = "25AC31352BAE9D9A7F24629E960EE07E", hash_generated_field = "8AC0B7212834068F171EE2AA5B80B5F8")

    private static final int CDMA_BROADCAST_SMS_NO_OF_SERVICE_CATEGORIES = 31;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.065 -0500", hash_original_field = "6971E2A0D3E5B2508308ACDF0894CC71", hash_generated_field = "6971E2A0D3E5B2508308ACDF0894CC71")

    LocalSocket mSocket;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.067 -0500", hash_original_field = "447BDB484814847833708DAC5CD0741B", hash_generated_field = "447BDB484814847833708DAC5CD0741B")

    HandlerThread mSenderThread;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.069 -0500", hash_original_field = "F824B77C4D08BC410F85653F55DB5D17", hash_generated_field = "F824B77C4D08BC410F85653F55DB5D17")

    RILSender mSender;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.071 -0500", hash_original_field = "4C5A8172CA27A059D229944DFD840114", hash_generated_field = "4C5A8172CA27A059D229944DFD840114")

    Thread mReceiverThread;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.073 -0500", hash_original_field = "B718778FEA0061AFBE714CC16C50488E", hash_generated_field = "B718778FEA0061AFBE714CC16C50488E")

    RILReceiver mReceiver;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.076 -0500", hash_original_field = "33E56F28B2B8FE4608887A854590880D", hash_generated_field = "33E56F28B2B8FE4608887A854590880D")

    WakeLock mWakeLock;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.078 -0500", hash_original_field = "102A8E8B4FA31B396B477F22D2A32DA8", hash_generated_field = "102A8E8B4FA31B396B477F22D2A32DA8")

    int mWakeLockTimeout;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.080 -0500", hash_original_field = "9200B1A2FDF04FDBA9EA6DB75F97F5C2", hash_generated_field = "AD7C5BAFD48BFFF8105D8322194E4C27")

    // EVENT_SEND and decreases while handling EVENT_SEND. It gets cleared while
    // WAKE_LOCK_TIMEOUT occurs.
    int mRequestMessagesPending;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.082 -0500", hash_original_field = "2A0F03062FAF4047F837E853AF898D37", hash_generated_field = "F8BC55AA6D7D115FF68A75EB43C66CCF")

    // sending request and decreases while handling response. It should match
    // mRequestList.size() unless there are requests no replied while
    // WAKE_LOCK_TIMEOUT occurs.
    int mRequestMessagesWaiting;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.084 -0500", hash_original_field = "A8E052F302542BDDE893942D71524913", hash_generated_field = "A8E052F302542BDDE893942D71524913")

    ArrayList<RILRequest> mRequestsList = new ArrayList<RILRequest>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.087 -0500", hash_original_field = "DD6FA850B0C2512C103BBC579CD52D51", hash_generated_field = "DD6FA850B0C2512C103BBC579CD52D51")

    Object     mLastNITZTimeInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.295 -0400", hash_original_field = "BF2765A7DF728F4D51D697E315A27D1E", hash_generated_field = "0EB899EA628BF1BD4CA4D632F2A8D506")

    BroadcastReceiver mIntentReceiver = new BroadcastReceiver() {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:24.295 -0400", hash_original_method = "2E7815AD99D182A9CFAEBA30A64F6122", hash_generated_method = "553AEA2DBD1EADB4B4CC318E4F64ACC6")
        @Override
        public void onReceive(Context context, Intent intent) {
            
            {
                boolean var8C358EA74D49A7EAFB8AA331D6B03438_1781041244 = (intent.getAction().equals(Intent.ACTION_SCREEN_ON));
                {
                    sendScreenState(true);
                } 
                {
                    boolean varD09851821BF78B9C6FDD532B0303A63D_1430556920 = (intent.getAction().equals(Intent.ACTION_SCREEN_OFF));
                    {
                        sendScreenState(false);
                    } 
                } 
            } 
            addTaint(context.getTaint());
            addTaint(intent.getTaint());
            
        }
        
};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.370 -0500", hash_original_field = "8205422FA9C8EE734805852885A1A6AF", hash_generated_field = "517EE6BA92CA6D3C16C0F4FDDB025C17")

    private int mSetPreferredNetworkType;

    //***** Constructors

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.147 -0500", hash_original_method = "57415555D3C32D9CF1C37CD62128114E", hash_generated_method = "EBD4AF15FC15B3B45EC1BCB6C3450064")
    
public RIL(Context context, int preferredNetworkType, int cdmaSubscription) {
        super(context);
        if (RILJ_LOGD) {
            riljLog("RIL(context, preferredNetworkType=" + preferredNetworkType +
                    " cdmaSubscription=" + cdmaSubscription + ")");
        }
        mCdmaSubscription  = cdmaSubscription;
        mPreferredNetworkType = preferredNetworkType;
        mPhoneType = RILConstants.NO_PHONE;

        PowerManager pm = (PowerManager)context.getSystemService(Context.POWER_SERVICE);
        mWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, LOG_TAG);
        mWakeLock.setReferenceCounted(false);
        mWakeLockTimeout = SystemProperties.getInt(TelephonyProperties.PROPERTY_WAKE_LOCK_TIMEOUT,
                DEFAULT_WAKE_LOCK_TIMEOUT);
        mRequestMessagesPending = 0;
        mRequestMessagesWaiting = 0;

        mSenderThread = new HandlerThread("RILSender");
        mSenderThread.start();

        Looper looper = mSenderThread.getLooper();
        mSender = new RILSender(looper);

        ConnectivityManager cm = (ConnectivityManager)context.getSystemService(
                Context.CONNECTIVITY_SERVICE);
        if (cm.isNetworkSupported(ConnectivityManager.TYPE_MOBILE) == false) {
            riljLog("Not starting RILReceiver: wifi-only");
        } else {
            riljLog("Starting RILReceiver");
            mReceiver = new RILReceiver();
            mReceiverThread = new Thread(mReceiver, "RILReceiver");
            mReceiverThread.start();

            IntentFilter filter = new IntentFilter();
            filter.addAction(Intent.ACTION_SCREEN_ON);
            filter.addAction(Intent.ACTION_SCREEN_OFF);
            context.registerReceiver(mIntentReceiver, filter);
        }
    }

    //***** CommandsInterface implementation

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.151 -0500", hash_original_method = "9505EC70575F3F081B82639224A26C6E", hash_generated_method = "83CD86D85ACADBA9C0784283738A5FAC")
    
@Override public void
    setOnNITZTime(Handler h, int what, Object obj) {
        super.setOnNITZTime(h, what, obj);

        // Send the last NITZ time if we have it
        if (mLastNITZTimeInfo != null) {
            mNITZTimeRegistrant
                .notifyRegistrant(
                    new AsyncResult (null, mLastNITZTimeInfo, null));
            mLastNITZTimeInfo = null;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.153 -0500", hash_original_method = "9A7EB00CD2404F3C288A75EFD9E4A220", hash_generated_method = "9845F65534EE430AF5488FBE4965FCDD")
    
public void
    getIccCardStatus(Message result) {
        //Note: This RIL request has not been renamed to ICC,
        //       but this request is also valid for SIM and RUIM
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_GET_SIM_STATUS, result);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        send(rr);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.156 -0500", hash_original_method = "A64490CEA7617DBF7C16959DD443F320", hash_generated_method = "2754B6467538470FD26123A3EF2B5082")
    
@Override public void
    supplyIccPin(String pin, Message result) {
        supplyIccPinForApp(pin, null, result);
    }

    @DSSink({DSSinkKind.PHONE_STATE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.158 -0500", hash_original_method = "292CEACE366769BDA48EB6300D49BD27", hash_generated_method = "03431EFD1052830D3AA53E969ACB5FA1")
    
@Override public void
    supplyIccPinForApp(String pin, String aid, Message result) {
        //Note: This RIL request has not been renamed to ICC,
        //       but this request is also valid for SIM and RUIM
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_ENTER_SIM_PIN, result);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        rr.mp.writeInt(2);
        rr.mp.writeString(pin);
        rr.mp.writeString(aid);

        send(rr);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.160 -0500", hash_original_method = "EDD0A15F8BC2322B300440A8148B03FB", hash_generated_method = "54D27AB755308927B0BDDEC73E883C89")
    
@Override public void
    supplyIccPuk(String puk, String newPin, Message result) {
        supplyIccPukForApp(puk, newPin, null, result);
    }

    @DSSink({DSSinkKind.PHONE_STATE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.163 -0500", hash_original_method = "1780B25BC715F62B7E7B76DC76BDB7F8", hash_generated_method = "0E900A5DCBE4FAD14857EC491876F845")
    
@Override public void
    supplyIccPukForApp(String puk, String newPin, String aid, Message result) {
        //Note: This RIL request has not been renamed to ICC,
        //       but this request is also valid for SIM and RUIM
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_ENTER_SIM_PUK, result);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        rr.mp.writeInt(3);
        rr.mp.writeString(puk);
        rr.mp.writeString(newPin);
        rr.mp.writeString(aid);

        send(rr);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.165 -0500", hash_original_method = "8076AE95CA0491033B7A3B1FDB27A00D", hash_generated_method = "05631E0E9F31EA04A8693EE3330EAF9E")
    
@Override public void
    supplyIccPin2(String pin, Message result) {
        supplyIccPin2ForApp(pin, null, result);
    }

    @DSSink({DSSinkKind.PHONE_STATE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.168 -0500", hash_original_method = "2364DF46EB4F312709574B2C726226B0", hash_generated_method = "1D93784D90C3EB061F59DE72838B2D0D")
    
@Override public void
    supplyIccPin2ForApp(String pin, String aid, Message result) {
        //Note: This RIL request has not been renamed to ICC,
        //       but this request is also valid for SIM and RUIM
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_ENTER_SIM_PIN2, result);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        rr.mp.writeInt(2);
        rr.mp.writeString(pin);
        rr.mp.writeString(aid);

        send(rr);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.170 -0500", hash_original_method = "02C50C8BAA9C120A4383EA48E4CE9EF9", hash_generated_method = "60499D17D410B085AA92DF9352484088")
    
@Override public void
    supplyIccPuk2(String puk2, String newPin2, Message result) {
        supplyIccPuk2ForApp(puk2, newPin2, null, result);
    }

    @DSSink({DSSinkKind.PHONE_STATE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.173 -0500", hash_original_method = "16881D0ACCF987B6F55F1477C7A8AF2E", hash_generated_method = "E6F13F7A8A4D62CB7C8EF7CD217A04EB")
    
@Override public void
    supplyIccPuk2ForApp(String puk, String newPin2, String aid, Message result) {
        //Note: This RIL request has not been renamed to ICC,
        //       but this request is also valid for SIM and RUIM
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_ENTER_SIM_PUK2, result);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        rr.mp.writeInt(3);
        rr.mp.writeString(puk);
        rr.mp.writeString(newPin2);
        rr.mp.writeString(aid);

        send(rr);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.176 -0500", hash_original_method = "E5801ABF4ED976E8B47A9DC4E0EF9FFC", hash_generated_method = "9333566F226F95BAC1E450E00E492DF5")
    
@Override public void
    changeIccPin(String oldPin, String newPin, Message result) {
        changeIccPinForApp(oldPin, newPin, null, result);
    }

    @DSSink({DSSinkKind.PHONE_STATE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.178 -0500", hash_original_method = "FB6D60EEFAF19AC3A68522374AFE5A34", hash_generated_method = "F2F757C43C302BDE99C83FFA05B8D513")
    
@Override public void
    changeIccPinForApp(String oldPin, String newPin, String aid, Message result) {
        //Note: This RIL request has not been renamed to ICC,
        //       but this request is also valid for SIM and RUIM
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_CHANGE_SIM_PIN, result);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        rr.mp.writeInt(3);
        rr.mp.writeString(oldPin);
        rr.mp.writeString(newPin);
        rr.mp.writeString(aid);

        send(rr);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.181 -0500", hash_original_method = "09C1A469DD89C445C72DC064DAF532C6", hash_generated_method = "E07452CA5AE27EF53049F3F2F894DE01")
    
@Override public void
    changeIccPin2(String oldPin2, String newPin2, Message result) {
        changeIccPin2ForApp(oldPin2, newPin2, null, result);
    }

    @DSSink({DSSinkKind.PHONE_STATE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.183 -0500", hash_original_method = "5CD184F5005892F6A2376DA12B8940E7", hash_generated_method = "79AE42D7498EDFA3139C1A9948D8DEC8")
    
@Override public void
    changeIccPin2ForApp(String oldPin2, String newPin2, String aid, Message result) {
        //Note: This RIL request has not been renamed to ICC,
        //       but this request is also valid for SIM and RUIM
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_CHANGE_SIM_PIN2, result);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        rr.mp.writeInt(3);
        rr.mp.writeString(oldPin2);
        rr.mp.writeString(newPin2);
        rr.mp.writeString(aid);

        send(rr);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.186 -0500", hash_original_method = "DCA3B69D42E061A95FB4470FAF19888E", hash_generated_method = "0C2BE2193A2ACE8870F82099D481706D")
    
public void
    changeBarringPassword(String facility, String oldPwd, String newPwd, Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_CHANGE_BARRING_PASSWORD, result);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        rr.mp.writeInt(3);
        rr.mp.writeString(facility);
        rr.mp.writeString(oldPwd);
        rr.mp.writeString(newPwd);

        send(rr);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.188 -0500", hash_original_method = "FD9166E53C98E732567F842FC6265121", hash_generated_method = "53EF95420EC6CA5BEAC41B8E62018336")
    
public void
    supplyNetworkDepersonalization(String netpin, Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_ENTER_NETWORK_DEPERSONALIZATION, result);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        rr.mp.writeInt(1);
        rr.mp.writeString(netpin);

        send(rr);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.190 -0500", hash_original_method = "6F2937ACBD34EE8D8FEF57D35663AFCC", hash_generated_method = "EA7655888FDB71BBD2E76B7A0678657B")
    
public void
    getCurrentCalls (Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_GET_CURRENT_CALLS, result);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        send(rr);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.192 -0500", hash_original_method = "A1D311E0B227CABB8D0707A1650659D2", hash_generated_method = "C3AC6F9A2CFFD32EBFB9540BD60867FB")
    
@Deprecated public void
    getPDPContextList(Message result) {
        getDataCallList(result);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.194 -0500", hash_original_method = "68CF653DB375A3C63D89D09DBB57244C", hash_generated_method = "6FEA3516FF175A7249C9230A95AB4F2A")
    
public void
    getDataCallList(Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_DATA_CALL_LIST, result);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        send(rr);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.197 -0500", hash_original_method = "85029AD0E77EFB7E7AAB9535BAB079D4", hash_generated_method = "5F12969E39261F925BD794DDAFA6B78D")
    
public void
    dial (String address, int clirMode, Message result) {
        dial(address, clirMode, null, result);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.200 -0500", hash_original_method = "2937351315DD22A0DBB0EBEECB6FBD52", hash_generated_method = "6F5D53D6E8CBFC87ED23ADEB04ACEC10")
    
public void
    dial(String address, int clirMode, UUSInfo uusInfo, Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_DIAL, result);

        rr.mp.writeString(address);
        rr.mp.writeInt(clirMode);
        rr.mp.writeInt(0); // UUS information is absent

        if (uusInfo == null) {
            rr.mp.writeInt(0); // UUS information is absent
        } else {
            rr.mp.writeInt(1); // UUS information is present
            rr.mp.writeInt(uusInfo.getType());
            rr.mp.writeInt(uusInfo.getDcs());
            rr.mp.writeByteArray(uusInfo.getUserData());
        }

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        send(rr);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.202 -0500", hash_original_method = "DCABA764531B1065D0038AAAD031BA27", hash_generated_method = "3821C0875657DA375DE89A3D9EC97311")
    
public void
    getIMSI(Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_GET_IMSI, result);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        send(rr);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.204 -0500", hash_original_method = "4D0F2CCF9960CC448C13E6CB3F3B5DE4", hash_generated_method = "EBAB5A5D400EF87FFB713114AFE6D989")
    
public void
    getIMEI(Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_GET_IMEI, result);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        send(rr);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.206 -0500", hash_original_method = "149F0748B48493B8EA1EFEBB8389549A", hash_generated_method = "1BB8B43004ECEF4213FC68CBCBE9FD5F")
    
public void
    getIMEISV(Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_GET_IMEISV, result);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        send(rr);
    }

    @DSSink({DSSinkKind.PHONE_STATE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.209 -0500", hash_original_method = "7905AFC17F454606777953D509A8D53A", hash_generated_method = "BC7CFDFB679492079FC8FCE9BE71BA5A")
    
public void
    hangupConnection (int gsmIndex, Message result) {
        if (RILJ_LOGD) riljLog("hangupConnection: gsmIndex=" + gsmIndex);

        RILRequest rr = RILRequest.obtain(RIL_REQUEST_HANGUP, result);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest) + " " +
                gsmIndex);

        rr.mp.writeInt(1);
        rr.mp.writeInt(gsmIndex);

        send(rr);
    }

    @DSSink({DSSinkKind.PHONE_CONNECTION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.211 -0500", hash_original_method = "85440FD9AE077A395C6F94573FB9B35A", hash_generated_method = "E6FF9476B275D0DC38BF69ADFCBEE6F5")
    
public void
    hangupWaitingOrBackground (Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_HANGUP_WAITING_OR_BACKGROUND,
                                        result);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        send(rr);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.213 -0500", hash_original_method = "7CE301AE0A34FEB3B57BD0350A2D5E6A", hash_generated_method = "E5D7DA806077A1E7F519079AF9DD8DA5")
    
public void
    hangupForegroundResumeBackground (Message result) {
        RILRequest rr
                = RILRequest.obtain(
                        RIL_REQUEST_HANGUP_FOREGROUND_RESUME_BACKGROUND,
                                        result);
        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        send(rr);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.216 -0500", hash_original_method = "D308C1E0C4F8D94B5EF5B2D9D0D36F66", hash_generated_method = "6C3EBEA4670E1346E5FD7E9714AB8040")
    
public void
    switchWaitingOrHoldingAndActive (Message result) {
        RILRequest rr
                = RILRequest.obtain(
                        RIL_REQUEST_SWITCH_WAITING_OR_HOLDING_AND_ACTIVE,
                                        result);
        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        send(rr);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.218 -0500", hash_original_method = "E472C7A7FA5FA1FA68AAF1D140E0BD67", hash_generated_method = "7E26170C64B3F7BF1A4ACB2CF37883B4")
    
public void
    conference (Message result) {
        RILRequest rr
                = RILRequest.obtain(RIL_REQUEST_CONFERENCE, result);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        send(rr);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.220 -0500", hash_original_method = "B803BD13961A7A2F16F3119AE2CBAC6F", hash_generated_method = "56748265189431DC6EED4D6419B2FDE4")
    
public void setPreferredVoicePrivacy(boolean enable, Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_CDMA_SET_PREFERRED_VOICE_PRIVACY_MODE,
                result);

        rr.mp.writeInt(1);
        rr.mp.writeInt(enable ? 1:0);

        send(rr);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.223 -0500", hash_original_method = "3E434E6C0C8E17A9191C0565807B19D8", hash_generated_method = "9DE0A8550A35ED14E3ADF1AAA141B584")
    
public void getPreferredVoicePrivacy(Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_CDMA_QUERY_PREFERRED_VOICE_PRIVACY_MODE,
                result);
        send(rr);
    }

    @DSSink({DSSinkKind.PHONE_STATE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.225 -0500", hash_original_method = "4B8D613904DEDF72212F0EB9A1BF349B", hash_generated_method = "A8C4008CF9862BC555954280CCB9C1F4")
    
public void
    separateConnection (int gsmIndex, Message result) {
        RILRequest rr
                = RILRequest.obtain(RIL_REQUEST_SEPARATE_CONNECTION, result);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                            + " " + gsmIndex);

        rr.mp.writeInt(1);
        rr.mp.writeInt(gsmIndex);

        send(rr);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.228 -0500", hash_original_method = "8CB5CF57551B01694681D1FE4B325AA7", hash_generated_method = "A0D8B1F3DDFE1F168FDD036ECA70557B")
    
public void
    acceptCall (Message result) {
        RILRequest rr
                = RILRequest.obtain(RIL_REQUEST_ANSWER, result);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        send(rr);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.230 -0500", hash_original_method = "2E92E83F2C082778F7F377F259918641", hash_generated_method = "932FC016B001EBFC546955A03D9FAEAE")
    
public void
    rejectCall (Message result) {
        RILRequest rr
                = RILRequest.obtain(RIL_REQUEST_UDUB, result);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        send(rr);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.232 -0500", hash_original_method = "4490A3E422842C7946255FFDE06D02C6", hash_generated_method = "CFBC79636E40BC223D2B7BC5B5696CE4")
    
public void
    explicitCallTransfer (Message result) {
        RILRequest rr
                = RILRequest.obtain(RIL_REQUEST_EXPLICIT_CALL_TRANSFER, result);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        send(rr);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.234 -0500", hash_original_method = "286D2CDF105911EDAA78CDFFAADE2FB4", hash_generated_method = "F51BDAA0E7FD7C098629275530565AD4")
    
public void
    getLastCallFailCause (Message result) {
        RILRequest rr
                = RILRequest.obtain(RIL_REQUEST_LAST_CALL_FAIL_CAUSE, result);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        send(rr);
    }

    /**
     * @deprecated
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.236 -0500", hash_original_method = "E839391FA5F4E8371F0D2466E996CFDA", hash_generated_method = "CF76277DBC8C7B5A718A27CC9BF2B21B")
    
public void
    getLastPdpFailCause (Message result) {
        getLastDataCallFailCause (result);
    }

    /**
     * The preferred new alternative to getLastPdpFailCause
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.238 -0500", hash_original_method = "367089EF39FE579C6BCEE97FCB3E914B", hash_generated_method = "531209B68622DD6030DAC21E00483D36")
    
public void
    getLastDataCallFailCause (Message result) {
        RILRequest rr
                = RILRequest.obtain(RIL_REQUEST_LAST_DATA_CALL_FAIL_CAUSE, result);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        send(rr);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.241 -0500", hash_original_method = "350AC1F658DA4E0097EF1D14A3117454", hash_generated_method = "046395BA0C4A3458086930CF3ABF0EFF")
    
public void
    setMute (boolean enableMute, Message response) {
        RILRequest rr
                = RILRequest.obtain(RIL_REQUEST_SET_MUTE, response);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                            + " " + enableMute);

        rr.mp.writeInt(1);
        rr.mp.writeInt(enableMute ? 1 : 0);

        send(rr);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.244 -0500", hash_original_method = "B42AC6EC10626260A88AA941D9E9F704", hash_generated_method = "0E2319DBE885BD40576DD73F0F0AA2DA")
    
public void
    getMute (Message response) {
        RILRequest rr
                = RILRequest.obtain(RIL_REQUEST_GET_MUTE, response);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        send(rr);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.246 -0500", hash_original_method = "16BB78D78D9B012F64B70344D11CBBD0", hash_generated_method = "ECF268D5AFD9C78BBD12C74007956873")
    
public void
    getSignalStrength (Message result) {
        RILRequest rr
                = RILRequest.obtain(RIL_REQUEST_SIGNAL_STRENGTH, result);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        send(rr);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.248 -0500", hash_original_method = "CD1D773750E577C45A4986B8D31A3404", hash_generated_method = "B949981C03E7EB84863FA2B1609338D0")
    
public void
    getVoiceRegistrationState (Message result) {
        RILRequest rr
                = RILRequest.obtain(RIL_REQUEST_VOICE_REGISTRATION_STATE, result);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        send(rr);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.250 -0500", hash_original_method = "A42E908B0E0EAE7E9677D8B8370610F9", hash_generated_method = "C0B0FE8BB6EDB3EB434106EA3CB80AD8")
    
public void
    getDataRegistrationState (Message result) {
        RILRequest rr
                = RILRequest.obtain(RIL_REQUEST_DATA_REGISTRATION_STATE, result);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        send(rr);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.253 -0500", hash_original_method = "F3EF4D956FA5FB9BDF6C62381BC62F41", hash_generated_method = "DB9E8C7615E7CE76630EBE707F313EBA")
    
public void
    getOperator(Message result) {
        RILRequest rr
                = RILRequest.obtain(RIL_REQUEST_OPERATOR, result);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        send(rr);
    }

    @DSSink({DSSinkKind.PHONE_CONNECTION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.255 -0500", hash_original_method = "3D70E9C0BFE2429BE8FC0BF7A1D59B4A", hash_generated_method = "8A8670FDE3946A58059F5AFF69F77A9B")
    
public void
    sendDtmf(char c, Message result) {
        RILRequest rr
                = RILRequest.obtain(RIL_REQUEST_DTMF, result);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        rr.mp.writeString(Character.toString(c));

        send(rr);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.257 -0500", hash_original_method = "BAA741C14C9F73BEA8C72D4011D64DC0", hash_generated_method = "3D03E3D292D1FCE7EF7AC887F78EF147")
    
public void
    startDtmf(char c, Message result) {
        RILRequest rr
                = RILRequest.obtain(RIL_REQUEST_DTMF_START, result);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        rr.mp.writeString(Character.toString(c));

        send(rr);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.261 -0500", hash_original_method = "C4D329464DB2A188FDA1049FC1B5C820", hash_generated_method = "55EC131B28BC90264579AAA064A7722D")
    
public void
    stopDtmf(Message result) {
        RILRequest rr
                = RILRequest.obtain(RIL_REQUEST_DTMF_STOP, result);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        send(rr);
    }

    @DSSink({DSSinkKind.PHONE_CONNECTION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.263 -0500", hash_original_method = "AF9E26B6734BDEC93AE44BA0DF8E2C9A", hash_generated_method = "155A8822F82960FD963489239935C5E8")
    
public void
    sendBurstDtmf(String dtmfString, int on, int off, Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_CDMA_BURST_DTMF, result);

        rr.mp.writeInt(3);
        rr.mp.writeString(dtmfString);
        rr.mp.writeString(Integer.toString(on));
        rr.mp.writeString(Integer.toString(off));

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                + " : " + dtmfString);

        send(rr);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.265 -0500", hash_original_method = "6216EB8701D12EFA1EABB572C0722209", hash_generated_method = "2C1DB9724BA444AE25C924A9DD76129A")
    
public void
    sendSMS (String smscPDU, String pdu, Message result) {
        RILRequest rr
                = RILRequest.obtain(RIL_REQUEST_SEND_SMS, result);

        rr.mp.writeInt(2);
        rr.mp.writeString(smscPDU);
        rr.mp.writeString(pdu);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        send(rr);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.269 -0500", hash_original_method = "B6146A457115D22EC1FC450C9E047949", hash_generated_method = "6BE347AC28A5379D92CECEA7AE510A60")
    
public void
    sendCdmaSms(byte[] pdu, Message result) {
        int address_nbr_of_digits;
        int subaddr_nbr_of_digits;
        int bearerDataLength;
        ByteArrayInputStream bais = new ByteArrayInputStream(pdu);
        DataInputStream dis = new DataInputStream(bais);

        RILRequest rr
                = RILRequest.obtain(RIL_REQUEST_CDMA_SEND_SMS, result);

        try {
            rr.mp.writeInt(dis.readInt()); //teleServiceId
            rr.mp.writeByte((byte) dis.readInt()); //servicePresent
            rr.mp.writeInt(dis.readInt()); //serviceCategory
            rr.mp.writeInt(dis.read()); //address_digit_mode
            rr.mp.writeInt(dis.read()); //address_nbr_mode
            rr.mp.writeInt(dis.read()); //address_ton
            rr.mp.writeInt(dis.read()); //address_nbr_plan
            address_nbr_of_digits = (byte) dis.read();
            rr.mp.writeByte((byte) address_nbr_of_digits);
            for(int i=0; i < address_nbr_of_digits; i++){
                rr.mp.writeByte(dis.readByte()); // address_orig_bytes[i]
            }
            rr.mp.writeInt(dis.read()); //subaddressType
            rr.mp.writeByte((byte) dis.read()); //subaddr_odd
            subaddr_nbr_of_digits = (byte) dis.read();
            rr.mp.writeByte((byte) subaddr_nbr_of_digits);
            for(int i=0; i < subaddr_nbr_of_digits; i++){
                rr.mp.writeByte(dis.readByte()); //subaddr_orig_bytes[i]
            }

            bearerDataLength = dis.read();
            rr.mp.writeInt(bearerDataLength);
            for(int i=0; i < bearerDataLength; i++){
                rr.mp.writeByte(dis.readByte()); //bearerData[i]
            }
        }catch (IOException ex){
            if (RILJ_LOGD) riljLog("sendSmsCdma: conversion from input stream to object failed: "
                    + ex);
        }

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        send(rr);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.271 -0500", hash_original_method = "33AA1BF497C1DD92CFF4D18BA36EE77C", hash_generated_method = "F99460047421C8D5D64BCF244C64F65C")
    
public void deleteSmsOnSim(int index, Message response) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_DELETE_SMS_ON_SIM,
                response);

        rr.mp.writeInt(1);
        rr.mp.writeInt(index);

        if (false) {
            if (RILJ_LOGD) riljLog(rr.serialString() + "> "
                    + requestToString(rr.mRequest)
                    + " " + index);
        }

        send(rr);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.273 -0500", hash_original_method = "AADBC281C1547D2CD40AF49A4F15439D", hash_generated_method = "704232C679311C80B843F775014DE8DD")
    
public void deleteSmsOnRuim(int index, Message response) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_CDMA_DELETE_SMS_ON_RUIM,
                response);

        rr.mp.writeInt(1);
        rr.mp.writeInt(index);

        if (false) {
            if (RILJ_LOGD) riljLog(rr.serialString() + "> "
                    + requestToString(rr.mRequest)
                    + " " + index);
        }

        send(rr);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.276 -0500", hash_original_method = "371A972FE084C98FCAE13C1996429D8F", hash_generated_method = "50811507BE39FF50AD9E1F587E5794D0")
    
public void writeSmsToSim(int status, String smsc, String pdu, Message response) {
        status = translateStatus(status);

        RILRequest rr = RILRequest.obtain(RIL_REQUEST_WRITE_SMS_TO_SIM,
                response);

        rr.mp.writeInt(status);
        rr.mp.writeString(pdu);
        rr.mp.writeString(smsc);

        if (false) {
            if (RILJ_LOGD) riljLog(rr.serialString() + "> "
                    + requestToString(rr.mRequest)
                    + " " + status);
        }

        send(rr);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.278 -0500", hash_original_method = "05C70D9FCCFAC2D0EDAAC7E4EA19DFB0", hash_generated_method = "59F01B989B0C4BEEE73D632778EBB1F8")
    
public void writeSmsToRuim(int status, String pdu, Message response) {
        status = translateStatus(status);

        RILRequest rr = RILRequest.obtain(RIL_REQUEST_CDMA_WRITE_SMS_TO_RUIM,
                response);

        rr.mp.writeInt(status);
        rr.mp.writeString(pdu);

        if (false) {
            if (RILJ_LOGD) riljLog(rr.serialString() + "> "
                    + requestToString(rr.mRequest)
                    + " " + status);
        }

        send(rr);
    }

    /**
     *  Translates EF_SMS status bits to a status value compatible with
     *  SMS AT commands.  See TS 27.005 3.1.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.280 -0500", hash_original_method = "0D77FBD1C1F349CB6A533B80F899FC6F", hash_generated_method = "C66ADC636E87867704F6F5AA6E39475A")
    
private int translateStatus(int status) {
        switch(status & 0x7) {
            case SmsManager.STATUS_ON_ICC_READ:
                return 1;
            case SmsManager.STATUS_ON_ICC_UNREAD:
                return 0;
            case SmsManager.STATUS_ON_ICC_SENT:
                return 3;
            case SmsManager.STATUS_ON_ICC_UNSENT:
                return 2;
        }

        // Default to READ.
        return 1;
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.283 -0500", hash_original_method = "9997727B0C7061EF37C7F5F20BA491DC", hash_generated_method = "D20CC6A6D047E0F970912023FA1291CE")
    
public void
    setupDataCall(String radioTechnology, String profile, String apn,
            String user, String password, String authType, String protocol,
            Message result) {
        RILRequest rr
                = RILRequest.obtain(RIL_REQUEST_SETUP_DATA_CALL, result);

        rr.mp.writeInt(7);

        rr.mp.writeString(radioTechnology);
        rr.mp.writeString(profile);
        rr.mp.writeString(apn);
        rr.mp.writeString(user);
        rr.mp.writeString(password);
        rr.mp.writeString(authType);
        rr.mp.writeString(protocol);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> "
                + requestToString(rr.mRequest) + " " + radioTechnology + " "
                + profile + " " + apn + " " + user + " "
                + password + " " + authType + " " + protocol);

        send(rr);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.286 -0500", hash_original_method = "7ACA8E6FBBE8E5A758B0F14E8B7A1BD0", hash_generated_method = "388143E101DCD24D563B3727CE5B80CE")
    
public void
    deactivateDataCall(int cid, int reason, Message result) {
        RILRequest rr
                = RILRequest.obtain(RIL_REQUEST_DEACTIVATE_DATA_CALL, result);

        rr.mp.writeInt(2);
        rr.mp.writeString(Integer.toString(cid));
        rr.mp.writeString(Integer.toString(reason));

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " +
                requestToString(rr.mRequest) + " " + cid + " " + reason);

        send(rr);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.288 -0500", hash_original_method = "EB783AFA41C6889D4897D81BF3D72432", hash_generated_method = "686F2E29DDA2AF0EC2F04382E1CE80D6")
    
public void
    setRadioPower(boolean on, Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_RADIO_POWER, result);

        rr.mp.writeInt(1);
        rr.mp.writeInt(on ? 1 : 0);

        if (RILJ_LOGD) {
            riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                    + (on ? " on" : " off"));
        }

        send(rr);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.291 -0500", hash_original_method = "20525E4C07E2BDDC8598F4A8A0A24AAC", hash_generated_method = "2BF85C7CE50207040943845077511BC3")
    
public void
    setSuppServiceNotifications(boolean enable, Message result) {
        RILRequest rr
                = RILRequest.obtain(RIL_REQUEST_SET_SUPP_SVC_NOTIFICATION, result);

        rr.mp.writeInt(1);
        rr.mp.writeInt(enable ? 1 : 0);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> "
                + requestToString(rr.mRequest));

        send(rr);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.293 -0500", hash_original_method = "2FD7CAC0F0B66293984C61A06F9D6871", hash_generated_method = "5920708B8C26F91AE7D3BB30F7E10DA9")
    
public void
    acknowledgeLastIncomingGsmSms(boolean success, int cause, Message result) {
        RILRequest rr
                = RILRequest.obtain(RIL_REQUEST_SMS_ACKNOWLEDGE, result);

        rr.mp.writeInt(2);
        rr.mp.writeInt(success ? 1 : 0);
        rr.mp.writeInt(cause);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                + " " + success + " " + cause);

        send(rr);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.295 -0500", hash_original_method = "7D64BD1B5FFD5E98E91826BF607F7EF6", hash_generated_method = "408F82B93ED17A846FD1A2F9653DBA68")
    
public void
    acknowledgeLastIncomingCdmaSms(boolean success, int cause, Message result) {
        RILRequest rr
                = RILRequest.obtain(RIL_REQUEST_CDMA_SMS_ACKNOWLEDGE, result);

        rr.mp.writeInt(success ? 0 : 1); //RIL_CDMA_SMS_ErrorClass
        // cause code according to X.S004-550E
        rr.mp.writeInt(cause);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                + " " + success + " " + cause);

        send(rr);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.298 -0500", hash_original_method = "64AA0D67C6CE837D613809948FDF7791", hash_generated_method = "A2E88224725052AB6466C65D9F319EA1")
    
public void
    acknowledgeIncomingGsmSmsWithPdu(boolean success, String ackPdu, Message result) {
        RILRequest rr
                = RILRequest.obtain(RIL_REQUEST_ACKNOWLEDGE_INCOMING_GSM_SMS_WITH_PDU, result);

        rr.mp.writeInt(2);
        rr.mp.writeString(success ? "1" : "0");
        rr.mp.writeString(ackPdu);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                + ' ' + success + " [" + ackPdu + ']');

        send(rr);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.300 -0500", hash_original_method = "59EE7F242CC2ECDC31CC3317E2625FB0", hash_generated_method = "95833E15F0F428F6E1FDDACD1109D23B")
    
public void
    iccIO (int command, int fileid, String path, int p1, int p2, int p3,
            String data, String pin2, Message result) {
        //Note: This RIL request has not been renamed to ICC,
        //       but this request is also valid for SIM and RUIM
        RILRequest rr
                = RILRequest.obtain(RIL_REQUEST_SIM_IO, result);

        rr.mp.writeInt(command);
        rr.mp.writeInt(fileid);
        rr.mp.writeString(path);
        rr.mp.writeInt(p1);
        rr.mp.writeInt(p2);
        rr.mp.writeInt(p3);
        rr.mp.writeString(data);
        rr.mp.writeString(pin2);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> iccIO: " + requestToString(rr.mRequest)
                + " 0x" + Integer.toHexString(command)
                + " 0x" + Integer.toHexString(fileid) + " "
                + " path: " + path + ","
                + p1 + "," + p2 + "," + p3);

        send(rr);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.303 -0500", hash_original_method = "ED6C155DF5FB4724355C53F41C941076", hash_generated_method = "A2E646C83B943925E8B4C31D7F99E428")
    
public void
    getCLIR(Message result) {
        RILRequest rr
                = RILRequest.obtain(RIL_REQUEST_GET_CLIR, result);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        send(rr);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.305 -0500", hash_original_method = "19860D4829B0277968FE7219CA94272C", hash_generated_method = "989D5E2592D27339F53219A2357C1B75")
    
public void
    setCLIR(int clirMode, Message result) {
        RILRequest rr
                = RILRequest.obtain(RIL_REQUEST_SET_CLIR, result);

        // count ints
        rr.mp.writeInt(1);

        rr.mp.writeInt(clirMode);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                    + " " + clirMode);

        send(rr);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.307 -0500", hash_original_method = "32FF52B6F1E399D1F262392EAB262972", hash_generated_method = "5616119EB615D297BDB179D335070818")
    
public void
    queryCallWaiting(int serviceClass, Message response) {
        RILRequest rr
                = RILRequest.obtain(RIL_REQUEST_QUERY_CALL_WAITING, response);

        rr.mp.writeInt(1);
        rr.mp.writeInt(serviceClass);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                    + " " + serviceClass);

        send(rr);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.310 -0500", hash_original_method = "5A203D1E3F2536DB5285EBA696BDFC7A", hash_generated_method = "AA022B60BC2EDC2F0C5D01BC0F3E8D88")
    
public void
    setCallWaiting(boolean enable, int serviceClass, Message response) {
        RILRequest rr
                = RILRequest.obtain(RIL_REQUEST_SET_CALL_WAITING, response);

        rr.mp.writeInt(2);
        rr.mp.writeInt(enable ? 1 : 0);
        rr.mp.writeInt(serviceClass);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                + " " + enable + ", " + serviceClass);

        send(rr);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.313 -0500", hash_original_method = "B2CF07F1A50F7E09BFE7FA86DAEC0935", hash_generated_method = "57EF2908CA19E86A69874E56C9860323")
    
public void
    setNetworkSelectionModeAutomatic(Message response) {
        RILRequest rr
                = RILRequest.obtain(RIL_REQUEST_SET_NETWORK_SELECTION_AUTOMATIC,
                                    response);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        send(rr);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.315 -0500", hash_original_method = "D59960D2C4E94DFBAD71EBB3A94610C2", hash_generated_method = "57B64BE62B4A78F5F44FC1B64CE8FE96")
    
public void
    setNetworkSelectionModeManual(String operatorNumeric, Message response) {
        RILRequest rr
                = RILRequest.obtain(RIL_REQUEST_SET_NETWORK_SELECTION_MANUAL,
                                    response);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                    + " " + operatorNumeric);

        rr.mp.writeString(operatorNumeric);

        send(rr);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.318 -0500", hash_original_method = "7D16D9750A543F65AAA01DDCEE296D12", hash_generated_method = "3CA91A53E3D13F5F040AE7ED02F952F8")
    
public void
    getNetworkSelectionMode(Message response) {
        RILRequest rr
                = RILRequest.obtain(RIL_REQUEST_QUERY_NETWORK_SELECTION_MODE,
                                    response);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        send(rr);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.320 -0500", hash_original_method = "A28AFA8A6050502E50A0794217CD9CA3", hash_generated_method = "7B3626F3DDFCC64B3EFE66C93C008F2E")
    
public void
    getAvailableNetworks(Message response) {
        RILRequest rr
                = RILRequest.obtain(RIL_REQUEST_QUERY_AVAILABLE_NETWORKS,
                                    response);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        send(rr);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.322 -0500", hash_original_method = "BAE7513A4D74D7F41628BC2CA56E49A7", hash_generated_method = "07120DC0F58BC8F1D81318A2617B116B")
    
public void
    setCallForward(int action, int cfReason, int serviceClass,
                String number, int timeSeconds, Message response) {
        RILRequest rr
                = RILRequest.obtain(RIL_REQUEST_SET_CALL_FORWARD, response);

        rr.mp.writeInt(action);
        rr.mp.writeInt(cfReason);
        rr.mp.writeInt(serviceClass);
        rr.mp.writeInt(PhoneNumberUtils.toaFromString(number));
        rr.mp.writeString(number);
        rr.mp.writeInt (timeSeconds);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                    + " " + action + " " + cfReason + " " + serviceClass
                    + timeSeconds);

        send(rr);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.325 -0500", hash_original_method = "23037026F2CF508E3AB593A615459BEF", hash_generated_method = "6181A2B5EC19EC16A179309FEF845C1E")
    
public void
    queryCallForwardStatus(int cfReason, int serviceClass,
                String number, Message response) {
        RILRequest rr
            = RILRequest.obtain(RIL_REQUEST_QUERY_CALL_FORWARD_STATUS, response);

        rr.mp.writeInt(2); // 2 is for query action, not in used anyway
        rr.mp.writeInt(cfReason);
        rr.mp.writeInt(serviceClass);
        rr.mp.writeInt(PhoneNumberUtils.toaFromString(number));
        rr.mp.writeString(number);
        rr.mp.writeInt (0);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                + " " + cfReason + " " + serviceClass);

        send(rr);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.327 -0500", hash_original_method = "51655E0BCF7B1E2F86E04B0432A13A10", hash_generated_method = "63D5767B7D068D080B49528CE2DC4183")
    
public void
    queryCLIP(Message response) {
        RILRequest rr
            = RILRequest.obtain(RIL_REQUEST_QUERY_CLIP, response);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        send(rr);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.329 -0500", hash_original_method = "A7E1CFA2EA980EF525A71B63D23749C6", hash_generated_method = "14E7F6C603D6C9B01BA7EB4AC147FBA2")
    
public void
    getBasebandVersion (Message response) {
        RILRequest rr
                = RILRequest.obtain(RIL_REQUEST_BASEBAND_VERSION, response);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        send(rr);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.332 -0500", hash_original_method = "E2D6CDE0F4A2E0F1E247B2E96BC06629", hash_generated_method = "D17AE35798FE231554412438D1F222C1")
    
@Override
    public void
    queryFacilityLock(String facility, String password, int serviceClass,
                            Message response) {
        queryFacilityLockForApp(facility, password, serviceClass, null, response);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.334 -0500", hash_original_method = "B68C5E6FDA45200A6E5673701837774F", hash_generated_method = "CE6630C9E5340D7AF2287323F466B069")
    
@Override
    public void
    queryFacilityLockForApp(String facility, String password, int serviceClass, String appId,
                            Message response) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_QUERY_FACILITY_LOCK, response);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        // count strings
        rr.mp.writeInt(4);

        rr.mp.writeString(facility);
        rr.mp.writeString(password);

        rr.mp.writeString(Integer.toString(serviceClass));
        rr.mp.writeString(appId);

        send(rr);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.337 -0500", hash_original_method = "AF27A0F06A4AEF0B8CE967EE20FD6D5A", hash_generated_method = "9C4FFCA6FAA0DD46269341542FE465DA")
    
@Override
    public void
    setFacilityLock (String facility, boolean lockState, String password,
                        int serviceClass, Message response) {
        setFacilityLockForApp(facility, lockState, password, serviceClass, null, response);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.339 -0500", hash_original_method = "99FAE35221FB0E541022587B483A8F41", hash_generated_method = "D1107DAF5EE97BA0C8C069CDF2159BAA")
    
@Override
    public void
    setFacilityLockForApp(String facility, boolean lockState, String password,
                        int serviceClass, String appId, Message response) {
        String lockString;
         RILRequest rr
                = RILRequest.obtain(RIL_REQUEST_SET_FACILITY_LOCK, response);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        // count strings
        rr.mp.writeInt(5);

        rr.mp.writeString(facility);
        lockString = (lockState)?"1":"0";
        rr.mp.writeString(lockString);
        rr.mp.writeString(password);
        rr.mp.writeString(Integer.toString(serviceClass));
        rr.mp.writeString(appId);

        send(rr);

    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.342 -0500", hash_original_method = "B3D73089A364D1181DC1E2D229325D6D", hash_generated_method = "A9CF38C79CB01E66FFA4BDB2880DBFF7")
    
public void
    sendUSSD (String ussdString, Message response) {
        RILRequest rr
                = RILRequest.obtain(RIL_REQUEST_SEND_USSD, response);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                            + " " + ussdString);

        rr.mp.writeString(ussdString);

        send(rr);
    }

    // inherited javadoc suffices
    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.344 -0500", hash_original_method = "08754E29DFB7112567CD0DC9F54BCD3D", hash_generated_method = "15C5D19C1E8E5B6701BE305EAC14A0CB")
    
public void cancelPendingUssd (Message response) {
        RILRequest rr
                = RILRequest.obtain(RIL_REQUEST_CANCEL_USSD, response);

        if (RILJ_LOGD) riljLog(rr.serialString()
                + "> " + requestToString(rr.mRequest));

        send(rr);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.347 -0500", hash_original_method = "5EED3CE7F239827AE459A68B7A5F6205", hash_generated_method = "0E409341A3956DB5EFB5A9E73C5179CF")
    
public void resetRadio(Message result) {
        RILRequest rr
                = RILRequest.obtain(RIL_REQUEST_RESET_RADIO, result);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        send(rr);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.350 -0500", hash_original_method = "CC2053517147AA26411A18AF4FB47931", hash_generated_method = "7B3346418E1878C98E2C294B637B5C60")
    
public void invokeOemRilRequestRaw(byte[] data, Message response) {
        RILRequest rr
                = RILRequest.obtain(RIL_REQUEST_OEM_HOOK_RAW, response);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
               + "[" + IccUtils.bytesToHexString(data) + "]");

        rr.mp.writeByteArray(data);

        send(rr);

    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.352 -0500", hash_original_method = "30F3E98808998C1043AF97B2AEFF80ED", hash_generated_method = "3AF6767D205A3D0512107736E9A49512")
    
public void invokeOemRilRequestStrings(String[] strings, Message response) {
        RILRequest rr
                = RILRequest.obtain(RIL_REQUEST_OEM_HOOK_STRINGS, response);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        rr.mp.writeStringArray(strings);

        send(rr);
    }

     /**
     * Assign a specified band for RF configuration.
     *
     * @param bandMode one of BM_*_BAND
     * @param response is callback message
     */
    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.354 -0500", hash_original_method = "0483D811AD0184EC240C471A09F163C0", hash_generated_method = "BF4EBAFE928208405D513F5D1B756B52")
    
public void setBandMode (int bandMode, Message response) {
        RILRequest rr
                = RILRequest.obtain(RIL_REQUEST_SET_BAND_MODE, response);

        rr.mp.writeInt(1);
        rr.mp.writeInt(bandMode);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                 + " " + bandMode);

        send(rr);
     }

    /**
     * Query the list of band mode supported by RF.
     *
     * @param response is callback message
     *        ((AsyncResult)response.obj).result  is an int[] with every
     *        element representing one avialable BM_*_BAND
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.357 -0500", hash_original_method = "3559A91588B2C9F9707F9FC4DC3F7539", hash_generated_method = "BDC5422584671C8096A4799FA99AA589")
    
public void queryAvailableBandMode (Message response) {
        RILRequest rr
                = RILRequest.obtain(RIL_REQUEST_QUERY_AVAILABLE_BAND_MODE,
                response);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        send(rr);
    }

    /**
     * {@inheritDoc}
     */
    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.359 -0500", hash_original_method = "E6DDFD05E0997BF7790CA803E711C2EC", hash_generated_method = "22C977A3B3ED9A8E5AFFBC0082B9EA2C")
    
public void sendTerminalResponse(String contents, Message response) {
        RILRequest rr = RILRequest.obtain(
                RILConstants.RIL_REQUEST_STK_SEND_TERMINAL_RESPONSE, response);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        rr.mp.writeString(contents);
        send(rr);
    }

    /**
     * {@inheritDoc}
     */
    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.362 -0500", hash_original_method = "AF8E8A7CD3B08412D1DCD73CAE0ACCA0", hash_generated_method = "1E02E5E6DAD7F5776FD54E3EE589B562")
    
public void sendEnvelope(String contents, Message response) {
        RILRequest rr = RILRequest.obtain(
                RILConstants.RIL_REQUEST_STK_SEND_ENVELOPE_COMMAND, response);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        rr.mp.writeString(contents);
        send(rr);
    }

    /**
     * {@inheritDoc}
     */
    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.364 -0500", hash_original_method = "A3C6115C92419E7DB4E4439F1BAFD013", hash_generated_method = "EE3C2A79AE717250C462050D7E870410")
    
public void sendEnvelopeWithStatus(String contents, Message response) {
        RILRequest rr = RILRequest.obtain(
                RILConstants.RIL_REQUEST_STK_SEND_ENVELOPE_WITH_STATUS, response);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                + '[' + contents + ']');

        rr.mp.writeString(contents);
        send(rr);
    }

    /**
     * {@inheritDoc}
     */
    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.366 -0500", hash_original_method = "0FD1EE2A52540A4F80ECA30E950318D2", hash_generated_method = "DA6632C1D4D3B6DEE73D98A414BDD497")
    
public void handleCallSetupRequestFromSim(
            boolean accept, Message response) {

        RILRequest rr = RILRequest.obtain(
            RILConstants.RIL_REQUEST_STK_HANDLE_CALL_SETUP_REQUESTED_FROM_SIM,
            response);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        int[] param = new int[1];
        param[0] = accept ? 1 : 0;
        rr.mp.writeIntArray(param);
        send(rr);
    }

    /**
     * {@inheritDoc}
     */
    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.368 -0500", hash_original_method = "E0470661D17E36A9D9FCCA070C28B88C", hash_generated_method = "8EF44D4BE40411F689C46C82530B7AD0")
    
@Override
    public void setCurrentPreferredNetworkType() {
        if (RILJ_LOGD) riljLog("setCurrentPreferredNetworkType: " + mSetPreferredNetworkType);
        setPreferredNetworkType(mSetPreferredNetworkType, null);
    }

    /**
     * {@inheritDoc}
     */
    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.373 -0500", hash_original_method = "CD05D01D2353BF09784B2C892638713C", hash_generated_method = "29A697DD9FFE9E1B2FF8AE99FE5ADC1D")
    
public void setPreferredNetworkType(int networkType , Message response) {
        RILRequest rr = RILRequest.obtain(
                RILConstants.RIL_REQUEST_SET_PREFERRED_NETWORK_TYPE, response);

        rr.mp.writeInt(1);
        rr.mp.writeInt(networkType);

        mSetPreferredNetworkType = networkType;
        mPreferredNetworkType = networkType;

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                + " : " + networkType);

        send(rr);
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.376 -0500", hash_original_method = "9630540DB0E1A382F252246374543CFF", hash_generated_method = "65E23DF9DEFF73F9CE87D994CBF73F75")
    
public void getPreferredNetworkType(Message response) {
        RILRequest rr = RILRequest.obtain(
                RILConstants.RIL_REQUEST_GET_PREFERRED_NETWORK_TYPE, response);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        send(rr);
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.378 -0500", hash_original_method = "EA7CB0793F40AD8E91B9E82268500DF5", hash_generated_method = "675049F2439C90DBE32981F7BBE76BA6")
    
public void getNeighboringCids(Message response) {
        RILRequest rr = RILRequest.obtain(
                RILConstants.RIL_REQUEST_GET_NEIGHBORING_CELL_IDS, response);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        send(rr);
    }

    /**
     * {@inheritDoc}
     */
    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.380 -0500", hash_original_method = "29FCAB1F96F7A6DF63D13BAE634B9C42", hash_generated_method = "C8850D378A117AFFFD8A0480D6558240")
    
public void setLocationUpdates(boolean enable, Message response) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_SET_LOCATION_UPDATES, response);
        rr.mp.writeInt(1);
        rr.mp.writeInt(enable ? 1 : 0);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> "
                + requestToString(rr.mRequest) + ": " + enable);

        send(rr);
    }

    /**
     * {@inheritDoc}
     */
    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.383 -0500", hash_original_method = "7C3C5691348423704F3F89A5A1253262", hash_generated_method = "D96A012163224A327084C400AF00B85A")
    
public void getSmscAddress(Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_GET_SMSC_ADDRESS, result);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        send(rr);
    }

    /**
     * {@inheritDoc}
     */
    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.385 -0500", hash_original_method = "8030AF8483F275DADFE9FBCDFA4401B2", hash_generated_method = "098BA9D896232E87B63E22E4A4D4B330")
    
public void setSmscAddress(String address, Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_SET_SMSC_ADDRESS, result);

        rr.mp.writeString(address);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                + " : " + address);

        send(rr);
    }

    /**
     * {@inheritDoc}
     */
    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.387 -0500", hash_original_method = "E14FF49FE633CFCC7BBD49EA04EF5648", hash_generated_method = "03BE0317615134E80403B54853479AFC")
    
public void reportSmsMemoryStatus(boolean available, Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_REPORT_SMS_MEMORY_STATUS, result);
        rr.mp.writeInt(1);
        rr.mp.writeInt(available ? 1 : 0);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> "
                + requestToString(rr.mRequest) + ": " + available);

        send(rr);
    }

    /**
     * {@inheritDoc}
     */
    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.390 -0500", hash_original_method = "00A5515B81A4CB5336CA56505ADAAD61", hash_generated_method = "0AE7BB021A319F33ED124C88FDA12E52")
    
public void reportStkServiceIsRunning(Message result) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_REPORT_STK_SERVICE_IS_RUNNING, result);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        send(rr);
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.392 -0500", hash_original_method = "8D8904D0E740DF21294F215C1D1D7109", hash_generated_method = "2608ADD1006B924DC51A494BD0790A9A")
    
public void getGsmBroadcastConfig(Message response) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_GSM_GET_BROADCAST_CONFIG, response);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        send(rr);
    }

    /**
     * {@inheritDoc}
     */
    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.395 -0500", hash_original_method = "052EA3DC72AD24FB98DF1CE5007E33C5", hash_generated_method = "4223DEF321C95104EFC299896948462E")
    
public void setGsmBroadcastConfig(SmsBroadcastConfigInfo[] config, Message response) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_GSM_SET_BROADCAST_CONFIG, response);

        int numOfConfig = config.length;
        rr.mp.writeInt(numOfConfig);

        for(int i = 0; i < numOfConfig; i++) {
            rr.mp.writeInt(config[i].getFromServiceId());
            rr.mp.writeInt(config[i].getToServiceId());
            rr.mp.writeInt(config[i].getFromCodeScheme());
            rr.mp.writeInt(config[i].getToCodeScheme());
            rr.mp.writeInt(config[i].isSelected() ? 1 : 0);
        }

        if (RILJ_LOGD) {
            riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                    + " with " + numOfConfig + " configs : ");
            for (int i = 0; i < numOfConfig; i++) {
                riljLog(config[i].toString());
            }
        }

        send(rr);
    }

    /**
     * {@inheritDoc}
     */
    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.397 -0500", hash_original_method = "A31C3FA8B485D8364A045A89E34CE9F1", hash_generated_method = "F398D908B27115F13C17C02E003F2CB8")
    
public void setGsmBroadcastActivation(boolean activate, Message response) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_GSM_BROADCAST_ACTIVATION, response);

        rr.mp.writeInt(1);
        rr.mp.writeInt(activate ? 0 : 1);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        send(rr);
    }

    //***** Private Methods

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.399 -0500", hash_original_method = "98C8C2D826445A3B0F1B6AA20E13AA85", hash_generated_method = "2DE309AE11E663AE1208FD76C3B1C6BA")
    
private void sendScreenState(boolean on) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_SCREEN_STATE, null);
        rr.mp.writeInt(1);
        rr.mp.writeInt(on ? 1 : 0);

        if (RILJ_LOGD) riljLog(rr.serialString()
                + "> " + requestToString(rr.mRequest) + ": " + on);

        send(rr);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.401 -0500", hash_original_method = "BB835229E5EA50CDBB0B126232F0F168", hash_generated_method = "C4718256DED8454907982DFF7F7963E9")
    
protected void
    onRadioAvailable() {
        // In case screen state was lost (due to process crash),
        // this ensures that the RIL knows the correct screen state.

        // TODO: Should query Power Manager and send the actual
        // screen state.  Just send true for now.
        sendScreenState(true);
   }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.404 -0500", hash_original_method = "160781DFD510822CA161AF254F33803E", hash_generated_method = "62DE4A3B1AB42A27278FF32FFE445953")
    
private RadioState getRadioStateFromInt(int stateInt) {
        RadioState state;

        /* RIL_RadioState ril.h */
        switch(stateInt) {
            case 0: state = RadioState.RADIO_OFF; break;
            case 1: state = RadioState.RADIO_UNAVAILABLE; break;
            case 2: state = RadioState.SIM_NOT_READY; break;
            case 3: state = RadioState.SIM_LOCKED_OR_ABSENT; break;
            case 4: state = RadioState.SIM_READY; break;
            case 5: state = RadioState.RUIM_NOT_READY; break;
            case 6: state = RadioState.RUIM_READY; break;
            case 7: state = RadioState.RUIM_LOCKED_OR_ABSENT; break;
            case 8: state = RadioState.NV_NOT_READY; break;
            case 9: state = RadioState.NV_READY; break;

            default:
                throw new RuntimeException(
                            "Unrecognized RIL_RadioState: " + stateInt);
        }
        return state;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.407 -0500", hash_original_method = "63485FEB05CEDE30346AAC1338BBCCD0", hash_generated_method = "B0B8B09EF94640BE531744F19AD42C68")
    
private void switchToRadioState(RadioState newState) {
        setRadioState(newState);
    }

    /**
     * Holds a PARTIAL_WAKE_LOCK whenever
     * a) There is outstanding RIL request sent to RIL deamon and no replied
     * b) There is a request pending to be sent out.
     *
     * There is a WAKE_LOCK_TIMEOUT to release the lock, though it shouldn't
     * happen often.
     */

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.410 -0500", hash_original_method = "80B68145386C06F39CF9C77A11CB4F6E", hash_generated_method = "8224FCD3C213FD53AFC8DB9EB6ED1691")
    
private void
    acquireWakeLock() {
        synchronized (mWakeLock) {
            mWakeLock.acquire();
            mRequestMessagesPending++;

            mSender.removeMessages(EVENT_WAKE_LOCK_TIMEOUT);
            Message msg = mSender.obtainMessage(EVENT_WAKE_LOCK_TIMEOUT);
            mSender.sendMessageDelayed(msg, mWakeLockTimeout);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.412 -0500", hash_original_method = "F7B2E2DA8A26C192DB4FA2BF8451999B", hash_generated_method = "5BB48DB32B9521B4C38F28494A2B2237")
    
private void
    releaseWakeLockIfDone() {
        synchronized (mWakeLock) {
            if (mWakeLock.isHeld() &&
                (mRequestMessagesPending == 0) &&
                (mRequestMessagesWaiting == 0)) {
                mSender.removeMessages(EVENT_WAKE_LOCK_TIMEOUT);
                mWakeLock.release();
            }
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.414 -0500", hash_original_method = "035841781AADB837D6EAD23CCB5C67B0", hash_generated_method = "F3A7299D499D0FDB239FABCE65D81EA7")
    
private void
    send(RILRequest rr) {
        Message msg;

        if (mSocket == null) {
            rr.onError(RADIO_NOT_AVAILABLE, null);
            rr.release();
            return;
        }

        msg = mSender.obtainMessage(EVENT_SEND, rr);

        acquireWakeLock();

        msg.sendToTarget();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.416 -0500", hash_original_method = "BE5BB24392C97184A4E1C8B58214F114", hash_generated_method = "BB4CF8C2C3E4F143A64FC7B6AEB09307")
    
private void
    processResponse (Parcel p) {
        int type;

        type = p.readInt();

        if (type == RESPONSE_UNSOLICITED) {
            processUnsolicited (p);
        } else if (type == RESPONSE_SOLICITED) {
            processSolicited (p);
        }

        releaseWakeLockIfDone();
    }

    /**
     * Release each request in mReqeustsList then clear the list
     * @param error is the RIL_Errno sent back
     * @param loggable true means to print all requests in mRequestslist
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.419 -0500", hash_original_method = "BC68EE684C76422271CAFE5D885C13B0", hash_generated_method = "DD84DE362D634E6ABBF5E8C5669F17DC")
    
private void clearRequestsList(int error, boolean loggable) {
        RILRequest rr;
        synchronized (mRequestsList) {
            int count = mRequestsList.size();
            if (RILJ_LOGD && loggable) {
                Log.d(LOG_TAG, "WAKE_LOCK_TIMEOUT " +
                        " mReqPending=" + mRequestMessagesPending +
                        " mRequestList=" + count);
            }

            for (int i = 0; i < count ; i++) {
                rr = mRequestsList.get(i);
                if (RILJ_LOGD && loggable) {
                    Log.d(LOG_TAG, i + ": [" + rr.mSerial + "] " +
                            requestToString(rr.mRequest));
                }
                rr.onError(error, null);
                rr.release();
            }
            mRequestsList.clear();
            mRequestMessagesWaiting = 0;
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.422 -0500", hash_original_method = "821C18746C2BF0250268E9897F34563E", hash_generated_method = "F93F5E85292EEA31D86C25F2CE2306C6")
    
private RILRequest findAndRemoveRequestFromList(int serial) {
        synchronized (mRequestsList) {
            for (int i = 0, s = mRequestsList.size() ; i < s ; i++) {
                RILRequest rr = mRequestsList.get(i);

                if (rr.mSerial == serial) {
                    mRequestsList.remove(i);
                    if (mRequestMessagesWaiting > 0)
                        mRequestMessagesWaiting--;
                    return rr;
                }
            }
        }

        return null;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.429 -0500", hash_original_method = "E53F353584D1FC1676A6EAA90642D430", hash_generated_method = "BD5989B3769BC1F9B20CBEE0D3FBBBD3")
    
private void
    processSolicited (Parcel p) {
        int serial, error;
        boolean found = false;

        serial = p.readInt();
        error = p.readInt();

        RILRequest rr;

        rr = findAndRemoveRequestFromList(serial);

        if (rr == null) {
            Log.w(LOG_TAG, "Unexpected solicited response! sn: "
                            + serial + " error: " + error);
            return;
        }

        Object ret = null;

        if (error == 0 || p.dataAvail() > 0) {
            // either command succeeds or command fails but with data payload
            try {switch (rr.mRequest) {
            /*
 cat libs/telephony/ril_commands.h \
 | egrep "^ *{RIL_" \
 | sed -re 's/\{([^,]+),[^,]+,([^}]+).+/case \1: ret = \2(p); break;/'
             */
            case RIL_REQUEST_GET_SIM_STATUS: ret =  responseIccCardStatus(p); break;
            case RIL_REQUEST_ENTER_SIM_PIN: ret =  responseInts(p); break;
            case RIL_REQUEST_ENTER_SIM_PUK: ret =  responseInts(p); break;
            case RIL_REQUEST_ENTER_SIM_PIN2: ret =  responseInts(p); break;
            case RIL_REQUEST_ENTER_SIM_PUK2: ret =  responseInts(p); break;
            case RIL_REQUEST_CHANGE_SIM_PIN: ret =  responseInts(p); break;
            case RIL_REQUEST_CHANGE_SIM_PIN2: ret =  responseInts(p); break;
            case RIL_REQUEST_ENTER_NETWORK_DEPERSONALIZATION: ret =  responseInts(p); break;
            case RIL_REQUEST_GET_CURRENT_CALLS: ret =  responseCallList(p); break;
            case RIL_REQUEST_DIAL: ret =  responseVoid(p); break;
            case RIL_REQUEST_GET_IMSI: ret =  responseString(p); break;
            case RIL_REQUEST_HANGUP: ret =  responseVoid(p); break;
            case RIL_REQUEST_HANGUP_WAITING_OR_BACKGROUND: ret =  responseVoid(p); break;
            case RIL_REQUEST_HANGUP_FOREGROUND_RESUME_BACKGROUND: ret =  responseVoid(p); break;
            case RIL_REQUEST_SWITCH_WAITING_OR_HOLDING_AND_ACTIVE: ret =  responseVoid(p); break;
            case RIL_REQUEST_CONFERENCE: ret =  responseVoid(p); break;
            case RIL_REQUEST_UDUB: ret =  responseVoid(p); break;
            case RIL_REQUEST_LAST_CALL_FAIL_CAUSE: ret =  responseInts(p); break;
            case RIL_REQUEST_SIGNAL_STRENGTH: ret =  responseSignalStrength(p); break;
            case RIL_REQUEST_VOICE_REGISTRATION_STATE: ret =  responseStrings(p); break;
            case RIL_REQUEST_DATA_REGISTRATION_STATE: ret =  responseStrings(p); break;
            case RIL_REQUEST_OPERATOR: ret =  responseStrings(p); break;
            case RIL_REQUEST_RADIO_POWER: ret =  responseVoid(p); break;
            case RIL_REQUEST_DTMF: ret =  responseVoid(p); break;
            case RIL_REQUEST_SEND_SMS: ret =  responseSMS(p); break;
            case RIL_REQUEST_SEND_SMS_EXPECT_MORE: ret =  responseSMS(p); break;
            case RIL_REQUEST_SETUP_DATA_CALL: ret =  responseSetupDataCall(p); break;
            case RIL_REQUEST_SIM_IO: ret =  responseICC_IO(p); break;
            case RIL_REQUEST_SEND_USSD: ret =  responseVoid(p); break;
            case RIL_REQUEST_CANCEL_USSD: ret =  responseVoid(p); break;
            case RIL_REQUEST_GET_CLIR: ret =  responseInts(p); break;
            case RIL_REQUEST_SET_CLIR: ret =  responseVoid(p); break;
            case RIL_REQUEST_QUERY_CALL_FORWARD_STATUS: ret =  responseCallForward(p); break;
            case RIL_REQUEST_SET_CALL_FORWARD: ret =  responseVoid(p); break;
            case RIL_REQUEST_QUERY_CALL_WAITING: ret =  responseInts(p); break;
            case RIL_REQUEST_SET_CALL_WAITING: ret =  responseVoid(p); break;
            case RIL_REQUEST_SMS_ACKNOWLEDGE: ret =  responseVoid(p); break;
            case RIL_REQUEST_GET_IMEI: ret =  responseString(p); break;
            case RIL_REQUEST_GET_IMEISV: ret =  responseString(p); break;
            case RIL_REQUEST_ANSWER: ret =  responseVoid(p); break;
            case RIL_REQUEST_DEACTIVATE_DATA_CALL: ret =  responseVoid(p); break;
            case RIL_REQUEST_QUERY_FACILITY_LOCK: ret =  responseInts(p); break;
            case RIL_REQUEST_SET_FACILITY_LOCK: ret =  responseInts(p); break;
            case RIL_REQUEST_CHANGE_BARRING_PASSWORD: ret =  responseVoid(p); break;
            case RIL_REQUEST_QUERY_NETWORK_SELECTION_MODE: ret =  responseInts(p); break;
            case RIL_REQUEST_SET_NETWORK_SELECTION_AUTOMATIC: ret =  responseVoid(p); break;
            case RIL_REQUEST_SET_NETWORK_SELECTION_MANUAL: ret =  responseVoid(p); break;
            case RIL_REQUEST_QUERY_AVAILABLE_NETWORKS : ret =  responseOperatorInfos(p); break;
            case RIL_REQUEST_DTMF_START: ret =  responseVoid(p); break;
            case RIL_REQUEST_DTMF_STOP: ret =  responseVoid(p); break;
            case RIL_REQUEST_BASEBAND_VERSION: ret =  responseString(p); break;
            case RIL_REQUEST_SEPARATE_CONNECTION: ret =  responseVoid(p); break;
            case RIL_REQUEST_SET_MUTE: ret =  responseVoid(p); break;
            case RIL_REQUEST_GET_MUTE: ret =  responseInts(p); break;
            case RIL_REQUEST_QUERY_CLIP: ret =  responseInts(p); break;
            case RIL_REQUEST_LAST_DATA_CALL_FAIL_CAUSE: ret =  responseInts(p); break;
            case RIL_REQUEST_DATA_CALL_LIST: ret =  responseDataCallList(p); break;
            case RIL_REQUEST_RESET_RADIO: ret =  responseVoid(p); break;
            case RIL_REQUEST_OEM_HOOK_RAW: ret =  responseRaw(p); break;
            case RIL_REQUEST_OEM_HOOK_STRINGS: ret =  responseStrings(p); break;
            case RIL_REQUEST_SCREEN_STATE: ret =  responseVoid(p); break;
            case RIL_REQUEST_SET_SUPP_SVC_NOTIFICATION: ret =  responseVoid(p); break;
            case RIL_REQUEST_WRITE_SMS_TO_SIM: ret =  responseInts(p); break;
            case RIL_REQUEST_DELETE_SMS_ON_SIM: ret =  responseVoid(p); break;
            case RIL_REQUEST_SET_BAND_MODE: ret =  responseVoid(p); break;
            case RIL_REQUEST_QUERY_AVAILABLE_BAND_MODE: ret =  responseInts(p); break;
            case RIL_REQUEST_STK_GET_PROFILE: ret =  responseString(p); break;
            case RIL_REQUEST_STK_SET_PROFILE: ret =  responseVoid(p); break;
            case RIL_REQUEST_STK_SEND_ENVELOPE_COMMAND: ret =  responseString(p); break;
            case RIL_REQUEST_STK_SEND_TERMINAL_RESPONSE: ret =  responseVoid(p); break;
            case RIL_REQUEST_STK_HANDLE_CALL_SETUP_REQUESTED_FROM_SIM: ret =  responseInts(p); break;
            case RIL_REQUEST_EXPLICIT_CALL_TRANSFER: ret =  responseVoid(p); break;
            case RIL_REQUEST_SET_PREFERRED_NETWORK_TYPE: ret =  responseVoid(p); break;
            case RIL_REQUEST_GET_PREFERRED_NETWORK_TYPE: ret =  responseGetPreferredNetworkType(p); break;
            case RIL_REQUEST_GET_NEIGHBORING_CELL_IDS: ret = responseCellList(p); break;
            case RIL_REQUEST_SET_LOCATION_UPDATES: ret =  responseVoid(p); break;
            case RIL_REQUEST_CDMA_SET_SUBSCRIPTION_SOURCE: ret =  responseVoid(p); break;
            case RIL_REQUEST_CDMA_SET_ROAMING_PREFERENCE: ret =  responseVoid(p); break;
            case RIL_REQUEST_CDMA_QUERY_ROAMING_PREFERENCE: ret =  responseInts(p); break;
            case RIL_REQUEST_SET_TTY_MODE: ret =  responseVoid(p); break;
            case RIL_REQUEST_QUERY_TTY_MODE: ret =  responseInts(p); break;
            case RIL_REQUEST_CDMA_SET_PREFERRED_VOICE_PRIVACY_MODE: ret =  responseVoid(p); break;
            case RIL_REQUEST_CDMA_QUERY_PREFERRED_VOICE_PRIVACY_MODE: ret =  responseInts(p); break;
            case RIL_REQUEST_CDMA_FLASH: ret =  responseVoid(p); break;
            case RIL_REQUEST_CDMA_BURST_DTMF: ret =  responseVoid(p); break;
            case RIL_REQUEST_CDMA_SEND_SMS: ret =  responseSMS(p); break;
            case RIL_REQUEST_CDMA_SMS_ACKNOWLEDGE: ret =  responseVoid(p); break;
            case RIL_REQUEST_GSM_GET_BROADCAST_CONFIG: ret =  responseGmsBroadcastConfig(p); break;
            case RIL_REQUEST_GSM_SET_BROADCAST_CONFIG: ret =  responseVoid(p); break;
            case RIL_REQUEST_GSM_BROADCAST_ACTIVATION: ret =  responseVoid(p); break;
            case RIL_REQUEST_CDMA_GET_BROADCAST_CONFIG: ret =  responseCdmaBroadcastConfig(p); break;
            case RIL_REQUEST_CDMA_SET_BROADCAST_CONFIG: ret =  responseVoid(p); break;
            case RIL_REQUEST_CDMA_BROADCAST_ACTIVATION: ret =  responseVoid(p); break;
            case RIL_REQUEST_CDMA_VALIDATE_AND_WRITE_AKEY: ret =  responseVoid(p); break;
            case RIL_REQUEST_CDMA_SUBSCRIPTION: ret =  responseStrings(p); break;
            case RIL_REQUEST_CDMA_WRITE_SMS_TO_RUIM: ret =  responseInts(p); break;
            case RIL_REQUEST_CDMA_DELETE_SMS_ON_RUIM: ret =  responseVoid(p); break;
            case RIL_REQUEST_DEVICE_IDENTITY: ret =  responseStrings(p); break;
            case RIL_REQUEST_GET_SMSC_ADDRESS: ret = responseString(p); break;
            case RIL_REQUEST_SET_SMSC_ADDRESS: ret = responseVoid(p); break;
            case RIL_REQUEST_EXIT_EMERGENCY_CALLBACK_MODE: ret = responseVoid(p); break;
            case RIL_REQUEST_REPORT_SMS_MEMORY_STATUS: ret = responseVoid(p); break;
            case RIL_REQUEST_REPORT_STK_SERVICE_IS_RUNNING: ret = responseVoid(p); break;
            case RIL_REQUEST_CDMA_GET_SUBSCRIPTION_SOURCE: ret =  responseInts(p); break;
            case RIL_REQUEST_ISIM_AUTHENTICATION: ret =  responseString(p); break;
            case RIL_REQUEST_ACKNOWLEDGE_INCOMING_GSM_SMS_WITH_PDU: ret = responseVoid(p); break;
            case RIL_REQUEST_STK_SEND_ENVELOPE_WITH_STATUS: ret = responseICC_IO(p); break;
            default:
                throw new RuntimeException("Unrecognized solicited response: " + rr.mRequest);
            //break;
            }} catch (Throwable tr) {
                // Exceptions here usually mean invalid RIL responses

                Log.w(LOG_TAG, rr.serialString() + "< "
                        + requestToString(rr.mRequest)
                        + " exception, possible invalid RIL response", tr);

                if (rr.mResult != null) {
                    AsyncResult.forMessage(rr.mResult, null, tr);
                    rr.mResult.sendToTarget();
                }
                rr.release();
                return;
            }
        }

        if (error != 0) {
            rr.onError(error, ret);
            rr.release();
            return;
        }

        if (RILJ_LOGD) riljLog(rr.serialString() + "< " + requestToString(rr.mRequest)
            + " " + retToString(rr.mRequest, ret));

        if (rr.mResult != null) {
            AsyncResult.forMessage(rr.mResult, ret, null);
            rr.mResult.sendToTarget();
        }

        rr.release();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.433 -0500", hash_original_method = "8A94A1215BBA17FF474D4F8406941ACC", hash_generated_method = "7BDB2C2C2FE64369E4BFA5FB1DA60FC8")
    
private String
    retToString(int req, Object ret) {
        if (ret == null) return "";
        switch (req) {
            // Don't log these return values, for privacy's sake.
            case RIL_REQUEST_GET_IMSI:
            case RIL_REQUEST_GET_IMEI:
            case RIL_REQUEST_GET_IMEISV:
                if (!RILJ_LOGV) {
                    // If not versbose logging just return and don't display IMSI and IMEI, IMEISV
                    return "";
                }
        }

        StringBuilder sb;
        String s;
        int length;
        if (ret instanceof int[]){
            int[] intArray = (int[]) ret;
            length = intArray.length;
            sb = new StringBuilder("{");
            if (length > 0) {
                int i = 0;
                sb.append(intArray[i++]);
                while ( i < length) {
                    sb.append(", ").append(intArray[i++]);
                }
            }
            sb.append("}");
            s = sb.toString();
        } else if (ret instanceof String[]) {
            String[] strings = (String[]) ret;
            length = strings.length;
            sb = new StringBuilder("{");
            if (length > 0) {
                int i = 0;
                sb.append(strings[i++]);
                while ( i < length) {
                    sb.append(", ").append(strings[i++]);
                }
            }
            sb.append("}");
            s = sb.toString();
        }else if (req == RIL_REQUEST_GET_CURRENT_CALLS) {
            ArrayList<DriverCall> calls = (ArrayList<DriverCall>) ret;
            sb = new StringBuilder(" ");
            for (DriverCall dc : calls) {
                sb.append("[").append(dc).append("] ");
            }
            s = sb.toString();
        } else if (req == RIL_REQUEST_GET_NEIGHBORING_CELL_IDS) {
            ArrayList<NeighboringCellInfo> cells;
            cells = (ArrayList<NeighboringCellInfo>) ret;
            sb = new StringBuilder(" ");
            for (NeighboringCellInfo cell : cells) {
                sb.append(cell).append(" ");
            }
            s = sb.toString();
        } else {
            s = ret.toString();
        }
        return s;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.442 -0500", hash_original_method = "0DD0C2CAC9DFFC256536DE8141109DEC", hash_generated_method = "391F90E9A57590FBA3FDE60B8EFD9402")
    
private void
    processUnsolicited (Parcel p) {
        int response;
        Object ret;

        response = p.readInt();

        try {switch(response) {
/*
 cat libs/telephony/ril_unsol_commands.h \
 | egrep "^ *{RIL_" \
 | sed -re 's/\{([^,]+),[^,]+,([^}]+).+/case \1: \2(rr, p); break;/'
*/

            case RIL_UNSOL_RESPONSE_RADIO_STATE_CHANGED: ret =  responseVoid(p); break;
            case RIL_UNSOL_RESPONSE_CALL_STATE_CHANGED: ret =  responseVoid(p); break;
            case RIL_UNSOL_RESPONSE_VOICE_NETWORK_STATE_CHANGED: ret =  responseVoid(p); break;
            case RIL_UNSOL_RESPONSE_NEW_SMS: ret =  responseString(p); break;
            case RIL_UNSOL_RESPONSE_NEW_SMS_STATUS_REPORT: ret =  responseString(p); break;
            case RIL_UNSOL_RESPONSE_NEW_SMS_ON_SIM: ret =  responseInts(p); break;
            case RIL_UNSOL_ON_USSD: ret =  responseStrings(p); break;
            case RIL_UNSOL_NITZ_TIME_RECEIVED: ret =  responseString(p); break;
            case RIL_UNSOL_SIGNAL_STRENGTH: ret = responseSignalStrength(p); break;
            case RIL_UNSOL_DATA_CALL_LIST_CHANGED: ret = responseDataCallList(p);break;
            case RIL_UNSOL_SUPP_SVC_NOTIFICATION: ret = responseSuppServiceNotification(p); break;
            case RIL_UNSOL_STK_SESSION_END: ret = responseVoid(p); break;
            case RIL_UNSOL_STK_PROACTIVE_COMMAND: ret = responseString(p); break;
            case RIL_UNSOL_STK_EVENT_NOTIFY: ret = responseString(p); break;
            case RIL_UNSOL_STK_CALL_SETUP: ret = responseInts(p); break;
            case RIL_UNSOL_SIM_SMS_STORAGE_FULL: ret =  responseVoid(p); break;
            case RIL_UNSOL_SIM_REFRESH: ret =  responseInts(p); break;
            case RIL_UNSOL_CALL_RING: ret =  responseCallRing(p); break;
            case RIL_UNSOL_RESTRICTED_STATE_CHANGED: ret = responseInts(p); break;
            case RIL_UNSOL_RESPONSE_SIM_STATUS_CHANGED:  ret =  responseVoid(p); break;
            case RIL_UNSOL_RESPONSE_CDMA_NEW_SMS:  ret =  responseCdmaSms(p); break;
            case RIL_UNSOL_RESPONSE_NEW_BROADCAST_SMS:  ret =  responseRaw(p); break;
            case RIL_UNSOL_CDMA_RUIM_SMS_STORAGE_FULL:  ret =  responseVoid(p); break;
            case RIL_UNSOL_ENTER_EMERGENCY_CALLBACK_MODE: ret = responseVoid(p); break;
            case RIL_UNSOL_CDMA_CALL_WAITING: ret = responseCdmaCallWaiting(p); break;
            case RIL_UNSOL_CDMA_OTA_PROVISION_STATUS: ret = responseInts(p); break;
            case RIL_UNSOL_CDMA_INFO_REC: ret = responseCdmaInformationRecord(p); break;
            case RIL_UNSOL_OEM_HOOK_RAW: ret = responseRaw(p); break;
            case RIL_UNSOL_RINGBACK_TONE: ret = responseInts(p); break;
            case RIL_UNSOL_RESEND_INCALL_MUTE: ret = responseVoid(p); break;
            case RIL_UNSOL_CDMA_SUBSCRIPTION_SOURCE_CHANGED: ret = responseInts(p); break;
            case RIL_UNSOl_CDMA_PRL_CHANGED: ret = responseInts(p); break;
            case RIL_UNSOL_EXIT_EMERGENCY_CALLBACK_MODE: ret = responseVoid(p); break;
            case RIL_UNSOL_RIL_CONNECTED: ret = responseInts(p); break;

            default:
                throw new RuntimeException("Unrecognized unsol response: " + response);
            //break; (implied)
        }} catch (Throwable tr) {
            Log.e(LOG_TAG, "Exception processing unsol response: " + response +
                "Exception:" + tr.toString());
            return;
        }

        switch(response) {
            case RIL_UNSOL_RESPONSE_RADIO_STATE_CHANGED:
                /* has bonus radio state int */
                RadioState newState = getRadioStateFromInt(p.readInt());
                if (RILJ_LOGD) unsljLogMore(response, newState.toString());

                switchToRadioState(newState);
            break;
            case RIL_UNSOL_RESPONSE_CALL_STATE_CHANGED:
                if (RILJ_LOGD) unsljLog(response);

                mCallStateRegistrants
                    .notifyRegistrants(new AsyncResult(null, null, null));
            break;
            case RIL_UNSOL_RESPONSE_VOICE_NETWORK_STATE_CHANGED:
                if (RILJ_LOGD) unsljLog(response);

                mVoiceNetworkStateRegistrants
                    .notifyRegistrants(new AsyncResult(null, null, null));
            break;
            case RIL_UNSOL_RESPONSE_NEW_SMS: {
                if (RILJ_LOGD) unsljLog(response);

                // FIXME this should move up a layer
                String a[] = new String[2];

                a[1] = (String)ret;

                SmsMessage sms;

                sms = SmsMessage.newFromCMT(a);
                if (mGsmSmsRegistrant != null) {
                    mGsmSmsRegistrant
                        .notifyRegistrant(new AsyncResult(null, sms, null));
                }
            break;
            }
            case RIL_UNSOL_RESPONSE_NEW_SMS_STATUS_REPORT:
                if (RILJ_LOGD) unsljLogRet(response, ret);

                if (mSmsStatusRegistrant != null) {
                    mSmsStatusRegistrant.notifyRegistrant(
                            new AsyncResult(null, ret, null));
                }
            break;
            case RIL_UNSOL_RESPONSE_NEW_SMS_ON_SIM:
                if (RILJ_LOGD) unsljLogRet(response, ret);

                int[] smsIndex = (int[])ret;

                if(smsIndex.length == 1) {
                    if (mSmsOnSimRegistrant != null) {
                        mSmsOnSimRegistrant.
                                notifyRegistrant(new AsyncResult(null, smsIndex, null));
                    }
                } else {
                    if (RILJ_LOGD) riljLog(" NEW_SMS_ON_SIM ERROR with wrong length "
                            + smsIndex.length);
                }
            break;
            case RIL_UNSOL_ON_USSD:
                String[] resp = (String[])ret;

                if (resp.length < 2) {
                    resp = new String[2];
                    resp[0] = ((String[])ret)[0];
                    resp[1] = null;
                }
                if (RILJ_LOGD) unsljLogMore(response, resp[0]);
                if (mUSSDRegistrant != null) {
                    mUSSDRegistrant.notifyRegistrant(
                        new AsyncResult (null, resp, null));
                }
            break;
            case RIL_UNSOL_NITZ_TIME_RECEIVED:
                if (RILJ_LOGD) unsljLogRet(response, ret);

                // has bonus long containing milliseconds since boot that the NITZ
                // time was received
                long nitzReceiveTime = p.readLong();

                Object[] result = new Object[2];

                result[0] = ret;
                result[1] = Long.valueOf(nitzReceiveTime);

                if (mNITZTimeRegistrant != null) {

                    mNITZTimeRegistrant
                        .notifyRegistrant(new AsyncResult (null, result, null));
                } else {
                    // in case NITZ time registrant isnt registered yet
                    mLastNITZTimeInfo = result;
                }
            break;

            case RIL_UNSOL_SIGNAL_STRENGTH:
                // Note this is set to "verbose" because it happens
                // frequently
                if (RILJ_LOGV) unsljLogvRet(response, ret);

                if (mSignalStrengthRegistrant != null) {
                    mSignalStrengthRegistrant.notifyRegistrant(
                                        new AsyncResult (null, ret, null));
                }
            break;
            case RIL_UNSOL_DATA_CALL_LIST_CHANGED:
                if (RILJ_LOGD) unsljLogRet(response, ret);

                mDataNetworkStateRegistrants.notifyRegistrants(new AsyncResult(null, ret, null));
            break;

            case RIL_UNSOL_SUPP_SVC_NOTIFICATION:
                if (RILJ_LOGD) unsljLogRet(response, ret);

                if (mSsnRegistrant != null) {
                    mSsnRegistrant.notifyRegistrant(
                                        new AsyncResult (null, ret, null));
                }
                break;

            case RIL_UNSOL_STK_SESSION_END:
                if (RILJ_LOGD) unsljLog(response);

                if (mCatSessionEndRegistrant != null) {
                    mCatSessionEndRegistrant.notifyRegistrant(
                                        new AsyncResult (null, ret, null));
                }
                break;

            case RIL_UNSOL_STK_PROACTIVE_COMMAND:
                if (RILJ_LOGD) unsljLogRet(response, ret);

                if (mCatProCmdRegistrant != null) {
                    mCatProCmdRegistrant.notifyRegistrant(
                                        new AsyncResult (null, ret, null));
                }
                break;

            case RIL_UNSOL_STK_EVENT_NOTIFY:
                if (RILJ_LOGD) unsljLogRet(response, ret);

                if (mCatEventRegistrant != null) {
                    mCatEventRegistrant.notifyRegistrant(
                                        new AsyncResult (null, ret, null));
                }
                break;

            case RIL_UNSOL_STK_CALL_SETUP:
                if (RILJ_LOGD) unsljLogRet(response, ret);

                if (mCatCallSetUpRegistrant != null) {
                    mCatCallSetUpRegistrant.notifyRegistrant(
                                        new AsyncResult (null, ret, null));
                }
                break;

            case RIL_UNSOL_SIM_SMS_STORAGE_FULL:
                if (RILJ_LOGD) unsljLog(response);

                if (mIccSmsFullRegistrant != null) {
                    mIccSmsFullRegistrant.notifyRegistrant();
                }
                break;

            case RIL_UNSOL_SIM_REFRESH:
                if (RILJ_LOGD) unsljLogRet(response, ret);

                if (mIccRefreshRegistrants != null) {
                    mIccRefreshRegistrants.notifyRegistrants(
                            new AsyncResult (null, ret, null));
                }
                break;

            case RIL_UNSOL_CALL_RING:
                if (RILJ_LOGD) unsljLogRet(response, ret);

                if (mRingRegistrant != null) {
                    mRingRegistrant.notifyRegistrant(
                            new AsyncResult (null, ret, null));
                }
                break;

            case RIL_UNSOL_RESTRICTED_STATE_CHANGED:
                if (RILJ_LOGD) unsljLogvRet(response, ret);
                if (mRestrictedStateRegistrant != null) {
                    mRestrictedStateRegistrant.notifyRegistrant(
                                        new AsyncResult (null, ret, null));
                }
                break;

            case RIL_UNSOL_RESPONSE_SIM_STATUS_CHANGED:
                if (RILJ_LOGD) unsljLog(response);

                if (mIccStatusChangedRegistrants != null) {
                    mIccStatusChangedRegistrants.notifyRegistrants();
                }
                break;

            case RIL_UNSOL_RESPONSE_CDMA_NEW_SMS:
                if (RILJ_LOGD) unsljLog(response);

                SmsMessage sms = (SmsMessage) ret;

                if (mCdmaSmsRegistrant != null) {
                    mCdmaSmsRegistrant
                        .notifyRegistrant(new AsyncResult(null, sms, null));
                }
                break;

            case RIL_UNSOL_RESPONSE_NEW_BROADCAST_SMS:
                if (RILJ_LOGD) unsljLog(response);

                if (mGsmBroadcastSmsRegistrant != null) {
                    mGsmBroadcastSmsRegistrant
                        .notifyRegistrant(new AsyncResult(null, ret, null));
                }
                break;

            case RIL_UNSOL_CDMA_RUIM_SMS_STORAGE_FULL:
                if (RILJ_LOGD) unsljLog(response);

                if (mIccSmsFullRegistrant != null) {
                    mIccSmsFullRegistrant.notifyRegistrant();
                }
                break;

            case RIL_UNSOL_ENTER_EMERGENCY_CALLBACK_MODE:
                if (RILJ_LOGD) unsljLog(response);

                if (mEmergencyCallbackModeRegistrant != null) {
                    mEmergencyCallbackModeRegistrant.notifyRegistrant();
                }
                break;

            case RIL_UNSOL_CDMA_CALL_WAITING:
                if (RILJ_LOGD) unsljLogRet(response, ret);

                if (mCallWaitingInfoRegistrants != null) {
                    mCallWaitingInfoRegistrants.notifyRegistrants(
                                        new AsyncResult (null, ret, null));
                }
                break;

            case RIL_UNSOL_CDMA_OTA_PROVISION_STATUS:
                if (RILJ_LOGD) unsljLogRet(response, ret);

                if (mOtaProvisionRegistrants != null) {
                    mOtaProvisionRegistrants.notifyRegistrants(
                                        new AsyncResult (null, ret, null));
                }
                break;

            case RIL_UNSOL_CDMA_INFO_REC:
                ArrayList<CdmaInformationRecords> listInfoRecs;

                try {
                    listInfoRecs = (ArrayList<CdmaInformationRecords>)ret;
                } catch (ClassCastException e) {
                    Log.e(LOG_TAG, "Unexpected exception casting to listInfoRecs", e);
                    break;
                }

                for (CdmaInformationRecords rec : listInfoRecs) {
                    if (RILJ_LOGD) unsljLogRet(response, rec);
                    notifyRegistrantsCdmaInfoRec(rec);
                }
                break;

            case RIL_UNSOL_OEM_HOOK_RAW:
                if (RILJ_LOGD) unsljLogvRet(response, IccUtils.bytesToHexString((byte[])ret));
                if (mUnsolOemHookRawRegistrant != null) {
                    mUnsolOemHookRawRegistrant.notifyRegistrant(new AsyncResult(null, ret, null));
                }
                break;

            case RIL_UNSOL_RINGBACK_TONE:
                if (RILJ_LOGD) unsljLogvRet(response, ret);
                if (mRingbackToneRegistrants != null) {
                    boolean playtone = (((int[])ret)[0] == 1);
                    mRingbackToneRegistrants.notifyRegistrants(
                                        new AsyncResult (null, playtone, null));
                }
                break;

            case RIL_UNSOL_RESEND_INCALL_MUTE:
                if (RILJ_LOGD) unsljLogRet(response, ret);

                if (mResendIncallMuteRegistrants != null) {
                    mResendIncallMuteRegistrants.notifyRegistrants(
                                        new AsyncResult (null, ret, null));
                }
                break;

            case RIL_UNSOL_CDMA_SUBSCRIPTION_SOURCE_CHANGED:
                if (RILJ_LOGD) unsljLogRet(response, ret);

                if (mCdmaSubscriptionChangedRegistrants != null) {
                    mCdmaSubscriptionChangedRegistrants.notifyRegistrants(
                                        new AsyncResult (null, ret, null));
                }
                break;

            case RIL_UNSOl_CDMA_PRL_CHANGED:
                if (RILJ_LOGD) unsljLogRet(response, ret);

                if (mCdmaPrlChangedRegistrants != null) {
                    mCdmaPrlChangedRegistrants.notifyRegistrants(
                                        new AsyncResult (null, ret, null));
                }
                break;

            case RIL_UNSOL_EXIT_EMERGENCY_CALLBACK_MODE:
                if (RILJ_LOGD) unsljLogRet(response, ret);

                if (mExitEmergencyCallbackModeRegistrants != null) {
                    mExitEmergencyCallbackModeRegistrants.notifyRegistrants(
                                        new AsyncResult (null, null, null));
                }
                break;

            case RIL_UNSOL_RIL_CONNECTED: {
                if (RILJ_LOGD) unsljLogRet(response, ret);

                // Initial conditions
                setRadioPower(false, null);
                setPreferredNetworkType(mPreferredNetworkType, null);
                setCdmaSubscriptionSource(mCdmaSubscription, null);
                notifyRegistrantsRilConnectionChanged(((int[])ret)[0]);
                break;
            }
        }
    }

    /**
     * Notifiy all registrants that the ril has connected or disconnected.
     *
     * @param rilVer is the version of the ril or -1 if disconnected.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.445 -0500", hash_original_method = "B856EBB2256F144A73FE56175A9B6A36", hash_generated_method = "DDC3745A3F8DC757EF205535670D3FDD")
    
private void notifyRegistrantsRilConnectionChanged(int rilVer) {
        mRilVersion = rilVer;
        if (mRilConnectedRegistrants != null) {
            mRilConnectedRegistrants.notifyRegistrants(
                                new AsyncResult (null, new Integer(rilVer), null));
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.448 -0500", hash_original_method = "2C7447093749DDBD708485E3CB5D7194", hash_generated_method = "58FE475C70A6E9810FA1A21048791969")
    
private Object
    responseInts(Parcel p) {
        int numInts;
        int response[];

        numInts = p.readInt();

        response = new int[numInts];

        for (int i = 0 ; i < numInts ; i++) {
            response[i] = p.readInt();
        }

        return response;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.451 -0500", hash_original_method = "F83E9E0330A999E5D5277EA606DEC7ED", hash_generated_method = "44F88BD92252367CACA6013E784AC19E")
    
private Object
    responseVoid(Parcel p) {
        return null;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.453 -0500", hash_original_method = "A9CCF034900EFF9E845FDB7DB22E08D2", hash_generated_method = "8B3D1A53E30992354590C5D02CB7B0FF")
    
private Object
    responseCallForward(Parcel p) {
        int numInfos;
        CallForwardInfo infos[];

        numInfos = p.readInt();

        infos = new CallForwardInfo[numInfos];

        for (int i = 0 ; i < numInfos ; i++) {
            infos[i] = new CallForwardInfo();

            infos[i].status = p.readInt();
            infos[i].reason = p.readInt();
            infos[i].serviceClass = p.readInt();
            infos[i].toa = p.readInt();
            infos[i].number = p.readString();
            infos[i].timeSeconds = p.readInt();
        }

        return infos;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.456 -0500", hash_original_method = "6CA2F91918640E9DE536352B73E673A3", hash_generated_method = "F60F85AFAA552486B581CBBE1012FD6E")
    
private Object
    responseSuppServiceNotification(Parcel p) {
        SuppServiceNotification notification = new SuppServiceNotification();

        notification.notificationType = p.readInt();
        notification.code = p.readInt();
        notification.index = p.readInt();
        notification.type = p.readInt();
        notification.number = p.readString();

        return notification;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.458 -0500", hash_original_method = "F3FE5FFB00EF9163091B0B3C9957ECDA", hash_generated_method = "C9262477EBC0EAE924A202DF9B25FDB5")
    
private Object
    responseCdmaSms(Parcel p) {
        SmsMessage sms;
        sms = SmsMessage.newFromParcel(p);

        return sms;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.460 -0500", hash_original_method = "E706FBE3176786F101EC24273C477E8B", hash_generated_method = "1CFDE9F5B5092DDC15D53EF077AB8DF7")
    
private Object
    responseString(Parcel p) {
        String response;

        response = p.readString();

        return response;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.462 -0500", hash_original_method = "D52365FD6A67C03CB48CBBF364BA22AF", hash_generated_method = "9D998DB899C5533A62D4248C6295E8BD")
    
private Object
    responseStrings(Parcel p) {
        int num;
        String response[];

        response = p.readStringArray();

        if (false) {
            num = p.readInt();

            response = new String[num];
            for (int i = 0; i < num; i++) {
                response[i] = p.readString();
            }
        }

        return response;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.464 -0500", hash_original_method = "B7DD4FAF5DCF16E3869A5E71E7C7982F", hash_generated_method = "EE6C0E5A95BC0C3EFE8D56FCD41B9A59")
    
private Object
    responseRaw(Parcel p) {
        int num;
        byte response[];

        response = p.createByteArray();

        return response;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.467 -0500", hash_original_method = "6A2331BAD13DEAF24E14B96082F25F22", hash_generated_method = "9EAB5CF23B6CE37D1FDEBCB9780C76B2")
    
private Object
    responseSMS(Parcel p) {
        int messageRef, errorCode;
        String ackPDU;

        messageRef = p.readInt();
        ackPDU = p.readString();
        errorCode = p.readInt();

        SmsResponse response = new SmsResponse(messageRef, ackPDU, errorCode);

        return response;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.470 -0500", hash_original_method = "36285902341CFAECFF4B1CF0D454D382", hash_generated_method = "5307DE4C11B27F7594C3A70D8F837049")
    
private Object
    responseICC_IO(Parcel p) {
        int sw1, sw2;
        byte data[] = null;
        Message ret;

        sw1 = p.readInt();
        sw2 = p.readInt();

        String s = p.readString();

        if (RILJ_LOGV) riljLog("< iccIO: "
                + " 0x" + Integer.toHexString(sw1)
                + " 0x" + Integer.toHexString(sw2) + " "
                + s);

        return new IccIoResult(sw1, sw2, s);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.473 -0500", hash_original_method = "D5683AC0AFFFFAC7278B155F54988C15", hash_generated_method = "B26496E41CBD49AF55E8049B2DA06F29")
    
private Object
    responseIccCardStatus(Parcel p) {
        IccCardApplication ca;

        IccCardStatus status = new IccCardStatus();
        status.setCardState(p.readInt());
        status.setUniversalPinState(p.readInt());
        status.setGsmUmtsSubscriptionAppIndex(p.readInt());
        status.setCdmaSubscriptionAppIndex(p.readInt());
        status.setImsSubscriptionAppIndex(p.readInt());
        int numApplications = p.readInt();

        // limit to maximum allowed applications
        if (numApplications > IccCardStatus.CARD_MAX_APPS) {
            numApplications = IccCardStatus.CARD_MAX_APPS;
        }
        status.setNumApplications(numApplications);

        for (int i = 0 ; i < numApplications ; i++) {
            ca = new IccCardApplication();
            ca.app_type       = ca.AppTypeFromRILInt(p.readInt());
            ca.app_state      = ca.AppStateFromRILInt(p.readInt());
            ca.perso_substate = ca.PersoSubstateFromRILInt(p.readInt());
            ca.aid            = p.readString();
            ca.app_label      = p.readString();
            ca.pin1_replaced  = p.readInt();
            ca.pin1           = ca.PinStateFromRILInt(p.readInt());
            ca.pin2           = ca.PinStateFromRILInt(p.readInt());
            status.addApplication(ca);
        }
        return status;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.476 -0500", hash_original_method = "26536CEB9BA98624BF6B84456E63F303", hash_generated_method = "FF490025FC0D83989689934CBECBC4FC")
    
private Object
    responseCallList(Parcel p) {
        int num;
        int voiceSettings;
        ArrayList<DriverCall> response;
        DriverCall dc;

        num = p.readInt();
        response = new ArrayList<DriverCall>(num);

        for (int i = 0 ; i < num ; i++) {
            dc = new DriverCall();

            dc.state = DriverCall.stateFromCLCC(p.readInt());
            dc.index = p.readInt();
            dc.TOA = p.readInt();
            dc.isMpty = (0 != p.readInt());
            dc.isMT = (0 != p.readInt());
            dc.als = p.readInt();
            voiceSettings = p.readInt();
            dc.isVoice = (0 == voiceSettings) ? false : true;
            dc.isVoicePrivacy = (0 != p.readInt());
            dc.number = p.readString();
            int np = p.readInt();
            dc.numberPresentation = DriverCall.presentationFromCLIP(np);
            dc.name = p.readString();
            dc.namePresentation = p.readInt();
            int uusInfoPresent = p.readInt();
            if (uusInfoPresent == 1) {
                dc.uusInfo = new UUSInfo();
                dc.uusInfo.setType(p.readInt());
                dc.uusInfo.setDcs(p.readInt());
                byte[] userData = p.createByteArray();
                dc.uusInfo.setUserData(userData);
                riljLogv(String.format("Incoming UUS : type=%d, dcs=%d, length=%d",
                                dc.uusInfo.getType(), dc.uusInfo.getDcs(),
                                dc.uusInfo.getUserData().length));
                riljLogv("Incoming UUS : data (string)="
                        + new String(dc.uusInfo.getUserData()));
                riljLogv("Incoming UUS : data (hex): "
                        + IccUtils.bytesToHexString(dc.uusInfo.getUserData()));
            } else {
                riljLogv("Incoming UUS : NOT present!");
            }

            // Make sure there's a leading + on addresses with a TOA of 145
            dc.number = PhoneNumberUtils.stringFromStringAndTOA(dc.number, dc.TOA);

            response.add(dc);

            if (dc.isVoicePrivacy) {
                mVoicePrivacyOnRegistrants.notifyRegistrants();
                riljLog("InCall VoicePrivacy is enabled");
            } else {
                mVoicePrivacyOffRegistrants.notifyRegistrants();
                riljLog("InCall VoicePrivacy is disabled");
            }
        }

        Collections.sort(response);

        return response;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.479 -0500", hash_original_method = "ED5CAFCBF47B1330CD2566A0B897CA0C", hash_generated_method = "71512459E732C910B542DB6C1ADA5185")
    
private DataCallState getDataCallState(Parcel p, int version) {
        DataCallState dataCall = new DataCallState();

        dataCall.version = version;
        if (version < 5) {
            dataCall.cid = p.readInt();
            dataCall.active = p.readInt();
            dataCall.type = p.readString();
            String addresses = p.readString();
            if (!TextUtils.isEmpty(addresses)) {
                dataCall.addresses = addresses.split(" ");
            }
        } else {
            dataCall.status = p.readInt();
            dataCall.suggestedRetryTime = p.readInt();
            dataCall.cid = p.readInt();
            dataCall.active = p.readInt();
            dataCall.type = p.readString();
            dataCall.ifname = p.readString();
            if ((dataCall.status == DataConnection.FailCause.NONE.getErrorCode()) &&
                    TextUtils.isEmpty(dataCall.ifname)) {
              throw new RuntimeException("getDataCallState, no ifname");
            }
            String addresses = p.readString();
            if (!TextUtils.isEmpty(addresses)) {
                dataCall.addresses = addresses.split(" ");
            }
            String dnses = p.readString();
            if (!TextUtils.isEmpty(dnses)) {
                dataCall.dnses = dnses.split(" ");
            }
            String gateways = p.readString();
            if (!TextUtils.isEmpty(gateways)) {
                dataCall.gateways = gateways.split(" ");
            }
        }
        return dataCall;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.482 -0500", hash_original_method = "123D49A321BB97EFA9843423F7545450", hash_generated_method = "61DE004301076E4BCC33A21DEC70F0EE")
    
private Object
    responseDataCallList(Parcel p) {
        ArrayList<DataCallState> response;

        int ver = p.readInt();
        int num = p.readInt();
        riljLog("responseDataCallList ver=" + ver + " num=" + num);

        response = new ArrayList<DataCallState>(num);
        for (int i = 0; i < num; i++) {
            response.add(getDataCallState(p, ver));
        }

        return response;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.485 -0500", hash_original_method = "6E11D362E553C380CF6ADBFD5304CD05", hash_generated_method = "A6D130DD58DC45CE2E494B4BA05C0FD4")
    
private Object
    responseSetupDataCall(Parcel p) {
        int ver = p.readInt();
        int num = p.readInt();
        if (RILJ_LOGV) riljLog("responseSetupDataCall ver=" + ver + " num=" + num);

        DataCallState dataCall;

        if (ver < 5) {
            dataCall = new DataCallState();
            dataCall.version = ver;
            dataCall.cid = Integer.parseInt(p.readString());
            dataCall.ifname = p.readString();
            if (TextUtils.isEmpty(dataCall.ifname)) {
                throw new RuntimeException(
                        "RIL_REQUEST_SETUP_DATA_CALL response, no ifname");
            }
            String addresses = p.readString();
            if (!TextUtils.isEmpty(addresses)) {
              dataCall.addresses = addresses.split(" ");
            }
            if (num >= 4) {
                String dnses = p.readString();
                if (RILJ_LOGD) riljLog("responseSetupDataCall got dnses=" + dnses);
                if (!TextUtils.isEmpty(dnses)) {
                    dataCall.dnses = dnses.split(" ");
                }
            }
            if (num >= 5) {
                String gateways = p.readString();
                if (RILJ_LOGD) riljLog("responseSetupDataCall got gateways=" + gateways);
                if (!TextUtils.isEmpty(gateways)) {
                    dataCall.gateways = gateways.split(" ");
                }
            }
        } else {
            if (num != 1) {
                throw new RuntimeException(
                        "RIL_REQUEST_SETUP_DATA_CALL response expecting 1 RIL_Data_Call_response_v5"
                        + " got " + num);
            }
            dataCall = getDataCallState(p, ver);
        }

        return dataCall;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.488 -0500", hash_original_method = "F2D5C4032BE6024B6126759412E50A01", hash_generated_method = "5DFF726CF185B8AF1CE90DE981582B33")
    
private Object
    responseOperatorInfos(Parcel p) {
        String strings[] = (String [])responseStrings(p);
        ArrayList<OperatorInfo> ret;

        if (strings.length % 4 != 0) {
            throw new RuntimeException(
                "RIL_REQUEST_QUERY_AVAILABLE_NETWORKS: invalid response. Got "
                + strings.length + " strings, expected multible of 4");
        }

        ret = new ArrayList<OperatorInfo>(strings.length / 4);

        for (int i = 0 ; i < strings.length ; i += 4) {
            ret.add (
                new OperatorInfo(
                    strings[i+0],
                    strings[i+1],
                    strings[i+2],
                    strings[i+3]));
        }

        return ret;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.491 -0500", hash_original_method = "E4123D5DA30749CB6D4FFE47F8C7BEAC", hash_generated_method = "BB29BCDA37F4ACDDBACEC16A2E61BD77")
    
private Object
    responseCellList(Parcel p) {
       int num, rssi;
       String location;
       ArrayList<NeighboringCellInfo> response;
       NeighboringCellInfo cell;

       num = p.readInt();
       response = new ArrayList<NeighboringCellInfo>();

       // Determine the radio access type
       String radioString = SystemProperties.get(
               TelephonyProperties.PROPERTY_DATA_NETWORK_TYPE, "unknown");
       int radioType;
       if (radioString.equals("GPRS")) {
           radioType = NETWORK_TYPE_GPRS;
       } else if (radioString.equals("EDGE")) {
           radioType = NETWORK_TYPE_EDGE;
       } else if (radioString.equals("UMTS")) {
           radioType = NETWORK_TYPE_UMTS;
       } else if (radioString.equals("HSDPA")) {
           radioType = NETWORK_TYPE_HSDPA;
       } else if (radioString.equals("HSUPA")) {
           radioType = NETWORK_TYPE_HSUPA;
       } else if (radioString.equals("HSPA")) {
           radioType = NETWORK_TYPE_HSPA;
       } else {
           radioType = NETWORK_TYPE_UNKNOWN;
       }

       // Interpret the location based on radio access type
       if (radioType != NETWORK_TYPE_UNKNOWN) {
           for (int i = 0 ; i < num ; i++) {
               rssi = p.readInt();
               location = p.readString();
               cell = new NeighboringCellInfo(rssi, location, radioType);
               response.add(cell);
           }
       }
       return response;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.494 -0500", hash_original_method = "225C4A262B1740AD55FF47639121D5EF", hash_generated_method = "5489CBB4FF442F65DA2D4F1866587C2A")
    
private Object responseGetPreferredNetworkType(Parcel p) {
       int [] response = (int[]) responseInts(p);

       if (response.length >= 1) {
           // Since this is the response for getPreferredNetworkType
           // we'll assume that it should be the value we want the
           // vendor ril to take if we reestablish a connection to it.
           mPreferredNetworkType = response[0];
       }
       return response;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.496 -0500", hash_original_method = "C459166A8880B065FE8A1B083AFDAF89", hash_generated_method = "0F6BE402FAFB0E2698726FDCC2070824")
    
private Object responseGmsBroadcastConfig(Parcel p) {
        int num;
        ArrayList<SmsBroadcastConfigInfo> response;
        SmsBroadcastConfigInfo info;

        num = p.readInt();
        response = new ArrayList<SmsBroadcastConfigInfo>(num);

        for (int i = 0; i < num; i++) {
            int fromId = p.readInt();
            int toId = p.readInt();
            int fromScheme = p.readInt();
            int toScheme = p.readInt();
            boolean selected = (p.readInt() == 1);

            info = new SmsBroadcastConfigInfo(fromId, toId, fromScheme,
                    toScheme, selected);
            response.add(info);
        }
        return response;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.499 -0500", hash_original_method = "55259F8FDA4B0C41A34B6184E02D7C2F", hash_generated_method = "19A68165695F38C6B4687CFB4FA46EA6")
    
private Object
    responseCdmaBroadcastConfig(Parcel p) {
        int numServiceCategories;
        int response[];

        numServiceCategories = p.readInt();

        if (numServiceCategories == 0) {
            // TODO: The logic of providing default values should
            // not be done by this transport layer. And needs to
            // be done by the vendor ril or application logic.
            int numInts;
            numInts = CDMA_BROADCAST_SMS_NO_OF_SERVICE_CATEGORIES * CDMA_BSI_NO_OF_INTS_STRUCT + 1;
            response = new int[numInts];

            // Faking a default record for all possible records.
            response[0] = CDMA_BROADCAST_SMS_NO_OF_SERVICE_CATEGORIES;

            // Loop over CDMA_BROADCAST_SMS_NO_OF_SERVICE_CATEGORIES set 'english' as
            // default language and selection status to false for all.
            for (int i = 1; i < numInts; i += CDMA_BSI_NO_OF_INTS_STRUCT ) {
                response[i + 0] = i / CDMA_BSI_NO_OF_INTS_STRUCT;
                response[i + 1] = 1;
                response[i + 2] = 0;
            }
        } else {
            int numInts;
            numInts = (numServiceCategories * CDMA_BSI_NO_OF_INTS_STRUCT) + 1;
            response = new int[numInts];

            response[0] = numServiceCategories;
            for (int i = 1 ; i < numInts; i++) {
                 response[i] = p.readInt();
             }
        }

        return response;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.501 -0500", hash_original_method = "90CED6467BA07D7B46A1F95705E3AC70", hash_generated_method = "2DC8C6A648473217783DBDDBCF78D774")
    
private Object
    responseSignalStrength(Parcel p) {
        int numInts = 12;
        int response[];

        /* TODO: Add SignalStrength class to match RIL_SignalStrength */
        response = new int[numInts];
        for (int i = 0 ; i < numInts ; i++) {
            response[i] = p.readInt();
        }

        return response;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.504 -0500", hash_original_method = "07F57EA5026D76F851755C6714CD7CB2", hash_generated_method = "53918D85714B547D3196FDC4FD5C6D74")
    
private ArrayList<CdmaInformationRecords>
    responseCdmaInformationRecord(Parcel p) {
        int numberOfInfoRecs;
        ArrayList<CdmaInformationRecords> response;

        /**
         * Loop through all of the information records unmarshalling them
         * and converting them to Java Objects.
         */
        numberOfInfoRecs = p.readInt();
        response = new ArrayList<CdmaInformationRecords>(numberOfInfoRecs);

        for (int i = 0; i < numberOfInfoRecs; i++) {
            CdmaInformationRecords InfoRec = new CdmaInformationRecords(p);
            response.add(InfoRec);
        }

        return response;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.506 -0500", hash_original_method = "C7CB5D07451D489A78BF82365C5A0B27", hash_generated_method = "080E78805484873FD500B8F4FA59555B")
    
private Object
    responseCdmaCallWaiting(Parcel p) {
        CdmaCallWaitingNotification notification = new CdmaCallWaitingNotification();

        notification.number = p.readString();
        notification.numberPresentation = notification.presentationFromCLIP(p.readInt());
        notification.name = p.readString();
        notification.namePresentation = notification.numberPresentation;
        notification.isPresent = p.readInt();
        notification.signalType = p.readInt();
        notification.alertPitch = p.readInt();
        notification.signal = p.readInt();
        notification.numberType = p.readInt();
        notification.numberPlan = p.readInt();

        return notification;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.509 -0500", hash_original_method = "F4EF6B3A014077C64691F0B8D26D4AED", hash_generated_method = "8C72FD3EED228F0EA56391C35103BC05")
    
private Object
    responseCallRing(Parcel p){
        char response[] = new char[4];

        response[0] = (char) p.readInt();    // isPresent
        response[1] = (char) p.readInt();    // signalType
        response[2] = (char) p.readInt();    // alertPitch
        response[3] = (char) p.readInt();    // signal

        return response;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.514 -0500", hash_original_method = "04666C2E99832FCFAFCF388A68EF0610", hash_generated_method = "179EB04D5DAEDBEE9ADB20BFE245346A")
    
private void
    notifyRegistrantsCdmaInfoRec(CdmaInformationRecords infoRec) {
        int response = RIL_UNSOL_CDMA_INFO_REC;
        if (infoRec.record instanceof CdmaInformationRecords.CdmaDisplayInfoRec) {
            if (mDisplayInfoRegistrants != null) {
                if (RILJ_LOGD) unsljLogRet(response, infoRec.record);
                mDisplayInfoRegistrants.notifyRegistrants(
                        new AsyncResult (null, infoRec.record, null));
            }
        } else if (infoRec.record instanceof CdmaInformationRecords.CdmaSignalInfoRec) {
            if (mSignalInfoRegistrants != null) {
                if (RILJ_LOGD) unsljLogRet(response, infoRec.record);
                mSignalInfoRegistrants.notifyRegistrants(
                        new AsyncResult (null, infoRec.record, null));
            }
        } else if (infoRec.record instanceof CdmaInformationRecords.CdmaNumberInfoRec) {
            if (mNumberInfoRegistrants != null) {
                if (RILJ_LOGD) unsljLogRet(response, infoRec.record);
                mNumberInfoRegistrants.notifyRegistrants(
                        new AsyncResult (null, infoRec.record, null));
            }
        } else if (infoRec.record instanceof CdmaInformationRecords.CdmaRedirectingNumberInfoRec) {
            if (mRedirNumInfoRegistrants != null) {
                if (RILJ_LOGD) unsljLogRet(response, infoRec.record);
                mRedirNumInfoRegistrants.notifyRegistrants(
                        new AsyncResult (null, infoRec.record, null));
            }
        } else if (infoRec.record instanceof CdmaInformationRecords.CdmaLineControlInfoRec) {
            if (mLineControlInfoRegistrants != null) {
                if (RILJ_LOGD) unsljLogRet(response, infoRec.record);
                mLineControlInfoRegistrants.notifyRegistrants(
                        new AsyncResult (null, infoRec.record, null));
            }
        } else if (infoRec.record instanceof CdmaInformationRecords.CdmaT53ClirInfoRec) {
            if (mT53ClirInfoRegistrants != null) {
                if (RILJ_LOGD) unsljLogRet(response, infoRec.record);
                mT53ClirInfoRegistrants.notifyRegistrants(
                        new AsyncResult (null, infoRec.record, null));
            }
        } else if (infoRec.record instanceof CdmaInformationRecords.CdmaT53AudioControlInfoRec) {
            if (mT53AudCntrlInfoRegistrants != null) {
               if (RILJ_LOGD) unsljLogRet(response, infoRec.record);
               mT53AudCntrlInfoRegistrants.notifyRegistrants(
                       new AsyncResult (null, infoRec.record, null));
            }
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.526 -0500", hash_original_method = "513B160CE13530A75C92D2BB2C156FD7", hash_generated_method = "1E131635314ABAE5EF6FDA3C0768DE7F")
    
private void riljLog(String msg) {
        Log.d(LOG_TAG, msg);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.528 -0500", hash_original_method = "709360DE622013B25C1B037A3416C3B6", hash_generated_method = "482E15019ADD4308592A2EF421ADF481")
    
private void riljLogv(String msg) {
        Log.v(LOG_TAG, msg);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.531 -0500", hash_original_method = "2B7AB7C6A9DFCD91149097CF23FA21DF", hash_generated_method = "3FC2E71BEA4797AEB881F8072DE56110")
    
private void unsljLog(int response) {
        riljLog("[UNSL]< " + responseToString(response));
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.533 -0500", hash_original_method = "B9D4DA0AB06082664757422C0E23F4B2", hash_generated_method = "3FCBFE29986B3A5AD4E199C9E8C84365")
    
private void unsljLogMore(int response, String more) {
        riljLog("[UNSL]< " + responseToString(response) + " " + more);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.535 -0500", hash_original_method = "02F7DA800ECB6E455062B2AF08D2856E", hash_generated_method = "4308949EB9B61C1B0F428CCAF52E8C62")
    
private void unsljLogRet(int response, Object ret) {
        riljLog("[UNSL]< " + responseToString(response) + " " + retToString(response, ret));
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.537 -0500", hash_original_method = "5479F9B9AF9D3C3FE7229BC789506755", hash_generated_method = "8E80D7270098728D5CB1E651C097C44E")
    
private void unsljLogvRet(int response, Object ret) {
        riljLogv("[UNSL]< " + responseToString(response) + " " + retToString(response, ret));
    }

    // ***** Methods for CDMA support
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.539 -0500", hash_original_method = "B8DB86D0D3DD2A6C87C6DBBEA17396A3", hash_generated_method = "76A6078265BCBAD73DB0DFCC3EC222BC")
    
public void
    getDeviceIdentity(Message response) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_DEVICE_IDENTITY, response);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        send(rr);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.542 -0500", hash_original_method = "2F4B55F10DAACCDACB48694F0AD6C5FC", hash_generated_method = "201594DD11867F9E5568C225E7F2F93B")
    
public void
    getCDMASubscription(Message response) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_CDMA_SUBSCRIPTION, response);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        send(rr);
    }
    
    class RILSender extends Handler implements Runnable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.120 -0500", hash_original_field = "D1362109E83ED4221773106790FD549F", hash_generated_field = "D1362109E83ED4221773106790FD549F")

        byte[] dataLength = new byte[4];
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.118 -0500", hash_original_method = "4D17817439BCC34837C575257CF9147F", hash_generated_method = "7F3B9F7D5201A9EB032C84CA645BFD5D")
        
public RILSender(Looper looper) {
            super(looper);
        }

        //***** Runnable implementation
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.122 -0500", hash_original_method = "941C644B96F3E7EE75FAD0CC47E0EEC2", hash_generated_method = "AB7009E9147A46711C31F9E68A9A4C54")
        
public void
        run() {
            //setup if needed
        }

        //***** Handler implementation
        @DSSink({DSSinkKind.SYSTEM_SETTINGS})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.127 -0500", hash_original_method = "D25DB5A43D9B976C2A2C198EC34CFB08", hash_generated_method = "31FD0E667E5596F74C850B900AEA6238")
        
@Override public void
        handleMessage(Message msg) {
            RILRequest rr = (RILRequest)(msg.obj);
            RILRequest req = null;

            switch (msg.what) {
                case EVENT_SEND:
                    /**
                     * mRequestMessagePending++ already happened for every
                     * EVENT_SEND, thus we must make sure
                     * mRequestMessagePending-- happens once and only once
                     */
                    boolean alreadySubtracted = false;
                    try {
                        LocalSocket s;

                        s = mSocket;

                        if (s == null) {
                            rr.onError(RADIO_NOT_AVAILABLE, null);
                            rr.release();
                            if (mRequestMessagesPending > 0)
                                mRequestMessagesPending--;
                            alreadySubtracted = true;
                            return;
                        }

                        synchronized (mRequestsList) {
                            mRequestsList.add(rr);
                            mRequestMessagesWaiting++;
                        }

                        if (mRequestMessagesPending > 0)
                            mRequestMessagesPending--;
                        alreadySubtracted = true;

                        byte[] data;

                        data = rr.mp.marshall();
                        rr.mp.recycle();
                        rr.mp = null;

                        if (data.length > RIL_MAX_COMMAND_BYTES) {
                            throw new RuntimeException(
                                    "Parcel larger than max bytes allowed! "
                                                          + data.length);
                        }

                        // parcel length in big endian
                        dataLength[0] = dataLength[1] = 0;
                        dataLength[2] = (byte)((data.length >> 8) & 0xff);
                        dataLength[3] = (byte)((data.length) & 0xff);

                        //Log.v(LOG_TAG, "writing packet: " + data.length + " bytes");

                        s.getOutputStream().write(dataLength);
                        s.getOutputStream().write(data);
                    } catch (IOException ex) {
                        Log.e(LOG_TAG, "IOException", ex);
                        req = findAndRemoveRequestFromList(rr.mSerial);
                        // make sure this request has not already been handled,
                        // eg, if RILReceiver cleared the list.
                        if (req != null || !alreadySubtracted) {
                            rr.onError(RADIO_NOT_AVAILABLE, null);
                            rr.release();
                        }
                    } catch (RuntimeException exc) {
                        Log.e(LOG_TAG, "Uncaught exception ", exc);
                        req = findAndRemoveRequestFromList(rr.mSerial);
                        // make sure this request has not already been handled,
                        // eg, if RILReceiver cleared the list.
                        if (req != null || !alreadySubtracted) {
                            rr.onError(GENERIC_FAILURE, null);
                            rr.release();
                        }
                    } finally {
                        // Note: We are "Done" only if there are no outstanding
                        // requests or replies. Thus this code path will only release
                        // the wake lock on errors.
                        releaseWakeLockIfDone();
                    }

                    if (!alreadySubtracted && mRequestMessagesPending > 0) {
                        mRequestMessagesPending--;
                    }

                    break;

                case EVENT_WAKE_LOCK_TIMEOUT:
                    // Haven't heard back from the last request.  Assume we're
                    // not getting a response and  release the wake lock.
                    synchronized (mWakeLock) {
                        if (mWakeLock.isHeld()) {
                            // The timer of WAKE_LOCK_TIMEOUT is reset with each
                            // new send request. So when WAKE_LOCK_TIMEOUT occurs
                            // all requests in mRequestList already waited at
                            // least DEFAULT_WAKE_LOCK_TIMEOUT but no response.
                            // Reset mRequestMessagesWaiting to enable
                            // releaseWakeLockIfDone().
                            //
                            // Note: Keep mRequestList so that delayed response
                            // can still be handled when response finally comes.
                            if (mRequestMessagesWaiting != 0) {
                                Log.d(LOG_TAG, "NOTE: mReqWaiting is NOT 0 but"
                                        + mRequestMessagesWaiting + " at TIMEOUT, reset!"
                                        + " There still msg waitng for response");

                                mRequestMessagesWaiting = 0;

                                if (RILJ_LOGD) {
                                    synchronized (mRequestsList) {
                                        int count = mRequestsList.size();
                                        Log.d(LOG_TAG, "WAKE_LOCK_TIMEOUT " +
                                                " mRequestList=" + count);

                                        for (int i = 0; i < count; i++) {
                                            rr = mRequestsList.get(i);
                                            Log.d(LOG_TAG, i + ": [" + rr.mSerial + "] "
                                                    + requestToString(rr.mRequest));
                                        }
                                    }
                                }
                            }
                            // mRequestMessagesPending shows how many
                            // requests are waiting to be sent (and before
                            // to be added in request list) since star the
                            // WAKE_LOCK_TIMEOUT timer. Since WAKE_LOCK_TIMEOUT
                            // is the expected time to get response, all requests
                            // should already sent out (i.e.
                            // mRequestMessagesPending is 0 )while TIMEOUT occurs.
                            if (mRequestMessagesPending != 0) {
                                Log.e(LOG_TAG, "ERROR: mReqPending is NOT 0 but"
                                        + mRequestMessagesPending + " at TIMEOUT, reset!");
                                mRequestMessagesPending = 0;

                            }
                            mWakeLock.release();
                        }
                    }
                    break;
            }
        }
        
    }
    
    class RILReceiver implements Runnable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.136 -0500", hash_original_field = "3923F3F9F9ECABE8D28493E863FC2CD8", hash_generated_field = "3923F3F9F9ECABE8D28493E863FC2CD8")

        byte[] buffer;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.138 -0500", hash_original_method = "AEB7D4EC0C0D3B29B57F76734A093487", hash_generated_method = "AEB7D4EC0C0D3B29B57F76734A093487")
        
RILReceiver() {
            buffer = new byte[RIL_MAX_COMMAND_BYTES];
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.142 -0500", hash_original_method = "3E25FFC0D00CEB4B0CF0C518A51DB777", hash_generated_method = "CB2E9E1461282E6FAEAB0D17308BF755")
        
public void
        run() {
            int retryCount = 0;

            try {for (;;) {
                LocalSocket s = null;
                LocalSocketAddress l;

                try {
                    s = new LocalSocket();
                    l = new LocalSocketAddress(SOCKET_NAME_RIL,
                            LocalSocketAddress.Namespace.RESERVED);
                    s.connect(l);
                } catch (IOException ex){
                    try {
                        if (s != null) {
                            s.close();
                        }
                    } catch (IOException ex2) {
                        //ignore failure to close after failure to connect
                    }

                    // don't print an error message after the the first time
                    // or after the 8th time

                    if (retryCount == 8) {
                        Log.e (LOG_TAG,
                            "Couldn't find '" + SOCKET_NAME_RIL
                            + "' socket after " + retryCount
                            + " times, continuing to retry silently");
                    } else if (retryCount > 0 && retryCount < 8) {
                        Log.i (LOG_TAG,
                            "Couldn't find '" + SOCKET_NAME_RIL
                            + "' socket; retrying after timeout");
                    }

                    try {
                        Thread.sleep(SOCKET_OPEN_RETRY_MILLIS);
                    } catch (InterruptedException er) {
                    }

                    retryCount++;
                    continue;
                }

                retryCount = 0;

                mSocket = s;
                Log.i(LOG_TAG, "Connected to '" + SOCKET_NAME_RIL + "' socket");

                int length = 0;
                try {
                    InputStream is = mSocket.getInputStream();

                    for (;;) {
                        Parcel p;

                        length = readRilMessage(is, buffer);

                        if (length < 0) {
                            // End-of-stream reached
                            break;
                        }

                        p = Parcel.obtain();
                        p.unmarshall(buffer, 0, length);
                        p.setDataPosition(0);

                        //Log.v(LOG_TAG, "Read packet: " + length + " bytes");

                        processResponse(p);
                        p.recycle();
                    }
                } catch (java.io.IOException ex) {
                    Log.i(LOG_TAG, "'" + SOCKET_NAME_RIL + "' socket closed",
                          ex);
                } catch (Throwable tr) {
                    Log.e(LOG_TAG, "Uncaught exception read length=" + length +
                        "Exception:" + tr.toString());
                }

                Log.i(LOG_TAG, "Disconnected from '" + SOCKET_NAME_RIL
                      + "' socket");

                setRadioState (RadioState.RADIO_UNAVAILABLE);

                try {
                    mSocket.close();
                } catch (IOException ex) {
                }

                mSocket = null;
                RILRequest.resetSerial();

                // Clear request list on close
                clearRequestsList(RADIO_NOT_AVAILABLE, false);
            }} catch (Throwable tr) {
                Log.e(LOG_TAG,"Uncaught exception", tr);
            }

            /* We're disconnected so we don't know the ril version */
            notifyRegistrantsRilConnectionChanged(-1);
        }
        
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.544 -0500", hash_original_method = "CD84ED40ADC2BEFF960D6D373762CCB2", hash_generated_method = "4CBCB581979D50D11AFFCF74C71147BD")
    
@Override
    public void setPhoneType(int phoneType) { // Called by CDMAPhone and GSMPhone constructor
        if (RILJ_LOGD) riljLog("setPhoneType=" + phoneType + " old value=" + mPhoneType);
        mPhoneType = phoneType;
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.547 -0500", hash_original_method = "849E6CD9CCE8F1ECF8BC959270B499A0", hash_generated_method = "25CA41E73B576D36C4DC46D880827142")
    
public void queryCdmaRoamingPreference(Message response) {
        RILRequest rr = RILRequest.obtain(
                RILConstants.RIL_REQUEST_CDMA_QUERY_ROAMING_PREFERENCE, response);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        send(rr);
    }

    /**
     * {@inheritDoc}
     */
    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.549 -0500", hash_original_method = "BC2979EAC0CBA90D634290B385917086", hash_generated_method = "D86D1F5E67B9A4CCE3C77FB04C17DB36")
    
public void setCdmaRoamingPreference(int cdmaRoamingType, Message response) {
        RILRequest rr = RILRequest.obtain(
                RILConstants.RIL_REQUEST_CDMA_SET_ROAMING_PREFERENCE, response);

        rr.mp.writeInt(1);
        rr.mp.writeInt(cdmaRoamingType);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                + " : " + cdmaRoamingType);

        send(rr);
    }

    /**
     * {@inheritDoc}
     */
    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.552 -0500", hash_original_method = "5B737D91D0E47D0010D2976568B23A82", hash_generated_method = "E1E8C91BCC3E820165CCFBF1CF0ACE9F")
    
public void setCdmaSubscriptionSource(int cdmaSubscription , Message response) {
        RILRequest rr = RILRequest.obtain(
                RILConstants.RIL_REQUEST_CDMA_SET_SUBSCRIPTION_SOURCE, response);

        rr.mp.writeInt(1);
        rr.mp.writeInt(cdmaSubscription);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                + " : " + cdmaSubscription);

        send(rr);
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.554 -0500", hash_original_method = "5EEECA9C4DAFB6EB7CE2420CACC9812C", hash_generated_method = "A7F30A855D4290597F2EC53B818E42FD")
    
@Override
    public void getCdmaSubscriptionSource(Message response) {
        RILRequest rr = RILRequest.obtain(
                RILConstants.RIL_REQUEST_CDMA_GET_SUBSCRIPTION_SOURCE, response);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        send(rr);
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.557 -0500", hash_original_method = "116710C0DB0DC531DE694B6BC2F4AE2B", hash_generated_method = "E820AD6E49E48479B64279165D44A52F")
    
public void queryTTYMode(Message response) {
        RILRequest rr = RILRequest.obtain(
                RILConstants.RIL_REQUEST_QUERY_TTY_MODE, response);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        send(rr);
    }

    /**
     * {@inheritDoc}
     */
    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.559 -0500", hash_original_method = "0B5DA23B67CE8A881960D39226001892", hash_generated_method = "BAE8EA5E99A08E0B9EBF1E0DA3E3CD55")
    
public void setTTYMode(int ttyMode, Message response) {
        RILRequest rr = RILRequest.obtain(
                RILConstants.RIL_REQUEST_SET_TTY_MODE, response);

        rr.mp.writeInt(1);
        rr.mp.writeInt(ttyMode);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                + " : " + ttyMode);

        send(rr);
    }

    /**
     * {@inheritDoc}
     */
    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.562 -0500", hash_original_method = "9DB0667959C6184F19426DF0FB910315", hash_generated_method = "1CDF46E850D12393272BE824CF77736E")
    
public void
    sendCDMAFeatureCode(String FeatureCode, Message response) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_CDMA_FLASH, response);

        rr.mp.writeString(FeatureCode);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest)
                + " : " + FeatureCode);

        send(rr);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.564 -0500", hash_original_method = "EB6E132144573DF781138A585850ED0A", hash_generated_method = "9B71DBAB3FD34DE9DFB39BCC252B4E52")
    
public void getCdmaBroadcastConfig(Message response) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_CDMA_GET_BROADCAST_CONFIG, response);

        send(rr);
    }

    // TODO: Change the configValuesArray to a RIL_BroadcastSMSConfig
    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.566 -0500", hash_original_method = "7AE57418607D61F0BA79FD2FF4F728AF", hash_generated_method = "8CF52294E8F8C9B4382CEA72F47F270F")
    
public void setCdmaBroadcastConfig(int[] configValuesArray, Message response) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_CDMA_SET_BROADCAST_CONFIG, response);

        for(int i = 0; i < configValuesArray.length; i++) {
            rr.mp.writeInt(configValuesArray[i]);
        }

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        send(rr);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.569 -0500", hash_original_method = "41C22C7BD9DE14E15F4803649E353969", hash_generated_method = "F7D6A0F4C6291549FF4E3BB3428A700D")
    
public void setCdmaBroadcastActivation(boolean activate, Message response) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_CDMA_BROADCAST_ACTIVATION, response);

        rr.mp.writeInt(1);
        rr.mp.writeInt(activate ? 0 :1);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        send(rr);
    }

    /**
     * {@inheritDoc}
     */
    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.571 -0500", hash_original_method = "82BAE0E7FF72D1A409D61F03DD8EFEA2", hash_generated_method = "20351156A4CEAF44F8649AE6EAE5E45A")
    
public void exitEmergencyCallbackMode(Message response) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_EXIT_EMERGENCY_CALLBACK_MODE, response);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        send(rr);
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:14.573 -0500", hash_original_method = "381EF137384490D69DA50E927DA4C209", hash_generated_method = "2FDEC52408531AFB988CB22C04CE278C")
    
public void requestIsimAuthentication(String nonce, Message response) {
        RILRequest rr = RILRequest.obtain(RIL_REQUEST_ISIM_AUTHENTICATION, response);

        rr.mp.writeString(nonce);

        if (RILJ_LOGD) riljLog(rr.serialString() + "> " + requestToString(rr.mRequest));

        send(rr);
    }
}

