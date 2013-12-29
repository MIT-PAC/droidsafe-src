package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public final class IntegralToString {

    /**
     * Equivalent to Integer.toString(i, radix).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.506 -0500", hash_original_method = "84A07FBCA269378A9147D6530126000E", hash_generated_method = "CF6A398FCDDC219326C41A995D5477D8")
    public static String intToString(int i, int radix) {
        if (radix < Character.MIN_RADIX || radix > Character.MAX_RADIX) {
            radix = 10;
        }
        if (radix == 10) {
            return intToString(i);
        }

        /*
         * If i is positive, negate it. This is the opposite of what one might
         * expect. It is necessary because the range of the negative values is
         * strictly larger than that of the positive values: there is no
         * positive value corresponding to Integer.MIN_VALUE.
         */
        boolean negative = false;
        if (i < 0) {
            negative = true;
        } else {
            i = -i;
        }

        int bufLen = radix < 8 ? 33 : 12;  // Max chars in result (conservative)
        char[] buf = new char[bufLen];
        int cursor = bufLen;

        do {
            int q = i / radix;
            buf[--cursor] = DIGITS[radix * q - i];
            i = q;
        } while (i != 0);

        if (negative) {
            buf[--cursor] = '-';
        }

        return new String(cursor, bufLen - cursor, buf);
    }

    /**
     * Equivalent to Integer.toString(i).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.507 -0500", hash_original_method = "B1B4D5F6DCA8EF0F22789512858C9AFE", hash_generated_method = "B3ECD37125ED3587B94ECCC77B8D6BA4")
    public static String intToString(int i) {
        return convertInt(null, i);
    }

    /**
     * Equivalent to sb.append(Integer.toString(i)).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.508 -0500", hash_original_method = "2E283002697DCA5F88CA6E1957785306", hash_generated_method = "BFF96DDFE121937C2DE0C7BAC3CC2780")
    public static void appendInt(AbstractStringBuilder sb, int i) {
        convertInt(sb, i);
    }

    /**
     * Returns the string representation of i and leaves sb alone if sb is null.
     * Returns null and appends the string representation of i to sb if sb is non-null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.509 -0500", hash_original_method = "18F04DADB801BEC6FD2BF5A5509D8E24", hash_generated_method = "E79DB73A536926B98FC83AF3DDCD828E")
    private static String convertInt(AbstractStringBuilder sb, int i) {
        boolean negative = false;
        String quickResult = null;
        if (i < 0) {
            negative = true;
            i = -i;
            if (i < 100) {
                if (i < 0) {
                    // If -n is still negative, n is Integer.MIN_VALUE
                    quickResult = "-2147483648";
                } else {
                    quickResult = SMALL_NEGATIVE_VALUES[i];
                    if (quickResult == null) {
                        SMALL_NEGATIVE_VALUES[i] = quickResult =
                                i < 10 ? stringOf('-', ONES[i]) : stringOf('-', TENS[i], ONES[i]);
                    }
                }
            }
        } else {
            if (i < 100) {
                quickResult = SMALL_NONNEGATIVE_VALUES[i];
                if (quickResult == null) {
                    SMALL_NONNEGATIVE_VALUES[i] = quickResult =
                            i < 10 ? stringOf(ONES[i]) : stringOf(TENS[i], ONES[i]);
                }
            }
        }
        if (quickResult != null) {
            if (sb != null) {
                sb.append0(quickResult);
                return null;
            }
            return quickResult;
        }

        int bufLen = 11; // Max number of chars in result
        char[] buf = (sb != null) ? BUFFER.get() : new char[bufLen];
        int cursor = bufLen;

        // Calculate digits two-at-a-time till remaining digits fit in 16 bits
        while (i >= (1 << 16)) {
            // Compute q = n/100 and r = n % 100 as per "Hacker's Delight" 10-8
            int q = (int) ((0x51EB851FL * i) >>> 37);
            int r = i - 100*q;
            buf[--cursor] = ONES[r];
            buf[--cursor] = TENS[r];
            i = q;
        }

        // Calculate remaining digits one-at-a-time for performance
        while (i != 0) {
            // Compute q = n/10 and r = n % 10 as per "Hacker's Delight" 10-8
            int q = (0xCCCD * i) >>> 19;
            int r = i - 10*q;
            buf[--cursor] = DIGITS[r];
            i = q;
        }

        if (negative) {
            buf[--cursor] = '-';
        }

        if (sb != null) {
            sb.append0(buf, cursor, bufLen - cursor);
            return null;
        } else {
            return new String(cursor, bufLen - cursor, buf);
        }
    }

    /**
     * Equivalent to Long.toString(v, radix).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.510 -0500", hash_original_method = "37B28104B332535CD9A4BDBCC29D5030", hash_generated_method = "B837EAB259A841BED217DC0BA5724CFC")
    public static String longToString(long v, int radix) {
        int i = (int) v;
        if (i == v) {
            return intToString(i, radix);
        }

        if (radix < Character.MIN_RADIX || radix > Character.MAX_RADIX) {
            radix = 10;
        }
        if (radix == 10) {
            return longToString(v);
        }

        /*
         * If v is positive, negate it. This is the opposite of what one might
         * expect. It is necessary because the range of the negative values is
         * strictly larger than that of the positive values: there is no
         * positive value corresponding to Integer.MIN_VALUE.
         */
        boolean negative = false;
        if (v < 0) {
            negative = true;
        } else {
            v = -v;
        }

        int bufLen = radix < 8 ? 65 : 23;  // Max chars in result (conservative)
        char[] buf = new char[bufLen];
        int cursor = bufLen;

        do {
            long q = v / radix;
            buf[--cursor] = DIGITS[(int) (radix * q - v)];
            v = q;
        } while (v != 0);

        if (negative) {
            buf[--cursor] = '-';
        }

        return new String(cursor, bufLen - cursor, buf);
    }

    /**
     * Equivalent to Long.toString(l).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.511 -0500", hash_original_method = "153B7EAD25B0FBAAC892ABA7B6CC50EA", hash_generated_method = "07305E55971D5721CD811119E18E7393")
    public static String longToString(long l) {
        return convertLong(null, l);
    }

    /**
     * Equivalent to sb.append(Long.toString(l)).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.512 -0500", hash_original_method = "1A7366BC9F5E7AAA65E998C16248FAE8", hash_generated_method = "47A45A0DE2D83C625D0B819AC9C77DF2")
    public static void appendLong(AbstractStringBuilder sb, long l) {
        convertLong(sb, l);
    }

    /**
     * Returns the string representation of n and leaves sb alone if sb is null.
     * Returns null and appends the string representation of n to sb if sb is non-null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.513 -0500", hash_original_method = "335087D7FF3CE8ACF704F016666ED5E4", hash_generated_method = "9C2CF14366EC4FEC5E2510809E61CCA2")
    private static String convertLong(AbstractStringBuilder sb, long n) {
        int i = (int) n;
        if (i == n) {
            return convertInt(sb, i);
        }

        boolean negative = (n < 0);
        if (negative) {
            n = -n;
            if (n < 0) {
                // If -n is still negative, n is Long.MIN_VALUE
                String quickResult = "-9223372036854775808";
                if (sb != null) {
                    sb.append0(quickResult);
                    return null;
                }
                return quickResult;
            }
        }

        int bufLen = 20; // Maximum number of chars in result
        char[] buf = (sb != null) ? BUFFER.get() : new char[bufLen];

        int low = (int) (n % 1000000000); // Extract low-order 9 digits
        int cursor = intIntoCharArray(buf, bufLen, low);

        // Zero-pad Low order part to 9 digits
        while (cursor != (bufLen - 9)) {
            buf[--cursor] = '0';
        }

        /*
         * The remaining digits are (n - low) / 1,000,000,000.  This
         * "exact division" is done as per the online addendum to Hank Warren's
         * "Hacker's Delight" 10-20, http://www.hackersdelight.org/divcMore.pdf
         */
        n = ((n - low) >>> 9) * 0x8E47CE423A2E9C6DL;

        /*
         * If the remaining digits fit in an int, emit them using a
         * single call to intIntoCharArray. Otherwise, strip off the
         * low-order digit, put it in buf, and then call intIntoCharArray
         * on the remaining digits (which now fit in an int).
         */
        if ((n & (-1L << 32)) == 0) {
            cursor = intIntoCharArray(buf, cursor, (int) n);
        } else {
            /*
             * Set midDigit to n % 10
             */
            int lo32 = (int) n;
            int hi32 = (int) (n >>> 32);

            // midDigit = ((unsigned) low32) % 10, per "Hacker's Delight" 10-21
            int midDigit = MOD_10_TABLE[(0x19999999 * lo32 + (lo32 >>> 1) + (lo32 >>> 3)) >>> 28];

            // Adjust midDigit for hi32. (assert hi32 == 1 || hi32 == 2)
            midDigit -= hi32 << 2;  // 1L << 32 == -4 MOD 10
            if (midDigit < 0) {
                midDigit += 10;
            }
            buf[--cursor] = DIGITS[midDigit];

            // Exact division as per Warren 10-20
            int rest = ((int) ((n - midDigit) >>> 1)) * 0xCCCCCCCD;
            cursor = intIntoCharArray(buf, cursor, rest);
        }

        if (negative) {
            buf[--cursor] = '-';
        }
        if (sb != null) {
            sb.append0(buf, cursor, bufLen - cursor);
            return null;
        } else {
            return new String(cursor, bufLen - cursor, buf);
        }
    }

    /**
     * Inserts the unsigned decimal integer represented by n into the specified
     * character array starting at position cursor.  Returns the index after
     * the last character inserted (i.e., the value to pass in as cursor the
     * next time this method is called). Note that n is interpreted as a large
     * positive integer (not a negative integer) if its sign bit is set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.515 -0500", hash_original_method = "AA8AE34ED725E04DA1882B7CEAEB718F", hash_generated_method = "C5EE79131CBB996273FBE7D43CDE847F")
    private static int intIntoCharArray(char[] buf, int cursor, int n) {
        // Calculate digits two-at-a-time till remaining digits fit in 16 bits
        while ((n & 0xffff0000) != 0) {
            /*
             * Compute q = n/100 and r = n % 100 as per "Hacker's Delight" 10-8.
             * This computation is slightly different from the corresponding
             * computation in intToString: the shifts before and after
             * multiply can't be combined, as that would yield the wrong result
             * if n's sign bit were set.
             */
            int q = (int) ((0x51EB851FL * (n >>> 2)) >>> 35);
            int r = n - 100*q;
            buf[--cursor] = ONES[r];
            buf[--cursor] = TENS[r];
            n = q;
        }

        // Calculate remaining digits one-at-a-time for performance
        while (n != 0) {
            // Compute q = n / 10 and r = n % 10 as per "Hacker's Delight" 10-8
            int q = (0xCCCD * n) >>> 19;
            int r = n - 10*q;
            buf[--cursor] = DIGITS[r];
            n = q;
        }
        return cursor;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.516 -0500", hash_original_method = "A41E5D3875136344B237460B8AD39DE0", hash_generated_method = "BF9029A36E87AD6C0F7646EBDC2AD21F")
    public static String intToBinaryString(int i) {
        int bufLen = 32;  // Max number of binary digits in an int
        char[] buf = new char[bufLen];
        int cursor = bufLen;

        do {
            buf[--cursor] = DIGITS[i & 1];
        }  while ((i >>>= 1) != 0);

        return new String(cursor, bufLen - cursor, buf);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.517 -0500", hash_original_method = "425709456D43055F08B99D956BED133A", hash_generated_method = "19DE5B453C600CEADCEE9910F20C6563")
    public static String longToBinaryString(long v) {
        int i = (int) v;
        if (v >= 0 && i == v) {
            return intToBinaryString(i);
        }

        int bufLen = 64;  // Max number of binary digits in a long
        char[] buf = new char[bufLen];
        int cursor = bufLen;

        do {
            buf[--cursor] = DIGITS[((int) v) & 1];
        }  while ((v >>>= 1) != 0);

        return new String(cursor, bufLen - cursor, buf);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.518 -0500", hash_original_method = "25742899540A4F6BF48504885A2F05E0", hash_generated_method = "47163F3DAA1C79F199346566712562F1")
    public static StringBuilder appendByteAsHex(StringBuilder sb, byte b, boolean upperCase) {
        char[] digits = upperCase ? UPPER_CASE_DIGITS : DIGITS;
        sb.append(digits[(b >> 4) & 0xf]);
        sb.append(digits[b & 0xf]);
        return sb;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.519 -0500", hash_original_method = "010E15EE749C468A15543203E9BC66F2", hash_generated_method = "65341427BE591FEECBDD3EBCD1A98B15")
    public static String byteToHexString(byte b, boolean upperCase) {
        char[] digits = upperCase ? UPPER_CASE_DIGITS : DIGITS;
        char[] buf = new char[2]; // We always want two digits.
        buf[0] = digits[(b >> 4) & 0xf];
        buf[1] = digits[b & 0xf];
        return new String(0, 2, buf);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.520 -0500", hash_original_method = "744A47F287A2754D655F5FDE5DEB2E5D", hash_generated_method = "8851B88F67110322BF450F54F6CBA037")
    public static String bytesToHexString(byte[] bytes, boolean upperCase) {
        char[] digits = upperCase ? UPPER_CASE_DIGITS : DIGITS;
        char[] buf = new char[bytes.length * 2];
        int c = 0;
        for (byte b : bytes) {
            buf[c++] = digits[(b >> 4) & 0xf];
            buf[c++] = digits[b & 0xf];
        }
        return new String(buf);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.521 -0500", hash_original_method = "53C9BEADC911A160577C54E5E3F03689", hash_generated_method = "1B231099D778F3AA3ECB08BDBE1B4A8A")
    public static String intToHexString(int i, boolean upperCase, int minWidth) {
        int bufLen = 8;  // Max number of hex digits in an int
        char[] buf = new char[bufLen];
        int cursor = bufLen;

        char[] digits = upperCase ? UPPER_CASE_DIGITS : DIGITS;
        do {
            buf[--cursor] = digits[i & 0xf];
        } while ((i >>>= 4) != 0 || (bufLen - cursor < minWidth));

        return new String(cursor, bufLen - cursor, buf);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.522 -0500", hash_original_method = "40D5415945BB8116A305EC0340CF03D3", hash_generated_method = "AC3B506B8F65F32340C42CCE255AD773")
    public static String longToHexString(long v) {
        int i = (int) v;
        if (v >= 0 && i == v) {
            return intToHexString(i, false, 0);
        }

        int bufLen = 16;  // Max number of hex digits in a long
        char[] buf = new char[bufLen];
        int cursor = bufLen;

        do {
            buf[--cursor] = DIGITS[((int) v) & 0xF];
        } while ((v >>>= 4) != 0);

        return new String(cursor, bufLen - cursor, buf);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.523 -0500", hash_original_method = "45CC1A585F589498B158F1646F8FCD50", hash_generated_method = "491C057DAC348EAD6D01733B5670B1D3")
    public static String intToOctalString(int i) {
        int bufLen = 11;  // Max number of octal digits in an int
        char[] buf = new char[bufLen];
        int cursor = bufLen;

        do {
            buf[--cursor] = DIGITS[i & 7];
        } while ((i >>>= 3) != 0);

        return new String(cursor, bufLen - cursor, buf);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.523 -0500", hash_original_method = "0B792E8186913E3E66D8EB47F2B35BC9", hash_generated_method = "CD5497C1B1686D3D197A7F06DC143795")
    public static String longToOctalString(long v) {
        int i = (int) v;
        if (v >= 0 && i == v) {
            return intToOctalString(i);
        }
        int bufLen = 22;  // Max number of octal digits in a long
        char[] buf = new char[bufLen];
        int cursor = bufLen;

        do {
            buf[--cursor] = DIGITS[((int) v) & 7];
        } while ((v >>>= 3) != 0);

        return new String(cursor, bufLen - cursor, buf);
    }

    /**
     * Returns a string composed of the specified characters. Note that the
     * autoboxing does *not* result in an extra copy of the char array: we are
     * using a package-private string constructor that incorporates the
     * "autoboxing array" into the new string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.524 -0500", hash_original_method = "F1C6410A467B286589D07AFCC53374B5", hash_generated_method = "49D2D4BE49B87B4FD1B9513189C9E32D")
    private static String stringOf(char... args) {
        return new String(0, args.length, args);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.236 -0400", hash_original_field = "AB280E60F0CF35D4F468078DFDA43178", hash_generated_field = "425773BE567620BA8858A8C9A806C3AB")

    private static final ThreadLocal<char[]> BUFFER = new ThreadLocal<char[]>() {        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.236 -0400", hash_original_method = "2EBCA8DA39A849AFE3E3749C7F49BA79", hash_generated_method = "DD3C6EC86D330D1AF7830345AF558804")
        @Override
        protected char[] initialValue() {
            char[] var401101FA2F200BBC59DD27CE1AD00AD7_83035988 = (new char[20]);
            char[] var50607924ABD4C17119BAF3A1CE41C0EC_66101806 = {getTaintChar()};
            return var50607924ABD4C17119BAF3A1CE41C0EC_66101806;
            
            
        }

        
};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.498 -0500", hash_original_field = "37DFB5C87B09E2D3A46A9A888D8120E2", hash_generated_field = "3F7A7621FDECF4B1F00F7F02BB032983")

    private static final String[] SMALL_NONNEGATIVE_VALUES = new String[100];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.499 -0500", hash_original_field = "FFDF6514E961275EBE2DC63ABCA79370", hash_generated_field = "0F2C6CD52D3AC35204AE87E543B933FE")

    private static final String[] SMALL_NEGATIVE_VALUES = new String[100];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.500 -0500", hash_original_field = "F311DA27D751D5FFD831BBA6CCCE30CC", hash_generated_field = "F4F0B5078F2B36CA1654493CC02FBE1B")

    private static final char[] TENS = {
        '0', '0', '0', '0', '0', '0', '0', '0', '0', '0',
        '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
        '2', '2', '2', '2', '2', '2', '2', '2', '2', '2',
        '3', '3', '3', '3', '3', '3', '3', '3', '3', '3',
        '4', '4', '4', '4', '4', '4', '4', '4', '4', '4',
        '5', '5', '5', '5', '5', '5', '5', '5', '5', '5',
        '6', '6', '6', '6', '6', '6', '6', '6', '6', '6',
        '7', '7', '7', '7', '7', '7', '7', '7', '7', '7',
        '8', '8', '8', '8', '8', '8', '8', '8', '8', '8',
        '9', '9', '9', '9', '9', '9', '9', '9', '9', '9'
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.501 -0500", hash_original_field = "F4BBEFA84DF5357F6D7EA1D47F1A573A", hash_generated_field = "C40FC9CE2E1863E8D99B8E9E8459B998")

    private static final char[] ONES = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.502 -0500", hash_original_field = "0703CCE2B73E1DC5A6EA665244A4D9F8", hash_generated_field = "7ECA72DEBCDA6EB92131D3D0F3D8765E")

    private static final char[] MOD_10_TABLE = {
        0, 1, 2, 2, 3, 3, 4, 5, 5, 6, 7, 7, 8, 8, 9, 0
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.503 -0500", hash_original_field = "FD7EDE0EC664D36F57D4A03087EFD371", hash_generated_field = "0F077AEAC9BBB0ADF3D0D4E6AACE2DF1")

    private static final char[] DIGITS = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
        'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
        'u', 'v', 'w', 'x', 'y', 'z'
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.504 -0500", hash_original_field = "0BAC015C4EE9B0B2ADAFBCE97C96378D", hash_generated_field = "C31924D8CB8753379AD2B96C86ABBAE8")


    private static final char[] UPPER_CASE_DIGITS = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
        'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
        'U', 'V', 'W', 'X', 'Y', 'Z'
    };

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:23.505 -0500", hash_original_method = "DF20FC0B1F395B5ECC5581BA0BD3AC0B", hash_generated_method = "F9A5116623A8F121F9E7894C48ABCCA4")
    private IntegralToString() {
    }
}

