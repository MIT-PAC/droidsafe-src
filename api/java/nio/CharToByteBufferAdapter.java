package java.nio;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import libcore.io.SizeOf;





final class CharToByteBufferAdapter extends CharBuffer {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:04.514 -0500", hash_original_method = "55E919F08D15D3984C4AEDF51E3F7B76", hash_generated_method = "F265B11CF4A6BA9EFE4614F4F4C01CB9")
    
static CharBuffer asCharBuffer(ByteBuffer byteBuffer) {
        ByteBuffer slice = byteBuffer.slice();
        slice.order(byteBuffer.order());
        return new CharToByteBufferAdapter(slice);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:04.512 -0500", hash_original_field = "1550DCB87D4D50D3727BEA306C5BDDD3", hash_generated_field = "34B9235D8E87AE2A76AC711395EEC0EB")


    private  ByteBuffer byteBuffer;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:04.517 -0500", hash_original_method = "20CC34DEF3812E72CBA72992E239D17C", hash_generated_method = "80120F0E3C39B69C1C2D92F7FDD2CC43")
    
private CharToByteBufferAdapter(ByteBuffer byteBuffer) {
        super(byteBuffer.capacity() / SizeOf.CHAR);
        this.byteBuffer = byteBuffer;
        this.byteBuffer.clear();
        this.effectiveDirectAddress = byteBuffer.effectiveDirectAddress;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:04.520 -0500", hash_original_method = "38E7AC500E9C1BA37DDE4BE628E69019", hash_generated_method = "571DAB2C65A319AF90F92BA6971A7A07")
    
@Override
    public CharBuffer asReadOnlyBuffer() {
        CharToByteBufferAdapter buf = new CharToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        buf.byteBuffer.order = byteBuffer.order;
        return buf;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:04.522 -0500", hash_original_method = "2B216932B774F9FB3B903B024B1F44DD", hash_generated_method = "F14AAE8FCBE23930C4615524B071B64B")
    
@Override
    public CharBuffer compact() {
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        byteBuffer.limit(limit * SizeOf.CHAR);
        byteBuffer.position(position * SizeOf.CHAR);
        byteBuffer.compact();
        byteBuffer.clear();
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:04.525 -0500", hash_original_method = "D6132370D2375183CB2B2E07203B0DEF", hash_generated_method = "DEC2CB77E80EA3205832F1C1F2C5D8BA")
    
@Override
    public CharBuffer duplicate() {
        ByteBuffer bb = byteBuffer.duplicate().order(byteBuffer.order());
        CharToByteBufferAdapter buf = new CharToByteBufferAdapter(bb);
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        return buf;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:04.528 -0500", hash_original_method = "E3B7C628ECBF1BA157CEBCB59E54138B", hash_generated_method = "FFACC0788C10DF37BEAB726CF2101594")
    
@Override
    public char get() {
        if (position == limit) {
            throw new BufferUnderflowException();
        }
        return byteBuffer.getChar(position++ * SizeOf.CHAR);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:04.530 -0500", hash_original_method = "2E9BB5D57AAEB3C216C710BA88C55EF9", hash_generated_method = "065EFE2C922136B5CAB51E31C8E365A1")
    
@Override
    public char get(int index) {
        checkIndex(index);
        return byteBuffer.getChar(index * SizeOf.CHAR);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:04.533 -0500", hash_original_method = "CD7E402824D81A34C6B45148A4A0EA7C", hash_generated_method = "DA3518F2FF20A01D76B0A31A1C41F0B1")
    
@Override
    public CharBuffer get(char[] dst, int dstOffset, int charCount) {
        byteBuffer.limit(limit * SizeOf.CHAR);
        byteBuffer.position(position * SizeOf.CHAR);
        if (byteBuffer instanceof DirectByteBuffer) {
            ((DirectByteBuffer) byteBuffer).get(dst, dstOffset, charCount);
        } else {
            ((HeapByteBuffer) byteBuffer).get(dst, dstOffset, charCount);
        }
        this.position += charCount;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:04.536 -0500", hash_original_method = "78E98F36E3D964482B56C152BAA7846E", hash_generated_method = "009663403DDC37C5A9CC05093822324F")
    
@Override
    public boolean isDirect() {
        return byteBuffer.isDirect();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:04.538 -0500", hash_original_method = "A5873C4C7FD9475A7CC3E2D0E938541A", hash_generated_method = "C9CF4EA86C1E45319D8243CAB871AD82")
    
@Override
    public boolean isReadOnly() {
        return byteBuffer.isReadOnly();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:04.541 -0500", hash_original_method = "DBC83B570884A1A98A3F46EF314D6E4A", hash_generated_method = "72A628D0C0DB04E7966F3ACE077688CC")
    
@Override
    public ByteOrder order() {
        return byteBuffer.order();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:04.543 -0500", hash_original_method = "5163488AC40767F8F030E728692C8A7E", hash_generated_method = "A5273F2C6BE04EE0F772333FB1D75282")
    
@Override
    protected char[] protectedArray() {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:04.545 -0500", hash_original_method = "11D0A2FFE917F2CC89FA6C9EBE3FCE7F", hash_generated_method = "06D077D8B128869B8EAFBB3C6DF9114F")
    
@Override
    protected int protectedArrayOffset() {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:04.548 -0500", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "4DE1ADBFC1C0BCD2FC8429D8307DD9AC")
    
@Override
    protected boolean protectedHasArray() {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:04.551 -0500", hash_original_method = "A46BC55FC455B05EF747C70552AAC069", hash_generated_method = "61ABEA2ADBAFAAE509189A5135E81F35")
    
@Override
    public CharBuffer put(char c) {
        if (position == limit) {
            throw new BufferOverflowException();
        }
        byteBuffer.putChar(position++ * SizeOf.CHAR, c);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:04.553 -0500", hash_original_method = "3E41BE4D2E49CC352D854BBBF4557ADA", hash_generated_method = "B7F140A54ADA2C555F037218CEC98DBB")
    
@Override
    public CharBuffer put(int index, char c) {
        checkIndex(index);
        byteBuffer.putChar(index * SizeOf.CHAR, c);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:04.556 -0500", hash_original_method = "25F0118CCA8CBA4D22EEA9D027B39A5B", hash_generated_method = "CB93FE1B612B8A613A36157C7308B38A")
    
@Override
    public CharBuffer put(char[] src, int srcOffset, int charCount) {
        byteBuffer.limit(limit * SizeOf.CHAR);
        byteBuffer.position(position * SizeOf.CHAR);
        if (byteBuffer instanceof ReadWriteDirectByteBuffer) {
            ((ReadWriteDirectByteBuffer) byteBuffer).put(src, srcOffset, charCount);
        } else {
            ((ReadWriteHeapByteBuffer) byteBuffer).put(src, srcOffset, charCount);
        }
        this.position += charCount;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:04.558 -0500", hash_original_method = "990BBC721EFE340A5DC5CE5D5661B284", hash_generated_method = "A1FA75FF3A8448C47A2A7DC9DA329BE4")
    
@Override
    public CharBuffer slice() {
        byteBuffer.limit(limit * SizeOf.CHAR);
        byteBuffer.position(position * SizeOf.CHAR);
        ByteBuffer bb = byteBuffer.slice().order(byteBuffer.order());
        CharBuffer result = new CharToByteBufferAdapter(bb);
        byteBuffer.clear();
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:04.561 -0500", hash_original_method = "4B1929E0A98D3F3896D7290A74598BEB", hash_generated_method = "507C558B5C25C4F63DFF63A7E6F61806")
    
@Override
    public CharSequence subSequence(int start, int end) {
        checkStartEndRemaining(start, end);
        CharBuffer result = duplicate();
        result.limit(position + end);
        result.position(position + start);
        return result;
    }

    
}

