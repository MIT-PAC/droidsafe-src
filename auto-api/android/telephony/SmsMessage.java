package android.telephony;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.278 -0400", hash_original_field = "6C6FE296324BD37F8F46A4EDA590FE7A", hash_generated_field = "6512A5313A4B16FABCD0C4BB52D92A5B")

    public SmsMessageBase mWrappedSmsMessage;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.279 -0400", hash_original_method = "8785081C14DC1062450E96A46CF3DF25", hash_generated_method = "7A720F4140A5D3175262E2DF902BCE6A")
    private  SmsMessage(SmsMessageBase smb) {
        mWrappedSmsMessage = smb;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static SmsMessage createFromPdu(byte[] pdu) {
        int activePhone = TelephonyManager.getDefault().getCurrentPhoneType();
        String format = (PHONE_TYPE_CDMA == activePhone) ? FORMAT_3GPP2 : FORMAT_3GPP;
        return createFromPdu(pdu, format);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static SmsMessage newFromCMT(String[] lines) {
        SmsMessageBase wrappedMessage =
                com.android.internal.telephony.gsm.SmsMessage.newFromCMT(lines);
        return new SmsMessage(wrappedMessage);
    }

    
    @DSModeled(DSC.SAFE)
    public static SmsMessage newFromParcel(Parcel p) {
        SmsMessageBase wrappedMessage =
                com.android.internal.telephony.cdma.SmsMessage.newFromParcel(p);
        return new SmsMessage(wrappedMessage);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static int getTPLayerLengthForPDU(String pdu) {
        int activePhone = TelephonyManager.getDefault().getCurrentPhoneType();
        if (PHONE_TYPE_CDMA == activePhone) {
            return com.android.internal.telephony.cdma.SmsMessage.getTPLayerLengthForPDU(pdu);
        } else {
            return com.android.internal.telephony.gsm.SmsMessage.getTPLayerLengthForPDU(pdu);
        }
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static int[] calculateLength(String messageBody, boolean use7bitOnly) {
        return calculateLength((CharSequence)messageBody, use7bitOnly);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.282 -0400", hash_original_method = "918A2835DDADF3191B8B6CF8127F286C", hash_generated_method = "808D9300D1BB4925CD86F53AF5DF1160")
    public String getServiceCenterAddress() {
        String varB4EAC82CA7396A68D541C85D26508E83_1599960570 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1599960570 = mWrappedSmsMessage.getServiceCenterAddress();
        varB4EAC82CA7396A68D541C85D26508E83_1599960570.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1599960570;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.283 -0400", hash_original_method = "E9EFC86835C6B2F047600D750A41AA1C", hash_generated_method = "7F134C6F3AD41D1DCC51318C635243D3")
    public String getOriginatingAddress() {
        String varB4EAC82CA7396A68D541C85D26508E83_860297945 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_860297945 = mWrappedSmsMessage.getOriginatingAddress();
        varB4EAC82CA7396A68D541C85D26508E83_860297945.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_860297945;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.284 -0400", hash_original_method = "A66BB5C1A20948050FC14BD05462FCCC", hash_generated_method = "4884D4CB7DA31408C9FE155A9BEC6E29")
    public String getDisplayOriginatingAddress() {
        String varB4EAC82CA7396A68D541C85D26508E83_1753961567 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1753961567 = mWrappedSmsMessage.getDisplayOriginatingAddress();
        varB4EAC82CA7396A68D541C85D26508E83_1753961567.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1753961567;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.284 -0400", hash_original_method = "11C71A7ADD8F40537023F3C9896D9F41", hash_generated_method = "26371F770036B1DC12027744269D235F")
    public String getMessageBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_97162193 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_97162193 = mWrappedSmsMessage.getMessageBody();
        varB4EAC82CA7396A68D541C85D26508E83_97162193.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_97162193;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.285 -0400", hash_original_method = "099557EF4A3D1E47FF142271693B3FFE", hash_generated_method = "F5A3891D52B5E6B2B3C67B4259BC8C7C")
    public MessageClass getMessageClass() {
        MessageClass varB4EAC82CA7396A68D541C85D26508E83_1807954345 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1807954345 = mWrappedSmsMessage.getMessageClass();
        varB4EAC82CA7396A68D541C85D26508E83_1807954345.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1807954345;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.285 -0400", hash_original_method = "DDB62DAFB6CA28A8B02386170905555B", hash_generated_method = "FEE0856DC7105D4EDB579CBE2A79C310")
    public String getDisplayMessageBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_25537599 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_25537599 = mWrappedSmsMessage.getDisplayMessageBody();
        varB4EAC82CA7396A68D541C85D26508E83_25537599.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_25537599;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.285 -0400", hash_original_method = "A55B37ECD2D988C3EC358C7240F7EDE2", hash_generated_method = "C717D2AB01016F38F432D9E8DA0ED531")
    public String getPseudoSubject() {
        String varB4EAC82CA7396A68D541C85D26508E83_1061522153 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1061522153 = mWrappedSmsMessage.getPseudoSubject();
        varB4EAC82CA7396A68D541C85D26508E83_1061522153.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1061522153;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.286 -0400", hash_original_method = "A397C7F820656CEADBC57751F7E32997", hash_generated_method = "753926B61237CC0CDEE84BF6DE4305CB")
    public long getTimestampMillis() {
        long varD74FBED3C84830DCE4507A727CF564FC_673893256 = (mWrappedSmsMessage.getTimestampMillis());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_2146587731 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2146587731;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.286 -0400", hash_original_method = "A5B6E1F6D425F99E0AE9246791CF1B08", hash_generated_method = "5F3B615EE383DA73EF1AFBF9316F145C")
    public boolean isEmail() {
        boolean var01F26EAB74A6E76EB5CC85065B2AB42C_252143030 = (mWrappedSmsMessage.isEmail());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1638463748 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1638463748;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.286 -0400", hash_original_method = "1B76815865383567D84D772FA102258B", hash_generated_method = "0AF6EFCB84B914A8D8D71377A5D6E3DC")
    public String getEmailBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_104226158 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_104226158 = mWrappedSmsMessage.getEmailBody();
        varB4EAC82CA7396A68D541C85D26508E83_104226158.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_104226158;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.287 -0400", hash_original_method = "CF41F1C32C92AADB2191A6AB99FD49D6", hash_generated_method = "763B0C8CB950BFAB5B20FFB73E1D20AB")
    public String getEmailFrom() {
        String varB4EAC82CA7396A68D541C85D26508E83_2146261106 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2146261106 = mWrappedSmsMessage.getEmailFrom();
        varB4EAC82CA7396A68D541C85D26508E83_2146261106.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2146261106;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.287 -0400", hash_original_method = "642EF36AD67598AD564965134BACF8A1", hash_generated_method = "A4E1B6B4327AAAE5E813AAFD5EED89EB")
    public int getProtocolIdentifier() {
        int varC61A7C9212F3E9FF0CA0B745657226BD_1798846582 = (mWrappedSmsMessage.getProtocolIdentifier());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1049550475 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1049550475;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.287 -0400", hash_original_method = "36F360B7C447980FEF01C7653F551835", hash_generated_method = "096D07CFBBBB3E641720EC8749DE3D39")
    public boolean isReplace() {
        boolean varBC2D932725136F9C20C34229415D4B97_329981217 = (mWrappedSmsMessage.isReplace());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1571610938 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1571610938;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.288 -0400", hash_original_method = "553B9246636C3A5BC903932A40C4BC5E", hash_generated_method = "8668A7CE40C5500BF4C689630D3E548F")
    public boolean isCphsMwiMessage() {
        boolean var480BB749EC7EC97FE4A1651C1A8FD73E_1369610094 = (mWrappedSmsMessage.isCphsMwiMessage());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1822819819 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1822819819;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.288 -0400", hash_original_method = "129EA72B0C9F078142A2BC814FB30CFA", hash_generated_method = "6D7BECFB4B1AFB7E212BF4EC5AF42FF5")
    public boolean isMWIClearMessage() {
        boolean varB7A77ECDEC8A73E675ABF225AE837A72_293420428 = (mWrappedSmsMessage.isMWIClearMessage());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1398810134 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1398810134;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.288 -0400", hash_original_method = "5602B112C459EA0AD88653A254825A5D", hash_generated_method = "BB41AC88B58E598422BE06A70929546D")
    public boolean isMWISetMessage() {
        boolean var5B955D4A1D8E3F5634E1C3A2B25FD29A_1384301836 = (mWrappedSmsMessage.isMWISetMessage());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_763951285 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_763951285;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.289 -0400", hash_original_method = "0ACB85E19D1AFC6F8EA2F470F677C800", hash_generated_method = "1C7E08394E74439EDF9EBF1E521039DE")
    public boolean isMwiDontStore() {
        boolean var77B6C24D29DDA670F2D629741A9B498F_14849522 = (mWrappedSmsMessage.isMwiDontStore());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1241344853 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1241344853;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.289 -0400", hash_original_method = "251D6D0F20B7389DF3878BB8173A6B0A", hash_generated_method = "76A2EE506EC4465BA428976C0353887C")
    public byte[] getUserData() {
        byte[] var56EE16369B6A9056187EC70F114596AF_1729511992 = (mWrappedSmsMessage.getUserData());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_763238784 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_763238784;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.289 -0400", hash_original_method = "F61520780332A4249272ED211A1EBC6F", hash_generated_method = "EC7A41CF3EEE540C73A23476777C1326")
    public byte[] getPdu() {
        byte[] var251F1A35ECF82D698D55B42DA1ECA076_1425875540 = (mWrappedSmsMessage.getPdu());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1598125453 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1598125453;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.289 -0400", hash_original_method = "43D7E194BC6DB0E7804F1B1454D5CCBF", hash_generated_method = "26693EA4AC2D9C217AEA9E09DA975967")
    @Deprecated
    public int getStatusOnSim() {
        int var9C85A772E629F12E0A5C09948CEAF5CB_593854545 = (mWrappedSmsMessage.getStatusOnIcc());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_430891153 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_430891153;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.290 -0400", hash_original_method = "F41186F27A3FFD01878B6A79ACBBD00F", hash_generated_method = "F7966AB32C34D947B959F80C3B3DBD9A")
    public int getStatusOnIcc() {
        int var9C85A772E629F12E0A5C09948CEAF5CB_605512939 = (mWrappedSmsMessage.getStatusOnIcc());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1342039431 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1342039431;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.290 -0400", hash_original_method = "150B1A5BD8253701A69C723196BA6DF9", hash_generated_method = "C504E9AB641321B4C647A45643180DCB")
    @Deprecated
    public int getIndexOnSim() {
        int varAAC43D666C403A91DB1773E11797D5BC_1492207171 = (mWrappedSmsMessage.getIndexOnIcc());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1408396837 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1408396837;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.290 -0400", hash_original_method = "4C0DE2049D9873C839084BE4DC285920", hash_generated_method = "6BDC7FABADF01857B06228B38701F1F0")
    public int getIndexOnIcc() {
        int varAAC43D666C403A91DB1773E11797D5BC_1135916239 = (mWrappedSmsMessage.getIndexOnIcc());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2130330026 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2130330026;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.291 -0400", hash_original_method = "BAA167F31D67CF27268081CFB0D79A6E", hash_generated_method = "57FCEF16F31160332CE7FB342EBFFF96")
    public int getStatus() {
        int var21EB021D474B531470E6B8E8AADA37C0_966513044 = (mWrappedSmsMessage.getStatus());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_541361984 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_541361984;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.291 -0400", hash_original_method = "D10C36D7B6CDC51D018139E7A34B7076", hash_generated_method = "5E6F6BC41E9F5ACEBA5EC01C82A2884F")
    public boolean isStatusReportMessage() {
        boolean varA3C3DB4C7E404E711EF55D5064B97BE1_943291852 = (mWrappedSmsMessage.isStatusReportMessage());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1273775958 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1273775958;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.292 -0400", hash_original_method = "F508F532A25EB5B4727057181F2BF528", hash_generated_method = "4B8EEA692ABA2B8954D1AD0D2C4D75C1")
    public boolean isReplyPathPresent() {
        boolean var52B036373B56F8584D28911DD9CACB80_387889566 = (mWrappedSmsMessage.isReplyPathPresent());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_918319527 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_918319527;
        
        
    }

    
    public enum MessageClass{
        UNKNOWN, CLASS_0, CLASS_1, CLASS_2, CLASS_3;
    }

    
    public static class SubmitPdu {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.292 -0400", hash_original_field = "275E12BC2D1B7A1135AB78E2E8FED5C1", hash_generated_field = "B7E7B1E4BBABCFD1218DEF1D08E579CA")

        public byte[] encodedScAddress;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.292 -0400", hash_original_field = "482E018453FC47667D6222532DFEB427", hash_generated_field = "59202226E3585983001906EF1AF63678")

        public byte[] encodedMessage;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.292 -0400", hash_original_method = "84E90F8D80D26E2676EED6BCE3E65E06", hash_generated_method = "D65631A9BDFFB9B21266433BCDB38CFF")
        protected  SubmitPdu(SubmitPduBase spb) {
            this.encodedMessage = spb.encodedMessage;
            this.encodedScAddress = spb.encodedScAddress;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.293 -0400", hash_original_method = "A866707516A0999C629C71FD5B45C6F7", hash_generated_method = "81EE9972FC3A2FB22E0A1A4DDFE965BA")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_2096754717 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_2096754717 = "SubmitPdu: encodedScAddress = "
                    + Arrays.toString(encodedScAddress)
                    + ", encodedMessage = "
                    + Arrays.toString(encodedMessage);
            varB4EAC82CA7396A68D541C85D26508E83_2096754717.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_2096754717;
            
            
                    
                    
                    
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.293 -0400", hash_original_field = "57729A6D26DD4D4E055A9FC1069E9025", hash_generated_field = "5D6970F5D62D74D2B187EA5DA34AA652")

    private static final String LOG_TAG = "SMS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.293 -0400", hash_original_field = "911D041943DE84D698667C86C3960E87", hash_generated_field = "27499AC5501958C24E1C878C00171D98")

    public static final int ENCODING_UNKNOWN = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.294 -0400", hash_original_field = "7C09D1CF68EDD64482420E88F8FAE8AB", hash_generated_field = "E3BD113EFA27FC80F1215EAC10F05F54")

    public static final int ENCODING_7BIT = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.294 -0400", hash_original_field = "4590BC9E0C03D7C72E5C28B0B321E9EB", hash_generated_field = "C6C4A2BD27CE6056084528ABE2108D41")

    public static final int ENCODING_8BIT = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.294 -0400", hash_original_field = "F2D1F619912C053120A34953383D3646", hash_generated_field = "A5A42D0A35339D86DEBBCEB46B9756FA")

    public static final int ENCODING_16BIT = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.294 -0400", hash_original_field = "9246C4EDF2F885233B87AF292514FF5C", hash_generated_field = "9FA989A1AC757B009256AA97A922831A")

    public static final int ENCODING_KSC5601 = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.294 -0400", hash_original_field = "352387DBC99D8AD424E083939B69C383", hash_generated_field = "0257BE4B4F208A23154B8F18AB43FEC5")

    public static final int MAX_USER_DATA_BYTES = 140;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.294 -0400", hash_original_field = "A89974340D019FDC13B3C5FC97BE4835", hash_generated_field = "C84733D22240FE9846722841159ECECC")

    public static final int MAX_USER_DATA_BYTES_WITH_HEADER = 134;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.294 -0400", hash_original_field = "041FD9CA1258920783716DC1DA6DF2B6", hash_generated_field = "BA710E28657EDC31EF8505D2CAA6A62C")

    public static final int MAX_USER_DATA_SEPTETS = 160;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.294 -0400", hash_original_field = "84A0A722A9089067E4B926DB02EF4D0A", hash_generated_field = "1E7DC369DA9053C67AF8B9AB932C4C33")

    public static final int MAX_USER_DATA_SEPTETS_WITH_HEADER = 153;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.294 -0400", hash_original_field = "625E8B197AE38860F6473EFEC71B0EBF", hash_generated_field = "1A314915591575EE5AB81A039C2EA299")

    public static final String FORMAT_3GPP = "3gpp";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.294 -0400", hash_original_field = "1EC59ECA713D8BA4FBE781F641A8893D", hash_generated_field = "D953DB3D95F249D4E9F6EAC3FC5F26A3")

    public static final String FORMAT_3GPP2 = "3gpp2";
}

