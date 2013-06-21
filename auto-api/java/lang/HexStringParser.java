package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class HexStringParser {
    private int EXPONENT_WIDTH;
    private int MANTISSA_WIDTH;
    private long EXPONENT_BASE;
    private long MAX_EXPONENT;
    private long MIN_EXPONENT;
    private long MANTISSA_MASK;
    private long sign;
    private long exponent;
    private long mantissa;
    private String abandonedNumber="";
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.730 -0400", hash_original_method = "0F94CFCCDCBAD4C71218B93664CFA571", hash_generated_method = "78C80D6FAC36424CE53085E2DDF98863")
    @DSModeled(DSC.SAFE)
    public HexStringParser(int exponentWidth, int mantissaWidth) {
        dsTaint.addTaint(mantissaWidth);
        dsTaint.addTaint(exponentWidth);
        this.EXPONENT_BASE = ~(-1L << (exponentWidth - 1));
        this.MAX_EXPONENT = ~(-1L << exponentWidth);
        this.MIN_EXPONENT = -(MANTISSA_WIDTH + 1);
        this.MANTISSA_MASK = ~(-1L << mantissaWidth);
        // ---------- Original Method ----------
        //this.EXPONENT_WIDTH = exponentWidth;
        //this.MANTISSA_WIDTH = mantissaWidth;
        //this.EXPONENT_BASE = ~(-1L << (exponentWidth - 1));
        //this.MAX_EXPONENT = ~(-1L << exponentWidth);
        //this.MIN_EXPONENT = -(MANTISSA_WIDTH + 1);
        //this.MANTISSA_MASK = ~(-1L << mantissaWidth);
    }

    
        public static double parseDouble(String hexString) {
        HexStringParser parser = new HexStringParser(DOUBLE_EXPONENT_WIDTH, DOUBLE_MANTISSA_WIDTH);
        long result = parser.parse(hexString, true);
        return Double.longBitsToDouble(result);
    }

    
        public static float parseFloat(String hexString) {
        HexStringParser parser = new HexStringParser(FLOAT_EXPONENT_WIDTH, FLOAT_MANTISSA_WIDTH);
        int result = (int) parser.parse(hexString, false);
        return Float.intBitsToFloat(result);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.730 -0400", hash_original_method = "596249BB373F56930CF8BA31CC9F5A97", hash_generated_method = "0A68D2244795946DEA032F4E02585CE6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private long parse(String hexString, boolean isDouble) {
        dsTaint.addTaint(hexString);
        dsTaint.addTaint(isDouble);
        Matcher matcher;
        matcher = PATTERN.matcher(hexString);
        {
            boolean var29857123035FF7A64A8598EB68050605_1867931437 = (!matcher.matches());
            {
                if (DroidSafeAndroidRuntime.control) throw new NumberFormatException("Invalid hex " + (isDouble ? "double" : "float")+ ":" +
                    hexString);
            } //End block
        } //End collapsed parenthetic
        String signStr;
        signStr = matcher.group(1);
        String significantStr;
        significantStr = matcher.group(2);
        String exponentStr;
        exponentStr = matcher.group(3);
        parseHexSign(signStr);
        parseExponent(exponentStr);
        parseMantissa(significantStr);
        sign <<= (MANTISSA_WIDTH + EXPONENT_WIDTH);
        exponent <<= MANTISSA_WIDTH;
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //Matcher matcher = PATTERN.matcher(hexString);
        //if (!matcher.matches()) {
            //throw new NumberFormatException("Invalid hex " + (isDouble ? "double" : "float")+ ":" +
                    //hexString);
        //}
        //String signStr = matcher.group(1);
        //String significantStr = matcher.group(2);
        //String exponentStr = matcher.group(3);
        //parseHexSign(signStr);
        //parseExponent(exponentStr);
        //parseMantissa(significantStr);
        //sign <<= (MANTISSA_WIDTH + EXPONENT_WIDTH);
        //exponent <<= MANTISSA_WIDTH;
        //return sign | exponent | mantissa;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.731 -0400", hash_original_method = "974D688FE86E3244D16C6508E4669FC6", hash_generated_method = "46C6B347155BEF7EFF6C9CC4806F1630")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void parseHexSign(String signStr) {
        dsTaint.addTaint(signStr);
        this.sign = signStr.equals("-") ? 1 : 0;
        // ---------- Original Method ----------
        //this.sign = signStr.equals("-") ? 1 : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.731 -0400", hash_original_method = "F54ED53D7D015179F6121F71E1763DC9", hash_generated_method = "3FAD4EC26505D12BBED1660071F73008")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void parseExponent(String exponentStr) {
        dsTaint.addTaint(exponentStr);
        char leadingChar;
        leadingChar = exponentStr.charAt(0);
        int expSign;
        expSign = (leadingChar == '-' ? -1 : 1);//DSFIXME:  CODE0008: Nested ternary operator in expression
        {
            boolean var12918441ABCBAE31E5F02154106075A8_742292287 = (!Character.isDigit(leadingChar));
            {
                exponentStr = exponentStr.substring(1);
            } //End block
        } //End collapsed parenthetic
        try 
        {
            exponent = expSign * Long.parseLong(exponentStr);
            checkedAddExponent(EXPONENT_BASE);
        } //End block
        catch (NumberFormatException e)
        {
            exponent = expSign * Long.MAX_VALUE;
        } //End block
        // ---------- Original Method ----------
        //char leadingChar = exponentStr.charAt(0);
        //int expSign = (leadingChar == '-' ? -1 : 1);
        //if (!Character.isDigit(leadingChar)) {
            //exponentStr = exponentStr.substring(1);
        //}
        //try {
            //exponent = expSign * Long.parseLong(exponentStr);
            //checkedAddExponent(EXPONENT_BASE);
        //} catch (NumberFormatException e) {
            //exponent = expSign * Long.MAX_VALUE;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.731 -0400", hash_original_method = "661AC685F2EB81E51AC0AC93731FE290", hash_generated_method = "AF7BC63FAE1B14A5B5D97FD1AF1D828A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void parseMantissa(String significantStr) {
        dsTaint.addTaint(significantStr);
        String[] strings;
        strings = significantStr.split("\\.");
        String strIntegerPart;
        strIntegerPart = strings[0];
        String strDecimalPart;
        strDecimalPart = strings[1];
        strDecimalPart = "";
        String significand;
        significand = getNormalizedSignificand(strIntegerPart,strDecimalPart);
        {
            boolean var33E818A7CFC583690A348CAC6377C380_386096077 = (significand.equals("0"));
            {
                setZero();
            } //End block
        } //End collapsed parenthetic
        int offset;
        offset = getOffset(strIntegerPart, strDecimalPart);
        checkedAddExponent(offset);
        {
            setInfinite();
        } //End block
        {
            setZero();
        } //End block
        {
            boolean varE202BC62D51C45F8F24333A3E462DF98_43433775 = (significand.length() > MAX_SIGNIFICANT_LENGTH);
            {
                abandonedNumber = significand.substring(MAX_SIGNIFICANT_LENGTH);
                significand = significand.substring(0, MAX_SIGNIFICANT_LENGTH);
            } //End block
        } //End collapsed parenthetic
        mantissa = Long.parseLong(significand, HEX_RADIX);
        {
            processNormalNumber();
        } //End block
        {
            processSubNormalNumber();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.732 -0400", hash_original_method = "E5B2CE5158E0191EB1B4342B503B503C", hash_generated_method = "79359CB12970F2F3F56D34C9271ED5F0")
    @DSModeled(DSC.SAFE)
    private void setInfinite() {
        exponent = MAX_EXPONENT;
        mantissa = 0;
        // ---------- Original Method ----------
        //exponent = MAX_EXPONENT;
        //mantissa = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.732 -0400", hash_original_method = "B9AC8BA0C31319FE099B6A6C8A6F4144", hash_generated_method = "243374FBE0863DE96BE7168DB3C6FD32")
    @DSModeled(DSC.SAFE)
    private void setZero() {
        exponent = 0;
        mantissa = 0;
        // ---------- Original Method ----------
        //exponent = 0;
        //mantissa = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.732 -0400", hash_original_method = "C2A5C13C47CD41059D53CDBF46698CF7", hash_generated_method = "AEAEAAD5F81F90BF0A2CEA9BB2909223")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkedAddExponent(long offset) {
        dsTaint.addTaint(offset);
        long result;
        result = exponent + offset;
        int expSign;
        expSign = Long.signum(exponent);
        {
            boolean var4023E4EFC04C969892416657FDC87896_1048233881 = (expSign * Long.signum(offset) > 0 && expSign * Long.signum(result) < 0);
            {
                exponent = expSign * Long.MAX_VALUE;
            } //End block
            {
                exponent = result;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //long result = exponent + offset;
        //int expSign = Long.signum(exponent);
        //if (expSign * Long.signum(offset) > 0 && expSign * Long.signum(result) < 0) {
            //exponent = expSign * Long.MAX_VALUE;
        //} else {
            //exponent = result;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.732 -0400", hash_original_method = "9CA1C86CDD20337336DE019762D1A2F8", hash_generated_method = "847C516BD365D65A506CEAB8150E293A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void processNormalNumber() {
        int desiredWidth;
        desiredWidth = MANTISSA_WIDTH + 2;
        fitMantissaInDesiredWidth(desiredWidth);
        round();
        mantissa = mantissa & MANTISSA_MASK;
        // ---------- Original Method ----------
        //int desiredWidth = MANTISSA_WIDTH + 2;
        //fitMantissaInDesiredWidth(desiredWidth);
        //round();
        //mantissa = mantissa & MANTISSA_MASK;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.732 -0400", hash_original_method = "C617BA86E331FAE3F2D53918109E2E13", hash_generated_method = "2CB5FFCAC4AA93E4551087521D611E60")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void processSubNormalNumber() {
        int desiredWidth;
        desiredWidth = MANTISSA_WIDTH + 1;
        desiredWidth += (int)exponent;
        exponent = 0;
        fitMantissaInDesiredWidth(desiredWidth);
        round();
        mantissa = mantissa & MANTISSA_MASK;
        // ---------- Original Method ----------
        //int desiredWidth = MANTISSA_WIDTH + 1;
        //desiredWidth += (int)exponent;
        //exponent = 0;
        //fitMantissaInDesiredWidth(desiredWidth);
        //round();
        //mantissa = mantissa & MANTISSA_MASK;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.733 -0400", hash_original_method = "330648F0D53116AAA430ECFB8E97D2A6", hash_generated_method = "513B6E699B985A395B24DDDF17770CCA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void fitMantissaInDesiredWidth(int desiredWidth) {
        dsTaint.addTaint(desiredWidth);
        int bitLength;
        bitLength = countBitsLength(mantissa);
        {
            discardTrailingBits(bitLength - desiredWidth);
        } //End block
        {
            mantissa <<= (desiredWidth - bitLength);
        } //End block
        // ---------- Original Method ----------
        //int bitLength = countBitsLength(mantissa);
        //if (bitLength > desiredWidth) {
            //discardTrailingBits(bitLength - desiredWidth);
        //} else {
            //mantissa <<= (desiredWidth - bitLength);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.733 -0400", hash_original_method = "40C79332802B26AD9210D4E26ECE1852", hash_generated_method = "D4A3BC3955F798DBA1FE9E302F5CE902")
    @DSModeled(DSC.SAFE)
    private void discardTrailingBits(long num) {
        dsTaint.addTaint(num);
        long mask;
        mask = ~(-1L << num);
        abandonedNumber += (mantissa & mask);
        // ---------- Original Method ----------
        //long mask = ~(-1L << num);
        //abandonedNumber += (mantissa & mask);
        //mantissa >>= num;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.733 -0400", hash_original_method = "BE1368BC0340B1F1D2FFF04FBC3A9E13", hash_generated_method = "B2345DF0811EE57FED33A7D168B6B79D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void round() {
        String result;
        result = abandonedNumber.replaceAll("0+", "");
        boolean moreThanZero;
        moreThanZero = (result.length() > 0 ? true : false);//DSFIXME:  CODE0008: Nested ternary operator in expression
        int lastDiscardedBit;
        lastDiscardedBit = (int) (mantissa & 1L);
        mantissa >>= 1;
        int tailBitInMantissa;
        tailBitInMantissa = (int) (mantissa & 1L);
        {
            int oldLength;
            oldLength = countBitsLength(mantissa);
            mantissa += 1L;
            int newLength;
            newLength = countBitsLength(mantissa);
            {
                checkedAddExponent(1);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //String result = abandonedNumber.replaceAll("0+", "");
        //boolean moreThanZero = (result.length() > 0 ? true : false);
        //int lastDiscardedBit = (int) (mantissa & 1L);
        //mantissa >>= 1;
        //int tailBitInMantissa = (int) (mantissa & 1L);
        //if (lastDiscardedBit == 1 && (moreThanZero || tailBitInMantissa == 1)) {
            //int oldLength = countBitsLength(mantissa);
            //mantissa += 1L;
            //int newLength = countBitsLength(mantissa);
            //if (oldLength >= MANTISSA_WIDTH && newLength > oldLength) {
                //checkedAddExponent(1);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.733 -0400", hash_original_method = "D2C62D141CD2F22FD7386D5422E8C46E", hash_generated_method = "2FC450C1FE18EB8B2644631020431091")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String getNormalizedSignificand(String strIntegerPart, String strDecimalPart) {
        dsTaint.addTaint(strDecimalPart);
        dsTaint.addTaint(strIntegerPart);
        String significand;
        significand = strIntegerPart + strDecimalPart;
        significand = significand.replaceFirst("^0+", "");
        {
            boolean varCB56E8C1B765A44EE13A3876ED8AFD68_396447718 = (significand.length() == 0);
            {
                significand = "0";
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String significand = strIntegerPart + strDecimalPart;
        //significand = significand.replaceFirst("^0+", "");
        //if (significand.length() == 0) {
            //significand = "0";
        //}
        //return significand;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.734 -0400", hash_original_method = "08762480F158FA197B11D4959C7DC334", hash_generated_method = "987E0DE14BE3052B5160EA91B2E23A36")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getOffset(String strIntegerPart, String strDecimalPart) {
        dsTaint.addTaint(strDecimalPart);
        dsTaint.addTaint(strIntegerPart);
        strIntegerPart = strIntegerPart.replaceFirst("^0+", "");
        {
            boolean varE136E385037462C3E72E57ECC517FB4A_1821064431 = (strIntegerPart.length() != 0);
            {
                String leadingNumber;
                leadingNumber = strIntegerPart.substring(0, 1);
                int var0F5F88D92968EEF0EEA83651B2C4EAF9_1085837256 = ((strIntegerPart.length() - 1) * 4 + countBitsLength(Long.parseLong(leadingNumber,HEX_RADIX)) - 1);
            } //End block
        } //End collapsed parenthetic
        int i;
        {
            i = 0;
            boolean varE884A9B658B796521F6D7CFBE1EED16D_342651069 = (i < strDecimalPart.length() && strDecimalPart.charAt(i) == '0');
            ;
        } //End collapsed parenthetic
        {
            boolean varEFA2529895BBE26403532BB3B6E39EFC_642304994 = (i == strDecimalPart.length());
        } //End collapsed parenthetic
        String leadingNumber;
        leadingNumber = strDecimalPart.substring(i,i + 1);
        int varF22829AC0DE8799BD6C5C24AE662D7AF_1272219468 = ((-i - 1) * 4 + countBitsLength(Long.parseLong(leadingNumber, HEX_RADIX)) - 1);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //strIntegerPart = strIntegerPart.replaceFirst("^0+", "");
        //if (strIntegerPart.length() != 0) {
            //String leadingNumber = strIntegerPart.substring(0, 1);
            //return (strIntegerPart.length() - 1) * 4 + countBitsLength(Long.parseLong(leadingNumber,HEX_RADIX)) - 1;
        //}
        //int i;
        //for (i = 0; i < strDecimalPart.length() && strDecimalPart.charAt(i) == '0'; i++);
        //if (i == strDecimalPart.length()) {
            //return 0;
        //}
        //String leadingNumber=strDecimalPart.substring(i,i + 1);
        //return (-i - 1) * 4 + countBitsLength(Long.parseLong(leadingNumber, HEX_RADIX)) - 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.734 -0400", hash_original_method = "20FEBC548021CA37C4B86DB718571102", hash_generated_method = "95853CEB34F978C97A1AF2EA5B65F7B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int countBitsLength(long value) {
        dsTaint.addTaint(value);
        int leadingZeros;
        leadingZeros = Long.numberOfLeadingZeros(value);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int leadingZeros = Long.numberOfLeadingZeros(value);
        //return Long.SIZE - leadingZeros;
    }

    
    private static final int DOUBLE_EXPONENT_WIDTH = 11;
    private static final int DOUBLE_MANTISSA_WIDTH = 52;
    private static final int FLOAT_EXPONENT_WIDTH = 8;
    private static final int FLOAT_MANTISSA_WIDTH = 23;
    private static final int HEX_RADIX = 16;
    private static final int MAX_SIGNIFICANT_LENGTH = 15;
    private static final String HEX_SIGNIFICANT = "0[xX](\\p{XDigit}+\\.?|\\p{XDigit}*\\.\\p{XDigit}+)";
    private static final String BINARY_EXPONENT = "[pP]([+-]?\\d+)";
    private static final String FLOAT_TYPE_SUFFIX = "[fFdD]?";
    private static final String HEX_PATTERN = "[\\x00-\\x20]*([+-]?)" + HEX_SIGNIFICANT
            + BINARY_EXPONENT + FLOAT_TYPE_SUFFIX + "[\\x00-\\x20]*";
    private static final Pattern PATTERN = Pattern.compile(HEX_PATTERN);
}

