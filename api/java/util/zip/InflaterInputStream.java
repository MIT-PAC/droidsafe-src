package java.util.zip;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import libcore.io.Streams;





public class InflaterInputStream extends FilterInputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.691 -0400", hash_original_field = "EE7B630995E7A36B6420696989441E2D", hash_generated_field = "1E4B81450D564B8A8EB02BC28E6E6C0F")

    protected Inflater inf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.691 -0400", hash_original_field = "CB7E52B21171FB9A53B498202607F0BD", hash_generated_field = "083037218D1B4F9535944A48D3FD1BCA")

    protected byte[] buf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.691 -0400", hash_original_field = "F5A8E923F8CD24B56B3BAB32358CC58A", hash_generated_field = "5D5995101D8A63DD862FB3CCC8ECEF3F")

    protected int len;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.691 -0400", hash_original_field = "349E686330723975502E9EF4F939A5AC", hash_generated_field = "0B6D06FC66AB1A3316E7702989E3F923")

    boolean closed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.691 -0400", hash_original_field = "2E51B1AB42E8A4A67F3445174BE5191B", hash_generated_field = "F63D5C2A3218247517725999753A7A52")

    boolean eof;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.691 -0400", hash_original_field = "8C71006A0A17320CD77ACB1DAD80DE7B", hash_generated_field = "7E70FEE52575958CC96A2F34CB55F620")

    int nativeEndBufSize = 0;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.691 -0400", hash_original_method = "E5B01AC162409617460AC7C3F79F7BB2", hash_generated_method = "11FC9829F371C62B2D8E7DBEDEBCF710")
    public  InflaterInputStream(InputStream is) {
        this(is, new Inflater(), BUF_SIZE);
        addTaint(is.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.692 -0400", hash_original_method = "FFCF6E0CDA6D7391850CE9D2857BF932", hash_generated_method = "24DBBED2A1216EA5EB3BF61FED6FD656")
    public  InflaterInputStream(InputStream is, Inflater inflater) {
        this(is, inflater, BUF_SIZE);
        addTaint(inflater.getTaint());
        addTaint(is.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.693 -0400", hash_original_method = "C80CB7FC71CBD6181B9FF475CD694AFF", hash_generated_method = "0F11B0C54E5C4D7991CA297D47D34D96")
    public  InflaterInputStream(InputStream is, Inflater inflater, int bsize) {
        super(is);
        addTaint(is.getTaint());
        if(is == null || inflater == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1237600423 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1237600423.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1237600423;
        } //End block
        if(bsize <= 0)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1050128519 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_1050128519.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_1050128519;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.694 -0400", hash_original_method = "DEBABCFB0D5C81DCE0E37961227F43C9", hash_generated_method = "40F7281CD7A95BA9C94DBF0DBF420405")
    @Override
    public int read() throws IOException {
        int varC29A5AE95A30EE64395CAB97F32FA4B0_1027827385 = (Streams.readSingleByte(this));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1627899228 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1627899228;
        // ---------- Original Method ----------
        //return Streams.readSingleByte(this);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.695 -0400", hash_original_method = "DE515D2D289FDA03BF01DDF0E0AD6AE1", hash_generated_method = "DC8862025EDFEF88CE804BC1CACBEB90")
    @Override
    public int read(byte[] buffer, int offset, int byteCount) throws IOException {
        addTaint(byteCount);
        addTaint(offset);
        addTaint(buffer[0]);
        checkClosed();
        Arrays.checkOffsetAndCount(buffer.length, offset, byteCount);
        if(byteCount == 0)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_446875651 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1076392340 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1076392340;
        } //End block
        if(eof)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_530678944 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1898066990 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1898066990;
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
                        int varB4A88417B3D0170D754C647C30B7216A_1385904464 = (result);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_589876071 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_589876071;
                    } //End block
                    else
                    if(eof)                    
                    {
                        int var6BB61E3B7BCE0931DA574D19D1D82C88_236271595 = (-1);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1348245789 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1348245789;
                    } //End block
                    else
                    if(inf.needsDictionary())                    
                    {
                        eof = true;
                        int var6BB61E3B7BCE0931DA574D19D1D82C88_696538319 = (-1);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1208141185 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1208141185;
                    } //End block
                    else
                    if(len == -1)                    
                    {
                        eof = true;
                        EOFException var0239D63DB748BB20D119EB36D6D1C384_953094344 = new EOFException();
                        var0239D63DB748BB20D119EB36D6D1C384_953094344.addTaint(taint);
                        throw var0239D63DB748BB20D119EB36D6D1C384_953094344;
                    } //End block
                } //End block
                catch (DataFormatException e)
                {
                    eof = true;
                    if(len == -1)                    
                    {
                        EOFException var0239D63DB748BB20D119EB36D6D1C384_1312505159 = new EOFException();
                        var0239D63DB748BB20D119EB36D6D1C384_1312505159.addTaint(taint);
                        throw var0239D63DB748BB20D119EB36D6D1C384_1312505159;
                    } //End block
                    IOException varD851A5E0F35BEFB8549066E6DB52F5AA_1481159693 = (IOException) (new IOException().initCause(e));
                    varD851A5E0F35BEFB8549066E6DB52F5AA_1481159693.addTaint(taint);
                    throw varD851A5E0F35BEFB8549066E6DB52F5AA_1481159693;
                } //End block
            } //End block
} while (true);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.696 -0400", hash_original_method = "92AAFAE1121490A2E461EB88A6DC741C", hash_generated_method = "4AE7034CA4125BA66E742BCA4C3BFBBB")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.697 -0400", hash_original_method = "A9123C6756DDC4D0ED42EE705B1E650B", hash_generated_method = "49BDDB87A27098592E2DB3D46462A203")
    @Override
    public long skip(long byteCount) throws IOException {
        addTaint(byteCount);
        if(byteCount < 0)        
        {
            IllegalArgumentException var733C7B5A76FC3574A99FB9CBD2DA28D8_854113698 = new IllegalArgumentException("byteCount < 0");
            var733C7B5A76FC3574A99FB9CBD2DA28D8_854113698.addTaint(taint);
            throw var733C7B5A76FC3574A99FB9CBD2DA28D8_854113698;
        } //End block
        long var905193B4CE519E6DD3D91E1E370ADA87_2092006376 = (Streams.skipByReading(this, byteCount));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1771321111 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1771321111;
        // ---------- Original Method ----------
        //if (byteCount < 0) {
            //throw new IllegalArgumentException("byteCount < 0");
        //}
        //return Streams.skipByReading(this, byteCount);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.697 -0400", hash_original_method = "CA27A6E1F269DA8120632D3AC729E489", hash_generated_method = "420738295A46A3571105E522631DAEFA")
    @Override
    public int available() throws IOException {
        checkClosed();
        if(eof)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_692964920 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1489285229 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1489285229;
        } //End block
        int varC4CA4238A0B923820DCC509A6F75849B_1010685389 = (1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1066183927 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1066183927;
        // ---------- Original Method ----------
        //checkClosed();
        //if (eof) {
            //return 0;
        //}
        //return 1;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.698 -0400", hash_original_method = "EA60532C802B6FAE0DE9014BA74F497F", hash_generated_method = "FE151E217601372EBB465CF0AAC5B660")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.698 -0400", hash_original_method = "99EDC8CF58ACEFC383E40E1B1F253896", hash_generated_method = "374E02FA36CE7C442AE21827EF6D82FC")
    @Override
    public void mark(int readlimit) {
        addTaint(readlimit);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.698 -0400", hash_original_method = "B2B0ACE34E24898AD20F33154DDE5ADD", hash_generated_method = "51EC38CEC6F7856305461F6FAE398AD6")
    @Override
    public void reset() throws IOException {
        IOException var1508E3FDF27FD56D4E1051DB16DE1816_1782334056 = new IOException();
        var1508E3FDF27FD56D4E1051DB16DE1816_1782334056.addTaint(taint);
        throw var1508E3FDF27FD56D4E1051DB16DE1816_1782334056;
        // ---------- Original Method ----------
        //throw new IOException();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.698 -0400", hash_original_method = "12DAC0CE56878A53F37AFF65E12010EB", hash_generated_method = "A8345AA04E1F8890E2A2F33157C1664F")
    @Override
    public boolean markSupported() {
        boolean var68934A3E9455FA72420237EB05902327_1461712079 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_870258860 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_870258860;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.699 -0400", hash_original_method = "249965AABC06DCB5B5F50760C9E2C49A", hash_generated_method = "B8E5CF6E6D4BE673D8B8C1B75ECD22F1")
    private void checkClosed() throws IOException {
        if(closed)        
        {
            IOException var4E3F8A3DA623CEFCDEFE68AFA0DAB154_1914620071 = new IOException("Stream is closed");
            var4E3F8A3DA623CEFCDEFE68AFA0DAB154_1914620071.addTaint(taint);
            throw var4E3F8A3DA623CEFCDEFE68AFA0DAB154_1914620071;
        } //End block
        // ---------- Original Method ----------
        //if (closed) {
            //throw new IOException("Stream is closed");
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.699 -0400", hash_original_field = "D1C827DB9A3BDE870AF89553E76D4553", hash_generated_field = "A60956B00A99CF9DF92AF09280C120E9")

    static final int BUF_SIZE = 512;
}

