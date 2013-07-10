package java.nio;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.Arrays;

public abstract class LongBuffer extends Buffer implements Comparable<LongBuffer> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.639 -0400", hash_original_method = "3A9B5F2A82543AF360E63C0F2EA35C03", hash_generated_method = "41849BA7BDC3CE94FF819BE93189CEF6")
      LongBuffer(int capacity) {
        super(3, capacity, null);
        addTaint(capacity);
        
    }

    
    @DSModeled(DSC.SAFE)
    public static LongBuffer allocate(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }
        return new ReadWriteLongArrayBuffer(capacity);
    }

    
    @DSModeled(DSC.SAFE)
    public static LongBuffer wrap(long[] array) {
        return wrap(array, 0, array.length);
    }

    
    @DSModeled(DSC.SAFE)
    public static LongBuffer wrap(long[] array, int start, int longCount) {
        Arrays.checkOffsetAndCount(array.length, start, longCount);
        LongBuffer buf = new ReadWriteLongArrayBuffer(array);
        buf.position = start;
        buf.limit = start + longCount;
        return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.640 -0400", hash_original_method = "4BA44AB0CDCB187F799C2188A053FC10", hash_generated_method = "3D1A641BC08232065E06D2D3D859F7B5")
    public final long[] array() {
        long[] varEA57FBC16B997AC0E679F048893AC79C_1685980285 = (protectedArray());
        long[] var3908C7C3AF5171CEE1F112DAE77A5C4D_1819241817 = {getTaintLong()};
        return var3908C7C3AF5171CEE1F112DAE77A5C4D_1819241817;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.640 -0400", hash_original_method = "0D5EF56CBEA1DA16093A6276D10D9347", hash_generated_method = "A5064B58AC57ECF21EB8CB03845ECC52")
    public final int arrayOffset() {
        int var457EDFAA982472962568D68CBF588B38_1988906617 = (protectedArrayOffset());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1628525623 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1628525623;
        
        
    }

    
    public abstract LongBuffer asReadOnlyBuffer();

    
    public abstract LongBuffer compact();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.641 -0400", hash_original_method = "FEA629F677F50B81610B0F350A8DD419", hash_generated_method = "7E49AC70AAA408D9764C3F9A9483A11C")
    public int compareTo(LongBuffer otherBuffer) {
        int compareRemaining;
        boolean var4BCBF0874E5D33E29652A3CCB2245276_14029503 = ((remaining() < otherBuffer.remaining()));
        compareRemaining = remaining();
        compareRemaining = otherBuffer.remaining();
        int thisPos = position;
        int otherPos = otherBuffer.position;
        long thisLong;
        long otherLong;
        {
            thisLong = get(thisPos);
            otherLong = otherBuffer.get(otherPos);
        } 
        int var51CE6C8A0A6AF44D4BCA06BE06554AF8_1344367176 = (remaining() - otherBuffer.remaining());
        addTaint(otherBuffer.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_975820621 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_975820621;
        
        
                
        
        
        
        
            
            
            
                
            
            
            
            
        
        
    }

    
    public abstract LongBuffer duplicate();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.643 -0400", hash_original_method = "D82E6566C9B77850C7E0596D73483706", hash_generated_method = "76AA137A5E3939280264548A38A38BD4")
    @Override
    public boolean equals(Object other) {
        LongBuffer otherBuffer = (LongBuffer) other;
        {
            boolean var0A43D7921CE313B818348D8F01F0C8D5_66641770 = (remaining() != otherBuffer.remaining());
        } 
        int myPosition = position;
        int otherPosition = otherBuffer.position;
        boolean equalSoFar = true;
        {
            equalSoFar = get(myPosition++) == otherBuffer.get(otherPosition++);
        } 
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1919643610 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1919643610;
        
        
            
        
        
        
            
        
        
        
        
        
            
        
        
    }

    
    public abstract long get();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.644 -0400", hash_original_method = "D4B2A0425DC120EC01BAEA51D6880E08", hash_generated_method = "935589D0613CFFBBAFCBD25FE45FEFFD")
    public LongBuffer get(long[] dst) {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_1359133799 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1359133799 = get(dst, 0, dst.length);
        addTaint(dst[0]);
        varB4EAC82CA7396A68D541C85D26508E83_1359133799.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1359133799;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.645 -0400", hash_original_method = "22F3DDD60BBBE627A1DDE8F148E9CD33", hash_generated_method = "08C7084EDF1823E6C89B1AFA92EEC88C")
    public LongBuffer get(long[] dst, int dstOffset, int longCount) {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_1347254014 = null; 
        Arrays.checkOffsetAndCount(dst.length, dstOffset, longCount);
        {
            boolean var689C4001D724360528D46748438966DA_540825680 = (longCount > remaining());
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
        varB4EAC82CA7396A68D541C85D26508E83_1347254014 = this;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(longCount);
        varB4EAC82CA7396A68D541C85D26508E83_1347254014.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1347254014;
        
        
        
            
        
        
            
        
        
    }

    
    public abstract long get(int index);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.645 -0400", hash_original_method = "89C81F0EAF8FCCBFE368437CC8972DD7", hash_generated_method = "9BBA0D75BE30B350EBE63498CFE80BB1")
    public final boolean hasArray() {
        boolean varADF219B8DAB0ACF2FCC593A6A216A7F8_2065241843 = (protectedHasArray());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_70123178 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_70123178;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.646 -0400", hash_original_method = "5C7ADDF6CA5903C3487F2A9B009FDDB4", hash_generated_method = "38C8A21F228BEEF8D2E52EA2601F8917")
    @Override
    public int hashCode() {
        int myPosition = position;
        int hash = 0;
        long l;
        {
            l = get(myPosition++);
            hash = hash + ((int) l) ^ ((int) (l >> 32));
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1079882204 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1079882204;
        
        
        
        
        
            
            
        
        
    }

    
    public abstract boolean isDirect();

    
    public abstract ByteOrder order();

    
    abstract long[] protectedArray();

    
    abstract int protectedArrayOffset();

    
    abstract boolean protectedHasArray();

    
    public abstract LongBuffer put(long l);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.647 -0400", hash_original_method = "5A5A365AB2651722CE67CD635F8A83E0", hash_generated_method = "16040215FD2BA2580197C0D7DD0EAC55")
    public final LongBuffer put(long[] src) {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_1620292628 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1620292628 = put(src, 0, src.length);
        addTaint(src[0]);
        varB4EAC82CA7396A68D541C85D26508E83_1620292628.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1620292628;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.648 -0400", hash_original_method = "B57657AA1D79DC46C889A6E8179D7A18", hash_generated_method = "948DFE6D3E4534ADB6D9E385D22E2A01")
    public LongBuffer put(long[] src, int srcOffset, int longCount) {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_2072050418 = null; 
        Arrays.checkOffsetAndCount(src.length, srcOffset, longCount);
        {
            boolean var689C4001D724360528D46748438966DA_1059060410 = (longCount > remaining());
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
        varB4EAC82CA7396A68D541C85D26508E83_2072050418 = this;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(longCount);
        varB4EAC82CA7396A68D541C85D26508E83_2072050418.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2072050418;
        
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.649 -0400", hash_original_method = "268B2EFE55B01F54F51A1709DBD7F8C3", hash_generated_method = "D2E3E8714B60F58FD867F917C90482ED")
    public LongBuffer put(LongBuffer src) {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_516701534 = null; 
        {
            boolean var9C07FD71E9483B067CE073F58225A0C4_1588026201 = (src == this);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } 
        } 
        {
            boolean var6E2E81EBCD4D9A6ACDDC12CE61513AA8_382502238 = (src.remaining() > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
            } 
        } 
        long[] contents = new long[src.remaining()];
        src.get(contents);
        put(contents);
        varB4EAC82CA7396A68D541C85D26508E83_516701534 = this;
        addTaint(src.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_516701534.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_516701534;
        
        
            
        
        
            
        
        
        
        
        
    }

    
    public abstract LongBuffer put(int index, long l);

    
    public abstract LongBuffer slice();

    
}

