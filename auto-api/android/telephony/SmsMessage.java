package android.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.util.Log;
import com.android.internal.telephony.GsmAlphabet;
import com.android.internal.telephony.SmsHeader;
import com.android.internal.telephony.SmsMessageBase;
import com.android.internal.telephony.SmsMessageBase.SubmitPduBase;
import com.android.internal.telephony.SmsMessageBase.TextEncodingDetails;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;
import static android.telephony.TelephonyManager.PHONE_TYPE_CDMA;

public class SmsMessage {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.302 -0400", hash_original_field = "6C6FE296324BD37F8F46A4EDA590FE7A", hash_generated_field = "6512A5313A4B16FABCD0C4BB52D92A5B")

    public SmsMessageBase mWrappedSmsMessage;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.308 -0400", hash_original_method = "8785081C14DC1062450E96A46CF3DF25", hash_generated_method = "7A720F4140A5D3175262E2DF902BCE6A")
    private  SmsMessage(SmsMessageBase smb) {
        mWrappedSmsMessage = smb;
        // ---------- Original Method ----------
        //mWrappedSmsMessage = smb;
    }

    
        public static SmsMessage createFromPdu(byte[] pdu) {
        int activePhone = TelephonyManager.getDefault().getCurrentPhoneType();
        String format = (PHONE_TYPE_CDMA == activePhone) ? FORMAT_3GPP2 : FORMAT_3GPP;
        return createFromPdu(pdu, format);
    }

    
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

    
        public static SmsMessage newFromCMT(String[] lines) {
        SmsMessageBase wrappedMessage =
                com.android.internal.telephony.gsm.SmsMessage.newFromCMT(lines);
        return new SmsMessage(wrappedMessage);
    }

    
        public static SmsMessage newFromParcel(Parcel p) {
        SmsMessageBase wrappedMessage =
                com.android.internal.telephony.cdma.SmsMessage.newFromParcel(p);
        return new SmsMessage(wrappedMessage);
    }

    
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

    
        public static int getTPLayerLengthForPDU(String pdu) {
        int activePhone = TelephonyManager.getDefault().getCurrentPhoneType();
        if (PHONE_TYPE_CDMA == activePhone) {
            return com.android.internal.telephony.cdma.SmsMessage.getTPLayerLengthForPDU(pdu);
        } else {
            return com.android.internal.telephony.gsm.SmsMessage.getTPLayerLengthForPDU(pdu);
        }
    }

    
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

    
        public static ArrayList<String> fragmentText(String text) {
        int activePhone = TelephonyManager.getDefault().getCurrentPhoneType();
        TextEncodingDetails ted = (PHONE_TYPE_CDMA == activePhone) ?
            com.android.internal.telephony.cdma.SmsMessage.calculateLength(text, false) :
            com.android.internal.telephony.gsm.SmsMessage.calculateLength(text, false);
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
        int pos = 0;
        int textLen = text.length();
        ArrayList<String> result = new ArrayList<String>(ted.msgCount);
        while (pos < textLen) {
            int nextPos = 0;  
            if (ted.codeUnitSize == ENCODING_7BIT) {
                if (activePhone == PHONE_TYPE_CDMA && ted.msgCount == 1) {
                    nextPos = pos + Math.min(limit, textLen - pos);
                } else {
                    nextPos = GsmAlphabet.findGsmSeptetLimitIndex(text, pos, limit,
                            ted.languageTable, ted.languageShiftTable);
                }
            } else {  
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

    
        public static int[] calculateLength(String messageBody, boolean use7bitOnly) {
        return calculateLength((CharSequence)messageBody, use7bitOnly);
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.339 -0400", hash_original_method = "918A2835DDADF3191B8B6CF8127F286C", hash_generated_method = "2F3A5B17F81E9EF40A1F90BA91D6CDB2")
    public String getServiceCenterAddress() {
        String varB4EAC82CA7396A68D541C85D26508E83_965800943 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_965800943 = mWrappedSmsMessage.getServiceCenterAddress();
        varB4EAC82CA7396A68D541C85D26508E83_965800943.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_965800943;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getServiceCenterAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.342 -0400", hash_original_method = "E9EFC86835C6B2F047600D750A41AA1C", hash_generated_method = "B6CF6B8F0C152DAEDB99954F30B2620D")
    public String getOriginatingAddress() {
        String varB4EAC82CA7396A68D541C85D26508E83_1277557979 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1277557979 = mWrappedSmsMessage.getOriginatingAddress();
        varB4EAC82CA7396A68D541C85D26508E83_1277557979.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1277557979;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getOriginatingAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.343 -0400", hash_original_method = "A66BB5C1A20948050FC14BD05462FCCC", hash_generated_method = "49E0BF3EC1F6282F380A0206416E0353")
    public String getDisplayOriginatingAddress() {
        String varB4EAC82CA7396A68D541C85D26508E83_207825120 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_207825120 = mWrappedSmsMessage.getDisplayOriginatingAddress();
        varB4EAC82CA7396A68D541C85D26508E83_207825120.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_207825120;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getDisplayOriginatingAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.347 -0400", hash_original_method = "11C71A7ADD8F40537023F3C9896D9F41", hash_generated_method = "F1B7279BB0F36DB1631AE2BFA3A2CA2B")
    public String getMessageBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1745890919 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1745890919 = mWrappedSmsMessage.getMessageBody();
        varB4EAC82CA7396A68D541C85D26508E83_1745890919.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1745890919;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getMessageBody();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.348 -0400", hash_original_method = "099557EF4A3D1E47FF142271693B3FFE", hash_generated_method = "5AEA06802159BF731F9885721CECF592")
    public MessageClass getMessageClass() {
        MessageClass varB4EAC82CA7396A68D541C85D26508E83_754072538 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_754072538 = mWrappedSmsMessage.getMessageClass();
        varB4EAC82CA7396A68D541C85D26508E83_754072538.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_754072538;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getMessageClass();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.355 -0400", hash_original_method = "DDB62DAFB6CA28A8B02386170905555B", hash_generated_method = "F07A0E8DFFC00BC1E595080CD87E4DFC")
    public String getDisplayMessageBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_2040828860 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2040828860 = mWrappedSmsMessage.getDisplayMessageBody();
        varB4EAC82CA7396A68D541C85D26508E83_2040828860.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2040828860;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getDisplayMessageBody();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.358 -0400", hash_original_method = "A55B37ECD2D988C3EC358C7240F7EDE2", hash_generated_method = "59E01AE34AFBAC4E7BBBDDC604B041A8")
    public String getPseudoSubject() {
        String varB4EAC82CA7396A68D541C85D26508E83_1879843127 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1879843127 = mWrappedSmsMessage.getPseudoSubject();
        varB4EAC82CA7396A68D541C85D26508E83_1879843127.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1879843127;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getPseudoSubject();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.358 -0400", hash_original_method = "A397C7F820656CEADBC57751F7E32997", hash_generated_method = "D99F6791B1AFEFD471D12787939BD74B")
    public long getTimestampMillis() {
        long varD74FBED3C84830DCE4507A727CF564FC_77090793 = (mWrappedSmsMessage.getTimestampMillis());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_2078035158 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2078035158;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getTimestampMillis();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.377 -0400", hash_original_method = "A5B6E1F6D425F99E0AE9246791CF1B08", hash_generated_method = "EE4285DDA39711549C782D5CB72AF80C")
    public boolean isEmail() {
        boolean var01F26EAB74A6E76EB5CC85065B2AB42C_387225605 = (mWrappedSmsMessage.isEmail());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1409208732 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1409208732;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.isEmail();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.378 -0400", hash_original_method = "1B76815865383567D84D772FA102258B", hash_generated_method = "848F8412EE67351568433BC166DEA7CB")
    public String getEmailBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_113855468 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_113855468 = mWrappedSmsMessage.getEmailBody();
        varB4EAC82CA7396A68D541C85D26508E83_113855468.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_113855468;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getEmailBody();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.380 -0400", hash_original_method = "CF41F1C32C92AADB2191A6AB99FD49D6", hash_generated_method = "6BDCF49BF6C1BF424B3E2E196DB41BA4")
    public String getEmailFrom() {
        String varB4EAC82CA7396A68D541C85D26508E83_1519037958 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1519037958 = mWrappedSmsMessage.getEmailFrom();
        varB4EAC82CA7396A68D541C85D26508E83_1519037958.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1519037958;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getEmailFrom();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.391 -0400", hash_original_method = "642EF36AD67598AD564965134BACF8A1", hash_generated_method = "43657A8D1728C56943EF30E11873BF93")
    public int getProtocolIdentifier() {
        int varC61A7C9212F3E9FF0CA0B745657226BD_846291529 = (mWrappedSmsMessage.getProtocolIdentifier());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1318717208 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1318717208;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getProtocolIdentifier();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.402 -0400", hash_original_method = "36F360B7C447980FEF01C7653F551835", hash_generated_method = "B603E7F76C650620BCADC46F95513615")
    public boolean isReplace() {
        boolean varBC2D932725136F9C20C34229415D4B97_1596707335 = (mWrappedSmsMessage.isReplace());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1203788274 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1203788274;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.isReplace();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.403 -0400", hash_original_method = "553B9246636C3A5BC903932A40C4BC5E", hash_generated_method = "41EFE60978F62A90B65B80CF39F75937")
    public boolean isCphsMwiMessage() {
        boolean var480BB749EC7EC97FE4A1651C1A8FD73E_150912432 = (mWrappedSmsMessage.isCphsMwiMessage());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1401124086 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1401124086;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.isCphsMwiMessage();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.403 -0400", hash_original_method = "129EA72B0C9F078142A2BC814FB30CFA", hash_generated_method = "A653AD40664390C15236197EA54A4E1F")
    public boolean isMWIClearMessage() {
        boolean varB7A77ECDEC8A73E675ABF225AE837A72_1930096506 = (mWrappedSmsMessage.isMWIClearMessage());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_766390944 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_766390944;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.isMWIClearMessage();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.404 -0400", hash_original_method = "5602B112C459EA0AD88653A254825A5D", hash_generated_method = "FC2C5F04C21D8F59A2F9C14AB9812769")
    public boolean isMWISetMessage() {
        boolean var5B955D4A1D8E3F5634E1C3A2B25FD29A_629385703 = (mWrappedSmsMessage.isMWISetMessage());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_259863509 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_259863509;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.isMWISetMessage();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.404 -0400", hash_original_method = "0ACB85E19D1AFC6F8EA2F470F677C800", hash_generated_method = "07A672871168D471729523C997CC68A8")
    public boolean isMwiDontStore() {
        boolean var77B6C24D29DDA670F2D629741A9B498F_1089192515 = (mWrappedSmsMessage.isMwiDontStore());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_105057622 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_105057622;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.isMwiDontStore();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.404 -0400", hash_original_method = "251D6D0F20B7389DF3878BB8173A6B0A", hash_generated_method = "DD1337C1350AF1C66AF2E75B810944D9")
    public byte[] getUserData() {
        byte[] var56EE16369B6A9056187EC70F114596AF_686076638 = (mWrappedSmsMessage.getUserData());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_856748422 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_856748422;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getUserData();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.410 -0400", hash_original_method = "F61520780332A4249272ED211A1EBC6F", hash_generated_method = "586302F24D75B4736E9E5C17312D2777")
    public byte[] getPdu() {
        byte[] var251F1A35ECF82D698D55B42DA1ECA076_2081271369 = (mWrappedSmsMessage.getPdu());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_756152513 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_756152513;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getPdu();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.411 -0400", hash_original_method = "43D7E194BC6DB0E7804F1B1454D5CCBF", hash_generated_method = "14B850D408F47843B893EF3D3A0E25C7")
    @Deprecated
    public int getStatusOnSim() {
        int var9C85A772E629F12E0A5C09948CEAF5CB_323445786 = (mWrappedSmsMessage.getStatusOnIcc());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_180306581 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_180306581;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getStatusOnIcc();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.411 -0400", hash_original_method = "F41186F27A3FFD01878B6A79ACBBD00F", hash_generated_method = "C52B815B3EBE38D908F7268D2E4A9DA1")
    public int getStatusOnIcc() {
        int var9C85A772E629F12E0A5C09948CEAF5CB_125204889 = (mWrappedSmsMessage.getStatusOnIcc());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1202940090 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1202940090;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getStatusOnIcc();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.414 -0400", hash_original_method = "150B1A5BD8253701A69C723196BA6DF9", hash_generated_method = "C4DA3A45B1FB739A381EEF67A6D4AEB1")
    @Deprecated
    public int getIndexOnSim() {
        int varAAC43D666C403A91DB1773E11797D5BC_1020453798 = (mWrappedSmsMessage.getIndexOnIcc());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1986353362 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1986353362;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getIndexOnIcc();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.425 -0400", hash_original_method = "4C0DE2049D9873C839084BE4DC285920", hash_generated_method = "71154F82D2F28C33DA475739C8E6A726")
    public int getIndexOnIcc() {
        int varAAC43D666C403A91DB1773E11797D5BC_1709044045 = (mWrappedSmsMessage.getIndexOnIcc());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1969266203 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1969266203;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getIndexOnIcc();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.425 -0400", hash_original_method = "BAA167F31D67CF27268081CFB0D79A6E", hash_generated_method = "7AB3F21C4CE5E259DA8779BA14A06888")
    public int getStatus() {
        int var21EB021D474B531470E6B8E8AADA37C0_1125674388 = (mWrappedSmsMessage.getStatus());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1662192482 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1662192482;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getStatus();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.438 -0400", hash_original_method = "D10C36D7B6CDC51D018139E7A34B7076", hash_generated_method = "00D852C95B5808D38CC60A55E287D18F")
    public boolean isStatusReportMessage() {
        boolean varA3C3DB4C7E404E711EF55D5064B97BE1_1962601175 = (mWrappedSmsMessage.isStatusReportMessage());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1537903531 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1537903531;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.isStatusReportMessage();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.439 -0400", hash_original_method = "F508F532A25EB5B4727057181F2BF528", hash_generated_method = "CE4C58D5311EDDF7FB4D2AA2358DA3C4")
    public boolean isReplyPathPresent() {
        boolean var52B036373B56F8584D28911DD9CACB80_210304844 = (mWrappedSmsMessage.isReplyPathPresent());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_160107232 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_160107232;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.isReplyPathPresent();
    }

    
    public enum MessageClass{
        UNKNOWN, CLASS_0, CLASS_1, CLASS_2, CLASS_3;
    }

    
    public static class SubmitPdu {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.439 -0400", hash_original_field = "275E12BC2D1B7A1135AB78E2E8FED5C1", hash_generated_field = "B7E7B1E4BBABCFD1218DEF1D08E579CA")

        public byte[] encodedScAddress;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.439 -0400", hash_original_field = "482E018453FC47667D6222532DFEB427", hash_generated_field = "59202226E3585983001906EF1AF63678")

        public byte[] encodedMessage;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.440 -0400", hash_original_method = "84E90F8D80D26E2676EED6BCE3E65E06", hash_generated_method = "D65631A9BDFFB9B21266433BCDB38CFF")
        protected  SubmitPdu(SubmitPduBase spb) {
            this.encodedMessage = spb.encodedMessage;
            this.encodedScAddress = spb.encodedScAddress;
            // ---------- Original Method ----------
            //this.encodedMessage = spb.encodedMessage;
            //this.encodedScAddress = spb.encodedScAddress;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.441 -0400", hash_original_method = "A866707516A0999C629C71FD5B45C6F7", hash_generated_method = "94E6A8B4BAE09F9B01F99FA981119AD0")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1813413734 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1813413734 = "SubmitPdu: encodedScAddress = "
                    + Arrays.toString(encodedScAddress)
                    + ", encodedMessage = "
                    + Arrays.toString(encodedMessage);
            varB4EAC82CA7396A68D541C85D26508E83_1813413734.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1813413734;
            // ---------- Original Method ----------
            //return "SubmitPdu: encodedScAddress = "
                    //+ Arrays.toString(encodedScAddress)
                    //+ ", encodedMessage = "
                    //+ Arrays.toString(encodedMessage);
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.441 -0400", hash_original_field = "57729A6D26DD4D4E055A9FC1069E9025", hash_generated_field = "FD8B5B4E0106F47C81A9C32406FD056B")

    private static String LOG_TAG = "SMS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.441 -0400", hash_original_field = "911D041943DE84D698667C86C3960E87", hash_generated_field = "27499AC5501958C24E1C878C00171D98")

    public static final int ENCODING_UNKNOWN = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.441 -0400", hash_original_field = "7C09D1CF68EDD64482420E88F8FAE8AB", hash_generated_field = "E3BD113EFA27FC80F1215EAC10F05F54")

    public static final int ENCODING_7BIT = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.441 -0400", hash_original_field = "4590BC9E0C03D7C72E5C28B0B321E9EB", hash_generated_field = "C6C4A2BD27CE6056084528ABE2108D41")

    public static final int ENCODING_8BIT = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.441 -0400", hash_original_field = "F2D1F619912C053120A34953383D3646", hash_generated_field = "A5A42D0A35339D86DEBBCEB46B9756FA")

    public static final int ENCODING_16BIT = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.441 -0400", hash_original_field = "9246C4EDF2F885233B87AF292514FF5C", hash_generated_field = "9FA989A1AC757B009256AA97A922831A")

    public static final int ENCODING_KSC5601 = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.441 -0400", hash_original_field = "352387DBC99D8AD424E083939B69C383", hash_generated_field = "0257BE4B4F208A23154B8F18AB43FEC5")

    public static final int MAX_USER_DATA_BYTES = 140;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.441 -0400", hash_original_field = "A89974340D019FDC13B3C5FC97BE4835", hash_generated_field = "C84733D22240FE9846722841159ECECC")

    public static final int MAX_USER_DATA_BYTES_WITH_HEADER = 134;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.441 -0400", hash_original_field = "041FD9CA1258920783716DC1DA6DF2B6", hash_generated_field = "BA710E28657EDC31EF8505D2CAA6A62C")

    public static final int MAX_USER_DATA_SEPTETS = 160;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.441 -0400", hash_original_field = "84A0A722A9089067E4B926DB02EF4D0A", hash_generated_field = "1E7DC369DA9053C67AF8B9AB932C4C33")

    public static final int MAX_USER_DATA_SEPTETS_WITH_HEADER = 153;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.442 -0400", hash_original_field = "625E8B197AE38860F6473EFEC71B0EBF", hash_generated_field = "1A314915591575EE5AB81A039C2EA299")

    public static final String FORMAT_3GPP = "3gpp";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.442 -0400", hash_original_field = "1EC59ECA713D8BA4FBE781F641A8893D", hash_generated_field = "D953DB3D95F249D4E9F6EAC3FC5F26A3")

    public static final String FORMAT_3GPP2 = "3gpp2";
}

