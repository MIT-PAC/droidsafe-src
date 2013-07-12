package java.nio;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Arrays;

public abstract class IntBuffer extends Buffer implements Comparable<IntBuffer> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.662 -0400", hash_original_method = "BC7C458D54C7EF00271779F9364447AB", hash_generated_method = "170567E1C278C9849B896D5CC60CA702")
      IntBuffer(int capacity) {
        super(2, capacity, null);
        addTaint(capacity);
        
    }

    
        public static IntBuffer allocate(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }
        return new ReadWriteIntArrayBuffer(capacity);
    }

    
        public static IntBuffer wrap(int[] array) {
        return wrap(array, 0, array.length);
    }

    
        public static IntBuffer wrap(int[] array, int start, int intCount) {
        Arrays.checkOffsetAndCount(array.length, start, intCount);
        IntBuffer buf = new ReadWriteIntArrayBuffer(array);
        buf.position = start;
        buf.limit = start + intCount;
        return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.663 -0400", hash_original_method = "D78164E532496862518F1BC4BDE62DEB", hash_generated_method = "CD0A80FD9D91C63071F038C00DB9231B")
    public final int[] array() {
        int[] var68B89E48382A0AA51B25AC59599E2EB0_1488513519 = (protectedArray());
                int[] varB4CCCA26F9DB9189C32F33E82D425CFB_1198901889 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_1198901889;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.664 -0400", hash_original_method = "0D5EF56CBEA1DA16093A6276D10D9347", hash_generated_method = "A78CE6586F45A909C0B3F9979487645F")
    public final int arrayOffset() {
        int var0B794CE56A38A9F3BFDD2D53E83BB109_582236738 = (protectedArrayOffset());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_956906060 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_956906060;
        
        
    }

    
    public abstract IntBuffer asReadOnlyBuffer();

    
    public abstract IntBuffer compact();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.665 -0400", hash_original_method = "E9F1AE5FDD3CB99604FBE90C4DDAAAAA", hash_generated_method = "D340ADF7BACD0F515968F896D97F5FEA")
    public int compareTo(IntBuffer otherBuffer) {
        addTaint(otherBuffer.getTaint());
        int compareRemaining = (remaining() < otherBuffer.remaining()) ? remaining()
                : otherBuffer.remaining();
        int thisPos = position;
        int otherPos = otherBuffer.position;
        int thisInt;
        int otherInt;
        while
(compareRemaining > 0)        
        {
            thisInt = get(thisPos);
            otherInt = otherBuffer.get(otherPos);
    if(thisInt != otherInt)            
            {
                int varB0A2C415E738F4ACAE648837EC3182E5_1339583663 = (thisInt < otherInt ? -1 : 1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_974941455 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_974941455;
            } 
            thisPos++;
            otherPos++;
            compareRemaining--;
        } 
        int var1DC167191FBC7DAD3BADAE830552C692_339652201 = (remaining() - otherBuffer.remaining());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_920361522 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_920361522;
        
        
                
        
        
        
        
            
            
            
                
            
            
            
            
        
        
    }

    
    public abstract IntBuffer duplicate();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.666 -0400", hash_original_method = "43D7EA8D2B4C608B648102E9AA040456", hash_generated_method = "7D55B06E4DEE42020405B07D751530FF")
    @Override
    public boolean equals(Object other) {
        addTaint(other.getTaint());
    if(!(other instanceof IntBuffer))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1326627971 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_120841923 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_120841923;
        } 
        IntBuffer otherBuffer = (IntBuffer) other;
    if(remaining() != otherBuffer.remaining())        
        {
            boolean var68934A3E9455FA72420237EB05902327_473034214 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1557788975 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1557788975;
        } 
        int myPosition = position;
        int otherPosition = otherBuffer.position;
        boolean equalSoFar = true;
        while
(equalSoFar && (myPosition < limit))        
        {
            equalSoFar = get(myPosition++) == otherBuffer.get(otherPosition++);
        } 
        boolean var4A97EF18B93B276118DD50585250A586_445701176 = (equalSoFar);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_989036796 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_989036796;
        
        
            
        
        
        
            
        
        
        
        
        
            
        
        
    }

    
    public abstract int get();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.667 -0400", hash_original_method = "257B404B7D2C714566C75E4EA0767CA2", hash_generated_method = "37F413463CA3F1043A68F9AC345C24FE")
    public IntBuffer get(int[] dst) {
        addTaint(dst[0]);
IntBuffer varAF8F268F60258FE30F192DE78F11CD4A_671827168 =         get(dst, 0, dst.length);
        varAF8F268F60258FE30F192DE78F11CD4A_671827168.addTaint(taint);
        return varAF8F268F60258FE30F192DE78F11CD4A_671827168;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.668 -0400", hash_original_method = "72F522BE346D267FC1DB76B8F081AACA", hash_generated_method = "FCEFB4FD15367FCE3A06AD06663E244C")
    public IntBuffer get(int[] dst, int dstOffset, int intCount) {
        addTaint(intCount);
        addTaint(dstOffset);
        addTaint(dst[0]);
        Arrays.checkOffsetAndCount(dst.length, dstOffset, intCount);
    if(intCount > remaining())        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_64701102 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_64701102.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_64701102;
        } 
for(int i = dstOffset;i < dstOffset + intCount;++i)
        {
            dst[i] = get();
        } 
IntBuffer var72A74007B2BE62B849F475C7BDA4658B_1429833645 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1429833645.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1429833645;
        
        
        
            
        
        
            
        
        
    }

    
    public abstract int get(int index);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.669 -0400", hash_original_method = "89C81F0EAF8FCCBFE368437CC8972DD7", hash_generated_method = "78DFF16376D4011675A08CFB90CB086A")
    public final boolean hasArray() {
        boolean var55B7C03E3C1EBABD22606AD17EE923C3_1746117030 = (protectedHasArray());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2121903589 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2121903589;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.670 -0400", hash_original_method = "371FAD0CF0C9AC8E78075F4EA52336BD", hash_generated_method = "8A40E5945160534E5FEACD8CBB76FF0F")
    @Override
    public int hashCode() {
        int myPosition = position;
        int hash = 0;
        while
(myPosition < limit)        
        {
            hash = hash + get(myPosition++);
        } 
        int var0800FC577294C34E0B28AD2839435945_734184683 = (hash);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_925860768 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_925860768;
        
        
        
        
            
        
        
    }

    
    public abstract boolean isDirect();

    
    public abstract ByteOrder order();

    
    abstract int[] protectedArray();

    
    abstract int protectedArrayOffset();

    
    abstract boolean protectedHasArray();

    
    public abstract IntBuffer put(int i);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.672 -0400", hash_original_method = "C57984865448BE8CC42F7EA5DB727833", hash_generated_method = "875251428054C9D7BD947CE19DFE7926")
    public final IntBuffer put(int[] src) {
        addTaint(src[0]);
IntBuffer var7D505613BED257805463C43ADCB4DBAD_338814675 =         put(src, 0, src.length);
        var7D505613BED257805463C43ADCB4DBAD_338814675.addTaint(taint);
        return var7D505613BED257805463C43ADCB4DBAD_338814675;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.672 -0400", hash_original_method = "E12C5DD5606B4F94202BB1F980DCA32C", hash_generated_method = "D91BB3E0EAC1F212468AFAD6DD94B3A9")
    public IntBuffer put(int[] src, int srcOffset, int intCount) {
        addTaint(intCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        Arrays.checkOffsetAndCount(src.length, srcOffset, intCount);
    if(intCount > remaining())        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_352493025 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_352493025.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_352493025;
        } 
for(int i = srcOffset;i < srcOffset + intCount;++i)
        {
            put(src[i]);
        } 
IntBuffer var72A74007B2BE62B849F475C7BDA4658B_1468169880 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1468169880.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1468169880;
        
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.673 -0400", hash_original_method = "874C21D5B52E872502D97AA1BF44CEA1", hash_generated_method = "4B133FCF08ADE2080C1F64D336F05338")
    public IntBuffer put(IntBuffer src) {
        addTaint(src.getTaint());
    if(src == this)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_77404571 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_77404571.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_77404571;
        } 
    if(src.remaining() > remaining())        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_325745535 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_325745535.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_325745535;
        } 
        int[] contents = new int[src.remaining()];
        src.get(contents);
        put(contents);
IntBuffer var72A74007B2BE62B849F475C7BDA4658B_1976841134 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1976841134.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1976841134;
        
        
            
        
        
            
        
        
        
        
        
    }

    
    public abstract IntBuffer put(int index, int i);

    
    public abstract IntBuffer slice();

    
}

