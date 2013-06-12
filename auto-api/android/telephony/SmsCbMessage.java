package android.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.text.format.Time;
import android.util.Log;
import com.android.internal.telephony.GsmAlphabet;
import com.android.internal.telephony.IccUtils;
import com.android.internal.telephony.gsm.SmsCbHeader;
import java.io.UnsupportedEncodingException;

public class SmsCbMessage {
    public static final int GEOGRAPHICAL_SCOPE_CELL_WIDE_IMMEDIATE = 0;
    public static final int GEOGRAPHICAL_SCOPE_PLMN_WIDE = 1;
    public static final int GEOGRAPHICAL_SCOPE_LA_WIDE = 2;
    public static final int GEOGRAPHICAL_SCOPE_CELL_WIDE = 3;
    private static final String LOG_TAG = "SMSCB";
    private static final String[] LANGUAGE_CODES_GROUP_0 = {
            "de", "en", "it", "fr", "es", "nl", "sv", "da", "pt", "fi", "no", "el", "tr", "hu",
            "pl", null
    };
    private static final String[] LANGUAGE_CODES_GROUP_2 = {
            "cs", "he", "ar", "ru", "is", null, null, null, null, null, null, null, null, null,
            null, null
    };
    private static final char CARRIAGE_RETURN = 0x0d;
    private static final int PDU_BODY_PAGE_LENGTH = 82;
    private SmsCbHeader mHeader;
    private String mLanguage;
    private String mBody;
    private long mPrimaryNotificationTimestamp;
    private byte[] mPrimaryNotificationDigitalSignature;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.758 -0400", hash_original_method = "DD54723C953392868971C295C47050D6", hash_generated_method = "DA4D45DECB63982B934B5CB1B0E00AD3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private SmsCbMessage(byte[] pdu) throws IllegalArgumentException {
        dsTaint.addTaint(pdu);
        mHeader = new SmsCbHeader(pdu);
        {
            mBody = "ETWS";
            {
                mPrimaryNotificationTimestamp = getTimestampMillis(pdu);
                mPrimaryNotificationDigitalSignature = new byte[43];
                System.arraycopy(pdu, 13, mPrimaryNotificationDigitalSignature, 0, 43);
            } //End block
        } //End block
        {
            parseBody(pdu);
        } //End block
        // ---------- Original Method ----------
        //mHeader = new SmsCbHeader(pdu);
        //if (mHeader.format == SmsCbHeader.FORMAT_ETWS_PRIMARY) {
            //mBody = "ETWS";
            //if (pdu.length >= SmsCbHeader.PDU_LENGTH_ETWS) {
                //mPrimaryNotificationTimestamp = getTimestampMillis(pdu);
                //mPrimaryNotificationDigitalSignature = new byte[43];
                //System.arraycopy(pdu, 13, mPrimaryNotificationDigitalSignature, 0, 43);
            //}
        //} else {
            //parseBody(pdu);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.758 -0400", hash_original_method = "07A41569E8E9B292706B30CA3F17F3DB", hash_generated_method = "A559DB78676E1B4DF1551D2E67AC8014")
    public static SmsCbMessage createFromPdu(byte[] pdu) {
        try {
            return new SmsCbMessage(pdu);
        } catch (IllegalArgumentException e) {
            Log.w(LOG_TAG, "Failed parsing SMS-CB pdu", e);
            return null;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.758 -0400", hash_original_method = "90496F9B0E583659024793BD6E4087A2", hash_generated_method = "3008C243D1C51623EC45DA4C7B7EDE61")
    @DSModeled(DSC.SAFE)
    public int getGeographicalScope() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mHeader.geographicalScope;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.758 -0400", hash_original_method = "66EB890D3718C84B5869E602D51232A3", hash_generated_method = "5E375E3E0DE3DBDC24F17B53BABA787D")
    @DSModeled(DSC.SAFE)
    public String getLanguageCode() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mLanguage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.758 -0400", hash_original_method = "76A5E72FE1C89D08295C081C4081B333", hash_generated_method = "781201137764F5233D41E7524B9A1141")
    @DSModeled(DSC.SAFE)
    public String getMessageBody() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mBody;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.758 -0400", hash_original_method = "01DE308CCC251A3B87D855FC62C0AC06", hash_generated_method = "A5A026E44E8C9C33AB6E1812815B2404")
    @DSModeled(DSC.SAFE)
    public int getMessageIdentifier() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mHeader.messageIdentifier;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.758 -0400", hash_original_method = "228F3A0B166FE724E464C63CF310997D", hash_generated_method = "E7F7FF72DBB8A90FA707744CA172CAA0")
    @DSModeled(DSC.SAFE)
    public int getMessageCode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mHeader.messageCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.758 -0400", hash_original_method = "D311CA027E4709BB6CC1C5E67F9E3AF1", hash_generated_method = "9F84BB8B29A7272EE7A4A8A4F2CE07FD")
    @DSModeled(DSC.SAFE)
    public int getUpdateNumber() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mHeader.updateNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.758 -0400", hash_original_method = "3A10F294F63BAAEE30E6FA45F40467DF", hash_generated_method = "507A449F2D6DA8CCF5A05275BEB429DB")
    @DSModeled(DSC.SAFE)
    public int getMessageFormat() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mHeader.format;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.758 -0400", hash_original_method = "537846046153E5A3B4DF7904B8EE8FB6", hash_generated_method = "0E13B2C72D25CC86D4FD5FDFD1573D55")
    @DSModeled(DSC.SAFE)
    public boolean getEtwsEmergencyUserAlert() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mHeader.etwsEmergencyUserAlert;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.759 -0400", hash_original_method = "1092DF3685B2B5DD080E8F3BF31E2D2B", hash_generated_method = "001B26F62B93474B831FFBC05FD1D91D")
    @DSModeled(DSC.SAFE)
    public boolean getEtwsPopup() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mHeader.etwsPopup;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.759 -0400", hash_original_method = "8D2FDE955E540C4E9F647FFAAC3F7704", hash_generated_method = "B10D2ECB9E06B119376714B3FDCA09A1")
    @DSModeled(DSC.SAFE)
    public int getEtwsWarningType() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mHeader.etwsWarningType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.759 -0400", hash_original_method = "401E6EDC137A68484E3C1B51EE4366C0", hash_generated_method = "36189A3333A36AC23D434380C29B9AAC")
    @DSModeled(DSC.SAFE)
    public long getEtwsSecurityTimestamp() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return mPrimaryNotificationTimestamp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.759 -0400", hash_original_method = "463E45E08CE84E86093AA98D100BB7E5", hash_generated_method = "19F99FED2EFE8BE21A4B911F2CD79911")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getEtwsSecuritySignature() {
        byte[] varC1DD849F12BD494F8260E6655C923EFD_157610321 = (mPrimaryNotificationDigitalSignature.clone());
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return mPrimaryNotificationDigitalSignature.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.759 -0400", hash_original_method = "EC42B4C67EF238170393ABD378EE2519", hash_generated_method = "B9102D4A9A9C96E0A29FB779A0539523")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void parseBody(byte[] pdu) {
        dsTaint.addTaint(pdu);
        int encoding;
        boolean hasLanguageIndicator;
        hasLanguageIndicator = false;
        //Begin case 0x00 
        encoding = SmsMessage.ENCODING_7BIT;
        //End case 0x00 
        //Begin case 0x00 
        mLanguage = LANGUAGE_CODES_GROUP_0[mHeader.dataCodingScheme & 0x0f];
        //End case 0x00 
        //Begin case 0x01 
        hasLanguageIndicator = true;
        //End case 0x01 
        //Begin case 0x01 
        {
            encoding = SmsMessage.ENCODING_16BIT;
        } //End block
        {
            encoding = SmsMessage.ENCODING_7BIT;
        } //End block
        //End case 0x01 
        //Begin case 0x02 
        encoding = SmsMessage.ENCODING_7BIT;
        //End case 0x02 
        //Begin case 0x02 
        mLanguage = LANGUAGE_CODES_GROUP_2[mHeader.dataCodingScheme & 0x0f];
        //End case 0x02 
        //Begin case 0x03 
        encoding = SmsMessage.ENCODING_7BIT;
        //End case 0x03 
        //Begin case 0x04 0x05 
        //Begin case 0x01 
        encoding = SmsMessage.ENCODING_8BIT;
        //End case 0x01 
        //Begin case 0x02 
        encoding = SmsMessage.ENCODING_16BIT;
        //End case 0x02 
        //Begin case 0x00 default 
        encoding = SmsMessage.ENCODING_7BIT;
        //End case 0x00 default 
        //End case 0x04 0x05 
        //Begin case 0x06 0x07 0x09 0x0e 
        encoding = SmsMessage.ENCODING_UNKNOWN;
        //End case 0x06 0x07 0x09 0x0e 
        //Begin case 0x0f 
        {
            encoding = SmsMessage.ENCODING_8BIT;
        } //End block
        {
            encoding = SmsMessage.ENCODING_7BIT;
        } //End block
        //End case 0x0f 
        //Begin case default 
        encoding = SmsMessage.ENCODING_7BIT;
        //End case default 
        {
            int nrPages;
            nrPages = pdu[SmsCbHeader.PDU_HEADER_LENGTH];
            {
                throw new IllegalArgumentException("Pdu length " + pdu.length + " does not match "
                        + nrPages + " pages");
            } //End block
            StringBuilder sb;
            sb = new StringBuilder();
            {
                int i;
                i = 0;
                {
                    int offset;
                    offset = SmsCbHeader.PDU_HEADER_LENGTH + 1 + (PDU_BODY_PAGE_LENGTH + 1) * i;
                    int length;
                    length = pdu[offset + PDU_BODY_PAGE_LENGTH];
                    {
                        throw new IllegalArgumentException("Page length " + length
                            + " exceeds maximum value " + PDU_BODY_PAGE_LENGTH);
                    } //End block
                    sb.append(unpackBody(pdu, encoding, offset, length, hasLanguageIndicator));
                } //End block
            } //End collapsed parenthetic
            mBody = sb.toString();
        } //End block
        {
            int offset;
            offset = SmsCbHeader.PDU_HEADER_LENGTH;
            int length;
            length = pdu.length - offset;
            mBody = unpackBody(pdu, encoding, offset, length, hasLanguageIndicator);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.760 -0400", hash_original_method = "34BF9346CD2E44D452286FCA947E9437", hash_generated_method = "8DBAE6822799455065B819BF8F054A62")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String unpackBody(byte[] pdu, int encoding, int offset, int length,
            boolean hasLanguageIndicator) {
        dsTaint.addTaint(hasLanguageIndicator);
        dsTaint.addTaint(encoding);
        dsTaint.addTaint(length);
        dsTaint.addTaint(pdu);
        dsTaint.addTaint(offset);
        String body;
        body = null;
        //Begin case SmsMessage.ENCODING_7BIT 
        body = GsmAlphabet.gsm7BitPackedToString(pdu, offset, length * 8 / 7);
        //End case SmsMessage.ENCODING_7BIT 
        //Begin case SmsMessage.ENCODING_7BIT 
        {
            boolean var23CA103027A87A2417F20D25C8239058_1803759086 = (hasLanguageIndicator && body != null && body.length() > 2);
            {
                mLanguage = body.substring(0, 2);
                body = body.substring(3);
            } //End block
        } //End collapsed parenthetic
        //End case SmsMessage.ENCODING_7BIT 
        //Begin case SmsMessage.ENCODING_16BIT 
        {
            mLanguage = GsmAlphabet.gsm7BitPackedToString(pdu, offset, 2);
            offset += 2;
            length -= 2;
        } //End block
        //End case SmsMessage.ENCODING_16BIT 
        //Begin case SmsMessage.ENCODING_16BIT 
        try 
        {
            body = new String(pdu, offset, (length & 0xfffe), "utf-16");
        } //End block
        catch (UnsupportedEncodingException e)
        { }
        //End case SmsMessage.ENCODING_16BIT 
        {
            {
                int i;
                i = body.length() - 1;
                {
                    {
                        boolean varB49C3AF8F8E9F7B1FCDF84AF9A01D611_55055191 = (body.charAt(i) != CARRIAGE_RETURN);
                        {
                            body = body.substring(0, i + 1);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            body = "";
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.760 -0400", hash_original_method = "D10A99754A3F56477D06E47018AF39CF", hash_generated_method = "AD7A9A77DE7875CEFA7E6F621DE27D32")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private long getTimestampMillis(byte[] pdu) {
        dsTaint.addTaint(pdu);
        int year;
        year = IccUtils.gsmBcdByteToInt(pdu[6]);
        int month;
        month = IccUtils.gsmBcdByteToInt(pdu[7]);
        int day;
        day = IccUtils.gsmBcdByteToInt(pdu[8]);
        int hour;
        hour = IccUtils.gsmBcdByteToInt(pdu[9]);
        int minute;
        minute = IccUtils.gsmBcdByteToInt(pdu[10]);
        int second;
        second = IccUtils.gsmBcdByteToInt(pdu[11]);
        byte tzByte;
        tzByte = pdu[12];
        int timezoneOffset;
        timezoneOffset = IccUtils.gsmBcdByteToInt((byte) (tzByte & (~0x08)));
        timezoneOffset = ((tzByte & 0x08) == 0) ? timezoneOffset : -timezoneOffset;
        Time time;
        time = new Time(Time.TIMEZONE_UTC);
        time.year = year >= 90 ? year + 1900 : year + 2000;
        time.month = month - 1;
        time.monthDay = day;
        time.hour = hour;
        time.minute = minute;
        time.second = second;
        long varB66601F6A44F43C54B79780B7F36850F_810471875 = (time.toMillis(true) - (timezoneOffset * 15 * 60 * 1000));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.760 -0400", hash_original_method = "2C9FAA38362CB04CDF5DCD5A9A61FC36", hash_generated_method = "8C4C030EBBCF1B9029A684F5521BBF22")
    @DSModeled(DSC.SAFE)
    public void appendToBody(String body) {
        dsTaint.addTaint(body);
        mBody = mBody + body;
        // ---------- Original Method ----------
        //mBody = mBody + body;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.760 -0400", hash_original_method = "53399BD8C20568A73925249B9149E048", hash_generated_method = "EE92C4EF022202316EDBF244F15E1D94")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String varAF82005E938044E19F63F4242726365A_1204685501 = ("SmsCbMessage{" + mHeader.toString() + ", language=" + mLanguage +
                ", body=\"" + mBody + "\"}");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "SmsCbMessage{" + mHeader.toString() + ", language=" + mLanguage +
                //", body=\"" + mBody + "\"}";
    }

    
}


