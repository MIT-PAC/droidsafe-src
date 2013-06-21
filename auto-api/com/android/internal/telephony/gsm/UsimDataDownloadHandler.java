package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    private CommandsInterface mCI;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.011 -0400", hash_original_method = "2BD8C1E6CB98C9A3BA971F52113C7C15", hash_generated_method = "4D150BC432605DE58B35375D471DA002")
    @DSModeled(DSC.SAFE)
    public UsimDataDownloadHandler(CommandsInterface commandsInterface) {
        dsTaint.addTaint(commandsInterface.dsTaint);
        // ---------- Original Method ----------
        //mCI = commandsInterface;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.012 -0400", hash_original_method = "59837CA7040CC62FF3A3565A11425127", hash_generated_method = "165F3F9EBA38DEEB6395FCF5478DA6A6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int startDataDownload(SmsMessage smsMessage) {
        dsTaint.addTaint(smsMessage.dsTaint);
        {
            boolean var4639B8EA71670A980A468F5191ADFF36_27727252 = (sendMessage(obtainMessage(EVENT_START_DATA_DOWNLOAD, smsMessage)));
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (sendMessage(obtainMessage(EVENT_START_DATA_DOWNLOAD, smsMessage))) {
            //return Activity.RESULT_OK;  
        //} else {
            //Log.e(TAG, "startDataDownload failed to send message to start data download.");
            //return Intents.RESULT_SMS_GENERIC_ERROR;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.012 -0400", hash_original_method = "B0FB1A5BEF9BBCC367C24989F3FA51BD", hash_generated_method = "1B1D95B65AC95EFE084ECFE52994996C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void handleDataDownload(SmsMessage smsMessage) {
        dsTaint.addTaint(smsMessage.dsTaint);
        int dcs;
        dcs = smsMessage.getDataCodingScheme();
        int pid;
        pid = smsMessage.getProtocolIdentifier();
        byte[] pdu;
        pdu = smsMessage.getPdu();
        int scAddressLength;
        scAddressLength = pdu[0] & 0xff;
        int tpduIndex;
        tpduIndex = scAddressLength + 1;
        int tpduLength;
        tpduLength = pdu.length - tpduIndex;
        int bodyLength;
        bodyLength = getEnvelopeBodyLength(scAddressLength, tpduLength);
        int totalLength;
        totalLength = bodyLength + 1 + (bodyLength > 127 ? 2 : 1);//DSFIXME:  CODE0008: Nested ternary operator in expression
        byte[] envelope;
        envelope = new byte[totalLength];
        int index;
        index = 0;
        envelope[index++] = (byte) BER_SMS_PP_DOWNLOAD_TAG;
        {
            envelope[index++] = (byte) 0x81;
        } //End block
        envelope[index++] = (byte) bodyLength;
        envelope[index++] = (byte) (0x80 | ComprehensionTlvTag.DEVICE_IDENTITIES.value());
        envelope[index++] = (byte) 2;
        envelope[index++] = (byte) DEV_ID_NETWORK;
        envelope[index++] = (byte) DEV_ID_UICC;
        {
            envelope[index++] = (byte) ComprehensionTlvTag.ADDRESS.value();
            envelope[index++] = (byte) scAddressLength;
            System.arraycopy(pdu, 1, envelope, index, scAddressLength);
            index += scAddressLength;
        } //End block
        envelope[index++] = (byte) (0x80 | ComprehensionTlvTag.SMS_TPDU.value());
        {
            envelope[index++] = (byte) 0x81;
        } //End block
        envelope[index++] = (byte) tpduLength;
        System.arraycopy(pdu, tpduIndex, envelope, index, tpduLength);
        index += tpduLength;
        {
            acknowledgeSmsWithError(CommandsInterface.GSM_SMS_FAIL_CAUSE_UNSPECIFIED_ERROR);
        } //End block
        String encodedEnvelope;
        encodedEnvelope = IccUtils.bytesToHexString(envelope);
        mCI.sendEnvelopeWithStatus(encodedEnvelope, obtainMessage(
                EVENT_SEND_ENVELOPE_RESPONSE, new int[]{ dcs, pid }));
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        private static int getEnvelopeBodyLength(int scAddressLength, int tpduLength) {
        int length = tpduLength + 5;
        length += (tpduLength > 127 ? 2 : 1);
        if (scAddressLength != 0) {
            length = length + 2 + scAddressLength;
        }
        return length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.013 -0400", hash_original_method = "4D0156FCE32C3B62D3099FB0908581D6", hash_generated_method = "22EE56AB6CEAFE47088AB4E6B80A25FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void sendSmsAckForEnvelopeResponse(IccIoResult response, int dcs, int pid) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(dcs);
        dsTaint.addTaint(pid);
        int sw1;
        sw1 = response.sw1;
        int sw2;
        sw2 = response.sw2;
        boolean success;
        {
            Log.d(TAG, "USIM data download succeeded: " + response.toString());
            success = true;
        } //End block
        {
            acknowledgeSmsWithError(CommandsInterface.GSM_SMS_FAIL_CAUSE_USIM_APP_TOOLKIT_BUSY);
        } //End block
        {
            success = false;
        } //End block
        {
            success = false;
        } //End block
        byte[] responseBytes;
        responseBytes = response.payload;
        {
            {
                mCI.acknowledgeLastIncomingGsmSms(true, 0, null);
            } //End block
            {
                acknowledgeSmsWithError(
                        CommandsInterface.GSM_SMS_FAIL_CAUSE_USIM_DATA_DOWNLOAD_ERROR);
            } //End block
        } //End block
        byte[] smsAckPdu;
        int index;
        index = 0;
        {
            smsAckPdu = new byte[responseBytes.length + 5];
            smsAckPdu[index++] = 0x00;
            smsAckPdu[index++] = 0x07;
        } //End block
        {
            smsAckPdu = new byte[responseBytes.length + 6];
            smsAckPdu[index++] = 0x00;
            smsAckPdu[index++] = (byte)
                    CommandsInterface.GSM_SMS_FAIL_CAUSE_USIM_DATA_DOWNLOAD_ERROR;
            smsAckPdu[index++] = 0x07;
        } //End block
        smsAckPdu[index++] = (byte) pid;
        smsAckPdu[index++] = (byte) dcs;
        {
            boolean var1BA70DBF1E33EFE9ABE7BE4607F7672F_235446314 = (is7bitDcs(dcs));
            {
                int septetCount;
                septetCount = responseBytes.length * 8 / 7;
                smsAckPdu[index++] = (byte) septetCount;
            } //End block
            {
                smsAckPdu[index++] = (byte) responseBytes.length;
            } //End block
        } //End collapsed parenthetic
        System.arraycopy(responseBytes, 0, smsAckPdu, index, responseBytes.length);
        mCI.acknowledgeIncomingGsmSmsWithPdu(success,
                IccUtils.bytesToHexString(smsAckPdu), null);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.014 -0400", hash_original_method = "906B533055E100DFA749FD0587281F55", hash_generated_method = "55C2BBAEF7493F02F520ED711EA2C8B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void acknowledgeSmsWithError(int cause) {
        dsTaint.addTaint(cause);
        mCI.acknowledgeLastIncomingGsmSms(false, cause, null);
        // ---------- Original Method ----------
        //mCI.acknowledgeLastIncomingGsmSms(false, cause, null);
    }

    
        private static boolean is7bitDcs(int dcs) {
        return ((dcs & 0x8C) == 0x00) || ((dcs & 0xF4) == 0xF0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.014 -0400", hash_original_method = "3D458ABE064DFE8DA418A778447E394C", hash_generated_method = "32F109329886873DF2C3A279D3013576")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void handleMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        //Begin case EVENT_START_DATA_DOWNLOAD 
        handleDataDownload((SmsMessage) msg.obj);
        //End case EVENT_START_DATA_DOWNLOAD 
        //Begin case EVENT_SEND_ENVELOPE_RESPONSE 
        AsyncResult ar;
        ar = (AsyncResult) msg.obj;
        //End case EVENT_SEND_ENVELOPE_RESPONSE 
        //Begin case EVENT_SEND_ENVELOPE_RESPONSE 
        {
            acknowledgeSmsWithError(
                            CommandsInterface.GSM_SMS_FAIL_CAUSE_USIM_DATA_DOWNLOAD_ERROR);
        } //End block
        //End case EVENT_SEND_ENVELOPE_RESPONSE 
        //Begin case EVENT_SEND_ENVELOPE_RESPONSE 
        int[] dcsPid;
        dcsPid = (int[]) ar.userObj;
        //End case EVENT_SEND_ENVELOPE_RESPONSE 
        //Begin case EVENT_SEND_ENVELOPE_RESPONSE 
        sendSmsAckForEnvelopeResponse((IccIoResult) ar.result, dcsPid[0], dcsPid[1]);
        //End case EVENT_SEND_ENVELOPE_RESPONSE 
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static final String TAG = "UsimDataDownloadHandler";
    private static final int BER_SMS_PP_DOWNLOAD_TAG      = 0xd1;
    private static final int DEV_ID_UICC        = 0x81;
    private static final int DEV_ID_NETWORK     = 0x83;
    private static final int EVENT_START_DATA_DOWNLOAD = 1;
    private static final int EVENT_SEND_ENVELOPE_RESPONSE = 2;
}

