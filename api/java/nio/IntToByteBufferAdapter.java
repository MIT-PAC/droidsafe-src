package java.nio;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import libcore.io.SizeOf;





final class IntToByteBufferAdapter extends IntBuffer {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.959 -0500", hash_original_method = "C26DFF1CB2F90F920ECE6C3095E8A671", hash_generated_method = "C4015C0AB13DA38B2DCE397C7B94B6F4")
    static IntBuffer asIntBuffer(ByteBuffer byteBuffer) {
        ByteBuffer slice = byteBuffer.slice();
        slice.order(byteBuffer.order());
        return new IntToByteBufferAdapter(slice);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.959 -0500", hash_original_field = "1550DCB87D4D50D3727BEA306C5BDDD3", hash_generated_field = "34B9235D8E87AE2A76AC711395EEC0EB")


    private  ByteBuffer byteBuffer;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.960 -0500", hash_original_method = "0E7C7C86CACD977D9C0D85465EADD9B5", hash_generated_method = "33220E3DF6D519ECC595690D0474A72B")
    private IntToByteBufferAdapter(ByteBuffer byteBuffer) {
        super(byteBuffer.capacity() / SizeOf.INT);
        this.byteBuffer = byteBuffer;
        this.byteBuffer.clear();
        this.effectiveDirectAddress = byteBuffer.effectiveDirectAddress;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.961 -0500", hash_original_method = "3B6C20C87137502BB674F780046CDA86", hash_generated_method = "772B31A8B50B6D1CF090BC015CE1E898")
    @Override
public IntBuffer asReadOnlyBuffer() {
        IntToByteBufferAdapter buf = new IntToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        buf.byteBuffer.order = byteBuffer.order;
        return buf;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.962 -0500", hash_original_method = "D18BA662CC63D97B7B456C28811B5740", hash_generated_method = "E6800CE86F80DE4B147D4D5EE05688CA")
    @Override
public IntBuffer compact() {
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        byteBuffer.limit(limit * SizeOf.INT);
        byteBuffer.position(position * SizeOf.INT);
        byteBuffer.compact();
        byteBuffer.clear();
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.963 -0500", hash_original_method = "E4BE94C048430920FB1F32A36A3DD508", hash_generated_method = "F83DD26DF062BEE2F4F521EC8A8E039B")
    @Override
public IntBuffer duplicate() {
        ByteBuffer bb = byteBuffer.duplicate().order(byteBuffer.order());
        IntToByteBufferAdapter buf = new IntToByteBufferAdapter(bb);
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        return buf;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.964 -0500", hash_original_method = "B6C265DA3B3DAD372E7C00DDFF580FE2", hash_generated_method = "3F444A582DADF506D3312AFFF54778C4")
    @Override
public int get() {
        if (position == limit) {
            throw new BufferUnderflowException();
        }
        return byteBuffer.getInt(position++ * SizeOf.INT);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.965 -0500", hash_original_method = "A308FF9E693AF460AC240055AB8B4E4F", hash_generated_method = "D93315D6A544398E7593D6C51BC41302")
    @Override
public int get(int index) {
        checkIndex(index);
        return byteBuffer.getInt(index * SizeOf.INT);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.966 -0500", hash_original_method = "C677A64CEDCCE4923055860B8C2E3944", hash_generated_method = "2C813DE2BA703BFACA19F862415C9419")
    @Override
public IntBuffer get(int[] dst, int dstOffset, int intCount) {
        byteBuffer.limit(limit * SizeOf.INT);
        byteBuffer.position(position * SizeOf.INT);
        if (byteBuffer instanceof DirectByteBuffer) {
            ((DirectByteBuffer) byteBuffer).get(dst, dstOffset, intCount);
        } else {
            ((HeapByteBuffer) byteBuffer).get(dst, dstOffset, intCount);
        }
        this.position += intCount;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.967 -0500", hash_original_method = "78E98F36E3D964482B56C152BAA7846E", hash_generated_method = "009663403DDC37C5A9CC05093822324F")
    @Override
public boolean isDirect() {
        return byteBuffer.isDirect();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.968 -0500", hash_original_method = "A5873C4C7FD9475A7CC3E2D0E938541A", hash_generated_method = "C9CF4EA86C1E45319D8243CAB871AD82")
    @Override
public boolean isReadOnly() {
        return byteBuffer.isReadOnly();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.969 -0500", hash_original_method = "DBC83B570884A1A98A3F46EF314D6E4A", hash_generated_method = "72A628D0C0DB04E7966F3ACE077688CC")
    @Override
public ByteOrder order() {
        return byteBuffer.order();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.970 -0500", hash_original_method = "B5E68F6CE1B6AAF4D730BB4F773E288A", hash_generated_method = "FA68B37D2799CF1DD1A94B7D28409544")
    @Override
protected int[] protectedArray() {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.971 -0500", hash_original_method = "11D0A2FFE917F2CC89FA6C9EBE3FCE7F", hash_generated_method = "06D077D8B128869B8EAFBB3C6DF9114F")
    @Override
protected int protectedArrayOffset() {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.972 -0500", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "4DE1ADBFC1C0BCD2FC8429D8307DD9AC")
    @Override
protected boolean protectedHasArray() {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.973 -0500", hash_original_method = "3F86EA2C1F796EC91605CF34A16A44E5", hash_generated_method = "F52CC257E42DD231D1D53FCD304AA380")
    @Override
public IntBuffer put(int c) {
        if (position == limit) {
            throw new BufferOverflowException();
        }
        byteBuffer.putInt(position++ * SizeOf.INT, c);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.974 -0500", hash_original_method = "3231AAB5D18FCEA9F424FA8559AECE08", hash_generated_method = "8B1C17B0CC0DCFCD5A4FFC8A44361AF3")
    @Override
public IntBuffer put(int index, int c) {
        checkIndex(index);
        byteBuffer.putInt(index * SizeOf.INT, c);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.975 -0500", hash_original_method = "DC03F153D09213907F9D5CD0A27C6001", hash_generated_method = "57EDD4028952E1175784D5B5DE4995C1")
    @Override
public IntBuffer put(int[] src, int srcOffset, int intCount) {
        byteBuffer.limit(limit * SizeOf.INT);
        byteBuffer.position(position * SizeOf.INT);
        if (byteBuffer instanceof ReadWriteDirectByteBuffer) {
            ((ReadWriteDirectByteBuffer) byteBuffer).put(src, srcOffset, intCount);
        } else {
            ((ReadWriteHeapByteBuffer) byteBuffer).put(src, srcOffset, intCount);
        }
        this.position += intCount;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:39.976 -0500", hash_original_method = "9FAC3500FD67AB6DCB59E60DAE965917", hash_generated_method = "799FBDB6FDF541DE96EA42877F265B72")
    @Override
public IntBuffer slice() {
        byteBuffer.limit(limit * SizeOf.INT);
        byteBuffer.position(position * SizeOf.INT);
        ByteBuffer bb = byteBuffer.slice().order(byteBuffer.order());
        IntBuffer result = new IntToByteBufferAdapter(bb);
        byteBuffer.clear();
        return result;
    }

    
}

