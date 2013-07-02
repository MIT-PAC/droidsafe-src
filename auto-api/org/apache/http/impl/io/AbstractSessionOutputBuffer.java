package org.apache.http.impl.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.io.HttpTransportMetrics;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.ByteArrayBuffer;
import org.apache.http.util.CharArrayBuffer;

public abstract class AbstractSessionOutputBuffer implements SessionOutputBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.683 -0400", hash_original_field = "90EFB1EA4F8636AD314AC4EEE074045F", hash_generated_field = "2BD7176B9CB0EEA2FAA19D55872406A1")

    private OutputStream outstream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.683 -0400", hash_original_field = "7F2DB423A49B305459147332FB01CF87", hash_generated_field = "C6CA0CD2A463E4556B9FE48D8551672D")

    private ByteArrayBuffer buffer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.683 -0400", hash_original_field = "6AF027F2A1AB832A1E028F7C18CA5687", hash_generated_field = "76BAEB11C3552BFB23E0B4B99A533DB1")

    private String charset = HTTP.US_ASCII;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.683 -0400", hash_original_field = "EF253EBC8AB611F3735C35E53DC2547D", hash_generated_field = "9303ABFC1EF5CEEB446DE036D38A5721")

    private boolean ascii = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.683 -0400", hash_original_field = "AA59D67C2123F094D0D6798FFE651C4D", hash_generated_field = "D608E8E883C0ADFB9BB241D869189B8C")

    private HttpTransportMetricsImpl metrics;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.683 -0400", hash_original_method = "83EACBB816713C51C4560064650A6E91", hash_generated_method = "83EACBB816713C51C4560064650A6E91")
    public AbstractSessionOutputBuffer ()
    {
        
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.684 -0400", hash_original_method = "D2A1D17455BD2E03E126CE24DA4B94C7", hash_generated_method = "EF701597FB5FC65BB973B2BBA80BB2F6")
    protected void init(final OutputStream outstream, int buffersize, final HttpParams params) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Input stream may not be null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Buffer size may not be negative or zero");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP parameters may not be null");
        } 
        this.outstream = outstream;
        this.buffer = new ByteArrayBuffer(buffersize);
        this.charset = HttpProtocolParams.getHttpElementCharset(params);
        this.ascii = this.charset.equalsIgnoreCase(HTTP.US_ASCII)
                     || this.charset.equalsIgnoreCase(HTTP.ASCII);
        this.metrics = new HttpTransportMetricsImpl();
        
        
            
        
        
            
        
        
            
        
        
        
        
        
                     
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.684 -0400", hash_original_method = "882208160FD161C7E0064D0E60BE1443", hash_generated_method = "96A7992C50CACB771EF2C149A105A26A")
    protected void flushBuffer() throws IOException {
        int len = this.buffer.length();
        {
            this.outstream.write(this.buffer.buffer(), 0, len);
            this.buffer.clear();
            this.metrics.incrementBytesTransferred(len);
        } 
        
        
        
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.685 -0400", hash_original_method = "82CAE825041564C42525435895C12BF6", hash_generated_method = "687C18CED0C47C1E5108C3993CC4F74B")
    public void flush() throws IOException {
        flushBuffer();
        this.outstream.flush();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.685 -0400", hash_original_method = "859D231B5A717C0A7AB5BB92D8C812A2", hash_generated_method = "9F00BC6182F27271EDAF63ED859C4751")
    public void write(final byte[] b, int off, int len) throws IOException {
        {
            boolean var1AD0A923D1BC1BA895382736EA219E7A_456803764 = (len > MAX_CHUNK || len > this.buffer.capacity());
            {
                flushBuffer();
                this.outstream.write(b, off, len);
                this.metrics.incrementBytesTransferred(len);
            } 
            {
                int freecapacity = this.buffer.capacity() - this.buffer.length();
                {
                    flushBuffer();
                } 
                this.buffer.append(b, off, len);
            } 
        } 
        addTaint(b[0]);
        addTaint(off);
        addTaint(len);
        
        
            
        
        
            
            
            
        
            
            
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.686 -0400", hash_original_method = "58EC072EF9ABE32C0299240E0A15E9B9", hash_generated_method = "FB65F45BB68B7A7E88CDCD733DB100A1")
    public void write(final byte[] b) throws IOException {
        write(b, 0, b.length);
        addTaint(b[0]);
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.686 -0400", hash_original_method = "3A892F1772116DEABF593C96C9FE9CC0", hash_generated_method = "22A5DC99EE76FDFEEA03E4A4E004AF45")
    public void write(int b) throws IOException {
        {
            boolean varC16CAD3883841ABC08A01CBF073AADAF_185696551 = (this.buffer.isFull());
            {
                flushBuffer();
            } 
        } 
        this.buffer.append(b);
        addTaint(b);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.686 -0400", hash_original_method = "028F93C5D719EA2685E11E6920D1D339", hash_generated_method = "354895963042AAFBB8207F36644C71C3")
    public void writeLine(final String s) throws IOException {
        {
            boolean var54C89261BEF62EDBA925AAFF50AD28A1_1619902560 = (s.length() > 0);
            {
                write(s.getBytes(this.charset));
            } 
        } 
        write(CRLF);
        addTaint(s.getTaint());
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.687 -0400", hash_original_method = "58771B165B2EA74A4951928351773B83", hash_generated_method = "0EE2B689F58CCDBB6AE177616D1C502B")
    public void writeLine(final CharArrayBuffer s) throws IOException {
        {
            int off = 0;
            int remaining = s.length();
            {
                int chunk = this.buffer.capacity() - this.buffer.length();
                chunk = Math.min(chunk, remaining);
                {
                    this.buffer.append(s, off, chunk);
                } 
                {
                    boolean var72B6D6297B2C08F159A8216B46F72C87_679643507 = (this.buffer.isFull());
                    {
                        flushBuffer();
                    } 
                } 
                off += chunk;
                remaining -= chunk;
            } 
        } 
        {
            byte[] tmp = s.toString().getBytes(this.charset);
            write(tmp);
        } 
        write(CRLF);
        addTaint(s.getTaint());
        
        
            
        
        
            
            
            
                
                
                
                    
                
                
                    
                
                
                
            
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.688 -0400", hash_original_method = "E82E77AA369AC2B118042C614F644F5C", hash_generated_method = "66EDC08AF4938407E0FDD612A9294E23")
    public HttpTransportMetrics getMetrics() {
        HttpTransportMetrics varB4EAC82CA7396A68D541C85D26508E83_1205683807 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1205683807 = this.metrics;
        varB4EAC82CA7396A68D541C85D26508E83_1205683807.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1205683807;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.688 -0400", hash_original_field = "8614F8248A0F6083657CCFEDD01EB9E4", hash_generated_field = "CA476214CA171474EF752CDA85E22F31")

    private static final byte[] CRLF = new byte[] {HTTP.CR, HTTP.LF};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.688 -0400", hash_original_field = "E6A38D2FFE216A27CFB357463D05ED88", hash_generated_field = "3BDE2E6C07EF32014555ADD4B032FE25")

    private static final int MAX_CHUNK = 256;
}

