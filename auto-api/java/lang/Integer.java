package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;


public final class Integer extends Number implements Comparable<Integer> {
    private static final long serialVersionUID = 1360826667806852920L;
    private final int value;
    public static final int MAX_VALUE = 0x7FFFFFFF;
    public static final int MIN_VALUE = 0x80000000;
    public static final int SIZE = 32;
    private static final byte[] NTZ_TABLE = {
        32,  0,  1, 12,  2,  6, -1, 13,   3, -1,  7, -1, -1, -1, -1, 14,
        10,  4, -1, -1,  8, -1, -1, 25,  -1, -1, -1, -1, -1, 21, 27, 15,
        31, 11,  5, -1, -1, -1, -1, -1,   9, -1, -1, 24, -1, -1, 20, 26,
        30, -1, -1, -1, -1, 23, -1, 19,  29, -1, 22, 18, 28, 17, 16, -1
    };
    @SuppressWarnings("unchecked")
    public static final Class<Integer> TYPE
            = (Class<Integer>) int[].class.getComponentType();
    private static final Integer[] SMALL_VALUES = new Integer[256];
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:37.945 -0400", hash_original_method = "22146E0D9B2FD3EEBD460016C940A35F", hash_generated_method = "331B37B736099F1DC6D2E2B27BCEBEA1")
    @DSModeled(DSC.SAFE)
    public Integer(int value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        this.value = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:37.954 -0400", hash_original_method = "E0CD1D1A7D46CCFF15C90A26B138404A", hash_generated_method = "B4D9B6C17624E88DDE91C69418573FFB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Integer(String string) throws NumberFormatException {
        this(parseInt(string));
        dsTaint.addTaint(string);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:37.957 -0400", hash_original_method = "6B61312FC318A12A6B19178CA8B54E86", hash_generated_method = "736992B7E67C3D999A201F9A84C24906")
    @DSModeled(DSC.SAFE)
    @Override
    public byte byteValue() {
        return dsTaint.getTaintByte();
        // ---------- Original Method ----------
        //return (byte) value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:37.960 -0400", hash_original_method = "735EC7AEC4F3C97B9E273B68A8C134FA", hash_generated_method = "1E5CFF44B6E1519B8122CFA4CE0423DD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int compareTo(Integer object) {
        dsTaint.addTaint(object.dsTaint);
        int varEB17148B4676BC6C35C2467C947D57DF_1792091077 = (compare(value, object.value));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return compare(value, object.value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:37.966 -0400", hash_original_method = "08B34540C6F5E5FA9EF442057B264C3A", hash_generated_method = "04989A44666D307E13510E4935EA503C")
    public static int compare(int lhs, int rhs) {
        return lhs < rhs ? -1 : (lhs == rhs ? 0 : 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:37.974 -0400", hash_original_method = "A3A010FC05E6D36052109B2A32E2CE6D", hash_generated_method = "5EC1AE6DACF5D4E96A3AD3BE653B196C")
    private static NumberFormatException invalidInt(String s) {
        throw new NumberFormatException("Invalid int: \"" + s + "\"");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:37.978 -0400", hash_original_method = "46DA43F84FA71E66C3C03274BBD22B81", hash_generated_method = "3ABFBE25C2D84F1E621213D0CCED98AA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:37.992 -0400", hash_original_method = "3D3B0AF18CC8081B7BB4A7DC662E1F07", hash_generated_method = "49EEC8EBB7ED6B4F36B5020D75D881E3")
    @DSModeled(DSC.SAFE)
    @Override
    public double doubleValue() {
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:37.994 -0400", hash_original_method = "F74FD59F9B798AB03C90305DF48139A2", hash_generated_method = "FD60C90B43DDF7B47E0F429C5C30001A")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (o instanceof Integer) && (((Integer) o).value == value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.001 -0400", hash_original_method = "9E2C0918A44EC11D2232D0B603F66A6B", hash_generated_method = "DB3CE558B9651E2B1B184E75E5F9E192")
    @DSModeled(DSC.SAFE)
    @Override
    public float floatValue() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.003 -0400", hash_original_method = "F01C30BD973BCE191A7284E98D1A303E", hash_generated_method = "C1DAAE89FBE184F5C7F6A97080859E37")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.007 -0400", hash_original_method = "B43E44D829289B070CF83BC460D06D24", hash_generated_method = "A056FC57C20DB105CD700CA7A32403BB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.012 -0400", hash_original_method = "1037DE5287EEBEFE56735B40DF7AE5DF", hash_generated_method = "CE137B705D1095FFD41C9C3C5AC33FD8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.021 -0400", hash_original_method = "961F210287166DF05D8915D632129E75", hash_generated_method = "839D1EBE643B666CA5D1F1CA10397ED1")
    @DSModeled(DSC.SAFE)
    @Override
    public int hashCode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.026 -0400", hash_original_method = "4668226786F0223B69B1E8157F3C469B", hash_generated_method = "E67840FBE5C0D422A0583798AABFBB9C")
    @DSModeled(DSC.SAFE)
    @Override
    public int intValue() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.028 -0400", hash_original_method = "ABF4FE035C950AC910A646D4B85E3F35", hash_generated_method = "D82057610AE68E1F843DA669F2E2AAF4")
    @DSModeled(DSC.SAFE)
    @Override
    public long longValue() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.034 -0400", hash_original_method = "172D4BA10AB000BE273AA7D695E5C087", hash_generated_method = "675665531A005AF15842D70D6F7DDA9A")
    public static int parseInt(String string) throws NumberFormatException {
        return parseInt(string, 10);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.042 -0400", hash_original_method = "162A603AB5DA029339CF16BB4270637E", hash_generated_method = "0D0CF7EDC037A4D1AFC9A3CB92A5F5D8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.045 -0400", hash_original_method = "2DC7C613589A3F978B8CE07DBD570473", hash_generated_method = "E72E0B7A74CD7BF6ACF7E658CE311850")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.047 -0400", hash_original_method = "8E8C16CBE89F9837B346C9544C9B6BCC", hash_generated_method = "9D74A9F80DCC02694F100928EBEB58C3")
    @DSModeled(DSC.SAFE)
    @Override
    public short shortValue() {
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //return (short) value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.059 -0400", hash_original_method = "9D8F65BFD86E7A18329171709CBF3046", hash_generated_method = "E737365418F916A96DC7B6DCF8FED481")
    public static String toBinaryString(int i) {
        return IntegralToString.intToBinaryString(i);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.062 -0400", hash_original_method = "3979972EEEC4E88868F959A411D789BE", hash_generated_method = "C7BC11F923377AFB81EB38684EC95967")
    public static String toHexString(int i) {
        return IntegralToString.intToHexString(i, false, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.064 -0400", hash_original_method = "72067B50D522BDEF5353890C050CC074", hash_generated_method = "39DB8FB2BAD3FBA7DDE4A06C2EF9F726")
    public static String toOctalString(int i) {
        return IntegralToString.intToOctalString(i);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.066 -0400", hash_original_method = "6B315C20A4D45816791A47779D79F014", hash_generated_method = "0E84537FB6C3F38C9B2B7F641CB59167")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String varD42FC0CD51582E4DF744832DA0BFE096_2083228089 = (Integer.toString(value));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return Integer.toString(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.076 -0400", hash_original_method = "83FFC2042E386057ACE3416E6CB82244", hash_generated_method = "937E52F3011B3AAE21ECE10A2A8E9C67")
    public static String toString(int i) {
        return IntegralToString.intToString(i);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.078 -0400", hash_original_method = "175FD40B6A0B4257AFDD7BA871A3507B", hash_generated_method = "2703FF1CAB3D642CD02346A51DCCD5AB")
    public static String toString(int i, int radix) {
        return IntegralToString.intToString(i, radix);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.080 -0400", hash_original_method = "5ACE3593E04E738DABAA0EBD77FF5A76", hash_generated_method = "1FFF9C927A6EC61FA8BD3E3BBB9D1BF5")
    public static Integer valueOf(String string) throws NumberFormatException {
        return valueOf(parseInt(string));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.085 -0400", hash_original_method = "5859C0A727537B8EC88F05E2B2FE00D6", hash_generated_method = "F741D2A1942CB111613D0D4114618CDE")
    public static Integer valueOf(String string, int radix) throws NumberFormatException {
        return valueOf(parseInt(string, radix));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.092 -0400", hash_original_method = "07B15BCA74AC5BE2F84043AACB0A310C", hash_generated_method = "D0064F96AD481E78AE672059B5A9CABC")
    public static int highestOneBit(int i) {
        i |= (i >> 1);
        i |= (i >> 2);
        i |= (i >> 4);
        i |= (i >> 8);
        i |= (i >> 16);
        return i - (i >>> 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.095 -0400", hash_original_method = "ABFA2AA3044F8D161D7CA2C8E1F71BE9", hash_generated_method = "EE380301ABB52F8350D1090A1D5C072D")
    public static int lowestOneBit(int i) {
        return i & -i;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.098 -0400", hash_original_method = "B598B2644508791A0E6226CE6E4EC6FE", hash_generated_method = "24825EC0439624939DB136DE6EC5181F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.109 -0400", hash_original_method = "4E0FDC4B081A56937B6D10C201A74C79", hash_generated_method = "5F878702236102E0C1A09A31D227D083")
    public static int numberOfTrailingZeros(int i) {
        return NTZ_TABLE[((i & -i) * 0x0450FBAF) >>> 26];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.111 -0400", hash_original_method = "96F418696A4CBAC7A39E33CF390C9745", hash_generated_method = "DFCA7814A162B922F1146DCB1FC27454")
    public static int bitCount(int i) {
        i -= (i >> 1) & 0x55555555;
        i = (i & 0x33333333) + ((i >> 2) & 0x33333333);
        i = ((i >> 4) + i) & 0x0F0F0F0F;
        i += i >> 8;
        i += i >> 16;
        return i & 0x0000003F;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.113 -0400", hash_original_method = "EDB2D6790586ADFBD3CCB3C657FE979E", hash_generated_method = "8E09FA5D5652BABB8CA0EF969B60FD67")
    public static int rotateLeft(int i, int distance) {
        return (i << distance) | (i >>> -distance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.121 -0400", hash_original_method = "6074674D7A01ED6AECC5FC14865BC8F8", hash_generated_method = "30A017608142B0F248F289A26CF58D53")
    public static int rotateRight(int i, int distance) {
        return (i >>> distance) | (i << -distance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.126 -0400", hash_original_method = "E82979AF836D183FB2BABD0E0E7F3431", hash_generated_method = "AD990A9AB0CD455E44D458F4EF724189")
    public static int reverseBytes(int i) {
        i =    ((i >>>  8) & 0x00FF00FF) | ((i & 0x00FF00FF) <<  8);
        return ( i >>> 16              ) | ( i               << 16);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.133 -0400", hash_original_method = "8FB6A7484D99181743947553B04591B0", hash_generated_method = "214A82E1E19FF9DB1F6DA6F16289F0AE")
    public static int reverse(int i) {
        i =    ((i >>>  1) & 0x55555555) | ((i & 0x55555555) <<  1);
        i =    ((i >>>  2) & 0x33333333) | ((i & 0x33333333) <<  2);
        i =    ((i >>>  4) & 0x0F0F0F0F) | ((i & 0x0F0F0F0F) <<  4);
        i =    ((i >>>  8) & 0x00FF00FF) | ((i & 0x00FF00FF) <<  8);
        return ((i >>> 16)             ) | ((i             ) << 16);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.137 -0400", hash_original_method = "75E0F722BBDC662C077609CB74D0DBA7", hash_generated_method = "4336DF936C8E6AD9E0CF5196C89BC1BF")
    public static int signum(int i) {
        return (i >> 31) | (-i >>> 31);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.139 -0400", hash_original_method = "34E26A0F2F8E35922D8A4237B251C395", hash_generated_method = "FEB2B9F896E123B5C0527B185F160803")
    public static Integer valueOf(int i) {
        return  i >= 128 || i < -128 ? new Integer(i) : SMALL_VALUES[i + 128];
    }

    
    static {
        for (int i = -128; i < 128; i++) {
            SMALL_VALUES[i + 128] = new Integer(i);
        }
    }
    
}


