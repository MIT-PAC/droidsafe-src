package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Arrays;

public class CharArrayWriter extends Writer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.998 -0400", hash_original_field = "CB7E52B21171FB9A53B498202607F0BD", hash_generated_field = "F3184E7FC423A3DB65CA949884DB59BD")

    protected char[] buf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.998 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "CADFF8C1F208C99E14B28CFC1A04442F")

    protected int count;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.999 -0400", hash_original_method = "C9452FB9491532C2A6C52BB5B3D25E39", hash_generated_method = "D4173DDAE8E1B17586789B3DC5C61CB6")
    public  CharArrayWriter() {
        buf = new char[32];
        lock = buf;
        // ---------- Original Method ----------
        //buf = new char[32];
        //lock = buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:46.999 -0400", hash_original_method = "71C0EC52128D22FED2D8659A81B00E37", hash_generated_method = "3D306CD146BF8192451738C7AA1030F7")
    public  CharArrayWriter(int initialSize) {
    if(initialSize < 0)        
        {
            IllegalArgumentException var2382BBC2482763F398967EC587DEA9AE_787272896 = new IllegalArgumentException("size < 0");
            var2382BBC2482763F398967EC587DEA9AE_787272896.addTaint(taint);
            throw var2382BBC2482763F398967EC587DEA9AE_787272896;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:47.000 -0400", hash_original_method = "B96EF178F3ED1A0DFACDA94649407E5C", hash_generated_method = "1A3F8C083102602A57FB2D0CBE40EA76")
    @Override
    public void close() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:47.000 -0400", hash_original_method = "74E26FDF253668E5689F73596E4C1217", hash_generated_method = "C52FC5F77B02935642B6F8DEFE2250FA")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:47.001 -0400", hash_original_method = "336EB9AA03C5B902D3CE726BD69F433F", hash_generated_method = "4A4713C8ADAF7778CF4E4BBDA39355C2")
    @Override
    public void flush() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:47.001 -0400", hash_original_method = "41854ED78018FCB86E06DA2ADE584B53", hash_generated_method = "EF66D3120D8A5048C78C67480E598644")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:47.001 -0400", hash_original_method = "796F2451CF9DC3EF411446EADA3F03C7", hash_generated_method = "E11B9201B31DD88C4FE18B1B5A8CB402")
    public int size() {
        synchronized
(lock)        {
            int varE2942A04780E223B215EB8B663CF5353_1197815318 = (count);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1959360624 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1959360624;
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //return count;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:47.002 -0400", hash_original_method = "A3DCAA229974F9979554B7E0F1F4EF9F", hash_generated_method = "97244ACC2E6F82BEC21ADC87E784DAA2")
    public char[] toCharArray() {
        synchronized
(lock)        {
            char[] result = new char[count];
            System.arraycopy(buf, 0, result, 0, count);
            char[] varB4A88417B3D0170D754C647C30B7216A_1522200617 = (result);
                        char[] var50607924ABD4C17119BAF3A1CE41C0EC_926094329 = {getTaintChar()};
            return var50607924ABD4C17119BAF3A1CE41C0EC_926094329;
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //char[] result = new char[count];
            //System.arraycopy(buf, 0, result, 0, count);
            //return result;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:47.002 -0400", hash_original_method = "F9B2EF7C65F2F351A8955F413D7A1883", hash_generated_method = "E41D3B8EDA442563C1DF3DDFC23E6CCA")
    @Override
    public String toString() {
        synchronized
(lock)        {
String var284A4624AC5D82C1992013009E0FB870_561904108 =             new String(buf, 0, count);
            var284A4624AC5D82C1992013009E0FB870_561904108.addTaint(taint);
            return var284A4624AC5D82C1992013009E0FB870_561904108;
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //return new String(buf, 0, count);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:47.003 -0400", hash_original_method = "17F94D6158075BE971F02096E85AEF33", hash_generated_method = "93847812E3AD8CFF2A91074835AFA875")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:47.003 -0400", hash_original_method = "F6D5648087F216C6BFDCFB078373F01B", hash_generated_method = "98F21E0D181DB75A943801F4748A9B8D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:47.004 -0400", hash_original_method = "9F8082FBB1391041DAA8F1A348E27C2A", hash_generated_method = "C19F7778337D091F4FD622F851DF67FE")
    @Override
    public void write(String str, int offset, int count) {
        addTaint(offset);
        addTaint(str.getTaint());
    if(str == null)        
        {
            NullPointerException varBAAB5D2ADD4C016ACB92A2133697155C_1969382345 = new NullPointerException("str == null");
            varBAAB5D2ADD4C016ACB92A2133697155C_1969382345.addTaint(taint);
            throw varBAAB5D2ADD4C016ACB92A2133697155C_1969382345;
        } //End block
    if((offset | count) < 0 || offset > str.length() - count)        
        {
            StringIndexOutOfBoundsException varDD6466A465572C8C2EC4C6C733FC9AF8_1232426152 = new StringIndexOutOfBoundsException(str, offset, count);
            varDD6466A465572C8C2EC4C6C733FC9AF8_1232426152.addTaint(taint);
            throw varDD6466A465572C8C2EC4C6C733FC9AF8_1232426152;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:47.005 -0400", hash_original_method = "C2C534AA9A22A4D0AC70B4A5DCDA6B73", hash_generated_method = "976D255417FDBD01A50A18B545A0465B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:47.006 -0400", hash_original_method = "98F1E9A8C1E20678242580E2421D983C", hash_generated_method = "C780F031C786FC61975E32E342CFC274")
    @Override
    public CharArrayWriter append(char c) {
        addTaint(c);
        write(c);
CharArrayWriter var72A74007B2BE62B849F475C7BDA4658B_497974827 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_497974827.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_497974827;
        // ---------- Original Method ----------
        //write(c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:47.006 -0400", hash_original_method = "B584B42D7A9874698AA3457A3A1D3154", hash_generated_method = "42A746E10D87DB4C07F80286FBE01E44")
    @Override
    public CharArrayWriter append(CharSequence csq) {
        addTaint(csq.getTaint());
    if(csq == null)        
        {
            csq = "null";
        } //End block
        append(csq, 0, csq.length());
CharArrayWriter var72A74007B2BE62B849F475C7BDA4658B_342348197 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_342348197.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_342348197;
        // ---------- Original Method ----------
        //if (csq == null) {
            //csq = "null";
        //}
        //append(csq, 0, csq.length());
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:47.007 -0400", hash_original_method = "A1054C6BA24908274B5EEDCC4DAC29F7", hash_generated_method = "2D1B364762A8BDEA6928DD59AE521CB8")
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
CharArrayWriter var72A74007B2BE62B849F475C7BDA4658B_1761652228 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1761652228.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1761652228;
        // ---------- Original Method ----------
        //if (csq == null) {
            //csq = "null";
        //}
        //String output = csq.subSequence(start, end).toString();
        //write(output, 0, output.length());
        //return this;
    }

    
}

