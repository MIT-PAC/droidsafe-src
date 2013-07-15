package java.nio;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

final class ReadWriteFloatArrayBuffer extends FloatArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.121 -0400", hash_original_method = "5A8DCC269DCB08038721B4A37F7722F4", hash_generated_method = "917D66AB646F81D9388A210DA86C5D6F")
      ReadWriteFloatArrayBuffer(float[] array) {
        super(array);
        addTaint(array[0]);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.122 -0400", hash_original_method = "495FFBE47D4B4B6385F4C7F54B916311", hash_generated_method = "6395FB40A1F17E2D269D92B633E16471")
      ReadWriteFloatArrayBuffer(int capacity) {
        super(capacity);
        addTaint(capacity);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.122 -0400", hash_original_method = "2552E9D1905F4AE718E09F5BFBACBECB", hash_generated_method = "DB5BF54DAA1E96E71EE81B5E38733F43")
      ReadWriteFloatArrayBuffer(int capacity, float[] backingArray, int arrayOffset) {
        super(capacity, backingArray, arrayOffset);
        addTaint(capacity);
        addTaint(backingArray[0]);
        addTaint(arrayOffset);
        
    }

    
    @DSModeled(DSC.SAFE)
    static ReadWriteFloatArrayBuffer copy(FloatArrayBuffer other, int markOfOther) {
        ReadWriteFloatArrayBuffer buf =
                new ReadWriteFloatArrayBuffer(other.capacity(), other.backingArray, other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.122 -0400", hash_original_method = "497069A519BB7A8E272B0965E0C603B5", hash_generated_method = "143896A0CC84C6C2E06D360843AD5BBD")
    @Override
    public FloatBuffer asReadOnlyBuffer() {
        FloatBuffer varB4EAC82CA7396A68D541C85D26508E83_1340601185 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1340601185 = ReadOnlyFloatArrayBuffer.copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_1340601185.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1340601185;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.123 -0400", hash_original_method = "22708AB3F2B534798FB2EED23A67DC19", hash_generated_method = "55079638828DB0300ADFB6BF85B90B9C")
    @Override
    public FloatBuffer compact() {
        FloatBuffer varB4EAC82CA7396A68D541C85D26508E83_1743588644 = null; 
        System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        varB4EAC82CA7396A68D541C85D26508E83_1743588644 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1743588644.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1743588644;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.124 -0400", hash_original_method = "3E38DEB88805A3AD5A9BAFA46381EB46", hash_generated_method = "BD35E58C999B68EC117F471355A12201")
    @Override
    public FloatBuffer duplicate() {
        FloatBuffer varB4EAC82CA7396A68D541C85D26508E83_998945692 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_998945692 = copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_998945692.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_998945692;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.124 -0400", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "1225DD36E331CED5BD92026AC3C2D831")
    @Override
    public boolean isReadOnly() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1400591235 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1400591235;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.124 -0400", hash_original_method = "902CC876A0B5CBA68FC4A86CDFA0BAEB", hash_generated_method = "47A10CF14C835BE3D63F385473421FE2")
    @Override
    protected float[] protectedArray() {
        float[] varB2C245003BAB9224CFB496218F7DAFE0_2081196340 = {getTaintFloat()};
        return varB2C245003BAB9224CFB496218F7DAFE0_2081196340;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.124 -0400", hash_original_method = "F848F07A68FC53238B1B56C46C388C04", hash_generated_method = "5950D85CFF039FCA95A20E005DB301BA")
    @Override
    protected int protectedArrayOffset() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2000495977 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2000495977;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.125 -0400", hash_original_method = "504D4244F3E9BA0CFC7CEE21DED3336C", hash_generated_method = "6246B52A0F37578FED5C44415A9811ED")
    @Override
    protected boolean protectedHasArray() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_33260457 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_33260457;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.125 -0400", hash_original_method = "13B22E8941626D16AD9A1C582F86CDB9", hash_generated_method = "EDD8C10396596BB953B6F430EFC9287D")
    @Override
    public FloatBuffer put(float c) {
        FloatBuffer varB4EAC82CA7396A68D541C85D26508E83_675909751 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } 
        backingArray[offset + position++] = c;
        varB4EAC82CA7396A68D541C85D26508E83_675909751 = this;
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_675909751.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_675909751;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.126 -0400", hash_original_method = "DA3D1DBD794212B37FED89EC3B7543A3", hash_generated_method = "D49AEA2D8FC795AFED792172E2A8F465")
    @Override
    public FloatBuffer put(int index, float c) {
        FloatBuffer varB4EAC82CA7396A68D541C85D26508E83_1884715572 = null; 
        checkIndex(index);
        backingArray[offset + index] = c;
        varB4EAC82CA7396A68D541C85D26508E83_1884715572 = this;
        addTaint(index);
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_1884715572.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1884715572;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.127 -0400", hash_original_method = "596A2808C1B03A79358C8C3443A19501", hash_generated_method = "622E78187D08F6C0DEEA579CEE8F877E")
    @Override
    public FloatBuffer put(float[] src, int srcOffset, int floatCount) {
        FloatBuffer varB4EAC82CA7396A68D541C85D26508E83_1698863439 = null; 
        {
            boolean varE021C2AFD91F3DCFB06333FB83FDE7E4_219332804 = (floatCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
            } 
        } 
        System.arraycopy(src, srcOffset, backingArray, offset + position, floatCount);
        position += floatCount;
        varB4EAC82CA7396A68D541C85D26508E83_1698863439 = this;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(floatCount);
        varB4EAC82CA7396A68D541C85D26508E83_1698863439.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1698863439;
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.128 -0400", hash_original_method = "B98DF5C640FB2DE362AEC4E72A11F767", hash_generated_method = "922B38E0D4028320BBA095D147E599B4")
    @Override
    public FloatBuffer slice() {
        FloatBuffer varB4EAC82CA7396A68D541C85D26508E83_614095453 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_614095453 = new ReadWriteFloatArrayBuffer(remaining(), backingArray, offset + position);
        varB4EAC82CA7396A68D541C85D26508E83_614095453.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_614095453;
        
        
    }

    
}

