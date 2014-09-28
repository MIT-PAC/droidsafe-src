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
 * A {@code long} array in which elements may be updated atomically.
 * See the {@link java.util.concurrent.atomic} package specification
 * for description of the properties of atomic variables.
 * @since 1.5
 * @author Doug Lea
 */
public class AtomicLongArray implements java.io.Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.264 -0400", hash_original_field = "CC39A1C52B9580282CD4DCBDB2CCE853", hash_generated_field = "353A0DB9401B29217EF8D77B58FE3997")

    private static final long serialVersionUID = -2308431214976778248L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.264 -0400", hash_original_field = "45AA3EADCAC9C9E31A558AD2E7D920BC", hash_generated_field = "225667B44D983DC733D3AAE856B0466F")

    private static final Unsafe unsafe = Unsafe.getUnsafe();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.265 -0400", hash_original_field = "9242FD11B547A088AA38E1D5D7710874", hash_generated_field = "E840612BC13BA3439D2963C9AE6D7EF3")

    private static final int base = unsafe.arrayBaseOffset(long[].class);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.265 -0400", hash_original_field = "EFC9E38E68B764BB5996C858EA2A5584", hash_generated_field = "FF5851CA3D0F293AEAEEEA589F926E4D")

    private static  int shift;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.266 -0400", hash_original_method = "AC5839B0E4D62288830D21A694D63CDF", hash_generated_method = "2D3E4D341B1B4AD89EA5B6D21FA9D61C")
    
private static long byteOffset(int i) {
        return ((long) i << shift) + base;
    }

    static {
        int scale = unsafe.arrayIndexScale(long[].class);
        if ((scale & (scale - 1)) != 0)
            throw new Error("data type scale not a power of two");
        shift = 31 - Integer.numberOfLeadingZeros(scale);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.265 -0400", hash_original_field = "6CBF535189A7848385491A4A460A449F", hash_generated_field = "F7C7881CDFB8EE39A77616767B7E28BC")

    private  long[] array;

    /**
     * Creates a new AtomicLongArray of the given length, with all
     * elements initially zero.
     *
     * @param length the length of the array
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.267 -0400", hash_original_method = "8B4DC9506BFF677670C5FDC2A32AE870", hash_generated_method = "2B9DCEAA015D0A93F4E173501EE4F614")
    
public AtomicLongArray(int length) {
        array = new long[length];
    }

    /**
     * Creates a new AtomicLongArray with the same length as, and
     * all elements copied from, the given array.
     *
     * @param array the array to copy elements from
     * @throws NullPointerException if array is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.267 -0400", hash_original_method = "3050E53F51A7E140FB04DB0A1747CE30", hash_generated_method = "002DA83A0C44A163C238DA830A947E25")
    
public AtomicLongArray(long[] array) {
        // Visibility guaranteed by final field guarantees
        this.array = array.clone();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.266 -0400", hash_original_method = "362098406DB6EC351C04D37BE5D9828B", hash_generated_method = "3DF43E0CE44DBFABB38293E3A8286B16")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.268 -0400", hash_original_method = "27E0D57FF2AEBC70EE6BF760C51E525C", hash_generated_method = "70C186BF3C020F97975A93D7ABF97EE3")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.268 -0400", hash_original_method = "8463D5A45B1A17BDF7D82E5555D69CD7", hash_generated_method = "DAF1ED99AF71309D57A2B8716F8D305C")
    
public final long get(int i) {
        return getRaw(checkedByteOffset(i));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.268 -0400", hash_original_method = "3BC3287D9A4267A89B05E2A24AB18A2F", hash_generated_method = "79704A4EDEA4D2779F05FA769BA8696B")
    
private long getRaw(long offset) {
        return unsafe.getLongVolatile(array, offset);
    }

    /**
     * Sets the element at position {@code i} to the given value.
     *
     * @param i the index
     * @param newValue the new value
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.269 -0400", hash_original_method = "4DA52F35ED4F588D120AC15F4A7F5E05", hash_generated_method = "84F1507F7B3A87BF1EC6806B18640218")
    
public final void set(int i, long newValue) {
        unsafe.putLongVolatile(array, checkedByteOffset(i), newValue);
    }

    /**
     * Eventually sets the element at position {@code i} to the given value.
     *
     * @param i the index
     * @param newValue the new value
     * @since 1.6
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.269 -0400", hash_original_method = "A9BE4DDEF95D04BC8772778BE2B9B289", hash_generated_method = "A8D0B115AA30F924F1CC4574C95EE797")
    
public final void lazySet(int i, long newValue) {
        unsafe.putOrderedLong(array, checkedByteOffset(i), newValue);
    }

    /**
     * Atomically sets the element at position {@code i} to the given value
     * and returns the old value.
     *
     * @param i the index
     * @param newValue the new value
     * @return the previous value
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.270 -0400", hash_original_method = "2B52BF2B27B28F94D4532D1FCB739678", hash_generated_method = "FF46EF5F001A50E6E8C593975E69B8C1")
    
public final long getAndSet(int i, long newValue) {
        long offset = checkedByteOffset(i);
        while (true) {
            long current = getRaw(offset);
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.270 -0400", hash_original_method = "068332A153A3867D545CC7FAFD9B0A09", hash_generated_method = "75A9587FBC0F89A275443115F1711438")
    
public final boolean compareAndSet(int i, long expect, long update) {
        return compareAndSetRaw(checkedByteOffset(i), expect, update);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.270 -0400", hash_original_method = "6CBE85C613A52AE19528F7E5DBB1A254", hash_generated_method = "24563503C106A8619ED6E2C8DF449AED")
    
private boolean compareAndSetRaw(long offset, long expect, long update) {
        return unsafe.compareAndSwapLong(array, offset, expect, update);
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.271 -0400", hash_original_method = "ED72E6FD3A21C5856EAC1B034EC6EA24", hash_generated_method = "CD90ADCC0ADA64DBC1436852E5F77B68")
    
public final boolean weakCompareAndSet(int i, long expect, long update) {
        return compareAndSet(i, expect, update);
    }

    /**
     * Atomically increments by one the element at index {@code i}.
     *
     * @param i the index
     * @return the previous value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.271 -0400", hash_original_method = "8FFC94593CC49EC6BAF09336827D1298", hash_generated_method = "49D61666AB6B351DC13C90C756C646F7")
    
public final long getAndIncrement(int i) {
        return getAndAdd(i, 1);
    }

    /**
     * Atomically decrements by one the element at index {@code i}.
     *
     * @param i the index
     * @return the previous value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.272 -0400", hash_original_method = "B27AC0A2F2D69309FD7FE34C486A6DFC", hash_generated_method = "E45FFB3B9AD880AECC73191D998C4BF7")
    
public final long getAndDecrement(int i) {
        return getAndAdd(i, -1);
    }

    /**
     * Atomically adds the given value to the element at index {@code i}.
     *
     * @param i the index
     * @param delta the value to add
     * @return the previous value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.272 -0400", hash_original_method = "65F34E97002151EAA8279BE0D0462B17", hash_generated_method = "AD9A8991DCBF5CE834A5D007C4F12C6D")
    
public final long getAndAdd(int i, long delta) {
        long offset = checkedByteOffset(i);
        while (true) {
            long current = getRaw(offset);
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.272 -0400", hash_original_method = "0952BD1EFAF2CADC0C104B904274AAA7", hash_generated_method = "74AF50E5F7788535078E7615D783E1F8")
    
public final long incrementAndGet(int i) {
        return addAndGet(i, 1);
    }

    /**
     * Atomically decrements by one the element at index {@code i}.
     *
     * @param i the index
     * @return the updated value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.273 -0400", hash_original_method = "1E049EFA1BA1304180B08336A5F8F226", hash_generated_method = "AAC306F5D8973C4ED9EFBBBC7265D8CF")
    
public final long decrementAndGet(int i) {
        return addAndGet(i, -1);
    }

    /**
     * Atomically adds the given value to the element at index {@code i}.
     *
     * @param i the index
     * @param delta the value to add
     * @return the updated value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.273 -0400", hash_original_method = "5A2B115B9C214021381979C4071AE18E", hash_generated_method = "B907E43C672C9650E6E251D11F43CBB9")
    
public long addAndGet(int i, long delta) {
        long offset = checkedByteOffset(i);
        while (true) {
            long current = getRaw(offset);
            long next = current + delta;
            if (compareAndSetRaw(offset, current, next))
                return next;
        }
    }

    /**
     * Returns the String representation of the current values of array.
     * @return the String representation of the current values of array
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:23.274 -0400", hash_original_method = "3492963B9799FA768D7650AC10A0F976", hash_generated_method = "05FA181A353EB1D2A8C6F63EB83AD424")
    
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
