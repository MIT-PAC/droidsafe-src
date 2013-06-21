package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class Long extends Number implements Comparable<Long> {
    private long value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.845 -0400", hash_original_method = "F7421F28ECB11D742A45928A1DF88A80", hash_generated_method = "09817C490D514246AD6D2785438A6A00")
    @DSModeled(DSC.SAFE)
    public Long(long value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        //this.value = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.845 -0400", hash_original_method = "FBD907393492057451D7BFE621A4E030", hash_generated_method = "0431A6B5B402F0EE9EEA6682D5907ADB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Long(String string) throws NumberFormatException {
        this(parseLong(string));
        dsTaint.addTaint(string);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.845 -0400", hash_original_method = "6B61312FC318A12A6B19178CA8B54E86", hash_generated_method = "4F78E57EE61A27A10E7A632140A3DDA6")
    @DSModeled(DSC.SAFE)
    @Override
    public byte byteValue() {
        return dsTaint.getTaintByte();
        // ---------- Original Method ----------
        //return (byte) value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.845 -0400", hash_original_method = "B49F758A210AD21F31F3B71259593715", hash_generated_method = "6228503A161DCF4976AA681D1AB7B7D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int compareTo(Long object) {
        dsTaint.addTaint(object.dsTaint);
        int varEB17148B4676BC6C35C2467C947D57DF_1192324059 = (compare(value, object.value));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return compare(value, object.value);
    }

    
        public static int compare(long lhs, long rhs) {
        return lhs < rhs ? -1 : (lhs == rhs ? 0 : 1);
    }

    
        private static NumberFormatException invalidLong(String s) {
        throw new NumberFormatException("Invalid long: \"" + s + "\"");
    }

    
        public static Long decode(String string) throws NumberFormatException {
        int length = string.length(), i = 0;
        if (length == 0) {
            throw invalidLong(string);
        }
        char firstDigit = string.charAt(i);
        boolean negative = firstDigit == '-';
        if (negative) {
            if (length == 1) {
                throw invalidLong(string);
            }
            firstDigit = string.charAt(++i);
        }
        int base = 10;
        if (firstDigit == '0') {
            if (++i == length) {
                return valueOf(0L);
            }
            if ((firstDigit = string.charAt(i)) == 'x' || firstDigit == 'X') {
                if (i == length) {
                    throw invalidLong(string);
                }
                i++;
                base = 16;
            } else {
                base = 8;
            }
        } else if (firstDigit == '#') {
            if (i == length) {
                throw invalidLong(string);
            }
            i++;
            base = 16;
        }
        long result = parse(string, i, base, negative);
        return valueOf(result);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.846 -0400", hash_original_method = "3D3B0AF18CC8081B7BB4A7DC662E1F07", hash_generated_method = "02C8EAF77A98DB2CD3BC8AC0566EBE67")
    @DSModeled(DSC.SAFE)
    @Override
    public double doubleValue() {
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.846 -0400", hash_original_method = "9DAD4C26B4F70BDE1AF6A261529DF01A", hash_generated_method = "E242CEEA16A6A4918A189F621504B3C9")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (o instanceof Long) && (((Long) o).value == value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.846 -0400", hash_original_method = "9E2C0918A44EC11D2232D0B603F66A6B", hash_generated_method = "89D86731B5289C6353CA0DC29E484746")
    @DSModeled(DSC.SAFE)
    @Override
    public float floatValue() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return value;
    }

    
        public static Long getLong(String string) {
        if (string == null || string.length() == 0) {
            return null;
        }
        String prop = System.getProperty(string);
        if (prop == null) {
            return null;
        }
        try {
            return decode(prop);
        } catch (NumberFormatException ex) {
            return null;
        }
    }

    
        public static Long getLong(String string, long defaultValue) {
        if (string == null || string.length() == 0) {
            return valueOf(defaultValue);
        }
        String prop = System.getProperty(string);
        if (prop == null) {
            return valueOf(defaultValue);
        }
        try {
            return decode(prop);
        } catch (NumberFormatException ex) {
            return valueOf(defaultValue);
        }
    }

    
        public static Long getLong(String string, Long defaultValue) {
        if (string == null || string.length() == 0) {
            return defaultValue;
        }
        String prop = System.getProperty(string);
        if (prop == null) {
            return defaultValue;
        }
        try {
            return decode(prop);
        } catch (NumberFormatException ex) {
            return defaultValue;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.847 -0400", hash_original_method = "7CEEFB1EC71C1E868FBC10557351E2DA", hash_generated_method = "085CB39A2C7F49431DD6BF9F7FF46952")
    @DSModeled(DSC.SAFE)
    @Override
    public int hashCode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (int) (value ^ (value >>> 32));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.847 -0400", hash_original_method = "138584002FB2DE9D0E5B5F8DAEDB3270", hash_generated_method = "7F343EC6551F993ABCCC87486B9C3CD6")
    @DSModeled(DSC.SAFE)
    @Override
    public int intValue() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (int) value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.847 -0400", hash_original_method = "ABF4FE035C950AC910A646D4B85E3F35", hash_generated_method = "80C9E384C663D2D407424A79AF4BFC59")
    @DSModeled(DSC.SAFE)
    @Override
    public long longValue() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return value;
    }

    
        public static long parseLong(String string) throws NumberFormatException {
        return parseLong(string, 10);
    }

    
        public static long parseLong(String string, int radix) throws NumberFormatException {
        if (radix < Character.MIN_RADIX || radix > Character.MAX_RADIX) {
            throw new NumberFormatException("Invalid radix: " + radix);
        }
        if (string == null) {
            throw invalidLong(string);
        }
        int length = string.length(), i = 0;
        if (length == 0) {
            throw invalidLong(string);
        }
        boolean negative = string.charAt(i) == '-';
        if (negative && ++i == length) {
            throw invalidLong(string);
        }
        return parse(string, i, radix, negative);
    }

    
        private static long parse(String string, int offset, int radix, boolean negative) {
        long max = Long.MIN_VALUE / radix;
        long result = 0, length = string.length();
        while (offset < length) {
            int digit = Character.digit(string.charAt(offset++), radix);
            if (digit == -1) {
                throw invalidLong(string);
            }
            if (max > result) {
                throw invalidLong(string);
            }
            long next = result * radix - digit;
            if (next > result) {
                throw invalidLong(string);
            }
            result = next;
        }
        if (!negative) {
            result = -result;
            if (result < 0) {
                throw invalidLong(string);
            }
        }
        return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.848 -0400", hash_original_method = "8E8C16CBE89F9837B346C9544C9B6BCC", hash_generated_method = "41D347FA9B5B0AF32CD8FBD284185B0B")
    @DSModeled(DSC.SAFE)
    @Override
    public short shortValue() {
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //return (short) value;
    }

    
        public static String toBinaryString(long v) {
        return IntegralToString.longToBinaryString(v);
    }

    
        public static String toHexString(long v) {
        return IntegralToString.longToHexString(v);
    }

    
        public static String toOctalString(long v) {
        return IntegralToString.longToOctalString(v);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.848 -0400", hash_original_method = "6878CA43BE92FEF897301589A58FE568", hash_generated_method = "CA50D78B8433A922BA33EEB90EC9AF9B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String varBD7F3E2EE807B2A34047F3A9BB6671E5_824797655 = (Long.toString(value));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return Long.toString(value);
    }

    
        public static String toString(long n) {
        return IntegralToString.longToString(n);
    }

    
        public static String toString(long v, int radix) {
        return IntegralToString.longToString(v, radix);
    }

    
        public static Long valueOf(String string) throws NumberFormatException {
        return valueOf(parseLong(string));
    }

    
        public static Long valueOf(String string, int radix) throws NumberFormatException {
        return valueOf(parseLong(string, radix));
    }

    
        public static long highestOneBit(long v) {
        v |= (v >> 1);
        v |= (v >> 2);
        v |= (v >> 4);
        v |= (v >> 8);
        v |= (v >> 16);
        v |= (v >> 32);
        return v - (v >>> 1);
    }

    
        public static long lowestOneBit(long v) {
        return v & -v;
    }

    
        public static int numberOfLeadingZeros(long v) {
        if (v < 0) {
            return 0;
        }
        if (v == 0) {
            return 64;
        }
        int n = 1;
        int i = (int) (v >>> 32);
        if (i == 0) {
            n +=  32;
            i = (int) v;
        }
        if (i >>> 16 == 0) {
            n +=  16;
            i <<= 16;
        }
        if (i >>> 24 == 0) {
            n +=  8;
            i <<= 8;
        }
        if (i >>> 28 == 0) {
            n +=  4;
            i <<= 4;
        }
        if (i >>> 30 == 0) {
            n +=  2;
            i <<= 2;
        }
        return n - (i >>> 31);
    }

    
        public static int numberOfTrailingZeros(long v) {
        int low = (int) v;
        return low !=0 ? Integer.numberOfTrailingZeros(low)
                       : 32 + Integer.numberOfTrailingZeros((int) (v >>> 32));
    }

    
        public static int bitCount(long v) {
        v -=  (v >>> 1) & 0x5555555555555555L;
        v = (v & 0x3333333333333333L) + ((v >>> 2) & 0x3333333333333333L);
        int i =  ((int)(v >>> 32)) + (int) v;
        i = (i & 0x0F0F0F0F) + ((i >>> 4) & 0x0F0F0F0F);
        i += i >>> 8;
        i += i >>> 16;
        return i  & 0x0000007F;
    }

    
        public static long rotateLeft(long v, int distance) {
        return (v << distance) | (v >>> -distance);
    }

    
        public static long rotateRight(long v, int distance) {
        return (v >>> distance) | (v << -distance);
    }

    
        public static long reverseBytes(long v) {
        v = ((v >>> 8) & 0x00FF00FF00FF00FFL) | ((v & 0x00FF00FF00FF00FFL) << 8);
        v = ((v >>>16) & 0x0000FFFF0000FFFFL) | ((v & 0x0000FFFF0000FFFFL) <<16);
        return ((v >>>32)                   ) | ((v                      ) <<32);
    }

    
        public static long reverse(long v) {
        v = ((v >>> 1) & 0x5555555555555555L) | ((v & 0x5555555555555555L) << 1);
        v = ((v >>> 2) & 0x3333333333333333L) | ((v & 0x3333333333333333L) << 2);
        v = ((v >>> 4) & 0x0F0F0F0F0F0F0F0FL) | ((v & 0x0F0F0F0F0F0F0F0FL) << 4);
        v = ((v >>> 8) & 0x00FF00FF00FF00FFL) | ((v & 0x00FF00FF00FF00FFL) << 8);
        v = ((v >>>16) & 0x0000FFFF0000FFFFL) | ((v & 0x0000FFFF0000FFFFL) <<16);
        return ((v >>>32)                   ) | ((v                      ) <<32);
    }

    
        public static int signum(long v) {
        return v < 0 ? -1 : (v == 0 ? 0 : 1);
    }

    
        public static Long valueOf(long v) {
        return  v >= 128 || v < -128 ? new Long(v) : SMALL_VALUES[((int) v) + 128];
    }

    
    private static final long serialVersionUID = 4290774380558885855L;
    public static final long MAX_VALUE = 0x7FFFFFFFFFFFFFFFL;
    public static final long MIN_VALUE = 0x8000000000000000L;
    @SuppressWarnings("unchecked") public static final Class<Long> TYPE
            = (Class<Long>) long[].class.getComponentType();
    public static final int SIZE = 64;
    private static final Long[] SMALL_VALUES = new Long[256];
    static {
        for (int i = -128; i < 128; i++) {
            SMALL_VALUES[i + 128] = new Long(i);
        }
    }
    
}

