package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Random;

import droidsafe.helpers.DSUtils;

public final class Math {
    
    public static double abs(double d) {
        return DSUtils.UNKNOWN_DOUBLE;
    }
    
    public static float abs(float f) {
        return DSUtils.UNKNOWN_FLOAT;
    }
    
    public static int abs(int i) {
        return DSUtils.UNKNOWN_INT;
    }
    
    public static long abs(long l) {
        return DSUtils.UNKNOWN_LONG;
    }
    
    public static double acos(double d) {
        return DSUtils.UNKNOWN_DOUBLE;
    }
    
    public static double asin(double d) {
        return DSUtils.UNKNOWN_DOUBLE;
    }
    
    public static double atan(double d) {
        return DSUtils.UNKNOWN_DOUBLE;
    }
    
    public static double atan2(double y, double x) {
        return DSUtils.UNKNOWN_DOUBLE;
    }
    
    public static double cbrt(double d) {
        return DSUtils.UNKNOWN_DOUBLE;
    }
    
    public static double ceil(double d) {
        return DSUtils.UNKNOWN_DOUBLE;
    }
    
    public static double cos(double d) {
        return DSUtils.UNKNOWN_DOUBLE;
    }
    
    public static double cosh(double d) {
        return DSUtils.UNKNOWN_DOUBLE;
    }
    
    public static double exp(double d) {
        return DSUtils.UNKNOWN_DOUBLE;
    }
    
    public static double expm1(double d) {
        return DSUtils.UNKNOWN_DOUBLE;
    }
    
    public static double floor(double d) {
        return DSUtils.UNKNOWN_DOUBLE;
    }
    
    public static double hypot(double x, double y) {
        return DSUtils.UNKNOWN_DOUBLE;
    }
    
    public static double IEEEremainder(double x, double y) {
        return DSUtils.UNKNOWN_DOUBLE;
    }
    
    public static double log(double d) {
        return DSUtils.UNKNOWN_DOUBLE;
    }
    
    public static double log10(double d) {
        return DSUtils.UNKNOWN_DOUBLE;
    }
    
    public static double log1p(double d) {
        return DSUtils.UNKNOWN_DOUBLE;
    }

    /**
     * Returns the most positive (closest to positive infinity) of the two
     * arguments.
     * <p>
     * Special cases:
     * <ul>
     * <li>{@code max(NaN, (anything)) = NaN}</li>
     * <li>{@code max((anything), NaN) = NaN}</li>
     * <li>{@code max(+0.0, -0.0) = +0.0}</li>
     * <li>{@code max(-0.0, +0.0) = +0.0}</li>
     * </ul>
     *
     * @param d1
     *            the first argument.
     * @param d2
     *            the second argument.
     * @return the larger of {@code d1} and {@code d2}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.675 -0500", hash_original_method = "44DF249E8533183B21D14B39E826B28E", hash_generated_method = "380B6602028EB9350F7E15749FFDEB86")
    
public static double max(double d1, double d2) {
        if (d1 > d2) {
            return d1;
        }
        if (d1 < d2) {
            return d2;
        }
        /* if either arg is NaN, return NaN */
        if (d1 != d2) {
            return Double.NaN;
        }
        /* max(+0.0,-0.0) == +0.0 */
        /* Double.doubleToRawLongBits(0.0d) == 0 */
        if (Double.doubleToRawLongBits(d1) != 0) {
            return d2;
        }
        return 0.0d;
    }

    /**
     * Returns the most positive (closest to positive infinity) of the two
     * arguments.
     * <p>
     * Special cases:
     * <ul>
     * <li>{@code max(NaN, (anything)) = NaN}</li>
     * <li>{@code max((anything), NaN) = NaN}</li>
     * <li>{@code max(+0.0, -0.0) = +0.0}</li>
     * <li>{@code max(-0.0, +0.0) = +0.0}</li>
     * </ul>
     *
     * @param f1
     *            the first argument.
     * @param f2
     *            the second argument.
     * @return the larger of {@code f1} and {@code f2}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.678 -0500", hash_original_method = "9AEE96235CF6352E912E5660F1DE7C95", hash_generated_method = "52E191849024F1F783651368968A056F")
    
public static float max(float f1, float f2) {
        if (f1 > f2) {
            return f1;
        }
        if (f1 < f2) {
            return f2;
        }
        /* if either arg is NaN, return NaN */
        if (f1 != f2) {
            return Float.NaN;
        }
        /* max(+0.0,-0.0) == +0.0 */
        /* Float.floatToRawIntBits(0.0f) == 0*/
        if (Float.floatToRawIntBits(f1) != 0) {
            return f2;
        }
        return 0.0f;
    }
    
    public static int max(int i1, int i2) {
        return DSUtils.UNKNOWN_INT;
    }

    /**
     * Returns the most positive (closest to positive infinity) of the two
     * arguments.
     *
     * @param l1
     *            the first argument.
     * @param l2
     *            the second argument.
     * @return the larger of {@code l1} and {@code l2}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.686 -0500", hash_original_method = "233BD25D9E931F9CFFEABFD8C1F7AD8D", hash_generated_method = "89BE60C16A0FDC38DA060BFBC44C081F")
    
public static long max(long l1, long l2) {
        return l1 > l2 ? l1 : l2;
    }

    /**
     * Returns the most negative (closest to negative infinity) of the two
     * arguments.
     * <p>
     * Special cases:
     * <ul>
     * <li>{@code min(NaN, (anything)) = NaN}</li>
     * <li>{@code min((anything), NaN) = NaN}</li>
     * <li>{@code min(+0.0, -0.0) = -0.0}</li>
     * <li>{@code min(-0.0, +0.0) = -0.0}</li>
     * </ul>
     *
     * @param d1
     *            the first argument.
     * @param d2
     *            the second argument.
     * @return the smaller of {@code d1} and {@code d2}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.689 -0500", hash_original_method = "8BB4E1970CF2E6F84A22C0B200AB3D65", hash_generated_method = "2DB2C5BF5971C12A102AAB53BED6CBE8")
    
public static double min(double d1, double d2) {
        if (d1 > d2) {
            return d2;
        }
        if (d1 < d2) {
            return d1;
        }
        /* if either arg is NaN, return NaN */
        if (d1 != d2) {
            return Double.NaN;
        }
        /* min(+0.0,-0.0) == -0.0 */
        /* 0x8000000000000000L == Double.doubleToRawLongBits(-0.0d) */
        if (Double.doubleToRawLongBits(d1) == 0x8000000000000000L) {
            return -0.0d;
        }
        return d2;
    }

    /**
     * Returns the most negative (closest to negative infinity) of the two
     * arguments.
     * <p>
     * Special cases:
     * <ul>
     * <li>{@code min(NaN, (anything)) = NaN}</li>
     * <li>{@code min((anything), NaN) = NaN}</li>
     * <li>{@code min(+0.0, -0.0) = -0.0}</li>
     * <li>{@code min(-0.0, +0.0) = -0.0}</li>
     * </ul>
     *
     * @param f1
     *            the first argument.
     * @param f2
     *            the second argument.
     * @return the smaller of {@code f1} and {@code f2}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.691 -0500", hash_original_method = "2C0167268EE64CB5B5506FBA30CD6B47", hash_generated_method = "E261F8D8CD79B72EAF5E86F7A6A28E3D")
    
public static float min(float f1, float f2) {
        if (f1 > f2) {
            return f2;
        }
        if (f1 < f2) {
            return f1;
        }
        /* if either arg is NaN, return NaN */
        if (f1 != f2) {
            return Float.NaN;
        }
        /* min(+0.0,-0.0) == -0.0 */
        /* 0x80000000 == Float.floatToRawIntBits(-0.0f) */
        if (Float.floatToRawIntBits(f1) == 0x80000000) {
            return -0.0f;
        }
        return f2;
    }
    
    public static int min(int i1, int i2) {
        return DSUtils.UNKNOWN_INT;
    }

    /**
     * Returns the most negative (closest to negative infinity) of the two
     * arguments.
     *
     * @param l1
     *            the first argument.
     * @param l2
     *            the second argument.
     * @return the smaller of {@code l1} and {@code l2}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.699 -0500", hash_original_method = "5570DD5E3DA486C8E4D5DC9CDBA5E092", hash_generated_method = "B73400D0D4481274464946AB0B36C034")
    
public static long min(long l1, long l2) {
        return l1 < l2 ? l1 : l2;
    }
    
    public static double pow(double x, double y) {
        return DSUtils.UNKNOWN_DOUBLE;
    }
    
    public static double rint(double d) {
        return DSUtils.UNKNOWN_DOUBLE;
    }

    /**
     * Returns the result of rounding the argument to an integer. The result is
     * equivalent to {@code (long) Math.floor(d+0.5)}.
     * <p>
     * Special cases:
     * <ul>
     * <li>{@code round(+0.0) = +0.0}</li>
     * <li>{@code round(-0.0) = +0.0}</li>
     * <li>{@code round((anything > Long.MAX_VALUE) = Long.MAX_VALUE}</li>
     * <li>{@code round((anything < Long.MIN_VALUE) = Long.MIN_VALUE}</li>
     * <li>{@code round(+infinity) = Long.MAX_VALUE}</li>
     * <li>{@code round(-infinity) = Long.MIN_VALUE}</li>
     * <li>{@code round(NaN) = +0.0}</li>
     * </ul>
     *
     * @param d
     *            the value to be rounded.
     * @return the closest integer to the argument.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.710 -0500", hash_original_method = "F31023BEAA17C26F61A8FAFF1293674E", hash_generated_method = "072077AC89CC90DD70D1ADC526A4DCC6")
    
public static long round(double d) {
        // check for NaN
        if (d != d) {
            return 0L;
        }
        return (long) floor(d + 0.5d);
    }

    /**
     * Returns the result of rounding the argument to an integer. The result is
     * equivalent to {@code (int) Math.floor(f+0.5)}.
     * <p>
     * Special cases:
     * <ul>
     * <li>{@code round(+0.0) = +0.0}</li>
     * <li>{@code round(-0.0) = +0.0}</li>
     * <li>{@code round((anything > Integer.MAX_VALUE) = Integer.MAX_VALUE}</li>
     * <li>{@code round((anything < Integer.MIN_VALUE) = Integer.MIN_VALUE}</li>
     * <li>{@code round(+infinity) = Integer.MAX_VALUE}</li>
     * <li>{@code round(-infinity) = Integer.MIN_VALUE}</li>
     * <li>{@code round(NaN) = +0.0}</li>
     * </ul>
     *
     * @param f
     *            the value to be rounded.
     * @return the closest integer to the argument.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.712 -0500", hash_original_method = "E7A3BD9CEF3664A05F97B7EE40F06764", hash_generated_method = "B4CE0EC04834B45CEA43F2C462779E4A")
    
public static int round(float f) {
        // check for NaN
        if (f != f) {
            return 0;
        }
        return (int) floor(f + 0.5f);
    }

    /**
     * Returns the signum function of the argument. If the argument is less than
     * zero, it returns -1.0. If the argument is greater than zero, 1.0 is
     * returned. If the argument is either positive or negative zero, the
     * argument is returned as result.
     * <p>
     * Special cases:
     * <ul>
     * <li>{@code signum(+0.0) = +0.0}</li>
     * <li>{@code signum(-0.0) = -0.0}</li>
     * <li>{@code signum(+infinity) = +1.0}</li>
     * <li>{@code signum(-infinity) = -1.0}</li>
     * <li>{@code signum(NaN) = NaN}</li>
     * </ul>
     *
     * @param d
     *            the value whose signum has to be computed.
     * @return the value of the signum function.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.715 -0500", hash_original_method = "D0C7BA71432AEC4F38A3BB94348D4F09", hash_generated_method = "0EE2C3EEAB3C8DF5C363E5A7D4532DE5")
    
public static double signum(double d) {
        if (Double.isNaN(d)) {
            return Double.NaN;
        }
        double sig = d;
        if (d > 0) {
            sig = 1.0;
        } else if (d < 0) {
            sig = -1.0;
        }
        return sig;
    }

    /**
     * Returns the signum function of the argument. If the argument is less than
     * zero, it returns -1.0. If the argument is greater than zero, 1.0 is
     * returned. If the argument is either positive or negative zero, the
     * argument is returned as result.
     * <p>
     * Special cases:
     * <ul>
     * <li>{@code signum(+0.0) = +0.0}</li>
     * <li>{@code signum(-0.0) = -0.0}</li>
     * <li>{@code signum(+infinity) = +1.0}</li>
     * <li>{@code signum(-infinity) = -1.0}</li>
     * <li>{@code signum(NaN) = NaN}</li>
     * </ul>
     *
     * @param f
     *            the value whose signum has to be computed.
     * @return the value of the signum function.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.718 -0500", hash_original_method = "51588EB5370FA34884D982F539C5410D", hash_generated_method = "A023E61233CE7EB3C06C7F6C1C7BB8A3")
    
public static float signum(float f) {
        if (Float.isNaN(f)) {
            return Float.NaN;
        }
        float sig = f;
        if (f > 0) {
            sig = 1.0f;
        } else if (f < 0) {
            sig = -1.0f;
        }
        return sig;
    }
    
    public static double sin(double d) {
        return DSUtils.UNKNOWN_DOUBLE;
    }
    
    public static double sinh(double d) {
        return DSUtils.UNKNOWN_DOUBLE;
    }
    
    public static double sqrt(double d) {
        return DSUtils.UNKNOWN_DOUBLE;
    }
    
    public static double tan(double d) {
        return DSUtils.UNKNOWN_DOUBLE;
    }
    
    public static double tanh(double d) {
        return DSUtils.UNKNOWN_DOUBLE;
    }

    /**
     * Returns a pseudo-random double {@code n}, where {@code n >= 0.0 && n < 1.0}.
     * This method reuses a single instance of {@link java.util.Random}.
     * This method is thread-safe because access to the {@code Random} is synchronized,
     * but this harms scalability. Applications may find a performance benefit from
     * allocating a {@code Random} for each of their threads.
     *
     * @return a pseudo-random number.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.742 -0500", hash_original_method = "22576C597930F29271BE56A4EEB59899", hash_generated_method = "7228F28FDE792D02717F7FA9021FFDC1")
    
public static synchronized double random() {
        if (random == null) {
            random = new Random();
        }
        return random.nextDouble();
    }

    /**
     * Returns the measure in radians of the supplied degree angle. The result
     * is {@code angdeg / 180 * pi}.
     * <p>
     * Special cases:
     * <ul>
     * <li>{@code toRadians(+0.0) = +0.0}</li>
     * <li>{@code toRadians(-0.0) = -0.0}</li>
     * <li>{@code toRadians(+infinity) = +infinity}</li>
     * <li>{@code toRadians(-infinity) = -infinity}</li>
     * <li>{@code toRadians(NaN) = NaN}</li>
     * </ul>
     *
     * @param angdeg
     *            an angle in degrees.
     * @return the radian measure of the angle.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.745 -0500", hash_original_method = "8DABF7F6D42535B5D2AB5BAB7ED39309", hash_generated_method = "C6FBC8B2019816B31A04818178A89723")
    
public static double toRadians(double angdeg) {
        return angdeg / 180d * PI;
    }

    /**
     * Returns the measure in degrees of the supplied radian angle. The result
     * is {@code angrad * 180 / pi}.
     * <p>
     * Special cases:
     * <ul>
     * <li>{@code toDegrees(+0.0) = +0.0}</li>
     * <li>{@code toDegrees(-0.0) = -0.0}</li>
     * <li>{@code toDegrees(+infinity) = +infinity}</li>
     * <li>{@code toDegrees(-infinity) = -infinity}</li>
     * <li>{@code toDegrees(NaN) = NaN}</li>
     * </ul>
     *
     * @param angrad
     *            an angle in radians.
     * @return the degree measure of the angle.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.748 -0500", hash_original_method = "502B50A67A0624ED7AF2A492E09480AA", hash_generated_method = "4AC6332E722A6F45208C9B436E0A8222")
    
public static double toDegrees(double angrad) {
        return angrad * 180d / PI;
    }

    /**
     * Returns the argument's ulp (unit in the last place). The size of a ulp of
     * a double value is the positive distance between this value and the double
     * value next larger in magnitude. For non-NaN {@code x}, {@code ulp(-x) ==
     * ulp(x)}.
     * <p>
     * Special cases:
     * <ul>
     * <li>{@code ulp(+0.0) = Double.MIN_VALUE}</li>
     * <li>{@code ulp(-0.0) = Double.MIN_VALUE}</li>
     * <li>{@code ulp(+infinity) = infinity}</li>
     * <li>{@code ulp(-infinity) = infinity}</li>
     * <li>{@code ulp(NaN) = NaN}</li>
     * </ul>
     *
     * @param d
     *            the floating-point value to compute ulp of.
     * @return the size of a ulp of the argument.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.751 -0500", hash_original_method = "2D28F1AD865BB966E30C11192290FAD6", hash_generated_method = "3794E08E03A0440B35D500AF8231457C")
    
public static double ulp(double d) {
        // special cases
        if (Double.isInfinite(d)) {
            return Double.POSITIVE_INFINITY;
        } else if (d == Double.MAX_VALUE || d == -Double.MAX_VALUE) {
            return pow(2, 971);
        }
        d = abs(d);
        return nextafter(d, Double.MAX_VALUE) - d;
    }
    
    private static double nextafter(double x, double y) {
        return DSUtils.UNKNOWN_DOUBLE;
    }

    /**
     * Returns the argument's ulp (unit in the last place). The size of a ulp of
     * a float value is the positive distance between this value and the float
     * value next larger in magnitude. For non-NaN {@code x}, {@code ulp(-x) ==
     * ulp(x)}.
     * <p>
     * Special cases:
     * <ul>
     * <li>{@code ulp(+0.0) = Float.MIN_VALUE}</li>
     * <li>{@code ulp(-0.0) = Float.MIN_VALUE}</li>
     * <li>{@code ulp(+infinity) = infinity}</li>
     * <li>{@code ulp(-infinity) = infinity}</li>
     * <li>{@code ulp(NaN) = NaN}</li>
     * </ul>
     *
     * @param f
     *            the floating-point value to compute ulp of.
     * @return the size of a ulp of the argument.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.758 -0500", hash_original_method = "21C6C2BCBE003FB0A77A1E9EFAE42634", hash_generated_method = "FAB09916BE1DD446B169D420203290FB")
    
public static float ulp(float f) {
        // special cases
        if (Float.isNaN(f)) {
            return Float.NaN;
        } else if (Float.isInfinite(f)) {
            return Float.POSITIVE_INFINITY;
        } else if (f == Float.MAX_VALUE || f == -Float.MAX_VALUE) {
            return (float) pow(2, 104);
        }

        f = Math.abs(f);
        int hx = Float.floatToRawIntBits(f);
        int hy = Float.floatToRawIntBits(Float.MAX_VALUE);
        if ((hx & 0x7fffffff) == 0) { /* f == 0 */
            return Float.intBitsToFloat((hy & 0x80000000) | 0x1);
        }
        if ((hx > 0) ^ (hx > hy)) { /* |f| < |Float.MAX_VALUE| */
            hx += 1;
        } else {
            hx -= 1;
        }
        return Float.intBitsToFloat(hx) - f;
    }

    /**
     * Returns a double with the given magnitude and the sign of {@code sign}.
     * If {@code sign} is NaN, the sign of the result is arbitrary.
     * If you need a determinate sign in such cases, use {@code StrictMath.copySign}.
     * @since 1.6
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.761 -0500", hash_original_method = "15C215F29F042865F85D52F4B5FD8DEC", hash_generated_method = "4A76309A7F79AD6F51982D57C30438A6")
    
public static double copySign(double magnitude, double sign) {
        long magnitudeBits = Double.doubleToRawLongBits(magnitude);
        long signBits = Double.doubleToRawLongBits(sign);
        magnitudeBits = (magnitudeBits & ~Double.SIGN_MASK) | (signBits & Double.SIGN_MASK);
        return Double.longBitsToDouble(magnitudeBits);
    }

    /**
     * Returns a float with the given magnitude and the sign of {@code sign}.
     * If {@code sign} is NaN, the sign of the result is arbitrary.
     * If you need a determinate sign in such cases, use {@code StrictMath.copySign}.
     * @since 1.6
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.763 -0500", hash_original_method = "35AECC28C40D46AAA2C600AE0D4B90F6", hash_generated_method = "2CB8DD010CFA47DCE071C17BA226E85D")
    
public static float copySign(float magnitude, float sign) {
        int magnitudeBits = Float.floatToRawIntBits(magnitude);
        int signBits = Float.floatToRawIntBits(sign);
        magnitudeBits = (magnitudeBits & ~Float.SIGN_MASK) | (signBits & Float.SIGN_MASK);
        return Float.intBitsToFloat(magnitudeBits);
    }

    /**
     * Returns the unbiased base-2 exponent of float {@code f}.
     * @since 1.6
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.766 -0500", hash_original_method = "97012FE7C9870A29CEA8A2EDD34265B2", hash_generated_method = "985C9E866BA90774D180385CF000AF5B")
    
public static int getExponent(float f) {
        int bits = Float.floatToRawIntBits(f);
        bits = (bits & Float.EXPONENT_MASK) >> Float.MANTISSA_BITS;
        return bits - Float.EXPONENT_BIAS;
    }

    /**
     * Returns the unbiased base-2 exponent of double {@code d}.
     * @since 1.6
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.768 -0500", hash_original_method = "19989C21DEF6CFA455C891A862B03E8C", hash_generated_method = "5D6AE80AF25A6EA9088CF469827CA904")
    
public static int getExponent(double d) {
        long bits = Double.doubleToRawLongBits(d);
        bits = (bits & Double.EXPONENT_MASK) >> Double.MANTISSA_BITS;
        return (int) bits - Double.EXPONENT_BIAS;
    }

    /**
     * Returns the next double after {@code start} in the given {@code direction}.
     * @since 1.6
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.772 -0500", hash_original_method = "D2D482B3D86CB8EF8A4CC5B9C45F68F0", hash_generated_method = "461C005C705E50F80E2022CDE544BF62")
    
public static double nextAfter(double start, double direction) {
        if (start == 0 && direction == 0) {
            return direction;
        }
        return nextafter(start, direction);
    }

    /**
     * Returns the next float after {@code start} in the given {@code direction}.
     * @since 1.6
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.775 -0500", hash_original_method = "2E9F27F6AE2FE55081770F69E2F60829", hash_generated_method = "6DECAE837D531B483F47DAC581A6C932")
    
public static float nextAfter(float start, double direction) {
        if (Float.isNaN(start) || Double.isNaN(direction)) {
            return Float.NaN;
        }
        if (start == 0 && direction == 0) {
            return (float) direction;
        }
        if ((start == Float.MIN_VALUE && direction < start)
                || (start == -Float.MIN_VALUE && direction > start)) {
            return (start > 0 ? 0f : -0f);
        }
        if (Float.isInfinite(start) && (direction != start)) {
            return (start > 0 ? Float.MAX_VALUE : -Float.MAX_VALUE);
        }
        if ((start == Float.MAX_VALUE && direction > start)
                || (start == -Float.MAX_VALUE && direction < start)) {
            return (start > 0 ? Float.POSITIVE_INFINITY
                    : Float.NEGATIVE_INFINITY);
        }
        if (direction > start) {
            if (start > 0) {
                return Float.intBitsToFloat(Float.floatToIntBits(start) + 1);
            }
            if (start < 0) {
                return Float.intBitsToFloat(Float.floatToIntBits(start) - 1);
            }
            return +Float.MIN_VALUE;
        }
        if (direction < start) {
            if (start > 0) {
                return Float.intBitsToFloat(Float.floatToIntBits(start) - 1);
            }
            if (start < 0) {
                return Float.intBitsToFloat(Float.floatToIntBits(start) + 1);
            }
            return -Float.MIN_VALUE;
        }
        return (float) direction;
    }

    /**
     * Returns the next double larger than {@code d}.
     * @since 1.6
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.778 -0500", hash_original_method = "C896DE85CFE9A8E858A973A7CAE05394", hash_generated_method = "2B1EC91962A669B47E637A6AD08DAE4A")
    
public static double nextUp(double d) {
        if (Double.isNaN(d)) {
            return Double.NaN;
        }
        if (d == Double.POSITIVE_INFINITY) {
            return Double.POSITIVE_INFINITY;
        }
        if (d == 0) {
            return Double.MIN_VALUE;
        } else if (d > 0) {
            return Double.longBitsToDouble(Double.doubleToLongBits(d) + 1);
        } else {
            return Double.longBitsToDouble(Double.doubleToLongBits(d) - 1);
        }
    }

    /**
     * Returns the next float larger than {@code f}.
     * @since 1.6
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.781 -0500", hash_original_method = "5F4A09591A5352832C5CA256EEF7C3E6", hash_generated_method = "BE36B2B4C13664CDD1EE9080481079CE")
    
public static float nextUp(float f) {
        if (Float.isNaN(f)) {
            return Float.NaN;
        }
        if (f == Float.POSITIVE_INFINITY) {
            return Float.POSITIVE_INFINITY;
        }
        if (f == 0) {
            return Float.MIN_VALUE;
        } else if (f > 0) {
            return Float.intBitsToFloat(Float.floatToIntBits(f) + 1);
        } else {
            return Float.intBitsToFloat(Float.floatToIntBits(f) - 1);
        }
    }

    /**
     * Returns {@code d} * 2^{@code scaleFactor}. The result may be rounded.
     * @since 1.6
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.785 -0500", hash_original_method = "CE7FEED34E827FAEBA93BA76C027047F", hash_generated_method = "7E07A06B36AFE408B936BCD429A07040")
    
public static double scalb(double d, int scaleFactor) {
        if (Double.isNaN(d) || Double.isInfinite(d) || d == 0) {
            return d;
        }
        // change double to long for calculation
        long bits = Double.doubleToLongBits(d);
        // the sign of the results must be the same of given d
        long sign = bits & Double.SIGN_MASK;
        // calculates the factor of the result
        long factor = ((bits & Double.EXPONENT_MASK) >> Double.MANTISSA_BITS)
                - Double.EXPONENT_BIAS + scaleFactor;

        // calculates the factor of sub-normal values
        int subNormalFactor = Long.numberOfLeadingZeros(bits & ~Double.SIGN_MASK)
                - Double.NON_MANTISSA_BITS;
        if (subNormalFactor < 0) {
            // not sub-normal values
            subNormalFactor = 0;
        } else {
            factor = factor - subNormalFactor;
        }
        if (factor > Double.MAX_EXPONENT) {
            return (d > 0 ? Double.POSITIVE_INFINITY : Double.NEGATIVE_INFINITY);
        }

        long result;
        // if result is a sub-normal
        if (factor <= -Double.EXPONENT_BIAS) {
            // the number of digits that shifts
            long digits = factor + Double.EXPONENT_BIAS + subNormalFactor;
            if (Math.abs(d) < Double.MIN_NORMAL) {
                // origin d is already sub-normal
                result = shiftLongBits(bits & Double.MANTISSA_MASK, digits);
            } else {
                // origin d is not sub-normal, change mantissa to sub-normal
                result = shiftLongBits(bits & Double.MANTISSA_MASK | 0x0010000000000000L, digits - 1);
            }
        } else {
            if (Math.abs(d) >= Double.MIN_NORMAL) {
                // common situation
                result = ((factor + Double.EXPONENT_BIAS) << Double.MANTISSA_BITS)
                        | (bits & Double.MANTISSA_MASK);
            } else {
                // origin d is sub-normal, change mantissa to normal style
                result = ((factor + Double.EXPONENT_BIAS) << Double.MANTISSA_BITS)
                        | ((bits << (subNormalFactor + 1)) & Double.MANTISSA_MASK);
            }
        }
        return Double.longBitsToDouble(result | sign);
    }

    /**
     * Returns {@code d} * 2^{@code scaleFactor}. The result may be rounded.
     * @since 1.6
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.789 -0500", hash_original_method = "8B2B282A6266695E06D45999219304F1", hash_generated_method = "B93174FD452796C4850B3F2CC588FFF4")
    
public static float scalb(float d, int scaleFactor) {
        if (Float.isNaN(d) || Float.isInfinite(d) || d == 0) {
            return d;
        }
        int bits = Float.floatToIntBits(d);
        int sign = bits & Float.SIGN_MASK;
        int factor = ((bits & Float.EXPONENT_MASK) >> Float.MANTISSA_BITS)
                - Float.EXPONENT_BIAS + scaleFactor;
        // calculates the factor of sub-normal values
        int subNormalFactor = Integer.numberOfLeadingZeros(bits & ~Float.SIGN_MASK)
                - Float.NON_MANTISSA_BITS;
        if (subNormalFactor < 0) {
            // not sub-normal values
            subNormalFactor = 0;
        } else {
            factor = factor - subNormalFactor;
        }
        if (factor > Float.MAX_EXPONENT) {
            return (d > 0 ? Float.POSITIVE_INFINITY : Float.NEGATIVE_INFINITY);
        }

        int result;
        // if result is a sub-normal
        if (factor <= -Float.EXPONENT_BIAS) {
            // the number of digits that shifts
            int digits = factor + Float.EXPONENT_BIAS + subNormalFactor;
            if (Math.abs(d) < Float.MIN_NORMAL) {
                // origin d is already sub-normal
                result = shiftIntBits(bits & Float.MANTISSA_MASK, digits);
            } else {
                // origin d is not sub-normal, change mantissa to sub-normal
                result = shiftIntBits(bits & Float.MANTISSA_MASK | 0x00800000, digits - 1);
            }
        } else {
            if (Math.abs(d) >= Float.MIN_NORMAL) {
                // common situation
                result = ((factor + Float.EXPONENT_BIAS) << Float.MANTISSA_BITS)
                        | (bits & Float.MANTISSA_MASK);
            } else {
                // origin d is sub-normal, change mantissa to normal style
                result = ((factor + Float.EXPONENT_BIAS) << Float.MANTISSA_BITS)
                        | ((bits << (subNormalFactor + 1)) & Float.MANTISSA_MASK);
            }
        }
        return Float.intBitsToFloat(result | sign);
    }

    // Shifts integer bits as float, if the digits is positive, left-shift; if
    // not, shift to right and calculate its carry.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.792 -0500", hash_original_method = "F851BF8D27456D38F9F1CC4D6CA88124", hash_generated_method = "655A4B2CCDDDE310E233C503E72B85F6")
    
private static int shiftIntBits(int bits, int digits) {
        if (digits > 0) {
            return bits << digits;
        }
        // change it to positive
        int absDigits = -digits;
        if (!(Integer.numberOfLeadingZeros(bits & ~Float.SIGN_MASK) <= (32 - absDigits))) {
            return 0;
        }
        int ret = bits >> absDigits;
        boolean halfBit = ((bits >> (absDigits - 1)) & 0x1) == 1;
        if (halfBit) {
            if (Integer.numberOfTrailingZeros(bits) < (absDigits - 1)) {
                ret = ret + 1;
            }
            if (Integer.numberOfTrailingZeros(bits) == (absDigits - 1)) {
                if ((ret & 0x1) == 1) {
                    ret = ret + 1;
                }
            }
        }
        return ret;
    }

    // Shifts long bits as double, if the digits is positive, left-shift; if
    // not, shift to right and calculate its carry.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.795 -0500", hash_original_method = "C9C8604677F0F22473B2353C70CE16C1", hash_generated_method = "F757253C1789525BED2F1C512436BB86")
    
private static long shiftLongBits(long bits, long digits) {
        if (digits > 0) {
            return bits << digits;
        }
        // change it to positive
        long absDigits = -digits;
        if (!(Long.numberOfLeadingZeros(bits & ~Double.SIGN_MASK) <= (64 - absDigits))) {
            return 0;
        }
        long ret = bits >> absDigits;
        boolean halfBit = ((bits >> (absDigits - 1)) & 0x1) == 1;
        if (halfBit) {
            // some bits will remain after shifting, calculates its carry
            // subnormal
            if (Long.numberOfTrailingZeros(bits) < (absDigits - 1)) {
                ret = ret + 1;
            }
            if (Long.numberOfTrailingZeros(bits) == (absDigits - 1)) {
                if ((ret & 0x1) == 1) {
                    ret = ret + 1;
                }
            }
        }
        return ret;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.579 -0500", hash_original_field = "01D392B075974AFA31089D621F15567C", hash_generated_field = "76C0B861A937FF04B12C48BD79B20BDE")

    public static final double E = 2.718281828459045;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.582 -0500", hash_original_field = "5A719DC86B4D65885D539BB11DE23B94", hash_generated_field = "FDBC076D774B74F039A18556D6342FEC")

    public static final double PI = 3.141592653589793;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.585 -0500", hash_original_field = "DC2327CCB95C5C902D526E5238316B9A", hash_generated_field = "4574226C6A992CD5F43E1273AEA83087")

    private static Random random;

    /**
     * Prevents this class from being instantiated.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.588 -0500", hash_original_method = "0273784C246265D2ED8DEE21631953AB", hash_generated_method = "FA4C376A124A9FB7E96B70642915FF5D")
    
private Math() {
    }
}

