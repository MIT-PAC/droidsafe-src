package org.apache.http.impl.io;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.http.io.HttpTransportMetrics;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.ByteArrayBuffer;
import org.apache.http.util.CharArrayBuffer;






public abstract class AbstractSessionOutputBuffer implements SessionOutputBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.461 -0400", hash_original_field = "90EFB1EA4F8636AD314AC4EEE074045F", hash_generated_field = "2BD7176B9CB0EEA2FAA19D55872406A1")

    private OutputStream outstream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.461 -0400", hash_original_field = "7F2DB423A49B305459147332FB01CF87", hash_generated_field = "C6CA0CD2A463E4556B9FE48D8551672D")

    private ByteArrayBuffer buffer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.461 -0400", hash_original_field = "6AF027F2A1AB832A1E028F7C18CA5687", hash_generated_field = "76BAEB11C3552BFB23E0B4B99A533DB1")

    private String charset = HTTP.US_ASCII;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.461 -0400", hash_original_field = "EF253EBC8AB611F3735C35E53DC2547D", hash_generated_field = "9303ABFC1EF5CEEB446DE036D38A5721")

    private boolean ascii = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.461 -0400", hash_original_field = "AA59D67C2123F094D0D6798FFE651C4D", hash_generated_field = "D608E8E883C0ADFB9BB241D869189B8C")

    private HttpTransportMetricsImpl metrics;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.461 -0400", hash_original_method = "83EACBB816713C51C4560064650A6E91", hash_generated_method = "83EACBB816713C51C4560064650A6E91")
    public AbstractSessionOutputBuffer ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.462 -0400", hash_original_method = "D2A1D17455BD2E03E126CE24DA4B94C7", hash_generated_method = "6443C37D150EDA0E422F218FF8C57888")
    protected void init(final OutputStream outstream, int buffersize, final HttpParams params) {
        if(outstream == null)        
        {
            IllegalArgumentException var6634DF518EA4C41A5618DC0E4E5C5981_586713625 = new IllegalArgumentException("Input stream may not be null");
            var6634DF518EA4C41A5618DC0E4E5C5981_586713625.addTaint(taint);
            throw var6634DF518EA4C41A5618DC0E4E5C5981_586713625;
        } //End block
        if(buffersize <= 0)        
        {
            IllegalArgumentException varCD9999C5706CD4D5205C93CCF978BDB6_1548728751 = new IllegalArgumentException("Buffer size may not be negative or zero");
            varCD9999C5706CD4D5205C93CCF978BDB6_1548728751.addTaint(taint);
            throw varCD9999C5706CD4D5205C93CCF978BDB6_1548728751;
        } //End block
        if(params == null)        
        {
            IllegalArgumentException var497CCC27A43EDD6EE25BEEC5507E2BE2_1584828673 = new IllegalArgumentException("HTTP parameters may not be null");
            var497CCC27A43EDD6EE25BEEC5507E2BE2_1584828673.addTaint(taint);
            throw var497CCC27A43EDD6EE25BEEC5507E2BE2_1584828673;
        } //End block
        this.outstream = outstream;
        this.buffer = new ByteArrayBuffer(buffersize);
        this.charset = HttpProtocolParams.getHttpElementCharset(params);
        this.ascii = this.charset.equalsIgnoreCase(HTTP.US_ASCII)
                     || this.charset.equalsIgnoreCase(HTTP.ASCII);
        this.metrics = new HttpTransportMetricsImpl();
        // ---------- Original Method ----------
        //if (outstream == null) {
            //throw new IllegalArgumentException("Input stream may not be null");
        //}
        //if (buffersize <= 0) {
            //throw new IllegalArgumentException("Buffer size may not be negative or zero");
        //}
        //if (params == null) {
            //throw new IllegalArgumentException("HTTP parameters may not be null");
        //}
        //this.outstream = outstream;
        //this.buffer = new ByteArrayBuffer(buffersize);
        //this.charset = HttpProtocolParams.getHttpElementCharset(params);
        //this.ascii = this.charset.equalsIgnoreCase(HTTP.US_ASCII)
                     //|| this.charset.equalsIgnoreCase(HTTP.ASCII);
        //this.metrics = new HttpTransportMetricsImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.463 -0400", hash_original_method = "882208160FD161C7E0064D0E60BE1443", hash_generated_method = "25AEC1BF301481F566FBFE619B6EF2FE")
    protected void flushBuffer() throws IOException {
        int len = this.buffer.length();
        if(len > 0)        
        {
            this.outstream.write(this.buffer.buffer(), 0, len);
            this.buffer.clear();
            this.metrics.incrementBytesTransferred(len);
        } //End block
        // ---------- Original Method ----------
        //int len = this.buffer.length();
        //if (len > 0) {
            //this.outstream.write(this.buffer.buffer(), 0, len);
            //this.buffer.clear();
            //this.metrics.incrementBytesTransferred(len);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.463 -0400", hash_original_method = "82CAE825041564C42525435895C12BF6", hash_generated_method = "687C18CED0C47C1E5108C3993CC4F74B")
    public void flush() throws IOException {
        flushBuffer();
        this.outstream.flush();
        // ---------- Original Method ----------
        //flushBuffer();
        //this.outstream.flush();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.463 -0400", hash_original_method = "859D231B5A717C0A7AB5BB92D8C812A2", hash_generated_method = "D3C123B16A68E38F8981CD7346AD1491")
    public void write(final byte[] b, int off, int len) throws IOException {
        addTaint(len);
        addTaint(off);
        addTaint(b[0]);
        if(b == null)        
        {
            return;
        } //End block
        if(len > MAX_CHUNK || len > this.buffer.capacity())        
        {
            flushBuffer();
            this.outstream.write(b, off, len);
            this.metrics.incrementBytesTransferred(len);
        } //End block
        else
        {
            int freecapacity = this.buffer.capacity() - this.buffer.length();
            if(len > freecapacity)            
            {
                flushBuffer();
            } //End block
            this.buffer.append(b, off, len);
        } //End block
        // ---------- Original Method ----------
        //if (b == null) {
            //return;
        //}
        //if (len > MAX_CHUNK || len > this.buffer.capacity()) {
            //flushBuffer();
            //this.outstream.write(b, off, len);
            //this.metrics.incrementBytesTransferred(len);
        //} else {
            //int freecapacity = this.buffer.capacity() - this.buffer.length();
            //if (len > freecapacity) {
                //flushBuffer();
            //}
            //this.buffer.append(b, off, len);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.464 -0400", hash_original_method = "58EC072EF9ABE32C0299240E0A15E9B9", hash_generated_method = "18366781DEADD763941779FF6B46C0D5")
    public void write(final byte[] b) throws IOException {
        addTaint(b[0]);
        if(b == null)        
        {
            return;
        } //End block
        write(b, 0, b.length);
        // ---------- Original Method ----------
        //if (b == null) {
            //return;
        //}
        //write(b, 0, b.length);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.464 -0400", hash_original_method = "3A892F1772116DEABF593C96C9FE9CC0", hash_generated_method = "0AEA9EC75E1CE578F9F9156CEEDB0906")
    public void write(int b) throws IOException {
        addTaint(b);
        if(this.buffer.isFull())        
        {
            flushBuffer();
        } //End block
        this.buffer.append(b);
        // ---------- Original Method ----------
        //if (this.buffer.isFull()) {
            //flushBuffer();
        //}
        //this.buffer.append(b);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.465 -0400", hash_original_method = "028F93C5D719EA2685E11E6920D1D339", hash_generated_method = "507CFB414F7B1BA1FAFD6E47E98D8E61")
    public void writeLine(final String s) throws IOException {
        addTaint(s.getTaint());
        if(s == null)        
        {
            return;
        } //End block
        if(s.length() > 0)        
        {
            write(s.getBytes(this.charset));
        } //End block
        write(CRLF);
        // ---------- Original Method ----------
        //if (s == null) {
            //return;
        //}
        //if (s.length() > 0) {
            //write(s.getBytes(this.charset));
        //}
        //write(CRLF);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.466 -0400", hash_original_method = "58771B165B2EA74A4951928351773B83", hash_generated_method = "94002D1AEE891B867ABB5D089A38869A")
    public void writeLine(final CharArrayBuffer s) throws IOException {
        addTaint(s.getTaint());
        if(s == null)        
        {
            return;
        } //End block
        if(this.ascii)        
        {
            int off = 0;
            int remaining = s.length();
            while
(remaining > 0)            
            {
                int chunk = this.buffer.capacity() - this.buffer.length();
                chunk = Math.min(chunk, remaining);
                if(chunk > 0)                
                {
                    this.buffer.append(s, off, chunk);
                } //End block
                if(this.buffer.isFull())                
                {
                    flushBuffer();
                } //End block
                off += chunk;
                remaining -= chunk;
            } //End block
        } //End block
        else
        {
            byte[] tmp = s.toString().getBytes(this.charset);
            write(tmp);
        } //End block
        write(CRLF);
        // ---------- Original Method ----------
        //if (s == null) {
            //return;
        //}
        //if (this.ascii) {
            //int off = 0;
            //int remaining = s.length();
            //while (remaining > 0) {
                //int chunk = this.buffer.capacity() - this.buffer.length();
                //chunk = Math.min(chunk, remaining);
                //if (chunk > 0) {
                    //this.buffer.append(s, off, chunk);
                //}
                //if (this.buffer.isFull()) {
                    //flushBuffer();
                //}
                //off += chunk;
                //remaining -= chunk;
            //}
        //} else {
            //byte[] tmp = s.toString().getBytes(this.charset);
            //write(tmp);
        //}
        //write(CRLF);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.466 -0400", hash_original_method = "E82E77AA369AC2B118042C614F644F5C", hash_generated_method = "D3823F8A2E7F3CE0A404C830A6487F4C")
    public HttpTransportMetrics getMetrics() {
HttpTransportMetrics varFC1AE2E8C2526EA66FBB8E6B024A2CB6_24561610 =         this.metrics;
        varFC1AE2E8C2526EA66FBB8E6B024A2CB6_24561610.addTaint(taint);
        return varFC1AE2E8C2526EA66FBB8E6B024A2CB6_24561610;
        // ---------- Original Method ----------
        //return this.metrics;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.467 -0400", hash_original_field = "8614F8248A0F6083657CCFEDD01EB9E4", hash_generated_field = "CA476214CA171474EF752CDA85E22F31")

    private static final byte[] CRLF = new byte[] {HTTP.CR, HTTP.LF};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.467 -0400", hash_original_field = "E6A38D2FFE216A27CFB357463D05ED88", hash_generated_field = "3BDE2E6C07EF32014555ADD4B032FE25")

    private static final int MAX_CHUNK = 256;
}

