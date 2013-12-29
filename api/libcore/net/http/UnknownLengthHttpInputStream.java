package libcore.net.http;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.CacheRequest;
import java.util.Arrays;




final class UnknownLengthHttpInputStream extends AbstractHttpInputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.331 -0500", hash_original_field = "7C8ED02256EE7A13CC64F8BE47E22974", hash_generated_field = "A47BA202024AEED5382C6DACAC7B8715")

    private boolean inputExhausted;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.332 -0500", hash_original_method = "03287555569090C6D887554C44738812", hash_generated_method = "03287555569090C6D887554C44738812")
    UnknownLengthHttpInputStream(InputStream is, CacheRequest cacheRequest,
            HttpEngine httpEngine) throws IOException {
        super(is, httpEngine, cacheRequest);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.333 -0500", hash_original_method = "E2336783F7D37948479E1E76BEFE0EF2", hash_generated_method = "60867053817CC2934DD47C29AA0D185D")
    @Override
public int read(byte[] buffer, int offset, int count) throws IOException {
        Arrays.checkOffsetAndCount(buffer.length, offset, count);
        checkNotClosed();
        if (in == null || inputExhausted) {
            return -1;
        }
        int read = in.read(buffer, offset, count);
        if (read == -1) {
            inputExhausted = true;
            endOfInput(false);
            return -1;
        }
        cacheWrite(buffer, offset, read);
        return read;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.334 -0500", hash_original_method = "10BF8275103D8B9D888D9077AFBF2526", hash_generated_method = "4B5A7EDE8E8172FFEB7CB29CB95E1A05")
    @Override
public int available() throws IOException {
        checkNotClosed();
        return in == null ? 0 : in.available();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.336 -0500", hash_original_method = "EFD48677D2EFEA5B0824ED8113A97C5A", hash_generated_method = "1F08B95B8160B2DAB74AFA7EBD977F9A")
    @Override
public void close() throws IOException {
        if (closed) {
            return;
        }
        closed = true;
        if (!inputExhausted) {
            unexpectedEndOfInput();
        }
    }

    
}

