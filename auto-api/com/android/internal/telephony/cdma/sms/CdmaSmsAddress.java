package com.android.internal.telephony.cdma.sms;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.util.SparseBooleanArray;
import com.android.internal.telephony.SmsAddress;
import com.android.internal.telephony.cdma.sms.UserData;
import com.android.internal.util.HexDump;

public class CdmaSmsAddress extends SmsAddress {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.270 -0400", hash_original_field = "49524A0E3EE6F35DABACF2EE847F7934", hash_generated_field = "84D708851062F6247553AB01A32917F4")

    public int digitMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.270 -0400", hash_original_field = "9F6DEAB7E87E178AA4369A698B428CC9", hash_generated_field = "684B3B4D05E25597D49E78621D640BA3")

    public int numberMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.270 -0400", hash_original_field = "4C094E528F219B5FA64F2348874263D5", hash_generated_field = "380C724376E6D50354D5A2BE6AD71C15")

    public int numberOfDigits;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.271 -0400", hash_original_field = "38786F58063652B570260E8A16FE7DB3", hash_generated_field = "8732F91B3DDF6D0B0124E0E68F0A73A0")

    public int numberPlan;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.271 -0400", hash_original_method = "C14D3E49998397C1BAE29B9693261AA4", hash_generated_method = "D0B7A6B483495AD2F861F207E5EE1740")
    public  CdmaSmsAddress() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.281 -0400", hash_original_method = "63A53E613DBD8AE7867F216680739B01", hash_generated_method = "E3510D4A90108D990DC09BF425B0D196")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1146087918 = null; //Variable for return #1
        StringBuilder builder;
        builder = new StringBuilder();
        builder.append("CdmaSmsAddress ");
        builder.append("{ digitMode=" + digitMode);
        builder.append(", numberMode=" + numberMode);
        builder.append(", numberPlan=" + numberPlan);
        builder.append(", numberOfDigits=" + numberOfDigits);
        builder.append(", ton=" + ton);
        builder.append(", address=\"" + address + "\"");
        builder.append(", origBytes=" + HexDump.toHexString(origBytes));
        builder.append(" }");
        varB4EAC82CA7396A68D541C85D26508E83_1146087918 = builder.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1146087918.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1146087918;
        // ---------- Original Method ----------
        //StringBuilder builder = new StringBuilder();
        //builder.append("CdmaSmsAddress ");
        //builder.append("{ digitMode=" + digitMode);
        //builder.append(", numberMode=" + numberMode);
        //builder.append(", numberPlan=" + numberPlan);
        //builder.append(", numberOfDigits=" + numberOfDigits);
        //builder.append(", ton=" + ton);
        //builder.append(", address=\"" + address + "\"");
        //builder.append(", origBytes=" + HexDump.toHexString(origBytes));
        //builder.append(" }");
        //return builder.toString();
    }

    
        private static byte[] parseToDtmf(String address) {
        int digits = address.length();
        byte[] result = new byte[digits];
        for (int i = 0; i < digits; i++) {
            char c = address.charAt(i);
            int val = 0;
            if ((c >= '1') && (c <= '9')) val = c - '0';
            else if (c == '0') val = 10;
            else if (c == '*') val = 11;
            else if (c == '#') val = 12;
            else return null;
            result[i] = (byte)val;
        }
        return result;
    }

    
        private static String filterNumericSugar(String address) {
        StringBuilder builder = new StringBuilder();
        int len = address.length();
        for (int i = 0; i < len; i++) {
            char c = address.charAt(i);
            int mapIndex = numericCharDialableMap.indexOfKey(c);
            if (mapIndex < 0) return null;
            if (! numericCharDialableMap.valueAt(mapIndex)) continue;
            builder.append(c);
        }
        return builder.toString();
    }

    
        private static String filterWhitespace(String address) {
        StringBuilder builder = new StringBuilder();
        int len = address.length();
        for (int i = 0; i < len; i++) {
            char c = address.charAt(i);
            if ((c == ' ') || (c == '\r') || (c == '\n') || (c == '\t')) continue;
            builder.append(c);
        }
        return builder.toString();
    }

    
        public static CdmaSmsAddress parse(String address) {
        CdmaSmsAddress addr = new CdmaSmsAddress();
        addr.address = address;
        addr.ton = CdmaSmsAddress.TON_UNKNOWN;
        byte[] origBytes = null;
        String filteredAddr = filterNumericSugar(address);
        if (filteredAddr != null) {
            origBytes = parseToDtmf(filteredAddr);
        }
        if (origBytes != null) {
            addr.digitMode = DIGIT_MODE_4BIT_DTMF;
            addr.numberMode = NUMBER_MODE_NOT_DATA_NETWORK;
            if (address.indexOf('+') != -1) {
                addr.ton = TON_INTERNATIONAL_OR_IP;
            }
        } else {
            filteredAddr = filterWhitespace(address);
            origBytes = UserData.stringToAscii(filteredAddr);
            if (origBytes == null) {
                return null;
            }
            addr.digitMode = DIGIT_MODE_8BIT_CHAR;
            addr.numberMode = NUMBER_MODE_DATA_NETWORK;
            if (address.indexOf('@') != -1) {
                addr.ton = TON_NATIONAL_OR_EMAIL;
            }
        }
        addr.origBytes = origBytes;
        addr.numberOfDigits = origBytes.length;
        return addr;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.288 -0400", hash_original_field = "05583BD551D503CA7EA11893644DC766", hash_generated_field = "5A2758A0B87D9B18D12A9717FAD91DC1")

    static public final int DIGIT_MODE_4BIT_DTMF              = 0x00;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.288 -0400", hash_original_field = "D3D16AF282309AD9335C6E1154F608DF", hash_generated_field = "54BE3135249F3F73963D11C2CFE3ACB7")

    static public final int DIGIT_MODE_8BIT_CHAR              = 0x01;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.288 -0400", hash_original_field = "631C635164DB5D39155F62701AFEBD29", hash_generated_field = "AD771361B86287E166B7D8CE7FC64849")

    static public final int NUMBER_MODE_NOT_DATA_NETWORK      = 0x00;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.289 -0400", hash_original_field = "BEF33DD6964C6C1D81160DFCB6438A5C", hash_generated_field = "E28E25A5920F22272F4F31D2133ADBB6")

    static public final int NUMBER_MODE_DATA_NETWORK          = 0x01;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.289 -0400", hash_original_field = "10D9659F7C5DC6EE7A624399BBC8F445", hash_generated_field = "4E1D0DA3019C5ED56F45C703C86EF80A")

    static public final int TON_UNKNOWN                   = 0x00;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.290 -0400", hash_original_field = "44E315C22CB82648660B80953606CABF", hash_generated_field = "46DE4D9FC5CED5251126A93B49F31D15")

    static public final int TON_INTERNATIONAL_OR_IP       = 0x01;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.296 -0400", hash_original_field = "FAE738F3C6BE541A2CD7D3E37176C4BB", hash_generated_field = "BEA310D2C3D82AE006FCAC9001DF328C")

    static public final int TON_NATIONAL_OR_EMAIL         = 0x02;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.296 -0400", hash_original_field = "7E92E1B294390A47501B12BE0B3BAF96", hash_generated_field = "66C75357AB4CBAD1CB386D03C954F069")

    static public final int TON_NETWORK                   = 0x03;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.296 -0400", hash_original_field = "727D26BE83B2228649D6A14E12721CB0", hash_generated_field = "C3F71FD8206C70C10E64C1CF22F24A5F")

    static public final int TON_SUBSCRIBER                = 0x04;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.296 -0400", hash_original_field = "09FC45D1A929BE6A69C59BA5FB0B0317", hash_generated_field = "EE6F07B4A7D22A7604381942299D8AD8")

    static public final int TON_ALPHANUMERIC              = 0x05;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.296 -0400", hash_original_field = "53A8D7F863A73957A350B92F85DD96A1", hash_generated_field = "6E2A5EA3F3527C247807D43C2ACE0355")

    static public final int TON_ABBREVIATED               = 0x06;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.296 -0400", hash_original_field = "BEB150BAD875F701DFA4BFCFE014F72C", hash_generated_field = "925B7E8535A72B09739E108E8008CD09")

    static public final int TON_RESERVED                  = 0x07;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.296 -0400", hash_original_field = "4719FCBF2016C14975D904E29E9B7E04", hash_generated_field = "6987753AD84CD41E4A5632238AAB4955")

    static public final int SMS_ADDRESS_MAX          =  36;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.296 -0400", hash_original_field = "9179B7EF6FFB6D59758B73310F26F443", hash_generated_field = "6E0CB2CCD89D3350A3127CAF1CA95FE5")

    static public final int SMS_SUBADDRESS_MAX       =  36;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.296 -0400", hash_original_field = "3E29746D0E09AB3DDC8052BBF212450D", hash_generated_field = "940A0C8E5C4FC7F3D3C2DEDC2FCC5C9D")

    static public final int NUMBERING_PLAN_UNKNOWN           = 0x0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.296 -0400", hash_original_field = "E53D44700F303BAF204D74A94743B589", hash_generated_field = "C1575C82F14549903772CBAD72AAD9B3")

    static public final int NUMBERING_PLAN_ISDN_TELEPHONY    = 0x1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.296 -0400", hash_original_field = "5AE19C60D35BB8B13ECA6E6C14209D9E", hash_generated_field = "ADDEAE46A41BBACE47F0EDF8B5741969")

    private static char[] numericCharsDialable = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '*', '#'
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.296 -0400", hash_original_field = "FB2AB05EA3AE03E2F4669DC06688BFB1", hash_generated_field = "6AE1CA2F527F03B05A3D28E70E41E8C0")

    private static char[] numericCharsSugar = {
        '(', ')', ' ', '-', '+', '.', '/', '\\'
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.296 -0400", hash_original_field = "F2B196133F7E2D81EAC9A53EF6BE910F", hash_generated_field = "A132DFC5B92A7A1193EBE725AC4DB22B")

    private static SparseBooleanArray numericCharDialableMap = new SparseBooleanArray (
            numericCharsDialable.length + numericCharsSugar.length);
    static {
        for (int i = 0; i < numericCharsDialable.length; i++) {
            numericCharDialableMap.put(numericCharsDialable[i], true);
        }
        for (int i = 0; i < numericCharsSugar.length; i++) {
            numericCharDialableMap.put(numericCharsSugar[i], false);
        }
    }
    
}

