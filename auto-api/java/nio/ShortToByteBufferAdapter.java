package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import libcore.io.SizeOf;

final class ShortToByteBufferAdapter extends ShortBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.300 -0400", hash_original_field = "73D79CD15754C8F39826976EB3E77012", hash_generated_field = "34B9235D8E87AE2A76AC711395EEC0EB")

    private ByteBuffer byteBuffer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.306 -0400", hash_original_method = "A7ACA037BB98388A15E54FB4598E481B", hash_generated_method = "99030E6A8F05267CDC21391C0846AEB3")
    private  ShortToByteBufferAdapter(ByteBuffer byteBuffer) {
        super(byteBuffer.capacity() / SizeOf.SHORT);
        this.byteBuffer = byteBuffer;
        this.byteBuffer.clear();
        this.effectiveDirectAddress = byteBuffer.effectiveDirectAddress;
        // ---------- Original Method ----------
        //this.byteBuffer = byteBuffer;
        //this.byteBuffer.clear();
        //this.effectiveDirectAddress = byteBuffer.effectiveDirectAddress;
    }

    
        static ShortBuffer asShortBuffer(ByteBuffer byteBuffer) {
        ByteBuffer slice = byteBuffer.slice();
        slice.order(byteBuffer.order());
        return new ShortToByteBufferAdapter(slice);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.307 -0400", hash_original_method = "D0F8AEC70CAA4378FE6A82AD4DA3E011", hash_generated_method = "50C1895462A46A5E7DA6BC6A95F01A21")
    @Override
    public ShortBuffer asReadOnlyBuffer() {
        ShortBuffer varB4EAC82CA7396A68D541C85D26508E83_750591534 = null; //Variable for return #1
        ShortToByteBufferAdapter buf;
        buf = new ShortToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        buf.byteBuffer.order = byteBuffer.order;
        varB4EAC82CA7396A68D541C85D26508E83_750591534 = buf;
        varB4EAC82CA7396A68D541C85D26508E83_750591534.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_750591534;
        // ---------- Original Method ----------
        //ShortToByteBufferAdapter buf = new ShortToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        //buf.limit = limit;
        //buf.position = position;
        //buf.mark = mark;
        //buf.byteBuffer.order = byteBuffer.order;
        //return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.311 -0400", hash_original_method = "05DE7B6CED27ACAA0A9F6BF73EB6C673", hash_generated_method = "61C58C8A61BA03DEC9751FE2395B410E")
    @Override
    public ShortBuffer compact() {
        ShortBuffer varB4EAC82CA7396A68D541C85D26508E83_309811631 = null; //Variable for return #1
        {
            boolean varD77B6130B34264A0EF448C4235FCDE48_288713559 = (byteBuffer.isReadOnly());
            {
                if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
            } //End block
        } //End collapsed parenthetic
        byteBuffer.limit(limit * SizeOf.SHORT);
        byteBuffer.position(position * SizeOf.SHORT);
        byteBuffer.compact();
        byteBuffer.clear();
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        varB4EAC82CA7396A68D541C85D26508E83_309811631 = this;
        varB4EAC82CA7396A68D541C85D26508E83_309811631.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_309811631;
        // ---------- Original Method ----------
        //if (byteBuffer.isReadOnly()) {
            //throw new ReadOnlyBufferException();
        //}
        //byteBuffer.limit(limit * SizeOf.SHORT);
        //byteBuffer.position(position * SizeOf.SHORT);
        //byteBuffer.compact();
        //byteBuffer.clear();
        //position = limit - position;
        //limit = capacity;
        //mark = UNSET_MARK;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.327 -0400", hash_original_method = "D125FE991C052B0355B5B7F2D7D9870F", hash_generated_method = "AB4DE14D6C46B71DB255509C0F168233")
    @Override
    public ShortBuffer duplicate() {
        ShortBuffer varB4EAC82CA7396A68D541C85D26508E83_1969146182 = null; //Variable for return #1
        ByteBuffer bb;
        bb = byteBuffer.duplicate().order(byteBuffer.order());
        ShortToByteBufferAdapter buf;
        buf = new ShortToByteBufferAdapter(bb);
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        varB4EAC82CA7396A68D541C85D26508E83_1969146182 = buf;
        varB4EAC82CA7396A68D541C85D26508E83_1969146182.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1969146182;
        // ---------- Original Method ----------
        //ByteBuffer bb = byteBuffer.duplicate().order(byteBuffer.order());
        //ShortToByteBufferAdapter buf = new ShortToByteBufferAdapter(bb);
        //buf.limit = limit;
        //buf.position = position;
        //buf.mark = mark;
        //return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.327 -0400", hash_original_method = "7C4E3224E8CBDBDF522D2B052ECE14D8", hash_generated_method = "5F36EBC51A091F6B9016E6B533A61C86")
    @Override
    public short get() {
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } //End block
        short varF4A707B1B20CA460D36B00B15C262335_638003406 = (byteBuffer.getShort(position++ * SizeOf.SHORT));
        short var4F09DAA9D95BCB166A302407A0E0BABE_124195227 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_124195227;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return byteBuffer.getShort(position++ * SizeOf.SHORT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.328 -0400", hash_original_method = "99D353FC1689A601B3A3A0ABA15D7065", hash_generated_method = "A3C042ABA8FFE547203E4420864317B8")
    @Override
    public short get(int index) {
        checkIndex(index);
        short varBE4C2F8B8B0709014E8FE2B3CF301305_1193530530 = (byteBuffer.getShort(index * SizeOf.SHORT));
        addTaint(index);
        short var4F09DAA9D95BCB166A302407A0E0BABE_1634199744 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1634199744;
        // ---------- Original Method ----------
        //checkIndex(index);
        //return byteBuffer.getShort(index * SizeOf.SHORT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.329 -0400", hash_original_method = "01D384F7005F01D67D604B15B569F233", hash_generated_method = "D3108AF7942998366C1FE9E900AAE3CE")
    @Override
    public ShortBuffer get(short[] dst, int dstOffset, int shortCount) {
        ShortBuffer varB4EAC82CA7396A68D541C85D26508E83_1911048128 = null; //Variable for return #1
        byteBuffer.limit(limit * SizeOf.SHORT);
        byteBuffer.position(position * SizeOf.SHORT);
        {
            ((DirectByteBuffer) byteBuffer).get(dst, dstOffset, shortCount);
        } //End block
        {
            ((HeapByteBuffer) byteBuffer).get(dst, dstOffset, shortCount);
        } //End block
        this.position += shortCount;
        varB4EAC82CA7396A68D541C85D26508E83_1911048128 = this;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(shortCount);
        varB4EAC82CA7396A68D541C85D26508E83_1911048128.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1911048128;
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.SHORT);
        //byteBuffer.position(position * SizeOf.SHORT);
        //if (byteBuffer instanceof DirectByteBuffer) {
            //((DirectByteBuffer) byteBuffer).get(dst, dstOffset, shortCount);
        //} else {
            //((HeapByteBuffer) byteBuffer).get(dst, dstOffset, shortCount);
        //}
        //this.position += shortCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.342 -0400", hash_original_method = "78E98F36E3D964482B56C152BAA7846E", hash_generated_method = "F5D11AE5CB66D9A92398F547655F366B")
    @Override
    public boolean isDirect() {
        boolean var6A38F61B252C327C2F003ABEEAE77D3E_1342803327 = (byteBuffer.isDirect());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_339729619 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_339729619;
        // ---------- Original Method ----------
        //return byteBuffer.isDirect();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.342 -0400", hash_original_method = "A5873C4C7FD9475A7CC3E2D0E938541A", hash_generated_method = "ECC334A5FB03B7939B758043010883E9")
    @Override
    public boolean isReadOnly() {
        boolean varB84E0A3CE12C63F21B1E15D856C3A969_835350581 = (byteBuffer.isReadOnly());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1753147664 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1753147664;
        // ---------- Original Method ----------
        //return byteBuffer.isReadOnly();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.343 -0400", hash_original_method = "DBC83B570884A1A98A3F46EF314D6E4A", hash_generated_method = "955123E873EC61B60D33532634674A86")
    @Override
    public ByteOrder order() {
        ByteOrder varB4EAC82CA7396A68D541C85D26508E83_746580971 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_746580971 = byteBuffer.order();
        varB4EAC82CA7396A68D541C85D26508E83_746580971.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_746580971;
        // ---------- Original Method ----------
        //return byteBuffer.order();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.343 -0400", hash_original_method = "797461B8F23A38201C61F803B025213F", hash_generated_method = "29071474CED68264CED0D9DBF55E5349")
    @Override
    protected short[] protectedArray() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        short[] var48EE7E2DDF8A83602BC526873BD0F875_2112070031 = {getTaintShort()};
        return var48EE7E2DDF8A83602BC526873BD0F875_2112070031;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.344 -0400", hash_original_method = "11D0A2FFE917F2CC89FA6C9EBE3FCE7F", hash_generated_method = "F1966A6EF4BDB7F69C150D7C3B4AE3E0")
    @Override
    protected int protectedArrayOffset() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2089840923 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2089840923;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.344 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "2603916D40E46B512CEA190022819E3C")
    @Override
    protected boolean protectedHasArray() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_628541399 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_628541399;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.345 -0400", hash_original_method = "BED9261A5E47204D4C26D68EDDB52578", hash_generated_method = "EFC4BDFDDB04A705A1D9318A01AE3F58")
    @Override
    public ShortBuffer put(short c) {
        ShortBuffer varB4EAC82CA7396A68D541C85D26508E83_1945913743 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        byteBuffer.putShort(position++ * SizeOf.SHORT, c);
        varB4EAC82CA7396A68D541C85D26508E83_1945913743 = this;
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_1945913743.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1945913743;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //byteBuffer.putShort(position++ * SizeOf.SHORT, c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.345 -0400", hash_original_method = "81BB381464177DAD01780ED6CBAA4133", hash_generated_method = "4301E66132FADA6C78EDC9DBE49E9C1C")
    @Override
    public ShortBuffer put(int index, short c) {
        ShortBuffer varB4EAC82CA7396A68D541C85D26508E83_1783258651 = null; //Variable for return #1
        checkIndex(index);
        byteBuffer.putShort(index * SizeOf.SHORT, c);
        varB4EAC82CA7396A68D541C85D26508E83_1783258651 = this;
        addTaint(index);
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_1783258651.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1783258651;
        // ---------- Original Method ----------
        //checkIndex(index);
        //byteBuffer.putShort(index * SizeOf.SHORT, c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.360 -0400", hash_original_method = "513A20FF10AFB87C25A95801BCBD1A6B", hash_generated_method = "D8926AFAFAE7099F08B6AFC3E94B55CB")
    @Override
    public ShortBuffer put(short[] src, int srcOffset, int shortCount) {
        ShortBuffer varB4EAC82CA7396A68D541C85D26508E83_362920396 = null; //Variable for return #1
        byteBuffer.limit(limit * SizeOf.SHORT);
        byteBuffer.position(position * SizeOf.SHORT);
        {
            ((ReadWriteDirectByteBuffer) byteBuffer).put(src, srcOffset, shortCount);
        } //End block
        {
            ((ReadWriteHeapByteBuffer) byteBuffer).put(src, srcOffset, shortCount);
        } //End block
        this.position += shortCount;
        varB4EAC82CA7396A68D541C85D26508E83_362920396 = this;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(shortCount);
        varB4EAC82CA7396A68D541C85D26508E83_362920396.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_362920396;
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.SHORT);
        //byteBuffer.position(position * SizeOf.SHORT);
        //if (byteBuffer instanceof ReadWriteDirectByteBuffer) {
            //((ReadWriteDirectByteBuffer) byteBuffer).put(src, srcOffset, shortCount);
        //} else {
            //((ReadWriteHeapByteBuffer) byteBuffer).put(src, srcOffset, shortCount);
        //}
        //this.position += shortCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.361 -0400", hash_original_method = "1D11F07A1825F4A6C771FB33ADDF613C", hash_generated_method = "AB22D36125AB3FDC3DF8D8EFAD181F6D")
    @Override
    public ShortBuffer slice() {
        ShortBuffer varB4EAC82CA7396A68D541C85D26508E83_358697296 = null; //Variable for return #1
        byteBuffer.limit(limit * SizeOf.SHORT);
        byteBuffer.position(position * SizeOf.SHORT);
        ByteBuffer bb;
        bb = byteBuffer.slice().order(byteBuffer.order());
        ShortBuffer result;
        result = new ShortToByteBufferAdapter(bb);
        byteBuffer.clear();
        varB4EAC82CA7396A68D541C85D26508E83_358697296 = result;
        varB4EAC82CA7396A68D541C85D26508E83_358697296.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_358697296;
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.SHORT);
        //byteBuffer.position(position * SizeOf.SHORT);
        //ByteBuffer bb = byteBuffer.slice().order(byteBuffer.order());
        //ShortBuffer result = new ShortToByteBufferAdapter(bb);
        //byteBuffer.clear();
        //return result;
    }

    
}

