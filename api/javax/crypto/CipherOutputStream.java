package javax.crypto;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import libcore.io.Streams;

public class CipherOutputStream extends FilterOutputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:54.306 -0500", hash_original_field = "250DADA90730C7EEAE534A8757581875", hash_generated_field = "2FF9F58B969F4213F59ABA296D3A8FC3")

    private  Cipher cipher;

    /**
     * Creates a new {@code CipherOutputStream} instance for an {@code
     * OutputStream} and a {@code Cipher}.
     *
     * @param os
     *            the output stream to write data to.
     * @param c
     *            the cipher to process the data with.
     */
    @DSComment("cipher input stream")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:54.310 -0500", hash_original_method = "F0906B408310381889BAAA52B967EE5F", hash_generated_method = "0ADA483B9C2CFED5418C77FDF989EE2D")
    
public CipherOutputStream(OutputStream os, Cipher c) {
        super(os);
        cipher = c;
    }

    /**
     * Creates a new {@code CipherOutputStream} instance for an {@code
     * OutputStream} without a cipher.
     * <p>
     * A {@code NullCipher} is created to process the data.
     *
     * @param os
     *            the output stream to write the data to.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:54.315 -0500", hash_original_method = "1AEB5C9039E95E13C9B65FD65F4D37C9", hash_generated_method = "5DB4712ED6FE8A34E26D58DC7C8C055E")
    
protected CipherOutputStream(OutputStream os) {
        this(os, new NullCipher());
    }

    /**
     * Writes the single byte to this cipher output stream.
     *
     * @param b
     *            the byte to write.
     * @throws IOException
     *             if an error occurs.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:54.319 -0500", hash_original_method = "C558B2B88CBF261C0FBBE5741F96019C", hash_generated_method = "23C1BFB0F79EE3063A60285E2CC71033")
    
@Override public void write(int b) throws IOException {
        Streams.writeSingleByte(this, b);
    }

    /**
     * Writes the {@code len} bytes from buffer {@code b} starting at offset
     * {@code off} to this cipher output stream.
     *
     * @param b
     *            the buffer.
     * @param off
     *            the offset to start at.
     * @param len
     *            the number of bytes.
     * @throws IOException
     *             if an error occurs.
     */
    @DSComment("IO operations")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:54.322 -0500", hash_original_method = "5836CE17B48698DBC2254777B1086E69", hash_generated_method = "303B5B5237A2689D22F4C6FFC92947DF")
    
@Override public void write(byte[] b, int off, int len) throws IOException {
        if (len == 0) {
            return;
        }
        byte[] result = cipher.update(b, off, len);
        if (result != null) {
            out.write(result);
        }
    }

    /**
     * Flushes this cipher output stream.
     *
     * @throws IOException
     *             if an error occurs
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:54.326 -0500", hash_original_method = "C99FBA65B0D308569620507D6E099042", hash_generated_method = "5CE80A6225762CA51E516040755CB8E9")
    
@Override
    public void flush() throws IOException {
        out.flush();
    }

    /**
     * Close this cipher output stream.
     * <p>
     * On the underlying cipher {@code doFinal} will be invoked, and any
     * buffered bytes from the cipher are also written out, and the cipher is
     * reset to its initial state. The underlying output stream is also closed.
     *
     * @throws IOException
     *             if an error occurs.
     */
    @DSComment("no impacts")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:54.330 -0500", hash_original_method = "C8083FF618F908C15CB2AD663C443A1B", hash_generated_method = "974459A89F685B5913D32585BCCCECBF")
    
@Override
    public void close() throws IOException {
        byte[] result;
        try {
            if (cipher != null) {
                result = cipher.doFinal();
                if (result != null) {
                    out.write(result);
                }
            }
            if (out != null) {
                out.flush();
            }
        } catch (BadPaddingException e) {
            throw new IOException(e.getMessage());
        } catch (IllegalBlockSizeException e) {
            throw new IOException(e.getMessage());
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
    
}

