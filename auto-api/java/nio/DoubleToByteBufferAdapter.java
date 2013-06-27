package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import libcore.io.SizeOf;

final class DoubleToByteBufferAdapter extends DoubleBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.288 -0400", hash_original_field = "73D79CD15754C8F39826976EB3E77012", hash_generated_field = "34B9235D8E87AE2A76AC711395EEC0EB")

    private ByteBuffer byteBuffer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.292 -0400", hash_original_method = "3C3F64E3DFEA19E69D83DE032CD69444", hash_generated_method = "6CAAD45A3D270E301643B5D0616EFF17")
    private  DoubleToByteBufferAdapter(ByteBuffer byteBuffer) {
        super(byteBuffer.capacity() / SizeOf.DOUBLE);
        this.byteBuffer = byteBuffer;
        this.byteBuffer.clear();
        this.effectiveDirectAddress = byteBuffer.effectiveDirectAddress;
        // ---------- Original Method ----------
        //this.byteBuffer = byteBuffer;
        //this.byteBuffer.clear();
        //this.effectiveDirectAddress = byteBuffer.effectiveDirectAddress;
    }

    
        static DoubleBuffer asDoubleBuffer(ByteBuffer byteBuffer) {
        ByteBuffer slice = byteBuffer.slice();
        slice.order(byteBuffer.order());
        return new DoubleToByteBufferAdapter(slice);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.293 -0400", hash_original_method = "66F1F6EEFF46B34AB7A86EE28CB8A669", hash_generated_method = "EB570699984A765EAC3A5ABA6C2A85F6")
    @Override
    public DoubleBuffer asReadOnlyBuffer() {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_1403308641 = null; //Variable for return #1
        DoubleToByteBufferAdapter buf;
        buf = new DoubleToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        buf.byteBuffer.order = byteBuffer.order;
        varB4EAC82CA7396A68D541C85D26508E83_1403308641 = buf;
        varB4EAC82CA7396A68D541C85D26508E83_1403308641.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1403308641;
        // ---------- Original Method ----------
        //DoubleToByteBufferAdapter buf = new DoubleToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        //buf.limit = limit;
        //buf.position = position;
        //buf.mark = mark;
        //buf.byteBuffer.order = byteBuffer.order;
        //return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.294 -0400", hash_original_method = "A0960685ED8E4B90630D067C0149A7A7", hash_generated_method = "87AFFD526593C1EB3EED9A9DB5B4205B")
    @Override
    public DoubleBuffer compact() {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_165655407 = null; //Variable for return #1
        {
            boolean varD77B6130B34264A0EF448C4235FCDE48_1358236426 = (byteBuffer.isReadOnly());
            {
                if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
            } //End block
        } //End collapsed parenthetic
        byteBuffer.limit(limit * SizeOf.DOUBLE);
        byteBuffer.position(position * SizeOf.DOUBLE);
        byteBuffer.compact();
        byteBuffer.clear();
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        varB4EAC82CA7396A68D541C85D26508E83_165655407 = this;
        varB4EAC82CA7396A68D541C85D26508E83_165655407.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_165655407;
        // ---------- Original Method ----------
        //if (byteBuffer.isReadOnly()) {
            //throw new ReadOnlyBufferException();
        //}
        //byteBuffer.limit(limit * SizeOf.DOUBLE);
        //byteBuffer.position(position * SizeOf.DOUBLE);
        //byteBuffer.compact();
        //byteBuffer.clear();
        //position = limit - position;
        //limit = capacity;
        //mark = UNSET_MARK;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.305 -0400", hash_original_method = "FD4932C207B542FC04D0525E47AC3161", hash_generated_method = "ECA0147ACB6FADED937253A8B319F1F3")
    @Override
    public DoubleBuffer duplicate() {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_864144725 = null; //Variable for return #1
        ByteBuffer bb;
        bb = byteBuffer.duplicate().order(byteBuffer.order());
        DoubleToByteBufferAdapter buf;
        buf = new DoubleToByteBufferAdapter(bb);
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        varB4EAC82CA7396A68D541C85D26508E83_864144725 = buf;
        varB4EAC82CA7396A68D541C85D26508E83_864144725.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_864144725;
        // ---------- Original Method ----------
        //ByteBuffer bb = byteBuffer.duplicate().order(byteBuffer.order());
        //DoubleToByteBufferAdapter buf = new DoubleToByteBufferAdapter(bb);
        //buf.limit = limit;
        //buf.position = position;
        //buf.mark = mark;
        //return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.306 -0400", hash_original_method = "0C75853E3C2CF6732FFCF6E98F870BD4", hash_generated_method = "AC0BAC30144E0374D3DFAC70CBF67DA2")
    @Override
    public double get() {
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } //End block
        double var0C8B152D8EEFE99D31FF9D209276D190_1543293706 = (byteBuffer.getDouble(position++ * SizeOf.DOUBLE));
        double varE8CD7DA078A86726031AD64F35F5A6C0_620130895 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_620130895;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return byteBuffer.getDouble(position++ * SizeOf.DOUBLE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.306 -0400", hash_original_method = "E6FEAF9DCFF95E07F26C5202FDF2E7B8", hash_generated_method = "93BD0FFB74507085CEB22D491FA026DC")
    @Override
    public double get(int index) {
        checkIndex(index);
        double var436C03F06107CC79B199B8289700FA67_1532002695 = (byteBuffer.getDouble(index * SizeOf.DOUBLE));
        addTaint(index);
        double varE8CD7DA078A86726031AD64F35F5A6C0_1816020103 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1816020103;
        // ---------- Original Method ----------
        //checkIndex(index);
        //return byteBuffer.getDouble(index * SizeOf.DOUBLE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.309 -0400", hash_original_method = "D37CED54394BDE1310F07C3D0EF5D332", hash_generated_method = "327AB93283EBF6FCF8DB1061BF39AA9E")
    @Override
    public DoubleBuffer get(double[] dst, int dstOffset, int doubleCount) {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_1088239552 = null; //Variable for return #1
        byteBuffer.limit(limit * SizeOf.DOUBLE);
        byteBuffer.position(position * SizeOf.DOUBLE);
        {
            ((DirectByteBuffer) byteBuffer).get(dst, dstOffset, doubleCount);
        } //End block
        {
            ((HeapByteBuffer) byteBuffer).get(dst, dstOffset, doubleCount);
        } //End block
        this.position += doubleCount;
        varB4EAC82CA7396A68D541C85D26508E83_1088239552 = this;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(doubleCount);
        varB4EAC82CA7396A68D541C85D26508E83_1088239552.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1088239552;
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.DOUBLE);
        //byteBuffer.position(position * SizeOf.DOUBLE);
        //if (byteBuffer instanceof DirectByteBuffer) {
            //((DirectByteBuffer) byteBuffer).get(dst, dstOffset, doubleCount);
        //} else {
            //((HeapByteBuffer) byteBuffer).get(dst, dstOffset, doubleCount);
        //}
        //this.position += doubleCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.310 -0400", hash_original_method = "78E98F36E3D964482B56C152BAA7846E", hash_generated_method = "963BA8E4068D3D6E56D6E06CFD6C0221")
    @Override
    public boolean isDirect() {
        boolean var6A38F61B252C327C2F003ABEEAE77D3E_1432020103 = (byteBuffer.isDirect());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1841029654 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1841029654;
        // ---------- Original Method ----------
        //return byteBuffer.isDirect();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.311 -0400", hash_original_method = "A5873C4C7FD9475A7CC3E2D0E938541A", hash_generated_method = "4949FDDDB7F7472865BD40A85E81E5E5")
    @Override
    public boolean isReadOnly() {
        boolean varB84E0A3CE12C63F21B1E15D856C3A969_96132103 = (byteBuffer.isReadOnly());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1242969948 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1242969948;
        // ---------- Original Method ----------
        //return byteBuffer.isReadOnly();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.312 -0400", hash_original_method = "DBC83B570884A1A98A3F46EF314D6E4A", hash_generated_method = "46D1BC9FE6E105E0A358F222C31ED625")
    @Override
    public ByteOrder order() {
        ByteOrder varB4EAC82CA7396A68D541C85D26508E83_1659853013 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1659853013 = byteBuffer.order();
        varB4EAC82CA7396A68D541C85D26508E83_1659853013.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1659853013;
        // ---------- Original Method ----------
        //return byteBuffer.order();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.323 -0400", hash_original_method = "74B676FF851868B6C558CA9DCC9A472E", hash_generated_method = "E5EE21A170142ED8FF415FF89CDB3BD0")
    @Override
    protected double[] protectedArray() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        double[] var74D44D7D9EE6FE6C3433D694F869E521_1329303117 = {getTaintDouble()};
        return var74D44D7D9EE6FE6C3433D694F869E521_1329303117;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.330 -0400", hash_original_method = "11D0A2FFE917F2CC89FA6C9EBE3FCE7F", hash_generated_method = "82FC32C1F7CAE86A4C20FEB13E1B0433")
    @Override
    protected int protectedArrayOffset() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1162728546 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1162728546;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.334 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "C5881AE80BFE07DC124D664B28898517")
    @Override
    protected boolean protectedHasArray() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1185825395 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1185825395;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.335 -0400", hash_original_method = "40AF4DBB8CAF825D560827D27834F61A", hash_generated_method = "694F3F4EFB178F23D03296BCB2E6729B")
    @Override
    public DoubleBuffer put(double c) {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_788585328 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        byteBuffer.putDouble(position++ * SizeOf.DOUBLE, c);
        varB4EAC82CA7396A68D541C85D26508E83_788585328 = this;
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_788585328.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_788585328;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //byteBuffer.putDouble(position++ * SizeOf.DOUBLE, c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.335 -0400", hash_original_method = "86E534F052F254A7B02EA4C07E94BFA8", hash_generated_method = "F52F6FCCF6E544A79F944086292910F0")
    @Override
    public DoubleBuffer put(int index, double c) {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_1053703348 = null; //Variable for return #1
        checkIndex(index);
        byteBuffer.putDouble(index * SizeOf.DOUBLE, c);
        varB4EAC82CA7396A68D541C85D26508E83_1053703348 = this;
        addTaint(index);
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_1053703348.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1053703348;
        // ---------- Original Method ----------
        //checkIndex(index);
        //byteBuffer.putDouble(index * SizeOf.DOUBLE, c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.336 -0400", hash_original_method = "9EEEA82F785CE6D4D72E12428428FA8D", hash_generated_method = "804924D14D0971A0FA4F8F7B3CA9F7A8")
    @Override
    public DoubleBuffer put(double[] src, int srcOffset, int doubleCount) {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_1538108783 = null; //Variable for return #1
        byteBuffer.limit(limit * SizeOf.DOUBLE);
        byteBuffer.position(position * SizeOf.DOUBLE);
        {
            ((ReadWriteDirectByteBuffer) byteBuffer).put(src, srcOffset, doubleCount);
        } //End block
        {
            ((ReadWriteHeapByteBuffer) byteBuffer).put(src, srcOffset, doubleCount);
        } //End block
        this.position += doubleCount;
        varB4EAC82CA7396A68D541C85D26508E83_1538108783 = this;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(doubleCount);
        varB4EAC82CA7396A68D541C85D26508E83_1538108783.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1538108783;
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.DOUBLE);
        //byteBuffer.position(position * SizeOf.DOUBLE);
        //if (byteBuffer instanceof ReadWriteDirectByteBuffer) {
            //((ReadWriteDirectByteBuffer) byteBuffer).put(src, srcOffset, doubleCount);
        //} else {
            //((ReadWriteHeapByteBuffer) byteBuffer).put(src, srcOffset, doubleCount);
        //}
        //this.position += doubleCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.347 -0400", hash_original_method = "22A6C9D0B842A6C5A7761EE0E7412B6B", hash_generated_method = "E544090673D9C45963C4C4D36995D86B")
    @Override
    public DoubleBuffer slice() {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_967833812 = null; //Variable for return #1
        byteBuffer.limit(limit * SizeOf.DOUBLE);
        byteBuffer.position(position * SizeOf.DOUBLE);
        ByteBuffer bb;
        bb = byteBuffer.slice().order(byteBuffer.order());
        DoubleBuffer result;
        result = new DoubleToByteBufferAdapter(bb);
        byteBuffer.clear();
        varB4EAC82CA7396A68D541C85D26508E83_967833812 = result;
        varB4EAC82CA7396A68D541C85D26508E83_967833812.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_967833812;
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.DOUBLE);
        //byteBuffer.position(position * SizeOf.DOUBLE);
        //ByteBuffer bb = byteBuffer.slice().order(byteBuffer.order());
        //DoubleBuffer result = new DoubleToByteBufferAdapter(bb);
        //byteBuffer.clear();
        //return result;
    }

    
}

