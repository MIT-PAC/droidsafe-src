package libcore.net.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.InputStream;
import java.net.CacheRequest;
import java.util.Arrays;

final class FixedLengthInputStream extends AbstractHttpInputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.443 -0400", hash_original_field = "4ADE3A97C5FA51FD77AF1423B6FF76A1", hash_generated_field = "ECAE5742BF4A68ADC431E811786D5F2D")

    private int bytesRemaining;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.443 -0400", hash_original_method = "049E0503B3705DE79405E1FD5D2A2E5D", hash_generated_method = "2C5FEE2E65BF573A1B2E71A9F5F6C707")
    public  FixedLengthInputStream(InputStream is, CacheRequest cacheRequest,
            HttpEngine httpEngine, int length) throws IOException {
        super(is, httpEngine, cacheRequest);
        bytesRemaining = length;
        {
            endOfInput(true);
        } //End block
        addTaint(is.getTaint());
        addTaint(cacheRequest.getTaint());
        addTaint(httpEngine.getTaint());
        // ---------- Original Method ----------
        //bytesRemaining = length;
        //if (bytesRemaining == 0) {
            //endOfInput(true);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.451 -0400", hash_original_method = "5B284B9FC407E028AC176D716362F3C7", hash_generated_method = "C71877D49BA2D7B519A51958C0BF2949")
    @Override
    public int read(byte[] buffer, int offset, int count) throws IOException {
        Arrays.checkOffsetAndCount(buffer.length, offset, count);
        checkNotClosed();
        int read;
        read = in.read(buffer, offset, Math.min(count, bytesRemaining));
        {
            unexpectedEndOfInput();
            if (DroidSafeAndroidRuntime.control) throw new IOException("unexpected end of stream");
        } //End block
        bytesRemaining -= read;
        cacheWrite(buffer, offset, read);
        {
            endOfInput(true);
        } //End block
        addTaint(buffer[0]);
        addTaint(offset);
        addTaint(count);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_666757436 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_666757436;
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(buffer.length, offset, count);
        //checkNotClosed();
        //if (bytesRemaining == 0) {
            //return -1;
        //}
        //int read = in.read(buffer, offset, Math.min(count, bytesRemaining));
        //if (read == -1) {
            //unexpectedEndOfInput(); 
            //throw new IOException("unexpected end of stream");
        //}
        //bytesRemaining -= read;
        //cacheWrite(buffer, offset, read);
        //if (bytesRemaining == 0) {
            //endOfInput(true);
        //}
        //return read;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.471 -0400", hash_original_method = "7AFD793A00CEC972BF0DC212CD2F3F7C", hash_generated_method = "866FF5B8D5BF971FFE5CEEEA84CE0340")
    @Override
    public int available() throws IOException {
        checkNotClosed();
        {
            Object var3CE0421F6D96B320C60C2CEBF05AFFDB_574115251 = (Math.min(in.available(), bytesRemaining));
        } //End flattened ternary
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_656434207 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_656434207;
        // ---------- Original Method ----------
        //checkNotClosed();
        //return bytesRemaining == 0 ? 0 : Math.min(in.available(), bytesRemaining);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.472 -0400", hash_original_method = "D3AA3AF2615FFDD211E9642D1EBA797E", hash_generated_method = "DBF8E6E46A11917EE7CBF4BCF2B83E35")
    @Override
    public void close() throws IOException {
        closed = true;
        {
            unexpectedEndOfInput();
        } //End block
        // ---------- Original Method ----------
        //if (closed) {
            //return;
        //}
        //closed = true;
        //if (bytesRemaining != 0) {
            //unexpectedEndOfInput();
        //}
    }

    
}

