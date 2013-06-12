package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.util.Arrays;

public class BufferedInputStream extends FilterInputStream {
    protected volatile byte[] buf;
    protected int count;
    protected int marklimit;
    protected int markpos = -1;
    protected int pos;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.372 -0400", hash_original_method = "21B504722C790213175AE0F5E25EEBB8", hash_generated_method = "AA737C1786C3B364E0AE26A09C39858A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BufferedInputStream(InputStream in) {
        this(in, 8192);
        dsTaint.addTaint(in.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.372 -0400", hash_original_method = "4F467422085302825BDB985C2FDC72F9", hash_generated_method = "090B07BB2110AE9809569D00A62CA79F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BufferedInputStream(InputStream in, int size) {
        super(in);
        dsTaint.addTaint(in.dsTaint);
        dsTaint.addTaint(size);
        {
            throw new IllegalArgumentException("size <= 0");
        } //End block
        buf = new byte[size];
        // ---------- Original Method ----------
        //if (size <= 0) {
            //throw new IllegalArgumentException("size <= 0");
        //}
        //buf = new byte[size];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.372 -0400", hash_original_method = "07FFB00D7B3DCD194F29893BBF5B52EB", hash_generated_method = "BA8F3433848F84A37DDD48E9D8F55CA8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized int available() throws IOException {
        InputStream localIn;
        localIn = in;
        {
            throw streamClosed();
        } //End block
        int var2B924E8BBC5F3CE3B1F1E3EF2F7F10B5_1486095762 = (count - pos + localIn.available());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //InputStream localIn = in;
        //if (buf == null || localIn == null) {
            //throw streamClosed();
        //}
        //return count - pos + localIn.available();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.372 -0400", hash_original_method = "4D8013C45FC6B1A765F1F6C3AB84963B", hash_generated_method = "C9DFDA73C8ECBAF72861548BED8E790B")
    @DSModeled(DSC.SAFE)
    private IOException streamClosed() throws IOException {
        throw new IOException("BufferedInputStream is closed");
        return (IOException)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new IOException("BufferedInputStream is closed");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.372 -0400", hash_original_method = "9458B5514F81355F9A651152E456CAE7", hash_generated_method = "2AB89AC82E0457D5984E3403A60DEEDB")
    @DSModeled(DSC.SAFE)
    @Override
    public void close() throws IOException {
        buf = null;
        InputStream localIn;
        localIn = in;
        in = null;
        {
            localIn.close();
        } //End block
        // ---------- Original Method ----------
        //buf = null;
        //InputStream localIn = in;
        //in = null;
        //if (localIn != null) {
            //localIn.close();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.372 -0400", hash_original_method = "763578223906D5382275DB1FE1B265CB", hash_generated_method = "33BC0422F43B6BFBD883D938B738BF77")
    @DSModeled(DSC.SAFE)
    private int fillbuf(InputStream localIn, byte[] localBuf) throws IOException {
        dsTaint.addTaint(localBuf);
        dsTaint.addTaint(localIn.dsTaint);
        {
            int result;
            result = localIn.read(localBuf);
            {
                markpos = -1;
                pos = 0;
                count = result == -1 ? 0 : result;
            } //End block
        } //End block
        {
            int newLength;
            newLength = localBuf.length * 2;
            {
                newLength = marklimit;
            } //End block
            byte[] newbuf;
            newbuf = new byte[newLength];
            System.arraycopy(localBuf, 0, newbuf, 0, localBuf.length);
            localBuf = buf = newbuf;
        } //End block
        {
            System.arraycopy(localBuf, markpos, localBuf, 0, localBuf.length
                    - markpos);
        } //End block
        pos -= markpos;
        count = markpos = 0;
        int bytesread;
        bytesread = localIn.read(localBuf, pos, localBuf.length - pos);
        count = bytesread <= 0 ? pos : pos + bytesread;
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.372 -0400", hash_original_method = "DF417F804FB76ED4D7DE805338DD287E", hash_generated_method = "B55883B16FD81192155D05FC5CD3D784")
    @DSModeled(DSC.SAFE)
    @Override
    public synchronized void mark(int readlimit) {
        dsTaint.addTaint(readlimit);
        markpos = pos;
        // ---------- Original Method ----------
        //marklimit = readlimit;
        //markpos = pos;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.372 -0400", hash_original_method = "3448BF342B33B519FE64A3FA0274077D", hash_generated_method = "1296A617D9B4AD609D1BB5E17D8BA087")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean markSupported() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.373 -0400", hash_original_method = "44D2E1EC0EF3B53AC5594D464D2C83B9", hash_generated_method = "49B22BA69345516FFE8EA124C878CF91")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized int read() throws IOException {
        byte[] localBuf;
        localBuf = buf;
        InputStream localIn;
        localIn = in;
        {
            throw streamClosed();
        } //End block
        {
            boolean varF86809B8FFE08F3AD3A1687782FBCF09_333047779 = (pos >= count && fillbuf(localIn, localBuf) == -1);
        } //End collapsed parenthetic
        {
            localBuf = buf;
            {
                throw streamClosed();
            } //End block
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //byte[] localBuf = buf;
        //InputStream localIn = in;
        //if (localBuf == null || localIn == null) {
            //throw streamClosed();
        //}
        //if (pos >= count && fillbuf(localIn, localBuf) == -1) {
            //return -1; 
        //}
        //if (localBuf != buf) {
            //localBuf = buf;
            //if (localBuf == null) {
                //throw streamClosed();
            //}
        //}
        //if (count - pos > 0) {
            //return localBuf[pos++] & 0xFF;
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.373 -0400", hash_original_method = "61DEF23C4EC5BF0BA1725AB1A56B4C17", hash_generated_method = "1E7C9E718CAEBC5E6CF74F46C836501F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized int read(byte[] buffer, int offset, int byteCount) throws IOException {
        dsTaint.addTaint(buffer);
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(offset);
        byte[] localBuf;
        localBuf = buf;
        {
            throw streamClosed();
        } //End block
        Arrays.checkOffsetAndCount(buffer.length, offset, byteCount);
        InputStream localIn;
        localIn = in;
        {
            throw streamClosed();
        } //End block
        int required;
        {
            int copylength;
            copylength = byteCount;
            copylength = count - pos;
            System.arraycopy(localBuf, pos, buffer, offset, copylength);
            pos += copylength;
            {
                boolean varEFE87A34F8169BCA8D8DC98CCC9095FD_1239699758 = (copylength == byteCount || localIn.available() == 0);
            } //End collapsed parenthetic
            offset += copylength;
            required = byteCount - copylength;
        } //End block
        {
            required = byteCount;
        } //End block
        {
            int read;
            {
                read = localIn.read(buffer, offset, required);
            } //End block
            {
                {
                    boolean varF25EF1B23AB1732E312B5DFAAD3BFA2F_1604316412 = (fillbuf(localIn, localBuf) == -1);
                } //End collapsed parenthetic
                {
                    localBuf = buf;
                    {
                        throw streamClosed();
                    } //End block
                } //End block
                read = count - pos >= required ? required : count - pos;
                System.arraycopy(localBuf, pos, buffer, offset, read);
                pos += read;
            } //End block
            required -= read;
            {
                boolean var31130D1C27C6C1FAA5AC8921793A9099_1915954890 = (localIn.available() == 0);
            } //End collapsed parenthetic
            offset += read;
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.373 -0400", hash_original_method = "0EB3739ECCD523AAEBB3A3F64D0A35BC", hash_generated_method = "46A53D2EF5B6A1B5CDA5E8F5668BF34A")
    @DSModeled(DSC.SAFE)
    @Override
    public synchronized void reset() throws IOException {
        {
            throw new IOException("Stream is closed");
        } //End block
        {
            throw new IOException("Mark has been invalidated.");
        } //End block
        pos = markpos;
        // ---------- Original Method ----------
        //if (buf == null) {
            //throw new IOException("Stream is closed");
        //}
        //if (-1 == markpos) {
            //throw new IOException("Mark has been invalidated.");
        //}
        //pos = markpos;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.373 -0400", hash_original_method = "61D210443DD8F238003AAFD35E7B7777", hash_generated_method = "B8ECC37BC0471BE5AF12A4CFA93090C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized long skip(long byteCount) throws IOException {
        dsTaint.addTaint(byteCount);
        byte[] localBuf;
        localBuf = buf;
        InputStream localIn;
        localIn = in;
        {
            throw streamClosed();
        } //End block
        {
            throw streamClosed();
        } //End block
        long read;
        read = count - pos;
        pos = count;
        {
            {
                {
                    boolean varF25EF1B23AB1732E312B5DFAAD3BFA2F_169807420 = (fillbuf(localIn, localBuf) == -1);
                } //End collapsed parenthetic
                {
                    pos += byteCount - read;
                } //End block
                read += (count - pos);
                pos = count;
            } //End block
        } //End block
        long var8633DA1A1892299DE222DC19D4AC5EB0_213017901 = (read + localIn.skip(byteCount - read));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}


