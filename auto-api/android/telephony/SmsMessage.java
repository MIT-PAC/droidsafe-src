package android.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private static final String LOG_TAG = "SMS";
    public static final int ENCODING_UNKNOWN = 0;
    public static final int ENCODING_7BIT = 1;
    public static final int ENCODING_8BIT = 2;
    public static final int ENCODING_16BIT = 3;
    public static final int ENCODING_KSC5601 = 4;
    public static final int MAX_USER_DATA_BYTES = 140;
    public static final int MAX_USER_DATA_BYTES_WITH_HEADER = 134;
    public static final int MAX_USER_DATA_SEPTETS = 160;
    public static final int MAX_USER_DATA_SEPTETS_WITH_HEADER = 153;
    public static final String FORMAT_3GPP = "3gpp";
    public static final String FORMAT_3GPP2 = "3gpp2";
    public SmsMessageBase mWrappedSmsMessage;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.841 -0400", hash_original_method = "8785081C14DC1062450E96A46CF3DF25", hash_generated_method = "CC3242EC3C7EC403B54F6B35BA05EB36")
    @DSModeled(DSC.SAFE)
    private SmsMessage(SmsMessageBase smb) {
        dsTaint.addTaint(smb.dsTaint);
        // ---------- Original Method ----------
        //mWrappedSmsMessage = smb;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.841 -0400", hash_original_method = "CF7F94C2BDE173AF6CC483B3F8BE19B9", hash_generated_method = "D130F6B0A70B67E3ACC0B0A502946CA3")
    public static SmsMessage createFromPdu(byte[] pdu) {
        int activePhone = TelephonyManager.getDefault().getCurrentPhoneType();
        String format = (PHONE_TYPE_CDMA == activePhone) ? FORMAT_3GPP2 : FORMAT_3GPP;
        return createFromPdu(pdu, format);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.841 -0400", hash_original_method = "B5B0C01DE595010BFEEC3AB703E88508", hash_generated_method = "FDF9E8B8EA9AE0FA9656134B5470A32A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.841 -0400", hash_original_method = "C5F8AF04E2B353E3814D87E2C7E1B91D", hash_generated_method = "C6EA974D7F198D698C2440F6C4B72B72")
    public static SmsMessage newFromCMT(String[] lines) {
        SmsMessageBase wrappedMessage =
                com.android.internal.telephony.gsm.SmsMessage.newFromCMT(lines);
        return new SmsMessage(wrappedMessage);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.842 -0400", hash_original_method = "7B8C162A35325E6011B23B50AEDCA0EA", hash_generated_method = "30F584CFE8879C4DDBF3076CF363A069")
    public static SmsMessage newFromParcel(Parcel p) {
        SmsMessageBase wrappedMessage =
                com.android.internal.telephony.cdma.SmsMessage.newFromParcel(p);
        return new SmsMessage(wrappedMessage);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.842 -0400", hash_original_method = "025100544259F7D0606564E546A2F5E4", hash_generated_method = "2341EDD86EA5813174DCE00E483983B5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.842 -0400", hash_original_method = "4B19EE32A85514EDB37C0B0F3BBF250F", hash_generated_method = "921D6D67A4D5509E6C4FAFD6B59DA26E")
    public static int getTPLayerLengthForPDU(String pdu) {
        int activePhone = TelephonyManager.getDefault().getCurrentPhoneType();
        if (PHONE_TYPE_CDMA == activePhone) {
            return com.android.internal.telephony.cdma.SmsMessage.getTPLayerLengthForPDU(pdu);
        } else {
            return com.android.internal.telephony.gsm.SmsMessage.getTPLayerLengthForPDU(pdu);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.842 -0400", hash_original_method = "13E7FC3E1B070CE7A770D3168E7D6A0F", hash_generated_method = "7EA1B99EDFDED904417122D334B7E3DF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.842 -0400", hash_original_method = "E2DED68AC9B462E78AE6945CB037592B", hash_generated_method = "B70CD35936DC10EFAC9154CE33EE3D7D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.842 -0400", hash_original_method = "3F53836604A3169B964FEAA2D80DC740", hash_generated_method = "6389A096C6C5B364BEBC6472E3D31AB4")
    public static int[] calculateLength(String messageBody, boolean use7bitOnly) {
        return calculateLength((CharSequence)messageBody, use7bitOnly);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.842 -0400", hash_original_method = "A51A57E31C7898594F04DE753700B14D", hash_generated_method = "617A0137F65DC1A03DB55F091E3EA10D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.842 -0400", hash_original_method = "A3431A292BD1310EF113F59EE5895A8C", hash_generated_method = "637A5B8E501B3F6288E2CDA2842661CE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.842 -0400", hash_original_method = "918A2835DDADF3191B8B6CF8127F286C", hash_generated_method = "242943365351E58CA8E624AFFD6D2732")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getServiceCenterAddress() {
        String var13989E81A31927CC4F1B9BEA9AF936FB_460372441 = (mWrappedSmsMessage.getServiceCenterAddress());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getServiceCenterAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.842 -0400", hash_original_method = "E9EFC86835C6B2F047600D750A41AA1C", hash_generated_method = "53CC086E074F41A58D78B4A5FBE9F423")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getOriginatingAddress() {
        String var43843A68E66509A8F741BEA2542D9E8B_1070997879 = (mWrappedSmsMessage.getOriginatingAddress());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getOriginatingAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.843 -0400", hash_original_method = "A66BB5C1A20948050FC14BD05462FCCC", hash_generated_method = "81501F053F96177985ACFD85A0517D0E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getDisplayOriginatingAddress() {
        String varF55FD4E71A5E6A56A34AC28F8A3F8408_1033016274 = (mWrappedSmsMessage.getDisplayOriginatingAddress());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getDisplayOriginatingAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.843 -0400", hash_original_method = "11C71A7ADD8F40537023F3C9896D9F41", hash_generated_method = "657AB9BAFB79238F27B304D26D985C71")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getMessageBody() {
        String varD5ED6E999C442ED099D01B0ECFDC4C45_1586960357 = (mWrappedSmsMessage.getMessageBody());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getMessageBody();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.843 -0400", hash_original_method = "099557EF4A3D1E47FF142271693B3FFE", hash_generated_method = "52DC2A0AF05C494B92785E3F72076AF1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MessageClass getMessageClass() {
        MessageClass var6FFFE0AF53A224D525C08B6FF9249779_1432857064 = (mWrappedSmsMessage.getMessageClass());
        return (MessageClass)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getMessageClass();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.843 -0400", hash_original_method = "DDB62DAFB6CA28A8B02386170905555B", hash_generated_method = "36C275D7D2BF029F77D8E2EF079CEBBB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getDisplayMessageBody() {
        String var4FBF23F379178FFB62E3C39C41F44D15_721890491 = (mWrappedSmsMessage.getDisplayMessageBody());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getDisplayMessageBody();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.843 -0400", hash_original_method = "A55B37ECD2D988C3EC358C7240F7EDE2", hash_generated_method = "18EA7DB2FB69F09929F83521238B1071")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getPseudoSubject() {
        String varCBEDB46359011F7ED7C70804F2931325_1751746556 = (mWrappedSmsMessage.getPseudoSubject());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getPseudoSubject();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.843 -0400", hash_original_method = "A397C7F820656CEADBC57751F7E32997", hash_generated_method = "CE00FCB43BEFE5BCF16479282BA4C5A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getTimestampMillis() {
        long varD74FBED3C84830DCE4507A727CF564FC_946486529 = (mWrappedSmsMessage.getTimestampMillis());
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getTimestampMillis();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.843 -0400", hash_original_method = "A5B6E1F6D425F99E0AE9246791CF1B08", hash_generated_method = "54C04003C817616144F8AADBC95F0041")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isEmail() {
        boolean var01F26EAB74A6E76EB5CC85065B2AB42C_866611662 = (mWrappedSmsMessage.isEmail());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.isEmail();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.843 -0400", hash_original_method = "1B76815865383567D84D772FA102258B", hash_generated_method = "D0BF6B7DBA755136BCB057376365350E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getEmailBody() {
        String varCB8F30E820BE119D1651F4A2E5C1C8B9_1823343030 = (mWrappedSmsMessage.getEmailBody());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getEmailBody();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.843 -0400", hash_original_method = "CF41F1C32C92AADB2191A6AB99FD49D6", hash_generated_method = "BE352C4669CA2149E5EFB5F847D3ECE5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getEmailFrom() {
        String var2C7CFEE95AB76BFDE4530E0A78EF81CA_1710352792 = (mWrappedSmsMessage.getEmailFrom());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getEmailFrom();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.843 -0400", hash_original_method = "642EF36AD67598AD564965134BACF8A1", hash_generated_method = "043692B5E5745A9BE2E371C5BB71EE3F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getProtocolIdentifier() {
        int varC61A7C9212F3E9FF0CA0B745657226BD_345851040 = (mWrappedSmsMessage.getProtocolIdentifier());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getProtocolIdentifier();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.843 -0400", hash_original_method = "36F360B7C447980FEF01C7653F551835", hash_generated_method = "BD81F30DFE9350438ADF7D8BE8314AA8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isReplace() {
        boolean varBC2D932725136F9C20C34229415D4B97_486518135 = (mWrappedSmsMessage.isReplace());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.isReplace();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.843 -0400", hash_original_method = "553B9246636C3A5BC903932A40C4BC5E", hash_generated_method = "0E44FD2A3C15E173B04F1C91EB51533F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isCphsMwiMessage() {
        boolean var480BB749EC7EC97FE4A1651C1A8FD73E_1995472333 = (mWrappedSmsMessage.isCphsMwiMessage());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.isCphsMwiMessage();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.844 -0400", hash_original_method = "129EA72B0C9F078142A2BC814FB30CFA", hash_generated_method = "943026C8032D4C354069F28D788AF475")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isMWIClearMessage() {
        boolean varB7A77ECDEC8A73E675ABF225AE837A72_567980114 = (mWrappedSmsMessage.isMWIClearMessage());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.isMWIClearMessage();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.844 -0400", hash_original_method = "5602B112C459EA0AD88653A254825A5D", hash_generated_method = "83EF1F85E7D4CF4FD14F64D5EC5F4347")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isMWISetMessage() {
        boolean var5B955D4A1D8E3F5634E1C3A2B25FD29A_1577784528 = (mWrappedSmsMessage.isMWISetMessage());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.isMWISetMessage();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.844 -0400", hash_original_method = "0ACB85E19D1AFC6F8EA2F470F677C800", hash_generated_method = "3DBFCBAFD13F5FF60AE1CBD9E60D2F89")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isMwiDontStore() {
        boolean var77B6C24D29DDA670F2D629741A9B498F_506789662 = (mWrappedSmsMessage.isMwiDontStore());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.isMwiDontStore();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.844 -0400", hash_original_method = "251D6D0F20B7389DF3878BB8173A6B0A", hash_generated_method = "E319A6724F97840C154CAD834C43464B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getUserData() {
        byte[] var56EE16369B6A9056187EC70F114596AF_2013251306 = (mWrappedSmsMessage.getUserData());
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getUserData();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.844 -0400", hash_original_method = "F61520780332A4249272ED211A1EBC6F", hash_generated_method = "3DA4A2754F26A3BDAF847646EB39325F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getPdu() {
        byte[] var251F1A35ECF82D698D55B42DA1ECA076_428528004 = (mWrappedSmsMessage.getPdu());
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getPdu();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.844 -0400", hash_original_method = "43D7E194BC6DB0E7804F1B1454D5CCBF", hash_generated_method = "BF8415FC5517E697556F9ADD193D23F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public int getStatusOnSim() {
        int var9C85A772E629F12E0A5C09948CEAF5CB_704518424 = (mWrappedSmsMessage.getStatusOnIcc());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getStatusOnIcc();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.844 -0400", hash_original_method = "F41186F27A3FFD01878B6A79ACBBD00F", hash_generated_method = "42AD9D8AF87C6D81FC83016481FE3EB7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getStatusOnIcc() {
        int var9C85A772E629F12E0A5C09948CEAF5CB_283514315 = (mWrappedSmsMessage.getStatusOnIcc());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getStatusOnIcc();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.844 -0400", hash_original_method = "150B1A5BD8253701A69C723196BA6DF9", hash_generated_method = "9B0EBEC8C37BC70A28DD13D651D74BFA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public int getIndexOnSim() {
        int varAAC43D666C403A91DB1773E11797D5BC_844932562 = (mWrappedSmsMessage.getIndexOnIcc());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getIndexOnIcc();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.844 -0400", hash_original_method = "4C0DE2049D9873C839084BE4DC285920", hash_generated_method = "2323FA0B28BB85F2C19D6DC94AE0C321")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getIndexOnIcc() {
        int varAAC43D666C403A91DB1773E11797D5BC_929092694 = (mWrappedSmsMessage.getIndexOnIcc());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getIndexOnIcc();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.844 -0400", hash_original_method = "BAA167F31D67CF27268081CFB0D79A6E", hash_generated_method = "B14EA9457B3D1976524D442DD941D52D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getStatus() {
        int var21EB021D474B531470E6B8E8AADA37C0_1829720213 = (mWrappedSmsMessage.getStatus());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getStatus();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.844 -0400", hash_original_method = "D10C36D7B6CDC51D018139E7A34B7076", hash_generated_method = "86A780FB2B54F96E8B8D207333719DDC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isStatusReportMessage() {
        boolean varA3C3DB4C7E404E711EF55D5064B97BE1_1349083216 = (mWrappedSmsMessage.isStatusReportMessage());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.isStatusReportMessage();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.844 -0400", hash_original_method = "F508F532A25EB5B4727057181F2BF528", hash_generated_method = "AB0A6AC312003C9D0A69AB99D3AFDA58")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isReplyPathPresent() {
        boolean var52B036373B56F8584D28911DD9CACB80_507144824 = (mWrappedSmsMessage.isReplyPathPresent());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.isReplyPathPresent();
    }

    
    public enum MessageClass{
        UNKNOWN, CLASS_0, CLASS_1, CLASS_2, CLASS_3;
    }

    
    public static class SubmitPdu {
        public byte[] encodedScAddress;
        public byte[] encodedMessage;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.845 -0400", hash_original_method = "84E90F8D80D26E2676EED6BCE3E65E06", hash_generated_method = "FF83636CA2BC1DA23642A16743C7B1D1")
        @DSModeled(DSC.SAFE)
        protected SubmitPdu(SubmitPduBase spb) {
            dsTaint.addTaint(spb.dsTaint);
            this.encodedMessage = spb.encodedMessage;
            this.encodedScAddress = spb.encodedScAddress;
            // ---------- Original Method ----------
            //this.encodedMessage = spb.encodedMessage;
            //this.encodedScAddress = spb.encodedScAddress;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.845 -0400", hash_original_method = "A866707516A0999C629C71FD5B45C6F7", hash_generated_method = "394F0087DE7E7698E873F46D0D403BB5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String toString() {
            String varD7043DD576E6C9EDFF336B8E03E30D31_1493827134 = ("SubmitPdu: encodedScAddress = "
                    + Arrays.toString(encodedScAddress)
                    + ", encodedMessage = "
                    + Arrays.toString(encodedMessage));
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return "SubmitPdu: encodedScAddress = "
                    //+ Arrays.toString(encodedScAddress)
                    //+ ", encodedMessage = "
                    //+ Arrays.toString(encodedMessage);
        }

        
    }


    
}


