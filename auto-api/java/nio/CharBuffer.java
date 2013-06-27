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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.085 -0400", hash_original_method = "295C6F316A1C76C71107A06FE21F48B5", hash_generated_method = "856FDA6EDC6BF7740B409AA337EC184E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.092 -0400", hash_original_method = "B8788BC8872EF40BE08078E90206AB2A", hash_generated_method = "BF8F89408C492ACA529F5BEBC47B4B06")
    public final char[] array() {
        char[] varEA57FBC16B997AC0E679F048893AC79C_777178801 = (protectedArray());
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_1637003235 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_1637003235;
        // ---------- Original Method ----------
        //return protectedArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.092 -0400", hash_original_method = "0D5EF56CBEA1DA16093A6276D10D9347", hash_generated_method = "FE9FD5237A8756CA6D813D2F40D7C506")
    public final int arrayOffset() {
        int var457EDFAA982472962568D68CBF588B38_1493480386 = (protectedArrayOffset());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1554093952 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1554093952;
        // ---------- Original Method ----------
        //return protectedArrayOffset();
    }

    
    public abstract CharBuffer asReadOnlyBuffer();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.092 -0400", hash_original_method = "064ED2665DC7B0A0ED1B4C93428755B4", hash_generated_method = "FAF9F965F776514BD5163F86463180B6")
    public final char charAt(int index) {
        {
            boolean var4ECF37DCE46CD97026588B8CEB8EE405_799658292 = (index < 0 || index >= remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("index=" + index + ", remaining()=" + remaining());
            } //End block
        } //End collapsed parenthetic
        char varC2865EDF4A02BF97D1DEE96A531B3DC7_2133874232 = (get(position + index));
        addTaint(index);
        char varA87DEB01C5F539E6BDA34829C8EF2368_672236356 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_672236356;
        // ---------- Original Method ----------
        //if (index < 0 || index >= remaining()) {
            //throw new IndexOutOfBoundsException("index=" + index + ", remaining()=" + remaining());
        //}
        //return get(position + index);
    }

    
    public abstract CharBuffer compact();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.093 -0400", hash_original_method = "726E488C44BA42D1E85B63DB9E089EB1", hash_generated_method = "BECA4708AE87D6BFA463C4725E827600")
    public int compareTo(CharBuffer otherBuffer) {
        int compareRemaining;
        boolean var4BCBF0874E5D33E29652A3CCB2245276_1557326021 = ((remaining() < otherBuffer.remaining()));
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
        int var51CE6C8A0A6AF44D4BCA06BE06554AF8_149673965 = (remaining() - otherBuffer.remaining());
        addTaint(otherBuffer.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1381439394 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1381439394;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.104 -0400", hash_original_method = "43FFCFC26BAE21B80C74493A78B534C8", hash_generated_method = "5428A6A7076DBEDD2AEB40FB289AA68F")
    @Override
    public boolean equals(Object other) {
        CharBuffer otherBuffer;
        otherBuffer = (CharBuffer) other;
        {
            boolean var0A43D7921CE313B818348D8F01F0C8D5_1650356907 = (remaining() != otherBuffer.remaining());
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1073099317 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1073099317;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.115 -0400", hash_original_method = "CCEA164926296D5352A245D12A0C46F5", hash_generated_method = "5C54C2C32C53EB9A7AFE3FCFDA4DA84F")
    public CharBuffer get(char[] dst) {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_2070347465 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2070347465 = get(dst, 0, dst.length);
        addTaint(dst[0]);
        varB4EAC82CA7396A68D541C85D26508E83_2070347465.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2070347465;
        // ---------- Original Method ----------
        //return get(dst, 0, dst.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.116 -0400", hash_original_method = "098FD190C217FD14B547D1BC38021C90", hash_generated_method = "F2F45D76B9C4BB2759F765BC8332D57B")
    public CharBuffer get(char[] dst, int dstOffset, int charCount) {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_1053497718 = null; //Variable for return #1
        Arrays.checkOffsetAndCount(dst.length, dstOffset, charCount);
        {
            boolean varD6CE167C3592D038C7B14F59C84C4F0D_1936803716 = (charCount > remaining());
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
        varB4EAC82CA7396A68D541C85D26508E83_1053497718 = this;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(charCount);
        varB4EAC82CA7396A68D541C85D26508E83_1053497718.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1053497718;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.117 -0400", hash_original_method = "89C81F0EAF8FCCBFE368437CC8972DD7", hash_generated_method = "F614EECAF83BEB85F6961D749980EB40")
    public final boolean hasArray() {
        boolean varADF219B8DAB0ACF2FCC593A6A216A7F8_233022980 = (protectedHasArray());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2007136344 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2007136344;
        // ---------- Original Method ----------
        //return protectedHasArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.117 -0400", hash_original_method = "371FAD0CF0C9AC8E78075F4EA52336BD", hash_generated_method = "BC01F4CE2C0F871758ACEBB513553E96")
    @Override
    public int hashCode() {
        int myPosition;
        myPosition = position;
        int hash;
        hash = 0;
        {
            hash = hash + get(myPosition++);
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_169088451 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_169088451;
        // ---------- Original Method ----------
        //int myPosition = position;
        //int hash = 0;
        //while (myPosition < limit) {
            //hash = hash + get(myPosition++);
        //}
        //return hash;
    }

    
    public abstract boolean isDirect();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.117 -0400", hash_original_method = "C49AE9EB347B20902074CA3EBA57FA96", hash_generated_method = "A5F6C24364A9C0901BC59144BF8AD334")
    public final int length() {
        int var5DBBE6ED518DFC3A55716B7433B673CB_938759061 = (remaining());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2114475676 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2114475676;
        // ---------- Original Method ----------
        //return remaining();
    }

    
    public abstract ByteOrder order();

    
    abstract char[] protectedArray();

    
    abstract int protectedArrayOffset();

    
    abstract boolean protectedHasArray();

    
    public abstract CharBuffer put(char c);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.123 -0400", hash_original_method = "470B54D034ECB079323054E5FA7FB003", hash_generated_method = "9DF07ABD049CDA130DAC0BE23AA52B17")
    public final CharBuffer put(char[] src) {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_686503687 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_686503687 = put(src, 0, src.length);
        addTaint(src[0]);
        varB4EAC82CA7396A68D541C85D26508E83_686503687.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_686503687;
        // ---------- Original Method ----------
        //return put(src, 0, src.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.143 -0400", hash_original_method = "022BE284F152CDC3C1FB1410D39A7C9D", hash_generated_method = "CBF7DDF0BAECBD3D538C1CC98BF09BB3")
    public CharBuffer put(char[] src, int srcOffset, int charCount) {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_1803528226 = null; //Variable for return #1
        Arrays.checkOffsetAndCount(src.length, srcOffset, charCount);
        {
            boolean varD6CE167C3592D038C7B14F59C84C4F0D_1830263215 = (charCount > remaining());
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
        varB4EAC82CA7396A68D541C85D26508E83_1803528226 = this;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(charCount);
        varB4EAC82CA7396A68D541C85D26508E83_1803528226.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1803528226;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.148 -0400", hash_original_method = "37C3423DFAF6E5EC51AB38006AB488BA", hash_generated_method = "0689C4B16A6D8CB4ABC3A7F7A282CA00")
    public CharBuffer put(CharBuffer src) {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_755877457 = null; //Variable for return #1
        {
            boolean var9C07FD71E9483B067CE073F58225A0C4_1132649879 = (src == this);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var6E2E81EBCD4D9A6ACDDC12CE61513AA8_524306479 = (src.remaining() > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
            } //End block
        } //End collapsed parenthetic
        char[] contents;
        contents = new char[src.remaining()];
        src.get(contents);
        put(contents);
        varB4EAC82CA7396A68D541C85D26508E83_755877457 = this;
        addTaint(src.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_755877457.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_755877457;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.152 -0400", hash_original_method = "E7006B831E6768B620311924466DB7A4", hash_generated_method = "E12024E42C9C8A73D53152B573A88CD3")
    public final CharBuffer put(String str) {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_1223073381 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1223073381 = put(str, 0, str.length());
        addTaint(str.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1223073381.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1223073381;
        // ---------- Original Method ----------
        //return put(str, 0, str.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.154 -0400", hash_original_method = "D2CD34EAF4E6074C289823E8F75291E2", hash_generated_method = "214FE9ADA24F2006DC0BE3093C84B360")
    public CharBuffer put(String str, int start, int end) {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_726816769 = null; //Variable for return #1
        {
            boolean varAA8B509CC93457664907255BA5D18238_1784232541 = (start < 0 || end < start || end > str.length());
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("str.length()=" + str.length() +
                    ", start=" + start + ", end=" + end);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var844D30051199F41003AA89FFC0C4F8E0_89220475 = (end - start > remaining());
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
        varB4EAC82CA7396A68D541C85D26508E83_726816769 = this;
        addTaint(str.getTaint());
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_726816769.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_726816769;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.154 -0400", hash_original_method = "7C6B898DBE310393A5687B676A637050", hash_generated_method = "BA8E4607CDB3432C357F3FA0662B5CC8")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1864992364 = null; //Variable for return #1
        StringBuilder result;
        result = new StringBuilder(limit - position);
        {
            int i;
            i = position;
            {
                result.append(get(i));
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1864992364 = result.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1864992364.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1864992364;
        // ---------- Original Method ----------
        //StringBuilder result = new StringBuilder(limit - position);
        //for (int i = position; i < limit; i++) {
            //result.append(get(i));
        //}
        //return result.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.155 -0400", hash_original_method = "B2B921133AE3BAD544E239EA4D0BB16C", hash_generated_method = "2A93BE7A94E5DBE02E04BB9660FCB8C1")
    public CharBuffer append(char c) {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_1607136382 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1607136382 = put(c);
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_1607136382.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1607136382;
        // ---------- Original Method ----------
        //return put(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.155 -0400", hash_original_method = "832DE990D6C4F53D8F1E55F3872916C2", hash_generated_method = "65B2A5EF6BF7C172FF8CA3F7C763F4EF")
    public CharBuffer append(CharSequence csq) {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_1981053379 = null; //Variable for return #1
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_1606172805 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1981053379 = put(csq.toString());
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1606172805 = put("null");
        addTaint(csq.getTaint());
        CharBuffer varA7E53CE21691AB073D9660D615818899_1239128211; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1239128211 = varB4EAC82CA7396A68D541C85D26508E83_1981053379;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1239128211 = varB4EAC82CA7396A68D541C85D26508E83_1606172805;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1239128211.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1239128211;
        // ---------- Original Method ----------
        //if (csq != null) {
            //return put(csq.toString());
        //}
        //return put("null");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.165 -0400", hash_original_method = "006D95454A8B407A6CE6A3881397CD6E", hash_generated_method = "12DB0BCCD4F5AAD83EB1A82FBBC1B3F7")
    public CharBuffer append(CharSequence csq, int start, int end) {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_1212302177 = null; //Variable for return #1
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_447588952 = null; //Variable for return #2
        {
            csq = "null";
        } //End block
        CharSequence cs;
        cs = csq.subSequence(start, end);
        {
            boolean varB311465800DC0596CEA6EA9DA57DCEE0_1151997069 = (cs.length() > 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1212302177 = put(cs.toString());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_447588952 = this;
        addTaint(csq.getTaint());
        addTaint(start);
        addTaint(end);
        CharBuffer varA7E53CE21691AB073D9660D615818899_2004127084; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2004127084 = varB4EAC82CA7396A68D541C85D26508E83_1212302177;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2004127084 = varB4EAC82CA7396A68D541C85D26508E83_447588952;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2004127084.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2004127084;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.182 -0400", hash_original_method = "412283507A99EDD12D2C7BFEC4EFD5FB", hash_generated_method = "968DD8C0018BAB75E046FF555C89AD78")
    public int read(CharBuffer target) throws IOException {
        int remaining;
        remaining = remaining();
        {
            boolean var47D0651F82DAAD38F2B0DC43BE2747A5_586591200 = (target == this);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
        } //End collapsed parenthetic
        {
            {
                boolean var19F2B3013B13D8C68161600448C63B08_1432735178 = (limit > 0 && target.remaining() == 0);
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_696704991 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_696704991;
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

