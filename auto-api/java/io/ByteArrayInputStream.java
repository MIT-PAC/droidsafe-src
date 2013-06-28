package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Arrays;

public class ByteArrayInputStream extends InputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.524 -0400", hash_original_field = "CB7E52B21171FB9A53B498202607F0BD", hash_generated_field = "083037218D1B4F9535944A48D3FD1BCA")

    protected byte[] buf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.524 -0400", hash_original_field = "5E0BDCBDDCCCA4D66D74BA8C1CEE1A68", hash_generated_field = "3039C52FCC40405280C80DE756778CBF")

    protected int pos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.524 -0400", hash_original_field = "EA82410C7A9991816B5EEEEBE195E20A", hash_generated_field = "5CD36671CA275C4800A9D662FF24FD61")

    protected int mark;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.524 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "CADFF8C1F208C99E14B28CFC1A04442F")

    protected int count;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.525 -0400", hash_original_method = "CF1B6A0EB8AC88640F4210354AA3396D", hash_generated_method = "A0B0F5C55FABD496502CD1493CE61372")
    public  ByteArrayInputStream(byte[] buf) {
        this.mark = 0;
        this.buf = buf;
        this.count = buf.length;
        // ---------- Original Method ----------
        //this.mark = 0;
        //this.buf = buf;
        //this.count = buf.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.525 -0400", hash_original_method = "CF3AD622E6B16C040D235FE2C3A31C84", hash_generated_method = "D1E790062826309E9586368E1A175542")
    public  ByteArrayInputStream(byte[] buf, int offset, int length) {
        this.buf = buf;
        pos = offset;
        mark = offset;
        count = offset + length > buf.length ? buf.length : offset + length;
        // ---------- Original Method ----------
        //this.buf = buf;
        //pos = offset;
        //mark = offset;
        //count = offset + length > buf.length ? buf.length : offset + length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.526 -0400", hash_original_method = "60B3E89517A58F980CEC13EE6BBDFCDA", hash_generated_method = "0D58A6827AEC0F9EC52D1486459D3DED")
    @Override
    public synchronized int available() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_963190446 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_963190446;
        // ---------- Original Method ----------
        //return count - pos;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.526 -0400", hash_original_method = "403A1214A00C2300123B494982A31042", hash_generated_method = "6B4749673D8A7A62B822BE7109DA1BE7")
    @Override
    public void close() throws IOException {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.526 -0400", hash_original_method = "78F90254D622F331873962595002D35F", hash_generated_method = "E9AFBC14CFC872FA782DC7FDB8371ACF")
    @Override
    public synchronized void mark(int readlimit) {
        mark = pos;
        addTaint(readlimit);
        // ---------- Original Method ----------
        //mark = pos;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.527 -0400", hash_original_method = "3448BF342B33B519FE64A3FA0274077D", hash_generated_method = "5D621815B35C8ED0AA06153CC53A38FD")
    @Override
    public boolean markSupported() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1717152556 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1717152556;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.527 -0400", hash_original_method = "BB56F6666E3E1FB5BE1E06064B4DC5BD", hash_generated_method = "B01DB2C38620551B3A06D07F1BFA5661")
    @Override
    public synchronized int read() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1580717517 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1580717517;
        // ---------- Original Method ----------
        //return pos < count ? buf[pos++] & 0xFF : -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.528 -0400", hash_original_method = "2397610A056026EF1112E9790F6EF360", hash_generated_method = "221C39A67328119F95E445959676033A")
    @Override
    public synchronized int read(byte[] buffer, int offset, int length) {
        Arrays.checkOffsetAndCount(buffer.length, offset, length);
        int copylen;
        copylen = this.count - pos;
        copylen = length;
        System.arraycopy(this.buf, pos, buffer, offset, copylen);
        pos += copylen;
        addTaint(buffer[0]);
        addTaint(offset);
        addTaint(length);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1943042701 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1943042701;
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(buffer.length, offset, length);
        //if (this.pos >= this.count) {
            //return -1;
        //}
        //if (length == 0) {
            //return 0;
        //}
        //int copylen = this.count - pos < length ? this.count - pos : length;
        //System.arraycopy(this.buf, pos, buffer, offset, copylen);
        //pos += copylen;
        //return copylen;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.528 -0400", hash_original_method = "C62CA45FA6D33EC45CB5D1463505B2CA", hash_generated_method = "5F81C3DDB804B4E1ED077DCCACC7F88D")
    @Override
    public synchronized void reset() {
        pos = mark;
        // ---------- Original Method ----------
        //pos = mark;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.529 -0400", hash_original_method = "18E56C09FFA023CF1EF098815CAD3886", hash_generated_method = "114D56263E57FC9A6B4539500D31C34A")
    @Override
    public synchronized long skip(long byteCount) {
        int temp = pos;
        pos = this.count - pos < byteCount ? this.count : (int) (pos + byteCount);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_2119195861 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2119195861;
        // ---------- Original Method ----------
        //if (byteCount <= 0) {
            //return 0;
        //}
        //int temp = pos;
        //pos = this.count - pos < byteCount ? this.count : (int) (pos + byteCount);
        //return pos - temp;
    }

    
}

