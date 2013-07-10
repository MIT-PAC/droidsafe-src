package java.nio;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

final class ReadWriteIntArrayBuffer extends IntArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.203 -0400", hash_original_method = "8D9DDDEFB3AB21DD4A0254B750731D70", hash_generated_method = "FBE6D4444647FC0D91F17CC3B3839210")
      ReadWriteIntArrayBuffer(int[] array) {
        super(array);
        addTaint(array[0]);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.203 -0400", hash_original_method = "43CEDB64CCBA692E544DE7CD0AC198FC", hash_generated_method = "D5824848B8F8069FF2A536AD7318DD6E")
      ReadWriteIntArrayBuffer(int capacity) {
        super(capacity);
        addTaint(capacity);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.204 -0400", hash_original_method = "A26E8A674EF0ED3D9F3331CA6DE93799", hash_generated_method = "26EBBD09F55D7885EFA6C159947723C8")
      ReadWriteIntArrayBuffer(int capacity, int[] backingArray, int arrayOffset) {
        super(capacity, backingArray, arrayOffset);
        addTaint(capacity);
        addTaint(backingArray[0]);
        addTaint(arrayOffset);
        
    }

    
    @DSModeled(DSC.SAFE)
    static ReadWriteIntArrayBuffer copy(IntArrayBuffer other, int markOfOther) {
        ReadWriteIntArrayBuffer buf =
                new ReadWriteIntArrayBuffer(other.capacity(), other.backingArray, other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.206 -0400", hash_original_method = "4B95192F4339BC062AF51933230B3F0C", hash_generated_method = "F62191C2C0532EBB3C010389903E795C")
    @Override
    public IntBuffer asReadOnlyBuffer() {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_419478959 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_419478959 = ReadOnlyIntArrayBuffer.copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_419478959.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_419478959;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.209 -0400", hash_original_method = "62E2BDB6C89716847449D50CC36598CA", hash_generated_method = "CAF0D61188947832BCC88A941AB9EB0E")
    @Override
    public IntBuffer compact() {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_266466284 = null; 
        System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        varB4EAC82CA7396A68D541C85D26508E83_266466284 = this;
        varB4EAC82CA7396A68D541C85D26508E83_266466284.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_266466284;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.210 -0400", hash_original_method = "E687D66866CD72B4F21034D8F21E9369", hash_generated_method = "35091049A0321F979EF553F26830F1AD")
    @Override
    public IntBuffer duplicate() {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_376938550 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_376938550 = copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_376938550.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_376938550;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.211 -0400", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "3B79C9D8F6513D271F2451836E624189")
    @Override
    public boolean isReadOnly() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_414213368 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_414213368;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.212 -0400", hash_original_method = "A905887CE8C7700C79178CD7C8EB8B1A", hash_generated_method = "0B810079AF099441BF0B14F56EF1E453")
    @Override
    protected int[] protectedArray() {
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_906782556 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_906782556;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.212 -0400", hash_original_method = "F848F07A68FC53238B1B56C46C388C04", hash_generated_method = "57DD2888FA862D349AA22E72E4C542AE")
    @Override
    protected int protectedArrayOffset() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1747679808 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1747679808;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.212 -0400", hash_original_method = "504D4244F3E9BA0CFC7CEE21DED3336C", hash_generated_method = "61FDC4DEE05C4EF86290B3F5A5F20C0E")
    @Override
    protected boolean protectedHasArray() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_560597211 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_560597211;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.213 -0400", hash_original_method = "24A625E8D082FBF527A2D93F3C5BC8E0", hash_generated_method = "796C51CCDB95AE819EE6CED9714DC245")
    @Override
    public IntBuffer put(int c) {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_2143855811 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } 
        backingArray[offset + position++] = c;
        varB4EAC82CA7396A68D541C85D26508E83_2143855811 = this;
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_2143855811.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2143855811;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.214 -0400", hash_original_method = "2E47BE1B8B3BBE9EFD962F4A517C459A", hash_generated_method = "279B71A3B7AFB846AB6AD0BC4231C5C7")
    @Override
    public IntBuffer put(int index, int c) {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_1509556716 = null; 
        checkIndex(index);
        backingArray[offset + index] = c;
        varB4EAC82CA7396A68D541C85D26508E83_1509556716 = this;
        addTaint(index);
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_1509556716.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1509556716;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.215 -0400", hash_original_method = "F72176B11CC709D09C4C37209C319F78", hash_generated_method = "42415316C4DCC12763B95536AC6B23C5")
    @Override
    public IntBuffer put(int[] src, int srcOffset, int intCount) {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_1068660958 = null; 
        {
            boolean var88D58DBFE8E26BEBC18FDE3265CF76EF_435427493 = (intCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
            } 
        } 
        System.arraycopy(src, srcOffset, backingArray, offset + position, intCount);
        position += intCount;
        varB4EAC82CA7396A68D541C85D26508E83_1068660958 = this;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(intCount);
        varB4EAC82CA7396A68D541C85D26508E83_1068660958.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1068660958;
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.216 -0400", hash_original_method = "E64EEB28D2F233E17F9AAF235F4E0576", hash_generated_method = "90EB3CCB6348265BC116DE48F8959028")
    @Override
    public IntBuffer slice() {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_1717538112 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1717538112 = new ReadWriteIntArrayBuffer(remaining(), backingArray, offset + position);
        varB4EAC82CA7396A68D541C85D26508E83_1717538112.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1717538112;
        
        
    }

    
}

