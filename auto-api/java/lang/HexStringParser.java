package java.lang;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class HexStringParser {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.061 -0400", hash_original_field = "94B91A0CFAEF3637DD641B0B0FB4F9B1", hash_generated_field = "3D1EE3F91B74E8DB430F2C1AC83A33D3")

    private int EXPONENT_WIDTH;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.061 -0400", hash_original_field = "60EFD0ED4D45F4B4A666A4093D94345D", hash_generated_field = "B9594B2F4506B67397EA5D3B03F60E18")

    private int MANTISSA_WIDTH;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.061 -0400", hash_original_field = "E143E81117216A0597A0740D9BB6D6DE", hash_generated_field = "C481FEDF39B196EABE033BD5CF17A7CB")

    private long EXPONENT_BASE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.061 -0400", hash_original_field = "67CA7FFB906FEBAE77BA4FFA7EC617A7", hash_generated_field = "C18CFDC021CBD7ABEB40DBD973A0ECFF")

    private long MAX_EXPONENT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.061 -0400", hash_original_field = "47C12D34BCFE98F694C58213C9C7B58F", hash_generated_field = "872FB1713A6708D4E85FF0ED4DC8BA7A")

    private long MIN_EXPONENT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.061 -0400", hash_original_field = "8EFF407AD7EEFB61C410B09DF698A9D4", hash_generated_field = "8F4140030FA67A2AE931BFB5AC88AE5E")

    private long MANTISSA_MASK;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.061 -0400", hash_original_field = "04B29480233F4DEF5C875875B6BDC3B1", hash_generated_field = "676D5001C1F011FD0B5A42C3B42410B6")

    private long sign;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.061 -0400", hash_original_field = "FACD4BC86B7F12740C83BCAA4E75AE0A", hash_generated_field = "DFBAA63A672635AB7C1CDDF13CEC1972")

    private long exponent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.061 -0400", hash_original_field = "8D53751FB2F972417C22F50994C3CB8B", hash_generated_field = "A592FD1FA81B363A971ABDB296D5BCFC")

    private long mantissa;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.061 -0400", hash_original_field = "2C740FBDD9C6ADC2AE67719BEED45845", hash_generated_field = "EDC092F9A3603100C3E4D1F89B0BAF46")

    private String abandonedNumber = "";
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.062 -0400", hash_original_method = "0F94CFCCDCBAD4C71218B93664CFA571", hash_generated_method = "FAB0E994F336D410190943BCA78F23A8")
    public  HexStringParser(int exponentWidth, int mantissaWidth) {
        this.EXPONENT_WIDTH = exponentWidth;
        this.MANTISSA_WIDTH = mantissaWidth;
        this.EXPONENT_BASE = ~(-1L << (exponentWidth - 1));
        this.MAX_EXPONENT = ~(-1L << exponentWidth);
        this.MIN_EXPONENT = -(MANTISSA_WIDTH + 1);
        this.MANTISSA_MASK = ~(-1L << mantissaWidth);
        
        
        
        
        
        
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.063 -0400", hash_original_method = "596249BB373F56930CF8BA31CC9F5A97", hash_generated_method = "94C460D2306223D8FE69F4D730F2098A")
    private long parse(String hexString, boolean isDouble) {
        Matcher matcher = PATTERN.matcher(hexString);
        {
            boolean var29857123035FF7A64A8598EB68050605_915105131 = (!matcher.matches());
            {
                if (DroidSafeAndroidRuntime.control) throw new NumberFormatException("Invalid hex " + (isDouble ? "double" : "float")+ ":" +
                    hexString);
            } 
        } 
        String signStr = matcher.group(1);
        String significantStr = matcher.group(2);
        String exponentStr = matcher.group(3);
        parseHexSign(signStr);
        parseExponent(exponentStr);
        parseMantissa(significantStr);
        sign <<= (MANTISSA_WIDTH + EXPONENT_WIDTH);
        exponent <<= MANTISSA_WIDTH;
        addTaint(hexString.getTaint());
        addTaint(isDouble);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_347173513 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_347173513;
        
        
        
            
                    
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.063 -0400", hash_original_method = "974D688FE86E3244D16C6508E4669FC6", hash_generated_method = "13BFEC942BAEF96FE6E364B15622A4E9")
    private void parseHexSign(String signStr) {
        this.sign = signStr.equals("-") ? 1 : 0;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.063 -0400", hash_original_method = "F54ED53D7D015179F6121F71E1763DC9", hash_generated_method = "12F59FEC1FB88FC6F5CD350947E804E9")
    private void parseExponent(String exponentStr) {
        char leadingChar = exponentStr.charAt(0);
        int expSign = (leadingChar == '-' ? -1 : 1);
        {
            boolean var12918441ABCBAE31E5F02154106075A8_1872030426 = (!Character.isDigit(leadingChar));
            {
                exponentStr = exponentStr.substring(1);
            } 
        } 
        try 
        {
            exponent = expSign * Long.parseLong(exponentStr);
            checkedAddExponent(EXPONENT_BASE);
        } 
        catch (NumberFormatException e)
        {
            exponent = expSign * Long.MAX_VALUE;
        } 
        
        
        
        
            
        
        
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.064 -0400", hash_original_method = "661AC685F2EB81E51AC0AC93731FE290", hash_generated_method = "CD224B01C44994FF4210112199B1AC9E")
    private void parseMantissa(String significantStr) {
        String[] strings = significantStr.split("\\.");
        String strIntegerPart = strings[0];
        String strDecimalPart;
        strDecimalPart = strings[1];
        strDecimalPart = "";
        String significand = getNormalizedSignificand(strIntegerPart,strDecimalPart);
        {
            boolean var33E818A7CFC583690A348CAC6377C380_1386175585 = (significand.equals("0"));
            {
                setZero();
            } 
        } 
        int offset = getOffset(strIntegerPart, strDecimalPart);
        checkedAddExponent(offset);
        {
            setInfinite();
        } 
        {
            setZero();
        } 
        {
            boolean varE202BC62D51C45F8F24333A3E462DF98_669453113 = (significand.length() > MAX_SIGNIFICANT_LENGTH);
            {
                abandonedNumber = significand.substring(MAX_SIGNIFICANT_LENGTH);
                significand = significand.substring(0, MAX_SIGNIFICANT_LENGTH);
            } 
        } 
        mantissa = Long.parseLong(significand, HEX_RADIX);
        {
            processNormalNumber();
        } 
        {
            processSubNormalNumber();
        } 
        addTaint(significantStr.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.065 -0400", hash_original_method = "E5B2CE5158E0191EB1B4342B503B503C", hash_generated_method = "79359CB12970F2F3F56D34C9271ED5F0")
    private void setInfinite() {
        exponent = MAX_EXPONENT;
        mantissa = 0;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.065 -0400", hash_original_method = "B9AC8BA0C31319FE099B6A6C8A6F4144", hash_generated_method = "243374FBE0863DE96BE7168DB3C6FD32")
    private void setZero() {
        exponent = 0;
        mantissa = 0;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.066 -0400", hash_original_method = "C2A5C13C47CD41059D53CDBF46698CF7", hash_generated_method = "DE47170A699CD2453075BA131AE5652D")
    private void checkedAddExponent(long offset) {
        long result = exponent + offset;
        int expSign = Long.signum(exponent);
        {
            boolean var4023E4EFC04C969892416657FDC87896_681688681 = (expSign * Long.signum(offset) > 0 && expSign * Long.signum(result) < 0);
            {
                exponent = expSign * Long.MAX_VALUE;
            } 
            {
                exponent = result;
            } 
        } 
        addTaint(offset);
        
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.066 -0400", hash_original_method = "9CA1C86CDD20337336DE019762D1A2F8", hash_generated_method = "B10F16C2067DCAF25262DC6DD14D5AE6")
    private void processNormalNumber() {
        int desiredWidth = MANTISSA_WIDTH + 2;
        fitMantissaInDesiredWidth(desiredWidth);
        round();
        mantissa = mantissa & MANTISSA_MASK;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.067 -0400", hash_original_method = "C617BA86E331FAE3F2D53918109E2E13", hash_generated_method = "22ECB6F94BDF27D309EAC69063F53844")
    private void processSubNormalNumber() {
        int desiredWidth = MANTISSA_WIDTH + 1;
        desiredWidth += (int)exponent;
        exponent = 0;
        fitMantissaInDesiredWidth(desiredWidth);
        round();
        mantissa = mantissa & MANTISSA_MASK;
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.067 -0400", hash_original_method = "330648F0D53116AAA430ECFB8E97D2A6", hash_generated_method = "8764AA97733F86B31674E5D529DE3606")
    private void fitMantissaInDesiredWidth(int desiredWidth) {
        int bitLength = countBitsLength(mantissa);
        {
            discardTrailingBits(bitLength - desiredWidth);
        } 
        {
            mantissa <<= (desiredWidth - bitLength);
        } 
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.067 -0400", hash_original_method = "40C79332802B26AD9210D4E26ECE1852", hash_generated_method = "AD3A7BE7F7E60A8AA641A809F1477C0B")
    private void discardTrailingBits(long num) {
        long mask = ~(-1L << num);
        abandonedNumber += (mantissa & mask);
        mantissa >>= num;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.068 -0400", hash_original_method = "BE1368BC0340B1F1D2FFF04FBC3A9E13", hash_generated_method = "0EB829377CC7ED7DA21C2111FB23A650")
    private void round() {
        String result = abandonedNumber.replaceAll("0+", "");
        boolean moreThanZero = (result.length() > 0 ? true : false);
        int lastDiscardedBit = (int) (mantissa & 1L);
        mantissa >>= 1;
        int tailBitInMantissa = (int) (mantissa & 1L);
        {
            int oldLength = countBitsLength(mantissa);
            mantissa += 1L;
            int newLength = countBitsLength(mantissa);
            {
                checkedAddExponent(1);
            } 
        } 
        
        
        
        
        
        
        
            
            
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.068 -0400", hash_original_method = "D2C62D141CD2F22FD7386D5422E8C46E", hash_generated_method = "975C4F0FCB054BF23A568ED6C4FB7828")
    private String getNormalizedSignificand(String strIntegerPart, String strDecimalPart) {
        String varB4EAC82CA7396A68D541C85D26508E83_1893493678 = null; 
        String significand = strIntegerPart + strDecimalPart;
        significand = significand.replaceFirst("^0+", "");
        {
            boolean varCB56E8C1B765A44EE13A3876ED8AFD68_441282040 = (significand.length() == 0);
            {
                significand = "0";
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1893493678 = significand;
        addTaint(strIntegerPart.getTaint());
        addTaint(strDecimalPart.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1893493678.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1893493678;
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.070 -0400", hash_original_method = "08762480F158FA197B11D4959C7DC334", hash_generated_method = "588C2F9DBD91193DA14FDB877FC3D1BE")
    private int getOffset(String strIntegerPart, String strDecimalPart) {
        strIntegerPart = strIntegerPart.replaceFirst("^0+", "");
        {
            boolean varE136E385037462C3E72E57ECC517FB4A_1645091489 = (strIntegerPart.length() != 0);
            {
                String leadingNumber = strIntegerPart.substring(0, 1);
                int var0F5F88D92968EEF0EEA83651B2C4EAF9_1725695434 = ((strIntegerPart.length() - 1) * 4 + countBitsLength(Long.parseLong(leadingNumber,HEX_RADIX)) - 1);
            } 
        } 
        int i;
        {
            i = 0;
            boolean varE884A9B658B796521F6D7CFBE1EED16D_1993556708 = (i < strDecimalPart.length() && strDecimalPart.charAt(i) == '0');
            ;
        } 
        {
            boolean varEFA2529895BBE26403532BB3B6E39EFC_1558571083 = (i == strDecimalPart.length());
        } 
        String leadingNumber = strDecimalPart.substring(i,i + 1);
        int varF22829AC0DE8799BD6C5C24AE662D7AF_1245233229 = ((-i - 1) * 4 + countBitsLength(Long.parseLong(leadingNumber, HEX_RADIX)) - 1);
        addTaint(strIntegerPart.getTaint());
        addTaint(strDecimalPart.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2106933189 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2106933189;
        
        
        
            
            
        
        
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.070 -0400", hash_original_method = "20FEBC548021CA37C4B86DB718571102", hash_generated_method = "70C99B3D9E1AAC91AD9387D20D0A1E11")
    private int countBitsLength(long value) {
        int leadingZeros = Long.numberOfLeadingZeros(value);
        addTaint(value);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_882997836 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_882997836;
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.070 -0400", hash_original_field = "E95BD279C9DF5452687674F1091E87A7", hash_generated_field = "D1155B269CDBACFDC3F3E9B06D7DE4A2")

    private static final int DOUBLE_EXPONENT_WIDTH = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.070 -0400", hash_original_field = "25BB785398DA769218D55CE71FEEBD70", hash_generated_field = "31882514B9F507357D29F8936E3263A5")

    private static final int DOUBLE_MANTISSA_WIDTH = 52;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.070 -0400", hash_original_field = "26F5EDC28A664C421B11FCE3033BFC3E", hash_generated_field = "CF4B4FF0FB0279FDF9CF8A86100ED45B")

    private static final int FLOAT_EXPONENT_WIDTH = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.070 -0400", hash_original_field = "B00C042C0AE59B835AB83607B098998B", hash_generated_field = "029320CB706024D91B89140CF93136C8")

    private static final int FLOAT_MANTISSA_WIDTH = 23;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.070 -0400", hash_original_field = "5603A6B10AC8627DB5145C05B3D58A33", hash_generated_field = "2C7DE9BC6090A7DECB1198112765A354")

    private static final int HEX_RADIX = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.070 -0400", hash_original_field = "5632A5274F3D356438943DCE4665D451", hash_generated_field = "5835216A7B337CFF7852890DA661381F")

    private static final int MAX_SIGNIFICANT_LENGTH = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.070 -0400", hash_original_field = "2B0526347792B208CA1A778CA7BE472B", hash_generated_field = "B767BEB049546541E0E508E050B00854")

    private static final String HEX_SIGNIFICANT = "0[xX](\\p{XDigit}+\\.?|\\p{XDigit}*\\.\\p{XDigit}+)";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.070 -0400", hash_original_field = "5E4989FA31617E624B47332BC4FEAD8F", hash_generated_field = "24520C6267DD97CD14C6BD15E0C225E5")

    private static final String BINARY_EXPONENT = "[pP]([+-]?\\d+)";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.070 -0400", hash_original_field = "9DF37BC726928BEF43F26853D07A2376", hash_generated_field = "56DFBB2C307D6BD6F06ABC2A92C6E120")

    private static final String FLOAT_TYPE_SUFFIX = "[fFdD]?";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.070 -0400", hash_original_field = "DCEAA83FB368B63F1A6A0A8ECA956C03", hash_generated_field = "10587FF47EEDFE0BD60A26FD884BF7D2")

    private static final String HEX_PATTERN = "[\\x00-\\x20]*([+-]?)" + HEX_SIGNIFICANT
            + BINARY_EXPONENT + FLOAT_TYPE_SUFFIX + "[\\x00-\\x20]*";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.070 -0400", hash_original_field = "22D8268CA759FF4FF4D7B64AE265940B", hash_generated_field = "751B566999B7757AAA6980E384CA6585")

    private static final Pattern PATTERN = Pattern.compile(HEX_PATTERN);
}

