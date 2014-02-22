package java.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;

public class OutputStreamWriter extends Writer {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.566 -0500", hash_original_field = "045D3F20D319391451B40CE63253C516", hash_generated_field = "FAC7CE5410064D378AF9E7B2309C5BE9")

    private  OutputStream out;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.568 -0500", hash_original_field = "35DE68BB49761C7459EF0234F6EAB1B7", hash_generated_field = "A07B3C678B690A0A298B0184B628874A")

    private CharsetEncoder encoder;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.571 -0500", hash_original_field = "D75566C09E1648987D573E04AE908DE5", hash_generated_field = "A3FC74598F816F44A8E790B9843EEF7E")

    private ByteBuffer bytes = ByteBuffer.allocate(8192);

    /**
     * Constructs a new OutputStreamWriter using {@code out} as the target
     * stream to write converted characters to. The default character encoding
     * is used.
     *
     * @param out
     *            the non-null target stream to write converted bytes to.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.574 -0500", hash_original_method = "8C206CCA706FC5574C37E56D894D8687", hash_generated_method = "842F6B6710D3A66CF876DB8E7DB54F66")
    
public OutputStreamWriter(OutputStream out) {
        this(out, Charset.defaultCharset());
    }

    /**
     * Constructs a new OutputStreamWriter using {@code out} as the target
     * stream to write converted characters to and {@code enc} as the character
     * encoding. If the encoding cannot be found, an
     * UnsupportedEncodingException error is thrown.
     *
     * @param out
     *            the target stream to write converted bytes to.
     * @param enc
     *            the string describing the desired character encoding.
     * @throws NullPointerException
     *             if {@code enc} is {@code null}.
     * @throws UnsupportedEncodingException
     *             if the encoding specified by {@code enc} cannot be found.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.577 -0500", hash_original_method = "FE2D64915F756E150E2359224C906A4F", hash_generated_method = "3EEBA5BDED2B81E569A17044B94159D1")
    
public OutputStreamWriter(OutputStream out, final String enc)
            throws UnsupportedEncodingException {
        super(out);
        if (enc == null) {
            throw new NullPointerException();
        }
        this.out = out;
        try {
            encoder = Charset.forName(enc).newEncoder();
        } catch (Exception e) {
            throw new UnsupportedEncodingException(enc);
        }
        encoder.onMalformedInput(CodingErrorAction.REPLACE);
        encoder.onUnmappableCharacter(CodingErrorAction.REPLACE);
    }

    /**
     * Constructs a new OutputStreamWriter using {@code out} as the target
     * stream to write converted characters to and {@code cs} as the character
     * encoding.
     *
     * @param out
     *            the target stream to write converted bytes to.
     * @param cs
     *            the {@code Charset} that specifies the character encoding.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.580 -0500", hash_original_method = "8F31DE887FC24410EE09434FBA44CA21", hash_generated_method = "C388739C3AC44331B56B35FBA1B88BA7")
    
public OutputStreamWriter(OutputStream out, Charset cs) {
        super(out);
        this.out = out;
        encoder = cs.newEncoder();
        encoder.onMalformedInput(CodingErrorAction.REPLACE);
        encoder.onUnmappableCharacter(CodingErrorAction.REPLACE);
    }

    /**
     * Constructs a new OutputStreamWriter using {@code out} as the target
     * stream to write converted characters to and {@code enc} as the character
     * encoder.
     *
     * @param out
     *            the target stream to write converted bytes to.
     * @param enc
     *            the character encoder used for character conversion.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.583 -0500", hash_original_method = "C5AFC76AE8F04EED9C657E07A65429EA", hash_generated_method = "8CD38A4A4B1FF7E5F7207AD626AB27C7")
    
public OutputStreamWriter(OutputStream out, CharsetEncoder enc) {
        super(out);
        enc.charset();
        this.out = out;
        encoder = enc;
    }

    /**
     * Closes this writer. This implementation flushes the buffer as well as the
     * target stream. The target stream is then closed and the resources for the
     * buffer and converter are released.
     *
     * <p>Only the first invocation of this method has any effect. Subsequent calls
     * do nothing.
     *
     * @throws IOException
     *             if an error occurs while closing this writer.
     */
    @DSComment("OutputStreamWrite class")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.585 -0500", hash_original_method = "348EDF61477AE4A3DCAC4870D899F874", hash_generated_method = "5D0388D5AAD5F0793DE2F1E9322C0CED")
    
@Override
    public void close() throws IOException {
        synchronized (lock) {
            if (encoder != null) {
                drainEncoder();
                flushBytes(false);
                out.close();
                encoder = null;
                bytes = null;
            }
        }
    }

    /**
     * Flushes this writer. This implementation ensures that all buffered bytes
     * are written to the target stream. After writing the bytes, the target
     * stream is flushed as well.
     *
     * @throws IOException
     *             if an error occurs while flushing this writer.
     */
    @DSComment("OutputStreamWrite class")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.587 -0500", hash_original_method = "E89503CD667F6DF7A02E3D218DF666E8", hash_generated_method = "5472256256B480FB5B4336E5277791E6")
    
@Override
    public void flush() throws IOException {
        flushBytes(true);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.590 -0500", hash_original_method = "0B376EED04C0EE48C2109F7445B1F9FC", hash_generated_method = "C8FACB662842DE898FFC39C3594E5611")
    
private void flushBytes(boolean flushUnderlyingStream) throws IOException {
        synchronized (lock) {
            checkStatus();
            int position = bytes.position();
            if (position > 0) {
                bytes.flip();
                out.write(bytes.array(), bytes.arrayOffset(), position);
                bytes.clear();
            }
            if (flushUnderlyingStream) {
                out.flush();
            }
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.592 -0500", hash_original_method = "5FDBBBBEF70B98878F7238A71245F3A5", hash_generated_method = "4A911564E9A859C4A6028B8201CF47CB")
    
private void convert(CharBuffer chars) throws IOException {
        while (true) {
            CoderResult result = encoder.encode(chars, bytes, false);
            if (result.isOverflow()) {
                // Make room and try again.
                flushBytes(false);
                continue;
            } else if (result.isError()) {
                result.throwException();
            }
            break;
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.596 -0500", hash_original_method = "17AF81F5CD218F57FFE1053C07491E0D", hash_generated_method = "524D4A956EFD1F9DD96E8962610F3BDB")
    
private void drainEncoder() throws IOException {
        // Strictly speaking, I think it's part of the CharsetEncoder contract that you call
        // encode with endOfInput true before flushing. Our ICU-based implementations don't
        // actually need this, and you'd hope that any reasonable implementation wouldn't either.
        // CharsetEncoder.encode doesn't actually pass the boolean through to encodeLoop anyway!
        CharBuffer chars = CharBuffer.allocate(0);
        while (true) {
            CoderResult result = encoder.encode(chars, bytes, true);
            if (result.isError()) {
                result.throwException();
            } else if (result.isOverflow()) {
                flushBytes(false);
                continue;
            }
            break;
        }

        // Some encoders (such as ISO-2022-JP) have stuff to write out after all the
        // characters (such as shifting back into a default state). In our implementation,
        // this is actually the first time ICU is told that we've run out of input.
        CoderResult result = encoder.flush(bytes);
        while (!result.isUnderflow()) {
            if (result.isOverflow()) {
                flushBytes(false);
                result = encoder.flush(bytes);
            } else {
                result.throwException();
            }
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.598 -0500", hash_original_method = "75BDF3BC8D58179DECD9AB14C1C7F3EE", hash_generated_method = "714C39594B4787E56AA58C1A1ACFBD74")
    
private void checkStatus() throws IOException {
        if (encoder == null) {
            throw new IOException("OutputStreamWriter is closed");
        }
    }

    /**
     * Returns the historical name of the encoding used by this writer to convert characters to
     * bytes, or null if this writer has been closed. Most callers should probably keep
     * track of the String or Charset they passed in; this method may not return the same
     * name.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.601 -0500", hash_original_method = "A69A1F1EB2BFDD0474AAD9460630967D", hash_generated_method = "0FF93F2101F36D1283DE60FF400C16CB")
    
public String getEncoding() {
        if (encoder == null) {
            return null;
        }
        return HistoricalCharsetNames.get(encoder.charset());
    }

    /**
     * Writes {@code count} characters starting at {@code offset} in {@code buf}
     * to this writer. The characters are immediately converted to bytes by the
     * character converter and stored in a local buffer. If the buffer gets full
     * as a result of the conversion, this writer is flushed.
     *
     * @param buffer
     *            the array containing characters to write.
     * @param offset
     *            the index of the first character in {@code buf} to write.
     * @param count
     *            the maximum number of characters to write.
     * @throws IndexOutOfBoundsException
     *             if {@code offset < 0} or {@code count < 0}, or if
     *             {@code offset + count} is greater than the size of
     *             {@code buf}.
     * @throws IOException
     *             if this writer has already been closed or another I/O error
     *             occurs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.603 -0500", hash_original_method = "A1014AE81A36DB02C830992F3B254644", hash_generated_method = "A96B07B6EEBAA8EA2F682CB1A720ECE7")
    
@Override
    public void write(char[] buffer, int offset, int count) throws IOException {
        synchronized (lock) {
            checkStatus();
            Arrays.checkOffsetAndCount(buffer.length, offset, count);
            CharBuffer chars = CharBuffer.wrap(buffer, offset, count);
            convert(chars);
        }
    }

    /**
     * Writes the character {@code oneChar} to this writer. The lowest two bytes
     * of the integer {@code oneChar} are immediately converted to bytes by the
     * character converter and stored in a local buffer. If the buffer gets full
     * by converting this character, this writer is flushed.
     *
     * @param oneChar
     *            the character to write.
     * @throws IOException
     *             if this writer is closed or another I/O error occurs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.607 -0500", hash_original_method = "9F78C67C90A8F7A084F2E3084DB157FE", hash_generated_method = "20C055F9C168D000FD8A3145FD191358")
    
@Override
    public void write(int oneChar) throws IOException {
        synchronized (lock) {
            checkStatus();
            CharBuffer chars = CharBuffer.wrap(new char[] { (char) oneChar });
            convert(chars);
        }
    }

    /**
     * Writes {@code count} characters starting at {@code offset} in {@code str}
     * to this writer. The characters are immediately converted to bytes by the
     * character converter and stored in a local buffer. If the buffer gets full
     * as a result of the conversion, this writer is flushed.
     *
     * @param str
     *            the string containing characters to write.
     * @param offset
     *            the start position in {@code str} for retrieving characters.
     * @param count
     *            the maximum number of characters to write.
     * @throws IOException
     *             if this writer has already been closed or another I/O error
     *             occurs.
     * @throws IndexOutOfBoundsException
     *             if {@code offset < 0} or {@code count < 0}, or if
     *             {@code offset + count} is bigger than the length of
     *             {@code str}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.610 -0500", hash_original_method = "720362548945B36884470AD2C6B99C23", hash_generated_method = "00265FCA2186A6FA0C1C9C2C49A9AE91")
    
@Override
    public void write(String str, int offset, int count) throws IOException {
        synchronized (lock) {
            if (count < 0) {
                throw new StringIndexOutOfBoundsException(str, offset, count);
            }
            if (str == null) {
                throw new NullPointerException("str == null");
            }
            if ((offset | count) < 0 || offset > str.length() - count) {
                throw new StringIndexOutOfBoundsException(str, offset, count);
            }
            checkStatus();
            CharBuffer chars = CharBuffer.wrap(str, offset, count + offset);
            convert(chars);
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.612 -0500", hash_original_method = "E279B5931B3E4ADEA2A691FE75B2536D", hash_generated_method = "69A9C9DFC45715CCC07CA531016E0080")
    
@Override boolean checkError() {
        return out.checkError();
    }
    
}

