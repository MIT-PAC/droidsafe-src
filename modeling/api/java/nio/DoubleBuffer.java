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
import java.util.Arrays;

public abstract class DoubleBuffer extends Buffer implements Comparable<DoubleBuffer> {

    /**
     * Creates a double buffer based on a newly allocated double array.
     *
     * @param capacity
     *            the capacity of the new buffer.
     * @return the created double buffer.
     * @throws IllegalArgumentException
     *             if {@code capacity} is less than zero.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.476 -0500", hash_original_method = "8705AFB5C37A38E8556AB4BF7EE2EBD2", hash_generated_method = "17359EE43527564D54CEDB763700A7D9")
    
public static DoubleBuffer allocate(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }
        return new ReadWriteDoubleArrayBuffer(capacity);
    }

    /**
     * Creates a new double buffer by wrapping the given double array.
     * <p>
     * Calling this method has the same effect as
     * {@code wrap(array, 0, array.length)}.
     *
     * @param array
     *            the double array which the new buffer will be based on.
     * @return the created double buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.479 -0500", hash_original_method = "C8CC9781A388E0CB6C7BA02CBEA33636", hash_generated_method = "BC01358C0A1FA425E8584B6C829F4084")
    
public static DoubleBuffer wrap(double[] array) {
        return wrap(array, 0, array.length);
    }

    /**
     * Creates a new double buffer by wrapping the given double array.
     * <p>
     * The new buffer's position will be {@code start}, limit will be
     * {@code start + doubleCount}, capacity will be the length of the array.
     *
     * @param array
     *            the double array which the new buffer will be based on.
     * @param start
     *            the start index, must not be negative and not greater than
     *            {@code array.length}.
     * @param doubleCount
     *            the length, must not be negative and not greater than
     *            {@code array.length - start}.
     * @return the created double buffer.
     * @exception IndexOutOfBoundsException
     *                if either {@code start} or {@code doubleCount} is invalid.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.482 -0500", hash_original_method = "1630A46B23D7E07EE618F29BEE62BADD", hash_generated_method = "701B8B350E5A0892D9C9522E1DC521AA")
    
public static DoubleBuffer wrap(double[] array, int start, int doubleCount) {
        Arrays.checkOffsetAndCount(array.length, start, doubleCount);
        DoubleBuffer buf = new ReadWriteDoubleArrayBuffer(array);
        buf.position = start;
        buf.limit = start + doubleCount;
        return buf;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.485 -0500", hash_original_method = "0AF8846C39B4C946E7DEA048FA516A89", hash_generated_method = "0AF8846C39B4C946E7DEA048FA516A89")
    
DoubleBuffer(int capacity) {
        super(3, capacity, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.488 -0500", hash_original_method = "A99B5F03AD18580EAA75CC7BA40FC0CE", hash_generated_method = "247E849ED78FF8066C268E0F8468AB4D")
    
public final double[] array() {
        return protectedArray();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.490 -0500", hash_original_method = "0D5EF56CBEA1DA16093A6276D10D9347", hash_generated_method = "28A2D71AE8939DE09018E333ADFF6CAE")
    
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
     * The new buffer shares its content with this buffer, which means that this
     * buffer's change of content will be visible to the new buffer. The two
     * buffer's position, limit and mark are independent.
     *
     * @return a read-only version of this buffer.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.492 -0500", hash_original_method = "2996A979A5716E23EE7031EA0434A8A0", hash_generated_method = "93D395317BFB18A9570C50EB29903EC8")
    
public abstract DoubleBuffer asReadOnlyBuffer();

    /**
     * Compacts this double buffer.
     * <p>
     * The remaining doubles will be moved to the head of the buffer, staring
     * from position zero. Then the position is set to {@code remaining()}; the
     * limit is set to capacity; the mark is cleared.
     *
     * @return this buffer.
     * @exception ReadOnlyBufferException
     *                if no changes may be made to the contents of this buffer.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.494 -0500", hash_original_method = "5043B711725CD9D2E916986208C437D3", hash_generated_method = "66EBDB25A24171CBACA0C8BB86DE2DDE")
    
public abstract DoubleBuffer compact();

    /**
     * Compare the remaining doubles of this buffer to another double buffer's
     * remaining doubles.
     *
     * @param otherBuffer
     *            another double buffer.
     * @return a negative value if this is less than {@code other}; 0 if this
     *         equals to {@code other}; a positive value if this is greater
     *         than {@code other}.
     * @exception ClassCastException
     *                if {@code other} is not a double buffer.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.497 -0500", hash_original_method = "A9C47546143A1E2A817B74D1052E5DC9", hash_generated_method = "9E80DB9DA9386DCD90EA39CFF14B66EC")
    
public int compareTo(DoubleBuffer otherBuffer) {
        int compareRemaining = (remaining() < otherBuffer.remaining()) ? remaining()
                : otherBuffer.remaining();
        int thisPos = position;
        int otherPos = otherBuffer.position;
        double thisDouble, otherDouble;
        while (compareRemaining > 0) {
            thisDouble = get(thisPos);
            otherDouble = otherBuffer.get(otherPos);
            // checks for double and NaN inequality
            if ((thisDouble != otherDouble)
                    && ((thisDouble == thisDouble) || (otherDouble == otherDouble))) {
                return thisDouble < otherDouble ? -1 : 1;
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
     * The duplicated buffer's position, limit, capacity and mark are the same
     * as this buffer's. The duplicated buffer's read-only property and byte
     * order are the same as this buffer's, too.
     * <p>
     * The new buffer shares its content with this buffer, which means either
     * buffer's change of content will be visible to the other. The two buffer's
     * position, limit and mark are independent.
     *
     * @return a duplicated buffer that shares its content with this buffer.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.500 -0500", hash_original_method = "BE74DB03EFC9DDBAB8ADF6C6A34C3321", hash_generated_method = "2179A62EFF99EE7867A1A432E0A5EF00")
    
public abstract DoubleBuffer duplicate();

    /**
     * Checks whether this double buffer is equal to another object. If {@code
     * other} is not a {@code DoubleBuffer} then {@code false} is returned.
     *
     * <p>Two double buffers are equal if their remaining doubles are equal.
     * Position, limit, capacity and mark are not considered.
     *
     * <p>This method considers two doubles {@code a} and {@code b} to be equal
     * if {@code a == b} or if {@code a} and {@code b} are both {@code NaN}.
     * Unlike {@link Double#equals}, this method considers {@code -0.0} and
     * {@code +0.0} to be equal.
     *
     * @param other
     *            the object to compare with this double buffer.
     * @return {@code true} if this double buffer is equal to {@code other},
     *         {@code false} otherwise.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.503 -0500", hash_original_method = "80D65346F74BD859AA9774E55290B1E1", hash_generated_method = "102FD7DB2A5779E73C016EEB090B84D0")
    
@Override
    public boolean equals(Object other) {
        if (!(other instanceof DoubleBuffer)) {
            return false;
        }
        DoubleBuffer otherBuffer = (DoubleBuffer) other;

        if (remaining() != otherBuffer.remaining()) {
            return false;
        }

        int myPosition = position;
        int otherPosition = otherBuffer.position;
        boolean equalSoFar = true;
        while (equalSoFar && (myPosition < limit)) {
            double a = get(myPosition++);
            double b = otherBuffer.get(otherPosition++);
            equalSoFar = a == b || (a != a && b != b);
        }

        return equalSoFar;
    }

    /**
     * Returns the double at the current position and increases the position by
     * 1.
     *
     * @return the double at the current position.
     * @exception BufferUnderflowException
     *                if the position is equal or greater than limit.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.506 -0500", hash_original_method = "7B91F8C48D472EDDE3E7E19AB4EA9792", hash_generated_method = "889ACFF9EFCF93B8782B2974FC4C8A68")
    
public abstract double get();

    /**
     * Reads doubles from the current position into the specified double array
     * and increases the position by the number of doubles read.
     * <p>
     * Calling this method has the same effect as
     * {@code get(dst, 0, dst.length)}.
     *
     * @param dst
     *            the destination double array.
     * @return this buffer.
     * @exception BufferUnderflowException
     *                if {@code dst.length} is greater than {@code remaining()}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.509 -0500", hash_original_method = "9BEB92FAE64B1253EE6CA9009E99F3B4", hash_generated_method = "B2C1AFE0F8659736164D0D822A275DAE")
    
public DoubleBuffer get(double[] dst) {
        return get(dst, 0, dst.length);
    }

    /**
     * Reads doubles from the current position into the specified double array,
     * starting from the specified offset, and increases the position by the
     * number of doubles read.
     *
     * @param dst
     *            the target double array.
     * @param dstOffset
     *            the offset of the double array, must not be negative and not
     *            greater than {@code dst.length}.
     * @param doubleCount
     *            the number of doubles to read, must be no less than zero and
     *            not greater than {@code dst.length - dstOffset}.
     * @return this buffer.
     * @exception IndexOutOfBoundsException
     *                if either {@code dstOffset} or {@code doubleCount} is invalid.
     * @exception BufferUnderflowException
     *                if {@code doubleCount} is greater than {@code remaining()}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.512 -0500", hash_original_method = "38134BA6A99F502238B51F3879F810C3", hash_generated_method = "EAC8151AE9324153277E4F151BA8F7BE")
    
public DoubleBuffer get(double[] dst, int dstOffset, int doubleCount) {
        Arrays.checkOffsetAndCount(dst.length, dstOffset, doubleCount);
        if (doubleCount > remaining()) {
            throw new BufferUnderflowException();
        }
        for (int i = dstOffset; i < dstOffset + doubleCount; ++i) {
            dst[i] = get();
        }
        return this;
    }

    /**
     * Returns a double at the specified index; the position is not changed.
     *
     * @param index
     *            the index, must not be negative and less than limit.
     * @return a double at the specified index.
     * @exception IndexOutOfBoundsException
     *                if index is invalid.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.514 -0500", hash_original_method = "7290F82235CCB3FE6BC33C45B069AD65", hash_generated_method = "448C75914A10D7B3AD8F4293CA72E646")
    
public abstract double get(int index);

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.517 -0500", hash_original_method = "89C81F0EAF8FCCBFE368437CC8972DD7", hash_generated_method = "9ABCCA1D4392A43B7EAC3713FD39CEA8")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.519 -0500", hash_original_method = "BF88872009B539EF877B1EA5B03706BA", hash_generated_method = "5943EB7BD659C5FC2B0BB3B0313FB053")
    
@Override
    public int hashCode() {
        int myPosition = position;
        int hash = 0;
        long l;
        while (myPosition < limit) {
            l = Double.doubleToLongBits(get(myPosition++));
            hash = hash + ((int) l) ^ ((int) (l >> 32));
        }
        return hash;
    }

    /**
     * Indicates whether this buffer is direct. A direct buffer will try its
     * best to take advantage of native memory APIs and it may not stay in the
     * Java heap, so it is not affected by garbage collection.
     * <p>
     * A double buffer is direct if it is based on a byte buffer and the byte
     * buffer is direct.
     *
     * @return {@code true} if this buffer is direct, {@code false} otherwise.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.522 -0500", hash_original_method = "2B5243B32EFBD4C87A9512D0DB4C2075", hash_generated_method = "FFC399E278E774AC5C957525392E5B9B")
    
public abstract boolean isDirect();

    /**
     * Returns the byte order used by this buffer when converting doubles
     * from/to bytes.
     * <p>
     * If this buffer is not based on a byte buffer, then this always returns
     * the platform's native byte order.
     *
     * @return the byte order used by this buffer when converting doubles
     *         from/to bytes.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.524 -0500", hash_original_method = "2DA427F16EF708C854E7D0C984AF174B", hash_generated_method = "2BEDE1A9F84B5799B19A96DDBD47ABB8")
    
public abstract ByteOrder order();

    /**
     * Child class implements this method to realize {@code array()}.
     *
     * @see #array()
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.527 -0500", hash_original_method = "05186557823E0B28309E4FCD9E9DC118", hash_generated_method = "2DB88162F6826E8682859A2F8B550312")
    
abstract double[] protectedArray();

    /**
     * Child class implements this method to realize {@code arrayOffset()}.
     *
     * @see #arrayOffset()
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.529 -0500", hash_original_method = "9E60C7ACB7338AE2B38C3B6B2C95F717", hash_generated_method = "CF9DD77B0F7512BEF2952176796D1F74")
    
abstract int protectedArrayOffset();

    /**
     * Child class implements this method to realize {@code hasArray()}.
     *
     * @see #hasArray()
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.532 -0500", hash_original_method = "A4BB1744D6CB0B58561CD2147D66FE72", hash_generated_method = "6F3071F3A04983A3B50C9AF29E029577")
    
abstract boolean protectedHasArray();

    /**
     * Writes the given double to the current position and increases the
     * position by 1.
     *
     * @param d
     *            the double to write.
     * @return this buffer.
     * @exception BufferOverflowException
     *                if position is equal or greater than limit.
     * @exception ReadOnlyBufferException
     *                if no changes may be made to the contents of this buffer.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.534 -0500", hash_original_method = "6E5D9E716104CE1312BE9B8492AD9715", hash_generated_method = "0E56ACB0C2D9601A7CDB7EDCA63EEE43")
    
public abstract DoubleBuffer put(double d);

    /**
     * Writes doubles from the given double array to the current position and
     * increases the position by the number of doubles written.
     * <p>
     * Calling this method has the same effect as
     * {@code put(src, 0, src.length)}.
     *
     * @param src
     *            the source double array.
     * @return this buffer.
     * @exception BufferOverflowException
     *                if {@code remaining()} is less than {@code src.length}.
     * @exception ReadOnlyBufferException
     *                if no changes may be made to the contents of this buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.537 -0500", hash_original_method = "93B6D9B754146968969402F4C9473429", hash_generated_method = "9086CA4F187C6C341ABF44AECEF0BE47")
    
public final DoubleBuffer put(double[] src) {
        return put(src, 0, src.length);
    }

    /**
     * Writes doubles from the given double array, starting from the specified
     * offset, to the current position and increases the position by the number
     * of doubles written.
     *
     * @param src
     *            the source double array.
     * @param srcOffset
     *            the offset of double array, must not be negative and not
     *            greater than {@code src.length}.
     * @param doubleCount
     *            the number of doubles to write, must be no less than zero and
     *            not greater than {@code src.length - srcOffset}.
     * @return this buffer.
     * @exception BufferOverflowException
     *                if {@code remaining()} is less than {@code doubleCount}.
     * @exception IndexOutOfBoundsException
     *                if either {@code srcOffset} or {@code doubleCount} is invalid.
     * @exception ReadOnlyBufferException
     *                if no changes may be made to the contents of this buffer.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.539 -0500", hash_original_method = "3E73039BF6DB142176253DE2263B83AD", hash_generated_method = "4F015A29746EB1C0C69EB5D48214782E")
    
public DoubleBuffer put(double[] src, int srcOffset, int doubleCount) {
        Arrays.checkOffsetAndCount(src.length, srcOffset, doubleCount);
        if (doubleCount > remaining()) {
            throw new BufferOverflowException();
        }
        for (int i = srcOffset; i < srcOffset + doubleCount; ++i) {
            put(src[i]);
        }
        return this;
    }

    /**
     * Writes all the remaining doubles of the {@code src} double buffer to this
     * buffer's current position, and increases both buffers' position by the
     * number of doubles copied.
     *
     * @param src
     *            the source double buffer.
     * @return this buffer.
     * @exception BufferOverflowException
     *                if {@code src.remaining()} is greater than this buffer's
     *                {@code remaining()}.
     * @exception IllegalArgumentException
     *                if {@code src} is this buffer.
     * @exception ReadOnlyBufferException
     *                if no changes may be made to the contents of this buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.542 -0500", hash_original_method = "C52ECDE4782921BA374F433E41853287", hash_generated_method = "95737D85E66B3030D7731AABF243BE8B")
    
public DoubleBuffer put(DoubleBuffer src) {
        if (src == this) {
            throw new IllegalArgumentException();
        }
        if (src.remaining() > remaining()) {
            throw new BufferOverflowException();
        }
        double[] doubles = new double[src.remaining()];
        src.get(doubles);
        put(doubles);
        return this;
    }

    /**
     * Write a double to the specified index of this buffer and the position is
     * not changed.
     *
     * @param index
     *            the index, must not be negative and less than the limit.
     * @param d
     *            the double to write.
     * @return this buffer.
     * @exception IndexOutOfBoundsException
     *                if index is invalid.
     * @exception ReadOnlyBufferException
     *                if no changes may be made to the contents of this buffer.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.544 -0500", hash_original_method = "FC1229DDC34A77EC4BA7A954517E40A4", hash_generated_method = "D2EAEEF2A722DC0BF5CB5A7204366CD4")
    
public abstract DoubleBuffer put(int index, double d);

    /**
     * Returns a sliced buffer that shares its content with this buffer.
     * <p>
     * The sliced buffer's capacity will be this buffer's {@code remaining()},
     * and its zero position will correspond to this buffer's current position.
     * The new buffer's position will be 0, limit will be its capacity, and its
     * mark is cleared. The new buffer's read-only property and byte order are
     * the same as this buffer's.
     * <p>
     * The new buffer shares its content with this buffer, which means either
     * buffer's change of content will be visible to the other. The two buffer's
     * position, limit and mark are independent.
     *
     * @return a sliced buffer that shares its content with this buffer.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.547 -0500", hash_original_method = "77285C0B11D6FAF3123027CAFA126E55", hash_generated_method = "FFE5DDEBAB752CC87926AAAD15D2E4AA")
    
public abstract DoubleBuffer slice();
    
}

