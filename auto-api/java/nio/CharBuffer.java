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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.544 -0400", hash_original_method = "295C6F316A1C76C71107A06FE21F48B5", hash_generated_method = "1E6FFA6D0FF59DA53979AE2CDFBEF11A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     CharBuffer(int capacity) {
        super(1, capacity, null);
        dsTaint.addTaint(capacity);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.545 -0400", hash_original_method = "B8788BC8872EF40BE08078E90206AB2A", hash_generated_method = "32B74C39D63051DF7E7E54FAC62CE8A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final char[] array() {
        char[] varEA57FBC16B997AC0E679F048893AC79C_1686872145 = (protectedArray());
        char[] retVal = new char[1];
        retVal[0] = dsTaint.getTaintString().charAt(0);
        return retVal;
        // ---------- Original Method ----------
        //return protectedArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.545 -0400", hash_original_method = "0D5EF56CBEA1DA16093A6276D10D9347", hash_generated_method = "40A13E6FC182272DFB559838D1C57012")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int arrayOffset() {
        int var457EDFAA982472962568D68CBF588B38_1631136906 = (protectedArrayOffset());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return protectedArrayOffset();
    }

    
    public abstract CharBuffer asReadOnlyBuffer();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.546 -0400", hash_original_method = "064ED2665DC7B0A0ED1B4C93428755B4", hash_generated_method = "B4F58222B3838ED65855D59B58B62309")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final char charAt(int index) {
        dsTaint.addTaint(index);
        {
            boolean var4ECF37DCE46CD97026588B8CEB8EE405_1614602360 = (index < 0 || index >= remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("index=" + index + ", remaining()=" + remaining());
            } //End block
        } //End collapsed parenthetic
        char varC2865EDF4A02BF97D1DEE96A531B3DC7_978589673 = (get(position + index));
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //if (index < 0 || index >= remaining()) {
            //throw new IndexOutOfBoundsException("index=" + index + ", remaining()=" + remaining());
        //}
        //return get(position + index);
    }

    
    public abstract CharBuffer compact();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.546 -0400", hash_original_method = "726E488C44BA42D1E85B63DB9E089EB1", hash_generated_method = "B649DC303FD3B1D54A3F853C0621A258")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int compareTo(CharBuffer otherBuffer) {
        dsTaint.addTaint(otherBuffer.dsTaint);
        int compareRemaining;
        boolean var4BCBF0874E5D33E29652A3CCB2245276_1726536350 = ((remaining() < otherBuffer.remaining()));
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
        int var51CE6C8A0A6AF44D4BCA06BE06554AF8_636605718 = (remaining() - otherBuffer.remaining());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.547 -0400", hash_original_method = "43FFCFC26BAE21B80C74493A78B534C8", hash_generated_method = "9D93CCA52A909E28AF99AB5FD393F80A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object other) {
        dsTaint.addTaint(other.dsTaint);
        CharBuffer otherBuffer;
        otherBuffer = (CharBuffer) other;
        {
            boolean var0A43D7921CE313B818348D8F01F0C8D5_1506749313 = (remaining() != otherBuffer.remaining());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.547 -0400", hash_original_method = "CCEA164926296D5352A245D12A0C46F5", hash_generated_method = "2FFB6EF7411E6542AE77327CEBB355C5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharBuffer get(char[] dst) {
        dsTaint.addTaint(dst[0]);
        CharBuffer var54C52896C1D21D17FF99C7DFE6939F7B_795356459 = (get(dst, 0, dst.length));
        return (CharBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return get(dst, 0, dst.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.547 -0400", hash_original_method = "098FD190C217FD14B547D1BC38021C90", hash_generated_method = "83B5F5593791040D309D50CBE9B12EBB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharBuffer get(char[] dst, int dstOffset, int charCount) {
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst[0]);
        dsTaint.addTaint(charCount);
        Arrays.checkOffsetAndCount(dst.length, dstOffset, charCount);
        {
            boolean varD6CE167C3592D038C7B14F59C84C4F0D_1708225193 = (charCount > remaining());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.548 -0400", hash_original_method = "89C81F0EAF8FCCBFE368437CC8972DD7", hash_generated_method = "08DE8C495995E653CDD06005A6A407EC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean hasArray() {
        boolean varADF219B8DAB0ACF2FCC593A6A216A7F8_1779320894 = (protectedHasArray());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return protectedHasArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.548 -0400", hash_original_method = "371FAD0CF0C9AC8E78075F4EA52336BD", hash_generated_method = "48881135A5C55AA9F3B219BF71BEF483")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.548 -0400", hash_original_method = "C49AE9EB347B20902074CA3EBA57FA96", hash_generated_method = "7C9EF7454EBFB9203496C61F8F67EE71")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int length() {
        int var5DBBE6ED518DFC3A55716B7433B673CB_200208957 = (remaining());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return remaining();
    }

    
    public abstract ByteOrder order();

    
    abstract char[] protectedArray();

    
    abstract int protectedArrayOffset();

    
    abstract boolean protectedHasArray();

    
    public abstract CharBuffer put(char c);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.549 -0400", hash_original_method = "470B54D034ECB079323054E5FA7FB003", hash_generated_method = "E82F7EE29AF7B4E5AB785CA95B4CC96A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final CharBuffer put(char[] src) {
        dsTaint.addTaint(src[0]);
        CharBuffer var974D367CEDA780433BF9CC5389A430C6_893309038 = (put(src, 0, src.length));
        return (CharBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return put(src, 0, src.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.549 -0400", hash_original_method = "022BE284F152CDC3C1FB1410D39A7C9D", hash_generated_method = "1CCC33E12E7083F93F4B15BC581083C5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharBuffer put(char[] src, int srcOffset, int charCount) {
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(src[0]);
        dsTaint.addTaint(charCount);
        Arrays.checkOffsetAndCount(src.length, srcOffset, charCount);
        {
            boolean varD6CE167C3592D038C7B14F59C84C4F0D_212560119 = (charCount > remaining());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.550 -0400", hash_original_method = "37C3423DFAF6E5EC51AB38006AB488BA", hash_generated_method = "05F0DEA010AD292B41462A5737994ED5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharBuffer put(CharBuffer src) {
        dsTaint.addTaint(src.dsTaint);
        {
            boolean var9C07FD71E9483B067CE073F58225A0C4_819228948 = (src == this);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var6E2E81EBCD4D9A6ACDDC12CE61513AA8_1808131044 = (src.remaining() > remaining());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.550 -0400", hash_original_method = "E7006B831E6768B620311924466DB7A4", hash_generated_method = "56898A6F6FD02FCC697FC86B8DB2BAA4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final CharBuffer put(String str) {
        dsTaint.addTaint(str);
        CharBuffer varBAE47BB5E29C131ABE9D30D50FA35389_241013681 = (put(str, 0, str.length()));
        return (CharBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return put(str, 0, str.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.550 -0400", hash_original_method = "D2CD34EAF4E6074C289823E8F75291E2", hash_generated_method = "2270E203B313A555C0E0FAB4A09824BB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharBuffer put(String str, int start, int end) {
        dsTaint.addTaint(str);
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        {
            boolean varAA8B509CC93457664907255BA5D18238_101337609 = (start < 0 || end < start || end > str.length());
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("str.length()=" + str.length() +
                    ", start=" + start + ", end=" + end);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var844D30051199F41003AA89FFC0C4F8E0_942040702 = (end - start > remaining());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.551 -0400", hash_original_method = "7C6B898DBE310393A5687B676A637050", hash_generated_method = "774813CB904EC5A03A0199AC8078DDE9")
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
        String varEA70154FDA28CC59402440C6317B57EF_1107045838 = (result.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder result = new StringBuilder(limit - position);
        //for (int i = position; i < limit; i++) {
            //result.append(get(i));
        //}
        //return result.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.551 -0400", hash_original_method = "B2B921133AE3BAD544E239EA4D0BB16C", hash_generated_method = "95A52B3C79524939A94E8D924DAB0E90")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharBuffer append(char c) {
        dsTaint.addTaint(c);
        CharBuffer varF898650661F6764675B23F8E4D09EE02_2094047774 = (put(c));
        return (CharBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return put(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.552 -0400", hash_original_method = "832DE990D6C4F53D8F1E55F3872916C2", hash_generated_method = "6AF2510E4B1786D1995116C7385959C6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharBuffer append(CharSequence csq) {
        dsTaint.addTaint(csq);
        {
            CharBuffer var8743683D19DAB09D6988E7CED6D40B4F_1275547720 = (put(csq.toString()));
        } //End block
        CharBuffer var5AAB307E89A47E1B3FB8C053D30A56C8_1354196145 = (put("null"));
        return (CharBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (csq != null) {
            //return put(csq.toString());
        //}
        //return put("null");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.552 -0400", hash_original_method = "006D95454A8B407A6CE6A3881397CD6E", hash_generated_method = "5E16873BAC309B2A82795EC2FC9E5AD5")
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
            boolean varB311465800DC0596CEA6EA9DA57DCEE0_243538988 = (cs.length() > 0);
            {
                CharBuffer var97434868D49DBE86B196D910B13576CD_446181685 = (put(cs.toString()));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.553 -0400", hash_original_method = "412283507A99EDD12D2C7BFEC4EFD5FB", hash_generated_method = "25391CF92346C647F148C91A86938755")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int read(CharBuffer target) throws IOException {
        dsTaint.addTaint(target.dsTaint);
        int remaining;
        remaining = remaining();
        {
            boolean var47D0651F82DAAD38F2B0DC43BE2747A5_716285680 = (target == this);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
        } //End collapsed parenthetic
        {
            {
                boolean var19F2B3013B13D8C68161600448C63B08_293541384 = (limit > 0 && target.remaining() == 0);
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

