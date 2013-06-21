package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Arrays;

public abstract class IntBuffer extends Buffer implements Comparable<IntBuffer> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.760 -0400", hash_original_method = "BC7C458D54C7EF00271779F9364447AB", hash_generated_method = "B6F17E00DC1209909AC31FABAD08FACB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     IntBuffer(int capacity) {
        super(2, capacity, null);
        dsTaint.addTaint(capacity);
        // ---------- Original Method ----------
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.761 -0400", hash_original_method = "D78164E532496862518F1BC4BDE62DEB", hash_generated_method = "5C88CB9AFE0FAD8A4A9621B2D627683B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int[] array() {
        int[] varEA57FBC16B997AC0E679F048893AC79C_732423044 = (protectedArray());
        int[] retVal = new int[1];
        retVal[0] = dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return protectedArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.761 -0400", hash_original_method = "0D5EF56CBEA1DA16093A6276D10D9347", hash_generated_method = "AD4AA7B419B9BC3C1106F62FA106E185")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int arrayOffset() {
        int var457EDFAA982472962568D68CBF588B38_1888639765 = (protectedArrayOffset());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return protectedArrayOffset();
    }

    
    public abstract IntBuffer asReadOnlyBuffer();

    
    public abstract IntBuffer compact();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.762 -0400", hash_original_method = "E9F1AE5FDD3CB99604FBE90C4DDAAAAA", hash_generated_method = "CAE3BE695139CE441AEFE051039174FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int compareTo(IntBuffer otherBuffer) {
        dsTaint.addTaint(otherBuffer.dsTaint);
        int compareRemaining;
        boolean var4BCBF0874E5D33E29652A3CCB2245276_1642086463 = ((remaining() < otherBuffer.remaining()));
        compareRemaining = remaining();
        compareRemaining = otherBuffer.remaining();
        int thisPos;
        thisPos = position;
        int otherPos;
        otherPos = otherBuffer.position;
        int thisInt, otherInt;
        {
            thisInt = get(thisPos);
            otherInt = otherBuffer.get(otherPos);
        } //End block
        int var51CE6C8A0A6AF44D4BCA06BE06554AF8_2083943473 = (remaining() - otherBuffer.remaining());
        return dsTaint.getTaintInt();
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

    
    public abstract IntBuffer duplicate();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.762 -0400", hash_original_method = "43D7EA8D2B4C608B648102E9AA040456", hash_generated_method = "A9FB3B9527F5D9E9E0C21BB7F76AE196")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object other) {
        dsTaint.addTaint(other.dsTaint);
        IntBuffer otherBuffer;
        otherBuffer = (IntBuffer) other;
        {
            boolean var0A43D7921CE313B818348D8F01F0C8D5_432559794 = (remaining() != otherBuffer.remaining());
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

    
    public abstract int get();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.762 -0400", hash_original_method = "257B404B7D2C714566C75E4EA0767CA2", hash_generated_method = "6309624A107BBF3DEC646BA9B768F0F0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IntBuffer get(int[] dst) {
        dsTaint.addTaint(dst[0]);
        IntBuffer var54C52896C1D21D17FF99C7DFE6939F7B_1818952199 = (get(dst, 0, dst.length));
        return (IntBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return get(dst, 0, dst.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.763 -0400", hash_original_method = "72F522BE346D267FC1DB76B8F081AACA", hash_generated_method = "33CCCEE7B311594B39008CC00CE8315F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IntBuffer get(int[] dst, int dstOffset, int intCount) {
        dsTaint.addTaint(intCount);
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst[0]);
        Arrays.checkOffsetAndCount(dst.length, dstOffset, intCount);
        {
            boolean var88D58DBFE8E26BEBC18FDE3265CF76EF_779416069 = (intCount > remaining());
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
        return (IntBuffer)dsTaint.getTaint();
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

    
    public abstract int get(int index);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.763 -0400", hash_original_method = "89C81F0EAF8FCCBFE368437CC8972DD7", hash_generated_method = "795F96104A2FB7E13186EC0C4777D768")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean hasArray() {
        boolean varADF219B8DAB0ACF2FCC593A6A216A7F8_1424469238 = (protectedHasArray());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return protectedHasArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.763 -0400", hash_original_method = "371FAD0CF0C9AC8E78075F4EA52336BD", hash_generated_method = "48881135A5C55AA9F3B219BF71BEF483")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int myPosition;
        myPosition = position;
        int hash;
        hash = 0;
        {
            hash = hash + get(myPosition++);
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int myPosition = position;
        //int hash = 0;
        //while (myPosition < limit) {
            //hash = hash + get(myPosition++);
        //}
        //return hash;
    }

    
    public abstract boolean isDirect();

    
    public abstract ByteOrder order();

    
    abstract int[] protectedArray();

    
    abstract int protectedArrayOffset();

    
    abstract boolean protectedHasArray();

    
    public abstract IntBuffer put(int i);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.764 -0400", hash_original_method = "C57984865448BE8CC42F7EA5DB727833", hash_generated_method = "BE0CCEF4C57C4D7FBE42A977347340EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final IntBuffer put(int[] src) {
        dsTaint.addTaint(src[0]);
        IntBuffer var974D367CEDA780433BF9CC5389A430C6_1459455342 = (put(src, 0, src.length));
        return (IntBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return put(src, 0, src.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.764 -0400", hash_original_method = "E12C5DD5606B4F94202BB1F980DCA32C", hash_generated_method = "AD01C0A02F0000C918153DFC384C0EC8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IntBuffer put(int[] src, int srcOffset, int intCount) {
        dsTaint.addTaint(intCount);
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(src[0]);
        Arrays.checkOffsetAndCount(src.length, srcOffset, intCount);
        {
            boolean var88D58DBFE8E26BEBC18FDE3265CF76EF_1559759349 = (intCount > remaining());
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
        return (IntBuffer)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.764 -0400", hash_original_method = "874C21D5B52E872502D97AA1BF44CEA1", hash_generated_method = "3571049C76CCB1DB9DD077C174972E20")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IntBuffer put(IntBuffer src) {
        dsTaint.addTaint(src.dsTaint);
        {
            boolean var9C07FD71E9483B067CE073F58225A0C4_476295204 = (src == this);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var6E2E81EBCD4D9A6ACDDC12CE61513AA8_1627744936 = (src.remaining() > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
            } //End block
        } //End collapsed parenthetic
        int[] contents;
        contents = new int[src.remaining()];
        src.get(contents);
        put(contents);
        return (IntBuffer)dsTaint.getTaint();
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

    
    public abstract IntBuffer put(int index, int i);

    
    public abstract IntBuffer slice();

    
}

