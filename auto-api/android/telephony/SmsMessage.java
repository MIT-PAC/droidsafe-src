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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:35.839 -0400", hash_original_field = "6C6FE296324BD37F8F46A4EDA590FE7A", hash_generated_field = "6512A5313A4B16FABCD0C4BB52D92A5B")

    public SmsMessageBase mWrappedSmsMessage;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:35.840 -0400", hash_original_method = "8785081C14DC1062450E96A46CF3DF25", hash_generated_method = "7A720F4140A5D3175262E2DF902BCE6A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:35.875 -0400", hash_original_method = "918A2835DDADF3191B8B6CF8127F286C", hash_generated_method = "DEC51078BB634D8D006EC0736E8847B7")
    public String getServiceCenterAddress() {
        String varB4EAC82CA7396A68D541C85D26508E83_1492970564 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1492970564 = mWrappedSmsMessage.getServiceCenterAddress();
        varB4EAC82CA7396A68D541C85D26508E83_1492970564.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1492970564;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getServiceCenterAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:35.880 -0400", hash_original_method = "E9EFC86835C6B2F047600D750A41AA1C", hash_generated_method = "E0834B9A0E8E60C53C0E0B7806D49BF9")
    public String getOriginatingAddress() {
        String varB4EAC82CA7396A68D541C85D26508E83_587666939 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_587666939 = mWrappedSmsMessage.getOriginatingAddress();
        varB4EAC82CA7396A68D541C85D26508E83_587666939.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_587666939;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getOriginatingAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:35.881 -0400", hash_original_method = "A66BB5C1A20948050FC14BD05462FCCC", hash_generated_method = "4998D92E7D38EA7E250CBFF477D51D68")
    public String getDisplayOriginatingAddress() {
        String varB4EAC82CA7396A68D541C85D26508E83_9964259 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_9964259 = mWrappedSmsMessage.getDisplayOriginatingAddress();
        varB4EAC82CA7396A68D541C85D26508E83_9964259.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_9964259;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getDisplayOriginatingAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:35.882 -0400", hash_original_method = "11C71A7ADD8F40537023F3C9896D9F41", hash_generated_method = "A014F2B1912CC04DF6C5B7979A7578D8")
    public String getMessageBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_495459738 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_495459738 = mWrappedSmsMessage.getMessageBody();
        varB4EAC82CA7396A68D541C85D26508E83_495459738.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_495459738;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getMessageBody();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:35.892 -0400", hash_original_method = "099557EF4A3D1E47FF142271693B3FFE", hash_generated_method = "999F34147150EF14C2D36233D10DD8A4")
    public MessageClass getMessageClass() {
        MessageClass varB4EAC82CA7396A68D541C85D26508E83_2107706272 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2107706272 = mWrappedSmsMessage.getMessageClass();
        varB4EAC82CA7396A68D541C85D26508E83_2107706272.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2107706272;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getMessageClass();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:35.893 -0400", hash_original_method = "DDB62DAFB6CA28A8B02386170905555B", hash_generated_method = "A98029E26CB17F593E37040082D39BA8")
    public String getDisplayMessageBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1930500753 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1930500753 = mWrappedSmsMessage.getDisplayMessageBody();
        varB4EAC82CA7396A68D541C85D26508E83_1930500753.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1930500753;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getDisplayMessageBody();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:35.910 -0400", hash_original_method = "A55B37ECD2D988C3EC358C7240F7EDE2", hash_generated_method = "9AABF851478FCCC67EA803FE06679AFD")
    public String getPseudoSubject() {
        String varB4EAC82CA7396A68D541C85D26508E83_1800101989 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1800101989 = mWrappedSmsMessage.getPseudoSubject();
        varB4EAC82CA7396A68D541C85D26508E83_1800101989.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1800101989;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getPseudoSubject();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:35.911 -0400", hash_original_method = "A397C7F820656CEADBC57751F7E32997", hash_generated_method = "C9A94D3203135CD897A9FD487F493F6E")
    public long getTimestampMillis() {
        long varD74FBED3C84830DCE4507A727CF564FC_946177926 = (mWrappedSmsMessage.getTimestampMillis());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_841645728 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_841645728;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getTimestampMillis();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:35.911 -0400", hash_original_method = "A5B6E1F6D425F99E0AE9246791CF1B08", hash_generated_method = "77C40E24303C437A27C09358192E5C60")
    public boolean isEmail() {
        boolean var01F26EAB74A6E76EB5CC85065B2AB42C_143681633 = (mWrappedSmsMessage.isEmail());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2046681135 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2046681135;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.isEmail();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:35.911 -0400", hash_original_method = "1B76815865383567D84D772FA102258B", hash_generated_method = "EDD6E4571B03CAE37D74AD2D249DAC84")
    public String getEmailBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1117131807 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1117131807 = mWrappedSmsMessage.getEmailBody();
        varB4EAC82CA7396A68D541C85D26508E83_1117131807.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1117131807;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getEmailBody();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:35.921 -0400", hash_original_method = "CF41F1C32C92AADB2191A6AB99FD49D6", hash_generated_method = "A6E97332602393577FC83E995989C265")
    public String getEmailFrom() {
        String varB4EAC82CA7396A68D541C85D26508E83_725185491 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_725185491 = mWrappedSmsMessage.getEmailFrom();
        varB4EAC82CA7396A68D541C85D26508E83_725185491.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_725185491;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getEmailFrom();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:35.922 -0400", hash_original_method = "642EF36AD67598AD564965134BACF8A1", hash_generated_method = "99660CF7130849A3F899EFBBE0787E2A")
    public int getProtocolIdentifier() {
        int varC61A7C9212F3E9FF0CA0B745657226BD_603148310 = (mWrappedSmsMessage.getProtocolIdentifier());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1989833565 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1989833565;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getProtocolIdentifier();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:35.923 -0400", hash_original_method = "36F360B7C447980FEF01C7653F551835", hash_generated_method = "06471CC4D8CD4C62CD6018385017C8FC")
    public boolean isReplace() {
        boolean varBC2D932725136F9C20C34229415D4B97_35652524 = (mWrappedSmsMessage.isReplace());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_909337431 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_909337431;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.isReplace();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:35.923 -0400", hash_original_method = "553B9246636C3A5BC903932A40C4BC5E", hash_generated_method = "8B780D882F92497E54E0683887746ED0")
    public boolean isCphsMwiMessage() {
        boolean var480BB749EC7EC97FE4A1651C1A8FD73E_2051583244 = (mWrappedSmsMessage.isCphsMwiMessage());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_235097830 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_235097830;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.isCphsMwiMessage();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:35.924 -0400", hash_original_method = "129EA72B0C9F078142A2BC814FB30CFA", hash_generated_method = "482A2D5B0F58756FDF6037490973A63F")
    public boolean isMWIClearMessage() {
        boolean varB7A77ECDEC8A73E675ABF225AE837A72_394905616 = (mWrappedSmsMessage.isMWIClearMessage());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1701343340 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1701343340;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.isMWIClearMessage();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:35.924 -0400", hash_original_method = "5602B112C459EA0AD88653A254825A5D", hash_generated_method = "FD4A2B7A97EAE2D82E9F6BBBA38F7F73")
    public boolean isMWISetMessage() {
        boolean var5B955D4A1D8E3F5634E1C3A2B25FD29A_825396210 = (mWrappedSmsMessage.isMWISetMessage());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_659500798 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_659500798;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.isMWISetMessage();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:35.928 -0400", hash_original_method = "0ACB85E19D1AFC6F8EA2F470F677C800", hash_generated_method = "74034A2F2093B1CFDADEC074E3230604")
    public boolean isMwiDontStore() {
        boolean var77B6C24D29DDA670F2D629741A9B498F_706420774 = (mWrappedSmsMessage.isMwiDontStore());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_202040617 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_202040617;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.isMwiDontStore();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:35.929 -0400", hash_original_method = "251D6D0F20B7389DF3878BB8173A6B0A", hash_generated_method = "A74AC291DD699C62113859FFA0B7C9DC")
    public byte[] getUserData() {
        byte[] var56EE16369B6A9056187EC70F114596AF_1279460952 = (mWrappedSmsMessage.getUserData());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_108075265 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_108075265;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getUserData();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:35.929 -0400", hash_original_method = "F61520780332A4249272ED211A1EBC6F", hash_generated_method = "1530D8DDD653B1E83327EAA788635619")
    public byte[] getPdu() {
        byte[] var251F1A35ECF82D698D55B42DA1ECA076_76385482 = (mWrappedSmsMessage.getPdu());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_880443572 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_880443572;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getPdu();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:35.944 -0400", hash_original_method = "43D7E194BC6DB0E7804F1B1454D5CCBF", hash_generated_method = "F7E52BC0FBF7B3E4344D17C7E41B5804")
    @Deprecated
    public int getStatusOnSim() {
        int var9C85A772E629F12E0A5C09948CEAF5CB_582178465 = (mWrappedSmsMessage.getStatusOnIcc());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1900199010 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1900199010;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getStatusOnIcc();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:35.945 -0400", hash_original_method = "F41186F27A3FFD01878B6A79ACBBD00F", hash_generated_method = "227B9718BB9E6D5651D2D2528CBC1822")
    public int getStatusOnIcc() {
        int var9C85A772E629F12E0A5C09948CEAF5CB_1672417644 = (mWrappedSmsMessage.getStatusOnIcc());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_171570349 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_171570349;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getStatusOnIcc();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:35.945 -0400", hash_original_method = "150B1A5BD8253701A69C723196BA6DF9", hash_generated_method = "C454BA6D90771BF3EA4F160B6A49E8E6")
    @Deprecated
    public int getIndexOnSim() {
        int varAAC43D666C403A91DB1773E11797D5BC_716630859 = (mWrappedSmsMessage.getIndexOnIcc());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_663657647 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_663657647;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getIndexOnIcc();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:35.947 -0400", hash_original_method = "4C0DE2049D9873C839084BE4DC285920", hash_generated_method = "9FE26A0511555EDC20139606194A25BB")
    public int getIndexOnIcc() {
        int varAAC43D666C403A91DB1773E11797D5BC_814974435 = (mWrappedSmsMessage.getIndexOnIcc());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2025473514 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2025473514;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getIndexOnIcc();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:35.950 -0400", hash_original_method = "BAA167F31D67CF27268081CFB0D79A6E", hash_generated_method = "A94ADD83BED0349F92C147BE6A8C11AF")
    public int getStatus() {
        int var21EB021D474B531470E6B8E8AADA37C0_2027864845 = (mWrappedSmsMessage.getStatus());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1118195591 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1118195591;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getStatus();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:35.951 -0400", hash_original_method = "D10C36D7B6CDC51D018139E7A34B7076", hash_generated_method = "76E9E7672A1CA42226E07D5698C0B6B8")
    public boolean isStatusReportMessage() {
        boolean varA3C3DB4C7E404E711EF55D5064B97BE1_1775344736 = (mWrappedSmsMessage.isStatusReportMessage());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2058290281 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2058290281;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.isStatusReportMessage();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:35.951 -0400", hash_original_method = "F508F532A25EB5B4727057181F2BF528", hash_generated_method = "B7F61519488699FC19C5DF68045DE052")
    public boolean isReplyPathPresent() {
        boolean var52B036373B56F8584D28911DD9CACB80_70950958 = (mWrappedSmsMessage.isReplyPathPresent());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1370297381 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1370297381;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.isReplyPathPresent();
    }

    
    public enum MessageClass{
        UNKNOWN, CLASS_0, CLASS_1, CLASS_2, CLASS_3;
    }

    
    public static class SubmitPdu {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:35.955 -0400", hash_original_field = "275E12BC2D1B7A1135AB78E2E8FED5C1", hash_generated_field = "B7E7B1E4BBABCFD1218DEF1D08E579CA")

        public byte[] encodedScAddress;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:35.955 -0400", hash_original_field = "482E018453FC47667D6222532DFEB427", hash_generated_field = "59202226E3585983001906EF1AF63678")

        public byte[] encodedMessage;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:35.957 -0400", hash_original_method = "84E90F8D80D26E2676EED6BCE3E65E06", hash_generated_method = "D65631A9BDFFB9B21266433BCDB38CFF")
        protected  SubmitPdu(SubmitPduBase spb) {
            this.encodedMessage = spb.encodedMessage;
            this.encodedScAddress = spb.encodedScAddress;
            // ---------- Original Method ----------
            //this.encodedMessage = spb.encodedMessage;
            //this.encodedScAddress = spb.encodedScAddress;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:35.964 -0400", hash_original_method = "A866707516A0999C629C71FD5B45C6F7", hash_generated_method = "9000398AC3A90D02B7BCE69807A4399F")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_933656461 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_933656461 = "SubmitPdu: encodedScAddress = "
                    + Arrays.toString(encodedScAddress)
                    + ", encodedMessage = "
                    + Arrays.toString(encodedMessage);
            varB4EAC82CA7396A68D541C85D26508E83_933656461.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_933656461;
            // ---------- Original Method ----------
            //return "SubmitPdu: encodedScAddress = "
                    //+ Arrays.toString(encodedScAddress)
                    //+ ", encodedMessage = "
                    //+ Arrays.toString(encodedMessage);
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:35.968 -0400", hash_original_field = "57729A6D26DD4D4E055A9FC1069E9025", hash_generated_field = "FD8B5B4E0106F47C81A9C32406FD056B")

    private static String LOG_TAG = "SMS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:35.968 -0400", hash_original_field = "911D041943DE84D698667C86C3960E87", hash_generated_field = "27499AC5501958C24E1C878C00171D98")

    public static final int ENCODING_UNKNOWN = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:35.968 -0400", hash_original_field = "7C09D1CF68EDD64482420E88F8FAE8AB", hash_generated_field = "E3BD113EFA27FC80F1215EAC10F05F54")

    public static final int ENCODING_7BIT = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:35.969 -0400", hash_original_field = "4590BC9E0C03D7C72E5C28B0B321E9EB", hash_generated_field = "C6C4A2BD27CE6056084528ABE2108D41")

    public static final int ENCODING_8BIT = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:35.969 -0400", hash_original_field = "F2D1F619912C053120A34953383D3646", hash_generated_field = "A5A42D0A35339D86DEBBCEB46B9756FA")

    public static final int ENCODING_16BIT = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:35.969 -0400", hash_original_field = "9246C4EDF2F885233B87AF292514FF5C", hash_generated_field = "9FA989A1AC757B009256AA97A922831A")

    public static final int ENCODING_KSC5601 = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:35.969 -0400", hash_original_field = "352387DBC99D8AD424E083939B69C383", hash_generated_field = "0257BE4B4F208A23154B8F18AB43FEC5")

    public static final int MAX_USER_DATA_BYTES = 140;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:35.969 -0400", hash_original_field = "A89974340D019FDC13B3C5FC97BE4835", hash_generated_field = "C84733D22240FE9846722841159ECECC")

    public static final int MAX_USER_DATA_BYTES_WITH_HEADER = 134;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:35.969 -0400", hash_original_field = "041FD9CA1258920783716DC1DA6DF2B6", hash_generated_field = "BA710E28657EDC31EF8505D2CAA6A62C")

    public static final int MAX_USER_DATA_SEPTETS = 160;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.059 -0400", hash_original_field = "84A0A722A9089067E4B926DB02EF4D0A", hash_generated_field = "1E7DC369DA9053C67AF8B9AB932C4C33")

    public static final int MAX_USER_DATA_SEPTETS_WITH_HEADER = 153;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.059 -0400", hash_original_field = "625E8B197AE38860F6473EFEC71B0EBF", hash_generated_field = "1A314915591575EE5AB81A039C2EA299")

    public static final String FORMAT_3GPP = "3gpp";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:36.059 -0400", hash_original_field = "1EC59ECA713D8BA4FBE781F641A8893D", hash_generated_field = "D953DB3D95F249D4E9F6EAC3FC5F26A3")

    public static final String FORMAT_3GPP2 = "3gpp2";
}

