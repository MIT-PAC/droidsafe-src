package java.nio;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import libcore.io.SizeOf;

final class LongToByteBufferAdapter extends LongBuffer {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.176 -0500", hash_original_method = "D932C9FB81190BBA2222EE830AEAF465", hash_generated_method = "9C539DAB3D1A86AFAC4F6478C3DB9947")
    
static LongBuffer asLongBuffer(ByteBuffer byteBuffer) {
        ByteBuffer slice = byteBuffer.slice();
        slice.order(byteBuffer.order());
        return new LongToByteBufferAdapter(slice);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.174 -0500", hash_original_field = "1550DCB87D4D50D3727BEA306C5BDDD3", hash_generated_field = "34B9235D8E87AE2A76AC711395EEC0EB")

    private  ByteBuffer byteBuffer;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.179 -0500", hash_original_method = "7BE681F333C6F648B89AD219E60BA2F8", hash_generated_method = "51E21B349A7901D675DAD719F52322E6")
    
private LongToByteBufferAdapter(ByteBuffer byteBuffer) {
        super(byteBuffer.capacity() / SizeOf.LONG);
        this.byteBuffer = byteBuffer;
        this.byteBuffer.clear();
        this.effectiveDirectAddress = byteBuffer.effectiveDirectAddress;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.182 -0500", hash_original_method = "D050B63E2506664B1FB8FA5AF2DF1745", hash_generated_method = "705206E4F637B91E6C785AA60097F28B")
    
@Override
    public LongBuffer asReadOnlyBuffer() {
        LongToByteBufferAdapter buf = new LongToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        buf.byteBuffer.order = byteBuffer.order;
        return buf;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.184 -0500", hash_original_method = "B90A69906FF2A7DF6CFB9034F84C98E2", hash_generated_method = "63C408C126C668925623E4C1E8309E6D")
    
@Override
    public LongBuffer compact() {
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        byteBuffer.limit(limit * SizeOf.LONG);
        byteBuffer.position(position * SizeOf.LONG);
        byteBuffer.compact();
        byteBuffer.clear();
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.187 -0500", hash_original_method = "43AC1DE0A2813C7EA603135E834FD979", hash_generated_method = "6A62301095E26F405F94DC2537F110D0")
    
@Override
    public LongBuffer duplicate() {
        ByteBuffer bb = byteBuffer.duplicate().order(byteBuffer.order());
        LongToByteBufferAdapter buf = new LongToByteBufferAdapter(bb);
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        return buf;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.189 -0500", hash_original_method = "69EF1CD1610BDC80B0B9220CD61D963E", hash_generated_method = "1A6C85E8B2D9B3E9D8C30278622528AB")
    
@Override
    public long get() {
        if (position == limit) {
            throw new BufferUnderflowException();
        }
        return byteBuffer.getLong(position++ * SizeOf.LONG);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.191 -0500", hash_original_method = "89069B89A0801CA51434AC3AB566C55F", hash_generated_method = "250BBE1E5E22CFC51F5177704F4D4D93")
    
@Override
    public long get(int index) {
        checkIndex(index);
        return byteBuffer.getLong(index * SizeOf.LONG);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.194 -0500", hash_original_method = "D4236D431748AB12467DF84CDEDC66D3", hash_generated_method = "4DEBEE53EF73F941F2EB7887187B4F3E")
    
@Override
    public LongBuffer get(long[] dst, int dstOffset, int longCount) {
        byteBuffer.limit(limit * SizeOf.LONG);
        byteBuffer.position(position * SizeOf.LONG);
        if (byteBuffer instanceof DirectByteBuffer) {
            ((DirectByteBuffer) byteBuffer).get(dst, dstOffset, longCount);
        } else {
            ((HeapByteBuffer) byteBuffer).get(dst, dstOffset, longCount);
        }
        this.position += longCount;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.198 -0500", hash_original_method = "78E98F36E3D964482B56C152BAA7846E", hash_generated_method = "009663403DDC37C5A9CC05093822324F")
    
@Override
    public boolean isDirect() {
        return byteBuffer.isDirect();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.200 -0500", hash_original_method = "A5873C4C7FD9475A7CC3E2D0E938541A", hash_generated_method = "C9CF4EA86C1E45319D8243CAB871AD82")
    
@Override
    public boolean isReadOnly() {
        return byteBuffer.isReadOnly();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.202 -0500", hash_original_method = "DBC83B570884A1A98A3F46EF314D6E4A", hash_generated_method = "72A628D0C0DB04E7966F3ACE077688CC")
    
@Override
    public ByteOrder order() {
        return byteBuffer.order();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.205 -0500", hash_original_method = "BB4072AD98AEBDD15F1C2BE658CD1C60", hash_generated_method = "1FAAD8948A039FFB37C6AB0EE435C3E8")
    
@Override
    protected long[] protectedArray() {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.207 -0500", hash_original_method = "11D0A2FFE917F2CC89FA6C9EBE3FCE7F", hash_generated_method = "06D077D8B128869B8EAFBB3C6DF9114F")
    
@Override
    protected int protectedArrayOffset() {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.210 -0500", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "4DE1ADBFC1C0BCD2FC8429D8307DD9AC")
    
@Override
    protected boolean protectedHasArray() {
        return false;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.212 -0500", hash_original_method = "87F5FD3E4F89C8080D5C7CCD57D2DD50", hash_generated_method = "791FAA1EB501CB85267F780D792086C2")
    
@Override
    public LongBuffer put(long c) {
        if (position == limit) {
            throw new BufferOverflowException();
        }
        byteBuffer.putLong(position++ * SizeOf.LONG, c);
        return this;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.214 -0500", hash_original_method = "CF44390369F77E5D846E6D2329A6B3BC", hash_generated_method = "E2131AD4E5C9E469729672ECCFFA08DE")
    
@Override
    public LongBuffer put(int index, long c) {
        checkIndex(index);
        byteBuffer.putLong(index * SizeOf.LONG, c);
        return this;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.217 -0500", hash_original_method = "95A4CBB7FC306D23EF877E74124EDB15", hash_generated_method = "112CA108D904D1D1E5F8A43C2EE5F21E")
    
@Override
    public LongBuffer put(long[] src, int srcOffset, int longCount) {
        byteBuffer.limit(limit * SizeOf.LONG);
        byteBuffer.position(position * SizeOf.LONG);
        if (byteBuffer instanceof ReadWriteDirectByteBuffer) {
            ((ReadWriteDirectByteBuffer) byteBuffer).put(src, srcOffset, longCount);
        } else {
            ((ReadWriteHeapByteBuffer) byteBuffer).put(src, srcOffset, longCount);
        }
        this.position += longCount;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.220 -0500", hash_original_method = "456A8EB98AABFAF4E458EC4948195D08", hash_generated_method = "C92E6D28CB0AAA10B6AC9441869F7885")
    
@Override
    public LongBuffer slice() {
        byteBuffer.limit(limit * SizeOf.LONG);
        byteBuffer.position(position * SizeOf.LONG);
        ByteBuffer bb = byteBuffer.slice().order(byteBuffer.order());
        LongBuffer result = new LongToByteBufferAdapter(bb);
        byteBuffer.clear();
        return result;
    }
    
}

