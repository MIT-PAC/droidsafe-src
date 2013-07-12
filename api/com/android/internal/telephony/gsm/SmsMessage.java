package com.android.internal.telephony.gsm;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.824 -0400", hash_original_field = "D302E5EFB0B648FBA3A15C5F33DF9776", hash_generated_field = "7857416028EC39FBC0A39F3682AC483E")

    private MessageClass messageClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.824 -0400", hash_original_field = "19A04FAFB5F9DD7E606920C3ADACF8F0", hash_generated_field = "E7356B822A8D6EAF5A79AC5BFB93BA7C")

    private int mti;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.824 -0400", hash_original_field = "5B061E5E44867E47310F5788A9CC721F", hash_generated_field = "B1BC4F1F687666F5FB78306ED8E39C0D")

    private int protocolIdentifier;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.824 -0400", hash_original_field = "35CE477420B8D0FBD7AD0A0ED5C35EDB", hash_generated_field = "D845AB3694191CB4C3D298D5D655FF89")

    private int dataCodingScheme;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.824 -0400", hash_original_field = "3A4B1350CCFB9DDB78E5BC4724F25DAD", hash_generated_field = "5A5EDAAFEA15A0CAB3F6DE0AD07E40A4")

    private boolean replyPathPresent = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.824 -0400", hash_original_field = "FDFB42EA9B5FA1CC073BC11EE3632EAD", hash_generated_field = "AE8157ED2C11F4093644915D3F083BA5")

    private boolean automaticDeletion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.824 -0400", hash_original_field = "112EC8599C86EC7759EEB9B0F5A1A838", hash_generated_field = "C607017C2C44E60AAC44759C98F463E7")

    private boolean forSubmit;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.824 -0400", hash_original_field = "E0CBA49A23F21B04D743530E3F81F000", hash_generated_field = "6F3AA87D4A1136C3D307623CA6224439")

    private GsmSmsAddress recipientAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.824 -0400", hash_original_field = "6C085D4E8DE0E11E87CAEFF561247D33", hash_generated_field = "7F8B1302B10B9B6031593ECB5E2259BB")

    private long dischargeTimeMillis;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.824 -0400", hash_original_field = "9ACB44549B41563697BB490144EC6258", hash_generated_field = "4BAC49709EDEAEFDD9E07400E0F02406")

    private int status;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.824 -0400", hash_original_field = "9039A5255B50C39AE6EBC764E6B25AD1", hash_generated_field = "63317BD16A868FCF8316B9F91C279BC5")

    private boolean isStatusReportMessage = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.824 -0400", hash_original_method = "6C523C791261F68A00BC5A8339EB91FE", hash_generated_method = "6C523C791261F68A00BC5A8339EB91FE")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.825 -0400", hash_original_method = "AD0C1E28FA77467C1A6AC08BEE60D8C5", hash_generated_method = "63CE86C186A79B90FCB663F421F8E8C3")
    public boolean isTypeZero() {
        boolean varE398FDF7B25594026191CAEB46522C80_2043688760 = ((protocolIdentifier == 0x40));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_308776226 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_308776226;
        
        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.828 -0400", hash_original_method = "E7C032F027F70A1B6B025F651AAD0755", hash_generated_method = "BC12339B4A8EC8FC509DFFDE58C97F0D")
    @Override
    public int getProtocolIdentifier() {
        int var5B061E5E44867E47310F5788A9CC721F_2020400544 = (protocolIdentifier);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_294754022 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_294754022;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.828 -0400", hash_original_method = "5E449C3565950C318CBD3ECE2F1F0BD6", hash_generated_method = "370C8E83E696722D168489B011282D6F")
     int getDataCodingScheme() {
        int var35CE477420B8D0FBD7AD0A0ED5C35EDB_808031812 = (dataCodingScheme);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_5205339 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_5205339;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.829 -0400", hash_original_method = "BDE809523E280561E9C29F7B9A7C7DBF", hash_generated_method = "972EA6E2739ECB15C2106869E822B6F0")
    @Override
    public boolean isReplace() {
        boolean varC7659B8AB677650F7F77248FC673F893_1857619825 = ((protocolIdentifier & 0xc0) == 0x40
                && (protocolIdentifier & 0x3f) > 0
                && (protocolIdentifier & 0x3f) < 8);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_88994783 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_88994783;
        
        
                
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.829 -0400", hash_original_method = "8C882F4C280C6C8CC6957F303C6657A2", hash_generated_method = "A8D69D4A709212976DCFDFDF1DAFCBFC")
    @Override
    public boolean isCphsMwiMessage() {
        boolean var40E138E6A3F8A03467D2B2E059B0A3D7_844090605 = (((GsmSmsAddress) originatingAddress).isCphsVoiceMessageClear()
                || ((GsmSmsAddress) originatingAddress).isCphsVoiceMessageSet());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_86286936 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_86286936;
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.829 -0400", hash_original_method = "70DC4C6B18CE83A6EFAF90F534A37766", hash_generated_method = "CDC1A82CB6F832B54E5A831959CE5A3A")
    @Override
    public boolean isMWIClearMessage() {
    if(isMwi && !mwiSense)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1791072458 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_836687009 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_836687009;
        } 
        boolean varAA572F2A7D10033AD9A4503C143ECE4D_950481424 = (originatingAddress != null
                && ((GsmSmsAddress) originatingAddress).isCphsVoiceMessageClear());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_156120719 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_156120719;
        
        
            
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.830 -0400", hash_original_method = "29E72ED32BDC3692E9219EFE428EB222", hash_generated_method = "C618DE06F0DFD33D2F908A91FC8BC05B")
    @Override
    public boolean isMWISetMessage() {
    if(isMwi && mwiSense)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_407631042 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_850880646 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_850880646;
        } 
        boolean var15C11FCEC0DB1CB9543F3B06103D73DC_1283502673 = (originatingAddress != null
                && ((GsmSmsAddress) originatingAddress).isCphsVoiceMessageSet());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1118097120 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1118097120;
        
        
            
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.830 -0400", hash_original_method = "06DE61C568026EFDCDFB983D9CE6FFEE", hash_generated_method = "C0AD485F54FBD627A75718C8FE5BD311")
    @Override
    public boolean isMwiDontStore() {
    if(isMwi && mwiDontStore)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1025610627 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_572886990 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_572886990;
        } 
    if(isCphsMwiMessage())        
        {
    if(" ".equals(getMessageBody()))            
            {
                ;
            } 
            boolean varB326B5062B2F0E69046810717534CB09_159984289 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_293994401 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_293994401;
        } 
        boolean var68934A3E9455FA72420237EB05902327_718820581 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_687504283 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_687504283;
        
        
            
        
        
            
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.830 -0400", hash_original_method = "A6874122EB6D2A9BF852845259D73D4C", hash_generated_method = "67DCFC2120A0C0059C16921A9C92ADBD")
    @Override
    public int getStatus() {
        int var9ACB44549B41563697BB490144EC6258_308684620 = (status);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_322883418 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_322883418;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.831 -0400", hash_original_method = "234314E66EB58BCF2E45191C1F3D0599", hash_generated_method = "90D5113B2AF9C327838282BC3D7CA51F")
    @Override
    public boolean isStatusReportMessage() {
        boolean var79E9C87C1BFC5A2AC02530D22ADFC843_16491266 = (isStatusReportMessage);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1875605483 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1875605483;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.831 -0400", hash_original_method = "D49F3476E255463D6592CF4849CB4273", hash_generated_method = "7826CC90AC511A31B467647364CFAF66")
    @Override
    public boolean isReplyPathPresent() {
        boolean varE1393A5BDA7AA4799DCD65FD40656440_420279653 = (replyPathPresent);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_836356882 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_836356882;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.831 -0400", hash_original_method = "AF62799239B28F1660277ADF3CA55E81", hash_generated_method = "19BD04CFD70B8F3F97752718816B7340")
    private void parsePdu(byte[] pdu) {
        addTaint(pdu[0]);
        mPdu = pdu;
        PduParser p = new PduParser(pdu);
        scAddress = p.getSCAddress();
    if(scAddress != null)        
        {
    if(false)            
            Log.d(LOG_TAG, "SMS SC address: " + scAddress);
        } 
        int firstByte = p.getByte();
        mti = firstByte & 0x3;
switch(mti){
        case 0:
        case 3:
        parseSmsDeliver(p, firstByte);
        break;
        case 2:
        parseSmsStatusReport(p, firstByte);
        break;
        default:
        RuntimeException var7567D76CA17DAF91247FA01B6447F360_1833371696 = new RuntimeException("Unsupported message type");
        var7567D76CA17DAF91247FA01B6447F360_1833371696.addTaint(taint);
        throw var7567D76CA17DAF91247FA01B6447F360_1833371696;
}
        
        
        
        
        
            
        
        
        
        
        
        
            
            
        
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.833 -0400", hash_original_method = "A70831539166366B9681E2ACC95982AC", hash_generated_method = "FB47605E7932C2AB133FE724A70DCC4A")
    private void parseSmsStatusReport(PduParser p, int firstByte) {
        isStatusReportMessage = true;
        forSubmit = (firstByte & 0x20) == 0x00;
        messageRef = p.getByte();
        recipientAddress = p.getAddress();
        scTimeMillis = p.getSCTimestampMillis();
        dischargeTimeMillis = p.getSCTimestampMillis();
        status = p.getByte();
    if(p.moreDataPresent())        
        {
            int extraParams = p.getByte();
            int moreExtraParams = extraParams;
            while
((moreExtraParams & 0x80) != 0)            
            {
                moreExtraParams = p.getByte();
            } 
    if((extraParams & 0x01) != 0)            
            {
                protocolIdentifier = p.getByte();
            } 
    if((extraParams & 0x02) != 0)            
            {
                dataCodingScheme = p.getByte();
            } 
    if((extraParams & 0x04) != 0)            
            {
                boolean hasUserDataHeader = (firstByte & 0x40) == 0x40;
                parseUserData(p, hasUserDataHeader);
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.834 -0400", hash_original_method = "7E3F60FEC92AD175AC8D63C56FC781E1", hash_generated_method = "B5350F1A0F300B75C28B617699B873BD")
    private void parseSmsDeliver(PduParser p, int firstByte) {
        replyPathPresent = (firstByte & 0x80) == 0x80;
        originatingAddress = p.getAddress();
    if(originatingAddress != null)        
        {
    if(false){ }
        } 
        protocolIdentifier = p.getByte();
        dataCodingScheme = p.getByte();
    if(false)        
        {
        } 
        scTimeMillis = p.getSCTimestampMillis();
    if(false)        
        Log.d(LOG_TAG, "SMS SC timestamp: " + scTimeMillis);
        boolean hasUserDataHeader = (firstByte & 0x40) == 0x40;
        parseUserData(p, hasUserDataHeader);
        
        
        
        
            
                    
        
        
        
        
            
                    
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.838 -0400", hash_original_method = "445BCC4CA8B8EE2EB716CA993346CBBC", hash_generated_method = "572833D8D3A8D25E320AC4E7873D0F00")
    private void parseUserData(PduParser p, boolean hasUserDataHeader) {
        addTaint(hasUserDataHeader);
        addTaint(p.getTaint());
        boolean hasMessageClass = false;
        boolean userDataCompressed = false;
        int encodingType = ENCODING_UNKNOWN;
    if((dataCodingScheme & 0x80) == 0)        
        {
            automaticDeletion = (0 != (dataCodingScheme & 0x40));
            userDataCompressed = (0 != (dataCodingScheme & 0x20));
            hasMessageClass = (0 != (dataCodingScheme & 0x10));
    if(userDataCompressed)            
            {
            } 
            else
            {
switch((dataCodingScheme >> 2) & 0x3){
                case 0:
                encodingType = ENCODING_7BIT;
                break;
                case 2:
                encodingType = ENCODING_16BIT;
                break;
                case 1:
                case 3:
                encodingType = ENCODING_8BIT;
                break;
}
            } 
        } 
        else
    if((dataCodingScheme & 0xf0) == 0xf0)        
        {
            automaticDeletion = false;
            hasMessageClass = true;
            userDataCompressed = false;
    if(0 == (dataCodingScheme & 0x04))            
            {
                encodingType = ENCODING_7BIT;
            } 
            else
            {
                encodingType = ENCODING_8BIT;
            } 
        } 
        else
    if((dataCodingScheme & 0xF0) == 0xC0
                || (dataCodingScheme & 0xF0) == 0xD0
                || (dataCodingScheme & 0xF0) == 0xE0)        
        {
    if((dataCodingScheme & 0xF0) == 0xE0)            
            {
                encodingType = ENCODING_16BIT;
            } 
            else
            {
                encodingType = ENCODING_7BIT;
            } 
            userDataCompressed = false;
            boolean active = ((dataCodingScheme & 0x08) == 0x08);
    if((dataCodingScheme & 0x03) == 0x00)            
            {
                isMwi = true;
                mwiSense = active;
                mwiDontStore = ((dataCodingScheme & 0xF0) == 0xC0);
            } 
            else
            {
                isMwi = false;
            } 
        } 
        else
    if((dataCodingScheme & 0xC0) == 0x80)        
        {
    if(dataCodingScheme == 0x84)            
            {
                encodingType = ENCODING_KSC5601;
            } 
            else
            {
            } 
        } 
        else
        {
        } 
        int count = p.constructUserData(hasUserDataHeader,
                encodingType == ENCODING_7BIT);
        this.userData = p.getUserData();
        this.userDataHeader = p.getUserDataHeader();
switch(encodingType){
        case ENCODING_UNKNOWN:
        case ENCODING_8BIT:
        messageBody = null;
        break;
        case ENCODING_7BIT:
        messageBody = p.getUserDataGSM7Bit(count,
                    hasUserDataHeader ? userDataHeader.languageTable : 0,
                    hasUserDataHeader ? userDataHeader.languageShiftTable : 0);
        break;
        case ENCODING_16BIT:
        messageBody = p.getUserDataUCS2(count);
        break;
        case ENCODING_KSC5601:
        messageBody = p.getUserDataKSC5601(count);
        break;
}    if(false){ }    if(messageBody != null)        
        {
            parseMessageBody();
        } 
    if(!hasMessageClass)        
        {
            messageClass = MessageClass.UNKNOWN;
        } 
        else
        {
switch(dataCodingScheme & 0x3){
            case 0:
            messageClass = MessageClass.CLASS_0;
            break;
            case 1:
            messageClass = MessageClass.CLASS_1;
            break;
            case 2:
            messageClass = MessageClass.CLASS_2;
            break;
            case 3:
            messageClass = MessageClass.CLASS_3;
            break;
}
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.839 -0400", hash_original_method = "A363CB6F91B76BEA5906C381D551632B", hash_generated_method = "101FA996EC2B31E15B4BD0A337D0AF84")
    @Override
    public MessageClass getMessageClass() {
MessageClass varBFA743AA68FAB2987074675DD944EFDD_489327473 =         messageClass;
        varBFA743AA68FAB2987074675DD944EFDD_489327473.addTaint(taint);
        return varBFA743AA68FAB2987074675DD944EFDD_489327473;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.839 -0400", hash_original_method = "E16A5CBE2AF5641D1FC19A09E4EADBC9", hash_generated_method = "C8FC91A64AEB2A9E2F904EF4678EF6A6")
     boolean isUsimDataDownload() {
        boolean var23C721EBDC542947E3AE5B4A94E882EB_1381887165 = (messageClass == MessageClass.CLASS_2 &&
                (protocolIdentifier == 0x7f || protocolIdentifier == 0x7c));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_708070945 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_708070945;
        
        
                
    }

    
    public static class SubmitPdu extends SubmitPduBase {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.840 -0400", hash_original_method = "0DF27C295EE94AE1A62B7F3B1FD6EBC8", hash_generated_method = "0DF27C295EE94AE1A62B7F3B1FD6EBC8")
        public SubmitPdu ()
        {
            
        }


    }


    
    private static class PduParser {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.840 -0400", hash_original_field = "5645D4C4B415EFD5ECD9CF6111004AD6", hash_generated_field = "19D13A40BDDB2C7F8CD159EA0077CC93")

        byte pdu[];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.840 -0400", hash_original_field = "B5FDDF1EF601E74DB01C1425561A38CB", hash_generated_field = "2F4877CE6BA21232C2B8D66924B60128")

        int cur;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.840 -0400", hash_original_field = "743D61CD0F8B499FFB5961C09D48393C", hash_generated_field = "532180B80C80AE52803AEB5499571541")

        SmsHeader userDataHeader;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.840 -0400", hash_original_field = "56491F2E1C74898E18BB6E47D2425B19", hash_generated_field = "A84FAC4EE7B4249A85AFD54238EB3F78")

        byte[] userData;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.840 -0400", hash_original_field = "6944462409EAAFC73113C0FD4675221D", hash_generated_field = "E1D52F93D65AFF05A56D0C19482CCBAC")

        int mUserDataSeptetPadding;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.840 -0400", hash_original_field = "8DCFA4D4E6C8EBBFB5F773290A97E452", hash_generated_field = "DDFAE6B21F6F82F78AE1E9B94A4CE136")

        int mUserDataSize;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.840 -0400", hash_original_method = "A42B16D029D2C7C381F18291645B39B4", hash_generated_method = "8DA570D5AC0F18CEA4B2613348B62A55")
          PduParser(byte[] pdu) {
            this.pdu = pdu;
            cur = 0;
            mUserDataSeptetPadding = 0;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.842 -0400", hash_original_method = "99E23657D695EA8C595E80B24F474921", hash_generated_method = "BA92189DB05F85A223983BDC51DF9D1F")
         String getSCAddress() {
            int len;
            String ret;
            len = getByte();
    if(len == 0)            
            {
                ret = null;
            } 
            else
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
String varEDFF4FBBF053B5DC2B444ADFA049EE0F_717896580 =             ret;
            varEDFF4FBBF053B5DC2B444ADFA049EE0F_717896580.addTaint(taint);
            return varEDFF4FBBF053B5DC2B444ADFA049EE0F_717896580;
            
            
            
            
            
                
            
                
                    
                            
                
                    
                    
                
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.843 -0400", hash_original_method = "2F75C981EB64A28A85FF5D6FE13A88A1", hash_generated_method = "60E5346EB90F6354D1BC2ED16A12CEE4")
         int getByte() {
            int varDAABF7463F2146A31643F60EA25A58D8_236423169 = (pdu[cur++] & 0xff);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_632787038 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_632787038;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.843 -0400", hash_original_method = "F408E9DA0C4025DEBACF10CB13B7E7DC", hash_generated_method = "9E2DBF3F6DC66C85FE25E3DA82FE3D55")
         GsmSmsAddress getAddress() {
            GsmSmsAddress ret;
            int addressLength = pdu[cur] & 0xff;
            int lengthBytes = 2 + (addressLength + 1) / 2;
            ret = new GsmSmsAddress(pdu, cur, lengthBytes);
            cur += lengthBytes;
GsmSmsAddress varEDFF4FBBF053B5DC2B444ADFA049EE0F_1433282097 =             ret;
            varEDFF4FBBF053B5DC2B444ADFA049EE0F_1433282097.addTaint(taint);
            return varEDFF4FBBF053B5DC2B444ADFA049EE0F_1433282097;
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.845 -0400", hash_original_method = "E4DF9155D0C40868D52456F5AA0ADEBA", hash_generated_method = "0317061EC653B46E125E89727AB2D9F2")
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
            long var0A927EC1B7310609F86ED50E0FB04F4E_2095576813 = (time.toMillis(true) - (timezoneOffset * 15 * 60 * 1000));
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1708248192 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1708248192;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.846 -0400", hash_original_method = "E0920414B78E3CE1FE70B99B68FA357A", hash_generated_method = "97217BA20E2E872B1B1F9F6854999B96")
         int constructUserData(boolean hasUserDataHeader, boolean dataInSeptets) {
            addTaint(dataInSeptets);
            addTaint(hasUserDataHeader);
            int offset = cur;
            int userDataLength = pdu[offset++] & 0xff;
            int headerSeptets = 0;
            int userDataHeaderLength = 0;
    if(hasUserDataHeader)            
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
    if(dataInSeptets)            
            {
                bufferLen = pdu.length - offset;
            } 
            else
            {
                bufferLen = userDataLength - (hasUserDataHeader ? (userDataHeaderLength + 1) : 0);
    if(bufferLen < 0)                
                {
                    bufferLen = 0;
                } 
            } 
            userData = new byte[bufferLen];
            System.arraycopy(pdu, offset, userData, 0, userData.length);
            cur = offset;
    if(dataInSeptets)            
            {
                int count = userDataLength - headerSeptets;
                int var9D1760F9267B99678124D70ACA249997_1431536438 = (count < 0 ? 0 : count);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_75375187 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_75375187;
            } 
            else
            {
                int var5A4BAF89A5097BF56A4AC462BE1B9588_869802645 = (userData.length);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2107423313 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2107423313;
            } 
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.847 -0400", hash_original_method = "832EF14448695517A54541076D502A0C", hash_generated_method = "09DF07B34D919BD59BDA7B3C146EB2E6")
         byte[] getUserData() {
            byte[] var56491F2E1C74898E18BB6E47D2425B19_1720299867 = (userData);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_91539819 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_91539819;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.847 -0400", hash_original_method = "904FFB9CBF6AC3FF663F8EA296F9CEA9", hash_generated_method = "46A6852CEFE15B49DA845161462477F2")
         int getUserDataSeptetPadding() {
            int var6944462409EAAFC73113C0FD4675221D_949408396 = (mUserDataSeptetPadding);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1960629536 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1960629536;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.847 -0400", hash_original_method = "4DA43BCCB17FE826B675411D64594E85", hash_generated_method = "2726852895F68DC982227706A01F40AE")
         SmsHeader getUserDataHeader() {
SmsHeader varC667C99DB117EC88666F8C8FC671A339_1425059241 =             userDataHeader;
            varC667C99DB117EC88666F8C8FC671A339_1425059241.addTaint(taint);
            return varC667C99DB117EC88666F8C8FC671A339_1425059241;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.847 -0400", hash_original_method = "51731F422A9CB8603202E115B88733FC", hash_generated_method = "EAF11CB7508001473EB5540C78D1D09C")
         String getUserDataGSM7Bit(int septetCount, int languageTable,
                int languageShiftTable) {
            addTaint(languageShiftTable);
            addTaint(languageTable);
            String ret;
            ret = GsmAlphabet.gsm7BitPackedToString(pdu, cur, septetCount,
                    mUserDataSeptetPadding, languageTable, languageShiftTable);
            cur += (septetCount * 7) / 8;
String varEDFF4FBBF053B5DC2B444ADFA049EE0F_2040948979 =             ret;
            varEDFF4FBBF053B5DC2B444ADFA049EE0F_2040948979.addTaint(taint);
            return varEDFF4FBBF053B5DC2B444ADFA049EE0F_2040948979;
            
            
            
                    
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.847 -0400", hash_original_method = "97FC9E20E0F795CD7B2A52C595E2E8DE", hash_generated_method = "CF0A6BDB02CC18D306B26C3D2F04B83A")
         String getUserDataUCS2(int byteCount) {
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
String varEDFF4FBBF053B5DC2B444ADFA049EE0F_1544747688 =             ret;
            varEDFF4FBBF053B5DC2B444ADFA049EE0F_1544747688.addTaint(taint);
            return varEDFF4FBBF053B5DC2B444ADFA049EE0F_1544747688;
            
            
            
                
            
                
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.848 -0400", hash_original_method = "D8D8AF92C3889C36EC89CBE6C5FEE71F", hash_generated_method = "29E530EC7ECD12826F93D8B76F163031")
         String getUserDataKSC5601(int byteCount) {
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
String varEDFF4FBBF053B5DC2B444ADFA049EE0F_1140342447 =             ret;
            varEDFF4FBBF053B5DC2B444ADFA049EE0F_1140342447.addTaint(taint);
            return varEDFF4FBBF053B5DC2B444ADFA049EE0F_1140342447;
            
            
            
                
            
                
                
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.848 -0400", hash_original_method = "AB0388E5C4230464C7FA98166E0C9557", hash_generated_method = "C3F9E79E938BF5A2C5D53A2ED0002561")
         boolean moreDataPresent() {
            boolean varB30B76D69E77C4C4884D1A5B07F0584E_2027594981 = ((pdu.length > cur));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_375195739 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_375195739;
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.848 -0400", hash_original_field = "41EBE7F32B96C1E2E9C209710486A443", hash_generated_field = "B8386CD6D900777C9D6A0A5CA1D0B217")

    static final String LOG_TAG = "GSM";
}

