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
    public int digitMode;
    public int numberMode;
    public int numberOfDigits;
    public int numberPlan;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.030 -0400", hash_original_method = "C14D3E49998397C1BAE29B9693261AA4", hash_generated_method = "D0B7A6B483495AD2F861F207E5EE1740")
    @DSModeled(DSC.SAFE)
    public CdmaSmsAddress() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.030 -0400", hash_original_method = "63A53E613DBD8AE7867F216680739B01", hash_generated_method = "BF7687AF7422E606506B3DB512A71591")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
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
        String var687AAF24B90629C9BFCFE9608FDCE6E7_1885429707 = (builder.toString());
        return dsTaint.getTaintString();
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

    
    static public final int DIGIT_MODE_4BIT_DTMF              = 0x00;
    static public final int DIGIT_MODE_8BIT_CHAR              = 0x01;
    static public final int NUMBER_MODE_NOT_DATA_NETWORK      = 0x00;
    static public final int NUMBER_MODE_DATA_NETWORK          = 0x01;
    static public final int TON_UNKNOWN                   = 0x00;
    static public final int TON_INTERNATIONAL_OR_IP       = 0x01;
    static public final int TON_NATIONAL_OR_EMAIL         = 0x02;
    static public final int TON_NETWORK                   = 0x03;
    static public final int TON_SUBSCRIBER                = 0x04;
    static public final int TON_ALPHANUMERIC              = 0x05;
    static public final int TON_ABBREVIATED               = 0x06;
    static public final int TON_RESERVED                  = 0x07;
    static public final int SMS_ADDRESS_MAX          =  36;
    static public final int SMS_SUBADDRESS_MAX       =  36;
    static public final int NUMBERING_PLAN_UNKNOWN           = 0x0;
    static public final int NUMBERING_PLAN_ISDN_TELEPHONY    = 0x1;
    private static final char[] numericCharsDialable = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '*', '#'
    };
    private static final char[] numericCharsSugar = {
        '(', ')', ' ', '-', '+', '.', '/', '\\'
    };
    private static final SparseBooleanArray numericCharDialableMap = new SparseBooleanArray (
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

