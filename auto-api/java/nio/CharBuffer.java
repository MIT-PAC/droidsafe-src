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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:06.440 -0400", hash_original_method = "295C6F316A1C76C71107A06FE21F48B5", hash_generated_method = "7E54C63129FEE89C3388B7B9644C7A64")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     CharBuffer(int capacity) {
        super(1, capacity, null);
        dsTaint.addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:06.445 -0400", hash_original_method = "8E15B4BAB979FFE1D8AD7F6E38D447D6", hash_generated_method = "C5F8F31431C8864718BD1CDDB3322B44")
    public static CharBuffer allocate(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }
        return new ReadWriteCharArrayBuffer(capacity);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:06.447 -0400", hash_original_method = "D9A2F140B5EF04EB7DEC41094ED7E8AE", hash_generated_method = "65ED0488DDDF29B220084A330F6927CA")
    public static CharBuffer wrap(char[] array) {
        return wrap(array, 0, array.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:06.452 -0400", hash_original_method = "F4BBCADC2CAAE6F42E5D0A764115F8AA", hash_generated_method = "D5490944D7BAD3977680C13B7CFB7E2A")
    public static CharBuffer wrap(char[] array, int start, int charCount) {
        Arrays.checkOffsetAndCount(array.length, start, charCount);
        CharBuffer buf = new ReadWriteCharArrayBuffer(array);
        buf.position = start;
        buf.limit = start + charCount;
        return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:06.456 -0400", hash_original_method = "A0EB00DB48D8743104B82F6C26C74F16", hash_generated_method = "EBAB227E99E79F26C2763E8C24D9BF33")
    public static CharBuffer wrap(CharSequence chseq) {
        return new CharSequenceAdapter(chseq);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:06.467 -0400", hash_original_method = "6F90926803EA51F00CE00F4590525589", hash_generated_method = "D9FFB72AF163F0ACAE0C27A8A19234D4")
    public static CharBuffer wrap(CharSequence cs, int start, int end) {
        if (start < 0 || end < start || end > cs.length()) {
            throw new IndexOutOfBoundsException("cs.length()=" + cs.length() + ", start=" + start + ", end=" + end);
        }
        CharBuffer result = new CharSequenceAdapter(cs);
        result.position = start;
        result.limit = end;
        return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:06.470 -0400", hash_original_method = "B8788BC8872EF40BE08078E90206AB2A", hash_generated_method = "3FCA839D1E40FBB246D04B36E169A7EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final char[] array() {
        char[] varEA57FBC16B997AC0E679F048893AC79C_230514224 = (protectedArray());
        char[] retVal = new char[1];
        retVal[0] = dsTaint.getTaintString().charAt(0);
        return retVal;
        // ---------- Original Method ----------
        //return protectedArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:06.476 -0400", hash_original_method = "0D5EF56CBEA1DA16093A6276D10D9347", hash_generated_method = "9D49BCA6E8E4BC77F5D08476007BD0B6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int arrayOffset() {
        int var457EDFAA982472962568D68CBF588B38_984846165 = (protectedArrayOffset());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return protectedArrayOffset();
    }

    
    public abstract CharBuffer asReadOnlyBuffer();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:06.490 -0400", hash_original_method = "064ED2665DC7B0A0ED1B4C93428755B4", hash_generated_method = "9ADF0DF200AC529E06490C0853D2F1B6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final char charAt(int index) {
        dsTaint.addTaint(index);
        {
            boolean var4ECF37DCE46CD97026588B8CEB8EE405_1967824253 = (index < 0 || index >= remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("index=" + index + ", remaining()=" + remaining());
            } //End block
        } //End collapsed parenthetic
        char varC2865EDF4A02BF97D1DEE96A531B3DC7_642275940 = (get(position + index));
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //if (index < 0 || index >= remaining()) {
            //throw new IndexOutOfBoundsException("index=" + index + ", remaining()=" + remaining());
        //}
        //return get(position + index);
    }

    
    public abstract CharBuffer compact();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:06.498 -0400", hash_original_method = "726E488C44BA42D1E85B63DB9E089EB1", hash_generated_method = "995D426A42F40C524057EA33516CCF65")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int compareTo(CharBuffer otherBuffer) {
        dsTaint.addTaint(otherBuffer.dsTaint);
        int compareRemaining;
        boolean var4BCBF0874E5D33E29652A3CCB2245276_2133255415 = ((remaining() < otherBuffer.remaining()));
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
            thisPos++;
            otherPos++;
            compareRemaining--;
        } //End block
        int var51CE6C8A0A6AF44D4BCA06BE06554AF8_235440250 = (remaining() - otherBuffer.remaining());
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:06.516 -0400", hash_original_method = "43FFCFC26BAE21B80C74493A78B534C8", hash_generated_method = "C6CE9F54D07DE122BAC98E1F2F9EE6B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object other) {
        dsTaint.addTaint(other.dsTaint);
        CharBuffer otherBuffer;
        otherBuffer = (CharBuffer) other;
        {
            boolean var0A43D7921CE313B818348D8F01F0C8D5_2078803588 = (remaining() != otherBuffer.remaining());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:06.529 -0400", hash_original_method = "CCEA164926296D5352A245D12A0C46F5", hash_generated_method = "8AEFB63716DD698D3355C10BA4C5E8BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharBuffer get(char[] dst) {
        dsTaint.addTaint(dst);
        CharBuffer var54C52896C1D21D17FF99C7DFE6939F7B_2024355430 = (get(dst, 0, dst.length));
        return (CharBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return get(dst, 0, dst.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:06.541 -0400", hash_original_method = "098FD190C217FD14B547D1BC38021C90", hash_generated_method = "0FFF0A50277E54085045550BB38C2F81")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharBuffer get(char[] dst, int dstOffset, int charCount) {
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst);
        dsTaint.addTaint(charCount);
        Arrays.checkOffsetAndCount(dst.length, dstOffset, charCount);
        {
            boolean varD6CE167C3592D038C7B14F59C84C4F0D_1374196559 = (charCount > remaining());
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
        return (CharBuffer)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:06.544 -0400", hash_original_method = "89C81F0EAF8FCCBFE368437CC8972DD7", hash_generated_method = "ECD252588CEEF4038D6F029FC2B51F15")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean hasArray() {
        boolean varADF219B8DAB0ACF2FCC593A6A216A7F8_854910990 = (protectedHasArray());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return protectedHasArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:06.554 -0400", hash_original_method = "371FAD0CF0C9AC8E78075F4EA52336BD", hash_generated_method = "363034E27E0AFE4833C7CE1DB3D1C651")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:06.561 -0400", hash_original_method = "C49AE9EB347B20902074CA3EBA57FA96", hash_generated_method = "C8872B71471D5E3EA24E8FB1BA54CDEA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int length() {
        int var5DBBE6ED518DFC3A55716B7433B673CB_948815809 = (remaining());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return remaining();
    }

    
    public abstract ByteOrder order();

    
    abstract char[] protectedArray();

    
    abstract int protectedArrayOffset();

    
    abstract boolean protectedHasArray();

    
    public abstract CharBuffer put(char c);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:06.577 -0400", hash_original_method = "470B54D034ECB079323054E5FA7FB003", hash_generated_method = "4FD921D53E85C16A719A144AB71493D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final CharBuffer put(char[] src) {
        dsTaint.addTaint(src);
        CharBuffer var974D367CEDA780433BF9CC5389A430C6_31983740 = (put(src, 0, src.length));
        return (CharBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return put(src, 0, src.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:06.586 -0400", hash_original_method = "022BE284F152CDC3C1FB1410D39A7C9D", hash_generated_method = "F17F550A972269AB4323A69ECD76B332")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharBuffer put(char[] src, int srcOffset, int charCount) {
        dsTaint.addTaint(src);
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(charCount);
        Arrays.checkOffsetAndCount(src.length, srcOffset, charCount);
        {
            boolean varD6CE167C3592D038C7B14F59C84C4F0D_1389604684 = (charCount > remaining());
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
        return (CharBuffer)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:06.589 -0400", hash_original_method = "37C3423DFAF6E5EC51AB38006AB488BA", hash_generated_method = "AD73B4174705B172801873F8003FAA51")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharBuffer put(CharBuffer src) {
        dsTaint.addTaint(src.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        {
            boolean var6E2E81EBCD4D9A6ACDDC12CE61513AA8_1021716956 = (src.remaining() > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
            } //End block
        } //End collapsed parenthetic
        char[] contents;
        contents = new char[src.remaining()];
        src.get(contents);
        put(contents);
        return (CharBuffer)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:06.598 -0400", hash_original_method = "E7006B831E6768B620311924466DB7A4", hash_generated_method = "22B973291ACACFD149D55D20084B99D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final CharBuffer put(String str) {
        dsTaint.addTaint(str);
        CharBuffer varBAE47BB5E29C131ABE9D30D50FA35389_1325333369 = (put(str, 0, str.length()));
        return (CharBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return put(str, 0, str.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:06.601 -0400", hash_original_method = "D2CD34EAF4E6074C289823E8F75291E2", hash_generated_method = "7A6FCC9B3D24A12149BEF3C1D2233827")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharBuffer put(String str, int start, int end) {
        dsTaint.addTaint(str);
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        {
            boolean varAA8B509CC93457664907255BA5D18238_614854483 = (start < 0 || end < start || end > str.length());
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("str.length()=" + str.length() +
                    ", start=" + start + ", end=" + end);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var844D30051199F41003AA89FFC0C4F8E0_1503515020 = (end - start > remaining());
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
        return (CharBuffer)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:06.610 -0400", hash_original_method = "7C6B898DBE310393A5687B676A637050", hash_generated_method = "81BF0668AF0414293DED541618D87DD0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder result;
        result = new StringBuilder(limit - position);
        {
            int i;
            i = position;
            {
                result.append(get(i));
            } //End block
        } //End collapsed parenthetic
        String varEA70154FDA28CC59402440C6317B57EF_250662042 = (result.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder result = new StringBuilder(limit - position);
        //for (int i = position; i < limit; i++) {
            //result.append(get(i));
        //}
        //return result.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:06.612 -0400", hash_original_method = "B2B921133AE3BAD544E239EA4D0BB16C", hash_generated_method = "0AC160B2BE3405AF69FAF40D127D4FB9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharBuffer append(char c) {
        dsTaint.addTaint(c);
        CharBuffer varF898650661F6764675B23F8E4D09EE02_1515266822 = (put(c));
        return (CharBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return put(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:06.618 -0400", hash_original_method = "832DE990D6C4F53D8F1E55F3872916C2", hash_generated_method = "FFD3B30E2DB4348CDCD53A584BBBFA49")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharBuffer append(CharSequence csq) {
        dsTaint.addTaint(csq);
        {
            CharBuffer var8743683D19DAB09D6988E7CED6D40B4F_384416659 = (put(csq.toString()));
        } //End block
        CharBuffer var5AAB307E89A47E1B3FB8C053D30A56C8_2013773429 = (put("null"));
        return (CharBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (csq != null) {
            //return put(csq.toString());
        //}
        //return put("null");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:06.630 -0400", hash_original_method = "006D95454A8B407A6CE6A3881397CD6E", hash_generated_method = "EFA880E7D0128180C5DD06F6DE33CAA1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharBuffer append(CharSequence csq, int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(csq);
        dsTaint.addTaint(end);
        {
            csq = "null";
        } //End block
        CharSequence cs;
        cs = csq.subSequence(start, end);
        {
            boolean varB311465800DC0596CEA6EA9DA57DCEE0_115261132 = (cs.length() > 0);
            {
                CharBuffer var97434868D49DBE86B196D910B13576CD_118468231 = (put(cs.toString()));
            } //End block
        } //End collapsed parenthetic
        return (CharBuffer)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:06.646 -0400", hash_original_method = "412283507A99EDD12D2C7BFEC4EFD5FB", hash_generated_method = "26C407E35B8F857FEEE8B3DD277FA694")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int read(CharBuffer target) throws IOException {
        dsTaint.addTaint(target.dsTaint);
        int remaining;
        remaining = remaining();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        {
            {
                boolean var19F2B3013B13D8C68161600448C63B08_1590105530 = (limit > 0 && target.remaining() == 0);
            } //End flattened ternary
        } //End block
        remaining = Math.min(target.remaining(), remaining);
        {
            char[] chars;
            chars = new char[remaining];
            get(chars);
            target.put(chars);
        } //End block
        return dsTaint.getTaintInt();
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


