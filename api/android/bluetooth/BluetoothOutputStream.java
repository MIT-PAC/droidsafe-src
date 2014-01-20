package android.bluetooth;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.OutputStream;

final class BluetoothOutputStream extends OutputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.494 -0500", hash_original_field = "F88CEEEA2A0982472DB6E6356FAA58B9", hash_generated_field = "F41529E7146F039F8982FD61509E896F")

    private BluetoothSocket mSocket;

    /*package*/ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.496 -0500", hash_original_method = "6B802CCB266833E5725B115B8F18B649", hash_generated_method = "6B802CCB266833E5725B115B8F18B649")
    
BluetoothOutputStream(BluetoothSocket s) {
        mSocket = s;
    }

    /**
     * Close this output stream and the socket associated with it.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.498 -0500", hash_original_method = "1323B57D07CB6385C2F8CE9373488A22", hash_generated_method = "C95071B8627034E7D9B94D5D2A0541A3")
    
public void close() throws IOException {
        mSocket.close();
    }

    /**
     * Writes a single byte to this stream. Only the least significant byte of
     * the integer {@code oneByte} is written to the stream.
     *
     * @param oneByte
     *            the byte to be written.
     * @throws IOException
     *             if an error occurs while writing to this stream.
     * @since Android 1.0
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.500 -0500", hash_original_method = "B2E185518772C6191E25665E6AAA6FD5", hash_generated_method = "2D5A46C23DD97DDE153E0C9506B1B72B")
    
public void write(int oneByte) throws IOException {
        byte b[] = new byte[1];
        b[0] = (byte)oneByte;
        mSocket.write(b, 0, 1);
    }

    /**
     * Writes {@code count} bytes from the byte array {@code buffer} starting
     * at position {@code offset} to this stream.
     *
     * @param b
     *            the buffer to be written.
     * @param offset
     *            the start position in {@code buffer} from where to get bytes.
     * @param count
     *            the number of bytes from {@code buffer} to write to this
     *            stream.
     * @throws IOException
     *             if an error occurs while writing to this stream.
     * @throws IndexOutOfBoundsException
     *             if {@code offset < 0} or {@code count < 0}, or if
     *             {@code offset + count} is bigger than the length of
     *             {@code buffer}.
     * @since Android 1.0
     */
    @DSSink({DSSinkKind.BLUETOOTH})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.503 -0500", hash_original_method = "DFA6C29609C7324702E3356FC466F21E", hash_generated_method = "7AAC56040D447F28CDAF031F1B6BE1B8")
    
public void write(byte[] b, int offset, int count) throws IOException {
        if (b == null) {
            throw new NullPointerException("buffer is null");
        }
        if ((offset | count) < 0 || count > b.length - offset) {
            throw new IndexOutOfBoundsException("invalid offset or length");
        }
        mSocket.write(b, offset, count);
    }
    
}

