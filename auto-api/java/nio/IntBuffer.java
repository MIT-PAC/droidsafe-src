package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Arrays;

public abstract class IntBuffer extends Buffer implements Comparable<IntBuffer> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:52.807 -0400", hash_original_method = "BC7C458D54C7EF00271779F9364447AB", hash_generated_method = "3207954798FC36C33148386D8499B3FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     IntBuffer(int capacity) {
        super(2, capacity, null);
        dsTaint.addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:52.808 -0400", hash_original_method = "C3C2422C66654D6E12C59493728B39AD", hash_generated_method = "0D16E8947227D39761B191AF74C187E8")
    public static IntBuffer allocate(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }
        return new ReadWriteIntArrayBuffer(capacity);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:52.809 -0400", hash_original_method = "69AB4E308DD923986E8AB96AF4F625AA", hash_generated_method = "6C1B3D0124340296BE544158357DB7B0")
    public static IntBuffer wrap(int[] array) {
        return wrap(array, 0, array.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:52.809 -0400", hash_original_method = "47E92E6AEEAACC35C5502B8D98F03798", hash_generated_method = "4ECA240E787448B61CD60196456D2818")
    public static IntBuffer wrap(int[] array, int start, int intCount) {
        Arrays.checkOffsetAndCount(array.length, start, intCount);
        IntBuffer buf = new ReadWriteIntArrayBuffer(array);
        buf.position = start;
        buf.limit = start + intCount;
        return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:52.810 -0400", hash_original_method = "D78164E532496862518F1BC4BDE62DEB", hash_generated_method = "A7EFF26959FE56479021D2947960B597")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int[] array() {
        int[] varEA57FBC16B997AC0E679F048893AC79C_1019471610 = (protectedArray());
        int[] retVal = new int[1];
        retVal[0] = dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return protectedArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:52.812 -0400", hash_original_method = "0D5EF56CBEA1DA16093A6276D10D9347", hash_generated_method = "AB31990712353D6ABC458D58CC2E3599")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int arrayOffset() {
        int var457EDFAA982472962568D68CBF588B38_1513833978 = (protectedArrayOffset());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return protectedArrayOffset();
    }

    
    public abstract IntBuffer asReadOnlyBuffer();

    
    public abstract IntBuffer compact();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:52.815 -0400", hash_original_method = "E9F1AE5FDD3CB99604FBE90C4DDAAAAA", hash_generated_method = "4ADB2D5C151E328980E76BE0F1827011")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int compareTo(IntBuffer otherBuffer) {
        dsTaint.addTaint(otherBuffer.dsTaint);
        int compareRemaining;
        boolean var4BCBF0874E5D33E29652A3CCB2245276_1730063985 = ((remaining() < otherBuffer.remaining()));
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
            thisPos++;
            otherPos++;
            compareRemaining--;
        } //End block
        int var51CE6C8A0A6AF44D4BCA06BE06554AF8_50670934 = (remaining() - otherBuffer.remaining());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:52.817 -0400", hash_original_method = "43D7EA8D2B4C608B648102E9AA040456", hash_generated_method = "C6C262554747A572458C070AAE7CCCFC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object other) {
        dsTaint.addTaint(other.dsTaint);
        IntBuffer otherBuffer;
        otherBuffer = (IntBuffer) other;
        {
            boolean var0A43D7921CE313B818348D8F01F0C8D5_2001405954 = (remaining() != otherBuffer.remaining());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:52.819 -0400", hash_original_method = "257B404B7D2C714566C75E4EA0767CA2", hash_generated_method = "840EED02294D15FE952B54AED7F9CA82")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IntBuffer get(int[] dst) {
        dsTaint.addTaint(dst);
        IntBuffer var54C52896C1D21D17FF99C7DFE6939F7B_738723669 = (get(dst, 0, dst.length));
        return (IntBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return get(dst, 0, dst.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:52.821 -0400", hash_original_method = "72F522BE346D267FC1DB76B8F081AACA", hash_generated_method = "BC0A26208E61252219D92C4888CADCB5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IntBuffer get(int[] dst, int dstOffset, int intCount) {
        dsTaint.addTaint(intCount);
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst);
        Arrays.checkOffsetAndCount(dst.length, dstOffset, intCount);
        {
            boolean var88D58DBFE8E26BEBC18FDE3265CF76EF_2077773887 = (intCount > remaining());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:52.822 -0400", hash_original_method = "89C81F0EAF8FCCBFE368437CC8972DD7", hash_generated_method = "52315E0B5BD91230F3D74EFB0C129841")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean hasArray() {
        boolean varADF219B8DAB0ACF2FCC593A6A216A7F8_573291646 = (protectedHasArray());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return protectedHasArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:52.823 -0400", hash_original_method = "371FAD0CF0C9AC8E78075F4EA52336BD", hash_generated_method = "363034E27E0AFE4833C7CE1DB3D1C651")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:52.827 -0400", hash_original_method = "C57984865448BE8CC42F7EA5DB727833", hash_generated_method = "6E90578075F3390EA6E5331368214AEE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final IntBuffer put(int[] src) {
        dsTaint.addTaint(src);
        IntBuffer var974D367CEDA780433BF9CC5389A430C6_1261149565 = (put(src, 0, src.length));
        return (IntBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return put(src, 0, src.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:52.828 -0400", hash_original_method = "E12C5DD5606B4F94202BB1F980DCA32C", hash_generated_method = "3BB4F4D17CB5D8954A15A4830F155DF6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IntBuffer put(int[] src, int srcOffset, int intCount) {
        dsTaint.addTaint(intCount);
        dsTaint.addTaint(src);
        dsTaint.addTaint(srcOffset);
        Arrays.checkOffsetAndCount(src.length, srcOffset, intCount);
        {
            boolean var88D58DBFE8E26BEBC18FDE3265CF76EF_283483340 = (intCount > remaining());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:52.842 -0400", hash_original_method = "874C21D5B52E872502D97AA1BF44CEA1", hash_generated_method = "77734EECDAD22817D7121822CCB4E961")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IntBuffer put(IntBuffer src) {
        dsTaint.addTaint(src.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        {
            boolean var6E2E81EBCD4D9A6ACDDC12CE61513AA8_386808157 = (src.remaining() > remaining());
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


