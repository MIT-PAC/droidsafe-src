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
    private MessageClass messageClass;
    private int mti;
    private int protocolIdentifier;
    private int dataCodingScheme;
    private boolean replyPathPresent = false;
    private boolean automaticDeletion;
    private boolean forSubmit;
    private GsmSmsAddress recipientAddress;
    private long dischargeTimeMillis;
    private int status;
    private boolean isStatusReportMessage = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.966 -0400", hash_original_method = "C72C4FDBCEC8D62FDBBCA2E507E59AB6", hash_generated_method = "C72C4FDBCEC8D62FDBBCA2E507E59AB6")
        public SmsMessage ()
    {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.967 -0400", hash_original_method = "AD0C1E28FA77467C1A6AC08BEE60D8C5", hash_generated_method = "BA706AEAB5D5E795EEB35310D95425C0")
    @DSModeled(DSC.SAFE)
    public boolean isTypeZero() {
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.969 -0400", hash_original_method = "E7C032F027F70A1B6B025F651AAD0755", hash_generated_method = "E5FAA911A5FA4CF04BBCF0892AAEC20A")
    @DSModeled(DSC.SAFE)
    @Override
    public int getProtocolIdentifier() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return protocolIdentifier;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.970 -0400", hash_original_method = "5E449C3565950C318CBD3ECE2F1F0BD6", hash_generated_method = "01533EEE1232A3BF9C23E5084BFB378F")
    @DSModeled(DSC.SAFE)
     int getDataCodingScheme() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return dataCodingScheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.970 -0400", hash_original_method = "BDE809523E280561E9C29F7B9A7C7DBF", hash_generated_method = "3DF28B4DCE5EC75FC55CE81F3571FAA7")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isReplace() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (protocolIdentifier & 0xc0) == 0x40
                //&& (protocolIdentifier & 0x3f) > 0
                //&& (protocolIdentifier & 0x3f) < 8;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.970 -0400", hash_original_method = "8C882F4C280C6C8CC6957F303C6657A2", hash_generated_method = "CE31070198E99D37F01563C53CF9A2FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isCphsMwiMessage() {
        boolean var0064C8543CFB04FA8B8C5337C3D73C6E_1661835666 = (((GsmSmsAddress) originatingAddress).isCphsVoiceMessageClear()
                || ((GsmSmsAddress) originatingAddress).isCphsVoiceMessageSet());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return ((GsmSmsAddress) originatingAddress).isCphsVoiceMessageClear()
                //|| ((GsmSmsAddress) originatingAddress).isCphsVoiceMessageSet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.970 -0400", hash_original_method = "70DC4C6B18CE83A6EFAF90F534A37766", hash_generated_method = "E16E9384D86FFD09F7421479BF609D59")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isMWIClearMessage() {
        boolean var5B99184308D7B96B7C766273527E2F51_1494158177 = (originatingAddress != null
                && ((GsmSmsAddress) originatingAddress).isCphsVoiceMessageClear());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (isMwi && !mwiSense) {
            //return true;
        //}
        //return originatingAddress != null
                //&& ((GsmSmsAddress) originatingAddress).isCphsVoiceMessageClear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.970 -0400", hash_original_method = "29E72ED32BDC3692E9219EFE428EB222", hash_generated_method = "82DD91A0E8513E36C182DBA81E42EB67")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isMWISetMessage() {
        boolean var0009BB8C429D24589ED9599970648826_1966772992 = (originatingAddress != null
                && ((GsmSmsAddress) originatingAddress).isCphsVoiceMessageSet());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (isMwi && mwiSense) {
            //return true;
        //}
        //return originatingAddress != null
                //&& ((GsmSmsAddress) originatingAddress).isCphsVoiceMessageSet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.971 -0400", hash_original_method = "06DE61C568026EFDCDFB983D9CE6FFEE", hash_generated_method = "0B45F66382BA0C2914D086E1150CF9FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isMwiDontStore() {
        {
            boolean var99DBAC6B8998FB78C7361CC808533243_1026186791 = (isCphsMwiMessage());
            {
                {
                    boolean varBE63956A4C4D7FD446688CEDCE89BD02_126752460 = (" ".equals(getMessageBody()));
                    {
                        ;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.971 -0400", hash_original_method = "A6874122EB6D2A9BF852845259D73D4C", hash_generated_method = "00292CD008B7B1B23A4CD363BCA2844D")
    @DSModeled(DSC.SAFE)
    @Override
    public int getStatus() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return status;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.971 -0400", hash_original_method = "234314E66EB58BCF2E45191C1F3D0599", hash_generated_method = "BB122D88010BAFCE967BF14E8129844E")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isStatusReportMessage() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isStatusReportMessage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.971 -0400", hash_original_method = "D49F3476E255463D6592CF4849CB4273", hash_generated_method = "496FA0B6AE8616BD89661926835CA944")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isReplyPathPresent() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return replyPathPresent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.972 -0400", hash_original_method = "AF62799239B28F1660277ADF3CA55E81", hash_generated_method = "26D172BBF99DEB4086AB3E1DE487CF0C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void parsePdu(byte[] pdu) {
        dsTaint.addTaint(pdu[0]);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.972 -0400", hash_original_method = "A70831539166366B9681E2ACC95982AC", hash_generated_method = "EDED4314FC515D62A7317DBBAE081A57")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void parseSmsStatusReport(PduParser p, int firstByte) {
        dsTaint.addTaint(firstByte);
        dsTaint.addTaint(p.dsTaint);
        isStatusReportMessage = true;
        forSubmit = (firstByte & 0x20) == 0x00;
        messageRef = p.getByte();
        recipientAddress = p.getAddress();
        scTimeMillis = p.getSCTimestampMillis();
        dischargeTimeMillis = p.getSCTimestampMillis();
        status = p.getByte();
        {
            boolean varB6E943617D844E0DA7DE4A065AB8CE61_139472010 = (p.moreDataPresent());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.973 -0400", hash_original_method = "7E3F60FEC92AD175AC8D63C56FC781E1", hash_generated_method = "854D3C7DE3F698B7B6F5CE2E6153A9E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void parseSmsDeliver(PduParser p, int firstByte) {
        dsTaint.addTaint(firstByte);
        dsTaint.addTaint(p.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.974 -0400", hash_original_method = "445BCC4CA8B8EE2EB716CA993346CBBC", hash_generated_method = "ACA96B5EF1C6458F81891BEDE107AB82")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void parseUserData(PduParser p, boolean hasUserDataHeader) {
        dsTaint.addTaint(hasUserDataHeader);
        dsTaint.addTaint(p.dsTaint);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.974 -0400", hash_original_method = "A363CB6F91B76BEA5906C381D551632B", hash_generated_method = "2032CD611D75FA1BF28A94F0A48D691D")
    @DSModeled(DSC.SAFE)
    @Override
    public MessageClass getMessageClass() {
        return (MessageClass)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return messageClass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.974 -0400", hash_original_method = "E16A5CBE2AF5641D1FC19A09E4EADBC9", hash_generated_method = "DA20DC3A98FA2D0374D761C4D128F146")
    @DSModeled(DSC.SAFE)
     boolean isUsimDataDownload() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return messageClass == MessageClass.CLASS_2 &&
                //(protocolIdentifier == 0x7f || protocolIdentifier == 0x7c);
    }

    
    public static class SubmitPdu extends SubmitPduBase {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.974 -0400", hash_original_method = "B7DE6E4B5E35E85E322148859309B318", hash_generated_method = "B7DE6E4B5E35E85E322148859309B318")
                public SubmitPdu ()
        {
        }


    }


    
    private static class PduParser {
        byte pdu[];
        int cur;
        SmsHeader userDataHeader;
        byte[] userData;
        int mUserDataSeptetPadding;
        int mUserDataSize;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.975 -0400", hash_original_method = "A42B16D029D2C7C381F18291645B39B4", hash_generated_method = "C18CBD6E7BCD5E10583D757403FC3166")
        @DSModeled(DSC.SAFE)
         PduParser(byte[] pdu) {
            dsTaint.addTaint(pdu[0]);
            this.pdu = pdu;
            cur = 0;
            mUserDataSeptetPadding = 0;
            // ---------- Original Method ----------
            //this.pdu = pdu;
            //cur = 0;
            //mUserDataSeptetPadding = 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.975 -0400", hash_original_method = "99E23657D695EA8C595E80B24F474921", hash_generated_method = "232FBB453AF5B739F511159F96DDC0D3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         String getSCAddress() {
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
            return dsTaint.getTaintString();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.975 -0400", hash_original_method = "2F75C981EB64A28A85FF5D6FE13A88A1", hash_generated_method = "849F69B85807D7A517B37E10C925E48C")
        @DSModeled(DSC.SAFE)
         int getByte() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return pdu[cur++] & 0xff;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.975 -0400", hash_original_method = "F408E9DA0C4025DEBACF10CB13B7E7DC", hash_generated_method = "C70096AA59EBFC7055803C93595E3E0A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         GsmSmsAddress getAddress() {
            GsmSmsAddress ret;
            int addressLength;
            addressLength = pdu[cur] & 0xff;
            int lengthBytes;
            lengthBytes = 2 + (addressLength + 1) / 2;
            ret = new GsmSmsAddress(pdu, cur, lengthBytes);
            cur += lengthBytes;
            return (GsmSmsAddress)dsTaint.getTaint();
            // ---------- Original Method ----------
            //GsmSmsAddress ret;
            //int addressLength = pdu[cur] & 0xff;
            //int lengthBytes = 2 + (addressLength + 1) / 2;
            //ret = new GsmSmsAddress(pdu, cur, lengthBytes);
            //cur += lengthBytes;
            //return ret;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.976 -0400", hash_original_method = "E4DF9155D0C40868D52456F5AA0ADEBA", hash_generated_method = "6F1EDC1F307B531D1EE3022339506FD3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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
            long var71AE5F04DA1797F40C7D521CE4C928C9_1228639162 = (time.toMillis(true) - (timezoneOffset * 15 * 60 * 1000));
            return dsTaint.getTaintLong();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.976 -0400", hash_original_method = "E0920414B78E3CE1FE70B99B68FA357A", hash_generated_method = "FB1BD70114ACF0496EE7E9FABF30E149")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         int constructUserData(boolean hasUserDataHeader, boolean dataInSeptets) {
            dsTaint.addTaint(dataInSeptets);
            dsTaint.addTaint(hasUserDataHeader);
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
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.977 -0400", hash_original_method = "832EF14448695517A54541076D502A0C", hash_generated_method = "83B1204E833D38979E57A4C2F147CE29")
        @DSModeled(DSC.SAFE)
         byte[] getUserData() {
            byte[] retVal = new byte[1];
            retVal[0] = (byte)dsTaint.getTaintInt();
            return retVal;
            // ---------- Original Method ----------
            //return userData;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.978 -0400", hash_original_method = "904FFB9CBF6AC3FF663F8EA296F9CEA9", hash_generated_method = "2BE125C17CF88DAD36F33B396C963D23")
        @DSModeled(DSC.SAFE)
         int getUserDataSeptetPadding() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mUserDataSeptetPadding;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.979 -0400", hash_original_method = "4DA43BCCB17FE826B675411D64594E85", hash_generated_method = "0043A92DCD2EE32C101BBEF88C712D29")
        @DSModeled(DSC.SAFE)
         SmsHeader getUserDataHeader() {
            return (SmsHeader)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return userDataHeader;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.979 -0400", hash_original_method = "51731F422A9CB8603202E115B88733FC", hash_generated_method = "89AC9FF55DA066A0191C1593341ACC63")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         String getUserDataGSM7Bit(int septetCount, int languageTable,
                int languageShiftTable) {
            dsTaint.addTaint(languageShiftTable);
            dsTaint.addTaint(septetCount);
            dsTaint.addTaint(languageTable);
            String ret;
            ret = GsmAlphabet.gsm7BitPackedToString(pdu, cur, septetCount,
                    mUserDataSeptetPadding, languageTable, languageShiftTable);
            cur += (septetCount * 7) / 8;
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //String ret;
            //ret = GsmAlphabet.gsm7BitPackedToString(pdu, cur, septetCount,
                    //mUserDataSeptetPadding, languageTable, languageShiftTable);
            //cur += (septetCount * 7) / 8;
            //return ret;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.979 -0400", hash_original_method = "97FC9E20E0F795CD7B2A52C595E2E8DE", hash_generated_method = "D95E64C2419F7268E89E46F2F71582E2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         String getUserDataUCS2(int byteCount) {
            dsTaint.addTaint(byteCount);
            String ret;
            try 
            {
                ret = new String(pdu, cur, byteCount, "utf-16");
            } //End block
            catch (UnsupportedEncodingException ex)
            {
                ret = "";
            } //End block
            return dsTaint.getTaintString();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.980 -0400", hash_original_method = "D8D8AF92C3889C36EC89CBE6C5FEE71F", hash_generated_method = "F12DCCE603DD9FA9F772C4AD15C6D1CE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         String getUserDataKSC5601(int byteCount) {
            dsTaint.addTaint(byteCount);
            String ret;
            try 
            {
                ret = new String(pdu, cur, byteCount, "KSC5601");
            } //End block
            catch (UnsupportedEncodingException ex)
            {
                ret = "";
            } //End block
            return dsTaint.getTaintString();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.981 -0400", hash_original_method = "AB0388E5C4230464C7FA98166E0C9557", hash_generated_method = "62E4FED6074B2DFA0FD2A226AF46515E")
        @DSModeled(DSC.SAFE)
         boolean moreDataPresent() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return (pdu.length > cur);
        }

        
    }


    
    static final String LOG_TAG = "GSM";
}

