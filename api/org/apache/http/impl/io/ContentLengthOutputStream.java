package org.apache.http.impl.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.http.io.SessionOutputBuffer;

public class ContentLengthOutputStream extends OutputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.321 -0500", hash_original_field = "862CD4E306AB155A980F18A7EE0A0BF8", hash_generated_field = "77BC14A656F9BA385AF4199F8E7C3C1D")

    private  SessionOutputBuffer out;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.324 -0500", hash_original_field = "1E697977C6954C6B938DDD0BFFFD6A14", hash_generated_field = "0235B86EE2D19DB7BC14B5867FCABFC4")

    private  long contentLength;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.327 -0500", hash_original_field = "D6E3A85E538AE40DB2B52595F75A374B", hash_generated_field = "4C6BD53EE3E09B37B86F24B0D970D840")

    private long total = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.329 -0500", hash_original_field = "3AA5C7F0C9D40E3C1B48B8404423A098", hash_generated_field = "AA98B16E301073717D23E903C6D6286D")

    private boolean closed = false;

    /**
     * Creates a new length limited stream
     *
     * @param out The data transmitter to wrap
     * @param contentLength The maximum number of bytes that can be written to
     * the stream. Subsequent write operations will be ignored.
     * 
     * @since 4.0
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.331 -0500", hash_original_method = "CBDB2FDC82C5AFE44AFBC6A393E7627D", hash_generated_method = "ADFE4528856650CE0B7FC18515D9291E")
    
public ContentLengthOutputStream(final SessionOutputBuffer out, long contentLength) {
        super();
        if (out == null) {
            throw new IllegalArgumentException("Session output buffer may not be null");
        }
        if (contentLength < 0) {
            throw new IllegalArgumentException("Content length may not be negative");
        }
        this.out = out;
        this.contentLength = contentLength;
    }

    /**
     * <p>Does not close the underlying socket output.</p>
     * 
     * @throws IOException If an I/O problem occurs.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.334 -0500", hash_original_method = "5088685B92B0533111B1789635B9B452", hash_generated_method = "26BE9D5EBA83E15A05E65873FF8E9852")
    
public void close() throws IOException {
        if (!this.closed) {
            this.closed = true;
            this.out.flush();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.336 -0500", hash_original_method = "A5A452E28D931563D6707491621FFBE7", hash_generated_method = "69E9959092BAC6291CF23078F47E18CD")
    
public void flush() throws IOException {
        this.out.flush();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.338 -0500", hash_original_method = "C2CCC6E8489DACB9C9AD7F8549C28D94", hash_generated_method = "E50355F5905203E5B300ADD2F7C08070")
    
public void write(byte[] b, int off, int len) throws IOException {
        if (this.closed) {
            throw new IOException("Attempted write to closed stream.");
        }
        if (this.total < this.contentLength) {
            long max = this.contentLength - this.total;
            if (len > max) {
                len = (int) max;
            }
            this.out.write(b, off, len);
            this.total += len;
        }
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.340 -0500", hash_original_method = "E1D4EA7BC5A1A039095C078064FA6BD5", hash_generated_method = "571732832533DA058E04BC8F76720194")
    
public void write(byte[] b) throws IOException {
        write(b, 0, b.length);
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSink(DSSinkKind.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.343 -0500", hash_original_method = "671E4413F0815DA1A7C3D0AAECD8B1E8", hash_generated_method = "54F2DB86A0AF3DDF4E6101BDDBD1BEE4")
    
public void write(int b) throws IOException {
        if (this.closed) {
            throw new IOException("Attempted write to closed stream.");
        }
        if (this.total < this.contentLength) {
            this.out.write(b);
            this.total++;
        }
    }
    
}

