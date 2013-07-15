package com.android.internal.telephony.gsm;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.446 -0400", hash_original_field = "D23A9A1E20D1A7A9C562EB626C5216B0", hash_generated_field = "FB0C4AC891EDC21FFB7A5101DD66CA15")

    private UsimDataDownloadHandler mDataDownloadHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.446 -0400", hash_original_field = "29454096E52BB79CDB7B876CEFEF19B3", hash_generated_field = "9A4B59DC2D3D1F23A20F3C6764DA1638")

    private final HashMap<SmsCbConcatInfo, byte[][]> mSmsCbPageMap = new HashMap<SmsCbConcatInfo, byte[][]>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.447 -0400", hash_original_method = "00834B5C758A658CCABAFC48B413096E", hash_generated_method = "4C0BACD30169DA11E6028A639D80B3DB")
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
        
        
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.447 -0400", hash_original_method = "FC96C37EC7CCEA012658804CB9F94924", hash_generated_method = "AB9F18314E4DF06E27ECE87D12F5EA19")
    @Override
    public void dispose() {
        mCm.unSetOnNewGsmSms(this);
        mCm.unSetOnSmsStatus(this);
        mCm.unSetOnNewGsmBroadcastSms(this);
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.448 -0400", hash_original_method = "1D516C6BB697A8ECCBFC751AA141CC3E", hash_generated_method = "868E4A3F73B37D2E0A6EF61755DCD898")
    @Override
    protected String getFormat() {
        String varB4EAC82CA7396A68D541C85D26508E83_2086974859 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2086974859 = android.telephony.SmsMessage.FORMAT_3GPP;
        varB4EAC82CA7396A68D541C85D26508E83_2086974859.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2086974859;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.448 -0400", hash_original_method = "789365F05DDE44536DDE00C9B93C643B", hash_generated_method = "4D2E0FF70727E2A21E1DB14A9DAF657C")
    @Override
    public void handleMessage(Message msg) {
        
        handleStatusReport((AsyncResult) msg.obj);
        
        
        handleBroadcastSms((AsyncResult)msg.obj);
        
        
        AsyncResult ar = (AsyncResult) msg.obj;
        
        
        {
            Log.d(TAG, "Successfully wrote SMS-PP message to UICC");
            mCm.acknowledgeLastIncomingGsmSms(true, 0, null);
        } 
        {
            Log.d(TAG, "Failed to write SMS-PP message to UICC", ar.exception);
            mCm.acknowledgeLastIncomingGsmSms(false,
                        CommandsInterface.GSM_SMS_FAIL_CAUSE_UNSPECIFIED_ERROR, null);
        } 
        
        
        super.handleMessage(msg);
        
        addTaint(msg.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.449 -0400", hash_original_method = "4DDABCDA44FFF28C561B2585B61E25F7", hash_generated_method = "00DC53C45742429184914E0A7FC0A057")
    private void handleStatusReport(AsyncResult ar) {
        String pduString = (String) ar.result;
        SmsMessage sms = SmsMessage.newFromCDS(pduString);
        {
            int tpStatus = sms.getStatus();
            int messageRef = sms.messageRef;
            {
                int i = 0;
                int count = deliveryPendingList.size();
                {
                    SmsTracker tracker = deliveryPendingList.get(i);
                    {
                        {
                            deliveryPendingList.remove(i);
                        } 
                        PendingIntent intent = tracker.mDeliveryIntent;
                        Intent fillIn = new Intent();
                        fillIn.putExtra("pdu", IccUtils.hexStringToBytes(pduString));
                        fillIn.putExtra("format", android.telephony.SmsMessage.FORMAT_3GPP);
                        try 
                        {
                            intent.send(mContext, Activity.RESULT_OK, fillIn);
                        } 
                        catch (CanceledException ex)
                        { }
                    } 
                } 
            } 
        } 
        acknowledgeLastIncomingSms(true, Intents.RESULT_SMS_HANDLED, null);
        addTaint(ar.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.451 -0400", hash_original_method = "00DA5224E05DFE04589B7B4693E817E4", hash_generated_method = "42B271C9503A23185807454EA2C31034")
    @Override
    public int dispatchMessage(SmsMessageBase smsb) {
        SmsMessage sms = (SmsMessage) smsb;
        {
            boolean varB6031355C0905631735F722E8A67DE3D_227826740 = (sms.isTypeZero());
            {
                Log.d(TAG, "Received short message type 0, Don't display or store it. Send Ack");
            } 
        } 
        {
            boolean varA5EE62D09AEC8F9FD1898F2B6486F22D_1451082805 = (sms.isUsimDataDownload());
            {
                UsimServiceTable ust = mPhone.getUsimServiceTable();
                {
                    boolean var12D35405AA0257D7AD5F7F54F16478EA_412161972 = (ust != null && ust.isAvailable(
                    UsimServiceTable.UsimService.DATA_DL_VIA_SMS_PP));
                    {
                        Log.d(TAG, "Received SMS-PP data download, sending to UICC.");
                        int var8B022B4480B8D4E4694849310BDCE5C7_1565352473 = (mDataDownloadHandler.startDataDownload(sms));
                    } 
                    {
                        Log.d(TAG, "DATA_DL_VIA_SMS_PP service not available, storing message to UICC.");
                        String smsc = IccUtils.bytesToHexString(
                        PhoneNumberUtils.networkPortionToCalledPartyBCDWithLength(
                                sms.getServiceCenterAddress()));
                        mCm.writeSmsToSim(SmsManager.STATUS_ON_ICC_UNREAD, smsc,
                        IccUtils.bytesToHexString(sms.getPdu()),
                        obtainMessage(EVENT_WRITE_SMS_COMPLETE));
                    } 
                } 
            } 
        } 
        {
            Log.d(TAG, "Received short message on device which doesn't support "
                    + "SMS service. Ignored.");
        } 
        boolean handled = false;
        {
            boolean varF8C0D9A02B2BCE7F3BBAAC567BF16F6E_239659086 = (sms.isMWISetMessage());
            {
                mPhone.setVoiceMessageWaiting(1, -1);
                handled = sms.isMwiDontStore();
                {
                    Log.d(TAG, "Received voice mail indicator set SMS shouldStore=" + !handled);
                } 
            } 
            {
                boolean var5C4804CFC9656A5E0B83164B653B7DCC_1812024611 = (sms.isMWIClearMessage());
                {
                    mPhone.setVoiceMessageWaiting(1, 0);
                    handled = sms.isMwiDontStore();
                    {
                        Log.d(TAG, "Received voice mail indicator clear SMS shouldStore=" + !handled);
                    } 
                } 
            } 
        } 
        {
            boolean varA6EC97D1C251BAAEFB63A742DEBA1DB1_2060352682 = (!mStorageMonitor.isStorageAvailable() &&
                sms.getMessageClass() != MessageClass.CLASS_0);
        } 
        int var3F541A711EB85996C611FA5F634F0615_1721041801 = (dispatchNormalMessage(smsb));
        addTaint(smsb.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_459044838 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_459044838;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.452 -0400", hash_original_method = "3D7E3502DD1585858E097F3A6DC759F7", hash_generated_method = "D707952955E557825FB492761BAD9DDF")
    @Override
    protected void sendData(String destAddr, String scAddr, int destPort,
            byte[] data, PendingIntent sentIntent, PendingIntent deliveryIntent) {
        SmsMessage.SubmitPdu pdu = SmsMessage.getSubmitPdu(
                scAddr, destAddr, destPort, data, (deliveryIntent != null));
        {
            sendRawPdu(pdu.encodedScAddress, pdu.encodedMessage, sentIntent, deliveryIntent);
        } 
        addTaint(destAddr.getTaint());
        addTaint(scAddr.getTaint());
        addTaint(destPort);
        addTaint(data[0]);
        addTaint(sentIntent.getTaint());
        addTaint(deliveryIntent.getTaint());
        
        
                
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.452 -0400", hash_original_method = "5889D931B0AF2BA9EF13AED6A1D3F698", hash_generated_method = "FCD292E9120EE9471DEB0777EB8A6177")
    @Override
    protected void sendText(String destAddr, String scAddr, String text,
            PendingIntent sentIntent, PendingIntent deliveryIntent) {
        SmsMessage.SubmitPdu pdu = SmsMessage.getSubmitPdu(
                scAddr, destAddr, text, (deliveryIntent != null));
        {
            sendRawPdu(pdu.encodedScAddress, pdu.encodedMessage, sentIntent, deliveryIntent);
        } 
        addTaint(destAddr.getTaint());
        addTaint(scAddr.getTaint());
        addTaint(text.getTaint());
        addTaint(sentIntent.getTaint());
        addTaint(deliveryIntent.getTaint());
        
        
                
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.453 -0400", hash_original_method = "9DEF445F0373354182FDA1EF238BF843", hash_generated_method = "4B628FCCE98D7D740B723ECC78F90F91")
    @Override
    protected TextEncodingDetails calculateLength(CharSequence messageBody,
            boolean use7bitOnly) {
        TextEncodingDetails varB4EAC82CA7396A68D541C85D26508E83_1332946381 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1332946381 = SmsMessage.calculateLength(messageBody, use7bitOnly);
        addTaint(messageBody.getTaint());
        addTaint(use7bitOnly);
        varB4EAC82CA7396A68D541C85D26508E83_1332946381.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1332946381;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.453 -0400", hash_original_method = "D46F86683A1628DBA1448E14FF571355", hash_generated_method = "DE63B20A92F78042F3D43AEED87F4BFD")
    @Override
    protected void sendNewSubmitPdu(String destinationAddress, String scAddress,
            String message, SmsHeader smsHeader, int encoding,
            PendingIntent sentIntent, PendingIntent deliveryIntent, boolean lastPart) {
        SmsMessage.SubmitPdu pdu = SmsMessage.getSubmitPdu(scAddress, destinationAddress,
                message, deliveryIntent != null, SmsHeader.toByteArray(smsHeader),
                encoding, smsHeader.languageTable, smsHeader.languageShiftTable);
        {
            sendRawPdu(pdu.encodedScAddress, pdu.encodedMessage, sentIntent, deliveryIntent);
        } 
        addTaint(destinationAddress.getTaint());
        addTaint(scAddress.getTaint());
        addTaint(message.getTaint());
        addTaint(smsHeader.getTaint());
        addTaint(encoding);
        addTaint(sentIntent.getTaint());
        addTaint(deliveryIntent.getTaint());
        addTaint(lastPart);
        
        
                
                
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.454 -0400", hash_original_method = "FF8E1B494DDC1956B0825172C230EA31", hash_generated_method = "DEF89BEE1EFC5D760E29EA6C9D62F48B")
    @Override
    protected void sendSms(SmsTracker tracker) {
        HashMap<String, Object> map = tracker.mData;
        byte smsc[] = (byte[]) map.get("smsc");
        byte pdu[] = (byte[]) map.get("pdu");
        Message reply = obtainMessage(EVENT_SEND_SMS_COMPLETE, tracker);
        mCm.sendSMS(IccUtils.bytesToHexString(smsc), IccUtils.bytesToHexString(pdu), reply);
        addTaint(tracker.getTaint());
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.454 -0400", hash_original_method = "72A464580F37288F468EE51C88A0917A", hash_generated_method = "A946FC2869313F60A0BAA57198780470")
    @Override
    protected void acknowledgeLastIncomingSms(boolean success, int result, Message response) {
        mCm.acknowledgeLastIncomingGsmSms(success, resultToCause(result), response);
        addTaint(success);
        addTaint(result);
        addTaint(response.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.455 -0400", hash_original_method = "4513E8DEDD790BB664A98AD56B29A135", hash_generated_method = "23D14BC2D7EB23E26912A32878903124")
    private void handleBroadcastSms(AsyncResult ar) {
        try 
        {
            byte[] receivedPdu = (byte[])ar.result;
            {
                {
                    int i = 0;
                    i += 8;
                    {
                        StringBuilder sb = new StringBuilder("SMS CB pdu data: ");
                        {
                            int j = i;
                            {
                                int b = receivedPdu[j] & 0xff;
                                {
                                    sb.append('0');
                                } 
                                sb.append(Integer.toHexString(b)).append(' ');
                            } 
                        } 
                        Log.d(TAG, sb.toString());
                    } 
                } 
            } 
            SmsCbHeader header = new SmsCbHeader(receivedPdu);
            String plmn = SystemProperties.get(TelephonyProperties.PROPERTY_OPERATOR_NUMERIC);
            GsmCellLocation cellLocation = (GsmCellLocation) mPhone.getCellLocation();
            int lac = cellLocation.getLac();
            int cid = cellLocation.getCid();
            byte[][] pdus;
            {
                SmsCbConcatInfo concatInfo = new SmsCbConcatInfo(header, plmn, lac, cid);
                pdus = mSmsCbPageMap.get(concatInfo);
                {
                    pdus = new byte[header.nrOfPages][];
                    mSmsCbPageMap.put(concatInfo, pdus);
                } 
                pdus[header.pageIndex - 1] = receivedPdu;
                {
                    int i = 0;
                } 
                mSmsCbPageMap.remove(concatInfo);
            } 
            {
                pdus = new byte[1][];
                pdus[0] = receivedPdu;
            } 
            boolean isEmergencyMessage = SmsCbHeader.isEmergencyMessage(header.messageIdentifier);
            dispatchBroadcastPdus(pdus, isEmergencyMessage);
            Iterator<SmsCbConcatInfo> iter = mSmsCbPageMap.keySet().iterator();
            {
                boolean var8492AE2C695A56B730381A28B8BA3F6D_1356145089 = (iter.hasNext());
                {
                    SmsCbConcatInfo info = iter.next();
                    {
                        boolean var0270A608337A35ABA6617D8040104D0F_1058080067 = (!info.matchesLocation(plmn, lac, cid));
                        {
                            iter.remove();
                        } 
                    } 
                } 
            } 
        } 
        catch (RuntimeException e)
        { }
        addTaint(ar.getTaint());
        
        
    }

    
    private static final class SmsCbConcatInfo {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.455 -0400", hash_original_field = "F43892C15B0C2065A0D775948F742664", hash_generated_field = "F13EAF462BF75A9C18B71C5567248AEE")

        private SmsCbHeader mHeader;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.455 -0400", hash_original_field = "0CC356ECF78F7DFAE70968CD3E9A7877", hash_generated_field = "5B8CD52C7682DA00C91E3E72EBFA9940")

        private String mPlmn;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.455 -0400", hash_original_field = "B2F9C701F6B9FA98A906A1D27571667E", hash_generated_field = "E1DF72766EAA7700CC09E2EF71762BF7")

        private int mLac;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.455 -0400", hash_original_field = "47909A4A63C9D0DF4D400D36305EA002", hash_generated_field = "6613038ECFEA58ECF70AB91998D5EB03")

        private int mCid;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.456 -0400", hash_original_method = "D7F908FE9EEA79B2D247A82A8EA2135C", hash_generated_method = "71F92BDBEEEF5CCD670C3BCCA9D92D30")
        public  SmsCbConcatInfo(SmsCbHeader header, String plmn, int lac, int cid) {
            mHeader = header;
            mPlmn = plmn;
            mLac = lac;
            mCid = cid;
            
            
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.456 -0400", hash_original_method = "EE152888A937A1561BADC909DEBD7300", hash_generated_method = "0F73C8A8A64127B05C615F2324475569")
        @Override
        public int hashCode() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_529121087 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_529121087;
            
            
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.456 -0400", hash_original_method = "A4665EFAF0A95C2E46EAC850D0E6C5D5", hash_generated_method = "299E7686BAAE3D27924F991E23B05997")
        @Override
        public boolean equals(Object obj) {
            {
                SmsCbConcatInfo other = (SmsCbConcatInfo)obj;
                {
                    boolean varBB88E0D05F92693B90C9BE1E32F42C62_1658281493 = (matchesLocation(other.mPlmn, other.mLac, other.mCid));
                } 
            } 
            addTaint(obj.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_982681597 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_982681597;
            
            
                
                
                        
                        
                        
                        
                        
                    
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.457 -0400", hash_original_method = "16D562DE8E79921485CB55DC774779E3", hash_generated_method = "193349220633A3450EA4033C26785C75")
        public boolean matchesLocation(String plmn, int lac, int cid) {
            
            boolean var1B5436BDE88E386A54C0FBA50F7E9CF9_12655947 = (mPlmn != null && mPlmn.equals(plmn));
            
            addTaint(plmn.getTaint());
            addTaint(lac);
            addTaint(cid);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2111819764 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2111819764;
            
            
                
                
                    
                        
                    
                
                    
                        
                    
                
                    
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.457 -0400", hash_original_field = "1E54D398F6654D474F0F5192DC98EDCC", hash_generated_field = "EFF0BA8EAA7A2E5FCD3601D1F8EC46DA")

    private static final String TAG = "GSM";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.457 -0400", hash_original_field = "50395D21AF66157B4B10912FCD54B108", hash_generated_field = "E72B26964A801FCD13745348E2F39E5E")

    private static final int EVENT_NEW_SMS_STATUS_REPORT = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.457 -0400", hash_original_field = "BDB4FEC067A25D13FF04C51317B87865", hash_generated_field = "1C09FC92D14FE7DA05FCFF7B41C8CA1E")

    private static final int EVENT_NEW_BROADCAST_SMS = 101;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.457 -0400", hash_original_field = "9436FC3322A611484CE8FC6322B0170D", hash_generated_field = "0CD824DED9BF2D233D61D30AB013D005")

    private static final int EVENT_WRITE_SMS_COMPLETE = 102;
}

