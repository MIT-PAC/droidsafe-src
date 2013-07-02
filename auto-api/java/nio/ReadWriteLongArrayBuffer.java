package java.nio;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

final class ReadWriteLongArrayBuffer extends LongArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.227 -0400", hash_original_method = "834F92961971218638A9D7B65E865A6A", hash_generated_method = "0BF1E72F9CDE48CDFF9B1041B1117CC0")
      ReadWriteLongArrayBuffer(long[] array) {
        super(array);
        addTaint(array[0]);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.227 -0400", hash_original_method = "B372464DEEDD255C23B3D6D2F6AC357B", hash_generated_method = "12326B1AE0736FDED662AAC5D35BA336")
      ReadWriteLongArrayBuffer(int capacity) {
        super(capacity);
        addTaint(capacity);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.227 -0400", hash_original_method = "D4CFA6531161D5EBB7847D86519768A8", hash_generated_method = "320D622C16E158AC75A4CDE278E017C9")
      ReadWriteLongArrayBuffer(int capacity, long[] backingArray, int arrayOffset) {
        super(capacity, backingArray, arrayOffset);
        addTaint(capacity);
        addTaint(backingArray[0]);
        addTaint(arrayOffset);
        
    }

    
    @DSModeled(DSC.SAFE)
    static ReadWriteLongArrayBuffer copy(LongArrayBuffer other, int markOfOther) {
        ReadWriteLongArrayBuffer buf =
                new ReadWriteLongArrayBuffer(other.capacity(), other.backingArray, other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.228 -0400", hash_original_method = "491DB95BA7040FC98389856362623E65", hash_generated_method = "E50A95EDA5F3BA6F5971FA55F18E4DDD")
    @Override
    public LongBuffer asReadOnlyBuffer() {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_1737743721 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1737743721 = ReadOnlyLongArrayBuffer.copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_1737743721.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1737743721;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.229 -0400", hash_original_method = "060222CDD5267DE677B9C3E035FABA38", hash_generated_method = "F754A371F27D2BBA98E9FA6AB29B7B1F")
    @Override
    public LongBuffer compact() {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_782127413 = null; 
        System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        varB4EAC82CA7396A68D541C85D26508E83_782127413 = this;
        varB4EAC82CA7396A68D541C85D26508E83_782127413.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_782127413;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.231 -0400", hash_original_method = "BCAEF14AE65D2F213653B4CB45E8B265", hash_generated_method = "8F188E745A5F3CCB81E1E91D8ACE3089")
    @Override
    public LongBuffer duplicate() {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_1682559446 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1682559446 = copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_1682559446.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1682559446;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.231 -0400", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "DFB1CA60CA489D24D6642BA14F243445")
    @Override
    public boolean isReadOnly() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1145407341 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1145407341;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.233 -0400", hash_original_method = "7F3F8A80822D5A0A92B191B6CC171534", hash_generated_method = "5B37B8CBA5BAB66BCE3A48415EA10354")
    @Override
    protected long[] protectedArray() {
        long[] var3908C7C3AF5171CEE1F112DAE77A5C4D_1276629432 = {getTaintLong()};
        return var3908C7C3AF5171CEE1F112DAE77A5C4D_1276629432;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.235 -0400", hash_original_method = "F848F07A68FC53238B1B56C46C388C04", hash_generated_method = "07B5FFDB18C1F71D1D360DB3EAD14FB9")
    @Override
    protected int protectedArrayOffset() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1977213170 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1977213170;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.236 -0400", hash_original_method = "504D4244F3E9BA0CFC7CEE21DED3336C", hash_generated_method = "C76495C4D5E3B2EF05B670FB24B2B1CA")
    @Override
    protected boolean protectedHasArray() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1220408916 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1220408916;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.237 -0400", hash_original_method = "425DFBE2ED449316EC67E343889A606E", hash_generated_method = "0424DB836639C11B23798589931C2961")
    @Override
    public LongBuffer put(long c) {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_1924567781 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } 
        backingArray[offset + position++] = c;
        varB4EAC82CA7396A68D541C85D26508E83_1924567781 = this;
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_1924567781.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1924567781;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.238 -0400", hash_original_method = "1D23D6036C356E1E5C3421A08A3084B8", hash_generated_method = "9D7284A5E71F2E3FB75E165BD04C71F6")
    @Override
    public LongBuffer put(int index, long c) {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_2055636350 = null; 
        checkIndex(index);
        backingArray[offset + index] = c;
        varB4EAC82CA7396A68D541C85D26508E83_2055636350 = this;
        addTaint(index);
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_2055636350.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2055636350;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.239 -0400", hash_original_method = "DEBADA2447C09B43BF32BF5E36B4652E", hash_generated_method = "4609A0F7D627F8E5F4A3376493627487")
    @Override
    public LongBuffer put(long[] src, int srcOffset, int longCount) {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_1719569604 = null; 
        {
            boolean var689C4001D724360528D46748438966DA_1227220233 = (longCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
            } 
        } 
        System.arraycopy(src, srcOffset, backingArray, offset + position, longCount);
        position += longCount;
        varB4EAC82CA7396A68D541C85D26508E83_1719569604 = this;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(longCount);
        varB4EAC82CA7396A68D541C85D26508E83_1719569604.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1719569604;
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.240 -0400", hash_original_method = "66DF3FBD18C3DE0FC10F7184B9F43E0E", hash_generated_method = "C88FAE7322EB679D40455B10F520A725")
    @Override
    public LongBuffer slice() {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_1245031327 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1245031327 = new ReadWriteLongArrayBuffer(remaining(), backingArray, offset + position);
        varB4EAC82CA7396A68D541C85D26508E83_1245031327.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1245031327;
        
        
    }

    
}

