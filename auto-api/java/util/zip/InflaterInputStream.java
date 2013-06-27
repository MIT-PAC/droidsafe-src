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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.834 -0400", hash_original_field = "EE7B630995E7A36B6420696989441E2D", hash_generated_field = "1E4B81450D564B8A8EB02BC28E6E6C0F")

    protected Inflater inf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.834 -0400", hash_original_field = "CB7E52B21171FB9A53B498202607F0BD", hash_generated_field = "083037218D1B4F9535944A48D3FD1BCA")

    protected byte[] buf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.834 -0400", hash_original_field = "F5A8E923F8CD24B56B3BAB32358CC58A", hash_generated_field = "5D5995101D8A63DD862FB3CCC8ECEF3F")

    protected int len;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.834 -0400", hash_original_field = "349E686330723975502E9EF4F939A5AC", hash_generated_field = "0B6D06FC66AB1A3316E7702989E3F923")

    boolean closed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.834 -0400", hash_original_field = "2E51B1AB42E8A4A67F3445174BE5191B", hash_generated_field = "F63D5C2A3218247517725999753A7A52")

    boolean eof;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.834 -0400", hash_original_field = "8C71006A0A17320CD77ACB1DAD80DE7B", hash_generated_field = "7E70FEE52575958CC96A2F34CB55F620")

    int nativeEndBufSize = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.834 -0400", hash_original_method = "E5B01AC162409617460AC7C3F79F7BB2", hash_generated_method = "11FC9829F371C62B2D8E7DBEDEBCF710")
    public  InflaterInputStream(InputStream is) {
        this(is, new Inflater(), BUF_SIZE);
        addTaint(is.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.835 -0400", hash_original_method = "FFCF6E0CDA6D7391850CE9D2857BF932", hash_generated_method = "DC5EC952F355E00DAED4FF42FBEE1D4A")
    public  InflaterInputStream(InputStream is, Inflater inflater) {
        this(is, inflater, BUF_SIZE);
        addTaint(is.getTaint());
        addTaint(inflater.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.845 -0400", hash_original_method = "C80CB7FC71CBD6181B9FF475CD694AFF", hash_generated_method = "C55AED601B835190C03CF3B653C6039A")
    public  InflaterInputStream(InputStream is, Inflater inflater, int bsize) {
        super(is);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        this.inf = inflater;
        {
            nativeEndBufSize = bsize;
        } //End block
        {
            buf = new byte[bsize];
        } //End block
        addTaint(is.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.845 -0400", hash_original_method = "DEBABCFB0D5C81DCE0E37961227F43C9", hash_generated_method = "1D898B08407B91143B9E6BEC870DEDDD")
    @Override
    public int read() throws IOException {
        int var5941BF1153E2E81479FC3BECE4E461FF_462087539 = (Streams.readSingleByte(this));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1535678444 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1535678444;
        // ---------- Original Method ----------
        //return Streams.readSingleByte(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.862 -0400", hash_original_method = "DE515D2D289FDA03BF01DDF0E0AD6AE1", hash_generated_method = "E2450007EC114A758A918327265EE4D6")
    @Override
    public int read(byte[] buffer, int offset, int byteCount) throws IOException {
        checkClosed();
        Arrays.checkOffsetAndCount(buffer.length, offset, byteCount);
        {
            {
                boolean var1A5A145F098DD1F555879555CE369339_929207608 = (inf.needsInput());
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
                    boolean var7BCCDB7D901E7D3A1DF620C3DD5F899C_1915570568 = (inf.needsDictionary());
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
        addTaint(buffer[0]);
        addTaint(offset);
        addTaint(byteCount);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_86638424 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_86638424;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.863 -0400", hash_original_method = "92AAFAE1121490A2E461EB88A6DC741C", hash_generated_method = "B7A3C9F57BC447144F30BE081B9CF264")
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
                boolean var24AC157EF1A0A7950280F7E056FDB23C_854044943 = ((len = in.read(buf)) > 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.864 -0400", hash_original_method = "A9123C6756DDC4D0ED42EE705B1E650B", hash_generated_method = "CDB085F307AF836B3333DF9D951983A3")
    @Override
    public long skip(long byteCount) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("byteCount < 0");
        } //End block
        long var242616A7471CF01D821614D0D0C41129_1863870038 = (Streams.skipByReading(this, byteCount));
        addTaint(byteCount);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_337608550 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_337608550;
        // ---------- Original Method ----------
        //if (byteCount < 0) {
            //throw new IllegalArgumentException("byteCount < 0");
        //}
        //return Streams.skipByReading(this, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.864 -0400", hash_original_method = "CA27A6E1F269DA8120632D3AC729E489", hash_generated_method = "5F4FEA9B6F9CFA37965CCDFA925428C6")
    @Override
    public int available() throws IOException {
        checkClosed();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1748981860 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1748981860;
        // ---------- Original Method ----------
        //checkClosed();
        //if (eof) {
            //return 0;
        //}
        //return 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.865 -0400", hash_original_method = "EA60532C802B6FAE0DE9014BA74F497F", hash_generated_method = "08938E98150C81F0A8FCB3BCD6A8821B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.865 -0400", hash_original_method = "99EDC8CF58ACEFC383E40E1B1F253896", hash_generated_method = "374E02FA36CE7C442AE21827EF6D82FC")
    @Override
    public void mark(int readlimit) {
        addTaint(readlimit);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.865 -0400", hash_original_method = "B2B0ACE34E24898AD20F33154DDE5ADD", hash_generated_method = "A9C0F826408505F69F969DEF2E274553")
    @Override
    public void reset() throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new IOException();
        // ---------- Original Method ----------
        //throw new IOException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.874 -0400", hash_original_method = "12DAC0CE56878A53F37AFF65E12010EB", hash_generated_method = "3A77307FC02E7930844C52277C50CF83")
    @Override
    public boolean markSupported() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_165599853 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_165599853;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.876 -0400", hash_original_method = "249965AABC06DCB5B5F50760C9E2C49A", hash_generated_method = "6CFA37B07466A20BDBB88E064EBD8E21")
    private void checkClosed() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Stream is closed");
        } //End block
        // ---------- Original Method ----------
        //if (closed) {
            //throw new IOException("Stream is closed");
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.876 -0400", hash_original_field = "D1C827DB9A3BDE870AF89553E76D4553", hash_generated_field = "9880536815CC2F93011C070CDDEA4810")

    static int BUF_SIZE = 512;
}

