package libcore.net.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

final class FixedLengthOutputStream extends AbstractHttpOutputStream {
    private OutputStream socketOut;
    private int bytesRemaining;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.077 -0400", hash_original_method = "CD6D5F7765163EE89DC0FFBAC0DC51D9", hash_generated_method = "FC13434DC9EB57389FDB483421595733")
    @DSModeled(DSC.SAFE)
    public FixedLengthOutputStream(OutputStream socketOut, int bytesRemaining) {
        dsTaint.addTaint(bytesRemaining);
        dsTaint.addTaint(socketOut.dsTaint);
        // ---------- Original Method ----------
        //this.socketOut = socketOut;
        //this.bytesRemaining = bytesRemaining;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.077 -0400", hash_original_method = "954563C6DA4D081D04FBFCB6C3DCBDF3", hash_generated_method = "88794E4F48E584D1BD08AC4B2ECE51F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void write(byte[] buffer, int offset, int count) throws IOException {
        dsTaint.addTaint(buffer[0]);
        dsTaint.addTaint(count);
        dsTaint.addTaint(offset);
        checkNotClosed();
        Arrays.checkOffsetAndCount(buffer.length, offset, count);
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("expected " + bytesRemaining + " bytes but received " + count);
        } //End block
        socketOut.write(buffer, offset, count);
        // ---------- Original Method ----------
        //checkNotClosed();
        //Arrays.checkOffsetAndCount(buffer.length, offset, count);
        //if (count > bytesRemaining) {
            //throw new IOException("expected " + bytesRemaining + " bytes but received " + count);
        //}
        //socketOut.write(buffer, offset, count);
        //bytesRemaining -= count;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.077 -0400", hash_original_method = "5CB5A053EE4A231C6D0A0D598E9BEDBB", hash_generated_method = "282F73A2D581CA790CBC32B2052C7F72")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void flush() throws IOException {
        socketOut.flush();
        // ---------- Original Method ----------
        //if (closed) {
            //return; 
        //}
        //socketOut.flush();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.077 -0400", hash_original_method = "FCB6BF5DC7C6AA8912495FC6DAF3D35C", hash_generated_method = "ECF0EB4A98E0F2E8B7857344CADB6CEE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void close() throws IOException {
        closed = true;
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("unexpected end of stream");
        } //End block
        // ---------- Original Method ----------
        //if (closed) {
            //return;
        //}
        //closed = true;
        //if (bytesRemaining > 0) {
            //throw new IOException("unexpected end of stream");
        //}
    }

    
}

