package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Arrays;

public class ByteArrayInputStream extends InputStream {
    protected byte[] buf;
    protected int pos;
    protected int mark;
    protected int count;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.435 -0400", hash_original_method = "CF1B6A0EB8AC88640F4210354AA3396D", hash_generated_method = "9343ECD5AE79DD88562E53C38961151F")
    @DSModeled(DSC.SAFE)
    public ByteArrayInputStream(byte[] buf) {
        dsTaint.addTaint(buf[0]);
        this.mark = 0;
        this.count = buf.length;
        // ---------- Original Method ----------
        //this.mark = 0;
        //this.buf = buf;
        //this.count = buf.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.436 -0400", hash_original_method = "CF3AD622E6B16C040D235FE2C3A31C84", hash_generated_method = "26DF4E67B52B86C2361C80D82EA22A3F")
    @DSModeled(DSC.SAFE)
    public ByteArrayInputStream(byte[] buf, int offset, int length) {
        dsTaint.addTaint(length);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(buf[0]);
        count = offset + length > buf.length ? buf.length : offset + length;
        // ---------- Original Method ----------
        //this.buf = buf;
        //pos = offset;
        //mark = offset;
        //count = offset + length > buf.length ? buf.length : offset + length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.436 -0400", hash_original_method = "60B3E89517A58F980CEC13EE6BBDFCDA", hash_generated_method = "273A0A194543EB406E458FDF5ABCA4AD")
    @DSModeled(DSC.SAFE)
    @Override
    public synchronized int available() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return count - pos;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.436 -0400", hash_original_method = "403A1214A00C2300123B494982A31042", hash_generated_method = "6B4749673D8A7A62B822BE7109DA1BE7")
    @DSModeled(DSC.SAFE)
    @Override
    public void close() throws IOException {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.436 -0400", hash_original_method = "78F90254D622F331873962595002D35F", hash_generated_method = "F369DEEB3B8C12C7F234BFC77F23E32A")
    @DSModeled(DSC.SAFE)
    @Override
    public synchronized void mark(int readlimit) {
        dsTaint.addTaint(readlimit);
        mark = pos;
        // ---------- Original Method ----------
        //mark = pos;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.436 -0400", hash_original_method = "3448BF342B33B519FE64A3FA0274077D", hash_generated_method = "4C8BC0E845541479E10014C1D7864553")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean markSupported() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.437 -0400", hash_original_method = "BB56F6666E3E1FB5BE1E06064B4DC5BD", hash_generated_method = "C7F3818823E4C09DB9CAB11F07ABB0F1")
    @DSModeled(DSC.SAFE)
    @Override
    public synchronized int read() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return pos < count ? buf[pos++] & 0xFF : -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.437 -0400", hash_original_method = "2397610A056026EF1112E9790F6EF360", hash_generated_method = "438C9F24949F233232842FDF03790D50")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized int read(byte[] buffer, int offset, int length) {
        dsTaint.addTaint(buffer[0]);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.437 -0400", hash_original_method = "C62CA45FA6D33EC45CB5D1463505B2CA", hash_generated_method = "5F81C3DDB804B4E1ED077DCCACC7F88D")
    @DSModeled(DSC.SAFE)
    @Override
    public synchronized void reset() {
        pos = mark;
        // ---------- Original Method ----------
        //pos = mark;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.438 -0400", hash_original_method = "18E56C09FFA023CF1EF098815CAD3886", hash_generated_method = "CD05403E189A316B2DE686EA6AB43AF0")
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

