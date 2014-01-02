package java.math;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

import libcore.math.MathUtils;





public class BigDecimal extends Number implements Comparable<BigDecimal>, Serializable {

    /* Public Methods */

    /**
     * Returns a new {@code BigDecimal} instance whose value is equal to {@code
     * unscaledVal} 10^(-{@code scale}). The scale of the result is {@code
     * scale}, and its unscaled value is {@code unscaledVal}.
     *
     * @param unscaledVal
     *            unscaled value to be used to construct the new {@code
     *            BigDecimal}.
     * @param scale
     *            scale to be used to construct the new {@code BigDecimal}.
     * @return {@code BigDecimal} instance with the value {@code unscaledVal}*
     *         10^(-{@code unscaledVal}).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.216 -0500", hash_original_method = "F9892CC1443390F81D4FBFF3F20214AD", hash_generated_method = "5CE479A48454C88ED412F5E65ACE7121")
    
public static BigDecimal valueOf(long unscaledVal, int scale) {
        if (scale == 0) {
            return valueOf(unscaledVal);
        }
        if ((unscaledVal == 0) && (scale >= 0)
                && (scale < ZERO_SCALED_BY.length)) {
            return ZERO_SCALED_BY[scale];
        }
        return new BigDecimal(unscaledVal, scale);
    }

    /**
     * Returns a new {@code BigDecimal} instance whose value is equal to {@code
     * unscaledVal}. The scale of the result is {@code 0}, and its unscaled
     * value is {@code unscaledVal}.
     *
     * @param unscaledVal
     *            value to be converted to a {@code BigDecimal}.
     * @return {@code BigDecimal} instance with the value {@code unscaledVal}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.219 -0500", hash_original_method = "6005B27E24A666ABF80A39B1F52409D2", hash_generated_method = "004BECF32C4D7725B75CD1E903B7E085")
    
public static BigDecimal valueOf(long unscaledVal) {
        if ((unscaledVal >= 0) && (unscaledVal < BI_SCALED_BY_ZERO_LENGTH)) {
            return BI_SCALED_BY_ZERO[(int)unscaledVal];
        }
        return new BigDecimal(unscaledVal,0);
    }

    /**
     * Returns a new {@code BigDecimal} instance whose value is equal to {@code
     * val}. The new decimal is constructed as if the {@code BigDecimal(String)}
     * constructor is called with an argument which is equal to {@code
     * Double.toString(val)}. For example, {@code valueOf("0.1")} is converted to
     * (unscaled=1, scale=1), although the double {@code 0.1} cannot be
     * represented exactly as a double value. In contrast to that, a new {@code
     * BigDecimal(0.1)} instance has the value {@code
     * 0.1000000000000000055511151231257827021181583404541015625} with an
     * unscaled value {@code 1000000000000000055511151231257827021181583404541015625}
     * and the scale {@code 55}.
     *
     * @param val
     *            double value to be converted to a {@code BigDecimal}.
     * @return {@code BigDecimal} instance with the value {@code val}.
     * @throws NumberFormatException
     *             if {@code val} is infinite or {@code val} is not a number
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.222 -0500", hash_original_method = "10A95FF55B9E585002402901CCF62557", hash_generated_method = "C311EE40996D59E17B3F55D313EE4358")
    
public static BigDecimal valueOf(double val) {
        if (Double.isInfinite(val) || Double.isNaN(val)) {
            throw new NumberFormatException("Infinity or NaN: " + val);
        }
        return new BigDecimal(Double.toString(val));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.228 -0500", hash_original_method = "A46415AE823E313D5E8C5AE45376215F", hash_generated_method = "80370484F8CE3F1AD90C7B721552903B")
    
private static BigDecimal addAndMult10(BigDecimal thisValue,BigDecimal augend, int diffScale) {
        if(diffScale < MathUtils.LONG_POWERS_OF_TEN.length &&
                Math.max(thisValue.bitLength,augend.bitLength+LONG_POWERS_OF_TEN_BIT_LENGTH[diffScale])+1<64) {
            return valueOf(thisValue.smallValue+augend.smallValue*MathUtils.LONG_POWERS_OF_TEN[diffScale],thisValue.scale);
        } else {
            BigInt bi = Multiplication.multiplyByTenPow(augend.getUnscaledValue(),diffScale).getBigInt();
            bi.add(thisValue.getUnscaledValue().getBigInt());
            return new BigDecimal(new BigInteger(bi), thisValue.scale);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.252 -0500", hash_original_method = "5942F5A028CB6724F6727335EEB4228B", hash_generated_method = "DA627B5F8B1BC7F08FAB5B469CFE1529")
    
private static BigDecimal divideBigIntegers(BigInteger scaledDividend, BigInteger scaledDivisor, int scale, RoundingMode roundingMode) {

        BigInteger[] quotAndRem = scaledDividend.divideAndRemainder(scaledDivisor);  // quotient and remainder
        // If after division there is a remainder...
        BigInteger quotient = quotAndRem[0];
        BigInteger remainder = quotAndRem[1];
        if (remainder.signum() == 0) {
            return new BigDecimal(quotient, scale);
        }
        int sign = scaledDividend.signum() * scaledDivisor.signum();
        int compRem;                                      // 'compare to remainder'
        if(scaledDivisor.bitLength() < 63) { // 63 in order to avoid out of long after *2
            long rem = remainder.longValue();
            long divisor = scaledDivisor.longValue();
            compRem = longCompareTo(Math.abs(rem) * 2,Math.abs(divisor));
            // To look if there is a carry
            compRem = roundingBehavior(quotient.testBit(0) ? 1 : 0,
                    sign * (5 + compRem), roundingMode);

        } else {
            // Checking if:  remainder * 2 >= scaledDivisor
            compRem = remainder.abs().shiftLeftOneBit().compareTo(scaledDivisor.abs());
            compRem = roundingBehavior(quotient.testBit(0) ? 1 : 0,
                    sign * (5 + compRem), roundingMode);
        }
            if (compRem != 0) {
            if(quotient.bitLength() < 63) {
                return valueOf(quotient.longValue() + compRem,scale);
            }
            quotient = quotient.add(BigInteger.valueOf(compRem));
            return new BigDecimal(quotient, scale);
        }
        // Constructing the result with the appropriate unscaled value
        return new BigDecimal(quotient, scale);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.256 -0500", hash_original_method = "7B0F2D11454582168AA71FF633AE192E", hash_generated_method = "44DAF81F917D0C26F92BE7A5A93C17FF")
    
private static BigDecimal dividePrimitiveLongs(long scaledDividend, long scaledDivisor, int scale, RoundingMode roundingMode) {
        long quotient = scaledDividend / scaledDivisor;
        long remainder = scaledDividend % scaledDivisor;
        int sign = Long.signum( scaledDividend ) * Long.signum( scaledDivisor );
        if (remainder != 0) {
            // Checking if:  remainder * 2 >= scaledDivisor
            int compRem;                                      // 'compare to remainder'
            compRem = longCompareTo(Math.abs(remainder) * 2,Math.abs(scaledDivisor));
            // To look if there is a carry
            quotient += roundingBehavior(((int)quotient) & 1,
                    sign * (5 + compRem),
                    roundingMode);
        }
        // Constructing the result with the appropriate unscaled value
        return valueOf(quotient, scale);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.411 -0500", hash_original_method = "6F8795E63BC9049AAA9B8D7577159AC3", hash_generated_method = "2C494A30C70403F75BDC3A7CF90E78BB")
    
private static int longCompareTo(long value1, long value2) {
        return value1 > value2 ? 1 : (value1 < value2 ? -1 : 0);
    }

    /**
     * Return an increment that can be -1,0 or 1, depending of
     * {@code roundingMode}.
     *
     * @param parityBit
     *            can be 0 or 1, it's only used in the case
     *            {@code HALF_EVEN}
     * @param fraction
     *            the mantissa to be analyzed
     * @param roundingMode
     *            the type of rounding
     * @return the carry propagated after rounding
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.417 -0500", hash_original_method = "89FB81061342283FD2D255BA617B9F56", hash_generated_method = "D85A0B85302C2EDA6C22AC490F606B0B")
    
private static int roundingBehavior(int parityBit, int fraction, RoundingMode roundingMode) {
        int increment = 0; // the carry after rounding

        switch (roundingMode) {
            case UNNECESSARY:
                if (fraction != 0) {
                    throw new ArithmeticException("Rounding necessary");
                }
                break;
            case UP:
                increment = Integer.signum(fraction);
                break;
            case DOWN:
                break;
            case CEILING:
                increment = Math.max(Integer.signum(fraction), 0);
                break;
            case FLOOR:
                increment = Math.min(Integer.signum(fraction), 0);
                break;
            case HALF_UP:
                if (Math.abs(fraction) >= 5) {
                    increment = Integer.signum(fraction);
                }
                break;
            case HALF_DOWN:
                if (Math.abs(fraction) > 5) {
                    increment = Integer.signum(fraction);
                }
                break;
            case HALF_EVEN:
                if (Math.abs(fraction) + parityBit > 5) {
                    increment = Integer.signum(fraction);
                }
                break;
        }
        return increment;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.424 -0500", hash_original_method = "3E37D52FCEF46233035FAF85688E9AE3", hash_generated_method = "4EFDE105A2047266074EE79EE87CC770")
    
private static int safeLongToInt(long longValue) {
        if (longValue < Integer.MIN_VALUE || longValue > Integer.MAX_VALUE) {
            throw new ArithmeticException("Out of int range: " + longValue);
        }
        return (int) longValue;
    }

    /**
     * It returns the value 0 with the most approximated scale of type
     * {@code int}. if {@code longScale > Integer.MAX_VALUE} the
     * scale will be {@code Integer.MAX_VALUE}; if
     * {@code longScale < Integer.MIN_VALUE} the scale will be
     * {@code Integer.MIN_VALUE}; otherwise {@code longScale} is
     * casted to the type {@code int}.
     *
     * @param longScale
     *            the scale to which the value 0 will be scaled.
     * @return the value 0 scaled by the closer scale of type {@code int}.
     * @see #scale
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.427 -0500", hash_original_method = "02562B606C3E71F0B7DFB1304AA72DDB", hash_generated_method = "C194E961E90BA0311F68E21D1A359734")
    
private static BigDecimal zeroScaledBy(long longScale) {
        if (longScale == (int) longScale) {
            return valueOf(0,(int)longScale);
            }
        if (longScale >= 0) {
            return new BigDecimal( 0, Integer.MAX_VALUE);
        }
        return new BigDecimal( 0, Integer.MIN_VALUE);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.440 -0500", hash_original_method = "82F1645A8A86A2C28F5CBA199054A99A", hash_generated_method = "C60AF3E4191D1B3AD0803B03B056147B")
    
private static int bitLength(long smallValue) {
        if(smallValue < 0) {
            smallValue = ~smallValue;
        }
        return 64 - Long.numberOfLeadingZeros(smallValue);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.443 -0500", hash_original_method = "DC0F77C7653E0BDC476925E875F64B26", hash_generated_method = "A286E1DAA74B22D67487DC50E36C15B2")
    
private static int bitLength(int smallValue) {
        if(smallValue < 0) {
            smallValue = ~smallValue;
        }
        return 32 - Integer.numberOfLeadingZeros(smallValue);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.085 -0500", hash_original_field = "376C7D7B79D7F4567BFE1A377FE284B2", hash_generated_field = "B6EECEB04C7C8E9BC518DBA316290DA7")

    public static final int ROUND_UP = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.087 -0500", hash_original_field = "E9C02588513D6417E25D4AA45014BE66", hash_generated_field = "454999CD924CB489896B8D343444FE92")

    public static final int ROUND_DOWN = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.090 -0500", hash_original_field = "51785B13ED3E5BDB46F34040F95F4255", hash_generated_field = "3C0D845F7C2F954D2ED7E86C0AE35835")

    public static final int ROUND_CEILING = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.093 -0500", hash_original_field = "19296B0DFAC123E30E1C315A6B16D4C8", hash_generated_field = "53D60190BBA8538A982DF868F4C6200E")

    public static final int ROUND_FLOOR = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.096 -0500", hash_original_field = "5CBA3FB7BB360CDD170671E9457D16E2", hash_generated_field = "F10F1696D5C52C5E6B4B91643A72CEBE")

    public static final int ROUND_HALF_UP = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.098 -0500", hash_original_field = "0B26D612BA5EFAE8EDE3F710E3F5C666", hash_generated_field = "1619429E1C6C75DCE5756A9CF242CB9E")

    public static final int ROUND_HALF_DOWN = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.101 -0500", hash_original_field = "1AA68CFE0DAD904695650F4BBAD21E43", hash_generated_field = "737A62C6AFA4A3B8167B738F856B0DEA")

    public static final int ROUND_HALF_EVEN = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.103 -0500", hash_original_field = "A88EC5ED045AD3D66EE024D7473AD192", hash_generated_field = "C5A01DD93D79DC15583A8D0F0236E74E")

    public static final int ROUND_UNNECESSARY = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.105 -0500", hash_original_field = "63B1D38782173ABAAED19D754998DD9D", hash_generated_field = "732C210E7618496C3947E6F404C23DC5")

    private static final long serialVersionUID = 6108874887143696463L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.108 -0500", hash_original_field = "98CE2463B419C045DFD2A6D6C60E2402", hash_generated_field = "E93F26BA415E2A63370EECFB39CABE9A")

    private static final double LOG10_2 = 0.3010299956639812;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.117 -0500", hash_original_field = "752505761B9845B313A2EF02A3C16815", hash_generated_field = "BC1FA69034FA076F552F1F096B6FE848")

    private static  BigInteger[] FIVE_POW;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.119 -0500", hash_original_field = "FF7162C0B5BE8CFB0550B2B3387E69CA", hash_generated_field = "487DAC2FC944E340E99AE2E5C8C63B33")

    private static  BigInteger[] TEN_POW;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.122 -0500", hash_original_field = "8FA9D1BEEAB8A8C00CACD4833A69484A", hash_generated_field = "7278FA9BE84E3C616E4421DE5FF2F206")


    private static final long[] LONG_FIVE_POW = new long[]
    {   1L,
        5L,
        25L,
        125L,
        625L,
        3125L,
        15625L,
        78125L,
        390625L,
        1953125L,
        9765625L,
        48828125L,
        244140625L,
        1220703125L,
        6103515625L,
        30517578125L,
        152587890625L,
        762939453125L,
        3814697265625L,
        19073486328125L,
        95367431640625L,
        476837158203125L,
        2384185791015625L,
        11920928955078125L,
        59604644775390625L,
        298023223876953125L,
        1490116119384765625L,
        7450580596923828125L, };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.125 -0500", hash_original_field = "A77A182FE39DE5EBF94A318A1AFECB07", hash_generated_field = "FD0F7EAC9A9246982008521CC29799A7")


    private static final int[] LONG_FIVE_POW_BIT_LENGTH = new int[LONG_FIVE_POW.length];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.128 -0500", hash_original_field = "4749A86959EF10EF1080A9333DA3124F", hash_generated_field = "9DFBCE8298EAB00B86718FC0B2D88337")

    private static final int[] LONG_POWERS_OF_TEN_BIT_LENGTH = new int[MathUtils.LONG_POWERS_OF_TEN.length];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.130 -0500", hash_original_field = "52C500940B1EC4250CA8ACC65D9CCA1A", hash_generated_field = "E22EB04741B2BFD88E960FE524D60B1A")


    private static final int BI_SCALED_BY_ZERO_LENGTH = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.133 -0500", hash_original_field = "DCAF56BF5ED70EAB2415C3D633724F4E", hash_generated_field = "5B020D40BF07C0EC94E4149184B70A65")

    private static final BigDecimal[] BI_SCALED_BY_ZERO = new BigDecimal[BI_SCALED_BY_ZERO_LENGTH];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.135 -0500", hash_original_field = "3D15C3A7C135CCF6BA5DCFF7AADD7FD0", hash_generated_field = "5C08AD19ABFF43369109F8D9272F2B04")

    private static final BigDecimal[] ZERO_SCALED_BY = new BigDecimal[11];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.138 -0500", hash_original_field = "4587AF79F3F280A350A136CBA1B8049B", hash_generated_field = "12A340B61FB03C00F6D04EBF43FAFF99")

    private static final char[] CH_ZEROS = new char[100];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.142 -0500", hash_original_field = "1D7AF782751FE95BB10255F61ECD5990", hash_generated_field = "E2BD5BBDB2DF3AE4973FDC84A00AF40A")

    public static final BigDecimal ZERO = new BigDecimal(0, 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.144 -0500", hash_original_field = "EED8177809CCB66F893BAF55D41D0B52", hash_generated_field = "9F34079F2BD32FDD32B17DD6B2BC0759")

    public static final BigDecimal ONE = new BigDecimal(1, 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.146 -0500", hash_original_field = "61F8CE6C71126BF7F7297E72E0D2A276", hash_generated_field = "7D43F273171CCD7BF176CC18D6BEE813")

    public static final BigDecimal TEN = new BigDecimal(10, 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.111 -0500", hash_original_field = "C7E6CF1EB1F09252628C67CF5F252D88", hash_generated_field = "326D03DFD6F64D4B3F1173FBD427B520")

    private transient String toStringImage = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.113 -0500", hash_original_field = "2257B8AF42139E78B9EB6F31816249E1", hash_generated_field = "3D9A07F218385AD7A5B345B923EAF46E")

    private transient int hashCode = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.149 -0500", hash_original_field = "22392F4CDA217309CEACFD6B5400654A", hash_generated_field = "E1C21CCC8969038A086EDD16030014B8")

    private BigInteger intVal;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.151 -0500", hash_original_field = "2D47056835D2DB19B19AB49B6EFAF056", hash_generated_field = "1C841931B61AD9BC0EB5C76BA4219E64")


    private transient int bitLength;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.153 -0500", hash_original_field = "C7105AF1F7C710FDA21C6C5661A3F35B", hash_generated_field = "27339F171BD0CF229BCBE4E7356A5F0B")


    private transient long smallValue;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.156 -0500", hash_original_field = "BA0D3D812FE0526303F6820DD8690E4B", hash_generated_field = "F9D5D1CA2ABDD82810FF1FE80E0268E6")

    private int scale;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.159 -0500", hash_original_field = "0306FC1243D52C8B5E0B842583EF7F23", hash_generated_field = "4E7D370BAE76B07332BBBB929C2DF340")

    private transient int precision = 0;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.162 -0500", hash_original_method = "6BC27F867C09C0249873A4D338F8666D", hash_generated_method = "F5A17E3EA4EFB84D0C87E0D2B7FB5801")
    
private BigDecimal(long smallValue, int scale){
        this.smallValue = smallValue;
        this.scale = scale;
        this.bitLength = bitLength(smallValue);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.165 -0500", hash_original_method = "9F6CD654516DCD03F33530EDCF81D84D", hash_generated_method = "2DA05A7D2D4CDD563EC3533635DFDC65")
    
private BigDecimal(int smallValue, int scale){
        this.smallValue = smallValue;
        this.scale = scale;
        this.bitLength = bitLength(smallValue);
    }

    /**
     * Constructs a new {@code BigDecimal} instance from a string representation
     * given as a character array.
     *
     * @param in
     *            array of characters containing the string representation of
     *            this {@code BigDecimal}.
     * @param offset
     *            first index to be copied.
     * @param len
     *            number of characters to be used.
     * @throws NumberFormatException
     *             if {@code offset < 0 || len <= 0 || offset+len-1 < 0 ||
     *             offset+len-1 >= in.length}, or if {@code in} does not
     *             contain a valid string representation of a big decimal.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.169 -0500", hash_original_method = "374C425CF4086C798A21EEA670343536", hash_generated_method = "1344B854F823E3ECBDC918043A9EFA67")
    
public BigDecimal(char[] in, int offset, int len) {
        int begin = offset; // first index to be copied
        int last = offset + (len - 1); // last index to be copied
        String scaleString; // buffer for scale
        StringBuilder unscaledBuffer; // buffer for unscaled value
        long newScale; // the new scale

        if (in == null) {
            throw new NullPointerException();
        }
        if ((last >= in.length) || (offset < 0) || (len <= 0) || (last < 0)) {
            throw new NumberFormatException("Bad offset/length: offset=" + offset +
                    " len=" + len + " in.length=" + in.length);
        }
        unscaledBuffer = new StringBuilder(len);
        int bufLength = 0;
        // To skip a possible '+' symbol
        if ((offset <= last) && (in[offset] == '+')) {
            offset++;
            begin++;
        }
        int counter = 0;
        boolean wasNonZero = false;
        // Accumulating all digits until a possible decimal point
        for (; (offset <= last) && (in[offset] != '.') && (in[offset] != 'e') && (in[offset] != 'E'); offset++) {
            if (!wasNonZero) {
                if (in[offset] == '0') {
                    counter++;
                } else {
                    wasNonZero = true;
                }
            }

        }
        unscaledBuffer.append(in, begin, offset - begin);
        bufLength += offset - begin;
        // A decimal point was found
        if ((offset <= last) && (in[offset] == '.')) {
            offset++;
            // Accumulating all digits until a possible exponent
            begin = offset;
            for (; (offset <= last) && (in[offset] != 'e')
            && (in[offset] != 'E'); offset++) {
                if (!wasNonZero) {
                    if (in[offset] == '0') {
                        counter++;
                    } else {
                        wasNonZero = true;
                    }
                }
            }
            scale = offset - begin;
            bufLength +=scale;
            unscaledBuffer.append(in, begin, scale);
        } else {
            scale = 0;
        }
        // An exponent was found
        if ((offset <= last) && ((in[offset] == 'e') || (in[offset] == 'E'))) {
            offset++;
            // Checking for a possible sign of scale
            begin = offset;
            if ((offset <= last) && (in[offset] == '+')) {
                offset++;
                if ((offset <= last) && (in[offset] != '-')) {
                    begin++;
                }
            }
            // Accumulating all remaining digits
            scaleString = String.valueOf(in, begin, last + 1 - begin);
            // Checking if the scale is defined
            newScale = (long)scale - Integer.parseInt(scaleString);
            scale = (int)newScale;
            if (newScale != scale) {
                throw new NumberFormatException("Scale out of range");
            }
        }
        // Parsing the unscaled value
        if (bufLength < 19) {
            smallValue = Long.parseLong(unscaledBuffer.toString());
            bitLength = bitLength(smallValue);
        } else {
            setUnscaledValue(new BigInteger(unscaledBuffer.toString()));
        }
        precision = unscaledBuffer.length() - counter;
        if (unscaledBuffer.charAt(0) == '-') {
            precision --;
        }
    }

    /**
     * Constructs a new {@code BigDecimal} instance from a string representation
     * given as a character array.
     *
     * @param in
     *            array of characters containing the string representation of
     *            this {@code BigDecimal}.
     * @param offset
     *            first index to be copied.
     * @param len
     *            number of characters to be used.
     * @param mc
     *            rounding mode and precision for the result of this operation.
     * @throws NumberFormatException
     *             if {@code offset < 0 || len <= 0 || offset+len-1 < 0 ||
     *             offset+len-1 >= in.length}, or if {@code in} does not
     *             contain a valid string representation of a big decimal.
     * @throws ArithmeticException
     *             if {@code mc.precision > 0} and {@code mc.roundingMode ==
     *             UNNECESSARY} and the new big decimal cannot be represented
     *             within the given precision without rounding.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.172 -0500", hash_original_method = "021DB19003FFCB38960FC53E0DB20D11", hash_generated_method = "CDDA988A05CDA057AA45C4E3F8EF4061")
    
public BigDecimal(char[] in, int offset, int len, MathContext mc) {
        this(in, offset, len);
        inplaceRound(mc);
    }

    /**
     * Constructs a new {@code BigDecimal} instance from a string representation
     * given as a character array.
     *
     * @param in
     *            array of characters containing the string representation of
     *            this {@code BigDecimal}.
     * @throws NumberFormatException
     *             if {@code in} does not contain a valid string representation
     *             of a big decimal.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.175 -0500", hash_original_method = "2CA49E7A005F756FE298C75D3E276FBD", hash_generated_method = "4AC8B8EE73741A27E40468A1F00ADD73")
    
public BigDecimal(char[] in) {
        this(in, 0, in.length);
    }

    /**
     * Constructs a new {@code BigDecimal} instance from a string representation
     * given as a character array. The result is rounded according to the
     * specified math context.
     *
     * @param in
     *            array of characters containing the string representation of
     *            this {@code BigDecimal}.
     * @param mc
     *            rounding mode and precision for the result of this operation.
     * @throws NumberFormatException
     *             if {@code in} does not contain a valid string representation
     *             of a big decimal.
     * @throws ArithmeticException
     *             if {@code mc.precision > 0} and {@code mc.roundingMode ==
     *             UNNECESSARY} and the new big decimal cannot be represented
     *             within the given precision without rounding.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.178 -0500", hash_original_method = "24A3A809E90D8D728111B1E9DFB6AE2B", hash_generated_method = "4FF142B916F88376ADF7F1B880F61B37")
    
public BigDecimal(char[] in, MathContext mc) {
        this(in, 0, in.length);
        inplaceRound(mc);
    }

    /**
     * Constructs a new {@code BigDecimal} instance from a string
     * representation.
     *
     * @param val
     *            string containing the string representation of this {@code
     *            BigDecimal}.
     * @throws NumberFormatException
     *             if {@code val} does not contain a valid string representation
     *             of a big decimal.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.181 -0500", hash_original_method = "97883F5F25D8C2D5B9EC2501AC7ECDA2", hash_generated_method = "8A7E2F1E0BA78CDD4F6AE32E1A77DAE9")
    
public BigDecimal(String val) {
        this(val.toCharArray(), 0, val.length());
    }

    /**
     * Constructs a new {@code BigDecimal} instance from a string
     * representation. The result is rounded according to the specified math
     * context.
     *
     * @param val
     *            string containing the string representation of this {@code
     *            BigDecimal}.
     * @param mc
     *            rounding mode and precision for the result of this operation.
     * @throws NumberFormatException
     *             if {@code val} does not contain a valid string representation
     *             of a big decimal.
     * @throws ArithmeticException
     *             if {@code mc.precision > 0} and {@code mc.roundingMode ==
     *             UNNECESSARY} and the new big decimal cannot be represented
     *             within the given precision without rounding.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.184 -0500", hash_original_method = "65FA78E7CB5F82CDA77BAA4B434CD165", hash_generated_method = "D81DDA313B6CAB173D7687D7A33BFB68")
    
public BigDecimal(String val, MathContext mc) {
        this(val.toCharArray(), 0, val.length());
        inplaceRound(mc);
    }

    /**
     * Constructs a new {@code BigDecimal} instance from the 64bit double
     * {@code val}. The constructed big decimal is equivalent to the given
     * double. For example, {@code new BigDecimal(0.1)} is equal to {@code
     * 0.1000000000000000055511151231257827021181583404541015625}. This happens
     * as {@code 0.1} cannot be represented exactly in binary.
     * <p>
     * To generate a big decimal instance which is equivalent to {@code 0.1} use
     * the {@code BigDecimal(String)} constructor.
     *
     * @param val
     *            double value to be converted to a {@code BigDecimal} instance.
     * @throws NumberFormatException
     *             if {@code val} is infinity or not a number.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.188 -0500", hash_original_method = "A550123107439183BDAF78BFBC33380D", hash_generated_method = "21F06AAA0AAC6CA3F389A18FE466D483")
    
public BigDecimal(double val) {
        if (Double.isInfinite(val) || Double.isNaN(val)) {
            throw new NumberFormatException("Infinity or NaN: " + val);
        }
        long bits = Double.doubleToLongBits(val); // IEEE-754
        long mantissa;
        int trailingZeros;
        // Extracting the exponent, note that the bias is 1023
        scale = 1075 - (int)((bits >> 52) & 0x7FFL);
        // Extracting the 52 bits of the mantissa.
        mantissa = (scale == 1075) ? (bits & 0xFFFFFFFFFFFFFL) << 1
                : (bits & 0xFFFFFFFFFFFFFL) | 0x10000000000000L;
        if (mantissa == 0) {
            scale = 0;
            precision = 1;
        }
        // To simplify all factors '2' in the mantissa
        if (scale > 0) {
            trailingZeros = Math.min(scale, Long.numberOfTrailingZeros(mantissa));
            mantissa >>>= trailingZeros;
            scale -= trailingZeros;
        }
        // Calculating the new unscaled value and the new scale
        if((bits >> 63) != 0) {
            mantissa = -mantissa;
        }
        int mantissaBits = bitLength(mantissa);
        if (scale < 0) {
            bitLength = mantissaBits == 0 ? 0 : mantissaBits - scale;
            if(bitLength < 64) {
                smallValue = mantissa << (-scale);
            } else {
                BigInt bi = new BigInt();
                bi.putLongInt(mantissa);
                bi.shift(-scale);
                intVal = new BigInteger(bi);
            }
            scale = 0;
        } else if (scale > 0) {
            // m * 2^e =  (m * 5^(-e)) * 10^e
            if(scale < LONG_FIVE_POW.length
                    && mantissaBits+LONG_FIVE_POW_BIT_LENGTH[scale] < 64) {
                smallValue = mantissa * LONG_FIVE_POW[scale];
                bitLength = bitLength(smallValue);
            } else {
                setUnscaledValue(Multiplication.multiplyByFivePow(BigInteger.valueOf(mantissa), scale));
            }
        } else { // scale == 0
            smallValue = mantissa;
            bitLength = mantissaBits;
        }
    }

    /**
     * Constructs a new {@code BigDecimal} instance from the 64bit double
     * {@code val}. The constructed big decimal is equivalent to the given
     * double. For example, {@code new BigDecimal(0.1)} is equal to {@code
     * 0.1000000000000000055511151231257827021181583404541015625}. This happens
     * as {@code 0.1} cannot be represented exactly in binary.
     * <p>
     * To generate a big decimal instance which is equivalent to {@code 0.1} use
     * the {@code BigDecimal(String)} constructor.
     *
     * @param val
     *            double value to be converted to a {@code BigDecimal} instance.
     * @param mc
     *            rounding mode and precision for the result of this operation.
     * @throws NumberFormatException
     *             if {@code val} is infinity or not a number.
     * @throws ArithmeticException
     *             if {@code mc.precision > 0} and {@code mc.roundingMode ==
     *             UNNECESSARY} and the new big decimal cannot be represented
     *             within the given precision without rounding.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.191 -0500", hash_original_method = "A301A521891A68A20E545213C1CF7F7F", hash_generated_method = "E9786ABA71C9886B56D6F46B8B4947A4")
    
public BigDecimal(double val, MathContext mc) {
        this(val);
        inplaceRound(mc);
    }

    /**
     * Constructs a new {@code BigDecimal} instance from the given big integer
     * {@code val}. The scale of the result is {@code 0}.
     *
     * @param val
     *            {@code BigInteger} value to be converted to a {@code
     *            BigDecimal} instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.193 -0500", hash_original_method = "35103202AC4D8227390F065BF679C471", hash_generated_method = "B65C999537FA8174D81B17542E707877")
    
public BigDecimal(BigInteger val) {
        this(val, 0);
    }

    /**
     * Constructs a new {@code BigDecimal} instance from the given big integer
     * {@code val}. The scale of the result is {@code 0}.
     *
     * @param val
     *            {@code BigInteger} value to be converted to a {@code
     *            BigDecimal} instance.
     * @param mc
     *            rounding mode and precision for the result of this operation.
     * @throws ArithmeticException
     *             if {@code mc.precision > 0} and {@code mc.roundingMode ==
     *             UNNECESSARY} and the new big decimal cannot be represented
     *             within the given precision without rounding.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.196 -0500", hash_original_method = "4DD15F45D533F2889A2A72BE2BF675A6", hash_generated_method = "021F311C52BFAFE27D4FD77CD8BBBEA4")
    
public BigDecimal(BigInteger val, MathContext mc) {
        this(val);
        inplaceRound(mc);
    }

    /**
     * Constructs a new {@code BigDecimal} instance from a given unscaled value
     * {@code unscaledVal} and a given scale. The value of this instance is
     * {@code unscaledVal} 10^(-{@code scale}).
     *
     * @param unscaledVal
     *            {@code BigInteger} representing the unscaled value of this
     *            {@code BigDecimal} instance.
     * @param scale
     *            scale of this {@code BigDecimal} instance.
     * @throws NullPointerException
     *             if {@code unscaledVal == null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.199 -0500", hash_original_method = "E5BF86952E31D522F2FAABCF30464562", hash_generated_method = "115C2EAA40DB64ED0BDD57F24BD9C782")
    
public BigDecimal(BigInteger unscaledVal, int scale) {
        if (unscaledVal == null) {
            throw new NullPointerException();
        }
        this.scale = scale;
        setUnscaledValue(unscaledVal);
    }

    /**
     * Constructs a new {@code BigDecimal} instance from a given unscaled value
     * {@code unscaledVal} and a given scale. The value of this instance is
     * {@code unscaledVal} 10^(-{@code scale}). The result is rounded according
     * to the specified math context.
     *
     * @param unscaledVal
     *            {@code BigInteger} representing the unscaled value of this
     *            {@code BigDecimal} instance.
     * @param scale
     *            scale of this {@code BigDecimal} instance.
     * @param mc
     *            rounding mode and precision for the result of this operation.
     * @throws ArithmeticException
     *             if {@code mc.precision > 0} and {@code mc.roundingMode ==
     *             UNNECESSARY} and the new big decimal cannot be represented
     *             within the given precision without rounding.
     * @throws NullPointerException
     *             if {@code unscaledVal == null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.202 -0500", hash_original_method = "59F34EC0A04F061EC6FA9A9EFC322A4C", hash_generated_method = "8285298D80A91748B2E308D1A7BE8433")
    
public BigDecimal(BigInteger unscaledVal, int scale, MathContext mc) {
        this(unscaledVal, scale);
        inplaceRound(mc);
    }

    /**
     * Constructs a new {@code BigDecimal} instance from the given int
     * {@code val}. The scale of the result is 0.
     *
     * @param val
     *            int value to be converted to a {@code BigDecimal} instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.205 -0500", hash_original_method = "5359C9BE484C4A97ECD231D115B1BCDB", hash_generated_method = "A43CF34EEBC609AD9C787706045DDEE9")
    
public BigDecimal(int val) {
        this(val,0);
    }

    /**
     * Constructs a new {@code BigDecimal} instance from the given int {@code
     * val}. The scale of the result is {@code 0}. The result is rounded
     * according to the specified math context.
     *
     * @param val
     *            int value to be converted to a {@code BigDecimal} instance.
     * @param mc
     *            rounding mode and precision for the result of this operation.
     * @throws ArithmeticException
     *             if {@code mc.precision > 0} and {@code c.roundingMode ==
     *             UNNECESSARY} and the new big decimal cannot be represented
     *             within the given precision without rounding.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.208 -0500", hash_original_method = "919820155B3DF9AD0A8E776AC27BF824", hash_generated_method = "244D6A792EAFC43B9353B4FA0D185B13")
    
public BigDecimal(int val, MathContext mc) {
        this(val,0);
        inplaceRound(mc);
    }

    /**
     * Constructs a new {@code BigDecimal} instance from the given long {@code
     * val}. The scale of the result is {@code 0}.
     *
     * @param val
     *            long value to be converted to a {@code BigDecimal} instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.211 -0500", hash_original_method = "3B8082CDF108D6321820C9FA6A6A1D42", hash_generated_method = "059A38D1C6121517C792C0A4590EED1F")
    
public BigDecimal(long val) {
        this(val,0);
    }

    /**
     * Constructs a new {@code BigDecimal} instance from the given long {@code
     * val}. The scale of the result is {@code 0}. The result is rounded
     * according to the specified math context.
     *
     * @param val
     *            long value to be converted to a {@code BigDecimal} instance.
     * @param mc
     *            rounding mode and precision for the result of this operation.
     * @throws ArithmeticException
     *             if {@code mc.precision > 0} and {@code mc.roundingMode ==
     *             UNNECESSARY} and the new big decimal cannot be represented
     *             within the given precision without rounding.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.213 -0500", hash_original_method = "E0851629E0BD0FDB6233816479A7E4A8", hash_generated_method = "3D6ECC8BE254CA47FA1B8AEFED4EAECE")
    
public BigDecimal(long val, MathContext mc) {
        this(val);
        inplaceRound(mc);
    }

    /**
     * Returns a new {@code BigDecimal} whose value is {@code this + augend}.
     * The scale of the result is the maximum of the scales of the two
     * arguments.
     *
     * @param augend
     *            value to be added to {@code this}.
     * @return {@code this + augend}.
     * @throws NullPointerException
     *             if {@code augend == null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.225 -0500", hash_original_method = "1DCD141A7D54B6C70CB155CC6BA0AB13", hash_generated_method = "A1CC44DFE2DE860538438C2DDD6F971C")
    
public BigDecimal add(BigDecimal augend) {
        int diffScale = this.scale - augend.scale;
        // Fast return when some operand is zero
        if (this.isZero()) {
            if (diffScale <= 0) {
                return augend;
            }
            if (augend.isZero()) {
                return this;
            }
        } else if (augend.isZero()) {
            if (diffScale >= 0) {
                return this;
            }
        }
        // Let be:  this = [u1,s1]  and  augend = [u2,s2]
        if (diffScale == 0) {
            // case s1 == s2: [u1 + u2 , s1]
            if (Math.max(this.bitLength, augend.bitLength) + 1 < 64) {
                return valueOf(this.smallValue + augend.smallValue, this.scale);
            }
            return new BigDecimal(this.getUnscaledValue().add(augend.getUnscaledValue()), this.scale);
        } else if (diffScale > 0) {
            // case s1 > s2 : [(u1 + u2) * 10 ^ (s1 - s2) , s1]
            return addAndMult10(this, augend, diffScale);
        } else {// case s2 > s1 : [(u2 + u1) * 10 ^ (s2 - s1) , s2]
            return addAndMult10(augend, this, -diffScale);
        }
    }

    /**
     * Returns a new {@code BigDecimal} whose value is {@code this + augend}.
     * The result is rounded according to the passed context {@code mc}.
     *
     * @param augend
     *            value to be added to {@code this}.
     * @param mc
     *            rounding mode and precision for the result of this operation.
     * @return {@code this + augend}.
     * @throws NullPointerException
     *             if {@code augend == null} or {@code mc == null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.231 -0500", hash_original_method = "37BDD6EE07613654EB8729406017A0AF", hash_generated_method = "80FAC738473446FAD371EA1BBE419EA4")
    
public BigDecimal add(BigDecimal augend, MathContext mc) {
        BigDecimal larger; // operand with the largest unscaled value
        BigDecimal smaller; // operand with the smallest unscaled value
        BigInteger tempBI;
        long diffScale = (long)this.scale - augend.scale;
        int largerSignum;
        // Some operand is zero or the precision is infinity
        if ((augend.isZero()) || (this.isZero())
                || (mc.getPrecision() == 0)) {
            return add(augend).round(mc);
        }
        // Cases where there is room for optimizations
        if (this.approxPrecision() < diffScale - 1) {
            larger = augend;
            smaller = this;
        } else if (augend.approxPrecision() < -diffScale - 1) {
            larger = this;
            smaller = augend;
        } else {// No optimization is done
            return add(augend).round(mc);
        }
        if (mc.getPrecision() >= larger.approxPrecision()) {
            // No optimization is done
            return add(augend).round(mc);
        }
        // Cases where it's unnecessary to add two numbers with very different scales
        largerSignum = larger.signum();
        if (largerSignum == smaller.signum()) {
            tempBI = Multiplication.multiplyByPositiveInt(larger.getUnscaledValue(),10)
            .add(BigInteger.valueOf(largerSignum));
        } else {
            tempBI = larger.getUnscaledValue().subtract(
                    BigInteger.valueOf(largerSignum));
            tempBI = Multiplication.multiplyByPositiveInt(tempBI,10)
            .add(BigInteger.valueOf(largerSignum * 9));
        }
        // Rounding the improved adding
        larger = new BigDecimal(tempBI, larger.scale + 1);
        return larger.round(mc);
    }

    /**
     * Returns a new {@code BigDecimal} whose value is {@code this - subtrahend}.
     * The scale of the result is the maximum of the scales of the two arguments.
     *
     * @param subtrahend
     *            value to be subtracted from {@code this}.
     * @return {@code this - subtrahend}.
     * @throws NullPointerException
     *             if {@code subtrahend == null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.235 -0500", hash_original_method = "463B27AE9A4331C20782D4CCC2226F12", hash_generated_method = "2734D33C57E8B2121F820F66D4927122")
    
public BigDecimal subtract(BigDecimal subtrahend) {
        int diffScale = this.scale - subtrahend.scale;
        // Fast return when some operand is zero
        if (this.isZero()) {
            if (diffScale <= 0) {
                return subtrahend.negate();
            }
            if (subtrahend.isZero()) {
                return this;
            }
        } else if (subtrahend.isZero()) {
            if (diffScale >= 0) {
                return this;
            }
        }
        // Let be: this = [u1,s1] and subtrahend = [u2,s2] so:
        if (diffScale == 0) {
            // case s1 = s2 : [u1 - u2 , s1]
            if (Math.max(this.bitLength, subtrahend.bitLength) + 1 < 64) {
                return valueOf(this.smallValue - subtrahend.smallValue,this.scale);
            }
            return new BigDecimal(this.getUnscaledValue().subtract(subtrahend.getUnscaledValue()), this.scale);
        } else if (diffScale > 0) {
            // case s1 > s2 : [ u1 - u2 * 10 ^ (s1 - s2) , s1 ]
            if(diffScale < MathUtils.LONG_POWERS_OF_TEN.length &&
                    Math.max(this.bitLength,subtrahend.bitLength+LONG_POWERS_OF_TEN_BIT_LENGTH[diffScale])+1<64) {
                return valueOf(this.smallValue-subtrahend.smallValue*MathUtils.LONG_POWERS_OF_TEN[diffScale],this.scale);
            }
            return new BigDecimal(this.getUnscaledValue().subtract(
                    Multiplication.multiplyByTenPow(subtrahend.getUnscaledValue(),diffScale)), this.scale);
        } else {// case s2 > s1 : [ u1 * 10 ^ (s2 - s1) - u2 , s2 ]
            diffScale = -diffScale;
            if(diffScale < MathUtils.LONG_POWERS_OF_TEN.length &&
                    Math.max(this.bitLength+LONG_POWERS_OF_TEN_BIT_LENGTH[diffScale],subtrahend.bitLength)+1<64) {
                return valueOf(this.smallValue*MathUtils.LONG_POWERS_OF_TEN[diffScale]-subtrahend.smallValue,subtrahend.scale);
            }
            return new BigDecimal(Multiplication.multiplyByTenPow(this.getUnscaledValue(),diffScale)
            .subtract(subtrahend.getUnscaledValue()), subtrahend.scale);
        }
    }

    /**
     * Returns a new {@code BigDecimal} whose value is {@code this - subtrahend}.
     * The result is rounded according to the passed context {@code mc}.
     *
     * @param subtrahend
     *            value to be subtracted from {@code this}.
     * @param mc
     *            rounding mode and precision for the result of this operation.
     * @return {@code this - subtrahend}.
     * @throws NullPointerException
     *             if {@code subtrahend == null} or {@code mc == null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.238 -0500", hash_original_method = "427D658D2E18BC359A41906DA92107B2", hash_generated_method = "1320AADB37D8AF23B94C83AEBA55F6AE")
    
public BigDecimal subtract(BigDecimal subtrahend, MathContext mc) {
        long diffScale = subtrahend.scale - (long)this.scale;
        int thisSignum;
        BigDecimal leftOperand; // it will be only the left operand (this)
        BigInteger tempBI;
        // Some operand is zero or the precision is infinity
        if ((subtrahend.isZero()) || (this.isZero())
                || (mc.getPrecision() == 0)) {
            return subtract(subtrahend).round(mc);
        }
        // Now:   this != 0   and   subtrahend != 0
        if (subtrahend.approxPrecision() < diffScale - 1) {
            // Cases where it is unnecessary to subtract two numbers with very different scales
            if (mc.getPrecision() < this.approxPrecision()) {
                thisSignum = this.signum();
                if (thisSignum != subtrahend.signum()) {
                    tempBI = Multiplication.multiplyByPositiveInt(this.getUnscaledValue(), 10)
                    .add(BigInteger.valueOf(thisSignum));
                } else {
                    tempBI = this.getUnscaledValue().subtract(BigInteger.valueOf(thisSignum));
                    tempBI = Multiplication.multiplyByPositiveInt(tempBI, 10)
                    .add(BigInteger.valueOf(thisSignum * 9));
                }
                // Rounding the improved subtracting
                leftOperand = new BigDecimal(tempBI, this.scale + 1);
                return leftOperand.round(mc);
            }
        }
        // No optimization is done
        return subtract(subtrahend).round(mc);
    }

    /**
     * Returns a new {@code BigDecimal} whose value is {@code this *
     * multiplicand}. The scale of the result is the sum of the scales of the
     * two arguments.
     *
     * @param multiplicand
     *            value to be multiplied with {@code this}.
     * @return {@code this * multiplicand}.
     * @throws NullPointerException
     *             if {@code multiplicand == null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.240 -0500", hash_original_method = "0CD1948BD2366020AE6A84C7902D73D6", hash_generated_method = "5C491A48FEADFCE39ABE82868E1406F2")
    
public BigDecimal multiply(BigDecimal multiplicand) {
        long newScale = (long)this.scale + multiplicand.scale;

        if ((this.isZero()) || (multiplicand.isZero())) {
            return zeroScaledBy(newScale);
        }
        /* Let be: this = [u1,s1] and multiplicand = [u2,s2] so:
         * this x multiplicand = [ s1 * s2 , s1 + s2 ] */
        if(this.bitLength + multiplicand.bitLength < 64) {
            return valueOf(this.smallValue*multiplicand.smallValue, safeLongToInt(newScale));
        }
        return new BigDecimal(this.getUnscaledValue().multiply(
                multiplicand.getUnscaledValue()), safeLongToInt(newScale));
    }

    /**
     * Returns a new {@code BigDecimal} whose value is {@code this *
     * multiplicand}. The result is rounded according to the passed context
     * {@code mc}.
     *
     * @param multiplicand
     *            value to be multiplied with {@code this}.
     * @param mc
     *            rounding mode and precision for the result of this operation.
     * @return {@code this * multiplicand}.
     * @throws NullPointerException
     *             if {@code multiplicand == null} or {@code mc == null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.243 -0500", hash_original_method = "C6525DC236CD6C9B7DA82BBF840C4183", hash_generated_method = "52A1FCECF98A8C691396122D634473BB")
    
public BigDecimal multiply(BigDecimal multiplicand, MathContext mc) {
        BigDecimal result = multiply(multiplicand);

        result.inplaceRound(mc);
        return result;
    }

    /**
     * Returns a new {@code BigDecimal} whose value is {@code this / divisor}.
     * As scale of the result the parameter {@code scale} is used. If rounding
     * is required to meet the specified scale, then the specified rounding mode
     * {@code roundingMode} is applied.
     *
     * @param divisor
     *            value by which {@code this} is divided.
     * @param scale
     *            the scale of the result returned.
     * @param roundingMode
     *            rounding mode to be used to round the result.
     * @return {@code this / divisor} rounded according to the given rounding
     *         mode.
     * @throws NullPointerException
     *             if {@code divisor == null}.
     * @throws IllegalArgumentException
     *             if {@code roundingMode} is not a valid rounding mode.
     * @throws ArithmeticException
     *             if {@code divisor == 0}.
     * @throws ArithmeticException
     *             if {@code roundingMode == ROUND_UNNECESSARY} and rounding is
     *             necessary according to the given scale.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.245 -0500", hash_original_method = "462A8C7DE00EC7C78FAA3F28B925453C", hash_generated_method = "6C7A5F52403ED80085324A00698592FF")
    
public BigDecimal divide(BigDecimal divisor, int scale, int roundingMode) {
        return divide(divisor, scale, RoundingMode.valueOf(roundingMode));
    }

    /**
     * Returns a new {@code BigDecimal} whose value is {@code this / divisor}.
     * As scale of the result the parameter {@code scale} is used. If rounding
     * is required to meet the specified scale, then the specified rounding mode
     * {@code roundingMode} is applied.
     *
     * @param divisor
     *            value by which {@code this} is divided.
     * @param scale
     *            the scale of the result returned.
     * @param roundingMode
     *            rounding mode to be used to round the result.
     * @return {@code this / divisor} rounded according to the given rounding
     *         mode.
     * @throws NullPointerException
     *             if {@code divisor == null} or {@code roundingMode == null}.
     * @throws ArithmeticException
     *             if {@code divisor == 0}.
     * @throws ArithmeticException
     *             if {@code roundingMode == RoundingMode.UNNECESSAR}Y and
     *             rounding is necessary according to the given scale and given
     *             precision.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.249 -0500", hash_original_method = "CAF40474AE4670E1A6482892323F28CB", hash_generated_method = "8E41DFBCEF5D09C6638D7BC1CAB80B89")
    
public BigDecimal divide(BigDecimal divisor, int scale, RoundingMode roundingMode) {
        // Let be: this = [u1,s1]  and  divisor = [u2,s2]
        if (roundingMode == null) {
            throw new NullPointerException();
        }
        if (divisor.isZero()) {
            throw new ArithmeticException("Division by zero");
        }

        long diffScale = ((long)this.scale - divisor.scale) - scale;
        if(this.bitLength < 64 && divisor.bitLength < 64 ) {
            if(diffScale == 0) {
                return dividePrimitiveLongs(this.smallValue,
                        divisor.smallValue,
                        scale,
                        roundingMode );
            } else if(diffScale > 0) {
                if(diffScale < MathUtils.LONG_POWERS_OF_TEN.length &&
                        divisor.bitLength + LONG_POWERS_OF_TEN_BIT_LENGTH[(int)diffScale] < 64) {
                    return dividePrimitiveLongs(this.smallValue,
                            divisor.smallValue*MathUtils.LONG_POWERS_OF_TEN[(int)diffScale],
                            scale,
                            roundingMode);
                }
            } else { // diffScale < 0
                if(-diffScale < MathUtils.LONG_POWERS_OF_TEN.length &&
                        this.bitLength + LONG_POWERS_OF_TEN_BIT_LENGTH[(int)-diffScale] < 64) {
                    return dividePrimitiveLongs(this.smallValue*MathUtils.LONG_POWERS_OF_TEN[(int)-diffScale],
                            divisor.smallValue,
                            scale,
                            roundingMode);
                }

            }
        }
        BigInteger scaledDividend = this.getUnscaledValue();
        BigInteger scaledDivisor = divisor.getUnscaledValue(); // for scaling of 'u2'

        if (diffScale > 0) {
            // Multiply 'u2'  by:  10^((s1 - s2) - scale)
            scaledDivisor = Multiplication.multiplyByTenPow(scaledDivisor, (int)diffScale);
        } else if (diffScale < 0) {
            // Multiply 'u1'  by:  10^(scale - (s1 - s2))
            scaledDividend  = Multiplication.multiplyByTenPow(scaledDividend, (int)-diffScale);
        }
        return divideBigIntegers(scaledDividend, scaledDivisor, scale, roundingMode);
        }

    /**
     * Returns a new {@code BigDecimal} whose value is {@code this / divisor}.
     * The scale of the result is the scale of {@code this}. If rounding is
     * required to meet the specified scale, then the specified rounding mode
     * {@code roundingMode} is applied.
     *
     * @param divisor
     *            value by which {@code this} is divided.
     * @param roundingMode
     *            rounding mode to be used to round the result.
     * @return {@code this / divisor} rounded according to the given rounding
     *         mode.
     * @throws NullPointerException
     *             if {@code divisor == null}.
     * @throws IllegalArgumentException
     *             if {@code roundingMode} is not a valid rounding mode.
     * @throws ArithmeticException
     *             if {@code divisor == 0}.
     * @throws ArithmeticException
     *             if {@code roundingMode == ROUND_UNNECESSARY} and rounding is
     *             necessary according to the scale of this.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.258 -0500", hash_original_method = "2C6660A6ECCA62927D6A6B71E8D4804F", hash_generated_method = "13281CE06210DF139A9EA2F2D9C8C712")
    
public BigDecimal divide(BigDecimal divisor, int roundingMode) {
        return divide(divisor, scale, RoundingMode.valueOf(roundingMode));
    }

    /**
     * Returns a new {@code BigDecimal} whose value is {@code this / divisor}.
     * The scale of the result is the scale of {@code this}. If rounding is
     * required to meet the specified scale, then the specified rounding mode
     * {@code roundingMode} is applied.
     *
     * @param divisor
     *            value by which {@code this} is divided.
     * @param roundingMode
     *            rounding mode to be used to round the result.
     * @return {@code this / divisor} rounded according to the given rounding
     *         mode.
     * @throws NullPointerException
     *             if {@code divisor == null} or {@code roundingMode == null}.
     * @throws ArithmeticException
     *             if {@code divisor == 0}.
     * @throws ArithmeticException
     *             if {@code roundingMode == RoundingMode.UNNECESSARY} and
     *             rounding is necessary according to the scale of this.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.261 -0500", hash_original_method = "5F1D784ACEFAF8C3A3D46632D71C7A92", hash_generated_method = "A11F6777CF2B847BA6B6999A1D83BEB8")
    
public BigDecimal divide(BigDecimal divisor, RoundingMode roundingMode) {
        return divide(divisor, scale, roundingMode);
    }

    /**
     * Returns a new {@code BigDecimal} whose value is {@code this / divisor}.
     * The scale of the result is the difference of the scales of {@code this}
     * and {@code divisor}. If the exact result requires more digits, then the
     * scale is adjusted accordingly. For example, {@code 1/128 = 0.0078125}
     * which has a scale of {@code 7} and precision {@code 5}.
     *
     * @param divisor
     *            value by which {@code this} is divided.
     * @return {@code this / divisor}.
     * @throws NullPointerException
     *             if {@code divisor == null}.
     * @throws ArithmeticException
     *             if {@code divisor == 0}.
     * @throws ArithmeticException
     *             if the result cannot be represented exactly.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.272 -0500", hash_original_method = "A7E2E0DD5FAFAFB93C0707787850F19F", hash_generated_method = "1F0C17975A47CA0FEF73DC81D15EA38E")
    
public BigDecimal divide(BigDecimal divisor) {
        BigInteger p = this.getUnscaledValue();
        BigInteger q = divisor.getUnscaledValue();
        BigInteger gcd; // greatest common divisor between 'p' and 'q'
        BigInteger quotAndRem[];
        long diffScale = (long)scale - divisor.scale;
        int newScale; // the new scale for final quotient
        int k; // number of factors "2" in 'q'
        int l = 0; // number of factors "5" in 'q'
        int i = 1;
        int lastPow = FIVE_POW.length - 1;

        if (divisor.isZero()) {
            throw new ArithmeticException("Division by zero");
        }
        if (p.signum() == 0) {
            return zeroScaledBy(diffScale);
        }
        // To divide both by the GCD
        gcd = p.gcd(q);
        p = p.divide(gcd);
        q = q.divide(gcd);
        // To simplify all "2" factors of q, dividing by 2^k
        k = q.getLowestSetBit();
        q = q.shiftRight(k);
        // To simplify all "5" factors of q, dividing by 5^l
        do {
            quotAndRem = q.divideAndRemainder(FIVE_POW[i]);
            if (quotAndRem[1].signum() == 0) {
                l += i;
                if (i < lastPow) {
                    i++;
                }
                q = quotAndRem[0];
            } else {
                if (i == 1) {
                    break;
                }
                i = 1;
            }
        } while (true);
        // If  abs(q) != 1  then the quotient is periodic
        if (!q.abs().equals(BigInteger.ONE)) {
            throw new ArithmeticException("Non-terminating decimal expansion; no exact representable decimal result");
        }
        // The sign of the is fixed and the quotient will be saved in 'p'
        if (q.signum() < 0) {
            p = p.negate();
        }
        // Checking if the new scale is out of range
        newScale = safeLongToInt(diffScale + Math.max(k, l));
        // k >= 0  and  l >= 0  implies that  k - l  is in the 32-bit range
        i = k - l;

        p = (i > 0) ? Multiplication.multiplyByFivePow(p, i)
        : p.shiftLeft(-i);
        return new BigDecimal(p, newScale);
    }

    /**
     * Returns a new {@code BigDecimal} whose value is {@code this / divisor}.
     * The result is rounded according to the passed context {@code mc}. If the
     * passed math context specifies precision {@code 0}, then this call is
     * equivalent to {@code this.divide(divisor)}.
     *
     * @param divisor
     *            value by which {@code this} is divided.
     * @param mc
     *            rounding mode and precision for the result of this operation.
     * @return {@code this / divisor}.
     * @throws NullPointerException
     *             if {@code divisor == null} or {@code mc == null}.
     * @throws ArithmeticException
     *             if {@code divisor == 0}.
     * @throws ArithmeticException
     *             if {@code mc.getRoundingMode() == UNNECESSARY} and rounding
     *             is necessary according {@code mc.getPrecision()}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.276 -0500", hash_original_method = "E69AD17C16131904FF2F859BB6B8C3E0", hash_generated_method = "F765F5E322DA9590229DFFE04C6282D6")
    
public BigDecimal divide(BigDecimal divisor, MathContext mc) {
        /* Calculating how many zeros must be append to 'dividend'
         * to obtain a  quotient with at least 'mc.precision()' digits */
        long trailingZeros = mc.getPrecision() + 2L
                + divisor.approxPrecision() - approxPrecision();
        long diffScale = (long)scale - divisor.scale;
        long newScale = diffScale; // scale of the final quotient
        int compRem; // to compare the remainder
        int i = 1; // index
        int lastPow = TEN_POW.length - 1; // last power of ten
        BigInteger integerQuot; // for temporal results
        BigInteger quotAndRem[] = {getUnscaledValue()};
        // In special cases it reduces the problem to call the dual method
        if ((mc.getPrecision() == 0) || (this.isZero())
        || (divisor.isZero())) {
            return this.divide(divisor);
        }
        if (trailingZeros > 0) {
            // To append trailing zeros at end of dividend
            quotAndRem[0] = getUnscaledValue().multiply( Multiplication.powerOf10(trailingZeros) );
            newScale += trailingZeros;
        }
        quotAndRem = quotAndRem[0].divideAndRemainder( divisor.getUnscaledValue() );
        integerQuot = quotAndRem[0];
        // Calculating the exact quotient with at least 'mc.precision()' digits
        if (quotAndRem[1].signum() != 0) {
            // Checking if:   2 * remainder >= divisor ?
            compRem = quotAndRem[1].shiftLeftOneBit().compareTo( divisor.getUnscaledValue() );
            // quot := quot * 10 + r;     with 'r' in {-6,-5,-4, 0,+4,+5,+6}
            integerQuot = integerQuot.multiply(BigInteger.TEN)
            .add(BigInteger.valueOf(quotAndRem[0].signum() * (5 + compRem)));
            newScale++;
        } else {
            // To strip trailing zeros until the preferred scale is reached
            while (!integerQuot.testBit(0)) {
                quotAndRem = integerQuot.divideAndRemainder(TEN_POW[i]);
                if ((quotAndRem[1].signum() == 0)
                        && (newScale - i >= diffScale)) {
                    newScale -= i;
                    if (i < lastPow) {
                        i++;
                    }
                    integerQuot = quotAndRem[0];
                } else {
                    if (i == 1) {
                        break;
                    }
                    i = 1;
                }
            }
        }
        // To perform rounding
        return new BigDecimal(integerQuot, safeLongToInt(newScale), mc);
    }

    /**
     * Returns a new {@code BigDecimal} whose value is the integral part of
     * {@code this / divisor}. The quotient is rounded down towards zero to the
     * next integer. For example, {@code 0.5/0.2 = 2}.
     *
     * @param divisor
     *            value by which {@code this} is divided.
     * @return integral part of {@code this / divisor}.
     * @throws NullPointerException
     *             if {@code divisor == null}.
     * @throws ArithmeticException
     *             if {@code divisor == 0}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.279 -0500", hash_original_method = "370FC7E5A1C86319865302EB832BE460", hash_generated_method = "2F19FB5249D6D45C12D12CA0B3557CFB")
    
public BigDecimal divideToIntegralValue(BigDecimal divisor) {
        BigInteger integralValue; // the integer of result
        BigInteger powerOfTen; // some power of ten
        BigInteger quotAndRem[] = {getUnscaledValue()};
        long newScale = (long)this.scale - divisor.scale;
        long tempScale = 0;
        int i = 1;
        int lastPow = TEN_POW.length - 1;

        if (divisor.isZero()) {
            throw new ArithmeticException("Division by zero");
        }
        if ((divisor.approxPrecision() + newScale > this.approxPrecision() + 1L)
        || (this.isZero())) {
            /* If the divisor's integer part is greater than this's integer part,
             * the result must be zero with the appropriate scale */
            integralValue = BigInteger.ZERO;
        } else if (newScale == 0) {
            integralValue = getUnscaledValue().divide( divisor.getUnscaledValue() );
        } else if (newScale > 0) {
            powerOfTen = Multiplication.powerOf10(newScale);
            integralValue = getUnscaledValue().divide( divisor.getUnscaledValue().multiply(powerOfTen) );
            integralValue = integralValue.multiply(powerOfTen);
        } else {// (newScale < 0)
            powerOfTen = Multiplication.powerOf10(-newScale);
            integralValue = getUnscaledValue().multiply(powerOfTen).divide( divisor.getUnscaledValue() );
            // To strip trailing zeros approximating to the preferred scale
            while (!integralValue.testBit(0)) {
                quotAndRem = integralValue.divideAndRemainder(TEN_POW[i]);
                if ((quotAndRem[1].signum() == 0)
                        && (tempScale - i >= newScale)) {
                    tempScale -= i;
                    if (i < lastPow) {
                        i++;
                    }
                    integralValue = quotAndRem[0];
                } else {
                    if (i == 1) {
                        break;
                    }
                    i = 1;
                }
            }
            newScale = tempScale;
        }
        return ((integralValue.signum() == 0)
        ? zeroScaledBy(newScale)
                : new BigDecimal(integralValue, safeLongToInt(newScale)));
    }

    /**
     * Returns a new {@code BigDecimal} whose value is the integral part of
     * {@code this / divisor}. The quotient is rounded down towards zero to the
     * next integer. The rounding mode passed with the parameter {@code mc} is
     * not considered. But if the precision of {@code mc > 0} and the integral
     * part requires more digits, then an {@code ArithmeticException} is thrown.
     *
     * @param divisor
     *            value by which {@code this} is divided.
     * @param mc
     *            math context which determines the maximal precision of the
     *            result.
     * @return integral part of {@code this / divisor}.
     * @throws NullPointerException
     *             if {@code divisor == null} or {@code mc == null}.
     * @throws ArithmeticException
     *             if {@code divisor == 0}.
     * @throws ArithmeticException
     *             if {@code mc.getPrecision() > 0} and the result requires more
     *             digits to be represented.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.283 -0500", hash_original_method = "15ECC758BA9BF5EB2D64CC984DE4A4C9", hash_generated_method = "011ACBACE693B1E02D307BCE345A0CFC")
    
public BigDecimal divideToIntegralValue(BigDecimal divisor, MathContext mc) {
        int mcPrecision = mc.getPrecision();
        int diffPrecision = this.precision() - divisor.precision();
        int lastPow = TEN_POW.length - 1;
        long diffScale = (long)this.scale - divisor.scale;
        long newScale = diffScale;
        long quotPrecision = diffPrecision - diffScale + 1;
        BigInteger quotAndRem[] = new BigInteger[2];
        // In special cases it call the dual method
        if ((mcPrecision == 0) || (this.isZero()) || (divisor.isZero())) {
            return this.divideToIntegralValue(divisor);
        }
        // Let be:   this = [u1,s1]   and   divisor = [u2,s2]
        if (quotPrecision <= 0) {
            quotAndRem[0] = BigInteger.ZERO;
        } else if (diffScale == 0) {
            // CASE s1 == s2:  to calculate   u1 / u2
            quotAndRem[0] = this.getUnscaledValue().divide( divisor.getUnscaledValue() );
        } else if (diffScale > 0) {
            // CASE s1 >= s2:  to calculate   u1 / (u2 * 10^(s1-s2)
            quotAndRem[0] = this.getUnscaledValue().divide(
                    divisor.getUnscaledValue().multiply(Multiplication.powerOf10(diffScale)) );
            // To chose  10^newScale  to get a quotient with at least 'mc.precision()' digits
            newScale = Math.min(diffScale, Math.max(mcPrecision - quotPrecision + 1, 0));
            // To calculate: (u1 / (u2 * 10^(s1-s2)) * 10^newScale
            quotAndRem[0] = quotAndRem[0].multiply(Multiplication.powerOf10(newScale));
        } else {// CASE s2 > s1:
            /* To calculate the minimum power of ten, such that the quotient
             *   (u1 * 10^exp) / u2   has at least 'mc.precision()' digits. */
            long exp = Math.min(-diffScale, Math.max((long)mcPrecision - diffPrecision, 0));
            long compRemDiv;
            // Let be:   (u1 * 10^exp) / u2 = [q,r]
            quotAndRem = this.getUnscaledValue().multiply(Multiplication.powerOf10(exp)).
                    divideAndRemainder(divisor.getUnscaledValue());
            newScale += exp; // To fix the scale
            exp = -newScale; // The remaining power of ten
            // If after division there is a remainder...
            if ((quotAndRem[1].signum() != 0) && (exp > 0)) {
                // Log10(r) + ((s2 - s1) - exp) > mc.precision ?
                compRemDiv = (new BigDecimal(quotAndRem[1])).precision()
                + exp - divisor.precision();
                if (compRemDiv == 0) {
                    // To calculate:  (r * 10^exp2) / u2
                    quotAndRem[1] = quotAndRem[1].multiply(Multiplication.powerOf10(exp)).
                            divide(divisor.getUnscaledValue());
                    compRemDiv = Math.abs(quotAndRem[1].signum());
                }
                if (compRemDiv > 0) {
                    throw new ArithmeticException("Division impossible");
                }
            }
        }
        // Fast return if the quotient is zero
        if (quotAndRem[0].signum() == 0) {
            return zeroScaledBy(diffScale);
        }
        BigInteger strippedBI = quotAndRem[0];
        BigDecimal integralValue = new BigDecimal(quotAndRem[0]);
        long resultPrecision = integralValue.precision();
        int i = 1;
        // To strip trailing zeros until the specified precision is reached
        while (!strippedBI.testBit(0)) {
            quotAndRem = strippedBI.divideAndRemainder(TEN_POW[i]);
            if ((quotAndRem[1].signum() == 0) &&
                    ((resultPrecision - i >= mcPrecision)
                    || (newScale - i >= diffScale)) ) {
                resultPrecision -= i;
                newScale -= i;
                if (i < lastPow) {
                    i++;
                }
                strippedBI = quotAndRem[0];
            } else {
                if (i == 1) {
                    break;
                }
                i = 1;
            }
        }
        // To check if the result fit in 'mc.precision()' digits
        if (resultPrecision > mcPrecision) {
            throw new ArithmeticException("Division impossible");
        }
        integralValue.scale = safeLongToInt(newScale);
        integralValue.setUnscaledValue(strippedBI);
        return integralValue;
    }

    /**
     * Returns a new {@code BigDecimal} whose value is {@code this % divisor}.
     * <p>
     * The remainder is defined as {@code this -
     * this.divideToIntegralValue(divisor) * divisor}.
     *
     * @param divisor
     *            value by which {@code this} is divided.
     * @return {@code this % divisor}.
     * @throws NullPointerException
     *             if {@code divisor == null}.
     * @throws ArithmeticException
     *             if {@code divisor == 0}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.285 -0500", hash_original_method = "EBDBD1FB251B2EF1CF76CA97862E098F", hash_generated_method = "AB69E7BF707C97D5E6B9E9048F53ED2E")
    
public BigDecimal remainder(BigDecimal divisor) {
        return divideAndRemainder(divisor)[1];
    }

    /**
     * Returns a new {@code BigDecimal} whose value is {@code this % divisor}.
     * <p>
     * The remainder is defined as {@code this -
     * this.divideToIntegralValue(divisor) * divisor}.
     * <p>
     * The specified rounding mode {@code mc} is used for the division only.
     *
     * @param divisor
     *            value by which {@code this} is divided.
     * @param mc
     *            rounding mode and precision to be used.
     * @return {@code this % divisor}.
     * @throws NullPointerException
     *             if {@code divisor == null}.
     * @throws ArithmeticException
     *             if {@code divisor == 0}.
     * @throws ArithmeticException
     *             if {@code mc.getPrecision() > 0} and the result of {@code
     *             this.divideToIntegralValue(divisor, mc)} requires more digits
     *             to be represented.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.288 -0500", hash_original_method = "B5D8082AFBB8A8B7919238963079BE8E", hash_generated_method = "4E21F5572C26DDBE9DDC6EE648EC9748")
    
public BigDecimal remainder(BigDecimal divisor, MathContext mc) {
        return divideAndRemainder(divisor, mc)[1];
    }

    /**
     * Returns a {@code BigDecimal} array which contains the integral part of
     * {@code this / divisor} at index 0 and the remainder {@code this %
     * divisor} at index 1. The quotient is rounded down towards zero to the
     * next integer.
     *
     * @param divisor
     *            value by which {@code this} is divided.
     * @return {@code [this.divideToIntegralValue(divisor),
     *         this.remainder(divisor)]}.
     * @throws NullPointerException
     *             if {@code divisor == null}.
     * @throws ArithmeticException
     *             if {@code divisor == 0}.
     * @see #divideToIntegralValue
     * @see #remainder
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.291 -0500", hash_original_method = "078854E5024F03E2C96ABDC15A98EC28", hash_generated_method = "95F5EC5C0624C1DFAF0EBCCED0C95990")
    
public BigDecimal[] divideAndRemainder(BigDecimal divisor) {
        BigDecimal quotAndRem[] = new BigDecimal[2];

        quotAndRem[0] = this.divideToIntegralValue(divisor);
        quotAndRem[1] = this.subtract( quotAndRem[0].multiply(divisor) );
        return quotAndRem;
    }

    /**
     * Returns a {@code BigDecimal} array which contains the integral part of
     * {@code this / divisor} at index 0 and the remainder {@code this %
     * divisor} at index 1. The quotient is rounded down towards zero to the
     * next integer. The rounding mode passed with the parameter {@code mc} is
     * not considered. But if the precision of {@code mc > 0} and the integral
     * part requires more digits, then an {@code ArithmeticException} is thrown.
     *
     * @param divisor
     *            value by which {@code this} is divided.
     * @param mc
     *            math context which determines the maximal precision of the
     *            result.
     * @return {@code [this.divideToIntegralValue(divisor),
     *         this.remainder(divisor)]}.
     * @throws NullPointerException
     *             if {@code divisor == null}.
     * @throws ArithmeticException
     *             if {@code divisor == 0}.
     * @see #divideToIntegralValue
     * @see #remainder
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.293 -0500", hash_original_method = "36D2BD3305B7DD5EA1226F88EE4D6B60", hash_generated_method = "96881AA2D33E5764CBEF7A18A067F51B")
    
public BigDecimal[] divideAndRemainder(BigDecimal divisor, MathContext mc) {
        BigDecimal quotAndRem[] = new BigDecimal[2];

        quotAndRem[0] = this.divideToIntegralValue(divisor, mc);
        quotAndRem[1] = this.subtract( quotAndRem[0].multiply(divisor) );
        return quotAndRem;
    }

    /**
     * Returns a new {@code BigDecimal} whose value is {@code this ^ n}. The
     * scale of the result is {@code n} times the scales of {@code this}.
     * <p>
     * {@code x.pow(0)} returns {@code 1}, even if {@code x == 0}.
     * <p>
     * Implementation Note: The implementation is based on the ANSI standard
     * X3.274-1996 algorithm.
     *
     * @param n
     *            exponent to which {@code this} is raised.
     * @return {@code this ^ n}.
     * @throws ArithmeticException
     *             if {@code n < 0} or {@code n > 999999999}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.296 -0500", hash_original_method = "0BA2A5CD46D450D69AC19365E08D7C5C", hash_generated_method = "25E358A0E55FC38F39ED177E74617051")
    
public BigDecimal pow(int n) {
        if (n == 0) {
            return ONE;
        }
        if ((n < 0) || (n > 999999999)) {
            throw new ArithmeticException("Invalid operation");
        }
        long newScale = scale * (long)n;
        // Let be: this = [u,s]   so:  this^n = [u^n, s*n]
        return isZero() ? zeroScaledBy(newScale)
                : new BigDecimal(getUnscaledValue().pow(n), safeLongToInt(newScale));
    }

    /**
     * Returns a new {@code BigDecimal} whose value is {@code this ^ n}. The
     * result is rounded according to the passed context {@code mc}.
     * <p>
     * Implementation Note: The implementation is based on the ANSI standard
     * X3.274-1996 algorithm.
     *
     * @param n
     *            exponent to which {@code this} is raised.
     * @param mc
     *            rounding mode and precision for the result of this operation.
     * @return {@code this ^ n}.
     * @throws ArithmeticException
     *             if {@code n < 0} or {@code n > 999999999}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.300 -0500", hash_original_method = "C8938AEDE89231C5AAB8CE41C7A1DE59", hash_generated_method = "18223D9F3EF2BF4C360117304A880604")
    
public BigDecimal pow(int n, MathContext mc) {
        // The ANSI standard X3.274-1996 algorithm
        int m = Math.abs(n);
        int mcPrecision = mc.getPrecision();
        int elength = (int)Math.log10(m) + 1;   // decimal digits in 'n'
        int oneBitMask; // mask of bits
        BigDecimal accum; // the single accumulator
        MathContext newPrecision = mc; // MathContext by default

        // In particular cases, it reduces the problem to call the other 'pow()'
        if ((n == 0) || ((isZero()) && (n > 0))) {
            return pow(n);
        }
        if ((m > 999999999) || ((mcPrecision == 0) && (n < 0))
                || ((mcPrecision > 0) && (elength > mcPrecision))) {
            throw new ArithmeticException("Invalid operation");
        }
        if (mcPrecision > 0) {
            newPrecision = new MathContext( mcPrecision + elength + 1,
                    mc.getRoundingMode());
        }
        // The result is calculated as if 'n' were positive
        accum = round(newPrecision);
        oneBitMask = Integer.highestOneBit(m) >> 1;

        while (oneBitMask > 0) {
            accum = accum.multiply(accum, newPrecision);
            if ((m & oneBitMask) == oneBitMask) {
                accum = accum.multiply(this, newPrecision);
            }
            oneBitMask >>= 1;
        }
        // If 'n' is negative, the value is divided into 'ONE'
        if (n < 0) {
            accum = ONE.divide(accum, newPrecision);
        }
        // The final value is rounded to the destination precision
        accum.inplaceRound(mc);
        return accum;
    }

    /**
     * Returns a new {@code BigDecimal} whose value is the absolute value of
     * {@code this}. The scale of the result is the same as the scale of this.
     *
     * @return {@code abs(this)}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.302 -0500", hash_original_method = "DF1CB3D65F2CAE136A2978BF9C5604B4", hash_generated_method = "4358A16DCF011550343A5FC8F0CA9D4A")
    
public BigDecimal abs() {
        return ((signum() < 0) ? negate() : this);
    }

    /**
     * Returns a new {@code BigDecimal} whose value is the absolute value of
     * {@code this}. The result is rounded according to the passed context
     * {@code mc}.
     *
     * @param mc
     *            rounding mode and precision for the result of this operation.
     * @return {@code abs(this)}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.304 -0500", hash_original_method = "BC934B9214C4819E6720F567E9C870B9", hash_generated_method = "6FEE03E6A8452AEAF7F666FC73BA2FFE")
    
public BigDecimal abs(MathContext mc) {
        BigDecimal result = abs();
        result.inplaceRound(mc);
        return result;
    }

    /**
     * Returns a new {@code BigDecimal} whose value is the {@code -this}. The
     * scale of the result is the same as the scale of this.
     *
     * @return {@code -this}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.307 -0500", hash_original_method = "434D4E2CBF9E3CBC75126AF4586B2CF0", hash_generated_method = "87F17B3831C0BC1042D691FEA8A8F24E")
    
public BigDecimal negate() {
        if(bitLength < 63 || (bitLength == 63 && smallValue!=Long.MIN_VALUE)) {
            return valueOf(-smallValue,scale);
        }
        return new BigDecimal(getUnscaledValue().negate(), scale);
    }

    /**
     * Returns a new {@code BigDecimal} whose value is the {@code -this}. The
     * result is rounded according to the passed context {@code mc}.
     *
     * @param mc
     *            rounding mode and precision for the result of this operation.
     * @return {@code -this}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.309 -0500", hash_original_method = "1D24791EE4ADD6E04558F8C92319E898", hash_generated_method = "D3AC0378F8C5F18782A745AA8B2E039D")
    
public BigDecimal negate(MathContext mc) {
        BigDecimal result = negate();
        result.inplaceRound(mc);
        return result;
    }

    /**
     * Returns a new {@code BigDecimal} whose value is {@code +this}. The scale
     * of the result is the same as the scale of this.
     *
     * @return {@code this}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.311 -0500", hash_original_method = "E5A0BEEECFDAB0EB24F23ED92FDA1EE0", hash_generated_method = "7F40BB81175E92CA68ADFEEF6FCDEC73")
    
public BigDecimal plus() {
        return this;
    }

    /**
     * Returns a new {@code BigDecimal} whose value is {@code +this}. The result
     * is rounded according to the passed context {@code mc}.
     *
     * @param mc
     *            rounding mode and precision for the result of this operation.
     * @return {@code this}, rounded
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.314 -0500", hash_original_method = "06DE611812CE14E42B61206CBE361795", hash_generated_method = "6B61789A5B5B2DA5B7E2A04DD45154AD")
    
public BigDecimal plus(MathContext mc) {
        return round(mc);
    }

    /**
     * Returns the sign of this {@code BigDecimal}.
     *
     * @return {@code -1} if {@code this < 0},
     *         {@code 0} if {@code this == 0},
     *         {@code 1} if {@code this > 0}.     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.316 -0500", hash_original_method = "CA4E5917AFEF32459FAB7B79AFDA8BD4", hash_generated_method = "4DBB12AF7DE147BE0A03C552985E5DC1")
    
public int signum() {
        if( bitLength < 64) {
            return Long.signum( this.smallValue );
        }
        return getUnscaledValue().signum();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.319 -0500", hash_original_method = "F3E74BAAEB162D78F28E445308393563", hash_generated_method = "2BCD342721AE558B0DD72466E06E93D1")
    
private boolean isZero() {
        //Watch out: -1 has a bitLength=0
        return bitLength == 0 && this.smallValue != -1;
    }

    /**
     * Returns the scale of this {@code BigDecimal}. The scale is the number of
     * digits behind the decimal point. The value of this {@code BigDecimal} is
     * the unsignedValue * 10^(-scale). If the scale is negative, then this
     * {@code BigDecimal} represents a big integer.
     *
     * @return the scale of this {@code BigDecimal}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.321 -0500", hash_original_method = "5F6F67A9AE4AEECC5BD64D7ACC145B6A", hash_generated_method = "B158333277170B3A0321DD3B71C3A01D")
    
public int scale() {
        return scale;
    }

    /**
     * Returns the precision of this {@code BigDecimal}. The precision is the
     * number of decimal digits used to represent this decimal. It is equivalent
     * to the number of digits of the unscaled value. The precision of {@code 0}
     * is {@code 1} (independent of the scale).
     *
     * @return the precision of this {@code BigDecimal}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.324 -0500", hash_original_method = "6DFBDD0E771CAF738A0C801E888E1E3B", hash_generated_method = "C38299C41AB0EFACD90A3DEB330E8D64")
    
public int precision() {
        // Checking if the precision already was calculated
        if (precision > 0) {
            return precision;
        }

        int bitLength = this.bitLength;

        if (bitLength == 0) {
            precision = 1;
        } else if (bitLength < 64) {
            precision = decimalDigitsInLong(smallValue);
        } else {
            int decimalDigits = 1 + (int) ((bitLength - 1) * LOG10_2);
            // If after division the number isn't zero, there exists an additional digit
            if (getUnscaledValue().divide(Multiplication.powerOf10(decimalDigits)).signum() != 0) {
                decimalDigits++;
            }
            precision = decimalDigits;
        }
        return precision;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.326 -0500", hash_original_method = "EAD040D94F5F819E555B537F69E87C66", hash_generated_method = "F60221B654271D80FB8BDE0D14AFD145")
    
private int decimalDigitsInLong(long value) {
        if (value == Long.MIN_VALUE) {
            return 19; // special case required because abs(MIN_VALUE) == MIN_VALUE
        } else {
            int index = Arrays.binarySearch(MathUtils.LONG_POWERS_OF_TEN, Math.abs(value));
            return (index < 0) ? (-index - 1) : (index + 1);
        }
    }

    /**
     * Returns the unscaled value (mantissa) of this {@code BigDecimal} instance
     * as a {@code BigInteger}. The unscaled value can be computed as {@code
     * this} 10^(scale).
     *
     * @return unscaled value (this * 10^(scale)).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.328 -0500", hash_original_method = "067DA515CBCF3B72C5546CE6034B99CF", hash_generated_method = "B45B8C228515EC5B5F844E259B43D7A8")
    
public BigInteger unscaledValue() {
        return getUnscaledValue();
    }

    /**
     * Returns a new {@code BigDecimal} whose value is {@code this}, rounded
     * according to the passed context {@code mc}.
     * <p>
     * If {@code mc.precision = 0}, then no rounding is performed.
     * <p>
     * If {@code mc.precision > 0} and {@code mc.roundingMode == UNNECESSARY},
     * then an {@code ArithmeticException} is thrown if the result cannot be
     * represented exactly within the given precision.
     *
     * @param mc
     *            rounding mode and precision for the result of this operation.
     * @return {@code this} rounded according to the passed context.
     * @throws ArithmeticException
     *             if {@code mc.precision > 0} and {@code mc.roundingMode ==
     *             UNNECESSARY} and this cannot be represented within the given
     *             precision.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.330 -0500", hash_original_method = "2FC46B1D06394AF066FA7CDA852A22F8", hash_generated_method = "62B403C0FFEDBC4570040CA6FE4782B8")
    
public BigDecimal round(MathContext mc) {
        BigDecimal thisBD = new BigDecimal(getUnscaledValue(), scale);

        thisBD.inplaceRound(mc);
        return thisBD;
    }

    /**
     * Returns a new {@code BigDecimal} instance with the specified scale.
     * <p>
     * If the new scale is greater than the old scale, then additional zeros are
     * added to the unscaled value. In this case no rounding is necessary.
     * <p>
     * If the new scale is smaller than the old scale, then trailing digits are
     * removed. If these trailing digits are not zero, then the remaining
     * unscaled value has to be rounded. For this rounding operation the
     * specified rounding mode is used.
     *
     * @param newScale
     *            scale of the result returned.
     * @param roundingMode
     *            rounding mode to be used to round the result.
     * @return a new {@code BigDecimal} instance with the specified scale.
     * @throws NullPointerException
     *             if {@code roundingMode == null}.
     * @throws ArithmeticException
     *             if {@code roundingMode == ROUND_UNNECESSARY} and rounding is
     *             necessary according to the given scale.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.333 -0500", hash_original_method = "7B0F1A102C68137F597240860B4573E3", hash_generated_method = "1251547CE725D247880878D8861F2E24")
    
public BigDecimal setScale(int newScale, RoundingMode roundingMode) {
        if (roundingMode == null) {
            throw new NullPointerException();
        }
        long diffScale = newScale - (long)scale;
        // Let be:  'this' = [u,s]
        if(diffScale == 0) {
            return this;
        }
        if(diffScale > 0) {
        // return  [u * 10^(s2 - s), newScale]
            if(diffScale < MathUtils.LONG_POWERS_OF_TEN.length &&
                    (this.bitLength + LONG_POWERS_OF_TEN_BIT_LENGTH[(int)diffScale]) < 64 ) {
                return valueOf(this.smallValue*MathUtils.LONG_POWERS_OF_TEN[(int)diffScale],newScale);
            }
            return new BigDecimal(Multiplication.multiplyByTenPow(getUnscaledValue(),(int)diffScale), newScale);
        }
        // diffScale < 0
        // return  [u,s] / [1,newScale]  with the appropriate scale and rounding
        if(this.bitLength < 64 && -diffScale < MathUtils.LONG_POWERS_OF_TEN.length) {
            return dividePrimitiveLongs(this.smallValue, MathUtils.LONG_POWERS_OF_TEN[(int)-diffScale], newScale,roundingMode);
        }
        return divideBigIntegers(this.getUnscaledValue(),Multiplication.powerOf10(-diffScale),newScale,roundingMode);
    }

    /**
     * Returns a new {@code BigDecimal} instance with the specified scale.
     * <p>
     * If the new scale is greater than the old scale, then additional zeros are
     * added to the unscaled value. In this case no rounding is necessary.
     * <p>
     * If the new scale is smaller than the old scale, then trailing digits are
     * removed. If these trailing digits are not zero, then the remaining
     * unscaled value has to be rounded. For this rounding operation the
     * specified rounding mode is used.
     *
     * @param newScale
     *            scale of the result returned.
     * @param roundingMode
     *            rounding mode to be used to round the result.
     * @return a new {@code BigDecimal} instance with the specified scale.
     * @throws IllegalArgumentException
     *             if {@code roundingMode} is not a valid rounding mode.
     * @throws ArithmeticException
     *             if {@code roundingMode == ROUND_UNNECESSARY} and rounding is
     *             necessary according to the given scale.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.336 -0500", hash_original_method = "82E5CBCA5195979E97780CEADBFBD3C4", hash_generated_method = "1F01152117CE8A68F2CE84AFB39BC354")
    
public BigDecimal setScale(int newScale, int roundingMode) {
        return setScale(newScale, RoundingMode.valueOf(roundingMode));
    }

    /**
     * Returns a new {@code BigDecimal} instance with the specified scale. If
     * the new scale is greater than the old scale, then additional zeros are
     * added to the unscaled value. If the new scale is smaller than the old
     * scale, then trailing zeros are removed. If the trailing digits are not
     * zeros then an ArithmeticException is thrown.
     * <p>
     * If no exception is thrown, then the following equation holds: {@code
     * x.setScale(s).compareTo(x) == 0}.
     *
     * @param newScale
     *            scale of the result returned.
     * @return a new {@code BigDecimal} instance with the specified scale.
     * @throws ArithmeticException
     *             if rounding would be necessary.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.339 -0500", hash_original_method = "ABCD452F1FC16ADBD3F58023EF098557", hash_generated_method = "E8ED73193568A0B44AEC00A62500D3AB")
    
public BigDecimal setScale(int newScale) {
        return setScale(newScale, RoundingMode.UNNECESSARY);
    }

    /**
     * Returns a new {@code BigDecimal} instance where the decimal point has
     * been moved {@code n} places to the left. If {@code n < 0} then the
     * decimal point is moved {@code -n} places to the right.
     * <p>
     * The result is obtained by changing its scale. If the scale of the result
     * becomes negative, then its precision is increased such that the scale is
     * zero.
     * <p>
     * Note, that {@code movePointLeft(0)} returns a result which is
     * mathematically equivalent, but which has {@code scale >= 0}.
     *
     * @param n
     *            number of placed the decimal point has to be moved.
     * @return {@code this * 10^(-n}).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.342 -0500", hash_original_method = "146C1C6822DF31E0F5C90B0C65347C9D", hash_generated_method = "4713584E466523900457042FCB2F3E55")
    
public BigDecimal movePointLeft(int n) {
        return movePoint(scale + (long)n);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.344 -0500", hash_original_method = "EF6481821B33DB93DBF91CDB78772ACF", hash_generated_method = "2BC2E099FA195247465E4408C93C222B")
    
private BigDecimal movePoint(long newScale) {
        if (isZero()) {
            return zeroScaledBy(Math.max(newScale, 0));
        }
        /*
         * When: 'n'== Integer.MIN_VALUE isn't possible to call to
         * movePointRight(-n) since -Integer.MIN_VALUE == Integer.MIN_VALUE
         */
        if(newScale >= 0) {
            if(bitLength < 64) {
                return valueOf(smallValue, safeLongToInt(newScale));
            }
            return new BigDecimal(getUnscaledValue(), safeLongToInt(newScale));
        }
        if(-newScale < MathUtils.LONG_POWERS_OF_TEN.length &&
                bitLength + LONG_POWERS_OF_TEN_BIT_LENGTH[(int)-newScale] < 64 ) {
            return valueOf(smallValue*MathUtils.LONG_POWERS_OF_TEN[(int)-newScale],0);
        }
        return new BigDecimal(Multiplication.multiplyByTenPow(
                getUnscaledValue(), safeLongToInt(-newScale)), 0);
    }

    /**
     * Returns a new {@code BigDecimal} instance where the decimal point has
     * been moved {@code n} places to the right. If {@code n < 0} then the
     * decimal point is moved {@code -n} places to the left.
     * <p>
     * The result is obtained by changing its scale. If the scale of the result
     * becomes negative, then its precision is increased such that the scale is
     * zero.
     * <p>
     * Note, that {@code movePointRight(0)} returns a result which is
     * mathematically equivalent, but which has scale >= 0.
     *
     * @param n
     *            number of placed the decimal point has to be moved.
     * @return {@code this * 10^n}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.347 -0500", hash_original_method = "07D5C3611C3ACCF090DC6103621F9345", hash_generated_method = "663A838C1DB631F9E734F605CD440991")
    
public BigDecimal movePointRight(int n) {
        return movePoint(scale - (long)n);
    }

    /**
     * Returns a new {@code BigDecimal} whose value is {@code this} 10^{@code n}.
     * The scale of the result is {@code this.scale()} - {@code n}.
     * The precision of the result is the precision of {@code this}.
     * <p>
     * This method has the same effect as {@link #movePointRight}, except that
     * the precision is not changed.
     *
     * @param n
     *            number of places the decimal point has to be moved.
     * @return {@code this * 10^n}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.349 -0500", hash_original_method = "D86719E7E7F9F283B32E5780DA0BBE23", hash_generated_method = "9C622986FD776E9A6A5BDECA62A856D0")
    
public BigDecimal scaleByPowerOfTen(int n) {
        long newScale = scale - (long)n;
        if(bitLength < 64) {
            //Taking care when a 0 is to be scaled
            if( smallValue==0  ){
                return zeroScaledBy( newScale );
            }
            return valueOf(smallValue, safeLongToInt(newScale));
        }
        return new BigDecimal(getUnscaledValue(), safeLongToInt(newScale));
    }

    /**
     * Returns a new {@code BigDecimal} instance with the same value as {@code
     * this} but with a unscaled value where the trailing zeros have been
     * removed. If the unscaled value of {@code this} has n trailing zeros, then
     * the scale and the precision of the result has been reduced by n.
     *
     * @return a new {@code BigDecimal} instance equivalent to this where the
     *         trailing zeros of the unscaled value have been removed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.352 -0500", hash_original_method = "6A410D70691999CADF96A81B91BD2E64", hash_generated_method = "DDC4B67999A47862066557831C042146")
    
public BigDecimal stripTrailingZeros() {
        int i = 1; // 1 <= i <= 18
        int lastPow = TEN_POW.length - 1;
        long newScale = scale;

        if (isZero()) {
            // Preserve RI compatibility, so BigDecimal.equals (which checks
            // value *and* scale) continues to work.
            return this;
        }
        BigInteger strippedBI = getUnscaledValue();
        BigInteger[] quotAndRem;

        // while the number is even...
        while (!strippedBI.testBit(0)) {
            // To divide by 10^i
            quotAndRem = strippedBI.divideAndRemainder(TEN_POW[i]);
            // To look the remainder
            if (quotAndRem[1].signum() == 0) {
                // To adjust the scale
                newScale -= i;
                if (i < lastPow) {
                    // To set to the next power
                    i++;
                }
                strippedBI = quotAndRem[0];
            } else {
                if (i == 1) {
                    // 'this' has no more trailing zeros
                    break;
                }
                // To set to the smallest power of ten
                i = 1;
            }
        }
        return new BigDecimal(strippedBI, safeLongToInt(newScale));
    }

    /**
     * Compares this {@code BigDecimal} with {@code val}. Returns one of the
     * three values {@code 1}, {@code 0}, or {@code -1}. The method behaves as
     * if {@code this.subtract(val)} is computed. If this difference is > 0 then
     * 1 is returned, if the difference is < 0 then -1 is returned, and if the
     * difference is 0 then 0 is returned. This means, that if two decimal
     * instances are compared which are equal in value but differ in scale, then
     * these two instances are considered as equal.
     *
     * @param val
     *            value to be compared with {@code this}.
     * @return {@code 1} if {@code this > val}, {@code -1} if {@code this < val},
     *         {@code 0} if {@code this == val}.
     * @throws NullPointerException
     *             if {@code val == null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.355 -0500", hash_original_method = "1C45ED34C4C1F5BEBD8BB8EF3CBE1A6B", hash_generated_method = "1695AC05EBFF1DFDEC554390AEF57837")
    
public int compareTo(BigDecimal val) {
        int thisSign = signum();
        int valueSign = val.signum();

        if( thisSign == valueSign) {
            if(this.scale == val.scale && this.bitLength<64 && val.bitLength<64 ) {
                return (smallValue < val.smallValue) ? -1 : (smallValue > val.smallValue) ? 1 : 0;
            }
            long diffScale = (long)this.scale - val.scale;
            int diffPrecision = this.approxPrecision() - val.approxPrecision();
            if (diffPrecision > diffScale + 1) {
                return thisSign;
            } else if (diffPrecision < diffScale - 1) {
                return -thisSign;
            } else {// thisSign == val.signum()  and  diffPrecision is aprox. diffScale
                BigInteger thisUnscaled = this.getUnscaledValue();
                BigInteger valUnscaled = val.getUnscaledValue();
                // If any of both precision is bigger, append zeros to the shorter one
                if (diffScale < 0) {
                    thisUnscaled = thisUnscaled.multiply(Multiplication.powerOf10(-diffScale));
                } else if (diffScale > 0) {
                    valUnscaled = valUnscaled.multiply(Multiplication.powerOf10(diffScale));
                }
                return thisUnscaled.compareTo(valUnscaled);
            }
        } else if (thisSign < valueSign) {
            return -1;
        } else  {
            return 1;
        }
    }

    /**
     * Returns {@code true} if {@code x} is a {@code BigDecimal} instance and if
     * this instance is equal to this big decimal. Two big decimals are equal if
     * their unscaled value and their scale is equal. For example, 1.0
     * (10*10^(-1)) is not equal to 1.00 (100*10^(-2)). Similarly, zero
     * instances are not equal if their scale differs.
     *
     * @param x
     *            object to be compared with {@code this}.
     * @return true if {@code x} is a {@code BigDecimal} and {@code this == x}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.358 -0500", hash_original_method = "310E755E039C5525B03EE3C0A35D27A8", hash_generated_method = "852B71EA9B73031C580A43D11F197A7C")
    
@Override
    public boolean equals(Object x) {
        if (this == x) {
            return true;
        }
        if (x instanceof BigDecimal) {
            BigDecimal x1 = (BigDecimal) x;
            return x1.scale == scale
                   && (bitLength < 64 ? (x1.smallValue == smallValue)
                    : intVal.equals(x1.intVal));


        }
        return false;
    }

    /**
     * Returns the minimum of this {@code BigDecimal} and {@code val}.
     *
     * @param val
     *            value to be used to compute the minimum with this.
     * @return {@code min(this, val}.
     * @throws NullPointerException
     *             if {@code val == null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.360 -0500", hash_original_method = "F19ED99F66E082325A61ACA186AF7454", hash_generated_method = "B5C322E27F4A2821E47AB8C9C3381577")
    
public BigDecimal min(BigDecimal val) {
        return ((compareTo(val) <= 0) ? this : val);
    }

    /**
     * Returns the maximum of this {@code BigDecimal} and {@code val}.
     *
     * @param val
     *            value to be used to compute the maximum with this.
     * @return {@code max(this, val}.
     * @throws NullPointerException
     *             if {@code val == null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.363 -0500", hash_original_method = "4EA6A2C4CEA295044D603E0ACE9B5BC6", hash_generated_method = "A8A3E4227932E5E2F4E68F9FE8867014")
    
public BigDecimal max(BigDecimal val) {
        return ((compareTo(val) >= 0) ? this : val);
    }

    /**
     * Returns a hash code for this {@code BigDecimal}.
     *
     * @return hash code for {@code this}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.366 -0500", hash_original_method = "F20F131BB03F0B25B12A1EF1F413017D", hash_generated_method = "8704A94867026972F3E4DA16D3DB25FD")
    
@Override
    public int hashCode() {
        if (hashCode != 0) {
            return hashCode;
        }
        if (bitLength < 64) {
            hashCode = (int)(smallValue & 0xffffffff);
            hashCode = 33 * hashCode +  (int)((smallValue >> 32) & 0xffffffff);
            hashCode = 17 * hashCode + scale;
            return hashCode;
        }
        hashCode = 17 * intVal.hashCode() + scale;
        return hashCode;
    }

    /**
     * Returns a canonical string representation of this {@code BigDecimal}. If
     * necessary, scientific notation is used. This representation always prints
     * all significant digits of this value.
     * <p>
     * If the scale is negative or if {@code scale - precision >= 6} then
     * scientific notation is used.
     *
     * @return a string representation of {@code this} in scientific notation if
     *         necessary.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.369 -0500", hash_original_method = "7C431BE8FF70735180E872A989DC1E52", hash_generated_method = "573FF4C86B22743A6E931033731866A5")
    
@Override
    public String toString() {
        if (toStringImage != null) {
            return toStringImage;
        }
        if(bitLength < 32) {
            toStringImage = Conversion.toDecimalScaledString(smallValue,scale);
            return toStringImage;
        }
        String intString = getUnscaledValue().toString();
        if (scale == 0) {
            return intString;
        }
        int begin = (getUnscaledValue().signum() < 0) ? 2 : 1;
        int end = intString.length();
        long exponent = -(long)scale + end - begin;
        StringBuilder result = new StringBuilder();

        result.append(intString);
        if ((scale > 0) && (exponent >= -6)) {
            if (exponent >= 0) {
                result.insert(end - scale, '.');
            } else {
                result.insert(begin - 1, "0.");
                result.insert(begin + 1, CH_ZEROS, 0, -(int)exponent - 1);
            }
        } else {
            if (end - begin >= 1) {
                result.insert(begin, '.');
                end++;
            }
            result.insert(end, 'E');
            if (exponent > 0) {
                result.insert(++end, '+');
            }
            result.insert(++end, Long.toString(exponent));
        }
        toStringImage = result.toString();
        return toStringImage;
    }

    /**
     * Returns a string representation of this {@code BigDecimal}. This
     * representation always prints all significant digits of this value.
     * <p>
     * If the scale is negative or if {@code scale - precision >= 6} then
     * engineering notation is used. Engineering notation is similar to the
     * scientific notation except that the exponent is made to be a multiple of
     * 3 such that the integer part is >= 1 and < 1000.
     *
     * @return a string representation of {@code this} in engineering notation
     *         if necessary.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.372 -0500", hash_original_method = "37C393D601D5FE9982CCA7EB2837999F", hash_generated_method = "86A9CDAD28C9E49F01DE5A9B6AF6D07D")
    
public String toEngineeringString() {
        String intString = getUnscaledValue().toString();
        if (scale == 0) {
            return intString;
        }
        int begin = (getUnscaledValue().signum() < 0) ? 2 : 1;
        int end = intString.length();
        long exponent = -(long)scale + end - begin;
        StringBuilder result = new StringBuilder(intString);

        if ((scale > 0) && (exponent >= -6)) {
            if (exponent >= 0) {
                result.insert(end - scale, '.');
            } else {
                result.insert(begin - 1, "0.");
                result.insert(begin + 1, CH_ZEROS, 0, -(int)exponent - 1);
            }
        } else {
            int delta = end - begin;
            int rem = (int)(exponent % 3);

            if (rem != 0) {
                // adjust exponent so it is a multiple of three
                if (getUnscaledValue().signum() == 0) {
                    // zero value
                    rem = (rem < 0) ? -rem : 3 - rem;
                    exponent += rem;
                } else {
                    // nonzero value
                    rem = (rem < 0) ? rem + 3 : rem;
                    exponent -= rem;
                    begin += rem;
                }
                if (delta < 3) {
                    for (int i = rem - delta; i > 0; i--) {
                        result.insert(end++, '0');
                    }
                }
            }
            if (end - begin >= 1) {
                result.insert(begin, '.');
                end++;
            }
            if (exponent != 0) {
                result.insert(end, 'E');
                if (exponent > 0) {
                    result.insert(++end, '+');
                }
                result.insert(++end, Long.toString(exponent));
            }
        }
        return result.toString();
    }

    /**
     * Returns a string representation of this {@code BigDecimal}. No scientific
     * notation is used. This methods adds zeros where necessary.
     * <p>
     * If this string representation is used to create a new instance, this
     * instance is generally not identical to {@code this} as the precision
     * changes.
     * <p>
     * {@code x.equals(new BigDecimal(x.toPlainString())} usually returns
     * {@code false}.
     * <p>
     * {@code x.compareTo(new BigDecimal(x.toPlainString())} returns {@code 0}.
     *
     * @return a string representation of {@code this} without exponent part.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.375 -0500", hash_original_method = "F2C3CA97C72252FC482FDCEF1D32932E", hash_generated_method = "E324CD78D77655299471C188FBC93245")
    
public String toPlainString() {
        String intStr = getUnscaledValue().toString();
        if ((scale == 0) || ((isZero()) && (scale < 0))) {
            return intStr;
        }
        int begin = (signum() < 0) ? 1 : 0;
        int delta = scale;
        // We take space for all digits, plus a possible decimal point, plus 'scale'
        StringBuilder result = new StringBuilder(intStr.length() + 1 + Math.abs(scale));

        if (begin == 1) {
            // If the number is negative, we insert a '-' character at front
            result.append('-');
        }
        if (scale > 0) {
            delta -= (intStr.length() - begin);
            if (delta >= 0) {
                result.append("0.");
                // To append zeros after the decimal point
                for (; delta > CH_ZEROS.length; delta -= CH_ZEROS.length) {
                    result.append(CH_ZEROS);
                }
                result.append(CH_ZEROS, 0, delta);
                result.append(intStr.substring(begin));
            } else {
                delta = begin - delta;
                result.append(intStr.substring(begin, delta));
                result.append('.');
                result.append(intStr.substring(delta));
            }
        } else {// (scale <= 0)
            result.append(intStr.substring(begin));
            // To append trailing zeros
            for (; delta < -CH_ZEROS.length; delta += CH_ZEROS.length) {
                result.append(CH_ZEROS);
            }
            result.append(CH_ZEROS, 0, -delta);
        }
        return result.toString();
    }

    /**
     * Returns this {@code BigDecimal} as a big integer instance. A fractional
     * part is discarded.
     *
     * @return this {@code BigDecimal} as a big integer instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.378 -0500", hash_original_method = "E90ADE3EE93FD433EFA047972DEC5382", hash_generated_method = "DDF1452A65A1812AE69308240A7202DE")
    
public BigInteger toBigInteger() {
        if ((scale == 0) || (isZero())) {
            return getUnscaledValue();
        } else if (scale < 0) {
            return getUnscaledValue().multiply(Multiplication.powerOf10(-(long)scale));
        } else {// (scale > 0)
            return getUnscaledValue().divide(Multiplication.powerOf10(scale));
        }
    }

    /**
     * Returns this {@code BigDecimal} as a big integer instance if it has no
     * fractional part. If this {@code BigDecimal} has a fractional part, i.e.
     * if rounding would be necessary, an {@code ArithmeticException} is thrown.
     *
     * @return this {@code BigDecimal} as a big integer value.
     * @throws ArithmeticException
     *             if rounding is necessary.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.381 -0500", hash_original_method = "0E78A189176A3E6769EBE407FB203DE6", hash_generated_method = "9A763559F8D384779FDD35E8114B47BC")
    
public BigInteger toBigIntegerExact() {
        if ((scale == 0) || (isZero())) {
            return getUnscaledValue();
        } else if (scale < 0) {
            return getUnscaledValue().multiply(Multiplication.powerOf10(-(long)scale));
        } else {// (scale > 0)
            BigInteger[] integerAndFraction;
            // An optimization before do a heavy division
            if ((scale > approxPrecision()) || (scale > getUnscaledValue().getLowestSetBit())) {
                throw new ArithmeticException("Rounding necessary");
            }
            integerAndFraction = getUnscaledValue().divideAndRemainder(Multiplication.powerOf10(scale));
            if (integerAndFraction[1].signum() != 0) {
                // It exists a non-zero fractional part
                throw new ArithmeticException("Rounding necessary");
            }
            return integerAndFraction[0];
        }
    }

    /**
     * Returns this {@code BigDecimal} as an long value. Any fractional part is
     * discarded. If the integral part of {@code this} is too big to be
     * represented as an long, then {@code this} % 2^64 is returned.
     *
     * @return this {@code BigDecimal} as a long value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.383 -0500", hash_original_method = "A54EDCAFB9A559A1B4EB83484BB75122", hash_generated_method = "53A993C5E954A4A33DB257E84EB74F2C")
    
@Override
    public long longValue() {
        /*
         * If scale <= -64 there are at least 64 trailing bits zero in
         * 10^(-scale). If the scale is positive and very large the long value
         * could be zero.
         */
        return ((scale <= -64) || (scale > approxPrecision()) ? 0L
                : toBigInteger().longValue());
    }

    /**
     * Returns this {@code BigDecimal} as a long value if it has no fractional
     * part and if its value fits to the int range ([-2^{63}..2^{63}-1]). If
     * these conditions are not met, an {@code ArithmeticException} is thrown.
     *
     * @return this {@code BigDecimal} as a long value.
     * @throws ArithmeticException
     *             if rounding is necessary or the number doesn't fit in a long.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.386 -0500", hash_original_method = "FC36A176D0180DB1420333E5E0A5371B", hash_generated_method = "B9863E23290D0379E457DCB3773F4DEF")
    
public long longValueExact() {
        return valueExact(64);
    }

    /**
     * Returns this {@code BigDecimal} as an int value. Any fractional part is
     * discarded. If the integral part of {@code this} is too big to be
     * represented as an int, then {@code this} % 2^32 is returned.
     *
     * @return this {@code BigDecimal} as a int value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.388 -0500", hash_original_method = "C22AEC57669E1045E01A9977FB32CBED", hash_generated_method = "B69D30E547226408DE329DDBCF67633E")
    
@Override
    public int intValue() {
        /*
         * If scale <= -32 there are at least 32 trailing bits zero in
         * 10^(-scale). If the scale is positive and very large the long value
         * could be zero.
         */
        return ((scale <= -32) || (scale > approxPrecision())
        ? 0
                : toBigInteger().intValue());
    }

    /**
     * Returns this {@code BigDecimal} as a int value if it has no fractional
     * part and if its value fits to the int range ([-2^{31}..2^{31}-1]). If
     * these conditions are not met, an {@code ArithmeticException} is thrown.
     *
     * @return this {@code BigDecimal} as a int value.
     * @throws ArithmeticException
     *             if rounding is necessary or the number doesn't fit in a int.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.391 -0500", hash_original_method = "3865E14853C36D94FA2C26348C89A3B8", hash_generated_method = "C51B444E4A78D734F9BE458FA15ED71F")
    
public int intValueExact() {
        return (int)valueExact(32);
    }

    /**
     * Returns this {@code BigDecimal} as a short value if it has no fractional
     * part and if its value fits to the short range ([-2^{15}..2^{15}-1]). If
     * these conditions are not met, an {@code ArithmeticException} is thrown.
     *
     * @return this {@code BigDecimal} as a short value.
     * @throws ArithmeticException
     *             if rounding is necessary of the number doesn't fit in a
     *             short.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.393 -0500", hash_original_method = "D0948D36E91C12739D01E1A7BD76887B", hash_generated_method = "AE0F9EA057BEB70F9F7ECAB896283675")
    
public short shortValueExact() {
        return (short)valueExact(16);
    }

    /**
     * Returns this {@code BigDecimal} as a byte value if it has no fractional
     * part and if its value fits to the byte range ([-128..127]). If these
     * conditions are not met, an {@code ArithmeticException} is thrown.
     *
     * @return this {@code BigDecimal} as a byte value.
     * @throws ArithmeticException
     *             if rounding is necessary or the number doesn't fit in a byte.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.395 -0500", hash_original_method = "D6CE76A6DF6EC675E82ED0D5BFCEAF06", hash_generated_method = "97241FFE0CE8D9719558489CF6B811DC")
    
public byte byteValueExact() {
        return (byte)valueExact(8);
    }

    /**
     * Returns this {@code BigDecimal} as a float value. If {@code this} is too
     * big to be represented as an float, then {@code Float.POSITIVE_INFINITY}
     * or {@code Float.NEGATIVE_INFINITY} is returned.
     * <p>
     * Note, that if the unscaled value has more than 24 significant digits,
     * then this decimal cannot be represented exactly in a float variable. In
     * this case the result is rounded.
     * <p>
     * For example, if the instance {@code x1 = new BigDecimal("0.1")} cannot be
     * represented exactly as a float, and thus {@code x1.equals(new
     * BigDecimal(x1.folatValue())} returns {@code false} for this case.
     * <p>
     * Similarly, if the instance {@code new BigDecimal(16777217)} is converted
     * to a float, the result is {@code 1.6777216E}7.
     *
     * @return this {@code BigDecimal} as a float value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.398 -0500", hash_original_method = "4137052570907849FFBB7EF546BA389D", hash_generated_method = "36C08B39863DE723086D4D6AB52E9C5C")
    
@Override
    public float floatValue() {
        /* A similar code like in doubleValue() could be repeated here,
         * but this simple implementation is quite efficient. */
        float floatResult = signum();
        long powerOfTwo = this.bitLength - (long)(scale / LOG10_2);
        if ((powerOfTwo < -149) || (floatResult == 0.0f)) {
            // Cases which 'this' is very small
            floatResult *= 0.0f;
        } else if (powerOfTwo > 129) {
            // Cases which 'this' is very large
            floatResult *= Float.POSITIVE_INFINITY;
        } else {
            floatResult = (float)doubleValue();
        }
        return floatResult;
    }

    /**
     * Returns this {@code BigDecimal} as a double value. If {@code this} is too
     * big to be represented as an float, then {@code Double.POSITIVE_INFINITY}
     * or {@code Double.NEGATIVE_INFINITY} is returned.
     * <p>
     * Note, that if the unscaled value has more than 53 significant digits,
     * then this decimal cannot be represented exactly in a double variable. In
     * this case the result is rounded.
     * <p>
     * For example, if the instance {@code x1 = new BigDecimal("0.1")} cannot be
     * represented exactly as a double, and thus {@code x1.equals(new
     * BigDecimal(x1.doubleValue())} returns {@code false} for this case.
     * <p>
     * Similarly, if the instance {@code new BigDecimal(9007199254740993L)} is
     * converted to a double, the result is {@code 9.007199254740992E15}.
     * <p>
     *
     * @return this {@code BigDecimal} as a double value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.403 -0500", hash_original_method = "73F99D783081712086B11A0804DADCB9", hash_generated_method = "776D3F9A3EE753795FD46C836C3A97B2")
    
@Override
    public double doubleValue() {
        int sign = signum();
        int exponent = 1076; // bias + 53
        int lowestSetBit;
        int discardedSize;
        long powerOfTwo = this.bitLength - (long)(scale / LOG10_2);
        long bits; // IEEE-754 Standard
        long tempBits; // for temporal calculations
        BigInteger mantissa;

        if ((powerOfTwo < -1074) || (sign == 0)) {
            // Cases which 'this' is very small
            return (sign * 0.0d);
        } else if (powerOfTwo > 1025) {
            // Cases which 'this' is very large
            return (sign * Double.POSITIVE_INFINITY);
        }
        mantissa = getUnscaledValue().abs();
        // Let be:  this = [u,s], with s > 0
        if (scale <= 0) {
            // mantissa = abs(u) * 10^s
            mantissa = mantissa.multiply(Multiplication.powerOf10(-scale));
        } else {// (scale > 0)
            BigInteger quotAndRem[];
            BigInteger powerOfTen = Multiplication.powerOf10(scale);
            int k = 100 - (int)powerOfTwo;
            int compRem;

            if (k > 0) {
                /* Computing (mantissa * 2^k) , where 'k' is a enough big
                 * power of '2' to can divide by 10^s */
                mantissa = mantissa.shiftLeft(k);
                exponent -= k;
            }
            // Computing (mantissa * 2^k) / 10^s
            quotAndRem = mantissa.divideAndRemainder(powerOfTen);
            // To check if the fractional part >= 0.5
            compRem = quotAndRem[1].shiftLeftOneBit().compareTo(powerOfTen);
            // To add two rounded bits at end of mantissa
            mantissa = quotAndRem[0].shiftLeft(2).add(
                    BigInteger.valueOf((compRem * (compRem + 3)) / 2 + 1));
            exponent -= 2;
        }
        lowestSetBit = mantissa.getLowestSetBit();
        discardedSize = mantissa.bitLength() - 54;
        if (discardedSize > 0) {// (n > 54)
            // mantissa = (abs(u) * 10^s) >> (n - 54)
            bits = mantissa.shiftRight(discardedSize).longValue();
            tempBits = bits;
            // #bits = 54, to check if the discarded fraction produces a carry
            if ((((bits & 1) == 1) && (lowestSetBit < discardedSize))
                    || ((bits & 3) == 3)) {
                bits += 2;
            }
        } else {// (n <= 54)
            // mantissa = (abs(u) * 10^s) << (54 - n)
            bits = mantissa.longValue() << -discardedSize;
            tempBits = bits;
            // #bits = 54, to check if the discarded fraction produces a carry:
            if ((bits & 3) == 3) {
                bits += 2;
            }
        }
        // Testing bit 54 to check if the carry creates a new binary digit
        if ((bits & 0x40000000000000L) == 0) {
            // To drop the last bit of mantissa (first discarded)
            bits >>= 1;
            // exponent = 2^(s-n+53+bias)
            exponent += discardedSize;
        } else {// #bits = 54
            bits >>= 2;
            exponent += discardedSize + 1;
        }
        // To test if the 53-bits number fits in 'double'
        if (exponent > 2046) {// (exponent - bias > 1023)
            return (sign * Double.POSITIVE_INFINITY);
        } else if (exponent <= 0) {// (exponent - bias <= -1023)
            // Denormalized numbers (having exponent == 0)
            if (exponent < -53) {// exponent - bias < -1076
                return (sign * 0.0d);
            }
            // -1076 <= exponent - bias <= -1023
            // To discard '- exponent + 1' bits
            bits = tempBits >> 1;
            tempBits = bits & (-1L >>> (63 + exponent));
            bits >>= (-exponent );
            // To test if after discard bits, a new carry is generated
            if (((bits & 3) == 3) || (((bits & 1) == 1) && (tempBits != 0)
            && (lowestSetBit < discardedSize))) {
                bits += 1;
            }
            exponent = 0;
            bits >>= 1;
        }
        // Construct the 64 double bits: [sign(1), exponent(11), mantissa(52)]
        bits = (sign & 0x8000000000000000L) | ((long)exponent << 52)
                | (bits & 0xFFFFFFFFFFFFFL);
        return Double.longBitsToDouble(bits);
    }

    /**
     * Returns the unit in the last place (ULP) of this {@code BigDecimal}
     * instance. An ULP is the distance to the nearest big decimal with the same
     * precision.
     * <p>
     * The amount of a rounding error in the evaluation of a floating-point
     * operation is often expressed in ULPs. An error of 1 ULP is often seen as
     * a tolerable error.
     * <p>
     * For class {@code BigDecimal}, the ULP of a number is simply 10^(-scale).
     * <p>
     * For example, {@code new BigDecimal(0.1).ulp()} returns {@code 1E-55}.
     *
     * @return unit in the last place (ULP) of this {@code BigDecimal} instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.405 -0500", hash_original_method = "AE130D2701C769DD6982173139D47466", hash_generated_method = "EABCD499FF416C3B00F13851160E0BAC")
    
public BigDecimal ulp() {
        return valueOf(1, scale);
    }

    /* Private Methods */

    /**
     * It does all rounding work of the public method
     * {@code round(MathContext)}, performing an inplace rounding
     * without creating a new object.
     *
     * @param mc
     *            the {@code MathContext} for perform the rounding.
     * @see #round(MathContext)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.409 -0500", hash_original_method = "55CD7E6ED2002FE9D7C30850FBD08759", hash_generated_method = "1BACB30DEF0675711E42916D30144FDD")
    
private void inplaceRound(MathContext mc) {
        int mcPrecision = mc.getPrecision();
        if (approxPrecision() < mcPrecision || mcPrecision == 0) {
            return;
        }
        int discardedPrecision = precision() - mcPrecision;
        // If no rounding is necessary it returns immediately
        if ((discardedPrecision <= 0)) {
            return;
        }
        // When the number is small perform an efficient rounding
        if (this.bitLength < 64) {
            smallRound(mc, discardedPrecision);
            return;
        }
        // Getting the integer part and the discarded fraction
        BigInteger sizeOfFraction = Multiplication.powerOf10(discardedPrecision);
        BigInteger[] integerAndFraction = getUnscaledValue().divideAndRemainder(sizeOfFraction);
        long newScale = (long)scale - discardedPrecision;
        int compRem;
        BigDecimal tempBD;
        // If the discarded fraction is non-zero, perform rounding
        if (integerAndFraction[1].signum() != 0) {
            // To check if the discarded fraction >= 0.5
            compRem = (integerAndFraction[1].abs().shiftLeftOneBit().compareTo(sizeOfFraction));
            // To look if there is a carry
            compRem =  roundingBehavior( integerAndFraction[0].testBit(0) ? 1 : 0,
                    integerAndFraction[1].signum() * (5 + compRem),
                    mc.getRoundingMode());
            if (compRem != 0) {
                integerAndFraction[0] = integerAndFraction[0].add(BigInteger.valueOf(compRem));
            }
            tempBD = new BigDecimal(integerAndFraction[0]);
            // If after to add the increment the precision changed, we normalize the size
            if (tempBD.precision() > mcPrecision) {
                integerAndFraction[0] = integerAndFraction[0].divide(BigInteger.TEN);
                newScale--;
            }
        }
        // To update all internal fields
        scale = safeLongToInt(newScale);
        precision = mcPrecision;
        setUnscaledValue(integerAndFraction[0]);
    }
    /**
     * This method implements an efficient rounding for numbers which unscaled
     * value fits in the type {@code long}.
     *
     * @param mc
     *            the context to use
     * @param discardedPrecision
     *            the number of decimal digits that are discarded
     * @see #round(MathContext)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.414 -0500", hash_original_method = "7FBE752FF3FF6B350050AE2B0F2B0308", hash_generated_method = "37FE81751B97E7D6EAD2DCA0FFF6D997")
    
private void smallRound(MathContext mc, int discardedPrecision) {
        long sizeOfFraction = MathUtils.LONG_POWERS_OF_TEN[discardedPrecision];
        long newScale = (long)scale - discardedPrecision;
        long unscaledVal = smallValue;
        // Getting the integer part and the discarded fraction
        long integer = unscaledVal / sizeOfFraction;
        long fraction = unscaledVal % sizeOfFraction;
        int compRem;
        // If the discarded fraction is non-zero perform rounding
        if (fraction != 0) {
            // To check if the discarded fraction >= 0.5
            compRem = longCompareTo(Math.abs(fraction) * 2, sizeOfFraction);
            // To look if there is a carry
            integer += roundingBehavior( ((int)integer) & 1,
                    Long.signum(fraction) * (5 + compRem),
                    mc.getRoundingMode());
            // If after to add the increment the precision changed, we normalize the size
            if (Math.log10(Math.abs(integer)) >= mc.getPrecision()) {
                integer /= 10;
                newScale--;
            }
        }
        // To update all internal fields
        scale = safeLongToInt(newScale);
        precision = mc.getPrecision();
        smallValue = integer;
        bitLength = bitLength(integer);
        intVal = null;
    }

    /**
     * If {@code intVal} has a fractional part throws an exception,
     * otherwise it counts the number of bits of value and checks if it's out of
     * the range of the primitive type. If the number fits in the primitive type
     * returns this number as {@code long}, otherwise throws an
     * exception.
     *
     * @param bitLengthOfType
     *            number of bits of the type whose value will be calculated
     *            exactly
     * @return the exact value of the integer part of {@code BigDecimal}
     *         when is possible
     * @throws ArithmeticException when rounding is necessary or the
     *             number don't fit in the primitive type
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.419 -0500", hash_original_method = "77E444DFD73510CC8BF3E35576C17A04", hash_generated_method = "564BACCFB068A700E026DE346050608E")
    
private long valueExact(int bitLengthOfType) {
        BigInteger bigInteger = toBigIntegerExact();

        if (bigInteger.bitLength() < bitLengthOfType) {
            // It fits in the primitive type
            return bigInteger.longValue();
        }
        throw new ArithmeticException("Rounding necessary");
    }

    /**
     * If the precision already was calculated it returns that value, otherwise
     * it calculates a very good approximation efficiently . Note that this
     * value will be {@code precision()} or {@code precision()-1}
     * in the worst case.
     *
     * @return an approximation of {@code precision()} value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.422 -0500", hash_original_method = "610DE3E95388579A8DD4E22BDEDE3C6E", hash_generated_method = "EF0951ABBD6CF64F7215F07309AE070A")
    
private int approxPrecision() {
        return precision > 0
                ? precision
                : (int) ((this.bitLength - 1) * LOG10_2) + 1;
    }

    /**
     * Assigns all transient fields upon deserialization of a
     * {@code BigDecimal} instance (bitLength and smallValue). The transient
     * field precision is assigned lazily.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.430 -0500", hash_original_method = "886E4F08C2196C85465CF795B505FE44", hash_generated_method = "5EFA3B947738FDBB6421F5EEFF179627")
    
private void readObject(ObjectInputStream in) throws IOException,
            ClassNotFoundException {
        in.defaultReadObject();

        this.bitLength = intVal.bitLength();
        if (this.bitLength < 64) {
            this.smallValue = intVal.longValue();
        }
    }
    static {
        Arrays.fill(CH_ZEROS, '0');
        for (int i = 0; i < ZERO_SCALED_BY.length; ++i) {
            BI_SCALED_BY_ZERO[i] = new BigDecimal(i, 0);
            ZERO_SCALED_BY[i] = new BigDecimal(0, i);
        }
        for (int i = 0; i < LONG_FIVE_POW_BIT_LENGTH.length; ++i) {
            LONG_FIVE_POW_BIT_LENGTH[i] = bitLength(LONG_FIVE_POW[i]);
        }
        for (int i = 0; i < LONG_POWERS_OF_TEN_BIT_LENGTH.length; ++i) {
            LONG_POWERS_OF_TEN_BIT_LENGTH[i] = bitLength(MathUtils.LONG_POWERS_OF_TEN[i]);
        }
        TEN_POW = Multiplication.bigTenPows;
        FIVE_POW = Multiplication.bigFivePows;
    }

    /**
     * Prepares this {@code BigDecimal} for serialization, i.e. the
     * non-transient field {@code intVal} is assigned.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.432 -0500", hash_original_method = "19FA8CC309F5EC9C814FD711C697099A", hash_generated_method = "DE66862784E7C18CF2CA3EC569D2BABB")
    
private void writeObject(ObjectOutputStream out) throws IOException {
        getUnscaledValue();
        out.defaultWriteObject();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.434 -0500", hash_original_method = "1C1109E2DBDCFAE7331AD37D197254D0", hash_generated_method = "AD75AA5CC8607B923389235FD93F223C")
    
private BigInteger getUnscaledValue() {
        if(intVal == null) {
            intVal = BigInteger.valueOf(smallValue);
        }
        return intVal;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:36.437 -0500", hash_original_method = "3BE919C32007DA5FAF4FB8B842EE650C", hash_generated_method = "F3ABDF381707075FC8F9129AE1388BE4")
    
private void setUnscaledValue(BigInteger unscaledValue) {
        this.intVal = unscaledValue;
        this.bitLength = unscaledValue.bitLength();
        if(this.bitLength < 64) {
            this.smallValue = unscaledValue.longValue();
        }
    }
}

