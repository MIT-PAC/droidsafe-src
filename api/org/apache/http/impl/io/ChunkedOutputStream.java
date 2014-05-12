package org.apache.http.impl.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.http.io.SessionOutputBuffer;

public class ChunkedOutputStream extends OutputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.498 -0500", hash_original_field = "862CD4E306AB155A980F18A7EE0A0BF8", hash_generated_field = "77BC14A656F9BA385AF4199F8E7C3C1D")

    private  SessionOutputBuffer out;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.500 -0500", hash_original_field = "0C211D26B312EE2C89BEFF712202C7AE", hash_generated_field = "EBA08CF4C3E674FAE289C26AD80951B3")

    private byte[] cache;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.502 -0500", hash_original_field = "01F113117CDB8E17A401EB9369CF51E3", hash_generated_field = "8AF6C10D15ADA8AC990219FA73C4C6FF")

    private int cachePosition = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.504 -0500", hash_original_field = "862858CDE54366C6091E0A52DAD048AD", hash_generated_field = "079555C6CADEB50B1BB49A96B89EAB4C")

    private boolean wroteLastChunk = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.506 -0500", hash_original_field = "3AA5C7F0C9D40E3C1B48B8404423A098", hash_generated_field = "AA98B16E301073717D23E903C6D6286D")

    private boolean closed = false;
    
    // ----------------------------------------------------------- Constructors
    /**
     * Wraps a session output buffer and chunks the output.
     * @param out the session output buffer to wrap
     * @param bufferSize minimum chunk size (excluding last chunk)
     * @throws IOException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.509 -0500", hash_original_method = "56C47BEE54D84D2C2F06C5F3380F6FB5", hash_generated_method = "137823E306F1E3181E0323F27A60481E")
    
public ChunkedOutputStream(final SessionOutputBuffer out, int bufferSize)
            throws IOException {
        super();
        this.cache = new byte[bufferSize];
        this.out = out;
    }

    /**
     * Wraps a session output buffer and chunks the output. The default buffer 
     * size of 2048 was chosen because the chunk overhead is less than 0.5%
     *
     * @param out       the output buffer to wrap
     * @throws IOException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.512 -0500", hash_original_method = "0998BD1AC5B9537C7B2BFA3E832ED71A", hash_generated_method = "6AA1C1C41048396E244FE7724B12A914")
    
public ChunkedOutputStream(final SessionOutputBuffer out) 
            throws IOException {
        this(out, 2048);
    }

    // ----------------------------------------------------------- Internal methods
    /**
     * Writes the cache out onto the underlying stream
     * @throws IOException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.514 -0500", hash_original_method = "320F140F8D57B27D338CDA0750999A03", hash_generated_method = "A536783168A45F38B4FBC5281CBB1B4D")
    
protected void flushCache() throws IOException {
        if (this.cachePosition > 0) {
            this.out.writeLine(Integer.toHexString(this.cachePosition));
            this.out.write(this.cache, 0, this.cachePosition);
            this.out.writeLine("");
            this.cachePosition = 0;
        }
    }

    /**
     * Writes the cache and bufferToAppend to the underlying stream
     * as one large chunk
     * @param bufferToAppend
     * @param off
     * @param len
     * @throws IOException
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.516 -0500", hash_original_method = "B6A1CB3240895E2E2F127D1796BCAECF", hash_generated_method = "A30ADD53DA444FC89EBE3A6591604ECF")
    
protected void flushCacheWithAppend(byte bufferToAppend[], int off, int len) throws IOException {
        this.out.writeLine(Integer.toHexString(this.cachePosition + len));
        this.out.write(this.cache, 0, this.cachePosition);
        this.out.write(bufferToAppend, off, len);
        this.out.writeLine("");
        this.cachePosition = 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.519 -0500", hash_original_method = "967E1BC0792D48B7189E3B566BF7EE9B", hash_generated_method = "209105C50080DF7926A1C563C970270B")
    
protected void writeClosingChunk() throws IOException {
        // Write the final chunk.
        this.out.writeLine("0");
        this.out.writeLine("");
    }

    // ----------------------------------------------------------- Public Methods
    /**
     * Must be called to ensure the internal cache is flushed and the closing chunk is written.
     * @throws IOException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.521 -0500", hash_original_method = "48C91C3E7A4F39D8E60BF0ABE327AC31", hash_generated_method = "30DC26F914220D71E7656F090C402658")
    
public void finish() throws IOException {
        if (!this.wroteLastChunk) {
            flushCache();
            writeClosingChunk();
            this.wroteLastChunk = true;
        }
    }

    // -------------------------------------------- OutputStream Methods
    @DSSink({DSSinkKind.IO})
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.523 -0500", hash_original_method = "97963AB3B21DB4797CA6C19C718B8A38", hash_generated_method = "CF1E450E6EB239C83DE93F69EFB91E68")
    
public void write(int b) throws IOException {
        if (this.closed) {
            throw new IOException("Attempted write to closed stream.");
        }
        this.cache[this.cachePosition] = (byte) b;
        this.cachePosition++;
        if (this.cachePosition == this.cache.length) flushCache();
    }

    /**
     * Writes the array. If the array does not fit within the buffer, it is
     * not split, but rather written out as one large chunk.
     * @param b
     * @throws IOException
     */
    @DSSpec(DSCat.IO)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.525 -0500", hash_original_method = "3A39FD94F4678FF92F02222292608085", hash_generated_method = "F6C81F6D58C1DBA8A32360C2D4037BF3")
    
public void write(byte b[]) throws IOException {
        write(b, 0, b.length);
    }

    @DSSink({DSSinkKind.IO})
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.527 -0500", hash_original_method = "CCAB33DDE1A6D08280EC0BE0610A6B79", hash_generated_method = "6B6F1E98A57891C1B4D1833806E6B11D")
    
public void write(byte src[], int off, int len) throws IOException {
        if (this.closed) {
            throw new IOException("Attempted write to closed stream.");
        }
        if (len >= this.cache.length - this.cachePosition) {
            flushCacheWithAppend(src, off, len);
        } else {
            System.arraycopy(src, off, cache, this.cachePosition, len);
            this.cachePosition += len;
        }
    }

    /**
     * Flushes the content buffer and the underlying stream.
     * @throws IOException
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.530 -0500", hash_original_method = "1D035E07BE479B8A909681E6BF90CFBD", hash_generated_method = "30EC794E829AE5A6C71E9027AA07F44F")
    
public void flush() throws IOException {
        flushCache();
        this.out.flush();
    }

    /**
     * Finishes writing to the underlying stream, but does NOT close the underlying stream.
     * @throws IOException
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.532 -0500", hash_original_method = "E495FD5BB343CF99481A29E811E92BD2", hash_generated_method = "0AF69A29991DEB492291E42E4EEA1909")
    
public void close() throws IOException {
        if (!this.closed) {
            this.closed = true;
            finish();
            this.out.flush();
        }
    }
    
}

