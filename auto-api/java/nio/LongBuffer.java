package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Arrays;

public abstract class LongBuffer extends Buffer implements Comparable<LongBuffer> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.768 -0400", hash_original_method = "3A9B5F2A82543AF360E63C0F2EA35C03", hash_generated_method = "41849BA7BDC3CE94FF819BE93189CEF6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.768 -0400", hash_original_method = "4BA44AB0CDCB187F799C2188A053FC10", hash_generated_method = "8FD559E90C0C93266A3D187847DD53EC")
    public final long[] array() {
        long[] varEA57FBC16B997AC0E679F048893AC79C_480357866 = (protectedArray());
        long[] var3908C7C3AF5171CEE1F112DAE77A5C4D_1241881657 = {getTaintLong()};
        return var3908C7C3AF5171CEE1F112DAE77A5C4D_1241881657;
        // ---------- Original Method ----------
        //return protectedArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.769 -0400", hash_original_method = "0D5EF56CBEA1DA16093A6276D10D9347", hash_generated_method = "6B09032CAD1C0B8F8A67EBEEFF78C8CA")
    public final int arrayOffset() {
        int var457EDFAA982472962568D68CBF588B38_2116632326 = (protectedArrayOffset());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1554276428 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1554276428;
        // ---------- Original Method ----------
        //return protectedArrayOffset();
    }

    
    public abstract LongBuffer asReadOnlyBuffer();

    
    public abstract LongBuffer compact();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.770 -0400", hash_original_method = "FEA629F677F50B81610B0F350A8DD419", hash_generated_method = "D4F87C07A8A423C55A9FD9228AFECF8B")
    public int compareTo(LongBuffer otherBuffer) {
        int compareRemaining;
        boolean var4BCBF0874E5D33E29652A3CCB2245276_1339931995 = ((remaining() < otherBuffer.remaining()));
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
        int var51CE6C8A0A6AF44D4BCA06BE06554AF8_1885684401 = (remaining() - otherBuffer.remaining());
        addTaint(otherBuffer.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_5060695 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_5060695;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.771 -0400", hash_original_method = "D82E6566C9B77850C7E0596D73483706", hash_generated_method = "035D7AA1E6AC1535EC3CF25441E14B03")
    @Override
    public boolean equals(Object other) {
        LongBuffer otherBuffer;
        otherBuffer = (LongBuffer) other;
        {
            boolean var0A43D7921CE313B818348D8F01F0C8D5_93029754 = (remaining() != otherBuffer.remaining());
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
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2051707088 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2051707088;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.780 -0400", hash_original_method = "D4B2A0425DC120EC01BAEA51D6880E08", hash_generated_method = "B93CD97950552798C6D78DCFBD6E2C81")
    public LongBuffer get(long[] dst) {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_274254373 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_274254373 = get(dst, 0, dst.length);
        addTaint(dst[0]);
        varB4EAC82CA7396A68D541C85D26508E83_274254373.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_274254373;
        // ---------- Original Method ----------
        //return get(dst, 0, dst.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.792 -0400", hash_original_method = "22F3DDD60BBBE627A1DDE8F148E9CD33", hash_generated_method = "3E1B2A8913B76257D7D8281BA8E79398")
    public LongBuffer get(long[] dst, int dstOffset, int longCount) {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_394968873 = null; //Variable for return #1
        Arrays.checkOffsetAndCount(dst.length, dstOffset, longCount);
        {
            boolean var689C4001D724360528D46748438966DA_1334220677 = (longCount > remaining());
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
        varB4EAC82CA7396A68D541C85D26508E83_394968873 = this;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(longCount);
        varB4EAC82CA7396A68D541C85D26508E83_394968873.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_394968873;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.792 -0400", hash_original_method = "89C81F0EAF8FCCBFE368437CC8972DD7", hash_generated_method = "BC82E96585744127786EF3BA46CD4F2E")
    public final boolean hasArray() {
        boolean varADF219B8DAB0ACF2FCC593A6A216A7F8_1055365825 = (protectedHasArray());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1544579588 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1544579588;
        // ---------- Original Method ----------
        //return protectedHasArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.793 -0400", hash_original_method = "5C7ADDF6CA5903C3487F2A9B009FDDB4", hash_generated_method = "56CBCA1D672200CB089E14B2A57EE5B3")
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_607960430 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_607960430;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.794 -0400", hash_original_method = "5A5A365AB2651722CE67CD635F8A83E0", hash_generated_method = "6485C32D06830F3CFD845251478054DE")
    public final LongBuffer put(long[] src) {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_1548983679 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1548983679 = put(src, 0, src.length);
        addTaint(src[0]);
        varB4EAC82CA7396A68D541C85D26508E83_1548983679.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1548983679;
        // ---------- Original Method ----------
        //return put(src, 0, src.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.795 -0400", hash_original_method = "B57657AA1D79DC46C889A6E8179D7A18", hash_generated_method = "F446BE3BD1F0332AC603826A03391A37")
    public LongBuffer put(long[] src, int srcOffset, int longCount) {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_468729649 = null; //Variable for return #1
        Arrays.checkOffsetAndCount(src.length, srcOffset, longCount);
        {
            boolean var689C4001D724360528D46748438966DA_1265778570 = (longCount > remaining());
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
        varB4EAC82CA7396A68D541C85D26508E83_468729649 = this;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(longCount);
        varB4EAC82CA7396A68D541C85D26508E83_468729649.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_468729649;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.826 -0400", hash_original_method = "268B2EFE55B01F54F51A1709DBD7F8C3", hash_generated_method = "DFE9FB34AE17D492F08F2CDA16B241EF")
    public LongBuffer put(LongBuffer src) {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_997627028 = null; //Variable for return #1
        {
            boolean var9C07FD71E9483B067CE073F58225A0C4_1576399437 = (src == this);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var6E2E81EBCD4D9A6ACDDC12CE61513AA8_1141792660 = (src.remaining() > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
            } //End block
        } //End collapsed parenthetic
        long[] contents;
        contents = new long[src.remaining()];
        src.get(contents);
        put(contents);
        varB4EAC82CA7396A68D541C85D26508E83_997627028 = this;
        addTaint(src.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_997627028.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_997627028;
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

