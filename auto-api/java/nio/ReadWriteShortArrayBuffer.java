package java.nio;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

final class ReadWriteShortArrayBuffer extends ShortArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.251 -0400", hash_original_method = "8E9D34BCCAE8E429C96FDCF9DF5CAB41", hash_generated_method = "55B4923DA3F935D80CF9E9294A9995E3")
      ReadWriteShortArrayBuffer(short[] array) {
        super(array);
        addTaint(array[0]);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.251 -0400", hash_original_method = "D514769C5D5F8B6E9B68E0333601C0ED", hash_generated_method = "231BB39C0D50E7FFC13D6EB0885AFC60")
      ReadWriteShortArrayBuffer(int capacity) {
        super(capacity);
        addTaint(capacity);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.252 -0400", hash_original_method = "9C56AF79FD26FC5F344A35E3553FC338", hash_generated_method = "54BC2C5B47493D743460EFCD83C4DF7B")
      ReadWriteShortArrayBuffer(int capacity, short[] backingArray,
            int arrayOffset) {
        super(capacity, backingArray, arrayOffset);
        addTaint(capacity);
        addTaint(backingArray[0]);
        addTaint(arrayOffset);
        
    }

    
    @DSModeled(DSC.SAFE)
    static ReadWriteShortArrayBuffer copy(ShortArrayBuffer other, int markOfOther) {
        ReadWriteShortArrayBuffer buf =
                new ReadWriteShortArrayBuffer(other.capacity(), other.backingArray, other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.252 -0400", hash_original_method = "462C3B568A7739CEDBF963B6B469485C", hash_generated_method = "351213274AB8AE69DD39CD3CCFB6AC78")
    @Override
    public ShortBuffer asReadOnlyBuffer() {
        ShortBuffer varB4EAC82CA7396A68D541C85D26508E83_183179393 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_183179393 = ReadOnlyShortArrayBuffer.copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_183179393.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_183179393;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.253 -0400", hash_original_method = "36F9748654A1F1F28EBEE4901281019B", hash_generated_method = "604163DF2BAFD48F27B28E893C15A84A")
    @Override
    public ShortBuffer compact() {
        ShortBuffer varB4EAC82CA7396A68D541C85D26508E83_651127035 = null; 
        System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        varB4EAC82CA7396A68D541C85D26508E83_651127035 = this;
        varB4EAC82CA7396A68D541C85D26508E83_651127035.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_651127035;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.254 -0400", hash_original_method = "F49238B32F318D341B9FD2839B701A87", hash_generated_method = "4C077F31809CD465AA919FC03CF42E72")
    @Override
    public ShortBuffer duplicate() {
        ShortBuffer varB4EAC82CA7396A68D541C85D26508E83_473832100 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_473832100 = copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_473832100.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_473832100;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.255 -0400", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "2A916CF82053C105C8D07F491237EF9F")
    @Override
    public boolean isReadOnly() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1628805676 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1628805676;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.255 -0400", hash_original_method = "085A06B6EDE16089D63E0B4E0858AD77", hash_generated_method = "1F68BB4A2523ACAC4832D0645A7A3A93")
    @Override
    protected short[] protectedArray() {
        short[] var48EE7E2DDF8A83602BC526873BD0F875_1899015839 = {getTaintShort()};
        return var48EE7E2DDF8A83602BC526873BD0F875_1899015839;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.255 -0400", hash_original_method = "F848F07A68FC53238B1B56C46C388C04", hash_generated_method = "42A12EB7DF5CB97CC45F8F24A92FB1D8")
    @Override
    protected int protectedArrayOffset() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_232356189 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_232356189;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.256 -0400", hash_original_method = "504D4244F3E9BA0CFC7CEE21DED3336C", hash_generated_method = "DE776F7A1DC374EA76BD2E1D0AF1BE81")
    @Override
    protected boolean protectedHasArray() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2100705863 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2100705863;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.257 -0400", hash_original_method = "54E323A30539354E0A95916606A58A4C", hash_generated_method = "DC608C77BFACA4C37FBD3F99002B624B")
    @Override
    public ShortBuffer put(short c) {
        ShortBuffer varB4EAC82CA7396A68D541C85D26508E83_1607629822 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } 
        backingArray[offset + position++] = c;
        varB4EAC82CA7396A68D541C85D26508E83_1607629822 = this;
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_1607629822.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1607629822;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.259 -0400", hash_original_method = "40ADB3B61FB69E1E8C75AAC651E43068", hash_generated_method = "D5B8AAF9DE5466E996E3ADB56D000051")
    @Override
    public ShortBuffer put(int index, short c) {
        ShortBuffer varB4EAC82CA7396A68D541C85D26508E83_2026306567 = null; 
        checkIndex(index);
        backingArray[offset + index] = c;
        varB4EAC82CA7396A68D541C85D26508E83_2026306567 = this;
        addTaint(index);
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_2026306567.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2026306567;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.260 -0400", hash_original_method = "2F2CA14AF95FC5682B6555E8CB32AB80", hash_generated_method = "E8798D03F39D8BF8344C4B8538E0134B")
    @Override
    public ShortBuffer put(short[] src, int srcOffset, int shortCount) {
        ShortBuffer varB4EAC82CA7396A68D541C85D26508E83_529593502 = null; 
        {
            boolean varD727A1D2181C264BA4333582F807AE27_1756943118 = (shortCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
            } 
        } 
        System.arraycopy(src, srcOffset, backingArray, offset + position, shortCount);
        position += shortCount;
        varB4EAC82CA7396A68D541C85D26508E83_529593502 = this;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(shortCount);
        varB4EAC82CA7396A68D541C85D26508E83_529593502.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_529593502;
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.261 -0400", hash_original_method = "295BE67A092E5DAA08585681B1E9120C", hash_generated_method = "B5728A17CF6613868CABDDADE4BCFD2A")
    @Override
    public ShortBuffer slice() {
        ShortBuffer varB4EAC82CA7396A68D541C85D26508E83_127595796 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_127595796 = new ReadWriteShortArrayBuffer(remaining(), backingArray, offset + position);
        varB4EAC82CA7396A68D541C85D26508E83_127595796.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_127595796;
        
        
    }

    
}

