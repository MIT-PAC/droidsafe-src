package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;
import java.util.Arrays;

public final class Character implements Serializable, Comparable<Character> {
    private char value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.520 -0400", hash_original_method = "8DEFF913326DC7F74512EFD131579B65", hash_generated_method = "21AA08DE5D9FB709249FCA2BB4A5432B")
    @DSModeled(DSC.SAFE)
    public Character(char value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        //this.value = value;
    }

    
        private static int forNameImpl(String blockName) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int ofImpl(int codePoint) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.521 -0400", hash_original_method = "1972D57F3C05C7BADF696B9ADC3E34F9", hash_generated_method = "D7BF0C5F83CAFA88A8E87093DF719E92")
    @DSModeled(DSC.SAFE)
    public char charValue() {
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //return value;
    }

    
        private static void checkValidCodePoint(int codePoint) {
        if (!isValidCodePoint(codePoint)) {
            throw new IllegalArgumentException("Invalid code point: " + codePoint);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.521 -0400", hash_original_method = "3BC38476D10A0BB1E7E9CABDBB184EDE", hash_generated_method = "D657241DBB93D11ADEA3FF27C25E5E65")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int compareTo(Character c) {
        dsTaint.addTaint(c.dsTaint);
        int var2D53C4D03B154FEA4531431C9E7F8DB6_1529659267 = (compare(value, c.value));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return compare(value, c.value);
    }

    
        public static int compare(char lhs, char rhs) {
        return lhs - rhs;
    }

    
        public static Character valueOf(char c) {
        return c < 128 ? SMALL_VALUES[c] : new Character(c);
    }

    
        public static boolean isValidCodePoint(int codePoint) {
        return (MIN_CODE_POINT <= codePoint && MAX_CODE_POINT >= codePoint);
    }

    
        public static boolean isSupplementaryCodePoint(int codePoint) {
        return (MIN_SUPPLEMENTARY_CODE_POINT <= codePoint && MAX_CODE_POINT >= codePoint);
    }

    
        public static boolean isHighSurrogate(char ch) {
        return (MIN_HIGH_SURROGATE <= ch && MAX_HIGH_SURROGATE >= ch);
    }

    
        public static boolean isLowSurrogate(char ch) {
        return (MIN_LOW_SURROGATE <= ch && MAX_LOW_SURROGATE >= ch);
    }

    
        public static boolean isSurrogate(char ch) {
        return ch >= MIN_SURROGATE && ch <= MAX_SURROGATE;
    }

    
        public static boolean isSurrogatePair(char high, char low) {
        return (isHighSurrogate(high) && isLowSurrogate(low));
    }

    
        public static int charCount(int codePoint) {
        return (codePoint >= 0x10000 ? 2 : 1);
    }

    
        public static int toCodePoint(char high, char low) {
        int h = (high & 0x3FF) << 10;
        int l = low & 0x3FF;
        return (h | l) + 0x10000;
    }

    
        public static int codePointAt(CharSequence seq, int index) {
        if (seq == null) {
            throw new NullPointerException();
        }
        int len = seq.length();
        if (index < 0 || index >= len) {
            throw new IndexOutOfBoundsException();
        }
        char high = seq.charAt(index++);
        if (index >= len) {
            return high;
        }
        char low = seq.charAt(index);
        if (isSurrogatePair(high, low)) {
            return toCodePoint(high, low);
        }
        return high;
    }

    
        public static int codePointAt(char[] seq, int index) {
        if (seq == null) {
            throw new NullPointerException();
        }
        int len = seq.length;
        if (index < 0 || index >= len) {
            throw new IndexOutOfBoundsException();
        }
        char high = seq[index++];
        if (index >= len) {
            return high;
        }
        char low = seq[index];
        if (isSurrogatePair(high, low)) {
            return toCodePoint(high, low);
        }
        return high;
    }

    
        public static int codePointAt(char[] seq, int index, int limit) {
        if (index < 0 || index >= limit || limit < 0 || limit > seq.length) {
            throw new IndexOutOfBoundsException();
        }
        char high = seq[index++];
        if (index >= limit) {
            return high;
        }
        char low = seq[index];
        if (isSurrogatePair(high, low)) {
            return toCodePoint(high, low);
        }
        return high;
    }

    
        public static int codePointBefore(CharSequence seq, int index) {
        if (seq == null) {
            throw new NullPointerException();
        }
        int len = seq.length();
        if (index < 1 || index > len) {
            throw new IndexOutOfBoundsException();
        }
        char low = seq.charAt(--index);
        if (--index < 0) {
            return low;
        }
        char high = seq.charAt(index);
        if (isSurrogatePair(high, low)) {
            return toCodePoint(high, low);
        }
        return low;
    }

    
        public static int codePointBefore(char[] seq, int index) {
        if (seq == null) {
            throw new NullPointerException();
        }
        int len = seq.length;
        if (index < 1 || index > len) {
            throw new IndexOutOfBoundsException();
        }
        char low = seq[--index];
        if (--index < 0) {
            return low;
        }
        char high = seq[index];
        if (isSurrogatePair(high, low)) {
            return toCodePoint(high, low);
        }
        return low;
    }

    
        public static int codePointBefore(char[] seq, int index, int start) {
        if (seq == null) {
            throw new NullPointerException();
        }
        int len = seq.length;
        if (index <= start || index > len || start < 0 || start >= len) {
            throw new IndexOutOfBoundsException();
        }
        char low = seq[--index];
        if (--index < start) {
            return low;
        }
        char high = seq[index];
        if (isSurrogatePair(high, low)) {
            return toCodePoint(high, low);
        }
        return low;
    }

    
        public static int toChars(int codePoint, char[] dst, int dstIndex) {
        checkValidCodePoint(codePoint);
        if (dst == null) {
            throw new NullPointerException();
        }
        if (dstIndex < 0 || dstIndex >= dst.length) {
            throw new IndexOutOfBoundsException();
        }
        if (isSupplementaryCodePoint(codePoint)) {
            if (dstIndex == dst.length - 1) {
                throw new IndexOutOfBoundsException();
            }
            int cpPrime = codePoint - 0x10000;
            int high = 0xD800 | ((cpPrime >> 10) & 0x3FF);
            int low = 0xDC00 | (cpPrime & 0x3FF);
            dst[dstIndex] = (char) high;
            dst[dstIndex + 1] = (char) low;
            return 2;
        }
        dst[dstIndex] = (char) codePoint;
        return 1;
    }

    
        public static char[] toChars(int codePoint) {
        checkValidCodePoint(codePoint);
        if (isSupplementaryCodePoint(codePoint)) {
            int cpPrime = codePoint - 0x10000;
            int high = 0xD800 | ((cpPrime >> 10) & 0x3FF);
            int low = 0xDC00 | (cpPrime & 0x3FF);
            return new char[] { (char) high, (char) low };
        }
        return new char[] { (char) codePoint };
    }

    
        public static int codePointCount(CharSequence seq, int beginIndex,
            int endIndex) {
        if (seq == null) {
            throw new NullPointerException();
        }
        int len = seq.length();
        if (beginIndex < 0 || endIndex > len || beginIndex > endIndex) {
            throw new IndexOutOfBoundsException();
        }
        int result = 0;
        for (int i = beginIndex; i < endIndex; i++) {
            char c = seq.charAt(i);
            if (isHighSurrogate(c)) {
                if (++i < endIndex) {
                    c = seq.charAt(i);
                    if (!isLowSurrogate(c)) {
                        result++;
                    }
                }
            }
            result++;
        }
        return result;
    }

    
        public static int codePointCount(char[] seq, int offset, int count) {
        Arrays.checkOffsetAndCount(seq.length, offset, count);
        int endIndex = offset + count;
        int result = 0;
        for (int i = offset; i < endIndex; i++) {
            char c = seq[i];
            if (isHighSurrogate(c)) {
                if (++i < endIndex) {
                    c = seq[i];
                    if (!isLowSurrogate(c)) {
                        result++;
                    }
                }
            }
            result++;
        }
        return result;
    }

    
        public static int offsetByCodePoints(CharSequence seq, int index, int codePointOffset) {
        if (seq == null) {
            throw new NullPointerException();
        }
        int len = seq.length();
        if (index < 0 || index > len) {
            throw new IndexOutOfBoundsException();
        }
        if (codePointOffset == 0) {
            return index;
        }
        if (codePointOffset > 0) {
            int codePoints = codePointOffset;
            int i = index;
            while (codePoints > 0) {
                codePoints--;
                if (i >= len) {
                    throw new IndexOutOfBoundsException();
                }
                if (isHighSurrogate(seq.charAt(i))) {
                    int next = i + 1;
                    if (next < len && isLowSurrogate(seq.charAt(next))) {
                        i++;
                    }
                }
                i++;
            }
            return i;
        }
        int codePoints = -codePointOffset;
        int i = index;
        while (codePoints > 0) {
            codePoints--;
            i--;
            if (i < 0) {
                throw new IndexOutOfBoundsException();
            }
            if (isLowSurrogate(seq.charAt(i))) {
                int prev = i - 1;
                if (prev >= 0 && isHighSurrogate(seq.charAt(prev))) {
                    i--;
                }
            }
        }
        return i;
    }

    
        public static int offsetByCodePoints(char[] seq, int start, int count,
            int index, int codePointOffset) {
        Arrays.checkOffsetAndCount(seq.length, start, count);
        int end = start + count;
        if (index < start || index > end) {
            throw new IndexOutOfBoundsException();
        }
        if (codePointOffset == 0) {
            return index;
        }
        if (codePointOffset > 0) {
            int codePoints = codePointOffset;
            int i = index;
            while (codePoints > 0) {
                codePoints--;
                if (i >= end) {
                    throw new IndexOutOfBoundsException();
                }
                if (isHighSurrogate(seq[i])) {
                    int next = i + 1;
                    if (next < end && isLowSurrogate(seq[next])) {
                        i++;
                    }
                }
                i++;
            }
            return i;
        }
        int codePoints = -codePointOffset;
        int i = index;
        while (codePoints > 0) {
            codePoints--;
            i--;
            if (i < start) {
                throw new IndexOutOfBoundsException();
            }
            if (isLowSurrogate(seq[i])) {
                int prev = i - 1;
                if (prev >= start && isHighSurrogate(seq[prev])) {
                    i--;
                }
            }
        }
        return i;
    }

    
        public static int digit(char c, int radix) {
        return digit((int) c, radix);
    }

    
        public static int digit(int codePoint, int radix) {
        if (radix < MIN_RADIX || radix > MAX_RADIX) {
            return -1;
        }
        if (codePoint < 128) {
            int result = -1;
            if ('0' <= codePoint && codePoint <= '9') {
                result = codePoint - '0';
            } else if ('a' <= codePoint && codePoint <= 'z') {
                result = 10 + (codePoint - 'a');
            } else if ('A' <= codePoint && codePoint <= 'Z') {
                result = 10 + (codePoint - 'A');
            }
            return result < radix ? result : -1;
        }
        return digitImpl(codePoint, radix);
    }

    
        private static int digitImpl(int codePoint, int radix) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.525 -0400", hash_original_method = "88215BA2DAA464AB2808512F13A48003", hash_generated_method = "61692EE26D4111810D0F94BEB4188154")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (object instanceof Character) && (((Character) object).value == value);
    }

    
        public static char forDigit(int digit, int radix) {
        if (MIN_RADIX <= radix && radix <= MAX_RADIX) {
            if (digit >= 0 && digit < radix) {
                return (char) (digit < 10 ? digit + '0' : digit + 'a' - 10);
            }
        }
        return 0;
    }

    
        public static String getName(int codePoint) {
        checkValidCodePoint(codePoint);
        if (getType(codePoint) == Character.UNASSIGNED) {
            return null;
        }
        String result = getNameImpl(codePoint);
        if (result == null) {
            String blockName = Character.UnicodeBlock.of(codePoint).toString().replace('_', ' ');
            result = blockName + " " + IntegralToString.intToHexString(codePoint, true, 0);
        }
        return result;
    }

    
        private static String getNameImpl(int codePoint) {
        return DSUtils.UNKNOWN_STRING;
    }

    
        public static int getNumericValue(char c) {
        return getNumericValue((int) c);
    }

    
        public static int getNumericValue(int codePoint) {
        if (codePoint < 128) {
            if (codePoint >= '0' && codePoint <= '9') {
                return codePoint - '0';
            }
            if (codePoint >= 'a' && codePoint <= 'z') {
                return codePoint - ('a' - 10);
            }
            if (codePoint >= 'A' && codePoint <= 'Z') {
                return codePoint - ('A' - 10);
            }
            return -1;
        }
        if (codePoint >= 0xff21 && codePoint <= 0xff3a) {
            return codePoint - 0xff17;
        }
        if (codePoint >= 0xff41 && codePoint <= 0xff5a) {
            return codePoint - 0xff37;
        }
        return getNumericValueImpl(codePoint);
    }

    
        private static int getNumericValueImpl(int codePoint) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static int getType(char c) {
        return getType((int) c);
    }

    
        public static int getType(int codePoint) {
        int type = getTypeImpl(codePoint);
        if (type <= Character.FORMAT) {
            return type;
        }
        return (type + 1);
    }

    
        private static int getTypeImpl(int codePoint) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static byte getDirectionality(char c) {
        return getDirectionality((int)c);
    }

    
        public static byte getDirectionality(int codePoint) {
        if (getType(codePoint) == Character.UNASSIGNED) {
            return Character.DIRECTIONALITY_UNDEFINED;
        }
        byte directionality = getDirectionalityImpl(codePoint);
        if (directionality == -1) {
            return -1;
        }
        return DIRECTIONALITY[directionality];
    }

    
        private static byte getDirectionalityImpl(int codePoint) {
        return DSUtils.UNKNOWN_BYTE;
    }

    
        public static boolean isMirrored(char c) {
        return isMirrored((int) c);
    }

    
        public static boolean isMirrored(int codePoint) {
        return isMirroredImpl(codePoint);
    }

    
        private static boolean isMirroredImpl(int codePoint) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.527 -0400", hash_original_method = "961F210287166DF05D8915D632129E75", hash_generated_method = "2CC0EC8302E0602B9137F5B8629A7214")
    @DSModeled(DSC.SAFE)
    @Override
    public int hashCode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return value;
    }

    
        public static char highSurrogate(int codePoint) {
        return (char) ((codePoint >> 10) + 0xd7c0);
    }

    
        public static char lowSurrogate(int codePoint) {
        return (char) ((codePoint & 0x3ff) | 0xdc00);
    }

    
        public static boolean isBmpCodePoint(int codePoint) {
        return codePoint >= 0 && codePoint <= 0xffff;
    }

    
        public static boolean isDefined(char c) {
        return isDefinedImpl(c);
    }

    
        public static boolean isDefined(int codePoint) {
        return isDefinedImpl(codePoint);
    }

    
        private static boolean isDefinedImpl(int codePoint) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        public static boolean isDigit(char c) {
        return isDigit((int) c);
    }

    
        public static boolean isDigit(int codePoint) {
        if ('0' <= codePoint && codePoint <= '9') {
            return true;
        }
        if (codePoint < 1632) {
            return false;
        }
        return isDigitImpl(codePoint);
    }

    
        private static boolean isDigitImpl(int codePoint) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        public static boolean isIdentifierIgnorable(char c) {
        return isIdentifierIgnorable((int) c);
    }

    
        public static boolean isIdentifierIgnorable(int codePoint) {
        if (codePoint < 0x600) {
            return (codePoint >= 0 && codePoint <= 8) || (codePoint >= 0xe && codePoint <= 0x1b) ||
                    (codePoint >= 0x7f && codePoint <= 0x9f) || (codePoint == 0xad);
        }
        return isIdentifierIgnorableImpl(codePoint);
    }

    
        private static boolean isIdentifierIgnorableImpl(int codePoint) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        public static boolean isISOControl(char c) {
        return isISOControl((int) c);
    }

    
        public static boolean isISOControl(int c) {
        return (c >= 0 && c <= 0x1f) || (c >= 0x7f && c <= 0x9f);
    }

    
        public static boolean isJavaIdentifierPart(char c) {
        return isJavaIdentifierPart((int) c);
    }

    
        public static boolean isJavaIdentifierPart(int codePoint) {
        if (codePoint < 64) {
            return (0x3ff00100fffc1ffL & (1L << codePoint)) != 0;
        } else if (codePoint < 128) {
            return (0x87fffffe87fffffeL & (1L << (codePoint - 64))) != 0;
        }
        int type = getType(codePoint);
        return (type >= UPPERCASE_LETTER && type <= OTHER_LETTER)
                || type == CURRENCY_SYMBOL || type == CONNECTOR_PUNCTUATION
                || (type >= DECIMAL_DIGIT_NUMBER && type <= LETTER_NUMBER)
                || type == COMBINING_SPACING_MARK || type == NON_SPACING_MARK
                || (codePoint >= 0 && codePoint <= 8) || (codePoint >= 0xe && codePoint <= 0x1b)
                || (codePoint >= 0x7f && codePoint <= 0x9f) || type == FORMAT;
    }

    
        public static boolean isJavaIdentifierStart(char c) {
        return isJavaIdentifierStart((int) c);
    }

    
        public static boolean isJavaIdentifierStart(int codePoint) {
        if (codePoint < 64) {
            return (codePoint == '$'); 
        } else if (codePoint < 128) {
            return (0x7fffffe87fffffeL & (1L << (codePoint - 64))) != 0;
        }
        int type = getType(codePoint);
        return (type >= UPPERCASE_LETTER && type <= OTHER_LETTER) || type == CURRENCY_SYMBOL
                || type == CONNECTOR_PUNCTUATION || type == LETTER_NUMBER;
    }

    
        @Deprecated
    public static boolean isJavaLetter(char c) {
        return isJavaIdentifierStart(c);
    }

    
        @Deprecated
    public static boolean isJavaLetterOrDigit(char c) {
        return isJavaIdentifierPart(c);
    }

    
        public static boolean isLetter(char c) {
        return isLetter((int) c);
    }

    
        public static boolean isLetter(int codePoint) {
        if (('A' <= codePoint && codePoint <= 'Z') || ('a' <= codePoint && codePoint <= 'z')) {
            return true;
        }
        if (codePoint < 128) {
            return false;
        }
        return isLetterImpl(codePoint);
    }

    
        private static boolean isLetterImpl(int codePoint) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        public static boolean isLetterOrDigit(char c) {
        return isLetterOrDigit((int) c);
    }

    
        public static boolean isLetterOrDigit(int codePoint) {
        if (('A' <= codePoint && codePoint <= 'Z') || ('a' <= codePoint && codePoint <= 'z')) {
            return true;
        }
        if ('0' <= codePoint && codePoint <= '9') {
            return true;
        }
        if (codePoint < 128) {
            return false;
        }
        return isLetterOrDigitImpl(codePoint);
    }

    
        private static boolean isLetterOrDigitImpl(int codePoint) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        public static boolean isLowerCase(char c) {
        return isLowerCase((int) c);
    }

    
        public static boolean isLowerCase(int codePoint) {
        if ('a' <= codePoint && codePoint <= 'z') {
            return true;
        }
        if (codePoint < 128) {
            return false;
        }
        return isLowerCaseImpl(codePoint);
    }

    
        private static boolean isLowerCaseImpl(int codePoint) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        @Deprecated
    public static boolean isSpace(char c) {
        return c == '\n' || c == '\t' || c == '\f' || c == '\r' || c == ' ';
    }

    
        public static boolean isSpaceChar(char c) {
        return isSpaceChar((int) c);
    }

    
        public static boolean isSpaceChar(int codePoint) {
        if (codePoint == 0x20 || codePoint == 0xa0 || codePoint == 0x1680) {
            return true;
        }
        if (codePoint < 0x2000) {
            return false;
        }
        if (codePoint <= 0xffff) {
            return codePoint <= 0x200b || codePoint == 0x2028 || codePoint == 0x2029 ||
                    codePoint == 0x202f || codePoint == 0x3000;
        }
        return isSpaceCharImpl(codePoint);
    }

    
        private static boolean isSpaceCharImpl(int codePoint) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        public static boolean isTitleCase(char c) {
        return isTitleCaseImpl(c);
    }

    
        public static boolean isTitleCase(int codePoint) {
        return isTitleCaseImpl(codePoint);
    }

    
        private static boolean isTitleCaseImpl(int codePoint) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        public static boolean isUnicodeIdentifierPart(char c) {
        return isUnicodeIdentifierPartImpl(c);
    }

    
        public static boolean isUnicodeIdentifierPart(int codePoint) {
        return isUnicodeIdentifierPartImpl(codePoint);
    }

    
        private static boolean isUnicodeIdentifierPartImpl(int codePoint) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        public static boolean isUnicodeIdentifierStart(char c) {
        return isUnicodeIdentifierStartImpl(c);
    }

    
        public static boolean isUnicodeIdentifierStart(int codePoint) {
        return isUnicodeIdentifierStartImpl(codePoint);
    }

    
        private static boolean isUnicodeIdentifierStartImpl(int codePoint) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        public static boolean isUpperCase(char c) {
        return isUpperCase((int) c);
    }

    
        public static boolean isUpperCase(int codePoint) {
        if ('A' <= codePoint && codePoint <= 'Z') {
            return true;
        }
        if (codePoint < 128) {
            return false;
        }
        return isUpperCaseImpl(codePoint);
    }

    
        private static boolean isUpperCaseImpl(int codePoint) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        public static boolean isWhitespace(char c) {
        return isWhitespace((int) c);
    }

    
        public static boolean isWhitespace(int codePoint) {
        if ((codePoint >= 0x1c && codePoint <= 0x20) || (codePoint >= 0x9 && codePoint <= 0xd)) {
            return true;
        }
        if (codePoint == 0x1680) {
            return true;
        }
        if (codePoint < 0x2000 || codePoint == 0x2007) {
            return false;
        }
        if (codePoint <= 0xffff) {
            return codePoint <= 0x200b || codePoint == 0x2028 || codePoint == 0x2029 ||
                    codePoint == 0x3000;
        }
        return isWhitespaceImpl(codePoint);
    }

    
        private static boolean isWhitespaceImpl(int codePoint) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        public static char reverseBytes(char c) {
        return (char)((c<<8) | (c>>8));
    }

    
        public static char toLowerCase(char c) {
        return (char) toLowerCase((int) c);
    }

    
        public static int toLowerCase(int codePoint) {
        if ('A' <= codePoint && codePoint <= 'Z') {
            return (char) (codePoint + ('a' - 'A'));
        }
        if (codePoint < 192) {
            return codePoint;
        }
        return toLowerCaseImpl(codePoint);
    }

    
        private static int toLowerCaseImpl(int codePoint) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.533 -0400", hash_original_method = "27F3E47E60B1213ECE72A0C1452319D1", hash_generated_method = "FC0C81FA07C5B672CD6D0219F4BAC129")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String varE56CB71A0102261E1E6B2E712053A166_273951476 = (String.valueOf(value));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return String.valueOf(value);
    }

    
        public static String toString(char value) {
        return String.valueOf(value);
    }

    
        public static char toTitleCase(char c) {
        return (char) toTitleCaseImpl(c);
    }

    
        public static int toTitleCase(int codePoint) {
        return toTitleCaseImpl(codePoint);
    }

    
        private static int toTitleCaseImpl(int codePoint) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static char toUpperCase(char c) {
        return (char) toUpperCase((int) c);
    }

    
        public static int toUpperCase(int codePoint) {
        if ('a' <= codePoint && codePoint <= 'z') {
            return (char) (codePoint - ('a' - 'A'));
        }
        if (codePoint < 181) {
            return codePoint;
        }
        return toUpperCaseImpl(codePoint);
    }

    
        private static int toUpperCaseImpl(int codePoint) {
        return DSUtils.UNKNOWN_INT;
    }

    
    public static class Subset {
        String name;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.534 -0400", hash_original_method = "F864A542FCD1C844E1D83841069C7DB4", hash_generated_method = "9256548ED3A73C311D989009863EDBB0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected Subset(String string) {
            dsTaint.addTaint(string);
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            // ---------- Original Method ----------
            //if (string == null) {
                //throw new NullPointerException();
            //}
            //name = string;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.534 -0400", hash_original_method = "4C72D63DD7600BBEA68526CF4A3E7570", hash_generated_method = "0FBB9739A338A21761CD492FE7EF4EAF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public final boolean equals(Object object) {
            dsTaint.addTaint(object.dsTaint);
            boolean varA3157AA9BC21D9DE63321077403F3F07_380171902 = (super.equals(object));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return super.equals(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.534 -0400", hash_original_method = "BBCDAD7BF06FB621822DBBAD11355700", hash_generated_method = "B0FE7C43743B0FA081416321CF421A71")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public final int hashCode() {
            int var7065CA1B738CD514456434D45E0A5A67_639999176 = (super.hashCode());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return super.hashCode();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.534 -0400", hash_original_method = "0EB66BA5E965B83E191719250E0A82FF", hash_generated_method = "FEF344B1068AD1616CE235619EEF4208")
        @DSModeled(DSC.SAFE)
        @Override
        public final String toString() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return name;
        }

        
    }


    
    public static final class UnicodeBlock extends Subset {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.535 -0400", hash_original_method = "234E88093AAFC12110C9FE35072443BD", hash_generated_method = "B2ABF9878AB37D4F41DFB1A7DE1C24DB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private UnicodeBlock(String blockName, int start, int end) {
            super(blockName);
            dsTaint.addTaint(start);
            dsTaint.addTaint(blockName);
            dsTaint.addTaint(end);
            // ---------- Original Method ----------
        }

        
                public static UnicodeBlock forName(String blockName) {
            if (blockName == null) {
                throw new NullPointerException();
            }
            int block = forNameImpl(blockName);
            if (block == -1) {
                if (blockName.equals("SURROGATES_AREA")) {
                    return SURROGATES_AREA;
                } else if(blockName.equalsIgnoreCase("greek")) {
                    return GREEK;
                } else if(blockName.equals("COMBINING_MARKS_FOR_SYMBOLS") ||
                        blockName.equals("Combining Marks for Symbols") ||
                        blockName.equals("CombiningMarksforSymbols")) {
                    return COMBINING_MARKS_FOR_SYMBOLS;
                }
                throw new IllegalArgumentException("Bad block name: " + blockName);
            }
            return BLOCKS[block];
        }

        
                public static UnicodeBlock of(char c) {
            return of((int) c);
        }

        
                public static UnicodeBlock of(int codePoint) {
            checkValidCodePoint(codePoint);
            int block = ofImpl(codePoint);
            if (block == -1 || block >= BLOCKS.length) {
                return null;
            }
            return BLOCKS[block];
        }

        
        @Deprecated public static final UnicodeBlock SURROGATES_AREA = new UnicodeBlock("SURROGATES_AREA", 0x0, 0x0);
        public static final UnicodeBlock BASIC_LATIN = new UnicodeBlock("BASIC_LATIN", 0x0, 0x7f);
        public static final UnicodeBlock LATIN_1_SUPPLEMENT = new UnicodeBlock("LATIN_1_SUPPLEMENT", 0x80, 0xff);
        public static final UnicodeBlock LATIN_EXTENDED_A = new UnicodeBlock("LATIN_EXTENDED_A", 0x100, 0x17f);
        public static final UnicodeBlock LATIN_EXTENDED_B = new UnicodeBlock("LATIN_EXTENDED_B", 0x180, 0x24f);
        public static final UnicodeBlock IPA_EXTENSIONS = new UnicodeBlock("IPA_EXTENSIONS", 0x250, 0x2af);
        public static final UnicodeBlock SPACING_MODIFIER_LETTERS = new UnicodeBlock("SPACING_MODIFIER_LETTERS", 0x2b0, 0x2ff);
        public static final UnicodeBlock COMBINING_DIACRITICAL_MARKS = new UnicodeBlock("COMBINING_DIACRITICAL_MARKS", 0x300, 0x36f);
        public static final UnicodeBlock GREEK = new UnicodeBlock("GREEK", 0x370, 0x3ff);
        public static final UnicodeBlock CYRILLIC = new UnicodeBlock("CYRILLIC", 0x400, 0x4ff);
        public static final UnicodeBlock CYRILLIC_SUPPLEMENTARY = new UnicodeBlock("CYRILLIC_SUPPLEMENTARY", 0x500, 0x52f);
        public static final UnicodeBlock ARMENIAN = new UnicodeBlock("ARMENIAN", 0x530, 0x58f);
        public static final UnicodeBlock HEBREW = new UnicodeBlock("HEBREW", 0x590, 0x5ff);
        public static final UnicodeBlock ARABIC = new UnicodeBlock("ARABIC", 0x600, 0x6ff);
        public static final UnicodeBlock SYRIAC = new UnicodeBlock("SYRIAC", 0x700, 0x74f);
        public static final UnicodeBlock THAANA = new UnicodeBlock("THAANA", 0x780, 0x7bf);
        public static final UnicodeBlock DEVANAGARI = new UnicodeBlock("DEVANAGARI", 0x900, 0x97f);
        public static final UnicodeBlock BENGALI = new UnicodeBlock("BENGALI", 0x980, 0x9ff);
        public static final UnicodeBlock GURMUKHI = new UnicodeBlock("GURMUKHI", 0xa00, 0xa7f);
        public static final UnicodeBlock GUJARATI = new UnicodeBlock("GUJARATI", 0xa80, 0xaff);
        public static final UnicodeBlock ORIYA = new UnicodeBlock("ORIYA", 0xb00, 0xb7f);
        public static final UnicodeBlock TAMIL = new UnicodeBlock("TAMIL", 0xb80, 0xbff);
        public static final UnicodeBlock TELUGU = new UnicodeBlock("TELUGU", 0xc00, 0xc7f);
        public static final UnicodeBlock KANNADA = new UnicodeBlock("KANNADA", 0xc80, 0xcff);
        public static final UnicodeBlock MALAYALAM = new UnicodeBlock("MALAYALAM", 0xd00, 0xd7f);
        public static final UnicodeBlock SINHALA = new UnicodeBlock("SINHALA", 0xd80, 0xdff);
        public static final UnicodeBlock THAI = new UnicodeBlock("THAI", 0xe00, 0xe7f);
        public static final UnicodeBlock LAO = new UnicodeBlock("LAO", 0xe80, 0xeff);
        public static final UnicodeBlock TIBETAN = new UnicodeBlock("TIBETAN", 0xf00, 0xfff);
        public static final UnicodeBlock MYANMAR = new UnicodeBlock("MYANMAR", 0x1000, 0x109f);
        public static final UnicodeBlock GEORGIAN = new UnicodeBlock("GEORGIAN", 0x10a0, 0x10ff);
        public static final UnicodeBlock HANGUL_JAMO = new UnicodeBlock("HANGUL_JAMO", 0x1100, 0x11ff);
        public static final UnicodeBlock ETHIOPIC = new UnicodeBlock("ETHIOPIC", 0x1200, 0x137f);
        public static final UnicodeBlock CHEROKEE = new UnicodeBlock("CHEROKEE", 0x13a0, 0x13ff);
        public static final UnicodeBlock UNIFIED_CANADIAN_ABORIGINAL_SYLLABICS = new UnicodeBlock("UNIFIED_CANADIAN_ABORIGINAL_SYLLABICS", 0x1400, 0x167f);
        public static final UnicodeBlock OGHAM = new UnicodeBlock("OGHAM", 0x1680, 0x169f);
        public static final UnicodeBlock RUNIC = new UnicodeBlock("RUNIC", 0x16a0, 0x16ff);
        public static final UnicodeBlock TAGALOG = new UnicodeBlock("TAGALOG", 0x1700, 0x171f);
        public static final UnicodeBlock HANUNOO = new UnicodeBlock("HANUNOO", 0x1720, 0x173f);
        public static final UnicodeBlock BUHID = new UnicodeBlock("BUHID", 0x1740, 0x175f);
        public static final UnicodeBlock TAGBANWA = new UnicodeBlock("TAGBANWA", 0x1760, 0x177f);
        public static final UnicodeBlock KHMER = new UnicodeBlock("KHMER", 0x1780, 0x17ff);
        public static final UnicodeBlock MONGOLIAN = new UnicodeBlock("MONGOLIAN", 0x1800, 0x18af);
        public static final UnicodeBlock LIMBU = new UnicodeBlock("LIMBU", 0x1900, 0x194f);
        public static final UnicodeBlock TAI_LE = new UnicodeBlock("TAI_LE", 0x1950, 0x197f);
        public static final UnicodeBlock KHMER_SYMBOLS = new UnicodeBlock("KHMER_SYMBOLS", 0x19e0, 0x19ff);
        public static final UnicodeBlock PHONETIC_EXTENSIONS = new UnicodeBlock("PHONETIC_EXTENSIONS", 0x1d00, 0x1d7f);
        public static final UnicodeBlock LATIN_EXTENDED_ADDITIONAL = new UnicodeBlock("LATIN_EXTENDED_ADDITIONAL", 0x1e00, 0x1eff);
        public static final UnicodeBlock GREEK_EXTENDED = new UnicodeBlock("GREEK_EXTENDED", 0x1f00, 0x1fff);
        public static final UnicodeBlock GENERAL_PUNCTUATION = new UnicodeBlock("GENERAL_PUNCTUATION", 0x2000, 0x206f);
        public static final UnicodeBlock SUPERSCRIPTS_AND_SUBSCRIPTS = new UnicodeBlock("SUPERSCRIPTS_AND_SUBSCRIPTS", 0x2070, 0x209f);
        public static final UnicodeBlock CURRENCY_SYMBOLS = new UnicodeBlock("CURRENCY_SYMBOLS", 0x20a0, 0x20cf);
        public static final UnicodeBlock COMBINING_MARKS_FOR_SYMBOLS = new UnicodeBlock("COMBINING_MARKS_FOR_SYMBOLS", 0x20d0, 0x20ff);
        public static final UnicodeBlock LETTERLIKE_SYMBOLS = new UnicodeBlock("LETTERLIKE_SYMBOLS", 0x2100, 0x214f);
        public static final UnicodeBlock NUMBER_FORMS = new UnicodeBlock("NUMBER_FORMS", 0x2150, 0x218f);
        public static final UnicodeBlock ARROWS = new UnicodeBlock("ARROWS", 0x2190, 0x21ff);
        public static final UnicodeBlock MATHEMATICAL_OPERATORS = new UnicodeBlock("MATHEMATICAL_OPERATORS", 0x2200, 0x22ff);
        public static final UnicodeBlock MISCELLANEOUS_TECHNICAL = new UnicodeBlock("MISCELLANEOUS_TECHNICAL", 0x2300, 0x23ff);
        public static final UnicodeBlock CONTROL_PICTURES = new UnicodeBlock("CONTROL_PICTURES", 0x2400, 0x243f);
        public static final UnicodeBlock OPTICAL_CHARACTER_RECOGNITION = new UnicodeBlock("OPTICAL_CHARACTER_RECOGNITION", 0x2440, 0x245f);
        public static final UnicodeBlock ENCLOSED_ALPHANUMERICS = new UnicodeBlock("ENCLOSED_ALPHANUMERICS", 0x2460, 0x24ff);
        public static final UnicodeBlock BOX_DRAWING = new UnicodeBlock("BOX_DRAWING", 0x2500, 0x257f);
        public static final UnicodeBlock BLOCK_ELEMENTS = new UnicodeBlock("BLOCK_ELEMENTS", 0x2580, 0x259f);
        public static final UnicodeBlock GEOMETRIC_SHAPES = new UnicodeBlock("GEOMETRIC_SHAPES", 0x25a0, 0x25ff);
        public static final UnicodeBlock MISCELLANEOUS_SYMBOLS = new UnicodeBlock("MISCELLANEOUS_SYMBOLS", 0x2600, 0x26ff);
        public static final UnicodeBlock DINGBATS = new UnicodeBlock("DINGBATS", 0x2700, 0x27bf);
        public static final UnicodeBlock MISCELLANEOUS_MATHEMATICAL_SYMBOLS_A = new UnicodeBlock("MISCELLANEOUS_MATHEMATICAL_SYMBOLS_A", 0x27c0, 0x27ef);
        public static final UnicodeBlock SUPPLEMENTAL_ARROWS_A = new UnicodeBlock("SUPPLEMENTAL_ARROWS_A", 0x27f0, 0x27ff);
        public static final UnicodeBlock BRAILLE_PATTERNS = new UnicodeBlock("BRAILLE_PATTERNS", 0x2800, 0x28ff);
        public static final UnicodeBlock SUPPLEMENTAL_ARROWS_B = new UnicodeBlock("SUPPLEMENTAL_ARROWS_B", 0x2900, 0x297f);
        public static final UnicodeBlock MISCELLANEOUS_MATHEMATICAL_SYMBOLS_B = new UnicodeBlock("MISCELLANEOUS_MATHEMATICAL_SYMBOLS_B", 0x2980, 0x29ff);
        public static final UnicodeBlock SUPPLEMENTAL_MATHEMATICAL_OPERATORS = new UnicodeBlock("SUPPLEMENTAL_MATHEMATICAL_OPERATORS", 0x2a00, 0x2aff);
        public static final UnicodeBlock MISCELLANEOUS_SYMBOLS_AND_ARROWS = new UnicodeBlock("MISCELLANEOUS_SYMBOLS_AND_ARROWS", 0x2b00, 0x2bff);
        public static final UnicodeBlock CJK_RADICALS_SUPPLEMENT = new UnicodeBlock("CJK_RADICALS_SUPPLEMENT", 0x2e80, 0x2eff);
        public static final UnicodeBlock KANGXI_RADICALS = new UnicodeBlock("KANGXI_RADICALS", 0x2f00, 0x2fdf);
        public static final UnicodeBlock IDEOGRAPHIC_DESCRIPTION_CHARACTERS = new UnicodeBlock("IDEOGRAPHIC_DESCRIPTION_CHARACTERS", 0x2ff0, 0x2fff);
        public static final UnicodeBlock CJK_SYMBOLS_AND_PUNCTUATION = new UnicodeBlock("CJK_SYMBOLS_AND_PUNCTUATION", 0x3000, 0x303f);
        public static final UnicodeBlock HIRAGANA = new UnicodeBlock("HIRAGANA", 0x3040, 0x309f);
        public static final UnicodeBlock KATAKANA = new UnicodeBlock("KATAKANA", 0x30a0, 0x30ff);
        public static final UnicodeBlock BOPOMOFO = new UnicodeBlock("BOPOMOFO", 0x3100, 0x312f);
        public static final UnicodeBlock HANGUL_COMPATIBILITY_JAMO = new UnicodeBlock("HANGUL_COMPATIBILITY_JAMO", 0x3130, 0x318f);
        public static final UnicodeBlock KANBUN = new UnicodeBlock("KANBUN", 0x3190, 0x319f);
        public static final UnicodeBlock BOPOMOFO_EXTENDED = new UnicodeBlock("BOPOMOFO_EXTENDED", 0x31a0, 0x31bf);
        public static final UnicodeBlock KATAKANA_PHONETIC_EXTENSIONS = new UnicodeBlock("KATAKANA_PHONETIC_EXTENSIONS", 0x31f0, 0x31ff);
        public static final UnicodeBlock ENCLOSED_CJK_LETTERS_AND_MONTHS = new UnicodeBlock("ENCLOSED_CJK_LETTERS_AND_MONTHS", 0x3200, 0x32ff);
        public static final UnicodeBlock CJK_COMPATIBILITY = new UnicodeBlock("CJK_COMPATIBILITY", 0x3300, 0x33ff);
        public static final UnicodeBlock CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A = new UnicodeBlock("CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A", 0x3400, 0x4dbf);
        public static final UnicodeBlock YIJING_HEXAGRAM_SYMBOLS = new UnicodeBlock("YIJING_HEXAGRAM_SYMBOLS", 0x4dc0, 0x4dff);
        public static final UnicodeBlock CJK_UNIFIED_IDEOGRAPHS = new UnicodeBlock("CJK_UNIFIED_IDEOGRAPHS", 0x4e00, 0x9fff);
        public static final UnicodeBlock YI_SYLLABLES = new UnicodeBlock("YI_SYLLABLES", 0xa000, 0xa48f);
        public static final UnicodeBlock YI_RADICALS = new UnicodeBlock("YI_RADICALS", 0xa490, 0xa4cf);
        public static final UnicodeBlock HANGUL_SYLLABLES = new UnicodeBlock("HANGUL_SYLLABLES", 0xac00, 0xd7af);
        public static final UnicodeBlock HIGH_SURROGATES = new UnicodeBlock("HIGH_SURROGATES", 0xd800, 0xdb7f);
        public static final UnicodeBlock HIGH_PRIVATE_USE_SURROGATES = new UnicodeBlock("HIGH_PRIVATE_USE_SURROGATES", 0xdb80, 0xdbff);
        public static final UnicodeBlock LOW_SURROGATES = new UnicodeBlock("LOW_SURROGATES", 0xdc00, 0xdfff);
        public static final UnicodeBlock PRIVATE_USE_AREA = new UnicodeBlock("PRIVATE_USE_AREA", 0xe000, 0xf8ff);
        public static final UnicodeBlock CJK_COMPATIBILITY_IDEOGRAPHS = new UnicodeBlock("CJK_COMPATIBILITY_IDEOGRAPHS", 0xf900, 0xfaff);
        public static final UnicodeBlock ALPHABETIC_PRESENTATION_FORMS = new UnicodeBlock("ALPHABETIC_PRESENTATION_FORMS", 0xfb00, 0xfb4f);
        public static final UnicodeBlock ARABIC_PRESENTATION_FORMS_A = new UnicodeBlock("ARABIC_PRESENTATION_FORMS_A", 0xfb50, 0xfdff);
        public static final UnicodeBlock VARIATION_SELECTORS = new UnicodeBlock("VARIATION_SELECTORS", 0xfe00, 0xfe0f);
        public static final UnicodeBlock COMBINING_HALF_MARKS = new UnicodeBlock("COMBINING_HALF_MARKS", 0xfe20, 0xfe2f);
        public static final UnicodeBlock CJK_COMPATIBILITY_FORMS = new UnicodeBlock("CJK_COMPATIBILITY_FORMS", 0xfe30, 0xfe4f);
        public static final UnicodeBlock SMALL_FORM_VARIANTS = new UnicodeBlock("SMALL_FORM_VARIANTS", 0xfe50, 0xfe6f);
        public static final UnicodeBlock ARABIC_PRESENTATION_FORMS_B = new UnicodeBlock("ARABIC_PRESENTATION_FORMS_B", 0xfe70, 0xfeff);
        public static final UnicodeBlock HALFWIDTH_AND_FULLWIDTH_FORMS = new UnicodeBlock("HALFWIDTH_AND_FULLWIDTH_FORMS", 0xff00, 0xffef);
        public static final UnicodeBlock SPECIALS = new UnicodeBlock("SPECIALS", 0xfff0, 0xffff);
        public static final UnicodeBlock LINEAR_B_SYLLABARY = new UnicodeBlock("LINEAR_B_SYLLABARY", 0x10000, 0x1007f);
        public static final UnicodeBlock LINEAR_B_IDEOGRAMS = new UnicodeBlock("LINEAR_B_IDEOGRAMS", 0x10080, 0x100ff);
        public static final UnicodeBlock AEGEAN_NUMBERS = new UnicodeBlock("AEGEAN_NUMBERS", 0x10100, 0x1013f);
        public static final UnicodeBlock OLD_ITALIC = new UnicodeBlock("OLD_ITALIC", 0x10300, 0x1032f);
        public static final UnicodeBlock GOTHIC = new UnicodeBlock("GOTHIC", 0x10330, 0x1034f);
        public static final UnicodeBlock UGARITIC = new UnicodeBlock("UGARITIC", 0x10380, 0x1039f);
        public static final UnicodeBlock DESERET = new UnicodeBlock("DESERET", 0x10400, 0x1044f);
        public static final UnicodeBlock SHAVIAN = new UnicodeBlock("SHAVIAN", 0x10450, 0x1047f);
        public static final UnicodeBlock OSMANYA = new UnicodeBlock("OSMANYA", 0x10480, 0x104af);
        public static final UnicodeBlock CYPRIOT_SYLLABARY = new UnicodeBlock("CYPRIOT_SYLLABARY", 0x10800, 0x1083f);
        public static final UnicodeBlock BYZANTINE_MUSICAL_SYMBOLS = new UnicodeBlock("BYZANTINE_MUSICAL_SYMBOLS", 0x1d000, 0x1d0ff);
        public static final UnicodeBlock MUSICAL_SYMBOLS = new UnicodeBlock("MUSICAL_SYMBOLS", 0x1d100, 0x1d1ff);
        public static final UnicodeBlock TAI_XUAN_JING_SYMBOLS = new UnicodeBlock("TAI_XUAN_JING_SYMBOLS", 0x1d300, 0x1d35f);
        public static final UnicodeBlock MATHEMATICAL_ALPHANUMERIC_SYMBOLS = new UnicodeBlock("MATHEMATICAL_ALPHANUMERIC_SYMBOLS", 0x1d400, 0x1d7ff);
        public static final UnicodeBlock CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B = new UnicodeBlock("CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B", 0x20000, 0x2a6df);
        public static final UnicodeBlock CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT = new UnicodeBlock("CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT", 0x2f800, 0x2fa1f);
        public static final UnicodeBlock TAGS = new UnicodeBlock("TAGS", 0xe0000, 0xe007f);
        public static final UnicodeBlock VARIATION_SELECTORS_SUPPLEMENT = new UnicodeBlock("VARIATION_SELECTORS_SUPPLEMENT", 0xe0100, 0xe01ef);
        public static final UnicodeBlock SUPPLEMENTARY_PRIVATE_USE_AREA_A = new UnicodeBlock("SUPPLEMENTARY_PRIVATE_USE_AREA_A", 0xf0000, 0xfffff);
        public static final UnicodeBlock SUPPLEMENTARY_PRIVATE_USE_AREA_B = new UnicodeBlock("SUPPLEMENTARY_PRIVATE_USE_AREA_B", 0x100000, 0x10ffff);
        private static UnicodeBlock[] BLOCKS = new UnicodeBlock[] {
            null,
            UnicodeBlock.BASIC_LATIN,
            UnicodeBlock.LATIN_1_SUPPLEMENT,
            UnicodeBlock.LATIN_EXTENDED_A,
            UnicodeBlock.LATIN_EXTENDED_B,
            UnicodeBlock.IPA_EXTENSIONS,
            UnicodeBlock.SPACING_MODIFIER_LETTERS,
            UnicodeBlock.COMBINING_DIACRITICAL_MARKS,
            UnicodeBlock.GREEK,
            UnicodeBlock.CYRILLIC,
            UnicodeBlock.ARMENIAN,
            UnicodeBlock.HEBREW,
            UnicodeBlock.ARABIC,
            UnicodeBlock.SYRIAC,
            UnicodeBlock.THAANA,
            UnicodeBlock.DEVANAGARI,
            UnicodeBlock.BENGALI,
            UnicodeBlock.GURMUKHI,
            UnicodeBlock.GUJARATI,
            UnicodeBlock.ORIYA,
            UnicodeBlock.TAMIL,
            UnicodeBlock.TELUGU,
            UnicodeBlock.KANNADA,
            UnicodeBlock.MALAYALAM,
            UnicodeBlock.SINHALA,
            UnicodeBlock.THAI,
            UnicodeBlock.LAO,
            UnicodeBlock.TIBETAN,
            UnicodeBlock.MYANMAR,
            UnicodeBlock.GEORGIAN,
            UnicodeBlock.HANGUL_JAMO,
            UnicodeBlock.ETHIOPIC,
            UnicodeBlock.CHEROKEE,
            UnicodeBlock.UNIFIED_CANADIAN_ABORIGINAL_SYLLABICS,
            UnicodeBlock.OGHAM,
            UnicodeBlock.RUNIC,
            UnicodeBlock.KHMER,
            UnicodeBlock.MONGOLIAN,
            UnicodeBlock.LATIN_EXTENDED_ADDITIONAL,
            UnicodeBlock.GREEK_EXTENDED,
            UnicodeBlock.GENERAL_PUNCTUATION,
            UnicodeBlock.SUPERSCRIPTS_AND_SUBSCRIPTS,
            UnicodeBlock.CURRENCY_SYMBOLS,
            UnicodeBlock.COMBINING_MARKS_FOR_SYMBOLS,
            UnicodeBlock.LETTERLIKE_SYMBOLS,
            UnicodeBlock.NUMBER_FORMS,
            UnicodeBlock.ARROWS,
            UnicodeBlock.MATHEMATICAL_OPERATORS,
            UnicodeBlock.MISCELLANEOUS_TECHNICAL,
            UnicodeBlock.CONTROL_PICTURES,
            UnicodeBlock.OPTICAL_CHARACTER_RECOGNITION,
            UnicodeBlock.ENCLOSED_ALPHANUMERICS,
            UnicodeBlock.BOX_DRAWING,
            UnicodeBlock.BLOCK_ELEMENTS,
            UnicodeBlock.GEOMETRIC_SHAPES,
            UnicodeBlock.MISCELLANEOUS_SYMBOLS,
            UnicodeBlock.DINGBATS,
            UnicodeBlock.BRAILLE_PATTERNS,
            UnicodeBlock.CJK_RADICALS_SUPPLEMENT,
            UnicodeBlock.KANGXI_RADICALS,
            UnicodeBlock.IDEOGRAPHIC_DESCRIPTION_CHARACTERS,
            UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION,
            UnicodeBlock.HIRAGANA,
            UnicodeBlock.KATAKANA,
            UnicodeBlock.BOPOMOFO,
            UnicodeBlock.HANGUL_COMPATIBILITY_JAMO,
            UnicodeBlock.KANBUN,
            UnicodeBlock.BOPOMOFO_EXTENDED,
            UnicodeBlock.ENCLOSED_CJK_LETTERS_AND_MONTHS,
            UnicodeBlock.CJK_COMPATIBILITY,
            UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A,
            UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS,
            UnicodeBlock.YI_SYLLABLES,
            UnicodeBlock.YI_RADICALS,
            UnicodeBlock.HANGUL_SYLLABLES,
            UnicodeBlock.HIGH_SURROGATES,
            UnicodeBlock.HIGH_PRIVATE_USE_SURROGATES,
            UnicodeBlock.LOW_SURROGATES,
            UnicodeBlock.PRIVATE_USE_AREA,
            UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS,
            UnicodeBlock.ALPHABETIC_PRESENTATION_FORMS,
            UnicodeBlock.ARABIC_PRESENTATION_FORMS_A,
            UnicodeBlock.COMBINING_HALF_MARKS,
            UnicodeBlock.CJK_COMPATIBILITY_FORMS,
            UnicodeBlock.SMALL_FORM_VARIANTS,
            UnicodeBlock.ARABIC_PRESENTATION_FORMS_B,
            UnicodeBlock.SPECIALS,
            UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS,
            UnicodeBlock.OLD_ITALIC,
            UnicodeBlock.GOTHIC,
            UnicodeBlock.DESERET,
            UnicodeBlock.BYZANTINE_MUSICAL_SYMBOLS,
            UnicodeBlock.MUSICAL_SYMBOLS,
            UnicodeBlock.MATHEMATICAL_ALPHANUMERIC_SYMBOLS,
            UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B,
            UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT,
            UnicodeBlock.TAGS,
            UnicodeBlock.CYRILLIC_SUPPLEMENTARY,
            UnicodeBlock.TAGALOG,
            UnicodeBlock.HANUNOO,
            UnicodeBlock.BUHID,
            UnicodeBlock.TAGBANWA,
            UnicodeBlock.MISCELLANEOUS_MATHEMATICAL_SYMBOLS_A,
            UnicodeBlock.SUPPLEMENTAL_ARROWS_A,
            UnicodeBlock.SUPPLEMENTAL_ARROWS_B,
            UnicodeBlock.MISCELLANEOUS_MATHEMATICAL_SYMBOLS_B,
            UnicodeBlock.SUPPLEMENTAL_MATHEMATICAL_OPERATORS,
            UnicodeBlock.KATAKANA_PHONETIC_EXTENSIONS,
            UnicodeBlock.VARIATION_SELECTORS,
            UnicodeBlock.SUPPLEMENTARY_PRIVATE_USE_AREA_A,
            UnicodeBlock.SUPPLEMENTARY_PRIVATE_USE_AREA_B,
            UnicodeBlock.LIMBU,
            UnicodeBlock.TAI_LE,
            UnicodeBlock.KHMER_SYMBOLS,
            UnicodeBlock.PHONETIC_EXTENSIONS,
            UnicodeBlock.MISCELLANEOUS_SYMBOLS_AND_ARROWS,
            UnicodeBlock.YIJING_HEXAGRAM_SYMBOLS,
            UnicodeBlock.LINEAR_B_SYLLABARY,
            UnicodeBlock.LINEAR_B_IDEOGRAMS,
            UnicodeBlock.AEGEAN_NUMBERS,
            UnicodeBlock.UGARITIC,
            UnicodeBlock.SHAVIAN,
            UnicodeBlock.OSMANYA,
            UnicodeBlock.CYPRIOT_SYLLABARY,
            UnicodeBlock.TAI_XUAN_JING_SYMBOLS,
            UnicodeBlock.VARIATION_SELECTORS_SUPPLEMENT
        };
    }


    
    private static final long serialVersionUID = 3786198910865385080L;
    public static final char MIN_VALUE = '\u0000';
    public static final char MAX_VALUE = '\uffff';
    public static final int MIN_RADIX = 2;
    public static final int MAX_RADIX = 36;
    @SuppressWarnings("unchecked") public static final Class<Character> TYPE
            = (Class<Character>) char[].class.getComponentType();
    public static final byte UNASSIGNED = 0;
    public static final byte UPPERCASE_LETTER = 1;
    public static final byte LOWERCASE_LETTER = 2;
    public static final byte TITLECASE_LETTER = 3;
    public static final byte MODIFIER_LETTER = 4;
    public static final byte OTHER_LETTER = 5;
    public static final byte NON_SPACING_MARK = 6;
    public static final byte ENCLOSING_MARK = 7;
    public static final byte COMBINING_SPACING_MARK = 8;
    public static final byte DECIMAL_DIGIT_NUMBER = 9;
    public static final byte LETTER_NUMBER = 10;
    public static final byte OTHER_NUMBER = 11;
    public static final byte SPACE_SEPARATOR = 12;
    public static final byte LINE_SEPARATOR = 13;
    public static final byte PARAGRAPH_SEPARATOR = 14;
    public static final byte CONTROL = 15;
    public static final byte FORMAT = 16;
    public static final byte PRIVATE_USE = 18;
    public static final byte SURROGATE = 19;
    public static final byte DASH_PUNCTUATION = 20;
    public static final byte START_PUNCTUATION = 21;
    public static final byte END_PUNCTUATION = 22;
    public static final byte CONNECTOR_PUNCTUATION = 23;
    public static final byte OTHER_PUNCTUATION = 24;
    public static final byte MATH_SYMBOL = 25;
    public static final byte CURRENCY_SYMBOL = 26;
    public static final byte MODIFIER_SYMBOL = 27;
    public static final byte OTHER_SYMBOL = 28;
    public static final byte INITIAL_QUOTE_PUNCTUATION = 29;
    public static final byte FINAL_QUOTE_PUNCTUATION = 30;
    public static final byte DIRECTIONALITY_UNDEFINED = -1;
    public static final byte DIRECTIONALITY_LEFT_TO_RIGHT = 0;
    public static final byte DIRECTIONALITY_RIGHT_TO_LEFT = 1;
    public static final byte DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC = 2;
    public static final byte DIRECTIONALITY_EUROPEAN_NUMBER = 3;
    public static final byte DIRECTIONALITY_EUROPEAN_NUMBER_SEPARATOR = 4;
    public static final byte DIRECTIONALITY_EUROPEAN_NUMBER_TERMINATOR = 5;
    public static final byte DIRECTIONALITY_ARABIC_NUMBER = 6;
    public static final byte DIRECTIONALITY_COMMON_NUMBER_SEPARATOR = 7;
    public static final byte DIRECTIONALITY_NONSPACING_MARK = 8;
    public static final byte DIRECTIONALITY_BOUNDARY_NEUTRAL = 9;
    public static final byte DIRECTIONALITY_PARAGRAPH_SEPARATOR = 10;
    public static final byte DIRECTIONALITY_SEGMENT_SEPARATOR = 11;
    public static final byte DIRECTIONALITY_WHITESPACE = 12;
    public static final byte DIRECTIONALITY_OTHER_NEUTRALS = 13;
    public static final byte DIRECTIONALITY_LEFT_TO_RIGHT_EMBEDDING = 14;
    public static final byte DIRECTIONALITY_LEFT_TO_RIGHT_OVERRIDE = 15;
    public static final byte DIRECTIONALITY_RIGHT_TO_LEFT_EMBEDDING = 16;
    public static final byte DIRECTIONALITY_RIGHT_TO_LEFT_OVERRIDE = 17;
    public static final byte DIRECTIONALITY_POP_DIRECTIONAL_FORMAT = 18;
    public static final char MIN_HIGH_SURROGATE = '\uD800';
    public static final char MAX_HIGH_SURROGATE = '\uDBFF';
    public static final char MIN_LOW_SURROGATE = '\uDC00';
    public static final char MAX_LOW_SURROGATE = '\uDFFF';
    public static final char MIN_SURROGATE = '\uD800';
    public static final char MAX_SURROGATE = '\uDFFF';
    public static final int MIN_SUPPLEMENTARY_CODE_POINT = 0x10000;
    public static final int MIN_CODE_POINT = 0x000000;
    public static final int MAX_CODE_POINT = 0x10FFFF;
    public static final int SIZE = 16;
    private static final byte[] DIRECTIONALITY = new byte[] {
            DIRECTIONALITY_LEFT_TO_RIGHT, DIRECTIONALITY_RIGHT_TO_LEFT,
            DIRECTIONALITY_EUROPEAN_NUMBER,
            DIRECTIONALITY_EUROPEAN_NUMBER_SEPARATOR,
            DIRECTIONALITY_EUROPEAN_NUMBER_TERMINATOR,
            DIRECTIONALITY_ARABIC_NUMBER,
            DIRECTIONALITY_COMMON_NUMBER_SEPARATOR,
            DIRECTIONALITY_PARAGRAPH_SEPARATOR,
            DIRECTIONALITY_SEGMENT_SEPARATOR, DIRECTIONALITY_WHITESPACE,
            DIRECTIONALITY_OTHER_NEUTRALS,
            DIRECTIONALITY_LEFT_TO_RIGHT_EMBEDDING,
            DIRECTIONALITY_LEFT_TO_RIGHT_OVERRIDE,
            DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC,
            DIRECTIONALITY_RIGHT_TO_LEFT_EMBEDDING,
            DIRECTIONALITY_RIGHT_TO_LEFT_OVERRIDE,
            DIRECTIONALITY_POP_DIRECTIONAL_FORMAT,
            DIRECTIONALITY_NONSPACING_MARK, DIRECTIONALITY_BOUNDARY_NEUTRAL };
    private static final Character[] SMALL_VALUES = new Character[128];
    static {
        for (int i = 0; i < 128; i++) {
            SMALL_VALUES[i] = new Character((char) i);
        }
    }
    
}

