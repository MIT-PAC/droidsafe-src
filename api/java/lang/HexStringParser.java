package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class HexStringParser {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.852 -0400", hash_original_field = "94B91A0CFAEF3637DD641B0B0FB4F9B1", hash_generated_field = "3D1EE3F91B74E8DB430F2C1AC83A33D3")

    private int EXPONENT_WIDTH;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.852 -0400", hash_original_field = "60EFD0ED4D45F4B4A666A4093D94345D", hash_generated_field = "B9594B2F4506B67397EA5D3B03F60E18")

    private int MANTISSA_WIDTH;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.852 -0400", hash_original_field = "E143E81117216A0597A0740D9BB6D6DE", hash_generated_field = "C481FEDF39B196EABE033BD5CF17A7CB")

    private long EXPONENT_BASE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.853 -0400", hash_original_field = "67CA7FFB906FEBAE77BA4FFA7EC617A7", hash_generated_field = "C18CFDC021CBD7ABEB40DBD973A0ECFF")

    private long MAX_EXPONENT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.853 -0400", hash_original_field = "47C12D34BCFE98F694C58213C9C7B58F", hash_generated_field = "872FB1713A6708D4E85FF0ED4DC8BA7A")

    private long MIN_EXPONENT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.853 -0400", hash_original_field = "8EFF407AD7EEFB61C410B09DF698A9D4", hash_generated_field = "8F4140030FA67A2AE931BFB5AC88AE5E")

    private long MANTISSA_MASK;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.853 -0400", hash_original_field = "04B29480233F4DEF5C875875B6BDC3B1", hash_generated_field = "676D5001C1F011FD0B5A42C3B42410B6")

    private long sign;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.853 -0400", hash_original_field = "FACD4BC86B7F12740C83BCAA4E75AE0A", hash_generated_field = "DFBAA63A672635AB7C1CDDF13CEC1972")

    private long exponent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.853 -0400", hash_original_field = "8D53751FB2F972417C22F50994C3CB8B", hash_generated_field = "A592FD1FA81B363A971ABDB296D5BCFC")

    private long mantissa;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.854 -0400", hash_original_field = "2C740FBDD9C6ADC2AE67719BEED45845", hash_generated_field = "EDC092F9A3603100C3E4D1F89B0BAF46")

    private String abandonedNumber = "";
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.855 -0400", hash_original_method = "0F94CFCCDCBAD4C71218B93664CFA571", hash_generated_method = "FAB0E994F336D410190943BCA78F23A8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.857 -0400", hash_original_method = "596249BB373F56930CF8BA31CC9F5A97", hash_generated_method = "AD5E905A4419A91D3C963F02233F2E86")
    private long parse(String hexString, boolean isDouble) {
        addTaint(isDouble);
        addTaint(hexString.getTaint());
        Matcher matcher = PATTERN.matcher(hexString);
    if(!matcher.matches())        
        {
            NumberFormatException var9E6F64F797855B33ACF21BC0B16057D0_875811741 = new NumberFormatException("Invalid hex " + (isDouble ? "double" : "float")+ ":" +
                    hexString);
            var9E6F64F797855B33ACF21BC0B16057D0_875811741.addTaint(taint);
            throw var9E6F64F797855B33ACF21BC0B16057D0_875811741;
        } //End block
        String signStr = matcher.group(1);
        String significantStr = matcher.group(2);
        String exponentStr = matcher.group(3);
        parseHexSign(signStr);
        parseExponent(exponentStr);
        parseMantissa(significantStr);
        sign <<= (MANTISSA_WIDTH + EXPONENT_WIDTH);
        exponent <<= MANTISSA_WIDTH;
        long var8A0BFB77CF9220716E634FC53CAE9C50_2011777843 = (sign | exponent | mantissa);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_340576940 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_340576940;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.857 -0400", hash_original_method = "974D688FE86E3244D16C6508E4669FC6", hash_generated_method = "13BFEC942BAEF96FE6E364B15622A4E9")
    private void parseHexSign(String signStr) {
        this.sign = signStr.equals("-") ? 1 : 0;
        // ---------- Original Method ----------
        //this.sign = signStr.equals("-") ? 1 : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.858 -0400", hash_original_method = "F54ED53D7D015179F6121F71E1763DC9", hash_generated_method = "687BB5993F994A771E1EE49922F291B5")
    private void parseExponent(String exponentStr) {
        char leadingChar = exponentStr.charAt(0);
        int expSign = (leadingChar == '-' ? -1 : 1);
    if(!Character.isDigit(leadingChar))        
        {
            exponentStr = exponentStr.substring(1);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.860 -0400", hash_original_method = "661AC685F2EB81E51AC0AC93731FE290", hash_generated_method = "494D9E2219A5FCF5279A3BB5E5CD4B13")
    private void parseMantissa(String significantStr) {
        addTaint(significantStr.getTaint());
        String[] strings = significantStr.split("\\.");
        String strIntegerPart = strings[0];
        String strDecimalPart = strings.length > 1 ? strings[1] : "";
        String significand = getNormalizedSignificand(strIntegerPart,strDecimalPart);
    if(significand.equals("0"))        
        {
            setZero();
            return;
        } //End block
        int offset = getOffset(strIntegerPart, strDecimalPart);
        checkedAddExponent(offset);
    if(exponent >= MAX_EXPONENT)        
        {
            setInfinite();
            return;
        } //End block
    if(exponent <= MIN_EXPONENT)        
        {
            setZero();
            return;
        } //End block
    if(significand.length() > MAX_SIGNIFICANT_LENGTH)        
        {
            abandonedNumber = significand.substring(MAX_SIGNIFICANT_LENGTH);
            significand = significand.substring(0, MAX_SIGNIFICANT_LENGTH);
        } //End block
        mantissa = Long.parseLong(significand, HEX_RADIX);
    if(exponent >= 1)        
        {
            processNormalNumber();
        } //End block
        else
        {
            processSubNormalNumber();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.860 -0400", hash_original_method = "E5B2CE5158E0191EB1B4342B503B503C", hash_generated_method = "79359CB12970F2F3F56D34C9271ED5F0")
    private void setInfinite() {
        exponent = MAX_EXPONENT;
        mantissa = 0;
        // ---------- Original Method ----------
        //exponent = MAX_EXPONENT;
        //mantissa = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.861 -0400", hash_original_method = "B9AC8BA0C31319FE099B6A6C8A6F4144", hash_generated_method = "243374FBE0863DE96BE7168DB3C6FD32")
    private void setZero() {
        exponent = 0;
        mantissa = 0;
        // ---------- Original Method ----------
        //exponent = 0;
        //mantissa = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.862 -0400", hash_original_method = "C2A5C13C47CD41059D53CDBF46698CF7", hash_generated_method = "29DEE53CB7C05699741B7C9542535030")
    private void checkedAddExponent(long offset) {
        addTaint(offset);
        long result = exponent + offset;
        int expSign = Long.signum(exponent);
    if(expSign * Long.signum(offset) > 0 && expSign * Long.signum(result) < 0)        
        {
            exponent = expSign * Long.MAX_VALUE;
        } //End block
        else
        {
            exponent = result;
        } //End block
        // ---------- Original Method ----------
        //long result = exponent + offset;
        //int expSign = Long.signum(exponent);
        //if (expSign * Long.signum(offset) > 0 && expSign * Long.signum(result) < 0) {
            //exponent = expSign * Long.MAX_VALUE;
        //} else {
            //exponent = result;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.863 -0400", hash_original_method = "9CA1C86CDD20337336DE019762D1A2F8", hash_generated_method = "B10F16C2067DCAF25262DC6DD14D5AE6")
    private void processNormalNumber() {
        int desiredWidth = MANTISSA_WIDTH + 2;
        fitMantissaInDesiredWidth(desiredWidth);
        round();
        mantissa = mantissa & MANTISSA_MASK;
        // ---------- Original Method ----------
        //int desiredWidth = MANTISSA_WIDTH + 2;
        //fitMantissaInDesiredWidth(desiredWidth);
        //round();
        //mantissa = mantissa & MANTISSA_MASK;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.864 -0400", hash_original_method = "C617BA86E331FAE3F2D53918109E2E13", hash_generated_method = "22ECB6F94BDF27D309EAC69063F53844")
    private void processSubNormalNumber() {
        int desiredWidth = MANTISSA_WIDTH + 1;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.864 -0400", hash_original_method = "330648F0D53116AAA430ECFB8E97D2A6", hash_generated_method = "D0FDCACB458D0A3BF4184F253BE06D53")
    private void fitMantissaInDesiredWidth(int desiredWidth) {
        int bitLength = countBitsLength(mantissa);
    if(bitLength > desiredWidth)        
        {
            discardTrailingBits(bitLength - desiredWidth);
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.865 -0400", hash_original_method = "40C79332802B26AD9210D4E26ECE1852", hash_generated_method = "AD3A7BE7F7E60A8AA641A809F1477C0B")
    private void discardTrailingBits(long num) {
        long mask = ~(-1L << num);
        abandonedNumber += (mantissa & mask);
        mantissa >>= num;
        // ---------- Original Method ----------
        //long mask = ~(-1L << num);
        //abandonedNumber += (mantissa & mask);
        //mantissa >>= num;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.866 -0400", hash_original_method = "BE1368BC0340B1F1D2FFF04FBC3A9E13", hash_generated_method = "3EB605AE18A4F8B425B8E1B5B168B3CB")
    private void round() {
        String result = abandonedNumber.replaceAll("0+", "");
        boolean moreThanZero = (result.length() > 0 ? true : false);
        int lastDiscardedBit = (int) (mantissa & 1L);
        mantissa >>= 1;
        int tailBitInMantissa = (int) (mantissa & 1L);
    if(lastDiscardedBit == 1 && (moreThanZero || tailBitInMantissa == 1))        
        {
            int oldLength = countBitsLength(mantissa);
            mantissa += 1L;
            int newLength = countBitsLength(mantissa);
    if(oldLength >= MANTISSA_WIDTH && newLength > oldLength)            
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.867 -0400", hash_original_method = "D2C62D141CD2F22FD7386D5422E8C46E", hash_generated_method = "435AF017D6026E5B76284363035EA0FA")
    private String getNormalizedSignificand(String strIntegerPart, String strDecimalPart) {
        addTaint(strDecimalPart.getTaint());
        addTaint(strIntegerPart.getTaint());
        String significand = strIntegerPart + strDecimalPart;
        significand = significand.replaceFirst("^0+", "");
    if(significand.length() == 0)        
        {
            significand = "0";
        } //End block
String var41AB4756B20347E39831A25B31A6008E_532413534 =         significand;
        var41AB4756B20347E39831A25B31A6008E_532413534.addTaint(taint);
        return var41AB4756B20347E39831A25B31A6008E_532413534;
        // ---------- Original Method ----------
        //String significand = strIntegerPart + strDecimalPart;
        //significand = significand.replaceFirst("^0+", "");
        //if (significand.length() == 0) {
            //significand = "0";
        //}
        //return significand;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.868 -0400", hash_original_method = "08762480F158FA197B11D4959C7DC334", hash_generated_method = "30FBC7A03E5A4AA5DD2A95A2B2A7D1C2")
    private int getOffset(String strIntegerPart, String strDecimalPart) {
        addTaint(strDecimalPart.getTaint());
        addTaint(strIntegerPart.getTaint());
        strIntegerPart = strIntegerPart.replaceFirst("^0+", "");
    if(strIntegerPart.length() != 0)        
        {
            String leadingNumber = strIntegerPart.substring(0, 1);
            int varA42771118F02D9AF1DEEEBB758B511E8_1456108447 = ((strIntegerPart.length() - 1) * 4 + countBitsLength(Long.parseLong(leadingNumber,HEX_RADIX)) - 1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_999562415 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_999562415;
        } //End block
        int i;
for(i = 0;i < strDecimalPart.length() && strDecimalPart.charAt(i) == '0';i++)
        ;
    if(i == strDecimalPart.length())        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1213380945 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1072364479 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1072364479;
        } //End block
        String leadingNumber = strDecimalPart.substring(i,i + 1);
        int var353BD6777A0DA09D9454133997E5FB64_861808010 = ((-i - 1) * 4 + countBitsLength(Long.parseLong(leadingNumber, HEX_RADIX)) - 1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1168873091 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1168873091;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.869 -0400", hash_original_method = "20FEBC548021CA37C4B86DB718571102", hash_generated_method = "384A7D35849E8EEA760DB574CA524257")
    private int countBitsLength(long value) {
        addTaint(value);
        int leadingZeros = Long.numberOfLeadingZeros(value);
        int varFB000237B069C89ADFA459681B8133E0_1279242515 = (Long.SIZE - leadingZeros);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1337475178 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1337475178;
        // ---------- Original Method ----------
        //int leadingZeros = Long.numberOfLeadingZeros(value);
        //return Long.SIZE - leadingZeros;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.869 -0400", hash_original_field = "E95BD279C9DF5452687674F1091E87A7", hash_generated_field = "D1155B269CDBACFDC3F3E9B06D7DE4A2")

    private static final int DOUBLE_EXPONENT_WIDTH = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.869 -0400", hash_original_field = "25BB785398DA769218D55CE71FEEBD70", hash_generated_field = "31882514B9F507357D29F8936E3263A5")

    private static final int DOUBLE_MANTISSA_WIDTH = 52;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.870 -0400", hash_original_field = "26F5EDC28A664C421B11FCE3033BFC3E", hash_generated_field = "CF4B4FF0FB0279FDF9CF8A86100ED45B")

    private static final int FLOAT_EXPONENT_WIDTH = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.870 -0400", hash_original_field = "B00C042C0AE59B835AB83607B098998B", hash_generated_field = "029320CB706024D91B89140CF93136C8")

    private static final int FLOAT_MANTISSA_WIDTH = 23;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.870 -0400", hash_original_field = "5603A6B10AC8627DB5145C05B3D58A33", hash_generated_field = "2C7DE9BC6090A7DECB1198112765A354")

    private static final int HEX_RADIX = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.870 -0400", hash_original_field = "5632A5274F3D356438943DCE4665D451", hash_generated_field = "5835216A7B337CFF7852890DA661381F")

    private static final int MAX_SIGNIFICANT_LENGTH = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.870 -0400", hash_original_field = "2B0526347792B208CA1A778CA7BE472B", hash_generated_field = "B767BEB049546541E0E508E050B00854")

    private static final String HEX_SIGNIFICANT = "0[xX](\\p{XDigit}+\\.?|\\p{XDigit}*\\.\\p{XDigit}+)";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.870 -0400", hash_original_field = "5E4989FA31617E624B47332BC4FEAD8F", hash_generated_field = "24520C6267DD97CD14C6BD15E0C225E5")

    private static final String BINARY_EXPONENT = "[pP]([+-]?\\d+)";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.871 -0400", hash_original_field = "9DF37BC726928BEF43F26853D07A2376", hash_generated_field = "56DFBB2C307D6BD6F06ABC2A92C6E120")

    private static final String FLOAT_TYPE_SUFFIX = "[fFdD]?";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.871 -0400", hash_original_field = "DCEAA83FB368B63F1A6A0A8ECA956C03", hash_generated_field = "10587FF47EEDFE0BD60A26FD884BF7D2")

    private static final String HEX_PATTERN = "[\\x00-\\x20]*([+-]?)" + HEX_SIGNIFICANT
            + BINARY_EXPONENT + FLOAT_TYPE_SUFFIX + "[\\x00-\\x20]*";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.871 -0400", hash_original_field = "22D8268CA759FF4FF4D7B64AE265940B", hash_generated_field = "751B566999B7757AAA6980E384CA6585")

    private static final Pattern PATTERN = Pattern.compile(HEX_PATTERN);
}

