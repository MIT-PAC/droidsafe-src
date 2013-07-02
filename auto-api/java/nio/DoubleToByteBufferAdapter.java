package java.nio;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import libcore.io.SizeOf;

final class DoubleToByteBufferAdapter extends DoubleBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.192 -0400", hash_original_field = "73D79CD15754C8F39826976EB3E77012", hash_generated_field = "34B9235D8E87AE2A76AC711395EEC0EB")

    private ByteBuffer byteBuffer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.192 -0400", hash_original_method = "3C3F64E3DFEA19E69D83DE032CD69444", hash_generated_method = "6CAAD45A3D270E301643B5D0616EFF17")
    private  DoubleToByteBufferAdapter(ByteBuffer byteBuffer) {
        super(byteBuffer.capacity() / SizeOf.DOUBLE);
        this.byteBuffer = byteBuffer;
        this.byteBuffer.clear();
        this.effectiveDirectAddress = byteBuffer.effectiveDirectAddress;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    static DoubleBuffer asDoubleBuffer(ByteBuffer byteBuffer) {
        ByteBuffer slice = byteBuffer.slice();
        slice.order(byteBuffer.order());
        return new DoubleToByteBufferAdapter(slice);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.193 -0400", hash_original_method = "66F1F6EEFF46B34AB7A86EE28CB8A669", hash_generated_method = "BC91ED9B57AD1C57D9D3FF2DA1B1632C")
    @Override
    public DoubleBuffer asReadOnlyBuffer() {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_330662263 = null; 
        DoubleToByteBufferAdapter buf = new DoubleToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        buf.byteBuffer.order = byteBuffer.order;
        varB4EAC82CA7396A68D541C85D26508E83_330662263 = buf;
        varB4EAC82CA7396A68D541C85D26508E83_330662263.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_330662263;
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.194 -0400", hash_original_method = "A0960685ED8E4B90630D067C0149A7A7", hash_generated_method = "DDF732B177BC4C6F7294C8D39F1D5212")
    @Override
    public DoubleBuffer compact() {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_1714743532 = null; 
        {
            boolean varD77B6130B34264A0EF448C4235FCDE48_1048409579 = (byteBuffer.isReadOnly());
            {
                if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
            } 
        } 
        byteBuffer.limit(limit * SizeOf.DOUBLE);
        byteBuffer.position(position * SizeOf.DOUBLE);
        byteBuffer.compact();
        byteBuffer.clear();
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        varB4EAC82CA7396A68D541C85D26508E83_1714743532 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1714743532.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1714743532;
        
        
            
        
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.195 -0400", hash_original_method = "FD4932C207B542FC04D0525E47AC3161", hash_generated_method = "25A48103003EE4BC4CBA1C98DB19B054")
    @Override
    public DoubleBuffer duplicate() {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_1734955408 = null; 
        ByteBuffer bb = byteBuffer.duplicate().order(byteBuffer.order());
        DoubleToByteBufferAdapter buf = new DoubleToByteBufferAdapter(bb);
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        varB4EAC82CA7396A68D541C85D26508E83_1734955408 = buf;
        varB4EAC82CA7396A68D541C85D26508E83_1734955408.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1734955408;
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.195 -0400", hash_original_method = "0C75853E3C2CF6732FFCF6E98F870BD4", hash_generated_method = "46FD6FC3E9A1218DF378BE01B7F970A2")
    @Override
    public double get() {
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } 
        double var0C8B152D8EEFE99D31FF9D209276D190_604874835 = (byteBuffer.getDouble(position++ * SizeOf.DOUBLE));
        double varE8CD7DA078A86726031AD64F35F5A6C0_1763499465 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1763499465;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.196 -0400", hash_original_method = "E6FEAF9DCFF95E07F26C5202FDF2E7B8", hash_generated_method = "5D11D700452FA31ABC0DE085618D7D04")
    @Override
    public double get(int index) {
        checkIndex(index);
        double var436C03F06107CC79B199B8289700FA67_1024745330 = (byteBuffer.getDouble(index * SizeOf.DOUBLE));
        addTaint(index);
        double varE8CD7DA078A86726031AD64F35F5A6C0_663588155 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_663588155;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.196 -0400", hash_original_method = "D37CED54394BDE1310F07C3D0EF5D332", hash_generated_method = "7E50F2FA1605CAB93D063E49C726D5B4")
    @Override
    public DoubleBuffer get(double[] dst, int dstOffset, int doubleCount) {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_1159591365 = null; 
        byteBuffer.limit(limit * SizeOf.DOUBLE);
        byteBuffer.position(position * SizeOf.DOUBLE);
        {
            ((DirectByteBuffer) byteBuffer).get(dst, dstOffset, doubleCount);
        } 
        {
            ((HeapByteBuffer) byteBuffer).get(dst, dstOffset, doubleCount);
        } 
        this.position += doubleCount;
        varB4EAC82CA7396A68D541C85D26508E83_1159591365 = this;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(doubleCount);
        varB4EAC82CA7396A68D541C85D26508E83_1159591365.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1159591365;
        
        
        
        
            
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.197 -0400", hash_original_method = "78E98F36E3D964482B56C152BAA7846E", hash_generated_method = "2AA6B50AFB123D70F8661389082C929C")
    @Override
    public boolean isDirect() {
        boolean var6A38F61B252C327C2F003ABEEAE77D3E_1467295330 = (byteBuffer.isDirect());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1548417636 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1548417636;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.197 -0400", hash_original_method = "A5873C4C7FD9475A7CC3E2D0E938541A", hash_generated_method = "4A5AE68B1AAD30CDA1CB2A1693D22F70")
    @Override
    public boolean isReadOnly() {
        boolean varB84E0A3CE12C63F21B1E15D856C3A969_1222363619 = (byteBuffer.isReadOnly());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_922225038 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_922225038;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.197 -0400", hash_original_method = "DBC83B570884A1A98A3F46EF314D6E4A", hash_generated_method = "AA7E0306E7D7C2E15460B4530FCA58D0")
    @Override
    public ByteOrder order() {
        ByteOrder varB4EAC82CA7396A68D541C85D26508E83_548041956 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_548041956 = byteBuffer.order();
        varB4EAC82CA7396A68D541C85D26508E83_548041956.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_548041956;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.198 -0400", hash_original_method = "74B676FF851868B6C558CA9DCC9A472E", hash_generated_method = "25A9131376A60812F9FCA3D7DBB8B2C3")
    @Override
    protected double[] protectedArray() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        double[] var74D44D7D9EE6FE6C3433D694F869E521_906033704 = {getTaintDouble()};
        return var74D44D7D9EE6FE6C3433D694F869E521_906033704;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.198 -0400", hash_original_method = "11D0A2FFE917F2CC89FA6C9EBE3FCE7F", hash_generated_method = "7729080CEAF3B57A495B84678290C5E9")
    @Override
    protected int protectedArrayOffset() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1091281656 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1091281656;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.198 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "538768034EC5FBC1825C2896ED7FAD23")
    @Override
    protected boolean protectedHasArray() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1185207815 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1185207815;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.199 -0400", hash_original_method = "40AF4DBB8CAF825D560827D27834F61A", hash_generated_method = "F10B2CCB12A5F5FE1E3DBB46DADED818")
    @Override
    public DoubleBuffer put(double c) {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_1184184771 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } 
        byteBuffer.putDouble(position++ * SizeOf.DOUBLE, c);
        varB4EAC82CA7396A68D541C85D26508E83_1184184771 = this;
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_1184184771.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1184184771;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.199 -0400", hash_original_method = "86E534F052F254A7B02EA4C07E94BFA8", hash_generated_method = "26562156EAD763287E6E7183D708BD0D")
    @Override
    public DoubleBuffer put(int index, double c) {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_1397781797 = null; 
        checkIndex(index);
        byteBuffer.putDouble(index * SizeOf.DOUBLE, c);
        varB4EAC82CA7396A68D541C85D26508E83_1397781797 = this;
        addTaint(index);
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_1397781797.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1397781797;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.200 -0400", hash_original_method = "9EEEA82F785CE6D4D72E12428428FA8D", hash_generated_method = "4894CDD01F6C55850CA8D587CDF30167")
    @Override
    public DoubleBuffer put(double[] src, int srcOffset, int doubleCount) {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_842032932 = null; 
        byteBuffer.limit(limit * SizeOf.DOUBLE);
        byteBuffer.position(position * SizeOf.DOUBLE);
        {
            ((ReadWriteDirectByteBuffer) byteBuffer).put(src, srcOffset, doubleCount);
        } 
        {
            ((ReadWriteHeapByteBuffer) byteBuffer).put(src, srcOffset, doubleCount);
        } 
        this.position += doubleCount;
        varB4EAC82CA7396A68D541C85D26508E83_842032932 = this;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(doubleCount);
        varB4EAC82CA7396A68D541C85D26508E83_842032932.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_842032932;
        
        
        
        
            
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.202 -0400", hash_original_method = "22A6C9D0B842A6C5A7761EE0E7412B6B", hash_generated_method = "3888F2DCE796F8453AFFC609D97FA048")
    @Override
    public DoubleBuffer slice() {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_198287492 = null; 
        byteBuffer.limit(limit * SizeOf.DOUBLE);
        byteBuffer.position(position * SizeOf.DOUBLE);
        ByteBuffer bb = byteBuffer.slice().order(byteBuffer.order());
        DoubleBuffer result = new DoubleToByteBufferAdapter(bb);
        byteBuffer.clear();
        varB4EAC82CA7396A68D541C85D26508E83_198287492 = result;
        varB4EAC82CA7396A68D541C85D26508E83_198287492.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_198287492;
        
        
        
        
        
        
        
    }

    
}

