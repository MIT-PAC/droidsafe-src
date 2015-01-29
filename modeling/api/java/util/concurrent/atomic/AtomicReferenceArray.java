/*
 * Written by Doug Lea with assistance from members of JCP JSR-166
 * Expert Group and released to the public domain, as explained at
 * http://creativecommons.org/publicdomain/zero/1.0/
 */

package java.util.concurrent.atomic;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.Arrays;
import java.lang.reflect.Array;
import sun.misc.Unsafe;

/**
 * An array of object references in which elements may be updated
 * atomically.  See the {@link java.util.concurrent.atomic} package
 * specification for description of the properties of atomic
 * variables.
 * @since 1.5
 * @author Doug Lea
 * @param <E> The base class of elements held in this array
 */
public class AtomicReferenceArray<E> implements java.io.Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.154 -0400", hash_original_field = "7BE25CE6AE6CA65DD45CAFBD91DC80AE", hash_generated_field = "2F36DD6945CCC2B6BE6348A40D0E3487")

    private static final long serialVersionUID = -6209656149925076980L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.154 -0400", hash_original_field = "91F4A6B1206F96A8BDFE7DC44D2205A8", hash_generated_field = "961DD659829096B383EAE5A26558643E")

    private static  Unsafe unsafe;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.155 -0400", hash_original_field = "E557BC1AC704FEEC83B0EF5D1FA054AB", hash_generated_field = "0477195552D30BC41410E5A72A139DE5")

    private static  int base;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.155 -0400", hash_original_field = "EFC9E38E68B764BB5996C858EA2A5584", hash_generated_field = "FF5851CA3D0F293AEAEEEA589F926E4D")

    private static  int shift;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.155 -0400", hash_original_field = "89639BF918D28D13FAD463DA6663DB22", hash_generated_field = "986BA88EDE02C11A41449FD4E1C14EBB")

    private static  long arrayFieldOffset;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.157 -0400", hash_original_method = "AC5839B0E4D62288830D21A694D63CDF", hash_generated_method = "2D3E4D341B1B4AD89EA5B6D21FA9D61C")
    
private static long byteOffset(int i) {
        return ((long) i << shift) + base;
    } // must have exact type Object[]

    static {
        try {
            unsafe = Unsafe.getUnsafe();
            arrayFieldOffset = unsafe.objectFieldOffset
                (AtomicReferenceArray.class.getDeclaredField("array"));
            base = unsafe.arrayBaseOffset(Object[].class);
            int scale = unsafe.arrayIndexScale(Object[].class);
            if ((scale & (scale - 1)) != 0)
                throw new Error("data type scale not a power of two");
            shift = 31 - Integer.numberOfLeadingZeros(scale);
        } catch (Exception e) {
            throw new Error(e);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.156 -0400", hash_original_field = "3E4C52F6F0428C39E4E692D20A9AA9AA", hash_generated_field = "1DD4CAAEAF702037B8556F46C93A922C")

    private  Object[] array;

    /**
     * Creates a new AtomicReferenceArray of the given length, with all
     * elements initially null.
     *
     * @param length the length of the array
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.157 -0400", hash_original_method = "3F3B508809AB9C6785D44F9F17208801", hash_generated_method = "D889519C1E920D91ADF12936DFDB860E")
    
public AtomicReferenceArray(int length) {
        array = new Object[length];
    }

    /**
     * Creates a new AtomicReferenceArray with the same length as, and
     * all elements copied from, the given array.
     *
     * @param array the array to copy elements from
     * @throws NullPointerException if array is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.158 -0400", hash_original_method = "C049CEFDA7A5BCB5BA0800C3390BB89B", hash_generated_method = "6F48A97CC72605DE2FEBC8CF1D078A6D")
    
public AtomicReferenceArray(E[] array) {
        // Visibility guaranteed by final field guarantees
        this.array = Arrays.copyOf(array, array.length, Object[].class);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.156 -0400", hash_original_method = "362098406DB6EC351C04D37BE5D9828B", hash_generated_method = "3DF43E0CE44DBFABB38293E3A8286B16")
    
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
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.158 -0400", hash_original_method = "27E0D57FF2AEBC70EE6BF760C51E525C", hash_generated_method = "70C186BF3C020F97975A93D7ABF97EE3")
    
public final int length() {
        return array.length;
    }

    /**
     * Gets the current value at position {@code i}.
     *
     * @param i the index
     * @return the current value
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.158 -0400", hash_original_method = "1A08AAB0F92ABC3159CC4A0EF89B33D7", hash_generated_method = "3CF90D7CCCF35B3D861F1A300401B7BC")
    
public final E get(int i) {
        return getRaw(checkedByteOffset(i));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.159 -0400", hash_original_method = "5C38AE7D133AF705563A03AB70E3DC4F", hash_generated_method = "466B40317750270CA3F170C9C1C10CF5")
    
@SuppressWarnings("unchecked")
    private E getRaw(long offset) {
        return (E) unsafe.getObjectVolatile(array, offset);
    }

    /**
     * Sets the element at position {@code i} to the given value.
     *
     * @param i the index
     * @param newValue the new value
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.160 -0400", hash_original_method = "2871A98FC9C1130D313120CFEF808AF1", hash_generated_method = "650E4B55613FDE6FC80BD4E02330E6D9")
    
public final void set(int i, E newValue) {
        unsafe.putObjectVolatile(array, checkedByteOffset(i), newValue);
    }

    /**
     * Eventually sets the element at position {@code i} to the given value.
     *
     * @param i the index
     * @param newValue the new value
     * @since 1.6
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.160 -0400", hash_original_method = "3F210D61D8876E2D9B64DE55A46FE422", hash_generated_method = "899E23CCD06A118A16D3BF8C00B737C4")
    
public final void lazySet(int i, E newValue) {
        unsafe.putOrderedObject(array, checkedByteOffset(i), newValue);
    }

    /**
     * Atomically sets the element at position {@code i} to the given
     * value and returns the old value.
     *
     * @param i the index
     * @param newValue the new value
     * @return the previous value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.161 -0400", hash_original_method = "B96F1A5C31486D778E2ABCF0728D2F2A", hash_generated_method = "33C921D7E1025890B742C9583FEBECD1")
    
public final E getAndSet(int i, E newValue) {
        long offset = checkedByteOffset(i);
        while (true) {
            E current = getRaw(offset);
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.161 -0400", hash_original_method = "B59DE16F8D16118A13A1CCE839A3A85D", hash_generated_method = "E4EA38F81971E2CDD0275A490A20E44A")
    
public final boolean compareAndSet(int i, E expect, E update) {
        return compareAndSetRaw(checkedByteOffset(i), expect, update);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.162 -0400", hash_original_method = "C142592EE20B948DF28BEA68CBD1D6F8", hash_generated_method = "3AFD1ECEB525116F1ACD854C3827A1EF")
    
private boolean compareAndSetRaw(long offset, E expect, E update) {
        return unsafe.compareAndSwapObject(array, offset, expect, update);
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.162 -0400", hash_original_method = "7FEFACA3B4A06CC6BC9F3075614DF7C8", hash_generated_method = "3C126AA6A3838687D5DAAD70B9B064C6")
    
public final boolean weakCompareAndSet(int i, E expect, E update) {
        return compareAndSet(i, expect, update);
    }

    /**
     * Returns the String representation of the current values of array.
     * @return the String representation of the current values of array
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.163 -0400", hash_original_method = "3492963B9799FA768D7650AC10A0F976", hash_generated_method = "05FA181A353EB1D2A8C6F63EB83AD424")
    
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

    /**
     * Reconstitutes the instance from a stream (that is, deserializes it).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.163 -0400", hash_original_method = "76D46AA991D5DE74C57933C3448350A5", hash_generated_method = "822296E06481C1F1E4D8C358D6B0FA76")
    
private void readObject(java.io.ObjectInputStream s)
        throws java.io.IOException, ClassNotFoundException,
        java.io.InvalidObjectException {
        // Note: This must be changed if any additional fields are defined
        Object a = s.readFields().get("array", null);
        if (a == null || !a.getClass().isArray())
            throw new java.io.InvalidObjectException("Not array type");
        if (a.getClass() != Object[].class)
            a = Arrays.copyOf((Object[])a, Array.getLength(a), Object[].class);
        unsafe.putObjectVolatile(this, arrayFieldOffset, a);
    }

}
