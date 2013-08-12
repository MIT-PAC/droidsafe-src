package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.telephony.SmsCbConstants;





public class SmsCbHeader implements SmsCbConstants {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.748 -0400", hash_original_field = "F3192B2A01511D9751A32C5665EBD0C3", hash_generated_field = "1D5E4DABFDDA8C9C0EA798EAAADB2805")

    public int geographicalScope;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.748 -0400", hash_original_field = "CDD8C2B4160C66C1DCF977E2FA56D4CC", hash_generated_field = "5A14F88CF089D587182B20FD8BFABCD4")

    public int messageCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.748 -0400", hash_original_field = "DEFAF5A673D7AA8C177BB3D556065521", hash_generated_field = "7EC9965A45B411C158B30B7C98CE6E9F")

    public int updateNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.748 -0400", hash_original_field = "1F342FEE4386E5C88552C8EC5B6FF07F", hash_generated_field = "D0F6F349F40771E87DD4A0D1B07055EF")

    public int messageIdentifier;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.748 -0400", hash_original_field = "35CE477420B8D0FBD7AD0A0ED5C35EDB", hash_generated_field = "0532B741E6B346E45FA103D1BFE0FE0D")

    public int dataCodingScheme;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.748 -0400", hash_original_field = "5305C22E368C1761772322939E8CCFB9", hash_generated_field = "9B2C08A54E75C2F08E1D537651339465")

    public int pageIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.748 -0400", hash_original_field = "1F5E6466869210616309D200B43FBD20", hash_generated_field = "9F94093BFD073A9802BB5459EAA16BCF")

    public int nrOfPages;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.748 -0400", hash_original_field = "1DDCB92ADE31C8FBD370001F9B29A7D9", hash_generated_field = "607BD764A61A3197D0A2D65B6E1CF0E2")

    public int format;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.748 -0400", hash_original_field = "E125BC6E22DFD30F68AE9D18D978E804", hash_generated_field = "A790BFAEF6B0FE178FDF16CD5DDFB350")

    public boolean etwsEmergencyUserAlert;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.748 -0400", hash_original_field = "BB0B550EFFBA9025CFA828291548E5B3", hash_generated_field = "F8E090EAD27FBA00AFC967E09A39BD7F")

    public boolean etwsPopup;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.749 -0400", hash_original_field = "53720BF6D3F12D4958F0DA27E9CDDCF5", hash_generated_field = "67B1A0815B115CD87AEEBA262974E91F")

    public int etwsWarningType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.754 -0400", hash_original_method = "261755DF1F24560363C9FCA5817FD7DA", hash_generated_method = "20E2A738CB648BD05EB27474AC1E842D")
    public  SmsCbHeader(byte[] pdu) throws IllegalArgumentException {
        if(pdu == null || pdu.length < PDU_HEADER_LENGTH)        
        {
            IllegalArgumentException var55E009F14C28B40B22A8325E6C5D49EB_1284678818 = new IllegalArgumentException("Illegal PDU");
            var55E009F14C28B40B22A8325E6C5D49EB_1284678818.addTaint(taint);
            throw var55E009F14C28B40B22A8325E6C5D49EB_1284678818;
        } //End block
        if(pdu.length <= PDU_LENGTH_ETWS)        
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
        else
        if(pdu.length <= PDU_LENGTH_GSM)        
        {
            format = FORMAT_GSM;
            geographicalScope = (pdu[0] & 0xc0) >> 6;
            messageCode = ((pdu[0] & 0x3f) << 4) | ((pdu[1] & 0xf0) >> 4);
            updateNumber = pdu[1] & 0x0f;
            messageIdentifier = ((pdu[2] & 0xff) << 8) | (pdu[3] & 0xff);
            dataCodingScheme = pdu[4] & 0xff;
            int pageIndex = (pdu[5] & 0xf0) >> 4;
            int nrOfPages = pdu[5] & 0x0f;
            if(pageIndex == 0 || nrOfPages == 0 || pageIndex > nrOfPages)            
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
        else
        {
            format = FORMAT_UMTS;
            int messageType = pdu[0];
            if(messageType != MESSAGE_TYPE_CBS_MESSAGE)            
            {
                IllegalArgumentException var2E22A44E8F929646BC5D5E1A3B03E5C4_1614047954 = new IllegalArgumentException("Unsupported message type " + messageType);
                var2E22A44E8F929646BC5D5E1A3B03E5C4_1614047954.addTaint(taint);
                throw var2E22A44E8F929646BC5D5E1A3B03E5C4_1614047954;
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

    
    @DSModeled(DSC.SAFE)
    public static boolean isEmergencyMessage(int id) {
        return id >= MESSAGE_ID_PWS_FIRST_IDENTIFIER && id <= MESSAGE_ID_PWS_LAST_IDENTIFIER;
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isEtwsMessage(int id) {
        return (id & MESSAGE_ID_ETWS_TYPE_MASK) == MESSAGE_ID_ETWS_TYPE;
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isCmasMessage(int id) {
        return id >= MESSAGE_ID_CMAS_FIRST_IDENTIFIER && id <= MESSAGE_ID_CMAS_LAST_IDENTIFIER;
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isEtwsPopupAlert(int messageCode) {
        return (messageCode & MESSAGE_CODE_ETWS_ACTIVATE_POPUP) != 0;
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isEtwsEmergencyUserAlert(int messageCode) {
        return (messageCode & MESSAGE_CODE_ETWS_EMERGENCY_USER_ALERT) != 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.756 -0400", hash_original_method = "F77CFF978B7542934CFB3B1620EE83C7", hash_generated_method = "2FD90AAB376F1817982BB9AEE4B1DF49")
    @Override
    public String toString() {
String varA312391745A05796CC1AA3A94F083DD0_875041442 =         "SmsCbHeader{GS=" + geographicalScope + ", messageCode=0x" +
                Integer.toHexString(messageCode) + ", updateNumber=" + updateNumber +
                ", messageIdentifier=0x" + Integer.toHexString(messageIdentifier) +
                ", DCS=0x" + Integer.toHexString(dataCodingScheme) +
                ", page " + pageIndex + " of " + nrOfPages + '}';
        varA312391745A05796CC1AA3A94F083DD0_875041442.addTaint(taint);
        return varA312391745A05796CC1AA3A94F083DD0_875041442;
        // ---------- Original Method ----------
        //return "SmsCbHeader{GS=" + geographicalScope + ", messageCode=0x" +
                //Integer.toHexString(messageCode) + ", updateNumber=" + updateNumber +
                //", messageIdentifier=0x" + Integer.toHexString(messageIdentifier) +
                //", DCS=0x" + Integer.toHexString(dataCodingScheme) +
                //", page " + pageIndex + " of " + nrOfPages + '}';
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.756 -0400", hash_original_field = "5FB4B9067295B944D094E7148074D4B9", hash_generated_field = "7E8F3E0A33C6A1772480AFF2D24BEB86")

    public static final int PDU_HEADER_LENGTH = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.756 -0400", hash_original_field = "DD33BD3E72D5624DDADF4B397EDCC808", hash_generated_field = "AD5EFFBD9301232FCB41B3EE928ADF6C")

    public static final int FORMAT_GSM = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.756 -0400", hash_original_field = "B795955516CAA8A61E6291D52ABF347F", hash_generated_field = "B24C6DE0C8B3F9C256D18EDEB67BB8C0")

    public static final int FORMAT_UMTS = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.756 -0400", hash_original_field = "F7CA5C7294E53B129E7F100243623DCB", hash_generated_field = "FF539DEE25DC67A07ABC4EC6BE492742")

    public static final int FORMAT_ETWS_PRIMARY = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.756 -0400", hash_original_field = "CE4899AF33183DA31B6ECCB3144F3EE7", hash_generated_field = "EDB7EDFB4873395BD2745F96175B8117")

    private static final int MESSAGE_TYPE_CBS_MESSAGE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.756 -0400", hash_original_field = "7E42AFF5ED4D5D16B4EDF050CF69CB97", hash_generated_field = "4F0B093BC053A489824F11B3593BF645")

    public static final int PDU_LENGTH_GSM = 88;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.757 -0400", hash_original_field = "A2FFB32C25079AB4D74C904464D9CED8", hash_generated_field = "829A8FE49043E7F186EB425545E12087")

    public static final int PDU_LENGTH_ETWS = 56;
}

