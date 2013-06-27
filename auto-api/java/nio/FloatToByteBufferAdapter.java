package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import libcore.io.SizeOf;

final class FloatToByteBufferAdapter extends FloatBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.489 -0400", hash_original_field = "73D79CD15754C8F39826976EB3E77012", hash_generated_field = "34B9235D8E87AE2A76AC711395EEC0EB")

    private ByteBuffer byteBuffer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.489 -0400", hash_original_method = "810EBC63174C0FA8B04ABE1EAC99DA74", hash_generated_method = "FC9D382F68DC054BA01D6ECD3665B29E")
      FloatToByteBufferAdapter(ByteBuffer byteBuffer) {
        super(byteBuffer.capacity() / SizeOf.FLOAT);
        this.byteBuffer = byteBuffer;
        this.byteBuffer.clear();
        this.effectiveDirectAddress = byteBuffer.effectiveDirectAddress;
        // ---------- Original Method ----------
        //this.byteBuffer = byteBuffer;
        //this.byteBuffer.clear();
        //this.effectiveDirectAddress = byteBuffer.effectiveDirectAddress;
    }

    
        static FloatBuffer asFloatBuffer(ByteBuffer byteBuffer) {
        ByteBuffer slice = byteBuffer.slice();
        slice.order(byteBuffer.order());
        return new FloatToByteBufferAdapter(slice);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.494 -0400", hash_original_method = "3FF4AF57EF2BE2D13954C1B0FC09E489", hash_generated_method = "F8772E4898BD5E375531FEE8B25AAFA8")
    @Override
    public FloatBuffer asReadOnlyBuffer() {
        FloatBuffer varB4EAC82CA7396A68D541C85D26508E83_845482709 = null; //Variable for return #1
        FloatToByteBufferAdapter buf;
        buf = new FloatToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        buf.byteBuffer.order = byteBuffer.order;
        varB4EAC82CA7396A68D541C85D26508E83_845482709 = buf;
        varB4EAC82CA7396A68D541C85D26508E83_845482709.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_845482709;
        // ---------- Original Method ----------
        //FloatToByteBufferAdapter buf = new FloatToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        //buf.limit = limit;
        //buf.position = position;
        //buf.mark = mark;
        //buf.byteBuffer.order = byteBuffer.order;
        //return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.495 -0400", hash_original_method = "FBAC0D7CFE3E15F2BC0CE6753022B0DD", hash_generated_method = "AE1F536D3BF70779906FC69A8EFD5693")
    @Override
    public FloatBuffer compact() {
        FloatBuffer varB4EAC82CA7396A68D541C85D26508E83_1821493617 = null; //Variable for return #1
        {
            boolean varD77B6130B34264A0EF448C4235FCDE48_1485818981 = (byteBuffer.isReadOnly());
            {
                if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
            } //End block
        } //End collapsed parenthetic
        byteBuffer.limit(limit * SizeOf.FLOAT);
        byteBuffer.position(position * SizeOf.FLOAT);
        byteBuffer.compact();
        byteBuffer.clear();
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        varB4EAC82CA7396A68D541C85D26508E83_1821493617 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1821493617.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1821493617;
        // ---------- Original Method ----------
        //if (byteBuffer.isReadOnly()) {
            //throw new ReadOnlyBufferException();
        //}
        //byteBuffer.limit(limit * SizeOf.FLOAT);
        //byteBuffer.position(position * SizeOf.FLOAT);
        //byteBuffer.compact();
        //byteBuffer.clear();
        //position = limit - position;
        //limit = capacity;
        //mark = UNSET_MARK;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.498 -0400", hash_original_method = "2336A0F3EA16333D5C7B2B5772DB119B", hash_generated_method = "FD7BD23BD90ADFFB8E7148F5FAF97845")
    @Override
    public FloatBuffer duplicate() {
        FloatBuffer varB4EAC82CA7396A68D541C85D26508E83_1448823921 = null; //Variable for return #1
        ByteBuffer bb;
        bb = byteBuffer.duplicate().order(byteBuffer.order());
        FloatToByteBufferAdapter buf;
        buf = new FloatToByteBufferAdapter(bb);
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        varB4EAC82CA7396A68D541C85D26508E83_1448823921 = buf;
        varB4EAC82CA7396A68D541C85D26508E83_1448823921.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1448823921;
        // ---------- Original Method ----------
        //ByteBuffer bb = byteBuffer.duplicate().order(byteBuffer.order());
        //FloatToByteBufferAdapter buf = new FloatToByteBufferAdapter(bb);
        //buf.limit = limit;
        //buf.position = position;
        //buf.mark = mark;
        //return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.519 -0400", hash_original_method = "B6EAE0A3183D6C7B7623279A287B061F", hash_generated_method = "254BB45CB288D235043AB1D68890BC4E")
    @Override
    public float get() {
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } //End block
        float varB42DF50547C1CBA17136619660C28C11_1306189171 = (byteBuffer.getFloat(position++ * SizeOf.FLOAT));
        float var546ADE640B6EDFBC8A086EF31347E768_212628271 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_212628271;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return byteBuffer.getFloat(position++ * SizeOf.FLOAT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.519 -0400", hash_original_method = "230A68E38935998751EB725110E55452", hash_generated_method = "F7BF605920D9053F802DD58752C9A6D1")
    @Override
    public float get(int index) {
        checkIndex(index);
        float var0D7D6C5512E2A5EF31892DD80FA65589_554427266 = (byteBuffer.getFloat(index * SizeOf.FLOAT));
        addTaint(index);
        float var546ADE640B6EDFBC8A086EF31347E768_1194350901 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1194350901;
        // ---------- Original Method ----------
        //checkIndex(index);
        //return byteBuffer.getFloat(index * SizeOf.FLOAT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.521 -0400", hash_original_method = "D58B2A76A0F3A395BA7B6FFCBE67E2EB", hash_generated_method = "5266A77450C026E222CC437E1757999E")
    @Override
    public FloatBuffer get(float[] dst, int dstOffset, int floatCount) {
        FloatBuffer varB4EAC82CA7396A68D541C85D26508E83_1176506426 = null; //Variable for return #1
        byteBuffer.limit(limit * SizeOf.FLOAT);
        byteBuffer.position(position * SizeOf.FLOAT);
        {
            ((DirectByteBuffer) byteBuffer).get(dst, dstOffset, floatCount);
        } //End block
        {
            ((HeapByteBuffer) byteBuffer).get(dst, dstOffset, floatCount);
        } //End block
        this.position += floatCount;
        varB4EAC82CA7396A68D541C85D26508E83_1176506426 = this;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(floatCount);
        varB4EAC82CA7396A68D541C85D26508E83_1176506426.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1176506426;
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.FLOAT);
        //byteBuffer.position(position * SizeOf.FLOAT);
        //if (byteBuffer instanceof DirectByteBuffer) {
            //((DirectByteBuffer) byteBuffer).get(dst, dstOffset, floatCount);
        //} else {
            //((HeapByteBuffer) byteBuffer).get(dst, dstOffset, floatCount);
        //}
        //this.position += floatCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.521 -0400", hash_original_method = "78E98F36E3D964482B56C152BAA7846E", hash_generated_method = "45EAA521B59FBCB1B5FFCFF8FA95392E")
    @Override
    public boolean isDirect() {
        boolean var6A38F61B252C327C2F003ABEEAE77D3E_385974436 = (byteBuffer.isDirect());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_719594638 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_719594638;
        // ---------- Original Method ----------
        //return byteBuffer.isDirect();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.525 -0400", hash_original_method = "A5873C4C7FD9475A7CC3E2D0E938541A", hash_generated_method = "B12135DF5A2DA4342AC4DCE7C0F67E87")
    @Override
    public boolean isReadOnly() {
        boolean varB84E0A3CE12C63F21B1E15D856C3A969_739321134 = (byteBuffer.isReadOnly());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1187486668 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1187486668;
        // ---------- Original Method ----------
        //return byteBuffer.isReadOnly();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.525 -0400", hash_original_method = "DBC83B570884A1A98A3F46EF314D6E4A", hash_generated_method = "8F915DE81B6EC7C3A788A7C49947F7CB")
    @Override
    public ByteOrder order() {
        ByteOrder varB4EAC82CA7396A68D541C85D26508E83_883486331 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_883486331 = byteBuffer.order();
        varB4EAC82CA7396A68D541C85D26508E83_883486331.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_883486331;
        // ---------- Original Method ----------
        //return byteBuffer.order();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.528 -0400", hash_original_method = "B84097C1EE35CBEC4451B3A83458D5FB", hash_generated_method = "60D8976D3A28E69DA95F9013B5193C53")
    @Override
    protected float[] protectedArray() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        float[] varB2C245003BAB9224CFB496218F7DAFE0_2116212799 = {getTaintFloat()};
        return varB2C245003BAB9224CFB496218F7DAFE0_2116212799;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.528 -0400", hash_original_method = "11D0A2FFE917F2CC89FA6C9EBE3FCE7F", hash_generated_method = "D7A2E945C8BC5C3C9F1F08815B40FE4C")
    @Override
    protected int protectedArrayOffset() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1828736885 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1828736885;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.548 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "322F806F96CF7CECA32BC9100745FE39")
    @Override
    protected boolean protectedHasArray() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1890649642 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1890649642;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.549 -0400", hash_original_method = "BFCE73D0BEC9C4C5044FD718D90FCD3E", hash_generated_method = "C992B5772767FA609C627FE959351D2B")
    @Override
    public FloatBuffer put(float c) {
        FloatBuffer varB4EAC82CA7396A68D541C85D26508E83_539629665 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        byteBuffer.putFloat(position++ * SizeOf.FLOAT, c);
        varB4EAC82CA7396A68D541C85D26508E83_539629665 = this;
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_539629665.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_539629665;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //byteBuffer.putFloat(position++ * SizeOf.FLOAT, c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.550 -0400", hash_original_method = "031128B9243B4CE1487F7A32DBB76678", hash_generated_method = "DFD42CB7907B65745EB63019EB443CC9")
    @Override
    public FloatBuffer put(int index, float c) {
        FloatBuffer varB4EAC82CA7396A68D541C85D26508E83_1678192834 = null; //Variable for return #1
        checkIndex(index);
        byteBuffer.putFloat(index * SizeOf.FLOAT, c);
        varB4EAC82CA7396A68D541C85D26508E83_1678192834 = this;
        addTaint(index);
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_1678192834.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1678192834;
        // ---------- Original Method ----------
        //checkIndex(index);
        //byteBuffer.putFloat(index * SizeOf.FLOAT, c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.550 -0400", hash_original_method = "3BDFA2137C718F8287015587FF612D27", hash_generated_method = "F3E9F0B3FB7AA4DD8A498929A8BB436A")
    @Override
    public FloatBuffer put(float[] src, int srcOffset, int floatCount) {
        FloatBuffer varB4EAC82CA7396A68D541C85D26508E83_2076744812 = null; //Variable for return #1
        byteBuffer.limit(limit * SizeOf.FLOAT);
        byteBuffer.position(position * SizeOf.FLOAT);
        {
            ((ReadWriteDirectByteBuffer) byteBuffer).put(src, srcOffset, floatCount);
        } //End block
        {
            ((ReadWriteHeapByteBuffer) byteBuffer).put(src, srcOffset, floatCount);
        } //End block
        this.position += floatCount;
        varB4EAC82CA7396A68D541C85D26508E83_2076744812 = this;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(floatCount);
        varB4EAC82CA7396A68D541C85D26508E83_2076744812.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2076744812;
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.FLOAT);
        //byteBuffer.position(position * SizeOf.FLOAT);
        //if (byteBuffer instanceof ReadWriteDirectByteBuffer) {
            //((ReadWriteDirectByteBuffer) byteBuffer).put(src, srcOffset, floatCount);
        //} else {
            //((ReadWriteHeapByteBuffer) byteBuffer).put(src, srcOffset, floatCount);
        //}
        //this.position += floatCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.584 -0400", hash_original_method = "72D0D38C2A2E773EAB91888933B787B4", hash_generated_method = "140A1477E178FEA2F6986764BAFEF3D9")
    @Override
    public FloatBuffer slice() {
        FloatBuffer varB4EAC82CA7396A68D541C85D26508E83_908561207 = null; //Variable for return #1
        byteBuffer.limit(limit * SizeOf.FLOAT);
        byteBuffer.position(position * SizeOf.FLOAT);
        ByteBuffer bb;
        bb = byteBuffer.slice().order(byteBuffer.order());
        FloatBuffer result;
        result = new FloatToByteBufferAdapter(bb);
        byteBuffer.clear();
        varB4EAC82CA7396A68D541C85D26508E83_908561207 = result;
        varB4EAC82CA7396A68D541C85D26508E83_908561207.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_908561207;
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.FLOAT);
        //byteBuffer.position(position * SizeOf.FLOAT);
        //ByteBuffer bb = byteBuffer.slice().order(byteBuffer.order());
        //FloatBuffer result = new FloatToByteBufferAdapter(bb);
        //byteBuffer.clear();
        //return result;
    }

    
}

