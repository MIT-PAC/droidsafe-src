package com.android.internal.telephony.gsm;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.880 -0400", hash_original_field = "8DED1767E2ACBCA09F61DC1D6C7324D2", hash_generated_field = "BA1337E4728FB9F6BD795CF7696F04DE")

    private CommandsInterface mCI;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.880 -0400", hash_original_method = "2BD8C1E6CB98C9A3BA971F52113C7C15", hash_generated_method = "6253F0A4A1A3E88DC85C7C8CF860EEA2")
    public  UsimDataDownloadHandler(CommandsInterface commandsInterface) {
        mCI = commandsInterface;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.880 -0400", hash_original_method = "59837CA7040CC62FF3A3565A11425127", hash_generated_method = "035A79688436698631178E71B8551E53")
    public int startDataDownload(SmsMessage smsMessage) {
        {
            boolean var4639B8EA71670A980A468F5191ADFF36_2042545960 = (sendMessage(obtainMessage(EVENT_START_DATA_DOWNLOAD, smsMessage)));
        } 
        addTaint(smsMessage.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_301842388 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_301842388;
        
        
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.881 -0400", hash_original_method = "B0FB1A5BEF9BBCC367C24989F3FA51BD", hash_generated_method = "A261048888256AF1C62B555662982B57")
    private void handleDataDownload(SmsMessage smsMessage) {
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
        {
            envelope[index++] = (byte) 0x81;
        } 
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
        } 
        envelope[index++] = (byte) (0x80 | ComprehensionTlvTag.SMS_TPDU.value());
        {
            envelope[index++] = (byte) 0x81;
        } 
        envelope[index++] = (byte) tpduLength;
        System.arraycopy(pdu, tpduIndex, envelope, index, tpduLength);
        index += tpduLength;
        {
            acknowledgeSmsWithError(CommandsInterface.GSM_SMS_FAIL_CAUSE_UNSPECIFIED_ERROR);
        } 
        String encodedEnvelope = IccUtils.bytesToHexString(envelope);
        mCI.sendEnvelopeWithStatus(encodedEnvelope, obtainMessage(
                EVENT_SEND_ENVELOPE_RESPONSE, new int[]{ dcs, pid }));
        addTaint(smsMessage.getTaint());
        
        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.883 -0400", hash_original_method = "4D0156FCE32C3B62D3099FB0908581D6", hash_generated_method = "23A77682A45902935809FA808C2396ED")
    private void sendSmsAckForEnvelopeResponse(IccIoResult response, int dcs, int pid) {
        int sw1 = response.sw1;
        int sw2 = response.sw2;
        boolean success;
        {
            Log.d(TAG, "USIM data download succeeded: " + response.toString());
            success = true;
        } 
        {
            acknowledgeSmsWithError(CommandsInterface.GSM_SMS_FAIL_CAUSE_USIM_APP_TOOLKIT_BUSY);
        } 
        {
            success = false;
        } 
        {
            success = false;
        } 
        byte[] responseBytes = response.payload;
        {
            {
                mCI.acknowledgeLastIncomingGsmSms(true, 0, null);
            } 
            {
                acknowledgeSmsWithError(
                        CommandsInterface.GSM_SMS_FAIL_CAUSE_USIM_DATA_DOWNLOAD_ERROR);
            } 
        } 
        byte[] smsAckPdu;
        int index = 0;
        {
            smsAckPdu = new byte[responseBytes.length + 5];
            smsAckPdu[index++] = 0x00;
            smsAckPdu[index++] = 0x07;
        } 
        {
            smsAckPdu = new byte[responseBytes.length + 6];
            smsAckPdu[index++] = 0x00;
            smsAckPdu[index++] = (byte)
                    CommandsInterface.GSM_SMS_FAIL_CAUSE_USIM_DATA_DOWNLOAD_ERROR;
            smsAckPdu[index++] = 0x07;
        } 
        smsAckPdu[index++] = (byte) pid;
        smsAckPdu[index++] = (byte) dcs;
        {
            boolean var1BA70DBF1E33EFE9ABE7BE4607F7672F_925992896 = (is7bitDcs(dcs));
            {
                int septetCount = responseBytes.length * 8 / 7;
                smsAckPdu[index++] = (byte) septetCount;
            } 
            {
                smsAckPdu[index++] = (byte) responseBytes.length;
            } 
        } 
        System.arraycopy(responseBytes, 0, smsAckPdu, index, responseBytes.length);
        mCI.acknowledgeIncomingGsmSmsWithPdu(success,
                IccUtils.bytesToHexString(smsAckPdu), null);
        addTaint(response.getTaint());
        addTaint(dcs);
        addTaint(pid);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.884 -0400", hash_original_method = "906B533055E100DFA749FD0587281F55", hash_generated_method = "11D07CF0D8772C707C8E9461DCF87D07")
    private void acknowledgeSmsWithError(int cause) {
        mCI.acknowledgeLastIncomingGsmSms(false, cause, null);
        addTaint(cause);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean is7bitDcs(int dcs) {
        return ((dcs & 0x8C) == 0x00) || ((dcs & 0xF4) == 0xF0);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.885 -0400", hash_original_method = "3D458ABE064DFE8DA418A778447E394C", hash_generated_method = "BAA1863882F72FFC80B21ADF3BB41EF0")
    @Override
    public void handleMessage(Message msg) {
        
        handleDataDownload((SmsMessage) msg.obj);
        
        
        AsyncResult ar = (AsyncResult) msg.obj;
        
        
        {
            acknowledgeSmsWithError(
                            CommandsInterface.GSM_SMS_FAIL_CAUSE_USIM_DATA_DOWNLOAD_ERROR);
        } 
        
        
        int[] dcsPid = (int[]) ar.userObj;
        
        
        sendSmsAckForEnvelopeResponse((IccIoResult) ar.result, dcsPid[0], dcsPid[1]);
        
        addTaint(msg.getTaint());
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.885 -0400", hash_original_field = "EE18BF356607786CDE558DFED908CF73", hash_generated_field = "B2E07BF7BD34CBD8ED21A89747D9D3D2")

    private static final String TAG = "UsimDataDownloadHandler";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.885 -0400", hash_original_field = "DBBCBD75ED57B144BC3E6B29AE66A9DA", hash_generated_field = "A92B4C35F8E20622970FFC8EF6375C2B")

    private static final int BER_SMS_PP_DOWNLOAD_TAG = 0xd1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.885 -0400", hash_original_field = "FF522F9795F08E1F1130B741C23CB557", hash_generated_field = "B0B4E321690DD56DB0A3650FB64A8E74")

    private static final int DEV_ID_UICC = 0x81;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.885 -0400", hash_original_field = "A2BFA57161B3AFF490465A9D4249A75C", hash_generated_field = "A4537B62A3FF2B04B6AE0CFC11651C24")

    private static final int DEV_ID_NETWORK = 0x83;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.885 -0400", hash_original_field = "DFF63AA4A4BCDD06BBC88FEA5E38C621", hash_generated_field = "2D105F45E630980C460A44407CEAD8C4")

    private static final int EVENT_START_DATA_DOWNLOAD = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.885 -0400", hash_original_field = "13415B2322E38BB9857866CF3BACC5FA", hash_generated_field = "F607F76513DC72A51732EF8C2B9ADF36")

    private static final int EVENT_SEND_ENVELOPE_RESPONSE = 2;
}

