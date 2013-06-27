package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import libcore.io.SizeOf;

final class DoubleToByteBufferAdapter extends DoubleBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.241 -0400", hash_original_field = "73D79CD15754C8F39826976EB3E77012", hash_generated_field = "34B9235D8E87AE2A76AC711395EEC0EB")

    private ByteBuffer byteBuffer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.253 -0400", hash_original_method = "3C3F64E3DFEA19E69D83DE032CD69444", hash_generated_method = "6CAAD45A3D270E301643B5D0616EFF17")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.259 -0400", hash_original_method = "66F1F6EEFF46B34AB7A86EE28CB8A669", hash_generated_method = "8181F436BC463E10962CEB76CB155E25")
    @Override
    public DoubleBuffer asReadOnlyBuffer() {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_95923768 = null; //Variable for return #1
        DoubleToByteBufferAdapter buf;
        buf = new DoubleToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        buf.byteBuffer.order = byteBuffer.order;
        varB4EAC82CA7396A68D541C85D26508E83_95923768 = buf;
        varB4EAC82CA7396A68D541C85D26508E83_95923768.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_95923768;
        // ---------- Original Method ----------
        //DoubleToByteBufferAdapter buf = new DoubleToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        //buf.limit = limit;
        //buf.position = position;
        //buf.mark = mark;
        //buf.byteBuffer.order = byteBuffer.order;
        //return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.277 -0400", hash_original_method = "A0960685ED8E4B90630D067C0149A7A7", hash_generated_method = "2B75BCAAA262E34B82A553103536D9C0")
    @Override
    public DoubleBuffer compact() {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_247066233 = null; //Variable for return #1
        {
            boolean varD77B6130B34264A0EF448C4235FCDE48_214559456 = (byteBuffer.isReadOnly());
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
        varB4EAC82CA7396A68D541C85D26508E83_247066233 = this;
        varB4EAC82CA7396A68D541C85D26508E83_247066233.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_247066233;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.279 -0400", hash_original_method = "FD4932C207B542FC04D0525E47AC3161", hash_generated_method = "35FD9E8E84BBEA837FDE8B39EB55C63A")
    @Override
    public DoubleBuffer duplicate() {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_443241764 = null; //Variable for return #1
        ByteBuffer bb;
        bb = byteBuffer.duplicate().order(byteBuffer.order());
        DoubleToByteBufferAdapter buf;
        buf = new DoubleToByteBufferAdapter(bb);
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        varB4EAC82CA7396A68D541C85D26508E83_443241764 = buf;
        varB4EAC82CA7396A68D541C85D26508E83_443241764.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_443241764;
        // ---------- Original Method ----------
        //ByteBuffer bb = byteBuffer.duplicate().order(byteBuffer.order());
        //DoubleToByteBufferAdapter buf = new DoubleToByteBufferAdapter(bb);
        //buf.limit = limit;
        //buf.position = position;
        //buf.mark = mark;
        //return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.279 -0400", hash_original_method = "0C75853E3C2CF6732FFCF6E98F870BD4", hash_generated_method = "F9F652D7A364033D9D72AA391A1E4DE4")
    @Override
    public double get() {
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } //End block
        double var0C8B152D8EEFE99D31FF9D209276D190_192243738 = (byteBuffer.getDouble(position++ * SizeOf.DOUBLE));
        double varE8CD7DA078A86726031AD64F35F5A6C0_647539055 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_647539055;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return byteBuffer.getDouble(position++ * SizeOf.DOUBLE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.280 -0400", hash_original_method = "E6FEAF9DCFF95E07F26C5202FDF2E7B8", hash_generated_method = "CF894939C378395F8033085359A8DC57")
    @Override
    public double get(int index) {
        checkIndex(index);
        double var436C03F06107CC79B199B8289700FA67_2313791 = (byteBuffer.getDouble(index * SizeOf.DOUBLE));
        addTaint(index);
        double varE8CD7DA078A86726031AD64F35F5A6C0_1762560365 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1762560365;
        // ---------- Original Method ----------
        //checkIndex(index);
        //return byteBuffer.getDouble(index * SizeOf.DOUBLE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.309 -0400", hash_original_method = "D37CED54394BDE1310F07C3D0EF5D332", hash_generated_method = "D4751857879ED1C35C81FFC526A257D9")
    @Override
    public DoubleBuffer get(double[] dst, int dstOffset, int doubleCount) {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_773910914 = null; //Variable for return #1
        byteBuffer.limit(limit * SizeOf.DOUBLE);
        byteBuffer.position(position * SizeOf.DOUBLE);
        {
            ((DirectByteBuffer) byteBuffer).get(dst, dstOffset, doubleCount);
        } //End block
        {
            ((HeapByteBuffer) byteBuffer).get(dst, dstOffset, doubleCount);
        } //End block
        this.position += doubleCount;
        varB4EAC82CA7396A68D541C85D26508E83_773910914 = this;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(doubleCount);
        varB4EAC82CA7396A68D541C85D26508E83_773910914.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_773910914;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.309 -0400", hash_original_method = "78E98F36E3D964482B56C152BAA7846E", hash_generated_method = "D6080723A7B4789CDD394617B49F6D0A")
    @Override
    public boolean isDirect() {
        boolean var6A38F61B252C327C2F003ABEEAE77D3E_1734050259 = (byteBuffer.isDirect());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_603713530 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_603713530;
        // ---------- Original Method ----------
        //return byteBuffer.isDirect();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.323 -0400", hash_original_method = "A5873C4C7FD9475A7CC3E2D0E938541A", hash_generated_method = "2E2A72AE6A507E49D1B713E67D15048B")
    @Override
    public boolean isReadOnly() {
        boolean varB84E0A3CE12C63F21B1E15D856C3A969_56755622 = (byteBuffer.isReadOnly());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_141744832 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_141744832;
        // ---------- Original Method ----------
        //return byteBuffer.isReadOnly();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.323 -0400", hash_original_method = "DBC83B570884A1A98A3F46EF314D6E4A", hash_generated_method = "485783EEB433C832C1B05A4ADAD8E715")
    @Override
    public ByteOrder order() {
        ByteOrder varB4EAC82CA7396A68D541C85D26508E83_279210991 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_279210991 = byteBuffer.order();
        varB4EAC82CA7396A68D541C85D26508E83_279210991.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_279210991;
        // ---------- Original Method ----------
        //return byteBuffer.order();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.324 -0400", hash_original_method = "74B676FF851868B6C558CA9DCC9A472E", hash_generated_method = "71C20CB718A3F90D4A2AFBE41D8AD87F")
    @Override
    protected double[] protectedArray() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        double[] var74D44D7D9EE6FE6C3433D694F869E521_2118203152 = {getTaintDouble()};
        return var74D44D7D9EE6FE6C3433D694F869E521_2118203152;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.324 -0400", hash_original_method = "11D0A2FFE917F2CC89FA6C9EBE3FCE7F", hash_generated_method = "529C9E3C5E3A4562A1A2703FA2C1B99C")
    @Override
    protected int protectedArrayOffset() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1583270810 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1583270810;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.324 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "B36585DBBA3CEFF8F93D550E966571C7")
    @Override
    protected boolean protectedHasArray() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1234893547 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1234893547;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.325 -0400", hash_original_method = "40AF4DBB8CAF825D560827D27834F61A", hash_generated_method = "8ACB09E15136D28C4A4EED8BBCBC2ECC")
    @Override
    public DoubleBuffer put(double c) {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_1703969767 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        byteBuffer.putDouble(position++ * SizeOf.DOUBLE, c);
        varB4EAC82CA7396A68D541C85D26508E83_1703969767 = this;
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_1703969767.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1703969767;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //byteBuffer.putDouble(position++ * SizeOf.DOUBLE, c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.339 -0400", hash_original_method = "86E534F052F254A7B02EA4C07E94BFA8", hash_generated_method = "671A03E57214E8FBDD37F0C693B3B82E")
    @Override
    public DoubleBuffer put(int index, double c) {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_999857671 = null; //Variable for return #1
        checkIndex(index);
        byteBuffer.putDouble(index * SizeOf.DOUBLE, c);
        varB4EAC82CA7396A68D541C85D26508E83_999857671 = this;
        addTaint(index);
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_999857671.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_999857671;
        // ---------- Original Method ----------
        //checkIndex(index);
        //byteBuffer.putDouble(index * SizeOf.DOUBLE, c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.340 -0400", hash_original_method = "9EEEA82F785CE6D4D72E12428428FA8D", hash_generated_method = "A14901EA88A6B8E0F49E0F49DB28C419")
    @Override
    public DoubleBuffer put(double[] src, int srcOffset, int doubleCount) {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_1347797377 = null; //Variable for return #1
        byteBuffer.limit(limit * SizeOf.DOUBLE);
        byteBuffer.position(position * SizeOf.DOUBLE);
        {
            ((ReadWriteDirectByteBuffer) byteBuffer).put(src, srcOffset, doubleCount);
        } //End block
        {
            ((ReadWriteHeapByteBuffer) byteBuffer).put(src, srcOffset, doubleCount);
        } //End block
        this.position += doubleCount;
        varB4EAC82CA7396A68D541C85D26508E83_1347797377 = this;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(doubleCount);
        varB4EAC82CA7396A68D541C85D26508E83_1347797377.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1347797377;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.341 -0400", hash_original_method = "22A6C9D0B842A6C5A7761EE0E7412B6B", hash_generated_method = "4AF030231240D964CD0DE8DCDFF68D07")
    @Override
    public DoubleBuffer slice() {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_1246359433 = null; //Variable for return #1
        byteBuffer.limit(limit * SizeOf.DOUBLE);
        byteBuffer.position(position * SizeOf.DOUBLE);
        ByteBuffer bb;
        bb = byteBuffer.slice().order(byteBuffer.order());
        DoubleBuffer result;
        result = new DoubleToByteBufferAdapter(bb);
        byteBuffer.clear();
        varB4EAC82CA7396A68D541C85D26508E83_1246359433 = result;
        varB4EAC82CA7396A68D541C85D26508E83_1246359433.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1246359433;
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.DOUBLE);
        //byteBuffer.position(position * SizeOf.DOUBLE);
        //ByteBuffer bb = byteBuffer.slice().order(byteBuffer.order());
        //DoubleBuffer result = new DoubleToByteBufferAdapter(bb);
        //byteBuffer.clear();
        //return result;
    }

    
}

