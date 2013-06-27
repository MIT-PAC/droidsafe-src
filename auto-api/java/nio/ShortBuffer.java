package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Arrays;

public abstract class ShortBuffer extends Buffer implements Comparable<ShortBuffer> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.317 -0400", hash_original_method = "EAB92A092C9FEE1EEAB86C6A6FABA79C", hash_generated_method = "6318691CE755B9046B333B497AB15184")
      ShortBuffer(int capacity) {
        super(1, capacity, null);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
        public static ShortBuffer allocate(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }
        return new ReadWriteShortArrayBuffer(capacity);
    }

    
        public static ShortBuffer wrap(short[] array) {
        return wrap(array, 0, array.length);
    }

    
        public static ShortBuffer wrap(short[] array, int start, int shortCount) {
        Arrays.checkOffsetAndCount(array.length, start, shortCount);
        ShortBuffer buf = new ReadWriteShortArrayBuffer(array);
        buf.position = start;
        buf.limit = start + shortCount;
        return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.318 -0400", hash_original_method = "0A1B03C776C1004F61482923BC618EF6", hash_generated_method = "7251164BD783BED3193A9E0D4E52FB56")
    public final short[] array() {
        short[] varEA57FBC16B997AC0E679F048893AC79C_213215183 = (protectedArray());
        short[] var48EE7E2DDF8A83602BC526873BD0F875_119291203 = {getTaintShort()};
        return var48EE7E2DDF8A83602BC526873BD0F875_119291203;
        // ---------- Original Method ----------
        //return protectedArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.324 -0400", hash_original_method = "0D5EF56CBEA1DA16093A6276D10D9347", hash_generated_method = "08620A697F3277AA638C843FD213DF51")
    public final int arrayOffset() {
        int var457EDFAA982472962568D68CBF588B38_1401869284 = (protectedArrayOffset());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1251262936 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1251262936;
        // ---------- Original Method ----------
        //return protectedArrayOffset();
    }

    
    public abstract ShortBuffer asReadOnlyBuffer();

    
    public abstract ShortBuffer compact();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.325 -0400", hash_original_method = "F5228E310614FF7F70EC616A5A8F6CEB", hash_generated_method = "58F2A7BF942BE27AEEA50FB46E666444")
    public int compareTo(ShortBuffer otherBuffer) {
        int compareRemaining;
        boolean var4BCBF0874E5D33E29652A3CCB2245276_1272907090 = ((remaining() < otherBuffer.remaining()));
        compareRemaining = remaining();
        compareRemaining = otherBuffer.remaining();
        int thisPos;
        thisPos = position;
        int otherPos;
        otherPos = otherBuffer.position;
        short thisByte, otherByte;
        {
            thisByte = get(thisPos);
            otherByte = otherBuffer.get(otherPos);
        } //End block
        int var51CE6C8A0A6AF44D4BCA06BE06554AF8_981087530 = (remaining() - otherBuffer.remaining());
        addTaint(otherBuffer.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_438272308 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_438272308;
        // ---------- Original Method ----------
        //int compareRemaining = (remaining() < otherBuffer.remaining()) ? remaining()
                //: otherBuffer.remaining();
        //int thisPos = position;
        //int otherPos = otherBuffer.position;
        //short thisByte, otherByte;
        //while (compareRemaining > 0) {
            //thisByte = get(thisPos);
            //otherByte = otherBuffer.get(otherPos);
            //if (thisByte != otherByte) {
                //return thisByte < otherByte ? -1 : 1;
            //}
            //thisPos++;
            //otherPos++;
            //compareRemaining--;
        //}
        //return remaining() - otherBuffer.remaining();
    }

    
    public abstract ShortBuffer duplicate();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.326 -0400", hash_original_method = "5B31F4285E964D7BDABED3BB847D41AA", hash_generated_method = "C0D19BE36F33556EFC3B41291C13ECC1")
    @Override
    public boolean equals(Object other) {
        ShortBuffer otherBuffer;
        otherBuffer = (ShortBuffer) other;
        {
            boolean var0A43D7921CE313B818348D8F01F0C8D5_274482427 = (remaining() != otherBuffer.remaining());
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_267705599 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_267705599;
        // ---------- Original Method ----------
        //if (!(other instanceof ShortBuffer)) {
            //return false;
        //}
        //ShortBuffer otherBuffer = (ShortBuffer) other;
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

    
    public abstract short get();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.334 -0400", hash_original_method = "68406DA953A1F3530F74FC6FE1C452A7", hash_generated_method = "8330D477C537F81562F738D7759BBDF6")
    public ShortBuffer get(short[] dst) {
        ShortBuffer varB4EAC82CA7396A68D541C85D26508E83_81286637 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_81286637 = get(dst, 0, dst.length);
        addTaint(dst[0]);
        varB4EAC82CA7396A68D541C85D26508E83_81286637.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_81286637;
        // ---------- Original Method ----------
        //return get(dst, 0, dst.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.348 -0400", hash_original_method = "DE4C5284FF189AE8B07194EE8C193F03", hash_generated_method = "F6FBBD20C5CB368080B478F2F5A9FB7B")
    public ShortBuffer get(short[] dst, int dstOffset, int shortCount) {
        ShortBuffer varB4EAC82CA7396A68D541C85D26508E83_334537732 = null; //Variable for return #1
        Arrays.checkOffsetAndCount(dst.length, dstOffset, shortCount);
        {
            boolean varD727A1D2181C264BA4333582F807AE27_733228284 = (shortCount > remaining());
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
        varB4EAC82CA7396A68D541C85D26508E83_334537732 = this;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(shortCount);
        varB4EAC82CA7396A68D541C85D26508E83_334537732.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_334537732;
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(dst.length, dstOffset, shortCount);
        //if (shortCount > remaining()) {
            //throw new BufferUnderflowException();
        //}
        //for (int i = dstOffset; i < dstOffset + shortCount; ++i) {
            //dst[i] = get();
        //}
        //return this;
    }

    
    public abstract short get(int index);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.350 -0400", hash_original_method = "89C81F0EAF8FCCBFE368437CC8972DD7", hash_generated_method = "3450150E2A3E3BAB71D1E982E3477063")
    public final boolean hasArray() {
        boolean varADF219B8DAB0ACF2FCC593A6A216A7F8_1830789214 = (protectedHasArray());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_262531431 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_262531431;
        // ---------- Original Method ----------
        //return protectedHasArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.365 -0400", hash_original_method = "371FAD0CF0C9AC8E78075F4EA52336BD", hash_generated_method = "F5F36AEACD64187E046EE1073DC6D9E5")
    @Override
    public int hashCode() {
        int myPosition;
        myPosition = position;
        int hash;
        hash = 0;
        {
            hash = hash + get(myPosition++);
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1707343608 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1707343608;
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

    
    abstract short[] protectedArray();

    
    abstract int protectedArrayOffset();

    
    abstract boolean protectedHasArray();

    
    public abstract ShortBuffer put(short s);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.368 -0400", hash_original_method = "47A309F7D8F6DC58E14B9D901E5CA4EB", hash_generated_method = "52BBD86E847BB7416126EE119335DC3C")
    public final ShortBuffer put(short[] src) {
        ShortBuffer varB4EAC82CA7396A68D541C85D26508E83_1907577078 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1907577078 = put(src, 0, src.length);
        addTaint(src[0]);
        varB4EAC82CA7396A68D541C85D26508E83_1907577078.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1907577078;
        // ---------- Original Method ----------
        //return put(src, 0, src.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.377 -0400", hash_original_method = "F4EA1FDC39DA95E004DECB204CC15A47", hash_generated_method = "F6490EE80A3F466E8E90BF71C50243CE")
    public ShortBuffer put(short[] src, int srcOffset, int shortCount) {
        ShortBuffer varB4EAC82CA7396A68D541C85D26508E83_468722814 = null; //Variable for return #1
        Arrays.checkOffsetAndCount(src.length, srcOffset, shortCount);
        {
            boolean varD727A1D2181C264BA4333582F807AE27_348759570 = (shortCount > remaining());
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
        varB4EAC82CA7396A68D541C85D26508E83_468722814 = this;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(shortCount);
        varB4EAC82CA7396A68D541C85D26508E83_468722814.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_468722814;
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(src.length, srcOffset, shortCount);
        //if (shortCount > remaining()) {
            //throw new BufferOverflowException();
        //}
        //for (int i = srcOffset; i < srcOffset + shortCount; ++i) {
            //put(src[i]);
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.394 -0400", hash_original_method = "1D8FC7647B57D46D94B3AA0BA31269DF", hash_generated_method = "4AD8680F71634D3874262DA48F46FC87")
    public ShortBuffer put(ShortBuffer src) {
        ShortBuffer varB4EAC82CA7396A68D541C85D26508E83_859035090 = null; //Variable for return #1
        {
            boolean var9C07FD71E9483B067CE073F58225A0C4_360417754 = (src == this);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var6E2E81EBCD4D9A6ACDDC12CE61513AA8_456905646 = (src.remaining() > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
            } //End block
        } //End collapsed parenthetic
        short[] contents;
        contents = new short[src.remaining()];
        src.get(contents);
        put(contents);
        varB4EAC82CA7396A68D541C85D26508E83_859035090 = this;
        addTaint(src.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_859035090.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_859035090;
        // ---------- Original Method ----------
        //if (src == this) {
            //throw new IllegalArgumentException();
        //}
        //if (src.remaining() > remaining()) {
            //throw new BufferOverflowException();
        //}
        //short[] contents = new short[src.remaining()];
        //src.get(contents);
        //put(contents);
        //return this;
    }

    
    public abstract ShortBuffer put(int index, short s);

    
    public abstract ShortBuffer slice();

    
}

