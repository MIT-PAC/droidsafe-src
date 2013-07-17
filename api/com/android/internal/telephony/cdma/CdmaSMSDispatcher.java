package com.android.internal.telephony.cdma;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.963 -0400", hash_original_field = "99435B34EC210BD6AB4CF145BA066DD0", hash_generated_field = "32AEC3A3AE4EA72117A81D9C026D630A")

    private byte[] mLastDispatchedSmsFingerprint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.963 -0400", hash_original_field = "BC88600A2C397EC19F71B1A872168269", hash_generated_field = "238150EEC26DEB25A5C3E3E164D32D3E")

    private byte[] mLastAcknowledgedSmsFingerprint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.963 -0400", hash_original_field = "67D22654A80F6A8B030E4469FC9F96B1", hash_generated_field = "4B29A4BC6301E562FA9789ADCA210E6D")

    private final boolean mCheckForDuplicatePortsInOmadmWapPush = Resources.getSystem().getBoolean(
            com.android.internal.R.bool.config_duplicate_port_omadm_wappush);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.963 -0400", hash_original_method = "2E2EEE07B541CA6772FE9654DB0B546E", hash_generated_method = "EBD30BE7030698566647192A32E6941B")
      CdmaSMSDispatcher(CDMAPhone phone, SmsStorageMonitor storageMonitor,
            SmsUsageMonitor usageMonitor) {
        super(phone, storageMonitor, usageMonitor);
        addTaint(usageMonitor.getTaint());
        addTaint(storageMonitor.getTaint());
        addTaint(phone.getTaint());
        mCm.setOnNewCdmaSms(this, EVENT_NEW_SMS, null);
        // ---------- Original Method ----------
        //mCm.setOnNewCdmaSms(this, EVENT_NEW_SMS, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.963 -0400", hash_original_method = "6D5F69086FA9BAB54819022B7E1C6EB4", hash_generated_method = "80D407A54A94447C6E35DFD5DF927FC8")
    @Override
    public void dispose() {
        mCm.unSetOnNewCdmaSms(this);
        // ---------- Original Method ----------
        //mCm.unSetOnNewCdmaSms(this);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.964 -0400", hash_original_method = "77401C8F23584A16465C2C7060977D74", hash_generated_method = "B7E61FF59CF9937536AB07B442E891D0")
    @Override
    protected String getFormat() {
String var7E8ED78256EA5640D81A12BE6B09A2A1_1605250742 =         android.telephony.SmsMessage.FORMAT_3GPP2;
        var7E8ED78256EA5640D81A12BE6B09A2A1_1605250742.addTaint(taint);
        return var7E8ED78256EA5640D81A12BE6B09A2A1_1605250742;
        // ---------- Original Method ----------
        //return android.telephony.SmsMessage.FORMAT_3GPP2;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.964 -0400", hash_original_method = "D8F9BF94E3CE828F06F15D06BD41575B", hash_generated_method = "03DD0AE38F414E7F49E6FBB331A7B67E")
    private void handleCdmaStatusReport(SmsMessage sms) {
        addTaint(sms.getTaint());
for(int i = 0, count = deliveryPendingList.size();i < count;i++)
        {
            SmsTracker tracker = deliveryPendingList.get(i);
            if(tracker.mMessageRef == sms.messageRef)            
            {
                deliveryPendingList.remove(i);
                PendingIntent intent = tracker.mDeliveryIntent;
                Intent fillIn = new Intent();
                fillIn.putExtra("pdu", sms.getPdu());
                fillIn.putExtra("format", android.telephony.SmsMessage.FORMAT_3GPP2);
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
        // ---------- Original Method ----------
        //for (int i = 0, count = deliveryPendingList.size(); i < count; i++) {
            //SmsTracker tracker = deliveryPendingList.get(i);
            //if (tracker.mMessageRef == sms.messageRef) {
                //deliveryPendingList.remove(i);
                //PendingIntent intent = tracker.mDeliveryIntent;
                //Intent fillIn = new Intent();
                //fillIn.putExtra("pdu", sms.getPdu());
                //fillIn.putExtra("format", android.telephony.SmsMessage.FORMAT_3GPP2);
                //try {
                    //intent.send(mContext, Activity.RESULT_OK, fillIn);
                //} catch (CanceledException ex) {}
                //break;  
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.966 -0400", hash_original_method = "AEF7CF36D035C3FD2F985EB9DE02C895", hash_generated_method = "C37AB51D81C76360B508473C8A4BE85E")
    @Override
    public int dispatchMessage(SmsMessageBase smsb) {
        addTaint(smsb.getTaint());
        if(smsb == null)        
        {
            int varFCC16322707A95E5743FED9CA64177EC_477490703 = (Intents.RESULT_SMS_GENERIC_ERROR);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_263437150 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_263437150;
        } //End block
        String inEcm = SystemProperties.get(TelephonyProperties.PROPERTY_INECM_MODE, "false");
        if(inEcm.equals("true"))        
        {
            int var4C0737507AD994723C875A6D0646D112_735394097 = (Activity.RESULT_OK);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_80383302 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_80383302;
        } //End block
        if(mSmsReceiveDisabled)        
        {
            Log.d(TAG, "Received short message on device which doesn't support "
                    + "receiving SMS. Ignored.");
            int var0A0A6D68560CC5EF46A3B9603DD175AA_1602877129 = (Intents.RESULT_SMS_HANDLED);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2052255385 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2052255385;
        } //End block
        SmsMessage sms = (SmsMessage) smsb;
        mLastDispatchedSmsFingerprint = sms.getIncomingSmsFingerprint();
        if(mLastAcknowledgedSmsFingerprint != null &&
                Arrays.equals(mLastDispatchedSmsFingerprint, mLastAcknowledgedSmsFingerprint))        
        {
            int var0A0A6D68560CC5EF46A3B9603DD175AA_1271053443 = (Intents.RESULT_SMS_HANDLED);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_731200924 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_731200924;
        } //End block
        sms.parseSms();
        int teleService = sms.getTeleService();
        boolean handled = false;
        if((SmsEnvelope.TELESERVICE_VMN == teleService) ||
                (SmsEnvelope.TELESERVICE_MWI == teleService))        
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
        } //End block
        else
        if(((SmsEnvelope.TELESERVICE_WMT == teleService) ||
                (SmsEnvelope.TELESERVICE_WEMT == teleService)) &&
                sms.isStatusReportMessage())        
        {
            handleCdmaStatusReport(sms);
            handled = true;
        } //End block
        else
        if((sms.getUserData() == null))        
        {
            if(false)            
            {
                Log.d(TAG, "Received SMS without user data");
            } //End block
            handled = true;
        } //End block
        if(handled)        
        {
            int var0A0A6D68560CC5EF46A3B9603DD175AA_1012168914 = (Intents.RESULT_SMS_HANDLED);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_477161868 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_477161868;
        } //End block
        if(!mStorageMonitor.isStorageAvailable() &&
                sms.getMessageClass() != MessageClass.CLASS_0)        
        {
            int varDEFBF0C406E78C33F6A54AB9BC317484_1019554640 = (Intents.RESULT_SMS_OUT_OF_MEMORY);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_401147674 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_401147674;
        } //End block
        if(SmsEnvelope.TELESERVICE_WAP == teleService)        
        {
            int var4DC0FF27B5A3E33E6155ECDA72BF218D_1553618220 = (processCdmaWapPdu(sms.getUserData(), sms.messageRef,
                    sms.getOriginatingAddress()));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_24225946 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_24225946;
        } //End block
        if((SmsEnvelope.TELESERVICE_WMT != teleService) &&
                (SmsEnvelope.TELESERVICE_WEMT != teleService) &&
                (SmsEnvelope.MESSAGE_TYPE_BROADCAST != sms.getMessageType()))        
        {
            int varF2CAC3FB8F6B000662880C416178BE84_605756506 = (Intents.RESULT_SMS_UNSUPPORTED);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_735969827 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_735969827;
        } //End block
        int var346A9897E2392234AEC3F85CEF1CB0D4_23808098 = (dispatchNormalMessage(smsb));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_566833152 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_566833152;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.970 -0400", hash_original_method = "7B6C844E67A0CC9BDD3E050A8ACE8852", hash_generated_method = "EA2F390DEF43CA4AD545A89B9E8E3B9B")
    protected int processCdmaWapPdu(byte[] pdu, int referenceNumber, String address) {
        addTaint(address.getTaint());
        addTaint(referenceNumber);
        addTaint(pdu[0]);
        int index = 0;
        int msgType = (0xFF & pdu[index++]);
        if(msgType != 0)        
        {
            int var0A0A6D68560CC5EF46A3B9603DD175AA_391331662 = (Intents.RESULT_SMS_HANDLED);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_669153026 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_669153026;
        } //End block
        int totalSegments = (0xFF & pdu[index++]);
        int segment = (0xFF & pdu[index++]);
        if(segment >= totalSegments)        
        {
            int var0A0A6D68560CC5EF46A3B9603DD175AA_1704567730 = (Intents.RESULT_SMS_HANDLED);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1272379588 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1272379588;
        } //End block
        int sourcePort = 0;
        int destinationPort = 0;
        if(segment == 0)        
        {
            sourcePort = (0xFF & pdu[index++]) << 8;
            sourcePort |= 0xFF & pdu[index++];
            destinationPort = (0xFF & pdu[index++]) << 8;
            destinationPort |= 0xFF & pdu[index++];
            if(mCheckForDuplicatePortsInOmadmWapPush)            
            {
                if(checkDuplicatePortOmadmWappush(pdu,index))                
                {
                    index = index + 4;
                } //End block
            } //End block
        } //End block
        byte[] userData = new byte[pdu.length - index];
        System.arraycopy(pdu, index, userData, 0, pdu.length - index);
        int varC2515737852DC6332CB749B0B7E0907C_1908727829 = (processMessagePart(userData, address, referenceNumber, segment, totalSegments,
                0L, destinationPort, true));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_266763108 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_266763108;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.971 -0400", hash_original_method = "1C79B20542F5EA033BD01F30A8B0455D", hash_generated_method = "72B7024DF51DCBBD1D6E8C4B5870D4D3")
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
        sendSubmitPdu(pdu, sentIntent, deliveryIntent);
        // ---------- Original Method ----------
        //SmsMessage.SubmitPdu pdu = SmsMessage.getSubmitPdu(
                //scAddr, destAddr, destPort, data, (deliveryIntent != null));
        //sendSubmitPdu(pdu, sentIntent, deliveryIntent);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.973 -0400", hash_original_method = "5D58764547BE2148EE8A5F6EEE636061", hash_generated_method = "8D910942DF4C3EBFC86FE04FB66F5874")
    @Override
    protected void sendText(String destAddr, String scAddr, String text,
            PendingIntent sentIntent, PendingIntent deliveryIntent) {
        addTaint(deliveryIntent.getTaint());
        addTaint(sentIntent.getTaint());
        addTaint(text.getTaint());
        addTaint(scAddr.getTaint());
        addTaint(destAddr.getTaint());
        SmsMessage.SubmitPdu pdu = SmsMessage.getSubmitPdu(
                scAddr, destAddr, text, (deliveryIntent != null), null);
        sendSubmitPdu(pdu, sentIntent, deliveryIntent);
        // ---------- Original Method ----------
        //SmsMessage.SubmitPdu pdu = SmsMessage.getSubmitPdu(
                //scAddr, destAddr, text, (deliveryIntent != null), null);
        //sendSubmitPdu(pdu, sentIntent, deliveryIntent);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.974 -0400", hash_original_method = "9DEF445F0373354182FDA1EF238BF843", hash_generated_method = "B435AEC04CEF6748F95B78E9D09460DD")
    @Override
    protected TextEncodingDetails calculateLength(CharSequence messageBody,
            boolean use7bitOnly) {
        addTaint(use7bitOnly);
        addTaint(messageBody.getTaint());
TextEncodingDetails var9473932D319F0FA2CD84167FDAB5206A_1065058420 =         SmsMessage.calculateLength(messageBody, use7bitOnly);
        var9473932D319F0FA2CD84167FDAB5206A_1065058420.addTaint(taint);
        return var9473932D319F0FA2CD84167FDAB5206A_1065058420;
        // ---------- Original Method ----------
        //return SmsMessage.calculateLength(messageBody, use7bitOnly);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.976 -0400", hash_original_method = "77E27619E0BAA0675283D74233CDEF70", hash_generated_method = "4DFDE733898AAFDBFC346B6AE6C7AB82")
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
        UserData uData = new UserData();
        uData.payloadStr = message;
        uData.userDataHeader = smsHeader;
        if(encoding == android.telephony.SmsMessage.ENCODING_7BIT)        
        {
            uData.msgEncoding = UserData.ENCODING_GSM_7BIT_ALPHABET;
        } //End block
        else
        {
            uData.msgEncoding = UserData.ENCODING_UNICODE_16;
        } //End block
        uData.msgEncodingSet = true;
        SmsMessage.SubmitPdu submitPdu = SmsMessage.getSubmitPdu(destinationAddress,
                uData, (deliveryIntent != null) && lastPart);
        sendSubmitPdu(submitPdu, sentIntent, deliveryIntent);
        // ---------- Original Method ----------
        //UserData uData = new UserData();
        //uData.payloadStr = message;
        //uData.userDataHeader = smsHeader;
        //if (encoding == android.telephony.SmsMessage.ENCODING_7BIT) {
            //uData.msgEncoding = UserData.ENCODING_GSM_7BIT_ALPHABET;
        //} else { 
            //uData.msgEncoding = UserData.ENCODING_UNICODE_16;
        //}
        //uData.msgEncodingSet = true;
        //SmsMessage.SubmitPdu submitPdu = SmsMessage.getSubmitPdu(destinationAddress,
                //uData, (deliveryIntent != null) && lastPart);
        //sendSubmitPdu(submitPdu, sentIntent, deliveryIntent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.977 -0400", hash_original_method = "DEF3D00017A9EC7ED64C2C82C9EF5E11", hash_generated_method = "450119391670FFE97F4CD4206C164112")
    protected void sendSubmitPdu(SmsMessage.SubmitPdu pdu,
            PendingIntent sentIntent, PendingIntent deliveryIntent) {
        addTaint(deliveryIntent.getTaint());
        addTaint(sentIntent.getTaint());
        addTaint(pdu.getTaint());
        if(SystemProperties.getBoolean(TelephonyProperties.PROPERTY_INECM_MODE, false))        
        {
            if(sentIntent != null)            
            {
                try 
                {
                    sentIntent.send(SmsManager.RESULT_ERROR_NO_SERVICE);
                } //End block
                catch (CanceledException ex)
                {
                } //End block
            } //End block
            if(false)            
            {
                Log.d(TAG, "Block SMS in Emergency Callback mode");
            } //End block
            return;
        } //End block
        sendRawPdu(pdu.encodedScAddress, pdu.encodedMessage, sentIntent, deliveryIntent);
        // ---------- Original Method ----------
        //if (SystemProperties.getBoolean(TelephonyProperties.PROPERTY_INECM_MODE, false)) {
            //if (sentIntent != null) {
                //try {
                    //sentIntent.send(SmsManager.RESULT_ERROR_NO_SERVICE);
                //} catch (CanceledException ex) {}
            //}
            //if (false) {
                //Log.d(TAG, "Block SMS in Emergency Callback mode");
            //}
            //return;
        //}
        //sendRawPdu(pdu.encodedScAddress, pdu.encodedMessage, sentIntent, deliveryIntent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.979 -0400", hash_original_method = "B01C05D91305560949593CF3FA30240C", hash_generated_method = "3DD8953D05058DF2595F6A850B7FACFC")
    @Override
    protected void sendSms(SmsTracker tracker) {
        addTaint(tracker.getTaint());
        HashMap<String, Object> map = tracker.mData;
        byte pdu[] = (byte[]) map.get("pdu");
        Message reply = obtainMessage(EVENT_SEND_SMS_COMPLETE, tracker);
        mCm.sendCdmaSms(pdu, reply);
        // ---------- Original Method ----------
        //HashMap<String, Object> map = tracker.mData;
        //byte pdu[] = (byte[]) map.get("pdu");
        //Message reply = obtainMessage(EVENT_SEND_SMS_COMPLETE, tracker);
        //mCm.sendCdmaSms(pdu, reply);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.980 -0400", hash_original_method = "8A630C8BC501F81DB51344181E02B8CE", hash_generated_method = "54988EDB67C41AB9D73A4516B7474B2D")
    @Override
    protected void acknowledgeLastIncomingSms(boolean success, int result, Message response) {
        addTaint(response.getTaint());
        addTaint(result);
        addTaint(success);
        String inEcm = SystemProperties.get(TelephonyProperties.PROPERTY_INECM_MODE, "false");
        if(inEcm.equals("true"))        
        {
            return;
        } //End block
        int causeCode = resultToCause(result);
        mCm.acknowledgeLastIncomingCdmaSms(success, causeCode, response);
        if(causeCode == 0)        
        {
            mLastAcknowledgedSmsFingerprint = mLastDispatchedSmsFingerprint;
        } //End block
        mLastDispatchedSmsFingerprint = null;
        // ---------- Original Method ----------
        //String inEcm=SystemProperties.get(TelephonyProperties.PROPERTY_INECM_MODE, "false");
        //if (inEcm.equals("true")) {
            //return;
        //}
        //int causeCode = resultToCause(result);
        //mCm.acknowledgeLastIncomingCdmaSms(success, causeCode, response);
        //if (causeCode == 0) {
            //mLastAcknowledgedSmsFingerprint = mLastDispatchedSmsFingerprint;
        //}
        //mLastDispatchedSmsFingerprint = null;
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SPEC)
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.981 -0400", hash_original_field = "82200A3ADDBE6AEFE6AAB2FA56CBEC0A", hash_generated_field = "E679783596AFAE58531AA760F376FE87")

    private static final String TAG = "CDMA";
}

