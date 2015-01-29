package javax.crypto;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;

import libcore.io.Streams;

public class CipherInputStream extends FilterInputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.844 -0500", hash_original_field = "17EB8419073573BCE3A0D064B41698CF", hash_generated_field = "15654AA7FE9DD715F5D7B5D292F8279E")

    private static final int I_BUFFER_SIZE = 20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.847 -0500", hash_original_field = "250DADA90730C7EEAE534A8757581875", hash_generated_field = "2FF9F58B969F4213F59ABA296D3A8FC3")

    private  Cipher cipher;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.849 -0500", hash_original_field = "7E46CBB3D3286318B976675E39568711", hash_generated_field = "DBE86B18DCC7D2F72C0A6792DDA95D4C")

    private final byte[] inputBuffer = new byte[I_BUFFER_SIZE];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.851 -0500", hash_original_field = "8BD524D6245D998B3BBC44EB9313082E", hash_generated_field = "56A277C77B76B31C1E1045C8C11CA802")

    private int index;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.854 -0500", hash_original_field = "C68BA6BC5E7DC06D47CF1745157D2847", hash_generated_field = "C130DF454E55F573D8007DE087170612")

    private byte[] outputBuffer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.856 -0500", hash_original_field = "59CD61E3A383ACAD01F8F1AA33285180", hash_generated_field = "3E2B0E3E2E572DECE0B20D77E19B79CF")

    private boolean finished;

    /**
     * Creates a new {@code CipherInputStream} instance for an {@code
     * InputStream} and a cipher.
     *
     * <p><strong>Warning:</strong> passing a null source creates an invalid
     * {@code CipherInputStream}. All read operations on such a stream will
     * fail.
     *
     * @param is
     *            the input stream to read data from.
     * @param c
     *            the cipher to process the data with.
     */
    @DSComment("cipher input stream")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.858 -0500", hash_original_method = "EC8926C4C5D7C4B05365DF92BFAEAD8D", hash_generated_method = "F12952E0CA8E1854E15DF5DB4C454684")
    
public CipherInputStream(InputStream is, Cipher c) {
        super(is);
        this.cipher = c;
    }

    /**
     * Creates a new {@code CipherInputStream} instance for an {@code
     * InputStream} without a cipher.
     * <p>
     * A {@code NullCipher} is created and used to process the data.
     *
     * @param is
     *            the input stream to read data from.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.861 -0500", hash_original_method = "3F50D5CECF426A3B563FBE87D10C056C", hash_generated_method = "09DCFC4A18D77F03F0A4F62AB1516ED5")
    
protected CipherInputStream(InputStream is) {
        this(is, new NullCipher());
    }

    /**
     * Reads the next byte from this cipher input stream.
     *
     * @return the next byte, or {@code -1} if the end of the stream is reached.
     * @throws IOException
     *             if an error occurs.
     */
    @DSSource({DSSourceKind.IO})
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.864 -0500", hash_original_method = "352555B7350AF9FC6F75FE9A04D77107", hash_generated_method = "5A3D4669971A485C77903A73C5150728")
    
@Override
    public int read() throws IOException {
        if (finished) {
            return ((outputBuffer == null) || (index == outputBuffer.length))
                            ? -1
                            : outputBuffer[index++] & 0xFF;
        }
        if ((outputBuffer != null) && (index < outputBuffer.length)) {
            return outputBuffer[index++] & 0xFF;
        }
        index = 0;
        outputBuffer = null;
        int byteCount;
        while (outputBuffer == null) {
            if ((byteCount = in.read(inputBuffer)) == -1) {
                try {
                    outputBuffer = cipher.doFinal();
                } catch (Exception e) {
                    throw new IOException(e.getMessage());
                }
                finished = true;
                break;
            }
            outputBuffer = cipher.update(inputBuffer, 0, byteCount);
        }
        return read();
    }

    /**
     * Reads the next {@code len} bytes from this input stream into buffer
     * {@code buf} starting at offset {@code off}.
     * <p>
     * if {@code b} is {@code null}, the next {@code len} bytes are read and
     * discarded.
     *
     * @return the number of bytes filled into buffer {@code b}, or {@code -1}
     *         of the of the stream is reached.
     * @throws IOException
     *             if an error occurs.
     * @throws NullPointerException
     *             if the underlying input stream is {@code null}.
     */
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.867 -0500", hash_original_method = "B8FB2A7CB3FB3DB7D0751D6D604C7303", hash_generated_method = "32C5EF162C13731AD932D0D8BFB53A3E")
    
@Override
    public int read(byte[] buf, int off, int len) throws IOException {
        if (in == null) {
            throw new NullPointerException("Underlying input stream is null");
        }

        int i;
        for (i = 0; i < len; ++i) {
            int b = read();
            if (b == -1) {
                return (i == 0) ? -1 : i;
            }
            if (buf != null) {
                buf[off+i] = (byte) b;
            }
        }
        return i;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.869 -0500", hash_original_method = "B0B2C5ABB0F3ADBF684B825EB14D5721", hash_generated_method = "FA64348A96D1C68BD0600E70DFA81D7E")
    
@Override
    public long skip(long byteCount) throws IOException {
        return Streams.skipByReading(this, byteCount);
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.872 -0500", hash_original_method = "1AA324AC6812BCD54DB71C20D6BA0F20", hash_generated_method = "A7CC27DC0CFA97EFE281A07867F4C6B1")
    
@Override
    public int available() throws IOException {
        return 0;
    }

    /**
     * Closes this {@code CipherInputStream}, also closes the underlying input
     * stream and call {@code doFinal} on the cipher object.
     *
     * @throws IOException
     *             if an error occurs.
     */
    @DSComment("no impacts")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.874 -0500", hash_original_method = "6325F2669A2E29C02EEAA5CF85C35B84", hash_generated_method = "4A52BEEDC3B4C19075A88B5C435F3B79")
    
@Override
    public void close() throws IOException {
        in.close();
        try {
            cipher.doFinal();
        } catch (GeneralSecurityException ignore) {
            //do like RI does
        }

    }

    /**
     * Returns whether this input stream supports {@code mark} and
     * {@code reset}, which it does not.
     *
     * @return false, since this input stream does not support {@code mark} and
     *         {@code reset}.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.877 -0500", hash_original_method = "12DAC0CE56878A53F37AFF65E12010EB", hash_generated_method = "98834879561C7504F012DD22F86DCE30")
    
@Override
    public boolean markSupported() {
        return false;
    }
}

