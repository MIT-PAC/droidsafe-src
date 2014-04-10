package java.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Arrays;

import libcore.util.SneakyThrow;

public class FilterOutputStream extends OutputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.165 -0500", hash_original_field = "045D3F20D319391451B40CE63253C516", hash_generated_field = "F5E376611CAAF4EE829F9CD268525BC2")

    protected OutputStream out;

    /**
     * Constructs a new {@code FilterOutputStream} with {@code out} as its
     * target stream.
     *
     * @param out
     *            the target stream that this stream writes to.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.169 -0500", hash_original_method = "970F937F317FD0AE06FB76477C0F6F62", hash_generated_method = "C7AF229F201AE48E3E201474212FCBB3")
    
public FilterOutputStream(OutputStream out) {
        this.out = out;
    }

    /**
     * Closes this stream. This implementation closes the target stream.
     *
     * @throws IOException
     *             if an error occurs attempting to close this stream.
     */
    @DSComment("no security concern")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.172 -0500", hash_original_method = "C1E29F96DEA4D8E16CD646B2E66B7808", hash_generated_method = "49067DA9501AEFB1EA5D29AE5A00F09E")
    
@Override
    public void close() throws IOException {
       /* Throwable thrown = null;
        try {
            flush();
        } catch (Throwable e) {
            thrown = e;
        }

        try {
            out.close();
        } catch (Throwable e) {
            if (thrown == null) {
                thrown = e;
            }
        }

        if (thrown != null) {
            SneakyThrow.sneakyThrow(thrown);
        }*/
    }

    /**
     * Ensures that all pending data is sent out to the target stream. This
     * implementation flushes the target stream.
     *
     * @throws IOException
     *             if an error occurs attempting to flush this stream.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.174 -0500", hash_original_method = "C99FBA65B0D308569620507D6E099042", hash_generated_method = "5CE80A6225762CA51E516040755CB8E9")
    
@Override
    public void flush() throws IOException {
        out.flush();
    }

    /**
     * Writes {@code count} bytes from the byte array {@code buffer} starting at
     * {@code offset} to the target stream.
     *
     * @param buffer
     *            the buffer to write.
     * @param offset
     *            the index of the first byte in {@code buffer} to write.
     * @param length
     *            the number of bytes in {@code buffer} to write.
     * @throws IndexOutOfBoundsException
     *             if {@code offset < 0} or {@code count < 0}, or if
     *             {@code offset + count} is bigger than the length of
     *             {@code buffer}.
     * @throws IOException
     *             if an I/O error occurs while writing to this stream.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.177 -0500", hash_original_method = "6F432F0CBACFD3E73C2E675DFA6BA23C", hash_generated_method = "498B074A2C195BA232A7D0D68326D9CB")
    
@Override
    public void write(byte[] buffer, int offset, int length) throws IOException {
        Arrays.checkOffsetAndCount(buffer.length, offset, length);
        for (int i = 0; i < length; i++) {
            // Call write() instead of out.write() since subclasses could
            // override the write() method.
            write(buffer[offset + i]);
        }
    }

    /**
     * Writes one byte to the target stream. Only the low order byte of the
     * integer {@code oneByte} is written.
     *
     * @param oneByte
     *            the byte to be written.
     * @throws IOException
     *             if an I/O error occurs while writing to this stream.
     */
    @DSComment("Activity on IO class")
    @DSSpec(DSCat.IO)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.179 -0500", hash_original_method = "10EC24027333F66A6325D4B91084AA70", hash_generated_method = "72256F3E593320096EE1351175BB4E9C")
    
@Override
    public void write(int oneByte) throws IOException {
        //out.write(oneByte);
        out.droidsafeWrite(oneByte);
    }
    
}

