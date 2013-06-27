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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.454 -0400", hash_original_field = "199B6833958A1195ADC95B67243D2F6F", hash_generated_field = "67AC7536EB45CC65D4356C94551DF297")

    private OutputStream socketOut;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.454 -0400", hash_original_field = "4ADE3A97C5FA51FD77AF1423B6FF76A1", hash_generated_field = "ECAE5742BF4A68ADC431E811786D5F2D")

    private int bytesRemaining;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.454 -0400", hash_original_method = "CD6D5F7765163EE89DC0FFBAC0DC51D9", hash_generated_method = "12B9AE81D736BC49DD2838960DD2FDBF")
    public  FixedLengthOutputStream(OutputStream socketOut, int bytesRemaining) {
        this.socketOut = socketOut;
        this.bytesRemaining = bytesRemaining;
        // ---------- Original Method ----------
        //this.socketOut = socketOut;
        //this.bytesRemaining = bytesRemaining;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.455 -0400", hash_original_method = "954563C6DA4D081D04FBFCB6C3DCBDF3", hash_generated_method = "3F7D3C53F861B6117A40A51DDBDBE677")
    @Override
    public void write(byte[] buffer, int offset, int count) throws IOException {
        checkNotClosed();
        Arrays.checkOffsetAndCount(buffer.length, offset, count);
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("expected " + bytesRemaining + " bytes but received " + count);
        } //End block
        socketOut.write(buffer, offset, count);
        bytesRemaining -= count;
        addTaint(buffer[0]);
        addTaint(offset);
        // ---------- Original Method ----------
        //checkNotClosed();
        //Arrays.checkOffsetAndCount(buffer.length, offset, count);
        //if (count > bytesRemaining) {
            //throw new IOException("expected " + bytesRemaining + " bytes but received " + count);
        //}
        //socketOut.write(buffer, offset, count);
        //bytesRemaining -= count;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.456 -0400", hash_original_method = "5CB5A053EE4A231C6D0A0D598E9BEDBB", hash_generated_method = "282F73A2D581CA790CBC32B2052C7F72")
    @Override
    public void flush() throws IOException {
        socketOut.flush();
        // ---------- Original Method ----------
        //if (closed) {
            //return; 
        //}
        //socketOut.flush();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.456 -0400", hash_original_method = "FCB6BF5DC7C6AA8912495FC6DAF3D35C", hash_generated_method = "ECF0EB4A98E0F2E8B7857344CADB6CEE")
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

