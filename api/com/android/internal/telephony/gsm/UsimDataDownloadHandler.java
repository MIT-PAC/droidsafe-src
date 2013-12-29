package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.app.Activity;
import android.os.AsyncResult;
import android.os.Handler;
import android.os.Message;
import android.provider.Telephony.Sms.Intents;
import android.util.Log;

import com.android.internal.telephony.CommandsInterface;
import com.android.internal.telephony.IccIoResult;
import com.android.internal.telephony.IccUtils;
import com.android.internal.telephony.cat.ComprehensionTlvTag;






public class UsimDataDownloadHandler extends Handler {

    /**
     * Return the size in bytes of the envelope to send to the UICC, excluding the
     * SMS-PP download tag byte and length byte(s). If the size returned is <= 127,
     * the BER-TLV length will be encoded in 1 byte, otherwise 2 bytes are required.
     *
     * @param scAddressLength the length of the SMSC address, or zero if not present
     * @param tpduLength the length of the TPDU from the SMS-PP message
     * @return the number of bytes to allocate for the envelope command
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:09.028 -0500", hash_original_method = "8E06EDD4AB6FEF826893E1C60C4B92E0", hash_generated_method = "619B5414EB99F1F8961CE461B6A9B802")
    private static int getEnvelopeBodyLength(int scAddressLength, int tpduLength) {
        // Add 4 bytes for device identities TLV + 1 byte for SMS TPDU tag byte
        int length = tpduLength + 5;
        // Add 1 byte for TPDU length, or 2 bytes if length > 127
        length += (tpduLength > 127 ? 2 : 1);
        // Add length of address tag, if present (+ 2 bytes for tag and length)
        if (scAddressLength != 0) {
            length = length + 2 + scAddressLength;
        }
        return length;
    }

    /**
     * Returns whether the DCS is 7 bit. If so, set TP-UDL to the septet count of TP-UD;
     * otherwise, set TP-UDL to the octet count of TP-UD.
     * @param dcs the TP-Data-Coding-Scheme field from the original download SMS
     * @return true if the DCS specifies 7 bit encoding; false otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:09.031 -0500", hash_original_method = "6AC69FAB0F79D0D17493B5AE3A868686", hash_generated_method = "4039ABFF0D42614771CF6ADECC95A827")
    private static boolean is7bitDcs(int dcs) {
        // See 3GPP TS 23.038 section 4
        return ((dcs & 0x8C) == 0x00) || ((dcs & 0xF4) == 0xF0);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:09.019 -0500", hash_original_field = "E8D518FC09A35A8324CE61F8B3A5EE68", hash_generated_field = "B2E07BF7BD34CBD8ED21A89747D9D3D2")

    private static final String TAG = "UsimDataDownloadHandler";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:09.020 -0500", hash_original_field = "230DDA02485771E392DB0CD8616521DD", hash_generated_field = "A92B4C35F8E20622970FFC8EF6375C2B")

    private static final int BER_SMS_PP_DOWNLOAD_TAG      = 0xd1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:09.021 -0500", hash_original_field = "60C9B4D7334D5174AAEECF0D21B3C28F", hash_generated_field = "B0B4E321690DD56DB0A3650FB64A8E74")

    private static final int DEV_ID_UICC        = 0x81;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:09.021 -0500", hash_original_field = "B5C3D8418ABB4B3F2C746403102418EB", hash_generated_field = "A4537B62A3FF2B04B6AE0CFC11651C24")

    private static final int DEV_ID_NETWORK     = 0x83;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:09.022 -0500", hash_original_field = "35596610FBD3332C0041EE2D97DA0B11", hash_generated_field = "2D105F45E630980C460A44407CEAD8C4")

    private static final int EVENT_START_DATA_DOWNLOAD = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:09.023 -0500", hash_original_field = "F7AA238BB7A05B905287C8A8BD491367", hash_generated_field = "F607F76513DC72A51732EF8C2B9ADF36")

    private static final int EVENT_SEND_ENVELOPE_RESPONSE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:09.024 -0500", hash_original_field = "E21447DC33A25D2D4C7CF7D97EC4FA16", hash_generated_field = "BA1337E4728FB9F6BD795CF7696F04DE")


    private  CommandsInterface mCI;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:09.025 -0500", hash_original_method = "2BD8C1E6CB98C9A3BA971F52113C7C15", hash_generated_method = "33FE76F42A6CC5E011BA3D6F81B073B5")
    public UsimDataDownloadHandler(CommandsInterface commandsInterface) {
        mCI = commandsInterface;
    }

    /**
     * Start an SMS-PP data download for the specified message. Can be called from a different
     * thread than this Handler is running on.
     *
     * @param smsMessage the message to process
     * @return Activity.RESULT_OK on success; Intents.RESULT_SMS_GENERIC_ERROR on failure
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:09.026 -0500", hash_original_method = "59837CA7040CC62FF3A3565A11425127", hash_generated_method = "885A3F0ED409E93D0630E978F4CF01F0")
    public int startDataDownload(SmsMessage smsMessage) {
        if (sendMessage(obtainMessage(EVENT_START_DATA_DOWNLOAD, smsMessage))) {
            return Activity.RESULT_OK;  // we will send SMS ACK/ERROR based on UICC response
        } else {
            Log.e(TAG, "startDataDownload failed to send message to start data download.");
            return Intents.RESULT_SMS_GENERIC_ERROR;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:09.028 -0500", hash_original_method = "B0FB1A5BEF9BBCC367C24989F3FA51BD", hash_generated_method = "8BC3F49B49EF9CA50B42AEC5AB2E0E63")
    private void handleDataDownload(SmsMessage smsMessage) {
        int dcs = smsMessage.getDataCodingScheme();
        int pid = smsMessage.getProtocolIdentifier();
        byte[] pdu = smsMessage.getPdu();           // includes SC address

        int scAddressLength = pdu[0] & 0xff;
        int tpduIndex = scAddressLength + 1;        // start of TPDU
        int tpduLength = pdu.length - tpduIndex;

        int bodyLength = getEnvelopeBodyLength(scAddressLength, tpduLength);

        // Add 1 byte for SMS-PP download tag and 1-2 bytes for BER-TLV length.
        // See ETSI TS 102 223 Annex C for encoding of length and tags.
        int totalLength = bodyLength + 1 + (bodyLength > 127 ? 2 : 1);

        byte[] envelope = new byte[totalLength];
        int index = 0;

        // SMS-PP download tag and length (assumed to be < 256 bytes).
        envelope[index++] = (byte) BER_SMS_PP_DOWNLOAD_TAG;
        if (bodyLength > 127) {
            envelope[index++] = (byte) 0x81;    // length 128-255 encoded as 0x81 + length
        }
        envelope[index++] = (byte) bodyLength;

        // Device identities TLV
        envelope[index++] = (byte) (0x80 | ComprehensionTlvTag.DEVICE_IDENTITIES.value());
        envelope[index++] = (byte) 2;
        envelope[index++] = (byte) DEV_ID_NETWORK;
        envelope[index++] = (byte) DEV_ID_UICC;

        // Address TLV (if present). Encoded length is assumed to be < 127 bytes.
        if (scAddressLength != 0) {
            envelope[index++] = (byte) ComprehensionTlvTag.ADDRESS.value();
            envelope[index++] = (byte) scAddressLength;
            System.arraycopy(pdu, 1, envelope, index, scAddressLength);
            index += scAddressLength;
        }

        // SMS TPDU TLV. Length is assumed to be < 256 bytes.
        envelope[index++] = (byte) (0x80 | ComprehensionTlvTag.SMS_TPDU.value());
        if (tpduLength > 127) {
            envelope[index++] = (byte) 0x81;    // length 128-255 encoded as 0x81 + length
        }
        envelope[index++] = (byte) tpduLength;
        System.arraycopy(pdu, tpduIndex, envelope, index, tpduLength);
        index += tpduLength;

        // Verify that we calculated the payload size correctly.
        if (index != envelope.length) {
            Log.e(TAG, "startDataDownload() calculated incorrect envelope length, aborting.");
            acknowledgeSmsWithError(CommandsInterface.GSM_SMS_FAIL_CAUSE_UNSPECIFIED_ERROR);
            return;
        }

        String encodedEnvelope = IccUtils.bytesToHexString(envelope);
        mCI.sendEnvelopeWithStatus(encodedEnvelope, obtainMessage(
                EVENT_SEND_ENVELOPE_RESPONSE, new int[]{ dcs, pid }));
    }

    /**
     * Handle the response to the ENVELOPE command.
     * @param response UICC response encoded as hexadecimal digits. First two bytes are the
     *  UICC SW1 and SW2 status bytes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:09.030 -0500", hash_original_method = "4D0156FCE32C3B62D3099FB0908581D6", hash_generated_method = "1B3832723BC3034606D499CCE41B0CA4")
    private void sendSmsAckForEnvelopeResponse(IccIoResult response, int dcs, int pid) {
        int sw1 = response.sw1;
        int sw2 = response.sw2;

        boolean success;
        if ((sw1 == 0x90 && sw2 == 0x00) || sw1 == 0x91) {
            Log.d(TAG, "USIM data download succeeded: " + response.toString());
            success = true;
        } else if (sw1 == 0x93 && sw2 == 0x00) {
            Log.e(TAG, "USIM data download failed: Toolkit busy");
            acknowledgeSmsWithError(CommandsInterface.GSM_SMS_FAIL_CAUSE_USIM_APP_TOOLKIT_BUSY);
            return;
        } else if (sw1 == 0x62 || sw1 == 0x63) {
            Log.e(TAG, "USIM data download failed: " + response.toString());
            success = false;
        } else {
            Log.e(TAG, "Unexpected SW1/SW2 response from UICC: " + response.toString());
            success = false;
        }

        byte[] responseBytes = response.payload;
        if (responseBytes == null || responseBytes.length == 0) {
            if (success) {
                mCI.acknowledgeLastIncomingGsmSms(true, 0, null);
            } else {
                acknowledgeSmsWithError(
                        CommandsInterface.GSM_SMS_FAIL_CAUSE_USIM_DATA_DOWNLOAD_ERROR);
            }
            return;
        }

        byte[] smsAckPdu;
        int index = 0;
        if (success) {
            smsAckPdu = new byte[responseBytes.length + 5];
            smsAckPdu[index++] = 0x00;      // TP-MTI, TP-UDHI
            smsAckPdu[index++] = 0x07;      // TP-PI: TP-PID, TP-DCS, TP-UDL present
        } else {
            smsAckPdu = new byte[responseBytes.length + 6];
            smsAckPdu[index++] = 0x00;      // TP-MTI, TP-UDHI
            smsAckPdu[index++] = (byte)
                    CommandsInterface.GSM_SMS_FAIL_CAUSE_USIM_DATA_DOWNLOAD_ERROR;  // TP-FCS
            smsAckPdu[index++] = 0x07;      // TP-PI: TP-PID, TP-DCS, TP-UDL present
        }

        smsAckPdu[index++] = (byte) pid;
        smsAckPdu[index++] = (byte) dcs;

        if (is7bitDcs(dcs)) {
            int septetCount = responseBytes.length * 8 / 7;
            smsAckPdu[index++] = (byte) septetCount;
        } else {
            smsAckPdu[index++] = (byte) responseBytes.length;
        }

        System.arraycopy(responseBytes, 0, smsAckPdu, index, responseBytes.length);

        mCI.acknowledgeIncomingGsmSmsWithPdu(success,
                IccUtils.bytesToHexString(smsAckPdu), null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:09.031 -0500", hash_original_method = "906B533055E100DFA749FD0587281F55", hash_generated_method = "007D4DD9D3C9DC7502F5A6EA63BC10C0")
    private void acknowledgeSmsWithError(int cause) {
        mCI.acknowledgeLastIncomingGsmSms(false, cause, null);
    }

    /**
     * Handle UICC envelope response and send SMS acknowledgement.
     *
     * @param msg the message to handle
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:09.032 -0500", hash_original_method = "3D458ABE064DFE8DA418A778447E394C", hash_generated_method = "A6014E5EB851F86E973CE76A92443A99")
    @Override
public void handleMessage(Message msg) {
        switch (msg.what) {
            case EVENT_START_DATA_DOWNLOAD:
                handleDataDownload((SmsMessage) msg.obj);
                break;

            case EVENT_SEND_ENVELOPE_RESPONSE:
                AsyncResult ar = (AsyncResult) msg.obj;

                if (ar.exception != null) {
                    Log.e(TAG, "UICC Send Envelope failure, exception: " + ar.exception);
                    acknowledgeSmsWithError(
                            CommandsInterface.GSM_SMS_FAIL_CAUSE_USIM_DATA_DOWNLOAD_ERROR);
                    return;
                }

                int[] dcsPid = (int[]) ar.userObj;
                sendSmsAckForEnvelopeResponse((IccIoResult) ar.result, dcsPid[0], dcsPid[1]);
                break;

            default:
                Log.e(TAG, "Ignoring unexpected message, what=" + msg.what);
        }
    }
}

