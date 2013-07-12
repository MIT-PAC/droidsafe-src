package android.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.584 -0400", hash_original_field = "6C6FE296324BD37F8F46A4EDA590FE7A", hash_generated_field = "6512A5313A4B16FABCD0C4BB52D92A5B")

    public SmsMessageBase mWrappedSmsMessage;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.584 -0400", hash_original_method = "8785081C14DC1062450E96A46CF3DF25", hash_generated_method = "7A720F4140A5D3175262E2DF902BCE6A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.587 -0400", hash_original_method = "918A2835DDADF3191B8B6CF8127F286C", hash_generated_method = "7769F524268DD45D85A6458B45305576")
    public String getServiceCenterAddress() {
String var925E36433672E3787EB66016D3EC0AE0_1046036553 =         mWrappedSmsMessage.getServiceCenterAddress();
        var925E36433672E3787EB66016D3EC0AE0_1046036553.addTaint(taint);
        return var925E36433672E3787EB66016D3EC0AE0_1046036553;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getServiceCenterAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.587 -0400", hash_original_method = "E9EFC86835C6B2F047600D750A41AA1C", hash_generated_method = "16BA18FB4418E14C893CDF0049F217D3")
    public String getOriginatingAddress() {
String var49AF36764A3915031147328D13EC74EE_2144509711 =         mWrappedSmsMessage.getOriginatingAddress();
        var49AF36764A3915031147328D13EC74EE_2144509711.addTaint(taint);
        return var49AF36764A3915031147328D13EC74EE_2144509711;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getOriginatingAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.588 -0400", hash_original_method = "A66BB5C1A20948050FC14BD05462FCCC", hash_generated_method = "657B28B13592C9B0D63BCF969A0F7690")
    public String getDisplayOriginatingAddress() {
String var396DE6F0D854D262064C40FA2AC292EB_258481307 =         mWrappedSmsMessage.getDisplayOriginatingAddress();
        var396DE6F0D854D262064C40FA2AC292EB_258481307.addTaint(taint);
        return var396DE6F0D854D262064C40FA2AC292EB_258481307;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getDisplayOriginatingAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.588 -0400", hash_original_method = "11C71A7ADD8F40537023F3C9896D9F41", hash_generated_method = "735CADAAEB6D6B3AF356882B9F027722")
    public String getMessageBody() {
String var0E1B253B3A7C288458E5036AB1FC4915_1677302091 =         mWrappedSmsMessage.getMessageBody();
        var0E1B253B3A7C288458E5036AB1FC4915_1677302091.addTaint(taint);
        return var0E1B253B3A7C288458E5036AB1FC4915_1677302091;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getMessageBody();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.588 -0400", hash_original_method = "099557EF4A3D1E47FF142271693B3FFE", hash_generated_method = "1D99B1DF221E7BF04C3CF8E2376667FA")
    public MessageClass getMessageClass() {
MessageClass varFEC2C330D72D70FD4F363F58E2613062_600761964 =         mWrappedSmsMessage.getMessageClass();
        varFEC2C330D72D70FD4F363F58E2613062_600761964.addTaint(taint);
        return varFEC2C330D72D70FD4F363F58E2613062_600761964;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getMessageClass();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.588 -0400", hash_original_method = "DDB62DAFB6CA28A8B02386170905555B", hash_generated_method = "853273862F4670D516DAB6D846C3F83A")
    public String getDisplayMessageBody() {
String var99CD2E836DDD081526689EFA5A3D13FD_20279878 =         mWrappedSmsMessage.getDisplayMessageBody();
        var99CD2E836DDD081526689EFA5A3D13FD_20279878.addTaint(taint);
        return var99CD2E836DDD081526689EFA5A3D13FD_20279878;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getDisplayMessageBody();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.588 -0400", hash_original_method = "A55B37ECD2D988C3EC358C7240F7EDE2", hash_generated_method = "005B0B48717CFFEED5339654E0FC6BB6")
    public String getPseudoSubject() {
String var678AD1F33CD9A4D7B1E9CB845197D6D6_1199834128 =         mWrappedSmsMessage.getPseudoSubject();
        var678AD1F33CD9A4D7B1E9CB845197D6D6_1199834128.addTaint(taint);
        return var678AD1F33CD9A4D7B1E9CB845197D6D6_1199834128;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getPseudoSubject();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.588 -0400", hash_original_method = "A397C7F820656CEADBC57751F7E32997", hash_generated_method = "9CF76FE8A287B3B2C8DDC5C9D156B7E3")
    public long getTimestampMillis() {
        long var6092B16D96793A76A598DA9FEA7F3867_897050658 = (mWrappedSmsMessage.getTimestampMillis());
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1940062890 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1940062890;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getTimestampMillis();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.589 -0400", hash_original_method = "A5B6E1F6D425F99E0AE9246791CF1B08", hash_generated_method = "E8BB5AE46D8604196E6C729925F9C7FD")
    public boolean isEmail() {
        boolean var4E1F5C64E20847E31953992E560A1C78_1320747365 = (mWrappedSmsMessage.isEmail());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_464745705 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_464745705;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.isEmail();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.589 -0400", hash_original_method = "1B76815865383567D84D772FA102258B", hash_generated_method = "A16751CE5E0C8A943147AB0223F24078")
    public String getEmailBody() {
String var67A1D8B8DD5E36D76DD3DF492B86B2D9_421842944 =         mWrappedSmsMessage.getEmailBody();
        var67A1D8B8DD5E36D76DD3DF492B86B2D9_421842944.addTaint(taint);
        return var67A1D8B8DD5E36D76DD3DF492B86B2D9_421842944;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getEmailBody();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.589 -0400", hash_original_method = "CF41F1C32C92AADB2191A6AB99FD49D6", hash_generated_method = "F52AF8DD4A9E9802400A4074DA4A22CA")
    public String getEmailFrom() {
String var386E04FEBE237FE6A60C9EC9B5FDA847_696326798 =         mWrappedSmsMessage.getEmailFrom();
        var386E04FEBE237FE6A60C9EC9B5FDA847_696326798.addTaint(taint);
        return var386E04FEBE237FE6A60C9EC9B5FDA847_696326798;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getEmailFrom();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.589 -0400", hash_original_method = "642EF36AD67598AD564965134BACF8A1", hash_generated_method = "F521E44F639BED6C08F2ADA833F03699")
    public int getProtocolIdentifier() {
        int varAD2233615CF88E8755DD6227D5F9F05E_1413272166 = (mWrappedSmsMessage.getProtocolIdentifier());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_941658242 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_941658242;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getProtocolIdentifier();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.589 -0400", hash_original_method = "36F360B7C447980FEF01C7653F551835", hash_generated_method = "AACB400C5028731034770F8C24A5777F")
    public boolean isReplace() {
        boolean var06FECE350D4286FB19C9957C5A58184C_211578605 = (mWrappedSmsMessage.isReplace());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_123016426 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_123016426;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.isReplace();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.590 -0400", hash_original_method = "553B9246636C3A5BC903932A40C4BC5E", hash_generated_method = "6D9931E50E62BC7D9C1B1A5B2A10444C")
    public boolean isCphsMwiMessage() {
        boolean var2CB3BE886F81C8D84F89B7191B76A987_1850956486 = (mWrappedSmsMessage.isCphsMwiMessage());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1780569352 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1780569352;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.isCphsMwiMessage();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.590 -0400", hash_original_method = "129EA72B0C9F078142A2BC814FB30CFA", hash_generated_method = "F41C98D5F2716FDAF745FF5F65497AB6")
    public boolean isMWIClearMessage() {
        boolean var585E54B2A33AB110879B00E57A8DA3AC_951848242 = (mWrappedSmsMessage.isMWIClearMessage());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1196970684 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1196970684;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.isMWIClearMessage();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.590 -0400", hash_original_method = "5602B112C459EA0AD88653A254825A5D", hash_generated_method = "F32CF3AE3E0381B60BB630EF79210679")
    public boolean isMWISetMessage() {
        boolean varD5BCFAED004ACF905D1919AA002AA2D6_1285387868 = (mWrappedSmsMessage.isMWISetMessage());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1515611516 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1515611516;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.isMWISetMessage();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.590 -0400", hash_original_method = "0ACB85E19D1AFC6F8EA2F470F677C800", hash_generated_method = "AF5B3D8B9FB9B918029390A2491DDDF1")
    public boolean isMwiDontStore() {
        boolean varC52B74AF143B5C422B7F5834D68C697B_476782620 = (mWrappedSmsMessage.isMwiDontStore());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_526405308 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_526405308;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.isMwiDontStore();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.591 -0400", hash_original_method = "251D6D0F20B7389DF3878BB8173A6B0A", hash_generated_method = "B552EBA037F6994B98F95A532332495E")
    public byte[] getUserData() {
        byte[] varAE688663295359FE46DD9965D5DEA56C_789467304 = (mWrappedSmsMessage.getUserData());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1258473094 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1258473094;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getUserData();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.591 -0400", hash_original_method = "F61520780332A4249272ED211A1EBC6F", hash_generated_method = "5A734D34A8874A3FA3ADD7006555DAE1")
    public byte[] getPdu() {
        byte[] var6023B6186A54154A7A7D4B28633F6539_1131852732 = (mWrappedSmsMessage.getPdu());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1787494476 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1787494476;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getPdu();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.591 -0400", hash_original_method = "43D7E194BC6DB0E7804F1B1454D5CCBF", hash_generated_method = "511F4807B653D2AE9CD4B4BEB9B5831C")
    @Deprecated
    public int getStatusOnSim() {
        int var6705C6C34F6F35245059CF05D5A30A79_2009467649 = (mWrappedSmsMessage.getStatusOnIcc());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1845552129 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1845552129;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getStatusOnIcc();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.591 -0400", hash_original_method = "F41186F27A3FFD01878B6A79ACBBD00F", hash_generated_method = "C6953BD973F36FEDC985F9A55A0920F1")
    public int getStatusOnIcc() {
        int var6705C6C34F6F35245059CF05D5A30A79_433908151 = (mWrappedSmsMessage.getStatusOnIcc());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1988325651 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1988325651;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getStatusOnIcc();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.592 -0400", hash_original_method = "150B1A5BD8253701A69C723196BA6DF9", hash_generated_method = "4EB354CB339C4B4A07B67EA66B4ADC1C")
    @Deprecated
    public int getIndexOnSim() {
        int var271A3E7297F00EC935218314ED9D7914_914990241 = (mWrappedSmsMessage.getIndexOnIcc());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1647856835 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1647856835;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getIndexOnIcc();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.592 -0400", hash_original_method = "4C0DE2049D9873C839084BE4DC285920", hash_generated_method = "8B7050A1625C8EC1769A86FF9D082B49")
    public int getIndexOnIcc() {
        int var271A3E7297F00EC935218314ED9D7914_575069843 = (mWrappedSmsMessage.getIndexOnIcc());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1595635363 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1595635363;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getIndexOnIcc();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.592 -0400", hash_original_method = "BAA167F31D67CF27268081CFB0D79A6E", hash_generated_method = "5AA7A7ADF4B47C67163239F44EB34E20")
    public int getStatus() {
        int varC7235C304F4004D9DB17AB9D2508C3F8_1959096248 = (mWrappedSmsMessage.getStatus());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1706203620 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1706203620;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getStatus();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.592 -0400", hash_original_method = "D10C36D7B6CDC51D018139E7A34B7076", hash_generated_method = "38428E71EF88E285F7B25A9295A1CDAF")
    public boolean isStatusReportMessage() {
        boolean varF6F4855214EC06155F20F1677431168C_1265675570 = (mWrappedSmsMessage.isStatusReportMessage());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1649576051 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1649576051;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.isStatusReportMessage();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.593 -0400", hash_original_method = "F508F532A25EB5B4727057181F2BF528", hash_generated_method = "1AFBA7D70FDAE2EB6B84713191636AEC")
    public boolean isReplyPathPresent() {
        boolean varE830695720B1EA9A9595E946A69A7A07_1008332661 = (mWrappedSmsMessage.isReplyPathPresent());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2128207151 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2128207151;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.isReplyPathPresent();
    }

    
    public enum MessageClass{
        UNKNOWN, CLASS_0, CLASS_1, CLASS_2, CLASS_3;
    }

    
    public static class SubmitPdu {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.593 -0400", hash_original_field = "275E12BC2D1B7A1135AB78E2E8FED5C1", hash_generated_field = "B7E7B1E4BBABCFD1218DEF1D08E579CA")

        public byte[] encodedScAddress;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.593 -0400", hash_original_field = "482E018453FC47667D6222532DFEB427", hash_generated_field = "59202226E3585983001906EF1AF63678")

        public byte[] encodedMessage;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.593 -0400", hash_original_method = "84E90F8D80D26E2676EED6BCE3E65E06", hash_generated_method = "D65631A9BDFFB9B21266433BCDB38CFF")
        protected  SubmitPdu(SubmitPduBase spb) {
            this.encodedMessage = spb.encodedMessage;
            this.encodedScAddress = spb.encodedScAddress;
            // ---------- Original Method ----------
            //this.encodedMessage = spb.encodedMessage;
            //this.encodedScAddress = spb.encodedScAddress;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.594 -0400", hash_original_method = "A866707516A0999C629C71FD5B45C6F7", hash_generated_method = "8B7F78F4CFC360816DCCBDEDA7A7B876")
        public String toString() {
String var7D8267AB38F2C416692BE7250E9741D6_73946129 =             "SubmitPdu: encodedScAddress = "
                    + Arrays.toString(encodedScAddress)
                    + ", encodedMessage = "
                    + Arrays.toString(encodedMessage);
            var7D8267AB38F2C416692BE7250E9741D6_73946129.addTaint(taint);
            return var7D8267AB38F2C416692BE7250E9741D6_73946129;
            // ---------- Original Method ----------
            //return "SubmitPdu: encodedScAddress = "
                    //+ Arrays.toString(encodedScAddress)
                    //+ ", encodedMessage = "
                    //+ Arrays.toString(encodedMessage);
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.594 -0400", hash_original_field = "57729A6D26DD4D4E055A9FC1069E9025", hash_generated_field = "5D6970F5D62D74D2B187EA5DA34AA652")

    private static final String LOG_TAG = "SMS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.594 -0400", hash_original_field = "911D041943DE84D698667C86C3960E87", hash_generated_field = "27499AC5501958C24E1C878C00171D98")

    public static final int ENCODING_UNKNOWN = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.594 -0400", hash_original_field = "7C09D1CF68EDD64482420E88F8FAE8AB", hash_generated_field = "E3BD113EFA27FC80F1215EAC10F05F54")

    public static final int ENCODING_7BIT = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.594 -0400", hash_original_field = "4590BC9E0C03D7C72E5C28B0B321E9EB", hash_generated_field = "C6C4A2BD27CE6056084528ABE2108D41")

    public static final int ENCODING_8BIT = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.594 -0400", hash_original_field = "F2D1F619912C053120A34953383D3646", hash_generated_field = "A5A42D0A35339D86DEBBCEB46B9756FA")

    public static final int ENCODING_16BIT = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.594 -0400", hash_original_field = "9246C4EDF2F885233B87AF292514FF5C", hash_generated_field = "9FA989A1AC757B009256AA97A922831A")

    public static final int ENCODING_KSC5601 = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.594 -0400", hash_original_field = "352387DBC99D8AD424E083939B69C383", hash_generated_field = "0257BE4B4F208A23154B8F18AB43FEC5")

    public static final int MAX_USER_DATA_BYTES = 140;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.594 -0400", hash_original_field = "A89974340D019FDC13B3C5FC97BE4835", hash_generated_field = "C84733D22240FE9846722841159ECECC")

    public static final int MAX_USER_DATA_BYTES_WITH_HEADER = 134;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.594 -0400", hash_original_field = "041FD9CA1258920783716DC1DA6DF2B6", hash_generated_field = "BA710E28657EDC31EF8505D2CAA6A62C")

    public static final int MAX_USER_DATA_SEPTETS = 160;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.594 -0400", hash_original_field = "84A0A722A9089067E4B926DB02EF4D0A", hash_generated_field = "1E7DC369DA9053C67AF8B9AB932C4C33")

    public static final int MAX_USER_DATA_SEPTETS_WITH_HEADER = 153;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.594 -0400", hash_original_field = "625E8B197AE38860F6473EFEC71B0EBF", hash_generated_field = "1A314915591575EE5AB81A039C2EA299")

    public static final String FORMAT_3GPP = "3gpp";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.594 -0400", hash_original_field = "1EC59ECA713D8BA4FBE781F641A8893D", hash_generated_field = "D953DB3D95F249D4E9F6EAC3FC5F26A3")

    public static final String FORMAT_3GPP2 = "3gpp2";
}

