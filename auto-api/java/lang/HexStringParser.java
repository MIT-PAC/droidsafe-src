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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.575 -0400", hash_original_field = "94B91A0CFAEF3637DD641B0B0FB4F9B1", hash_generated_field = "3D1EE3F91B74E8DB430F2C1AC83A33D3")

    private int EXPONENT_WIDTH;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.575 -0400", hash_original_field = "60EFD0ED4D45F4B4A666A4093D94345D", hash_generated_field = "B9594B2F4506B67397EA5D3B03F60E18")

    private int MANTISSA_WIDTH;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.575 -0400", hash_original_field = "E143E81117216A0597A0740D9BB6D6DE", hash_generated_field = "C481FEDF39B196EABE033BD5CF17A7CB")

    private long EXPONENT_BASE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.575 -0400", hash_original_field = "67CA7FFB906FEBAE77BA4FFA7EC617A7", hash_generated_field = "C18CFDC021CBD7ABEB40DBD973A0ECFF")

    private long MAX_EXPONENT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.575 -0400", hash_original_field = "47C12D34BCFE98F694C58213C9C7B58F", hash_generated_field = "872FB1713A6708D4E85FF0ED4DC8BA7A")

    private long MIN_EXPONENT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.575 -0400", hash_original_field = "8EFF407AD7EEFB61C410B09DF698A9D4", hash_generated_field = "8F4140030FA67A2AE931BFB5AC88AE5E")

    private long MANTISSA_MASK;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.575 -0400", hash_original_field = "04B29480233F4DEF5C875875B6BDC3B1", hash_generated_field = "676D5001C1F011FD0B5A42C3B42410B6")

    private long sign;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.575 -0400", hash_original_field = "FACD4BC86B7F12740C83BCAA4E75AE0A", hash_generated_field = "DFBAA63A672635AB7C1CDDF13CEC1972")

    private long exponent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.575 -0400", hash_original_field = "8D53751FB2F972417C22F50994C3CB8B", hash_generated_field = "A592FD1FA81B363A971ABDB296D5BCFC")

    private long mantissa;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.575 -0400", hash_original_field = "2C740FBDD9C6ADC2AE67719BEED45845", hash_generated_field = "EDC092F9A3603100C3E4D1F89B0BAF46")

    private String abandonedNumber = "";
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.576 -0400", hash_original_method = "0F94CFCCDCBAD4C71218B93664CFA571", hash_generated_method = "FAB0E994F336D410190943BCA78F23A8")
    public  HexStringParser(int exponentWidth, int mantissaWidth) {
        this.EXPONENT_WIDTH = exponentWidth;
        this.MANTISSA_WIDTH = mantissaWidth;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.577 -0400", hash_original_method = "596249BB373F56930CF8BA31CC9F5A97", hash_generated_method = "779EB41AACDF758CC6FC950ACFA473B9")
    private long parse(String hexString, boolean isDouble) {
        Matcher matcher;
        matcher = PATTERN.matcher(hexString);
        {
            boolean var29857123035FF7A64A8598EB68050605_1091543397 = (!matcher.matches());
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
        addTaint(hexString.getTaint());
        addTaint(isDouble);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1457849099 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1457849099;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.588 -0400", hash_original_method = "974D688FE86E3244D16C6508E4669FC6", hash_generated_method = "13BFEC942BAEF96FE6E364B15622A4E9")
    private void parseHexSign(String signStr) {
        this.sign = signStr.equals("-") ? 1 : 0;
        // ---------- Original Method ----------
        //this.sign = signStr.equals("-") ? 1 : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.589 -0400", hash_original_method = "F54ED53D7D015179F6121F71E1763DC9", hash_generated_method = "59B9194E3F6A49BAF7A7EA12E800A78D")
    private void parseExponent(String exponentStr) {
        char leadingChar;
        leadingChar = exponentStr.charAt(0);
        int expSign;
        expSign = (leadingChar == '-' ? -1 : 1);//DSFIXME:  CODE0008: Nested ternary operator in expression
        {
            boolean var12918441ABCBAE31E5F02154106075A8_935100451 = (!Character.isDigit(leadingChar));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.600 -0400", hash_original_method = "661AC685F2EB81E51AC0AC93731FE290", hash_generated_method = "A221786604D22A87A2873A5C899857BA")
    private void parseMantissa(String significantStr) {
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
            boolean var33E818A7CFC583690A348CAC6377C380_2060851563 = (significand.equals("0"));
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
            boolean varE202BC62D51C45F8F24333A3E462DF98_1744518255 = (significand.length() > MAX_SIGNIFICANT_LENGTH);
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
        addTaint(significantStr.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.601 -0400", hash_original_method = "E5B2CE5158E0191EB1B4342B503B503C", hash_generated_method = "79359CB12970F2F3F56D34C9271ED5F0")
    private void setInfinite() {
        exponent = MAX_EXPONENT;
        mantissa = 0;
        // ---------- Original Method ----------
        //exponent = MAX_EXPONENT;
        //mantissa = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.602 -0400", hash_original_method = "B9AC8BA0C31319FE099B6A6C8A6F4144", hash_generated_method = "243374FBE0863DE96BE7168DB3C6FD32")
    private void setZero() {
        exponent = 0;
        mantissa = 0;
        // ---------- Original Method ----------
        //exponent = 0;
        //mantissa = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.606 -0400", hash_original_method = "C2A5C13C47CD41059D53CDBF46698CF7", hash_generated_method = "FDFC14FBD9874D4372116D93F7AFC57E")
    private void checkedAddExponent(long offset) {
        long result;
        result = exponent + offset;
        int expSign;
        expSign = Long.signum(exponent);
        {
            boolean var4023E4EFC04C969892416657FDC87896_908117646 = (expSign * Long.signum(offset) > 0 && expSign * Long.signum(result) < 0);
            {
                exponent = expSign * Long.MAX_VALUE;
            } //End block
            {
                exponent = result;
            } //End block
        } //End collapsed parenthetic
        addTaint(offset);
        // ---------- Original Method ----------
        //long result = exponent + offset;
        //int expSign = Long.signum(exponent);
        //if (expSign * Long.signum(offset) > 0 && expSign * Long.signum(result) < 0) {
            //exponent = expSign * Long.MAX_VALUE;
        //} else {
            //exponent = result;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.608 -0400", hash_original_method = "9CA1C86CDD20337336DE019762D1A2F8", hash_generated_method = "847C516BD365D65A506CEAB8150E293A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.619 -0400", hash_original_method = "C617BA86E331FAE3F2D53918109E2E13", hash_generated_method = "2CB5FFCAC4AA93E4551087521D611E60")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.619 -0400", hash_original_method = "330648F0D53116AAA430ECFB8E97D2A6", hash_generated_method = "C553FBA8C55E0E00674CD751D66173E6")
    private void fitMantissaInDesiredWidth(int desiredWidth) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.628 -0400", hash_original_method = "40C79332802B26AD9210D4E26ECE1852", hash_generated_method = "B6ECD8FA63F772AE6E02EA18A811589C")
    private void discardTrailingBits(long num) {
        long mask;
        mask = ~(-1L << num);
        abandonedNumber += (mantissa & mask);
        mantissa >>= num;
        // ---------- Original Method ----------
        //long mask = ~(-1L << num);
        //abandonedNumber += (mantissa & mask);
        //mantissa >>= num;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.629 -0400", hash_original_method = "BE1368BC0340B1F1D2FFF04FBC3A9E13", hash_generated_method = "B2345DF0811EE57FED33A7D168B6B79D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.641 -0400", hash_original_method = "D2C62D141CD2F22FD7386D5422E8C46E", hash_generated_method = "0B32A88724321EC0BBCC88B033BD654F")
    private String getNormalizedSignificand(String strIntegerPart, String strDecimalPart) {
        String varB4EAC82CA7396A68D541C85D26508E83_735479094 = null; //Variable for return #1
        String significand;
        significand = strIntegerPart + strDecimalPart;
        significand = significand.replaceFirst("^0+", "");
        {
            boolean varCB56E8C1B765A44EE13A3876ED8AFD68_203132592 = (significand.length() == 0);
            {
                significand = "0";
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_735479094 = significand;
        addTaint(strIntegerPart.getTaint());
        addTaint(strDecimalPart.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_735479094.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_735479094;
        // ---------- Original Method ----------
        //String significand = strIntegerPart + strDecimalPart;
        //significand = significand.replaceFirst("^0+", "");
        //if (significand.length() == 0) {
            //significand = "0";
        //}
        //return significand;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.642 -0400", hash_original_method = "08762480F158FA197B11D4959C7DC334", hash_generated_method = "83B15A7B0D66070509AB1BDE02F5A9BE")
    private int getOffset(String strIntegerPart, String strDecimalPart) {
        strIntegerPart = strIntegerPart.replaceFirst("^0+", "");
        {
            boolean varE136E385037462C3E72E57ECC517FB4A_855452270 = (strIntegerPart.length() != 0);
            {
                String leadingNumber;
                leadingNumber = strIntegerPart.substring(0, 1);
                int var0F5F88D92968EEF0EEA83651B2C4EAF9_462732898 = ((strIntegerPart.length() - 1) * 4 + countBitsLength(Long.parseLong(leadingNumber,HEX_RADIX)) - 1);
            } //End block
        } //End collapsed parenthetic
        int i;
        {
            i = 0;
            boolean varE884A9B658B796521F6D7CFBE1EED16D_1467946248 = (i < strDecimalPart.length() && strDecimalPart.charAt(i) == '0');
            ;
        } //End collapsed parenthetic
        {
            boolean varEFA2529895BBE26403532BB3B6E39EFC_553343247 = (i == strDecimalPart.length());
        } //End collapsed parenthetic
        String leadingNumber;
        leadingNumber = strDecimalPart.substring(i,i + 1);
        int varF22829AC0DE8799BD6C5C24AE662D7AF_1135956995 = ((-i - 1) * 4 + countBitsLength(Long.parseLong(leadingNumber, HEX_RADIX)) - 1);
        addTaint(strIntegerPart.getTaint());
        addTaint(strDecimalPart.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_93110751 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_93110751;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.642 -0400", hash_original_method = "20FEBC548021CA37C4B86DB718571102", hash_generated_method = "8D911377B6BFA4BB210C8374F3D55B2A")
    private int countBitsLength(long value) {
        int leadingZeros;
        leadingZeros = Long.numberOfLeadingZeros(value);
        addTaint(value);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1621451248 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1621451248;
        // ---------- Original Method ----------
        //int leadingZeros = Long.numberOfLeadingZeros(value);
        //return Long.SIZE - leadingZeros;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.642 -0400", hash_original_field = "E95BD279C9DF5452687674F1091E87A7", hash_generated_field = "7F7669CE5DCAA3ECA09C187729813601")

    private static int DOUBLE_EXPONENT_WIDTH = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.642 -0400", hash_original_field = "25BB785398DA769218D55CE71FEEBD70", hash_generated_field = "6AD69CD068E02375FDF9516CF752A28D")

    private static int DOUBLE_MANTISSA_WIDTH = 52;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.642 -0400", hash_original_field = "26F5EDC28A664C421B11FCE3033BFC3E", hash_generated_field = "E7F3D9410C08896E5F1F1C63C5889C83")

    private static int FLOAT_EXPONENT_WIDTH = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.643 -0400", hash_original_field = "B00C042C0AE59B835AB83607B098998B", hash_generated_field = "E0DA11369E6A491BED56D8C5BFCFCCD9")

    private static int FLOAT_MANTISSA_WIDTH = 23;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.643 -0400", hash_original_field = "5603A6B10AC8627DB5145C05B3D58A33", hash_generated_field = "D4A77FF1CCFDF8CCE99B201EC49B3F32")

    private static int HEX_RADIX = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.643 -0400", hash_original_field = "5632A5274F3D356438943DCE4665D451", hash_generated_field = "B01409EDBB6DAE4ADFEF806A13390917")

    private static int MAX_SIGNIFICANT_LENGTH = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.643 -0400", hash_original_field = "2B0526347792B208CA1A778CA7BE472B", hash_generated_field = "66BEF5FB33DFB495721035CA87B5A189")

    private static String HEX_SIGNIFICANT = "0[xX](\\p{XDigit}+\\.?|\\p{XDigit}*\\.\\p{XDigit}+)";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.643 -0400", hash_original_field = "5E4989FA31617E624B47332BC4FEAD8F", hash_generated_field = "9E10AA70152864714B7378E92F7A0260")

    private static String BINARY_EXPONENT = "[pP]([+-]?\\d+)";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.643 -0400", hash_original_field = "9DF37BC726928BEF43F26853D07A2376", hash_generated_field = "9E574B65F60F8C548386A9E7991D7C2A")

    private static String FLOAT_TYPE_SUFFIX = "[fFdD]?";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.643 -0400", hash_original_field = "DCEAA83FB368B63F1A6A0A8ECA956C03", hash_generated_field = "6406572BD98F12467EBF9022263F65A2")

    private static String HEX_PATTERN = "[\\x00-\\x20]*([+-]?)" + HEX_SIGNIFICANT
            + BINARY_EXPONENT + FLOAT_TYPE_SUFFIX + "[\\x00-\\x20]*";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.643 -0400", hash_original_field = "22D8268CA759FF4FF4D7B64AE265940B", hash_generated_field = "29E7F631EB23E516CC95B6D619BFEBAB")

    private static Pattern PATTERN = Pattern.compile(HEX_PATTERN);
}

