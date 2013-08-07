package libcore.net.http;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;




final class FixedLengthOutputStream extends AbstractHttpOutputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.963 -0400", hash_original_field = "199B6833958A1195ADC95B67243D2F6F", hash_generated_field = "67AC7536EB45CC65D4356C94551DF297")

    private OutputStream socketOut;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.963 -0400", hash_original_field = "4ADE3A97C5FA51FD77AF1423B6FF76A1", hash_generated_field = "ECAE5742BF4A68ADC431E811786D5F2D")

    private int bytesRemaining;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.964 -0400", hash_original_method = "CD6D5F7765163EE89DC0FFBAC0DC51D9", hash_generated_method = "12B9AE81D736BC49DD2838960DD2FDBF")
    public  FixedLengthOutputStream(OutputStream socketOut, int bytesRemaining) {
        this.socketOut = socketOut;
        this.bytesRemaining = bytesRemaining;
        // ---------- Original Method ----------
        //this.socketOut = socketOut;
        //this.bytesRemaining = bytesRemaining;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.964 -0400", hash_original_method = "954563C6DA4D081D04FBFCB6C3DCBDF3", hash_generated_method = "4604FA0B161A6A08D6A4355698E79E98")
    @Override
    public void write(byte[] buffer, int offset, int count) throws IOException {
        addTaint(offset);
        addTaint(buffer[0]);
        checkNotClosed();
        Arrays.checkOffsetAndCount(buffer.length, offset, count);
        if(count > bytesRemaining)        
        {
            IOException var2DACCE4C8DC02104E58E6118E7861F55_743798418 = new IOException("expected " + bytesRemaining + " bytes but received " + count);
            var2DACCE4C8DC02104E58E6118E7861F55_743798418.addTaint(taint);
            throw var2DACCE4C8DC02104E58E6118E7861F55_743798418;
        } //End block
        socketOut.write(buffer, offset, count);
        bytesRemaining -= count;
        // ---------- Original Method ----------
        //checkNotClosed();
        //Arrays.checkOffsetAndCount(buffer.length, offset, count);
        //if (count > bytesRemaining) {
            //throw new IOException("expected " + bytesRemaining + " bytes but received " + count);
        //}
        //socketOut.write(buffer, offset, count);
        //bytesRemaining -= count;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.965 -0400", hash_original_method = "5CB5A053EE4A231C6D0A0D598E9BEDBB", hash_generated_method = "85F7C1D8E1E60A94D3ABAE25C920B2F6")
    @Override
    public void flush() throws IOException {
        if(closed)        
        {
            return;
        } //End block
        socketOut.flush();
        // ---------- Original Method ----------
        //if (closed) {
            //return; 
        //}
        //socketOut.flush();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.965 -0400", hash_original_method = "FCB6BF5DC7C6AA8912495FC6DAF3D35C", hash_generated_method = "AE7EA14CB9E1773F9CEA0C7D001C0791")
    @Override
    public void close() throws IOException {
        if(closed)        
        {
            return;
        } //End block
        closed = true;
        if(bytesRemaining > 0)        
        {
            IOException var9FCEBBA092763F5F75BC70A376D097E6_1290602341 = new IOException("unexpected end of stream");
            var9FCEBBA092763F5F75BC70A376D097E6_1290602341.addTaint(taint);
            throw var9FCEBBA092763F5F75BC70A376D097E6_1290602341;
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

