package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;




import droidsafe.helpers.DSUtils;

public final class Float extends Number implements Comparable<Float> {

    
    @DSModeled(DSC.SAFE)
    public static int floatToIntBits(float value) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    public static int floatToRawIntBits(float value) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    public static float intBitsToFloat(int bits) {
        return DSUtils.UNKNOWN_FLOAT;
    }

    /**
     * Indicates whether the specified float represents an infinite value.
     *
     * @param f
     *            the float to check.
     * @return {@code true} if the value of {@code f} is positive or negative
     *         infinity; {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:27.327 -0500", hash_original_method = "F3C86372B308CB7AC0FC99B1DB4B622C", hash_generated_method = "683D8A9E5B30B40DB742F066FBD6598C")
    public static boolean isInfinite(float f) {
        return (f == POSITIVE_INFINITY) || (f == NEGATIVE_INFINITY);
    }

    /**
     * Indicates whether the specified float is a <em>Not-a-Number (NaN)</em>
     * value.
     *
     * @param f
     *            the float value to check.
     * @return {@code true} if {@code f} is <em>Not-a-Number</em>;
     *         {@code false} if it is a (potentially infinite) float number.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:27.329 -0500", hash_original_method = "797988AA09B377AAD595A673B0C7988B", hash_generated_method = "D920FE10DB13EBBC00F5D9F8CC7066A9")
    public static boolean isNaN(float f) {
        return f != f;
    }

    /**
     * Parses the specified string as a float value.
     *
     * @param string
     *            the string representation of a float value.
     * @return the primitive float value represented by {@code string}.
     * @throws NumberFormatException
     *             if {@code string} can not be parsed as a float value.
     * @see #valueOf(String)
     * @since 1.2
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:27.330 -0500", hash_original_method = "E332FB0E1CB7130552914B4D301DE791", hash_generated_method = "5A5D0EA79CAFDCAECA35E7E93C07C205")
    public static float parseFloat(String string) throws NumberFormatException {
        return StringToReal.parseFloat(string);
    }

    /**
     * Returns a string containing a concise, human-readable description of the
     * specified float value.
     *
     * @param f
     *             the float to convert to a string.
     * @return a printable representation of {@code f}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:27.333 -0500", hash_original_method = "B7E1BCC1B7A5845C5179DE746CBEEF71", hash_generated_method = "D5F9E6B59E5CA5AC8021B7D7B2DC2734")
    public static String toString(float f) {
        return RealToString.getInstance().floatToString(f);
    }

    /**
     * Parses the specified string as a float value.
     *
     * @param string
     *            the string representation of a float value.
     * @return a {@code Float} instance containing the float value represented
     *         by {@code string}.
     * @throws NumberFormatException
     *             if {@code string} can not be parsed as a float value.
     * @see #parseFloat(String)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:27.333 -0500", hash_original_method = "642ABD7E73780470D384DD3A60166E0E", hash_generated_method = "0A0CF9F1A77E65FC8EAE564F16A81F7F")
    public static Float valueOf(String string) throws NumberFormatException {
        return parseFloat(string);
    }

    /**
     * Compares the two specified float values. There are two special cases:
     * <ul>
     * <li>{@code Float.NaN} is equal to {@code Float.NaN} and it is greater
     * than any other float value, including {@code Float.POSITIVE_INFINITY};</li>
     * <li>+0.0f is greater than -0.0f</li>
     * </ul>
     *
     * @param float1
     *            the first value to compare.
     * @param float2
     *            the second value to compare.
     * @return a negative value if {@code float1} is less than {@code float2};
     *         0 if {@code float1} and {@code float2} are equal; a positive
     *         value if {@code float1} is greater than {@code float2}.
     * @since 1.4
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:27.334 -0500", hash_original_method = "437B20A71BAFB5FA99C486D62470A20A", hash_generated_method = "A08FC7329D3A6C2C7FB657184679034A")
    public static int compare(float float1, float float2) {
        // Non-zero, non-NaN checking.
        if (float1 > float2) {
            return 1;
        }
        if (float2 > float1) {
            return -1;
        }
        if (float1 == float2 && 0.0f != float1) {
            return 0;
        }

        // NaNs are equal to other NaNs and larger than any other float
        if (isNaN(float1)) {
            if (isNaN(float2)) {
                return 0;
            }
            return 1;
        } else if (isNaN(float2)) {
            return -1;
        }

        // Deal with +0.0 and -0.0
        int f1 = floatToRawIntBits(float1);
        int f2 = floatToRawIntBits(float2);
        // The below expression is equivalent to:
        // (f1 == f2) ? 0 : (f1 < f2) ? -1 : 1
        // because f1 and f2 are either 0 or Integer.MIN_VALUE
        return (f1 >> 31) - (f2 >> 31);
    }

    /**
     * Returns a {@code Float} instance for the specified float value.
     *
     * @param f
     *            the float value to store in the instance.
     * @return a {@code Float} instance containing {@code f}.
     * @since 1.5
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:27.335 -0500", hash_original_method = "D6416EFEFB750655A8B1DFB2823F2602", hash_generated_method = "63606CBCD564F19C028A0CDFCD104D78")
    public static Float valueOf(float f) {
        return new Float(f);
    }

    /**
     * Converts the specified float into its hexadecimal string representation.
     *
     * @param f
     *            the float to convert.
     * @return the hexadecimal string representation of {@code f}.
     * @since 1.5
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:27.337 -0500", hash_original_method = "10B7F57DA48FEE510D3FE44F096FB152", hash_generated_method = "FC28E11E54D49E3E7425983032DF35AD")
    public static String toHexString(float f) {
        /*
         * Reference: http://en.wikipedia.org/wiki/IEEE_754-1985
         */
        if (f != f) {
            return "NaN";
        }
        if (f == POSITIVE_INFINITY) {
            return "Infinity";
        }
        if (f == NEGATIVE_INFINITY) {
            return "-Infinity";
        }

        int bitValue = floatToIntBits(f);

        boolean negative = (bitValue & 0x80000000) != 0;
        // mask exponent bits and shift down
        int exponent = (bitValue & 0x7f800000) >>> 23;
        // mask significand bits and shift up
        // significand is 23-bits, so we shift to treat it like 24-bits
        int significand = (bitValue & 0x007FFFFF) << 1;

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
            // significand is 23-bits, so there can be 6 hex digits
            int fractionDigits = 6;
            // remove trailing hex zeros, so Integer.toHexString() won't print
            // them
            while ((significand != 0) && ((significand & 0xF) == 0)) {
                significand >>>= 4;
                fractionDigits--;
            }
            // this assumes Integer.toHexString() returns lowercase characters
            String hexSignificand = Integer.toHexString(significand);

            // if there are digits left, then insert some '0' chars first
            if (significand != 0 && fractionDigits > hexSignificand.length()) {
                int digitDiff = fractionDigits - hexSignificand.length();
                while (digitDiff-- != 0) {
                    hexString.append('0');
                }
            }
            hexString.append(hexSignificand);
            hexString.append("p-126");
        } else { // normal value
            hexString.append("1.");
            // significand is 23-bits, so there can be 6 hex digits
            int fractionDigits = 6;
            // remove trailing hex zeros, so Integer.toHexString() won't print
            // them
            while ((significand != 0) && ((significand & 0xF) == 0)) {
                significand >>>= 4;
                fractionDigits--;
            }
            // this assumes Integer.toHexString() returns lowercase characters
            String hexSignificand = Integer.toHexString(significand);

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
            hexString.append(exponent - 127);
        }
        return hexString.toString();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:27.294 -0500", hash_original_field = "000C4FCEDA08ED86907ED4A1E40905D5", hash_generated_field = "2D74B2AF393FD57B1253D83587B03C3D")

    static final int EXPONENT_BIAS = 127;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:27.296 -0500", hash_original_field = "9C9ADE8D52CD0B7FC8528B4F8D9CB261", hash_generated_field = "AAB44785F4FC3A37C42CA63B6A8EBE86")


    static final int EXPONENT_BITS = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:27.297 -0500", hash_original_field = "A12356A8AA5F8FA4D03DECCC97E6061F", hash_generated_field = "F67817DD7050153A96F45168E72D8F28")

    static final int MANTISSA_BITS = 23;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:27.297 -0500", hash_original_field = "7865360FC50102B6BF7A24D4AB33F66F", hash_generated_field = "35E165A48A70B8CCA5272FC3BE589E43")

    static final int NON_MANTISSA_BITS = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:27.298 -0500", hash_original_field = "16837E81C0CF60EDEAF65F3912719CFA", hash_generated_field = "7094B89EE6D925DFA81EF867594CF0A9")


    static final int SIGN_MASK     = 0x80000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:27.299 -0500", hash_original_field = "3086487D2ED25E30450466E77AC5232F", hash_generated_field = "D091E878ED0F3CCC802CE44713C89F6E")

    static final int EXPONENT_MASK = 0x7f800000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:27.300 -0500", hash_original_field = "C30A1DA18F53D594F3FBE502DA7689A9", hash_generated_field = "3A1DB9D1750D6BCC0EE5312BC8121235")

    static final int MANTISSA_MASK = 0x007fffff;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:27.301 -0500", hash_original_field = "E786B752FBB96B26566832DAA0B711C5", hash_generated_field = "1967804242F606EDCF5ADE6EBC54C263")


    private static final long serialVersionUID = -2671257302660747028L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:27.302 -0500", hash_original_field = "C683BBFDDFFB87EA94B20502D7B915D5", hash_generated_field = "64A78D592CBFAAAD64B3A3BFB1932908")

    public static final float MAX_VALUE = 3.40282346638528860e+38f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:27.303 -0500", hash_original_field = "45B9CEA1F40B43AE9CB5F94AC9A26900", hash_generated_field = "4A827F8491540AF52FD9F8C6E5AEB2A2")

    public static final float MIN_VALUE = 1.40129846432481707e-45f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:27.304 -0500", hash_original_field = "A1E968E62D695A47E89B31A98D4779CF", hash_generated_field = "C60CF7E907A2A964678CDF2826A00539")

    public static final float NaN = 0.0f / 0.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:27.305 -0500", hash_original_field = "ADEB2EA18BA0275605D3250B90807773", hash_generated_field = "489A915079CFDC9521642D78AC79C490")

    public static final float POSITIVE_INFINITY = 1.0f / 0.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:27.306 -0500", hash_original_field = "F5CD74DAECEE252DACED62D275388FEB", hash_generated_field = "0A0A6DC04A00ACB8142143545EFE7514")

    public static final float NEGATIVE_INFINITY = -1.0f / 0.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:27.307 -0500", hash_original_field = "FE71B3C2B5DE1F4AC0F3AAC859E0AA37", hash_generated_field = "17572F678E5EEF0D46D3BBCC6454815E")

    public static final float MIN_NORMAL = 1.1754943508222875E-38f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:27.308 -0500", hash_original_field = "FE92890A922A0440B1E5B38ECFC80309", hash_generated_field = "12C402989413083FF31BD33A94337571")

    public static final int MAX_EXPONENT = 127;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:27.309 -0500", hash_original_field = "3A9EA051692DD99B516D7827EBD91A56", hash_generated_field = "EC1E80AD9830FFEA4C4F22313425865A")

    public static final int MIN_EXPONENT = -126;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:27.310 -0500", hash_original_field = "6DCCA26522FE9AB1E358B585DF50C7BE", hash_generated_field = "42120EDB27D6BEEDC5C3C0CA73234E89")

    @SuppressWarnings("unchecked")
    public static final Class<Float> TYPE
            = (Class<Float>) float[].class.getComponentType();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:27.311 -0500", hash_original_field = "1503BF3B0F0858201FC26D4F68A4CEDE", hash_generated_field = "2AC6F395BC8010240D5EEA24EC046798")

    // defined to be "java.lang.Float.TYPE";

    /**
     * Constant for the number of bits needed to represent a {@code float} in
     * two's complement form.
     *
     * @since 1.5
     */
    public static final int SIZE = 32;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:27.302 -0500", hash_original_field = "AFED88F9B46D00F83012B0491FE8482F", hash_generated_field = "9AC23CAA5D24AAACBEAFEC0133B195BB")

    private  float value;

    /**
     * Constructs a new {@code Float} with the specified primitive float value.
     *
     * @param value
     *            the primitive float value to store in the new instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:27.312 -0500", hash_original_method = "5ED6E2A1D35592501FD060BC19F5CA5B", hash_generated_method = "BCBFF272BF6FC28A9014B170F0FCF64F")
    public Float(float value) {
        this.value = value;
    }

    /**
     * Constructs a new {@code Float} with the specified primitive double value.
     *
     * @param value
     *            the primitive double value to store in the new instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:27.313 -0500", hash_original_method = "F67C36B21D5AC7A6288ABF8CC3CCE46F", hash_generated_method = "76E4C5FB0F782D0A9C051CF0A1E945D1")
    public Float(double value) {
        this.value = (float) value;
    }

    /**
     * Constructs a new {@code Float} from the specified string.
     *
     * @param string
     *            the string representation of a float value.
     * @throws NumberFormatException
     *             if {@code string} can not be parsed as a float value.
     * @see #parseFloat(String)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:27.314 -0500", hash_original_method = "4BD76BD235C983014B5B86B98889672F", hash_generated_method = "BC72A168338795CF3C7F860F2F0279BB")
    public Float(String string) throws NumberFormatException {
        this(parseFloat(string));
    }

    /**
     * Compares this object to the specified float object to determine their
     * relative order. There are two special cases:
     * <ul>
     * <li>{@code Float.NaN} is equal to {@code Float.NaN} and it is greater
     * than any other float value, including {@code Float.POSITIVE_INFINITY};</li>
     * <li>+0.0f is greater than -0.0f</li>
     * </ul>
     *
     * @param object
     *            the float object to compare this object to.
     * @return a negative value if the value of this float is less than the
     *         value of {@code object}; 0 if the value of this float and the
     *         value of {@code object} are equal; a positive value if the value
     *         of this float is greater than the value of {@code object}.
     * @see java.lang.Comparable
     * @since 1.2
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:27.315 -0500", hash_original_method = "C4AC6F26EC342AC8CCBAB08E832A244F", hash_generated_method = "295C477FE388D5EBA14F86DECAF1B063")
    public int compareTo(Float object) {
        return compare(value, object.value);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:27.316 -0500", hash_original_method = "6B61312FC318A12A6B19178CA8B54E86", hash_generated_method = "4C2FE469A77605BE0BF5A0C525E46699")
    @Override
public byte byteValue() {
        return (byte) value;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:27.317 -0500", hash_original_method = "3D3B0AF18CC8081B7BB4A7DC662E1F07", hash_generated_method = "BF89BE4469CF5E691A2C43432BBB5D3E")
    @Override
public double doubleValue() {
        return value;
    }

    /**
     * Tests this double for equality with {@code object}.
     * To be equal, {@code object} must be an instance of {@code Float} and
     * {@code floatToIntBits} must give the same value for both objects.
     *
     * <p>Note that, unlike {@code ==}, {@code -0.0} and {@code +0.0} compare
     * unequal, and {@code NaN}s compare equal by this method.
     *
     * @param object
     *            the object to compare this float with.
     * @return {@code true} if the specified object is equal to this
     *         {@code Float}; {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:27.318 -0500", hash_original_method = "D5A6527E8F740E6B81FAC1E35F94CBE1", hash_generated_method = "842C33B3DA49D18CAAF606BC8E5D01B5")
    @Override
public boolean equals(Object object) {
        return (object instanceof Float) &&
                (floatToIntBits(this.value) == floatToIntBits(((Float) object).value));
    }

    /**
     * Gets the primitive value of this float.
     *
     * @return this object's primitive value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:27.322 -0500", hash_original_method = "9E2C0918A44EC11D2232D0B603F66A6B", hash_generated_method = "0138C4AD160C9AAF1F0B41D5F85236C8")
    @Override
public float floatValue() {
        return value;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:27.323 -0500", hash_original_method = "08993E3A95048E3B463477EA75421A52", hash_generated_method = "D59EDD7D21AF66F58605F88F64ED1B24")
    @Override
public int hashCode() {
        return floatToIntBits(value);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:27.325 -0500", hash_original_method = "138584002FB2DE9D0E5B5F8DAEDB3270", hash_generated_method = "9019C920956BC6564E381830D24ADC2B")
    @Override
public int intValue() {
        return (int) value;
    }

    /**
     * Indicates whether this object represents an infinite value.
     *
     * @return {@code true} if the value of this float is positive or negative
     *         infinity; {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:27.326 -0500", hash_original_method = "82C3193F23F6D7770C948A8F860700C8", hash_generated_method = "ECFDA70CD333AB189AE460B59374A49D")
    public boolean isInfinite() {
        return isInfinite(value);
    }

    /**
     * Indicates whether this object is a <em>Not-a-Number (NaN)</em> value.
     *
     * @return {@code true} if this float is <em>Not-a-Number</em>;
     *         {@code false} if it is a (potentially infinite) float number.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:27.328 -0500", hash_original_method = "9E74C322CF79FFEBE378AFAB98D56D96", hash_generated_method = "AD43DA09B8F6BB6058A22755BDBA989F")
    public boolean isNaN() {
        return isNaN(value);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:27.329 -0500", hash_original_method = "C9BB01BEFAD51CB3D65FBCA00F38E36E", hash_generated_method = "8688FBD601BD891739470FEF2F36C2F2")
    @Override
public long longValue() {
        return (long) value;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:27.331 -0500", hash_original_method = "8E8C16CBE89F9837B346C9544C9B6BCC", hash_generated_method = "5FBF5C4E9B9689119C13934CEF72831A")
    @Override
public short shortValue() {
        return (short) value;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:27.332 -0500", hash_original_method = "A363CDE834C704519FC1C85052C83F92", hash_generated_method = "61B50C37391F52970D25A3753BBCA35D")
    @Override
public String toString() {
        return Float.toString(value);
    }
}

