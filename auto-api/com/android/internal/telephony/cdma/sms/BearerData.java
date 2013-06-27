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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.921 -0400", hash_original_field = "9CEBBECC0F683775CABCD1C6DD3D70C7", hash_generated_field = "7D96870A082A2C76305FFABAAF52B964")

    public int messageType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.921 -0400", hash_original_field = "009BC6CA542405D9097AE589731691FB", hash_generated_field = "69D22C3B16825C62B121ECB6B61FE9B4")

    public int messageId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.921 -0400", hash_original_field = "07F5A4613EABBFBE839A771DBB3C36FB", hash_generated_field = "8C6D4EB162537F5CB8F50CC2D2872E4C")

    public boolean priorityIndicatorSet = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.921 -0400", hash_original_field = "388D5BF0DC9FBD42D062CD499FA9987B", hash_generated_field = "87C8A49C336BEBF94409DBFE1A6E9513")

    public int priority = PRIORITY_NORMAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.921 -0400", hash_original_field = "554BD311FBEC16CF8F012B6F3BB2B256", hash_generated_field = "8AFEB6424474CA320D5E27C58170FD4F")

    public boolean privacyIndicatorSet = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.921 -0400", hash_original_field = "1693FBACD939E2EFA546CEA217F0EF7B", hash_generated_field = "5D1760697D056EF534E00F74EA4CA781")

    public int privacy = PRIVACY_NOT_RESTRICTED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.921 -0400", hash_original_field = "6FCB8A8DE3C75D3EC370DAF05AE8C74E", hash_generated_field = "F9B735CFCE16BBCEEC92C414108E0381")

    public boolean alertIndicatorSet = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.921 -0400", hash_original_field = "1DC336753AAFAA44BF2CB5978221CC1F", hash_generated_field = "1058D9B40B2EE772AA0DB52D24123C2C")

    public int alert = ALERT_DEFAULT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.921 -0400", hash_original_field = "9127CE7DABDE8740F59A51D8B7E99E54", hash_generated_field = "8B825C7CC140C428A94DFB003A4EB6F5")

    public boolean displayModeSet = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.921 -0400", hash_original_field = "121C6F3759C53AFED77029CC53F502FD", hash_generated_field = "2557E119FF5302FABE3F787E2D1DFDC9")

    public int displayMode = DISPLAY_MODE_DEFAULT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.921 -0400", hash_original_field = "C27242B2CA7715F3EC7B3CAEB837975E", hash_generated_field = "74138E627E76977DE10F18FB807F0E15")

    public boolean languageIndicatorSet = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.921 -0400", hash_original_field = "57D991653D5F1F6E23AB9782E3A72C66", hash_generated_field = "DE6339F5105113B3C56C063546E8135C")

    public int language = LANGUAGE_UNKNOWN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.921 -0400", hash_original_field = "FD022BEF150F74DFD7D3F2B2B0FE1CBC", hash_generated_field = "2920A4421EF87EA64E53D58C7FD08230")

    public boolean messageStatusSet = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.921 -0400", hash_original_field = "B04FECA52FFBB81891A29129C62A31F2", hash_generated_field = "EDCE519B7F83288A6CD0184D83960173")

    public int errorClass = ERROR_UNDEFINED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.921 -0400", hash_original_field = "6AF94AD302D85CC448558DD38528F31F", hash_generated_field = "EFFAD2073DB12B311A95C0B423F9BD66")

    public int messageStatus = STATUS_UNDEFINED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.921 -0400", hash_original_field = "01EA08396E29CBF1BF650F368FF76B1E", hash_generated_field = "96B1530B0C6B9E62545CCD9F2FFB771D")

    public boolean hasUserDataHeader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.922 -0400", hash_original_field = "56491F2E1C74898E18BB6E47D2425B19", hash_generated_field = "CB5D0EEECFDE2749BF4B796DA4DEB821")

    public UserData userData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.922 -0400", hash_original_field = "3A4C0D9CE13AF3039E7CF544A48FE334", hash_generated_field = "573E1F4BFE7A25D18D46B1540FD60D71")

    public boolean userResponseCodeSet = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.922 -0400", hash_original_field = "3483E79F0754EACBC68849628898D755", hash_generated_field = "C9BE5D25D405DB5587138848C8D727A8")

    public int userResponseCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.922 -0400", hash_original_field = "51095761FEE51E00878E01120735C5D6", hash_generated_field = "F2CEDF1D18CD508C2828421FCE344864")

    public TimeStamp msgCenterTimeStamp;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.922 -0400", hash_original_field = "6E4EBBBE0712BC7C1605AF7C8EE44C4D", hash_generated_field = "A7BDA794034CCF1E85FBB1CD3D5589E0")

    public TimeStamp validityPeriodAbsolute;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.922 -0400", hash_original_field = "FEEA7295E5D13E0CC101785B3247B9D4", hash_generated_field = "963C06E39DBAD6B0E126755019329CEA")

    public TimeStamp deferredDeliveryTimeAbsolute;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.922 -0400", hash_original_field = "7320353E8CB3C0F4943BAD5199D6E811", hash_generated_field = "9C17B1FD88737F473DEBA3485827EC48")

    public boolean validityPeriodRelativeSet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.922 -0400", hash_original_field = "6A8D4C50F157023A395BBED9BECCF8B0", hash_generated_field = "C69E194E4844C6AE487C64DC3199BA53")

    public int validityPeriodRelative;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.922 -0400", hash_original_field = "D51393DEC39630B08CF6FA23411A6E34", hash_generated_field = "96A354EFFA3AFA1D01B39014CCC8D1A8")

    public boolean deferredDeliveryTimeRelativeSet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.922 -0400", hash_original_field = "7B2A56345F1CEA728220A3F3619A932B", hash_generated_field = "2DF4B9C75C215F2287DB1867874F49A4")

    public int deferredDeliveryTimeRelative;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.922 -0400", hash_original_field = "5C165647B441AC853F5AED8B4EA0DF14", hash_generated_field = "2325DFAE1E286B33DD7558FC23E204F3")

    public boolean userAckReq;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.922 -0400", hash_original_field = "1275632522043F6CE255558E51D8B8AB", hash_generated_field = "7D24F7831836A98A9063AAD2B2891EF3")

    public boolean deliveryAckReq;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.922 -0400", hash_original_field = "0A0D0D33285438EDF46F55BBFE4B0DA0", hash_generated_field = "4B653E342F3F416FAA909BA8F87D480A")

    public boolean readAckReq;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.922 -0400", hash_original_field = "D9A2894D2EF681BE7E4E499FD511E730", hash_generated_field = "CEFB44C617F9BE7CF9A64BF2A279AF19")

    public boolean reportReq;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.922 -0400", hash_original_field = "421F1A54E1CF7CD383F1AD64779E0A2A", hash_generated_field = "FB808B8007F3B66E846BCC95CC40D9D1")

    public int numberOfMessages;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.922 -0400", hash_original_field = "43B31D48BC25474007142DAD6FBECF0E", hash_generated_field = "F7E6C4B6D48F5780A12CA3A78218D733")

    public int depositIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.922 -0400", hash_original_field = "6393986C5852B553D371C55D86D34D32", hash_generated_field = "BECE4D57FCF735C0868024CB12671E4B")

    public CdmaSmsAddress callbackNumber;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.922 -0400", hash_original_method = "035CB3DD1AE9F589077AA91F91422CE0", hash_generated_method = "035CB3DD1AE9F589077AA91F91422CE0")
    public BearerData ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.923 -0400", hash_original_method = "E225AAC9CA93385B8BA6F6A4FE181F4E", hash_generated_method = "15EF8715134FA7C9DB3954F9B40C2736")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1029258863 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1029258863 = builder.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1029258863.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1029258863;
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.978 -0400", hash_original_method = "227CB08289E9E58D2E1A786B0B8104B3", hash_generated_method = "8C18566B3367C0FEDF5A52BA15A777A6")
        public  TimeStamp() {
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.979 -0400", hash_original_method = "ED297E11B9020980F3FCB379731AD215", hash_generated_method = "0DACCD07EEC8D7642B21F35D040BE5EC")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_351579356 = null; //Variable for return #1
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
            varB4EAC82CA7396A68D541C85D26508E83_351579356 = builder.toString();
            varB4EAC82CA7396A68D541C85D26508E83_351579356.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_351579356;
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.997 -0400", hash_original_method = "7A2C15A084F2DA50BCA20CD284E89E4B", hash_generated_method = "BC6A3BF10D682888E50FB691D94A6109")
        public  CodingException(String s) {
            super(s);
            addTaint(s.getTaint());
            // ---------- Original Method ----------
        }

        
    }


    
    private static class Gsm7bitCodingResult {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.997 -0400", hash_original_field = "DAD6213D11B8F620D4A9E5B19B248E60", hash_generated_field = "3D638577AFFE2D6F939C79F75360B6FF")

        int septets;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.997 -0400", hash_original_field = "8D777F385D3DFEC8815D20F7496026DC", hash_generated_field = "B330DF564CD90A5498A9E4F0AB344BB9")

        byte[] data;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.997 -0400", hash_original_method = "7E9DFC757F4277B439A8F1AFF7D9B860", hash_generated_method = "7E9DFC757F4277B439A8F1AFF7D9B860")
        public Gsm7bitCodingResult ()
        {
            //Synthesized constructor
        }


    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.997 -0400", hash_original_field = "57729A6D26DD4D4E055A9FC1069E9025", hash_generated_field = "FD8B5B4E0106F47C81A9C32406FD056B")

    private static String LOG_TAG = "SMS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.997 -0400", hash_original_field = "0B310CC1C03F5CFD5F1B340138FFC334", hash_generated_field = "E8BF100ED744EDC11E0A6E03F64ADFCB")

    private static byte SUBPARAM_MESSAGE_IDENTIFIER = 0x00;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.997 -0400", hash_original_field = "77F8FE5C96421F75D8CA1AEDA18575F7", hash_generated_field = "48BDFFDCD373AEA10D319505C24600DE")

    private static byte SUBPARAM_USER_DATA = 0x01;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.997 -0400", hash_original_field = "829378289AC31B61EFE41AD5FD9D0C16", hash_generated_field = "A1E7979D052070FAA499EB6DA21E0190")

    private static byte SUBPARAM_USER_RESPONSE_CODE = 0x02;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.997 -0400", hash_original_field = "DC49CBAD9EB860509055D3C1BC8EF7C9", hash_generated_field = "F43694BDC68A3D6E48C89FE907E5D308")

    private static byte SUBPARAM_MESSAGE_CENTER_TIME_STAMP = 0x03;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.997 -0400", hash_original_field = "F28C70BF15B05497F1E00249AFF71446", hash_generated_field = "04418624CCB98A0E6C708FF4B61E9205")

    private static byte SUBPARAM_VALIDITY_PERIOD_ABSOLUTE = 0x04;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.997 -0400", hash_original_field = "136F69CC9D729258471656081DAB9F62", hash_generated_field = "EFEC2A33FD84F03D2DC05B7E6438E662")

    private static byte SUBPARAM_VALIDITY_PERIOD_RELATIVE = 0x05;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.997 -0400", hash_original_field = "AB0795A6D4CF5A065C8F46164FA8C240", hash_generated_field = "A5DABBE3CA0618372558EB7DAA4DD6AE")

    private static byte SUBPARAM_DEFERRED_DELIVERY_TIME_ABSOLUTE = 0x06;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.997 -0400", hash_original_field = "051A3D0966E1360AA91FEAEFA5E9006F", hash_generated_field = "A570C7055552286D5C78D3F59DE009F0")

    private static byte SUBPARAM_DEFERRED_DELIVERY_TIME_RELATIVE = 0x07;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.997 -0400", hash_original_field = "BA78E07C61670874FBA793380EFBC962", hash_generated_field = "C4D99E38F4ECC2B92A2E25146D15B14B")

    private static byte SUBPARAM_PRIORITY_INDICATOR = 0x08;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.997 -0400", hash_original_field = "0BC2FCC3D97B3585E9C3F63ED6CB3EEF", hash_generated_field = "ACED0549D32F529F231F160385E9604D")

    private static byte SUBPARAM_PRIVACY_INDICATOR = 0x09;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.997 -0400", hash_original_field = "D2594EB2D1F93ECA23DA67F235E3E8D0", hash_generated_field = "77A0071E9D91AC4CD4880EFB914B122D")

    private static byte SUBPARAM_REPLY_OPTION = 0x0A;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.997 -0400", hash_original_field = "0093C3B5683B4B7DF0A57F434E132A06", hash_generated_field = "BCC09BC6EC1CFFF6D134DC007F0C4831")

    private static byte SUBPARAM_NUMBER_OF_MESSAGES = 0x0B;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.997 -0400", hash_original_field = "AC5723705CAC708CBB46CCB1C498E73E", hash_generated_field = "FB4B8F1B500170DAD17D803B5FD32176")

    private static byte SUBPARAM_ALERT_ON_MESSAGE_DELIVERY = 0x0C;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.997 -0400", hash_original_field = "BEEE07D56A985765C55CCC65DA9A87CB", hash_generated_field = "ECE458AC5932197028A65A6F66A454D9")

    private static byte SUBPARAM_LANGUAGE_INDICATOR = 0x0D;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.998 -0400", hash_original_field = "D0020BFF18B126AB4043CB8F7E84446D", hash_generated_field = "7C814E6B7DA578682439648D567DB9F5")

    private static byte SUBPARAM_CALLBACK_NUMBER = 0x0E;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.998 -0400", hash_original_field = "54D98DD8A22150A6C7FD7C7BA77F9D61", hash_generated_field = "35CDE2BF2DFE44A7735AF993857A6A80")

    private static byte SUBPARAM_MESSAGE_DISPLAY_MODE = 0x0F;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.998 -0400", hash_original_field = "354489DE41A488B26D1FB32141291809", hash_generated_field = "46C2A3B3CE413BE28F95F1C4BAE0F314")

    private static byte SUBPARAM_MESSAGE_DEPOSIT_INDEX = 0x11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.998 -0400", hash_original_field = "605C2434B9ED103E6F892D63879A5B49", hash_generated_field = "A09219DC15AB0FF860D338DC8F8FF507")

    private static byte SUBPARAM_MESSAGE_STATUS = 0x14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.998 -0400", hash_original_field = "2132F0242020A68C15065282DD0CA03C", hash_generated_field = "AECA9233A06DB30284EAEEF4D7D4006A")

    public static final int MESSAGE_TYPE_DELIVER        = 0x01;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.998 -0400", hash_original_field = "A7491B32CA743499B82C61715851A7A5", hash_generated_field = "031A242F3842AD4D24E88218BFAABD11")

    public static final int MESSAGE_TYPE_SUBMIT         = 0x02;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.998 -0400", hash_original_field = "81175F29AE1072066A387C2FE18D2005", hash_generated_field = "CB84DF64AB5D7EFF6D68DB66CEF0EFFA")

    public static final int MESSAGE_TYPE_CANCELLATION   = 0x03;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.998 -0400", hash_original_field = "F3A8FAB8FF6D0BCBE1D7CDF3531C478A", hash_generated_field = "C6118AE030C84A0D8A79351310A303FB")

    public static final int MESSAGE_TYPE_DELIVERY_ACK   = 0x04;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.998 -0400", hash_original_field = "EC1E60B30D9BF86C6D3C644CCDCD3DF5", hash_generated_field = "D3E301021704CCC30564CF4178785FCB")

    public static final int MESSAGE_TYPE_USER_ACK       = 0x05;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.998 -0400", hash_original_field = "AE6A9BEA8E62C36593F1E5DC8EC3F639", hash_generated_field = "57300DC0D37C2DEFB87C46AE25307B2F")

    public static final int MESSAGE_TYPE_READ_ACK       = 0x06;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.998 -0400", hash_original_field = "DA22783C866C2331F9F1DC1D30B0555E", hash_generated_field = "2BF129AB6BE31531BF4B305979DBCCAD")

    public static final int MESSAGE_TYPE_DELIVER_REPORT = 0x07;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.998 -0400", hash_original_field = "7BC604ABB47BEB05CC13BCCAEFF85E3B", hash_generated_field = "8753CB8136240C0C2690F71B901E2930")

    public static final int MESSAGE_TYPE_SUBMIT_REPORT  = 0x08;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.998 -0400", hash_original_field = "6F2E4D3092541C08D542607D1DB382E9", hash_generated_field = "B13E523EEA6650D52D37BFEF8BF03C51")

    public static final int PRIORITY_NORMAL        = 0x0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.998 -0400", hash_original_field = "3DA0EDF6F45269CEB0B039139AA62287", hash_generated_field = "621D526584A68648DD799F460F586FE7")

    public static final int PRIORITY_INTERACTIVE   = 0x1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.998 -0400", hash_original_field = "B31688E0EA9D067CBED2C8CEB095B786", hash_generated_field = "AAFDEAEA3A3FC13D5C959E2E40F87EFD")

    public static final int PRIORITY_URGENT        = 0x2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.998 -0400", hash_original_field = "EB6B4CEB3328AE9A94AB2F41AF0C3109", hash_generated_field = "DB6F10E2BD45B47A6E8208AAD429644C")

    public static final int PRIORITY_EMERGENCY     = 0x3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.998 -0400", hash_original_field = "76FEE13B3BC5D4502777CDCF87A7CE03", hash_generated_field = "5502809DEAD6C0F675046EAD2EDC070D")

    public static final int PRIVACY_NOT_RESTRICTED = 0x0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.998 -0400", hash_original_field = "AFE70EE27D63E4DBDF2774685B7FD7DF", hash_generated_field = "92980FE0290A64362BE365C13422742C")

    public static final int PRIVACY_RESTRICTED     = 0x1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.998 -0400", hash_original_field = "9640D1888B843FB486A484D465D0999A", hash_generated_field = "9E9E28EBDE66AB5551E0DBF97B667C29")

    public static final int PRIVACY_CONFIDENTIAL   = 0x2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.998 -0400", hash_original_field = "548330F95475209295FEA513E695F601", hash_generated_field = "B10E9EC23F761D26DC7E6765FA14E45D")

    public static final int PRIVACY_SECRET         = 0x3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.998 -0400", hash_original_field = "16D923388C2CF423A2EDE25031188B2A", hash_generated_field = "160382AAA1DBB0AAC0010B402FF60035")

    public static final int ALERT_DEFAULT          = 0x0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.998 -0400", hash_original_field = "F2209553102282B8E4DE190CC06AA694", hash_generated_field = "93E3C2EEB484F6B9D60F33AF2CCDC0A0")

    public static final int ALERT_LOW_PRIO         = 0x1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.998 -0400", hash_original_field = "3A660144B8B5FB0371F72C77EA4A8F5B", hash_generated_field = "598C216B00FA721FB0DF81ABABDE55E0")

    public static final int ALERT_MEDIUM_PRIO      = 0x2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.998 -0400", hash_original_field = "BBAA7F23593BC7A6722DBDDAE3029BF2", hash_generated_field = "CB00D98DEE8741725800375CF80F4552")

    public static final int ALERT_HIGH_PRIO        = 0x3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.999 -0400", hash_original_field = "0D5ADB42EAA485A8018D3522DB713E03", hash_generated_field = "48B87FE8CDF87970FFB7311CD17D2E27")

    public static final int DISPLAY_MODE_IMMEDIATE      = 0x0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.999 -0400", hash_original_field = "944639411FE7306DBB76226608F8F270", hash_generated_field = "9916519CCE7C7D9454CCEF8A723C5344")

    public static final int DISPLAY_MODE_DEFAULT        = 0x1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.999 -0400", hash_original_field = "F1A3EE69A5563025B8011A76A969E63B", hash_generated_field = "2144934F1F707ADAD734BF5F01E7DABB")

    public static final int DISPLAY_MODE_USER           = 0x2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.999 -0400", hash_original_field = "DDF4E445C6E015781C24F22942F7B315", hash_generated_field = "665151E6E97B0C1A5D68722445D54A6D")

    public static final int LANGUAGE_UNKNOWN  = 0x00;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.999 -0400", hash_original_field = "237D3753F97BD5650567F11C7A59D819", hash_generated_field = "4FB0DD20BAF85938611D70BFD1E16BBB")

    public static final int LANGUAGE_ENGLISH  = 0x01;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.999 -0400", hash_original_field = "A7A165FA52CB7EE8F3CC6C3A84604896", hash_generated_field = "F18793CEFBDCFFC7C6787E50040F1ACC")

    public static final int LANGUAGE_FRENCH   = 0x02;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.999 -0400", hash_original_field = "E31508B6DA7A46DB72586DCDBE1CAF24", hash_generated_field = "26374576D2351929FC66B4B7278915FD")

    public static final int LANGUAGE_SPANISH  = 0x03;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.999 -0400", hash_original_field = "56B90A6D65490D24CD873172D5D811CA", hash_generated_field = "C0FD3FB4054094FBF338DD05BCAAFCF0")

    public static final int LANGUAGE_JAPANESE = 0x04;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.999 -0400", hash_original_field = "647D5ADBC5018558E02BCF857FA12133", hash_generated_field = "7670C14EBFAC65E6AF631FF55E18A710")

    public static final int LANGUAGE_KOREAN   = 0x05;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.999 -0400", hash_original_field = "BC10DA614C1DADC07FA692094134CC91", hash_generated_field = "C83F26D00825EC4387D760852EAFA3B0")

    public static final int LANGUAGE_CHINESE  = 0x06;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.999 -0400", hash_original_field = "EE7010E74F2CA9F3DF90C3BD81225113", hash_generated_field = "954CBB5F7392B65D7DA53DCF981CE794")

    public static final int LANGUAGE_HEBREW   = 0x07;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.999 -0400", hash_original_field = "67326F1EE05CF2D033515513B0D4DEFC", hash_generated_field = "D94FDE95BC15E9AACD1211F8E14D9576")

    public static final int ERROR_NONE                   = 0x00;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.999 -0400", hash_original_field = "5DFB769AA994F7C9A3F953E2E11C78B8", hash_generated_field = "20D9A66FB34F5C2FEEF9EFB2952CDC08")

    public static final int STATUS_ACCEPTED              = 0x00;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.999 -0400", hash_original_field = "6FF341ADA4F5852B40222F23EDFACBD5", hash_generated_field = "98745991576C7D001B37D86906DFDF83")

    public static final int STATUS_DEPOSITED_TO_INTERNET = 0x01;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.999 -0400", hash_original_field = "0B72104763074768E49740EFBE62DCBD", hash_generated_field = "000A68F6AC682D6BB9B0E2AF155A60F8")

    public static final int STATUS_DELIVERED             = 0x02;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.999 -0400", hash_original_field = "8D7CBC27F20BC8486D94D40EDAD5D8AB", hash_generated_field = "ABB74DFCDF7205EB43CDB604F690CFF8")

    public static final int STATUS_CANCELLED             = 0x03;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.999 -0400", hash_original_field = "D0F317B86A42CCDF2F4915C5CDF79739", hash_generated_field = "49F8F1D6210C467FA621247B1CA26347")

    public static final int ERROR_TEMPORARY              = 0x02;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.999 -0400", hash_original_field = "336E36AC67E1035CA07E5F612ABD37B7", hash_generated_field = "84F01B8266B7F11377E5CC8DC8276BFC")

    public static final int STATUS_NETWORK_CONGESTION    = 0x04;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.999 -0400", hash_original_field = "1C8C2DD072FCD177C0026B103BBBC72E", hash_generated_field = "434AC7DE857780B92044192AF5EF4BAE")

    public static final int STATUS_NETWORK_ERROR         = 0x05;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.999 -0400", hash_original_field = "ADADCC2C0D8516458579DC1034A7828B", hash_generated_field = "CDCE3F1E9FBCEDF9D7E9770FA2BD8520")

    public static final int STATUS_UNKNOWN_ERROR         = 0x1F;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.999 -0400", hash_original_field = "BC3DE0BEB0C72BD78FB9DC87FF4BDE6B", hash_generated_field = "C3776F9D642D640A756F7FEE5691374B")

    public static final int ERROR_PERMANENT              = 0x03;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.999 -0400", hash_original_field = "2A0D17B717B070CD2BA626E946E93E84", hash_generated_field = "28A81AF17D45BD1A67C0CDF352D029CE")

    public static final int STATUS_CANCEL_FAILED         = 0x06;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.999 -0400", hash_original_field = "E18DD74D3109C37D50A77FA423A5CBDF", hash_generated_field = "D677D29567345BA3290362DB0371EF77")

    public static final int STATUS_BLOCKED_DESTINATION   = 0x07;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.999 -0400", hash_original_field = "780D423F54FCC13E75387CC7F72E5148", hash_generated_field = "A6ACDA46B349FAEDA8A6FAB5901A87F8")

    public static final int STATUS_TEXT_TOO_LONG         = 0x08;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.999 -0400", hash_original_field = "1219E8A021940A1727C10BE0DBFA1B16", hash_generated_field = "65852D4340BF670417915CE62F6B3C43")

    public static final int STATUS_DUPLICATE_MESSAGE     = 0x09;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.999 -0400", hash_original_field = "E03F4BAFBA6E2D6ED2F5E053EF151373", hash_generated_field = "C407295586236DA5DA90BE81CB3FCD9A")

    public static final int STATUS_INVALID_DESTINATION   = 0x0A;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.999 -0400", hash_original_field = "D84FC5303B8836890B7F5C50361A5691", hash_generated_field = "AF06091E20E9218351B8807EA11D30B9")

    public static final int STATUS_MESSAGE_EXPIRED       = 0x0D;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.999 -0400", hash_original_field = "731A8E83E10670D4D5AF9D8B026108F0", hash_generated_field = "CF1C380CBF599EC22A7812A0D4C031DF")

    public static final int ERROR_UNDEFINED              = 0xFF;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.999 -0400", hash_original_field = "1B3E698DFD2655A82E7EA61F21427625", hash_generated_field = "344A2F467F8570A27356DE9367EF7D53")

    public static final int STATUS_UNDEFINED             = 0xFF;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.000 -0400", hash_original_field = "89BE0A53C9DBB74E6C86D7209C521FAC", hash_generated_field = "5306C9878D7D475484539D2F3983A394")

    public static final int RELATIVE_TIME_MINS_LIMIT      = 143;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.000 -0400", hash_original_field = "7DF84F2199AF358C013BEBDB06A6DC00", hash_generated_field = "D2E63B61DEDB429DDC6999A23CEB9B60")

    public static final int RELATIVE_TIME_HOURS_LIMIT     = 167;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.000 -0400", hash_original_field = "CDD92DCD3AF0DD65FD48B3AC6819AFC3", hash_generated_field = "BF199B47AF9858BECB6C89B5B683019F")

    public static final int RELATIVE_TIME_DAYS_LIMIT      = 196;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.000 -0400", hash_original_field = "F8E470B699C45E022904602B67B77D91", hash_generated_field = "BAC0ED3816D2C72D50B6EC9013B4B1D8")

    public static final int RELATIVE_TIME_WEEKS_LIMIT     = 244;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.000 -0400", hash_original_field = "D81B99FD5D73B281DDFD122014B7366E", hash_generated_field = "706BD02B7A5BB19ED83920AE20E90D30")

    public static final int RELATIVE_TIME_INDEFINITE      = 245;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.000 -0400", hash_original_field = "4565244A9A01F367A6121B4D407EF162", hash_generated_field = "084E61410501483C7F0216D4875D8697")

    public static final int RELATIVE_TIME_NOW             = 246;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.000 -0400", hash_original_field = "90BA1C429F5EC5B2A110DC922A1D5951", hash_generated_field = "C770D899DF53837A6ABBBEAF6FFBAA3F")

    public static final int RELATIVE_TIME_MOBILE_INACTIVE = 247;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.000 -0400", hash_original_field = "C1FE7361B0F1CD4EB197C205F677D641", hash_generated_field = "625FFBADB3FC56C1B929E83275CFCA32")

    public static final int RELATIVE_TIME_RESERVED        = 248;
}

