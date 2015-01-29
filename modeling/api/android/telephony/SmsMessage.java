package android.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import static android.telephony.TelephonyManager.PHONE_TYPE_CDMA;

import java.util.ArrayList;
import java.util.Arrays;

import android.os.Parcel;
import android.util.Log;

import com.android.internal.telephony.GsmAlphabet;
import com.android.internal.telephony.SmsMessageBase;
import com.android.internal.telephony.SmsMessageBase.SubmitPduBase;
import com.android.internal.telephony.SmsMessageBase.TextEncodingDetails;

public class SmsMessage {

    /**
     * Create an SmsMessage from a raw PDU.
     *
     * <p><b>This method will soon be deprecated</b> and all applications which handle
     * incoming SMS messages by processing the {@code SMS_RECEIVED_ACTION} broadcast
     * intent <b>must</b> now pass the new {@code format} String extra from the intent
     * into the new method {@code createFromPdu(byte[], String)} which takes an
     * extra format parameter. This is required in order to correctly decode the PDU on
     * devices that require support for both 3GPP and 3GPP2 formats at the same time,
     * such as dual-mode GSM/CDMA and CDMA/LTE phones.
     */
    @DSSource({DSSourceKind.SMS_MMS})
    @DSComment("SMS message creation from raw data")
    @DSSafe(DSCat.DATA_STRUCTURE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:49.603 -0500", hash_original_method = "CF7F94C2BDE173AF6CC483B3F8BE19B9", hash_generated_method = "D130F6B0A70B67E3ACC0B0A502946CA3")
    
public static SmsMessage createFromPdu(byte[] pdu) {
        int activePhone = TelephonyManager.getDefault().getCurrentPhoneType();
        String format = (PHONE_TYPE_CDMA == activePhone) ? FORMAT_3GPP2 : FORMAT_3GPP;
        return createFromPdu(pdu, format);
    }

    /**
     * Create an SmsMessage from a raw PDU with the specified message format. The
     * message format is passed in the {@code SMS_RECEIVED_ACTION} as the {@code format}
     * String extra, and will be either "3gpp" for GSM/UMTS/LTE messages in 3GPP format
     * or "3gpp2" for CDMA/LTE messages in 3GPP2 format.
     *
     * @param pdu the message PDU from the SMS_RECEIVED_ACTION intent
     * @param format the format extra from the SMS_RECEIVED_ACTION intent
     * @hide pending API council approval
     */
    @DSSource({DSSourceKind.SMS_MMS})
    @DSSafe(DSCat.DATA_STRUCTURE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:49.608 -0500", hash_original_method = "B5B0C01DE595010BFEEC3AB703E88508", hash_generated_method = "FDF9E8B8EA9AE0FA9656134B5470A32A")
    
public static SmsMessage createFromPdu(byte[] pdu, String format) {
        SmsMessageBase wrappedMessage;

        if (FORMAT_3GPP2.equals(format)) {
            wrappedMessage = com.android.internal.telephony.cdma.SmsMessage.createFromPdu(pdu);
        } else if (FORMAT_3GPP.equals(format)) {
            wrappedMessage = com.android.internal.telephony.gsm.SmsMessage.createFromPdu(pdu);
        } else {
            Log.e(LOG_TAG, "createFromPdu(): unsupported message format " + format);
            return null;
        }

        return new SmsMessage(wrappedMessage);
    }

    /**
     * TS 27.005 3.4.1 lines[0] and lines[1] are the two lines read from the
     * +CMT unsolicited response (PDU mode, of course)
     *  +CMT: [&lt;alpha>],<length><CR><LF><pdu>
     *
     * Only public for debugging and for RIL
     *
     * {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:49.611 -0500", hash_original_method = "C5F8AF04E2B353E3814D87E2C7E1B91D", hash_generated_method = "D188BFEB15C693341974D551CA49C4A1")
    
public static SmsMessage newFromCMT(String[] lines) {
        // received SMS in 3GPP format
        SmsMessageBase wrappedMessage =
                com.android.internal.telephony.gsm.SmsMessage.newFromCMT(lines);

        return new SmsMessage(wrappedMessage);
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:49.615 -0500", hash_original_method = "7B8C162A35325E6011B23B50AEDCA0EA", hash_generated_method = "8AC5B51723A7B9F0E707F3574358E027")
    
public static SmsMessage newFromParcel(Parcel p) {
        // received SMS in 3GPP2 format
        SmsMessageBase wrappedMessage =
                com.android.internal.telephony.cdma.SmsMessage.newFromParcel(p);

        return new SmsMessage(wrappedMessage);
    }

    /**
     * Create an SmsMessage from an SMS EF record.
     *
     * @param index Index of SMS record. This should be index in ArrayList
     *              returned by SmsManager.getAllMessagesFromSim + 1.
     * @param data Record data.
     * @return An SmsMessage representing the record.
     *
     * @hide
     */
    @DSSource({DSSourceKind.SMS_MMS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:49.619 -0500", hash_original_method = "025100544259F7D0606564E546A2F5E4", hash_generated_method = "2341EDD86EA5813174DCE00E483983B5")
    
public static SmsMessage createFromEfRecord(int index, byte[] data) {
        SmsMessageBase wrappedMessage;
        int activePhone = TelephonyManager.getDefault().getCurrentPhoneType();

        if (PHONE_TYPE_CDMA == activePhone) {
            wrappedMessage = com.android.internal.telephony.cdma.SmsMessage.createFromEfRecord(
                    index, data);
        } else {
            wrappedMessage = com.android.internal.telephony.gsm.SmsMessage.createFromEfRecord(
                    index, data);
        }

        return wrappedMessage != null ? new SmsMessage(wrappedMessage) : null;
    }

    /**
     * Get the TP-Layer-Length for the given SMS-SUBMIT PDU Basically, the
     * length in bytes (not hex chars) less the SMSC header
     *
     * FIXME: This method is only used by a CTS test case that isn't run on CDMA devices.
     * We should probably deprecate it and remove the obsolete test case.
     */
    @DSSource({DSSourceKind.SMS_MMS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:49.623 -0500", hash_original_method = "4B19EE32A85514EDB37C0B0F3BBF250F", hash_generated_method = "921D6D67A4D5509E6C4FAFD6B59DA26E")
    
public static int getTPLayerLengthForPDU(String pdu) {
        int activePhone = TelephonyManager.getDefault().getCurrentPhoneType();

        if (PHONE_TYPE_CDMA == activePhone) {
            return com.android.internal.telephony.cdma.SmsMessage.getTPLayerLengthForPDU(pdu);
        } else {
            return com.android.internal.telephony.gsm.SmsMessage.getTPLayerLengthForPDU(pdu);
        }
    }

    /*
     * TODO(cleanup): It would make some sense if the result of
     * preprocessing a message to determine the proper encoding (i.e.
     * the resulting data structure from calculateLength) could be
     * passed as an argument to the actual final encoding function.
     * This would better ensure that the logic behind size calculation
     * actually matched the encoding.
     */

    /**
     * Calculates the number of SMS's required to encode the message body and
     * the number of characters remaining until the next message.
     *
     * @param msgBody the message to encode
     * @param use7bitOnly if true, characters that are not part of the
     *         radio-specific 7-bit encoding are counted as single
     *         space chars.  If false, and if the messageBody contains
     *         non-7-bit encodable characters, length is calculated
     *         using a 16-bit encoding.
     * @return an int[4] with int[0] being the number of SMS's
     *         required, int[1] the number of code units used, and
     *         int[2] is the number of code units remaining until the
     *         next message. int[3] is an indicator of the encoding
     *         code unit size (see the ENCODING_* definitions in this
     *         class).
     */
    @DSComment("data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:49.627 -0500", hash_original_method = "13E7FC3E1B070CE7A770D3168E7D6A0F", hash_generated_method = "7EA1B99EDFDED904417122D334B7E3DF")
    
public static int[] calculateLength(CharSequence msgBody, boolean use7bitOnly) {
        int activePhone = TelephonyManager.getDefault().getCurrentPhoneType();
        TextEncodingDetails ted = (PHONE_TYPE_CDMA == activePhone) ?
            com.android.internal.telephony.cdma.SmsMessage.calculateLength(msgBody, use7bitOnly) :
            com.android.internal.telephony.gsm.SmsMessage.calculateLength(msgBody, use7bitOnly);
        int ret[] = new int[4];
        ret[0] = ted.msgCount;
        ret[1] = ted.codeUnitCount;
        ret[2] = ted.codeUnitsRemaining;
        ret[3] = ted.codeUnitSize;
        return ret;
    }

    /**
     * Divide a message text into several fragments, none bigger than
     * the maximum SMS message text size.
     *
     * @param text text, must not be null.
     * @return an <code>ArrayList</code> of strings that, in order,
     *   comprise the original msg text
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:49.633 -0500", hash_original_method = "E2DED68AC9B462E78AE6945CB037592B", hash_generated_method = "886EFB9D1599BB90032DDEDB84CFDE25")
    
public static ArrayList<String> fragmentText(String text) {
        int activePhone = TelephonyManager.getDefault().getCurrentPhoneType();
        TextEncodingDetails ted = (PHONE_TYPE_CDMA == activePhone) ?
            com.android.internal.telephony.cdma.SmsMessage.calculateLength(text, false) :
            com.android.internal.telephony.gsm.SmsMessage.calculateLength(text, false);

        // TODO(cleanup): The code here could be rolled into the logic
        // below cleanly if these MAX_* constants were defined more
        // flexibly...

        int limit;
        if (ted.codeUnitSize == ENCODING_7BIT) {
            int udhLength;
            if (ted.languageTable != 0 && ted.languageShiftTable != 0) {
                udhLength = GsmAlphabet.UDH_SEPTET_COST_TWO_SHIFT_TABLES;
            } else if (ted.languageTable != 0 || ted.languageShiftTable != 0) {
                udhLength = GsmAlphabet.UDH_SEPTET_COST_ONE_SHIFT_TABLE;
            } else {
                udhLength = 0;
            }

            if (ted.msgCount > 1) {
                udhLength += GsmAlphabet.UDH_SEPTET_COST_CONCATENATED_MESSAGE;
            }

            if (udhLength != 0) {
                udhLength += GsmAlphabet.UDH_SEPTET_COST_LENGTH;
            }

            limit = MAX_USER_DATA_SEPTETS - udhLength;
        } else {
            if (ted.msgCount > 1) {
                limit = MAX_USER_DATA_BYTES_WITH_HEADER;
            } else {
                limit = MAX_USER_DATA_BYTES;
            }
        }

        int pos = 0;  // Index in code units.
        int textLen = text.length();
        ArrayList<String> result = new ArrayList<String>(ted.msgCount);
        while (pos < textLen) {
            int nextPos = 0;  // Counts code units.
            if (ted.codeUnitSize == ENCODING_7BIT) {
                if (activePhone == PHONE_TYPE_CDMA && ted.msgCount == 1) {
                    // For a singleton CDMA message, the encoding must be ASCII...
                    nextPos = pos + Math.min(limit, textLen - pos);
                } else {
                    // For multi-segment messages, CDMA 7bit equals GSM 7bit encoding (EMS mode).
                    nextPos = GsmAlphabet.findGsmSeptetLimitIndex(text, pos, limit,
                            ted.languageTable, ted.languageShiftTable);
                }
            } else {  // Assume unicode.
                nextPos = pos + Math.min(limit / 2, textLen - pos);
            }
            if ((nextPos <= pos) || (nextPos > textLen)) {
                Log.e(LOG_TAG, "fragmentText failed (" + pos + " >= " + nextPos + " or " +
                          nextPos + " >= " + textLen + ")");
                break;
            }
            result.add(text.substring(pos, nextPos));
            pos = nextPos;
        }
        return result;
    }

    /**
     * Calculates the number of SMS's required to encode the message body and
     * the number of characters remaining until the next message, given the
     * current encoding.
     *
     * @param messageBody the message to encode
     * @param use7bitOnly if true, characters that are not part of the radio
     *         specific (GSM / CDMA) alphabet encoding are converted to as a
     *         single space characters. If false, a messageBody containing
     *         non-GSM or non-CDMA alphabet characters are encoded using
     *         16-bit encoding.
     * @return an int[4] with int[0] being the number of SMS's required, int[1]
     *         the number of code units used, and int[2] is the number of code
     *         units remaining until the next message. int[3] is the encoding
     *         type that should be used for the message.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:49.637 -0500", hash_original_method = "3F53836604A3169B964FEAA2D80DC740", hash_generated_method = "6389A096C6C5B364BEBC6472E3D31AB4")
    
public static int[] calculateLength(String messageBody, boolean use7bitOnly) {
        return calculateLength((CharSequence)messageBody, use7bitOnly);
    }

    /*
     * TODO(cleanup): It looks like there is now no useful reason why
     * apps should generate pdus themselves using these routines,
     * instead of handing the raw data to SMSDispatcher (and thereby
     * have the phone process do the encoding).  Moreover, CDMA now
     * has shared state (in the form of the msgId system property)
     * which can only be modified by the phone process, and hence
     * makes the output of these routines incorrect.  Since they now
     * serve no purpose, they should probably just return null
     * directly, and be deprecated.  Going further in that direction,
     * the above parsers of serialized pdu data should probably also
     * be gotten rid of, hiding all but the necessarily visible
     * structured data from client apps.  A possible concern with
     * doing this is that apps may be using these routines to generate
     * pdus that are then sent elsewhere, some network server, for
     * example, and that always returning null would thereby break
     * otherwise useful apps.
     */

    /**
     * Get an SMS-SUBMIT PDU for a destination address and a message.
     * This method will not attempt to use any GSM national language 7 bit encodings.
     *
     * @param scAddress Service Centre address.  Null means use default.
     * @return a <code>SubmitPdu</code> containing the encoded SC
     *         address, if applicable, and the encoded message.
     *         Returns null on encode error.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:49.642 -0500", hash_original_method = "A51A57E31C7898594F04DE753700B14D", hash_generated_method = "617A0137F65DC1A03DB55F091E3EA10D")
    
public static SubmitPdu getSubmitPdu(String scAddress,
            String destinationAddress, String message, boolean statusReportRequested) {
        SubmitPduBase spb;
        int activePhone = TelephonyManager.getDefault().getCurrentPhoneType();

        if (PHONE_TYPE_CDMA == activePhone) {
            spb = com.android.internal.telephony.cdma.SmsMessage.getSubmitPdu(scAddress,
                    destinationAddress, message, statusReportRequested, null);
        } else {
            spb = com.android.internal.telephony.gsm.SmsMessage.getSubmitPdu(scAddress,
                    destinationAddress, message, statusReportRequested);
        }

        return new SubmitPdu(spb);
    }

    /**
     * Get an SMS-SUBMIT PDU for a data message to a destination address &amp; port.
     * This method will not attempt to use any GSM national language 7 bit encodings.
     *
     * @param scAddress Service Centre address. null == use default
     * @param destinationAddress the address of the destination for the message
     * @param destinationPort the port to deliver the message to at the
     *        destination
     * @param data the data for the message
     * @return a <code>SubmitPdu</code> containing the encoded SC
     *         address, if applicable, and the encoded message.
     *         Returns null on encode error.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:49.646 -0500", hash_original_method = "A3431A292BD1310EF113F59EE5895A8C", hash_generated_method = "637A5B8E501B3F6288E2CDA2842661CE")
    
public static SubmitPdu getSubmitPdu(String scAddress,
            String destinationAddress, short destinationPort, byte[] data,
            boolean statusReportRequested) {
        SubmitPduBase spb;
        int activePhone = TelephonyManager.getDefault().getCurrentPhoneType();

        if (PHONE_TYPE_CDMA == activePhone) {
            spb = com.android.internal.telephony.cdma.SmsMessage.getSubmitPdu(scAddress,
                    destinationAddress, destinationPort, data, statusReportRequested);
        } else {
            spb = com.android.internal.telephony.gsm.SmsMessage.getSubmitPdu(scAddress,
                    destinationAddress, destinationPort, data, statusReportRequested);
        }

        return new SubmitPdu(spb);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:49.526 -0500", hash_original_field = "C996BA564C8E7280B21DCC0E50132626", hash_generated_field = "5D6970F5D62D74D2B187EA5DA34AA652")

    private static final String LOG_TAG = "SMS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:49.532 -0500", hash_original_field = "CE1AB8C9FAA00ACFE72982204A371EC7", hash_generated_field = "27499AC5501958C24E1C878C00171D98")

    public static final int ENCODING_UNKNOWN = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:49.537 -0500", hash_original_field = "3B5343803931A1659FC591BDF9B19152", hash_generated_field = "E3BD113EFA27FC80F1215EAC10F05F54")

    public static final int ENCODING_7BIT = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:49.541 -0500", hash_original_field = "055659E670AD8F4BFCEED3633333260B", hash_generated_field = "C6C4A2BD27CE6056084528ABE2108D41")

    public static final int ENCODING_8BIT = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:49.544 -0500", hash_original_field = "CCF0F17470D34E7089449F78CC1EE485", hash_generated_field = "A5A42D0A35339D86DEBBCEB46B9756FA")

    public static final int ENCODING_16BIT = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:49.549 -0500", hash_original_field = "375145D0F1B6FDB99ED4976C06CDF8ED", hash_generated_field = "9FA989A1AC757B009256AA97A922831A")

    public static final int ENCODING_KSC5601 = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:49.554 -0500", hash_original_field = "D1C121A1939F690ED892C1A8578A2533", hash_generated_field = "0257BE4B4F208A23154B8F18AB43FEC5")

    public static final int MAX_USER_DATA_BYTES = 140;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:49.558 -0500", hash_original_field = "D42C9EC2E4E5D7B6DD86DB4DE42D10DA", hash_generated_field = "C84733D22240FE9846722841159ECECC")

    public static final int MAX_USER_DATA_BYTES_WITH_HEADER = 134;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:49.562 -0500", hash_original_field = "CBC4A688CED5D5155F69705A7A7D8E29", hash_generated_field = "BA710E28657EDC31EF8505D2CAA6A62C")

    public static final int MAX_USER_DATA_SEPTETS = 160;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:49.566 -0500", hash_original_field = "47E80C9B483F482930A56CE881265D9F", hash_generated_field = "1E7DC369DA9053C67AF8B9AB932C4C33")

    public static final int MAX_USER_DATA_SEPTETS_WITH_HEADER = 153;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:49.570 -0500", hash_original_field = "57FBEA8AF80730C3A6D7212C7D7C56E7", hash_generated_field = "1A314915591575EE5AB81A039C2EA299")

    public static final String FORMAT_3GPP = "3gpp";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:49.573 -0500", hash_original_field = "264B870D5F012C99C9C5F07E230D93D1", hash_generated_field = "D953DB3D95F249D4E9F6EAC3FC5F26A3")

    public static final String FORMAT_3GPP2 = "3gpp2";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:49.577 -0500", hash_original_field = "D58A4ABAA917CE673BC06A6DCE19B3D4", hash_generated_field = "6512A5313A4B16FABCD0C4BB52D92A5B")

    public SmsMessageBase mWrappedSmsMessage;

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:49.599 -0500", hash_original_method = "8785081C14DC1062450E96A46CF3DF25", hash_generated_method = "160E8077F5999571B4B1C03D54A61684")
    
private SmsMessage(SmsMessageBase smb) {
        mWrappedSmsMessage = smb;
    }

    /**
     * Returns the address of the SMS service center that relayed this message
     * or null if there is none.
     */
    @DSComment("data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SMS_MMS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:49.650 -0500", hash_original_method = "918A2835DDADF3191B8B6CF8127F286C", hash_generated_method = "D2BBE7103262E98ECE08E23E782B26CE")
    
public String getServiceCenterAddress() {
        return mWrappedSmsMessage.getServiceCenterAddress();
    }

    /**
     * Returns the originating address (sender) of this SMS message in String
     * form or null if unavailable
     */
    @DSComment("data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SMS_MMS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:49.653 -0500", hash_original_method = "E9EFC86835C6B2F047600D750A41AA1C", hash_generated_method = "93AAA0AA1B2814015145729AEFBD57FD")
    
public String getOriginatingAddress() {
        return mWrappedSmsMessage.getOriginatingAddress();
    }

    /**
     * Returns the originating address, or email from address if this message
     * was from an email gateway. Returns null if originating address
     * unavailable.
     */
    @DSComment("data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SMS_MMS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:49.657 -0500", hash_original_method = "A66BB5C1A20948050FC14BD05462FCCC", hash_generated_method = "1FF8B5A61361428A910FF4BE7EF44F5F")
    
public String getDisplayOriginatingAddress() {
        return mWrappedSmsMessage.getDisplayOriginatingAddress();
    }

    /**
     * Returns the message body as a String, if it exists and is text based.
     * @return message body is there is one, otherwise null
     */
    @DSComment("data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SMS_MMS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:49.660 -0500", hash_original_method = "11C71A7ADD8F40537023F3C9896D9F41", hash_generated_method = "7774CA66961BBDA3065A3890C914D58B")
    
public String getMessageBody() {
        return mWrappedSmsMessage.getMessageBody();
    }

    /**
     * Returns the class of this message.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:49.663 -0500", hash_original_method = "099557EF4A3D1E47FF142271693B3FFE", hash_generated_method = "2E9AF2B272ED33A6DE45E869DACDC2AB")
    
public MessageClass getMessageClass() {
        return mWrappedSmsMessage.getMessageClass();
    }

    /**
     * Returns the message body, or email message body if this message was from
     * an email gateway. Returns null if message body unavailable.
     */
    @DSComment("data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SMS_MMS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:49.666 -0500", hash_original_method = "DDB62DAFB6CA28A8B02386170905555B", hash_generated_method = "4A92242B5D1C975FE9D1D846D52F61BD")
    
public String getDisplayMessageBody() {
        return mWrappedSmsMessage.getDisplayMessageBody();
    }

    /**
     * Unofficial convention of a subject line enclosed in parens empty string
     * if not present
     */
    @DSComment("data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SMS_MMS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:49.669 -0500", hash_original_method = "A55B37ECD2D988C3EC358C7240F7EDE2", hash_generated_method = "3077F9E9A5D9D5EBCFF44F791CF0E538")
    
public String getPseudoSubject() {
        return mWrappedSmsMessage.getPseudoSubject();
    }

    /**
     * Returns the service centre timestamp in currentTimeMillis() format
     */
    @DSComment("data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SMS_MMS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:49.674 -0500", hash_original_method = "A397C7F820656CEADBC57751F7E32997", hash_generated_method = "F1C1819DA2E5CEC79CA8EE20AEF6B5DB")
    
public long getTimestampMillis() {
        return mWrappedSmsMessage.getTimestampMillis();
    }

    /**
     * Returns true if message is an email.
     *
     * @return true if this message came through an email gateway and email
     *         sender / subject / parsed body are available
     */
    @DSComment("data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:49.677 -0500", hash_original_method = "A5B6E1F6D425F99E0AE9246791CF1B08", hash_generated_method = "B309F6487EC0084BAC11E56A87B00298")
    
public boolean isEmail() {
        return mWrappedSmsMessage.isEmail();
    }

     /**
     * @return if isEmail() is true, body of the email sent through the gateway.
     *         null otherwise
     */
    @DSComment("data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SMS_MMS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:49.681 -0500", hash_original_method = "1B76815865383567D84D772FA102258B", hash_generated_method = "64676D1234D53B5BF7E74543FA25CFB8")
    
public String getEmailBody() {
        return mWrappedSmsMessage.getEmailBody();
    }

    /**
     * @return if isEmail() is true, email from address of email sent through
     *         the gateway. null otherwise
     */
    @DSComment("data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SMS_MMS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:49.684 -0500", hash_original_method = "CF41F1C32C92AADB2191A6AB99FD49D6", hash_generated_method = "3D47F8BD991072AD2EA7E10922210673")
    
public String getEmailFrom() {
        return mWrappedSmsMessage.getEmailFrom();
    }

    /**
     * Get protocol identifier.
     */
    @DSSource({DSSourceKind.SMS_MMS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:49.687 -0500", hash_original_method = "642EF36AD67598AD564965134BACF8A1", hash_generated_method = "9E3A7AB70857F546303E4451348F4D10")
    
public int getProtocolIdentifier() {
        return mWrappedSmsMessage.getProtocolIdentifier();
    }

    /**
     * See TS 23.040 9.2.3.9 returns true if this is a "replace short message"
     * SMS
     */
    @DSComment("data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:49.691 -0500", hash_original_method = "36F360B7C447980FEF01C7653F551835", hash_generated_method = "6A1F95A295531C17D734D7B8172E25FC")
    
public boolean isReplace() {
        return mWrappedSmsMessage.isReplace();
    }

    /**
     * Returns true for CPHS MWI toggle message.
     *
     * @return true if this is a CPHS MWI toggle message See CPHS 4.2 section
     *         B.4.2
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:49.694 -0500", hash_original_method = "553B9246636C3A5BC903932A40C4BC5E", hash_generated_method = "FA87EB70F96C0E9808E3DF35429E1873")
    
public boolean isCphsMwiMessage() {
        return mWrappedSmsMessage.isCphsMwiMessage();
    }
    
    public enum MessageClass{
        UNKNOWN, CLASS_0, CLASS_1, CLASS_2, CLASS_3;
    }
    
    public static class SubmitPdu {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:49.581 -0500", hash_original_field = "C8745BBAF5F74776C20A108492164E97", hash_generated_field = "B7E7B1E4BBABCFD1218DEF1D08E579CA")

        public byte[] encodedScAddress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:49.585 -0500", hash_original_field = "67003B73FD5C802781F626C68CAE8BB6", hash_generated_field = "59202226E3585983001906EF1AF63678")

        public byte[] encodedMessage;

        /**
         * @hide
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:49.592 -0500", hash_original_method = "84E90F8D80D26E2676EED6BCE3E65E06", hash_generated_method = "961864B876064E52BC08249CC28D98B7")
        
protected SubmitPdu(SubmitPduBase spb) {
            this.encodedMessage = spb.encodedMessage;
            this.encodedScAddress = spb.encodedScAddress;
        }

        @DSSafe(DSCat.SAFE_LIST)
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:49.588 -0500", hash_original_method = "A866707516A0999C629C71FD5B45C6F7", hash_generated_method = "D0C20D3DE0C0706C4141E4BF6E7BAEC9")
        
public String toString() {
            return "SubmitPdu: encodedScAddress = "
                    + Arrays.toString(encodedScAddress)
                    + ", encodedMessage = "
                    + Arrays.toString(encodedMessage);
        }
        
    }

    /**
     * returns true if this message is a CPHS voicemail / message waiting
     * indicator (MWI) clear message
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:49.697 -0500", hash_original_method = "129EA72B0C9F078142A2BC814FB30CFA", hash_generated_method = "1395F39F0AFF24A9D7E47FBD6C73F711")
    
public boolean isMWIClearMessage() {
        return mWrappedSmsMessage.isMWIClearMessage();
    }

    /**
     * returns true if this message is a CPHS voicemail / message waiting
     * indicator (MWI) set message
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:49.701 -0500", hash_original_method = "5602B112C459EA0AD88653A254825A5D", hash_generated_method = "DED8E69DAEAD7F291990A7522CE6A2F7")
    
public boolean isMWISetMessage() {
        return mWrappedSmsMessage.isMWISetMessage();
    }

    /**
     * returns true if this message is a "Message Waiting Indication Group:
     * Discard Message" notification and should not be stored.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:49.704 -0500", hash_original_method = "0ACB85E19D1AFC6F8EA2F470F677C800", hash_generated_method = "9393A5946E1A40C3CF22463056704523")
    
public boolean isMwiDontStore() {
        return mWrappedSmsMessage.isMwiDontStore();
    }

    /**
     * returns the user data section minus the user data header if one was
     * present.
     */
    @DSSource({DSSourceKind.SMS_MMS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:49.708 -0500", hash_original_method = "251D6D0F20B7389DF3878BB8173A6B0A", hash_generated_method = "23C8682F8F23C90FC2013A652FED8E2D")
    
public byte[] getUserData() {
        return mWrappedSmsMessage.getUserData();
    }

    /**
     * Returns the raw PDU for the message.
     *
     * @return the raw PDU for the message.
     */
    @DSSource({DSSourceKind.SMS_MMS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:49.711 -0500", hash_original_method = "F61520780332A4249272ED211A1EBC6F", hash_generated_method = "381C9D609E26ADA8F5256FD1947E56D8")
    
public byte[] getPdu() {
        return mWrappedSmsMessage.getPdu();
    }

    /**
     * Returns the status of the message on the SIM (read, unread, sent, unsent).
     *
     * @return the status of the message on the SIM.  These are:
     *         SmsManager.STATUS_ON_SIM_FREE
     *         SmsManager.STATUS_ON_SIM_READ
     *         SmsManager.STATUS_ON_SIM_UNREAD
     *         SmsManager.STATUS_ON_SIM_SEND
     *         SmsManager.STATUS_ON_SIM_UNSENT
     * @deprecated Use getStatusOnIcc instead.
     */
    @DSSource({DSSourceKind.SMS_MMS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:49.714 -0500", hash_original_method = "43D7E194BC6DB0E7804F1B1454D5CCBF", hash_generated_method = "CC30C810E2B6E132FBD59CA9600655C5")
    
@Deprecated public int getStatusOnSim() {
        return mWrappedSmsMessage.getStatusOnIcc();
    }

    /**
     * Returns the status of the message on the ICC (read, unread, sent, unsent).
     *
     * @return the status of the message on the ICC.  These are:
     *         SmsManager.STATUS_ON_ICC_FREE
     *         SmsManager.STATUS_ON_ICC_READ
     *         SmsManager.STATUS_ON_ICC_UNREAD
     *         SmsManager.STATUS_ON_ICC_SEND
     *         SmsManager.STATUS_ON_ICC_UNSENT
     */
    @DSSource({DSSourceKind.SMS_MMS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:49.718 -0500", hash_original_method = "F41186F27A3FFD01878B6A79ACBBD00F", hash_generated_method = "670ADD5D39BB148FF5A3F6EB171D6184")
    
public int getStatusOnIcc() {
        return mWrappedSmsMessage.getStatusOnIcc();
    }

    /**
     * Returns the record index of the message on the SIM (1-based index).
     * @return the record index of the message on the SIM, or -1 if this
     *         SmsMessage was not created from a SIM SMS EF record.
     * @deprecated Use getIndexOnIcc instead.
     */
    @DSSource({DSSourceKind.SMS_MMS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:49.722 -0500", hash_original_method = "150B1A5BD8253701A69C723196BA6DF9", hash_generated_method = "EA45187BE1A5462EBAC3618828E9E766")
    
@Deprecated public int getIndexOnSim() {
        return mWrappedSmsMessage.getIndexOnIcc();
    }

    /**
     * Returns the record index of the message on the ICC (1-based index).
     * @return the record index of the message on the ICC, or -1 if this
     *         SmsMessage was not created from a ICC SMS EF record.
     */
    @DSSource({DSSourceKind.SMS_MMS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:49.725 -0500", hash_original_method = "4C0DE2049D9873C839084BE4DC285920", hash_generated_method = "112A1018B16AA1B92A49CFBC6C2C8AD9")
    
public int getIndexOnIcc() {
        return mWrappedSmsMessage.getIndexOnIcc();
    }

    /**
     * GSM:
     * For an SMS-STATUS-REPORT message, this returns the status field from
     * the status report.  This field indicates the status of a previously
     * submitted SMS, if requested.  See TS 23.040, 9.2.3.15 TP-Status for a
     * description of values.
     * CDMA:
     * For not interfering with status codes from GSM, the value is
     * shifted to the bits 31-16.
     * The value is composed of an error class (bits 25-24) and a status code (bits 23-16).
     * Possible codes are described in C.S0015-B, v2.0, 4.5.21.
     *
     * @return 0 indicates the previously sent message was received.
     *         See TS 23.040, 9.9.2.3.15 and C.S0015-B, v2.0, 4.5.21
     *         for a description of other possible values.
     */
    @DSSource({DSSourceKind.SMS_MMS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:49.728 -0500", hash_original_method = "BAA167F31D67CF27268081CFB0D79A6E", hash_generated_method = "51E3BE84330918BEAE5AEBA96376F796")
    
public int getStatus() {
        return mWrappedSmsMessage.getStatus();
    }

    /**
     * Return true iff the message is a SMS-STATUS-REPORT message.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:49.732 -0500", hash_original_method = "D10C36D7B6CDC51D018139E7A34B7076", hash_generated_method = "75F94075F8DDFE48734272B5192F0A28")
    
public boolean isStatusReportMessage() {
        return mWrappedSmsMessage.isStatusReportMessage();
    }

    /**
     * Returns true iff the <code>TP-Reply-Path</code> bit is set in
     * this message.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:49.736 -0500", hash_original_method = "F508F532A25EB5B4727057181F2BF528", hash_generated_method = "1237B74E8ECF0647A1B1DA830D1899AE")
    
public boolean isReplyPathPresent() {
        return mWrappedSmsMessage.isReplyPathPresent();
    }
}

