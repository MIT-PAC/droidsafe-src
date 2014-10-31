package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:22.895 -0500", hash_original_method = "43CB38824F520614242805C962124F56", hash_generated_method = "50A51534287DE547B59C18626D20E481")
    
private static int resultToCause(int rc) {
        switch (rc) {
            case Activity.RESULT_OK:
            case Intents.RESULT_SMS_HANDLED:
                // Cause code is ignored on success.
                return 0;
            case Intents.RESULT_SMS_OUT_OF_MEMORY:
                return CommandsInterface.GSM_SMS_FAIL_CAUSE_MEMORY_CAPACITY_EXCEEDED;
            case Intents.RESULT_SMS_GENERIC_ERROR:
            default:
                return CommandsInterface.GSM_SMS_FAIL_CAUSE_UNSPECIFIED_ERROR;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:22.846 -0500", hash_original_field = "51AD1D1B7CA2A72E6B430B8A496104BA", hash_generated_field = "EFF0BA8EAA7A2E5FCD3601D1F8EC46DA")

    private static final String TAG = "GSM";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:22.849 -0500", hash_original_field = "5C6166272CA18188F65644621618803B", hash_generated_field = "E72B26964A801FCD13745348E2F39E5E")

    private static final int EVENT_NEW_SMS_STATUS_REPORT = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:22.852 -0500", hash_original_field = "D0FC480AD95661929AE327AD92A496FA", hash_generated_field = "1C09FC92D14FE7DA05FCFF7B41C8CA1E")

    private static final int EVENT_NEW_BROADCAST_SMS = 101;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:22.854 -0500", hash_original_field = "A27A15A3F3121B3FCAAE940C5DE45ECF", hash_generated_field = "0CD824DED9BF2D233D61D30AB013D005")

    private static final int EVENT_WRITE_SMS_COMPLETE = 102;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:22.856 -0500", hash_original_field = "857D13A26AAB5679056ED506445B9E3D", hash_generated_field = "FB0C4AC891EDC21FFB7A5101DD66CA15")

    private  UsimDataDownloadHandler mDataDownloadHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:22.922 -0500", hash_original_field = "09F50919B6AD5CB1EC2B6A6050A54162", hash_generated_field = "9A4B59DC2D3D1F23A20F3C6764DA1638")

    private final HashMap<SmsCbConcatInfo, byte[][]> mSmsCbPageMap =
            new HashMap<SmsCbConcatInfo, byte[][]>();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:22.859 -0500", hash_original_method = "00834B5C758A658CCABAFC48B413096E", hash_generated_method = "B276CF3C751B7F50165B8DC0C52D07D1")
    
public GsmSMSDispatcher(PhoneBase phone, SmsStorageMonitor storageMonitor,
            SmsUsageMonitor usageMonitor) {
        super(phone, storageMonitor, usageMonitor);
        mDataDownloadHandler = new UsimDataDownloadHandler(mCm);
        mCm.setOnNewGsmSms(this, EVENT_NEW_SMS, null);
        mCm.setOnSmsStatus(this, EVENT_NEW_SMS_STATUS_REPORT, null);
        mCm.setOnNewGsmBroadcastSms(this, EVENT_NEW_BROADCAST_SMS, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:22.862 -0500", hash_original_method = "FC96C37EC7CCEA012658804CB9F94924", hash_generated_method = "5A8224E8193768FCC53131125798AACB")
    
@Override
    public void dispose() {
        mCm.unSetOnNewGsmSms(this);
        mCm.unSetOnSmsStatus(this);
        mCm.unSetOnNewGsmBroadcastSms(this);
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:22.865 -0500", hash_original_method = "1D516C6BB697A8ECCBFC751AA141CC3E", hash_generated_method = "650E0DB5BC6A30E56AA546FF5DC34AD3")
    
@Override
    protected String getFormat() {
        return android.telephony.SmsMessage.FORMAT_3GPP;
    }

    /**
     * Handles 3GPP format-specific events coming from the phone stack.
     * Other events are handled by {@link SMSDispatcher#handleMessage}.
     *
     * @param msg the message to handle
     */
    @DSSafe(DSCat.IPC_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:22.868 -0500", hash_original_method = "789365F05DDE44536DDE00C9B93C643B", hash_generated_method = "DD4CF33FF66DA8C07C84F60EB9134889")
    
@Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
        case EVENT_NEW_SMS_STATUS_REPORT:
            handleStatusReport((AsyncResult) msg.obj);
            break;

        case EVENT_NEW_BROADCAST_SMS:
            handleBroadcastSms((AsyncResult)msg.obj);
            break;

        case EVENT_WRITE_SMS_COMPLETE:
            AsyncResult ar = (AsyncResult) msg.obj;
            if (ar.exception == null) {
                Log.d(TAG, "Successfully wrote SMS-PP message to UICC");
                mCm.acknowledgeLastIncomingGsmSms(true, 0, null);
            } else {
                Log.d(TAG, "Failed to write SMS-PP message to UICC", ar.exception);
                mCm.acknowledgeLastIncomingGsmSms(false,
                        CommandsInterface.GSM_SMS_FAIL_CAUSE_UNSPECIFIED_ERROR, null);
            }
            break;

        default:
            super.handleMessage(msg);
        }
    }

    /**
     * Called when a status report is received.  This should correspond to
     * a previously successful SEND.
     *
     * @param ar AsyncResult passed into the message handler.  ar.result should
     *           be a String representing the status report PDU, as ASCII hex.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:22.871 -0500", hash_original_method = "4DDABCDA44FFF28C561B2585B61E25F7", hash_generated_method = "672B038178BC088608C17482EB0C7D6B")
    
private void handleStatusReport(AsyncResult ar) {
        String pduString = (String) ar.result;
        SmsMessage sms = SmsMessage.newFromCDS(pduString);

        if (sms != null) {
            int tpStatus = sms.getStatus();
            int messageRef = sms.messageRef;
            for (int i = 0, count = deliveryPendingList.size(); i < count; i++) {
                SmsTracker tracker = deliveryPendingList.get(i);
                if (tracker.mMessageRef == messageRef) {
                    // Found it.  Remove from list and broadcast.
                    if(tpStatus >= Sms.STATUS_FAILED || tpStatus < Sms.STATUS_PENDING ) {
                       deliveryPendingList.remove(i);
                    }
                    PendingIntent intent = tracker.mDeliveryIntent;
                    Intent fillIn = new Intent();
                    fillIn.putExtra("pdu", IccUtils.hexStringToBytes(pduString));
                    fillIn.putExtra("format", android.telephony.SmsMessage.FORMAT_3GPP);
                    try {
                        intent.send(mContext, Activity.RESULT_OK, fillIn);
                    } catch (CanceledException ex) {}

                    // Only expect to see one tracker matching this messageref
                    break;
                }
            }
        }
        acknowledgeLastIncomingSms(true, Intents.RESULT_SMS_HANDLED, null);
    }

    /** {@inheritDoc} */
    @DSSink({DSSinkKind.SMS_MMS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:22.875 -0500", hash_original_method = "00DA5224E05DFE04589B7B4693E817E4", hash_generated_method = "D20BAA62740846AE547AB5BC137789AE")
    
@Override
    public int dispatchMessage(SmsMessageBase smsb) {

        // If sms is null, means there was a parsing error.
        if (smsb == null) {
            Log.e(TAG, "dispatchMessage: message is null");
            return Intents.RESULT_SMS_GENERIC_ERROR;
        }

        SmsMessage sms = (SmsMessage) smsb;

        if (sms.isTypeZero()) {
            // As per 3GPP TS 23.040 9.2.3.9, Type Zero messages should not be
            // Displayed/Stored/Notified. They should only be acknowledged.
            Log.d(TAG, "Received short message type 0, Don't display or store it. Send Ack");
            return Intents.RESULT_SMS_HANDLED;
        }

        // Send SMS-PP data download messages to UICC. See 3GPP TS 31.111 section 7.1.1.
        if (sms.isUsimDataDownload()) {
            UsimServiceTable ust = mPhone.getUsimServiceTable();
            // If we receive an SMS-PP message before the UsimServiceTable has been loaded,
            // assume that the data download service is not present. This is very unlikely to
            // happen because the IMS connection will not be established until after the ISIM
            // records have been loaded, after the USIM service table has been loaded.
            if (ust != null && ust.isAvailable(
                    UsimServiceTable.UsimService.DATA_DL_VIA_SMS_PP)) {
                Log.d(TAG, "Received SMS-PP data download, sending to UICC.");
                return mDataDownloadHandler.startDataDownload(sms);
            } else {
                Log.d(TAG, "DATA_DL_VIA_SMS_PP service not available, storing message to UICC.");
                String smsc = IccUtils.bytesToHexString(
                        PhoneNumberUtils.networkPortionToCalledPartyBCDWithLength(
                                sms.getServiceCenterAddress()));
                mCm.writeSmsToSim(SmsManager.STATUS_ON_ICC_UNREAD, smsc,
                        IccUtils.bytesToHexString(sms.getPdu()),
                        obtainMessage(EVENT_WRITE_SMS_COMPLETE));
                return Activity.RESULT_OK;  // acknowledge after response from write to USIM
            }
        }

        if (mSmsReceiveDisabled) {
            // Device doesn't support SMS service,
            Log.d(TAG, "Received short message on device which doesn't support "
                    + "SMS service. Ignored.");
            return Intents.RESULT_SMS_HANDLED;
        }

        // Special case the message waiting indicator messages
        boolean handled = false;
        if (sms.isMWISetMessage()) {
            mPhone.setVoiceMessageWaiting(1, -1);  // line 1: unknown number of msgs waiting
            handled = sms.isMwiDontStore();
            if (false) {
                Log.d(TAG, "Received voice mail indicator set SMS shouldStore=" + !handled);
            }
        } else if (sms.isMWIClearMessage()) {
            mPhone.setVoiceMessageWaiting(1, 0);   // line 1: no msgs waiting
            handled = sms.isMwiDontStore();
            if (false) {
                Log.d(TAG, "Received voice mail indicator clear SMS shouldStore=" + !handled);
            }
        }

        if (handled) {
            return Intents.RESULT_SMS_HANDLED;
        }

        if (!mStorageMonitor.isStorageAvailable() &&
                sms.getMessageClass() != MessageClass.CLASS_0) {
            // It's a storable message and there's no storage available.  Bail.
            // (See TS 23.038 for a description of class 0 messages.)
            return Intents.RESULT_SMS_OUT_OF_MEMORY;
        }

        return dispatchNormalMessage(smsb);
    }

    /** {@inheritDoc} */
    @DSSink({DSSinkKind.SMS_MMS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:22.878 -0500", hash_original_method = "3D7E3502DD1585858E097F3A6DC759F7", hash_generated_method = "90CF4B14C5C8C7F35A99A112035FA7E8")
    
@Override
    protected void sendData(String destAddr, String scAddr, int destPort,
            byte[] data, PendingIntent sentIntent, PendingIntent deliveryIntent) {
        SmsMessage.SubmitPdu pdu = SmsMessage.getSubmitPdu(
                scAddr, destAddr, destPort, data, (deliveryIntent != null));
        if (pdu != null) {
            sendRawPdu(pdu.encodedScAddress, pdu.encodedMessage, sentIntent, deliveryIntent);
        } else {
            Log.e(TAG, "GsmSMSDispatcher.sendData(): getSubmitPdu() returned null");
        }
    }

    /** {@inheritDoc} */
    @DSSink({DSSinkKind.SMS_MMS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:22.881 -0500", hash_original_method = "5889D931B0AF2BA9EF13AED6A1D3F698", hash_generated_method = "618A7099CAD0C95BF9ECFB2329C8660C")
    
@Override
    protected void sendText(String destAddr, String scAddr, String text,
            PendingIntent sentIntent, PendingIntent deliveryIntent) {
        SmsMessage.SubmitPdu pdu = SmsMessage.getSubmitPdu(
                scAddr, destAddr, text, (deliveryIntent != null));
        if (pdu != null) {
            sendRawPdu(pdu.encodedScAddress, pdu.encodedMessage, sentIntent, deliveryIntent);
        } else {
            Log.e(TAG, "GsmSMSDispatcher.sendText(): getSubmitPdu() returned null");
        }
    }

    /** {@inheritDoc} */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:22.883 -0500", hash_original_method = "9DEF445F0373354182FDA1EF238BF843", hash_generated_method = "AF8E472D5EF143D29E4D51C66A6C4604")
    
@Override
    protected TextEncodingDetails calculateLength(CharSequence messageBody,
            boolean use7bitOnly) {
        return SmsMessage.calculateLength(messageBody, use7bitOnly);
    }
    
    private static final class SmsCbConcatInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:22.899 -0500", hash_original_field = "458D24E91CA1CE8B3C8055DB30AA0914", hash_generated_field = "F13EAF462BF75A9C18B71C5567248AEE")

        private  SmsCbHeader mHeader;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:22.901 -0500", hash_original_field = "3653AEEB1B390AE55EB1D85E3D0E89C0", hash_generated_field = "5B8CD52C7682DA00C91E3E72EBFA9940")

        private  String mPlmn;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:22.904 -0500", hash_original_field = "DD653ED27FEE3ABB69B8731CF5FBE1FA", hash_generated_field = "E1DF72766EAA7700CC09E2EF71762BF7")

        private  int mLac;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:22.906 -0500", hash_original_field = "3FDE358D194E184A7314E5F9932F2066", hash_generated_field = "6613038ECFEA58ECF70AB91998D5EB03")

        private  int mCid;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:22.909 -0500", hash_original_method = "D7F908FE9EEA79B2D247A82A8EA2135C", hash_generated_method = "91A3BC2E2403D3094C92DE0935040D0E")
        
public SmsCbConcatInfo(SmsCbHeader header, String plmn, int lac, int cid) {
            mHeader = header;
            mPlmn = plmn;
            mLac = lac;
            mCid = cid;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:22.912 -0500", hash_original_method = "EE152888A937A1561BADC909DEBD7300", hash_generated_method = "7A3538499E98BC30600DF44164E5E2EB")
        
@Override
        public int hashCode() {
            return mHeader.messageIdentifier * 31 + mHeader.updateNumber;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:22.914 -0500", hash_original_method = "A4665EFAF0A95C2E46EAC850D0E6C5D5", hash_generated_method = "F4171D9F067537FB0751EF37F8355EB6")
        
@Override
        public boolean equals(Object obj) {
            if (obj instanceof SmsCbConcatInfo) {
                SmsCbConcatInfo other = (SmsCbConcatInfo)obj;

                // Two pages match if all header attributes (except the page
                // index) are identical, and both pages belong to the same
                // location (which is also determined by the scope parameter)
                if (mHeader.geographicalScope == other.mHeader.geographicalScope
                        && mHeader.messageCode == other.mHeader.messageCode
                        && mHeader.updateNumber == other.mHeader.updateNumber
                        && mHeader.messageIdentifier == other.mHeader.messageIdentifier
                        && mHeader.dataCodingScheme == other.mHeader.dataCodingScheme
                        && mHeader.nrOfPages == other.mHeader.nrOfPages) {
                    return matchesLocation(other.mPlmn, other.mLac, other.mCid);
                }
            }

            return false;
        }

        /**
         * Checks if this concatenation info matches the given location. The
         * granularity of the match depends on the geographical scope.
         *
         * @param plmn PLMN
         * @param lac Location area code
         * @param cid Cell ID
         * @return true if matching, false otherwise
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:22.917 -0500", hash_original_method = "16D562DE8E79921485CB55DC774779E3", hash_generated_method = "082DE4EAFD44B15BE8DF996B0E89B7B5")
        
public boolean matchesLocation(String plmn, int lac, int cid) {
            switch (mHeader.geographicalScope) {
                case SmsCbMessage.GEOGRAPHICAL_SCOPE_CELL_WIDE:
                case SmsCbMessage.GEOGRAPHICAL_SCOPE_CELL_WIDE_IMMEDIATE:
                    if (mCid != cid) {
                        return false;
                    }
                    // deliberate fall-through
                case SmsCbMessage.GEOGRAPHICAL_SCOPE_LA_WIDE:
                    if (mLac != lac) {
                        return false;
                    }
                    // deliberate fall-through
                case SmsCbMessage.GEOGRAPHICAL_SCOPE_PLMN_WIDE:
                    return mPlmn != null && mPlmn.equals(plmn);
            }

            return false;
        }
        
    }

    /** {@inheritDoc} */
    @DSSink({DSSinkKind.SMS_MMS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:22.887 -0500", hash_original_method = "D46F86683A1628DBA1448E14FF571355", hash_generated_method = "02A01997163661965EC4C5CCA3EF5877")
    
@Override
    protected void sendNewSubmitPdu(String destinationAddress, String scAddress,
            String message, SmsHeader smsHeader, int encoding,
            PendingIntent sentIntent, PendingIntent deliveryIntent, boolean lastPart) {
        SmsMessage.SubmitPdu pdu = SmsMessage.getSubmitPdu(scAddress, destinationAddress,
                message, deliveryIntent != null, SmsHeader.toByteArray(smsHeader),
                encoding, smsHeader.languageTable, smsHeader.languageShiftTable);
        if (pdu != null) {
            sendRawPdu(pdu.encodedScAddress, pdu.encodedMessage, sentIntent, deliveryIntent);
        } else {
            Log.e(TAG, "GsmSMSDispatcher.sendNewSubmitPdu(): getSubmitPdu() returned null");
        }
    }

    /** {@inheritDoc} */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:22.890 -0500", hash_original_method = "FF8E1B494DDC1956B0825172C230EA31", hash_generated_method = "2B1F84E6BD7475F6C680F2C638F3A0FE")
    
@Override
    protected void sendSms(SmsTracker tracker) {
        HashMap<String, Object> map = tracker.mData;

        byte smsc[] = (byte[]) map.get("smsc");
        byte pdu[] = (byte[]) map.get("pdu");

        Message reply = obtainMessage(EVENT_SEND_SMS_COMPLETE, tracker);
        mCm.sendSMS(IccUtils.bytesToHexString(smsc), IccUtils.bytesToHexString(pdu), reply);
    }

    /** {@inheritDoc} */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:22.892 -0500", hash_original_method = "72A464580F37288F468EE51C88A0917A", hash_generated_method = "BB1E288A82FC912C17A6324FCBE94289")
    
@Override
    protected void acknowledgeLastIncomingSms(boolean success, int result, Message response) {
        mCm.acknowledgeLastIncomingGsmSms(success, resultToCause(result), response);
    }

    /**
     * Handle 3GPP format SMS-CB message.
     * @param ar the AsyncResult containing the received PDUs
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:22.927 -0500", hash_original_method = "4513E8DEDD790BB664A98AD56B29A135", hash_generated_method = "E344EEAD2668EB96BDD6242C7F151494")
    
private void handleBroadcastSms(AsyncResult ar) {
        try {
            byte[] receivedPdu = (byte[])ar.result;

            if (false) {
                for (int i = 0; i < receivedPdu.length; i += 8) {
                    StringBuilder sb = new StringBuilder("SMS CB pdu data: ");
                    for (int j = i; j < i + 8 && j < receivedPdu.length; j++) {
                        int b = receivedPdu[j] & 0xff;
                        if (b < 0x10) {
                            sb.append('0');
                        }
                        sb.append(Integer.toHexString(b)).append(' ');
                    }
                    Log.d(TAG, sb.toString());
                }
            }

            SmsCbHeader header = new SmsCbHeader(receivedPdu);
            String plmn = SystemProperties.get(TelephonyProperties.PROPERTY_OPERATOR_NUMERIC);
            GsmCellLocation cellLocation = (GsmCellLocation) mPhone.getCellLocation();
            int lac = cellLocation.getLac();
            int cid = cellLocation.getCid();

            byte[][] pdus;
            if (header.nrOfPages > 1) {
                // Multi-page message
                SmsCbConcatInfo concatInfo = new SmsCbConcatInfo(header, plmn, lac, cid);

                // Try to find other pages of the same message
                pdus = mSmsCbPageMap.get(concatInfo);

                if (pdus == null) {
                    // This it the first page of this message, make room for all
                    // pages and keep until complete
                    pdus = new byte[header.nrOfPages][];

                    mSmsCbPageMap.put(concatInfo, pdus);
                }

                // Page parameter is one-based
                pdus[header.pageIndex - 1] = receivedPdu;

                for (int i = 0; i < pdus.length; i++) {
                    if (pdus[i] == null) {
                        // Still missing pages, exit
                        return;
                    }
                }

                // Message complete, remove and dispatch
                mSmsCbPageMap.remove(concatInfo);
            } else {
                // Single page message
                pdus = new byte[1][];
                pdus[0] = receivedPdu;
            }

            boolean isEmergencyMessage = SmsCbHeader.isEmergencyMessage(header.messageIdentifier);
            dispatchBroadcastPdus(pdus, isEmergencyMessage);

            // Remove messages that are out of scope to prevent the map from
            // growing indefinitely, containing incomplete messages that were
            // never assembled
            Iterator<SmsCbConcatInfo> iter = mSmsCbPageMap.keySet().iterator();

            while (iter.hasNext()) {
                SmsCbConcatInfo info = iter.next();

                if (!info.matchesLocation(plmn, lac, cid)) {
                    iter.remove();
                }
            }
        } catch (RuntimeException e) {
            Log.e(TAG, "Error in decoding SMS CB pdu", e);
        }
    }
}

