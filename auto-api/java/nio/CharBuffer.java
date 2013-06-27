package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.util.Arrays;

public abstract class CharBuffer extends Buffer implements Comparable<CharBuffer>, CharSequence, Appendable, Readable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.014 -0400", hash_original_method = "295C6F316A1C76C71107A06FE21F48B5", hash_generated_method = "856FDA6EDC6BF7740B409AA337EC184E")
      CharBuffer(int capacity) {
        super(1, capacity, null);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
        public static CharBuffer allocate(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }
        return new ReadWriteCharArrayBuffer(capacity);
    }

    
        public static CharBuffer wrap(char[] array) {
        return wrap(array, 0, array.length);
    }

    
        public static CharBuffer wrap(char[] array, int start, int charCount) {
        Arrays.checkOffsetAndCount(array.length, start, charCount);
        CharBuffer buf = new ReadWriteCharArrayBuffer(array);
        buf.position = start;
        buf.limit = start + charCount;
        return buf;
    }

    
        public static CharBuffer wrap(CharSequence chseq) {
        return new CharSequenceAdapter(chseq);
    }

    
        public static CharBuffer wrap(CharSequence cs, int start, int end) {
        if (start < 0 || end < start || end > cs.length()) {
            throw new IndexOutOfBoundsException("cs.length()=" + cs.length() + ", start=" + start + ", end=" + end);
        }
        CharBuffer result = new CharSequenceAdapter(cs);
        result.position = start;
        result.limit = end;
        return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.034 -0400", hash_original_method = "B8788BC8872EF40BE08078E90206AB2A", hash_generated_method = "523B8EE38E1FD9B87E18C6A5C9DE1797")
    public final char[] array() {
        char[] varEA57FBC16B997AC0E679F048893AC79C_1835644584 = (protectedArray());
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_1657208503 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_1657208503;
        // ---------- Original Method ----------
        //return protectedArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.034 -0400", hash_original_method = "0D5EF56CBEA1DA16093A6276D10D9347", hash_generated_method = "95ED5B316363703F63B974D596781D7D")
    public final int arrayOffset() {
        int var457EDFAA982472962568D68CBF588B38_2126715793 = (protectedArrayOffset());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_88998803 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_88998803;
        // ---------- Original Method ----------
        //return protectedArrayOffset();
    }

    
    public abstract CharBuffer asReadOnlyBuffer();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.035 -0400", hash_original_method = "064ED2665DC7B0A0ED1B4C93428755B4", hash_generated_method = "0960DBDC6BB12BDC319877F28B969A1C")
    public final char charAt(int index) {
        {
            boolean var4ECF37DCE46CD97026588B8CEB8EE405_55988409 = (index < 0 || index >= remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("index=" + index + ", remaining()=" + remaining());
            } //End block
        } //End collapsed parenthetic
        char varC2865EDF4A02BF97D1DEE96A531B3DC7_558656017 = (get(position + index));
        addTaint(index);
        char varA87DEB01C5F539E6BDA34829C8EF2368_1534677295 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1534677295;
        // ---------- Original Method ----------
        //if (index < 0 || index >= remaining()) {
            //throw new IndexOutOfBoundsException("index=" + index + ", remaining()=" + remaining());
        //}
        //return get(position + index);
    }

    
    public abstract CharBuffer compact();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.038 -0400", hash_original_method = "726E488C44BA42D1E85B63DB9E089EB1", hash_generated_method = "7BA3B47A274349C95F370DE69089EF60")
    public int compareTo(CharBuffer otherBuffer) {
        int compareRemaining;
        boolean var4BCBF0874E5D33E29652A3CCB2245276_1355493851 = ((remaining() < otherBuffer.remaining()));
        compareRemaining = remaining();
        compareRemaining = otherBuffer.remaining();
        int thisPos;
        thisPos = position;
        int otherPos;
        otherPos = otherBuffer.position;
        char thisByte, otherByte;
        {
            thisByte = get(thisPos);
            otherByte = otherBuffer.get(otherPos);
        } //End block
        int var51CE6C8A0A6AF44D4BCA06BE06554AF8_1624254518 = (remaining() - otherBuffer.remaining());
        addTaint(otherBuffer.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_375870692 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_375870692;
        // ---------- Original Method ----------
        //int compareRemaining = (remaining() < otherBuffer.remaining()) ? remaining()
                //: otherBuffer.remaining();
        //int thisPos = position;
        //int otherPos = otherBuffer.position;
        //char thisByte, otherByte;
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

    
    public abstract CharBuffer duplicate();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.039 -0400", hash_original_method = "43FFCFC26BAE21B80C74493A78B534C8", hash_generated_method = "310BD55ACF7FE1D6903FC084042FBB50")
    @Override
    public boolean equals(Object other) {
        CharBuffer otherBuffer;
        otherBuffer = (CharBuffer) other;
        {
            boolean var0A43D7921CE313B818348D8F01F0C8D5_430124686 = (remaining() != otherBuffer.remaining());
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_776167969 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_776167969;
        // ---------- Original Method ----------
        //if (!(other instanceof CharBuffer)) {
            //return false;
        //}
        //CharBuffer otherBuffer = (CharBuffer) other;
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

    
    public abstract char get();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.050 -0400", hash_original_method = "CCEA164926296D5352A245D12A0C46F5", hash_generated_method = "14E48D847311C46BA784C4BC3875C73E")
    public CharBuffer get(char[] dst) {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_1063502494 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1063502494 = get(dst, 0, dst.length);
        addTaint(dst[0]);
        varB4EAC82CA7396A68D541C85D26508E83_1063502494.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1063502494;
        // ---------- Original Method ----------
        //return get(dst, 0, dst.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.052 -0400", hash_original_method = "098FD190C217FD14B547D1BC38021C90", hash_generated_method = "037ECEF8BCFC2C65C55D0FAD438143B1")
    public CharBuffer get(char[] dst, int dstOffset, int charCount) {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_1581562188 = null; //Variable for return #1
        Arrays.checkOffsetAndCount(dst.length, dstOffset, charCount);
        {
            boolean varD6CE167C3592D038C7B14F59C84C4F0D_414305511 = (charCount > remaining());
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
        varB4EAC82CA7396A68D541C85D26508E83_1581562188 = this;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(charCount);
        varB4EAC82CA7396A68D541C85D26508E83_1581562188.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1581562188;
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(dst.length, dstOffset, charCount);
        //if (charCount > remaining()) {
            //throw new BufferUnderflowException();
        //}
        //for (int i = dstOffset; i < dstOffset + charCount; ++i) {
            //dst[i] = get();
        //}
        //return this;
    }

    
    public abstract char get(int index);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.052 -0400", hash_original_method = "89C81F0EAF8FCCBFE368437CC8972DD7", hash_generated_method = "72153AF1C54C31F02B7AE08CCB0D23AB")
    public final boolean hasArray() {
        boolean varADF219B8DAB0ACF2FCC593A6A216A7F8_1414545206 = (protectedHasArray());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_607179533 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_607179533;
        // ---------- Original Method ----------
        //return protectedHasArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.057 -0400", hash_original_method = "371FAD0CF0C9AC8E78075F4EA52336BD", hash_generated_method = "317976F0604E6E32B8CF7683DFB1158E")
    @Override
    public int hashCode() {
        int myPosition;
        myPosition = position;
        int hash;
        hash = 0;
        {
            hash = hash + get(myPosition++);
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1631671199 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1631671199;
        // ---------- Original Method ----------
        //int myPosition = position;
        //int hash = 0;
        //while (myPosition < limit) {
            //hash = hash + get(myPosition++);
        //}
        //return hash;
    }

    
    public abstract boolean isDirect();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.057 -0400", hash_original_method = "C49AE9EB347B20902074CA3EBA57FA96", hash_generated_method = "CADB3440AC8A085566AF925E31FCA275")
    public final int length() {
        int var5DBBE6ED518DFC3A55716B7433B673CB_316481278 = (remaining());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_372396640 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_372396640;
        // ---------- Original Method ----------
        //return remaining();
    }

    
    public abstract ByteOrder order();

    
    abstract char[] protectedArray();

    
    abstract int protectedArrayOffset();

    
    abstract boolean protectedHasArray();

    
    public abstract CharBuffer put(char c);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.063 -0400", hash_original_method = "470B54D034ECB079323054E5FA7FB003", hash_generated_method = "FAAD87EC2B5DCBBCFD01B8494F581FE3")
    public final CharBuffer put(char[] src) {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_1246176266 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1246176266 = put(src, 0, src.length);
        addTaint(src[0]);
        varB4EAC82CA7396A68D541C85D26508E83_1246176266.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1246176266;
        // ---------- Original Method ----------
        //return put(src, 0, src.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.063 -0400", hash_original_method = "022BE284F152CDC3C1FB1410D39A7C9D", hash_generated_method = "EB6C0EAF5964187D9B50390482107A97")
    public CharBuffer put(char[] src, int srcOffset, int charCount) {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_644464391 = null; //Variable for return #1
        Arrays.checkOffsetAndCount(src.length, srcOffset, charCount);
        {
            boolean varD6CE167C3592D038C7B14F59C84C4F0D_781280798 = (charCount > remaining());
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
        varB4EAC82CA7396A68D541C85D26508E83_644464391 = this;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(charCount);
        varB4EAC82CA7396A68D541C85D26508E83_644464391.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_644464391;
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(src.length, srcOffset, charCount);
        //if (charCount > remaining()) {
            //throw new BufferOverflowException();
        //}
        //for (int i = srcOffset; i < srcOffset + charCount; ++i) {
            //put(src[i]);
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.067 -0400", hash_original_method = "37C3423DFAF6E5EC51AB38006AB488BA", hash_generated_method = "A8E0BEAAC4270664C031406BB04A67F0")
    public CharBuffer put(CharBuffer src) {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_864766687 = null; //Variable for return #1
        {
            boolean var9C07FD71E9483B067CE073F58225A0C4_244455451 = (src == this);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var6E2E81EBCD4D9A6ACDDC12CE61513AA8_1204953320 = (src.remaining() > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
            } //End block
        } //End collapsed parenthetic
        char[] contents;
        contents = new char[src.remaining()];
        src.get(contents);
        put(contents);
        varB4EAC82CA7396A68D541C85D26508E83_864766687 = this;
        addTaint(src.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_864766687.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_864766687;
        // ---------- Original Method ----------
        //if (src == this) {
            //throw new IllegalArgumentException();
        //}
        //if (src.remaining() > remaining()) {
            //throw new BufferOverflowException();
        //}
        //char[] contents = new char[src.remaining()];
        //src.get(contents);
        //put(contents);
        //return this;
    }

    
    public abstract CharBuffer put(int index, char c);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.080 -0400", hash_original_method = "E7006B831E6768B620311924466DB7A4", hash_generated_method = "4178A2B239FF7A9A7B09BB522F1059BB")
    public final CharBuffer put(String str) {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_1181967741 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1181967741 = put(str, 0, str.length());
        addTaint(str.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1181967741.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1181967741;
        // ---------- Original Method ----------
        //return put(str, 0, str.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.095 -0400", hash_original_method = "D2CD34EAF4E6074C289823E8F75291E2", hash_generated_method = "7E6319BCC7F27A40605498CBF13E9813")
    public CharBuffer put(String str, int start, int end) {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_2082491757 = null; //Variable for return #1
        {
            boolean varAA8B509CC93457664907255BA5D18238_1023912509 = (start < 0 || end < start || end > str.length());
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("str.length()=" + str.length() +
                    ", start=" + start + ", end=" + end);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var844D30051199F41003AA89FFC0C4F8E0_993147702 = (end - start > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
            } //End block
        } //End collapsed parenthetic
        {
            int i;
            i = start;
            {
                put(str.charAt(i));
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_2082491757 = this;
        addTaint(str.getTaint());
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_2082491757.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2082491757;
        // ---------- Original Method ----------
        //if (start < 0 || end < start || end > str.length()) {
            //throw new IndexOutOfBoundsException("str.length()=" + str.length() +
                    //", start=" + start + ", end=" + end);
        //}
        //if (end - start > remaining()) {
            //throw new BufferOverflowException();
        //}
        //for (int i = start; i < end; i++) {
            //put(str.charAt(i));
        //}
        //return this;
    }

    
    public abstract CharBuffer slice();

    
    public abstract CharSequence subSequence(int start, int end);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.097 -0400", hash_original_method = "7C6B898DBE310393A5687B676A637050", hash_generated_method = "A9BF3DC0D53EFE0DA402C7B1879702E4")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_2038610642 = null; //Variable for return #1
        StringBuilder result;
        result = new StringBuilder(limit - position);
        {
            int i;
            i = position;
            {
                result.append(get(i));
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_2038610642 = result.toString();
        varB4EAC82CA7396A68D541C85D26508E83_2038610642.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2038610642;
        // ---------- Original Method ----------
        //StringBuilder result = new StringBuilder(limit - position);
        //for (int i = position; i < limit; i++) {
            //result.append(get(i));
        //}
        //return result.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.097 -0400", hash_original_method = "B2B921133AE3BAD544E239EA4D0BB16C", hash_generated_method = "97A0D1BE37E767133F7A721A0EC9A2DE")
    public CharBuffer append(char c) {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_340325827 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_340325827 = put(c);
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_340325827.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_340325827;
        // ---------- Original Method ----------
        //return put(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.098 -0400", hash_original_method = "832DE990D6C4F53D8F1E55F3872916C2", hash_generated_method = "550BB6FEDC7BA55D897EEFABB58371EF")
    public CharBuffer append(CharSequence csq) {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_179733931 = null; //Variable for return #1
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_1102384601 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_179733931 = put(csq.toString());
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1102384601 = put("null");
        addTaint(csq.getTaint());
        CharBuffer varA7E53CE21691AB073D9660D615818899_89696712; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_89696712 = varB4EAC82CA7396A68D541C85D26508E83_179733931;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_89696712 = varB4EAC82CA7396A68D541C85D26508E83_1102384601;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_89696712.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_89696712;
        // ---------- Original Method ----------
        //if (csq != null) {
            //return put(csq.toString());
        //}
        //return put("null");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.098 -0400", hash_original_method = "006D95454A8B407A6CE6A3881397CD6E", hash_generated_method = "82D12D85BB34EF9B078C9B17307E1E20")
    public CharBuffer append(CharSequence csq, int start, int end) {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_507287826 = null; //Variable for return #1
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_438805499 = null; //Variable for return #2
        {
            csq = "null";
        } //End block
        CharSequence cs;
        cs = csq.subSequence(start, end);
        {
            boolean varB311465800DC0596CEA6EA9DA57DCEE0_627196434 = (cs.length() > 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_507287826 = put(cs.toString());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_438805499 = this;
        addTaint(csq.getTaint());
        addTaint(start);
        addTaint(end);
        CharBuffer varA7E53CE21691AB073D9660D615818899_1812753503; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1812753503 = varB4EAC82CA7396A68D541C85D26508E83_507287826;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1812753503 = varB4EAC82CA7396A68D541C85D26508E83_438805499;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1812753503.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1812753503;
        // ---------- Original Method ----------
        //if (csq == null) {
            //csq = "null";
        //}
        //CharSequence cs = csq.subSequence(start, end);
        //if (cs.length() > 0) {
            //return put(cs.toString());
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.099 -0400", hash_original_method = "412283507A99EDD12D2C7BFEC4EFD5FB", hash_generated_method = "EE241BA28EEA8E291B9334D9CD7FEE79")
    public int read(CharBuffer target) throws IOException {
        int remaining;
        remaining = remaining();
        {
            boolean var47D0651F82DAAD38F2B0DC43BE2747A5_1913684349 = (target == this);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
        } //End collapsed parenthetic
        {
            {
                boolean var19F2B3013B13D8C68161600448C63B08_1628877520 = (limit > 0 && target.remaining() == 0);
            } //End flattened ternary
        } //End block
        remaining = Math.min(target.remaining(), remaining);
        {
            char[] chars;
            chars = new char[remaining];
            get(chars);
            target.put(chars);
        } //End block
        addTaint(target.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_589025902 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_589025902;
        // ---------- Original Method ----------
        //int remaining = remaining();
        //if (target == this) {
            //if (remaining == 0) {
                //return -1;
            //}
            //throw new IllegalArgumentException();
        //}
        //if (remaining == 0) {
            //return limit > 0 && target.remaining() == 0 ? 0 : -1;
        //}
        //remaining = Math.min(target.remaining(), remaining);
        //if (remaining > 0) {
            //char[] chars = new char[remaining];
            //get(chars);
            //target.put(chars);
        //}
        //return remaining;
    }

    
}

