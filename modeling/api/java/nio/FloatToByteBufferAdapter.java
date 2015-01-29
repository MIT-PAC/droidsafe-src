package java.nio;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import libcore.io.SizeOf;

final class FloatToByteBufferAdapter extends FloatBuffer {

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.889 -0500", hash_original_method = "4E320B5A4FC28FA956032ED554AE256C", hash_generated_method = "1C7AD486528B62D4E17062BD36B4E068")
    
static FloatBuffer asFloatBuffer(ByteBuffer byteBuffer) {
        ByteBuffer slice = byteBuffer.slice();
        slice.order(byteBuffer.order());
        return new FloatToByteBufferAdapter(slice);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.887 -0500", hash_original_field = "1550DCB87D4D50D3727BEA306C5BDDD3", hash_generated_field = "34B9235D8E87AE2A76AC711395EEC0EB")

    private  ByteBuffer byteBuffer;

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.891 -0500", hash_original_method = "810EBC63174C0FA8B04ABE1EAC99DA74", hash_generated_method = "810EBC63174C0FA8B04ABE1EAC99DA74")
    
FloatToByteBufferAdapter(ByteBuffer byteBuffer) {
        super(byteBuffer.capacity() / SizeOf.FLOAT);
        this.byteBuffer = byteBuffer;
        this.byteBuffer.clear();
        this.effectiveDirectAddress = byteBuffer.effectiveDirectAddress;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.894 -0500", hash_original_method = "3FF4AF57EF2BE2D13954C1B0FC09E489", hash_generated_method = "CE5DCA3690F2C99954CAD93962D6140B")
    
@Override
    public FloatBuffer asReadOnlyBuffer() {
        FloatToByteBufferAdapter buf = new FloatToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        buf.byteBuffer.order = byteBuffer.order;
        return buf;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.896 -0500", hash_original_method = "FBAC0D7CFE3E15F2BC0CE6753022B0DD", hash_generated_method = "F3CB90BBDF8F8CC1B934FF863C57D767")
    
@Override
    public FloatBuffer compact() {
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        byteBuffer.limit(limit * SizeOf.FLOAT);
        byteBuffer.position(position * SizeOf.FLOAT);
        byteBuffer.compact();
        byteBuffer.clear();
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.899 -0500", hash_original_method = "2336A0F3EA16333D5C7B2B5772DB119B", hash_generated_method = "CFAC250F407CAAF86C2FCB85C66A3451")
    
@Override
    public FloatBuffer duplicate() {
        ByteBuffer bb = byteBuffer.duplicate().order(byteBuffer.order());
        FloatToByteBufferAdapter buf = new FloatToByteBufferAdapter(bb);
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        return buf;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.902 -0500", hash_original_method = "B6EAE0A3183D6C7B7623279A287B061F", hash_generated_method = "9D2FD73857D890BFAC382C4D06A93804")
    
@Override
    public float get() {
        if (position == limit) {
            throw new BufferUnderflowException();
        }
        return byteBuffer.getFloat(position++ * SizeOf.FLOAT);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.904 -0500", hash_original_method = "230A68E38935998751EB725110E55452", hash_generated_method = "333291051F34D4C7C1B5D195EFC89B01")
    
@Override
    public float get(int index) {
        checkIndex(index);
        return byteBuffer.getFloat(index * SizeOf.FLOAT);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.907 -0500", hash_original_method = "D58B2A76A0F3A395BA7B6FFCBE67E2EB", hash_generated_method = "55F12A5DA4AFD2330046AB16635CDBA9")
    
@Override
    public FloatBuffer get(float[] dst, int dstOffset, int floatCount) {
        byteBuffer.limit(limit * SizeOf.FLOAT);
        byteBuffer.position(position * SizeOf.FLOAT);
        if (byteBuffer instanceof DirectByteBuffer) {
            ((DirectByteBuffer) byteBuffer).get(dst, dstOffset, floatCount);
        } else {
            ((HeapByteBuffer) byteBuffer).get(dst, dstOffset, floatCount);
        }
        this.position += floatCount;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.909 -0500", hash_original_method = "78E98F36E3D964482B56C152BAA7846E", hash_generated_method = "009663403DDC37C5A9CC05093822324F")
    
@Override
    public boolean isDirect() {
        return byteBuffer.isDirect();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.912 -0500", hash_original_method = "A5873C4C7FD9475A7CC3E2D0E938541A", hash_generated_method = "C9CF4EA86C1E45319D8243CAB871AD82")
    
@Override
    public boolean isReadOnly() {
        return byteBuffer.isReadOnly();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.915 -0500", hash_original_method = "DBC83B570884A1A98A3F46EF314D6E4A", hash_generated_method = "72A628D0C0DB04E7966F3ACE077688CC")
    
@Override
    public ByteOrder order() {
        return byteBuffer.order();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.917 -0500", hash_original_method = "B84097C1EE35CBEC4451B3A83458D5FB", hash_generated_method = "24243B43DA12FBEE7FB1ED54B339E4A3")
    
@Override
    protected float[] protectedArray() {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.920 -0500", hash_original_method = "11D0A2FFE917F2CC89FA6C9EBE3FCE7F", hash_generated_method = "06D077D8B128869B8EAFBB3C6DF9114F")
    
@Override
    protected int protectedArrayOffset() {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.922 -0500", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "4DE1ADBFC1C0BCD2FC8429D8307DD9AC")
    
@Override
    protected boolean protectedHasArray() {
        return false;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.925 -0500", hash_original_method = "BFCE73D0BEC9C4C5044FD718D90FCD3E", hash_generated_method = "2C22A5CECD7A431F9A6C682E7EED3514")
    
@Override
    public FloatBuffer put(float c) {
        if (position == limit) {
            throw new BufferOverflowException();
        }
        byteBuffer.putFloat(position++ * SizeOf.FLOAT, c);
        return this;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.927 -0500", hash_original_method = "031128B9243B4CE1487F7A32DBB76678", hash_generated_method = "415AE599113D8030A5477E6609FDA17C")
    
@Override
    public FloatBuffer put(int index, float c) {
        checkIndex(index);
        byteBuffer.putFloat(index * SizeOf.FLOAT, c);
        return this;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.930 -0500", hash_original_method = "3BDFA2137C718F8287015587FF612D27", hash_generated_method = "1634EED238CF0274F5688F2EA179E5E4")
    
@Override
    public FloatBuffer put(float[] src, int srcOffset, int floatCount) {
        byteBuffer.limit(limit * SizeOf.FLOAT);
        byteBuffer.position(position * SizeOf.FLOAT);
        if (byteBuffer instanceof ReadWriteDirectByteBuffer) {
            ((ReadWriteDirectByteBuffer) byteBuffer).put(src, srcOffset, floatCount);
        } else {
            ((ReadWriteHeapByteBuffer) byteBuffer).put(src, srcOffset, floatCount);
        }
        this.position += floatCount;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:05.933 -0500", hash_original_method = "72D0D38C2A2E773EAB91888933B787B4", hash_generated_method = "5E88D47DB5C59A91DE48C6378AAF16C7")
    
@Override
    public FloatBuffer slice() {
        byteBuffer.limit(limit * SizeOf.FLOAT);
        byteBuffer.position(position * SizeOf.FLOAT);
        ByteBuffer bb = byteBuffer.slice().order(byteBuffer.order());
        FloatBuffer result = new FloatToByteBufferAdapter(bb);
        byteBuffer.clear();
        return result;
    }
    
}

