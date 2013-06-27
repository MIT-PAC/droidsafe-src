package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import libcore.io.SizeOf;

final class IntToByteBufferAdapter extends IntBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.667 -0400", hash_original_field = "73D79CD15754C8F39826976EB3E77012", hash_generated_field = "34B9235D8E87AE2A76AC711395EEC0EB")

    private ByteBuffer byteBuffer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.668 -0400", hash_original_method = "0E7C7C86CACD977D9C0D85465EADD9B5", hash_generated_method = "6657DCBFFBE0C8453AA9452787423263")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.669 -0400", hash_original_method = "3B6C20C87137502BB674F780046CDA86", hash_generated_method = "6EC64781569D22F093B75E238107E91A")
    @Override
    public IntBuffer asReadOnlyBuffer() {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_449495710 = null; //Variable for return #1
        IntToByteBufferAdapter buf;
        buf = new IntToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        buf.byteBuffer.order = byteBuffer.order;
        varB4EAC82CA7396A68D541C85D26508E83_449495710 = buf;
        varB4EAC82CA7396A68D541C85D26508E83_449495710.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_449495710;
        // ---------- Original Method ----------
        //IntToByteBufferAdapter buf = new IntToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        //buf.limit = limit;
        //buf.position = position;
        //buf.mark = mark;
        //buf.byteBuffer.order = byteBuffer.order;
        //return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.672 -0400", hash_original_method = "D18BA662CC63D97B7B456C28811B5740", hash_generated_method = "7221E1B3EE45809FEC97978468D8131B")
    @Override
    public IntBuffer compact() {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_577320019 = null; //Variable for return #1
        {
            boolean varD77B6130B34264A0EF448C4235FCDE48_1249982461 = (byteBuffer.isReadOnly());
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
        varB4EAC82CA7396A68D541C85D26508E83_577320019 = this;
        varB4EAC82CA7396A68D541C85D26508E83_577320019.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_577320019;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.675 -0400", hash_original_method = "E4BE94C048430920FB1F32A36A3DD508", hash_generated_method = "9BBC04F3C79BC087B5575182A7A18239")
    @Override
    public IntBuffer duplicate() {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_52462776 = null; //Variable for return #1
        ByteBuffer bb;
        bb = byteBuffer.duplicate().order(byteBuffer.order());
        IntToByteBufferAdapter buf;
        buf = new IntToByteBufferAdapter(bb);
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        varB4EAC82CA7396A68D541C85D26508E83_52462776 = buf;
        varB4EAC82CA7396A68D541C85D26508E83_52462776.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_52462776;
        // ---------- Original Method ----------
        //ByteBuffer bb = byteBuffer.duplicate().order(byteBuffer.order());
        //IntToByteBufferAdapter buf = new IntToByteBufferAdapter(bb);
        //buf.limit = limit;
        //buf.position = position;
        //buf.mark = mark;
        //return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.689 -0400", hash_original_method = "B6C265DA3B3DAD372E7C00DDFF580FE2", hash_generated_method = "DFC4CCD26B41DC7FC3B249809969FEF1")
    @Override
    public int get() {
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } //End block
        int varD18E1B8FE9CD97C8C6275F7ADEF444F4_100137291 = (byteBuffer.getInt(position++ * SizeOf.INT));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_292052427 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_292052427;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return byteBuffer.getInt(position++ * SizeOf.INT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.689 -0400", hash_original_method = "A308FF9E693AF460AC240055AB8B4E4F", hash_generated_method = "2004F946837C8C8DC8CCC84E2024DAEA")
    @Override
    public int get(int index) {
        checkIndex(index);
        int var027D604C62CC9C19A1201FADEFFBEA6F_955244926 = (byteBuffer.getInt(index * SizeOf.INT));
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_992380507 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_992380507;
        // ---------- Original Method ----------
        //checkIndex(index);
        //return byteBuffer.getInt(index * SizeOf.INT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.690 -0400", hash_original_method = "C677A64CEDCCE4923055860B8C2E3944", hash_generated_method = "CF781B90A977B0ABA3E3127845AF9C8A")
    @Override
    public IntBuffer get(int[] dst, int dstOffset, int intCount) {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_1253044245 = null; //Variable for return #1
        byteBuffer.limit(limit * SizeOf.INT);
        byteBuffer.position(position * SizeOf.INT);
        {
            ((DirectByteBuffer) byteBuffer).get(dst, dstOffset, intCount);
        } //End block
        {
            ((HeapByteBuffer) byteBuffer).get(dst, dstOffset, intCount);
        } //End block
        this.position += intCount;
        varB4EAC82CA7396A68D541C85D26508E83_1253044245 = this;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(intCount);
        varB4EAC82CA7396A68D541C85D26508E83_1253044245.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1253044245;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.690 -0400", hash_original_method = "78E98F36E3D964482B56C152BAA7846E", hash_generated_method = "FFA64CAE95AF964F5E8657CDCBEB86A4")
    @Override
    public boolean isDirect() {
        boolean var6A38F61B252C327C2F003ABEEAE77D3E_618785047 = (byteBuffer.isDirect());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_474967658 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_474967658;
        // ---------- Original Method ----------
        //return byteBuffer.isDirect();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.697 -0400", hash_original_method = "A5873C4C7FD9475A7CC3E2D0E938541A", hash_generated_method = "5CC9C126E573A4E4881071C1F7FC06CB")
    @Override
    public boolean isReadOnly() {
        boolean varB84E0A3CE12C63F21B1E15D856C3A969_1480217263 = (byteBuffer.isReadOnly());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1606346954 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1606346954;
        // ---------- Original Method ----------
        //return byteBuffer.isReadOnly();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.697 -0400", hash_original_method = "DBC83B570884A1A98A3F46EF314D6E4A", hash_generated_method = "AD36691D6E881213B8D026847C27B509")
    @Override
    public ByteOrder order() {
        ByteOrder varB4EAC82CA7396A68D541C85D26508E83_2075465803 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2075465803 = byteBuffer.order();
        varB4EAC82CA7396A68D541C85D26508E83_2075465803.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2075465803;
        // ---------- Original Method ----------
        //return byteBuffer.order();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.698 -0400", hash_original_method = "B5E68F6CE1B6AAF4D730BB4F773E288A", hash_generated_method = "7A836A25BEC337C4C28D42932DA6CFC8")
    @Override
    protected int[] protectedArray() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_15972520 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_15972520;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.698 -0400", hash_original_method = "11D0A2FFE917F2CC89FA6C9EBE3FCE7F", hash_generated_method = "FE7E32FA799D48D002346D6DBC5F263B")
    @Override
    protected int protectedArrayOffset() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2089356055 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2089356055;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.698 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "99F22291C29C87DF2794807C89ECE601")
    @Override
    protected boolean protectedHasArray() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1209529390 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1209529390;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.703 -0400", hash_original_method = "3F86EA2C1F796EC91605CF34A16A44E5", hash_generated_method = "B74A3458948F0B8F7F0BFB96F1F01486")
    @Override
    public IntBuffer put(int c) {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_1085302715 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        byteBuffer.putInt(position++ * SizeOf.INT, c);
        varB4EAC82CA7396A68D541C85D26508E83_1085302715 = this;
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_1085302715.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1085302715;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //byteBuffer.putInt(position++ * SizeOf.INT, c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.704 -0400", hash_original_method = "3231AAB5D18FCEA9F424FA8559AECE08", hash_generated_method = "A98DD0E49D579B7A5C93746B90B3815C")
    @Override
    public IntBuffer put(int index, int c) {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_1888564192 = null; //Variable for return #1
        checkIndex(index);
        byteBuffer.putInt(index * SizeOf.INT, c);
        varB4EAC82CA7396A68D541C85D26508E83_1888564192 = this;
        addTaint(index);
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_1888564192.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1888564192;
        // ---------- Original Method ----------
        //checkIndex(index);
        //byteBuffer.putInt(index * SizeOf.INT, c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.705 -0400", hash_original_method = "DC03F153D09213907F9D5CD0A27C6001", hash_generated_method = "835F0E4DF7F311950ACBAAD16B496442")
    @Override
    public IntBuffer put(int[] src, int srcOffset, int intCount) {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_579728038 = null; //Variable for return #1
        byteBuffer.limit(limit * SizeOf.INT);
        byteBuffer.position(position * SizeOf.INT);
        {
            ((ReadWriteDirectByteBuffer) byteBuffer).put(src, srcOffset, intCount);
        } //End block
        {
            ((ReadWriteHeapByteBuffer) byteBuffer).put(src, srcOffset, intCount);
        } //End block
        this.position += intCount;
        varB4EAC82CA7396A68D541C85D26508E83_579728038 = this;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(intCount);
        varB4EAC82CA7396A68D541C85D26508E83_579728038.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_579728038;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.705 -0400", hash_original_method = "9FAC3500FD67AB6DCB59E60DAE965917", hash_generated_method = "61385EFC1958972EABA9D46C6F6FD318")
    @Override
    public IntBuffer slice() {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_1088067769 = null; //Variable for return #1
        byteBuffer.limit(limit * SizeOf.INT);
        byteBuffer.position(position * SizeOf.INT);
        ByteBuffer bb;
        bb = byteBuffer.slice().order(byteBuffer.order());
        IntBuffer result;
        result = new IntToByteBufferAdapter(bb);
        byteBuffer.clear();
        varB4EAC82CA7396A68D541C85D26508E83_1088067769 = result;
        varB4EAC82CA7396A68D541C85D26508E83_1088067769.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1088067769;
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.INT);
        //byteBuffer.position(position * SizeOf.INT);
        //ByteBuffer bb = byteBuffer.slice().order(byteBuffer.order());
        //IntBuffer result = new IntToByteBufferAdapter(bb);
        //byteBuffer.clear();
        //return result;
    }

    
}

