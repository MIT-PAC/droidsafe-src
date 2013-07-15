package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.910 -0400", hash_original_field = "8DED1767E2ACBCA09F61DC1D6C7324D2", hash_generated_field = "BA1337E4728FB9F6BD795CF7696F04DE")

    private CommandsInterface mCI;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.910 -0400", hash_original_method = "2BD8C1E6CB98C9A3BA971F52113C7C15", hash_generated_method = "6253F0A4A1A3E88DC85C7C8CF860EEA2")
    public  UsimDataDownloadHandler(CommandsInterface commandsInterface) {
        mCI = commandsInterface;
        // ---------- Original Method ----------
        //mCI = commandsInterface;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.910 -0400", hash_original_method = "59837CA7040CC62FF3A3565A11425127", hash_generated_method = "E3FC7F02BDCBDFD18F01748A56DB080D")
    public int startDataDownload(SmsMessage smsMessage) {
        addTaint(smsMessage.getTaint());
    if(sendMessage(obtainMessage(EVENT_START_DATA_DOWNLOAD, smsMessage)))        
        {
            int var4C0737507AD994723C875A6D0646D112_330003604 = (Activity.RESULT_OK);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1369437100 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1369437100;
        } //End block
        else
        {
            int varFCC16322707A95E5743FED9CA64177EC_556904359 = (Intents.RESULT_SMS_GENERIC_ERROR);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_282175506 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_282175506;
        } //End block
        // ---------- Original Method ----------
        //if (sendMessage(obtainMessage(EVENT_START_DATA_DOWNLOAD, smsMessage))) {
            //return Activity.RESULT_OK;  
        //} else {
            //Log.e(TAG, "startDataDownload failed to send message to start data download.");
            //return Intents.RESULT_SMS_GENERIC_ERROR;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.913 -0400", hash_original_method = "B0FB1A5BEF9BBCC367C24989F3FA51BD", hash_generated_method = "14CA98D062CB5FF3653C01E66A9BE9AB")
    private void handleDataDownload(SmsMessage smsMessage) {
        addTaint(smsMessage.getTaint());
        int dcs = smsMessage.getDataCodingScheme();
        int pid = smsMessage.getProtocolIdentifier();
        byte[] pdu = smsMessage.getPdu();
        int scAddressLength = pdu[0] & 0xff;
        int tpduIndex = scAddressLength + 1;
        int tpduLength = pdu.length - tpduIndex;
        int bodyLength = getEnvelopeBodyLength(scAddressLength, tpduLength);
        int totalLength = bodyLength + 1 + (bodyLength > 127 ? 2 : 1);
        byte[] envelope = new byte[totalLength];
        int index = 0;
        envelope[index++] = (byte) BER_SMS_PP_DOWNLOAD_TAG;
    if(bodyLength > 127)        
        {
            envelope[index++] = (byte) 0x81;
        } //End block
        envelope[index++] = (byte) bodyLength;
        envelope[index++] = (byte) (0x80 | ComprehensionTlvTag.DEVICE_IDENTITIES.value());
        envelope[index++] = (byte) 2;
        envelope[index++] = (byte) DEV_ID_NETWORK;
        envelope[index++] = (byte) DEV_ID_UICC;
    if(scAddressLength != 0)        
        {
            envelope[index++] = (byte) ComprehensionTlvTag.ADDRESS.value();
            envelope[index++] = (byte) scAddressLength;
            System.arraycopy(pdu, 1, envelope, index, scAddressLength);
            index += scAddressLength;
        } //End block
        envelope[index++] = (byte) (0x80 | ComprehensionTlvTag.SMS_TPDU.value());
    if(tpduLength > 127)        
        {
            envelope[index++] = (byte) 0x81;
        } //End block
        envelope[index++] = (byte) tpduLength;
        System.arraycopy(pdu, tpduIndex, envelope, index, tpduLength);
        index += tpduLength;
    if(index != envelope.length)        
        {
            acknowledgeSmsWithError(CommandsInterface.GSM_SMS_FAIL_CAUSE_UNSPECIFIED_ERROR);
            return;
        } //End block
        String encodedEnvelope = IccUtils.bytesToHexString(envelope);
        mCI.sendEnvelopeWithStatus(encodedEnvelope, obtainMessage(
                EVENT_SEND_ENVELOPE_RESPONSE, new int[]{ dcs, pid }));
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
    private static int getEnvelopeBodyLength(int scAddressLength, int tpduLength) {
        int length = tpduLength + 5;
        length += (tpduLength > 127 ? 2 : 1);
        if (scAddressLength != 0) {
            length = length + 2 + scAddressLength;
        }
        return length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.917 -0400", hash_original_method = "4D0156FCE32C3B62D3099FB0908581D6", hash_generated_method = "6F8A18DCA271D31BDC7A81C6D318B86A")
    private void sendSmsAckForEnvelopeResponse(IccIoResult response, int dcs, int pid) {
        addTaint(pid);
        addTaint(dcs);
        addTaint(response.getTaint());
        int sw1 = response.sw1;
        int sw2 = response.sw2;
        boolean success;
    if((sw1 == 0x90 && sw2 == 0x00) || sw1 == 0x91)        
        {
            Log.d(TAG, "USIM data download succeeded: " + response.toString());
            success = true;
        } //End block
        else
    if(sw1 == 0x93 && sw2 == 0x00)        
        {
            acknowledgeSmsWithError(CommandsInterface.GSM_SMS_FAIL_CAUSE_USIM_APP_TOOLKIT_BUSY);
            return;
        } //End block
        else
    if(sw1 == 0x62 || sw1 == 0x63)        
        {
            success = false;
        } //End block
        else
        {
            success = false;
        } //End block
        byte[] responseBytes = response.payload;
    if(responseBytes == null || responseBytes.length == 0)        
        {
    if(success)            
            {
                mCI.acknowledgeLastIncomingGsmSms(true, 0, null);
            } //End block
            else
            {
                acknowledgeSmsWithError(
                        CommandsInterface.GSM_SMS_FAIL_CAUSE_USIM_DATA_DOWNLOAD_ERROR);
            } //End block
            return;
        } //End block
        byte[] smsAckPdu;
        int index = 0;
    if(success)        
        {
            smsAckPdu = new byte[responseBytes.length + 5];
            smsAckPdu[index++] = 0x00;
            smsAckPdu[index++] = 0x07;
        } //End block
        else
        {
            smsAckPdu = new byte[responseBytes.length + 6];
            smsAckPdu[index++] = 0x00;
            smsAckPdu[index++] = (byte)
                    CommandsInterface.GSM_SMS_FAIL_CAUSE_USIM_DATA_DOWNLOAD_ERROR;
            smsAckPdu[index++] = 0x07;
        } //End block
        smsAckPdu[index++] = (byte) pid;
        smsAckPdu[index++] = (byte) dcs;
    if(is7bitDcs(dcs))        
        {
            int septetCount = responseBytes.length * 8 / 7;
            smsAckPdu[index++] = (byte) septetCount;
        } //End block
        else
        {
            smsAckPdu[index++] = (byte) responseBytes.length;
        } //End block
        System.arraycopy(responseBytes, 0, smsAckPdu, index, responseBytes.length);
        mCI.acknowledgeIncomingGsmSmsWithPdu(success,
                IccUtils.bytesToHexString(smsAckPdu), null);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.919 -0400", hash_original_method = "906B533055E100DFA749FD0587281F55", hash_generated_method = "15DB38CEE7D6B7D886C8F91F0944A93D")
    private void acknowledgeSmsWithError(int cause) {
        addTaint(cause);
        mCI.acknowledgeLastIncomingGsmSms(false, cause, null);
        // ---------- Original Method ----------
        //mCI.acknowledgeLastIncomingGsmSms(false, cause, null);
    }

    
        @DSModeled(DSC.SAFE)
    private static boolean is7bitDcs(int dcs) {
        return ((dcs & 0x8C) == 0x00) || ((dcs & 0xF4) == 0xF0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.920 -0400", hash_original_method = "3D458ABE064DFE8DA418A778447E394C", hash_generated_method = "D0064A43B7E5939A0DCA4624F9D09FCA")
    @Override
    public void handleMessage(Message msg) {
        addTaint(msg.getTaint());
switch(msg.what){
        case EVENT_START_DATA_DOWNLOAD:
        handleDataDownload((SmsMessage) msg.obj);
        break;
        case EVENT_SEND_ENVELOPE_RESPONSE:
        AsyncResult ar = (AsyncResult) msg.obj;
    if(ar.exception != null)        
        {
            acknowledgeSmsWithError(
                            CommandsInterface.GSM_SMS_FAIL_CAUSE_USIM_DATA_DOWNLOAD_ERROR);
            return;
        } //End block
        int[] dcsPid = (int[]) ar.userObj;
        sendSmsAckForEnvelopeResponse((IccIoResult) ar.result, dcsPid[0], dcsPid[1]);
        break;
        default:
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.921 -0400", hash_original_field = "EE18BF356607786CDE558DFED908CF73", hash_generated_field = "B2E07BF7BD34CBD8ED21A89747D9D3D2")

    private static final String TAG = "UsimDataDownloadHandler";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.921 -0400", hash_original_field = "DBBCBD75ED57B144BC3E6B29AE66A9DA", hash_generated_field = "A92B4C35F8E20622970FFC8EF6375C2B")

    private static final int BER_SMS_PP_DOWNLOAD_TAG = 0xd1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.921 -0400", hash_original_field = "FF522F9795F08E1F1130B741C23CB557", hash_generated_field = "B0B4E321690DD56DB0A3650FB64A8E74")

    private static final int DEV_ID_UICC = 0x81;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.921 -0400", hash_original_field = "A2BFA57161B3AFF490465A9D4249A75C", hash_generated_field = "A4537B62A3FF2B04B6AE0CFC11651C24")

    private static final int DEV_ID_NETWORK = 0x83;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.921 -0400", hash_original_field = "DFF63AA4A4BCDD06BBC88FEA5E38C621", hash_generated_field = "2D105F45E630980C460A44407CEAD8C4")

    private static final int EVENT_START_DATA_DOWNLOAD = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.921 -0400", hash_original_field = "13415B2322E38BB9857866CF3BACC5FA", hash_generated_field = "F607F76513DC72A51732EF8C2B9ADF36")

    private static final int EVENT_SEND_ENVELOPE_RESPONSE = 2;
}

