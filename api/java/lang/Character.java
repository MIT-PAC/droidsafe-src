package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.Serializable;
import java.util.Arrays;

public final class Character implements Serializable, Comparable<Character> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.395 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "747ED88C4962B4F2D5A7D8AD1452F805")

    private char value;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.395 -0400", hash_original_method = "8DEFF913326DC7F74512EFD131579B65", hash_generated_method = "1645DDBBE78063D348F5E0EDDC7FC72B")
    public  Character(char value) {
        this.value = value;
        // ---------- Original Method ----------
        //this.value = value;
    }

    
    @DSModeled(DSC.SAFE)
    private static int forNameImpl(String blockName) {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1915900274 = DSUtils.UNKNOWN_INT;
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1915900274;
	}

    
    @DSModeled(DSC.SAFE)
    private static int ofImpl(int codePoint) {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_771157942 = DSUtils.UNKNOWN_INT;
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_771157942;
	}

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.395 -0400", hash_original_method = "1972D57F3C05C7BADF696B9ADC3E34F9", hash_generated_method = "4D0E35994CC22D2A21A3D160EC7CB8A5")
    public char charValue() {
        char var2063C1608D6E0BAF80249C42E2BE5804_1070323718 = (value);
                char varA87DEB01C5F539E6BDA34829C8EF2368_1869496205 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1869496205;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSModeled(DSC.SAFE)
    private static void checkValidCodePoint(int codePoint) {
        if (!isValidCodePoint(codePoint)) {
            throw new IllegalArgumentException("Invalid code point: " + codePoint);
        }
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.395 -0400", hash_original_method = "3BC38476D10A0BB1E7E9CABDBB184EDE", hash_generated_method = "91FE7DCC9A11401F23BBCCE7F8800563")
    public int compareTo(Character c) {
        addTaint(c.getTaint());
        int var6C2308B5D99F89BD1A70B3C6D6BC7C64_293505810 = (compare(value, c.value));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1121536932 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1121536932;
        // ---------- Original Method ----------
        //return compare(value, c.value);
    }

    
    @DSModeled(DSC.SAFE)
    public static int compare(char lhs, char rhs) {
        return lhs - rhs;
    }

    
    @DSModeled(DSC.SAFE)
    public static Character valueOf(char c) {
        return c < 128 ? SMALL_VALUES[c] : new Character(c);
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isValidCodePoint(int codePoint) {
        return (MIN_CODE_POINT <= codePoint && MAX_CODE_POINT >= codePoint);
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isSupplementaryCodePoint(int codePoint) {
        return (MIN_SUPPLEMENTARY_CODE_POINT <= codePoint && MAX_CODE_POINT >= codePoint);
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isHighSurrogate(char ch) {
        return (MIN_HIGH_SURROGATE <= ch && MAX_HIGH_SURROGATE >= ch);
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isLowSurrogate(char ch) {
        return (MIN_LOW_SURROGATE <= ch && MAX_LOW_SURROGATE >= ch);
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isSurrogate(char ch) {
        return ch >= MIN_SURROGATE && ch <= MAX_SURROGATE;
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isSurrogatePair(char high, char low) {
        return (isHighSurrogate(high) && isLowSurrogate(low));
    }

    
    @DSModeled(DSC.SAFE)
    public static int charCount(int codePoint) {
        return (codePoint >= 0x10000 ? 2 : 1);
    }

    
    @DSModeled(DSC.SAFE)
    public static int toCodePoint(char high, char low) {
        int h = (high & 0x3FF) << 10;
        int l = low & 0x3FF;
        return (h | l) + 0x10000;
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static int digit(char c, int radix) {
        return digit((int) c, radix);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    private static int digitImpl(int codePoint, int radix) {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_350347683 = DSUtils.UNKNOWN_INT;
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_350347683;
	}

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.398 -0400", hash_original_method = "88215BA2DAA464AB2808512F13A48003", hash_generated_method = "6FA1FC4FFD683B18B4EE1A8D3463A05D")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
        boolean var5573357C3C07CA4D2EF38248668F486D_1928908685 = ((object instanceof Character) && (((Character) object).value == value));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_882183826 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_882183826;
        // ---------- Original Method ----------
        //return (object instanceof Character) && (((Character) object).value == value);
    }

    
    @DSModeled(DSC.SAFE)
    public static char forDigit(int digit, int radix) {
        if (MIN_RADIX <= radix && radix <= MAX_RADIX) {
            if (digit >= 0 && digit < radix) {
                return (char) (digit < 10 ? digit + '0' : digit + 'a' - 10);
            }
        }
        return 0;
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    private static String getNameImpl(int codePoint) {
		return new String();
	}

    
    @DSModeled(DSC.SAFE)
    public static int getNumericValue(char c) {
        return getNumericValue((int) c);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    private static int getNumericValueImpl(int codePoint) {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_154176117 = DSUtils.UNKNOWN_INT;
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_154176117;
	}

    
    @DSModeled(DSC.SAFE)
    public static int getType(char c) {
        return getType((int) c);
    }

    
    @DSModeled(DSC.SAFE)
    public static int getType(int codePoint) {
        int type = getTypeImpl(codePoint);
        if (type <= Character.FORMAT) {
            return type;
        }
        return (type + 1);
    }

    
    @DSModeled(DSC.SAFE)
    private static int getTypeImpl(int codePoint) {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_750496757 = DSUtils.UNKNOWN_INT;
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_750496757;
	}

    
    @DSModeled(DSC.SAFE)
    public static byte getDirectionality(char c) {
        return getDirectionality((int)c);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    private static byte getDirectionalityImpl(int codePoint) {
		byte var40EA57D3EE3C07BF1C102B466E1C3091_330183665 = DSUtils.UNKNOWN_BYTE;
		return var40EA57D3EE3C07BF1C102B466E1C3091_330183665;
	}

    
    @DSModeled(DSC.SAFE)
    public static boolean isMirrored(char c) {
        return isMirrored((int) c);
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isMirrored(int codePoint) {
        return isMirroredImpl(codePoint);
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean isMirroredImpl(int codePoint) {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1579042988 = DSUtils.UNKNOWN_BOOLEAN;
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_1579042988;
	}

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.399 -0400", hash_original_method = "961F210287166DF05D8915D632129E75", hash_generated_method = "EEFED4963DCE60AF1955D2E436223C8A")
    @Override
    public int hashCode() {
        int var2063C1608D6E0BAF80249C42E2BE5804_881277847 = (value);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1322765793 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1322765793;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSModeled(DSC.SAFE)
    public static char highSurrogate(int codePoint) {
        return (char) ((codePoint >> 10) + 0xd7c0);
    }

    
    @DSModeled(DSC.SAFE)
    public static char lowSurrogate(int codePoint) {
        return (char) ((codePoint & 0x3ff) | 0xdc00);
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isBmpCodePoint(int codePoint) {
        return codePoint >= 0 && codePoint <= 0xffff;
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isDefined(char c) {
        return isDefinedImpl(c);
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isDefined(int codePoint) {
        return isDefinedImpl(codePoint);
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean isDefinedImpl(int codePoint) {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1918835177 = DSUtils.UNKNOWN_BOOLEAN;
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_1918835177;
	}

    
    @DSModeled(DSC.SAFE)
    public static boolean isDigit(char c) {
        return isDigit((int) c);
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isDigit(int codePoint) {
        if ('0' <= codePoint && codePoint <= '9') {
            return true;
        }
        if (codePoint < 1632) {
            return false;
        }
        return isDigitImpl(codePoint);
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean isDigitImpl(int codePoint) {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_79933192 = DSUtils.UNKNOWN_BOOLEAN;
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_79933192;
	}

    
    @DSModeled(DSC.SAFE)
    public static boolean isIdentifierIgnorable(char c) {
        return isIdentifierIgnorable((int) c);
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isIdentifierIgnorable(int codePoint) {
        if (codePoint < 0x600) {
            return (codePoint >= 0 && codePoint <= 8) || (codePoint >= 0xe && codePoint <= 0x1b) ||
                    (codePoint >= 0x7f && codePoint <= 0x9f) || (codePoint == 0xad);
        }
        return isIdentifierIgnorableImpl(codePoint);
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean isIdentifierIgnorableImpl(int codePoint) {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_370417676 = DSUtils.UNKNOWN_BOOLEAN;
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_370417676;
	}

    
    @DSModeled(DSC.SAFE)
    public static boolean isISOControl(char c) {
        return isISOControl((int) c);
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isISOControl(int c) {
        return (c >= 0 && c <= 0x1f) || (c >= 0x7f && c <= 0x9f);
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isJavaIdentifierPart(char c) {
        return isJavaIdentifierPart((int) c);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static boolean isJavaIdentifierStart(char c) {
        return isJavaIdentifierStart((int) c);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @Deprecated
    public static boolean isJavaLetter(char c) {
        return isJavaIdentifierStart(c);
    }

    
    @DSModeled(DSC.SAFE)
    @Deprecated
    public static boolean isJavaLetterOrDigit(char c) {
        return isJavaIdentifierPart(c);
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isLetter(char c) {
        return isLetter((int) c);
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isLetter(int codePoint) {
        if (('A' <= codePoint && codePoint <= 'Z') || ('a' <= codePoint && codePoint <= 'z')) {
            return true;
        }
        if (codePoint < 128) {
            return false;
        }
        return isLetterImpl(codePoint);
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean isLetterImpl(int codePoint) {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1317859906 = DSUtils.UNKNOWN_BOOLEAN;
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_1317859906;
	}

    
    @DSModeled(DSC.SAFE)
    public static boolean isLetterOrDigit(char c) {
        return isLetterOrDigit((int) c);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    private static boolean isLetterOrDigitImpl(int codePoint) {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_331892654 = DSUtils.UNKNOWN_BOOLEAN;
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_331892654;
	}

    
    @DSModeled(DSC.SAFE)
    public static boolean isLowerCase(char c) {
        return isLowerCase((int) c);
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isLowerCase(int codePoint) {
        if ('a' <= codePoint && codePoint <= 'z') {
            return true;
        }
        if (codePoint < 128) {
            return false;
        }
        return isLowerCaseImpl(codePoint);
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean isLowerCaseImpl(int codePoint) {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1079247224 = DSUtils.UNKNOWN_BOOLEAN;
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_1079247224;
	}

    
    @DSModeled(DSC.SAFE)
    @Deprecated
    public static boolean isSpace(char c) {
        return c == '\n' || c == '\t' || c == '\f' || c == '\r' || c == ' ';
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isSpaceChar(char c) {
        return isSpaceChar((int) c);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    private static boolean isSpaceCharImpl(int codePoint) {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_684024122 = DSUtils.UNKNOWN_BOOLEAN;
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_684024122;
	}

    
    @DSModeled(DSC.SAFE)
    public static boolean isTitleCase(char c) {
        return isTitleCaseImpl(c);
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isTitleCase(int codePoint) {
        return isTitleCaseImpl(codePoint);
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean isTitleCaseImpl(int codePoint) {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1687158249 = DSUtils.UNKNOWN_BOOLEAN;
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_1687158249;
	}

    
    @DSModeled(DSC.SAFE)
    public static boolean isUnicodeIdentifierPart(char c) {
        return isUnicodeIdentifierPartImpl(c);
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isUnicodeIdentifierPart(int codePoint) {
        return isUnicodeIdentifierPartImpl(codePoint);
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean isUnicodeIdentifierPartImpl(int codePoint) {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1167587608 = DSUtils.UNKNOWN_BOOLEAN;
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_1167587608;
	}

    
    @DSModeled(DSC.SAFE)
    public static boolean isUnicodeIdentifierStart(char c) {
        return isUnicodeIdentifierStartImpl(c);
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isUnicodeIdentifierStart(int codePoint) {
        return isUnicodeIdentifierStartImpl(codePoint);
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean isUnicodeIdentifierStartImpl(int codePoint) {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_389180321 = DSUtils.UNKNOWN_BOOLEAN;
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_389180321;
	}

    
    @DSModeled(DSC.SAFE)
    public static boolean isUpperCase(char c) {
        return isUpperCase((int) c);
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isUpperCase(int codePoint) {
        if ('A' <= codePoint && codePoint <= 'Z') {
            return true;
        }
        if (codePoint < 128) {
            return false;
        }
        return isUpperCaseImpl(codePoint);
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean isUpperCaseImpl(int codePoint) {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1247968420 = DSUtils.UNKNOWN_BOOLEAN;
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_1247968420;
	}

    
    @DSModeled(DSC.SAFE)
    public static boolean isWhitespace(char c) {
        return isWhitespace((int) c);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    private static boolean isWhitespaceImpl(int codePoint) {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1925136494 = DSUtils.UNKNOWN_BOOLEAN;
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_1925136494;
	}

    
    @DSModeled(DSC.SAFE)
    public static char reverseBytes(char c) {
        return (char)((c<<8) | (c>>8));
    }

    
    @DSModeled(DSC.SAFE)
    public static char toLowerCase(char c) {
        return (char) toLowerCase((int) c);
    }

    
    @DSModeled(DSC.SAFE)
    public static int toLowerCase(int codePoint) {
        if ('A' <= codePoint && codePoint <= 'Z') {
            return (char) (codePoint + ('a' - 'A'));
        }
        if (codePoint < 192) {
            return codePoint;
        }
        return toLowerCaseImpl(codePoint);
    }

    
    @DSModeled(DSC.SAFE)
    private static int toLowerCaseImpl(int codePoint) {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_257147218 = DSUtils.UNKNOWN_INT;
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_257147218;
	}

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.414 -0400", hash_original_method = "27F3E47E60B1213ECE72A0C1452319D1", hash_generated_method = "B03AABF3E3164B627A3D5393572FE570")
    @Override
    public String toString() {
String varE1C269B12AA3B951D8A9B8058A1CED16_936961933 =         String.valueOf(value);
        varE1C269B12AA3B951D8A9B8058A1CED16_936961933.addTaint(taint);
        return varE1C269B12AA3B951D8A9B8058A1CED16_936961933;
        // ---------- Original Method ----------
        //return String.valueOf(value);
    }

    
    @DSModeled(DSC.SAFE)
    public static String toString(char value) {
        return String.valueOf(value);
    }

    
    @DSModeled(DSC.SAFE)
    public static char toTitleCase(char c) {
        return (char) toTitleCaseImpl(c);
    }

    
    @DSModeled(DSC.SAFE)
    public static int toTitleCase(int codePoint) {
        return toTitleCaseImpl(codePoint);
    }

    
    @DSModeled(DSC.SAFE)
    private static int toTitleCaseImpl(int codePoint) {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1465695862 = DSUtils.UNKNOWN_INT;
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1465695862;
	}

    
    @DSModeled(DSC.SAFE)
    public static char toUpperCase(char c) {
        return (char) toUpperCase((int) c);
    }

    
    @DSModeled(DSC.SAFE)
    public static int toUpperCase(int codePoint) {
        if ('a' <= codePoint && codePoint <= 'z') {
            return (char) (codePoint - ('a' - 'A'));
        }
        if (codePoint < 181) {
            return codePoint;
        }
        return toUpperCaseImpl(codePoint);
    }

    
    @DSModeled(DSC.SAFE)
    private static int toUpperCaseImpl(int codePoint) {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1328761199 = DSUtils.UNKNOWN_INT;
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1328761199;
	}

    
    public static class Subset {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.414 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "BF45F7481B8091DE3CBF80E94F7F940B")

        String name;
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.416 -0400", hash_original_method = "F864A542FCD1C844E1D83841069C7DB4", hash_generated_method = "EE88F1B3BA6EDC9CD7CA2183AF805F1D")
        protected  Subset(String string) {
            if(string == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_329546435 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_329546435.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_329546435;
            } //End block
            name = string;
            // ---------- Original Method ----------
            //if (string == null) {
                //throw new NullPointerException();
            //}
            //name = string;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.417 -0400", hash_original_method = "4C72D63DD7600BBEA68526CF4A3E7570", hash_generated_method = "E4FD41B188BEF0EE4143B1C95AD91D70")
        @Override
        public final boolean equals(Object object) {
            addTaint(object.getTaint());
            boolean var75EAEC12DA10D524D5BB1C4333283B8A_1102895051 = (super.equals(object));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_122557771 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_122557771;
            // ---------- Original Method ----------
            //return super.equals(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.417 -0400", hash_original_method = "BBCDAD7BF06FB621822DBBAD11355700", hash_generated_method = "80460BB5B4BAF1B6A0B4961E514738A8")
        @Override
        public final int hashCode() {
            int var805ED14872F1C08E5C4314680FD405F0_1360295034 = (super.hashCode());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1032249059 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1032249059;
            // ---------- Original Method ----------
            //return super.hashCode();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.417 -0400", hash_original_method = "0EB66BA5E965B83E191719250E0A82FF", hash_generated_method = "BA7419FA7B44CF05E0F627BFAB48392A")
        @Override
        public final String toString() {
String varB017984728AC60AD1F0BF8734F33F15C_935948158 =             name;
            varB017984728AC60AD1F0BF8734F33F15C_935948158.addTaint(taint);
            return varB017984728AC60AD1F0BF8734F33F15C_935948158;
            // ---------- Original Method ----------
            //return name;
        }

        
    }


    
    public static final class UnicodeBlock extends Subset {
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.421 -0400", hash_original_method = "234E88093AAFC12110C9FE35072443BD", hash_generated_method = "4B1FCCF606CEF9910A2C98FAAC82908F")
        private  UnicodeBlock(String blockName, int start, int end) {
            super(blockName);
            addTaint(end);
            addTaint(start);
            addTaint(blockName.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.SAFE)
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

        
        @DSModeled(DSC.SAFE)
        public static UnicodeBlock of(char c) {
            return of((int) c);
        }

        
        @DSModeled(DSC.SAFE)
        public static UnicodeBlock of(int codePoint) {
            checkValidCodePoint(codePoint);
            int block = ofImpl(codePoint);
            if (block == -1 || block >= BLOCKS.length) {
                return null;
            }
            return BLOCKS[block];
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.422 -0400", hash_original_field = "105E8CE6015CF6C42A8DD210AC78FC49", hash_generated_field = "0470A3C22253E9E004DE810D1786EC8B")

        @Deprecated
        public static final UnicodeBlock SURROGATES_AREA = new UnicodeBlock("SURROGATES_AREA", 0x0, 0x0);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.422 -0400", hash_original_field = "5DB8EC6E207DD287059F1988E69175AB", hash_generated_field = "A5313206D56111DCAE3B6A137CA79034")

        public static final UnicodeBlock BASIC_LATIN = new UnicodeBlock("BASIC_LATIN", 0x0, 0x7f);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.422 -0400", hash_original_field = "5CEC4F3EED4E2FF10DA093B264A33FA1", hash_generated_field = "7B47538BF6E9E67889A7D6B77AA31E8C")

        public static final UnicodeBlock LATIN_1_SUPPLEMENT = new UnicodeBlock("LATIN_1_SUPPLEMENT", 0x80, 0xff);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.422 -0400", hash_original_field = "40E92EAF09C0E279813096AD51E169F3", hash_generated_field = "E49B53383948DEAF11DA3E7277D77ECE")

        public static final UnicodeBlock LATIN_EXTENDED_A = new UnicodeBlock("LATIN_EXTENDED_A", 0x100, 0x17f);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.422 -0400", hash_original_field = "67BD0C1F501FFCCB0E90D2D10A85DAA8", hash_generated_field = "DA2D6DEC1DEA2E4B9A6E63E3EDEDB775")

        public static final UnicodeBlock LATIN_EXTENDED_B = new UnicodeBlock("LATIN_EXTENDED_B", 0x180, 0x24f);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.423 -0400", hash_original_field = "2DE37806A66B0EF8547714DD00C99EEB", hash_generated_field = "CD1F323507B01EFC6A183BD020ED4A00")

        public static final UnicodeBlock IPA_EXTENSIONS = new UnicodeBlock("IPA_EXTENSIONS", 0x250, 0x2af);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.423 -0400", hash_original_field = "5CF65DA8F9B2724E6F4DD9BD347EDBC6", hash_generated_field = "4784277FA769D983DF3754CD66F93762")

        public static final UnicodeBlock SPACING_MODIFIER_LETTERS = new UnicodeBlock("SPACING_MODIFIER_LETTERS", 0x2b0, 0x2ff);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.423 -0400", hash_original_field = "626017BE11113B668F0A509C46F113ED", hash_generated_field = "8143A29B11F459536D30C03F0BDDF3CB")

        public static final UnicodeBlock COMBINING_DIACRITICAL_MARKS = new UnicodeBlock("COMBINING_DIACRITICAL_MARKS", 0x300, 0x36f);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.423 -0400", hash_original_field = "229C4C9991998CC6425E543BC11BA238", hash_generated_field = "7F378156781098B9F68CDDFA37AD00A4")

        public static final UnicodeBlock GREEK = new UnicodeBlock("GREEK", 0x370, 0x3ff);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.423 -0400", hash_original_field = "A347CE0F337528A5763954B6092B5716", hash_generated_field = "7B7443CE075ED31D63E83384BFAFFA44")

        public static final UnicodeBlock CYRILLIC = new UnicodeBlock("CYRILLIC", 0x400, 0x4ff);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.423 -0400", hash_original_field = "7F77F46416320E6868D2DFC814BE9584", hash_generated_field = "065B53E349ECF09B96A9DB74C1F11EF9")

        public static final UnicodeBlock CYRILLIC_SUPPLEMENTARY = new UnicodeBlock("CYRILLIC_SUPPLEMENTARY", 0x500, 0x52f);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.423 -0400", hash_original_field = "F9EE52C98AECC47EDFB2A06707EACECD", hash_generated_field = "796694AF8BCDF64956A3727B538B251C")

        public static final UnicodeBlock ARMENIAN = new UnicodeBlock("ARMENIAN", 0x530, 0x58f);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.423 -0400", hash_original_field = "288AC451D965C86788CC1B981A3C85CD", hash_generated_field = "8B915958210665AA79002514B914A888")

        public static final UnicodeBlock HEBREW = new UnicodeBlock("HEBREW", 0x590, 0x5ff);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.423 -0400", hash_original_field = "261F418BB24FF3940F983AF18918398A", hash_generated_field = "DDD0C0246AC273698FD0F7612C4AEDCF")

        public static final UnicodeBlock ARABIC = new UnicodeBlock("ARABIC", 0x600, 0x6ff);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.423 -0400", hash_original_field = "4986AEC52844BFABF96F1B4C7DEEF214", hash_generated_field = "B16E462F6087563842BB54CECEC23447")

        public static final UnicodeBlock SYRIAC = new UnicodeBlock("SYRIAC", 0x700, 0x74f);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.423 -0400", hash_original_field = "583A69325A9F175CF4A4CF5A3C3A2A2F", hash_generated_field = "50D61AE11094986F4623FD73E93F2F55")

        public static final UnicodeBlock THAANA = new UnicodeBlock("THAANA", 0x780, 0x7bf);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.423 -0400", hash_original_field = "81B0FF8112CA31F807F19ADFC77D5108", hash_generated_field = "91347602C02BD4588EE4F49FEFFF9895")

        public static final UnicodeBlock DEVANAGARI = new UnicodeBlock("DEVANAGARI", 0x900, 0x97f);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.423 -0400", hash_original_field = "6973FB3C945B0FC9F7D806798FCC0388", hash_generated_field = "AD3C7E6337036148EFA962E744A18963")

        public static final UnicodeBlock BENGALI = new UnicodeBlock("BENGALI", 0x980, 0x9ff);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.423 -0400", hash_original_field = "51441269C29BB7BFE70588C97B5C99D0", hash_generated_field = "F41B56B20EB532E62F94FBBF2D5E1B67")

        public static final UnicodeBlock GURMUKHI = new UnicodeBlock("GURMUKHI", 0xa00, 0xa7f);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.423 -0400", hash_original_field = "CE3396EAECC4042921A3FBBE705EDA1A", hash_generated_field = "6102B37503E241C438DB976AB8333067")

        public static final UnicodeBlock GUJARATI = new UnicodeBlock("GUJARATI", 0xa80, 0xaff);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.423 -0400", hash_original_field = "04C3BD6D7B156B7131FF2943A9076800", hash_generated_field = "33DA9652CF96E4BFCFD097F56F775C29")

        public static final UnicodeBlock ORIYA = new UnicodeBlock("ORIYA", 0xb00, 0xb7f);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.423 -0400", hash_original_field = "D547D014A3317CC1804EC7A6E492EAAF", hash_generated_field = "C211160BBB1A56F2C35293F1CF115849")

        public static final UnicodeBlock TAMIL = new UnicodeBlock("TAMIL", 0xb80, 0xbff);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.423 -0400", hash_original_field = "D231261857E74B8B9546AD13C3426AAB", hash_generated_field = "64AA21DEC39F50CFEB837EAC9E12D288")

        public static final UnicodeBlock TELUGU = new UnicodeBlock("TELUGU", 0xc00, 0xc7f);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.423 -0400", hash_original_field = "68D85386BA12983B87F9FF103ABDCFE6", hash_generated_field = "4A208BF6450296A4EEAD5FBE71EC0CD7")

        public static final UnicodeBlock KANNADA = new UnicodeBlock("KANNADA", 0xc80, 0xcff);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.423 -0400", hash_original_field = "3F77F05D06B593B47D54A145ED135B96", hash_generated_field = "4209D83E5C17DE51D8F05557D64B2750")

        public static final UnicodeBlock MALAYALAM = new UnicodeBlock("MALAYALAM", 0xd00, 0xd7f);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.423 -0400", hash_original_field = "9D5B7716D21E240DFA9C33D7012E88F6", hash_generated_field = "C74AE8B604CFF4DE242D3C75CFAB9EA0")

        public static final UnicodeBlock SINHALA = new UnicodeBlock("SINHALA", 0xd80, 0xdff);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.423 -0400", hash_original_field = "A772D7C3C1D828C057FDA9471BC6A9C0", hash_generated_field = "E06B4D150C06D3746D814B80153EE836")

        public static final UnicodeBlock THAI = new UnicodeBlock("THAI", 0xe00, 0xe7f);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.423 -0400", hash_original_field = "06BEA28D05A96892A51F852E8CB0D494", hash_generated_field = "EC53474B7C536DAD8961DABF19D07ACE")

        public static final UnicodeBlock LAO = new UnicodeBlock("LAO", 0xe80, 0xeff);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.423 -0400", hash_original_field = "95679314EDC7AA840A3F87F100BE9581", hash_generated_field = "2B2DBD179F7CBC78FB985454914CE639")

        public static final UnicodeBlock TIBETAN = new UnicodeBlock("TIBETAN", 0xf00, 0xfff);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.423 -0400", hash_original_field = "DD857546D6B5BAAAE4ECBE471D4A9997", hash_generated_field = "AAFFC1959CF1CFA1FB24BA8C87B64447")

        public static final UnicodeBlock MYANMAR = new UnicodeBlock("MYANMAR", 0x1000, 0x109f);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.423 -0400", hash_original_field = "F3ECCBBD42EA04BC32F5364BAB6B470E", hash_generated_field = "323ADE8903669DE5F4AE54F0C5F33FED")

        public static final UnicodeBlock GEORGIAN = new UnicodeBlock("GEORGIAN", 0x10a0, 0x10ff);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.423 -0400", hash_original_field = "9634254B118AC85BB167F01426F9732A", hash_generated_field = "C80F3E9E83ABDD4F62AB0DFE52FFB927")

        public static final UnicodeBlock HANGUL_JAMO = new UnicodeBlock("HANGUL_JAMO", 0x1100, 0x11ff);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.423 -0400", hash_original_field = "DDD78BF02E473DC5AE41234A2E7FE7B2", hash_generated_field = "E244B68CDBA950D32DACA086817A2D04")

        public static final UnicodeBlock ETHIOPIC = new UnicodeBlock("ETHIOPIC", 0x1200, 0x137f);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.423 -0400", hash_original_field = "3A6E32D415DEF9587549B2EE9E2EE378", hash_generated_field = "A6A5840DA9DD74900C1AD732A1E62B63")

        public static final UnicodeBlock CHEROKEE = new UnicodeBlock("CHEROKEE", 0x13a0, 0x13ff);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.423 -0400", hash_original_field = "6E967F82B8CCCEB98212F282A7BABCD5", hash_generated_field = "E0CBF79F089077E32A85232A2FC67E19")

        public static final UnicodeBlock UNIFIED_CANADIAN_ABORIGINAL_SYLLABICS = new UnicodeBlock("UNIFIED_CANADIAN_ABORIGINAL_SYLLABICS", 0x1400, 0x167f);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.424 -0400", hash_original_field = "46CF883171203BC7BF7A2887DCC3E0F0", hash_generated_field = "C449B362B0AA0B54D65B6F77E6FE7983")

        public static final UnicodeBlock OGHAM = new UnicodeBlock("OGHAM", 0x1680, 0x169f);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.424 -0400", hash_original_field = "953D688587489BA5D04AB0A5891DFB76", hash_generated_field = "E45768F5943B63B70D37AF473FFB00B8")

        public static final UnicodeBlock RUNIC = new UnicodeBlock("RUNIC", 0x16a0, 0x16ff);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.424 -0400", hash_original_field = "AB088DE3EF417866B6888543B9FC6E93", hash_generated_field = "E9ED1DEEF6505F35BD5A9A460E231FA9")

        public static final UnicodeBlock TAGALOG = new UnicodeBlock("TAGALOG", 0x1700, 0x171f);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.424 -0400", hash_original_field = "3FDDDDD794906824D859ECB916D001F9", hash_generated_field = "828F7A62898EB49785402F90F010744D")

        public static final UnicodeBlock HANUNOO = new UnicodeBlock("HANUNOO", 0x1720, 0x173f);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.424 -0400", hash_original_field = "78AA1E144EBD481D006565A6F708D5B3", hash_generated_field = "5125CB42037D948BBFAB6F6A3764ED7E")

        public static final UnicodeBlock BUHID = new UnicodeBlock("BUHID", 0x1740, 0x175f);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.424 -0400", hash_original_field = "3C273F9EE9496B9CC352D7CB1FA06030", hash_generated_field = "52DDE6EC90BD898A5694574363AF2A7B")

        public static final UnicodeBlock TAGBANWA = new UnicodeBlock("TAGBANWA", 0x1760, 0x177f);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.424 -0400", hash_original_field = "C854C37EA7B27985A941EB1D34479B00", hash_generated_field = "4869B0CB54ACE359B3BBB3D626D7D3A4")

        public static final UnicodeBlock KHMER = new UnicodeBlock("KHMER", 0x1780, 0x17ff);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.424 -0400", hash_original_field = "88F6008144BE5455DBCEB8EB08F17AB6", hash_generated_field = "947F7C5AE34A12BE2317096CF4FBBF24")

        public static final UnicodeBlock MONGOLIAN = new UnicodeBlock("MONGOLIAN", 0x1800, 0x18af);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.424 -0400", hash_original_field = "2CEB3728726A12F3272B6B25B1998636", hash_generated_field = "F255EC7982124B9814E02ECBC37FD156")

        public static final UnicodeBlock LIMBU = new UnicodeBlock("LIMBU", 0x1900, 0x194f);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.424 -0400", hash_original_field = "C32B4FB9B7AEBC6976973E354BB35491", hash_generated_field = "D70E741C8A1B3415F37F6F8C21FCE52F")

        public static final UnicodeBlock TAI_LE = new UnicodeBlock("TAI_LE", 0x1950, 0x197f);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.424 -0400", hash_original_field = "9A4F338A8C05190F15E456347FC410E2", hash_generated_field = "388070871C45D4C22AEE8D75889C3CB5")

        public static final UnicodeBlock KHMER_SYMBOLS = new UnicodeBlock("KHMER_SYMBOLS", 0x19e0, 0x19ff);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.424 -0400", hash_original_field = "17298EB73816BBC9AAD2288737511910", hash_generated_field = "D96DBDC03A72D5AEEB13491E2848F9A5")

        public static final UnicodeBlock PHONETIC_EXTENSIONS = new UnicodeBlock("PHONETIC_EXTENSIONS", 0x1d00, 0x1d7f);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.424 -0400", hash_original_field = "F0874D9C406B66E4E3FF9DF6BC375682", hash_generated_field = "0934E50FADB3C08262578A270455335C")

        public static final UnicodeBlock LATIN_EXTENDED_ADDITIONAL = new UnicodeBlock("LATIN_EXTENDED_ADDITIONAL", 0x1e00, 0x1eff);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.424 -0400", hash_original_field = "A3BA4813FC26394341EE9A2FC26441F4", hash_generated_field = "7371E4D001FAFB197E120996FE11DC31")

        public static final UnicodeBlock GREEK_EXTENDED = new UnicodeBlock("GREEK_EXTENDED", 0x1f00, 0x1fff);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.424 -0400", hash_original_field = "0DAA7A815EFFC9F1F37A4DAEF9617157", hash_generated_field = "9C2CFF0F91CCEEFB7127A71DDD43D41B")

        public static final UnicodeBlock GENERAL_PUNCTUATION = new UnicodeBlock("GENERAL_PUNCTUATION", 0x2000, 0x206f);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.424 -0400", hash_original_field = "AC47F6A59732D45E8E8E0A19E78EE39B", hash_generated_field = "82419378DF9AC762DB84383B7ECDB977")

        public static final UnicodeBlock SUPERSCRIPTS_AND_SUBSCRIPTS = new UnicodeBlock("SUPERSCRIPTS_AND_SUBSCRIPTS", 0x2070, 0x209f);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.424 -0400", hash_original_field = "302A11EEF8EF0E211D961E9B1D37A5B2", hash_generated_field = "74CED514590E4CECCE1B9C7F66A7F521")

        public static final UnicodeBlock CURRENCY_SYMBOLS = new UnicodeBlock("CURRENCY_SYMBOLS", 0x20a0, 0x20cf);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.424 -0400", hash_original_field = "DFF3A1C5ED03902C48C4106AFC0B5223", hash_generated_field = "B967A14B1D1D5E7DE127BF8A7A969A42")

        public static final UnicodeBlock COMBINING_MARKS_FOR_SYMBOLS = new UnicodeBlock("COMBINING_MARKS_FOR_SYMBOLS", 0x20d0, 0x20ff);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.424 -0400", hash_original_field = "890DAB3D82332EB9772B60564BABB589", hash_generated_field = "ED9D613259FB7BE24581D97EB2D4B36C")

        public static final UnicodeBlock LETTERLIKE_SYMBOLS = new UnicodeBlock("LETTERLIKE_SYMBOLS", 0x2100, 0x214f);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.424 -0400", hash_original_field = "9FD49143776EFCF6955F9662CABF7DE6", hash_generated_field = "DE9E52D4423299708EC88EC6A8C6DCF6")

        public static final UnicodeBlock NUMBER_FORMS = new UnicodeBlock("NUMBER_FORMS", 0x2150, 0x218f);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.424 -0400", hash_original_field = "066E5BCA9B389B7FDE92D2FE8159759F", hash_generated_field = "1DBA7F105CFC2652DC5EEEF00B8D1B29")

        public static final UnicodeBlock ARROWS = new UnicodeBlock("ARROWS", 0x2190, 0x21ff);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.424 -0400", hash_original_field = "3C2AFCE1498B0D49FB7D3A097A8B7478", hash_generated_field = "D7CD0EB4CA541777C361F6FA7035DABC")

        public static final UnicodeBlock MATHEMATICAL_OPERATORS = new UnicodeBlock("MATHEMATICAL_OPERATORS", 0x2200, 0x22ff);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.424 -0400", hash_original_field = "333D1EC99F58765C3690B06CC641A6C3", hash_generated_field = "926C750522BC176C76C1707C7736942B")

        public static final UnicodeBlock MISCELLANEOUS_TECHNICAL = new UnicodeBlock("MISCELLANEOUS_TECHNICAL", 0x2300, 0x23ff);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.425 -0400", hash_original_field = "564968467EDADFF36D10984C2615A829", hash_generated_field = "F6AD9C956127F65E30C8C9BA426B85B6")

        public static final UnicodeBlock CONTROL_PICTURES = new UnicodeBlock("CONTROL_PICTURES", 0x2400, 0x243f);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.425 -0400", hash_original_field = "97B090A730967B0843F56DE565EE397A", hash_generated_field = "AC5CF075D0502A594F356785FC70901E")

        public static final UnicodeBlock OPTICAL_CHARACTER_RECOGNITION = new UnicodeBlock("OPTICAL_CHARACTER_RECOGNITION", 0x2440, 0x245f);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.425 -0400", hash_original_field = "A37E007D5A68B97F87DFB55D7F31DDB1", hash_generated_field = "CC8C65F3FC61B00629E07EA7D4CB78AF")

        public static final UnicodeBlock ENCLOSED_ALPHANUMERICS = new UnicodeBlock("ENCLOSED_ALPHANUMERICS", 0x2460, 0x24ff);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.425 -0400", hash_original_field = "3D724408B38379A8F10E3666150F9CAE", hash_generated_field = "8E4DB7A5184CCB25F83BC5CE83AD322E")

        public static final UnicodeBlock BOX_DRAWING = new UnicodeBlock("BOX_DRAWING", 0x2500, 0x257f);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.425 -0400", hash_original_field = "E7C41B37BBF4A08638497783C71700D0", hash_generated_field = "DB464C4BE5C793FA1E3A56017F1E23FA")

        public static final UnicodeBlock BLOCK_ELEMENTS = new UnicodeBlock("BLOCK_ELEMENTS", 0x2580, 0x259f);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.425 -0400", hash_original_field = "2D2A4BEBE67BF69FFAF498C8693217D2", hash_generated_field = "402F82F4798F6525D8BE68314680DD8B")

        public static final UnicodeBlock GEOMETRIC_SHAPES = new UnicodeBlock("GEOMETRIC_SHAPES", 0x25a0, 0x25ff);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.425 -0400", hash_original_field = "CCBAE547611D4F750B5D59C95F4CC065", hash_generated_field = "47C2EAFC9E1016362CDC3AC939436CE4")

        public static final UnicodeBlock MISCELLANEOUS_SYMBOLS = new UnicodeBlock("MISCELLANEOUS_SYMBOLS", 0x2600, 0x26ff);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.425 -0400", hash_original_field = "82ED9E3C3A4265FB78610E880CF12C89", hash_generated_field = "60653EB8608807060009D65E8028EBEE")

        public static final UnicodeBlock DINGBATS = new UnicodeBlock("DINGBATS", 0x2700, 0x27bf);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.425 -0400", hash_original_field = "0C2FCEBF1AA4607DEC1250B6613E4876", hash_generated_field = "10F7165473316DF82822668B8279ECF6")

        public static final UnicodeBlock MISCELLANEOUS_MATHEMATICAL_SYMBOLS_A = new UnicodeBlock("MISCELLANEOUS_MATHEMATICAL_SYMBOLS_A", 0x27c0, 0x27ef);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.425 -0400", hash_original_field = "FF4241E8B7514EA077F430D1E9F0AD7B", hash_generated_field = "E8636511717B74717F63309511C55029")

        public static final UnicodeBlock SUPPLEMENTAL_ARROWS_A = new UnicodeBlock("SUPPLEMENTAL_ARROWS_A", 0x27f0, 0x27ff);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.425 -0400", hash_original_field = "A123099B3843BE1636038AB5787A83AC", hash_generated_field = "C1EE1CFC0D7C5476A0EE9B3BA107BCFD")

        public static final UnicodeBlock BRAILLE_PATTERNS = new UnicodeBlock("BRAILLE_PATTERNS", 0x2800, 0x28ff);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.425 -0400", hash_original_field = "DA5DA3D8CEB4163A84D100086B505AEC", hash_generated_field = "620B3A9CE716FF4FEFB3B67FD56E41BE")

        public static final UnicodeBlock SUPPLEMENTAL_ARROWS_B = new UnicodeBlock("SUPPLEMENTAL_ARROWS_B", 0x2900, 0x297f);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.425 -0400", hash_original_field = "2E19DBA730D8F047A39D09701F0B5FA0", hash_generated_field = "6016E8D817FEBA77C12B0D324C74B6A1")

        public static final UnicodeBlock MISCELLANEOUS_MATHEMATICAL_SYMBOLS_B = new UnicodeBlock("MISCELLANEOUS_MATHEMATICAL_SYMBOLS_B", 0x2980, 0x29ff);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.425 -0400", hash_original_field = "3ADEE61036E08503BD0B9A47CDCD4533", hash_generated_field = "5D91286FFEC5DF87B1FC46A7EE858D5F")

        public static final UnicodeBlock SUPPLEMENTAL_MATHEMATICAL_OPERATORS = new UnicodeBlock("SUPPLEMENTAL_MATHEMATICAL_OPERATORS", 0x2a00, 0x2aff);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.425 -0400", hash_original_field = "C73930CD71EACC8AE89140E9C664B062", hash_generated_field = "0134B121A95640D16A57F3D8E680AA88")

        public static final UnicodeBlock MISCELLANEOUS_SYMBOLS_AND_ARROWS = new UnicodeBlock("MISCELLANEOUS_SYMBOLS_AND_ARROWS", 0x2b00, 0x2bff);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.425 -0400", hash_original_field = "15FEA305607A9AA06A357BAD31FA7E44", hash_generated_field = "3256E4BD30C85C532C0A701EE026DD89")

        public static final UnicodeBlock CJK_RADICALS_SUPPLEMENT = new UnicodeBlock("CJK_RADICALS_SUPPLEMENT", 0x2e80, 0x2eff);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.425 -0400", hash_original_field = "BEF6EB7F516DCE0C7F9F74CA43FCF2C4", hash_generated_field = "0F14D50B7E40BD4B8D8E129372DB0B5B")

        public static final UnicodeBlock KANGXI_RADICALS = new UnicodeBlock("KANGXI_RADICALS", 0x2f00, 0x2fdf);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.425 -0400", hash_original_field = "6DDC671C847D78A12ADA6D55273DB4D5", hash_generated_field = "DB7346FECAFC51C42CFCD446C5CD8ED2")

        public static final UnicodeBlock IDEOGRAPHIC_DESCRIPTION_CHARACTERS = new UnicodeBlock("IDEOGRAPHIC_DESCRIPTION_CHARACTERS", 0x2ff0, 0x2fff);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.425 -0400", hash_original_field = "6000CC696882885B026A50401FAD6383", hash_generated_field = "0FBC8A7CA1E1C178AEFAD9BAD7FD8BA6")

        public static final UnicodeBlock CJK_SYMBOLS_AND_PUNCTUATION = new UnicodeBlock("CJK_SYMBOLS_AND_PUNCTUATION", 0x3000, 0x303f);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.425 -0400", hash_original_field = "C87371BC7FEEA1308B2E14D8B421B279", hash_generated_field = "89E48B46BC9763EA20906E0C9E83446F")

        public static final UnicodeBlock HIRAGANA = new UnicodeBlock("HIRAGANA", 0x3040, 0x309f);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.425 -0400", hash_original_field = "5EB20EC5D194799FFB12B04AC238A3C3", hash_generated_field = "EB234F086A1BD8842B8E337316B59C18")

        public static final UnicodeBlock KATAKANA = new UnicodeBlock("KATAKANA", 0x30a0, 0x30ff);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.425 -0400", hash_original_field = "6CAA7AE897E094302897288FFA1D2262", hash_generated_field = "9D28916A0D169BA84155A29EA5A14947")

        public static final UnicodeBlock BOPOMOFO = new UnicodeBlock("BOPOMOFO", 0x3100, 0x312f);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.425 -0400", hash_original_field = "CE92B317C92282BAC92894472EC5E32B", hash_generated_field = "FDB7722C38F86DA6D49CB152F57A81F2")

        public static final UnicodeBlock HANGUL_COMPATIBILITY_JAMO = new UnicodeBlock("HANGUL_COMPATIBILITY_JAMO", 0x3130, 0x318f);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.425 -0400", hash_original_field = "47DE2F1ADF66C659146E97DF839AD057", hash_generated_field = "9870595B1D9E5ED8D47D552E1082ECA0")

        public static final UnicodeBlock KANBUN = new UnicodeBlock("KANBUN", 0x3190, 0x319f);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.425 -0400", hash_original_field = "97D57EACF7A90F16D51F43221B71582B", hash_generated_field = "F095BF5739393B0802453A804B5D618E")

        public static final UnicodeBlock BOPOMOFO_EXTENDED = new UnicodeBlock("BOPOMOFO_EXTENDED", 0x31a0, 0x31bf);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.425 -0400", hash_original_field = "30949C0557DC58E05BF93EC1DA1F45BF", hash_generated_field = "2BD91BDEDEDF4516A406B66C3DCB4FD3")

        public static final UnicodeBlock KATAKANA_PHONETIC_EXTENSIONS = new UnicodeBlock("KATAKANA_PHONETIC_EXTENSIONS", 0x31f0, 0x31ff);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.425 -0400", hash_original_field = "B9643B33E6F0B6C0EB784773277BC76C", hash_generated_field = "3CA4CEF138ED9067AC4729B1F8768908")

        public static final UnicodeBlock ENCLOSED_CJK_LETTERS_AND_MONTHS = new UnicodeBlock("ENCLOSED_CJK_LETTERS_AND_MONTHS", 0x3200, 0x32ff);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.425 -0400", hash_original_field = "73D68E6A7D2561D338A282D3D559D054", hash_generated_field = "DE5A722AFCC0A621605F3FE90292B0CA")

        public static final UnicodeBlock CJK_COMPATIBILITY = new UnicodeBlock("CJK_COMPATIBILITY", 0x3300, 0x33ff);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.425 -0400", hash_original_field = "9DC2F1F208FA6A383EBDF1F508228422", hash_generated_field = "C04BE31D6701909EDE4A9E74608FC320")

        public static final UnicodeBlock CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A = new UnicodeBlock("CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A", 0x3400, 0x4dbf);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.426 -0400", hash_original_field = "E91AE1D4F955542A345B6C3FD2DF057E", hash_generated_field = "E1536B9D8446C9A6A32A6C2DB831BB2B")

        public static final UnicodeBlock YIJING_HEXAGRAM_SYMBOLS = new UnicodeBlock("YIJING_HEXAGRAM_SYMBOLS", 0x4dc0, 0x4dff);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.426 -0400", hash_original_field = "858E2BF61D3C7FC3157972A06F25906B", hash_generated_field = "A6638282D081E5B0BF56AE4CB51BAA28")

        public static final UnicodeBlock CJK_UNIFIED_IDEOGRAPHS = new UnicodeBlock("CJK_UNIFIED_IDEOGRAPHS", 0x4e00, 0x9fff);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.426 -0400", hash_original_field = "09092BEFCCEEB5BB8C57B1CAAEB1A558", hash_generated_field = "098555705ADCB5046EEAA2EDD7D1961C")

        public static final UnicodeBlock YI_SYLLABLES = new UnicodeBlock("YI_SYLLABLES", 0xa000, 0xa48f);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.426 -0400", hash_original_field = "DE21CEB3E9374057F01AAAB1F53A668A", hash_generated_field = "B5208EC4AD5DFE1C7AEB1AFF8418351A")

        public static final UnicodeBlock YI_RADICALS = new UnicodeBlock("YI_RADICALS", 0xa490, 0xa4cf);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.426 -0400", hash_original_field = "8F09596AEFF9D98F909EE3971321548C", hash_generated_field = "0BBEF82C4B814E06C0B36C6B6A407FE1")

        public static final UnicodeBlock HANGUL_SYLLABLES = new UnicodeBlock("HANGUL_SYLLABLES", 0xac00, 0xd7af);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.426 -0400", hash_original_field = "A39CA3BA61293BFAD8555EB98703D076", hash_generated_field = "A3E9E353C6F34AA3360E9D4D0E11EBEC")

        public static final UnicodeBlock HIGH_SURROGATES = new UnicodeBlock("HIGH_SURROGATES", 0xd800, 0xdb7f);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.426 -0400", hash_original_field = "019F962EC13835D347D7AF51E4A6B082", hash_generated_field = "ECC47680DA2F4AF1E166373258E2A73F")

        public static final UnicodeBlock HIGH_PRIVATE_USE_SURROGATES = new UnicodeBlock("HIGH_PRIVATE_USE_SURROGATES", 0xdb80, 0xdbff);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.426 -0400", hash_original_field = "8725157B8947ABD69BA7B100345FD3CE", hash_generated_field = "CA8F7B713D75AE4C540FC9BE1E94B14C")

        public static final UnicodeBlock LOW_SURROGATES = new UnicodeBlock("LOW_SURROGATES", 0xdc00, 0xdfff);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.426 -0400", hash_original_field = "1CE4918413167FE71EB4B0ACD14666B9", hash_generated_field = "D0B703B2ED38517C0D7B294421F9F1A8")

        public static final UnicodeBlock PRIVATE_USE_AREA = new UnicodeBlock("PRIVATE_USE_AREA", 0xe000, 0xf8ff);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.426 -0400", hash_original_field = "B518B090BE06622F8DA92B8DE8AFE383", hash_generated_field = "99A590A3E4C0036F9A7FEB4C80D1DC86")

        public static final UnicodeBlock CJK_COMPATIBILITY_IDEOGRAPHS = new UnicodeBlock("CJK_COMPATIBILITY_IDEOGRAPHS", 0xf900, 0xfaff);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.426 -0400", hash_original_field = "9323895451905232516D53956BF0A565", hash_generated_field = "298039FA168BAD6173D22D39F2F6E569")

        public static final UnicodeBlock ALPHABETIC_PRESENTATION_FORMS = new UnicodeBlock("ALPHABETIC_PRESENTATION_FORMS", 0xfb00, 0xfb4f);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.426 -0400", hash_original_field = "195DE30562A375825D7422F1E5831C94", hash_generated_field = "C3DAA2886FEBE16DA702A7635103A66F")

        public static final UnicodeBlock ARABIC_PRESENTATION_FORMS_A = new UnicodeBlock("ARABIC_PRESENTATION_FORMS_A", 0xfb50, 0xfdff);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.426 -0400", hash_original_field = "67ED6966ED5719CBAB7190A83AE31216", hash_generated_field = "977C92BC90D9AD33A96C2E1695DCEE9E")

        public static final UnicodeBlock VARIATION_SELECTORS = new UnicodeBlock("VARIATION_SELECTORS", 0xfe00, 0xfe0f);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.426 -0400", hash_original_field = "EC1DCCB0B7CAD74A610B7F68C185FEB0", hash_generated_field = "A8558C320DD51CB5665AC157E601DAF5")

        public static final UnicodeBlock COMBINING_HALF_MARKS = new UnicodeBlock("COMBINING_HALF_MARKS", 0xfe20, 0xfe2f);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.426 -0400", hash_original_field = "F7B71E63CCB4B563D3A965245684A20D", hash_generated_field = "1F0BD8E11D487E1D2A2D641C6858E8C8")

        public static final UnicodeBlock CJK_COMPATIBILITY_FORMS = new UnicodeBlock("CJK_COMPATIBILITY_FORMS", 0xfe30, 0xfe4f);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.426 -0400", hash_original_field = "9339229DFF5572B26FA3DC5E84143765", hash_generated_field = "BEAD6130A6222972DD1A8A29B8609522")

        public static final UnicodeBlock SMALL_FORM_VARIANTS = new UnicodeBlock("SMALL_FORM_VARIANTS", 0xfe50, 0xfe6f);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.426 -0400", hash_original_field = "0840F76D86D0041D24530BABC16DC55B", hash_generated_field = "539EE254C9810D31387B0E81A87ACB77")

        public static final UnicodeBlock ARABIC_PRESENTATION_FORMS_B = new UnicodeBlock("ARABIC_PRESENTATION_FORMS_B", 0xfe70, 0xfeff);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.426 -0400", hash_original_field = "A66CCB895567A60A53AFD3D8F99F3437", hash_generated_field = "E4EE3AB3E9711C4718FA45FD3F2FB359")

        public static final UnicodeBlock HALFWIDTH_AND_FULLWIDTH_FORMS = new UnicodeBlock("HALFWIDTH_AND_FULLWIDTH_FORMS", 0xff00, 0xffef);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.426 -0400", hash_original_field = "F2DC108EB3379C83574357EB39C99159", hash_generated_field = "68AA014FD4A408F01BA93DCA41187CBE")

        public static final UnicodeBlock SPECIALS = new UnicodeBlock("SPECIALS", 0xfff0, 0xffff);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.426 -0400", hash_original_field = "382447232F31C4D34634E6F89548FE50", hash_generated_field = "6216E3FFEB4A702A4EB827A96741F966")

        public static final UnicodeBlock LINEAR_B_SYLLABARY = new UnicodeBlock("LINEAR_B_SYLLABARY", 0x10000, 0x1007f);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.426 -0400", hash_original_field = "AB2F03B0AE055340AA8BBA0E8D05E8FB", hash_generated_field = "864F93B3684928ABDFBB3C39AB300C89")

        public static final UnicodeBlock LINEAR_B_IDEOGRAMS = new UnicodeBlock("LINEAR_B_IDEOGRAMS", 0x10080, 0x100ff);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.426 -0400", hash_original_field = "4E46827857B82A3F69186BD79D275327", hash_generated_field = "076E60A9275FB64D6B8CD06E79FBC642")

        public static final UnicodeBlock AEGEAN_NUMBERS = new UnicodeBlock("AEGEAN_NUMBERS", 0x10100, 0x1013f);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.426 -0400", hash_original_field = "2A986EE673D07FA6E55EF3E11EF3B84B", hash_generated_field = "B0BDE03A8FB3FCE90FD7C0D393528563")

        public static final UnicodeBlock OLD_ITALIC = new UnicodeBlock("OLD_ITALIC", 0x10300, 0x1032f);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.426 -0400", hash_original_field = "512BCFD9B6E44347C495A43A783E441D", hash_generated_field = "E719B95FABA4FE9E7CBE093B4B9814F7")

        public static final UnicodeBlock GOTHIC = new UnicodeBlock("GOTHIC", 0x10330, 0x1034f);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.426 -0400", hash_original_field = "37C702B0219D9A71CFB10C3C00F1753B", hash_generated_field = "90722BF19C5FEF316989CAEB3A438A4A")

        public static final UnicodeBlock UGARITIC = new UnicodeBlock("UGARITIC", 0x10380, 0x1039f);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.426 -0400", hash_original_field = "2C3906CE6F31E9A651D3C0CC979EC1E0", hash_generated_field = "00778E5B6E8F5A54CA1C86D148A9BB28")

        public static final UnicodeBlock DESERET = new UnicodeBlock("DESERET", 0x10400, 0x1044f);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.426 -0400", hash_original_field = "8E34A2A3E18197BC1951B201BFFA5ABE", hash_generated_field = "5C961EA224EDA4C2536FB691BF1F7840")

        public static final UnicodeBlock SHAVIAN = new UnicodeBlock("SHAVIAN", 0x10450, 0x1047f);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.427 -0400", hash_original_field = "2363EAFAA921F5F5FFFF9FACB0D0523A", hash_generated_field = "4CD61F0B986413AFB693D0E5A2D24B1E")

        public static final UnicodeBlock OSMANYA = new UnicodeBlock("OSMANYA", 0x10480, 0x104af);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.427 -0400", hash_original_field = "AF399B2B94CBDA8BB8A9EC7C6D08E20A", hash_generated_field = "101F676992A43133D9E3017D2FA402B0")

        public static final UnicodeBlock CYPRIOT_SYLLABARY = new UnicodeBlock("CYPRIOT_SYLLABARY", 0x10800, 0x1083f);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.427 -0400", hash_original_field = "36E184D7C515776D886ED3318EA90801", hash_generated_field = "0BD33AB611AD5B24DD9F1E272A1F9EEE")

        public static final UnicodeBlock BYZANTINE_MUSICAL_SYMBOLS = new UnicodeBlock("BYZANTINE_MUSICAL_SYMBOLS", 0x1d000, 0x1d0ff);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.427 -0400", hash_original_field = "F857E9508D2CE74CFC42C329773BFE84", hash_generated_field = "410FBA662CD029F8C166CEFB28CB7F21")

        public static final UnicodeBlock MUSICAL_SYMBOLS = new UnicodeBlock("MUSICAL_SYMBOLS", 0x1d100, 0x1d1ff);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.427 -0400", hash_original_field = "57F0B21970C0F3A3C13170DE319BC0CD", hash_generated_field = "6489484CC1D5DDAB83E1826B19ED4CD1")

        public static final UnicodeBlock TAI_XUAN_JING_SYMBOLS = new UnicodeBlock("TAI_XUAN_JING_SYMBOLS", 0x1d300, 0x1d35f);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.427 -0400", hash_original_field = "61E6AD2684A347652A5FAC33068E2C14", hash_generated_field = "E8C629138322F05716CF142BE26FCDCE")

        public static final UnicodeBlock MATHEMATICAL_ALPHANUMERIC_SYMBOLS = new UnicodeBlock("MATHEMATICAL_ALPHANUMERIC_SYMBOLS", 0x1d400, 0x1d7ff);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.427 -0400", hash_original_field = "83D009D65C8E3E59042F7479FD166BC2", hash_generated_field = "59796DF707EADEA6172C6C78A63C8CB1")

        public static final UnicodeBlock CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B = new UnicodeBlock("CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B", 0x20000, 0x2a6df);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.427 -0400", hash_original_field = "24D50DBE8E58F32487A3D8A92CB5C5AE", hash_generated_field = "5AB34FE83B4ECFDC4EAF6F3FCF704BC7")

        public static final UnicodeBlock CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT = new UnicodeBlock("CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT", 0x2f800, 0x2fa1f);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.427 -0400", hash_original_field = "12AB416BAB0D83D19758FA6CC2501677", hash_generated_field = "E089A9FF255D079E2E3A2EB7B0735970")

        public static final UnicodeBlock TAGS = new UnicodeBlock("TAGS", 0xe0000, 0xe007f);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.427 -0400", hash_original_field = "F6F0A5266A0660D022D9C0C89E03147B", hash_generated_field = "A185E731085E928EF6F4F1E0EF098FAA")

        public static final UnicodeBlock VARIATION_SELECTORS_SUPPLEMENT = new UnicodeBlock("VARIATION_SELECTORS_SUPPLEMENT", 0xe0100, 0xe01ef);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.427 -0400", hash_original_field = "82CEEF0CC95EC3B5B4E48C2366F2F7DA", hash_generated_field = "A333F35399AC2ED68EE573C8CFABE105")

        public static final UnicodeBlock SUPPLEMENTARY_PRIVATE_USE_AREA_A = new UnicodeBlock("SUPPLEMENTARY_PRIVATE_USE_AREA_A", 0xf0000, 0xfffff);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.428 -0400", hash_original_field = "70FD15F2E92A8593DBE1C9EB5F414140", hash_generated_field = "C7A657D93940D340E8D0B1F3025A5133")

        public static final UnicodeBlock SUPPLEMENTARY_PRIVATE_USE_AREA_B = new UnicodeBlock("SUPPLEMENTARY_PRIVATE_USE_AREA_B", 0x100000, 0x10ffff);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.428 -0400", hash_original_field = "9CA50F088E7A4D123A6C6C412D5D258E", hash_generated_field = "BE70CFE8234B32987A3B5D8D50E1DFAA")

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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.429 -0400", hash_original_field = "D2AC65249DCEA1160865EC92E35FF1B8", hash_generated_field = "366B6821F766B64AFF49ADADAD2066C9")

    private static final long serialVersionUID = 3786198910865385080L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.429 -0400", hash_original_field = "0D44225835709BDE7D27E6518FA3DAD9", hash_generated_field = "258F3224D2008DAF62BB633B4BC8DAC4")

    public static final char MIN_VALUE = '\u0000';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.429 -0400", hash_original_field = "6642598097510B55688A4CC4803A5AE6", hash_generated_field = "663E1F5D00FD3EE16E2562E439D9FE18")

    public static final char MAX_VALUE = '\uffff';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.429 -0400", hash_original_field = "9EC01B76F094147695AFFE1379904C06", hash_generated_field = "0E66BAB1BEEC2016078BF53E6B6D1E16")

    public static final int MIN_RADIX = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.429 -0400", hash_original_field = "A5107826110A74B23B5960174685E64C", hash_generated_field = "5F187A71774049C0F4BDFF24147D9101")

    public static final int MAX_RADIX = 36;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.429 -0400", hash_original_field = "C98D7FC28A00384E0E5D0544F68D5DA8", hash_generated_field = "EDA376943A29EE67731B884C48162F25")

    @SuppressWarnings("unchecked")
    public static final Class<Character> TYPE
            = (Class<Character>) char[].class.getComponentType();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.429 -0400", hash_original_field = "8798AAE5AA766A9DA3CA9D0F422168C7", hash_generated_field = "85111CB5731338C7ABC74C73D33BCC6D")

    public static final byte UNASSIGNED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.429 -0400", hash_original_field = "A77D0ADFAD3261C85B98EABB64FA2925", hash_generated_field = "E46E31E36A2A064FCA5A5B3365B9D7C2")

    public static final byte UPPERCASE_LETTER = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.429 -0400", hash_original_field = "4E9DEF41B48CEA15E72BD40BD49F8DC2", hash_generated_field = "2349C4B44027F5A2AAF5A3EB964C33FD")

    public static final byte LOWERCASE_LETTER = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.429 -0400", hash_original_field = "4FB3368712846AFF0ACD97C2164C0787", hash_generated_field = "2518D7B86288E9E10B57EE7906C01230")

    public static final byte TITLECASE_LETTER = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.429 -0400", hash_original_field = "BB10669777C5EEE6F72CDF4B82578AFC", hash_generated_field = "B43043DB882F54DCDBED3E23A2D8C140")

    public static final byte MODIFIER_LETTER = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.429 -0400", hash_original_field = "9AE55A66A841B0F8B01DE15FC61B18B1", hash_generated_field = "14418A71CB2CBFDAFAB2CE97D5446FAA")

    public static final byte OTHER_LETTER = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.429 -0400", hash_original_field = "163A761BE4D93F1555FC666101177352", hash_generated_field = "A0D3B9A6108781728BD40B2B402D4DF9")

    public static final byte NON_SPACING_MARK = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.429 -0400", hash_original_field = "4C07F00ADED7B9CD4FCE4601AE04FBF8", hash_generated_field = "0F47728D97DCCC7BFE30DEC641821ABD")

    public static final byte ENCLOSING_MARK = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.429 -0400", hash_original_field = "DCCFA06971F2A83233E0551236A55781", hash_generated_field = "B560F93773D678E7D93ACC37919F4041")

    public static final byte COMBINING_SPACING_MARK = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.429 -0400", hash_original_field = "CA9CD60EE483084B78C38268CBA7BAFB", hash_generated_field = "2775D0C911F5415D7BEDEFE1B25331DC")

    public static final byte DECIMAL_DIGIT_NUMBER = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.429 -0400", hash_original_field = "5AFE435941D2D0F43987D1215A8CC726", hash_generated_field = "477D956497C398C77F0FCCA28D525D1F")

    public static final byte LETTER_NUMBER = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.429 -0400", hash_original_field = "50F7A497852678608C20F3CADB744C0D", hash_generated_field = "F698BFA73FDC7BD5E7D6E5091D5CF7F8")

    public static final byte OTHER_NUMBER = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.429 -0400", hash_original_field = "0C03230C5C2745AC39A2017719A75937", hash_generated_field = "3B1AA2DFDC53D5D5EFF9998A23CDEE3E")

    public static final byte SPACE_SEPARATOR = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.429 -0400", hash_original_field = "A2C5585F040DAA7B1DC70AE13D7446A3", hash_generated_field = "EEB5E60400D692C9E518E0A100223F65")

    public static final byte LINE_SEPARATOR = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.429 -0400", hash_original_field = "E3141A07ADD66AF9937B235C3BC1DB9D", hash_generated_field = "CAC8235F10F25399871A2F8F7EFCD385")

    public static final byte PARAGRAPH_SEPARATOR = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.429 -0400", hash_original_field = "D0FE6A09694CB5C8371AF7B4B73D92EF", hash_generated_field = "B4291BDF4C5CC797DDEE4B3C672B0D3C")

    public static final byte CONTROL = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.429 -0400", hash_original_field = "44ABE4D46402549B2375983A052BB10B", hash_generated_field = "FE8354F3B328CC0D8EBC380E2527BF8A")

    public static final byte FORMAT = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.429 -0400", hash_original_field = "4E91EAC3DE587C7A0C7D4F03470B16F4", hash_generated_field = "D6A2E7BA4A5499452B5042DC30BE8263")

    public static final byte PRIVATE_USE = 18;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.429 -0400", hash_original_field = "4E17601DDC694001787F64C84DFCA628", hash_generated_field = "9BCE804B6E91EB7C0D6AC3CF48D9A9EB")

    public static final byte SURROGATE = 19;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.430 -0400", hash_original_field = "7AE2BE4AD9C4C6E949694DFAD3FDF253", hash_generated_field = "235A1DD1A9C784BDA03E995E24F7B805")

    public static final byte DASH_PUNCTUATION = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.430 -0400", hash_original_field = "3BA2BB8B261E4B7A28F5637EC20F6BE8", hash_generated_field = "918E1A2C2FA7E8789172EEEF46231185")

    public static final byte START_PUNCTUATION = 21;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.430 -0400", hash_original_field = "E532594F809EDA0C7D4E9EA4FD1083A4", hash_generated_field = "CE6479FE6E66972BACE1857331300B8D")

    public static final byte END_PUNCTUATION = 22;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.430 -0400", hash_original_field = "D8B6EE24BB4BF23FF229E7FF2800FACC", hash_generated_field = "1CAE83EE4D96A8C2E604E0A3EF1439CE")

    public static final byte CONNECTOR_PUNCTUATION = 23;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.430 -0400", hash_original_field = "479E9C9E5FBE18BDC0617733945E880D", hash_generated_field = "D10F22A3B961FBA1C72332C12A40205E")

    public static final byte OTHER_PUNCTUATION = 24;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.430 -0400", hash_original_field = "693E621A50ADF382734ECCB6A6F241FF", hash_generated_field = "B414F2054A74344DA216054479E22625")

    public static final byte MATH_SYMBOL = 25;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.430 -0400", hash_original_field = "555AD384670FAFB6DC198129777E71F6", hash_generated_field = "E1F97B4B70A657B7E642CDE292B2A449")

    public static final byte CURRENCY_SYMBOL = 26;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.430 -0400", hash_original_field = "826A1D4085419D1A28B5340164B5ED11", hash_generated_field = "38A2EEF804B6CC1D0349835A8313EF3C")

    public static final byte MODIFIER_SYMBOL = 27;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.430 -0400", hash_original_field = "1F33D04B58855C77CD0954155DF007BE", hash_generated_field = "F8B93C0F898E6A2F79436FBAE3DECA3B")

    public static final byte OTHER_SYMBOL = 28;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.430 -0400", hash_original_field = "BEDC53EA0DE24EC8F9AB9D462A6D9658", hash_generated_field = "18A46E9202B75C9327D292A17F53A8BB")

    public static final byte INITIAL_QUOTE_PUNCTUATION = 29;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.430 -0400", hash_original_field = "526A662D1F40B25325C80505A23FD5A8", hash_generated_field = "7FFD9E2D501F2AD28BF90E9B7808B206")

    public static final byte FINAL_QUOTE_PUNCTUATION = 30;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.430 -0400", hash_original_field = "86B24109DAB8F514C08D84996A9C2581", hash_generated_field = "2CF99592472E13E145863194D0D3E5D3")

    public static final byte DIRECTIONALITY_UNDEFINED = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.430 -0400", hash_original_field = "64487DD82040863371A1D6053A575961", hash_generated_field = "DF72F07E75BBA2515475DE173F66E0F2")

    public static final byte DIRECTIONALITY_LEFT_TO_RIGHT = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.430 -0400", hash_original_field = "22F1CA0CEF1B3DE42FB10982E4F8FD16", hash_generated_field = "1B0E0291882CB62A799850C13A74DF38")

    public static final byte DIRECTIONALITY_RIGHT_TO_LEFT = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.430 -0400", hash_original_field = "16478874A30CF2EE4D27F63A294B1962", hash_generated_field = "08FDA81C783B61E7D52CB11AE2BC7A01")

    public static final byte DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.430 -0400", hash_original_field = "4DDDC843D33C5B3B17EC8940865C1FD5", hash_generated_field = "B8761BBD29E3A3E729024F2B9614E2FB")

    public static final byte DIRECTIONALITY_EUROPEAN_NUMBER = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.430 -0400", hash_original_field = "671537FE7695C068C19C150EA13F5B11", hash_generated_field = "BEAC1A18B62ED65F6B0F3F456AB7B228")

    public static final byte DIRECTIONALITY_EUROPEAN_NUMBER_SEPARATOR = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.430 -0400", hash_original_field = "C0F0E428BE3CD2870C2341E887524DC3", hash_generated_field = "57A2E4EB471BA0D51C6130CBF994EBD5")

    public static final byte DIRECTIONALITY_EUROPEAN_NUMBER_TERMINATOR = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.430 -0400", hash_original_field = "C2A44587280682D09A19F1549106AA4E", hash_generated_field = "6D88ECC2E43F26FAB23E8757B8F4B1D3")

    public static final byte DIRECTIONALITY_ARABIC_NUMBER = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.430 -0400", hash_original_field = "97C6213431C06887E2120EE424CCCCA1", hash_generated_field = "8446420EF1951B38F6EFBA4E9A4EF6F5")

    public static final byte DIRECTIONALITY_COMMON_NUMBER_SEPARATOR = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.430 -0400", hash_original_field = "2033D04332343EEBC6311E1A06F93C8E", hash_generated_field = "9880FF4079E587478B95A27724064BB6")

    public static final byte DIRECTIONALITY_NONSPACING_MARK = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.430 -0400", hash_original_field = "8FD27438EBCAC232F4FB467041D34180", hash_generated_field = "2237817D3DAA9D4C620B5D03348069D9")

    public static final byte DIRECTIONALITY_BOUNDARY_NEUTRAL = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.430 -0400", hash_original_field = "CE55E952670AD41F335EAB3C26E80236", hash_generated_field = "E0036E751C705657BEB42EA1B90BEE35")

    public static final byte DIRECTIONALITY_PARAGRAPH_SEPARATOR = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.430 -0400", hash_original_field = "9800E89A768ECC8E4A7AA50C21A9F739", hash_generated_field = "4074F2100CC73D2D1DA4E75F8C460D32")

    public static final byte DIRECTIONALITY_SEGMENT_SEPARATOR = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.431 -0400", hash_original_field = "EBADDA266F92D1D39CCD3CE9A29FF6DC", hash_generated_field = "64083855912A5B1B16820118FA057A37")

    public static final byte DIRECTIONALITY_WHITESPACE = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.431 -0400", hash_original_field = "1E7C4663C10AA064CD70518CDF5BE6EB", hash_generated_field = "4EDB0AF33074436151C0EBF30A24D4C2")

    public static final byte DIRECTIONALITY_OTHER_NEUTRALS = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.431 -0400", hash_original_field = "D4D2B2C8A0AD7444E1EDA5445C42D9D0", hash_generated_field = "9F58F45F02B0DEB351D4FD9415072A91")

    public static final byte DIRECTIONALITY_LEFT_TO_RIGHT_EMBEDDING = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.431 -0400", hash_original_field = "1DC7F4010B3E833F97DD81DB65FB220E", hash_generated_field = "F1A15423B4369E280E7DA7FF3D3A42D3")

    public static final byte DIRECTIONALITY_LEFT_TO_RIGHT_OVERRIDE = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.431 -0400", hash_original_field = "51E424CE75BA6A9C589869D1F52C546C", hash_generated_field = "4C83AF7A955F4BFB8B5ED12499ED4008")

    public static final byte DIRECTIONALITY_RIGHT_TO_LEFT_EMBEDDING = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.431 -0400", hash_original_field = "A54D784059E41F96230EA76489524813", hash_generated_field = "5E07D195A5895A7F53CBC4556D57E9D2")

    public static final byte DIRECTIONALITY_RIGHT_TO_LEFT_OVERRIDE = 17;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.431 -0400", hash_original_field = "022F93F3A673A0BD076C0E7D3E8517F7", hash_generated_field = "823095A31D59328F1FCC4D05B73A8304")

    public static final byte DIRECTIONALITY_POP_DIRECTIONAL_FORMAT = 18;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.431 -0400", hash_original_field = "8FD52107871323FB5DC7859254D4D0C9", hash_generated_field = "67164DD8003FCA956CEF01CBAA71F41F")

    public static final char MIN_HIGH_SURROGATE = '\uD800';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.431 -0400", hash_original_field = "566DB9AAEE416299DC0E6021D54389D6", hash_generated_field = "E754CC1F6E8F11F1639DE78093B86F7A")

    public static final char MAX_HIGH_SURROGATE = '\uDBFF';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.431 -0400", hash_original_field = "4244E63BF277BE2476695FC8F394A5A7", hash_generated_field = "A6C1DC6C1854AAABCAA1A0500BE13AE6")

    public static final char MIN_LOW_SURROGATE = '\uDC00';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.431 -0400", hash_original_field = "AEE9875AC2E02668B93308B0CC19727B", hash_generated_field = "8CC93D87C4BFA83CB89659DD2769590B")

    public static final char MAX_LOW_SURROGATE = '\uDFFF';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.431 -0400", hash_original_field = "D96E5697A4E805D39D2EE92F533D2230", hash_generated_field = "E53CD7E7DADB80CC5215196EA399D4D8")

    public static final char MIN_SURROGATE = '\uD800';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.431 -0400", hash_original_field = "45E6A7F2DA450DD9F28376FB4E1070D3", hash_generated_field = "B2FF295311D6A95860932B19554C26C7")

    public static final char MAX_SURROGATE = '\uDFFF';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.431 -0400", hash_original_field = "3600F5FD7A74E3E87DEE4E6F5F516D16", hash_generated_field = "4430BA24D2AE2566886D2E5562919E6F")

    public static final int MIN_SUPPLEMENTARY_CODE_POINT = 0x10000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.431 -0400", hash_original_field = "1C34F7CF61E02AEF4E6E1701056AE207", hash_generated_field = "C9A0D15452A074F5179338EE20BDD54C")

    public static final int MIN_CODE_POINT = 0x000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.431 -0400", hash_original_field = "10B49875B4A4C3DA0C4DD86DA4F02CF0", hash_generated_field = "A23E3C853E31AC1620D798966175A835")

    public static final int MAX_CODE_POINT = 0x10FFFF;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.431 -0400", hash_original_field = "19BE510B820D2DF825572D14CACB552E", hash_generated_field = "35BBD8D16D40CCFD2558C6BE179C9BD7")

    public static final int SIZE = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.431 -0400", hash_original_field = "3DD9B53B62753D9A6A436D1C800D4F05", hash_generated_field = "504A101457658254DD8C38E597554F90")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.432 -0400", hash_original_field = "F9BBE724ED0DC9038A4954481F9FA45A", hash_generated_field = "6CC9F0022C62911835E4ACEBBB9BE5BF")

    private static final Character[] SMALL_VALUES = new Character[128];
    static {
        for (int i = 0; i < 128; i++) {
            SMALL_VALUES[i] = new Character((char) i);
        }
    }
    
}

