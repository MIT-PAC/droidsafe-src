package android.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Base64OutputStream extends FilterOutputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.724 -0500", hash_original_field = "8DB95C34ED9D40E875BEE17B0361EF64", hash_generated_field = "8DC8CC9D462633D2F5F238FD63AB94FA")

    private static byte[] EMPTY = new byte[0];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.716 -0500", hash_original_field = "4B998A8F6E44515A88542CACC83463DA", hash_generated_field = "1F1AACA9B8C921BF3C739250DBC6741F")

    private  Base64.Coder coder;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.718 -0500", hash_original_field = "E0CDE1A38A40425C446F52269E5723DC", hash_generated_field = "C01DA7975DA485EEDBF522635D053B3B")

    private  int flags;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.720 -0500", hash_original_field = "5A57624227AB14653270DE833B17A5A8", hash_generated_field = "B17349ED402A8EE321EE2D687D0FC773")

    private byte[] buffer = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.722 -0500", hash_original_field = "1F0B4B6BB95B4A11F5F030C5AA3E5A0D", hash_generated_field = "DE1311439F73FF2DC9E1E67409991F70")

    private int bpos = 0;

    /**
     * Performs Base64 encoding on the data written to the stream,
     * writing the encoded data to another OutputStream.
     *
     * @param out the OutputStream to write the encoded data to
     * @param flags bit flags for controlling the encoder; see the
     *        constants in {@link Base64}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.727 -0500", hash_original_method = "E46F474FD2867F9C3A785E56A0AD2237", hash_generated_method = "E1573FD3B03298E261695FCC31E3E53D")
    
public Base64OutputStream(OutputStream out, int flags) {
        this(out, flags, true);
    }

    /**
     * Performs Base64 encoding or decoding on the data written to the
     * stream, writing the encoded/decoded data to another
     * OutputStream.
     *
     * @param out the OutputStream to write the encoded data to
     * @param flags bit flags for controlling the encoder; see the
     *        constants in {@link Base64}
     * @param encode true to encode, false to decode
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.729 -0500", hash_original_method = "5457B6ADA9169BEDA2429E8007C22AEC", hash_generated_method = "CD65ECE60001EF2C88E3D007B6B65249")
    
public Base64OutputStream(OutputStream out, int flags, boolean encode) {
        super(out);
        this.flags = flags;
        if (encode) {
            coder = new Base64.Encoder(flags, null);
        } else {
            coder = new Base64.Decoder(flags, null);
        }
    }

    @DSSink(DSSinkKind.IO)
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.732 -0500", hash_original_method = "FE73EB52D6E189AC5420897BE3BAB488", hash_generated_method = "1ADCACF23ED831A66C2E0CE629D2DBDC")
    
public void write(int b) throws IOException {
        // To avoid invoking the encoder/decoder routines for single
        // bytes, we buffer up calls to write(int) in an internal
        // byte array to transform them into writes of decently-sized
        // arrays.

        if (buffer == null) {
            buffer = new byte[1024];
        }
        if (bpos >= buffer.length) {
            // internal buffer full; write it out.
            internalWrite(buffer, 0, bpos, false);
            bpos = 0;
        }
        buffer[bpos++] = (byte) b;
    }

    /**
     * Flush any buffered data from calls to write(int).  Needed
     * before doing a write(byte[], int, int) or a close().
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.734 -0500", hash_original_method = "F067C038C49D9731F81C40BA311D56BE", hash_generated_method = "CE5DDA8376A87F35429A12ECB9E39420")
    
private void flushBuffer() throws IOException {
        if (bpos > 0) {
            internalWrite(buffer, 0, bpos, false);
            bpos = 0;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.736 -0500", hash_original_method = "A3459DDB741D1D5DB893FD9A7CFFE0F1", hash_generated_method = "25400C9816E5E3BE7016286D20B6E9B1")
    
public void write(byte[] b, int off, int len) throws IOException {
        if (len <= 0) return;
        flushBuffer();
        internalWrite(b, off, len, false);
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.739 -0500", hash_original_method = "17457DFCCCBD635753AB001ED5B818FB", hash_generated_method = "15381DEED18B66C2741AA8C2FA6A8DD8")
    
public void close() throws IOException {
        IOException thrown = null;
        try {
            flushBuffer();
            internalWrite(EMPTY, 0, 0, true);
        } catch (IOException e) {
            thrown = e;
        }

        try {
            if ((flags & Base64.NO_CLOSE) == 0) {
                out.close();
            } else {
                out.flush();
            }
        } catch (IOException e) {
            if (thrown != null) {
                thrown = e;
            }
        }

        if (thrown != null) {
            throw thrown;
        }
    }

    /**
     * Write the given bytes to the encoder/decoder.
     *
     * @param finish true if this is the last batch of input, to cause
     *        encoder/decoder state to be finalized.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.741 -0500", hash_original_method = "4C39B7C855C3608586F188D73E5D3223", hash_generated_method = "5FC83B1953E7A5C3D3F0561A084B9533")
    
private void internalWrite(byte[] b, int off, int len, boolean finish) throws IOException {
        coder.output = embiggen(coder.output, coder.maxOutputSize(len));
        if (!coder.process(b, off, len, finish)) {
            throw new Base64DataException("bad base-64");
        }
        out.write(coder.output, 0, coder.op);
    }

    /**
     * If b.length is at least len, return b.  Otherwise return a new
     * byte array of length len.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.744 -0500", hash_original_method = "8F1A1CDA0B50B3C3FF8220D3A1F18B22", hash_generated_method = "4D1F018057D46810BCA86915AB70D911")
    
private byte[] embiggen(byte[] b, int len) {
        if (b == null || b.length < len) {
            return new byte[len];
        } else {
            return b;
        }
    }
}

