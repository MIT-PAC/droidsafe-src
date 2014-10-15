package java.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;

public class InputStreamReader extends Reader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.957 -0500", hash_original_field = "0A829BC26C36EAF422E245C1EC11D5B0", hash_generated_field = "9DA78E40E39AA56A72373CEA8B1326DF")

    private InputStream in;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.959 -0500", hash_original_field = "C9198FC6CD0651265F41AA62AD6A1F5C", hash_generated_field = "C1BD264EA71B8905202FEFE2EB6106E5")

    private boolean endOfInput = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.961 -0500", hash_original_field = "EB8B81788E764E7EC09C99438B975CD8", hash_generated_field = "E190C0DE068854E0E786DAC309DED1B8")

    private CharsetDecoder decoder;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.963 -0500", hash_original_field = "D75566C09E1648987D573E04AE908DE5", hash_generated_field = "C7ACDD8E59EDFE2B06C91B0B5639E9AE")

    private final ByteBuffer bytes = ByteBuffer.allocate(8192);

    /**
     * Constructs a new {@code InputStreamReader} on the {@link InputStream}
     * {@code in}. This constructor sets the character converter to the encoding
     * specified in the "file.encoding" property and falls back to ISO 8859_1
     * (ISO-Latin-1) if the property doesn't exist.
     *
     * @param in
     *            the input stream from which to read characters.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.966 -0500", hash_original_method = "3590A2EED02D10C52AB0172AD4BE22C4", hash_generated_method = "2BA25DDC3C17AC85E8604B7021C53C69")
    
public InputStreamReader(InputStream in) {
        this(in, Charset.defaultCharset());
    }

    /**
     * Constructs a new InputStreamReader on the InputStream {@code in}. The
     * character converter that is used to decode bytes into characters is
     * identified by name by {@code enc}. If the encoding cannot be found, an
     * UnsupportedEncodingException error is thrown.
     *
     * @param in
     *            the InputStream from which to read characters.
     * @param enc
     *            identifies the character converter to use.
     * @throws NullPointerException
     *             if {@code enc} is {@code null}.
     * @throws UnsupportedEncodingException
     *             if the encoding specified by {@code enc} cannot be found.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.969 -0500", hash_original_method = "EBBB6FD529AC9BA283207DBA01D68764", hash_generated_method = "928B63F479963A3A8B7A87B65C786357")
    
public InputStreamReader(InputStream in, final String enc)
            throws UnsupportedEncodingException {
        super(in);
        if (enc == null) {
            throw new NullPointerException();
        }
        this.in = in;
        try {
            decoder = Charset.forName(enc).newDecoder().onMalformedInput(
                    CodingErrorAction.REPLACE).onUnmappableCharacter(
                    CodingErrorAction.REPLACE);
        } catch (IllegalArgumentException e) {
            throw (UnsupportedEncodingException)
                    new UnsupportedEncodingException(enc).initCause(e);
        }
        bytes.limit(0);
    }

    /**
     * Constructs a new InputStreamReader on the InputStream {@code in} and
     * CharsetDecoder {@code dec}.
     *
     * @param in
     *            the source InputStream from which to read characters.
     * @param dec
     *            the CharsetDecoder used by the character conversion.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.972 -0500", hash_original_method = "A7068E06FC6AB9497581BF79FF6884E3", hash_generated_method = "1CD6FFD5964E8F92B391E44B0726D407")
    
public InputStreamReader(InputStream in, CharsetDecoder dec) {
        super(in);
        dec.averageCharsPerByte();
        this.in = in;
        decoder = dec;
        bytes.limit(0);
    }

    /**
     * Constructs a new InputStreamReader on the InputStream {@code in} and
     * Charset {@code charset}.
     *
     * @param in
     *            the source InputStream from which to read characters.
     * @param charset
     *            the Charset that defines the character converter
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.975 -0500", hash_original_method = "F689BDB30C937E91D3C146F93A07A4B9", hash_generated_method = "25C9BE37F4F9559B696FB3861A4C24DF")
    
public InputStreamReader(InputStream in, Charset charset) {
        super(in);
        this.in = in;
        decoder = charset.newDecoder().onMalformedInput(
                CodingErrorAction.REPLACE).onUnmappableCharacter(
                CodingErrorAction.REPLACE);
        bytes.limit(0);
    }

    /**
     * Closes this reader. This implementation closes the source InputStream and
     * releases all local storage.
     *
     * @throws IOException
     *             if an error occurs attempting to close this reader.
     */
    @DSComment("InputStreamReader class")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.978 -0500", hash_original_method = "FE46DA5B445A82E67613621D1604074D", hash_generated_method = "64568DB66E5B89ACA9154E9C002982F9")
    
@Override
    public void close() throws IOException {
        synchronized (lock) {
            if (decoder != null) {
                decoder.reset();
            }
            decoder = null;
            if (in != null) {
                in.close();
                in = null;
            }
        }
    }

    /**
     * Returns the historical name of the encoding used by this writer to convert characters to
     * bytes, or null if this writer has been closed. Most callers should probably keep
     * track of the String or Charset they passed in; this method may not return the same
     * name.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.980 -0500", hash_original_method = "4B46B0B3D8C39E950459FB803D7FD65D", hash_generated_method = "1D58F563A49A07C6EFD3A0F1D5FF34D9")
    
public String getEncoding() {
        if (!isOpen()) {
            return null;
        }
        return HistoricalCharsetNames.get(decoder.charset());
    }

    /**
     * Reads a single character from this reader and returns it as an integer
     * with the two higher-order bytes set to 0. Returns -1 if the end of the
     * reader has been reached. The byte value is either obtained from
     * converting bytes in this reader's buffer or by first filling the buffer
     * from the source InputStream and then reading from the buffer.
     *
     * @return the character read or -1 if the end of the reader has been
     *         reached.
     * @throws IOException
     *             if this reader is closed or some other I/O error occurs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.983 -0500", hash_original_method = "42220754D208F7633D722D928E4FD163", hash_generated_method = "608AB390C1A12B16DEDCCA342E1016AE")
    @DSSpec(DSCat.IO) 
    @DSSource({DSSourceKind.IO})
@Override
    public int read() throws IOException {
        synchronized (lock) {
            if (!isOpen()) {
                throw new IOException("InputStreamReader is closed");
            }
            char[] buf = new char[1];
            return read(buf, 0, 1) != -1 ? buf[0] : -1;
        }
    }

    /**
     * Reads at most {@code length} characters from this reader and stores them
     * at position {@code offset} in the character array {@code buf}. Returns
     * the number of characters actually read or -1 if the end of the reader has
     * been reached. The bytes are either obtained from converting bytes in this
     * reader's buffer or by first filling the buffer from the source
     * InputStream and then reading from the buffer.
     *
     * @param buffer
     *            the array to store the characters read.
     * @param offset
     *            the initial position in {@code buf} to store the characters
     *            read from this reader.
     * @param length
     *            the maximum number of characters to read.
     * @return the number of characters read or -1 if the end of the reader has
     *         been reached.
     * @throws IndexOutOfBoundsException
     *             if {@code offset < 0} or {@code length < 0}, or if
     *             {@code offset + length} is greater than the length of
     *             {@code buf}.
     * @throws IOException
     *             if this reader is closed or some other I/O error occurs.
     */
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.987 -0500", hash_original_method = "610EEC39BC95175186F6D1B73FBDC240", hash_generated_method = "550A9EF91DBCD99AD901345976E441C5")
    
@Override
    public int read(char[] buffer, int offset, int length) throws IOException {
        synchronized (lock) {
            if (!isOpen()) {
                throw new IOException("InputStreamReader is closed");
            }

            Arrays.checkOffsetAndCount(buffer.length, offset, length);
            if (length == 0) {
                return 0;
            }

            CharBuffer out = CharBuffer.wrap(buffer, offset, length);
            CoderResult result = CoderResult.UNDERFLOW;

            // bytes.remaining() indicates number of bytes in buffer
            // when 1-st time entered, it'll be equal to zero
            boolean needInput = !bytes.hasRemaining();

            while (out.hasRemaining()) {
                // fill the buffer if needed
                if (needInput) {
                    try {
                        if (in.available() == 0 && out.position() > offset) {
                            // we could return the result without blocking read
                            break;
                        }
                    } catch (IOException e) {
                        // available didn't work so just try the read
                    }

                    int desiredByteCount = bytes.capacity() - bytes.limit();
                    int off = bytes.arrayOffset() + bytes.limit();
                    int actualByteCount = in.read(bytes.array(), off, desiredByteCount);

                    if (actualByteCount == -1) {
                        endOfInput = true;
                        break;
                    } else if (actualByteCount == 0) {
                        break;
                    }
                    bytes.limit(bytes.limit() + actualByteCount);
                    needInput = false;
                }

                // decode bytes
                result = decoder.decode(bytes, out, false);

                if (result.isUnderflow()) {
                    // compact the buffer if no space left
                    if (bytes.limit() == bytes.capacity()) {
                        bytes.compact();
                        bytes.limit(bytes.position());
                        bytes.position(0);
                    }
                    needInput = true;
                } else {
                    break;
                }
            }

            if (result == CoderResult.UNDERFLOW && endOfInput) {
                result = decoder.decode(bytes, out, true);
                decoder.flush(out);
                decoder.reset();
            }
            if (result.isMalformed() || result.isUnmappable()) {
                result.throwException();
            }

            return out.position() - offset == 0 ? -1 : out.position() - offset;
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.989 -0500", hash_original_method = "2814A675517787CC2FFF66E2663BBAA6", hash_generated_method = "D3C76831C6D46CAC396A10504AD86E99")
    
private boolean isOpen() {
        return in != null;
    }

    /**
     * Indicates whether this reader is ready to be read without blocking. If
     * the result is {@code true}, the next {@code read()} will not block. If
     * the result is {@code false} then this reader may or may not block when
     * {@code read()} is called. This implementation returns {@code true} if
     * there are bytes available in the buffer or the source stream has bytes
     * available.
     *
     * @return {@code true} if the receiver will not block when {@code read()}
     *         is called, {@code false} if unknown or blocking will occur.
     * @throws IOException
     *             if this reader is closed or some other I/O error occurs.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.993 -0500", hash_original_method = "281B3CA6768822BAE894DB2D1EB23921", hash_generated_method = "2498DC1D1B71629ADBB2B0126A321243")
    
@Override
    public boolean ready() throws IOException {
        synchronized (lock) {
            if (in == null) {
                throw new IOException("InputStreamReader is closed");
            }
            try {
                return 1 == ((((bytes.hasRemaining())) ? 1 : 0) +
                                      in.available());
            } catch (IOException e) {
                return false;
            }
        }
    }
    
}

