package java.nio;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Arrays;





public abstract class FloatBuffer extends Buffer implements Comparable<FloatBuffer> {

    /**
     * Creates a float buffer based on a newly allocated float array.
     *
     * @param capacity
     *            the capacity of the new buffer.
     * @return the created float buffer.
     * @throws IllegalArgumentException
     *             if {@code capacity} is less than zero.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.872 -0500", hash_original_method = "2FB775104C66661A886824538B4C7ED2", hash_generated_method = "950C460F63BEA3BB7574BF8AF1F6AE4B")
    public static FloatBuffer allocate(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }
        return new ReadWriteFloatArrayBuffer(capacity);
    }

    /**
     * Creates a new float buffer by wrapping the given float array.
     * <p>
     * Calling this method has the same effect as
     * {@code wrap(array, 0, array.length)}.
     *
     * @param array
     *            the float array which the new buffer will be based on.
     * @return the created float buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.874 -0500", hash_original_method = "F6DE4EB6E1FC74E6B009DCDAEF838F5B", hash_generated_method = "3C85BFB5E937DEBCF3D8C5D85A4ABFF3")
    public static FloatBuffer wrap(float[] array) {
        return wrap(array, 0, array.length);
    }

    /**
     * Creates a new float buffer by wrapping the given float array.
     * <p>
     * The new buffer's position will be {@code start}, limit will be
     * {@code start + floatCount}, capacity will be the length of the array.
     *
     * @param array
     *            the float array which the new buffer will be based on.
     * @param start
     *            the start index, must not be negative and not greater than
     *            {@code array.length}.
     * @param floatCount
     *            the length, must not be negative and not greater than
     *            {@code array.length - start}.
     * @return the created float buffer.
     * @exception IndexOutOfBoundsException
     *                if either {@code start} or {@code floatCount} is invalid.
     * @exception NullPointerException
     *                if {@code array} is null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.875 -0500", hash_original_method = "D1BAE48EAFBA264E33C378E4B66BB5B1", hash_generated_method = "3785786E289B11CEBD7181C5C685306A")
    public static FloatBuffer wrap(float[] array, int start, int floatCount) {
        Arrays.checkOffsetAndCount(array.length, start, floatCount);
        FloatBuffer buf = new ReadWriteFloatArrayBuffer(array);
        buf.position = start;
        buf.limit = start + floatCount;
        return buf;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.875 -0500", hash_original_method = "40CC822379F71BDE2069817768983643", hash_generated_method = "40CC822379F71BDE2069817768983643")
    FloatBuffer(int capacity) {
        super(2, capacity, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.876 -0500", hash_original_method = "3D88E12435E8ECFF27E8491C8CFB38C5", hash_generated_method = "8816DD4F29979B4BD6ABC553A2CDE741")
    public final float[] array() {
        return protectedArray();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.877 -0500", hash_original_method = "0D5EF56CBEA1DA16093A6276D10D9347", hash_generated_method = "28A2D71AE8939DE09018E333ADFF6CAE")
    public final int arrayOffset() {
        return protectedArrayOffset();
    }

    /**
     * Returns a read-only buffer that shares its content with this buffer.
     * <p>
     * The returned buffer is guaranteed to be a new instance, even if this
     * buffer is read-only itself. The new buffer's position, limit, capacity
     * and mark are the same as this buffer.
     * <p>
     * The new buffer shares its content with this buffer, which means this
     * buffer's change of content will be visible to the new buffer. The two
     * buffer's position, limit and mark are independent.
     *
     * @return a read-only version of this buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.878 -0500", hash_original_method = "7D04A9A0A6165ECC04702031574C9284", hash_generated_method = "CD1F845562D6F37D2A5B53D175237E61")
    public abstract FloatBuffer asReadOnlyBuffer();

    /**
     * Compacts this float buffer.
     * <p>
     * The remaining floats will be moved to the head of the buffer, starting
     * from position zero. Then the position is set to {@code remaining()}; the
     * limit is set to capacity; the mark is cleared.
     *
     * @return this buffer.
     * @exception ReadOnlyBufferException
     *                if no changes may be made to the contents of this buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.879 -0500", hash_original_method = "32451F91DF186B108F7203FB4BA804FE", hash_generated_method = "EF0844D0F5966A9C2725DA610CA19C52")
    public abstract FloatBuffer compact();

    /**
     * Compare the remaining floats of this buffer to another float buffer's
     * remaining floats.
     *
     * @param otherBuffer
     *            another float buffer.
     * @return a negative value if this is less than {@code otherBuffer}; 0 if
     *         this equals to {@code otherBuffer}; a positive value if this is
     *         greater than {@code otherBuffer}.
     * @exception ClassCastException
     *                if {@code otherBuffer} is not a float buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.881 -0500", hash_original_method = "255AC25FE0773812484072E75724705E", hash_generated_method = "C1CC1091457C3214DAF5CA5AF7A7D860")
    public int compareTo(FloatBuffer otherBuffer) {
        int compareRemaining = (remaining() < otherBuffer.remaining()) ? remaining()
                : otherBuffer.remaining();
        int thisPos = position;
        int otherPos = otherBuffer.position;
        float thisFloat, otherFloat;
        while (compareRemaining > 0) {
            thisFloat = get(thisPos);
            otherFloat = otherBuffer.get(otherPos);
            // checks for float and NaN inequality
            if ((thisFloat != otherFloat)
                    && ((thisFloat == thisFloat) || (otherFloat == otherFloat))) {
                return thisFloat < otherFloat ? -1 : 1;
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
     * as this buffer. The duplicated buffer's read-only property and byte order
     * are same as this buffer too.
     * <p>
     * The new buffer shares its content with this buffer, which means either
     * buffer's change of content will be visible to the other. The two buffer's
     * position, limit and mark are independent.
     *
     * @return a duplicated buffer that shares its content with this buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.882 -0500", hash_original_method = "1B86386F557AE66C36D17D9B1B10AA42", hash_generated_method = "50991417D689BE7BA7C34A224197ED5A")
    public abstract FloatBuffer duplicate();

    /**
     * Checks whether this float buffer is equal to another object. If {@code
     * other} is not a {@code FloatBuffer} then {@code false} is returned.
     *
     * <p>Two float buffers are equal if their remaining floats are equal.
     * Position, limit, capacity and mark are not considered.
     *
     * <p>This method considers two floats {@code a} and {@code b} to be equal
     * if {@code a == b} or if {@code a} and {@code b} are both {@code NaN}.
     * Unlike {@link Float#equals}, this method considers {@code -0.0} and
     * {@code +0.0} to be equal.
     *
     * @param other
     *            the object to compare with this float buffer.
     * @return {@code true} if this float buffer is equal to {@code other},
     *         {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.883 -0500", hash_original_method = "962C433BA6F78C4BE1DF9C98AF3A7A4D", hash_generated_method = "2980BDA4B6B7ADD49B9A6AF3F520F9BA")
    @Override
public boolean equals(Object other) {
        if (!(other instanceof FloatBuffer)) {
            return false;
        }
        FloatBuffer otherBuffer = (FloatBuffer) other;

        if (remaining() != otherBuffer.remaining()) {
            return false;
        }

        int myPosition = position;
        int otherPosition = otherBuffer.position;
        boolean equalSoFar = true;
        while (equalSoFar && (myPosition < limit)) {
            float a = get(myPosition++);
            float b = otherBuffer.get(otherPosition++);
            equalSoFar = a == b || (a != a && b != b);
        }

        return equalSoFar;
    }

    /**
     * Returns the float at the current position and increases the position by
     * 1.
     *
     * @return the float at the current position.
     * @exception BufferUnderflowException
     *                if the position is equal or greater than limit.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.884 -0500", hash_original_method = "DD95629D26D81841C1FF3883AEB98612", hash_generated_method = "E89A65E5800A885076A7605D12085972")
    public abstract float get();

    /**
     * Reads floats from the current position into the specified float array and
     * increases the position by the number of floats read.
     * <p>
     * Calling this method has the same effect as
     * {@code get(dst, 0, dst.length)}.
     *
     * @param dst
     *            the destination float array.
     * @return this buffer.
     * @exception BufferUnderflowException
     *                if {@code dst.length} is greater than {@code remaining()}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.884 -0500", hash_original_method = "5C1BC742B784E1F54201A6BFE04FB3C1", hash_generated_method = "A25DC9A0C575B997CCD28575DD9FA6AF")
    public FloatBuffer get(float[] dst) {
        return get(dst, 0, dst.length);
    }

    /**
     * Reads floats from the current position into the specified float array,
     * starting from the specified offset, and increases the position by the
     * number of floats read.
     *
     * @param dst
     *            the target float array.
     * @param dstOffset
     *            the offset of the float array, must not be negative and no
     *            greater than {@code dst.length}.
     * @param floatCount
     *            the number of floats to read, must be no less than zero and no
     *            greater than {@code dst.length - dstOffset}.
     * @return this buffer.
     * @exception IndexOutOfBoundsException
     *                if either {@code dstOffset} or {@code floatCount} is invalid.
     * @exception BufferUnderflowException
     *                if {@code floatCount} is greater than {@code remaining()}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.885 -0500", hash_original_method = "62E3FD5BE0E5A19BF5F39022D7154217", hash_generated_method = "CFEDBCC4F65A19B096EA2EB2DAE7FBC4")
    public FloatBuffer get(float[] dst, int dstOffset, int floatCount) {
        Arrays.checkOffsetAndCount(dst.length, dstOffset, floatCount);
        if (floatCount > remaining()) {
            throw new BufferUnderflowException();
        }
        for (int i = dstOffset; i < dstOffset + floatCount; ++i) {
            dst[i] = get();
        }
        return this;
    }

    /**
     * Returns a float at the specified index; the position is not changed.
     *
     * @param index
     *            the index, must not be negative and less than limit.
     * @return a float at the specified index.
     * @exception IndexOutOfBoundsException
     *                if index is invalid.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.886 -0500", hash_original_method = "F91C260BFD4314693FFE7C960F687058", hash_generated_method = "ED2514FFDD12B9EA8E991C2A15809E5B")
    public abstract float get(int index);

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.887 -0500", hash_original_method = "89C81F0EAF8FCCBFE368437CC8972DD7", hash_generated_method = "9ABCCA1D4392A43B7EAC3713FD39CEA8")
    public final boolean hasArray() {
        return protectedHasArray();
    }

    /**
     * Calculates this buffer's hash code from the remaining chars. The
     * position, limit, capacity and mark don't affect the hash code.
     *
     * @return the hash code calculated from the remaining floats.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.888 -0500", hash_original_method = "B144F8C59516E29D7B0EE6B79958F98A", hash_generated_method = "398E5B4217CC179808D12B8E7584D484")
    @Override
public int hashCode() {
        int myPosition = position;
        int hash = 0;
        while (myPosition < limit) {
            hash = hash + Float.floatToIntBits(get(myPosition++));
        }
        return hash;
    }

    /**
     * Indicates whether this buffer is direct. A direct buffer will try its
     * best to take advantage of native memory APIs and it may not stay in the
     * Java heap, so it is not affected by garbage collection.
     * <p>
     * A float buffer is direct if it is based on a byte buffer and the byte
     * buffer is direct.
     *
     * @return {@code true} if this buffer is direct, {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.888 -0500", hash_original_method = "2B5243B32EFBD4C87A9512D0DB4C2075", hash_generated_method = "FFC399E278E774AC5C957525392E5B9B")
    public abstract boolean isDirect();

    /**
     * Returns the byte order used by this buffer when converting floats from/to
     * bytes.
     * <p>
     * If this buffer is not based on a byte buffer, then always return the
     * platform's native byte order.
     *
     * @return the byte order used by this buffer when converting floats from/to
     *         bytes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.889 -0500", hash_original_method = "2DA427F16EF708C854E7D0C984AF174B", hash_generated_method = "2BEDE1A9F84B5799B19A96DDBD47ABB8")
    public abstract ByteOrder order();

    /**
     * Child class implements this method to realize {@code array()}.
     *
     * @return see {@code array()}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.890 -0500", hash_original_method = "49CD62ACC68CCE0E42D0E52B209B94A8", hash_generated_method = "A92F33D350E7D3E689CEAD5B921975B9")
    abstract float[] protectedArray();

    /**
     * Child class implements this method to realize {@code arrayOffset()}.
     *
     * @return see {@code arrayOffset()}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.891 -0500", hash_original_method = "9E60C7ACB7338AE2B38C3B6B2C95F717", hash_generated_method = "CF9DD77B0F7512BEF2952176796D1F74")
    abstract int protectedArrayOffset();

    /**
     * Child class implements this method to realize {@code hasArray()}.
     *
     * @return see {@code hasArray()}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.892 -0500", hash_original_method = "A4BB1744D6CB0B58561CD2147D66FE72", hash_generated_method = "6F3071F3A04983A3B50C9AF29E029577")
    abstract boolean protectedHasArray();

    /**
     * Writes the given float to the current position and increases the position
     * by 1.
     *
     * @param f
     *            the float to write.
     * @return this buffer.
     * @exception BufferOverflowException
     *                if position is equal or greater than limit.
     * @exception ReadOnlyBufferException
     *                if no changes may be made to the contents of this buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.892 -0500", hash_original_method = "41A5E27A4133F6F3A8C64820C2D21D90", hash_generated_method = "378AF54BC621B6DF660AC5E8B485929F")
    public abstract FloatBuffer put(float f);

    /**
     * Writes floats from the given float array to the current position and
     * increases the position by the number of floats written.
     * <p>
     * Calling this method has the same effect as
     * {@code put(src, 0, src.length)}.
     *
     * @param src
     *            the source float array.
     * @return this buffer.
     * @exception BufferOverflowException
     *                if {@code remaining()} is less than {@code src.length}.
     * @exception ReadOnlyBufferException
     *                if no changes may be made to the contents of this buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.893 -0500", hash_original_method = "5B7E9D4E0A0B3CF72C892C67E2CB78B1", hash_generated_method = "364B08C6990445194E4D43237CB05BC7")
    public final FloatBuffer put(float[] src) {
        return put(src, 0, src.length);
    }

    /**
     * Writes floats from the given float array, starting from the specified
     * offset, to the current position and increases the position by the number
     * of floats written.
     *
     * @param src
     *            the source float array.
     * @param srcOffset
     *            the offset of float array, must not be negative and not
     *            greater than {@code src.length}.
     * @param floatCount
     *            the number of floats to write, must be no less than zero and
     *            no greater than {@code src.length - srcOffset}.
     * @return this buffer.
     * @exception BufferOverflowException
     *                if {@code remaining()} is less than {@code floatCount}.
     * @exception IndexOutOfBoundsException
     *                if either {@code srcOffset} or {@code floatCount} is invalid.
     * @exception ReadOnlyBufferException
     *                if no changes may be made to the contents of this buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.894 -0500", hash_original_method = "DFC1F5A8B9B8E6C8478049F847BE00DC", hash_generated_method = "ADFFCE20F56DE416B180F9199E877E04")
    public FloatBuffer put(float[] src, int srcOffset, int floatCount) {
        Arrays.checkOffsetAndCount(src.length, srcOffset, floatCount);
        if (floatCount > remaining()) {
            throw new BufferOverflowException();
        }
        for (int i = srcOffset; i < srcOffset + floatCount; ++i) {
            put(src[i]);
        }
        return this;
    }

    /**
     * Writes all the remaining floats of the {@code src} float buffer to this
     * buffer's current position, and increases both buffers' position by the
     * number of floats copied.
     *
     * @param src
     *            the source float buffer.
     * @return this buffer.
     * @exception BufferOverflowException
     *                if {@code src.remaining()} is greater than this buffer's
     *                {@code remaining()}.
     * @exception IllegalArgumentException
     *                if {@code src} is this buffer.
     * @exception ReadOnlyBufferException
     *                if no changes may be made to the contents of this buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.896 -0500", hash_original_method = "338DD208CFE8C4AD7CB14619D9789866", hash_generated_method = "B4EEE4C4BA196D1B3218B7A8F1728EE4")
    public FloatBuffer put(FloatBuffer src) {
        if (src == this) {
            throw new IllegalArgumentException();
        }
        if (src.remaining() > remaining()) {
            throw new BufferOverflowException();
        }
        float[] contents = new float[src.remaining()];
        src.get(contents);
        put(contents);
        return this;
    }

    /**
     * Writes a float to the specified index of this buffer; the position is not
     * changed.
     *
     * @param index
     *            the index, must not be negative and less than the limit.
     * @param f
     *            the float to write.
     * @return this buffer.
     * @exception IndexOutOfBoundsException
     *                if index is invalid.
     * @exception ReadOnlyBufferException
     *                if no changes may be made to the contents of this buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.897 -0500", hash_original_method = "E055474EFA3FA7B3EA940C5865B7DADC", hash_generated_method = "FF72BFC456E313F487B3F4301D2E435E")
    public abstract FloatBuffer put(int index, float f);

    /**
     * Returns a sliced buffer that shares its content with this buffer.
     * <p>
     * The sliced buffer's capacity will be this buffer's {@code remaining()},
     * and its zero position will correspond to this buffer's current position.
     * The new buffer's position will be 0, limit will be its capacity, and its
     * mark is cleared. The new buffer's read-only property and byte order are
     * same as this buffer's.
     * <p>
     * The new buffer shares its content with this buffer, which means either
     * buffer's change of content will be visible to the other. The two buffer's
     * position, limit and mark are independent.
     *
     * @return a sliced buffer that shares its content with this buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.898 -0500", hash_original_method = "BDB0C51DF50027D80732B423FDACD53A", hash_generated_method = "AD1D105D90B144C73812BDD3ADD1779B")
    public abstract FloatBuffer slice();

    
}

