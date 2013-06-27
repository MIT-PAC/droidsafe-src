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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.056 -0400", hash_original_field = "8DED1767E2ACBCA09F61DC1D6C7324D2", hash_generated_field = "BA1337E4728FB9F6BD795CF7696F04DE")

    private CommandsInterface mCI;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.056 -0400", hash_original_method = "2BD8C1E6CB98C9A3BA971F52113C7C15", hash_generated_method = "6253F0A4A1A3E88DC85C7C8CF860EEA2")
    public  UsimDataDownloadHandler(CommandsInterface commandsInterface) {
        mCI = commandsInterface;
        // ---------- Original Method ----------
        //mCI = commandsInterface;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.057 -0400", hash_original_method = "59837CA7040CC62FF3A3565A11425127", hash_generated_method = "F9C493F1CEE7879C3342B4342D162BB4")
    public int startDataDownload(SmsMessage smsMessage) {
        {
            boolean var4639B8EA71670A980A468F5191ADFF36_1613339873 = (sendMessage(obtainMessage(EVENT_START_DATA_DOWNLOAD, smsMessage)));
        } //End collapsed parenthetic
        addTaint(smsMessage.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1939041592 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1939041592;
        // ---------- Original Method ----------
        //if (sendMessage(obtainMessage(EVENT_START_DATA_DOWNLOAD, smsMessage))) {
            //return Activity.RESULT_OK;  
        //} else {
            //Log.e(TAG, "startDataDownload failed to send message to start data download.");
            //return Intents.RESULT_SMS_GENERIC_ERROR;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.060 -0400", hash_original_method = "B0FB1A5BEF9BBCC367C24989F3FA51BD", hash_generated_method = "5F81C8CDC0656F39F709A918A79130D9")
    private void handleDataDownload(SmsMessage smsMessage) {
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
        addTaint(smsMessage.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.072 -0400", hash_original_method = "4D0156FCE32C3B62D3099FB0908581D6", hash_generated_method = "56695767B095008447D08B7A2715C001")
    private void sendSmsAckForEnvelopeResponse(IccIoResult response, int dcs, int pid) {
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
            boolean var1BA70DBF1E33EFE9ABE7BE4607F7672F_270056759 = (is7bitDcs(dcs));
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
        addTaint(response.getTaint());
        addTaint(dcs);
        addTaint(pid);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.073 -0400", hash_original_method = "906B533055E100DFA749FD0587281F55", hash_generated_method = "11D07CF0D8772C707C8E9461DCF87D07")
    private void acknowledgeSmsWithError(int cause) {
        mCI.acknowledgeLastIncomingGsmSms(false, cause, null);
        addTaint(cause);
        // ---------- Original Method ----------
        //mCI.acknowledgeLastIncomingGsmSms(false, cause, null);
    }

    
        private static boolean is7bitDcs(int dcs) {
        return ((dcs & 0x8C) == 0x00) || ((dcs & 0xF4) == 0xF0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.073 -0400", hash_original_method = "3D458ABE064DFE8DA418A778447E394C", hash_generated_method = "8C591377BA4ADEC01FEAB60334356B4A")
    @Override
    public void handleMessage(Message msg) {
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
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.092 -0400", hash_original_field = "EE18BF356607786CDE558DFED908CF73", hash_generated_field = "09D5433DA206D4C66FB6D5C518248665")

    private static String TAG = "UsimDataDownloadHandler";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.092 -0400", hash_original_field = "DBBCBD75ED57B144BC3E6B29AE66A9DA", hash_generated_field = "A1763F180677B4E222CCE75A90A3CE0A")

    private static int BER_SMS_PP_DOWNLOAD_TAG = 0xd1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.092 -0400", hash_original_field = "FF522F9795F08E1F1130B741C23CB557", hash_generated_field = "520315B8B74C568C1A0A908391D152B7")

    private static int DEV_ID_UICC = 0x81;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.092 -0400", hash_original_field = "A2BFA57161B3AFF490465A9D4249A75C", hash_generated_field = "EC883D9ECE92BD54EAAE9AF032E41139")

    private static int DEV_ID_NETWORK = 0x83;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.092 -0400", hash_original_field = "DFF63AA4A4BCDD06BBC88FEA5E38C621", hash_generated_field = "30AD7B942E885DD697017BB160F68F53")

    private static int EVENT_START_DATA_DOWNLOAD = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.092 -0400", hash_original_field = "13415B2322E38BB9857866CF3BACC5FA", hash_generated_field = "04B4C27AB8A07AE41937FC6012DCC223")

    private static int EVENT_SEND_ENVELOPE_RESPONSE = 2;
}

