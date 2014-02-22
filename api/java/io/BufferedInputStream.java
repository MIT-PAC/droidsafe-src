package java.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Arrays;

public class BufferedInputStream extends FilterInputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.139 -0500", hash_original_field = "001DD3820C6A6A544AB42831C6F17A05", hash_generated_field = "C53666C61D704ACE793D3D98401D06E0")

    protected volatile byte[] buf;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.141 -0500", hash_original_field = "B83BF7ED7F5719DA923E1BC0AC69952B", hash_generated_field = "CADFF8C1F208C99E14B28CFC1A04442F")

    protected int count;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.144 -0500", hash_original_field = "A7BDBB7BB14DDDE2FA2BAB4A41062BFB", hash_generated_field = "187237640B843AF018F2A924787F8CE1")

    protected int marklimit;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.146 -0500", hash_original_field = "AA082170A07E47DD757AA0D276241BD9", hash_generated_field = "584BEF84693439016482B6900153EC57")

    protected int markpos = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.148 -0500", hash_original_field = "5780BC7BCF265A6425A5A90F1AD9B24E", hash_generated_field = "3039C52FCC40405280C80DE756778CBF")

    protected int pos;

    /**
     * Constructs a new {@code BufferedInputStream}, providing {@code in} with a buffer
     * of 8192 bytes.
     *
     * <p><strong>Warning:</strong> passing a null source creates a closed
     * {@code BufferedInputStream}. All read operations on such a stream will
     * fail with an IOException.
     *
     * @param in the {@code InputStream} the buffer reads from.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.150 -0500", hash_original_method = "21B504722C790213175AE0F5E25EEBB8", hash_generated_method = "372D73774F2BD015B118B47B81AE2714")
    
public BufferedInputStream(InputStream in) {
        this(in, 8192);
    }

    /**
     * Constructs a new {@code BufferedInputStream}, providing {@code in} with {@code size} bytes
     * of buffer.
     *
     * <p><strong>Warning:</strong> passing a null source creates a closed
     * {@code BufferedInputStream}. All read operations on such a stream will
     * fail with an IOException.
     *
     * @param in the {@code InputStream} the buffer reads from.
     * @param size the size of buffer in bytes.
     * @throws IllegalArgumentException if {@code size <= 0}.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.153 -0500", hash_original_method = "4F467422085302825BDB985C2FDC72F9", hash_generated_method = "E76DA12E1EAECD7C410B08708D171821")
    
public BufferedInputStream(InputStream in, int size) {
        super(in);
        if (size <= 0) {
            throw new IllegalArgumentException("size <= 0");
        }
        buf = new byte[size];
    }

    /**
     * Returns an estimated number of bytes that can be read or skipped without blocking for more
     * input. This method returns the number of bytes available in the buffer
     * plus those available in the source stream, but see {@link InputStream#available} for
     * important caveats.
     *
     * @return the estimated number of bytes available
     * @throws IOException if this stream is closed or an error occurs
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.156 -0500", hash_original_method = "07FFB00D7B3DCD194F29893BBF5B52EB", hash_generated_method = "E702B54EC9B1A3179D95C3F8C922A986")
    
@Override
    public synchronized int available() throws IOException {
        InputStream localIn = in; // 'in' could be invalidated by close()
        if (buf == null || localIn == null) {
            throw streamClosed();
        }
        return count - pos + localIn.available();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.159 -0500", hash_original_method = "4D8013C45FC6B1A765F1F6C3AB84963B", hash_generated_method = "492C714F78E5F2332BAF645DCF0D7765")
    
private IOException streamClosed() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    /**
     * Closes this stream. The source stream is closed and any resources
     * associated with it are released.
     *
     * @throws IOException
     *             if an error occurs while closing this stream.
     */
    @DSComment("not sensitive")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.162 -0500", hash_original_method = "9458B5514F81355F9A651152E456CAE7", hash_generated_method = "98FD5980451359CE86D0EDE2C1BE1722")
    
@Override
    public void close() throws IOException {
        buf = null;
        InputStream localIn = in;
        in = null;
        if (localIn != null) {
            localIn.close();
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.165 -0500", hash_original_method = "763578223906D5382275DB1FE1B265CB", hash_generated_method = "1E32DD52A6A22E317CE9B897937C2FA6")
    
private int fillbuf(InputStream localIn, byte[] localBuf)
            throws IOException {
        if (markpos == -1 || (pos - markpos >= marklimit)) {
            /* Mark position not set or exceeded readlimit */
            int result = localIn.read(localBuf);
            if (result > 0) {
                markpos = -1;
                pos = 0;
                count = result == -1 ? 0 : result;
            }
            return result;
        }
        if (markpos == 0 && marklimit > localBuf.length) {
            /* Increase buffer size to accommodate the readlimit */
            int newLength = localBuf.length * 2;
            if (newLength > marklimit) {
                newLength = marklimit;
            }
            byte[] newbuf = new byte[newLength];
            System.arraycopy(localBuf, 0, newbuf, 0, localBuf.length);
            // Reassign buf, which will invalidate any local references
            // FIXME: what if buf was null?
            localBuf = buf = newbuf;
        } else if (markpos > 0) {
            System.arraycopy(localBuf, markpos, localBuf, 0, localBuf.length
                    - markpos);
        }
        /* Set the new position and mark position */
        pos -= markpos;
        count = markpos = 0;
        int bytesread = localIn.read(localBuf, pos, localBuf.length - pos);
        count = bytesread <= 0 ? pos : pos + bytesread;
        return bytesread;
    }

    /**
     * Sets a mark position in this stream. The parameter {@code readlimit}
     * indicates how many bytes can be read before a mark is invalidated.
     * Calling {@code reset()} will reposition the stream back to the marked
     * position if {@code readlimit} has not been surpassed. The underlying
     * buffer may be increased in size to allow {@code readlimit} number of
     * bytes to be supported.
     *
     * @param readlimit
     *            the number of bytes that can be read before the mark is
     *            invalidated.
     * @see #reset()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.168 -0500", hash_original_method = "DF417F804FB76ED4D7DE805338DD287E", hash_generated_method = "6C8AA12DBDC90F730C598DE59714D576")
    
@Override
    public synchronized void mark(int readlimit) {
        marklimit = readlimit;
        markpos = pos;
    }

    /**
     * Indicates whether {@code BufferedInputStream} supports the {@code mark()}
     * and {@code reset()} methods.
     *
     * @return {@code true} for BufferedInputStreams.
     * @see #mark(int)
     * @see #reset()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.170 -0500", hash_original_method = "3448BF342B33B519FE64A3FA0274077D", hash_generated_method = "8651EC098CD56FF2A595F29537142CD3")
    
@Override
    public boolean markSupported() {
        return true;
    }

    /**
     * Reads a single byte from this stream and returns it as an integer in the
     * range from 0 to 255. Returns -1 if the end of the source string has been
     * reached. If the internal buffer does not contain any available bytes then
     * it is filled from the source stream and the first byte is returned.
     *
     * @return the byte read or -1 if the end of the source stream has been
     *         reached.
     * @throws IOException
     *             if this stream is closed or another IOException occurs.
     */
    @DSComment("Activity on IO class")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.173 -0500", hash_original_method = "44D2E1EC0EF3B53AC5594D464D2C83B9", hash_generated_method = "6A4474C98316806C704D1FF867C7D064")
    
@Override
    public synchronized int read() throws IOException {
        // Use local refs since buf and in may be invalidated by an
        // unsynchronized close()
        byte[] localBuf = buf;
        InputStream localIn = in;
        if (localBuf == null || localIn == null) {
            throw streamClosed();
        }

        /* Are there buffered bytes available? */
        if (pos >= count && fillbuf(localIn, localBuf) == -1) {
            return -1; /* no, fill buffer */
        }
        // localBuf may have been invalidated by fillbuf
        if (localBuf != buf) {
            localBuf = buf;
            if (localBuf == null) {
                throw streamClosed();
            }
        }

        /* Did filling the buffer fail with -1 (EOF)? */
        if (count - pos > 0) {
            return localBuf[pos++] & 0xFF;
        }
        return -1;
    }

    /**
     * Reads at most {@code byteCount} bytes from this stream and stores them in
     * byte array {@code buffer} starting at offset {@code offset}. Returns the
     * number of bytes actually read or -1 if no bytes were read and the end of
     * the stream was encountered. If all the buffered bytes have been used, a
     * mark has not been set and the requested number of bytes is larger than
     * the receiver's buffer size, this implementation bypasses the buffer and
     * simply places the results directly into {@code buffer}.
     *
     * @param buffer
     *            the byte array in which to store the bytes read.
     * @return the number of bytes actually read or -1 if end of stream.
     * @throws IndexOutOfBoundsException
     *             if {@code offset < 0} or {@code byteCount < 0}, or if
     *             {@code offset + byteCount} is greater than the size of
     *             {@code buffer}.
     * @throws IOException
     *             if the stream is already closed or another IOException
     *             occurs.
     */
    @DSComment("Activity on IO class")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.177 -0500", hash_original_method = "61DEF23C4EC5BF0BA1725AB1A56B4C17", hash_generated_method = "0D02395DDFF6896AF352C79259C47479")
    
@Override
    public synchronized int read(byte[] buffer, int offset, int byteCount) throws IOException {
        // Use local ref since buf may be invalidated by an unsynchronized
        // close()
        byte[] localBuf = buf;
        if (localBuf == null) {
            throw streamClosed();
        }
        Arrays.checkOffsetAndCount(buffer.length, offset, byteCount);
        if (byteCount == 0) {
            return 0;
        }
        InputStream localIn = in;
        if (localIn == null) {
            throw streamClosed();
        }

        int required;
        if (pos < count) {
            /* There are bytes available in the buffer. */
            int copylength = count - pos >= byteCount ? byteCount : count - pos;
            System.arraycopy(localBuf, pos, buffer, offset, copylength);
            pos += copylength;
            if (copylength == byteCount || localIn.available() == 0) {
                return copylength;
            }
            offset += copylength;
            required = byteCount - copylength;
        } else {
            required = byteCount;
        }

        while (true) {
            int read;
            /*
             * If we're not marked and the required size is greater than the
             * buffer, simply read the bytes directly bypassing the buffer.
             */
            if (markpos == -1 && required >= localBuf.length) {
                read = localIn.read(buffer, offset, required);
                if (read == -1) {
                    return required == byteCount ? -1 : byteCount - required;
                }
            } else {
                if (fillbuf(localIn, localBuf) == -1) {
                    return required == byteCount ? -1 : byteCount - required;
                }
                // localBuf may have been invalidated by fillbuf
                if (localBuf != buf) {
                    localBuf = buf;
                    if (localBuf == null) {
                        throw streamClosed();
                    }
                }

                read = count - pos >= required ? required : count - pos;
                System.arraycopy(localBuf, pos, buffer, offset, read);
                pos += read;
            }
            required -= read;
            if (required == 0) {
                return byteCount;
            }
            if (localIn.available() == 0) {
                return byteCount - required;
            }
            offset += read;
        }
    }

    /**
     * Resets this stream to the last marked location.
     *
     * @throws IOException
     *             if this stream is closed, no mark has been set or the mark is
     *             no longer valid because more than {@code readlimit} bytes
     *             have been read since setting the mark.
     * @see #mark(int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.180 -0500", hash_original_method = "0EB3739ECCD523AAEBB3A3F64D0A35BC", hash_generated_method = "CE8767DA2D459643F76527EFC21F6D25")
    
@Override
    public synchronized void reset() throws IOException {
        if (buf == null) {
            throw new IOException("Stream is closed");
        }
        if (-1 == markpos) {
            throw new IOException("Mark has been invalidated.");
        }
        pos = markpos;
    }

    /**
     * Skips {@code byteCount} bytes in this stream. Subsequent calls to
     * {@code read} will not return these bytes unless {@code reset} is
     * used.
     *
     * @param byteCount
     *            the number of bytes to skip. {@code skip} does nothing and
     *            returns 0 if {@code byteCount} is less than zero.
     * @return the number of bytes actually skipped.
     * @throws IOException
     *             if this stream is closed or another IOException occurs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.183 -0500", hash_original_method = "61D210443DD8F238003AAFD35E7B7777", hash_generated_method = "B07EB192285C854B260DCBADFA71F959")
    
@Override
    public synchronized long skip(long byteCount) throws IOException {
        // Use local refs since buf and in may be invalidated by an
        // unsynchronized close()
        byte[] localBuf = buf;
        InputStream localIn = in;
        if (localBuf == null) {
            throw streamClosed();
        }
        if (byteCount < 1) {
            return 0;
        }
        if (localIn == null) {
            throw streamClosed();
        }

        if (count - pos >= byteCount) {
            pos += byteCount;
            return byteCount;
        }
        long read = count - pos;
        pos = count;

        if (markpos != -1) {
            if (byteCount <= marklimit) {
                if (fillbuf(localIn, localBuf) == -1) {
                    return read;
                }
                if (count - pos >= byteCount - read) {
                    pos += byteCount - read;
                    return byteCount;
                }
                // Couldn't get all the bytes, skip what we read
                read += (count - pos);
                pos = count;
                return read;
            }
        }
        return read + localIn.skip(byteCount - read);
    }
    
}

