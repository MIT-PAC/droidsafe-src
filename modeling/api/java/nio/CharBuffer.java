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


package java.nio;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.util.Arrays;

public abstract class CharBuffer extends Buffer implements Comparable<CharBuffer>, CharSequence, Appendable, Readable {

    /**
     * Creates a char buffer based on a newly allocated char array.
     *
     * @param capacity
     *            the capacity of the new buffer.
     * @return the created char buffer.
     * @throws IllegalArgumentException
     *             if {@code capacity} is less than zero.
     */
    @DSComment("memory buffer only")
    @DSSafe(DSCat.MEM_BUFFER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.724 -0500", hash_original_method = "8E15B4BAB979FFE1D8AD7F6E38D447D6", hash_generated_method = "C5F8F31431C8864718BD1CDDB3322B44")
    
public static CharBuffer allocate(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }
        return new ReadWriteCharArrayBuffer(capacity);
    }

    /**
     * Creates a new char buffer by wrapping the given char array.
     * <p>
     * Calling this method has the same effect as
     * {@code wrap(array, 0, array.length)}.
     *
     * @param array
     *            the char array which the new buffer will be based on.
     * @return the created char buffer.
     */
    @DSComment("memory buffer only")
    @DSSafe(DSCat.MEM_BUFFER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.726 -0500", hash_original_method = "D9A2F140B5EF04EB7DEC41094ED7E8AE", hash_generated_method = "65ED0488DDDF29B220084A330F6927CA")
    
public static CharBuffer wrap(char[] array) {
        return wrap(array, 0, array.length);
    }

    /**
     * Creates a new char buffer by wrapping the given char array.
     * <p>
     * The new buffer's position will be {@code start}, limit will be
     * {@code start + charCount}, capacity will be the length of the array.
     *
     * @param array
     *            the char array which the new buffer will be based on.
     * @param start
     *            the start index, must not be negative and not greater than
     *            {@code array.length}.
     * @param charCount
     *            the length, must not be negative and not greater than
     *            {@code array.length - start}.
     * @return the created char buffer.
     * @exception IndexOutOfBoundsException
     *                if either {@code start} or {@code charCount} is invalid.
     */
    @DSComment("memory buffer only")
    @DSSafe(DSCat.MEM_BUFFER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.729 -0500", hash_original_method = "F4BBCADC2CAAE6F42E5D0A764115F8AA", hash_generated_method = "D5490944D7BAD3977680C13B7CFB7E2A")
    
public static CharBuffer wrap(char[] array, int start, int charCount) {
        Arrays.checkOffsetAndCount(array.length, start, charCount);
        CharBuffer buf = new ReadWriteCharArrayBuffer(array);
        buf.position = start;
        buf.limit = start + charCount;
        return buf;
    }

    /**
     * Creates a new char buffer by wrapping the given char sequence.
     * <p>
     * Calling this method has the same effect as
     * {@code wrap(chseq, 0, chseq.length())}.
     *
     * @param chseq
     *            the char sequence which the new buffer will be based on.
     * @return the created char buffer.
     */
    @DSComment("memory buffer only")
    @DSSafe(DSCat.MEM_BUFFER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.731 -0500", hash_original_method = "A0EB00DB48D8743104B82F6C26C74F16", hash_generated_method = "EBAB227E99E79F26C2763E8C24D9BF33")
    
public static CharBuffer wrap(CharSequence chseq) {
        return new CharSequenceAdapter(chseq);
    }

    /**
     * Creates a new char buffer by wrapping the given char sequence.
     * <p>
     * The new buffer's position will be {@code start}, limit will be
     * {@code end}, capacity will be the length of the char sequence. The new
     * buffer is read-only.
     *
     * @param cs
     *            the char sequence which the new buffer will be based on.
     * @param start
     *            the start index, must not be negative and not greater than
     *            {@code cs.length()}.
     * @param end
     *            the end index, must be no less than {@code start} and no
     *            greater than {@code cs.length()}.
     * @return the created char buffer.
     * @exception IndexOutOfBoundsException
     *                if either {@code start} or {@code end} is invalid.
     */
    @DSComment("memory buffer only")
    @DSSafe(DSCat.MEM_BUFFER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.734 -0500", hash_original_method = "6F90926803EA51F00CE00F4590525589", hash_generated_method = "D9FFB72AF163F0ACAE0C27A8A19234D4")
    
public static CharBuffer wrap(CharSequence cs, int start, int end) {
        if (start < 0 || end < start || end > cs.length()) {
            throw new IndexOutOfBoundsException("cs.length()=" + cs.length() + ", start=" + start + ", end=" + end);
        }
        CharBuffer result = new CharSequenceAdapter(cs);
        result.position = start;
        result.limit = end;
        return result;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.737 -0500", hash_original_method = "295C6F316A1C76C71107A06FE21F48B5", hash_generated_method = "295C6F316A1C76C71107A06FE21F48B5")
    
CharBuffer(int capacity) {
        super(1, capacity, null);
    }

    @DSComment("memory buffer only")
    @DSSafe(DSCat.MEM_BUFFER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.739 -0500", hash_original_method = "B8788BC8872EF40BE08078E90206AB2A", hash_generated_method = "F7EF93A89420C122FCC187990CCE4477")
    
public final char[] array() {
        return protectedArray();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.742 -0500", hash_original_method = "0D5EF56CBEA1DA16093A6276D10D9347", hash_generated_method = "28A2D71AE8939DE09018E333ADFF6CAE")
    
public final int arrayOffset() {
        return protectedArrayOffset();
    }

    /**
     * Returns a read-only buffer that shares its content with this buffer.
     * <p>
     * The returned buffer is guaranteed to be a new instance, even if this
     * buffer is read-only itself. The new buffer's position, limit, capacity
     * and mark are the same as this buffer's.
     * <p>
     * The new buffer shares its content with this buffer, which means this
     * buffer's change of content will be visible to the new buffer. The two
     * buffer's position, limit and mark are independent.
     *
     * @return a read-only version of this buffer.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.744 -0500", hash_original_method = "E9C6B44F85BB9193F204D1E49DCFF090", hash_generated_method = "BD21260925E192AF83E56ED872F08B60")
    
public abstract CharBuffer asReadOnlyBuffer();

    /**
     * Returns the character located at the specified index in the buffer. The
     * index value is referenced from the current buffer position.
     *
     * @param index
     *            the index referenced from the current buffer position. It must
     *            not be less than zero but less than the value obtained from a
     *            call to {@code remaining()}.
     * @return the character located at the specified index (referenced from the
     *         current position) in the buffer.
     * @exception IndexOutOfBoundsException
     *                if the index is invalid.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.747 -0500", hash_original_method = "064ED2665DC7B0A0ED1B4C93428755B4", hash_generated_method = "E0528FF289F11D7D7DE35009840902E6")
    
public final char charAt(int index) {
        if (index < 0 || index >= remaining()) {
            throw new IndexOutOfBoundsException("index=" + index + ", remaining()=" + remaining());
        }
        return get(position + index);
    }

    /**
     * Compacts this char buffer.
     * <p>
     * The remaining chars will be moved to the head of the buffer,
     * starting from position zero. Then the position is set to
     * {@code remaining()}; the limit is set to capacity; the mark is cleared.
     *
     * @return this buffer.
     * @exception ReadOnlyBufferException
     *                if no changes may be made to the contents of this buffer.
     */
    @DSComment("Abstract Method")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.749 -0500", hash_original_method = "4734CE8977AF20831B683F622B556E41", hash_generated_method = "132D1383C510B50C25E6DF2A3CA8EF13")
    
public abstract CharBuffer compact();

    /**
     * Compare the remaining chars of this buffer to another char
     * buffer's remaining chars.
     *
     * @param otherBuffer
     *            another char buffer.
     * @return a negative value if this is less than {@code otherBuffer}; 0 if
     *         this equals to {@code otherBuffer}; a positive value if this is
     *         greater than {@code otherBuffer}.
     * @exception ClassCastException
     *                if {@code otherBuffer} is not a char buffer.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.752 -0500", hash_original_method = "726E488C44BA42D1E85B63DB9E089EB1", hash_generated_method = "8467A4596428B2A439EFBB856C3EE3D9")
    
public int compareTo(CharBuffer otherBuffer) {
        int compareRemaining = (remaining() < otherBuffer.remaining()) ? remaining()
                : otherBuffer.remaining();
        int thisPos = position;
        int otherPos = otherBuffer.position;
        char thisByte, otherByte;
        while (compareRemaining > 0) {
            thisByte = get(thisPos);
            otherByte = otherBuffer.get(otherPos);
            if (thisByte != otherByte) {
                return thisByte < otherByte ? -1 : 1;
            }
            thisPos++;
            otherPos++;
            compareRemaining--;
        }
        return remaining() - otherBuffer.remaining();
    }

    /**
     * Returns a duplicated buffer that shares its content with this buffer.
     * <p>
     * The duplicated buffer's initial position, limit, capacity and mark are
     * the same as this buffer's. The duplicated buffer's read-only property and
     * byte order are the same as this buffer's, too.
     * <p>
     * The new buffer shares its content with this buffer, which means either
     * buffer's change of content will be visible to the other. The two buffer's
     * position, limit and mark are independent.
     *
     * @return a duplicated buffer that shares its content with this buffer.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.754 -0500", hash_original_method = "B6D218A3CD92B4ADC9511EB98EDFD60B", hash_generated_method = "F52BEDA6CC60856F0546400F6EECE9BF")
    
public abstract CharBuffer duplicate();

    /**
     * Checks whether this char buffer is equal to another object.
     * <p>
     * If {@code other} is not a char buffer then {@code false} is returned. Two
     * char buffers are equal if and only if their remaining chars are exactly
     * the same. Position, limit, capacity and mark are not considered.
     *
     * @param other
     *            the object to compare with this char buffer.
     * @return {@code true} if this char buffer is equal to {@code other},
     *         {@code false} otherwise.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.757 -0500", hash_original_method = "43FFCFC26BAE21B80C74493A78B534C8", hash_generated_method = "6EEB7BA4B6B7183769BC94F588EE1AF2")
    
@Override
    public boolean equals(Object other) {
        if (!(other instanceof CharBuffer)) {
            return false;
        }
        CharBuffer otherBuffer = (CharBuffer) other;

        if (remaining() != otherBuffer.remaining()) {
            return false;
        }

        int myPosition = position;
        int otherPosition = otherBuffer.position;
        boolean equalSoFar = true;
        while (equalSoFar && (myPosition < limit)) {
            equalSoFar = get(myPosition++) == otherBuffer.get(otherPosition++);
        }

        return equalSoFar;
    }

    /**
     * Returns the char at the current position and increases the position by 1.
     *
     * @return the char at the current position.
     * @exception BufferUnderflowException
     *                if the position is equal or greater than limit.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.759 -0500", hash_original_method = "1850A36FB6FEA614E5920130AEF47F4F", hash_generated_method = "16456A3FF8F8E0989D5459246EBEF5BE")
    
public abstract char get();

    /**
     * Reads chars from the current position into the specified char array and
     * increases the position by the number of chars read.
     * <p>
     * Calling this method has the same effect as
     * {@code get(dst, 0, dst.length)}.
     *
     * @param dst
     *            the destination char array.
     * @return this buffer.
     * @exception BufferUnderflowException
     *                if {@code dst.length} is greater than {@code remaining()}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.762 -0500", hash_original_method = "CCEA164926296D5352A245D12A0C46F5", hash_generated_method = "191FA0F1A1725B2094DF30D3780BBD15")
    
public CharBuffer get(char[] dst) {
        return get(dst, 0, dst.length);
    }

    /**
     * Reads chars from the current position into the specified char array,
     * starting from the specified offset, and increases the position by the
     * number of chars read.
     *
     * @param dst
     *            the target char array.
     * @param dstOffset
     *            the offset of the char array, must not be negative and not
     *            greater than {@code dst.length}.
     * @param charCount
     *            The number of chars to read, must be no less than zero and no
     *            greater than {@code dst.length - dstOffset}.
     * @return this buffer.
     * @exception IndexOutOfBoundsException
     *                if either {@code dstOffset} or {@code charCount} is invalid.
     * @exception BufferUnderflowException
     *                if {@code charCount} is greater than {@code remaining()}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.765 -0500", hash_original_method = "098FD190C217FD14B547D1BC38021C90", hash_generated_method = "4E65E0F49D964022501BB9659D732E79")
    
public CharBuffer get(char[] dst, int dstOffset, int charCount) {
        Arrays.checkOffsetAndCount(dst.length, dstOffset, charCount);
        if (charCount > remaining()) {
            throw new BufferUnderflowException();
        }
        for (int i = dstOffset; i < dstOffset + charCount; ++i) {
            dst[i] = get();
        }
        return this;
    }

    /**
     * Returns a char at the specified index; the position is not changed.
     *
     * @param index
     *            the index, must not be negative and less than limit.
     * @return a char at the specified index.
     * @exception IndexOutOfBoundsException
     *                if index is invalid.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.768 -0500", hash_original_method = "AAD541C0A943308D03DC370F70AABFC7", hash_generated_method = "702C6AA2AC3B48F035AF66A2D86DBA29")
    
public abstract char get(int index);

    @DSComment("memory buffer only")
    @DSSafe(DSCat.MEM_BUFFER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.770 -0500", hash_original_method = "89C81F0EAF8FCCBFE368437CC8972DD7", hash_generated_method = "9ABCCA1D4392A43B7EAC3713FD39CEA8")
    
public final boolean hasArray() {
        return protectedHasArray();
    }

    /**
     * Calculates this buffer's hash code from the remaining chars. The
     * position, limit, capacity and mark don't affect the hash code.
     *
     * @return the hash code calculated from the remaining chars.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.772 -0500", hash_original_method = "371FAD0CF0C9AC8E78075F4EA52336BD", hash_generated_method = "1E25806FB1ABDE5EAE09DE7EAB683BE8")
    
@Override
    public int hashCode() {
        int myPosition = position;
        int hash = 0;
        while (myPosition < limit) {
            hash = hash + get(myPosition++);
        }
        return hash;
    }

    /**
     * Indicates whether this buffer is direct. A direct buffer will try its
     * best to take advantage of native memory APIs and it may not stay in the
     * Java heap, so it is not affected by garbage collection.
     * <p>
     * A char buffer is direct if it is based on a byte buffer and the byte
     * buffer is direct.
     *
     * @return {@code true} if this buffer is direct, {@code false} otherwise.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.775 -0500", hash_original_method = "2B5243B32EFBD4C87A9512D0DB4C2075", hash_generated_method = "FFC399E278E774AC5C957525392E5B9B")
    
public abstract boolean isDirect();

    /**
     * Returns the number of remaining chars.
     *
     * @return the number of remaining chars.
     */
    @DSComment("memory buffer only")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.777 -0500", hash_original_method = "C49AE9EB347B20902074CA3EBA57FA96", hash_generated_method = "F35DC62349F3AD30827027EE6CC83782")
    
public final int length() {
        return remaining();
    }

    /**
     * Returns the byte order used by this buffer when converting chars from/to
     * bytes.
     * <p>
     * If this buffer is not based on a byte buffer, then this always returns
     * the platform's native byte order.
     *
     * @return the byte order used by this buffer when converting chars from/to
     *         bytes.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.779 -0500", hash_original_method = "2DA427F16EF708C854E7D0C984AF174B", hash_generated_method = "2BEDE1A9F84B5799B19A96DDBD47ABB8")
    
public abstract ByteOrder order();

    /**
     * Child class implements this method to realize {@code array()}.
     *
     * @see #array()
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.782 -0500", hash_original_method = "47D1D50E8E7D288303379675E63DADA6", hash_generated_method = "8B277730029D605093B8781CFD73DDCA")
    
abstract char[] protectedArray();

    /**
     * Child class implements this method to realize {@code arrayOffset()}.
     *
     * @see #arrayOffset()
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.784 -0500", hash_original_method = "9E60C7ACB7338AE2B38C3B6B2C95F717", hash_generated_method = "CF9DD77B0F7512BEF2952176796D1F74")
    
abstract int protectedArrayOffset();

    /**
     * Child class implements this method to realize {@code hasArray()}.
     *
     * @see #hasArray()
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.786 -0500", hash_original_method = "A4BB1744D6CB0B58561CD2147D66FE72", hash_generated_method = "6F3071F3A04983A3B50C9AF29E029577")
    
abstract boolean protectedHasArray();

    /**
     * Writes the given char to the current position and increases the position
     * by 1.
     *
     * @param c
     *            the char to write.
     * @return this buffer.
     * @exception BufferOverflowException
     *                if position is equal or greater than limit.
     * @exception ReadOnlyBufferException
     *                if no changes may be made to the contents of this buffer.
     */
    @DSComment("Abstract Method")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.789 -0500", hash_original_method = "F19EB97E90F9577C945FC2A86DA468D8", hash_generated_method = "85AFD595D3F36EA1A3437288DCA79CB7")
    
public abstract CharBuffer put(char c);

    /**
     * Writes chars from the given char array to the current position and
     * increases the position by the number of chars written.
     * <p>
     * Calling this method has the same effect as
     * {@code put(src, 0, src.length)}.
     *
     * @param src
     *            the source char array.
     * @return this buffer.
     * @exception BufferOverflowException
     *                if {@code remaining()} is less than {@code src.length}.
     * @exception ReadOnlyBufferException
     *                if no changes may be made to the contents of this buffer.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.791 -0500", hash_original_method = "470B54D034ECB079323054E5FA7FB003", hash_generated_method = "43651BE45F5D8F0AFEEB782FAE4BFA77")
    
public final CharBuffer put(char[] src) {
        return put(src, 0, src.length);
    }

    /**
     * Writes chars from the given char array, starting from the specified offset,
     * to the current position and increases the position by the number of chars
     * written.
     *
     * @param src
     *            the source char array.
     * @param srcOffset
     *            the offset of char array, must not be negative and not greater
     *            than {@code src.length}.
     * @param charCount
     *            the number of chars to write, must be no less than zero and no
     *            greater than {@code src.length - srcOffset}.
     * @return this buffer.
     * @exception BufferOverflowException
     *                if {@code remaining()} is less than {@code charCount}.
     * @exception IndexOutOfBoundsException
     *                if either {@code srcOffset} or {@code charCount} is invalid.
     * @exception ReadOnlyBufferException
     *                if no changes may be made to the contents of this buffer.
     */
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.794 -0500", hash_original_method = "022BE284F152CDC3C1FB1410D39A7C9D", hash_generated_method = "02D3786322E03C26806C036B38D25D9E")
    
public CharBuffer put(char[] src, int srcOffset, int charCount) {
        Arrays.checkOffsetAndCount(src.length, srcOffset, charCount);
        if (charCount > remaining()) {
            throw new BufferOverflowException();
        }
        for (int i = srcOffset; i < srcOffset + charCount; ++i) {
            put(src[i]);
        }
        return this;
    }

    /**
     * Writes all the remaining chars of the {@code src} char buffer to this
     * buffer's current position, and increases both buffers' position by the
     * number of chars copied.
     *
     * @param src
     *            the source char buffer.
     * @return this buffer.
     * @exception BufferOverflowException
     *                if {@code src.remaining()} is greater than this buffer's
     *                {@code remaining()}.
     * @exception IllegalArgumentException
     *                if {@code src} is this buffer.
     * @exception ReadOnlyBufferException
     *                if no changes may be made to the contents of this buffer.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.796 -0500", hash_original_method = "37C3423DFAF6E5EC51AB38006AB488BA", hash_generated_method = "81937F4E7EC54F35925FFCA752194CC2")
    
public CharBuffer put(CharBuffer src) {
        if (src == this) {
            throw new IllegalArgumentException();
        }
        if (src.remaining() > remaining()) {
            throw new BufferOverflowException();
        }

        char[] contents = new char[src.remaining()];
        src.get(contents);
        put(contents);
        return this;
    }

    /**
     * Writes a char to the specified index of this buffer; the position is not
     * changed.
     *
     * @param index
     *            the index, must be no less than zero and less than the limit.
     * @param c
     *            the char to write.
     * @return this buffer.
     * @exception IndexOutOfBoundsException
     *                if index is invalid.
     * @exception ReadOnlyBufferException
     *                if no changes may be made to the contents of this buffer.
     */
    @DSComment("Abstract Method")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.799 -0500", hash_original_method = "B4FC48477262D11801112BB7E12149CE", hash_generated_method = "D715DB6A762D536206BD0E9BF8B1E04B")
    
public abstract CharBuffer put(int index, char c);

    /**
     * Writes all chars of the given string to the current position of this
     * buffer, and increases the position by the length of string.
     * <p>
     * Calling this method has the same effect as
     * {@code put(str, 0, str.length())}.
     *
     * @param str
     *            the string to write.
     * @return this buffer.
     * @exception BufferOverflowException
     *                if {@code remaining()} is less than the length of string.
     * @exception ReadOnlyBufferException
     *                if no changes may be made to the contents of this buffer.
     */
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.802 -0500", hash_original_method = "E7006B831E6768B620311924466DB7A4", hash_generated_method = "4B9B6ED275EF14DF7F13CE8DBE9C44E1")
    
public final CharBuffer put(String str) {
        return put(str, 0, str.length());
    }

    /**
     * Writes chars of the given string to the current position of this buffer,
     * and increases the position by the number of chars written.
     *
     * @param str
     *            the string to write.
     * @param start
     *            the first char to write, must not be negative and not greater
     *            than {@code str.length()}.
     * @param end
     *            the last char to write (excluding), must be less than
     *            {@code start} and not greater than {@code str.length()}.
     * @return this buffer.
     * @exception BufferOverflowException
     *                if {@code remaining()} is less than {@code end - start}.
     * @exception IndexOutOfBoundsException
     *                if either {@code start} or {@code end} is invalid.
     * @exception ReadOnlyBufferException
     *                if no changes may be made to the contents of this buffer.
     */
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.804 -0500", hash_original_method = "D2CD34EAF4E6074C289823E8F75291E2", hash_generated_method = "BEBCA007E3E0477D10B11131B9FB7D27")
    
public CharBuffer put(String str, int start, int end) {
        if (start < 0 || end < start || end > str.length()) {
            throw new IndexOutOfBoundsException("str.length()=" + str.length() +
                    ", start=" + start + ", end=" + end);
        }
        if (end - start > remaining()) {
            throw new BufferOverflowException();
        }
        for (int i = start; i < end; i++) {
            put(str.charAt(i));
        }
        return this;
    }

    /**
     * Returns a sliced buffer that shares its content with this buffer.
     * <p>
     * The sliced buffer's capacity will be this buffer's {@code remaining()},
     * and its zero position will correspond to this buffer's current position.
     * The new buffer's position will be 0, limit will be its capacity, and its
     * mark is cleared. The new buffer's read-only property and byte order are
     * same as this buffer.
     * <p>
     * The new buffer shares its content with this buffer, which means either
     * buffer's change of content will be visible to the other. The two buffer's
     * position, limit and mark are independent.
     *
     * @return a sliced buffer that shares its content with this buffer.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.806 -0500", hash_original_method = "C5C9BF0F4A6933B0CC2EE10D9BDC82D3", hash_generated_method = "A48B1767436E9EA6AC807558E9050885")
    
public abstract CharBuffer slice();

    /**
     * Returns a new char buffer representing a sub-sequence of this buffer's
     * current remaining content.
     * <p>
     * The new buffer's position will be {@code position() + start}, limit will
     * be {@code position() + end}, capacity will be the same as this buffer.
     * The new buffer's read-only property and byte order are the same as this
     * buffer.
     * <p>
     * The new buffer shares its content with this buffer, which means either
     * buffer's change of content will be visible to the other. The two buffer's
     * position, limit and mark are independent.
     *
     * @param start
     *            the start index of the sub-sequence, referenced from the
     *            current buffer position. Must not be less than zero and not
     *            greater than the value obtained from a call to
     *            {@code remaining()}.
     * @param end
     *            the end index of the sub-sequence, referenced from the current
     *            buffer position. Must not be less than {@code start} and not
     *            be greater than the value obtained from a call to
     *            {@code remaining()}.
     * @return a new char buffer represents a sub-sequence of this buffer's
     *         current remaining content.
     * @exception IndexOutOfBoundsException
     *                if either {@code start} or {@code end} is invalid.
     */
    @DSComment("Abstract Method")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.809 -0500", hash_original_method = "CC1A918E751879C0CACBEAD0F53D48ED", hash_generated_method = "460F5702CFF0539D37C9D86BAB80AFE3")
    
public abstract CharSequence subSequence(int start, int end);

    /**
     * Returns a string representing the current remaining chars of this buffer.
     */
    @DSComment("memory buffer only")
    @DSSafe(DSCat.MEM_BUFFER)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.812 -0500", hash_original_method = "7C6B898DBE310393A5687B676A637050", hash_generated_method = "00B4A448AFB77E5525AA5B006C3CEB6D")
    
@Override
    public String toString() {
        StringBuilder result = new StringBuilder(limit - position);
        for (int i = position; i < limit; i++) {
            result.append(get(i));
        }
        return result.toString();
    }

    /**
     * Writes the given char to the current position and increases the position
     * by 1.
     *
     * @param c
     *            the char to write.
     * @return this buffer.
     * @exception BufferOverflowException
     *                if position is equal or greater than limit.
     * @exception ReadOnlyBufferException
     *                if no changes may be made to the contents of this buffer.
     */
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.814 -0500", hash_original_method = "B2B921133AE3BAD544E239EA4D0BB16C", hash_generated_method = "9E7DD5F3797D5B52007932CF09EB8FBB")
    
public CharBuffer append(char c) {
        return put(c);
    }

    /**
     * Writes all chars of the given character sequence {@code csq} to the
     * current position of this buffer, and increases the position by the length
     * of the csq.
     * <p>
     * Calling this method has the same effect as {@code append(csq.toString())}.
     * If the {@code CharSequence} is {@code null} the string "null" will be
     * written to the buffer.
     *
     * @param csq
     *            the {@code CharSequence} to write.
     * @return this buffer.
     * @exception BufferOverflowException
     *                if {@code remaining()} is less than the length of csq.
     * @exception ReadOnlyBufferException
     *                if no changes may be made to the contents of this buffer.
     */
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.816 -0500", hash_original_method = "832DE990D6C4F53D8F1E55F3872916C2", hash_generated_method = "2E9F81D0A0AB63E64D2C92C0A73F4023")
    
public CharBuffer append(CharSequence csq) {
        if (csq != null) {
            return put(csq.toString());
        }
        return put("null");
    }

    /**
     * Writes chars of the given {@code CharSequence} to the current position of
     * this buffer, and increases the position by the number of chars written.
     *
     * @param csq
     *            the {@code CharSequence} to write.
     * @param start
     *            the first char to write, must not be negative and not greater
     *            than {@code csq.length()}.
     * @param end
     *            the last char to write (excluding), must be less than
     *            {@code start} and not greater than {@code csq.length()}.
     * @return this buffer.
     * @exception BufferOverflowException
     *                if {@code remaining()} is less than {@code end - start}.
     * @exception IndexOutOfBoundsException
     *                if either {@code start} or {@code end} is invalid.
     * @exception ReadOnlyBufferException
     *                if no changes may be made to the contents of this buffer.
     */
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.818 -0500", hash_original_method = "006D95454A8B407A6CE6A3881397CD6E", hash_generated_method = "2D33A52979140EEEDD22B43246DAD055")
    
public CharBuffer append(CharSequence csq, int start, int end) {
        if (csq == null) {
            csq = "null";
        }
        CharSequence cs = csq.subSequence(start, end);
        if (cs.length() > 0) {
            return put(cs.toString());
        }
        return this;
    }

    /**
     * Reads characters from this buffer and puts them into {@code target}. The
     * number of chars that are copied is either the number of remaining chars
     * in this buffer or the number of remaining chars in {@code target},
     * whichever is smaller.
     *
     * @param target
     *            the target char buffer.
     * @throws IllegalArgumentException
     *             if {@code target} is this buffer.
     * @throws IOException
     *             if an I/O error occurs.
     * @throws ReadOnlyBufferException
     *             if no changes may be made to the contents of {@code target}.
     * @return the number of chars copied or -1 if there are no chars left to be
     *         read from this buffer.
     */
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:02.821 -0500", hash_original_method = "412283507A99EDD12D2C7BFEC4EFD5FB", hash_generated_method = "68C4C9B2FB6A1D49B82F37C0DD39E65D")
    
public int read(CharBuffer target) throws IOException {
        int remaining = remaining();
        if (target == this) {
            if (remaining == 0) {
                return -1;
            }
            throw new IllegalArgumentException();
        }
        if (remaining == 0) {
            return limit > 0 && target.remaining() == 0 ? 0 : -1;
        }
        remaining = Math.min(target.remaining(), remaining);
        if (remaining > 0) {
            char[] chars = new char[remaining];
            get(chars);
            target.put(chars);
        }
        return remaining;
    }
    
}

