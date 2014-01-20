package com.android.internal.telephony.cdma.sms;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import static android.telephony.SmsMessage.ENCODING_16BIT;
import static android.telephony.SmsMessage.MAX_USER_DATA_BYTES;
import static android.telephony.SmsMessage.MAX_USER_DATA_BYTES_WITH_HEADER;

import java.util.TimeZone;

import android.content.res.Resources;
import android.telephony.SmsMessage;
import android.text.format.Time;
import android.util.Log;

import com.android.internal.telephony.GsmAlphabet;
import com.android.internal.telephony.IccUtils;
import com.android.internal.telephony.SmsHeader;
import com.android.internal.telephony.SmsMessageBase.TextEncodingDetails;
import com.android.internal.util.BitwiseInputStream;
import com.android.internal.util.BitwiseOutputStream;

public final class BearerData {

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.822 -0500", hash_original_method = "C8440B4B5249951B0460180E0996DCC0", hash_generated_method = "FA9866DE9E0EBCC74C058B4FAECAE16B")
    
private static void encodeMessageId(BearerData bData, BitwiseOutputStream outStream)
        throws BitwiseOutputStream.AccessException
    {
        outStream.write(8, 3);
        outStream.write(4, bData.messageType);
        outStream.write(8, bData.messageId >> 8);
        outStream.write(8, bData.messageId);
        outStream.write(1, bData.hasUserDataHeader ? 1 : 0);
        outStream.skip(3);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.830 -0500", hash_original_method = "45CCF9FC6BBE2266C382A19B24C2C3B0", hash_generated_method = "3B561D8B62665EB2FD102C8FE0C61698")
    
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

    /**
     * Calculate the message text encoding length, fragmentation, and other details.
     *
     * @param msg message text
     * @param force7BitEncoding ignore (but still count) illegal characters if true
     * @return septet count, or -1 on failure
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.833 -0500", hash_original_method = "6B08EB07811C6437ABA5F29C5CF7EE01", hash_generated_method = "D2B13765670B9BA356FC0487FE019689")
    
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
                // We don't support single-segment EMS, so calculate for 16-bit
                // TODO: Consider supporting single-segment EMS
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.836 -0500", hash_original_method = "91C355610BEE9F119AA057EC1B5B9E18", hash_generated_method = "B34A37701351C2D499E5BC2DCFABCAD0")
    
private static byte[] encode7bitAscii(String msg, boolean force)
        throws CodingException
    {
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.841 -0500", hash_original_method = "5DF4ACCAFFF22D1CDA83BC54321F8332", hash_generated_method = "2729D69952FA805225C1DCDED77AF55E")
    
private static byte[] encodeUtf16(String msg)
        throws CodingException
    {
        try {
            return msg.getBytes("utf-16be");
        } catch (java.io.UnsupportedEncodingException ex) {
            throw new CodingException("UTF-16 encode failed: " + ex);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.851 -0500", hash_original_method = "CA4EA0E920693DD81359CEDE79E84C00", hash_generated_method = "4F95D4DCA844B4B846C4D13DE10B1BB2")
    
private static Gsm7bitCodingResult encode7bitGsm(String msg, int septetOffset, boolean force)
        throws CodingException
    {
        try {
            /*
             * TODO(cleanup): It would be nice if GsmAlphabet provided
             * an option to produce just the data without prepending
             * the septet count, as this function is really just a
             * wrapper to strip that off.  Not to mention that the
             * septet count is generally known prior to invocation of
             * the encoder.  Note that it cannot be derived from the
             * resulting array length, since that cannot distinguish
             * if the last contains either 1 or 8 valid bits.
             *
             * TODO(cleanup): The BitwiseXStreams could also be
             * extended with byte-wise reversed endianness read/write
             * routines to allow a corresponding implementation of
             * stringToGsm7BitPacked, and potentially directly support
             * access to the main bitwise stream from encode/decode.
             */
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.854 -0500", hash_original_method = "5F838063F0B141F65631125BC7CC38DD", hash_generated_method = "FB87166E076E652E9F95FE9EFD65391E")
    
private static void encode7bitEms(UserData uData, byte[] udhData, boolean force)
        throws CodingException
    {
        int udhBytes = udhData.length + 1;  // Add length octet.
        int udhSeptets = ((udhBytes * 8) + 6) / 7;
        Gsm7bitCodingResult gcr = encode7bitGsm(uData.payloadStr, udhSeptets, force);
        uData.msgEncoding = UserData.ENCODING_GSM_7BIT_ALPHABET;
        uData.msgEncodingSet = true;
        uData.numFields = gcr.septets;
        uData.payload = gcr.data;
        uData.payload[0] = (byte)udhData.length;
        System.arraycopy(udhData, 0, uData.payload, 1, udhData.length);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.857 -0500", hash_original_method = "7033638EB6D76A8EF1270FE61E5C8913", hash_generated_method = "6A6575B7D28F31F0634D0A483209977D")
    
private static void encode16bitEms(UserData uData, byte[] udhData)
        throws CodingException
    {
        byte[] payload = encodeUtf16(uData.payloadStr);
        int udhBytes = udhData.length + 1;  // Add length octet.
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.860 -0500", hash_original_method = "A4489840F8F0AB7CD46376C0433D5DEC", hash_generated_method = "2701996644D0BB50A6CB89FA82F8F349")
    
private static void encodeEmsUserDataPayload(UserData uData)
        throws CodingException
    {
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.864 -0500", hash_original_method = "4E9E7A33D89CCEFB6DB4C49B1926C5C6", hash_generated_method = "68F825D930631A65A4453F4784DAB2AC")
    
private static void encodeUserDataPayload(UserData uData)
        throws CodingException
    {
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.868 -0500", hash_original_method = "D961044B5677DD1E2D66ABA393A33F76", hash_generated_method = "3411014163B14FEA1F532568C00D5633")
    
private static void encodeUserData(BearerData bData, BitwiseOutputStream outStream)
        throws BitwiseOutputStream.AccessException, CodingException
    {
        /*
         * TODO(cleanup): Do we really need to set userData.payload as
         * a side effect of encoding?  If not, we could avoid data
         * copies by passing outStream directly.
         */
        encodeUserDataPayload(bData.userData);
        bData.hasUserDataHeader = bData.userData.userDataHeader != null;

        if (bData.userData.payload.length > SmsMessage.MAX_USER_DATA_BYTES) {
            throw new CodingException("encoded user data too large (" +
                                      bData.userData.payload.length +
                                      " > " + SmsMessage.MAX_USER_DATA_BYTES + " bytes)");
        }

        /*
         * TODO(cleanup): figure out what the right answer is WRT paddingBits field
         *
         *   userData.paddingBits = (userData.payload.length * 8) - (userData.numFields * 7);
         *   userData.paddingBits = 0; // XXX this seems better, but why?
         *
         */
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.870 -0500", hash_original_method = "9AA3A2721795859BDBEE9278794F1EAF", hash_generated_method = "128190140A42D44530A6B506F292B00E")
    
private static void encodeReplyOption(BearerData bData, BitwiseOutputStream outStream)
        throws BitwiseOutputStream.AccessException
    {
        outStream.write(8, 1);
        outStream.write(1, bData.userAckReq     ? 1 : 0);
        outStream.write(1, bData.deliveryAckReq ? 1 : 0);
        outStream.write(1, bData.readAckReq     ? 1 : 0);
        outStream.write(1, bData.reportReq      ? 1 : 0);
        outStream.write(4, 0);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.873 -0500", hash_original_method = "145B537C285486FDF388CB1D49BC658C", hash_generated_method = "348077A4D5CECB075EF423A41661F3C7")
    
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

    /*
     * TODO(cleanup): CdmaSmsAddress encoding should make use of
     * CdmaSmsAddress.parse provided that DTMF encoding is unified,
     * and the difference in 4-bit vs. 8-bit is resolved.
     */

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.876 -0500", hash_original_method = "E0D8BC2FB733B97D4B84758B4B732CFB", hash_generated_method = "D9C5502EE73831DB1993CE1ECDD537DD")
    
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.879 -0500", hash_original_method = "4AD2B9904764EF519DAE910AE53084AC", hash_generated_method = "3FA94612ADDD794FEACCD9817B86FD2C")
    
private static void encodeCallbackNumber(BearerData bData, BitwiseOutputStream outStream)
        throws BitwiseOutputStream.AccessException, CodingException
    {
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.881 -0500", hash_original_method = "40D56C36E677F312FE390FA3CD6739EB", hash_generated_method = "9EA53459644D33AD109C3CB2EA4F58E5")
    
private static void encodeMsgStatus(BearerData bData, BitwiseOutputStream outStream)
        throws BitwiseOutputStream.AccessException
    {
        outStream.write(8, 1);
        outStream.write(2, bData.errorClass);
        outStream.write(6, bData.messageStatus);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.884 -0500", hash_original_method = "B066D5B97CE0C4B0F8C8E9DF62137DA2", hash_generated_method = "B799D47987141ED2E80DA42BB02FDF06")
    
private static void encodeMsgCount(BearerData bData, BitwiseOutputStream outStream)
        throws BitwiseOutputStream.AccessException
    {
        outStream.write(8, 1);
        outStream.write(8, bData.numberOfMessages);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.887 -0500", hash_original_method = "62291A77DBFA4C919FF73895F4C94439", hash_generated_method = "565229793C500D32C211A542FEEADD6D")
    
private static void encodeValidityPeriodRel(BearerData bData, BitwiseOutputStream outStream)
        throws BitwiseOutputStream.AccessException
    {
        outStream.write(8, 1);
        outStream.write(8, bData.validityPeriodRelative);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.890 -0500", hash_original_method = "38925A3103B0642972D74B5CCA5C4E6C", hash_generated_method = "5E9D01A14813DB532B6457CDB26762DF")
    
private static void encodePrivacyIndicator(BearerData bData, BitwiseOutputStream outStream)
        throws BitwiseOutputStream.AccessException
    {
        outStream.write(8, 1);
        outStream.write(2, bData.privacy);
        outStream.skip(6);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.892 -0500", hash_original_method = "AE5D89FF794A34715DD9D23D6669FE26", hash_generated_method = "66CC667E7A3DAAD97D884E2C39FFA765")
    
private static void encodeLanguageIndicator(BearerData bData, BitwiseOutputStream outStream)
        throws BitwiseOutputStream.AccessException
    {
        outStream.write(8, 1);
        outStream.write(8, bData.language);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.895 -0500", hash_original_method = "EC15F8B60508169BAD62310FB6E7B62C", hash_generated_method = "B3861987E5CBF8354520E18A6BA47F9D")
    
private static void encodeDisplayMode(BearerData bData, BitwiseOutputStream outStream)
        throws BitwiseOutputStream.AccessException
    {
        outStream.write(8, 1);
        outStream.write(2, bData.displayMode);
        outStream.skip(6);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.897 -0500", hash_original_method = "3615FE986595FC6130C29894F12AA6C9", hash_generated_method = "0AEE5E65B6E327D7FEDFA8C1E6B871A8")
    
private static void encodePriorityIndicator(BearerData bData, BitwiseOutputStream outStream)
        throws BitwiseOutputStream.AccessException
    {
        outStream.write(8, 1);
        outStream.write(2, bData.priority);
        outStream.skip(6);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.900 -0500", hash_original_method = "397B6C49F7435C6B9291006B0E5CA067", hash_generated_method = "68A3CC721BE956233BC07D611C5E7AB8")
    
private static void encodeMsgDeliveryAlert(BearerData bData, BitwiseOutputStream outStream)
        throws BitwiseOutputStream.AccessException
    {
        outStream.write(8, 1);
        outStream.write(2, bData.alert);
        outStream.skip(6);
    }

    /**
     * Create serialized representation for BearerData object.
     * (See 3GPP2 C.R1001-F, v1.0, section 4.5 for layout details)
     *
     * @param bData an instance of BearerData.
     *
     * @return byte array of raw encoded SMS bearer data.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.904 -0500", hash_original_method = "0DC00ECED2377219DA9814104C103031", hash_generated_method = "A20D525512F1D32F192CDD5423DF454C")
    
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.907 -0500", hash_original_method = "923C845F84F5C6F3155DABBB92C6DE2E", hash_generated_method = "16709A57212C08B8A6DA2BA619E65CB4")
    
private static boolean decodeMessageId(BearerData bData, BitwiseInputStream inStream)
        throws BitwiseInputStream.AccessException, CodingException
    {
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.910 -0500", hash_original_method = "F5B8D6E554376177A61DA467E9B8453E", hash_generated_method = "753C11D25CE5011154EF0D60756BFB80")
    
private static boolean decodeUserData(BearerData bData, BitwiseInputStream inStream)
        throws BitwiseInputStream.AccessException
    {
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.912 -0500", hash_original_method = "B88592DD561D7BE4EA02EB193ADE417D", hash_generated_method = "A172CF350931CE4E4CADB4EC23CB854A")
    
private static String decodeUtf8(byte[] data, int offset, int numFields)
        throws CodingException
    {
        try {
            return new String(data, offset, numFields, "UTF-8");
        } catch (java.io.UnsupportedEncodingException ex) {
            throw new CodingException("UTF-8 decode failed: " + ex);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.915 -0500", hash_original_method = "29926604C70FE73490D2AFB0EFFA3811", hash_generated_method = "56EFD4D116CC64741554CDC56157C6A8")
    
private static String decodeUtf16(byte[] data, int offset, int numFields)
        throws CodingException
    {
        // Start reading from the next 16-bit aligned boundary after offset.
        int padding = offset % 2;
        numFields -= (offset + padding) / 2;
        try {
            return new String(data, offset, numFields * 2, "utf-16be");
        } catch (java.io.UnsupportedEncodingException ex) {
            throw new CodingException("UTF-16 decode failed: " + ex);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.918 -0500", hash_original_method = "A2E3D42851B4A12F82658D4CF7E558E6", hash_generated_method = "8B00CEA38BA8F57C6D404113CFA6072E")
    
private static String decode7bitAscii(byte[] data, int offset, int numFields)
        throws CodingException
    {
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
                    /* For other charCodes, they are unprintable, and so simply use SPACE. */
                    strBuf.append(' ');
                }
            }
            return strBuf.toString();
        } catch (BitwiseInputStream.AccessException ex) {
            throw new CodingException("7bit ASCII decode failed: " + ex);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.921 -0500", hash_original_method = "2BBEF1F919895529A7B92F9F319B970F", hash_generated_method = "4F7AE1FF33F63C303787B8CFE92F06C3")
    
private static String decode7bitGsm(byte[] data, int offset, int numFields)
        throws CodingException
    {
        // Start reading from the next 7-bit aligned boundary after offset.
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.923 -0500", hash_original_method = "1666BB823F4365D840FAE30FB0402662", hash_generated_method = "65E9803E8CED5E48CED1412496A6EC53")
    
private static String decodeLatin(byte[] data, int offset, int numFields)
        throws CodingException
    {
        try {
            return new String(data, offset, numFields - offset, "ISO-8859-1");
        } catch (java.io.UnsupportedEncodingException ex) {
            throw new CodingException("ISO-8859-1 decode failed: " + ex);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.927 -0500", hash_original_method = "8FE95FBAC86FD32B593F5D6A76FB895E", hash_generated_method = "B3801A795C5808716148EDCD3D37E685")
    
private static void decodeUserDataPayload(UserData userData, boolean hasUserDataHeader)
        throws CodingException
    {
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
            /*
            *  Octet decoding depends on the carrier service.
            */
            boolean decodingtypeUTF8 = Resources.getSystem()
                    .getBoolean(com.android.internal.R.bool.config_sms_utf8_support);

            // Strip off any padding bytes, meaning any differences between the length of the
            // array and the target length specified by numFields.  This is to avoid any
            // confusion by code elsewhere that only considers the payload array length.
            byte[] payload = new byte[userData.numFields];
            int copyLen = userData.numFields < userData.payload.length
                    ? userData.numFields : userData.payload.length;

            System.arraycopy(userData.payload, 0, payload, 0, copyLen);
            userData.payload = payload;

            if (!decodingtypeUTF8) {
                // There are many devices in the market that send 8bit text sms (latin encoded) as
                // octet encoded.
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

    /**
     * IS-91 Voice Mail message decoding
     * (See 3GPP2 C.S0015-A, Table 4.3.1.4.1-1)
     * (For character encodings, see TIA/EIA/IS-91, Annex B)
     *
     * Protocol Summary: The user data payload may contain 3-14
     * characters.  The first two characters are parsed as a number
     * and indicate the number of voicemails.  The third character is
     * either a SPACE or '!' to indicate normal or urgent priority,
     * respectively.  Any following characters are treated as normal
     * text user data payload.
     *
     * Note that the characters encoding is 6-bit packed.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.931 -0500", hash_original_method = "11C583A748C5126F7632A70965DAF4B7", hash_generated_method = "106AED6AFFFEAC4EFF5136245DD51CBA")
    
private static void decodeIs91VoicemailStatus(BearerData bData)
        throws BitwiseInputStream.AccessException, CodingException
    {
        BitwiseInputStream inStream = new BitwiseInputStream(bData.userData.payload);
        int dataLen = inStream.available() / 6;  // 6-bit packed character encoding.
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

    /**
     * IS-91 Short Message decoding
     * (See 3GPP2 C.S0015-A, Table 4.3.1.4.1-1)
     * (For character encodings, see TIA/EIA/IS-91, Annex B)
     *
     * Protocol Summary: The user data payload may contain 1-14
     * characters, which are treated as normal text user data payload.
     * Note that the characters encoding is 6-bit packed.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.934 -0500", hash_original_method = "060A9EEF28BA2151837477F91B43F7FB", hash_generated_method = "4FB634BF302A3B38AE7DC3F2E3F82FB5")
    
private static void decodeIs91ShortMessage(BearerData bData)
        throws BitwiseInputStream.AccessException, CodingException
    {
        BitwiseInputStream inStream = new BitwiseInputStream(bData.userData.payload);
        int dataLen = inStream.available() / 6;  // 6-bit packed character encoding.
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

    /**
     * IS-91 CLI message (callback number) decoding
     * (See 3GPP2 C.S0015-A, Table 4.3.1.4.1-1)
     *
     * Protocol Summary: The data payload may contain 1-32 digits,
     * encoded using standard 4-bit DTMF, which are treated as a
     * callback number.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.937 -0500", hash_original_method = "D142CB8A8401CEBF28BCC073ADA26748", hash_generated_method = "373B09AAC78224AA682522BE6B8FA27F")
    
private static void decodeIs91Cli(BearerData bData) throws CodingException {
        BitwiseInputStream inStream = new BitwiseInputStream(bData.userData.payload);
        int dataLen = inStream.available() / 4;  // 4-bit packed DTMF digit encoding.
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.939 -0500", hash_original_method = "109ABA3A30E199287EB04CAB6B02E375", hash_generated_method = "649E9740F601EA23CD5D1CBC45528112")
    
private static void decodeIs91(BearerData bData)
        throws BitwiseInputStream.AccessException, CodingException
    {
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.942 -0500", hash_original_method = "E24DF7CFD7741E5C7CB66CF0BBA61C19", hash_generated_method = "CE4F112230DDF2F546524B03603BF15D")
    
private static boolean decodeReplyOption(BearerData bData, BitwiseInputStream inStream)
        throws BitwiseInputStream.AccessException, CodingException
    {
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.945 -0500", hash_original_method = "B7DA0193C1F0E29A3C9A95B701317994", hash_generated_method = "41F808E9E6D6FE7929E45EB1EC3912DE")
    
private static boolean decodeMsgCount(BearerData bData, BitwiseInputStream inStream)
        throws BitwiseInputStream.AccessException, CodingException
    {
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.949 -0500", hash_original_method = "E2815FE9E78B59C1196C5265558ADE24", hash_generated_method = "D862F305FFD47EBE1FEB2D3FFED831B2")
    
private static boolean decodeDepositIndex(BearerData bData, BitwiseInputStream inStream)
        throws BitwiseInputStream.AccessException, CodingException
    {
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.952 -0500", hash_original_method = "05A2FAD69F38ED087E94B9E189DD8CF0", hash_generated_method = "DBA118A49F03EBB1354F504479BFB46A")
    
private static String decodeDtmfSmsAddress(byte[] rawData, int numFields)
        throws CodingException
    {
        /* DTMF 4-bit digit encoding, defined in at
         * 3GPP2 C.S005-D, v2.0, table 2.7.1.3.2.4-4 */
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.954 -0500", hash_original_method = "07134771082B158670F9BBEB576EFC00", hash_generated_method = "3F8F868EC66482C23CBD8D6B4A6E207E")
    
private static void decodeSmsAddress(CdmaSmsAddress addr) throws CodingException {
        if (addr.digitMode == CdmaSmsAddress.DIGIT_MODE_8BIT_CHAR) {
            try {
                /* As specified in 3GPP2 C.S0015-B, v2, 4.5.15 -- actually
                 * just 7-bit ASCII encoding, with the MSB being zero. */
                addr.address = new String(addr.origBytes, 0, addr.origBytes.length, "US-ASCII");
            } catch (java.io.UnsupportedEncodingException ex) {
                throw new CodingException("invalid SMS address ASCII code");
            }
        } else {
            addr.address = decodeDtmfSmsAddress(addr.origBytes, addr.numberOfDigits);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.958 -0500", hash_original_method = "F2DBCC59FA7C535660772894A9C035EF", hash_generated_method = "72DE8FA51832B259C8A6BE024F8B6BC0")
    
private static boolean decodeCallbackNumber(BearerData bData, BitwiseInputStream inStream)
        throws BitwiseInputStream.AccessException, CodingException
    {
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.961 -0500", hash_original_method = "4C657FE6B6C6A98999E77FAF28124251", hash_generated_method = "DBA14E9850132EB85C2FBC01FC80C3AD")
    
private static boolean decodeMsgStatus(BearerData bData, BitwiseInputStream inStream)
        throws BitwiseInputStream.AccessException, CodingException
    {
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.963 -0500", hash_original_method = "AD019ACB8EA466739D545F6EFCB467DE", hash_generated_method = "F5F5882ADECE914B4AD85179347D3257")
    
private static boolean decodeMsgCenterTimeStamp(BearerData bData, BitwiseInputStream inStream)
        throws BitwiseInputStream.AccessException, CodingException
    {
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.966 -0500", hash_original_method = "6422694027F3414640C09CE3A0B4639B", hash_generated_method = "B50CE842CB10FFDB13F144724A58700E")
    
private static boolean decodeValidityAbs(BearerData bData, BitwiseInputStream inStream)
        throws BitwiseInputStream.AccessException, CodingException
    {
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.969 -0500", hash_original_method = "5924CBF7BA5FE313E58D9F30B885ADAB", hash_generated_method = "18A98E6B861BCA1CA879B79E6C32FF6E")
    
private static boolean decodeDeferredDeliveryAbs(BearerData bData, BitwiseInputStream inStream)
        throws BitwiseInputStream.AccessException, CodingException
    {
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.972 -0500", hash_original_method = "EEF778150D7C2C7BE621DC9A5F784533", hash_generated_method = "B3F0B34E17AA97127696F624E5A83968")
    
private static boolean decodeValidityRel(BearerData bData, BitwiseInputStream inStream)
        throws BitwiseInputStream.AccessException, CodingException
    {
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.974 -0500", hash_original_method = "C853F9ACBB971D28351D63FF9F0BA3C8", hash_generated_method = "FB80D2DBDFFF1D28E6ECC10E55BC4150")
    
private static boolean decodeDeferredDeliveryRel(BearerData bData, BitwiseInputStream inStream)
        throws BitwiseInputStream.AccessException, CodingException
    {
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.978 -0500", hash_original_method = "DE548435765F76D91D91A1AFBA22C349", hash_generated_method = "1209AC6B4571452AF7B9C3728577FB5C")
    
private static boolean decodePrivacyIndicator(BearerData bData, BitwiseInputStream inStream)
        throws BitwiseInputStream.AccessException, CodingException
    {
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.981 -0500", hash_original_method = "2B34FAF3BF7167101350848AE7AE2B5E", hash_generated_method = "3BB9E133395645FEC9140A3D938B72D1")
    
private static boolean decodeLanguageIndicator(BearerData bData, BitwiseInputStream inStream)
        throws BitwiseInputStream.AccessException, CodingException
    {
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.984 -0500", hash_original_method = "D7D5F0FE94672665DAD8D39209E46552", hash_generated_method = "38006448C3360909685BB024711A892A")
    
private static boolean decodeDisplayMode(BearerData bData, BitwiseInputStream inStream)
        throws BitwiseInputStream.AccessException, CodingException
    {
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.987 -0500", hash_original_method = "A6F5010B57ABFA30013AE64166D804D6", hash_generated_method = "3272DD8D375AC0BB4834E7E82A70D7FE")
    
private static boolean decodePriorityIndicator(BearerData bData, BitwiseInputStream inStream)
        throws BitwiseInputStream.AccessException, CodingException
    {
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.990 -0500", hash_original_method = "EDC73F8B955E61094495F0071001FC68", hash_generated_method = "9FB4574120A6DFA3583EFDA0F4E7BDFE")
    
private static boolean decodeMsgDeliveryAlert(BearerData bData, BitwiseInputStream inStream)
        throws BitwiseInputStream.AccessException, CodingException
    {
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.993 -0500", hash_original_method = "8C0053F177150406639891A416F80AA8", hash_generated_method = "09DF8B0BC2AA93B0A5375CD1701723E9")
    
private static boolean decodeUserResponseCode(BearerData bData, BitwiseInputStream inStream)
        throws BitwiseInputStream.AccessException, CodingException
    {
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

    /**
     * Create BearerData object from serialized representation.
     * (See 3GPP2 C.R1001-F, v1.0, section 4.5 for layout details)
     *
     * @param smsData byte array of raw encoded SMS bearer data.
     *
     * @return an instance of BearerData.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.998 -0500", hash_original_method = "A8EF5648BDA276CD13AE7067E9EC61AB", hash_generated_method = "90B84465273DB897B22795818393AFD9")
    
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.514 -0500", hash_original_field = "C996BA564C8E7280B21DCC0E50132626", hash_generated_field = "0BE9B8D4C56001BB37DC60A2B9FCBDE7")

    private final static String LOG_TAG = "SMS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.517 -0500", hash_original_field = "45D664C16BF9B6CDA6E96880BB536F9D", hash_generated_field = "7E895720D23FA19E43E399ABF830C73E")

    private final static byte SUBPARAM_MESSAGE_IDENTIFIER               = 0x00;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.520 -0500", hash_original_field = "1377317DD895A838D1F355CF61B84C10", hash_generated_field = "9A28A70E2FDDC9AE64611945D661E474")

    private final static byte SUBPARAM_USER_DATA                        = 0x01;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.522 -0500", hash_original_field = "CBD98CDB489417865E3ADD5D1C0B82E8", hash_generated_field = "4273ED21E43C74A260C42E33274CC00E")

    private final static byte SUBPARAM_USER_RESPONSE_CODE               = 0x02;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.525 -0500", hash_original_field = "E4BE5497995C6AAA72574E83463D33DF", hash_generated_field = "2E4E6A1BAD2C888392A01ACF47392343")

    private final static byte SUBPARAM_MESSAGE_CENTER_TIME_STAMP        = 0x03;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.528 -0500", hash_original_field = "B1356B8BF5D094A0031F64117805B507", hash_generated_field = "C0D7F314C848DCA3C09097670573B422")

    private final static byte SUBPARAM_VALIDITY_PERIOD_ABSOLUTE         = 0x04;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.530 -0500", hash_original_field = "2E3F3182636BA0F7494CA2E3252BB662", hash_generated_field = "DC4D3944898871E95504CA8EF34A0010")

    private final static byte SUBPARAM_VALIDITY_PERIOD_RELATIVE         = 0x05;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.532 -0500", hash_original_field = "A838985365573058CED6A5D67D8B8B9F", hash_generated_field = "B4E139080D24CEBCCB502B2E7A21236E")

    private final static byte SUBPARAM_DEFERRED_DELIVERY_TIME_ABSOLUTE  = 0x06;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.535 -0500", hash_original_field = "2F3AD54375175EAB8E9B744DD77B2615", hash_generated_field = "7EC97FC60B7691AE93E9B6C2F99A8E95")

    private final static byte SUBPARAM_DEFERRED_DELIVERY_TIME_RELATIVE  = 0x07;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.537 -0500", hash_original_field = "1179E11FC39562CDE735F7DAC198EE48", hash_generated_field = "815333FE11FDD92016D60D9669417089")

    private final static byte SUBPARAM_PRIORITY_INDICATOR               = 0x08;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.541 -0500", hash_original_field = "89A0C03EE24D11CAF5188E196A3D7ACE", hash_generated_field = "BC24C42A4502D6251B6BE713271D49A3")

    private final static byte SUBPARAM_PRIVACY_INDICATOR                = 0x09;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.544 -0500", hash_original_field = "7ABEBDA585167C735D781DA3FC8B4621", hash_generated_field = "31B4A3F86CE9C26E51D6FA2D0BE17044")

    private final static byte SUBPARAM_REPLY_OPTION                     = 0x0A;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.546 -0500", hash_original_field = "6C7A0EDDF133BF0534AC7145607060FC", hash_generated_field = "9B6CEC7AE0826D5411F673F1D22331F7")

    private final static byte SUBPARAM_NUMBER_OF_MESSAGES               = 0x0B;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.549 -0500", hash_original_field = "938766538B21DE1622F226548A2310A4", hash_generated_field = "E9DD60510364DE379075B1C9A6A9B448")

    private final static byte SUBPARAM_ALERT_ON_MESSAGE_DELIVERY        = 0x0C;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.551 -0500", hash_original_field = "F69B5B2C8ADEE59D2C2152A2C201E8D9", hash_generated_field = "FEA816A3D9B26EE2CC6E34282F2DCDFB")

    private final static byte SUBPARAM_LANGUAGE_INDICATOR               = 0x0D;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.554 -0500", hash_original_field = "6437970B38ACE1DDD1543BDD02D702BA", hash_generated_field = "3D8210471C10299E7DF05508CFF4F68B")

    private final static byte SUBPARAM_CALLBACK_NUMBER                  = 0x0E;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.557 -0500", hash_original_field = "9AF506D9F0E9FB9D361420940A16818A", hash_generated_field = "13B7B4A704E90C561470C1889033DC93")

    private final static byte SUBPARAM_MESSAGE_DISPLAY_MODE             = 0x0F;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.559 -0500", hash_original_field = "EAD6150DC2778E56C8BC6AC0A7FCCAC7", hash_generated_field = "8A30871E7EF057C171C8A572DC0EFC07")

    private final static byte SUBPARAM_MESSAGE_DEPOSIT_INDEX            = 0x11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.561 -0500", hash_original_field = "B9B746DC18CF723650AFA809D4896CB8", hash_generated_field = "55410CF8E20F30E2E4E62BD0AA0C025A")

    //private final static byte SUBPARAM_SERVICE_CATEGORY_PROGRAM_RESULTS = 0x13;
    private final static byte SUBPARAM_MESSAGE_STATUS                   = 0x14;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.564 -0500", hash_original_field = "C0D4BA82786ED01786D5D4A6392EEA9E", hash_generated_field = "6F2D8D006C19460D4112E76E78702D28")

    //private final static byte SUBPARAM_ENHANCED_VMN                     = 0x16;
    //private final static byte SUBPARAM_ENHANCED_VMN_ACK                 = 0x17;

    /**
     * Supported message types for CDMA SMS messages
     * (See 3GPP2 C.S0015-B, v2.0, table 4.5.1-1)
     */
    public static final int MESSAGE_TYPE_DELIVER        = 0x01;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.566 -0500", hash_original_field = "8CD9F9706C5692FE51B4DAB26D740007", hash_generated_field = "031A242F3842AD4D24E88218BFAABD11")

    public static final int MESSAGE_TYPE_SUBMIT         = 0x02;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.569 -0500", hash_original_field = "05902FD37C8D22101867EBA1E001466B", hash_generated_field = "CB84DF64AB5D7EFF6D68DB66CEF0EFFA")

    public static final int MESSAGE_TYPE_CANCELLATION   = 0x03;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.572 -0500", hash_original_field = "5006EB44306173FB9618E5007FFA82AD", hash_generated_field = "C6118AE030C84A0D8A79351310A303FB")

    public static final int MESSAGE_TYPE_DELIVERY_ACK   = 0x04;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.575 -0500", hash_original_field = "67581E289ADE4302678B1DA31031C1AE", hash_generated_field = "D3E301021704CCC30564CF4178785FCB")

    public static final int MESSAGE_TYPE_USER_ACK       = 0x05;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.578 -0500", hash_original_field = "A4C4C996169F29D7465F1BBD70421D62", hash_generated_field = "57300DC0D37C2DEFB87C46AE25307B2F")

    public static final int MESSAGE_TYPE_READ_ACK       = 0x06;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.580 -0500", hash_original_field = "89F75B7200C9029FB4CDAFFF50F26138", hash_generated_field = "2BF129AB6BE31531BF4B305979DBCCAD")

    public static final int MESSAGE_TYPE_DELIVER_REPORT = 0x07;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.583 -0500", hash_original_field = "EE19CE8D5915B414590E8FDD7A6F35F4", hash_generated_field = "8753CB8136240C0C2690F71B901E2930")

    public static final int MESSAGE_TYPE_SUBMIT_REPORT  = 0x08;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.590 -0500", hash_original_field = "80CC60054D24E1B93F11BCA3B2889547", hash_generated_field = "B13E523EEA6650D52D37BFEF8BF03C51")

    public static final int PRIORITY_NORMAL        = 0x0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.592 -0500", hash_original_field = "D5C74154014A7AA9D9F9DCCED234192B", hash_generated_field = "621D526584A68648DD799F460F586FE7")

    public static final int PRIORITY_INTERACTIVE   = 0x1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.595 -0500", hash_original_field = "4931996380C9847975B90B93EFE94C64", hash_generated_field = "AAFDEAEA3A3FC13D5C959E2E40F87EFD")

    public static final int PRIORITY_URGENT        = 0x2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.597 -0500", hash_original_field = "AE4918AB3D091FA35365391825D34391", hash_generated_field = "DB6F10E2BD45B47A6E8208AAD429644C")

    public static final int PRIORITY_EMERGENCY     = 0x3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.604 -0500", hash_original_field = "9FAC9A38805DF83FE6E51CFD5BD3A339", hash_generated_field = "5502809DEAD6C0F675046EAD2EDC070D")

    public static final int PRIVACY_NOT_RESTRICTED = 0x0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.607 -0500", hash_original_field = "6B2C69C953E54FAB101E069F5C331A01", hash_generated_field = "92980FE0290A64362BE365C13422742C")

    public static final int PRIVACY_RESTRICTED     = 0x1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.609 -0500", hash_original_field = "690BDFEDEF5FA2629C7805FE5F055207", hash_generated_field = "9E9E28EBDE66AB5551E0DBF97B667C29")

    public static final int PRIVACY_CONFIDENTIAL   = 0x2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.612 -0500", hash_original_field = "B6EEA0B39F02799DF856036668DFCE25", hash_generated_field = "B10E9EC23F761D26DC7E6765FA14E45D")

    public static final int PRIVACY_SECRET         = 0x3;
    
    public static class TimeStamp extends Time {

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.739 -0500", hash_original_method = "3C7DB1668D01091724EF1F2E8A911916", hash_generated_method = "54C6882DB2028DAB49784C6ACF58E94C")
        
public static TimeStamp fromByteArray(byte[] data) {
            TimeStamp ts = new TimeStamp();
            // C.S0015-B v2.0, 4.5.4: range is 1996-2095
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

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.736 -0500", hash_original_method = "227CB08289E9E58D2E1A786B0B8104B3", hash_generated_method = "78C48B8E92B103D212B02A82B32484F6")
        
public TimeStamp() {
            super(TimeZone.getDefault().getID());   // 3GPP2 timestamps use the local timezone
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.742 -0500", hash_original_method = "ED297E11B9020980F3FCB379731AD215", hash_generated_method = "5CAF47C4B1E925E4E0D8B0F356E4F50E")
        
@Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("TimeStamp ");
            builder.append("{ year=" + year);
            builder.append(", month=" + month);
            builder.append(", day=" + monthDay);
            builder.append(", hour=" + hour);
            builder.append(", minute=" + minute);
            builder.append(", second=" + second);
            builder.append(" }");
            return builder.toString();
        }
        
    }
    
    private static class CodingException extends Exception {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.812 -0500", hash_original_method = "7A2C15A084F2DA50BCA20CD284E89E4B", hash_generated_method = "4FED4EE0C00A2998CCB9066876496DF7")
        
public CodingException(String s) {
            super(s);
        }
        
    }
    
    private static class Gsm7bitCodingResult {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.844 -0500", hash_original_field = "3D638577AFFE2D6F939C79F75360B6FF", hash_generated_field = "3D638577AFFE2D6F939C79F75360B6FF")

        int septets;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.846 -0500", hash_original_field = "B330DF564CD90A5498A9E4F0AB344BB9", hash_generated_field = "B330DF564CD90A5498A9E4F0AB344BB9")

        byte[] data;
        
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.708 -0400", hash_original_method = "7E9DFC757F4277B439A8F1AFF7D9B860", hash_generated_method = "7E9DFC757F4277B439A8F1AFF7D9B860")
        public Gsm7bitCodingResult ()
        {
            //Synthesized constructor
        }

    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.619 -0500", hash_original_field = "BA22A4A76D5FD376FB7A14BC682D83AB", hash_generated_field = "160382AAA1DBB0AAC0010B402FF60035")

    public static final int ALERT_DEFAULT          = 0x0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.622 -0500", hash_original_field = "E272ED88262FF4360C3A9F28B77AB6E1", hash_generated_field = "93E3C2EEB484F6B9D60F33AF2CCDC0A0")

    public static final int ALERT_LOW_PRIO         = 0x1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.625 -0500", hash_original_field = "5E50BB5F3FBAB2A6DCF53CE959C221BF", hash_generated_field = "598C216B00FA721FB0DF81ABABDE55E0")

    public static final int ALERT_MEDIUM_PRIO      = 0x2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.628 -0500", hash_original_field = "FF3B9DBA4090D029DC5AE27E4B894428", hash_generated_field = "CB00D98DEE8741725800375CF80F4552")

    public static final int ALERT_HIGH_PRIO        = 0x3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.635 -0500", hash_original_field = "D7BC5ECA2366CA06CF74E8AB81BF02F8", hash_generated_field = "48B87FE8CDF87970FFB7311CD17D2E27")

    public static final int DISPLAY_MODE_IMMEDIATE      = 0x0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.637 -0500", hash_original_field = "A218EC3F541B267C6D451BAA524E3499", hash_generated_field = "9916519CCE7C7D9454CCEF8A723C5344")

    public static final int DISPLAY_MODE_DEFAULT        = 0x1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.640 -0500", hash_original_field = "FE3120D9EB766E5C5E6C734D5A4E3B5A", hash_generated_field = "2144934F1F707ADAD734BF5F01E7DABB")

    public static final int DISPLAY_MODE_USER           = 0x2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.647 -0500", hash_original_field = "0784DEE946D4196A2C0E33996455263E", hash_generated_field = "665151E6E97B0C1A5D68722445D54A6D")

    public static final int LANGUAGE_UNKNOWN  = 0x00;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.650 -0500", hash_original_field = "3F2925969E60670B582117376CC4F5D1", hash_generated_field = "4FB0DD20BAF85938611D70BFD1E16BBB")

    public static final int LANGUAGE_ENGLISH  = 0x01;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.652 -0500", hash_original_field = "8530C2726236933D3650E34A02FE11F6", hash_generated_field = "F18793CEFBDCFFC7C6787E50040F1ACC")

    public static final int LANGUAGE_FRENCH   = 0x02;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.654 -0500", hash_original_field = "8E3564A4F94E2E4F9309F1F922BD3D54", hash_generated_field = "26374576D2351929FC66B4B7278915FD")

    public static final int LANGUAGE_SPANISH  = 0x03;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.657 -0500", hash_original_field = "3E93EDC668D371315DAB2A7B47784BAC", hash_generated_field = "C0FD3FB4054094FBF338DD05BCAAFCF0")

    public static final int LANGUAGE_JAPANESE = 0x04;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.659 -0500", hash_original_field = "6B8B5623D834AF20E06EEA704C1FA08A", hash_generated_field = "7670C14EBFAC65E6AF631FF55E18A710")

    public static final int LANGUAGE_KOREAN   = 0x05;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.662 -0500", hash_original_field = "86721F1A2F5983FCC641D33138777BEE", hash_generated_field = "C83F26D00825EC4387D760852EAFA3B0")

    public static final int LANGUAGE_CHINESE  = 0x06;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.665 -0500", hash_original_field = "2621493D96E091DB749C5B0C09EC3ADE", hash_generated_field = "954CBB5F7392B65D7DA53DCF981CE794")

    public static final int LANGUAGE_HEBREW   = 0x07;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.672 -0500", hash_original_field = "301A2EE57951D5B43158FCD5FD058211", hash_generated_field = "4B4277BEB7840EFDE40AB51136F1B947")

    /* no-error codes */
    public static final int ERROR_NONE                   = 0x00;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.675 -0500", hash_original_field = "5888E08A93357F55DEEE7EDAED79994B", hash_generated_field = "20D9A66FB34F5C2FEEF9EFB2952CDC08")

    public static final int STATUS_ACCEPTED              = 0x00;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.678 -0500", hash_original_field = "0DD1E9098ED869DD1656DF07B2BCC93C", hash_generated_field = "98745991576C7D001B37D86906DFDF83")

    public static final int STATUS_DEPOSITED_TO_INTERNET = 0x01;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.680 -0500", hash_original_field = "E0F9C4F0AC20F48A17FD528AC911CB54", hash_generated_field = "000A68F6AC682D6BB9B0E2AF155A60F8")

    public static final int STATUS_DELIVERED             = 0x02;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.683 -0500", hash_original_field = "134864A338BA43FB4A1BD374E82AC3C4", hash_generated_field = "ABB74DFCDF7205EB43CDB604F690CFF8")

    public static final int STATUS_CANCELLED             = 0x03;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.685 -0500", hash_original_field = "29391ACB633B2DC91D2B5C1D39D0ECA5", hash_generated_field = "49F8F1D6210C467FA621247B1CA26347")

    public static final int ERROR_TEMPORARY              = 0x02;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.688 -0500", hash_original_field = "E62960DC881C46A41319D1BEAE6BC9CC", hash_generated_field = "84F01B8266B7F11377E5CC8DC8276BFC")

    public static final int STATUS_NETWORK_CONGESTION    = 0x04;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.691 -0500", hash_original_field = "FAEA4080D908C78ECA5D7BC55182946F", hash_generated_field = "434AC7DE857780B92044192AF5EF4BAE")

    public static final int STATUS_NETWORK_ERROR         = 0x05;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.693 -0500", hash_original_field = "4DB45051111D83453B9B21F6CEF1B6DA", hash_generated_field = "CDCE3F1E9FBCEDF9D7E9770FA2BD8520")

    public static final int STATUS_UNKNOWN_ERROR         = 0x1F;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.695 -0500", hash_original_field = "D77BD8591CA16558BF04AD082439B851", hash_generated_field = "C3776F9D642D640A756F7FEE5691374B")

    public static final int ERROR_PERMANENT              = 0x03;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.698 -0500", hash_original_field = "6C2B66F109EA0DC4F0DC92B8C0456491", hash_generated_field = "28A81AF17D45BD1A67C0CDF352D029CE")

    public static final int STATUS_CANCEL_FAILED         = 0x06;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.700 -0500", hash_original_field = "9977C728F83B8F1ECE5DA8B3C3CA2DE7", hash_generated_field = "D677D29567345BA3290362DB0371EF77")

    public static final int STATUS_BLOCKED_DESTINATION   = 0x07;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.703 -0500", hash_original_field = "851CB39A9AA9DA10E27BDC000B48B4A0", hash_generated_field = "A6ACDA46B349FAEDA8A6FAB5901A87F8")

    public static final int STATUS_TEXT_TOO_LONG         = 0x08;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.706 -0500", hash_original_field = "5025A185755D05538E3C6EFC29FE094A", hash_generated_field = "65852D4340BF670417915CE62F6B3C43")

    public static final int STATUS_DUPLICATE_MESSAGE     = 0x09;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.708 -0500", hash_original_field = "76D9FFE0067A8312234AF96B535F59CB", hash_generated_field = "C407295586236DA5DA90BE81CB3FCD9A")

    public static final int STATUS_INVALID_DESTINATION   = 0x0A;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.711 -0500", hash_original_field = "75D26362B4722C6D505488881723830E", hash_generated_field = "AF06091E20E9218351B8807EA11D30B9")

    public static final int STATUS_MESSAGE_EXPIRED       = 0x0D;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.713 -0500", hash_original_field = "5D69BDEEDE243C7A7E941813FCBCEA22", hash_generated_field = "CF1C380CBF599EC22A7812A0D4C031DF")

    public static final int ERROR_UNDEFINED              = 0xFF;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.716 -0500", hash_original_field = "3DBA18E0377F3072CDB2759666D6BF8B", hash_generated_field = "344A2F467F8570A27356DE9367EF7D53")

    public static final int STATUS_UNDEFINED             = 0xFF;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.753 -0500", hash_original_field = "32F08F95A5BE377801045B805354D9F8", hash_generated_field = "5306C9878D7D475484539D2F3983A394")

    public static final int RELATIVE_TIME_MINS_LIMIT      = 143;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.756 -0500", hash_original_field = "E12819A278728E6F067B54535E61920A", hash_generated_field = "D2E63B61DEDB429DDC6999A23CEB9B60")

    public static final int RELATIVE_TIME_HOURS_LIMIT     = 167;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.759 -0500", hash_original_field = "951AF0966810A6E24825158D7F465534", hash_generated_field = "BF199B47AF9858BECB6C89B5B683019F")

    public static final int RELATIVE_TIME_DAYS_LIMIT      = 196;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.762 -0500", hash_original_field = "90A9E06C96768BCB8D1D2CE9C3122DDF", hash_generated_field = "BAC0ED3816D2C72D50B6EC9013B4B1D8")

    public static final int RELATIVE_TIME_WEEKS_LIMIT     = 244;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.765 -0500", hash_original_field = "8249F7E31CE4756413EAE38ECF4BBD44", hash_generated_field = "706BD02B7A5BB19ED83920AE20E90D30")

    public static final int RELATIVE_TIME_INDEFINITE      = 245;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.767 -0500", hash_original_field = "35994B36DE867FBD0F6E8D9060F2D670", hash_generated_field = "084E61410501483C7F0216D4875D8697")

    public static final int RELATIVE_TIME_NOW             = 246;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.770 -0500", hash_original_field = "7B2CD8EBA6F06051F12E4BBF6DA444B9", hash_generated_field = "C770D899DF53837A6ABBBEAF6FFBAA3F")

    public static final int RELATIVE_TIME_MOBILE_INACTIVE = 247;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.773 -0500", hash_original_field = "4D4CE915BA58B64C9433B7C9752F230B", hash_generated_field = "625FFBADB3FC56C1B929E83275CFCA32")

    public static final int RELATIVE_TIME_RESERVED        = 248;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.585 -0500", hash_original_field = "B3E0C00F8616825E1647BC1E6CD823E2", hash_generated_field = "7D96870A082A2C76305FFABAAF52B964")

    public int messageType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.587 -0500", hash_original_field = "6EB81A1EDD0A12DBAF913511729A2977", hash_generated_field = "69D22C3B16825C62B121ECB6B61FE9B4")

    public int messageId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.600 -0500", hash_original_field = "449AC62555DCFE2D93FEEE4F1FB74D9C", hash_generated_field = "8C6D4EB162537F5CB8F50CC2D2872E4C")

    public boolean priorityIndicatorSet = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.602 -0500", hash_original_field = "FED32C58FF3EC80D7BBFB75D2DE70C79", hash_generated_field = "87C8A49C336BEBF94409DBFE1A6E9513")

    public int priority = PRIORITY_NORMAL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.614 -0500", hash_original_field = "3F45085D5A05428F9F3CBE6081012CB6", hash_generated_field = "8AFEB6424474CA320D5E27C58170FD4F")

    public boolean privacyIndicatorSet = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.617 -0500", hash_original_field = "15221451F2B86BDC02EAAA9CED357273", hash_generated_field = "5D1760697D056EF534E00F74EA4CA781")

    public int privacy = PRIVACY_NOT_RESTRICTED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.630 -0500", hash_original_field = "F39EC2A67CD9AC460C8E5EDD0425A070", hash_generated_field = "F9B735CFCE16BBCEEC92C414108E0381")

    public boolean alertIndicatorSet = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.632 -0500", hash_original_field = "E9D2D8B8712E4737C19ACDF87E11533A", hash_generated_field = "1058D9B40B2EE772AA0DB52D24123C2C")

    public int alert = ALERT_DEFAULT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.642 -0500", hash_original_field = "BBAAC3CC9D93ACA0860653E6DDE3116B", hash_generated_field = "8B825C7CC140C428A94DFB003A4EB6F5")

    public boolean displayModeSet = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.644 -0500", hash_original_field = "3CFF58F58811325B2887632BFC2D6B1F", hash_generated_field = "2557E119FF5302FABE3F787E2D1DFDC9")

    public int displayMode = DISPLAY_MODE_DEFAULT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.667 -0500", hash_original_field = "C67213094AD8E09A830F9C89DE35A897", hash_generated_field = "74138E627E76977DE10F18FB807F0E15")

    public boolean languageIndicatorSet = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.669 -0500", hash_original_field = "E923620B353BA1911010D9BC7EC50353", hash_generated_field = "DE6339F5105113B3C56C063546E8135C")

    public int language = LANGUAGE_UNKNOWN;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.719 -0500", hash_original_field = "660C1612C76A0C4C712B80C57E97D433", hash_generated_field = "2920A4421EF87EA64E53D58C7FD08230")

    public boolean messageStatusSet = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.721 -0500", hash_original_field = "0886E5058665C6571B095488DB74401F", hash_generated_field = "EDCE519B7F83288A6CD0184D83960173")

    public int errorClass = ERROR_UNDEFINED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.723 -0500", hash_original_field = "0F3471F513151E604F68274B2DDAFC2D", hash_generated_field = "EFFAD2073DB12B311A95C0B423F9BD66")

    public int messageStatus = STATUS_UNDEFINED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.725 -0500", hash_original_field = "1DB7D89F4E882DC0737DA7497870A933", hash_generated_field = "96B1530B0C6B9E62545CCD9F2FFB771D")

    public boolean hasUserDataHeader;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.728 -0500", hash_original_field = "A87127828E8D9D42D59AC1448049D1A7", hash_generated_field = "CB5D0EEECFDE2749BF4B796DA4DEB821")

    public UserData userData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.730 -0500", hash_original_field = "449DB79784F0A9F953A7F50FA510FE48", hash_generated_field = "573E1F4BFE7A25D18D46B1540FD60D71")

    public boolean userResponseCodeSet = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.732 -0500", hash_original_field = "3FEB923644CB2F2B007E77C891BD425F", hash_generated_field = "C9BE5D25D405DB5587138848C8D727A8")

    public int userResponseCode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.746 -0500", hash_original_field = "D1D4228F22A59F4181997B23869F591F", hash_generated_field = "F2CEDF1D18CD508C2828421FCE344864")

    public TimeStamp msgCenterTimeStamp;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.748 -0500", hash_original_field = "675AC1B7CF391CD3025F935F8473AB16", hash_generated_field = "A7BDA794034CCF1E85FBB1CD3D5589E0")

    public TimeStamp validityPeriodAbsolute;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.751 -0500", hash_original_field = "649B3D885AE52E05E790E930551C9605", hash_generated_field = "963C06E39DBAD6B0E126755019329CEA")

    public TimeStamp deferredDeliveryTimeAbsolute;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.775 -0500", hash_original_field = "42842F0A1C1AEBF19D7352D234092B79", hash_generated_field = "9C17B1FD88737F473DEBA3485827EC48")

    public boolean validityPeriodRelativeSet;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.778 -0500", hash_original_field = "839802210443379DFBF10AD2F5B80A69", hash_generated_field = "C69E194E4844C6AE487C64DC3199BA53")

    public int validityPeriodRelative;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.781 -0500", hash_original_field = "70B65B09AAC3F9BDF498D8DBA68EBCBC", hash_generated_field = "96A354EFFA3AFA1D01B39014CCC8D1A8")

    public boolean deferredDeliveryTimeRelativeSet;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.784 -0500", hash_original_field = "DADC19E7528D5918D6F42479528C641B", hash_generated_field = "2DF4B9C75C215F2287DB1867874F49A4")

    public int deferredDeliveryTimeRelative;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.786 -0500", hash_original_field = "81B1B718EBBAE8BB435A77BC5B949395", hash_generated_field = "2325DFAE1E286B33DD7558FC23E204F3")

    public boolean userAckReq;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.794 -0500", hash_original_field = "7363541DC565FF2F1004CD263358B718", hash_generated_field = "7D24F7831836A98A9063AAD2B2891EF3")

    public boolean deliveryAckReq;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.797 -0500", hash_original_field = "525E4104D355C7078EFFAE2EFFFB6E9B", hash_generated_field = "4B653E342F3F416FAA909BA8F87D480A")

    public boolean readAckReq;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.799 -0500", hash_original_field = "C66CF428FCA333A57AFEE1E45A3ADB7A", hash_generated_field = "CEFB44C617F9BE7CF9A64BF2A279AF19")

    public boolean reportReq;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.802 -0500", hash_original_field = "F8365C3EF2897DD7A855077F9E479346", hash_generated_field = "FB808B8007F3B66E846BCC95CC40D9D1")

    public int numberOfMessages;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.805 -0500", hash_original_field = "A6BC56CA36EF867BEAC8E9776DADA49D", hash_generated_field = "F7E6C4B6D48F5780A12CA3A78218D733")

    public int depositIndex;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.808 -0500", hash_original_field = "21BC81520C2CF1261DC54ACBF6149D19", hash_generated_field = "BECE4D57FCF735C0868024CB12671E4B")

    public CdmaSmsAddress callbackNumber;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.682 -0400", hash_original_method = "035CB3DD1AE9F589077AA91F91422CE0", hash_generated_method = "035CB3DD1AE9F589077AA91F91422CE0")
    public BearerData ()
    {
        //Synthesized constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:50.819 -0500", hash_original_method = "E225AAC9CA93385B8BA6F6A4FE181F4E", hash_generated_method = "D4CAA8452A734919448DB71EE898F08B")
    
@Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
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
        return builder.toString();
    }
}

