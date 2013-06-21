package com.android.internal.telephony.cdma.sms;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import static android.telephony.SmsMessage.ENCODING_16BIT;
import static android.telephony.SmsMessage.MAX_USER_DATA_BYTES;
import static android.telephony.SmsMessage.MAX_USER_DATA_BYTES_WITH_HEADER;
import android.util.Log;
import android.telephony.SmsMessage;
import android.text.format.Time;
import com.android.internal.telephony.IccUtils;
import com.android.internal.telephony.GsmAlphabet;
import com.android.internal.telephony.SmsHeader;
import com.android.internal.telephony.SmsMessageBase.TextEncodingDetails;
import com.android.internal.util.BitwiseInputStream;
import com.android.internal.util.BitwiseOutputStream;
import android.content.res.Resources;
import java.util.TimeZone;

public final class BearerData {
    public int messageType;
    public int messageId;
    public boolean priorityIndicatorSet = false;
    public int priority = PRIORITY_NORMAL;
    public boolean privacyIndicatorSet = false;
    public int privacy = PRIVACY_NOT_RESTRICTED;
    public boolean alertIndicatorSet = false;
    public int alert = ALERT_DEFAULT;
    public boolean displayModeSet = false;
    public int displayMode = DISPLAY_MODE_DEFAULT;
    public boolean languageIndicatorSet = false;
    public int language = LANGUAGE_UNKNOWN;
    public boolean messageStatusSet = false;
    public int errorClass = ERROR_UNDEFINED;
    public int messageStatus = STATUS_UNDEFINED;
    public boolean hasUserDataHeader;
    public UserData userData;
    public boolean userResponseCodeSet = false;
    public int userResponseCode;
    public TimeStamp msgCenterTimeStamp;
    public TimeStamp validityPeriodAbsolute;
    public TimeStamp deferredDeliveryTimeAbsolute;
    public boolean validityPeriodRelativeSet;
    public int validityPeriodRelative;
    public boolean deferredDeliveryTimeRelativeSet;
    public int deferredDeliveryTimeRelative;
    public boolean userAckReq;
    public boolean deliveryAckReq;
    public boolean readAckReq;
    public boolean reportReq;
    public int numberOfMessages;
    public int depositIndex;
    public CdmaSmsAddress callbackNumber;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.008 -0400", hash_original_method = "EAAAD90B2C9DF675682D399D59A82B14", hash_generated_method = "EAAAD90B2C9DF675682D399D59A82B14")
        public BearerData ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.009 -0400", hash_original_method = "E225AAC9CA93385B8BA6F6A4FE181F4E", hash_generated_method = "85EED1B544417BC064479030346218E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder builder;
        builder = new StringBuilder();
        builder.append("BearerData ");
        builder.append("{ messageType=" + messageType);
        builder.append(", messageId=" + (int)messageId);
        builder.append(", priority=" + (priorityIndicatorSet ? priority : "unset"));
        builder.append(", privacy=" + (privacyIndicatorSet ? privacy : "unset"));
        builder.append(", alert=" + (alertIndicatorSet ? alert : "unset"));
        builder.append(", displayMode=" + (displayModeSet ? displayMode : "unset"));
        builder.append(", language=" + (languageIndicatorSet ? language : "unset"));
        builder.append(", errorClass=" + (messageStatusSet ? errorClass : "unset"));
        builder.append(", msgStatus=" + (messageStatusSet ? messageStatus : "unset"));
        builder.append(", msgCenterTimeStamp=" +
                ((msgCenterTimeStamp != null) ? msgCenterTimeStamp : "unset"));
        builder.append(", validityPeriodAbsolute=" +
                ((validityPeriodAbsolute != null) ? validityPeriodAbsolute : "unset"));
        builder.append(", validityPeriodRelative=" +
                ((validityPeriodRelativeSet) ? validityPeriodRelative : "unset"));
        builder.append(", deferredDeliveryTimeAbsolute=" +
                ((deferredDeliveryTimeAbsolute != null) ? deferredDeliveryTimeAbsolute : "unset"));
        builder.append(", deferredDeliveryTimeRelative=" +
                ((deferredDeliveryTimeRelativeSet) ? deferredDeliveryTimeRelative : "unset"));
        builder.append(", userAckReq=" + userAckReq);
        builder.append(", deliveryAckReq=" + deliveryAckReq);
        builder.append(", readAckReq=" + readAckReq);
        builder.append(", reportReq=" + reportReq);
        builder.append(", numberOfMessages=" + numberOfMessages);
        builder.append(", callbackNumber=" + callbackNumber);
        builder.append(", depositIndex=" + depositIndex);
        builder.append(", hasUserDataHeader=" + hasUserDataHeader);
        builder.append(", userData=" + userData);
        builder.append(" }");
        String var687AAF24B90629C9BFCFE9608FDCE6E7_212025392 = (builder.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        private static void encodeMessageId(BearerData bData, BitwiseOutputStream outStream) throws BitwiseOutputStream.AccessException {
        outStream.write(8, 3);
        outStream.write(4, bData.messageType);
        outStream.write(8, bData.messageId >> 8);
        outStream.write(8, bData.messageId);
        outStream.write(1, bData.hasUserDataHeader ? 1 : 0);
        outStream.skip(3);
    }

    
        private static int countAsciiSeptets(CharSequence msg, boolean force) {
        int msgLen = msg.length();
        if (force) return msgLen;
        for (int i = 0; i < msgLen; i++) {
            if (UserData.charToAscii.get(msg.charAt(i), -1) == -1) {
                return -1;
            }
        }
        return msgLen;
    }

    
        public static TextEncodingDetails calcTextEncodingDetails(CharSequence msg,
            boolean force7BitEncoding) {
        TextEncodingDetails ted;
        int septets = countAsciiSeptets(msg, force7BitEncoding);
        if (septets != -1 && septets <= SmsMessage.MAX_USER_DATA_SEPTETS) {
            ted = new TextEncodingDetails();
            ted.msgCount = 1;
            ted.codeUnitCount = septets;
            ted.codeUnitsRemaining = SmsMessage.MAX_USER_DATA_SEPTETS - septets;
            ted.codeUnitSize = SmsMessage.ENCODING_7BIT;
        } else {
            ted = com.android.internal.telephony.gsm.SmsMessage.calculateLength(
                    msg, force7BitEncoding);
            if (ted.msgCount == 1 && ted.codeUnitSize == SmsMessage.ENCODING_7BIT) {
                ted.codeUnitCount = msg.length();
                int octets = ted.codeUnitCount * 2;
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
        }
        return ted;
    }

    
        private static byte[] encode7bitAscii(String msg, boolean force) throws CodingException {
        try {
            BitwiseOutputStream outStream = new BitwiseOutputStream(msg.length());
            int msgLen = msg.length();
            for (int i = 0; i < msgLen; i++) {
                int charCode = UserData.charToAscii.get(msg.charAt(i), -1);
                if (charCode == -1) {
                    if (force) {
                        outStream.write(7, UserData.UNENCODABLE_7_BIT_CHAR);
                    } else {
                        throw new CodingException("cannot ASCII encode (" + msg.charAt(i) + ")");
                    }
                } else {
                    outStream.write(7, charCode);
                }
            }
            return outStream.toByteArray();
        } catch (BitwiseOutputStream.AccessException ex) {
            throw new CodingException("7bit ASCII encode failed: " + ex);
        }
    }

    
        private static byte[] encodeUtf16(String msg) throws CodingException {
        try {
            return msg.getBytes("utf-16be");
        } catch (java.io.UnsupportedEncodingException ex) {
            throw new CodingException("UTF-16 encode failed: " + ex);
        }
    }

    
        private static Gsm7bitCodingResult encode7bitGsm(String msg, int septetOffset, boolean force) throws CodingException {
        try {
            byte[] fullData = GsmAlphabet.stringToGsm7BitPacked(msg, septetOffset, !force, 0, 0);
            Gsm7bitCodingResult result = new Gsm7bitCodingResult();
            result.data = new byte[fullData.length - 1];
            System.arraycopy(fullData, 1, result.data, 0, fullData.length - 1);
            result.septets = fullData[0] & 0x00FF;
            return result;
        } catch (com.android.internal.telephony.EncodeException ex) {
            throw new CodingException("7bit GSM encode failed: " + ex);
        }
    }

    
        private static void encode7bitEms(UserData uData, byte[] udhData, boolean force) throws CodingException {
        int udhBytes = udhData.length + 1;
        int udhSeptets = ((udhBytes * 8) + 6) / 7;
        Gsm7bitCodingResult gcr = encode7bitGsm(uData.payloadStr, udhSeptets, force);
        uData.msgEncoding = UserData.ENCODING_GSM_7BIT_ALPHABET;
        uData.msgEncodingSet = true;
        uData.numFields = gcr.septets;
        uData.payload = gcr.data;
        uData.payload[0] = (byte)udhData.length;
        System.arraycopy(udhData, 0, uData.payload, 1, udhData.length);
    }

    
        private static void encode16bitEms(UserData uData, byte[] udhData) throws CodingException {
        byte[] payload = encodeUtf16(uData.payloadStr);
        int udhBytes = udhData.length + 1;
        int udhCodeUnits = (udhBytes + 1) / 2;
        int udhPadding = udhBytes % 2;
        int payloadCodeUnits = payload.length / 2;
        uData.msgEncoding = UserData.ENCODING_UNICODE_16;
        uData.msgEncodingSet = true;
        uData.numFields = udhCodeUnits + payloadCodeUnits;
        uData.payload = new byte[uData.numFields * 2];
        uData.payload[0] = (byte)udhData.length;
        System.arraycopy(udhData, 0, uData.payload, 1, udhData.length);
        System.arraycopy(payload, 0, uData.payload, udhBytes + udhPadding, payload.length);
    }

    
        private static void encodeEmsUserDataPayload(UserData uData) throws CodingException {
        byte[] headerData = SmsHeader.toByteArray(uData.userDataHeader);
        if (uData.msgEncodingSet) {
            if (uData.msgEncoding == UserData.ENCODING_GSM_7BIT_ALPHABET) {
                encode7bitEms(uData, headerData, true);
            } else if (uData.msgEncoding == UserData.ENCODING_UNICODE_16) {
                encode16bitEms(uData, headerData);
            } else {
                throw new CodingException("unsupported EMS user data encoding (" +
                                          uData.msgEncoding + ")");
            }
        } else {
            try {
                encode7bitEms(uData, headerData, false);
            } catch (CodingException ex) {
                encode16bitEms(uData, headerData);
            }
        }
    }

    
        private static void encodeUserDataPayload(UserData uData) throws CodingException {
        if ((uData.payloadStr == null) && (uData.msgEncoding != UserData.ENCODING_OCTET)) {
            Log.e(LOG_TAG, "user data with null payloadStr");
            uData.payloadStr = "";
        }
        if (uData.userDataHeader != null) {
            encodeEmsUserDataPayload(uData);
            return;
        }
        if (uData.msgEncodingSet) {
            if (uData.msgEncoding == UserData.ENCODING_OCTET) {
                if (uData.payload == null) {
                    Log.e(LOG_TAG, "user data with octet encoding but null payload");
                    uData.payload = new byte[0];
                    uData.numFields = 0;
                } else {
                    uData.numFields = uData.payload.length;
                }
            } else {
                if (uData.payloadStr == null) {
                    Log.e(LOG_TAG, "non-octet user data with null payloadStr");
                    uData.payloadStr = "";
                }
                if (uData.msgEncoding == UserData.ENCODING_GSM_7BIT_ALPHABET) {
                    Gsm7bitCodingResult gcr = encode7bitGsm(uData.payloadStr, 0, true);
                    uData.payload = gcr.data;
                    uData.numFields = gcr.septets;
                } else if (uData.msgEncoding == UserData.ENCODING_7BIT_ASCII) {
                    uData.payload = encode7bitAscii(uData.payloadStr, true);
                    uData.numFields = uData.payloadStr.length();
                } else if (uData.msgEncoding == UserData.ENCODING_UNICODE_16) {
                    uData.payload = encodeUtf16(uData.payloadStr);
                    uData.numFields = uData.payloadStr.length();
                } else {
                    throw new CodingException("unsupported user data encoding (" +
                                              uData.msgEncoding + ")");
                }
            }
        } else {
            try {
                uData.payload = encode7bitAscii(uData.payloadStr, false);
                uData.msgEncoding = UserData.ENCODING_7BIT_ASCII;
            } catch (CodingException ex) {
                uData.payload = encodeUtf16(uData.payloadStr);
                uData.msgEncoding = UserData.ENCODING_UNICODE_16;
            }
            uData.numFields = uData.payloadStr.length();
            uData.msgEncodingSet = true;
        }
    }

    
        private static void encodeUserData(BearerData bData, BitwiseOutputStream outStream) throws BitwiseOutputStream.AccessException, CodingException {
        encodeUserDataPayload(bData.userData);
        bData.hasUserDataHeader = bData.userData.userDataHeader != null;
        if (bData.userData.payload.length > SmsMessage.MAX_USER_DATA_BYTES) {
            throw new CodingException("encoded user data too large (" +
                                      bData.userData.payload.length +
                                      " > " + SmsMessage.MAX_USER_DATA_BYTES + " bytes)");
        }
        int dataBits = (bData.userData.payload.length * 8) - bData.userData.paddingBits;
        int paramBits = dataBits + 13;
        if ((bData.userData.msgEncoding == UserData.ENCODING_IS91_EXTENDED_PROTOCOL) ||
            (bData.userData.msgEncoding == UserData.ENCODING_GSM_DCS)) {
            paramBits += 8;
        }
        int paramBytes = (paramBits / 8) + ((paramBits % 8) > 0 ? 1 : 0);
        int paddingBits = (paramBytes * 8) - paramBits;
        outStream.write(8, paramBytes);
        outStream.write(5, bData.userData.msgEncoding);
        if ((bData.userData.msgEncoding == UserData.ENCODING_IS91_EXTENDED_PROTOCOL) ||
            (bData.userData.msgEncoding == UserData.ENCODING_GSM_DCS)) {
            outStream.write(8, bData.userData.msgType);
        }
        outStream.write(8, bData.userData.numFields);
        outStream.writeByteArray(dataBits, bData.userData.payload);
        if (paddingBits > 0) outStream.write(paddingBits, 0);
    }

    
        private static void encodeReplyOption(BearerData bData, BitwiseOutputStream outStream) throws BitwiseOutputStream.AccessException {
        outStream.write(8, 1);
        outStream.write(1, bData.userAckReq     ? 1 : 0);
        outStream.write(1, bData.deliveryAckReq ? 1 : 0);
        outStream.write(1, bData.readAckReq     ? 1 : 0);
        outStream.write(1, bData.reportReq      ? 1 : 0);
        outStream.write(4, 0);
    }

    
        private static byte[] encodeDtmfSmsAddress(String address) {
        int digits = address.length();
        int dataBits = digits * 4;
        int dataBytes = (dataBits / 8);
        dataBytes += (dataBits % 8) > 0 ? 1 : 0;
        byte[] rawData = new byte[dataBytes];
        for (int i = 0; i < digits; i++) {
            char c = address.charAt(i);
            int val = 0;
            if ((c >= '1') && (c <= '9')) val = c - '0';
            else if (c == '0') val = 10;
            else if (c == '*') val = 11;
            else if (c == '#') val = 12;
            else return null;
            rawData[i / 2] |= val << (4 - ((i % 2) * 4));
        }
        return rawData;
    }

    
        private static void encodeCdmaSmsAddress(CdmaSmsAddress addr) throws CodingException {
        if (addr.digitMode == CdmaSmsAddress.DIGIT_MODE_8BIT_CHAR) {
            try {
                addr.origBytes = addr.address.getBytes("US-ASCII");
            } catch (java.io.UnsupportedEncodingException ex) {
                throw new CodingException("invalid SMS address, cannot convert to ASCII");
            }
        } else {
            addr.origBytes = encodeDtmfSmsAddress(addr.address);
        }
    }

    
        private static void encodeCallbackNumber(BearerData bData, BitwiseOutputStream outStream) throws BitwiseOutputStream.AccessException, CodingException {
        CdmaSmsAddress addr = bData.callbackNumber;
        encodeCdmaSmsAddress(addr);
        int paramBits = 9;
        int dataBits = 0;
        if (addr.digitMode == CdmaSmsAddress.DIGIT_MODE_8BIT_CHAR) {
            paramBits += 7;
            dataBits = addr.numberOfDigits * 8;
        } else {
            dataBits = addr.numberOfDigits * 4;
        }
        paramBits += dataBits;
        int paramBytes = (paramBits / 8) + ((paramBits % 8) > 0 ? 1 : 0);
        int paddingBits = (paramBytes * 8) - paramBits;
        outStream.write(8, paramBytes);
        outStream.write(1, addr.digitMode);
        if (addr.digitMode == CdmaSmsAddress.DIGIT_MODE_8BIT_CHAR) {
            outStream.write(3, addr.ton);
            outStream.write(4, addr.numberPlan);
        }
        outStream.write(8, addr.numberOfDigits);
        outStream.writeByteArray(dataBits, addr.origBytes);
        if (paddingBits > 0) outStream.write(paddingBits, 0);
    }

    
        private static void encodeMsgStatus(BearerData bData, BitwiseOutputStream outStream) throws BitwiseOutputStream.AccessException {
        outStream.write(8, 1);
        outStream.write(2, bData.errorClass);
        outStream.write(6, bData.messageStatus);
    }

    
        private static void encodeMsgCount(BearerData bData, BitwiseOutputStream outStream) throws BitwiseOutputStream.AccessException {
        outStream.write(8, 1);
        outStream.write(8, bData.numberOfMessages);
    }

    
        private static void encodeValidityPeriodRel(BearerData bData, BitwiseOutputStream outStream) throws BitwiseOutputStream.AccessException {
        outStream.write(8, 1);
        outStream.write(8, bData.validityPeriodRelative);
    }

    
        private static void encodePrivacyIndicator(BearerData bData, BitwiseOutputStream outStream) throws BitwiseOutputStream.AccessException {
        outStream.write(8, 1);
        outStream.write(2, bData.privacy);
        outStream.skip(6);
    }

    
        private static void encodeLanguageIndicator(BearerData bData, BitwiseOutputStream outStream) throws BitwiseOutputStream.AccessException {
        outStream.write(8, 1);
        outStream.write(8, bData.language);
    }

    
        private static void encodeDisplayMode(BearerData bData, BitwiseOutputStream outStream) throws BitwiseOutputStream.AccessException {
        outStream.write(8, 1);
        outStream.write(2, bData.displayMode);
        outStream.skip(6);
    }

    
        private static void encodePriorityIndicator(BearerData bData, BitwiseOutputStream outStream) throws BitwiseOutputStream.AccessException {
        outStream.write(8, 1);
        outStream.write(2, bData.priority);
        outStream.skip(6);
    }

    
        private static void encodeMsgDeliveryAlert(BearerData bData, BitwiseOutputStream outStream) throws BitwiseOutputStream.AccessException {
        outStream.write(8, 1);
        outStream.write(2, bData.alert);
        outStream.skip(6);
    }

    
        public static byte[] encode(BearerData bData) {
        bData.hasUserDataHeader = ((bData.userData != null) &&
                (bData.userData.userDataHeader != null));
        try {
            BitwiseOutputStream outStream = new BitwiseOutputStream(200);
            outStream.write(8, SUBPARAM_MESSAGE_IDENTIFIER);
            encodeMessageId(bData, outStream);
            if (bData.userData != null) {
                outStream.write(8, SUBPARAM_USER_DATA);
                encodeUserData(bData, outStream);
            }
            if (bData.callbackNumber != null) {
                outStream.write(8, SUBPARAM_CALLBACK_NUMBER);
                encodeCallbackNumber(bData, outStream);
            }
            if (bData.userAckReq || bData.deliveryAckReq || bData.readAckReq || bData.reportReq) {
                outStream.write(8, SUBPARAM_REPLY_OPTION);
                encodeReplyOption(bData, outStream);
            }
            if (bData.numberOfMessages != 0) {
                outStream.write(8, SUBPARAM_NUMBER_OF_MESSAGES);
                encodeMsgCount(bData, outStream);
            }
            if (bData.validityPeriodRelativeSet) {
                outStream.write(8, SUBPARAM_VALIDITY_PERIOD_RELATIVE);
                encodeValidityPeriodRel(bData, outStream);
            }
            if (bData.privacyIndicatorSet) {
                outStream.write(8, SUBPARAM_PRIVACY_INDICATOR);
                encodePrivacyIndicator(bData, outStream);
            }
            if (bData.languageIndicatorSet) {
                outStream.write(8, SUBPARAM_LANGUAGE_INDICATOR);
                encodeLanguageIndicator(bData, outStream);
            }
            if (bData.displayModeSet) {
                outStream.write(8, SUBPARAM_MESSAGE_DISPLAY_MODE);
                encodeDisplayMode(bData, outStream);
            }
            if (bData.priorityIndicatorSet) {
                outStream.write(8, SUBPARAM_PRIORITY_INDICATOR);
                encodePriorityIndicator(bData, outStream);
            }
            if (bData.alertIndicatorSet) {
                outStream.write(8, SUBPARAM_ALERT_ON_MESSAGE_DELIVERY);
                encodeMsgDeliveryAlert(bData, outStream);
            }
            if (bData.messageStatusSet) {
                outStream.write(8, SUBPARAM_MESSAGE_STATUS);
                encodeMsgStatus(bData, outStream);
            }
            return outStream.toByteArray();
        } catch (BitwiseOutputStream.AccessException ex) {
            Log.e(LOG_TAG, "BearerData encode failed: " + ex);
        } catch (CodingException ex) {
            Log.e(LOG_TAG, "BearerData encode failed: " + ex);
        }
        return null;
    }

    
        private static boolean decodeMessageId(BearerData bData, BitwiseInputStream inStream) throws BitwiseInputStream.AccessException, CodingException {
        final int EXPECTED_PARAM_SIZE = 3 * 8;
        boolean decodeSuccess = false;
        int paramBits = inStream.read(8) * 8;
        if (paramBits >= EXPECTED_PARAM_SIZE) {
            paramBits -= EXPECTED_PARAM_SIZE;
            decodeSuccess = true;
            bData.messageType = inStream.read(4);
            bData.messageId = inStream.read(8) << 8;
            bData.messageId |= inStream.read(8);
            bData.hasUserDataHeader = (inStream.read(1) == 1);
            inStream.skip(3);
        }
        if ((! decodeSuccess) || (paramBits > 0)) {
            Log.d(LOG_TAG, "MESSAGE_IDENTIFIER decode " +
                      (decodeSuccess ? "succeeded" : "failed") +
                      " (extra bits = " + paramBits + ")");
        }
        inStream.skip(paramBits);
        return decodeSuccess;
    }

    
        private static boolean decodeUserData(BearerData bData, BitwiseInputStream inStream) throws BitwiseInputStream.AccessException {
        int paramBits = inStream.read(8) * 8;
        bData.userData = new UserData();
        bData.userData.msgEncoding = inStream.read(5);
        bData.userData.msgEncodingSet = true;
        bData.userData.msgType = 0;
        int consumedBits = 5;
        if ((bData.userData.msgEncoding == UserData.ENCODING_IS91_EXTENDED_PROTOCOL) ||
            (bData.userData.msgEncoding == UserData.ENCODING_GSM_DCS)) {
            bData.userData.msgType = inStream.read(8);
            consumedBits += 8;
        }
        bData.userData.numFields = inStream.read(8);
        consumedBits += 8;
        int dataBits = paramBits - consumedBits;
        bData.userData.payload = inStream.readByteArray(dataBits);
        return true;
    }

    
        private static String decodeUtf8(byte[] data, int offset, int numFields) throws CodingException {
        try {
            return new String(data, offset, numFields, "UTF-8");
        } catch (java.io.UnsupportedEncodingException ex) {
            throw new CodingException("UTF-8 decode failed: " + ex);
        }
    }

    
        private static String decodeUtf16(byte[] data, int offset, int numFields) throws CodingException {
        int padding = offset % 2;
        numFields -= (offset + padding) / 2;
        try {
            return new String(data, offset, numFields * 2, "utf-16be");
        } catch (java.io.UnsupportedEncodingException ex) {
            throw new CodingException("UTF-16 decode failed: " + ex);
        }
    }

    
        private static String decode7bitAscii(byte[] data, int offset, int numFields) throws CodingException {
        try {
            offset *= 8;
            StringBuffer strBuf = new StringBuffer(numFields);
            BitwiseInputStream inStream = new BitwiseInputStream(data);
            int wantedBits = (offset * 8) + (numFields * 7);
            if (inStream.available() < wantedBits) {
                throw new CodingException("insufficient data (wanted " + wantedBits +
                                          " bits, but only have " + inStream.available() + ")");
            }
            inStream.skip(offset);
            for (int i = 0; i < numFields; i++) {
                int charCode = inStream.read(7);
                if ((charCode >= UserData.ASCII_MAP_BASE_INDEX) &&
                        (charCode <= UserData.ASCII_MAP_MAX_INDEX)) {
                    strBuf.append(UserData.ASCII_MAP[charCode - UserData.ASCII_MAP_BASE_INDEX]);
                } else if (charCode == UserData.ASCII_NL_INDEX) {
                    strBuf.append('\n');
                } else if (charCode == UserData.ASCII_CR_INDEX) {
                    strBuf.append('\r');
                } else {
                    strBuf.append(' ');
                }
            }
            return strBuf.toString();
        } catch (BitwiseInputStream.AccessException ex) {
            throw new CodingException("7bit ASCII decode failed: " + ex);
        }
    }

    
        private static String decode7bitGsm(byte[] data, int offset, int numFields) throws CodingException {
        int offsetBits = offset * 8;
        int offsetSeptets = (offsetBits + 6) / 7;
        numFields -= offsetSeptets;
        int paddingBits = (offsetSeptets * 7) - offsetBits;
        String result = GsmAlphabet.gsm7BitPackedToString(data, offset, numFields, paddingBits,
                0, 0);
        if (result == null) {
            throw new CodingException("7bit GSM decoding failed");
        }
        return result;
    }

    
        private static String decodeLatin(byte[] data, int offset, int numFields) throws CodingException {
        try {
            return new String(data, offset, numFields - offset, "ISO-8859-1");
        } catch (java.io.UnsupportedEncodingException ex) {
            throw new CodingException("ISO-8859-1 decode failed: " + ex);
        }
    }

    
        private static void decodeUserDataPayload(UserData userData, boolean hasUserDataHeader) throws CodingException {
        int offset = 0;
        if (hasUserDataHeader) {
            int udhLen = userData.payload[0] & 0x00FF;
            offset += udhLen + 1;
            byte[] headerData = new byte[udhLen];
            System.arraycopy(userData.payload, 1, headerData, 0, udhLen);
            userData.userDataHeader = SmsHeader.fromByteArray(headerData);
        }
        switch (userData.msgEncoding) {
        case UserData.ENCODING_OCTET:
            boolean decodingtypeUTF8 = Resources.getSystem()
                    .getBoolean(com.android.internal.R.bool.config_sms_utf8_support);
            byte[] payload = new byte[userData.numFields];
            int copyLen = userData.numFields < userData.payload.length
                    ? userData.numFields : userData.payload.length;
            System.arraycopy(userData.payload, 0, payload, 0, copyLen);
            userData.payload = payload;
            if (!decodingtypeUTF8) {
                userData.payloadStr = decodeLatin(userData.payload, offset, userData.numFields);
            } else {
                userData.payloadStr = decodeUtf8(userData.payload, offset, userData.numFields);
            }
            break;
        case UserData.ENCODING_IA5:
        case UserData.ENCODING_7BIT_ASCII:
            userData.payloadStr = decode7bitAscii(userData.payload, offset, userData.numFields);
            break;
        case UserData.ENCODING_UNICODE_16:
            userData.payloadStr = decodeUtf16(userData.payload, offset, userData.numFields);
            break;
        case UserData.ENCODING_GSM_7BIT_ALPHABET:
            userData.payloadStr = decode7bitGsm(userData.payload, offset, userData.numFields);
            break;
        case UserData.ENCODING_LATIN:
            userData.payloadStr = decodeLatin(userData.payload, offset, userData.numFields);
            break;
        default:
            throw new CodingException("unsupported user data encoding ("
                                      + userData.msgEncoding + ")");
        }
    }

    
        private static void decodeIs91VoicemailStatus(BearerData bData) throws BitwiseInputStream.AccessException, CodingException {
        BitwiseInputStream inStream = new BitwiseInputStream(bData.userData.payload);
        int dataLen = inStream.available() / 6;
        int numFields = bData.userData.numFields;
        if ((dataLen > 14) || (dataLen < 3) || (dataLen < numFields)) {
            throw new CodingException("IS-91 voicemail status decoding failed");
        }
        try {
            StringBuffer strbuf = new StringBuffer(dataLen);
            while (inStream.available() >= 6) {
                strbuf.append(UserData.ASCII_MAP[inStream.read(6)]);
            }
            String data = strbuf.toString();
            bData.numberOfMessages = Integer.parseInt(data.substring(0, 2));
            char prioCode = data.charAt(2);
            if (prioCode == ' ') {
                bData.priority = PRIORITY_NORMAL;
            } else if (prioCode == '!') {
                bData.priority = PRIORITY_URGENT;
            } else {
                throw new CodingException("IS-91 voicemail status decoding failed: " +
                        "illegal priority setting (" + prioCode + ")");
            }
            bData.priorityIndicatorSet = true;
            bData.userData.payloadStr = data.substring(3, numFields - 3);
       } catch (java.lang.NumberFormatException ex) {
            throw new CodingException("IS-91 voicemail status decoding failed: " + ex);
        } catch (java.lang.IndexOutOfBoundsException ex) {
            throw new CodingException("IS-91 voicemail status decoding failed: " + ex);
        }
    }

    
        private static void decodeIs91ShortMessage(BearerData bData) throws BitwiseInputStream.AccessException, CodingException {
        BitwiseInputStream inStream = new BitwiseInputStream(bData.userData.payload);
        int dataLen = inStream.available() / 6;
        int numFields = bData.userData.numFields;
        if ((dataLen > 14) || (dataLen < numFields)) {
            throw new CodingException("IS-91 voicemail status decoding failed");
        }
        StringBuffer strbuf = new StringBuffer(dataLen);
        for (int i = 0; i < numFields; i++) {
            strbuf.append(UserData.ASCII_MAP[inStream.read(6)]);
        }
        bData.userData.payloadStr = strbuf.toString();
    }

    
        private static void decodeIs91Cli(BearerData bData) throws CodingException {
        BitwiseInputStream inStream = new BitwiseInputStream(bData.userData.payload);
        int dataLen = inStream.available() / 4;
        int numFields = bData.userData.numFields;
        if ((dataLen > 14) || (dataLen < 3) || (dataLen < numFields)) {
            throw new CodingException("IS-91 voicemail status decoding failed");
        }
        CdmaSmsAddress addr = new CdmaSmsAddress();
        addr.digitMode = CdmaSmsAddress.DIGIT_MODE_4BIT_DTMF;
        addr.origBytes = bData.userData.payload;
        addr.numberOfDigits = (byte)numFields;
        decodeSmsAddress(addr);
        bData.callbackNumber = addr;
    }

    
        private static void decodeIs91(BearerData bData) throws BitwiseInputStream.AccessException, CodingException {
        switch (bData.userData.msgType) {
        case UserData.IS91_MSG_TYPE_VOICEMAIL_STATUS:
            decodeIs91VoicemailStatus(bData);
            break;
        case UserData.IS91_MSG_TYPE_CLI:
            decodeIs91Cli(bData);
            break;
        case UserData.IS91_MSG_TYPE_SHORT_MESSAGE_FULL:
        case UserData.IS91_MSG_TYPE_SHORT_MESSAGE:
            decodeIs91ShortMessage(bData);
            break;
        default:
            throw new CodingException("unsupported IS-91 message type (" +
                    bData.userData.msgType + ")");
        }
    }

    
        private static boolean decodeReplyOption(BearerData bData, BitwiseInputStream inStream) throws BitwiseInputStream.AccessException, CodingException {
        final int EXPECTED_PARAM_SIZE = 1 * 8;
        boolean decodeSuccess = false;
        int paramBits = inStream.read(8) * 8;
        if (paramBits >= EXPECTED_PARAM_SIZE) {
            paramBits -= EXPECTED_PARAM_SIZE;
            decodeSuccess = true;
            bData.userAckReq     = (inStream.read(1) == 1);
            bData.deliveryAckReq = (inStream.read(1) == 1);
            bData.readAckReq     = (inStream.read(1) == 1);
            bData.reportReq      = (inStream.read(1) == 1);
            inStream.skip(4);
        }
        if ((! decodeSuccess) || (paramBits > 0)) {
            Log.d(LOG_TAG, "REPLY_OPTION decode " +
                      (decodeSuccess ? "succeeded" : "failed") +
                      " (extra bits = " + paramBits + ")");
        }
        inStream.skip(paramBits);
        return decodeSuccess;
    }

    
        private static boolean decodeMsgCount(BearerData bData, BitwiseInputStream inStream) throws BitwiseInputStream.AccessException, CodingException {
        final int EXPECTED_PARAM_SIZE = 1 * 8;
        boolean decodeSuccess = false;
        int paramBits = inStream.read(8) * 8;
        if (paramBits >= EXPECTED_PARAM_SIZE) {
            paramBits -= EXPECTED_PARAM_SIZE;
            decodeSuccess = true;
            bData.numberOfMessages = IccUtils.cdmaBcdByteToInt((byte)inStream.read(8));
        }
        if ((! decodeSuccess) || (paramBits > 0)) {
            Log.d(LOG_TAG, "NUMBER_OF_MESSAGES decode " +
                      (decodeSuccess ? "succeeded" : "failed") +
                      " (extra bits = " + paramBits + ")");
        }
        inStream.skip(paramBits);
        return decodeSuccess;
    }

    
        private static boolean decodeDepositIndex(BearerData bData, BitwiseInputStream inStream) throws BitwiseInputStream.AccessException, CodingException {
        final int EXPECTED_PARAM_SIZE = 2 * 8;
        boolean decodeSuccess = false;
        int paramBits = inStream.read(8) * 8;
        if (paramBits >= EXPECTED_PARAM_SIZE) {
            paramBits -= EXPECTED_PARAM_SIZE;
            decodeSuccess = true;
            bData.depositIndex = (inStream.read(8) << 8) | inStream.read(8);
        }
        if ((! decodeSuccess) || (paramBits > 0)) {
            Log.d(LOG_TAG, "MESSAGE_DEPOSIT_INDEX decode " +
                      (decodeSuccess ? "succeeded" : "failed") +
                      " (extra bits = " + paramBits + ")");
        }
        inStream.skip(paramBits);
        return decodeSuccess;
    }

    
        private static String decodeDtmfSmsAddress(byte[] rawData, int numFields) throws CodingException {
        StringBuffer strBuf = new StringBuffer(numFields);
        for (int i = 0; i < numFields; i++) {
            int val = 0x0F & (rawData[i / 2] >>> (4 - ((i % 2) * 4)));
            if ((val >= 1) && (val <= 9)) strBuf.append(Integer.toString(val, 10));
            else if (val == 10) strBuf.append('0');
            else if (val == 11) strBuf.append('*');
            else if (val == 12) strBuf.append('#');
            else throw new CodingException("invalid SMS address DTMF code (" + val + ")");
        }
        return strBuf.toString();
    }

    
        private static void decodeSmsAddress(CdmaSmsAddress addr) throws CodingException {
        if (addr.digitMode == CdmaSmsAddress.DIGIT_MODE_8BIT_CHAR) {
            try {
                addr.address = new String(addr.origBytes, 0, addr.origBytes.length, "US-ASCII");
            } catch (java.io.UnsupportedEncodingException ex) {
                throw new CodingException("invalid SMS address ASCII code");
            }
        } else {
            addr.address = decodeDtmfSmsAddress(addr.origBytes, addr.numberOfDigits);
        }
    }

    
        private static boolean decodeCallbackNumber(BearerData bData, BitwiseInputStream inStream) throws BitwiseInputStream.AccessException, CodingException {
        int paramBits = inStream.read(8) * 8;
        CdmaSmsAddress addr = new CdmaSmsAddress();
        addr.digitMode = inStream.read(1);
        byte fieldBits = 4;
        byte consumedBits = 1;
        if (addr.digitMode == CdmaSmsAddress.DIGIT_MODE_8BIT_CHAR) {
            addr.ton = inStream.read(3);
            addr.numberPlan = inStream.read(4);
            fieldBits = 8;
            consumedBits += 7;
        }
        addr.numberOfDigits = inStream.read(8);
        consumedBits += 8;
        int remainingBits = paramBits - consumedBits;
        int dataBits = addr.numberOfDigits * fieldBits;
        int paddingBits = remainingBits - dataBits;
        if (remainingBits < dataBits) {
            throw new CodingException("CALLBACK_NUMBER subparam encoding size error (" +
                                      "remainingBits + " + remainingBits + ", dataBits + " +
                                      dataBits + ", paddingBits + " + paddingBits + ")");
        }
        addr.origBytes = inStream.readByteArray(dataBits);
        inStream.skip(paddingBits);
        decodeSmsAddress(addr);
        bData.callbackNumber = addr;
        return true;
    }

    
        private static boolean decodeMsgStatus(BearerData bData, BitwiseInputStream inStream) throws BitwiseInputStream.AccessException, CodingException {
        final int EXPECTED_PARAM_SIZE = 1 * 8;
        boolean decodeSuccess = false;
        int paramBits = inStream.read(8) * 8;
        if (paramBits >= EXPECTED_PARAM_SIZE) {
            paramBits -= EXPECTED_PARAM_SIZE;
            decodeSuccess = true;
            bData.errorClass = inStream.read(2);
            bData.messageStatus = inStream.read(6);
        }
        if ((! decodeSuccess) || (paramBits > 0)) {
            Log.d(LOG_TAG, "MESSAGE_STATUS decode " +
                      (decodeSuccess ? "succeeded" : "failed") +
                      " (extra bits = " + paramBits + ")");
        }
        inStream.skip(paramBits);
        bData.messageStatusSet = decodeSuccess;
        return decodeSuccess;
    }

    
        private static boolean decodeMsgCenterTimeStamp(BearerData bData, BitwiseInputStream inStream) throws BitwiseInputStream.AccessException, CodingException {
        final int EXPECTED_PARAM_SIZE = 6 * 8;
        boolean decodeSuccess = false;
        int paramBits = inStream.read(8) * 8;
        if (paramBits >= EXPECTED_PARAM_SIZE) {
            paramBits -= EXPECTED_PARAM_SIZE;
            decodeSuccess = true;
            bData.msgCenterTimeStamp = TimeStamp.fromByteArray(inStream.readByteArray(6 * 8));
        }
        if ((! decodeSuccess) || (paramBits > 0)) {
            Log.d(LOG_TAG, "MESSAGE_CENTER_TIME_STAMP decode " +
                      (decodeSuccess ? "succeeded" : "failed") +
                      " (extra bits = " + paramBits + ")");
        }
        inStream.skip(paramBits);
        return decodeSuccess;
    }

    
        private static boolean decodeValidityAbs(BearerData bData, BitwiseInputStream inStream) throws BitwiseInputStream.AccessException, CodingException {
        final int EXPECTED_PARAM_SIZE = 6 * 8;
        boolean decodeSuccess = false;
        int paramBits = inStream.read(8) * 8;
        if (paramBits >= EXPECTED_PARAM_SIZE) {
            paramBits -= EXPECTED_PARAM_SIZE;
            decodeSuccess = true;
            bData.validityPeriodAbsolute = TimeStamp.fromByteArray(inStream.readByteArray(6 * 8));
        }
        if ((! decodeSuccess) || (paramBits > 0)) {
            Log.d(LOG_TAG, "VALIDITY_PERIOD_ABSOLUTE decode " +
                      (decodeSuccess ? "succeeded" : "failed") +
                      " (extra bits = " + paramBits + ")");
        }
        inStream.skip(paramBits);
        return decodeSuccess;
    }

    
        private static boolean decodeDeferredDeliveryAbs(BearerData bData, BitwiseInputStream inStream) throws BitwiseInputStream.AccessException, CodingException {
        final int EXPECTED_PARAM_SIZE = 6 * 8;
        boolean decodeSuccess = false;
        int paramBits = inStream.read(8) * 8;
        if (paramBits >= EXPECTED_PARAM_SIZE) {
            paramBits -= EXPECTED_PARAM_SIZE;
            decodeSuccess = true;
            bData.deferredDeliveryTimeAbsolute = TimeStamp.fromByteArray(
                    inStream.readByteArray(6 * 8));
        }
        if ((! decodeSuccess) || (paramBits > 0)) {
            Log.d(LOG_TAG, "DEFERRED_DELIVERY_TIME_ABSOLUTE decode " +
                      (decodeSuccess ? "succeeded" : "failed") +
                      " (extra bits = " + paramBits + ")");
        }
        inStream.skip(paramBits);
        return decodeSuccess;
    }

    
        private static boolean decodeValidityRel(BearerData bData, BitwiseInputStream inStream) throws BitwiseInputStream.AccessException, CodingException {
        final int EXPECTED_PARAM_SIZE = 1 * 8;
        boolean decodeSuccess = false;
        int paramBits = inStream.read(8) * 8;
        if (paramBits >= EXPECTED_PARAM_SIZE) {
            paramBits -= EXPECTED_PARAM_SIZE;
            decodeSuccess = true;
            bData.deferredDeliveryTimeRelative = inStream.read(8);
        }
        if ((! decodeSuccess) || (paramBits > 0)) {
            Log.d(LOG_TAG, "VALIDITY_PERIOD_RELATIVE decode " +
                      (decodeSuccess ? "succeeded" : "failed") +
                      " (extra bits = " + paramBits + ")");
        }
        inStream.skip(paramBits);
        bData.deferredDeliveryTimeRelativeSet = decodeSuccess;
        return decodeSuccess;
    }

    
        private static boolean decodeDeferredDeliveryRel(BearerData bData, BitwiseInputStream inStream) throws BitwiseInputStream.AccessException, CodingException {
        final int EXPECTED_PARAM_SIZE = 1 * 8;
        boolean decodeSuccess = false;
        int paramBits = inStream.read(8) * 8;
        if (paramBits >= EXPECTED_PARAM_SIZE) {
            paramBits -= EXPECTED_PARAM_SIZE;
            decodeSuccess = true;
            bData.validityPeriodRelative = inStream.read(8);
        }
        if ((! decodeSuccess) || (paramBits > 0)) {
            Log.d(LOG_TAG, "DEFERRED_DELIVERY_TIME_RELATIVE decode " +
                      (decodeSuccess ? "succeeded" : "failed") +
                      " (extra bits = " + paramBits + ")");
        }
        inStream.skip(paramBits);
        bData.validityPeriodRelativeSet = decodeSuccess;
        return decodeSuccess;
    }

    
        private static boolean decodePrivacyIndicator(BearerData bData, BitwiseInputStream inStream) throws BitwiseInputStream.AccessException, CodingException {
        final int EXPECTED_PARAM_SIZE = 1 * 8;
        boolean decodeSuccess = false;
        int paramBits = inStream.read(8) * 8;
        if (paramBits >= EXPECTED_PARAM_SIZE) {
            paramBits -= EXPECTED_PARAM_SIZE;
            decodeSuccess = true;
            bData.privacy = inStream.read(2);
            inStream.skip(6);
        }
        if ((! decodeSuccess) || (paramBits > 0)) {
            Log.d(LOG_TAG, "PRIVACY_INDICATOR decode " +
                      (decodeSuccess ? "succeeded" : "failed") +
                      " (extra bits = " + paramBits + ")");
        }
        inStream.skip(paramBits);
        bData.privacyIndicatorSet = decodeSuccess;
        return decodeSuccess;
    }

    
        private static boolean decodeLanguageIndicator(BearerData bData, BitwiseInputStream inStream) throws BitwiseInputStream.AccessException, CodingException {
        final int EXPECTED_PARAM_SIZE = 1 * 8;
        boolean decodeSuccess = false;
        int paramBits = inStream.read(8) * 8;
        if (paramBits >= EXPECTED_PARAM_SIZE) {
            paramBits -= EXPECTED_PARAM_SIZE;
            decodeSuccess = true;
            bData.language = inStream.read(8);
        }
        if ((! decodeSuccess) || (paramBits > 0)) {
            Log.d(LOG_TAG, "LANGUAGE_INDICATOR decode " +
                      (decodeSuccess ? "succeeded" : "failed") +
                      " (extra bits = " + paramBits + ")");
        }
        inStream.skip(paramBits);
        bData.languageIndicatorSet = decodeSuccess;
        return decodeSuccess;
    }

    
        private static boolean decodeDisplayMode(BearerData bData, BitwiseInputStream inStream) throws BitwiseInputStream.AccessException, CodingException {
        final int EXPECTED_PARAM_SIZE = 1 * 8;
        boolean decodeSuccess = false;
        int paramBits = inStream.read(8) * 8;
        if (paramBits >= EXPECTED_PARAM_SIZE) {
            paramBits -= EXPECTED_PARAM_SIZE;
            decodeSuccess = true;
            bData.displayMode = inStream.read(2);
            inStream.skip(6);
        }
        if ((! decodeSuccess) || (paramBits > 0)) {
            Log.d(LOG_TAG, "DISPLAY_MODE decode " +
                      (decodeSuccess ? "succeeded" : "failed") +
                      " (extra bits = " + paramBits + ")");
        }
        inStream.skip(paramBits);
        bData.displayModeSet = decodeSuccess;
        return decodeSuccess;
    }

    
        private static boolean decodePriorityIndicator(BearerData bData, BitwiseInputStream inStream) throws BitwiseInputStream.AccessException, CodingException {
        final int EXPECTED_PARAM_SIZE = 1 * 8;
        boolean decodeSuccess = false;
        int paramBits = inStream.read(8) * 8;
        if (paramBits >= EXPECTED_PARAM_SIZE) {
            paramBits -= EXPECTED_PARAM_SIZE;
            decodeSuccess = true;
            bData.priority = inStream.read(2);
            inStream.skip(6);
        }
        if ((! decodeSuccess) || (paramBits > 0)) {
            Log.d(LOG_TAG, "PRIORITY_INDICATOR decode " +
                      (decodeSuccess ? "succeeded" : "failed") +
                      " (extra bits = " + paramBits + ")");
        }
        inStream.skip(paramBits);
        bData.priorityIndicatorSet = decodeSuccess;
        return decodeSuccess;
    }

    
        private static boolean decodeMsgDeliveryAlert(BearerData bData, BitwiseInputStream inStream) throws BitwiseInputStream.AccessException, CodingException {
        final int EXPECTED_PARAM_SIZE = 1 * 8;
        boolean decodeSuccess = false;
        int paramBits = inStream.read(8) * 8;
        if (paramBits >= EXPECTED_PARAM_SIZE) {
            paramBits -= EXPECTED_PARAM_SIZE;
            decodeSuccess = true;
            bData.alert = inStream.read(2);
            inStream.skip(6);
        }
        if ((! decodeSuccess) || (paramBits > 0)) {
            Log.d(LOG_TAG, "ALERT_ON_MESSAGE_DELIVERY decode " +
                      (decodeSuccess ? "succeeded" : "failed") +
                      " (extra bits = " + paramBits + ")");
        }
        inStream.skip(paramBits);
        bData.alertIndicatorSet = decodeSuccess;
        return decodeSuccess;
    }

    
        private static boolean decodeUserResponseCode(BearerData bData, BitwiseInputStream inStream) throws BitwiseInputStream.AccessException, CodingException {
        final int EXPECTED_PARAM_SIZE = 1 * 8;
        boolean decodeSuccess = false;
        int paramBits = inStream.read(8) * 8;
        if (paramBits >= EXPECTED_PARAM_SIZE) {
            paramBits -= EXPECTED_PARAM_SIZE;
            decodeSuccess = true;
            bData.userResponseCode = inStream.read(8);
        }
        if ((! decodeSuccess) || (paramBits > 0)) {
            Log.d(LOG_TAG, "USER_REPONSE_CODE decode " +
                      (decodeSuccess ? "succeeded" : "failed") +
                      " (extra bits = " + paramBits + ")");
        }
        inStream.skip(paramBits);
        bData.userResponseCodeSet = decodeSuccess;
        return decodeSuccess;
    }

    
        public static BearerData decode(byte[] smsData) {
        try {
            BitwiseInputStream inStream = new BitwiseInputStream(smsData);
            BearerData bData = new BearerData();
            int foundSubparamMask = 0;
            while (inStream.available() > 0) {
                boolean decodeSuccess = false;
                int subparamId = inStream.read(8);
                int subparamIdBit = 1 << subparamId;
                if ((foundSubparamMask & subparamIdBit) != 0) {
                    throw new CodingException("illegal duplicate subparameter (" +
                                              subparamId + ")");
                }
                switch (subparamId) {
                case SUBPARAM_MESSAGE_IDENTIFIER:
                    decodeSuccess = decodeMessageId(bData, inStream);
                    break;
                case SUBPARAM_USER_DATA:
                    decodeSuccess = decodeUserData(bData, inStream);
                    break;
                case SUBPARAM_USER_RESPONSE_CODE:
                    decodeSuccess = decodeUserResponseCode(bData, inStream);
                    break;
                case SUBPARAM_REPLY_OPTION:
                    decodeSuccess = decodeReplyOption(bData, inStream);
                    break;
                case SUBPARAM_NUMBER_OF_MESSAGES:
                    decodeSuccess = decodeMsgCount(bData, inStream);
                    break;
                case SUBPARAM_CALLBACK_NUMBER:
                    decodeSuccess = decodeCallbackNumber(bData, inStream);
                    break;
                case SUBPARAM_MESSAGE_STATUS:
                    decodeSuccess = decodeMsgStatus(bData, inStream);
                    break;
                case SUBPARAM_MESSAGE_CENTER_TIME_STAMP:
                    decodeSuccess = decodeMsgCenterTimeStamp(bData, inStream);
                    break;
                case SUBPARAM_VALIDITY_PERIOD_ABSOLUTE:
                    decodeSuccess = decodeValidityAbs(bData, inStream);
                    break;
                case SUBPARAM_VALIDITY_PERIOD_RELATIVE:
                    decodeSuccess = decodeValidityRel(bData, inStream);
                    break;
                case SUBPARAM_DEFERRED_DELIVERY_TIME_ABSOLUTE:
                    decodeSuccess = decodeDeferredDeliveryAbs(bData, inStream);
                    break;
                case SUBPARAM_DEFERRED_DELIVERY_TIME_RELATIVE:
                    decodeSuccess = decodeDeferredDeliveryRel(bData, inStream);
                    break;
                case SUBPARAM_PRIVACY_INDICATOR:
                    decodeSuccess = decodePrivacyIndicator(bData, inStream);
                    break;
                case SUBPARAM_LANGUAGE_INDICATOR:
                    decodeSuccess = decodeLanguageIndicator(bData, inStream);
                    break;
                case SUBPARAM_MESSAGE_DISPLAY_MODE:
                    decodeSuccess = decodeDisplayMode(bData, inStream);
                    break;
                case SUBPARAM_PRIORITY_INDICATOR:
                    decodeSuccess = decodePriorityIndicator(bData, inStream);
                    break;
                case SUBPARAM_ALERT_ON_MESSAGE_DELIVERY:
                    decodeSuccess = decodeMsgDeliveryAlert(bData, inStream);
                    break;
                case SUBPARAM_MESSAGE_DEPOSIT_INDEX:
                    decodeSuccess = decodeDepositIndex(bData, inStream);
                    break;
                default:
                    throw new CodingException("unsupported bearer data subparameter ("
                                              + subparamId + ")");
                }
                if (decodeSuccess) foundSubparamMask |= subparamIdBit;
            }
            if ((foundSubparamMask & (1 << SUBPARAM_MESSAGE_IDENTIFIER)) == 0) {
                throw new CodingException("missing MESSAGE_IDENTIFIER subparam");
            }
            if (bData.userData != null) {
                if (bData.userData.msgEncoding == UserData.ENCODING_IS91_EXTENDED_PROTOCOL) {
                    if ((foundSubparamMask ^
                             (1 << SUBPARAM_MESSAGE_IDENTIFIER) ^
                             (1 << SUBPARAM_USER_DATA))
                            != 0) {
                        Log.e(LOG_TAG, "IS-91 must occur without extra subparams (" +
                              foundSubparamMask + ")");
                    }
                    decodeIs91(bData);
                } else {
                    decodeUserDataPayload(bData.userData, bData.hasUserDataHeader);
                }
            }
            return bData;
        } catch (BitwiseInputStream.AccessException ex) {
            Log.e(LOG_TAG, "BearerData decode failed: " + ex);
        } catch (CodingException ex) {
            Log.e(LOG_TAG, "BearerData decode failed: " + ex);
        }
        return null;
    }

    
    public static class TimeStamp extends Time {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.018 -0400", hash_original_method = "227CB08289E9E58D2E1A786B0B8104B3", hash_generated_method = "8C18566B3367C0FEDF5A52BA15A777A6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public TimeStamp() {
            super(TimeZone.getDefault().getID());
            // ---------- Original Method ----------
        }

        
                public static TimeStamp fromByteArray(byte[] data) {
            TimeStamp ts = new TimeStamp();
            int year = IccUtils.cdmaBcdByteToInt(data[0]);
            if (year > 99 || year < 0) return null;
            ts.year = year >= 96 ? year + 1900 : year + 2000;
            int month = IccUtils.cdmaBcdByteToInt(data[1]);
            if (month < 1 || month > 12) return null;
            ts.month = month - 1;
            int day = IccUtils.cdmaBcdByteToInt(data[2]);
            if (day < 1 || day > 31) return null;
            ts.monthDay = day;
            int hour = IccUtils.cdmaBcdByteToInt(data[3]);
            if (hour < 0 || hour > 23) return null;
            ts.hour = hour;
            int minute = IccUtils.cdmaBcdByteToInt(data[4]);
            if (minute < 0 || minute > 59) return null;
            ts.minute = minute;
            int second = IccUtils.cdmaBcdByteToInt(data[5]);
            if (second < 0 || second > 59) return null;
            ts.second = second;
            return ts;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.019 -0400", hash_original_method = "ED297E11B9020980F3FCB379731AD215", hash_generated_method = "E616CA20DB04F95546D8C6170BE9BF8D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String toString() {
            StringBuilder builder;
            builder = new StringBuilder();
            builder.append("TimeStamp ");
            builder.append("{ year=" + year);
            builder.append(", month=" + month);
            builder.append(", day=" + monthDay);
            builder.append(", hour=" + hour);
            builder.append(", minute=" + minute);
            builder.append(", second=" + second);
            builder.append(" }");
            String varCEB98099F8B5AF9267E3A4873F9FB1DE_1018747924 = (builder.toString());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //StringBuilder builder = new StringBuilder();
            //builder.append("TimeStamp ");
            //builder.append("{ year=" + year);
            //builder.append(", month=" + month);
            //builder.append(", day=" + monthDay);
            //builder.append(", hour=" + hour);
            //builder.append(", minute=" + minute);
            //builder.append(", second=" + second);
            //builder.append(" }");
            //return builder.toString();
        }

        
    }


    
    private static class CodingException extends Exception {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.019 -0400", hash_original_method = "7A2C15A084F2DA50BCA20CD284E89E4B", hash_generated_method = "20F62A9D37710DE8637AEAAE54D77956")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public CodingException(String s) {
            super(s);
            dsTaint.addTaint(s);
            // ---------- Original Method ----------
        }

        
    }


    
    private static class Gsm7bitCodingResult {
        int septets;
        byte[] data;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.019 -0400", hash_original_method = "92930CF7709F3A16583DBEED4B39CBA1", hash_generated_method = "92930CF7709F3A16583DBEED4B39CBA1")
                public Gsm7bitCodingResult ()
        {
        }


    }


    
    private final static String LOG_TAG = "SMS";
    private final static byte SUBPARAM_MESSAGE_IDENTIFIER               = 0x00;
    private final static byte SUBPARAM_USER_DATA                        = 0x01;
    private final static byte SUBPARAM_USER_RESPONSE_CODE               = 0x02;
    private final static byte SUBPARAM_MESSAGE_CENTER_TIME_STAMP        = 0x03;
    private final static byte SUBPARAM_VALIDITY_PERIOD_ABSOLUTE         = 0x04;
    private final static byte SUBPARAM_VALIDITY_PERIOD_RELATIVE         = 0x05;
    private final static byte SUBPARAM_DEFERRED_DELIVERY_TIME_ABSOLUTE  = 0x06;
    private final static byte SUBPARAM_DEFERRED_DELIVERY_TIME_RELATIVE  = 0x07;
    private final static byte SUBPARAM_PRIORITY_INDICATOR               = 0x08;
    private final static byte SUBPARAM_PRIVACY_INDICATOR                = 0x09;
    private final static byte SUBPARAM_REPLY_OPTION                     = 0x0A;
    private final static byte SUBPARAM_NUMBER_OF_MESSAGES               = 0x0B;
    private final static byte SUBPARAM_ALERT_ON_MESSAGE_DELIVERY        = 0x0C;
    private final static byte SUBPARAM_LANGUAGE_INDICATOR               = 0x0D;
    private final static byte SUBPARAM_CALLBACK_NUMBER                  = 0x0E;
    private final static byte SUBPARAM_MESSAGE_DISPLAY_MODE             = 0x0F;
    private final static byte SUBPARAM_MESSAGE_DEPOSIT_INDEX            = 0x11;
    private final static byte SUBPARAM_MESSAGE_STATUS                   = 0x14;
    public static final int MESSAGE_TYPE_DELIVER        = 0x01;
    public static final int MESSAGE_TYPE_SUBMIT         = 0x02;
    public static final int MESSAGE_TYPE_CANCELLATION   = 0x03;
    public static final int MESSAGE_TYPE_DELIVERY_ACK   = 0x04;
    public static final int MESSAGE_TYPE_USER_ACK       = 0x05;
    public static final int MESSAGE_TYPE_READ_ACK       = 0x06;
    public static final int MESSAGE_TYPE_DELIVER_REPORT = 0x07;
    public static final int MESSAGE_TYPE_SUBMIT_REPORT  = 0x08;
    public static final int PRIORITY_NORMAL        = 0x0;
    public static final int PRIORITY_INTERACTIVE   = 0x1;
    public static final int PRIORITY_URGENT        = 0x2;
    public static final int PRIORITY_EMERGENCY     = 0x3;
    public static final int PRIVACY_NOT_RESTRICTED = 0x0;
    public static final int PRIVACY_RESTRICTED     = 0x1;
    public static final int PRIVACY_CONFIDENTIAL   = 0x2;
    public static final int PRIVACY_SECRET         = 0x3;
    public static final int ALERT_DEFAULT          = 0x0;
    public static final int ALERT_LOW_PRIO         = 0x1;
    public static final int ALERT_MEDIUM_PRIO      = 0x2;
    public static final int ALERT_HIGH_PRIO        = 0x3;
    public static final int DISPLAY_MODE_IMMEDIATE      = 0x0;
    public static final int DISPLAY_MODE_DEFAULT        = 0x1;
    public static final int DISPLAY_MODE_USER           = 0x2;
    public static final int LANGUAGE_UNKNOWN  = 0x00;
    public static final int LANGUAGE_ENGLISH  = 0x01;
    public static final int LANGUAGE_FRENCH   = 0x02;
    public static final int LANGUAGE_SPANISH  = 0x03;
    public static final int LANGUAGE_JAPANESE = 0x04;
    public static final int LANGUAGE_KOREAN   = 0x05;
    public static final int LANGUAGE_CHINESE  = 0x06;
    public static final int LANGUAGE_HEBREW   = 0x07;
    public static final int ERROR_NONE                   = 0x00;
    public static final int STATUS_ACCEPTED              = 0x00;
    public static final int STATUS_DEPOSITED_TO_INTERNET = 0x01;
    public static final int STATUS_DELIVERED             = 0x02;
    public static final int STATUS_CANCELLED             = 0x03;
    public static final int ERROR_TEMPORARY              = 0x02;
    public static final int STATUS_NETWORK_CONGESTION    = 0x04;
    public static final int STATUS_NETWORK_ERROR         = 0x05;
    public static final int STATUS_UNKNOWN_ERROR         = 0x1F;
    public static final int ERROR_PERMANENT              = 0x03;
    public static final int STATUS_CANCEL_FAILED         = 0x06;
    public static final int STATUS_BLOCKED_DESTINATION   = 0x07;
    public static final int STATUS_TEXT_TOO_LONG         = 0x08;
    public static final int STATUS_DUPLICATE_MESSAGE     = 0x09;
    public static final int STATUS_INVALID_DESTINATION   = 0x0A;
    public static final int STATUS_MESSAGE_EXPIRED       = 0x0D;
    public static final int ERROR_UNDEFINED              = 0xFF;
    public static final int STATUS_UNDEFINED             = 0xFF;
    public static final int RELATIVE_TIME_MINS_LIMIT      = 143;
    public static final int RELATIVE_TIME_HOURS_LIMIT     = 167;
    public static final int RELATIVE_TIME_DAYS_LIMIT      = 196;
    public static final int RELATIVE_TIME_WEEKS_LIMIT     = 244;
    public static final int RELATIVE_TIME_INDEFINITE      = 245;
    public static final int RELATIVE_TIME_NOW             = 246;
    public static final int RELATIVE_TIME_MOBILE_INACTIVE = 247;
    public static final int RELATIVE_TIME_RESERVED        = 248;
}

