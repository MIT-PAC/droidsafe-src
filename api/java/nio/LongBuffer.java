package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Arrays;

public abstract class LongBuffer extends Buffer implements Comparable<LongBuffer> {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.269 -0400", hash_original_method = "3A9B5F2A82543AF360E63C0F2EA35C03", hash_generated_method = "41849BA7BDC3CE94FF819BE93189CEF6")
      LongBuffer(int capacity) {
        super(3, capacity, null);
        addTaint(capacity);
        // ---------- Original Method ----------
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.270 -0400", hash_original_method = "4BA44AB0CDCB187F799C2188A053FC10", hash_generated_method = "63CA89092A20ED391734527FAB5C64B9")
    public final long[] array() {
        long[] var68B89E48382A0AA51B25AC59599E2EB0_1385963802 = (protectedArray());
                long[] var3908C7C3AF5171CEE1F112DAE77A5C4D_149626451 = {getTaintLong()};
        return var3908C7C3AF5171CEE1F112DAE77A5C4D_149626451;
        // ---------- Original Method ----------
        //return protectedArray();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.271 -0400", hash_original_method = "0D5EF56CBEA1DA16093A6276D10D9347", hash_generated_method = "B2880506CF9A3247BD99085334A3057F")
    public final int arrayOffset() {
        int var0B794CE56A38A9F3BFDD2D53E83BB109_1156353062 = (protectedArrayOffset());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_815762310 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_815762310;
        // ---------- Original Method ----------
        //return protectedArrayOffset();
    }

    
    @DSModeled(DSC.SAFE)
    public abstract LongBuffer asReadOnlyBuffer();

    
    @DSModeled(DSC.SAFE)
    public abstract LongBuffer compact();

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.272 -0400", hash_original_method = "FEA629F677F50B81610B0F350A8DD419", hash_generated_method = "6E1C5B442AD068383669ABC5960A7701")
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
                int varA8E1A787D0C8C8750D6A153FD61F6B1C_1927643327 = (thisLong < otherLong ? -1 : 1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1717767319 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1717767319;
            } //End block
            thisPos++;
            otherPos++;
            compareRemaining--;
        } //End block
        int var1DC167191FBC7DAD3BADAE830552C692_1648428082 = (remaining() - otherBuffer.remaining());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1441331446 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1441331446;
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

    
    @DSModeled(DSC.SAFE)
    public abstract LongBuffer duplicate();

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.273 -0400", hash_original_method = "D82E6566C9B77850C7E0596D73483706", hash_generated_method = "6A0FD4B8F86B9D860B2F7CDFE8BFDF7A")
    @Override
    public boolean equals(Object other) {
        addTaint(other.getTaint());
        if(!(other instanceof LongBuffer))        
        {
            boolean var68934A3E9455FA72420237EB05902327_20474269 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1376138370 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1376138370;
        } //End block
        LongBuffer otherBuffer = (LongBuffer) other;
        if(remaining() != otherBuffer.remaining())        
        {
            boolean var68934A3E9455FA72420237EB05902327_942877136 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1580968049 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1580968049;
        } //End block
        int myPosition = position;
        int otherPosition = otherBuffer.position;
        boolean equalSoFar = true;
        while
(equalSoFar && (myPosition < limit))        
        {
            equalSoFar = get(myPosition++) == otherBuffer.get(otherPosition++);
        } //End block
        boolean var4A97EF18B93B276118DD50585250A586_1118792655 = (equalSoFar);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_3364080 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_3364080;
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

    
    @DSModeled(DSC.SAFE)
    public abstract long get();

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.274 -0400", hash_original_method = "D4B2A0425DC120EC01BAEA51D6880E08", hash_generated_method = "5B73A4AC63851FFD4BB55C4E9973340B")
    public LongBuffer get(long[] dst) {
        addTaint(dst[0]);
LongBuffer varAF8F268F60258FE30F192DE78F11CD4A_536826547 =         get(dst, 0, dst.length);
        varAF8F268F60258FE30F192DE78F11CD4A_536826547.addTaint(taint);
        return varAF8F268F60258FE30F192DE78F11CD4A_536826547;
        // ---------- Original Method ----------
        //return get(dst, 0, dst.length);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.275 -0400", hash_original_method = "22F3DDD60BBBE627A1DDE8F148E9CD33", hash_generated_method = "601F5C8B613486CA192725A8E1A0B80B")
    public LongBuffer get(long[] dst, int dstOffset, int longCount) {
        addTaint(longCount);
        addTaint(dstOffset);
        addTaint(dst[0]);
        Arrays.checkOffsetAndCount(dst.length, dstOffset, longCount);
        if(longCount > remaining())        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_376519098 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_376519098.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_376519098;
        } //End block
for(int i = dstOffset;i < dstOffset + longCount;++i)
        {
            dst[i] = get();
        } //End block
LongBuffer var72A74007B2BE62B849F475C7BDA4658B_2009802766 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_2009802766.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_2009802766;
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

    
    @DSModeled(DSC.SAFE)
    public abstract long get(int index);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.275 -0400", hash_original_method = "89C81F0EAF8FCCBFE368437CC8972DD7", hash_generated_method = "9B4CB2D53AE992D4C5F05C90E0DFBB13")
    public final boolean hasArray() {
        boolean var55B7C03E3C1EBABD22606AD17EE923C3_417558658 = (protectedHasArray());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_711143395 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_711143395;
        // ---------- Original Method ----------
        //return protectedHasArray();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.275 -0400", hash_original_method = "5C7ADDF6CA5903C3487F2A9B009FDDB4", hash_generated_method = "09A8C02502EDA66B80B041ED8FA12CE9")
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
        int var0800FC577294C34E0B28AD2839435945_57764505 = (hash);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_497359922 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_497359922;
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

    
    @DSModeled(DSC.SAFE)
    public abstract boolean isDirect();

    
    @DSModeled(DSC.SAFE)
    public abstract ByteOrder order();

    
    @DSModeled(DSC.SAFE)
    abstract long[] protectedArray();

    
    @DSModeled(DSC.SAFE)
    abstract int protectedArrayOffset();

    
    @DSModeled(DSC.SAFE)
    abstract boolean protectedHasArray();

    
    @DSModeled(DSC.SAFE)
    public abstract LongBuffer put(long l);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.276 -0400", hash_original_method = "5A5A365AB2651722CE67CD635F8A83E0", hash_generated_method = "76BE7C8A0F0D5868363CDDC44BF03E81")
    public final LongBuffer put(long[] src) {
        addTaint(src[0]);
LongBuffer var7D505613BED257805463C43ADCB4DBAD_1709839521 =         put(src, 0, src.length);
        var7D505613BED257805463C43ADCB4DBAD_1709839521.addTaint(taint);
        return var7D505613BED257805463C43ADCB4DBAD_1709839521;
        // ---------- Original Method ----------
        //return put(src, 0, src.length);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.276 -0400", hash_original_method = "B57657AA1D79DC46C889A6E8179D7A18", hash_generated_method = "E31C5856FB247384676E62CB941B1D40")
    public LongBuffer put(long[] src, int srcOffset, int longCount) {
        addTaint(longCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        Arrays.checkOffsetAndCount(src.length, srcOffset, longCount);
        if(longCount > remaining())        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_1460720417 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_1460720417.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_1460720417;
        } //End block
for(int i = srcOffset;i < srcOffset + longCount;++i)
        {
            put(src[i]);
        } //End block
LongBuffer var72A74007B2BE62B849F475C7BDA4658B_2052036699 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_2052036699.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_2052036699;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.276 -0400", hash_original_method = "268B2EFE55B01F54F51A1709DBD7F8C3", hash_generated_method = "5B4ED01715D3172BD838CFDA638D566D")
    public LongBuffer put(LongBuffer src) {
        addTaint(src.getTaint());
        if(src == this)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_239811816 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_239811816.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_239811816;
        } //End block
        if(src.remaining() > remaining())        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_2100632844 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_2100632844.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_2100632844;
        } //End block
        long[] contents = new long[src.remaining()];
        src.get(contents);
        put(contents);
LongBuffer var72A74007B2BE62B849F475C7BDA4658B_1587264387 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1587264387.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1587264387;
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

    
    @DSModeled(DSC.SAFE)
    public abstract LongBuffer put(int index, long l);

    
    @DSModeled(DSC.SAFE)
    public abstract LongBuffer slice();

    
}

