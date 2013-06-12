package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.util.Arrays;

public class CharArrayWriter extends Writer {
    protected char[] buf;
    protected int count;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.405 -0400", hash_original_method = "C9452FB9491532C2A6C52BB5B3D25E39", hash_generated_method = "414F23D47C1551B813ACCE811C7716BA")
    @DSModeled(DSC.SAFE)
    public CharArrayWriter() {
        buf = new char[32];
        lock = buf;
        // ---------- Original Method ----------
        //buf = new char[32];
        //lock = buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.405 -0400", hash_original_method = "71C0EC52128D22FED2D8659A81B00E37", hash_generated_method = "63DCC8C795EBBEAF2AFFBECDF60C45B8")
    @DSModeled(DSC.SAFE)
    public CharArrayWriter(int initialSize) {
        dsTaint.addTaint(initialSize);
        {
            throw new IllegalArgumentException("size < 0");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.405 -0400", hash_original_method = "B96EF178F3ED1A0DFACDA94649407E5C", hash_generated_method = "1CDA3FDF568962C4A889B5852A7121B0")
    @DSModeled(DSC.SAFE)
    @Override
    public void close() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.405 -0400", hash_original_method = "74E26FDF253668E5689F73596E4C1217", hash_generated_method = "1F06DFC170916029248C0C4F02E5E0F0")
    @DSModeled(DSC.SAFE)
    private void expand(int i) {
        dsTaint.addTaint(i);
        int newLen;
        newLen = Math.max(2 * buf.length, count + i);
        char[] newbuf;
        newbuf = new char[newLen];
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.405 -0400", hash_original_method = "336EB9AA03C5B902D3CE726BD69F433F", hash_generated_method = "E4D40EC6493188B29F77D031E968A12F")
    @DSModeled(DSC.SAFE)
    @Override
    public void flush() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.405 -0400", hash_original_method = "41854ED78018FCB86E06DA2ADE584B53", hash_generated_method = "6A4C0D9DEA0330028B2162EBD7253DF5")
    @DSModeled(DSC.SAFE)
    public void reset() {
        {
            count = 0;
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //count = 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.405 -0400", hash_original_method = "796F2451CF9DC3EF411446EADA3F03C7", hash_generated_method = "C6E7A7DF3A1CC25860B35453E5008857")
    @DSModeled(DSC.SAFE)
    public int size() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //synchronized (lock) {
            //return count;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.405 -0400", hash_original_method = "A3DCAA229974F9979554B7E0F1F4EF9F", hash_generated_method = "B849AB610DECCC77E5366E1F68496548")
    @DSModeled(DSC.SAFE)
    public char[] toCharArray() {
        {
            char[] result;
            result = new char[count];
            System.arraycopy(buf, 0, result, 0, count);
        } //End block
        char[] retVal = new char[1];
        retVal[0] = dsTaint.getTaintString().charAt(0);
        return retVal;
        // ---------- Original Method ----------
        //synchronized (lock) {
            //char[] result = new char[count];
            //System.arraycopy(buf, 0, result, 0, count);
            //return result;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.405 -0400", hash_original_method = "F9B2EF7C65F2F351A8955F413D7A1883", hash_generated_method = "D940030C1523CBED1F7DF0A4D64C9F33")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //synchronized (lock) {
            //return new String(buf, 0, count);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.405 -0400", hash_original_method = "17F94D6158075BE971F02096E85AEF33", hash_generated_method = "15858286E8E07A36805FC8659F02B34D")
    @DSModeled(DSC.SAFE)
    @Override
    public void write(char[] buffer, int offset, int len) {
        dsTaint.addTaint(buffer);
        dsTaint.addTaint(len);
        dsTaint.addTaint(offset);
        Arrays.checkOffsetAndCount(buffer.length, offset, len);
        {
            expand(len);
            System.arraycopy(buffer, offset, this.buf, this.count, len);
        } //End block
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(buffer.length, offset, len);
        //synchronized (lock) {
            //expand(len);
            //System.arraycopy(buffer, offset, this.buf, this.count, len);
            //this.count += len;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.405 -0400", hash_original_method = "F6D5648087F216C6BFDCFB078373F01B", hash_generated_method = "6FC08F3BE894D193C86D49B635B6D3D4")
    @DSModeled(DSC.SAFE)
    @Override
    public void write(int oneChar) {
        dsTaint.addTaint(oneChar);
        {
            expand(1);
            buf[count++] = (char) oneChar;
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //expand(1);
            //buf[count++] = (char) oneChar;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.406 -0400", hash_original_method = "9F8082FBB1391041DAA8F1A348E27C2A", hash_generated_method = "784448FF8FB79D23E397C206CE237984")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void write(String str, int offset, int count) {
        dsTaint.addTaint(str);
        dsTaint.addTaint(count);
        dsTaint.addTaint(offset);
        {
            throw new NullPointerException("str == null");
        } //End block
        {
            boolean var692490DEFA1D61E18F718478B787B00C_504887394 = ((offset | count) < 0 || offset > str.length() - count);
            {
                throw new StringIndexOutOfBoundsException(str, offset, count);
            } //End block
        } //End collapsed parenthetic
        {
            expand(count);
            str.getChars(offset, offset + count, buf, this.count);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.406 -0400", hash_original_method = "C2C534AA9A22A4D0AC70B4A5DCDA6B73", hash_generated_method = "45838B54099BB04602C41286658F19CE")
    @DSModeled(DSC.SAFE)
    public void writeTo(Writer out) throws IOException {
        dsTaint.addTaint(out.dsTaint);
        {
            out.write(buf, 0, count);
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //out.write(buf, 0, count);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.406 -0400", hash_original_method = "98F1E9A8C1E20678242580E2421D983C", hash_generated_method = "221E49D9BBB2CB8C9A86B869C951B459")
    @DSModeled(DSC.SAFE)
    @Override
    public CharArrayWriter append(char c) {
        dsTaint.addTaint(c);
        write(c);
        return (CharArrayWriter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //write(c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.406 -0400", hash_original_method = "B584B42D7A9874698AA3457A3A1D3154", hash_generated_method = "682593D349A454432814D1CE8D4B8C1D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public CharArrayWriter append(CharSequence csq) {
        dsTaint.addTaint(csq);
        {
            csq = "null";
        } //End block
        append(csq, 0, csq.length());
        return (CharArrayWriter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (csq == null) {
            //csq = "null";
        //}
        //append(csq, 0, csq.length());
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.406 -0400", hash_original_method = "A1054C6BA24908274B5EEDCC4DAC29F7", hash_generated_method = "05361F6E91506FBD2494C7C8D71AC74E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public CharArrayWriter append(CharSequence csq, int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(csq);
        dsTaint.addTaint(end);
        {
            csq = "null";
        } //End block
        String output;
        output = csq.subSequence(start, end).toString();
        write(output, 0, output.length());
        return (CharArrayWriter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (csq == null) {
            //csq = "null";
        //}
        //String output = csq.subSequence(start, end).toString();
        //write(output, 0, output.length());
        //return this;
    }

    
}


