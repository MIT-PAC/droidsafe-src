package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public final class Long extends Number implements Comparable<Long> {

    /**
     * Compares two {@code long} values.
     * @return 0 if lhs = rhs, less than 0 if lhs &lt; rhs, and greater than 0 if lhs &gt; rhs.
     * @since 1.7
     * @hide 1.7
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.196 -0500", hash_original_method = "AF31214DC9658698FC6F93EE1A427F5A", hash_generated_method = "8A15ED8494923E2C5CF33F19A2C4ADA1")
    
public static int compare(long lhs, long rhs) {
        //return lhs < rhs ? -1 : (lhs == rhs ? 0 : 1);
        return (int)(lhs - rhs);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.198 -0500", hash_original_method = "87BAE2A40D900C787A26458C6932A3FF", hash_generated_method = "CBD1511248566B5C03055A6057451706")
    
private static NumberFormatException invalidLong(String s) {
        throw new NumberFormatException("Invalid long: \"" + s + "\"");
    }

    /**
     * Parses the specified string and returns a {@code Long} instance if the
     * string can be decoded into a long value. The string may be an optional
     * minus sign "-" followed by a hexadecimal ("0x..." or "#..."), octal
     * ("0..."), or decimal ("...") representation of a long.
     *
     * @param string
     *            a string representation of a long value.
     * @return a {@code Long} containing the value represented by {@code string}.
     * @throws NumberFormatException
     *             if {@code string} cannot be parsed as a long value.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.201 -0500", hash_original_method = "C4DE08B293D744CFBD0C37997765A17D", hash_generated_method = "DDB4A5686FCB85EB3F25017717543770")
    
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

    /**
     * Returns the {@code Long} value of the system property identified by
     * {@code string}. Returns {@code null} if {@code string} is {@code null}
     * or empty, if the property can not be found or if its value can not be
     * parsed as a long.
     *
     * @param string
     *            the name of the requested system property.
     * @return the requested property's value as a {@code Long} or {@code null}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.212 -0500", hash_original_method = "9035D6AEDC958DB855473DD21BCDD233", hash_generated_method = "2124D74FC6C56B6F6CB5EE22747C0FA3")
    
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

    /**
     * Returns the {@code Long} value of the system property identified by
     * {@code string}. Returns the specified default value if {@code string} is
     * {@code null} or empty, if the property can not be found or if its value
     * can not be parsed as a long.
     *
     * @param string
     *            the name of the requested system property.
     * @param defaultValue
     *            the default value that is returned if there is no long system
     *            property with the requested name.
     * @return the requested property's value as a {@code Long} or the default
     *         value.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.215 -0500", hash_original_method = "6EAF4D8AF90235D6552C9CEB2581B7A8", hash_generated_method = "C199CDD233762D94E5433D06E745403D")
    
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

    /**
     * Returns the {@code Long} value of the system property identified by
     * {@code string}. Returns the specified default value if {@code string} is
     * {@code null} or empty, if the property can not be found or if its value
     * can not be parsed as a long.
     *
     * @param string
     *            the name of the requested system property.
     * @param defaultValue
     *            the default value that is returned if there is no long system
     *            property with the requested name.
     * @return the requested property's value as a {@code Long} or the default
     *         value.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.218 -0500", hash_original_method = "DCCDDF7521D917FC949C1A5151409355", hash_generated_method = "C4FB6D089F37C31BBD0FE0E6C1C3BE0F")
    
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

    /**
     * Parses the specified string as a signed decimal long value. The ASCII
     * character \u002d ('-') is recognized as the minus sign.
     *
     * @param string
     *            the string representation of a long value.
     * @return the primitive long value represented by {@code string}.
     * @throws NumberFormatException
     *             if {@code string} cannot be parsed as a long value.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.227 -0500", hash_original_method = "40543B72DB43DB0F89BABF52692EB942", hash_generated_method = "8FD8A8A6BBF3AE39438B1FC3917E9E4E")
    
public static long parseLong(String string) throws NumberFormatException {
        return parseLong(string, 10);
    }

    /**
     * Parses the specified string as a signed long value using the specified
     * radix. The ASCII character \u002d ('-') is recognized as the minus sign.
     *
     * @param string
     *            the string representation of a long value.
     * @param radix
     *            the radix to use when parsing.
     * @return the primitive long value represented by {@code string} using
     *         {@code radix}.
     * @throws NumberFormatException
     *             if {@code string} cannot be parsed as a long value, or
     *             {@code radix < Character.MIN_RADIX ||
     *             radix > Character.MAX_RADIX}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.230 -0500", hash_original_method = "37F9F64824FAF4D2E17AC94C2167510B", hash_generated_method = "08F133E83B9B1B64AA4CE7E30D669FA8")
    
public static long parseLong(String string, int radix) throws NumberFormatException {
        /*
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
        */
        return (string.length() + radix);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.233 -0500", hash_original_method = "5F099721BA22F8C0462415F93D75AC09", hash_generated_method = "1B5D6A65FF554EB847E082D6FEBAD556")
    
private static long parse(String string, int offset, int radix, boolean negative) {
        /*
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
        */
        
        return (string.length() + offset + radix + ((negative) ? 1 : 0));
    }

    /**
     * Converts the specified long value into its binary string representation.
     * The returned string is a concatenation of '0' and '1' characters.
     *
     * @param v
     *            the long value to convert.
     * @return the binary string representation of {@code v}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.239 -0500", hash_original_method = "054A3F820797F764C7C7D974F4C364D1", hash_generated_method = "7F5E73E17D01222EB9B6DC63B047D775")
    
public static String toBinaryString(long v) {
        return IntegralToString.longToBinaryString(v);
    }

    /**
     * Converts the specified long value into its hexadecimal string
     * representation. The returned string is a concatenation of characters from
     * '0' to '9' and 'a' to 'f'.
     *
     * @param v
     *            the long value to convert.
     * @return the hexadecimal string representation of {@code l}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.241 -0500", hash_original_method = "6B85F90491881D2C299E5BF02CCF5806", hash_generated_method = "82489B93E2C39EE14F117933CF49B12C")
    
public static String toHexString(long v) {
        return IntegralToString.longToHexString(v);
    }

    /**
     * Converts the specified long value into its octal string representation.
     * The returned string is a concatenation of characters from '0' to '7'.
     *
     * @param v
     *            the long value to convert.
     * @return the octal string representation of {@code l}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.244 -0500", hash_original_method = "7F9E047B51DBA75DC18A757B80E882F7", hash_generated_method = "DB1114BC7A734B93414409E7AC5A0CD5")
    
public static String toOctalString(long v) {
        return IntegralToString.longToOctalString(v);
    }

    /**
     * Converts the specified long value into its decimal string representation.
     * The returned string is a concatenation of a minus sign if the number is
     * negative and characters from '0' to '9'.
     *
     * @param n
     *            the long to convert.
     * @return the decimal string representation of {@code l}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.249 -0500", hash_original_method = "5451D461541A6217AC0EFFC2EF4C9329", hash_generated_method = "4017904D62B0FEC0C72BF95924032E36")
    
public static String toString(long n) {
        return IntegralToString.longToString(n);
    }

    /**
     * Converts the specified signed long value into a string representation based on
     * the specified radix. The returned string is a concatenation of a minus
     * sign if the number is negative and characters from '0' to '9' and 'a' to
     * 'z', depending on the radix. If {@code radix} is not in the interval
     * defined by {@code Character.MIN_RADIX} and {@code Character.MAX_RADIX}
     * then 10 is used as the base for the conversion.
     *
     * <p>This method treats its argument as signed. If you want to convert an
     * unsigned value to one of the common non-decimal bases, you may find
     * {@link #toBinaryString}, {@code #toHexString}, or {@link #toOctalString}
     * more convenient.
     *
     * @param v
     *            the signed long to convert.
     * @param radix
     *            the base to use for the conversion.
     * @return the string representation of {@code v}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.251 -0500", hash_original_method = "E70E35D7AD8B9CABB3BD011FA70B18B3", hash_generated_method = "EB5747C682923FE90CBB8319D454C726")
    
public static String toString(long v, int radix) {
        return IntegralToString.longToString(v, radix);
    }

    /**
     * Parses the specified string as a signed decimal long value.
     *
     * @param string
     *            the string representation of a long value.
     * @return a {@code Long} instance containing the long value represented by
     *         {@code string}.
     * @throws NumberFormatException
     *             if {@code string} cannot be parsed as a long value.
     * @see #parseLong(String)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.254 -0500", hash_original_method = "5329D88830912459D833DA651EF25565", hash_generated_method = "978F13491909EB135627806DA513B029")
    
public static Long valueOf(String string) throws NumberFormatException {
        return valueOf(parseLong(string));
    }

    /**
     * Parses the specified string as a signed long value using the specified
     * radix.
     *
     * @param string
     *            the string representation of a long value.
     * @param radix
     *            the radix to use when parsing.
     * @return a {@code Long} instance containing the long value represented by
     *         {@code string} using {@code radix}.
     * @throws NumberFormatException
     *             if {@code string} cannot be parsed as a long value, or
     *             {@code radix < Character.MIN_RADIX ||
     *             radix > Character.MAX_RADIX}.
     * @see #parseLong(String, int)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.256 -0500", hash_original_method = "5CBCB44F730AFA5B014234B536635195", hash_generated_method = "5E69CBAD463CAB8D45FF21CFF47912ED")
    
public static Long valueOf(String string, int radix) throws NumberFormatException {
        return valueOf(parseLong(string, radix));
    }

    /**
     * Determines the highest (leftmost) bit of the specified long value that is
     * 1 and returns the bit mask value for that bit. This is also referred to
     * as the Most Significant 1 Bit. Returns zero if the specified long is
     * zero.
     *
     * @param v
     *            the long to examine.
     * @return the bit mask indicating the highest 1 bit in {@code v}.
     * @since 1.5
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.259 -0500", hash_original_method = "30CB5FC67E5FCAC16AC8505B4CB757BB", hash_generated_method = "C3A475F4003E6E2EB8D44D7F90CE7207")
    
public static long highestOneBit(long v) {
        // Hacker's Delight, Figure 3-1
        v |= (v >> 1);
        v |= (v >> 2);
        v |= (v >> 4);
        v |= (v >> 8);
        v |= (v >> 16);
        v |= (v >> 32);
        return v - (v >>> 1);
    }

    /**
     * Determines the lowest (rightmost) bit of the specified long value that is
     * 1 and returns the bit mask value for that bit. This is also referred to
     * as the Least Significant 1 Bit. Returns zero if the specified long is
     * zero.
     *
     * @param v
     *            the long to examine.
     * @return the bit mask indicating the lowest 1 bit in {@code v}.
     * @since 1.5
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.262 -0500", hash_original_method = "B81137E6BD6C07F65D7774D0D377E124", hash_generated_method = "0BE63B09E527B1405383654C0D2144C9")
    
public static long lowestOneBit(long v) {
        return v & -v;
    }

    /**
     * Determines the number of leading zeros in the specified long value prior
     * to the {@link #highestOneBit(long) highest one bit}.
     *
     * @param v
     *            the long to examine.
     * @return the number of leading zeros in {@code v}.
     * @since 1.5
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.265 -0500", hash_original_method = "33961C72BAE219042F19AFFF80ED0D48", hash_generated_method = "2187BAEA08FC8352E01EA4B85E01D4F6")
    
public static int numberOfLeadingZeros(long v) {
        // After Hacker's Delight, Figure 5-6
        if (v < 0) {
            return 0;
        }
        if (v == 0) {
            return 64;
        }
        // On a 64-bit VM, the two previous tests should probably be replaced by
        // if (v <= 0) return ((int) (~v >> 57)) & 64;

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

    /**
     * Determines the number of trailing zeros in the specified long value after
     * the {@link #lowestOneBit(long) lowest one bit}.
     *
     * @param v
     *            the long to examine.
     * @return the number of trailing zeros in {@code v}.
     * @since 1.5
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.267 -0500", hash_original_method = "742DD812D57640DE025BDD2284962D31", hash_generated_method = "F898CDA751901199B3054D7A96183C59")
    
public static int numberOfTrailingZeros(long v) {
        /*
        int low = (int) v;
        return low !=0 ? Integer.numberOfTrailingZeros(low)
                       : 32 + Integer.numberOfTrailingZeros((int) (v >>> 32));
        */
        return (int)v;
    }

    /**
     * Counts the number of 1 bits in the specified long value; this is also
     * referred to as population count.
     *
     * @param v
     *            the long to examine.
     * @return the number of 1 bits in {@code v}.
     * @since 1.5
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.269 -0500", hash_original_method = "E6B8A87E363F5B01FA470053AAF5BDFD", hash_generated_method = "4AAEE0D7878EBFB345095E6687BB47F9")
    
public static int bitCount(long v) {
        // Combines techniques from several sources
        v -=  (v >>> 1) & 0x5555555555555555L;
        v = (v & 0x3333333333333333L) + ((v >>> 2) & 0x3333333333333333L);
        int i =  ((int)(v >>> 32)) + (int) v;
        i = (i & 0x0F0F0F0F) + ((i >>> 4) & 0x0F0F0F0F);
        i += i >>> 8;
        i += i >>> 16;
        return i  & 0x0000007F;
    }

    /*
     * On a modern 64-bit processor with a fast hardware multiply, this is
     * much faster (assuming you're running a 64-bit VM):
     *
     * // http://chessprogramming.wikispaces.com/Population+Count
     * int bitCount (long x) {
     *     x -=  (x >>> 1) & 0x5555555555555555L;
     *     x = (x & 0x3333333333333333L) + ((x >>> 2) & 0x3333333333333333L);
     *     x = (x + (x >>> 4)) & 0x0f0f0f0f0f0f0f0fL;
     *     x = (x * 0x0101010101010101L) >>> 56;
     *     return (int) x;
     * }
     *
     * Really modern processors (e.g., Nehalem, K-10) have hardware popcount
     * instructions.
     */

    /**
     * Rotates the bits of the specified long value to the left by the specified
     * number of bits.
     *
     * @param v
     *            the long value to rotate left.
     * @param distance
     *            the number of bits to rotate.
     * @return the rotated value.
     * @since 1.5
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.272 -0500", hash_original_method = "5AB94474E1DC309D9D6AD0273D58BFE8", hash_generated_method = "B5F7B1C540646214975522439FBE3C1E")
    
public static long rotateLeft(long v, int distance) {
        // Shift distances are mod 64 (JLS3 15.19), so we needn't mask -distance
        return (v << distance) | (v >>> -distance);
    }

    /**
     * Rotates the bits of the specified long value to the right by the
     * specified number of bits.
     *
     * @param v
     *            the long value to rotate right.
     * @param distance
     *            the number of bits to rotate.
     * @return the rotated value.
     * @since 1.5
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.274 -0500", hash_original_method = "B06DCE1DF709801335FC6880CADA9E72", hash_generated_method = "E8B99B66CF7B8D547C92FB35AF020C1A")
    
public static long rotateRight(long v, int distance) {
        // Shift distances are mod 64 (JLS3 15.19), so we needn't mask -distance
        return (v >>> distance) | (v << -distance);
    }

    /**
     * Reverses the order of the bytes of the specified long value.
     *
     * @param v
     *            the long value for which to reverse the byte order.
     * @return the reversed value.
     * @since 1.5
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.278 -0500", hash_original_method = "BBF1769C3A61AA8AD42E4ABB1FF8D517", hash_generated_method = "CF4196B29E5BFE269824F26B0BCEAE9C")
    
public static long reverseBytes(long v) {
        // Hacker's Delight 7-1, with minor tweak from Veldmeijer
        // http://graphics.stanford.edu/~seander/bithacks.html
        v = ((v >>> 8) & 0x00FF00FF00FF00FFL) | ((v & 0x00FF00FF00FF00FFL) << 8);
        v = ((v >>>16) & 0x0000FFFF0000FFFFL) | ((v & 0x0000FFFF0000FFFFL) <<16);
        return ((v >>>32)                   ) | ((v                      ) <<32);
    }

    /**
     * Reverses the order of the bits of the specified long value.
     *
     * @param v
     *            the long value for which to reverse the bit order.
     * @return the reversed value.
     * @since 1.5
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.280 -0500", hash_original_method = "3BB60B8557B70E4713CB12DD6901C8CC", hash_generated_method = "012C2B63A931A3FB2219E4D915578546")
    
public static long reverse(long v) {
        // Hacker's Delight 7-1, with minor tweak from Veldmeijer
        // http://graphics.stanford.edu/~seander/bithacks.html
        v = ((v >>> 1) & 0x5555555555555555L) | ((v & 0x5555555555555555L) << 1);
        v = ((v >>> 2) & 0x3333333333333333L) | ((v & 0x3333333333333333L) << 2);
        v = ((v >>> 4) & 0x0F0F0F0F0F0F0F0FL) | ((v & 0x0F0F0F0F0F0F0F0FL) << 4);
        v = ((v >>> 8) & 0x00FF00FF00FF00FFL) | ((v & 0x00FF00FF00FF00FFL) << 8);
        v = ((v >>>16) & 0x0000FFFF0000FFFFL) | ((v & 0x0000FFFF0000FFFFL) <<16);
        return ((v >>>32)                   ) | ((v                      ) <<32);
    }

    /**
     * Returns the value of the {@code signum} function for the specified long
     * value.
     *
     * @param v
     *            the long value to check.
     * @return -1 if {@code v} is negative, 1 if {@code v} is positive, 0 if
     *         {@code v} is zero.
     * @since 1.5
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.283 -0500", hash_original_method = "0CBF54C07708EF45E17A96AD3CF57EA7", hash_generated_method = "87B8366929744E4279F48A5481612CFC")
    
public static int signum(long v) {
        return v < 0 ? -1 : (v == 0 ? 0 : 1);
    }

    /**
     * Returns a {@code Long} instance for the specified long value.
     * <p>
     * If it is not necessary to get a new {@code Long} instance, it is
     * recommended to use this method instead of the constructor, since it
     * maintains a cache of instances which may result in better performance.
     *
     * @param v
     *            the long value to store in the instance.
     * @return a {@code Long} instance containing {@code v}.
     * @since 1.5
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.285 -0500", hash_original_method = "8F2CF5A217071E0F4A3781D5167C1BC6", hash_generated_method = "137B180EC478CCA493863FFA3A3D4729")
    
public static Long valueOf(long v) {
        return new Long(v);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.170 -0500", hash_original_field = "3694E207E9FA390D67DFF54E3EB6C15C", hash_generated_field = "2DEB2A3C564958CD30E19E2E40A09F63")

    private static final long serialVersionUID = 4290774380558885855L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.175 -0500", hash_original_field = "936999DF46F7B5DA279E7D40F081AB37", hash_generated_field = "6A687F94CB3540BCBE64F3A2D65BF860")

    public static final long MAX_VALUE = 0x7FFFFFFFFFFFFFFFL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.178 -0500", hash_original_field = "92A314637E69F366D7A7D8C26486E35E", hash_generated_field = "2C18D3CE50E188B1C1E009DC3946478A")

    public static final long MIN_VALUE = 0x8000000000000000L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.180 -0500", hash_original_field = "7ED28B5E78A9EAA21806974B8BAB8FD7", hash_generated_field = "57ADF8471073F1A212186F7FAF5B7D3E")

    @SuppressWarnings("unchecked")
    public static final Class<Long> TYPE
            = (Class<Long>) long[].class.getComponentType();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.183 -0500", hash_original_field = "3FE546B3A2686882FFF20CAC96A9D377", hash_generated_field = "CE30BD1708F50091494AB5D34447B413")

    // defined to be "java.lang.Long.TYPE";

    /**
     * Constant for the number of bits needed to represent a {@code long} in
     * two's complement form.
     *
     * @since 1.5
     */
    public static final int SIZE = 64;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.173 -0500", hash_original_field = "DDD221DA9F0E75EE691CFACED8C3397A", hash_generated_field = "8A7F925BC1BBEBA69C20FE023280FB40")

    private  long value;

    /**
     * Constructs a new {@code Long} with the specified primitive long value.
     *
     * @param value
     *            the primitive long value to store in the new instance.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.186 -0500", hash_original_method = "F7421F28ECB11D742A45928A1DF88A80", hash_generated_method = "C881530C83685CC8A13E1C945742B04A")
    
public Long(long value) {
        this.value = value;
        addTaint(value);
    }

    /**
     * Constructs a new {@code Long} from the specified string.
     *
     * @param string
     *            the string representation of a long value.
     * @throws NumberFormatException
     *             if {@code string} cannot be parsed as a long value.
     * @see #parseLong(String)
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.189 -0500", hash_original_method = "FBD907393492057451D7BFE621A4E030", hash_generated_method = "CFB280A7B8AB2A0D00761A7CE10CA5F9")
    
public Long(String string) throws NumberFormatException {
        this(parseLong(string));
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.191 -0500", hash_original_method = "6B61312FC318A12A6B19178CA8B54E86", hash_generated_method = "4C2FE469A77605BE0BF5A0C525E46699")
    
@Override
    public byte byteValue() {
        return (byte) value;
    }

    /**
     * Compares this object to the specified long object to determine their
     * relative order.
     *
     * @param object
     *            the long object to compare this object to.
     * @return a negative value if the value of this long is less than the value
     *         of {@code object}; 0 if the value of this long and the value of
     *         {@code object} are equal; a positive value if the value of this
     *         long is greater than the value of {@code object}.
     * @see java.lang.Comparable
     * @since 1.2
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.193 -0500", hash_original_method = "B49F758A210AD21F31F3B71259593715", hash_generated_method = "8E72B18CCD8FE382703DB68F2A4AF3C9")
    
public int compareTo(Long object) {
        return compare(value, object.value);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.204 -0500", hash_original_method = "3D3B0AF18CC8081B7BB4A7DC662E1F07", hash_generated_method = "BF89BE4469CF5E691A2C43432BBB5D3E")
    
@Override
    public double doubleValue() {
        return value;
    }

    /**
     * Compares this instance with the specified object and indicates if they
     * are equal. In order to be equal, {@code o} must be an instance of
     * {@code Long} and have the same long value as this object.
     *
     * @param o
     *            the object to compare this long with.
     * @return {@code true} if the specified object is equal to this
     *         {@code Long}; {@code false} otherwise.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.207 -0500", hash_original_method = "9DAD4C26B4F70BDE1AF6A261529DF01A", hash_generated_method = "126975311CD059CCC2CB348FF28481B8")
    
@Override
    public boolean equals(Object o) {
        //return (o instanceof Long) && (((Long) o).value == value);
        return super.equals(o);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.210 -0500", hash_original_method = "9E2C0918A44EC11D2232D0B603F66A6B", hash_generated_method = "0138C4AD160C9AAF1F0B41D5F85236C8")
    
@Override
    public float floatValue() {
        return value;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.220 -0500", hash_original_method = "7CEEFB1EC71C1E868FBC10557351E2DA", hash_generated_method = "D0FE4446DCCD4B6FE8E99E3CC308D0B7")
    
@Override
    public int hashCode() {
        return (int) (value ^ (value >>> 32));
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.222 -0500", hash_original_method = "138584002FB2DE9D0E5B5F8DAEDB3270", hash_generated_method = "9019C920956BC6564E381830D24ADC2B")
    
@Override
    public int intValue() {
        return (int) value;
    }

    /**
     * Gets the primitive value of this long.
     *
     * @return this object's primitive value.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.225 -0500", hash_original_method = "ABF4FE035C950AC910A646D4B85E3F35", hash_generated_method = "1422248BBCC1B2BAF9351E8A3DC0A5BE")
    
@Override
    public long longValue() {
        return value;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.236 -0500", hash_original_method = "8E8C16CBE89F9837B346C9544C9B6BCC", hash_generated_method = "5FBF5C4E9B9689119C13934CEF72831A")
    
@Override
    public short shortValue() {
        return (short) value;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.246 -0500", hash_original_method = "6878CA43BE92FEF897301589A58FE568", hash_generated_method = "74AA83416BB5C082A687DD80E941BE7A")
    
@Override
    public String toString() {
        return Long.toString(value);
    }
    
}

