package libcore.net.http;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.CacheRequest;
import java.util.Arrays;






final class FixedLengthInputStream extends AbstractHttpInputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.390 -0500", hash_original_field = "85E14E76D885CFD0C41B5E514C78B157", hash_generated_field = "ECAE5742BF4A68ADC431E811786D5F2D")

    private int bytesRemaining;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.391 -0500", hash_original_method = "049E0503B3705DE79405E1FD5D2A2E5D", hash_generated_method = "2865748CFF0E77743A85D7999CAA3463")
    public FixedLengthInputStream(InputStream is, CacheRequest cacheRequest,
            HttpEngine httpEngine, int length) throws IOException {
        super(is, httpEngine, cacheRequest);
        bytesRemaining = length;
        if (bytesRemaining == 0) {
            endOfInput(true);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.392 -0500", hash_original_method = "5B284B9FC407E028AC176D716362F3C7", hash_generated_method = "CE6C6291522C34C8FBC42B445E42AA67")
    @Override
public int read(byte[] buffer, int offset, int count) throws IOException {
        Arrays.checkOffsetAndCount(buffer.length, offset, count);
        checkNotClosed();
        if (bytesRemaining == 0) {
            return -1;
        }
        int read = in.read(buffer, offset, Math.min(count, bytesRemaining));
        if (read == -1) {
            unexpectedEndOfInput(); // the server didn't supply the promised content length
            throw new IOException("unexpected end of stream");
        }
        bytesRemaining -= read;
        cacheWrite(buffer, offset, read);
        if (bytesRemaining == 0) {
            endOfInput(true);
        }
        return read;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.393 -0500", hash_original_method = "7AFD793A00CEC972BF0DC212CD2F3F7C", hash_generated_method = "A6DF3D5156AB0C395F5392D7373836BD")
    @Override
public int available() throws IOException {
        checkNotClosed();
        return bytesRemaining == 0 ? 0 : Math.min(in.available(), bytesRemaining);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.394 -0500", hash_original_method = "D3AA3AF2615FFDD211E9642D1EBA797E", hash_generated_method = "768FDB1E6D57C7631928CDD6A6DF191F")
    @Override
public void close() throws IOException {
        if (closed) {
            return;
        }
        closed = true;
        if (bytesRemaining != 0) {
            unexpectedEndOfInput();
        }
    }

    
}

