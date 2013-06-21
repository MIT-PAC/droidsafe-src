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
    private byte[] hex = { 0, 0, 0, 0, 0, 0, 0, 0, '\r', '\n' };
    private OutputStream socketOut;
    private int maxChunkLength;
    private ByteArrayOutputStream bufferedChunk;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.068 -0400", hash_original_method = "B36B9312ECC7FB1AB37744B06B5B016C", hash_generated_method = "A39E25290D957E17AE66C919FA73C8FA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ChunkedOutputStream(OutputStream socketOut, int maxChunkLength) {
        dsTaint.addTaint(maxChunkLength);
        dsTaint.addTaint(socketOut.dsTaint);
        this.maxChunkLength = Math.max(1, dataLength(maxChunkLength));
        this.bufferedChunk = new ByteArrayOutputStream(maxChunkLength);
        // ---------- Original Method ----------
        //this.socketOut = socketOut;
        //this.maxChunkLength = Math.max(1, dataLength(maxChunkLength));
        //this.bufferedChunk = new ByteArrayOutputStream(maxChunkLength);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.068 -0400", hash_original_method = "4E0221343957C12C5A2A1CAE66CCC091", hash_generated_method = "9B1AF06D700DD6E366A8A49E0FCFEC48")
    @DSModeled(DSC.SAFE)
    private int dataLength(int dataPlusHeaderLength) {
        dsTaint.addTaint(dataPlusHeaderLength);
        int headerLength;
        headerLength = 4;
        {
            int i;
            i = dataPlusHeaderLength - headerLength;
            i >>= 4;
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int headerLength = 4;
        //for (int i = dataPlusHeaderLength - headerLength; i > 0; i >>= 4) {
            //headerLength++;
        //}
        //return dataPlusHeaderLength - headerLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.069 -0400", hash_original_method = "B30C627643BAEC8E45C685D7AFD0614D", hash_generated_method = "DA9126400E80872A2E95C887AF6EFF0B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized void write(byte[] buffer, int offset, int count) throws IOException {
        dsTaint.addTaint(buffer[0]);
        dsTaint.addTaint(count);
        dsTaint.addTaint(offset);
        checkNotClosed();
        Arrays.checkOffsetAndCount(buffer.length, offset, count);
        {
            int numBytesWritten;
            {
                boolean varF13CBE75611B789F8CD077BCF7831748_1961191555 = (bufferedChunk.size() > 0 || count < maxChunkLength);
                {
                    numBytesWritten = Math.min(count, maxChunkLength - bufferedChunk.size());
                    bufferedChunk.write(buffer, offset, numBytesWritten);
                    {
                        boolean var865D83D3469A41A0F59C93791A49C355_1818952726 = (bufferedChunk.size() == maxChunkLength);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.069 -0400", hash_original_method = "3C05A9E8858284557710D8ECCDD07B35", hash_generated_method = "249793972D6F4712DBE65C6331768479")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writeHex(int i) throws IOException {
        dsTaint.addTaint(i);
        int cursor;
        cursor = 8;
        {
            hex[--cursor] = HEX_DIGITS[i & 0xf];
        } //End block
        {
            boolean varB82D55A2111BBE7B38375654B8ACC431_941538173 = ((i >>>= 4) != 0);
        } //End collapsed parenthetic
        socketOut.write(hex, cursor, hex.length - cursor);
        // ---------- Original Method ----------
        //int cursor = 8;
        //do {
            //hex[--cursor] = HEX_DIGITS[i & 0xf];
        //} while ((i >>>= 4) != 0);
        //socketOut.write(hex, cursor, hex.length - cursor);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.069 -0400", hash_original_method = "2122C1B33A3B975810DFF4F0E39E0DD1", hash_generated_method = "1AB06A934D5313C2DE62784C1CC304DD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.070 -0400", hash_original_method = "319458C7344F8B27CFA895D3D7B87CF0", hash_generated_method = "CC499C548A711E23B4F010C2E66BB3C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.070 -0400", hash_original_method = "8C406F82035B71C42CDC38D557C582DC", hash_generated_method = "E7E8966013F552B43C156BF544811E70")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writeBufferedChunkToSocket() throws IOException {
        int size;
        size = bufferedChunk.size();
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

    
    private static final byte[] CRLF = { '\r', '\n' };
    private static final byte[] HEX_DIGITS = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
    };
    private static final byte[] FINAL_CHUNK = new byte[] { '0', '\r', '\n', '\r', '\n' };
}

