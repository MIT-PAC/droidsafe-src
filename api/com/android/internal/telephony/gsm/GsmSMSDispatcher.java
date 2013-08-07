package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.HashMap;
import java.util.Iterator;

import android.app.Activity;
import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.Intent;
import android.os.AsyncResult;
import android.os.Message;
import android.os.SystemProperties;
import android.provider.Telephony.Sms;
import android.provider.Telephony.Sms.Intents;
import android.telephony.PhoneNumberUtils;
import android.telephony.SmsCbMessage;
import android.telephony.SmsManager;
import android.telephony.SmsMessage.MessageClass;
import android.telephony.gsm.GsmCellLocation;
import android.util.Log;

import com.android.internal.telephony.CommandsInterface;
import com.android.internal.telephony.IccUtils;
import com.android.internal.telephony.PhoneBase;
import com.android.internal.telephony.SMSDispatcher;
import com.android.internal.telephony.SmsHeader;
import com.android.internal.telephony.SmsMessageBase;
import com.android.internal.telephony.SmsMessageBase.TextEncodingDetails;
import com.android.internal.telephony.SmsStorageMonitor;
import com.android.internal.telephony.SmsUsageMonitor;
import com.android.internal.telephony.TelephonyProperties;






public final class GsmSMSDispatcher extends SMSDispatcher {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.126 -0400", hash_original_field = "D23A9A1E20D1A7A9C562EB626C5216B0", hash_generated_field = "FB0C4AC891EDC21FFB7A5101DD66CA15")

    private UsimDataDownloadHandler mDataDownloadHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.127 -0400", hash_original_field = "29454096E52BB79CDB7B876CEFEF19B3", hash_generated_field = "9A4B59DC2D3D1F23A20F3C6764DA1638")

    private final HashMap<SmsCbConcatInfo, byte[][]> mSmsCbPageMap = new HashMap<SmsCbConcatInfo, byte[][]>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.127 -0400", hash_original_method = "00834B5C758A658CCABAFC48B413096E", hash_generated_method = "4DF9584E1A9997719A8481228A961CFB")
    public  GsmSMSDispatcher(PhoneBase phone, SmsStorageMonitor storageMonitor,
            SmsUsageMonitor usageMonitor) {
        super(phone, storageMonitor, usageMonitor);
        addTaint(usageMonitor.getTaint());
        addTaint(storageMonitor.getTaint());
        addTaint(phone.getTaint());
        mDataDownloadHandler = new UsimDataDownloadHandler(mCm);
        mCm.setOnNewGsmSms(this, EVENT_NEW_SMS, null);
        mCm.setOnSmsStatus(this, EVENT_NEW_SMS_STATUS_REPORT, null);
        mCm.setOnNewGsmBroadcastSms(this, EVENT_NEW_BROADCAST_SMS, null);
        // ---------- Original Method ----------
        //mDataDownloadHandler = new UsimDataDownloadHandler(mCm);
        //mCm.setOnNewGsmSms(this, EVENT_NEW_SMS, null);
        //mCm.setOnSmsStatus(this, EVENT_NEW_SMS_STATUS_REPORT, null);
        //mCm.setOnNewGsmBroadcastSms(this, EVENT_NEW_BROADCAST_SMS, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.127 -0400", hash_original_method = "FC96C37EC7CCEA012658804CB9F94924", hash_generated_method = "AB9F18314E4DF06E27ECE87D12F5EA19")
    @Override
    public void dispose() {
        mCm.unSetOnNewGsmSms(this);
        mCm.unSetOnSmsStatus(this);
        mCm.unSetOnNewGsmBroadcastSms(this);
        // ---------- Original Method ----------
        //mCm.unSetOnNewGsmSms(this);
        //mCm.unSetOnSmsStatus(this);
        //mCm.unSetOnNewGsmBroadcastSms(this);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.127 -0400", hash_original_method = "1D516C6BB697A8ECCBFC751AA141CC3E", hash_generated_method = "69F52CE3B787F87333BEC839ECDF8D87")
    @Override
    protected String getFormat() {
String varC345C9016D68CE4F646C76C73C4A46BE_1962887212 =         android.telephony.SmsMessage.FORMAT_3GPP;
        varC345C9016D68CE4F646C76C73C4A46BE_1962887212.addTaint(taint);
        return varC345C9016D68CE4F646C76C73C4A46BE_1962887212;
        // ---------- Original Method ----------
        //return android.telephony.SmsMessage.FORMAT_3GPP;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.128 -0400", hash_original_method = "789365F05DDE44536DDE00C9B93C643B", hash_generated_method = "D85C24BB39BCB33B5566BF304B4D5843")
    @Override
    public void handleMessage(Message msg) {
        addTaint(msg.getTaint());
switch(msg.what){
        case EVENT_NEW_SMS_STATUS_REPORT:
        handleStatusReport((AsyncResult) msg.obj);
        break;
        case EVENT_NEW_BROADCAST_SMS:
        handleBroadcastSms((AsyncResult)msg.obj);
        break;
        case EVENT_WRITE_SMS_COMPLETE:
        AsyncResult ar = (AsyncResult) msg.obj;
        if(ar.exception == null)        
        {
            Log.d(TAG, "Successfully wrote SMS-PP message to UICC");
            mCm.acknowledgeLastIncomingGsmSms(true, 0, null);
        } //End block
        else
        {
            Log.d(TAG, "Failed to write SMS-PP message to UICC", ar.exception);
            mCm.acknowledgeLastIncomingGsmSms(false,
                        CommandsInterface.GSM_SMS_FAIL_CAUSE_UNSPECIFIED_ERROR, null);
        } //End block
        break;
        default:
        super.handleMessage(msg);
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.129 -0400", hash_original_method = "4DDABCDA44FFF28C561B2585B61E25F7", hash_generated_method = "3CBFFFA97C91039BCC7EF23191E09A11")
    private void handleStatusReport(AsyncResult ar) {
        addTaint(ar.getTaint());
        String pduString = (String) ar.result;
        SmsMessage sms = SmsMessage.newFromCDS(pduString);
        if(sms != null)        
        {
            int tpStatus = sms.getStatus();
            int messageRef = sms.messageRef;
for(int i = 0, count = deliveryPendingList.size();i < count;i++)
            {
                SmsTracker tracker = deliveryPendingList.get(i);
                if(tracker.mMessageRef == messageRef)                
                {
                    if(tpStatus >= Sms.STATUS_FAILED || tpStatus < Sms.STATUS_PENDING)                    
                    {
                        deliveryPendingList.remove(i);
                    } //End block
                    PendingIntent intent = tracker.mDeliveryIntent;
                    Intent fillIn = new Intent();
                    fillIn.putExtra("pdu", IccUtils.hexStringToBytes(pduString));
                    fillIn.putExtra("format", android.telephony.SmsMessage.FORMAT_3GPP);
                    try 
                    {
                        intent.send(mContext, Activity.RESULT_OK, fillIn);
                    } //End block
                    catch (CanceledException ex)
                    {
                    } //End block
                    break;
                } //End block
            } //End block
        } //End block
        acknowledgeLastIncomingSms(true, Intents.RESULT_SMS_HANDLED, null);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.130 -0400", hash_original_method = "00DA5224E05DFE04589B7B4693E817E4", hash_generated_method = "03443294B1BF7A8C40FEAD56E0BD4BF6")
    @Override
    public int dispatchMessage(SmsMessageBase smsb) {
        addTaint(smsb.getTaint());
        if(smsb == null)        
        {
            int varFCC16322707A95E5743FED9CA64177EC_2115526391 = (Intents.RESULT_SMS_GENERIC_ERROR);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1161379449 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1161379449;
        } //End block
        SmsMessage sms = (SmsMessage) smsb;
        if(sms.isTypeZero())        
        {
            Log.d(TAG, "Received short message type 0, Don't display or store it. Send Ack");
            int var0A0A6D68560CC5EF46A3B9603DD175AA_536621105 = (Intents.RESULT_SMS_HANDLED);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2114442590 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2114442590;
        } //End block
        if(sms.isUsimDataDownload())        
        {
            UsimServiceTable ust = mPhone.getUsimServiceTable();
            if(ust != null && ust.isAvailable(
                    UsimServiceTable.UsimService.DATA_DL_VIA_SMS_PP))            
            {
                Log.d(TAG, "Received SMS-PP data download, sending to UICC.");
                int var774733FE609D84F3433163F1EAC3E5C9_1306199984 = (mDataDownloadHandler.startDataDownload(sms));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_628607493 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_628607493;
            } //End block
            else
            {
                Log.d(TAG, "DATA_DL_VIA_SMS_PP service not available, storing message to UICC.");
                String smsc = IccUtils.bytesToHexString(
                        PhoneNumberUtils.networkPortionToCalledPartyBCDWithLength(
                                sms.getServiceCenterAddress()));
                mCm.writeSmsToSim(SmsManager.STATUS_ON_ICC_UNREAD, smsc,
                        IccUtils.bytesToHexString(sms.getPdu()),
                        obtainMessage(EVENT_WRITE_SMS_COMPLETE));
                int var4C0737507AD994723C875A6D0646D112_801062466 = (Activity.RESULT_OK);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_705385838 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_705385838;
            } //End block
        } //End block
        if(mSmsReceiveDisabled)        
        {
            Log.d(TAG, "Received short message on device which doesn't support "
                    + "SMS service. Ignored.");
            int var0A0A6D68560CC5EF46A3B9603DD175AA_1524746617 = (Intents.RESULT_SMS_HANDLED);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_964495318 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_964495318;
        } //End block
        boolean handled = false;
        if(sms.isMWISetMessage())        
        {
            mPhone.setVoiceMessageWaiting(1, -1);
            handled = sms.isMwiDontStore();
            if(false)            
            {
                Log.d(TAG, "Received voice mail indicator set SMS shouldStore=" + !handled);
            } //End block
        } //End block
        else
        if(sms.isMWIClearMessage())        
        {
            mPhone.setVoiceMessageWaiting(1, 0);
            handled = sms.isMwiDontStore();
            if(false)            
            {
                Log.d(TAG, "Received voice mail indicator clear SMS shouldStore=" + !handled);
            } //End block
        } //End block
        if(handled)        
        {
            int var0A0A6D68560CC5EF46A3B9603DD175AA_1224535621 = (Intents.RESULT_SMS_HANDLED);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_809349205 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_809349205;
        } //End block
        if(!mStorageMonitor.isStorageAvailable() &&
                sms.getMessageClass() != MessageClass.CLASS_0)        
        {
            int varDEFBF0C406E78C33F6A54AB9BC317484_1220434547 = (Intents.RESULT_SMS_OUT_OF_MEMORY);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_715996940 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_715996940;
        } //End block
        int var346A9897E2392234AEC3F85CEF1CB0D4_783992159 = (dispatchNormalMessage(smsb));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2082906182 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2082906182;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.132 -0400", hash_original_method = "3D7E3502DD1585858E097F3A6DC759F7", hash_generated_method = "657A9AE8C30AD049265B3E48C19D719A")
    @Override
    protected void sendData(String destAddr, String scAddr, int destPort,
            byte[] data, PendingIntent sentIntent, PendingIntent deliveryIntent) {
        addTaint(deliveryIntent.getTaint());
        addTaint(sentIntent.getTaint());
        addTaint(data[0]);
        addTaint(destPort);
        addTaint(scAddr.getTaint());
        addTaint(destAddr.getTaint());
        SmsMessage.SubmitPdu pdu = SmsMessage.getSubmitPdu(
                scAddr, destAddr, destPort, data, (deliveryIntent != null));
        if(pdu != null)        
        {
            sendRawPdu(pdu.encodedScAddress, pdu.encodedMessage, sentIntent, deliveryIntent);
        } //End block
        else
        {
        } //End block
        // ---------- Original Method ----------
        //SmsMessage.SubmitPdu pdu = SmsMessage.getSubmitPdu(
                //scAddr, destAddr, destPort, data, (deliveryIntent != null));
        //if (pdu != null) {
            //sendRawPdu(pdu.encodedScAddress, pdu.encodedMessage, sentIntent, deliveryIntent);
        //} else {
            //Log.e(TAG, "GsmSMSDispatcher.sendData(): getSubmitPdu() returned null");
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.133 -0400", hash_original_method = "5889D931B0AF2BA9EF13AED6A1D3F698", hash_generated_method = "D6BE9A1035E985E74A7C36E539639EE3")
    @Override
    protected void sendText(String destAddr, String scAddr, String text,
            PendingIntent sentIntent, PendingIntent deliveryIntent) {
        addTaint(deliveryIntent.getTaint());
        addTaint(sentIntent.getTaint());
        addTaint(text.getTaint());
        addTaint(scAddr.getTaint());
        addTaint(destAddr.getTaint());
        SmsMessage.SubmitPdu pdu = SmsMessage.getSubmitPdu(
                scAddr, destAddr, text, (deliveryIntent != null));
        if(pdu != null)        
        {
            sendRawPdu(pdu.encodedScAddress, pdu.encodedMessage, sentIntent, deliveryIntent);
        } //End block
        else
        {
        } //End block
        // ---------- Original Method ----------
        //SmsMessage.SubmitPdu pdu = SmsMessage.getSubmitPdu(
                //scAddr, destAddr, text, (deliveryIntent != null));
        //if (pdu != null) {
            //sendRawPdu(pdu.encodedScAddress, pdu.encodedMessage, sentIntent, deliveryIntent);
        //} else {
            //Log.e(TAG, "GsmSMSDispatcher.sendText(): getSubmitPdu() returned null");
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.133 -0400", hash_original_method = "9DEF445F0373354182FDA1EF238BF843", hash_generated_method = "3BFF870EFE90594FDFC128ADCB46F6B3")
    @Override
    protected TextEncodingDetails calculateLength(CharSequence messageBody,
            boolean use7bitOnly) {
        addTaint(use7bitOnly);
        addTaint(messageBody.getTaint());
TextEncodingDetails var9473932D319F0FA2CD84167FDAB5206A_992691367 =         SmsMessage.calculateLength(messageBody, use7bitOnly);
        var9473932D319F0FA2CD84167FDAB5206A_992691367.addTaint(taint);
        return var9473932D319F0FA2CD84167FDAB5206A_992691367;
        // ---------- Original Method ----------
        //return SmsMessage.calculateLength(messageBody, use7bitOnly);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.134 -0400", hash_original_method = "D46F86683A1628DBA1448E14FF571355", hash_generated_method = "C11DE1ED6E4AAC2528E1745135F45B91")
    @Override
    protected void sendNewSubmitPdu(String destinationAddress, String scAddress,
            String message, SmsHeader smsHeader, int encoding,
            PendingIntent sentIntent, PendingIntent deliveryIntent, boolean lastPart) {
        addTaint(lastPart);
        addTaint(deliveryIntent.getTaint());
        addTaint(sentIntent.getTaint());
        addTaint(encoding);
        addTaint(smsHeader.getTaint());
        addTaint(message.getTaint());
        addTaint(scAddress.getTaint());
        addTaint(destinationAddress.getTaint());
        SmsMessage.SubmitPdu pdu = SmsMessage.getSubmitPdu(scAddress, destinationAddress,
                message, deliveryIntent != null, SmsHeader.toByteArray(smsHeader),
                encoding, smsHeader.languageTable, smsHeader.languageShiftTable);
        if(pdu != null)        
        {
            sendRawPdu(pdu.encodedScAddress, pdu.encodedMessage, sentIntent, deliveryIntent);
        } //End block
        else
        {
        } //End block
        // ---------- Original Method ----------
        //SmsMessage.SubmitPdu pdu = SmsMessage.getSubmitPdu(scAddress, destinationAddress,
                //message, deliveryIntent != null, SmsHeader.toByteArray(smsHeader),
                //encoding, smsHeader.languageTable, smsHeader.languageShiftTable);
        //if (pdu != null) {
            //sendRawPdu(pdu.encodedScAddress, pdu.encodedMessage, sentIntent, deliveryIntent);
        //} else {
            //Log.e(TAG, "GsmSMSDispatcher.sendNewSubmitPdu(): getSubmitPdu() returned null");
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.134 -0400", hash_original_method = "FF8E1B494DDC1956B0825172C230EA31", hash_generated_method = "48B236C7123669EC9654E19A333E965F")
    @Override
    protected void sendSms(SmsTracker tracker) {
        addTaint(tracker.getTaint());
        HashMap<String, Object> map = tracker.mData;
        byte smsc[] = (byte[]) map.get("smsc");
        byte pdu[] = (byte[]) map.get("pdu");
        Message reply = obtainMessage(EVENT_SEND_SMS_COMPLETE, tracker);
        mCm.sendSMS(IccUtils.bytesToHexString(smsc), IccUtils.bytesToHexString(pdu), reply);
        // ---------- Original Method ----------
        //HashMap<String, Object> map = tracker.mData;
        //byte smsc[] = (byte[]) map.get("smsc");
        //byte pdu[] = (byte[]) map.get("pdu");
        //Message reply = obtainMessage(EVENT_SEND_SMS_COMPLETE, tracker);
        //mCm.sendSMS(IccUtils.bytesToHexString(smsc), IccUtils.bytesToHexString(pdu), reply);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.135 -0400", hash_original_method = "72A464580F37288F468EE51C88A0917A", hash_generated_method = "E5F61C674358B06759CD39C4B9208A98")
    @Override
    protected void acknowledgeLastIncomingSms(boolean success, int result, Message response) {
        addTaint(response.getTaint());
        addTaint(result);
        addTaint(success);
        mCm.acknowledgeLastIncomingGsmSms(success, resultToCause(result), response);
        // ---------- Original Method ----------
        //mCm.acknowledgeLastIncomingGsmSms(success, resultToCause(result), response);
    }

    
    @DSModeled(DSC.BAN)
    private static int resultToCause(int rc) {
        switch (rc) {
            case Activity.RESULT_OK:
            case Intents.RESULT_SMS_HANDLED:
                return 0;
            case Intents.RESULT_SMS_OUT_OF_MEMORY:
                return CommandsInterface.GSM_SMS_FAIL_CAUSE_MEMORY_CAPACITY_EXCEEDED;
            case Intents.RESULT_SMS_GENERIC_ERROR:
            default:
                return CommandsInterface.GSM_SMS_FAIL_CAUSE_UNSPECIFIED_ERROR;
        }
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.136 -0400", hash_original_method = "4513E8DEDD790BB664A98AD56B29A135", hash_generated_method = "CDC955E6ACC4186F2A822E4F427C0839")
    private void handleBroadcastSms(AsyncResult ar) {
        addTaint(ar.getTaint());
        try 
        {
            byte[] receivedPdu = (byte[])ar.result;
            if(false)            
            {
for(int i = 0;i < receivedPdu.length;i += 8)
                {
                    StringBuilder sb = new StringBuilder("SMS CB pdu data: ");
for(int j = i;j < i + 8 && j < receivedPdu.length;j++)
                    {
                        int b = receivedPdu[j] & 0xff;
                        if(b < 0x10)                        
                        {
                            sb.append('0');
                        } //End block
                        sb.append(Integer.toHexString(b)).append(' ');
                    } //End block
                    Log.d(TAG, sb.toString());
                } //End block
            } //End block
            SmsCbHeader header = new SmsCbHeader(receivedPdu);
            String plmn = SystemProperties.get(TelephonyProperties.PROPERTY_OPERATOR_NUMERIC);
            GsmCellLocation cellLocation = (GsmCellLocation) mPhone.getCellLocation();
            int lac = cellLocation.getLac();
            int cid = cellLocation.getCid();
            byte[][] pdus;
            if(header.nrOfPages > 1)            
            {
                SmsCbConcatInfo concatInfo = new SmsCbConcatInfo(header, plmn, lac, cid);
                pdus = mSmsCbPageMap.get(concatInfo);
                if(pdus == null)                
                {
                    pdus = new byte[header.nrOfPages][];
                    mSmsCbPageMap.put(concatInfo, pdus);
                } //End block
                pdus[header.pageIndex - 1] = receivedPdu;
for(int i = 0;i < pdus.length;i++)
                {
                    if(pdus[i] == null)                    
                    {
                        return;
                    } //End block
                } //End block
                mSmsCbPageMap.remove(concatInfo);
            } //End block
            else
            {
                pdus = new byte[1][];
                pdus[0] = receivedPdu;
            } //End block
            boolean isEmergencyMessage = SmsCbHeader.isEmergencyMessage(header.messageIdentifier);
            dispatchBroadcastPdus(pdus, isEmergencyMessage);
            Iterator<SmsCbConcatInfo> iter = mSmsCbPageMap.keySet().iterator();
            while
(iter.hasNext())            
            {
                SmsCbConcatInfo info = iter.next();
                if(!info.matchesLocation(plmn, lac, cid))                
                {
                    iter.remove();
                } //End block
            } //End block
        } //End block
        catch (RuntimeException e)
        {
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static final class SmsCbConcatInfo {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.137 -0400", hash_original_field = "F43892C15B0C2065A0D775948F742664", hash_generated_field = "F13EAF462BF75A9C18B71C5567248AEE")

        private SmsCbHeader mHeader;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.137 -0400", hash_original_field = "0CC356ECF78F7DFAE70968CD3E9A7877", hash_generated_field = "5B8CD52C7682DA00C91E3E72EBFA9940")

        private String mPlmn;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.137 -0400", hash_original_field = "B2F9C701F6B9FA98A906A1D27571667E", hash_generated_field = "E1DF72766EAA7700CC09E2EF71762BF7")

        private int mLac;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.137 -0400", hash_original_field = "47909A4A63C9D0DF4D400D36305EA002", hash_generated_field = "6613038ECFEA58ECF70AB91998D5EB03")

        private int mCid;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.137 -0400", hash_original_method = "D7F908FE9EEA79B2D247A82A8EA2135C", hash_generated_method = "71F92BDBEEEF5CCD670C3BCCA9D92D30")
        public  SmsCbConcatInfo(SmsCbHeader header, String plmn, int lac, int cid) {
            mHeader = header;
            mPlmn = plmn;
            mLac = lac;
            mCid = cid;
            // ---------- Original Method ----------
            //mHeader = header;
            //mPlmn = plmn;
            //mLac = lac;
            //mCid = cid;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.137 -0400", hash_original_method = "EE152888A937A1561BADC909DEBD7300", hash_generated_method = "AE394B50A3C8ACA77A5FB08EE5F70120")
        @Override
        public int hashCode() {
            int var4563B0F6CA63C6FAA6D7B6D620DED75E_1890438993 = (mHeader.messageIdentifier * 31 + mHeader.updateNumber);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_387179001 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_387179001;
            // ---------- Original Method ----------
            //return mHeader.messageIdentifier * 31 + mHeader.updateNumber;
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.137 -0400", hash_original_method = "A4665EFAF0A95C2E46EAC850D0E6C5D5", hash_generated_method = "9C9AF8FB332438CD70AC998282CF1E5B")
        @Override
        public boolean equals(Object obj) {
            addTaint(obj.getTaint());
            if(obj instanceof SmsCbConcatInfo)            
            {
                SmsCbConcatInfo other = (SmsCbConcatInfo)obj;
                if(mHeader.geographicalScope == other.mHeader.geographicalScope
                        && mHeader.messageCode == other.mHeader.messageCode
                        && mHeader.updateNumber == other.mHeader.updateNumber
                        && mHeader.messageIdentifier == other.mHeader.messageIdentifier
                        && mHeader.dataCodingScheme == other.mHeader.dataCodingScheme
                        && mHeader.nrOfPages == other.mHeader.nrOfPages)                
                {
                    boolean varA276C239EB60C56998195C02A9962CD2_996180158 = (matchesLocation(other.mPlmn, other.mLac, other.mCid));
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1447365319 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1447365319;
                } //End block
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_448082975 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_895960662 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_895960662;
            // ---------- Original Method ----------
            //if (obj instanceof SmsCbConcatInfo) {
                //SmsCbConcatInfo other = (SmsCbConcatInfo)obj;
                //if (mHeader.geographicalScope == other.mHeader.geographicalScope
                        //&& mHeader.messageCode == other.mHeader.messageCode
                        //&& mHeader.updateNumber == other.mHeader.updateNumber
                        //&& mHeader.messageIdentifier == other.mHeader.messageIdentifier
                        //&& mHeader.dataCodingScheme == other.mHeader.dataCodingScheme
                        //&& mHeader.nrOfPages == other.mHeader.nrOfPages) {
                    //return matchesLocation(other.mPlmn, other.mLac, other.mCid);
                //}
            //}
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.138 -0400", hash_original_method = "16D562DE8E79921485CB55DC774779E3", hash_generated_method = "4DCA3C92389EFBEBBBD67C47A1B09615")
        public boolean matchesLocation(String plmn, int lac, int cid) {
            addTaint(cid);
            addTaint(lac);
            addTaint(plmn.getTaint());
switch(mHeader.geographicalScope){
            case SmsCbMessage.GEOGRAPHICAL_SCOPE_CELL_WIDE:
            case SmsCbMessage.GEOGRAPHICAL_SCOPE_CELL_WIDE_IMMEDIATE:
            if(mCid != cid)            
            {
                boolean var68934A3E9455FA72420237EB05902327_2050792738 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_772541150 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_772541150;
            } //End block
            case SmsCbMessage.GEOGRAPHICAL_SCOPE_LA_WIDE:
            if(mLac != lac)            
            {
                boolean var68934A3E9455FA72420237EB05902327_1203555651 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_466898355 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_466898355;
            } //End block
            case SmsCbMessage.GEOGRAPHICAL_SCOPE_PLMN_WIDE:
            boolean varAD08EA8BCD8D2D5BB3151EE959048571_558115179 = (mPlmn != null && mPlmn.equals(plmn));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_105879435 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_105879435;
}            boolean var68934A3E9455FA72420237EB05902327_1261858967 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1139100331 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1139100331;
            // ---------- Original Method ----------
            //switch (mHeader.geographicalScope) {
                //case SmsCbMessage.GEOGRAPHICAL_SCOPE_CELL_WIDE:
                //case SmsCbMessage.GEOGRAPHICAL_SCOPE_CELL_WIDE_IMMEDIATE:
                    //if (mCid != cid) {
                        //return false;
                    //}
                //case SmsCbMessage.GEOGRAPHICAL_SCOPE_LA_WIDE:
                    //if (mLac != lac) {
                        //return false;
                    //}
                //case SmsCbMessage.GEOGRAPHICAL_SCOPE_PLMN_WIDE:
                    //return mPlmn != null && mPlmn.equals(plmn);
            //}
            //return false;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.139 -0400", hash_original_field = "1E54D398F6654D474F0F5192DC98EDCC", hash_generated_field = "EFF0BA8EAA7A2E5FCD3601D1F8EC46DA")

    private static final String TAG = "GSM";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.139 -0400", hash_original_field = "50395D21AF66157B4B10912FCD54B108", hash_generated_field = "E72B26964A801FCD13745348E2F39E5E")

    private static final int EVENT_NEW_SMS_STATUS_REPORT = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.139 -0400", hash_original_field = "BDB4FEC067A25D13FF04C51317B87865", hash_generated_field = "1C09FC92D14FE7DA05FCFF7B41C8CA1E")

    private static final int EVENT_NEW_BROADCAST_SMS = 101;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.139 -0400", hash_original_field = "9436FC3322A611484CE8FC6322B0170D", hash_generated_field = "0CD824DED9BF2D233D61D30AB013D005")

    private static final int EVENT_WRITE_SMS_COMPLETE = 102;
}

