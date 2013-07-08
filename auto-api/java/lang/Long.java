package java.lang;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public final class Long extends Number implements Comparable<Long> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.293 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "8A7F925BC1BBEBA69C20FE023280FB40")

    private long value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.293 -0400", hash_original_method = "F7421F28ECB11D742A45928A1DF88A80", hash_generated_method = "5A444BA7F41E5A7F34C5C8078DB04F37")
    public  Long(long value) {
        this.value = value;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.294 -0400", hash_original_method = "FBD907393492057451D7BFE621A4E030", hash_generated_method = "EB1664B2E0B2D14FE1ECCC22062306DD")
    public  Long(String string) throws NumberFormatException {
        this(parseLong(string));
        addTaint(string.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.294 -0400", hash_original_method = "6B61312FC318A12A6B19178CA8B54E86", hash_generated_method = "0047E74ADBA112394DC25D838BA04035")
    @Override
    public byte byteValue() {
        byte var40EA57D3EE3C07BF1C102B466E1C3091_1921897128 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_1921897128;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.294 -0400", hash_original_method = "B49F758A210AD21F31F3B71259593715", hash_generated_method = "C8ECDB0F651AED53797BC0E4ADDB8390")
    public int compareTo(Long object) {
        int varEB17148B4676BC6C35C2467C947D57DF_1508121410 = (compare(value, object.value));
        addTaint(object.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_879097250 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_879097250;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static int compare(long lhs, long rhs) {
        return lhs < rhs ? -1 : (lhs == rhs ? 0 : 1);
    }

    
    @DSModeled(DSC.SAFE)
    private static NumberFormatException invalidLong(String s) {
        throw new NumberFormatException("Invalid long: \"" + s + "\"");
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.295 -0400", hash_original_method = "3D3B0AF18CC8081B7BB4A7DC662E1F07", hash_generated_method = "07FF8366DF8A3126DB26C763F3514C69")
    @Override
    public double doubleValue() {
        double varE8CD7DA078A86726031AD64F35F5A6C0_575307523 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_575307523;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.296 -0400", hash_original_method = "9DAD4C26B4F70BDE1AF6A261529DF01A", hash_generated_method = "ECBC653EFDAD3A5E6A8EE5059A8F4D0A")
    @Override
    public boolean equals(Object o) {
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1949577284 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1949577284;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.296 -0400", hash_original_method = "9E2C0918A44EC11D2232D0B603F66A6B", hash_generated_method = "153DA5787A0B0DE110330FA405F41D2A")
    @Override
    public float floatValue() {
        float var546ADE640B6EDFBC8A086EF31347E768_1970955106 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1970955106;
        
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.297 -0400", hash_original_method = "7CEEFB1EC71C1E868FBC10557351E2DA", hash_generated_method = "2FA352D35471329EA6614C0CCC23F353")
    @Override
    public int hashCode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_998062440 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_998062440;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.298 -0400", hash_original_method = "138584002FB2DE9D0E5B5F8DAEDB3270", hash_generated_method = "A4F73998075891B739F3172184DDDB28")
    @Override
    public int intValue() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1432585376 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1432585376;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.298 -0400", hash_original_method = "ABF4FE035C950AC910A646D4B85E3F35", hash_generated_method = "FE98CAE363A6A1767B587D26E71D920C")
    @Override
    public long longValue() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1587783595 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1587783595;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static long parseLong(String string) throws NumberFormatException {
        return parseLong(string, 10);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.299 -0400", hash_original_method = "8E8C16CBE89F9837B346C9544C9B6BCC", hash_generated_method = "C8B8684B37182B8AB5AED550AADD5DC0")
    @Override
    public short shortValue() {
        short var4F09DAA9D95BCB166A302407A0E0BABE_489181435 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_489181435;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static String toBinaryString(long v) {
        return IntegralToString.longToBinaryString(v);
    }

    
    @DSModeled(DSC.SAFE)
    public static String toHexString(long v) {
        return IntegralToString.longToHexString(v);
    }

    
    @DSModeled(DSC.SAFE)
    public static String toOctalString(long v) {
        return IntegralToString.longToOctalString(v);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.300 -0400", hash_original_method = "6878CA43BE92FEF897301589A58FE568", hash_generated_method = "2ED80ED5626581086B39A7FE7E143661")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_460037583 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_460037583 = Long.toString(value);
        varB4EAC82CA7396A68D541C85D26508E83_460037583.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_460037583;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static String toString(long n) {
        return IntegralToString.longToString(n);
    }

    
    @DSModeled(DSC.SAFE)
    public static String toString(long v, int radix) {
        return IntegralToString.longToString(v, radix);
    }

    
    @DSModeled(DSC.SAFE)
    public static Long valueOf(String string) throws NumberFormatException {
        return valueOf(parseLong(string));
    }

    
    @DSModeled(DSC.SAFE)
    public static Long valueOf(String string, int radix) throws NumberFormatException {
        return valueOf(parseLong(string, radix));
    }

    
    @DSModeled(DSC.SAFE)
    public static long highestOneBit(long v) {
        v |= (v >> 1);
        v |= (v >> 2);
        v |= (v >> 4);
        v |= (v >> 8);
        v |= (v >> 16);
        v |= (v >> 32);
        return v - (v >>> 1);
    }

    
    @DSModeled(DSC.SAFE)
    public static long lowestOneBit(long v) {
        return v & -v;
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static int numberOfTrailingZeros(long v) {
        int low = (int) v;
        return low !=0 ? Integer.numberOfTrailingZeros(low)
                       : 32 + Integer.numberOfTrailingZeros((int) (v >>> 32));
    }

    
    @DSModeled(DSC.SAFE)
    public static int bitCount(long v) {
        v -=  (v >>> 1) & 0x5555555555555555L;
        v = (v & 0x3333333333333333L) + ((v >>> 2) & 0x3333333333333333L);
        int i =  ((int)(v >>> 32)) + (int) v;
        i = (i & 0x0F0F0F0F) + ((i >>> 4) & 0x0F0F0F0F);
        i += i >>> 8;
        i += i >>> 16;
        return i  & 0x0000007F;
    }

    
    @DSModeled(DSC.SAFE)
    public static long rotateLeft(long v, int distance) {
        return (v << distance) | (v >>> -distance);
    }

    
    @DSModeled(DSC.SAFE)
    public static long rotateRight(long v, int distance) {
        return (v >>> distance) | (v << -distance);
    }

    
    @DSModeled(DSC.SAFE)
    public static long reverseBytes(long v) {
        v = ((v >>> 8) & 0x00FF00FF00FF00FFL) | ((v & 0x00FF00FF00FF00FFL) << 8);
        v = ((v >>>16) & 0x0000FFFF0000FFFFL) | ((v & 0x0000FFFF0000FFFFL) <<16);
        return ((v >>>32)                   ) | ((v                      ) <<32);
    }

    
    @DSModeled(DSC.SAFE)
    public static long reverse(long v) {
        v = ((v >>> 1) & 0x5555555555555555L) | ((v & 0x5555555555555555L) << 1);
        v = ((v >>> 2) & 0x3333333333333333L) | ((v & 0x3333333333333333L) << 2);
        v = ((v >>> 4) & 0x0F0F0F0F0F0F0F0FL) | ((v & 0x0F0F0F0F0F0F0F0FL) << 4);
        v = ((v >>> 8) & 0x00FF00FF00FF00FFL) | ((v & 0x00FF00FF00FF00FFL) << 8);
        v = ((v >>>16) & 0x0000FFFF0000FFFFL) | ((v & 0x0000FFFF0000FFFFL) <<16);
        return ((v >>>32)                   ) | ((v                      ) <<32);
    }

    
    @DSModeled(DSC.SAFE)
    public static int signum(long v) {
        return v < 0 ? -1 : (v == 0 ? 0 : 1);
    }

    
    @DSModeled(DSC.SAFE)
    public static Long valueOf(long v) {
        return  v >= 128 || v < -128 ? new Long(v) : SMALL_VALUES[((int) v) + 128];
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.302 -0400", hash_original_field = "44CE7F85928786949F80F1045DC5FE2F", hash_generated_field = "2DEB2A3C564958CD30E19E2E40A09F63")

    private static final long serialVersionUID = 4290774380558885855L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.302 -0400", hash_original_field = "737ABDA3AACFC49D3C9DE9B906C528EC", hash_generated_field = "6A687F94CB3540BCBE64F3A2D65BF860")

    public static final long MAX_VALUE = 0x7FFFFFFFFFFFFFFFL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.302 -0400", hash_original_field = "E2C1ADD83FF4A449C0F7F20AA8AE96AD", hash_generated_field = "2C18D3CE50E188B1C1E009DC3946478A")

    public static final long MIN_VALUE = 0x8000000000000000L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.302 -0400", hash_original_field = "5F5F992F68FAE61D99A6FEB2265938EC", hash_generated_field = "57ADF8471073F1A212186F7FAF5B7D3E")

    @SuppressWarnings("unchecked")
    public static final Class<Long> TYPE
            = (Class<Long>) long[].class.getComponentType();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.302 -0400", hash_original_field = "BEF545AA11A759CEB31C53B46631D67E", hash_generated_field = "9A4CFA4F02C5D68B7BDAB9B36D90F8D9")

    public static final int SIZE = 64;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.303 -0400", hash_original_field = "5FFBAB6682D99F393A6C9EB918276D1E", hash_generated_field = "202F4351B1469287DCC673EA94D22CDB")

    private static final Long[] SMALL_VALUES = new Long[256];
    static {
        for (int i = -128; i < 128; i++) {
            SMALL_VALUES[i + 128] = new Long(i);
        }
    }
    
}

