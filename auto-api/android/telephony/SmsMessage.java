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
    public SmsMessageBase mWrappedSmsMessage;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.844 -0400", hash_original_method = "8785081C14DC1062450E96A46CF3DF25", hash_generated_method = "DC682EC32C266FE49EA96F97B8BE7FE0")
    @DSModeled(DSC.SAFE)
    private SmsMessage(SmsMessageBase smb) {
        dsTaint.addTaint(smb.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.846 -0400", hash_original_method = "918A2835DDADF3191B8B6CF8127F286C", hash_generated_method = "4321C78E28C93732A755776F558BB66F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getServiceCenterAddress() {
        String var13989E81A31927CC4F1B9BEA9AF936FB_681775314 = (mWrappedSmsMessage.getServiceCenterAddress());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getServiceCenterAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.847 -0400", hash_original_method = "E9EFC86835C6B2F047600D750A41AA1C", hash_generated_method = "4F90522EE183B5145DA30F4DFFA3AF58")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getOriginatingAddress() {
        String var43843A68E66509A8F741BEA2542D9E8B_273764211 = (mWrappedSmsMessage.getOriginatingAddress());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getOriginatingAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.847 -0400", hash_original_method = "A66BB5C1A20948050FC14BD05462FCCC", hash_generated_method = "DD88B1AC9EE42E9EDCAD25428FB79721")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getDisplayOriginatingAddress() {
        String varF55FD4E71A5E6A56A34AC28F8A3F8408_1023778900 = (mWrappedSmsMessage.getDisplayOriginatingAddress());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getDisplayOriginatingAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.847 -0400", hash_original_method = "11C71A7ADD8F40537023F3C9896D9F41", hash_generated_method = "6C761414A1B7D641B935FD9829028AB9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getMessageBody() {
        String varD5ED6E999C442ED099D01B0ECFDC4C45_899826930 = (mWrappedSmsMessage.getMessageBody());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getMessageBody();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.847 -0400", hash_original_method = "099557EF4A3D1E47FF142271693B3FFE", hash_generated_method = "5D3329176B33351D227B4281B9465756")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MessageClass getMessageClass() {
        MessageClass var6FFFE0AF53A224D525C08B6FF9249779_942775044 = (mWrappedSmsMessage.getMessageClass());
        return (MessageClass)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getMessageClass();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.847 -0400", hash_original_method = "DDB62DAFB6CA28A8B02386170905555B", hash_generated_method = "BE6D15BD21E646953D314BC6BA7A6C5E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getDisplayMessageBody() {
        String var4FBF23F379178FFB62E3C39C41F44D15_1367057555 = (mWrappedSmsMessage.getDisplayMessageBody());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getDisplayMessageBody();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.848 -0400", hash_original_method = "A55B37ECD2D988C3EC358C7240F7EDE2", hash_generated_method = "B6978E572FE70D12CC6BE7768CB4E7E3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getPseudoSubject() {
        String varCBEDB46359011F7ED7C70804F2931325_822145222 = (mWrappedSmsMessage.getPseudoSubject());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getPseudoSubject();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.848 -0400", hash_original_method = "A397C7F820656CEADBC57751F7E32997", hash_generated_method = "A059648F9615AD82F071E0691AD39A39")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getTimestampMillis() {
        long varD74FBED3C84830DCE4507A727CF564FC_1503864221 = (mWrappedSmsMessage.getTimestampMillis());
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getTimestampMillis();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.848 -0400", hash_original_method = "A5B6E1F6D425F99E0AE9246791CF1B08", hash_generated_method = "8ACF4249CC1065513F9FFCC0936BD8E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isEmail() {
        boolean var01F26EAB74A6E76EB5CC85065B2AB42C_1941686401 = (mWrappedSmsMessage.isEmail());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.isEmail();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.848 -0400", hash_original_method = "1B76815865383567D84D772FA102258B", hash_generated_method = "AD54FBB21816BBC7B4649ED9902E8342")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getEmailBody() {
        String varCB8F30E820BE119D1651F4A2E5C1C8B9_1536905706 = (mWrappedSmsMessage.getEmailBody());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getEmailBody();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.848 -0400", hash_original_method = "CF41F1C32C92AADB2191A6AB99FD49D6", hash_generated_method = "B500B3A72D59B3E7BA2BD565A0C18D5F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getEmailFrom() {
        String var2C7CFEE95AB76BFDE4530E0A78EF81CA_1652460228 = (mWrappedSmsMessage.getEmailFrom());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getEmailFrom();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.849 -0400", hash_original_method = "642EF36AD67598AD564965134BACF8A1", hash_generated_method = "629FF498A332962FC453FF9C8785357C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getProtocolIdentifier() {
        int varC61A7C9212F3E9FF0CA0B745657226BD_407861208 = (mWrappedSmsMessage.getProtocolIdentifier());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getProtocolIdentifier();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.849 -0400", hash_original_method = "36F360B7C447980FEF01C7653F551835", hash_generated_method = "73697086A5A46A600485A48E2C3A5D23")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isReplace() {
        boolean varBC2D932725136F9C20C34229415D4B97_1015280928 = (mWrappedSmsMessage.isReplace());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.isReplace();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.849 -0400", hash_original_method = "553B9246636C3A5BC903932A40C4BC5E", hash_generated_method = "D74BCF939AB9276C5309FED1F1551066")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isCphsMwiMessage() {
        boolean var480BB749EC7EC97FE4A1651C1A8FD73E_715086217 = (mWrappedSmsMessage.isCphsMwiMessage());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.isCphsMwiMessage();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.849 -0400", hash_original_method = "129EA72B0C9F078142A2BC814FB30CFA", hash_generated_method = "365400DB2501B4DD5FAC9AC1EC4A1413")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isMWIClearMessage() {
        boolean varB7A77ECDEC8A73E675ABF225AE837A72_1988894241 = (mWrappedSmsMessage.isMWIClearMessage());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.isMWIClearMessage();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.850 -0400", hash_original_method = "5602B112C459EA0AD88653A254825A5D", hash_generated_method = "7FF7DED7A7A307F5C5F8B352E33C764B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isMWISetMessage() {
        boolean var5B955D4A1D8E3F5634E1C3A2B25FD29A_1556540309 = (mWrappedSmsMessage.isMWISetMessage());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.isMWISetMessage();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.850 -0400", hash_original_method = "0ACB85E19D1AFC6F8EA2F470F677C800", hash_generated_method = "7D5770429A69CA54165BA2DADA47D878")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isMwiDontStore() {
        boolean var77B6C24D29DDA670F2D629741A9B498F_1358064697 = (mWrappedSmsMessage.isMwiDontStore());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.isMwiDontStore();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.850 -0400", hash_original_method = "251D6D0F20B7389DF3878BB8173A6B0A", hash_generated_method = "45EFC9D3055DA94B0C8D2DB473DC2892")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getUserData() {
        byte[] var56EE16369B6A9056187EC70F114596AF_651652830 = (mWrappedSmsMessage.getUserData());
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getUserData();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.851 -0400", hash_original_method = "F61520780332A4249272ED211A1EBC6F", hash_generated_method = "14BAEF68AF2B6E19910C740F03D50A78")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getPdu() {
        byte[] var251F1A35ECF82D698D55B42DA1ECA076_1549972932 = (mWrappedSmsMessage.getPdu());
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getPdu();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.851 -0400", hash_original_method = "43D7E194BC6DB0E7804F1B1454D5CCBF", hash_generated_method = "D6AC67104A96647EC7EA3947A55AC53A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public int getStatusOnSim() {
        int var9C85A772E629F12E0A5C09948CEAF5CB_4930036 = (mWrappedSmsMessage.getStatusOnIcc());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getStatusOnIcc();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.851 -0400", hash_original_method = "F41186F27A3FFD01878B6A79ACBBD00F", hash_generated_method = "59C40F53725312219C07F94B1DB37A78")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getStatusOnIcc() {
        int var9C85A772E629F12E0A5C09948CEAF5CB_1189055800 = (mWrappedSmsMessage.getStatusOnIcc());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getStatusOnIcc();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.851 -0400", hash_original_method = "150B1A5BD8253701A69C723196BA6DF9", hash_generated_method = "787091E72C3153DB9F88D9BA742C7641")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public int getIndexOnSim() {
        int varAAC43D666C403A91DB1773E11797D5BC_1497162340 = (mWrappedSmsMessage.getIndexOnIcc());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getIndexOnIcc();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.852 -0400", hash_original_method = "4C0DE2049D9873C839084BE4DC285920", hash_generated_method = "64885D05BD18B03A32AF1A68BA83039A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getIndexOnIcc() {
        int varAAC43D666C403A91DB1773E11797D5BC_862071330 = (mWrappedSmsMessage.getIndexOnIcc());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getIndexOnIcc();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.852 -0400", hash_original_method = "BAA167F31D67CF27268081CFB0D79A6E", hash_generated_method = "B0F61A394B795E006A346C68535868C1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getStatus() {
        int var21EB021D474B531470E6B8E8AADA37C0_465747775 = (mWrappedSmsMessage.getStatus());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.getStatus();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.852 -0400", hash_original_method = "D10C36D7B6CDC51D018139E7A34B7076", hash_generated_method = "B019310A8FE7C583520564BA1BE7FC65")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isStatusReportMessage() {
        boolean varA3C3DB4C7E404E711EF55D5064B97BE1_1741687457 = (mWrappedSmsMessage.isStatusReportMessage());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mWrappedSmsMessage.isStatusReportMessage();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.852 -0400", hash_original_method = "F508F532A25EB5B4727057181F2BF528", hash_generated_method = "AEC7BC7120496A93CDBF506FDA2250E0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isReplyPathPresent() {
        boolean var52B036373B56F8584D28911DD9CACB80_283161880 = (mWrappedSmsMessage.isReplyPathPresent());
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.853 -0400", hash_original_method = "84E90F8D80D26E2676EED6BCE3E65E06", hash_generated_method = "1D84861CAB5627EB9185A44E4DBB2F3C")
        @DSModeled(DSC.SAFE)
        protected SubmitPdu(SubmitPduBase spb) {
            dsTaint.addTaint(spb.dsTaint);
            this.encodedMessage = spb.encodedMessage;
            this.encodedScAddress = spb.encodedScAddress;
            // ---------- Original Method ----------
            //this.encodedMessage = spb.encodedMessage;
            //this.encodedScAddress = spb.encodedScAddress;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.853 -0400", hash_original_method = "A866707516A0999C629C71FD5B45C6F7", hash_generated_method = "28277E9F5175685F06A8F88633724640")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String toString() {
            String varD7043DD576E6C9EDFF336B8E03E30D31_161845039 = ("SubmitPdu: encodedScAddress = "
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
}

