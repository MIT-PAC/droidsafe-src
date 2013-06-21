package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class Integer extends Number implements Comparable<Integer> {
    private int value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.770 -0400", hash_original_method = "22146E0D9B2FD3EEBD460016C940A35F", hash_generated_method = "76231FFFB8AD1705BC7892ACA28CEC44")
    @DSModeled(DSC.SAFE)
    public Integer(int value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        //this.value = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.770 -0400", hash_original_method = "E0CD1D1A7D46CCFF15C90A26B138404A", hash_generated_method = "84E3B9084897B50B3A1E0BC9F06D6D8D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Integer(String string) throws NumberFormatException {
        this(parseInt(string));
        dsTaint.addTaint(string);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.771 -0400", hash_original_method = "6B61312FC318A12A6B19178CA8B54E86", hash_generated_method = "4F78E57EE61A27A10E7A632140A3DDA6")
    @DSModeled(DSC.SAFE)
    @Override
    public byte byteValue() {
        return dsTaint.getTaintByte();
        // ---------- Original Method ----------
        //return (byte) value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.771 -0400", hash_original_method = "735EC7AEC4F3C97B9E273B68A8C134FA", hash_generated_method = "A78B73FB7D336CB6E237A00C2A78E2F0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int compareTo(Integer object) {
        dsTaint.addTaint(object.dsTaint);
        int varEB17148B4676BC6C35C2467C947D57DF_892664915 = (compare(value, object.value));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return compare(value, object.value);
    }

    
        public static int compare(int lhs, int rhs) {
        return lhs < rhs ? -1 : (lhs == rhs ? 0 : 1);
    }

    
        private static NumberFormatException invalidInt(String s) {
        throw new NumberFormatException("Invalid int: \"" + s + "\"");
    }

    
        public static Integer decode(String string) throws NumberFormatException {
        int length = string.length(), i = 0;
        if (length == 0) {
            throw invalidInt(string);
        }
        char firstDigit = string.charAt(i);
        boolean negative = firstDigit == '-';
        if (negative) {
            if (length == 1) {
                throw invalidInt(string);
            }
            firstDigit = string.charAt(++i);
        }
        int base = 10;
        if (firstDigit == '0') {
            if (++i == length) {
                return valueOf(0);
            }
            if ((firstDigit = string.charAt(i)) == 'x' || firstDigit == 'X') {
                if (++i == length) {
                    throw invalidInt(string);
                }
                base = 16;
            } else {
                base = 8;
            }
        } else if (firstDigit == '#') {
            if (++i == length) {
                throw invalidInt(string);
            }
            base = 16;
        }
        int result = parse(string, i, base, negative);
        return valueOf(result);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.771 -0400", hash_original_method = "3D3B0AF18CC8081B7BB4A7DC662E1F07", hash_generated_method = "02C8EAF77A98DB2CD3BC8AC0566EBE67")
    @DSModeled(DSC.SAFE)
    @Override
    public double doubleValue() {
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.771 -0400", hash_original_method = "F74FD59F9B798AB03C90305DF48139A2", hash_generated_method = "E1D4C1343FBD99850B8785EDC9FEE330")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (o instanceof Integer) && (((Integer) o).value == value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.772 -0400", hash_original_method = "9E2C0918A44EC11D2232D0B603F66A6B", hash_generated_method = "89D86731B5289C6353CA0DC29E484746")
    @DSModeled(DSC.SAFE)
    @Override
    public float floatValue() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return value;
    }

    
        public static Integer getInteger(String string) {
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

    
        public static Integer getInteger(String string, int defaultValue) {
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

    
        public static Integer getInteger(String string, Integer defaultValue) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.772 -0400", hash_original_method = "961F210287166DF05D8915D632129E75", hash_generated_method = "2CC0EC8302E0602B9137F5B8629A7214")
    @DSModeled(DSC.SAFE)
    @Override
    public int hashCode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.772 -0400", hash_original_method = "4668226786F0223B69B1E8157F3C469B", hash_generated_method = "036E05D318FB7A9B9F28D4BD928D74B4")
    @DSModeled(DSC.SAFE)
    @Override
    public int intValue() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.772 -0400", hash_original_method = "ABF4FE035C950AC910A646D4B85E3F35", hash_generated_method = "80C9E384C663D2D407424A79AF4BFC59")
    @DSModeled(DSC.SAFE)
    @Override
    public long longValue() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return value;
    }

    
        public static int parseInt(String string) throws NumberFormatException {
        return parseInt(string, 10);
    }

    
        public static int parseInt(String string, int radix) throws NumberFormatException {
        if (radix < Character.MIN_RADIX || radix > Character.MAX_RADIX) {
            throw new NumberFormatException("Invalid radix: " + radix);
        }
        if (string == null) {
            throw invalidInt(string);
        }
        int length = string.length(), i = 0;
        if (length == 0) {
            throw invalidInt(string);
        }
        boolean negative = string.charAt(i) == '-';
        if (negative && ++i == length) {
            throw invalidInt(string);
        }
        return parse(string, i, radix, negative);
    }

    
        private static int parse(String string, int offset, int radix, boolean negative) throws NumberFormatException {
        int max = Integer.MIN_VALUE / radix;
        int result = 0, length = string.length();
        while (offset < length) {
            int digit = Character.digit(string.charAt(offset++), radix);
            if (digit == -1) {
                throw invalidInt(string);
            }
            if (max > result) {
                throw invalidInt(string);
            }
            int next = result * radix - digit;
            if (next > result) {
                throw invalidInt(string);
            }
            result = next;
        }
        if (!negative) {
            result = -result;
            if (result < 0) {
                throw invalidInt(string);
            }
        }
        return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.773 -0400", hash_original_method = "8E8C16CBE89F9837B346C9544C9B6BCC", hash_generated_method = "41D347FA9B5B0AF32CD8FBD284185B0B")
    @DSModeled(DSC.SAFE)
    @Override
    public short shortValue() {
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //return (short) value;
    }

    
        public static String toBinaryString(int i) {
        return IntegralToString.intToBinaryString(i);
    }

    
        public static String toHexString(int i) {
        return IntegralToString.intToHexString(i, false, 0);
    }

    
        public static String toOctalString(int i) {
        return IntegralToString.intToOctalString(i);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.774 -0400", hash_original_method = "6B315C20A4D45816791A47779D79F014", hash_generated_method = "3DE8B889F398C8D7DC62FD66FD5FB407")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String varD42FC0CD51582E4DF744832DA0BFE096_806625244 = (Integer.toString(value));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return Integer.toString(value);
    }

    
        public static String toString(int i) {
        return IntegralToString.intToString(i);
    }

    
        public static String toString(int i, int radix) {
        return IntegralToString.intToString(i, radix);
    }

    
        public static Integer valueOf(String string) throws NumberFormatException {
        return valueOf(parseInt(string));
    }

    
        public static Integer valueOf(String string, int radix) throws NumberFormatException {
        return valueOf(parseInt(string, radix));
    }

    
        public static int highestOneBit(int i) {
        i |= (i >> 1);
        i |= (i >> 2);
        i |= (i >> 4);
        i |= (i >> 8);
        i |= (i >> 16);
        return i - (i >>> 1);
    }

    
        public static int lowestOneBit(int i) {
        return i & -i;
    }

    
        public static int numberOfLeadingZeros(int i) {
        if (i <= 0) {
            return (~i >> 26) & 32;
        }
        int n = 1;
        if (i >> 16 == 0) {
            n +=  16;
            i <<= 16;
        }
        if (i >> 24 == 0) {
            n +=  8;
            i <<= 8;
        }
        if (i >> 28 == 0) {
            n +=  4;
            i <<= 4;
        }
        if (i >> 30 == 0) {
            n +=  2;
            i <<= 2;
        }
        return n - (i >>> 31);
    }

    
        public static int numberOfTrailingZeros(int i) {
        return NTZ_TABLE[((i & -i) * 0x0450FBAF) >>> 26];
    }

    
        public static int bitCount(int i) {
        i -= (i >> 1) & 0x55555555;
        i = (i & 0x33333333) + ((i >> 2) & 0x33333333);
        i = ((i >> 4) + i) & 0x0F0F0F0F;
        i += i >> 8;
        i += i >> 16;
        return i & 0x0000003F;
    }

    
        public static int rotateLeft(int i, int distance) {
        return (i << distance) | (i >>> -distance);
    }

    
        public static int rotateRight(int i, int distance) {
        return (i >>> distance) | (i << -distance);
    }

    
        public static int reverseBytes(int i) {
        i =    ((i >>>  8) & 0x00FF00FF) | ((i & 0x00FF00FF) <<  8);
        return ( i >>> 16              ) | ( i               << 16);
    }

    
        public static int reverse(int i) {
        i =    ((i >>>  1) & 0x55555555) | ((i & 0x55555555) <<  1);
        i =    ((i >>>  2) & 0x33333333) | ((i & 0x33333333) <<  2);
        i =    ((i >>>  4) & 0x0F0F0F0F) | ((i & 0x0F0F0F0F) <<  4);
        i =    ((i >>>  8) & 0x00FF00FF) | ((i & 0x00FF00FF) <<  8);
        return ((i >>> 16)             ) | ((i             ) << 16);
    }

    
        public static int signum(int i) {
        return (i >> 31) | (-i >>> 31);
    }

    
        public static Integer valueOf(int i) {
        return  i >= 128 || i < -128 ? new Integer(i) : SMALL_VALUES[i + 128];
    }

    
    private static final long serialVersionUID = 1360826667806852920L;
    public static final int MAX_VALUE = 0x7FFFFFFF;
    public static final int MIN_VALUE = 0x80000000;
    public static final int SIZE = 32;
    private static final byte[] NTZ_TABLE = {
        32,  0,  1, 12,  2,  6, -1, 13,   3, -1,  7, -1, -1, -1, -1, 14,
        10,  4, -1, -1,  8, -1, -1, 25,  -1, -1, -1, -1, -1, 21, 27, 15,
        31, 11,  5, -1, -1, -1, -1, -1,   9, -1, -1, 24, -1, -1, 20, 26,
        30, -1, -1, -1, -1, 23, -1, 19,  29, -1, 22, 18, 28, 17, 16, -1
    };
    @SuppressWarnings("unchecked") public static final Class<Integer> TYPE
            = (Class<Integer>) int[].class.getComponentType();
    private static final Integer[] SMALL_VALUES = new Integer[256];
    static {
        for (int i = -128; i < 128; i++) {
            SMALL_VALUES[i + 128] = new Integer(i);
        }
    }
    
}

