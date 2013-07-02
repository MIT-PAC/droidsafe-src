package java.nio;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.Arrays;

public abstract class IntBuffer extends Buffer implements Comparable<IntBuffer> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.500 -0400", hash_original_method = "BC7C458D54C7EF00271779F9364447AB", hash_generated_method = "170567E1C278C9849B896D5CC60CA702")
      IntBuffer(int capacity) {
        super(2, capacity, null);
        addTaint(capacity);
        
    }

    
    @DSModeled(DSC.SAFE)
    public static IntBuffer allocate(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }
        return new ReadWriteIntArrayBuffer(capacity);
    }

    
    @DSModeled(DSC.SAFE)
    public static IntBuffer wrap(int[] array) {
        return wrap(array, 0, array.length);
    }

    
    @DSModeled(DSC.SAFE)
    public static IntBuffer wrap(int[] array, int start, int intCount) {
        Arrays.checkOffsetAndCount(array.length, start, intCount);
        IntBuffer buf = new ReadWriteIntArrayBuffer(array);
        buf.position = start;
        buf.limit = start + intCount;
        return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.502 -0400", hash_original_method = "D78164E532496862518F1BC4BDE62DEB", hash_generated_method = "08C9E0C846132CCA6E4D0BD1C7C620F6")
    public final int[] array() {
        int[] varEA57FBC16B997AC0E679F048893AC79C_631388190 = (protectedArray());
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_557386368 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_557386368;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.502 -0400", hash_original_method = "0D5EF56CBEA1DA16093A6276D10D9347", hash_generated_method = "7669695DBDC5A902DA0042359DD067E4")
    public final int arrayOffset() {
        int var457EDFAA982472962568D68CBF588B38_1347297039 = (protectedArrayOffset());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_262088330 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_262088330;
        
        
    }

    
    public abstract IntBuffer asReadOnlyBuffer();

    
    public abstract IntBuffer compact();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.506 -0400", hash_original_method = "E9F1AE5FDD3CB99604FBE90C4DDAAAAA", hash_generated_method = "427C3FB823781597824BDA882D1AC2AD")
    public int compareTo(IntBuffer otherBuffer) {
        int compareRemaining;
        boolean var4BCBF0874E5D33E29652A3CCB2245276_180834741 = ((remaining() < otherBuffer.remaining()));
        compareRemaining = remaining();
        compareRemaining = otherBuffer.remaining();
        int thisPos = position;
        int otherPos = otherBuffer.position;
        int thisInt;
        int otherInt;
        {
            thisInt = get(thisPos);
            otherInt = otherBuffer.get(otherPos);
        } 
        int var51CE6C8A0A6AF44D4BCA06BE06554AF8_1100038268 = (remaining() - otherBuffer.remaining());
        addTaint(otherBuffer.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1540445079 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1540445079;
        
        
                
        
        
        
        
            
            
            
                
            
            
            
            
        
        
    }

    
    public abstract IntBuffer duplicate();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.508 -0400", hash_original_method = "43D7EA8D2B4C608B648102E9AA040456", hash_generated_method = "B3CE08FDB22275619EF3536CB9019D0C")
    @Override
    public boolean equals(Object other) {
        IntBuffer otherBuffer = (IntBuffer) other;
        {
            boolean var0A43D7921CE313B818348D8F01F0C8D5_145797849 = (remaining() != otherBuffer.remaining());
        } 
        int myPosition = position;
        int otherPosition = otherBuffer.position;
        boolean equalSoFar = true;
        {
            equalSoFar = get(myPosition++) == otherBuffer.get(otherPosition++);
        } 
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_866294394 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_866294394;
        
        
            
        
        
        
            
        
        
        
        
        
            
        
        
    }

    
    public abstract int get();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.509 -0400", hash_original_method = "257B404B7D2C714566C75E4EA0767CA2", hash_generated_method = "5F711F23133830E25292CD12690806EA")
    public IntBuffer get(int[] dst) {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_1670716812 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1670716812 = get(dst, 0, dst.length);
        addTaint(dst[0]);
        varB4EAC82CA7396A68D541C85D26508E83_1670716812.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1670716812;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.510 -0400", hash_original_method = "72F522BE346D267FC1DB76B8F081AACA", hash_generated_method = "1EDC8A3F69950148D995716E491F83A5")
    public IntBuffer get(int[] dst, int dstOffset, int intCount) {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_1388719159 = null; 
        Arrays.checkOffsetAndCount(dst.length, dstOffset, intCount);
        {
            boolean var88D58DBFE8E26BEBC18FDE3265CF76EF_1955171607 = (intCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
            } 
        } 
        {
            int i = dstOffset;
            {
                dst[i] = get();
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1388719159 = this;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(intCount);
        varB4EAC82CA7396A68D541C85D26508E83_1388719159.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1388719159;
        
        
        
            
        
        
            
        
        
    }

    
    public abstract int get(int index);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.510 -0400", hash_original_method = "89C81F0EAF8FCCBFE368437CC8972DD7", hash_generated_method = "CBD443779A696DE244B01928F5068F13")
    public final boolean hasArray() {
        boolean varADF219B8DAB0ACF2FCC593A6A216A7F8_569557199 = (protectedHasArray());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1515546839 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1515546839;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.511 -0400", hash_original_method = "371FAD0CF0C9AC8E78075F4EA52336BD", hash_generated_method = "318A176F38D9A8D2BF27CA3C3FD81137")
    @Override
    public int hashCode() {
        int myPosition = position;
        int hash = 0;
        {
            hash = hash + get(myPosition++);
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_655304826 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_655304826;
        
        
        
        
            
        
        
    }

    
    public abstract boolean isDirect();

    
    public abstract ByteOrder order();

    
    abstract int[] protectedArray();

    
    abstract int protectedArrayOffset();

    
    abstract boolean protectedHasArray();

    
    public abstract IntBuffer put(int i);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.513 -0400", hash_original_method = "C57984865448BE8CC42F7EA5DB727833", hash_generated_method = "CF6642A76DFF777FE3CB3CD859F6F715")
    public final IntBuffer put(int[] src) {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_209113072 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_209113072 = put(src, 0, src.length);
        addTaint(src[0]);
        varB4EAC82CA7396A68D541C85D26508E83_209113072.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_209113072;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.515 -0400", hash_original_method = "E12C5DD5606B4F94202BB1F980DCA32C", hash_generated_method = "C1DA7BCC96E855F97605B9F830D83443")
    public IntBuffer put(int[] src, int srcOffset, int intCount) {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_1959100251 = null; 
        Arrays.checkOffsetAndCount(src.length, srcOffset, intCount);
        {
            boolean var88D58DBFE8E26BEBC18FDE3265CF76EF_1849369345 = (intCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
            } 
        } 
        {
            int i = srcOffset;
            {
                put(src[i]);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1959100251 = this;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(intCount);
        varB4EAC82CA7396A68D541C85D26508E83_1959100251.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1959100251;
        
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.516 -0400", hash_original_method = "874C21D5B52E872502D97AA1BF44CEA1", hash_generated_method = "1AB9B5AE2597F36B8E0B82E6114E3363")
    public IntBuffer put(IntBuffer src) {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_876869482 = null; 
        {
            boolean var9C07FD71E9483B067CE073F58225A0C4_188084575 = (src == this);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } 
        } 
        {
            boolean var6E2E81EBCD4D9A6ACDDC12CE61513AA8_609533159 = (src.remaining() > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
            } 
        } 
        int[] contents = new int[src.remaining()];
        src.get(contents);
        put(contents);
        varB4EAC82CA7396A68D541C85D26508E83_876869482 = this;
        addTaint(src.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_876869482.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_876869482;
        
        
            
        
        
            
        
        
        
        
        
    }

    
    public abstract IntBuffer put(int index, int i);

    
    public abstract IntBuffer slice();

    
}

