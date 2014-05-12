package libcore.net.http;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

final class ChunkedOutputStream extends AbstractHttpOutputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.824 -0500", hash_original_field = "0708F15A26A4B9328B7DA0A1ADD69C0D", hash_generated_field = "4B60FF730AF43EA9F22E2DB05173F202")

    private static final byte[] CRLF = { '\r', '\n' };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.826 -0500", hash_original_field = "3C54E8075EC95DC1EC0FEF8E4F97AB5B", hash_generated_field = "EB18653A9ADE81F629C5BABEB37A529C")

    private static final byte[] HEX_DIGITS = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.829 -0500", hash_original_field = "E9A1683561AD60E6757E2930D3EB5271", hash_generated_field = "B2ADE567FCF6FB168F909D0DB6F26ABD")

    private static final byte[] FINAL_CHUNK = new byte[] { '0', '\r', '\n', '\r', '\n' };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.832 -0500", hash_original_field = "326537C01EC34B5AF6F6D97A5028AE10", hash_generated_field = "7E119A02B300ABE6FAAAAAB772A34121")

    private final byte[] hex = { 0, 0, 0, 0, 0, 0, 0, 0, '\r', '\n' };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.834 -0500", hash_original_field = "E040E41AD170B59C0C0B918B5BFE7983", hash_generated_field = "67AC7536EB45CC65D4356C94551DF297")

    private  OutputStream socketOut;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.836 -0500", hash_original_field = "8EC177D2A833548FA8A58828E89211B5", hash_generated_field = "0770750E9DA495C2C14F0337E32B0F75")

    private  int maxChunkLength;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.838 -0500", hash_original_field = "A696C8FD5DA65FB2C8ABA0FB4B272CB8", hash_generated_field = "23546DAF85E308782CACA02F261440D5")

    private  ByteArrayOutputStream bufferedChunk;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.841 -0500", hash_original_method = "B36B9312ECC7FB1AB37744B06B5B016C", hash_generated_method = "15E51A573FD7238D4AEF9752A64DE3CF")
    
public ChunkedOutputStream(OutputStream socketOut, int maxChunkLength) {
        this.socketOut = socketOut;
        this.maxChunkLength = Math.max(1, dataLength(maxChunkLength));
        this.bufferedChunk = new ByteArrayOutputStream(maxChunkLength);
    }

    /**
     * Returns the amount of data that can be transmitted in a chunk whose total
     * length (data+headers) is {@code dataPlusHeaderLength}. This is presumably
     * useful to match sizes with wire-protocol packets.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.843 -0500", hash_original_method = "4E0221343957C12C5A2A1CAE66CCC091", hash_generated_method = "45028AE40A28DE0C1B50EC72E20664DD")
    
private int dataLength(int dataPlusHeaderLength) {
        int headerLength = 4; // "\r\n" after the size plus another "\r\n" after the data
        for (int i = dataPlusHeaderLength - headerLength; i > 0; i >>= 4) {
            headerLength++;
        }
        return dataPlusHeaderLength - headerLength;
    }

    @DSSpec(DSCat.IO)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.846 -0500", hash_original_method = "B30C627643BAEC8E45C685D7AFD0614D", hash_generated_method = "DF933EA00B9F278BEF508C46A19942B0")
    
@Override public synchronized void write(byte[] buffer, int offset, int count)
            throws IOException {
        checkNotClosed();
        Arrays.checkOffsetAndCount(buffer.length, offset, count);

        while (count > 0) {
            int numBytesWritten;

            if (bufferedChunk.size() > 0 || count < maxChunkLength) {
                // fill the buffered chunk and then maybe write that to the stream
                numBytesWritten = Math.min(count, maxChunkLength - bufferedChunk.size());
                // TODO: skip unnecessary copies from buffer->bufferedChunk?
                bufferedChunk.write(buffer, offset, numBytesWritten);
                if (bufferedChunk.size() == maxChunkLength) {
                    writeBufferedChunkToSocket();
                }

            } else {
                // write a single chunk of size maxChunkLength to the stream
                numBytesWritten = maxChunkLength;
                writeHex(numBytesWritten);
                socketOut.write(buffer, offset, numBytesWritten);
                socketOut.write(CRLF);
            }

            offset += numBytesWritten;
            count -= numBytesWritten;
        }
    }

    /**
     * Equivalent to, but cheaper than writing Integer.toHexString().getBytes()
     * followed by CRLF.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.849 -0500", hash_original_method = "3C05A9E8858284557710D8ECCDD07B35", hash_generated_method = "EEEC1B7912F3169DDD870925BA9EB596")
    
private void writeHex(int i) throws IOException {
        int cursor = 8;
        do {
            hex[--cursor] = HEX_DIGITS[i & 0xf];
        } while ((i >>>= 4) != 0);
        socketOut.write(hex, cursor, hex.length - cursor);
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.851 -0500", hash_original_method = "2122C1B33A3B975810DFF4F0E39E0DD1", hash_generated_method = "F7B1D4A9788DDE30F529F00DBE210A74")
    
@Override public synchronized void flush() throws IOException {
        if (closed) {
            return; // don't throw; this stream might have been closed on the caller's behalf
        }
        writeBufferedChunkToSocket();
        socketOut.flush();
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.854 -0500", hash_original_method = "319458C7344F8B27CFA895D3D7B87CF0", hash_generated_method = "C4D7B666472B7F938E0721FDE4761124")
    
@Override public synchronized void close() throws IOException {
        if (closed) {
            return;
        }
        closed = true;
        writeBufferedChunkToSocket();
        socketOut.write(FINAL_CHUNK);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.856 -0500", hash_original_method = "8C406F82035B71C42CDC38D557C582DC", hash_generated_method = "1684E4B6E19BA9DF1626EA0CBBFB01E5")
    
private void writeBufferedChunkToSocket() throws IOException {
        int size = bufferedChunk.size();
        if (size <= 0) {
            return;
        }

        writeHex(size);
        bufferedChunk.writeTo(socketOut);
        bufferedChunk.reset();
        socketOut.write(CRLF);
    }
}

