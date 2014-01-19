package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import static android.telephony.SmsManager.STATUS_ON_ICC_FREE;

import java.util.ArrayList;
import java.util.List;

import android.app.PendingIntent;
import android.content.Context;
import android.util.Log;

import com.android.internal.util.HexDump;

public abstract class IccSmsInterfaceManager extends ISms.Stub {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:21.937 -0500", hash_original_field = "B504049739EC0253F0006BF183324917", hash_generated_field = "C5284483C4CF8ED630A2E2607ED30E12")

    protected PhoneBase mPhone;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:21.939 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "B3359F86E29A965BC1436888E98C55A8")

    protected Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:21.941 -0500", hash_original_field = "FD1C0FFB971986B256FC7777A6439457", hash_generated_field = "AC8E6363A1434BE5D4DA002E7C8CA149")

    protected SMSDispatcher mDispatcher;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:21.945 -0500", hash_original_method = "78E99F4B2BD1DF9D391D1AFBEE29FD49", hash_generated_method = "46D7AF8BFB1486DAABE1C492CFE067FE")
    
protected IccSmsInterfaceManager(PhoneBase phone){
        mPhone = phone;
        mContext = phone.getContext();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:21.947 -0500", hash_original_method = "D94224C2F430A720CDDDF796E6F87142", hash_generated_method = "5717DD822544F99ECC1D2D48AE7159D2")
    
protected void enforceReceiveAndSend(String message) {
        mContext.enforceCallingPermission(
                "android.permission.RECEIVE_SMS", message);
        mContext.enforceCallingPermission(
                "android.permission.SEND_SMS", message);
    }

    /**
     * Send a data based SMS to a specific application port.
     *
     * @param destAddr the address to send the message to
     * @param scAddr is the service center address or null to use
     *  the current default SMSC
     * @param destPort the port to deliver the message to
     * @param data the body of the message to send
     * @param sentIntent if not NULL this <code>PendingIntent</code> is
     *  broadcast when the message is successfully sent, or failed.
     *  The result code will be <code>Activity.RESULT_OK<code> for success,
     *  or one of these errors:<br>
     *  <code>RESULT_ERROR_GENERIC_FAILURE</code><br>
     *  <code>RESULT_ERROR_RADIO_OFF</code><br>
     *  <code>RESULT_ERROR_NULL_PDU</code><br>
     *  For <code>RESULT_ERROR_GENERIC_FAILURE</code> the sentIntent may include
     *  the extra "errorCode" containing a radio technology specific value,
     *  generally only useful for troubleshooting.<br>
     *  The per-application based SMS control checks sentIntent. If sentIntent
     *  is NULL the caller will be checked against all unknown applications,
     *  which cause smaller number of SMS to be sent in checking period.
     * @param deliveryIntent if not NULL this <code>PendingIntent</code> is
     *  broadcast when the message is delivered to the recipient.  The
     *  raw pdu of the status report is in the extended data ("pdu").
     */
    @DSSink({DSSinkKind.SMS_MMS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:21.950 -0500", hash_original_method = "2CBD208E09A1050F1D8C833305F8E60D", hash_generated_method = "214E2FF2E20EF4CC247E30C5B4CF7CDF")
    
public void sendData(String destAddr, String scAddr, int destPort,
            byte[] data, PendingIntent sentIntent, PendingIntent deliveryIntent) {
        mPhone.getContext().enforceCallingPermission(
                "android.permission.SEND_SMS",
                "Sending SMS message");
        if (Log.isLoggable("SMS", Log.VERBOSE)) {
            log("sendData: destAddr=" + destAddr + " scAddr=" + scAddr + " destPort=" +
                destPort + " data='"+ HexDump.toHexString(data)  + "' sentIntent=" +
                sentIntent + " deliveryIntent=" + deliveryIntent);
        }
        mDispatcher.sendData(destAddr, scAddr, destPort, data, sentIntent, deliveryIntent);
    }

    /**
     * Send a text based SMS.
     *
     * @param destAddr the address to send the message to
     * @param scAddr is the service center address or null to use
     *  the current default SMSC
     * @param text the body of the message to send
     * @param sentIntent if not NULL this <code>PendingIntent</code> is
     *  broadcast when the message is successfully sent, or failed.
     *  The result code will be <code>Activity.RESULT_OK<code> for success,
     *  or one of these errors:<br>
     *  <code>RESULT_ERROR_GENERIC_FAILURE</code><br>
     *  <code>RESULT_ERROR_RADIO_OFF</code><br>
     *  <code>RESULT_ERROR_NULL_PDU</code><br>
     *  For <code>RESULT_ERROR_GENERIC_FAILURE</code> the sentIntent may include
     *  the extra "errorCode" containing a radio technology specific value,
     *  generally only useful for troubleshooting.<br>
     *  The per-application based SMS control checks sentIntent. If sentIntent
     *  is NULL the caller will be checked against all unknown applications,
     *  which cause smaller number of SMS to be sent in checking period.
     * @param deliveryIntent if not NULL this <code>PendingIntent</code> is
     *  broadcast when the message is delivered to the recipient.  The
     *  raw pdu of the status report is in the extended data ("pdu").
     */
    @DSSink({DSSinkKind.SMS_MMS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:21.952 -0500", hash_original_method = "9F601681CEADDF9DEDCDA3A25A2BC5E0", hash_generated_method = "1C7F1D7499FD133B353290818F55D85D")
    
public void sendText(String destAddr, String scAddr,
            String text, PendingIntent sentIntent, PendingIntent deliveryIntent) {
        mPhone.getContext().enforceCallingOrSelfPermission(
                "android.permission.SEND_SMS",
                "Sending SMS message");
        if (Log.isLoggable("SMS", Log.VERBOSE)) {
            log("sendText: destAddr=" + destAddr + " scAddr=" + scAddr +
                " text='"+ text + "' sentIntent=" +
                sentIntent + " deliveryIntent=" + deliveryIntent);
        }
        mDispatcher.sendText(destAddr, scAddr, text, sentIntent, deliveryIntent);
    }

    /**
     * Send a multi-part text based SMS.
     *
     * @param destAddr the address to send the message to
     * @param scAddr is the service center address or null to use
     *   the current default SMSC
     * @param parts an <code>ArrayList</code> of strings that, in order,
     *   comprise the original message
     * @param sentIntents if not null, an <code>ArrayList</code> of
     *   <code>PendingIntent</code>s (one for each message part) that is
     *   broadcast when the corresponding message part has been sent.
     *   The result code will be <code>Activity.RESULT_OK<code> for success,
     *   or one of these errors:
     *   <code>RESULT_ERROR_GENERIC_FAILURE</code>
     *   <code>RESULT_ERROR_RADIO_OFF</code>
     *   <code>RESULT_ERROR_NULL_PDU</code>.
     *  The per-application based SMS control checks sentIntent. If sentIntent
     *  is NULL the caller will be checked against all unknown applications,
     *  which cause smaller number of SMS to be sent in checking period.
     * @param deliveryIntents if not null, an <code>ArrayList</code> of
     *   <code>PendingIntent</code>s (one for each message part) that is
     *   broadcast when the corresponding message part has been delivered
     *   to the recipient.  The raw pdu of the status report is in the
     *   extended data ("pdu").
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:21.956 -0500", hash_original_method = "D9EE0BE48B3A066597B9F477CD500C6B", hash_generated_method = "5EA6231858D31BDB043830FDCC18B744")
    
public void sendMultipartText(String destAddr, String scAddr, List<String> parts,
            List<PendingIntent> sentIntents, List<PendingIntent> deliveryIntents) {
        mPhone.getContext().enforceCallingPermission(
                "android.permission.SEND_SMS",
                "Sending SMS message");
        if (Log.isLoggable("SMS", Log.VERBOSE)) {
            int i = 0;
            for (String part : parts) {
                log("sendMultipartText: destAddr=" + destAddr + ", srAddr=" + scAddr +
                        ", part[" + (i++) + "]=" + part);
            }
        }
        mDispatcher.sendMultipartText(destAddr, scAddr, (ArrayList<String>) parts,
                (ArrayList<PendingIntent>) sentIntents, (ArrayList<PendingIntent>) deliveryIntents);
    }

    /**
     * create SmsRawData lists from all sms record byte[]
     * Use null to indicate "free" record
     *
     * @param messages List of message records from EF_SMS.
     * @return SmsRawData list of all in-used records
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:21.959 -0500", hash_original_method = "26382ED0E59B10B13781F79838E812B0", hash_generated_method = "5DB03524DBBD28AC2186937E3E446110")
    
protected ArrayList<SmsRawData> buildValidRawData(ArrayList<byte[]> messages) {
        int count = messages.size();
        ArrayList<SmsRawData> ret;

        ret = new ArrayList<SmsRawData>(count);

        for (int i = 0; i < count; i++) {
            byte[] ba = messages.get(i);
            if (ba[0] == STATUS_ON_ICC_FREE) {
                ret.add(null);
            } else {
                ret.add(new SmsRawData(messages.get(i)));
            }
        }

        return ret;
    }

    /**
     * Generates an EF_SMS record from status and raw PDU.
     *
     * @param status Message status.  See TS 51.011 10.5.3.
     * @param pdu Raw message PDU.
     * @return byte array for the record.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:21.961 -0500", hash_original_method = "D79D646E773875E9B0C4106E95D311F1", hash_generated_method = "C7D71DE575D67D09C999189F654E7463")
    
protected byte[] makeSmsRecordData(int status, byte[] pdu) {
        byte[] data = new byte[IccConstants.SMS_RECORD_LENGTH];

        // Status bits for this record.  See TS 51.011 10.5.3
        data[0] = (byte)(status & 7);

        System.arraycopy(pdu, 0, data, 1, pdu.length);

        // Pad out with 0xFF's.
        for (int j = pdu.length+1; j < IccConstants.SMS_RECORD_LENGTH; j++) {
            data[j] = -1;
        }

        return data;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:21.964 -0500", hash_original_method = "1B0CB576F4EF5F2EF28DA50D10DF2025", hash_generated_method = "4B0D139DF3381DCA5257214505F38057")
    
protected abstract void log(String msg);
    
}

