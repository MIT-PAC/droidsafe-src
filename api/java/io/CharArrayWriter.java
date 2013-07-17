package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Arrays;

public class CharArrayWriter extends Writer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.535 -0400", hash_original_field = "CB7E52B21171FB9A53B498202607F0BD", hash_generated_field = "F3184E7FC423A3DB65CA949884DB59BD")

    protected char[] buf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.535 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "CADFF8C1F208C99E14B28CFC1A04442F")

    protected int count;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.536 -0400", hash_original_method = "C9452FB9491532C2A6C52BB5B3D25E39", hash_generated_method = "D4173DDAE8E1B17586789B3DC5C61CB6")
    public  CharArrayWriter() {
        buf = new char[32];
        lock = buf;
        // ---------- Original Method ----------
        //buf = new char[32];
        //lock = buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.536 -0400", hash_original_method = "71C0EC52128D22FED2D8659A81B00E37", hash_generated_method = "95846B6CBCB309B95BD87C66439564E2")
    public  CharArrayWriter(int initialSize) {
        if(initialSize < 0)        
        {
            IllegalArgumentException var2382BBC2482763F398967EC587DEA9AE_1904786646 = new IllegalArgumentException("size < 0");
            var2382BBC2482763F398967EC587DEA9AE_1904786646.addTaint(taint);
            throw var2382BBC2482763F398967EC587DEA9AE_1904786646;
        } //End block
        buf = new char[initialSize];
        lock = buf;
        // ---------- Original Method ----------
        //if (initialSize < 0) {
            //throw new IllegalArgumentException("size < 0");
        //}
        //buf = new char[initialSize];
        //lock = buf;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.537 -0400", hash_original_method = "B96EF178F3ED1A0DFACDA94649407E5C", hash_generated_method = "1A3F8C083102602A57FB2D0CBE40EA76")
    @Override
    public void close() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.537 -0400", hash_original_method = "74E26FDF253668E5689F73596E4C1217", hash_generated_method = "C52FC5F77B02935642B6F8DEFE2250FA")
    private void expand(int i) {
        addTaint(i);
        if(count + i <= buf.length)        
        {
            return;
        } //End block
        int newLen = Math.max(2 * buf.length, count + i);
        char[] newbuf = new char[newLen];
        System.arraycopy(buf, 0, newbuf, 0, count);
        buf = newbuf;
        // ---------- Original Method ----------
        //if (count + i <= buf.length) {
            //return;
        //}
        //int newLen = Math.max(2 * buf.length, count + i);
        //char[] newbuf = new char[newLen];
        //System.arraycopy(buf, 0, newbuf, 0, count);
        //buf = newbuf;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.538 -0400", hash_original_method = "336EB9AA03C5B902D3CE726BD69F433F", hash_generated_method = "4A4713C8ADAF7778CF4E4BBDA39355C2")
    @Override
    public void flush() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.538 -0400", hash_original_method = "41854ED78018FCB86E06DA2ADE584B53", hash_generated_method = "EF66D3120D8A5048C78C67480E598644")
    public void reset() {
        synchronized
(lock)        {
            count = 0;
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //count = 0;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.539 -0400", hash_original_method = "796F2451CF9DC3EF411446EADA3F03C7", hash_generated_method = "E04CB8783C54ECAFDEA2710B09B25879")
    public int size() {
        synchronized
(lock)        {
            int varE2942A04780E223B215EB8B663CF5353_309710168 = (count);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2048693481 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2048693481;
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //return count;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.539 -0400", hash_original_method = "A3DCAA229974F9979554B7E0F1F4EF9F", hash_generated_method = "C983CD6DF37E752B3104C012C31217D9")
    public char[] toCharArray() {
        synchronized
(lock)        {
            char[] result = new char[count];
            System.arraycopy(buf, 0, result, 0, count);
            char[] varB4A88417B3D0170D754C647C30B7216A_445958691 = (result);
                        char[] var50607924ABD4C17119BAF3A1CE41C0EC_131134873 = {getTaintChar()};
            return var50607924ABD4C17119BAF3A1CE41C0EC_131134873;
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //char[] result = new char[count];
            //System.arraycopy(buf, 0, result, 0, count);
            //return result;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.540 -0400", hash_original_method = "F9B2EF7C65F2F351A8955F413D7A1883", hash_generated_method = "A652D21F1F13D33BC318A2593F7BE013")
    @Override
    public String toString() {
        synchronized
(lock)        {
String var284A4624AC5D82C1992013009E0FB870_1543673132 =             new String(buf, 0, count);
            var284A4624AC5D82C1992013009E0FB870_1543673132.addTaint(taint);
            return var284A4624AC5D82C1992013009E0FB870_1543673132;
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //return new String(buf, 0, count);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.541 -0400", hash_original_method = "17F94D6158075BE971F02096E85AEF33", hash_generated_method = "93847812E3AD8CFF2A91074835AFA875")
    @Override
    public void write(char[] buffer, int offset, int len) {
        addTaint(offset);
        addTaint(buffer[0]);
        Arrays.checkOffsetAndCount(buffer.length, offset, len);
        synchronized
(lock)        {
            expand(len);
            System.arraycopy(buffer, offset, this.buf, this.count, len);
            this.count += len;
        } //End block
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(buffer.length, offset, len);
        //synchronized (lock) {
            //expand(len);
            //System.arraycopy(buffer, offset, this.buf, this.count, len);
            //this.count += len;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.542 -0400", hash_original_method = "F6D5648087F216C6BFDCFB078373F01B", hash_generated_method = "98F21E0D181DB75A943801F4748A9B8D")
    @Override
    public void write(int oneChar) {
        synchronized
(lock)        {
            expand(1);
            buf[count++] = (char) oneChar;
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //expand(1);
            //buf[count++] = (char) oneChar;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.544 -0400", hash_original_method = "9F8082FBB1391041DAA8F1A348E27C2A", hash_generated_method = "3FD172E3D82C11935B79326A32D3FFCC")
    @Override
    public void write(String str, int offset, int count) {
        addTaint(offset);
        addTaint(str.getTaint());
        if(str == null)        
        {
            NullPointerException varBAAB5D2ADD4C016ACB92A2133697155C_1787967377 = new NullPointerException("str == null");
            varBAAB5D2ADD4C016ACB92A2133697155C_1787967377.addTaint(taint);
            throw varBAAB5D2ADD4C016ACB92A2133697155C_1787967377;
        } //End block
        if((offset | count) < 0 || offset > str.length() - count)        
        {
            StringIndexOutOfBoundsException varDD6466A465572C8C2EC4C6C733FC9AF8_1627356946 = new StringIndexOutOfBoundsException(str, offset, count);
            varDD6466A465572C8C2EC4C6C733FC9AF8_1627356946.addTaint(taint);
            throw varDD6466A465572C8C2EC4C6C733FC9AF8_1627356946;
        } //End block
        synchronized
(lock)        {
            expand(count);
            str.getChars(offset, offset + count, buf, this.count);
            this.count += count;
        } //End block
        // ---------- Original Method ----------
        //if (str == null) {
            //throw new NullPointerException("str == null");
        //}
        //if ((offset | count) < 0 || offset > str.length() - count) {
            //throw new StringIndexOutOfBoundsException(str, offset, count);
        //}
        //synchronized (lock) {
            //expand(count);
            //str.getChars(offset, offset + count, buf, this.count);
            //this.count += count;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.545 -0400", hash_original_method = "C2C534AA9A22A4D0AC70B4A5DCDA6B73", hash_generated_method = "976D255417FDBD01A50A18B545A0465B")
    public void writeTo(Writer out) throws IOException {
        addTaint(out.getTaint());
        synchronized
(lock)        {
            out.write(buf, 0, count);
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //out.write(buf, 0, count);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.545 -0400", hash_original_method = "98F1E9A8C1E20678242580E2421D983C", hash_generated_method = "A8BC0D21ADD4AA9268A04C80AE17824D")
    @Override
    public CharArrayWriter append(char c) {
        addTaint(c);
        write(c);
CharArrayWriter var72A74007B2BE62B849F475C7BDA4658B_944290908 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_944290908.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_944290908;
        // ---------- Original Method ----------
        //write(c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.546 -0400", hash_original_method = "B584B42D7A9874698AA3457A3A1D3154", hash_generated_method = "64FD201C87F90BB5D0949B18FAF5022B")
    @Override
    public CharArrayWriter append(CharSequence csq) {
        addTaint(csq.getTaint());
        if(csq == null)        
        {
            csq = "null";
        } //End block
        append(csq, 0, csq.length());
CharArrayWriter var72A74007B2BE62B849F475C7BDA4658B_1607931057 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1607931057.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1607931057;
        // ---------- Original Method ----------
        //if (csq == null) {
            //csq = "null";
        //}
        //append(csq, 0, csq.length());
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.547 -0400", hash_original_method = "A1054C6BA24908274B5EEDCC4DAC29F7", hash_generated_method = "11607D1BDAA0C35A89D3B52693209C00")
    @Override
    public CharArrayWriter append(CharSequence csq, int start, int end) {
        addTaint(end);
        addTaint(start);
        addTaint(csq.getTaint());
        if(csq == null)        
        {
            csq = "null";
        } //End block
        String output = csq.subSequence(start, end).toString();
        write(output, 0, output.length());
CharArrayWriter var72A74007B2BE62B849F475C7BDA4658B_1198374338 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1198374338.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1198374338;
        // ---------- Original Method ----------
        //if (csq == null) {
            //csq = "null";
        //}
        //String output = csq.subSequence(start, end).toString();
        //write(output, 0, output.length());
        //return this;
    }

    
}

