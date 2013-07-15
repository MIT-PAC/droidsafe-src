package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Arrays;

public class BufferedInputStream extends FilterInputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:20.282 -0400", hash_original_field = "CB7E52B21171FB9A53B498202607F0BD", hash_generated_field = "C53666C61D704ACE793D3D98401D06E0")

    protected volatile byte[] buf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:20.282 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "CADFF8C1F208C99E14B28CFC1A04442F")

    protected int count;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:20.283 -0400", hash_original_field = "7E1D45D2D0791CB14CAE674BF346C80C", hash_generated_field = "187237640B843AF018F2A924787F8CE1")

    protected int marklimit;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:20.285 -0400", hash_original_field = "492E5D488B8C3F3A5B37BE9C27216BA1", hash_generated_field = "584BEF84693439016482B6900153EC57")

    protected int markpos = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:20.286 -0400", hash_original_field = "5E0BDCBDDCCCA4D66D74BA8C1CEE1A68", hash_generated_field = "3039C52FCC40405280C80DE756778CBF")

    protected int pos;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:20.287 -0400", hash_original_method = "21B504722C790213175AE0F5E25EEBB8", hash_generated_method = "082827D8E12E6C89AE7674A5DA40B439")
    public  BufferedInputStream(InputStream in) {
        this(in, 8192);
        addTaint(in.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:20.289 -0400", hash_original_method = "4F467422085302825BDB985C2FDC72F9", hash_generated_method = "8F79C3026AE72CD496574D27CE56F4C2")
    public  BufferedInputStream(InputStream in, int size) {
        super(in);
        addTaint(in.getTaint());
    if(size <= 0)        
        {
            IllegalArgumentException var5AFB46BA040E4CEE38200888DC74991F_1961474474 = new IllegalArgumentException("size <= 0");
            var5AFB46BA040E4CEE38200888DC74991F_1961474474.addTaint(taint);
            throw var5AFB46BA040E4CEE38200888DC74991F_1961474474;
        } //End block
        buf = new byte[size];
        // ---------- Original Method ----------
        //if (size <= 0) {
            //throw new IllegalArgumentException("size <= 0");
        //}
        //buf = new byte[size];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:38.883 -0400", hash_original_method = "07FFB00D7B3DCD194F29893BBF5B52EB", hash_generated_method = "6F653193B00CDA358F5CB847EF0D2AF8")
    @Override
    public synchronized int available() throws IOException {
        InputStream localIn = in;
    if(buf == null || localIn == null)        
        {
            java.io.IOException varA98E388EB7D58355C3D9798BF8FEED22_1193637902 = streamClosed();
            varA98E388EB7D58355C3D9798BF8FEED22_1193637902.addTaint(taint);
            throw varA98E388EB7D58355C3D9798BF8FEED22_1193637902;
        } //End block
        int varD532F72443E2D24D25126F962BF5192D_820980195 = (count - pos + localIn.available());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_840530851 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_840530851;
        // ---------- Original Method ----------
        //InputStream localIn = in;
        //if (buf == null || localIn == null) {
            //throw streamClosed();
        //}
        //return count - pos + localIn.available();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:38.885 -0400", hash_original_method = "4D8013C45FC6B1A765F1F6C3AB84963B", hash_generated_method = "05EA514ADBDFA5F4DA3E3EA8C124A3F8")
    private IOException streamClosed() throws IOException {
        IOException var89916D241EE2238C12187BD738C2B6DE_1709574113 = new IOException("BufferedInputStream is closed");
        var89916D241EE2238C12187BD738C2B6DE_1709574113.addTaint(taint);
        throw var89916D241EE2238C12187BD738C2B6DE_1709574113;
        // ---------- Original Method ----------
        //throw new IOException("BufferedInputStream is closed");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:38.887 -0400", hash_original_method = "9458B5514F81355F9A651152E456CAE7", hash_generated_method = "B0805CE5B8110FDCECC2334E181CC143")
    @Override
    public void close() throws IOException {
        buf = null;
        InputStream localIn = in;
        in = null;
    if(localIn != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:38.896 -0400", hash_original_method = "763578223906D5382275DB1FE1B265CB", hash_generated_method = "305FE476A93EC855DCAC87FADC9FC20C")
    private int fillbuf(InputStream localIn, byte[] localBuf) throws IOException {
        addTaint(localBuf[0]);
        addTaint(localIn.getTaint());
    if(markpos == -1 || (pos - markpos >= marklimit))        
        {
            int result = localIn.read(localBuf);
    if(result > 0)            
            {
                markpos = -1;
                pos = 0;
                count = result == -1 ? 0 : result;
            } //End block
            int varB4A88417B3D0170D754C647C30B7216A_1223700789 = (result);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1877143416 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1877143416;
        } //End block
    if(markpos == 0 && marklimit > localBuf.length)        
        {
            int newLength = localBuf.length * 2;
    if(newLength > marklimit)            
            {
                newLength = marklimit;
            } //End block
            byte[] newbuf = new byte[newLength];
            System.arraycopy(localBuf, 0, newbuf, 0, localBuf.length);
            localBuf = buf = newbuf;
        } //End block
        else
    if(markpos > 0)        
        {
            System.arraycopy(localBuf, markpos, localBuf, 0, localBuf.length
                    - markpos);
        } //End block
        pos -= markpos;
        count = markpos = 0;
        int bytesread = localIn.read(localBuf, pos, localBuf.length - pos);
        count = bytesread <= 0 ? pos : pos + bytesread;
        int var01B28BAEB777B9C7327B9F35DB7A8609_1432775342 = (bytesread);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1420134265 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1420134265;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:38.899 -0400", hash_original_method = "DF417F804FB76ED4D7DE805338DD287E", hash_generated_method = "E33C32E52CFE857EB9ED3111281AA940")
    @Override
    public synchronized void mark(int readlimit) {
        marklimit = readlimit;
        markpos = pos;
        // ---------- Original Method ----------
        //marklimit = readlimit;
        //markpos = pos;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:38.900 -0400", hash_original_method = "3448BF342B33B519FE64A3FA0274077D", hash_generated_method = "807893A7BB3E0C949A5454A0AF11B146")
    @Override
    public boolean markSupported() {
        boolean varB326B5062B2F0E69046810717534CB09_1652283449 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_981475068 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_981475068;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:38.933 -0400", hash_original_method = "44D2E1EC0EF3B53AC5594D464D2C83B9", hash_generated_method = "B84763FE29402AF9D345756D5311FE3B")
    @Override
    public synchronized int read() throws IOException {
        byte[] localBuf = buf;
        InputStream localIn = in;
    if(localBuf == null || localIn == null)        
        {
            java.io.IOException varA98E388EB7D58355C3D9798BF8FEED22_682371161 = streamClosed();
            varA98E388EB7D58355C3D9798BF8FEED22_682371161.addTaint(taint);
            throw varA98E388EB7D58355C3D9798BF8FEED22_682371161;
        } //End block
    if(pos >= count && fillbuf(localIn, localBuf) == -1)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1597173087 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1077978223 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1077978223;
        } //End block
    if(localBuf != buf)        
        {
            localBuf = buf;
    if(localBuf == null)            
            {
                java.io.IOException varA98E388EB7D58355C3D9798BF8FEED22_424999174 = streamClosed();
                varA98E388EB7D58355C3D9798BF8FEED22_424999174.addTaint(taint);
                throw varA98E388EB7D58355C3D9798BF8FEED22_424999174;
            } //End block
        } //End block
    if(count - pos > 0)        
        {
            int varC8367146E0AB6551BC24E9A0C27B8A26_432354822 = (localBuf[pos++] & 0xFF);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_186075980 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_186075980;
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_598206166 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1090696755 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1090696755;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.022 -0400", hash_original_method = "61DEF23C4EC5BF0BA1725AB1A56B4C17", hash_generated_method = "E0BFB2AAC5BDC0A605CC6FF5DEA3A637")
    @Override
    public synchronized int read(byte[] buffer, int offset, int byteCount) throws IOException {
        addTaint(byteCount);
        addTaint(offset);
        addTaint(buffer[0]);
        byte[] localBuf = buf;
    if(localBuf == null)        
        {
            java.io.IOException varA98E388EB7D58355C3D9798BF8FEED22_499800346 = streamClosed();
            varA98E388EB7D58355C3D9798BF8FEED22_499800346.addTaint(taint);
            throw varA98E388EB7D58355C3D9798BF8FEED22_499800346;
        } //End block
        Arrays.checkOffsetAndCount(buffer.length, offset, byteCount);
    if(byteCount == 0)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_411279899 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_679691618 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_679691618;
        } //End block
        InputStream localIn = in;
    if(localIn == null)        
        {
            java.io.IOException varA98E388EB7D58355C3D9798BF8FEED22_1076681719 = streamClosed();
            varA98E388EB7D58355C3D9798BF8FEED22_1076681719.addTaint(taint);
            throw varA98E388EB7D58355C3D9798BF8FEED22_1076681719;
        } //End block
        int required;
    if(pos < count)        
        {
            int copylength = count - pos >= byteCount ? byteCount : count - pos;
            System.arraycopy(localBuf, pos, buffer, offset, copylength);
            pos += copylength;
    if(copylength == byteCount || localIn.available() == 0)            
            {
                int var7628A5F96B2E1738AE4435B7AB59A209_2048860852 = (copylength);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_543567324 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_543567324;
            } //End block
            offset += copylength;
            required = byteCount - copylength;
        } //End block
        else
        {
            required = byteCount;
        } //End block
        while
(true)        
        {
            int read;
    if(markpos == -1 && required >= localBuf.length)            
            {
                read = localIn.read(buffer, offset, required);
    if(read == -1)                
                {
                    int varE9F7BEC0C88CD14A00890C7265F93994_1599068511 = (required == byteCount ? -1 : byteCount - required);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1079104649 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1079104649;
                } //End block
            } //End block
            else
            {
    if(fillbuf(localIn, localBuf) == -1)                
                {
                    int varE9F7BEC0C88CD14A00890C7265F93994_352841878 = (required == byteCount ? -1 : byteCount - required);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_18958982 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_18958982;
                } //End block
    if(localBuf != buf)                
                {
                    localBuf = buf;
    if(localBuf == null)                    
                    {
                        java.io.IOException varA98E388EB7D58355C3D9798BF8FEED22_1861311741 = streamClosed();
                        varA98E388EB7D58355C3D9798BF8FEED22_1861311741.addTaint(taint);
                        throw varA98E388EB7D58355C3D9798BF8FEED22_1861311741;
                    } //End block
                } //End block
                read = count - pos >= required ? required : count - pos;
                System.arraycopy(localBuf, pos, buffer, offset, read);
                pos += read;
            } //End block
            required -= read;
    if(required == 0)            
            {
                int varA43EF6D60A83013EA1A61A23BDB16029_1072799800 = (byteCount);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1260385434 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1260385434;
            } //End block
    if(localIn.available() == 0)            
            {
                int var879D2AEAC98BC52A6AF483DC5AACBB4E_2043194355 = (byteCount - required);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_22196833 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_22196833;
            } //End block
            offset += read;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.025 -0400", hash_original_method = "0EB3739ECCD523AAEBB3A3F64D0A35BC", hash_generated_method = "8D0E9D34DD14093D810A7B796A779FD2")
    @Override
    public synchronized void reset() throws IOException {
    if(buf == null)        
        {
            IOException var4E3F8A3DA623CEFCDEFE68AFA0DAB154_1854883827 = new IOException("Stream is closed");
            var4E3F8A3DA623CEFCDEFE68AFA0DAB154_1854883827.addTaint(taint);
            throw var4E3F8A3DA623CEFCDEFE68AFA0DAB154_1854883827;
        } //End block
    if(-1 == markpos)        
        {
            IOException varD960D5D97FEA4B4006FCB806C802A79F_1319803997 = new IOException("Mark has been invalidated.");
            varD960D5D97FEA4B4006FCB806C802A79F_1319803997.addTaint(taint);
            throw varD960D5D97FEA4B4006FCB806C802A79F_1319803997;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.070 -0400", hash_original_method = "61D210443DD8F238003AAFD35E7B7777", hash_generated_method = "40FD0D1EEF4F9555A0C5C12F685F76A4")
    @Override
    public synchronized long skip(long byteCount) throws IOException {
        byte[] localBuf = buf;
        InputStream localIn = in;
    if(localBuf == null)        
        {
            java.io.IOException varA98E388EB7D58355C3D9798BF8FEED22_1043947611 = streamClosed();
            varA98E388EB7D58355C3D9798BF8FEED22_1043947611.addTaint(taint);
            throw varA98E388EB7D58355C3D9798BF8FEED22_1043947611;
        } //End block
    if(byteCount < 1)        
        {
            long varCFCD208495D565EF66E7DFF9F98764DA_2081859427 = (0);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_193022188 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_193022188;
        } //End block
    if(localIn == null)        
        {
            java.io.IOException varA98E388EB7D58355C3D9798BF8FEED22_1352804164 = streamClosed();
            varA98E388EB7D58355C3D9798BF8FEED22_1352804164.addTaint(taint);
            throw varA98E388EB7D58355C3D9798BF8FEED22_1352804164;
        } //End block
    if(count - pos >= byteCount)        
        {
            pos += byteCount;
            long varA43EF6D60A83013EA1A61A23BDB16029_1190002324 = (byteCount);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_723759721 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_723759721;
        } //End block
        long read = count - pos;
        pos = count;
    if(markpos != -1)        
        {
    if(byteCount <= marklimit)            
            {
    if(fillbuf(localIn, localBuf) == -1)                
                {
                    long varECAE13117D6F0584C25A9DA6C8F8415E_2079154328 = (read);
                                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1529971151 = getTaintLong();
                    return var0F5264038205EDFB1AC05FBB0E8C5E94_1529971151;
                } //End block
    if(count - pos >= byteCount - read)                
                {
                    pos += byteCount - read;
                    long varA43EF6D60A83013EA1A61A23BDB16029_1316094965 = (byteCount);
                                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1177618026 = getTaintLong();
                    return var0F5264038205EDFB1AC05FBB0E8C5E94_1177618026;
                } //End block
                read += (count - pos);
                pos = count;
                long varECAE13117D6F0584C25A9DA6C8F8415E_73470854 = (read);
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_2022328471 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_2022328471;
            } //End block
        } //End block
        long var7954D807A5D66A0A5F40953FB3C263B3_961878399 = (read + localIn.skip(byteCount - read));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1475674650 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1475674650;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

