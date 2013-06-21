package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Arrays;

public abstract class LongBuffer extends Buffer implements Comparable<LongBuffer> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.799 -0400", hash_original_method = "3A9B5F2A82543AF360E63C0F2EA35C03", hash_generated_method = "E41582C4A5A7BB78A13897764C001A1E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     LongBuffer(int capacity) {
        super(3, capacity, null);
        dsTaint.addTaint(capacity);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.800 -0400", hash_original_method = "4BA44AB0CDCB187F799C2188A053FC10", hash_generated_method = "088E17054F044AD2858FE5D6FC8481D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final long[] array() {
        long[] varEA57FBC16B997AC0E679F048893AC79C_122523948 = (protectedArray());
        long[] retVal = new long[1];
        retVal[0] = dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return protectedArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.800 -0400", hash_original_method = "0D5EF56CBEA1DA16093A6276D10D9347", hash_generated_method = "78193DE5DF8447B11093FD097396498C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int arrayOffset() {
        int var457EDFAA982472962568D68CBF588B38_1654616506 = (protectedArrayOffset());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return protectedArrayOffset();
    }

    
    public abstract LongBuffer asReadOnlyBuffer();

    
    public abstract LongBuffer compact();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.800 -0400", hash_original_method = "FEA629F677F50B81610B0F350A8DD419", hash_generated_method = "AB93B37A6EBFB3EBC843849EE184D988")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int compareTo(LongBuffer otherBuffer) {
        dsTaint.addTaint(otherBuffer.dsTaint);
        int compareRemaining;
        boolean var4BCBF0874E5D33E29652A3CCB2245276_700950557 = ((remaining() < otherBuffer.remaining()));
        compareRemaining = remaining();
        compareRemaining = otherBuffer.remaining();
        int thisPos;
        thisPos = position;
        int otherPos;
        otherPos = otherBuffer.position;
        long thisLong, otherLong;
        {
            thisLong = get(thisPos);
            otherLong = otherBuffer.get(otherPos);
        } //End block
        int var51CE6C8A0A6AF44D4BCA06BE06554AF8_1306038894 = (remaining() - otherBuffer.remaining());
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.801 -0400", hash_original_method = "D82E6566C9B77850C7E0596D73483706", hash_generated_method = "3AD32EB5166DE4DF27B6811D1B683D48")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object other) {
        dsTaint.addTaint(other.dsTaint);
        LongBuffer otherBuffer;
        otherBuffer = (LongBuffer) other;
        {
            boolean var0A43D7921CE313B818348D8F01F0C8D5_15620972 = (remaining() != otherBuffer.remaining());
        } //End collapsed parenthetic
        int myPosition;
        myPosition = position;
        int otherPosition;
        otherPosition = otherBuffer.position;
        boolean equalSoFar;
        equalSoFar = true;
        {
            equalSoFar = get(myPosition++) == otherBuffer.get(otherPosition++);
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.801 -0400", hash_original_method = "D4B2A0425DC120EC01BAEA51D6880E08", hash_generated_method = "C8B3E6F6D56B1FE6610FCA884FA71CD4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LongBuffer get(long[] dst) {
        dsTaint.addTaint(dst[0]);
        LongBuffer var54C52896C1D21D17FF99C7DFE6939F7B_1400986036 = (get(dst, 0, dst.length));
        return (LongBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return get(dst, 0, dst.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.801 -0400", hash_original_method = "22F3DDD60BBBE627A1DDE8F148E9CD33", hash_generated_method = "6EFEE1093B3CFD4458FDA7D20CF75D20")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LongBuffer get(long[] dst, int dstOffset, int longCount) {
        dsTaint.addTaint(longCount);
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst[0]);
        Arrays.checkOffsetAndCount(dst.length, dstOffset, longCount);
        {
            boolean var689C4001D724360528D46748438966DA_401780246 = (longCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
            } //End block
        } //End collapsed parenthetic
        {
            int i;
            i = dstOffset;
            {
                dst[i] = get();
            } //End block
        } //End collapsed parenthetic
        return (LongBuffer)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.801 -0400", hash_original_method = "89C81F0EAF8FCCBFE368437CC8972DD7", hash_generated_method = "7596E471D40AD1F7440BE1B306B31431")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean hasArray() {
        boolean varADF219B8DAB0ACF2FCC593A6A216A7F8_610410079 = (protectedHasArray());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return protectedHasArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.802 -0400", hash_original_method = "5C7ADDF6CA5903C3487F2A9B009FDDB4", hash_generated_method = "174533E48067809AB8F1BB2A1C81C8A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int myPosition;
        myPosition = position;
        int hash;
        hash = 0;
        long l;
        {
            l = get(myPosition++);
            hash = hash + ((int) l) ^ ((int) (l >> 32));
        } //End block
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.802 -0400", hash_original_method = "5A5A365AB2651722CE67CD635F8A83E0", hash_generated_method = "63BC4F1F8139EC9B66A977BCB4DD73FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final LongBuffer put(long[] src) {
        dsTaint.addTaint(src[0]);
        LongBuffer var974D367CEDA780433BF9CC5389A430C6_595089763 = (put(src, 0, src.length));
        return (LongBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return put(src, 0, src.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.803 -0400", hash_original_method = "B57657AA1D79DC46C889A6E8179D7A18", hash_generated_method = "EAE49A0D3E4CE717CC1796892DAFDDDE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LongBuffer put(long[] src, int srcOffset, int longCount) {
        dsTaint.addTaint(longCount);
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(src[0]);
        Arrays.checkOffsetAndCount(src.length, srcOffset, longCount);
        {
            boolean var689C4001D724360528D46748438966DA_774935185 = (longCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
            } //End block
        } //End collapsed parenthetic
        {
            int i;
            i = srcOffset;
            {
                put(src[i]);
            } //End block
        } //End collapsed parenthetic
        return (LongBuffer)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.803 -0400", hash_original_method = "268B2EFE55B01F54F51A1709DBD7F8C3", hash_generated_method = "2869EF5CDF5FA571C53A46146B9ECC18")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LongBuffer put(LongBuffer src) {
        dsTaint.addTaint(src.dsTaint);
        {
            boolean var9C07FD71E9483B067CE073F58225A0C4_1110413726 = (src == this);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var6E2E81EBCD4D9A6ACDDC12CE61513AA8_1256571583 = (src.remaining() > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
            } //End block
        } //End collapsed parenthetic
        long[] contents;
        contents = new long[src.remaining()];
        src.get(contents);
        put(contents);
        return (LongBuffer)dsTaint.getTaint();
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

