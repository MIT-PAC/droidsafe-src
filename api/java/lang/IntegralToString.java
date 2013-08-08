package java.lang;

// Droidsafe Imports
import droidsafe.annotations.*;





public final class IntegralToString {
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.196 -0400", hash_original_method = "DF20FC0B1F395B5ECC5581BA0BD3AC0B", hash_generated_method = "724F18F022450896EB503A5FBBDA6BC7")
    private  IntegralToString() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.BAN)
    public static String intToString(int i, int radix) {
        if (radix < Character.MIN_RADIX || radix > Character.MAX_RADIX) {
            radix = 10;
        }
        if (radix == 10) {
            return intToString(i);
        }
        boolean negative = false;
        if (i < 0) {
            negative = true;
        } else {
            i = -i;
        }
        int bufLen = radix < 8 ? 33 : 12;
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

    
    @DSModeled(DSC.SAFE)
    public static String intToString(int i) {
        return convertInt(null, i);
    }

    
    @DSModeled(DSC.BAN)
    public static void appendInt(AbstractStringBuilder sb, int i) {
        convertInt(sb, i);
    }

    
    @DSModeled(DSC.BAN)
    private static String convertInt(AbstractStringBuilder sb, int i) {
        boolean negative = false;
        String quickResult = null;
        if (i < 0) {
            negative = true;
            i = -i;
            if (i < 100) {
                if (i < 0) {
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
        int bufLen = 11;
        char[] buf = (sb != null) ? BUFFER.get() : new char[bufLen];
        int cursor = bufLen;
        while (i >= (1 << 16)) {
            int q = (int) ((0x51EB851FL * i) >>> 37);
            int r = i - 100*q;
            buf[--cursor] = ONES[r];
            buf[--cursor] = TENS[r];
            i = q;
        }
        while (i != 0) {
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

    
    @DSModeled(DSC.BAN)
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
        boolean negative = false;
        if (v < 0) {
            negative = true;
        } else {
            v = -v;
        }
        int bufLen = radix < 8 ? 65 : 23;
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

    
    @DSModeled(DSC.SAFE)
    public static String longToString(long l) {
        return convertLong(null, l);
    }

    
    @DSModeled(DSC.BAN)
    public static void appendLong(AbstractStringBuilder sb, long l) {
        convertLong(sb, l);
    }

    
    @DSModeled(DSC.BAN)
    private static String convertLong(AbstractStringBuilder sb, long n) {
        int i = (int) n;
        if (i == n) {
            return convertInt(sb, i);
        }
        boolean negative = (n < 0);
        if (negative) {
            n = -n;
            if (n < 0) {
                String quickResult = "-9223372036854775808";
                if (sb != null) {
                    sb.append0(quickResult);
                    return null;
                }
                return quickResult;
            }
        }
        int bufLen = 20;
        char[] buf = (sb != null) ? BUFFER.get() : new char[bufLen];
        int low = (int) (n % 1000000000);
        int cursor = intIntoCharArray(buf, bufLen, low);
        while (cursor != (bufLen - 9)) {
            buf[--cursor] = '0';
        }
        n = ((n - low) >>> 9) * 0x8E47CE423A2E9C6DL;
        if ((n & (-1L << 32)) == 0) {
            cursor = intIntoCharArray(buf, cursor, (int) n);
        } else {
            int lo32 = (int) n;
            int hi32 = (int) (n >>> 32);
            int midDigit = MOD_10_TABLE[(0x19999999 * lo32 + (lo32 >>> 1) + (lo32 >>> 3)) >>> 28];
            midDigit -= hi32 << 2;  
            if (midDigit < 0) {
                midDigit += 10;
            }
            buf[--cursor] = DIGITS[midDigit];
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

    
    @DSModeled(DSC.BAN)
    private static int intIntoCharArray(char[] buf, int cursor, int n) {
        while ((n & 0xffff0000) != 0) {
            int q = (int) ((0x51EB851FL * (n >>> 2)) >>> 35);
            int r = n - 100*q;
            buf[--cursor] = ONES[r];
            buf[--cursor] = TENS[r];
            n = q;
        }
        while (n != 0) {
            int q = (0xCCCD * n) >>> 19;
            int r = n - 10*q;
            buf[--cursor] = DIGITS[r];
            n = q;
        }
        return cursor;
    }

    
    @DSModeled(DSC.BAN)
    public static String intToBinaryString(int i) {
        int bufLen = 32;
        char[] buf = new char[bufLen];
        int cursor = bufLen;
        do {
            buf[--cursor] = DIGITS[i & 1];
        }  while ((i >>>= 1) != 0);
        return new String(cursor, bufLen - cursor, buf);
    }

    
    @DSModeled(DSC.BAN)
    public static String longToBinaryString(long v) {
        int i = (int) v;
        if (v >= 0 && i == v) {
            return intToBinaryString(i);
        }
        int bufLen = 64;
        char[] buf = new char[bufLen];
        int cursor = bufLen;
        do {
            buf[--cursor] = DIGITS[((int) v) & 1];
        }  while ((v >>>= 1) != 0);
        return new String(cursor, bufLen - cursor, buf);
    }

    
    @DSModeled(DSC.BAN)
    public static StringBuilder appendByteAsHex(StringBuilder sb, byte b, boolean upperCase) {
        char[] digits = upperCase ? UPPER_CASE_DIGITS : DIGITS;
        sb.append(digits[(b >> 4) & 0xf]);
        sb.append(digits[b & 0xf]);
        return sb;
    }

    
    @DSModeled(DSC.SAFE)
    public static String byteToHexString(byte b, boolean upperCase) {
        char[] digits = upperCase ? UPPER_CASE_DIGITS : DIGITS;
        char[] buf = new char[2];
        buf[0] = digits[(b >> 4) & 0xf];
        buf[1] = digits[b & 0xf];
        return new String(0, 2, buf);
    }

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.BAN)
    public static String intToHexString(int i, boolean upperCase, int minWidth) {
        int bufLen = 8;
        char[] buf = new char[bufLen];
        int cursor = bufLen;
        char[] digits = upperCase ? UPPER_CASE_DIGITS : DIGITS;
        do {
            buf[--cursor] = digits[i & 0xf];
        } while ((i >>>= 4) != 0 || (bufLen - cursor < minWidth));
        return new String(cursor, bufLen - cursor, buf);
    }

    
    @DSModeled(DSC.SAFE)
    public static String longToHexString(long v) {
        int i = (int) v;
        if (v >= 0 && i == v) {
            return intToHexString(i, false, 0);
        }
        int bufLen = 16;
        char[] buf = new char[bufLen];
        int cursor = bufLen;
        do {
            buf[--cursor] = DIGITS[((int) v) & 0xF];
        } while ((v >>>= 4) != 0);
        return new String(cursor, bufLen - cursor, buf);
    }

    
    @DSModeled(DSC.SAFE)
    public static String intToOctalString(int i) {
        int bufLen = 11;
        char[] buf = new char[bufLen];
        int cursor = bufLen;
        do {
            buf[--cursor] = DIGITS[i & 7];
        } while ((i >>>= 3) != 0);
        return new String(cursor, bufLen - cursor, buf);
    }

    
    @DSModeled(DSC.SAFE)
    public static String longToOctalString(long v) {
        int i = (int) v;
        if (v >= 0 && i == v) {
            return intToOctalString(i);
        }
        int bufLen = 22;
        char[] buf = new char[bufLen];
        int cursor = bufLen;
        do {
            buf[--cursor] = DIGITS[((int) v) & 7];
        } while ((v >>>= 3) != 0);
        return new String(cursor, bufLen - cursor, buf);
    }

    
    @DSModeled(DSC.BAN)
    private static String stringOf(char... args) {
        return new String(0, args.length, args);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.236 -0400", hash_original_field = "AB280E60F0CF35D4F468078DFDA43178", hash_generated_field = "425773BE567620BA8858A8C9A806C3AB")

    private static final ThreadLocal<char[]> BUFFER = new ThreadLocal<char[]>() {        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.236 -0400", hash_original_method = "2EBCA8DA39A849AFE3E3749C7F49BA79", hash_generated_method = "DD3C6EC86D330D1AF7830345AF558804")
        @Override
        protected char[] initialValue() {
            char[] var401101FA2F200BBC59DD27CE1AD00AD7_83035988 = (new char[20]);
            char[] var50607924ABD4C17119BAF3A1CE41C0EC_66101806 = {getTaintChar()};
            return var50607924ABD4C17119BAF3A1CE41C0EC_66101806;
            
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.201 -0400", hash_original_field = "EAFB73603CE2CB8500F6DCC368134B80", hash_generated_field = "3F7A7621FDECF4B1F00F7F02BB032983")

    private static final String[] SMALL_NONNEGATIVE_VALUES = new String[100];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.201 -0400", hash_original_field = "488857CAEF9939FF9A91517F8184C90C", hash_generated_field = "0F2C6CD52D3AC35204AE87E543B933FE")

    private static final String[] SMALL_NEGATIVE_VALUES = new String[100];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.201 -0400", hash_original_field = "4E44F8641CA299D7987D949BD06F7C5E", hash_generated_field = "F4F0B5078F2B36CA1654493CC02FBE1B")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.201 -0400", hash_original_field = "2DFD29EBB5934DA81BA3D203A821EF23", hash_generated_field = "C40FC9CE2E1863E8D99B8E9E8459B998")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.201 -0400", hash_original_field = "611CCEC708888401FC95E85326BFD8A1", hash_generated_field = "7ECA72DEBCDA6EB92131D3D0F3D8765E")

    private static final char[] MOD_10_TABLE = {
        0, 1, 2, 2, 3, 3, 4, 5, 5, 6, 7, 7, 8, 8, 9, 0
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.201 -0400", hash_original_field = "4102EFFF5068B86037B1783FBB3A87A6", hash_generated_field = "0F077AEAC9BBB0ADF3D0D4E6AACE2DF1")

    private static final char[] DIGITS = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
        'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
        'u', 'v', 'w', 'x', 'y', 'z'
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.201 -0400", hash_original_field = "26697557AFB8BA6B08D03FD60A18E4FF", hash_generated_field = "C31924D8CB8753379AD2B96C86ABBAE8")

    private static final char[] UPPER_CASE_DIGITS = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
        'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
        'U', 'V', 'W', 'X', 'Y', 'Z'
    };
}

