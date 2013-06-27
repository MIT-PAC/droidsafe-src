package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import libcore.io.SizeOf;

final class IntToByteBufferAdapter extends IntBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.602 -0400", hash_original_field = "73D79CD15754C8F39826976EB3E77012", hash_generated_field = "34B9235D8E87AE2A76AC711395EEC0EB")

    private ByteBuffer byteBuffer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.617 -0400", hash_original_method = "0E7C7C86CACD977D9C0D85465EADD9B5", hash_generated_method = "6657DCBFFBE0C8453AA9452787423263")
    private  IntToByteBufferAdapter(ByteBuffer byteBuffer) {
        super(byteBuffer.capacity() / SizeOf.INT);
        this.byteBuffer = byteBuffer;
        this.byteBuffer.clear();
        this.effectiveDirectAddress = byteBuffer.effectiveDirectAddress;
        // ---------- Original Method ----------
        //this.byteBuffer = byteBuffer;
        //this.byteBuffer.clear();
        //this.effectiveDirectAddress = byteBuffer.effectiveDirectAddress;
    }

    
        static IntBuffer asIntBuffer(ByteBuffer byteBuffer) {
        ByteBuffer slice = byteBuffer.slice();
        slice.order(byteBuffer.order());
        return new IntToByteBufferAdapter(slice);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.627 -0400", hash_original_method = "3B6C20C87137502BB674F780046CDA86", hash_generated_method = "D7C83E0752D1203B594D870F58C1584C")
    @Override
    public IntBuffer asReadOnlyBuffer() {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_1470500368 = null; //Variable for return #1
        IntToByteBufferAdapter buf;
        buf = new IntToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        buf.byteBuffer.order = byteBuffer.order;
        varB4EAC82CA7396A68D541C85D26508E83_1470500368 = buf;
        varB4EAC82CA7396A68D541C85D26508E83_1470500368.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1470500368;
        // ---------- Original Method ----------
        //IntToByteBufferAdapter buf = new IntToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        //buf.limit = limit;
        //buf.position = position;
        //buf.mark = mark;
        //buf.byteBuffer.order = byteBuffer.order;
        //return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.628 -0400", hash_original_method = "D18BA662CC63D97B7B456C28811B5740", hash_generated_method = "A2783CF564669018860DF276CCF2141A")
    @Override
    public IntBuffer compact() {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_289427938 = null; //Variable for return #1
        {
            boolean varD77B6130B34264A0EF448C4235FCDE48_1164266547 = (byteBuffer.isReadOnly());
            {
                if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
            } //End block
        } //End collapsed parenthetic
        byteBuffer.limit(limit * SizeOf.INT);
        byteBuffer.position(position * SizeOf.INT);
        byteBuffer.compact();
        byteBuffer.clear();
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        varB4EAC82CA7396A68D541C85D26508E83_289427938 = this;
        varB4EAC82CA7396A68D541C85D26508E83_289427938.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_289427938;
        // ---------- Original Method ----------
        //if (byteBuffer.isReadOnly()) {
            //throw new ReadOnlyBufferException();
        //}
        //byteBuffer.limit(limit * SizeOf.INT);
        //byteBuffer.position(position * SizeOf.INT);
        //byteBuffer.compact();
        //byteBuffer.clear();
        //position = limit - position;
        //limit = capacity;
        //mark = UNSET_MARK;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.640 -0400", hash_original_method = "E4BE94C048430920FB1F32A36A3DD508", hash_generated_method = "980B679B8102EF708F9F49EE0C219FCB")
    @Override
    public IntBuffer duplicate() {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_437549558 = null; //Variable for return #1
        ByteBuffer bb;
        bb = byteBuffer.duplicate().order(byteBuffer.order());
        IntToByteBufferAdapter buf;
        buf = new IntToByteBufferAdapter(bb);
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        varB4EAC82CA7396A68D541C85D26508E83_437549558 = buf;
        varB4EAC82CA7396A68D541C85D26508E83_437549558.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_437549558;
        // ---------- Original Method ----------
        //ByteBuffer bb = byteBuffer.duplicate().order(byteBuffer.order());
        //IntToByteBufferAdapter buf = new IntToByteBufferAdapter(bb);
        //buf.limit = limit;
        //buf.position = position;
        //buf.mark = mark;
        //return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.640 -0400", hash_original_method = "B6C265DA3B3DAD372E7C00DDFF580FE2", hash_generated_method = "D3352CA69A956AF07B9BB140FD48EC5E")
    @Override
    public int get() {
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } //End block
        int varD18E1B8FE9CD97C8C6275F7ADEF444F4_915951297 = (byteBuffer.getInt(position++ * SizeOf.INT));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_723844549 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_723844549;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return byteBuffer.getInt(position++ * SizeOf.INT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.642 -0400", hash_original_method = "A308FF9E693AF460AC240055AB8B4E4F", hash_generated_method = "3616B0AA597B6CBCD5966408309960F2")
    @Override
    public int get(int index) {
        checkIndex(index);
        int var027D604C62CC9C19A1201FADEFFBEA6F_1392383952 = (byteBuffer.getInt(index * SizeOf.INT));
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1542624608 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1542624608;
        // ---------- Original Method ----------
        //checkIndex(index);
        //return byteBuffer.getInt(index * SizeOf.INT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.654 -0400", hash_original_method = "C677A64CEDCCE4923055860B8C2E3944", hash_generated_method = "DE709B5521EFDF692C8E1F75FEF7EE9C")
    @Override
    public IntBuffer get(int[] dst, int dstOffset, int intCount) {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_69465225 = null; //Variable for return #1
        byteBuffer.limit(limit * SizeOf.INT);
        byteBuffer.position(position * SizeOf.INT);
        {
            ((DirectByteBuffer) byteBuffer).get(dst, dstOffset, intCount);
        } //End block
        {
            ((HeapByteBuffer) byteBuffer).get(dst, dstOffset, intCount);
        } //End block
        this.position += intCount;
        varB4EAC82CA7396A68D541C85D26508E83_69465225 = this;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(intCount);
        varB4EAC82CA7396A68D541C85D26508E83_69465225.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_69465225;
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.INT);
        //byteBuffer.position(position * SizeOf.INT);
        //if (byteBuffer instanceof DirectByteBuffer) {
            //((DirectByteBuffer) byteBuffer).get(dst, dstOffset, intCount);
        //} else {
            //((HeapByteBuffer) byteBuffer).get(dst, dstOffset, intCount);
        //}
        //this.position += intCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.654 -0400", hash_original_method = "78E98F36E3D964482B56C152BAA7846E", hash_generated_method = "D834C6AE9255795780EBF18719B13C6D")
    @Override
    public boolean isDirect() {
        boolean var6A38F61B252C327C2F003ABEEAE77D3E_389204703 = (byteBuffer.isDirect());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1555401186 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1555401186;
        // ---------- Original Method ----------
        //return byteBuffer.isDirect();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.655 -0400", hash_original_method = "A5873C4C7FD9475A7CC3E2D0E938541A", hash_generated_method = "AB7B8D42EE791D05BBE7D04981E0948D")
    @Override
    public boolean isReadOnly() {
        boolean varB84E0A3CE12C63F21B1E15D856C3A969_290079514 = (byteBuffer.isReadOnly());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_224139490 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_224139490;
        // ---------- Original Method ----------
        //return byteBuffer.isReadOnly();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.655 -0400", hash_original_method = "DBC83B570884A1A98A3F46EF314D6E4A", hash_generated_method = "7EC6C939A697BC8A2921BE8DEADD2C8D")
    @Override
    public ByteOrder order() {
        ByteOrder varB4EAC82CA7396A68D541C85D26508E83_838727818 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_838727818 = byteBuffer.order();
        varB4EAC82CA7396A68D541C85D26508E83_838727818.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_838727818;
        // ---------- Original Method ----------
        //return byteBuffer.order();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.656 -0400", hash_original_method = "B5E68F6CE1B6AAF4D730BB4F773E288A", hash_generated_method = "9E9C78454E9FD3EF18CDC8BE4D344CDF")
    @Override
    protected int[] protectedArray() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_40807241 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_40807241;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.656 -0400", hash_original_method = "11D0A2FFE917F2CC89FA6C9EBE3FCE7F", hash_generated_method = "303B609C3F9E310482FD8FDD4EAFA563")
    @Override
    protected int protectedArrayOffset() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1034842876 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1034842876;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.670 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "36CEF3A50208BC3847057559FB83D445")
    @Override
    protected boolean protectedHasArray() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_301983275 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_301983275;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.671 -0400", hash_original_method = "3F86EA2C1F796EC91605CF34A16A44E5", hash_generated_method = "7B12446B1663C74CE337493638F5E570")
    @Override
    public IntBuffer put(int c) {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_1543059416 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        byteBuffer.putInt(position++ * SizeOf.INT, c);
        varB4EAC82CA7396A68D541C85D26508E83_1543059416 = this;
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_1543059416.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1543059416;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //byteBuffer.putInt(position++ * SizeOf.INT, c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.675 -0400", hash_original_method = "3231AAB5D18FCEA9F424FA8559AECE08", hash_generated_method = "A1F97013687BE5720341330171F191A8")
    @Override
    public IntBuffer put(int index, int c) {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_1391276703 = null; //Variable for return #1
        checkIndex(index);
        byteBuffer.putInt(index * SizeOf.INT, c);
        varB4EAC82CA7396A68D541C85D26508E83_1391276703 = this;
        addTaint(index);
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_1391276703.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1391276703;
        // ---------- Original Method ----------
        //checkIndex(index);
        //byteBuffer.putInt(index * SizeOf.INT, c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.702 -0400", hash_original_method = "DC03F153D09213907F9D5CD0A27C6001", hash_generated_method = "F0A8AAD40A075B08601526820D53A7C1")
    @Override
    public IntBuffer put(int[] src, int srcOffset, int intCount) {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_1276738921 = null; //Variable for return #1
        byteBuffer.limit(limit * SizeOf.INT);
        byteBuffer.position(position * SizeOf.INT);
        {
            ((ReadWriteDirectByteBuffer) byteBuffer).put(src, srcOffset, intCount);
        } //End block
        {
            ((ReadWriteHeapByteBuffer) byteBuffer).put(src, srcOffset, intCount);
        } //End block
        this.position += intCount;
        varB4EAC82CA7396A68D541C85D26508E83_1276738921 = this;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(intCount);
        varB4EAC82CA7396A68D541C85D26508E83_1276738921.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1276738921;
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.INT);
        //byteBuffer.position(position * SizeOf.INT);
        //if (byteBuffer instanceof ReadWriteDirectByteBuffer) {
            //((ReadWriteDirectByteBuffer) byteBuffer).put(src, srcOffset, intCount);
        //} else {
            //((ReadWriteHeapByteBuffer) byteBuffer).put(src, srcOffset, intCount);
        //}
        //this.position += intCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.702 -0400", hash_original_method = "9FAC3500FD67AB6DCB59E60DAE965917", hash_generated_method = "9ADC429CA4AEEB33B2BC732FDC1F2603")
    @Override
    public IntBuffer slice() {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_1148869758 = null; //Variable for return #1
        byteBuffer.limit(limit * SizeOf.INT);
        byteBuffer.position(position * SizeOf.INT);
        ByteBuffer bb;
        bb = byteBuffer.slice().order(byteBuffer.order());
        IntBuffer result;
        result = new IntToByteBufferAdapter(bb);
        byteBuffer.clear();
        varB4EAC82CA7396A68D541C85D26508E83_1148869758 = result;
        varB4EAC82CA7396A68D541C85D26508E83_1148869758.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1148869758;
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.INT);
        //byteBuffer.position(position * SizeOf.INT);
        //ByteBuffer bb = byteBuffer.slice().order(byteBuffer.order());
        //IntBuffer result = new IntToByteBufferAdapter(bb);
        //byteBuffer.clear();
        //return result;
    }

    
}

