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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:17.692 -0400", hash_original_method = "295C6F316A1C76C71107A06FE21F48B5", hash_generated_method = "7E54C63129FEE89C3388B7B9644C7A64")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     CharBuffer(int capacity) {
        super(1, capacity, null);
        dsTaint.addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:17.699 -0400", hash_original_method = "8E15B4BAB979FFE1D8AD7F6E38D447D6", hash_generated_method = "C5F8F31431C8864718BD1CDDB3322B44")
    public static CharBuffer allocate(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }
        return new ReadWriteCharArrayBuffer(capacity);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:17.703 -0400", hash_original_method = "D9A2F140B5EF04EB7DEC41094ED7E8AE", hash_generated_method = "65ED0488DDDF29B220084A330F6927CA")
    public static CharBuffer wrap(char[] array) {
        return wrap(array, 0, array.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:17.706 -0400", hash_original_method = "F4BBCADC2CAAE6F42E5D0A764115F8AA", hash_generated_method = "D5490944D7BAD3977680C13B7CFB7E2A")
    public static CharBuffer wrap(char[] array, int start, int charCount) {
        Arrays.checkOffsetAndCount(array.length, start, charCount);
        CharBuffer buf = new ReadWriteCharArrayBuffer(array);
        buf.position = start;
        buf.limit = start + charCount;
        return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:17.709 -0400", hash_original_method = "A0EB00DB48D8743104B82F6C26C74F16", hash_generated_method = "EBAB227E99E79F26C2763E8C24D9BF33")
    public static CharBuffer wrap(CharSequence chseq) {
        return new CharSequenceAdapter(chseq);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:17.715 -0400", hash_original_method = "6F90926803EA51F00CE00F4590525589", hash_generated_method = "D9FFB72AF163F0ACAE0C27A8A19234D4")
    public static CharBuffer wrap(CharSequence cs, int start, int end) {
        if (start < 0 || end < start || end > cs.length()) {
            throw new IndexOutOfBoundsException("cs.length()=" + cs.length() + ", start=" + start + ", end=" + end);
        }
        CharBuffer result = new CharSequenceAdapter(cs);
        result.position = start;
        result.limit = end;
        return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:17.720 -0400", hash_original_method = "B8788BC8872EF40BE08078E90206AB2A", hash_generated_method = "968A18421FAD93575A4879795148CC87")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final char[] array() {
        char[] varEA57FBC16B997AC0E679F048893AC79C_2027793250 = (protectedArray());
        char[] retVal = new char[1];
        retVal[0] = dsTaint.getTaintString().charAt(0);
        return retVal;
        // ---------- Original Method ----------
        //return protectedArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:17.727 -0400", hash_original_method = "0D5EF56CBEA1DA16093A6276D10D9347", hash_generated_method = "2030F71CD0572C20BE62A5550E54553D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int arrayOffset() {
        int var457EDFAA982472962568D68CBF588B38_1922173723 = (protectedArrayOffset());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return protectedArrayOffset();
    }

    
    public abstract CharBuffer asReadOnlyBuffer();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:17.743 -0400", hash_original_method = "064ED2665DC7B0A0ED1B4C93428755B4", hash_generated_method = "202D8CFB0C9441DF9EDF4A200CA86E52")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final char charAt(int index) {
        dsTaint.addTaint(index);
        {
            boolean var4ECF37DCE46CD97026588B8CEB8EE405_685107293 = (index < 0 || index >= remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("index=" + index + ", remaining()=" + remaining());
            } //End block
        } //End collapsed parenthetic
        char varC2865EDF4A02BF97D1DEE96A531B3DC7_1069580347 = (get(position + index));
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //if (index < 0 || index >= remaining()) {
            //throw new IndexOutOfBoundsException("index=" + index + ", remaining()=" + remaining());
        //}
        //return get(position + index);
    }

    
    public abstract CharBuffer compact();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:17.768 -0400", hash_original_method = "726E488C44BA42D1E85B63DB9E089EB1", hash_generated_method = "64365321E0884297E50CAEEC095152E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int compareTo(CharBuffer otherBuffer) {
        dsTaint.addTaint(otherBuffer.dsTaint);
        int compareRemaining;
        boolean var4BCBF0874E5D33E29652A3CCB2245276_1869223765 = ((remaining() < otherBuffer.remaining()));
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
        int var51CE6C8A0A6AF44D4BCA06BE06554AF8_1752682686 = (remaining() - otherBuffer.remaining());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:17.793 -0400", hash_original_method = "43FFCFC26BAE21B80C74493A78B534C8", hash_generated_method = "F4974608D36D0FBA9A9507EB3D1829F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object other) {
        dsTaint.addTaint(other.dsTaint);
        CharBuffer otherBuffer;
        otherBuffer = (CharBuffer) other;
        {
            boolean var0A43D7921CE313B818348D8F01F0C8D5_552717155 = (remaining() != otherBuffer.remaining());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:17.806 -0400", hash_original_method = "CCEA164926296D5352A245D12A0C46F5", hash_generated_method = "9808B14746E64DC13C3BAB3E755624C7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharBuffer get(char[] dst) {
        dsTaint.addTaint(dst);
        CharBuffer var54C52896C1D21D17FF99C7DFE6939F7B_301254569 = (get(dst, 0, dst.length));
        return (CharBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return get(dst, 0, dst.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:17.817 -0400", hash_original_method = "098FD190C217FD14B547D1BC38021C90", hash_generated_method = "AF4C19A8EDB5554E8CD10A19246CDF44")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharBuffer get(char[] dst, int dstOffset, int charCount) {
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst);
        dsTaint.addTaint(charCount);
        Arrays.checkOffsetAndCount(dst.length, dstOffset, charCount);
        {
            boolean varD6CE167C3592D038C7B14F59C84C4F0D_2033219609 = (charCount > remaining());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:17.829 -0400", hash_original_method = "89C81F0EAF8FCCBFE368437CC8972DD7", hash_generated_method = "B793CC82E448FC6D5AAD4C29949D3158")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean hasArray() {
        boolean varADF219B8DAB0ACF2FCC593A6A216A7F8_595998192 = (protectedHasArray());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return protectedHasArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:17.838 -0400", hash_original_method = "371FAD0CF0C9AC8E78075F4EA52336BD", hash_generated_method = "363034E27E0AFE4833C7CE1DB3D1C651")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:17.843 -0400", hash_original_method = "C49AE9EB347B20902074CA3EBA57FA96", hash_generated_method = "2E16ECE776D40DD0B05DA45659051EB7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int length() {
        int var5DBBE6ED518DFC3A55716B7433B673CB_1049836061 = (remaining());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return remaining();
    }

    
    public abstract ByteOrder order();

    
    abstract char[] protectedArray();

    
    abstract int protectedArrayOffset();

    
    abstract boolean protectedHasArray();

    
    public abstract CharBuffer put(char c);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:17.849 -0400", hash_original_method = "470B54D034ECB079323054E5FA7FB003", hash_generated_method = "50B8CB89AA964395688D082088F07F16")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final CharBuffer put(char[] src) {
        dsTaint.addTaint(src);
        CharBuffer var974D367CEDA780433BF9CC5389A430C6_717019562 = (put(src, 0, src.length));
        return (CharBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return put(src, 0, src.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:17.854 -0400", hash_original_method = "022BE284F152CDC3C1FB1410D39A7C9D", hash_generated_method = "0B35642BEAD7A914FACA1DBE1587B480")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharBuffer put(char[] src, int srcOffset, int charCount) {
        dsTaint.addTaint(src);
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(charCount);
        Arrays.checkOffsetAndCount(src.length, srcOffset, charCount);
        {
            boolean varD6CE167C3592D038C7B14F59C84C4F0D_1029095416 = (charCount > remaining());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:17.861 -0400", hash_original_method = "37C3423DFAF6E5EC51AB38006AB488BA", hash_generated_method = "15FEEDF8FF7ABAA94C5C72345FCE25D7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharBuffer put(CharBuffer src) {
        dsTaint.addTaint(src.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        {
            boolean var6E2E81EBCD4D9A6ACDDC12CE61513AA8_876667644 = (src.remaining() > remaining());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:17.865 -0400", hash_original_method = "E7006B831E6768B620311924466DB7A4", hash_generated_method = "0242C4E95CF10D8F2007EBF895D26FC7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final CharBuffer put(String str) {
        dsTaint.addTaint(str);
        CharBuffer varBAE47BB5E29C131ABE9D30D50FA35389_47178009 = (put(str, 0, str.length()));
        return (CharBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return put(str, 0, str.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:17.870 -0400", hash_original_method = "D2CD34EAF4E6074C289823E8F75291E2", hash_generated_method = "654CC628B42B62C9B1ACA8918E9112E4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharBuffer put(String str, int start, int end) {
        dsTaint.addTaint(str);
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        {
            boolean varAA8B509CC93457664907255BA5D18238_712574109 = (start < 0 || end < start || end > str.length());
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("str.length()=" + str.length() +
                    ", start=" + start + ", end=" + end);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var844D30051199F41003AA89FFC0C4F8E0_1054865199 = (end - start > remaining());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:17.876 -0400", hash_original_method = "7C6B898DBE310393A5687B676A637050", hash_generated_method = "6B3F5BB330D79D0C2EDF257DF861767D")
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
        String varEA70154FDA28CC59402440C6317B57EF_2062179252 = (result.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder result = new StringBuilder(limit - position);
        //for (int i = position; i < limit; i++) {
            //result.append(get(i));
        //}
        //return result.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:17.879 -0400", hash_original_method = "B2B921133AE3BAD544E239EA4D0BB16C", hash_generated_method = "CD2EB541191F3D8E1962A8FB596D663C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharBuffer append(char c) {
        dsTaint.addTaint(c);
        CharBuffer varF898650661F6764675B23F8E4D09EE02_26988576 = (put(c));
        return (CharBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return put(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:17.882 -0400", hash_original_method = "832DE990D6C4F53D8F1E55F3872916C2", hash_generated_method = "41108DF9DD1A42A0E13E33D34ACF53E4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharBuffer append(CharSequence csq) {
        dsTaint.addTaint(csq);
        {
            CharBuffer var8743683D19DAB09D6988E7CED6D40B4F_1628820402 = (put(csq.toString()));
        } //End block
        CharBuffer var5AAB307E89A47E1B3FB8C053D30A56C8_400503408 = (put("null"));
        return (CharBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (csq != null) {
            //return put(csq.toString());
        //}
        //return put("null");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:17.890 -0400", hash_original_method = "006D95454A8B407A6CE6A3881397CD6E", hash_generated_method = "7AD8056AA90A2D8CBBACD3B6921F06E0")
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
            boolean varB311465800DC0596CEA6EA9DA57DCEE0_2040566234 = (cs.length() > 0);
            {
                CharBuffer var97434868D49DBE86B196D910B13576CD_1398476913 = (put(cs.toString()));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:41:17.897 -0400", hash_original_method = "412283507A99EDD12D2C7BFEC4EFD5FB", hash_generated_method = "96E8F06A89B668C71AD91F0DC0D6F0EA")
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
                boolean var19F2B3013B13D8C68161600448C63B08_37892816 = (limit > 0 && target.remaining() == 0);
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


