package java.nio;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.Arrays;

public abstract class DoubleBuffer extends Buffer implements Comparable<DoubleBuffer> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.137 -0400", hash_original_method = "0AF8846C39B4C946E7DEA048FA516A89", hash_generated_method = "E632E4EC7764C222EF3E3833B184A64D")
      DoubleBuffer(int capacity) {
        super(3, capacity, null);
        addTaint(capacity);
        
    }

    
    @DSModeled(DSC.SAFE)
    public static DoubleBuffer allocate(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }
        return new ReadWriteDoubleArrayBuffer(capacity);
    }

    
    @DSModeled(DSC.SAFE)
    public static DoubleBuffer wrap(double[] array) {
        return wrap(array, 0, array.length);
    }

    
    @DSModeled(DSC.SAFE)
    public static DoubleBuffer wrap(double[] array, int start, int doubleCount) {
        Arrays.checkOffsetAndCount(array.length, start, doubleCount);
        DoubleBuffer buf = new ReadWriteDoubleArrayBuffer(array);
        buf.position = start;
        buf.limit = start + doubleCount;
        return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.138 -0400", hash_original_method = "A99B5F03AD18580EAA75CC7BA40FC0CE", hash_generated_method = "E8054ED2F785EB9AD8C836DA8909EDBD")
    public final double[] array() {
        double[] varEA57FBC16B997AC0E679F048893AC79C_766105192 = (protectedArray());
        double[] var74D44D7D9EE6FE6C3433D694F869E521_1197207219 = {getTaintDouble()};
        return var74D44D7D9EE6FE6C3433D694F869E521_1197207219;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.139 -0400", hash_original_method = "0D5EF56CBEA1DA16093A6276D10D9347", hash_generated_method = "A51861040EC3DD4A5DF782331795BC2E")
    public final int arrayOffset() {
        int var457EDFAA982472962568D68CBF588B38_867598727 = (protectedArrayOffset());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_969332256 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_969332256;
        
        
    }

    
    public abstract DoubleBuffer asReadOnlyBuffer();

    
    public abstract DoubleBuffer compact();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.139 -0400", hash_original_method = "A9C47546143A1E2A817B74D1052E5DC9", hash_generated_method = "1156DF8DDAAB964F6257C085CB2CA76A")
    public int compareTo(DoubleBuffer otherBuffer) {
        int compareRemaining;
        boolean var4BCBF0874E5D33E29652A3CCB2245276_1072845800 = ((remaining() < otherBuffer.remaining()));
        compareRemaining = remaining();
        compareRemaining = otherBuffer.remaining();
        int thisPos = position;
        int otherPos = otherBuffer.position;
        double thisDouble;
        double otherDouble;
        {
            thisDouble = get(thisPos);
            otherDouble = otherBuffer.get(otherPos);
        } 
        int var51CE6C8A0A6AF44D4BCA06BE06554AF8_811634497 = (remaining() - otherBuffer.remaining());
        addTaint(otherBuffer.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1778163260 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1778163260;
        
        
                
        
        
        
        
            
            
            
                    
                
            
            
            
            
        
        
    }

    
    public abstract DoubleBuffer duplicate();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.141 -0400", hash_original_method = "80D65346F74BD859AA9774E55290B1E1", hash_generated_method = "110FA220BA955322E41CF75CE05617D1")
    @Override
    public boolean equals(Object other) {
        DoubleBuffer otherBuffer = (DoubleBuffer) other;
        {
            boolean var0A43D7921CE313B818348D8F01F0C8D5_66642376 = (remaining() != otherBuffer.remaining());
        } 
        int myPosition = position;
        int otherPosition = otherBuffer.position;
        boolean equalSoFar = true;
        {
            double a = get(myPosition++);
            double b = otherBuffer.get(otherPosition++);
            equalSoFar = a == b || (a != a && b != b);
        } 
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1544007564 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1544007564;
        
        
            
        
        
        
            
        
        
        
        
        
            
            
            
        
        
    }

    
    public abstract double get();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.142 -0400", hash_original_method = "9BEB92FAE64B1253EE6CA9009E99F3B4", hash_generated_method = "AEF6995B0EB40E0C9218EAC6DBF57662")
    public DoubleBuffer get(double[] dst) {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_1966504157 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1966504157 = get(dst, 0, dst.length);
        addTaint(dst[0]);
        varB4EAC82CA7396A68D541C85D26508E83_1966504157.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1966504157;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.143 -0400", hash_original_method = "38134BA6A99F502238B51F3879F810C3", hash_generated_method = "60192BFE6C3F2E6B019D5F5B78EC6695")
    public DoubleBuffer get(double[] dst, int dstOffset, int doubleCount) {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_379009786 = null; 
        Arrays.checkOffsetAndCount(dst.length, dstOffset, doubleCount);
        {
            boolean var74C0A42AB3BAE67C7C3CC56E2CA2CC6D_1827516844 = (doubleCount > remaining());
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
        varB4EAC82CA7396A68D541C85D26508E83_379009786 = this;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(doubleCount);
        varB4EAC82CA7396A68D541C85D26508E83_379009786.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_379009786;
        
        
        
            
        
        
            
        
        
    }

    
    public abstract double get(int index);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.143 -0400", hash_original_method = "89C81F0EAF8FCCBFE368437CC8972DD7", hash_generated_method = "3545A3471DD4EBEDA77D35A87F7D3F5C")
    public final boolean hasArray() {
        boolean varADF219B8DAB0ACF2FCC593A6A216A7F8_1669910663 = (protectedHasArray());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1129549762 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1129549762;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.144 -0400", hash_original_method = "BF88872009B539EF877B1EA5B03706BA", hash_generated_method = "B6AF2852F06FDDC98AB71C74FDA22D6E")
    @Override
    public int hashCode() {
        int myPosition = position;
        int hash = 0;
        long l;
        {
            l = Double.doubleToLongBits(get(myPosition++));
            hash = hash + ((int) l) ^ ((int) (l >> 32));
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1366972562 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1366972562;
        
        
        
        
        
            
            
        
        
    }

    
    public abstract boolean isDirect();

    
    public abstract ByteOrder order();

    
    abstract double[] protectedArray();

    
    abstract int protectedArrayOffset();

    
    abstract boolean protectedHasArray();

    
    public abstract DoubleBuffer put(double d);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.145 -0400", hash_original_method = "93B6D9B754146968969402F4C9473429", hash_generated_method = "94EE8B49F30440282A4C40F381E59E1A")
    public final DoubleBuffer put(double[] src) {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_852036613 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_852036613 = put(src, 0, src.length);
        addTaint(src[0]);
        varB4EAC82CA7396A68D541C85D26508E83_852036613.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_852036613;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.146 -0400", hash_original_method = "3E73039BF6DB142176253DE2263B83AD", hash_generated_method = "809562A8C72DE19B79995ABC63E9BC8A")
    public DoubleBuffer put(double[] src, int srcOffset, int doubleCount) {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_551712169 = null; 
        Arrays.checkOffsetAndCount(src.length, srcOffset, doubleCount);
        {
            boolean var74C0A42AB3BAE67C7C3CC56E2CA2CC6D_526667664 = (doubleCount > remaining());
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
        varB4EAC82CA7396A68D541C85D26508E83_551712169 = this;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(doubleCount);
        varB4EAC82CA7396A68D541C85D26508E83_551712169.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_551712169;
        
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.146 -0400", hash_original_method = "C52ECDE4782921BA374F433E41853287", hash_generated_method = "7E5C8A1BAEDD5F2437ED1BC5344FE6C9")
    public DoubleBuffer put(DoubleBuffer src) {
        DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_17156690 = null; 
        {
            boolean var9C07FD71E9483B067CE073F58225A0C4_1477027250 = (src == this);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } 
        } 
        {
            boolean var6E2E81EBCD4D9A6ACDDC12CE61513AA8_519506421 = (src.remaining() > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
            } 
        } 
        double[] doubles = new double[src.remaining()];
        src.get(doubles);
        put(doubles);
        varB4EAC82CA7396A68D541C85D26508E83_17156690 = this;
        addTaint(src.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_17156690.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_17156690;
        
        
            
        
        
            
        
        
        
        
        
    }

    
    public abstract DoubleBuffer put(int index, double d);

    
    public abstract DoubleBuffer slice();

    
}

