package java.nio;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Arrays;

import libcore.io.Memory;

public abstract class ByteBuffer extends Buffer implements Comparable<ByteBuffer> {

    /**
     * Creates a byte buffer based on a newly allocated byte array.
     *
     * @param capacity
     *            the capacity of the new buffer
     * @return the created byte buffer.
     * @throws IllegalArgumentException
     *             if {@code capacity < 0}.
     */
    @DSComment("memory buffer only")
    @DSSafe(DSCat.MEM_BUFFER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.776 -0500", hash_original_method = "52AD6B6B7E23BF311D4F636879CBD6FE", hash_generated_method = "78087FDF303403A3D440EB1840BA83C4")
    
public static ByteBuffer allocate(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }
        return new ReadWriteHeapByteBuffer(capacity);
    }

    /**
     * Creates a direct byte buffer based on a newly allocated memory block.
     *
     * @param capacity
     *            the capacity of the new buffer
     * @return the created byte buffer.
     * @throws IllegalArgumentException
     *             if {@code capacity < 0}.
     */
    @DSComment("memory buffer only")
    @DSSafe(DSCat.MEM_BUFFER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.779 -0500", hash_original_method = "19A737D0A382F54D53A0D74CAB245982", hash_generated_method = "D8573714774DBCCDAD59691ED95DB73A")
    
public static ByteBuffer allocateDirect(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }
        return new ReadWriteDirectByteBuffer(capacity);
    }

    /**
     * Creates a new byte buffer by wrapping the given byte array.
     * <p>
     * Calling this method has the same effect as
     * {@code wrap(array, 0, array.length)}.
     *
     * @param array
     *            the byte array which the new buffer will be based on
     * @return the created byte buffer.
     */
    @DSComment("memory buffer only")
    @DSSafe(DSCat.MEM_BUFFER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.782 -0500", hash_original_method = "644E067849AFA471C056003EF7410F82", hash_generated_method = "935CA5F599322CC4A3A38C0932293EAC")
    
public static ByteBuffer wrap(byte[] array) {
        return new ReadWriteHeapByteBuffer(array);
    }

    /**
     * Creates a new byte buffer by wrapping the given byte array.
     * <p>
     * The new buffer's position will be {@code start}, limit will be
     * {@code start + byteCount}, capacity will be the length of the array.
     *
     * @param array
     *            the byte array which the new buffer will be based on.
     * @param start
     *            the start index, must not be negative and not greater than
     *            {@code array.length}.
     * @param byteCount
     *            the length, must not be negative and not greater than
     *            {@code array.length - start}.
     * @return the created byte buffer.
     * @exception IndexOutOfBoundsException
     *                if either {@code start} or {@code byteCount} is invalid.
     */
    @DSComment("memory buffer only")
    @DSSafe(DSCat.MEM_BUFFER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.784 -0500", hash_original_method = "5D8D0E67F592AD30EDF4A2251BAAF655", hash_generated_method = "6D1AB983F7D25AFAF7CDD62A51C18B49")
    
public static ByteBuffer wrap(byte[] array, int start, int byteCount) {
        Arrays.checkOffsetAndCount(array.length, start, byteCount);
        ByteBuffer buf = new ReadWriteHeapByteBuffer(array);
        buf.position = start;
        buf.limit = start + byteCount;
        return buf;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.787 -0500", hash_original_field = "E62C78D2A6D46FD1B0DD1DF9D3201034", hash_generated_field = "E62C78D2A6D46FD1B0DD1DF9D3201034")

    ByteOrder order = ByteOrder.BIG_ENDIAN;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.789 -0500", hash_original_method = "8BF63B2B8E79FA88256074D41FD2061C", hash_generated_method = "8BF63B2B8E79FA88256074D41FD2061C")
    
ByteBuffer(int capacity, MemoryBlock block) {
        super(0, capacity, block);
    }

    /**
     * Returns the byte array which this buffer is based on, if there is one.
     *
     * @return the byte array which this buffer is based on.
     * @exception ReadOnlyBufferException
     *                if this buffer is based on a read-only array.
     * @exception UnsupportedOperationException
     *                if this buffer is not based on an array.
     */
    @DSComment("memory buffer only")
    @DSSafe(DSCat.MEM_BUFFER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.792 -0500", hash_original_method = "7344C3769A78C71213763E627C382A16", hash_generated_method = "537451EEC285CE457427409DDF7B387C")
    
public final byte[] array() {
        return protectedArray();
    }

    /**
     * Returns the offset of the byte array which this buffer is based on, if
     * there is one.
     * <p>
     * The offset is the index of the array which corresponds to the zero
     * position of the buffer.
     *
     * @return the offset of the byte array which this buffer is based on.
     * @exception ReadOnlyBufferException
     *                if this buffer is based on a read-only array.
     * @exception UnsupportedOperationException
     *                if this buffer is not based on an array.
     */
    @DSComment("memory buffer only")
    @DSSafe(DSCat.MEM_BUFFER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.794 -0500", hash_original_method = "0D5EF56CBEA1DA16093A6276D10D9347", hash_generated_method = "28A2D71AE8939DE09018E333ADFF6CAE")
    
public final int arrayOffset() {
        return protectedArrayOffset();
    }

    /**
     * Returns a char buffer which is based on the remaining content of this
     * byte buffer.
     * <p>
     * The new buffer's position is zero, its limit and capacity is the number
     * of remaining bytes divided by two, and its mark is not set. The new
     * buffer's read-only property and byte order are the same as this buffer's.
     * The new buffer is direct if this byte buffer is direct.
     * <p>
     * The new buffer shares its content with this buffer, which means either
     * buffer's change of content will be visible to the other. The two buffer's
     * position, limit and mark are independent.
     *
     * @return a char buffer which is based on the content of this byte buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.796 -0500", hash_original_method = "EB1FF19683DE7E07713D53D8394BE1C2", hash_generated_method = "3FEA32B228E5C16CBBBF976D5F7AC6D0")
    
public abstract CharBuffer asCharBuffer();

    /**
     * Returns a double buffer which is based on the remaining content of this
     * byte buffer.
     * <p>
     * The new buffer's position is zero, its limit and capacity is the number
     * of remaining bytes divided by eight, and its mark is not set. The new
     * buffer's read-only property and byte order are the same as this buffer's.
     * The new buffer is direct if this byte buffer is direct.
     * <p>
     * The new buffer shares its content with this buffer, which means either
     * buffer's change of content will be visible to the other. The two buffer's
     * position, limit and mark are independent.
     *
     * @return a double buffer which is based on the content of this byte
     *         buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.800 -0500", hash_original_method = "834B79D80CC324C2F3867B315D95EB86", hash_generated_method = "AFA3444F7C93AF287F124ABBD0A7D84D")
    
public abstract DoubleBuffer asDoubleBuffer();

    /**
     * Returns a float buffer which is based on the remaining content of this
     * byte buffer.
     * <p>
     * The new buffer's position is zero, its limit and capacity is the number
     * of remaining bytes divided by four, and its mark is not set. The new
     * buffer's read-only property and byte order are the same as this buffer's.
     * The new buffer is direct if this byte buffer is direct.
     * <p>
     * The new buffer shares its content with this buffer, which means either
     * buffer's change of content will be visible to the other. The two buffer's
     * position, limit and mark are independent.
     *
     * @return a float buffer which is based on the content of this byte buffer.
     */
    @DSComment("memory buffer only")
    @DSSafe(DSCat.MEM_BUFFER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.803 -0500", hash_original_method = "82BC70631BC7EE783D874DCCAAC589A3", hash_generated_method = "C5891CD0BD489591A86B1C772B9ADFC8")
    
public abstract FloatBuffer asFloatBuffer();

    /**
     * Returns a int buffer which is based on the remaining content of this byte
     * buffer.
     * <p>
     * The new buffer's position is zero, its limit and capacity is the number
     * of remaining bytes divided by four, and its mark is not set. The new
     * buffer's read-only property and byte order are the same as this buffer's.
     * The new buffer is direct if this byte buffer is direct.
     * <p>
     * The new buffer shares its content with this buffer, which means either
     * buffer's change of content will be visible to the other. The two buffer's
     * position, limit and mark are independent.
     *
     * @return a int buffer which is based on the content of this byte buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.805 -0500", hash_original_method = "A1A1AB0CA4F00DBF83AA40317DF5CCEA", hash_generated_method = "478A60445EC8306AF6F3BD30AB28A1F7")
    
public abstract IntBuffer asIntBuffer();

    /**
     * Returns a long buffer which is based on the remaining content of this
     * byte buffer.
     * <p>
     * The new buffer's position is zero, its limit and capacity is the number
     * of remaining bytes divided by eight, and its mark is not set. The new
     * buffer's read-only property and byte order are the same as this buffer's.
     * The new buffer is direct if this byte buffer is direct.
     * <p>
     * The new buffer shares its content with this buffer, which means either
     * buffer's change of content will be visible to the other. The two buffer's
     * position, limit and mark are independent.
     *
     * @return a long buffer which is based on the content of this byte buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.808 -0500", hash_original_method = "E1B3AC349AAAFFADBF6C3577D1224DB0", hash_generated_method = "06DE89656ECA1535F30202F2E151D14C")
    
public abstract LongBuffer asLongBuffer();

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
    @DSComment("memory buffer only")
    @DSSafe(DSCat.MEM_BUFFER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.810 -0500", hash_original_method = "2C8C703CAF419C058EA637666AEED48B", hash_generated_method = "2947557BD5CB823DB1EF90134782546B")
    
public abstract ByteBuffer asReadOnlyBuffer();

    /**
     * Returns a short buffer which is based on the remaining content of this
     * byte buffer.
     * <p>
     * The new buffer's position is zero, its limit and capacity is the number
     * of remaining bytes divided by two, and its mark is not set. The new
     * buffer's read-only property and byte order are the same as this buffer's.
     * The new buffer is direct if this byte buffer is direct.
     * <p>
     * The new buffer shares its content with this buffer, which means either
     * buffer's change of content will be visible to the other. The two buffer's
     * position, limit and mark are independent.
     *
     * @return a short buffer which is based on the content of this byte buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.813 -0500", hash_original_method = "20615A09CFFA897A74EB5583EF0672DE", hash_generated_method = "E2552A5722BC69E290F0E150EF10DB71")
    
public abstract ShortBuffer asShortBuffer();

    /**
     * Compacts this byte buffer.
     * <p>
     * The remaining bytes will be moved to the head of the
     * buffer, starting from position zero. Then the position is set to
     * {@code remaining()}; the limit is set to capacity; the mark is
     * cleared.
     *
     * @return {@code this}
     * @exception ReadOnlyBufferException
     *                if no changes may be made to the contents of this buffer.
     */
    @DSComment("memory buffer only")
    @DSSafe(DSCat.MEM_BUFFER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.815 -0500", hash_original_method = "6034C0C2CF299086DEAB3934133CDE65", hash_generated_method = "0ED3116A7F719F0E8523D8C2365B0391")
    
public abstract ByteBuffer compact();

    /**
     * Compares the remaining bytes of this buffer to another byte buffer's
     * remaining bytes.
     *
     * @param otherBuffer
     *            another byte buffer.
     * @return a negative value if this is less than {@code other}; 0 if this
     *         equals to {@code other}; a positive value if this is greater
     *         than {@code other}.
     * @exception ClassCastException
     *                if {@code other} is not a byte buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.818 -0500", hash_original_method = "278C7A58B0643B88C9704D6A9846EFB3", hash_generated_method = "04A2DE4C768895E88EE700C8F703E7E5")
    
public int compareTo(ByteBuffer otherBuffer) {
        int compareRemaining = (remaining() < otherBuffer.remaining()) ? remaining()
                : otherBuffer.remaining();
        int thisPos = position;
        int otherPos = otherBuffer.position;
        byte thisByte, otherByte;
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
     * as this buffer's. The duplicated buffer's read-only property and byte
     * order are the same as this buffer's too.
     * <p>
     * The new buffer shares its content with this buffer, which means either
     * buffer's change of content will be visible to the other. The two buffer's
     * position, limit and mark are independent.
     *
     * @return a duplicated buffer that shares its content with this buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.821 -0500", hash_original_method = "24740CE519E5213E6361B9AB72589388", hash_generated_method = "9A8BF95AA9BD291F389A7B4EB7600CBF")
    
public abstract ByteBuffer duplicate();

    /**
     * Checks whether this byte buffer is equal to another object.
     * <p>
     * If {@code other} is not a byte buffer then {@code false} is returned. Two
     * byte buffers are equal if and only if their remaining bytes are exactly
     * the same. Position, limit, capacity and mark are not considered.
     *
     * @param other
     *            the object to compare with this byte buffer.
     * @return {@code true} if this byte buffer is equal to {@code other},
     *         {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.825 -0500", hash_original_method = "D3C1AD6F8182660C2A5A272A59569D9E", hash_generated_method = "F4CEF0482888DC1F94CAD32BB350C4A7")
    
@Override
    public boolean equals(Object other) {
        if (!(other instanceof ByteBuffer)) {
            return false;
        }
        ByteBuffer otherBuffer = (ByteBuffer) other;

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
     * Returns the byte at the current position and increases the position by 1.
     *
     * @return the byte at the current position.
     * @exception BufferUnderflowException
     *                if the position is equal or greater than limit.
     */
    @DSComment("memory buffer only")
    @DSSafe(DSCat.MEM_BUFFER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.827 -0500", hash_original_method = "8963DC023C1EE4FC88DF506D11BD6D89", hash_generated_method = "4826D1D4015CEF7EAC4BBB6F5E4D04A7")
    
public abstract byte get();

    /**
     * Reads bytes from the current position into the specified byte array and
     * increases the position by the number of bytes read.
     * <p>
     * Calling this method has the same effect as
     * {@code get(dst, 0, dst.length)}.
     *
     * @param dst
     *            the destination byte array.
     * @return {@code this}
     * @exception BufferUnderflowException
     *                if {@code dst.length} is greater than {@code remaining()}.
     */
    @DSComment("memory buffer only")
    @DSSafe(DSCat.MEM_BUFFER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.830 -0500", hash_original_method = "9A475FF9B92E938C1B69F2A1BC2AE724", hash_generated_method = "988551F2BBB206BBDE3A8BA08F16DFB3")
    
public ByteBuffer get(byte[] dst) {
        return get(dst, 0, dst.length);
    }

    /**
     * Reads bytes from the current position into the specified byte array,
     * starting at the specified offset, and increases the position by the
     * number of bytes read.
     *
     * @param dst
     *            the target byte array.
     * @param dstOffset
     *            the offset of the byte array, must not be negative and
     *            not greater than {@code dst.length}.
     * @param byteCount
     *            the number of bytes to read, must not be negative and not
     *            greater than {@code dst.length - dstOffset}
     * @return {@code this}
     * @exception IndexOutOfBoundsException if {@code dstOffset < 0 ||  byteCount < 0}
     * @exception BufferUnderflowException if {@code byteCount > remaining()}
     */
    @DSComment("memory buffer only")
    @DSSafe(DSCat.MEM_BUFFER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.833 -0500", hash_original_method = "1D8E1FFC265A4E71218B8D81ECBD99D1", hash_generated_method = "A112D08E1771E5017BE9406DD1561DC0")
    
public ByteBuffer get(byte[] dst, int dstOffset, int byteCount) {
        Arrays.checkOffsetAndCount(dst.length, dstOffset, byteCount);
        if (byteCount > remaining()) {
            throw new BufferUnderflowException();
        }
        for (int i = dstOffset; i < dstOffset + byteCount; ++i) {
            dst[i] = get();
        }
        return this;
    }

    /**
     * Returns the byte at the specified index and does not change the position.
     *
     * @param index
     *            the index, must not be negative and less than limit.
     * @return the byte at the specified index.
     * @exception IndexOutOfBoundsException
     *                if index is invalid.
     */
    @DSComment("memory buffer only")
    @DSSafe(DSCat.MEM_BUFFER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.836 -0500", hash_original_method = "2CD4CBAECCFACEACBCB0799ADF430E79", hash_generated_method = "04371A8BE0FD7B83C93A247F9BD768E0")
    
public abstract byte get(int index);

    /**
     * Returns the char at the current position and increases the position by 2.
     * <p>
     * The 2 bytes starting at the current position are composed into a char
     * according to the current byte order and returned.
     *
     * @return the char at the current position.
     * @exception BufferUnderflowException
     *                if the position is greater than {@code limit - 2}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.838 -0500", hash_original_method = "98B6CA7BAB902BD767B5ECCF233BA35A", hash_generated_method = "48BD64F6F4F8707B56CE4D1740CC87A7")
    
public abstract char getChar();

    /**
     * Returns the char at the specified index.
     * <p>
     * The 2 bytes starting from the specified index are composed into a char
     * according to the current byte order and returned. The position is not
     * changed.
     *
     * @param index
     *            the index, must not be negative and equal or less than
     *            {@code limit - 2}.
     * @return the char at the specified index.
     * @exception IndexOutOfBoundsException
     *                if {@code index} is invalid.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.840 -0500", hash_original_method = "8D1FAC530C5317B22381CDF207144FF3", hash_generated_method = "9CD13971D8574738EDF558E0EA30F0BE")
    
public abstract char getChar(int index);

    /**
     * Returns the double at the current position and increases the position by
     * 8.
     * <p>
     * The 8 bytes starting from the current position are composed into a double
     * according to the current byte order and returned.
     *
     * @return the double at the current position.
     * @exception BufferUnderflowException
     *                if the position is greater than {@code limit - 8}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.843 -0500", hash_original_method = "3C21225CB5A14BBA76C08E337861A597", hash_generated_method = "7CFD03C650BDE5FD1CDA5B92CA191BD1")
    
public abstract double getDouble();

    /**
     * Returns the double at the specified index.
     * <p>
     * The 8 bytes starting at the specified index are composed into a double
     * according to the current byte order and returned. The position is not
     * changed.
     *
     * @param index
     *            the index, must not be negative and equal or less than
     *            {@code limit - 8}.
     * @return the double at the specified index.
     * @exception IndexOutOfBoundsException
     *                if {@code index} is invalid.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.846 -0500", hash_original_method = "D016736880E0DE3B307395736952CC42", hash_generated_method = "E66A2D55395F15EA8DF9F515DF7AD0E2")
    
public abstract double getDouble(int index);

    /**
     * Returns the float at the current position and increases the position by
     * 4.
     * <p>
     * The 4 bytes starting at the current position are composed into a float
     * according to the current byte order and returned.
     *
     * @return the float at the current position.
     * @exception BufferUnderflowException
     *                if the position is greater than {@code limit - 4}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.848 -0500", hash_original_method = "0E0CE91FC681068A2048B34C16969734", hash_generated_method = "852F943CE5DB25471DC47532EF66A231")
    
public abstract float getFloat();

    /**
     * Returns the float at the specified index.
     * <p>
     * The 4 bytes starting at the specified index are composed into a float
     * according to the current byte order and returned. The position is not
     * changed.
     *
     * @param index
     *            the index, must not be negative and equal or less than
     *            {@code limit - 4}.
     * @return the float at the specified index.
     * @exception IndexOutOfBoundsException
     *                if {@code index} is invalid.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.851 -0500", hash_original_method = "3CC89B327C16506F6ED5E5C5CD9C5C13", hash_generated_method = "0EECD807016D04D3C9FB8E8892839540")
    
public abstract float getFloat(int index);

    /**
     * Returns the int at the current position and increases the position by 4.
     * <p>
     * The 4 bytes starting at the current position are composed into a int
     * according to the current byte order and returned.
     *
     * @return the int at the current position.
     * @exception BufferUnderflowException
     *                if the position is greater than {@code limit - 4}.
     */
    @DSComment("memory buffer only")
    @DSSafe(DSCat.MEM_BUFFER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.853 -0500", hash_original_method = "CA56528FA2D7DF3324FC3C7FC98167DB", hash_generated_method = "528E6A2DBEC13A16DD24EBF48B2F49F3")
    
public abstract int getInt();

    /**
     * Returns the int at the specified index.
     * <p>
     * The 4 bytes starting at the specified index are composed into a int
     * according to the current byte order and returned. The position is not
     * changed.
     *
     * @param index
     *            the index, must not be negative and equal or less than
     *            {@code limit - 4}.
     * @return the int at the specified index.
     * @exception IndexOutOfBoundsException
     *                if {@code index} is invalid.
     */
    @DSComment("memory buffer only")
    @DSSafe(DSCat.MEM_BUFFER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.856 -0500", hash_original_method = "38C74DC091B9771D568CFC46A07CD694", hash_generated_method = "9F01653E4B5791462ACF08B426146241")
    
public abstract int getInt(int index);

    /**
     * Returns the long at the current position and increases the position by 8.
     * <p>
     * The 8 bytes starting at the current position are composed into a long
     * according to the current byte order and returned.
     *
     * @return the long at the current position.
     * @exception BufferUnderflowException
     *                if the position is greater than {@code limit - 8}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.858 -0500", hash_original_method = "155CD3780672071A89F37893ECD385B6", hash_generated_method = "4E649AEF63AFFB884EED780D00AE51D9")
    
public abstract long getLong();

    /**
     * Returns the long at the specified index.
     * <p>
     * The 8 bytes starting at the specified index are composed into a long
     * according to the current byte order and returned. The position is not
     * changed.
     *
     * @param index
     *            the index, must not be negative and equal or less than
     *            {@code limit - 8}.
     * @return the long at the specified index.
     * @exception IndexOutOfBoundsException
     *                if {@code index} is invalid.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.861 -0500", hash_original_method = "5DE1667376B16E4FCF4E293F2B444300", hash_generated_method = "D3A52FC2D00AE65C9BDF44DCA666F90E")
    
public abstract long getLong(int index);

    /**
     * Returns the short at the current position and increases the position by 2.
     * <p>
     * The 2 bytes starting at the current position are composed into a short
     * according to the current byte order and returned.
     *
     * @return the short at the current position.
     * @exception BufferUnderflowException
     *                if the position is greater than {@code limit - 2}.
     */
    @DSComment("memory buffer only")
    @DSSafe(DSCat.MEM_BUFFER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.863 -0500", hash_original_method = "B04961994EADA034A3C810FFB4132367", hash_generated_method = "73784FCE5375F5D233BCBC5A4BF7CD8C")
    
public abstract short getShort();

    /**
     * Returns the short at the specified index.
     * <p>
     * The 2 bytes starting at the specified index are composed into a short
     * according to the current byte order and returned. The position is not
     * changed.
     *
     * @param index
     *            the index, must not be negative and equal or less than
     *            {@code limit - 2}.
     * @return the short at the specified index.
     * @exception IndexOutOfBoundsException
     *                if {@code index} is invalid.
     */
    @DSComment("memory buffer only")
    @DSSafe(DSCat.MEM_BUFFER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.866 -0500", hash_original_method = "94161056D9B25788FAC95FC2611DDB43", hash_generated_method = "E4046EA33BB11E2336E53290781CCFDE")
    
public abstract short getShort(int index);

    @DSComment("memory buffer only")
    @DSSafe(DSCat.MEM_BUFFER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.868 -0500", hash_original_method = "89C81F0EAF8FCCBFE368437CC8972DD7", hash_generated_method = "9ABCCA1D4392A43B7EAC3713FD39CEA8")
    
public final boolean hasArray() {
        return protectedHasArray();
    }

    /**
     * Calculates this buffer's hash code from the remaining chars. The
     * position, limit, capacity and mark don't affect the hash code.
     *
     * @return the hash code calculated from the remaining bytes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.871 -0500", hash_original_method = "371FAD0CF0C9AC8E78075F4EA52336BD", hash_generated_method = "1E25806FB1ABDE5EAE09DE7EAB683BE8")
    
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
     * Indicates whether this buffer is direct.
     *
     * @return {@code true} if this buffer is direct, {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.873 -0500", hash_original_method = "2B5243B32EFBD4C87A9512D0DB4C2075", hash_generated_method = "FFC399E278E774AC5C957525392E5B9B")
    
public abstract boolean isDirect();

    /**
     * Returns the byte order used by this buffer when converting bytes from/to
     * other primitive types.
     * <p>
     * The default byte order of byte buffer is always
     * {@link ByteOrder#BIG_ENDIAN BIG_ENDIAN}
     *
     * @return the byte order used by this buffer when converting bytes from/to
     *         other primitive types.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.876 -0500", hash_original_method = "65B1A3EBEA253AF86057FAE15F6D4DB5", hash_generated_method = "EE2ABE1DAA1B6458AFBD3971ED955F67")
    
public final ByteOrder order() {
        return order;
    }

    /**
     * Sets the byte order of this buffer.
     *
     * @param byteOrder
     *            the byte order to set. If {@code null} then the order
     *            will be {@link ByteOrder#LITTLE_ENDIAN LITTLE_ENDIAN}.
     * @return {@code this}
     * @see ByteOrder
     */
    @DSComment("memory buffer only")
    @DSSafe(DSCat.MEM_BUFFER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.879 -0500", hash_original_method = "56B1D3E8961AB315D57FF8A49B63D4AB", hash_generated_method = "BBA106CE496C53C9D30C7C6FE08A840A")
    
public final ByteBuffer order(ByteOrder byteOrder) {
        orderImpl(byteOrder);
        return this;
    }

    /**
     * Subverts the fact that order(ByteOrder) is final, for the benefit of MappedByteBufferAdapter.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.881 -0500", hash_original_method = "00AA16AC102512E5E69E8EC846E58DBE", hash_generated_method = "00AA16AC102512E5E69E8EC846E58DBE")
    
void orderImpl(ByteOrder byteOrder) {
        if (byteOrder == null) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        order = byteOrder;
    }

    /**
     * Child class implements this method to realize {@code array()}.
     *
     * @see #array()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.884 -0500", hash_original_method = "50DD750BC6C5D1101E206C0AF2C2D66E", hash_generated_method = "6FE475DB8D9DC734484B25A187FACBBE")
    
abstract byte[] protectedArray();

    /**
     * Child class implements this method to realize {@code arrayOffset()}.
     *
     * @see #arrayOffset()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.886 -0500", hash_original_method = "9E60C7ACB7338AE2B38C3B6B2C95F717", hash_generated_method = "CF9DD77B0F7512BEF2952176796D1F74")
    
abstract int protectedArrayOffset();

    /**
     * Child class implements this method to realize {@code hasArray()}.
     *
     * @see #hasArray()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.888 -0500", hash_original_method = "A4BB1744D6CB0B58561CD2147D66FE72", hash_generated_method = "6F3071F3A04983A3B50C9AF29E029577")
    
abstract boolean protectedHasArray();

    /**
     * Writes the given byte to the current position and increases the position
     * by 1.
     *
     * @param b
     *            the byte to write.
     * @return {@code this}
     * @exception BufferOverflowException
     *                if position is equal or greater than limit.
     * @exception ReadOnlyBufferException
     *                if no changes may be made to the contents of this buffer.
     */
    @DSComment("memory buffer only")
    @DSSafe(DSCat.MEM_BUFFER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.891 -0500", hash_original_method = "983CB5E1253F102F78ED5C2EA2A5C64E", hash_generated_method = "F8C5B1E091128CE11734F291E1363FC9")
    
public abstract ByteBuffer put(byte b);

    /**
     * Writes bytes in the given byte array to the current position and
     * increases the position by the number of bytes written.
     * <p>
     * Calling this method has the same effect as
     * {@code put(src, 0, src.length)}.
     *
     * @param src
     *            the source byte array.
     * @return {@code this}
     * @exception BufferOverflowException
     *                if {@code remaining()} is less than {@code src.length}.
     * @exception ReadOnlyBufferException
     *                if no changes may be made to the contents of this buffer.
     */
    @DSComment("memory buffer only")
    @DSSafe(DSCat.MEM_BUFFER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.893 -0500", hash_original_method = "D20A20C1C5EFB26E81C8757F39019CA4", hash_generated_method = "5C7A4A6063FCAC7DD6D046C669E7256D")
    
public final ByteBuffer put(byte[] src) {
        return put(src, 0, src.length);
    }

    /**
     * Writes bytes in the given byte array, starting from the specified offset,
     * to the current position and increases the position by the number of bytes
     * written.
     *
     * @param src
     *            the source byte array.
     * @param srcOffset
     *            the offset of byte array, must not be negative and not greater
     *            than {@code src.length}.
     * @param byteCount
     *            the number of bytes to write, must not be negative and not
     *            greater than {@code src.length - srcOffset}.
     * @return {@code this}
     * @exception BufferOverflowException
     *                if {@code remaining()} is less than {@code byteCount}.
     * @exception IndexOutOfBoundsException
     *                if either {@code srcOffset} or {@code byteCount} is invalid.
     * @exception ReadOnlyBufferException
     *                if no changes may be made to the contents of this buffer.
     */
    @DSComment("memory buffer only")
    @DSSafe(DSCat.MEM_BUFFER)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.896 -0500", hash_original_method = "D0316A3A41AD4E9576A2DF2983507374", hash_generated_method = "242B2D84BCF2BAED8FD10923575F609F")
    
public ByteBuffer put(byte[] src, int srcOffset, int byteCount) {
        Arrays.checkOffsetAndCount(src.length, srcOffset, byteCount);
        if (byteCount > remaining()) {
            throw new BufferOverflowException();
        }
        for (int i = srcOffset; i < srcOffset + byteCount; ++i) {
            put(src[i]);
        }
        return this;
    }

    /**
     * Writes all the remaining bytes of the {@code src} byte buffer to this
     * buffer's current position, and increases both buffers' position by the
     * number of bytes copied.
     *
     * @param src
     *            the source byte buffer.
     * @return {@code this}
     * @exception BufferOverflowException
     *                if {@code src.remaining()} is greater than this buffer's
     *                {@code remaining()}.
     * @exception IllegalArgumentException
     *                if {@code src} is this buffer.
     * @exception ReadOnlyBufferException
     *                if no changes may be made to the contents of this buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.900 -0500", hash_original_method = "9C697C4B592697CC08FD298666C0BB54", hash_generated_method = "E8E099DCDF065A984638E8D712836242")
    
public ByteBuffer put(ByteBuffer src) {
        if (src == this) {
            throw new IllegalArgumentException("src == this");
        }
        int srcByteCount = src.remaining();
        if (srcByteCount > remaining()) {
            throw new BufferOverflowException();
        }

        Object srcObject = src.isDirect() ? src : NioUtils.unsafeArray(src);
        int srcOffset = src.position();
        if (!src.isDirect()) {
            srcOffset += NioUtils.unsafeArrayOffset(src);
        }

        ByteBuffer dst = this;
        Object dstObject = dst.isDirect() ? dst : NioUtils.unsafeArray(dst);
        int dstOffset = dst.position();
        if (!dst.isDirect()) {
            dstOffset += NioUtils.unsafeArrayOffset(dst);
        }

        Memory.memmove(dstObject, dstOffset, srcObject, srcOffset, srcByteCount);
        src.position(src.limit());
        dst.position(dst.position() + srcByteCount);

        return this;
    }

    /**
     * Write a byte to the specified index of this buffer without changing the
     * position.
     *
     * @param index
     *            the index, must not be negative and less than the limit.
     * @param b
     *            the byte to write.
     * @return {@code this}
     * @exception IndexOutOfBoundsException
     *                if {@code index} is invalid.
     * @exception ReadOnlyBufferException
     *                if no changes may be made to the contents of this buffer.
     */
    @DSComment("memory buffer only")
    @DSSafe(DSCat.MEM_BUFFER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.902 -0500", hash_original_method = "2EBD837469F8F98183BF1C66B6EF96DD", hash_generated_method = "7FC9FF03AFC347A0BA849BA2BC07C996")
    
public abstract ByteBuffer put(int index, byte b);

    /**
     * Writes the given char to the current position and increases the position
     * by 2.
     * <p>
     * The char is converted to bytes using the current byte order.
     *
     * @param value
     *            the char to write.
     * @return {@code this}
     * @exception BufferOverflowException
     *                if position is greater than {@code limit - 2}.
     * @exception ReadOnlyBufferException
     *                if no changes may be made to the contents of this buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.905 -0500", hash_original_method = "7014ECB331FFA1BE919279AD15B4B026", hash_generated_method = "901DE9758CD0A4FDF0CF53C9575F89AF")
    
public abstract ByteBuffer putChar(char value);

    /**
     * Writes the given char to the specified index of this buffer.
     * <p>
     * The char is converted to bytes using the current byte order. The position
     * is not changed.
     *
     * @param index
     *            the index, must not be negative and equal or less than
     *            {@code limit - 2}.
     * @param value
     *            the char to write.
     * @return {@code this}
     * @exception IndexOutOfBoundsException
     *                if {@code index} is invalid.
     * @exception ReadOnlyBufferException
     *                if no changes may be made to the contents of this buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.907 -0500", hash_original_method = "506E8BCF465B00C6E4E1C4D0644B0486", hash_generated_method = "7D46C3052F16633374110792928ADA3A")
    
public abstract ByteBuffer putChar(int index, char value);

    /**
     * Writes the given double to the current position and increases the position
     * by 8.
     * <p>
     * The double is converted to bytes using the current byte order.
     *
     * @param value
     *            the double to write.
     * @return {@code this}
     * @exception BufferOverflowException
     *                if position is greater than {@code limit - 8}.
     * @exception ReadOnlyBufferException
     *                if no changes may be made to the contents of this buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.909 -0500", hash_original_method = "E64D988A1CE5EC8B40BAA589E7DE49FB", hash_generated_method = "A690E6FFE2F44F90D42BA99E9C6431E0")
    
public abstract ByteBuffer putDouble(double value);

    /**
     * Writes the given double to the specified index of this buffer.
     * <p>
     * The double is converted to bytes using the current byte order. The
     * position is not changed.
     *
     * @param index
     *            the index, must not be negative and equal or less than
     *            {@code limit - 8}.
     * @param value
     *            the double to write.
     * @return {@code this}
     * @exception IndexOutOfBoundsException
     *                if {@code index} is invalid.
     * @exception ReadOnlyBufferException
     *                if no changes may be made to the contents of this buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.912 -0500", hash_original_method = "D953E19DBF5372CBBCCFAC31998BE0FE", hash_generated_method = "8343D7702B93A1EC5FA16E377831A1AF")
    
public abstract ByteBuffer putDouble(int index, double value);

    /**
     * Writes the given float to the current position and increases the position
     * by 4.
     * <p>
     * The float is converted to bytes using the current byte order.
     *
     * @param value
     *            the float to write.
     * @return {@code this}
     * @exception BufferOverflowException
     *                if position is greater than {@code limit - 4}.
     * @exception ReadOnlyBufferException
     *                if no changes may be made to the contents of this buffer.
     */
    @DSComment("memory buffer only")
    @DSSafe(DSCat.MEM_BUFFER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.914 -0500", hash_original_method = "CAD20A12FC39C156414E05D321098216", hash_generated_method = "2969CB3CF774700206AF11CCD204054A")
    
public abstract ByteBuffer putFloat(float value);

    /**
     * Writes the given float to the specified index of this buffer.
     * <p>
     * The float is converted to bytes using the current byte order. The
     * position is not changed.
     *
     * @param index
     *            the index, must not be negative and equal or less than
     *            {@code limit - 4}.
     * @param value
     *            the float to write.
     * @return {@code this}
     * @exception IndexOutOfBoundsException
     *                if {@code index} is invalid.
     * @exception ReadOnlyBufferException
     *                if no changes may be made to the contents of this buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.917 -0500", hash_original_method = "554A94658153D6D242E4F80493021AA5", hash_generated_method = "601BB92FC2C607615C134FC39EA8B907")
    
public abstract ByteBuffer putFloat(int index, float value);

    /**
     * Writes the given int to the current position and increases the position by
     * 4.
     * <p>
     * The int is converted to bytes using the current byte order.
     *
     * @param value
     *            the int to write.
     * @return {@code this}
     * @exception BufferOverflowException
     *                if position is greater than {@code limit - 4}.
     * @exception ReadOnlyBufferException
     *                if no changes may be made to the contents of this buffer.
     */
    @DSComment("memory buffer only")
    @DSSafe(DSCat.MEM_BUFFER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.919 -0500", hash_original_method = "75EC8C47F9703D9624CB50AF2DF2107C", hash_generated_method = "D017F8503453EA22D1777AB0BA3C4B54")
    
public abstract ByteBuffer putInt(int value);

    /**
     * Writes the given int to the specified index of this buffer.
     * <p>
     * The int is converted to bytes using the current byte order. The position
     * is not changed.
     *
     * @param index
     *            the index, must not be negative and equal or less than
     *            {@code limit - 4}.
     * @param value
     *            the int to write.
     * @return {@code this}
     * @exception IndexOutOfBoundsException
     *                if {@code index} is invalid.
     * @exception ReadOnlyBufferException
     *                if no changes may be made to the contents of this buffer.
     */
    @DSComment("memory buffer only")
    @DSSafe(DSCat.MEM_BUFFER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.922 -0500", hash_original_method = "BAA5B108DB4DFB337C242B4B0C63505D", hash_generated_method = "C233F5397E70E5FD99DD79E363B9A340")
    
public abstract ByteBuffer putInt(int index, int value);

    /**
     * Writes the given long to the current position and increases the position
     * by 8.
     * <p>
     * The long is converted to bytes using the current byte order.
     *
     * @param value
     *            the long to write.
     * @return {@code this}
     * @exception BufferOverflowException
     *                if position is greater than {@code limit - 8}.
     * @exception ReadOnlyBufferException
     *                if no changes may be made to the contents of this buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.924 -0500", hash_original_method = "15B65CCEB3F08CF32631B7873950672F", hash_generated_method = "551FBAB580A07516F4E71F7D4F22B53B")
    
public abstract ByteBuffer putLong(long value);

    /**
     * Writes the given long to the specified index of this buffer.
     * <p>
     * The long is converted to bytes using the current byte order. The position
     * is not changed.
     *
     * @param index
     *            the index, must not be negative and equal or less than
     *            {@code limit - 8}.
     * @param value
     *            the long to write.
     * @return {@code this}
     * @exception IndexOutOfBoundsException
     *                if {@code index} is invalid.
     * @exception ReadOnlyBufferException
     *                if no changes may be made to the contents of this buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.927 -0500", hash_original_method = "F1915EA214B2E29925E9F7A3B8593A2B", hash_generated_method = "93E9DF63E453C4C873800E936100C1CD")
    
public abstract ByteBuffer putLong(int index, long value);

    /**
     * Writes the given short to the current position and increases the position
     * by 2.
     * <p>
     * The short is converted to bytes using the current byte order.
     *
     * @param value
     *            the short to write.
     * @return {@code this}
     * @exception BufferOverflowException
     *                if position is greater than {@code limit - 2}.
     * @exception ReadOnlyBufferException
     *                if no changes may be made to the contents of this buffer.
     */
    @DSComment("memory buffer only")
    @DSSafe(DSCat.MEM_BUFFER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.929 -0500", hash_original_method = "D52374AE84C378EC795E94F54C620976", hash_generated_method = "BEA8FC1140694CED3060B7B5F6313531")
    
public abstract ByteBuffer putShort(short value);

    /**
     * Writes the given short to the specified index of this buffer.
     * <p>
     * The short is converted to bytes using the current byte order. The
     * position is not changed.
     *
     * @param index
     *            the index, must not be negative and equal or less than
     *            {@code limit - 2}.
     * @param value
     *            the short to write.
     * @return {@code this}
     * @exception IndexOutOfBoundsException
     *                if {@code index} is invalid.
     * @exception ReadOnlyBufferException
     *                if no changes may be made to the contents of this buffer.
     */
    @DSComment("memory buffer only")
    @DSSafe(DSCat.MEM_BUFFER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.931 -0500", hash_original_method = "3BAEB9FDE443890D21DF52C9B257B084", hash_generated_method = "EB4251EF9AB7B99B5982F70F15363874")
    
public abstract ByteBuffer putShort(int index, short value);

    /**
     * Returns a sliced buffer that shares its content with this buffer.
     * <p>
     * The sliced buffer's capacity will be this buffer's
     * {@code remaining()}, and it's zero position will correspond to
     * this buffer's current position. The new buffer's position will be 0,
     * limit will be its capacity, and its mark is cleared. The new buffer's
     * read-only property and byte order are the same as this buffer's.
     * <p>
     * The new buffer shares its content with this buffer, which means either
     * buffer's change of content will be visible to the other. The two buffer's
     * position, limit and mark are independent.
     *
     * @return a sliced buffer that shares its content with this buffer.
     */
    @DSComment("memory buffer only")
    @DSSafe(DSCat.MEM_BUFFER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:03.934 -0500", hash_original_method = "A8BD672FEFA2ADBF23B3E18AD8770B59", hash_generated_method = "3EBFFC9669B52A8EEDB07E9A812B2532")
    
public abstract ByteBuffer slice();
    
}

