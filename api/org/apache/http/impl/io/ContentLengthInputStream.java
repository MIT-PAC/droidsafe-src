package org.apache.http.impl.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.io.SessionInputBuffer;




public class ContentLengthInputStream extends InputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.052 -0500", hash_original_field = "3FB102CF00D4B531C2E12F98A5BDDBFE", hash_generated_field = "62F0934D18D3617E6D093F1927E1FC4F")

    
    private static final int BUFFER_SIZE = 2048;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.055 -0500", hash_original_field = "1E697977C6954C6B938DDD0BFFFD6A14", hash_generated_field = "0235B86EE2D19DB7BC14B5867FCABFC4")

    private long contentLength;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.057 -0500", hash_original_field = "20E65178D546E6F052E77AAADF12715C", hash_generated_field = "337E67B29A254DB50F39D690161DCA16")

    private long pos = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.059 -0500", hash_original_field = "3AA5C7F0C9D40E3C1B48B8404423A098", hash_generated_field = "AA98B16E301073717D23E903C6D6286D")

    private boolean closed = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.061 -0500", hash_original_field = "A0D9CFA505D29A6EA61BB948ED1C1C77", hash_generated_field = "12C364DD3F2CEF8D8A2DC449FD12693B")

    private SessionInputBuffer in = null;

    /**
     * Creates a new length limited stream
     *
     * @param in The session input buffer to wrap
     * @param contentLength The maximum number of bytes that can be read from
     * the stream. Subsequent read operations will return -1.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.064 -0500", hash_original_method = "EB9A16D491B02E1C854609CD55105FA5", hash_generated_method = "9BDB328CC2AE86523BBEAC346BA93185")
    
public ContentLengthInputStream(final SessionInputBuffer in, long contentLength) {
        super();
        if (in == null) {
            throw new IllegalArgumentException("Input stream may not be null");
        }
        if (contentLength < 0) {
            throw new IllegalArgumentException("Content length may not be negative");
        }
        this.in = in;
        this.contentLength = contentLength;
    }

    /**
     * <p>Reads until the end of the known length of content.</p>
     *
     * <p>Does not close the underlying socket input, but instead leaves it
     * primed to parse the next response.</p>
     * @throws IOException If an IO problem occurs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.066 -0500", hash_original_method = "37495B10D833FDE07627744A97E6F360", hash_generated_method = "1C9A247DEF15CC56BBB62F24F77B8BB7")
    
public void close() throws IOException {
        if (!closed) {
            try {
                byte buffer[] = new byte[BUFFER_SIZE];
                while (read(buffer) >= 0) {
                }
            } finally {
                // close after above so that we don't throw an exception trying
                // to read after closed!
                closed = true;
            }
        }
    }


    /**
     * Read the next byte from the stream
     * @return The next byte or -1 if the end of stream has been reached.
     * @throws IOException If an IO problem occurs
     * @see java.io.InputStream#read()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.068 -0500", hash_original_method = "829D665E9575B14A2545A678B846DF03", hash_generated_method = "3D2C22A6B1859C1BF80A90876F79B416")
    
public int read() throws IOException {
        if (closed) {
            throw new IOException("Attempted read from closed stream.");
        }

        if (pos >= contentLength) {
            return -1;
        }
        pos++;
        return this.in.read();
    }

    /**
     * Does standard {@link InputStream#read(byte[], int, int)} behavior, but
     * also notifies the watcher when the contents have been consumed.
     *
     * @param b     The byte array to fill.
     * @param off   Start filling at this position.
     * @param len   The number of bytes to attempt to read.
     * @return The number of bytes read, or -1 if the end of content has been
     *  reached.
     *
     * @throws java.io.IOException Should an error occur on the wrapped stream.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.071 -0500", hash_original_method = "7953751167B17924FE4F5EE632E22C6C", hash_generated_method = "87F145D42A3BB632F9457934C2B1F5C7")
    
public int read (byte[] b, int off, int len) throws java.io.IOException {
        if (closed) {
            throw new IOException("Attempted read from closed stream.");
        }

        if (pos >= contentLength) {
            return -1;
        }

        if (pos + len > contentLength) {
            len = (int) (contentLength - pos);
        }
        int count = this.in.read(b, off, len);
        pos += count;
        return count;
    }


    /**
     * Read more bytes from the stream.
     * @param b The byte array to put the new data in.
     * @return The number of bytes read into the buffer.
     * @throws IOException If an IO problem occurs
     * @see java.io.InputStream#read(byte[])
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.073 -0500", hash_original_method = "03121A7AC3B4E7519E88953F37DA485C", hash_generated_method = "E0F9C5B343EA0376178403393DBFABB2")
    
public int read(byte[] b) throws IOException {
        return read(b, 0, b.length);
    }

    /**
     * Skips and discards a number of bytes from the input stream.
     * @param n The number of bytes to skip.
     * @return The actual number of bytes skipped. <= 0 if no bytes
     * are skipped.
     * @throws IOException If an error occurs while skipping bytes.
     * @see InputStream#skip(long)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.076 -0500", hash_original_method = "F403C2DD7869661F9202FB887EC75E9B", hash_generated_method = "C71F29B723820B743949EE2ADEE8C074")
    
public long skip(long n) throws IOException {
        if (n <= 0) {
            return 0;
        }
        byte[] buffer = new byte[BUFFER_SIZE];
        // make sure we don't skip more bytes than are 
        // still available
        long remaining = Math.min(n, this.contentLength - this.pos); 
        // skip and keep track of the bytes actually skipped
        long count = 0;
        while (remaining > 0) {
            int l = read(buffer, 0, (int)Math.min(BUFFER_SIZE, remaining));
            if (l == -1) {
                break;
            }
            count += l;
            remaining -= l;
        }
        this.pos += count;
        return count;
    }
}

