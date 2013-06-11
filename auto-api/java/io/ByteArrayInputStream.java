package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.util.Arrays;

public class ByteArrayInputStream extends InputStream {
    protected byte[] buf;
    protected int pos;
    protected int mark;
    protected int count;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.399 -0400", hash_original_method = "CF1B6A0EB8AC88640F4210354AA3396D", hash_generated_method = "ECACC7933C90B212D28792F8CDA94441")
    @DSModeled(DSC.SAFE)
    public ByteArrayInputStream(byte[] buf) {
        dsTaint.addTaint(buf);
        this.mark = 0;
        this.count = buf.length;
        // ---------- Original Method ----------
        //this.mark = 0;
        //this.buf = buf;
        //this.count = buf.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.399 -0400", hash_original_method = "CF3AD622E6B16C040D235FE2C3A31C84", hash_generated_method = "5189A974CE5DA5312FEE1FEABA7C3638")
    @DSModeled(DSC.SAFE)
    public ByteArrayInputStream(byte[] buf, int offset, int length) {
        dsTaint.addTaint(length);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(buf);
        count = offset + length > buf.length ? buf.length : offset + length;
        // ---------- Original Method ----------
        //this.buf = buf;
        //pos = offset;
        //mark = offset;
        //count = offset + length > buf.length ? buf.length : offset + length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.399 -0400", hash_original_method = "60B3E89517A58F980CEC13EE6BBDFCDA", hash_generated_method = "77630A255942F4F7CCFC56CC09BF4D60")
    @DSModeled(DSC.SAFE)
    @Override
    public synchronized int available() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return count - pos;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.399 -0400", hash_original_method = "403A1214A00C2300123B494982A31042", hash_generated_method = "43913192A45340DD2B1DDA454AD68C8F")
    @DSModeled(DSC.SAFE)
    @Override
    public void close() throws IOException {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.399 -0400", hash_original_method = "78F90254D622F331873962595002D35F", hash_generated_method = "F8E05FB6F649374D4845A9318C4AE5F4")
    @DSModeled(DSC.SAFE)
    @Override
    public synchronized void mark(int readlimit) {
        dsTaint.addTaint(readlimit);
        mark = pos;
        // ---------- Original Method ----------
        //mark = pos;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.399 -0400", hash_original_method = "3448BF342B33B519FE64A3FA0274077D", hash_generated_method = "1296A617D9B4AD609D1BB5E17D8BA087")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean markSupported() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.400 -0400", hash_original_method = "BB56F6666E3E1FB5BE1E06064B4DC5BD", hash_generated_method = "F0E095FB85FF137C6C4577D19D526E58")
    @DSModeled(DSC.SAFE)
    @Override
    public synchronized int read() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return pos < count ? buf[pos++] & 0xFF : -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.400 -0400", hash_original_method = "2397610A056026EF1112E9790F6EF360", hash_generated_method = "6A8C05D974594F9CDDD7B7F326C8F3B7")
    @DSModeled(DSC.SAFE)
    @Override
    public synchronized int read(byte[] buffer, int offset, int length) {
        dsTaint.addTaint(buffer);
        dsTaint.addTaint(length);
        dsTaint.addTaint(offset);
        Arrays.checkOffsetAndCount(buffer.length, offset, length);
        int copylen;
        copylen = this.count - pos;
        copylen = length;
        System.arraycopy(this.buf, pos, buffer, offset, copylen);
        pos += copylen;
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.400 -0400", hash_original_method = "C62CA45FA6D33EC45CB5D1463505B2CA", hash_generated_method = "3233F74EA06F82A2977883143BC9811E")
    @DSModeled(DSC.SAFE)
    @Override
    public synchronized void reset() {
        pos = mark;
        // ---------- Original Method ----------
        //pos = mark;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.400 -0400", hash_original_method = "18E56C09FFA023CF1EF098815CAD3886", hash_generated_method = "43F029EE33E75119F27F8C724A53614F")
    @DSModeled(DSC.SAFE)
    @Override
    public synchronized long skip(long byteCount) {
        dsTaint.addTaint(byteCount);
        int temp;
        temp = pos;
        pos = this.count - pos < byteCount ? this.count : (int) (pos + byteCount);
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //if (byteCount <= 0) {
            //return 0;
        //}
        //int temp = pos;
        //pos = this.count - pos < byteCount ? this.count : (int) (pos + byteCount);
        //return pos - temp;
    }

    
}


