package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.LongBuffer;

import libcore.io.SizeOf;

public class BitSet implements Serializable, Cloneable {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.872 -0500", hash_original_method = "1111A64C23DDCF149E99F7B137B1F799", hash_generated_method = "4E8F03DCF07A0DF56E510F9082D72E34")
    
private static long[] arrayForBits(int bitCount) {
        return new long[(bitCount + 63)/ 64];
    }

    /**
     * Equivalent to {@code BitSet.valueOf(LongBuffer.wrap(longs))}, but likely to be faster.
     * This is likely to be the fastest way to create a {@code BitSet} because it's closest
     * to the internal representation.
     * @hide 1.7
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.954 -0500", hash_original_method = "C8159A78BE8562D2D9F1DF0DDA2620DD", hash_generated_method = "790027A2935AAD7FDAC9B4945DEA0804")
    
public static BitSet valueOf(long[] longs) {
        return new BitSet(longs.clone());
    }

    /**
     * Returns a {@code BitSet} corresponding to {@code longBuffer}, interpreted as a little-endian
     * sequence of bits. This method does not alter the {@code LongBuffer}.
     * @hide 1.7
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.963 -0500", hash_original_method = "DD569DFB6205EB853157686A9EE36FCB", hash_generated_method = "894D7B624061B6C353A51DB71BD036CE")
    
public static BitSet valueOf(LongBuffer longBuffer) {
        // The bulk get would mutate LongBuffer (even if we reset position later), and it's not
        // clear that's allowed. My assumption is that it's the long[] variant that's the common
        // case anyway, so copy the buffer into a long[].
        long[] longs = new long[longBuffer.remaining()];
        for (int i = 0; i < longs.length; ++i) {
            longs[i] = longBuffer.get(longBuffer.position() + i);
        }
        return BitSet.valueOf(longs);
    }

    /**
     * Equivalent to {@code BitSet.valueOf(ByteBuffer.wrap(bytes))}.
     * @hide 1.7
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.965 -0500", hash_original_method = "DC3F0689BFE4E765667AB4AD073F9341", hash_generated_method = "7F61F6426C7F17D90DB69476D461D980")
    
public static BitSet valueOf(byte[] bytes) {
        return BitSet.valueOf(ByteBuffer.wrap(bytes));
    }

    /**
     * Returns a {@code BitSet} corresponding to {@code byteBuffer}, interpreted as a little-endian
     * sequence of bits. This method does not alter the {@code ByteBuffer}.
     * @hide 1.7
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.968 -0500", hash_original_method = "5ACB02A28D6F82C45314227EF9456C0E", hash_generated_method = "E2D0FD93A8E61FA9A599886183C1C711")
    
public static BitSet valueOf(ByteBuffer byteBuffer) {
        byteBuffer = byteBuffer.slice().order(ByteOrder.LITTLE_ENDIAN);
        long[] longs = arrayForBits(byteBuffer.remaining() * 8);
        int i = 0;
        while (byteBuffer.remaining() >= SizeOf.LONG) {
            longs[i++] = byteBuffer.getLong();
        }
        for (int j = 0; byteBuffer.hasRemaining(); ++j) {
            longs[i] |= ((((long) byteBuffer.get()) & 0xff) << (8*j));
        }
        return BitSet.valueOf(longs);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.852 -0500", hash_original_field = "E9AD6054FBF64C1F5CBC9A3ECFD47A0F", hash_generated_field = "975BBBA7B21A6881F86AABFE03BF689A")

    private static final long serialVersionUID = 7997698588986878753L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.854 -0500", hash_original_field = "DEEECB9191B71C4C2B4B619251057097", hash_generated_field = "BC830E41BA8334B8E98728347067D4B9")

    private static final long ALL_ONES = ~0L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.857 -0500", hash_original_field = "92F775DED5CE5142CEEF7075890CCFCE", hash_generated_field = "487233F7143B18DBA481DB90C8ACD8D3")

    private long[] bits;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.859 -0500", hash_original_field = "4AD87862C652F89C878D30BE61E5EA20", hash_generated_field = "DC80EF19CD932E16185FEB519D23D494")

    private transient int longCount;

    /**
     * Creates a new {@code BitSet} with size equal to 64 bits.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.864 -0500", hash_original_method = "36F48153593A7027DE7089606CF225FB", hash_generated_method = "B8AA473D2470532DC2D2F7EE24947AC2")
    
public BitSet() {
        this(new long[1]);
    }

    /**
     * Creates a new {@code BitSet} with size equal to {@code bitCount}, rounded up to
     * a multiple of 64.
     *
     * @throws NegativeArraySizeException if {@code bitCount < 0}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.866 -0500", hash_original_method = "12ED281EDA73627C34F706B1E8393C0F", hash_generated_method = "CCA75D20C978B5242794FB978FDBC8AB")
    
public BitSet(int bitCount) {
        if (bitCount < 0) {
            throw new NegativeArraySizeException();
        }
        this.bits = arrayForBits(bitCount);
        this.longCount = 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.869 -0500", hash_original_method = "F5397E49D432953D65E6CB2ED1150384", hash_generated_method = "A2CD9155732F355E87209AA42010DC75")
    
private BitSet(long[] bits) {
        this.bits = bits;
        this.longCount = bits.length;
        shrinkSize();
    }

    /**
     * Updates 'longCount' by inspecting 'bits'. Assumes that the new longCount is <= the current
     * longCount, to avoid scanning large tracts of empty array. This means it's safe to call
     * directly after a clear operation that may have cleared the highest set bit, but
     * not safe after an xor operation that may have cleared the highest set bit or
     * made a new highest set bit. In that case, you'd need to set 'longCount' to a conservative
     * estimate before calling this method.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.861 -0500", hash_original_method = "2E0FE194508C45AD5184DCF0A152D7A0", hash_generated_method = "C9D76E5C4B47FC1953B85F362C2958F2")
    
private void shrinkSize() {
        int i = longCount - 1;
        while (i >= 0 && bits[i] == 0) {
            --i;
        }
        this.longCount = i + 1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.875 -0500", hash_original_method = "C5612661FC3C49DB4DB071789CF210EF", hash_generated_method = "590C4E443B620BE6282321651CBBA4E4")
    
@Override public Object clone() {
        try {
            BitSet clone = (BitSet) super.clone();
            clone.bits = bits.clone();
            clone.shrinkSize();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.878 -0500", hash_original_method = "82791B0EBFB6ED23064857D8180EA65E", hash_generated_method = "098F5947404DE24CCAE785B9D16E13F4")
    
@Override public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BitSet)) {
            return false;
        }
        BitSet lhs = (BitSet) o;
        if (this.longCount != lhs.longCount) {
            return false;
        }
        for (int i = 0; i < longCount; ++i) {
            if (bits[i] != lhs.bits[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Ensures that our long[] can hold at least 64 * desiredLongCount bits.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.881 -0500", hash_original_method = "FD70AAE85AF9795828FE994C30CD34E8", hash_generated_method = "935D764AA3BFBA7DB148A96DB36F16D9")
    
private void ensureCapacity(int desiredLongCount) {
        if (desiredLongCount <= bits.length) {
            return;
        }
        int newLength = Math.max(desiredLongCount, bits.length * 2);
        long[] newBits = new long[newLength];
        System.arraycopy(bits, 0, newBits, 0, longCount);
        this.bits = newBits;
        // 'longCount' is unchanged by this operation: the long[] is larger,
        // but you're not yet using any more of it.
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.883 -0500", hash_original_method = "4E772724E1A92C93EB62C933BC27FE7C", hash_generated_method = "4CBF6F9EA2E60EED0FE74C1AE63E714A")
    
@Override public int hashCode() {
        // The RI doesn't use Arrays.hashCode, and explicitly specifies this algorithm.
        long x = 1234;
        for (int i = 0; i < longCount; ++i) {
            x ^= bits[i] * (i + 1);
        }
        return (int) ((x >> 32) ^ x);
    }

    /**
     * Returns the bit at index {@code index}. Indexes greater than the current length return false.
     *
     * @throws IndexOutOfBoundsException if {@code index < 0}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.885 -0500", hash_original_method = "95B4B3127159370AD2A9AF3A9CB73F00", hash_generated_method = "0C9AC5C908057F8168D7843E21A6DF08")
    
public boolean get(int index) {
        if (index < 0) { // TODO: until we have an inlining JIT.
            checkIndex(index);
        }
        int arrayIndex = index / 64;
        if (arrayIndex >= longCount) {
            return false;
        }
        return (bits[arrayIndex] & (1L << index)) != 0;
    }

    /**
     * Sets the bit at index {@code index} to true.
     *
     * @throws IndexOutOfBoundsException if {@code index < 0}.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.888 -0500", hash_original_method = "3D2EC51930163E4AB4304E4F9059CB5F", hash_generated_method = "8185EA4AEDBA7BDE7BA26A57910FD132")
    
public void set(int index) {
        if (index < 0) { // TODO: until we have an inlining JIT.
            checkIndex(index);
        }
        int arrayIndex = index / 64;
        if (arrayIndex >= bits.length) {
            ensureCapacity(arrayIndex + 1);
        }
        bits[arrayIndex] |= (1L << index);
        longCount = Math.max(longCount, arrayIndex + 1);
    }

    /**
     * Clears the bit at index {@code index}.
     *
     * @throws IndexOutOfBoundsException if {@code index < 0}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.890 -0500", hash_original_method = "D4755629803CE3870851808B06FB6C2C", hash_generated_method = "E4EF3C3547190AAB68250E8985CC28B6")
    
public void clear(int index) {
        if (index < 0) { // TODO: until we have an inlining JIT.
            checkIndex(index);
        }
        int arrayIndex = index / 64;
        if (arrayIndex >= longCount) {
            return;
        }
        bits[arrayIndex] &= ~(1L << index);
        shrinkSize();
    }

    /**
     * Flips the bit at index {@code index}.
     *
     * @throws IndexOutOfBoundsException if {@code index < 0}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.893 -0500", hash_original_method = "BA9F6F086346AF8289CA95B11E39C3E4", hash_generated_method = "CBF708E1A1C1C1A7979EA13B1DE13E6D")
    
public void flip(int index) {
        if (index < 0) { // TODO: until we have an inlining JIT.
            checkIndex(index);
        }
        int arrayIndex = index / 64;
        if (arrayIndex >= bits.length) {
            ensureCapacity(arrayIndex + 1);
        }
        bits[arrayIndex] ^= (1L << index);
        longCount = Math.max(longCount, arrayIndex + 1);
        shrinkSize();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.895 -0500", hash_original_method = "71550A783E2339080C93A6660DB93338", hash_generated_method = "C2654B8AA28FA43925B6F6B20C02FB6B")
    
private void checkIndex(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("index < 0: " + index);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.898 -0500", hash_original_method = "87A456FF76D283B2A0EA4C0CB9963D07", hash_generated_method = "013A5A64FF0CBDCE4B0D551CF9B9626D")
    
private void checkRange(int fromIndex, int toIndex) {
        if ((fromIndex | toIndex) < 0 || toIndex < fromIndex) {
            throw new IndexOutOfBoundsException("fromIndex=" + fromIndex + " toIndex=" + toIndex);
        }
    }

    /**
     * Returns a new {@code BitSet} containing the
     * range of bits {@code [fromIndex, toIndex)}, shifted down so that the bit
     * at {@code fromIndex} is at bit 0 in the new {@code BitSet}.
     *
     * @throws IndexOutOfBoundsException
     *             if {@code fromIndex} or {@code toIndex} is negative, or if
     *             {@code toIndex} is smaller than {@code fromIndex}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.901 -0500", hash_original_method = "5C76FE7FFACA682F8E2DA192826E5D27", hash_generated_method = "BE536BDE2E3E2A89FF121B98ADC0FD25")
    
public BitSet get(int fromIndex, int toIndex) {
        checkRange(fromIndex, toIndex);

        int last = 64 * longCount;
        if (fromIndex >= last || fromIndex == toIndex) {
            return new BitSet(0);
        }
        if (toIndex > last) {
            toIndex = last;
        }

        int firstArrayIndex = fromIndex / 64;
        int lastArrayIndex = (toIndex - 1) / 64;
        long lowMask = ALL_ONES << fromIndex;
        long highMask = ALL_ONES >>> -toIndex;

        if (firstArrayIndex == lastArrayIndex) {
            long result = (bits[firstArrayIndex] & (lowMask & highMask)) >>> fromIndex;
            if (result == 0) {
                return new BitSet(0);
            }
            return new BitSet(new long[] { result });
        }

        long[] newBits = new long[lastArrayIndex - firstArrayIndex + 1];

        // first fill in the first and last indexes in the new BitSet
        newBits[0] = bits[firstArrayIndex] & lowMask;
        newBits[newBits.length - 1] = bits[lastArrayIndex] & highMask;

        // fill in the in between elements of the new BitSet
        for (int i = 1; i < lastArrayIndex - firstArrayIndex; i++) {
            newBits[i] = bits[firstArrayIndex + i];
        }

        // shift all the elements in the new BitSet to the right
        int numBitsToShift = fromIndex % 64;
        int actualLen = newBits.length;
        if (numBitsToShift != 0) {
            for (int i = 0; i < newBits.length; i++) {
                // shift the current element to the right regardless of
                // sign
                newBits[i] = newBits[i] >>> (numBitsToShift);

                // apply the last x bits of newBits[i+1] to the current
                // element
                if (i != newBits.length - 1) {
                    newBits[i] |= newBits[i + 1] << -numBitsToShift;
                }
                if (newBits[i] != 0) {
                    actualLen = i + 1;
                }
            }
        }
        return new BitSet(newBits);
    }

    /**
     * Sets the bit at index {@code index} to {@code state}.
     *
     * @throws IndexOutOfBoundsException if {@code index < 0}.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.903 -0500", hash_original_method = "74386BE28B96B2445F889AFAD9F88AFA", hash_generated_method = "5075AF5A9DA1126BC989D385BF14419D")
    
public void set(int index, boolean state) {
        if (state) {
            set(index);
        } else {
            clear(index);
        }
    }

    /**
     * Sets the range of bits {@code [fromIndex, toIndex)} to {@code state}.
     *
     * @throws IndexOutOfBoundsException
     *             if {@code fromIndex} or {@code toIndex} is negative, or if
     *             {@code toIndex} is smaller than {@code fromIndex}.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.905 -0500", hash_original_method = "9EFB812AD22830556B4E1C754018229D", hash_generated_method = "C684743A61A6FE7B85D098BB851F13D6")
    
public void set(int fromIndex, int toIndex, boolean state) {
        if (state) {
            set(fromIndex, toIndex);
        } else {
            clear(fromIndex, toIndex);
        }
    }

    /**
     * Clears all the bits in this {@code BitSet}. This method does not change the capacity.
     * Use {@code clear} if you want to reuse this {@code BitSet} with the same capacity, but
     * create a new {@code BitSet} if you're trying to potentially reclaim memory.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.908 -0500", hash_original_method = "8EA7A389047D1FB0971FCD5F7482B28A", hash_generated_method = "1F75C74EF9ED9056BC657885E3A90A4D")
    
public void clear() {
        Arrays.fill(bits, 0, longCount, 0L);
        longCount = 0;
    }

    /**
     * Sets the range of bits {@code [fromIndex, toIndex)}.
     *
     * @throws IndexOutOfBoundsException
     *             if {@code fromIndex} or {@code toIndex} is negative, or if
     *             {@code toIndex} is smaller than {@code fromIndex}.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.911 -0500", hash_original_method = "A26503DA159C46EB79782AEABE473F9D", hash_generated_method = "31C8795A099AF909AD3221B0BD5FAA64")
    
public void set(int fromIndex, int toIndex) {
        checkRange(fromIndex, toIndex);
        if (fromIndex == toIndex) {
            return;
        }
        int firstArrayIndex = fromIndex / 64;
        int lastArrayIndex = (toIndex - 1) / 64;
        if (lastArrayIndex >= bits.length) {
            ensureCapacity(lastArrayIndex + 1);
        }

        long lowMask = ALL_ONES << fromIndex;
        long highMask = ALL_ONES >>> -toIndex;
        if (firstArrayIndex == lastArrayIndex) {
            bits[firstArrayIndex] |= (lowMask & highMask);
        } else {
            int i = firstArrayIndex;
            bits[i++] |= lowMask;
            while (i < lastArrayIndex) {
                bits[i++] |= ALL_ONES;
            }
            bits[i++] |= highMask;
        }
        longCount = Math.max(longCount, lastArrayIndex + 1);
    }

    /**
     * Clears the range of bits {@code [fromIndex, toIndex)}.
     *
     * @throws IndexOutOfBoundsException
     *             if {@code fromIndex} or {@code toIndex} is negative, or if
     *             {@code toIndex} is smaller than {@code fromIndex}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.914 -0500", hash_original_method = "C97E5F07F0FAAF9942FBF154783DA0BB", hash_generated_method = "834ED009CA61DD9344A1FC53C9C8FBD1")
    
public void clear(int fromIndex, int toIndex) {
        checkRange(fromIndex, toIndex);
        if (fromIndex == toIndex || longCount == 0) {
            return;
        }
        int last = 64 * longCount;
        if (fromIndex >= last) {
            return;
        }
        if (toIndex > last) {
            toIndex = last;
        }
        int firstArrayIndex = fromIndex / 64;
        int lastArrayIndex = (toIndex - 1) / 64;

        long lowMask = ALL_ONES << fromIndex;
        long highMask = ALL_ONES >>> -toIndex;
        if (firstArrayIndex == lastArrayIndex) {
            bits[firstArrayIndex] &= ~(lowMask & highMask);
        } else {
            int i = firstArrayIndex;
            bits[i++] &= ~lowMask;
            while (i < lastArrayIndex) {
                bits[i++] = 0L;
            }
            bits[i++] &= ~highMask;
        }
        shrinkSize();
    }

    /**
     * Flips the range of bits {@code [fromIndex, toIndex)}.
     *
     * @throws IndexOutOfBoundsException
     *             if {@code fromIndex} or {@code toIndex} is negative, or if
     *             {@code toIndex} is smaller than {@code fromIndex}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.917 -0500", hash_original_method = "AF219115F487DC5279F51F56FAD6576B", hash_generated_method = "5244D7C85548360E5DE79E6B229A8F07")
    
public void flip(int fromIndex, int toIndex) {
        checkRange(fromIndex, toIndex);
        if (fromIndex == toIndex) {
            return;
        }
        int firstArrayIndex = fromIndex / 64;
        int lastArrayIndex = (toIndex - 1) / 64;
        if (lastArrayIndex >= bits.length) {
            ensureCapacity(lastArrayIndex + 1);
        }

        long lowMask = ALL_ONES << fromIndex;
        long highMask = ALL_ONES >>> -toIndex;
        if (firstArrayIndex == lastArrayIndex) {
            bits[firstArrayIndex] ^= (lowMask & highMask);
        } else {
            int i = firstArrayIndex;
            bits[i++] ^= lowMask;
            while (i < lastArrayIndex) {
                bits[i++] ^= ALL_ONES;
            }
            bits[i++] ^= highMask;
        }
        longCount = Math.max(longCount, lastArrayIndex + 1);
        shrinkSize();
    }

    /**
     * Returns true if {@code this.and(bs)} is non-empty, but may be faster than computing that.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.919 -0500", hash_original_method = "F6E914263E6B2AC21BC763D068DFC9F2", hash_generated_method = "906442D4B1AFE9389AD1461F9D961E7E")
    
public boolean intersects(BitSet bs) {
        long[] bsBits = bs.bits;
        int length = Math.min(this.longCount, bs.longCount);
        for (int i = 0; i < length; ++i) {
            if ((bits[i] & bsBits[i]) != 0L) {
                return true;
            }
        }
        return false;
    }

    /**
     * Logically ands the bits of this {@code BitSet} with {@code bs}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.922 -0500", hash_original_method = "83F89EEE7E2D54034E7D4AA2FF619E80", hash_generated_method = "01DEA52140EAB11F467F27664E3D4B3B")
    
public void and(BitSet bs) {
        int minSize = Math.min(this.longCount, bs.longCount);
        for (int i = 0; i < minSize; ++i) {
            bits[i] &= bs.bits[i];
        }
        Arrays.fill(bits, minSize, longCount, 0L);
        shrinkSize();
    }

    /**
     * Clears all bits in this {@code BitSet} which are also set in {@code bs}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.924 -0500", hash_original_method = "6AEA541E74DD35C186C561500AE782A6", hash_generated_method = "FC8A10E7477CF74A1FCB28AC26EF8501")
    
public void andNot(BitSet bs) {
        int minSize = Math.min(this.longCount, bs.longCount);
        for (int i = 0; i < minSize; ++i) {
            bits[i] &= ~bs.bits[i];
        }
        shrinkSize();
    }

    /**
     * Logically ors the bits of this {@code BitSet} with {@code bs}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.927 -0500", hash_original_method = "BEA444ABE4A457608A295CEBFA17C48D", hash_generated_method = "24F5C73F5339141EEA015851EF14A7AB")
    
public void or(BitSet bs) {
        int minSize = Math.min(this.longCount, bs.longCount);
        int maxSize = Math.max(this.longCount, bs.longCount);
        ensureCapacity(maxSize);
        for (int i = 0; i < minSize; ++i) {
            bits[i] |= bs.bits[i];
        }
        if (bs.longCount > minSize) {
            System.arraycopy(bs.bits, minSize, bits, minSize, maxSize - minSize);
        }
        longCount = maxSize;
    }

    /**
     * Logically xors the bits of this {@code BitSet} with {@code bs}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.929 -0500", hash_original_method = "E1F10E844B44799F9E6FF97093185186", hash_generated_method = "F5429E772A6CEA41116922E365498C29")
    
public void xor(BitSet bs) {
        int minSize = Math.min(this.longCount, bs.longCount);
        int maxSize = Math.max(this.longCount, bs.longCount);
        ensureCapacity(maxSize);
        for (int i = 0; i < minSize; ++i) {
            bits[i] ^= bs.bits[i];
        }
        if (bs.longCount > minSize) {
            System.arraycopy(bs.bits, minSize, bits, minSize, maxSize - minSize);
        }
        longCount = maxSize;
        shrinkSize();
    }

    /**
     * Returns the capacity in bits of the array implementing this {@code BitSet}. This is
     * unrelated to the length of the {@code BitSet}, and not generally useful.
     * Use {@link #nextSetBit} to iterate, or {@link #length} to find the highest set bit.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.932 -0500", hash_original_method = "F33E07354BDEEAA3CDE5DA5EA8779C95", hash_generated_method = "68F75C1103E4801917F2C9C997F00A32")
    
public int size() {
        return bits.length * 64;
    }

    /**
     * Returns the number of bits up to and including the highest bit set. This is unrelated to
     * the {@link #size} of the {@code BitSet}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.934 -0500", hash_original_method = "6F3396C6D4F506441C95587742A4BBC3", hash_generated_method = "554038216182ED28D763275A8FC1C890")
    
public int length() {
        if (longCount == 0) {
            return 0;
        }
        return 64 * (longCount - 1) + (64 - Long.numberOfLeadingZeros(bits[longCount - 1]));
    }

    /**
     * Returns a string containing a concise, human-readable description of the
     * receiver: a comma-delimited list of the indexes of all set bits.
     * For example: {@code "{0,1,8}"}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.937 -0500", hash_original_method = "A54CE267AEC3D3118A3C3A52C928D20A", hash_generated_method = "8E2F86D5ADB18E72C5366992FFD4F3E2")
    
@Override public String toString() {
        //System.err.println("BitSet[longCount=" + longCount + ",bits=" + Arrays.toString(bits) + "]");
        StringBuilder sb = new StringBuilder(longCount / 2);
        sb.append('{');
        boolean comma = false;
        for (int i = 0; i < longCount; ++i) {
            if (bits[i] != 0) {
                for (int j = 0; j < 64; ++j) {
                    if ((bits[i] & 1L << j) != 0) {
                        if (comma) {
                            sb.append(", ");
                        } else {
                            comma = true;
                        }
                        sb.append(64 * i + j);
                    }
                }
            }
        }
        sb.append('}');
        return sb.toString();
    }

    /**
     * Returns the index of the first bit that is set on or after {@code index}, or -1
     * if no higher bits are set.
     * @throws IndexOutOfBoundsException if {@code index < 0}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.940 -0500", hash_original_method = "9B70742E631D0FF7E36300CA25C790B5", hash_generated_method = "5C274020D0532A2AF22F681E173C8CB0")
    
public int nextSetBit(int index) {
        checkIndex(index);
        int arrayIndex = index / 64;
        if (arrayIndex >= longCount) {
            return -1;
        }
        long mask = ALL_ONES << index;
        if ((bits[arrayIndex] & mask) != 0) {
            return 64 * arrayIndex + Long.numberOfTrailingZeros(bits[arrayIndex] & mask);
        }
        while (++arrayIndex < longCount && bits[arrayIndex] == 0) {
        }
        if (arrayIndex == longCount) {
            return -1;
        }
        return 64 * arrayIndex + Long.numberOfTrailingZeros(bits[arrayIndex]);
    }

    /**
     * Returns the index of the first bit that is clear on or after {@code index}.
     * Since all bits past the end are implicitly clear, this never returns -1.
     * @throws IndexOutOfBoundsException if {@code index < 0}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.943 -0500", hash_original_method = "B6E36E70EF447F6B993A99CF808640C0", hash_generated_method = "9ABEA64DE2AF5FBA46B9353AE490B318")
    
public int nextClearBit(int index) {
        checkIndex(index);
        int arrayIndex = index / 64;
        if (arrayIndex >= longCount) {
            return index;
        }
        long mask = ALL_ONES << index;
        if ((~bits[arrayIndex] & mask) != 0) {
            return 64 * arrayIndex + Long.numberOfTrailingZeros(~bits[arrayIndex] & mask);
        }
        while (++arrayIndex < longCount && bits[arrayIndex] == ALL_ONES) {
        }
        if (arrayIndex == longCount) {
            return size();
        }
        return 64 * arrayIndex + Long.numberOfTrailingZeros(~bits[arrayIndex]);
    }

    /**
     * Returns the index of the first bit that is set on or before {@code index}, or -1 if
     * no lower bits are set or {@code index == -1}.
     * @throws IndexOutOfBoundsException if {@code index < -1}.
     * @hide 1.7
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.945 -0500", hash_original_method = "BDE3A7C277C6F771330A08D119C9767D", hash_generated_method = "8DB7F33DCFA3187134647D41E6E80C1C")
    
public int previousSetBit(int index) {
        if (index == -1) {
            return -1;
        }
        checkIndex(index);
        // TODO: optimize this.
        for (int i = index; i >= 0; --i) {
            if (get(i)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns the index of the first bit that is clear on or before {@code index}, or -1 if
     * no lower bits are clear or {@code index == -1}.
     * @throws IndexOutOfBoundsException if {@code index < -1}.
     * @hide 1.7
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.948 -0500", hash_original_method = "4D910DE065D256451DE439F25B5A6A08", hash_generated_method = "0A376BD5286D566B082596287C190E5D")
    
public int previousClearBit(int index) {
        if (index == -1) {
            return -1;
        }
        checkIndex(index);
        // TODO: optimize this.
        for (int i = index; i >= 0; --i) {
            if (!get(i)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns true if all the bits in this {@code BitSet} are set to false, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.950 -0500", hash_original_method = "F34A10F6A3FF7AEAC6E09DDBD9741E2B", hash_generated_method = "7155D76E515931672786B8CA9752FA19")
    
public boolean isEmpty() {
        return (longCount == 0);
    }

    /**
     * Returns the number of bits that are {@code true} in this {@code BitSet}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.952 -0500", hash_original_method = "5D3E782DB55862032A3B0CF1D30A4050", hash_generated_method = "32A32E7B2DC50E8F023DE83299F1D9FD")
    
public int cardinality() {
        int result = 0;
        for (int i = 0; i < longCount; ++i) {
            result += Long.bitCount(bits[i]);
        }
        return result;
    }

    /**
     * Returns a new {@code long[]} containing a little-endian representation of the bits of
     * this {@code BitSet}, suitable for passing to {@code valueOf} to reconstruct
     * this {@code BitSet}.
     * @hide 1.7
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.970 -0500", hash_original_method = "87C10E36682237AA1B22F77F460E655A", hash_generated_method = "8414CBD25EFE7E0B2432E58F20AD2989")
    
public long[] toLongArray() {
        return Arrays.copyOf(bits, longCount);
    }

    /**
     * Returns a new {@code byte[]} containing a little-endian representation the bits of
     * this {@code BitSet}, suitable for passing to {@code valueOf} to reconstruct
     * this {@code BitSet}.
     * @hide 1.7
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.972 -0500", hash_original_method = "BCE80AE7073A25796C80405F8FB14636", hash_generated_method = "F8B61DA0FCB0C79B27726A5133092BC9")
    
public byte[] toByteArray() {
        int bitCount = length();
        byte[] result = new byte[(bitCount + 7)/ 8];
        for (int i = 0; i < result.length; ++i) {
            int lowBit = 8 * i;
            int arrayIndex = lowBit / 64;
            result[i] = (byte) (bits[arrayIndex] >>> lowBit);
        }
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.975 -0500", hash_original_method = "928646C6EBB028EB87EF1072BE151B53", hash_generated_method = "05C2E4053D2A8B44000E20510FE6C453")
    
private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        // The serialized form doesn't include a 'longCount' field, so we'll have to scan the array.
        this.longCount = this.bits.length;
        shrinkSize();
    }
}

