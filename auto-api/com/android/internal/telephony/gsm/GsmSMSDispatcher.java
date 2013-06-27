package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
import java.util.HashMap;
import java.util.Iterator;
import static android.telephony.SmsMessage.MessageClass;

public final class GsmSMSDispatcher extends SMSDispatcher {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.589 -0400", hash_original_field = "D23A9A1E20D1A7A9C562EB626C5216B0", hash_generated_field = "FB0C4AC891EDC21FFB7A5101DD66CA15")

    private UsimDataDownloadHandler mDataDownloadHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.589 -0400", hash_original_field = "29454096E52BB79CDB7B876CEFEF19B3", hash_generated_field = "DDCF5F5EC241E964087AEBB3E9A0869B")

    private HashMap<SmsCbConcatInfo, byte[][]> mSmsCbPageMap = new HashMap<SmsCbConcatInfo, byte[][]>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.591 -0400", hash_original_method = "00834B5C758A658CCABAFC48B413096E", hash_generated_method = "4C0BACD30169DA11E6028A639D80B3DB")
    public  GsmSMSDispatcher(PhoneBase phone, SmsStorageMonitor storageMonitor,
            SmsUsageMonitor usageMonitor) {
        super(phone, storageMonitor, usageMonitor);
        mDataDownloadHandler = new UsimDataDownloadHandler(mCm);
        mCm.setOnNewGsmSms(this, EVENT_NEW_SMS, null);
        mCm.setOnSmsStatus(this, EVENT_NEW_SMS_STATUS_REPORT, null);
        mCm.setOnNewGsmBroadcastSms(this, EVENT_NEW_BROADCAST_SMS, null);
        addTaint(phone.getTaint());
        addTaint(storageMonitor.getTaint());
        addTaint(usageMonitor.getTaint());
        // ---------- Original Method ----------
        //mDataDownloadHandler = new UsimDataDownloadHandler(mCm);
        //mCm.setOnNewGsmSms(this, EVENT_NEW_SMS, null);
        //mCm.setOnSmsStatus(this, EVENT_NEW_SMS_STATUS_REPORT, null);
        //mCm.setOnNewGsmBroadcastSms(this, EVENT_NEW_BROADCAST_SMS, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.591 -0400", hash_original_method = "FC96C37EC7CCEA012658804CB9F94924", hash_generated_method = "AB9F18314E4DF06E27ECE87D12F5EA19")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.597 -0400", hash_original_method = "1D516C6BB697A8ECCBFC751AA141CC3E", hash_generated_method = "6209ABB967CDA8644AD2D73D601781AB")
    @Override
    protected String getFormat() {
        String varB4EAC82CA7396A68D541C85D26508E83_1680876388 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1680876388 = android.telephony.SmsMessage.FORMAT_3GPP;
        varB4EAC82CA7396A68D541C85D26508E83_1680876388.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1680876388;
        // ---------- Original Method ----------
        //return android.telephony.SmsMessage.FORMAT_3GPP;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.597 -0400", hash_original_method = "789365F05DDE44536DDE00C9B93C643B", hash_generated_method = "A0D58DA7E57759916E69F74E1295CEB1")
    @Override
    public void handleMessage(Message msg) {
        //Begin case EVENT_NEW_SMS_STATUS_REPORT 
        handleStatusReport((AsyncResult) msg.obj);
        //End case EVENT_NEW_SMS_STATUS_REPORT 
        //Begin case EVENT_NEW_BROADCAST_SMS 
        handleBroadcastSms((AsyncResult)msg.obj);
        //End case EVENT_NEW_BROADCAST_SMS 
        //Begin case EVENT_WRITE_SMS_COMPLETE 
        AsyncResult ar;
        ar = (AsyncResult) msg.obj;
        //End case EVENT_WRITE_SMS_COMPLETE 
        //Begin case EVENT_WRITE_SMS_COMPLETE 
        {
            Log.d(TAG, "Successfully wrote SMS-PP message to UICC");
            mCm.acknowledgeLastIncomingGsmSms(true, 0, null);
        } //End block
        {
            Log.d(TAG, "Failed to write SMS-PP message to UICC", ar.exception);
            mCm.acknowledgeLastIncomingGsmSms(false,
                        CommandsInterface.GSM_SMS_FAIL_CAUSE_UNSPECIFIED_ERROR, null);
        } //End block
        //End case EVENT_WRITE_SMS_COMPLETE 
        //Begin case default 
        super.handleMessage(msg);
        //End case default 
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.608 -0400", hash_original_method = "4DDABCDA44FFF28C561B2585B61E25F7", hash_generated_method = "0F3E4D17F6669C4E5A067A10B5F59C5F")
    private void handleStatusReport(AsyncResult ar) {
        String pduString;
        pduString = (String) ar.result;
        SmsMessage sms;
        sms = SmsMessage.newFromCDS(pduString);
        {
            int tpStatus;
            tpStatus = sms.getStatus();
            int messageRef;
            messageRef = sms.messageRef;
            {
                int i, count;
                i = 0;
                count = deliveryPendingList.size();
                {
                    SmsTracker tracker;
                    tracker = deliveryPendingList.get(i);
                    {
                        {
                            deliveryPendingList.remove(i);
                        } //End block
                        PendingIntent intent;
                        intent = tracker.mDeliveryIntent;
                        Intent fillIn;
                        fillIn = new Intent();
                        fillIn.putExtra("pdu", IccUtils.hexStringToBytes(pduString));
                        fillIn.putExtra("format", android.telephony.SmsMessage.FORMAT_3GPP);
                        try 
                        {
                            intent.send(mContext, Activity.RESULT_OK, fillIn);
                        } //End block
                        catch (CanceledException ex)
                        { }
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        acknowledgeLastIncomingSms(true, Intents.RESULT_SMS_HANDLED, null);
        addTaint(ar.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.614 -0400", hash_original_method = "00DA5224E05DFE04589B7B4693E817E4", hash_generated_method = "F81063ADD8981CECCF96189D394A7935")
    @Override
    public int dispatchMessage(SmsMessageBase smsb) {
        SmsMessage sms;
        sms = (SmsMessage) smsb;
        {
            boolean varB6031355C0905631735F722E8A67DE3D_692264842 = (sms.isTypeZero());
            {
                Log.d(TAG, "Received short message type 0, Don't display or store it. Send Ack");
            } //End block
        } //End collapsed parenthetic
        {
            boolean varA5EE62D09AEC8F9FD1898F2B6486F22D_1161142805 = (sms.isUsimDataDownload());
            {
                UsimServiceTable ust;
                ust = mPhone.getUsimServiceTable();
                {
                    boolean var12D35405AA0257D7AD5F7F54F16478EA_1091634146 = (ust != null && ust.isAvailable(
                    UsimServiceTable.UsimService.DATA_DL_VIA_SMS_PP));
                    {
                        Log.d(TAG, "Received SMS-PP data download, sending to UICC.");
                        int var8B022B4480B8D4E4694849310BDCE5C7_1603461590 = (mDataDownloadHandler.startDataDownload(sms));
                    } //End block
                    {
                        Log.d(TAG, "DATA_DL_VIA_SMS_PP service not available, storing message to UICC.");
                        String smsc;
                        smsc = IccUtils.bytesToHexString(
                        PhoneNumberUtils.networkPortionToCalledPartyBCDWithLength(
                                sms.getServiceCenterAddress()));
                        mCm.writeSmsToSim(SmsManager.STATUS_ON_ICC_UNREAD, smsc,
                        IccUtils.bytesToHexString(sms.getPdu()),
                        obtainMessage(EVENT_WRITE_SMS_COMPLETE));
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            Log.d(TAG, "Received short message on device which doesn't support "
                    + "SMS service. Ignored.");
        } //End block
        boolean handled;
        handled = false;
        {
            boolean varF8C0D9A02B2BCE7F3BBAAC567BF16F6E_1477261108 = (sms.isMWISetMessage());
            {
                mPhone.setVoiceMessageWaiting(1, -1);
                handled = sms.isMwiDontStore();
                {
                    Log.d(TAG, "Received voice mail indicator set SMS shouldStore=" + !handled);
                } //End block
            } //End block
            {
                boolean var5C4804CFC9656A5E0B83164B653B7DCC_217413024 = (sms.isMWIClearMessage());
                {
                    mPhone.setVoiceMessageWaiting(1, 0);
                    handled = sms.isMwiDontStore();
                    {
                        Log.d(TAG, "Received voice mail indicator clear SMS shouldStore=" + !handled);
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        {
            boolean varA6EC97D1C251BAAEFB63A742DEBA1DB1_453931630 = (!mStorageMonitor.isStorageAvailable() &&
                sms.getMessageClass() != MessageClass.CLASS_0);
        } //End collapsed parenthetic
        int var3F541A711EB85996C611FA5F634F0615_601147609 = (dispatchNormalMessage(smsb));
        addTaint(smsb.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2109436962 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2109436962;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.615 -0400", hash_original_method = "3D7E3502DD1585858E097F3A6DC759F7", hash_generated_method = "DA9C2884682E08E1B82C564F5740BD26")
    @Override
    protected void sendData(String destAddr, String scAddr, int destPort,
            byte[] data, PendingIntent sentIntent, PendingIntent deliveryIntent) {
        SmsMessage.SubmitPdu pdu;
        pdu = SmsMessage.getSubmitPdu(
                scAddr, destAddr, destPort, data, (deliveryIntent != null));
        {
            sendRawPdu(pdu.encodedScAddress, pdu.encodedMessage, sentIntent, deliveryIntent);
        } //End block
        addTaint(destAddr.getTaint());
        addTaint(scAddr.getTaint());
        addTaint(destPort);
        addTaint(data[0]);
        addTaint(sentIntent.getTaint());
        addTaint(deliveryIntent.getTaint());
        // ---------- Original Method ----------
        //SmsMessage.SubmitPdu pdu = SmsMessage.getSubmitPdu(
                //scAddr, destAddr, destPort, data, (deliveryIntent != null));
        //if (pdu != null) {
            //sendRawPdu(pdu.encodedScAddress, pdu.encodedMessage, sentIntent, deliveryIntent);
        //} else {
            //Log.e(TAG, "GsmSMSDispatcher.sendData(): getSubmitPdu() returned null");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.615 -0400", hash_original_method = "5889D931B0AF2BA9EF13AED6A1D3F698", hash_generated_method = "F5AD0CB60D871C251295381059F3EFAE")
    @Override
    protected void sendText(String destAddr, String scAddr, String text,
            PendingIntent sentIntent, PendingIntent deliveryIntent) {
        SmsMessage.SubmitPdu pdu;
        pdu = SmsMessage.getSubmitPdu(
                scAddr, destAddr, text, (deliveryIntent != null));
        {
            sendRawPdu(pdu.encodedScAddress, pdu.encodedMessage, sentIntent, deliveryIntent);
        } //End block
        addTaint(destAddr.getTaint());
        addTaint(scAddr.getTaint());
        addTaint(text.getTaint());
        addTaint(sentIntent.getTaint());
        addTaint(deliveryIntent.getTaint());
        // ---------- Original Method ----------
        //SmsMessage.SubmitPdu pdu = SmsMessage.getSubmitPdu(
                //scAddr, destAddr, text, (deliveryIntent != null));
        //if (pdu != null) {
            //sendRawPdu(pdu.encodedScAddress, pdu.encodedMessage, sentIntent, deliveryIntent);
        //} else {
            //Log.e(TAG, "GsmSMSDispatcher.sendText(): getSubmitPdu() returned null");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.616 -0400", hash_original_method = "9DEF445F0373354182FDA1EF238BF843", hash_generated_method = "3B5FB4977C2927323A0B740159444740")
    @Override
    protected TextEncodingDetails calculateLength(CharSequence messageBody,
            boolean use7bitOnly) {
        TextEncodingDetails varB4EAC82CA7396A68D541C85D26508E83_241553301 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_241553301 = SmsMessage.calculateLength(messageBody, use7bitOnly);
        addTaint(messageBody.getTaint());
        addTaint(use7bitOnly);
        varB4EAC82CA7396A68D541C85D26508E83_241553301.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_241553301;
        // ---------- Original Method ----------
        //return SmsMessage.calculateLength(messageBody, use7bitOnly);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.621 -0400", hash_original_method = "D46F86683A1628DBA1448E14FF571355", hash_generated_method = "92CD5CF435A70F113D23B484ADB7EA6F")
    @Override
    protected void sendNewSubmitPdu(String destinationAddress, String scAddress,
            String message, SmsHeader smsHeader, int encoding,
            PendingIntent sentIntent, PendingIntent deliveryIntent, boolean lastPart) {
        SmsMessage.SubmitPdu pdu;
        pdu = SmsMessage.getSubmitPdu(scAddress, destinationAddress,
                message, deliveryIntent != null, SmsHeader.toByteArray(smsHeader),
                encoding, smsHeader.languageTable, smsHeader.languageShiftTable);
        {
            sendRawPdu(pdu.encodedScAddress, pdu.encodedMessage, sentIntent, deliveryIntent);
        } //End block
        addTaint(destinationAddress.getTaint());
        addTaint(scAddress.getTaint());
        addTaint(message.getTaint());
        addTaint(smsHeader.getTaint());
        addTaint(encoding);
        addTaint(sentIntent.getTaint());
        addTaint(deliveryIntent.getTaint());
        addTaint(lastPart);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.621 -0400", hash_original_method = "FF8E1B494DDC1956B0825172C230EA31", hash_generated_method = "2F45A312D3E46059A11C4B372A6BF1AE")
    @Override
    protected void sendSms(SmsTracker tracker) {
        HashMap<String, Object> map;
        map = tracker.mData;
        byte smsc[];
        smsc = (byte[]) map.get("smsc");
        byte pdu[];
        pdu = (byte[]) map.get("pdu");
        Message reply;
        reply = obtainMessage(EVENT_SEND_SMS_COMPLETE, tracker);
        mCm.sendSMS(IccUtils.bytesToHexString(smsc), IccUtils.bytesToHexString(pdu), reply);
        addTaint(tracker.getTaint());
        // ---------- Original Method ----------
        //HashMap<String, Object> map = tracker.mData;
        //byte smsc[] = (byte[]) map.get("smsc");
        //byte pdu[] = (byte[]) map.get("pdu");
        //Message reply = obtainMessage(EVENT_SEND_SMS_COMPLETE, tracker);
        //mCm.sendSMS(IccUtils.bytesToHexString(smsc), IccUtils.bytesToHexString(pdu), reply);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.622 -0400", hash_original_method = "72A464580F37288F468EE51C88A0917A", hash_generated_method = "A946FC2869313F60A0BAA57198780470")
    @Override
    protected void acknowledgeLastIncomingSms(boolean success, int result, Message response) {
        mCm.acknowledgeLastIncomingGsmSms(success, resultToCause(result), response);
        addTaint(success);
        addTaint(result);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //mCm.acknowledgeLastIncomingGsmSms(success, resultToCause(result), response);
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.624 -0400", hash_original_method = "4513E8DEDD790BB664A98AD56B29A135", hash_generated_method = "1C6DB211F939F4B98C901BF79E71E3C3")
    private void handleBroadcastSms(AsyncResult ar) {
        try 
        {
            byte[] receivedPdu;
            receivedPdu = (byte[])ar.result;
            {
                {
                    int i;
                    i = 0;
                    i += 8;
                    {
                        StringBuilder sb;
                        sb = new StringBuilder("SMS CB pdu data: ");
                        {
                            int j;
                            j = i;
                            {
                                int b;
                                b = receivedPdu[j] & 0xff;
                                {
                                    sb.append('0');
                                } //End block
                                sb.append(Integer.toHexString(b)).append(' ');
                            } //End block
                        } //End collapsed parenthetic
                        Log.d(TAG, sb.toString());
                    } //End block
                } //End collapsed parenthetic
            } //End block
            SmsCbHeader header;
            header = new SmsCbHeader(receivedPdu);
            String plmn;
            plmn = SystemProperties.get(TelephonyProperties.PROPERTY_OPERATOR_NUMERIC);
            GsmCellLocation cellLocation;
            cellLocation = (GsmCellLocation) mPhone.getCellLocation();
            int lac;
            lac = cellLocation.getLac();
            int cid;
            cid = cellLocation.getCid();
            byte[][] pdus;
            {
                SmsCbConcatInfo concatInfo;
                concatInfo = new SmsCbConcatInfo(header, plmn, lac, cid);
                pdus = mSmsCbPageMap.get(concatInfo);
                {
                    pdus = new byte[header.nrOfPages][];
                    mSmsCbPageMap.put(concatInfo, pdus);
                } //End block
                pdus[header.pageIndex - 1] = receivedPdu;
                {
                    int i;
                    i = 0;
                } //End collapsed parenthetic
                mSmsCbPageMap.remove(concatInfo);
            } //End block
            {
                pdus = new byte[1][];
                pdus[0] = receivedPdu;
            } //End block
            boolean isEmergencyMessage;
            isEmergencyMessage = SmsCbHeader.isEmergencyMessage(header.messageIdentifier);
            dispatchBroadcastPdus(pdus, isEmergencyMessage);
            Iterator<SmsCbConcatInfo> iter;
            iter = mSmsCbPageMap.keySet().iterator();
            {
                boolean var8492AE2C695A56B730381A28B8BA3F6D_1035696118 = (iter.hasNext());
                {
                    SmsCbConcatInfo info;
                    info = iter.next();
                    {
                        boolean var0270A608337A35ABA6617D8040104D0F_188235670 = (!info.matchesLocation(plmn, lac, cid));
                        {
                            iter.remove();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (RuntimeException e)
        { }
        addTaint(ar.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static final class SmsCbConcatInfo {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.624 -0400", hash_original_field = "F43892C15B0C2065A0D775948F742664", hash_generated_field = "F13EAF462BF75A9C18B71C5567248AEE")

        private SmsCbHeader mHeader;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.624 -0400", hash_original_field = "0CC356ECF78F7DFAE70968CD3E9A7877", hash_generated_field = "5B8CD52C7682DA00C91E3E72EBFA9940")

        private String mPlmn;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.624 -0400", hash_original_field = "B2F9C701F6B9FA98A906A1D27571667E", hash_generated_field = "E1DF72766EAA7700CC09E2EF71762BF7")

        private int mLac;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.624 -0400", hash_original_field = "47909A4A63C9D0DF4D400D36305EA002", hash_generated_field = "6613038ECFEA58ECF70AB91998D5EB03")

        private int mCid;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.634 -0400", hash_original_method = "D7F908FE9EEA79B2D247A82A8EA2135C", hash_generated_method = "71F92BDBEEEF5CCD670C3BCCA9D92D30")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.635 -0400", hash_original_method = "EE152888A937A1561BADC909DEBD7300", hash_generated_method = "DEA74AE05F80D0B4DBFE7AF6B5E57B87")
        @Override
        public int hashCode() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1083104177 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1083104177;
            // ---------- Original Method ----------
            //return mHeader.messageIdentifier * 31 + mHeader.updateNumber;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.635 -0400", hash_original_method = "A4665EFAF0A95C2E46EAC850D0E6C5D5", hash_generated_method = "D80A7D6A53D6E0136BAB78A6EEE8E598")
        @Override
        public boolean equals(Object obj) {
            {
                SmsCbConcatInfo other;
                other = (SmsCbConcatInfo)obj;
                {
                    boolean varBB88E0D05F92693B90C9BE1E32F42C62_1133762973 = (matchesLocation(other.mPlmn, other.mLac, other.mCid));
                } //End block
            } //End block
            addTaint(obj.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_525764471 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_525764471;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.636 -0400", hash_original_method = "16D562DE8E79921485CB55DC774779E3", hash_generated_method = "4E436BE4041F23CBB14283B2239F185F")
        public boolean matchesLocation(String plmn, int lac, int cid) {
            //Begin case SmsCbMessage.GEOGRAPHICAL_SCOPE_PLMN_WIDE 
            boolean var1B5436BDE88E386A54C0FBA50F7E9CF9_1037649472 = (mPlmn != null && mPlmn.equals(plmn));
            //End case SmsCbMessage.GEOGRAPHICAL_SCOPE_PLMN_WIDE 
            addTaint(plmn.getTaint());
            addTaint(lac);
            addTaint(cid);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1147907372 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1147907372;
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.636 -0400", hash_original_field = "1E54D398F6654D474F0F5192DC98EDCC", hash_generated_field = "8BC77F4B5E1482D39A3C5083797AFB8D")

    private static String TAG = "GSM";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.641 -0400", hash_original_field = "50395D21AF66157B4B10912FCD54B108", hash_generated_field = "BC702ABF4851BD4F9C560B5F1EA71D1C")

    private static int EVENT_NEW_SMS_STATUS_REPORT = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.641 -0400", hash_original_field = "BDB4FEC067A25D13FF04C51317B87865", hash_generated_field = "B6F27544668FA0D2182203268658708E")

    private static int EVENT_NEW_BROADCAST_SMS = 101;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.641 -0400", hash_original_field = "9436FC3322A611484CE8FC6322B0170D", hash_generated_field = "D2404A7A8A538FFDB2E490C02563BFEB")

    private static int EVENT_WRITE_SMS_COMPLETE = 102;
}

