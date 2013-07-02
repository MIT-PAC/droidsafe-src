package java.lang;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.Random;

public final class Math {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.361 -0400", hash_original_method = "0273784C246265D2ED8DEE21631953AB", hash_generated_method = "78B9D931D5E71470A5832EAA02F41698")
    private  Math() {
        
    }

    
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

    
    @DSModeled(DSC.SAFE)
    public static double max(double d1, double d2) {
        if (d1 > d2) {
            return d1;
        }
        if (d1 < d2) {
            return d2;
        }
        if (d1 != d2) {
            return Double.NaN;
        }
        if (Double.doubleToRawLongBits(d1) != 0) {
            return d2;
        }
        return 0.0d;
    }

    
    @DSModeled(DSC.SAFE)
    public static float max(float f1, float f2) {
        if (f1 > f2) {
            return f1;
        }
        if (f1 < f2) {
            return f2;
        }
        if (f1 != f2) {
            return Float.NaN;
        }
        if (Float.floatToRawIntBits(f1) != 0) {
            return f2;
        }
        return 0.0f;
    }

    
    public static int max(int i1, int i2) {
        return DSUtils.UNKNOWN_INT;
    }

    
    public static long max(long l1, long l2) {
        return l1 > l2 ? l1 : l2;
    }

    
    @DSModeled(DSC.SAFE)
    public static double min(double d1, double d2) {
        if (d1 > d2) {
            return d2;
        }
        if (d1 < d2) {
            return d1;
        }
        if (d1 != d2) {
            return Double.NaN;
        }
        if (Double.doubleToRawLongBits(d1) == 0x8000000000000000L) {
            return -0.0d;
        }
        return d2;
    }

    
    @DSModeled(DSC.SAFE)
    public static float min(float f1, float f2) {
        if (f1 > f2) {
            return f2;
        }
        if (f1 < f2) {
            return f1;
        }
        if (f1 != f2) {
            return Float.NaN;
        }
        if (Float.floatToRawIntBits(f1) == 0x80000000) {
            return -0.0f;
        }
        return f2;
    }

    
    public static int min(int i1, int i2) {
        return DSUtils.UNKNOWN_INT;
    }

    
    public static long min(long l1, long l2) {
        return l1 < l2 ? l1 : l2;
    }

    
    public static double pow(double x, double y) {
        return DSUtils.UNKNOWN_DOUBLE;
    }

    
    public static double rint(double d) {
        return DSUtils.UNKNOWN_DOUBLE;
    }

    
    @DSModeled(DSC.SAFE)
    public static long round(double d) {
        if (d != d) {
            return 0L;
        }
        return (long) floor(d + 0.5d);
    }

    
    @DSModeled(DSC.SAFE)
    public static int round(float f) {
        if (f != f) {
            return 0;
        }
        return (int) floor(f + 0.5f);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static synchronized double random() {
        if (random == null) {
            random = new Random();
        }
        return random.nextDouble();
    }

    
    public static double toRadians(double angdeg) {
        return angdeg / 180d * PI;
    }

    
    public static double toDegrees(double angrad) {
        return angrad * 180d / PI;
    }

    
    @DSModeled(DSC.SAFE)
    public static double ulp(double d) {
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

    
    @DSModeled(DSC.SAFE)
    public static float ulp(float f) {
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
        if ((hx & 0x7fffffff) == 0) { 
            return Float.intBitsToFloat((hy & 0x80000000) | 0x1);
        }
        if ((hx > 0) ^ (hx > hy)) { 
            hx += 1;
        } else {
            hx -= 1;
        }
        return Float.intBitsToFloat(hx) - f;
    }

    
    @DSModeled(DSC.SAFE)
    public static double copySign(double magnitude, double sign) {
        long magnitudeBits = Double.doubleToRawLongBits(magnitude);
        long signBits = Double.doubleToRawLongBits(sign);
        magnitudeBits = (magnitudeBits & ~Double.SIGN_MASK) | (signBits & Double.SIGN_MASK);
        return Double.longBitsToDouble(magnitudeBits);
    }

    
    @DSModeled(DSC.SAFE)
    public static float copySign(float magnitude, float sign) {
        int magnitudeBits = Float.floatToRawIntBits(magnitude);
        int signBits = Float.floatToRawIntBits(sign);
        magnitudeBits = (magnitudeBits & ~Float.SIGN_MASK) | (signBits & Float.SIGN_MASK);
        return Float.intBitsToFloat(magnitudeBits);
    }

    
    @DSModeled(DSC.SAFE)
    public static int getExponent(float f) {
        int bits = Float.floatToRawIntBits(f);
        bits = (bits & Float.EXPONENT_MASK) >> Float.MANTISSA_BITS;
        return bits - Float.EXPONENT_BIAS;
    }

    
    @DSModeled(DSC.SAFE)
    public static int getExponent(double d) {
        long bits = Double.doubleToRawLongBits(d);
        bits = (bits & Double.EXPONENT_MASK) >> Double.MANTISSA_BITS;
        return (int) bits - Double.EXPONENT_BIAS;
    }

    
    @DSModeled(DSC.SAFE)
    public static double nextAfter(double start, double direction) {
        if (start == 0 && direction == 0) {
            return direction;
        }
        return nextafter(start, direction);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static double scalb(double d, int scaleFactor) {
        if (Double.isNaN(d) || Double.isInfinite(d) || d == 0) {
            return d;
        }
        long bits = Double.doubleToLongBits(d);
        long sign = bits & Double.SIGN_MASK;
        long factor = ((bits & Double.EXPONENT_MASK) >> Double.MANTISSA_BITS)
                - Double.EXPONENT_BIAS + scaleFactor;
        int subNormalFactor = Long.numberOfLeadingZeros(bits & ~Double.SIGN_MASK)
                - Double.NON_MANTISSA_BITS;
        if (subNormalFactor < 0) {
            subNormalFactor = 0;
        } else {
            factor = factor - subNormalFactor;
        }
        if (factor > Double.MAX_EXPONENT) {
            return (d > 0 ? Double.POSITIVE_INFINITY : Double.NEGATIVE_INFINITY);
        }
        long result;
        if (factor <= -Double.EXPONENT_BIAS) {
            long digits = factor + Double.EXPONENT_BIAS + subNormalFactor;
            if (Math.abs(d) < Double.MIN_NORMAL) {
                result = shiftLongBits(bits & Double.MANTISSA_MASK, digits);
            } else {
                result = shiftLongBits(bits & Double.MANTISSA_MASK | 0x0010000000000000L, digits - 1);
            }
        } else {
            if (Math.abs(d) >= Double.MIN_NORMAL) {
                result = ((factor + Double.EXPONENT_BIAS) << Double.MANTISSA_BITS)
                        | (bits & Double.MANTISSA_MASK);
            } else {
                result = ((factor + Double.EXPONENT_BIAS) << Double.MANTISSA_BITS)
                        | ((bits << (subNormalFactor + 1)) & Double.MANTISSA_MASK);
            }
        }
        return Double.longBitsToDouble(result | sign);
    }

    
    @DSModeled(DSC.SAFE)
    public static float scalb(float d, int scaleFactor) {
        if (Float.isNaN(d) || Float.isInfinite(d) || d == 0) {
            return d;
        }
        int bits = Float.floatToIntBits(d);
        int sign = bits & Float.SIGN_MASK;
        int factor = ((bits & Float.EXPONENT_MASK) >> Float.MANTISSA_BITS)
                - Float.EXPONENT_BIAS + scaleFactor;
        int subNormalFactor = Integer.numberOfLeadingZeros(bits & ~Float.SIGN_MASK)
                - Float.NON_MANTISSA_BITS;
        if (subNormalFactor < 0) {
            subNormalFactor = 0;
        } else {
            factor = factor - subNormalFactor;
        }
        if (factor > Float.MAX_EXPONENT) {
            return (d > 0 ? Float.POSITIVE_INFINITY : Float.NEGATIVE_INFINITY);
        }
        int result;
        if (factor <= -Float.EXPONENT_BIAS) {
            int digits = factor + Float.EXPONENT_BIAS + subNormalFactor;
            if (Math.abs(d) < Float.MIN_NORMAL) {
                result = shiftIntBits(bits & Float.MANTISSA_MASK, digits);
            } else {
                result = shiftIntBits(bits & Float.MANTISSA_MASK | 0x00800000, digits - 1);
            }
        } else {
            if (Math.abs(d) >= Float.MIN_NORMAL) {
                result = ((factor + Float.EXPONENT_BIAS) << Float.MANTISSA_BITS)
                        | (bits & Float.MANTISSA_MASK);
            } else {
                result = ((factor + Float.EXPONENT_BIAS) << Float.MANTISSA_BITS)
                        | ((bits << (subNormalFactor + 1)) & Float.MANTISSA_MASK);
            }
        }
        return Float.intBitsToFloat(result | sign);
    }

    
    @DSModeled(DSC.SAFE)
    private static int shiftIntBits(int bits, int digits) {
        if (digits > 0) {
            return bits << digits;
        }
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

    
    @DSModeled(DSC.SAFE)
    private static long shiftLongBits(long bits, long digits) {
        if (digits > 0) {
            return bits << digits;
        }
        long absDigits = -digits;
        if (!(Long.numberOfLeadingZeros(bits & ~Double.SIGN_MASK) <= (64 - absDigits))) {
            return 0;
        }
        long ret = bits >> absDigits;
        boolean halfBit = ((bits >> (absDigits - 1)) & 0x1) == 1;
        if (halfBit) {
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.370 -0400", hash_original_field = "81D72EDD8724627525B16222A6EE30E9", hash_generated_field = "76C0B861A937FF04B12C48BD79B20BDE")

    public static final double E = 2.718281828459045;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.370 -0400", hash_original_field = "AAC9BFF077D3AB0FC824AF3464B50C74", hash_generated_field = "FDBC076D774B74F039A18556D6342FEC")

    public static final double PI = 3.141592653589793;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.370 -0400", hash_original_field = "7DDF32E17A6AC5CE04A8ECBF782CA509", hash_generated_field = "4574226C6A992CD5F43E1273AEA83087")

    private static Random random;
}

