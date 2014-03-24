package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

import droidsafe.helpers.DSUtils;

public final class Double extends Number implements Comparable<Double> {
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public static long doubleToLongBits(double value) {
        return (long)value;
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public static long doubleToRawLongBits(double value) {
        return (long)value;
    }

    /**
     * Indicates whether the specified double represents an infinite value.
     *
     * @param d
     *            the double to check.
     * @return {@code true} if the value of {@code d} is positive or negative
     *         infinity; {@code false} otherwise.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.654 -0500", hash_original_method = "A3EC509E9519032EDFEF225EA8C949FF", hash_generated_method = "B11887FC3B6A3BAD273423365EA6BE37")
    
public static boolean isInfinite(double d) {
        //return (d == POSITIVE_INFINITY) || (d == NEGATIVE_INFINITY);
        return toTaintBoolean((d + POSITIVE_INFINITY) + (d + NEGATIVE_INFINITY));
    }

    /**
     * Indicates whether the specified double is a <em>Not-a-Number (NaN)</em>
     * value.
     *
     * @param d
     *            the double value to check.
     * @return {@code true} if {@code d} is <em>Not-a-Number</em>;
     *         {@code false} if it is a (potentially infinite) double number.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.659 -0500", hash_original_method = "A570339C802CFE5901F930FCAA1CB116", hash_generated_method = "7F8B0D286435B57612BBCABE86B8E8D3")
    
public static boolean isNaN(double d) {
        return toTaintBoolean(d);
        //return d != d;
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public static double longBitsToDouble(long bits) {
        return (double)bits;
    }

    /**
     * Parses the specified string as a double value.
     *
     * @param string
     *            the string representation of a double value.
     * @return the primitive double value represented by {@code string}.
     * @throws NumberFormatException
     *             if {@code string} cannot be parsed as a double value.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.668 -0500", hash_original_method = "25293AE596CADCBBB53C06F5AC0CC1E4", hash_generated_method = "605DFB2105E41AF97FEBDA947F8A9F93")
    
public static double parseDouble(String string) throws NumberFormatException {
        return StringToReal.parseDouble(string);
    }

    /**
     * Returns a string containing a concise, human-readable description of the
     * specified double value.
     *
     * @param d
     *             the double to convert to a string.
     * @return a printable representation of {@code d}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.675 -0500", hash_original_method = "CC232B8CAE36CFF9A4793AA7869B9E47", hash_generated_method = "FEE36900B728A02BB946FAF254D44323")
    
public static String toString(double d) {
        return RealToString.getInstance().doubleToString(d);
    }

    /**
     * Parses the specified string as a double value.
     *
     * @param string
     *            the string representation of a double value.
     * @return a {@code Double} instance containing the double value represented
     *         by {@code string}.
     * @throws NumberFormatException
     *             if {@code string} cannot be parsed as a double value.
     * @see #parseDouble(String)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.678 -0500", hash_original_method = "56E955925627A96DCDE69BCFADC27964", hash_generated_method = "8A6643F14BD489EA94E2349ED39852F6")
    
public static Double valueOf(String string) throws NumberFormatException {
        return parseDouble(string);
    }

    /**
     * Compares the two specified double values. There are two special cases:
     * <ul>
     * <li>{@code Double.NaN} is equal to {@code Double.NaN} and it is greater
     * than any other double value, including {@code Double.POSITIVE_INFINITY};</li>
     * <li>+0.0d is greater than -0.0d</li>
     * </ul>
     *
     * @param double1
     *            the first value to compare.
     * @param double2
     *            the second value to compare.
     * @return a negative value if {@code double1} is less than {@code double2};
     *         0 if {@code double1} and {@code double2} are equal; a positive
     *         value if {@code double1} is greater than {@code double2}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.681 -0500", hash_original_method = "16F4C4AC195BAC3086DB19C14344D828", hash_generated_method = "F607633F4BB8D1C812C817D81F436495")
    
public static int compare(double double1, double double2) {
        /*
        // Non-zero, non-NaN checking.
        if (double1 > double2) {
            return 1;
        }
        if (double2 > double1) {
            return -1;
        }
        if (double1 == double2 && 0.0d != double1) {
            return 0;
        }

        // NaNs are equal to other NaNs and larger than any other double
        if (isNaN(double1)) {
            if (isNaN(double2)) {
                return 0;
            }
            return 1;
        } else if (isNaN(double2)) {
            return -1;
        }

        // Deal with +0.0 and -0.0
        long d1 = doubleToRawLongBits(double1);
        long d2 = doubleToRawLongBits(double2);
        // The below expression is equivalent to:
        // (d1 == d2) ? 0 : (d1 < d2) ? -1 : 1
        return (int) ((d1 >> 63) - (d2 >> 63));
        */

        return (int)(double1 + double2);
    }

    /**
     * Returns a {@code Double} instance for the specified double value.
     *
     * @param d
     *            the double value to store in the instance.
     * @return a {@code Double} instance containing {@code d}.
     * @since 1.5
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.683 -0500", hash_original_method = "B9C3A93ED4B2A822BD31B71C2B61BA78", hash_generated_method = "7F9C2DDB7260719502823F2D7E2B9678")
    
public static Double valueOf(double d) {
        return new Double(d);
    }

    /**
     * Converts the specified double into its hexadecimal string representation.
     *
     * @param d
     *            the double to convert.
     * @return the hexadecimal string representation of {@code d}.
     * @since 1.5
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.688 -0500", hash_original_method = "1D9798A0A4D63301EAA0C709DA651E0D", hash_generated_method = "4777531DC6DAFBE5D6CD7B3DF1F501A7")
    
public static String toHexString(double d) {
        /*
         * Reference: http://en.wikipedia.org/wiki/IEEE_754-1985
         */
        if (d != d) {
            return "NaN";
        }
        if (d == POSITIVE_INFINITY) {
            return "Infinity";
        }
        if (d == NEGATIVE_INFINITY) {
            return "-Infinity";
        }

        String str = new String();
        str.addTaint(d);
        return str;

        /*
        long bitValue = doubleToLongBits(d);

        boolean negative = (bitValue & 0x8000000000000000L) != 0;
        // mask exponent bits and shift down
        long exponent = (bitValue & 0x7FF0000000000000L) >>> 52;
        // mask significand bits and shift up
        long significand = bitValue & 0x000FFFFFFFFFFFFFL;

        if (exponent == 0 && significand == 0) {
            return (negative ? "-0x0.0p0" : "0x0.0p0");
        }

        StringBuilder hexString = new StringBuilder(10);
        if (negative) {
            hexString.append("-0x");
        } else {
            hexString.append("0x");
        }

        if (exponent == 0) { // denormal (subnormal) value
            hexString.append("0.");
            // significand is 52-bits, so there can be 13 hex digits
            int fractionDigits = 13;
            // remove trailing hex zeros, so Integer.toHexString() won't print
            // them
            while ((significand != 0) && ((significand & 0xF) == 0)) {
                significand >>>= 4;
                fractionDigits--;
            }
            // this assumes Integer.toHexString() returns lowercase characters
            String hexSignificand = Long.toHexString(significand);

            // if there are digits left, then insert some '0' chars first
            if (significand != 0 && fractionDigits > hexSignificand.length()) {
                int digitDiff = fractionDigits - hexSignificand.length();
                while (digitDiff-- != 0) {
                    hexString.append('0');
                }
            }
            hexString.append(hexSignificand);
            hexString.append("p-1022");
        } else { // normal value
            hexString.append("1.");
            // significand is 52-bits, so there can be 13 hex digits
            int fractionDigits = 13;
            // remove trailing hex zeros, so Integer.toHexString() won't print
            // them
            while ((significand != 0) && ((significand & 0xF) == 0)) {
                significand >>>= 4;
                fractionDigits--;
            }
            // this assumes Integer.toHexString() returns lowercase characters
            String hexSignificand = Long.toHexString(significand);

            // if there are digits left, then insert some '0' chars first
            if (significand != 0 && fractionDigits > hexSignificand.length()) {
                int digitDiff = fractionDigits - hexSignificand.length();
                while (digitDiff-- != 0) {
                    hexString.append('0');
                }
            }

            hexString.append(hexSignificand);
            hexString.append('p');
            // remove exponent's 'bias' and convert to a string
            hexString.append(Long.toString(exponent - 1023));
        }
        return hexString.toString();
        */
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.569 -0500", hash_original_field = "35B23ACD344EC3F8625C720C8375C8B0", hash_generated_field = "7F5B63AE36FC607559921B1D63D2079E")

    static final int EXPONENT_BIAS = 1023;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.572 -0500", hash_original_field = "001714363BB57C7EAACCCB37B3EE5CB0", hash_generated_field = "000E54F3BA29FBD16878C04E2FD284BE")

    static final int EXPONENT_BITS = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.575 -0500", hash_original_field = "633D3941CFCD2CB07CBC370B19286CA6", hash_generated_field = "B967A752EB7E74E3CC0A175C277EF3D5")

    static final int MANTISSA_BITS = 52;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.577 -0500", hash_original_field = "03BDD27D2DF250902CE20DD812E952F1", hash_generated_field = "69AB626B8F36038530178B38518A69D1")

    static final int NON_MANTISSA_BITS = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.580 -0500", hash_original_field = "D05945263B9CC3ABC6A4CAC5B08D5200", hash_generated_field = "9BA6940C2D6091320867626804E0CB6D")

    static final long SIGN_MASK     = 0x8000000000000000L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.582 -0500", hash_original_field = "26E4C7D338C97FEBD85162696B037ABA", hash_generated_field = "EBAB46050B41988DC2C5DC9FB4EC64CB")

    static final long EXPONENT_MASK = 0x7ff0000000000000L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.584 -0500", hash_original_field = "02EE6B7BEE6B7FB4A911818525D86D8E", hash_generated_field = "8169933C3C05CBB337AAC9FF554BE71F")

    static final long MANTISSA_MASK = 0x000fffffffffffffL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.587 -0500", hash_original_field = "C5A2B2057A03DEDC57BD654BB16EFF95", hash_generated_field = "2742CA755AF68701043B73DE036C7EDA")

    private static final long serialVersionUID = -9172774392245257468L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.592 -0500", hash_original_field = "4201E1E7B051C0E2134CCEFEA994B330", hash_generated_field = "D7B4F6E8BA984FBCFAED1ACB27E780C2")

    public static final double MAX_VALUE = 1.79769313486231570e+308;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.595 -0500", hash_original_field = "9734ABDB25496F3855CBE9EA9F461559", hash_generated_field = "6E35A9B0BA9FEBA45F45D92AEF546455")

    public static final double MIN_VALUE = 5e-324;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.597 -0500", hash_original_field = "6985004810874D53150DE7FB5CBC9076", hash_generated_field = "5AF44A589AC0950641B2A15FBD377731")

    /**
     * Constant for the Not-a-Number (NaN) value of the {@code double} type.
     */
    public static final double NaN = 0.0 / 0.0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.600 -0500", hash_original_field = "2A3994538D725519BD4E6070174C9538", hash_generated_field = "6B8F1800C8E14DB7ED360C0B33522F82")

    public static final double POSITIVE_INFINITY = 1.0 / 0.0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.603 -0500", hash_original_field = "3E888D4D87699AA8EEFD6DA6C0CBF249", hash_generated_field = "CFAAFA22EF80D170F9AD8220AA6677ED")

    public static final double NEGATIVE_INFINITY = -1.0 / 0.0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.605 -0500", hash_original_field = "2F5B9B61AB36D16CC310D030DCF5A406", hash_generated_field = "BD4E0DFD43F13354C4EBFEC46FC809C1")

    public static final double MIN_NORMAL = 2.2250738585072014E-308;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.608 -0500", hash_original_field = "F0EF3B18849E49521BA354731276C193", hash_generated_field = "A3E18AE28C2AEA8DC9FC7D7193B6C46A")

    public static final int MAX_EXPONENT = 1023;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.611 -0500", hash_original_field = "3D21A779F3BBCCD4DE94181CF9046204", hash_generated_field = "B9C9CE6037D12FD54C9E8B9BBF1B837A")

    public static final int MIN_EXPONENT = -1022;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.614 -0500", hash_original_field = "3F338DACC8970E140EE97598854663A7", hash_generated_field = "52AE33E5FC27971C510276C7051C89E9")

    @SuppressWarnings("unchecked")
    public static final Class<Double> TYPE
            = (Class<Double>) double[].class.getComponentType();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.617 -0500", hash_original_field = "3FE546B3A2686882FFF20CAC96A9D377", hash_generated_field = "8D5AC023D9098736D7483B5C821714DB")

    // defined to be "java.lang.Double.TYPE";

    /**
     * Constant for the number of bits needed to represent a {@code double} in
     * two's complement form.
     *
     * @since 1.5
     */
    public static final int SIZE = 64;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.589 -0500", hash_original_field = "952CFF67CB056A490AA4147ABB7A94F7", hash_generated_field = "CC3A7411181F65EEC4CCC5FA5B83F90E")

    private  double value;

    /**
     * Constructs a new {@code Double} with the specified primitive double
     * value.
     *
     * @param value
     *            the primitive double value to store in the new instance.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.619 -0500", hash_original_method = "7EA95E8804ADA9698A61C51212EFD766", hash_generated_method = "589D0C0B7FC9F4A52B12E44AC1FCBA18")
    
public Double(double value) {
        this.value = value;
        addTaint(value);
    }

    /**
     * Constructs a new {@code Double} from the specified string.
     *
     * @param string
     *            the string representation of a double value.
     * @throws NumberFormatException
     *             if {@code string} cannot be parsed as a double value.
     * @see #parseDouble(String)
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.623 -0500", hash_original_method = "C14717042677DE8EFE6605DB4D5CF298", hash_generated_method = "343BD09059FB57D9991D877A88D8B7ED")
    
public Double(String string) throws NumberFormatException {
        this(parseDouble(string));
    }

    /**
     * Compares this object to the specified double object to determine their
     * relative order. There are two special cases:
     * <ul>
     * <li>{@code Double.NaN} is equal to {@code Double.NaN} and it is greater
     * than any other double value, including {@code Double.POSITIVE_INFINITY};</li>
     * <li>+0.0d is greater than -0.0d</li>
     * </ul>
     *
     * @param object
     *            the double object to compare this object to.
     * @return a negative value if the value of this double is less than the
     *         value of {@code object}; 0 if the value of this double and the
     *         value of {@code object} are equal; a positive value if the value
     *         of this double is greater than the value of {@code object}.
     * @throws NullPointerException
     *             if {@code object} is {@code null}.
     * @see java.lang.Comparable
     * @since 1.2
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.625 -0500", hash_original_method = "1B85A65FB948A1CAE41CDDDF947CA953", hash_generated_method = "286C44CA10C99DDF8CEFFE5672D34BD2")
    
public int compareTo(Double object) {
        return compare(value, object.value);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.628 -0500", hash_original_method = "6B61312FC318A12A6B19178CA8B54E86", hash_generated_method = "4C2FE469A77605BE0BF5A0C525E46699")
    
@Override
    public byte byteValue() {
        return (byte) value;
    }

    /**
     * Gets the primitive value of this double.
     *
     * @return this object's primitive value.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.639 -0500", hash_original_method = "3D3B0AF18CC8081B7BB4A7DC662E1F07", hash_generated_method = "BF89BE4469CF5E691A2C43432BBB5D3E")
    
@Override
    public double doubleValue() {
        return value;
    }

    /**
     * Tests this double for equality with {@code object}.
     * To be equal, {@code object} must be an instance of {@code Double} and
     * {@code doubleToLongBits} must give the same value for both objects.
     *
     * <p>Note that, unlike {@code ==}, {@code -0.0} and {@code +0.0} compare
     * unequal, and {@code NaN}s compare equal by this method.
     *
     * @param object
     *            the object to compare this double with.
     * @return {@code true} if the specified object is equal to this
     *         {@code Double}; {@code false} otherwise.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.641 -0500", hash_original_method = "EE93E703109A76630ADBE20E58BC1ACE", hash_generated_method = "D82C2AE3C2635BF0173DC63463B49011")
    
@Override
    public boolean equals(Object object) {
        return super.equals(object);
        /*
        return (object instanceof Double) &&
                (doubleToLongBits(this.value) == doubleToLongBits(((Double) object).value));
        */
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.643 -0500", hash_original_method = "118855AC112B739ED1B5D8D57CEDA105", hash_generated_method = "0B5E80262680677099E066818539AB62")
    
@Override
    public float floatValue() {
        return (float) value;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.646 -0500", hash_original_method = "66DA7C954B623D2BD7B3A96EB7989DA3", hash_generated_method = "243A950A1A6DC9CA8D06A15F48F0F22F")
    
@Override
    public int hashCode() {
        long v = doubleToLongBits(value);
        return (int) (v ^ (v >>> 32));
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.648 -0500", hash_original_method = "138584002FB2DE9D0E5B5F8DAEDB3270", hash_generated_method = "9019C920956BC6564E381830D24ADC2B")
    
@Override
    public int intValue() {
        return (int) value;
    }

    /**
     * Indicates whether this object represents an infinite value.
     *
     * @return {@code true} if the value of this double is positive or negative
     *         infinity; {@code false} otherwise.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.652 -0500", hash_original_method = "82C3193F23F6D7770C948A8F860700C8", hash_generated_method = "ECFDA70CD333AB189AE460B59374A49D")
    
public boolean isInfinite() {
        return isInfinite(value);
    }

    /**
     * Indicates whether this object is a <em>Not-a-Number (NaN)</em> value.
     *
     * @return {@code true} if this double is <em>Not-a-Number</em>;
     *         {@code false} if it is a (potentially infinite) double number.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.656 -0500", hash_original_method = "9E74C322CF79FFEBE378AFAB98D56D96", hash_generated_method = "AD43DA09B8F6BB6058A22755BDBA989F")
    
public boolean isNaN() {
        return isNaN(value);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.665 -0500", hash_original_method = "C9BB01BEFAD51CB3D65FBCA00F38E36E", hash_generated_method = "8688FBD601BD891739470FEF2F36C2F2")
    
@Override
    public long longValue() {
        return (long) value;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.670 -0500", hash_original_method = "8E8C16CBE89F9837B346C9544C9B6BCC", hash_generated_method = "5FBF5C4E9B9689119C13934CEF72831A")
    
@Override
    public short shortValue() {
        return (short) value;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.673 -0500", hash_original_method = "CC4885D60C7843DD614D40299C63463C", hash_generated_method = "EE1984E84915156C0AAA3C8B1CFFD86F")
    
@Override
    public String toString() {
        return Double.toString(value);
    }
}

