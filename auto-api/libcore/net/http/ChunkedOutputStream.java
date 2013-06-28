package libcore.net.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

final class ChunkedOutputStream extends AbstractHttpOutputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.633 -0400", hash_original_field = "C0E37FC3522AAF119980E44CDA3BD507", hash_generated_field = "7E119A02B300ABE6FAAAAAB772A34121")

    private final byte[] hex = { 0, 0, 0, 0, 0, 0, 0, 0, '\r', '\n' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.633 -0400", hash_original_field = "199B6833958A1195ADC95B67243D2F6F", hash_generated_field = "67AC7536EB45CC65D4356C94551DF297")

    private OutputStream socketOut;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.633 -0400", hash_original_field = "D6C78BEC18E6C26B4EF715D6CA3D8598", hash_generated_field = "0770750E9DA495C2C14F0337E32B0F75")

    private int maxChunkLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.633 -0400", hash_original_field = "CD62C91F91B558516DA14670986E381F", hash_generated_field = "23546DAF85E308782CACA02F261440D5")

    private ByteArrayOutputStream bufferedChunk;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.634 -0400", hash_original_method = "B36B9312ECC7FB1AB37744B06B5B016C", hash_generated_method = "C3EA4EBC4FB1FF0DE80B4F438FCA04E4")
    public  ChunkedOutputStream(OutputStream socketOut, int maxChunkLength) {
        this.socketOut = socketOut;
        this.maxChunkLength = Math.max(1, dataLength(maxChunkLength));
        this.bufferedChunk = new ByteArrayOutputStream(maxChunkLength);
        // ---------- Original Method ----------
        //this.socketOut = socketOut;
        //this.maxChunkLength = Math.max(1, dataLength(maxChunkLength));
        //this.bufferedChunk = new ByteArrayOutputStream(maxChunkLength);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.634 -0400", hash_original_method = "4E0221343957C12C5A2A1CAE66CCC091", hash_generated_method = "8203339BBCCFB5F5BA97A8F4A17BF3C1")
    private int dataLength(int dataPlusHeaderLength) {
        int headerLength = 4;
        {
            int i = dataPlusHeaderLength - headerLength;
            i >>= 4;
        } //End collapsed parenthetic
        addTaint(dataPlusHeaderLength);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_149086937 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_149086937;
        // ---------- Original Method ----------
        //int headerLength = 4;
        //for (int i = dataPlusHeaderLength - headerLength; i > 0; i >>= 4) {
            //headerLength++;
        //}
        //return dataPlusHeaderLength - headerLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.635 -0400", hash_original_method = "B30C627643BAEC8E45C685D7AFD0614D", hash_generated_method = "69DB32EFAEFDA418B523F8067988731A")
    @Override
    public synchronized void write(byte[] buffer, int offset, int count) throws IOException {
        checkNotClosed();
        Arrays.checkOffsetAndCount(buffer.length, offset, count);
        {
            int numBytesWritten;
            {
                boolean varF13CBE75611B789F8CD077BCF7831748_1836853247 = (bufferedChunk.size() > 0 || count < maxChunkLength);
                {
                    numBytesWritten = Math.min(count, maxChunkLength - bufferedChunk.size());
                    bufferedChunk.write(buffer, offset, numBytesWritten);
                    {
                        boolean var865D83D3469A41A0F59C93791A49C355_814764783 = (bufferedChunk.size() == maxChunkLength);
                        {
                            writeBufferedChunkToSocket();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    numBytesWritten = maxChunkLength;
                    writeHex(numBytesWritten);
                    socketOut.write(buffer, offset, numBytesWritten);
                    socketOut.write(CRLF);
                } //End block
            } //End collapsed parenthetic
            offset += numBytesWritten;
            count -= numBytesWritten;
        } //End block
        addTaint(buffer[0]);
        addTaint(offset);
        addTaint(count);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.636 -0400", hash_original_method = "3C05A9E8858284557710D8ECCDD07B35", hash_generated_method = "9728A1CDE4EC931830BCE40388184F1C")
    private void writeHex(int i) throws IOException {
        int cursor = 8;
        {
            hex[--cursor] = HEX_DIGITS[i & 0xf];
        } //End block
        {
            boolean varB82D55A2111BBE7B38375654B8ACC431_1989071218 = ((i >>>= 4) != 0);
        } //End collapsed parenthetic
        socketOut.write(hex, cursor, hex.length - cursor);
        // ---------- Original Method ----------
        //int cursor = 8;
        //do {
            //hex[--cursor] = HEX_DIGITS[i & 0xf];
        //} while ((i >>>= 4) != 0);
        //socketOut.write(hex, cursor, hex.length - cursor);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.636 -0400", hash_original_method = "2122C1B33A3B975810DFF4F0E39E0DD1", hash_generated_method = "1AB06A934D5313C2DE62784C1CC304DD")
    @Override
    public synchronized void flush() throws IOException {
        writeBufferedChunkToSocket();
        socketOut.flush();
        // ---------- Original Method ----------
        //if (closed) {
            //return; 
        //}
        //writeBufferedChunkToSocket();
        //socketOut.flush();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.637 -0400", hash_original_method = "319458C7344F8B27CFA895D3D7B87CF0", hash_generated_method = "CC499C548A711E23B4F010C2E66BB3C8")
    @Override
    public synchronized void close() throws IOException {
        closed = true;
        writeBufferedChunkToSocket();
        socketOut.write(FINAL_CHUNK);
        // ---------- Original Method ----------
        //if (closed) {
            //return;
        //}
        //closed = true;
        //writeBufferedChunkToSocket();
        //socketOut.write(FINAL_CHUNK);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.638 -0400", hash_original_method = "8C406F82035B71C42CDC38D557C582DC", hash_generated_method = "579B61A1B5B1B7F3572396A8C8FEBDB5")
    private void writeBufferedChunkToSocket() throws IOException {
        int size = bufferedChunk.size();
        writeHex(size);
        bufferedChunk.writeTo(socketOut);
        bufferedChunk.reset();
        socketOut.write(CRLF);
        // ---------- Original Method ----------
        //int size = bufferedChunk.size();
        //if (size <= 0) {
            //return;
        //}
        //writeHex(size);
        //bufferedChunk.writeTo(socketOut);
        //bufferedChunk.reset();
        //socketOut.write(CRLF);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.638 -0400", hash_original_field = "0FB2D7C7599E1278F6E31DD7106E77DB", hash_generated_field = "4B60FF730AF43EA9F22E2DB05173F202")

    private static final byte[] CRLF = { '\r', '\n' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.638 -0400", hash_original_field = "C98D21B8FAC7647D23DCEE3CC1EA43FE", hash_generated_field = "EB18653A9ADE81F629C5BABEB37A529C")

    private static final byte[] HEX_DIGITS = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.638 -0400", hash_original_field = "73F8B66F837608F735B93E40F96EE64F", hash_generated_field = "B2ADE567FCF6FB168F909D0DB6F26ABD")

    private static final byte[] FINAL_CHUNK = new byte[] { '0', '\r', '\n', '\r', '\n' };
}

