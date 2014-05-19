package android.bluetooth;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;

final class BluetoothInputStream extends InputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.438 -0500", hash_original_field = "F88CEEEA2A0982472DB6E6356FAA58B9", hash_generated_field = "F41529E7146F039F8982FD61509E896F")

    private BluetoothSocket mSocket;

    /*package*/ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.440 -0500", hash_original_method = "A759A55FDB7858A5B7FBD6EFC5F7FCA1", hash_generated_method = "A759A55FDB7858A5B7FBD6EFC5F7FCA1")
    
BluetoothInputStream(BluetoothSocket s) {
        mSocket = s;
    }

    /**
     * Return number of bytes available before this stream will block.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.442 -0500", hash_original_method = "F8D5D10C5F2F8FB1DCC0A3044A3235C3", hash_generated_method = "698BE5E5354DC14F82BB3A94A7C5289A")
    
public int available() throws IOException {
        return mSocket.available();
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.445 -0500", hash_original_method = "1323B57D07CB6385C2F8CE9373488A22", hash_generated_method = "C95071B8627034E7D9B94D5D2A0541A3")
    
public void close() throws IOException {
        mSocket.close();
    }

    /**
     * Reads a single byte from this stream and returns it as an integer in the
     * range from 0 to 255. Returns -1 if the end of the stream has been
     * reached. Blocks until one byte has been read, the end of the source
     * stream is detected or an exception is thrown.
     *
     * @return the byte read or -1 if the end of stream has been reached.
     * @throws IOException
     *             if the stream is closed or another IOException occurs.
     * @since Android 1.5
     */
    @DSSource({DSSourceKind.IO})
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.447 -0500", hash_original_method = "2059D974D6DFEDC9A8B8553096188222", hash_generated_method = "6E79AC07ED988EFBA15A6F1994AEF577")
    
public int read() throws IOException {
        byte b[] = new byte[1];
        int ret = mSocket.read(b, 0, 1);
        return (ret + b[0]);
    }

    /**
     * Reads at most {@code length} bytes from this stream and stores them in
     * the byte array {@code b} starting at {@code offset}.
     *
     * @param b
     *            the byte array in which to store the bytes read.
     * @param offset
     *            the initial position in {@code buffer} to store the bytes
     *            read from this stream.
     * @param length
     *            the maximum number of bytes to store in {@code b}.
     * @return the number of bytes actually read or -1 if the end of the stream
     *         has been reached.
     * @throws IndexOutOfBoundsException
     *             if {@code offset < 0} or {@code length < 0}, or if
     *             {@code offset + length} is greater than the length of
     *             {@code b}.
     * @throws IOException
     *             if the stream is closed or another IOException occurs.
     * @since Android 1.5
     */
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.449 -0500", hash_original_method = "20F62B1F3CA63F6FE3BCEE9660F3F09F", hash_generated_method = "0DF6D203DCBC3F1E01A85090A3B0A6A7")
    
public int read(byte[] b, int offset, int length) throws IOException {
        if (b == null) {
            throw new NullPointerException("byte array is null");
        }
        if ((offset | length) < 0 || length > b.length - offset) {
            throw new ArrayIndexOutOfBoundsException("invalid offset or length");
        }
        return mSocket.read(b, offset, length);
    }
    
}

