package org.apache.http.impl.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.io.HttpTransportMetrics;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.ByteArrayBuffer;
import org.apache.http.util.CharArrayBuffer;

public abstract class AbstractSessionInputBuffer implements SessionInputBuffer {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.869 -0500", hash_original_field = "ABC191480B217CDD4C9CD0F134BDA16A", hash_generated_field = "9B0F52B8C31A449A2E624B8847C753E5")

    private InputStream instream;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.871 -0500", hash_original_field = "3923F3F9F9ECABE8D28493E863FC2CD8", hash_generated_field = "67DBC7965A32AEE1CAB7B25294021930")

    private byte[] buffer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.874 -0500", hash_original_field = "6FC598A647354F760F2F8BB0322356D2", hash_generated_field = "C38A316D53C22723B1202376C6917B3F")

    private int bufferpos;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.876 -0500", hash_original_field = "F0DAC33E5FDB372FDA0EBE49D4845023", hash_generated_field = "296206540354C2045FC39BBE1B298B67")

    private int bufferlen;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.878 -0500", hash_original_field = "5BE7446BA22AC876A96460A896625418", hash_generated_field = "0CC6340E9144F7E622BCBFBE8F5F5CB5")
    
    private ByteArrayBuffer linebuffer = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.880 -0500", hash_original_field = "64A133D796EAE83898A5E51E6D434FEF", hash_generated_field = "76BAEB11C3552BFB23E0B4B99A533DB1")
    
    private String charset = HTTP.US_ASCII;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.882 -0500", hash_original_field = "1268E551E2D06835242E1DD85742F5B8", hash_generated_field = "9303ABFC1EF5CEEB446DE036D38A5721")

    private boolean ascii = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.884 -0500", hash_original_field = "BE354D9B1A47BDE141DFF8CC6162BD1F", hash_generated_field = "5CA0E4EE0481DA70634C383CF4BE2DA3")

    private int maxLineLen = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.886 -0500", hash_original_field = "80498DD6FD825DCA7A9A3D886278D44D", hash_generated_field = "D608E8E883C0ADFB9BB241D869189B8C")
    
    private HttpTransportMetricsImpl metrics;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.425 -0400", hash_original_method = "C27F370149363385AD6F9F81753F4445", hash_generated_method = "C27F370149363385AD6F9F81753F4445")
    public AbstractSessionInputBuffer ()
    {
        //Synthesized constructor
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.889 -0500", hash_original_method = "9ACC7C380ECF9A2AF3368BF4FBEC1DC4", hash_generated_method = "A98B506E3A6A0E5A355AEEC2A1AABFE7")
    
protected void init(final InputStream instream, int buffersize, final HttpParams params) {
        if (instream == null) {
            throw new IllegalArgumentException("Input stream may not be null");
        }
        if (buffersize <= 0) {
            throw new IllegalArgumentException("Buffer size may not be negative or zero");
        }
        if (params == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        this.instream = instream;
        this.buffer = new byte[buffersize];
        this.bufferpos = 0;
        this.bufferlen = 0;
        this.linebuffer = new ByteArrayBuffer(buffersize);
        this.charset = HttpProtocolParams.getHttpElementCharset(params);
        this.ascii = this.charset.equalsIgnoreCase(HTTP.US_ASCII)
                     || this.charset.equalsIgnoreCase(HTTP.ASCII);
        this.maxLineLen = params.getIntParameter(CoreConnectionPNames.MAX_LINE_LENGTH, -1);
        this.metrics = new HttpTransportMetricsImpl();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.892 -0500", hash_original_method = "AED6430DDF1A78B7022960A54C9608D3", hash_generated_method = "68397E390F56A405E218CA166981FBED")
    
protected int fillBuffer() throws IOException {
        // compact the buffer if necessary
        if (this.bufferpos > 0) {
            int len = this.bufferlen - this.bufferpos;
            if (len > 0) {
                System.arraycopy(this.buffer, this.bufferpos, this.buffer, 0, len);
            }
            this.bufferpos = 0;
            this.bufferlen = len;
        }
        int l;
        int off = this.bufferlen;
        int len = this.buffer.length - off;
        l = this.instream.read(this.buffer, off, len);
        if (l == -1) {
            return -1;
        } else {
            this.bufferlen = off + l;
            this.metrics.incrementBytesTransferred(l);
            return l;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.894 -0500", hash_original_method = "BAC6DE94AA32B94037307F5D6F9840B7", hash_generated_method = "ACDB991EEA141DA6CA2ADAE5BAE29080")
    
protected boolean hasBufferedData() {
        return this.bufferpos < this.bufferlen;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.896 -0500", hash_original_method = "E463AA34023422AC03B9513A2E94EA6B", hash_generated_method = "79158ACBC78EDD88DA804BD2D86B1896")
    
public int read() throws IOException {
        int noRead = 0;
        while (!hasBufferedData()) {
            noRead = fillBuffer();
            if (noRead == -1) {
                return -1;
            }
        }
        return this.buffer[this.bufferpos++] & 0xff;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.899 -0500", hash_original_method = "5A83C8A4FAF4774EC1C7C0472F5C75E8", hash_generated_method = "AE3B2612162B0746C7402D15D9277CEA")
    
public int read(final byte[] b, int off, int len) throws IOException {
        if (b == null) {
            return 0;
        }
        int noRead = 0;
        while (!hasBufferedData()) {
            noRead = fillBuffer();
            if (noRead == -1) {
                return -1;
            }
        }
        int chunk = this.bufferlen - this.bufferpos;
        if (chunk > len) {
            chunk = len;
        }
        System.arraycopy(this.buffer, this.bufferpos, b, off, chunk);
        this.bufferpos += chunk;
        return chunk;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.901 -0500", hash_original_method = "EA19DAA67F217B43FC33D4721E7544D2", hash_generated_method = "9224D19C7439FFD899D862EA4DD6D57E")
    
public int read(final byte[] b) throws IOException {
        if (b == null) {
            return 0;
        }
        return read(b, 0, b.length);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.903 -0500", hash_original_method = "25E4831B40662E7C69D1371A042407AC", hash_generated_method = "46B003EDF5AB4CB2C6B031CA7531D9F7")
    
private int locateLF() {
        for (int i = this.bufferpos; i < this.bufferlen; i++) {
            if (this.buffer[i] == HTTP.LF) {
                return i;
            }
        }
        return -1;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.907 -0500", hash_original_method = "473C0DD8FF067FE4EC2BE597B4124765", hash_generated_method = "F7E7E8908354648A0E9C6E0CA26E4104")
    
public int readLine(final CharArrayBuffer charbuffer) throws IOException {
        if (charbuffer == null) {
            throw new IllegalArgumentException("Char array buffer may not be null");
        }
        this.linebuffer.clear();
        int noRead = 0;
        boolean retry = true;
        while (retry) {
            // attempt to find end of line (LF)
            int i = locateLF();
            if (i != -1) {
                // end of line found. 
                if (this.linebuffer.isEmpty()) {
                    // the entire line is preset in the read buffer
                    return lineFromReadBuffer(charbuffer, i);
                }
                retry = false;
                int len = i + 1 - this.bufferpos;
                this.linebuffer.append(this.buffer, this.bufferpos, len);
                this.bufferpos = i + 1;
            } else {
                // end of line not found
                if (hasBufferedData()) {
                    int len = this.bufferlen - this.bufferpos;
                    this.linebuffer.append(this.buffer, this.bufferpos, len);
                    this.bufferpos = this.bufferlen;
                }
                noRead = fillBuffer();
                if (noRead == -1) {
                    retry = false;
                }
            }
            if (this.maxLineLen > 0 && this.linebuffer.length() >= this.maxLineLen) {
                throw new IOException("Maximum line length limit exceeded");
            }
        }
        if (noRead == -1 && this.linebuffer.isEmpty()) {
            // indicate the end of stream
            return -1;
        }
        return lineFromLineBuffer(charbuffer);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.910 -0500", hash_original_method = "729842E116E7795B9747338D0779180E", hash_generated_method = "710AACF457A8E18BE9BB0E6D99B7D6C3")
    
private int lineFromLineBuffer(final CharArrayBuffer charbuffer) 
            throws IOException {
        // discard LF if found
        int l = this.linebuffer.length(); 
        if (l > 0) {
            if (this.linebuffer.byteAt(l - 1) == HTTP.LF) {
                l--;
                this.linebuffer.setLength(l);
            }
            // discard CR if found
            if (l > 0) {
                if (this.linebuffer.byteAt(l - 1) == HTTP.CR) {
                    l--;
                    this.linebuffer.setLength(l);
                }
            }
        }
        l = this.linebuffer.length(); 
        if (this.ascii) {
            charbuffer.append(this.linebuffer, 0, l);
        } else {
            // This is VERY memory inefficient, BUT since non-ASCII charsets are 
            // NOT meant to be used anyway, there's no point optimizing it
            String s = new String(this.linebuffer.buffer(), 0, l, this.charset);
            charbuffer.append(s);
        }
        return l;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.912 -0500", hash_original_method = "E6FBFD5C83985C7D6E27D18B8C3822A9", hash_generated_method = "21EF0D9E357645AFEC672B40FB53250A")
    
private int lineFromReadBuffer(final CharArrayBuffer charbuffer, int pos) 
            throws IOException {
        int off = this.bufferpos;
        int len;
        this.bufferpos = pos + 1;
        // BEGIN android-changed
        // The first test below was fixed to not try to skip beyond the
        // start of the live part of the buffer.
        if (pos > off && this.buffer[pos - 1] == HTTP.CR) {
            // skip CR if found
            pos--;
        }
        // END android-changed
        len = pos - off;
        if (this.ascii) {
            charbuffer.append(this.buffer, off, len);
        } else {
            // This is VERY memory inefficient, BUT since non-ASCII charsets are 
            // NOT meant to be used anyway, there's no point optimizing it
            String s = new String(this.buffer, off, len, this.charset);
            charbuffer.append(s);
        }
        return len;
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.914 -0500", hash_original_method = "40CE76C5D842CFEF27650CABF8F97946", hash_generated_method = "D432802EC1C592DE7FCE122012E97D0E")
    
public String readLine() throws IOException {
        CharArrayBuffer charbuffer = new CharArrayBuffer(64);
        int l = readLine(charbuffer);
        if (l != -1) {
            return charbuffer.toString();
        } else {
            return null;
        }
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.916 -0500", hash_original_method = "E82E77AA369AC2B118042C614F644F5C", hash_generated_method = "0F09664C8D045EB8CE43D8B36FB12762")
    
public HttpTransportMetrics getMetrics() {
        return this.metrics;
    }
    
}

