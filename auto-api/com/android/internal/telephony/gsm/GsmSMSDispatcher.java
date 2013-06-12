package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private static final String TAG = "GSM";
    private static final int EVENT_NEW_SMS_STATUS_REPORT = 100;
    private static final int EVENT_NEW_BROADCAST_SMS = 101;
    private static final int EVENT_WRITE_SMS_COMPLETE = 102;
    private final UsimDataDownloadHandler mDataDownloadHandler;
    private final HashMap<SmsCbConcatInfo, byte[][]> mSmsCbPageMap =
            new HashMap<SmsCbConcatInfo, byte[][]>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.929 -0400", hash_original_method = "00834B5C758A658CCABAFC48B413096E", hash_generated_method = "F6654347351223D7CAF7BF8DA56F6EDC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public GsmSMSDispatcher(PhoneBase phone, SmsStorageMonitor storageMonitor,
            SmsUsageMonitor usageMonitor) {
        super(phone, storageMonitor, usageMonitor);
        dsTaint.addTaint(phone.dsTaint);
        dsTaint.addTaint(usageMonitor.dsTaint);
        dsTaint.addTaint(storageMonitor.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.929 -0400", hash_original_method = "FC96C37EC7CCEA012658804CB9F94924", hash_generated_method = "69BA18D7FB84944E1B19F50AA54F7894")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.929 -0400", hash_original_method = "1D516C6BB697A8ECCBFC751AA141CC3E", hash_generated_method = "9449C90884D33A6D3EEC68B39B10B2E2")
    @DSModeled(DSC.SAFE)
    @Override
    protected String getFormat() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return android.telephony.SmsMessage.FORMAT_3GPP;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.930 -0400", hash_original_method = "789365F05DDE44536DDE00C9B93C643B", hash_generated_method = "A0127CDDD8209B92112498B9E25D2F5A")
    @DSModeled(DSC.SAFE)
    @Override
    public void handleMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.930 -0400", hash_original_method = "4DDABCDA44FFF28C561B2585B61E25F7", hash_generated_method = "8CFFE3A85D596A2F302A8D75D84EBFBE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void handleStatusReport(AsyncResult ar) {
        dsTaint.addTaint(ar.dsTaint);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.930 -0400", hash_original_method = "00DA5224E05DFE04589B7B4693E817E4", hash_generated_method = "0FEB8B4E7A1225D83AFBAAFEF3D468E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int dispatchMessage(SmsMessageBase smsb) {
        dsTaint.addTaint(smsb.dsTaint);
        SmsMessage sms;
        sms = (SmsMessage) smsb;
        {
            boolean varB6031355C0905631735F722E8A67DE3D_899455467 = (sms.isTypeZero());
            {
                Log.d(TAG, "Received short message type 0, Don't display or store it. Send Ack");
            } //End block
        } //End collapsed parenthetic
        {
            boolean varA5EE62D09AEC8F9FD1898F2B6486F22D_1173131157 = (sms.isUsimDataDownload());
            {
                UsimServiceTable ust;
                ust = mPhone.getUsimServiceTable();
                {
                    boolean var12D35405AA0257D7AD5F7F54F16478EA_380212496 = (ust != null && ust.isAvailable(
                    UsimServiceTable.UsimService.DATA_DL_VIA_SMS_PP));
                    {
                        Log.d(TAG, "Received SMS-PP data download, sending to UICC.");
                        int var8B022B4480B8D4E4694849310BDCE5C7_1691246075 = (mDataDownloadHandler.startDataDownload(sms));
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
            boolean varF8C0D9A02B2BCE7F3BBAAC567BF16F6E_1390904552 = (sms.isMWISetMessage());
            {
                mPhone.setVoiceMessageWaiting(1, -1);
                handled = sms.isMwiDontStore();
                {
                    Log.d(TAG, "Received voice mail indicator set SMS shouldStore=" + !handled);
                } //End block
            } //End block
            {
                boolean var5C4804CFC9656A5E0B83164B653B7DCC_1966030012 = (sms.isMWIClearMessage());
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
            boolean varA6EC97D1C251BAAEFB63A742DEBA1DB1_291566916 = (!mStorageMonitor.isStorageAvailable() &&
                sms.getMessageClass() != MessageClass.CLASS_0);
        } //End collapsed parenthetic
        int var3F541A711EB85996C611FA5F634F0615_524926752 = (dispatchNormalMessage(smsb));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.930 -0400", hash_original_method = "3D7E3502DD1585858E097F3A6DC759F7", hash_generated_method = "7A6AF166AEE4FE1897D28F053D87D8EC")
    @DSModeled(DSC.SAFE)
    @Override
    protected void sendData(String destAddr, String scAddr, int destPort,
            byte[] data, PendingIntent sentIntent, PendingIntent deliveryIntent) {
        dsTaint.addTaint(scAddr);
        dsTaint.addTaint(destAddr);
        dsTaint.addTaint(data);
        dsTaint.addTaint(sentIntent.dsTaint);
        dsTaint.addTaint(destPort);
        dsTaint.addTaint(deliveryIntent.dsTaint);
        SmsMessage.SubmitPdu pdu;
        pdu = SmsMessage.getSubmitPdu(
                scAddr, destAddr, destPort, data, (deliveryIntent != null));
        {
            sendRawPdu(pdu.encodedScAddress, pdu.encodedMessage, sentIntent, deliveryIntent);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.930 -0400", hash_original_method = "5889D931B0AF2BA9EF13AED6A1D3F698", hash_generated_method = "83F85C484F8AD25411C0AC7A8795E6A1")
    @DSModeled(DSC.SAFE)
    @Override
    protected void sendText(String destAddr, String scAddr, String text,
            PendingIntent sentIntent, PendingIntent deliveryIntent) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(scAddr);
        dsTaint.addTaint(destAddr);
        dsTaint.addTaint(sentIntent.dsTaint);
        dsTaint.addTaint(deliveryIntent.dsTaint);
        SmsMessage.SubmitPdu pdu;
        pdu = SmsMessage.getSubmitPdu(
                scAddr, destAddr, text, (deliveryIntent != null));
        {
            sendRawPdu(pdu.encodedScAddress, pdu.encodedMessage, sentIntent, deliveryIntent);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.931 -0400", hash_original_method = "9DEF445F0373354182FDA1EF238BF843", hash_generated_method = "8B4002D856B535E94D60498ED6EAF479")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected TextEncodingDetails calculateLength(CharSequence messageBody,
            boolean use7bitOnly) {
        dsTaint.addTaint(messageBody);
        dsTaint.addTaint(use7bitOnly);
        TextEncodingDetails var43C10878969A86A3A296086B315FD31F_1578329479 = (SmsMessage.calculateLength(messageBody, use7bitOnly));
        return (TextEncodingDetails)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return SmsMessage.calculateLength(messageBody, use7bitOnly);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.931 -0400", hash_original_method = "D46F86683A1628DBA1448E14FF571355", hash_generated_method = "10D5B18BA00A3F1EA9F8492C01955DE4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void sendNewSubmitPdu(String destinationAddress, String scAddress,
            String message, SmsHeader smsHeader, int encoding,
            PendingIntent sentIntent, PendingIntent deliveryIntent, boolean lastPart) {
        dsTaint.addTaint(message);
        dsTaint.addTaint(lastPart);
        dsTaint.addTaint(destinationAddress);
        dsTaint.addTaint(scAddress);
        dsTaint.addTaint(encoding);
        dsTaint.addTaint(sentIntent.dsTaint);
        dsTaint.addTaint(deliveryIntent.dsTaint);
        dsTaint.addTaint(smsHeader.dsTaint);
        SmsMessage.SubmitPdu pdu;
        pdu = SmsMessage.getSubmitPdu(scAddress, destinationAddress,
                message, deliveryIntent != null, SmsHeader.toByteArray(smsHeader),
                encoding, smsHeader.languageTable, smsHeader.languageShiftTable);
        {
            sendRawPdu(pdu.encodedScAddress, pdu.encodedMessage, sentIntent, deliveryIntent);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.931 -0400", hash_original_method = "FF8E1B494DDC1956B0825172C230EA31", hash_generated_method = "B2BD5928A77D4B69C6308F72A61C0E63")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void sendSms(SmsTracker tracker) {
        dsTaint.addTaint(tracker.dsTaint);
        HashMap<String, Object> map;
        map = tracker.mData;
        byte smsc[];
        smsc = (byte[]) map.get("smsc");
        byte pdu[];
        pdu = (byte[]) map.get("pdu");
        Message reply;
        reply = obtainMessage(EVENT_SEND_SMS_COMPLETE, tracker);
        mCm.sendSMS(IccUtils.bytesToHexString(smsc), IccUtils.bytesToHexString(pdu), reply);
        // ---------- Original Method ----------
        //HashMap<String, Object> map = tracker.mData;
        //byte smsc[] = (byte[]) map.get("smsc");
        //byte pdu[] = (byte[]) map.get("pdu");
        //Message reply = obtainMessage(EVENT_SEND_SMS_COMPLETE, tracker);
        //mCm.sendSMS(IccUtils.bytesToHexString(smsc), IccUtils.bytesToHexString(pdu), reply);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.931 -0400", hash_original_method = "72A464580F37288F468EE51C88A0917A", hash_generated_method = "D1212444E50B028B8A353FCFB8FB697C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void acknowledgeLastIncomingSms(boolean success, int result, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(result);
        dsTaint.addTaint(success);
        mCm.acknowledgeLastIncomingGsmSms(success, resultToCause(result), response);
        // ---------- Original Method ----------
        //mCm.acknowledgeLastIncomingGsmSms(success, resultToCause(result), response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.931 -0400", hash_original_method = "43CB38824F520614242805C962124F56", hash_generated_method = "19C9713015A03EB3D91DB800B4276B84")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.931 -0400", hash_original_method = "4513E8DEDD790BB664A98AD56B29A135", hash_generated_method = "964953F205B5F09CAF3381904AE39299")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void handleBroadcastSms(AsyncResult ar) {
        dsTaint.addTaint(ar.dsTaint);
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
                boolean var8492AE2C695A56B730381A28B8BA3F6D_1223373139 = (iter.hasNext());
                {
                    SmsCbConcatInfo info;
                    info = iter.next();
                    {
                        boolean var0270A608337A35ABA6617D8040104D0F_1019319672 = (!info.matchesLocation(plmn, lac, cid));
                        {
                            iter.remove();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (RuntimeException e)
        { }
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static final class SmsCbConcatInfo {
        private final SmsCbHeader mHeader;
        private final String mPlmn;
        private final int mLac;
        private final int mCid;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.932 -0400", hash_original_method = "D7F908FE9EEA79B2D247A82A8EA2135C", hash_generated_method = "9B234B4D541D9C088416102101F5D5C4")
        @DSModeled(DSC.SAFE)
        public SmsCbConcatInfo(SmsCbHeader header, String plmn, int lac, int cid) {
            dsTaint.addTaint(plmn);
            dsTaint.addTaint(cid);
            dsTaint.addTaint(header.dsTaint);
            dsTaint.addTaint(lac);
            // ---------- Original Method ----------
            //mHeader = header;
            //mPlmn = plmn;
            //mLac = lac;
            //mCid = cid;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.932 -0400", hash_original_method = "EE152888A937A1561BADC909DEBD7300", hash_generated_method = "0128406985433CC74DBF8E6F0E3DEDCE")
        @DSModeled(DSC.SAFE)
        @Override
        public int hashCode() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mHeader.messageIdentifier * 31 + mHeader.updateNumber;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.932 -0400", hash_original_method = "A4665EFAF0A95C2E46EAC850D0E6C5D5", hash_generated_method = "08A01EEBDE026AC0BD7C270BBCBAA03F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean equals(Object obj) {
            dsTaint.addTaint(obj.dsTaint);
            {
                SmsCbConcatInfo other;
                other = (SmsCbConcatInfo)obj;
                {
                    boolean varBB88E0D05F92693B90C9BE1E32F42C62_838839743 = (matchesLocation(other.mPlmn, other.mLac, other.mCid));
                } //End block
            } //End block
            return dsTaint.getTaintBoolean();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.932 -0400", hash_original_method = "16D562DE8E79921485CB55DC774779E3", hash_generated_method = "80500AB735D8F5E1C177A0655EE7F0E3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean matchesLocation(String plmn, int lac, int cid) {
            dsTaint.addTaint(plmn);
            dsTaint.addTaint(cid);
            dsTaint.addTaint(lac);
            //Begin case SmsCbMessage.GEOGRAPHICAL_SCOPE_PLMN_WIDE 
            boolean var1B5436BDE88E386A54C0FBA50F7E9CF9_1122482277 = (mPlmn != null && mPlmn.equals(plmn));
            //End case SmsCbMessage.GEOGRAPHICAL_SCOPE_PLMN_WIDE 
            return dsTaint.getTaintBoolean();
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


    
}


