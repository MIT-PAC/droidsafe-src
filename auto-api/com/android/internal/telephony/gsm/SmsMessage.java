package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.telephony.PhoneNumberUtils;
import android.text.format.Time;
import android.util.Log;
import com.android.internal.telephony.EncodeException;
import com.android.internal.telephony.GsmAlphabet;
import com.android.internal.telephony.IccUtils;
import com.android.internal.telephony.SmsHeader;
import com.android.internal.telephony.SmsMessageBase;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import static android.telephony.SmsMessage.ENCODING_16BIT;
import static android.telephony.SmsMessage.ENCODING_7BIT;
import static android.telephony.SmsMessage.ENCODING_8BIT;
import static android.telephony.SmsMessage.ENCODING_KSC5601;
import static android.telephony.SmsMessage.ENCODING_UNKNOWN;
import static android.telephony.SmsMessage.MAX_USER_DATA_BYTES;
import static android.telephony.SmsMessage.MAX_USER_DATA_BYTES_WITH_HEADER;
import static android.telephony.SmsMessage.MAX_USER_DATA_SEPTETS;
import static android.telephony.SmsMessage.MessageClass;

public class SmsMessage extends SmsMessageBase {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.082 -0400", hash_original_field = "D302E5EFB0B648FBA3A15C5F33DF9776", hash_generated_field = "7857416028EC39FBC0A39F3682AC483E")

    private MessageClass messageClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.082 -0400", hash_original_field = "19A04FAFB5F9DD7E606920C3ADACF8F0", hash_generated_field = "E7356B822A8D6EAF5A79AC5BFB93BA7C")

    private int mti;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.082 -0400", hash_original_field = "5B061E5E44867E47310F5788A9CC721F", hash_generated_field = "B1BC4F1F687666F5FB78306ED8E39C0D")

    private int protocolIdentifier;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.082 -0400", hash_original_field = "35CE477420B8D0FBD7AD0A0ED5C35EDB", hash_generated_field = "D845AB3694191CB4C3D298D5D655FF89")

    private int dataCodingScheme;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.082 -0400", hash_original_field = "3A4B1350CCFB9DDB78E5BC4724F25DAD", hash_generated_field = "5A5EDAAFEA15A0CAB3F6DE0AD07E40A4")

    private boolean replyPathPresent = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.082 -0400", hash_original_field = "FDFB42EA9B5FA1CC073BC11EE3632EAD", hash_generated_field = "AE8157ED2C11F4093644915D3F083BA5")

    private boolean automaticDeletion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.082 -0400", hash_original_field = "112EC8599C86EC7759EEB9B0F5A1A838", hash_generated_field = "C607017C2C44E60AAC44759C98F463E7")

    private boolean forSubmit;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.082 -0400", hash_original_field = "E0CBA49A23F21B04D743530E3F81F000", hash_generated_field = "6F3AA87D4A1136C3D307623CA6224439")

    private GsmSmsAddress recipientAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.082 -0400", hash_original_field = "6C085D4E8DE0E11E87CAEFF561247D33", hash_generated_field = "7F8B1302B10B9B6031593ECB5E2259BB")

    private long dischargeTimeMillis;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.083 -0400", hash_original_field = "9ACB44549B41563697BB490144EC6258", hash_generated_field = "4BAC49709EDEAEFDD9E07400E0F02406")

    private int status;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.083 -0400", hash_original_field = "9039A5255B50C39AE6EBC764E6B25AD1", hash_generated_field = "63317BD16A868FCF8316B9F91C279BC5")

    private boolean isStatusReportMessage = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.083 -0400", hash_original_method = "6C523C791261F68A00BC5A8339EB91FE", hash_generated_method = "6C523C791261F68A00BC5A8339EB91FE")
    public SmsMessage ()
    {
        //Synthesized constructor
    }


        public static SmsMessage createFromPdu(byte[] pdu) {
        try {
            SmsMessage msg = new SmsMessage();
            msg.parsePdu(pdu);
            return msg;
        } catch (RuntimeException ex) {
            Log.e(LOG_TAG, "SMS PDU parsing failed: ", ex);
            return null;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.083 -0400", hash_original_method = "AD0C1E28FA77467C1A6AC08BEE60D8C5", hash_generated_method = "BDAA26E459C73C160466165B61F2FA05")
    public boolean isTypeZero() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_809040551 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_809040551;
        // ---------- Original Method ----------
        //return (protocolIdentifier == 0x40);
    }

    
        public static SmsMessage newFromCMT(String[] lines) {
        try {
            SmsMessage msg = new SmsMessage();
            msg.parsePdu(IccUtils.hexStringToBytes(lines[1]));
            return msg;
        } catch (RuntimeException ex) {
            Log.e(LOG_TAG, "SMS PDU parsing failed: ", ex);
            return null;
        }
    }

    
        public static SmsMessage newFromCDS(String line) {
        try {
            SmsMessage msg = new SmsMessage();
            msg.parsePdu(IccUtils.hexStringToBytes(line));
            return msg;
        } catch (RuntimeException ex) {
            Log.e(LOG_TAG, "CDS SMS PDU parsing failed: ", ex);
            return null;
        }
    }

    
        public static SmsMessage createFromEfRecord(int index, byte[] data) {
        try {
            SmsMessage msg = new SmsMessage();
            msg.indexOnIcc = index;
            if ((data[0] & 1) == 0) {
                Log.w(LOG_TAG,
                        "SMS parsing failed: Trying to parse a free record");
                return null;
            } else {
                msg.statusOnIcc = data[0] & 0x07;
            }
            int size = data.length - 1;
            byte[] pdu = new byte[size];
            System.arraycopy(data, 1, pdu, 0, size);
            msg.parsePdu(pdu);
            return msg;
        } catch (RuntimeException ex) {
            Log.e(LOG_TAG, "SMS PDU parsing failed: ", ex);
            return null;
        }
    }

    
        public static int getTPLayerLengthForPDU(String pdu) {
        int len = pdu.length() / 2;
        int smscLen = Integer.parseInt(pdu.substring(0, 2), 16);
        return len - smscLen - 1;
    }

    
        public static SubmitPdu getSubmitPdu(String scAddress,
            String destinationAddress, String message,
            boolean statusReportRequested, byte[] header) {
        return getSubmitPdu(scAddress, destinationAddress, message, statusReportRequested, header,
                ENCODING_UNKNOWN, 0, 0);
    }

    
        public static SubmitPdu getSubmitPdu(String scAddress,
            String destinationAddress, String message,
            boolean statusReportRequested, byte[] header, int encoding,
            int languageTable, int languageShiftTable) {
        if (message == null || destinationAddress == null) {
            return null;
        }
        if (encoding == ENCODING_UNKNOWN) {
            TextEncodingDetails ted = calculateLength(message, false);
            encoding = ted.codeUnitSize;
            languageTable = ted.languageTable;
            languageShiftTable = ted.languageShiftTable;
            if (encoding == ENCODING_7BIT && (languageTable != 0 || languageShiftTable != 0)) {
                if (header != null) {
                    SmsHeader smsHeader = SmsHeader.fromByteArray(header);
                    if (smsHeader.languageTable != languageTable
                            || smsHeader.languageShiftTable != languageShiftTable) {
                        Log.w(LOG_TAG, "Updating language table in SMS header: "
                                + smsHeader.languageTable + " -> " + languageTable + ", "
                                + smsHeader.languageShiftTable + " -> " + languageShiftTable);
                        smsHeader.languageTable = languageTable;
                        smsHeader.languageShiftTable = languageShiftTable;
                        header = SmsHeader.toByteArray(smsHeader);
                    }
                } else {
                    SmsHeader smsHeader = new SmsHeader();
                    smsHeader.languageTable = languageTable;
                    smsHeader.languageShiftTable = languageShiftTable;
                    header = SmsHeader.toByteArray(smsHeader);
                }
            }
        }
        SubmitPdu ret = new SubmitPdu();
        byte mtiByte = (byte)(0x01 | (header != null ? 0x40 : 0x00));
        ByteArrayOutputStream bo = getSubmitPduHead(
                scAddress, destinationAddress, mtiByte,
                statusReportRequested, ret);
        byte[] userData;
        try {
            if (encoding == ENCODING_7BIT) {
                userData = GsmAlphabet.stringToGsm7BitPackedWithHeader(message, header,
                        languageTable, languageShiftTable);
            } else { 
                try {
                    userData = encodeUCS2(message, header);
                } catch(UnsupportedEncodingException uex) {
                    Log.e(LOG_TAG,
                            "Implausible UnsupportedEncodingException ",
                            uex);
                    return null;
                }
            }
        } catch (EncodeException ex) {
            try {
                userData = encodeUCS2(message, header);
                encoding = ENCODING_16BIT;
            } catch(UnsupportedEncodingException uex) {
                Log.e(LOG_TAG,
                        "Implausible UnsupportedEncodingException ",
                        uex);
                return null;
            }
        }
        if (encoding == ENCODING_7BIT) {
            if ((0xff & userData[0]) > MAX_USER_DATA_SEPTETS) {
                Log.e(LOG_TAG, "Message too long (" + (0xff & userData[0]) + " septets)");
                return null;
            }
            bo.write(0x00);
        } else { 
            if ((0xff & userData[0]) > MAX_USER_DATA_BYTES) {
                Log.e(LOG_TAG, "Message too long (" + (0xff & userData[0]) + " bytes)");
                return null;
            }
            bo.write(0x08);
        }
        bo.write(userData, 0, userData.length);
        ret.encodedMessage = bo.toByteArray();
        return ret;
    }

    
        private static byte[] encodeUCS2(String message, byte[] header) throws UnsupportedEncodingException {
        byte[] userData, textPart;
        textPart = message.getBytes("utf-16be");
        if (header != null) {
            userData = new byte[header.length + textPart.length + 1];
            userData[0] = (byte)header.length;
            System.arraycopy(header, 0, userData, 1, header.length);
            System.arraycopy(textPart, 0, userData, header.length + 1, textPart.length);
        }
        else {
            userData = textPart;
        }
        byte[] ret = new byte[userData.length+1];
        ret[0] = (byte) (userData.length & 0xff );
        System.arraycopy(userData, 0, ret, 1, userData.length);
        return ret;
    }

    
        public static SubmitPdu getSubmitPdu(String scAddress,
            String destinationAddress, String message,
            boolean statusReportRequested) {
        return getSubmitPdu(scAddress, destinationAddress, message, statusReportRequested, null);
    }

    
        public static SubmitPdu getSubmitPdu(String scAddress,
            String destinationAddress, int destinationPort, byte[] data,
            boolean statusReportRequested) {
        SmsHeader.PortAddrs portAddrs = new SmsHeader.PortAddrs();
        portAddrs.destPort = destinationPort;
        portAddrs.origPort = 0;
        portAddrs.areEightBits = false;
        SmsHeader smsHeader = new SmsHeader();
        smsHeader.portAddrs = portAddrs;
        byte[] smsHeaderData = SmsHeader.toByteArray(smsHeader);
        if ((data.length + smsHeaderData.length + 1) > MAX_USER_DATA_BYTES) {
            Log.e(LOG_TAG, "SMS data message may only contain "
                    + (MAX_USER_DATA_BYTES - smsHeaderData.length - 1) + " bytes");
            return null;
        }
        SubmitPdu ret = new SubmitPdu();
        ByteArrayOutputStream bo = getSubmitPduHead(
                scAddress, destinationAddress, (byte) 0x41, 
                statusReportRequested, ret);
        bo.write(0x04);
        bo.write(data.length + smsHeaderData.length + 1);
        bo.write(smsHeaderData.length);
        bo.write(smsHeaderData, 0, smsHeaderData.length);
        bo.write(data, 0, data.length);
        ret.encodedMessage = bo.toByteArray();
        return ret;
    }

    
        private static ByteArrayOutputStream getSubmitPduHead(
            String scAddress, String destinationAddress, byte mtiByte,
            boolean statusReportRequested, SubmitPdu ret) {
        ByteArrayOutputStream bo = new ByteArrayOutputStream(
                MAX_USER_DATA_BYTES + 40);
        if (scAddress == null) {
            ret.encodedScAddress = null;
        } else {
            ret.encodedScAddress = PhoneNumberUtils.networkPortionToCalledPartyBCDWithLength(
                    scAddress);
        }
        if (statusReportRequested) {
            mtiByte |= 0x20;
            if (false) Log.d(LOG_TAG, "SMS status report requested");
        }
        bo.write(mtiByte);
        bo.write(0);
        byte[] daBytes;
        daBytes = PhoneNumberUtils.networkPortionToCalledPartyBCD(destinationAddress);
        bo.write((daBytes.length - 1) * 2
                - ((daBytes[daBytes.length - 1] & 0xf0) == 0xf0 ? 1 : 0));
        bo.write(daBytes, 0, daBytes.length);
        bo.write(0);
        return bo;
    }

    
        public static TextEncodingDetails calculateLength(CharSequence msgBody,
            boolean use7bitOnly) {
        TextEncodingDetails ted = GsmAlphabet.countGsmSeptets(msgBody, use7bitOnly);
        if (ted == null) {
            ted = new TextEncodingDetails();
            int octets = msgBody.length() * 2;
            ted.codeUnitCount = msgBody.length();
            if (octets > MAX_USER_DATA_BYTES) {
                ted.msgCount = (octets + (MAX_USER_DATA_BYTES_WITH_HEADER - 1)) /
                        MAX_USER_DATA_BYTES_WITH_HEADER;
                ted.codeUnitsRemaining = ((ted.msgCount *
                        MAX_USER_DATA_BYTES_WITH_HEADER) - octets) / 2;
            } else {
                ted.msgCount = 1;
                ted.codeUnitsRemaining = (MAX_USER_DATA_BYTES - octets)/2;
            }
            ted.codeUnitSize = ENCODING_16BIT;
        }
        return ted;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.106 -0400", hash_original_method = "E7C032F027F70A1B6B025F651AAD0755", hash_generated_method = "866BD90E835C094D6280CC8B3985C63D")
    @Override
    public int getProtocolIdentifier() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_395539995 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_395539995;
        // ---------- Original Method ----------
        //return protocolIdentifier;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.107 -0400", hash_original_method = "5E449C3565950C318CBD3ECE2F1F0BD6", hash_generated_method = "A6B599B91C6E17F807418F69802EC4D0")
     int getDataCodingScheme() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_481082162 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_481082162;
        // ---------- Original Method ----------
        //return dataCodingScheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.107 -0400", hash_original_method = "BDE809523E280561E9C29F7B9A7C7DBF", hash_generated_method = "A0A830DBED7718691F2A388551CB38B5")
    @Override
    public boolean isReplace() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_409428122 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_409428122;
        // ---------- Original Method ----------
        //return (protocolIdentifier & 0xc0) == 0x40
                //&& (protocolIdentifier & 0x3f) > 0
                //&& (protocolIdentifier & 0x3f) < 8;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.107 -0400", hash_original_method = "8C882F4C280C6C8CC6957F303C6657A2", hash_generated_method = "74B38A3218C187CBB7823B0A98CED3D1")
    @Override
    public boolean isCphsMwiMessage() {
        boolean var0064C8543CFB04FA8B8C5337C3D73C6E_324628661 = (((GsmSmsAddress) originatingAddress).isCphsVoiceMessageClear()
                || ((GsmSmsAddress) originatingAddress).isCphsVoiceMessageSet());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_19071473 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_19071473;
        // ---------- Original Method ----------
        //return ((GsmSmsAddress) originatingAddress).isCphsVoiceMessageClear()
                //|| ((GsmSmsAddress) originatingAddress).isCphsVoiceMessageSet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.108 -0400", hash_original_method = "70DC4C6B18CE83A6EFAF90F534A37766", hash_generated_method = "484732C7615EE7D418F552590CAF6F8E")
    @Override
    public boolean isMWIClearMessage() {
        boolean var5B99184308D7B96B7C766273527E2F51_517710216 = (originatingAddress != null
                && ((GsmSmsAddress) originatingAddress).isCphsVoiceMessageClear());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_203873155 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_203873155;
        // ---------- Original Method ----------
        //if (isMwi && !mwiSense) {
            //return true;
        //}
        //return originatingAddress != null
                //&& ((GsmSmsAddress) originatingAddress).isCphsVoiceMessageClear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.108 -0400", hash_original_method = "29E72ED32BDC3692E9219EFE428EB222", hash_generated_method = "2BE65909E32415ACA9ACE562EC634CC9")
    @Override
    public boolean isMWISetMessage() {
        boolean var0009BB8C429D24589ED9599970648826_1127764545 = (originatingAddress != null
                && ((GsmSmsAddress) originatingAddress).isCphsVoiceMessageSet());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1428146853 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1428146853;
        // ---------- Original Method ----------
        //if (isMwi && mwiSense) {
            //return true;
        //}
        //return originatingAddress != null
                //&& ((GsmSmsAddress) originatingAddress).isCphsVoiceMessageSet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.112 -0400", hash_original_method = "06DE61C568026EFDCDFB983D9CE6FFEE", hash_generated_method = "FE2D13612B5B00ED1FAC5AA0A9419499")
    @Override
    public boolean isMwiDontStore() {
        {
            boolean var99DBAC6B8998FB78C7361CC808533243_1878708974 = (isCphsMwiMessage());
            {
                {
                    boolean varBE63956A4C4D7FD446688CEDCE89BD02_1892107175 = (" ".equals(getMessageBody()));
                    {
                        ;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_69226288 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_69226288;
        // ---------- Original Method ----------
        //if (isMwi && mwiDontStore) {
            //return true;
        //}
        //if (isCphsMwiMessage()) {
            //if (" ".equals(getMessageBody())) {
                //;
            //}
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.112 -0400", hash_original_method = "A6874122EB6D2A9BF852845259D73D4C", hash_generated_method = "60CB0F3B33C19F061267FD0D1B2CF44B")
    @Override
    public int getStatus() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_125040521 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_125040521;
        // ---------- Original Method ----------
        //return status;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.112 -0400", hash_original_method = "234314E66EB58BCF2E45191C1F3D0599", hash_generated_method = "A8E9FBC582C0511C94559E3F99677FC4")
    @Override
    public boolean isStatusReportMessage() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1356078163 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1356078163;
        // ---------- Original Method ----------
        //return isStatusReportMessage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.113 -0400", hash_original_method = "D49F3476E255463D6592CF4849CB4273", hash_generated_method = "597DD1B0B68064A1E4F3CF857F2590F4")
    @Override
    public boolean isReplyPathPresent() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1850760317 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1850760317;
        // ---------- Original Method ----------
        //return replyPathPresent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.113 -0400", hash_original_method = "AF62799239B28F1660277ADF3CA55E81", hash_generated_method = "77FFD8890A06648ACFBEE05F7B3B9DCA")
    private void parsePdu(byte[] pdu) {
        mPdu = pdu;
        PduParser p;
        p = new PduParser(pdu);
        scAddress = p.getSCAddress();
        {
            Log.d(LOG_TAG, "SMS SC address: " + scAddress);
        } //End block
        int firstByte;
        firstByte = p.getByte();
        mti = firstByte & 0x3;
        //Begin case 0 3 
        parseSmsDeliver(p, firstByte);
        //End case 0 3 
        //Begin case 2 
        parseSmsStatusReport(p, firstByte);
        //End case 2 
        //Begin case default 
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Unsupported message type");
        //End case default 
        addTaint(pdu[0]);
        // ---------- Original Method ----------
        //mPdu = pdu;
        //PduParser p = new PduParser(pdu);
        //scAddress = p.getSCAddress();
        //if (scAddress != null) {
            //if (false) Log.d(LOG_TAG, "SMS SC address: " + scAddress);
        //}
        //int firstByte = p.getByte();
        //mti = firstByte & 0x3;
        //switch (mti) {
        //case 0:
        //case 3: 
            //parseSmsDeliver(p, firstByte);
            //break;
        //case 2:
            //parseSmsStatusReport(p, firstByte);
            //break;
        //default:
            //throw new RuntimeException("Unsupported message type");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.114 -0400", hash_original_method = "A70831539166366B9681E2ACC95982AC", hash_generated_method = "8AA5E8BA37EE906EB3DB97C4AC75E9E5")
    private void parseSmsStatusReport(PduParser p, int firstByte) {
        isStatusReportMessage = true;
        forSubmit = (firstByte & 0x20) == 0x00;
        messageRef = p.getByte();
        recipientAddress = p.getAddress();
        scTimeMillis = p.getSCTimestampMillis();
        dischargeTimeMillis = p.getSCTimestampMillis();
        status = p.getByte();
        {
            boolean varB6E943617D844E0DA7DE4A065AB8CE61_1530602472 = (p.moreDataPresent());
            {
                int extraParams;
                extraParams = p.getByte();
                int moreExtraParams;
                moreExtraParams = extraParams;
                {
                    moreExtraParams = p.getByte();
                } //End block
                {
                    protocolIdentifier = p.getByte();
                } //End block
                {
                    dataCodingScheme = p.getByte();
                } //End block
                {
                    boolean hasUserDataHeader;
                    hasUserDataHeader = (firstByte & 0x40) == 0x40;
                    parseUserData(p, hasUserDataHeader);
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.126 -0400", hash_original_method = "7E3F60FEC92AD175AC8D63C56FC781E1", hash_generated_method = "96443380E96CE209377A91411DF78C52")
    private void parseSmsDeliver(PduParser p, int firstByte) {
        replyPathPresent = (firstByte & 0x80) == 0x80;
        originatingAddress = p.getAddress();
        protocolIdentifier = p.getByte();
        dataCodingScheme = p.getByte();
        scTimeMillis = p.getSCTimestampMillis();
        Log.d(LOG_TAG, "SMS SC timestamp: " + scTimeMillis);
        boolean hasUserDataHeader;
        hasUserDataHeader = (firstByte & 0x40) == 0x40;
        parseUserData(p, hasUserDataHeader);
        // ---------- Original Method ----------
        //replyPathPresent = (firstByte & 0x80) == 0x80;
        //originatingAddress = p.getAddress();
        //if (originatingAddress != null) {
            //if (false) Log.v(LOG_TAG, "SMS originating address: "
                    //+ originatingAddress.address);
        //}
        //protocolIdentifier = p.getByte();
        //dataCodingScheme = p.getByte();
        //if (false) {
            //Log.v(LOG_TAG, "SMS TP-PID:" + protocolIdentifier
                    //+ " data coding scheme: " + dataCodingScheme);
        //}
        //scTimeMillis = p.getSCTimestampMillis();
        //if (false) Log.d(LOG_TAG, "SMS SC timestamp: " + scTimeMillis);
        //boolean hasUserDataHeader = (firstByte & 0x40) == 0x40;
        //parseUserData(p, hasUserDataHeader);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.139 -0400", hash_original_method = "445BCC4CA8B8EE2EB716CA993346CBBC", hash_generated_method = "F6EE2ABFAD08AD34CA05EC0D79EA2DD4")
    private void parseUserData(PduParser p, boolean hasUserDataHeader) {
        boolean hasMessageClass;
        hasMessageClass = false;
        boolean userDataCompressed;
        userDataCompressed = false;
        int encodingType;
        encodingType = ENCODING_UNKNOWN;
        {
            automaticDeletion = (0 != (dataCodingScheme & 0x40));
            userDataCompressed = (0 != (dataCodingScheme & 0x20));
            hasMessageClass = (0 != (dataCodingScheme & 0x10));
            {
                //Begin case 0 
                encodingType = ENCODING_7BIT;
                //End case 0 
                //Begin case 2 
                encodingType = ENCODING_16BIT;
                //End case 2 
                //Begin case 1 3 
                encodingType = ENCODING_8BIT;
                //End case 1 3 
            } //End block
        } //End block
        {
            automaticDeletion = false;
            hasMessageClass = true;
            userDataCompressed = false;
            {
                encodingType = ENCODING_7BIT;
            } //End block
            {
                encodingType = ENCODING_8BIT;
            } //End block
        } //End block
        {
            {
                encodingType = ENCODING_16BIT;
            } //End block
            {
                encodingType = ENCODING_7BIT;
            } //End block
            userDataCompressed = false;
            boolean active;
            active = ((dataCodingScheme & 0x08) == 0x08);
            {
                isMwi = true;
                mwiSense = active;
                mwiDontStore = ((dataCodingScheme & 0xF0) == 0xC0);
            } //End block
            {
                isMwi = false;
            } //End block
        } //End block
        {
            {
                encodingType = ENCODING_KSC5601;
            } //End block
        } //End block
        int count;
        count = p.constructUserData(hasUserDataHeader,
                encodingType == ENCODING_7BIT);
        this.userData = p.getUserData();
        this.userDataHeader = p.getUserDataHeader();
        //Begin case ENCODING_UNKNOWN ENCODING_8BIT 
        messageBody = null;
        //End case ENCODING_UNKNOWN ENCODING_8BIT 
        //Begin case ENCODING_7BIT 
        messageBody = p.getUserDataGSM7Bit(count,
                    hasUserDataHeader ? userDataHeader.languageTable : 0,
                    hasUserDataHeader ? userDataHeader.languageShiftTable : 0);
        //End case ENCODING_7BIT 
        //Begin case ENCODING_16BIT 
        messageBody = p.getUserDataUCS2(count);
        //End case ENCODING_16BIT 
        //Begin case ENCODING_KSC5601 
        messageBody = p.getUserDataKSC5601(count);
        //End case ENCODING_KSC5601 
        {
            parseMessageBody();
        } //End block
        {
            messageClass = MessageClass.UNKNOWN;
        } //End block
        {
            //Begin case 0 
            messageClass = MessageClass.CLASS_0;
            //End case 0 
            //Begin case 1 
            messageClass = MessageClass.CLASS_1;
            //End case 1 
            //Begin case 2 
            messageClass = MessageClass.CLASS_2;
            //End case 2 
            //Begin case 3 
            messageClass = MessageClass.CLASS_3;
            //End case 3 
        } //End block
        addTaint(p.getTaint());
        addTaint(hasUserDataHeader);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.148 -0400", hash_original_method = "A363CB6F91B76BEA5906C381D551632B", hash_generated_method = "A6F4E3D1FDE7E102AF5706A5F6BA069E")
    @Override
    public MessageClass getMessageClass() {
        MessageClass varB4EAC82CA7396A68D541C85D26508E83_1434020060 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1434020060 = messageClass;
        varB4EAC82CA7396A68D541C85D26508E83_1434020060.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1434020060;
        // ---------- Original Method ----------
        //return messageClass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.149 -0400", hash_original_method = "E16A5CBE2AF5641D1FC19A09E4EADBC9", hash_generated_method = "F4C053077C44461E1E42EBABC01BC417")
     boolean isUsimDataDownload() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1018636200 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1018636200;
        // ---------- Original Method ----------
        //return messageClass == MessageClass.CLASS_2 &&
                //(protocolIdentifier == 0x7f || protocolIdentifier == 0x7c);
    }

    
    public static class SubmitPdu extends SubmitPduBase {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.149 -0400", hash_original_method = "0DF27C295EE94AE1A62B7F3B1FD6EBC8", hash_generated_method = "0DF27C295EE94AE1A62B7F3B1FD6EBC8")
        public SubmitPdu ()
        {
            //Synthesized constructor
        }


    }


    
    private static class PduParser {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.150 -0400", hash_original_field = "5645D4C4B415EFD5ECD9CF6111004AD6", hash_generated_field = "19D13A40BDDB2C7F8CD159EA0077CC93")

        byte pdu[];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.150 -0400", hash_original_field = "B5FDDF1EF601E74DB01C1425561A38CB", hash_generated_field = "2F4877CE6BA21232C2B8D66924B60128")

        int cur;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.151 -0400", hash_original_field = "743D61CD0F8B499FFB5961C09D48393C", hash_generated_field = "532180B80C80AE52803AEB5499571541")

        SmsHeader userDataHeader;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.151 -0400", hash_original_field = "56491F2E1C74898E18BB6E47D2425B19", hash_generated_field = "A84FAC4EE7B4249A85AFD54238EB3F78")

        byte[] userData;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.151 -0400", hash_original_field = "6944462409EAAFC73113C0FD4675221D", hash_generated_field = "E1D52F93D65AFF05A56D0C19482CCBAC")

        int mUserDataSeptetPadding;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.151 -0400", hash_original_field = "8DCFA4D4E6C8EBBFB5F773290A97E452", hash_generated_field = "DDFAE6B21F6F82F78AE1E9B94A4CE136")

        int mUserDataSize;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.157 -0400", hash_original_method = "A42B16D029D2C7C381F18291645B39B4", hash_generated_method = "5267DA8D3D50F83E586973C8E13B029F")
          PduParser(byte[] pdu) {
            this.pdu = pdu;
            cur = 0;
            mUserDataSeptetPadding = 0;
            addTaint(pdu[0]);
            // ---------- Original Method ----------
            //this.pdu = pdu;
            //cur = 0;
            //mUserDataSeptetPadding = 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.158 -0400", hash_original_method = "99E23657D695EA8C595E80B24F474921", hash_generated_method = "DECF5729A85484C4F73A0922E29C49E7")
         String getSCAddress() {
            String varB4EAC82CA7396A68D541C85D26508E83_393980696 = null; //Variable for return #1
            int len;
            String ret;
            len = getByte();
            {
                ret = null;
            } //End block
            {
                try 
                {
                    ret = PhoneNumberUtils
                            .calledPartyBCDToString(pdu, cur, len);
                } //End block
                catch (RuntimeException tr)
                {
                    Log.d(LOG_TAG, "invalid SC address: ", tr);
                    ret = null;
                } //End block
            } //End block
            cur += len;
            varB4EAC82CA7396A68D541C85D26508E83_393980696 = ret;
            varB4EAC82CA7396A68D541C85D26508E83_393980696.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_393980696;
            // ---------- Original Method ----------
            //int len;
            //String ret;
            //len = getByte();
            //if (len == 0) {
                //ret = null;
            //} else {
                //try {
                    //ret = PhoneNumberUtils
                            //.calledPartyBCDToString(pdu, cur, len);
                //} catch (RuntimeException tr) {
                    //Log.d(LOG_TAG, "invalid SC address: ", tr);
                    //ret = null;
                //}
            //}
            //cur += len;
            //return ret;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.159 -0400", hash_original_method = "2F75C981EB64A28A85FF5D6FE13A88A1", hash_generated_method = "E667D3486AC558E8EE4A68A69F98287A")
         int getByte() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_985484097 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_985484097;
            // ---------- Original Method ----------
            //return pdu[cur++] & 0xff;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.177 -0400", hash_original_method = "F408E9DA0C4025DEBACF10CB13B7E7DC", hash_generated_method = "A3B27BB1E3508BE1045C2D68D202B001")
         GsmSmsAddress getAddress() {
            GsmSmsAddress varB4EAC82CA7396A68D541C85D26508E83_709104660 = null; //Variable for return #1
            GsmSmsAddress ret;
            int addressLength;
            addressLength = pdu[cur] & 0xff;
            int lengthBytes;
            lengthBytes = 2 + (addressLength + 1) / 2;
            ret = new GsmSmsAddress(pdu, cur, lengthBytes);
            cur += lengthBytes;
            varB4EAC82CA7396A68D541C85D26508E83_709104660 = ret;
            varB4EAC82CA7396A68D541C85D26508E83_709104660.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_709104660;
            // ---------- Original Method ----------
            //GsmSmsAddress ret;
            //int addressLength = pdu[cur] & 0xff;
            //int lengthBytes = 2 + (addressLength + 1) / 2;
            //ret = new GsmSmsAddress(pdu, cur, lengthBytes);
            //cur += lengthBytes;
            //return ret;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.179 -0400", hash_original_method = "E4DF9155D0C40868D52456F5AA0ADEBA", hash_generated_method = "B35A476A4632CE7C2AA37C4993DF6677")
         long getSCTimestampMillis() {
            int year;
            year = IccUtils.gsmBcdByteToInt(pdu[cur++]);
            int month;
            month = IccUtils.gsmBcdByteToInt(pdu[cur++]);
            int day;
            day = IccUtils.gsmBcdByteToInt(pdu[cur++]);
            int hour;
            hour = IccUtils.gsmBcdByteToInt(pdu[cur++]);
            int minute;
            minute = IccUtils.gsmBcdByteToInt(pdu[cur++]);
            int second;
            second = IccUtils.gsmBcdByteToInt(pdu[cur++]);
            byte tzByte;
            tzByte = pdu[cur++];
            int timezoneOffset;
            timezoneOffset = IccUtils.gsmBcdByteToInt((byte) (tzByte & (~0x08)));
            timezoneOffset = ((tzByte & 0x08) == 0) ? timezoneOffset : -timezoneOffset;
            Time time;
            time = new Time(Time.TIMEZONE_UTC);
            time.year = year >= 90 ? year + 1900 : year + 2000;
            time.month = month - 1;
            time.monthDay = day;
            time.hour = hour;
            time.minute = minute;
            time.second = second;
            long var71AE5F04DA1797F40C7D521CE4C928C9_1277429382 = (time.toMillis(true) - (timezoneOffset * 15 * 60 * 1000));
            long var0F5264038205EDFB1AC05FBB0E8C5E94_647501488 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_647501488;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.180 -0400", hash_original_method = "E0920414B78E3CE1FE70B99B68FA357A", hash_generated_method = "22670B31789FF34932D75DD8287C4EBD")
         int constructUserData(boolean hasUserDataHeader, boolean dataInSeptets) {
            int offset;
            offset = cur;
            int userDataLength;
            userDataLength = pdu[offset++] & 0xff;
            int headerSeptets;
            headerSeptets = 0;
            int userDataHeaderLength;
            userDataHeaderLength = 0;
            {
                userDataHeaderLength = pdu[offset++] & 0xff;
                byte[] udh;
                udh = new byte[userDataHeaderLength];
                System.arraycopy(pdu, offset, udh, 0, userDataHeaderLength);
                userDataHeader = SmsHeader.fromByteArray(udh);
                offset += userDataHeaderLength;
                int headerBits;
                headerBits = (userDataHeaderLength + 1) * 8;
                headerSeptets = headerBits / 7;
                headerSeptets += (headerBits % 7) > 0 ? 1 : 0;
                mUserDataSeptetPadding = (headerSeptets * 7) - headerBits;
            } //End block
            int bufferLen;
            {
                bufferLen = pdu.length - offset;
            } //End block
            {
                bufferLen = userDataLength - (hasUserDataHeader ? (userDataHeaderLength + 1) : 0);
                {
                    bufferLen = 0;
                } //End block
            } //End block
            userData = new byte[bufferLen];
            System.arraycopy(pdu, offset, userData, 0, userData.length);
            cur = offset;
            {
                int count;
                count = userDataLength - headerSeptets;
            } //End block
            addTaint(hasUserDataHeader);
            addTaint(dataInSeptets);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1183826459 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1183826459;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.180 -0400", hash_original_method = "832EF14448695517A54541076D502A0C", hash_generated_method = "14170222B6130C5DF58E240551BEE495")
         byte[] getUserData() {
            byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1923619455 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_1923619455;
            // ---------- Original Method ----------
            //return userData;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.180 -0400", hash_original_method = "904FFB9CBF6AC3FF663F8EA296F9CEA9", hash_generated_method = "8C13635EDE15EB695FFD04E65F1D2024")
         int getUserDataSeptetPadding() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1589359690 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1589359690;
            // ---------- Original Method ----------
            //return mUserDataSeptetPadding;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.181 -0400", hash_original_method = "4DA43BCCB17FE826B675411D64594E85", hash_generated_method = "1BC606C53607CF0FF6797EA7084CAFD5")
         SmsHeader getUserDataHeader() {
            SmsHeader varB4EAC82CA7396A68D541C85D26508E83_1114056087 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1114056087 = userDataHeader;
            varB4EAC82CA7396A68D541C85D26508E83_1114056087.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1114056087;
            // ---------- Original Method ----------
            //return userDataHeader;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.182 -0400", hash_original_method = "51731F422A9CB8603202E115B88733FC", hash_generated_method = "945D1A99AE34885AF79AF99185DDB78E")
         String getUserDataGSM7Bit(int septetCount, int languageTable,
                int languageShiftTable) {
            String varB4EAC82CA7396A68D541C85D26508E83_258060912 = null; //Variable for return #1
            String ret;
            ret = GsmAlphabet.gsm7BitPackedToString(pdu, cur, septetCount,
                    mUserDataSeptetPadding, languageTable, languageShiftTable);
            cur += (septetCount * 7) / 8;
            varB4EAC82CA7396A68D541C85D26508E83_258060912 = ret;
            addTaint(languageTable);
            addTaint(languageShiftTable);
            varB4EAC82CA7396A68D541C85D26508E83_258060912.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_258060912;
            // ---------- Original Method ----------
            //String ret;
            //ret = GsmAlphabet.gsm7BitPackedToString(pdu, cur, septetCount,
                    //mUserDataSeptetPadding, languageTable, languageShiftTable);
            //cur += (septetCount * 7) / 8;
            //return ret;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.182 -0400", hash_original_method = "97FC9E20E0F795CD7B2A52C595E2E8DE", hash_generated_method = "4F67EBF261A7FC78C072F5780B4D65F6")
         String getUserDataUCS2(int byteCount) {
            String varB4EAC82CA7396A68D541C85D26508E83_1835788119 = null; //Variable for return #1
            String ret;
            try 
            {
                ret = new String(pdu, cur, byteCount, "utf-16");
            } //End block
            catch (UnsupportedEncodingException ex)
            {
                ret = "";
            } //End block
            cur += byteCount;
            varB4EAC82CA7396A68D541C85D26508E83_1835788119 = ret;
            varB4EAC82CA7396A68D541C85D26508E83_1835788119.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1835788119;
            // ---------- Original Method ----------
            //String ret;
            //try {
                //ret = new String(pdu, cur, byteCount, "utf-16");
            //} catch (UnsupportedEncodingException ex) {
                //ret = "";
                //Log.e(LOG_TAG, "implausible UnsupportedEncodingException", ex);
            //}
            //cur += byteCount;
            //return ret;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.195 -0400", hash_original_method = "D8D8AF92C3889C36EC89CBE6C5FEE71F", hash_generated_method = "5059C98D96A98B7204FAECA227103461")
         String getUserDataKSC5601(int byteCount) {
            String varB4EAC82CA7396A68D541C85D26508E83_888165568 = null; //Variable for return #1
            String ret;
            try 
            {
                ret = new String(pdu, cur, byteCount, "KSC5601");
            } //End block
            catch (UnsupportedEncodingException ex)
            {
                ret = "";
            } //End block
            cur += byteCount;
            varB4EAC82CA7396A68D541C85D26508E83_888165568 = ret;
            varB4EAC82CA7396A68D541C85D26508E83_888165568.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_888165568;
            // ---------- Original Method ----------
            //String ret;
            //try {
                //ret = new String(pdu, cur, byteCount, "KSC5601");
            //} catch (UnsupportedEncodingException ex) {
                //ret = "";
                //Log.e(LOG_TAG, "implausible UnsupportedEncodingException", ex);
            //}
            //cur += byteCount;
            //return ret;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.195 -0400", hash_original_method = "AB0388E5C4230464C7FA98166E0C9557", hash_generated_method = "00567633D60B34A39A5664D3B243A493")
         boolean moreDataPresent() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1637756866 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1637756866;
            // ---------- Original Method ----------
            //return (pdu.length > cur);
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.195 -0400", hash_original_field = "41EBE7F32B96C1E2E9C209710486A443", hash_generated_field = "D3C0B237A982707BF0906F1B27E7321D")

    static String LOG_TAG = "GSM";
}

