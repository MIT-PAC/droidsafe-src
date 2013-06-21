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
    private int bytesRemaining;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.074 -0400", hash_original_method = "049E0503B3705DE79405E1FD5D2A2E5D", hash_generated_method = "9E33E5173F435B239AD71F3D35562C68")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FixedLengthInputStream(InputStream is, CacheRequest cacheRequest,
            HttpEngine httpEngine, int length) throws IOException {
        super(is, httpEngine, cacheRequest);
        dsTaint.addTaint(cacheRequest.dsTaint);
        dsTaint.addTaint(is.dsTaint);
        dsTaint.addTaint(httpEngine.dsTaint);
        dsTaint.addTaint(length);
        {
            endOfInput(true);
        } //End block
        // ---------- Original Method ----------
        //bytesRemaining = length;
        //if (bytesRemaining == 0) {
            //endOfInput(true);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.075 -0400", hash_original_method = "5B284B9FC407E028AC176D716362F3C7", hash_generated_method = "7FFFD1DF9828659E9CE666BD79B94D5D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int read(byte[] buffer, int offset, int count) throws IOException {
        dsTaint.addTaint(buffer[0]);
        dsTaint.addTaint(count);
        dsTaint.addTaint(offset);
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
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.075 -0400", hash_original_method = "7AFD793A00CEC972BF0DC212CD2F3F7C", hash_generated_method = "5283C3387E4C2C79819EBBFD69FE0099")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int available() throws IOException {
        checkNotClosed();
        {
            Object var3CE0421F6D96B320C60C2CEBF05AFFDB_1440377673 = (Math.min(in.available(), bytesRemaining));
        } //End flattened ternary
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkNotClosed();
        //return bytesRemaining == 0 ? 0 : Math.min(in.available(), bytesRemaining);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.075 -0400", hash_original_method = "D3AA3AF2615FFDD211E9642D1EBA797E", hash_generated_method = "DBF8E6E46A11917EE7CBF4BCF2B83E35")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

