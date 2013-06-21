package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.telephony.SmsCbConstants;

public class SmsCbHeader implements SmsCbConstants {
    public int geographicalScope;
    public int messageCode;
    public int updateNumber;
    public int messageIdentifier;
    public int dataCodingScheme;
    public int pageIndex;
    public int nrOfPages;
    public int format;
    public boolean etwsEmergencyUserAlert;
    public boolean etwsPopup;
    public int etwsWarningType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.912 -0400", hash_original_method = "261755DF1F24560363C9FCA5817FD7DA", hash_generated_method = "393BAB6561FF5E77C8FAA75BA8D6CE31")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SmsCbHeader(byte[] pdu) throws IllegalArgumentException {
        dsTaint.addTaint(pdu[0]);
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
            format = FORMAT_GSM;
            geographicalScope = (pdu[0] & 0xc0) >> 6;
            messageCode = ((pdu[0] & 0x3f) << 4) | ((pdu[1] & 0xf0) >> 4);
            updateNumber = pdu[1] & 0x0f;
            messageIdentifier = ((pdu[2] & 0xff) << 8) | (pdu[3] & 0xff);
            dataCodingScheme = pdu[4] & 0xff;
            int pageIndex;
            pageIndex = (pdu[5] & 0xf0) >> 4;
            int nrOfPages;
            nrOfPages = pdu[5] & 0x0f;
            {
                pageIndex = 1;
                nrOfPages = 1;
            } //End block
            this.pageIndex = pageIndex;
            this.nrOfPages = nrOfPages;
            etwsEmergencyUserAlert = false;
            etwsPopup = false;
            etwsWarningType = -1;
        } //End block
        {
            format = FORMAT_UMTS;
            int messageType;
            messageType = pdu[0];
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Unsupported message type " + messageType);
            } //End block
            messageIdentifier = ((pdu[1] & 0xff) << 8) | pdu[2] & 0xff;
            geographicalScope = (pdu[3] & 0xc0) >> 6;
            messageCode = ((pdu[3] & 0x3f) << 4) | ((pdu[4] & 0xf0) >> 4);
            updateNumber = pdu[4] & 0x0f;
            dataCodingScheme = pdu[5] & 0xff;
            pageIndex = 1;
            nrOfPages = 1;
            etwsEmergencyUserAlert = false;
            etwsPopup = false;
            etwsWarningType = -1;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        public static boolean isEmergencyMessage(int id) {
        return id >= MESSAGE_ID_PWS_FIRST_IDENTIFIER && id <= MESSAGE_ID_PWS_LAST_IDENTIFIER;
    }

    
        public static boolean isEtwsMessage(int id) {
        return (id & MESSAGE_ID_ETWS_TYPE_MASK) == MESSAGE_ID_ETWS_TYPE;
    }

    
        public static boolean isCmasMessage(int id) {
        return id >= MESSAGE_ID_CMAS_FIRST_IDENTIFIER && id <= MESSAGE_ID_CMAS_LAST_IDENTIFIER;
    }

    
        public static boolean isEtwsPopupAlert(int messageCode) {
        return (messageCode & MESSAGE_CODE_ETWS_ACTIVATE_POPUP) != 0;
    }

    
        public static boolean isEtwsEmergencyUserAlert(int messageCode) {
        return (messageCode & MESSAGE_CODE_ETWS_EMERGENCY_USER_ALERT) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.913 -0400", hash_original_method = "F77CFF978B7542934CFB3B1620EE83C7", hash_generated_method = "7A9382B722FE3F959DD775FC0798A7BB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String varFFE23FCFD1033D1F79CF65DE7684AAB8_270582080 = ("SmsCbHeader{GS=" + geographicalScope + ", messageCode=0x" +
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

    
    public static final int PDU_HEADER_LENGTH = 6;
    public static final int FORMAT_GSM = 1;
    public static final int FORMAT_UMTS = 2;
    public static final int FORMAT_ETWS_PRIMARY = 3;
    private static final int MESSAGE_TYPE_CBS_MESSAGE = 1;
    public static final int PDU_LENGTH_GSM = 88;
    public static final int PDU_LENGTH_ETWS = 56;
}

