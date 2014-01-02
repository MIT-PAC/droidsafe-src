package com.android.internal.telephony.cdma.sms;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.util.SparseBooleanArray;

import com.android.internal.telephony.SmsAddress;
import com.android.internal.util.HexDump;






public class CdmaSmsAddress extends SmsAddress {

    /*
     * TODO(cleanup): Refactor the parsing for addresses to better
     * share code and logic with GSM.  Also, gather all DTMF/BCD
     * processing code in one place.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:49.774 -0500", hash_original_method = "94CDCBFA443680005A46D43F8D4600C3", hash_generated_method = "9753CE4C72E0F575AE77034E87DF86E4")
    
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

    /**
     * Given a numeric address string, return the string without
     * syntactic sugar, meaning parens, spaces, hyphens/minuses, or
     * plus signs.  If the input string contains non-numeric
     * non-punctuation characters, return null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:49.784 -0500", hash_original_method = "8E90C4CB34BFA3C349704DFD8C6BECF1", hash_generated_method = "A642FAE04AD387A5323BD6E74B8D7924")
    
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

    /**
     * Given a string, return the string without whitespace,
     * including CR/LF.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:49.787 -0500", hash_original_method = "93FB269A6EC54BFB27C79F36D7092575", hash_generated_method = "527BA607A8BF91EBA1712AE8BE5BC746")
    
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

    /**
     * Given a string, create a corresponding CdmaSmsAddress object.
     *
     * The result will be null if the input string is not
     * representable using printable ASCII.
     *
     * For numeric addresses, the string is cleaned up by removing
     * common punctuation.  For alpha addresses, the string is cleaned
     * up by removing whitespace.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:49.791 -0500", hash_original_method = "8094E6003A9AD72F860775776E112CF5", hash_generated_method = "75AB8E31F3FFE2C2BA960C3340D99E46")
    
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:49.717 -0500", hash_original_field = "C9D5C5DBB0D9E0264F89AD98EA9C44EC", hash_generated_field = "5A2758A0B87D9B18D12A9717FAD91DC1")

    static public final int DIGIT_MODE_4BIT_DTMF              = 0x00;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:49.720 -0500", hash_original_field = "0687D74D6D548DB4D7871D5D2297D010", hash_generated_field = "54BE3135249F3F73963D11C2CFE3ACB7")

    static public final int DIGIT_MODE_8BIT_CHAR              = 0x01;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:49.724 -0500", hash_original_field = "7FE6D992E68DCA973893F44950DC23ED", hash_generated_field = "AD771361B86287E166B7D8CE7FC64849")

    static public final int NUMBER_MODE_NOT_DATA_NETWORK      = 0x00;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:49.727 -0500", hash_original_field = "68E2691EA19CEBFE936552C6D218CDF1", hash_generated_field = "E28E25A5920F22272F4F31D2133ADBB6")

    static public final int NUMBER_MODE_DATA_NETWORK          = 0x01;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:49.732 -0500", hash_original_field = "2789B41D9E614B4E7F670B7F3B286EDC", hash_generated_field = "4E1D0DA3019C5ED56F45C703C86EF80A")

    static public final int TON_UNKNOWN                   = 0x00;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:49.735 -0500", hash_original_field = "C61F7E3748A5BB5CD1876D634E2C42DB", hash_generated_field = "46DE4D9FC5CED5251126A93B49F31D15")

    static public final int TON_INTERNATIONAL_OR_IP       = 0x01;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:49.737 -0500", hash_original_field = "6E5D4D02C07D093D64A1C4A14EA6B30F", hash_generated_field = "BEA310D2C3D82AE006FCAC9001DF328C")

    static public final int TON_NATIONAL_OR_EMAIL         = 0x02;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:49.739 -0500", hash_original_field = "0388B0F5A2288E4CC7D9B2E11AE1F47E", hash_generated_field = "66C75357AB4CBAD1CB386D03C954F069")

    static public final int TON_NETWORK                   = 0x03;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:49.742 -0500", hash_original_field = "9A808F6C51C23B14FAF8631742FFB4F2", hash_generated_field = "C3F71FD8206C70C10E64C1CF22F24A5F")

    static public final int TON_SUBSCRIBER                = 0x04;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:49.744 -0500", hash_original_field = "42D29FB64A0C2ADDE918A1B0F254A92C", hash_generated_field = "EE6F07B4A7D22A7604381942299D8AD8")

    static public final int TON_ALPHANUMERIC              = 0x05;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:49.747 -0500", hash_original_field = "8EA177D7DA8558BC961593DA74AE6B43", hash_generated_field = "6E2A5EA3F3527C247807D43C2ACE0355")

    static public final int TON_ABBREVIATED               = 0x06;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:49.750 -0500", hash_original_field = "F3B53247F88B225C483EC9996C4EE06A", hash_generated_field = "925B7E8535A72B09739E108E8008CD09")

    static public final int TON_RESERVED                  = 0x07;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:49.753 -0500", hash_original_field = "FD5D2F93FF5E58CB74EE35401F8D515B", hash_generated_field = "6987753AD84CD41E4A5632238AAB4955")

    static public final int SMS_ADDRESS_MAX          =  36;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:49.755 -0500", hash_original_field = "62B1AFEB280BAFF2D1768E5F2D22618B", hash_generated_field = "6E0CB2CCD89D3350A3127CAF1CA95FE5")

    static public final int SMS_SUBADDRESS_MAX       =  36;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:49.761 -0500", hash_original_field = "9D75F92B84E7241CAAD1C8521D460B08", hash_generated_field = "940A0C8E5C4FC7F3D3C2DEDC2FCC5C9D")

    static public final int NUMBERING_PLAN_UNKNOWN           = 0x0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:49.763 -0500", hash_original_field = "9D21B48D9BFC441272C0B1C08336371C", hash_generated_field = "C1575C82F14549903772CBAD72AAD9B3")

    static public final int NUMBERING_PLAN_ISDN_TELEPHONY    = 0x1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:49.777 -0500", hash_original_field = "A64F5A798EB6CA8C17C15747160E252A", hash_generated_field = "00E884E68BEB39F563669D9FAF5BFCF3")


    private static final char[] numericCharsDialable = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '*', '#'
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:49.779 -0500", hash_original_field = "B05F9DA368C10DEF9F752276FDB4EEC5", hash_generated_field = "EC628CFAB5EFDD0C4241E5FFF0B67C86")


    private static final char[] numericCharsSugar = {
        '(', ')', ' ', '-', '+', '.', '/', '\\'
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:49.782 -0500", hash_original_field = "D5086EE4F9CC96792F605F498053CE65", hash_generated_field = "2A475C0FC5FE4DAC50F34DDADF01035E")


    private static final SparseBooleanArray numericCharDialableMap = new SparseBooleanArray (
            numericCharsDialable.length + numericCharsSugar.length);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:49.722 -0500", hash_original_field = "95A92FD03ED6030688D1428AC7469695", hash_generated_field = "84D708851062F6247553AB01A32917F4")


    public int digitMode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:49.729 -0500", hash_original_field = "962B558E45E8225B77AF1A46E6FCF9DB", hash_generated_field = "684B3B4D05E25597D49E78621D640BA3")


    public int numberMode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:49.758 -0500", hash_original_field = "BD35BB3473BF9134209D1D8D0E6D72E2", hash_generated_field = "380C724376E6D50354D5A2BE6AD71C15")

    public int numberOfDigits;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:49.765 -0500", hash_original_field = "24727A36E01C18526D4583586B00366A", hash_generated_field = "8BE0FE6FF3ADD41BE52BAA8B67E235AA")

    //static protected final int NUMBERING_PLAN_TELEX             = 0x4;
    //static protected final int NUMBERING_PLAN_PRIVATE           = 0x9;

    public int numberPlan;

    /**
     * NOTE: the parsed string address and the raw byte array values
     * are stored in the parent class address and origBytes fields,
     * respectively.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:49.768 -0500", hash_original_method = "C14D3E49998397C1BAE29B9693261AA4", hash_generated_method = "91279E3A882CF9CD2214172B23D3D4B8")
    
public CdmaSmsAddress(){
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:49.771 -0500", hash_original_method = "63A53E613DBD8AE7867F216680739B01", hash_generated_method = "09CDD0D7433F20EFD32B305806295534")
    
@Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("CdmaSmsAddress ");
        builder.append("{ digitMode=" + digitMode);
        builder.append(", numberMode=" + numberMode);
        builder.append(", numberPlan=" + numberPlan);
        builder.append(", numberOfDigits=" + numberOfDigits);
        builder.append(", ton=" + ton);
        builder.append(", address=\"" + address + "\"");
        builder.append(", origBytes=" + HexDump.toHexString(origBytes));
        builder.append(" }");
        return builder.toString();
    }
    static {
        for (int i = 0; i < numericCharsDialable.length; i++) {
            numericCharDialableMap.put(numericCharsDialable[i], true);
        }
        for (int i = 0; i < numericCharsSugar.length; i++) {
            numericCharDialableMap.put(numericCharsSugar[i], false);
        }
    }
    
}

