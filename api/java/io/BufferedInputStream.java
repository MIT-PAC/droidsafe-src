package java.io;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.Arrays;






public class BufferedInputStream extends FilterInputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.226 -0400", hash_original_field = "CB7E52B21171FB9A53B498202607F0BD", hash_generated_field = "C53666C61D704ACE793D3D98401D06E0")

    protected volatile byte[] buf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.226 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "CADFF8C1F208C99E14B28CFC1A04442F")

    protected int count;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.226 -0400", hash_original_field = "7E1D45D2D0791CB14CAE674BF346C80C", hash_generated_field = "187237640B843AF018F2A924787F8CE1")

    protected int marklimit;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.226 -0400", hash_original_field = "492E5D488B8C3F3A5B37BE9C27216BA1", hash_generated_field = "584BEF84693439016482B6900153EC57")

    protected int markpos = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.226 -0400", hash_original_field = "5E0BDCBDDCCCA4D66D74BA8C1CEE1A68", hash_generated_field = "3039C52FCC40405280C80DE756778CBF")

    protected int pos;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.226 -0400", hash_original_method = "21B504722C790213175AE0F5E25EEBB8", hash_generated_method = "082827D8E12E6C89AE7674A5DA40B439")
    public  BufferedInputStream(InputStream in) {
        this(in, 8192);
        addTaint(in.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.227 -0400", hash_original_method = "4F467422085302825BDB985C2FDC72F9", hash_generated_method = "33F47EABF50AF381ECA2F52E40741515")
    public  BufferedInputStream(InputStream in, int size) {
        super(in);
        addTaint(in.getTaint());
        if(size <= 0)        
        {
            IllegalArgumentException var5AFB46BA040E4CEE38200888DC74991F_400185253 = new IllegalArgumentException("size <= 0");
            var5AFB46BA040E4CEE38200888DC74991F_400185253.addTaint(taint);
            throw var5AFB46BA040E4CEE38200888DC74991F_400185253;
        } //End block
        buf = new byte[size];
        // ---------- Original Method ----------
        //if (size <= 0) {
            //throw new IllegalArgumentException("size <= 0");
        //}
        //buf = new byte[size];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.240 -0400", hash_original_method = "07FFB00D7B3DCD194F29893BBF5B52EB", hash_generated_method = "B05545DDDCE9E193B3A1242967BEC7C2")
    @Override
    public synchronized int available() throws IOException {
        InputStream localIn = in;
        if(buf == null || localIn == null)        
        {
            java.io.IOException varA98E388EB7D58355C3D9798BF8FEED22_1732673131 = streamClosed();
            varA98E388EB7D58355C3D9798BF8FEED22_1732673131.addTaint(taint);
            throw varA98E388EB7D58355C3D9798BF8FEED22_1732673131;
        } //End block
        int varD532F72443E2D24D25126F962BF5192D_1529426523 = (count - pos + localIn.available());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1521759512 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1521759512;
        // ---------- Original Method ----------
        //InputStream localIn = in;
        //if (buf == null || localIn == null) {
            //throw streamClosed();
        //}
        //return count - pos + localIn.available();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.241 -0400", hash_original_method = "4D8013C45FC6B1A765F1F6C3AB84963B", hash_generated_method = "5AA9CFA9376539DB00F5A5D78696581C")
    private IOException streamClosed() throws IOException {
        IOException var89916D241EE2238C12187BD738C2B6DE_507137193 = new IOException("BufferedInputStream is closed");
        var89916D241EE2238C12187BD738C2B6DE_507137193.addTaint(taint);
        throw var89916D241EE2238C12187BD738C2B6DE_507137193;
        // ---------- Original Method ----------
        //throw new IOException("BufferedInputStream is closed");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.241 -0400", hash_original_method = "9458B5514F81355F9A651152E456CAE7", hash_generated_method = "B0805CE5B8110FDCECC2334E181CC143")
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.243 -0400", hash_original_method = "763578223906D5382275DB1FE1B265CB", hash_generated_method = "3680F9739C189BD077973F250B4FA91E")
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
            int varB4A88417B3D0170D754C647C30B7216A_1039366504 = (result);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_3975677 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_3975677;
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
        int var01B28BAEB777B9C7327B9F35DB7A8609_1091875760 = (bytesread);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_877185649 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_877185649;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.245 -0400", hash_original_method = "DF417F804FB76ED4D7DE805338DD287E", hash_generated_method = "E33C32E52CFE857EB9ED3111281AA940")
    @Override
    public synchronized void mark(int readlimit) {
        marklimit = readlimit;
        markpos = pos;
        // ---------- Original Method ----------
        //marklimit = readlimit;
        //markpos = pos;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.245 -0400", hash_original_method = "3448BF342B33B519FE64A3FA0274077D", hash_generated_method = "2D205BF0C7B6F1731DD6914EF730603B")
    @Override
    public boolean markSupported() {
        boolean varB326B5062B2F0E69046810717534CB09_1530606018 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_254791470 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_254791470;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.257 -0400", hash_original_method = "44D2E1EC0EF3B53AC5594D464D2C83B9", hash_generated_method = "46974C7D647CF9CEF2FCF1144E6FA7A2")
    @Override
    public synchronized int read() throws IOException {
        byte[] localBuf = buf;
        InputStream localIn = in;
        if(localBuf == null || localIn == null)        
        {
            java.io.IOException varA98E388EB7D58355C3D9798BF8FEED22_384249906 = streamClosed();
            varA98E388EB7D58355C3D9798BF8FEED22_384249906.addTaint(taint);
            throw varA98E388EB7D58355C3D9798BF8FEED22_384249906;
        } //End block
        if(pos >= count && fillbuf(localIn, localBuf) == -1)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1029273064 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_498166845 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_498166845;
        } //End block
        if(localBuf != buf)        
        {
            localBuf = buf;
            if(localBuf == null)            
            {
                java.io.IOException varA98E388EB7D58355C3D9798BF8FEED22_646643365 = streamClosed();
                varA98E388EB7D58355C3D9798BF8FEED22_646643365.addTaint(taint);
                throw varA98E388EB7D58355C3D9798BF8FEED22_646643365;
            } //End block
        } //End block
        if(count - pos > 0)        
        {
            int varC8367146E0AB6551BC24E9A0C27B8A26_252534196 = (localBuf[pos++] & 0xFF);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_81375424 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_81375424;
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_226099147 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_360131753 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_360131753;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.284 -0400", hash_original_method = "61DEF23C4EC5BF0BA1725AB1A56B4C17", hash_generated_method = "A797C94A79E0360AC2C69A8877F1ADFB")
    @Override
    public synchronized int read(byte[] buffer, int offset, int byteCount) throws IOException {
        addTaint(byteCount);
        addTaint(offset);
        addTaint(buffer[0]);
        byte[] localBuf = buf;
        if(localBuf == null)        
        {
            java.io.IOException varA98E388EB7D58355C3D9798BF8FEED22_1759255349 = streamClosed();
            varA98E388EB7D58355C3D9798BF8FEED22_1759255349.addTaint(taint);
            throw varA98E388EB7D58355C3D9798BF8FEED22_1759255349;
        } //End block
        Arrays.checkOffsetAndCount(buffer.length, offset, byteCount);
        if(byteCount == 0)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1607573965 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1876561240 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1876561240;
        } //End block
        InputStream localIn = in;
        if(localIn == null)        
        {
            java.io.IOException varA98E388EB7D58355C3D9798BF8FEED22_852830118 = streamClosed();
            varA98E388EB7D58355C3D9798BF8FEED22_852830118.addTaint(taint);
            throw varA98E388EB7D58355C3D9798BF8FEED22_852830118;
        } //End block
        int required;
        if(pos < count)        
        {
            int copylength = count - pos >= byteCount ? byteCount : count - pos;
            System.arraycopy(localBuf, pos, buffer, offset, copylength);
            pos += copylength;
            if(copylength == byteCount || localIn.available() == 0)            
            {
                int var7628A5F96B2E1738AE4435B7AB59A209_1218510602 = (copylength);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1409738655 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1409738655;
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
                    int varE9F7BEC0C88CD14A00890C7265F93994_318780106 = (required == byteCount ? -1 : byteCount - required);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_867354855 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_867354855;
                } //End block
            } //End block
            else
            {
                if(fillbuf(localIn, localBuf) == -1)                
                {
                    int varE9F7BEC0C88CD14A00890C7265F93994_1615711291 = (required == byteCount ? -1 : byteCount - required);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_745156374 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_745156374;
                } //End block
                if(localBuf != buf)                
                {
                    localBuf = buf;
                    if(localBuf == null)                    
                    {
                        java.io.IOException varA98E388EB7D58355C3D9798BF8FEED22_1789705881 = streamClosed();
                        varA98E388EB7D58355C3D9798BF8FEED22_1789705881.addTaint(taint);
                        throw varA98E388EB7D58355C3D9798BF8FEED22_1789705881;
                    } //End block
                } //End block
                read = count - pos >= required ? required : count - pos;
                System.arraycopy(localBuf, pos, buffer, offset, read);
                pos += read;
            } //End block
            required -= read;
            if(required == 0)            
            {
                int varA43EF6D60A83013EA1A61A23BDB16029_873687190 = (byteCount);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1090108590 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1090108590;
            } //End block
            if(localIn.available() == 0)            
            {
                int var879D2AEAC98BC52A6AF483DC5AACBB4E_1131820907 = (byteCount - required);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_498733294 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_498733294;
            } //End block
            offset += read;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.285 -0400", hash_original_method = "0EB3739ECCD523AAEBB3A3F64D0A35BC", hash_generated_method = "DAB59114C74A955AA2A11F71E00A3278")
    @Override
    public synchronized void reset() throws IOException {
        if(buf == null)        
        {
            IOException var4E3F8A3DA623CEFCDEFE68AFA0DAB154_1687404629 = new IOException("Stream is closed");
            var4E3F8A3DA623CEFCDEFE68AFA0DAB154_1687404629.addTaint(taint);
            throw var4E3F8A3DA623CEFCDEFE68AFA0DAB154_1687404629;
        } //End block
        if(-1 == markpos)        
        {
            IOException varD960D5D97FEA4B4006FCB806C802A79F_1064424916 = new IOException("Mark has been invalidated.");
            varD960D5D97FEA4B4006FCB806C802A79F_1064424916.addTaint(taint);
            throw varD960D5D97FEA4B4006FCB806C802A79F_1064424916;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.305 -0400", hash_original_method = "61D210443DD8F238003AAFD35E7B7777", hash_generated_method = "0B21355ADA4328DAAB8267621925C821")
    @Override
    public synchronized long skip(long byteCount) throws IOException {
        byte[] localBuf = buf;
        InputStream localIn = in;
        if(localBuf == null)        
        {
            java.io.IOException varA98E388EB7D58355C3D9798BF8FEED22_816800908 = streamClosed();
            varA98E388EB7D58355C3D9798BF8FEED22_816800908.addTaint(taint);
            throw varA98E388EB7D58355C3D9798BF8FEED22_816800908;
        } //End block
        if(byteCount < 1)        
        {
            long varCFCD208495D565EF66E7DFF9F98764DA_714662884 = (0);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1182541251 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1182541251;
        } //End block
        if(localIn == null)        
        {
            java.io.IOException varA98E388EB7D58355C3D9798BF8FEED22_2056356566 = streamClosed();
            varA98E388EB7D58355C3D9798BF8FEED22_2056356566.addTaint(taint);
            throw varA98E388EB7D58355C3D9798BF8FEED22_2056356566;
        } //End block
        if(count - pos >= byteCount)        
        {
            pos += byteCount;
            long varA43EF6D60A83013EA1A61A23BDB16029_1709943237 = (byteCount);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_702896712 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_702896712;
        } //End block
        long read = count - pos;
        pos = count;
        if(markpos != -1)        
        {
            if(byteCount <= marklimit)            
            {
                if(fillbuf(localIn, localBuf) == -1)                
                {
                    long varECAE13117D6F0584C25A9DA6C8F8415E_1387929206 = (read);
                                        long var0F5264038205EDFB1AC05FBB0E8C5E94_389635758 = getTaintLong();
                    return var0F5264038205EDFB1AC05FBB0E8C5E94_389635758;
                } //End block
                if(count - pos >= byteCount - read)                
                {
                    pos += byteCount - read;
                    long varA43EF6D60A83013EA1A61A23BDB16029_425324044 = (byteCount);
                                        long var0F5264038205EDFB1AC05FBB0E8C5E94_145922265 = getTaintLong();
                    return var0F5264038205EDFB1AC05FBB0E8C5E94_145922265;
                } //End block
                read += (count - pos);
                pos = count;
                long varECAE13117D6F0584C25A9DA6C8F8415E_1816685605 = (read);
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_473695715 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_473695715;
            } //End block
        } //End block
        long var7954D807A5D66A0A5F40953FB3C263B3_115465889 = (read + localIn.skip(byteCount - read));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1000358687 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1000358687;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

