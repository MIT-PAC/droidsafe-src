package java.nio;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Arrays;

public abstract class IntBuffer extends Buffer implements Comparable<IntBuffer> {

    /**
     * Creates an int buffer based on a newly allocated int array.
     *
     * @param capacity
     *            the capacity of the new buffer.
     * @return the created int buffer.
     * @throws IllegalArgumentException
     *             if {@code capacity} is less than zero.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.109 -0500", hash_original_method = "C3C2422C66654D6E12C59493728B39AD", hash_generated_method = "0D16E8947227D39761B191AF74C187E8")
    
public static IntBuffer allocate(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }
        return new ReadWriteIntArrayBuffer(capacity);
    }

    /**
     * Creates a new int buffer by wrapping the given int array.
     * <p>
     * Calling this method has the same effect as
     * {@code wrap(array, 0, array.length)}.
     *
     * @param array
     *            the int array which the new buffer will be based on.
     * @return the created int buffer.
     */
    @DSComment("no suspicious activity")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.111 -0500", hash_original_method = "69AB4E308DD923986E8AB96AF4F625AA", hash_generated_method = "6C1B3D0124340296BE544158357DB7B0")
    
public static IntBuffer wrap(int[] array) {
        return wrap(array, 0, array.length);
    }

    /**
     * Creates a new int buffer by wrapping the given int array.
     * <p>
     * The new buffer's position will be {@code start}, limit will be
     * {@code start + intCount}, capacity will be the length of the array.
     *
     * @param array
     *            the int array which the new buffer will be based on.
     * @param start
     *            the start index, must not be negative and not greater than
     *            {@code array.length}
     * @param intCount
     *            the length, must not be negative and not greater than
     *            {@code array.length - start}.
     * @return the created int buffer.
     * @exception IndexOutOfBoundsException
     *                if either {@code start} or {@code intCount} is invalid.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.114 -0500", hash_original_method = "47E92E6AEEAACC35C5502B8D98F03798", hash_generated_method = "4ECA240E787448B61CD60196456D2818")
    
public static IntBuffer wrap(int[] array, int start, int intCount) {
        Arrays.checkOffsetAndCount(array.length, start, intCount);
        IntBuffer buf = new ReadWriteIntArrayBuffer(array);
        buf.position = start;
        buf.limit = start + intCount;
        return buf;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.117 -0500", hash_original_method = "BC7C458D54C7EF00271779F9364447AB", hash_generated_method = "BC7C458D54C7EF00271779F9364447AB")
    
IntBuffer(int capacity) {
        super(2, capacity, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.119 -0500", hash_original_method = "D78164E532496862518F1BC4BDE62DEB", hash_generated_method = "CB5E64554344EFAB91A39013834819D7")
    
public final int[] array() {
        return protectedArray();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.122 -0500", hash_original_method = "0D5EF56CBEA1DA16093A6276D10D9347", hash_generated_method = "28A2D71AE8939DE09018E333ADFF6CAE")
    
public final int arrayOffset() {
        return protectedArrayOffset();
    }

    /**
     * Returns a read-only buffer that shares its content with this buffer.
     * <p>
     * The returned buffer is guaranteed to be a new instance, even this buffer
     * is read-only itself. The new buffer's position, limit, capacity and mark
     * are the same as this buffer's.
     * <p>
     * The new buffer shares its content with this buffer, which means this
     * buffer's change of content will be visible to the new buffer. The two
     * buffer's position, limit and mark are independent.
     *
     * @return a read-only version of this buffer.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.124 -0500", hash_original_method = "4E5C9DEC8494400600F057FE77AF41B7", hash_generated_method = "A87D6616A98CD0E633A87C121BC06FA8")
    
public abstract IntBuffer asReadOnlyBuffer();

    /**
     * Compacts this int buffer.
     * <p>
     * The remaining ints will be moved to the head of the buffer, starting from
     * position zero. Then the position is set to {@code remaining()}; the
     * limit is set to capacity; the mark is cleared.
     *
     * @return this buffer.
     * @exception ReadOnlyBufferException
     *                if no changes may be made to the contents of this buffer.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.127 -0500", hash_original_method = "ADBAAAA244C99486C1E2FADBAB49EEE2", hash_generated_method = "497335B55AC037794B7F61A23232A35C")
    
public abstract IntBuffer compact();

    /**
     * Compares the remaining ints of this buffer to another int buffer's
     * remaining ints.
     *
     * @param otherBuffer
     *            another int buffer.
     * @return a negative value if this is less than {@code other}; 0 if this
     *         equals to {@code other}; a positive value if this is greater
     *         than {@code other}.
     * @exception ClassCastException
     *                if {@code other} is not an int buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.130 -0500", hash_original_method = "E9F1AE5FDD3CB99604FBE90C4DDAAAAA", hash_generated_method = "FB7CC9CE9AA426F3D8AF8E054906B8DA")
    
public int compareTo(IntBuffer otherBuffer) {
        int compareRemaining = (remaining() < otherBuffer.remaining()) ? remaining()
                : otherBuffer.remaining();
        int thisPos = position;
        int otherPos = otherBuffer.position;
        int thisInt, otherInt;
        while (compareRemaining > 0) {
            thisInt = get(thisPos);
            otherInt = otherBuffer.get(otherPos);
            if (thisInt != otherInt) {
                return thisInt < otherInt ? -1 : 1;
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
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.133 -0500", hash_original_method = "0C804092755E4B9B6E5C0297DAA0E741", hash_generated_method = "5A5B68DA5A5D5C973D12C09D54E816A6")
    
public abstract IntBuffer duplicate();

    /**
     * Checks whether this int buffer is equal to another object.
     * <p>
     * If {@code other} is not a int buffer then {@code false} is returned. Two
     * int buffers are equal if and only if their remaining ints are exactly the
     * same. Position, limit, capacity and mark are not considered.
     *
     * @param other
     *            the object to compare with this int buffer.
     * @return {@code true} if this int buffer is equal to {@code other},
     *         {@code false} otherwise.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.136 -0500", hash_original_method = "43D7EA8D2B4C608B648102E9AA040456", hash_generated_method = "40D9F64D79A67D8167034E36F27AB9A8")
    
@Override
    public boolean equals(Object other) {
        if (!(other instanceof IntBuffer)) {
            return false;
        }
        IntBuffer otherBuffer = (IntBuffer) other;

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
     * Returns the int at the current position and increases the position by 1.
     *
     * @return the int at the current position.
     * @exception BufferUnderflowException
     *                if the position is equal or greater than limit.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.138 -0500", hash_original_method = "0A798F66266369F5E0B8382312B2A42C", hash_generated_method = "3728D34F4B8457DB5591DFE714380404")
    
public abstract int get();

    /**
     * Reads ints from the current position into the specified int array and
     * increases the position by the number of ints read.
     * <p>
     * Calling this method has the same effect as
     * {@code get(dst, 0, dst.length)}.
     *
     * @param dst
     *            the destination int array.
     * @return this buffer.
     * @exception BufferUnderflowException
     *                if {@code dst.length} is greater than {@code remaining()}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.140 -0500", hash_original_method = "257B404B7D2C714566C75E4EA0767CA2", hash_generated_method = "788107F6E76274CC5C6266D6CB7F4F9A")
    
public IntBuffer get(int[] dst) {
        return get(dst, 0, dst.length);
    }

    /**
     * Reads ints from the current position into the specified int array,
     * starting from the specified offset, and increases the position by the
     * number of ints read.
     *
     * @param dst
     *            the target int array.
     * @param dstOffset
     *            the offset of the int array, must not be negative and not
     *            greater than {@code dst.length}.
     * @param intCount
     *            the number of ints to read, must be no less than zero and not
     *            greater than {@code dst.length - dstOffset}.
     * @return this buffer.
     * @exception IndexOutOfBoundsException
     *                if either {@code dstOffset} or {@code intCount} is invalid.
     * @exception BufferUnderflowException
     *                if {@code intCount} is greater than {@code remaining()}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.143 -0500", hash_original_method = "72F522BE346D267FC1DB76B8F081AACA", hash_generated_method = "F757E7BF7AB4D20D9AF94C8418AF12DA")
    
public IntBuffer get(int[] dst, int dstOffset, int intCount) {
        Arrays.checkOffsetAndCount(dst.length, dstOffset, intCount);
        if (intCount > remaining()) {
            throw new BufferUnderflowException();
        }
        for (int i = dstOffset; i < dstOffset + intCount; ++i) {
            dst[i] = get();
        }
        return this;
    }

    /**
     * Returns an int at the specified index; the position is not changed.
     *
     * @param index
     *            the index, must not be negative and less than limit.
     * @return an int at the specified index.
     * @exception IndexOutOfBoundsException
     *                if index is invalid.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.146 -0500", hash_original_method = "C5D471E4849A6B00EECD9AFDBF0AFE23", hash_generated_method = "3A3B1B5CB5F362BC2AAE9BEF986FF130")
    
public abstract int get(int index);

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.148 -0500", hash_original_method = "89C81F0EAF8FCCBFE368437CC8972DD7", hash_generated_method = "9ABCCA1D4392A43B7EAC3713FD39CEA8")
    
public final boolean hasArray() {
        return protectedHasArray();
    }

    /**
     * Calculates this buffer's hash code from the remaining chars. The
     * position, limit, capacity and mark don't affect the hash code.
     *
     * @return the hash code calculated from the remaining ints.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.151 -0500", hash_original_method = "371FAD0CF0C9AC8E78075F4EA52336BD", hash_generated_method = "1E25806FB1ABDE5EAE09DE7EAB683BE8")
    
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
     * An int buffer is direct if it is based on a byte buffer and the byte
     * buffer is direct.
     *
     * @return {@code true} if this buffer is direct, {@code false} otherwise.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.153 -0500", hash_original_method = "2B5243B32EFBD4C87A9512D0DB4C2075", hash_generated_method = "FFC399E278E774AC5C957525392E5B9B")
    
public abstract boolean isDirect();

    /**
     * Returns the byte order used by this buffer when converting ints from/to
     * bytes.
     * <p>
     * If this buffer is not based on a byte buffer, then always return the
     * platform's native byte order.
     *
     * @return the byte order used by this buffer when converting ints from/to
     *         bytes.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.155 -0500", hash_original_method = "2DA427F16EF708C854E7D0C984AF174B", hash_generated_method = "2BEDE1A9F84B5799B19A96DDBD47ABB8")
    
public abstract ByteOrder order();

    /**
     * Child class implements this method to realize {@code array()}.
     *
     * @return see {@code array()}
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.157 -0500", hash_original_method = "0C22D1CF923E9DF3483B308CB9EA9081", hash_generated_method = "3141C402420A674783C4D953BBCA5765")
    
abstract int[] protectedArray();

    /**
     * Child class implements this method to realize {@code arrayOffset()}.
     *
     * @return see {@code arrayOffset()}
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.160 -0500", hash_original_method = "9E60C7ACB7338AE2B38C3B6B2C95F717", hash_generated_method = "CF9DD77B0F7512BEF2952176796D1F74")
    
abstract int protectedArrayOffset();

    /**
     * Child class implements this method to realize {@code hasArray()}.
     *
     * @return see {@code hasArray()}
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.163 -0500", hash_original_method = "A4BB1744D6CB0B58561CD2147D66FE72", hash_generated_method = "6F3071F3A04983A3B50C9AF29E029577")
    
abstract boolean protectedHasArray();

    /**
     * Writes the given int to the current position and increases the position
     * by 1.
     *
     * @param i
     *            the int to write.
     * @return this buffer.
     * @exception BufferOverflowException
     *                if position is equal or greater than limit.
     * @exception ReadOnlyBufferException
     *                if no changes may be made to the contents of this buffer.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.165 -0500", hash_original_method = "82862E853D49F26D6E084DD906147BE0", hash_generated_method = "6CC47AC36AEAFCB275507B3483ECA23A")
    
public abstract IntBuffer put(int i);

    /**
     * Writes ints from the given int array to the current position and
     * increases the position by the number of ints written.
     * <p>
     * Calling this method has the same effect as
     * {@code put(src, 0, src.length)}.
     *
     * @param src
     *            the source int array.
     * @return this buffer.
     * @exception BufferOverflowException
     *                if {@code remaining()} is less than {@code src.length}.
     * @exception ReadOnlyBufferException
     *                if no changes may be made to the contents of this buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.168 -0500", hash_original_method = "C57984865448BE8CC42F7EA5DB727833", hash_generated_method = "27343A32060FA378BCF5F2BB10CCC48A")
    
public final IntBuffer put(int[] src) {
        return put(src, 0, src.length);
    }

    /**
     * Writes ints from the given int array, starting from the specified offset,
     * to the current position and increases the position by the number of ints
     * written.
     *
     * @param src
     *            the source int array.
     * @param srcOffset
     *            the offset of int array, must not be negative and not greater
     *            than {@code src.length}.
     * @param intCount
     *            the number of ints to write, must be no less than zero and not
     *            greater than {@code src.length - srcOffset}.
     * @return this buffer.
     * @exception BufferOverflowException
     *                if {@code remaining()} is less than {@code intCount}.
     * @exception IndexOutOfBoundsException
     *                if either {@code srcOffset} or {@code intCount} is invalid.
     * @exception ReadOnlyBufferException
     *                if no changes may be made to the contents of this buffer.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.170 -0500", hash_original_method = "E12C5DD5606B4F94202BB1F980DCA32C", hash_generated_method = "D8E8482E479EA8A948E3AD114397F08C")
    
public IntBuffer put(int[] src, int srcOffset, int intCount) {
        Arrays.checkOffsetAndCount(src.length, srcOffset, intCount);
        if (intCount > remaining()) {
            throw new BufferOverflowException();
        }
        for (int i = srcOffset; i < srcOffset + intCount; ++i) {
            put(src[i]);
        }
        return this;
    }

    /**
     * Writes all the remaining ints of the {@code src} int buffer to this
     * buffer's current position, and increases both buffers' position by the
     * number of ints copied.
     *
     * @param src
     *            the source int buffer.
     * @return this buffer.
     * @exception BufferOverflowException
     *                if {@code src.remaining()} is greater than this buffer's
     *                {@code remaining()}.
     * @exception IllegalArgumentException
     *                if {@code src} is this buffer.
     * @exception ReadOnlyBufferException
     *                if no changes may be made to the contents of this buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.173 -0500", hash_original_method = "874C21D5B52E872502D97AA1BF44CEA1", hash_generated_method = "44208B665AD9607EFA385FF0564D336C")
    
public IntBuffer put(IntBuffer src) {
        if (src == this) {
            throw new IllegalArgumentException();
        }
        if (src.remaining() > remaining()) {
            throw new BufferOverflowException();
        }
        int[] contents = new int[src.remaining()];
        src.get(contents);
        put(contents);
        return this;
    }

    /**
     * Write a int to the specified index of this buffer; the position is not
     * changed.
     *
     * @param index
     *            the index, must not be negative and less than the limit.
     * @param i
     *            the int to write.
     * @return this buffer.
     * @exception IndexOutOfBoundsException
     *                if index is invalid.
     * @exception ReadOnlyBufferException
     *                if no changes may be made to the contents of this buffer.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.175 -0500", hash_original_method = "C04490F77D9F5C2317E167F33A34C0AF", hash_generated_method = "794E9CBD8FE98A8EBCFB2C6DAE020A9E")
    
public abstract IntBuffer put(int index, int i);

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
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:07.178 -0500", hash_original_method = "B9F3B2A9702898038CC25336B74676C0", hash_generated_method = "3B6DA994D8723384D96B2E09D6E6434C")
    
public abstract IntBuffer slice();
    
}

