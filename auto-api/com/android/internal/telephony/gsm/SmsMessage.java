package com.android.internal.telephony.gsm;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.699 -0400", hash_original_field = "D302E5EFB0B648FBA3A15C5F33DF9776", hash_generated_field = "7857416028EC39FBC0A39F3682AC483E")

    private MessageClass messageClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.699 -0400", hash_original_field = "19A04FAFB5F9DD7E606920C3ADACF8F0", hash_generated_field = "E7356B822A8D6EAF5A79AC5BFB93BA7C")

    private int mti;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.699 -0400", hash_original_field = "5B061E5E44867E47310F5788A9CC721F", hash_generated_field = "B1BC4F1F687666F5FB78306ED8E39C0D")

    private int protocolIdentifier;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.699 -0400", hash_original_field = "35CE477420B8D0FBD7AD0A0ED5C35EDB", hash_generated_field = "D845AB3694191CB4C3D298D5D655FF89")

    private int dataCodingScheme;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.699 -0400", hash_original_field = "3A4B1350CCFB9DDB78E5BC4724F25DAD", hash_generated_field = "5A5EDAAFEA15A0CAB3F6DE0AD07E40A4")

    private boolean replyPathPresent = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.699 -0400", hash_original_field = "FDFB42EA9B5FA1CC073BC11EE3632EAD", hash_generated_field = "AE8157ED2C11F4093644915D3F083BA5")

    private boolean automaticDeletion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.699 -0400", hash_original_field = "112EC8599C86EC7759EEB9B0F5A1A838", hash_generated_field = "C607017C2C44E60AAC44759C98F463E7")

    private boolean forSubmit;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.699 -0400", hash_original_field = "E0CBA49A23F21B04D743530E3F81F000", hash_generated_field = "6F3AA87D4A1136C3D307623CA6224439")

    private GsmSmsAddress recipientAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.699 -0400", hash_original_field = "6C085D4E8DE0E11E87CAEFF561247D33", hash_generated_field = "7F8B1302B10B9B6031593ECB5E2259BB")

    private long dischargeTimeMillis;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.699 -0400", hash_original_field = "9ACB44549B41563697BB490144EC6258", hash_generated_field = "4BAC49709EDEAEFDD9E07400E0F02406")

    private int status;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.699 -0400", hash_original_field = "9039A5255B50C39AE6EBC764E6B25AD1", hash_generated_field = "63317BD16A868FCF8316B9F91C279BC5")

    private boolean isStatusReportMessage = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.699 -0400", hash_original_method = "6C523C791261F68A00BC5A8339EB91FE", hash_generated_method = "6C523C791261F68A00BC5A8339EB91FE")
    public SmsMessage ()
    {
        
    }


    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.700 -0400", hash_original_method = "AD0C1E28FA77467C1A6AC08BEE60D8C5", hash_generated_method = "F37658F54A103429D7C987918BE76D05")
    public boolean isTypeZero() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1138046072 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1138046072;
        
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static int getTPLayerLengthForPDU(String pdu) {
        int len = pdu.length() / 2;
        int smscLen = Integer.parseInt(pdu.substring(0, 2), 16);
        return len - smscLen - 1;
    }

    
    @DSModeled(DSC.SAFE)
    public static SubmitPdu getSubmitPdu(String scAddress,
            String destinationAddress, String message,
            boolean statusReportRequested, byte[] header) {
        return getSubmitPdu(scAddress, destinationAddress, message, statusReportRequested, header,
                ENCODING_UNKNOWN, 0, 0);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static SubmitPdu getSubmitPdu(String scAddress,
            String destinationAddress, String message,
            boolean statusReportRequested) {
        return getSubmitPdu(scAddress, destinationAddress, message, statusReportRequested, null);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.749 -0400", hash_original_method = "E7C032F027F70A1B6B025F651AAD0755", hash_generated_method = "33FE9098E574D80380AC1A3CD25DBBB4")
    @Override
    public int getProtocolIdentifier() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_985978179 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_985978179;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.751 -0400", hash_original_method = "5E449C3565950C318CBD3ECE2F1F0BD6", hash_generated_method = "D44AB16D4C6378B14F0987C33AFAD78C")
     int getDataCodingScheme() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1933948078 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1933948078;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.753 -0400", hash_original_method = "BDE809523E280561E9C29F7B9A7C7DBF", hash_generated_method = "5B8AC074F0F276A4C63CAB58E5346158")
    @Override
    public boolean isReplace() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_432053965 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_432053965;
        
        
                
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.754 -0400", hash_original_method = "8C882F4C280C6C8CC6957F303C6657A2", hash_generated_method = "D91A12B82F23652891829FE56450D91D")
    @Override
    public boolean isCphsMwiMessage() {
        boolean var0064C8543CFB04FA8B8C5337C3D73C6E_1222013784 = (((GsmSmsAddress) originatingAddress).isCphsVoiceMessageClear()
                || ((GsmSmsAddress) originatingAddress).isCphsVoiceMessageSet());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_796594987 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_796594987;
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.755 -0400", hash_original_method = "70DC4C6B18CE83A6EFAF90F534A37766", hash_generated_method = "7EF4BA3A040C6E9DF2EDD54BEC0B1AA0")
    @Override
    public boolean isMWIClearMessage() {
        boolean var5B99184308D7B96B7C766273527E2F51_1953642594 = (originatingAddress != null
                && ((GsmSmsAddress) originatingAddress).isCphsVoiceMessageClear());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2121415108 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2121415108;
        
        
            
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.757 -0400", hash_original_method = "29E72ED32BDC3692E9219EFE428EB222", hash_generated_method = "44C62A2BAA8D0F96CB5A3D6027145AB1")
    @Override
    public boolean isMWISetMessage() {
        boolean var0009BB8C429D24589ED9599970648826_96448941 = (originatingAddress != null
                && ((GsmSmsAddress) originatingAddress).isCphsVoiceMessageSet());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_657096932 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_657096932;
        
        
            
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.758 -0400", hash_original_method = "06DE61C568026EFDCDFB983D9CE6FFEE", hash_generated_method = "6F247CB69C6FC53C32ECC166D612DFDD")
    @Override
    public boolean isMwiDontStore() {
        {
            boolean var99DBAC6B8998FB78C7361CC808533243_1419784668 = (isCphsMwiMessage());
            {
                {
                    boolean varBE63956A4C4D7FD446688CEDCE89BD02_1521307530 = (" ".equals(getMessageBody()));
                    {
                        ;
                    } 
                } 
            } 
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1228562667 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1228562667;
        
        
            
        
        
            
                
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.760 -0400", hash_original_method = "A6874122EB6D2A9BF852845259D73D4C", hash_generated_method = "F5C02084D08D60B65F100BAD1676855A")
    @Override
    public int getStatus() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1946534190 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1946534190;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.762 -0400", hash_original_method = "234314E66EB58BCF2E45191C1F3D0599", hash_generated_method = "9A08D11394F1B7AA1A8E41FF8032ABBB")
    @Override
    public boolean isStatusReportMessage() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_854550859 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_854550859;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.766 -0400", hash_original_method = "D49F3476E255463D6592CF4849CB4273", hash_generated_method = "A3F7DABF9E92B094D6485C6BD4803720")
    @Override
    public boolean isReplyPathPresent() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_81912800 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_81912800;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.769 -0400", hash_original_method = "AF62799239B28F1660277ADF3CA55E81", hash_generated_method = "DDCDB82AC770C8E4454F58C61DA85807")
    private void parsePdu(byte[] pdu) {
        mPdu = pdu;
        PduParser p = new PduParser(pdu);
        scAddress = p.getSCAddress();
        {
            Log.d(LOG_TAG, "SMS SC address: " + scAddress);
        } 
        int firstByte = p.getByte();
        mti = firstByte & 0x3;
        
        parseSmsDeliver(p, firstByte);
        
        
        parseSmsStatusReport(p, firstByte);
        
        
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Unsupported message type");
        
        addTaint(pdu[0]);
        
        
        
        
        
            
        
        
        
        
        
        
            
            
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.773 -0400", hash_original_method = "A70831539166366B9681E2ACC95982AC", hash_generated_method = "984DC2F5FB85C538253CA9A3E3604EA6")
    private void parseSmsStatusReport(PduParser p, int firstByte) {
        isStatusReportMessage = true;
        forSubmit = (firstByte & 0x20) == 0x00;
        messageRef = p.getByte();
        recipientAddress = p.getAddress();
        scTimeMillis = p.getSCTimestampMillis();
        dischargeTimeMillis = p.getSCTimestampMillis();
        status = p.getByte();
        {
            boolean varB6E943617D844E0DA7DE4A065AB8CE61_1448690023 = (p.moreDataPresent());
            {
                int extraParams = p.getByte();
                int moreExtraParams = extraParams;
                {
                    moreExtraParams = p.getByte();
                } 
                {
                    protocolIdentifier = p.getByte();
                } 
                {
                    dataCodingScheme = p.getByte();
                } 
                {
                    boolean hasUserDataHeader = (firstByte & 0x40) == 0x40;
                    parseUserData(p, hasUserDataHeader);
                } 
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.775 -0400", hash_original_method = "7E3F60FEC92AD175AC8D63C56FC781E1", hash_generated_method = "CFFABC77675C9E93D4012D250B5D5FB0")
    private void parseSmsDeliver(PduParser p, int firstByte) {
        replyPathPresent = (firstByte & 0x80) == 0x80;
        originatingAddress = p.getAddress();
        protocolIdentifier = p.getByte();
        dataCodingScheme = p.getByte();
        scTimeMillis = p.getSCTimestampMillis();
        Log.d(LOG_TAG, "SMS SC timestamp: " + scTimeMillis);
        boolean hasUserDataHeader = (firstByte & 0x40) == 0x40;
        parseUserData(p, hasUserDataHeader);
        
        
        
        
            
                    
        
        
        
        
            
                    
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.778 -0400", hash_original_method = "445BCC4CA8B8EE2EB716CA993346CBBC", hash_generated_method = "5D4B3D9F51C7A1B2EB8856A93296283E")
    private void parseUserData(PduParser p, boolean hasUserDataHeader) {
        boolean hasMessageClass = false;
        boolean userDataCompressed = false;
        int encodingType = ENCODING_UNKNOWN;
        {
            automaticDeletion = (0 != (dataCodingScheme & 0x40));
            userDataCompressed = (0 != (dataCodingScheme & 0x20));
            hasMessageClass = (0 != (dataCodingScheme & 0x10));
            {
                
                encodingType = ENCODING_7BIT;
                
                
                encodingType = ENCODING_16BIT;
                
                
                encodingType = ENCODING_8BIT;
                
            } 
        } 
        {
            automaticDeletion = false;
            hasMessageClass = true;
            userDataCompressed = false;
            {
                encodingType = ENCODING_7BIT;
            } 
            {
                encodingType = ENCODING_8BIT;
            } 
        } 
        {
            {
                encodingType = ENCODING_16BIT;
            } 
            {
                encodingType = ENCODING_7BIT;
            } 
            userDataCompressed = false;
            boolean active = ((dataCodingScheme & 0x08) == 0x08);
            {
                isMwi = true;
                mwiSense = active;
                mwiDontStore = ((dataCodingScheme & 0xF0) == 0xC0);
            } 
            {
                isMwi = false;
            } 
        } 
        {
            {
                encodingType = ENCODING_KSC5601;
            } 
        } 
        int count = p.constructUserData(hasUserDataHeader,
                encodingType == ENCODING_7BIT);
        this.userData = p.getUserData();
        this.userDataHeader = p.getUserDataHeader();
        
        messageBody = null;
        
        
        messageBody = p.getUserDataGSM7Bit(count,
                    hasUserDataHeader ? userDataHeader.languageTable : 0,
                    hasUserDataHeader ? userDataHeader.languageShiftTable : 0);
        
        
        messageBody = p.getUserDataUCS2(count);
        
        
        messageBody = p.getUserDataKSC5601(count);
        
        {
            parseMessageBody();
        } 
        {
            messageClass = MessageClass.UNKNOWN;
        } 
        {
            
            messageClass = MessageClass.CLASS_0;
            
            
            messageClass = MessageClass.CLASS_1;
            
            
            messageClass = MessageClass.CLASS_2;
            
            
            messageClass = MessageClass.CLASS_3;
            
        } 
        addTaint(p.getTaint());
        addTaint(hasUserDataHeader);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.786 -0400", hash_original_method = "A363CB6F91B76BEA5906C381D551632B", hash_generated_method = "93E582C17194BB7D9BBA64C3AC8E2F40")
    @Override
    public MessageClass getMessageClass() {
        MessageClass varB4EAC82CA7396A68D541C85D26508E83_100784008 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_100784008 = messageClass;
        varB4EAC82CA7396A68D541C85D26508E83_100784008.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_100784008;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.788 -0400", hash_original_method = "E16A5CBE2AF5641D1FC19A09E4EADBC9", hash_generated_method = "4E12289723B2038FE5D6E7812A96ECE3")
     boolean isUsimDataDownload() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1001147643 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1001147643;
        
        
                
    }

    
    public static class SubmitPdu extends SubmitPduBase {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.788 -0400", hash_original_method = "0DF27C295EE94AE1A62B7F3B1FD6EBC8", hash_generated_method = "0DF27C295EE94AE1A62B7F3B1FD6EBC8")
        public SubmitPdu ()
        {
            
        }


    }


    
    private static class PduParser {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.788 -0400", hash_original_field = "5645D4C4B415EFD5ECD9CF6111004AD6", hash_generated_field = "19D13A40BDDB2C7F8CD159EA0077CC93")

        byte pdu[];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.788 -0400", hash_original_field = "B5FDDF1EF601E74DB01C1425561A38CB", hash_generated_field = "2F4877CE6BA21232C2B8D66924B60128")

        int cur;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.788 -0400", hash_original_field = "743D61CD0F8B499FFB5961C09D48393C", hash_generated_field = "532180B80C80AE52803AEB5499571541")

        SmsHeader userDataHeader;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.788 -0400", hash_original_field = "56491F2E1C74898E18BB6E47D2425B19", hash_generated_field = "A84FAC4EE7B4249A85AFD54238EB3F78")

        byte[] userData;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.788 -0400", hash_original_field = "6944462409EAAFC73113C0FD4675221D", hash_generated_field = "E1D52F93D65AFF05A56D0C19482CCBAC")

        int mUserDataSeptetPadding;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.788 -0400", hash_original_field = "8DCFA4D4E6C8EBBFB5F773290A97E452", hash_generated_field = "DDFAE6B21F6F82F78AE1E9B94A4CE136")

        int mUserDataSize;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.792 -0400", hash_original_method = "A42B16D029D2C7C381F18291645B39B4", hash_generated_method = "8DA570D5AC0F18CEA4B2613348B62A55")
          PduParser(byte[] pdu) {
            this.pdu = pdu;
            cur = 0;
            mUserDataSeptetPadding = 0;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.799 -0400", hash_original_method = "99E23657D695EA8C595E80B24F474921", hash_generated_method = "AF44DAF852B62E156F0D76F81AFAD056")
         String getSCAddress() {
            String varB4EAC82CA7396A68D541C85D26508E83_1506396358 = null; 
            int len;
            String ret;
            len = getByte();
            {
                ret = null;
            } 
            {
                try 
                {
                    ret = PhoneNumberUtils
                            .calledPartyBCDToString(pdu, cur, len);
                } 
                catch (RuntimeException tr)
                {
                    Log.d(LOG_TAG, "invalid SC address: ", tr);
                    ret = null;
                } 
            } 
            cur += len;
            varB4EAC82CA7396A68D541C85D26508E83_1506396358 = ret;
            varB4EAC82CA7396A68D541C85D26508E83_1506396358.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1506396358;
            
            
            
            
            
                
            
                
                    
                            
                
                    
                    
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.800 -0400", hash_original_method = "2F75C981EB64A28A85FF5D6FE13A88A1", hash_generated_method = "6983A6BD9AA3F14BD63F77D08E213846")
         int getByte() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_681690534 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_681690534;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.806 -0400", hash_original_method = "F408E9DA0C4025DEBACF10CB13B7E7DC", hash_generated_method = "5CC3C5F7F65213F613CD025222455195")
         GsmSmsAddress getAddress() {
            GsmSmsAddress varB4EAC82CA7396A68D541C85D26508E83_1050700894 = null; 
            GsmSmsAddress ret;
            int addressLength = pdu[cur] & 0xff;
            int lengthBytes = 2 + (addressLength + 1) / 2;
            ret = new GsmSmsAddress(pdu, cur, lengthBytes);
            cur += lengthBytes;
            varB4EAC82CA7396A68D541C85D26508E83_1050700894 = ret;
            varB4EAC82CA7396A68D541C85D26508E83_1050700894.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1050700894;
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.808 -0400", hash_original_method = "E4DF9155D0C40868D52456F5AA0ADEBA", hash_generated_method = "58232F1208929A44432E602903A02BDA")
         long getSCTimestampMillis() {
            int year = IccUtils.gsmBcdByteToInt(pdu[cur++]);
            int month = IccUtils.gsmBcdByteToInt(pdu[cur++]);
            int day = IccUtils.gsmBcdByteToInt(pdu[cur++]);
            int hour = IccUtils.gsmBcdByteToInt(pdu[cur++]);
            int minute = IccUtils.gsmBcdByteToInt(pdu[cur++]);
            int second = IccUtils.gsmBcdByteToInt(pdu[cur++]);
            byte tzByte = pdu[cur++];
            int timezoneOffset = IccUtils.gsmBcdByteToInt((byte) (tzByte & (~0x08)));
            timezoneOffset = ((tzByte & 0x08) == 0) ? timezoneOffset : -timezoneOffset;
            Time time = new Time(Time.TIMEZONE_UTC);
            time.year = year >= 90 ? year + 1900 : year + 2000;
            time.month = month - 1;
            time.monthDay = day;
            time.hour = hour;
            time.minute = minute;
            time.second = second;
            long var71AE5F04DA1797F40C7D521CE4C928C9_193231558 = (time.toMillis(true) - (timezoneOffset * 15 * 60 * 1000));
            long var0F5264038205EDFB1AC05FBB0E8C5E94_323004748 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_323004748;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.810 -0400", hash_original_method = "E0920414B78E3CE1FE70B99B68FA357A", hash_generated_method = "FDC3EB749949792A261116654562454D")
         int constructUserData(boolean hasUserDataHeader, boolean dataInSeptets) {
            int offset = cur;
            int userDataLength = pdu[offset++] & 0xff;
            int headerSeptets = 0;
            int userDataHeaderLength = 0;
            {
                userDataHeaderLength = pdu[offset++] & 0xff;
                byte[] udh = new byte[userDataHeaderLength];
                System.arraycopy(pdu, offset, udh, 0, userDataHeaderLength);
                userDataHeader = SmsHeader.fromByteArray(udh);
                offset += userDataHeaderLength;
                int headerBits = (userDataHeaderLength + 1) * 8;
                headerSeptets = headerBits / 7;
                headerSeptets += (headerBits % 7) > 0 ? 1 : 0;
                mUserDataSeptetPadding = (headerSeptets * 7) - headerBits;
            } 
            int bufferLen;
            {
                bufferLen = pdu.length - offset;
            } 
            {
                bufferLen = userDataLength - (hasUserDataHeader ? (userDataHeaderLength + 1) : 0);
                {
                    bufferLen = 0;
                } 
            } 
            userData = new byte[bufferLen];
            System.arraycopy(pdu, offset, userData, 0, userData.length);
            cur = offset;
            {
                int count = userDataLength - headerSeptets;
            } 
            addTaint(hasUserDataHeader);
            addTaint(dataInSeptets);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1954033252 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1954033252;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.812 -0400", hash_original_method = "832EF14448695517A54541076D502A0C", hash_generated_method = "2E09602893DBD1AE7E7559ABD4781AA2")
         byte[] getUserData() {
            byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_954720804 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_954720804;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.817 -0400", hash_original_method = "904FFB9CBF6AC3FF663F8EA296F9CEA9", hash_generated_method = "64376D6233313D3727C4F742E4CEF7E0")
         int getUserDataSeptetPadding() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_578988751 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_578988751;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.818 -0400", hash_original_method = "4DA43BCCB17FE826B675411D64594E85", hash_generated_method = "7BE720F5BDA007473A20862B1DB2E918")
         SmsHeader getUserDataHeader() {
            SmsHeader varB4EAC82CA7396A68D541C85D26508E83_1368014076 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1368014076 = userDataHeader;
            varB4EAC82CA7396A68D541C85D26508E83_1368014076.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1368014076;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.819 -0400", hash_original_method = "51731F422A9CB8603202E115B88733FC", hash_generated_method = "A0B91D03B6322050938D3202D94067EF")
         String getUserDataGSM7Bit(int septetCount, int languageTable,
                int languageShiftTable) {
            String varB4EAC82CA7396A68D541C85D26508E83_816098960 = null; 
            String ret;
            ret = GsmAlphabet.gsm7BitPackedToString(pdu, cur, septetCount,
                    mUserDataSeptetPadding, languageTable, languageShiftTable);
            cur += (septetCount * 7) / 8;
            varB4EAC82CA7396A68D541C85D26508E83_816098960 = ret;
            addTaint(languageTable);
            addTaint(languageShiftTable);
            varB4EAC82CA7396A68D541C85D26508E83_816098960.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_816098960;
            
            
            
                    
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.819 -0400", hash_original_method = "97FC9E20E0F795CD7B2A52C595E2E8DE", hash_generated_method = "952BC57ECEB7373EA834108AA8796E2C")
         String getUserDataUCS2(int byteCount) {
            String varB4EAC82CA7396A68D541C85D26508E83_211335528 = null; 
            String ret;
            try 
            {
                ret = new String(pdu, cur, byteCount, "utf-16");
            } 
            catch (UnsupportedEncodingException ex)
            {
                ret = "";
            } 
            cur += byteCount;
            varB4EAC82CA7396A68D541C85D26508E83_211335528 = ret;
            varB4EAC82CA7396A68D541C85D26508E83_211335528.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_211335528;
            
            
            
                
            
                
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.820 -0400", hash_original_method = "D8D8AF92C3889C36EC89CBE6C5FEE71F", hash_generated_method = "5F326F74AB4312B54FED1872170A908A")
         String getUserDataKSC5601(int byteCount) {
            String varB4EAC82CA7396A68D541C85D26508E83_1493337266 = null; 
            String ret;
            try 
            {
                ret = new String(pdu, cur, byteCount, "KSC5601");
            } 
            catch (UnsupportedEncodingException ex)
            {
                ret = "";
            } 
            cur += byteCount;
            varB4EAC82CA7396A68D541C85D26508E83_1493337266 = ret;
            varB4EAC82CA7396A68D541C85D26508E83_1493337266.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1493337266;
            
            
            
                
            
                
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.820 -0400", hash_original_method = "AB0388E5C4230464C7FA98166E0C9557", hash_generated_method = "AAD109259B855911CD466DC8B577B0CA")
         boolean moreDataPresent() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1255537480 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1255537480;
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.820 -0400", hash_original_field = "41EBE7F32B96C1E2E9C209710486A443", hash_generated_field = "B8386CD6D900777C9D6A0A5CA1D0B217")

    static final String LOG_TAG = "GSM";
}

