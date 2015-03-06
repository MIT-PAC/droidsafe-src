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
 * Written by Doug Lea with assistance from members of JCP JSR-166
 * Expert Group and released to the public domain, as explained at
 * http://creativecommons.org/licenses/publicdomain
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


/*
 * Written by Doug Lea with assistance from members of JCP JSR-166
 * Expert Group and released to the public domain, as explained at
 * http://creativecommons.org/publicdomain/zero/1.0/
 */

package java.util.concurrent.atomic;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import sun.misc.Unsafe;

/**
 * An {@code int} array in which elements may be updated atomically.
 * See the {@link java.util.concurrent.atomic} package
 * specification for description of the properties of atomic
 * variables.
 * @since 1.5
 * @author Doug Lea
 */
public class AtomicIntegerArray implements java.io.Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.381 -0400", hash_original_field = "6664CBF7AC3521EC840C2F6B7D523C0F", hash_generated_field = "AA688CC66EEACDDF831BA2DF2A514AB4")

    private static final long serialVersionUID = 2862133569453604235L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.381 -0400", hash_original_field = "45AA3EADCAC9C9E31A558AD2E7D920BC", hash_generated_field = "225667B44D983DC733D3AAE856B0466F")

    private static final Unsafe unsafe = Unsafe.getUnsafe();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.382 -0400", hash_original_field = "7AE2EC4C7CE8C768097B19AB2C2A693C", hash_generated_field = "5EA6FC671EF34E60C45A8492EB63175B")

    private static final int base = unsafe.arrayBaseOffset(int[].class);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.382 -0400", hash_original_field = "EFC9E38E68B764BB5996C858EA2A5584", hash_generated_field = "FF5851CA3D0F293AEAEEEA589F926E4D")

    private static  int shift;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.384 -0400", hash_original_method = "AC5839B0E4D62288830D21A694D63CDF", hash_generated_method = "2D3E4D341B1B4AD89EA5B6D21FA9D61C")
    
private static long byteOffset(int i) {
        return ((long) i << shift) + base;
    }

    static {
        int scale = unsafe.arrayIndexScale(int[].class);
        if ((scale & (scale - 1)) != 0)
            throw new Error("data type scale not a power of two");
        shift = 31 - Integer.numberOfLeadingZeros(scale);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.383 -0400", hash_original_field = "E18B52A18AA69F65BEAFE3B6E2633123", hash_generated_field = "5A96236BC27A5B1DA7EEA644E06CB29F")

    private  int[] array;

    /**
     * Creates a new AtomicIntegerArray of the given length, with all
     * elements initially zero.
     *
     * @param length the length of the array
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.384 -0400", hash_original_method = "493DDE601B16F20B8C727AEC5BE72075", hash_generated_method = "3A5AD5EA689A95BFAC76537067494A80")
    
public AtomicIntegerArray(int length) {
        array = new int[length];
    }

    /**
     * Creates a new AtomicIntegerArray with the same length as, and
     * all elements copied from, the given array.
     *
     * @param array the array to copy elements from
     * @throws NullPointerException if array is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.384 -0400", hash_original_method = "543A4E4207D46955001B65E3AC416795", hash_generated_method = "2EE7E03CBF0E974160BD192726514A54")
    
public AtomicIntegerArray(int[] array) {
        // Visibility guaranteed by final field guarantees
        this.array = array.clone();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.383 -0400", hash_original_method = "362098406DB6EC351C04D37BE5D9828B", hash_generated_method = "3DF43E0CE44DBFABB38293E3A8286B16")
    
private long checkedByteOffset(int i) {
        if (i < 0 || i >= array.length)
            throw new IndexOutOfBoundsException("index " + i);

        return byteOffset(i);
    }

    /**
     * Returns the length of the array.
     *
     * @return the length of the array
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.385 -0400", hash_original_method = "27E0D57FF2AEBC70EE6BF760C51E525C", hash_generated_method = "70C186BF3C020F97975A93D7ABF97EE3")
    
public final int length() {
        return array.length;
    }

    /**
     * Gets the current value at position {@code i}.
     *
     * @param i the index
     * @return the current value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.385 -0400", hash_original_method = "F6EF482A72D4E7956662802598CF2920", hash_generated_method = "854852F34A375172415E76DD5830AE66")
    
public final int get(int i) {
        return getRaw(checkedByteOffset(i));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.386 -0400", hash_original_method = "49387FB80F1D9CBF5D7D15937B915827", hash_generated_method = "6FDF05E9F7D44A999676AE5E0B5CE6EB")
    
private int getRaw(long offset) {
        return unsafe.getIntVolatile(array, offset);
    }

    /**
     * Sets the element at position {@code i} to the given value.
     *
     * @param i the index
     * @param newValue the new value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.386 -0400", hash_original_method = "D0DF03C10EB92F5BCEEBFA38E3C69FA1", hash_generated_method = "E904DBDAF899B839AEDB8C01CD3F2ED0")
    
public final void set(int i, int newValue) {
        unsafe.putIntVolatile(array, checkedByteOffset(i), newValue);
    }

    /**
     * Eventually sets the element at position {@code i} to the given value.
     *
     * @param i the index
     * @param newValue the new value
     * @since 1.6
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.386 -0400", hash_original_method = "699D659F9108A9DAD9A977427BDF5361", hash_generated_method = "C6A1801216E916FBEE131B68C0EBC8EE")
    
public final void lazySet(int i, int newValue) {
        unsafe.putOrderedInt(array, checkedByteOffset(i), newValue);
    }

    /**
     * Atomically sets the element at position {@code i} to the given
     * value and returns the old value.
     *
     * @param i the index
     * @param newValue the new value
     * @return the previous value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.387 -0400", hash_original_method = "2BB6948F65CCE4B66F7D807089C7A79A", hash_generated_method = "CB219E7B8A84F5459422BC91B0C5F7FE")
    
public final int getAndSet(int i, int newValue) {
        long offset = checkedByteOffset(i);
        while (true) {
            int current = getRaw(offset);
            if (compareAndSetRaw(offset, current, newValue))
                return current;
        }
    }

    /**
     * Atomically sets the element at position {@code i} to the given
     * updated value if the current value {@code ==} the expected value.
     *
     * @param i the index
     * @param expect the expected value
     * @param update the new value
     * @return true if successful. False return indicates that
     * the actual value was not equal to the expected value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.387 -0400", hash_original_method = "1249D8442EF88839CA4A565F5104B09E", hash_generated_method = "DA16518D8201C75EE0527110FA1023DE")
    
public final boolean compareAndSet(int i, int expect, int update) {
        return compareAndSetRaw(checkedByteOffset(i), expect, update);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.388 -0400", hash_original_method = "F873A031C56477515B7C76771B28875F", hash_generated_method = "195F9C28DA9B7698A8D2A4EAF532BC75")
    
private boolean compareAndSetRaw(long offset, int expect, int update) {
        return unsafe.compareAndSwapInt(array, offset, expect, update);
    }

    /**
     * Atomically sets the element at position {@code i} to the given
     * updated value if the current value {@code ==} the expected value.
     *
     * <p><a href="package-summary.html#weakCompareAndSet">May fail
     * spuriously and does not provide ordering guarantees</a>, so is
     * only rarely an appropriate alternative to {@code compareAndSet}.
     *
     * @param i the index
     * @param expect the expected value
     * @param update the new value
     * @return true if successful
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.388 -0400", hash_original_method = "9CF348CAAB9BF0BDEA824D28757D28F4", hash_generated_method = "835EBB45D28C47BBE7CD29410BFBC50B")
    
public final boolean weakCompareAndSet(int i, int expect, int update) {
        return compareAndSet(i, expect, update);
    }

    /**
     * Atomically increments by one the element at index {@code i}.
     *
     * @param i the index
     * @return the previous value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.388 -0400", hash_original_method = "88FEC8BC52387541C7A280879E09B502", hash_generated_method = "33858EB65A243196D56BB6B7BB99FDB9")
    
public final int getAndIncrement(int i) {
        return getAndAdd(i, 1);
    }

    /**
     * Atomically decrements by one the element at index {@code i}.
     *
     * @param i the index
     * @return the previous value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.389 -0400", hash_original_method = "51318A098495A0CA12CF5240A256B56D", hash_generated_method = "35B67CE9C0FD33494DFBD865979F83DF")
    
public final int getAndDecrement(int i) {
        return getAndAdd(i, -1);
    }

    /**
     * Atomically adds the given value to the element at index {@code i}.
     *
     * @param i the index
     * @param delta the value to add
     * @return the previous value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.390 -0400", hash_original_method = "DBE224F15753EB877B182F1A80EE299E", hash_generated_method = "AAC6088DAC710AD01A0F88D89874CB83")
    
public final int getAndAdd(int i, int delta) {
        long offset = checkedByteOffset(i);
        while (true) {
            int current = getRaw(offset);
            if (compareAndSetRaw(offset, current, current + delta))
                return current;
        }
    }

    /**
     * Atomically increments by one the element at index {@code i}.
     *
     * @param i the index
     * @return the updated value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.390 -0400", hash_original_method = "F805E976C7AF95BCE080D78BADFEA76F", hash_generated_method = "EEFEBAA4EB13FA1D85671D9205E0EE14")
    
public final int incrementAndGet(int i) {
        return addAndGet(i, 1);
    }

    /**
     * Atomically decrements by one the element at index {@code i}.
     *
     * @param i the index
     * @return the updated value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.390 -0400", hash_original_method = "CC7001EBED3C0BBF66AEF807FAB57F14", hash_generated_method = "2286108298C2197D5C4D65937B7C9352")
    
public final int decrementAndGet(int i) {
        return addAndGet(i, -1);
    }

    /**
     * Atomically adds the given value to the element at index {@code i}.
     *
     * @param i the index
     * @param delta the value to add
     * @return the updated value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.391 -0400", hash_original_method = "3ADA77B2542D84476D61DC6509DE6714", hash_generated_method = "63706087488A980194F6E37A84217260")
    
public final int addAndGet(int i, int delta) {
        long offset = checkedByteOffset(i);
        while (true) {
            int current = getRaw(offset);
            int next = current + delta;
            if (compareAndSetRaw(offset, current, next))
                return next;
        }
    }

    /**
     * Returns the String representation of the current values of array.
     * @return the String representation of the current values of array
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:24.391 -0400", hash_original_method = "3492963B9799FA768D7650AC10A0F976", hash_generated_method = "05FA181A353EB1D2A8C6F63EB83AD424")
    
public String toString() {
        int iMax = array.length - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(getRaw(byteOffset(i)));
            if (i == iMax)
                return b.append(']').toString();
            b.append(',').append(' ');
        }
    }

}
