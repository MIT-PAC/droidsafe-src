package java.nio;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Arrays;

public abstract class ShortBuffer extends Buffer implements Comparable<ShortBuffer> {

    /**
     * Creates a short buffer based on a newly allocated short array.
     *
     * @param capacity
     *            the capacity of the new buffer.
     * @return the created short buffer.
     * @throws IllegalArgumentException
     *             if {@code capacity} is less than zero.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.365 -0500", hash_original_method = "EBFF8E9D938EEAC173B69FFFF0E788F4", hash_generated_method = "6F0E3EBA0D404FB0AFCEEAE1582B0585")
    
public static ShortBuffer allocate(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }
        return new ReadWriteShortArrayBuffer(capacity);
    }

    /**
     * Creates a new short buffer by wrapping the given short array.
     * <p>
     * Calling this method has the same effect as
     * {@code wrap(array, 0, array.length)}.
     *
     * @param array
     *            the short array which the new buffer will be based on.
     * @return the created short buffer.
     */
    @DSComment("no suspicious activity")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.368 -0500", hash_original_method = "8B4AACC8CC10C13D135A06929763BDF6", hash_generated_method = "509E98722C673CDBAA01B76811FD1BC5")
    
public static ShortBuffer wrap(short[] array) {
        return wrap(array, 0, array.length);
    }

    /**
     * Creates a new short buffer by wrapping the given short array.
     * <p>
     * The new buffer's position will be {@code start}, limit will be
     * {@code start + shortCount}, capacity will be the length of the array.
     *
     * @param array
     *            the short array which the new buffer will be based on.
     * @param start
     *            the start index, must not be negative and not greater than
     *            {@code array.length}.
     * @param shortCount
     *            the length, must not be negative and not greater than
     *            {@code array.length - start}.
     * @return the created short buffer.
     * @exception IndexOutOfBoundsException
     *                if either {@code start} or {@code shortCount} is invalid.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.370 -0500", hash_original_method = "72F1175C01A5143461DE3CE030C68996", hash_generated_method = "40F2E483DA1BD0B0688E5E89D7125496")
    
public static ShortBuffer wrap(short[] array, int start, int shortCount) {
        Arrays.checkOffsetAndCount(array.length, start, shortCount);
        ShortBuffer buf = new ReadWriteShortArrayBuffer(array);
        buf.position = start;
        buf.limit = start + shortCount;
        return buf;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.373 -0500", hash_original_method = "EAB92A092C9FEE1EEAB86C6A6FABA79C", hash_generated_method = "EAB92A092C9FEE1EEAB86C6A6FABA79C")
    
ShortBuffer(int capacity) {
        super(1, capacity, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.376 -0500", hash_original_method = "0A1B03C776C1004F61482923BC618EF6", hash_generated_method = "D88DAC21520F60D21DFDBF333F914C87")
    
public final short[] array() {
        return protectedArray();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.378 -0500", hash_original_method = "0D5EF56CBEA1DA16093A6276D10D9347", hash_generated_method = "28A2D71AE8939DE09018E333ADFF6CAE")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.381 -0500", hash_original_method = "91FD5D5EA70084AF642BD55F71B535D6", hash_generated_method = "250F8AE91CFC572D260501D822AA8C48")
    
public abstract ShortBuffer asReadOnlyBuffer();

    /**
     * Compacts this short buffer.
     * <p>
     * The remaining shorts will be moved to the head of the buffer, starting
     * from position zero. Then the position is set to {@code remaining()}; the
     * limit is set to capacity; the mark is cleared.
     *
     * @return this buffer.
     * @exception ReadOnlyBufferException
     *                if no changes may be made to the contents of this buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.383 -0500", hash_original_method = "32FE6B05956DB41925E4AA9608D70E12", hash_generated_method = "2450FBBD34D23EA3301EC8913E64A0F5")
    
public abstract ShortBuffer compact();

    /**
     * Compare the remaining shorts of this buffer to another short buffer's
     * remaining shorts.
     *
     * @param otherBuffer
     *            another short buffer.
     * @return a negative value if this is less than {@code otherBuffer}; 0 if
     *         this equals to {@code otherBuffer}; a positive value if this is
     *         greater than {@code otherBuffer}.
     * @exception ClassCastException
     *                if {@code otherBuffer} is not a short buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.386 -0500", hash_original_method = "F5228E310614FF7F70EC616A5A8F6CEB", hash_generated_method = "59642D28CC7C07C7C3A2E8DC8FB6BD15")
    
public int compareTo(ShortBuffer otherBuffer) {
        int compareRemaining = (remaining() < otherBuffer.remaining()) ? remaining()
                : otherBuffer.remaining();
        int thisPos = position;
        int otherPos = otherBuffer.position;
        short thisByte, otherByte;
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
     * The duplicated buffer's position, limit, capacity and mark are the same
     * as this buffer. The duplicated buffer's read-only property and byte order
     * are the same as this buffer's.
     * <p>
     * The new buffer shares its content with this buffer, which means either
     * buffer's change of content will be visible to the other. The two buffer's
     * position, limit and mark are independent.
     *
     * @return a duplicated buffer that shares its content with this buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.388 -0500", hash_original_method = "84196D0A2943D1A18DE7380AB4F2D8B1", hash_generated_method = "841D10B5C11B7A44164DB41BCDF09368")
    
public abstract ShortBuffer duplicate();

    /**
     * Checks whether this short buffer is equal to another object.
     * <p>
     * If {@code other} is not a short buffer then {@code false} is returned.
     * Two short buffers are equal if and only if their remaining shorts are
     * exactly the same. Position, limit, capacity and mark are not considered.
     *
     * @param other
     *            the object to compare with this short buffer.
     * @return {@code true} if this short buffer is equal to {@code other},
     *         {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.391 -0500", hash_original_method = "5B31F4285E964D7BDABED3BB847D41AA", hash_generated_method = "E6D080F92E3789439860734FC4273609")
    
@Override
    public boolean equals(Object other) {
        if (!(other instanceof ShortBuffer)) {
            return false;
        }
        ShortBuffer otherBuffer = (ShortBuffer) other;

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
     * Returns the short at the current position and increases the position by
     * 1.
     *
     * @return the short at the current position.
     * @exception BufferUnderflowException
     *                if the position is equal or greater than limit.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.393 -0500", hash_original_method = "3AAC84AA37FB75635F4DB8D7D6A7F6FB", hash_generated_method = "CA7D87777C6F14C126444A36141F350D")
    
public abstract short get();

    /**
     * Reads shorts from the current position into the specified short array and
     * increases the position by the number of shorts read.
     * <p>
     * Calling this method has the same effect as
     * {@code get(dst, 0, dst.length)}.
     *
     * @param dst
     *            the destination short array.
     * @return this buffer.
     * @exception BufferUnderflowException
     *                if {@code dst.length} is greater than {@code remaining()}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.396 -0500", hash_original_method = "68406DA953A1F3530F74FC6FE1C452A7", hash_generated_method = "2F943CD8BE97273C95D613084C8175C9")
    
public ShortBuffer get(short[] dst) {
        return get(dst, 0, dst.length);
    }

    /**
     * Reads shorts from the current position into the specified short array,
     * starting from the specified offset, and increases the position by the
     * number of shorts read.
     *
     * @param dst
     *            the target short array.
     * @param dstOffset
     *            the offset of the short array, must not be negative and not
     *            greater than {@code dst.length}.
     * @param shortCount
     *            the number of shorts to read, must be no less than zero and
     *            not greater than {@code dst.length - dstOffset}.
     * @return this buffer.
     * @exception IndexOutOfBoundsException
     *                if either {@code dstOffset} or {@code shortCount} is invalid.
     * @exception BufferUnderflowException
     *                if {@code shortCount} is greater than {@code remaining()}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.399 -0500", hash_original_method = "DE4C5284FF189AE8B07194EE8C193F03", hash_generated_method = "FE9700AF6413630B2C83C799F4D60421")
    
public ShortBuffer get(short[] dst, int dstOffset, int shortCount) {
        Arrays.checkOffsetAndCount(dst.length, dstOffset, shortCount);
        if (shortCount > remaining()) {
            throw new BufferUnderflowException();
        }
        for (int i = dstOffset; i < dstOffset + shortCount; ++i) {
            dst[i] = get();
        }
        return this;
    }

    /**
     * Returns the short at the specified index; the position is not changed.
     *
     * @param index
     *            the index, must not be negative and less than limit.
     * @return a short at the specified index.
     * @exception IndexOutOfBoundsException
     *                if index is invalid.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.401 -0500", hash_original_method = "05444F99607C6D96174593B423EC0AF5", hash_generated_method = "D73DECCF622EA13439CE33FADFFBBC9A")
    
public abstract short get(int index);

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.404 -0500", hash_original_method = "89C81F0EAF8FCCBFE368437CC8972DD7", hash_generated_method = "9ABCCA1D4392A43B7EAC3713FD39CEA8")
    
public final boolean hasArray() {
        return protectedHasArray();
    }

    /**
     * Calculates this buffer's hash code from the remaining chars. The
     * position, limit, capacity and mark don't affect the hash code.
     *
     * @return the hash code calculated from the remaining shorts.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.407 -0500", hash_original_method = "371FAD0CF0C9AC8E78075F4EA52336BD", hash_generated_method = "1E25806FB1ABDE5EAE09DE7EAB683BE8")
    
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
     * A short buffer is direct if it is based on a byte buffer and the byte
     * buffer is direct.
     *
     * @return {@code true} if this buffer is direct, {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.409 -0500", hash_original_method = "2B5243B32EFBD4C87A9512D0DB4C2075", hash_generated_method = "FFC399E278E774AC5C957525392E5B9B")
    
public abstract boolean isDirect();

    /**
     * Returns the byte order used by this buffer when converting shorts from/to
     * bytes.
     * <p>
     * If this buffer is not based on a byte buffer, then always return the
     * platform's native byte order.
     *
     * @return the byte order used by this buffer when converting shorts from/to
     *         bytes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.411 -0500", hash_original_method = "2DA427F16EF708C854E7D0C984AF174B", hash_generated_method = "2BEDE1A9F84B5799B19A96DDBD47ABB8")
    
public abstract ByteOrder order();

    /**
     * Child class implements this method to realize {@code array()}.
     *
     * @return see {@code array()}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.413 -0500", hash_original_method = "3F562962CA5DDB163573A642AC6C6B63", hash_generated_method = "BC17CA1F3E3A40289AD39B5388DC5B95")
    
abstract short[] protectedArray();

    /**
     * Child class implements this method to realize {@code arrayOffset()}.
     *
     * @return see {@code arrayOffset()}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.416 -0500", hash_original_method = "9E60C7ACB7338AE2B38C3B6B2C95F717", hash_generated_method = "CF9DD77B0F7512BEF2952176796D1F74")
    
abstract int protectedArrayOffset();

    /**
     * Child class implements this method to realize {@code hasArray()}.
     *
     * @return see {@code hasArray()}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.418 -0500", hash_original_method = "A4BB1744D6CB0B58561CD2147D66FE72", hash_generated_method = "6F3071F3A04983A3B50C9AF29E029577")
    
abstract boolean protectedHasArray();

    /**
     * Writes the given short to the current position and increases the position
     * by 1.
     *
     * @param s
     *            the short to write.
     * @return this buffer.
     * @exception BufferOverflowException
     *                if position is equal or greater than limit.
     * @exception ReadOnlyBufferException
     *                if no changes may be made to the contents of this buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.421 -0500", hash_original_method = "6570691A1175A820D63EC8E97F1555FC", hash_generated_method = "8E5DFF499737070AF5C1DC6B1E9F7C8A")
    
public abstract ShortBuffer put(short s);

    /**
     * Writes shorts from the given short array to the current position and
     * increases the position by the number of shorts written.
     * <p>
     * Calling this method has the same effect as
     * {@code put(src, 0, src.length)}.
     *
     * @param src
     *            the source short array.
     * @return this buffer.
     * @exception BufferOverflowException
     *                if {@code remaining()} is less than {@code src.length}.
     * @exception ReadOnlyBufferException
     *                if no changes may be made to the contents of this buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.423 -0500", hash_original_method = "47A309F7D8F6DC58E14B9D901E5CA4EB", hash_generated_method = "255F124D368E299A92A4C751EACEB9A6")
    
public final ShortBuffer put(short[] src) {
        return put(src, 0, src.length);
    }

    /**
     * Writes shorts from the given short array, starting from the specified
     * offset, to the current position and increases the position by the number
     * of shorts written.
     *
     * @param src
     *            the source short array.
     * @param srcOffset
     *            the offset of short array, must not be negative and not
     *            greater than {@code src.length}.
     * @param shortCount
     *            the number of shorts to write, must be no less than zero and
     *            not greater than {@code src.length - srcOffset}.
     * @return this buffer.
     * @exception BufferOverflowException
     *                if {@code remaining()} is less than {@code shortCount}.
     * @exception IndexOutOfBoundsException
     *                if either {@code srcOffset} or {@code shortCount} is invalid.
     * @exception ReadOnlyBufferException
     *                if no changes may be made to the contents of this buffer.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.425 -0500", hash_original_method = "F4EA1FDC39DA95E004DECB204CC15A47", hash_generated_method = "AF72556D5279A124D49614DCE6B0133C")
    
public ShortBuffer put(short[] src, int srcOffset, int shortCount) {
        Arrays.checkOffsetAndCount(src.length, srcOffset, shortCount);
        if (shortCount > remaining()) {
            throw new BufferOverflowException();
        }
        for (int i = srcOffset; i < srcOffset + shortCount; ++i) {
            put(src[i]);
        }
        return this;
    }

    /**
     * Writes all the remaining shorts of the {@code src} short buffer to this
     * buffer's current position, and increases both buffers' position by the
     * number of shorts copied.
     *
     * @param src
     *            the source short buffer.
     * @return this buffer.
     * @exception BufferOverflowException
     *                if {@code src.remaining()} is greater than this buffer's
     *                {@code remaining()}.
     * @exception IllegalArgumentException
     *                if {@code src} is this buffer.
     * @exception ReadOnlyBufferException
     *                if no changes may be made to the contents of this buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.428 -0500", hash_original_method = "1D8FC7647B57D46D94B3AA0BA31269DF", hash_generated_method = "35991EB3AB7828C2B83FF11FFF427C24")
    
public ShortBuffer put(ShortBuffer src) {
        if (src == this) {
            throw new IllegalArgumentException();
        }
        if (src.remaining() > remaining()) {
            throw new BufferOverflowException();
        }
        short[] contents = new short[src.remaining()];
        src.get(contents);
        put(contents);
        return this;
    }

    /**
     * Writes a short to the specified index of this buffer; the position is not
     * changed.
     *
     * @param index
     *            the index, must not be negative and less than the limit.
     * @param s
     *            the short to write.
     * @return this buffer.
     * @exception IndexOutOfBoundsException
     *                if index is invalid.
     * @exception ReadOnlyBufferException
     *                if no changes may be made to the contents of this buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.431 -0500", hash_original_method = "97F479E63BAAF12D41496325BCF680F5", hash_generated_method = "5A18E9665F277D2C4C54F5FC31387C82")
    
public abstract ShortBuffer put(int index, short s);

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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.433 -0500", hash_original_method = "5A4FD88E954DBDA74D41F1E3D86F73D1", hash_generated_method = "72EF6F8F265AB024F008383B6BE0397F")
    
public abstract ShortBuffer slice();
    
}

