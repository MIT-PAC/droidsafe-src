package java.lang;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public final class Integer extends Number implements Comparable<Integer> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.178 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "810C3DA5CE7DA1BA423D6BE76816E5C9")

    private int value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.178 -0400", hash_original_method = "22146E0D9B2FD3EEBD460016C940A35F", hash_generated_method = "F4A1CCEE47CB188DE4B924DA0BBDC75E")
    public  Integer(int value) {
        this.value = value;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.179 -0400", hash_original_method = "E0CD1D1A7D46CCFF15C90A26B138404A", hash_generated_method = "C7D8A3D0A970F4CCFAE7CF1E10D54B3A")
    public  Integer(String string) throws NumberFormatException {
        this(parseInt(string));
        addTaint(string.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.179 -0400", hash_original_method = "6B61312FC318A12A6B19178CA8B54E86", hash_generated_method = "16A94DEF64F454A95299F02674388663")
    @Override
    public byte byteValue() {
        byte var40EA57D3EE3C07BF1C102B466E1C3091_748349924 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_748349924;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.179 -0400", hash_original_method = "735EC7AEC4F3C97B9E273B68A8C134FA", hash_generated_method = "9DC652B50872E024B360563E66F8A169")
    public int compareTo(Integer object) {
        int varEB17148B4676BC6C35C2467C947D57DF_1551795286 = (compare(value, object.value));
        addTaint(object.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1008443242 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1008443242;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static int compare(int lhs, int rhs) {
        return lhs < rhs ? -1 : (lhs == rhs ? 0 : 1);
    }

    
    @DSModeled(DSC.SAFE)
    private static NumberFormatException invalidInt(String s) {
        throw new NumberFormatException("Invalid int: \"" + s + "\"");
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.180 -0400", hash_original_method = "3D3B0AF18CC8081B7BB4A7DC662E1F07", hash_generated_method = "F54CE542FE4652379C489FF86F5BA5C8")
    @Override
    public double doubleValue() {
        double varE8CD7DA078A86726031AD64F35F5A6C0_410013126 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_410013126;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.180 -0400", hash_original_method = "F74FD59F9B798AB03C90305DF48139A2", hash_generated_method = "78A6ABD162FD747B4C644A2B997F6B80")
    @Override
    public boolean equals(Object o) {
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1051625583 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1051625583;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.180 -0400", hash_original_method = "9E2C0918A44EC11D2232D0B603F66A6B", hash_generated_method = "7E3066909B9D32CAD4A4A479054AD695")
    @Override
    public float floatValue() {
        float var546ADE640B6EDFBC8A086EF31347E768_1643251802 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1643251802;
        
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.181 -0400", hash_original_method = "961F210287166DF05D8915D632129E75", hash_generated_method = "F435F274E17204E6979DBE528348CBF1")
    @Override
    public int hashCode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1081647909 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1081647909;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.181 -0400", hash_original_method = "4668226786F0223B69B1E8157F3C469B", hash_generated_method = "65524BEAE563B0D50CF2C709501C5F7E")
    @Override
    public int intValue() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1195481980 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1195481980;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.182 -0400", hash_original_method = "ABF4FE035C950AC910A646D4B85E3F35", hash_generated_method = "EF06ECDE30D42469A7C77B4848D4864F")
    @Override
    public long longValue() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_730621936 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_730621936;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static int parseInt(String string) throws NumberFormatException {
        return parseInt(string, 10);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.183 -0400", hash_original_method = "8E8C16CBE89F9837B346C9544C9B6BCC", hash_generated_method = "CA042995F3D8420763A56366ACF4A958")
    @Override
    public short shortValue() {
        short var4F09DAA9D95BCB166A302407A0E0BABE_8595800 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_8595800;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static String toBinaryString(int i) {
        return IntegralToString.intToBinaryString(i);
    }

    
    @DSModeled(DSC.SAFE)
    public static String toHexString(int i) {
        return IntegralToString.intToHexString(i, false, 0);
    }

    
    @DSModeled(DSC.SAFE)
    public static String toOctalString(int i) {
        return IntegralToString.intToOctalString(i);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.184 -0400", hash_original_method = "6B315C20A4D45816791A47779D79F014", hash_generated_method = "8F55E7B0AA2C13DE1A4D2669EE02578C")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1844058882 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1844058882 = Integer.toString(value);
        varB4EAC82CA7396A68D541C85D26508E83_1844058882.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1844058882;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static String toString(int i) {
        return IntegralToString.intToString(i);
    }

    
    @DSModeled(DSC.SAFE)
    public static String toString(int i, int radix) {
        return IntegralToString.intToString(i, radix);
    }

    
    @DSModeled(DSC.SAFE)
    public static Integer valueOf(String string) throws NumberFormatException {
        return valueOf(parseInt(string));
    }

    
    @DSModeled(DSC.SAFE)
    public static Integer valueOf(String string, int radix) throws NumberFormatException {
        return valueOf(parseInt(string, radix));
    }

    
    @DSModeled(DSC.SAFE)
    public static int highestOneBit(int i) {
        i |= (i >> 1);
        i |= (i >> 2);
        i |= (i >> 4);
        i |= (i >> 8);
        i |= (i >> 16);
        return i - (i >>> 1);
    }

    
    @DSModeled(DSC.SAFE)
    public static int lowestOneBit(int i) {
        return i & -i;
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static int numberOfTrailingZeros(int i) {
        return NTZ_TABLE[((i & -i) * 0x0450FBAF) >>> 26];
    }

    
    @DSModeled(DSC.SAFE)
    public static int bitCount(int i) {
        i -= (i >> 1) & 0x55555555;
        i = (i & 0x33333333) + ((i >> 2) & 0x33333333);
        i = ((i >> 4) + i) & 0x0F0F0F0F;
        i += i >> 8;
        i += i >> 16;
        return i & 0x0000003F;
    }

    
    @DSModeled(DSC.SAFE)
    public static int rotateLeft(int i, int distance) {
        return (i << distance) | (i >>> -distance);
    }

    
    @DSModeled(DSC.SAFE)
    public static int rotateRight(int i, int distance) {
        return (i >>> distance) | (i << -distance);
    }

    
    @DSModeled(DSC.SAFE)
    public static int reverseBytes(int i) {
        i =    ((i >>>  8) & 0x00FF00FF) | ((i & 0x00FF00FF) <<  8);
        return ( i >>> 16              ) | ( i               << 16);
    }

    
    @DSModeled(DSC.SAFE)
    public static int reverse(int i) {
        i =    ((i >>>  1) & 0x55555555) | ((i & 0x55555555) <<  1);
        i =    ((i >>>  2) & 0x33333333) | ((i & 0x33333333) <<  2);
        i =    ((i >>>  4) & 0x0F0F0F0F) | ((i & 0x0F0F0F0F) <<  4);
        i =    ((i >>>  8) & 0x00FF00FF) | ((i & 0x00FF00FF) <<  8);
        return ((i >>> 16)             ) | ((i             ) << 16);
    }

    
    @DSModeled(DSC.SAFE)
    public static int signum(int i) {
        return (i >> 31) | (-i >>> 31);
    }

    
    @DSModeled(DSC.SAFE)
    public static Integer valueOf(int i) {
        return  i >= 128 || i < -128 ? new Integer(i) : SMALL_VALUES[i + 128];
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.186 -0400", hash_original_field = "58F18909B0F81D2156ED8B75F6324259", hash_generated_field = "88D0C92B83B1D40D76F4FBB954A2A9E5")

    private static final long serialVersionUID = 1360826667806852920L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.186 -0400", hash_original_field = "57413E9209A87703B8BA6098E2B6DB80", hash_generated_field = "3BDA0DF3C86CD680ACE62390D2B524ED")

    public static final int MAX_VALUE = 0x7FFFFFFF;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.186 -0400", hash_original_field = "ACB61A70235AF892570EB8C34E753962", hash_generated_field = "36D06DCD804B103124720EBA9F7340A9")

    public static final int MIN_VALUE = 0x80000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.186 -0400", hash_original_field = "2ADF4761385B682BC0DA2831DB6315E2", hash_generated_field = "63FA0385596F5F13183B5684F35B159F")

    public static final int SIZE = 32;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.186 -0400", hash_original_field = "AEDC44522CC4C4CC67CC1460BA1F5412", hash_generated_field = "F9D89F9F328AFF2D37ED87D088C176D7")

    private static final byte[] NTZ_TABLE = {
        32,  0,  1, 12,  2,  6, -1, 13,   3, -1,  7, -1, -1, -1, -1, 14,
        10,  4, -1, -1,  8, -1, -1, 25,  -1, -1, -1, -1, -1, 21, 27, 15,
        31, 11,  5, -1, -1, -1, -1, -1,   9, -1, -1, 24, -1, -1, 20, 26,
        30, -1, -1, -1, -1, 23, -1, 19,  29, -1, 22, 18, 28, 17, 16, -1
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.186 -0400", hash_original_field = "2CE02B937AE0B3F8680FE97AECD4FC0E", hash_generated_field = "073FFFEFB41314D95534816366682FCC")

    @SuppressWarnings("unchecked")
    public static final Class<Integer> TYPE
            = (Class<Integer>) int[].class.getComponentType();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.186 -0400", hash_original_field = "477FBCA35ED0655CBD69BEC398733B9B", hash_generated_field = "2B503CD004C95B2E1022E1C894D7A1A1")

    private static final Integer[] SMALL_VALUES = new Integer[256];
    static {
        for (int i = -128; i < 128; i++) {
            SMALL_VALUES[i + 128] = new Integer(i);
        }
    }
    
}

