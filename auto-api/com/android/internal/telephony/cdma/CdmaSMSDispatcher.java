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
    private byte[] mLastDispatchedSmsFingerprint;
    private byte[] mLastAcknowledgedSmsFingerprint;
    private boolean mCheckForDuplicatePortsInOmadmWapPush = Resources.getSystem().getBoolean(
            com.android.internal.R.bool.config_duplicate_port_omadm_wappush);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.644 -0400", hash_original_method = "2E2EEE07B541CA6772FE9654DB0B546E", hash_generated_method = "A06D16CF718D583A78F04012B336E88D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     CdmaSMSDispatcher(CDMAPhone phone, SmsStorageMonitor storageMonitor,
            SmsUsageMonitor usageMonitor) {
        super(phone, storageMonitor, usageMonitor);
        dsTaint.addTaint(phone.dsTaint);
        dsTaint.addTaint(usageMonitor.dsTaint);
        dsTaint.addTaint(storageMonitor.dsTaint);
        mCm.setOnNewCdmaSms(this, EVENT_NEW_SMS, null);
        // ---------- Original Method ----------
        //mCm.setOnNewCdmaSms(this, EVENT_NEW_SMS, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.644 -0400", hash_original_method = "6D5F69086FA9BAB54819022B7E1C6EB4", hash_generated_method = "80D407A54A94447C6E35DFD5DF927FC8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void dispose() {
        mCm.unSetOnNewCdmaSms(this);
        // ---------- Original Method ----------
        //mCm.unSetOnNewCdmaSms(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.644 -0400", hash_original_method = "77401C8F23584A16465C2C7060977D74", hash_generated_method = "F0271BA8C475C7C0D961E4D8FF140E55")
    @DSModeled(DSC.SAFE)
    @Override
    protected String getFormat() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return android.telephony.SmsMessage.FORMAT_3GPP2;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.644 -0400", hash_original_method = "D8F9BF94E3CE828F06F15D06BD41575B", hash_generated_method = "E9FB8104090A98130A84B2DB05EAA110")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void handleCdmaStatusReport(SmsMessage sms) {
        dsTaint.addTaint(sms.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.645 -0400", hash_original_method = "AEF7CF36D035C3FD2F985EB9DE02C895", hash_generated_method = "BBD9E616E00030A50CF826C9BBC3A24E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int dispatchMessage(SmsMessageBase smsb) {
        dsTaint.addTaint(smsb.dsTaint);
        String inEcm;
        inEcm = SystemProperties.get(TelephonyProperties.PROPERTY_INECM_MODE, "false");
        {
            boolean varA0F6E951DAEE6AF07E9F4144653EDB3A_999777875 = (inEcm.equals("true"));
        } //End collapsed parenthetic
        {
            Log.d(TAG, "Received short message on device which doesn't support "
                    + "receiving SMS. Ignored.");
        } //End block
        SmsMessage sms;
        sms = (SmsMessage) smsb;
        mLastDispatchedSmsFingerprint = sms.getIncomingSmsFingerprint();
        {
            boolean varDF6EBE56566BC9DCD284E2602989ED53_700211855 = (mLastAcknowledgedSmsFingerprint != null &&
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
            boolean var6BFACB98B67502CFF9E96D2D882A1268_113092255 = (((SmsEnvelope.TELESERVICE_WMT == teleService) ||
                (SmsEnvelope.TELESERVICE_WEMT == teleService)) &&
                sms.isStatusReportMessage());
            {
                handleCdmaStatusReport(sms);
                handled = true;
            } //End block
            {
                boolean varBE4A2285BBE5F32B453C107F5877041B_1078432421 = ((sms.getUserData() == null));
                {
                    {
                        Log.d(TAG, "Received SMS without user data");
                    } //End block
                    handled = true;
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        {
            boolean varA6EC97D1C251BAAEFB63A742DEBA1DB1_55094231 = (!mStorageMonitor.isStorageAvailable() &&
                sms.getMessageClass() != MessageClass.CLASS_0);
        } //End collapsed parenthetic
        {
            int varD40C172EBE77C0D6F53AB9839B849E95_1008007950 = (processCdmaWapPdu(sms.getUserData(), sms.messageRef,
                    sms.getOriginatingAddress()));
        } //End block
        {
            boolean var3D2190DCE0A796AA437486D706358C65_1273111726 = ((SmsEnvelope.TELESERVICE_WMT != teleService) &&
                (SmsEnvelope.TELESERVICE_WEMT != teleService) &&
                (SmsEnvelope.MESSAGE_TYPE_BROADCAST != sms.getMessageType()));
        } //End collapsed parenthetic
        int var3F541A711EB85996C611FA5F634F0615_925019748 = (dispatchNormalMessage(smsb));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.646 -0400", hash_original_method = "7B6C844E67A0CC9BDD3E050A8ACE8852", hash_generated_method = "DF964FAE98BEA8A4C91243CA5BB40D63")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected int processCdmaWapPdu(byte[] pdu, int referenceNumber, String address) {
        dsTaint.addTaint(address);
        dsTaint.addTaint(referenceNumber);
        dsTaint.addTaint(pdu[0]);
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
                    boolean var2D609C19B2CBA7666BC03ED4CBB382E6_1294195049 = (checkDuplicatePortOmadmWappush(pdu,index));
                    {
                        index = index + 4;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        byte[] userData;
        userData = new byte[pdu.length - index];
        System.arraycopy(pdu, index, userData, 0, pdu.length - index);
        int var2CF4D70DCF81F3DCA9EA65A5EFDC134E_537377814 = (processMessagePart(userData, address, referenceNumber, segment, totalSegments,
                0L, destinationPort, true));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.646 -0400", hash_original_method = "1C79B20542F5EA033BD01F30A8B0455D", hash_generated_method = "914CF6992C9C1D3413E9A712E8AB1F1B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void sendData(String destAddr, String scAddr, int destPort,
            byte[] data, PendingIntent sentIntent, PendingIntent deliveryIntent) {
        dsTaint.addTaint(scAddr);
        dsTaint.addTaint(destAddr);
        dsTaint.addTaint(sentIntent.dsTaint);
        dsTaint.addTaint(data[0]);
        dsTaint.addTaint(destPort);
        dsTaint.addTaint(deliveryIntent.dsTaint);
        SmsMessage.SubmitPdu pdu;
        pdu = SmsMessage.getSubmitPdu(
                scAddr, destAddr, destPort, data, (deliveryIntent != null));
        sendSubmitPdu(pdu, sentIntent, deliveryIntent);
        // ---------- Original Method ----------
        //SmsMessage.SubmitPdu pdu = SmsMessage.getSubmitPdu(
                //scAddr, destAddr, destPort, data, (deliveryIntent != null));
        //sendSubmitPdu(pdu, sentIntent, deliveryIntent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.646 -0400", hash_original_method = "5D58764547BE2148EE8A5F6EEE636061", hash_generated_method = "2FB036C14008106F52421E52ACA9BC05")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
                scAddr, destAddr, text, (deliveryIntent != null), null);
        sendSubmitPdu(pdu, sentIntent, deliveryIntent);
        // ---------- Original Method ----------
        //SmsMessage.SubmitPdu pdu = SmsMessage.getSubmitPdu(
                //scAddr, destAddr, text, (deliveryIntent != null), null);
        //sendSubmitPdu(pdu, sentIntent, deliveryIntent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.647 -0400", hash_original_method = "9DEF445F0373354182FDA1EF238BF843", hash_generated_method = "D87BC5BD743CB4B4849D28850BEF24B4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected TextEncodingDetails calculateLength(CharSequence messageBody,
            boolean use7bitOnly) {
        dsTaint.addTaint(messageBody);
        dsTaint.addTaint(use7bitOnly);
        TextEncodingDetails var43C10878969A86A3A296086B315FD31F_1043396896 = (SmsMessage.calculateLength(messageBody, use7bitOnly));
        return (TextEncodingDetails)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return SmsMessage.calculateLength(messageBody, use7bitOnly);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.647 -0400", hash_original_method = "77E27619E0BAA0675283D74233CDEF70", hash_generated_method = "791DD14B859CC223FBBA0DC70198F39B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void sendNewSubmitPdu(String destinationAddress, String scAddress,
            String message, SmsHeader smsHeader, int encoding,
            PendingIntent sentIntent, PendingIntent deliveryIntent, boolean lastPart) {
        dsTaint.addTaint(message);
        dsTaint.addTaint(lastPart);
        dsTaint.addTaint(destinationAddress);
        dsTaint.addTaint(sentIntent.dsTaint);
        dsTaint.addTaint(encoding);
        dsTaint.addTaint(scAddress);
        dsTaint.addTaint(deliveryIntent.dsTaint);
        dsTaint.addTaint(smsHeader.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.647 -0400", hash_original_method = "DEF3D00017A9EC7ED64C2C82C9EF5E11", hash_generated_method = "8C0D2894E75DE25D55647964135104F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void sendSubmitPdu(SmsMessage.SubmitPdu pdu,
            PendingIntent sentIntent, PendingIntent deliveryIntent) {
        dsTaint.addTaint(sentIntent.dsTaint);
        dsTaint.addTaint(pdu.dsTaint);
        dsTaint.addTaint(deliveryIntent.dsTaint);
        {
            boolean varA40FEF0397CC3CD9D2B924BC5AEF9981_313076801 = (SystemProperties.getBoolean(TelephonyProperties.PROPERTY_INECM_MODE, false));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.648 -0400", hash_original_method = "B01C05D91305560949593CF3FA30240C", hash_generated_method = "3E0703A4843D5D2C332A189C1A5A115D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void sendSms(SmsTracker tracker) {
        dsTaint.addTaint(tracker.dsTaint);
        HashMap<String, Object> map;
        map = tracker.mData;
        byte pdu[];
        pdu = (byte[]) map.get("pdu");
        Message reply;
        reply = obtainMessage(EVENT_SEND_SMS_COMPLETE, tracker);
        mCm.sendCdmaSms(pdu, reply);
        // ---------- Original Method ----------
        //HashMap<String, Object> map = tracker.mData;
        //byte pdu[] = (byte[]) map.get("pdu");
        //Message reply = obtainMessage(EVENT_SEND_SMS_COMPLETE, tracker);
        //mCm.sendCdmaSms(pdu, reply);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.648 -0400", hash_original_method = "8A630C8BC501F81DB51344181E02B8CE", hash_generated_method = "F7480ED19422A96E15045C80D01D8FBA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void acknowledgeLastIncomingSms(boolean success, int result, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(result);
        dsTaint.addTaint(success);
        String inEcm;
        inEcm = SystemProperties.get(TelephonyProperties.PROPERTY_INECM_MODE, "false");
        {
            boolean varA0F6E951DAEE6AF07E9F4144653EDB3A_946583167 = (inEcm.equals("true"));
        } //End collapsed parenthetic
        int causeCode;
        causeCode = resultToCause(result);
        mCm.acknowledgeLastIncomingCdmaSms(success, causeCode, response);
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

    
    private static final String TAG = "CDMA";
}

