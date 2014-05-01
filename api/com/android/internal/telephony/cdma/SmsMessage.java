package com.android.internal.telephony.cdma;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import android.os.Parcel;
import android.os.SystemProperties;
import android.telephony.PhoneNumberUtils;
import android.telephony.SmsMessage.MessageClass;
import android.util.Log;

import com.android.internal.telephony.IccUtils;
import com.android.internal.telephony.SmsHeader;
import com.android.internal.telephony.SmsMessageBase;
import com.android.internal.telephony.TelephonyProperties;
import com.android.internal.telephony.cdma.sms.BearerData;
import com.android.internal.telephony.cdma.sms.CdmaSmsAddress;
import com.android.internal.telephony.cdma.sms.CdmaSmsSubaddress;
import com.android.internal.telephony.cdma.sms.SmsEnvelope;
import com.android.internal.telephony.cdma.sms.UserData;
import com.android.internal.util.BitwiseInputStream;
import com.android.internal.util.HexDump;

public class SmsMessage extends SmsMessageBase {

    /**
     * Create an SmsMessage from a raw PDU.
     * Note: In CDMA the PDU is just a byte representation of the received Sms.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:56.775 -0500", hash_original_method = "99232C70861F540E42FB57435D811DAE", hash_generated_method = "A89B3B729B64F331E1D8043057407503")
    
public static SmsMessage createFromPdu(byte[] pdu) {
        SmsMessage msg = new SmsMessage();

        try {
            msg.parsePdu(pdu);
            return msg;
        } catch (RuntimeException ex) {
            Log.e(LOG_TAG, "SMS PDU parsing failed: ", ex);
            return null;
        }
    }

    /**
     *  Create a "raw" CDMA SmsMessage from a Parcel that was forged in ril.cpp.
     *  Note: Only primitive fields are set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:56.779 -0500", hash_original_method = "40C5594A7A5C74207DFB0150B38ADFE3", hash_generated_method = "C0F3368B28E6315AC137FC3953CEE799")
    
public static SmsMessage newFromParcel(Parcel p) {
        // Note: Parcel.readByte actually reads one Int and masks to byte
        SmsMessage msg = new SmsMessage();
        SmsEnvelope env = new SmsEnvelope();
        CdmaSmsAddress addr = new CdmaSmsAddress();
        CdmaSmsSubaddress subaddr = new CdmaSmsSubaddress();
        byte[] data;
        byte count;
        int countInt;
        int addressDigitMode;

        //currently not supported by the modem-lib: env.mMessageType
        env.teleService = p.readInt(); //p_cur->uTeleserviceID

        if (0 != p.readByte()) { //p_cur->bIsServicePresent
            env.messageType = SmsEnvelope.MESSAGE_TYPE_BROADCAST;
        }
        else {
            if (SmsEnvelope.TELESERVICE_NOT_SET == env.teleService) {
                // assume type ACK
                env.messageType = SmsEnvelope.MESSAGE_TYPE_ACKNOWLEDGE;
            } else {
                env.messageType = SmsEnvelope.MESSAGE_TYPE_POINT_TO_POINT;
            }
        }
        env.serviceCategory = p.readInt(); //p_cur->uServicecategory

        // address
        addressDigitMode = p.readInt();
        addr.digitMode = (byte) (0xFF & addressDigitMode); //p_cur->sAddress.digit_mode
        addr.numberMode = (byte) (0xFF & p.readInt()); //p_cur->sAddress.number_mode
        addr.ton = p.readInt(); //p_cur->sAddress.number_type
        addr.numberPlan = (byte) (0xFF & p.readInt()); //p_cur->sAddress.number_plan
        count = p.readByte(); //p_cur->sAddress.number_of_digits
        addr.numberOfDigits = count;
        data = new byte[count];
        //p_cur->sAddress.digits[digitCount]
        for (int index=0; index < count; index++) {
            data[index] = p.readByte();

            // convert the value if it is 4-bit DTMF to 8 bit
            if (addressDigitMode == CdmaSmsAddress.DIGIT_MODE_4BIT_DTMF) {
                data[index] = msg.convertDtmfToAscii(data[index]);
            }
        }

        addr.origBytes = data;

        subaddr.type = p.readInt(); // p_cur->sSubAddress.subaddressType
        subaddr.odd = p.readByte();     // p_cur->sSubAddress.odd
        count = p.readByte();           // p_cur->sSubAddress.number_of_digits

        if (count < 0) {
            count = 0;
        }

        // p_cur->sSubAddress.digits[digitCount] :

        data = new byte[count];

        for (int index = 0; index < count; ++index) {
            data[index] = p.readByte();
        }

        subaddr.origBytes = data;

        /* currently not supported by the modem-lib:
            env.bearerReply
            env.replySeqNo
            env.errorClass
            env.causeCode
        */

        // bearer data
        countInt = p.readInt(); //p_cur->uBearerDataLen
        if (countInt >0) {
            data = new byte[countInt];
             //p_cur->aBearerData[digitCount] :
            for (int index=0; index < countInt; index++) {
                data[index] = p.readByte();
            }
            env.bearerData = data;
            // BD gets further decoded when accessed in SMSDispatcher
        }

        // link the the filled objects to the SMS
        env.origAddress = addr;
        env.origSubaddress = subaddr;
        msg.originatingAddress = addr;
        msg.mEnvelope = env;

        // create byte stream representation for transportation through the layers.
        msg.createPdu();

        return msg;
    }

    /**
     * Create an SmsMessage from an SMS EF record.
     *
     * @param index Index of SMS record. This should be index in ArrayList
     *              returned by RuimSmsInterfaceManager.getAllMessagesFromIcc + 1.
     * @param data Record data.
     * @return An SmsMessage representing the record.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:56.781 -0500", hash_original_method = "EBB24F7A09C76B232310B77610C33832", hash_generated_method = "85CB07F6721D93BA303964EFCF468105")
    
public static SmsMessage createFromEfRecord(int index, byte[] data) {
        try {
            SmsMessage msg = new SmsMessage();

            msg.indexOnIcc = index;

            // First byte is status: RECEIVED_READ, RECEIVED_UNREAD, STORED_SENT,
            // or STORED_UNSENT
            // See 3GPP2 C.S0023 3.4.27
            if ((data[0] & 1) == 0) {
                Log.w(LOG_TAG, "SMS parsing failed: Trying to parse a free record");
                return null;
            } else {
                msg.statusOnIcc = data[0] & 0x07;
            }

            // Second byte is the MSG_LEN, length of the message
            // See 3GPP2 C.S0023 3.4.27
            int size = data[1];

            // Note: Data may include trailing FF's.  That's OK; message
            // should still parse correctly.
            byte[] pdu = new byte[size];
            System.arraycopy(data, 2, pdu, 0, size);
            // the message has to be parsed before it can be displayed
            // see gsm.SmsMessage
            msg.parsePduFromEfRecord(pdu);
            return msg;
        } catch (RuntimeException ex) {
            Log.e(LOG_TAG, "SMS PDU parsing failed: ", ex);
            return null;
        }

    }

    /**
     * Note: This function is a GSM specific functionality which is not supported in CDMA mode.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:56.784 -0500", hash_original_method = "4A06653CD3A3C3119D4CD72086FF4F09", hash_generated_method = "F135C8D0AE61D472D5F3282AF5AB23E0")
    
public static int getTPLayerLengthForPDU(String pdu) {
        Log.w(LOG_TAG, "getTPLayerLengthForPDU: is not supported in CDMA mode.");
        return 0;
    }

    /**
     * TODO(cleanup): why do getSubmitPdu methods take an scAddr input
     * and do nothing with it?  GSM allows us to specify a SC (eg,
     * when responding to an SMS that explicitly requests the response
     * is sent to a specific SC), or pass null to use the default
     * value.  Is there no similar notion in CDMA? Or do we just not
     * have it hooked up?
     */

    /**
     * Get an SMS-SUBMIT PDU for a destination address and a message
     *
     * @param scAddr                Service Centre address.  Null means use default.
     * @param destAddr              Address of the recipient.
     * @param message               String representation of the message payload.
     * @param statusReportRequested Indicates whether a report is requested for this message.
     * @param smsHeader             Array containing the data for the User Data Header, preceded
     *                              by the Element Identifiers.
     * @return a <code>SubmitPdu</code> containing the encoded SC
     *         address, if applicable, and the encoded message.
     *         Returns null on encode error.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:56.788 -0500", hash_original_method = "4B0FA09EDBEBDEFE41916B87612ADB51", hash_generated_method = "C7E96406AF7646F150E2FD3A4E609688")
    
public static SubmitPdu getSubmitPdu(String scAddr, String destAddr, String message,
            boolean statusReportRequested, SmsHeader smsHeader) {

        /**
         * TODO(cleanup): Do we really want silent failure like this?
         * Would it not be much more reasonable to make sure we don't
         * call this function if we really want nothing done?
         */
        if (message == null || destAddr == null) {
            return null;
        }

        UserData uData = new UserData();
        uData.payloadStr = message;
        uData.userDataHeader = smsHeader;
        return privateGetSubmitPdu(destAddr, statusReportRequested, uData);
    }

    /**
     * Get an SMS-SUBMIT PDU for a data message to a destination address and port.
     *
     * @param scAddr Service Centre address. null == use default
     * @param destAddr the address of the destination for the message
     * @param destPort the port to deliver the message to at the
     *        destination
     * @param data the data for the message
     * @return a <code>SubmitPdu</code> containing the encoded SC
     *         address, if applicable, and the encoded message.
     *         Returns null on encode error.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:56.791 -0500", hash_original_method = "5F3DFBA2A9930B27925F9A4FEC1DD56C", hash_generated_method = "E46BE2D8BAB6DC837ED20D361D135EB1")
    
public static SubmitPdu getSubmitPdu(String scAddr, String destAddr, int destPort,
            byte[] data, boolean statusReportRequested) {

        /**
         * TODO(cleanup): this is not a general-purpose SMS creation
         * method, but rather something specialized to messages
         * containing OCTET encoded (meaning non-human-readable) user
         * data.  The name should reflect that, and not just overload.
         */

        SmsHeader.PortAddrs portAddrs = new SmsHeader.PortAddrs();
        portAddrs.destPort = destPort;
        portAddrs.origPort = 0;
        portAddrs.areEightBits = false;

        SmsHeader smsHeader = new SmsHeader();
        smsHeader.portAddrs = portAddrs;

        UserData uData = new UserData();
        uData.userDataHeader = smsHeader;
        uData.msgEncoding = UserData.ENCODING_OCTET;
        uData.msgEncodingSet = true;
        uData.payload = data;

        return privateGetSubmitPdu(destAddr, statusReportRequested, uData);
    }

    /**
     * Get an SMS-SUBMIT PDU for a data message to a destination address &amp; port
     *
     * @param destAddr the address of the destination for the message
     * @param userData the data for the message
     * @param statusReportRequested Indicates whether a report is requested for this message.
     * @return a <code>SubmitPdu</code> containing the encoded SC
     *         address, if applicable, and the encoded message.
     *         Returns null on encode error.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:56.793 -0500", hash_original_method = "15C279B82B02BD0136F5028C9C8D61D0", hash_generated_method = "C2282C7CFA2056EC78A54317734F26F8")
    
public static SubmitPdu getSubmitPdu(String destAddr, UserData userData,
            boolean statusReportRequested) {
        return privateGetSubmitPdu(destAddr, statusReportRequested, userData);
    }

    /**
     * Calculate the number of septets needed to encode the message.
     *
     * @param messageBody the message to encode
     * @param use7bitOnly ignore (but still count) illegal characters if true
     * @return TextEncodingDetails
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:56.819 -0500", hash_original_method = "C814290BDB3D50BD3D6287FB6AC9378C", hash_generated_method = "E37471A98E8C39307A28164F7E7272D9")
    
public static TextEncodingDetails calculateLength(CharSequence messageBody,
            boolean use7bitOnly) {
        return BearerData.calcTextEncodingDetails(messageBody, use7bitOnly);
    }

    /**
     * Calculate the next message id, starting at 1 and iteratively
     * incrementing within the range 1..65535 remembering the state
     * via a persistent system property.  (See C.S0015-B, v2.0,
     * 4.3.1.5) Since this routine is expected to be accessed via via
     * binder-call, and hence should be thread-safe, it has been
     * synchronized.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:56.847 -0500", hash_original_method = "B1ECCC301AA91188E5EEB90EE18562E0", hash_generated_method = "A3F46B2E5D7E5D6512D9983CE5F52EC9")
    
private synchronized static int getNextMessageId() {
        // Testing and dialog with partners has indicated that
        // msgId==0 is (sometimes?) treated specially by lower levels.
        // Specifically, the ID is not preserved for delivery ACKs.
        // Hence, avoid 0 -- constraining the range to 1..65535.
        int msgId = SystemProperties.getInt(TelephonyProperties.PROPERTY_CDMA_MSG_ID, 1);
        String nextMsgId = Integer.toString((msgId % 0xFFFF) + 1);
        SystemProperties.set(TelephonyProperties.PROPERTY_CDMA_MSG_ID, nextMsgId);
        if (Log.isLoggable(LOGGABLE_TAG, Log.VERBOSE)) {
            Log.d(LOG_TAG, "next " + TelephonyProperties.PROPERTY_CDMA_MSG_ID + " = " + nextMsgId);
            Log.d(LOG_TAG, "readback gets " +
                    SystemProperties.get(TelephonyProperties.PROPERTY_CDMA_MSG_ID));
        }
        return msgId;
    }

    /**
     * Creates BearerData and Envelope from parameters for a Submit SMS.
     * @return byte stream for SubmitPdu.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:56.851 -0500", hash_original_method = "A4385799D730B1B0CC0428D2283AD11F", hash_generated_method = "AFC908DA3E27C0F23D900546811A98A8")
    
private static SubmitPdu privateGetSubmitPdu(String destAddrStr, boolean statusReportRequested,
            UserData userData) {

        /**
         * TODO(cleanup): give this function a more meaningful name.
         */

        /**
         * TODO(cleanup): Make returning null from the getSubmitPdu
         * variations meaningful -- clean up the error feedback
         * mechanism, and avoid null pointer exceptions.
         */

        /**
         * North America Plus Code :
         * Convert + code to 011 and dial out for international SMS
         */
        CdmaSmsAddress destAddr = CdmaSmsAddress.parse(
                PhoneNumberUtils.cdmaCheckAndProcessPlusCode(destAddrStr));
        if (destAddr == null) return null;

        BearerData bearerData = new BearerData();
        bearerData.messageType = BearerData.MESSAGE_TYPE_SUBMIT;

        bearerData.messageId = getNextMessageId();

        bearerData.deliveryAckReq = statusReportRequested;
        bearerData.userAckReq = false;
        bearerData.readAckReq = false;
        bearerData.reportReq = false;

        bearerData.userData = userData;

        byte[] encodedBearerData = BearerData.encode(bearerData);
        if (Log.isLoggable(LOGGABLE_TAG, Log.VERBOSE)) {
            Log.d(LOG_TAG, "MO (encoded) BearerData = " + bearerData);
            Log.d(LOG_TAG, "MO raw BearerData = '" + HexDump.toHexString(encodedBearerData) + "'");
        }
        if (encodedBearerData == null) return null;

        int teleservice = bearerData.hasUserDataHeader ?
                SmsEnvelope.TELESERVICE_WEMT : SmsEnvelope.TELESERVICE_WMT;

        SmsEnvelope envelope = new SmsEnvelope();
        envelope.messageType = SmsEnvelope.MESSAGE_TYPE_POINT_TO_POINT;
        envelope.teleService = teleservice;
        envelope.destAddress = destAddr;
        envelope.bearerReply = RETURN_ACK;
        envelope.bearerData = encodedBearerData;

        /**
         * TODO(cleanup): envelope looks to be a pointless class, get
         * rid of it.  Also -- most of the envelope fields set here
         * are ignored, why?
         */

        try {
            /**
             * TODO(cleanup): reference a spec and get rid of the ugly comments
             */
            ByteArrayOutputStream baos = new ByteArrayOutputStream(100);
            DataOutputStream dos = new DataOutputStream(baos);
            dos.writeInt(envelope.teleService);
            dos.writeInt(0); //servicePresent
            dos.writeInt(0); //serviceCategory
            dos.write(destAddr.digitMode);
            dos.write(destAddr.numberMode);
            dos.write(destAddr.ton); // number_type
            dos.write(destAddr.numberPlan);
            dos.write(destAddr.numberOfDigits);
            dos.write(destAddr.origBytes, 0, destAddr.origBytes.length); // digits
            // Subaddress is not supported.
            dos.write(0); //subaddressType
            dos.write(0); //subaddr_odd
            dos.write(0); //subaddr_nbr_of_digits
            dos.write(encodedBearerData.length);
            dos.write(encodedBearerData, 0, encodedBearerData.length);
            dos.close();

            SubmitPdu pdu = new SubmitPdu();
            pdu.encodedMessage = baos.toByteArray();
            pdu.encodedScAddress = null;
            return pdu;
        } catch(IOException ex) {
            Log.e(LOG_TAG, "creating SubmitPdu failed: " + ex);
        }
        return null;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:56.720 -0500", hash_original_field = "DB10E3AE28CC9996A816C3CCD7216A83", hash_generated_field = "37C2AB96DD7CCDC96FF809DAC1A6D712")

    static final String LOG_TAG = "CDMA";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:56.723 -0500", hash_original_field = "05BE73B868968A6E92AEF3C98FA9A448", hash_generated_field = "9363CC8A66AF573FDD4C4EAFB23F1719")

    static private final String LOGGABLE_TAG = "CDMA:SMS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:56.726 -0500", hash_original_field = "0E811A533EE6F3DBA24287171709A790", hash_generated_field = "C65F2A73F946D436D2201029781974D6")

    private final static byte TELESERVICE_IDENTIFIER                    = 0x00;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:56.729 -0500", hash_original_field = "51CEC42382CCFB8F6E506491846ED14D", hash_generated_field = "631EA667FBE5CC787A050F2AB978AD26")

    private final static byte SERVICE_CATEGORY                          = 0x01;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:56.732 -0500", hash_original_field = "A85A8FF67045274E53DB37E32C1C1D8F", hash_generated_field = "4C46DFCF7F018BB58EF0EDDE72736A41")

    private final static byte ORIGINATING_ADDRESS                       = 0x02;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:56.735 -0500", hash_original_field = "34FD2C400E3123667B9190C092B9C3AE", hash_generated_field = "75958DD895EF30960C4DDC1BFED7AB3E")

    private final static byte ORIGINATING_SUB_ADDRESS                   = 0x03;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:56.737 -0500", hash_original_field = "16F1F936233973E3D4114DF3F5598A75", hash_generated_field = "C80E39CEEAD1FA46761297E1FD4776A7")

    private final static byte DESTINATION_ADDRESS                       = 0x04;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:56.740 -0500", hash_original_field = "F8D4E9D2700CEA43D7B62802357515AB", hash_generated_field = "8CED3132652626592505768E52936428")

    private final static byte DESTINATION_SUB_ADDRESS                   = 0x05;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:56.743 -0500", hash_original_field = "9A6B98CDFE5B95570B0ABCA9CDEC1455", hash_generated_field = "18C838A90451BDFF11B450AA4B244836")

    private final static byte BEARER_REPLY_OPTION                       = 0x06;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:56.745 -0500", hash_original_field = "0C98BC4BEB94C7E4087745C434E54B5F", hash_generated_field = "CDDDEAEC17D512E97A804AE8045B86BF")

    private final static byte CAUSE_CODES                               = 0x07;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:56.748 -0500", hash_original_field = "8B13421881AD5F27A5C745AFB3CDB32B", hash_generated_field = "62CE98B8DFD2FCF87BE739E43598B88F")

    private final static byte BEARER_DATA                               = 0x08;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:56.755 -0500", hash_original_field = "E582F4B0F2632A628953D0918B6C225D", hash_generated_field = "FDDF3DFB7B3487AEC77BD14175979048")

    private static final int RETURN_NO_ACK  = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:56.758 -0500", hash_original_field = "7CEE666C58D3EEC5B41FC6D1F2EFE8F9", hash_generated_field = "8243279A7C0906DDE4D2CCFF57A1DBAA")

    private static final int RETURN_ACK     = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:56.753 -0500", hash_original_field = "72D62D1933050B7AC2D9DFC43782C64E", hash_generated_field = "4BAC49709EDEAEFDD9E07400E0F02406")

    private int status;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:56.766 -0500", hash_original_field = "DB128CD3B752231758348B3D7C8F0ADC", hash_generated_field = "5DE432FC9FD653332885B7638256C4A9")

    private SmsEnvelope mEnvelope;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:56.769 -0500", hash_original_field = "A6C6F32E4531FEF4087515342CE005CB", hash_generated_field = "B90F3642F146E4CB5B7C5D2425641201")

    private BearerData mBearerData;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.477 -0400", hash_original_method = "6C523C791261F68A00BC5A8339EB91FE", hash_generated_method = "6C523C791261F68A00BC5A8339EB91FE")
    public SmsMessage ()
    {
        //Synthesized constructor
    }

    /**
     * Note: This function is a GSM specific functionality which is not supported in CDMA mode.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:56.796 -0500", hash_original_method = "CFC9E8C6C71B803A9382349B0D254790", hash_generated_method = "1E62D1DAC0FFB971B9F7AA54D8238671")
    
public int getProtocolIdentifier() {
        Log.w(LOG_TAG, "getProtocolIdentifier: is not supported in CDMA mode.");
        // (3GPP TS 23.040): "no interworking, but SME to SME protocol":
        return 0;
    }

    /**
     * Note: This function is a GSM specific functionality which is not supported in CDMA mode.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:56.798 -0500", hash_original_method = "95CFCAABC583EA802C704015EAFBF308", hash_generated_method = "4715350B322F100A8EEAF52C45524B48")
    
public boolean isReplace() {
        Log.w(LOG_TAG, "isReplace: is not supported in CDMA mode.");
        return false;
    }

    /**
     * {@inheritDoc}
     * Note: This function is a GSM specific functionality which is not supported in CDMA mode.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:56.800 -0500", hash_original_method = "201DA8455DBB44F9D4BF017BFCDAFF9F", hash_generated_method = "D0872BA4455191769FF59B6251F1E680")
    
public boolean isCphsMwiMessage() {
        Log.w(LOG_TAG, "isCphsMwiMessage: is not supported in CDMA mode.");
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:56.802 -0500", hash_original_method = "B638C86EC79B8E5FA2D28FA811D2BCF0", hash_generated_method = "61E80D6571A00A1E7DC6126DF0A12264")
    
public boolean isMWIClearMessage() {
        return ((mBearerData != null) && (mBearerData.numberOfMessages == 0));
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:56.805 -0500", hash_original_method = "E19020FF854A35A2375E0A8AE070BF97", hash_generated_method = "8B51E772CFFAD7F4DCD3BE05B9748105")
    
public boolean isMWISetMessage() {
        return ((mBearerData != null) && (mBearerData.numberOfMessages > 0));
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:56.807 -0500", hash_original_method = "2F5A490D5EB0B5469046C11BA63EC135", hash_generated_method = "1DA5328D88D33A1F3E612ADF3B9BC0ED")
    
public boolean isMwiDontStore() {
        return ((mBearerData != null) &&
                (mBearerData.numberOfMessages > 0) &&
                (mBearerData.userData == null));
    }
    
    public static class SubmitPdu extends SubmitPduBase {
        
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.486 -0400", hash_original_method = "0DF27C295EE94AE1A62B7F3B1FD6EBC8", hash_generated_method = "0DF27C295EE94AE1A62B7F3B1FD6EBC8")
        public SubmitPdu ()
        {
            //Synthesized constructor
        }

    }

    /**
     * Returns the status for a previously submitted message.
     * For not interfering with status codes from GSM, this status code is
     * shifted to the bits 31-16.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:56.810 -0500", hash_original_method = "03B5EE24FC37A73D7F31FE2BAB3C2BFD", hash_generated_method = "D61B9EC8352A34F8304694E35F8F3AB4")
    
public int getStatus() {
        return (status << 16);
    }

    /** Return true iff the bearer data message type is DELIVERY_ACK. */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:56.812 -0500", hash_original_method = "A75C98E30CFF18DAC25DE4B33918A3F4", hash_generated_method = "06DD9DA11DA58271E78A992BD8C19713")
    
public boolean isStatusReportMessage() {
        return (mBearerData.messageType == BearerData.MESSAGE_TYPE_DELIVERY_ACK);
    }

    /**
     * Note: This function is a GSM specific functionality which is not supported in CDMA mode.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:56.815 -0500", hash_original_method = "0F1242A5312C3945C722AC39BFD87EF2", hash_generated_method = "AF5A5C7A32392CF1B3E8A044D8053EBF")
    
public boolean isReplyPathPresent() {
        Log.w(LOG_TAG, "isReplyPathPresent: is not supported in CDMA mode.");
        return false;
    }

    /**
     * Returns the teleservice type of the message.
     * @return the teleservice:
     *  {@link com.android.internal.telephony.cdma.sms.SmsEnvelope#TELESERVICE_NOT_SET},
     *  {@link com.android.internal.telephony.cdma.sms.SmsEnvelope#TELESERVICE_WMT},
     *  {@link com.android.internal.telephony.cdma.sms.SmsEnvelope#TELESERVICE_WEMT},
     *  {@link com.android.internal.telephony.cdma.sms.SmsEnvelope#TELESERVICE_VMN},
     *  {@link com.android.internal.telephony.cdma.sms.SmsEnvelope#TELESERVICE_WAP}
    */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:56.826 -0500", hash_original_method = "BA17728EC06E4E9670ACA616D9E29C12", hash_generated_method = "BA17728EC06E4E9670ACA616D9E29C12")
    
int getTeleService() {
        return mEnvelope.teleService;
    }

    /**
     * Returns the message type of the message.
     * @return the message type:
     *  {@link com.android.internal.telephony.cdma.sms.SmsEnvelope#MESSAGE_TYPE_POINT_TO_POINT},
     *  {@link com.android.internal.telephony.cdma.sms.SmsEnvelope#MESSAGE_TYPE_BROADCAST},
     *  {@link com.android.internal.telephony.cdma.sms.SmsEnvelope#MESSAGE_TYPE_ACKNOWLEDGE},
    */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:56.828 -0500", hash_original_method = "1BE3451C0D43919E5115D33DA4A62DB3", hash_generated_method = "1BE3451C0D43919E5115D33DA4A62DB3")
    
int getMessageType() {
        return mEnvelope.messageType;
    }

    /**
     * Decodes pdu to an empty SMS object.
     * In the CDMA case the pdu is just an internal byte stream representation
     * of the SMS Java-object.
     * @see #createPdu()
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:56.832 -0500", hash_original_method = "CD6FB45A1A4A8300476A32D9A94A5A2D", hash_generated_method = "267E465882A299B4FD631D6D40CF5E7E")
    
private void parsePdu(byte[] pdu) {
        ByteArrayInputStream bais = new ByteArrayInputStream(pdu);
        DataInputStream dis = new DataInputStream(bais);
        byte length;
        int bearerDataLength;
        SmsEnvelope env = new SmsEnvelope();
        CdmaSmsAddress addr = new CdmaSmsAddress();

        try {
            env.messageType = dis.readInt();
            env.teleService = dis.readInt();
            env.serviceCategory = dis.readInt();

            addr.digitMode = dis.readByte();
            addr.numberMode = dis.readByte();
            addr.ton = dis.readByte();
            addr.numberPlan = dis.readByte();

            length = dis.readByte();
            addr.numberOfDigits = length;
            addr.origBytes = new byte[length];
            dis.read(addr.origBytes, 0, length); // digits

            env.bearerReply = dis.readInt();
            // CauseCode values:
            env.replySeqNo = dis.readByte();
            env.errorClass = dis.readByte();
            env.causeCode = dis.readByte();

            //encoded BearerData:
            bearerDataLength = dis.readInt();
            env.bearerData = new byte[bearerDataLength];
            dis.read(env.bearerData, 0, bearerDataLength);
            dis.close();
        } catch (Exception ex) {
            Log.e(LOG_TAG, "createFromPdu: conversion from byte array to object failed: " + ex);
        }

        // link the filled objects to this SMS
        originatingAddress = addr;
        env.origAddress = addr;
        mEnvelope = env;
        mPdu = pdu;

        parseSms();
    }

    /**
     * Decodes 3GPP2 sms stored in CSIM/RUIM cards As per 3GPP2 C.S0015-0
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:56.837 -0500", hash_original_method = "4600019E789700BB681DB9CDCB53078A", hash_generated_method = "DB4BEEDC695F7A1D0A1EFB737C359D83")
    
private void parsePduFromEfRecord(byte[] pdu) {
        ByteArrayInputStream bais = new ByteArrayInputStream(pdu);
        DataInputStream dis = new DataInputStream(bais);
        SmsEnvelope env = new SmsEnvelope();
        CdmaSmsAddress addr = new CdmaSmsAddress();
        CdmaSmsSubaddress subAddr = new CdmaSmsSubaddress();

        try {
            env.messageType = dis.readByte();

            while (dis.available() > 0) {
                int parameterId = dis.readByte();
                int parameterLen = dis.readByte();
                byte[] parameterData = new byte[parameterLen];

                switch (parameterId) {
                    case TELESERVICE_IDENTIFIER:
                        /*
                         * 16 bit parameter that identifies which upper layer
                         * service access point is sending or should receive
                         * this message
                         */
                        env.teleService = dis.readUnsignedShort();
                        Log.i(LOG_TAG, "teleservice = " + env.teleService);
                        break;
                    case SERVICE_CATEGORY:
                        /*
                         * 16 bit parameter that identifies type of service as
                         * in 3GPP2 C.S0015-0 Table 3.4.3.2-1
                         */
                        env.serviceCategory = dis.readUnsignedShort();
                        break;
                    case ORIGINATING_ADDRESS:
                    case DESTINATION_ADDRESS:
                        dis.read(parameterData, 0, parameterLen);
                        BitwiseInputStream addrBis = new BitwiseInputStream(parameterData);
                        addr.digitMode = addrBis.read(1);
                        addr.numberMode = addrBis.read(1);
                        int numberType = 0;
                        if (addr.digitMode == CdmaSmsAddress.DIGIT_MODE_8BIT_CHAR) {
                            numberType = addrBis.read(3);
                            addr.ton = numberType;

                            if (addr.numberMode == CdmaSmsAddress.NUMBER_MODE_NOT_DATA_NETWORK)
                                addr.numberPlan = addrBis.read(4);
                        }

                        addr.numberOfDigits = addrBis.read(8);

                        byte[] data = new byte[addr.numberOfDigits];
                        byte b = 0x00;

                        if (addr.digitMode == CdmaSmsAddress.DIGIT_MODE_4BIT_DTMF) {
                            /* As per 3GPP2 C.S0005-0 Table 2.7.1.3.2.4-4 */
                            for (int index = 0; index < addr.numberOfDigits; index++) {
                                b = (byte) (0xF & addrBis.read(4));
                                // convert the value if it is 4-bit DTMF to 8
                                // bit
                                data[index] = convertDtmfToAscii(b);
                            }
                        } else if (addr.digitMode == CdmaSmsAddress.DIGIT_MODE_8BIT_CHAR) {
                            if (addr.numberMode == CdmaSmsAddress.NUMBER_MODE_NOT_DATA_NETWORK) {
                                for (int index = 0; index < addr.numberOfDigits; index++) {
                                    b = (byte) (0xFF & addrBis.read(8));
                                    data[index] = b;
                                }

                            } else if (addr.numberMode == CdmaSmsAddress.NUMBER_MODE_DATA_NETWORK) {
                                if (numberType == 2)
                                    Log.e(LOG_TAG, "TODO: Originating Addr is email id");
                                else
                                    Log.e(LOG_TAG,
                                          "TODO: Originating Addr is data network address");
                            } else {
                                Log.e(LOG_TAG, "Originating Addr is of incorrect type");
                            }
                        } else {
                            Log.e(LOG_TAG, "Incorrect Digit mode");
                        }
                        addr.origBytes = data;
                        Log.i(LOG_TAG, "Originating Addr=" + addr.toString());
                        break;
                    case ORIGINATING_SUB_ADDRESS:
                    case DESTINATION_SUB_ADDRESS:
                        dis.read(parameterData, 0, parameterLen);
                        BitwiseInputStream subAddrBis = new BitwiseInputStream(parameterData);
                        subAddr.type = subAddrBis.read(3);
                        subAddr.odd = subAddrBis.readByteArray(1)[0];
                        int subAddrLen = subAddrBis.read(8);
                        byte[] subdata = new byte[subAddrLen];
                        for (int index = 0; index < subAddrLen; index++) {
                            b = (byte) (0xFF & subAddrBis.read(4));
                            // convert the value if it is 4-bit DTMF to 8 bit
                            subdata[index] = convertDtmfToAscii(b);
                        }
                        subAddr.origBytes = subdata;
                        break;
                    case BEARER_REPLY_OPTION:
                        dis.read(parameterData, 0, parameterLen);
                        BitwiseInputStream replyOptBis = new BitwiseInputStream(parameterData);
                        env.bearerReply = replyOptBis.read(6);
                        break;
                    case CAUSE_CODES:
                        dis.read(parameterData, 0, parameterLen);
                        BitwiseInputStream ccBis = new BitwiseInputStream(parameterData);
                        env.replySeqNo = ccBis.readByteArray(6)[0];
                        env.errorClass = ccBis.readByteArray(2)[0];
                        if (env.errorClass != 0x00)
                            env.causeCode = ccBis.readByteArray(8)[0];
                        break;
                    case BEARER_DATA:
                        dis.read(parameterData, 0, parameterLen);
                        env.bearerData = parameterData;
                        break;
                    default:
                        throw new Exception("unsupported parameterId (" + parameterId + ")");
                }
            }
            bais.close();
            dis.close();
        } catch (Exception ex) {
            Log.e(LOG_TAG, "parsePduFromEfRecord: conversion from pdu to SmsMessage failed" + ex);
        }

        // link the filled objects to this SMS
        originatingAddress = addr;
        env.origAddress = addr;
        env.origSubaddress = subAddr;
        mEnvelope = env;
        mPdu = pdu;

        parseSms();
    }

    /**
     * Parses a SMS message from its BearerData stream. (mobile-terminated only)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:56.841 -0500", hash_original_method = "64AD6AE28B963471C0AF85BE0E89B856", hash_generated_method = "7439A5458564ACEE115AF724D68C9BB0")
    
protected void parseSms() {
        // Message Waiting Info Record defined in 3GPP2 C.S-0005, 3.7.5.6
        // It contains only an 8-bit number with the number of messages waiting
        if (mEnvelope.teleService == SmsEnvelope.TELESERVICE_MWI) {
            mBearerData = new BearerData();
            if (mEnvelope.bearerData != null) {
                mBearerData.numberOfMessages = 0x000000FF & mEnvelope.bearerData[0];
            }
            if (false) {
                Log.d(LOG_TAG, "parseSms: get MWI " +
                      Integer.toString(mBearerData.numberOfMessages));
            }
            return;
        }
        mBearerData = BearerData.decode(mEnvelope.bearerData);
        if (Log.isLoggable(LOGGABLE_TAG, Log.VERBOSE)) {
            Log.d(LOG_TAG, "MT raw BearerData = '" +
                      HexDump.toHexString(mEnvelope.bearerData) + "'");
            Log.d(LOG_TAG, "MT (decoded) BearerData = " + mBearerData);
        }
        messageRef = mBearerData.messageId;
        if (mBearerData.userData != null) {
            userData = mBearerData.userData.payload;
            userDataHeader = mBearerData.userData.userDataHeader;
            messageBody = mBearerData.userData.payloadStr;
        }

        if (originatingAddress != null) {
            originatingAddress.address = new String(originatingAddress.origBytes);
            if (false) Log.v(LOG_TAG, "SMS originating address: "
                    + originatingAddress.address);
        }

        if (mBearerData.msgCenterTimeStamp != null) {
            scTimeMillis = mBearerData.msgCenterTimeStamp.toMillis(true);
        }

        if (false) Log.d(LOG_TAG, "SMS SC timestamp: " + scTimeMillis);

        // Message Type (See 3GPP2 C.S0015-B, v2, 4.5.1)
        if (mBearerData.messageType == BearerData.MESSAGE_TYPE_DELIVERY_ACK) {
            // The BearerData MsgStatus subparameter should only be
            // included for DELIVERY_ACK messages.  If it occurred for
            // other messages, it would be unclear what the status
            // being reported refers to.  The MsgStatus subparameter
            // is primarily useful to indicate error conditions -- a
            // message without this subparameter is assumed to
            // indicate successful delivery (status == 0).
            if (! mBearerData.messageStatusSet) {
                Log.d(LOG_TAG, "DELIVERY_ACK message without msgStatus (" +
                        (userData == null ? "also missing" : "does have") +
                        " userData).");
                status = 0;
            } else {
                status = mBearerData.errorClass << 8;
                status |= mBearerData.messageStatus;
            }
        } else if (mBearerData.messageType != BearerData.MESSAGE_TYPE_DELIVER) {
            throw new RuntimeException("Unsupported message type: " + mBearerData.messageType);
        }

        if (messageBody != null) {
            if (false) Log.v(LOG_TAG, "SMS message body: '" + messageBody + "'");
            parseMessageBody();
        } else if ((userData != null) && (false)) {
            Log.v(LOG_TAG, "SMS payload: '" + IccUtils.bytesToHexString(userData) + "'");
        }
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:56.843 -0500", hash_original_method = "7EF6A65398433E9B1CBF5DF28BDBF834", hash_generated_method = "4B901E5266ABA3BD97C7C222FAF67F17")
    
public MessageClass getMessageClass() {
        if (BearerData.DISPLAY_MODE_IMMEDIATE == mBearerData.displayMode ) {
            return MessageClass.CLASS_0;
        } else {
            return MessageClass.UNKNOWN;
        }
    }

    /**
     * Creates byte array (pseudo pdu) from SMS object.
     * Note: Do not call this method more than once per object!
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:56.853 -0500", hash_original_method = "D3C9920CEA488FFF412D7F8E3FE64835", hash_generated_method = "1112B3A261238B6BEC43636417F4DA7A")
    
private void createPdu() {
        SmsEnvelope env = mEnvelope;
        CdmaSmsAddress addr = env.origAddress;
        ByteArrayOutputStream baos = new ByteArrayOutputStream(100);
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(baos));

        try {
            dos.writeInt(env.messageType);
            dos.writeInt(env.teleService);
            dos.writeInt(env.serviceCategory);

            dos.writeByte(addr.digitMode);
            dos.writeByte(addr.numberMode);
            dos.writeByte(addr.ton);
            dos.writeByte(addr.numberPlan);
            dos.writeByte(addr.numberOfDigits);
            dos.write(addr.origBytes, 0, addr.origBytes.length); // digits

            dos.writeInt(env.bearerReply);
            // CauseCode values:
            dos.writeByte(env.replySeqNo);
            dos.writeByte(env.errorClass);
            dos.writeByte(env.causeCode);
            //encoded BearerData:
            dos.writeInt(env.bearerData.length);
            dos.write(env.bearerData, 0, env.bearerData.length);
            dos.close();

            /**
             * TODO(cleanup) -- The mPdu field is managed in
             * a fragile manner, and it would be much nicer if
             * accessing the serialized representation used a less
             * fragile mechanism.  Maybe the getPdu method could
             * generate a representation if there was not yet one?
             */

            mPdu = baos.toByteArray();
        } catch (IOException ex) {
            Log.e(LOG_TAG, "createPdu: conversion from object to byte array failed: " + ex);
        }
    }

    /**
     * Converts a 4-Bit DTMF encoded symbol from the calling address number to ASCII character
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:56.857 -0500", hash_original_method = "A11C498F23B8370C7C5D04AE2A0C173A", hash_generated_method = "F3C11577317FE8B59675FBC5C5FEBB98")
    
private byte convertDtmfToAscii(byte dtmfDigit) {
        byte asciiDigit;

        switch (dtmfDigit) {
        case  0: asciiDigit = 68; break; // 'D'
        case  1: asciiDigit = 49; break; // '1'
        case  2: asciiDigit = 50; break; // '2'
        case  3: asciiDigit = 51; break; // '3'
        case  4: asciiDigit = 52; break; // '4'
        case  5: asciiDigit = 53; break; // '5'
        case  6: asciiDigit = 54; break; // '6'
        case  7: asciiDigit = 55; break; // '7'
        case  8: asciiDigit = 56; break; // '8'
        case  9: asciiDigit = 57; break; // '9'
        case 10: asciiDigit = 48; break; // '0'
        case 11: asciiDigit = 42; break; // '*'
        case 12: asciiDigit = 35; break; // '#'
        case 13: asciiDigit = 65; break; // 'A'
        case 14: asciiDigit = 66; break; // 'B'
        case 15: asciiDigit = 67; break; // 'C'
        default:
            asciiDigit = 32; // Invalid DTMF code
            break;
        }

        return asciiDigit;
    }

    /** This function  shall be called to get the number of voicemails.
     * @hide
     */
    /*package*/ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:56.859 -0500", hash_original_method = "D8D3E4C6269124C18E32B3734994B647", hash_generated_method = "D8D3E4C6269124C18E32B3734994B647")
    
int getNumOfVoicemails() {
        return mBearerData.numberOfMessages;
    }

    /**
     * Returns a byte array that can be use to uniquely identify a received SMS message.
     * C.S0015-B  4.3.1.6 Unique Message Identification.
     *
     * @return byte array uniquely identifying the message.
     * @hide
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:56.861 -0500", hash_original_method = "ECE8D39C64EEB1FB74B915B4B0882D92", hash_generated_method = "ECE8D39C64EEB1FB74B915B4B0882D92")
    
byte[] getIncomingSmsFingerprint() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        output.write(mEnvelope.teleService);
        output.write(mEnvelope.origAddress.origBytes, 0, mEnvelope.origAddress.origBytes.length);
        output.write(mEnvelope.bearerData, 0, mEnvelope.bearerData.length);
        output.write(mEnvelope.origSubaddress.origBytes, 0,
                mEnvelope.origSubaddress.origBytes.length);

        return output.toByteArray();
    }
}

