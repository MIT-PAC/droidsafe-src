package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Arrays;

public abstract class LongBuffer extends Buffer implements Comparable<LongBuffer> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.764 -0400", hash_original_method = "3A9B5F2A82543AF360E63C0F2EA35C03", hash_generated_method = "41849BA7BDC3CE94FF819BE93189CEF6")
      LongBuffer(int capacity) {
        super(3, capacity, null);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
        public static LongBuffer allocate(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }
        return new ReadWriteLongArrayBuffer(capacity);
    }

    
        public static LongBuffer wrap(long[] array) {
        return wrap(array, 0, array.length);
    }

    
        public static LongBuffer wrap(long[] array, int start, int longCount) {
        Arrays.checkOffsetAndCount(array.length, start, longCount);
        LongBuffer buf = new ReadWriteLongArrayBuffer(array);
        buf.position = start;
        buf.limit = start + longCount;
        return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.765 -0400", hash_original_method = "4BA44AB0CDCB187F799C2188A053FC10", hash_generated_method = "3A878FBC24DCEA5F140773E5FF81B214")
    public final long[] array() {
        long[] var68B89E48382A0AA51B25AC59599E2EB0_1940592925 = (protectedArray());
                long[] var3908C7C3AF5171CEE1F112DAE77A5C4D_489823164 = {getTaintLong()};
        return var3908C7C3AF5171CEE1F112DAE77A5C4D_489823164;
        // ---------- Original Method ----------
        //return protectedArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.766 -0400", hash_original_method = "0D5EF56CBEA1DA16093A6276D10D9347", hash_generated_method = "2FC8C655E9E61C6362B1E7BC59C72EF6")
    public final int arrayOffset() {
        int var0B794CE56A38A9F3BFDD2D53E83BB109_133585603 = (protectedArrayOffset());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1353140169 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1353140169;
        // ---------- Original Method ----------
        //return protectedArrayOffset();
    }

    
    public abstract LongBuffer asReadOnlyBuffer();

    
    public abstract LongBuffer compact();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.767 -0400", hash_original_method = "FEA629F677F50B81610B0F350A8DD419", hash_generated_method = "BC26D1AECE8A70DC5DF6F6F9D4869EC7")
    public int compareTo(LongBuffer otherBuffer) {
        addTaint(otherBuffer.getTaint());
        int compareRemaining = (remaining() < otherBuffer.remaining()) ? remaining()
                : otherBuffer.remaining();
        int thisPos = position;
        int otherPos = otherBuffer.position;
        long thisLong;
        long otherLong;
        while
(compareRemaining > 0)        
        {
            thisLong = get(thisPos);
            otherLong = otherBuffer.get(otherPos);
    if(thisLong != otherLong)            
            {
                int varA8E1A787D0C8C8750D6A153FD61F6B1C_866204349 = (thisLong < otherLong ? -1 : 1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_38650208 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_38650208;
            } //End block
            thisPos++;
            otherPos++;
            compareRemaining--;
        } //End block
        int var1DC167191FBC7DAD3BADAE830552C692_1430184746 = (remaining() - otherBuffer.remaining());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1657843920 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1657843920;
        // ---------- Original Method ----------
        //int compareRemaining = (remaining() < otherBuffer.remaining()) ? remaining()
                //: otherBuffer.remaining();
        //int thisPos = position;
        //int otherPos = otherBuffer.position;
        //long thisLong, otherLong;
        //while (compareRemaining > 0) {
            //thisLong = get(thisPos);
            //otherLong = otherBuffer.get(otherPos);
            //if (thisLong != otherLong) {
                //return thisLong < otherLong ? -1 : 1;
            //}
            //thisPos++;
            //otherPos++;
            //compareRemaining--;
        //}
        //return remaining() - otherBuffer.remaining();
    }

    
    public abstract LongBuffer duplicate();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.768 -0400", hash_original_method = "D82E6566C9B77850C7E0596D73483706", hash_generated_method = "26442C89930BFDDAA834342D74A2800E")
    @Override
    public boolean equals(Object other) {
        addTaint(other.getTaint());
    if(!(other instanceof LongBuffer))        
        {
            boolean var68934A3E9455FA72420237EB05902327_612197668 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1110687787 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1110687787;
        } //End block
        LongBuffer otherBuffer = (LongBuffer) other;
    if(remaining() != otherBuffer.remaining())        
        {
            boolean var68934A3E9455FA72420237EB05902327_1254806613 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1405513522 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1405513522;
        } //End block
        int myPosition = position;
        int otherPosition = otherBuffer.position;
        boolean equalSoFar = true;
        while
(equalSoFar && (myPosition < limit))        
        {
            equalSoFar = get(myPosition++) == otherBuffer.get(otherPosition++);
        } //End block
        boolean var4A97EF18B93B276118DD50585250A586_882960911 = (equalSoFar);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_117295705 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_117295705;
        // ---------- Original Method ----------
        //if (!(other instanceof LongBuffer)) {
            //return false;
        //}
        //LongBuffer otherBuffer = (LongBuffer) other;
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

    
    public abstract long get();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.769 -0400", hash_original_method = "D4B2A0425DC120EC01BAEA51D6880E08", hash_generated_method = "E02D406F6C65F10253280BF464365018")
    public LongBuffer get(long[] dst) {
        addTaint(dst[0]);
LongBuffer varAF8F268F60258FE30F192DE78F11CD4A_1915582442 =         get(dst, 0, dst.length);
        varAF8F268F60258FE30F192DE78F11CD4A_1915582442.addTaint(taint);
        return varAF8F268F60258FE30F192DE78F11CD4A_1915582442;
        // ---------- Original Method ----------
        //return get(dst, 0, dst.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.769 -0400", hash_original_method = "22F3DDD60BBBE627A1DDE8F148E9CD33", hash_generated_method = "971B1222044D55B01A11D73CD3DDA2CC")
    public LongBuffer get(long[] dst, int dstOffset, int longCount) {
        addTaint(longCount);
        addTaint(dstOffset);
        addTaint(dst[0]);
        Arrays.checkOffsetAndCount(dst.length, dstOffset, longCount);
    if(longCount > remaining())        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_1461838764 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_1461838764.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_1461838764;
        } //End block
for(int i = dstOffset;i < dstOffset + longCount;++i)
        {
            dst[i] = get();
        } //End block
LongBuffer var72A74007B2BE62B849F475C7BDA4658B_1925856977 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1925856977.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1925856977;
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(dst.length, dstOffset, longCount);
        //if (longCount > remaining()) {
            //throw new BufferUnderflowException();
        //}
        //for (int i = dstOffset; i < dstOffset + longCount; ++i) {
            //dst[i] = get();
        //}
        //return this;
    }

    
    public abstract long get(int index);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.770 -0400", hash_original_method = "89C81F0EAF8FCCBFE368437CC8972DD7", hash_generated_method = "F7478D20B6580E826A2A91FA4256BD1A")
    public final boolean hasArray() {
        boolean var55B7C03E3C1EBABD22606AD17EE923C3_2109716732 = (protectedHasArray());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1137638017 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1137638017;
        // ---------- Original Method ----------
        //return protectedHasArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.771 -0400", hash_original_method = "5C7ADDF6CA5903C3487F2A9B009FDDB4", hash_generated_method = "C0C354D4EA769AADA0BE214778113E4F")
    @Override
    public int hashCode() {
        int myPosition = position;
        int hash = 0;
        long l;
        while
(myPosition < limit)        
        {
            l = get(myPosition++);
            hash = hash + ((int) l) ^ ((int) (l >> 32));
        } //End block
        int var0800FC577294C34E0B28AD2839435945_737751964 = (hash);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1609703610 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1609703610;
        // ---------- Original Method ----------
        //int myPosition = position;
        //int hash = 0;
        //long l;
        //while (myPosition < limit) {
            //l = get(myPosition++);
            //hash = hash + ((int) l) ^ ((int) (l >> 32));
        //}
        //return hash;
    }

    
    public abstract boolean isDirect();

    
    public abstract ByteOrder order();

    
    abstract long[] protectedArray();

    
    abstract int protectedArrayOffset();

    
    abstract boolean protectedHasArray();

    
    public abstract LongBuffer put(long l);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.772 -0400", hash_original_method = "5A5A365AB2651722CE67CD635F8A83E0", hash_generated_method = "5A9828A425116A2B6095C5F0F63938E9")
    public final LongBuffer put(long[] src) {
        addTaint(src[0]);
LongBuffer var7D505613BED257805463C43ADCB4DBAD_1278592092 =         put(src, 0, src.length);
        var7D505613BED257805463C43ADCB4DBAD_1278592092.addTaint(taint);
        return var7D505613BED257805463C43ADCB4DBAD_1278592092;
        // ---------- Original Method ----------
        //return put(src, 0, src.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.773 -0400", hash_original_method = "B57657AA1D79DC46C889A6E8179D7A18", hash_generated_method = "EDD1A1816006CC8DC9AD34256F0CAA8E")
    public LongBuffer put(long[] src, int srcOffset, int longCount) {
        addTaint(longCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        Arrays.checkOffsetAndCount(src.length, srcOffset, longCount);
    if(longCount > remaining())        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_10574068 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_10574068.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_10574068;
        } //End block
for(int i = srcOffset;i < srcOffset + longCount;++i)
        {
            put(src[i]);
        } //End block
LongBuffer var72A74007B2BE62B849F475C7BDA4658B_1868028732 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1868028732.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1868028732;
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(src.length, srcOffset, longCount);
        //if (longCount > remaining()) {
            //throw new BufferOverflowException();
        //}
        //for (int i = srcOffset; i < srcOffset + longCount; ++i) {
            //put(src[i]);
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.773 -0400", hash_original_method = "268B2EFE55B01F54F51A1709DBD7F8C3", hash_generated_method = "B1A8594155447A0DE98ED9ECEC0415F5")
    public LongBuffer put(LongBuffer src) {
        addTaint(src.getTaint());
    if(src == this)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_790669559 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_790669559.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_790669559;
        } //End block
    if(src.remaining() > remaining())        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_1801779305 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_1801779305.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_1801779305;
        } //End block
        long[] contents = new long[src.remaining()];
        src.get(contents);
        put(contents);
LongBuffer var72A74007B2BE62B849F475C7BDA4658B_1410114006 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1410114006.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1410114006;
        // ---------- Original Method ----------
        //if (src == this) {
            //throw new IllegalArgumentException();
        //}
        //if (src.remaining() > remaining()) {
            //throw new BufferOverflowException();
        //}
        //long[] contents = new long[src.remaining()];
        //src.get(contents);
        //put(contents);
        //return this;
    }

    
    public abstract LongBuffer put(int index, long l);

    
    public abstract LongBuffer slice();

    
}

