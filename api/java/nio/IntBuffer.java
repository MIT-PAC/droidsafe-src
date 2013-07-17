package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Arrays;

public abstract class IntBuffer extends Buffer implements Comparable<IntBuffer> {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.143 -0400", hash_original_method = "BC7C458D54C7EF00271779F9364447AB", hash_generated_method = "170567E1C278C9849B896D5CC60CA702")
      IntBuffer(int capacity) {
        super(2, capacity, null);
        addTaint(capacity);
        // ---------- Original Method ----------
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.145 -0400", hash_original_method = "D78164E532496862518F1BC4BDE62DEB", hash_generated_method = "98418B2A36CE3D3A044C12FD219EE92B")
    public final int[] array() {
        int[] var68B89E48382A0AA51B25AC59599E2EB0_212699667 = (protectedArray());
                int[] varB4CCCA26F9DB9189C32F33E82D425CFB_1539914670 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_1539914670;
        // ---------- Original Method ----------
        //return protectedArray();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.146 -0400", hash_original_method = "0D5EF56CBEA1DA16093A6276D10D9347", hash_generated_method = "8566E1FCAE73BE912DF46A3F5C78E21A")
    public final int arrayOffset() {
        int var0B794CE56A38A9F3BFDD2D53E83BB109_960044091 = (protectedArrayOffset());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_904901306 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_904901306;
        // ---------- Original Method ----------
        //return protectedArrayOffset();
    }

    
    @DSModeled(DSC.SAFE)
    public abstract IntBuffer asReadOnlyBuffer();

    
    @DSModeled(DSC.SAFE)
    public abstract IntBuffer compact();

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.147 -0400", hash_original_method = "E9F1AE5FDD3CB99604FBE90C4DDAAAAA", hash_generated_method = "6ADF39A0B3CF1A8B2E0EB42036456CC4")
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
                int varB0A2C415E738F4ACAE648837EC3182E5_721454202 = (thisInt < otherInt ? -1 : 1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2044676797 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2044676797;
            } //End block
            thisPos++;
            otherPos++;
            compareRemaining--;
        } //End block
        int var1DC167191FBC7DAD3BADAE830552C692_1271094092 = (remaining() - otherBuffer.remaining());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1859282409 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1859282409;
        // ---------- Original Method ----------
        //int compareRemaining = (remaining() < otherBuffer.remaining()) ? remaining()
                //: otherBuffer.remaining();
        //int thisPos = position;
        //int otherPos = otherBuffer.position;
        //int thisInt, otherInt;
        //while (compareRemaining > 0) {
            //thisInt = get(thisPos);
            //otherInt = otherBuffer.get(otherPos);
            //if (thisInt != otherInt) {
                //return thisInt < otherInt ? -1 : 1;
            //}
            //thisPos++;
            //otherPos++;
            //compareRemaining--;
        //}
        //return remaining() - otherBuffer.remaining();
    }

    
    @DSModeled(DSC.SAFE)
    public abstract IntBuffer duplicate();

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.149 -0400", hash_original_method = "43D7EA8D2B4C608B648102E9AA040456", hash_generated_method = "1C3FBA22B661D10CA8CDF85CA573CC4F")
    @Override
    public boolean equals(Object other) {
        addTaint(other.getTaint());
        if(!(other instanceof IntBuffer))        
        {
            boolean var68934A3E9455FA72420237EB05902327_881015657 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_623433782 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_623433782;
        } //End block
        IntBuffer otherBuffer = (IntBuffer) other;
        if(remaining() != otherBuffer.remaining())        
        {
            boolean var68934A3E9455FA72420237EB05902327_1023689635 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1454943211 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1454943211;
        } //End block
        int myPosition = position;
        int otherPosition = otherBuffer.position;
        boolean equalSoFar = true;
        while
(equalSoFar && (myPosition < limit))        
        {
            equalSoFar = get(myPosition++) == otherBuffer.get(otherPosition++);
        } //End block
        boolean var4A97EF18B93B276118DD50585250A586_295957416 = (equalSoFar);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_625630297 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_625630297;
        // ---------- Original Method ----------
        //if (!(other instanceof IntBuffer)) {
            //return false;
        //}
        //IntBuffer otherBuffer = (IntBuffer) other;
        //if (remaining() != otherBuffer.remaining()) {
            //return false;
        //}
        //int myPosition = position;
        //int otherPosition = otherBuffer.position;
        //boolean equalSoFar = true;
        //while (equalSoFar && (myPosition < limit)) {
            //equalSoFar = get(myPosition++) == otherBuffer.get(otherPosition++);
        //}
        //return equalSoFar;
    }

    
    @DSModeled(DSC.SAFE)
    public abstract int get();

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.150 -0400", hash_original_method = "257B404B7D2C714566C75E4EA0767CA2", hash_generated_method = "1D9F221CC3BD00BB4F01F805B176AB22")
    public IntBuffer get(int[] dst) {
        addTaint(dst[0]);
IntBuffer varAF8F268F60258FE30F192DE78F11CD4A_252783977 =         get(dst, 0, dst.length);
        varAF8F268F60258FE30F192DE78F11CD4A_252783977.addTaint(taint);
        return varAF8F268F60258FE30F192DE78F11CD4A_252783977;
        // ---------- Original Method ----------
        //return get(dst, 0, dst.length);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.151 -0400", hash_original_method = "72F522BE346D267FC1DB76B8F081AACA", hash_generated_method = "30DC994D4955EAFBCA27D32ED10DBC10")
    public IntBuffer get(int[] dst, int dstOffset, int intCount) {
        addTaint(intCount);
        addTaint(dstOffset);
        addTaint(dst[0]);
        Arrays.checkOffsetAndCount(dst.length, dstOffset, intCount);
        if(intCount > remaining())        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_823981746 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_823981746.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_823981746;
        } //End block
for(int i = dstOffset;i < dstOffset + intCount;++i)
        {
            dst[i] = get();
        } //End block
IntBuffer var72A74007B2BE62B849F475C7BDA4658B_704659596 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_704659596.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_704659596;
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(dst.length, dstOffset, intCount);
        //if (intCount > remaining()) {
            //throw new BufferUnderflowException();
        //}
        //for (int i = dstOffset; i < dstOffset + intCount; ++i) {
            //dst[i] = get();
        //}
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    public abstract int get(int index);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.152 -0400", hash_original_method = "89C81F0EAF8FCCBFE368437CC8972DD7", hash_generated_method = "420BB3C8D449383876B8B7B86842522F")
    public final boolean hasArray() {
        boolean var55B7C03E3C1EBABD22606AD17EE923C3_2058430727 = (protectedHasArray());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_494171593 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_494171593;
        // ---------- Original Method ----------
        //return protectedHasArray();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.153 -0400", hash_original_method = "371FAD0CF0C9AC8E78075F4EA52336BD", hash_generated_method = "4A8B81A764F067A8BD8E6D7AD261EEC2")
    @Override
    public int hashCode() {
        int myPosition = position;
        int hash = 0;
        while
(myPosition < limit)        
        {
            hash = hash + get(myPosition++);
        } //End block
        int var0800FC577294C34E0B28AD2839435945_640556919 = (hash);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2050047302 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2050047302;
        // ---------- Original Method ----------
        //int myPosition = position;
        //int hash = 0;
        //while (myPosition < limit) {
            //hash = hash + get(myPosition++);
        //}
        //return hash;
    }

    
    @DSModeled(DSC.SAFE)
    public abstract boolean isDirect();

    
    @DSModeled(DSC.SAFE)
    public abstract ByteOrder order();

    
    @DSModeled(DSC.SAFE)
    abstract int[] protectedArray();

    
    @DSModeled(DSC.SAFE)
    abstract int protectedArrayOffset();

    
    @DSModeled(DSC.SAFE)
    abstract boolean protectedHasArray();

    
    @DSModeled(DSC.SAFE)
    public abstract IntBuffer put(int i);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.154 -0400", hash_original_method = "C57984865448BE8CC42F7EA5DB727833", hash_generated_method = "E5811B8E21B67B15B362A16101A6B7B0")
    public final IntBuffer put(int[] src) {
        addTaint(src[0]);
IntBuffer var7D505613BED257805463C43ADCB4DBAD_541381468 =         put(src, 0, src.length);
        var7D505613BED257805463C43ADCB4DBAD_541381468.addTaint(taint);
        return var7D505613BED257805463C43ADCB4DBAD_541381468;
        // ---------- Original Method ----------
        //return put(src, 0, src.length);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.155 -0400", hash_original_method = "E12C5DD5606B4F94202BB1F980DCA32C", hash_generated_method = "0FD869C7E3C9E8221BD0E2E211F43139")
    public IntBuffer put(int[] src, int srcOffset, int intCount) {
        addTaint(intCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        Arrays.checkOffsetAndCount(src.length, srcOffset, intCount);
        if(intCount > remaining())        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_191229191 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_191229191.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_191229191;
        } //End block
for(int i = srcOffset;i < srcOffset + intCount;++i)
        {
            put(src[i]);
        } //End block
IntBuffer var72A74007B2BE62B849F475C7BDA4658B_1119276965 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1119276965.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1119276965;
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(src.length, srcOffset, intCount);
        //if (intCount > remaining()) {
            //throw new BufferOverflowException();
        //}
        //for (int i = srcOffset; i < srcOffset + intCount; ++i) {
            //put(src[i]);
        //}
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.155 -0400", hash_original_method = "874C21D5B52E872502D97AA1BF44CEA1", hash_generated_method = "930DFD70996894DCD9824C8DBB22A711")
    public IntBuffer put(IntBuffer src) {
        addTaint(src.getTaint());
        if(src == this)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_676411680 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_676411680.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_676411680;
        } //End block
        if(src.remaining() > remaining())        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_1820585545 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_1820585545.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_1820585545;
        } //End block
        int[] contents = new int[src.remaining()];
        src.get(contents);
        put(contents);
IntBuffer var72A74007B2BE62B849F475C7BDA4658B_1962116745 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1962116745.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1962116745;
        // ---------- Original Method ----------
        //if (src == this) {
            //throw new IllegalArgumentException();
        //}
        //if (src.remaining() > remaining()) {
            //throw new BufferOverflowException();
        //}
        //int[] contents = new int[src.remaining()];
        //src.get(contents);
        //put(contents);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    public abstract IntBuffer put(int index, int i);

    
    @DSModeled(DSC.SAFE)
    public abstract IntBuffer slice();

    
}

