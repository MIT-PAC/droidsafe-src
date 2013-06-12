package com.android.internal.telephony.gsm;

// Droidsafe Imports
import android.telephony.SmsCbConstants;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.runtime.DroidSafeAndroidRuntime;
// import Iterator to deal with enhanced for loop translation

public class SmsCbHeader implements SmsCbConstants {
    public static final int PDU_HEADER_LENGTH = 6;
    public static final int FORMAT_GSM = 1;
    public static final int FORMAT_UMTS = 2;
    public static final int FORMAT_ETWS_PRIMARY = 3;
    private static final int MESSAGE_TYPE_CBS_MESSAGE = 1;
    public static final int PDU_LENGTH_GSM = 88;
    public static final int PDU_LENGTH_ETWS = 56;
    public final int geographicalScope;
    public final int messageCode;
    public final int updateNumber;
    public final int messageIdentifier;
    public final int dataCodingScheme;
    public final int pageIndex;
    public final int nrOfPages;
    public final int format;
    public final boolean etwsEmergencyUserAlert;
    public final boolean etwsPopup;
    public final int etwsWarningType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.012 -0400", hash_original_method = "261755DF1F24560363C9FCA5817FD7DA", hash_generated_method = "CC2276E2AEF005837B4E72455ECC8B2A")
    @DSModeled(DSC.SAFE)
    public SmsCbHeader(byte[] pdu) throws IllegalArgumentException {
        dsTaint.addTaint(pdu);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Illegal PDU");
        } //End block
        {
            format = FORMAT_ETWS_PRIMARY;
            geographicalScope = -1;
            messageCode = -1;
            updateNumber = -1;
            messageIdentifier = ((pdu[2] & 0xff) << 8) | (pdu[3] & 0xff);
            dataCodingScheme = -1;
            pageIndex = -1;
            nrOfPages = -1;
            etwsEmergencyUserAlert = (pdu[4] & 0x1) != 0;
            etwsPopup = (pdu[5] & 0x80) != 0;
            etwsWarningType = (pdu[4] & 0xfe) >> 1;
        } //End block
        {
            int pageIndex;
            pageIndex = (pdu[5] & 0xf0) >> 4;
            int nrOfPages;
            nrOfPages = pdu[5] & 0x0f;
            {
                pageIndex = 1;
                nrOfPages = 1;
            } //End block
        } //End block
        {

            int messageType;
            messageType = pdu[0];
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Unsupported message type " + messageType);
            } //End block
            
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.012 -0400", hash_original_method = "C914D7E35A4624471549A0AE16D24940", hash_generated_method = "F0548958B40A83AA883C615982816527")
    public static boolean isEmergencyMessage(int id) {
        return id >= MESSAGE_ID_PWS_FIRST_IDENTIFIER && id <= MESSAGE_ID_PWS_LAST_IDENTIFIER;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.012 -0400", hash_original_method = "4C70ECA3D09099250615666E21F5961A", hash_generated_method = "A086C2ADA3071BE2E148E67D0B17583B")
    public static boolean isEtwsMessage(int id) {
        return (id & MESSAGE_ID_ETWS_TYPE_MASK) == MESSAGE_ID_ETWS_TYPE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.012 -0400", hash_original_method = "6F975588874A217BF414483961FFBC21", hash_generated_method = "604F65D9535DC588B0ED38BC228F68C4")
    public static boolean isCmasMessage(int id) {
        return id >= MESSAGE_ID_CMAS_FIRST_IDENTIFIER && id <= MESSAGE_ID_CMAS_LAST_IDENTIFIER;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.012 -0400", hash_original_method = "785A21683DF02537913C025154B975A6", hash_generated_method = "A5F7E4770C244FAC926968A50E89781D")
    public static boolean isEtwsPopupAlert(int messageCode) {
        return (messageCode & MESSAGE_CODE_ETWS_ACTIVATE_POPUP) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.012 -0400", hash_original_method = "1338FD648DB3B2BAA5C0EC8F5443BAC7", hash_generated_method = "8F49EA1283EBC0CE39F3CC5A101B9DB9")
    public static boolean isEtwsEmergencyUserAlert(int messageCode) {
        return (messageCode & MESSAGE_CODE_ETWS_EMERGENCY_USER_ALERT) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.012 -0400", hash_original_method = "F77CFF978B7542934CFB3B1620EE83C7", hash_generated_method = "AA587766217453773C689A30D82024A8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String varFFE23FCFD1033D1F79CF65DE7684AAB8_1002053070 = ("SmsCbHeader{GS=" + geographicalScope + ", messageCode=0x" +
                Integer.toHexString(messageCode) + ", updateNumber=" + updateNumber +
                ", messageIdentifier=0x" + Integer.toHexString(messageIdentifier) +
                ", DCS=0x" + Integer.toHexString(dataCodingScheme) +
                ", page " + pageIndex + " of " + nrOfPages + '}');
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "SmsCbHeader{GS=" + geographicalScope + ", messageCode=0x" +
                //Integer.toHexString(messageCode) + ", updateNumber=" + updateNumber +
                //", messageIdentifier=0x" + Integer.toHexString(messageIdentifier) +
                //", DCS=0x" + Integer.toHexString(dataCodingScheme) +
                //", page " + pageIndex + " of " + nrOfPages + '}';
    }

    
}


