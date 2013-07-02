package com.android.internal.telephony.cdma;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.app.Activity;
import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Message;
import android.os.SystemProperties;
import android.preference.PreferenceManager;
import android.provider.Telephony;
import android.provider.Telephony.Sms.Intents;
import android.telephony.SmsManager;
import android.telephony.SmsMessage.MessageClass;
import android.util.Log;
import com.android.internal.telephony.CommandsInterface;
import com.android.internal.telephony.SMSDispatcher;
import com.android.internal.telephony.SmsHeader;
import com.android.internal.telephony.SmsMessageBase;
import com.android.internal.telephony.SmsMessageBase.TextEncodingDetails;
import com.android.internal.telephony.SmsStorageMonitor;
import com.android.internal.telephony.SmsUsageMonitor;
import com.android.internal.telephony.TelephonyProperties;
import com.android.internal.telephony.WspTypeDecoder;
import com.android.internal.telephony.cdma.sms.SmsEnvelope;
import com.android.internal.telephony.cdma.sms.UserData;
import com.android.internal.util.HexDump;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.HashMap;
import android.content.res.Resources;

final class CdmaSMSDispatcher extends SMSDispatcher {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.110 -0400", hash_original_field = "99435B34EC210BD6AB4CF145BA066DD0", hash_generated_field = "32AEC3A3AE4EA72117A81D9C026D630A")

    private byte[] mLastDispatchedSmsFingerprint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.110 -0400", hash_original_field = "BC88600A2C397EC19F71B1A872168269", hash_generated_field = "238150EEC26DEB25A5C3E3E164D32D3E")

    private byte[] mLastAcknowledgedSmsFingerprint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.110 -0400", hash_original_field = "67D22654A80F6A8B030E4469FC9F96B1", hash_generated_field = "4B29A4BC6301E562FA9789ADCA210E6D")

    private final boolean mCheckForDuplicatePortsInOmadmWapPush = Resources.getSystem().getBoolean(
            com.android.internal.R.bool.config_duplicate_port_omadm_wappush);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.110 -0400", hash_original_method = "2E2EEE07B541CA6772FE9654DB0B546E", hash_generated_method = "E2D0386AE236E0FF8392A73CEB374B84")
      CdmaSMSDispatcher(CDMAPhone phone, SmsStorageMonitor storageMonitor,
            SmsUsageMonitor usageMonitor) {
        super(phone, storageMonitor, usageMonitor);
        mCm.setOnNewCdmaSms(this, EVENT_NEW_SMS, null);
        addTaint(phone.getTaint());
        addTaint(storageMonitor.getTaint());
        addTaint(usageMonitor.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.111 -0400", hash_original_method = "6D5F69086FA9BAB54819022B7E1C6EB4", hash_generated_method = "80D407A54A94447C6E35DFD5DF927FC8")
    @Override
    public void dispose() {
        mCm.unSetOnNewCdmaSms(this);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.111 -0400", hash_original_method = "77401C8F23584A16465C2C7060977D74", hash_generated_method = "16AF466DE7CC04B7C0A5EE90E8CD2E28")
    @Override
    protected String getFormat() {
        String varB4EAC82CA7396A68D541C85D26508E83_947247899 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_947247899 = android.telephony.SmsMessage.FORMAT_3GPP2;
        varB4EAC82CA7396A68D541C85D26508E83_947247899.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_947247899;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.112 -0400", hash_original_method = "D8F9BF94E3CE828F06F15D06BD41575B", hash_generated_method = "EB4CA9D0ADAC47FB704B3A05242A7B5B")
    private void handleCdmaStatusReport(SmsMessage sms) {
        {
            int i = 0;
            int count = deliveryPendingList.size();
            {
                SmsTracker tracker = deliveryPendingList.get(i);
                {
                    deliveryPendingList.remove(i);
                    PendingIntent intent = tracker.mDeliveryIntent;
                    Intent fillIn = new Intent();
                    fillIn.putExtra("pdu", sms.getPdu());
                    fillIn.putExtra("format", android.telephony.SmsMessage.FORMAT_3GPP2);
                    try 
                    {
                        intent.send(mContext, Activity.RESULT_OK, fillIn);
                    } 
                    catch (CanceledException ex)
                    { }
                } 
            } 
        } 
        addTaint(sms.getTaint());
        
        
            
            
                
                
                
                
                
                
                    
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.113 -0400", hash_original_method = "AEF7CF36D035C3FD2F985EB9DE02C895", hash_generated_method = "BD606AEF81D3010F1C900CAF3EF7C7A7")
    @Override
    public int dispatchMessage(SmsMessageBase smsb) {
        String inEcm = SystemProperties.get(TelephonyProperties.PROPERTY_INECM_MODE, "false");
        {
            boolean varA0F6E951DAEE6AF07E9F4144653EDB3A_1103336626 = (inEcm.equals("true"));
        } 
        {
            Log.d(TAG, "Received short message on device which doesn't support "
                    + "receiving SMS. Ignored.");
        } 
        SmsMessage sms = (SmsMessage) smsb;
        mLastDispatchedSmsFingerprint = sms.getIncomingSmsFingerprint();
        {
            boolean varDF6EBE56566BC9DCD284E2602989ED53_1526222085 = (mLastAcknowledgedSmsFingerprint != null &&
                Arrays.equals(mLastDispatchedSmsFingerprint, mLastAcknowledgedSmsFingerprint));
        } 
        sms.parseSms();
        int teleService = sms.getTeleService();
        boolean handled = false;
        {
            int voicemailCount = sms.getNumOfVoicemails();
            Log.d(TAG, "Voicemail count=" + voicemailCount);
            SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(
                    mContext);
            SharedPreferences.Editor editor = sp.edit();
            editor.putInt(CDMAPhone.VM_COUNT_CDMA, voicemailCount);
            editor.apply();
            mPhone.setVoiceMessageWaiting(1, voicemailCount);
            handled = true;
        } 
        {
            boolean var6BFACB98B67502CFF9E96D2D882A1268_1896697803 = (((SmsEnvelope.TELESERVICE_WMT == teleService) ||
                (SmsEnvelope.TELESERVICE_WEMT == teleService)) &&
                sms.isStatusReportMessage());
            {
                handleCdmaStatusReport(sms);
                handled = true;
            } 
            {
                boolean varBE4A2285BBE5F32B453C107F5877041B_418564028 = ((sms.getUserData() == null));
                {
                    {
                        Log.d(TAG, "Received SMS without user data");
                    } 
                    handled = true;
                } 
            } 
        } 
        {
            boolean varA6EC97D1C251BAAEFB63A742DEBA1DB1_631514247 = (!mStorageMonitor.isStorageAvailable() &&
                sms.getMessageClass() != MessageClass.CLASS_0);
        } 
        {
            int varD40C172EBE77C0D6F53AB9839B849E95_520724886 = (processCdmaWapPdu(sms.getUserData(), sms.messageRef,
                    sms.getOriginatingAddress()));
        } 
        {
            boolean var3D2190DCE0A796AA437486D706358C65_985499840 = ((SmsEnvelope.TELESERVICE_WMT != teleService) &&
                (SmsEnvelope.TELESERVICE_WEMT != teleService) &&
                (SmsEnvelope.MESSAGE_TYPE_BROADCAST != sms.getMessageType()));
        } 
        int var3F541A711EB85996C611FA5F634F0615_1653389549 = (dispatchNormalMessage(smsb));
        addTaint(smsb.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_658569763 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_658569763;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.114 -0400", hash_original_method = "7B6C844E67A0CC9BDD3E050A8ACE8852", hash_generated_method = "154DF23989F6BE3A528756CCF63C4449")
    protected int processCdmaWapPdu(byte[] pdu, int referenceNumber, String address) {
        int index = 0;
        int msgType = (0xFF & pdu[index++]);
        int totalSegments = (0xFF & pdu[index++]);
        int segment = (0xFF & pdu[index++]);
        int sourcePort = 0;
        int destinationPort = 0;
        {
            sourcePort = (0xFF & pdu[index++]) << 8;
            sourcePort |= 0xFF & pdu[index++];
            destinationPort = (0xFF & pdu[index++]) << 8;
            destinationPort |= 0xFF & pdu[index++];
            {
                {
                    boolean var2D609C19B2CBA7666BC03ED4CBB382E6_1201416112 = (checkDuplicatePortOmadmWappush(pdu,index));
                    {
                        index = index + 4;
                    } 
                } 
            } 
        } 
        byte[] userData = new byte[pdu.length - index];
        System.arraycopy(pdu, index, userData, 0, pdu.length - index);
        int var2CF4D70DCF81F3DCA9EA65A5EFDC134E_1826341886 = (processMessagePart(userData, address, referenceNumber, segment, totalSegments,
                0L, destinationPort, true));
        addTaint(pdu[0]);
        addTaint(referenceNumber);
        addTaint(address.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1082361409 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1082361409;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.115 -0400", hash_original_method = "1C79B20542F5EA033BD01F30A8B0455D", hash_generated_method = "6B58C21148E618C62C69E17B12FBF1EE")
    @Override
    protected void sendData(String destAddr, String scAddr, int destPort,
            byte[] data, PendingIntent sentIntent, PendingIntent deliveryIntent) {
        SmsMessage.SubmitPdu pdu = SmsMessage.getSubmitPdu(
                scAddr, destAddr, destPort, data, (deliveryIntent != null));
        sendSubmitPdu(pdu, sentIntent, deliveryIntent);
        addTaint(destAddr.getTaint());
        addTaint(scAddr.getTaint());
        addTaint(destPort);
        addTaint(data[0]);
        addTaint(sentIntent.getTaint());
        addTaint(deliveryIntent.getTaint());
        
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.115 -0400", hash_original_method = "5D58764547BE2148EE8A5F6EEE636061", hash_generated_method = "9452BBC5E62EB8EB5D22A444C1191BB6")
    @Override
    protected void sendText(String destAddr, String scAddr, String text,
            PendingIntent sentIntent, PendingIntent deliveryIntent) {
        SmsMessage.SubmitPdu pdu = SmsMessage.getSubmitPdu(
                scAddr, destAddr, text, (deliveryIntent != null), null);
        sendSubmitPdu(pdu, sentIntent, deliveryIntent);
        addTaint(destAddr.getTaint());
        addTaint(scAddr.getTaint());
        addTaint(text.getTaint());
        addTaint(sentIntent.getTaint());
        addTaint(deliveryIntent.getTaint());
        
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.116 -0400", hash_original_method = "9DEF445F0373354182FDA1EF238BF843", hash_generated_method = "C92434467C3C6D62F8C74C6B62A737A8")
    @Override
    protected TextEncodingDetails calculateLength(CharSequence messageBody,
            boolean use7bitOnly) {
        TextEncodingDetails varB4EAC82CA7396A68D541C85D26508E83_609974667 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_609974667 = SmsMessage.calculateLength(messageBody, use7bitOnly);
        addTaint(messageBody.getTaint());
        addTaint(use7bitOnly);
        varB4EAC82CA7396A68D541C85D26508E83_609974667.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_609974667;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.116 -0400", hash_original_method = "77E27619E0BAA0675283D74233CDEF70", hash_generated_method = "19524CB08CB8F8A945313822E4F39A6B")
    @Override
    protected void sendNewSubmitPdu(String destinationAddress, String scAddress,
            String message, SmsHeader smsHeader, int encoding,
            PendingIntent sentIntent, PendingIntent deliveryIntent, boolean lastPart) {
        UserData uData = new UserData();
        uData.payloadStr = message;
        uData.userDataHeader = smsHeader;
        {
            uData.msgEncoding = UserData.ENCODING_GSM_7BIT_ALPHABET;
        } 
        {
            uData.msgEncoding = UserData.ENCODING_UNICODE_16;
        } 
        uData.msgEncodingSet = true;
        SmsMessage.SubmitPdu submitPdu = SmsMessage.getSubmitPdu(destinationAddress,
                uData, (deliveryIntent != null) && lastPart);
        sendSubmitPdu(submitPdu, sentIntent, deliveryIntent);
        addTaint(destinationAddress.getTaint());
        addTaint(scAddress.getTaint());
        addTaint(message.getTaint());
        addTaint(smsHeader.getTaint());
        addTaint(encoding);
        addTaint(sentIntent.getTaint());
        addTaint(deliveryIntent.getTaint());
        addTaint(lastPart);
        
        
        
        
        
            
        
            
        
        
        
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.117 -0400", hash_original_method = "DEF3D00017A9EC7ED64C2C82C9EF5E11", hash_generated_method = "6DA1E2E7B490810720A732434B0BBC08")
    protected void sendSubmitPdu(SmsMessage.SubmitPdu pdu,
            PendingIntent sentIntent, PendingIntent deliveryIntent) {
        {
            boolean varA40FEF0397CC3CD9D2B924BC5AEF9981_1069794868 = (SystemProperties.getBoolean(TelephonyProperties.PROPERTY_INECM_MODE, false));
            {
                {
                    try 
                    {
                        sentIntent.send(SmsManager.RESULT_ERROR_NO_SERVICE);
                    } 
                    catch (CanceledException ex)
                    { }
                } 
                {
                    Log.d(TAG, "Block SMS in Emergency Callback mode");
                } 
            } 
        } 
        sendRawPdu(pdu.encodedScAddress, pdu.encodedMessage, sentIntent, deliveryIntent);
        addTaint(pdu.getTaint());
        addTaint(sentIntent.getTaint());
        addTaint(deliveryIntent.getTaint());
        
        
            
                
                    
                
            
            
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.117 -0400", hash_original_method = "B01C05D91305560949593CF3FA30240C", hash_generated_method = "1B1A91891B4E9F6BF0D881836423711D")
    @Override
    protected void sendSms(SmsTracker tracker) {
        HashMap<String, Object> map = tracker.mData;
        byte pdu[] = (byte[]) map.get("pdu");
        Message reply = obtainMessage(EVENT_SEND_SMS_COMPLETE, tracker);
        mCm.sendCdmaSms(pdu, reply);
        addTaint(tracker.getTaint());
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.117 -0400", hash_original_method = "8A630C8BC501F81DB51344181E02B8CE", hash_generated_method = "0FBB411C178B9285903278F0E402141F")
    @Override
    protected void acknowledgeLastIncomingSms(boolean success, int result, Message response) {
        String inEcm = SystemProperties.get(TelephonyProperties.PROPERTY_INECM_MODE, "false");
        {
            boolean varA0F6E951DAEE6AF07E9F4144653EDB3A_78956471 = (inEcm.equals("true"));
        } 
        int causeCode = resultToCause(result);
        mCm.acknowledgeLastIncomingCdmaSms(success, causeCode, response);
        {
            mLastAcknowledgedSmsFingerprint = mLastDispatchedSmsFingerprint;
        } 
        mLastDispatchedSmsFingerprint = null;
        addTaint(success);
        addTaint(result);
        addTaint(response.getTaint());
        
        
        
            
        
        
        
        
            
        
        
    }

    
    private static int resultToCause(int rc) {
        switch (rc) {
        case Activity.RESULT_OK:
        case Intents.RESULT_SMS_HANDLED:
            return 0;
        case Intents.RESULT_SMS_OUT_OF_MEMORY:
            return CommandsInterface.CDMA_SMS_FAIL_CAUSE_RESOURCE_SHORTAGE;
        case Intents.RESULT_SMS_UNSUPPORTED:
            return CommandsInterface.CDMA_SMS_FAIL_CAUSE_INVALID_TELESERVICE_ID;
        case Intents.RESULT_SMS_GENERIC_ERROR:
        default:
            return CommandsInterface.CDMA_SMS_FAIL_CAUSE_ENCODING_PROBLEM;
        }
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean checkDuplicatePortOmadmWappush(byte[] origPdu, int index) {
        index += 4;
        byte[] omaPdu = new byte[origPdu.length - index];
        System.arraycopy(origPdu, index, omaPdu, 0, omaPdu.length);
        WspTypeDecoder pduDecoder = new WspTypeDecoder(omaPdu);
        int wspIndex = 2;
        if (pduDecoder.decodeUintvarInteger(wspIndex) == false) {
            return false;
        }
        wspIndex += pduDecoder.getDecodedDataLength();
        if (pduDecoder.decodeContentType(wspIndex) == false) {
            return false;
        }
        String mimeType = pduDecoder.getValueString();
        if (mimeType != null && mimeType.equals(WspTypeDecoder.CONTENT_TYPE_B_PUSH_SYNCML_NOTI)) {
            return true;
        }
        return false;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.118 -0400", hash_original_field = "82200A3ADDBE6AEFE6AAB2FA56CBEC0A", hash_generated_field = "E679783596AFAE58531AA760F376FE87")

    private static final String TAG = "CDMA";
}

