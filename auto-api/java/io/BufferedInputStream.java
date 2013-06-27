package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Arrays;

public class BufferedInputStream extends FilterInputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.179 -0400", hash_original_field = "CB7E52B21171FB9A53B498202607F0BD", hash_generated_field = "C53666C61D704ACE793D3D98401D06E0")

    protected volatile byte[] buf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.179 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "CADFF8C1F208C99E14B28CFC1A04442F")

    protected int count;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.179 -0400", hash_original_field = "7E1D45D2D0791CB14CAE674BF346C80C", hash_generated_field = "187237640B843AF018F2A924787F8CE1")

    protected int marklimit;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.180 -0400", hash_original_field = "492E5D488B8C3F3A5B37BE9C27216BA1", hash_generated_field = "584BEF84693439016482B6900153EC57")

    protected int markpos = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.180 -0400", hash_original_field = "5E0BDCBDDCCCA4D66D74BA8C1CEE1A68", hash_generated_field = "3039C52FCC40405280C80DE756778CBF")

    protected int pos;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.192 -0400", hash_original_method = "21B504722C790213175AE0F5E25EEBB8", hash_generated_method = "082827D8E12E6C89AE7674A5DA40B439")
    public  BufferedInputStream(InputStream in) {
        this(in, 8192);
        addTaint(in.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.193 -0400", hash_original_method = "4F467422085302825BDB985C2FDC72F9", hash_generated_method = "C6898A6B1690835FE1ED3553873875D6")
    public  BufferedInputStream(InputStream in, int size) {
        super(in);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("size <= 0");
        } //End block
        buf = new byte[size];
        addTaint(in.getTaint());
        // ---------- Original Method ----------
        //if (size <= 0) {
            //throw new IllegalArgumentException("size <= 0");
        //}
        //buf = new byte[size];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.194 -0400", hash_original_method = "07FFB00D7B3DCD194F29893BBF5B52EB", hash_generated_method = "171E1264ED5A80559316597417069994")
    @Override
    public synchronized int available() throws IOException {
        InputStream localIn;
        localIn = in;
        {
            if (DroidSafeAndroidRuntime.control) throw streamClosed();
        } //End block
        int var2B924E8BBC5F3CE3B1F1E3EF2F7F10B5_90349576 = (count - pos + localIn.available());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1305388738 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1305388738;
        // ---------- Original Method ----------
        //InputStream localIn = in;
        //if (buf == null || localIn == null) {
            //throw streamClosed();
        //}
        //return count - pos + localIn.available();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.194 -0400", hash_original_method = "4D8013C45FC6B1A765F1F6C3AB84963B", hash_generated_method = "41453DD9F47E59238E8E8C396C3D3ECC")
    private IOException streamClosed() throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new IOException("BufferedInputStream is closed");
        // ---------- Original Method ----------
        //throw new IOException("BufferedInputStream is closed");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.195 -0400", hash_original_method = "9458B5514F81355F9A651152E456CAE7", hash_generated_method = "73DDD97D2DBC2C5446BEF3E26DAF144E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.200 -0400", hash_original_method = "763578223906D5382275DB1FE1B265CB", hash_generated_method = "4DAD51F3E552B318468BDBC4400C5A2E")
    private int fillbuf(InputStream localIn, byte[] localBuf) throws IOException {
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
        addTaint(localIn.getTaint());
        addTaint(localBuf[0]);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1214089782 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1214089782;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.200 -0400", hash_original_method = "DF417F804FB76ED4D7DE805338DD287E", hash_generated_method = "E33C32E52CFE857EB9ED3111281AA940")
    @Override
    public synchronized void mark(int readlimit) {
        marklimit = readlimit;
        markpos = pos;
        // ---------- Original Method ----------
        //marklimit = readlimit;
        //markpos = pos;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.205 -0400", hash_original_method = "3448BF342B33B519FE64A3FA0274077D", hash_generated_method = "35BC5C288BE27127D27078A2F239A8FE")
    @Override
    public boolean markSupported() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_729014567 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_729014567;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.220 -0400", hash_original_method = "44D2E1EC0EF3B53AC5594D464D2C83B9", hash_generated_method = "7F32AD209D40BA7BDB540946043A0AF0")
    @Override
    public synchronized int read() throws IOException {
        byte[] localBuf;
        localBuf = buf;
        InputStream localIn;
        localIn = in;
        {
            if (DroidSafeAndroidRuntime.control) throw streamClosed();
        } //End block
        {
            boolean varF86809B8FFE08F3AD3A1687782FBCF09_1204806558 = (pos >= count && fillbuf(localIn, localBuf) == -1);
        } //End collapsed parenthetic
        {
            localBuf = buf;
            {
                if (DroidSafeAndroidRuntime.control) throw streamClosed();
            } //End block
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_341133351 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_341133351;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.221 -0400", hash_original_method = "61DEF23C4EC5BF0BA1725AB1A56B4C17", hash_generated_method = "41CC231494E66554F4E5CF3F26992E86")
    @Override
    public synchronized int read(byte[] buffer, int offset, int byteCount) throws IOException {
        byte[] localBuf;
        localBuf = buf;
        {
            if (DroidSafeAndroidRuntime.control) throw streamClosed();
        } //End block
        Arrays.checkOffsetAndCount(buffer.length, offset, byteCount);
        InputStream localIn;
        localIn = in;
        {
            if (DroidSafeAndroidRuntime.control) throw streamClosed();
        } //End block
        int required;
        {
            int copylength;
            copylength = byteCount;
            copylength = count - pos;
            System.arraycopy(localBuf, pos, buffer, offset, copylength);
            pos += copylength;
            {
                boolean varEFE87A34F8169BCA8D8DC98CCC9095FD_779824605 = (copylength == byteCount || localIn.available() == 0);
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
                    boolean varF25EF1B23AB1732E312B5DFAAD3BFA2F_315784314 = (fillbuf(localIn, localBuf) == -1);
                } //End collapsed parenthetic
                {
                    localBuf = buf;
                    {
                        if (DroidSafeAndroidRuntime.control) throw streamClosed();
                    } //End block
                } //End block
                read = count - pos >= required ? required : count - pos;
                System.arraycopy(localBuf, pos, buffer, offset, read);
                pos += read;
            } //End block
            required -= read;
            {
                boolean var31130D1C27C6C1FAA5AC8921793A9099_702053295 = (localIn.available() == 0);
            } //End collapsed parenthetic
            offset += read;
        } //End block
        addTaint(buffer[0]);
        addTaint(offset);
        addTaint(byteCount);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2030348823 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2030348823;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.222 -0400", hash_original_method = "0EB3739ECCD523AAEBB3A3F64D0A35BC", hash_generated_method = "33CCC16E38D43BA69C021996A176D548")
    @Override
    public synchronized void reset() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Stream is closed");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Mark has been invalidated.");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.234 -0400", hash_original_method = "61D210443DD8F238003AAFD35E7B7777", hash_generated_method = "991BEB1E7ACC95D4310BE7FF04027329")
    @Override
    public synchronized long skip(long byteCount) throws IOException {
        byte[] localBuf;
        localBuf = buf;
        InputStream localIn;
        localIn = in;
        {
            if (DroidSafeAndroidRuntime.control) throw streamClosed();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw streamClosed();
        } //End block
        {
            pos += byteCount;
        } //End block
        long read;
        read = count - pos;
        pos = count;
        {
            {
                {
                    boolean varF25EF1B23AB1732E312B5DFAAD3BFA2F_106299878 = (fillbuf(localIn, localBuf) == -1);
                } //End collapsed parenthetic
                {
                    pos += byteCount - read;
                } //End block
                read += (count - pos);
                pos = count;
            } //End block
        } //End block
        long var8633DA1A1892299DE222DC19D4AC5EB0_1379132331 = (read + localIn.skip(byteCount - read));
        long var0F5264038205EDFB1AC05FBB0E8C5E94_322540314 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_322540314;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

