package java.util.zip;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;

import libcore.io.Streams;

public class CheckedInputStream extends java.io.FilterInputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.612 -0500", hash_original_field = "4AE29764ABB14C73F8209F7640A7CC1D", hash_generated_field = "17891C0CAF0BD7DDA9A721E3165E41B4")

    private  Checksum check;

    /**
     * Constructs a new {@code CheckedInputStream} on {@code InputStream}
     * {@code is}. The checksum will be calculated using the algorithm
     * implemented by {@code csum}.
     *
     * <p><strong>Warning:</strong> passing a null source creates an invalid
     * {@code CheckedInputStream}. All operations on such a stream will fail.
     *
     * @param is
     *            the input stream to calculate checksum from.
     * @param csum
     *            an entity implementing the checksum algorithm.
     */
    @DSComment("IO/Stream accessing")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.615 -0500", hash_original_method = "7E1EA825FE47CC59E068EE04C6081636", hash_generated_method = "D6F3C69C6C1E49B6A76D5C3044EBA8A4")
    
public CheckedInputStream(InputStream is, Checksum csum) {
        super(is);
        check = csum;
    }

    /**
     * Reads one byte of data from the underlying input stream and updates the
     * checksum with the byte data.
     *
     * @return {@code -1} at the end of the stream, a single byte value
     *         otherwise.
     * @throws IOException
     *             if an {@code IOException} occurs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.618 -0500", hash_original_method = "4C16D1761C9EE9C5267A2DEA3E7C4510", hash_generated_method = "85B82615DADE129198492E31080E9E81")
    
@Override
    public int read() throws IOException {
        int x = in.read();
        if (x != -1) {
            check.update(x);
        }
        return x;
    }

    /**
     * Reads up to n bytes of data from the underlying input stream, storing it
     * into {@code buf}, starting at offset {@code off}. The checksum is
     * updated with the bytes read.
     *
     * @param buf
     *            the byte array in which to store the bytes read.
     * @param off
     *            the initial position in {@code buf} to store the bytes read
     *            from this stream.
     * @param nbytes
     *            the maximum number of bytes to store in {@code buf}.
     * @return the number of bytes actually read or {@code -1} if arrived at the
     *         end of the filtered stream while reading the data.
     * @throws IOException
     *             if this stream is closed or some I/O error occurs.
     */
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.621 -0500", hash_original_method = "7EEC56472DB745F24C7F951D18194473", hash_generated_method = "822145D2C7EF4E7B86931B5DEF72125A")
    
@Override
    public int read(byte[] buf, int off, int nbytes) throws IOException {
        int x = in.read(buf, off, nbytes);
        if (x != -1) {
            check.update(buf, off, x);
        }
        return x;
    }

    /**
     * Returns the checksum calculated on the stream read so far.
     *
     * @return the updated checksum.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.623 -0500", hash_original_method = "8D60BCB1BD17D4099BEB55CEF28E25BB", hash_generated_method = "ACB993D8534E9018B97946C2173993C4")
    
public Checksum getChecksum() {
        return check;
    }

    /**
     * Skip up to {@code byteCount} bytes of data on the underlying input
     * stream. Any skipped bytes are added to the running checksum value.
     *
     * @param byteCount the number of bytes to skip.
     * @throws IOException if this stream is closed or another I/O error occurs.
     * @return the number of bytes skipped.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.626 -0500", hash_original_method = "B0B2C5ABB0F3ADBF684B825EB14D5721", hash_generated_method = "FA64348A96D1C68BD0600E70DFA81D7E")
    
@Override
    public long skip(long byteCount) throws IOException {
        return Streams.skipByReading(this, byteCount);
    }
    
}

