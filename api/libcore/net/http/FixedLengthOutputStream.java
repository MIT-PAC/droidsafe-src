package libcore.net.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

final class FixedLengthOutputStream extends AbstractHttpOutputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.088 -0400", hash_original_field = "199B6833958A1195ADC95B67243D2F6F", hash_generated_field = "67AC7536EB45CC65D4356C94551DF297")

    private OutputStream socketOut;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.088 -0400", hash_original_field = "4ADE3A97C5FA51FD77AF1423B6FF76A1", hash_generated_field = "ECAE5742BF4A68ADC431E811786D5F2D")

    private int bytesRemaining;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.089 -0400", hash_original_method = "CD6D5F7765163EE89DC0FFBAC0DC51D9", hash_generated_method = "12B9AE81D736BC49DD2838960DD2FDBF")
    public  FixedLengthOutputStream(OutputStream socketOut, int bytesRemaining) {
        this.socketOut = socketOut;
        this.bytesRemaining = bytesRemaining;
        // ---------- Original Method ----------
        //this.socketOut = socketOut;
        //this.bytesRemaining = bytesRemaining;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.089 -0400", hash_original_method = "954563C6DA4D081D04FBFCB6C3DCBDF3", hash_generated_method = "F2E8BC8AE63F4810A6A1B4DE04A811E8")
    @Override
    public void write(byte[] buffer, int offset, int count) throws IOException {
        addTaint(offset);
        addTaint(buffer[0]);
        checkNotClosed();
        Arrays.checkOffsetAndCount(buffer.length, offset, count);
    if(count > bytesRemaining)        
        {
            IOException var2DACCE4C8DC02104E58E6118E7861F55_462106071 = new IOException("expected " + bytesRemaining + " bytes but received " + count);
            var2DACCE4C8DC02104E58E6118E7861F55_462106071.addTaint(taint);
            throw var2DACCE4C8DC02104E58E6118E7861F55_462106071;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.090 -0400", hash_original_method = "5CB5A053EE4A231C6D0A0D598E9BEDBB", hash_generated_method = "85F7C1D8E1E60A94D3ABAE25C920B2F6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.090 -0400", hash_original_method = "FCB6BF5DC7C6AA8912495FC6DAF3D35C", hash_generated_method = "F9C736D3087D107D0E54E7F41EE97C6F")
    @Override
    public void close() throws IOException {
    if(closed)        
        {
            return;
        } //End block
        closed = true;
    if(bytesRemaining > 0)        
        {
            IOException var9FCEBBA092763F5F75BC70A376D097E6_1402201323 = new IOException("unexpected end of stream");
            var9FCEBBA092763F5F75BC70A376D097E6_1402201323.addTaint(taint);
            throw var9FCEBBA092763F5F75BC70A376D097E6_1402201323;
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

