package java.util.zip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import libcore.io.Streams;

public class InflaterInputStream extends FilterInputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.454 -0400", hash_original_field = "EE7B630995E7A36B6420696989441E2D", hash_generated_field = "1E4B81450D564B8A8EB02BC28E6E6C0F")

    protected Inflater inf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.454 -0400", hash_original_field = "CB7E52B21171FB9A53B498202607F0BD", hash_generated_field = "083037218D1B4F9535944A48D3FD1BCA")

    protected byte[] buf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.454 -0400", hash_original_field = "F5A8E923F8CD24B56B3BAB32358CC58A", hash_generated_field = "5D5995101D8A63DD862FB3CCC8ECEF3F")

    protected int len;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.454 -0400", hash_original_field = "349E686330723975502E9EF4F939A5AC", hash_generated_field = "0B6D06FC66AB1A3316E7702989E3F923")

    boolean closed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.454 -0400", hash_original_field = "2E51B1AB42E8A4A67F3445174BE5191B", hash_generated_field = "F63D5C2A3218247517725999753A7A52")

    boolean eof;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.454 -0400", hash_original_field = "8C71006A0A17320CD77ACB1DAD80DE7B", hash_generated_field = "7E70FEE52575958CC96A2F34CB55F620")

    int nativeEndBufSize = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.455 -0400", hash_original_method = "E5B01AC162409617460AC7C3F79F7BB2", hash_generated_method = "11FC9829F371C62B2D8E7DBEDEBCF710")
    public  InflaterInputStream(InputStream is) {
        this(is, new Inflater(), BUF_SIZE);
        addTaint(is.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.455 -0400", hash_original_method = "FFCF6E0CDA6D7391850CE9D2857BF932", hash_generated_method = "24DBBED2A1216EA5EB3BF61FED6FD656")
    public  InflaterInputStream(InputStream is, Inflater inflater) {
        this(is, inflater, BUF_SIZE);
        addTaint(inflater.getTaint());
        addTaint(is.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.456 -0400", hash_original_method = "C80CB7FC71CBD6181B9FF475CD694AFF", hash_generated_method = "56BE6904C0FB15D2FAD836DE65FF589E")
    public  InflaterInputStream(InputStream is, Inflater inflater, int bsize) {
        super(is);
        addTaint(is.getTaint());
    if(is == null || inflater == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1608367888 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1608367888.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1608367888;
        } //End block
    if(bsize <= 0)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_260000605 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_260000605.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_260000605;
        } //End block
        this.inf = inflater;
    if(is instanceof ZipFile.RAFStream)        
        {
            nativeEndBufSize = bsize;
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.456 -0400", hash_original_method = "DEBABCFB0D5C81DCE0E37961227F43C9", hash_generated_method = "18F1198030B9CF3A61DB0D28B23A407D")
    @Override
    public int read() throws IOException {
        int varC29A5AE95A30EE64395CAB97F32FA4B0_1040056608 = (Streams.readSingleByte(this));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2129040048 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2129040048;
        // ---------- Original Method ----------
        //return Streams.readSingleByte(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.458 -0400", hash_original_method = "DE515D2D289FDA03BF01DDF0E0AD6AE1", hash_generated_method = "7FE97F4F15793146B97B8C07AB8D7970")
    @Override
    public int read(byte[] buffer, int offset, int byteCount) throws IOException {
        addTaint(byteCount);
        addTaint(offset);
        addTaint(buffer[0]);
        checkClosed();
        Arrays.checkOffsetAndCount(buffer.length, offset, byteCount);
    if(byteCount == 0)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1598156933 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2035367092 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2035367092;
        } //End block
    if(eof)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_744326151 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1847695659 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1847695659;
        } //End block
        do {
            {
    if(inf.needsInput())                
                {
                    fill();
                } //End block
                try 
                {
                    int result = inf.inflate(buffer, offset, byteCount);
                    eof = inf.finished();
    if(result > 0)                    
                    {
                        int varB4A88417B3D0170D754C647C30B7216A_1862256795 = (result);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_888945870 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_888945870;
                    } //End block
                    else
    if(eof)                    
                    {
                        int var6BB61E3B7BCE0931DA574D19D1D82C88_1739573286 = (-1);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_913733874 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_913733874;
                    } //End block
                    else
    if(inf.needsDictionary())                    
                    {
                        eof = true;
                        int var6BB61E3B7BCE0931DA574D19D1D82C88_225827802 = (-1);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1257785092 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1257785092;
                    } //End block
                    else
    if(len == -1)                    
                    {
                        eof = true;
                        EOFException var0239D63DB748BB20D119EB36D6D1C384_428698752 = new EOFException();
                        var0239D63DB748BB20D119EB36D6D1C384_428698752.addTaint(taint);
                        throw var0239D63DB748BB20D119EB36D6D1C384_428698752;
                    } //End block
                } //End block
                catch (DataFormatException e)
                {
                    eof = true;
    if(len == -1)                    
                    {
                        EOFException var0239D63DB748BB20D119EB36D6D1C384_876697865 = new EOFException();
                        var0239D63DB748BB20D119EB36D6D1C384_876697865.addTaint(taint);
                        throw var0239D63DB748BB20D119EB36D6D1C384_876697865;
                    } //End block
                    IOException varD851A5E0F35BEFB8549066E6DB52F5AA_8620507 = (IOException) (new IOException().initCause(e));
                    varD851A5E0F35BEFB8549066E6DB52F5AA_8620507.addTaint(taint);
                    throw varD851A5E0F35BEFB8549066E6DB52F5AA_8620507;
                } //End block
            } //End block
} while (true);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.459 -0400", hash_original_method = "92AAFAE1121490A2E461EB88A6DC741C", hash_generated_method = "4AE7034CA4125BA66E742BCA4C3BFBBB")
    protected void fill() throws IOException {
        checkClosed();
    if(nativeEndBufSize > 0)        
        {
            ZipFile.RAFStream is = (ZipFile.RAFStream)in;
            synchronized
(is.mSharedRaf)            {
                long len = is.mLength - is.mOffset;
    if(len > nativeEndBufSize)                
                len = nativeEndBufSize;
                int cnt = inf.setFileInput(is.mSharedRaf.getFD(), is.mOffset, nativeEndBufSize);
                is.skip(cnt);
            } //End block
        } //End block
        else
        {
    if((len = in.read(buf)) > 0)            
            {
                inf.setInput(buf, 0, len);
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.460 -0400", hash_original_method = "A9123C6756DDC4D0ED42EE705B1E650B", hash_generated_method = "F08FED5F0010414C70428F392058EEF9")
    @Override
    public long skip(long byteCount) throws IOException {
        addTaint(byteCount);
    if(byteCount < 0)        
        {
            IllegalArgumentException var733C7B5A76FC3574A99FB9CBD2DA28D8_663634614 = new IllegalArgumentException("byteCount < 0");
            var733C7B5A76FC3574A99FB9CBD2DA28D8_663634614.addTaint(taint);
            throw var733C7B5A76FC3574A99FB9CBD2DA28D8_663634614;
        } //End block
        long var905193B4CE519E6DD3D91E1E370ADA87_696181395 = (Streams.skipByReading(this, byteCount));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_204264567 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_204264567;
        // ---------- Original Method ----------
        //if (byteCount < 0) {
            //throw new IllegalArgumentException("byteCount < 0");
        //}
        //return Streams.skipByReading(this, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.460 -0400", hash_original_method = "CA27A6E1F269DA8120632D3AC729E489", hash_generated_method = "54AF447E258D1C67BCF9EA576EA6355B")
    @Override
    public int available() throws IOException {
        checkClosed();
    if(eof)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1700174957 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1714141797 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1714141797;
        } //End block
        int varC4CA4238A0B923820DCC509A6F75849B_1336441505 = (1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2047949411 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2047949411;
        // ---------- Original Method ----------
        //checkClosed();
        //if (eof) {
            //return 0;
        //}
        //return 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.461 -0400", hash_original_method = "EA60532C802B6FAE0DE9014BA74F497F", hash_generated_method = "FE151E217601372EBB465CF0AAC5B660")
    @Override
    public void close() throws IOException {
    if(!closed)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.461 -0400", hash_original_method = "99EDC8CF58ACEFC383E40E1B1F253896", hash_generated_method = "374E02FA36CE7C442AE21827EF6D82FC")
    @Override
    public void mark(int readlimit) {
        addTaint(readlimit);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.461 -0400", hash_original_method = "B2B0ACE34E24898AD20F33154DDE5ADD", hash_generated_method = "370C4233109C0FE15E824753B61FDBD1")
    @Override
    public void reset() throws IOException {
        IOException var1508E3FDF27FD56D4E1051DB16DE1816_502753927 = new IOException();
        var1508E3FDF27FD56D4E1051DB16DE1816_502753927.addTaint(taint);
        throw var1508E3FDF27FD56D4E1051DB16DE1816_502753927;
        // ---------- Original Method ----------
        //throw new IOException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.462 -0400", hash_original_method = "12DAC0CE56878A53F37AFF65E12010EB", hash_generated_method = "E42B042EDE193D76963AA49F46CB5A9E")
    @Override
    public boolean markSupported() {
        boolean var68934A3E9455FA72420237EB05902327_1736808886 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_714885066 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_714885066;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.462 -0400", hash_original_method = "249965AABC06DCB5B5F50760C9E2C49A", hash_generated_method = "F0489217BA4667E6AB4E65C3F17F9121")
    private void checkClosed() throws IOException {
    if(closed)        
        {
            IOException var4E3F8A3DA623CEFCDEFE68AFA0DAB154_1635563971 = new IOException("Stream is closed");
            var4E3F8A3DA623CEFCDEFE68AFA0DAB154_1635563971.addTaint(taint);
            throw var4E3F8A3DA623CEFCDEFE68AFA0DAB154_1635563971;
        } //End block
        // ---------- Original Method ----------
        //if (closed) {
            //throw new IOException("Stream is closed");
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.462 -0400", hash_original_field = "D1C827DB9A3BDE870AF89553E76D4553", hash_generated_field = "A60956B00A99CF9DF92AF09280C120E9")

    static final int BUF_SIZE = 512;
}

