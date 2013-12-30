package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public final class Integer extends Number implements Comparable<Integer> {

    /**
     * Compares two {@code int} values.
     * @return 0 if lhs = rhs, less than 0 if lhs &lt; rhs, and greater than 0 if lhs &gt; rhs.
     * @since 1.7
     * @hide 1.7
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.163 -0500", hash_original_method = "08B34540C6F5E5FA9EF442057B264C3A", hash_generated_method = "04989A44666D307E13510E4935EA503C")
    
public static int compare(int lhs, int rhs) {
        return lhs < rhs ? -1 : (lhs == rhs ? 0 : 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.166 -0500", hash_original_method = "A3A010FC05E6D36052109B2A32E2CE6D", hash_generated_method = "5EC1AE6DACF5D4E96A3AD3BE653B196C")
    
private static NumberFormatException invalidInt(String s) {
        throw new NumberFormatException("Invalid int: \"" + s + "\"");
    }

    /**
     * Parses the specified string and returns a {@code Integer} instance if the
     * string can be decoded into an integer value. The string may be an
     * optional minus sign "-" followed by a hexadecimal ("0x..." or "#..."),
     * octal ("0..."), or decimal ("...") representation of an integer.
     *
     * @param string
     *            a string representation of an integer value.
     * @return an {@code Integer} containing the value represented by
     *         {@code string}.
     * @throws NumberFormatException
     *             if {@code string} cannot be parsed as an integer value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.169 -0500", hash_original_method = "46DA43F84FA71E66C3C03274BBD22B81", hash_generated_method = "3ABFBE25C2D84F1E621213D0CCED98AA")
    
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

    /**
     * Returns the {@code Integer} value of the system property identified by
     * {@code string}. Returns {@code null} if {@code string} is {@code null}
     * or empty, if the property can not be found or if its value can not be
     * parsed as an integer.
     *
     * @param string
     *            the name of the requested system property.
     * @return the requested property's value as an {@code Integer} or
     *         {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.180 -0500", hash_original_method = "F01C30BD973BCE191A7284E98D1A303E", hash_generated_method = "C1DAAE89FBE184F5C7F6A97080859E37")
    
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

    /**
     * Returns the {@code Integer} value of the system property identified by
     * {@code string}. Returns the specified default value if {@code string} is
     * {@code null} or empty, if the property can not be found or if its value
     * can not be parsed as an integer.
     *
     * @param string
     *            the name of the requested system property.
     * @param defaultValue
     *            the default value that is returned if there is no integer
     *            system property with the requested name.
     * @return the requested property's value as an {@code Integer} or the
     *         default value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.182 -0500", hash_original_method = "B43E44D829289B070CF83BC460D06D24", hash_generated_method = "A056FC57C20DB105CD700CA7A32403BB")
    
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

    /**
     * Returns the {@code Integer} value of the system property identified by
     * {@code string}. Returns the specified default value if {@code string} is
     * {@code null} or empty, if the property can not be found or if its value
     * can not be parsed as an integer.
     *
     * @param string
     *            the name of the requested system property.
     * @param defaultValue
     *            the default value that is returned if there is no integer
     *            system property with the requested name.
     * @return the requested property's value as an {@code Integer} or the
     *         default value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.185 -0500", hash_original_method = "1037DE5287EEBEFE56735B40DF7AE5DF", hash_generated_method = "CE137B705D1095FFD41C9C3C5AC33FD8")
    
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

    /**
     * Parses the specified string as a signed decimal integer value. The ASCII
     * character \u002d ('-') is recognized as the minus sign.
     *
     * @param string
     *            the string representation of an integer value.
     * @return the primitive integer value represented by {@code string}.
     * @throws NumberFormatException
     *             if {@code string} cannot be parsed as an integer value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.195 -0500", hash_original_method = "172D4BA10AB000BE273AA7D695E5C087", hash_generated_method = "675665531A005AF15842D70D6F7DDA9A")
    
public static int parseInt(String string) throws NumberFormatException {
        return parseInt(string, 10);
    }

    /**
     * Parses the specified string as a signed integer value using the specified
     * radix. The ASCII character \u002d ('-') is recognized as the minus sign.
     *
     * @param string
     *            the string representation of an integer value.
     * @param radix
     *            the radix to use when parsing.
     * @return the primitive integer value represented by {@code string} using
     *         {@code radix}.
     * @throws NumberFormatException
     *             if {@code string} cannot be parsed as an integer value,
     *             or {@code radix < Character.MIN_RADIX ||
     *             radix > Character.MAX_RADIX}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.202 -0500", hash_original_method = "162A603AB5DA029339CF16BB4270637E", hash_generated_method = "0D0CF7EDC037A4D1AFC9A3CB92A5F5D8")
    
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.205 -0500", hash_original_method = "2DC7C613589A3F978B8CE07DBD570473", hash_generated_method = "E72E0B7A74CD7BF6ACF7E658CE311850")
    
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

    /**
     * Converts the specified integer into its binary string representation. The
     * returned string is a concatenation of '0' and '1' characters.
     *
     * @param i
     *            the integer to convert.
     * @return the binary string representation of {@code i}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.210 -0500", hash_original_method = "9D8F65BFD86E7A18329171709CBF3046", hash_generated_method = "E737365418F916A96DC7B6DCF8FED481")
    
public static String toBinaryString(int i) {
        return IntegralToString.intToBinaryString(i);
    }

    /**
     * Converts the specified integer into its hexadecimal string
     * representation. The returned string is a concatenation of characters from
     * '0' to '9' and 'a' to 'f'.
     *
     * @param i
     *            the integer to convert.
     * @return the hexadecimal string representation of {@code i}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.212 -0500", hash_original_method = "3979972EEEC4E88868F959A411D789BE", hash_generated_method = "C7BC11F923377AFB81EB38684EC95967")
    
public static String toHexString(int i) {
        return IntegralToString.intToHexString(i, false, 0);
    }

    /**
     * Converts the specified integer into its octal string representation. The
     * returned string is a concatenation of characters from '0' to '7'.
     *
     * @param i
     *            the integer to convert.
     * @return the octal string representation of {@code i}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.215 -0500", hash_original_method = "72067B50D522BDEF5353890C050CC074", hash_generated_method = "39DB8FB2BAD3FBA7DDE4A06C2EF9F726")
    
public static String toOctalString(int i) {
        return IntegralToString.intToOctalString(i);
    }

    /**
     * Converts the specified integer into its decimal string representation.
     * The returned string is a concatenation of a minus sign if the number is
     * negative and characters from '0' to '9'.
     *
     * @param i
     *            the integer to convert.
     * @return the decimal string representation of {@code i}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.220 -0500", hash_original_method = "83FFC2042E386057ACE3416E6CB82244", hash_generated_method = "937E52F3011B3AAE21ECE10A2A8E9C67")
    
public static String toString(int i) {
        return IntegralToString.intToString(i);
    }

    /**
     * Converts the specified signed integer into a string representation based on the
     * specified radix. The returned string is a concatenation of a minus sign
     * if the number is negative and characters from '0' to '9' and 'a' to 'z',
     * depending on the radix. If {@code radix} is not in the interval defined
     * by {@code Character.MIN_RADIX} and {@code Character.MAX_RADIX} then 10 is
     * used as the base for the conversion.
     *
     * <p>This method treats its argument as signed. If you want to convert an
     * unsigned value to one of the common non-decimal bases, you may find
     * {@link #toBinaryString}, {@code #toHexString}, or {@link #toOctalString}
     * more convenient.
     *
     * @param i
     *            the signed integer to convert.
     * @param radix
     *            the base to use for the conversion.
     * @return the string representation of {@code i}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.223 -0500", hash_original_method = "175FD40B6A0B4257AFDD7BA871A3507B", hash_generated_method = "2703FF1CAB3D642CD02346A51DCCD5AB")
    
public static String toString(int i, int radix) {
        return IntegralToString.intToString(i, radix);
    }

    /**
     * Parses the specified string as a signed decimal integer value.
     *
     * @param string
     *            the string representation of an integer value.
     * @return an {@code Integer} instance containing the integer value
     *         represented by {@code string}.
     * @throws NumberFormatException
     *             if {@code string} cannot be parsed as an integer value.
     * @see #parseInt(String)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.225 -0500", hash_original_method = "5ACE3593E04E738DABAA0EBD77FF5A76", hash_generated_method = "1FFF9C927A6EC61FA8BD3E3BBB9D1BF5")
    
public static Integer valueOf(String string) throws NumberFormatException {
        return valueOf(parseInt(string));
    }

    /**
     * Parses the specified string as a signed integer value using the specified
     * radix.
     *
     * @param string
     *            the string representation of an integer value.
     * @param radix
     *            the radix to use when parsing.
     * @return an {@code Integer} instance containing the integer value
     *         represented by {@code string} using {@code radix}.
     * @throws NumberFormatException
     *             if {@code string} cannot be parsed as an integer value, or
     *             {@code radix < Character.MIN_RADIX ||
     *             radix > Character.MAX_RADIX}.
     * @see #parseInt(String, int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.227 -0500", hash_original_method = "5859C0A727537B8EC88F05E2B2FE00D6", hash_generated_method = "F741D2A1942CB111613D0D4114618CDE")
    
public static Integer valueOf(String string, int radix) throws NumberFormatException {
        return valueOf(parseInt(string, radix));
    }

    /**
     * Determines the highest (leftmost) bit of the specified integer that is 1
     * and returns the bit mask value for that bit. This is also referred to as
     * the Most Significant 1 Bit. Returns zero if the specified integer is
     * zero.
     *
     * @param i
     *            the integer to examine.
     * @return the bit mask indicating the highest 1 bit in {@code i}.
     * @since 1.5
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.230 -0500", hash_original_method = "07B15BCA74AC5BE2F84043AACB0A310C", hash_generated_method = "B6DBA61B905A0FCCC76CA3CD0DA32EE0")
    
public static int highestOneBit(int i) {
        // Hacker's Delight, Figure 3-1
        i |= (i >> 1);
        i |= (i >> 2);
        i |= (i >> 4);
        i |= (i >> 8);
        i |= (i >> 16);
        return i - (i >>> 1);
    }

    /**
     * Determines the lowest (rightmost) bit of the specified integer that is 1
     * and returns the bit mask value for that bit. This is also referred
     * to as the Least Significant 1 Bit. Returns zero if the specified integer
     * is zero.
     *
     * @param i
     *            the integer to examine.
     * @return the bit mask indicating the lowest 1 bit in {@code i}.
     * @since 1.5
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.232 -0500", hash_original_method = "ABFA2AA3044F8D161D7CA2C8E1F71BE9", hash_generated_method = "EE380301ABB52F8350D1090A1D5C072D")
    
public static int lowestOneBit(int i) {
        return i & -i;
    }

    /**
     * Determines the number of leading zeros in the specified integer prior to
     * the {@link #highestOneBit(int) highest one bit}.
     *
     * @param i
     *            the integer to examine.
     * @return the number of leading zeros in {@code i}.
     * @since 1.5
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.236 -0500", hash_original_method = "B598B2644508791A0E6226CE6E4EC6FE", hash_generated_method = "48A2DDE22CF3E254A068A354ACF44783")
    
public static int numberOfLeadingZeros(int i) {
        // Hacker's Delight, Figure 5-6
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

    /**
     * Determines the number of trailing zeros in the specified integer after
     * the {@link #lowestOneBit(int) lowest one bit}.
     *
     * @param i
     *            the integer to examine.
     * @return the number of trailing zeros in {@code i}.
     * @since 1.5
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.238 -0500", hash_original_method = "4E0FDC4B081A56937B6D10C201A74C79", hash_generated_method = "5F878702236102E0C1A09A31D227D083")
    
public static int numberOfTrailingZeros(int i) {
        return NTZ_TABLE[((i & -i) * 0x0450FBAF) >>> 26];
    }

    /**
     * Counts the number of 1 bits in the specified integer; this is also
     * referred to as population count.
     *
     * @param i
     *            the integer to examine.
     * @return the number of 1 bits in {@code i}.
     * @since 1.5
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.241 -0500", hash_original_method = "96F418696A4CBAC7A39E33CF390C9745", hash_generated_method = "796B97E864DDE00011C807F15057D093")
    
public static int bitCount(int i) {
        // Hacker's Delight, Figure 5-2
        i -= (i >> 1) & 0x55555555;
        i = (i & 0x33333333) + ((i >> 2) & 0x33333333);
        i = ((i >> 4) + i) & 0x0F0F0F0F;
        i += i >> 8;
        i += i >> 16;
        return i & 0x0000003F;
    }

    /**
     * Rotates the bits of the specified integer to the left by the specified
     * number of bits.
     *
     * @param i
     *            the integer value to rotate left.
     * @param distance
     *            the number of bits to rotate.
     * @return the rotated value.
     * @since 1.5
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.243 -0500", hash_original_method = "EDB2D6790586ADFBD3CCB3C657FE979E", hash_generated_method = "154CA778413D72FD7120CE19D552321D")
    
public static int rotateLeft(int i, int distance) {
        // Shift distances are mod 32 (JLS3 15.19), so we needn't mask -distance
        return (i << distance) | (i >>> -distance);
    }

    /**
     * Rotates the bits of the specified integer to the right by the specified
     * number of bits.
     *
     * @param i
     *            the integer value to rotate right.
     * @param distance
     *            the number of bits to rotate.
     * @return the rotated value.
     * @since 1.5
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.246 -0500", hash_original_method = "6074674D7A01ED6AECC5FC14865BC8F8", hash_generated_method = "BDB7EEC2F311DC2505B8F3ADEB750EE8")
    
public static int rotateRight(int i, int distance) {
        // Shift distances are mod 32 (JLS3 15.19), so we needn't mask -distance
        return (i >>> distance) | (i << -distance);
    }

    /**
     * Reverses the order of the bytes of the specified integer.
     *
     * @param i
     *            the integer value for which to reverse the byte order.
     * @return the reversed value.
     * @since 1.5
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.248 -0500", hash_original_method = "E82979AF836D183FB2BABD0E0E7F3431", hash_generated_method = "F9AF44DB11847DD24867E34B907F1D76")
    
public static int reverseBytes(int i) {
        // Hacker's Delight 7-1, with minor tweak from Veldmeijer
        // http://graphics.stanford.edu/~seander/bithacks.html
        i =    ((i >>>  8) & 0x00FF00FF) | ((i & 0x00FF00FF) <<  8);
        return ( i >>> 16              ) | ( i               << 16);
    }

    /**
     * Reverses the order of the bits of the specified integer.
     *
     * @param i
     *            the integer value for which to reverse the bit order.
     * @return the reversed value.
     * @since 1.5
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.251 -0500", hash_original_method = "8FB6A7484D99181743947553B04591B0", hash_generated_method = "4D54DAC6709D8BC4B1289684F495D52B")
    
public static int reverse(int i) {
        // Hacker's Delight 7-1, with minor tweak from Veldmeijer
        // http://graphics.stanford.edu/~seander/bithacks.html
        i =    ((i >>>  1) & 0x55555555) | ((i & 0x55555555) <<  1);
        i =    ((i >>>  2) & 0x33333333) | ((i & 0x33333333) <<  2);
        i =    ((i >>>  4) & 0x0F0F0F0F) | ((i & 0x0F0F0F0F) <<  4);
        i =    ((i >>>  8) & 0x00FF00FF) | ((i & 0x00FF00FF) <<  8);
        return ((i >>> 16)             ) | ((i             ) << 16);
    }

    /**
     * Returns the value of the {@code signum} function for the specified
     * integer.
     *
     * @param i
     *            the integer value to check.
     * @return -1 if {@code i} is negative, 1 if {@code i} is positive, 0 if
     *         {@code i} is zero.
     * @since 1.5
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.253 -0500", hash_original_method = "75E0F722BBDC662C077609CB74D0DBA7", hash_generated_method = "0319A297ACBCD3ABBB61C28D9C866493")
    
public static int signum(int i) {
        return (i >> 31) | (-i >>> 31); // Hacker's delight 2-7
    }

    /**
     * Returns a {@code Integer} instance for the specified integer value.
     * <p>
     * If it is not necessary to get a new {@code Integer} instance, it is
     * recommended to use this method instead of the constructor, since it
     * maintains a cache of instances which may result in better performance.
     *
     * @param i
     *            the integer value to store in the instance.
     * @return a {@code Integer} instance containing {@code i}.
     * @since 1.5
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.256 -0500", hash_original_method = "34E26A0F2F8E35922D8A4237B251C395", hash_generated_method = "FEB2B9F896E123B5C0527B185F160803")
    
public static Integer valueOf(int i) {
        return  i >= 128 || i < -128 ? new Integer(i) : SMALL_VALUES[i + 128];
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.135 -0500", hash_original_field = "3D10FD4F0E8697EBDBC88B99D7AC38DA", hash_generated_field = "88D0C92B83B1D40D76F4FBB954A2A9E5")


    private static final long serialVersionUID = 1360826667806852920L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.139 -0500", hash_original_field = "6A8627387400A06C9777F47AFC91409F", hash_generated_field = "3BDA0DF3C86CD680ACE62390D2B524ED")

    public static final int MAX_VALUE = 0x7FFFFFFF;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.142 -0500", hash_original_field = "D0DBFB74F0A3D581E6252820A72BFB27", hash_generated_field = "36D06DCD804B103124720EBA9F7340A9")

    public static final int MIN_VALUE = 0x80000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.144 -0500", hash_original_field = "1503BF3B0F0858201FC26D4F68A4CEDE", hash_generated_field = "63FA0385596F5F13183B5684F35B159F")

    public static final int SIZE = 32;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.148 -0500", hash_original_field = "873E62CE0F7A4AA009B08A44A357C91F", hash_generated_field = "F9D89F9F328AFF2D37ED87D088C176D7")

    private static final byte[] NTZ_TABLE = {
        32,  0,  1, 12,  2,  6, -1, 13,   3, -1,  7, -1, -1, -1, -1, 14,
        10,  4, -1, -1,  8, -1, -1, 25,  -1, -1, -1, -1, -1, 21, 27, 15,
        31, 11,  5, -1, -1, -1, -1, -1,   9, -1, -1, 24, -1, -1, 20, 26,
        30, -1, -1, -1, -1, 23, -1, 19,  29, -1, 22, 18, 28, 17, 16, -1
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.151 -0500", hash_original_field = "4AAB7FD4197E8542DF8910723B8B3C8A", hash_generated_field = "073FFFEFB41314D95534816366682FCC")

    @SuppressWarnings("unchecked")
    public static final Class<Integer> TYPE
            = (Class<Integer>) int[].class.getComponentType();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.258 -0500", hash_original_field = "8BF684B9DEAA323648A9119C4E3D2EED", hash_generated_field = "2B503CD004C95B2E1022E1C894D7A1A1")

    private static final Integer[] SMALL_VALUES = new Integer[256];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.137 -0500", hash_original_field = "2A5EA2B60261C751D318C2CB32BF7CEC", hash_generated_field = "810C3DA5CE7DA1BA423D6BE76816E5C9")

    private  int value;
    // Note: Integer.TYPE can't be set to "int.class", since *that* is
    // defined to be "java.lang.Integer.TYPE";

    /**
     * Constructs a new {@code Integer} with the specified primitive integer
     * value.
     *
     * @param value
     *            the primitive integer value to store in the new instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.153 -0500", hash_original_method = "22146E0D9B2FD3EEBD460016C940A35F", hash_generated_method = "F12C9F40D3EC41E1174EF104CA5C5A1E")
    
public Integer(int value) {
        this.value = value;
    }

    /**
     * Constructs a new {@code Integer} from the specified string.
     *
     * @param string
     *            the string representation of an integer value.
     * @throws NumberFormatException
     *             if {@code string} cannot be parsed as an integer value.
     * @see #parseInt(String)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.156 -0500", hash_original_method = "E0CD1D1A7D46CCFF15C90A26B138404A", hash_generated_method = "840AFBF91231E7375DBE5F4F8362BFE1")
    
public Integer(String string) throws NumberFormatException {
        this(parseInt(string));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.159 -0500", hash_original_method = "6B61312FC318A12A6B19178CA8B54E86", hash_generated_method = "4C2FE469A77605BE0BF5A0C525E46699")
    
@Override
    public byte byteValue() {
        return (byte) value;
    }

    /**
     * Compares this object to the specified integer object to determine their
     * relative order.
     *
     * @param object
     *            the integer object to compare this object to.
     * @return a negative value if the value of this integer is less than the
     *         value of {@code object}; 0 if the value of this integer and the
     *         value of {@code object} are equal; a positive value if the value
     *         of this integer is greater than the value of {@code object}.
     * @see java.lang.Comparable
     * @since 1.2
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.161 -0500", hash_original_method = "735EC7AEC4F3C97B9E273B68A8C134FA", hash_generated_method = "EA3AB24781A5CC0C1AB8613C230C6044")
    
public int compareTo(Integer object) {
        return compare(value, object.value);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.172 -0500", hash_original_method = "3D3B0AF18CC8081B7BB4A7DC662E1F07", hash_generated_method = "BF89BE4469CF5E691A2C43432BBB5D3E")
    
@Override
    public double doubleValue() {
        return value;
    }

    /**
     * Compares this instance with the specified object and indicates if they
     * are equal. In order to be equal, {@code o} must be an instance of
     * {@code Integer} and have the same integer value as this object.
     *
     * @param o
     *            the object to compare this integer with.
     * @return {@code true} if the specified object is equal to this
     *         {@code Integer}; {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.174 -0500", hash_original_method = "F74FD59F9B798AB03C90305DF48139A2", hash_generated_method = "3586DCA622D06B9D98649998D2AA7C87")
    
@Override
    public boolean equals(Object o) {
        return (o instanceof Integer) && (((Integer) o).value == value);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.177 -0500", hash_original_method = "9E2C0918A44EC11D2232D0B603F66A6B", hash_generated_method = "0138C4AD160C9AAF1F0B41D5F85236C8")
    
@Override
    public float floatValue() {
        return value;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.187 -0500", hash_original_method = "961F210287166DF05D8915D632129E75", hash_generated_method = "C30218EC7C084095E716A93197D10945")
    
@Override
    public int hashCode() {
        return value;
    }

    /**
     * Gets the primitive value of this int.
     *
     * @return this object's primitive value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.190 -0500", hash_original_method = "4668226786F0223B69B1E8157F3C469B", hash_generated_method = "CED71A70CDF5F216D39A3AE3E558B24B")
    
@Override
    public int intValue() {
        return value;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.192 -0500", hash_original_method = "ABF4FE035C950AC910A646D4B85E3F35", hash_generated_method = "1422248BBCC1B2BAF9351E8A3DC0A5BE")
    
@Override
    public long longValue() {
        return value;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.207 -0500", hash_original_method = "8E8C16CBE89F9837B346C9544C9B6BCC", hash_generated_method = "5FBF5C4E9B9689119C13934CEF72831A")
    
@Override
    public short shortValue() {
        return (short) value;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.217 -0500", hash_original_method = "6B315C20A4D45816791A47779D79F014", hash_generated_method = "523848B88799F041621FC5C99AD5BFED")
    
@Override
    public String toString() {
        return Integer.toString(value);
    }
    static {
        for (int i = -128; i < 128; i++) {
            SMALL_VALUES[i + 128] = new Integer(i);
        }
    }
    
}

