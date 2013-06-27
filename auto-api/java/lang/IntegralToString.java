package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class IntegralToString {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.823 -0400", hash_original_method = "DF20FC0B1F395B5ECC5581BA0BD3AC0B", hash_generated_method = "724F18F022450896EB503A5FBBDA6BC7")
    private  IntegralToString() {
        // ---------- Original Method ----------
    }

    
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

    
        public static String intToString(int i) {
        return convertInt(null, i);
    }

    
        public static void appendInt(AbstractStringBuilder sb, int i) {
        convertInt(sb, i);
    }

    
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

    
        public static String longToString(long l) {
        return convertLong(null, l);
    }

    
        public static void appendLong(AbstractStringBuilder sb, long l) {
        convertLong(sb, l);
    }

    
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

    
        public static String intToBinaryString(int i) {
        int bufLen = 32;
        char[] buf = new char[bufLen];
        int cursor = bufLen;
        do {
            buf[--cursor] = DIGITS[i & 1];
        }  while ((i >>>= 1) != 0);
        return new String(cursor, bufLen - cursor, buf);
    }

    
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

    
        public static StringBuilder appendByteAsHex(StringBuilder sb, byte b, boolean upperCase) {
        char[] digits = upperCase ? UPPER_CASE_DIGITS : DIGITS;
        sb.append(digits[(b >> 4) & 0xf]);
        sb.append(digits[b & 0xf]);
        return sb;
    }

    
        public static String byteToHexString(byte b, boolean upperCase) {
        char[] digits = upperCase ? UPPER_CASE_DIGITS : DIGITS;
        char[] buf = new char[2];
        buf[0] = digits[(b >> 4) & 0xf];
        buf[1] = digits[b & 0xf];
        return new String(0, 2, buf);
    }

    
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

    
        public static String intToOctalString(int i) {
        int bufLen = 11;
        char[] buf = new char[bufLen];
        int cursor = bufLen;
        do {
            buf[--cursor] = DIGITS[i & 7];
        } while ((i >>>= 3) != 0);
        return new String(cursor, bufLen - cursor, buf);
    }

    
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

    
        private static String stringOf(char... args) {
        return new String(0, args.length, args);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.874 -0400", hash_original_field = "AB280E60F0CF35D4F468078DFDA43178", hash_generated_field = "B72B8BB11CFF9DD0FC2237D4817FD1DA")

    private static ThreadLocal<char[]> BUFFER = new ThreadLocal<char[]>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.874 -0400", hash_original_method = "2EBCA8DA39A849AFE3E3749C7F49BA79", hash_generated_method = "575661B0D955C7EE2EFE8DFB6E44951D")
        @Override
        protected char[] initialValue() {
            char[] var401101FA2F200BBC59DD27CE1AD00AD7_1407371010 = (new char[20]);
            char[] var50607924ABD4C17119BAF3A1CE41C0EC_2107241563 = {getTaintChar()};
            return var50607924ABD4C17119BAF3A1CE41C0EC_2107241563;
            // ---------- Original Method ----------
            //return new char[20];
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.874 -0400", hash_original_field = "EAFB73603CE2CB8500F6DCC368134B80", hash_generated_field = "10F1A9F0A79564FDF741D9913F8DBDA3")

    private static String[] SMALL_NONNEGATIVE_VALUES = new String[100];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.874 -0400", hash_original_field = "488857CAEF9939FF9A91517F8184C90C", hash_generated_field = "C47224BEF3BE0FC2C1A8150BECD5E9C0")

    private static String[] SMALL_NEGATIVE_VALUES = new String[100];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.874 -0400", hash_original_field = "4E44F8641CA299D7987D949BD06F7C5E", hash_generated_field = "8107D16E7A9CFBBC3A641D1B14313394")

    private static char[] TENS = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.874 -0400", hash_original_field = "2DFD29EBB5934DA81BA3D203A821EF23", hash_generated_field = "1B9F87B10B0EF538BFA9C680ABE58778")

    private static char[] ONES = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.874 -0400", hash_original_field = "611CCEC708888401FC95E85326BFD8A1", hash_generated_field = "CBD055E1EDB2DB59199BB05EB60BA748")

    private static char[] MOD_10_TABLE = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.874 -0400", hash_original_field = "4102EFFF5068B86037B1783FBB3A87A6", hash_generated_field = "D65854F37D133994A5CD968BA1C3B3CD")

    private static char[] DIGITS = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.874 -0400", hash_original_field = "26697557AFB8BA6B08D03FD60A18E4FF", hash_generated_field = "AE4626EABB3CE7F739881CAAD918A316")

    private static char[] UPPER_CASE_DIGITS = ;
}

