package libcore.net.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

final class ChunkedOutputStream extends AbstractHttpOutputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.072 -0400", hash_original_field = "C0E37FC3522AAF119980E44CDA3BD507", hash_generated_field = "7E119A02B300ABE6FAAAAAB772A34121")

    private final byte[] hex = { 0, 0, 0, 0, 0, 0, 0, 0, '\r', '\n' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.072 -0400", hash_original_field = "199B6833958A1195ADC95B67243D2F6F", hash_generated_field = "67AC7536EB45CC65D4356C94551DF297")

    private OutputStream socketOut;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.072 -0400", hash_original_field = "D6C78BEC18E6C26B4EF715D6CA3D8598", hash_generated_field = "0770750E9DA495C2C14F0337E32B0F75")

    private int maxChunkLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.072 -0400", hash_original_field = "CD62C91F91B558516DA14670986E381F", hash_generated_field = "23546DAF85E308782CACA02F261440D5")

    private ByteArrayOutputStream bufferedChunk;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.073 -0400", hash_original_method = "B36B9312ECC7FB1AB37744B06B5B016C", hash_generated_method = "C3EA4EBC4FB1FF0DE80B4F438FCA04E4")
    public  ChunkedOutputStream(OutputStream socketOut, int maxChunkLength) {
        this.socketOut = socketOut;
        this.maxChunkLength = Math.max(1, dataLength(maxChunkLength));
        this.bufferedChunk = new ByteArrayOutputStream(maxChunkLength);
        // ---------- Original Method ----------
        //this.socketOut = socketOut;
        //this.maxChunkLength = Math.max(1, dataLength(maxChunkLength));
        //this.bufferedChunk = new ByteArrayOutputStream(maxChunkLength);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.073 -0400", hash_original_method = "4E0221343957C12C5A2A1CAE66CCC091", hash_generated_method = "7A21661DCB921487C31D22C35B7161E5")
    private int dataLength(int dataPlusHeaderLength) {
        addTaint(dataPlusHeaderLength);
        int headerLength = 4;
for(int i = dataPlusHeaderLength - headerLength;i > 0;i >>= 4)
        {
            headerLength++;
        } //End block
        int var7C5135D75AF4DE2B800035B834BA9249_388671258 = (dataPlusHeaderLength - headerLength);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1891514777 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1891514777;
        // ---------- Original Method ----------
        //int headerLength = 4;
        //for (int i = dataPlusHeaderLength - headerLength; i > 0; i >>= 4) {
            //headerLength++;
        //}
        //return dataPlusHeaderLength - headerLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.074 -0400", hash_original_method = "B30C627643BAEC8E45C685D7AFD0614D", hash_generated_method = "04267AF2DDC7DBAFF466735A5B6D2235")
    @Override
    public synchronized void write(byte[] buffer, int offset, int count) throws IOException {
        addTaint(count);
        addTaint(offset);
        addTaint(buffer[0]);
        checkNotClosed();
        Arrays.checkOffsetAndCount(buffer.length, offset, count);
        while
(count > 0)        
        {
            int numBytesWritten;
    if(bufferedChunk.size() > 0 || count < maxChunkLength)            
            {
                numBytesWritten = Math.min(count, maxChunkLength - bufferedChunk.size());
                bufferedChunk.write(buffer, offset, numBytesWritten);
    if(bufferedChunk.size() == maxChunkLength)                
                {
                    writeBufferedChunkToSocket();
                } //End block
            } //End block
            else
            {
                numBytesWritten = maxChunkLength;
                writeHex(numBytesWritten);
                socketOut.write(buffer, offset, numBytesWritten);
                socketOut.write(CRLF);
            } //End block
            offset += numBytesWritten;
            count -= numBytesWritten;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.075 -0400", hash_original_method = "3C05A9E8858284557710D8ECCDD07B35", hash_generated_method = "5A23DEAA87FAE43CC34B5FF4838A23CE")
    private void writeHex(int i) throws IOException {
        int cursor = 8;
        do {
            {
                hex[--cursor] = HEX_DIGITS[i & 0xf];
            } //End block
} while ((i >>>= 4) != 0);
        socketOut.write(hex, cursor, hex.length - cursor);
        // ---------- Original Method ----------
        //int cursor = 8;
        //do {
            //hex[--cursor] = HEX_DIGITS[i & 0xf];
        //} while ((i >>>= 4) != 0);
        //socketOut.write(hex, cursor, hex.length - cursor);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.075 -0400", hash_original_method = "2122C1B33A3B975810DFF4F0E39E0DD1", hash_generated_method = "87B38B1D73F667F1C1ECE6667444F550")
    @Override
    public synchronized void flush() throws IOException {
    if(closed)        
        {
            return;
        } //End block
        writeBufferedChunkToSocket();
        socketOut.flush();
        // ---------- Original Method ----------
        //if (closed) {
            //return; 
        //}
        //writeBufferedChunkToSocket();
        //socketOut.flush();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.076 -0400", hash_original_method = "319458C7344F8B27CFA895D3D7B87CF0", hash_generated_method = "549260384737FE78FE20A34EF4BAA109")
    @Override
    public synchronized void close() throws IOException {
    if(closed)        
        {
            return;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.076 -0400", hash_original_method = "8C406F82035B71C42CDC38D557C582DC", hash_generated_method = "D77B48CBF481BD8943B5E9C19561FADD")
    private void writeBufferedChunkToSocket() throws IOException {
        int size = bufferedChunk.size();
    if(size <= 0)        
        {
            return;
        } //End block
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.076 -0400", hash_original_field = "0FB2D7C7599E1278F6E31DD7106E77DB", hash_generated_field = "4B60FF730AF43EA9F22E2DB05173F202")

    private static final byte[] CRLF = { '\r', '\n' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.077 -0400", hash_original_field = "C98D21B8FAC7647D23DCEE3CC1EA43FE", hash_generated_field = "EB18653A9ADE81F629C5BABEB37A529C")

    private static final byte[] HEX_DIGITS = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.077 -0400", hash_original_field = "73F8B66F837608F735B93E40F96EE64F", hash_generated_field = "B2ADE567FCF6FB168F909D0DB6F26ABD")

    private static final byte[] FINAL_CHUNK = new byte[] { '0', '\r', '\n', '\r', '\n' };
}

