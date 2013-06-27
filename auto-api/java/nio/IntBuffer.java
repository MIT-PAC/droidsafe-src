package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Arrays;

public abstract class IntBuffer extends Buffer implements Comparable<IntBuffer> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.677 -0400", hash_original_method = "BC7C458D54C7EF00271779F9364447AB", hash_generated_method = "170567E1C278C9849B896D5CC60CA702")
      IntBuffer(int capacity) {
        super(2, capacity, null);
        addTaint(capacity);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.678 -0400", hash_original_method = "D78164E532496862518F1BC4BDE62DEB", hash_generated_method = "B7FB4D4C78221E17F83E2A1C372D9E41")
    public final int[] array() {
        int[] varEA57FBC16B997AC0E679F048893AC79C_231522221 = (protectedArray());
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_1159750553 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_1159750553;
        // ---------- Original Method ----------
        //return protectedArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.694 -0400", hash_original_method = "0D5EF56CBEA1DA16093A6276D10D9347", hash_generated_method = "CB55A3D77D991C283A25AF6762D8582F")
    public final int arrayOffset() {
        int var457EDFAA982472962568D68CBF588B38_878077126 = (protectedArrayOffset());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_605473676 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_605473676;
        // ---------- Original Method ----------
        //return protectedArrayOffset();
    }

    
    public abstract IntBuffer asReadOnlyBuffer();

    
    public abstract IntBuffer compact();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.699 -0400", hash_original_method = "E9F1AE5FDD3CB99604FBE90C4DDAAAAA", hash_generated_method = "57FA1E008C28140AAA62594C99B272CC")
    public int compareTo(IntBuffer otherBuffer) {
        int compareRemaining;
        boolean var4BCBF0874E5D33E29652A3CCB2245276_1190270348 = ((remaining() < otherBuffer.remaining()));
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
        int var51CE6C8A0A6AF44D4BCA06BE06554AF8_146752987 = (remaining() - otherBuffer.remaining());
        addTaint(otherBuffer.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1597829076 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1597829076;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.700 -0400", hash_original_method = "43D7EA8D2B4C608B648102E9AA040456", hash_generated_method = "A94C5726AFA3CAB67212C5ADE9256161")
    @Override
    public boolean equals(Object other) {
        IntBuffer otherBuffer;
        otherBuffer = (IntBuffer) other;
        {
            boolean var0A43D7921CE313B818348D8F01F0C8D5_1962941416 = (remaining() != otherBuffer.remaining());
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_184345845 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_184345845;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.700 -0400", hash_original_method = "257B404B7D2C714566C75E4EA0767CA2", hash_generated_method = "15794DD05998F85DB09EB1742F18ECD5")
    public IntBuffer get(int[] dst) {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_618162702 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_618162702 = get(dst, 0, dst.length);
        addTaint(dst[0]);
        varB4EAC82CA7396A68D541C85D26508E83_618162702.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_618162702;
        // ---------- Original Method ----------
        //return get(dst, 0, dst.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.701 -0400", hash_original_method = "72F522BE346D267FC1DB76B8F081AACA", hash_generated_method = "2B96727FD2AAB5F443A2AD5CCB6D925E")
    public IntBuffer get(int[] dst, int dstOffset, int intCount) {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_193371466 = null; //Variable for return #1
        Arrays.checkOffsetAndCount(dst.length, dstOffset, intCount);
        {
            boolean var88D58DBFE8E26BEBC18FDE3265CF76EF_186660114 = (intCount > remaining());
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
        varB4EAC82CA7396A68D541C85D26508E83_193371466 = this;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(intCount);
        varB4EAC82CA7396A68D541C85D26508E83_193371466.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_193371466;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.701 -0400", hash_original_method = "89C81F0EAF8FCCBFE368437CC8972DD7", hash_generated_method = "826B7FC097F66B8B99177D71D526C387")
    public final boolean hasArray() {
        boolean varADF219B8DAB0ACF2FCC593A6A216A7F8_1995820630 = (protectedHasArray());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_865654674 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_865654674;
        // ---------- Original Method ----------
        //return protectedHasArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.702 -0400", hash_original_method = "371FAD0CF0C9AC8E78075F4EA52336BD", hash_generated_method = "5C9CD274C87765242A4A4294D30CC830")
    @Override
    public int hashCode() {
        int myPosition;
        myPosition = position;
        int hash;
        hash = 0;
        {
            hash = hash + get(myPosition++);
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_164606376 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_164606376;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.717 -0400", hash_original_method = "C57984865448BE8CC42F7EA5DB727833", hash_generated_method = "C39322728A2E615464188C0C8F193F4A")
    public final IntBuffer put(int[] src) {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_2003006293 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2003006293 = put(src, 0, src.length);
        addTaint(src[0]);
        varB4EAC82CA7396A68D541C85D26508E83_2003006293.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2003006293;
        // ---------- Original Method ----------
        //return put(src, 0, src.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.718 -0400", hash_original_method = "E12C5DD5606B4F94202BB1F980DCA32C", hash_generated_method = "B90465F55E4B49641A3376E61F9D0C96")
    public IntBuffer put(int[] src, int srcOffset, int intCount) {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_1506284743 = null; //Variable for return #1
        Arrays.checkOffsetAndCount(src.length, srcOffset, intCount);
        {
            boolean var88D58DBFE8E26BEBC18FDE3265CF76EF_1024221716 = (intCount > remaining());
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
        varB4EAC82CA7396A68D541C85D26508E83_1506284743 = this;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(intCount);
        varB4EAC82CA7396A68D541C85D26508E83_1506284743.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1506284743;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.719 -0400", hash_original_method = "874C21D5B52E872502D97AA1BF44CEA1", hash_generated_method = "3F9E38EF1BC51FE6FFFB946B0C2AF029")
    public IntBuffer put(IntBuffer src) {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_639974058 = null; //Variable for return #1
        {
            boolean var9C07FD71E9483B067CE073F58225A0C4_236143557 = (src == this);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var6E2E81EBCD4D9A6ACDDC12CE61513AA8_857982008 = (src.remaining() > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
            } //End block
        } //End collapsed parenthetic
        int[] contents;
        contents = new int[src.remaining()];
        src.get(contents);
        put(contents);
        varB4EAC82CA7396A68D541C85D26508E83_639974058 = this;
        addTaint(src.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_639974058.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_639974058;
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

