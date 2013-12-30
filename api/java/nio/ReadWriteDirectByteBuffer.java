package java.nio;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import libcore.io.Memory;
import libcore.io.SizeOf;




final class ReadWriteDirectByteBuffer extends DirectByteBuffer {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.863 -0500", hash_original_method = "606F49D58A59410A4684B206A52E185F", hash_generated_method = "C2A300365376ECC3085B834EAD5F24EB")
    
static ReadWriteDirectByteBuffer copy(DirectByteBuffer other, int markOfOther) {
        ReadWriteDirectByteBuffer buf =
                new ReadWriteDirectByteBuffer(other.block, other.capacity(), other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    // Used by ByteBuffer.allocateDirect.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.866 -0500", hash_original_method = "F2F90AA1C14708BA27FBCC0DAF6F8A9D", hash_generated_method = "F2F90AA1C14708BA27FBCC0DAF6F8A9D")
    
ReadWriteDirectByteBuffer(int capacity) {
        super(MemoryBlock.allocate(capacity), capacity, 0);
    }

    // Used by the JNI NewDirectByteBuffer function.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.869 -0500", hash_original_method = "B59F4E2576E1A9EB301DFADAA106D67F", hash_generated_method = "B59F4E2576E1A9EB301DFADAA106D67F")
    
ReadWriteDirectByteBuffer(int address, int capacity) {
        super(MemoryBlock.wrapFromJni(address, capacity), capacity, 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.871 -0500", hash_original_method = "64217974EE9299818C86F07054C3DD19", hash_generated_method = "64217974EE9299818C86F07054C3DD19")
    
ReadWriteDirectByteBuffer(MemoryBlock block, int capacity, int offset) {
        super(block, capacity, offset);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.874 -0500", hash_original_method = "CE9B7C65263563316466CBF3E3F947EC", hash_generated_method = "1058763992E0D8FA5F02903F342F0F47")
    
@Override
    public ByteBuffer asReadOnlyBuffer() {
        return ReadOnlyDirectByteBuffer.copy(this, mark);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.876 -0500", hash_original_method = "D5E5DB3E7908F6BA902162C22E7A6F05", hash_generated_method = "3379C45A52F10F2B684BA7491F4C3883")
    
@Override
    public ByteBuffer compact() {
        Memory.memmove(this, 0, this, position, remaining());
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.879 -0500", hash_original_method = "C2883EB2B7E86A704D76356E1AAB194F", hash_generated_method = "ED4EF02B9858C417E9309F42C851963A")
    
@Override
    public ByteBuffer duplicate() {
        return copy(this, mark);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.881 -0500", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "71081A201DF7B08144D6AE781E679981")
    
@Override
    public boolean isReadOnly() {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.884 -0500", hash_original_method = "395C1E25ABAA7CA19067E1D56A7B6B36", hash_generated_method = "17FA8FF251ACE9AAFF768BC99391EDB1")
    
@Override
    public ByteBuffer put(byte value) {
        if (position == limit) {
            throw new BufferOverflowException();
        }
        this.block.pokeByte(offset + position++, value);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.886 -0500", hash_original_method = "652949A668C0C42E265D3C7FA8C1BFFC", hash_generated_method = "1524ECF9DF67FBC9F36A540B5CCC181D")
    
@Override
    public ByteBuffer put(int index, byte value) {
        checkIndex(index);
        this.block.pokeByte(offset + index, value);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.889 -0500", hash_original_method = "BDD014EAD3BC316DD5191C68FD62AF55", hash_generated_method = "DABF59484564E649BCEF0837E4366D6D")
    
@Override
    public ByteBuffer put(byte[] src, int srcOffset, int byteCount) {
        checkPutBounds(1, src.length, srcOffset, byteCount);
        this.block.pokeByteArray(offset + position, src, srcOffset, byteCount);
        position += byteCount;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.891 -0500", hash_original_method = "3221718B504A786DEFCB0B7DC092A6F4", hash_generated_method = "C62ADAB5A4D8F21A815CA9AF9B574A1A")
    
final void put(char[] src, int srcOffset, int charCount) {
        int byteCount = checkPutBounds(SizeOf.CHAR, src.length, srcOffset, charCount);
        this.block.pokeCharArray(offset + position, src, srcOffset, charCount, order.needsSwap);
        position += byteCount;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.894 -0500", hash_original_method = "96DFC920F61F6006882BF66934B5DF94", hash_generated_method = "BC901481B14820A523E8F2A014B1BC01")
    
final void put(double[] src, int srcOffset, int doubleCount) {
        int byteCount = checkPutBounds(SizeOf.DOUBLE, src.length, srcOffset, doubleCount);
        this.block.pokeDoubleArray(offset + position, src, srcOffset, doubleCount, order.needsSwap);
        position += byteCount;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.897 -0500", hash_original_method = "C81F946AF2E7397E3B6D2FB9DB9038F5", hash_generated_method = "2277334AB7888CE22237E032A79741BC")
    
final void put(float[] src, int srcOffset, int floatCount) {
        int byteCount = checkPutBounds(SizeOf.FLOAT, src.length, srcOffset, floatCount);
        this.block.pokeFloatArray(offset + position, src, srcOffset, floatCount, order.needsSwap);
        position += byteCount;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.899 -0500", hash_original_method = "69116E139CC5D8D5FB2D59FB1E27087D", hash_generated_method = "7C2A31C15DF1A254375CC18946693C4A")
    
final void put(int[] src, int srcOffset, int intCount) {
        int byteCount = checkPutBounds(SizeOf.INT, src.length, srcOffset, intCount);
        this.block.pokeIntArray(offset + position, src, srcOffset, intCount, order.needsSwap);
        position += byteCount;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.902 -0500", hash_original_method = "F69F67F942D07574E852DB6B4C993418", hash_generated_method = "E8F0FA8B8890C3423109EFAC9A67FA5F")
    
final void put(long[] src, int srcOffset, int longCount) {
        int byteCount = checkPutBounds(SizeOf.LONG, src.length, srcOffset, longCount);
        this.block.pokeLongArray(offset + position, src, srcOffset, longCount, order.needsSwap);
        position += byteCount;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.904 -0500", hash_original_method = "E0EA76B0F879DDFFA81447B27E7A4446", hash_generated_method = "99FF64CD855C046B9E6CF8BD1BCACE32")
    
final void put(short[] src, int srcOffset, int shortCount) {
        int byteCount = checkPutBounds(SizeOf.SHORT, src.length, srcOffset, shortCount);
        this.block.pokeShortArray(offset + position, src, srcOffset, shortCount, order.needsSwap);
        position += byteCount;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.907 -0500", hash_original_method = "F0572D8329DABC9F86465CEDFC740ABD", hash_generated_method = "8122CAF358053ABCE555E9293066179A")
    
@Override
    public ByteBuffer putChar(char value) {
        int newPosition = position + SizeOf.CHAR;
        if (newPosition > limit) {
            throw new BufferOverflowException();
        }
        this.block.pokeShort(offset + position, (short) value, order);
        position = newPosition;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.909 -0500", hash_original_method = "CBD66B79847E3D8D427C79D0498E0CCC", hash_generated_method = "89F1DCCCA192ED32F37A74C27D59E378")
    
@Override
    public ByteBuffer putChar(int index, char value) {
        checkIndex(index, SizeOf.CHAR);
        this.block.pokeShort(offset + index, (short) value, order);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.912 -0500", hash_original_method = "9ED8D9340D66DD3DF3B6EBAEE44AFD16", hash_generated_method = "856BE1094B730A48B7225BA6CAAD0EA0")
    
@Override
    public ByteBuffer putDouble(double value) {
        int newPosition = position + SizeOf.DOUBLE;
        if (newPosition > limit) {
            throw new BufferOverflowException();
        }
        this.block.pokeLong(offset + position, Double.doubleToRawLongBits(value), order);
        position = newPosition;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.915 -0500", hash_original_method = "8AAC575A61B55D0966D81E09A35D0181", hash_generated_method = "F35A44B0962D3DE5285EF45E18D1AB50")
    
@Override
    public ByteBuffer putDouble(int index, double value) {
        checkIndex(index, SizeOf.DOUBLE);
        this.block.pokeLong(offset + index, Double.doubleToRawLongBits(value), order);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.918 -0500", hash_original_method = "0A3477476230781B1656EAAB87E3304B", hash_generated_method = "14FBDA18CD744520B68AA36731A24139")
    
@Override
    public ByteBuffer putFloat(float value) {
        int newPosition = position + SizeOf.FLOAT;
        if (newPosition > limit) {
            throw new BufferOverflowException();
        }
        this.block.pokeInt(offset + position, Float.floatToRawIntBits(value), order);
        position = newPosition;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.921 -0500", hash_original_method = "E1D9BD09C632F025AC8B3D46ED3F66A9", hash_generated_method = "19B39F1E95189DA4EF8773022C62239D")
    
@Override
    public ByteBuffer putFloat(int index, float value) {
        checkIndex(index, SizeOf.FLOAT);
        this.block.pokeInt(offset + index, Float.floatToRawIntBits(value), order);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.923 -0500", hash_original_method = "8B2258E2CDB6554D65089AAF42AB6164", hash_generated_method = "211BB723E60BEB980335196253F32D6E")
    
@Override
    public ByteBuffer putInt(int value) {
        int newPosition = position + SizeOf.INT;
        if (newPosition > limit) {
            throw new BufferOverflowException();
        }
        this.block.pokeInt(offset + position, value, order);
        position = newPosition;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.926 -0500", hash_original_method = "8C6F9A9AD35489B3E9144FE27229FEA6", hash_generated_method = "858C9DEC8749F286B76C2217571B75D9")
    
@Override
    public ByteBuffer putInt(int index, int value) {
        checkIndex(index, SizeOf.INT);
        this.block.pokeInt(offset + index, value, order);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.928 -0500", hash_original_method = "1B6AA9EF9F994F4063EEE65EEDAD78AF", hash_generated_method = "A0BEAFFA73704D3712F909A4463CC7C9")
    
@Override
    public ByteBuffer putLong(long value) {
        int newPosition = position + SizeOf.LONG;
        if (newPosition > limit) {
            throw new BufferOverflowException();
        }
        this.block.pokeLong(offset + position, value, order);
        position = newPosition;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.931 -0500", hash_original_method = "4C4D1F2ADFCF9A28948ABA57C52309AC", hash_generated_method = "CA3B7A3CE42EE79B8C25E562058C788B")
    
@Override
    public ByteBuffer putLong(int index, long value) {
        checkIndex(index, SizeOf.LONG);
        this.block.pokeLong(offset + index, value, order);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.933 -0500", hash_original_method = "3ACD25E4A627200A6604DD06DE084CC0", hash_generated_method = "C0A107B071DC1C0CF1025BC04C7E4280")
    
@Override
    public ByteBuffer putShort(short value) {
        int newPosition = position + SizeOf.SHORT;
        if (newPosition > limit) {
            throw new BufferOverflowException();
        }
        this.block.pokeShort(offset + position, value, order);
        position = newPosition;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.936 -0500", hash_original_method = "BC61FE6FEC8007EEA3BC0AA561C1C935", hash_generated_method = "1AB2041539566DBD1509273A3C0F1FDB")
    
@Override
    public ByteBuffer putShort(int index, short value) {
        checkIndex(index, SizeOf.SHORT);
        this.block.pokeShort(offset + index, value, order);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.938 -0500", hash_original_method = "D4755AC954967E40D5DAD107FB36CBC4", hash_generated_method = "D6F998F949C2271D77ABDB3223EF7E65")
    
@Override
    public ByteBuffer slice() {
        return new ReadWriteDirectByteBuffer(block, remaining(), offset + position);
    }

    
}

