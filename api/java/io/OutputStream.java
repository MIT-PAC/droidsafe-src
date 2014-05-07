package java.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Arrays;

public abstract class OutputStream implements Closeable, Flushable {

    /**
     * Default constructor.
     */
    @DSComment("no security concern")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.823 -0500", hash_original_method = "5995752F91892DAFA432449AA7A2BB76", hash_generated_method = "1D6DCD4069A5099E588E31C568880D1D")
    
public OutputStream() {
    }

    /**
     * Closes this stream. Implementations of this method should free any
     * resources used by the stream. This implementation does nothing.
     *
     * @throws IOException
     *             if an error occurs while closing this stream.
     */
    @DSComment("no security concern")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.825 -0500", hash_original_method = "403A1214A00C2300123B494982A31042", hash_generated_method = "BDB80A0BA0CE964F390B74B4F78F39D0")
    
public void close() throws IOException {
        /* empty */
    }

    /**
     * Flushes this stream. Implementations of this method should ensure that
     * any buffered data is written out. This implementation does nothing.
     *
     * @throws IOException
     *             if an error occurs while flushing this stream.
     */
    @DSComment("no security concern")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.827 -0500", hash_original_method = "1521992F8E9F05A9FDFB0E59716E3E93", hash_generated_method = "243C0871CD5D1DDEC1C9766742E8A0B7")
    
public void flush() throws IOException {
        /* empty */
    }

    /**
     * Equivalent to {@code write(buffer, 0, buffer.length)}.
     */
    @DSComment("Activity on IO class")
    @DSSpec(DSCat.IO)
    @DSSink({DSSinkKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.829 -0500", hash_original_method = "773CDFC941DB5BD8F51FCC7460E1F3ED", hash_generated_method = "227B669FDA8AD574341B08A5DD95557F")
    
public void write(byte[] buffer) throws IOException {
        write(buffer, 0, buffer.length);
    }

    /**
     * Writes {@code count} bytes from the byte array {@code buffer} starting at
     * position {@code offset} to this stream.
     *
     * @param buffer
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
     */
    @DSComment("Activity on IO class")
    @DSSpec(DSCat.IO)
    @DSSink({DSSinkKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.832 -0500", hash_original_method = "F6CDEA64748F80FE862CBAFFE4725DDE", hash_generated_method = "CDD044E99B9A9B3DC054F6D500C9D2DA")
    
public void write(byte[] buffer, int offset, int count) throws IOException {
        Arrays.checkOffsetAndCount(buffer.length, offset, count);
        for (int i = offset; i < offset + count; i++) {
            write(buffer[i]);
        }
    }

    /**
     * Writes a single byte to this stream. Only the least significant byte of
     * the integer {@code oneByte} is written to the stream.
     *
     * @param oneByte
     *            the byte to be written.
     * @throws IOException
     *             if an error occurs while writing to this stream.
     */
    @DSSink(DSSinkKind.IO)
    @DSComment("Abstract Method")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.835 -0500", hash_original_method = "6F952A0997C9C7FC75CA00C51592E230", hash_generated_method = "EFF3C84F96B0F410A6246A434AA1C3DB")
    
public abstract void write(int oneByte) throws IOException;

    /**
     * Returns true if this writer has encountered and suppressed an error. Used
     * by PrintStreams as an alternative to checked exceptions.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.837 -0500", hash_original_method = "0FEA708DB7A5B3B6D16FEC9623D0EEF8", hash_generated_method = "0FEA708DB7A5B3B6D16FEC9623D0EEF8")
    
boolean checkError() {
        return false;
    }
    
    @DSBan(DSCat.DROIDSAFE_INTERNAL)
    public void droidsafeWrite(int oneByte) {
        addTaint(oneByte);
    }
    
}

