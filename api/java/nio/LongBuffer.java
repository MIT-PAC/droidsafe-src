package java.nio;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Arrays;





public abstract class LongBuffer extends Buffer implements Comparable<LongBuffer> {

    /**
     * Creates a long buffer based on a newly allocated long array.
     *
     * @param capacity
     *            the capacity of the new buffer.
     * @return the created long buffer.
     * @throws IllegalArgumentException
     *             if {@code capacity} is less than zero.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.383 -0500", hash_original_method = "0C0E2AE77B5CB5772EEF14C1E96752F1", hash_generated_method = "41B900FC32E92D7485603843911F59C9")
    
public static LongBuffer allocate(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }
        return new ReadWriteLongArrayBuffer(capacity);
    }

    /**
     * Creates a new long buffer by wrapping the given long array.
     * <p>
     * Calling this method has the same effect as
     * {@code wrap(array, 0, array.length)}.
     *
     * @param array
     *            the long array which the new buffer will be based on.
     * @return the created long buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.385 -0500", hash_original_method = "0F4E3A8DE685937C5DC7D885D0EC8B3B", hash_generated_method = "E806624605C75DA25A16D8F61B5E4565")
    
public static LongBuffer wrap(long[] array) {
        return wrap(array, 0, array.length);
    }

    /**
     * Creates a new long buffer by wrapping the given long array.
     * <p>
     * The new buffer's position will be {@code start}, limit will be
     * {@code start + longCount}, capacity will be the length of the array.
     *
     * @param array
     *            the long array which the new buffer will be based on.
     * @param start
     *            the start index, must not be negative and not greater than
     *            {@code array.length}.
     * @param longCount
     *            the length, must not be negative and not greater than
     *            {@code array.length - start}.
     * @return the created long buffer.
     * @exception IndexOutOfBoundsException
     *                if either {@code start} or {@code longCount} is invalid.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.388 -0500", hash_original_method = "2C18A8A89F26B75BE1B7CF107BBA9D37", hash_generated_method = "C31498A59734DB7B53C2A59176111A03")
    
public static LongBuffer wrap(long[] array, int start, int longCount) {
        Arrays.checkOffsetAndCount(array.length, start, longCount);
        LongBuffer buf = new ReadWriteLongArrayBuffer(array);
        buf.position = start;
        buf.limit = start + longCount;
        return buf;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.390 -0500", hash_original_method = "3A9B5F2A82543AF360E63C0F2EA35C03", hash_generated_method = "3A9B5F2A82543AF360E63C0F2EA35C03")
    
LongBuffer(int capacity) {
        super(3, capacity, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.393 -0500", hash_original_method = "4BA44AB0CDCB187F799C2188A053FC10", hash_generated_method = "61678AFA55A37005D6880AA1685C19D4")
    
public final long[] array() {
        return protectedArray();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.395 -0500", hash_original_method = "0D5EF56CBEA1DA16093A6276D10D9347", hash_generated_method = "28A2D71AE8939DE09018E333ADFF6CAE")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.398 -0500", hash_original_method = "EA84EE94947A1E6B3D4BCBC4BC97B98C", hash_generated_method = "BDC2F35BBF6E91E07D767F7EBB3D436C")
    
public abstract LongBuffer asReadOnlyBuffer();

    /**
     * Compacts this long buffer.
     * <p>
     * The remaining longs will be moved to the head of the buffer, staring from
     * position zero. Then the position is set to {@code remaining()}; the
     * limit is set to capacity; the mark is cleared.
     *
     * @return this buffer.
     * @exception ReadOnlyBufferException
     *                if no changes may be made to the contents of this buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.401 -0500", hash_original_method = "65B1173EDE8F0277AB549EB0B9AC970A", hash_generated_method = "B25497F8A60157F3846369E8D9A5E02E")
    
public abstract LongBuffer compact();

    /**
     * Compare the remaining longs of this buffer to another long buffer's
     * remaining longs.
     *
     * @param otherBuffer
     *            another long buffer.
     * @return a negative value if this is less than {@code otherBuffer}; 0 if
     *         this equals to {@code otherBuffer}; a positive value if this is
     *         greater than {@code otherBuffer}
     * @exception ClassCastException
     *                if {@code otherBuffer} is not a long buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.404 -0500", hash_original_method = "FEA629F677F50B81610B0F350A8DD419", hash_generated_method = "6362DD160C15E6F35EEC5A1808917F88")
    
public int compareTo(LongBuffer otherBuffer) {
        int compareRemaining = (remaining() < otherBuffer.remaining()) ? remaining()
                : otherBuffer.remaining();
        int thisPos = position;
        int otherPos = otherBuffer.position;
        long thisLong, otherLong;
        while (compareRemaining > 0) {
            thisLong = get(thisPos);
            otherLong = otherBuffer.get(otherPos);
            if (thisLong != otherLong) {
                return thisLong < otherLong ? -1 : 1;
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
     * are same as this buffer's, too.
     * <p>
     * The new buffer shares its content with this buffer, which means either
     * buffer's change of content will be visible to the other. The two buffer's
     * position, limit and mark are independent.
     *
     * @return a duplicated buffer that shares its content with this buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.406 -0500", hash_original_method = "5413D30CD3EBC90F68D9250237276737", hash_generated_method = "5420BC50C6D8AEF499023FF16803CE85")
    
public abstract LongBuffer duplicate();

    /**
     * Checks whether this long buffer is equal to another object.
     * <p>
     * If {@code other} is not a long buffer then {@code false} is returned. Two
     * long buffers are equal if and only if their remaining longs are exactly
     * the same. Position, limit, capacity and mark are not considered.
     *
     * @param other
     *            the object to compare with this long buffer.
     * @return {@code true} if this long buffer is equal to {@code other},
     *         {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.409 -0500", hash_original_method = "D82E6566C9B77850C7E0596D73483706", hash_generated_method = "5306D08342CFA40C8D6A07D919BFFB19")
    
@Override
    public boolean equals(Object other) {
        if (!(other instanceof LongBuffer)) {
            return false;
        }
        LongBuffer otherBuffer = (LongBuffer) other;

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
     * Returns the long at the current position and increase the position by 1.
     *
     * @return the long at the current position.
     * @exception BufferUnderflowException
     *                if the position is equal or greater than limit.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.411 -0500", hash_original_method = "DFBC8484A449FE298AE7B323A63CA550", hash_generated_method = "35C8D264EA201FE7C778D2FA1BB835F4")
    
public abstract long get();

    /**
     * Reads longs from the current position into the specified long array and
     * increases the position by the number of longs read.
     * <p>
     * Calling this method has the same effect as
     * {@code get(dst, 0, dst.length)}.
     *
     * @param dst
     *            the destination long array.
     * @return this buffer.
     * @exception BufferUnderflowException
     *                if {@code dst.length} is greater than {@code remaining()}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.413 -0500", hash_original_method = "D4B2A0425DC120EC01BAEA51D6880E08", hash_generated_method = "FB57FEAA659B88E7B68C17793F0541F1")
    
public LongBuffer get(long[] dst) {
        return get(dst, 0, dst.length);
    }

    /**
     * Reads longs from the current position into the specified long array,
     * starting from the specified offset, and increase the position by the
     * number of longs read.
     *
     * @param dst
     *            the target long array.
     * @param dstOffset
     *            the offset of the long array, must not be negative and not
     *            greater than {@code dst.length}.
     * @param longCount
     *            the number of longs to read, must be no less than zero and not
     *            greater than {@code dst.length - dstOffset}.
     * @return this buffer.
     * @exception IndexOutOfBoundsException
     *                if either {@code dstOffset} or {@code longCount} is invalid.
     * @exception BufferUnderflowException
     *                if {@code longCount} is greater than {@code remaining()}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.416 -0500", hash_original_method = "22F3DDD60BBBE627A1DDE8F148E9CD33", hash_generated_method = "E4E1AB0551FD8F7547378AA85A60AA0C")
    
public LongBuffer get(long[] dst, int dstOffset, int longCount) {
        Arrays.checkOffsetAndCount(dst.length, dstOffset, longCount);
        if (longCount > remaining()) {
            throw new BufferUnderflowException();
        }
        for (int i = dstOffset; i < dstOffset + longCount; ++i) {
            dst[i] = get();
        }
        return this;
    }

    /**
     * Returns the long at the specified index; the position is not changed.
     *
     * @param index
     *            the index, must not be negative and less than limit.
     * @return the long at the specified index.
     * @exception IndexOutOfBoundsException
     *                if index is invalid.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.419 -0500", hash_original_method = "39F5D2B49059340DBB0B6DEF4C7EEFE5", hash_generated_method = "07D3CC36CE8EAB5897CED617E22A3CAB")
    
public abstract long get(int index);

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.421 -0500", hash_original_method = "89C81F0EAF8FCCBFE368437CC8972DD7", hash_generated_method = "9ABCCA1D4392A43B7EAC3713FD39CEA8")
    
public final boolean hasArray() {
        return protectedHasArray();
    }

    /**
     * Calculates this buffer's hash code from the remaining chars. The
     * position, limit, capacity and mark don't affect the hash code.
     *
     * @return the hash code calculated from the remaining longs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.424 -0500", hash_original_method = "5C7ADDF6CA5903C3487F2A9B009FDDB4", hash_generated_method = "BCACA7378872C9AF8EB23DB3A327D381")
    
@Override
    public int hashCode() {
        int myPosition = position;
        int hash = 0;
        long l;
        while (myPosition < limit) {
            l = get(myPosition++);
            hash = hash + ((int) l) ^ ((int) (l >> 32));
        }
        return hash;
    }

    /**
     * Indicates whether this buffer is direct. A direct buffer will try its
     * best to take advantage of native memory APIs and it may not stay in the
     * Java heap, so it is not affected by garbage collection.
     * <p>
     * A long buffer is direct if it is based on a byte buffer and the byte
     * buffer is direct.
     *
     * @return {@code true} if this buffer is direct, {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.426 -0500", hash_original_method = "2B5243B32EFBD4C87A9512D0DB4C2075", hash_generated_method = "FFC399E278E774AC5C957525392E5B9B")
    
public abstract boolean isDirect();

    /**
     * Returns the byte order used by this buffer when converting longs from/to
     * bytes.
     * <p>
     * If this buffer is not based on a byte buffer, then always return the
     * platform's native byte order.
     *
     * @return the byte order used by this buffer when converting longs from/to
     *         bytes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.429 -0500", hash_original_method = "2DA427F16EF708C854E7D0C984AF174B", hash_generated_method = "2BEDE1A9F84B5799B19A96DDBD47ABB8")
    
public abstract ByteOrder order();

    /**
     * Child class implements this method to realize {@code array()}.
     *
     * @return see {@code array()}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.431 -0500", hash_original_method = "871DA11A9DF08881A9FCDFF81EB530B5", hash_generated_method = "9D9537D982E8FFAE67CB8A094717C2BF")
    
abstract long[] protectedArray();

    /**
     * Child class implements this method to realize {@code arrayOffset()}.
     *
     * @return see {@code arrayOffset()}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.433 -0500", hash_original_method = "9E60C7ACB7338AE2B38C3B6B2C95F717", hash_generated_method = "CF9DD77B0F7512BEF2952176796D1F74")
    
abstract int protectedArrayOffset();

    /**
     * Child class implements this method to realize {@code hasArray()}.
     *
     * @return see {@code hasArray()}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.435 -0500", hash_original_method = "A4BB1744D6CB0B58561CD2147D66FE72", hash_generated_method = "6F3071F3A04983A3B50C9AF29E029577")
    
abstract boolean protectedHasArray();

    /**
     * Writes the given long to the current position and increases the position
     * by 1.
     *
     * @param l
     *            the long to write.
     * @return this buffer.
     * @exception BufferOverflowException
     *                if position is equal or greater than limit.
     * @exception ReadOnlyBufferException
     *                if no changes may be made to the contents of this buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.438 -0500", hash_original_method = "7DF6B4F8DA8FBE6F4C17DBAB06D0ACEA", hash_generated_method = "616336DC89E45A8294CA98BF1EE3C04B")
    
public abstract LongBuffer put(long l);

    /**
     * Writes longs from the given long array to the current position and
     * increases the position by the number of longs written.
     * <p>
     * Calling this method has the same effect as
     * {@code put(src, 0, src.length)}.
     *
     * @param src
     *            the source long array.
     * @return this buffer.
     * @exception BufferOverflowException
     *                if {@code remaining()} is less than {@code src.length}.
     * @exception ReadOnlyBufferException
     *                if no changes may be made to the contents of this buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.440 -0500", hash_original_method = "5A5A365AB2651722CE67CD635F8A83E0", hash_generated_method = "C68A334C05EEA585255BFA8884131842")
    
public final LongBuffer put(long[] src) {
        return put(src, 0, src.length);
    }

    /**
     * Writes longs from the given long array, starting from the specified
     * offset, to the current position and increases the position by the number
     * of longs written.
     *
     * @param src
     *            the source long array.
     * @param srcOffset
     *            the offset of long array, must not be negative and not greater
     *            than {@code src.length}.
     * @param longCount
     *            the number of longs to write, must be no less than zero and
     *            not greater than {@code src.length - srcOffset}.
     * @return this buffer.
     * @exception BufferOverflowException
     *                if {@code remaining()} is less than {@code longCount}.
     * @exception IndexOutOfBoundsException
     *                if either {@code srcOffset} or {@code longCount} is invalid.
     * @exception ReadOnlyBufferException
     *                if no changes may be made to the contents of this buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.444 -0500", hash_original_method = "B57657AA1D79DC46C889A6E8179D7A18", hash_generated_method = "A42CE20F6CCDAFADB828534D5EAB68CB")
    
public LongBuffer put(long[] src, int srcOffset, int longCount) {
        Arrays.checkOffsetAndCount(src.length, srcOffset, longCount);
        if (longCount > remaining()) {
            throw new BufferOverflowException();
        }
        for (int i = srcOffset; i < srcOffset + longCount; ++i) {
            put(src[i]);
        }
        return this;
    }

    /**
     * Writes all the remaining longs of the {@code src} long buffer to this
     * buffer's current position, and increases both buffers' position by the
     * number of longs copied.
     *
     * @param src
     *            the source long buffer.
     * @return this buffer.
     * @exception BufferOverflowException
     *                if {@code src.remaining()} is greater than this buffer's
     *                {@code remaining()}.
     * @exception IllegalArgumentException
     *                if {@code src} is this buffer.
     * @exception ReadOnlyBufferException
     *                if no changes may be made to the contents of this buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.446 -0500", hash_original_method = "268B2EFE55B01F54F51A1709DBD7F8C3", hash_generated_method = "51BDBE1A008BC7D0C190929A809AF87A")
    
public LongBuffer put(LongBuffer src) {
        if (src == this) {
            throw new IllegalArgumentException();
        }
        if (src.remaining() > remaining()) {
            throw new BufferOverflowException();
        }
        long[] contents = new long[src.remaining()];
        src.get(contents);
        put(contents);
        return this;
    }

    /**
     * Writes a long to the specified index of this buffer; the position is not
     * changed.
     *
     * @param index
     *            the index, must not be negative and less than the limit.
     * @param l
     *            the long to write.
     * @return this buffer.
     * @exception IndexOutOfBoundsException
     *                if index is invalid.
     * @exception ReadOnlyBufferException
     *                if no changes may be made to the contents of this buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.449 -0500", hash_original_method = "4B297CAE32B3CDD427A17908B0003281", hash_generated_method = "FB0108677215A3CB2224A852D9C187E0")
    
public abstract LongBuffer put(int index, long l);

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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.451 -0500", hash_original_method = "9887614DC21CB1EE57B05B261C33E0E7", hash_generated_method = "133C5A8A8A658D91F61868C12755449D")
    
public abstract LongBuffer slice();

    
}

