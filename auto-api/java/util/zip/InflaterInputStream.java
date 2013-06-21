package java.util.zip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import libcore.io.Streams;

public class InflaterInputStream extends FilterInputStream {
    protected Inflater inf;
    protected byte[] buf;
    protected int len;
    boolean closed;
    boolean eof;
    int nativeEndBufSize = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.813 -0400", hash_original_method = "E5B01AC162409617460AC7C3F79F7BB2", hash_generated_method = "B73A7DD75C18D99A4EAF2D14C07892AB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InflaterInputStream(InputStream is) {
        this(is, new Inflater(), BUF_SIZE);
        dsTaint.addTaint(is.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.813 -0400", hash_original_method = "FFCF6E0CDA6D7391850CE9D2857BF932", hash_generated_method = "20F9876F0268EC00B606307E833A99B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InflaterInputStream(InputStream is, Inflater inflater) {
        this(is, inflater, BUF_SIZE);
        dsTaint.addTaint(is.dsTaint);
        dsTaint.addTaint(inflater.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.813 -0400", hash_original_method = "C80CB7FC71CBD6181B9FF475CD694AFF", hash_generated_method = "FF425C67D63856FC05CAA16C4DF9A409")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InflaterInputStream(InputStream is, Inflater inflater, int bsize) {
        super(is);
        dsTaint.addTaint(is.dsTaint);
        dsTaint.addTaint(bsize);
        dsTaint.addTaint(inflater.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        {
            buf = new byte[bsize];
        } //End block
        // ---------- Original Method ----------
        //if (is == null || inflater == null) {
            //throw new NullPointerException();
        //}
        //if (bsize <= 0) {
            //throw new IllegalArgumentException();
        //}
        //this.inf = inflater;
        //if (is instanceof ZipFile.RAFStream) {
            //nativeEndBufSize = bsize;
        //} else {
            //buf = new byte[bsize];
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.814 -0400", hash_original_method = "DEBABCFB0D5C81DCE0E37961227F43C9", hash_generated_method = "7EAC5DC76FB730C208FE94A3EE1B8E79")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int read() throws IOException {
        int var5941BF1153E2E81479FC3BECE4E461FF_1151981367 = (Streams.readSingleByte(this));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return Streams.readSingleByte(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.814 -0400", hash_original_method = "DE515D2D289FDA03BF01DDF0E0AD6AE1", hash_generated_method = "F2DEC395D31DBA971F9B1FED77309681")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int read(byte[] buffer, int offset, int byteCount) throws IOException {
        dsTaint.addTaint(buffer[0]);
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(offset);
        checkClosed();
        Arrays.checkOffsetAndCount(buffer.length, offset, byteCount);
        {
            {
                boolean var1A5A145F098DD1F555879555CE369339_571847564 = (inf.needsInput());
                {
                    fill();
                } //End block
            } //End collapsed parenthetic
            try 
            {
                int result;
                result = inf.inflate(buffer, offset, byteCount);
                eof = inf.finished();
                {
                    boolean var7BCCDB7D901E7D3A1DF620C3DD5F899C_1317643803 = (inf.needsDictionary());
                    {
                        eof = true;
                    } //End block
                    {
                        eof = true;
                        if (DroidSafeAndroidRuntime.control) throw new EOFException();
                    } //End block
                } //End collapsed parenthetic
            } //End block
            catch (DataFormatException e)
            {
                eof = true;
                {
                    if (DroidSafeAndroidRuntime.control) throw new EOFException();
                } //End block
                if (DroidSafeAndroidRuntime.control) throw (IOException) (new IOException().initCause(e));
            } //End block
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.815 -0400", hash_original_method = "92AAFAE1121490A2E461EB88A6DC741C", hash_generated_method = "72BB0360B7996573C88BFC793FE3EBCA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void fill() throws IOException {
        checkClosed();
        {
            ZipFile.RAFStream is;
            is = (ZipFile.RAFStream)in;
            {
                long len;
                len = is.mLength - is.mOffset;
                len = nativeEndBufSize;
                int cnt;
                cnt = inf.setFileInput(is.mSharedRaf.getFD(), is.mOffset, nativeEndBufSize);
                is.skip(cnt);
            } //End block
        } //End block
        {
            {
                boolean var24AC157EF1A0A7950280F7E056FDB23C_443489673 = ((len = in.read(buf)) > 0);
                {
                    inf.setInput(buf, 0, len);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //checkClosed();
        //if (nativeEndBufSize > 0) {
            //ZipFile.RAFStream is = (ZipFile.RAFStream)in;
            //synchronized (is.mSharedRaf) {
                //long len = is.mLength - is.mOffset;
                //if (len > nativeEndBufSize) len = nativeEndBufSize;
                //int cnt = inf.setFileInput(is.mSharedRaf.getFD(), is.mOffset, nativeEndBufSize);
                //is.skip(cnt);
            //}
        //} else {
            //if ((len = in.read(buf)) > 0) {
                //inf.setInput(buf, 0, len);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.815 -0400", hash_original_method = "A9123C6756DDC4D0ED42EE705B1E650B", hash_generated_method = "CF17AB6756E33E4AC3AAD3E33BA3718E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public long skip(long byteCount) throws IOException {
        dsTaint.addTaint(byteCount);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("byteCount < 0");
        } //End block
        long var242616A7471CF01D821614D0D0C41129_1810818043 = (Streams.skipByReading(this, byteCount));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //if (byteCount < 0) {
            //throw new IllegalArgumentException("byteCount < 0");
        //}
        //return Streams.skipByReading(this, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.815 -0400", hash_original_method = "CA27A6E1F269DA8120632D3AC729E489", hash_generated_method = "411727D2D7F425C8878BBFA9B3B38AF8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int available() throws IOException {
        checkClosed();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkClosed();
        //if (eof) {
            //return 0;
        //}
        //return 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.815 -0400", hash_original_method = "EA60532C802B6FAE0DE9014BA74F497F", hash_generated_method = "08938E98150C81F0A8FCB3BCD6A8821B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void close() throws IOException {
        {
            inf.end();
            closed = true;
            eof = true;
            super.close();
        } //End block
        // ---------- Original Method ----------
        //if (!closed) {
            //inf.end();
            //closed = true;
            //eof = true;
            //super.close();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.816 -0400", hash_original_method = "99EDC8CF58ACEFC383E40E1B1F253896", hash_generated_method = "B31C26BECE0372A4FA48EE5727FE34E2")
    @DSModeled(DSC.SAFE)
    @Override
    public void mark(int readlimit) {
        dsTaint.addTaint(readlimit);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.816 -0400", hash_original_method = "B2B0ACE34E24898AD20F33154DDE5ADD", hash_generated_method = "A9C0F826408505F69F969DEF2E274553")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void reset() throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new IOException();
        // ---------- Original Method ----------
        //throw new IOException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.817 -0400", hash_original_method = "12DAC0CE56878A53F37AFF65E12010EB", hash_generated_method = "68288F8CAFD57F6B45948F556AADD5DE")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean markSupported() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.818 -0400", hash_original_method = "249965AABC06DCB5B5F50760C9E2C49A", hash_generated_method = "6CFA37B07466A20BDBB88E064EBD8E21")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkClosed() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Stream is closed");
        } //End block
        // ---------- Original Method ----------
        //if (closed) {
            //throw new IOException("Stream is closed");
        //}
    }

    
    static final int BUF_SIZE = 512;
}

