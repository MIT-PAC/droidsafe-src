package org.apache.http.impl.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.net.SocketTimeoutException;

import org.apache.http.params.HttpParams;




public class SocketInputBuffer extends AbstractSessionInputBuffer {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:22.469 -0500", hash_original_field = "5019B3EE05D6098E4ECE32F00F7F88CA", hash_generated_field = "8626E3C3C4BFCB66E8863775B28E01CC")


    private  Socket socket;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:22.470 -0500", hash_original_method = "7283DB9E346A36B4239C51041B32EE66", hash_generated_method = "589AA70F20F0C29C0CEDB39CA43959BC")
    public SocketInputBuffer(
            final Socket socket,
            int buffersize,
            final HttpParams params) throws IOException {
        super();
        if (socket == null) {
            throw new IllegalArgumentException("Socket may not be null");
        }
        this.socket = socket;
        // BEGIN android-changed
        // Workaround for http://b/3514259. We take 'buffersize' as a hint in
        // the weakest sense, and always use an 8KiB heap buffer and leave the
        // kernel buffer size alone, trusting the system to have set a
        // network-appropriate default.
        init(socket.getInputStream(), 8192, params);
        // END android-changed
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:22.471 -0500", hash_original_method = "311ACBA3C6B98FE9C535127054B24088", hash_generated_method = "A078C5AF499E827D5762FC0B5E1D7F31")
    public boolean isDataAvailable(int timeout) throws IOException {
        boolean result = hasBufferedData();
        if (!result) {
            int oldtimeout = this.socket.getSoTimeout();
            try {
                this.socket.setSoTimeout(timeout);
                fillBuffer();
                result = hasBufferedData();
            } catch (InterruptedIOException e) {
                if (!(e instanceof SocketTimeoutException)) {
                    throw e;
                }
            } finally {
                socket.setSoTimeout(oldtimeout);
            }
        }
        return result;
    }    
        
    // BEGIN android-added
    /**
     * Returns true if the connection is probably functional. It's insufficient
     * to rely on isDataAvailable() returning normally; that approach cannot
     * distinguish between an exhausted stream and a stream with zero bytes
     * buffered.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:22.471 -0500", hash_original_method = "60456E7A862D179906482739ACBD4572", hash_generated_method = "1FED05F39E3BB61C72DF3B048AB4D949")
    public boolean isStale() throws IOException {
        if (hasBufferedData()) {
            return false;
        }
        int oldTimeout = this.socket.getSoTimeout();
        try {
            this.socket.setSoTimeout(1);
            return fillBuffer() == -1;
        } catch (SocketTimeoutException e) {
            return false; // the connection is not stale; hooray
        } catch (IOException e) {
            return true; // the connection is stale, the read or soTimeout failed.
        } finally {
            this.socket.setSoTimeout(oldTimeout);
        }
    }

    
}

