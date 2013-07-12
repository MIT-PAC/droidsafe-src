package org.apache.http.impl.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.io.SessionInputBuffer;

public class ContentLengthInputStream extends InputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.169 -0400", hash_original_field = "C22384F3ABFE57BC648B6E1701C98123", hash_generated_field = "0235B86EE2D19DB7BC14B5867FCABFC4")

    private long contentLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.169 -0400", hash_original_field = "30905E6E8D02502121446F7E78ED3C72", hash_generated_field = "337E67B29A254DB50F39D690161DCA16")

    private long pos = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.169 -0400", hash_original_field = "1E79543A888DE7BB0ADBB289A8F4251D", hash_generated_field = "AA98B16E301073717D23E903C6D6286D")

    private boolean closed = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.169 -0400", hash_original_field = "8184C339823DFB91A7F30328C371321E", hash_generated_field = "12C364DD3F2CEF8D8A2DC449FD12693B")

    private SessionInputBuffer in = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.170 -0400", hash_original_method = "EB9A16D491B02E1C854609CD55105FA5", hash_generated_method = "74B35A17BFDDD6F558C3832190B636F4")
    public  ContentLengthInputStream(final SessionInputBuffer in, long contentLength) {
        super();
    if(in == null)        
        {
            IllegalArgumentException var6634DF518EA4C41A5618DC0E4E5C5981_628977929 = new IllegalArgumentException("Input stream may not be null");
            var6634DF518EA4C41A5618DC0E4E5C5981_628977929.addTaint(taint);
            throw var6634DF518EA4C41A5618DC0E4E5C5981_628977929;
        } 
    if(contentLength < 0)        
        {
            IllegalArgumentException varC9A4EC004E3A33FE21D2178F89740754_1369543123 = new IllegalArgumentException("Content length may not be negative");
            varC9A4EC004E3A33FE21D2178F89740754_1369543123.addTaint(taint);
            throw varC9A4EC004E3A33FE21D2178F89740754_1369543123;
        } 
        this.in = in;
        this.contentLength = contentLength;
        
        
            
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.171 -0400", hash_original_method = "37495B10D833FDE07627744A97E6F360", hash_generated_method = "39ABC36047E0431FDDDCCDAF33183EF4")
    public void close() throws IOException {
    if(!closed)        
        {
            try 
            {
                byte buffer[] = new byte[BUFFER_SIZE];
                while
(read(buffer) >= 0)                
                {
                } 
            } 
            finally 
            {
                closed = true;
            } 
        } 
        
        
            
                
                
                
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.171 -0400", hash_original_method = "829D665E9575B14A2545A678B846DF03", hash_generated_method = "30C98DD0E916733765AF3B385B84E4DC")
    public int read() throws IOException {
    if(closed)        
        {
            IOException varEE3E399CAE0E5DE731C2BF5A8C5ABA04_11999268 = new IOException("Attempted read from closed stream.");
            varEE3E399CAE0E5DE731C2BF5A8C5ABA04_11999268.addTaint(taint);
            throw varEE3E399CAE0E5DE731C2BF5A8C5ABA04_11999268;
        } 
    if(pos >= contentLength)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_278073854 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_580987703 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_580987703;
        } 
        pos++;
        int var4B24E33D3D9F67DD13235F201B80A449_996667189 = (this.in.read());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_756770329 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_756770329;
        
        
            
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.173 -0400", hash_original_method = "7953751167B17924FE4F5EE632E22C6C", hash_generated_method = "45603A68BFD414064610EDA25CEE2A9C")
    public int read(byte[] b, int off, int len) throws java.io.IOException {
        addTaint(len);
        addTaint(off);
        addTaint(b[0]);
    if(closed)        
        {
            IOException varEE3E399CAE0E5DE731C2BF5A8C5ABA04_569678461 = new IOException("Attempted read from closed stream.");
            varEE3E399CAE0E5DE731C2BF5A8C5ABA04_569678461.addTaint(taint);
            throw varEE3E399CAE0E5DE731C2BF5A8C5ABA04_569678461;
        } 
    if(pos >= contentLength)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_855488899 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_463377532 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_463377532;
        } 
    if(pos + len > contentLength)        
        {
            len = (int) (contentLength - pos);
        } 
        int count = this.in.read(b, off, len);
        pos += count;
        int varE2942A04780E223B215EB8B663CF5353_1712033036 = (count);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_883936087 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_883936087;
        
        
            
        
        
            
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.174 -0400", hash_original_method = "03121A7AC3B4E7519E88953F37DA485C", hash_generated_method = "02529F7767B340E4ED15364C66FE0645")
    public int read(byte[] b) throws IOException {
        addTaint(b[0]);
        int var3AE1B8835719D1E8BA9C297EF156E04B_50668780 = (read(b, 0, b.length));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1836001629 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1836001629;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.176 -0400", hash_original_method = "F403C2DD7869661F9202FB887EC75E9B", hash_generated_method = "38E0E7AB78BCBC1FF44375199D6BADBB")
    public long skip(long n) throws IOException {
        addTaint(n);
    if(n <= 0)        
        {
            long varCFCD208495D565EF66E7DFF9F98764DA_258973424 = (0);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_361418271 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_361418271;
        } 
        byte[] buffer = new byte[BUFFER_SIZE];
        long remaining = Math.min(n, this.contentLength - this.pos);
        long count = 0;
        while
(remaining > 0)        
        {
            int l = read(buffer, 0, (int)Math.min(BUFFER_SIZE, remaining));
    if(l == -1)            
            {
                break;
            } 
            count += l;
            remaining -= l;
        } 
        this.pos += count;
        long varE2942A04780E223B215EB8B663CF5353_687473915 = (count);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1348954309 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1348954309;
        
        
            
        
        
        
        
        
            
            
                
            
            
            
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.176 -0400", hash_original_field = "D4808A3FE7592153FBF8721DE2EDDCBC", hash_generated_field = "62F0934D18D3617E6D093F1927E1FC4F")

    private static final int BUFFER_SIZE = 2048;
}

