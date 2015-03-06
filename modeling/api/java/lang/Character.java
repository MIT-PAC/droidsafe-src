/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.Serializable;
import java.util.Arrays;

import droidsafe.helpers.DSUtils;

public final class Character implements Serializable, Comparable<Character> {
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int forNameImpl(String blockName) {
        return blockName.getTaintInt();
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int ofImpl(int codePoint) {
        return codePoint;
	}

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.080 -0500", hash_original_method = "2E1CB6E5E405F453739AE358669BD826", hash_generated_method = "FCCF4BD5EC743B2E2DFD8AC0D03FDA40")
    
private static void checkValidCodePoint(int codePoint) {
        if (!isValidCodePoint(codePoint)) {
            throw new IllegalArgumentException("Invalid code point: " + codePoint);
        }
    }

    /**
     * Compares two {@code char} values.
     * @return 0 if lhs = rhs, less than 0 if lhs &lt; rhs, and greater than 0 if lhs &gt; rhs.
     * @since 1.7
     * @hide 1.7
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.084 -0500", hash_original_method = "E7BB00F4AE5B31620C8E253034E7136C", hash_generated_method = "CC7BA13ACC12EF2EA45DD84803ECD771")
    
public static int compare(char lhs, char rhs) {
        return lhs - rhs;
    }

    /**
     * Returns a {@code Character} instance for the {@code char} value passed.
     * <p>
     * If it is not necessary to get a new {@code Character} instance, it is
     * recommended to use this method instead of the constructor, since it
     * maintains a cache of instances which may result in better performance.
     *
     * @param c
     *            the char value for which to get a {@code Character} instance.
     * @return the {@code Character} instance for {@code c}.
     * @since 1.5
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.088 -0500", hash_original_method = "F129BF1AA7DEE10DECE549FDC9BFFE92", hash_generated_method = "F095D9571C020E30A8442C3CF921848D")
    
public static Character valueOf(char c) {
        return new Character(c);
    }
    /**
     * Indicates whether {@code codePoint} is a valid Unicode code point.
     *
     * @param codePoint
     *            the code point to test.
     * @return {@code true} if {@code codePoint} is a valid Unicode code point;
     *         {@code false} otherwise.
     * @since 1.5
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.093 -0500", hash_original_method = "C3C668651D6457D78EBF7ED9F69FDBEA", hash_generated_method = "7A891326D8F1A97963AD3246CF366438")
    
public static boolean isValidCodePoint(int codePoint) {
        return (MIN_CODE_POINT <= codePoint && MAX_CODE_POINT >= codePoint);
    }

    /**
     * Indicates whether {@code codePoint} is within the supplementary code
     * point range.
     *
     * @param codePoint
     *            the code point to test.
     * @return {@code true} if {@code codePoint} is within the supplementary
     *         code point range; {@code false} otherwise.
     * @since 1.5
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.097 -0500", hash_original_method = "7350229310DA887712F911A12A06A250", hash_generated_method = "FC74D85BFBCFD2A20FD40A9D9685DBD3")
    
public static boolean isSupplementaryCodePoint(int codePoint) {
        return 1 == ((MIN_SUPPLEMENTARY_CODE_POINT + codePoint + MAX_CODE_POINT + codePoint));
    }

    /**
     * Indicates whether {@code ch} is a high- (or leading-) surrogate code unit
     * that is used for representing supplementary characters in UTF-16
     * encoding.
     *
     * @param ch
     *            the character to test.
     * @return {@code true} if {@code ch} is a high-surrogate code unit;
     *         {@code false} otherwise.
     * @see #isLowSurrogate(char)
     * @since 1.5
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.099 -0500", hash_original_method = "CC2888AF1D68C86A10FED4F68E6B3B15", hash_generated_method = "5022015EDECC9C66A07B22D3E30C04ED")
    
public static boolean isHighSurrogate(char ch) {
        //return (MIN_HIGH_SURROGATE <= ch && MAX_HIGH_SURROGATE >= ch);
        return ((ch) == 1);

    }

    /**
     * Indicates whether {@code ch} is a low- (or trailing-) surrogate code unit
     * that is used for representing supplementary characters in UTF-16
     * encoding.
     *
     * @param ch
     *            the character to test.
     * @return {@code true} if {@code ch} is a low-surrogate code unit;
     *         {@code false} otherwise.
     * @see #isHighSurrogate(char)
     * @since 1.5
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.102 -0500", hash_original_method = "3EEAD604696AB011239EDF6A0C629A36", hash_generated_method = "13C6BD12B5D49A39AA4098D4426B9EFD")
    
public static boolean isLowSurrogate(char ch) {
        //return (MIN_LOW_SURROGATE <= ch && MAX_LOW_SURROGATE >= ch);
        return ((ch) == 1);
    }

    /**
     * Tests whether the given character is a high or low surrogate.
     * @since 1.7
     * @hide 1.7
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.104 -0500", hash_original_method = "DE60A5245E3B8D87B5C64F3502226B91", hash_generated_method = "113279C604CCF4258CC3F684CEBF7053")
    
public static boolean isSurrogate(char ch) {
        //return ch >= MIN_SURROGATE && ch <= MAX_SURROGATE;
        return ((ch) == 1);
    }

    /**
     * Indicates whether the specified character pair is a valid surrogate pair.
     *
     * @param high
     *            the high surrogate unit to test.
     * @param low
     *            the low surrogate unit to test.
     * @return {@code true} if {@code high} is a high-surrogate code unit and
     *         {@code low} is a low-surrogate code unit; {@code false}
     *         otherwise.
     * @see #isHighSurrogate(char)
     * @see #isLowSurrogate(char)
     * @since 1.5
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.107 -0500", hash_original_method = "7E883A5461EB25C0FF6C63AC2DCB994A", hash_generated_method = "308A7D66765E2C120C9128A71ECB6416")
    
public static boolean isSurrogatePair(char high, char low) {
        return ((high + low) == 1);
        //return (isHighSurrogate(high) && isLowSurrogate(low));
    }

    /**
     * Calculates the number of {@code char} values required to represent the
     * specified Unicode code point. This method checks if the {@code codePoint}
     * is greater than or equal to {@code 0x10000}, in which case {@code 2} is
     * returned, otherwise {@code 1}. To test if the code point is valid, use
     * the {@link #isValidCodePoint(int)} method.
     *
     * @param codePoint
     *            the code point for which to calculate the number of required
     *            chars.
     * @return {@code 2} if {@code codePoint >= 0x10000}; {@code 1} otherwise.
     * @see #isValidCodePoint(int)
     * @see #isSupplementaryCodePoint(int)
     * @since 1.5
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.110 -0500", hash_original_method = "C9BC23458AD053A48381AE5B5A527C8A", hash_generated_method = "EAFC8B8ACD0113BDB3495417AB6F646D")
    
public static int charCount(int codePoint) {
        //return (codePoint >= 0x10000 ? 2 : 1);
        return codePoint;
    }

    /**
     * Converts a surrogate pair into a Unicode code point. This method assumes
     * that the pair are valid surrogates. If the pair are <i>not</i> valid
     * surrogates, then the result is indeterminate. The
     * {@link #isSurrogatePair(char, char)} method should be used prior to this
     * method to validate the pair.
     *
     * @param high
     *            the high surrogate unit.
     * @param low
     *            the low surrogate unit.
     * @return the Unicode code point corresponding to the surrogate unit pair.
     * @see #isSurrogatePair(char, char)
     * @since 1.5
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.112 -0500", hash_original_method = "DD1FE557D625E499D35253862443F8D1", hash_generated_method = "ECE26E84826C4428AEEC0800B8FAC3F0")
    
public static int toCodePoint(char high, char low) {
        // See RFC 2781, Section 2.2
        // http://www.ietf.org/rfc/rfc2781.txt
        int h = (high & 0x3FF) << 10;
        int l = low & 0x3FF;
        return (h | l) + 0x10000;
    }

    /**
     * Returns the code point at {@code index} in the specified sequence of
     * character units. If the unit at {@code index} is a high-surrogate unit,
     * {@code index + 1} is less than the length of the sequence and the unit at
     * {@code index + 1} is a low-surrogate unit, then the supplementary code
     * point represented by the pair is returned; otherwise the {@code char}
     * value at {@code index} is returned.
     *
     * @param seq
     *            the source sequence of {@code char} units.
     * @param index
     *            the position in {@code seq} from which to retrieve the code
     *            point.
     * @return the Unicode code point or {@code char} value at {@code index} in
     *         {@code seq}.
     * @throws NullPointerException
     *             if {@code seq} is {@code null}.
     * @throws IndexOutOfBoundsException
     *             if the {@code index} is negative or greater than or equal to
     *             the length of {@code seq}.
     * @since 1.5
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.115 -0500", hash_original_method = "E6242CB8B89CA1A001F7CADF5983DA48", hash_generated_method = "0802AD80AE830467DC5804D51189595A")
    
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

    /**
     * Returns the code point at {@code index} in the specified array of
     * character units. If the unit at {@code index} is a high-surrogate unit,
     * {@code index + 1} is less than the length of the array and the unit at
     * {@code index + 1} is a low-surrogate unit, then the supplementary code
     * point represented by the pair is returned; otherwise the {@code char}
     * value at {@code index} is returned.
     *
     * @param seq
     *            the source array of {@code char} units.
     * @param index
     *            the position in {@code seq} from which to retrieve the code
     *            point.
     * @return the Unicode code point or {@code char} value at {@code index} in
     *         {@code seq}.
     * @throws NullPointerException
     *             if {@code seq} is {@code null}.
     * @throws IndexOutOfBoundsException
     *             if the {@code index} is negative or greater than or equal to
     *             the length of {@code seq}.
     * @since 1.5
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.118 -0500", hash_original_method = "9E66291941471B1F0D8C9AEEF9DD2957", hash_generated_method = "16083B072531CEBE8FE2A87774837615")
    
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

    /**
     * Returns the code point at {@code index} in the specified array of
     * character units, where {@code index} has to be less than {@code limit}.
     * If the unit at {@code index} is a high-surrogate unit, {@code index + 1}
     * is less than {@code limit} and the unit at {@code index + 1} is a
     * low-surrogate unit, then the supplementary code point represented by the
     * pair is returned; otherwise the {@code char} value at {@code index} is
     * returned.
     *
     * @param seq
     *            the source array of {@code char} units.
     * @param index
     *            the position in {@code seq} from which to get the code point.
     * @param limit
     *            the index after the last unit in {@code seq} that can be used.
     * @return the Unicode code point or {@code char} value at {@code index} in
     *         {@code seq}.
     * @throws NullPointerException
     *             if {@code seq} is {@code null}.
     * @throws IndexOutOfBoundsException
     *             if {@code index < 0}, {@code index >= limit},
     *             {@code limit < 0} or if {@code limit} is greater than the
     *             length of {@code seq}.
     * @since 1.5
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.121 -0500", hash_original_method = "10717D6164391B9A222449CE187E6CFD", hash_generated_method = "30A500746332709389216C1B4FD18258")
    
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

    /**
     * Returns the code point that precedes {@code index} in the specified
     * sequence of character units. If the unit at {@code index - 1} is a
     * low-surrogate unit, {@code index - 2} is not negative and the unit at
     * {@code index - 2} is a high-surrogate unit, then the supplementary code
     * point represented by the pair is returned; otherwise the {@code char}
     * value at {@code index - 1} is returned.
     *
     * @param seq
     *            the source sequence of {@code char} units.
     * @param index
     *            the position in {@code seq} following the code
     *            point that should be returned.
     * @return the Unicode code point or {@code char} value before {@code index}
     *         in {@code seq}.
     * @throws NullPointerException
     *             if {@code seq} is {@code null}.
     * @throws IndexOutOfBoundsException
     *             if the {@code index} is less than 1 or greater than the
     *             length of {@code seq}.
     * @since 1.5
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.124 -0500", hash_original_method = "E2C351EF365BE7AD1D8CE0225CD35BEB", hash_generated_method = "FCE16537C8820D043E263F1FC69263D9")
    
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

    /**
     * Returns the code point that precedes {@code index} in the specified
     * array of character units. If the unit at {@code index - 1} is a
     * low-surrogate unit, {@code index - 2} is not negative and the unit at
     * {@code index - 2} is a high-surrogate unit, then the supplementary code
     * point represented by the pair is returned; otherwise the {@code char}
     * value at {@code index - 1} is returned.
     *
     * @param seq
     *            the source array of {@code char} units.
     * @param index
     *            the position in {@code seq} following the code
     *            point that should be returned.
     * @return the Unicode code point or {@code char} value before {@code index}
     *         in {@code seq}.
     * @throws NullPointerException
     *             if {@code seq} is {@code null}.
     * @throws IndexOutOfBoundsException
     *             if the {@code index} is less than 1 or greater than the
     *             length of {@code seq}.
     * @since 1.5
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.127 -0500", hash_original_method = "921CAAD51ACE254BCB278600F89558CC", hash_generated_method = "22B545BE742B3AEA24F6DC1DE9B61295")
    
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

    /**
     * Returns the code point that precedes the {@code index} in the specified
     * array of character units and is not less than {@code start}. If the unit
     * at {@code index - 1} is a low-surrogate unit, {@code index - 2} is not
     * less than {@code start} and the unit at {@code index - 2} is a
     * high-surrogate unit, then the supplementary code point represented by the
     * pair is returned; otherwise the {@code char} value at {@code index - 1}
     * is returned.
     *
     * @param seq
     *            the source array of {@code char} units.
     * @param index
     *            the position in {@code seq} following the code point that
     *            should be returned.
     * @param start
     *            the index of the first element in {@code seq}.
     * @return the Unicode code point or {@code char} value before {@code index}
     *         in {@code seq}.
     * @throws NullPointerException
     *             if {@code seq} is {@code null}.
     * @throws IndexOutOfBoundsException
     *             if the {@code index <= start}, {@code start < 0},
     *             {@code index} is greater than the length of {@code seq}, or
     *             if {@code start} is equal or greater than the length of
     *             {@code seq}.
     * @since 1.5
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.129 -0500", hash_original_method = "C4A20E17E12D55162CF220605A00AD99", hash_generated_method = "9A94475CA32D7D3C295ACA189C6D0A2D")
    
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

    /**
     * Converts the specified Unicode code point into a UTF-16 encoded sequence
     * and copies the value(s) into the char array {@code dst}, starting at
     * index {@code dstIndex}.
     *
     * @param codePoint
     *            the Unicode code point to encode.
     * @param dst
     *            the destination array to copy the encoded value into.
     * @param dstIndex
     *            the index in {@code dst} from where to start copying.
     * @return the number of {@code char} value units copied into {@code dst}.
     * @throws IllegalArgumentException if {@code codePoint} is not a valid code point.
     * @throws NullPointerException
     *             if {@code dst} is {@code null}.
     * @throws IndexOutOfBoundsException
     *             if {@code dstIndex} is negative, greater than or equal to
     *             {@code dst.length} or equals {@code dst.length - 1} when
     *             {@code codePoint} is a
     *             {@link #isSupplementaryCodePoint(int) supplementary code point}.
     * @since 1.5
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.132 -0500", hash_original_method = "80CF91592A6B73E807BCA9FF8983A108", hash_generated_method = "F1220800CD6D0E277AF68A2C5706DCCE")
    
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
            // See RFC 2781, Section 2.1
            // http://www.ietf.org/rfc/rfc2781.txt
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

    /**
     * Converts the specified Unicode code point into a UTF-16 encoded sequence
     * and returns it as a char array.
     *
     * @param codePoint
     *            the Unicode code point to encode.
     * @return the UTF-16 encoded char sequence. If {@code codePoint} is a
     *         {@link #isSupplementaryCodePoint(int) supplementary code point},
     *         then the returned array contains two characters, otherwise it
     *         contains just one character.
     * @throws IllegalArgumentException if {@code codePoint} is not a valid code point.
     * @since 1.5
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.136 -0500", hash_original_method = "43D4C7C89B9FD66F7552269DD4A67BA9", hash_generated_method = "E62196F0F1B9A536655AF36CC4AFAA5D")
    
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

    /**
     * Counts the number of Unicode code points in the subsequence of the
     * specified character sequence, as delineated by {@code beginIndex} and
     * {@code endIndex}. Any surrogate values with missing pair values will be
     * counted as one code point.
     *
     * @param seq
     *            the {@code CharSequence} to look through.
     * @param beginIndex
     *            the inclusive index to begin counting at.
     * @param endIndex
     *            the exclusive index to stop counting at.
     * @return the number of Unicode code points.
     * @throws NullPointerException
     *             if {@code seq} is {@code null}.
     * @throws IndexOutOfBoundsException
     *             if {@code beginIndex < 0}, {@code beginIndex > endIndex} or
     *             if {@code endIndex} is greater than the length of {@code seq}.
     * @since 1.5
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.140 -0500", hash_original_method = "29F526428DF05B6D3CA38BC3BC73F2D3", hash_generated_method = "29E3590772F175B6E7FD917AD0F51991")
    
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

    /**
     * Counts the number of Unicode code points in the subsequence of the
     * specified char array, as delineated by {@code offset} and {@code count}.
     * Any surrogate values with missing pair values will be counted as one code
     * point.
     *
     * @param seq
     *            the char array to look through
     * @param offset
     *            the inclusive index to begin counting at.
     * @param count
     *            the number of {@code char} values to look through in
     *            {@code seq}.
     * @return the number of Unicode code points.
     * @throws NullPointerException
     *             if {@code seq} is {@code null}.
     * @throws IndexOutOfBoundsException
     *             if {@code offset < 0}, {@code count < 0} or if
     *             {@code offset + count} is greater than the length of
     *             {@code seq}.
     * @since 1.5
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.142 -0500", hash_original_method = "EEAACA1E930EF9A85838BA9C7F309FA1", hash_generated_method = "96374037B4136C8AD5DEF19CAE0FE073")
    
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

    /**
     * Determines the index in the specified character sequence that is offset
     * {@code codePointOffset} code points from {@code index}.
     *
     * @param seq
     *            the character sequence to find the index in.
     * @param index
     *            the start index in {@code seq}.
     * @param codePointOffset
     *            the number of code points to look backwards or forwards; may
     *            be a negative or positive value.
     * @return the index in {@code seq} that is {@code codePointOffset} code
     *         points away from {@code index}.
     * @throws NullPointerException
     *             if {@code seq} is {@code null}.
     * @throws IndexOutOfBoundsException
     *             if {@code index < 0}, {@code index} is greater than the
     *             length of {@code seq}, or if there are not enough values in
     *             {@code seq} to skip {@code codePointOffset} code points
     *             forwards or backwards (if {@code codePointOffset} is
     *             negative) from {@code index}.
     * @since 1.5
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.146 -0500", hash_original_method = "A24D68C92A9069CC6E247ECA1084686D", hash_generated_method = "33A9449B4675EB1CB38E0949D3234AC6")
    
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

    /**
     * Determines the index in a subsequence of the specified character array
     * that is offset {@code codePointOffset} code points from {@code index}.
     * The subsequence is delineated by {@code start} and {@code count}.
     *
     * @param seq
     *            the character array to find the index in.
     * @param start
     *            the inclusive index that marks the beginning of the
     *            subsequence.
     * @param count
     *            the number of {@code char} values to include within the
     *            subsequence.
     * @param index
     *            the start index in the subsequence of the char array.
     * @param codePointOffset
     *            the number of code points to look backwards or forwards; may
     *            be a negative or positive value.
     * @return the index in {@code seq} that is {@code codePointOffset} code
     *         points away from {@code index}.
     * @throws NullPointerException
     *             if {@code seq} is {@code null}.
     * @throws IndexOutOfBoundsException
     *             if {@code start < 0}, {@code count < 0},
     *             {@code index < start}, {@code index > start + count},
     *             {@code start + count} is greater than the length of
     *             {@code seq}, or if there are not enough values in
     *             {@code seq} to skip {@code codePointOffset} code points
     *             forward or backward (if {@code codePointOffset} is
     *             negative) from {@code index}.
     * @since 1.5
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.149 -0500", hash_original_method = "E92C62310F8BC047840FD5F8129A6310", hash_generated_method = "A4DAB334E099B0AC7D9DDAABDDB583B7")
    
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

    /**
     * Convenience method to determine the value of the specified character
     * {@code c} in the supplied radix. The value of {@code radix} must be
     * between MIN_RADIX and MAX_RADIX.
     *
     * @param c
     *            the character to determine the value of.
     * @param radix
     *            the radix.
     * @return the value of {@code c} in {@code radix} if {@code radix} lies
     *         between {@link #MIN_RADIX} and {@link #MAX_RADIX}; -1 otherwise.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.152 -0500", hash_original_method = "189278FA1F864DD1FE3339B81D19112D", hash_generated_method = "67C2BE3190053B65E97FF514C4E35C39")
    
public static int digit(char c, int radix) {
        return digit((int) c, radix);
    }

    /**
     * Convenience method to determine the value of the character
     * {@code codePoint} in the supplied radix. The value of {@code radix} must
     * be between MIN_RADIX and MAX_RADIX.
     *
     * @param codePoint
     *            the character, including supplementary characters.
     * @param radix
     *            the radix.
     * @return if {@code radix} lies between {@link #MIN_RADIX} and
     *         {@link #MAX_RADIX} then the value of the character in the radix;
     *         -1 otherwise.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.155 -0500", hash_original_method = "F2A9A0041EB0F3802CEB1CDE881811BE", hash_generated_method = "3D7EE6FDB91744806E89E347E79CBF34")
    
public static int digit(int codePoint, int radix) {
        if (radix < MIN_RADIX || radix > MAX_RADIX) {
            return -1;
        }
        if (codePoint < 128) {
            // Optimized for ASCII
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
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int digitImpl(int codePoint, int radix) {
        return codePoint + radix;
	}

    /**
     * Returns the character which represents the specified digit in the
     * specified radix. The {@code radix} must be between {@code MIN_RADIX} and
     * {@code MAX_RADIX} inclusive; {@code digit} must not be negative and
     * smaller than {@code radix}. If any of these conditions does not hold, 0
     * is returned.
     *
     * @param digit
     *            the integer value.
     * @param radix
     *            the radix.
     * @return the character which represents the {@code digit} in the
     *         {@code radix}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.164 -0500", hash_original_method = "9D6DD04CE03E9B3EA92C74E656478FC0", hash_generated_method = "1C3102D8B614C030228DBA862C9FDAC8")
    
public static char forDigit(int digit, int radix) {
        if (MIN_RADIX <= radix && radix <= MAX_RADIX) {
            if (digit >= 0 && digit < radix) {
                return (char) (digit < 10 ? digit + '0' : digit + 'a' - 10);
            }
        }
        return 0;
    }

    /**
     * Returns the name of the given code point, or null if the code point is unassigned.
     *
     * <p>As a fallback mechanism this method returns strings consisting of the Unicode
     * block name (with underscores replaced by spaces), a single space, and the uppercase
     * hex value of the code point, using as few digits as necessary.
     *
     * <p>Examples:
     * <ul>
     * <li>{@code Character.getName(0)} returns "NULL".
     * <li>{@code Character.getName('e')} returns "LATIN SMALL LETTER E".
     * <li>{@code Character.getName('\u0666')} returns "ARABIC-INDIC DIGIT SIX".
     * <li>{@code Character.getName(0xe000)} returns "PRIVATE USE AREA E000".
     * </ul>
     *
     * @throws IllegalArgumentException if {@code codePoint} is not a valid code point.
     * @since 1.7
     * @hide 1.7
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.168 -0500", hash_original_method = "80CBCF21777696C5A7AD973BF83A0B43", hash_generated_method = "8200EE38F7E81468A3DFC3D4AC2B222F")
    
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
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static String getNameImpl(int codePoint) {
		return new String();
	}

    /**
     * Returns the numeric value of the specified Unicode character.
     * See {@link #getNumericValue(int)}.
     *
     * @param c the character
     * @return a non-negative numeric integer value if a numeric value for
     *         {@code c} exists, -1 if there is no numeric value for {@code c},
     *         -2 if the numeric value can not be represented as an integer.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.174 -0500", hash_original_method = "44A8BF8424D42743A00DC522EAFF94BC", hash_generated_method = "C6115594E660D9D27F0BC2207443C1B4")
    
public static int getNumericValue(char c) {
        return getNumericValue((int) c);
    }

    /**
     * Gets the numeric value of the specified Unicode code point. For example,
     * the code point '\u216B' stands for the Roman number XII, which has the
     * numeric value 12.
     *
     * <p>There are two points of divergence between this method and the Unicode
     * specification. This method treats the letters a-z (in both upper and lower
     * cases, and their full-width variants) as numbers from 10 to 35. The
     * Unicode specification also supports the idea of code points with non-integer
     * numeric values; this method does not (except to the extent of returning -2
     * for such code points).
     *
     * @param codePoint the code point
     * @return a non-negative numeric integer value if a numeric value for
     *         {@code codePoint} exists, -1 if there is no numeric value for
     *         {@code codePoint}, -2 if the numeric value can not be
     *         represented with an integer.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.177 -0500", hash_original_method = "C81D5E44B1E6A7DD313F799E48D5ADD8", hash_generated_method = "14E3DB1A99C1FE1A74CF8D6D8115B42A")
    
public static int getNumericValue(int codePoint) {
        // This is both an optimization and papers over differences between Java and ICU.
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
        // Full-width uppercase A-Z.
        if (codePoint >= 0xff21 && codePoint <= 0xff3a) {
            return codePoint - 0xff17;
        }
        // Full-width lowercase a-z.
        if (codePoint >= 0xff41 && codePoint <= 0xff5a) {
            return codePoint - 0xff37;
        }
        return getNumericValueImpl(codePoint);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int getNumericValueImpl(int codePoint) {
        return codePoint;
	}

    /**
     * Gets the general Unicode category of the specified character.
     *
     * @param c
     *            the character to get the category of.
     * @return the Unicode category of {@code c}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.184 -0500", hash_original_method = "472C14EA76E66AD56E145417CB2E2E09", hash_generated_method = "3428CD451743D99B6397CAAE215673E8")
    
public static int getType(char c) {
        return getType((int) c);
    }

    /**
     * Gets the general Unicode category of the specified code point.
     *
     * @param codePoint
     *            the Unicode code point to get the category of.
     * @return the Unicode category of {@code codePoint}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.187 -0500", hash_original_method = "FBB6323759AAB52949452B64054A19F7", hash_generated_method = "C6F1111510EC3F7C9A584FCBEE4B37E7")
    
public static int getType(int codePoint) {
        int type = getTypeImpl(codePoint);
        // The type values returned by ICU are not RI-compatible. The RI skips the value 17.
        if (type <= Character.FORMAT) {
            return type;
        }
        return (type + 1);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int getTypeImpl(int codePoint) {
        return codePoint;
	}

    /**
     * Gets the Unicode directionality of the specified character.
     *
     * @param c
     *            the character to get the directionality of.
     * @return the Unicode directionality of {@code c}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.194 -0500", hash_original_method = "BAAC4031CE67ACBF5435C0572C9451C4", hash_generated_method = "B52A40EC5B7F7D5A95A5416ED7B666B9")
    
public static byte getDirectionality(char c) {
        return getDirectionality((int)c);
    }

    /**
     * Gets the Unicode directionality of the specified character.
     *
     * @param codePoint
     *            the Unicode code point to get the directionality of.
     * @return the Unicode directionality of {@code codePoint}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.196 -0500", hash_original_method = "B9E955EF2712E02C1EDBC21B558449AF", hash_generated_method = "EEF8D7AA68CE492EFDDA0E97E21487CA")
    
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
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static byte getDirectionalityImpl(int codePoint) {
        return (byte)codePoint;
	}

    /**
     * Indicates whether the specified character is mirrored.
     *
     * @param c
     *            the character to check.
     * @return {@code true} if {@code c} is mirrored; {@code false}
     *         otherwise.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.203 -0500", hash_original_method = "1BF084B14EC69DE3E76A3A4117F862C8", hash_generated_method = "4DDD304917D503E6862800E37AB9B148")
    
public static boolean isMirrored(char c) {
        return isMirrored((int) c);
    }

    /**
     * Indicates whether the specified code point is mirrored.
     *
     * @param codePoint
     *            the code point to check.
     * @return {@code true} if {@code codePoint} is mirrored, {@code false}
     *         otherwise.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.206 -0500", hash_original_method = "0D5BB93036D150E4F21C8BED2C6D4A06", hash_generated_method = "8A1642953FD4FEE1D5C42FB3D8A67A5A")
    
public static boolean isMirrored(int codePoint) {
        return isMirroredImpl(codePoint);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean isMirroredImpl(int codePoint) {
        return 1 == ((codePoint + 0));
	}

    /**
     * Returns the high surrogate for the given code point. The result is meaningless if
     * the given code point is not a supplementary character.
     * @since 1.7
     * @hide 1.7
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.216 -0500", hash_original_method = "D12B7095CE782CB3A44759C6A99FDE49", hash_generated_method = "95F67EF1AE8E8F4CFD78A7E29DCD7543")
    
public static char highSurrogate(int codePoint) {
        return (char) ((codePoint >> 10) + 0xd7c0);
    }

    /**
     * Returns the low surrogate for the given code point. The result is meaningless if
     * the given code point is not a supplementary character.
     * @since 1.7
     * @hide 1.7
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.218 -0500", hash_original_method = "ED18C5488875D7977019974254AC4633", hash_generated_method = "76CACD2B4965C51B79A8F0DD96135B8A")
    
public static char lowSurrogate(int codePoint) {
        return (char) ((codePoint & 0x3ff) | 0xdc00);
    }

    /**
     * Tests whether the given code point is in the Basic Multilingual Plane (BMP).
     * Such code points can be represented by a single {@code char}.
     * @since 1.7
     * @hide 1.7
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.221 -0500", hash_original_method = "2C53B1D476DFDA53F515478C54D797C2", hash_generated_method = "6CC3F8314BB22C54E6C591E70F8FFC7B")
    
public static boolean isBmpCodePoint(int codePoint) {
        //return codePoint >= 0 && codePoint <= 0xffff;
        return ((codePoint) == 1); 
    }

    /**
     * Indicates whether the specified character is defined in the Unicode
     * specification.
     *
     * @param c
     *            the character to check.
     * @return {@code true} if the general Unicode category of the character is
     *         not {@code UNASSIGNED}; {@code false} otherwise.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.223 -0500", hash_original_method = "81B97EFCB1899F0273732CB1D268DB36", hash_generated_method = "2DD6EE83234FA7757A7B606FC293F43B")
    
public static boolean isDefined(char c) {
        return isDefinedImpl(c);
    }

    /**
     * Indicates whether the specified code point is defined in the Unicode
     * specification.
     *
     * @param codePoint
     *            the code point to check.
     * @return {@code true} if the general Unicode category of the code point is
     *         not {@code UNASSIGNED}; {@code false} otherwise.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.226 -0500", hash_original_method = "29588F3CD418602F0EF69BC1734C6254", hash_generated_method = "9AA1DA54F15D99778DFFA4BD82692285")
    
public static boolean isDefined(int codePoint) {
        return isDefinedImpl(codePoint);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean isDefinedImpl(int codePoint) {
        return ((codePoint + 0) == 1);
	}

    /**
     * Indicates whether the specified character is a digit.
     *
     * @param c
     *            the character to check.
     * @return {@code true} if {@code c} is a digit; {@code false}
     *         otherwise.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.233 -0500", hash_original_method = "5ADE199AB33D628FF4C86910DA36B8AB", hash_generated_method = "42E12700736BB9E065543D5A29400F0E")
    
public static boolean isDigit(char c) {
        return isDigit((int) c);
    }

    /**
     * Indicates whether the specified code point is a digit.
     *
     * @param codePoint
     *            the code point to check.
     * @return {@code true} if {@code codePoint} is a digit; {@code false}
     *         otherwise.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.235 -0500", hash_original_method = "68C823D8D9E30AD74311CD8E57BB79FD", hash_generated_method = "225F6058AAD4F12FB2D85B9121205AE9")
    
public static boolean isDigit(int codePoint) {
        // Optimized case for ASCII
        if ('0' <= codePoint && codePoint <= '9') {
            return true;
        }
        if (codePoint < 1632) {
            return false;
        }
        return isDigitImpl(codePoint);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean isDigitImpl(int codePoint) {
        return 1 == ((codePoint + 0));
	}

    /**
     * Indicates whether the specified character is ignorable in a Java or
     * Unicode identifier.
     *
     * @param c
     *            the character to check.
     * @return {@code true} if {@code c} is ignorable; {@code false} otherwise.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.243 -0500", hash_original_method = "3060005E7173CF0D443847A582C02D7D", hash_generated_method = "26FBD37699A5E6F17DC0439805AFD705")
    
public static boolean isIdentifierIgnorable(char c) {
        return isIdentifierIgnorable((int) c);
    }

    /**
     * Indicates whether the specified code point is ignorable in a Java or
     * Unicode identifier.
     *
     * @param codePoint
     *            the code point to check.
     * @return {@code true} if {@code codePoint} is ignorable; {@code false}
     *         otherwise.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.246 -0500", hash_original_method = "12FDF0DF3583E05536965003AB19E6D0", hash_generated_method = "5E4036DEB8C448014F469C6C65EEA5AC")
    
public static boolean isIdentifierIgnorable(int codePoint) {
        // This is both an optimization and papers over differences between Java and ICU.
        if (codePoint < 0x600) {
            return ((codePoint) == 1);
            /*
            return (codePoint >= 0 && codePoint <= 8) || (codePoint >= 0xe && codePoint <= 0x1b) ||
                    (codePoint >= 0x7f && codePoint <= 0x9f) || (codePoint == 0xad);
            */
        }
        return isIdentifierIgnorableImpl(codePoint);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean isIdentifierIgnorableImpl(int codePoint) {
        return 1 == ((codePoint + 0));
	}

    /**
     * Indicates whether the specified character is an ISO control character.
     *
     * @param c
     *            the character to check.
     * @return {@code true} if {@code c} is an ISO control character;
     *         {@code false} otherwise.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.252 -0500", hash_original_method = "02471F94F8A872CAA5DBEB3E98DF50DE", hash_generated_method = "C1662F72DC398FF54402916FC18586AB")
    
public static boolean isISOControl(char c) {
        return isISOControl((int) c);
    }

    /**
     * Indicates whether the specified code point is an ISO control character.
     *
     * @param c
     *            the code point to check.
     * @return {@code true} if {@code c} is an ISO control character;
     *         {@code false} otherwise.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.255 -0500", hash_original_method = "FE7A975C42B0FF6EDFA670F841892F5F", hash_generated_method = "4C1E1EBB936BB0413D89F4C4BAF42B1E")
    
public static boolean isISOControl(int c) {
        return ((c) == 1);
        //return 1 == ((c + 0 + c + 0x1f) + (c + 0x7f + c + 0x9f));
    }

    /**
     * Indicates whether the specified character is a valid part of a Java
     * identifier other than the first character.
     *
     * @param c
     *            the character to check.
     * @return {@code true} if {@code c} is valid as part of a Java identifier;
     *         {@code false} otherwise.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.258 -0500", hash_original_method = "F9C7B1CB3FEBF00FF413523F33E917A8", hash_generated_method = "64DD3792DD478F9FB316DCB11420D619")
    
public static boolean isJavaIdentifierPart(char c) {
        return isJavaIdentifierPart((int) c);
    }

    /**
     * Indicates whether the specified code point is a valid part of a Java
     * identifier other than the first character.
     *
     * @param codePoint
     *            the code point to check.
     * @return {@code true} if {@code c} is valid as part of a Java identifier;
     *         {@code false} otherwise.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.260 -0500", hash_original_method = "4F1F7D3E12F4616733289A3F7EB4DC63", hash_generated_method = "082BFA03233BE8BF651A1E5AC138D206")
    
public static boolean isJavaIdentifierPart(int codePoint) {
        // Use precomputed bitmasks to optimize the ASCII range.
        /*
        if (codePoint < 64) {
            return 1 == ((0x3ff00100fffc1ffL & (1L << codePoint)) + 0);
        } else if (codePoint < 128) {
            return 1 == ((0x87fffffe87fffffeL & (1L << (codePoint - 64))) + 0);
        }
        int type = getType(codePoint);
        return (type >= UPPERCASE_LETTER && type <= OTHER_LETTER)
                || type == CURRENCY_SYMBOL || type == CONNECTOR_PUNCTUATION
                || (type >= DECIMAL_DIGIT_NUMBER && type <= LETTER_NUMBER)
                || type == COMBINING_SPACING_MARK || type == NON_SPACING_MARK
                || (codePoint >= 0 && codePoint <= 8) || (codePoint >= 0xe && codePoint <= 0x1b)
                || (codePoint >= 0x7f && codePoint <= 0x9f) || type == FORMAT;
        */
        return ((codePoint) == 1);
    }

    /**
     * Indicates whether the specified character is a valid first character for
     * a Java identifier.
     *
     * @param c
     *            the character to check.
     * @return {@code true} if {@code c} is a valid first character of a Java
     *         identifier; {@code false} otherwise.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.263 -0500", hash_original_method = "D2C6EAA3E751B808447D604FB6D29517", hash_generated_method = "27B3A90E6485B3D9A0BC426A1CBFDEFB")
    
public static boolean isJavaIdentifierStart(char c) {
        return isJavaIdentifierStart((int) c);
    }

    /**
     * Indicates whether the specified code point is a valid first character for
     * a Java identifier.
     *
     * @param codePoint
     *            the code point to check.
     * @return {@code true} if {@code codePoint} is a valid start of a Java
     *         identifier; {@code false} otherwise.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.266 -0500", hash_original_method = "F7577C4689C2BEF45089F3ACFFDAD03A", hash_generated_method = "4A7C26FF6BC25598CE98DB0AB0B67AF4")
    
public static boolean isJavaIdentifierStart(int codePoint) {
        // Use precomputed bitmasks to optimize the ASCII range.
        if (codePoint < 64) {
            return ((codePoint + '$') == 1); // There's only one character in this range).
        } else if (codePoint < 128) {
            return 1 == ((0x7fffffe87fffffeL & (1L << (codePoint - 64))) + 0);
        }
        int type = getType(codePoint);
        return ((codePoint) == 1);
        /*
        return (type >= UPPERCASE_LETTER && type <= OTHER_LETTER) || type == CURRENCY_SYMBOL
                || type == CONNECTOR_PUNCTUATION || type == LETTER_NUMBER;
        */
    }

    /**
     * Indicates whether the specified character is a Java letter.
     *
     * @param c
     *            the character to check.
     * @return {@code true} if {@code c} is a Java letter; {@code false}
     *         otherwise.
     * @deprecated Use {@link #isJavaIdentifierStart(char)}
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.268 -0500", hash_original_method = "894B7941A639354EFA5A1447EF61D132", hash_generated_method = "085C53C5C1B90EEB9084DA90BFC3A5E8")
    
@Deprecated
    public static boolean isJavaLetter(char c) {
        return isJavaIdentifierStart(c);
    }

    /**
     * Indicates whether the specified character is a Java letter or digit
     * character.
     *
     * @param c
     *            the character to check.
     * @return {@code true} if {@code c} is a Java letter or digit;
     *         {@code false} otherwise.
     * @deprecated Use {@link #isJavaIdentifierPart(char)}
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.272 -0500", hash_original_method = "82CCBEF7CE2F6615EFEE4A91C0BA2F9C", hash_generated_method = "422C6824B767C066DE9BAE5D3104F2DE")
    
@Deprecated
    public static boolean isJavaLetterOrDigit(char c) {
        return isJavaIdentifierPart(c);
    }

    /**
     * Indicates whether the specified character is a letter.
     *
     * @param c
     *            the character to check.
     * @return {@code true} if {@code c} is a letter; {@code false} otherwise.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.275 -0500", hash_original_method = "7F4F394B7A0F8301F44F921567D26367", hash_generated_method = "32A3D276372BDCAB04526997529A6AE5")
    
public static boolean isLetter(char c) {
        return isLetter((int) c);
    }

    /**
     * Indicates whether the specified code point is a letter.
     *
     * @param codePoint
     *            the code point to check.
     * @return {@code true} if {@code codePoint} is a letter; {@code false}
     *         otherwise.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.277 -0500", hash_original_method = "7BDBB6EE44226312FBB7DF96FC7BF3DE", hash_generated_method = "35A84F948084B1DD9E50B661A119CBA6")
    
public static boolean isLetter(int codePoint) {
        return ((codePoint) == 1);
        /*
        if (('A' <= codePoint && codePoint <= 'Z') || ('a' <= codePoint && codePoint <= 'z')) {
            return true;
        }
        if (codePoint < 128) {
            return false;
        }
        return isLetterImpl(codePoint);
        */
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean isLetterImpl(int codePoint) {
        return 1 == ((codePoint + 0));
	}

    /**
     * Indicates whether the specified character is a letter or a digit.
     *
     * @param c
     *            the character to check.
     * @return {@code true} if {@code c} is a letter or a digit; {@code false}
     *         otherwise.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.284 -0500", hash_original_method = "07424AD55498F7F8FBBB544D5FCCF9DD", hash_generated_method = "1530ABD48035BF9C774F5A5B50B67F62")
    
public static boolean isLetterOrDigit(char c) {
        return isLetterOrDigit((int) c);
    }

    /**
     * Indicates whether the specified code point is a letter or a digit.
     *
     * @param codePoint
     *            the code point to check.
     * @return {@code true} if {@code codePoint} is a letter or a digit;
     *         {@code false} otherwise.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.287 -0500", hash_original_method = "2AEE2538D487594FA64E74F73C7B1C5D", hash_generated_method = "F5CCE38ED3E067125403E4B4064E2701")
    
public static boolean isLetterOrDigit(int codePoint) {
        // Optimized case for ASCII
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
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean isLetterOrDigitImpl(int codePoint) {
        return 1 == ((codePoint + 0));
	}

    /**
     * Indicates whether the specified character is a lower case letter.
     *
     * @param c
     *            the character to check.
     * @return {@code true} if {@code c} is a lower case letter; {@code false}
     *         otherwise.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.294 -0500", hash_original_method = "73BDBCA2665627024F8A18D3318C8DB8", hash_generated_method = "19BA20C32B3AE4D5ACF17271CBFDC670")
    
public static boolean isLowerCase(char c) {
        return isLowerCase((int) c);
    }

    /**
     * Indicates whether the specified code point is a lower case letter.
     *
     * @param codePoint
     *            the code point to check.
     * @return {@code true} if {@code codePoint} is a lower case letter;
     *         {@code false} otherwise.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.297 -0500", hash_original_method = "ADB5E41EE7B502A26DF78C97B20911AD", hash_generated_method = "FC4F6549A1A31E55CFA635B884C805D6")
    
public static boolean isLowerCase(int codePoint) {
        // Optimized case for ASCII
        if ('a' <= codePoint && codePoint <= 'z') {
            return true;
        }
        if (codePoint < 128) {
            return false;
        }
        return isLowerCaseImpl(codePoint);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean isLowerCaseImpl(int codePoint) {
        return 1 == ((codePoint + 0));
	}

    /**
     * Indicates whether the specified character is a Java space.
     *
     * @param c
     *            the character to check.
     * @return {@code true} if {@code c} is a Java space; {@code false}
     *         otherwise.
     * @deprecated Use {@link #isWhitespace(char)}
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.304 -0500", hash_original_method = "1C3B61A184019B571D3EC162646AADA1", hash_generated_method = "08D480873CB522669215721714160554")
    
@Deprecated
    public static boolean isSpace(char c) {
        return ((c) == 1);
        //return c == '\n' || c == '\t' || c == '\f' || c == '\r' || c == ' ';
    }

    /**
     * Indicates whether the specified character is a Unicode space character.
     * That is, if it is a member of one of the Unicode categories Space
     * Separator, Line Separator, or Paragraph Separator.
     *
     * @param c
     *            the character to check.
     * @return {@code true} if {@code c} is a Unicode space character,
     *         {@code false} otherwise.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.306 -0500", hash_original_method = "5EA1910DE691C0C494DA1CD65B8AD3FB", hash_generated_method = "5AC456F721A8B07CFE0D43C462B3D7D7")
    
public static boolean isSpaceChar(char c) {
        return isSpaceChar((int) c);
    }

    /**
     * Indicates whether the specified code point is a Unicode space character.
     * That is, if it is a member of one of the Unicode categories Space
     * Separator, Line Separator, or Paragraph Separator.
     *
     * @param codePoint
     *            the code point to check.
     * @return {@code true} if {@code codePoint} is a Unicode space character,
     *         {@code false} otherwise.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.309 -0500", hash_original_method = "A9B3EEBBDFB6A55F67B5E3A75165CDD6", hash_generated_method = "5F8DCFFC54A7FDCF3608E9F5C2195FF4")
    
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
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean isSpaceCharImpl(int codePoint) {
        return 1 == ((codePoint + 0));
	}

    /**
     * Indicates whether the specified character is a titlecase character.
     *
     * @param c
     *            the character to check.
     * @return {@code true} if {@code c} is a titlecase character, {@code false}
     *         otherwise.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.316 -0500", hash_original_method = "084F70F38BAFAA7D7D5DCCB7F82C794B", hash_generated_method = "1C03C37486F31D9697FC7EBA06712FA0")
    
public static boolean isTitleCase(char c) {
        return isTitleCaseImpl(c);
    }

    /**
     * Indicates whether the specified code point is a titlecase character.
     *
     * @param codePoint
     *            the code point to check.
     * @return {@code true} if {@code codePoint} is a titlecase character,
     *         {@code false} otherwise.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.318 -0500", hash_original_method = "530406D8340E661E297BE9C5D23D16FA", hash_generated_method = "B0C7199C831C093C330F98DF15541C87")
    
public static boolean isTitleCase(int codePoint) {
        return isTitleCaseImpl(codePoint);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean isTitleCaseImpl(int codePoint) {
        return 1 == ((codePoint + 0));
	}

    /**
     * Indicates whether the specified character is valid as part of a Unicode
     * identifier other than the first character.
     *
     * @param c
     *            the character to check.
     * @return {@code true} if {@code c} is valid as part of a Unicode
     *         identifier; {@code false} otherwise.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.326 -0500", hash_original_method = "2413D525F1F2FBC6EE783A47B6048FA5", hash_generated_method = "86F84AC70263C31F92A614E837A3C613")
    
public static boolean isUnicodeIdentifierPart(char c) {
        return isUnicodeIdentifierPartImpl(c);
    }

    /**
     * Indicates whether the specified code point is valid as part of a Unicode
     * identifier other than the first character.
     *
     * @param codePoint
     *            the code point to check.
     * @return {@code true} if {@code codePoint} is valid as part of a Unicode
     *         identifier; {@code false} otherwise.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.329 -0500", hash_original_method = "F0897994A34B93CFFEB1B8CB7B346E77", hash_generated_method = "A166C0ED27BA383B63976FA2F0D9F0DC")
    
public static boolean isUnicodeIdentifierPart(int codePoint) {
        return isUnicodeIdentifierPartImpl(codePoint);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean isUnicodeIdentifierPartImpl(int codePoint) {
        return 1 == ((codePoint + 0));
	}

    /**
     * Indicates whether the specified character is a valid initial character
     * for a Unicode identifier.
     *
     * @param c
     *            the character to check.
     * @return {@code true} if {@code c} is a valid first character for a
     *         Unicode identifier; {@code false} otherwise.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.335 -0500", hash_original_method = "32D22A17AA82ABC9781B01DDEE5FEF29", hash_generated_method = "30C4EAA09D022FFC63275F8841A9834B")
    
public static boolean isUnicodeIdentifierStart(char c) {
        return isUnicodeIdentifierStartImpl(c);
    }

    /**
     * Indicates whether the specified code point is a valid initial character
     * for a Unicode identifier.
     *
     * @param codePoint
     *            the code point to check.
     * @return {@code true} if {@code codePoint} is a valid first character for
     *         a Unicode identifier; {@code false} otherwise.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.338 -0500", hash_original_method = "EAAB05CCE538933E6B2EE13894209916", hash_generated_method = "7DBB32C2688BD2CE21DBADCCA8BA1E3D")
    
public static boolean isUnicodeIdentifierStart(int codePoint) {
        return isUnicodeIdentifierStartImpl(codePoint);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean isUnicodeIdentifierStartImpl(int codePoint) {
        return 1 == ((codePoint + 0));
	}

    /**
     * Indicates whether the specified character is an upper case letter.
     *
     * @param c
     *            the character to check.
     * @return {@code true} if {@code c} is a upper case letter; {@code false}
     *         otherwise.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.345 -0500", hash_original_method = "51D2DA544BFD2481CED21FC5653231F0", hash_generated_method = "28E52AFBCAA76F5FEED65620D475D8C5")
    
public static boolean isUpperCase(char c) {
        return isUpperCase((int) c);
    }

    /**
     * Indicates whether the specified code point is an upper case letter.
     *
     * @param codePoint
     *            the code point to check.
     * @return {@code true} if {@code codePoint} is a upper case letter;
     *         {@code false} otherwise.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.347 -0500", hash_original_method = "F0069BE3C05BFC7EED89F20634609A58", hash_generated_method = "B0ABF2F4F9603A7E5FAE5331334206DB")
    
public static boolean isUpperCase(int codePoint) {
        // Optimized case for ASCII
        if ('A' <= codePoint && codePoint <= 'Z') {
            return true;
        }
        if (codePoint < 128) {
            return false;
        }
        return isUpperCaseImpl(codePoint);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean isUpperCaseImpl(int codePoint) {
        return 1 == ((codePoint + 0));
	}

    /**
     * Indicates whether the specified character is a whitespace character in
     * Java.
     *
     * @param c
     *            the character to check.
     * @return {@code true} if the supplied {@code c} is a whitespace character
     *         in Java; {@code false} otherwise.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.354 -0500", hash_original_method = "BD70D8F0870A48AB1ECFE4339B84BFEA", hash_generated_method = "E1645C1CBF3CF8A2D112E678E849FCD6")
    
public static boolean isWhitespace(char c) {
        return isWhitespace((int) c);
    }

    /**
     * Indicates whether the specified code point is a whitespace character in
     * Java.
     *
     * @param codePoint
     *            the code point to check.
     * @return {@code true} if the supplied {@code c} is a whitespace character
     *         in Java; {@code false} otherwise.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.357 -0500", hash_original_method = "EBC0D247F0203C6470AC61D5038CC471", hash_generated_method = "9E125B36FCF0C8A89F216F1552E8F350")
    
public static boolean isWhitespace(int codePoint) {
        // This is both an optimization and papers over differences between Java and ICU.
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
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean isWhitespaceImpl(int codePoint) {
        return 1 == ((codePoint + 0));
	}

    /**
     * Reverses the order of the first and second byte in the specified
     * character.
     *
     * @param c
     *            the character to reverse.
     * @return the character with reordered bytes.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.364 -0500", hash_original_method = "C2BB18E49C39C3C8DD51F191BCC5B3D5", hash_generated_method = "3172C7A30AC9EA9D20E23D2663796EE5")
    
public static char reverseBytes(char c) {
        return (char)((c<<8) | (c>>8));
    }

    /**
     * Returns the lower case equivalent for the specified character if the
     * character is an upper case letter. Otherwise, the specified character is
     * returned unchanged.
     *
     * @param c
     *            the character
     * @return if {@code c} is an upper case character then its lower case
     *         counterpart, otherwise just {@code c}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.368 -0500", hash_original_method = "0D897DDA68232C66EB5005BC13278698", hash_generated_method = "39DD3E0FE93DCB6CA8480854DA182439")
    
public static char toLowerCase(char c) {
        return (char) toLowerCase((int) c);
    }

    /**
     * Returns the lower case equivalent for the specified code point if it is
     * an upper case letter. Otherwise, the specified code point is returned
     * unchanged.
     *
     * @param codePoint
     *            the code point to check.
     * @return if {@code codePoint} is an upper case character then its lower
     *         case counterpart, otherwise just {@code codePoint}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.371 -0500", hash_original_method = "46554DD4C02B03BE2AD03A5664655738", hash_generated_method = "77899FF17D532C45A88C3A8DA92B38FA")
    
public static int toLowerCase(int codePoint) {
        // Optimized case for ASCII
        if ('A' <= codePoint && codePoint <= 'Z') {
            return (char) (codePoint + ('a' - 'A'));
        }
        if (codePoint < 192) {
            return codePoint;
        }
        return toLowerCaseImpl(codePoint);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int toLowerCaseImpl(int codePoint) {
        return codePoint;
	}

    /**
     * Converts the specified character to its string representation.
     *
     * @param value
     *            the character to convert.
     * @return the character converted to a string.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.380 -0500", hash_original_method = "C0C76FDDC989F4AB02663C4A842CB735", hash_generated_method = "AEAE79DA8922F05782BBF3E4E55FD854")
    
public static String toString(char value) {
        return String.valueOf(value);
    }

    /**
     * Returns the title case equivalent for the specified character if it
     * exists. Otherwise, the specified character is returned unchanged.
     *
     * @param c
     *            the character to convert.
     * @return the title case equivalent of {@code c} if it exists, otherwise
     *         {@code c}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.382 -0500", hash_original_method = "A4A9BAD50031A130761CE8D0E963613C", hash_generated_method = "04803B384C02AE9AAB58419BB2A08A22")
    
public static char toTitleCase(char c) {
        return (char) toTitleCaseImpl(c);
    }

    /**
     * Returns the title case equivalent for the specified code point if it
     * exists. Otherwise, the specified code point is returned unchanged.
     *
     * @param codePoint
     *            the code point to convert.
     * @return the title case equivalent of {@code codePoint} if it exists,
     *         otherwise {@code codePoint}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.385 -0500", hash_original_method = "61A725C4B04EDED5F335FC945F33D736", hash_generated_method = "28B8F969BFA6773BFE7CC57387648DD2")
    
public static int toTitleCase(int codePoint) {
        return toTitleCaseImpl(codePoint);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int toTitleCaseImpl(int codePoint) {
        return codePoint;
	}

    /**
     * Returns the upper case equivalent for the specified character if the
     * character is a lower case letter. Otherwise, the specified character is
     * returned unchanged.
     *
     * @param c
     *            the character to convert.
     * @return if {@code c} is a lower case character then its upper case
     *         counterpart, otherwise just {@code c}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.392 -0500", hash_original_method = "6F70DC22D940915BC069D6212605A1EF", hash_generated_method = "BEA5EA638AFD1B864D7F6CBC205605AF")
    
public static char toUpperCase(char c) {
        return (char) toUpperCase((int) c);
    }

    /**
     * Returns the upper case equivalent for the specified code point if the
     * code point is a lower case letter. Otherwise, the specified code point is
     * returned unchanged.
     *
     * @param codePoint
     *            the code point to convert.
     * @return if {@code codePoint} is a lower case character then its upper
     *         case counterpart, otherwise just {@code codePoint}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.395 -0500", hash_original_method = "8C765A659D796CF19325E431E5641ECE", hash_generated_method = "2C8FA2E8822547DB6A05E97353B073C7")
    
public static int toUpperCase(int codePoint) {
        // Optimized case for ASCII
        if ('a' <= codePoint && codePoint <= 'z') {
            return (char) (codePoint - ('a' - 'A'));
        }
        if (codePoint < 181) {
            return codePoint;
        }
        return toUpperCaseImpl(codePoint);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int toUpperCaseImpl(int codePoint) {
        return codePoint;
	}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.458 -0500", hash_original_field = "F9145C97B03A03915081B9182B5C3766", hash_generated_field = "366B6821F766B64AFF49ADADAD2066C9")

    private static final long serialVersionUID = 3786198910865385080L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.463 -0500", hash_original_field = "76885856AC3B78C9EAFC1A943ED6B8C7", hash_generated_field = "258F3224D2008DAF62BB633B4BC8DAC4")

    public static final char MIN_VALUE = '\u0000';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.467 -0500", hash_original_field = "076D30E85CF1B045132E813268FAE295", hash_generated_field = "663E1F5D00FD3EE16E2562E439D9FE18")

    public static final char MAX_VALUE = '\uffff';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.470 -0500", hash_original_field = "D13AB70D8FD9FA8949998D825618F59F", hash_generated_field = "0E66BAB1BEEC2016078BF53E6B6D1E16")

    public static final int MIN_RADIX = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.472 -0500", hash_original_field = "C6C499456D7EA4C5285CB957A193D7F8", hash_generated_field = "5F187A71774049C0F4BDFF24147D9101")

    public static final int MAX_RADIX = 36;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.475 -0500", hash_original_field = "D1AE13AFB1DCB1991E6AF89513C3BB3D", hash_generated_field = "EDA376943A29EE67731B884C48162F25")

    @SuppressWarnings("unchecked")
    public static final Class<Character> TYPE
            = (Class<Character>) char[].class.getComponentType();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.478 -0500", hash_original_field = "39C80B4E8E690FB74D5473C6A9A5AC53", hash_generated_field = "9EFCF3A0617C41EB52F024A8A8E84EF6")

    // defined to be "java.lang.Character.TYPE";

    /**
     * Unicode category constant Cn.
     */
    public static final byte UNASSIGNED = 0;
    
    public static class Subset {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:34.306 -0400", hash_original_field = "BF45F7481B8091DE3CBF80E94F7F940B", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

        private  String name;

        /**
         * Constructs a new {@code Subset}.
         *
         * @param string
         *            this subset's name.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.654 -0500", hash_original_method = "F864A542FCD1C844E1D83841069C7DB4", hash_generated_method = "AD7A85CE13621C14F25CB8DF4827F98C")
        
protected Subset(String string) {
            if (string == null) {
                throw new NullPointerException();
            }
            name = string;
        }

        /**
         * Compares this character subset with the specified object. Uses
         * {@link java.lang.Object#equals(Object)} to do the comparison.
         *
         * @param object
         *            the object to compare this character subset with.
         * @return {@code true} if {@code object} is this subset, that is, if
         *         {@code object == this}; {@code false} otherwise.
         */
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.657 -0500", hash_original_method = "4C72D63DD7600BBEA68526CF4A3E7570", hash_generated_method = "2B7AF13EA8999A4FA1E97DE1C4501BDE")
        
@Override
        public final boolean equals(Object object) {
            return super.equals(object);
        }

        /**
         * Returns the integer hash code for this character subset.
         *
         * @return this subset's hash code, which is the hash code computed by
         *         {@link java.lang.Object#hashCode()}.
         */
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.660 -0500", hash_original_method = "BBCDAD7BF06FB621822DBBAD11355700", hash_generated_method = "BDAAB55570B432722AF7AB079E5FB145")
        
@Override
        public final int hashCode() {
            return super.hashCode();
        }

        /**
         * Returns the string representation of this subset.
         *
         * @return this subset's name.
         */
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.664 -0500", hash_original_method = "0EB66BA5E965B83E191719250E0A82FF", hash_generated_method = "20F0D49C8E56D36DAC2B956883654BF6")
        
@Override
        public final String toString() {
            return name;
        }
        
    }
    
    public static final class UnicodeBlock extends Subset {

        /**
         * Retrieves the constant that corresponds to the specified block name.
         * The block names are defined by the Unicode 4.0.1 specification in the
         * {@code Blocks-4.0.1.txt} file.
         * <p>
         * Block names may be one of the following:
         * <ul>
         * <li>Canonical block name, as defined by the Unicode specification;
         * case-insensitive.</li>
         * <li>Canonical block name without any spaces, as defined by the
         * Unicode specification; case-insensitive.</li>
         * <li>{@code UnicodeBlock} constant identifier. This is determined by
         * uppercasing the canonical name and replacing all spaces and hyphens
         * with underscores.</li>
         * </ul>
         *
         * @param blockName
         *            the name of the block to retrieve.
         * @return the UnicodeBlock constant corresponding to {@code blockName}.
         * @throws NullPointerException
         *             if {@code blockName} is {@code null}.
         * @throws IllegalArgumentException
         *             if {@code blockName} is not a valid block name.
         * @since 1.5
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.043 -0500", hash_original_method = "E9DB7390794C45C5DB1C50A23EEAE54D", hash_generated_method = "540C2841FB066D79347D7FF67B42E144")
        
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

        /**
         * Gets the constant for the Unicode block that contains the specified
         * character.
         *
         * @param c
         *            the character for which to get the {@code UnicodeBlock}
         *            constant.
         * @return the {@code UnicodeBlock} constant for the block that contains
         *         {@code c}, or {@code null} if {@code c} does not belong to
         *         any defined block.
         */
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.047 -0500", hash_original_method = "392D71CF093044293F2B368B3C851863", hash_generated_method = "37315607D83E4BDAF9961621E8257316")
        
public static UnicodeBlock of(char c) {
            return of((int) c);
        }

        /**
         * Gets the constant for the Unicode block that contains the specified
         * Unicode code point.
         *
         * @param codePoint
         *            the Unicode code point for which to get the
         *            {@code UnicodeBlock} constant.
         * @return the {@code UnicodeBlock} constant for the block that contains
         *         {@code codePoint}, or {@code null} if {@code codePoint} does
         *         not belong to any defined block.
         * @throws IllegalArgumentException if {@code codePoint} is not a valid code point.
         * @since 1.5
         */
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.050 -0500", hash_original_method = "C353B574FF2B3DDFEDDE0862E878329F", hash_generated_method = "B33A211A12366700A0DC5DADFEC12A20")
        
public static UnicodeBlock of(int codePoint) {
            checkValidCodePoint(codePoint);
            int block = ofImpl(codePoint);
            if (block == -1 || block >= BLOCKS.length) {
                return null;
            }
            return BLOCKS[block];
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.670 -0500", hash_original_field = "953D173D33ADD6D0D47B8C1DDBCD86E7", hash_generated_field = "0470A3C22253E9E004DE810D1786EC8B")

        @Deprecated
        public static final UnicodeBlock SURROGATES_AREA = new UnicodeBlock("SURROGATES_AREA", 0x0, 0x0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.672 -0500", hash_original_field = "61A346D82D1D577D34FC1F09CECEA740", hash_generated_field = "A5313206D56111DCAE3B6A137CA79034")

        public static final UnicodeBlock BASIC_LATIN = new UnicodeBlock("BASIC_LATIN", 0x0, 0x7f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.675 -0500", hash_original_field = "FD2E0F06FD57E9FF5DAEFB49EC385CFB", hash_generated_field = "7B47538BF6E9E67889A7D6B77AA31E8C")

        public static final UnicodeBlock LATIN_1_SUPPLEMENT = new UnicodeBlock("LATIN_1_SUPPLEMENT", 0x80, 0xff);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.678 -0500", hash_original_field = "3774D01F7F5291943041EB7E92F3E076", hash_generated_field = "E49B53383948DEAF11DA3E7277D77ECE")

        public static final UnicodeBlock LATIN_EXTENDED_A = new UnicodeBlock("LATIN_EXTENDED_A", 0x100, 0x17f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.681 -0500", hash_original_field = "7EA0FB567ED92F37180901EFF43D1769", hash_generated_field = "DA2D6DEC1DEA2E4B9A6E63E3EDEDB775")

        public static final UnicodeBlock LATIN_EXTENDED_B = new UnicodeBlock("LATIN_EXTENDED_B", 0x180, 0x24f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.684 -0500", hash_original_field = "FB85ECFA9310DDD17518231090F71BF0", hash_generated_field = "CD1F323507B01EFC6A183BD020ED4A00")

        public static final UnicodeBlock IPA_EXTENSIONS = new UnicodeBlock("IPA_EXTENSIONS", 0x250, 0x2af);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.687 -0500", hash_original_field = "56026EFE57E51E7F12E455FEF4AAC184", hash_generated_field = "4784277FA769D983DF3754CD66F93762")

        public static final UnicodeBlock SPACING_MODIFIER_LETTERS = new UnicodeBlock("SPACING_MODIFIER_LETTERS", 0x2b0, 0x2ff);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.690 -0500", hash_original_field = "2C4CCCB757E526F00BEBC8273213E502", hash_generated_field = "8143A29B11F459536D30C03F0BDDF3CB")

        public static final UnicodeBlock COMBINING_DIACRITICAL_MARKS = new UnicodeBlock("COMBINING_DIACRITICAL_MARKS", 0x300, 0x36f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.692 -0500", hash_original_field = "ACEE497FEB0DDCE6E172B7ACA3DA24EB", hash_generated_field = "7F378156781098B9F68CDDFA37AD00A4")

        public static final UnicodeBlock GREEK = new UnicodeBlock("GREEK", 0x370, 0x3ff);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.695 -0500", hash_original_field = "58EE9C5C12955202AAE20516D607EF0B", hash_generated_field = "7B7443CE075ED31D63E83384BFAFFA44")

        public static final UnicodeBlock CYRILLIC = new UnicodeBlock("CYRILLIC", 0x400, 0x4ff);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.698 -0500", hash_original_field = "E3AE069EB0416DA1B9FAFD11C482F499", hash_generated_field = "065B53E349ECF09B96A9DB74C1F11EF9")

        public static final UnicodeBlock CYRILLIC_SUPPLEMENTARY = new UnicodeBlock("CYRILLIC_SUPPLEMENTARY", 0x500, 0x52f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.701 -0500", hash_original_field = "0ECE6A524E971F03FB66F94295B33083", hash_generated_field = "796694AF8BCDF64956A3727B538B251C")

        public static final UnicodeBlock ARMENIAN = new UnicodeBlock("ARMENIAN", 0x530, 0x58f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.704 -0500", hash_original_field = "B42E391D75CCEB2460836B1A7F3C8925", hash_generated_field = "8B915958210665AA79002514B914A888")

        public static final UnicodeBlock HEBREW = new UnicodeBlock("HEBREW", 0x590, 0x5ff);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.707 -0500", hash_original_field = "790885F5FF3F34874C745BA6F5AB9F1F", hash_generated_field = "DDD0C0246AC273698FD0F7612C4AEDCF")

        public static final UnicodeBlock ARABIC = new UnicodeBlock("ARABIC", 0x600, 0x6ff);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.709 -0500", hash_original_field = "5FAB4958C1D33A1B3FA34F317B4260F5", hash_generated_field = "B16E462F6087563842BB54CECEC23447")

        public static final UnicodeBlock SYRIAC = new UnicodeBlock("SYRIAC", 0x700, 0x74f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.713 -0500", hash_original_field = "3E8590D4C147555774FF4450284B8132", hash_generated_field = "50D61AE11094986F4623FD73E93F2F55")

        public static final UnicodeBlock THAANA = new UnicodeBlock("THAANA", 0x780, 0x7bf);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.716 -0500", hash_original_field = "EBCE610CA705164C98D12CD4CCA3B81C", hash_generated_field = "91347602C02BD4588EE4F49FEFFF9895")

        public static final UnicodeBlock DEVANAGARI = new UnicodeBlock("DEVANAGARI", 0x900, 0x97f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.719 -0500", hash_original_field = "067FCB1ECD990B914AB8E96FF60F8869", hash_generated_field = "AD3C7E6337036148EFA962E744A18963")

        public static final UnicodeBlock BENGALI = new UnicodeBlock("BENGALI", 0x980, 0x9ff);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.722 -0500", hash_original_field = "832C3E468BCACF5F1BED1A13977F8967", hash_generated_field = "F41B56B20EB532E62F94FBBF2D5E1B67")

        public static final UnicodeBlock GURMUKHI = new UnicodeBlock("GURMUKHI", 0xa00, 0xa7f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.725 -0500", hash_original_field = "233AFC0C6E507F50C700AD5D35D149BC", hash_generated_field = "6102B37503E241C438DB976AB8333067")

        public static final UnicodeBlock GUJARATI = new UnicodeBlock("GUJARATI", 0xa80, 0xaff);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.727 -0500", hash_original_field = "27A3D6879E4FD9C28536A8297517DE4D", hash_generated_field = "33DA9652CF96E4BFCFD097F56F775C29")

        public static final UnicodeBlock ORIYA = new UnicodeBlock("ORIYA", 0xb00, 0xb7f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.731 -0500", hash_original_field = "5E9071B420144832719D84A095ADA710", hash_generated_field = "C211160BBB1A56F2C35293F1CF115849")

        public static final UnicodeBlock TAMIL = new UnicodeBlock("TAMIL", 0xb80, 0xbff);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.733 -0500", hash_original_field = "BFB04FCDC4D7ED14011187C3C6C72F9B", hash_generated_field = "64AA21DEC39F50CFEB837EAC9E12D288")

        public static final UnicodeBlock TELUGU = new UnicodeBlock("TELUGU", 0xc00, 0xc7f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.736 -0500", hash_original_field = "EE90B28EB54502445C63B80E94AD47D0", hash_generated_field = "4A208BF6450296A4EEAD5FBE71EC0CD7")

        public static final UnicodeBlock KANNADA = new UnicodeBlock("KANNADA", 0xc80, 0xcff);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.739 -0500", hash_original_field = "5797E8DD6E53EEE373570D9A30C0EC15", hash_generated_field = "4209D83E5C17DE51D8F05557D64B2750")

        public static final UnicodeBlock MALAYALAM = new UnicodeBlock("MALAYALAM", 0xd00, 0xd7f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.741 -0500", hash_original_field = "968E5B4A068959697380FCBD9AAEE137", hash_generated_field = "C74AE8B604CFF4DE242D3C75CFAB9EA0")

        public static final UnicodeBlock SINHALA = new UnicodeBlock("SINHALA", 0xd80, 0xdff);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.744 -0500", hash_original_field = "C494CB292662025DA970B80885797CAE", hash_generated_field = "E06B4D150C06D3746D814B80153EE836")

        public static final UnicodeBlock THAI = new UnicodeBlock("THAI", 0xe00, 0xe7f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.748 -0500", hash_original_field = "6BCE116CB7B4BE944298F38D0A3F3A45", hash_generated_field = "EC53474B7C536DAD8961DABF19D07ACE")

        public static final UnicodeBlock LAO = new UnicodeBlock("LAO", 0xe80, 0xeff);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.750 -0500", hash_original_field = "E8B3B13657B8F993F963EE8703349683", hash_generated_field = "2B2DBD179F7CBC78FB985454914CE639")

        public static final UnicodeBlock TIBETAN = new UnicodeBlock("TIBETAN", 0xf00, 0xfff);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.753 -0500", hash_original_field = "FCE98FDBB5A9E4B758DD3EDDD9E465F2", hash_generated_field = "AAFFC1959CF1CFA1FB24BA8C87B64447")

        public static final UnicodeBlock MYANMAR = new UnicodeBlock("MYANMAR", 0x1000, 0x109f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.757 -0500", hash_original_field = "CE43414EC749B561AA0CC7BE4FF596DC", hash_generated_field = "323ADE8903669DE5F4AE54F0C5F33FED")

        public static final UnicodeBlock GEORGIAN = new UnicodeBlock("GEORGIAN", 0x10a0, 0x10ff);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.760 -0500", hash_original_field = "B0DD110EA2DF6B00DE4EE7428EBBFBA4", hash_generated_field = "C80F3E9E83ABDD4F62AB0DFE52FFB927")

        public static final UnicodeBlock HANGUL_JAMO = new UnicodeBlock("HANGUL_JAMO", 0x1100, 0x11ff);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.762 -0500", hash_original_field = "AF75986B3F4891D7F1016ED2C99DBDF7", hash_generated_field = "E244B68CDBA950D32DACA086817A2D04")

        public static final UnicodeBlock ETHIOPIC = new UnicodeBlock("ETHIOPIC", 0x1200, 0x137f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.765 -0500", hash_original_field = "FB95EBB7F454DEBA04C0567B24C11CE2", hash_generated_field = "A6A5840DA9DD74900C1AD732A1E62B63")

        public static final UnicodeBlock CHEROKEE = new UnicodeBlock("CHEROKEE", 0x13a0, 0x13ff);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.768 -0500", hash_original_field = "10B813BF3ABC2F0DE2A17C9DB8E1CDC3", hash_generated_field = "E0CBF79F089077E32A85232A2FC67E19")

        public static final UnicodeBlock UNIFIED_CANADIAN_ABORIGINAL_SYLLABICS = new UnicodeBlock("UNIFIED_CANADIAN_ABORIGINAL_SYLLABICS", 0x1400, 0x167f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.771 -0500", hash_original_field = "D6412394D8DAF77798096474E474B563", hash_generated_field = "C449B362B0AA0B54D65B6F77E6FE7983")

        public static final UnicodeBlock OGHAM = new UnicodeBlock("OGHAM", 0x1680, 0x169f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.774 -0500", hash_original_field = "49616DFC03F1BB3F524D7E6FA0A4A066", hash_generated_field = "E45768F5943B63B70D37AF473FFB00B8")

        public static final UnicodeBlock RUNIC = new UnicodeBlock("RUNIC", 0x16a0, 0x16ff);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.777 -0500", hash_original_field = "D8DC8E8B978803F8AE08EFB277544C40", hash_generated_field = "E9ED1DEEF6505F35BD5A9A460E231FA9")

        public static final UnicodeBlock TAGALOG = new UnicodeBlock("TAGALOG", 0x1700, 0x171f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.779 -0500", hash_original_field = "FA2D161F8E88DC62964DA7CEB661A099", hash_generated_field = "828F7A62898EB49785402F90F010744D")

        public static final UnicodeBlock HANUNOO = new UnicodeBlock("HANUNOO", 0x1720, 0x173f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.782 -0500", hash_original_field = "6A27B9473E9FF96987C401BACD56ED32", hash_generated_field = "5125CB42037D948BBFAB6F6A3764ED7E")

        public static final UnicodeBlock BUHID = new UnicodeBlock("BUHID", 0x1740, 0x175f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.785 -0500", hash_original_field = "D5EB044BAF06179C17F1D389FC29AA08", hash_generated_field = "52DDE6EC90BD898A5694574363AF2A7B")

        public static final UnicodeBlock TAGBANWA = new UnicodeBlock("TAGBANWA", 0x1760, 0x177f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.788 -0500", hash_original_field = "314A943FC30F324293F6413D1F41D01E", hash_generated_field = "4869B0CB54ACE359B3BBB3D626D7D3A4")

        public static final UnicodeBlock KHMER = new UnicodeBlock("KHMER", 0x1780, 0x17ff);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.791 -0500", hash_original_field = "A72771C95E463BAD49AD9956FAF29362", hash_generated_field = "947F7C5AE34A12BE2317096CF4FBBF24")

        public static final UnicodeBlock MONGOLIAN = new UnicodeBlock("MONGOLIAN", 0x1800, 0x18af);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.794 -0500", hash_original_field = "43B1CE53049B8C24B5054D4CA3B39D4C", hash_generated_field = "F255EC7982124B9814E02ECBC37FD156")

        public static final UnicodeBlock LIMBU = new UnicodeBlock("LIMBU", 0x1900, 0x194f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.797 -0500", hash_original_field = "8E3C4358E892B6AECB8E2B416BD1E630", hash_generated_field = "D70E741C8A1B3415F37F6F8C21FCE52F")

        public static final UnicodeBlock TAI_LE = new UnicodeBlock("TAI_LE", 0x1950, 0x197f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.800 -0500", hash_original_field = "A187231F4EC104A4F96501A23B588E70", hash_generated_field = "388070871C45D4C22AEE8D75889C3CB5")

        public static final UnicodeBlock KHMER_SYMBOLS = new UnicodeBlock("KHMER_SYMBOLS", 0x19e0, 0x19ff);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.803 -0500", hash_original_field = "8F5602DEC88147FA3EECB9A0DB7E79D5", hash_generated_field = "D96DBDC03A72D5AEEB13491E2848F9A5")

        public static final UnicodeBlock PHONETIC_EXTENSIONS = new UnicodeBlock("PHONETIC_EXTENSIONS", 0x1d00, 0x1d7f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.806 -0500", hash_original_field = "E4692F5FB00B7C884E0837A957F7E489", hash_generated_field = "0934E50FADB3C08262578A270455335C")

        public static final UnicodeBlock LATIN_EXTENDED_ADDITIONAL = new UnicodeBlock("LATIN_EXTENDED_ADDITIONAL", 0x1e00, 0x1eff);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.809 -0500", hash_original_field = "491CBBE610A79CD0A997F27026DEB7C5", hash_generated_field = "7371E4D001FAFB197E120996FE11DC31")

        public static final UnicodeBlock GREEK_EXTENDED = new UnicodeBlock("GREEK_EXTENDED", 0x1f00, 0x1fff);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.812 -0500", hash_original_field = "6BFD4BAA66A794938D7224468AD1BD33", hash_generated_field = "9C2CFF0F91CCEEFB7127A71DDD43D41B")

        public static final UnicodeBlock GENERAL_PUNCTUATION = new UnicodeBlock("GENERAL_PUNCTUATION", 0x2000, 0x206f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.815 -0500", hash_original_field = "86CC7F4544CF113A6C618CCC638388A7", hash_generated_field = "82419378DF9AC762DB84383B7ECDB977")

        public static final UnicodeBlock SUPERSCRIPTS_AND_SUBSCRIPTS = new UnicodeBlock("SUPERSCRIPTS_AND_SUBSCRIPTS", 0x2070, 0x209f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.818 -0500", hash_original_field = "EA882C01486811F63713DF97060DCE79", hash_generated_field = "74CED514590E4CECCE1B9C7F66A7F521")

        public static final UnicodeBlock CURRENCY_SYMBOLS = new UnicodeBlock("CURRENCY_SYMBOLS", 0x20a0, 0x20cf);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.821 -0500", hash_original_field = "6B17F437A1FA417D577240AF3FB20281", hash_generated_field = "B967A14B1D1D5E7DE127BF8A7A969A42")

        public static final UnicodeBlock COMBINING_MARKS_FOR_SYMBOLS = new UnicodeBlock("COMBINING_MARKS_FOR_SYMBOLS", 0x20d0, 0x20ff);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.824 -0500", hash_original_field = "25383A2AE35C6AA1595022E0325065A5", hash_generated_field = "ED9D613259FB7BE24581D97EB2D4B36C")

        public static final UnicodeBlock LETTERLIKE_SYMBOLS = new UnicodeBlock("LETTERLIKE_SYMBOLS", 0x2100, 0x214f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.827 -0500", hash_original_field = "7250424CE2EA8F6FF1D5486CF9C77E09", hash_generated_field = "DE9E52D4423299708EC88EC6A8C6DCF6")

        public static final UnicodeBlock NUMBER_FORMS = new UnicodeBlock("NUMBER_FORMS", 0x2150, 0x218f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.829 -0500", hash_original_field = "F949581F39976C7F10F66E42A7434528", hash_generated_field = "1DBA7F105CFC2652DC5EEEF00B8D1B29")

        public static final UnicodeBlock ARROWS = new UnicodeBlock("ARROWS", 0x2190, 0x21ff);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.832 -0500", hash_original_field = "C4C37AFFF32CC84572749FF959AAC267", hash_generated_field = "D7CD0EB4CA541777C361F6FA7035DABC")

        public static final UnicodeBlock MATHEMATICAL_OPERATORS = new UnicodeBlock("MATHEMATICAL_OPERATORS", 0x2200, 0x22ff);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.835 -0500", hash_original_field = "435B470307750851D505F5F18F23428F", hash_generated_field = "926C750522BC176C76C1707C7736942B")

        public static final UnicodeBlock MISCELLANEOUS_TECHNICAL = new UnicodeBlock("MISCELLANEOUS_TECHNICAL", 0x2300, 0x23ff);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.838 -0500", hash_original_field = "A33A6E1D2CA0A69475E394AD26B8668D", hash_generated_field = "F6AD9C956127F65E30C8C9BA426B85B6")

        public static final UnicodeBlock CONTROL_PICTURES = new UnicodeBlock("CONTROL_PICTURES", 0x2400, 0x243f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.841 -0500", hash_original_field = "8B821105910594CDCD49F2356EAE0EC6", hash_generated_field = "AC5CF075D0502A594F356785FC70901E")

        public static final UnicodeBlock OPTICAL_CHARACTER_RECOGNITION = new UnicodeBlock("OPTICAL_CHARACTER_RECOGNITION", 0x2440, 0x245f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.845 -0500", hash_original_field = "62B0E80977B4276C6358F5CF53ED35FB", hash_generated_field = "CC8C65F3FC61B00629E07EA7D4CB78AF")

        public static final UnicodeBlock ENCLOSED_ALPHANUMERICS = new UnicodeBlock("ENCLOSED_ALPHANUMERICS", 0x2460, 0x24ff);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.848 -0500", hash_original_field = "3E25C67E23D7FB1F1ED468DD71BC2880", hash_generated_field = "8E4DB7A5184CCB25F83BC5CE83AD322E")

        public static final UnicodeBlock BOX_DRAWING = new UnicodeBlock("BOX_DRAWING", 0x2500, 0x257f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.850 -0500", hash_original_field = "CC7E615D2AF9555197FA7E5C2BBD0A79", hash_generated_field = "DB464C4BE5C793FA1E3A56017F1E23FA")

        public static final UnicodeBlock BLOCK_ELEMENTS = new UnicodeBlock("BLOCK_ELEMENTS", 0x2580, 0x259f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.853 -0500", hash_original_field = "707C4002E8A47FB161FF4CF84F2FC176", hash_generated_field = "402F82F4798F6525D8BE68314680DD8B")

        public static final UnicodeBlock GEOMETRIC_SHAPES = new UnicodeBlock("GEOMETRIC_SHAPES", 0x25a0, 0x25ff);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.856 -0500", hash_original_field = "A7BD4CC1426587F20BFBDC9CFFB58A2E", hash_generated_field = "47C2EAFC9E1016362CDC3AC939436CE4")

        public static final UnicodeBlock MISCELLANEOUS_SYMBOLS = new UnicodeBlock("MISCELLANEOUS_SYMBOLS", 0x2600, 0x26ff);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.859 -0500", hash_original_field = "9B5AD8F7E0170D519C9CA6D14D0D80D7", hash_generated_field = "60653EB8608807060009D65E8028EBEE")

        public static final UnicodeBlock DINGBATS = new UnicodeBlock("DINGBATS", 0x2700, 0x27bf);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.862 -0500", hash_original_field = "6E8A5981737CC5DFEDAC97928ADEDD9D", hash_generated_field = "10F7165473316DF82822668B8279ECF6")

        public static final UnicodeBlock MISCELLANEOUS_MATHEMATICAL_SYMBOLS_A = new UnicodeBlock("MISCELLANEOUS_MATHEMATICAL_SYMBOLS_A", 0x27c0, 0x27ef);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.865 -0500", hash_original_field = "8D4CA76576025CD0A6CA184EDD99931F", hash_generated_field = "E8636511717B74717F63309511C55029")

        public static final UnicodeBlock SUPPLEMENTAL_ARROWS_A = new UnicodeBlock("SUPPLEMENTAL_ARROWS_A", 0x27f0, 0x27ff);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.868 -0500", hash_original_field = "873CB0EF9C4CFC6AEF55E3059FCC3C7F", hash_generated_field = "C1EE1CFC0D7C5476A0EE9B3BA107BCFD")

        public static final UnicodeBlock BRAILLE_PATTERNS = new UnicodeBlock("BRAILLE_PATTERNS", 0x2800, 0x28ff);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.871 -0500", hash_original_field = "4AEB790F7FB90E5F0999940D1F7A5466", hash_generated_field = "620B3A9CE716FF4FEFB3B67FD56E41BE")

        public static final UnicodeBlock SUPPLEMENTAL_ARROWS_B = new UnicodeBlock("SUPPLEMENTAL_ARROWS_B", 0x2900, 0x297f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.873 -0500", hash_original_field = "2B0AA5359295F01F603DBE643296D3DD", hash_generated_field = "6016E8D817FEBA77C12B0D324C74B6A1")

        public static final UnicodeBlock MISCELLANEOUS_MATHEMATICAL_SYMBOLS_B = new UnicodeBlock("MISCELLANEOUS_MATHEMATICAL_SYMBOLS_B", 0x2980, 0x29ff);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.876 -0500", hash_original_field = "42A69CDBF2B6045D164D989900322020", hash_generated_field = "5D91286FFEC5DF87B1FC46A7EE858D5F")

        public static final UnicodeBlock SUPPLEMENTAL_MATHEMATICAL_OPERATORS = new UnicodeBlock("SUPPLEMENTAL_MATHEMATICAL_OPERATORS", 0x2a00, 0x2aff);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.879 -0500", hash_original_field = "5413F93D99CCD31473041B8A78F01F14", hash_generated_field = "0134B121A95640D16A57F3D8E680AA88")

        public static final UnicodeBlock MISCELLANEOUS_SYMBOLS_AND_ARROWS = new UnicodeBlock("MISCELLANEOUS_SYMBOLS_AND_ARROWS", 0x2b00, 0x2bff);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.883 -0500", hash_original_field = "F23F9B20C86F3395E84EE4D27DCABBFD", hash_generated_field = "3256E4BD30C85C532C0A701EE026DD89")

        public static final UnicodeBlock CJK_RADICALS_SUPPLEMENT = new UnicodeBlock("CJK_RADICALS_SUPPLEMENT", 0x2e80, 0x2eff);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.886 -0500", hash_original_field = "CB25C5EC072F6E5EDD57AF43ACEF92FF", hash_generated_field = "0F14D50B7E40BD4B8D8E129372DB0B5B")

        public static final UnicodeBlock KANGXI_RADICALS = new UnicodeBlock("KANGXI_RADICALS", 0x2f00, 0x2fdf);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.889 -0500", hash_original_field = "5BF486DD0E00B8DBDC322EB8F9A884EE", hash_generated_field = "DB7346FECAFC51C42CFCD446C5CD8ED2")

        public static final UnicodeBlock IDEOGRAPHIC_DESCRIPTION_CHARACTERS = new UnicodeBlock("IDEOGRAPHIC_DESCRIPTION_CHARACTERS", 0x2ff0, 0x2fff);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.892 -0500", hash_original_field = "51D993F7625E0BE83C3A55B26870451D", hash_generated_field = "0FBC8A7CA1E1C178AEFAD9BAD7FD8BA6")

        public static final UnicodeBlock CJK_SYMBOLS_AND_PUNCTUATION = new UnicodeBlock("CJK_SYMBOLS_AND_PUNCTUATION", 0x3000, 0x303f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.895 -0500", hash_original_field = "C2D80B167BF94D2BBC9BB79D9E73F375", hash_generated_field = "89E48B46BC9763EA20906E0C9E83446F")

        public static final UnicodeBlock HIRAGANA = new UnicodeBlock("HIRAGANA", 0x3040, 0x309f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.898 -0500", hash_original_field = "33719C9AE8A0D4C547881B1B1CE0FC52", hash_generated_field = "EB234F086A1BD8842B8E337316B59C18")

        public static final UnicodeBlock KATAKANA = new UnicodeBlock("KATAKANA", 0x30a0, 0x30ff);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.900 -0500", hash_original_field = "44AB986084B79E9F408B9CFA76F0603E", hash_generated_field = "9D28916A0D169BA84155A29EA5A14947")

        public static final UnicodeBlock BOPOMOFO = new UnicodeBlock("BOPOMOFO", 0x3100, 0x312f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.903 -0500", hash_original_field = "BC2184B31BD2246CED15EE18C8EFD8C6", hash_generated_field = "FDB7722C38F86DA6D49CB152F57A81F2")

        public static final UnicodeBlock HANGUL_COMPATIBILITY_JAMO = new UnicodeBlock("HANGUL_COMPATIBILITY_JAMO", 0x3130, 0x318f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.906 -0500", hash_original_field = "A37EDA20384C3A4E8D79D2D6F8FAF872", hash_generated_field = "9870595B1D9E5ED8D47D552E1082ECA0")

        public static final UnicodeBlock KANBUN = new UnicodeBlock("KANBUN", 0x3190, 0x319f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.909 -0500", hash_original_field = "C63A46E15544B52D78FF21629F75AD31", hash_generated_field = "F095BF5739393B0802453A804B5D618E")

        public static final UnicodeBlock BOPOMOFO_EXTENDED = new UnicodeBlock("BOPOMOFO_EXTENDED", 0x31a0, 0x31bf);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.913 -0500", hash_original_field = "79FEB026BF70EF71F8A157B8AE522EE9", hash_generated_field = "2BD91BDEDEDF4516A406B66C3DCB4FD3")

        public static final UnicodeBlock KATAKANA_PHONETIC_EXTENSIONS = new UnicodeBlock("KATAKANA_PHONETIC_EXTENSIONS", 0x31f0, 0x31ff);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.916 -0500", hash_original_field = "4EED1C25A8880A4239798690F27AC6BF", hash_generated_field = "3CA4CEF138ED9067AC4729B1F8768908")

        public static final UnicodeBlock ENCLOSED_CJK_LETTERS_AND_MONTHS = new UnicodeBlock("ENCLOSED_CJK_LETTERS_AND_MONTHS", 0x3200, 0x32ff);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.918 -0500", hash_original_field = "B5103A118C13B75D426C19BC3858741C", hash_generated_field = "DE5A722AFCC0A621605F3FE90292B0CA")

        public static final UnicodeBlock CJK_COMPATIBILITY = new UnicodeBlock("CJK_COMPATIBILITY", 0x3300, 0x33ff);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.921 -0500", hash_original_field = "9DEBBDF0056DDFBA4535B4CE048C9D11", hash_generated_field = "C04BE31D6701909EDE4A9E74608FC320")

        public static final UnicodeBlock CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A = new UnicodeBlock("CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A", 0x3400, 0x4dbf);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.923 -0500", hash_original_field = "FA568C25560FEC34CE051821F80BEE58", hash_generated_field = "E1536B9D8446C9A6A32A6C2DB831BB2B")

        public static final UnicodeBlock YIJING_HEXAGRAM_SYMBOLS = new UnicodeBlock("YIJING_HEXAGRAM_SYMBOLS", 0x4dc0, 0x4dff);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.927 -0500", hash_original_field = "21CA13D74C5338B3AEBBC54F41D7BCF2", hash_generated_field = "A6638282D081E5B0BF56AE4CB51BAA28")

        public static final UnicodeBlock CJK_UNIFIED_IDEOGRAPHS = new UnicodeBlock("CJK_UNIFIED_IDEOGRAPHS", 0x4e00, 0x9fff);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.930 -0500", hash_original_field = "99B27CFD2E411E55042F680CF47CA0CD", hash_generated_field = "098555705ADCB5046EEAA2EDD7D1961C")

        public static final UnicodeBlock YI_SYLLABLES = new UnicodeBlock("YI_SYLLABLES", 0xa000, 0xa48f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.933 -0500", hash_original_field = "F828AB439E023DF5A8C18F115E087BDE", hash_generated_field = "B5208EC4AD5DFE1C7AEB1AFF8418351A")

        public static final UnicodeBlock YI_RADICALS = new UnicodeBlock("YI_RADICALS", 0xa490, 0xa4cf);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.936 -0500", hash_original_field = "78AD64028D1FB1F67947930D771ED09F", hash_generated_field = "0BBEF82C4B814E06C0B36C6B6A407FE1")

        public static final UnicodeBlock HANGUL_SYLLABLES = new UnicodeBlock("HANGUL_SYLLABLES", 0xac00, 0xd7af);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.939 -0500", hash_original_field = "33CE8A243B7486A0E54C7B0A66D6C223", hash_generated_field = "A3E9E353C6F34AA3360E9D4D0E11EBEC")

        public static final UnicodeBlock HIGH_SURROGATES = new UnicodeBlock("HIGH_SURROGATES", 0xd800, 0xdb7f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.941 -0500", hash_original_field = "2A4BBC85C857E733DE22BB3284BB2ACF", hash_generated_field = "ECC47680DA2F4AF1E166373258E2A73F")

        public static final UnicodeBlock HIGH_PRIVATE_USE_SURROGATES = new UnicodeBlock("HIGH_PRIVATE_USE_SURROGATES", 0xdb80, 0xdbff);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.944 -0500", hash_original_field = "B16F6258CA3FDF126071864F84C13FCB", hash_generated_field = "CA8F7B713D75AE4C540FC9BE1E94B14C")

        public static final UnicodeBlock LOW_SURROGATES = new UnicodeBlock("LOW_SURROGATES", 0xdc00, 0xdfff);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.947 -0500", hash_original_field = "66EA45F8516E0E750C4DB9248E5C35F4", hash_generated_field = "D0B703B2ED38517C0D7B294421F9F1A8")

        public static final UnicodeBlock PRIVATE_USE_AREA = new UnicodeBlock("PRIVATE_USE_AREA", 0xe000, 0xf8ff);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.950 -0500", hash_original_field = "606FC84FBF5CEB2B6EA38CA58D04BC51", hash_generated_field = "99A590A3E4C0036F9A7FEB4C80D1DC86")

        public static final UnicodeBlock CJK_COMPATIBILITY_IDEOGRAPHS = new UnicodeBlock("CJK_COMPATIBILITY_IDEOGRAPHS", 0xf900, 0xfaff);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.953 -0500", hash_original_field = "8B13F6CD66CD6C899C48D02E87AEF0C5", hash_generated_field = "298039FA168BAD6173D22D39F2F6E569")

        public static final UnicodeBlock ALPHABETIC_PRESENTATION_FORMS = new UnicodeBlock("ALPHABETIC_PRESENTATION_FORMS", 0xfb00, 0xfb4f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.956 -0500", hash_original_field = "4D7F02B8644B521D610B7F02B55AFCDC", hash_generated_field = "C3DAA2886FEBE16DA702A7635103A66F")

        public static final UnicodeBlock ARABIC_PRESENTATION_FORMS_A = new UnicodeBlock("ARABIC_PRESENTATION_FORMS_A", 0xfb50, 0xfdff);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.959 -0500", hash_original_field = "4992867B518BB982E189446C84883C82", hash_generated_field = "977C92BC90D9AD33A96C2E1695DCEE9E")

        public static final UnicodeBlock VARIATION_SELECTORS = new UnicodeBlock("VARIATION_SELECTORS", 0xfe00, 0xfe0f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.962 -0500", hash_original_field = "88DDCA1F86ECAC4004BA7EDE296064C8", hash_generated_field = "A8558C320DD51CB5665AC157E601DAF5")

        public static final UnicodeBlock COMBINING_HALF_MARKS = new UnicodeBlock("COMBINING_HALF_MARKS", 0xfe20, 0xfe2f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.965 -0500", hash_original_field = "6761C186991A3FF59B5A9667669225DE", hash_generated_field = "1F0BD8E11D487E1D2A2D641C6858E8C8")

        public static final UnicodeBlock CJK_COMPATIBILITY_FORMS = new UnicodeBlock("CJK_COMPATIBILITY_FORMS", 0xfe30, 0xfe4f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.967 -0500", hash_original_field = "3D2BFD5DA2537CE4B9888D39F6E4D6D3", hash_generated_field = "BEAD6130A6222972DD1A8A29B8609522")

        public static final UnicodeBlock SMALL_FORM_VARIANTS = new UnicodeBlock("SMALL_FORM_VARIANTS", 0xfe50, 0xfe6f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.971 -0500", hash_original_field = "633638E5BACB05EB977C3156849601A1", hash_generated_field = "539EE254C9810D31387B0E81A87ACB77")

        public static final UnicodeBlock ARABIC_PRESENTATION_FORMS_B = new UnicodeBlock("ARABIC_PRESENTATION_FORMS_B", 0xfe70, 0xfeff);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.974 -0500", hash_original_field = "3DE00F57BDBF8EE2C61B0A4FB7B4E40C", hash_generated_field = "E4EE3AB3E9711C4718FA45FD3F2FB359")

        public static final UnicodeBlock HALFWIDTH_AND_FULLWIDTH_FORMS = new UnicodeBlock("HALFWIDTH_AND_FULLWIDTH_FORMS", 0xff00, 0xffef);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.976 -0500", hash_original_field = "C5498260571200D235071ED92C4D3A2C", hash_generated_field = "68AA014FD4A408F01BA93DCA41187CBE")

        public static final UnicodeBlock SPECIALS = new UnicodeBlock("SPECIALS", 0xfff0, 0xffff);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.979 -0500", hash_original_field = "6C84B2DAFE3CDF2E3C3AA6BB2D359DE1", hash_generated_field = "6216E3FFEB4A702A4EB827A96741F966")

        public static final UnicodeBlock LINEAR_B_SYLLABARY = new UnicodeBlock("LINEAR_B_SYLLABARY", 0x10000, 0x1007f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.983 -0500", hash_original_field = "7BE37C5FADE798F15A056474D782BC91", hash_generated_field = "864F93B3684928ABDFBB3C39AB300C89")

        public static final UnicodeBlock LINEAR_B_IDEOGRAMS = new UnicodeBlock("LINEAR_B_IDEOGRAMS", 0x10080, 0x100ff);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.986 -0500", hash_original_field = "8D5FB9C8FD0D51B07EF5162686D94A14", hash_generated_field = "076E60A9275FB64D6B8CD06E79FBC642")

        public static final UnicodeBlock AEGEAN_NUMBERS = new UnicodeBlock("AEGEAN_NUMBERS", 0x10100, 0x1013f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.989 -0500", hash_original_field = "AE79C3BEB0FA2DB10377F6D23C08CE53", hash_generated_field = "B0BDE03A8FB3FCE90FD7C0D393528563")

        public static final UnicodeBlock OLD_ITALIC = new UnicodeBlock("OLD_ITALIC", 0x10300, 0x1032f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.992 -0500", hash_original_field = "82D681D5EE08584A43480DD79DFC68E3", hash_generated_field = "E719B95FABA4FE9E7CBE093B4B9814F7")

        public static final UnicodeBlock GOTHIC = new UnicodeBlock("GOTHIC", 0x10330, 0x1034f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.994 -0500", hash_original_field = "F89BAA7DD8B96205F383383282B8917F", hash_generated_field = "90722BF19C5FEF316989CAEB3A438A4A")

        public static final UnicodeBlock UGARITIC = new UnicodeBlock("UGARITIC", 0x10380, 0x1039f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.997 -0500", hash_original_field = "3033146AD46633A97381B4662C75A205", hash_generated_field = "00778E5B6E8F5A54CA1C86D148A9BB28")

        public static final UnicodeBlock DESERET = new UnicodeBlock("DESERET", 0x10400, 0x1044f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.000 -0500", hash_original_field = "2CBF602FE57F2ACDBA906FD60D157775", hash_generated_field = "5C961EA224EDA4C2536FB691BF1F7840")

        public static final UnicodeBlock SHAVIAN = new UnicodeBlock("SHAVIAN", 0x10450, 0x1047f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.003 -0500", hash_original_field = "58A1AA0FDED038849D6FA3A339238B77", hash_generated_field = "4CD61F0B986413AFB693D0E5A2D24B1E")

        public static final UnicodeBlock OSMANYA = new UnicodeBlock("OSMANYA", 0x10480, 0x104af);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.006 -0500", hash_original_field = "33E8B22CCE791003C5693A6BFFFE902E", hash_generated_field = "101F676992A43133D9E3017D2FA402B0")

        public static final UnicodeBlock CYPRIOT_SYLLABARY = new UnicodeBlock("CYPRIOT_SYLLABARY", 0x10800, 0x1083f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.009 -0500", hash_original_field = "B13484A171D2A93C27297D7EAF4E7EE9", hash_generated_field = "0BD33AB611AD5B24DD9F1E272A1F9EEE")

        public static final UnicodeBlock BYZANTINE_MUSICAL_SYMBOLS = new UnicodeBlock("BYZANTINE_MUSICAL_SYMBOLS", 0x1d000, 0x1d0ff);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.013 -0500", hash_original_field = "05AB0F72ECA518AF8D2E1B1E7DF28D70", hash_generated_field = "410FBA662CD029F8C166CEFB28CB7F21")

        public static final UnicodeBlock MUSICAL_SYMBOLS = new UnicodeBlock("MUSICAL_SYMBOLS", 0x1d100, 0x1d1ff);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.016 -0500", hash_original_field = "B3900FEF68DD9AFE3B55CC7B03169B61", hash_generated_field = "6489484CC1D5DDAB83E1826B19ED4CD1")

        public static final UnicodeBlock TAI_XUAN_JING_SYMBOLS = new UnicodeBlock("TAI_XUAN_JING_SYMBOLS", 0x1d300, 0x1d35f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.018 -0500", hash_original_field = "EB3249C22587294DB4BE2D8BE331AD16", hash_generated_field = "E8C629138322F05716CF142BE26FCDCE")

        public static final UnicodeBlock MATHEMATICAL_ALPHANUMERIC_SYMBOLS = new UnicodeBlock("MATHEMATICAL_ALPHANUMERIC_SYMBOLS", 0x1d400, 0x1d7ff);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.021 -0500", hash_original_field = "F9D05C7B458762B9B26B2A64AB0AC80C", hash_generated_field = "59796DF707EADEA6172C6C78A63C8CB1")

        public static final UnicodeBlock CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B = new UnicodeBlock("CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B", 0x20000, 0x2a6df);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.024 -0500", hash_original_field = "614899A8B899EC7AE2AA23377649905C", hash_generated_field = "5AB34FE83B4ECFDC4EAF6F3FCF704BC7")

        public static final UnicodeBlock CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT = new UnicodeBlock("CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT", 0x2f800, 0x2fa1f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.027 -0500", hash_original_field = "ADF0C056342413C9F07F42FB234E6BD0", hash_generated_field = "E089A9FF255D079E2E3A2EB7B0735970")

        public static final UnicodeBlock TAGS = new UnicodeBlock("TAGS", 0xe0000, 0xe007f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.030 -0500", hash_original_field = "E3738A26E68F0A109B29292BAA5CB67B", hash_generated_field = "A185E731085E928EF6F4F1E0EF098FAA")

        public static final UnicodeBlock VARIATION_SELECTORS_SUPPLEMENT = new UnicodeBlock("VARIATION_SELECTORS_SUPPLEMENT", 0xe0100, 0xe01ef);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.033 -0500", hash_original_field = "7A1B8512C3D8559B443C6DA9D710DF85", hash_generated_field = "A333F35399AC2ED68EE573C8CFABE105")

        public static final UnicodeBlock SUPPLEMENTARY_PRIVATE_USE_AREA_A = new UnicodeBlock("SUPPLEMENTARY_PRIVATE_USE_AREA_A", 0xf0000, 0xfffff);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.036 -0500", hash_original_field = "005AB99DC024AF46D3EB8104C92081B6", hash_generated_field = "C7A657D93940D340E8D0B1F3025A5133")

        public static final UnicodeBlock SUPPLEMENTARY_PRIVATE_USE_AREA_B = new UnicodeBlock("SUPPLEMENTARY_PRIVATE_USE_AREA_B", 0x100000, 0x10ffff);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.040 -0500", hash_original_field = "2FB3A88A8880FB0963113C5F1BF87430", hash_generated_field = "BE70CFE8234B32987A3B5D8D50E1DFAA")

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

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.052 -0500", hash_original_method = "234E88093AAFC12110C9FE35072443BD", hash_generated_method = "7891E7DDA46973DD6645D95F592E70F4")
        
private UnicodeBlock(String blockName, int start, int end) {
            super(blockName);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.480 -0500", hash_original_field = "555D08BA3A33F36357A4BD929083D550", hash_generated_field = "E46E31E36A2A064FCA5A5B3365B9D7C2")

    public static final byte UPPERCASE_LETTER = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.483 -0500", hash_original_field = "507A8AD3E31237C2AE673D1FFBEE3F2B", hash_generated_field = "2349C4B44027F5A2AAF5A3EB964C33FD")

    public static final byte LOWERCASE_LETTER = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.485 -0500", hash_original_field = "0AC984772DF9C02FE34D9B8EE558BD86", hash_generated_field = "2518D7B86288E9E10B57EE7906C01230")

    public static final byte TITLECASE_LETTER = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.488 -0500", hash_original_field = "20EE878561EF8D30611A26E9F9200CFA", hash_generated_field = "B43043DB882F54DCDBED3E23A2D8C140")

    public static final byte MODIFIER_LETTER = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.491 -0500", hash_original_field = "F9341CAA27A72152AF7DEB92C331BD49", hash_generated_field = "14418A71CB2CBFDAFAB2CE97D5446FAA")

    public static final byte OTHER_LETTER = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.494 -0500", hash_original_field = "EDD9D39E5CE34F16E5FD99B9F304A9ED", hash_generated_field = "A0D3B9A6108781728BD40B2B402D4DF9")

    public static final byte NON_SPACING_MARK = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.497 -0500", hash_original_field = "900C7A7BD7CF0909AB8992819C6086CA", hash_generated_field = "0F47728D97DCCC7BFE30DEC641821ABD")

    public static final byte ENCLOSING_MARK = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.499 -0500", hash_original_field = "52C05E434060F6A8C00547F9E2A6BC1C", hash_generated_field = "B560F93773D678E7D93ACC37919F4041")

    public static final byte COMBINING_SPACING_MARK = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.502 -0500", hash_original_field = "8F7D1C741CC5B3E036D984004D077023", hash_generated_field = "2775D0C911F5415D7BEDEFE1B25331DC")

    public static final byte DECIMAL_DIGIT_NUMBER = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.505 -0500", hash_original_field = "B393EB0558FE10E35880ADBF3E2B5523", hash_generated_field = "477D956497C398C77F0FCCA28D525D1F")

    public static final byte LETTER_NUMBER = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.507 -0500", hash_original_field = "29953B65796FDE8B9384DFBD8C8B86D3", hash_generated_field = "F698BFA73FDC7BD5E7D6E5091D5CF7F8")

    public static final byte OTHER_NUMBER = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.511 -0500", hash_original_field = "97EFFA4F79859410C28D61DE3760CD01", hash_generated_field = "3B1AA2DFDC53D5D5EFF9998A23CDEE3E")

    public static final byte SPACE_SEPARATOR = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.513 -0500", hash_original_field = "A3DE9A1AB76687CC3C05FD35A74C5CD1", hash_generated_field = "EEB5E60400D692C9E518E0A100223F65")

    public static final byte LINE_SEPARATOR = 13;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.516 -0500", hash_original_field = "B3A34C95F901C4ECE6EDDB8905A7F8A3", hash_generated_field = "CAC8235F10F25399871A2F8F7EFCD385")

    public static final byte PARAGRAPH_SEPARATOR = 14;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.518 -0500", hash_original_field = "2C91C102000C1A4323083D4AD6C613A5", hash_generated_field = "B4291BDF4C5CC797DDEE4B3C672B0D3C")

    public static final byte CONTROL = 15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.522 -0500", hash_original_field = "30D21BF900943172CDAA3C3C55FF7648", hash_generated_field = "FE8354F3B328CC0D8EBC380E2527BF8A")

    public static final byte FORMAT = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.524 -0500", hash_original_field = "644A7DC0113B953BFDDCEBEC0BA95F9B", hash_generated_field = "D6A2E7BA4A5499452B5042DC30BE8263")

    public static final byte PRIVATE_USE = 18;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.527 -0500", hash_original_field = "E970A6718E40B0E4AA65118FD333C73B", hash_generated_field = "9BCE804B6E91EB7C0D6AC3CF48D9A9EB")

    public static final byte SURROGATE = 19;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.530 -0500", hash_original_field = "108F721FA119D91360A13A6A4406631C", hash_generated_field = "235A1DD1A9C784BDA03E995E24F7B805")

    public static final byte DASH_PUNCTUATION = 20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.532 -0500", hash_original_field = "44E47383CA98F72E4834054539DE1DB7", hash_generated_field = "918E1A2C2FA7E8789172EEEF46231185")

    public static final byte START_PUNCTUATION = 21;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.535 -0500", hash_original_field = "6CB5F47DC6D07486D7AEC0F2D215AD48", hash_generated_field = "CE6479FE6E66972BACE1857331300B8D")

    public static final byte END_PUNCTUATION = 22;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.538 -0500", hash_original_field = "85A3029E2A0E2783411BB60EDFBFF0AE", hash_generated_field = "1CAE83EE4D96A8C2E604E0A3EF1439CE")

    public static final byte CONNECTOR_PUNCTUATION = 23;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.540 -0500", hash_original_field = "172FFECABCD7894FBEB20230F2A32CA0", hash_generated_field = "D10F22A3B961FBA1C72332C12A40205E")

    public static final byte OTHER_PUNCTUATION = 24;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.543 -0500", hash_original_field = "1A90CDCE1461BC93C819F739A4810A6D", hash_generated_field = "B414F2054A74344DA216054479E22625")

    public static final byte MATH_SYMBOL = 25;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.546 -0500", hash_original_field = "81C1532B668DCD62742DE722114C7699", hash_generated_field = "E1F97B4B70A657B7E642CDE292B2A449")

    public static final byte CURRENCY_SYMBOL = 26;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.548 -0500", hash_original_field = "3DC992A52FF9E1C4AED80FAECF3B63DA", hash_generated_field = "38A2EEF804B6CC1D0349835A8313EF3C")

    public static final byte MODIFIER_SYMBOL = 27;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.551 -0500", hash_original_field = "1395E05608F3466BA51A96ADC37DFAB2", hash_generated_field = "F8B93C0F898E6A2F79436FBAE3DECA3B")

    public static final byte OTHER_SYMBOL = 28;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.554 -0500", hash_original_field = "A880823B0C5B26BD1969FB642D798D87", hash_generated_field = "18A46E9202B75C9327D292A17F53A8BB")

    public static final byte INITIAL_QUOTE_PUNCTUATION = 29;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.557 -0500", hash_original_field = "FB708D099C9874C6BFC77A47CB34FFA8", hash_generated_field = "7FFD9E2D501F2AD28BF90E9B7808B206")

    public static final byte FINAL_QUOTE_PUNCTUATION = 30;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.560 -0500", hash_original_field = "36607E63EFB104352EA2B743147B58EF", hash_generated_field = "2CF99592472E13E145863194D0D3E5D3")

    public static final byte DIRECTIONALITY_UNDEFINED = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.562 -0500", hash_original_field = "4D46D46CE4E274B6A41614E89AC26844", hash_generated_field = "DF72F07E75BBA2515475DE173F66E0F2")

    public static final byte DIRECTIONALITY_LEFT_TO_RIGHT = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.565 -0500", hash_original_field = "E248217267749D335B157086F8A0CE64", hash_generated_field = "1B0E0291882CB62A799850C13A74DF38")

    public static final byte DIRECTIONALITY_RIGHT_TO_LEFT = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.568 -0500", hash_original_field = "E00990FB4B36832507E8473C57958E3F", hash_generated_field = "08FDA81C783B61E7D52CB11AE2BC7A01")

    public static final byte DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.571 -0500", hash_original_field = "5B2A0E80CB3C6D526740C81100C8FF8A", hash_generated_field = "B8761BBD29E3A3E729024F2B9614E2FB")

    public static final byte DIRECTIONALITY_EUROPEAN_NUMBER = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.573 -0500", hash_original_field = "0B05CE139452350EBF65EEDC95D1A0F1", hash_generated_field = "BEAC1A18B62ED65F6B0F3F456AB7B228")

    public static final byte DIRECTIONALITY_EUROPEAN_NUMBER_SEPARATOR = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.576 -0500", hash_original_field = "213378DD28874EBE6E41C87328214C90", hash_generated_field = "57A2E4EB471BA0D51C6130CBF994EBD5")

    public static final byte DIRECTIONALITY_EUROPEAN_NUMBER_TERMINATOR = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.579 -0500", hash_original_field = "F311E8DC7E1C09526D2D109B2FF31E6D", hash_generated_field = "6D88ECC2E43F26FAB23E8757B8F4B1D3")

    public static final byte DIRECTIONALITY_ARABIC_NUMBER = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.581 -0500", hash_original_field = "BA5B117361934E4C0B2CCEA92345EB7C", hash_generated_field = "8446420EF1951B38F6EFBA4E9A4EF6F5")

    public static final byte DIRECTIONALITY_COMMON_NUMBER_SEPARATOR = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.584 -0500", hash_original_field = "B47F5C5BB39CE70F9C110B2609F4C5B1", hash_generated_field = "9880FF4079E587478B95A27724064BB6")

    public static final byte DIRECTIONALITY_NONSPACING_MARK = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.587 -0500", hash_original_field = "E45F0B0094BE64A2385A10E4F2104AA2", hash_generated_field = "2237817D3DAA9D4C620B5D03348069D9")

    public static final byte DIRECTIONALITY_BOUNDARY_NEUTRAL = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.589 -0500", hash_original_field = "7DD3D9F206C9770137D4E2E0B344C258", hash_generated_field = "E0036E751C705657BEB42EA1B90BEE35")

    public static final byte DIRECTIONALITY_PARAGRAPH_SEPARATOR = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.592 -0500", hash_original_field = "B67F2BF2239CE7FF7ED1B1DB59FAFEA9", hash_generated_field = "4074F2100CC73D2D1DA4E75F8C460D32")

    public static final byte DIRECTIONALITY_SEGMENT_SEPARATOR = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.595 -0500", hash_original_field = "D82035E7B98CAF486DAD5A0AAD7197B4", hash_generated_field = "64083855912A5B1B16820118FA057A37")

    public static final byte DIRECTIONALITY_WHITESPACE = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.598 -0500", hash_original_field = "B5A30BA8973BC10026ED0FAB18D3CD64", hash_generated_field = "4EDB0AF33074436151C0EBF30A24D4C2")

    public static final byte DIRECTIONALITY_OTHER_NEUTRALS = 13;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.600 -0500", hash_original_field = "E722427740CD512E4165D080C5B71F78", hash_generated_field = "9F58F45F02B0DEB351D4FD9415072A91")

    public static final byte DIRECTIONALITY_LEFT_TO_RIGHT_EMBEDDING = 14;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.603 -0500", hash_original_field = "3761A4402474D1AC81235FBAEBD7A3BF", hash_generated_field = "F1A15423B4369E280E7DA7FF3D3A42D3")

    public static final byte DIRECTIONALITY_LEFT_TO_RIGHT_OVERRIDE = 15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.606 -0500", hash_original_field = "60E1FB01134637FC57CFD6C1E3094662", hash_generated_field = "4C83AF7A955F4BFB8B5ED12499ED4008")

    public static final byte DIRECTIONALITY_RIGHT_TO_LEFT_EMBEDDING = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.608 -0500", hash_original_field = "5B15C5ACFDC419A2B989E3F2AE83E5C0", hash_generated_field = "5E07D195A5895A7F53CBC4556D57E9D2")

    public static final byte DIRECTIONALITY_RIGHT_TO_LEFT_OVERRIDE = 17;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.611 -0500", hash_original_field = "B9FD081064C868AC8B8F3380B1471969", hash_generated_field = "823095A31D59328F1FCC4D05B73A8304")

    public static final byte DIRECTIONALITY_POP_DIRECTIONAL_FORMAT = 18;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.614 -0500", hash_original_field = "2502F52332FB4ACB6363CD617C29A8B5", hash_generated_field = "67164DD8003FCA956CEF01CBAA71F41F")

    public static final char MIN_HIGH_SURROGATE = '\uD800';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.617 -0500", hash_original_field = "DA4E1F0E4C7D8941C771395DF994FB07", hash_generated_field = "E754CC1F6E8F11F1639DE78093B86F7A")

    public static final char MAX_HIGH_SURROGATE = '\uDBFF';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.619 -0500", hash_original_field = "471903CB2E1112A949B5753CEDDB353F", hash_generated_field = "A6C1DC6C1854AAABCAA1A0500BE13AE6")

    public static final char MIN_LOW_SURROGATE = '\uDC00';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.623 -0500", hash_original_field = "28A7EB6F3382FB3309EC0996D8E977F9", hash_generated_field = "8CC93D87C4BFA83CB89659DD2769590B")

    public static final char MAX_LOW_SURROGATE = '\uDFFF';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.625 -0500", hash_original_field = "00F8B44B0E99B6D3E32C7074DFE0C8B4", hash_generated_field = "E53CD7E7DADB80CC5215196EA399D4D8")

    public static final char MIN_SURROGATE = '\uD800';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.628 -0500", hash_original_field = "A0B10540AE2D728E04324BF4EC844DF3", hash_generated_field = "B2FF295311D6A95860932B19554C26C7")

    public static final char MAX_SURROGATE = '\uDFFF';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.631 -0500", hash_original_field = "E9457AA43A8E97275EBADE64ECE01AA9", hash_generated_field = "4430BA24D2AE2566886D2E5562919E6F")

    public static final int MIN_SUPPLEMENTARY_CODE_POINT = 0x10000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.640 -0500", hash_original_field = "3B821AD30A4119CB32E30C33CBE284A1", hash_generated_field = "C9A0D15452A074F5179338EE20BDD54C")

    public static final int MIN_CODE_POINT = 0x000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.643 -0500", hash_original_field = "8AE61D3D8A50EB5E061892C1F475E6FC", hash_generated_field = "A23E3C853E31AC1620D798966175A835")

    public static final int MAX_CODE_POINT = 0x10FFFF;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.645 -0500", hash_original_field = "483DD33A2F1D80B313CD1100ACB2057F", hash_generated_field = "35BBD8D16D40CCFD2558C6BE179C9BD7")

    public static final int SIZE = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.648 -0500", hash_original_field = "2896E5C0CC76D537CC3B13493B0E8B47", hash_generated_field = "504A101457658254DD8C38E597554F90")

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

@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:22.461 -0500", hash_original_field = "116C54C63A0999E8859ECE8A2FFB8D84", hash_generated_field = "747ED88C4962B4F2D5A7D8AD1452F805")

    private  char value;

    /**
     * Constructs a new {@code Character} with the specified primitive char
     * value.
     *
     * @param value
     *            the primitive char value to store in the new instance.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.075 -0500", hash_original_method = "8DEFF913326DC7F74512EFD131579B65", hash_generated_method = "7C63A56BD2050D9DFD23DCA01F1FAB4D")
    
public Character(char value) {
        this.value = value;
        addTaint(value);
    }

    /**
     * Gets the primitive value of this character.
     *
     * @return this object's primitive value.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.077 -0500", hash_original_method = "1972D57F3C05C7BADF696B9ADC3E34F9", hash_generated_method = "BA9A46CE526C5E63D2D926F1CB99EE3C")
    
public char charValue() {
        return value;
    }

    /**
     * Compares this object to the specified character object to determine their
     * relative order.
     *
     * @param c
     *            the character object to compare this object to.
     * @return {@code 0} if the value of this character and the value of
     *         {@code c} are equal; a positive value if the value of this
     *         character is greater than the value of {@code c}; a negative
     *         value if the value of this character is less than the value of
     *         {@code c}.
     * @see java.lang.Comparable
     * @since 1.2
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.082 -0500", hash_original_method = "3BC38476D10A0BB1E7E9CABDBB184EDE", hash_generated_method = "7422014396724F0DEB22E6C2D38FCDA5")
    
public int compareTo(Character c) {
        return compare(value, c.value);
    }

    /**
     * Compares this object with the specified object and indicates if they are
     * equal. In order to be equal, {@code object} must be an instance of
     * {@code Character} and have the same char value as this object.
     *
     * @param object
     *            the object to compare this double with.
     * @return {@code true} if the specified object is equal to this
     *         {@code Character}; {@code false} otherwise.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.161 -0500", hash_original_method = "88215BA2DAA464AB2808512F13A48003", hash_generated_method = "808599830A3D4CCFB8477D4C7F559DEE")
    
@Override
    public boolean equals(Object object) {
        return (object instanceof Character) && (((Character) object).value == value);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.213 -0500", hash_original_method = "961F210287166DF05D8915D632129E75", hash_generated_method = "C30218EC7C084095E716A93197D10945")
    
@Override
    public int hashCode() {
        return value;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:23.377 -0500", hash_original_method = "27F3E47E60B1213ECE72A0C1452319D1", hash_generated_method = "B864B858E73245729E2A2FF424814054")
    
@Override
    public String toString() {
        return String.valueOf(value);
    }
    
}

