package java.nio;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public abstract class Buffer {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.624 -0500", hash_original_field = "EE1E1D1DCBD45F5386724204A7B9858F", hash_generated_field = "4FD98D60CF309FB8A0BDD7D63A79939A")

    static final int UNSET_MARK = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.627 -0500", hash_original_field = "0B1D26332B4020647655E70C20DE6D8D", hash_generated_field = "0B1D26332B4020647655E70C20DE6D8D")

     int capacity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.629 -0500", hash_original_field = "136FDC88CA742E83C109AD31983DA2BF", hash_generated_field = "136FDC88CA742E83C109AD31983DA2BF")

    int limit;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.632 -0500", hash_original_field = "F4125C160956CCDB3F5B836CF165E567", hash_generated_field = "F4125C160956CCDB3F5B836CF165E567")

    int mark = UNSET_MARK;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.634 -0500", hash_original_field = "B0CD1B3F8E4067A68C294939F6EB1E36", hash_generated_field = "B0CD1B3F8E4067A68C294939F6EB1E36")

    int position = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.637 -0500", hash_original_field = "AC48A19F4743BE2D100608593BADD722", hash_generated_field = "AC48A19F4743BE2D100608593BADD722")

     int _elementSizeShift;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.639 -0500", hash_original_field = "8BF4E4D6767B9222837C08D79533D1FA", hash_generated_field = "8BF4E4D6767B9222837C08D79533D1FA")

    int effectiveDirectAddress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.641 -0500", hash_original_field = "2536D72C0292B1D797C3E93689D5E5F8", hash_generated_field = "2536D72C0292B1D797C3E93689D5E5F8")

     MemoryBlock block;

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.644 -0500", hash_original_method = "2FDB6310072AD349AB73186351A07476", hash_generated_method = "2FDB6310072AD349AB73186351A07476")
    
Buffer(int elementSizeShift, int capacity, MemoryBlock block) {
        this._elementSizeShift = elementSizeShift;
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity < 0: " + capacity);
        }
        this.capacity = this.limit = capacity;
        this.block = block;
    }

    /**
     * Returns the array that backs this buffer (optional operation).
     * The returned value is the actual array, not a copy, so modifications
     * to the array write through to the buffer.
     *
     * <p>Subclasses should override this method with a covariant return type
     * to provide the exact type of the array.
     *
     * <p>Use {@code hasArray} to ensure this method won't throw.
     * (A separate call to {@code isReadOnly} is not necessary.)
     *
     * @return the array
     * @throws ReadOnlyBufferException if the buffer is read-only
     *         UnsupportedOperationException if the buffer does not expose an array
     * @since 1.6
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.646 -0500", hash_original_method = "09741C8E85E025E968AD6F26D3687DF1", hash_generated_method = "84B70AC4A107B559ECC2A7E3978C672F")
    
public abstract Object array();

    /**
     * Returns the offset into the array returned by {@code array} of the first
     * element of the buffer (optional operation). The backing array (if there is one)
     * is not necessarily the same size as the buffer, and position 0 in the buffer is
     * not necessarily the 0th element in the array. Use
     * {@code buffer.array()[offset + buffer.arrayOffset()} to access element {@code offset}
     * in {@code buffer}.
     *
     * <p>Use {@code hasArray} to ensure this method won't throw.
     * (A separate call to {@code isReadOnly} is not necessary.)
     *
     * @return the offset
     * @throws ReadOnlyBufferException if the buffer is read-only
     *         UnsupportedOperationException if the buffer does not expose an array
     * @since 1.6
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.649 -0500", hash_original_method = "6116DB2B49159CA0E0F5A4E8FDD85562", hash_generated_method = "E71FB9D0772673BC9C1AFEAE483451D3")
    
public abstract int arrayOffset();

    /**
     * Returns the capacity of this buffer.
     *
     * @return the number of elements that are contained in this buffer.
     */
    @DSComment("memory buffer only")
    @DSSafe(DSCat.MEM_BUFFER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.651 -0500", hash_original_method = "BDE11E8E3D76C140A59ECD57AE712B97", hash_generated_method = "EFD11F35F16F958D3B5DB156279B8E62")
    
public final int capacity() {
        return capacity;
    }

    /**
     * Used for the scalar get/put operations.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.653 -0500", hash_original_method = "3713E0ECC304C61FA995548AAE6F6858", hash_generated_method = "3713E0ECC304C61FA995548AAE6F6858")
    
void checkIndex(int index) {
        if (index < 0 || index >= limit) {
            throw new IndexOutOfBoundsException("index=" + index + ", limit=" + limit);
        }
    }

    /**
     * Used for the ByteBuffer operations that get types larger than a byte.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.656 -0500", hash_original_method = "E27C706F4FA27A5F90FA0BA455FA267B", hash_generated_method = "E27C706F4FA27A5F90FA0BA455FA267B")
    
void checkIndex(int index, int sizeOfType) {
        if (index < 0 || index > limit - sizeOfType) {
            throw new IndexOutOfBoundsException("index=" + index + ", limit=" + limit +
                    ", size of type=" + sizeOfType);
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.658 -0500", hash_original_method = "BA880ED8E3C58CA5885B3C340E7A6A66", hash_generated_method = "BA880ED8E3C58CA5885B3C340E7A6A66")
    
int checkGetBounds(int bytesPerElement, int length, int offset, int count) {
        int byteCount = bytesPerElement * count;
        if ((offset | count) < 0 || offset > length || length - offset < count) {
            throw new IndexOutOfBoundsException("offset=" + offset +
                    ", count=" + count + ", length=" + length);
        }
        if (byteCount > remaining()) {
            throw new BufferUnderflowException();
        }
        return byteCount;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.661 -0500", hash_original_method = "A9251187BC2FC71988179BCFBD0F334A", hash_generated_method = "A9251187BC2FC71988179BCFBD0F334A")
    
int checkPutBounds(int bytesPerElement, int length, int offset, int count) {
        int byteCount = bytesPerElement * count;
        if ((offset | count) < 0 || offset > length || length - offset < count) {
            throw new IndexOutOfBoundsException("offset=" + offset +
                    ", count=" + count + ", length=" + length);
        }
        if (byteCount > remaining()) {
            throw new BufferOverflowException();
        }
        if (isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        return byteCount;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.663 -0500", hash_original_method = "37F8609F5279E5BC0D8BC318C47B5ADC", hash_generated_method = "37F8609F5279E5BC0D8BC318C47B5ADC")
    
void checkStartEndRemaining(int start, int end) {
        if (end < start || start < 0 || end > remaining()) {
            throw new IndexOutOfBoundsException("start=" + start + ", end=" + end +
                    ", remaining()=" + remaining());
        }
    }

    /**
     * Clears this buffer.
     * <p>
     * While the content of this buffer is not changed, the following internal
     * changes take place: the current position is reset back to the start of
     * the buffer, the value of the buffer limit is made equal to the capacity
     * and mark is cleared.
     *
     * @return this buffer.
     */
    @DSComment("Activity on IO class")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.665 -0500", hash_original_method = "7210DA7B6C2A4BE4693F950CE68DF306", hash_generated_method = "B5A12F365A72B6206D219915F6919D8D")
    
public final Buffer clear() {
        position = 0;
        mark = UNSET_MARK;
        limit = capacity;
        return this;
    }

    /**
     * Flips this buffer.
     * <p>
     * The limit is set to the current position, then the position is set to
     * zero, and the mark is cleared.
     * <p>
     * The content of this buffer is not changed.
     *
     * @return this buffer.
     */
    @DSComment("memory buffer only")
    @DSSafe(DSCat.MEM_BUFFER)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.668 -0500", hash_original_method = "A8519E3C9C4A5F3DEEC9F7CACEDF020E", hash_generated_method = "3784C4CB883262D841A3EF3660F3F0E4")
    
public final Buffer flip() {
        limit = position;
        position = 0;
        mark = UNSET_MARK;
        return this;
    }

    /**
     * Returns true if {@code array} and {@code arrayOffset} won't throw. This method does not
     * return true for buffers not backed by arrays because the other methods would throw
     * {@code UnsupportedOperationException}, nor does it return true for buffers backed by
     * read-only arrays, because the other methods would throw {@code ReadOnlyBufferException}.
     * @since 1.6
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.670 -0500", hash_original_method = "5D0B8C70464A251811F6E29D47898FAC", hash_generated_method = "F51D3E74A2EA9BEA06AE46602087F65C")
    
public abstract boolean hasArray();

    /**
     * Indicates if there are elements remaining in this buffer, that is if
     * {@code position < limit}.
     *
     * @return {@code true} if there are elements remaining in this buffer,
     *         {@code false} otherwise.
     */
    @DSComment("memory buffer only")
    @DSSafe(DSCat.MEM_BUFFER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.673 -0500", hash_original_method = "13F7C083DDE22C46FB0AD1170426F423", hash_generated_method = "AE3E2F3587E0ADADFAEE7D4A57197881")
    
public final boolean hasRemaining() {
        return position < limit;
    }

    /**
     * Returns true if this is a direct buffer.
     * @since 1.6
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.676 -0500", hash_original_method = "2B5243B32EFBD4C87A9512D0DB4C2075", hash_generated_method = "FFC399E278E774AC5C957525392E5B9B")
    
public abstract boolean isDirect();

    /**
     * Indicates whether this buffer is read-only.
     *
     * @return {@code true} if this buffer is read-only, {@code false}
     *         otherwise.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.678 -0500", hash_original_method = "A8AEFD64A4190D55AF4312903F115146", hash_generated_method = "CD3E3A8E7CDFBBFF1BC7E86A37D41E49")
    
public abstract boolean isReadOnly();

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.681 -0500", hash_original_method = "08F9CA73B929B3F2D88417804C3457BC", hash_generated_method = "0D3DD797BA7A4055D03530371799E958")
    
final void checkWritable() {
        if (isReadOnly()) {
            throw new IllegalArgumentException("read-only buffer");
        }
    }

    /**
     * Returns the limit of this buffer.
     *
     * @return the limit of this buffer.
     */
    @DSComment("memory buffer only")
    @DSSafe(DSCat.MEM_BUFFER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.683 -0500", hash_original_method = "D5C1223BE3A23A4695C92DD81173DEDC", hash_generated_method = "471F805B434E1CB66DC1AE378132B944")
    
public final int limit() {
        return limit;
    }

    /**
     * Sets the limit of this buffer.
     * <p>
     * If the current position in the buffer is in excess of
     * <code>newLimit</code> then, on returning from this call, it will have
     * been adjusted to be equivalent to <code>newLimit</code>. If the mark
     * is set and is greater than the new limit, then it is cleared.
     *
     * @param newLimit
     *            the new limit, must not be negative and not greater than
     *            capacity.
     * @return this buffer.
     * @exception IllegalArgumentException
     *                if <code>newLimit</code> is invalid.
     */
    @DSComment("memory buffer only")
    @DSSafe(DSCat.MEM_BUFFER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.685 -0500", hash_original_method = "44A9FE5FA1BE9CFEEC46842C8860150F", hash_generated_method = "3750F30122B5D6DE9AF0EC1E1105CF58")
    
public final Buffer limit(int newLimit) {
        limitImpl(newLimit);
        return this;
    }

    /**
     * Subverts the fact that limit(int) is final, for the benefit of MappedByteBufferAdapter.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.688 -0500", hash_original_method = "513739890B0FB1849008B6B4DB830FEC", hash_generated_method = "513739890B0FB1849008B6B4DB830FEC")
    
void limitImpl(int newLimit) {
        if (newLimit < 0 || newLimit > capacity) {
            throw new IllegalArgumentException("Bad limit (capacity " + capacity + "): " + newLimit);
        }

        limit = newLimit;
        if (position > newLimit) {
            position = newLimit;
        }
        if ((mark != UNSET_MARK) && (mark > newLimit)) {
            mark = UNSET_MARK;
        }
    }

    /**
     * Marks the current position, so that the position may return to this point
     * later by calling <code>reset()</code>.
     *
     * @return this buffer.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.690 -0500", hash_original_method = "A81425374E4EA5264849380D40913956", hash_generated_method = "36C5BE3A97F8DB052DA4FDAF2129DECE")
    
public final Buffer mark() {
        mark = position;
        return this;
    }

    /**
     * Returns the position of this buffer.
     *
     * @return the value of this buffer's current position.
     */
    @DSComment("memory buffer only")
    @DSSafe(DSCat.MEM_BUFFER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.693 -0500", hash_original_method = "DAD201A4DC24D53E1106EBA819979825", hash_generated_method = "8846965B1CB9F84CDD93D980D81838A2")
    
public final int position() {
        return position;
    }

    /**
     * Sets the position of this buffer.
     * <p>
     * If the mark is set and it is greater than the new position, then it is
     * cleared.
     *
     * @param newPosition
     *            the new position, must be not negative and not greater than
     *            limit.
     * @return this buffer.
     * @exception IllegalArgumentException
     *                if <code>newPosition</code> is invalid.
     */
    @DSComment("memory buffer only")
    @DSSafe(DSCat.MEM_BUFFER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.695 -0500", hash_original_method = "E134461CBBE71A88508EDF7172D7480E", hash_generated_method = "9CCC860571F9BBE2407CB4C15E31AF20")
    
public final Buffer position(int newPosition) {
        positionImpl(newPosition);
        return this;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.698 -0500", hash_original_method = "291AA3CEE66D23BDF7C966DCE30CC485", hash_generated_method = "291AA3CEE66D23BDF7C966DCE30CC485")
    
void positionImpl(int newPosition) {
        if (newPosition < 0 || newPosition > limit) {
            throw new IllegalArgumentException("Bad position (limit " + limit + "): " + newPosition);
        }

        position = newPosition;
        if ((mark != UNSET_MARK) && (mark > position)) {
            mark = UNSET_MARK;
        }
    }

    /**
     * Returns the number of remaining elements in this buffer, that is
     * {@code limit - position}.
     *
     * @return the number of remaining elements in this buffer.
     */
    @DSComment("memory buffer only")
    @DSSafe(DSCat.MEM_BUFFER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.700 -0500", hash_original_method = "BFA4599854F3739E9A14ABA863ADA9FF", hash_generated_method = "E090FA6FA949940E777B4395FB88B092")
    
public final int remaining() {
        return limit - position;
    }

    /**
     * Resets the position of this buffer to the <code>mark</code>.
     *
     * @return this buffer.
     * @exception InvalidMarkException
     *                if the mark is not set.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.702 -0500", hash_original_method = "2BE1864DF6C90B2A62411C9F7C095DEC", hash_generated_method = "1D2AB15880A52D66321090C37B5864C5")
    
public final Buffer reset() {
        if (mark == UNSET_MARK) {
            throw new InvalidMarkException("Mark not set");
        }
        position = mark;
        return this;
    }

    /**
     * Rewinds this buffer.
     * <p>
     * The position is set to zero, and the mark is cleared. The content of this
     * buffer is not changed.
     *
     * @return this buffer.
     */
    @DSComment("memory buffer only")
    @DSSafe(DSCat.MEM_BUFFER)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.705 -0500", hash_original_method = "533909B48B402AC142AA1672CC89D5CC", hash_generated_method = "87393F25F4D0CCA65B5273B24AF8B1D0")
    
public final Buffer rewind() {
        position = 0;
        mark = UNSET_MARK;
        return this;
    }

    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.708 -0500", hash_original_method = "E469E128CB7197E7BD730454D1CDC172", hash_generated_method = "FEA4BAD8EA8B5C084A519DD34D080B25")
    
@Override public String toString() {
        StringBuilder buf = new StringBuilder();
        buf.append(getClass().getName());
        buf.append(", status: capacity=");
        buf.append(capacity);
        buf.append(" position=");
        buf.append(position);
        buf.append(" limit=");
        buf.append(limit);
        return buf.toString();
    }
    
    public static class DroidSafeNioBuffer extends Buffer {

        byte[] buffer;
        
        DroidSafeNioBuffer(int elementSizeShift, int capacity, MemoryBlock block) {
            super(elementSizeShift, capacity, block);
        }
        
        public DroidSafeNioBuffer(DSOnlyType dontcare) {
            this(0, 0, null);
        }

        @Override
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.646 -0500", hash_original_method = "09741C8E85E025E968AD6F26D3687DF1", hash_generated_method = "84B70AC4A107B559ECC2A7E3978C672F")
        public Object array() {
            // TODO Auto-generated method stub
            return buffer;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.649 -0500", hash_original_method = "6116DB2B49159CA0E0F5A4E8FDD85562", hash_generated_method = "E71FB9D0772673BC9C1AFEAE483451D3")
        public int arrayOffset() {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.670 -0500", hash_original_method = "5D0B8C70464A251811F6E29D47898FAC", hash_generated_method = "F51D3E74A2EA9BEA06AE46602087F65C")
        public boolean hasArray() {
            // TODO Auto-generated method stub
            return true;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.676 -0500", hash_original_method = "2B5243B32EFBD4C87A9512D0DB4C2075", hash_generated_method = "FFC399E278E774AC5C957525392E5B9B")
        public boolean isDirect() {
            // TODO Auto-generated method stub
            return true;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.678 -0500", hash_original_method = "A8AEFD64A4190D55AF4312903F115146", hash_generated_method = "CD3E3A8E7CDFBBFF1BC7E86A37D41E49")
        public boolean isReadOnly() {
            // TODO Auto-generated method stub
            return false;
        }

    }
}



