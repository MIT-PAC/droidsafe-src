package org.apache.http.impl.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.709 -0400", hash_original_field = "90EFB1EA4F8636AD314AC4EEE074045F", hash_generated_field = "2BD7176B9CB0EEA2FAA19D55872406A1")

    private OutputStream outstream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.709 -0400", hash_original_field = "7F2DB423A49B305459147332FB01CF87", hash_generated_field = "C6CA0CD2A463E4556B9FE48D8551672D")

    private ByteArrayBuffer buffer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.709 -0400", hash_original_field = "6AF027F2A1AB832A1E028F7C18CA5687", hash_generated_field = "76BAEB11C3552BFB23E0B4B99A533DB1")

    private String charset = HTTP.US_ASCII;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.709 -0400", hash_original_field = "EF253EBC8AB611F3735C35E53DC2547D", hash_generated_field = "9303ABFC1EF5CEEB446DE036D38A5721")

    private boolean ascii = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.709 -0400", hash_original_field = "AA59D67C2123F094D0D6798FFE651C4D", hash_generated_field = "D608E8E883C0ADFB9BB241D869189B8C")

    private HttpTransportMetricsImpl metrics;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.709 -0400", hash_original_method = "83EACBB816713C51C4560064650A6E91", hash_generated_method = "83EACBB816713C51C4560064650A6E91")
    public AbstractSessionOutputBuffer ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.710 -0400", hash_original_method = "D2A1D17455BD2E03E126CE24DA4B94C7", hash_generated_method = "EF701597FB5FC65BB973B2BBA80BB2F6")
    protected void init(final OutputStream outstream, int buffersize, final HttpParams params) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Input stream may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Buffer size may not be negative or zero");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP parameters may not be null");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.715 -0400", hash_original_method = "882208160FD161C7E0064D0E60BE1443", hash_generated_method = "9602F87DACEB8C59355F1EE67707B43B")
    protected void flushBuffer() throws IOException {
        int len;
        len = this.buffer.length();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.716 -0400", hash_original_method = "82CAE825041564C42525435895C12BF6", hash_generated_method = "687C18CED0C47C1E5108C3993CC4F74B")
    public void flush() throws IOException {
        flushBuffer();
        this.outstream.flush();
        // ---------- Original Method ----------
        //flushBuffer();
        //this.outstream.flush();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.720 -0400", hash_original_method = "859D231B5A717C0A7AB5BB92D8C812A2", hash_generated_method = "9F802F6CAB9ADC20C77BB33BD50ACB7A")
    public void write(final byte[] b, int off, int len) throws IOException {
        {
            boolean var1AD0A923D1BC1BA895382736EA219E7A_799823943 = (len > MAX_CHUNK || len > this.buffer.capacity());
            {
                flushBuffer();
                this.outstream.write(b, off, len);
                this.metrics.incrementBytesTransferred(len);
            } //End block
            {
                int freecapacity;
                freecapacity = this.buffer.capacity() - this.buffer.length();
                {
                    flushBuffer();
                } //End block
                this.buffer.append(b, off, len);
            } //End block
        } //End collapsed parenthetic
        addTaint(b[0]);
        addTaint(off);
        addTaint(len);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.731 -0400", hash_original_method = "58EC072EF9ABE32C0299240E0A15E9B9", hash_generated_method = "FB65F45BB68B7A7E88CDCD733DB100A1")
    public void write(final byte[] b) throws IOException {
        write(b, 0, b.length);
        addTaint(b[0]);
        // ---------- Original Method ----------
        //if (b == null) {
            //return;
        //}
        //write(b, 0, b.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.732 -0400", hash_original_method = "3A892F1772116DEABF593C96C9FE9CC0", hash_generated_method = "477A4EE41BF2D62BA07927587DF1BCBF")
    public void write(int b) throws IOException {
        {
            boolean varC16CAD3883841ABC08A01CBF073AADAF_755933241 = (this.buffer.isFull());
            {
                flushBuffer();
            } //End block
        } //End collapsed parenthetic
        this.buffer.append(b);
        addTaint(b);
        // ---------- Original Method ----------
        //if (this.buffer.isFull()) {
            //flushBuffer();
        //}
        //this.buffer.append(b);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.748 -0400", hash_original_method = "028F93C5D719EA2685E11E6920D1D339", hash_generated_method = "DD0D80F928925FB8A5549D29D4733594")
    public void writeLine(final String s) throws IOException {
        {
            boolean var54C89261BEF62EDBA925AAFF50AD28A1_800857362 = (s.length() > 0);
            {
                write(s.getBytes(this.charset));
            } //End block
        } //End collapsed parenthetic
        write(CRLF);
        addTaint(s.getTaint());
        // ---------- Original Method ----------
        //if (s == null) {
            //return;
        //}
        //if (s.length() > 0) {
            //write(s.getBytes(this.charset));
        //}
        //write(CRLF);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.757 -0400", hash_original_method = "58771B165B2EA74A4951928351773B83", hash_generated_method = "00D671406B1FEBF3DEF7E6CF92D3F5A6")
    public void writeLine(final CharArrayBuffer s) throws IOException {
        {
            int off;
            off = 0;
            int remaining;
            remaining = s.length();
            {
                int chunk;
                chunk = this.buffer.capacity() - this.buffer.length();
                chunk = Math.min(chunk, remaining);
                {
                    this.buffer.append(s, off, chunk);
                } //End block
                {
                    boolean var72B6D6297B2C08F159A8216B46F72C87_634847598 = (this.buffer.isFull());
                    {
                        flushBuffer();
                    } //End block
                } //End collapsed parenthetic
                off += chunk;
                remaining -= chunk;
            } //End block
        } //End block
        {
            byte[] tmp;
            tmp = s.toString().getBytes(this.charset);
            write(tmp);
        } //End block
        write(CRLF);
        addTaint(s.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.761 -0400", hash_original_method = "E82E77AA369AC2B118042C614F644F5C", hash_generated_method = "CADD5DA8C125F8E4236D20157B82EA11")
    public HttpTransportMetrics getMetrics() {
        HttpTransportMetrics varB4EAC82CA7396A68D541C85D26508E83_125125839 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_125125839 = this.metrics;
        varB4EAC82CA7396A68D541C85D26508E83_125125839.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_125125839;
        // ---------- Original Method ----------
        //return this.metrics;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.761 -0400", hash_original_field = "8614F8248A0F6083657CCFEDD01EB9E4", hash_generated_field = "8CE8D71E3FB4286D71FEF4136FB4703A")

    private static byte[] CRLF = new byte[] {HTTP.CR, HTTP.LF};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.762 -0400", hash_original_field = "E6A38D2FFE216A27CFB357463D05ED88", hash_generated_field = "A78F974EEF7DA53634C4718679B3817C")

    private static int MAX_CHUNK = 256;
}

