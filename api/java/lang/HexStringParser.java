package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;






final class HexStringParser {

    /*
     * Parses the hex string to a double number.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.670 -0500", hash_original_method = "7303956EBF011484C590040E5CCE18E3", hash_generated_method = "1CE1DE670B1018FCC97528F384B75A1B")
    public static double parseDouble(String hexString) {
        HexStringParser parser = new HexStringParser(DOUBLE_EXPONENT_WIDTH, DOUBLE_MANTISSA_WIDTH);
        long result = parser.parse(hexString, true);
        return Double.longBitsToDouble(result);
    }

    /*
     * Parses the hex string to a float number.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.671 -0500", hash_original_method = "BDFCF66879E1D3B3E569635C77B0BADA", hash_generated_method = "E6E3597AE10FE2E61F8BD136C07B0B4A")
    public static float parseFloat(String hexString) {
        HexStringParser parser = new HexStringParser(FLOAT_EXPONENT_WIDTH, FLOAT_MANTISSA_WIDTH);
        int result = (int) parser.parse(hexString, false);
        return Float.intBitsToFloat(result);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.649 -0500", hash_original_field = "7D9EF8DE52CA2BBB43B5979AA63BA45B", hash_generated_field = "D1155B269CDBACFDC3F3E9B06D7DE4A2")


    private static final int DOUBLE_EXPONENT_WIDTH = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.651 -0500", hash_original_field = "ED98BB921C6D7467B2123112CC9C6C75", hash_generated_field = "31882514B9F507357D29F8936E3263A5")


    private static final int DOUBLE_MANTISSA_WIDTH = 52;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.652 -0500", hash_original_field = "59E3D1F50B9C879C9FA3E66F4E982380", hash_generated_field = "CF4B4FF0FB0279FDF9CF8A86100ED45B")


    private static final int FLOAT_EXPONENT_WIDTH = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.653 -0500", hash_original_field = "B6E24ADF8EDDF380D474AE461B92CDD6", hash_generated_field = "029320CB706024D91B89140CF93136C8")


    private static final int FLOAT_MANTISSA_WIDTH = 23;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.654 -0500", hash_original_field = "07B2D8584EF04E2B99D2814FCDE7787C", hash_generated_field = "2C7DE9BC6090A7DECB1198112765A354")


    private static final int HEX_RADIX = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.655 -0500", hash_original_field = "E86E1BDCD048C17FF7020D34FE8D0805", hash_generated_field = "5835216A7B337CFF7852890DA661381F")


    private static final int MAX_SIGNIFICANT_LENGTH = 15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.656 -0500", hash_original_field = "A11BCE31042C290BC616C80076AEC254", hash_generated_field = "B767BEB049546541E0E508E050B00854")


    private static final String HEX_SIGNIFICANT = "0[xX](\\p{XDigit}+\\.?|\\p{XDigit}*\\.\\p{XDigit}+)";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.657 -0500", hash_original_field = "27FBEE257A72FBF25E12FEB24DC0C1E2", hash_generated_field = "24520C6267DD97CD14C6BD15E0C225E5")


    private static final String BINARY_EXPONENT = "[pP]([+-]?\\d+)";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.658 -0500", hash_original_field = "CD7D897ED67AE58DD8F6064274A9AA16", hash_generated_field = "56DFBB2C307D6BD6F06ABC2A92C6E120")


    private static final String FLOAT_TYPE_SUFFIX = "[fFdD]?";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.659 -0500", hash_original_field = "DAAB9DE20DE1C396D6701C04AF6FF6A9", hash_generated_field = "10587FF47EEDFE0BD60A26FD884BF7D2")


    private static final String HEX_PATTERN = "[\\x00-\\x20]*([+-]?)" + HEX_SIGNIFICANT
            + BINARY_EXPONENT + FLOAT_TYPE_SUFFIX + "[\\x00-\\x20]*";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.660 -0500", hash_original_field = "9BDC9F6AC8B3C88FCF4CCDA41DE42AEA", hash_generated_field = "751B566999B7757AAA6980E384CA6585")


    private static final Pattern PATTERN = Pattern.compile(HEX_PATTERN);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.660 -0500", hash_original_field = "375B8EF424C62E63F30CD4F4A498C17E", hash_generated_field = "3D1EE3F91B74E8DB430F2C1AC83A33D3")


    private  int EXPONENT_WIDTH;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.661 -0500", hash_original_field = "3B37D02678196B5A3074104DC44F226F", hash_generated_field = "B9594B2F4506B67397EA5D3B03F60E18")


    private  int MANTISSA_WIDTH;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.662 -0500", hash_original_field = "268AC93C7141AC5612E6366121709DC1", hash_generated_field = "C481FEDF39B196EABE033BD5CF17A7CB")


    private  long EXPONENT_BASE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.663 -0500", hash_original_field = "7FC26B36DB57F8E20FCF964487251636", hash_generated_field = "C18CFDC021CBD7ABEB40DBD973A0ECFF")


    private  long MAX_EXPONENT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.664 -0500", hash_original_field = "DED1C915F9F0EF55D32DA7E1A48AB6BB", hash_generated_field = "872FB1713A6708D4E85FF0ED4DC8BA7A")


    private  long MIN_EXPONENT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.665 -0500", hash_original_field = "7E57C979411EB7FC094689D65C97C03E", hash_generated_field = "8F4140030FA67A2AE931BFB5AC88AE5E")


    private  long MANTISSA_MASK;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.666 -0500", hash_original_field = "09BF80B82B2E76389991270A93A03C74", hash_generated_field = "676D5001C1F011FD0B5A42C3B42410B6")


    private long sign;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.666 -0500", hash_original_field = "989D2F7FDAA75672DCFF9F1945D9DA4C", hash_generated_field = "DFBAA63A672635AB7C1CDDF13CEC1972")


    private long exponent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.667 -0500", hash_original_field = "24D6828452654A8C9BF4BDE687C67E23", hash_generated_field = "A592FD1FA81B363A971ABDB296D5BCFC")


    private long mantissa;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.668 -0500", hash_original_field = "A2C7A586C6ACB704E813E098A0E6F18C", hash_generated_field = "EDC092F9A3603100C3E4D1F89B0BAF46")


    private String abandonedNumber="";

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.669 -0500", hash_original_method = "0F94CFCCDCBAD4C71218B93664CFA571", hash_generated_method = "3CE32692D048C03045C91920A5AA1922")
    public HexStringParser(int exponentWidth, int mantissaWidth) {
        this.EXPONENT_WIDTH = exponentWidth;
        this.MANTISSA_WIDTH = mantissaWidth;

        this.EXPONENT_BASE = ~(-1L << (exponentWidth - 1));
        this.MAX_EXPONENT = ~(-1L << exponentWidth);
        this.MIN_EXPONENT = -(MANTISSA_WIDTH + 1);
        this.MANTISSA_MASK = ~(-1L << mantissaWidth);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.672 -0500", hash_original_method = "596249BB373F56930CF8BA31CC9F5A97", hash_generated_method = "63E2BB8AC97B10AD98A907D9FEE01CED")
    private long parse(String hexString, boolean isDouble) {
        Matcher matcher = PATTERN.matcher(hexString);
        if (!matcher.matches()) {
            throw new NumberFormatException("Invalid hex " + (isDouble ? "double" : "float")+ ":" +
                    hexString);
        }

        String signStr = matcher.group(1);
        String significantStr = matcher.group(2);
        String exponentStr = matcher.group(3);

        parseHexSign(signStr);
        parseExponent(exponentStr);
        parseMantissa(significantStr);

        sign <<= (MANTISSA_WIDTH + EXPONENT_WIDTH);
        exponent <<= MANTISSA_WIDTH;
        return sign | exponent | mantissa;
    }

    /*
     * Parses the sign field.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.673 -0500", hash_original_method = "974D688FE86E3244D16C6508E4669FC6", hash_generated_method = "6B03A34A5314161B1527AD34AC9ABD77")
    private void parseHexSign(String signStr) {
        this.sign = signStr.equals("-") ? 1 : 0;
    }

    /*
     * Parses the exponent field.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.674 -0500", hash_original_method = "F54ED53D7D015179F6121F71E1763DC9", hash_generated_method = "CA372BF68E74AF9DC52BE3CB9D7743B8")
    private void parseExponent(String exponentStr) {
        char leadingChar = exponentStr.charAt(0);
        int expSign = (leadingChar == '-' ? -1 : 1);
        if (!Character.isDigit(leadingChar)) {
            exponentStr = exponentStr.substring(1);
        }

        try {
            exponent = expSign * Long.parseLong(exponentStr);
            checkedAddExponent(EXPONENT_BASE);
        } catch (NumberFormatException e) {
            exponent = expSign * Long.MAX_VALUE;
        }
    }

    /*
     * Parses the mantissa field.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.675 -0500", hash_original_method = "661AC685F2EB81E51AC0AC93731FE290", hash_generated_method = "59366AD8B841C52436C4D332C70BF375")
    private void parseMantissa(String significantStr) {
        String[] strings = significantStr.split("\\.");
        String strIntegerPart = strings[0];
        String strDecimalPart = strings.length > 1 ? strings[1] : "";

        String significand = getNormalizedSignificand(strIntegerPart,strDecimalPart);
        if (significand.equals("0")) {
            setZero();
            return;
        }

        int offset = getOffset(strIntegerPart, strDecimalPart);
        checkedAddExponent(offset);

        if (exponent >= MAX_EXPONENT) {
            setInfinite();
            return;
        }

        if (exponent <= MIN_EXPONENT) {
            setZero();
            return;
        }

        if (significand.length() > MAX_SIGNIFICANT_LENGTH) {
            abandonedNumber = significand.substring(MAX_SIGNIFICANT_LENGTH);
            significand = significand.substring(0, MAX_SIGNIFICANT_LENGTH);
        }

        mantissa = Long.parseLong(significand, HEX_RADIX);

        if (exponent >= 1) {
            processNormalNumber();
        } else{
            processSubNormalNumber();
        }

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.676 -0500", hash_original_method = "E5B2CE5158E0191EB1B4342B503B503C", hash_generated_method = "976BB6C5CAD481AE09CE6CCFFC81A010")
    private void setInfinite() {
        exponent = MAX_EXPONENT;
        mantissa = 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.677 -0500", hash_original_method = "B9AC8BA0C31319FE099B6A6C8A6F4144", hash_generated_method = "5E165D072CB4564D3DD4EFF372D6845F")
    private void setZero() {
        exponent = 0;
        mantissa = 0;
    }

    /*
     * Sets the exponent variable to Long.MAX_VALUE or -Long.MAX_VALUE if
     * overflow or underflow happens.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.678 -0500", hash_original_method = "C2A5C13C47CD41059D53CDBF46698CF7", hash_generated_method = "885121F3160A256C33B26607B5203BF6")
    private void checkedAddExponent(long offset) {
        long result = exponent + offset;
        int expSign = Long.signum(exponent);
        if (expSign * Long.signum(offset) > 0 && expSign * Long.signum(result) < 0) {
            exponent = expSign * Long.MAX_VALUE;
        } else {
            exponent = result;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.679 -0500", hash_original_method = "9CA1C86CDD20337336DE019762D1A2F8", hash_generated_method = "4DBDE7DDC250FCEE57623D8174532582")
    private void processNormalNumber(){
        int desiredWidth = MANTISSA_WIDTH + 2;
        fitMantissaInDesiredWidth(desiredWidth);
        round();
        mantissa = mantissa & MANTISSA_MASK;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.680 -0500", hash_original_method = "C617BA86E331FAE3F2D53918109E2E13", hash_generated_method = "528912C877FE389DF7F62D7081ACDD62")
    private void processSubNormalNumber(){
        int desiredWidth = MANTISSA_WIDTH + 1;
        desiredWidth += (int)exponent;//lends bit from mantissa to exponent
        exponent = 0;
        fitMantissaInDesiredWidth(desiredWidth);
        round();
        mantissa = mantissa & MANTISSA_MASK;
    }

    /*
     * Adjusts the mantissa to desired width for further analysis.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.681 -0500", hash_original_method = "330648F0D53116AAA430ECFB8E97D2A6", hash_generated_method = "0534047768B02E4690A8966E76139901")
    private void fitMantissaInDesiredWidth(int desiredWidth){
        int bitLength = countBitsLength(mantissa);
        if (bitLength > desiredWidth) {
            discardTrailingBits(bitLength - desiredWidth);
        } else {
            mantissa <<= (desiredWidth - bitLength);
        }
    }

    /*
     * Stores the discarded bits to abandonedNumber.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.682 -0500", hash_original_method = "40C79332802B26AD9210D4E26ECE1852", hash_generated_method = "90E18BEAFCC8900A14F396EE9B0E0EBE")
    private void discardTrailingBits(long num) {
        long mask = ~(-1L << num);
        abandonedNumber += (mantissa & mask);
        mantissa >>= num;
    }

    /*
     * The value is rounded up or down to the nearest infinitely precise result.
     * If the value is exactly halfway between two infinitely precise results,
     * then it should be rounded up to the nearest infinitely precise even.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.683 -0500", hash_original_method = "BE1368BC0340B1F1D2FFF04FBC3A9E13", hash_generated_method = "692D349DE4EA6829166817861462EA9C")
    private void round() {
        String result = abandonedNumber.replaceAll("0+", "");
        boolean moreThanZero = (result.length() > 0 ? true : false);

        int lastDiscardedBit = (int) (mantissa & 1L);
        mantissa >>= 1;
        int tailBitInMantissa = (int) (mantissa & 1L);

        if (lastDiscardedBit == 1 && (moreThanZero || tailBitInMantissa == 1)) {
            int oldLength = countBitsLength(mantissa);
            mantissa += 1L;
            int newLength = countBitsLength(mantissa);

            //Rounds up to exponent when whole bits of mantissa are one-bits.
            if (oldLength >= MANTISSA_WIDTH && newLength > oldLength) {
                checkedAddExponent(1);
            }
        }
    }

    /*
     * Returns the normalized significand after removing the leading zeros.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.684 -0500", hash_original_method = "D2C62D141CD2F22FD7386D5422E8C46E", hash_generated_method = "90D91664A3B68F4A21813DEB48F41751")
    private String getNormalizedSignificand(String strIntegerPart, String strDecimalPart) {
        String significand = strIntegerPart + strDecimalPart;
        significand = significand.replaceFirst("^0+", "");
        if (significand.length() == 0) {
            significand = "0";
        }
        return significand;
    }

    /*
     * Calculates the offset between the normalized number and unnormalized
     * number. In a normalized representation, significand is represented by the
     * characters "0x1." followed by a lowercase hexadecimal representation of
     * the rest of the significand as a fraction.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.685 -0500", hash_original_method = "08762480F158FA197B11D4959C7DC334", hash_generated_method = "FB120997EECBE831E52B60C0713D226C")
    private int getOffset(String strIntegerPart, String strDecimalPart) {
        strIntegerPart = strIntegerPart.replaceFirst("^0+", "");

        //If the Integer part is a nonzero number.
        if (strIntegerPart.length() != 0) {
            String leadingNumber = strIntegerPart.substring(0, 1);
            return (strIntegerPart.length() - 1) * 4 + countBitsLength(Long.parseLong(leadingNumber,HEX_RADIX)) - 1;
        }

        //If the Integer part is a zero number.
        int i;
        for (i = 0; i < strDecimalPart.length() && strDecimalPart.charAt(i) == '0'; i++);
        if (i == strDecimalPart.length()) {
            return 0;
        }
        String leadingNumber=strDecimalPart.substring(i,i + 1);
        return (-i - 1) * 4 + countBitsLength(Long.parseLong(leadingNumber, HEX_RADIX)) - 1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.685 -0500", hash_original_method = "20FEBC548021CA37C4B86DB718571102", hash_generated_method = "90E8E25FF2838D42004C15B8F7D2C263")
    private int countBitsLength(long value) {
        int leadingZeros = Long.numberOfLeadingZeros(value);
        return Long.SIZE - leadingZeros;
    }
}

