package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.Serializable;
import java.util.Arrays;

public final class Character implements Serializable, Comparable<Character> {
    private static final long serialVersionUID = 3786198910865385080L;
    private final char value;
    public static final char MIN_VALUE = '\u0000';
    public static final char MAX_VALUE = '\uffff';
    public static final int MIN_RADIX = 2;
    public static final int MAX_RADIX = 36;
    @SuppressWarnings("unchecked")
    public static final Class<Character> TYPE
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.761 -0400", hash_original_method = "8DEFF913326DC7F74512EFD131579B65", hash_generated_method = "2D36670CD570C60FE0EF01CD8020B68D")
    @DSModeled(DSC.SAFE)
    public Character(char value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        //this.value = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.761 -0400", hash_original_method = "4015C311D2E9352F0DAC3B1EE7912530", hash_generated_method = "BC6889B19F6C653D65982F668C15F9A7")
    private static int forNameImpl(String blockName) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.761 -0400", hash_original_method = "B4F6660FE5C4F398695868C604C73DDE", hash_generated_method = "EDCDD3CB837022FCD0AA678FDC769ECA")
    private static int ofImpl(int codePoint) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.761 -0400", hash_original_method = "1972D57F3C05C7BADF696B9ADC3E34F9", hash_generated_method = "979859E5D53724E7B32FEC4740ADD103")
    @DSModeled(DSC.SAFE)
    public char charValue() {
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.761 -0400", hash_original_method = "2E1CB6E5E405F453739AE358669BD826", hash_generated_method = "FCCF4BD5EC743B2E2DFD8AC0D03FDA40")
    private static void checkValidCodePoint(int codePoint) {
        if (!isValidCodePoint(codePoint)) {
            throw new IllegalArgumentException("Invalid code point: " + codePoint);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.761 -0400", hash_original_method = "3BC38476D10A0BB1E7E9CABDBB184EDE", hash_generated_method = "36A79D23C6A81D0963DDD83078639AB1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int compareTo(Character c) {
        dsTaint.addTaint(c.dsTaint);
        int var2D53C4D03B154FEA4531431C9E7F8DB6_1067303766 = (compare(value, c.value));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return compare(value, c.value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.761 -0400", hash_original_method = "E7BB00F4AE5B31620C8E253034E7136C", hash_generated_method = "CC7BA13ACC12EF2EA45DD84803ECD771")
    public static int compare(char lhs, char rhs) {
        return lhs - rhs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.761 -0400", hash_original_method = "F129BF1AA7DEE10DECE549FDC9BFFE92", hash_generated_method = "F095D9571C020E30A8442C3CF921848D")
    public static Character valueOf(char c) {
        return c < 128 ? SMALL_VALUES[c] : new Character(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.761 -0400", hash_original_method = "C3C668651D6457D78EBF7ED9F69FDBEA", hash_generated_method = "7A891326D8F1A97963AD3246CF366438")
    public static boolean isValidCodePoint(int codePoint) {
        return (MIN_CODE_POINT <= codePoint && MAX_CODE_POINT >= codePoint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.761 -0400", hash_original_method = "7350229310DA887712F911A12A06A250", hash_generated_method = "FC74D85BFBCFD2A20FD40A9D9685DBD3")
    public static boolean isSupplementaryCodePoint(int codePoint) {
        return (MIN_SUPPLEMENTARY_CODE_POINT <= codePoint && MAX_CODE_POINT >= codePoint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.761 -0400", hash_original_method = "CC2888AF1D68C86A10FED4F68E6B3B15", hash_generated_method = "5022015EDECC9C66A07B22D3E30C04ED")
    public static boolean isHighSurrogate(char ch) {
        return (MIN_HIGH_SURROGATE <= ch && MAX_HIGH_SURROGATE >= ch);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.761 -0400", hash_original_method = "3EEAD604696AB011239EDF6A0C629A36", hash_generated_method = "13C6BD12B5D49A39AA4098D4426B9EFD")
    public static boolean isLowSurrogate(char ch) {
        return (MIN_LOW_SURROGATE <= ch && MAX_LOW_SURROGATE >= ch);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.761 -0400", hash_original_method = "DE60A5245E3B8D87B5C64F3502226B91", hash_generated_method = "113279C604CCF4258CC3F684CEBF7053")
    public static boolean isSurrogate(char ch) {
        return ch >= MIN_SURROGATE && ch <= MAX_SURROGATE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.761 -0400", hash_original_method = "7E883A5461EB25C0FF6C63AC2DCB994A", hash_generated_method = "308A7D66765E2C120C9128A71ECB6416")
    public static boolean isSurrogatePair(char high, char low) {
        return (isHighSurrogate(high) && isLowSurrogate(low));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.761 -0400", hash_original_method = "C9BC23458AD053A48381AE5B5A527C8A", hash_generated_method = "EAFC8B8ACD0113BDB3495417AB6F646D")
    public static int charCount(int codePoint) {
        return (codePoint >= 0x10000 ? 2 : 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.761 -0400", hash_original_method = "DD1FE557D625E499D35253862443F8D1", hash_generated_method = "75290209ABC8DC8238EACB2D7A21EC32")
    public static int toCodePoint(char high, char low) {
        int h = (high & 0x3FF) << 10;
        int l = low & 0x3FF;
        return (h | l) + 0x10000;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.762 -0400", hash_original_method = "E6242CB8B89CA1A001F7CADF5983DA48", hash_generated_method = "0802AD80AE830467DC5804D51189595A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.762 -0400", hash_original_method = "9E66291941471B1F0D8C9AEEF9DD2957", hash_generated_method = "16083B072531CEBE8FE2A87774837615")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.762 -0400", hash_original_method = "10717D6164391B9A222449CE187E6CFD", hash_generated_method = "30A500746332709389216C1B4FD18258")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.762 -0400", hash_original_method = "E2C351EF365BE7AD1D8CE0225CD35BEB", hash_generated_method = "FCE16537C8820D043E263F1FC69263D9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.762 -0400", hash_original_method = "921CAAD51ACE254BCB278600F89558CC", hash_generated_method = "22B545BE742B3AEA24F6DC1DE9B61295")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.762 -0400", hash_original_method = "C4A20E17E12D55162CF220605A00AD99", hash_generated_method = "9A94475CA32D7D3C295ACA189C6D0A2D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.762 -0400", hash_original_method = "80CF91592A6B73E807BCA9FF8983A108", hash_generated_method = "65E983CA58793D9D8B1B7A4479EBB88A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.762 -0400", hash_original_method = "43D4C7C89B9FD66F7552269DD4A67BA9", hash_generated_method = "E62196F0F1B9A536655AF36CC4AFAA5D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.762 -0400", hash_original_method = "29F526428DF05B6D3CA38BC3BC73F2D3", hash_generated_method = "29E3590772F175B6E7FD917AD0F51991")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.762 -0400", hash_original_method = "EEAACA1E930EF9A85838BA9C7F309FA1", hash_generated_method = "96374037B4136C8AD5DEF19CAE0FE073")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.762 -0400", hash_original_method = "A24D68C92A9069CC6E247ECA1084686D", hash_generated_method = "33A9449B4675EB1CB38E0949D3234AC6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.762 -0400", hash_original_method = "E92C62310F8BC047840FD5F8129A6310", hash_generated_method = "A4DAB334E099B0AC7D9DDAABDDB583B7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.763 -0400", hash_original_method = "189278FA1F864DD1FE3339B81D19112D", hash_generated_method = "67C2BE3190053B65E97FF514C4E35C39")
    public static int digit(char c, int radix) {
        return digit((int) c, radix);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.763 -0400", hash_original_method = "F2A9A0041EB0F3802CEB1CDE881811BE", hash_generated_method = "93A3325702ECB8B7065FD5FF99F9394F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.763 -0400", hash_original_method = "5136D0E0B0E7F6F03C2ACBA60CD0DA7D", hash_generated_method = "FD3CE60BD3644B78228E36DD5B28BBD7")
    private static int digitImpl(int codePoint, int radix) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.763 -0400", hash_original_method = "88215BA2DAA464AB2808512F13A48003", hash_generated_method = "BC1AD139B66A0FB90CA6756667A65DF4")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (object instanceof Character) && (((Character) object).value == value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.763 -0400", hash_original_method = "9D6DD04CE03E9B3EA92C74E656478FC0", hash_generated_method = "1C3102D8B614C030228DBA862C9FDAC8")
    public static char forDigit(int digit, int radix) {
        if (MIN_RADIX <= radix && radix <= MAX_RADIX) {
            if (digit >= 0 && digit < radix) {
                return (char) (digit < 10 ? digit + '0' : digit + 'a' - 10);
            }
        }
        return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.763 -0400", hash_original_method = "80CBCF21777696C5A7AD973BF83A0B43", hash_generated_method = "8200EE38F7E81468A3DFC3D4AC2B222F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.763 -0400", hash_original_method = "308577C469D43230519015864E3846FC", hash_generated_method = "16941F8CB59826F2E87576C549E5F313")
    private static String getNameImpl(int codePoint) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.763 -0400", hash_original_method = "44A8BF8424D42743A00DC522EAFF94BC", hash_generated_method = "C6115594E660D9D27F0BC2207443C1B4")
    public static int getNumericValue(char c) {
        return getNumericValue((int) c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.763 -0400", hash_original_method = "C81D5E44B1E6A7DD313F799E48D5ADD8", hash_generated_method = "7286CC174E4342DAB5414D5E884844D6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.763 -0400", hash_original_method = "92CF6E8F473015AEBE60E2D661CB1525", hash_generated_method = "21E880B116E6CB09CB0CB770FD76E30F")
    private static int getNumericValueImpl(int codePoint) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.763 -0400", hash_original_method = "472C14EA76E66AD56E145417CB2E2E09", hash_generated_method = "3428CD451743D99B6397CAAE215673E8")
    public static int getType(char c) {
        return getType((int) c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.763 -0400", hash_original_method = "FBB6323759AAB52949452B64054A19F7", hash_generated_method = "41874089F56E73A4751A514406D566D7")
    public static int getType(int codePoint) {
        int type = getTypeImpl(codePoint);
        if (type <= Character.FORMAT) {
            return type;
        }
        return (type + 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.763 -0400", hash_original_method = "77B3E40EF93B0722D6FCE2DCAE56E47E", hash_generated_method = "77221D568DE9B01FC53DEF672F330314")
    private static int getTypeImpl(int codePoint) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.763 -0400", hash_original_method = "BAAC4031CE67ACBF5435C0572C9451C4", hash_generated_method = "B52A40EC5B7F7D5A95A5416ED7B666B9")
    public static byte getDirectionality(char c) {
        return getDirectionality((int)c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.763 -0400", hash_original_method = "B9E955EF2712E02C1EDBC21B558449AF", hash_generated_method = "EEF8D7AA68CE492EFDDA0E97E21487CA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.763 -0400", hash_original_method = "7754284BD875AFA90F21F5FE8120A159", hash_generated_method = "D9F82847FCE187FDC195154610B14F7B")
    private static byte getDirectionalityImpl(int codePoint) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.763 -0400", hash_original_method = "1BF084B14EC69DE3E76A3A4117F862C8", hash_generated_method = "4DDD304917D503E6862800E37AB9B148")
    public static boolean isMirrored(char c) {
        return isMirrored((int) c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.763 -0400", hash_original_method = "0D5BB93036D150E4F21C8BED2C6D4A06", hash_generated_method = "8A1642953FD4FEE1D5C42FB3D8A67A5A")
    public static boolean isMirrored(int codePoint) {
        return isMirroredImpl(codePoint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.763 -0400", hash_original_method = "E292C959323B528E04496C7CCA760565", hash_generated_method = "8F4F700CCD114EF9769B4721AF51851B")
    private static boolean isMirroredImpl(int codePoint) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.763 -0400", hash_original_method = "961F210287166DF05D8915D632129E75", hash_generated_method = "839D1EBE643B666CA5D1F1CA10397ED1")
    @DSModeled(DSC.SAFE)
    @Override
    public int hashCode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.763 -0400", hash_original_method = "D12B7095CE782CB3A44759C6A99FDE49", hash_generated_method = "95F67EF1AE8E8F4CFD78A7E29DCD7543")
    public static char highSurrogate(int codePoint) {
        return (char) ((codePoint >> 10) + 0xd7c0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.763 -0400", hash_original_method = "ED18C5488875D7977019974254AC4633", hash_generated_method = "76CACD2B4965C51B79A8F0DD96135B8A")
    public static char lowSurrogate(int codePoint) {
        return (char) ((codePoint & 0x3ff) | 0xdc00);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.763 -0400", hash_original_method = "2C53B1D476DFDA53F515478C54D797C2", hash_generated_method = "6CC3F8314BB22C54E6C591E70F8FFC7B")
    public static boolean isBmpCodePoint(int codePoint) {
        return codePoint >= 0 && codePoint <= 0xffff;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.763 -0400", hash_original_method = "81B97EFCB1899F0273732CB1D268DB36", hash_generated_method = "2DD6EE83234FA7757A7B606FC293F43B")
    public static boolean isDefined(char c) {
        return isDefinedImpl(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.763 -0400", hash_original_method = "29588F3CD418602F0EF69BC1734C6254", hash_generated_method = "9AA1DA54F15D99778DFFA4BD82692285")
    public static boolean isDefined(int codePoint) {
        return isDefinedImpl(codePoint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.764 -0400", hash_original_method = "BA2C340F1A386E9F3EC0BA5846FE0962", hash_generated_method = "A07F091AE5BE4F24E8772BD24669A831")
    private static boolean isDefinedImpl(int codePoint) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.764 -0400", hash_original_method = "5ADE199AB33D628FF4C86910DA36B8AB", hash_generated_method = "42E12700736BB9E065543D5A29400F0E")
    public static boolean isDigit(char c) {
        return isDigit((int) c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.764 -0400", hash_original_method = "68C823D8D9E30AD74311CD8E57BB79FD", hash_generated_method = "142D07B848AB542D9BE1DA2D45C16D5F")
    public static boolean isDigit(int codePoint) {
        if ('0' <= codePoint && codePoint <= '9') {
            return true;
        }
        if (codePoint < 1632) {
            return false;
        }
        return isDigitImpl(codePoint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.764 -0400", hash_original_method = "F904076CF8ED09F6D0D155E03B5610A7", hash_generated_method = "0FA0ED862AECD4AB9FADA5F0EB0E01F9")
    private static boolean isDigitImpl(int codePoint) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.764 -0400", hash_original_method = "3060005E7173CF0D443847A582C02D7D", hash_generated_method = "26FBD37699A5E6F17DC0439805AFD705")
    public static boolean isIdentifierIgnorable(char c) {
        return isIdentifierIgnorable((int) c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.764 -0400", hash_original_method = "12FDF0DF3583E05536965003AB19E6D0", hash_generated_method = "13166660EAD882BFFA526F22F902D067")
    public static boolean isIdentifierIgnorable(int codePoint) {
        if (codePoint < 0x600) {
            return (codePoint >= 0 && codePoint <= 8) || (codePoint >= 0xe && codePoint <= 0x1b) ||
                    (codePoint >= 0x7f && codePoint <= 0x9f) || (codePoint == 0xad);
        }
        return isIdentifierIgnorableImpl(codePoint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.764 -0400", hash_original_method = "2A2AB9D0D4CBD87FC680B28F68076F12", hash_generated_method = "982218B622E2B2274763547E8F96FC33")
    private static boolean isIdentifierIgnorableImpl(int codePoint) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.764 -0400", hash_original_method = "02471F94F8A872CAA5DBEB3E98DF50DE", hash_generated_method = "C1662F72DC398FF54402916FC18586AB")
    public static boolean isISOControl(char c) {
        return isISOControl((int) c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.764 -0400", hash_original_method = "FE7A975C42B0FF6EDFA670F841892F5F", hash_generated_method = "4C1E1EBB936BB0413D89F4C4BAF42B1E")
    public static boolean isISOControl(int c) {
        return (c >= 0 && c <= 0x1f) || (c >= 0x7f && c <= 0x9f);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.764 -0400", hash_original_method = "F9C7B1CB3FEBF00FF413523F33E917A8", hash_generated_method = "64DD3792DD478F9FB316DCB11420D619")
    public static boolean isJavaIdentifierPart(char c) {
        return isJavaIdentifierPart((int) c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.764 -0400", hash_original_method = "4F1F7D3E12F4616733289A3F7EB4DC63", hash_generated_method = "E841032F7EEB6B019683FFE018C32496")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.764 -0400", hash_original_method = "D2C6EAA3E751B808447D604FB6D29517", hash_generated_method = "27B3A90E6485B3D9A0BC426A1CBFDEFB")
    public static boolean isJavaIdentifierStart(char c) {
        return isJavaIdentifierStart((int) c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.764 -0400", hash_original_method = "F7577C4689C2BEF45089F3ACFFDAD03A", hash_generated_method = "D41E494F8324E465AFE7F625DCDEC10C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.764 -0400", hash_original_method = "894B7941A639354EFA5A1447EF61D132", hash_generated_method = "085C53C5C1B90EEB9084DA90BFC3A5E8")
    @Deprecated
    public static boolean isJavaLetter(char c) {
        return isJavaIdentifierStart(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.764 -0400", hash_original_method = "82CCBEF7CE2F6615EFEE4A91C0BA2F9C", hash_generated_method = "422C6824B767C066DE9BAE5D3104F2DE")
    @Deprecated
    public static boolean isJavaLetterOrDigit(char c) {
        return isJavaIdentifierPart(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.764 -0400", hash_original_method = "7F4F394B7A0F8301F44F921567D26367", hash_generated_method = "32A3D276372BDCAB04526997529A6AE5")
    public static boolean isLetter(char c) {
        return isLetter((int) c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.764 -0400", hash_original_method = "7BDBB6EE44226312FBB7DF96FC7BF3DE", hash_generated_method = "35A84F948084B1DD9E50B661A119CBA6")
    public static boolean isLetter(int codePoint) {
        if (('A' <= codePoint && codePoint <= 'Z') || ('a' <= codePoint && codePoint <= 'z')) {
            return true;
        }
        if (codePoint < 128) {
            return false;
        }
        return isLetterImpl(codePoint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.764 -0400", hash_original_method = "B671C8CB4836F23CCDC793D8C06B6725", hash_generated_method = "0FB08F46807C63C8BB89F45D418CF373")
    private static boolean isLetterImpl(int codePoint) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.764 -0400", hash_original_method = "07424AD55498F7F8FBBB544D5FCCF9DD", hash_generated_method = "1530ABD48035BF9C774F5A5B50B67F62")
    public static boolean isLetterOrDigit(char c) {
        return isLetterOrDigit((int) c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.764 -0400", hash_original_method = "2AEE2538D487594FA64E74F73C7B1C5D", hash_generated_method = "F10950903EC744FBA69518321B130B6F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.764 -0400", hash_original_method = "3C7B38B03B018EEA897CD89E14D09984", hash_generated_method = "58AD72D52161DAF8BDF214C174B501BA")
    private static boolean isLetterOrDigitImpl(int codePoint) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.764 -0400", hash_original_method = "73BDBCA2665627024F8A18D3318C8DB8", hash_generated_method = "19BA20C32B3AE4D5ACF17271CBFDC670")
    public static boolean isLowerCase(char c) {
        return isLowerCase((int) c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.764 -0400", hash_original_method = "ADB5E41EE7B502A26DF78C97B20911AD", hash_generated_method = "0439778D78A156B7FE2FEC4E050D1167")
    public static boolean isLowerCase(int codePoint) {
        if ('a' <= codePoint && codePoint <= 'z') {
            return true;
        }
        if (codePoint < 128) {
            return false;
        }
        return isLowerCaseImpl(codePoint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.764 -0400", hash_original_method = "BA09C596C26CA8AA15B61529DE1EA5CB", hash_generated_method = "B3EAE94AC11671742B9ABBED6ED85880")
    private static boolean isLowerCaseImpl(int codePoint) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.764 -0400", hash_original_method = "1C3B61A184019B571D3EC162646AADA1", hash_generated_method = "08D480873CB522669215721714160554")
    @Deprecated
    public static boolean isSpace(char c) {
        return c == '\n' || c == '\t' || c == '\f' || c == '\r' || c == ' ';
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.764 -0400", hash_original_method = "5EA1910DE691C0C494DA1CD65B8AD3FB", hash_generated_method = "5AC456F721A8B07CFE0D43C462B3D7D7")
    public static boolean isSpaceChar(char c) {
        return isSpaceChar((int) c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.764 -0400", hash_original_method = "A9B3EEBBDFB6A55F67B5E3A75165CDD6", hash_generated_method = "5F8DCFFC54A7FDCF3608E9F5C2195FF4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.765 -0400", hash_original_method = "6B5A033B254409E9D1D4FA09A102D44E", hash_generated_method = "74057EF841BA310C92353E990D7AEFAD")
    private static boolean isSpaceCharImpl(int codePoint) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.765 -0400", hash_original_method = "084F70F38BAFAA7D7D5DCCB7F82C794B", hash_generated_method = "1C03C37486F31D9697FC7EBA06712FA0")
    public static boolean isTitleCase(char c) {
        return isTitleCaseImpl(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.765 -0400", hash_original_method = "530406D8340E661E297BE9C5D23D16FA", hash_generated_method = "B0C7199C831C093C330F98DF15541C87")
    public static boolean isTitleCase(int codePoint) {
        return isTitleCaseImpl(codePoint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.765 -0400", hash_original_method = "5D4C2B46F0A51AB70DF29B1A0552D734", hash_generated_method = "290045B1011D688D802B6CF3EA42DFFD")
    private static boolean isTitleCaseImpl(int codePoint) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.765 -0400", hash_original_method = "2413D525F1F2FBC6EE783A47B6048FA5", hash_generated_method = "86F84AC70263C31F92A614E837A3C613")
    public static boolean isUnicodeIdentifierPart(char c) {
        return isUnicodeIdentifierPartImpl(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.765 -0400", hash_original_method = "F0897994A34B93CFFEB1B8CB7B346E77", hash_generated_method = "A166C0ED27BA383B63976FA2F0D9F0DC")
    public static boolean isUnicodeIdentifierPart(int codePoint) {
        return isUnicodeIdentifierPartImpl(codePoint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.765 -0400", hash_original_method = "98A737EE3ABB813CF1439C9A0D88676D", hash_generated_method = "AFA711E89FED2B2E3716F6D4F73328CE")
    private static boolean isUnicodeIdentifierPartImpl(int codePoint) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.765 -0400", hash_original_method = "32D22A17AA82ABC9781B01DDEE5FEF29", hash_generated_method = "30C4EAA09D022FFC63275F8841A9834B")
    public static boolean isUnicodeIdentifierStart(char c) {
        return isUnicodeIdentifierStartImpl(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.765 -0400", hash_original_method = "EAAB05CCE538933E6B2EE13894209916", hash_generated_method = "7DBB32C2688BD2CE21DBADCCA8BA1E3D")
    public static boolean isUnicodeIdentifierStart(int codePoint) {
        return isUnicodeIdentifierStartImpl(codePoint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.765 -0400", hash_original_method = "19E0B88A41590772F2B6579654359C8A", hash_generated_method = "BC7F055DA1BBC081ECE86BF982BFE6E8")
    private static boolean isUnicodeIdentifierStartImpl(int codePoint) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.765 -0400", hash_original_method = "51D2DA544BFD2481CED21FC5653231F0", hash_generated_method = "28E52AFBCAA76F5FEED65620D475D8C5")
    public static boolean isUpperCase(char c) {
        return isUpperCase((int) c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.765 -0400", hash_original_method = "F0069BE3C05BFC7EED89F20634609A58", hash_generated_method = "19E4F72FD9BE2B3015DC41A0411E9CC0")
    public static boolean isUpperCase(int codePoint) {
        if ('A' <= codePoint && codePoint <= 'Z') {
            return true;
        }
        if (codePoint < 128) {
            return false;
        }
        return isUpperCaseImpl(codePoint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.765 -0400", hash_original_method = "5D4232B921B2097EACFE07B8CA79F206", hash_generated_method = "55E3EAB4CF41D7AFCDF50AC0DD827771")
    private static boolean isUpperCaseImpl(int codePoint) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.765 -0400", hash_original_method = "BD70D8F0870A48AB1ECFE4339B84BFEA", hash_generated_method = "E1645C1CBF3CF8A2D112E678E849FCD6")
    public static boolean isWhitespace(char c) {
        return isWhitespace((int) c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.765 -0400", hash_original_method = "EBC0D247F0203C6470AC61D5038CC471", hash_generated_method = "B5CA5B9AD7131CA83AE5C19BF76D7B31")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.765 -0400", hash_original_method = "13541F0E4A0D4F6FA23E865B664895DF", hash_generated_method = "FC9B03FF1DC2EB630A1E3510AC1510D1")
    private static boolean isWhitespaceImpl(int codePoint) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.765 -0400", hash_original_method = "C2BB18E49C39C3C8DD51F191BCC5B3D5", hash_generated_method = "3172C7A30AC9EA9D20E23D2663796EE5")
    public static char reverseBytes(char c) {
        return (char)((c<<8) | (c>>8));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.765 -0400", hash_original_method = "0D897DDA68232C66EB5005BC13278698", hash_generated_method = "39DD3E0FE93DCB6CA8480854DA182439")
    public static char toLowerCase(char c) {
        return (char) toLowerCase((int) c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.765 -0400", hash_original_method = "46554DD4C02B03BE2AD03A5664655738", hash_generated_method = "4FD35F342D65149E82AD89D9325C5B2A")
    public static int toLowerCase(int codePoint) {
        if ('A' <= codePoint && codePoint <= 'Z') {
            return (char) (codePoint + ('a' - 'A'));
        }
        if (codePoint < 192) {
            return codePoint;
        }
        return toLowerCaseImpl(codePoint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.765 -0400", hash_original_method = "BC02FA7C2EB83DBC36BD24E9BC8F5D01", hash_generated_method = "9F8F288EDE2E2B6CCC649773AD1A19DC")
    private static int toLowerCaseImpl(int codePoint) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.765 -0400", hash_original_method = "27F3E47E60B1213ECE72A0C1452319D1", hash_generated_method = "0AEA542B330B37C5D99F2D95C032BE35")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String varE56CB71A0102261E1E6B2E712053A166_1101000707 = (String.valueOf(value));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return String.valueOf(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.765 -0400", hash_original_method = "C0C76FDDC989F4AB02663C4A842CB735", hash_generated_method = "AEAE79DA8922F05782BBF3E4E55FD854")
    public static String toString(char value) {
        return String.valueOf(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.765 -0400", hash_original_method = "A4A9BAD50031A130761CE8D0E963613C", hash_generated_method = "04803B384C02AE9AAB58419BB2A08A22")
    public static char toTitleCase(char c) {
        return (char) toTitleCaseImpl(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.765 -0400", hash_original_method = "61A725C4B04EDED5F335FC945F33D736", hash_generated_method = "28B8F969BFA6773BFE7CC57387648DD2")
    public static int toTitleCase(int codePoint) {
        return toTitleCaseImpl(codePoint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.765 -0400", hash_original_method = "FE2B382CC43B1E9A80006125376CDF15", hash_generated_method = "77CC16A903DA16AEBE67922377BA7B4A")
    private static int toTitleCaseImpl(int codePoint) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.765 -0400", hash_original_method = "6F70DC22D940915BC069D6212605A1EF", hash_generated_method = "BEA5EA638AFD1B864D7F6CBC205605AF")
    public static char toUpperCase(char c) {
        return (char) toUpperCase((int) c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.765 -0400", hash_original_method = "8C765A659D796CF19325E431E5641ECE", hash_generated_method = "058759B7687D4A1055165554502F358C")
    public static int toUpperCase(int codePoint) {
        if ('a' <= codePoint && codePoint <= 'z') {
            return (char) (codePoint - ('a' - 'A'));
        }
        if (codePoint < 181) {
            return codePoint;
        }
        return toUpperCaseImpl(codePoint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.765 -0400", hash_original_method = "DA6B9550C074BDC69CBF47357D2E1CFA", hash_generated_method = "A32C0FEC0866250358980F33F070DD93")
    private static int toUpperCaseImpl(int codePoint) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    public static class Subset {
        String name;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.765 -0400", hash_original_method = "F864A542FCD1C844E1D83841069C7DB4", hash_generated_method = "0B469ECBE2E72D19DC6CEBEE4C86A194")
        @DSModeled(DSC.SAFE)
        protected Subset(String string) {
            dsTaint.addTaint(string);
            {
                throw new NullPointerException();
            } //End block
            // ---------- Original Method ----------
            //if (string == null) {
                //throw new NullPointerException();
            //}
            //name = string;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.765 -0400", hash_original_method = "4C72D63DD7600BBEA68526CF4A3E7570", hash_generated_method = "55DD09AB37F2B4860EFB0F9CDC4389D1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public final boolean equals(Object object) {
            dsTaint.addTaint(object.dsTaint);
            boolean varA3157AA9BC21D9DE63321077403F3F07_1857729860 = (super.equals(object));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return super.equals(object);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.766 -0400", hash_original_method = "BBCDAD7BF06FB621822DBBAD11355700", hash_generated_method = "20F2370A410E3A51A9132E3CC8FF245A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public final int hashCode() {
            int var7065CA1B738CD514456434D45E0A5A67_1569645044 = (super.hashCode());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return super.hashCode();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.766 -0400", hash_original_method = "0EB66BA5E965B83E191719250E0A82FF", hash_generated_method = "106E524F7DD5083F3F25D749353ACA76")
        @DSModeled(DSC.SAFE)
        @Override
        public final String toString() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return name;
        }

        
    }


    
    public static final class UnicodeBlock extends Subset {
        @Deprecated
        public static final UnicodeBlock SURROGATES_AREA = new UnicodeBlock("SURROGATES_AREA", 0x0, 0x0);
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.766 -0400", hash_original_method = "234E88093AAFC12110C9FE35072443BD", hash_generated_method = "1A0DDD9E9DF42098B5D19D004AD7A935")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private UnicodeBlock(String blockName, int start, int end) {
            super(blockName);
            dsTaint.addTaint(start);
            dsTaint.addTaint(blockName);
            dsTaint.addTaint(end);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.766 -0400", hash_original_method = "E9DB7390794C45C5DB1C50A23EEAE54D", hash_generated_method = "540C2841FB066D79347D7FF67B42E144")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.766 -0400", hash_original_method = "392D71CF093044293F2B368B3C851863", hash_generated_method = "37315607D83E4BDAF9961621E8257316")
        public static UnicodeBlock of(char c) {
            return of((int) c);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.766 -0400", hash_original_method = "C353B574FF2B3DDFEDDE0862E878329F", hash_generated_method = "B33A211A12366700A0DC5DADFEC12A20")
        public static UnicodeBlock of(int codePoint) {
            checkValidCodePoint(codePoint);
            int block = ofImpl(codePoint);
            if (block == -1 || block >= BLOCKS.length) {
                return null;
            }
            return BLOCKS[block];
        }

        
    }


    
    static {
        for (int i = 0; i < 128; i++) {
            SMALL_VALUES[i] = new Character((char) i);
        }
    }
    
}


