package com.android.internal.telephony.cdma;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.946 -0400", hash_original_field = "99435B34EC210BD6AB4CF145BA066DD0", hash_generated_field = "32AEC3A3AE4EA72117A81D9C026D630A")

    private byte[] mLastDispatchedSmsFingerprint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.946 -0400", hash_original_field = "BC88600A2C397EC19F71B1A872168269", hash_generated_field = "238150EEC26DEB25A5C3E3E164D32D3E")

    private byte[] mLastAcknowledgedSmsFingerprint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.946 -0400", hash_original_field = "67D22654A80F6A8B030E4469FC9F96B1", hash_generated_field = "AD342BDEFA0E8A38C794B935F4624123")

    private boolean mCheckForDuplicatePortsInOmadmWapPush = Resources.getSystem().getBoolean(
            com.android.internal.R.bool.config_duplicate_port_omadm_wappush);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.946 -0400", hash_original_method = "2E2EEE07B541CA6772FE9654DB0B546E", hash_generated_method = "E2D0386AE236E0FF8392A73CEB374B84")
      CdmaSMSDispatcher(CDMAPhone phone, SmsStorageMonitor storageMonitor,
            SmsUsageMonitor usageMonitor) {
        super(phone, storageMonitor, usageMonitor);
        mCm.setOnNewCdmaSms(this, EVENT_NEW_SMS, null);
        addTaint(phone.getTaint());
        addTaint(storageMonitor.getTaint());
        addTaint(usageMonitor.getTaint());
        // ---------- Original Method ----------
        //mCm.setOnNewCdmaSms(this, EVENT_NEW_SMS, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.948 -0400", hash_original_method = "6D5F69086FA9BAB54819022B7E1C6EB4", hash_generated_method = "80D407A54A94447C6E35DFD5DF927FC8")
    @Override
    public void dispose() {
        mCm.unSetOnNewCdmaSms(this);
        // ---------- Original Method ----------
        //mCm.unSetOnNewCdmaSms(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.958 -0400", hash_original_method = "77401C8F23584A16465C2C7060977D74", hash_generated_method = "5520380B9CF95A1E607D77E19A1B0415")
    @Override
    protected String getFormat() {
        String varB4EAC82CA7396A68D541C85D26508E83_421071956 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_421071956 = android.telephony.SmsMessage.FORMAT_3GPP2;
        varB4EAC82CA7396A68D541C85D26508E83_421071956.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_421071956;
        // ---------- Original Method ----------
        //return android.telephony.SmsMessage.FORMAT_3GPP2;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.958 -0400", hash_original_method = "D8F9BF94E3CE828F06F15D06BD41575B", hash_generated_method = "CFD76A849DE72347A7B40FDAFC9318BB")
    private void handleCdmaStatusReport(SmsMessage sms) {
        {
            int i, count;
            i = 0;
            count = deliveryPendingList.size();
            {
                SmsTracker tracker;
                tracker = deliveryPendingList.get(i);
                {
                    deliveryPendingList.remove(i);
                    PendingIntent intent;
                    intent = tracker.mDeliveryIntent;
                    Intent fillIn;
                    fillIn = new Intent();
                    fillIn.putExtra("pdu", sms.getPdu());
                    fillIn.putExtra("format", android.telephony.SmsMessage.FORMAT_3GPP2);
                    try 
                    {
                        intent.send(mContext, Activity.RESULT_OK, fillIn);
                    } //End block
                    catch (CanceledException ex)
                    { }
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(sms.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.960 -0400", hash_original_method = "AEF7CF36D035C3FD2F985EB9DE02C895", hash_generated_method = "F3A6BD755A69656544E6C76281E4650F")
    @Override
    public int dispatchMessage(SmsMessageBase smsb) {
        String inEcm;
        inEcm = SystemProperties.get(TelephonyProperties.PROPERTY_INECM_MODE, "false");
        {
            boolean varA0F6E951DAEE6AF07E9F4144653EDB3A_1773513616 = (inEcm.equals("true"));
        } //End collapsed parenthetic
        {
            Log.d(TAG, "Received short message on device which doesn't support "
                    + "receiving SMS. Ignored.");
        } //End block
        SmsMessage sms;
        sms = (SmsMessage) smsb;
        mLastDispatchedSmsFingerprint = sms.getIncomingSmsFingerprint();
        {
            boolean varDF6EBE56566BC9DCD284E2602989ED53_1292371759 = (mLastAcknowledgedSmsFingerprint != null &&
                Arrays.equals(mLastDispatchedSmsFingerprint, mLastAcknowledgedSmsFingerprint));
        } //End collapsed parenthetic
        sms.parseSms();
        int teleService;
        teleService = sms.getTeleService();
        boolean handled;
        handled = false;
        {
            int voicemailCount;
            voicemailCount = sms.getNumOfVoicemails();
            Log.d(TAG, "Voicemail count=" + voicemailCount);
            SharedPreferences sp;
            sp = PreferenceManager.getDefaultSharedPreferences(
                    mContext);
            SharedPreferences.Editor editor;
            editor = sp.edit();
            editor.putInt(CDMAPhone.VM_COUNT_CDMA, voicemailCount);
            editor.apply();
            mPhone.setVoiceMessageWaiting(1, voicemailCount);
            handled = true;
        } //End block
        {
            boolean var6BFACB98B67502CFF9E96D2D882A1268_1356879364 = (((SmsEnvelope.TELESERVICE_WMT == teleService) ||
                (SmsEnvelope.TELESERVICE_WEMT == teleService)) &&
                sms.isStatusReportMessage());
            {
                handleCdmaStatusReport(sms);
                handled = true;
            } //End block
            {
                boolean varBE4A2285BBE5F32B453C107F5877041B_572353011 = ((sms.getUserData() == null));
                {
                    {
                        Log.d(TAG, "Received SMS without user data");
                    } //End block
                    handled = true;
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        {
            boolean varA6EC97D1C251BAAEFB63A742DEBA1DB1_451366086 = (!mStorageMonitor.isStorageAvailable() &&
                sms.getMessageClass() != MessageClass.CLASS_0);
        } //End collapsed parenthetic
        {
            int varD40C172EBE77C0D6F53AB9839B849E95_265624305 = (processCdmaWapPdu(sms.getUserData(), sms.messageRef,
                    sms.getOriginatingAddress()));
        } //End block
        {
            boolean var3D2190DCE0A796AA437486D706358C65_1877242428 = ((SmsEnvelope.TELESERVICE_WMT != teleService) &&
                (SmsEnvelope.TELESERVICE_WEMT != teleService) &&
                (SmsEnvelope.MESSAGE_TYPE_BROADCAST != sms.getMessageType()));
        } //End collapsed parenthetic
        int var3F541A711EB85996C611FA5F634F0615_1579478101 = (dispatchNormalMessage(smsb));
        addTaint(smsb.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1016632871 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1016632871;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.965 -0400", hash_original_method = "7B6C844E67A0CC9BDD3E050A8ACE8852", hash_generated_method = "141906C17840B2AADA609FAFD048695D")
    protected int processCdmaWapPdu(byte[] pdu, int referenceNumber, String address) {
        int index;
        index = 0;
        int msgType;
        msgType = (0xFF & pdu[index++]);
        int totalSegments;
        totalSegments = (0xFF & pdu[index++]);
        int segment;
        segment = (0xFF & pdu[index++]);
        int sourcePort;
        sourcePort = 0;
        int destinationPort;
        destinationPort = 0;
        {
            sourcePort = (0xFF & pdu[index++]) << 8;
            sourcePort |= 0xFF & pdu[index++];
            destinationPort = (0xFF & pdu[index++]) << 8;
            destinationPort |= 0xFF & pdu[index++];
            {
                {
                    boolean var2D609C19B2CBA7666BC03ED4CBB382E6_84968561 = (checkDuplicatePortOmadmWappush(pdu,index));
                    {
                        index = index + 4;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        byte[] userData;
        userData = new byte[pdu.length - index];
        System.arraycopy(pdu, index, userData, 0, pdu.length - index);
        int var2CF4D70DCF81F3DCA9EA65A5EFDC134E_2136134021 = (processMessagePart(userData, address, referenceNumber, segment, totalSegments,
                0L, destinationPort, true));
        addTaint(pdu[0]);
        addTaint(referenceNumber);
        addTaint(address.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1169235904 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1169235904;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.030 -0400", hash_original_method = "1C79B20542F5EA033BD01F30A8B0455D", hash_generated_method = "EBA5CD247F50A51C9DAF0222FC726520")
    @Override
    protected void sendData(String destAddr, String scAddr, int destPort,
            byte[] data, PendingIntent sentIntent, PendingIntent deliveryIntent) {
        SmsMessage.SubmitPdu pdu;
        pdu = SmsMessage.getSubmitPdu(
                scAddr, destAddr, destPort, data, (deliveryIntent != null));
        sendSubmitPdu(pdu, sentIntent, deliveryIntent);
        addTaint(destAddr.getTaint());
        addTaint(scAddr.getTaint());
        addTaint(destPort);
        addTaint(data[0]);
        addTaint(sentIntent.getTaint());
        addTaint(deliveryIntent.getTaint());
        // ---------- Original Method ----------
        //SmsMessage.SubmitPdu pdu = SmsMessage.getSubmitPdu(
                //scAddr, destAddr, destPort, data, (deliveryIntent != null));
        //sendSubmitPdu(pdu, sentIntent, deliveryIntent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.031 -0400", hash_original_method = "5D58764547BE2148EE8A5F6EEE636061", hash_generated_method = "98D51FEBC9593BCD972219AFD3AE1226")
    @Override
    protected void sendText(String destAddr, String scAddr, String text,
            PendingIntent sentIntent, PendingIntent deliveryIntent) {
        SmsMessage.SubmitPdu pdu;
        pdu = SmsMessage.getSubmitPdu(
                scAddr, destAddr, text, (deliveryIntent != null), null);
        sendSubmitPdu(pdu, sentIntent, deliveryIntent);
        addTaint(destAddr.getTaint());
        addTaint(scAddr.getTaint());
        addTaint(text.getTaint());
        addTaint(sentIntent.getTaint());
        addTaint(deliveryIntent.getTaint());
        // ---------- Original Method ----------
        //SmsMessage.SubmitPdu pdu = SmsMessage.getSubmitPdu(
                //scAddr, destAddr, text, (deliveryIntent != null), null);
        //sendSubmitPdu(pdu, sentIntent, deliveryIntent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.031 -0400", hash_original_method = "9DEF445F0373354182FDA1EF238BF843", hash_generated_method = "F3C65D051D62D267D40BBBDBE384CF32")
    @Override
    protected TextEncodingDetails calculateLength(CharSequence messageBody,
            boolean use7bitOnly) {
        TextEncodingDetails varB4EAC82CA7396A68D541C85D26508E83_2032874199 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2032874199 = SmsMessage.calculateLength(messageBody, use7bitOnly);
        addTaint(messageBody.getTaint());
        addTaint(use7bitOnly);
        varB4EAC82CA7396A68D541C85D26508E83_2032874199.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2032874199;
        // ---------- Original Method ----------
        //return SmsMessage.calculateLength(messageBody, use7bitOnly);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.032 -0400", hash_original_method = "77E27619E0BAA0675283D74233CDEF70", hash_generated_method = "D1589B8CC5D46A7AF4CE6F4244147266")
    @Override
    protected void sendNewSubmitPdu(String destinationAddress, String scAddress,
            String message, SmsHeader smsHeader, int encoding,
            PendingIntent sentIntent, PendingIntent deliveryIntent, boolean lastPart) {
        UserData uData;
        uData = new UserData();
        uData.payloadStr = message;
        uData.userDataHeader = smsHeader;
        {
            uData.msgEncoding = UserData.ENCODING_GSM_7BIT_ALPHABET;
        } //End block
        {
            uData.msgEncoding = UserData.ENCODING_UNICODE_16;
        } //End block
        uData.msgEncodingSet = true;
        SmsMessage.SubmitPdu submitPdu;
        submitPdu = SmsMessage.getSubmitPdu(destinationAddress,
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.032 -0400", hash_original_method = "DEF3D00017A9EC7ED64C2C82C9EF5E11", hash_generated_method = "31A269366FC79FF7B7BEA73C16B1D7FA")
    protected void sendSubmitPdu(SmsMessage.SubmitPdu pdu,
            PendingIntent sentIntent, PendingIntent deliveryIntent) {
        {
            boolean varA40FEF0397CC3CD9D2B924BC5AEF9981_1698974225 = (SystemProperties.getBoolean(TelephonyProperties.PROPERTY_INECM_MODE, false));
            {
                {
                    try 
                    {
                        sentIntent.send(SmsManager.RESULT_ERROR_NO_SERVICE);
                    } //End block
                    catch (CanceledException ex)
                    { }
                } //End block
                {
                    Log.d(TAG, "Block SMS in Emergency Callback mode");
                } //End block
            } //End block
        } //End collapsed parenthetic
        sendRawPdu(pdu.encodedScAddress, pdu.encodedMessage, sentIntent, deliveryIntent);
        addTaint(pdu.getTaint());
        addTaint(sentIntent.getTaint());
        addTaint(deliveryIntent.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.033 -0400", hash_original_method = "B01C05D91305560949593CF3FA30240C", hash_generated_method = "009472BF4B127618D3277A178589A29B")
    @Override
    protected void sendSms(SmsTracker tracker) {
        HashMap<String, Object> map;
        map = tracker.mData;
        byte pdu[];
        pdu = (byte[]) map.get("pdu");
        Message reply;
        reply = obtainMessage(EVENT_SEND_SMS_COMPLETE, tracker);
        mCm.sendCdmaSms(pdu, reply);
        addTaint(tracker.getTaint());
        // ---------- Original Method ----------
        //HashMap<String, Object> map = tracker.mData;
        //byte pdu[] = (byte[]) map.get("pdu");
        //Message reply = obtainMessage(EVENT_SEND_SMS_COMPLETE, tracker);
        //mCm.sendCdmaSms(pdu, reply);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.040 -0400", hash_original_method = "8A630C8BC501F81DB51344181E02B8CE", hash_generated_method = "BA64E107A3271E1C87C57216FFB9ABFD")
    @Override
    protected void acknowledgeLastIncomingSms(boolean success, int result, Message response) {
        String inEcm;
        inEcm = SystemProperties.get(TelephonyProperties.PROPERTY_INECM_MODE, "false");
        {
            boolean varA0F6E951DAEE6AF07E9F4144653EDB3A_181534166 = (inEcm.equals("true"));
        } //End collapsed parenthetic
        int causeCode;
        causeCode = resultToCause(result);
        mCm.acknowledgeLastIncomingCdmaSms(success, causeCode, response);
        {
            mLastAcknowledgedSmsFingerprint = mLastDispatchedSmsFingerprint;
        } //End block
        mLastDispatchedSmsFingerprint = null;
        addTaint(success);
        addTaint(result);
        addTaint(response.getTaint());
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.041 -0400", hash_original_field = "82200A3ADDBE6AEFE6AAB2FA56CBEC0A", hash_generated_field = "F5153DDC70CF50A8FC88A671F8719B35")

    private static String TAG = "CDMA";
}

