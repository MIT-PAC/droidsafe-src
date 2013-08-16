package org.apache.http.impl.io;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.io.SessionInputBuffer;




public class ContentLengthInputStream extends InputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.545 -0400", hash_original_field = "C22384F3ABFE57BC648B6E1701C98123", hash_generated_field = "0235B86EE2D19DB7BC14B5867FCABFC4")

    private long contentLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.545 -0400", hash_original_field = "30905E6E8D02502121446F7E78ED3C72", hash_generated_field = "337E67B29A254DB50F39D690161DCA16")

    private long pos = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.545 -0400", hash_original_field = "1E79543A888DE7BB0ADBB289A8F4251D", hash_generated_field = "AA98B16E301073717D23E903C6D6286D")

    private boolean closed = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.545 -0400", hash_original_field = "8184C339823DFB91A7F30328C371321E", hash_generated_field = "12C364DD3F2CEF8D8A2DC449FD12693B")

    private SessionInputBuffer in = null;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.546 -0400", hash_original_method = "EB9A16D491B02E1C854609CD55105FA5", hash_generated_method = "A9FB7A4461901A5E3962104E6CCA4CA9")
    public  ContentLengthInputStream(final SessionInputBuffer in, long contentLength) {
        super();
        if(in == null)        
        {
            IllegalArgumentException var6634DF518EA4C41A5618DC0E4E5C5981_561737142 = new IllegalArgumentException("Input stream may not be null");
            var6634DF518EA4C41A5618DC0E4E5C5981_561737142.addTaint(taint);
            throw var6634DF518EA4C41A5618DC0E4E5C5981_561737142;
        } //End block
        if(contentLength < 0)        
        {
            IllegalArgumentException varC9A4EC004E3A33FE21D2178F89740754_341661210 = new IllegalArgumentException("Content length may not be negative");
            varC9A4EC004E3A33FE21D2178F89740754_341661210.addTaint(taint);
            throw varC9A4EC004E3A33FE21D2178F89740754_341661210;
        } //End block
        this.in = in;
        this.contentLength = contentLength;
        // ---------- Original Method ----------
        //if (in == null) {
            //throw new IllegalArgumentException("Input stream may not be null");
        //}
        //if (contentLength < 0) {
            //throw new IllegalArgumentException("Content length may not be negative");
        //}
        //this.in = in;
        //this.contentLength = contentLength;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.547 -0400", hash_original_method = "37495B10D833FDE07627744A97E6F360", hash_generated_method = "39ABC36047E0431FDDDCCDAF33183EF4")
    public void close() throws IOException {
        if(!closed)        
        {
            try 
            {
                byte buffer[] = new byte[BUFFER_SIZE];
                while
(read(buffer) >= 0)                
                {
                } //End block
            } //End block
            finally 
            {
                closed = true;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (!closed) {
            //try {
                //byte buffer[] = new byte[BUFFER_SIZE];
                //while (read(buffer) >= 0) {
                //}
            //} finally {
                //closed = true;
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.548 -0400", hash_original_method = "829D665E9575B14A2545A678B846DF03", hash_generated_method = "0F596C6A98EDEDA9A07A23CB6DBF73ED")
    public int read() throws IOException {
        if(closed)        
        {
            IOException varEE3E399CAE0E5DE731C2BF5A8C5ABA04_1765361350 = new IOException("Attempted read from closed stream.");
            varEE3E399CAE0E5DE731C2BF5A8C5ABA04_1765361350.addTaint(taint);
            throw varEE3E399CAE0E5DE731C2BF5A8C5ABA04_1765361350;
        } //End block
        if(pos >= contentLength)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_212444316 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_315205746 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_315205746;
        } //End block
        pos++;
        int var4B24E33D3D9F67DD13235F201B80A449_1607719090 = (this.in.read());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_289226975 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_289226975;
        // ---------- Original Method ----------
        //if (closed) {
            //throw new IOException("Attempted read from closed stream.");
        //}
        //if (pos >= contentLength) {
            //return -1;
        //}
        //pos++;
        //return this.in.read();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.550 -0400", hash_original_method = "7953751167B17924FE4F5EE632E22C6C", hash_generated_method = "A2C8CCB2E97624005DA252A1895A4C48")
    public int read(byte[] b, int off, int len) throws java.io.IOException {
        addTaint(len);
        addTaint(off);
        addTaint(b[0]);
        if(closed)        
        {
            IOException varEE3E399CAE0E5DE731C2BF5A8C5ABA04_286178385 = new IOException("Attempted read from closed stream.");
            varEE3E399CAE0E5DE731C2BF5A8C5ABA04_286178385.addTaint(taint);
            throw varEE3E399CAE0E5DE731C2BF5A8C5ABA04_286178385;
        } //End block
        if(pos >= contentLength)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_283473353 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_785266034 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_785266034;
        } //End block
        if(pos + len > contentLength)        
        {
            len = (int) (contentLength - pos);
        } //End block
        int count = this.in.read(b, off, len);
        pos += count;
        int varE2942A04780E223B215EB8B663CF5353_1534848049 = (count);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_30922710 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_30922710;
        // ---------- Original Method ----------
        //if (closed) {
            //throw new IOException("Attempted read from closed stream.");
        //}
        //if (pos >= contentLength) {
            //return -1;
        //}
        //if (pos + len > contentLength) {
            //len = (int) (contentLength - pos);
        //}
        //int count = this.in.read(b, off, len);
        //pos += count;
        //return count;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.551 -0400", hash_original_method = "03121A7AC3B4E7519E88953F37DA485C", hash_generated_method = "8ACD227DD484B0D4F014512BCCCCBF57")
    public int read(byte[] b) throws IOException {
        addTaint(b[0]);
        int var3AE1B8835719D1E8BA9C297EF156E04B_1541711329 = (read(b, 0, b.length));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_424814465 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_424814465;
        // ---------- Original Method ----------
        //return read(b, 0, b.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.554 -0400", hash_original_method = "F403C2DD7869661F9202FB887EC75E9B", hash_generated_method = "A8FD20A26BFA98DDBDFA35AEA793729D")
    public long skip(long n) throws IOException {
        addTaint(n);
        if(n <= 0)        
        {
            long varCFCD208495D565EF66E7DFF9F98764DA_708763068 = (0);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1524829149 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1524829149;
        } //End block
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
            } //End block
            count += l;
            remaining -= l;
        } //End block
        this.pos += count;
        long varE2942A04780E223B215EB8B663CF5353_1969828164 = (count);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1323445578 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1323445578;
        // ---------- Original Method ----------
        //if (n <= 0) {
            //return 0;
        //}
        //byte[] buffer = new byte[BUFFER_SIZE];
        //long remaining = Math.min(n, this.contentLength - this.pos);
        //long count = 0;
        //while (remaining > 0) {
            //int l = read(buffer, 0, (int)Math.min(BUFFER_SIZE, remaining));
            //if (l == -1) {
                //break;
            //}
            //count += l;
            //remaining -= l;
        //}
        //this.pos += count;
        //return count;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.554 -0400", hash_original_field = "D4808A3FE7592153FBF8721DE2EDDCBC", hash_generated_field = "62F0934D18D3617E6D093F1927E1FC4F")

    private static final int BUFFER_SIZE = 2048;
}

