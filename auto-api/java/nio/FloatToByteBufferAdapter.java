package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import libcore.io.SizeOf;

final class FloatToByteBufferAdapter extends FloatBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.472 -0400", hash_original_field = "73D79CD15754C8F39826976EB3E77012", hash_generated_field = "34B9235D8E87AE2A76AC711395EEC0EB")

    private ByteBuffer byteBuffer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.472 -0400", hash_original_method = "810EBC63174C0FA8B04ABE1EAC99DA74", hash_generated_method = "FC9D382F68DC054BA01D6ECD3665B29E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.474 -0400", hash_original_method = "3FF4AF57EF2BE2D13954C1B0FC09E489", hash_generated_method = "6AD38C4E40CD33D7A6BDEEC3970C2B64")
    @Override
    public FloatBuffer asReadOnlyBuffer() {
        FloatBuffer varB4EAC82CA7396A68D541C85D26508E83_101669913 = null; //Variable for return #1
        FloatToByteBufferAdapter buf;
        buf = new FloatToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        buf.byteBuffer.order = byteBuffer.order;
        varB4EAC82CA7396A68D541C85D26508E83_101669913 = buf;
        varB4EAC82CA7396A68D541C85D26508E83_101669913.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_101669913;
        // ---------- Original Method ----------
        //FloatToByteBufferAdapter buf = new FloatToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        //buf.limit = limit;
        //buf.position = position;
        //buf.mark = mark;
        //buf.byteBuffer.order = byteBuffer.order;
        //return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.475 -0400", hash_original_method = "FBAC0D7CFE3E15F2BC0CE6753022B0DD", hash_generated_method = "55D56669BCB3159D8694FE58D89BC370")
    @Override
    public FloatBuffer compact() {
        FloatBuffer varB4EAC82CA7396A68D541C85D26508E83_762035865 = null; //Variable for return #1
        {
            boolean varD77B6130B34264A0EF448C4235FCDE48_961120722 = (byteBuffer.isReadOnly());
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
        varB4EAC82CA7396A68D541C85D26508E83_762035865 = this;
        varB4EAC82CA7396A68D541C85D26508E83_762035865.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_762035865;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.574 -0400", hash_original_method = "2336A0F3EA16333D5C7B2B5772DB119B", hash_generated_method = "8FF7D1A23AF6234EE044A52E6962989A")
    @Override
    public FloatBuffer duplicate() {
        FloatBuffer varB4EAC82CA7396A68D541C85D26508E83_1905585908 = null; //Variable for return #1
        ByteBuffer bb;
        bb = byteBuffer.duplicate().order(byteBuffer.order());
        FloatToByteBufferAdapter buf;
        buf = new FloatToByteBufferAdapter(bb);
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        varB4EAC82CA7396A68D541C85D26508E83_1905585908 = buf;
        varB4EAC82CA7396A68D541C85D26508E83_1905585908.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1905585908;
        // ---------- Original Method ----------
        //ByteBuffer bb = byteBuffer.duplicate().order(byteBuffer.order());
        //FloatToByteBufferAdapter buf = new FloatToByteBufferAdapter(bb);
        //buf.limit = limit;
        //buf.position = position;
        //buf.mark = mark;
        //return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.578 -0400", hash_original_method = "B6EAE0A3183D6C7B7623279A287B061F", hash_generated_method = "8F857E510ECA91F835E329366B1822C3")
    @Override
    public float get() {
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } //End block
        float varB42DF50547C1CBA17136619660C28C11_278596832 = (byteBuffer.getFloat(position++ * SizeOf.FLOAT));
        float var546ADE640B6EDFBC8A086EF31347E768_2094115629 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2094115629;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return byteBuffer.getFloat(position++ * SizeOf.FLOAT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.578 -0400", hash_original_method = "230A68E38935998751EB725110E55452", hash_generated_method = "D4F7FAFFAEA2A9EA56DE429CD6316028")
    @Override
    public float get(int index) {
        checkIndex(index);
        float var0D7D6C5512E2A5EF31892DD80FA65589_170814743 = (byteBuffer.getFloat(index * SizeOf.FLOAT));
        addTaint(index);
        float var546ADE640B6EDFBC8A086EF31347E768_1824806869 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1824806869;
        // ---------- Original Method ----------
        //checkIndex(index);
        //return byteBuffer.getFloat(index * SizeOf.FLOAT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.579 -0400", hash_original_method = "D58B2A76A0F3A395BA7B6FFCBE67E2EB", hash_generated_method = "96E431B3B4589DB6317AAC3C3F60DA07")
    @Override
    public FloatBuffer get(float[] dst, int dstOffset, int floatCount) {
        FloatBuffer varB4EAC82CA7396A68D541C85D26508E83_522248007 = null; //Variable for return #1
        byteBuffer.limit(limit * SizeOf.FLOAT);
        byteBuffer.position(position * SizeOf.FLOAT);
        {
            ((DirectByteBuffer) byteBuffer).get(dst, dstOffset, floatCount);
        } //End block
        {
            ((HeapByteBuffer) byteBuffer).get(dst, dstOffset, floatCount);
        } //End block
        this.position += floatCount;
        varB4EAC82CA7396A68D541C85D26508E83_522248007 = this;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(floatCount);
        varB4EAC82CA7396A68D541C85D26508E83_522248007.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_522248007;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.580 -0400", hash_original_method = "78E98F36E3D964482B56C152BAA7846E", hash_generated_method = "7289E0F47C6914A9754EFA450333C785")
    @Override
    public boolean isDirect() {
        boolean var6A38F61B252C327C2F003ABEEAE77D3E_653401364 = (byteBuffer.isDirect());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1546744450 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1546744450;
        // ---------- Original Method ----------
        //return byteBuffer.isDirect();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.581 -0400", hash_original_method = "A5873C4C7FD9475A7CC3E2D0E938541A", hash_generated_method = "451C7F543238AB19AF9F99DBAF19B973")
    @Override
    public boolean isReadOnly() {
        boolean varB84E0A3CE12C63F21B1E15D856C3A969_117895369 = (byteBuffer.isReadOnly());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1006747665 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1006747665;
        // ---------- Original Method ----------
        //return byteBuffer.isReadOnly();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.581 -0400", hash_original_method = "DBC83B570884A1A98A3F46EF314D6E4A", hash_generated_method = "668C96AB67CAD410A5003E9918E11759")
    @Override
    public ByteOrder order() {
        ByteOrder varB4EAC82CA7396A68D541C85D26508E83_170243782 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_170243782 = byteBuffer.order();
        varB4EAC82CA7396A68D541C85D26508E83_170243782.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_170243782;
        // ---------- Original Method ----------
        //return byteBuffer.order();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.583 -0400", hash_original_method = "B84097C1EE35CBEC4451B3A83458D5FB", hash_generated_method = "0C02DD51E2BFD37E3CE9053437DCC963")
    @Override
    protected float[] protectedArray() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        float[] varB2C245003BAB9224CFB496218F7DAFE0_1079037419 = {getTaintFloat()};
        return varB2C245003BAB9224CFB496218F7DAFE0_1079037419;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.591 -0400", hash_original_method = "11D0A2FFE917F2CC89FA6C9EBE3FCE7F", hash_generated_method = "E12166EDECDE629C1C6E0D40E6BE1BE1")
    @Override
    protected int protectedArrayOffset() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1101794060 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1101794060;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.591 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "4A009E640E74652DC681DE41EF495BB3")
    @Override
    protected boolean protectedHasArray() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2077339149 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2077339149;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.591 -0400", hash_original_method = "BFCE73D0BEC9C4C5044FD718D90FCD3E", hash_generated_method = "A5F86E7B9D7E130CFD2CF8928B1DFC9F")
    @Override
    public FloatBuffer put(float c) {
        FloatBuffer varB4EAC82CA7396A68D541C85D26508E83_225092988 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        byteBuffer.putFloat(position++ * SizeOf.FLOAT, c);
        varB4EAC82CA7396A68D541C85D26508E83_225092988 = this;
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_225092988.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_225092988;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //byteBuffer.putFloat(position++ * SizeOf.FLOAT, c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.592 -0400", hash_original_method = "031128B9243B4CE1487F7A32DBB76678", hash_generated_method = "EB3B8F23BDDACB7EF0572B45A197ED76")
    @Override
    public FloatBuffer put(int index, float c) {
        FloatBuffer varB4EAC82CA7396A68D541C85D26508E83_1762767657 = null; //Variable for return #1
        checkIndex(index);
        byteBuffer.putFloat(index * SizeOf.FLOAT, c);
        varB4EAC82CA7396A68D541C85D26508E83_1762767657 = this;
        addTaint(index);
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_1762767657.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1762767657;
        // ---------- Original Method ----------
        //checkIndex(index);
        //byteBuffer.putFloat(index * SizeOf.FLOAT, c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.592 -0400", hash_original_method = "3BDFA2137C718F8287015587FF612D27", hash_generated_method = "4F8BBDD2A3C7AC2A60599930CDD7F81A")
    @Override
    public FloatBuffer put(float[] src, int srcOffset, int floatCount) {
        FloatBuffer varB4EAC82CA7396A68D541C85D26508E83_949128733 = null; //Variable for return #1
        byteBuffer.limit(limit * SizeOf.FLOAT);
        byteBuffer.position(position * SizeOf.FLOAT);
        {
            ((ReadWriteDirectByteBuffer) byteBuffer).put(src, srcOffset, floatCount);
        } //End block
        {
            ((ReadWriteHeapByteBuffer) byteBuffer).put(src, srcOffset, floatCount);
        } //End block
        this.position += floatCount;
        varB4EAC82CA7396A68D541C85D26508E83_949128733 = this;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(floatCount);
        varB4EAC82CA7396A68D541C85D26508E83_949128733.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_949128733;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.593 -0400", hash_original_method = "72D0D38C2A2E773EAB91888933B787B4", hash_generated_method = "996AB7C43D3FF67ADECB521245830CD7")
    @Override
    public FloatBuffer slice() {
        FloatBuffer varB4EAC82CA7396A68D541C85D26508E83_351707519 = null; //Variable for return #1
        byteBuffer.limit(limit * SizeOf.FLOAT);
        byteBuffer.position(position * SizeOf.FLOAT);
        ByteBuffer bb;
        bb = byteBuffer.slice().order(byteBuffer.order());
        FloatBuffer result;
        result = new FloatToByteBufferAdapter(bb);
        byteBuffer.clear();
        varB4EAC82CA7396A68D541C85D26508E83_351707519 = result;
        varB4EAC82CA7396A68D541C85D26508E83_351707519.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_351707519;
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.FLOAT);
        //byteBuffer.position(position * SizeOf.FLOAT);
        //ByteBuffer bb = byteBuffer.slice().order(byteBuffer.order());
        //FloatBuffer result = new FloatToByteBufferAdapter(bb);
        //byteBuffer.clear();
        //return result;
    }

    
}

